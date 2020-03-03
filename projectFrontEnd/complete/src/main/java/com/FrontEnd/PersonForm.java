package com.FrontEnd;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

	@NotNull
	@Size(min=2, max=30)
	private String userName;

	@NotNull
	@Size(min=2, max=10)
	private String password;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Person(Name: " + this.userName + ", Age: " + this.password + ")";
	}
}
