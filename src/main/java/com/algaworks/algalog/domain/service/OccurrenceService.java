package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OccurrenceService {
	
	private DeliveryService deliveryService;
	
	@Transactional
	public Occurrence register(Long deliveryId, String description) {
		Delivery retrievedDelivery = deliveryService.find(deliveryId);
		
		return retrievedDelivery.addOccurrence(description);
	}
	
}
