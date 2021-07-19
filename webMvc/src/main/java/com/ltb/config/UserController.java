package com.ltb.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.RejectedExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.pool.DruidDataSource;
import com.ltb.asynch.RedBagSave;
import com.ltb.redis.config.RedisConfig;
@Controller
public class UserController {
	
	@Autowired
	private PropertyHolder resource;
	
	@Autowired
	private ApplicationContext applicationContext ;
	
	@Autowired
	private RedisConfig config;
	
	@Autowired
	private RedBagSave save;
	
	public UserController(){
	}
	
	@ResponseBody()
	@GetMapping("/getStr")
	public String getStr(){
		System.out.println("main:"+Thread.currentThread().getName());
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<11;i++){
			try{
				save.save();
			}catch(RejectedExecutionException e){
				System.out.println("//////////////");
				applicationContext.getBean(ThreadPoolTaskExecutor.class).shutdown();
			}finally{
				break;
			}
		}
		DataSourceConfig config = applicationContext.getBean(DataSourceConfig.class);
		DruidDataSource source = config.getDataSource();
		try {
			ResultSet set = source.getConnection().createStatement().executeQuery("select * from tb_user");
			while(set.next()){
				buffer.append(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"<br/>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return buffer.toString();
	}
	
}
