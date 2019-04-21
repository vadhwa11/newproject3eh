/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.

 * Use is subject to license terms.
 * Class DietController.java
 * Purpose of the class - This is for Diet Module.
 * @author  Ritu Sahu
 * Create Date: 5th Sep,2008
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/
package jkt.hms.diet.controller;

import static jkt.hms.util.RequestConstants.ADDRESS;


import static jkt.hms.util.RequestConstants.DIET_MESSAGE_DETAILS;
import static jkt.hms.util.RequestConstants.AD_NO;
import static jkt.hms.util.RequestConstants.DIET_CHANGE_JSP;
import static jkt.hms.util.RequestConstants.DIET_PENDING_LIST_JSP;
import static jkt.hms.util.RequestConstants.DIET_EXTRA_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.DIET_INDENT_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.DIET_MENU_ITEM_FORMULA_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GRN_DATE;
import static jkt.hms.util.RequestConstants.HEIGHT;
import static jkt.hms.util.RequestConstants.HIN_ID;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ITEM_NAME;
import static jkt.hms.util.RequestConstants.MOBILE_NO;
import static jkt.hms.util.RequestConstants.PATIENT_DETAILS;
import static jkt.hms.util.RequestConstants.PATIENT_ENQUIRY_JSP;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_STATUS;
import static jkt.hms.util.RequestConstants.POLICE_STATION;
import static jkt.hms.util.RequestConstants.STATE_ID;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VILLAGE;
import static jkt.hms.util.RequestConstants.DIET_PENDING_DETAILS;
import static jkt.hms.util.RequestConstants.VISIT_ID;
import static jkt.hms.util.RequestConstants.WEIGHT;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.DIET_INDOOR_PATIENT_JSP;
import static jkt.hms.util.RequestConstants.DIET_INDOOR_MESSAGE_DETAILS;
import static jkt.hms.util.RequestConstants.DIET_INDOOR_PATIENT_CHART;
import static jkt.hms.util.RequestConstants.GENERAL_DIET_SHEET_JSP;
//mport static jkt.hms.util.RequestConstants.RESPONSE_DIET_INDOOR_PATIENT_JSP;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.diet.handler.DietHandlerService;
import jkt.hms.masters.business.DietExtraItemFormula;
import jkt.hms.masters.business.DietIndentItemFormula;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@SuppressWarnings("unused")
public class DietController extends MultiActionController {

	DietHandlerService dietHandlerService = null;
	String title = "";
	String jsp = "";
	String message = "";
	public DietHandlerService getDietHandlerService() {
		return dietHandlerService;
	}

	public void setDietHandlerService(DietHandlerService dietHandlerService) {
		this.dietHandlerService = dietHandlerService;
	}

	/**
	 * --------------------------- Method to show Menu Item Formula jsp
	 * -----------------------------------
	 *
	 */

	public ModelAndView showMenuItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showMenuItemFormulaJsp();
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addMenuItemFormula(box);

