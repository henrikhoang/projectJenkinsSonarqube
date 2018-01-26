package com.hoang.service;

import java.util.List;

import com.hoang.entity.Student;
public interface IStudentService {
	List<Student> getAllStudents();
	Student getStudentById(int studentId);
	boolean addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int studentId);	
}
