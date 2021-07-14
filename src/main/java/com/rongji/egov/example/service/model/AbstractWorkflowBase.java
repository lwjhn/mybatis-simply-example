package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;

public class AbstractWorkflowBase {
    private String flowProcessId;
    private String flowLabel;
    private String flowVersion;
    private String flowStatus;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private ArrayList<Object> todoReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private ArrayList<Object> atdoReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private ArrayList<Object> passReader;
    private ArrayList<Object> referReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private ArrayList<Object> extensionReader;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
//    private Date operatorTime;
//    private String operatorUserNo;
//    private String operatorUserName;
//    private String operatorOrgNo;

    public String getFlowProcessId() {
        return flowProcessId;
    }

    public void setFlowProcessId(String flowProcessId) {
        this.flowProcessId = flowProcessId;
    }

    public String getFlowLabel() {
        return flowLabel;
    }

    public void setFlowLabel(String flowLabel) {
        this.flowLabel = flowLabel;
    }

    public String getFlowVersion() {
        return flowVersion;
    }

    public void setFlowVersion(String flowVersion) {
        this.flowVersion = flowVersion;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public ArrayList<Object> getTodoReader() {
        return todoReader;
    }

    public void setTodoReader(ArrayList<Object> todoReader) {
        this.todoReader = todoReader;
    }

    public ArrayList<Object> getAtdoReader() {
        return atdoReader;
    }

    public void setAtdoReader(ArrayList<Object> atdoReader) {
        this.atdoReader = atdoReader;
    }

    public ArrayList<Object> getPassReader() {
        return passReader;
    }

    public void setPassReader(ArrayList<Object> passReader) {
        this.passReader = passReader;
    }

    public ArrayList<Object> getReferReader() {
        return referReader;
    }

    public void setReferReader(ArrayList<Object> referReader) {
        this.referReader = referReader;
    }

    public ArrayList<Object> getExtensionReader() {
        return extensionReader;
    }

    public void setExtensionReader(ArrayList<Object> extensionReader) {
        this.extensionReader = extensionReader;
    }

//    public Date getOperatorTime() {
//        return operatorTime;
//    }
//
//    public void setOperatorTime(Date operatorTime) {
//        this.operatorTime = operatorTime;
//    }
//
//    public String getOperatorUserNo() {
//        return operatorUserNo;
//    }
//
//    public void setOperatorUserNo(String operatorUserNo) {
//        this.operatorUserNo = operatorUserNo;
//    }
//
//    public String getOperatorUserName() {
//        return operatorUserName;
//    }
//
//    public void setOperatorUserName(String operatorUserName) {
//        this.operatorUserName = operatorUserName;
//    }
//
//    public String getOperatorOrgNo() {
//        return operatorOrgNo;
//    }
//
//    public void setOperatorOrgNo(String operatorOrgNo) {
//        this.operatorOrgNo = operatorOrgNo;
//    }
}
