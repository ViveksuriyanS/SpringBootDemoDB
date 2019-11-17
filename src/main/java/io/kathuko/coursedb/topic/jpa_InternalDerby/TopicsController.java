package io.kathuko.coursedb.topic.jpa_InternalDerby;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {
	@Autowired // Enables to inject dependency implicitly
	// Internally uses setter or constructor injection
	private TopicBusinessService topicService;

	@RequestMapping("/topics")
	public List<TopicDto> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public TopicDto getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody TopicDto topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void udateTopic(@RequestBody TopicDto topic, @PathVariable String id) {
		topicService.updateTopic(topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}

// @Controller is a common SpringMVC controller
// @RestController is a special controller in RESTful web services
//    - Combination of @RestResponse+@Controller	