package com.eureka.client.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eureka.client.model.Student;
import com.eureka.client.repository.M2_Repository;
import com.eureka.client.servicei.M2_ServiceI;

@Service
public class M2_ServiceImpl implements M2_ServiceI{

	@Autowired
	RestTemplate rt;
	
	@Autowired
	M2_Repository mr;
	
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
		
		String url2="http://localhost:8081/getAllData";
		rt.getForObject(url2,List.class);
		
		String url3="http://localhost:8083/getAllData";
		rt.getForObject(url3, List.class);
				
		String url4="http://localhost:8084/getAllData";
	    rt.getForObject(url4, List.class);
		
		return mr.findAll();
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
