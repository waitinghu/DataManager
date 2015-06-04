package com.seuic.entities;

public class BillDetail {
    private String flowid;
    private String code;
    private int codetype;
    private String cpid;

    public String getFlowid() {
        return flowid;
    }

    public void setFlowid(String flowid) {
        this.flowid = flowid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCodetype() {
        return codetype;
    }

    public void setCodetype(int codetype) {
        this.codetype = codetype;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
}
