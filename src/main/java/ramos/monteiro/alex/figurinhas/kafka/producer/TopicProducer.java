package ramos.monteiro.alex.figurinhas.kafka.producer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class TopicProducer {
	

    @Value("${topic.name.producer}")
    private String topicName;

    
    private final KafkaTemplate<String, String> kafkaTemplate;


    public void send(String message){
    	TopicProducer.log.info("Payload enviado: {}" + message);
        kafkaTemplate.send(topicName, message);
    	
    }

}