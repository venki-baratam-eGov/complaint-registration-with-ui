
package org.complaint.persistence.common.service;

import java.util.List;
import java.util.Optional;

import org.complaint.persistence.common.entity.Employee;
import org.complaint.persistence.common.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<Employee> getById(Long id) {

		return employeeRepository.findById(id);
	}

	public List<Employee> getAll() {

		return employeeRepository.findAll();
	}

	@Transactional
	public Employee createEmployee(final Employee employee) {

		employeeRepository.save(employee);

		return employee;
	}
}
