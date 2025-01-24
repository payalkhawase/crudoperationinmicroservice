package com.eureka.client.servicei;

import java.util.List;

import com.eureka.client.model.Student;

public interface M4_ServiceI {

 public	void deleteSingleData(int rollno);

public void deleteAllData();

public Student setSingleData(Student s);

public List<Student> setAllData(List<Student> ls);

public List<Student> getAllData();

public Student updateData(Student s);

public Student getSingleData(int rollno);

}
