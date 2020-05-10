package org.yeyz.fourm.dto;

import java.util.List;

import org.yeyz.fourm.model.Question;


public class PageDTO {
	
	// 1.总数据量
	private int totalCount;

	// 2.每页显示多少条数据
	private int pageSize;

	// 3.当前页
	private int currentPage;

	// 4.总页数
	private int totalPage;

	// 当前页数据集合questions
	private List<QuestionDTO> questionDTOS;

	public PageDTO() {
		
	}
	
	
	public PageDTO(int totalCount, int pageSize, int currentPage, List<QuestionDTO> questionDTOS) {
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		setTotalPage(totalCount, pageSize);
		this.questionDTOS = questionDTOS;
	}





	public PageDTO(int totalCount, int pageSize, int currentPage, int totalPage, List<QuestionDTO> questionDTOS) {
		
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.questionDTOS = questionDTOS;
	}





/***************************************************************************/
	
	
	
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	// 通过totalCount和pageSize进行计算,不需要进行赋值
		public void setTotalPage(int totalCount,int pageSize) {
			if(totalCount % this.pageSize == 0) {
				this.totalPage =  this.totalCount / this.pageSize;
			}else {
				this.totalPage =  (this.totalCount / this.pageSize) + 1;
			}
			
			
		}

	public List<QuestionDTO> getQuestionDTOS() {
		return questionDTOS;
	}

	public void setQuestionDTOS(List<QuestionDTO> questionDTOS) {
		this.questionDTOS = questionDTOS;
	}


	@Override
	public String toString() {
		return "PageDTO [totalCount=" + totalCount + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", totalPage=" + totalPage + ", questionDTOS=" + questionDTOS + "]";
	}
	
	
	




	


	
}