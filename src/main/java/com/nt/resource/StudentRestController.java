package com.nt.resource;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.command.Student;
import com.nt.entity.StudentEntity;
import com.nt.repository.StudentRepository;

@RestController
public class StudentRestController {
	@Autowired
	private StudentRepository repository;

	@GetMapping(value="getStudentById", produces="application/json")
	public @ResponseBody Student getStudentById(@RequestParam("id")Integer id) {
		Student student = new Student();
		Optional<StudentEntity> entities = repository.findById(id);
		StudentEntity entity = entities.get();
		BeanUtils.copyProperties(entity, student);
		return student;
	}
}
