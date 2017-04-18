package org.complaint.web.controller.complaint;

import java.util.List;

import org.complaint.persistence.complaint.entity.ComplaintStatus;
import org.complaint.persistence.complaint.service.ComplaintStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/complaintstatus")
public class ComplaintStatusController {

	@Autowired
	private ComplaintStatusService complaintStatusService;

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(complaintStatusService.getAll());
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<ComplaintStatus> complaintStatuss) {
		return new ResponseEntity<List<ComplaintStatus>>(complaintStatuss, HttpStatus.OK);
	}

}