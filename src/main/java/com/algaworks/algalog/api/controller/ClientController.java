package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> listar() {
		return clientRepository.findAll();
	}
	
}
