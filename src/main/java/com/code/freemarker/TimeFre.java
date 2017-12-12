/**
 * 
 */
package com.code.freemarker;
import java.io.IOException;
import java.util.Map;

import com.code.util.DateUtils;

import freemarker.core.Environment;
import freemarker.template.SimpleDate;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
 

/**
 * 
 *  自定义时间标签
 * act里 model.put("testTime", new Date()) ;
 *  页面<@timeFormat time=testTime format='yyyy-MM-dd HH:mm'  />  不写format默认为yyyy-MM-dd ,没有时间时，不输出
 */
public class TimeFre implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		SimpleDate simpleDate = (SimpleDate) params.get("time");
		SimpleScalar tempContent =(SimpleScalar) params.get("format");
		
		if(simpleDate!=null){
			if(tempContent==null){
				env.getOut().write(DateUtils.safeFormatTime(simpleDate.getAsDate(),"yyyy-MM-dd"));
			}else{
				env.getOut().write(DateUtils.safeFormatTime(simpleDate.getAsDate(),tempContent.getAsString()));
			}
			 
		}

	}

}