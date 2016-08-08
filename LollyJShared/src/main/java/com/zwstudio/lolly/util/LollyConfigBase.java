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
		return new DriverManagerDataSource() {{
//			setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			setUrl("jdbc:sqlserver://ZHAOWEI-PC\\SQLEXPRESS;integratedSecurity=true;databaseName=Lolly");
//			setUsername("ZHAOWEI-PC\\zhaowei");
//			setPassword("");
		
			setDriverClassName("org.sqlite.JDBC");
//			setUrl("jdbc:sqlite:E:\\Education\\Lolly\\LollyDB\\LollyCore.db");
			setUrl("jdbc:sqlite:C:\\zw\\backup\\LollyDB\\LollyCore.db");
//			setUrl("jdbc:sqlite:/Users/zwvista/Documents/Programs/Lolly/LollyDB/LollyCore.db");
			setUsername("");
			setPassword("");
		}};
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
