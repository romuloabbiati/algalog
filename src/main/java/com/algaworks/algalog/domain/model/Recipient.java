package com.algaworks.algalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {

	@Column(name = "recipient_name")
	private String name;
	
	@Column(name = "recipient_road")
	private String road;
	
	@Column(name = "recipient_number")
	private String number;
	
	@Column(name = "recipient_place")
	private String place;
	
	@Column(name = "recipient_neighborhood")
	private String neighborhood;
	
}
