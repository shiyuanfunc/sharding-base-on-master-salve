package com.shiyuanfunc.sharding.baseon.mastersalve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.shiyuanfunc.sharding.baseon.mastersalve.mapper")
public class ShardingBaseOnMasterSalveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingBaseOnMasterSalveApplication.class, args);
    }

}
