package com.focusoft.power.sccb.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;

public interface BaseDaoInf {
	public <X> List<X> query(final String sql, final Object... values);
	
	public <X> List<X> getAll(Class clz);
	
	
	public  List<Map> queryForMap(final String sql, final Object... values);

	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> List<X> query(final String sql, final Map<String, ?> values);
	
	public  List<Map> queryForMap(final String sql, final Map<String, ?> values) ;

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> X queryUnique(final String sql, final Object... values) ;

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> X queryUnique(final String sql, final Map<String, ?> values);
	
	
	
	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> List<X> queryByHql(final String sql, final Object... values);
	
	
	public  List<Map> queryForMapByHql(final String sql, final Object... values);

	/**
	 * 按sql查询对象列表.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> List<X> queryByHql(final String sql, final Map<String, ?> values) ;
	
	public  List<Map> queryForMapByHql(final String sql, final Map<String, ?> values);

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 数量可变的参数,按顺序绑定.
	 */
	public <X> X queryUniqueByHql(final String sql, final Object... values);

	/**
	 * 按sql查询唯一对象.
	 * 
	 * @param values 命名参数,按名称绑定.
	 */
	public <X> X queryUniqueByHql(final String sql, final Map<String, ?> values);

	public Query createQuery(final String sql, final Object... values);
	 
	public Query createQuery(final String queryString, final Map<String, ?> values);
	
	public Query createHqlQuery(final String sql, final Object... values);
	 
	public Query createHqlQuery(final String queryString, final Map<String, ?> values);
	
	/**
	 * 保存新增或修改的对象.
	 */
	public void save(final Object entity);
	
	public void update(final Object entity);
	
	/**
	 * 删除对象.
	 * 
	 * @param entity 对象必须是session中的对象或含id属性的transient对象.
	 */
	public void delete(final Object entity);
	
	/**
	 * 按id删除对象.
	 */
	public void delete(Class cls,final Serializable id);
	/**
	 * 按id获取对象.
	 */
	public Object get(Class cls,final Serializable id);
	
	/** 执行增删改等 SQL
	 * @param sql
	 * @param values
	 * @return
	 */
	public int execute( final String sql, final Object... values);
	
	public int execute( final String sql, final Map<String, ?> values);
}
