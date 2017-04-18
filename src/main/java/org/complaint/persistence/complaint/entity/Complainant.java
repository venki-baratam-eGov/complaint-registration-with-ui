
package org.complaint.persistence.complaint.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "complainant")
@SequenceGenerator(name = Complainant.SEQ_COMPLAINANT, sequenceName = Complainant.SEQ_COMPLAINANT, allocationSize = 1)
public class Complainant extends AbstractPersistable<Long> {

	public static final String SEQ_COMPLAINANT = "SEQ_COMPLAINANT";
	
	private static final long serialVersionUID = 5691022600220045218L;
	
	@Id
	@GeneratedValue(generator = SEQ_COMPLAINANT, strategy = GenerationType.SEQUENCE)
	private Long id;

	private String name;

	private String mobile;

	private String email;

	private String address;

}
