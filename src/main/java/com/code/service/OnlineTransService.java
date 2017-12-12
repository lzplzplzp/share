package com.code.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.alibaba.fastjson.JSONObject;
import org.omg.PortableInterceptor.RequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.code.util.CustomizedPropertyConfigurer;
import com.code.util.jxpay.DateUtil;
import com.code.util.jxpay.SignUtil_lj;
import com.mysql.jdbc.StringUtils;

/**
 * 联机接口
 *
 * @author LiuDezhuang
 */
@Service
public class OnlineTransService {

    private final static Logger LOG = LoggerFactory.getLogger(OnlineTransService.class);

    //访问接口地址
    // private static String uri = "https://test.credit2go.cn/escrow/p2p/online";
    //银行代码
    private static final String BANKCODE = CustomizedPropertyConfigurer.getContextProperty("jx.pay.bankcode");
    //机构代码   （说明：平台需要根据即信端给定实际参数进行调整）
    private static final String INSTCODE = CustomizedPropertyConfigurer.getContextProperty("jx.pay.instcode");

    /**
     * 电子账户余额查询
     *
     * @param txCode    交易代码
     * @param accountId 电子账号(存管平台分配的账号)
     * @throws Exception
     */
    public Map<String, String> balanceQuery(String accountId) {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap = getHeadReq(reqMap);
        //reqMap.put("accountId", "6212461270000004701");
        reqMap.put("txCode", "balanceQuery");
        reqMap.put("accountId", accountId);

        return commonRequest(reqMap, 1);
    }

    /**
     * 电子账户密码是否设置查询
     *
     * @param accountId 电子账号(存管平台分配的账号)
     * @throws Exception
     */
    public Map<String, String> passwordSetQuery(String accountId) {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap = getHeadReq(reqMap);
        reqMap.put("txCode", "passwordSetQuery");
        reqMap.put("accountId", accountId);

        return commonRequest(reqMap, 1);
    }


