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

import com.store.flower.entity.Flower;


@Repository
public class FlowerDAO {
	@Autowired
    private DataSource dataSource;
	
	public List<Flower> getAllFlower() {
        List<Flower> listFlower = new ArrayList<>();
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id;");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
            	int id = resultSet.getInt("id");
            	String name = resultSet.getString("name");
            	int price = resultSet.getInt("price");
            	String link_image = resultSet.getString("link_image");
            	String description = resultSet.getString("description");
            	int flowerstyle_id = resultSet.getInt("flowerstyle_id");
            	String flowerstyle_name = resultSet.getString("flowerstyle_name");
               
            	listFlower.add(new Flower(id, name, price, link_image, description, flowerstyle_id, flowerstyle_name) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listFlower;
    }
	
	
	
	public List<Flower> getKindOfFlower(String sttm) {
		List<Flower> listFlower= new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sttm)) {
	           ResultSet resultSet = stmt.executeQuery();
	           while (resultSet.next()) {
	        	   	int id = resultSet.getInt("id");
	            	String name = resultSet.getString("name");
	            	int price = resultSet.getInt("price");
	            	String link_image = resultSet.getString("link_image");
	            	String description = resultSet.getString("description");
	            	int flowerstyle_id = resultSet.getInt("flowerstyle_id");
	            	String flowerstyle_name = resultSet.getString("flowerstyle_name");
	               
	            	listFlower.add(new Flower(id, name, price, link_image, description, flowerstyle_id, flowerstyle_name) );
	           }
	       } catch (SQLException ex) {
	           // handle exception
	       }
        return listFlower;
	}
	
	public List<Flower> getSearchFlower(String sttm) {
		List<Flower> listFlower = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sttm)) {
	           ResultSet resultSet = stmt.executeQuery();
	           while (resultSet.next()) {
	        	   	int id = resultSet.getInt("id");
	            	String name = resultSet.getString("name");
	            	int price = resultSet.getInt("price");
	            	String link_image = resultSet.getString("link_image");
	            	String description = resultSet.getString("description");
	            	int flowerstyle_id = resultSet.getInt("flowerstyle_id");
	            	String flowerstyle_name = resultSet.getString("flowerstyle_name");
	               
	            	listFlower.add(new Flower(id, name, price, link_image, description, flowerstyle_id, flowerstyle_name) );
	           }
	       } catch (SQLException ex) {
	           // handle exception
	       }
        return listFlower;
	}
	
	public Flower getFlower(String id) {
		Flower flowerItem = null;
        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT flw.*, fst.name as flowerstyle_name FROM flower flw inner join flowerstyle fst on flw.flowerstyle_id = fst.id where flw.id = ?")) {
        	stmt.setString(1, id);
        	ResultSet resultSet = stmt.executeQuery();
	           while (resultSet.next()) {
	        	   	int newid = resultSet.getInt("id");
	            	String name = resultSet.getString("name");
	            	int price = resultSet.getInt("price");
	            	String link_image = resultSet.getString("link_image");
	            	String description = resultSet.getString("description");
	            	int flowerstyle_id = resultSet.getInt("flowerstyle_id");
	            	String flowerstyle_name = resultSet.getString("flowerstyle_name");
	               
	            	return new Flower(newid, name, price, link_image, description, flowerstyle_id, flowerstyle_name);
	           }
	       } catch (SQLException ex) {
	           // handle exception
	       }
        return flowerItem;
	}
	
	public void saveFlower(String name, int price, String link_image, String description, int flowerstyle_id) {
        String sql = "insert into flower(name, price, link_image, description, flowerstyle_id) \r\n"
        		+ "values (?, ?, ?, ?, ?);";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setString(3, link_image);
            ps.setString(4, description);
            ps.setInt(5, flowerstyle_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void deleteFlower(String id) {
		String sql = "delete from flower where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void updateFlower(String name, int price, String link_image, String description, int flowerstyle_id, String id) {
		String sql = "update flower set name = ?, price = ?, link_image = ?, description = ?, flowerstyle_id = ? where id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
        	 ps.setString(1, name);
             ps.setInt(2, price);
             ps.setString(3, link_image);
             ps.setString(4, description);
             ps.setInt(5, flowerstyle_id);
             ps.setString(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
