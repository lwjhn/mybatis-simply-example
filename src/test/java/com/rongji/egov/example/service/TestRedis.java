package com.rongji.egov.example.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.example.service.model.DocPermission;
import com.rongji.egov.mybatis.base.sql.SQLCriteria;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {
    @Resource
    RedisTemplate<String, DocPermission> redisTemplate;

    private final String prefixKey = "doc:permission:user:";

    Logger logger = LoggerFactory.getLogger(TestRedis.class);

    private static final String NORMAL_NAME_TMP="(_|[a-zA-Z])(_|[a-zA-Z0-9])*";
    public static final Pattern PATTERN_TABLE_NAME_LIST= Pattern.compile("^"+NORMAL_NAME_TMP+"((\\.|(\\s)*,(\\s)*|\\sAS\\s)"+NORMAL_NAME_TMP+")*$", Pattern.CASE_INSENSITIVE);
    public static final Pattern PATTERN_NORMAL_NAME = Pattern.compile("^"+NORMAL_NAME_TMP+"$");
    public static final Pattern PATTERN_DOT_NAME= Pattern.compile("^"+NORMAL_NAME_TMP+"(\\."+NORMAL_NAME_TMP+")*$", Pattern.CASE_INSENSITIVE);
    public static final Pattern PATTERN_DOT_NAME_LIST= Pattern.compile("^"+NORMAL_NAME_TMP+"((\\.|(\\s)*,(\\s)*)"+NORMAL_NAME_TMP+")*$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidTableList(String name) {
        return org.apache.commons.lang.StringUtils.isNotBlank(name) && PATTERN_TABLE_NAME_LIST.matcher(name).matches();
    }

    public static boolean isInvalidTableList(String name) {
        return !isValidTableList(name);
    }

    @Test
    public void test3(){
        System.out.println(isInvalidTableList("test"));
        System.out.println(PATTERN_TABLE_NAME_LIST.matcher("abcd.a1").matches());
        System.out.println(PATTERN_TABLE_NAME_LIST.matcher("abcd.1").matches());
        System.out.println(PATTERN_TABLE_NAME_LIST.matcher("abcd as b_1,cde as f1,yccde").matches());
        System.out.println(PATTERN_TABLE_NAME_LIST.matcher("abcd as b_1,cde  f1,yccde").matches());

        Object object = JSONObject.parseObject("{\"expression\": \"count(subEventType)>?\",\n" +
                "    \"value\": [2]}");

        SQLCriteria criteria = JSONObject.toJavaObject((JSON) object, SQLCriteria.class);
        System.out.println(JSON.toJSONString(object));
    }

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
            logger.info(key);
            ValueOperations<String, DocPermission> operations = redisTemplate.opsForValue();
            DocPermission permission1 = operations.get(key);
            //System.out.println(JSON.toJSONString(permission1, true));
            logger.info(JSON.toJSONString(permission1, true));
        } catch (Exception e) {
            logger.error("get DocPermission Error ! ", e);
            //e.printStackTrace();
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
