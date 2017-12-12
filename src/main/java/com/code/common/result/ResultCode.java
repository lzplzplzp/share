package com.code.common.result;

/**
 * 返回状态代码
 * @author ys
 * 2014-8-15 上午11:48:52
 */
public class ResultCode {
	
	public final static int SUCCESS = 0;
	
	public final static int FAILURE = -1;
		
	private int code = SUCCESS; // 返回代码
	private String message = "处理成功"; // 返回消息

	public ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public ResultCode(int code) {
		this.code = code;
		if(code == SUCCESS) {
			this.message = "处理成功";
		} else {
			this.message = "处理失败";
		}
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}	
}
