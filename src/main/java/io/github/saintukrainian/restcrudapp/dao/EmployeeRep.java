package io.github.saintukrainian.restcrudapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.saintukrainian.restcrudapp.entity.Employee;

public interface EmployeeRep extends JpaRepository<Employee, Integer> {

}
