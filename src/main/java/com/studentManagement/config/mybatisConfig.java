package com.studentManagement.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan("com.studentManagement.mapper")
public class mybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
       //Interceptor interceptor=new  com.github.pagehelper.PageInterceptor();
        SqlSessionFactoryBean ssfb=new SqlSessionFactoryBean();
        ssfb.setDataSource(dataSource);
        ssfb.setTypeAliasesPackage("com.studentManagement.pojo");
        //ssfb.setPlugins(interceptor);
        Interceptor pageInterceptor=new PageInterceptor();
        Properties properties = new Properties();
        //properties.setProperty("dialect", "mysql"); // 配置 MySQL 方言
        properties.setProperty("reasonable", "true"); // 启用合理化查询，将 PageNum 和 PageSize 传给后台
        properties.setProperty("supportMethodsArguments", "true"); // 支持通过 Mapper 接口参数来传递分页参数
        pageInterceptor.setProperties(properties);
        ssfb.setPlugins(pageInterceptor);
        return ssfb;

    }
}
