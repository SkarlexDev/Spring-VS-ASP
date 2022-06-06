package com.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Student;
import com.repository.StudentRepository;
import com.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository repository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<Student> getAll() {
		List<Student> students = new ArrayList<>();
		repository.findAll().forEach(students::add);
		return students;
	}

	@Override
	public Optional<Student> getById(int id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Student> getByEmail(String email) {
		return repository.findByEmail(email);
		
	}

	@Override
	public void add(Student student) {
		repository.save(student);
	}

	@Override
	public Student update(Student newStudent) {
		return repository.save(newStudent);
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

}
