package org.yeyz.fourm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yeyz.fourm.mapper.CommentTbMapper;
import org.yeyz.fourm.model.CommentTb;
import org.yeyz.fourm.service.ICommentTbService;

@Service
public class CommentTbServiceImpl implements ICommentTbService{
	
	@Autowired
	CommentTbMapper commentMapper;
	
	
	
public CommentTbMapper getCommentMapper() {
		return commentMapper;
	}

	public void setCommentMapper(CommentTbMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

/********************************************************************/
	@Override
	public int queryTotalCount(Long parentId) {
		
		return commentMapper.queryTotalCount(parentId);
	}

	@Override
	public List<CommentTb> queryCommentByPage(int currentPage, int pageSize, Long parentId) {
		// TODO Auto-generated method stub
		return commentMapper.queryCommentByPage(currentPage, pageSize, parentId);
	}

	@Override
	@Transactional
	public void addComment(CommentTb comment) {
		commentMapper.addComment(comment);
		
	}

	@Override
	public List<CommentTb> queryComment(Long parentId) {
		// TODO Auto-generated method stub
		return commentMapper.queryComment(parentId);
	}

	@Override
	@Transactional
	public void addComment2(CommentTb comment) {
		commentMapper.addComment2(comment);
		
	}

	@Override
	@Transactional
	public void updateComment(int like_count, Long id) {
		commentMapper.updateComment(like_count, id);
		
	}

	@Override
	public CommentTb queryCommentByOne(Long id) {
		
		return commentMapper.queryCommentByOne(id);
	}

	@Override
	@Transactional
	public void updataCommentLikeCount(int new_like_count, Long id) {
		// TODO Auto-generated method stub
		commentMapper.updataCommentLikeCount(new_like_count, id);
		
	}

	@Override
	public CommentTb queryCommentById(Long id) {
		// TODO Auto-generated method stub
		return commentMapper.queryCommentById(id);
	}

	@Override
	@Transactional
	public void deleteComment(Long parentId) {
		
		commentMapper.deleteComment(parentId);
	}

	
	
}
