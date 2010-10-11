package com.focusoft.power.sccb.service;

public interface FlowService {
	/**
	 * 创建新的流程
	 * @param flowType          流程类型
	 * @param creator             创建人
	 * @param participate       参与人【流程下一步处理人】
	 * @param entity            流程关联实体
	 */
	public void saveStartFlow(String flowType, String creator, String participate, String entity);
	
	
}
