function deleteQuestion(e) {

	console.log(5555);
	
	var id = e.getAttribute("data-id");
	console.log(id);
	
	var flag = confirm("确认删除");
	
	if(flag == false) {
		return
	}
	
	if(flag == true) {
		$.post(
				"/deleteQuestion",
				{
					"id":id,
					"flag":flag
				},
				function(data) {
					console.log(00000000000000000000000000);
					window.location.reload();
				}
		);
	}
	
	
	
}










