
/******************************************************
 * Unpublished confidential information of Computer Sciences Corporation. Do not disclose.<br>
 * Copyright (c) Computer Sciences Corporation 2010 to present.<br>
 * All rights reserved.
 ******************************************************/

package com.csc.batch;

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
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jinhai (Max) Wang
 * @version 12 Dec 2019
 */
@Configuration
@EnableAutoConfiguration
@EnableBatchProcessing
@EnableTask
public class TestJob1Configuration {
	
	@Autowired
	protected JobBuilderFactory jobBuilderFactory;

	@Autowired
	protected StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job testJob1() {
		return jobBuilderFactory.get("TESTJOB1").start(step1()).build();
	}

	/**
	 * @return
	 */
	@Bean
	protected Step step1() {
		return stepBuilderFactory.get("TESTJOB1.STEP1").tasklet(new Tasklet() {
			@Override
			public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
				System.out.println(TestJob1Configuration.class + " is executed");
				return RepeatStatus.FINISHED;
			}
		}).build();
	}

}
