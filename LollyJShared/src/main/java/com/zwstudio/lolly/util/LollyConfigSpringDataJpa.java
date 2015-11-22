package com.zwstudio.lolly.util;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@EnableJpaRepositories("com.zwstudio.lolly.spring.data.jpa")
public class LollyConfigSpringDataJpa extends LollyConfigBase {
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return new LocalContainerEntityManagerFactoryBean() {{
			setDataSource(dataSource());
			setJpaVendorAdapter(new HibernateJpaVendorAdapter());
			setPackagesToScan("com.zwstudio.lolly.domain");
			setJpaProperties(properties());
		}};
	}
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
