package com.code.util.sms;

import com.code.util.CustomizedPropertyConfigurer;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 发送短信工具类
 * Created by Administrator on 2017/5/2.
 */
public class PhoneSendMessageUtils {

    private static final Logger LOG = LoggerFactory.getLogger(PhoneSendMessageUtils.class);


    /**
     * 生成验证码
     *
     * @return
     */
    public static String createAuthcode() {
        String debug = CustomizedPropertyConfigurer.getContextProperty("phone.debug");
        if (debug.equals("1")) {
            return "888888";
        }
        Random random = new Random();
        int x = random.nextInt(899999) + 100000;
        return Integer.toString(x);
    }

    /**
     * 短信发送，根据渠道去发
     * @param phoneNum
     * @param msg
     * @return sendFlag 失败：0，成功：1
     */
    public static int sendMsg(String phoneNum, String msg){
        String debug = CustomizedPropertyConfigurer.getContextProperty("phone.debug");
        int sendFlag = 0;
        try {
            int i =0;
            if(debug.equals("1")) {
                sendFlag = 1;
            }else{
                    ISms sms=new CHttpPost();
                    StringBuffer strPtMsgId=new StringBuffer("");
                    //短信息发送接口（相同内容群发，可自定义流水号）POST请求,httpClient为空，则是短连接,httpClient不为空，则是长连接。
                    /**
                     * 1.短信息发送接口（相同内容群发，可自定义流水号）
                     * @param strPtMsgId 平台返回的流水号 如果返回的流水大于10位小于25位为提交成功
                     * @param strUserId  帐号
                     * @param strPwd 密码
                     * @param strMobiles 手机号
                     * @param strMessage 短信内容
                     * @param strSubPort 扩展子号
                     * @param strUserMsgId 用户自编流水号
                     * @param bKeepAlive 长连接或短连接,默认短连接,false短连接,true长连接
                     * @param connection 连接对象,如果是短连接，传null
                     * @return 0:成功 非0:返回webservice接口返回的错误代码
                     */
                    i =sms.SendSms(strPtMsgId, CustomizedPropertyConfigurer.getContextProperty("sms.mont.username"), CustomizedPropertyConfigurer.getContextProperty("sms.mont.password"), phoneNum, msg, "*", "0", false, null);
                    if (i == 0 && strPtMsgId.length()>=10 && strPtMsgId.length()<=25) {
                        sendFlag = 1;
                    }
                    if(LOG.isDebugEnabled()){
                        LOG.debug("梦网短信发送，手机号码：{},短信内容：{},返回状态：{},流水号:{},状态:{}", new Object[] { phoneNum,msg, i,strPtMsgId,sendFlag});
                    }
            }
        } catch (Exception e) {
            LOG.error("短信发送失败，手机号码：{},短信内容：{},错误：{}", new Object[] { phoneNum,msg, e });
        }
        return sendFlag;
    }
}
