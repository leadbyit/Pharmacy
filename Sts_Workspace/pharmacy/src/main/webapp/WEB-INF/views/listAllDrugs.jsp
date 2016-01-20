<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Drugs</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function(){
});
</script>
</head>
<body>
<a href="drugs/createdrug">Add a Drug Item</a>
<c:if test="${not empty drugs }">
<div id="drugs-contain" class="ui-widget">
	<table class="ui-widget ui-widget-content" border="1">
		<thead class="ui-widget-header">
			<tr>
				<td>Drug Name</td>
				<td>Dosage</td>
				<td>Manufacturer</td>
				<td>Description</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Drug Entry Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${drugs}" var="drug">
				<tr>
				<td>${drug.drugName }</td>
				<td>${drug.dosage}</td>
				<td>${drug.manufacturer}</td>
				<td>${drug.description }</td>
				<td>${drug.price}</td>
				<td>${drug.quantity}</td>
				<td>${drug.drugEntryDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</c:if>
</body>
</html>