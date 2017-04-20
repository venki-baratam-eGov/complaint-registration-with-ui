
package org.complaint.persistence.common.repository;

import org.complaint.persistence.common.entity.Boundary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoundaryRepository extends JpaRepository<Boundary, Long> {

	Boundary findByLongitudeAndLatitude(Double longitude, Double latitude);
}
