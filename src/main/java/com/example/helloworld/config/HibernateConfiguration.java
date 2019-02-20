package com.example.helloworld.config;


import com.example.helloworld.constant.DatabaseConstant;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 *  Init the database config
 * @author dongdong.jiang
 * @date 2019/2/19 11:42
 */
@Configuration
public class HibernateConfiguration {

    @Bean
    @FlywayDataSource
    public DataSource dataSource() {
        System.out.println("*********初始化数据库*********");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl(DatabaseConstant.getDatabaseMapInfo("dbUrl"));
            dataSource.setUsername(DatabaseConstant.getDatabaseMapInfo("dbUserName"));
            dataSource.setPassword(DatabaseConstant.getDatabaseMapInfo("dbPassword"));
        } catch (Exception ex) {
            System.out.println("HibernateConfiguration-dataSource-"+ex.getMessage());
        }
        return dataSource;
    }
}
