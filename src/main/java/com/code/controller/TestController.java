package com.code.controller;

import com.code.common.JsonWrapper;
import com.zqm.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class TestController  extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(BuildActivityUrlController.class);


    /**
     * 上传Excel数据，并校验
     *
     */
    @RequestMapping("/test1")
    @ResponseBody
    public JsonWrapper<Map<String, String>> uploadExcel(HttpServletRequest req, HttpServletResponse respose) {

        return new JsonWrapper<>(true, "success");
    }
}
