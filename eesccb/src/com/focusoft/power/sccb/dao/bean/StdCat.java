package com.focusoft.power.sccb.dao.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

//标准分类
@Entity
@Table(name = "PPRT_STD_CAT")
public class StdCat {
	
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long catid;
	
	@Column
	private String name;
	
	@Column
	private String desct;
	
	@OneToMany(mappedBy="parent")
	private List<StdCat> children;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=StdCat.class )
    @JoinColumn(name="PARENT")
	private StdCat parent;
	
	public StdCat getParent() {
		return parent;
	}

	public void setParent(StdCat parent) {
		this.parent = parent;
	}

	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesct() {
		return desct;
	}

	public void setDesct(String desct) {
		this.desct = desct;
	}

	public List<StdCat> getChildren() {
		return children;
	}

	public void setChildren(List<StdCat> children) {
		this.children = children;
	}
}
