
package org.complaint.persistence.common.repository;

import org.complaint.persistence.common.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByCode(String code);
}
