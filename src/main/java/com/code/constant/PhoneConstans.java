package com.code.constant;

public class PhoneConstans {

	/**
	 * 票据审核状态
	 *
	 */
	public enum Channel {
		
		MONTNETS(1, "梦网"),
	    EMAY(2, "亿美");
		
		private Integer id;

		private String name;

		private Channel(Integer id, String name) {
			this.id = id;
			this.name = name;
		}
		public static String getName(Integer id) {
			for (Channel c : Channel.values()) {
				if (id.equals(c.getId())) {
					return c.getName();
				}
			}
			return null;
		}
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	/**
	 * 模版
	 *
	 */
	public enum PhoneTemplate {
		REG(1, "注册短信模板"),
		RESETPSD(2, "重置密码短信模板"),
		RESETPAYPSD(3, "重置支付密码短信模板"),
		BUY(4, "购买短信模板"),
		LOGIN(5, "后台登录模板"),

		PAY(6, "打款给融资企业模版"),
		BINDBANKCARD(7, "绑定成功后短信"),
		EXPIRE(8, "项目到期通知客户模版"),
		NEWEXPIRE(32, "项目到期通知客户模版(新)"),
		PAYFAIL(9, "给企业打款失败"),
		PAYSUCESS(10, "给企业打款成功"),

		REPAYFAIL(11, "给投资人还款失败"),
		REPAYSUCESS(12, "给投资人还款成功"),
		BUYFAIL(13, "购买后，系统操作数据库异常情况下，发送短信"),
		PAYCLIENTFAIL(14, "操作联动优势API出错，发送短信"),
		ACTIVESUCCESS(15, "活动回款短信"),

		ACTIVEMISUCCESS(16, "活动回款短信"),
		ACTIVEHBSUCCESS(17, "红包活动发送成功"),
		ACTIVENOTICEFAIL(18, "活动通知打款失败短信"),
		REPAYUSERSUCESS(19, "项目还款成功通知客户"),
		CANCALBANKCARD(20, "解绑成功后短信"),
		PAYFAILFAIL(21, "失败订单产生或者再次处理失败"),
		OVERSOLD(22, "超卖情况下通知短信"),
		PAYFAILSUCESS(23, "失败订单处理成功"),

		REBINDBANKCARD(24,"更换银行卡成功通知短信"),
		UNBANKCARDCODE(25,"解绑银行卡验证码短信"),

		ACTIVEPHONEREWARD(26,"活动抽奖话费短信"),
		ACTIVEMAILREWARD(27,"活动抽奖邮寄奖品短信"),
		DROPORDERSUCCESS(28,"调单、超卖还款成功后的短信"),

		CHECKBANDPHONE(29,"校验银行预留手机号，绑定银行卡的时候"),
		MESSAGEWARNING(30,"短信余额不足发送短信到负责人手机"),
		DELBANKCARDCODE(31,"删除银行卡"),
		DOEARLYREPAY(33,"执行提前还款，给投资人发送短信"),
		EARLYREPAYSUCESS(34,"项目提前还款成功通知客户模版"),
		EXPIREWITHCARDNO(35,"项目到期通知客户模版(卡号后四位)"),
		NEWEXPIREWITHCARDNO(36,"项目到期通知客户模版(新)(卡号后四位)"),
		ERRORSOLD(37,"对账第三方数据小于本地数据"),
		YEEPAYFAIL(38,"易宝接口出错"),
		YEEPAYNEEDREVIEW(39,"易宝代发代付打款需要登录后台复核，发送短信"),
		BINDBANKCARDSUCCESS(40, "绑定成功后短信(新)"),

		UNPYAORDER(41, "未购买成功的短信数量"),
		NOMALBLLMINIAMOUNT(42, "普通标可购金额小于配置金额"),
		ISNEWBIE_BILL_MINI_AMOUNT(43, "新手标可购金额小于配置金额"),
		JP_PUSH_ERROR(44, "巨品数据推送失败短信"),

