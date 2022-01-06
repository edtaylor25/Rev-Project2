package com.demo.ersSpring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//default bean id is camel casing of the class- userPojo
@Component
public class UserPojo {
	private int id;
	private String userType= "_";
	private String email= "_";
	private String password= "_";
	private String screenName = "_";
	private String homeState= "_";
	private String homeTown= "_";
	private String address = "_";
	
	public UserPojo(int id, String pLevel, String email, String pass, String screen_name, String home_state, String home_town, String address) {
		this.id=id;
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
		this.screenName=screen_name;
		this.homeState=home_state;
		this.homeTown = home_town;
		this.address = address;
	}
	
	public UserPojo(int id, String pLevel, String email, String pass) {
		this.id=id;
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
	}
	

	public UserPojo(String pLevel, String email, String pass, String screen_name, String home_state, String home_town, String address) {
		this.userType=pLevel;
		this.email = email;
		this.password = pass;
		this.screenName=screen_name;
		this.homeState=home_state;
		this.homeTown = home_town;
		this.address = address;
	}
	public UserPojo() {
		
	}
	
	@Value("88")
	public void setId(int id) {
		this.id = id;
	}

	@Value("employee")
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Value("")
	public void setEmail(String email) {
		this.email = email;
	}
	@Value("")
	public void setPassword(String password) {
		this.password = password;
	}

	@Value("")
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	@Value("")
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	@Value("")
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	@Value("")
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getId() {
		return this.id;
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
