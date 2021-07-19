package com.ltb.redis.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import com.ltb.config.PropertyHolder;

import redis.clients.jedis.JedisPoolConfig;
@Component
public class RedisConfig implements InitializingBean,ApplicationContextAware{
	private JedisPoolConfig config;
	private JedisConnectionFactory factory;
	private RedisTemplate tempalate;
	@Autowired
	private PropertyHolder resource;
	private ApplicationContext context;
	@Override
	public void afterPropertiesSet() throws Exception {
		ResourcePropertySource source = new ResourcePropertySource(new EncodedResource(new ClassPathResource("redis.properties"),"UTF-8"));
		this.config = new JedisPoolConfig();
		this.config.setMaxIdle(Integer.parseInt((String)source.getProperty("maxIdle")));
		this.config.setMaxTotal(Integer.parseInt((String)source.getProperty("maxTotal")));
		this.config.setMaxWaitMillis(Integer.parseInt((String)source.getProperty("maxWaitMillis")));
		this.factory = new JedisConnectionFactory(this.config);
		this.factory.setHostName((String)source.getProperty("host"));
		this.factory.setPort(Integer.parseInt((String)source.getProperty("port")));
		this.factory.afterPropertiesSet();
		RedisSerializer serializer = new StringRedisSerializer();
		tempalate = new RedisTemplate();
		tempalate.setConnectionFactory(this.factory);
		tempalate.setDefaultSerializer(serializer);
		tempalate.setStringSerializer(serializer);
		tempalate.setValueSerializer(serializer);
		tempalate.afterPropertiesSet();
		
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	public RedisTemplate getTempalate() {
		return tempalate;
	}
	public void setTempalate(RedisTemplate tempalate) {
		this.tempalate = tempalate;
	}
}
