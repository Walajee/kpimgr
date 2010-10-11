package com.focusoft.power.sccb.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.focusoft.power.sccb.base.JsonResponseObj;
import com.focusoft.power.sccb.dao.bean.Role;
import com.focusoft.power.sccb.dao.bean.User;
import com.focusoft.power.sccb.service.UserService;

@Controller
public class SystemMgrController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/org/users/{id}", method=RequestMethod.POST)
	public ModelAndView main(@PathVariable Long id) {
		List users = userService.getOrgUsers(id);
		
		ModelAndView view =  new ModelAndView("orgusers", "users", users);
		
		view.addObject("orgId", id);
		return view;
	}
	
	
	
	@RequestMapping(value="/org/roles/funs/upd", method=RequestMethod.POST)
	public @ResponseBody Object updRolePmn(HttpServletRequest request,HttpServletResponse response) {
		String type = request.getParameter("type");
		
		String[] values = request.getParameterValues("funcName");
		
		String roleId = request.getParameter("roleId");
		
		try
		{
			userService.updateRolePmn(type, roleId, values);
			JsonResponseObj obj = new JsonResponseObj();
			return obj;
		}catch (Exception e)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setMessage("更新失败!");
			return obj;
		}
	}
	
	@RequestMapping(value="/org/roles/funs/{id}", method=RequestMethod.POST)
	public ModelAndView roleFuns(@PathVariable Long id) {
		List funcs = userService.getAllFunc(id);
		
		ModelAndView view =  new ModelAndView("roleFun", "funcs", funcs);
		view.addObject("roleId", id);
		
		view.addObject("orgId", id);
		return view;
	}
	
	@RequestMapping(value="/org/roles/list", method=RequestMethod.POST)
	public ModelAndView roleList() {
		List roles = userService.getRoleList();
		
		ModelAndView view =  new ModelAndView("roles", "roles", roles);
		
		return view;
	}
	
	@RequestMapping(value="/org/roles/add", method=RequestMethod.POST)
	public @ResponseBody Object addUser(HttpServletRequest request,HttpServletResponse response, Role u) {
		try
		{
			userService.saveRole(u);
			JsonResponseObj obj = new JsonResponseObj();
			return obj;
		}catch (Exception e)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setMessage("请先删除角色权限！");
			return obj;
		}
	}
	
	@RequestMapping(value="/org/roles/del/{id}", method=RequestMethod.POST)
	public @ResponseBody Object delRole(@PathVariable Long id) {
		userService.deleteRole(id);
		
		
		JsonResponseObj obj = new JsonResponseObj();
		obj.setCallbackType("forward");
		obj.setForwardUrl("org/roles/list");
		
		return obj;
	}
	
	@RequestMapping(value="/org/users/del/{id}", method=RequestMethod.POST)
	public @ResponseBody Object del(@PathVariable Long id) {
		User modUser = userService.getUser(id);
		
		userService.delete(modUser);
		
		
		JsonResponseObj obj = new JsonResponseObj();
		obj.setCallbackType("forward");
		obj.setForwardUrl("org/users/" + modUser.getOrgId());
		
		return obj;
	}
	
	@RequestMapping(value="/org/users/upd/{id}", method=RequestMethod.POST)
	public ModelAndView upd(@PathVariable Long id) {
		User u = userService.getUser(id);
		
		ModelAndView view =  new ModelAndView("user", "user", u);
		
		return view;
	}
	
	@RequestMapping(value="/org/users/supd", method=RequestMethod.POST)
	public @ResponseBody Object submitUpd(HttpServletRequest request,HttpServletResponse response, User u) {
		User modUser = userService.getUser(u.getUid());
		
		modUser.setAccount(u.getAccount());
		modUser.setEmail(u.getEmail());
		modUser.setName(u.getName());
		modUser.setPhone(u.getPhone());
		modUser.setPwd(u.getPwd());
		
		userService.updateUser(modUser);
		
		JsonResponseObj obj = new JsonResponseObj();
		
		return obj;
	}
	
	@RequestMapping(value="/org/users/add", method=RequestMethod.POST)
	public @ResponseBody Object addUser(HttpServletRequest request,HttpServletResponse response, User u) {
		User sameUser = userService.getUserByAccount(u.getAccount());
		
		if(sameUser != null)
		{
			JsonResponseObj obj = new JsonResponseObj();
			obj.setStatusCode("300");
			obj.setCallbackType("");
			obj.setMessage("用户登录名重复，请重新输入");
			//obj.setCallbackType("forward");
			//obj.setForwardUrl("org/users/"+u.getOrgId());
			
			return obj;
		}
		else
		{
			userService.save(u);
			
			JsonResponseObj obj = new JsonResponseObj();
			//obj.setCallbackType("forward");
			obj.setForwardUrl("org/users/"+u.getOrgId());
			
			return obj;
		}
	}
}
