package com.nt.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.command.Student;
import com.nt.entity.StudentEntity;
import com.nt.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public String addStudent(StudentEntity student) {
		StudentEntity save = repository.save(student);
		if(save!=null) {
			return "Stduent saved successfully.";
		} else
			return "Student not saved.";
	}
	
	public List<Student> getAllStudent(){
		List<Student> listStudent = new ArrayList<Student>();
		Iterable<StudentEntity> allStudent = repository.findAll();
		allStudent.forEach(student->{
			Student stud = new Student();
			BeanUtils.copyProperties(student, stud);
			listStudent.add(stud);
		});
		return listStudent;
	}
	
	public void deleteStudentById(Integer id) {
		repository.deleteById(id);
	}
	
	public Student getStudentById(Integer id) {
		
		Student student = new Student();
		
		Optional<StudentEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			StudentEntity studentEntity = entity.get();
			BeanUtils.copyProperties(studentEntity, student);
		}
		return student;
	}
	
	public String updateStudent(StudentEntity entity) {
		StudentEntity save = repository.save(entity);
		if(save!=null) {
			return "Updated successfully.";
		}
		return "Failed to update";
	}
	
	
	public Map<String, Object> getAllStudent1(int currPage){
		int pagesize = 3;
		Map<String, Object> mapStudent = new HashMap<>();
		List<Student> listStudent = new ArrayList<>();
		PageRequest page = PageRequest.of(currPage-1, pagesize);
		
		Page<StudentEntity> pages = repository.findAll(page);
		List<StudentEntity> content = pages.getContent();
		int totalPages = pages.getTotalPages();
		System.out.println(totalPages);
		content.forEach(student->{
			Student stud = new Student();
			BeanUtils.copyProperties(student, stud);
			listStudent.add(stud);
		});
		mapStudent.put("list", listStudent);
		mapStudent.put("tp", totalPages);
		mapStudent.put("cp", currPage);
		return mapStudent;
	}
	public List<String> fetchAllQualification(){
		return repository.getAllQualifications();	  
	}
	
	public String fetchQualificationById(Integer id){
		System.out.println("id in service"+id+" mail "+repository.getQualificationById(id));
		return repository.getQualificationById(id);
	}
	
	
	
}
