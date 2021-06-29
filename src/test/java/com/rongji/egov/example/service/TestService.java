package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.mapper.StatisticMapper;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.model.SQLSelector;
import com.rongji.egov.mybatis.base.utils.SQLChecker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestService {
    @Resource
    StatisticMapper statisticMapper;


    @Test
    public void testQueryFormList() {
        InputStream is = null;
        try {
            is = TestService.class.getClassLoader().getResourceAsStream("select-example.json");
            System.out.println(">>> G1");
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = is.read(buff, 0, 1024)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            //System.out.println(">>> G2 ------------>");
            //System.out.println(new String(swapStream.toByteArray()));
            System.out.println(">>> G3 ------------>");
            SQLSelector selector = JSONObject.parseObject(new String(swapStream.toByteArray()), SQLSelector.class);
            selector.setModel(SubmitReport.class);
            System.out.println(JSON.toJSONString(selector, true));

            System.out.println(">>> G4 ------------>");
            System.out.println(JSON.toJSONString(statisticMapper.query(selector), true));
            System.out.println(">>> G5 ------------>");
            for(Field field : SQLSelector.class.getDeclaredFields()){
                System.out.println(field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception e) {
            }
        }
    }
}