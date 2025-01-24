package com.eureka.client.servicei;

import java.util.List;

import com.eureka.client.model.Student;

public interface M3_ServiceI {

	public Student updateData(Student s);

	public Student setSingleData(Student s);

	public List<Student> setAllData(List<Student> ls);

	public Student getSingleData(int rollno);

	public List<Student> getAllData();

	public void deleteSingleData(int rollno);

	public void deleteAllData();

}
