package com.permata.migrate.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = {"com.permata.migrate.repository.db2"},
		entityManagerFactoryRef = "dbEntityManager",
		transactionManagerRef = "dbTransactionManager")
public class DB2Config {
	@Autowired
	private Environment env;
	@Bean
	public LocalContainerEntityManagerFactoryBean dbEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dbDatasource());
		em.setPackagesToScan(new String[]{"com.permata.migrate.entity.db2"});
		em.setPersistenceUnitName("dbEntityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect",
				env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql",
				env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.log",
				env.getProperty("log4j.logger.org.springframework"));
		properties.put("logging.level",
				env.getProperty("logging.level.root"));
		properties.put("logging.level.org.springframework",
				env.getProperty("logging.level.org.springframework.boot"));
		properties.put("spring.main",
				env.getProperty("spring.main.banner-mode"));
		properties.put("hibernate.hbm2ddl.auto",
				env.getProperty("spring.jpa.hibernate.ddl-auto"));
		em.setJpaPropertyMap(properties);
		return em;
	}


	@Bean
	public DataSource dbDatasource() {

		DriverManagerDataSource dataSource
				= new DriverManagerDataSource();
		dataSource.setDriverClassName(
				env.getProperty("db2.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("db2.datasource.url"));
		dataSource.setUsername(env.getProperty("db2.datasource.username"));
		dataSource.setPassword(env.getProperty("db2.datasource.password"));
		return dataSource;
	}



	@Bean
	public PlatformTransactionManager dbTransactionManager() {

		JpaTransactionManager transactionManager
				= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				dbEntityManager().getObject());
		return transactionManager;
	}
}



