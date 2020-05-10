function questionComment() {
	
	var questionId = $("#question_Id").val();
	
	var content =$("#comment_content").val();
	
	
	if(!content) {
		alert("回复内容不能为空!");
		return;
	}
	
	
	$.post(
			"/comment",								      // url
			{											 // json格式数据
				"parentId":questionId,
				"content":content,
				"type":1
			},	 						
			function(response) { 							// 回调函数	
				console.log(response);
				//成功则刷新页面
	      window.location.reload();
	            
			}
		);
}












