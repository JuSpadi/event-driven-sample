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
    
    private int count = 0;
    
    private static final Logger LOG = LoggerFactory.getLogger(EventDrivenSampleService.class);
	
    public void sendMessage(Record messageContent) throws Exception {
    	String transformedMessage = "Transformed : "+messageContent;
    	LOG.info("Message treated in service : {}, transforming it to : {}", messageContent, transformedMessage);
    	count++;
    	if (count%2 == 0) {
    		throw new RuntimeException();
    	} 
    	sender.send(messageContent);
    }
}