		boolean saved = false;
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) map.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);

		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------------- Method to Edit Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editMenuItemFormula(box);
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		boolean updated = false;
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) datamap
					.get("existingList");
		}

		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to delete Menu Item Formula details
	 * -----------------------------------
	 *
	 */

	public ModelAndView deleteMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteMenuItemFormula(box);
		boolean deleted = false;
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showMenuItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------------- Method to Search Menu Item Formula
	 * -----------------------------------
	 *
	 */

	public ModelAndView searchMenuItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchMenuItemFormula(box);
		jsp = DIET_MENU_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Menu Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to show Extra Item Formula jsp
	 * -----------------------------------
	 *
	 */

	public ModelAndView showExtraItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showExtraItemFormulaJsp();
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addExtraItemFormula(box);

		boolean saved = false;
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) map.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to Edit Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editExtraItemFormula(box);

		boolean updated = false;
		List<DietExtraItemFormula> existingList = new ArrayList<DietExtraItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietExtraItemFormula>) datamap
					.get("existingList");
		}
		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to delete Extra Item Formula details
	 * -----------------------------------
	 *
	 */

	public ModelAndView deleteExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteExtraItemFormula(box);
		boolean deleted = false;
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showExtraItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------------- Method to Search Extra Item Formula
	 * -----------------------------------
	 *
	 */

	public ModelAndView searchExtraItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchExtraItemFormula(box);
		jsp = DIET_EXTRA_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Extra Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to show Indent Item Formula jsp
	 * -----------------------------------
	 *
	 */

	public ModelAndView showIndentItemFormulaJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = dietHandlerService.showIndentItemFormulaJsp();
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to submit Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView addIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;

		Box box = HMSUtil.getBox(request);

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = dietHandlerService.addIndentItemFormula(box);

		boolean saved = false;
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();

		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (map.get("existingList") != null) {
			existingList = (List<DietIndentItemFormula>) map
					.get("existingList");
		}

		if (saved) {
			message = "Record Saved Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------------- Method to Edit Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView editIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		datamap = dietHandlerService.editIndentItemFormula(box);
		HttpSession session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		boolean updated = false;
		List<DietIndentItemFormula> existingList = new ArrayList<DietIndentItemFormula>();

		if (datamap.get("updated") != null) {
			updated = (Boolean) datamap.get("updated");
		}
		if (datamap.get("existingList") != null) {
			existingList = (List<DietIndentItemFormula>) datamap
					.get("existingList");
		}

		if (updated) {
			message = "Record Updated Successfully!!";
		} else {
			if (existingList.size() > 0) {
				message = "Record already exist!!";
			} else {
				message = "Try Again!";
			}
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to delete Indent Item Formula details
	 * -----------------------------------
	 *
	 */

	public ModelAndView deleteIndentItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		map = dietHandlerService.deleteIndentItemFormula(box);
		boolean deleted = false;
		if (map.get("deleted") != null) {
			deleted = (Boolean) map.get("deleted");
		}

		if (deleted) {
			message = "Record Inactivated Successfully!!";
		} else {
			message = "Try Again!";
		}
		map = dietHandlerService.showIndentItemFormulaJsp();
		map.put("message", message);
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * --------------------------- Method to Search Indent Item Formula
	 * -----------------------------------
	 *
	 */

	public ModelAndView searchInedntItemFormula(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String itemName = "";

		Box box = HMSUtil.getBox(request);

		itemName = box.getString(ITEM_NAME);
		map = dietHandlerService.searchIndentItemFormula(box);
		jsp = DIET_INDENT_ITEM_FORMULA_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item Formula";
		map.put("itemName", itemName);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------------- Method to Show Patient Diet Change Jsp
	 * -----------------------------------
	 *
	 */

	public ModelAndView showPatientDietChangeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int departmentId = 0;

		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
		}

		map = dietHandlerService.getPatientListForDietChange(departmentId);
		jsp = DIET_CHANGE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addPatientDietDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		int hospitalId = 0;
		String userName = "";

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}
		map = dietHandlerService.addPatientDietDetails(box);
		jsp = DIET_CHANGE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	//Added by Ramdular +21-OCT-2010+
	public ModelAndView showPendingPatientDietList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Date toDate =new Date();
		int hospitalId = 0;
		String userName = "";
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}
		map.put("toDate",toDate);
		map = dietHandlerService.getPendingPatientDietList(map);
		jsp = DIET_PENDING_LIST_JSP;
		jsp += ".jsp";
		title = "Pending OPD Patient list for Diet Schedule";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchPendingPatientDietList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date toDate =null;
		String hin_no="";
		String p_first_name="";
		String p_middle_name="";
		String p_last_name="";

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				map.put("toDate", toDate);


			}
				if(request.getParameter(HIN_NO)!=null && !request.getParameter(HIN_NO).equals(""))
				{
					hin_no = (String)request.getParameter(HIN_NO);
					map.put("hin_no", hin_no);
				}
				if(request.getParameter(P_FIRST_NAME)!=null && !request.getParameter(P_FIRST_NAME).equals(""))
				{
					p_first_name = (String)request.getParameter(P_FIRST_NAME);
					map.put("p_first_name", p_first_name);
				}
				if(request.getParameter(P_MIDDLE_NAME)!=null && !request.getParameter(P_MIDDLE_NAME).equals(""))
				{
					p_middle_name = (String)request.getParameter(P_MIDDLE_NAME);
					map.put("p_middle_name", p_middle_name);
				}
				if(request.getParameter(P_LAST_NAME)!=null && !request.getParameter(P_LAST_NAME).equals(""))
				{
					p_last_name = (String)request.getParameter(P_LAST_NAME);
					map.put("p_last_name", p_last_name);
				}
			map = dietHandlerService.getPendingPatientDietList(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_PENDING_LIST_JSP;
		jsp += ".jsp";
		title = "Pending OPD Patient list for Diet Schedule";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showPendingPatientDietDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int id =0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		dataMap.put("id", id);
		map = dietHandlerService.showPendingPatientDietDetails(dataMap);
		String jsp = DIET_PENDING_DETAILS;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView updatePatientDiet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int hospitalId = 0;
		String userName = "";
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}
		map = dietHandlerService.updatePatientDiet(box);
		if(map.get("flag")!=null)
		{
			message = "The Diet Details Successfully saved !";
			map.put("message", message);
		}
		jsp = DIET_MESSAGE_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDietDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int opdPatientId = 0;
		String query =null;
		String time=null;
		if (request.getParameter("opdPatientId") != null) {
			opdPatientId = Integer.parseInt(request.getParameter("opdPatientId"));
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = dietHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("opdPatientId", opdPatientId);
		parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
		parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));

		query = "where opd_patient_details.id="+opdPatientId;
		parameters.put("query", query);

		try {

			HMSUtil.generateReport("patientPendingDietDetails",
					parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	public ModelAndView showDietForIndoorPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int departmentId = 0;
		String userName = "";
		Date toDate =null;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			map.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			map.put("departmentId", departmentId);
		}

		 map = dietHandlerService.getDietForIndoorPatientList(map);
		jsp = DIET_INDOOR_PATIENT_JSP;
		jsp += ".jsp";
		title = "Chart of diet for indoor patient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchIndoorPatientDietList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date toDate =null;
		int departmentId=0;
		String hin_no="";
		String p_first_name="";
		String p_middle_name="";
		String p_last_name="";

		try {

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				map.put("toDate", toDate);
			}
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
				map.put("departmentId", departmentId);
			}

				if(request.getParameter(HIN_NO)!=null && !request.getParameter(HIN_NO).equals(""))
				{
					hin_no = (String)request.getParameter(HIN_NO);
					map.put("hin_no", hin_no);
				}
				if(request.getParameter(P_FIRST_NAME)!=null && !request.getParameter(P_FIRST_NAME).equals(""))
				{
					p_first_name = (String)request.getParameter(P_FIRST_NAME);
					map.put("p_first_name", p_first_name);
				}
				if(request.getParameter(P_MIDDLE_NAME)!=null && !request.getParameter(P_MIDDLE_NAME).equals(""))
				{
					p_middle_name = (String)request.getParameter(P_MIDDLE_NAME);
					map.put("p_middle_name", p_middle_name);
				}
				if(request.getParameter(P_LAST_NAME)!=null && !request.getParameter(P_LAST_NAME).equals(""))
				{
					p_last_name = (String)request.getParameter(P_LAST_NAME);
					map.put("p_last_name", p_last_name);
				}
			map = dietHandlerService.getDietForIndoorPatientList(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_INDOOR_PATIENT_JSP;
		jsp += ".jsp";
		title = "Chart of diet for indoor patient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateIndoorPatientDiet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int hospitalId = 0;
		String userName = "";
		int departmentId=0;
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			box.put("departmentId", departmentId);
		}

		map = dietHandlerService.updateIndoorPatientDiet(box);
		if(map.get("flag")!=null)
		{
			message = "The Indoor Patient Diet Details Successfully saved !";
			map.put("message", message);
		}
		jsp = DIET_INDOOR_MESSAGE_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIndoorPatientDiet(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = dietHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId=0;
		String query=null;
		String time =null;
		String toDate =null;
		try {
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
				map.put("departmentId", departmentId);
				parameters.put("departmentId", departmentId);
				query = " where patient_diet_indoor_header.department_id ="+departmentId+" and inpatient.ad_status='A' ";
			}
			parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));
			if(request.getParameter("toDate")!=null)
			{
				toDate =(String)(request.getParameter("toDate"));
				query =query+" and patient_diet_indoor_header.dateofcreation ='"+toDate+"' ";
				parameters.put("toDate", toDate);
			}
			if(request.getParameter("timeType")!=null)
			{
				time = request.getParameter("timeType");
				query =query+" and patient_diet_indoor_header.time ='"+time+"'";
			}

			parameters.put("query", query);
			HMSUtil.generateReport("IndoorPatientDietDetails",
					parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public ModelAndView showIndoorPatientDietReports(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = dietHandlerService.getConnectionForReport();
		HttpSession session = request.getSession();
		int departmentId=0;
		try {
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
				map.put("departmentId", departmentId);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}

		jsp = DIET_INDOOR_PATIENT_CHART;
		jsp += ".jsp";
		title = "Chart of diet served to indoor patient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showGeneralDietSheetReports(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = dietHandlerService.getConnectionForReport();
		HttpSession session = request.getSession();
		int departmentId=0;
		try {
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
				map.put("departmentId", departmentId);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		jsp = GENERAL_DIET_SHEET_JSP;
		jsp += ".jsp";
		title = "General Diet Sheet";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printGeneralDietSheet(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = dietHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId=0;
		String time =null;
		Date fromDate = null;
		Date toDate = null;

		try {
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
				map.put("departmentId", departmentId);
				parameters.put("departmentId", departmentId);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				parameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				parameters.put("TO_DATE", toDate);
			}
			parameters.put("IMAGE_RKS", getServletContext().getRealPath("/jsp/images/rks.gif"));
			parameters.put("IMAGE_DIR", getServletContext().getRealPath("/jsp/images/svb.jpg"));

			HMSUtil.generateReport("GeneralDietSheet",
					parameters, (Connection) detailsMap.get("conn"),
					response, getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView showDietForIndoorPatientListNest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int departmentId = 0;
		String userName = "";
		Date toDate =null;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
			map.put("userName", userName);
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = (Integer) session.getAttribute("deptId");
			map.put("departmentId", departmentId);
		}
		if(request.getParameter(RequestConstants.TIME)!=null)
		{
			map.put("time",request.getParameter(RequestConstants.TIME));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			map.put("toDate", toDate);
		}

		map = dietHandlerService.getDietForIndoorPatientList(map);
		//jsp = RESPONSE_DIET_INDOOR_PATIENT_JSP;

		return new ModelAndView("responseDietIndoorPatientJsp", "map", map);
	}
}
