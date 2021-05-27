package com.mqc.seatademo.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 数据源配置
 */
@Configuration
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.ds0")
    public DruidDataSource ds0(){
        DruidDataSource druidDataSource =  new DruidDataSource();
        return druidDataSource;
    }

    /**
     * seata框架代理数据源
     * @param ds0
     * @return
     */
    @Primary
    @Bean
    public DataSource dataSource(DruidDataSource ds0)  {
        DataSourceProxy pds0 = new DataSourceProxy(ds0);
        return pds0;
    }
}
