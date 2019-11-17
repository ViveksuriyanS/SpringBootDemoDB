package io.kathuko.coursedb.topic.jpa_InternalDerby;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Serves different request and process in DB and respond with rows->Object
public class TopicBusinessService {

	@Autowired
	private TopicRepository topicRepository;

	public List<TopicDto> getAllTopics() {
		List<TopicDto> topicList = new ArrayList<TopicDto>();
		topicRepository.findAll().forEach(topicList::add);
		return topicList;
	}

	public TopicDto getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(TopicDto topic) {
		topicRepository.save(topic);

	}

	public void updateTopic(TopicDto topic) {
		topicRepository.save(topic); // Save can do both add/update with pk_id
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}

// Service is a special annotation of @Component annotation