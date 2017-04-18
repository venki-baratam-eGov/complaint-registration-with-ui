<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form method="post" action="../update">

	<table width="100%">
		<tr>
			<td width="100%" align="right"><a href="/monolith"><H1>Home</H1></a>
				</br></td>
		</tr>
	</table>

	<table>
		<tr>
			<td><b>Update Complaint registration</b></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<form:hidden path="id" id="id" value="${id}" />
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
			<td>Complaint Status *</td>

			<td><select name="status" id="status" required="required">
					<option value="">Select</option>
					<c:forEach items="${complaintStatus}" var="status">

						<option value="${status.id} ">${status.name}</option>

					</c:forEach>
			</select></td>

		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td></td>
			<td>Comments *</td>
			<td><form:textarea path="comments" id="comments" minlength="10"
					maxlength="500" cssClass="form-control autogrow"
					required="required" /></td>
		</tr>

		<tr>
			<td colspan="3"></td>
		</tr>

		<tr>
			<td colspan="3" align="center"><input type="submit"
				value="Update" /></td>
		</tr>
	</table>
</form:form>
<script type="text/javascript">
	function onSubmit() {
		if (document.getElementById("complaint").value) {
			document.forms[0].action = "/monolith/complaint/update"
					+ document.getElementById("complaint").value;
			document.forms[0].submit();
		} else
			alert("Please select complaint");
	}
</script>