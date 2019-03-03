package com.magicretro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "item", schema = "retro")
@SQLDelete(sql="UPDATE retro.item SET active_indicator = false WHERE id = ?")
@Where(clause="active_indicator = true")
public class ItemEntity extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence_generator")
	@SequenceGenerator(name="item_sequence_generator", sequenceName = "item_sequence", schema = "retro",allocationSize=1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="description")
	private String description;
	
	@Min(0)
	@Column(name="total_vote")
	private Integer totalVote;
	
	@ManyToOne
	@JoinColumn(name = "column_id", nullable = false)
	private ColumnEntity column;

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getTotalVote() {
		return totalVote;
	}
	
	public void setTotalVote(Integer totalVote) {
		this.totalVote = totalVote;
	}
	
	public ColumnEntity getColumn() {
		return column;
	}
	
	public void setColumn(ColumnEntity column) {
		this.column = column;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((column == null) ? 0 : column.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((totalVote == null) ? 0 : totalVote.hashCode());
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
		ItemEntity other = (ItemEntity) obj;
		if (column == null) {
			if (other.column != null)
				return false;
		} else if (!column.equals(other.column))
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
		if (totalVote == null) {
			if (other.totalVote != null)
				return false;
		} else if (!totalVote.equals(other.totalVote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemEntity [id=" + id + ", description=" + description + ", totalVote=" + totalVote + ", column="
				+ column + "]";
	}

}
