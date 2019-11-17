package io.kathuko.coursedb.courses.externalDB;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseDto, String> {

	// custom find method should start with find_By_Name
	// eg. findByName(String name) -> JPA automatically implement

	//
	public List<CourseDto> findByName(String name);

	public List<CourseDto> findByDescription(String description);
	
	// find_By_Topic_id Id in Topic
	public List<CourseDto> findByTopicId(String topicId);

}

// Irrespective of the Entity (Course, Weather, Item) the below structure remains the same
// 1. getAll() -> Returns all the objects
// 2. get(id)  -> Returns the object that matches the id
// 3. delete(id) -> Deletes the object with the id
// 4. update(Object) -> Updates the object if present, else add

// Spring Data JPA, does all the above common functionalities done.
// Predefined standard methods
// We can implement the custom methods