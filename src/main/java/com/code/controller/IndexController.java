package com.code.controller;


import com.code.common.JsonWrapper;
import com.code.common.config.CommonConfig;
import com.code.model.JxActivityUrlBuild;
import com.code.model.TbkItem;
import com.code.service.TaoBaoService;
import com.code.util.CustomizedPropertyConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private TaoBaoService taoBaoService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexLogin(HttpServletRequest request,
                             HttpServletResponse response, ModelMap model) {
        List<TbkItem> list = taoBaoService.getIndexList(null,1L);
        model.addAttribute("result", list);// 列表
        return "my/index";
    }
    @RequestMapping("/search")
    @ResponseBody
    public JsonWrapper<List<TbkItem>> search(HttpServletRequest request,
                                             HttpServletResponse respose,
                                             String searchVal,
                                             Long page) {
        if(page==null){
            page=1L;
        }
        List<TbkItem> list = taoBaoService.getIndexList(searchVal,page);
        return new JsonWrapper<>(true, "success", list);
    }
}
