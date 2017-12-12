package com.code.common;

/**
 * Json封装类
 * 
 * @param <T>
 */
public class JsonWrapper<T> {

	public final static int SUCCESS = 0;

	public final static int FAILURE = -1;

	private boolean flag; 				// 是否执行成功
	private boolean timeout; 			// 是否超时
	private int code = SUCCESS; 		// 返回代码
	private String msg; 				// 错误消息
	private T data; 					// 返回数据

	public JsonWrapper() {
		super();
	}

	public JsonWrapper(boolean timeout, boolean flag, int code, String msg, T data) {
		super();
		this.timeout = timeout;
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public JsonWrapper(boolean flag, int code, String msg, T data) {
		super();
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public JsonWrapper(boolean timeout, boolean flag, String msg, T data) {
		super();
		this.timeout = timeout;
		this.flag = flag;
		this.msg = msg;
		this.data = data;
	}

	public JsonWrapper(boolean flag, String msg, T data) {
		super();
		this.timeout = false;
		this.flag = flag;
		this.msg = msg;
		this.data = data;
	}

	public JsonWrapper(boolean flag, String msg) {
		super();
		this.timeout = false;
		this.flag = flag;
		this.msg = msg;
	}

	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
