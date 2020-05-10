package org.yeyz.fourm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yeyz.fourm.model.CommentTb;

public interface ICommentTbService {

	//插入
	public void addComment(CommentTb comment);
	public void addComment2(CommentTb comment);
	//查询
	public List<CommentTb> queryComment(Long parentId);
	//查询单条语句
	public CommentTb queryCommentByOne(Long id);
	//点赞
	public void updateComment(int like_count,Long id);
	
	//计算总评论数
	public int queryTotalCount(Long parentId);
	//分页
	public List<CommentTb> queryCommentByPage(
			int currentPage,
			int pageSize,
			Long parentId);
	
	
	
	
		//点赞
		public void updataCommentLikeCount(int new_like_count,Long id);
		
		//查询单条语句
		public CommentTb queryCommentById(Long id);
	
		//删除
		public void deleteComment(Long parentId);
	
	
	
}
