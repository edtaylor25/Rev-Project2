package com.demo.ersSpring.controller;


import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.ersSpring.entity.FileDB;
import com.demo.ersSpring.exception.NullReturnException;
import com.demo.ersSpring.message.ResponseFile;
import com.demo.ersSpring.message.ResponseMessage;
import com.demo.ersSpring.pojo.RequestPojo;
import com.demo.ersSpring.pojo.UserPojo;
import com.demo.ersSpring.service.FileStorageService;
import com.demo.ersSpring.service.RequestService;
import com.demo.ersSpring.service.RequestServiceImpl;
import com.demo.ersSpring.service.UserService;
import com.demo.ersSpring.service.UserServiceImpl;



@CrossOrigin
@RestController
@RequestMapping("api")
public class ErsController {

	@Autowired
	RequestService RSI;
	
	@Autowired
	UserService USI;
	
	@Autowired
	private FileStorageService fileStorageService;
	//Exceptions ensure that if no results are obtained, the backend will return an empty list or dummy object instead of a null.
	

	// http://localhost:8080/api/request
	@GetMapping("request")
	public List<RequestPojo> getAllRequests(){
		try {
		List<RequestPojo> requestList = RSI.getAllRequests();
		return requestList;
		} catch (NullReturnException nre) {
			return new LinkedList<RequestPojo>();
		}
	}
	
			
	@GetMapping("request/{uid}")
	public List<RequestPojo> getRequestsForuser(@PathVariable("uid") Integer userId) {
		try {
			return RSI.getRequestsForUser(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@DeleteMapping("request/{rid}")
	public void deleteRequest(@PathVariable("rid") Integer requestId){
		RSI.deleteRequest(requestId);
	}
			
	
	@PostMapping("request")
	public RequestPojo createRequest(@Valid @RequestBody RequestPojo requestPojo){
		return RSI.createRequest(requestPojo);
	}
			
	
	@PutMapping("request")
	public void updateRequest(@Valid @RequestBody RequestPojo requestPojo) {
		RSI.updateRequest(requestPojo);
	}
				
		
	@GetMapping("requestpending")
	public List<RequestPojo> allPending(){
		try {
			return RSI.getPendingRequests();
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	
	@GetMapping("request/pending/{uid}")
	public List<RequestPojo> getUserPending(@PathVariable("uid")Integer userId){
		try {
			return RSI.getUserPending(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("requestresolved")
	public List<RequestPojo> allResolved(){
		try {
			return RSI.getResolvedRequests();
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("request/resolved/{uid}")
	public List<RequestPojo> getUserResolved(@PathVariable("uid") Integer userId){
		try {
			return RSI.getUserResolved(userId);
		} catch (NullReturnException e) {
			return new LinkedList<RequestPojo>();
		}
	}
			
	@GetMapping("user/login/{email}/{password}")
	public UserPojo logIn(@PathVariable("email") String email, @PathVariable("password") String password){
		try {
			return USI.login(email, password);
		} catch (NullReturnException e) {
			return new UserPojo();
		}
	}
			
	@GetMapping("user/{userId}")
	public UserPojo getUserInfo(@PathVariable("userId") Integer userId){
		try {
			return USI.getUserInfo(userId);
		} catch (NullReturnException e) {
			return new UserPojo();
		}
	}
			
	@GetMapping("user")
	public List<UserPojo> getAllUsers(){
		try {
			return USI.getAllUsers();
		} catch (NullReturnException e) {
			return new LinkedList<UserPojo>();
		}
	}
			
	@PutMapping("user")
	public void editUser(@Valid @RequestBody UserPojo userPojo){
		USI.editUser(userPojo);
	}
	
	@GetMapping("manager")
	public List<UserPojo> getAllManagers() {
		try {
			return USI.getAllManagers();
		} catch (NullReturnException nre) {
			return new LinkedList<UserPojo>();
		}
	}
	
	 @PostMapping("image/upload/{rId}")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("rId") int requestId) {
	    String message = "";
	    System.out.println("Hello Picture");
	    try {
	      fileStorageService.store(file, requestId);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	    	e.printStackTrace();
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("image/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = fileStorageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId()+"")
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getName(),
	          fileDownloadUri,
	          dbFile.getType(),
	          dbFile.getPicData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("image/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable("id") int id) {
	    FileDB fileDB = fileStorageService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getPicData());
	  }
	
	
}
