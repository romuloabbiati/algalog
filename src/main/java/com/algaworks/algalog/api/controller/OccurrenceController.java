package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.assembler.OccurrenceAssembler;
import com.algaworks.algalog.api.model.OccurrenceModel;
import com.algaworks.algalog.api.model.input.OccurrenceInput;
import com.algaworks.algalog.domain.model.Delivery;
import com.algaworks.algalog.domain.model.Occurrence;
import com.algaworks.algalog.domain.service.DeliveryService;
import com.algaworks.algalog.domain.service.OccurrenceService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

	private OccurrenceService occurrenceService;
	
	private OccurrenceAssembler occurrenceAssembler;
	
	private DeliveryService deliveryService;
	
	public List<OccurrenceModel> list(@PathVariable Long deliveryId) {
		Delivery retrievedDelivery = deliveryService.find(deliveryId);
		
		List<Occurrence> occurrencesList = retrievedDelivery.getOccurrences();
		
		return occurrenceAssembler.toCollectionModel(occurrencesList);
	}
	
	@PostMapping
	public OccurrenceModel register(@PathVariable Long deliveryId, 
			@Valid @RequestBody OccurrenceInput occurrenceInput) {
		
		Occurrence occurrence = occurrenceService.register(deliveryId, occurrenceInput.getDescription());
		
		return occurrenceAssembler.toModel(occurrence);
	}
	
}
