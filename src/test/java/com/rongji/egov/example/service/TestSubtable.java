package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.mybatis.base.mapper.BaseMapper;
import com.rongji.egov.mybatis.base.querier.SelectListQuerier;
import com.rongji.egov.mybatis.base.sql.SQLSelector;
import com.rongji.egov.mybatis.base.utils.AutoCloseableBase;
import com.rongji.egov.mybatis.base.wrapper.HashCamelMap;
import com.rongji.egov.mybatis.dac.handler.Acl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSubtable {
    @Resource
    BaseMapper baseMapper;

    @Test
    public void testQueryFormList() {
        InputStream is = null;
        try {
            is = TestSubtable.class.getClassLoader().getResourceAsStream("example-sub-table.json");
            assert is != null;
            SQLSelector selector = JSONObject.parseObject(is, SQLSelector.class);
            List<HashCamelMap> result = baseMapper.select(
                    new SelectListQuerier<HashCamelMap>().setResultMap(HashCamelMap.class).setSqlHandler(selector)
            );
            System.out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            AutoCloseableBase.close(is);
        }
    }
}