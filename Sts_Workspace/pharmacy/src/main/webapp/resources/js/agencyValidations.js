(function($) {
	$.extend({
			validateAgencyDetails : function(formId) {
				var agencyForm = $('#' + formId);
				agencyForm.validate({
						rules : {
							agencyName : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							tinNumber : {
								required : true,
								number : true,
								minlength : 11,
								maxlength : 11
							},
							contactName : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							city : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							phoneNumber : {
								required : true,
								number : true,
								minlength : 10,
								maxlength : 10
							},
							address : {
								required : true
							}
						},
					messages : {
						agencyName : {
							required : 'Agency Name is required.',
							minlength : 'Agency Name should be have atleast 3 characters.',
							maxlength : 'Agency Name cannot exceed 30 characters.'
						},
						tinNumber : {
							required : 'TIN Number is required.',
							number : 'TIN Number should contain only numbers.',
							minlength : 'TIN Number should be have 11 digits.',
							maxlength : 'TIN Number cannot exceed 11 digits.'
						},
						contactName : {
							required : 'Contact Name is required.',
							minlength : 'Contact Name should be have atleast 3 characters.',
							maxlength : 'Contact Name cannot exceed 30 characters.'
						},
						city : {
							required : 'City is required.',
							minlength : 'City should be have atleast 3 characters.',
							maxlength : 'City cannot exceed 50 characters.'
						},
						phoneNumber : {
							required : 'Phone Number is required.',
							number : 'Phone Number should contain only numbers',
							minlength : 'Phone Number should contain 10 digits',
							maxlength : 'Phone Number cannot exceed 10 digits.'
						},
						address : {
							required : 'Address is required.'
						}
					},
					submitHandler: function(agencyForm){
						agencyForm.submit();
					},
					invalidHandler: function(agencyForm, validator){
						var errors = validator.numberOfInvalids();
						if (errors) {
				    		var message = errors == 1
				    		? 'You missed 1 field.'
				    		: 'You missed ' + errors + ' fields.';
				    		$("div.error span").html(message);
				    		$("div.error").show();
			    		} else {
			    		$("div.error").hide();
			    		}
					}
					});
				agencyForm.submit();
				}
			});
}(jQuery));