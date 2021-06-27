package com.cognizant.Dao;

import java.util.List;

import com.cognizant.Model.Person;

public interface AddMultipleDetailsDao {

	public Boolean insertRecords(List<Person> persons);
}
