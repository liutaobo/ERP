package com.ltb.asynch;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class AsynchCfg implements AsyncConfigurer
{
	@Bean
	public ThreadPoolTaskExecutor executor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(5);
		executor.setKeepAliveSeconds(100);
		executor.setQueueCapacity(5);
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
		executor.initialize();
		return executor;
		
	}
	
	@Override
	public Executor getAsyncExecutor() {
		
		return executor();
	}
	
	
	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return (a,b,c)->{};
	}

}
