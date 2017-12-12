package com.code.util.jxpay;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.code.util.CustomizedPropertyConfigurer;





/**
 * 签名工具类
 * 
 * @author jack
 *
 */
@Component
public class SignUtil_lj {

	private final static Logger logger = LoggerFactory.getLogger(SignUtil_lj.class);
	/**
	 * 签名算法
	 */
	//public static final String SIGN_ALGORITHMS = "SHA1withRSA";
	//private static String keys = "src/main/profiles/test1/yibao_sit.p12";//私钥文件
	private static String pass =CustomizedPropertyConfigurer.getContextProperty("jx.pay.pass") ; //私钥密码
	//private static String  crt = "src/main/profiles/test1/fdep.crt"; //服务端证书文件
	
	public SignUtil_lj() {

	}

	/**
	 * 获取签名
	 * 
	 * @param signStr  待签名字符串
	 * @return
	 * @throws Exception
	 */
	public static String sign(String signStr){
		
		System.out.println((new StringBuilder()).append("(P2P-->即信端)待签名字符串：").append(signStr)
				.toString());
		String sign = null;
		RSAHelper signer = null;
		try {
			//Signature sig = Signature.getInstance(SIGN_ALGORITHMS);
			String keyPath=CustomizedPropertyConfigurer.getContextProperty("jx.pay.keys.path");
			logger.info("keyPath="+keyPath);
			//System.out.println("keyPath="+keyPath);
			keyPath=SignUtil_lj.class.getResource("/"+keyPath).getPath();
			System.out.println("(P2P-->即信端)获取签名私钥:"+keyPath);
			
			RSAKeyUtil rsaKey = new RSAKeyUtil(new File(keyPath), pass);
			signer = new RSAHelper(rsaKey.getPrivateKey());
			
		    sign = signer.sign(signStr);
		} catch (Exception e) {
			logger.error("签名校验异常",e);
		}
		System.out.println((new StringBuilder()).append("(P2P-->即信端)签名:").append(sign)
				.toString());
		return sign;
	}
	
	/**
	 *  签名校验
	 * @param signText  待验的签名
	 * @param dataText  待签名字符串
	 * @return
	 */
	public static boolean verify(String signText,String dataText){
		signText = signText.replaceAll("[\\t\\n\\r]", "");
		System.out.println((new StringBuilder()).append("(即信端-->P2P)待签名字符串：").append(dataText)
				.toString());
		System.out.println((new StringBuilder()).append("(即信端-->P2P)签名：").append(signText)
				.toString());

		boolean b = false;
		try {
			//FIXME
			String crtPath=CustomizedPropertyConfigurer.getContextProperty("jx.pay.sert.path");
			logger.info("crtPath="+crtPath);
			//System.out.println("crtPath="+crtPath);
			crtPath=SignUtil_lj.class.getResource("/"+crtPath).getPath();
			logger.info("(P2P-->即信端)获取签名私钥:"+crtPath);
			System.out.println("(P2P-->即信端)获取签名私钥:"+crtPath);
			RSAKeyUtil ru = new RSAKeyUtil(new File(crtPath));
			RSAHelper signHelper = new RSAHelper(ru.getPublicKey()); 
			b = signHelper.verify(dataText , signText);
		} catch (Exception e) {
			System.out.println("签名校验异常"+e.getMessage());
		}
		return b;
	}

	/**
	 * 拼接字符串
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String mergeMap(Map map) {
		map = new TreeMap(map);
		String requestMerged = "";
		StringBuffer buff = new StringBuffer();
		Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
		Map.Entry<String, String> entry;
		while (iter.hasNext()) {
			entry = iter.next();
			if (!"SIGN".equalsIgnoreCase(entry.getKey())) {
				if(entry.getValue()==null){
					entry.setValue("");
					buff.append("");
				}else{
						buff.append(String.valueOf(entry.getValue()));
				}
			}
		}
		requestMerged = buff.toString();
		return requestMerged;
	}
}
