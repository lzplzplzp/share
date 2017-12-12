package com.code.util;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 

 
 
public class HttpUtil
{
	private static Logger log = LoggerFactory.getLogger(HttpUtil.class);
	// 创建HttpClient对象
	private static final HttpClient httpClient = new DefaultHttpClient();
 
	
	/**
	 * 
	 * @param url 发送请求的URL
	 * @return 服务器响应字符串
	 * @throws Exception
	 */
	public static String getRequest(String url)
	{
		try{
			// 创建HttpGet对象。
			HttpGet get = new HttpGet(url);
			// 发送GET请求
			HttpResponse httpResponse = httpClient.execute(get);
			// 如果服务器成功地返回响应
			if (httpResponse.getStatusLine()
				.getStatusCode() == 200)
			{
				// 获取服务器响应字符串
				String result = EntityUtils
					.toString(httpResponse.getEntity());
				return result;
			}
		}catch(IOException e){
			log.error( "请求连接:"+url+"  异常", e); 
		}

		return null;
	}

	/**
	 * 
	 * @param url 发送请求的URL
	 * @param params 请求参数
	 * @return 服务器响应字符串
	 * @throws Exception
	 */
	public static String postRequest(String url
		, Map<String ,String> rawParams)throws IOException
	{
		// 创建HttpPost对象。
		HttpPost post = new HttpPost(url);
 
		// 如果传递参数个数比较多的话可以对传递的参数进行封装
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for(String key : rawParams.keySet())
		{
			//封装请求参数
			params.add(new BasicNameValuePair(key , rawParams.get(key)));
		}
 	// 设置请求参数
		post.setEntity(new UrlEncodedFormEntity(
			params, "UTF-8"));
		// 发送POST请求
		HttpResponse httpResponse = httpClient.execute(post);
		// 如果服务器成功地返回响应
		if (httpResponse.getStatusLine()
			.getStatusCode() == 200)
		{
			//头部测试
//		System.out.println(httpResponse.getFirstHeader("status").getValue()+" 长度:"+httpResponse.getFirstHeader("status").getValue().length());	 
			// 获取服务器响应字符串
			String result = EntityUtils
				.toString(httpResponse.getEntity());
			return result;
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
 
 
		Map<String ,String>  map = new HashMap<String,String>() ;
		map.put("json", "test json");
		map.put("outPdf", "test outPdf");
		System.out.println(postRequest("http://127.0.0.1:8080/pdf/kjPdf", map) );
		
	}
 
	
	
	
	
	
	
	
	
	
}
