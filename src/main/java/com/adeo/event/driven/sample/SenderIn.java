package com.adeo.event.driven.sample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.adeo.event.driven.avro.RecordIn;

@Service
public class SenderIn {

    private static final Logger LOG = LoggerFactory.getLogger(SenderIn.class);

    @Autowired
    private KafkaTemplate<String, RecordIn> kafkaRecordInTemplate;

    @Value("${app.topic.event-driven-topic-in}")
    private String topic;

    public void send(RecordIn message){
        LOG.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaRecordInTemplate.send(topic, message);
    }
}