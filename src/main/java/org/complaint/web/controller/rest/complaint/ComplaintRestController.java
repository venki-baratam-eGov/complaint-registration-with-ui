package org.complaint.web.controller.rest.complaint;

import java.util.List;

import org.complaint.errorhandlers.ErrorHandler;
import org.complaint.persistence.complaint.entity.Complaint;
import org.complaint.persistence.complaint.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/complaint")
public class ComplaintRestController {

	@Autowired
	private ErrorHandler errorHandler;

	@Autowired
	private ComplaintService complaintService;

	@PostMapping("_create")
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody Complaint complaint, BindingResult bindingResult) {

		ResponseEntity<?> errorResponseEntity = validateComplaintRequest(complaint, bindingResult);
		if (errorResponseEntity != null)
			return errorResponseEntity;

		return getSuccessResponseForCreate(complaintService.createComplaint(complaint));
	}

	@PostMapping("/{id}/_update")
	@ResponseBody
	public ResponseEntity<?> update(@RequestBody Complaint complaint, BindingResult bindingResult,
			@PathVariable(name = "id") Long id) {

		ResponseEntity<?> errorResponseEntity = validateComplaintRequest(complaint, bindingResult);
		if (errorResponseEntity != null)
			return errorResponseEntity;
		complaint.setId(id);
		return getSuccessResponseForCreate(complaintService.updateComplaint(complaint));
	}

	@GetMapping("_search")
	@ResponseBody
	public ResponseEntity<?> search() {
		return getSuccessResponseForSearch(complaintService.getAll());
	}

	private ResponseEntity<?> validateComplaintRequest(Complaint complaint, BindingResult bindingResult) {
		// validate input params that can be handled by annotations
		if (bindingResult.hasErrors()) {
			return errorHandler.getErrorResponseEntityForBindingErrors(bindingResult);
		}
		return null;
	}

	public ResponseEntity<?> getSuccessResponseForSearch(List<Complaint> complaintStatuss) {
		return new ResponseEntity<List<Complaint>>(complaintStatuss, HttpStatus.OK);
	}

	public ResponseEntity<?> getSuccessResponseForCreate(Complaint complaint) {
		return new ResponseEntity<Complaint>(complaint, HttpStatus.OK);
	}

}