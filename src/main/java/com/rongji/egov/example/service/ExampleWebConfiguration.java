package com.rongji.egov.example.service;

import com.rongji.egov.app.support.AppSupportConfiguration;
import com.rongji.egov.example.service.filter.DefaultAclLoaderFilter;
import com.rongji.egov.example.service.filter.DefaultNormalInterceptor;
import com.rongji.egov.mybatis.web.interceptor.AclLoaderFilter;
import com.rongji.egov.mybatis.web.interceptor.NormalInterceptor;
import com.rongji.egov.security.service.SecurityServiceConfiguration;
import com.rongji.egov.user.client.UserClientConfiguration;
import com.rongji.egov.utils.mybatis.configuration.MybatisConfiguration;
import com.rongji.egov.utils.spring.configuration.ClientConfiguration;
import com.rongji.egov.utils.spring.configuration.IgnoredPathsConfiguration;
import com.rongji.egov.utils.spring.configuration.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@MapperScan({"com.rongji.egov.example.service.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableTransactionManagement
@Import({WebConfiguration.class,
        SecurityServiceConfiguration.class,
        ClientConfiguration.class,
        UserClientConfiguration.class,
        AppSupportConfiguration.class,
        MybatisConfiguration.class,
        IgnoredPathsConfiguration.class,})
public class ExampleWebConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(ExampleWebConfiguration.class, args);
    }

    @Bean
    public AclLoaderFilter aclLoaderFilter(){
        return new DefaultAclLoaderFilter();
    }

    @Bean
    public NormalInterceptor normalInterceptor(){
        return new DefaultNormalInterceptor();
    }
}
