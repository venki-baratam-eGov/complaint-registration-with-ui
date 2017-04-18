package org.complaint.persistence.common.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.complaint.persistence.complaint.entity.AbstractAuditable;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "department")
@SequenceGenerator(name = Department.SEQ_DEPARTMENT, sequenceName = Department.SEQ_DEPARTMENT, allocationSize = 1)
public class Department extends AbstractAuditable {

	private static final long serialVersionUID = 178123766561239146L;

	public static final String SEQ_DEPARTMENT = "SEQ_DEPARTMENT";

	@Id
	@GeneratedValue(generator = SEQ_DEPARTMENT, strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Length(max = 25)
	private String name;

	@NotNull
	@Length(max = 25)
	private String code;

	@NotNull
	@Length(max = 256)
	private String description;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	protected void setId(final Long id) {
		this.id = id;
	}
}
