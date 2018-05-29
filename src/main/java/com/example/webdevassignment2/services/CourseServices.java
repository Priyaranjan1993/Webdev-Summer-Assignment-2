package com.example.webdevassignment2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevassignment2.models.Course;
import com.example.webdevassignment2.repositories.CourseRepository;

@RestController
public class CourseServices {
	@Autowired
	CourseRepository courseRepository;

	//get all course list
	@GetMapping("/api/course")
	public Iterable<Course> findAllCourses() {
		return courseRepository.findAll();
	}
}
