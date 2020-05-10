package org.yeyz.fourm.dto;

import org.yeyz.fourm.model.Question;

public class QuestionDTO {
	//帖子id
	private Long id;
	
	private String title;
	//具体内容
	private String description;
	//创建人id
	private Long creator;
	//评论人数
	private int comment_count;
	//阅读数
	private int view_count;
	//点赞数
	private int like_count;
	//标签,以后用于搜索
	private String tag;
	//记录创建时间 number(20,0)用于代替 mysql中的 BigInt gtm代表格林威治时间
	private String gtm_create;
	//记录修改时间
	private String gtm_modified;
	//头像的的图片路径
	private String avatar_url;
	
	
	
	public QuestionDTO() {
		
	}
	
	public QuestionDTO(Question question,String avatar_url) {
		this.id = question.getId();
		this.title = question.getTitle();
		this.description = question.getDescription();
		this.creator = question.getCreator();
		this.comment_count = question.getComment_count();
		this.view_count = question.getView_count();
		this.like_count = question.getLike_count();
		this.tag = question.getTag();
		this.gtm_create = question.getGtm_create();
		this.gtm_modified = question.getGtm_create();
		this.avatar_url = avatar_url;
	}
	
	
	
	

	public QuestionDTO(String title, String description, Long creator, int comment_count, int view_count, int like_count,
			String tag, String gtm_create, String gtm_modified, String avatar_url) {
		
		this.title = title;
		this.description = description;
		this.creator = creator;
		this.comment_count = comment_count;
		this.view_count = view_count;
		this.like_count = like_count;
		this.tag = tag;
		this.gtm_create = gtm_create;
		this.gtm_modified = gtm_modified;
		this.avatar_url = avatar_url;
	}

	
	public QuestionDTO(Long id, String title, String description, Long creator, int comment_count, int view_count,
			int like_count, String tag, String gtm_create, String gtm_modified, String avatar_url) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.creator = creator;
		this.comment_count = comment_count;
		this.view_count = view_count;
		this.like_count = like_count;
		this.tag = tag;
		this.gtm_create = gtm_create;
		this.gtm_modified = gtm_modified;
		this.avatar_url = avatar_url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}

	public int getView_count() {
		return view_count;
	}

	public void setView_count(int view_count) {
		this.view_count = view_count;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getGtm_create() {
		return gtm_create;
	}

	public void setGtm_create(String gtm_create) {
		this.gtm_create = gtm_create;
	}

	public String getGtm_modified() {
		return gtm_modified;
	}

	public void setGtm_modified(String gtm_modified) {
		this.gtm_modified = gtm_modified;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	@Override
	public String toString() {
		return "QuestionDTO [title=" + title + ", description=" + description + ", creator=" + creator
				+ ", comment_count=" + comment_count + ", view_count=" + view_count + ", like_count=" + like_count
				+ ", tag=" + tag + ", gtm_create=" + gtm_create + ", gtm_modified=" + gtm_modified + ", avatar_url="
				+ avatar_url + "]";
	}
	
	
	
	
	
}
