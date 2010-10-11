package com.focusoft.power.sccb.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.focusoft.power.sccb.dao.bean.Organization;
import com.focusoft.power.sccb.dao.sys.OrganizationDao;

@Service("organizationService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class OrganizationServiceImpl implements OrganizationService{
	@Autowired
	private OrganizationDao organizationDao;

	@Override
	public Organization getOrg(Serializable id) {
		return organizationDao.getOrg(id);
	}
	
	
}
