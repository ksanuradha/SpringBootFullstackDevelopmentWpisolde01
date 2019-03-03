package com.javasampleapproach.jqueryajax.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.jqueryajax.message.Response;
import com.javasampleapproach.jqueryajax.model.Customer;
import com.javasampleapproach.jqueryajax.model.CustomerRepository;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {
	
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping(value = "/all")
	public Response getResource() {
		List<Customer> findAll = customerRepository.findAll();
		Response response = new Response("Done", findAll);
		return response;
	}

	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		Response response = new Response("Done", customer);
		return response;
	}
}