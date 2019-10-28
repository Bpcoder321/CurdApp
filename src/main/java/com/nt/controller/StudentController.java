package com.nt.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.command.Student;
import com.nt.constant.AppConstant;
import com.nt.entity.StudentEntity;
import com.nt.repository.StudentRepository;
import com.nt.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@Autowired
	private StudentRepository repository;

	@RequestMapping("home")
	public String launchHomePage(@ModelAttribute("stud") Student student) {
		return AppConstant.VIEW_HOME;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("stud") Student student, Map<String, Object> map) {
		System.out.println(student);
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		String result = service.addStudent(entity);
		map.put("result", result);
		List<Student> allStudent = service.getAllStudent();
		map.put("allStudent", allStudent);
		return AppConstant.VIEW_REPORT;
	}

	@RequestMapping(value = "allstudent", method = RequestMethod.GET)
	public String fetchAllStudnet(Map<String, Object> map) {
		List<Student> allStudent = service.getAllStudent();
		map.put("allStudent", allStudent);
		return AppConstant.VIEW_REPORT;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteStudentById(@RequestParam("id") Integer id, Map<String, Object> map) {
		System.out.println("incoming id in app : " + id);
		service.deleteStudentById(id);
		List<Student> allStudent = service.getAllStudent();
		map.put("allStudent", allStudent);
		return AppConstant.VIEW_REPORT;
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String fetchStudentById(@RequestParam("id") Integer id, Map<String, Object> map,
			@ModelAttribute("stud") Student student) {
		
		student = service.getStudentById(id);
		map.put("stud", student);
		return AppConstant.VIEW_EDIT;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateStudent(@RequestParam("id") Integer id, Map<String, Object> map,
			@ModelAttribute("stud") Student student) {
		System.out.println("id in update " + id);
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(student, entity);
		System.out.println("entity in update " + entity);
		String result = service.updateStudent(entity);
		List<Student> allStudent = service.getAllStudent();
		map.put("allStudent", allStudent);
		map.put("result", result);
		return AppConstant.VIEW_REPORT;
	}

	@RequestMapping(value = "allstudent1", method = RequestMethod.GET)
	public String fetchAllStudnet1(Map<String, Object> map, @RequestParam("pn") Integer currPage) {
		int pageSize = 3;
		List<Student> listStudent = new ArrayList<Student>();
		PageRequest page = PageRequest.of(currPage-1, pageSize);
		Page<StudentEntity> pages = repository.findAll(page);
		int tp = pages.getTotalPages();
		pages.forEach(entiry->{
			Student stud = new Student();
			BeanUtils.copyProperties(entiry, stud);
			listStudent.add(stud);
		});
		System.out.println(tp+" "+currPage);
		map.put("allStudent", listStudent);
		map.put("tp", tp);
		map.put("cp", currPage);
		return AppConstant.VIEW_REPORT;
	}
	@RequestMapping(value="allmails", method=RequestMethod.GET)
	public @ResponseBody List<String> retriveAllEmails(){
		return service.fetchAllQualification();
	}
	
	@RequestMapping(value="mailbyid", method=RequestMethod.GET)
	public @ResponseBody String retriveQualificationById(@RequestParam("id")Integer id) {
		return service.fetchQualificationById(id);
	}
	
}
