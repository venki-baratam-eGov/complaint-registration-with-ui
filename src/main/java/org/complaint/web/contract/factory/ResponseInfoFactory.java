package org.complaint.web.contract.factory;

import org.complaint.web.contract.ResponseInfo;
import org.springframework.stereotype.Component;

@Component
public class ResponseInfoFactory {

	public ResponseInfo createResponseInfoFromRequestInfo(String ts, Boolean status) {

		String responseStatus = status ? "successful" : "failed";

		return new ResponseInfo(ts, responseStatus);
	}

}