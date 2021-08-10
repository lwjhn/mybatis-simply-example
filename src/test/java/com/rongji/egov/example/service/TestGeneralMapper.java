package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.pattern.SQLFactory;
import com.rongji.egov.mybatis.base.pattern.verifier.SQLVerifier;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGeneralMapper {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void testGeneralMapper() {
        InputStream is = null;
        try {
            is = TestGeneralMapper.class.getClassLoader().getResourceAsStream("select-example-acl.json");   //("example-full-group.json");   //
            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            selector.setModel(SubmitReport.class);
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

    private static final Pattern PATTERN_WORD = Pattern.compile("\\b[.\\w]+\\b");

    @Test
    public void testGeneric() throws NoSuchFieldException, IllegalAccessException {
        boolean t = ((Class)Integer.class.getField("TYPE").get(null)).isPrimitive();
        t=int.class.isPrimitive();
        t=SubmitReport.class.isPrimitive();
        Object m = Integer.class.getField("TYPE").get(null);
        m = SubmitReport.class.getField("TYPE").get(null);
        System.out.println(m instanceof Class);

        //
        System.out.println(SubmitReport.class.hashCode());

        SQLVerifier.Replicator replicator = s -> {
            System.out.println(s);
            return s;
        };
        String expression="t..k=9k and .test=b.test or DRAFT_USER_NO = B.USER_NO and t1.id=t2.id ";
        expression = SQLVerifier.matchSqlWord(expression, replicator);
        System.out.println(expression);
    }
}