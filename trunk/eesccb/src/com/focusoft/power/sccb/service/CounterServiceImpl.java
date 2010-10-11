package com.focusoft.power.sccb.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.focusoft.power.sccb.dao.sys.CounterDao;

/**
 * 通过数据库存储自增获取编码值（为减少更新操作，一定范围内存计数，会存在编码跳跃情况，单实例Bean）
 * @author ym
 *
 */
@Service("counterService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class CounterServiceImpl implements CounterService{
	//获取ID的间隔,6位长ID每增加10重新获取
	private static final Long SHORT_SPAN = 10L;
	//10位长ID每增加50重新获取
	private static final Long LONG_SPAN = 50L;
	
	private static final Long SIX_COUNTER_START = 100000L;
	private static final Long TEN_COUNTER_START = 1000000000L;
	@Autowired
	private CounterDao counterDao;
	
	private static HashMap counterMap;
	
//	public CounterDao getCounterDao() {
//		return counterDao;
//	}
//
//	public void setCounterDao(CounterDao counterDao) {
//		this.counterDao = counterDao;
//	}

	@Override
	public Long getNextLong(String counterName) {
		/*
		 * 若集合为空，重新构建
		 */
		if(counterMap == null)
		{
			counterMap = new HashMap();
		}
		
		/*
		 * 若集合为空或者集合中对应的键值为空，从数据库中查询对应ID的最高值
		 */
		if(counterMap.size() == 0 || counterMap.get(counterName + "s") == null)
		{
				Long start = counterDao.getNextLongValue(counterName);
				if(start < TEN_COUNTER_START)
				{
					return null;
				}
				Long end   = start + LONG_SPAN;
				Long retShortId = start;
				start ++;
				counterMap.put(counterName + "s", start+"");
				counterMap.put(counterName + "e", end+"");
				return retShortId;
		}
		/*
		 * 否则从内存中获取，若当前值小于最大值，直接返回，否则从数据库中重新查找
		 */
		else
		{
			Long start = Long.parseLong(counterMap.get(counterName+"s")+"");
			Long end   = Long.parseLong(counterMap.get(counterName+"e")+"");
			if(start < end)
			{
				Long nextShortId = start ;
				start ++;
				counterMap.put(counterName + "s", start+"");
				return nextShortId;
			}
			else
			{
				start = counterDao.getNextLongValue(counterName);
				end   = start + LONG_SPAN;
				Long retShortId = start;
				start ++;
				counterMap.put(counterName + "s", start+"");
				counterMap.put(counterName + "e", end+"");
				return retShortId;
			}
		}
	}

	@Override
	public Long getNextShort(String counterName) {
		/*
		 * 若集合为空，重新构建
		 */
		if(counterMap == null)
		{
			counterMap = new HashMap();
		}
		
		/*
		 * 若集合为空或者集合中对应的键值为空，从数据库中查询对应ID的最高值
		 */
		if(counterMap.size() == 0 || counterMap.get(counterName + "s") == null)
		{
				Long start = counterDao.getNextShortValue(counterName);
				if(start < SIX_COUNTER_START)
				{
					return null;
				}
				Long end   = start + SHORT_SPAN;
				Long retShortId = start;
				start ++;
				counterMap.put(counterName + "s", start+"");
				counterMap.put(counterName + "e", end+"");
				return retShortId;
		}
		/*
		 * 否则从内存中获取，若当前值小于最大值，直接返回，否则从数据库中重新查找
		 */
		else
		{
			Long start = Long.parseLong(counterMap.get(counterName+"s")+"");
			Long end   = Long.parseLong(counterMap.get(counterName+"e")+"");
			if(start < end)
			{
				Long nextShortId = start;
				start ++;
				counterMap.put(counterName + "s", start+"");
				return nextShortId;
			}
			else
			{
				//try
				//{
					start = counterDao.getNextShortValue(counterName);
				//}
				
				end   = start + SHORT_SPAN;
				Long retShortId = start;
				start ++;
				counterMap.put(counterName + "s", start+"");
				counterMap.put(counterName + "e", end+"");
				return retShortId;
			}
		}
	}
}
