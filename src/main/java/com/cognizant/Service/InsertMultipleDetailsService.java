package com.cognizant.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.DaoImpl.AddMultipleDetailsDaoImpl;
import com.cognizant.Model.Person;

@Service
public class InsertMultipleDetailsService {

	@Autowired
	AddMultipleDetailsDaoImpl addMultipleDetailsDaoImpl;
	
	public Boolean insertMultipleDetails(List<Person> persons) {
		return addMultipleDetailsDaoImpl.insertRecords(persons);
	}
}
