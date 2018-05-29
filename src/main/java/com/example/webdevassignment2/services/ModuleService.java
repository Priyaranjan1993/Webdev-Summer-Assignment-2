package com.example.webdevassignment2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevassignment2.repositories.CourseRepository;
import com.example.webdevassignment2.repositories.ModuleRepository;
import com.example.webdevassignment2.models.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	ModuleRepository moduleRepository;

	@PostMapping("/api/course/{courseId}/module")
	public Module createModule() {
		return null;

	}
	@GetMapping("/api/course/{courseId}/module")
	public List<Module> findAllModulesForCourse(
			@PathVariable("courseId") int courseId) {
		Optional<Course> data = courseRepository.findById(courseId);
		if(data.isPresent()) {
			Course course = data.get();
			return course.getModules();
		}
		return null;
	}

	@DeleteMapping("/api/module/{mId}")
	public void deleteModule(@PathVariable("mId")int moduleId) {
		moduleRepository.deleteById(moduleId);
	}
}