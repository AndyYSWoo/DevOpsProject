package cn.edu.nju.se.DevOpsProject.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextHelper {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static Object getBean(String id){
		return context.getBean(id);
	}
}
