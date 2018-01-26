package com.hoang.dao;


import java.util.List;

import com.hoang.entity.Student;

public interface IStudentDAO {
	List <Student> getAllStudents();
	Student getStudentById(int studentId);
	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int studentId);
	boolean studentExists(String firstName, String lastName, String address);
}
