package ramos.monteiro.alex.figurinhas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ramos.monteiro.alex.figurinhas.kafka.producer.TopicProducer;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/kafka")
public class ControllerTest {

	
	private final TopicProducer topicProducer;

	@GetMapping(value = "/send")
	public void send() {
		topicProducer.send("Mensagem de teste enviada ao tópico");
	}

}
