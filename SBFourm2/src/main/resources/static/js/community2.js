/*
 *层级回复折叠
 */
function collapseComments(e) {
	var id = e.getAttribute("data-id");
	
	
	/*
	 * 获取节点
	 */
	var comments = $("#comment-" + id);
	/*
	 * 增加 class属性
	 * 展开二级评论
	 */
	
	/*
	 * 获取二级评论展开状态
	 * 进行折叠与展开
	 */
	var collapse = e.getAttribute("data-collapse");
	if(collapse) {
		comments.removeClass("in");
		e.removeAttribute("data-collapse");
	}else {
		
		
		
		var parentInfoId = id;
		var questionId = $("#question_Id").val();
		
		var subCommentContainer = $("#comment-" + id);
		console.log(subCommentContainer);
		console.log(subCommentContainer.children());
		console.log(subCommentContainer.children().length);
		 if(subCommentContainer.children().length < 7 || subCommentContainer.children().length > 8) {
			 comments.addClass("in");
			e.setAttribute("data-collapse","in");
		 }else {
			 $.post(
						"/levQuestion",								      
						{	"id":questionId,
							"parentInfoId":parentInfoId
							
						},	 						
						function(data) { 								
						
							/*
							 * 有数据返回则追加标签
							 */
							
							
							
							 
							 
							 $.each(data,function(levelCommentDTOS,plcd) {
								
								
								 console.log(data);
								 
								 console.log(plcd);
								 console.log(levelCommentDTOS);
								 
								 	console.log(7777777777777);	
								 	
								 	
								 	
								 	
								 	
								 	var i = 0;
								 	var img = 0;
								 	var user = 0;
								 	for(i = 0 ;i<plcd.length;i++ ) {
								 		if(plcd[i].avatar_url != null) {
								 			 img = $("<div/>",{
												"class":"media-left"
											}).append($("<img/>",{
												"class":"media-object",
												"style":"width:38px ; height:38px",
												"src":plcd[i].avatar_url
											}));
										   
									 		//subCommentContainer.prepend(img);
								 		}else {
								 			 img = $("<div/>",{
												"class":"media-left"
											}).append($("<img/>",{
												"class":"media-object",
												"style":"width:38px ; height:38px",
												"src":"https://avatars1.githubusercontent.com/u/64524595?v=4"
											}));
										   
									 		//subCommentContainer.prepend(img);
								 		}
								 		
								 		if(plcd[i].userName != null) {
								 			user = $("<span/>",{
												"class":"media-heading userIsLog",
												"html":plcd[i].userName
											});
								 		}else {
								 			user = $("<span/>",{
												"class":"media-heading userIsLog",
												"html":"游客"
											});
								 		}
								 		
								 		img.append(user);
								 							 		
								 		var c = $("<div/>",{
											"class":"col-lg-12 col-md-12 col-sm-12 col-xs-12 levelComments",
											 "html":plcd[i].levelCommentContent
										});
									   
								 		
								 		subCommentContainer.prepend(c);
								 		
								 		subCommentContainer.prepend(img);
								 	
								 	
								 	
								 	
								 	}
								 	
								
									 
								 
							  
							  });
							

						
							/*
							 * 
							 */
							comments.addClass("in");
							e.setAttribute("data-collapse","in");
				            
							
							//成功则刷新页面
							// window.location.reload();
						}
					);
		 }
		
		
		
		
		
		
		
		/*
		 * 标记评论展开状态
		 */
		
	}
	
	
	
}




