package com.sahana.matrimony;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dao.MatrimonyDAOImpl;
import com.sahana.matrimony.service.MatrimonyService;
import com.sahana.matrimony.service.MatrimonyServiceImpl;

public class DeleteBrideApplication {
	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);
		int result=matrimonyService.DeleteBride(3);
		System.out.println(result);
	}

}
