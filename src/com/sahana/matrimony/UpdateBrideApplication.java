package com.sahana.matrimony;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dao.MatrimonyDAOImpl;
import com.sahana.matrimony.service.MatrimonyService;
import com.sahana.matrimony.service.MatrimonyServiceImpl;

public class UpdateBrideApplication {
	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);
		
		int result=matrimonyService.updateBride(1,"7873374683");
		System.out.println(result);
	}

}
