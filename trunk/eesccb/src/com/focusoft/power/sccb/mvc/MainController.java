package com.focusoft.power.sccb.mvc;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.focusoft.power.sccb.dao.bean.Organization;
import com.focusoft.power.sccb.dao.bean.User;
import com.focusoft.power.sccb.dao.sys.UserDao;
import com.focusoft.power.sccb.service.CounterService;
import com.focusoft.power.sccb.service.OrganizationService;

@Controller
public class MainController {
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/main")
	public ModelAndView main() {
		Long getId = counterService.getNextLong("count1");
		
		//Organization o = organizationService.getOrg(0L);
		//o.getChildren().size();
		
		ModelAndView view =  new ModelAndView("main", "message", "");
		view.addObject("select", "sys");
		return view;
	}
	
	@RequestMapping("/daily")
	public ModelAndView daily() {
		Long getId = counterService.getNextLong("count1");
		
		ModelAndView view =  new ModelAndView("daily", "message", "");
		view.addObject("select", "daily");
		return view;
	}
	
	@RequestMapping("/mark")
	public ModelAndView mark() {
		Long getId = counterService.getNextLong("count1");
		
		ModelAndView view =  new ModelAndView("mark", "message", "");
		view.addObject("select", "mark");
		return view;
	}
	
	@RequestMapping("/stand")
	public ModelAndView stand() {
		Long getId = counterService.getNextLong("count1");
		
		ModelAndView view =  new ModelAndView("stand", "message", "");
		view.addObject("select", "stand");
		return view;
	}
	
	@RequestMapping("/sys")
	public ModelAndView sys() {
		Long getId = counterService.getNextLong("count1");
		
		ModelAndView view =  new ModelAndView("sys", "message", "");
		view.addObject("select", "sys");
		return view;
	}
	
	@RequestMapping(value="/org/{id}", method=RequestMethod.GET)
	public @ResponseBody Object get(@PathVariable Integer id) {
		Organization org = organizationService.getOrg(new Long(id));
		return org;
	}
	
	@RequestMapping(value="/demo/add", method=RequestMethod.GET)
	public @ResponseBody Object add() {
		
		return "succ";
	}
	
	
}
