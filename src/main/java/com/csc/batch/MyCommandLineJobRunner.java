package com.csc.batch;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

public class MyCommandLineJobRunner {

	public static void main(final String[] args) throws Exception {
		CommandLineJobRunner.main(new String[] {TestJob1Configuration.class.getName(), "testJob1"});
	}

}
