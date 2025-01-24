package com.eureka.client.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;
import com.eureka.client.repository.M3_Repository;
import com.eureka.client.servicei.M3_ServiceI;

@Service
public class M3_ServiceImpl implements M3_ServiceI{

	@Autowired
	RestTemplate rt;
	
	@Autowired
	M3_Repository mr;
	
	@Override
	public Student updateData(Student s) {
		
		String url2="http://localhost:8081/edit";
		rt.put(url2,s);
		
		String url3="http://localhost:8082/edit";
		rt.put(url3, s);
				
		String url4="http://localhost:8084/edit";
	    rt.put(url4, s);
	    
		return mr.save(s);
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
	public Student getSingleData(int rollno) {
		Optional<Student> op=mr.findById(rollno);
		if(op.isPresent()) {
			
			Student stu=op.get();
			return stu;
		}
		return null;
	}

	@Override
	public List<Student> getAllData() {
		
		return mr.findAll();
	}

	@Override
	public void deleteSingleData(int rollno) {
		
		mr.deleteById(rollno);
		
	}

	@Override
	public void deleteAllData() {
		
		mr.deleteAll();
		
	}

}
