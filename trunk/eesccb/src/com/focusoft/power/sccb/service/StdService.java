package com.focusoft.power.sccb.service;

import java.util.List;

import com.focusoft.power.sccb.dao.bean.StdCat;
import com.focusoft.power.sccb.dao.bean.StdInfo;
import com.focusoft.power.sccb.dao.bean.StdTpl;

public interface StdService {
	/**
	 * 获取标准分类根节点
	 * @return
	 */
	public StdCat getRootStdCat();
	
	/**
	 * 添加分类
	 * @param parent
	 * @param child
	 */
	public void saveStdCat(StdCat child);
	
	/**
	 * 删除分类
	 * @param catId
	 */
	public void deleteCat(Long catId);
	
	/**
	 * 根据分类获取
	 * @param catId
	 * @return
	 */
	public List<StdInfo> getStdInfoByCat(Long catId);
	
	/**
	 * 
	 * @param catId
	 * @return
	 */
	public StdCat getStdCat(Long catId);
	
	/**
	 * 
	 * @param sc
	 */
	public void updateStdCat(StdCat sc);
	
	/**
	 * 
	 * @param si
	 */
	public void saveStdInfo(StdInfo si);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public StdInfo getStdInfo(Long id);
	
	/**
	 * 删除标准
	 * @param id
	 */
	public void deleteStdInfo(Long id);
	
	/**
	 * 
	 * @param si
	 */
	public void updateStdInfo(StdInfo si);
	
	/**
	 * 
	 * @param st
	 */
	public void saveStdTpl(StdTpl st);
	
	/**
	 * 
	 * @param tplId
	 */
	public void deleteTpl(Long tplId);
	
	/**
	 * 
	 * @param st
	 */
	public void deleteTplEntity(StdTpl st);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public StdTpl getStdTpl(Long id);
}
