
package org.complaint.errorhandlers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.complaint.web.contract.ResponseInfo;
import org.complaint.web.contract.factory.ResponseInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class ErrorHandler {

	@Autowired
	private ResponseInfoFactory responseInfoFactory;

	public ResponseEntity<ErrorResponse> getErrorResponseEntityForBindingErrors(BindingResult bindingResult) {
		Error error = new Error();
		error.setCode(400);
		error.setMessage("Binding Error");
		error.setDescription("Error while binding request object");

		if (bindingResult.hasFieldErrors()) {
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				if (fieldError.getField().contains("Date")) {
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String errorDate = dateFormat.format(fieldError.getRejectedValue());
					error.getFields().put(fieldError.getField(), errorDate);
				} else {
					error.getFields().put(fieldError.getField(), fieldError.getRejectedValue());
				}
			}
		}

		ResponseInfo responseInfo = responseInfoFactory.createResponseInfoFromRequestInfo(new Date().toString(), false);

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setResponseInfo(responseInfo);
		errorResponse.setError(error);

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
