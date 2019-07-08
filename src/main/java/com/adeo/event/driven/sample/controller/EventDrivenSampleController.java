package com.adeo.event.driven.sample.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adeo.event.driven.sample.SenderIn;
import com.adeo.lys.event.context.ContextCreateOrUpdateInEvent;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
@RequestMapping("/event-driven")
public class EventDrivenSampleController{

    private static final Logger LOG = LoggerFactory.getLogger(EventDrivenSampleController.class);
	
    @Autowired
    private SenderIn sender;
    
    @PostMapping(value = "/send")
    public ResponseEntity<Void> sendMessage(@RequestBody@Valid ContextCreateOrUpdateInEvent event) throws JsonParseException, JsonMappingException, IOException {
    	LOG.info("Creation message received");
		sender.send(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}