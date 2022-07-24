package com.foodbox.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 10, name = "contactUser_id")
	private int contactUserId;

	@Column(length = 100, name = "contactUser_name")
	private String userName;

	@Column(length = 100, name = "contactUser_email")
	private String userEmail;

	@Column(length = 12, name = "contactUser_phone")
	private String userPhone;

	@Column(length = 100, name = "contactUser_subject")
	private String userSubject;

	@Column(length = 1500, name = "contactUser_query")
	private String userQuery;

	public ContactUser(int contactId, String userName, String userEmail, String userPhone, String userSubject,
			String userQuery) {
		this.contactUserId = contactId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userSubject = userSubject;
		this.userQuery = userQuery;
	}

	public ContactUser(String userName, String userEmail, String userPhone, String userSubject, String userQuery) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userSubject = userSubject;
		this.userQuery = userQuery;
	}

	public ContactUser() {

	}

	public int getContactId() {
		return contactUserId;
	}

	public void setContactId(int contactId) {
		this.contactUserId = contactId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserSubject() {
		return userSubject;
	}

	public void setUserSubject(String userSubject) {
		this.userSubject = userSubject;
	}

	public String getUserQuery() {
		return userQuery;
	}

	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}

	@Override
	public String toString() {
		return "ContactUser [contactUserId=" + contactUserId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userSubject=" + userSubject + ", userQuery=" + userQuery + "]";
	}

}
