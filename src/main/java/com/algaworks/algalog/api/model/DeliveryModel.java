package com.algaworks.algalog.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.DeliveryStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryModel {
	
	private Long id;
	private String customerName;
	private RecipientModel recipient;
	private BigDecimal fee;
	private DeliveryStatus status;
	private OffsetDateTime orderDate;
	private OffsetDateTime deliveryDate;

}
