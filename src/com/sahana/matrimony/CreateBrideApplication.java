package com.sahana.matrimony;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dao.MatrimonyDAOImpl;
import com.sahana.matrimony.dto.BrideDTO;
import com.sahana.matrimony.service.MatrimonyService;
import com.sahana.matrimony.service.MatrimonyServiceImpl;

public class CreateBrideApplication {
	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);
		BrideDTO bride = new BrideDTO();
		bride.setId(3);
		bride.setName("sapna");
		bride.setAge(24);
		bride.setHeight(5.6);
		bride.setWeight(50);
		bride.setQualification("B.E");
		bride.setExpectation("good");
		bride.setPhoneNumber("767643467");
		bride.setSalary(5000000);
		bride.setAddress("mysore");
		bride.setOccupation("dentist");

		int result = matrimonyService.validateAndCreateBride(bride);
		if (result == 1) {
			System.out.println("bride created successfully");
		} else {
			System.out.println("failed to create bride");
		}

	}

}
