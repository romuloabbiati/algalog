package com.algaworks.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Client;
import com.algaworks.algalog.domain.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Transactional
	public Client save(Client client) {
		boolean isUsed = clientRepository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(checkedClient -> !checkedClient.equals(client));
		
		if(isUsed) {
			throw new BusinessException("There is already a client registered with this e-mail.");
		}
		
		return clientRepository.save(client);
	}
	
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
}
