package com.zwstudio.lolly.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class LollyConfigBase {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource bean = new DriverManagerDataSource();
//		bean.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		bean.setUrl("jdbc:sqlserver://ZHAOWEI-PC\\SQLEXPRESS;integratedSecurity=true;databaseName=Lolly");
//		bean.setUsername("ZHAOWEI-PC\\zhaowei");
//		bean.setPassword("");
		
		bean.setDriverClassName("org.sqlite.JDBC");
		bean.setUrl("jdbc:sqlite:E:\\Education\\Lolly\\Lolly.db");
//		bean.setUrl("jdbc:sqlite:C:\\zw\\backup\\Lolly.db");
//		bean.setUrl("jdbc:sqlite:/Users/zwvista/Documents/Programs/Lolly/Lolly.db");
		bean.setUsername("");
		bean.setPassword("");
		
		return bean;
	}
	Properties properties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
		{
//			setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
			setProperty("hibernate.dialect", "com.applerao.hibernatesqlite.dialect.SQLiteDialect");
			setProperty("hibernate.show_sql", "true");
		}};
	}
}
