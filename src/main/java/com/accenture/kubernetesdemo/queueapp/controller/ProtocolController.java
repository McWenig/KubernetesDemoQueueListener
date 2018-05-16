package com.accenture.kubernetesdemo.queueapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.kubernetesdemo.queueapp.dao.ProtocolDao;
import com.accenture.kubernetesdemo.queueapp.domain.Protocol;

@Controller
public class ProtocolController {

  /**
   * Create a new protocol with an auto-generated id and email and name as passed 
   * values.
   */
  @RequestMapping(value="/protocol/create")
  @ResponseBody
  public String create(String name, Long actId) {
    try {
      Protocol protocol = new Protocol(name, actId);
      protocolDao.create(protocol);
    }
    catch (Exception ex) {
      return "Error creating the protocol: " + ex.toString();
    }
    return "Protocol succesfully created!";
  }
  
  /**
   * Delete the protocol with the passed id.
   */
  @RequestMapping(value="/protocol/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Protocol protocol = new Protocol(id);
      protocolDao.delete(protocol);
    }
    catch (Exception ex) {
      return "Error deleting the protocol: " + ex.toString();
    }
    return "Protocol succesfully deleted!";
  }
  
    
  /**
   * Update the email and the name for the protocol indentified by the passed id.
   */
  @RequestMapping(value="/update")
  @ResponseBody
  public String updateName(long id, String name) {
    try {
      Protocol protocol = protocolDao.getById(id);
      protocol.setName(name);
      protocolDao.update(protocol);
    }
    catch (Exception ex) {
      return "Error updating the protocol: " + ex.toString();
    }
    return "Protocol succesfully updated!";
  } 


  // Private fields
  
  // Wire the ProtocolDao used inside this controler.
  @Autowired
  private ProtocolDao protocolDao;
  
}