package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntityNotFoundException;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DeliveryService {
	
	private DeliveryRepository deliveryRepository;
	
	public Delivery find(Long id) {
		return deliveryRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Delivery not found!"));
	}
	
}