		NEWEXPIREWITHCARDNO_ADD_DAY(45,"项目到期通知客户模版(新)(卡号后四位)加日期"),
		DOEARLYREPAY_ADD_DAY(46,"执行提前还款，给投资人发送短信,加日期"),
		BUYPAYFAIL(47, "购买后，第三方报异常情况下，发送短信"),
		DEPOSITPAYREMIND(48, "扣款提醒"),
		DEPOSITPAYSUCCESS(49,"定期扣款成功短信"),
		DEPOSITPAYFAIL(50,"08: 00/14：00定期扣款失败短信"),
		DEPOSITPAYLASTFAIL(51,"20：00定期扣款失败短信"),
		DEPOSITPBUYUCCESS(52,"定存购买成功"),
		GET_ADD_INTEREST(53,"获得加息券"),
		INTERESTOVERDUEREMIND(54,"加息券提前3天到期提醒"),
		FLOW_CALL_BACK_FAIL(55,"流量回调充值失败短信"),
		FLOW_CALL_BACK_SUCCESS(56,"流量回调充值成功短信"),
		BUY_SUCCESS_GET_RED_ENVELOPE(57,"购买分享成功获得红包短信"),
		WXUSER_GET_RED_ENVELOPE(58,"好友微信成功领取红包后获得红包短信"),
		EARLY_REPAY_DONATE_ADD_INTEREST_TICKET(60,"提前还款赠送一张30天的加息券"),
		FRIEND_INVITE_GET_RED_ENVELOPE(59,"好友邀请获得无门槛红包短信"),
		BUY_WITH_RED_EVLELOPE(61,"使用红包购买成功"),
		BUY_WITH_INTEREST(62,"使用加息券购买成功"),
		FINANCINGLOG_OVER_TIME(63,"打款订单超过设定查询时限发送短信"),
		BUYGIVEINTERESTREMIND(64,"加息券活动提醒短信"),
		GETINTERESTREMIND(65,"加息券活动领取短信"),
		DEL_BANK_CARD(66,"解绑银行卡失败"),
		DOU_DI_WARNING_MESSAGE(67,"兜底短信提醒工作人员"),
		FEED_BACK_RED(68,"投资送红包"),
		COST_CALL_BACK_FAIL(69,"话费回调充值失败短信"),
		COST_CALL_BACK_SUCCESS(70,"话费回调充值成功短信"),
		LUCKY_DRAW_PHYSICAL(71,"抽中实物奖品"),
		LUCKY_DRAW_VIRTUAL(72,"抽中虚拟奖品"),
		NEWBIE_COST(73,"新人专享话费"),
		LUCKY_DRAW_INTEREST(74,"抽奖中加息券"),
		FEED_BACK_RED_TOGE(75,"购买送红包合并"),
		ONE_TO_ONE_HB_OVERDUE_REMIND(76,"1:1红包提前3天到期提醒"),
		ANNUAL_YIELD_PRODUCT_AMOUNT_NOT_ENOUGH(77,"短信提醒相对年化的标，可购金额不足"),
		FRIEND_FLOW_READY_50HF_INTEREST(78,"好友首次投资将获得50元话费和1%加息券一张"),
		FRIEND_FLOW_SUCESS_FIRST_INVEST(79,"好友首次投资恭喜获得50元话费和1%加息券一张"),
		FRIEND_FLOW_IDCARD_REPEAT(80,"被邀请人身份信息已存在"),
		SEND_ADD_ADDRESS(81,"督促添加地址"),
		ADD_EXPRESS_NUMBER(82,"快递单寄送地址"),
		PLATFORM_PRO_REWARD_RED_LIMITE(83,"推广送红包（有期限）"),
		PLATFORM_PRO_REWARD_RED(84,"推广送红包（无期限）"),
		PLATFORM_PRO_REWARD_INTEREST(85,"推广送加息券"),
		PLATFORM_PRO_REWARD_FLOW(86,"推广送流量"),
		PLATFORM_PRO_REWARD_COST(87,"推广送话费"),
		PLATFORM_PRO_REWARD_REAL(88,"推广送实物"),
		PLATFORM_PRO_REWARD_VIRTUAL_CODE_PASSWARD(89,"推广送虚拟（卡密类）"),
		PLATFORM_PRO_REWARD_VIRTUAL_CODE_ACTIVE(90,"推广送虚拟（激活码类）"),
		BINDBANKCARDSUCCESS_CARD(91, "绑定成功后短信(新,有银行卡)，给用户"),
		BACK_CARD(92, "后台绑定短信,给用户发送绑卡短信"),
		BACK_CARD_SUCCESS_CARD(93, "绑定成功后短信(新,有银行卡)，给操作员"),
		ACTIVITY_RETURN_ALERT(94,"活动到期提醒"),
		EXPERIENCE_MONEY_REG(95,"注册获得体验金"),
		EXPERIENCE_MONEY_OVERDUE(96,"体验金1或3天到期"),
		EXPERIENCE_MONEY_FIRST_INVEST_REWARD(97,"第一次购买获得20元红包"),
		EXPERIENCE_MONEY_SECOND_INVEST_REWARD(98,"第二次购买获得50元红包和1%加息券"),
		EXPERIENCE_RED_OVERDUE(99,"红包1或3天到期"),
		EXPERIENCE_INTEREST_ALLONE_OVERDUE(100,"1%加息券1或3天到期"),
		EXPERIENCE_INTEREST_NOALLTONE_OVERDUE(101,"加息券1或3天到期"),
		EXPERIENCE_AUTH_CARD(102,"体验金绑卡验证"),
		EXPERIENCE_BEGIN_WITH_RED(103,"体验金起息有红包"),
		EXPERIENCE_BEGIN_WITHOUT_RED(104,"体验金起息无红包"),
		EXPERIENCE_NORMAL_END_WITHOUT_PAY(105,"体验金结息后第二天上午8点（无支付1元钱，工作日）"),
		EXPERIENCE_HOLIDAY_END_WITHOUT_PAY(106,"体验金结息后第二天上午8点（无支付1元钱，非工作日）"),
		EXPERIENCE_NORMAL_END_WITH_PAY(107,"体验金结息后第二天上午8点（有支付1元钱，工作日"),
		EXPERIENCE_HOLIDAY_END_WITH_PAY(108,"体验金结息后第二天上午8点（有支付1元钱，非工作日）"),
		
