<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form method="post" action="create">
	<table width="100%">
		<tr>
			<td width="100%" align="right"><a href="/monolith"><H1>Home</H1></a> </br></td>
		</tr>
	</table>
	<table>
		<tr>
			<td><b>Complaint registration</b></td>
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
			<td>Name *</td>
			<td><form:input path="complainant.name" required="required" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td>Mobile Number *</td>
			<td><form:input path="complainant.mobile" required="required"
					maxlength="10" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td>Email</td>
			<td><form:input path="complainant.email" /></td>
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
			<td>Complaint Type *</td>
			<td><form:select path="complaintType" id="complaintType"
					cssClass="form-control" cssErrorClass="form-control error"
					required="required">
					<form:option value="">
					Select
				</form:option>
					<form:options items="${complaintTypes}" itemValue="id"
						itemLabel="name" />
				</form:select></td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>


		<tr>
			<td></td>
			<td>Department *</td>
			<td><form:select path="department" id="department"
					cssClass="form-control" cssErrorClass="form-control error"
					required="required">
					<form:option value="">
					Select
				</form:option>
					<form:options items="${department}" itemValue="id" itemLabel="name" />
				</form:select></td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td>Complaint details *</td>
			<td><form:textarea path="details" id="doc"
					placeholder="Give more details about the complaint to help us solve your issue"
					minlength="10" maxlength="500" cssClass="form-control autogrow"
					required="required" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td>Latitude *</td>
			<td><form:input path="latitude" required="required" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td></td>
			<td>Longitude *</td>
			<td><form:input path="longitude" required="required" /></td>
		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td>Landmark (if any)</td>
			<td><form:textarea path="landmarkDetails" id="landmarkDetails"
					minlength="10" maxlength="500" cssClass="form-control autogrow" /></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td colspan="3" align="center"><input type="submit" value="Register" /></td>
		</tr>
	</table>
</form:form>
