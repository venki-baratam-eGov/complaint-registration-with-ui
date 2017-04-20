package org.complaint.persistence.complaint.service;

import java.util.List;

import org.complaint.persistence.complaint.entity.ComplaintType;
import org.complaint.persistence.complaint.repository.ComplaintTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ComplaintTypeService {

	@Autowired
	private ComplaintTypeRepository complaintTypeRepository;

	public ComplaintType getByCode(String code) {

		return complaintTypeRepository.findByCode(code);
	}

	public List<ComplaintType> getAll() {

		return complaintTypeRepository.findAll();
	}

}
