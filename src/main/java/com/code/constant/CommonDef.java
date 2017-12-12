package com.code.constant;

/**
 * Message Type
 * @author Eric23 2016-01-06
 *
 */
public interface CommonDef {
	
  
	/**
	 * 请求处理成功
	 */
	public static final String JX_SUCCESS_CODE = "00000000";

	/**
	 * 提现处理成功
	 */
	public static final String Withdraw_SUCCESS_CODE="CE999028";
    //版本号
	public static final String VERSION = "10";  
	//交易渠道	000001手机APP
	public static final String CHANNEL_TYPE_APP = "000001";
	//交易渠道	000002网页
	public static final String CHANNEL_TYPE_WEB = "000002";
	//交易渠道	000003微信
	public static final String CHANNEL_TYPE_WECHAT = "000003";
	//交易渠道	000004柜面
	public static final String CHANNEL_TYPE_COUNTER = "000004";
	public static final String CMD = "cmd";
	
	public static final String OPEN_BANK_NAME = "江西银行";
	/**
	 * 普通账户
	 */
	public static final String ACCOUNT_COMMON = "00000";
	/**
	 * 红包账户
	 */
	public static final String ACCOUNT_REDPACKET = "10000";
	/**
	 * 手续费账户
	 */
	public static final String ACCOUNT_FACTORAGE = "01000";
	/**
	 * 担保账户
	 */
	public static final String ACCOUNT_ASSURE = "00100";
	/**
	 * 证件类型为身份证
	 */
	public static final String ID_TYPE_IDENTITY = "01";
	
	/**
	 * 银行代码
	 */
	public static final String BANKCODE = "30050000";
	
	/**
	 * frzFlag	是否冻结金额 0-不冻结   1-冻结
	 */
	public static final String FRZ_FLAG_FALSE = "0";
	/**
	 * frzFlag	是否冻结金额 0-不冻结   1-冻结
	 */
	public static final String FRZ_FLAG_TRUE = "1";
	
	/**
	 * bonusFlag	是否使用红包 1-使用红包
	 */
	public static final String BONUS_FLAG_TRUE = "1";
	
	/**
	 * bonusFlag	是否使用红包 0-不使用红包
	 */
	public static final String BONUS_FLAG_FALSE = "0";
	
	
	/**
	 * 机构代码   （说明：平台需要根据即信端给定实际参数进行调整）     
	 */
	public static final String INSTCODE = "00750001";
	
	
	/**
	 * 银行代码
	 */
	public static final String PRODUCT_QUERY_STATE_ALL = "0";
	/**
	 * 机构代码   （说明：平台需要根据即信端给定实际参数进行调整）     
	 */
	public static final String PRODUCT_QUERY_STATE_VALID = "1";
	/**
	 * 交易币种 156-人民币
	 */
	public static final String CURRENCY_TYPE_RMB = "156";
	
	/**************************提现定义区域↓**********************************/
    /**
     * 提现申请-申请提交
     */
    public final static int CASH_WITHDRAW_APPLYING = 0;
    
    /**
     * 提现申请-提现成功
     */
    public final static int CASH_WITHDRAW_SUCCESSS = 1;
    
    /**
     * 提现申请-提现失败
     */
    public final static int CASH_WITHDRAW_FALSE = 2;
	
	/**************************提现定义区域↑**********************************/
}
