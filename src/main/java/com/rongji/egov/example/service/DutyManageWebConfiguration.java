package com.rongji.egov.example.service;

import com.rongji.egov.utils.mybatis.configuration.MybatisConfiguration;
import com.rongji.egov.utils.spring.configuration.WebConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author daihuabin
 * web层的配置类
 */
@MapperScan({"com.rongji.egov.example.service.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
@Import({MybatisConfiguration.class})
public class DutyManageWebConfiguration {
    public static void main(String[] args) {
        SpringApplication.run(DutyManageWebConfiguration.class, args);
    }

}
