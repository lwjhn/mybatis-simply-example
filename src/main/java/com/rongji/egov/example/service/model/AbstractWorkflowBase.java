package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.ACL;
import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Reader;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.mybatis.base.wrapper.JsonTypeHandler;
import com.rongji.egov.workflow.FlowReaderList;

import java.util.Date;

public class AbstractWorkflowBase {
    private String flowProcessId;
    private String flowLabel;
    private String flowVersion;
    private String flowStatus;

    @TypeHandler(value = JsonTypeHandler.class)
    //@Reader(prefix = "%\"", suffix = "\"%")
    private FlowReaderList todoReader;

    @TypeHandler(value = JsonTypeHandler.class)
    //@Reader(prefix = "%\"", suffix = "\"%")
    private FlowReaderList atdoReader;

    @TypeHandler(value = JsonTypeHandler.class)
    @Reader(prefix = "%\"", suffix = "\"%", value={ACL.USER})
    private FlowReaderList passReader;

    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList referReader;

    @TypeHandler(value = JsonTypeHandler.class)
    //@Reader(prefix = "%\"", suffix = "\"%")
    private FlowReaderList extensionReader;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )

    @Column(exist = false)
    private Date operatorTime;
    @Column(exist = false)
    private String operatorUserNo;
    @Column(exist = false)
    private String operatorUserName;
    @Column(exist = false)
    private String operatorOrgNo;

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

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getOperatorUserNo() {
        return operatorUserNo;
    }

    public void setOperatorUserNo(String operatorUserNo) {
        this.operatorUserNo = operatorUserNo;
    }

    public String getOperatorUserName() {
        return operatorUserName;
    }

    public void setOperatorUserName(String operatorUserName) {
        this.operatorUserName = operatorUserName;
    }

    public String getOperatorOrgNo() {
        return operatorOrgNo;
    }

    public void setOperatorOrgNo(String operatorOrgNo) {
        this.operatorOrgNo = operatorOrgNo;
    }
}
