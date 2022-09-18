package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.algaworks.algalog.domain.exception.BusinessException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@Valid
//	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
//	@NotNull
	@ManyToOne
	private Customer customer;
	
//	@Valid
//	@NotNull
	@Embedded
	private Recipient recipient;
	
//	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occurrences = new ArrayList<>();
	
//	@NotNull
	private BigDecimal fee;
	
//	@JsonProperty(access = Access.READ_ONLY)	
	private OffsetDateTime orderDate;
	
//	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime deliveryDate;

	public Occurrence addOccurrence(String description) {
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setOccurrenceDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOccurrences().add(occurrence);
		
		return occurrence;
	}

	public void complete() {
		
		if(cannotBeCompleted()) {
			throw new BusinessException("Delivery cannot be completed!");
		}
		
		this.setStatus(DeliveryStatus.DONE);
		this.setDeliveryDate(OffsetDateTime.now());
	}

	public boolean canBeCompleted() {
		return DeliveryStatus.PENDING.equals(this.getStatus());
	}
	
	public boolean cannotBeCompleted() {
		return !canBeCompleted();
	}

}
