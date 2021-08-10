package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.ACL;
import com.rongji.egov.mybatis.base.annotation.Reader;
import com.rongji.egov.mybatis.base.annotation.Table;
import com.rongji.egov.mybatis.base.annotation.TypeHandler;
import com.rongji.egov.mybatis.base.wrapper.JsonTypeHandler;
import com.rongji.egov.utils.spring.validation.InsertValidate;
import com.rongji.egov.utils.spring.validation.UpdateValidate;
import com.rongji.egov.workflow.FlowReaderList;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(value = "EGOV_DUTY_SUBMIT_REPORT", dac = true)
public class SubmitReport extends AbstractWorkflowBase implements Serializable {
    @TypeHandler(value = JsonTypeHandler.class)
    @Reader(prefix = "%\"", suffix = "\"%")
    private FlowReaderList todoReader;
    /**
     * ID
     */
    private String id;
    /**
     * 事件主题
     */
    @NotBlank(message = "标题不能为空", groups = {InsertValidate.class})
    @Length(max = 256, message = "标题超出最大长度256", groups = {UpdateValidate.class, InsertValidate.class})
    private String subject;
    /**
     * 事发地点
     */
    private String eventPlace;
    /**
     * 事发地点编码:["省编码","市编码","县编码"]
     */

    @TypeHandler(value = JsonTypeHandler.class)
    private List<String> eventPlaceNo;
    /**
     * 涉及人数
     */
    private Integer involvePNumber;
    /**
     * 受伤人数
     */
    private Integer injuredPNumber;
    /**
     * 死亡人数
     */
    private Integer deathPNumber;
    /**
     * 失踪人数
     */
    private Integer missingPNumber;
    /**
     * 事发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date eventTime;
    /**
     * 事件类型分9个大类，大类下细分为若干子类。可以在系统配置库中建立类型表。
     * 大类选项有：案件、事件、事故、汛情、震情、森林火灾、疫情、环境污染、前兆信息
     */
    private String eventType;
    /**
     * 情况类型-子类
     */
    private String subEventType;
    /**
     * 接报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date receiveTime;
    /**
     * 选项为：电话、传真、网络、其他
     */
    private String reportType;
    /**
     * 事件原上报单位。
     */
    private String reportUnitName;
    /**
     * 报送单位ID
     */
    private String reportUnitNo;
    /**
     * 来电人/报送人
     */
    private String reportUserName;
    /**
     * 来电人ID/报送人ID
     */
    private String reportUserNo;
    /**
     * 联系电话
     */
    private String reportUserPhone;
    /**
     * 主送领导，系统提供领导人列表供选择。
     */
    @TypeHandler(value = JsonTypeHandler.class)
    private List<String> mainSend;
    /**
     * 抄送领导，系统提供领导人列表供选择。
     */
    @TypeHandler(value = JsonTypeHandler.class)
    private List<String> copySend;
    /**
     * 值班员
     */
    private String draftUserName;
    /**
     * 值班员ID
     */

    @Reader(value = {ACL.USER})
    private String draftUserNo;
    /**
     * 登记部门
     */
    private String draftDeptName;
    /**
     * 登记部门ID
     */
    private String draftDeptNo;
    /**
     * 登记单位
     */
    private String draftUnitName;
    /**
     * 登记单位ID
     */
    private String draftUnitNo;
    /**
     * 拟稿状态（预留）
     */
    private String draftFlag;
    /**
     * 原页面中传阅（为使用传阅件打开可见部分如附件列表等页面）（预留）
     */
    private String readFlag;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    /**
     * 情况描述：紧急情况描述，包括时间、地点、发展态势等。
     */
    private String eventSituation;
    /**
     * 附件，可以附件其他电子背景材料，如传真件电子文件。
     */
    private String attachdesc;
    /**
     * 备注
     */
    private String remark;
    /**
     * 意见栏
     */
    private String opinion;
    /**
     * 值班记录ID
     */
    private String recordId;
    /**
     * 上报端值班记录ID
     */
    private String netRecordId;
    /**
     * 期数：格式为“第XX期”，期数自动计算，可人工干预。
     */
    private String docSequence;
    /**
     * 文件类型：呈报件/呈阅件/电话报件
     */
    private String docCate;
    /**
     * 阅办单信息
     */
    private String dealFormId;
    /**
     * 系统编号
     */
    private String systemNo;
    /**
     * 密级
     */
    private String secLevel;
    /**
     * 批示数量
     */
    private Integer opinionNum;
    /**
     * 办理单位
     */
    private String urgerUnit;
    /**
     * 督查流水号
     */
    private String urgerMark;
    /**
     * 导出政务网
     */
    private String outIntranet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public List<String> getEventPlaceNo() {
        return eventPlaceNo;
    }

