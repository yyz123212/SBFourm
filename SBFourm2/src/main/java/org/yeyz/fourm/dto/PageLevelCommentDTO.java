package org.yeyz.fourm.dto;

import java.util.List;

public class PageLevelCommentDTO {

	
	private List<LevelCommentDTO> levelCommentDTOS;

	
	public PageLevelCommentDTO() {
		
	}

	
	
	

	public PageLevelCommentDTO(List<LevelCommentDTO> levelCommentDTOS) {
		super();
		this.levelCommentDTOS = levelCommentDTOS;
	}





	public List<LevelCommentDTO> getLevelCommentDTOS() {
		return levelCommentDTOS;
	}


	public void setLevelCommentDTOS(List<LevelCommentDTO> levelCommentDTOS) {
		this.levelCommentDTOS = levelCommentDTOS;
	}
	
	
	
	
	




	

	
	
	
}
