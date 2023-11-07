package com.example.sqldemo.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.sqldemo.*")
public class DBConfig {

    @Value("${sql.url}")
    String url;

    @Value("${sql.username}")
    String username;

    @Value("${sql.password}")
    String password;

    @Value("${sql.driver_class_name}")
    String driverClassName;

    @Value("${sql.hibernate_ddl_auto}")
    String ddlAuto;

    @Value("${sql.show_sql}")
    String showSql;

    @Value("${sql.dialect}")
    String dialect;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.ddl-auto", ddlAuto);
        return properties;
    }

    /*@Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setHibernateProperties(hibernateProperties());
        factoryBean.setPackagesToScan("com.example.sqldemo.entity");

        return factoryBean;
    }

    @Bean
//    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory factory){
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(factory);

        return manager;
    }*/
}