package com.ltb.config;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryRegister implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("+++++++++++++postProcessBeanFactory");
		PropertyHolder holder = beanFactory.getBean(PropertyHolder.class);
		try {
			holder.setResource(new ResourcePropertySource(new EncodedResource(new ClassPathResource("application.properties"),"UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("+++++++++++++postProcessBeanDefinitionRegistry");
		RootBeanDefinition property = new RootBeanDefinition(PropertyHolder.class);
		registry.registerBeanDefinition("propertyResolver", property);
	}

}
