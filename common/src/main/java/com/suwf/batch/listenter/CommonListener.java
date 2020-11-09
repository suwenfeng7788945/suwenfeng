package com.suwf.batch.listenter;

import org.springframework.batch.core.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CommonListener implements JobExecutionListener, StepExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("before job");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("after job");
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("before step");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println(stepExecution.getStepName() + stepExecution.getExitStatus() +
                System.currentTimeMillis());
        return stepExecution.getExitStatus();
    }
}
