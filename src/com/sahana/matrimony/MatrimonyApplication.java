package com.sahana.matrimony;

import java.sql.SQLException;
import java.util.List;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dao.MatrimonyDAOImpl;
import com.sahana.matrimony.dto.Bride;
import com.sahana.matrimony.service.MatrimonyService;
import com.sahana.matrimony.service.MatrimonyServiceImpl;

public class MatrimonyApplication {
	public static void main(String[] args) {
		
		
		try {
			MatrimonyDAO dao=new MatrimonyDAOImpl();
			dao.createDataBaseConnection();
			System.out.println("DataBase connection created successfully");
			MatrimonyService matrimonyService=new MatrimonyServiceImpl(dao);
			List<Bride> listOfBride=matrimonyService.getAllBride();
			for (Bride bride : listOfBride) {
				System.out.println(bride.getId()
						           +" "+bride.getName()
						           +" "+bride.getAge()
						           +" "+bride.getHeight()
						           +" "+bride.getWeight()
						           +" "+bride.getQualification()
						           +" "+bride.getExpectation()
						           +" "+bride.getPhoneNumber()
						           +" "+bride.getSalary()
						           +" "+bride.getAddress()
						           +" "+bride.getOccupation());
			}
			} catch (SQLException e) {
				e.printStackTrace();
			System.out.println("failed to connect DataBase");
		}
		
	}
	

}
