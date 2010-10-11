package com.focusoft.power.sccb.dao.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PPRT_APP_FLOW")
public class AppFlow {
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long id;
	@Column
	private String flow;
	@Column
	private String stats;
	@Column
	private String participe;
	@Column(name = "LAST_UPDATE")
	private Date lastUpdate;
	@Column
	private String creator;
	@Column
	private String entity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public String getParticipe() {
		return participe;
	}

	public void setParticipe(String participe) {
		this.participe = participe;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
}
