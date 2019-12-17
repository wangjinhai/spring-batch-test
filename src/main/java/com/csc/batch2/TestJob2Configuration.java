package com.csc.batch2;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@EnableTask
public class TestJob2Configuration {
	
	@Autowired
	protected JobBuilderFactory jobBuilderFactory;

	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job testJob() {
		return jobBuilderFactory.get("TESTJOB2").start(step1()).build();
	}

	/**
	 * @return
	 */
	@Bean
	protected Step step1() {
		return stepBuilderFactory.get("TESTJOB2.STEP1").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
				System.out.println(TestJob2Configuration.class + " is executed");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

}
