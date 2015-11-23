/*
 * FileName : UserManagementTest.java
 * 
 * 
 * Summary : Test methods for method defined in UserManagement.java class
 * 
 * */

package com.dao;

import java.math.BigInteger;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import com.coding.CodingTastApplicationTests;

@Transactional
public class UserManagementTest extends CodingTastApplicationTests {

	@Autowired
	private UserManagement userManagement;

	// Test Method to create user
	@Test
	public void createUserTest() {
		JSONObject json = new JSONObject();
		try {
			json.put("id", 99);
			json.put("firstName", "abcdef");
			json.put("middleName", "e");
			json.put("lastName", "a b");
			json.put("age", 20);
			json.put("gender", "M");
			json.put("phoneNumber", "01234567789");
			json.put("zip", "123456");

			String status = userManagement.createUser(json.toString());
			if (status.equalsIgnoreCase("User created")) {
				Assert.assertEquals("Failure", "User created", status);
			} else if (status.equalsIgnoreCase("User already exists")) {
				Assert.assertEquals("Failure", "User already exists", status);
			}
		} catch (JSONException e) {
			System.out.println("JSON Exception");
		}
	}

	/*************************************************************************************/
	// Test Method to update user information
	@Test
	public void updateUserTest() {
		UserDetails usd = new UserDetails();
		try {
			usd.setId(99);
			usd.setFirstName("abcdef");
			usd.setMiddleName("f");
			usd.setLastName("a b");
			usd.setAge(-200);
			usd.setGender("M");

			usd.setPhoneNumber(new BigInteger("9876543210"));
			usd.setZip("654321");

			HttpStatus status = userManagement.updateUser(usd);
			Assert.assertEquals("Failure", HttpStatus.ACCEPTED, status);

			usd.setId(99);
			usd.setFirstName("agf");
			usd.setMiddleName("t");
			usd.setLastName("s b");
			usd.setAge(-29);
			usd.setGender("M");
			usd.setPhoneNumber(new BigInteger("9876543210"));
			usd.setZip("654321");
			status = userManagement.updateUser(usd);
			Assert.assertEquals("Failure", HttpStatus.NOT_FOUND, status);

		} catch (Exception e) {
			System.out.println("JSON Exception");
		}
	}

	/***************************************************************************************/
	// Test Method to get all the user from database.
	@Test
	public void getAllUsersTest() {
		JSONObject jsonTest = userManagement.getAllUsers();

		Assert.assertNotNull("Failure - Null returned by getAllUsers", jsonTest);
		Assert.assertEquals("Failure - expected size", 3, jsonTest.length());

	}

}
