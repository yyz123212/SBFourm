package org.yeyz.fourm.model;

public class UserOracle {

	private String name ;
	private Long id ;
	// bio 描述信息
	private String bio ;
	// 长度不会变化
	private String token ;
	// 记录创建时间 number(20,0)用于代替 mysql中的 BigInt gtm代表格林威治时间
	private String gtm_create ;
	// 记录修改时间
	private String gtm_modified ;
	//头像的的图片路径
	private String avatar_url;
	
	public UserOracle() {
		
	}

	
	
	public UserOracle(String name, Long id, String bio, String token, String gtm_create, String gtm_modified,
			String avatar_url) {
		super();
		this.name = name;
		this.id = id;
		this.bio = bio;
		this.token = token;
		this.gtm_create = gtm_create;
		this.gtm_modified = gtm_modified;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
		return "UserOracle [name=" + name + ", id=" + id + ", bio=" + bio + ", token=" + token + ", gtm_create="
				+ gtm_create + ", gtm_modified=" + gtm_modified + ", avatar_url=" + avatar_url + "]";
	}

	
	
	
	
	
	
}
