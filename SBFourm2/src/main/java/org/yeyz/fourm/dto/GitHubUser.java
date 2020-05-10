package org.yeyz.fourm.dto;

public class GitHubUser {

	private String name;
	private Long id;
	//描述信息
	private String bio;
	//头像信息
	private String avatar_url;
	
	public GitHubUser() {
		
	}
	
	public GitHubUser(String name, Long id, String bio) {
		
		this.name = name;
		this.id = id;
		this.bio = bio;
	}

	
	
	
	public GitHubUser(String name, Long id, String bio, String avatar_url) {
		
		this.name = name;
		this.id = id;
		this.bio = bio;
		this.avatar_url = avatar_url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	@Override
	public String toString() {
		return "GitHubUser [name=" + name + ", id=" + id + ", bio=" + bio + ", avatar_url=" + avatar_url + "]";
	}

	
	
	
	
}
