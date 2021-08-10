package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.plugin.Page;
import com.rongji.egov.mybatis.base.querier.SelectPageQuerier;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.SpringContextUtil;
import com.rongji.egov.mybatis.dac.handler.Acl;
import com.rongji.egov.mybatis.dac.querier.DacSelectPageQuerier;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestACL {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void testQueryFormList() {
        InputStream is = null;
        try {
            is = TestACL.class.getClassLoader().getResourceAsStream("select-example-acl.json");   //("example-full-group.json");   //

            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            selector.setModel(SubmitReport.class);

            Page<SubmitReport> result = baseMapper.select(
                    new SelectPageQuerier<SubmitReport>().setSqlHandler(selector));
            System.out.println(result.getTotal());

            Acl acl = getAcl();

            result = baseMapper.select(
                    new DacSelectPageQuerier<SubmitReport>().setAcl(acl).setSqlHandler(selector));
            System.out.println(result.getTotal());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception ignored) {
            }
        }
    }

    Acl getAcl() {
        return (new Acl() {
            @Override
            public @NotEmpty String getUserNo() {
                return "U000007";
            }

            @Override
            public Collection<String> getOrgNoList() {
                return new ArrayList<String>() {{
                    add("D00001");
                    add("D00005");
                    add("D00024");
                }};
            }

            @Override
            public Collection<String> getRoleNoList() {
                return new ArrayList<String>() {{
                    add("sys_manager");
                    add("D00005_csfzr");
                }};
            }

            @Override
            public Collection<String> getGroupNoList() {
                return new ArrayList<String>() {{
                    add("D00003_csgly");
                    add("D00005_csfzr");
                }};
            }
        });
    }

    @Test
    public void test6() {
        SqlSessionTemplate sqlSessionTemplate = SpringContextUtil.getBean(SqlSessionTemplate.class);
        Configuration configuration = sqlSessionTemplate.getConfiguration();
        //configuration.getResultMaps()
        ResultMap resultMap;
        for (String key : configuration.getResultMapNames()) {
            if (!key.contains(".")) continue;
            System.out.println(key);
            resultMap = configuration.getResultMap(key);
            System.out.println(resultMap.getType() + "-->" + resultMap.getId());
        }

    }
}