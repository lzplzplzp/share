package com.code.service;

import com.code.dao.mapper.JxActivityUrlBuildMapper;
import com.code.dao.mapper.JxActivityUrlMapper;
import com.code.model.JxActivityUrl;
import com.code.model.JxActivityUrlBuild;
import com.code.util.CustomizedPropertyConfigurer;
import com.code.util.ExcelUtils;
import com.code.util.sms.PhoneSendMessageUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BatchActivityUrlTask {
    private final static Logger logger = LoggerFactory.getLogger(BatchActivityUrlTask.class);
    @Resource
    protected JxActivityUrlMapper jxActivityUrlMapper;
    @Resource
    private JxActivityUrlBuildMapper jxActivityUrlBuildMapper;


    @Async
    public void batchActivityUrlInsertDB(List<JxActivityUrl> list) throws Exception {
        logger.info("-------------批量增加活动url至数据库线程开始");
        int commitCountEveryTime=1000; //每次提交的记录数
        try{
            if(list==null){
                return ;
            }
            //提交次数
            int commitCount = (int) Math.ceil(list.size() / (double) commitCountEveryTime);
            List<JxActivityUrl> tempList = new ArrayList<JxActivityUrl>(commitCountEveryTime);
            int start, stop;
            Long startTime = System.currentTimeMillis();
            for(int i=0;i<commitCount;i++){
                tempList.clear();
                start = i * commitCountEveryTime;
                stop = Math.min(i * commitCountEveryTime + commitCountEveryTime - 1, list.size() - 1);
                for (int j = start; j <= stop; j++) {
                    tempList.add(list.get(j));
                }
                jxActivityUrlMapper.insertBatch(tempList);
            }
            Long endTime = System.currentTimeMillis();
            logger.info("============批量增加活动url至数据库线程结束,耗时："+(endTime - startTime) + "毫秒");
        }catch (Exception e){
            logger.error("BatchActivityUrlInsertDBCallable批量插入操作失败,异常:",e);
        }
    }

    @Async
    public void createUrlExcel(List<JxActivityUrl> list,String path,String name, Integer jxActivityUrlBuildId) throws Exception {
        logger.info("-------------创建短链接excel线程开始");
        JxActivityUrlBuild updatePm = new JxActivityUrlBuild();
        updatePm.setId(jxActivityUrlBuildId);
        try{
            if(list==null){
                return ;
            }
            ExcelUtils.CreateExcelByJxActivityUrlList(list,path,name);

            updatePm.setStatus(2); // 0未处理,1处理中,2处理完成,3处理失败
            //读取配置中的手机号  发送短信
            String phone= CustomizedPropertyConfigurer.getContextProperty("jx.sms.warn.phone");
            PhoneSendMessageUtils.sendMsg(phone,name+"文件已生成，请到生成记录页面下载！");
            logger.info("excel已生成，短信已发送至"+phone+",内容为："+name+"文件已生成，请到生成记录页面下载！");
        }catch (Exception e){
            //失败后更新数据库状态
            updatePm.setStatus(3);
            logger.error(" 生成表格操作失败,异常:",e);
        }finally {
            jxActivityUrlBuildMapper.updateByPrimaryKeySelective(updatePm);
        }
        logger.info("============创建短链接excel线程结束");
    }
}
