package com.demo.ersSpring.service;

import java.util.LinkedList;
import java.util.List;

import com.demo.ersSpring.entity.User;
import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.pojo.UserPojo;

public interface UserService {
	
	public UserPojo login(String email, String password) throws NullReturnException;
	public List<UserPojo> getAllUsers() throws NullReturnException;
	public UserPojo getUserInfo(int uID) throws NullReturnException;
	public void editUser(UserPojo UPJ);
	public List<UserPojo> getAllManagers() throws NullReturnException;
}
