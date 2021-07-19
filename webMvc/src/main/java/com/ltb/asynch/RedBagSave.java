package com.ltb.asynch;

import java.util.concurrent.RejectedExecutionException;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RedBagSave {

	public void save(){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"----"+System.currentTimeMillis());

		
	}
}
