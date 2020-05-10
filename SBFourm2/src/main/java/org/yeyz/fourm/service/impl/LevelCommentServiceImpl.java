package org.yeyz.fourm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yeyz.fourm.mapper.LevelCommentMapper;
import org.yeyz.fourm.model.LevelComment;
import org.yeyz.fourm.service.ILevelCommentService;

@Service
public class LevelCommentServiceImpl implements ILevelCommentService{

	@Autowired
	LevelCommentMapper levelMapper;
	
	
	
	public LevelCommentMapper getLevelMapper() {
		return levelMapper;
	}

	public void setLevelMapper(LevelCommentMapper levelMapper) {
		this.levelMapper = levelMapper;
	}

	@Override
	@Transactional
	public void addLevelComment(LevelComment levelComment) {
		
		levelMapper.addLevelComment(levelComment);
	}

	@Override
	public List<LevelComment> queryLevelComment(Long parentInfoId) {
		
		return levelMapper.queryLevelComment(parentInfoId);
	}

	@Override
	public int queryLevelTotalCount(Long parentInfoId) {
		
		return levelMapper.queryLevelTotalCount(parentInfoId);
	}

	@Override
	public List<LevelComment> queryLevelCommentByPage(int levelCurrentPage, int levelPageSize, Long parentInfoId) {
		
		return levelMapper.queryLevelCommentByPage(levelCurrentPage, levelPageSize, parentInfoId);
	}

	@Override
	@Transactional
	public void deleteLevelComment(Long parentInfoId) {
		
		levelMapper.deleteLevelComment(parentInfoId);
	}

	

}
