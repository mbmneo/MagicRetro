package com.magicretro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.magicretro.enums.ColorCode;

@Entity
@Table(name = "column", schema = "retro")
@SQLDelete(sql="UPDATE retro.column SET active_indicator = false WHERE id = ?")
@Where(clause="active_indicator = true")
public class ColumnEntity extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "column_sequence_generator")
	@SequenceGenerator(name="column_sequence_generator", sequenceName = "column_sequence", schema = "retro",allocationSize=1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name="color_cd")
	private ColorCode colorCode;
	
	@ManyToOne
	@JoinColumn(name = "board_id", nullable = false)
	private BoardEntity board;

	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
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
	
	public ColorCode getColorCode() {
		return colorCode;
	}
	
	public void setColorCode(ColorCode colorCode) {
		this.colorCode = colorCode;
	}
	
	public BoardEntity getBoard() {
		return board;
	}
	
	public void setBoard(BoardEntity board) {
		this.board = board;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		result = prime * result + ((colorCode == null) ? 0 : colorCode.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ColumnEntity other = (ColumnEntity) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		if (colorCode != other.colorCode)
			return false;
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColumnEntity [id=" + id + ", title=" + title + ", description=" + description + ", colorCode="
				+ colorCode + ", board=" + board + "]";
	}
}
