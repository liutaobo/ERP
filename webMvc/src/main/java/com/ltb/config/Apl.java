package com.ltb.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
public class Apl implements InitializingBean{
	private ApplicationContext context;
	@Value("${person.name}")
	private String name;
	@Value("${person.id}")
	private String id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void initPer(){
		System.out.println("Person.initPer");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.getId()+this.getName());
		System.out.println("Person.afterPropertiesSet");
	}
	


}
