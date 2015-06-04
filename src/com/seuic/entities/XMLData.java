package com.seuic.entities;

import java.util.ArrayList;


public class XMLData {
    
    private String corpName;
    private String dataType;
    private String version;
    private String xmlns_xsi;
    private String xsi_noNamespaceSchemaLocation;
    private ArrayList<Product> products;
    
    public ArrayList<Product> getProducts() {
        return products;
    }
    public XMLData() {
    }
    public XMLData(String corpName, String dataType, String version,
            String xmlns_xsi, String xsi_noNamespaceSchemaLocation,
            ArrayList<Product> products) {
        super();
        this.corpName = corpName;
        this.dataType = dataType;
        this.version = version;
        this.xmlns_xsi = xmlns_xsi;
        this.xsi_noNamespaceSchemaLocation = xsi_noNamespaceSchemaLocation;
        this.products = products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public String getCorpName() {
        return corpName;
    }
    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }
    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public String getXmlns_xsi() {
        return xmlns_xsi;
    }
    public void setXmlns_xsi(String xmlns_xsi) {
        this.xmlns_xsi = xmlns_xsi;
    }
    public String getXsi_noNamespaceSchemaLocation() {
        return xsi_noNamespaceSchemaLocation;
    }
    public void setXsi_noNamespaceSchemaLocation(
            String xsi_noNamespaceSchemaLocation) {
        this.xsi_noNamespaceSchemaLocation = xsi_noNamespaceSchemaLocation;
    }
}
