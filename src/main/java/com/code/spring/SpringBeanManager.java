package com.code.spring;

import org.springframework.context.ApplicationContext;

/**
 * spring 手动获取bean
 * @since 1.0
 */
public class SpringBeanManager {
	
	private static ApplicationContext context;

	public static void initContext(ApplicationContext ctx) {
		context = ctx;
	}

	public static Object getBean(String name) {
		return context.getBean(name);
	}

	public static <T> T getBean(String name, Class<T> cls) {
		return context.getBean(name, cls);
	}
	
}
