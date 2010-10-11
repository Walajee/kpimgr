package com.focusoft.power.sccb.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.focusoft.power.sccb.base.JsonResponseObj;
import com.focusoft.power.sccb.dao.bean.StdCat;
import com.focusoft.power.sccb.service.FlowService;

@Controller
public class FlowController {
	@Autowired
	private FlowService flowService;
	
	@RequestMapping(value="/flow/add", method=RequestMethod.POST)
	public @ResponseBody Object del(HttpServletRequest request,HttpServletResponse response) {
		String flowType = request.getParameter("flowType");
		String participate = request.getParameter("par");
		String entity  = request.getParameter("ent");
		
		flowService.saveStartFlow(flowType, "admin", participate, entity);
		JsonResponseObj obj = new JsonResponseObj();
		
		return obj;
	}
}
