package com.demo.ersSpring.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ersSpring.HibernateUtil;
import com.demo.ersSpring.entity.Request;

@Repository
public interface RequestDaoRepository extends JpaRepository<Request,Integer>{

	public default List<Request> getPendingRequests() {
		LinkedList<Request> rPJ = new LinkedList<Request>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where status= 'pending';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6)));
			    }
			} catch (ClassNotFoundException e) {
				return new LinkedList<Request>();
			} catch (SQLException e) {
				return new LinkedList<Request>();
			}
		return rPJ;
	}
	
	public default List<Request> getResolvedRequests() {
		LinkedList<Request> rPJ = new LinkedList<Request>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where status= 'rejected' or status='approved';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6)));
			    }
			} catch (ClassNotFoundException e) {
				return new LinkedList<Request>();
			} catch (SQLException e) {
				return new LinkedList<Request>();
			}
		return rPJ;
	}
	
	
	public default List<Request> getRequestsForUser(int userId) {
		LinkedList<Request> rPJ = new LinkedList<Request>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "Select * from request_info where user_id = " + userId+";";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6)));
			    }
			} catch (ClassNotFoundException e) {
				return new LinkedList<Request>();
			} catch (SQLException e) {
				return new LinkedList<Request>();
			}
		return rPJ;
	}
	
	public default List<Request> getUserPending(int userId) {

		LinkedList<Request> rPJ = new LinkedList<Request>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "select * from request_info where user_id=" + userId +" and status='pending';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6)));
			    }
			} catch (ClassNotFoundException e) {
				return new LinkedList<Request>();
			} catch (SQLException e) {
				return new LinkedList<Request>();
			}
		return rPJ;
	}
	
	public default List<Request> getUserResolved(int userId) {
		LinkedList<Request> rPJ = new LinkedList<Request>();
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "select * from request_info where user_id=" + userId +" and status='rejected' or user_id="+userId+" and status='approved';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	rPJ.add(new Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(6)));
			    }
			} catch (ClassNotFoundException e) {
				return new LinkedList<Request>();
			} catch (SQLException e) {
				return new LinkedList<Request>();
			}
		return rPJ;
	}
	
}
