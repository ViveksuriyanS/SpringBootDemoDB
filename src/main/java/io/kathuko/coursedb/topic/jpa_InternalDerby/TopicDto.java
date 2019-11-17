package io.kathuko.coursedb.topic.jpa_InternalDerby;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // default it creates a table with name TopicDto
public class TopicDto {
	// With columns id, name and description

	@Id // Makes the id as Primary Key to the table
	private String id;
	private String name;
	private String description;

	public TopicDto() {

	}

	public TopicDto(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

}

// With @Entity configuration now, the row in the table TopicDto can be converted to TopicDto Object

// TopicDto -> ROW <====> TopicDto->Object