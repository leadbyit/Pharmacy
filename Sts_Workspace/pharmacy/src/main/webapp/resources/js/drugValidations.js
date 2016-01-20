(function($) {
	$.extend({
			validateDrugInsert : function(formId) {
				var drugForm = $('#' + formId);
				drugForm.validate({
						rules : {
							drugName : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							dosage : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							manufacturer : {
								required : true,
								minlength : 3,
								maxlength : 30
							},
							description : {
								required : true,
								minlength : 3,
								maxlength : 50
							},
							price : {
								required : true,
								number : true
							},
							quantity : {
								required : true,
								number : true
							},
							drugEntryDate : {
								required : true,
								date : true
							}
						},
					messages : {
						drugName : {
							required : 'Drug Name is required.',
							minlength : 'Drug Name should be have atleast 3 characters.',
							maxlength : 'Drug Name cannot exceed 30 characters.'
						},
						dosage : {
							required : 'Dosage is required.',
							minlength : 'Dosage should be have atleast 3 characters.',
							maxlength : 'Dosage cannot exceed 30 characters.'
						},
						manufacturer : {
							required : 'Manufacturer is required.',
							minlength : 'Manufacturer should be have atleast 3 characters.',
							maxlength : 'Manufacturer cannot exceed 30 characters.'
						},
						description : {
							required : 'Description is required.',
							minlength : 'Description should be have atleast 3 characters.',
							maxlength : 'Description cannot exceed 50 characters.'
						},
						price : {
							required : 'Price is required.',
							number : 'Price should contain only numbers'
						},
						quantity : {
							required : 'Quantity is required.',
							number : 'Quantity should contain only numbers.'
						},
						drugEntryDate : {
							required : ' Drug Entry Date is required.',
						}
					},
					submitHandler: function(drugForm){
						drugForm.submit();
					},
					invalidHandler: function(drugForm, validator){
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
				drugForm.submit();
				}
			});
}(jQuery));