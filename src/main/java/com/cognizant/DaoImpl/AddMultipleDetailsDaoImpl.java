package com.cognizant.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.Dao.AddMultipleDetailsDao;
import com.cognizant.Model.Person;

@Component
public class AddMultipleDetailsDaoImpl implements AddMultipleDetailsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Boolean insertRecords(List<Person> persons) {
		for (Person p : persons) {
			int i = jdbcTemplate.update("INSERT INTO details VALUES(?,?)", p.getId(), p.getName());
			if (i < 0)
				return false;
		}
		return true;
	}

}
