package com.algaworks.algalog.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.service.CreateDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/deliveries")
public class DeliveryController {

	private CreateDeliveryService createDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery create(@RequestBody Delivery delivery) {
		return createDeliveryService.create(delivery);
	}
	
}
