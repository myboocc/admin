package com.front.operator.bean;

public class User {
	
	private String[] role;
	private String token;
	private String introduction;
	private String avatar;
	private String name;
	public User(String[] role, String token, String introduction, String avatar, String name) {
		super();
		this.role = role;
		this.token = token;
		this.introduction = introduction;
		this.avatar = avatar;
		this.name = name;
	}
	public String[] getRole() {
		return role;
	}
	public void setRole(String[] role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
	}

}
