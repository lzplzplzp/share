package com.code.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
 
/**
 * 配置初始化类 
 * @author 400
 *
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {
 
	
	private static final Map<String, String> ctxPropertiesMap = new HashMap<String, String>() ;
 
 
    /**
     * 是否为测试环境,不发报错邮件
     */
    public static  boolean isTest = false ;
    
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactory,
			Properties props)throws BeansException {
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
		if("true".equalsIgnoreCase(ctxPropertiesMap.get("isTest"))){
			isTest = true ;
		}
	 
		super.processProperties(beanFactory, props);
	}

	/**
	 * 通过Property key 来取对应的Property 值 
	 * @param name
	 * @return 没有返回null
	 */
	public static String getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
	
}
