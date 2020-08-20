package io.github.saintukrainian.restcrudapp.service;

import java.util.List;

import io.github.saintukrainian.restcrudapp.entity.Employee;

public interface CustomerService {

	List<Employee> findAll();
	
	Employee findOne(int id);
	
	void updateOne(Employee employee);
	
	void deleteOne(int id);
}
