package com.rongji.egov.example.service.model;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.TableName;
import org.apache.commons.lang.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 电子公告
 *
 * @author chenwenkang 上个zhangshiyi
 * @date 2018-9-26
 **/
@TableName("EGOV_DUTY_BBS")
public class Bbs implements Serializable {
  private static final long serialVersionUID = 1L;
  private String id;
  private String subject;
  private String bbsCategory;
  private String bbsLevel;
  /**
   * 0 未发布 1 发布 2 过期 3 撤销
   */
  private String bbsStatus;
  private String publisherNo;
  private String publisherName;
  private String publisherOrgNo;
  private String publisherOrgName;
  private String approverNo;
  private String approverName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp oldPublishDate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp publishDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date validStart;
  private String validStartStr;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date validEnd;
  private String validEndStr;
  /**
   * 有效天数
   */
  private int deleteDate;
  private String attachment;
  private List<String> attList;
  /**
   * 内容
   */
  private String content;
  //byte[]
  private String contentStr;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Timestamp createDate;
  private String url;
  private String title;
  private String bbsCategoryName;
  private String isTop;
  private Timestamp topDate;
  /**
   * 签发人
   */
  private String signUserName;
  /**
   * 流程读者
   */
  private Set<String> readers;

  /**
   * 发布范围读者
   */
  private Set<String> publishReaders;
  /**
   * 解决Set查询问题
   */
  private String queryReaders;
  /**
   * 解决前端多棵树遍历问题，数据由后端遍历完取出去
   */
  private String readerNames;
  /**
   * 点击量
   */
  private int hits;
  /**
   * 是否发布政务外网 1是； 0：否
   */
  private String outerNet;
  /**
   * 公告内容是否来源来word 1:是； 0否
   */
  private String isWord;

  private int sortNo;


  /**
   * 查询时候用到
   */
  private String[] groupList;
  private String currentDate;
  private List<String> publisherOrgNoList;


  /**
   * 高级搜索起始日期
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date beginDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Timestamp queryPublishDate;
  private String beginTime;
  private String endTime;


  /**
   * 预览的时候用
   */
  private JSONObject previewParam;

  private String systemNo;
  private String sourceId;
  private String sourceModule;

  /**
   * solr作业使用 开始时间
   */
  private Date front_RangeStartDate;
  /**
   * solr作业使用 结束时间
   */
  private Date front_RangeEndDate;

  /**
   * 记录用户是否点击 存储json
   */
  private Set<String> hitRecord;

  /**
   * 当前用户是否在首页点击过该条记录
   * 0 没点击过 1 点击过
   */
  private String isClick;

  /**
   * 下发的分支局编号
   */
  private Set<String> issuedBranchNo;

  /**
   * 下发的分支局名称
   */
  private Set<String> issuedBranchName;

  /**
   * 反馈要求
   */
  private String feedbackClaim;

  /**
   * 是否反馈 0-否 1-是
   */
  private String isFeedback;

  /**
   * 反馈期限
   */
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Timestamp feedbackDeadline;

  /**
   * 查询用 当前用户的单位编号
   */
  private String currentUserUnitNo;

  /**
   * 查询分支局用系统编号
   */
  private String searchSystemNo;

  /**
   * 密级
   */
  private String secLevel;

