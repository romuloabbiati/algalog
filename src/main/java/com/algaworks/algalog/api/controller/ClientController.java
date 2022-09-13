package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> listar() {
		var client1 = new Client();
		client1.setId(1L);
		client1.setName("Joao das Couves");
		client1.setEmail("joaodascouves@email.com");
		client1.setTelephone("99988-7777");
		
		var client2 = new Client();
		client2.setId(2L);
		client2.setName("Maria da Silva");
		client2.setEmail("mariadasilva@email.com");
		client2.setTelephone("99977-6666");
		
		return Arrays.asList(client1, client2);
	}
	
}
