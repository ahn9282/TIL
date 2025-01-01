package example.springbatch.batch;

import example.springbatch.batch.custom.CustomBeforeRowMapper;
import example.springbatch.entity.AfterEntity;
import example.springbatch.entity.BeforeEntity;
import example.springbatch.repository.AfterRepository;
import example.springbatch.repository.BeforeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class SevenBatch {

    private final JobRepository jobRepository;
    private final PlatformTransactionManager platformTransactionManager;

    private final BeforeRepository beforeRepository;
    private final AfterRepository afterRepository;
    private final DataSource dataSource;



    @Bean("firstJob")
    public Job firstJob(){
        return new JobBuilder("firstJob", jobRepository)
                .start(firstStep())
                .build();
    }

    @Bean
    public Step firstStep(){
        System.out.println("first step");

        return new StepBuilder("firstStep", jobRepository)
                .<BeforeEntity, AfterEntity>chunk(10, platformTransactionManager)
                .reader(beforeReaderJdbc())
                .processor(middleProcessor())
                .writer(afterWriterJdbc())
                .build();
    }

    @Bean
    public RepositoryItemReader<BeforeEntity> beforeReaderJpa(){
        return new RepositoryItemReaderBuilder<BeforeEntity>()
                .name("beforeReader")
                .pageSize(10)
                .methodName("findAll")
                .repository(beforeRepository)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();
    }
    @Bean
    public JdbcPagingItemReader<BeforeEntity> beforeReaderJdbc(){
        return new JdbcPagingItemReaderBuilder<BeforeEntity>()
                .name("beforeReader")
                .dataSource(dataSource)
                .selectClause("SELECT id, username")
                .fromClause("FROM BeforeEntity")
                .sortKeys(Map.of("id", Order.ASCENDING))
                .rowMapper(new CustomBeforeRowMapper())
                .pageSize(10)
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
    public JdbcBatchItemWriter<AfterEntity> afterWriterJdbc(){
        String sql = "INSERT INTO AfterEntity (username) VALUES (:username)";
        return new JdbcBatchItemWriterBuilder<AfterEntity>()
                .dataSource(dataSource)
                .sql(sql)
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .build();
    }
}
