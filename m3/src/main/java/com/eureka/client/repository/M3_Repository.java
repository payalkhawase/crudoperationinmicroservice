package com.eureka.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eureka.client.model.Student;

@Repository
public interface M3_Repository extends JpaRepository<Student, Integer>{

}
