package com.ltb.config;

import org.springframework.beans.factory.InitializingBean;

import lombok.Data;
@Data
public class Book implements InitializingBean{
	private String id;
	private String name;
	private double price;
	private String title;
	@Override
	public void afterPropertiesSet() throws Exception {
		this.id="1";
		this.name = "j";
		this.price=30d;
	}
	
}
