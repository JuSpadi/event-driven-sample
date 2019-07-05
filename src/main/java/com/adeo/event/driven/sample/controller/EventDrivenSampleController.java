package com.adeo.event.driven.sample.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adeo.event.driven.sample.SenderIn;
import com.adeo.lys.event.context.ContextCreateOrUpdateInEvent;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/event-driven")
public class EventDrivenSampleController{

    private static final Logger LOG = LoggerFactory.getLogger(EventDrivenSampleController.class);
	
    @Autowired
    private SenderIn sender;
    
    @PostMapping(value = "/send")
    public ResponseEntity<Void> sendMessage(String messageContent) throws JsonParseException, JsonMappingException, IOException {
    	LOG.info("Creation message received");
		ObjectMapper mapper = new ObjectMapper();
		ClassPathResource sequenceRes = new ClassPathResource("/context.json");
		sender.send(mapper.readValue(sequenceRes.getFile(), ContextCreateOrUpdateInEvent.class));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}