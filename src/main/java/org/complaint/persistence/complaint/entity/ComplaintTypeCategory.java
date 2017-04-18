package org.complaint.persistence.complaint.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "complainttypecategory_write")
@Table(name = "complainttype_category")
@SequenceGenerator(name = ComplaintTypeCategory.SEQ_COMP_TYPE_CATEGORY, sequenceName = ComplaintTypeCategory.SEQ_COMP_TYPE_CATEGORY, allocationSize = 1)
public class ComplaintTypeCategory extends AbstractPersistable<Long> {
	private static final long serialVersionUID = 2739365086791183614L;

	public static final String SEQ_COMP_TYPE_CATEGORY = "SEQ_COMPLAINTTYPE_CATEGORY";

	@Id
	@GeneratedValue(generator = SEQ_COMP_TYPE_CATEGORY, strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	@Length(min = 5, max = 100)
	private String name;

	@Length(max = 250)
	private String description;

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonIgnore
	private List<ComplaintType> complaintTypes;

	@Override
	protected void setId(final Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
}
