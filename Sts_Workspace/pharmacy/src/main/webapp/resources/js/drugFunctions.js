(function($) {
	$.extend({
				loadAllDrugs : function(url) {
					$.get(url, function(response) {
						var drugs = [];
						if (response.length > 0) {
							$.each(response, function(i, drugItem) {
								drugs.push("<tr>");
								drugs
										.push("<td>" + drugItem.drugName
												+ "</td>");
								drugs.push("<td>" + drugItem.dosage + "</td>");
								drugs.push("<td>" + drugItem.manufacturer
										+ "</td>");
								drugs.push("<td>" + drugItem.description
										+ "</td>");
								drugs.push("<td>" + drugItem.price + "</td>");
								drugs
										.push("<td>" + drugItem.quantity
												+ "</td>");
								drugs.push("<td>" + drugItem.drugEntryDate
										+ "</td>");
								drugs.push("<td>");
								drugs
										.push("<button id='updateButton-"
												+ drugItem.drugId
												+ "'>Update</button>");
								drugs.push("</td>");
								drugs.push("<td>");
								drugs
										.push("<button id='deleteButton-"
												+ drugItem.drugId
												+ "'>Delete</button>");
								drugs.push("</td>");
								drugs.push("</tr>");
							});
							$('#drugsTableBody').html(drugs.join(""));
							$('#drugsTableBody > tr > td').attr('align',
									'center');
							$.bindUpdateEvent();
							$.bindDeleteEvent();
						} else {
							$('#drugs-contain').hide();
						}
					});
				},
				addDrugItem : function(url) {
					$.ajax({
						url : url,
						method : 'get',
						dataType : 'html'
					}).done(function(htmlResponse) {
						$.openDrugItemDialog(htmlResponse);
					});
				},
				openDrugItemDialog : function(htmlResponse) {
					$('#addDrugItemDiv').html(htmlResponse);
					$('#drugEntryDate').datepicker({
						changeMonth : true,
						changeYear : true,
						dateFormat : "yy-mm-dd",
						maxDate : new Date(),
						minDate : "-5y",
						constrainInput : true
					});
					$('#addDrugItemDiv').dialog({
						title : 'Add Drug Item',
						modal : true,
						autoOpen : false,
						minWidth : 420,
						buttons : [ {
							text : ' Submit',
							click : function(evt) {
								$.validateDrugInsert('createDrugForm');
							}
						}, {
							text : 'Close',
							click : function(evt) {
								evt.preventDefault();
								// allFields.val( "" ).removeClass(
								// "ui-state-error" );
								$(this).dialog('close');
							}
						} ]
					});
					$('#addDrugItemDiv').dialog('open');
				},
				updateTips : function(t) {
					tips.text(t).addClass('ui-state-highlight');
					setTimeout(function() {
						tips.removeClass("ui-state-highlight", 1500);
					}, 500);
				},
				bindUpdateEvent : function() {
					$("button[id*='updateButton']").bind('click', function() {
						var parent = $(this).parent().html();
						var id = $(parent).attr('id').split('-')[1];
						$.ajax({
							url : './updatedrug/' + id,
							method : 'get',
							dataType : 'html'
						}).done(function(responseHTML) {
							$("#updateDrugItemDiv").html(responseHTML);
							$('#drugEntryDate').datepicker({
								changeMonth : true,
								changeYear : true,
								dateFormat : "yy-mm-dd",
								maxDate : new Date(),
								minDate : "-5y",
								constrainInput : true
							});
							$('#updateDrugItemDiv').dialog({
								title : 'Update Drug Item',
								modal : true,
								autoOpen : false,
								minWidth : 420,
								buttons : [ {
									text : ' Submit',
									click : function(evt) {
										evt.preventDefault();
										$.validateDrugInsert('updateDrugForm');
									}
								}, {
									text : 'Close',
									click : function(evt) {
										evt.preventDefault();
										$(this).dialog('close');
									}
								} ]
							});
							$('#updateDrugItemDiv').dialog('open');
						});
					});
				},
				bindDeleteEvent : function() {
					$("button[id*='deleteButton']").bind('click',function() {
							var parent = $(this).parent().html();
							var id = $(parent).attr('id').split('-')[1];
							$('#deleteDrugItemDiv').html('Are you sure to delete this Item? ');
							$('#deleteDrugItemDiv').dialog({
								title : 'Delete Drug Item',
								modal : true,
								autoOpen : false,
								minWidth : 420,
								buttons : [
									{
									text : ' Delete',
									click : function(evt) {
											evt.preventDefault();
											$.ajax({
												url : './deletedrug/'+ id,
												method : 'get'}).done(function() {
												$('#deleteDrugItemDiv').dialog('close');
															});
													}
									},
									{
										text : 'Close',
										click : function(evt) {
												evt.preventDefault();
												$(this).dialog('close');
															}
									} ]});
								$('#deleteDrugItemDiv').dialog('open');
						});
				}
			});
}(jQuery));