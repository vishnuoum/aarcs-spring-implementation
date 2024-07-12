package com.app.aarcs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("properties/application-${spring.profiles.active}.properties")
@PropertySource("secrets/secret.properties")
@MapperScan("com.app.aarcs.sqlMappers")
public class ServiceConfiguration {
}
