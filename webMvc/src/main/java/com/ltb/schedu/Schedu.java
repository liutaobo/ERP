package com.ltb.schedu;

import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
@Component
public class Schedu implements SchedulingConfigurer  {
	public void test(){
		System.out.println(System.currentTimeMillis());
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
	}

	
}
