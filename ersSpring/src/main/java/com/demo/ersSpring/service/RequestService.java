package com.demo.ersSpring.service;

import java.util.LinkedList;
import java.util.List;

import com.demo.ersSpring.entity.Request;
import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.pojo.RequestPojo;

public interface RequestService {

	public RequestPojo createRequest(RequestPojo RPJ);
	public List<RequestPojo> getRequestsForUser(int userId) throws NullReturnException;
	public List<RequestPojo> getAllRequests() throws NullReturnException;
	public List<RequestPojo> getPendingRequests() throws NullReturnException;
	public List<RequestPojo> getResolvedRequests() throws NullReturnException;
	public void deleteRequest(int requestId);
	public void updateRequest(RequestPojo RPJ);
	public List<RequestPojo> getUserPending(int userId) throws NullReturnException;
	public List<RequestPojo> getUserResolved(int userId) throws NullReturnException;
	
}
