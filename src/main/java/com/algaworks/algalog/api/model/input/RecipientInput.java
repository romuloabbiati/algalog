package com.algaworks.algalog.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientInput {

	@NotBlank
	private String name;
	
	@NotBlank
	private String road;
	
	@NotBlank
	private String number;
	
	@NotBlank
	private String place;
	
	@NotBlank
	private String neighborhood;
	
}