  public String getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(String beginTime) {
    this.beginTime = beginTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getSearchSystemNo() {
    return searchSystemNo;
  }

  public void setSearchSystemNo(String searchSystemNo) {
    this.searchSystemNo = searchSystemNo;
  }

  public String getCurrentUserUnitNo() {
    return currentUserUnitNo;
  }

  public void setCurrentUserUnitNo(String currentUserUnitNo) {
    this.currentUserUnitNo = currentUserUnitNo;
  }

  public Set<String> getIssuedBranchNo() {
    return issuedBranchNo;
  }

  public void setIssuedBranchNo(Set<String> issuedBranchNo) {
    this.issuedBranchNo = issuedBranchNo;
  }

  public Set<String> getIssuedBranchName() {
    return issuedBranchName;
  }

  public void setIssuedBranchName(Set<String> issuedBranchName) {
    this.issuedBranchName = issuedBranchName;
  }

  public String getFeedbackClaim() {
    return feedbackClaim;
  }

  public void setFeedbackClaim(String feedbackClaim) {
    this.feedbackClaim = feedbackClaim;
  }

  public String getIsFeedback() {
    return isFeedback;
  }

  public void setIsFeedback(String isFeedback) {
    this.isFeedback = isFeedback;
  }

  public Timestamp getFeedbackDeadline() {
    return feedbackDeadline;
  }

  public void setFeedbackDeadline(Timestamp feedbackDeadline) {
    this.feedbackDeadline = feedbackDeadline;
  }

  public String getIsClick() {
    return isClick;
  }

  public void setIsClick(String isClick) {
    this.isClick = isClick;
  }

  public Set<String> getHitRecord() {
    return hitRecord;
  }

  public void setHitRecord(Set<String> hitRecord) {
    this.hitRecord = hitRecord;
  }

  public Timestamp getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Timestamp publishDate) {
    this.publishDate = publishDate;
  }

