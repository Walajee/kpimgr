package com.focusoft.power.sccb.dao.sys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.focusoft.power.sccb.base.BaseRTException;
import com.focusoft.power.sccb.dao.BaseDao;
import com.focusoft.power.sccb.dao.bean.Counter;

@Repository("counterDao")
public class CounterDaoImpl extends BaseDao implements CounterDao{
	//获取ID的间隔,6位长ID每增加10重新获取
	private static final Long SHORT_SPAN = 10L;
	//10位长ID每增加50重新获取
	private static final Long LONG_SPAN = 50L;
	
	private static final Long SIX_COUNTER_START = 100000L;
	private static final Long TEN_COUNTER_START = 1000000000L;
	
	//private SessionFactory sessionFactory;
	  
	//public void setSessionFactory(SessionFactory sessionFactory) {  
	//	this.sessionFactory = sessionFactory;  
	//}
	
	@Override
	public Long getNextLongValue(String counterName) {
		Session session = null ;
		try
		{
			session = this.getSession();
			
			Object o = session.get(Counter.class, counterName);
			//计数器不存在，创建新的
			Long current = 1000000000L;
			//Transaction t = session.beginTransaction();
			if(o == null)
			{
				Long max = current + LONG_SPAN;
				Counter counter = new Counter();
				counter.setCode(counterName);
				counter.setValue(max);
				session.save(counter);
			}
			else
			{
				Counter c = (Counter)o;
				Long max = c.getValue() + LONG_SPAN;
				c.setValue(max);
				current = max;
				session.update(c);
			}
			//t.commit();
			return current;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BaseRTException(e.getMessage(), "数据库操作异常");
		}
		
	}

	@Override
	public Long getNextShortValue(String counterName) {
		Session session = null ;
		try
		{
			session = sessionFactory.openSession();
			Object o = session.get(Counter.class, counterName);
			//计数器不存在，创建新的
			Long current = 100000L;
			//Transaction t = session.beginTransaction();
			if(o == null)
			{
				Long max = current + SHORT_SPAN;
				Counter counter = new Counter();
				counter.setCode(counterName);
				counter.setValue(max);
				session.save(counter);
			}
			else
			{
				Counter c = (Counter)o;
				Long max = c.getValue() + SHORT_SPAN;
				c.setValue(max);
				current = max;
				session.update(c);
			}
			//t.commit();
			return current;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new BaseRTException(e.getMessage(), "数据库操作异常");
		}
		
	}
}
