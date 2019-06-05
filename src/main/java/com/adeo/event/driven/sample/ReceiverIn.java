package com.adeo.event.driven.sample;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.adeo.event.driven.avro.Record;
import com.adeo.event.driven.sample.service.EventDrivenSampleService;

@Service
public class ReceiverIn {

    private static final Logger LOG = LoggerFactory.getLogger(ReceiverIn.class);

    @Resource
    private EventDrivenSampleService service;
    
    @Resource
    private SenderError senderError;
    
    @KafkaListener(topics = "${app.topic.event-driven-topic-in}")
    public void listen(@Payload Record message, Acknowledgment acknowledgment) {
    	LOG.info("Received message='{}'", message);
    	try {
			service.sendMessage(message);
		} catch (Exception e) {
			senderError.send(message);
		}
    	acknowledgment.acknowledge();
    }

}