package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.builder.assistant.Builder;
import com.rongji.egov.mybatis.base.builder.assistant.LambdaHelper;
import com.rongji.egov.mybatis.base.mapper.GeneralMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.querier.SelectSimpleQuerier;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGeneralMapper {
    @Resource
    GeneralMapper generalMapper;

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
        String name = LambdaHelper.fieldName(SubmitReport::getSubject);
        System.out.println(name.length() > 1 ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : name.toLowerCase());
        name="";
        System.out.println(name.length() > 1 ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : name.toLowerCase());
        name="K";
        System.out.println(name.length() > 1 ? Character.toLowerCase(name.charAt(0)) + name.substring(1) : name.toLowerCase());
    }

    @Test
    public void testGeneralMapper() {
        InputStream is = null;
        try {
            is = TestGeneralMapper.class.getClassLoader().getResourceAsStream("select-example-permission.json");   //("example-full-group.json");   //
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
            //System.out.println(JSON.toJSONString(selector, true));

            System.out.println(">>> G4 ------------>");
            //access(selector);
            //QueryHandler<SQLSelector, Page<SubmitReport>> queryHandler = new SelectPageQuerier<>(selector, SubmitReport.class);

            SelectPageQuerier<SubmitReport> queryHandler = new SelectPageQuerier<>(selector, SubmitReport.class);
            Page<SubmitReport> result = generalMapper.select(queryHandler);

            //bject result = generalMapper.select(queryHandler);
            System.out.println(JSON.toJSONString(result, true));

            //List<HashMap<String, ?>> result = ;
            //System.out.println(JSON.toJSONString(result, true));
            System.out.println(">>> G5 ------------>");
//            SubmitReport submitReport = (SubmitReport) toBean(result.get(0), SubmitReport.class);
//            System.out.println(JSON.toJSONString(submitReport, true));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception e) {
            }
        }
    }

    @Test
    public void testGeneric() {
        SQLSelector selector = new SQLSelector();
        SelectSimpleQuerier<Page<SubmitReport>> querier = new SelectSimpleQuerier<Page<SubmitReport>>(selector) {
        };
        System.out.println("-----> 000");
        System.out.println(querier.getResultCommandType());
        System.out.println(querier.getResultMap());

        SelectSimpleQuerier<List<SubmitReport>> querier1 = new SelectSimpleQuerier<List<SubmitReport>>(selector) {
        };

        System.out.println("-----> 111");
        System.out.println(querier1.getResultCommandType());
        System.out.println(querier1.getResultMap());
        SelectSimpleQuerier<SubmitReport> querier2 = new SelectSimpleQuerier<SubmitReport>(selector) {
        };
        System.out.println("-----> 222");
        System.out.println(querier2.getResultCommandType());
        System.out.println(querier2.getResultMap());
//        QueryHandler<SQLSelector, SubmitReport> queryHandler = new QueryHandler<SQLSelector, SubmitReport>(
//                new SQLSelector(),
//                SubmitReport.class);
//        Type type = queryHandler.getClass().getGenericSuperclass();
//        System.out.println(type);
//        BaseQueryHandler<ArrayList<SubmitReport>> baseQueryHandler = new BaseQueryHandler<ArrayList<SubmitReport>>(){};
//        System.out.println(baseQueryHandler.getClassT());
//        Type type = ((ParameterizedType)baseQueryHandler.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        System.out.println(type);
        //Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        if(type instanceof ParameterizedType){
//            ParameterizedType pType = (ParameterizedType)type;
//            if(pType==null){
//                System.out.println("null.....");
//            }else{
//                System.out.println("getRawType====>"+pType.getRawType());
//                System.out.println("getRawType====>"+pType.getTypeName());
//                Type[] cTypes=pType.getActualTypeArguments();
//                for (Type t: cTypes){
//                    System.out.println("getRawType==t==>"+pType.getRawType());
//                    System.out.println("getRawType==t==>"+pType.getTypeName());
//                }
//            }
//        }
    }
}