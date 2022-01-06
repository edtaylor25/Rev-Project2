package com.demo.ersSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ersSpring.entity.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Integer> {
	
		Optional<FileDB> findById(int id);

}