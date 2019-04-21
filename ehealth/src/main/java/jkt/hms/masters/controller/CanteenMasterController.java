package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.DIET_CATEGORY_NAME;
import static jkt.hms.util.RequestConstants.DIET_COMBINATION_NAME;
import static jkt.hms.util.RequestConstants.DIET_DIET_TYPE;
import static jkt.hms.util.RequestConstants.DIET_ID;
import static jkt.hms.util.RequestConstants.DIET_INDENT_ITEM_JSP;
import static jkt.hms.util.RequestConstants.DIET_ITEMS;
import static jkt.hms.util.RequestConstants.DIET_JSP;
import static jkt.hms.util.RequestConstants.DIET_MENU_ITEM_JSP;
import static jkt.hms.util.RequestConstants.DIET_TYPE;
import static jkt.hms.util.RequestConstants.DIET_TYPE_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.DIET_MENU_ITEM_ID;
import static jkt.hms.util.RequestConstants.MENU_TYPE;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.MasDiet;
import jkt.hms.masters.business.MasDietCombination;
import jkt.hms.masters.business.MasDietIndentItem;
import jkt.hms.masters.business.MasDietItems;
import jkt.hms.masters.business.MasDietType;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasMenuType;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CanteenMasterHandlerService;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class CanteenMasterController extends MultiActionController {

	CanteenMasterHandlerService canteenMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String code = "";
	String name = "";
	String currentDate = "";
	String currentTime = "";
	String jspName = "";
	String jsp = "";
	String title = "";
	String message = " ";
	String url = "";
	String viewPage = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String status = "";
	int id = 0;
	HttpSession session = null;
	String userName = "";

	// --------------------------------Diet
	// master-------------------------------------------

	public ModelAndView searchDiet(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dietCode = null;
		String dietName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			dietCode = searchField;
			dietName = null;

		} else {
			dietCode = null;
			dietName = searchField;
		}
		map = canteenMasterHandlerService.searchDiet(dietCode, dietName);

		jsp = DIET_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dietCode", dietCode);
		map.put("dietName", dietName);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDietJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = canteenMasterHandlerService.showDietJsp();
		jsp = DIET_JSP;
		jsp += ".jsp";
		title = "Diet";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDiet(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String changedBy = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		int category = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter(DIET_CATEGORY_NAME) != null) {
			category = Integer.parseInt(request.getParameter(DIET_CATEGORY_NAME));
		}*/
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("category", category);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put(RequestConstants.USER_ID, userId);


		listMap = canteenMasterHandlerService.addDiet(generalMap);

		List<MasDiet> duplicateList = new ArrayList<MasDiet>();
		boolean successfullyAdded = false;

		if (listMap.get("duplicateList") != null) {
			duplicateList = (List) listMap.get("duplicateList");
		}
		if (listMap.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) listMap.get("successfullyAdded");
		}
		if ((duplicateList.size() == 0)) {
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (duplicateList.size() != 0) {
			message = "Record  already exists.";
		}
		url = "/hms/hms/canteen?method=showDietJsp";

		try {
			map = canteenMasterHandlerService.showDietJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_JSP;
		title = "Add Diet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDiet(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();

		session = request.getSession(true);

		String dietCode = "";
		String dietName = "";
		int category = 0;
		int dietId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietName = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter(DIET_CATEGORY_NAME) != null) {
			category = Integer.parseInt(request.getParameter(DIET_CATEGORY_NAME));
		}*/
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
		}

		generalMap.put("id", dietId);
		generalMap.put("dietCode", dietCode);
		generalMap.put("name", dietName);
		generalMap.put("category", category);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("flag", true);

		listMap = canteenMasterHandlerService.editDietToDatabase(generalMap);
		List<MasDiet> duplicateList = new ArrayList<MasDiet>();
		boolean dataUpdated = false;

		if (listMap.get("duplicateList") != null) {
			duplicateList = (List) listMap.get("duplicateList");
		}
		if (listMap.get("dataUpdated") != null) {
			dataUpdated = (Boolean) listMap.get("dataUpdated");
		}

		if (duplicateList.size() == 0) {
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else {
			message = "Record already exists.";
		}
		url = "/hms/hms/canteen?method=showDietJsp";

		try {
			map = canteenMasterHandlerService.showDietJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_JSP;
		title = "update Diet";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDiet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int dietId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataDeleted = false;
		dataDeleted = canteenMasterHandlerService
				.deleteDiet(dietId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/canteen?method=showDietJsp";
		try {
			map = canteenMasterHandlerService.showDietJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_JSP;
		title = "delete Diet";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------- DietType-----------------------

	public ModelAndView searchDietType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dietTypeCode = null;
		String dietTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietTypeName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			dietTypeCode = searchField;
			dietTypeName = null;

		} else {
			dietTypeCode = null;
			dietTypeName = searchField;
		}
		map = canteenMasterHandlerService.searchDietType(dietTypeCode,
				dietTypeName);

		jsp = DIET_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dietTypeCode", dietTypeCode);
		map.put("dietTypeName", dietTypeName);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDietTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = canteenMasterHandlerService.showDietTypeJsp();
		jsp = DIET_TYPE;
		jsp += ".jsp";
		title = "dietType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDietType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasDietType masDietType = new MasDietType();
		HttpSession session=request.getSession();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List dietTypeCodeList = new ArrayList();
		List dietTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			dietTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			dietTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((dietTypeCodeList.size() == 0 || dietTypeCodeList == null)
				&& (dietTypeNameList.size() == 0 || dietTypeNameList == null)) {
			masDietType.setDietTypeCode(code);
			masDietType.setDietTypeName(name);
			masDietType.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masDietType.setLastChgBy(users);
			masDietType.setLastChgDate(currentDate);
			masDietType.setLastChgTime(currentTime);
			successfullyAdded = canteenMasterHandlerService
					.addDietType(masDietType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((dietTypeCodeList.size() != 0 || dietTypeCodeList != null)
				|| (dietTypeNameList.size() != 0) || dietTypeNameList != null) {

			if ((dietTypeCodeList.size() != 0 || dietTypeCodeList != null)
					&& (dietTypeNameList.size() == 0 || dietTypeNameList == null)) {

				message = "DietType Code  already exists.";
			} else if ((dietTypeNameList.size() != 0 || dietTypeNameList != null)
					&& (dietTypeCodeList.size() == 0 || dietTypeCodeList == null)) {
				message = "DietType Name already exists.";
			} else if ((dietTypeCodeList.size() != 0 || dietTypeCodeList != null)
					&& (dietTypeNameList.size() != 0 || dietTypeNameList != null)) {
				message = "DietType Code and DietType Name already exist.";
			}
		}

		url = "/hms/hms/canteen?method=showDietTypeJsp";

		try {
			map = canteenMasterHandlerService.showDietTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_TYPE;
		title = "Add DietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDietType(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String dietTypeCode = "";
		String dietTypeName = "";
		int dietTypeId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);     
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietTypeName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", dietTypeId);
		generalMap.put("dietTypeCode", dietTypeCode);
		generalMap.put("name", dietTypeName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDietTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDietTypeNameList.size() == 0) {

			dataUpdated = canteenMasterHandlerService
					.editDietTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDietTypeNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/canteen?method=showDietTypeJsp";

		try {
			map = canteenMasterHandlerService.showDietTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_TYPE;
		title = "update DietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDietType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dietTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		
		HttpSession session=request.getSession();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID); 
		generalMap.put("userId", userId);
		
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = canteenMasterHandlerService.deleteDietType(dietTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/canteen?method=showDietTypeJsp";
		try {
			map = canteenMasterHandlerService.showDietTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_TYPE;
		title = "delete DietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------------- DietItems-----------------------

	public ModelAndView searchDietItems(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dietItemsCode = null;
		String dietItemsName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietItemsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietItemsName = request.getParameter(SEARCH_NAME);
		}
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);
			}
			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (searchRadio == 1) {
			dietItemsCode = searchField;
			dietItemsName = null;

		} else {
			dietItemsCode = null;
			dietItemsName = searchField;
		}
		map = canteenMasterHandlerService.searchDietItems(dietItemsCode,
				dietItemsName);
		jsp = DIET_ITEMS;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dietItemsCode", dietItemsCode);
		map.put("dietItemsName", dietItemsName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showDietItemsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = canteenMasterHandlerService.showDietItemsJsp();
		jsp = DIET_ITEMS;
		jsp += ".jsp";
		title = "dietItems";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDietItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		MasDietItems masDietItems = new MasDietItems();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List dietItemsCodeList = new ArrayList();
		List dietItemsNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			dietItemsCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			dietItemsNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((dietItemsCodeList.size() == 0 || dietItemsCodeList == null)
				&& (dietItemsNameList.size() == 0 || dietItemsNameList == null)) {
			masDietItems.setDietItemsCode(code);
			masDietItems.setDietItemsName(name);
			masDietItems.setStatus("y");
			Users users=new Users();
			users.setId(userId);
			masDietItems.setLastChgBy(users);
			masDietItems.setLastChgDate(currentDate);
			masDietItems.setLastChgTime(currentTime);
			successfullyAdded = canteenMasterHandlerService
					.addDietItems(masDietItems);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((dietItemsCodeList.size() != 0 || dietItemsCodeList != null)
				|| (dietItemsNameList.size() != 0) || dietItemsNameList != null) {

			if ((dietItemsCodeList.size() != 0 || dietItemsCodeList != null)
					&& (dietItemsNameList.size() == 0 || dietItemsNameList == null)) {

				message = "DietItems Code  already exists.";
			} else if ((dietItemsNameList.size() != 0 || dietItemsNameList != null)
					&& (dietItemsCodeList.size() == 0 || dietItemsCodeList == null)) {
				message = "DietItems Name already exists.";
			} else if ((dietItemsCodeList.size() != 0 || dietItemsCodeList != null)
					&& (dietItemsNameList.size() != 0 || dietItemsNameList != null)) {
				message = "DietItems Code and DietItems Name already exist.";
			}
		}

		url = "/hms/hms/canteen?method=showDietItemsJsp";

		try {
			map = canteenMasterHandlerService.showDietItemsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_ITEMS;
		title = "Add DietItems";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDietItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession(true);
		String dietItemsCode = "";
		String dietItemsName = "";
		int dietItemsId = 0;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietItemsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			dietItemsCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietItemsName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", dietItemsId);
		generalMap.put("dietItemsCode", dietItemsCode);
		generalMap.put("name", dietItemsName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put(RequestConstants.USER_ID, userId);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingDietItemsNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingDietItemsNameList.size() == 0) {

			dataUpdated = canteenMasterHandlerService
					.editDietItemsToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingDietItemsNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/canteen?method=showDietItemsJsp";

		try {
			map = canteenMasterHandlerService.showDietItemsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_ITEMS;
		title = "update DietItems";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDietItems(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();

		int dietItemsId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int userId=(Integer)session.getAttribute(RequestConstants.USER_ID);

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietItemsId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put(RequestConstants.USER_ID, userId);

		boolean dataDeleted = false;
		dataDeleted = canteenMasterHandlerService.deleteDietItems(dietItemsId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = canteenMasterHandlerService.showDietItemsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_ITEMS;
		title = "delete DietItems";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------Diet
	// Combination--------------------------------------------------

	public ModelAndView showDietCombinationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = canteenMasterHandlerService.showDietCombinationJsp();
		jsp = DIET_DIET_TYPE;
		jsp += ".jsp";
		title = "dietDietType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDietCombination(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasDietCombination masDietCombination = new MasDietCombination();
		HttpSession session=request.getSession();
		int userId=0;
		int dietId = 0;
		int dietTypeId = 0;
		String dietCategoryName = "";
		String changedBy = "";
		 int hsId=0;
		int dMenu=0;
		int dItem=0;
		float dquat=0;
		if(session.getAttribute("hospitalId")!=null){
			hsId=(Integer)session.getAttribute("hospitalId");
		}
		
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(MENU_TYPE) != null) {
			dMenu = Integer.parseInt(request.getParameter(MENU_TYPE));
		}
		if (request.getParameter("items") != null) {
			dItem = Integer.parseInt(request.getParameter("items"));
		}
		if (request.getParameter("dquat") != null) {
			dquat = Float.parseFloat(request.getParameter("dquat"));
		}
		if (request.getParameter(DIET_ID) != null) {
			dietId = Integer.parseInt(request.getParameter(DIET_ID));
		}
		/*if (request.getParameter(DIET_TYPE_ID) != null) {
			dietTypeId = Integer.parseInt(request.getParameter(DIET_TYPE_ID));
		}*/
		if (request.getParameter(DIET_COMBINATION_NAME) != null
				&& !(request.getParameter(DIET_COMBINATION_NAME).equals(""))) {
			dietCategoryName = request.getParameter(DIET_COMBINATION_NAME);
		}
		if (session.getAttribute("userId") != null
				&& !(session.getAttribute("userId").equals(""))) {
			userId =(Integer)session.getAttribute("userId");
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		
		
		
		
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoName", pojoName);

		boolean successfullyAdded = false;

		MasDiet masDiet = new MasDiet();
		masDiet.setId(dietId);
		masDietCombination.setDiet(masDiet);

		//MasDietType masDietType = new MasDietType();
	//	masDietType.setId(dietTypeId);
		//masDietCombination.setDietType(masDietType);

		masDietCombination.setDietCombinationName(dietCategoryName);
		masDietCombination.setStatus("y");
		Users user=new Users();
		user.setId(userId);
		masDietCombination.setLastChgBy(user);
		masDietCombination.setLastChgDate(currentDate);
		masDietCombination.setLastChgTime(currentTime);
	    MasDietItems masDietItem=new MasDietItems();
	    masDietItem.setId(dItem);
		masDietCombination.setDietItems(masDietItem);
		
		masDietCombination.setDietQuantity(dquat);
		MasHospital masHos=new MasHospital();
		masHos.setId(hsId);
		masDietCombination.setHospital(masHos);
		MasMenuType maMenu=new MasMenuType();
		maMenu.setId(dMenu);
		masDietCombination.setMenu(maMenu);
		successfullyAdded = canteenMasterHandlerService
				.addDietCombination(masDietCombination);
		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = canteenMasterHandlerService.showDietCombinationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_DIET_TYPE;
		title = "Add DietDietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editDietCombination(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int dietDietTypeId = 0;
		int dietId = 0;
		int dietTypeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String dietCategoryName = "";
		int userId=0;
		int hsId=0;
		int dMenu=0;
		int dItem=0;
		float dquat=0;
		

        if(session.getAttribute("hospitalId")!=null){
	      hsId=(Integer)session.getAttribute("hospitalId");
            }
        if (request.getParameter(MENU_TYPE) != null) {
			dMenu = Integer.parseInt(request.getParameter(MENU_TYPE));
		}
		if (request.getParameter("items") != null) {
			dItem = Integer.parseInt(request.getParameter("items"));
		}
		if (request.getParameter("dquat") != null) {
			dquat = Float.parseFloat(request.getParameter("dquat"));
		}

	
		if (request.getParameter(COMMON_ID) != null) {
			dietDietTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(DIET_ID) != null) {
			dietId = Integer.parseInt(request.getParameter(DIET_ID));
		}
		if (request.getParameter(DIET_TYPE_ID) != null) {
			dietTypeId = Integer.parseInt(request.getParameter(DIET_TYPE_ID));
		}
		if (request.getParameter(DIET_COMBINATION_NAME) != null
				&& !(request.getParameter(DIET_COMBINATION_NAME).equals(""))) {
			dietCategoryName = request.getParameter(DIET_COMBINATION_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute("userId") != null
				&& !(session.getAttribute("userId").equals(""))) {
			userId =(Integer)session.getAttribute("userId");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", dietDietTypeId);
		generalMap.put("dietId", dietId);
		generalMap.put("dietTypeId", dietTypeId);
		generalMap.put("dietCategoryName", dietCategoryName);
		
		
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("hsId", hsId);
		generalMap.put("dMenu", dMenu);
		generalMap.put("dItem", dItem);
		generalMap.put("dquat", dquat);
		
		generalMap.put("flag", true);
		boolean dataUpdated = false;
		dataUpdated = canteenMasterHandlerService
				.editDietCombination(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = canteenMasterHandlerService.showDietCombinationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_DIET_TYPE;
		title = "Edit DietDietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDietCombination(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int dietDietTypeId = 0;
		String message = null;
		int userId=0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session=request.getSession();
		if (session.getAttribute("userId") != null
				&& !(session.getAttribute("userId").equals(""))) {
			userId =(Integer)session.getAttribute("userId");
		}
		
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			dietDietTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute("userId") != null
				&& !(session.getAttribute("userId").equals(""))) {
			userId =(Integer)session.getAttribute("userId");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = canteenMasterHandlerService.deleteDietCombination(
				dietDietTypeId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = canteenMasterHandlerService.showDietCombinationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_DIET_TYPE;
		title = "Delete DietDietType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDietCombination(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String dietName = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			dietName = request.getParameter(SEARCH_NAME);
		}

		map = canteenMasterHandlerService.searchDietCombination(dietName);

		jsp = DIET_DIET_TYPE;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("dietName", dietName);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------------Diet Menu
	// Item--------------------------------------------------

	public ModelAndView showDietMenuItemJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = canteenMasterHandlerService.showDietMenuItemJsp();
		jsp = DIET_MENU_ITEM_JSP;
		jsp += ".jsp";
		title = "DietMenuItem";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addDietMenuItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
       int  userId=0;
       HttpSession session=request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		boolean successfullyAdded = false;
		box.put("userId", userId);
		successfullyAdded = canteenMasterHandlerService.addDietMenuItem(box);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}

		try {
			map = canteenMasterHandlerService.showDietMenuItemJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_MENU_ITEM_JSP;
		title = "Diet Menu Item";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editDietMenuItem(HttpServletRequest request,
			HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Map<String, Object> listMap = new HashMap<String, Object>();
            HttpSession session=request.getSession();
			
			String dietMenuType = "";
			String dietMenuItemsName = "";
			int dietMenuItemsId = 0;
			String changedBy = "";
			String changedTime = "";
			Date changedDate = null;
			int dietDietTypeId=0;
			int userId=0;
			
			if (request.getParameter(MENU_TYPE) != null
					&& !(request.getParameter(MENU_TYPE).equals(""))) {
				dietMenuType = request.getParameter(MENU_TYPE);
			}
			
			if (request.getParameter(COMMON_ID) != null) {
				dietDietTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			
			if (request.getParameter(DIET_MENU_ITEM_ID) != null
					&& !(request.getParameter(DIET_MENU_ITEM_ID).equals(""))) {
				dietMenuItemsId = Integer.parseInt(request.getParameter(DIET_MENU_ITEM_ID));
			}
			if (session.getAttribute("userId")!= null
					&& !(session.getAttribute("userId").equals(""))) {
				userId = (Integer)session.getAttribute("userId");
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			
			
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
	                if (request.getParameter("pojoPropertyCode") != null) {
				pojoPropertyCode = request.getParameter("pojoPropertyCode");
			} 
	               
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", dietDietTypeId);
			generalMap.put("dietMenuType", dietMenuType);
			generalMap.put("dietMenuItemsId", dietMenuItemsId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
	                generalMap.put("pojoPropertyCode","pojoPropertyCode");

			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingDietItemsNameList = (List) listMap
					.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingDietItemsNameList.size() == 0) {

				dataUpdated = canteenMasterHandlerService
						.editDietMenuItemToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant be updated !!";
				}
			} else if (existingDietItemsNameList.size() > 0) {

				message = "Name already exists.";
			}
			url = "/hms/hms/canteen?method=showDietMenuItemJsp";

			try {
				map = canteenMasterHandlerService.showDietMenuItemJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = DIET_MENU_ITEM_JSP;
			title = "update DietMenuItems";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		

	public ModelAndView deleteDietMenuItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
 
		Box box = HMSUtil.getBox(request);
		int userId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		box.put("userId", userId);
		boolean successfullyDeleted = false;
		successfullyDeleted = canteenMasterHandlerService
				.deleteDietMenuItem(box);

		if (successfullyDeleted) {
			String flag = (String) box.getString("flag");
			if (flag.equals("InActivate")) {
				message = "Record Inactivated successfully !!";
			} else if (flag.equals("Activate")) {
				message = "Record Activated successfully !!";
			}
		} else {
			message = "Try Again !!";
		}

		try {
			map = canteenMasterHandlerService.showDietMenuItemJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_MENU_ITEM_JSP;
		title = "Diet Menu Item";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDietMenuItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String searchField = null;
		Box box = HMSUtil.getBox(request);

		searchField = box.getString(SEARCH_NAME);

		map = canteenMasterHandlerService.searchDietMenuItem(box);
		jsp = DIET_MENU_ITEM_JSP;
		title = "Diet Menu Item";
		jsp += ".jsp";
		map.put("searchField", searchField);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	

	// -------------------------------------------Diet Indent
	// Item--------------------------------------------------

	public ModelAndView showDietIndentItemJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = canteenMasterHandlerService.showDietIndentItemJsp();
		jsp = DIET_INDENT_ITEM_JSP;
		jsp += ".jsp";
		title = "Diet Indent Item";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addDietIndentItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		boolean successfullyAdded = false;
		int userId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		box.put("userId", userId);
		dataMap = canteenMasterHandlerService.addDietIndentItem(box);
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		if (dataMap.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) dataMap.get("successfullyAdded");
		}
		if (dataMap.get("duplicateList") != null) {
			duplicateList = (List<MasDietIndentItem>) dataMap
					.get("duplicateList");
		}

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			if (duplicateList.size() > 0) {
				message = "Record Already Exists!!";
			} else {
				message = "Try Again !!";
			}
		}

		try {
			map = canteenMasterHandlerService.showDietIndentItemJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_INDENT_ITEM_JSP;
		title = "Diet Indent Item";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editDietIndentItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		boolean successfullyUpdate = false;
		int userId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		box.put("userId", userId);
		dataMap = canteenMasterHandlerService.editDietIndentItem(box);
		List<MasDietIndentItem> duplicateList = new ArrayList<MasDietIndentItem>();

		if (dataMap.get("successfullyUpdate") != null) {
			successfullyUpdate = (Boolean) dataMap.get("successfullyUpdate");
		}
		if (dataMap.get("duplicateList") != null) {
			duplicateList = (List<MasDietIndentItem>) dataMap
					.get("duplicateList");
		}

		if (successfullyUpdate) {
			message = "Record Updated Successfully !!";
		} else {
			if (duplicateList.size() > 0) {
				message = "Record Already Exists!!";
			} else {
				message = "Try Again !!";
			}
		}

		try {
			map = canteenMasterHandlerService.showDietIndentItemJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_INDENT_ITEM_JSP;
		title = "Diet Indent Item";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteDietIndentItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Box box = HMSUtil.getBox(request);
		int userId=0;
		HttpSession session=request.getSession();
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		box.put("userId", userId);
		boolean successfullyDeleted = false;
		successfullyDeleted = canteenMasterHandlerService
				.deleteDietIndentItem(box);

		if (successfullyDeleted) {
			String flag = (String) box.getString("flag");
			if (flag.equals("InActivate")) {
				message = "Record Inactivated successfully !!";
			} else if (flag.equals("Activate")) {
				message = "Record Activated successfully !!";
			}
		} else {
			message = "Try Again !!";
		}

		try {
			map = canteenMasterHandlerService.showDietIndentItemJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = DIET_INDENT_ITEM_JSP;
		title = "Diet Indent Item";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchDietIndentItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String searchField = null;

		Box box = HMSUtil.getBox(request);

		searchField = box.getString(SEARCH_FIELD);

		map = canteenMasterHandlerService.searchDietIndentItem(box);
		jsp = DIET_INDENT_ITEM_JSP;
		title = "Diet Indent Item";
		jsp += ".jsp";
		map.put("searchField", searchField);
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	// -----------------------------showMenuTypeJsp-------------

	@SuppressWarnings("unchecked")
	public ModelAndView showMenuTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map) canteenMasterHandlerService.showMenuType();
		String jsp = "menuType";
		jsp += ".jsp";
		title = "menu";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMenuType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasMenuType masMenuType = new MasMenuType();
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");


		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		try {
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}

			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}


			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				currentDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			if (request.getParameter("pojoPropertyCode") != null) {
				pojoPropertyCode = request.getParameter("pojoPropertyCode");
			}

			generalMap.put("code", code);
			generalMap.put("name", name);

			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List menuCodeList = new ArrayList();
		List menuNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			menuCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			menuNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((menuCodeList.size() == 0 || menuCodeList == null)
				&& (menuNameList.size() == 0 || menuNameList == null)) {
			masMenuType.setMenuCode(code);
			masMenuType.setMenuName(name);

			Users users = new Users();
			users.setId(userId);
			masMenuType.setLastChgBy(users);

			masMenuType.setStatus("Y");
			masMenuType.setLastChgDate(currentDate);
			masMenuType.setLastChgTime(currentTime);
			successfullyAdded = canteenMasterHandlerService.addMenuType(masMenuType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((menuCodeList.size() != 0 || menuCodeList != null)
				|| (menuNameList.size() != 0) || menuNameList != null) {
			if ((menuCodeList.size() != 0 || menuCodeList != null)
					&& (menuNameList.size() == 0 || menuNameList == null)) {
				message = "RoomType Code already exists.";
			} else if ((menuNameList.size() != 0 || menuNameList != null)
					&& (menuCodeList.size() == 0 || menuCodeList == null)) {
				message = "RoomType Name already exists.";
			} else if ((menuCodeList.size() != 0 || menuCodeList != null)
					&& (menuCodeList.size() != 0 || menuNameList != null)) {
				message = "RoomType Code and Name exist.";
			}
		}
		try {
			map = canteenMasterHandlerService.showMenuType();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "menuType";
		title = " Add menu";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editMenuType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		String menuCode = "";
		String menuName = "";
		int menuId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Integer userId = (Integer) session.getAttribute("userId");

		try {
		
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				menuId = Integer.parseInt(request.getParameter(COMMON_ID));
			}

	
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				menuCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				menuName = request.getParameter(SEARCH_NAME);
			}

			if (request.getParameter("pojoName") != null) {
				pojoName = request.getParameter("pojoName");
			}
			if (request.getParameter("pojoPropertyName") != null) {
				pojoPropertyName = request.getParameter("pojoPropertyName");
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		changedDate = new Date();
		try {
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", menuId);
			generalMap.put("menuCode", menuCode);
			generalMap.put("name", menuName);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			Map<String, Object> listMap = new HashMap<String, Object>();

			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingRoomTypeNameList = (List) listMap
					.get("duplicateMastersList");
			boolean dataUpdated = false;

			if (existingRoomTypeNameList.size() == 0) {
				dataUpdated = canteenMasterHandlerService.editMenuType(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingRoomTypeNameList.size() > 0) {
				message = "Name already exists.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			map = canteenMasterHandlerService.showMenuType();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String jsp = "menuType";
		title = " Edit Room Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchMenuType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String menuCode = null;
		String menuName = null;
		int searchRadio = 1;
		try {
			if (request.getParameter(SEARCH_FIELD) != null
					&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
				searchField = request.getParameter(SEARCH_FIELD);

			}

			if (request.getParameter(SELECTED_RADIO) != null
					&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
				searchRadio = Integer.parseInt(request
						.getParameter(SELECTED_RADIO));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (searchRadio == 1) {
			menuCode = searchField;
			menuName = null;

		} else {
			menuCode = null;
			menuName = searchField;
		}

		//

		map = canteenMasterHandlerService.searchMenuType(menuCode,
				menuName);

		jsp = "menuType";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("menuCode", menuCode);
		map.put("menuName", menuName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMenuType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int menuId = 0;
		String message = null;
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		Map<String, Object> generalMap = new HashMap<String, Object>();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			menuId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = canteenMasterHandlerService.deleteMenuType(menuId,generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/canteen?method=showMenuTypeJsp";
		try {
			map = canteenMasterHandlerService.showMenuType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "menuType";
		title = "delete Menu Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ----------------------------------------------------------------------------------------------------

	public CanteenMasterHandlerService getCanteenMasterHandlerService() {
		return canteenMasterHandlerService;
	}

	public void setCanteenMasterHandlerService(
			CanteenMasterHandlerService canteenMasterHandlerService) {
		this.canteenMasterHandlerService = canteenMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
}
