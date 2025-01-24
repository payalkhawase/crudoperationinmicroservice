package com.eureka.client.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;
import com.eureka.client.repository.M1_Repository;
import com.eureka.client.service.M1_ServiceI;

@Service
public class M1_ServiceImpl implements M1_ServiceI{

	@Autowired
	RestTemplate rt;
	
	@Autowired
	M1_Repository mr;
	
	@Override
	public Student setSingleData(Student s) {
		
		return mr.save(s);
	}

	@Override
	public List<Student> setAllData(List<Student> ls) {
		
		List<Student> list=mr.saveAll(ls);
		
		String url2="http://localhost:8082/setAllData";
		rt.postForObject(url2, ls,List.class);
		
		String url3="http://localhost:8083/setAllData";
		rt.postForObject(url3, ls, List.class);
				
		String url4="http://localhost:8084/setAllData";
	    rt.postForObject(url4, ls, List.class);
		
		return null;
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
	public Student updateData(Student s) {
		
		return mr.save(s);
	
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
