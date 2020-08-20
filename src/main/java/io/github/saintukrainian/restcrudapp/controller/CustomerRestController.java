package io.github.saintukrainian.restcrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.saintukrainian.restcrudapp.entity.Employee;
import io.github.saintukrainian.restcrudapp.service.CustomerService;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		
		return service.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id) {
		
		return service.findOne(id);
	}
	
	@PostMapping("/employees")
	public String addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		service.updateOne(employee);
		return "New employee has been added!";
		
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		service.updateOne(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteOne(id);
	}

}
