package com.code.common;
/**
 * @description  统一常量定义类
 * @author sen
 */
public class Constants {
	/*start*****************/
 
	/**查询top条数 默认5条**/
	public static final int TOP_LIMIT 						  =5;
	/*end*****************/


	/*start***************/
	/**当天能关注的最多人数**/
	public final static int ATTENTION_USER_TODAY_MAX           = 3;
	/**每天新增关注问题最大值*/
	public static final int ATTENTION_QUESTION_TODAY_MAX       = 20;
	/**每天新增关注存货最大值*/
	public static final int ATTENTION__INVENTORY_TODAY_MAX     = 20;
	/**一个用户最多只能打5个标签*/
	public final static int ATTENTION_USER_LABEL_MAX           =5;
	/**每天收藏问题的上限*/
	public final static int COLLECT_QUESTION_TODAY_MAX         =50;
	/**每天收藏存货的上限*/
	public final static int COLLECT_INVENTROY_TODAY_MAX        =20;
	/*end***************/
	
	/**邀请码的最大个数*/
	public final static int INVITATION_CODE_MAX  =5;
	/**
	 * 默认的分页展示数
	 */
	public final static int LIST_PAGE_SIZE            =20 ;
	
	/**
	 * 用户排行一页显示多少条数据
	 */
	public static final int TOP_USER_PAGE_SIZE = 15 ;
	/**
	 * 
	 */
	public static final int MAX_PAGE = 7 ;
	
	/**
	 * 存货或者问题用户推荐第页数目
	 */
	public final static int INVITE_USER_PAGE_SIZE            =5;
	
	/*start***************/
	
	/**标签页的条数  目前12个1级标签*/
	public final static int LABEL_PAGE_SIZE                    =12; 
	/*end***************/

	
	/*start****/
	/**邀请用户的最大数*/
	public final static int INVITE_USER_PAGESIZE                =2;
	/*end*/
	
    /**
     * 30分钟码一个需要多少积分更换
     */
	public final static int CODE_CHANGE = 500 ;
	/**
	 * 申诉--有人回答时多锁定1天时间
	 */
	public final static int CODE_APPEAL_TIME = 1440  ;
	
	/**
	 * 页面操作提示信息
	 */
	public static final String hint = "hint";
 
	/**
	 * 系统错误提示
	 */
	public static final String systemError ="系统异常,为此造成您的不便请多见谅,请您稍后重试;我们已经把问题记录，并尽快解决" ;
	
	
	/**
	 * spring mvc主动返回 404错误页面
	 */
	public static final String url404 = "/404";
	/**
	 * spring mvc主动返回 500错误页面
	 */
	public static final String url500 = "/500";
	
	/**
	 * 跳转到登录页面的url
	 */
	public static final String toLogin = "redirect:/" ;
	
	/**
	 * 网站根url
	 */
	public static final String baseUrl = "http://www.laibao.me" ;
	
	public static final String desKeySeparate ="_" ;
	/**
	 * cookie盐的最大长度
	 */
	public static final int cookieRandomLength =14 ;
	/**
	 * 用户密码的盐的最大长度
	 */
	public static final int passwordRandomLength =13 ;
	/**
	 * 激活用户密码的盐的最大长度
	 */
	public static final int activateUserLength =13 ;
	/**
	 * 邀请码分隔符
	 */
	public static final String invitationCodeSeparate ="_" ;
	/**
	 * 图片验证码的key
	 */
	public static final String validatePic ="vpc" ;
    /**
     * 系统标签
     */
	public static final Byte systemLabel = 1 ;
    /**
     * 用户标签
     */
	public static final Byte userLabel = 2 ;
	/**上传附件大小*/
	public static final int squeezedFileSize = 1024*1024*10;
	
	/**每天下载次数*/
	public static final int downMaxTimes = 10;
	
	/**存货存储路径*/
	public static final String inventory_path="/uploadfile/inventory/";
	/**头像存储路径*/
	public static final String head_path = "/uploadfile/heads";
	/**
	 * 统计多少名用户
	 */
	public static final int count_user = 100 ;
	
	
	
	
	/**邮件队列最大数*/
	public static final int emailQueueMaxLength = 1000;
	
	
	
	
	
	/**后台管理用的 1-question_answer  2-inventory_answer*/
	public static final int answer_question_type = 1;
	/**后台管理用的 1-question_answer  2-inventory_answer*/
	public static final int answer_inventory_type = 2;
	
	/**后台管理用的 1-question_comment  2-inventory_comment*/
	public static final int comment_question_type = 1;
	/**后台管理用的 1-question_comment  2-inventory_comment*/
	public static final int comment_inventory_type = 2;
	
	/**给QQ批量发送邀请码 最大次数*/
	public static final int  sendQqMax = 5;
	
	
	
	
	
	
	
	
}
