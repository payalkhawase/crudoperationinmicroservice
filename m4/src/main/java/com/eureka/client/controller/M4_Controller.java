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

import com.eureka.client.model.Student;
import com.eureka.client.servicei.M4_ServiceI;

@RestController
public class M4_Controller {

	@Autowired
	M4_ServiceI msi;
	
	@DeleteMapping("/deleteSingle/{rollno}")
	public void deleteSingleData(@PathVariable("rollno") int rollno){
		
		msi.deleteSingleData(rollno);
		
		
	}
	
	@DeleteMapping("/delete")
	public void deleteAllData(){
		
		msi.deleteAllData();
		
		
	}
	
	@PostMapping("/setSingleData")
	public Student setSingleData(@RequestBody Student s) {
		
		Student stu=msi.setSingleData(s);
		
		return stu;
	}
	
	@PostMapping("/setAllData")
	public List<Student> setAllData(@RequestBody List<Student> ls) {
		
		List<Student> list=msi.setAllData(ls);
		
		return list;
	}
	
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
	
	@PutMapping("/edit")
	public Student updateData(@RequestBody Student s) {
		
		Student stu=msi.updateData(s);
		
		return stu;
	}
	
}
