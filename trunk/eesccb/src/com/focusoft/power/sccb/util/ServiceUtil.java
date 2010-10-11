package com.focusoft.power.sccb.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.focusoft.power.sccb.service.PageService;

/**
 * 为JSP页面通过的服务获取接口
 * @author 
 *
 */
public class ServiceUtil {
	/**
	 * 获取页面服务
	 * @param sc
	 * @return
	 */
	public static PageService getPageService(ServletContext sc)
	{
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
		return (PageService)context.getBean("pageService");
	}
}
