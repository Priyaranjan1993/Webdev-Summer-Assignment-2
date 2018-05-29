package com.example.webdevassignment2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.webdevassignment2.models.*;

public interface CourseRepository
extends CrudRepository<Course, Integer> { }