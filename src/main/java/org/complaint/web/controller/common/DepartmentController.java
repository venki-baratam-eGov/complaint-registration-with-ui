package org.complaint.web.controller.common;

import java.util.List;

import org.complaint.persistence.common.entity.Department;
import org.complaint.persistence.common.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(departmentService.getAll());
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<Department> departments) {
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}

}