package org.complaint.web.controller.common;

import java.util.List;

import org.complaint.persistence.common.entity.Employee;
import org.complaint.persistence.common.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(employeeService.getAll());
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<Employee> employees) {
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

}