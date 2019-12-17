
/******************************************************
 * Unpublished confidential information of Computer Sciences Corporation. Do not disclose.<br>
 * Copyright (c) Computer Sciences Corporation 2010 to present.<br>
 * All rights reserved.
 ******************************************************/

package com.csc.batch;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

/**
 * @author Jinhai (Max) Wang
 * @version 18 Dec 2019
 */
public class MyCommandLineJobRunner {

	public static void main(final String[] args) throws Exception {
		CommandLineJobRunner.main(new String[] {TestJob1Configuration.class.getName(), "testJob1"});
	}

}
