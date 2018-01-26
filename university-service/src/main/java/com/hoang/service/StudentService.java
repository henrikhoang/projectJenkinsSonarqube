package com.hoang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoang.dao.IStudentDAO;
import com.hoang.entity.Student;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDAO studentDAO;
	
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDAO.getAllStudents();
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		Student std = studentDAO.getStudentById(studentId);
		return std;
	}

	@Override
	public synchronized boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		if (studentDAO.studentExists(student.getFirstName(), student.getLastName(), student.getAddress())) {
		return false;
		} else {
			studentDAO.addStudent(student);
			return true;
		}
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(studentId);
	}

}
