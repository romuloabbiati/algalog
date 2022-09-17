package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.RecipientModel;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.repository.DeliveryRepository;
import com.algaworks.algalog.domain.service.CreateDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/deliveries")
public class DeliveryController {

	private CreateDeliveryService createDeliveryService;
	
	private DeliveryRepository deliveryRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery create(@Valid @RequestBody Delivery delivery) {
		return createDeliveryService.create(delivery);
	}
	
	@GetMapping
	public List<Delivery> list() {
		return deliveryRepository.findAll();
	}
	
	@GetMapping(path = "/{deliveryId}")
	public ResponseEntity<DeliveryModel> findDelivery(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> {
					DeliveryModel deliveryModel = new DeliveryModel();
					deliveryModel.setId(delivery.getId());
					deliveryModel.setCustomerName(delivery.getCustomer().getName());
					deliveryModel.setRecipient(new RecipientModel());
					deliveryModel.getRecipient().setName(delivery.getRecipient().getName());
					deliveryModel.getRecipient().setRoad(delivery.getRecipient().getRoad());
					deliveryModel.getRecipient().setNumber(delivery.getRecipient().getNumber());
					deliveryModel.getRecipient().setPlace(delivery.getRecipient().getPlace());
					deliveryModel.getRecipient().setNeighborhood(delivery.getRecipient().getNeighborhood());
					deliveryModel.setFee(delivery.getFee());
					deliveryModel.setStatus(delivery.getStatus());
					deliveryModel.setOrderDate(delivery.getOrderDate());
					deliveryModel.setDeliveryDate(delivery.getDeliveryDate());
					
					return ResponseEntity.ok(deliveryModel);
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
