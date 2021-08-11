package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.*;
import com.rongji.egov.utils.mybatis.typehandler.JsonTypeHandler;
import com.rongji.egov.workflow.consts.ModuleFiledConst;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 值班快报
 *
 * @author 赵若帆
 * @date 2021-4-22
 */
@Table(value = "EGOV_DUTY_FAST_REPORT", dac = true)
public class DutyFastReport extends WorkflowBase implements Serializable {
    @Column(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private String id;
    /**
     * 源文件ID
     */
    private String reportId;
    /**
     * 标题
     */
    private String subject;
    /**
     * 刊型
     */
    private String printType;
    /**
     * 发刊日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date publishTime;
    /**
     * 期数
     */
    private String docSequence;
    /**
     * 分送
     */
    @TypeHandler(value = JsonTypeHandler.class)
    private List<String> copySend;
    /**
     * 印制份数
     */
    private Integer printSum;
    /**
     * 值班员
     */
    private String dutyUserName;
    /**
     * 值班员编号
     */
    @Reader(value = ACL.USER)
    private String dutyUserNo;
    /**
     * 详细内容
     */
    private String eventSituation;
    /**
     * 备注
     */
    private String remark;
    /**
     * 意见栏
     */
    private String opinion;
    /**
     * 意见栏数量
     */
    private Integer opinionNum;
    /**
     * 密级
     */
    private String secLevel;
    /**
     * 导出至政务网
     */
    private String outIntranet;
    /**
     * 当前状态
     */
    private String status;
    /**
     * 起草人
     */
    private String draftUser;
    /**
     * 起草人编号
     */
    @Reader(value = ACL.USER)
    private String draftUserNo;
    /**
     * 起草人单位
     */
    private String draftOrg;
    /**
     * 起草人单位ID
     */
    private String draftOrgNo;
    /**
     * 系统编号
     */
    private String systemNo;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getDocSequence() {
        return docSequence;
    }

    public void setDocSequence(String docSequence) {
        this.docSequence = docSequence;
    }

    public List<String> getCopySend() {
        return copySend;
    }

    public void setCopySend(List<String> copySend) {
        this.copySend = copySend;
    }

    public Integer getPrintSum() {
        return printSum;
    }

    public void setPrintSum(Integer printSum) {
        this.printSum = printSum;
    }

    public String getDutyUserName() {
        return dutyUserName;
    }

    public void setDutyUserName(String dutyUserName) {
        this.dutyUserName = dutyUserName;
    }

    public String getDutyUserNo() {
        return dutyUserNo;
    }

    public void setDutyUserNo(String dutyUserNo) {
        this.dutyUserNo = dutyUserNo;
    }

    public String getEventSituation() {
        return eventSituation;
    }

    public void setEventSituation(String eventSituation) {
        this.eventSituation = eventSituation;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Integer getOpinionNum() {
        return opinionNum;
    }

    public void setOpinionNum(Integer opinionNum) {
        this.opinionNum = opinionNum;
    }

    public String getSecLevel() {
        return secLevel;
    }

    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel;
    }

    public String getOutIntranet() {
        return outIntranet;
    }

    public void setOutIntranet(String outIntranet) {
        this.outIntranet = outIntranet;
    }

    public String getDraftUser() {
        return draftUser;
    }

    public void setDraftUser(String draftUser) {
        this.draftUser = draftUser;
    }

    public String getDraftUserNo() {
        return draftUserNo;
    }

    public void setDraftUserNo(String draftUserNo) {
        this.draftUserNo = draftUserNo;
    }

    public String getDraftOrg() {
        return draftOrg;
    }

    public void setDraftOrg(String draftOrg) {
        this.draftOrg = draftOrg;
    }

    public String getDraftOrgNo() {
        return draftOrgNo;
    }

    public void setDraftOrgNo(String draftOrgNo) {
        this.draftOrgNo = draftOrgNo;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>(16);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        map.put(ModuleFiledConst.DOC_ID, this.id);
        map.put(ModuleFiledConst.SUBJECT, this.subject);
        map.put(ModuleFiledConst.DOC_SEQUENCE, this.docSequence);
        map.put(ModuleFiledConst.TEMPLATE_SYSTEM_NO, this.systemNo);
        map.put(ModuleFiledConst.DOC_DATE, dateFormat.format(this.createTime));
        map.put(ModuleFiledConst.BUSINESS_NO, "DUTY");
        map.put(ModuleFiledConst.BUSINESS_CATE, "FAST");
        map.put(ModuleFiledConst.BUSINESS_NAME, "值班快报");
        map.put(ModuleFiledConst.REG_ORG_NAME, this.draftOrg);
        map.put(ModuleFiledConst.SECRET, this.secLevel);
        map.put(ModuleFiledConst.PRIORITY, "无");
        return map;
    }

    public <T> T toTargetObject(Class<T> target) throws Exception {
        T object = target.newInstance();
        org.springframework.beans.BeanUtils.copyProperties(this, object);
        return object;
    }
}

