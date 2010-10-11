package com.focusoft.power.sccb.dao.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "PPRT_APP_FLOW_HIS")
public class FlowHis {
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long hid;
	@Column
	private Long id;
	@Column(name = "ACTION_DATE")
	private Date actionDate;
	@Column
	private String user;
	@Column(name = "CURR_STAT")
	private String currStat;
	@Column(name = "NEXT_STAT")
	private String nextStat;
	@Column(name = "ACTION_RET")
	private String actionRet;
	@Column
	private String desct;
	@Column
	private String participate;

	public String getParticipate() {
		return participate;
	}

	public void setParticipate(String participate) {
		this.participate = participate;
	}

	public Long getHid() {
		return hid;
	}

	public void setHid(Long hid) {
		this.hid = hid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCurrStat() {
		return currStat;
	}

	public void setCurrStat(String currStat) {
		this.currStat = currStat;
	}

	public String getNextStat() {
		return nextStat;
	}

	public void setNextStat(String nextStat) {
		this.nextStat = nextStat;
	}

	public String getActionRet() {
		return actionRet;
	}

	public void setActionRet(String actionRet) {
		this.actionRet = actionRet;
	}

	public String getDesct() {
		return desct;
	}

	public void setDesct(String desct) {
		this.desct = desct;
	}
}
