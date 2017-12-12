package com.code.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 配置文件BEAN 对应 config.xml
 */
@Component
public class CommonConfig {

	private static final String  SETTINGS= "settings";

	/**
	 * 生成活动短连接前导入的Excel上传路径
	 */
	@Value("#{"+SETTINGS+"['build.activity.url.before.upload.absolutely.path']}")
	private String buildActivityUrlBefore;

	/**
	 * 生成活动短连接后导入的Excel上传路径
	 */
	@Value("#{"+SETTINGS+"['build.activity.url.after.upload.absolutely.path']}")
	private String buildActivityUrlAfter;


	public String getBuildActivityUrlBefore() {
		return buildActivityUrlBefore;
	}

	public void setBuildActivityUrlBefore(String buildActivityUrlBefore) {
		this.buildActivityUrlBefore = buildActivityUrlBefore;
	}

	public String getBuildActivityUrlAfter() {
		return buildActivityUrlAfter;
	}

	public void setBuildActivityUrlAfter(String buildActivityUrlAfter) {
		this.buildActivityUrlAfter = buildActivityUrlAfter;
	}
}
