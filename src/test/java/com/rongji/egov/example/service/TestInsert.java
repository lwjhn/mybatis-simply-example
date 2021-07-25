package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.model.*;
import com.rongji.egov.mybatis.base.utils.StringUtils;
import com.rongji.egov.mybatis.web.service.NormalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestInsert {
    @Resource
    NormalService normalService;

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
        System.out.println(normalService.execute(inserter, null));
    }

    @Test
    public void test4() {
        String id = "T3-1626677444671";
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
        System.out.println(normalService.execute(updater, null));
    }

    @Test
    public void testDelete() {
        String id = "T3-%";
        SQLDeleter handle = new SQLDeleter(SubmitReport.class, new SQLCriteria("id LIKE ?", new ArrayList<Object>() {{
            add(id);
        }}));
        System.out.println(JSON.toJSONString(handle, true));
        System.out.println(normalService.execute(handle, null));
    }

    @Test
    public void test3() {
        System.out.println(normalService.queryCount(new SQLSelector(SubmitReport.class), null));
        System.out.println(normalService.queryCount(new SQLSelector(
                new SQLCriteria("subject LIKE ?",
                        new ArrayList<Object>() {{
                            add("%测试%");
                        }}), SubmitReport.class), null
        ));
    }

    @Test
    public void test5() {
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher("OFD").matches());
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher("..OFD").matches());
        System.out.println(Pattern.compile("^\\.*ofd$", Pattern.CASE_INSENSITIVE).matcher(".32OFD").matches());
        System.out.println(StringUtils.camelToUnderline("eventPlaceNo"));
        System.out.println(StringUtils.camelToUnderline("missingPNumber"));
        System.out.println(StringUtils.camelToUnderline("missingPUABNumber"));
        System.out.println(StringUtils.camelToUnderline("missingPUABNumber12"));
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
