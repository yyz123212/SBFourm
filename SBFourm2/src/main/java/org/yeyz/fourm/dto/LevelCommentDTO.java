package org.yeyz.fourm.dto;

import org.yeyz.fourm.model.LevelComment;

public class LevelCommentDTO {

	private Long parentInfoId;
	// 层级回复信息Id
	private Long levelId;
	// 区分一级回复和二级回复
	private int type;
	// 评论人Id
	private Long levelCommentator;
	// 层级回复具体内容
	private String levelCommentContent;
	// 点赞数
	private int like_count;
	// 回复的时间
	private String gtm_create;
	
	//头像的的图片路径
	private String avatar_url;
			
	private String userName;

	
	public LevelCommentDTO() {
		
	}
	
	
	
	
	public LevelCommentDTO(LevelComment levelComment,String avatar_url, String userName) {
		
		this.parentInfoId = levelComment.getParentInfoId();
		this.levelId = levelComment.getLevelId();
		this.type = levelComment.getType();
		this.levelCommentator = levelComment.getLevelCommentator();
		this.levelCommentContent = levelComment.getLevelCommentContent();
		this.like_count = levelComment.getLike_count();
		this.gtm_create = levelComment.getGtm_create();
		
		this.avatar_url = avatar_url;
		this.userName = userName;
	}
















	public LevelCommentDTO(Long parentInfoId, Long levelId, int type, Long levelCommentator, String levelCommentContent,
			int like_count, String gtm_create, String avatar_url, String userName) {
		this.parentInfoId = parentInfoId;
		this.levelId = levelId;
		this.type = type;
		this.levelCommentator = levelCommentator;
		this.levelCommentContent = levelCommentContent;
		this.like_count = like_count;
		this.gtm_create = gtm_create;
		this.avatar_url = avatar_url;
		this.userName = userName;
	}



















	public Long getParentInfoId() {
		return parentInfoId;
	}



















	public void setParentInfoId(Long parentInfoId) {
		this.parentInfoId = parentInfoId;
	}



















	public Long getLevelId() {
		return levelId;
	}



















	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}



















	public int getType() {
		return type;
	}



















	public void setType(int type) {
		this.type = type;
	}



















	public Long getLevelCommentator() {
		return levelCommentator;
	}



















	public void setLevelCommentator(Long levelCommentator) {
		this.levelCommentator = levelCommentator;
	}



















	public String getLevelCommentContent() {
		return levelCommentContent;
	}



















	public void setLevelCommentContent(String levelCommentContent) {
		this.levelCommentContent = levelCommentContent;
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
		return "LevelCommentDTO [parentInfoId=" + parentInfoId + ", levelId=" + levelId + ", type=" + type
				+ ", levelCommentator=" + levelCommentator + ", levelCommentContent=" + levelCommentContent
				+ ", like_count=" + like_count + ", gtm_create=" + gtm_create + ", avatar_url=" + avatar_url
				+ ", userName=" + userName + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
