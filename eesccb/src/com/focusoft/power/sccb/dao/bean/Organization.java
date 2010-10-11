package com.focusoft.power.sccb.dao.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PPRT_PT_SYS_ORG")
public class Organization {
	
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long id;
	
	@Column
	private String code;
	
	@Column
	private String lev;
	
	private String name;
	
	@Column
	private String creator;
	
	@Column
	private String type;
	
	private String stats;
	
	@Column
	private String desct;
	
	@Column(name = "crt_date" )
	private Date crtDate;
	
	@Column(name = "upd_date" )
	private Date updDate;
    
    @OneToMany
    @JoinTable(
    name = "PPRT_PT_SYS_ORGREL",
    joinColumns = {@JoinColumn(name = "PRTORG_ID")},
    inverseJoinColumns = @JoinColumn(name = "ORG_ID")
    ) 
	private List<Organization> children;
    
//    private Organization parent;
//    
//    public Organization getParent() {
//		return parent;
//	}
//
//	public void setParent(Organization parent) {
//		this.parent = parent;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLev() {
		return lev;
	}

	public void setLev(String lev) {
		this.lev = lev;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStats() {
		return stats;
	}

	public void setStatus(String stats) {
		this.stats = stats;
	}

	public String getDesct() {
		return desct;
	}

	public void setDesct(String desct) {
		this.desct = desct;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public List<Organization> getChildren() {
		return children;
	}

	public void setChildren(List<Organization> children) {
		this.children = children;
	}
}
