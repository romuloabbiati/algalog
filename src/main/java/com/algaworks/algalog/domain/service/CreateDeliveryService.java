package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.DeliveryStatus;
import com.algaworks.algalog.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CreateDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	private CustomerService customerService;
	
	@Transactional
	public Delivery create(Delivery delivery) {
		
		Customer retrievedCustomer = customerService.getCustomer(delivery.getCustomer().getId());
		
		delivery.setCustomer(retrievedCustomer);
		
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}
	
}
