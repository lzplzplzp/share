package com.code.util.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
 

/**
 * json输出结果
 */
public class JsonResult   {
	
	private static Logger logger = LoggerFactory.getLogger(JsonResult.class);
 
//	private static final long serialVersionUID = 1L;
	/**
	 * 系统异常
	 */
	public final static int errorStatus = 0 ;
	/**
	 * 成功状态值
	 */
	public final static int  sucessStatus = 1;
	/**
	 * 失败状态值
	 */
	public final static int  failStatus = -1 ;
	
	
	

    /** 成功、失败 的附加提示 */
    String message;

    /** 操作状态 1：成功，0 系统异常 ，-1 业务异常 */
    int state;

    /** 结果数据 */
    Map<String, Object> data;

    /** 创建一个实例 */
    public static JsonResult newInstance() {
        return new JsonResult();
    }

    /**
     * 向输出中写入数据
     * @param key 
     * @param Object
     * @return
     */
    public JsonResult put(String key, Object Object) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        Assert.isTrue(data instanceof Map, "使用put 方法时 原始数据data 必须为 map类型");
        data.put(key, Object);
        return this;
    }

    /**
     * 直接向页面写输出对象
     * @param data
     * @return
     */
    public JsonResult data(Map<String, Object> data) {
        Assert.isNull(this.data, "data 数据已经赋值，不能重复赋值" + this.data);
        this.data = data;
        return this;
    }

    /**
     * 以json格式的字符串输出到页面
     * @return
     * @throws Exception 
     */
    public void jsonOnPage(HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("message", message);
        result.put("state", state);
        result.put("data", data);
        WebUtils.printOnPage(response,JSONObject.toJSONString(result));
    }

    public JsonResult success() {
        return state(sucessStatus, "");
    }
    
    public JsonResult success(String message) {
        return state(sucessStatus, message);
    }

    /**
     * 系统异常
     * @return
     */
    public JsonResult error() {
    	 return state(errorStatus, "系统异常请稍后重试");
    }

    /**
     * 业务异常
     * @param message
     * @return
     */
    public JsonResult fail(String message) {
        return state(failStatus, message);
    }

    private JsonResult state(int state, String message) {
        this.message = message;
        this.state = state;
        return this;
    }


    
	
 
	
}
