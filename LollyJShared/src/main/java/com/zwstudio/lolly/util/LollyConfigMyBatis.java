package com.zwstudio.lolly.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@MapperScan("com.zwstudio.lolly.mybatis.mappers")
@ComponentScan("com.zwstudio.lolly.mybatis.service")
public class LollyConfigMyBatis extends LollyConfigBase {
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		return new SqlSessionFactoryBean() {{
			setDataSource(dataSource());
			setTypeAliasesPackage("com.zwstudio.lolly.domain");
		}}.getObject();
	}
	@Bean
	public SqlSession sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}
