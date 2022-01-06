package com.demo.ersSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.ersSpring.dao.UserDaoRepository;
import com.demo.ersSpring.entity.User;
import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoRepository UDI;
	
	public UserServiceImpl() {
		
	}

	@Override
	public UserPojo login(String email, String password) throws NullReturnException {
		
		
		User user = UDI.getUserByEmail(email, password);
		if (user!= null)
		return new UserPojo(user.getId(),user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(), user.getHomeState(), user.getHomeTown(), user.getAddress());
		
		else throw new NullReturnException("No user found with this email and password");
	}

	@Override
	public UserPojo getUserInfo(int uID) throws NullReturnException {
		UserPojo userPojo = null;
		
		Optional<User> optional = this.UDI.findById(uID);
		if(optional.isPresent()) {
			User user = optional.get();
			userPojo = new UserPojo(user.getId(),user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(), user.getHomeState(), user.getHomeTown(), user.getAddress());
		}
		if (userPojo != null)
		return userPojo;
		else throw new NullReturnException("No user found with id "+ uID);
	}

	@Override
	public void editUser(UserPojo UPJ) {
		User user = new User(UPJ.getId(),UPJ.getUserType(), UPJ.getEmail(), UPJ.getPassword(), UPJ.getScreenName(), UPJ.getHomeState(), UPJ.getHomeTown(), UPJ.getAddress());
		UDI.save(user);
		
	}
	@Override
	public List<UserPojo> getAllUsers() throws NullReturnException{
		List<User> allUsersEntity = this.UDI.findAll();
		List<UserPojo> allUsersPojo = new ArrayList<UserPojo>();
		
		allUsersEntity.forEach((user) -> {
			UserPojo userPojo = new UserPojo(user.getId(),user.getUserType(), user.getEmail(), user.getPassword(), user.getScreenName(),user.getHomeState(), user.getHomeTown(), user.getAddress());
			allUsersPojo.add(userPojo);
		});
		if (!allUsersPojo.isEmpty())
		return allUsersPojo;
		
		else throw new NullReturnException("no users could be found!");
	}
	
	@Override
	public List<UserPojo> getAllManagers() throws NullReturnException{
		List<User> managersEntity = this.UDI.getAllManagers();
		List<UserPojo> managersPojo = new ArrayList<UserPojo>();
		
		managersEntity.forEach((manager) -> {
			managersPojo.add(new UserPojo(manager.getId(),manager.getUserType(), manager.getEmail(), manager.getPassword(), manager.getScreenName(),manager.getHomeState(), manager.getHomeTown(), manager.getAddress()));
		});
		if (!managersPojo.isEmpty())
			return managersPojo;
		else throw new NullReturnException("no managers found!");
	}
	
	
}
