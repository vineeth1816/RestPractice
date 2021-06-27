package com.cognizant.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.Dao.UpdateDetailsDao;
import com.cognizant.Model.Person;

@Component
public class UpdateDetailsDaoImpl implements UpdateDetailsDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Boolean updateDetails(Person p) {
		int i;
		try {
		 i=jdbcTemplate.update("UPDATE details SET name=? WHERE id=?", p.getName(),p.getId());
		}
		catch(Exception e) {
			return false;
		}
		if(i>0)
			return true;
		return false;
	}

}
