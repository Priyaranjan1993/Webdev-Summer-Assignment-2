package com.example.webdevassignment2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevassignment2.models.Lesson;
import com.example.webdevassignment2.models.Topic;
import com.example.webdevassignment2.repositories.LessonRepository;
import com.example.webdevassignment2.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {

	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;
	
	@PostMapping("/api/course/module/lesson/topic/{lessonId}")
	public Topic createTopic(@RequestBody Topic newTopic,@PathVariable("lessonId") int lessonId) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			Lesson lesson = data.get();
			newTopic.setLesson(lesson);
			return topicRepository.save(newTopic);
		}
		return null;
	}
	

	@GetMapping("/api/course/module/lesson/topic/{lessonId}")
	public List<Topic> findAllTopicsForLesson(@PathVariable("lessonId") int lessonId) 
	{
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		if(data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getTopic();
		}
		return null;
	}
}
