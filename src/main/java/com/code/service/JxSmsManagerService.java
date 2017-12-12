/**
 *
 */
package com.code.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.code.common.config.CommonConfig;
import com.code.dao.mapper.ActivityMapper;
import com.code.dao.mapper.JxActivityUrlBuildMapper;
import com.code.model.*;
import com.code.util.ExcelUtils;
import com.code.util.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.code.common.result.DefaultResult;
import com.code.common.result.Result;
import com.code.common.result.ResultCode;
import com.code.util.sms.PhoneSendMessageUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 系统登录service
 * @author:云风
 * @CreateTime:2017年7月27日
 */
@Service
public class JxSmsManagerService extends AbstractService {

    private final Logger logger = LoggerFactory.getLogger(JxSmsManagerService.class);

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private JxActivityUrlBuildMapper jxActivityUrlBuildMapper;
    @Resource
    private CommonConfig commonConfig;


    /**
     * 通过用户手机号查找用户
     *
     * @param phone
     * @return
     */
    public JxSmsManage getUserMangeByPhone(String phone) {
        JxSmsManageExample example = new JxSmsManageExample();
        example.createCriteria().andPhoneEqualTo(phone);
        List<JxSmsManage> list = jxSmsManageMapper.selectByExample(example);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 根据管理员ID查询管理员信息
     *
     * @param id
     * @return
     */
    public JxSmsManage getUserManageById(Integer id) {
        return jxSmsManageMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据管理员用户id修改用户密码
     *
     * @param id
     * @param password
     * @return
     */
    public boolean updatePassWordById(Integer id, String password) {
        JxSmsManage sing = new JxSmsManage();
        sing.setId(id);
        sing.setPassword(password);
        sing.setUpdateTime(new Date());
        return jxSmsManageMapper.updateByPrimaryKeySelective(sing) > 0;
    }


    /**
     * 将短信插入数据库
     *
     * @param phone
     * @param message
     * @param status
     * @param channelId
     * @return
     */
    public int addSmsDB(String phone, String message, int status, Integer channelId) {
        PhoneMessage phoneMessage = new PhoneMessage();
        phoneMessage.setPhone(phone);
        phoneMessage.setContent(message);
        phoneMessage.setCtime(new Date());
        phoneMessage.setStatus(status);
        phoneMessage.setChannelId(channelId);
        return this.phoneMessageMapper.insert(phoneMessage);
    }

    /**
     * 发送手机验证码
     *
     * @param phone
     * @return
     */
    public Result sendSms(String phone) {
        Result result = new DefaultResult(new ResultCode(ResultCode.FAILURE, "发送手机号码失败！"));
        String mobileExp = "^(13[0-9]|147|145|15[0-9]|(17[0])|(17[7])|18[0-9])[0-9]{8}$";
        Pattern mobileP = Pattern.compile(mobileExp);
        Matcher mobileM = mobileP.matcher(phone);
        if (!mobileM.matches()) {
            return new DefaultResult(new ResultCode(ResultCode.FAILURE, "手机号码格式不正确！"));
        }
        JxSmsManageExample jxMerchantManageExample = new JxSmsManageExample();
        jxMerchantManageExample.createCriteria().andPhoneEqualTo(phone);
        long count = jxSmsManageMapper.countByExample(jxMerchantManageExample);
        if (count < 1) {
            return new DefaultResult(new ResultCode(ResultCode.FAILURE, "用户不存在！"));
        }
        String code = PhoneSendMessageUtils.createAuthcode();
        String msg = "您的验证码为" + code + "，欢迎您登录抓钱猫抓钱猫-短信系统。热线电话：4000-902-903";
        int ret = PhoneSendMessageUtils.sendMsg(phone, msg);
        addSmsDB(phone, msg, ret, 1);
        if (ret == 1) {
            result = new DefaultResult(new ResultCode(ResultCode.SUCCESS, "手机验证码发送成功"));
            result.setDefaultModel(code);
            result.setModel("flag", true);
            return result;
        }
        return result;
    }

    /**
     * 根据条件查询活动点击记录
     *
     * @param userId
     * @param activityId
     * @param batchId
     * @param phone
     * @param startTime
     * @param endTime
     * @return
     */
    public List<JxActivityUrl> getQuertyRecordList(Integer userId, Integer activityId, Integer batchId, String phone, String startTime, String endTime) {
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("startTime", startTime+" 00:00:00");
        if (StringUtils.isEmpty(endTime)) {
        	mapper.put("endTime", endTime);
		}else{
			mapper.put("endTime", endTime+" 23:59:59");
		}
        mapper.put("phone", phone);
        mapper.put("userId", userId);
        mapper.put("activityId", activityId);
        mapper.put("batchId", batchId);
        return jxActivityUrlMapper.getQuertyRecordList(mapper);
    }

    /**
     * 根据条件查询对应总条数
     *
     * @param userId
     * @param activityId
     * @param batchId
     * @param startTime
     * @param endTime
     * @param phone
     * @return
     */
    public long getTotalRows(Integer userId, Integer activityId, Integer batchId, String phone, String startTime, String endTime) {
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("userId", userId);
        mapper.put("activityId", activityId);
        mapper.put("batchId", batchId);
        mapper.put("phone", phone);
        mapper.put("startTime", startTime);
        mapper.put("endTime", endTime);
        return jxActivityUrlMapper.getTotalRows(mapper);
    }

    /**
     * (1)解析excel (2)生成短链接 (3)存入数据库 (4)生成有短链接的excel
     *
     * @param path
     * @param fileName
     * @param batchNum
     * @param activityId
     * @return
     */
    public Map<String, String> analysisExcel(String path, String fileName, Integer batchNum, Integer activityId,Integer jxActivityUrlBuildId) {
        Map<String, String> result = new HashMap<String, String>();
		FileInputStream fileInputStream =null;
        try {
            // 变量
            List<JxActivityUrl> jxActivityUrlList = new ArrayList<JxActivityUrl>();
            // 1.使用工具类解析excel为mapList
            String analysisExcelPath = commonConfig.getBuildActivityUrlAfter();
            fileInputStream = new FileInputStream(new File(path));
            List<Map<String, String>> mapList = ExcelUtils.getFromExcelNew(fileInputStream, fileName);
            // 解析第2行，获得活动名称
            String activityName = "";
            Map<String, String> result1 = analysisExcel_processLine1(mapList.get(0), activityId, batchNum);
            if (result1.containsKey("error")) {
                return result1;
            }
            activityName = result1.get("activityName");
            // 解析第4行到最后一行，获得列表
            for (int i = 2; i < mapList.size(); i++) {
                Map<String, String> line = mapList.get(i);
                //
                String uid = line.get("0");
                String phone = line.get("1");
                //  校验用户ID是否为数字类型
                if(!StringUtils.isNumeric(uid)){
                    result.put("error", "有用户ID不是数字，异常ID为："+uid);
                    return result;
                }
                //  用户ID+活动ID+批次号
                String url = RandomUtils.encodeRandom(Integer.parseInt(uid), activityId, batchNum);
                //   (2)生成短链接
                JxActivityUrl jxActivityUrl = new JxActivityUrl();
                jxActivityUrl.setUserId(Integer.valueOf(uid)); // uid
                jxActivityUrl.setPhone(phone); // 手机号
                jxActivityUrl.setUrl(url); // 短链接
                jxActivityUrl.setActivityId(activityId);
                jxActivityUrl.setActivityName(activityName);
                jxActivityUrl.setBatchNum(batchNum);
                jxActivityUrl.setCtime(new Date());
                jxActivityUrl.setClickCount(0);
                jxActivityUrl.setIp("");
                jxActivityUrlList.add(jxActivityUrl);
            }
            // 校验
            if (jxActivityUrlList.isEmpty()) {
                result.put("error", "未解析到数据！请检查！");
                logger.info("解析excel文件:"+fileName+"未解析到数据！请检查！");
                return result;
            }
            // 上传文件时生成的记录
            JxActivityUrlBuild uploadJxActivityUrlBuild = jxActivityUrlBuildMapper.selectByPrimaryKey(jxActivityUrlBuildId);
            if (uploadJxActivityUrlBuild == null) {
                result.put("error", "数据库中未找到上传记录！");
                logger.info("解析excel文件:"+fileName+"数据库中未找到上传记录");
                return result;
            }
            // 更新
            JxActivityUrlBuild jxActivityUrlBuild = new JxActivityUrlBuild();
            jxActivityUrlBuild.setId(uploadJxActivityUrlBuild.getId());
            jxActivityUrlBuild.setActivityId(activityId);
            jxActivityUrlBuild.setBatchNum(batchNum.byteValue());
            jxActivityUrlBuild.setBuileFileName(fileName);
            jxActivityUrlBuild.setStatus(1);   //0未处理,1处理中,2处理完成,3处理失败
            jxActivityUrlBuild.setBuileFilePath(analysisExcelPath +"/"+ fileName);
            jxActivityUrlBuildMapper.updateByPrimaryKeySelective(jxActivityUrlBuild);
            // 数据批量插入数据库线程
            batchActivityUrlTask.batchActivityUrlInsertDB(jxActivityUrlList);
			// 生成excel操作后需要更新活动url 状态
            batchActivityUrlTask.createUrlExcel(jxActivityUrlList, analysisExcelPath, fileName, uploadJxActivityUrlBuild.getId());
        } catch (Exception e) {
            result.put("error", "未解析到数据！请检查！");
            logger.error("analysisExcel 解析excel  server异常",e);
            return result;
        } finally {
            if(fileInputStream!=null){
            	try{
					fileInputStream.close();
				}catch (Exception e){
                    logger.error("analysisExcel 解析excel  server 关闭流异常",e);
				}
			}
        }
        return result;
    }

    /**
     * @param line1Map
     * @param activityId
     * @param batchNum
     * @return
     */
    private Map<String, String> analysisExcel_processLine1(Map<String, String> line1Map, Integer activityId, Integer batchNum) {
        Map<String, String> rtn = new HashMap<>();
        String activityName = "";
        // activityIdExcel batchNumExcel
        String activityIdExcel = line1Map.get("0");
        String batchNumExcel = line1Map.get("1");
        if (activityIdExcel == null || batchNumExcel == null) {
            rtn.put("error", "手动输入活动ID或批次号与excel中不匹配！请检查！");
            return rtn;
        }
        if (!Integer.valueOf(activityIdExcel).equals(activityId)  || !batchNum.equals(Integer.valueOf(batchNumExcel))) {
            rtn.put("error", "手动输入活动ID或批次号与excel中不匹配！请检查！");
            return rtn;
        }
        //校验批次号逻辑
        JxActivityUrlBuild maxJxActivityUrlBuild=jxActivityUrlBuildMapper.selectMaxBatchNum(activityId);
        if(maxJxActivityUrlBuild==null){
            if(batchNum!=1){
                rtn.put("error", "活动首次进行生成短链接操作批次号应为：1,请修改！");
                return rtn;
            }
        }
        if(maxJxActivityUrlBuild!=null && maxJxActivityUrlBuild.getBatchNum().intValue()==batchNum){
            if (maxJxActivityUrlBuild.getStatus() == 1) { // 1:处理中; 2:已完成;
                rtn.put("error", "当前活动该批次正在处理，请勿重复提交！当前活动的最大批次号为"+maxJxActivityUrlBuild.getBatchNum()+",下一批次号应为："+(maxJxActivityUrlBuild.getBatchNum()+1));
                return rtn;
            }else if(maxJxActivityUrlBuild.getStatus() == 2){
                rtn.put("error", "当前活动该批次已生成，请到列表中下载即可！当前活动的最大批次号为"+maxJxActivityUrlBuild.getBatchNum()+",下一批次号应为："+(maxJxActivityUrlBuild.getBatchNum()+1));
                return rtn;
            }
        }
        if(maxJxActivityUrlBuild!=null && maxJxActivityUrlBuild.getBatchNum()+1!=batchNum ){
            rtn.put("error", "当前活动的最大批次号为"+maxJxActivityUrlBuild.getBatchNum()+",应上传批次号应为："+(maxJxActivityUrlBuild.getBatchNum()+1)+",请修改！");
            return rtn;
        }
        //批次号校验结束----------

        // 活动
        Activity activity = activityMapper.selectByPrimaryKey(activityId);
        if (activity == null) {
            rtn.put("error", "活动不存在，请检查活动ID！");
            return rtn;
        }
        activityName = activity.getName();
        rtn.put("activityName", activityName);
        return rtn;
    }

    public List<JxActivityUrlBuild> getLinkExcelList(Integer activityId, Integer batchNum, int page, int numPerPage) {
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("activityId", activityId);
        mapper.put("batchNum", batchNum);
        mapper.put("page", (page - 1) * numPerPage);
        mapper.put("numPerPage", numPerPage);
        return jxActivityUrlBuildMapper.getLinkExcelList(mapper);
    }

    public long getLinkExcelTotal(Integer activityId, Integer batchNum) {
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("activityId", activityId);
        mapper.put("batchNum", batchNum);
        return jxActivityUrlBuildMapper.getTotalRows(mapper);
    }

    /**
     *  导出 活动访问记录列表
     * @param list 数据列表
     * @return
     */
    public XSSFWorkbook syncDownRecordExcel(List<JxActivityUrl> list) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("sheet1");
        sheet.setDefaultColumnWidth(20);
        // 生成一个样式
        XSSFCellStyle style = workbook.createCellStyle();

        // 设置这些样式
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        XSSFFont font = workbook.createFont();
        font.setColor(IndexedColors.BLACK.getIndex());
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        XSSFFont font2 = workbook.createFont();
        font2.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);

        String[] headers = new String[]{"用户ID", "用户手机号", "活动id", "活动名称", "批次号", "点击次数", "首次打开时间", "创建时间"};
        int index = 0;
        XSSFRow row = sheet.createRow(index++);
        XSSFCell cell = row.createCell(0);
        cell.setCellStyle(style);
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i);
            XSSFRichTextString text = new XSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        for (JxActivityUrl activityUrl : list) {
            int cellIndex = 0;
            row = sheet.createRow(index++);
            //用户ID
            Integer userId = activityUrl.getUserId();
            cell = row.createCell(cellIndex++);
            XSSFRichTextString richString = new XSSFRichTextString(String.valueOf(userId));
            cell.setCellValue(richString);

            //用户手机号
            String userPhone = activityUrl.getPhone();
            cell = row.createCell(cellIndex++);
            richString = new XSSFRichTextString(userPhone);
            cell.setCellValue(richString);

            //活动id
            Integer accountId = activityUrl.getActivityId();
            cell = row.createCell(cellIndex++);
            richString = new XSSFRichTextString(String.valueOf(accountId));
            cell.setCellValue(richString);

            //活动名称
            String activityName = activityUrl.getActivityName();
            cell = row.createCell(cellIndex++);
            richString = new XSSFRichTextString(activityName);
            cell.setCellValue(richString);

            //批次号
            Integer batchNum = activityUrl.getBatchNum();
            cell = row.createCell(cellIndex++);
            richString = new XSSFRichTextString(String.valueOf(batchNum));
            cell.setCellValue(richString);
            //点击次数
            Integer clickCount = activityUrl.getClickCount();
            cell = row.createCell(cellIndex++);
            richString = new XSSFRichTextString(String.valueOf(clickCount));
            cell.setCellValue(richString);
            //首次打开时间
            Date firstOpenTime = activityUrl.getFirstOpenTime();
            cell = row.createCell(cellIndex++);
            richString = null;
            if (firstOpenTime != null) {
                richString = new XSSFRichTextString(com.code.util.DateUtils.safeFormatTime(firstOpenTime, "yyyy-MM-dd HH:mm:ss"));
            }
            cell.setCellValue(richString);
            //生成时间
            Date ctime = activityUrl.getCtime();
            cell = row.createCell(cellIndex);
            richString = new XSSFRichTextString(com.code.util.DateUtils.safeFormatTime(ctime, "yyyy-MM-dd HH:mm:ss"));
            cell.setCellValue(richString);
        }
        return workbook;
    }
}
