package com.magicretro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.magicretro.enums.BoardStageCode;

@Entity
@Table(name = "board", schema = "retro")
@SQLDelete(sql="UPDATE retro.board SET active_indicator = false WHERE id = ?")
@Where(clause="active_indicator = true")
public class BoardEntity extends BaseEntity<Long> {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_sequence_generator")
	@SequenceGenerator(name="board_sequence_generator", sequenceName = "board_sequence", schema = "retro",allocationSize=1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name="stage_cd")
	private BoardStageCode stageCode;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
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
	
	public BoardStageCode getStageCode() {
		return stageCode;
	}
	
	public void setStageCode(BoardStageCode stageCode) {
		this.stageCode = stageCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((stageCode == null) ? 0 : stageCode.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardEntity other = (BoardEntity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (stageCode != other.stageCode)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", title=" + title + ", description=" + description + ", stageCode=" + stageCode
				+ "]";
	}
	
}
