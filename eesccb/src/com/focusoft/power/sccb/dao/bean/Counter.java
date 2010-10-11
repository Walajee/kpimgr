package com.focusoft.power.sccb.dao.bean;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "pprt_base_counter")
public class Counter {
	@Id
	@GeneratedValue(generator = "counterGenerator")    
	@GenericGenerator(name = "counterGenerator", strategy = "assigned")
	private String code;
	
	@Column
	private Long value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
