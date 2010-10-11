package com.focusoft.power.sccb.service;

import java.io.Serializable;

import com.focusoft.power.sccb.dao.bean.Organization;

public interface OrganizationService {
	public Organization getOrg(Serializable id);
}
