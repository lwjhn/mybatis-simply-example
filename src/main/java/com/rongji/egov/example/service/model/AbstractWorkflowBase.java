package com.rongji.egov.example.service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rongji.egov.mybatis.base.annotation.Permission;
import com.rongji.egov.mybatis.base.annotation.PermissionType.*;

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
    private String stateHandleInfo;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date operatorTime;
    private String operatorUserNo;
    private String operatorUserName;
    private String operatorOrgNo;
}
