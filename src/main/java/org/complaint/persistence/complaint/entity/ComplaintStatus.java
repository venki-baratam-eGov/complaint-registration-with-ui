package org.complaint.persistence.complaint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "complaintstatus")
@SequenceGenerator(name = ComplaintStatus.SEQ_COMPLAINTSTATUS, sequenceName = ComplaintStatus.SEQ_COMPLAINTSTATUS, allocationSize = 1)
public class ComplaintStatus extends AbstractPersistable<Long> {
	public static final String SEQ_COMPLAINTSTATUS = "SEQ_COMPLAINTSTATUS";
	private static final long serialVersionUID = -9009821412847211632L;
	@Id
	@GeneratedValue(generator = SEQ_COMPLAINTSTATUS, strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	private String name;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	protected void setId(final Long id) {
		this.id = id;
	}
}
