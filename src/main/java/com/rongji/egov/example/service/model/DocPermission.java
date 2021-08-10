package com.rongji.egov.example.service.model;

import com.rongji.egov.mybatis.dac.handler.Acl;
import com.rongji.egov.user.model.RmsRole;

import java.io.Serializable;
import java.util.Collection;

public class DocPermission implements Acl, Serializable {
    private String userNo;
    private String orgNo;
    private Collection<String> orgNoList;
    private Collection<String> roleNoList;
    private Collection<String> groupNoList;
    private Collection<RmsRole> rmsRoles;

    @Override
    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    @Override
    public Collection<String> getOrgNoList() {
        return orgNoList;
    }

    public void setOrgNoList(Collection<String> orgNoList) {
        this.orgNoList = orgNoList;
    }

    @Override
    public Collection<String> getRoleNoList() {
        return roleNoList;
    }

    public void setRoleNoList(Collection<String> roleNoList) {
        this.roleNoList = roleNoList;
    }

    @Override
    public Collection<String> getGroupNoList() {
        return groupNoList;
    }

    public void setGroupNoList(Collection<String> groupNoList) {
        this.groupNoList = groupNoList;
    }

    public Collection<RmsRole> getRmsRoles() {
        return rmsRoles;
    }

    public void setRmsRoles(Collection<RmsRole> rmsRoles) {
        this.rmsRoles = rmsRoles;
    }
}
