package org.complaint.persistence.complaint.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.complaint.persistence.common.entity.Boundary;
import org.complaint.persistence.common.entity.Department;
import org.complaint.persistence.common.entity.Employee;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "complaint")
@SequenceGenerator(name = Complaint.SEQ_COMPLAINT, sequenceName = Complaint.SEQ_COMPLAINT, allocationSize = 1)
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Complaint extends AbstractAuditable {

	public static final String SEQ_COMPLAINT = "SEQ_COMPLAINT";

	private static final long serialVersionUID = 4020616083055647372L;

	@Id
	@GeneratedValue(generator = SEQ_COMPLAINT, strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "crn", unique = true)
	private String crn = "";

	@ManyToOne
	@JoinColumn(name = "complainttype")
	private ComplaintType complaintType;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "complainant", nullable = false)
	private Complainant complainant = new Complainant();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "assignee")
	private Employee assignee;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location")
	private Boundary location;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status")
	private ComplaintStatus status;

	private String details;

	@Column(name = "landmarkdetails")
	private String landmarkDetails;

	@Column(name = "lng")
	private Double longitude;

	@Column(name = "lat")
	private Double latitude;

	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;
	
	@Length(max=1024)
	private String comments;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}