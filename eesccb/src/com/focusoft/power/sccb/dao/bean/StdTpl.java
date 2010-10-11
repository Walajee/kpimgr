package com.focusoft.power.sccb.dao.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PPRT_STD_TPL")
public class StdTpl {
	@Id
	@GeneratedValue(generator = "stdGenerator")    
	@GenericGenerator(name = "stdGenerator", strategy = "assigned")
	private Long tplid;
	
	@Column
	private String name;
	
	@Column
	private Date deployDate;
	
	@Column
	private String creator;
	@Column
	private String url;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=StdInfo.class )
    @JoinColumn(name="id")
	private StdInfo stdInfo;
	
	public StdInfo getStdInfo() {
		return stdInfo;
	}
	public void setStdInfo(StdInfo stdInfo) {
		this.stdInfo = stdInfo;
	}
	public Long getTplid() {
		return tplid;
	}
	public void setTplid(Long tplid) {
		this.tplid = tplid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeployDate() {
		return deployDate;
	}
	public void setDeployDate(Date deployDate) {
		this.deployDate = deployDate;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
