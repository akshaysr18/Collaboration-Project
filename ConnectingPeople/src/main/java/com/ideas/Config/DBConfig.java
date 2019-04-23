package com.ideas.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ideas.model.Blog;
import com.ideas.model.BlogComment;
import com.ideas.model.Forum;
import com.ideas.model.ForumComment;
import com.ideas.model.Friend;
import com.ideas.model.Job;
import com.ideas.model.ProfilePicture;
import com.ideas.model.UserDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ideas")
public class DBConfig 
{
public DataSource getDataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	dataSource.setUsername("AKSHAYSR");
	dataSource.setPassword("1234");

	return dataSource;
}

@Bean(name="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateProp=new Properties();
	hibernateProp.put("hibernate.hbm2ddl.auto","update");
	hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	LocalSessionFactoryBuilder factoryBuilder =new LocalSessionFactoryBuilder(getDataSource());
	factoryBuilder.addProperties(hibernateProp);
	
	factoryBuilder.addAnnotatedClass(Blog.class);	
	factoryBuilder.addAnnotatedClass(BlogComment.class);
	factoryBuilder.addAnnotatedClass(UserDetail.class);
	factoryBuilder.addAnnotatedClass(Job.class);
	factoryBuilder.addAnnotatedClass(Forum.class);
	factoryBuilder.addAnnotatedClass(ForumComment.class);
	factoryBuilder.addAnnotatedClass(Friend.class);
	factoryBuilder.addAnnotatedClass(ProfilePicture.class);



	
	SessionFactory sessionFactory=factoryBuilder.buildSessionFactory();
	System.out.println("---SessionFactory Object  Created ----");
    return sessionFactory;
    

}
@Bean(name="txManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	System.out.println("---Transaction Manager object Created--");
	return new HibernateTransactionManager(sessionFactory);
}

}
