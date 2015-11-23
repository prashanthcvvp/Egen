/*
 * FileName : UserManagement.java
 * 
 * 
 * Summary : Contains method for creating user, Updating user and retrieve all the users
 * 
 * */

package com.dao;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import com.google.gson.Gson;

public class UserManagementImpl implements UserManagement {

	// Dependency injected
	@Autowired
	private SessionFactory sf;

	/*********************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserManagement#getAllUsers()
	 */
	@Override
	public JSONObject getAllUsers() {
		Session sess = sf.openSession();
		sess.beginTransaction();
		List<UserDetails> listOfRecords = sess.createCriteria(UserDetails.class).list();
		sess.getTransaction().commit();
		sess.close();

		Gson gson = new Gson();
		Object obj = null;
		JSONObject json = null;
		try {
			json = new JSONObject();
			for (int i = 0; i < listOfRecords.size(); i++) {
				obj = gson.toJson(listOfRecords.get(i));
				json.put(String.valueOf(i), obj);
			}
		} catch (JSONException e) {
			System.out.println("JSON Exception");
		}
		return json;
	}

	/************************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserManagement#updateUser(com.dao.UserDetails)
	 */
	@Override
	public HttpStatus updateUser(UserDetails usd) {
		Session sess = null;
		try {
			usd.setId(Math.abs((int) (usd.getFirstName() + usd.getLastName()).hashCode()));
			sess = sf.openSession();
			sess.beginTransaction();
			sess.update(usd);
			sess.getTransaction().commit();

			sess.close();
		} catch (Exception e) {
			sess.getTransaction().rollback();
			sess.close();
			System.out.println("Record Not fount");
			return HttpStatus.NOT_FOUND;
		}

		return HttpStatus.ACCEPTED;
	}

	/*********************************************************************************/
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dao.UserManagement#createUser(java.lang.String)
	 */
	@Override
	public String createUser(String user_info_json) {

		ObjectMapper mapper = new ObjectMapper();
		UserDetails usd = null;
		Session sess = null;
		try {
			usd = mapper.readValue(user_info_json, UserDetails.class);
			usd.setId(Math.abs((int) (usd.getFirstName() + usd.getLastName()).hashCode()));
			sess = sf.openSession();
			sess.beginTransaction();
			sess.save(usd);
			sess.getTransaction().commit();

			sess.close();
		} catch (Exception e) {
			sess.getTransaction().rollback();
			sess.close();
			System.out.println("User Name already exists");
			return "User already exists";
		}
		return "User created";

	}
	/*********************************************************************************************/
}
