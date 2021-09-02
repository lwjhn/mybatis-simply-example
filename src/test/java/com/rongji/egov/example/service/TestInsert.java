package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.handler.UpdateHandler;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.mapper.GeneralMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.*;
import com.rongji.egov.mybatis.base.sql.*;
import com.rongji.egov.mybatis.base.utils.StringUtils;
import com.rongji.egov.mybatis.base.wrapper.HashCamelMap;
import com.rongji.egov.workflow.FlowReaderList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestInsert {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void test1() {
        SubmitReport submitReport = new SubmitReport();
        submitReport.setId("T3-" + (new Date()).getTime());
        submitReport.setCreateTime(new Date());
        submitReport.setEventTime(new Date());
        submitReport.setDeathPNumber(1);
        submitReport.setMissingPNumber(3);
        submitReport.setSubject("测试-common-insert-" + new Date().getTime());
        submitReport.setEventType("案件");
        submitReport.setSubEventType("刑事案件");
        submitReport.setDraftUserName("系统管理员");
        submitReport.setDraftDeptNo("U000001");
        SQLInserter inserter = new SQLInserter(submitReport);
        System.out.println(JSON.toJSONString(inserter, true));

        System.out.println(baseMapper.update((new UpdateQuerier()).setSqlHandler(inserter)));
    }

    @Test
    public void test4() {
        String id = "T3-1628779339612";
        SubmitReport submitReport = new SubmitReport();
        submitReport.setId(id);
        submitReport.setCreateTime(new Date());
        submitReport.setEventTime(new Date());
        submitReport.setDeathPNumber(1);
        submitReport.setMissingPNumber(3);
        submitReport.setSubject("修改-2-测试-common-update-" + new Date().getTime());
        submitReport.setEventType("案件");
        submitReport.setSubEventType("刑事案件");
        submitReport.setDraftUserName("系统管理员");
        submitReport.setDraftDeptNo("U000001");
        SQLUpdater updater = new SQLUpdater(submitReport, new SQLCriteria("id = ?", new ArrayList<Object>() {{
            add(id);
        }}));
        System.out.println(JSON.toJSONString(updater, true));

        System.out.println(baseMapper.update(new UpdateQuerier().setSqlHandler(updater)));
    }

    @Test
    public void testDelete() {
        String id = "T3-1628779339612";
        SQLDeleter handle = new SQLDeleter(SubmitReport.class, new SQLCriteria("id LIKE ?", id));
        System.out.println(JSON.toJSONString(handle, true));
        System.out.println(baseMapper.update(new UpdateQuerier().setSqlHandler(handle)));
    }

    @Test
    public void test3() {
        SQLSelector selector = new SQLSelector(
                new SQLCriteria("subject LIKE ?", "%测试%"), SubmitReport.class);
        selector.setLimit(0, 6);
        selector.setFields(SQLWrapper.getSqlFields(SubmitReport.class, true));

        Page<HashCamelMap> test = baseMapper.select(new SelectSimpleQuerier<Page<HashCamelMap>>() {
        }.setSqlHandler(selector));

        Page<HashCamelMap> reportHashCamelMap = baseMapper.select(
                new SelectPageQuerier<HashCamelMap>().setResultMap(HashCamelMap.class).setSqlHandler(selector));

        selector.setFields(SQLWrapper.getSqlFields(SubmitReport.class));
        Page<SubmitReport> reportPage = baseMapper.select(
                new SelectPageQuerier<SubmitReport>()
                        .setResultMap(SubmitReport.class).setSqlHandler(selector));

        List<SubmitReport> reports = baseMapper.select(
                new SelectListQuerier<SubmitReport>()
                        .setResultMap(SubmitReport.class).setSqlHandler(selector));
        FlowReaderList flowReaderList = reports.get(0).getTodoReader();

        selector.setLimit(0, 1);
        SubmitReport report = baseMapper.select(
                new SelectOneQuerier<SubmitReport>()
                        .setResultMap(SubmitReport.class).setSqlHandler(selector));
        System.out.println(JSON.toJSONString(test));
    }

    @Test
    public void test5() {
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher("OFD").matches());
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher("..OFD").matches());
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher(".32OFD").matches());
        System.out.println(StringUtils.camelToUpperUnderscore("eventPlaceNo"));
        System.out.println(StringUtils.camelToLowerUnderline("missingPNumber"));
    }

    public static boolean newFile(File file, byte[] buff) throws Exception {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            os.write(buff);
            os.flush();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            throw e;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
