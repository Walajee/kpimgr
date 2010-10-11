package com.focusoft.power.sccb.dao;

import java.math.BigDecimal;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;

/**
 * 带分页功能的Hibernate DAO
 */
public class PageDao extends BaseDao {

	public PageDao() {

	}

	public PageDao(final SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	/**
	 * 按sql分页查询.
	 * 
	 * @param page
	 *            分页参数.不支持其中的orderBy参数.
	 * @param sql
	 *            sql语句.
	 * @param values
	 *            数量可变的查询参数,按顺序绑定.
	 * 
	 * @return 分页查询结果, 附带结果列表及所有查询时的参数.
	 */
	public Pagination query(final Pagination page, final String sql, final Object... values) {
		return queryPage(page,sql,false,false,values);
	}

	public Pagination queryForMap(final Pagination page, final String sql, final Object... values) {
		return queryPage(page,sql,false,true,values);
	}

	public Pagination query(final Pagination page, final String sql, final Map<String, ?> values) {
		return queryPage(page,sql,false,false,values);
	}

	public Pagination queryForMap(final Pagination page, final String sql, final Map<String, ?> values) {
		return queryPage(page,sql,false,true,values);
	}
	
	
	public Pagination queryByHql(final Pagination page, final String sql, final Object... values) {
		return queryPage(page,sql,true,false,values);
	}

	public Pagination queryForMapByHql(final Pagination page, final String sql, final Object... values) {
		return queryPage(page,sql,true,true,values);
	}

	public Pagination queryByHql(final Pagination page, final String sql, final Map<String, ?> values) {
		return queryPage(page,sql,true,false,values);
	}

	public Pagination queryForMapByHql(final Pagination page, final String sql, final Map<String, ?> values) {
		return queryPage(page,sql,true,true,values);
	}
	
	
	private Pagination queryPage(final Pagination page, final String ql, boolean isHql,boolean forMap,final Object... values ) {

		Query q = isHql? createHqlQuery(ql, values):createQuery(ql, values);

		if (page.recount()) {
			int totalCount = countResult(ql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);

		if(forMap) q.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

		page.setResult(q.list());
		
		return page;
	}

	
	private Pagination queryPage(final Pagination page, final String ql,boolean isHql,boolean forMap, final Map<String, ?> values ) {

		Query q = isHql? createHqlQuery(ql, values):createQuery(ql, values);

		if (page.recount()) {
			int totalCount = countResult(ql, values);
			page.setTotalCount(totalCount);
		}

		setPageParameter(q, page);

		if(forMap) q.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);

		page.setResult(q.list());
		
		return page;
	}

	/**
	 * 执行count查询获得本次sql查询所能获得的对象总数.
	 * 
	 * 本函数只能自动处理简单的sql语句,复杂的sql查询请另行编写count语句查询.
	 */
	protected int countResult(final String sql, final Object... values) {
		// select子句与order by子句会影响count查询,进行简单的排除.
		String fromSql = "from " + StringUtils.substringAfter(sql, "from");
		fromSql = StringUtils.substringBefore(fromSql, "order by");

		String countSql = "select count(*) " + fromSql;

		try {
			Object count = queryUnique(countSql, values);
			if(count ==null)return 0;
			
			 if (count instanceof Integer) 
				 return ((Integer) count).intValue();
			 else if( count instanceof Long)
				 return ((Long) count).intValue();
			 else if( count instanceof BigDecimal)
				 return ((BigDecimal) count).intValue();
			 else
				 return Integer.parseInt(count.toString());
			 
		} catch (Exception e) {
			throw new RuntimeException("sql can't be auto count, sql is:" + countSql, e);
		}
	}

	protected int countResult(final String sql, final Map<String, ?> values) {
		// select子句与order by子句会影响count查询,进行简单的排除.
		String fromSql = "from " + StringUtils.substringAfter(sql, "from");
		fromSql = StringUtils.substringBefore(fromSql, "order by");

		String countSql = "select count(*) " + fromSql;

		try {
			Integer count = queryUnique(countSql, values);
			return count;
		} catch (Exception e) {
			throw new RuntimeException("sql can't be auto count, sql is:" + countSql, e);
		}
	}

	/**
	 * 设置分页参数到Query对象,辅助函数.
	 */
	protected Query setPageParameter(final Query q, final Pagination page) {
		// hibernate的firstResult的序号从0开始
		q.setFirstResult(page.getFirst() - 1);
		q.setMaxResults(page.getPageSize());
		return q;
	}

}