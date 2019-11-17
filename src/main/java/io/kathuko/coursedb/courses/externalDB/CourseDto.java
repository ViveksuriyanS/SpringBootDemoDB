package io.kathuko.coursedb.courses.externalDB;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.kathuko.coursedb.topic.jpa_InternalDerby.TopicDto;

@Entity // default it creates a table with name CourseDto
public class CourseDto {
	// With columns id, name and description

	@Id // Makes the id as Primary Key to the table
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "Course name")
	private String name;
	@Column(name = "Course Description")
	private String description;
	@ManyToOne // Makes relationship with Course
	private TopicDto topic;

	public CourseDto() {

	}

	public CourseDto(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new TopicDto(topicId, "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TopicDto getTopic() {
		return topic;
	}

	public void setTopic(TopicDto topic) {
		this.topic = topic;
	}

}

// With @Entity configuration now, the row in the table CourseDto can be converted to CourseDto Object

// CourseDto -> ROW <====> CourseDto->Object