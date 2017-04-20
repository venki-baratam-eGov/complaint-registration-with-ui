
package org.complaint.errorhandlers;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Error {

	@NotNull
	private Integer code;

	@NotNull
	private String message;

	private String description;

	/**
	 * FIXME : If we take List of Object, it will generate twice the actual result.
	 * 		   On first line, the key & on next line the value.
	 * PROPOSITION : Can take Map instead where Key is fieldName, Value is Error description
	 */
	private Map<String, Object> fields = new LinkedHashMap<String, Object>();
}
