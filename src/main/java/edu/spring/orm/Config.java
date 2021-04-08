package edu.spring.orm;

import edu.spring.orm.entity.Aircraft;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Repository
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:postgresql://localhost:5432/demo", "postgres", "postgres");
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource, Properties hibernateProperties){
        final var factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setAnnotatedClasses(Aircraft.class);
        factoryBean.setHibernateProperties(hibernateProperties);
        return factoryBean;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.setProperty("hibernate.default_schema", "bookings");

        return properties;
    }

    @Bean
    public TransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory) {
        final var transactionManager = new HibernateTransactionManager(sessionFactory);
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
