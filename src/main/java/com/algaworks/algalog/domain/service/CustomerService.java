package com.algaworks.algalog.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.BusinessException;
import com.algaworks.algalog.domain.model.Customer;
import com.algaworks.algalog.domain.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomer(Long customerId) {
		return customerRepository.findById(customerId)
		.orElseThrow(() -> new BusinessException("Customer has not been found!"));
	}
	
	@Transactional
	public Customer save(Customer customer) {
		boolean isUsed = customerRepository.findByEmail(customer.getEmail())
				.stream()
				.anyMatch(checkedCustomer -> !checkedCustomer.equals(customer));
		
		if(isUsed) {
			throw new BusinessException("There is already a customer registered with this e-mail.");
		}
		
		return customerRepository.save(customer);
	}
	
	@Transactional
	public void delete(Long id) {
		customerRepository.deleteById(id);
	}
	
}
