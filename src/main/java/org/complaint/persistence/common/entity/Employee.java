
package org.complaint.persistence.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.complaint.persistence.complaint.entity.AbstractAuditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "employee")
@SequenceGenerator(name = Employee.SEQ_EMPLOYEE, sequenceName = Employee.SEQ_EMPLOYEE, allocationSize = 1)
public class Employee extends AbstractAuditable {

	private static final long serialVersionUID = -6508891779750985726L;

	public static final String SEQ_EMPLOYEE = "SEQ_EMPLOYEE";

	@Id
	@GeneratedValue(generator = SEQ_EMPLOYEE, strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	private String mobile;

	private String email;

	private String address;

}
