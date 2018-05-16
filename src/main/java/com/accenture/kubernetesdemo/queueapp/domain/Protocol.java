package com.accenture.kubernetesdemo.queueapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Protocol implements Serializable{


	private static final long serialVersionUID = 2828506261015290214L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Long actId;
	
	protected Protocol() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}

	public Protocol(String name, Long actId) {
		this.name = name;
		this.actId = actId;
	}

	public Protocol(long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}
}