  public Date getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(Date beginDate) {
    this.beginDate = beginDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Set<String> getPublishReaders() {
    return publishReaders;
  }

  public void setPublishReaders(Set<String> publishReaders) {
    this.publishReaders = publishReaders;
  }

  public String getQueryReaders() {
    return queryReaders;
  }

  public void setQueryReaders(String queryReaders) {
    this.queryReaders = queryReaders;
  }

  public Timestamp getOldPublishDate() {
    return oldPublishDate;
  }

  public void setOldPublishDate(Timestamp oldPublishDate) {
    this.oldPublishDate = oldPublishDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getBbsCategory() {
    return bbsCategory;
  }

  public void setBbsCategory(String bbsCategory) {
    this.bbsCategory = bbsCategory;
  }

  public String getBbsLevel() {
    return bbsLevel;
  }

  public void setBbsLevel(String bbsLevel) {
    this.bbsLevel = bbsLevel;
  }

  public String getBbsStatus() {
    return bbsStatus;
  }

  public void setBbsStatus(String bbsStatus) {
    this.bbsStatus = bbsStatus;
  }

  public String getPublisherNo() {
    return publisherNo;
  }

  public void setPublisherNo(String publisherNo) {
    this.publisherNo = publisherNo;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getPublisherOrgNo() {
    return publisherOrgNo;
  }

  public void setPublisherOrgNo(String publisherOrgNo) {
    this.publisherOrgNo = publisherOrgNo;
  }

  public String getPublisherOrgName() {
    return publisherOrgName;
  }

  public void setPublisherOrgName(String publisherOrgName) {
    this.publisherOrgName = publisherOrgName;
  }

  public String getApproverNo() {
    return approverNo;
  }

  public void setApproverNo(String approverNo) {
    this.approverNo = approverNo;
  }

  public String getApproverName() {
    return approverName;
  }

  public void setApproverName(String approverName) {
    this.approverName = approverName;
  }

  public Date getValidStart() {
    return validStart;
  }

  public void setValidStart(Date validStart) {
    this.validStart = validStart;
  }

  public String getValidStartStr() {
    return validStartStr;
  }

  public void setValidStartStr(String validStartStr) {
    this.validStartStr = validStartStr;
  }

  public Date getValidEnd() {
    return validEnd;
  }

  public void setValidEnd(Date validEnd) {
    this.validEnd = validEnd;
  }

  public String getValidEndStr() {
    return validEndStr;
  }

  public void setValidEndStr(String validEndStr) {
    this.validEndStr = validEndStr;
  }

  public int getDeleteDate() {
    return deleteDate;
  }

  public void setDeleteDate(int deleteDate) {
    this.deleteDate = deleteDate;
  }

  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

  public List<String> getAttList() {
    return attList;
  }

  public void setAttList(List<String> attList) {
    this.attList = attList;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContentStr() {
    return contentStr;
  }

  public void setContentStr(String contentStr) {
    this.contentStr = contentStr;
  }

  public Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
    this.createDate = createDate;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBbsCategoryName() {
    return bbsCategoryName;
  }

  public void setBbsCategoryName(String bbsCategoryName) {
    this.bbsCategoryName = bbsCategoryName;
  }

  public String getIsTop() {
    return isTop;
  }

  public void setIsTop(String isTop) {
    this.isTop = isTop;
  }

  public Timestamp getTopDate() {
    return topDate;
  }

  public void setTopDate(Timestamp topDate) {
    this.topDate = topDate;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public String getOuterNet() {
    return outerNet;
  }

  public void setOuterNet(String outerNet) {
    this.outerNet = outerNet;
  }

  public String getIsWord() {
    return isWord;
  }

  public void setIsWord(String isWord) {
    this.isWord = isWord;
  }

  public int getSortNo() {
    return sortNo;
  }

  public void setSortNo(int sortNo) {
    this.sortNo = sortNo;
  }

  public String[] getGroupList() {
    return groupList;
  }

  public void setGroupList(String[] groupList) {
    this.groupList = groupList;
  }

  public String getCurrentDate() {
    return currentDate;
  }

  public void setCurrentDate(String currentDate) {
    this.currentDate = currentDate;
  }

  public JSONObject getPreviewParam() {
    return previewParam;
  }

  public void setPreviewParam(JSONObject previewParam) {
    this.previewParam = previewParam;
  }

  public String getReaderNames() {
    return readerNames;
  }

  public void setReaderNames(String readerNames) {
    this.readerNames = readerNames;
  }

  public String getSecLevel() {
    return secLevel;
  }

  public void setSecLevel(String secLevel) {
    this.secLevel = secLevel;
  }

  public String getSignUserName() {
    return signUserName;
  }

  public void setSignUserName(String signUserName) {
    this.signUserName = signUserName;
  }

  public HashMap<String, Object> toSolrMap() {
    HashMap<String, Object> map = new HashMap<>(15);
    Calendar c = null;
    map.put("S_module", "DUTYBBS");
    map.put("S_moduleDes", "通知公告");
    map.put("S_rjSearchUrl", "");
    map.put("S_businessNo", "DUTYBBS");
    map.put("S_businessName", "通知公告");
    if (this.hitRecord != null && hitRecord.size() > 0) {
      map.put("R_readers", hitRecord.toArray(new String[hitRecord.size()]));
    }
    if (StringUtils.isNotBlank(this.id)) {
      map.put("id", this.id);
    }
    if (StringUtils.isNotBlank(this.subject)) {
      map.put("C_subject", this.subject);
      map.put("S_subject2", this.subject);
    }
    if (this.createDate != null) {
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = sdf.format(this.createDate);
      map.put("S_createTime", dateStr);
      map.put("T_createTime", this.createDate);
      c = Calendar.getInstance();
      c.setTime(this.createDate);
      map.put("I_createYear", c.get(Calendar.YEAR));
      map.put("I_createMonth", c.get(Calendar.MONTH) + 1);
      map.put("I_createDay", c.get(Calendar.DAY_OF_MONTH));
    }
    if (StringUtils.isNotBlank(this.bbsStatus)) {
      map.put("S_bbsStatus", this.bbsStatus);
    }
    if (StringUtils.isNotBlank(this.publisherNo)) {
      map.put("S_publisherNo", this.publisherNo);
    }
    if (StringUtils.isNotBlank(this.publisherName)) {
      map.put("S_publisherName", this.publisherName);
    }
    if (StringUtils.isNotBlank(this.publisherOrgNo)) {
      map.put("S_publisherOrgNo", this.publisherOrgNo);
    }
    if (StringUtils.isNotBlank(this.publisherOrgName)) {
      map.put("S_publisherOrgName", this.publisherOrgName);
    }
    if (StringUtils.isNotBlank(this.approverNo)) {
      map.put("S_approverNo", this.approverNo);
    }
    if (StringUtils.isNotBlank(this.approverName)) {
      map.put("S_approverName", this.approverName);
    }
    if (StringUtils.isNotBlank(this.bbsCategory)) {
      map.put("S_bbsCategory", this.bbsCategory);
    }
    if (StringUtils.isNotBlank(this.bbsCategoryName)) {
      map.put("S_bbsCategoryName", this.bbsCategoryName);
    }
    if (this.publishDate != null) {
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = sdf.format(this.publishDate);
      map.put("S_publishDate", dateStr);
      map.put("T_publishDate", this.publishDate);
      c = Calendar.getInstance();
      c.setTime(this.publishDate);
      map.put("I_publishDateYear", c.get(Calendar.YEAR));
      map.put("I_publishDateMonth", c.get(Calendar.MONTH) + 1);
      map.put("I_publishDateDay", c.get(Calendar.DAY_OF_MONTH));
    }
    if (this.validStart != null) {
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = sdf.format(this.validStart);
      map.put("S_validStart", dateStr);
      map.put("T_validStart", this.validStart);
      c = Calendar.getInstance();
      c.setTime(this.validStart);
      map.put("I_validStartYear", c.get(Calendar.YEAR));
      map.put("I_validStartMonth", c.get(Calendar.MONTH) + 1);
      map.put("I_validStartDay", c.get(Calendar.DAY_OF_MONTH));
    }
    if (this.validEnd != null) {
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = sdf.format(this.validEnd);
      map.put("S_validEnd", dateStr);
      map.put("T_validEnd", this.validEnd);
      c = Calendar.getInstance();
      c.setTime(this.validEnd);
      map.put("I_validEndYear", c.get(Calendar.YEAR));
      map.put("I_validEndMonth", c.get(Calendar.MONTH) + 1);
      map.put("I_validEndDay", c.get(Calendar.DAY_OF_MONTH));
    }
    if (StringUtils.isNotBlank(this.isTop)) {
      map.put("S_isTop", this.isTop);
    }
    if (this.topDate != null) {
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      String dateStr = sdf.format(this.topDate);
      map.put("S_topDate", dateStr);
      map.put("T_topDate", this.topDate);
      c = Calendar.getInstance();
      c.setTime(this.topDate);
      map.put("I_topYear", c.get(Calendar.YEAR));
      map.put("I_topMonth", c.get(Calendar.MONTH) + 1);
      map.put("I_topDay", c.get(Calendar.DAY_OF_MONTH));
    }
    if (StringUtils.isNotBlank(this.systemNo)) {
      map.put("S_systemNo", this.systemNo);
    }
    if (StringUtils.isNotBlank(this.secLevel)) {
      map.put("S_secLevel", this.secLevel);
    }
    //TODO content 和附件还没进去
    return map;
  }

  public String getSystemNo() {
    return systemNo;
  }

  public void setSystemNo(String systemNo) {
    this.systemNo = systemNo;
  }

  public String getSourceId() {
    return sourceId;
  }

  public void setSourceId(String sourceId) {
    this.sourceId = sourceId;
  }

  public String getSourceModule() {
    return sourceModule;
  }

  public void setSourceModule(String sourceModule) {
    this.sourceModule = sourceModule;
  }

  public Date getFront_RangeStartDate() {
    return front_RangeStartDate;
  }

  public void setFront_RangeStartDate(Date front_RangeStartDate) {
    this.front_RangeStartDate = front_RangeStartDate;
  }

  public Date getFront_RangeEndDate() {
    return front_RangeEndDate;
  }

  public void setFront_RangeEndDate(Date front_RangeEndDate) {
    this.front_RangeEndDate = front_RangeEndDate;
  }

  public List<String> getPublisherOrgNoList() {
    return publisherOrgNoList;
  }

  public void setPublisherOrgNoList(List<String> publisherOrgNoList) {
    this.publisherOrgNoList = publisherOrgNoList;
  }
}
