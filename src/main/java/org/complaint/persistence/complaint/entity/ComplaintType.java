package org.complaint.persistence.complaint.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.complaint.persistence.common.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "complainttype")
@SequenceGenerator(name = ComplaintType.SEQ_COMPLAINTTYPE, sequenceName = ComplaintType.SEQ_COMPLAINTTYPE, allocationSize = 1)
public class ComplaintType extends AbstractAuditable {

	public static final String SEQ_COMPLAINTTYPE = "SEQ_COMPLAINTTYPE";

	private static final long serialVersionUID = 8904645810221559541L;

	@Id
	@GeneratedValue(generator = SEQ_COMPLAINTTYPE, strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "code", updatable = false)
	private String code;

	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;

	private String description;

	@Column(name = "isactive")
	private boolean active;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category")
	private ComplaintTypeCategory category;

}
