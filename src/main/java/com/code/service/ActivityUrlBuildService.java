package com.code.service;

import com.code.model.JxActivityUrlBuild;
import com.code.model.JxUser;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lixin on 17/7/27.
 */
@Service
public class ActivityUrlBuildService extends AbstractService{

    /**
     * 校验是否为新用户
     * @param list
     * @return
     */
    public Map<String, Object> checkout(List<JxUser> list){
        Map<String, Object> map = new HashMap<>();
        // 添加校验用户id是否为新用户
        for (JxUser user : list) {
            Integer id = user.getId();
            String phone = user.getPhone();
            JxUser jxUser = jxUserMapper.selectByPrimaryKey(id);
            if (jxUser == null || !phone.equals(jxUser.getPhone())) {
                map.put("isOK", false);
                user.setId(id);
                map.put("user", user);
                return map;
            }
        }
        map.put("isOK", true);
        return map;
    }


    /**
     * 保存上传记录表
     * @param jxActivityUrlBuild
     * @return
     */
    public int saveUploadExcleMsg(JxActivityUrlBuild jxActivityUrlBuild){
        return jxActivityUrlBuildMapper.insert(jxActivityUrlBuild);
    }
}
