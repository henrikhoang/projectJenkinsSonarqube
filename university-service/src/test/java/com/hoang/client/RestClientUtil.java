package com.hoang.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.hoang.entity.Student;
public class RestClientUtil {
	
	public void getStudentByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
	
	headers.setContentType(MediaType.APPLICATION_JSON);
	RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/student/{id}";
	HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
	ResponseEntity<Student> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student.class, 1);
	Student student = responseEntity.getBody();
	System.out.println("Id:"+ student.getStudentId()+", First name:"+student.getFirstName()+
			", Last name:"+student.getLastName()+", Address:"+student.getAddress());
	
	}
	
	public void getAllStudentsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/user/students";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
		Student[] students = responseEntity.getBody();
		for(Student student : students) {
			System.out.println("Id:"+student.getStudentId()+", First name:"+student.getFirstName()+
					", Last name:"+student.getLastName()+", Address:"+student.getAddress());
			
		}
	}
	public void addStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/student";
	Student student = new Student();
	student.setStudentId(100);
	student.setFirstName("Spring REST Security using Hibernate");
	student.setLastName("Spring");
	student.setAddress("New York, 11550");
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());    	
    }
    public void updateStudentDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/student";
	Student student = new Student();
	student.setStudentId(1);
	student.setFirstName("Update:Java Concurrency");
	student.setLastName("Java");
	student.setAddress("California");
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(student, headers);
        restTemplate.put(url, requestEntity);
    }
    public void deleteArticleDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/user/student/{id}";
        HttpEntity<Student> requestEntity = new HttpEntity<Student>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
    	util.getAllStudentsDemo();
    	
    }    
	
	
}
