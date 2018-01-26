package com.hoang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hoang.dao.ICourseDAO;
import com.hoang.entity.Course;
import com.hoang.entity.CourseStudentGrade;

@Service
public class CourseService implements ICourseService {

	@Autowired
	private ICourseDAO courseDAO;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = courseDAO.getAllCourses();
		return courses;
	}

	@Override
	public List<CourseStudentGrade> getStudentGrade(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourseByInstructor(int instructorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
