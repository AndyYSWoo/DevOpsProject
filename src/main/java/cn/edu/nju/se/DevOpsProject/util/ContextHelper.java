package cn.edu.nju.se.DevOpsProject.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextHelper {
	private static ApplicationContext context = null;
	static{
		try{
			context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}catch(Exception e){
			System.out.println("=================");
			e.printStackTrace();
		}
	}
	public static Object getBean(String id){
		return context.getBean(id);
	}
}
