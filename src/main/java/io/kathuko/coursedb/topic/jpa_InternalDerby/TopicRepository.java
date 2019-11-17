package io.kathuko.coursedb.topic.jpa_InternalDerby;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<TopicDto, String> {
	
}

// Irrespective of the Entity (Course, Weather, Item) the below structure remains the same
// 1. getAll() -> Returns all the objects
// 2. get(id)  -> Returns the object that matches the id
// 3. delete(id) -> Deletes the object with the id
// 4. update(Object) -> Updates the object if present, else add

// Spring Data JPA, does all the above common functionalities done.
// Predefined standard methods
// We can implement the custom methods