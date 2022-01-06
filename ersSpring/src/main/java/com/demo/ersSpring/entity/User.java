package com.demo.ersSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_info")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	@Column(name="permission_level")
	private String userType= "_";
	@Column(name="email")
	private String email= "_";
	@Column(name="password")
	private String password= "_";
	@Column(name="screen_name")
	private String screenName = "_";
	@Column(name="home_state")
	private String homeState= "_";
	@Column(name="home_town")
	private String homeTown= "_";
	@Column(name="address")
	private String address = "_";
	
	public User(int id, String pLevel, String email, String pass, String screen_name, String home_state, String home_town, String address) {
		this.id=id;
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
		this.screenName=screen_name;
		this.homeState=home_state;
		this.homeTown = home_town;
		this.address = address;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User(String pLevel, String email, String pass, String screen_name, String home_state, String home_town, String address) {
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
		this.screenName=screen_name;
		this.homeState=home_state;
		this.homeTown = home_town;
		this.address = address;
	}
	public User() {
		
	}
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId() {
		
	}
	
	public String getUserType() {
		return this.userType;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
	public String getHomeState() {
		return this.homeState;
	}
	
	public String getHomeTown() {
		return this.homeTown;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	
	public String toString() {
		return "UserPojo [userId=" + id + ", permissionLevel=" + userType + ", email=" + email + ", password="
				+ password + ", screenName=" + screenName + ", homeState=" + homeState + ", homeTown=" + homeTown + ", address=" + address+"]";
	}
}