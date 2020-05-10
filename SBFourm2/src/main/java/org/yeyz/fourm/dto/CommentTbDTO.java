package org.yeyz.fourm.dto;

import org.yeyz.fourm.model.CommentTb;

public class CommentTbDTO {

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
		//头像的的图片路径
		private String avatar_url;
		
		private String userName;
		
		public CommentTbDTO() {
			
		}
		
		public CommentTbDTO(CommentTb commentTb,String avatar_url) {
			
			this.parentId = commentTb.getParentId();
			this.id = commentTb.getId();
			this.type = commentTb.getType();
			this.commentator = commentTb.getCommentator();
			this.content = commentTb.getContent();
			this.like_count = commentTb.getLike_count();
			this.gtm_create = commentTb.getGtm_create();
			this.avatar_url = avatar_url;
			
		}
		
		
		public CommentTbDTO(CommentTb commentTb,String avatar_url,String userName) {
			
			this.parentId = commentTb.getParentId();
			this.id = commentTb.getId();
			this.type = commentTb.getType();
			this.commentator = commentTb.getCommentator();
			this.content = commentTb.getContent();
			this.like_count = commentTb.getLike_count();
			this.gtm_create = commentTb.getGtm_create();
			this.avatar_url = avatar_url;
			this.userName = userName;
		}
		
		
		
		
		public CommentTbDTO(Long parentId, Long id, int type, Long commentator, String content, int like_count,
				String gtm_create, String avatar_url) {
			
			this.parentId = parentId;
			this.id = id;
			this.type = type;
			this.commentator = commentator;
			this.content = content;
			this.like_count = like_count;
			this.gtm_create = gtm_create;
			this.avatar_url = avatar_url;
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








		public String getAvatar_url() {
			return avatar_url;
		}








		public void setAvatar_url(String avatar_url) {
			this.avatar_url = avatar_url;
		}








		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		@Override
		public String toString() {
			return "CommentTbDTO [parentId=" + parentId + ", id=" + id + ", type=" + type + ", commentator="
					+ commentator + ", content=" + content + ", like_count=" + like_count + ", gtm_create=" + gtm_create
					+ ", avatar_url=" + avatar_url + "]";
		}
		
		
		
	
	
}
