package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SchedulerJob implements Job {
	public void execute(JobExecutionContext context)
		throws JobExecutionException {

		System.out.println("Struts 2 + Quartz 2");

	}
}