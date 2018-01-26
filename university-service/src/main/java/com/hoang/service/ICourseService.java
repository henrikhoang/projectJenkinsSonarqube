package com.hoang.service;

import java.util.List;

import com.hoang.entity.*;
public interface ICourseService {
	List<Course> getAllCourses();
	List<CourseStudentGrade> getStudentGrade(int courseId);
	List<Course> getCourseByInstructor(int instructorId);
}
