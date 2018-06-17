$(document).ready(function() {
	// SUBMIT FORM
	$("#postForm").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});

	function ajaxPost() {
		// PREPARE FORM DATA
		var userId = $("#userIdId").val();
		var formData = {
			content : $("#contentId").val()
		};

		// DO POST
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "api/v1/users/" + userId + "/posts",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if (result.status == "Done") {
					console.log(result.data);
					console.log("Success: ", result);
				} else {
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});

		resetData();
	}

	function resetData() {
		$("#contentId").val("");
	}
});