package ramos.monteiro.alex.figurinhas.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ramos.monteiro.alex.figurinhas.model.ProduceForAlbum;
import ramos.monteiro.alex.figurinhas.service.impl.FigurinhaServiceImpl;

@Slf4j
@RequiredArgsConstructor
@Service
public class TopicConsumer {

	@Autowired
	private FigurinhaServiceImpl service;

	@Value("${topic.name.consumer")
	private String topicName;

	Gson gson = new Gson();

	@KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
	public void consume(ConsumerRecord<String, String> payload) {

		ProduceForAlbum albumForSave = gson.fromJson(payload.value(), ProduceForAlbum.class);

		service.gerarFigurinhas(albumForSave.getAlbumId());
		
		TopicConsumer.log.info("Tópico: {}", topicName);
		TopicConsumer.log.info("key: {}", payload.key());
		TopicConsumer.log.info("Headers: {}", payload.headers());
		TopicConsumer.log.info("Partion: {}", payload.partition());
		TopicConsumer.log.info("Order: {}", payload.value());

	}

}
