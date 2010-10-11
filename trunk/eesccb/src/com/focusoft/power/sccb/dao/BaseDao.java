package com.focusoft.power.sccb.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
 

/**
 * 基于Hibnernate 的DAO

 */
public class BaseDao implements BaseDaoInf{

	@Autowired
	protected SessionFactory sessionFactory;

	public BaseDao() {
	}
 
	public BaseDao(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 取得当前Session.
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	 
	 
	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> List<X> query(final String sql, final Object... values) {
		return createQuery(sql, values).list();
	}
	
	
	public  List<Map> queryForMap(final String sql, final Object... values) {
		return createQuery(sql, values)
			.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			.list();
	}

	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> List<X> query(final String sql, final Map<String, ?> values) {
		return createQuery(sql, values).list();
	}
	
	public  List<Map> queryForMap(final String sql, final Map<String, ?> values) {
		return createQuery(sql, values)
			.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			.list();
	}

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> X queryUnique(final String sql, final Object... values) {
		return (X) createQuery(sql, values).uniqueResult();
	}

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> X queryUnique(final String sql, final Map<String, ?> values) {
		return (X) createQuery(sql, values).uniqueResult();
	}
	
	
	
	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> List<X> queryByHql(final String sql, final Object... values) {
		return createHqlQuery(sql, values).list();
	}
	
	
	public  List<Map> queryForMapByHql(final String sql, final Object... values) {
		return createHqlQuery(sql, values)
			.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			.list();
	}

	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> List<X> queryByHql(final String sql, final Map<String, ?> values) {
		return createHqlQuery(sql, values).list();
	}
	
	public  List<Map> queryForMapByHql(final String sql, final Map<String, ?> values) {
		return createHqlQuery(sql, values)
			.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP)
			.list();
	}

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> X queryUniqueByHql(final String sql, final Object... values) {
		return (X) createHqlQuery(sql, values).uniqueResult();
	}

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> X queryUniqueByHql(final String sql, final Map<String, ?> values) {
		return (X) createHqlQuery(sql, values).uniqueResult();
	}

	 

	 
	public Query createQuery(final String sql, final Object... values) {
		Query query = getSession().createSQLQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	 
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Query query = getSession().createSQLQuery(queryString);
		if (values != null) {			 
			query.setProperties(values);
		}
		return query;
	}
	
	
	public Query createHqlQuery(final String sql, final Object... values) {
		Query query = getSession().createQuery(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	 
	public Query createHqlQuery(final String queryString, final Map<String, ?> values) {
		Query query = getSession().createSQLQuery(queryString);
		if (values != null) {			 
			query.setProperties(values);
		}
		return query;
	}
	
	
	/**
	 * 保存新增或修改的对象.
	 */
	public void save(final Object entity) {
		getSession().save(entity);
	}
	
	public void update(final Object entity) {
		getSession().update(entity);
	}
	
	/**
	 * 删除对象.
	 * 
	 * @param entity 对象必须是session中的对象或含id属性的transient对象.
	 */
	public void delete(final Object entity) {
		getSession().delete(entity);
	}

	/**
	 * 按id删除对象.
	 */
	public void delete(Class cls,final Serializable id) {
		delete(get(cls,id));
	}

	/**
	 * 按id获取对象.
	 */
	public Object get(Class cls,final Serializable id) {
		return   getSession().get(cls, id);
	}
	
	
	/** 执行增删改等 SQL
	 * @param sql
	 * @param values
	 * @return
	 */
	public int execute( final String sql, final Object... values) {
		return createQuery(sql, values).executeUpdate();
	}
	
	public int execute( final String sql, final Map<String, ?> values) {
		return createQuery(sql, values).executeUpdate();
	}

	@Override
	public <X> List<X> getAll(Class clz) {
		return createHqlQuery("from " + clz.getName()).list();
	}

	 
}