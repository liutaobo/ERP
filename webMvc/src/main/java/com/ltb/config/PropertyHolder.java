package com.ltb.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.support.ResourcePropertySource;
public class PropertyHolder implements InitializingBean{

	private ResourcePropertySource resource;

	public ResourcePropertySource getResource() {
		return resource;
	}

	public void setResource(ResourcePropertySource resource) {
		this.resource = resource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("+++++++++++++afterPropertiesSet");
	}


}
