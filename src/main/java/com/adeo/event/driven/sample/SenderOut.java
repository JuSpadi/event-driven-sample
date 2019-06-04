package com.adeo.event.driven.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderOut {

    private static final Logger LOG = LoggerFactory.getLogger(SenderOut.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.topic.event-driven-topic-out}")
    private String topic;

    public void send(String message){
        LOG.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic, message);
    }
}