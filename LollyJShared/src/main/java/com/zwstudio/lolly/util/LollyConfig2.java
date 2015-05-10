package com.zwstudio.lolly.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.zwstudio.lolly.dao")
@EnableTransactionManagement
public class LollyConfig2 {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource bean = new DriverManagerDataSource();
		bean.setDriverClassName("org.sqlite.JDBC");
		bean.setUrl("jdbc:sqlite:E:\\Education\\Lolly\\Lolly.db");
//		bean.setUrl("jdbc:sqlite:C:\\zw\\backup\\Lolly.db");
		bean.setUsername("");
		bean.setPassword("");
		
		return bean;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		return new SqlSessionFactoryBean() {{
			setDataSource(dataSource());
			setTypeAliasesPackage("com.zwstudio.lolly.domain");
		}}.getObject();
	}
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}
