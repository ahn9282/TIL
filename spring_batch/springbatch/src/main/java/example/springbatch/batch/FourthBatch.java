package example.springbatch.batch;

import example.springbatch.entity.BeforeEntity;
import example.springbatch.repository.BeforeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class FourthBatch {
    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final BeforeRepository beforeRepository;


    @Bean
    public Job fourthJob(){
        System.out.println("fourth Job");

        return new JobBuilder("fourthJob", jobRepository)
                .start(fourthStep())
                .build();
    }

    @Bean
    public Step fourthStep() {

        System.out.println("fourth Step");

        return new StepBuilder("fourthStep", jobRepository)
                .<BeforeEntity, BeforeEntity>chunk(10, platformTransactionManager)
                .reader(fourthBeforeReader())
                .processor(fourthProcessor())
                .writer(excelWriter())
                .build();

    }

    @Bean
    public RepositoryItemReader<BeforeEntity> fourthBeforeReader() {

        RepositoryItemReader<BeforeEntity> reader = new RepositoryItemReaderBuilder<BeforeEntity>()
                .name("beforeReader")
                .pageSize(10)
                .methodName("findAll")
                .repository(beforeRepository)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();

        reader.setSaveState(false);

        return reader;
    }

    @Bean
    public ItemProcessor<BeforeEntity, BeforeEntity> fourthProcessor(){
        return item -> item;
    }

    @Bean
    public ItemStreamWriter<BeforeEntity> excelWriter(){
        try{
            return new ExcelRowWriter("C:\\study_Dev\\TIL\\spring_batch\\springbatch\\src\\main\\resources\\batch_ex_result.xlsx");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }


}
