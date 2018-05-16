package com.accenture.kubernetesdemo.queueapp.messaging;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.accenture.kubernetesdemo.queueapp.dao.ProtocolDao;
import com.accenture.kubernetesdemo.queueapp.domain.Protocol;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ProtocolReceiver {
	
	private final static Log LOGGER = LogFactory.getLog(ProtocolReceiver.class);

	@Autowired
	ProtocolDao protocolDao;
	
    public void receiveMessage(String message) throws JsonParseException, JsonMappingException, IOException {
        LOGGER.info("Message <"+message.toString()+"> reveived");
        ObjectMapper mapper = new ObjectMapper();
        Protocol protocol = mapper.readValue(message, Protocol.class);
        protocolDao.create(protocol);
        LOGGER.info("Protocol "+protocol.toString()+" entry created");
    }


}
