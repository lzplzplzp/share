package com.code.util;

import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.servlet.ModelAndView;

public class ViewResult {
	private int code;
	private String msg;
	private Map<String, Object> data;
	private ModelAndView mav;
	private static GsonBuilder GSON_BUILDER = new GsonBuilder();

	public static ViewResult newInstance() {
		ViewResult instance = new ViewResult();

		return instance;
	}

	public int getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public Map<String, Object> getData() {
		return this.data;
	}

	public ViewResult code(int code) {
		this.code = code;
		return this;
	}

	public ViewResult msg(String msg) {
		this.msg = msg;
		return this;
	}

	public ViewResult put(String key, Object value) {
		if (this.data == null) {
			this.data = new HashMap();
		}
		this.data.put(key, value);
		return this;
	}
	public ViewResult put(Map map) {
		if (this.data == null) {
			this.data = new HashMap();
		}
		this.data.putAll(map);;
		return this;
	}

	public String json() {
		return GSON_BUILDER.create().toJson(this);
	}

	public ModelAndView view(String pageName) {
		if (this.mav == null) {
			this.mav = new ModelAndView(pageName);
		}
		this.mav.addObject("result", this);
		return this.mav;
	}

	public String redirect(String url) {
		return "redirect:" + url;
	}

	public String forward(String url) {
		return "forward:" + url;
	}

	public ModelAndView error() {
		return view("error404");
	}
}
