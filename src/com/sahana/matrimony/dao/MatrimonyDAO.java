package com.sahana.matrimony.dao;

import com.sahana.matrimony.dto.BrideDTO;

public interface MatrimonyDAO {
	public BrideDTO getById(int id);

	public int create(BrideDTO bride);

	public int update(int id,String phone_number);
	
	public int DeleteBride(int id);
}
