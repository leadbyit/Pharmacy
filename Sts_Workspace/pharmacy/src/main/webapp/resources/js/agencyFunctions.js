(function($) {
	$.extend({
				loadAllAgencies : function(url) {
					$.get(url, function(response) {
						var agencies = [];
						if (response.length > 0) {
							$.each(response, function(i, agency) {
								agencies.push("<tr>");
								agencies
										.push("<td>" + agency.agencyName
												+ "</td>");
								agencies.push("<td>" + agency.tinNumber + "</td>");
								agencies.push("<td>" + agency.contactName
										+ "</td>");
								agencies.push("<td>" + agency.city
										+ "</td>");
								agencies.push("<td>" + agency.phoneNumber + "</td>");
								agencies
										.push("<td>" + agency.address
												+ "</td>");
								agencies.push("<td>");
								agencies
										.push("<button id='updateButton-"
												+ agency.agencyId
												+ "'>Update</button>");
								agencies.push("</td>");
								agencies.push("<td>");
								agencies
										.push("<button id='deleteButton-"
												+ agency.agencyId
												+ "'>Delete</button>");
								agencies.push("</td>");
								agencies.push("</tr>");
							});
							$('#agencyTableBody').html(agencies.join(""));
							$('#agencyTableBody > tr > td').attr('align',
									'center');
							$("td > button").buttonset();
							$("td > button").buttonset();
							$.bindUpdateEvent();
							$.bindDeleteEvent();
						} else {
							$('#agencies-contain').hide();
						}
					});
				},
				addAgencyDetails : function(url) {
					console.log(url);
					$.ajax({
						url : url,
						method : 'get',
						dataType : 'html'
					}).done(function(htmlResponse) {
						$.openAgencyDialog(htmlResponse);
					});
				},
				openAgencyDialog : function(htmlResponse) {
					$('#addAgencyDiv').html(htmlResponse);
					$('#addAgencyDiv').dialog({
						title : 'Add Agency Details',
						modal : true,
						autoOpen : false,
						minWidth : 500,
						buttons : [ {
							text : ' Submit',
							click : function(evt) {
								$.validateAgencyDetails('createAgencyForm');
							}
						}, {
							text : 'Close',
							click : function(evt) {
								evt.preventDefault();
								$(this).dialog('close');
							}
						} ]
					});
					$('#addAgencyDiv').dialog('open');
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
						console.log('ID = ' + id);
						$.ajax({
							url : './updateagency/' + id,
							method : 'get',
							dataType : 'html'
						}).done(function(responseHTML) {
							$("#updateAgencyDiv").html(responseHTML);
							$('#updateAgencyDiv').dialog({
								title : 'Update Agency Details',
								modal : true,
								autoOpen : false,
								minWidth : 420,
								buttons : [ {
									text : ' Submit',
									click : function(evt) {
										evt.preventDefault();
										$.validateAgencyDetails('updateAgencyForm');
									}
								}, {
									text : 'Close',
									click : function(evt) {
										evt.preventDefault();
										$(this).dialog('close');
									}
								} ]
							});
							$('#updateAgencyDiv').dialog('open');
						});
					});
				},
				bindDeleteEvent : function() {
					$("button[id*='deleteButton']").bind('click',function() {
							var parent = $(this).parent().html();
							var id = $(parent).attr('id').split('-')[1];
							$('#deleteAgencyDiv').html('Are you sure to delete this Item? ');
							$('#deleteAgencyDiv').dialog({
								title : 'Delete Agency Details',
								modal : true,
								autoOpen : false,
								minWidth : 420,
								buttons : [
									{
									text : ' Delete',
									click : function(evt) {
											evt.preventDefault();
											$.ajax({
												url : './deleteagency/'+ id,
												method : 'get'}).done(function() {
												$('#deleteAgencyDiv').dialog('close');
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
								$('#deleteAgencyDiv').dialog('open');
						});
				}
			});
}(jQuery));