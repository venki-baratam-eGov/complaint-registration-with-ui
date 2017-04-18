<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form method="post">
	<table width="100%">
		<tr>
			<td width="100%" align="right"><a href="/monolith"><H1>Home</H1></a>
				</br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><b>View Complaint registration</b></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td>Contact Information</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Name:</b></td>
			<td>${complaint.complainant.name}</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Mobile Number:</b></td>
			<td>${complaint.complainant.mobile}</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Email:</b></td>
			<td>${complaint.complainant.email}</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>


		<tr>
			<td>Grievance Information</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Complaint Type:</b></td>
			<td>${complaint.complaintType.name}</td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td><b>Complaint Status:</b></td>
			<td>${complaint.status.name}</td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td><b>Department:</b></td>
			<td>${complaint.department.name}</td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Complaint details:</b></td>
			<td>${ complaint.details }</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td><b>Location:</b></td>
			<td>${ complaint.location.name }</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td><b>Landmark (if any):</b></td>
			<td>${ complaint.landmarkDetails }</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td><b>Comments:</b></td>
			<td>${ complaint.comments }</td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td colspan="3" align="center"><button type="button"
					onclick="javascript:window.close()">Close</button></td>
		</tr>
	</table>
</form:form>
