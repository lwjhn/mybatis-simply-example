package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
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
import java.util.*;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestInsert {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void test1() {
        Map<String, Object> values = new HashMap<String, Object>(){{
            put(LambdaHelper.fieldName(SubmitReport::getId), "T3-" + (new Date()).getTime());
            put(LambdaHelper.fieldName(SubmitReport::getCreateTime), new Date());
            put(LambdaHelper.fieldName(SubmitReport::getEventTime), new Date());
            put(LambdaHelper.fieldName(SubmitReport::getDeathPNumber), 1);
            put(LambdaHelper.fieldName(SubmitReport::getMissingPNumber), 3);
            put(LambdaHelper.fieldName(SubmitReport::getSubject), Builder.register(SQLCriteria::new)
                    .set(SQLCriteria::setExpression, "? + NEWID()")
                    .set(SQLCriteria::setValue, new ArrayList<Object>(){{
                        add("测试-insert-");
                    }}).build());
            put(LambdaHelper.fieldName(SubmitReport::getEventType), "案件");
            put(LambdaHelper.fieldName(SubmitReport::getSubEventType), "刑事案件");
            put(LambdaHelper.fieldName(SubmitReport::getDraftDeptNo), "U000001");
        }};

        SQLInserter inserter = new SQLInserter(SubmitReport.class, values);
        System.out.println(JSON.toJSONString(inserter, true));
        System.out.println(baseMapper.update((new UpdateQuerier()).setSqlHandler(inserter)));
    }

    @Test
    public void test4() {
        String id = "T3-1634811784107";
        Map<String, Object> values = new HashMap<String, Object>(){{
            put(LambdaHelper.fieldName(SubmitReport::getSubject), Builder.register(SQLCriteria::new)
                    .set(SQLCriteria::setExpression, LambdaHelper.fieldName(SubmitReport::getSubject) + "+ ? + NEWID()")
                    .set(SQLCriteria::setValue, new ArrayList<Object>(){{
                        add("--->>>--new->>>");
                    }}).build());
        }};

        SQLUpdater updater = new SQLUpdater(SubmitReport.class, values, new SQLCriteria("id = ?", new ArrayList<Object>() {{
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
