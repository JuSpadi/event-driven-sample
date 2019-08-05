package com.adeo.event.driven.sample;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import loyalty.internal.last.out.identifier.context.identification;
@Service
public class ReceiverMessage {

    private static final Logger LOG = LoggerFactory.getLogger(ReceiverMessage.class);
   
    @KafkaListener(topics = "${app.topic.event-driven-topic-out}")
	public void listenMessage(@Payload ConsumerRecord<?, identification> reponse, @Headers MessageHeaders headers){
    	identification value = reponse.value();
		LOG.info("message received '{}'", value);
	}
}