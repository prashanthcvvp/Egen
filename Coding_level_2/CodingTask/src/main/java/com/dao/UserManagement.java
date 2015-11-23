package com.dao;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;

public interface UserManagement {

	/*********************************************************************************/
	/**
	 * retrieve all the users from the database
	 * 
	 * @param: none
	 * @return : JSONObject
	 **/
	JSONObject getAllUsers();

	/************************************************************************************/
	/**
	 * update a specific user in the database
	 * 
	 * @Params : UserDetails pojo class
	 * @return : HttpStatus
	 * 
	 */
	HttpStatus updateUser(UserDetails usd);

	/*********************************************************************************/
	/**
	 * create new user in the data base
	 * 
	 * @param :
	 *            String
	 * @return : JSONObject
	 */
	String createUser(String user_info_json);
	/*********************************************************************************************/

}