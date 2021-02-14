package com.sahana.matrimony.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatrimonyDAOImpl implements MatrimonyDAO{
	Statement stmt;
	public MatrimonyDAOImpl() {
		
	}
	
	public void createDataBaseConnection() throws SQLException {
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=password");
		Statement statement =connection.createStatement();
		stmt=statement;
	}

	@Override
	public ResultSet getAll(String sqlQuery)throws SQLException {
		if(null==sqlQuery) {
			return stmt.getResultSet();
		}
		return stmt.executeQuery(sqlQuery);
	}

}
