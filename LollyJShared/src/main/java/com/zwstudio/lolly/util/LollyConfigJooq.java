package com.zwstudio.lolly.util;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

@ComponentScan("com.zwstudio.lolly.hibernate.dao")
public class LollyConfigJooq extends LollyConfigBase {
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSource() {
		return new TransactionAwareDataSourceProxy(dataSource());
	}
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
		return new DataSourceConnectionProvider(dataSource());
	}
	@Bean
	public DefaultConfiguration config() {
		return new DefaultConfiguration() {{
			setSQLDialect(SQLDialect.SQLITE);
			setConnectionProvider(connectionProvider());
		}};
	}
	@Bean
	public DefaultDSLContext dsl() {
		return new DefaultDSLContext(config());
	}
}
