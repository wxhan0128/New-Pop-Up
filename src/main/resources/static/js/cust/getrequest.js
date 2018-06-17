$(document).ready(
		function() {
			// GET REQUEST
			$("#getAllUserId").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				var userId = $("#userIdId").val();
				$.ajax({
					type : "GET",
					url : "api/v1/users/" + userId + "/posts",
					success : function(result) {
						if (result.status == "Done") {
							console.log(result.data);
							console.log("Success: ", result);
							$('#resultList').empty();
							var postList = "";
							$.each(result.data, function(i, post) {
								var post = '<div class="panel panel-default">'
										+ '<div class="panel-body">' + '<p>'
										+ post.user.username + "</p>" + '<p>'
										+ post.createTime + '</p>' + '<p>'
										+ post.content + '</p>'
										+ '<button id="test" type="button"'
										+ 'class="btn btn-primary">' + 'test'
										+ '</button>' + '</div>' + '</div>';
								$('#resultList').append(post)
							});
						} else {
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						console.log("ERROR: ", e);
					}
				});
			}
		});
