package org.yeyz.fourm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yeyz.fourm.dto.CommentTbDTO;
import org.yeyz.fourm.dto.LevelCommentDTO;
import org.yeyz.fourm.dto.PageCommentDTO;
import org.yeyz.fourm.dto.PageLevelCommentDTO;
import org.yeyz.fourm.dto.QuestionDTO;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.model.LevelComment;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.model.UserOracle;
import org.yeyz.fourm.service.ICommentTbService;
import org.yeyz.fourm.service.ILevelCommentService;
import org.yeyz.fourm.service.IQuestionService;
import org.yeyz.fourm.service.IUserOracleService;

@Controller
public class QuestionController{

	@Autowired
	IUserOracleService service;
	@Autowired
	IQuestionService questionService;
	@Autowired
	ICommentTbService commentService;
	@Autowired
	ILevelCommentService levelCommentService;
	
	
	@RequestMapping(value="/question",method = RequestMethod.GET)
	public String question(
			@RequestParam(value="id") Long id,
			//一级评论Id
			@RequestParam(value="parentInfoId" ,defaultValue="4343425419876941950") Long parentInfoId,
			HttpServletRequest request,
			HttpServletResponse response,
			//当前页
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			
			Map<String,Object> map) {
	
		System.out.println("访问主题帖");
		
		System.out.println(id);
		
		String parentInfoId2 = request.getParameter("parentInfoId");
		System.out.println("主回复测试Id2" + parentInfoId2);
		if( parentInfoId2 != null) {
			System.out.println("有值");
			parentInfoId = Long.parseLong(parentInfoId2);
			System.out.println("主回复Id" + parentInfoId);
			
		}
		
		
		
		Question question = questionService.queryQuestionByThemeId(id);
		synchronized (this) {
			// 累加阅读人数
			int newView_count = question.getView_count() + 1;
			// 更新数据
			questionService.updateQuestionViewById(newView_count, id);
		}
		
		map.put("question",question);
		
		UserOracle user = service.queryUserById(question.getCreator());
		map.put("user",user);
		
		/*
		 * 判断是否是登录状态, 进行
		 */
		HttpSession session = request.getSession();
		UserOracle userLog = (UserOracle)session.getAttribute("user");
		map.put("userLog",userLog);
		
		
		
		/*
		 * 显示回复
		 */
		
		Long parentId = id;
		List<UserOracle> users = service.queryUserOracle();
		// 1.总数据量
		int totalCount = commentService.queryTotalCount(parentId);
		System.out.println("回复的总数据量 : " + totalCount);
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
				if(comment.getCommentator().equals(userComm.getId())) {
					CommentTbDTO commentDTO = new CommentTbDTO(comment,userComm.getAvatar_url(),userComm.getName());
					//判断回帖的id是否重复
					
					if(!commnetIds.contains(comment.getId())) {
						commentTbDTOs.add(commentDTO);
					}
					commnetIds.add(comment.getId());
				}else if(comment.getCommentator()==1){
					CommentTbDTO commentDTO = new CommentTbDTO(comment,null,null);
					
					if(!commnetIds.contains(comment.getId())) {
						commentTbDTOs.add(commentDTO);
					}
					commnetIds.add(comment.getId());
				}
			}	
		}
		//commentTbDTOs.addAll(set);
		System.out.println(commentTbDTOs);
		PageCommentDTO pcd = new PageCommentDTO(totalCount, pageSize, currentPage, commentTbDTOs);
		if(comments != null) {
			map.put("pcd",pcd);
		}
	
		//return "redirect:/question?id="+id;
		return "question";
		
	}

	
}
