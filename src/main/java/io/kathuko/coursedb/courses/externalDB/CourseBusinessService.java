package io.kathuko.coursedb.courses.externalDB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Serves different request and process in DB and respond with rows->Object
public class CourseBusinessService {

	@Autowired
	private CourseRepository courseRepository;

	public List<CourseDto> getAllCourses(String topicId) {
		List<CourseDto> courseList = new ArrayList<CourseDto>();
		courseRepository.findByTopicId(topicId).forEach(courseList::add);
		return courseList;
	}

	public CourseDto getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(CourseDto course) {
		courseRepository.save(course);

	}

	public void updateCourse(CourseDto course) {
		courseRepository.save(course); // Save can do both add/update with pk_id
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}

// Service is a special annotation of @Component annotation