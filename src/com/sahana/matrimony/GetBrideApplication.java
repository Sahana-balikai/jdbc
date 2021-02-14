package com.sahana.matrimony;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sahana.matrimony.dto.BrideDTO;

public class GetBrideApplication {
	public static void main(String[] args) {
		Connection connection = null;
//1.----load and register the driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

//2.---Establish the connection to DB
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "password");
			System.out.println("Connected to database");

//3.--creating statement object using connection object.
			Statement stmt = connection.createStatement();

//4.Execute Query and hold it in resultSet.
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM matrimonydata.bride where id=1");
			BrideDTO bride = new BrideDTO(); // to map the resultSet to object create the bride object.
			// resultSet.next();---moves the cursor to next position.
			while (resultSet.next()) { // for iteration
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
			}

			System.out.println(bride); // print all bride details.
		} catch (SQLException e) {
			System.out.println("failed to connect to database");
		}

		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
