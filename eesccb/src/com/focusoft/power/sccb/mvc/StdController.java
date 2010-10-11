package com.focusoft.power.sccb.mvc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.focusoft.power.sccb.base.BaseRTException;
import com.focusoft.power.sccb.base.JsonResponseObj;
import com.focusoft.power.sccb.dao.bean.StdCat;
import com.focusoft.power.sccb.dao.bean.StdInfo;
import com.focusoft.power.sccb.dao.bean.StdTpl;
import com.focusoft.power.sccb.dao.bean.User;
import com.focusoft.power.sccb.service.StdService;

import java.util.Map;

@Controller
public class StdController {
	private String sp = System.getProperty("file.separator");
	
	@Autowired
	private StdService stdService;
	
	@RequestMapping(value="/std/stdcats/{id}", method=RequestMethod.POST)
	public ModelAndView main(@PathVariable Long id) {
		List stds = stdService.getStdInfoByCat(id);
		
		StdCat cat = stdService.getStdCat(id);
		
		ModelAndView view =  new ModelAndView("stdcat", "stds", stds);
		
		view.addObject("catId", id);
		view.addObject("stdCat", cat);
		
		return view;
	}
	
	@RequestMapping(value="/std/stds/{id}", method=RequestMethod.POST)
	public ModelAndView viewStd(@PathVariable Long id) {
		StdInfo std = stdService.getStdInfo(id);
		
		ModelAndView view =  new ModelAndView("stdview", "std", std);
		
		return view;
	}
	
	@RequestMapping(value="/std/stds/add", method=RequestMethod.POST)
	public @ResponseBody Object addStd(HttpServletRequest request,HttpServletResponse response, StdInfo sc) {
		StdCat parent = stdService.getStdCat(sc.getCatid());
		sc.setStatus(StdInfo.STD_STAT_NEW);
		stdService.saveStdInfo(sc);
		
		JsonResponseObj obj = new JsonResponseObj();
		return obj;
	}
	
	@RequestMapping(value="/std/stds/upd/{id}", method=RequestMethod.POST)
	public ModelAndView updStd(@PathVariable Long id) {
		StdInfo std = stdService.getStdInfo(id);
		
		ModelAndView view =  new ModelAndView("stdupd", "std", std);
		
		return view;
	}
	
	
	@RequestMapping(value="/std/stds/tpl/del/{id}", method=RequestMethod.POST)
	public @ResponseBody Object delStdTpl(HttpServletRequest request,HttpServletResponse response,@PathVariable Long id) {
		try
		{
			StdTpl st = stdService.getStdTpl(id);
			stdService.deleteTplEntity(st);
			deleteTplFile(request.getSession().getServletContext().getRealPath("upload")+sp+st.getUrl());
			//TODO delete the file
			JsonResponseObj obj = new JsonResponseObj();
			obj.setMessage("操作成功，请刷新");
			
			return obj;
		}
		catch (Exception e)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setMessage("删除模板文件有误！");
			
			return obj;
		}
	}
	
	private void deleteTplFile(String filePath)
	{
		File f = new File(filePath);
		if(f.exists())
		{
			f.delete();
		}
	}
	
	@RequestMapping(value="/std/stds/tpl/upload", method=RequestMethod.POST)
	public String updateTpl(HttpServletRequest request,HttpServletResponse response ,
	        @RequestParam("stdId") Long stdId ) {
		String stdid = request.getParameter("stdId");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		
		Map<String, MultipartFile> files = multipartRequest.getFileMap();
		
		String path = request.getSession().getServletContext().getRealPath("upload");
		
		StdInfo  info = stdService.getStdInfo(stdId);
		for (Iterator it = multipartRequest.getFileNames(); it.hasNext();) {
			String key = (String)it.next();
			MultipartFile file = multipartRequest.getFile(key);
			
			try {
				if(file.getBytes().length > 0)
				{
					String filePath = saveUploadFile(file, path, stdId);
					
					StdTpl tpl = new StdTpl();
					tpl.setDeployDate(new Date());
					tpl.setName(file.getOriginalFilename());
					tpl.setUrl(filePath);
					
					tpl.setStdInfo(info);
					
					stdService.saveStdTpl(tpl);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:../../../../app/stand";
	}
	
	/**
	 * 存储上传文件，返回存储路径
	 */
	private synchronized String saveUploadFile(MultipartFile file,String path, Long stdId)
	{
		String absPath = stdId + sp + file.getOriginalFilename();
		String fullPath = path + sp + absPath;
		
		String dirPath = path + sp + stdId;
		
		File saveTo = new File(dirPath);
		
		if(!saveTo.exists())
		{
			saveTo.mkdirs();
		}
		
		try {
			FileCopyUtils.copy(file.getBytes(),new File(fullPath));
			return absPath;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BaseRTException("500", "文件读写错误！");
		}
	}
	
	
	@RequestMapping(value="/std/stds/upds", method=RequestMethod.POST)
	public @ResponseBody Object submitUpd(HttpServletRequest request,HttpServletResponse response, StdInfo si) {
		StdInfo usi = stdService.getStdInfo(si.getId());
		
		usi.setName(si.getName());
		usi.setProp(si.getProp());
		usi.setUnit(si.getUnit());
		usi.setMean(si.getMean());
		usi.setValue(si.getValue());
		usi.setDesct(si.getDesct());
		
		stdService.updateStdInfo(usi);
		
		JsonResponseObj obj = new JsonResponseObj();
		
		return obj;
	}
	
	@RequestMapping(value="/std/stds/del/{id}", method=RequestMethod.POST)
	public @ResponseBody Object delStd(@PathVariable Long id) {
		try
		{
			stdService.deleteStdInfo(id);
			JsonResponseObj obj = new JsonResponseObj();
			obj.setMessage("操作成功，请刷新");
			
			return obj;
		}
		catch (Exception e)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setMessage("请先删除标准模板文件信息！");
			
			return obj;
		}
	}
	
	@RequestMapping(value="/std/stdcats/del/{id}", method=RequestMethod.POST)
	public @ResponseBody Object del(@PathVariable Long id) {
		try
		{
			stdService.deleteCat(id);
			JsonResponseObj obj = new JsonResponseObj();
			obj.setMessage("操作成功，请刷新");
			
			return obj;
		}
		catch (Exception e)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setMessage("请先删除下级分类或者标准信息！");
			
			return obj;
		}
	}
	
	@RequestMapping(value="/std/stdcats/catd", method=RequestMethod.POST)
	public @ResponseBody Object submitUpd(HttpServletRequest request,HttpServletResponse response, StdCat sc) {
		StdCat usc = stdService.getStdCat(sc.getCatid());
		
		usc.setName(sc.getName());
		usc.setDesct(sc.getDesct());
		
		stdService.updateStdCat(usc);
		
		JsonResponseObj obj = new JsonResponseObj();
		
		return obj;
	}
	
	@RequestMapping(value="std/stdcats/add", method=RequestMethod.POST)
	public @ResponseBody Object addCat(HttpServletRequest request,HttpServletResponse response, StdCat sc) {
		StdCat parent = stdService.getStdCat(sc.getCatid());
		
		sc.setParent(parent);
		
		stdService.saveStdCat(sc);
		
		JsonResponseObj obj = new JsonResponseObj();
		return obj;
	}
}
