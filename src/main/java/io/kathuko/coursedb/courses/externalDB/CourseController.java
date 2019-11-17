package io.kathuko.coursedb.courses.externalDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kathuko.coursedb.topic.jpa_InternalDerby.TopicDto;

@RestController
public class CourseController {
	@Autowired // Enables to inject dependency implicitly
	// Internally uses setter or constructor injection
	private CourseBusinessService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	public List<CourseDto> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public CourseDto getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
	public void addCourse(@RequestBody CourseDto course, @PathVariable String topicId) {
		course.setTopic(new TopicDto(topicId, "", "")); // Mapping topic to the Course
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{id}")
	// RequestBody takes the input from BODY section in postman
	public void udateCourse(@RequestBody CourseDto course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new TopicDto(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String id) {
		courseService.deleteCourse(id);
	}
}

// @Controller is a common SpringMVC controller
// @RestController is a special controller in RESTful web services
//    - Combination of @RestResponse+@Controller	