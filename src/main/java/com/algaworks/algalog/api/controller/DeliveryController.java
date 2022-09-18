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

import com.algaworks.algalog.api.assembler.DeliveryAssembler;
import com.algaworks.algalog.api.model.DeliveryModel;
import com.algaworks.algalog.api.model.input.DeliveryInput;
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
	
	private DeliveryAssembler deliveryAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryModel create(@Valid @RequestBody DeliveryInput delivery) {
		Delivery newDelivery = deliveryAssembler.toEntityModel(delivery);
		
		return deliveryAssembler.toModel(createDeliveryService.create(newDelivery));
	}
	
	@GetMapping
	public List<DeliveryModel> list() {
		List<Delivery> deliveries = deliveryRepository.findAll();
		return deliveryAssembler.toCollectionModel(deliveries);
	}
	
	@GetMapping(path = "/{deliveryId}")
	public ResponseEntity<DeliveryModel> findDelivery(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> {
					return ResponseEntity.ok(deliveryAssembler.toModel(delivery));
					
				}).orElse(ResponseEntity.notFound().build());
	}
	
}
