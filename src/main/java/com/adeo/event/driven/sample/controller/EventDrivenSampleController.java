package com.adeo.event.driven.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adeo.event.driven.avro.RecordIn;
import com.adeo.event.driven.sample.SenderIn;

@Controller
@RequestMapping("/event-driven")
public class EventDrivenSampleController{

    private static final Logger LOG = LoggerFactory.getLogger(EventDrivenSampleController.class);
	
    @Autowired
    private SenderIn sender;
    
    @PostMapping(value = "/send")
    public ResponseEntity<Void> sendMessage(String messageContent) {
    	LOG.info("Creation message received");
    	sender.send(new RecordIn("Test", messageContent, "other"));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}