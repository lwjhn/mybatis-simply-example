package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.DutyFastReport;
import com.rongji.egov.example.service.model.DutyMsg;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.SQLWrapper;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.pattern.SQLFactory;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.querier.SelectSimpleQuerier;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGeneralMapper {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void testGeneralMapper() {
        InputStream is = null;
        try {
            //group-order-expression.json   group-order-string.json   group-order-list.json
            is = TestGeneralMapper.class.getClassLoader().getResourceAsStream("group-order-list.json");
            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            System.out.println(JSON.toJSONString(selector));
            System.out.println(SQLFactory.generate(selector, (o, o1) -> "?"));

            Page<SubmitReport> result = baseMapper.select(
                    new SelectPageQuerier<SubmitReport>().setResultMap(SubmitReport.class).setSqlHandler(selector)
            );

            System.out.println(JSON.toJSONString(result, true));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AutoCloseableBase.close(is);
        }
    }

    @Test
    public void test7() throws Exception {
        SubmitReport submitReport = Builder.register(SubmitReport::new)
                .set(SubmitReport::setSubject, "测试标题")
                .set(SubmitReport::setCopySend, new ArrayList<String>() {{
                    add("抄送---->");
                }})
                .build();

        System.out.println(LambdaHelper.methodName(SubmitReport::getSubject));
        System.out.println(LambdaHelper.fieldName(SubmitReport::getSubject));
    }

    @Test
    public void testGeneric() {
        SQLCriteria criteria = new SQLCriteria("NOT(passReader IS NULL)");
        List<Integer> limit = new ArrayList<Integer>() {{
            add(0);
            add(6);
        }};

        Page<?> result = baseMapper.select(new SelectSimpleQuerier<Page<SubmitReport>>() {
        }.setSqlHandler(Builder.register(SQLSelector::new).set(SQLSelector::setModel, SubmitReport.class)
                .set(SQLSelector::setFields,
                        SQLWrapper.getSqlFields(SubmitReport.class))
                .set(SQLSelector::setWhere, criteria)
                .set(SQLSelector::setLimit, limit).build()));

        System.out.println(JSON.toJSONString(result));

        result = baseMapper.select(new SelectSimpleQuerier<Page<DutyFastReport>>() {
        }.setSqlHandler(Builder.register(SQLSelector::new).set(SQLSelector::setModel, DutyFastReport.class)
                .set(SQLSelector::setFields,
                        SQLWrapper.getSqlFields(DutyFastReport.class))
                .set(SQLSelector::setWhere, criteria)
                .set(SQLSelector::setLimit, limit).build()));
        System.out.println(JSON.toJSONString(result));

        result = baseMapper.select(new SelectSimpleQuerier<Page<DutyMsg>>() {
        }.setSqlHandler(Builder.register(SQLSelector::new).set(SQLSelector::setModel, DutyMsg.class)
                .set(SQLSelector::setFields,
                        SQLWrapper.getSqlFields(DutyMsg.class))
                .set(SQLSelector::setWhere, criteria)
                .set(SQLSelector::setLimit, limit).build()));
        System.out.println(JSON.toJSONString(result));
    }
}