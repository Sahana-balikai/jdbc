package com.sahana.matrimony;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dao.MatrimonyDAOImpl;
import com.sahana.matrimony.dto.BrideDTO;
import com.sahana.matrimony.service.MatrimonyService;
import com.sahana.matrimony.service.MatrimonyServiceImpl;

public class GetBrideAppl {
	public static void main(String[] args) {
		MatrimonyDAO matrimonyDAO = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonyDAO);
		BrideDTO brideDTO=matrimonyService.ValidateGetBride(3);
		//BrideDTO brideDTO = matrimonyService.ValidateGetBride(1); // using service
		
		if (brideDTO != null) {
			System.out.println(brideDTO);

		}

	}
}
