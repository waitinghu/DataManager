package com.seuic.entities;

public class Bill {

    private String flowid;
    private int srvtype;
    private String cpid;
    private String batchno;
    private String cpdt;
    private String op;
    private String opdt;
    private String specification;
    private String minPackUnit;
    private String minTagUnit;
    private String tagPackRatio;
    private String tagRatio;
    private String toProvince;
    private String toUnit;
    private int isfile;
    
    public String getMinTagUnit() {
        return minTagUnit;
    }
    public void setMinTagUnit(String minTagUnit) {
        this.minTagUnit = minTagUnit;
    }
    public String getFlowid() {
        return flowid;
    }
    public void setFlowid(String flowid) {
        this.flowid = flowid;
    }
    public int getSrvtype() {
        return srvtype;
    }
    public void setSrvtype(int srvtype) {
        this.srvtype = srvtype;
    }
    public String getCpid() {
        return cpid;
    }
    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
    public String getBatchno() {
        return batchno;
    }
    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }
    public String getCpdt() {
        return cpdt;
    }
    public void setCpdt(String cpdt) {
        this.cpdt = cpdt;
    }
    public String getOp() {
        return op;
    }
    public void setOp(String op) {
        this.op = op;
    }
    public String getOpdt() {
        return opdt;
    }
    public void setOpdt(String opdt) {
        this.opdt = opdt;
    }
    public String getSpecification() {
        return specification;
    }
    public void setSpecification(String specification) {
        this.specification = specification;
    }
    public String getMinPackUnit() {
        return minPackUnit;
    }
    public void setMinPackUnit(String minPackUnit) {
        this.minPackUnit = minPackUnit;
    }
    public String getTagPackRatio() {
        return tagPackRatio;
    }
    public void setTagPackRatio(String tagPackRatio) {
        this.tagPackRatio = tagPackRatio;
    }
    public String getTagRatio() {
        return tagRatio;
    }
    public void setTagRatio(String tagRatio) {
        this.tagRatio = tagRatio;
    }
    public String getToProvince() {
        return toProvince;
    }
    public void setToProvince(String toProvince) {
        this.toProvince = toProvince;
    }
    public String getToUnit() {
        return toUnit;
    }
    public void setToUnit(String toUnit) {
        this.toUnit = toUnit;
    }
    public int getIsfile() {
        return isfile;
    }
    public void setIsfile(int isfile) {
        this.isfile = isfile;
    }
}