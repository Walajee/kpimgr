package com.focusoft.power.sccb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.focusoft.power.sccb.dao.bean.Organization;
import com.focusoft.power.sccb.dao.bean.StdCat;
import com.focusoft.power.sccb.dao.bean.StdInfo;

@Service("pageService")
public class PageServiceImpl implements PageService{
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private StdService stdService;
	
	@Override
	public String getOrgHtml(String orgId) {
		Organization o = organizationService.getOrg(Long.parseLong(orgId));
		
		if(o == null)
			return null;
		else
		{
			StringBuffer sb = new StringBuffer();
			sb.append("<ul class='tree treeFolder'>");
			getOrgDoc(sb, o);
			sb.append("</ul>");
			return sb.toString();
		}
	}
	
	private StringBuffer getOrgDoc(StringBuffer sb , Organization o)
	{
		sb.append("<li><a href='org/users/").append(o.getId()).append("' target='navTab' rel='page1'>").append(o.getName()).append("</a>");
		if(o.getChildren() != null && o.getChildren().size() > 0)
		{
			sb.append("<ul>");
			List<Organization> child = o.getChildren();
			for(Organization so: child)
			{
				getOrgDoc(sb, so);
			}
			sb.append("</ul>");
		}
		sb.append("</li>");
		return sb;
	}

	@Override
	public String getStdCatHtml() {
		StdCat sc = stdService.getRootStdCat();
		if(sc == null)
			return null;
		else
		{
			StringBuffer sb = new StringBuffer();
			sb.append("<ul class='tree treeFolder'>");
			getStdCatDoc(sb, sc);
			sb.append("</ul>");
			return sb.toString();
		}
	}
	
	private StringBuffer getStdCatDoc(StringBuffer sb ,StdCat sc)
	{
		sb.append("<li><a href='std/stdcats/").append(sc.getCatid()).append("' target='navTab' rel='page1'>").append(sc.getName()).append("</a>");
		if(sc.getChildren() != null && sc.getChildren().size() > 0)
		{
			sb.append("<ul>");
			List<StdCat> child = sc.getChildren();
			for(StdCat so: child)
			{
				getStdCatDoc(sb, so);
			}
			sb.append("</ul>");
		}
		sb.append("</li>");
		
		List<StdInfo> infoes = stdService.getStdInfoByCat(sc.getCatid());
		for(StdInfo si:infoes)
		{
			sb.append("<li><a href='std/stds/").append(si.getId()).append("' target='navTab' rel='page1'>").append(si.getName()).append("</a>");
		}
		
		return sb;
	}
}
