/**
 * 
 */
package com.adeo.event.driven.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adeo.event.driven.avro.RecordIn;
import com.adeo.event.driven.avro.RecordOut;
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
	
    public void sendMessage(RecordIn messageContent) throws Exception {
    	RecordOut other = new RecordOut("Transformed" + messageContent.getLabel());
    	LOG.info("Message transformation");
    	count++;
    	if (count%2 == 0) {
    		throw new RuntimeException("error");
    	} 
    	sender.send(other);
    }
}
