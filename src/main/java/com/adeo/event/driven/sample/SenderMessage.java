package com.adeo.event.driven.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import loyalty.internal.last.update.identifier.context.identification;

@Service
public class SenderMessage {

    private static final Logger LOG = LoggerFactory.getLogger(SenderMessage.class);

    @Autowired
    private KafkaTemplate<String, identification> kafkaTemplate;

    @Value("${app.topic.event-driven-topic-in}")
    private String topic;

    public void send(identification message){
    	LOG.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}