		EXPERIENCE_REPAY_SERSUCESS(109,"体验金收益到账"),
		EXPERIENCE_REPAYSUCESS(110,"某天体验金全部还款成功"),
		
		NOTICE_RED_ENVELOPE(111,"有红包未使用通知短信"),
		
		NOTICE_INTEREST(112,"有加息券未使用通知短信"),
		ADD_API_BLACK_IP(113,"api拉黑发短信"),
		
		EX_COUNT(114,"体验金数量短信"),
		
		FRIEND_CASH_IDCARD_REPEAT(115,"被邀请人身份信息已存在"),
		FRIEND_CASH_FIRST_INVEST(116,"好友首次投资获得50元话费"),
		FRIEND_CASH_INVEST_RED_5K(117,"好友投资获得50元红包5K"),
		FRIEND_CASH_INVEST_RED_1W(118,"好友投资获得50元红包1W"),
		FRIEND_HALVE_3W_CASH(119,"平分3W元现金"),
		MID_AUTUMN_FESTIVAL_INTEREST(120,"中秋送加息券"),
		BUY_EXCEPTION_REPARATION_RED(121,"购买异常补发红包"),
		FRIEND_GATHER_FIRST_INVEST(122,"好友首次投资获得30元红包"),
	
		CLM_CURRENT_DAY_DEPOSIT(123, "存了么当天存钱提醒"),
		CLM_THE_SECOND_DAY_DEPOSIT(124, "存了么第2天存钱提醒"),
		CLM_LAST_DAY_IN_MONTH_DEPOSIT(125, "存了么本月最后1天存钱提醒"),
		CLM_SEVEN_DAYS_IN_ADVANCE_DEPOSIT(126, "存了么前7天存钱提醒"),
		INVEST_RANK_READY_PUBLISH(127,"本周投资风云榜即将揭晓"),
		INVEST_RANK_NOTICE_REWARD(128,"上周投资风云榜通知奖励"),
		INVEST_RANK_GIVE_REWARD(129,"上周投资风云榜发放奖励"),
		CLM_REMIND_BUY(130, "存钱计划提醒复投"),
		GOLD_AUTUMN_INTEREST(131,"惠享金秋送加息券"),
		
		EXPERIENCE_MONEY_FIRST_INVEST_REWARD_NEW(132,"第一次购买获得20元红包和0.5%加息券"),
		EXPERIENCE_FIRST_INVEST_RED_OVERDUE(133,"首次投资红包1天到期"),
		EXPERIENCE_FIRST_INVEST_INTEREST_OVERDUE(134,"首次投资加息券1天到期"),
		BIRTHDY_TICKET(135,"周岁元红包和1%加息券"),
		
		FIRST_INVEST_REWARD_NEWBIE_MIAO(136,"第一次购买获得20元红包和0.5%加息券"),
		SECOND_INVEST_REWARD_NEWBIE_MIAO(137,"第二次购买获得50元红包和1%加息券"),
		FIRST_INVEST_OVERDUE_REWARD_NEWBIE_MIAO(138,"第一购买新喵福利过期投资奖励"),
		SECOND_INVEST_OVERDUE_REWARD_NEWBIE_MIAO(139,"第二购买新喵福利过期投资奖励"),
		REG_SECOND_DAY_NOT_INVEST_REMIND(140,"注册第二日未投资提醒"),
		// 平分5W
		FRIEND_HALVE_5W_CASH(141,"平分5W元现金"),
		NEWBIE_MIAO_REG_4DAY_SMS(142,"用户注册之后第4天未投资"),
		NEWBIE_MIAO_REG_8DAY_SMS(143,"用户注册之后第8天未投资"),
		FY_PAY_TIMEOUT(144, "富友支付异步回调超时"),
        FIRST_INVEST_REWARD_NEWBIE_MIAO6(151, "第一次购买可激活20元红包和0.5%加息券"),
        SECOND_INVEST_REWARD_NEWBIE_MIAO6(152, "注册后20天累计投资30000可激活50元红包和1%加息券"),
        THREE_INVEST_REWARD_NEWBIE_MIAO6(153, "注册后25天累计投资100000可激活110元红包"),
        FOUR_INVEST_REWARD_NEWBIE_MIAO6(154, "注册后30天累计投资200000可激活198元红包"),
        FIVE_INVEST_REWARD_NEWBIE_MIAO6(155, "注册后30天累计投资500000可激活288元红包"),
		MERCHANT_LOGIN(156, "融资方登陆"),
		;

		private Integer value;

		private String name;

		private PhoneTemplate(Integer value, String name) {
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
}