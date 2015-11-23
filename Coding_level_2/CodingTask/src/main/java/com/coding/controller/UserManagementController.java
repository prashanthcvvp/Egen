/*
 * FileName : UserManagementController.java
 * 
 * 
 * Summary : Callback function for different HttpMethods
 * 
 * */

package com.coding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.UserDetails;
import com.dao.UserManagement;
import com.google.gson.Gson;

import net.sf.ehcache.hibernate.HibernateUtil;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

@RestController
@RequestMapping("/user-details")
public class UserManagementController {

	@Autowired
	private UserManagement userManagement;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getUsers() {
		return userManagement.getAllUsers().toString();

	}

	// @RequestParam("user-update")
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody HttpStatus update(@Valid @RequestBody UserDetails usd) {
		return userManagement.updateUser(usd);
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String create(@RequestParam("user") String json) {
		System.out.println("Post method called");
		return userManagement.createUser(json);
	}

}
