package com.eureka.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;
import com.eureka.client.servicei.M2_ServiceI;

@RestController
public class M2_Controller {

	@Autowired
	RestTemplate rt;
	
	@Autowired
	M2_ServiceI msi;
	
	@GetMapping("/getSingleData/{rollno}")
	public Student getSingleDta(@PathVariable("rollno") int rollno) {
		
		Student stu=msi.getSingleData(rollno);
		return stu;
		
	}
	
	@GetMapping("/getAllData")
	public List<Student> getAllDta() {
		
		List<Student> stu=msi.getAllData();
		return stu;
		
	}
	
	@PostMapping("/setSingleData")
	public Student setSingleData(@RequestBody Student s) {
		
		Student stu=msi.setSingleData(s);
		
		return stu;
	}
	
	@PostMapping("/setAllData")
	public List<Student> setAllData(@RequestBody List<Student> ls)
	{
		
		List<Student> list=msi.setAllData(ls);
		
		return list;
	}
	
	
	
	@PutMapping("/edit")
	public Student updateData(@RequestBody Student s) {
		
		Student stu=msi.updateData(s);
		
		return stu;
	}
	
	@DeleteMapping("/deleteSingle/{rollno}")
	public void deleteSingleData(@PathVariable("rollno") int rollno){
		
		msi.deleteSingleData(rollno);
		
		
	}
	
	@DeleteMapping("/delete")
	public void deleteAllData(){
		
		msi.deleteAllData();
		
		
	}
}
