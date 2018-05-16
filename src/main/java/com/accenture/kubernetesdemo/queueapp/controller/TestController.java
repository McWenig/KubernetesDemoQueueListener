package com.accenture.kubernetesdemo.queueapp.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.accenture.kubernetesdemo.queueapp.dao.ProtocolDao;
import com.accenture.kubernetesdemo.queueapp.domain.Protocol;

@RestController
public class TestController {

	@Autowired
	private ProtocolDao protocolDao;
	
	@RequestMapping(path="hello")
	public String doSometing(){
		return "Hello World, I'm listening";
	}
	
	@RequestMapping(path="helloDatabase")
	public List<Protocol> doSometingDataish() throws RestClientException, URISyntaxException{
		List<Protocol> actList = protocolDao.getAll();
		return actList;
	}
}
