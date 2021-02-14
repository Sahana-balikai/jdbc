package com.sahana.matrimony.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MatrimonyDAO {
	public void createDataBaseConnection() throws SQLException;
	
	public ResultSet getAll(String sqlQuery)throws SQLException;

}
