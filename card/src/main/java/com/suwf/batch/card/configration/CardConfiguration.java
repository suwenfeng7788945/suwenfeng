package com.suwf.batch.card.configration;

import com.suwf.batch.constants.BatchConstants;
import com.suwf.batch.listenter.CommonItemProcessListener;
import com.suwf.batch.listenter.CommonItemWriterListener;
import com.suwf.batch.listenter.CommonListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class CardConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private CommonListener commonListener;
    @Autowired
    private CommonItemProcessListener commonItemProcessListener;
    @Autowired
    private CommonItemWriterListener commonItemWriterListener;

    @Bean
    public Job cardJob() {
        System.out.println("card job");
        return jobBuilderFactory.get("cardJob")
                .start(cardStep())
                .listener(commonListener)
                .build();
    }

    @Bean
    public Step cardStep() {
        return stepBuilderFactory.get("cardStep")
                .chunk(BatchConstants.CHUNK_SIZE)
                .reader()
                .build();
    }
}
