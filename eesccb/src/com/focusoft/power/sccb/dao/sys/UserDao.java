package com.focusoft.power.sccb.dao.sys;

import java.util.List;

import com.focusoft.power.sccb.dao.bean.User;

public interface UserDao{
	public List<User> getOrgUsers(Long orgId);
	
	public User getUser(Long userId);
	
	public void updateUser(User u);
	
	public void delete(Long uid);
	
	public void deleteUser(User u);
	
	public User getUserByAccount(String account);
}
