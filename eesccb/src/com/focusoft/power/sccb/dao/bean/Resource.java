package com.focusoft.power.sccb.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PPRT_PT_SYS_RESOURCE")
public class Resource {
	/**
	 * 资源类型-功能
	 */
	public final static String RES_TYPE_FUNC = "func";
	
	/**
	 * 资源类型-标准
	 */
	public final static String RES_TYPE_STD = "std";
	
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long resid;
	@Column
	private String type;
	@Column
	private String entity;
	@Column
	private String name;
	@Transient
	private boolean hasPmn;
	
	public boolean isHasPmn() {
		return hasPmn;
	}

	public void setHasPmn(boolean hasPmn) {
		this.hasPmn = hasPmn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getResid() {
		return resid;
	}

	public void setResid(Long resid) {
		this.resid = resid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}
}
