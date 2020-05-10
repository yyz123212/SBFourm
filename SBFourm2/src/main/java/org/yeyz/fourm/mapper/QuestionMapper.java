package org.yeyz.fourm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.yeyz.fourm.model.Question;

public interface QuestionMapper {

	public List<Question> queryQuestion();
	//插入
	public void addQuestion(Question question);
	
	//分页
	public List<Question> queryQuestionByPage(@Param("currentPage")int currentPage,@Param("pageSize")int pageSize);
	
	//计算总数据量
	public int queryTotalCount();
	
	//个人页面 总数据量
	public int queryTotalCountWithPersonal(Long userzId);
	
	//个人页面 分页
	public List<Question> queryQuestionByPageWithPersonal(
			@Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize,
			@Param("userId") Long userId
			);
	//获取主题帖信息
	public Question queryQuestionByThemeId(Long id);
	//更新数据--阅读数
	public void updateQuestionViewById(@Param("newView_count") int newView_count,@Param("id") Long id);
	
	
	//删除
	public void deleteQuestion(Long id);
	
	//搜索 模糊查询
	public List<Question> queryQuestionWithSeach(String seachContent);
	
	
	//搜索 计算总数据量
	public int queryTotalCountWithSeach(String seachContent);
	
	
	//分页搜索
	public List<Question> queryQuestionSeachPage(
			@Param("seachContent")String seachContent,
			@Param("currentPage")int currentPage,
			@Param("pageSize")int pageSize
			);
	
	
}

	