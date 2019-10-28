package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

	@Query(value="SELECT qlfy FROM StudentEntity")
	public List<String> getAllQualifications();

	@Query(value="SELECT qlfy FROM StudentEntity WHERE id = :sid")
	public String getQualificationById(Integer sid); 
}
