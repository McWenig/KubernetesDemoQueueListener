package com.accenture.kubernetesdemo.queueapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.kubernetesdemo.queueapp.dao.ProtocolDao;
import com.accenture.kubernetesdemo.queueapp.domain.Protocol;

@Controller
public class ProtocolController {

	/**
	 * Create a new protocol with an auto-generated id and email and name as
	 * passed values.
	 */
	@RequestMapping(value = "/protocols")
	@ResponseBody
	public List<Protocol> list() {
		List<Protocol> actList = protocolDao.getAll();
		return actList;
	}

	@Autowired
	private ProtocolDao protocolDao;

}