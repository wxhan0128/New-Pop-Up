$(document).ready(function() {
	// GET REQUEST
	$(".commentBt").click(function(event) {
		var message = [[${post.id}]];
		console.log(message);
		$(".commentArea").toggle();
	});
});
