package example.springbatch.batch;

import example.springbatch.entity.AfterEntity;
import example.springbatch.repository.AfterRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.aspectj.lang.annotation.After;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class ThirdBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;
    private final AfterRepository afterRepository;

    @Bean
    public Job thirdjob() {

        System.out.println("thirdJob");

        return new JobBuilder("thirdJob", jobRepository)
                .start(thirdStep())
                .build();
    }

    @Bean
    public Step thirdStep(){
        return new StepBuilder("thirdStep", jobRepository)
                .<Row, AfterEntity>chunk(10, platformTransactionManager)
                .reader(excelReader())
                .processor(thirdProcessor())
                .writer(thirdAfterWriter())
                .build();

    }

    @Bean
    public ItemStreamReader excelReader(){

        try{
            return new ExcelReader("C:\\study_Dev\\TIL\\spring_batch\\springbatch\\src\\main\\resources\\batch_ex.xlsx");
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Bean
    public ItemProcessor<Row, AfterEntity> thirdProcessor() {
        return new ItemProcessor<Row, AfterEntity>() {
            @Override
            public AfterEntity process(Row item) throws Exception {
                AfterEntity afterEntity = new AfterEntity();
                afterEntity.setUsername(item.getCell(0).getStringCellValue());

                return afterEntity;
            }
        };

    }

    @Bean
    public RepositoryItemWriter<AfterEntity> thirdAfterWriter(){

        return new RepositoryItemWriterBuilder<AfterEntity>()
                .repository(afterRepository)
                .methodName("save")
                .build();
    }
}
