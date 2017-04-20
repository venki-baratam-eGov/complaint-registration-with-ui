package org.complaint.persistence.complaint.repository;

import org.complaint.persistence.complaint.entity.ComplaintType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintTypeRepository extends JpaRepository<ComplaintType, Long> {

	ComplaintType findByCode(String code);
}
