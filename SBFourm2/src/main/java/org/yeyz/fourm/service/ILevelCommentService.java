package org.yeyz.fourm.service;

import java.util.List;


import org.yeyz.fourm.model.LevelComment;

public interface ILevelCommentService {
		//插入
		public void addLevelComment(LevelComment levelComment);
		
		//查询
		public List<LevelComment> queryLevelComment(Long parentInfoId);
		
		//计算层级回复数据量
		public int queryLevelTotalCount(Long parentInfoId);
		
		//层级分页
		
		public List<LevelComment> queryLevelCommentByPage(
				int levelCurrentPage,
				int levelPageSize,
				Long parentInfoId
				);
	
		//删除
		public void deleteLevelComment(Long parentInfoId);
	
	
}