    public void setEventPlaceNo(List<String> eventPlaceNo) {
        this.eventPlaceNo = eventPlaceNo;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportUnitName() {
        return reportUnitName;
    }

    public void setReportUnitName(String reportUnitName) {
        this.reportUnitName = reportUnitName;
    }

    public String getReportUnitNo() {
        return reportUnitNo;
    }

    public void setReportUnitNo(String reportUnitNo) {
        this.reportUnitNo = reportUnitNo;
    }

    public List<String> getMainSend() {
        return mainSend;
    }

    public void setMainSend(List<String> mainSend) {
        this.mainSend = mainSend;
    }

    public List<String> getCopySend() {
        return copySend;
    }

    public void setCopySend(List<String> copySend) {
        this.copySend = copySend;
    }

    public String getDraftUserName() {
        return draftUserName;
    }

    public void setDraftUserName(String draftUserName) {
        this.draftUserName = draftUserName;
    }

    public String getDraftUserNo() {
        return draftUserNo;
    }

    public void setDraftUserNo(String draftUserNo) {
        this.draftUserNo = draftUserNo;
    }

    public String getDraftDeptName() {
        return draftDeptName;
    }

    public void setDraftDeptName(String draftDeptName) {
        this.draftDeptName = draftDeptName;
    }

    public String getDraftDeptNo() {
        return draftDeptNo;
    }

    public void setDraftDeptNo(String draftDeptNo) {
        this.draftDeptNo = draftDeptNo;
    }

    public String getDraftUnitName() {
        return draftUnitName;
    }

    public void setDraftUnitName(String draftUnitName) {
        this.draftUnitName = draftUnitName;
    }

    public String getDraftUnitNo() {
        return draftUnitNo;
    }

    public void setDraftUnitNo(String draftUnitNo) {
        this.draftUnitNo = draftUnitNo;
    }

    public String getDraftFlag() {
        return draftFlag;
    }

    public void setDraftFlag(String draftFlag) {
        this.draftFlag = draftFlag;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEventSituation() {
        return eventSituation;
    }

    public void setEventSituation(String eventSituation) {
        this.eventSituation = eventSituation;
    }

    public String getAttachdesc() {
        return attachdesc;
    }

    public void setAttachdesc(String attachdesc) {
        this.attachdesc = attachdesc;
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDocSequence() {
        return docSequence;
    }

    public void setDocSequence(String docSequence) {
        this.docSequence = docSequence;
    }

    public String getDocCate() {
        return docCate;
    }

    public void setDocCate(String docCate) {
        this.docCate = docCate;
    }

    public String getDealFormId() {
        return dealFormId;
    }

    public void setDealFormId(String dealFormId) {
        this.dealFormId = dealFormId;
    }

    public String getSystemNo() {
        return systemNo;
    }

    public Integer getInvolvePNumber() {
        return involvePNumber;
    }

    public void setInvolvePNumber(Integer involvePNumber) {
        this.involvePNumber = involvePNumber;
    }

    public Integer getInjuredPNumber() {
        return injuredPNumber;
    }

    public void setInjuredPNumber(Integer injuredPNumber) {
        this.injuredPNumber = injuredPNumber;
    }

    public Integer getDeathPNumber() {
        return deathPNumber;
    }

    public void setDeathPNumber(Integer deathPNumber) {
        this.deathPNumber = deathPNumber;
    }

    public Integer getMissingPNumber() {
        return missingPNumber;
    }

    public void setMissingPNumber(Integer missingPNumber) {
        this.missingPNumber = missingPNumber;
    }

    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo;
    }

    public String getNetRecordId() {
        return netRecordId;
    }

    public void setNetRecordId(String netRecordId) {
        this.netRecordId = netRecordId;
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName;
    }

    public String getReportUserNo() {
        return reportUserNo;
    }

    public void setReportUserNo(String reportUserNo) {
        this.reportUserNo = reportUserNo;
    }

    public String getReportUserPhone() {
        return reportUserPhone;
    }

    public void setReportUserPhone(String reportUserPhone) {
        this.reportUserPhone = reportUserPhone;
    }

    public String getSecLevel() {
        return secLevel;
    }

    public void setSecLevel(String secLevel) {
        this.secLevel = secLevel;
    }

    public Integer getOpinionNum() {
        return opinionNum;
    }

    public void setOpinionNum(Integer opinionNum) {
        this.opinionNum = opinionNum;
    }

    public String getUrgerUnit() {
        return urgerUnit;
    }

    public void setUrgerUnit(String urgerUnit) {
        this.urgerUnit = urgerUnit;
    }

    public String getUrgerMark() {
        return urgerMark;
    }

    public void setUrgerMark(String urgerMark) {
        this.urgerMark = urgerMark;
    }

    public String getOutIntranet() {
        return outIntranet;
    }

    public void setOutIntranet(String outIntranet) {
        this.outIntranet = outIntranet;
    }

    public String getSubEventType() {
        return subEventType;
    }

    public void setSubEventType(String subEventType) {
        this.subEventType = subEventType;
    }

    public <T> T toTargetObject(Class<T> target) throws Exception {
        T object = target.newInstance();
        BeanUtils.copyProperties(this, object);
        return object;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public FlowReaderList getTodoReader() {
        return todoReader;
    }

    @Override
    public void setTodoReader(FlowReaderList todoReader) {
        this.todoReader = todoReader;
    }
}
