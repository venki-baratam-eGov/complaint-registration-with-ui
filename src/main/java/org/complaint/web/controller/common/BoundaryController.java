package org.complaint.web.controller.common;

import java.util.List;

import org.complaint.persistence.common.entity.Boundary;
import org.complaint.persistence.common.service.BoundaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boundary")
public class BoundaryController {

	@Autowired
	private BoundaryService boundaryService;

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(boundaryService.getAll());
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<Boundary> boundarys) {
		return new ResponseEntity<List<Boundary>>(boundarys, HttpStatus.OK);
	}

}