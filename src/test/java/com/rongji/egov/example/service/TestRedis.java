package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.DocPermission;
import com.rongji.egov.example.service.model.SubmitReport;
import com.rongji.egov.mybatis.base.model.SQLSelector;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {
    @Resource
    RedisTemplate<String, DocPermission> redisTemplate;

    private final String prefixKey = "doc:permission:user:";

    @Test
    public void test1() {
        DocPermission permission = loadTestData();
        try {
            String key = prefixKey + permission.getUserNo() + ":"
                    + ((StringUtils.isBlank(permission.getOrgNo())) ? "null" : permission.getOrgNo());
            ValueOperations<String, DocPermission> operations = redisTemplate.opsForValue();
            operations.set(key
                    , permission);
            redisTemplate.expire(key, 8, TimeUnit.HOURS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        DocPermission permission = loadTestData();
        try {
            String key = prefixKey + permission.getUserNo() + ":"
                    + ((StringUtils.isBlank(permission.getOrgNo())) ? "null" : permission.getOrgNo());

            ValueOperations<String, DocPermission> operations = redisTemplate.opsForValue();
            DocPermission permission1 = operations.get(key);
            System.out.println(JSON.toJSONString(permission1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void remove() {
        DocPermission permission = loadTestData();
        try {
            String key = prefixKey + permission.getUserNo() + ":"
                    + ((StringUtils.isBlank(permission.getOrgNo())) ? "null" : permission.getOrgNo());
            if (Boolean.TRUE.equals(redisTemplate.hasKey(key)))
                redisTemplate.delete(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DocPermission loadTestData() {
        InputStream is = null;
        try {
            is = TestRedis.class.getClassLoader().getResourceAsStream("file/user-permission.json");
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = is.read(buff, 0, 1024)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            return JSONObject.parseObject(swapStream.toString(), DocPermission.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception ignored) {
            }
        }
    }
}
