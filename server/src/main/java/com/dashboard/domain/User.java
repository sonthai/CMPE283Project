package com.dashboard.domain;

import java.util.Date;

public class User {
	private String username;
	private String password;
	private String fullname;
	private Date birthday;

	//Leo's implementation
	//first_name, last_name, account, pwd, email
	private String first_name;
	private String last_name;
	private String account;
	private String pwd;
	private String email;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	//Leo's implementation
	public String getAccount() { return account; }
	public void setAccount(String account) { this.account = account; }

	public String getFirst_name() { return first_name; }
	public void setFirst_name(String first_name) { this.first_name = first_name; }

	public String getLast_name() { return last_name; }
	public void setLast_name(String last_name) { this.last_name = last_name; }

	public String getPwd() { return pwd; }
	public void setPwd(String pwd) { this.pwd = pwd; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}
