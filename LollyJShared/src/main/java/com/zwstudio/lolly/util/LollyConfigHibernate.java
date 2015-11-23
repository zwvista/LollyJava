package com.zwstudio.lolly.util;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

@ComponentScan("com.zwstudio.lolly.hibernate.dao")
public class LollyConfigHibernate extends LollyConfigBase {
	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(dataSource())
			.scanPackages("com.zwstudio.lolly.domain")
			.addProperties(properties()).buildSessionFactory();
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		return new HibernateTransactionManager(sessionFactory());
	}
}
