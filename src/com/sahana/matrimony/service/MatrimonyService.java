package com.sahana.matrimony.service;

import com.sahana.matrimony.dto.BrideDTO;

public interface MatrimonyService {

	public BrideDTO ValidateGetBride(int id);

	public int validateAndCreateBride(BrideDTO bride);

	

	public int updateBride(int id, String phone_number);
	
	public int DeleteBride(int id);

}
