package com.zwstudio.lolly.util;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@ComponentScan("com.zwstudio.lolly.dao")
public class LollyConfig {
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource bean = new DriverManagerDataSource();
//		bean.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		bean.setUrl("jdbc:sqlserver://ZHAOWEI-PC\\SQLEXPRESS;integratedSecurity=true;databaseName=Lolly");
//		bean.setUsername("ZHAOWEI-PC\\zhaowei");
//		bean.setPassword("");
		
		bean.setDriverClassName("org.sqlite.JDBC");
//		bean.setUrl("jdbc:sqlite:E:\\Education\\Lolly\\Lolly.db");
		bean.setUrl("jdbc:sqlite:C:\\zw\\backup\\Lolly.db");
		bean.setUsername("");
		bean.setPassword("");
		
		return bean;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setPackagesToScan(new String[] { "com.zwstudio.lolly.domain" });
		bean.setHibernateProperties(new Properties() {{
//			setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
			setProperty("hibernate.dialect", "com.applerao.hibernatesqlite.dialect.SQLiteDialect");
			setProperty("hibernate.show_sql", "true");
		}});
		
		return bean;
	}
}
