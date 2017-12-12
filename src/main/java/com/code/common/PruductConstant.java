package com.code.common;


public class PruductConstant {
	
	/**
	 * 产品类型 1：安盈宝  2票据债权 3.月光宝 4.车盈宝
	 *
	 */
	public enum BillType {
	    AYB(1, "安盈宝"),
	    PJZQ(2, "票据债权"),
	    YGB(3, "月光宝"),
	    CAR_YGB(4, "车贷-月光宝"),
	    CYB(5, "车盈宝"),
	    JP(6, "机票"),
	    HTW(7, "会唐网"),
		DCZY(8,"应收保理"),
		KZ(9,"课栈"),
		TRAVEL(10,"旅游"),
		CAR(11,"汽车"),
		HSSY(12,"婚纱摄影"),
		SH(13,"石化")
	    ;
		
		private Integer value;

		private String name;

		private BillType(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (BillType c : BillType.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
		}
		
		public static BillType getBillTypeByName(String name) {
			for (BillType c : BillType.values()) {
				if (name.equals(c.getName())) {
					return c;
				}
			}
			return null;
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
	 * 发布类型 1：安盈宝  2.月光宝 
	 *
	 */
	public enum PubType {
	    AYB(1, "安盈宝"),
	    YGB(2, "月光宝");
		
		private Integer value;

		private String name;

		private PubType(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			if(value == null){
				return  null;
			}
			for (PubType c : PubType.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
		}


		/**
		 * 根据资产类型获取发布类型
		 * @param productType 资产类型
         * @return
         */
		public static PubType[] getPubType(Integer productType){
			//票据与车贷有安盈宝和月光宝、其他资产只有安盈宝
			PubType[] pubs;
			if(BillType.AYB.getValue().equals(productType) || BillType.YGB.getValue().equals(productType)
					|| BillType.CYB.getValue().equals(productType) || BillType.CAR_YGB.getValue().equals(productType)){
				pubs = PubType.values();
			}else{
				pubs = new PubType[]{PubType.AYB};
			}
			return pubs;
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
	 * 来源状态 1：银承库  2融数
	 *
	 */
	public enum FromType {
	    YCK(1, "银承库"),
	    RS(2, "融数");
		
		private Integer value;

		private String name;

		private FromType(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			if(value == null){
				return null;
			}
			for (FromType c : FromType.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 票据审核状态
	 *
	 */
	public enum BillStatus {
		UNCONFIRM(-1, "待确认"),
	    UNPUBLISH(0, "待排期"),
	    ARRANGE(1, "待审核"),
	    UNPASS(2, "审核未通过"),
	    PASSED(3, "待发布"),
	    PUBlISHED(4, "募集中"),
	    DELETED(5, "已删除"),
	    UNPAY(6, "待打款"),
	    UNREPAY(7, "待还款"),
	    REPAY(8, "已还款");
		
		private Integer value;

		private String name;

		private BillStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (BillStatus c : BillStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 定存状态
	 *
	 */
	public enum DepositStatus {
		
		UNPUBLISH(1, "未发布"),
		AreSALES(2, "募集中"),
		SOLDOUT(3, "募集完成"),
		CARRY_INTEREST(4, "进行中"),
		REPAYED(5, "已结束");
		
		private Integer value;

		private String name;

		private DepositStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (DepositStatus c : DepositStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	// 步骤 1.未打款 2 打款进行中 3 打款失败  4 未还款  5 还款进行中  6 还款失败 7还款成功  
	/**
	 * 票据打款状态
	 *
	 */
	public enum BillStatusStep {
	    UNPAY(1, "未打款"),
	    PAYING(2, "打款进行中"),
	    PAYFAIL(3, "打款失败"),
	    
	    UNREPAY(4, "未还款"),
	    REPAYING(5, "还款进行中"),
	    REPAYFAIL(6, "还款失败"),
	    REPAYED(7, "还款成功");
	    
		private Integer value;

		private String name;

		private BillStatusStep(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (BillStatusStep c : BillStatusStep.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 票据销售状态
	 *
	 */
	public enum BillSaleStatus {

		AreSALES(0, "抢购中"),
		FORSALE(1, "即将开抢"),
		SOLDOUT(2, "募集成功"),
		CARRY_INTEREST(3, "已起息"),
		REPAYMENT(4, "已还款"),
		REPAYING(5, "还款中");
		
		private Integer value;

		private String name;

		private BillSaleStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (BillSaleStatus c : BillSaleStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	
	// 步骤   注：0 对账成功，不放入数据库   状态 1：未提现   2:提现中 3：提现失败  4提现成功
	/**
	 * 票据打款状态
	 *
	 */
	public enum WithdrawStatus {
		
	    UNWITHDRAW(1, "未回款"),
	    WITHDRAWING(2, "银行回款中"),
	    WITHDRAWFAIL(3, "回款失败"),
	    WITHDRAWED(4, "已回款");
	    
		private Integer value;

		private String name;

		private WithdrawStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}

		public static String getName(Integer value) {
			for (WithdrawStatus c : WithdrawStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
		}

		public static WithdrawStatus[] unRepayStatus(){
			return new WithdrawStatus[]{UNWITHDRAW,WITHDRAWING,WITHDRAWFAIL};
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
	 * 前台个人投资显示状态
	 * @author yangshuai
	 *
	 */
public enum FrontStatus {

	    UN_INTEREST(1, ""),//未起息前台不显示
	    CARRY_INTEREST(5, "已起息(结息后1-3个工作日还款)"),
	    /**
	     * 未还款，前台显示还款中
	     */
	    UN_REPAY(6, "已结息(1-3个工作日还款)"),
	    REPAYING(2, "银行回款中"),
	    REPAYFAIL(3, "已还款银行处理失败"),
	    REPAYED(4, "已回款 ");
	    
	    /**
	     * 数据库对应状态，对前台的时候，就是要将1分解为1、5、6，
	    UNWITHDRAW(1, "未还款"),
	    WITHDRAWING(2, "还款进行中"),
	    WITHDRAWFAIL(3, "还款失败"),
	    WITHDRAWED(4, "还款成功");
	     */
	    
		private Integer value;

		private String name;

		private FrontStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (FrontStatus c : FrontStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 产品分类
	 * @author xiaohei
	 *
	 */
	public enum ProductType {
	    BILL(1, "票据"),
	    DEPOSIT(2,"定存宝"),
		EXPERIENCE_MONEY(3,"体验金");
		
		private Integer value;

		private String name;

		private ProductType(Integer value, String name) {
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
	
	public enum UserProductStatus {
	    HOLD(1, "持有"),
	    ALLOW_WITHDRAW(2, "允许提现"),
	    WITHDRAWED(3, "已提现");
		
		private Integer value;

		private String name;

		private UserProductStatus(Integer value, String name) {
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
	
	public enum UserProtocolStatus {
	    PLEDGE(1, "质押协议"),
	    DELEGATE(2, "委托协议"),
	    DEBT_TRANSFER(3, "债权转让协议"),
	    PLATFORM_SERVICE(4,"平台服务协议"),
	    DEPOSIT_PAY(5,"存一笔服务协议"),
	    JP(6,"机票协议"),
	    HTW(7,"会唐网协议"),
		DCZY(8,"动产质押保理协议"),
		KZ(9,"课栈保理协议"),
		TRAVEL(10,"旅游保理协议"),
		CAR(11,"汽车保理协议"),
		HSSY(9,"婚纱摄影保理协议"),
		SH(8,"石化协议"),
		;
		
		private Integer value;

		private String name;

		private UserProtocolStatus(Integer value, String name) {
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
	
	public enum PayFailType {
	    PAY(1, "打款"),
	    REPAY(2, "还款"),
	    ACTIVITY(3, "活动"),
	    DROP(4, "掉单"),
	    OVERSOLD(5,"超卖"),
	    
	    EXPERIENCE_DROP(6,"体验金掉单"),
	    EXPERIENCE_REPAY(7,"体验金还款"),
	    ;
		
		private Integer value;

		private String name;

		private PayFailType(Integer value, String name) {
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
	
	public enum PayFailStatus {
		
		UNPAY(1, "未处理"),
		PAYFAIL(2, "退款失败"),
		PAYING(3, "退款进行中"),
		PAYED(4, "退款成功"),
		ALIPAY(5, "已通过支付宝还款成功"),
		FILEPAY(6, "已通过文件还款成功");
		
		private Integer value;

		private String name;

		private PayFailStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		public static String getName(Integer value) {
			for (PayFailStatus c : PayFailStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 购买资产匹配状态
	 */
	public enum ProductAssetStatus {
		
		PERSENT_HOLD(0, "当前持有"),
		HISTROY_HOLD(1, "历史持有");
		
		private Integer value;

		private String name;

		private ProductAssetStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (ProductAssetStatus c : ProductAssetStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 资产状态
	 */
	public enum AssetStatus {
		
		PERSENT_HOLD(0, "当前持有"),
		HISTROY_HOLD(1, "历史持有");
		
		private Integer value;

		private String name;

		private AssetStatus(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (AssetStatus c : AssetStatus.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	 * 资产变动日志状态
	 */
	public enum AssetChangLogType {
		
		ADD(0, "新增"),
		MODIFY(1, "修改"),
		DELETE(2, "删除");
		
		private Integer value;

		private String name;

		private AssetChangLogType(Integer value, String name) {
			this.value = value;
			this.name = name;
		}
		
		public static String getName(Integer value) {
			for (AssetChangLogType c : AssetChangLogType.values()) {
				if (value.equals(c.getValue())) {
					return c.getName();
				}
			}
			return null;
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
	
	public enum CompanyCode {

		SHJJ("RSFN20160425", "上海君记商业保理有限公司"),
		SFRZ("RSFN20160225", "盛繁融资租赁(上海)有限公司"),
		FYSY("RSFN20160830", "沣盈商业保理有限公司"),
		DLPG("PJWTRZ20160315", "大连盘古贸易有限公司"),
		DLYJY("PJWTRZ20170112", "大连溢佳源商贸有限公司"),
		DLXYY("05110589X", "大连喜扬扬商贸有限公司");

		private String value;

		private String name;

		CompanyCode(String value, String name) {
			this.value = value;
			this.name = name;
		}

		public static CompanyCode getItem(String value){
			for (CompanyCode type : CompanyCode.values()) {
				if(type.getValue().equals(value)){
					return type;
				}
			}
			return null;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
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
