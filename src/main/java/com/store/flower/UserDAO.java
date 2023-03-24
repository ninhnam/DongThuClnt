package com.store.flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.flower.entity.User;

@Repository
public class UserDAO {
	
	@Autowired
    private DataSource dataSource;
	
	
	public User getUserFromDatabaseByUsername(String username) {
        User userFromDB = null;
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from user where username=? limit 1")) {
	           stmt.setString(1, username);
	           ResultSet resultSet = stmt.executeQuery();
	           while (resultSet.next()) {
	        	   	int id = resultSet.getInt("id");
	            	String username1 = resultSet.getString("username");
	            	String password = resultSet.getString("password");
	            	String role = resultSet.getString("role");
	            	userFromDB = new User(id, username1, password, role);
	           }
	       } catch (SQLException ex) {
	           // handle exception
	       }
        return userFromDB;
    }
	
	public void saveUserManager(String username, String password, String role) {
        String sql = "insert into user(username, password, role) values \r\n"
        		+ "(?,?,?);";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM user");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String username = resultSet.getString("username");
            	String password = resultSet.getString("password");
            	String role = resultSet.getString("role");
               
            	users.add(new User(id, username, password, role) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
	
	public User getUser(String idUser) {
        User user = null;
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from user where id = ? limit 1" )) {
	           stmt.setString(1, idUser);
	           ResultSet resultSet = stmt.executeQuery();
	           while (resultSet.next()) {
	        	   	int id = resultSet.getInt("id");
	            	String username = resultSet.getString("username");
	            	String password = resultSet.getString("password");
	            	String role = resultSet.getString("role");
	            	user =  new User(id, username, password, role);
	           }
	       } catch (SQLException ex) {
	           // handle exception
	       }
        return user;
    }
	
	public void updateUser(String username, String password) {
		String sql = "update user set password = ? where username = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, password);
            ps.setString(2, username);
            System.out.println(sql);
            System.out.println(conn);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteUser(String id) {
		String sql = "delete from user where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
