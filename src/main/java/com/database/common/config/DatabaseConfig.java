package com.database.common.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@PropertySource("classpath:database.properties")
@EnableJpaRepositories(basePackages = "com.database.common.repository")
@EnableTransactionManagement
@Profile("dev")
public class DatabaseConfig {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();	
		em.setJpaVendorAdapter(jpaVendorAdapter);
		em.setPackagesToScan(new String[] { "com.database.common.entity" });
		em.setJpaProperties(additionalProperties());
		return em;
	}

	@Primary
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.connection.url", env.getProperty("spring.datasource.url"));
		properties.setProperty("hibernate.connection.driver_class", env.getProperty("spring.datasource.driverClassName"));
		properties.setProperty("hibernate.connection.username", env.getProperty("spring.datasource.username"));
		properties.setProperty("hibernate.connection.password", env.getProperty("spring.datasource.password"));
		properties.setProperty("hibernate.hbm2ddl.auto", "create");
		System.out.println(properties);
		
		return properties;
	}

}
