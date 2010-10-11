package com.focusoft.power.sccb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focusoft.power.sccb.dao.bean.StdCat;
import com.focusoft.power.sccb.dao.bean.StdInfo;
import com.focusoft.power.sccb.dao.bean.StdTpl;
import com.focusoft.power.sccb.dao.sys.StdCatDao;
import com.focusoft.power.sccb.dao.sys.StdInfoDao;
import com.focusoft.power.sccb.dao.sys.StdTplDao;

@Service("stdService")
public class StdServiceImpl implements StdService{
	@Autowired
	private StdCatDao stdCatDao;
	@Autowired
	private StdInfoDao stdInfoDao;
	@Autowired
	private StdTplDao stdTplDao;
	
	@Autowired
	private CounterService counterService;
	
	@Override
	public void saveStdCat(StdCat child) {
		child.setCatid(counterService.getNextLong(CounterService.COUNTER_STD));
		stdCatDao.save(child);
	}

	@Override
	public void deleteCat(Long catId) {
		stdCatDao.delete(StdCat.class, catId);
	}

	@Override
	public StdCat getRootStdCat() {
		String hql = "from StdCat sc where sc.parent is null";
		List l = stdCatDao.queryByHql(hql);
		
		if(l == null || l.size() <=0)
			return null;
		else
			return (StdCat)l.get(0);
	}
	
	public List<StdInfo> getStdInfoByCat(Long catId)
	{
		String hql = "from StdInfo info where info.catid =?";
		
		List l = stdCatDao.queryByHql(hql, catId);
		
		return l;
	}

	@Override
	public StdCat getStdCat(Long catId) {
		return (StdCat)stdCatDao.get(StdCat.class, catId);
	}

	@Override
	public void updateStdCat(StdCat sc) {
		stdCatDao.update(sc);
	}

	@Override
	public void saveStdInfo(StdInfo si) {
		si.setId(counterService.getNextLong(CounterService.COUNTER_STD));
		stdCatDao.save(si);
	}

	@Override
	public StdInfo getStdInfo(Long id) {
		return (StdInfo)stdInfoDao.get(StdInfo.class, id);
	}

	@Override
	public void deleteStdInfo(Long id) {
		stdInfoDao.delete(StdInfo.class, id);
	}

	@Override
	public void updateStdInfo(StdInfo si) {
		stdInfoDao.update(si);
	}

	@Override
	public void saveStdTpl(StdTpl st) {
		st.setTplid(counterService.getNextLong(CounterService.COUNTER_STD));
		stdTplDao.save(st);
	}

	@Override
	public void deleteTpl(Long tplId) {
		stdTplDao.delete(StdTpl.class, tplId);
	}

	@Override
	public void deleteTplEntity(StdTpl st) {
		stdTplDao.delete(st);
	}

	@Override
	public StdTpl getStdTpl(Long id) {
		return (StdTpl)stdTplDao.get(StdTpl.class, id);
	}
}
