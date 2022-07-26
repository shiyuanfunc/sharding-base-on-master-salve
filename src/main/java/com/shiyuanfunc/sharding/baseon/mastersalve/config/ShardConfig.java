package com.shiyuanfunc.sharding.baseon.mastersalve.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceWrapper;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author MUSI
 * @Date 2022/7/26 11:22 PM
 * @Description
 * @Version
 **/
@Configuration
public class ShardConfig {

    @Bean
    public DataSource shardDatasource() throws SQLException {
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        // 配置主库
        DruidDataSourceWrapper masterDataSource = new DruidDataSourceWrapper();
        masterDataSource.setUsername("root");
        masterDataSource.setPassword("mysqlroot");
        masterDataSource.setUrl("jdbc:mysql://192.168.31.65:53306/shard_01?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        masterDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceMap.put("ds_master", masterDataSource);

        // 配置第一个从库
        DruidDataSourceWrapper slaveDataSource1 = new DruidDataSourceWrapper();
        slaveDataSource1.setUsername("root");
        slaveDataSource1.setPassword("mysqlroot");
        slaveDataSource1.setUrl("jdbc:mysql://192.168.31.65:53406/shard_01?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        slaveDataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSourceMap.put("ds_slave0", slaveDataSource1);

        // 配置读写分离规则
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "ds_master", Arrays.asList("ds_slave0"));
        // 获取数据源对象
        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new Properties());
    }
}
