package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Student;
import com.services.impl.StudentServiceImpl;

@Controller
public class StudentsController {
	
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	public StudentsController(StudentServiceImpl studentServiceImpl) {
		this.studentServiceImpl = studentServiceImpl;
	}

	@GetMapping("/Students")
	public String homepage(Model model) {
		model.addAttribute("pageTitle", "List of Students");
		model.addAttribute("students", students());
		return "Students/index";
	}
	
	
	@GetMapping("/Students/Create")
	public String newStudent(Model model) {
		model.addAttribute("StudentDetails", new Student());
		model.addAttribute("pageTitle", "Add a new Student");
		return "Students/Create";
	}
	
	
	@PostMapping("/Students/Create")
	public String addStudent(@ModelAttribute Student StudentDetails, Model model) {

		try {
			if(studentServiceImpl.getByEmail(StudentDetails.getEmail()).isPresent()) {
				throw new Exception();
			}else {
				studentServiceImpl.add(StudentDetails);
				return "redirect:/Students";
			}
	
		} catch (Exception e) {
			model.addAttribute("StudentDetails", StudentDetails);
			model.addAttribute("pageTitle", "Add a new Student");
			model.addAttribute("error", "true");
			return "Students/Create";
		}
		
	}
	
	
	@GetMapping("/Students/Details/{id}")
	public String viewStudentDetails(@PathVariable int id, Model model) {
		model.addAttribute("pageTitle", "View Student");
		model.addAttribute("StudentDetails", getById(id));
		return "Students/Details";
	}
	
	// Get Delete student
	@GetMapping("/Students/Delete/{id}")
	public String deleteStudent(@PathVariable int id, Model model) {
		model.addAttribute("pageTitle", "Delete Student");
		model.addAttribute("StudentDetails", getById(id));
		return "Students/Delete";
	}
	
	
	@RequestMapping("/Students/Delete/{id}")
	private String deleteStudent(@PathVariable String id){
		studentServiceImpl.delete(Integer.parseInt(id));
	    return "redirect:/Students";
	}
	
	// Get Edit Student
	@GetMapping("/Students/Edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		model.addAttribute("pageTitle", "View Student");
		model.addAttribute("StudentDetails", getById(id));
		return "Students/Edit";
	}
	
	
	@RequestMapping("/Students/Edit/{id}")
	private String updateStudent(@PathVariable String id, Student StudentDetails, Model model){
	    
		try {
			studentServiceImpl.update(StudentDetails);
			return "redirect:/Students";	
	
		} catch (Exception e) {
			model.addAttribute("StudentDetails", StudentDetails);
			model.addAttribute("pageTitle", "Add a new Student");
			model.addAttribute("error", "true");
			return "Students/Edit";
		}
	}
	
	
	
	public List<Student> students() {
		return studentServiceImpl.getAll();
	}
	
	public Student getById(int id) {
		return studentServiceImpl.getById(id).get();
	}
	
}
