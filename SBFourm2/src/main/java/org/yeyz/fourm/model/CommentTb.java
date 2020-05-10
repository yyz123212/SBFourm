package org.yeyz.fourm.model;




public class CommentTb {

	// 主贴Id ,用来指向主贴
	private Long parentId;
	// 回复信息Id
	private Long id;
	// 区分一级回复和二级回复
	private int type;
	// 评论人Id
	private Long commentator;
	// 回复的内容
	private String content;
	// 点赞数
	private int like_count;
	// 回复的时间
	private String gtm_create;
	
	
	
	
	public CommentTb() {
		
	}



	
	public CommentTb(Long parentId, Long id, int type, Long commentator, String content, int like_count,
			String gtm_create) {
		this.parentId = parentId;
		this.id = id;
		this.type = type;
		this.commentator = commentator;
		this.content = content;
		this.like_count = like_count;
		this.gtm_create = gtm_create;
	}




	public Long getParentId() {
		return parentId;
	}




	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public int getType() {
		return type;
	}




	public void setType(int type) {
		this.type = type;
	}




	public Long getCommentator() {
		return commentator;
	}




	public void setCommentator(Long commentator) {
		this.commentator = commentator;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public int getLike_count() {
		return like_count;
	}




	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}




	public String getGtm_create() {
		return gtm_create;
	}




	public void setGtm_create(String gtm_create) {
		this.gtm_create = gtm_create;
	}




	@Override
	public String toString() {
		return "CommentTb [parentId=" + parentId + ", id=" + id + ", type=" + type + ", commentator=" + commentator
				+ ", content=" + content + ", like_count=" + like_count + ", gtm_create=" + gtm_create + "]";
	}
	
	
	
	
	
	
	
	
}
