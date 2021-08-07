package com.rongji.egov.example.service;

import com.rongji.egov.mybatis.web.permission.IDocPermission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotEmpty;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestSubtable {

    IDocPermission getDocPermission() {
        return (new IDocPermission() {
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
    public void testQueryFormList() {

        InputStream is = null;
        try {
            is = TestSubtable.class.getClassLoader().getResourceAsStream("example-sub-table.json");
            System.out.println(">>> G1");
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];
            int rc = 0;
            while ((rc = is.read(buff, 0, 1024)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            System.out.println(">>> G3 ------------>");
            //SQLSelector selector = JSONObject.parseObject(new String(swapStream.toByteArray()), SQLSelector.class);
            //selector.setModel(SubmitReport.class);
            System.out.println(">>> G4------------->");
           // System.out.println(JSON.toJSONString(normalService.queryPage(selector, null), true));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) try {
                is.close();
            } catch (Exception e) {
            }
        }
    }
}