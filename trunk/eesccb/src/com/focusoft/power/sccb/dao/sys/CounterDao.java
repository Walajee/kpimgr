package com.focusoft.power.sccb.dao.sys;

public interface CounterDao {
	/**
	 * 获取10位长唯一编码
	 * @param counterName
	 * @return
	 */
	public Long getNextLongValue(String counterName);
	
	/**
	 * 获取6位长唯一编码
	 * @param counterName
	 * @return
	 */
	public Long getNextShortValue(String counterName);
}
