package com.focusoft.power.sccb.dao.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PPRT_PT_SYS_USER")
public class User {
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private Long uid;
	@Column(name = "name")
	private String name;
	@Column
	private String account;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String stats;
	@Column
	private Date crtTime;
	@Column
	private String pwd;
	@Column(name = "id")
	private Long orgId;
	
	@ManyToMany(
		targetEntity = Role.class,
		cascade = {CascadeType.PERSIST, CascadeType.MERGE}
	)
	@JoinTable(
			name = "PPRT_RT_SYS_USERROLE",
			joinColumns = {@JoinColumn(name = "UID")},
			inverseJoinColumns = {@JoinColumn(name = "ID")}
	)
	private List<Role> roles;
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
}
