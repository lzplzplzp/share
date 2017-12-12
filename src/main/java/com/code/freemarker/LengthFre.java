/**
 * 
 */
package com.code.freemarker;
import java.io.IOException;
import java.util.Map;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import  freemarker.template.SimpleNumber; 
import freemarker.template.SimpleScalar ;
/**
 * 
 *  自定义长度标签
 * 
 *  页面<@friendlyLength content=内容 length=20 />
 */
public class LengthFre implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		SimpleNumber tempLength = (SimpleNumber) params.get("length");
		SimpleScalar tempContent =(SimpleScalar) params.get("content");
		if(tempLength!=null&&tempContent!=null){
			int length = tempLength.getAsNumber().intValue();
			String content = tempContent.getAsString() ;
			if(content.length()<=length){
				env.getOut().write(content);
				return ;
			}
			content=content.substring(0, length)+".." ;
			env.getOut().write(content);
		}

	}

}