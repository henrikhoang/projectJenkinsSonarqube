package com.hoang.dao;

import com.hoang.entity.*;
import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
public interface ICourseDAO {
	List<Course> getAllCourses();
	List<CourseStudentGrade> getStudentGrade(int courseId);
	
	@Nullable
	List<Course> getCourseByIntructor(int instructorId);
}
