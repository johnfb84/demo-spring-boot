package com.johnfb.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.johnfb.demo.dao.StudentDao;
import com.johnfb.demo.model.Student;

@Service
public class StudentService {
	
	private final StudentDao studentDao;

	@Autowired
	public StudentService(@Qualifier("mongoDb") StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public int persistNewStudent(UUID studentId, Student student) {
		UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
		student.setId(studentId);
		return studentDao.insertNewStudent(studentUid, student);
	}
	
	public Student getStudentById(UUID studentId) {
		return studentDao.selectStudentById(studentId);
	}
	
	public List<Student> getAllStudents() {
		return studentDao.selectAllStudents();
	}
	
	public int updateStudentById(UUID studentId, Student studentUpdate) {
		studentUpdate.setId(studentId);
		return studentDao.updateStudentById(studentId, studentUpdate);
	}
	
	public int deleteStudentById(UUID studentId) {
		return studentDao.deleteStudentById(studentId);
	}

}
