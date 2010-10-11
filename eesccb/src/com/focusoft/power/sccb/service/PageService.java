package com.focusoft.power.sccb.service;

public interface PageService {
	/**
	 * 获取组织HTML
	 * @param orgId
	 * @return
	 */
	public String getOrgHtml(String orgId);
	
	/**
	 * 获取分类HTML
	 * @return
	 */
	public String getStdCatHtml();

}
