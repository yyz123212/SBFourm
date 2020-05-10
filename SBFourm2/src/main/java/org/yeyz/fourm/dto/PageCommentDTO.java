package org.yeyz.fourm.dto;

import java.util.List;

public class PageCommentDTO {

		// 1.总数据量
		private int totalCount;

		// 2.每页显示多少条数据
		private int pageSize;

		// 3.当前页
		private int currentPage;

		// 4.总页数
		private int totalPage;
		
		// 当前页数据集合CommentTbDTO
		private List<CommentTbDTO> commentTbDTOs;
		
		
		
		public PageCommentDTO() {
			
		}
		
		public PageCommentDTO(int totalCount, int pageSize, int currentPage,List<CommentTbDTO> commentTbDTOs) {
			
			this.totalCount = totalCount;
			this.pageSize = pageSize;
			this.currentPage = currentPage;
			setTotalPage(totalCount, pageSize);
			this.commentTbDTOs = commentTbDTOs;
		}
		
		
		
		public PageCommentDTO(int totalCount, int pageSize, int currentPage, int totalPage,
				List<CommentTbDTO> commentTbDTOs) {
			
			this.totalCount = totalCount;
			this.pageSize = pageSize;
			this.currentPage = currentPage;
			this.totalPage = totalPage;
			this.commentTbDTOs = commentTbDTOs;
		}

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

			public List<CommentTbDTO> getCommentTbDTOs() {
				return commentTbDTOs;
			}

			public void setCommentTbDTOs(List<CommentTbDTO> commentTbDTOs) {
				this.commentTbDTOs = commentTbDTOs;
			}
		
	
}
