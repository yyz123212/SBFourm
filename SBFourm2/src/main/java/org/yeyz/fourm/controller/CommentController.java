package org.yeyz.fourm.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeyz.fourm.dto.CommentTbDTO;
import org.yeyz.fourm.dto.PageCommentDTO;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@Controller
public class CommentController {

	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	@Autowired
	ILevelCommentService levelCommentService;
	@ResponseBody
	@RequestMapping(value="/comment",method = RequestMethod.POST)
	public Object comment(
			CommentTb commentTb,
			HttpServletRequest request,
			HttpServletResponse response,
			//当前页
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			Map<String,Object> map) {
		
		if(commentTb.getContent() == null || commentTb.getContent().equals("")) {
			map.put("commentNull","回复内容不能为空");
			return "question";
		}
	
		System.out.println("回复控制器");
		
		Long parentId = commentTb.getParentId();
		//获取回复信息id
		Random ran = new Random();
		Long temp = ran.nextLong();
			
		List<CommentTb> commentTbs = commentService.queryComment(parentId);
		List<Long> checkId = new ArrayList<Long>();
				
		for(CommentTb cs : commentTbs) {
			checkId.add(cs.getId());
		}
				
		while(checkId.contains(temp) && temp != 1) {
			temp = ran.nextLong();
		}
				
		System.out.println("回复 id : " + temp);		
		
		Long id = temp;
		
		int type = commentTb.getType();
		//判断是否登录
		UserOracle userComment = (UserOracle)request.getSession().getAttribute("user");
		Long commentator = (long) 1;
		System.out.println("回复人未变化 id : " + commentator) ;
		
		/*
		 * 登录才能执行的操作
		 */if(userComment != null) {
			 System.out.println("回复控制器 : 登录l");
			 commentator = userComment.getId();
		 }
		 System.out.println("回复人 id : " + commentator) ;
		
		String content = commentTb.getContent();
		int like_count = 0;
		
		//获取时间
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String gtm_create = sdf.format(new Date());
		
		CommentTb addComment = new CommentTb(parentId, id, type, commentator, content, like_count, gtm_create);
		System.out.println("addComment : " + addComment);
		
		
		commentService.addComment(addComment);
		map.put("userComment",userComment);
		
		
		Question question = questionService.queryQuestionByThemeId(parentId);
		//map.put("question",question);
		
		/*
		 * 显示回复
		 */
		
		List<UserOracle> users = service.queryUserOracle();
		// 1.总数据量
		int totalCount = commentService.queryTotalCount(parentId);
		// 2.每页显示多少条数据
		int pageSize = 10;
		// 3.当前页currentPage 在参数中
		// 4.总页数 totalPage 已经由构造方法计算
		
		// 获取所有评论
				List<CommentTb> comments = commentService.queryCommentByPage(currentPage, pageSize, parentId);
				List<CommentTbDTO> commentTbDTOs = new ArrayList<CommentTbDTO>();
				/*
				 * 为了处理多人登录评论的异常
				 */
				List<Long> commnetIds = new ArrayList<Long>();
				
				//无序不可重复集合
				Set<CommentTbDTO> set = new HashSet<CommentTbDTO>();
				for(CommentTb comment : comments) {
					//处理头像路径 将头像路径放入集合
					for(UserOracle userComm : users) {
						//如果id相同 则头像路径相同
						// 2个 Long 类型 不能直接 用 == 进行 比较 等于1是判断是否是游客
						if(comment.getCommentator().equals(userComm.getId()) ) {
							CommentTbDTO commentDTO = new CommentTbDTO(comment,userComm.getAvatar_url(),userComm.getName());
							//commentTbDTOs.add(commentDTO);
							if(!commnetIds.contains(comment.getId())) {
								commentTbDTOs.add(commentDTO);
							}
							commnetIds.add(comment.getId());
						}else if(comment.getCommentator()==1){
							CommentTbDTO commentDTO = new CommentTbDTO(comment,null,null);
							//commentTbDTOs.add(commentDTO);
							if(!commnetIds.contains(comment.getId())) {
								commentTbDTOs.add(commentDTO);
							}
							commnetIds.add(comment.getId());
						}
					}	
				}
				commentTbDTOs.addAll(set);
				PageCommentDTO pcd = new PageCommentDTO(totalCount, pageSize, currentPage, commentTbDTOs);
				if(comments != null) {
					map.put("pcd",pcd);
				}
		
				
				UserOracle user = service.queryUserById(question.getCreator());
				map.put("user",user);
				
		//return "redirect:/question?id=" + question.getId();
		return pcd;
	}
	
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


/*
@RequestParam(value="parentId") Long parentId, 	  // 	主贴 Id
@RequestParam(value="conten") String content,	 // 	回复内容
@RequestParam(value="type") int type,			//	 	判断是回复层级
*/