package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.MyUmsOrg;
import com.rongji.egov.example.service.model.MyUmsUser;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.pattern.SQLFactory;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.*;
import com.rongji.egov.mybatis.base.sql.*;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import com.rongji.egov.mybatis.base.wrapper.HashCamelMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJoin {
    @Resource
    BaseMapper baseMapper;

    /*
(
    SELECT SubmitReport.SUBJECT AS Subject, SubmitReport.EVENT_TYPE AS eventType, SubmitReport.INVOLVE_P_NUMBER AS involvePNumber,
            MyUmsUser.SHORT_NAME AS shortName, MyUmsUser.EMAIL AS email,
            MyUserOrgRelate.USER_NO AS userNo, MyUserOrgRelate.ORG_NO AS orgNo,
            MyUmsOrg.ORG_NAME_LIST AS orgNameList, MyUmsOrg.ORG_NO_LIST AS orgNoList
    FROM EGOV_DUTY_SUBMIT_REPORT AS SubmitReport
        JOIN (UMS_USER AS MyUmsUser
                JOIN UMS_USER_ORG_RELATE AS MyUserOrgRelate ON MyUserOrgRelate.USER_NO=MyUmsUser.USER_NO
             )
        ON MyUmsUser.USER_NO = SubmitReport.DRAFT_USER_NO
        LEFT JOIN UMS_ORG AS MyUmsOrg ON MyUmsOrg.ORG_NO = MyUserOrgRelate.ORG_NO
    LIMIT 0, 5
)
    */
    @Test
    public void testJoin() {
        InputStream is = null;
        try {
            is = TestGeneralMapper.class.getClassLoader().getResourceAsStream("example-join-1.json");
            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            System.out.println(JSON.toJSONString(selector));
            System.out.println(SQLFactory.generate(selector, (o, o1) -> "?"));

            Page<HashCamelMap> result = baseMapper.select(
                    new SelectPageQuerier<HashCamelMap>().setResultMap(HashCamelMap.class).setSqlHandler(selector)
            );

            System.out.println(JSON.toJSONString(result, true));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AutoCloseableBase.close(is);
        }
    }

    @Test
    public void test3() {
        SQLSelector selector = new SQLSelector(MyUmsOrg.class);
        selector.setLimit(new ArrayList<Integer>() {{
            add(0);
            add(6);
        }});
        selector.setFields(SQLWrapper.getSqlFields(MyUmsOrg.class, true));

        Page<HashCamelMap> test = baseMapper.select(new SelectSimpleQuerier<Page<HashCamelMap>>() {
        }.setSqlHandler(selector));

        System.out.println(JSON.toJSONString(test));
    }
}
