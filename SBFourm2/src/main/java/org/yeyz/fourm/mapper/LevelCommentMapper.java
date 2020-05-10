package org.yeyz.fourm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yeyz.fourm.model.LevelComment;

public interface LevelCommentMapper {

	//插入
	public void addLevelComment(LevelComment levelComment);
	
	//查询
	public List<LevelComment> queryLevelComment(Long parentInfoId);
	
	//计算层级回复数据量
	public int queryLevelTotalCount(Long parentInfoId);
	
	//层级分页
	
	public List<LevelComment> queryLevelCommentByPage(
			@Param("levelCurrentPage")int levelCurrentPage,
			@Param("levelPageSize")int levelPageSize,
			@Param("parentInfoId") Long parentInfoId
			);
	
	//删除
	public void deleteLevelComment(Long parentInfoId);
	
	
	
}
