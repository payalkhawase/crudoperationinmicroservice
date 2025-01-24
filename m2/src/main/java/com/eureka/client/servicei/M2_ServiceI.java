package com.eureka.client.servicei;

import java.util.List;

import com.eureka.client.model.Student;

public interface M2_ServiceI {

	public Student getSingleData(int rollno);

	public List<Student> getAllData();

	public Student setSingleData(Student s);

	public List<Student> setAllData(List<Student> ls);

	public Student updateData(Student s);

	public void deleteSingleData(int rollno);

	public void deleteAllData();

}
