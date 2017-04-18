package org.complaint.persistence.common.entity;

import javax.persistence.Column;
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

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "boundary")
@SequenceGenerator(name = Boundary.SEQ_BOUNDARY, sequenceName = Boundary.SEQ_BOUNDARY, allocationSize = 1)
public class Boundary extends AbstractAuditable {

	private static final long serialVersionUID = -4061895436388967094L;

	public static final String SEQ_BOUNDARY = "SEQ_BOUNDARY";

	@Id
	@GeneratedValue(generator = SEQ_BOUNDARY, strategy = GenerationType.SEQUENCE)
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

	@Column(name = "lng")
	private Double longitude;

	@Column(name = "lat")
	private Double latitude;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	protected void setId(Long id) {

	}

}