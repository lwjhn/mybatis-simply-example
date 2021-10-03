package com.rongji.egov.example.service.model;

import com.rongji.egov.example.service.base.model.GenericForm;
import com.rongji.egov.mybatis.base.annotation.*;

import java.util.Date;

@SuppressWarnings("unused")
@Table(value = "EGOV_JOURNAL_SUBSCRIPTION", dac = true, mapping = Mapping.UNDERSCORE)
public class Subscription extends GenericForm {
    private boolean govExpense;

    private String subscribeUser;

    @Editor(ACL.USER)
    private String subscribeUserNo;

    private String subscribeOrg;

    @Reader(ACL.ORG)
    private String subscribeOrgNo;

    private Integer subscribeYear;

    private Integer subscribeMonthBegin;

    private Integer subscribeMonthEnd;

    private String clearingForm;

    private Boolean isLeaderProvince;

    private Boolean isLeaderHall;

    private String consignee;

    private Integer verifyStatus;

    private String verifyUser;

    @Editor(ACL.USER)
    private String verifyUserNo;

    private Date subscribeTime;

    private Date verifyTime;

    public boolean isGovExpense() {
        return govExpense;
    }

    public void setGovExpense(boolean govExpense) {
        this.govExpense = govExpense;
    }

    public String getSubscribeUser() {
        return subscribeUser;
    }

    public void setSubscribeUser(String subscribeUser) {
        this.subscribeUser = subscribeUser;
    }

    public String getSubscribeUserNo() {
        return subscribeUserNo;
    }

    public void setSubscribeUserNo(String subscribeUserNo) {
        this.subscribeUserNo = subscribeUserNo;
    }

    public String getSubscribeOrg() {
        return subscribeOrg;
    }

    public void setSubscribeOrg(String subscribeOrg) {
        this.subscribeOrg = subscribeOrg;
    }

    public String getSubscribeOrgNo() {
        return subscribeOrgNo;
    }

    public void setSubscribeOrgNo(String subscribeOrgNo) {
        this.subscribeOrgNo = subscribeOrgNo;
    }

    public Integer getSubscribeYear() {
        return subscribeYear;
    }

    public void setSubscribeYear(Integer subscribeYear) {
        this.subscribeYear = subscribeYear;
    }

    public Integer getSubscribeMonthBegin() {
        return subscribeMonthBegin;
    }

    public void setSubscribeMonthBegin(Integer subscribeMonthBegin) {
        this.subscribeMonthBegin = subscribeMonthBegin;
    }

    public Integer getSubscribeMonthEnd() {
        return subscribeMonthEnd;
    }

    public void setSubscribeMonthEnd(Integer subscribeMonthEnd) {
        this.subscribeMonthEnd = subscribeMonthEnd;
    }

    public String getClearingForm() {
        return clearingForm;
    }

    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }

    public Boolean getLeaderProvince() {
        return isLeaderProvince;
    }

    public void setLeaderProvince(Boolean leaderProvince) {
        isLeaderProvince = leaderProvince;
    }

    public Boolean getLeaderHall() {
        return isLeaderHall;
    }

    public void setLeaderHall(Boolean leaderHall) {
        isLeaderHall = leaderHall;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getVerifyUser() {
        return verifyUser;
    }

    public void setVerifyUser(String verifyUser) {
        this.verifyUser = verifyUser;
    }

    public String getVerifyUserNo() {
        return verifyUserNo;
    }

    public void setVerifyUserNo(String verifyUserNo) {
        this.verifyUserNo = verifyUserNo;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }
}