package com.sahana.matrimony.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dto.Bride;
import static com.sahana.matrimony.constant.Constants.*;

public class MatrimonyServiceImpl implements MatrimonyService {
	MatrimonyDAO matrimonyDAO = null;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;
	}

	@Override
	public List<Bride> getAllBride() {
		List<Bride> listOfBride = new ArrayList<Bride>();
		try {
			ResultSet resultset = matrimonyDAO.getAll(GET_ALL_BRIDE);
			while (resultset != null && resultset.next()) {
				Bride bride = new Bride();
				bride.setId(resultset.getInt(1));
				bride.setName(resultset.getString(2));
				bride.setAge(resultset.getInt(3));
				bride.setHeight(resultset.getDouble(4));
				bride.setWeight(resultset.getDouble(5));
				bride.setQualification(resultset.getString(6));
				bride.setExpectation(resultset.getString(7));
				bride.setPhoneNumber(resultset.getString(8));
				bride.setSalary(resultset.getDouble(9));
				bride.setOccupation(resultset.getString(10));
				bride.setAddress(resultset.getString(11));
				listOfBride.add(bride);

			}
		} catch (SQLException e) {
			System.out.println("failed to get all bride");

		}
		return listOfBride;

	}
	@Override
	public void createBride() {
		Bride bride=new Bride();
		bride.setId(3);
		bride.setName("chinni");
		bride.setAge(26);
		bride.setHeight(5.7);
		bride.setWeight(58);
		bride.setQualification("B.E");
		bride.setExpectation("nothing");
		bride.setPhoneNumber("38771625");
		bride.setSalary(50000.0);
		bride.setAddress("bangalore");
		bride.setOccupation("doctor");
		
		
	}
	
	
	

}
