package com.cc.yht.provider.common;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisConfig {

    /**
     * 驼峰命名
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return (org.apache.ibatis.session.Configuration configuration) ->
                configuration.setMapUnderscoreToCamelCase(true);
    }

    /**
     * PageHelper 分页插件
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        return pageHelper;
    }
}
