package com.sahana.matrimony.service;

import com.sahana.matrimony.dao.MatrimonyDAO;
import com.sahana.matrimony.dto.BrideDTO;

public class MatrimonyServiceImpl implements MatrimonyService {

	MatrimonyDAO matrimonyDAO;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;
	}

	@Override
	public BrideDTO ValidateGetBride(int id) {
		if (0 == id) {
			System.out.println("invalid id");
			return null;
		}
		return matrimonyDAO.getById(1);

	}

	@Override
	public int validateAndCreateBride(BrideDTO bride) {
		if (null == bride) {
			System.out.println("Bride cannot be null");
			return 0;
		} else if (bride.getId() == 0) {
			System.out.println("Invalid Id");
			return 0;
		}

		else {
			return matrimonyDAO.create(bride);
		}
	}

	@Override
	public int updateBride(int id, String phone_number) {
		if(id==0||phone_number.length()!=10) {
			System.out.println("id and phone number are not valid");
			return 0;
		}
		else {
			return matrimonyDAO.update(id, phone_number);
		}
	}

	@Override
	public int DeleteBride(int id) {
		if(id==0) {
			System.out.println("id is null");
		}else {
			return matrimonyDAO.DeleteBride(id);
		}
		return id;
	}

	

}
