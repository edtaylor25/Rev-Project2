package com.demo.ersSpring.message;

import java.io.IOException;
import java.util.stream.Stream;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.demo.ersSpring.entity.FileDB;
import com.demo.ersSpring.repository.FileDBRepository;


public class ResponseFile {

	 private String name;
	  private String url;
	  private String type;
	  private long size;

	  public ResponseFile(String name, String url, String type, long size) {
	    this.name = name;
	    this.url = url;
	    this.type = type;
	    this.size = size;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getUrl() {
	    return url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public long getSize() {
	    return size;
	  }

	  public void setSize(long size) {
	    this.size = size;
	  }
	}