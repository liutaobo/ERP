package com.ltb.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	public void login(){
		int a=0;
		if(a>0){
			System.out.println(0);
		}
		if(a<0)
			a++;
	}
	
	public int test1(){
		return 1;
	}
	
	public int test2(){
		return 2;
	}
}
