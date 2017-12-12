package com.code.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.ShortConverter;

/**
 * 对BeanUtils封装了点  就是加了个时间解析
 * @description
 */
public class BeanUtils {
	
	public static void copyProperties(Object dest,Object orig) throws IllegalAccessException, InvocationTargetException{
		ConvertUtils.register(new LongConverter(null), Long.class);
		ConvertUtils.register(new ShortConverter(null), Short.class);
		ConvertUtils.register(new IntegerConverter(null), Integer.class);
		ConvertUtils.register(new DoubleConverter(null), Double.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		if(orig == null){
			return ;
		}
		org.apache.commons.beanutils.BeanUtils.copyProperties(dest, orig);
	}
	
	/**
	 * bean 转换成map 
	 * @param bean
	 * @return
	 * @throws IllegalAccessException
	 */
	public static Map<String, Object> bean2map(Object bean)
			throws IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		Class<? extends Object> c = bean.getClass();
		Field[] f = c.getDeclaredFields();// 获取所有字段
		for (int i = 0; i < f.length; i++) {
			if (f[i].getName().equals("serialVersionUID")) {// 去掉Serializable id
				continue;
			}
			f[i].setAccessible(true);
			Object value = f[i].get(bean);
			if (value == null) {
				continue;
			}
			map.put(f[i].getName(), value);
		}
		return map;
	}
	
}
