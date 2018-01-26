package com.hoang.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hoang.entity.Student;
import com.hoang.dao.IStudentDAO;

@Transactional
@Repository
public class StudentDAO implements IStudentDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, studentId);
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		String hql = "FROM Student as std ORDER BY std.studentId";
		return (List<Student>) entityManager.createQuery(hql).getResultList();
		
	}


	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		entityManager.persist(student);
		
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student std = getStudentById(student.getStudentId());
		std.setFirstName(student.getFirstName());
		std.setLastName(student.getLastName());
		std.setAddress(student.getAddress());
		entityManager.flush();
		
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		entityManager.remove(getStudentById(studentId));
		
	}

	@Override
	public boolean studentExists(String firstName, String lastName, String address) {
		// TODO Auto-generated method stub
		String hql = "FROM Student as std WHERE std.firstName = ? and std.lastName = ?";
		int count = entityManager.createQuery(hql).setParameter(1,  firstName)
				.setParameter(2, lastName).setParameter(3, address)
				.getResultList().size();
		return count > 0 ? true : false;
	}

}
