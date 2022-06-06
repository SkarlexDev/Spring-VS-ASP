package com.services;

import java.util.List;
import java.util.Optional;

import com.entity.Student;

public interface StudentService {

	List<Student> getAll();
	Optional<Student> getById(int id);
	Optional<Student> getByEmail(String email);
    void add(Student student);
    Student update(Student newStudent);
    void delete(int id);
}
