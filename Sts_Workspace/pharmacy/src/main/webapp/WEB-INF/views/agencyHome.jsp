<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/js/agencyFunctions.js" var="agencyFunctions"></spring:url>
<spring:url value="/resources/js/agencyValidations.js" var="agencyValidations"></spring:url>
<title>Agency Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/ui-lightness/jquery-ui.css">
<style type="text/css">
.span .ui-icon-closethick {
	margin-left: -7px;
	margin-top: -8px;
}

.ui-dialog .ui-state-error {
	padding: .3em;
}

.validateTips {
	border: 1px solid transparent;
	padding: 0.3em;
}

input.text {
	margin-bottom: 12px;
	width: 95%;
	padding: .4em;
}
label.error {
	margin-left: 3px;
	width:		auto;
	display:	inline-block;
	color: red;
	}
div.error {
	color : red;
}	
</style>	
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="${agencyFunctions}"></script>
<script type="text/javascript" src="${agencyValidations}"></script>
<script type="text/javascript">
$(document).ready(function(){
		$('#addAgencyButton').button();
		$.loadAllAgencies('./displayallagencies');
		$('#addAgencyButton').click(function(event) {
			console.log('Clicked');
			$.addAgencyDetails( './createagency');
		});
	});
</script>
</head>
<body>
<button id="addAgencyButton">Add Agency Item</button>

	<div id="agencies-contain" class="ui-widget" align="center">
		<table class="ui-widget ui-widget-content" border="1">
			<thead class="ui-widget-header">
				<tr>
					<td align="center">Agency Name</td>
					<td align="center">TIN</td>
					<td align="center">Contact Number</td>
					<td align="center">City</td>
					<td align="center">Phone Number</td>
					<td align="center">Address</td>
					<td align="center">Update</td>
					<td align="center">Delete</td>
				</tr>
			</thead>
			<tbody id="agencyTableBody">
			</tbody>
		</table>
	</div>
	<div id="addAgencyDiv"></div>
	<div id="updateAgencyDiv"></div>
	<div id="deleteAgencyDiv"></div>
</body>
</html>