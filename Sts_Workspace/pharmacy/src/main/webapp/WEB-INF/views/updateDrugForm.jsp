<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty drug }">
<div class="error" style="display:none;" align="center"><span></span></div>    
<form:form id="updateDrugForm" action="./updatedrug" method="post"
		modelAttribute="drug">
		<form:hidden path="drugId"/>
		<table>
				<tr>
					<td><form:label path="drugName">Drug Name</form:label></td>
					<td><form:input path="drugName"/></td>
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
			</table>
	</form:form>
	</c:if>