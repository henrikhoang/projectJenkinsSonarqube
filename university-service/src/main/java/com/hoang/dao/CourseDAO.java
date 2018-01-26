package com.hoang.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoang.entity.Course;
import com.hoang.entity.CourseStudentGrade;

@Transactional
@Repository
public class CourseDAO implements ICourseDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		String hql = "FROM Course as crs ORDER by crs.courseAuth";
		return (List<Course>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public List<CourseStudentGrade> getStudentGrade(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourseByIntructor(int instructorId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
