package org.yeyz.fourm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yeyz.fourm.model.CommentTb;

public interface CommentTbMapper {

	//插入
	public void addComment(CommentTb comment);
	public void addComment2(CommentTb comment);
	
	
	//点赞
	public void updateComment(@Param("like_count")int like_count,@Param("id")Long id);
	
	//查询
	public List<CommentTb> queryComment(Long parentId);
	
	//查询单条语句
	public CommentTb queryCommentByOne(Long id);
	
	
	
	//计算总评论数
	public int queryTotalCount(Long parentId);
	//分页
	public List<CommentTb> queryCommentByPage(
			@Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize,
			@Param("parentId") Long parentId);
	
	
	
	
	
	
	//点赞
	public void updataCommentLikeCount(@Param("new_like_count")int new_like_count,@Param("id")Long id);
	
	//查询单条语句
	public CommentTb queryCommentById(Long id);
	
	//删除
	public void deleteComment(Long parentId);
	
	
}
