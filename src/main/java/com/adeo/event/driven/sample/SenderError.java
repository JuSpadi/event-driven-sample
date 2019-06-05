package com.adeo.event.driven.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.adeo.event.driven.avro.RecordIn;

@Service
public class SenderError {

    private static final Logger LOG = LoggerFactory.getLogger(SenderError.class);

    @Autowired
    private KafkaTemplate<String, RecordIn> kafkaInTemplate;

    @Value("${app.topic.event-driven-topic-error}")
    private String topic;

    public void send(RecordIn message){
        LOG.info("Error message sending='{}' to topic='{}'", message, topic);
        kafkaInTemplate.send(topic, message);
    }
}