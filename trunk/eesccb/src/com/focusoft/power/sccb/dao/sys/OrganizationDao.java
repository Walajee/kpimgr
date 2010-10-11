package com.focusoft.power.sccb.dao.sys;

import java.io.Serializable;

import com.focusoft.power.sccb.dao.bean.Organization;

public interface OrganizationDao {
	public Organization getOrg(Serializable id);
}
