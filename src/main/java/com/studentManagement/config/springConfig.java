package com.studentManagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("com.studentManagement.service")
@Import({mybatisConfig.class,druidConfig.class})
public class springConfig {

}
