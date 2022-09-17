package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.repository.CustomerRepository;
import com.algaworks.algalog.domain.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public List<Customer> list() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable Long customerId) {
		return customerRepository.findById(customerId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer add(@Valid @RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> update(@PathVariable Long customerId, @Valid @RequestBody Customer customer) {
		
		if(!customerRepository.existsById(customerId)) {
			return ResponseEntity.notFound().build();
		}
		
		customer.setId(customerId);
		customer = customerService.save(customer);
		
		return ResponseEntity.ok(customer);
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> delete(@PathVariable Long customerId) {
		if(!customerRepository.existsById(customerId)) {
			return ResponseEntity.notFound().build();
		}
		
		customerService.delete(customerId);
		
		return ResponseEntity.noContent().build();
	}
	
}
