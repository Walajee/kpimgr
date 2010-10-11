package com.focusoft.power.sccb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focusoft.power.sccb.dao.bean.Resource;
import com.focusoft.power.sccb.dao.bean.Role;
import com.focusoft.power.sccb.dao.bean.User;
import com.focusoft.power.sccb.dao.sys.RoleDao;
import com.focusoft.power.sccb.dao.sys.UserDao;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CounterService counterService;
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<User> getOrgUsers(Long orgId) {
		return userDao.getOrgUsers(orgId);
	}

	@Override
	public User getUser(Long userId) {
		return userDao.getUser(userId);
	}

	@Override
	public void updateUser(User u) {
		userDao.updateUser(u);
	}

	@Override
	public void save(User u) {
		u.setUid(counterService.getNextLong(CounterService.COUNTER_USER));
		userDao.updateUser(u);
	}

	@Override
	public void delete(Long uid) {
		userDao.delete(uid);
	}

	@Override
	public void delete(User u) {
		userDao.deleteUser(u);
	}

	@Override
	public User getUserByAccount(String account) {
		return userDao.getUserByAccount(account);
	}

	@Override
	public List<Role> getRoleList() {
		return roleDao.getAll(Role.class);
	}

	@Override
	public void deleteRole(Long roleId) {
		roleDao.delete(Role.class, roleId);
	}

	@Override
	public void saveRole(Role r) {
		r.setId(counterService.getNextLong(CounterService.COUNTER_USER));
		r.setType("1");
		
		roleDao.save(r);
	}
	
	/**
	 * 获取角色某类型权限
	 * @param roleId
	 * @param entityType
	 * @return
	 */
	private List<String> getRolePmns(Long roleId, String entityType)
	{
		String sql = "select res.resid from PPRT_PT_SYS_ROLERES rr inner join PPRT_PT_SYS_RESOURCE res on rr.resid=res.resid where rr.id=? and res.type=?";
		
		return roleDao.query(sql, roleId, entityType);
	}

	private List<Resource> getDefFuns(String resType) {
		String hql = "from Resource r where r.type=?";
		
		return roleDao.createHqlQuery(hql, resType).list();
	}

	private boolean contain(String obj, List ele)
	{
		if(ele == null || ele.size() <= 0)
			return false;
		else
		{
			for(Object o: ele)
			{
				if(o.toString().equals(obj))
					return true;
			}
			return false;
		}
	}
	
	@Override
	public List<Resource> getAllFunc(Long roleId) {
		List<Resource> reses = getDefFuns(Resource.RES_TYPE_FUNC);
		
		List<String> rolePmns = (List<String>)getRolePmns(roleId, Resource.RES_TYPE_FUNC);
		
		for(Resource f:reses)
		{
			if(contain(f.getResid().toString(), rolePmns))
			{
				f.setHasPmn(true);
			}
		}
		return reses;
	}

	@Override
	public void updateRolePmn(String type, String roleId, String[] resids) {
		String sql = "delete from PPRT_PT_SYS_ROLERES  where type=?";
		roleDao.execute(sql, type);
		
		if(resids != null && resids.length > 0)
		{
			for(String resId:resids)
			{
				sql = "insert into PPRT_PT_SYS_ROLERES values(?, ?, ?)";
				roleDao.execute(sql, resId, roleId, type);
			}
		}
	}
}
