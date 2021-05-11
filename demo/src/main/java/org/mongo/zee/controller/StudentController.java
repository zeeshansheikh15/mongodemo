package org.mongo.zee.controller;

import java.util.List;

import org.mongo.zee.model.Student;
import org.mongo.zee.repository.StudentRepo;
import org.mongo.zee.repository.StudentRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	
	private StudentRepository studentRepository;
	
	private StudentRepo studentRepo;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@GetMapping("/")
	public List <Student> getStudents() {
		List<Student> li = studentRepository.findAll();
		for(Student stu: li) {
			System.out.print(stu.getName());
		}
		return studentRepository.findAll();		
	}
	
	@PostMapping("/")
	public void addStudents(@RequestBody Student student) {
		studentRepository.save(student);
	
	}

	@PutMapping("/{city}")
	public void addStudents(@RequestBody Student student, @PathVariable String city) {
		student.setCity(city);
		studentRepository.save(student);
	
	}	
	@DeleteMapping("/{id}")
	public void deleteStudents(@RequestBody Student student, @PathVariable String id) {
		studentRepository.deleteById(id);
	
	}	
	
	@DeleteMapping("/")
	public void deleteAll() {
		studentRepository.deleteAll();
	
	}
	
	
}
