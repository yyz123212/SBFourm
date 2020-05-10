function lickCount(e) {
	console.log(111111111);
	//var ElementId = e.getAttribute("data-id");
	//console.log(ElementId);
	
	//var id = $("#likeCount-" + ElementId).val();
	var id = e.getAttribute("data-id");
	console.log(id);
	
	$.post(
			"/likeCount",
			{
				"id":id
			},
			function(data) {
				console.log(00000000000000000000000000);
				window.location.reload();
			}
	);
	
}










