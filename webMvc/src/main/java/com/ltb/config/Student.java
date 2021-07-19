package com.ltb.config;

import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class Student implements InitializingBean{
	private String school;
	private String idNo;
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	@Override
	public void afterPropertiesSet() throws Exception {
	}
	
	public void initStu(){
	}
	
}
