package com.zwstudio.lolly.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.zwstudio.lolly.dao")
@EnableTransactionManagement
public class LollyConfig {
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
		bean.setUsername("");
		bean.setPassword("");
		
		return bean;
	}
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(dataSource())
			.scanPackages("com.zwstudio.lolly.domain")
			.addProperties(new Properties() {{
//				setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
				setProperty("hibernate.dialect", "com.applerao.hibernatesqlite.dialect.SQLiteDialect");
				setProperty("hibernate.show_sql", "true");
			}}).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager transactionManager(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
