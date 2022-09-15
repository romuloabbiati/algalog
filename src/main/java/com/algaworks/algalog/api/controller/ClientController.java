package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Client;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager;
	
	@GetMapping("/clients")
	public List<Client> listar() {
		return manager.createQuery("from Client", Client.class).getResultList();
	}
	
}
