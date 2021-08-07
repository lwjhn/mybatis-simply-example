package com.rongji.egov.example.service;

import com.rongji.egov.mybatis.base.utils.SpringContextUtil;
import com.rongji.egov.mybatis.web.permission.IDocPermission;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotEmpty;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestPermission {

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


    @Test
    public void testQueryFormList() {
        InputStream is = null;
        try {
            is = TestPermission.class.getClassLoader().getResourceAsStream("select-example-permission.json");   //("example-full-group.json");   //
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

            //System.out.println(JSON.toJSONString(selector, true));

            System.out.println(">>> G4 ------------>");
            //access(selector);
            //Object result = normalService.query(selector, null, ServiceType.formal);

            //System.out.println(JSON.toJSONString(result, true));
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
    public void test6(){
        SqlSessionTemplate sqlSessionTemplate = SpringContextUtil.getBean(SqlSessionTemplate.class);
        Configuration configuration = sqlSessionTemplate.getConfiguration();
        //configuration.getResultMaps()
        ResultMap resultMap;
        for(String key : configuration.getResultMapNames()){
            if(! key.contains(".")) continue;
            System.out.println(key);
            resultMap=configuration.getResultMap(key);
            System.out.println(resultMap.getType() + "-->" + resultMap.getId());
        }

    }
}