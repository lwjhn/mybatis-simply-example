package com.rongji.egov.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestModelScanner {
    @Test
    public void test1() {
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        ClassPathModelScanner scanner = new ClassPathModelScanner(registry);

        Collection<String> pkg = new ArrayList<String>() {{
            add("com.rongji.egov.example.service.model");
        }};
        Set<BeanDefinitionHolder> beanDefinitionHolders = scanner.doScan(StringUtils.toStringArray(pkg));
        System.out.println(beanDefinitionHolders.size());
    }
}
