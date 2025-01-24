package com.eureka.client.service;

import java.util.List;

import com.eureka.client.model.Student;

public interface M1_ServiceI {

	public Student setSingleData(Student s);

	public List<Student> setAllData(List<Student> ls);

	public Student getSingleData(int rollno);

	public List<Student> getAllData();

	public Student updateData(Student s);

	public void deleteSingleData(int rollno);

	public void deleteAllData();

}
