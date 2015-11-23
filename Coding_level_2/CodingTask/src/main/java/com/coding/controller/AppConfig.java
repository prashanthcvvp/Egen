/*
 * FileName : AppConfig.java
 * 
 * 
 * Summary : Java Configuration file.
 * 
 * */

package com.coding.controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dao.UserDetails;
import com.dao.UserManagement;
import com.dao.UserManagementImpl;

@Configuration
public class AppConfig {

	@Bean
	public SessionFactory sessionFactory() {
		return new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Bean
	public UserManagement userManagement() {
		return new UserManagementImpl();
	}
}
