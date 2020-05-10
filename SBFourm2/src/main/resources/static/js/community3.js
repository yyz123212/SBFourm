
/*
 * 层级回复控制器
 */
function levelComment(e) {
	console.log(1235456);
	var levelCommentContentId = e.getAttribute("data-id");
	console.log("节点: " + levelCommentContentId);
	
	var parentInfoId = e.getAttribute("data-id");
	var levelCommentContent = $("#input-" + levelCommentContentId).val();
	
	
	console.log(parentInfoId);
	console.log(levelCommentContent);
	
	if(!levelCommentContent) {
		alert("回复内容不能为空!");
		return;
	}
	
	$.post(
			"/levelComments",								     
			{											
				"parentInfoId":parentInfoId,
				"levelCommentContent":levelCommentContent,
				"type":2
			},
			function(response) { 							
				console.log(response);
				/*
				 * 成功则刷新页面
				 */
	      window.location.reload();
	            
			}
		);
	
}










