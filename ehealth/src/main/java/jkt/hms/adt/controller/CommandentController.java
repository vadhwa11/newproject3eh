package jkt.hms.adt.controller;

import static jkt.hms.util.RequestConstants.BED_STATE;
import static jkt.hms.util.RequestConstants.TODAY_ADMISSION;
import static jkt.hms.util.RequestConstants.TODAY_SILDIL;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.adt.handler.CommandentHandlerService;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.SilDilStatus;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CommandentController extends MultiActionController {

	CommandentHandlerService commandentHandlerService = null;

	/**
	 * ---------------------------------------- Today Admission
	 * ------------------------------- made by Mansi Gagrani on 24-june-08
	 * 
	 */

	public ModelAndView showTodayAdmissionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String jsp = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		Date currentDate = new Date();
		int deptId = 0;
		if (request.getParameter("parent") != null
				&& !request.getParameter("parent").equals("0")) {
			deptId = Integer.parseInt(request.getParameter("parent"));
		}
		map.put("currentDate", currentDate);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		inpatientList = commandentHandlerService.showTodayAdmission(map);
		jsp = TODAY_ADMISSION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("inpatientList", inpatientList);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------------------- Today SIL/DIL
	 * ------------------------------- made by Mansi Gagrani on 24-june-08
	 * 
	 */

	public ModelAndView showTodaySILDILJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String jsp = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		List<SilDilStatus> silDilStatusList = new ArrayList<SilDilStatus>();
		Date currentDate = new Date();
		int deptId = 0;
		if (request.getParameter("parent") != null
				&& !request.getParameter("parent").equals("0")) {
			deptId = Integer.parseInt(request.getParameter("parent"));
		}
		map.put("currentDate", currentDate);
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		silDilStatusList = commandentHandlerService.showTodaySILDILJsp(map);
		jsp = TODAY_SILDIL;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("silDilStatusList", silDilStatusList);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------------------- ADT BED STATE
	 * ------------------------------- made by Priyanka Garg on 25-june-08
	 * 
	 * @return
	 */

	public ModelAndView showBedStateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String jsp = "";
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Date currentDate = new Date();
		map.put("currentDate", currentDate);
		map.put("hospitalId", hospitalId);

		map = commandentHandlerService.showBedStateJsp(map);
		jsp = BED_STATE;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public CommandentHandlerService getCommandentHandlerService() {
		return commandentHandlerService;
	}

	public void setCommandentHandlerService(
			CommandentHandlerService commandentHandlerService) {
		this.commandentHandlerService = commandentHandlerService;
	}
}