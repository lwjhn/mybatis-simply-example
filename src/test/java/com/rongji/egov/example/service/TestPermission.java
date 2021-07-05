package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.model.SQLSelector;
import com.rongji.egov.mybatis.base.permission.DocPermissionProcessor;
import com.rongji.egov.mybatis.base.permission.IDocPermission;
import com.rongji.egov.mybatis.base.utils.ApplicationUtils;
import com.rongji.egov.mybatis.web.config.RJWebServiceConfig;
import com.rongji.egov.mybatis.web.mapper.NormalMapper;
import com.rongji.egov.mybatis.web.service.NormalService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPermission {
    @Resource
    NormalService normalService;

    IDocPermission getDocPermission() {
        return (new IDocPermission() {
            @Override
            public @NotEmpty String getUserNo() {
                return "U000007";
            }

            @Override
            public Collection<String> getOrgNoList() {
                return new ArrayList<String>(){{
                    add("D00001");
                    add("D00005");
                    add("D00024");
                }};
            }

            @Override
            public Collection<String> getRoleNoList() {
                return new ArrayList<String>(){{
                    add("sys_manager");
                    add("D00005_csfzr");
                }};
            }

            @Override
            public Collection<String> getGroupNoList() {
                return new ArrayList<String>(){{
                    add("D00003_csgly");
                    add("D00005_csfzr");
                }};
            }
        });
    }

    @Resource
    RJWebServiceConfig webServiceConfig;

    @Test
    public void testQueryFormList() {
        System.out.println(JSON.toJSONString(webServiceConfig.getModelMap(),  true));

        InputStream is = null;
        try {
            is = TestPermission.class.getClassLoader().getResourceAsStream("example-full-group.json");   //("select-example-permission.json");
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

            System.out.println(normalService.query(selector, null));
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

    public static Object toBean(HashMap<String, ?> source, Class<?> clazz) {
        try {
            Object obj = clazz.newInstance();
            BeanUtils.populate(obj, source);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void test6(){
        SqlSessionTemplate sqlSessionTemplate = ApplicationUtils.getBean(SqlSessionTemplate.class);
        Configuration configuration = sqlSessionTemplate.getConfiguration();
        ResultMap resultMap;
        for(String key : configuration.getResultMapNames()){
            if(! key.contains(".")) continue;
            System.out.println(key);
            resultMap=configuration.getResultMap(key);
            System.out.println(resultMap.getType() + "-->" + resultMap.getId());
        }
/*
        Map<String, Class<?>> modelMap = new HashMap<>();
        Class<?> clazz;
        System.out.println(configuration);
        System.out.println(configuration.getResultMaps().size());
        int i = 0;
        for(ResultMap resultMap : configuration.getResultMaps()){
            System.out.println(i++);
            System.out.println(resultMap.getClass().getName());
            System.out.println(resultMap.getType() + "-->" + resultMap.getId());
            System.out.println(resultMap);
            *//*clazz=resultMap.getType();
            if(clazz.getAnnotation(TableName.class)==null || modelMap.containsKey(clazz.getName()))
                continue;
            modelMap.put(clazz.getName(), clazz);
            if(clazz.getName().contains("."))
                modelMap.put(clazz.getName().replaceAll(".*\\.","").toLowerCase(), clazz);*//*
        }
        System.out.println(JSON.toJSONString(modelMap,true));*/
    }

//    @Test
//    public void test5() {
//        Class<?> clazz = SubmitReport.class;
//        Set<String> valid = new HashSet<>();
//        do {
//            for (Field field : clazz.getDeclaredFields()) {
//                if(!valid.add(field.getName()))
//                    continue;
//                System.out.print("---> " + field.getName() + " , --->");
//                System.out.println(field.getAnnotation(Permission.class));
//            }
//        } while ((clazz = clazz.getSuperclass()) != null);
//
//        PermissionFieldIterator.iterator(SubmitReport.class, ((permission, field) -> {
//            System.out.print("---> "+field.getName()+" , --->");
//            System.out.println(permission);
//        }));
//    }
}