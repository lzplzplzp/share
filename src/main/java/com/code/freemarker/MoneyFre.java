/**
 * 
 */
package com.code.freemarker;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import  freemarker.template.SimpleNumber; 
/**
 * 
 *  自定义长度标签
 *  minute  输入为分单元的金额   decimals小数位数,只能0或者2，为0显示整数 
 *  页面<@moneyShow minute=100 decimals=0 />
 */
public class MoneyFre implements TemplateDirectiveModel {

	@Override
	public void execute(Environment env, @SuppressWarnings("rawtypes") Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		SimpleNumber tempMinute = (SimpleNumber) params.get("minute");
		SimpleNumber tempDecimals =(SimpleNumber) params.get("decimals");
        if(tempMinute==null){
        	return ;
        }
		int  decimals= tempDecimals.getAsNumber().intValue() ;
		 
		int minute = 0 ;
		if(tempMinute!=null){
			minute = tempMinute.getAsNumber().intValue();
		}
		BigDecimal bigDecimal = new BigDecimal(minute);
		bigDecimal = bigDecimal.divide(new BigDecimal(100)) ;
		if(decimals>0){
			 java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00"); 
			 env.getOut().write(df.format(bigDecimal.doubleValue()));
		}else{
			Integer temp = bigDecimal.intValue() ;
			env.getOut().write(String.valueOf(temp));//输数字会出错
		}
	

	}

}