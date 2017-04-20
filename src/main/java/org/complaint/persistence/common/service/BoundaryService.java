
package org.complaint.persistence.common.service;

import java.util.List;

import org.complaint.persistence.common.entity.Boundary;
import org.complaint.persistence.common.repository.BoundaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BoundaryService {

	@Autowired
	private BoundaryRepository boundaryRepository;

	public Boundary getByLongitudeAndLatitude(Double longitude, Double latitude) {

		return boundaryRepository.getOne(1l);
	}

	public List<Boundary> getAll() {

		return boundaryRepository.findAll();
	}

	@Transactional
	public Boundary createBoundary(final Boundary boundary) {

		boundaryRepository.save(boundary);

		return boundary;
	}
}
