package com.focusoft.power.sccb.dao.sys;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.focusoft.power.sccb.dao.BaseDao;
import com.focusoft.power.sccb.dao.bean.Organization;

@Repository("organizationDao")
public class OrganizationDaoImpl extends BaseDao implements OrganizationDao {

	@Override
	public Organization getOrg(Serializable id) {
		return (Organization)this.get(Organization.class, id);
	}

}
