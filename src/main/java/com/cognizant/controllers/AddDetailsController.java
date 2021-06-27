package com.cognizant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Person;
import com.cognizant.Service.AddDetailsService;
import com.cognizant.Service.DeleteService;
import com.cognizant.Service.GetDetailsService;
import com.cognizant.Service.InsertMultipleDetailsService;
import com.cognizant.Service.UpdateDetailsService;

@RestController
public class AddDetailsController {

	@Autowired
	AddDetailsService addDetailsService;

	@Autowired
	GetDetailsService getDetailsService;

	@Autowired
	DeleteService deleteDetails;

	@Autowired
	UpdateDetailsService updateDetailsService;
	
	@Autowired
	InsertMultipleDetailsService insertMultipleDetailsService;

	@PostMapping("adddetails")
	public Person addDetails(@RequestBody Person p) {
		return addDetailsService.add(p);
	}

	@GetMapping("getDetails/{id}")
	public Person getDetails(@PathVariable int id) {
		return getDetailsService.getDetails(id);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteDetails(@PathVariable int id) {
		if (deleteDetails.deleteDetails(id))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("update")
	public ResponseEntity<String> updateDetails(@RequestBody Person p) {
		if (updateDetailsService.updateDetails(p))
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Error!!Updation failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("addmultipledetails")
	public ResponseEntity<Object> insertMultipleDetails(@RequestBody List<Person> p)
	{
		if(insertMultipleDetailsService.insertMultipleDetails(p))
			return new ResponseEntity<Object>(p, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error!!Insertion failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
