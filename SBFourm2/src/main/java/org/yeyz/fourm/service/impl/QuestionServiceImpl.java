package org.yeyz.fourm.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.yeyz.fourm.mapper.QuestionMapper;
import org.yeyz.fourm.model.Question;
import org.yeyz.fourm.service.IQuestionService;

@Component
public class QuestionServiceImpl implements IQuestionService{

	@Autowired
	QuestionMapper questionMapper;
	
	
	public QuestionMapper getQuestionMapper() {
		return questionMapper;
	}

	public void setQuestionMapper(QuestionMapper questionMapper) {
		this.questionMapper = questionMapper;
	}

	
	
	@Override
	public List<Question> queryQuestion() {
		
		return questionMapper.queryQuestion();
	}

	@Override
	@Transactional
	public void addQuestion(Question question) {
		questionMapper.addQuestion(question);
	}

	@Override
	public List<Question> queryQuestionByPage(int currentPage,int pageSize) {
		return questionMapper.queryQuestionByPage(currentPage, pageSize);
	}

	@Override
	public int queryTotalCount() {
		
		return questionMapper.queryTotalCount();
	}

	//个人页面 总数据量
	@Override
	public int queryTotalCountWithPersonal(Long userzId) {
		
		return questionMapper.queryTotalCountWithPersonal(userzId);
	}

	//个人页面 分页
	@Override
	public List<Question> queryQuestionByPageWithPersonal(int currentPage, int pageSize, Long userId) {
		
		return questionMapper.queryQuestionByPageWithPersonal(currentPage, pageSize, userId);
	}

	@Override
	public Question queryQuestionByThemeId(Long id) {
		
		return questionMapper.queryQuestionByThemeId(id);
	}

	@Override
	@Transactional
	public void updateQuestionViewById(int newView_count, Long id) {
		questionMapper.updateQuestionViewById(newView_count, id);
		
	}

	@Override
	@Transactional
	public void deleteQuestion(Long id) {
		questionMapper.deleteQuestion(id);
		
	}

	@Override
	public List<Question> queryQuestionWithSeach(String seachContent) {
		// TODO Auto-generated method stub
		return questionMapper.queryQuestionWithSeach(seachContent);
	}

	@Override
	public int queryTotalCountWithSeach(String seachContent) {
		// TODO Auto-generated method stub
		return questionMapper.queryTotalCountWithSeach(seachContent);
	}

	@Override
	public List<Question> queryQuestionSeachPage(String seachContent, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return questionMapper.queryQuestionSeachPage(seachContent, currentPage, pageSize);
	}

}
