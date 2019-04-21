/**
 * 
 */
package jkt.hrms.hr.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jkt.hrms.hr.handler.HRHandlerService;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * @author rajat
 *
 */
public class HRController extends MultiActionController{
	private HRHandlerService hrHandlerService;

	public HRHandlerService getHrHandlerService() {
		return hrHandlerService;
	}

	public void setHrHandlerService(HRHandlerService hrHandlerService) {
		this.hrHandlerService = hrHandlerService;
	}
	
	public ModelAndView showEmployeeJsp(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentJsp", "showEmployeeJsp.jsp");
		return new ModelAndView("index","map",map);
	}
	
	

}
