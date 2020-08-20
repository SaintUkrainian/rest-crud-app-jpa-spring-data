package io.github.saintukrainian.restcrudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.saintukrainian.restcrudapp.dao.EmployeeRep;
import io.github.saintukrainian.restcrudapp.entity.Employee;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private EmployeeRep emplRep;

	@Override
	public List<Employee> findAll() {
		return emplRep.findAll();
	}

	@Override
	public Employee findOne(int id) {
		Optional<Employee> result = emplRep.findById(id);
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
			return employee;
		}
		
		else {
			throw new RuntimeException("Employee wasn't found! id="+id);
		}
		
	}

	@Override
	public void updateOne(Employee employee) {
		emplRep.save(employee);
	}

	@Override
	public void deleteOne(int id) {
		emplRep.deleteById(id);
	}

}
