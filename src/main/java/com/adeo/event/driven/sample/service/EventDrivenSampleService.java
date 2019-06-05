/**
 * 
 */
package com.adeo.event.driven.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adeo.event.driven.avro.Record;
import com.adeo.event.driven.sample.SenderOut;

/**
 * @author spadi
 *
 */
@Service
public class EventDrivenSampleService {

    @Autowired
    private SenderOut sender;
    
    private static final Logger LOG = LoggerFactory.getLogger(EventDrivenSampleService.class);
	
    public void sendMessage(Record messageContent) {
    	String transformedMessage = "Transformed : "+messageContent;
    	LOG.info("Message treated in service : {}, transforming it to : {}", messageContent, transformedMessage);
    	sender.send(messageContent);
    }
}
