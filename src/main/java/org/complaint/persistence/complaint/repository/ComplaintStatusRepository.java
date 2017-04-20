package org.complaint.persistence.complaint.repository;

import java.util.List;

import org.complaint.persistence.complaint.entity.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Long> {

	ComplaintStatus findByName(String name);
	
	@Query("select cs from ComplaintStatus cs where cs.name in(:names)	")
	List<ComplaintStatus> findByNames(@Param("names") List<String> names);
}
