package com.magicretro.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author MBENMOHA
 * */
@MappedSuperclass
public abstract class BaseEntity<Id> {
	
	@Column(name = "active_indicator")
	private Boolean activeIndicator;

	@Column(name = "update_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	public abstract void setId(Id id);
	
	public abstract Id getId();
	
	public Boolean getActiveIndicator() {
		return activeIndicator;
	}

	public void setActiveIndicator(Boolean activeIndicator) {
		this.activeIndicator = activeIndicator;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@PrePersist
	private void onCreate() {
		this.setActiveIndicator(true);
		this.setUpdateDate(new Date());
	}
	
	@PreUpdate
	private void onUpdate() {
		this.setUpdateDate(new Date());
	}
}