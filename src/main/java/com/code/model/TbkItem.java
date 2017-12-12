package com.code.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 */
public class TbkItem {
    /**
     * item_url
     */
    private String item_url;

    /**
     * nick
     */
    private String nick;

    /**
     * num_iid
     */
    private String num_iid;

    /**
     * pict_url
     */
    private String pict_url;

    /**
     * provcity
     */
    private String provcity;

    /**
     * reserve_price
     */
    private BigDecimal reserve_price;

    /**
     * seller_id
     */
    private String seller_id;

    /**
     * small_images
     */
    private List<String> small_images;

    /**
     * title
     */
    private String title;

    /**
     * user_type
     */
    private String user_type;

    /**
     * volume
     */
    private String volume;
    /**
     * zk_final_price
     */
    private BigDecimal zk_final_price;

    public String getItem_url() {
        return item_url;
    }

    public void setItem_url(String item_url) {
        this.item_url = item_url;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNum_iid() {
        return num_iid;
    }

    public void setNum_iid(String num_iid) {
        this.num_iid = num_iid;
    }

    public String getPict_url() {
        return pict_url;
    }

    public void setPict_url(String pict_url) {
        this.pict_url = pict_url;
    }

    public String getProvcity() {
        return provcity;
    }

    public void setProvcity(String provcity) {
        this.provcity = provcity;
    }

    public BigDecimal getReserve_price() {
        return reserve_price;
    }

    public void setReserve_price(BigDecimal reserve_price) {
        this.reserve_price = reserve_price;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public List<String> getSmall_images() {
        return small_images;
    }

    public void setSmall_images(String small_images) {
        List<String> list= null;
        try {
            list = new ArrayList<String>();
            HashMap<String,Object> result=new HashMap<String,Object>();
            result=(HashMap<String,Object>)JSONObject.parseObject(small_images,HashMap.class);

            Object o=result.get("string");
            JSONArray arr=JSONObject.parseArray(o.toString());
            for (Iterator iterator = arr.iterator(); iterator.hasNext();) {
                String job = (String) iterator.next();
                list.add(job);
            }
            this.small_images = list;
        } catch (Exception e) {
            e.printStackTrace();
            this.small_images = null;
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public BigDecimal getZk_final_price() {
        return zk_final_price;
    }

    public void setZk_final_price(BigDecimal zk_final_price) {
        this.zk_final_price = zk_final_price;
    }
}