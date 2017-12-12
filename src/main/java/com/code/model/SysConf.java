package com.code.model;

public class SysConf {
	
    private String attr;

    private String val;

    private String type;

    private String valList;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr == null ? null : attr.trim();
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getValList() {
        return valList;
    }

    public void setValList(String valList) {
        this.valList = valList == null ? null : valList.trim();
    }
}