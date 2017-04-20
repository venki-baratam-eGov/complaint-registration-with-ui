
package org.complaint.persistence.common.service;

import java.util.List;

import org.complaint.persistence.common.entity.Department;
import org.complaint.persistence.common.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department getByCode(String code) {

		return departmentRepository.findByCode(code);
	}

	public List<Department> getAll() {

		return departmentRepository.findAll();
	}

	@Transactional
	public Department createDepartment(final Department department) {

		departmentRepository.save(department);

		return department;
	}
}
