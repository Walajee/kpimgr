package com.focusoft.power.sccb.service;

import java.util.List;

import com.focusoft.power.sccb.dao.bean.Resource;
import com.focusoft.power.sccb.dao.bean.Role;
import com.focusoft.power.sccb.dao.bean.User;

public interface UserService {
	public List<User> getOrgUsers(Long orgId);
	
	public User getUser(Long userId);
	
	public void updateUser(User u);
	
	public void save(User u);
	
	public void delete(Long uid);
	
	public void delete(User u);
	
	public User getUserByAccount(String account);
	
	public List<Role> getRoleList();
	
	public void deleteRole(Long roleId);
	
	public void saveRole(Role r);
	
	public List<Resource> getAllFunc(Long roleId);
	
	public void updateRolePmn(String type, String roleId, String[] resids);
}
