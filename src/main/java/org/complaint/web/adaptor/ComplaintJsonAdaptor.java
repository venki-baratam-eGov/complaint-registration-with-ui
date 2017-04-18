package org.complaint.web.adaptor;

import java.lang.reflect.Type;

import org.complaint.persistence.complaint.entity.Complaint;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class ComplaintJsonAdaptor implements JsonSerializer<Complaint> {
	@Override
	public JsonElement serialize(final Complaint complaint, final Type type, final JsonSerializationContext jsc) {
		final JsonObject jsonObject = new JsonObject();
		if (complaint != null) {
			if (complaint.getCrn() != null)
				jsonObject.addProperty("crn", complaint.getCrn());
			else
				jsonObject.addProperty("crn", "");

			if (complaint.getComplaintType() != null && complaint.getComplaintType().getName() != null)
				jsonObject.addProperty("complaintType", complaint.getComplaintType().getName());
			else
				jsonObject.addProperty("complaintType", "");

			if (complaint.getComplainant() != null && complaint.getComplainant().getName() != null)
				jsonObject.addProperty("complainant", complaint.getComplainant().getName());
			else
				jsonObject.addProperty("complainant", "");

			if (complaint.getLocation() != null && complaint.getLocation().getName() != null)
				jsonObject.addProperty("location", complaint.getLocation().getName());
			else
				jsonObject.addProperty("location", "");

			if (complaint.getStatus() != null && complaint.getStatus().getName() != null)
				jsonObject.addProperty("status", complaint.getStatus().getName());
			else
				jsonObject.addProperty("status", "");

			if (complaint.getDetails() != null)
				jsonObject.addProperty("details", complaint.getDetails());
			else
				jsonObject.addProperty("details", "");

			if (complaint.getLandmarkDetails() != null)
				jsonObject.addProperty("landmarkDetails", complaint.getLandmarkDetails());
			else
				jsonObject.addProperty("landmarkDetails", "");

			if (complaint.getLongitude() != null)
				jsonObject.addProperty("longitude", complaint.getLongitude());
			else
				jsonObject.addProperty("longitude", "");

			if (complaint.getLatitude() != null)
				jsonObject.addProperty("latitude", complaint.getLatitude());
			else
				jsonObject.addProperty("latitude", "");

			if (complaint.getDepartment() != null && complaint.getDepartment().getName() != null)
				jsonObject.addProperty("department", complaint.getDepartment().getName());
			else
				jsonObject.addProperty("department", "");

			if (complaint.getComments() != null)
				jsonObject.addProperty("comments", complaint.getComments());
			else
				jsonObject.addProperty("comments", "");

			jsonObject.addProperty("id", complaint.getId());
		}
		return jsonObject;
	}
}
