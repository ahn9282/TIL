package example.springbatch.batch;

import example.springbatch.batch.custom.CustomSkipPolicy;
import example.springbatch.entity.AfterEntity;
import example.springbatch.entity.BeforeEntity;
import example.springbatch.repository.AfterRepository;
import example.springbatch.repository.BeforeRepository;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Configuration
public class SixBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final BeforeRepository beforeRepository;
    private final AfterRepository afterRepository;
    private CustomSkipPolicy customSkipPolicy;

    public SixBatch(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager,
                    BeforeRepository beforeRepository, AfterRepository afterRepository) {

        this.jobRepository = jobRepository;
        this.platformTransactionManager = platformTransactionManager;
        this.beforeRepository = beforeRepository;
        this.afterRepository = afterRepository;
    }

    @Bean("sixJob")
    public Job sixJob(){
        //step을 연달아서 실행되도록 할 수 있다. 그러나 어느 step에서 막힌다면 뒤 step들도 실행되지 않는다. -> 연쇄 패턴(Chain of Responsibility Pattern)
        return new JobBuilder("sixJob", jobRepository)
                .start(sixStep())
                .next(sixStepWithSkipPolicy())
                .next(sixStepRetry())
                .build();
    }

    @Bean("sixJob_2")
    public Job sixJob_2(JobRepository jobRepository, Step stepA, Step stepB, Step stepC, Step stepD){
        return new JobBuilder("customJobSuccessOrFail", jobRepository)
                .start(stepA)
                .listener(jobExecutionListener())
                .on("*").to(stepB) // .on(*) 모든 경우에서 .to() 내에 Step으로 이어서
                .from(stepA).on("FAILED").to(stepC) //stepA에서 실패일 경우 .to() 내 step으로 실행
                .from(stepA).on("COMPLETED").to(stepD) //stepA에서 성공 시 .to() 내 step으로 실행
                .end()
                .build();
    }

    @Bean
    JobExecutionListener jobExecutionListener(){

        return new JobExecutionListener() {

            @Override
            public void beforeJob(JobExecution jobExecution){
                JobExecutionListener.super.beforeJob(jobExecution);
            }

            @Override
            public void afterJob(JobExecution jobExecution){
                JobExecutionListener.super.afterJob(jobExecution);
            }
        };
    }


    @Bean
    public RepositoryItemReader<BeforeEntity> beforeReader(){
        return new RepositoryItemReaderBuilder<BeforeEntity>()
                .name("beforeReader")
                .pageSize(10)
                .methodName("findAll")
                .repository(beforeRepository)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();
    }

    @Bean public ItemProcessor<BeforeEntity, AfterEntity> middleProcessor(){
        return new ItemProcessor<BeforeEntity, AfterEntity>() {

            @Override
            public AfterEntity process(BeforeEntity item) throws Exception {
                AfterEntity afterEntity = new AfterEntity();
                afterEntity.setUsername(item.getUsername());

                return afterEntity;
            }
        };
    }

    @Bean
    public RepositoryItemWriter<AfterEntity> afterWriter(){
        return new RepositoryItemWriterBuilder<AfterEntity>()
                .repository(afterRepository)
                .methodName("save")
                .build();
    }


    @Bean
    public Step sixStep(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skip(Exception.class)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }


    @Bean
    public Step sixStepWithSkipPolicy(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skipPolicy(customSkipPolicy)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }


    @Bean
    public Step sixStepRetry(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .retryLimit(3)
                .retry(SQLException.class)
                .retry(IOException.class)
                .noRetry(FileNotFoundException.class)
                .listener(stepExecutionListener())
                .build();
    }

    @Bean
    public Step stepD(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skip(Exception.class)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }
    @Bean
    public Step stepC(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skip(Exception.class)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }
    @Bean
    public Step stepB(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skip(Exception.class)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }
    @Bean
    public Step stepA(){
        return new StepBuilder("sixStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant()
                .skip(Exception.class)
                .noSkip(FileNotFoundException.class)
                .noSkip(IOException.class)
                .skipLimit(10)
                .build();
    }

    @Bean
    public StepExecutionListener stepExecutionListener(){

        return new StepExecutionListener(){
            @Override
            public void beforeStep(StepExecution stepExecution){
                StepExecutionListener.super.beforeStep(stepExecution);
            }

            @Override
            public ExitStatus afterStep(StepExecution stepExecution){
                return StepExecutionListener.super.afterStep(stepExecution);
            }
        };
    }

}
