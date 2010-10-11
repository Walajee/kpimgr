package com.focusoft.power.sccb.service;

public interface CounterService {
	/**
	 * 计数器，用户
	 */
	public static final String COUNTER_USER = "counter.user";
	
	/**
	 * 计数器，标准
	 */
	public static final String COUNTER_STD = "counter.std";
	
	/**
	 * 计数器，流程
	 */
	public static final String COUNTER_FLOW = "counter.flow";
	
	/**
	 * 获取下一编号（6位）
	 * @param counterName
	 * @return
	 */
	public Long getNextShort(String counterName);
	
	/**
	 * 获取下一编号（10位）
	 * @param counterName
	 * @return
	 */
	public Long getNextLong(String counterName);
}
