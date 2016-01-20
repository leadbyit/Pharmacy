<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url value="/resources/js/drugFunctions.js" var="drugFunctions"></spring:url>
<spring:url value="/resources/js/drugValidations.js" var="drugValidations"></spring:url>
<title>Drug Home</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.14.0/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
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
<script type="text/javascript" src="${drugFunctions}"></script>
<script type="text/javascript" src="${drugValidations}"></script>
<script type="text/javascript">
$(document).ready(function(){
		$('#addDrugButton').button();
		$.loadAllDrugs('displayalldrugs');
		$('#addDrugButton').click(function(event) {
			$.addDrugItem( 'createdrug');
		});
	});
</script>
</head>
<body>
	<button id="addDrugButton">Add Drug Item</button>

	<div id="drugs-contain" class="ui-widget" align="center">
		<table class="ui-widget ui-widget-content" border="1">
			<thead class="ui-widget-header">
				<tr>
					<td align="center">Drug Name</td>
					<td align="center">Dosage</td>
					<td align="center">Manufacturer</td>
					<td align="center">Description</td>
					<td align="center">Price</td>
					<td align="center">Quantity</td>
					<td align="center">Drug Entry Date</td>
					<td align="center">Update</td>
					<td align="center">Delete</td>
				</tr>
			</thead>
			<tbody id="drugsTableBody">
			</tbody>
		</table>
	</div>
	<div id="addDrugItemDiv"></div>
	<div id="updateDrugItemDiv"></div>
	<div id="deleteDrugItemDiv"></div>
</body>
</html>