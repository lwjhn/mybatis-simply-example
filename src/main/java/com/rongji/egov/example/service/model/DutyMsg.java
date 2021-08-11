package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.ACL;
import com.rongji.egov.mybatis.base.annotation.Column;
import com.rongji.egov.mybatis.base.annotation.Reader;
import com.rongji.egov.mybatis.base.annotation.Table;
import com.rongji.egov.workflow.consts.ModuleFiledConst;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 福建值班信息
 *
 * @author fanor&2814794291@qq.com
 * @date 2021-4-2215
 */
@Table(value = "EGOV_DUTY_MSG", dac = true)
public class DutyMsg extends WorkflowBase implements Serializable {
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
     * 签发人标号
     */
    private String approveUserNo;

    /**
     * 签发人姓名
     */
    private String approveUserName;

    /**
     * 编辑人姓名
     */
    private String dutyUserName;

    /**
     * 编辑人编号
     */
    @Reader(value = ACL.USER)
    private String dutyUserNo;

    /**
     * 上报单位编号
     */
    private String reportUnitNo;

    /**
     * 上报单位名称
     */
    private String reportUnitName;

    /**
     * 国办采用
     */
    private String isUse;

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
     * 起草人
     */
    @Reader(value = ACL.USER)
    private String draftUser;

    /**
     * 起草人编号
     */
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

    public String getApproveUserNo() {
        return approveUserNo;
    }

    public void setApproveUserNo(String approveUserNo) {
        this.approveUserNo = approveUserNo;
    }

    public String getApproveUserName() {
        return approveUserName;
    }

    public void setApproveUserName(String approveUserName) {
        this.approveUserName = approveUserName;
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

    public String getReportUnitNo() {
        return reportUnitNo;
    }

    public void setReportUnitNo(String reportUnitNo) {
        this.reportUnitNo = reportUnitNo;
    }

    public String getReportUnitName() {
        return reportUnitName;
    }

    public void setReportUnitName(String reportUnitName) {
        this.reportUnitName = reportUnitName;
    }

    public String getIsUse() {
        return isUse;
    }

    public void setIsUse(String isUse) {
        this.isUse = isUse;
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
        map.put(ModuleFiledConst.BUSINESS_CATE, "MSG");
        map.put(ModuleFiledConst.BUSINESS_NAME, "福建值班信息");
        map.put(ModuleFiledConst.REG_ORG_NAME, this.draftOrg);
        map.put(ModuleFiledConst.SECRET, this.secLevel);
        map.put(ModuleFiledConst.PRIORITY, "无");
        return map;
    }

    public <T> T toTargetObject(Class<T> target) throws Exception{
        T object = target.newInstance();
        org.springframework.beans.BeanUtils.copyProperties(this,object);
        return object;
    }
}
