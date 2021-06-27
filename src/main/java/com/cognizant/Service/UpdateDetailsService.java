package com.cognizant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DaoImpl.UpdateDetailsDaoImpl;
import com.cognizant.Model.Person;

@Service
public class UpdateDetailsService {
	
	@Autowired
	UpdateDetailsDaoImpl updateDetailsDaoImpl;
	
	public Boolean updateDetails(Person p) {
		return updateDetailsDaoImpl.updateDetails(p);
	}

}
