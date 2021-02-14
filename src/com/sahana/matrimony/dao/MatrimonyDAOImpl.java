package com.sahana.matrimony.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sahana.matrimony.dto.BrideDTO;

import static com.sahana.matrimony.constant.Constants.*;

public class MatrimonyDAOImpl implements MatrimonyDAO {

	@Override
	public BrideDTO getById(int id) {
		BrideDTO bride = new BrideDTO();

		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM matrimonydata.bride where id=" + id);

			resultSet.next();
			bride.setId(resultSet.getInt(1));
			bride.setName(resultSet.getString(2));
			bride.setAge(resultSet.getInt(3));
			bride.setHeight(resultSet.getDouble(4));
			bride.setWeight(resultSet.getDouble(5));
			bride.setQualification(resultSet.getString(6));
			bride.setExpectation(resultSet.getString(7));
			bride.setPhoneNumber(resultSet.getString(8));
			bride.setSalary(resultSet.getDouble(9));
			bride.setOccupation(resultSet.getString(10));
			bride.setAddress(resultSet.getString(11));
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return bride;

	}

	@Override
	public int create(BrideDTO bride) {
		int result = 0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt = con.prepareStatement("insert into matrimonydata.bride values(?,?,?,?,?,?,?,?,?,?,?)");
					
			stmt.setInt(1, bride.getId());
			stmt.setString(2, bride.getName());
			stmt.setInt(3, bride.getAge());
			stmt.setDouble(4, bride.getHeight());
			stmt.setDouble(5, bride.getWeight());
			stmt.setString(6, bride.getQualification());
			stmt.setString(7, bride.getExpectation());
			stmt.setString(8, bride.getPhoneNumber());
			stmt.setDouble(9, bride.getSalary());
			stmt.setString(10, bride.getAddress());
			stmt.setString(11, bride.getOccupation());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("failed to connect to DB");
		}
		return result;
	}

	@Override
	public int update(int id, String phone_number) {
		int result=0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt=con.prepareStatement("update matrimonydata.bride set phone_number=? where id=?");
			stmt.setString(1, phone_number);
			stmt.setInt(2, id);
			result=stmt.executeUpdate();
			System.out.println("update successfull");
		} catch (SQLException e) {
			System.out.println("failed to update");
		}
		return result;
	}

	@Override
	public int DeleteBride(int id) {
		int result=0;
		try (Connection con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD)) {
			PreparedStatement stmt=con.prepareStatement("delete from matrimonydata.bride where id=?");
			stmt.setInt(1, id);
			result=stmt.executeUpdate();
			System.out.println("deleted successfully");
		} catch (SQLException e) {
			System.out.println("failed to delete");
		}
		return result;
		
	}

	
}