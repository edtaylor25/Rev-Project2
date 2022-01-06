package com.demo.ersSpring.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.ersSpring.dao.RequestDaoRepository;
import com.demo.ersSpring.entity.Request;
import com.demo.ersSpring.entity.User;
import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.pojo.RequestPojo;
import com.demo.ersSpring.pojo.UserPojo;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	public RequestDaoRepository RDI;
	
	public RequestServiceImpl() {
		
	}
	
	
	@Override
	public RequestPojo createRequest(RequestPojo RPJ) {
		
		Request req = new Request(RPJ.getUserId(), RPJ.getDate(), RPJ.getAmount(), RPJ.getStatus());
		System.out.println(req);
		req = RDI.saveAndFlush(req);
		RPJ.setId(req.getId());
		return RPJ;
		//RDI.createRequest(RPJ.getId(), RPJ.getDate(), RPJ.getAmount());
		
	}
	

	@Override
	public List<RequestPojo> getRequestsForUser(int userId) throws NullReturnException{
		List<Request> requestsEntity = RDI.getRequestsForUser(userId);
		List<RequestPojo> requestsPojo = new LinkedList<RequestPojo>();
		
		requestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(), request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			requestsPojo.add(requestPojo);
		});
		if (!requestsPojo.isEmpty())
		return requestsPojo;
		else throw new NullReturnException("No requests found for user " + userId);
	}

	@Override
	public List<RequestPojo> getAllRequests() throws NullReturnException{
		List<Request> allRequestsEntity = this.RDI.findAll();
		List<RequestPojo> allRequestsPojo = new LinkedList<RequestPojo>();
		
		allRequestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(), request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			allRequestsPojo.add(requestPojo);
		});
		if (!allRequestsPojo.isEmpty())
		return allRequestsPojo;
		else throw new NullReturnException("No requests found");
	}

	@Override
	public List<RequestPojo> getPendingRequests() throws NullReturnException{
		List<Request> requestsEntity = RDI.getPendingRequests();
		List<RequestPojo> requestsPojo = new LinkedList<RequestPojo>();
		
		requestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(), request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			requestsPojo.add(requestPojo);
		});
		if (!requestsPojo.isEmpty())
		return requestsPojo;
		
		else throw new NullReturnException("No pending requests found");
	}

	@Override
	public List<RequestPojo> getResolvedRequests() throws NullReturnException {
		List<Request> requestsEntity = RDI.getResolvedRequests();
		List<RequestPojo> requestsPojo = new LinkedList<RequestPojo>();
		
		requestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(),request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			requestsPojo.add(requestPojo);
		});
		if (!requestsPojo.isEmpty())
		return requestsPojo;
		else throw new NullReturnException("no resolved requests found");
	}

	@Override
	public void deleteRequest(int requestId) {
		Optional<Request> optional = this.RDI.findById(requestId);
		if(optional.isPresent()) {
			Request req = optional.get();
			req.setStatus("deleted");
			RDI.saveAndFlush(req);
		}
	}

	@Override
	public void updateRequest(RequestPojo RPJ) {
		Request req = new Request(RPJ.getId(),RPJ.getUserId(), RPJ.getDate(), RPJ.getAmount(), RPJ.getStatus());
		RDI.save(req);
	}

	@Override
	public List<RequestPojo> getUserPending(int userId) throws NullReturnException{
		List<Request> requestsEntity = RDI.getUserPending(userId);
		List<RequestPojo> requestsPojo = new LinkedList<RequestPojo>();
		
		requestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(),request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			requestsPojo.add(requestPojo);
		});
		if (!requestsPojo.isEmpty())
		return requestsPojo;
		else throw new NullReturnException("No pending requests found for user " + userId);
	}

	@Override
	public List<RequestPojo> getUserResolved(int userId) throws NullReturnException {
		List<Request> requestsEntity = RDI.getUserResolved(userId);
		List<RequestPojo> requestsPojo = new LinkedList<RequestPojo>();
		
		requestsEntity.forEach((request) -> {
			RequestPojo requestPojo = new RequestPojo(request.getId(),request.getUserId(), request.getDate(), request.getAmount(), request.getStatus());
			requestsPojo.add(requestPojo);
		});
		if (!requestsPojo.isEmpty())
		return requestsPojo;
		else throw new NullReturnException("no pending requests found for user " + userId);
		
	}

}
