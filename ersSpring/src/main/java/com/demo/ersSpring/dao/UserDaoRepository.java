package com.demo.ersSpring.dao;


import com.demo.ersSpring.HibernateUtil;
import com.demo.ersSpring.entity.Request;
import com.demo.ersSpring.entity.User;

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

@Repository
public interface UserDaoRepository extends JpaRepository<User,Integer> {

	public default User getUserByEmail(String email, String password) {
		User uPJ = null;
		try {	
			Class.forName("org.postgresql.Driver");
				Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
				Statement stmt = conn.createStatement();
			    String query = "select * from user_info where email='" + email+"' and password='" +password+"';";
			    ResultSet rs = stmt.executeQuery(query);
			    while (rs.next()) {
			    	uPJ = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
			    			rs.getString(7), rs.getString(8));
			    }
			} catch (ClassNotFoundException e) {
				return null;
			} catch (SQLException e) {
				return null;
			}
		return uPJ;
	}

	public default List<User> getAllManagers() {
			List<User> uPJ = new LinkedList<User>();
			try {	
				Class.forName("org.postgresql.Driver");
					Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projectone", "postgres", "MMArookie1");
					Statement stmt = conn.createStatement();
				    String query = "select * from user_info where permission_level='manager';";
				    ResultSet rs = stmt.executeQuery(query);
				    while (rs.next()) {
				    	uPJ.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
				    			rs.getString(7), rs.getString(8)));
				    }
				} catch (ClassNotFoundException e) {
					return null;
				} catch (SQLException e) {
					return null;
				}
			return uPJ;
	}
	
}
