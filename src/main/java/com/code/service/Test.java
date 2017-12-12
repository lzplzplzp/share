package com.code.service;

import com.alibaba.fastjson.JSONObject;
import com.code.model.TbkItem;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.response.TbkItemGetResponse;

import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        getIndexList();
    }
    public static List<TbkItem> getIndexList() {
        String url="http://gw.api.taobao.com/router/rest";
        String appkey="24640689";
        String secret="2641e9f958eddb76ff34d5c93e2ab512";
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        TbkItemGetRequest req = new TbkItemGetRequest();
        req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
        req.setQ("女装");
        req.setCat("16,18");
//        req.setItemloc("杭州");
//        req.setSort("tk_rate_des");
//        req.setIsTmall(false);
//        req.setIsOverseas(false);
//        req.setStartPrice(10L);
//        req.setEndPrice(10L);
//        req.setStartTkRate(123L);
//        req.setEndTkRate(123L);
//        req.setPlatform(1L);
//        req.setPageNo(123L);
//        req.setPageSize(20L);
        TbkItemGetResponse rsp = null;
        try {
            rsp = client.execute(req);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return taobaoJsonToList(rsp);
    }

    private static List<TbkItem> taobaoJsonToList(TbkItemGetResponse rsp) {
        System.out.println(rsp.getBody());
        HashMap<String,Object> result=new HashMap<String,Object>();
        result=(HashMap<String,Object>) JSONObject.parseObject((rsp.getBody()),HashMap.class);
        result=JSONObject.parseObject(result.get("tbk_item_get_response").toString(),HashMap.class);
        result=JSONObject.parseObject(result.get("results").toString(),HashMap.class);
        List<TbkItem> list=JSONObject.parseArray(result.get("n_tbk_item").toString(),TbkItem.class);

        return list;
    }
}
