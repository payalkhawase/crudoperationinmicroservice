package com.eureka.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;

@RestController
public class ConsController {

	@Autowired
	RestTemplate rt;
	
	@PostMapping("/setData")
	public List<Student> setAllData(@RequestBody List<Student> ls) {
		
		String url="http://localhost:8081/setAllData";
		List<Student> list=rt.postForObject(url, ls, List.class);
		
		return list;
	}

	@GetMapping("/getData")
	public List<Student> getAllData() {
		
		String url="http://localhost:8082/getAllData";
		List<Student> list=rt.getForObject(url, List.class);
		
		return list;
	}

	@PutMapping("/editAll")
	public Student updateData(@RequestBody Student s) {
		
	    String url="http://localhost:8083/edit";
	    rt.put(url, s);
		
		return s;
	}
	
	@DeleteMapping("/deleteAll")
	public void deleteAllData(){
		
		String url="http://localhost:8084/delete";
	     rt.delete(url);
		
		
	}
}