    /**
     * 个人开户
     *
     * @throws Exception
     */
    public Map<String, String> accountOpen() throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);

        reqMap.put("txCode", "accountOpen");
        reqMap.put("idType", "01");
        reqMap.put("idNo", "110101199801012211");
        reqMap.put("name", "柳永");
        reqMap.put("mobile", "18242610829");
        reqMap.put("cardNo", "6222988812340036");
        reqMap.put("email", "");
        reqMap.put("acctUse", "00000");
        reqMap.put("acqRes", "");

        return commonRequest(reqMap, 1);
    }

    /**
     * 按证件号查询电子账号
     * 按照证件号查询对应的电子账号
     *
     * @param idType 证件类型	01-身份证（18位） 20-组织机构代码 25-企业社会信用代码
     * @param idNo   证件号码
     * @return
     * @throws Exception
     */
    public Map<String, String> accountIdQuery(String idType, String idNo) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);

        reqMap.put("txCode", "accountIdQuery");
      /* reqMap.put("idType","01");    
        reqMap.put("idNo","110101199801012211");     */

        reqMap.put("idType", idType);
        reqMap.put("idNo", idNo);

        return commonRequest(reqMap, 1);
    }

    /**
     * 电子账户资金交易明细查询 查询电子账户的资金交易明细（资金出或资金入）
     *
     * @param accountId 电子账号
     * @param startDate 起始日期 YYYYMMDD
     * @param endDate   结束日期YYYYMMDD
     * @param type      交易种类	0-所有交易 1-转入交易 2-转出交易 9-指定交易类型
     * @param tranType  交易类型(选填)	type=9必填，后台交易类型
     * @param pageNum   页数	 查询页数
     * @param pageSize  页长 每页笔数
     * @throws Exception
     */
    public Map<String, String> accountDetailsQuery(String accountId, String startDate, String endDate, String type, String tranType, String pageNum, String pageSize) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);

        reqMap.put("txCode", "accountDetailsQuery");

        reqMap.put("accountId", accountId);
        reqMap.put("startDate", startDate);
        reqMap.put("endDate", endDate);
        reqMap.put("type", type);
        reqMap.put("tranType", tranType);
        reqMap.put("pageNum", pageNum);
        reqMap.put("pageSize", pageSize);

        return commonRequest(reqMap, 1);
    }

    /**
     * 提现
     * 用户将电子账户资金转移到绑定的银行卡
     *
     * @param accountId        电子账号
     * @param idType           证件类型 01-身份证（18位）
     * @param idNo             证件号码
     * @param name             姓名
     * @param mobile           手机号
     * @param cardBankNameEn   绑定银行英文名称	A	20	C	绑定的银行卡对应的银行英文名称缩写
     * @param cardBankProvince 绑定银行卡开户省份	A	20	C	绑定的银行卡的开户省份
     * @param cardNo           银行卡号 	绑定银行卡号
     * @param txAmount         交易金额 	提现金额
     * @param txFee            手续费 	提现手续费
     * @param routeCode        路由代码 0-本行通道 1-银联通道  2-人行通道 空-自动选择
     * @param cardBankCnaps    绑定银行联行号 	人民银行分配的12位联行号  routeCode=2，必输 或者routeCode为空，但交易金额>20万，必输
     * @param cardBankCode     绑定银行代码 	绑定的银行卡对应的银行代码
     * @param cardBankNameCn   绑定银行中文名称 	绑定的银行卡对应的银行中文名称
     * @param cardBankCity     绑定银行卡开户城市 	绑定的银行卡的开户城市
     * @param forgotPwdUrl     忘记密码跳转 	忘记密码的跳转URL
     * @param retUrl           前台跳转链接	交易后台跳转的前台URL
     * @param notifyUrl        后台通知连接 	后台通知URL，“响应参数”返回到该URL，收到后返回“success”
     * @return
     * @throws Exception
     */
    public Map<String, String> withdraw(String accountId, String idType, String idNo, String name, String mobile, String cardNo, BigDecimal txAmount,
                                        BigDecimal txFee, String routeCode, String cardBankCnaps, String forgotPwdUrl, String retUrl, String notifyUrl, Date requestDate, String randomStr) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "withdraw");
        reqMap = getHeadReq(reqMap, requestDate, randomStr);

        reqMap.put("accountId", accountId);
        reqMap.put("idType", idType);
        reqMap.put("idNo", idNo);
        reqMap.put("name", name);
        reqMap.put("mobile", mobile);
        reqMap.put("cardNo", cardNo);
        reqMap.put("txAmount", txAmount.toString());
        reqMap.put("txFee", txFee == null ? null : txFee.toString());
        reqMap.put("routeCode", routeCode);
        reqMap.put("cardBankCnaps", cardBankCnaps);
        reqMap.put("forgotPwdUrl", forgotPwdUrl);
        reqMap.put("retUrl", retUrl);
        reqMap.put("notifyUrl", notifyUrl);

        //生成待签名字符串
        String requestMapMerged = mergeMap(reqMap);
        //生成签名
        String sign = SignUtil_lj.sign(requestMapMerged);
        reqMap.put("sign", sign);
        LOG.info("withdraw 请求参数:" + JSONObject.toJSONString(reqMap));
        return reqMap;//commonRequest(reqMap,2);
    }

    /**
     * 密码设置
     * 设置电子账户的密码，必须是首次设置密码
     *
     * @param accountId 电子账号
     * @param idType    证件类型	 	01-身份证18位  20-组织机构代码 25-企业社会信用代码
     * @param idNo      证件号码
     * @param name      姓名
     * @param mobile    手机号
     * @param retUrl    前台跳转链接 交易后台跳转的前台URL
     * @param notifyUrl 后台通知连接 后台通知URL，“响应参数”返回到该URL，收到后返回“success”
     * @return
     * @throws Exception
     */
    public Map<String, String> passwordSet(String accountId, String idType, String idNo, String name, String mobile, String retUrl, String notifyUrl) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "passwordSet");
        getHeadReq(reqMap);
        reqMap.put("accountId", accountId);
        reqMap.put("idType", idType);
        reqMap.put("idNo", idNo);
        reqMap.put("name", name);
        reqMap.put("mobile", mobile);
        reqMap.put("retUrl", retUrl);
        reqMap.put("notifyUrl", notifyUrl);

        //生成待签名字符串
        String requestMapMerged = mergeMap(reqMap);
        //生成签名
        String sign = SignUtil_lj.sign(requestMapMerged);

        reqMap.put("sign", sign);

        return reqMap;//commonRequest(reqMap,2);

    }

    /**
     * 密码重置
     * 必须曾经设置过电子账户密码
     *
     * @param accountId    电子账号
     * @param idType       证件类型	 	01-身份证18位  20-组织机构代码 25-企业社会信用代码
     * @param idNo证件号码
     * @param name姓名
     * @param mobile手机号
     * @param retUrl前台跳转链接 交易后台跳转的前台URL
     * @param notifyUrl    后台通知连接	 	后台通知URL，“响应参数”返回到该URL，收到后返回“success”
     * @return
     * @throws Exception
     */
    public Map<String, String> passwordReset(String accountId, String idType, String idNo, String name, String mobile, String retUrl, String notifyUrl) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "passwordReset");
        getHeadReq(reqMap);
        reqMap.put("accountId", accountId);
        reqMap.put("idType", idType);
        reqMap.put("name", name);
        reqMap.put("mobile", mobile);
        reqMap.put("retUrl", retUrl);
        reqMap.put("notifyUrl", notifyUrl);
        //生成待签名字符串
        String requestMapMerged = mergeMap(reqMap);
        //生成签名
        String sign = SignUtil_lj.sign(requestMapMerged);

        reqMap.put("sign", sign);

        return reqMap;
        //return  commonRequest(reqMap,2);
    }


    /**
     * 资金冻结(还款申请冻结资金)
     * 功能说明：冻结用户电子账户中指定金额
     *
     * @param accountId 电子账号
     * @param orderId   订单号 由P2P生成，必须保证唯一(30)
     * @param txAmount  交易金额
     * @return
     * @throws Exception
     */
    public Map<String, String> balanceFreeze(String accountId, String orderId, String txAmount) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "balanceFreeze");
        getHeadReq(reqMap);
        reqMap.put("accountId", accountId);
        reqMap.put("orderId", orderId);
        reqMap.put("txAmount", txAmount);

        return commonRequest(reqMap, 1);
    }

    /**
     * 资金解冻(还款申请撤销资金解冻)
     * 功能说明：撤销原来冻结的电子账户资金
     *
     * @param accountId  电子账号
     * @param orderId    订单号 由P2P生成，必须保证唯一
     * @param txAmount   原冻结金额
     * @param orgOrderId 原冻结订单号
     * @return
     * @throws Exception
     */
    public Map<String, String> balanceUnfreeze(String accountId, String orderId, String txAmount, String orgOrderId) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "balanceUnfreeze");
        getHeadReq(reqMap);
        reqMap.put("accountId", accountId);
        reqMap.put("orderId", orderId);
        reqMap.put("txAmount", txAmount);
        reqMap.put("orgOrderId", orgOrderId);

        return commonRequest(reqMap, 1);
    }

    /**
     * 还款
     * 功能说明：融资人向投资人还款，P2P平台通过本交易申请将资金从融资人电子账户划转到投资人电子账户，
     * 实际生效的时间视银行处理情况而定。
     *
     * @param accountId    电子账号	融资人电子账号
     * @param orderId      订单号		由P2P生成，必须保证唯一
     * @param txAmount     交易金额		融资人实际付出金额=交易金额+交易利息+还款手续费
     * @param intAmount    交易利息
     * @param txFeeOut     还款手续费		向融资人收取的手续费
     * @param txFeeIn      收款手续费		向投资人收取的手续费
     * @param forAccountId 对手电子账号		投资人账号
     * @param productId    标的号		投资人投标成功的标的号
     * @param authCode     授权码		投资人投标成功的授权号
     * @param freezeFlag   冻结资金开关	非必填	0-不冻结资金（如果在调用还款交易之前，已经使用了“资金冻结”，则无需再冻结） 1-冻结资金
     * @return
     * @throws Exception
     */
    public Map<String, String> repay(String accountId, String orderId, String txAmount, String intAmount, String txFeeOut, String txFeeIn, String forAccountId, String productId, String authCode, String freezeFlag) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "repay");
        getHeadReq(reqMap);

        reqMap.put("accountId", accountId);
        reqMap.put("orderId", orderId);
        reqMap.put("txAmount", txAmount);
        reqMap.put("intAmount", intAmount);
        reqMap.put("txFeeOut", txFeeOut);
        reqMap.put("txFeeIn", txFeeIn);
        reqMap.put("forAccountId", forAccountId);
        reqMap.put("productId", productId);
        reqMap.put("authCode", authCode);
        reqMap.put("freezeFlag", freezeFlag);

        return commonRequest(reqMap, 1);
    }


    /**
     * 绑卡关系查询
     * 功能说明：查询用户名下绑定卡的情况（仅有一张卡有效，仅保留最近十笔）
     *
     * @param accountId 电子账号
     * @param state     查询状态 非必填	0-所有（默认）1-当前有效的绑定卡
     * @return
     * @throws Exception
     */
    public Map<String, String> cardBindDetailsQuery(String accountId, String state) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "cardBindDetailsQuery");
        getHeadReq(reqMap);

        reqMap.put("accountId", accountId);
        if (!StringUtils.isEmptyOrWhitespaceOnly(state)) {
            reqMap.put("state", state);
        }


        return commonRequest(reqMap, 1);
    }


    /**
     * 借款人标的信息查询 功能说明：借款人登记的标的信息查询。
     *
     * @param accountId 电子账号	 	存管平台分配的借款人电子账号
     * @param productId 标的号	非必填	为空表示查询所有标的productId不能与（startDate和endDate）同时为空
     * @param startDate 起始日期	非必填	YYYYMMDD，对应募集日
     * @param endDate   结束日期	非必填	YYYYMMDD，对应募集日
     * @param pageNum   页数	 	查询页数
     * @param pageSize  页长	 每页笔数
     * @return
     * @throws Exception
     */
    public Map<String, String> debtDetailsQuery(String accountId, String productId, String startDate, String endDate, String pageNum, String pageSize) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "debtDetailsQuery");

        reqMap.put("accountId", accountId);
        reqMap.put("productId", productId);
        reqMap.put("startDate", startDate);
        reqMap.put("endDate", endDate);
        reqMap.put("pageNum", pageNum);
        reqMap.put("pageSize", pageSize);

        return commonRequest(reqMap, 1);
    }


    /**
     * 电子账户手机号查询维护
     * 功能说明：查询或修改电子账户的手机号，P2P平台应在调用前校验手机验证码
     *
     * @param accountId 电子账号 	存管平台分配的账号
     * @param option    选项 0-查询
     * @return
     * @throws Exception
     */
    public Map<String, String> mobileMaintainace(String accountId, String option) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "mobileMaintainace");

        reqMap.put("accountId", accountId);
        reqMap.put("option", option);

        return commonRequest(reqMap, 1);
    }

    /**
     * 按手机号查询电子账号信息
     * 功能说明：根据手机号查询电子账户信息
     *
     * @param mobile 手机号
     * @return
     * @throws Exception
     */
    public Map<String, String> accountQueryByMobile(String mobile) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "accountQueryByMobile");

        reqMap.put("mobile", mobile);

        return commonRequest(reqMap, 1);
    }

    /**
     * 查询交易状态
     * 功能说明：据交易流水号或者订单号查询交易的状态
     * （可以查询放款、还款、融资人还担保账户垫款、结束债权、批次放款、批次还款、批次融资人还担保账户垫款、批次结束债权交易、批次投资人购买债权、批次担保账户代偿）
     *
     * @param accountId  电子账号	非必填	若原交易有电子账号，必填
     * @param reqType    查询类别		1-按流水号查询（批次类交易不可用） 2-按订单号查询
     * @param reqTxCode  查询交易代码
     * @param reqTxDate  查询交易日期	 非必填	reqType=1，必填
     * @param reqTxTime  查询交易时间	非必填	reqType=1，必填
     * @param reqSeqNo   查询交易流水号	 非必填	reqType=1，必填
     * @param reqOrderId 查询订单号	非必填	reqType=2，必填
     * @return
     * @throws Exception
     */
    public Map<String, String> transactionStatusQuery(String accountId, String reqType, String reqTxCode, String reqTxDate, String reqTxTime, String reqSeqNo, String reqOrderId) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        reqMap.put("txCode", "transactionStatusQuery");
        getHeadReq(reqMap);

        reqMap.put("accountId", accountId);
        reqMap.put("reqType", reqType);
        reqMap.put("reqTxCode", reqTxCode);
        reqMap.put("reqTxDate", reqTxDate);
        reqMap.put("reqTxTime", reqTxTime);
        reqMap.put("reqSeqNo", reqSeqNo);
        reqMap.put("reqOrderId", reqOrderId);

        return commonRequest(reqMap, 1);
    }

    /**
     * 查询批次状态
     * 功能说明：查询批次的状态，包括批次放款、批次还款、批次融资人还担保账户垫款接口、批次结束债权。
     *
     * @param batchTxDate 批次交易日期	YYYYMMDD
     * @param batchNo     批次号
     * @return
     * @throws Exception
     */
    public Map<String, String> batchQuery(String batchTxDate, String batchNo) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "batchQuery");

        reqMap.put("batchTxDate", batchTxDate);
        reqMap.put("batchNo", batchNo);

        return commonRequest(reqMap, 1);
    }


    /**
     * 请求发送短信验证码
     * 功能说明：向指定的短信号码发送验证码。
     *
     * @param mobile    手机号
     * @param srvTxCode 业务交易代码 accountOpenPlus 	cardBindPlus 	mobileModifyPlus 	passwordResetPlus 	directRechargePlus	 	indirectRechargePlus    autoBidAuthPlus    autoCreditInvestAuthPlus
     * @return
     * @throws Exception
     */
    public Map<String, String> testSmsCodeApply(String mobile, String srvTxCode) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "smsCodeApply");

        reqMap.put("mobile", mobile);
        reqMap.put("srvTxCode", srvTxCode);

        return commonRequest(reqMap, 1);
    }

    /**
     * 个人开户增强
     * 功能说明：验证短信验证码，在账务系统中开户，同时绑定同名银行卡。必须银行卡对应的姓名、证件与输入信息一致。
     *
     * @param idType          证件类型	01-身份证（18位）
     * @param idNo            证件号码
     * @param name            姓名
     * @param mobile          手机号
     * @param cardNo          银行卡号 (绑定银行卡号)
     * @param email           邮箱  非必填
     * @param acctUse         账户用途 每一位字符表示一种用途，‘1’表示启用；全‘0’表示普通账户  1-红包账户（只能有一个）2-手续费账户（只能有一个） 3-担保账户 4-保留（填0）
     * @param lastSrvAuthCode 前导业务授权码 	通过请求发送短信验证码接口获取
     * @param smsCode         短信验证码	 	手机接收到短信验证码
     * @return
     * @throws Exception
     */
    public Map<String, String> testAccountOpenPlus(String idType, String idNo, String name, String mobile, String cardNo, String email, String acctUse, String lastSrvAuthCode, String smsCode) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "accountOpenPlus");

        reqMap.put("idType", idType);
        reqMap.put("idNo", idNo);
        reqMap.put("name", name);
        reqMap.put("mobile", mobile);
        reqMap.put("cardNo", cardNo);
        reqMap.put("email", email);
        reqMap.put("acctUse", acctUse);
        reqMap.put("lastSrvAuthCode", lastSrvAuthCode);
        reqMap.put("smsCode", smsCode);

        return commonRequest(reqMap, 1);
    }

    /**
     * 绑定银行卡增强
     * 功能说明：验证短信验证码，当电子账户在账务系统没有绑定银行卡时，
     * 使用该交易绑定同名银行卡。必须银行卡对应的姓名、证件与输入信息一致。
     *
     * @param accountId       电子账号	 	存管平台分配的账号
     * @param idType          证件类型	 01-身份证（18位）
     * @param idNo            证件号码
     * @param name            姓名
     * @param mobile          手机号
     * @param cardNo          银行卡号	 	绑定银行卡号
     * @param lastSrvAuthCode 前导业务授权码 	通过请求发送短信验证码接口获取
     * @param smsCode         短信验证码	 	手机接收到短信验证码
     * @return
     * @throws Exception
     */
    public Map<String, String> testCardBindPlus(String accountId, String idType, String idNo, String name, String mobile, String cardNo, String lastSrvAuthCode, String smsCode) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "cardBindPlus");

        reqMap.put("accountId", accountId);
        reqMap.put("idType", idType);
        reqMap.put("idNo", idNo);
        reqMap.put("name", name);
        reqMap.put("mobile", mobile);
        reqMap.put("cardNo", cardNo);
        reqMap.put("lastSrvAuthCode", lastSrvAuthCode);
        reqMap.put("smsCode", smsCode);

        return commonRequest(reqMap, 1);
    }

    /**
     * 电子账户手机号修改增强
     * 功能说明：验证短信验证码，修改电子账户的手机号。
     *
     * @param accountId       电子账号
     * @param option          选项	 	1-修改
     * @param mobile          新手机号
     * @param lastSrvAuthCode 前导业务授权码 	通过请求发送短信验证码接口获取
     * @param smsCode         短信验证码	 	手机接收到短信验证码
     * @throws Exception
     */
    public Map<String, String> testMobileModifyPlus(String accountId, String option, String mobile, String lastSrvAuthCode, String smsCode) throws Exception {
        Map<String, String> reqMap = new TreeMap<>();
        getHeadReq(reqMap);
        reqMap.put("txCode", "mobileModifyPlus");

        reqMap.put("accountId", accountId);
        reqMap.put("option", option);
        reqMap.put("mobile", mobile);
        reqMap.put("lastSrvAuthCode", lastSrvAuthCode);
        reqMap.put("smsCode", smsCode);

        return commonRequest(reqMap, 1);
    }

    /**
     * 通用部分统一管理
     *
     * @param reqMap 请求的参数map
     * @return 加入参数后的map
     */
    private Map<String, String> getHeadReq(Map<String, String> reqMap) {
        // TODO Auto-generated method stub

        reqMap.put("version", "10"); //版本号
        reqMap.put("instCode", INSTCODE);//机构代码
        reqMap.put("bankCode", BANKCODE);//银行代码
        reqMap.put("txDate", DateUtil.getDate());//交易日期
        reqMap.put("txTime", DateUtil.getTime());//交易时间
        reqMap.put("seqNo", DateUtil.getRandomStr(6));//交易流水号
        reqMap.put("channel", "000001");//交易渠道

        return reqMap;
    }

    /**
     * 通用部分统一管理
     *
     * @param reqMap 请求的参数map
     * @return 加入参数后的map
     */
    private Map<String, String> getHeadReq(Map<String, String> reqMap, Date requestDate, String randomStr) {
        // TODO Auto-generated method stub

        reqMap.put("version", "10"); //版本号
        reqMap.put("instCode", INSTCODE);//虚拟代码机构
        reqMap.put("bankCode", BANKCODE);//银行机构代码
        reqMap.put("txDate", DateUtil.getDate(requestDate));//交易日期
        reqMap.put("txTime", DateUtil.getTime(requestDate));//交易时间
        reqMap.put("seqNo", randomStr);//交易流水号
        reqMap.put("channel", "000002");//交易渠道

        return reqMap;
    }

    /**
     * 组织参数发起请求
     *
     * @param reqMap    传递参数
     * @param urlStatus 调用类型 1:接口调用 2:页面调用
     * @return
     * @throws Exception
     */
    @SuppressWarnings({"serial", "rawtypes", "unchecked"})
    public Map<String, String> commonRequest(Map<String, String> reqMap, int urlStatus) {
        //获取uri
        String uri = CustomizedPropertyConfigurer.getContextProperty(urlStatus == 2 ? "jx.pay.uri.page" : "jx.pay.uri.api");
        //生成待签名字符串
        String requestMapMerged = mergeMap(reqMap);
        //生成签名
        String sign = SignUtil_lj.sign(requestMapMerged);

        reqMap.put("sign", sign);

        RestTemplate restTemplate = new RestTemplate(new ArrayList<HttpMessageConverter<?>>() {{
            add(new FastJsonHttpMessageConverter());
        }});
        //新建请求头,并填充参数
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept-Charset", "UTF-8");
        headers.set("contentType", "application/json");
        //忽略证书,信任所有来源
        try {
            trustAllHttpsCertificates();
        } catch (Exception e) {
            LOG.error("忽略证书,信任所有来源出异常", e);
        }

        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        //新建HttpEntity实体
        HttpEntity entity = new HttpEntity(reqMap, headers);

        LOG.info("===============(zqm-->即信端)请求信息：\r\n" + JSON.toJSON(reqMap).toString().replace(",", ",\r\n") + "===================");
        LOG.info("\r\n(P2P-->即信端)发送请求至：" + uri + "\r\n");

        ResponseEntity response = null;
        //请求到即信端
        if (urlStatus == 1) {
            response = restTemplate.exchange(uri, HttpMethod.POST, entity, Map.class);
        } else {
            ResponseEntity<byte[]> html = restTemplate.exchange(uri, HttpMethod.POST, entity, byte[].class);
            LOG.info(html.toString());
            return null;
        }

        //打印响应报文
        LOG.info("===============(即信端-->zqm)响应报文：\r\n" + response.getBody().toString().replace(",", ",\r\n") + "===============");
        Map responseMap = (Map) response.getBody();

        //验签
        String responseSign = (String) responseMap.get("sign");
        responseMap.remove("sign");

        String responseMapMerged = mergeMap(new TreeMap(responseMap));

        boolean verifyResult = SignUtil_lj.verify(responseSign, responseMapMerged.toString());
        if (!verifyResult) {
            LOG.info("(P2P-->即信端)验证签名失败...");
            return null;
        }
        LOG.info("(P2P-->即信端)验证签名成功");
        LOG.info("retCode:" + responseMap.get("retCode"));
        LOG.info("retMsg:" + responseMap.get("retMsg"));

        if (responseMap.get("retCode").equals("00000000")) {
            System.out.println(responseMap.get("retMsg"));
        } else {
            System.out.println(responseMap.get("retMsg"));
        }
        responseMap.put("sign", responseSign);
        return responseMap;
        // assertEquals(verifyResult, true);
    }


    HostnameVerifier hv = new HostnameVerifier() {
        public boolean verify(String urlHostName, SSLSession session) {
            System.out.println("Warning: URL Host: " + urlHostName + " vs. "
                    + session.getPeerHost());
            return true;
        }
    };

    /**
     * 忽略证书信任问题
     *
     * @throws Exception
     */
    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
                .getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
                .getSocketFactory());
    }

    static class miTM implements javax.net.ssl.TrustManager,
            javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(
                java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(
                java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

    }

    /**
     * 获取Map的待签名字符串
     *
     * @param map 请求的参数map
     * @return 签名字符串
     */
    public static String mergeMap(Map<String, String> map) {
        //字典序排序后生成待签名字符串
        Map<String, String> reqMap = new TreeMap<String, String>(map);

        StringBuffer buff = new StringBuffer();

        Iterator<Map.Entry<String, String>> iter = reqMap.entrySet().iterator();
        Map.Entry<String, String> entry;
        while (iter.hasNext()) {
            entry = iter.next();
            if (!"sign".equals(entry.getKey())) {
                if (entry.getValue() == null) {
                    entry.setValue("");
                    buff.append("");
                } else {
                    buff.append(String.valueOf(entry.getValue()));
                }
            }
        }

        String requestMerged = buff.toString();
        return requestMerged;
    }
}
