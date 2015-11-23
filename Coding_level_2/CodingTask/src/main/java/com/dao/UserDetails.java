/*
 * FileName : UserDetails.java
 * 
 * 
 * Summary : POJO class used as a reference class for adding values to the database
 * 
 * */

package com.dao;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Entity
public class UserDetails implements Serializable {
	// Unique Identifier Number
	@Id
	@NotNull
	@SerializedName("id")
	private int id;

	// First Name
	@NotNull
	@SerializedName("firstName")
	@Length(min = 5)
	private String firstName;

	// Middle Name
	@SerializedName("middleName")
	private String middleName;

	// Last Name
	@NotNull
	@SerializedName("lastName")
	@Length(min = 2)
	private String lastName;

	// Age parameter with constraints
	// (Not null, Value >0 and < 110)
	@NotNull
	@Min(1)
	@Max(110)
	@SerializedName("age")
	private int age;

	// Gender Parameter
	// (Null Value not allowed)
	@SerializedName("gender")
	@NotNull
	private String gender;

	// Phone number
	// (Positive Integer and maximum length =10)
	@SerializedName("phoneNumber")
	@Min(1)
	@Length(max = 10)
	private BigInteger phoneNumber;

	// Zip code optional
	@SerializedName("zip")
	private String zip;

	/*
	 * Getters and Setting method for all the variables
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
