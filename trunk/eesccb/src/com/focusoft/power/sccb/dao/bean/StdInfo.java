package com.focusoft.power.sccb.dao.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//标准
@Entity
@Table(name = "PPRT_STD_INFO")
public class StdInfo {
	/**
	 * 标准为新标准
	 */
	public final static String STD_STAT_NEW = "n";
	/**
	 * 标准为新正式标准
	 */
	public final static String STD_STAT_EFFECT = "e";
	/**
	 * 标准过时
	 */
	public final static String STD_STAT_OUT  = "o";
	
	@Id
	@GeneratedValue(generator = "stdInfoGenerator")    
	@GenericGenerator(name = "stdInfoGenerator", strategy = "assigned")
	private Long id;
	
	@Column
	private String name;
	@Column
	private String prop;
	@Column
	private String unit;
	@Column
	private String mean;
	@Column
	private String value;
	@Column
	private String desct;
	@Column
	private String creator;
	@Column(name = "CREATE_DATE" )
	private Date createDate;
	@Column(name = "UPD_DATE" )
	private Date updDate;
	@Column
	private String status;
	@Column
	private Long catid;

	@OneToMany(mappedBy="stdInfo")
	private List<StdTpl> tpls;
	
	public List<StdTpl> getTpls() {
		return tpls;
	}
	public void setTpls(List<StdTpl> tpls) {
		this.tpls = tpls;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesct() {
		return desct;
	}
	public void setDesct(String desct) {
		this.desct = desct;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdDate() {
		return updDate;
	}
	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}