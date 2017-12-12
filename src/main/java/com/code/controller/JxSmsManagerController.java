/**
 * 
 */
package com.code.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.code.common.JsonWrapper;
import com.code.model.JxActivityUrlBuild;
import com.code.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.common.Constants;
import com.code.model.JxActivityUrl;
import com.code.service.JxSmsManagerService;
import com.code.session.SessionProvider;
import com.code.util.CustomizedPropertyConfigurer;
import com.zqm.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 短信相关controller
 * @author:云风
 * @CreateTime:2017年7月27日
 */
@Controller
@RequestMapping("/sms/")
public class JxSmsManagerController extends BaseController{

	private final static Logger logger = LoggerFactory.getLogger(JxSmsManagerController.class);
	@Resource
    private SessionProvider session;
	@Resource
	private JxSmsManagerService jxSmsManagerService;
	/**
	 * 查询记录
	 * @return
	 */
	@RequestMapping("quertyRecord")
	public String getQuertyRecord(HttpServletRequest request,ModelMap model,String startTime,String endTime,
            Integer userId,Integer activityId,Integer batchId,String phone,@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int numPerPage){
		// 所有参数都为空时,不请求接口
		if (StringUtils.isBlank(startTime)&&StringUtils.isBlank(endTime)&&StringUtils.isBlank(phone)
			&&userId==null&&activityId==null&&batchId==null) {
			return "jxSms/quertyRecord";
		}
		// 开始时间不能为空
		if (StringUtils.isBlank(startTime)) {
			startTime = CustomizedPropertyConfigurer.getContextProperty("jx.sms.start.date");
		}else{
			model.addAttribute("startTime", startTime); // 开始时间
		}
		Integer jxUserId = session.getLoginUserId(request);
    	if (jxUserId==null) {
    		model.addAttribute(Constants.hint, "未登录或登录已过期,请重新登录!");// 提示未登录
    		logger.error("getQuertyRecord查询活动点击记录,用户未登录或登录过期");
    		return "jxSms/quertyRecord";
		}
    	
    	try {
    		// 分页
    		@SuppressWarnings("rawtypes")
			Page pageHelper = PageHelper.startPage(page, numPerPage);
			// 查询数据列表
    		List<JxActivityUrl> list = jxSmsManagerService.getQuertyRecordList(userId, activityId, batchId, phone,
					startTime, endTime);
			model.addAttribute("result", list);// 列表
			model.addAttribute("endTime", endTime); // 结束时间
			model.addAttribute("phone", phone); // 用户id
			model.addAttribute("userId", userId); // 用户id
			model.addAttribute("activityId", activityId); // 活动id
			model.addAttribute("batchId", batchId); // 批次号
			model.addAttribute("page", page);// 当前页
			model.addAttribute("numPerPage", numPerPage); // 每页条数
			model.addAttribute("totalRows", pageHelper.getTotal()); // 总条数
		} catch (Exception e) {
			logger.error("查询活动点记录出现异常", e);
		}
		return "jxSms/quertyRecord";
	}


	/**
	 * 生成短链接页面
	 * @return
	 */
	@RequestMapping("createLink")
	public String createLink(HttpServletRequest request,
							  HttpServletResponse response, ModelMap modelMap) {
		return "/jxSms/createLink";
	}

    /**
     * 短链接excel下载页面
     * @return
     */
    @RequestMapping("downloadLinkExcel")
    public String downloadLinkExcel(HttpServletRequest request,ModelMap model,
									Integer activityId,Integer batchNum,@RequestParam(defaultValue = "1") int page,
									@RequestParam(defaultValue = "15") int numPerPage){
		Integer jxUserId = session.getLoginUserId(request);
		if (jxUserId==null) {
			model.addAttribute(Constants.hint, "未登录或登录已过期,请重新登录!");// 提示未登录
			logger.error("downloadLinkExcel下载短链接列表,用户未登录或登录过期");
			return "jxSms/downloadLinkExcel";
		}
		try {
			// 分页  fixme
			List<JxActivityUrlBuild> list = jxSmsManagerService.getLinkExcelList(activityId, batchNum,page,numPerPage);
			model.addAttribute("result", list);// 列表
			model.addAttribute("activityId", activityId); // 活动id
			model.addAttribute("batchNum", batchNum); // 批次号
			model.addAttribute("page", page);// 当前页
			model.addAttribute("numPerPage", numPerPage); // 每页条数
			model.addAttribute("totalRows", jxSmsManagerService.getLinkExcelTotal(activityId, batchNum)); // 总条数
		} catch (Exception e) {
			logger.error("查询活动点记录出现异常", e);
		}
        return "/jxSms/downloadLinkExcel";
    }

	/**
	 * 解析excel
	 * @param request
	 * @param response
	 * @param path 文件路径
	 * @param fileName 文件名称
	 * @param batchNum 批次号
	 * @param activityId 活动ID
	 * @return
	 */
	@RequestMapping("analysisExcel")
	@ResponseBody
	public JsonWrapper<Map<String, String>> analysisExcel(HttpServletRequest request,
								HttpServletResponse response, String path,String fileName,Integer batchNum,Integer activityId,
								Integer jxActivityUrlBuildId) {
		Map<String, String> map =jxSmsManagerService.analysisExcel(path,fileName,batchNum,activityId,jxActivityUrlBuildId);
		String msg="success";
		if(map!=null && map.get("error")!=null){
			msg=map.get("error");
		}
		return new JsonWrapper<>(true, msg,null);
	}


	@RequestMapping("exportRecord")
	public void exportRecord(HttpServletRequest request,HttpServletResponse response,
							 String startTime,String endTime, Integer userId,
							 Integer activityId,Integer batchNum,String phone)  {
		OutputStream ops = null;
		XSSFWorkbook workbook = null;
		try {
			if (StringUtils.isBlank(startTime) && StringUtils.isBlank(endTime)
					&& StringUtils.isBlank(phone) && activityId == null && batchNum == null && userId == null) {
				logger.error("/sms/exportRecord活动访问记录查询导出接口出入参数均为空");
				return;
			}
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", "attachment;filename="+ DateUtils.safeFormatTime(new Date(), "yyyy_MM_dd_HH_mm_ss") + ".xlsx");
			List<JxActivityUrl> list = jxSmsManagerService.getQuertyRecordList(userId, activityId, batchNum, phone, startTime, endTime);
			ops = response.getOutputStream();
			workbook = jxSmsManagerService.syncDownRecordExcel(list);
			workbook.write(ops);
			ops.flush();
		}catch (Exception e){
			logger.error("导出查询记录失败:", e);
		}finally {
			if (workbook != null) {
				try {
					workbook.close();
				}catch (Exception e) {
					logger.error("导出查询记录失败:", e);
				}
			}

			if (ops != null) {
				try {
					ops.close();
				}catch (Exception e){
					logger.error("导出查询记录失败:", e);
				}
			}
		}
	}
}
