package com.seuic.entities;

import java.util.ArrayList;

public class Product {
    
    private String productName;
    private String pzwh;
    private String batchNo;
    private String specification;
    private String minPackUnit;
    private String minTagUnit;
    private String tagPackRatio;
    private String tagRatio;
    
    public Product() {
    }
    
    public Product(String productName, String pzwh, String batchNo,
            String specification, String minPackUnit, String minTagUnit,
            String tagPackRatio, String tagRatio, String produceDate,
            String operator, String oprDate, String count, String countUnit,
            ArrayList<String> code) {
        super();
        this.productName = productName;
        this.pzwh = pzwh;
        this.batchNo = batchNo;
        this.specification = specification;
        this.minPackUnit = minPackUnit;
        this.minTagUnit = minTagUnit;
        this.tagPackRatio = tagPackRatio;
        this.tagRatio = tagRatio;
        this.produceDate = produceDate;
        this.operator = operator;
        this.oprDate = oprDate;
        this.count = count;
        this.countUnit = countUnit;
        this.code = code;
    }
    private String produceDate;
    private String operator;
    private String oprDate;
    private String count;
    private String countUnit;
    private ArrayList<String> code;
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getPzwh() {
        return pzwh;
    }
    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }
    public String getBatchNo() {
        return batchNo;
    }
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
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
    public String getMinTagUnit() {
        return minTagUnit;
    }
    public void setMinTagUnit(String minTagUnit) {
        this.minTagUnit = minTagUnit;
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
    public String getProduceDate() {
        return produceDate;
    }
    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getOprDate() {
        return oprDate;
    }
    public void setOprDate(String oprDate) {
        this.oprDate = oprDate;
    }
    public String getCount() {
        return count;
    }
    public void setCount(String count) {
        this.count = count;
    }
    public String getCountUnit() {
        return countUnit;
    }
    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit;
    }
    public ArrayList<String> getCode() {
        return code;
    }
    public void setCode(ArrayList<String> code) {
        this.code = code;
    }
}
