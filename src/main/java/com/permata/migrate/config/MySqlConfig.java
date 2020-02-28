package com.permata.migrate.config;

import org.springframework.beans.factory.annotation.Autowired;
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

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(basePackages = {"com.permata.migrate.repository.mysql"},
		entityManagerFactoryRef = "db2EntityManager",
		transactionManagerRef = "db2TransactionManager")
public class MySqlConfig {
	@Autowired
	private Environment env;
	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean db2EntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(db2Datasource());
		em.setPackagesToScan(new String[]{"com.permata.migrate.entity.mysql"});
		em.setPersistenceUnitName("db2EntityManager");
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect",
				env.getProperty("spring.jooq.sql-dialect"));
		properties.put("hibernate.show-sql",
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

	@Primary
	@Bean
	public DataSource db2Datasource() {

		DriverManagerDataSource dataSource
				= new DriverManagerDataSource();
		dataSource.setDriverClassName(
				env.getProperty("mysql.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("mysql.datasource.url"));
		dataSource.setUsername(env.getProperty("mysql.datasource.username"));
		dataSource.setPassword(env.getProperty("mysql.datasource.password"));
		return dataSource;
	}

	@Primary
	@Bean
	public PlatformTransactionManager db2TransactionManager() {

		JpaTransactionManager transactionManager
				= new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				db2EntityManager().getObject());
		return transactionManager;
	}
}
