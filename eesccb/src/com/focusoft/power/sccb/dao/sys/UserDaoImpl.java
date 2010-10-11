package com.focusoft.power.sccb.dao.sys;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.focusoft.power.sccb.dao.PageDao;
import com.focusoft.power.sccb.dao.bean.User;

@Repository("userDao")
public class UserDaoImpl extends PageDao implements UserDao{

	@Override
	public List<User> getOrgUsers(Long orgId) {
		String hql = "from User u where u.orgId=?";
		return this.queryByHql(hql, orgId);
	}

	@Override
	public User getUser(Long id) {
		return (User)this.get(User.class, id);
	}

	@Override
	public void updateUser(User u) {
		this.update(u);
	}

	@Override
	public void delete(Long uid) {
		this.delete(User.class, uid);
	}

	@Override
	public void deleteUser(User u) {
		this.delete(u);
	}

	@Override
	public User getUserByAccount(String account) {
		String hql = "from User u where u.account=?";
		List l = this.queryByHql(hql, account);
		if(l == null || l.size() <=0)
			return null;
		else
			return (User)l.get(0);
	}
}
