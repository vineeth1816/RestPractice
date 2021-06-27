package com.cognizant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DaoImpl.DeleteDaoImpl;
@Service
public class DeleteService {

	@Autowired
	DeleteDaoImpl deleteDetailsDaoImpl;
	
	public Boolean deleteDetails(int id) {
		
		return deleteDetailsDaoImpl.delete(id);
	}
}
