package com.code.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.code.common.JsonWrapper;
import com.code.common.config.CommonConfig;
import com.code.dao.mapper.JxSmsManageMapper;
import com.code.model.JxActivityUrlBuild;
import com.code.model.JxSmsManage;
import com.code.model.JxUser;
import com.code.service.ActivityUrlBuildService;
import com.code.session.SessionProvider;
import com.code.util.DateUtils;
import com.code.util.ExcelUtils;
import com.code.util.Upload;
import com.zqm.controller.BaseController;

/**
 * Created by lixin on 17/7/27.
 */
@Controller
@RequestMapping("/back/buildActivityUrl")
public class BuildActivityUrlController extends BaseController{

    private final Logger logger = LoggerFactory.getLogger(BuildActivityUrlController.class);

	@Resource
    private CommonConfig commonConfig;
	@Resource
    private ActivityUrlBuildService buildActivityUrlService;
	@Resource
    private SessionProvider session;
	@Resource
    private JxSmsManageMapper jxSmsManageMapper;

    /**
     * 上传Excel数据，并校验
     *
     */
    @RequestMapping("/uploadExcel")
    @ResponseBody
    public JsonWrapper<Map<String, String>> uploadExcel(HttpServletRequest request, HttpServletResponse respose, MultipartFile excelFile) {
        try {
            respose.setCharacterEncoding("utf-8");
            String path = commonConfig.getBuildActivityUrlBefore();

            if (excelFile == null || excelFile.getSize() == 0) {
                return new JsonWrapper<>(false, "上传文件不能为空", null);
            }

            String fileName = excelFile.getOriginalFilename().toLowerCase();
            // 得到文件的后缀名
            String ext = fileName.split("\\.")[fileName.split("\\.").length - 1];
            String newFileName = DateUtils.safeFormatTime(new Date(), "yyyy_MM_dd_HH_mm_ss") + "." + ext.toLowerCase();

            Upload upload = new Upload(excelFile);
            Map<String, String> urlMap = upload.saveFilePath(path, newFileName);
            String filename = excelFile.getOriginalFilename();

            // 校验开始--------------------------
            String absoluteUrl=urlMap.get("absoluteUrl");
            File file = new File(absoluteUrl);

            InputStream instream = new FileInputStream(file);
            List<String> list = ExcelUtils.getFromExcel2Col(instream, absoluteUrl);

            List<JxUser> userList = new ArrayList<>();
            for (String str : list) {
                if (str != null && str.contains(",")) {
                    String[] strs = str.split(",");
                    if (strs.length > 1) {
                        String id = strs[0];
                        String phone = strs[1];
                        JxUser user = new JxUser();
                        user.setId(Integer.parseInt(id));
                        user.setPhone(phone);
                        userList.add(user);
                    }
                }
            }
            Map<String, Object> checkout = buildActivityUrlService.checkout(userList);
            if (!(boolean) checkout.get("isOK")) {
                JxUser user = (JxUser) checkout.get("user");
                Integer id = user.getId();
                String phone = user.getPhone();
                String msg = "导入" + fileName + "数据失败，用户ID：" + id + "与该手机号：" + phone + "不匹配,或该用户ID不存在";
                logger.error(msg);
                return new JsonWrapper<>(false, msg, null);
            }
            // 校验结束------------------------------

            // 保存操作记录开始-----------------
            JxActivityUrlBuild jxActivityUrlBuild = new JxActivityUrlBuild();
            Integer adminId = session.getLoginUserId(request);
            JxSmsManage jxSmsManage = jxSmsManageMapper.selectByPrimaryKey(adminId);
            jxActivityUrlBuild.setFileOldName(filename);
            jxActivityUrlBuild.setFileNewName(newFileName);
            jxActivityUrlBuild.setCtime(new Date());
            jxActivityUrlBuild.setFilePath(absoluteUrl);

            jxActivityUrlBuild.setCuserId(jxSmsManage.getId());
            jxActivityUrlBuild.setCuserName(jxSmsManage.getName());
            jxActivityUrlBuild.setIsDel(0);
            jxActivityUrlBuild.setStatus(0);
            buildActivityUrlService.saveUploadExcleMsg(jxActivityUrlBuild);

            urlMap.put("jxActivityUrlBuildId",jxActivityUrlBuild.getId()+"");
            // 保存操作记录结束-------------------------
            return new JsonWrapper<>(true, "success", urlMap);
        }catch (Exception e){
            logger.error("上传文件失败:",e);
            return new JsonWrapper<>(false, "网络异常,上传文件失败", null);
        }
    }



    @RequestMapping(value="/downLoad",method= RequestMethod.GET)
    public void downLoadExcel(HttpServletRequest request,HttpServletResponse response, Integer type, String fileName){
        String path = null;
        if (type != null && type == 1){
            path = commonConfig.getBuildActivityUrlAfter();
        }else if (type != null && type == 2){
            path = commonConfig.getBuildActivityUrlBefore();
        }
        if (StringUtils.isBlank(path)) {
            logger.error("下载文件名为空");
            return;
        }
        try {
            File file = new File(path, fileName);// path是根据日志路径和文件名拼接出来的
            String filename = file.getName();// 获取文件名称
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.replaceAll(" ", "").getBytes("utf-8"),"iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            os.write(buffer);// 输出文件
            os.flush();
            os.close();
        } catch (Exception e) {
            logger.error("下载excel失败", e);
        }
    }
}
