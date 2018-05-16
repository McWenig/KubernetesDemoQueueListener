package com.accenture.kubernetesdemo.queueapp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.accenture.kubernetesdemo.queueapp.dao.ProtocolDao;
import com.accenture.kubernetesdemo.queueapp.domain.Protocol;

@RestController
public class TestController {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	private ProtocolDao protocollDao;
	
	@RequestMapping(path="hello")
	public String doSometing(){
		return "Hello World, I'm minikubetest2";
	}
	
	
	@RequestMapping(path="helloOthers")
	public String doSometingRemote() throws RestClientException, URISyntaxException{
		RestTemplate template = restTemplateBuilder.build();
		String result = template.getForObject(new URI("http://minikubetest1:8080/hello"), String.class);
		return "Other says: "+result;
	}
	
	@RequestMapping(path="helloDatabase")
	public List<Protocol> doSometingDataish() throws RestClientException, URISyntaxException{
		List<Protocol> actList = protocollDao.getAll();
		return actList;
	}
}
