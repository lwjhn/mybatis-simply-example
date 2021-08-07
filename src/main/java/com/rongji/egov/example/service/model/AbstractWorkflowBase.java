package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.workflow.FlowReaderList;

import java.util.ArrayList;

public class AbstractWorkflowBase {
    private String flowProcessId;
    private String flowLabel;
    private String flowVersion;
    private String flowStatus;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private FlowReaderList todoReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private FlowReaderList atdoReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private FlowReaderList passReader;
    private FlowReaderList referReader;

    //@Permission(prefix = "%\"", suffix = "\"%")
    private FlowReaderList extensionReader;
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

    public FlowReaderList getTodoReader() {
        return todoReader;
    }

    public void setTodoReader(FlowReaderList todoReader) {
        this.todoReader = todoReader;
    }

    public FlowReaderList getAtdoReader() {
        return atdoReader;
    }

    public void setAtdoReader(FlowReaderList atdoReader) {
        this.atdoReader = atdoReader;
    }

    public FlowReaderList getPassReader() {
        return passReader;
    }

    public void setPassReader(FlowReaderList passReader) {
        this.passReader = passReader;
    }

    public FlowReaderList getReferReader() {
        return referReader;
    }

    public void setReferReader(FlowReaderList referReader) {
        this.referReader = referReader;
    }

    public FlowReaderList getExtensionReader() {
        return extensionReader;
    }

    public void setExtensionReader(FlowReaderList extensionReader) {
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
