package com.sahana.matrimony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sahana.matrimony.dto.BrideDTO;

public class TryWithResource {
	public static void main(String[] args) {
		String mysql="jdbc:mysql://localhost:3306";
		System.out.println("connection established");
		
		try(Connection con = DriverManager.getConnection(mysql, "root", "password");
			      Statement stmt = con.createStatement(); ) {
			         try(ResultSet resultSet = stmt.executeQuery("SELECT * FROM matrimonydata.bride where id=1");){
			        	 BrideDTO bride=new BrideDTO();
			            //Retrieving the data
			            while(resultSet.next()) {
			            	bride.setId(resultSet.getInt(1));
							bride.setName(resultSet.getString(2));
							bride.setAge(resultSet.getInt(3));
							bride.setHeight(resultSet.getDouble(4));
							bride.setWeight(resultSet.getDouble(4));
							bride.setQualification(resultSet.getString(6));
							bride.setExpectation(resultSet.getString(7));
							bride.setPhoneNumber(resultSet.getString(8));
							bride.setSalary(resultSet.getDouble(9));
							bride.setOccupation(resultSet.getString(10));
							bride.setAddress(resultSet.getString(11));
							System.out.println(bride);
			               
			            }
			         } catch (SQLException e) {
			            e.printStackTrace();
			         }
			      } catch (SQLException e) {
			            e.printStackTrace();
			      }
			   }

}
