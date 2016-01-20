<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save a Drug Item</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#drugEntryDate').datepicker({
			changeMonth : true,
			changeYear : true,
			dateFormat : "yy-mm-dd",
			maxDate : new Date(),
			minDate : "-5y",
			constrainInput : true
		});
		$('#createDrugItem').submit(function(event) {
			var drugName = $('#drugName').val();
			var dosage = $('#dosage').val();
			var mfg = $('#manufacturer').val();
			var descr = $('#description').val();
			var price = $('#price').val();
			var quantity = $('quantity').val();
			var entryDate = $('#drugEntryDate').val();

			var json = {
				"drugName" : drugName,
				"dosage" : dosage,
				"manufacturer" : mfg,
				"description" : descr,
				"price" : price,
				"quantity" : quantity,
				"drugEntryDate" : entryDate
			};

		});

	});
</script>
</head>
<body>
	<div align="center">
		<h1>Save a Drug</h1>
		<form:form id="createDrugItem" action="insertdrug" method="post"
			modelAttribute="drug">
			<table>
				<form:hidden path="drugId" />
				<tr>
					<td><form:label path="drugName">Drug Name</form:label></td>
					<td><form:input path="drugName" /></td>
				</tr>
				<tr>
					<td><form:label path="dosage">Dosage</form:label></td>
					<td><form:input path="dosage" /></td>
				</tr>
				<tr>
					<td><form:label path="manufacturer">Manufacturer</form:label></td>
					<td><form:input path="manufacturer" /></td>
				</tr>
				<tr>
					<td><form:label path="description">Description</form:label></td>
					<td><form:input path="description" /></td>
				</tr>
				<tr>
					<td><form:label path="price">Price</form:label></td>
					<td><form:input path="price" /></td>
				</tr>
				<tr>
					<td><form:label path="quantity">Quantity</form:label></td>
					<td><form:input path="quantity" /></td>
				</tr>
				<tr>
					<td><form:label path="drugEntryDate">Entry Date</form:label></td>
					<td><form:input path="drugEntryDate" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>