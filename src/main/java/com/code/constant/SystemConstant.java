package com.code.constant;


public class SystemConstant {
	
	public static final String SPLIT_STR = "\\{@\\}";
	
	public enum RoleStatus {

	    INUSE(1, "使用中"),
	    DELETE(2, "已删除");

		private Integer value;

		private String name;

		private RoleStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 资金类型
	 * @author xiaohei
	 *
	 */
	public enum CapitalType {

	    BALANCE(1, "余额"),
	    VOUCHER(2, "理财本金");

		private Integer value;

		private String name;

		private CapitalType(Integer value, String name) {
			this.value = value;
			this.name = name;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	public enum Conf {
		
		MIN_MESSAGE_WARNING("min_message_warning","最小短信余量警告"),
		FINACE_RATE("finace_rate","融资利率"),
		GETUI("getui_notice_test_phone","各推"),
		API_IP_INTERCEPT_FLAG("api_ip_intercept_flag","api的ip拦截状态"),
		API_IP_WHITE("api_ip_white","api访问白名单"),
		SEND_MESSAGE_CHANNEL_1("send_message_channel_1","短信通道1"),
		SEND_MESSAGE_CHANNEL_2("send_message_channel_2","短信通道2"),
		MODULES_VERSION("modulles_version","模版替换配置"),
		MODULES_VERSION_V2("modulles_version_v2","模版替换配置2"),
		MODULES_VERSION_H5_ANDROID("modulles_version_h5_android","模版替换配置全盘h5安卓"),
		MODULES_VERSION_H5_IOS("modulles_version_h5_ios","模版替换配置全盘h5ios"),
		MODULES_VERSION_H5_IOS_IN_RELEASE("modulles_version_h5_ios_in_release","模版替换配置全盘h5ios-发布中"),
		
		BLACK_LIST_CHECK_FLAG("black_list_check_flag","黑名单列表检查开关"),
		/**
		 * 1:是，校验，0：否,不校验
		 */
		CHECK_COMMAUTH_FLAG("check_commAuth_flag","校验4要素状态"),
		
		/**
		 * 我们平台一分钱扣款状态
		 * 1:开启，0：不开启
		 */
		A_PENNY_FLAG("a_penny_flag","一分钱扣款状态"),
		USER_BIND_BANK_CARD_MAX_LIMIT("user_bind_bank_card_max_limit","用户最大绑卡数量限制"),
		PAY_INVESTOR_CHANNEL("pay_investor_channel","给投资人还款渠道"),
		ANNUAL_YIELD_PLUS_XYP("annual_yield_plus_xyp","月光宝新人标加息收益率"),
		ANNUAL_YIELD_PLUS_XYP_AYB("annual_yield_plus_xyp_ayb","安盈宝新人标加息收益率"),
		INVESTOR_ANNUAL_YIELD_XYP("investor_annual_yield_xyp","小银票给投资人的年化收益率"),
		NOMAL_BILL_MINI_AMOUNT("nomal_bill_mini_amount","普通标最小配置金额"), 
		ISNEWBIE_BILL_MINI_AMOUNT("isNewbie_bill_mini_amount","新手标最小配置金额"),
		BILL_END_TIME_ADD_DAY("bill_end_time_add_day","票据理财时间增加的天数"),
		HOLIDAY("holiday","节假日(格式：2015-10-01,2015-10-02,2015-10-03)"),	
		BANK_RATE("bank_rate","银行活期利率"),
		YUEBAO_BANK("yuebao_rate","余额宝利率"),
		IOS_APP_VERSION("iosappVersion","ios提示升级版本"),
		ANDRIOD_APP_VERSION("androidappVersion","安卓提示升级版本"),
		LOWEST_RUN_IOS_APP_VERSION("LowestRunIosappVersion","ios最低版本"),
		LOWEST_RUN_ANDRIOD_APP_VERSION("LowestRunAndroidappVersion","安卓最低版本"),
		DOWNLOAD_URL("downloadUrl","安卓下载地址"),

		MENU_BAR("menuBar","菜单栏"),
		MENU_BAR_VERSION("menuBarVersoin","菜单栏版本"),
		
		START_PAGE_ANDROID("startPageAndroid","安卓启动页"),
		START_PAGE_ANDROID_VERSION("startPageAndroidVersoin","安卓启动页版本"),
		
		START_PAGE_IOS("startPageIos","ios启动页"),
		START_PAGE_IOS_VERSION("startPageIosVersoin","ios启动页版本"),
		START_PAGE_IOS_COUNT("startPageIosCount","ios引导页图片数量"),

		
		
		
		GUIDE_PAGE_ANDROID("guidePageAndroid","安卓引导页"),
		GUIDE_PAGE_ANDROID_VERSION("guidePageAndroidVersoin","安卓引导页版本"),
		GUIDE_PAGE_ANDROID_COUNT("guidePageAndroidCount","安卓引导页图片数量"),
		
		GUIDE_PAGE_IOS("guidePageIos","ios引导页"),
		GUIDE_PAGE_IOS_VERSION("guidePageIosVersoin","ios引导页版本"),
		UPDATE_FEE_FALG("update_fee_flag","更新手续费状态"),
		TAB("tab","底部按钮"),
		DEPOSIT_INVESTOR_ANNUAL_YIELD("deposit_investor_annual_yield","定存宝投资人利率"),
		DEPOSIT_FINACE_ANNUAL_YIELD("deposit_finace_annual_yield","定存宝融资方利率"),
		FINACE_COMPANY_ID("finace_company_id", "融资方ID"),
		HAVE_REWARD("have_reward", "注册送加息券和100M流量"),

		SHAREINFO_TITLE("shareinfo_title", "活动分享的title"), 
		SHAREINFO_ICON("shareinfo_icon", "活动分享的icon"), 
		SHAREINFO_HEADER("shareinfo_header", "活动分享的header"),
		EARLY_REPAY_DONATE_ADD_INTEREST_TICKET("early_repay_donate_add_interest_ticket","提前还款是否赠送加息券"),
		NEW_GIFT_PACKAGE("new_gift_package", "新人大礼包"),
		
		PJ_RATE("pj_rate", "票据利率"),//0<x<=60:5.0,60<x<=90:5.2,90<x<=120:5.4,120<x:5.6
		BL_RATE("bl_rate", "保理利率"),//0<x<=50:5.0,50<x<=80:5.2,80<x<=110:5.4,110<x:5.6
		PJ_RATE_PRIORITY("pj_rate_priority", "票据利率优先级"),//5.0>5.2>5.4>5.6
		BL_RATE_PRIORITY("bl_rate_priority", "保理利率优先级"),//5.6>5.4>5.2>5.0

		BL_FINANCE_BEGIN_TIME_ADD("bl_finance_begin_time_add","保理融资起息时间增加天数"),
		VALUE_BEGIN_TIME_ADD("value_begin_time_add","投资起息时间增加天数"),
		YGB_LENGTH("ygb_length","月光宝期限"),
		AYB_QI_SHU("ayb_qi_shu","安盈宝当前期数"),
		YGB_QI_SHU("ygb_qi_shu","月光宝当前期数"),
		BL_PJ_PRIORITY("bl_pj_priority", "保理票据优先级"),//1.保理优先，0，票据优先
		NEW_BIE_ANNUAL_BASE_YIELD("new_bie_annual_base_yield","新手标基础年化收益率"),
		COMMON_PRODUCT_COUNT("common_product_count","普通情况下产品数量"),//4
		AUTO_PUB("auto_pub","自动发布项目"),//1
		IP_TEST("ip_test","测试ip"),//1.1.1.1
		ANDRIOD_APP_VERSION_TEST("androidappVersion_test","安卓提示升级版本测试"),
		LOWEST_RUN_ANDRIOD_APP_VERSION_TEST("LowestRunAndroidappVersion_test","安卓最低版本测试"),
		PJ_ASSET_ALLOCATION_LENGTH("pj_asset_allocation_length","票据资产分布期限间隔"),
		BL_ASSET_ALLOCATION_LENGTH("bl_asset_allocation_length","保理资产分布期限间隔"),
		NEW_BIE_MIN_AMOUNT("new_bie_min_amount","新人标最小起投金额"),
		NORMAL_MIN_AMOUNT("normal_min_amount","普通标最小起投金额"),
		WARNING_AMOUNT("warning_amount","兜底提醒金额"),
		NEW_BIE_PAY_MAX_AMOUNT("newbiePayMaxAmount","新手标购买最大金额"),//5000
		REG_USER_COUNT_ADD("reg_user_count_add", "已注册用户数量（假）"),
		UM_PAY_ERROR_MSG("um_pay_error_msg","联动资金归集错误信息"),//,支付超时,购买异常,
		UM_KUAIJIE_ERROR_MSG("um_kuaijie_error_msg","联动快捷错误信息"),//,支付超时,购买异常,
		FY_PAY_ERROR_MSG_CAN_BIND_CARD("fy_pay_error_msg_can_bind_card","富友可以认定绑卡成功的错误信息"),//余额不足，超限等可以认为绑卡成功的信息
		UM_KUAI_JIE_PAY_ERROR_MSG_CAN_BIND_CARD("um_kuai_jie_pay_error_msg_can_bind_card","联动快捷可以认定绑卡成功的错误信息"),//余额不足，超限等可以认为绑卡成功的信息
		UM_KUAI_JIE_PAY_ERROR_AUTH_MSG("um_kuai_jie_pay_error_auth_msg","联动快捷支付四要素错误信息"),
		FY_PAY_ERROR_AUTH_MSG("fy_pay_error_auth_msg","富友支付四要素错误信息"),
		UPDATE_USER_BANK_CARD_NAME_JOP_OPEN_FLAG("update_user_bank_card_name_jop_open_flag","校验用户银行卡任务开启状态"),
		IF_LESS_FIFTY_NAMED_AYG_FLAG("if_less_fifty_named_ayg_flag","如果期限小于等于15天命名为月光宝"),
		VIP_PRODUCT_ANNUAL_YIELD("vip_product_annual_yield","vip项目总年化收益率"),
		VIP_LESS_AMOUNT("vip_less_amount","VIP累计最少投资金额"),
		ANNUAL_YIELD_PRODUCT_AMOUNT_NOT_ENOUGH("annual_yield_product_amount_not_enough","年化收益提醒金额JSON字符串"),
		ANNUAL_YIELD_PRODUCT_AMOUNT_NOT_ENOUGH_JOB_SWITCH("annual_yield_product_amount_not_enough_job_switch","年化对应金额不足任务开关"),
		PLATFORMPRO("platformPro", "推广活动配置"),
		BANK_PHONE_ERROR_WHEN_ADD_PHONE("bank_phone_error_when_add_phone", "提额下单，预留手机号错误"),
		ORDER_BUSY_ERROR_WHEN_ADD_PHONE("order_busy_error_when_add_phone", "提额下单，下单过于频繁"),
		OTHER_ERROR_WHEN_ADD_PHONE("other_error_when_add_phone", "提额下单，其他错误"),
		API_REQUEST_LIMIT_PRODUCT("api_request_limit_product", "api接口，非客户端调用最大限制范围"),
		API_BLACK_IP_OPEN_FLAG("api_black_ip_open_flag", "api接口黑名单开启状态"),
		API_BLACK_IP_TIME_MS("api_black_ip_time_ms", "api接口请求超限间隔（毫秒）"),
		API_BLACK_IP_MAX_COUNT("api_black_ip_max_count", "api接口请求间隔内最大请求次数"),
		API_BLACK_IP_DISABLE_TIME("api_black_ip_disable_time", "api接口屏蔽时间（秒）"),
		API_BLACK_IP_WHITE_IP("api_black_ip_white_ip", "api接口禁用白名单"),
		FUTURE_HOLIDAY("future_holiday","未来节假日(格式：[{\"endTime\":\"2016-12-30\",\"holidayName\":\"元旦\",\"repayTime\":\"2016-12-31\"},{\"endTime\":\"2016-12-31\",\"holidayName\":\"元旦\",\"repayTime\":\"2017-01-04\"}])"),
		SEND_CODE_BLACK_IP_MAX_COUNT("send_code_black_ip_max_count", "发送验证码接口请求间隔内最大请求次数"),
		SEND_CODE_BLACK_IP_TIME_MS("send_code_black_ip_time_ms", "发送验证码接口超限间隔（毫秒）"),
		CHANNEL_DEPLOY("channelDeploy", "渠道配置"),
		ANDROID_VERSION_NEEDED_UPDATE("android_version_needed_update", "安卓需要提示升级的版本号"),
		SECURITY_TOP_BANNER("securityTopBanner", "重点页面安全保障banner配置"),
		EX_BIND_CARD_BLACK_IP_MAX_COUNT("ex_bind_card_black_ip_max_count", "体验金绑卡接口请求间隔内最大请求次数"),
		EX_BIND_CARD_BLACK_IP_TIME_MS("ex_bind_card_black_ip_time_ms", "体验金绑卡接口超限间隔（毫秒）"),
		
		EX_USER_COUNT_P("ex_user_count_p", "当天每次体验金收益XX个就发送短信"),
		NEED_SHOW_REWARD("needShowReward", "需要显示的奖品"),
		REPAY_LOG_UPDATE_JOB_OPEN("repay_log_update_job_open", "还款任务查询开启状态"),
		
		CLM_INTRODUCE("clm_introduce", "存了么app介绍"),
		CLM_IOS_APP_VERSION("clm_iosappVersion","存了么ios提示升级版本"),
		CLM_ANDRIOD_APP_VERSION("clm_androidappVersion","存了么安卓提示升级版本"),
		CLM_LOWEST_RUN_ANDRIOD_APP_VERSION("clm_lowestRunAndroidappVersion","存了么安卓最低版本"),
		CLM_LOWEST_RUN_IOS_APP_VERSION("clm_lowestRunIosappVersion","存了么ios最低版本"),
		CLM_IOS_APP_FEEDBACK("clm_ios_app_feedback","存了么ios下载链接"),
		CLM_MODULES_VERSION_H5_ANDROID("clm_modulles_version_h5_android","存了么模版替换配置安卓"),
		CLM_MODULES_VERSION_H5_IOS("clm_modulles_version_h5_ios","存了么模版替换配置ios"),
		CLM_DOWNLOAD_URL_ANDROID("clm_download_url_android","存了么安卓下载链接"),
		
		
		CLM_MENU_BAR("clm_menuBar","存了么菜单栏"),
		CLM_MENU_BAR_VERSION("clm_menuBarVersoin","存了么菜单栏版本"),
		CLM_START_PAGE_ANDROID("clm_startPageAndroid","存了么安卓启动页"),
		CLM_START_PAGE_ANDROID_VERSION("clm_startPageAndroidVersoin","存了么安卓启动页版本"),
		
		CLM_START_PAGE_IOS("clm_startPageIos","存了么ios启动页"),
		CLM_START_PAGE_IOS_VERSION("clm_startPageIosVersoin","存了么ios启动页版本"),
		CLM_START_PAGE_IOS_COUNT("clm_startPageIosCount","存了么ios引导页图片数量"),
		
		CLM_GUIDE_PAGE_ANDROID("clm_guidePageAndroid","存了么安卓引导页"),
		CLM_GUIDE_PAGE_ANDROID_VERSION("clm_guidePageAndroidVersoin","存了么安卓引导页版本"),
		CLM_GUIDE_PAGE_ANDROID_COUNT("clm_guidePageAndroidCount","存了么安卓引导页图片数量"),
		
		CLM_GUIDE_PAGE_IOS("clm_guidePageIos","存了么ios引导页"),
		CLM_GUIDE_PAGE_IOS_VERSION("clm_guidePageIosVersoin","存了么ios引导页版本"),
		CLM_TAB("clm_tab","存了么底部按钮"),
		
		;
		
		
		
		private String attr;

		private String name;
		
		private Conf(String attr, String name) {
			this.attr = attr;
			this.name = name;
		}

		public String getAttr() {
			return attr;
		}

		public void setAttr(String attr) {
			this.attr = attr;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	public enum OperatorConf {
		/**
		 * 巨品往抓钱猫推送开启状态
		 */
		JP_PUSH_OPEN_FLAG("jp_push_open_flag","巨品往抓钱猫推送开启状态"),
		/**
		 * 抓钱猫往巨品推送开启状态
		 */
		TO_JP_PUSH_OPEN_FLAG("to_jp_push_open_flag","抓钱猫往巨品推送开启状态"),
		/**
		 * 助力加息活动，领取加息券人数
		 */
		ADD_INTEREST_COUNT("add_interest_count", "助力加息活动，领取加息券人数"),
		/**
		 * 助力加息活动，领取加息券人数增加范围
		 */
		ADD_INTEREST_RANGE("add_interest_range", "助力加息活动，领取加息券人数增加范围"),
		/**
		 * 助力加息活动，领取加息券人数
		 */
		RED_PACKET_COUNT("red_packet_count", "红包活动，领取红包人数"),
		/**
		 * 助力加息活动，领取加息券人数增加范围
		 */
		RED_PACKET_RANGE("red_packet_range", "红包活动，领取红包人数增加范围"),
		/**
		 * 签到活动，签到人数
		 */
		SIGN_COUNT("sign_count", "签到活动，签到人数"),
		/**
		 * 签到活动，签到人数增加范围
		 */
		SIGN_RANGE("sign_range", "签到活动，签到人数增加范围"),
		/**
		 * 新人大礼包，领取人数
		 */
		NEW_GIFT_PACKET_COUNT("new_gift_packet_count", "新人大礼包，领取人数"),
		/**
		 * 新人大礼包，领取人数增加范围
		 */
		NEW_GIFT_PACKET_RANGE("new_gift_packet_range", "新人大礼包，领取人数增加范围"),
		/**
		 * 开放式安全套接层协议(https)
		 */
		IS_OPEN_SSL("is_open_ssl", "开放式安全套接层协议(https)"),
		/**
		 * 网站域名
		 */
		WEB_DOMAIN("web_domain", "网站域名"),
		/**
		 * 领取体验金人数增加范围
		 */
		EXPERIENCE_MONEY_RANGE("experience_money_range", "领取体验金人数增加范围"),
		/**
		 * 领取体验金人数
		 */
		EXPERIENCE_MONEY_COUNT("experience_money_count", "领取体验金人数"),
		;
		
		private String attr;

		private String name;
		
		private OperatorConf(String attr, String name) {
			this.attr = attr;
			this.name = name;
		}

		public String getAttr() {
			return attr;
		}

		public void setAttr(String attr) {
			this.attr = attr;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
}
