package ru.ketbiev.course_manager.configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
@ComponentScan("ru.ketbiev.course_manager")
@EnableJpaRepositories(basePackages="ru.ketbiev.course_manager.dao")
@EnableWebMvc
public class MyConfig {

//    Этот ViewResolver позволяет нам устанавливать такие свойства, как префикс или суффикс к имени представления, чтобы
//    сгенерировать окончательный URL страницы просмотра:
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    В классе конфигурации нам необходимо определить следующие интерфейсы для пользователя :
//    DataSource
//    EntityManagerFactory (userEntityManager)
//    TransactionManager (userTransactionManager)


//    Для подключения к бд указываем
//    DriverClass (Класс драйвера)
//    JdbcUrl (Адрес)
//    User (Пользователь)
//    Password (Пароль)
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource =
                new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost/test_db");
            dataSource.setUser("postgres");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

//    Затем нам нужно определить AbstractEntityManagerFactoryBean, который
//    отвечает за создание bean-компонента JPA EntityManagerFactory в Spring:
//    Управление сущностями начинается с создания EntityManagerFactory, которая отвечает за отображение объектов
//    в базу, поддержку соединений, кэш состояний и всякие такие вещи. Создание EntityManagerFactory  довольно
//    дорогая операция, поэтому обычно её создают один раз и на всё приложение. А чаще всего не создают сами,
//    а делегируют это фреймворку, такому как Spring, например.
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("ru.ketbiev.course_manager.entity");
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        //additional config of factory
        return entityManagerFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactoryBean().getObject());

        return transactionManager;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//    @Bean
//    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource() {
//        reloadableResourceBundleMessageSource().addBasenames("classpath:validation");
//        return reloadableResourceBundleMessageSource();
//    }
//    Заменяем это

    @Bean(name = "validator")
    public LocalValidatorFactoryBean getLocalValidatorFactoryBean() {
        final LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(this.getMessageSource());
        validator.afterPropertiesSet();
        return validator;
    }

    @Bean(name = "messageSource") // --> !!! This is what is so important!!!
    public MessageSource getMessageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource(); // easily swapped out with  "ReloadableResourceBundleMessageSource", my app just doesn't have any necessary reloadable  message requirements.
        messageSource.setBasenames("classpath:validation"); // static String for a direct path to your "ValidationMessages.properties" file or whatever name you've given it.
        return messageSource;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactory =
                new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.ketbiev.course_manager.entity");

        Properties hibernateProperties =
                new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) throws URISyntaxException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    public void addViewController(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}