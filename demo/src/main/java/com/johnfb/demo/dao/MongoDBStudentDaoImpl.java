package com.johnfb.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.johnfb.demo.model.Student;

@Repository("mongoDb")
public class MongoDBStudentDaoImpl implements StudentDao {
	
	@Override
	public int insertNewStudent(UUID studentId, Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student selectStudentById(UUID studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(UUID.randomUUID(), "John", "DB", "Fake", 34));
		return students;
	}

	@Override
	public int updateStudentById(UUID studentId, Student studentUpdate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentById(UUID studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
