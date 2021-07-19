package com.ltb.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextFreshListener implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent()==null){
			System.out.println(event+","+event.getApplicationContext().getApplicationName());
		}else{
			String names [] = event.getApplicationContext().getBeanDefinitionNames();
			for(String name:names){
				System.out.println(name);
			}
			System.out.println(event+","+event.getApplicationContext().getApplicationName());
		}
		
	}

}
