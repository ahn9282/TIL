package example.springbatch.batch;

import example.springbatch.batch.custom.CustomSkipPolicy;
import example.springbatch.entity.AfterEntity;
import example.springbatch.entity.BeforeEntity;
import example.springbatch.repository.AfterRepository;
import example.springbatch.repository.BeforeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.skip.SkipPolicy;
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
@RequiredArgsConstructor
public class FifthBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final BeforeRepository beforeRepository;
    private final AfterRepository afterRepository;
    private CustomSkipPolicy customSkipPolicy;


    @Bean
    public Job fifthJob(){

        return new JobBuilder("fifthJob", jobRepository)
                .start(fifthStep())
                .build();
    }

    //Customizing(skip) Step method()
    @Bean
    public Step fifthStep(){
        return new StepBuilder("fifthStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant() //잘못이 생길 경우 처리하도록
                .skip(Exception.class) // 해당 class의 예외 발생시 skip
                .noSkip(FileNotFoundException.class)//noskip 설정
                .noSkip(IOException.class)
                .skipLimit(10)//10번까지는 예외를 허용한다.
                .build();
    }


    //config skip policy Step Bean
    @Bean
    public Step fifthStepWithSkipPolicy(){
        return new StepBuilder("fifthStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant() //잘못이 생길 경우 처리하도록
                .skipPolicy(customSkipPolicy) //skipPolicy 구현체의 shouldSkip 메서드 내에서 로직을 짜 true를 반환할 경우 예외를 skip하도록 가능
                .noSkip(FileNotFoundException.class)//noskip 설정
                .noSkip(IOException.class)
                .skipLimit(10)//10번까지는 예외를 허용한다.
                .build();
    }


    //config Retry Step Bean - Step 과정 중 예외가 발생 시 특정 횟수까지는 반복할 수 있도록 설정하는 방법
    @Bean
    public Step fifthStepRetry(){
        return new StepBuilder("fifthStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReader())
                .processor(middleProcessor())
                .writer(afterWriter())
                .faultTolerant() //잘못이 생길 경우 처리하도록
                .retryLimit(3)
                .retry(SQLException.class)//retry 또는 noRetry 메서드 파라미터롤 예외 클래스들을 넣으면 retry 예외 여부 설정가능
                .retry(IOException.class)
                .noRetry(FileNotFoundException.class)
                .listener(stepExecutionListener()) //stepListener Bean을 넣어 Listener 설정
                .build();
    }

    //stepListener : Step 실행 전후에 특정 작업을 수행 시킬 수 있는 방법
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
}
