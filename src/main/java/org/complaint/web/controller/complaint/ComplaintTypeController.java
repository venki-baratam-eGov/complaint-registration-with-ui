package org.complaint.web.controller.complaint;

import java.util.List;

import org.complaint.persistence.complaint.entity.ComplaintType;
import org.complaint.persistence.complaint.service.ComplaintTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complainttype")
public class ComplaintTypeController {

	@Autowired
	private ComplaintTypeService complaintTypeService;

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(complaintTypeService.getAll());
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<ComplaintType> complaintTypes) {
		return new ResponseEntity<List<ComplaintType>>(complaintTypes, HttpStatus.OK);
	}

}