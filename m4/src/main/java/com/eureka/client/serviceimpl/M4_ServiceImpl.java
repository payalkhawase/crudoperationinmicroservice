package com.eureka.client.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;
import com.eureka.client.repository.M4_Repository;
import com.eureka.client.servicei.M4_ServiceI;

@Service
public class M4_ServiceImpl implements M4_ServiceI{

	@Autowired
	RestTemplate rt;
	
	@Autowired
	M4_Repository mr;
	
	@Override
	public void deleteSingleData(int rollno) {
		
		mr.deleteById(rollno);
		
	}

	@Override
	public void deleteAllData() {
		
		String url1="http://localhost:8081/delete";
	     rt.delete(url1);
	     
	     String url2="http://localhost:8082/delete";
	     rt.delete(url2);
	     
	     String url3="http://localhost:8083/delete";
	     rt.delete(url3);
	     
		mr.deleteAll();
		
	}

	@Override
	public Student setSingleData(Student s) {
		
		return mr.save(s);
	}

	@Override
	public List<Student> setAllData(List<Student> ls) {
		
		return mr.saveAll(ls);
	}

	@Override
	public List<Student> getAllData() {
		
		return mr.findAll();
	}

	@Override
	public Student updateData(Student s) {
		
		return mr.save(s);
	}

	@Override
	public Student getSingleData(int rollno) {
		Optional<Student> op=mr.findById(rollno);
		if(op.isPresent()) {
			
			Student stu=op.get();
			return stu;
		}
		return null;
	}

}
