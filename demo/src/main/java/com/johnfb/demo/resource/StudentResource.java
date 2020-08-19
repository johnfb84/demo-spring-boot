package com.johnfb.demo.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.johnfb.demo.model.Student;
import com.johnfb.demo.service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {
	
	private final StudentService studentService;
	
	@Autowired
	public StudentResource(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{studentId}"
			)
	public Student getStudentById(@PathVariable("studentId") UUID studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public void insertNewStudent(@RequestBody Student student) {
		studentService.persistNewStudent(UUID.randomUUID(), student);
	}
	
	@RequestMapping(
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			path = "{studentId}"
			)
	public void updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student studentUpdate) {
		studentService.updateStudentById(studentId, studentUpdate);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			path = "{studentId}"
			)
	public void deleteStudent(@PathVariable("studentId") UUID studentId) {
		studentService.deleteStudentById(studentId);
	}
	
}
