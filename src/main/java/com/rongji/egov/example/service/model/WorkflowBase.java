package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.ACL;
import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Reader;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.utils.mybatis.typehandler.JsonTypeHandler;
import com.rongji.egov.workflow.FlowReaderList;
import com.rongji.egov.workflow.client.model.AbstractWorkflowBase;

import java.util.Date;

public abstract class WorkflowBase extends AbstractWorkflowBase {
    /*private String flowProcessId;
    private String flowLabel;
    private String flowVersion;
    private String flowStatus;*/

    /**
     * @deprecated
     */
    @Deprecated
    @Column(exist = false)
    private String flowDoneUser;

    /**
     * 待办用户
     */
    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList todoReader;

    /**
     * 在办用户
     */
    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList atdoReader;

    /**
     * 经办用户
     */
    @Reader(value = ACL.USER)
    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList passReader;

    /**
     * 传阅用户、知会用户等
     */
    @Reader(value = ACL.USER)
    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList referReader;

    /**
     * 扩展。可添加各类型角色等
     * 如特定岗位、群组等（一般使用群组）
     */
    @Reader
    @TypeHandler(value = JsonTypeHandler.class)
    private FlowReaderList extensionReader;

    @Column(exist = false)
    private String stateHandleInfo;
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

    @Override
    public String getFlowDoneUser() {
        return flowDoneUser;
    }

    @Override
    public void setFlowDoneUser(String flowDoneUser) {
        this.flowDoneUser = flowDoneUser;
    }

    @Override
    public FlowReaderList getTodoReader() {
        return todoReader;
    }

    @Override
    public void setTodoReader(FlowReaderList todoReader) {
        this.todoReader = todoReader;
    }

    @Override
    public FlowReaderList getAtdoReader() {
        return atdoReader;
    }

    @Override
    public void setAtdoReader(FlowReaderList atdoReader) {
        this.atdoReader = atdoReader;
    }

    @Override
    public FlowReaderList getPassReader() {
        return passReader;
    }

    @Override
    public void setPassReader(FlowReaderList passReader) {
        this.passReader = passReader;
    }

    @Override
    public FlowReaderList getReferReader() {
        return referReader;
    }

    @Override
    public void setReferReader(FlowReaderList referReader) {
        this.referReader = referReader;
    }

    @Override
    public FlowReaderList getExtensionReader() {
        return extensionReader;
    }

    @Override
    public void setExtensionReader(FlowReaderList extensionReader) {
        this.extensionReader = extensionReader;
    }

    @Override
    public String getStateHandleInfo() {
        return stateHandleInfo;
    }

    @Override
    public void setStateHandleInfo(String stateHandleInfo) {
        this.stateHandleInfo = stateHandleInfo;
    }

    @Override
    public Date getOperatorTime() {
        return operatorTime;
    }

    @Override
    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    @Override
    public String getOperatorUserNo() {
        return operatorUserNo;
    }

    @Override
    public void setOperatorUserNo(String operatorUserNo) {
        this.operatorUserNo = operatorUserNo;
    }

    @Override
    public String getOperatorUserName() {
        return operatorUserName;
    }

    @Override
    public void setOperatorUserName(String operatorUserName) {
        this.operatorUserName = operatorUserName;
    }

    @Override
    public String getOperatorOrgNo() {
        return operatorOrgNo;
    }

    @Override
    public void setOperatorOrgNo(String operatorOrgNo) {
        this.operatorOrgNo = operatorOrgNo;
    }
}
