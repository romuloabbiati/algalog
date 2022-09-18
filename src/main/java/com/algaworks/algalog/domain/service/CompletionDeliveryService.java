package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompletionDeliveryService {
	
	private DeliveryService deliveryService;
	
	private DeliveryRepository deliveryRepository;

	@Transactional
	public void complete(Long deliveryId) {
		Delivery retrievedDelivery = deliveryService.find(deliveryId);
		
		retrievedDelivery.complete();
		
		deliveryRepository.save(retrievedDelivery);
	}
	
}
