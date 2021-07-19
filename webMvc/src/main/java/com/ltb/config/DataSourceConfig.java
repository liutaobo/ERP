package com.ltb.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;

@Component
public class DataSourceConfig implements InitializingBean, BeanFactoryPostProcessor,ApplicationContextAware{
	private ApplicationContext applicationContext;
	@Value("${url}")
	private String url;
	@Value("${username}")
	private String name;
	@Value("${password}")
	private String password;
	@Value("${driverClass}")
	private String driverClass;
	private DruidDataSource dataSource;
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		beanFactory.registerSingleton("dataSource", dataSource);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		PropertyHolder holder = applicationContext.getBean(PropertyHolder.class);
		this.setUrl((String)holder.getResource().getProperty("url"));
		this.setName((String)holder.getResource().getProperty("username"));
		this.setPassword((String)holder.getResource().getProperty("password"));
		this.setDriverClass((String)holder.getResource().getProperty("driverClass"));
		dataSource = new DruidDataSource();
		dataSource.setUrl(getUrl());
		dataSource.setUsername(getName());
		dataSource.setPassword(getPassword());
		dataSource.setDriverClassName(getDriverClass());
		dataSource.setMaxActive(2);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("select 1");
		
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public DruidDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DruidDataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	
}
