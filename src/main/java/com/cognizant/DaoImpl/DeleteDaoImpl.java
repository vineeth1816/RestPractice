package com.cognizant.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.Dao.DeleteDetailsDao;
@Component
public class DeleteDaoImpl implements DeleteDetailsDao {

	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Boolean delete(int id) {
		int i=jdbcTemplate.update("DELETE FROM details WHERE id=?", id);
		if(i>0)
			return true;
		return false;
	}

}
