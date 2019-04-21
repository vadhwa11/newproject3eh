package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.*;
import static jkt.hrms.util.HrmsRequestConstants.ADDRESS;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpaneled;
import jkt.hms.masters.business.MasItemCategory;
import jkt.hms.masters.business.MasItemClass;
import jkt.hms.masters.business.MasItemType;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasSalesTaxType;
import jkt.hms.masters.business.MasSalesType;
import jkt.hms.masters.business.MasState;
import jkt.hms.masters.business.MasStoreAirForceDepot;
import jkt.hms.masters.business.MasStoreBudget;
import jkt.hms.masters.business.MasStoreBudgetT;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreGroup;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemConversion;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStoreMeScale;
import jkt.hms.masters.business.MasStorePharmaIndex;
import jkt.hms.masters.business.MasStorePoDeliveryTerms;
import jkt.hms.masters.business.MasStoreSection;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierType;
import jkt.hms.masters.business.MasStoreUnit;
import jkt.hms.masters.business.MasStoreVendorWiseManufacturer;
import jkt.hms.masters.business.RouteOfAdministration;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.PharmacyMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.apache.log4j.Logger;
//commented for maven
/*import org.exolab.jms.authentication.User;*/
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PharmacyMasterController extends MultiActionController {
	/*
	 * Logger Implemented By Mukesh Narayan Singh
	 * Date 30 Aug 2010
	 */
	static final Logger log = Logger.getLogger(jkt.hms.masters.controller.PharmacyMasterController.class);

	PharmacyMasterHandlerService pharmacyMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = "";
	String url = "";
	String code = "";
	String name = "";
	int itemTypeId = 0;
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	Date encodedDate = new Date();
	String encodedTime = "";
	HttpSession session = null;

	// ------------------------------Item
	// Type---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showItemTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemTypeJsp();
		jsp = ITEM_TYPE_JSP;
		jsp += ".jsp";
		title = "ItemType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchItemType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String itemTypeCode = null;
		String itemTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemTypeName = request.getParameter(SEARCH_NAME);
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
			itemTypeCode = searchField;
			itemTypeName = null;
		} else {
			itemTypeCode = null;
			itemTypeName = searchField;
		}
		map = pharmacyMasterHandlerService.searchItemType(itemTypeCode,
				itemTypeName);
		jsp = ITEM_TYPE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("itemTypeCode", itemTypeCode);
		map.put("itemTypeName", itemTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasItemType masStoreItemType = new MasItemType();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int itemGroupId = 0;
		int userId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		System.out.println("item Group=="+Integer.parseInt(request.getParameter("itemGroupId")));
		if (request.getParameter("itemGroupId") != null && !request.getParameter("itemGroupId").equals("0")) {
			itemGroupId =Integer.parseInt(request.getParameter("itemGroupId"));
		}

		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List itemTypeCodeList = new ArrayList();
		List itemTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			itemTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			itemTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((itemTypeCodeList.size() == 0 || itemTypeCodeList == null)
				&& (itemTypeNameList.size() == 0 || itemTypeNameList == null)) {
			masStoreItemType.setItemTypeCode(code);
			masStoreItemType.setItemTypeName(name);
			MasStoreGroup masStoreGroup = new MasStoreGroup();
			masStoreGroup.setId(itemGroupId);
			masStoreItemType.setGroup(masStoreGroup);
			masStoreItemType.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masStoreItemType.setLastChgBy(users);
			masStoreItemType.setLastChgDate(currentDate);
			masStoreItemType.setLastChgTime(currentTime);

			successfullyAdded = pharmacyMasterHandlerService
					.addItemType(masStoreItemType);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((itemTypeCodeList.size() != 0 || itemTypeCodeList != null)
				|| (itemTypeNameList.size() != 0) || itemTypeNameList != null) {
			if ((itemTypeCodeList.size() != 0 || itemTypeCodeList != null)
					&& (itemTypeNameList.size() == 0 || itemTypeNameList == null)) {
				message = "Item Type Code  already exists.";
			} else if ((itemTypeNameList.size() != 0 || itemTypeNameList != null)
					&& (itemTypeCodeList.size() == 0 || itemTypeCodeList == null)) {
				message = "Item Type Name already exists.";
			} else if ((itemTypeCodeList.size() != 0 || itemTypeCodeList != null)
					&& (itemTypeNameList.size() != 0 || itemTypeNameList != null)) {
				message = "Item Type Code and Item Type Name already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showItemTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_TYPE_JSP;
		title = "Add Item Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editItemType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		int itemTypeId = 0;
		int userId=0;
		Date changedDate = null;
		String changedTime = "";
		int itemGroupId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("itemGroupId") != null && !request.getParameter("itemGroupId").equals("0")) {
			itemGroupId =Integer.parseInt(request.getParameter("itemGroupId"));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}

		
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", itemTypeId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("itemGroupId", itemGroupId);

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingItemTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingItemTypeNameList.size() == 0) {

			dataUpdated = pharmacyMasterHandlerService
					.editItemTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant Be Updated !!";
			}
		} else if (existingItemTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showItemTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_TYPE_JSP;
		title = "Update Item Type ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteItemType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemTypeId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		session = request.getSession();
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteItemType(itemTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		}

		else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showItemTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_TYPE_JSP;
		title = "Delete Item Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------------Item
	// Class---------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showItemCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemCategoryJsp();
		jsp = ITEM_CATEGORY_JSP;
		jsp += ".jsp";
		title = "itemCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchItemCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String itemCategoryCode = null;
		String itemCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemCategoryName = request.getParameter(SEARCH_NAME);
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
			itemCategoryCode = searchField;
			itemCategoryName = null;
		} else {
			itemCategoryCode = null;
			itemCategoryName = searchField;
		}

		map = pharmacyMasterHandlerService.searchItemCategory(itemCategoryCode,
				itemCategoryName);

		jsp = ITEM_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("itemCategoryCode", itemCategoryCode);
		map.put("itemCategoryName", itemCategoryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasItemCategory masStoreItemCategory = new MasItemCategory();
		int sectionId = 0;
		int itemTypeId = 0;
		int userId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		String userName = "";
		userName = (String) session.getAttribute("userName");
		String lastChangedDate = "";
		String lastChangedTime = "";
		listMap1 = HMSUtil.getCurrentDateAndTime();
		lastChangedTime = (String) listMap1.get("currentTime");
		lastChangedDate = (String) listMap1.get("currentDate");

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);

		}
		if (request.getParameter(ITEM_TYPE_ID) != null
				&& !request.getParameter(ITEM_TYPE_ID).equals("")) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}

		if (request.getParameter(SECTION_ID) != null
				&& !request.getParameter(SECTION_ID).equals("")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}

		//changedBy = userName;

		currentDate = HMSUtil.convertStringTypeDateToDateType(lastChangedDate);

		currentTime = lastChangedTime;

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
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List itemCategoryCodeList = new ArrayList();
		List itemCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			itemCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			itemCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((itemCategoryCodeList.size() == 0 || itemCategoryCodeList == null)
				&& (itemCategoryNameList.size() == 0 || itemCategoryNameList == null)) {
			masStoreItemCategory.setItemCategoryCode(code);
			masStoreItemCategory.setItemCategoryName(name);

			MasStoreSection masStoreSection = new MasStoreSection();

			if (itemTypeId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(itemTypeId);
				masStoreItemCategory.setDepartment(masDepartment);
			}
			if (sectionId != 0) {
				masStoreSection.setId(sectionId);

				masStoreItemCategory.setSection(masStoreSection);
			}
			masStoreItemCategory.setStatus("y");
			//masStoreItemCategory.setLastChgBy(changedBy);
			
			Users users = new Users();
			users.setId(userId);
			masStoreItemCategory.setLastChgBy(users);
			
			masStoreItemCategory.setLastChgDate(currentDate);
			masStoreItemCategory.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addItemCategory(masStoreItemCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		}

		else if ((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null)
				|| (itemCategoryNameList.size() != 0)
				|| itemCategoryNameList != null) {

			if ((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null)
					&& (itemCategoryNameList.size() == 0 || itemCategoryNameList == null)) {
				message = "Item Category Code  already exists.";
			} else if ((itemCategoryNameList.size() != 0 || itemCategoryNameList != null)
					&& (itemCategoryCodeList.size() == 0 || itemCategoryCodeList == null)) {
				message = "Item Category Name  already exists.";
			} else if ((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null)
					&& (itemCategoryNameList.size() != 0 || itemCategoryNameList != null)) {
				message = "Item Category Code and Item Category Name already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
		try {
			map = pharmacyMasterHandlerService.showItemCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_CATEGORY_JSP;
		title = "Add Item Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editItemCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String itemCategoryCode = "";
		String itemCategoryName = "";
		int sectionId = 0;
		int ItemTypeId = 0;
		int itemCategoryId = 0;
		Date changedDate = null;
		String changedTime = "";
		int userId=0;
		userName = (String) session.getAttribute("userName");
		String lastChangedDate = "";
		String lastChangedTime = "";
		listMap1 = HMSUtil.getCurrentDateAndTime();
		lastChangedTime = (String) listMap1.get("currentTime");
		lastChangedDate = (String) listMap1.get("currentDate");
		if (request.getParameter(SECTION_ID) != null
				&& !(request.getParameter(SECTION_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			itemCategoryCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemCategoryName = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(ITEM_TYPE_ID) != null
				&& !(request.getParameter(ITEM_TYPE_ID).equals(""))) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}

		//changedBy = userName;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", itemCategoryId);
		generalMap.put("itemClassCode", itemCategoryCode);
		generalMap.put("name", itemCategoryName);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("sectionId", sectionId);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate",
				HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
		generalMap.put("currentTime", lastChangedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editItemCategoryToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant be updated !!";
		}
		url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
		try {
			map = pharmacyMasterHandlerService.showItemCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_CATEGORY_JSP;
		title = "Edit Item Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteItemCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();

		int ItemCategoryId = 0;
		String message = null;
		//String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String userName = "";
		int userId=0;
		userName = (String) session.getAttribute("userName");
		String lastChangedDate = "";
		String lastChangedTime = "";
		listMap1 = HMSUtil.getCurrentDateAndTime();
		lastChangedTime = (String) listMap1.get("currentTime");
		lastChangedDate = (String) listMap1.get("currentDate");
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			ItemCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		//changedBy = userName;

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate",
				HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
		generalMap.put("currentTime", lastChangedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteItemCategory(
				ItemCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemCategoryJsp";
		try {
			map = pharmacyMasterHandlerService.showItemCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_CATEGORY_JSP;
		title = "delete Item Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	
	 //--------------------------------------Item Class-------------------
		@SuppressWarnings("unchecked")
	   public ModelAndView showItemClassJsp(HttpServletRequest request,HttpServletResponse response) { 
			session = request.getSession();
			map = pharmacyMasterHandlerService.showItemClassJsp();
			jsp =ITEM_CLASS_JSP; 
			jsp += ".jsp"; 
			title = "itemClass";
		  map.put("contentJsp",jsp); 
		  map.put("title", title); 
		  return new ModelAndView("index", "map", map);
		  }

	  
	  public ModelAndView searchItemClass(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String itemClassCode = null;
		    String itemClassName = null; 
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				itemClassCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				itemClassName = request.getParameter(SEARCH_NAME);
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
				itemClassCode = searchField;
				itemClassName = null;
			} else {
				itemClassCode = null;
				itemClassName = searchField;
			}
			map = pharmacyMasterHandlerService.searchItemClass(itemClassCode,
					itemClassName);
			jsp = ITEM_CLASS_JSP;
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("search", "search");
			map.put("itemClassCode", itemClassCode);
			map.put("itemClassName", itemClassName);
			return new ModelAndView("index", "map", map);
		}
	 
	 
	  public ModelAndView addItemClass(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasItemClass masStoreItemClass=new MasItemClass();
			String changedBy = "";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int userId = 0;
			int sectionId = 0;
			HttpSession session = request.getSession();
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}	
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			
			if (request.getParameter(SECTION_ID) != null
					&& !request.getParameter(SECTION_ID).equals("")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
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

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);

			  List itemClassCodeList = new ArrayList();
			  List itemClassNameList = new ArrayList();
			if (listMap.get("duplicateGeneralCodeList") != null) {
				itemClassCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				itemClassNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			 if((itemClassCodeList.size() == 0 || itemClassCodeList == null) &&
					  (itemClassNameList.size() == 0 || itemClassNameList == null)) {
					  masStoreItemClass.setItemClassCode(code);
					  masStoreItemClass.setItemClassName(name);
					  Users users = new Users();
					  users.setId(userId);
					  masStoreItemClass.setLastChgBy(users);
					  masStoreItemClass.setStatus("y");
					  masStoreItemClass.setLastChgDate(currentDate);
					  MasStoreSection masStoreSection = new MasStoreSection();
					  masStoreSection.setId(sectionId);
					  masStoreItemClass.setSection(masStoreSection);
					  masStoreItemClass.setLastChgTime(currentTime); successfullyAdded =
					  pharmacyMasterHandlerService.addItemClass(masStoreItemClass);
				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			} else if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
					|| (itemClassNameList.size() != 0) || itemClassNameList != null) {
				if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
						&& (itemClassNameList.size() == 0 || itemClassNameList == null)) {
					message = "Item Class Code already exists.";
				} else if ((itemClassNameList.size() != 0 || itemClassNameList != null)
						&& (itemClassCodeList.size() == 0 || itemClassCodeList == null)) {
					message = "Item Class Name already exists.";
				} else if ((itemClassCodeList.size() != 0 || itemClassCodeList != null)
						&& (itemClassNameList.size() != 0 || itemClassNameList != null)) {
					message = "Item Class Code and Item Class Name already exist.";
				}
			}
			url = "/hms/hms/generalMaster?method=showItemClassJsp";
			try {
				map = pharmacyMasterHandlerService.showItemClassJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = ITEM_CLASS_JSP;
			title = "Add Item Class";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
	  
	  public ModelAndView editItemClass(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
		
			String itemClassCode="";
			String itemClassName="";
			int itemClassId=0;
			int userId = 0;
			Date changedDate = null;
			String changedTime = "";
			if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
			 int sectionId = 0;
			  itemClassCode=(String )session.getAttribute("itemClassCode");
			  itemClassName=(String )session.getAttribute("itemClassName");

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemClassId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(SECTION_ID) != null
					&& !request.getParameter(SECTION_ID).equals("")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				itemClassCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				itemClassName = request.getParameter(SEARCH_NAME);
			}

		/*	if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}*/
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			generalMap.put("id", itemClassId);
			generalMap.put("sectionId", sectionId);
			generalMap.put("groupCode", itemClassCode);
			generalMap.put("name", itemClassName);
			generalMap.put("changedBy", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			Map<String, Object> listMap = new HashMap<String, Object>();
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoName", pojoName);
			generalMap.put("flag", true);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List existingItemClassNameList = (List) listMap.get("duplicateMastersList");

			boolean dataUpdated = false;
			if (existingItemClassNameList.size() == 0) {

				dataUpdated = pharmacyMasterHandlerService
						.editItemClassToDatabase(generalMap);

				if (dataUpdated == true) {
					message = "Data updated Successfully !!";
				} else {
					message = "Data Cant Be Updated !!";
				}
			} else if (existingItemClassNameList.size() > 0) {

				message = "Name already exists.";
			}
			url = "/hms/hms/generalMaster?method=showItemClassJsp";
			try {
				map = pharmacyMasterHandlerService.showItemClassJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp=ITEM_CLASS_JSP;
		    title="Edit Item Class";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}
	 
	  public ModelAndView deleteItemClass(HttpServletRequest request, HttpServletResponse response) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 int ItemClassId=0;
		 String message=null;
		 int userId = 0;
		 String changedTime = "";
		 Date changedDate = null;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
	  if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
		  ItemClassId = Integer.parseInt( request.getParameter(COMMON_ID));
		  }
	  if(request.getParameter("title") != null){
		  title = request.getParameter("title");
		  } 
	 /* if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
		  changedBy = request.getParameter(CHANGED_BY); 
		  } */
	  	changedDate= new Date();
		  changedTime = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 
		  generalMap.put("changedBy", userId);
		  generalMap.put("currentDate",changedDate); 
		  generalMap.put("currentTime", changedTime);
		  boolean dataDeleted=false;
	   dataDeleted=pharmacyMasterHandlerService.deleteItemClass(ItemClassId,generalMap);
	   if (dataDeleted==true) {
		   message="Record is InActivated successfully !!";
		   }else{ message="Record is Activated successfully !!";
		   } 
	   url = "/hms/hms/pharmacy?method=showItemClassJsp";
	   try{
		   map = pharmacyMasterHandlerService.showItemClassJsp();
		   }catch (Exception e) {
	   }
		   jsp=ITEM_CLASS_JSP;
		   title="delete Item Class";
		   jsp += ".jsp";
		   map.put("contentJsp", jsp);
		   map.put("title", title);
		   map.put("message", message);
		   return new ModelAndView("index", "map", map); }
	
	// --------------------Sales Type
	// Report-------------------------------------------------------
	public ModelAndView reportSalesType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Sales_Type", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// -------------------------------------Sales
	// Type------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showSalesTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showSalesTypeJsp();
		jsp = SALES_TYPE_JSP;
		jsp += ".jsp";
		title = "salesType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchSalesType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String salesTypeCode = null;
		String salesTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			salesTypeCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			salesTypeName = request.getParameter(SEARCH_NAME);
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
			salesTypeCode = searchField;
			salesTypeName = null;

		} else {
			salesTypeCode = null;
			salesTypeName = searchField;
		}
		map = pharmacyMasterHandlerService.searchSalesType(salesTypeCode,
				salesTypeName);

		jsp = SALES_TYPE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("salesTypeCode", salesTypeCode);
		map.put("salesTypeName", salesTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addSalesType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		MasSalesType masSalesType = new MasSalesType();
		String code = "";
		String name = "";
		int salesTypeValue = 0;
		String changedBy = "";
		Date currentDate = new Date();
		try {
			if (request.getParameter(CODE) != null) {
				code = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(SALES_TYPE_VALUE) != null) {
				salesTypeValue = Integer.parseInt(request
						.getParameter(SALES_TYPE_VALUE));
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List salesTypeCodeList = new ArrayList();
		List salesTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			salesTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			salesTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((salesTypeCodeList.size() == 0 || salesTypeCodeList == null)
				&& (salesTypeNameList.size() == 0 || salesTypeNameList == null)) {

			masSalesType.setSalesTypeCode(code);
			masSalesType.setSalesTypeName(name);
			masSalesType.setSalesTypeValue(salesTypeValue);
			masSalesType.setStatus("y");
			masSalesType.setLastChgBy(changedBy);
			masSalesType.setLastChgDate(currentDate);
			masSalesType.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addSalesType(masSalesType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((salesTypeCodeList.size() != 0 || salesTypeCodeList != null)
				|| (salesTypeNameList.size() != 0) || salesTypeNameList != null) {
			if ((salesTypeCodeList.size() != 0 || salesTypeCodeList != null)
					&& (salesTypeNameList.size() == 0 || salesTypeNameList == null)) {
				message = "Sales Type Code already exists.";
			} else if ((salesTypeNameList.size() != 0 || salesTypeNameList != null)
					&& (salesTypeCodeList.size() == 0 || salesTypeCodeList == null)) {
				message = "Sales Type Name already exists.";
			} else if ((salesTypeCodeList.size() != 0 || salesTypeCodeList != null)
					&& (salesTypeNameList.size() != 0 || salesTypeNameList != null)) {
				message = "Sales Type Code and Sales Type exist.";
			}
		}

		url = "/hms/hms/pharmacy?method=showSalesTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showSalesTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TYPE_JSP;
		title = "Add Sales Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteSalesType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int salesTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			salesTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteSalesType(salesTypeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}

		url = "/hms/hms/pharmacy?method=showSalesType";
		try {
			map = pharmacyMasterHandlerService.showSalesTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TYPE_JSP;
		title = "Delete Sales Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editSalesType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String salesTypeCode = "";
		String salesTypeName = "";
		int salesTypeValue = 0;
		int salesTypeId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		try {
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				salesTypeId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(SALES_TYPE_VALUE) != null
					&& !(request.getParameter(SALES_TYPE_VALUE).equals(""))) {
				salesTypeValue = Integer.parseInt(request
						.getParameter(SALES_TYPE_VALUE));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				salesTypeCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				salesTypeName = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
		} catch (Exception e) {
		}

		changedDate = new Date();
		try {
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", salesTypeId);
			generalMap.put("salesTypeCode", salesTypeCode);
			generalMap.put("name", salesTypeName);
			generalMap.put("salesTypeValue", salesTypeValue);
			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			@SuppressWarnings("unused")
			MasSalesType masSalesType = new MasSalesType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean dataUpdated = false;
		try {
			dataUpdated = pharmacyMasterHandlerService
					.editSalesType(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}

		url = "/hms/hms/pharmacy?method=showSalesType";
		try {
			map = pharmacyMasterHandlerService.showSalesTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = SALES_TYPE_JSP;
		title = "Edit Sales Type";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// --------------------Store Section
	// Report-------------------------------------------------------

	public ModelAndView reportStoreSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Section", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// --------------------------------------Store
	// Section-------------------------------------------

	public ModelAndView searchStoreSection(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String sectionCode = null;
		String sectionName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sectionCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sectionName = request.getParameter(SEARCH_NAME);
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
			sectionCode = searchField;
			sectionName = null;
		} else {
			sectionCode = null;
			sectionName = searchField;
		}

		map = pharmacyMasterHandlerService.searchStoreSection(sectionCode,
				sectionName);
		jsp = STORE_SECTION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("title", title);
		map.put("sectionCode", sectionCode);
		map.put("sectionName", sectionName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showStoreSectionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreSectionJsp();
		@SuppressWarnings("unused")
		ArrayList searchStoreSectionList = (ArrayList) map
				.get("searchStoreSectionList");
		jsp = STORE_SECTION_JSP;
		jsp += ".jsp";
		title = "StoreSection";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreSection masStoreSection = new MasStoreSection();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int itemTypeId = 0;
		int userId = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("itemTypeId") != null) {
			itemTypeId = Integer.parseInt(request.getParameter("itemTypeId"));
		}
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List sectionCodeList = new ArrayList();
		List sectionNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			sectionCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			sectionNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((sectionCodeList.size() == 0 || sectionCodeList == null)
				&& (sectionNameList.size() == 0 || sectionNameList == null)) {
			masStoreSection.setSectionCode(code);
			masStoreSection.setSectionName(name);
			MasItemType masItemType = new MasItemType();
			masItemType.setId(itemTypeId);
			masStoreSection.setItemType(masItemType);
			masStoreSection.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masStoreSection.setLastChgBy(users);
			masStoreSection.setLastChgDate(currentDate);
			masStoreSection.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addStoreSection(masStoreSection);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((sectionCodeList.size() != 0 || sectionCodeList != null)
				|| (sectionNameList.size() != 0) || sectionNameList != null) {

			if ((sectionCodeList.size() != 0 || sectionCodeList != null)
					&& (sectionNameList.size() == 0 || sectionNameList == null)) {

				message = "Section Code  already exists.";
			} else if ((sectionNameList.size() != 0 || sectionNameList != null)
					&& (sectionCodeList.size() == 0 || sectionCodeList == null)) {

				message = "Section Name already exists.";
			} else if ((sectionCodeList.size() != 0 || sectionCodeList != null)
					&& (sectionNameList.size() != 0 || sectionNameList != null)) {

				message = "Section Code and Section Name already exist.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";

		try {
			map = pharmacyMasterHandlerService.showStoreSectionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SECTION_JSP;
		title = "Add StoreSection";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editStoreSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String sectionCode = "";
		String sectionName = "";
		int sectionId = 0;
		int userId = 0;
		Date changedDate = null;
		String changedTime = "";
		int itemTypeId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			sectionCode = request.getParameter(CODE);
		}
		if (request.getParameter("itemTypeId") != null) {
			itemTypeId = Integer.parseInt(request.getParameter("itemTypeId"));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			sectionName = request.getParameter(SEARCH_NAME);
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
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", sectionId);
		generalMap.put("sectionCode", sectionCode);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("name", sectionName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingStoreSectionNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingStoreSectionNameList.size() == 0) {
			dataUpdated = pharmacyMasterHandlerService
					.editStoreSectionToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingStoreSectionNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";

		try {
			map = pharmacyMasterHandlerService.showStoreSectionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SECTION_JSP;
		title = "edit StoreSection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteStoreSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sectionId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			sectionId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		session = request.getSession();
		if (session.getAttribute("userId") != null){
			userId = Integer.parseInt(session.getAttribute("userId").toString());
		}	
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteStoreSection(
				sectionId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreSectionJsp";

		try {
			map = pharmacyMasterHandlerService.showStoreSectionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SECTION_JSP;
		title = "delete StoreSection";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Store Supplier Type
	// Report-------------------------------------------------------

	public ModelAndView reportStoreSupplierType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Supplier_Type", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------------- Store Supplier
	// Type-----------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showStoreSupplierTypeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
		jsp = STORE_SUPPLIER_TYPE_JSP;
		jsp += ".jsp";
		title = "StoreSupplierType";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchStoreSupplierType(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String storeSupplierTypeCode = null;
		String storeSupplierTypeName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			storeSupplierTypeCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			storeSupplierTypeName = request.getParameter(SEARCH_NAME);
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
			storeSupplierTypeCode = searchField;
			storeSupplierTypeName = null;

		} else {
			storeSupplierTypeCode = null;
			storeSupplierTypeName = searchField;
		}

		map = pharmacyMasterHandlerService.searchStoreSupplierType(
				storeSupplierTypeCode, storeSupplierTypeName);
		jsp = STORE_SUPPLIER_TYPE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("storeSupplierTypeCode", storeSupplierTypeCode);
		map.put("storeSupplierTypeName", storeSupplierTypeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreSupplierType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId=0;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List storeSupplierTypeCodeList = new ArrayList();
		List storeSupplierTypeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			storeSupplierTypeCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			storeSupplierTypeNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((storeSupplierTypeCodeList.size() == 0 || storeSupplierTypeCodeList == null)
				&& (storeSupplierTypeNameList.size() == 0 || storeSupplierTypeNameList == null)) {
			masStoreSupplierType.setSupplierTypeCode(code);
			masStoreSupplierType.setSupplierTypeName(name);
			masStoreSupplierType.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masStoreSupplierType.setLastChgBy(users);
			masStoreSupplierType.setLastChgDate(currentDate);
			masStoreSupplierType.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addStoreSupplierType(masStoreSupplierType);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null)
				|| (storeSupplierTypeNameList.size() != 0)
				|| storeSupplierTypeNameList != null) {
			if ((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null)
					&& (storeSupplierTypeNameList.size() == 0 || storeSupplierTypeNameList == null)) {

				message = "SST Code  already exists.";
			} else if ((storeSupplierTypeNameList.size() != 0 || storeSupplierTypeNameList != null)
					&& (storeSupplierTypeCodeList.size() == 0 || storeSupplierTypeCodeList == null)) {

				message = "SST Name already exists.";
			} else if ((storeSupplierTypeCodeList.size() != 0 || storeSupplierTypeCodeList != null)
					&& (storeSupplierTypeNameList.size() != 0 || storeSupplierTypeNameList != null)) {

				message = "SST Code and SST Name already exist.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SUPPLIER_TYPE_JSP;
		title = "Add StoreSupplierType";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editStoreSupplierType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		int storeSupplierTypeId = 0;
		Date changedDate = null;
		String changedTime = "";
		String changedBy = null;
		int userId=0;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			storeSupplierTypeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", storeSupplierTypeId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingStoreSupplierTypeNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingStoreSupplierTypeNameList.size() == 0) {

			dataUpdated = pharmacyMasterHandlerService
					.editStoreSupplierTypeToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant Be Updated !!";
			}
		} else if (existingStoreSupplierTypeNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SUPPLIER_TYPE_JSP;
		title = "Update Store Supplier Type ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteStoreSupplierType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int storeSupplierTypeId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		int userId=0;
		 HttpSession session = request.getSession();
		 if (session.getAttribute("userId") != null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
			}
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			storeSupplierTypeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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

		generalMap.put("changedBy", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteStoreSupplierType(
				storeSupplierTypeId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreSupplierTypeJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreSupplierTypeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SUPPLIER_TYPE_JSP;
		title = "delete StoreSupplierType";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// --------------------Manufacturer
	// Report-------------------------------------------------------

	public ModelAndView reportManufacturer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Manufacturer", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------------------------Manufacturer----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showManufacturerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showManufacturerJsp();
		jsp = MANUFACTURER_JSP;
		jsp += ".jsp";
		title = "Manufacturer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchManufacturer(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String manufacturerCode = null;
		String manufacturerName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			manufacturerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			manufacturerName = request.getParameter(SEARCH_NAME);
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
			manufacturerCode = searchField;
			manufacturerName = null;

		} else {
			manufacturerCode = null;
			manufacturerName = searchField;
		}
		map = pharmacyMasterHandlerService.searchManufacturer(manufacturerCode,
				manufacturerName);
		jsp = MANUFACTURER_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("manufacturerCode", manufacturerCode);
		map.put("manufacturerName", manufacturerName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addManufacturer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasManufacturer masManufacturer = new MasManufacturer();
		int userId = 0;
		String contactPerson = "";
		
		int cityId1 = 0;
		int cityId2 = 0;
		int cityId3 = 0;
		int stateId1 = 0;
		int stateId2 = 0;
		int stateId3 = 0;
		String mobileNo1 = "";
		int  mobileNo2 = 0;
		int mobileNo3 = 0;
		String emailId1 = "";
		String emailId2 = "";
		String emailId3 = "";
		//String faxNo = "";
		String url1 = "";
		String url2 = "";
		String url3 = "";
		String licenceNo1 = "";
		String licenceNo2 = "";
		String licenceNo3 = "";
		//String salesTaxNo = "";

		String cfDistributorName1 = "";
		String cfDistributorName2 = "";
		String cfDistributorName3 = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String cfDistributorAddress3 = "";

		int pinCode1 = 0;
		int pinCode2 = 0;
		int pinCode3 = 0;
		int tinNo1 = 0;
		int tinNo2 = 0;
		int tinNo3 = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CONTACT_PERSON) != null) {
			contactPerson = request.getParameter(CONTACT_PERSON);
		}
		if (request.getParameter(CF_DISTRIBUTOR_NAME1) != null) {
			cfDistributorName1 = request.getParameter(CF_DISTRIBUTOR_NAME1);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
			cfDistributorAddress1 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS1);
		}
		
		if (!request.getParameter(STATE_ID1).equals("0")) {
			stateId1 = Integer.parseInt(request.getParameter(STATE_ID1));
		}
		if (!request.getParameter(DISTRICT_ID1).equals("0")) {
			cityId1 = Integer.parseInt(request.getParameter(DISTRICT_ID1));
		}
		if (!request.getParameter(PINCODE1).equals("0")
				&& !request.getParameter(PINCODE1).equals("")) {
			pinCode1 = Integer.parseInt(request.getParameter(PINCODE1));
		}
		if (request.getParameter(MOBILE_NO1) != null && !request.getParameter(MOBILE_NO1).equals("")) {
			mobileNo1 = request.getParameter(MOBILE_NO1);
		}
		
		if (request.getParameter(TIN_NO1) != null && !request.getParameter(TIN_NO1).equals("")) {
			tinNo1 =Integer.parseInt(request.getParameter(TIN_NO1));
		}
		if (request.getParameter(LICENCE_NO1) != null && !request.getParameter(LICENCE_NO1).equals("")) {
			licenceNo1 = request.getParameter(LICENCE_NO1);
		}
		if (request.getParameter(EMAIL_ID1) != null) {
			emailId1 = request.getParameter(EMAIL_ID1);
		}

		if (request.getParameter(URL1) != null) {
			url1 = request.getParameter(URL1);
		}
		
		if (request.getParameter(CF_DISTRIBUTOR_NAME2) != null) {
			cfDistributorName2 = request.getParameter(CF_DISTRIBUTOR_NAME2);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}
		
		if (!request.getParameter(STATE_ID2).equals("0")) {
			stateId2 = Integer.parseInt(request.getParameter(STATE_ID2));
		}
		if (!request.getParameter(DISTRICT_ID2).equals("0")) {
			cityId2 = Integer.parseInt(request.getParameter(DISTRICT_ID2));
		}
		if (!request.getParameter(PINCODE2).equals("0")
				&& !request.getParameter(PINCODE2).equals("")) {
			pinCode2 = Integer.parseInt(request.getParameter(PINCODE2));
		}
		if (request.getParameter(MOBILE_NO2) != null && !request.getParameter(MOBILE_NO2).equals("")) {
			mobileNo2 =Integer.parseInt(request.getParameter(MOBILE_NO2));
		}
		
		if (request.getParameter(TIN_NO2) != null && !request.getParameter(TIN_NO2).equals("")) {
			tinNo2 =Integer.parseInt(request.getParameter(TIN_NO2));
		}
		if (request.getParameter(LICENCE_NO2) != null && !request.getParameter(LICENCE_NO2).equals("")) {
			licenceNo2 = request.getParameter(LICENCE_NO2);
		}
		if (request.getParameter(EMAIL_ID2) != null) {
			emailId2 = request.getParameter(EMAIL_ID2);
		}

		if (request.getParameter(URL2) != null) {
			url2 = request.getParameter(URL2);
		}
		
		if (request.getParameter(CF_DISTRIBUTOR_NAME3) != null) {
			cfDistributorName3 = request.getParameter(CF_DISTRIBUTOR_NAME3);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS3) != null) {
			cfDistributorAddress3 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS3);
		}
		
		if (!request.getParameter(STATE_ID3).equals("0")) {
			stateId3 = Integer.parseInt(request.getParameter(STATE_ID3));
		}
		if (!request.getParameter(DISTRICT_ID3).equals("0")) {
			cityId3 = Integer.parseInt(request.getParameter(DISTRICT_ID3));
		}
		if (!request.getParameter(PINCODE3).equals("0")
				&& !request.getParameter(PINCODE3).equals("")) {
			pinCode3 = Integer.parseInt(request.getParameter(PINCODE3));
		}
		if (request.getParameter(MOBILE_NO3) != null && !request.getParameter(MOBILE_NO3).equals("")) {
			mobileNo3 =Integer.parseInt(request.getParameter(MOBILE_NO3));
		}
		
		if (request.getParameter(TIN_NO3) != null && !request.getParameter(TIN_NO3).equals("")) {
			tinNo3 =Integer.parseInt(request.getParameter(TIN_NO3));
		}
		if (request.getParameter(LICENCE_NO3) != null && !request.getParameter(LICENCE_NO3).equals("")) {
			licenceNo3 = request.getParameter(LICENCE_NO3);
		}
		if (request.getParameter(EMAIL_ID3) != null) {
			emailId3 = request.getParameter(EMAIL_ID3);
		}

		if (request.getParameter(URL3) != null) {
			url3 = request.getParameter(URL3);
		}
			
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		
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

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List manufacturerCodeList = new ArrayList();
		List manufacturerNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			manufacturerCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			manufacturerNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((manufacturerCodeList.size() == 0 || manufacturerCodeList == null)
				&& (manufacturerNameList.size() == 0 || manufacturerNameList == null)) {
			try {
				masManufacturer.setManufacturerCode(code);
				masManufacturer.setManufacturerName(name);
				masManufacturer.setContactPerson(contactPerson);
				//masManufacturer.setAddress1(address1);
				//masManufacturer.setAddress2(address2);
				masManufacturer.setCfLocalDistributorName(cfDistributorName1);
				masManufacturer.setCfLocalDistributorAddress1(cfDistributorAddress1);
				if (cityId1 != 0) {
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(cityId1);
					masManufacturer.setCity(masDistrict);
				}
				if (stateId1 != 0) {
					MasState masState = new MasState();
					masState.setId(stateId1);
					masManufacturer.setState(masState);
				}
				masManufacturer.setPinCode(pinCode1);
				masManufacturer.setLicenceNo(licenceNo1);
				masManufacturer.setMobileno(mobileNo1);
				masManufacturer.setEmailId(emailId1);
				masManufacturer.setTinNo1(tinNo1);
				masManufacturer.setUrl(url1);
				
				masManufacturer.setCfLocalDistributorName2(cfDistributorName2);
				masManufacturer.setCfLocalDistributorAddress2(cfDistributorAddress2);
				if (cityId2 != 0) {
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(cityId2);
					masManufacturer.setDistrict2(masDistrict);
				}
				if (stateId2 != 0) {
					MasState masState = new MasState();
					masState.setId(stateId2);
					masManufacturer.setState2(masState);
				}
				masManufacturer.setPinCode2(pinCode2);
				masManufacturer.setLicenceNo2(licenceNo2);
				masManufacturer.setMobileno2(mobileNo2);
				masManufacturer.setEmailId2(emailId2);
				masManufacturer.setTinNo2(tinNo2);
				masManufacturer.setUrl2(url2);
				
				masManufacturer.setCfLocalDistributorName3(cfDistributorName3);
				masManufacturer.setCfLocalDistributorAddress3(cfDistributorAddress3);
				if (cityId3 != 0) {
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(cityId3);
					masManufacturer.setDistrict3(masDistrict);
				}
				if (stateId3 != 0) {
					MasState masState = new MasState();
					masState.setId(stateId3);
					masManufacturer.setState3(masState);
				}
				masManufacturer.setPinCode3(pinCode3);
				masManufacturer.setLicenceNo3(licenceNo3);
				masManufacturer.setMobileno3(mobileNo3);
				masManufacturer.setEmailId3(emailId3);
				masManufacturer.setTinNo3(tinNo3);
				masManufacturer.setUrl3(url3);
				
				masManufacturer.setStatus("y");
				
				Users users = new Users();
				users.setId(userId);
				masManufacturer.setLastChgBy(users);
				
				masManufacturer.setLastChgDate(currentDate);
				masManufacturer.setLastChgTime(currentTime);
				successfullyAdded = pharmacyMasterHandlerService
						.addManufacturer(masManufacturer);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if ((manufacturerCodeList.size() != 0 || manufacturerCodeList != null)
				|| (manufacturerNameList.size() != 0)
				|| manufacturerNameList != null) {
			if ((manufacturerCodeList.size() != 0 || manufacturerCodeList != null)
					&& (manufacturerNameList.size() == 0 || manufacturerNameList == null)) {
				message = "Manufacturer Code already exists.";
			} else if ((manufacturerNameList.size() != 0 || manufacturerNameList != null)
					&& (manufacturerCodeList.size() == 0 || manufacturerCodeList == null)) {
				message = "Manufacturer Name already exists.";
			} else if ((manufacturerCodeList.size() != 0 || manufacturerCodeList != null)
					&& (manufacturerNameList.size() != 0 || manufacturerNameList != null)) {
				message = "Manufacturer Code and Manufacturer exist.";
			}
		}
		try {
			map = pharmacyMasterHandlerService.showManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MANUFACTURER_JSP;
		title = "Add Manufacturer ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editManufacturer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int manufacturerId = 0;
		String manufacturerCode = "";
		String manufacturerName = "";
		String contactPerson = "";
		int cityId1 = 0;
		int cityId2 = 0;
		int cityId3 = 0;
		int stateId1 = 0;
		int stateId2 = 0;
		int stateId3 = 0;
		String mobileNo1 = "";
		int  mobileNo2 = 0;
		int mobileNo3 = 0;
		String emailId1 = "";
		String emailId2 = "";
		String emailId3 = "";
		//String faxNo = "";
		String url1 = "";
		String url2 = "";
		String url3 = "";
		String licenceNo1 = "";
		String licenceNo2 = "";
		String licenceNo3 = "";
		//String salesTaxNo = "";

		String cfDistributorName1 = "";
		String cfDistributorName2 = "";
		String cfDistributorName3 = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String cfDistributorAddress3 = "";

		int pinCode1 = 0;
		int pinCode2 = 0;
		int pinCode3 = 0;
		int tinNo1 = 0;
		int tinNo2 = 0;
		int tinNo3 = 0;
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			manufacturerId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			manufacturerCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			manufacturerName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CONTACT_PERSON) != null
				&& !(request.getParameter(CONTACT_PERSON).equals(""))) {
			contactPerson = request.getParameter(CONTACT_PERSON);
		}
		if (request.getParameter(CF_DISTRIBUTOR_NAME1) != null) {
			cfDistributorName1 = request.getParameter(CF_DISTRIBUTOR_NAME1);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
			cfDistributorAddress1 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS1);
		}
		
		if (!request.getParameter(STATE_ID1).equals("0")) {
			stateId1 = Integer.parseInt(request.getParameter(STATE_ID1));
		}
		if (!request.getParameter(DISTRICT_ID1).equals("0")) {
			cityId1 = Integer.parseInt(request.getParameter(DISTRICT_ID1));
		}
		if (!request.getParameter(PINCODE1).equals("0")
				&& !request.getParameter(PINCODE1).equals("")) {
			pinCode1 = Integer.parseInt(request.getParameter(PINCODE1));
		}
		if (request.getParameter(MOBILE_NO1) != null) {
			mobileNo1 = request.getParameter(MOBILE_NO1);
		}
		
		if (request.getParameter(TIN_NO1) != null && !request.getParameter(TIN_NO1).equals("")) {
			tinNo1 =Integer.parseInt(request.getParameter(TIN_NO1));
		}
		if (request.getParameter(LICENCE_NO1) != null) {
			licenceNo1 = request.getParameter(LICENCE_NO1);
		}
		if (request.getParameter(EMAIL_ID1) != null) {
			emailId1 = request.getParameter(EMAIL_ID1);
		}

		if (request.getParameter(URL1) != null) {
			url1 = request.getParameter(URL1);
		}
		
		if (request.getParameter(CF_DISTRIBUTOR_NAME2) != null) {
			cfDistributorName2 = request.getParameter(CF_DISTRIBUTOR_NAME2);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}
		
		if (!request.getParameter(STATE_ID2).equals("0")) {
			stateId2 = Integer.parseInt(request.getParameter(STATE_ID2));
		}
		if (!request.getParameter(DISTRICT_ID2).equals("0")) {
			cityId2 = Integer.parseInt(request.getParameter(DISTRICT_ID2));
		}
		if (!request.getParameter(PINCODE2).equals("0")
				&& !request.getParameter(PINCODE2).equals("")) {
			pinCode2 = Integer.parseInt(request.getParameter(PINCODE2));
		}
		if (request.getParameter(MOBILE_NO2) != null && !request.getParameter(MOBILE_NO2).equals("")) {
			mobileNo2 =Integer.parseInt(request.getParameter(MOBILE_NO2));
		}
		
		if (request.getParameter(TIN_NO2) != null && !request.getParameter(TIN_NO2).equals("")) {
			tinNo2 =Integer.parseInt(request.getParameter(TIN_NO2));
		}
		if (request.getParameter(LICENCE_NO2) != null) {
			licenceNo2 = request.getParameter(LICENCE_NO2);
		}
		if (request.getParameter(EMAIL_ID2) != null) {
			emailId2 = request.getParameter(EMAIL_ID2);
		}

		if (request.getParameter(URL2) != null) {
			url2 = request.getParameter(URL2);
		}
		
		if (request.getParameter(CF_DISTRIBUTOR_NAME3) != null) {
			cfDistributorName3 = request.getParameter(CF_DISTRIBUTOR_NAME3);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS3) != null) {
			cfDistributorAddress3 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS3);
		}
		
		if (!request.getParameter(STATE_ID3).equals("0")) {
			stateId3 = Integer.parseInt(request.getParameter(STATE_ID3));
		}
		if (!request.getParameter(DISTRICT_ID3).equals("0")) {
			cityId3 = Integer.parseInt(request.getParameter(DISTRICT_ID3));
		}
		if (!request.getParameter(PINCODE3).equals("0")
				&& !request.getParameter(PINCODE3).equals("")) {
			pinCode3 = Integer.parseInt(request.getParameter(PINCODE3));
		}
		if (request.getParameter(MOBILE_NO3) != null && !request.getParameter(MOBILE_NO3).equals("")) {
			mobileNo3 =Integer.parseInt(request.getParameter(MOBILE_NO3));
		}
		
		if (request.getParameter(TIN_NO3) != null && !request.getParameter(TIN_NO3).equals("")) {
			tinNo3 =Integer.parseInt(request.getParameter(TIN_NO3));
		}
		if (request.getParameter(LICENCE_NO3) != null) {
			licenceNo3 = request.getParameter(LICENCE_NO3);
		}
		if (request.getParameter(EMAIL_ID3) != null) {
			emailId3 = request.getParameter(EMAIL_ID3);
		}

		if (request.getParameter(URL3) != null) {
			url3 = request.getParameter(URL3);
		}
		
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		try {
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", manufacturerId);
			generalMap.put("manufacturerCode", manufacturerCode);
			generalMap.put("name", manufacturerName);
			generalMap.put("contactPerson", contactPerson);
			generalMap.put("cfDistributorName1", cfDistributorName1);
			generalMap.put("cfDistributorAddress1", cfDistributorAddress1);
			generalMap.put("cityId1", cityId1);
			generalMap.put("stateId1", stateId1);
			generalMap.put("pinCode1", pinCode1);
			generalMap.put("licenceNo1", licenceNo1);
			generalMap.put("tinNo1", tinNo1);
			generalMap.put("mobileNo1", mobileNo1);
			generalMap.put("emailId1", emailId1);
			generalMap.put("url1", url1);
			
			generalMap.put("cfDistributorName2", cfDistributorName2);
			generalMap.put("cfDistributorAddress2", cfDistributorAddress2);
			generalMap.put("cityId2", cityId2);
			generalMap.put("stateId2", stateId2);
			generalMap.put("pinCode2", pinCode2);
			generalMap.put("licenceNo2", licenceNo2);
			generalMap.put("tinNo2", tinNo2);
			generalMap.put("mobileNo2", mobileNo2);
			generalMap.put("emailId2", emailId2);
			generalMap.put("url2", url2);
			
			generalMap.put("cfDistributorName3", cfDistributorName3);
			generalMap.put("cfDistributorAddress3", cfDistributorAddress3);
			generalMap.put("cityId3", cityId3);
			generalMap.put("stateId3", stateId3);
			generalMap.put("pinCode3", pinCode3);
			generalMap.put("licenceNo3", licenceNo3);
			generalMap.put("tinNo3", tinNo3);
			generalMap.put("mobileNo3", mobileNo3);
			generalMap.put("emailId3", emailId3);
			generalMap.put("url3", url3);
			
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);

		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editManufacturerToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showManufacturerJsp";
		try {
			map = pharmacyMasterHandlerService.showManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MANUFACTURER_JSP;
		title = "Update Manufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteManufacturer(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int manufacturerId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			manufacturerId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteManufacturer(
				manufacturerId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showManufacturerJsp";
		try {
			map = pharmacyMasterHandlerService.showManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = MANUFACTURER_JSP;
		title = "Delete manufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Store Supplier
	// Report-------------------------------------------------------

	public ModelAndView reportStoreSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item_Supplier", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------For Store Supplier
	// Master-------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showStoreSupplierJsp(HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();

		map = pharmacyMasterHandlerService.showStoreSupplierJsp();
		jsp = STORE_SUPPLIER_JSP;
		jsp += ".jsp";
		title = " Supplier";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreSupplier masStoreSupplier = new MasStoreSupplier();
		MasManufacturer masManufacturer = new MasManufacturer();

		int storeSupplierTypeId = 0;
		String changedBy = "";

		String pinNo = "";
		String tinNo = "";
		String licenceNo = "";
		String salesTaxNo = "";
		String typeOfReg = "";

		String address1 = "";
		String address2 = "";
		int city = 0;
		int state = 0;
		String phoneNo = "";
		String mobileNo = "";
		int pinCode = 0;
		String emailId = "";
		String faxNo = "";
		String url = "";
		int groupId = 0;

		String localAddress1 = "";
		String localAddress2 = "";
		int localCity = 0;
		String localPhoneNo = "";
		int localPinCode = 0;
		int localState = 0;

		String fdrReceiptAttached = "";

		String cfDistributorName = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";

		String[] manufacturerIdArray = null;
		String[] groupIdArray = null;

		StringBuffer manufacturerStr = new StringBuffer();
		StringBuffer groupStr = new StringBuffer();

		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(STORE_SUPPLIER_TYPE_ID) != null) {
			storeSupplierTypeId = Integer.parseInt(request
					.getParameter(STORE_SUPPLIER_TYPE_ID));
		}
		if (request.getParameter(PIN_NUMBER) != null) {
			pinNo = request.getParameter(PIN_NUMBER);
		}
		if (request.getParameter(TIN_NUMBER) != null) {
			tinNo = request.getParameter(TIN_NUMBER);
		}
		if (request.getParameter(ADDRESS1) != null) {
			address1 = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			address2 = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(LOCAL_ADDRESS1) != null) {
			localAddress1 = request.getParameter(LOCAL_ADDRESS1);
		}
		if (request.getParameter(LOCAL_ADDRESS2) != null) {
			localAddress2 = request.getParameter(LOCAL_ADDRESS2);
		}
		if (!request.getParameter(DISTRICT).equals("0")) {
			city = Integer.parseInt(request.getParameter(DISTRICT));
		}
		if (!request.getParameter(STATE).equals("0")) {
			state = Integer.parseInt(request.getParameter(STATE));
		}
		if (!request.getParameter(LOCAL_CITY).equals("0")) {
			localCity = Integer.parseInt(request.getParameter(LOCAL_CITY));
		}
		if (!request.getParameter(LOCAL_STATE).equals("0")) {
			localState = Integer.parseInt(request.getParameter(LOCAL_STATE));
		}
		if (request.getParameter(PHONE_NO) != null) {
			phoneNo = request.getParameter(PHONE_NO);
		}
		if (request.getParameter(LOCAL_PHONE_NO) != null) {
			localPhoneNo = request.getParameter(LOCAL_PHONE_NO);
		}
		if (request.getParameter(MOBILE_NO) != null) {
			mobileNo = request.getParameter(MOBILE_NO);
		}
		if (!request.getParameter(PINCODE).equals("0")
				&& !request.getParameter(PINCODE).equals("")) {
			pinCode = Integer.parseInt(request.getParameter(PINCODE));
		}
		if (!request.getParameter(LOCAL_PINCODE).equals("0")
				&& !request.getParameter(LOCAL_PINCODE).equals("")) {
			localPinCode = Integer
					.parseInt(request.getParameter(LOCAL_PINCODE));
		}

		if (request.getParameter(TYPE_OF_REG) != null) {
			typeOfReg = request.getParameter(TYPE_OF_REG);
		}
		if (request.getParameterValues(MANUFACTURER_ID) != null
				&& !request.getParameterValues(MANUFACTURER_ID).equals("0")) {
			manufacturerIdArray = (String[]) (request
					.getParameterValues(MANUFACTURER_ID));
			for (int i = 0; i < manufacturerIdArray.length; i++) {
				manufacturerStr.append(manufacturerIdArray[i]);
				manufacturerStr.append(",");
			}
			manufacturerStr.deleteCharAt(manufacturerStr.length() - 1);
			generalMap.put("manufacturerStr", manufacturerStr.toString());
		}
		if (request.getParameterValues(GROUP_ID) != null
				&& !request.getParameterValues(GROUP_ID).equals("0")) {
			groupIdArray = (String[]) (request.getParameterValues(GROUP_ID));
			for (int i = 0; i < groupIdArray.length; i++) {
				groupStr.append(groupIdArray[i]);
				groupStr.append(",");
			}
			groupStr.deleteCharAt(groupStr.length() - 1);
			generalMap.put("groupStr", groupStr.toString());
		}

		if (request.getParameter(LICENCE_NO) != LICENCE_NO) {
			licenceNo = request.getParameter(PHONE_NO);
		}
		if (request.getParameter(SALES_TAX_NO) != null) {
			salesTaxNo = request.getParameter(SALES_TAX_NO);
		}
		if (request.getParameter(EMAIL_ID) != null) {
			emailId = request.getParameter(EMAIL_ID);
		}
		if (request.getParameter(FAX_NO) != null) {
			faxNo = request.getParameter(FAX_NO);
		}
		if (request.getParameter(URL) != null) {
			url = request.getParameter(URL);
		}

		if (request.getParameter(CF_DISTRIBUTOR_NAME) != null) {
			cfDistributorName = request.getParameter(CF_DISTRIBUTOR_NAME);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
			cfDistributorAddress1 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS1);
		}
		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}

		if (request.getParameter("FDR") != null) {
			fdrReceiptAttached = request.getParameter("FDR");
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
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		
		
		generalMap.put("code", code);
		generalMap.put("name", name);
	

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		try {

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List supplierCodeList = new ArrayList();
		List supplierNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			supplierCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			supplierNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;

		if ((supplierCodeList == null || supplierCodeList.size() == 0)
				&& (supplierNameList == null || supplierNameList.size() == 0)) {

			masStoreSupplier.setSupplierCode(code);
			masStoreSupplier.setSupplierName(name);

			MasStoreSupplierType masStoreSupplierType = new MasStoreSupplierType();
			masStoreSupplierType.setId(storeSupplierTypeId);
			masStoreSupplier.setSupplierType(masStoreSupplierType);

			masStoreSupplier.setTinNo(tinNo);
			masStoreSupplier.setSalesTaxNo(salesTaxNo);

			masStoreSupplier.setTypeOfReg(typeOfReg);
			masStoreSupplier.setLicenceNo(licenceNo);

			masStoreSupplier.setPinNo(pinNo);

			masStoreSupplier.setAddress1(address1);
			masStoreSupplier.setAddress2(address2);

			masStoreSupplier.setCfLocalDistributorName(cfDistributorName);
			masStoreSupplier
					.setCfLocalDistributorAddress1(cfDistributorAddress1);
			masStoreSupplier
					.setCfLocalDistributorAddress2(cfDistributorAddress2);
			masStoreSupplier.setFdrReceiptAttached(fdrReceiptAttached);

			if (city != 0) {
				MasDistrict masDistrict = new MasDistrict();
				masDistrict.setId(city);
				masStoreSupplier.setCity(masDistrict);
			} else {
				masStoreSupplier.setCity(null);
			}

			if (state != 0) {
				MasState masState = new MasState();
				masState.setId(state);
				masStoreSupplier.setState(masState);
			} else {
				masStoreSupplier.setState(null);
			}

			masStoreSupplier.setFaxNumber(faxNo);

			masStoreSupplier.setPhoneNo(phoneNo);

			masStoreSupplier.setMobileNo(mobileNo);

			masStoreSupplier.setPinCode(pinCode);

			masStoreSupplier.setEmailId(emailId);

			masStoreSupplier.setUrl(url);
			masStoreSupplier.setLocalAddress1(localAddress1);
			masStoreSupplier.setLocalAddress2(localAddress2);

			if (localCity != 0) {
				MasDistrict masDistrictLocal = new MasDistrict();
				masDistrictLocal.setId(localCity);
				masStoreSupplier.setLocalCity(masDistrictLocal);
			} else {
				masStoreSupplier.setLocalCity(null);
			}

			if (localState != 0) {
				MasState masStateLocal = new MasState();
				masStateLocal.setId(localState);
				masStoreSupplier.setLocalState(masStateLocal);
			} else {
				masStoreSupplier.setLocalState(null);
			}

			masStoreSupplier.setLocalPinCode(localPinCode);
			masStoreSupplier.setLocalPhoneNo(localPhoneNo);

			masStoreSupplier.setStatus("y");
			
			Users user= new Users();
			user.setId(userId);
			masStoreSupplier.setLastChgBy(user);
			
			
			masStoreSupplier.setLastChgDate(currentDate);
			masStoreSupplier.setLastChgTime(currentTime);

			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);

			/*
			 * If supplier type is Manufacturer, then the same record will be
			 * stored in Mas Manufacturer table also apart from
			 * mas_store_Supplier.
			 */
			if (storeSupplierTypeId == 2) {

				masManufacturer.setManufacturerCode(code);
				masManufacturer.setManufacturerName(name);
				masManufacturer.setStatus("y");
				masManufacturer.setSalesTaxNo(salesTaxNo);
				masManufacturer.setLicenceNo(licenceNo);
				masManufacturer.setAddress1(address1);
				masManufacturer.setAddress2(address2);
				masManufacturer.setCfLocalDistributorName(cfDistributorName);
				masManufacturer
						.setCfLocalDistributorAddress1(cfDistributorAddress1);
				masManufacturer
						.setCfLocalDistributorAddress2(cfDistributorAddress2);

				if (city != 0) {
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(city);
					masStoreSupplier.setCity(masDistrict);
					masManufacturer.setCity(masDistrict);
				} else {
					masStoreSupplier.setCity(null);
					masManufacturer.setCity(null);
				}

				if (state != 0) {
					MasState masState = new MasState();
					masState.setId(state);
					masStoreSupplier.setState(masState);
					masManufacturer.setState(masState);
				} else {
					masStoreSupplier.setState(null);
					masManufacturer.setState(null);
				}

				masManufacturer.setFaxNumber(faxNo);

				masManufacturer.setPhoneno(phoneNo);

				masManufacturer.setMobileno(mobileNo);
				masManufacturer.setPinCode(pinCode);
				masManufacturer.setEmailId(emailId);
				masManufacturer.setUrl(url);
				
				Users users = new Users();
				users.setId(userId);
				masManufacturer.setLastChgBy(users);
				
				masManufacturer.setLastChgDate(currentDate);
				masManufacturer.setLastChgTime(currentTime);
				generalMap.put("masManufacturer", masManufacturer);
			}

			successfullyAdded = pharmacyMasterHandlerService.addStoreSupplier(
					masStoreSupplier, generalMap);

			if (successfullyAdded) {
				message = "Record Added Successfully";
			} else {
				message = "Try Again !";
			}

		} else if ((supplierCodeList.size() != 0 || supplierCodeList != null)
				|| (supplierNameList.size() != 0) || supplierNameList != null) {
			if ((supplierCodeList.size() != 0 || supplierCodeList != null)
					&& (supplierNameList.size() == 0 || supplierNameList == null)) {
				message = "Supplier Code already exists.";
			} else if ((supplierNameList.size() != 0 || supplierNameList != null)
					&& (supplierCodeList.size() == 0 || supplierCodeList == null)) {
				message = "Supplier Name already exists.";
			} else if ((supplierCodeList.size() != 0 || supplierCodeList != null)
					&& (supplierNameList.size() != 0 || supplierNameList != null)) {
				message = "Supplier Code and Supplier exist.";
			}
		}

		try {
			map = pharmacyMasterHandlerService.showStoreSupplierJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SUPPLIER_JSP;
		title = "Add Store Supplier ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView editStoreSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		int storeSupplierId = 0;
		int storeSupplierTypeId = 0;
		String pinNo = "";
		String tinNo = "";
		String licenceNo = "";
		String salesTaxNo = "";
		String typeOfReg = "";

		String address1 = "";
		String address2 = "";
		int city = 0;
		int state = 0;
		String phoneNo = "";
		String mobileNo = "";
		String pinCode = "";
		String emailId = "";
		String faxNo = "";
		String url = "";
		String storeSupplierCode = "";
		String storeSupplierName = "";
		String localAddress1 = "";
		String localAddress2 = "";
		int localCity = 0;
		String localPhoneNo = "";
		String localPinCode = "";
		int manuFacturerId = 0;
		int localState = 0;
		int groupId = 0;

		String cfDistributorName = "";
		String cfDistributorAddress1 = "";
		String cfDistributorAddress2 = "";
		String fdrReceiptAttached = "";

		String changedTime = "";
		Date changedDate = null;

		String[] manufacturerIdArray = null;
		String[] groupIdArray = null;
		StringBuffer manufacturerStr = new StringBuffer();
		StringBuffer groupStr = new StringBuffer();
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		storeSupplierCode = (String) session.getAttribute("storeSupplierCode");
		storeSupplierName = (String) session.getAttribute("storeSupplierName");

		if (!request.getParameter(COMMON_ID).equals("0")) {
			storeSupplierId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null) {
			storeSupplierCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			storeSupplierName = request.getParameter(SEARCH_NAME);
		}
		if (!request.getParameter(STORE_SUPPLIER_TYPE_ID).equals("0")) {
			storeSupplierTypeId = Integer.parseInt(request
					.getParameter(STORE_SUPPLIER_TYPE_ID));
		}
		if (request.getParameter(PIN_NUMBER) != null) {
			pinNo = request.getParameter(PIN_NUMBER);
		}
		if (request.getParameter(TIN_NUMBER) != null) {
			tinNo = request.getParameter(TIN_NUMBER);
		}
		if (request.getParameter(ADDRESS1) != null) {
			address1 = request.getParameter(ADDRESS1);
		}
		if (request.getParameter(ADDRESS2) != null) {
			address2 = request.getParameter(ADDRESS2);
		}
		if (request.getParameter(LOCAL_ADDRESS1) != null) {
			localAddress1 = request.getParameter(LOCAL_ADDRESS1);
		}
		if (request.getParameter(LOCAL_ADDRESS2) != null) {
			localAddress2 = request.getParameter(LOCAL_ADDRESS2);
		}
		if (!request.getParameter(DISTRICT).equals("0")) {
			city = Integer.parseInt(request.getParameter(DISTRICT));
		}
		if (!request.getParameter(STATE).equals("0")) {
			state = Integer.parseInt(request.getParameter(STATE));
		}
		if (!request.getParameter(LOCAL_CITY).equals("0")) {
			localCity = Integer.parseInt(request.getParameter(LOCAL_CITY));
		}
		if (!request.getParameter(LOCAL_STATE).equals("0")) {
			localState = Integer.parseInt(request.getParameter(LOCAL_STATE));
		}
		if (request.getParameter(PHONE_NO) != null) {
			phoneNo = request.getParameter(PHONE_NO);
		}
		if (request.getParameter(LOCAL_PHONE_NO) != null) {
			localPhoneNo = request.getParameter(LOCAL_PHONE_NO);
		}
		if (request.getParameter(MOBILE_NO) != null) {
			mobileNo = request.getParameter(MOBILE_NO);
		}

		if (request.getParameter(PINCODE)!=null &&!request.getParameter(PINCODE).equals("")
				) {
			pinCode = request.getParameter(PINCODE);
		}
		if (request.getParameter(LOCAL_PINCODE)!=null &&!request.getParameter(LOCAL_PINCODE).equals(""))
			 {
			localPinCode = request.getParameter(LOCAL_PINCODE);
		}
		/*
		 * if (!request.getParameter(PINCODE).equals("0")) { pinCode =
		 * Integer.parseInt(request.getParameter(PINCODE)); } if
		 * (!request.getParameter(LOCAL_PINCODE).equals("0")) { localPinCode =
		 * Integer.parseInt(request.getParameter(LOCAL_PINCODE)); }
		 */
		if (request.getParameter(TYPE_OF_REG) != null) {
			typeOfReg = request.getParameter(TYPE_OF_REG);
		}

		if (request.getParameter(MANUFACTURER_ID) != null
				&& !request.getParameter(MANUFACTURER_ID).equals("")) {
			manuFacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		if (request.getParameter(LICENCE_NO) != null) {
			licenceNo = request.getParameter(LICENCE_NO);
		}
		if (request.getParameter(SALES_TAX_NO) != null) {
			salesTaxNo = request.getParameter(SALES_TAX_NO);
		}
		if (request.getParameter(EMAIL_ID) != null) {
			emailId = request.getParameter(EMAIL_ID);
		}
		if (request.getParameter(FAX_NO) != null) {
			faxNo = request.getParameter(FAX_NO);
		}
		if (request.getParameter(URL) != null) {
			url = request.getParameter(URL);
		}

		if (request.getParameter(CF_DISTRIBUTOR_NAME) != null) {
			cfDistributorName = request.getParameter(CF_DISTRIBUTOR_NAME);
		}

		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS1) != null) {
			cfDistributorAddress1 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS1);
		}

		if (request.getParameter(CF_DISTRIBUTOR_ADDRESS2) != null) {
			cfDistributorAddress2 = request
					.getParameter(CF_DISTRIBUTOR_ADDRESS2);
		}

		if (request.getParameter("FDR") != null) {
			fdrReceiptAttached = request.getParameter("FDR");
		}

		if (request.getParameter(GROUP_ID) != null) {
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}

		if (request.getParameterValues(MANUFACTURER_ID) != null
				&& request.getParameterValues(MANUFACTURER_ID).length > 0) {
			manufacturerIdArray = (String[]) (request
					.getParameterValues(MANUFACTURER_ID));

			for (int i = 0; i < manufacturerIdArray.length; i++) {
				manufacturerStr.append(manufacturerIdArray[i]);
				manufacturerStr.append(",");
			}
			manufacturerStr.deleteCharAt(manufacturerStr.length() - 1);
		}

		if (request.getParameterValues(GROUP_ID) != null
				&& request.getParameterValues(GROUP_ID).length > 0) {
			groupIdArray = (String[]) (request.getParameterValues(GROUP_ID));

			for (int i = 0; i < groupIdArray.length; i++) {
				groupStr.append(groupIdArray[i]);
				groupStr.append(",");
			}
			groupStr.deleteCharAt(groupStr.length() - 1);
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

		generalMap.put("manufacturerStr", manufacturerStr.toString());
		generalMap.put("groupStr", groupStr.toString());

		generalMap.put("id", storeSupplierId);
		generalMap.put("code", storeSupplierCode);
		generalMap.put("name", storeSupplierName);
		generalMap.put("storeSupplierTypeId", storeSupplierTypeId);
		generalMap.put("tinNo", tinNo);
		generalMap.put("pinNo", pinNo);
		generalMap.put("salesTaxNo", salesTaxNo);
		generalMap.put("typeOfReg", typeOfReg);
		generalMap.put("licenceNo", licenceNo);
		generalMap.put("address1", address1);
		generalMap.put("address2", address2);
		generalMap.put("city", city);
		generalMap.put("state", state);
		generalMap.put("phoneNo", phoneNo);
		generalMap.put("mobileNo", mobileNo);
		generalMap.put("pinCode", pinCode);
		generalMap.put("emailId", emailId);
		generalMap.put("faxNo", faxNo);
		generalMap.put("url", url);
		generalMap.put("localAddress1", localAddress1);
		generalMap.put("localAddress2", localAddress2);
		generalMap.put("localCity", localCity);
		generalMap.put("localState", localState);
		generalMap.put("localPhoneNo", localPhoneNo);
		generalMap.put("manuFacturerId", manuFacturerId);
		generalMap.put("localPinCode", localPinCode);

		generalMap.put("cfDistributorName", cfDistributorName);
		generalMap.put("cfDistributorAddress1", cfDistributorAddress1);
		generalMap.put("cfDistributorAddress2", cfDistributorAddress2);
		generalMap.put("fdrReceiptAttached", fdrReceiptAttached);

		generalMap.put("groupId", groupId);

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingSupplierNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingSupplierNameList == null
				|| existingSupplierNameList.size() == 0) {
			dataUpdated = pharmacyMasterHandlerService
					.editStoreSupplierToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Record updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
		} else if (existingSupplierNameList.size() > 0) {

			message = "Name already exists.";

		}
		map = pharmacyMasterHandlerService.showStoreSupplierJsp();

		jsp = STORE_SUPPLIER_JSP;
		title = "Edit Store Supplier ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchStoreSupplier(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String storeSupplierCode = null;
		String storeSupplierName = null;
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
			storeSupplierCode = searchField;
			storeSupplierName = null;

		} else {
			storeSupplierCode = null;
			storeSupplierName = searchField;
		}
		map = pharmacyMasterHandlerService.searchStoreSupplier(
				storeSupplierCode, storeSupplierName);
		jsp = STORE_SUPPLIER_JSP;

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("storeSupplierCode", storeSupplierCode);
		map.put("storeSupplierName", storeSupplierName);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteStoreSupplier(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int storeSuppliedId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			storeSuppliedId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteStoreSupplier(
				storeSuppliedId, generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully";
		}

		else {
			message = "Record is Activated successfully";
		}
		try {
			map = pharmacyMasterHandlerService.showStoreSupplierJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_SUPPLIER_JSP;
		title = "Delete Store Supplier ";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	/*
	 * // --------------------Item Wise Supplier
	 * Report-------------------------------------------------------
	 *
	 *
	 * public ModelAndView reportItemWiseSupplier(HttpServletRequest
	 * request,HttpServletResponse response) { Map<String, Object> parameters =
	 * new HashMap<String, Object>(); Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * parameters=pharmacyMasterHandlerService.getConnection();
	 * HMSUtil.generateReport("Mas_Item_Wise_Supplier", parameters,
	 * (Connection)parameters.get("conn"), response, getServletContext());
	 * return new ModelAndView("index", "map", map); } //
	 * ---------------------------For Item Wise
	 * Supplier-----------------------------------End-----
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * showItemWiseSupplier(HttpServletRequest request, HttpServletResponse
	 * response){  String
	 * jsp=ITEM_WISE_SUPPLIER_JSP; Map<String,Object> map = new
	 * HashMap<String,Object>(); try{
	 * map=(Map)pharmacyMasterHandlerService.getItemWiseSupplier();
	 *
	 * }catch (Exception e) { log.error("Exception in
	 * getItemWiseSupplier------"+e); } jsp += ".jsp"; title = "Item Wise
	 * Suppiler"; map.put("contentJsp", jsp); map.put("title", title);
	 *
	 * return new ModelAndView("index","map",map); }
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addItemWiseSupplier(HttpServletRequest request, HttpServletResponse
	 * response){ int itemId=0; int supplierId=0; String changedBy=""; Date
	 * currentDate=new Date(); Map<String,Object> map=new
	 * HashMap<String,Object>(); try{ if(request.getParameter(ITEM_ID) != null
	 * && !(request.getParameter(ITEM_ID).equals(""))){ itemId
	 * =Integer.parseInt( request.getParameter(ITEM_ID)); }
	 * if(request.getParameter(STORE_SUPPLIER_ID) != null &&
	 * !(request.getParameter(STORE_SUPPLIER_ID).equals(""))){ supplierId
	 * =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID)); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName"); } }catch (Exception e) {
	 *  } boolean
	 * flag=pharmacyMasterHandlerService.checkItem(itemId); boolean saved=false;
	 *
	 * if(flag) { message="Item Already Exists"; }else{ MasItemWiseSupplier
	 * masStoreItemWiseSupplier=new MasItemWiseSupplier(); try{
	 *
	 * MasStoreItem masStoreItem=new MasStoreItem(); masStoreItem.setId(itemId);
	 * masStoreItemWiseSupplier.setItem(masStoreItem);
	 *
	 * MasStoreSupplier masStoreSupplier=new MasStoreSupplier();
	 * masStoreSupplier.setId(supplierId);
	 * masStoreItemWiseSupplier.setSupplier(masStoreSupplier);
	 *
	 * masStoreItemWiseSupplier.setStatus("y");
	 * masStoreItemWiseSupplier.setLastChgBy(changedBy);
	 * masStoreItemWiseSupplier.setLastChgDate(currentDate);
	 * masStoreItemWiseSupplier.setLastChgTime(currentTime); }catch (Exception
	 * e) { e.printStackTrace(); }
	 *
	 * saved=pharmacyMasterHandlerService.addItemWiseSupplier(
	 * masStoreItemWiseSupplier); if(saved){
	 * message="Record Added Successfully !!"; }else { message="Try Again !!"; }
	 * } try{ map = pharmacyMasterHandlerService.getItemWiseSupplier();
	 *
	 * }catch (Exception e) { log.error("Exception in
	 * getItemWiseSupplier "+e); } jsp= ITEM_WISE_SUPPLIER_JSP; title="Add Item
	 * Wise Supplier"; jsp += ".jsp"; map.put("contentJsp", jsp);
	 * map.put("title", title); map.put("message", message); return new
	 * ModelAndView("index", "map", map); } public ModelAndView
	 * deleteItemWiseSupplier(HttpServletRequest request, HttpServletResponse
	 * response){ Map<String, Object> map = new HashMap<String, Object>(); int
	 * itemWiseSupplierId=0; String message=null; String changedBy = ""; String
	 * changedTime = ""; Date changedDate = null;
	 * if(request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))){ itemWiseSupplierId
	 * =Integer.parseInt( request.getParameter(COMMON_ID)); }
	 * if(request.getParameter("title") != null){ title =
	 * request.getParameter("title"); } if(request.getParameter(CHANGED_BY) !=
	 * null && !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } changedDate= new Date(); changedTime
	 * = (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 *
	 * generalMap.put("changedBy", changedBy); generalMap.put("currentDate",
	 * changedDate); generalMap.put("currentTime", changedTime); boolean
	 * dataDeleted=false;
	 * dataDeleted=pharmacyMasterHandlerService.deleteItemWiseSupplier
	 * (itemWiseSupplierId,generalMap); if (dataDeleted==true) {
	 *
	 * message="Record is InActivated successfully !!"; }
	 *
	 * else{ message="Record is Activated successfully !!"; } try{ map =
	 * pharmacyMasterHandlerService.getItemWiseSupplier();
	 *
	 * }catch (Exception e) { log.error("Exception in
	 * getItemWiseSupplier "+e); } jsp= ITEM_WISE_SUPPLIER_JSP; title="Delete
	 * Item Wise Supplier"; jsp += ".jsp"; map.put("contentJsp", jsp);
	 * map.put("title", title); map.put("message", message); return new
	 * ModelAndView("index", "map", map); }
	 *
	 * public ModelAndView editItemWiseSupplier(HttpServletRequest request,
	 * HttpServletResponse response){ Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> generalMap = new
	 * HashMap<String, Object>(); int itemWiseId=0; int itemId=0; int
	 * supplierId=0; String changedBy=""; Date currentDate=new Date();
	 *
	 * try{ if(request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))){ itemWiseId
	 * =Integer.parseInt( request.getParameter(COMMON_ID)); }
	 * if(request.getParameter(ITEM_ID) != null &&
	 * !(request.getParameter(ITEM_ID).equals(""))){ itemId =Integer.parseInt(
	 * request.getParameter(ITEM_ID)); }
	 * if(request.getParameter(STORE_SUPPLIER_ID) != null &&
	 * !(request.getParameter(STORE_SUPPLIER_ID).equals(""))){ supplierId
	 * =Integer.parseInt( request.getParameter(STORE_SUPPLIER_ID)); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ currentDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 * if(request.getParameter("pojoName") != null){ pojoName =
	 * request.getParameter("pojoName"); }
	 *
	 * }catch (Exception e) { e.printStackTrace(); }
	 * generalMap.put("id",itemWiseId); generalMap.put("itemId",itemId);
	 * generalMap.put("supplierId",supplierId);
	 * generalMap.put("changedBy",changedBy);
	 * generalMap.put("currentDate",currentDate);
	 * generalMap.put("currentTime",currentTime); boolean dataUpdated=false;
	 * try{
	 * dataUpdated=pharmacyMasterHandlerService.editItemWiseSupplier(generalMap
	 * ); }catch (Exception e) { e.printStackTrace(); }
	 * if(dataUpdated==true){ message="Record updated Successfully !!"; } else{
	 * message="Record Cant be updated !!"; } try{ map =
	 * pharmacyMasterHandlerService.getItemWiseSupplier();
	 *
	 * }catch (Exception e) { log.error("Exception in
	 * getItemWiseSupplier "+e); } jsp= ITEM_WISE_SUPPLIER_JSP; title="Edit Item
	 * Wise Supplier"; jsp += ".jsp";
	 *
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 */

	// --------------------Item Generic
	// Report-------------------------------------------------------
	public ModelAndView reportItemGeneric(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item_Generic", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// --------------------------------------------Item
	// Generic-----------------------------------------------------
	public ModelAndView showItemGenericJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemGenericJsp();
		jsp = ITEM_GENERIC_JSP;
		jsp += ".jsp";
		title = "ItemGeneric";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemGeneric(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
		String itemGenericName = "";
		//int pharmaIndexId = 0;
		String contraIndication = "";
		String dosageCalculation = "";
		String drugInteraction = "";
		String specialPrecaution = "";
		String sideEffects = "";
		int userId = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		
	/*	  if (request.getParameter(PHARMA_INDEX_ID) != null) { pharmaIndexId =
		  Integer.parseInt(request.getParameter(PHARMA_INDEX_ID)); }
		 */
		if (request.getParameter(SEARCH_NAME) != null) {
			itemGenericName = request.getParameter(SEARCH_NAME);
		}
		
		  if (request.getParameter(CONTRA_INDICATION) != null) {
		  contraIndication = request.getParameter(CONTRA_INDICATION); } 
		  
		  if(request.getParameter(DOSAGE_CALCULATION) != null) {
		  dosageCalculation = request.getParameter(DOSAGE_CALCULATION); } 
		  
		  if(request.getParameter(DRUG_INTERACTIONS) != null) 
		  
		  { drugInteraction = request.getParameter(DRUG_INTERACTIONS); } 
		  
		  if(request.getParameter(SPECIAL_PRECAUTION) != null) 
		  {
		  specialPrecaution = request.getParameter(SPECIAL_PRECAUTION); 
		  }
		 
		if (request.getParameter(SIDE_EFFECTS) != null) {
			sideEffects = request.getParameter(SIDE_EFFECTS);
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
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List itemGenericNameList = new ArrayList();
		if (listMap.get("duplicateGeneralNameList") != null) {
			itemGenericNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((itemGenericNameList.size() == 0 || itemGenericNameList == null)) {

			masStoreItemGeneric.setGenericName(itemGenericName);

			 MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
			 masStorePharmaIndex.setId(1);
			 masStoreItemGeneric.setPharmaIndex(masStorePharmaIndex);

			 masStoreItemGeneric.setContraIndication(contraIndication);
			 masStoreItemGeneric.setDosageCalculation(dosageCalculation);
			 masStoreItemGeneric.setDrugInteraction(drugInteraction);
			 masStoreItemGeneric.setSpecialPrecaution(specialPrecaution);
			masStoreItemGeneric.setSideEffects(sideEffects);

			masStoreItemGeneric.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masStoreItemGeneric.setLastChgBy(users);
			masStoreItemGeneric.setLastChgDate(currentDate);
			masStoreItemGeneric.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addItemGeneric(masStoreItemGeneric);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((itemGenericNameList.size() != 0 || itemGenericNameList != null)) {
			message = "Item Generic Name already exists.";
		}

		try {
			map = pharmacyMasterHandlerService.showItemGenericJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_GENERIC_JSP;
		title = "Add Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editItemGeneric(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String itemGenericName = "";
		int itemGenericId = 0;
		int pharmaIndexId = 0;
		String contraIndication = "";
		String dosageCalculation = "";
		String drugInteraction = "";
		String specialPrecaution = "";
		String sideEffects = "";
		int userId = 0;
		Date changedDate = null;
		String changedTime = "";
		
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(COMMON_ID) != null) {
			itemGenericId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		/*
		 * if (request.getParameter(PHARMA_INDEX_ID) != null) { pharmaIndexId =
		 * Integer.parseInt(request.getParameter(PHARMA_INDEX_ID)); }
		 */
		if (request.getParameter(SEARCH_NAME) != null) {
			itemGenericName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CONTRA_INDICATION) != null) {
			contraIndication = request.getParameter(CONTRA_INDICATION).trim();
		}
		if(request.getParameter(DOSAGE_CALCULATION) != null) {
			dosageCalculation = request.getParameter(DOSAGE_CALCULATION).trim();
		}
		if(request.getParameter(DRUG_INTERACTIONS) != null) {
			drugInteraction =request.getParameter(DRUG_INTERACTIONS).trim();
		}
		if(request.getParameter(SPECIAL_PRECAUTION) != null) {
			specialPrecaution = request.getParameter(SPECIAL_PRECAUTION).trim();
		}

		if (request.getParameter(SIDE_EFFECTS) != null) {
			sideEffects = request.getParameter(SIDE_EFFECTS).trim();
		}

	
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", itemGenericId);
		generalMap.put("itemGenericName", itemGenericName);
		generalMap.put("userId", userId);
		generalMap.put("pharmaIndexId",pharmaIndexId);
		generalMap.put("contraIndication", contraIndication);
		generalMap.put("dosageCalculation", dosageCalculation);
		generalMap.put("drugInteraction", drugInteraction);
		generalMap.put("specialPrecaution", specialPrecaution);
		generalMap.put("sideEffects", sideEffects);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService.editItemGeneric(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = pharmacyMasterHandlerService.showItemGenericJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_GENERIC_JSP;
		title = "Edit Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteItemGeneric(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemGenericId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		session = request.getSession();

		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemGenericId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteItemGeneric(
				itemGenericId, generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		try {
			map = pharmacyMasterHandlerService.showItemGenericJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_GENERIC_JSP;
		title = "Delete Item Generic";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchItemGeneric(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String itemGenericName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemGenericName = request.getParameter(SEARCH_NAME);
		}

		map = pharmacyMasterHandlerService.searchItemGeneric(itemGenericName);
		jsp = ITEM_GENERIC_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("itemGenericName", itemGenericName);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Item
	// Report-------------------------------------------------------

	public ModelAndView reportItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ---------------------------ITEM
	// MASTER----------------------------------------------
	public ModelAndView showItemJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		map = pharmacyMasterHandlerService.showItemJsp(deptId);
		jsp = ITEM_JSP;
		jsp += ".jsp";
		title = "Item";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public void getSubAccountList(HttpServletRequest request,
			HttpServletResponse response) {

		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
		}

		List<FaMasSubLed> subAccountList = new ArrayList<FaMasSubLed>();

		box.put("deptId", deptId);
		box.put("userName", userName);
		box.put("hospitalId", hospitalId);

		map = pharmacyMasterHandlerService.getSubAccountList(box);
		if (map.get("subAccountList") != null) {
			subAccountList = (List<FaMasSubLed>) map.get("subAccountList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			if (subAccountList != null && subAccountList.size() > 0) {
				for (FaMasSubLed faMasSubLed : subAccountList) {
					sb.append("<item>");
					sb.append("<id>" + faMasSubLed.getId() + "</id>");
					sb.append("<desc>" + faMasSubLed.getSubLedDesc() + "</desc>");
					sb.append("</item>");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			log.debug("sb =============================="
					+ sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchItem(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String pvmsNo = null;
		String nomenclature = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			pvmsNo = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			nomenclature = request.getParameter(SEARCH_NAME);
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
			pvmsNo = searchField;
			nomenclature = null;
		} else {
			pvmsNo = null;
			nomenclature = searchField;
		}
		map = pharmacyMasterHandlerService.searchItem(pvmsNo, nomenclature);

		jsp = ITEM_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pvmsNo", pvmsNo);
		map.put("nomenclature", nomenclature);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		MasStoreItem masStoreItem = new MasStoreItem();
		String message = null;
		int sectionId = 0;
		int itemGenericId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		int groupId = 0;
		
		String pvms = "";
		String commonName = "";
		BigDecimal minStock = new BigDecimal(0);
		BigDecimal maxStock = new BigDecimal(0);
		String leadTime = "";
		String specification = "";
		Date changedDate = null;
		String changedTime = "";

		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;

		String allergy="";
		String expiry = "";
		String tempreture = "";
		BigDecimal minTempreture = new BigDecimal(0);
		BigDecimal maxTempreture = new BigDecimal(0);
		
		String ved="";
		String abc="";
		int itemClassId=0;
		
		String standardAvailability="";
		String bagQuantity="";
		
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		map.put("deptId", deptId);
		
		String kmscl_item_code="";
		if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
			kmscl_item_code = request.getParameter("kmscl_item_code");
		}
		if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
			
			standardAvailability = request.getParameter("standardAvailability");
		}
		if (!request.getParameter(GROUP_ID).equals("0")) {
			
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
			
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter("commonName") != null) {
			commonName = request.getParameter("commonName");
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			
			itemConversionId = Integer.parseInt(request
					.getParameter(STORE_ITEM_CONVERSION_ID));
		}
		
		if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
			
			itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			
			itemCategoryId = Integer.parseInt(request
					.getParameter(ITEM_CATEGORY_ID));
		}
		
		
		if (request.getParameter(ITEM_GENERIC_ID) != null
				&& !request.getParameter(ITEM_GENERIC_ID).equals("")) {
			itemGenericId = Integer.parseInt(request
					.getParameter(ITEM_GENERIC_ID));
		}

		
		if (request.getParameter(DANGEROUS_DRUG) != null) {
			masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));

		} else {
			masStoreItem.setDangerousDrug("n");
		}
		
		
		
		if (request.getParameter(CONTROLLED_DRUG) != null) {
			masStoreItem.setControlledDrug(request
					.getParameter(CONTROLLED_DRUG));
		} else {
			masStoreItem.setControlledDrug("n");
		}
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
			masStoreItem
					.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
		} else {
			masStoreItem.setHighValueDrug("n");
		}
		if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
			masStoreItem.setRateContractItem(request
					.getParameter(RATE_CONTRACT_ITEM));
		} else {
			masStoreItem.setRateContractItem("n");
		}
		if (request.getParameter(MAX_STOCK) != null
				&& !(request.getParameter(MAX_STOCK).equals(""))) {
			maxStock =  new BigDecimal(request.getParameter(MAX_STOCK));
		}
		if (request.getParameter(MIN_STOCK) != null
				&& !(request.getParameter(MIN_STOCK).equals(""))) {
			minStock = new BigDecimal(request.getParameter(MIN_STOCK));
		}
		if (request.getParameter(LEAD_TIME) != null) {
			leadTime = request.getParameter(LEAD_TIME);
		}

		if (request.getParameter(SPECIFICATION) != null) {
			specification = request.getParameter(SPECIFICATION);
		}
		if (!request.getParameter(SLOW_MOVING_DAYS).equals("")) {
			slowMovingDays = Integer.valueOf(request
					.getParameter(SLOW_MOVING_DAYS));
			

		}
		if (!request.getParameter(FAST_MOVING_DAYS).equals("")) {
			fastMovingDays = Integer.parseInt(request
					.getParameter(FAST_MOVING_DAYS));
			
		}
		if (!request.getParameter(NON_MOVING_DAYS).equals("")) {
			nonMovingDays = Integer.parseInt(request
					.getParameter(NON_MOVING_DAYS));
			
		}

		if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
			expiry = request.getParameter(EXPIRY);
		}

	
		
		if (request.getParameter(ALLERGY) != null && !request.getParameter(ALLERGY).equals("")) {
			allergy = request.getParameter(ALLERGY);
		}
		if (!request.getParameter("ved").equals("")) {
			ved = request.getParameter("ved");
		}
		if (!request.getParameter("abc").equals("")) {
			abc = request.getParameter("abc");
		}

		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			tempreture = (request.getParameter(TEMPERATURE));
		}
		if (request.getParameter("minTemperature") != null
				&& !request.getParameter("minTemperature").equals("")) {
			minTempreture =  new BigDecimal(request
					.getParameter("minTemperature"));
		}
		if (request.getParameter("maxTemperature") != null
				&& !request.getParameter("minTemperature").equals("")) {
			maxTempreture =  new BigDecimal(request
					.getParameter("maxTemperature"));
		}
	
	
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("BagQuantity") != null) {
			bagQuantity = request.getParameter("BagQuantity");
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
		
		
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));

		generalMap.put("name", name);
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List nomenclatureList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
			try {
				masStoreItem.setNomenclature(name);
				masStoreItem.setPvmsNo(pvms);
				masStoreItem.setCommonName(commonName);
				

				if (sectionId != 0) {
					MasStoreSection masStoreSection = new MasStoreSection();
					masStoreSection.setId(sectionId);
					masStoreItem.setSection(masStoreSection);
				}

				if (itemGenericId != 0) {
					MasStoreItemGeneric masStoreItemGeneric = new MasStoreItemGeneric();
					masStoreItemGeneric.setId(itemGenericId);
					masStoreItem.setItemGeneric(masStoreItemGeneric);
				}

				masStoreItem.setKmsclItemCode(kmscl_item_code);
				
				if (itemTypeId != 0) {
					 MasItemType masStoreItemType = new MasItemType();
					 masStoreItemType.setId(itemTypeId);
					 masStoreItem.setItemType(masStoreItemType);
				}

				if (itemCategoryId != 0) {
					MasItemCategory masStoreItemCategory = new MasItemCategory();
					masStoreItemCategory.setId(itemCategoryId);
					masStoreItem.setItemCategory(masStoreItemCategory);
				}

				if (itemConversionId != 0) {
					MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
					masStoreItemConversion.setId(itemConversionId);
					masStoreItem.setItemConversion(masStoreItemConversion);
				}

				if (groupId != 0) {
					MasStoreGroup masStoreGroup = new MasStoreGroup();
					masStoreGroup.setId(groupId);
					masStoreItem.setGroup(masStoreGroup);
				}
				
				if (itemClassId != 0) {
					 MasItemClass masItemClass = new MasItemClass();
					 masItemClass.setId(itemClassId);
					 masStoreItem.setItemClass(masItemClass);
				}
				

				if(abc!="")
				{
					masStoreItem.setAbc(abc);
				}

			
				if(ved!="")
				{
					masStoreItem.setVed(ved);
				}
				if (!tempreture.equals("")) {
					masStoreItem.setTemprature(tempreture);
				}
				if (!standardAvailability.equals("")) {
					masStoreItem.setStandardAvailability(standardAvailability);
				}
				

				masStoreItem.setBagQuantity(bagQuantity);
				masStoreItem.setMinStock(minStock);
				masStoreItem.setMaxStock(maxStock);
				masStoreItem.setTempratureMax(maxTempreture);
				masStoreItem.setTempratureMin(minTempreture);
				masStoreItem.setLeadTime(leadTime);
		
				masStoreItem.setSpecification(specification);
				
				masStoreItem.setSlowMovingDays(slowMovingDays);
				masStoreItem.setFastMovingDays(fastMovingDays);
				masStoreItem.setNonMovingDays(nonMovingDays);
			
				masStoreItem.setExpiry(expiry);
				masStoreItem.setAllergy(allergy);
				masStoreItem.setStatus("y");
				Users users = new Users();
				users.setId(userId);
				masStoreItem.setLastChgBy(users);
			
				masStoreItem.setLastChgDate(changedDate);
				masStoreItem.setCreatedOn(changedDate);
				masStoreItem.setLastChgTime(changedTime);
			} catch (Exception e) {
				e.printStackTrace();
			}

			successfullyAdded = pharmacyMasterHandlerService.addItem(masStoreItem,map);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (nomenclatureList.size() != 0) {
			message = "Item Name already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showItemJsp(deptId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_JSP;
		title = "Add Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editItem(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasStoreItem masStoreItem = new MasStoreItem();
		session = request.getSession();
		int itemId = 0;
				
		String pvms = "";
		
		String nomenclature = "";
		int sectionId = 0;
		int itemGenericId = 0;
		int itemTypeId = 0;
		int itemCategoryId = 0;
		int itemConversionId = 0;
		int groupId = 0;
		String commonName = "";
		BigDecimal minStock = new BigDecimal(0);
		BigDecimal maxStock = null;
		String leadTime = "";
		String specification = "";
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";
		String dangerousDrug = "n";
		String controlledDrug = "n";
		String rateContractItem = "n";
		String highValueDrug = "n";
		int slowMovingDays = 0;
		int fastMovingDays = 0;
		int nonMovingDays = 0;
		String allergy="";
		String expiry = "";
		String tempreture = "";
		BigDecimal minTempreture  = new BigDecimal(0);
		BigDecimal maxTempreture  = new BigDecimal(0);
		
		String ved="";
		String abc="";
		int itemClassId=0;
		int deptId = 0;
		String standardAvailability="";
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
	if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
			
			standardAvailability = request.getParameter("standardAvailability");
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			nomenclature = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CODE) != null) {
			pvms = request.getParameter(CODE);
		}
		if (!request.getParameter(GROUP_ID).equals("0")) {
			
			groupId = Integer.parseInt(request.getParameter(GROUP_ID));
		}
		if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
			
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
			
		}
		if (!request.getParameter(SECTION_ID).equals("0")) {
			sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
		}
		
		
		if (request.getParameter("commonName") != null) {
			commonName = request.getParameter("commonName");
		}
		if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
			
			itemConversionId = Integer.parseInt(request
					.getParameter(STORE_ITEM_CONVERSION_ID));
		}
		
		if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
			
			itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
		}
		if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
			
			itemCategoryId = Integer.parseInt(request
					.getParameter(ITEM_CATEGORY_ID));
		}
		
		
		if (request.getParameter(ITEM_GENERIC_ID) != null
				&& !request.getParameter(ITEM_GENERIC_ID).equals("")) {
			itemGenericId = Integer.parseInt(request
					.getParameter(ITEM_GENERIC_ID));
		}

		
		if (request.getParameter(DANGEROUS_DRUG) != null) {
			masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));

		} else {
			masStoreItem.setDangerousDrug("n");
		}

		if (request.getParameter("tapered") != null) {
			masStoreItem.setTapered(request
					.getParameter("tapered"));
		} else {
			masStoreItem.setTapered("n");
		}
		
		if (request.getParameter(CONTROLLED_DRUG) != null) {
			masStoreItem.setControlledDrug(request
					.getParameter(CONTROLLED_DRUG));
		} else {
			masStoreItem.setControlledDrug("n");
		}
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
			masStoreItem
					.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
		} else {
			masStoreItem.setHighValueDrug("n");
		}
		if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
			masStoreItem.setRateContractItem(request.getParameter(RATE_CONTRACT_ITEM));
		} else {
			masStoreItem.setRateContractItem("n");
		}
		if (request.getParameter(MAX_STOCK) != null
				&& !(request.getParameter(MAX_STOCK).equals(""))) {
			maxStock =  new BigDecimal(request.getParameter(MAX_STOCK));
		}
		if (request.getParameter(MIN_STOCK) != null
				&& !(request.getParameter(MIN_STOCK).equals(""))) {
			minStock =  new BigDecimal(request.getParameter(MIN_STOCK));
		}
		if (request.getParameter(LEAD_TIME) != null) {
			leadTime = request.getParameter(LEAD_TIME);
		}

		if (request.getParameter(SPECIFICATION) != null) {
			specification = request.getParameter(SPECIFICATION);
		}
		if (!request.getParameter(SLOW_MOVING_DAYS).equals("")) {
			slowMovingDays = Integer.valueOf(request
					.getParameter(SLOW_MOVING_DAYS));
			

		}
		if (!request.getParameter(FAST_MOVING_DAYS).equals("")) {
			fastMovingDays = Integer.parseInt(request
					.getParameter(FAST_MOVING_DAYS));
			
		}
		if (!request.getParameter(NON_MOVING_DAYS).equals("")) {
			nonMovingDays = Integer.parseInt(request
					.getParameter(NON_MOVING_DAYS));
			
		}


		if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
			expiry = request.getParameter(EXPIRY);
		}

	

		if (request.getParameter(ALLERGY) != null && !request.getParameter(ALLERGY).equals("")) {
			allergy = request.getParameter(ALLERGY);
		}
		if (!request.getParameter("ved").equals("")) {
			ved = request.getParameter("ved");
		}
		if (!request.getParameter("abc").equals("")) {
			abc = request.getParameter("abc");
		}

		if (request.getParameter(TEMPERATURE) != null
				&& !request.getParameter(TEMPERATURE).equals("")) {
			tempreture = (request.getParameter(TEMPERATURE));
		}
		if (request.getParameter("minTemperature") != null
				&& !request.getParameter("minTemperature").equals("")) {
			minTempreture =  new BigDecimal(request
					.getParameter("minTemperature"));
		}
		if (request.getParameter("maxTemperature") != null
				&& !request.getParameter("maxTemperature").equals("")) {
			maxTempreture =  new BigDecimal(request
					.getParameter("maxTemperature"));
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		int userId = 0;
		int hospitalId=0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		generalMap.put("tempreture", tempreture);
		generalMap.put("itemClassId", itemClassId);
		generalMap.put("id", itemId);
		generalMap.put("name", nomenclature);
		generalMap.put("sectionId", sectionId);
		generalMap.put("commonName", commonName);
		generalMap.put("pvms", pvms);
		generalMap.put("itemGenericId", itemGenericId);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("itemCategoryId", itemCategoryId);
		generalMap.put("itemConversionId", itemConversionId);
		generalMap.put("minTempreture", minTempreture);
		generalMap.put("maxTempreture", maxTempreture);
		generalMap.put("maxStock", maxStock);
		generalMap.put("minStock", minStock);
		generalMap.put("ved", ved);
		generalMap.put("abc", abc);
		generalMap.put("controlledDrug", controlledDrug);
		generalMap.put("highValueDrug", highValueDrug);
		generalMap.put("rateContractItem", rateContractItem);
		generalMap.put("dangerousDrug", dangerousDrug);
		generalMap.put("leadTime", leadTime);
		generalMap.put("specification", specification);
		generalMap.put("groupId", groupId);
		generalMap.put("expiry", expiry);
		generalMap.put("allergy", allergy);
		generalMap.put("slowMovingDays", slowMovingDays);
		generalMap.put("fastMovingDays", fastMovingDays);
		generalMap.put("nonMovingDays", nonMovingDays);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		generalMap.put("hospitalId", hospitalId);
		generalMap.put("standardAvailability", standardAvailability);
		boolean dataUpdated = false;
		dataUpdated = pharmacyMasterHandlerService.editItem(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		try {
			map = pharmacyMasterHandlerService.showItemJsp(deptId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ITEM_JSP;
		title = "Edit Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteItem(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int itemId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		session = request.getSession();
		int deptId = 0;

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteItem(itemId,
				generalMap);

		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemJsp";
		try {
			map = pharmacyMasterHandlerService.showItemJsp(deptId);

		} catch (Exception e){
			e.printStackTrace();
		}
		jsp = ITEM_JSP;
		title = "Delete Item ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView checkForExistingPvmsNo(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		String pvmsNo = "";
		String message = "";
		if (request.getParameter("pvmsNo") != null) {
			pvmsNo = request.getParameter("pvmsNo");
		}
		List<MasStoreItem> existingPvmsNoList = pharmacyMasterHandlerService
				.checkForExistingPvmsNo(pvmsNo);

		if (existingPvmsNoList != null && existingPvmsNoList.size() > 0) {
			message = "Item Code Already Exists. \n Please Check Items  .";
		}
		map.put("message", message);
		jsp = AJAX_MESSAGE_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	// --------------------Store Vendor Wise Manufacturer
	// Report-------------------------------------------------------

	public ModelAndView reportStoreVendorWiseManufacturer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Vendor_Wise_Manufacturer",
				parameters, (Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// --------------------------------------
	// StoreVendorWiseManufacturer--------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showStoreVendorWiseManufacturerJsp(
			HttpServletRequest request, HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreVendorWiseManufacturerJsp();
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		jsp += ".jsp";
		title = "StoreVendorWiseManufacturer";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreVendorWiseManufacturer(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreVendorWiseManufacturer masStoreVendorWiseManufacturer = new MasStoreVendorWiseManufacturer();

		int manufacturerId = 0;
		Date changedDate = null;
		String changedTime = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(MANUFACTURER_ID) != null) {
			manufacturerId = Integer.valueOf(request
					.getParameter(MANUFACTURER_ID));
		}
		
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		generalMap.put("code", code);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List storeVendorWiseManufacturerCodeList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			storeVendorWiseManufacturerCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}

		boolean successfullyAdded = false;

		if ((storeVendorWiseManufacturerCodeList.size() == 0 || storeVendorWiseManufacturerCodeList == null)) {
			// masStoreVendorWiseManufacturer.setVendorCode(code);

			MasManufacturer masManufacturer = new MasManufacturer();
			masManufacturer.setId(manufacturerId);
			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);

			masStoreVendorWiseManufacturer.setManufacturer(masManufacturer);
			masStoreVendorWiseManufacturer.setStatus("y");
			
			
			Users users = new Users();
			users.setId(userId);
			masStoreVendorWiseManufacturer.setLastChgBy(users);
		
			
			
			masStoreVendorWiseManufacturer.setLastChgDate(changedDate);
			masStoreVendorWiseManufacturer.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addStoreVendorWiseManufacturer(masStoreVendorWiseManufacturer);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((storeVendorWiseManufacturerCodeList.size() != 0 || storeVendorWiseManufacturerCodeList != null)) {

			if ((storeVendorWiseManufacturerCodeList.size() != 0 || storeVendorWiseManufacturerCodeList != null)) {

				message = "Vendor Code  already exists.";
			}
		}

		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try {
			map = pharmacyMasterHandlerService
					.showStoreVendorWiseManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title = "add StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchStoreVendorWiseManufacturer(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String storeVendorWiseManufacturerCode = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			storeVendorWiseManufacturerCode = request.getParameter(CODE);
		}

		map = pharmacyMasterHandlerService
				.searchStoreVendorWiseManufacturer(storeVendorWiseManufacturerCode);
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("storeVendorWiseManufacturerCode",
				storeVendorWiseManufacturerCode);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editStoreVendorWiseManufacturer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String storeVendorWiseManufacturerCode = "";
		int manufacturerId = 0;
		int storeVendorWiseManufacturerId = 0;
		String changedTime = "";
		Date changedDate = new Date();
		
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
		
		if (request.getParameter(MANUFACTURER_ID) != null
				&& !(request.getParameter(MANUFACTURER_ID).equals(""))) {
			manufacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			storeVendorWiseManufacturerId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			storeVendorWiseManufacturerCode = request.getParameter(CODE);
		}
	
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		encodedDate = new Date();
		encodedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", storeVendorWiseManufacturerId);
		generalMap.put("storeVendorWiseManufacturerCode",
				storeVendorWiseManufacturerCode);
		generalMap.put("manufacturerId", manufacturerId);
		generalMap.put("userId", userId);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated = false;
		dataUpdated = pharmacyMasterHandlerService
				.editStoreVendorWiseManufacturerToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant be updated !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try {
			map = pharmacyMasterHandlerService
					.showStoreVendorWiseManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title = "edit StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteStoreVendorWiseManufacturer(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int storeVendorWiseManufacturerId = 0;
		String message = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			storeVendorWiseManufacturerId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService
				.deleteStoreVendorWiseManufacturer(
						storeVendorWiseManufacturerId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showStoreVendorWiseManufacturerJsp";
		try {
			map = pharmacyMasterHandlerService
					.showStoreVendorWiseManufacturerJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_VENDOR_WISE_MANUFACTURE_JSP;
		title = "delete StoreVendorWiseManufacturer";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Financial
	// Report-------------------------------------------------------

	public ModelAndView reportFinancial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Financial", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------Financial
	// Master---------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showFinancialJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showFinancialJsp();
		jsp = FINANCIAL_JSP;
		jsp += ".jsp";
		title = "Financial";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView searchFinancial(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletRequestBindingException {
	 * Map<String, Object> map= new HashMap<String, Object>(); Date startDate =
	 * new Date();; Date endDate = new Date(); String searchField= null;
	 *
	 * if(request.getParameter(START_DATE) != null &&
	 * !(request.getParameter(START_DATE).equals(""))){ startDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE)); }
	 * if(request.getParameter(END_DATE) != null &&
	 * !(request.getParameter(END_DATE).equals(""))){ endDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE)); } int
	 * searchRadio=1; try{ if(request.getParameter(SEARCH_FIELD) != null &&
	 * !(request.getParameter(SEARCH_FIELD).equals(""))){ searchField =
	 * request.getParameter(SEARCH_FIELD); }
	 * if(request.getParameter(SELECTED_RADIO) != null &&
	 * !(request.getParameter(SELECTED_RADIO).equals(""))){ searchRadio
	 * =Integer.parseInt(request.getParameter(SELECTED_RADIO)) ; } }catch
	 * (Exception e) { e.printStackTrace(); }
	 * if(searchRadio==1){ startDate=searchField; endDate=null; }else{
	 * startDate=null; endDate=searchField; } map =
	 * pharmacyMasterHandlerService.searchFinancial(startDate, endDate);
	 * jsp=FINANCIAL_JSP; jsp += ".jsp"; map.put("contentJsp",jsp);
	 * map.put("title", title); map.put("startDate",startDate);
	 * map.put("endDate",endDate); return new ModelAndView("index", "map", map);
	 * }
	 *
	 * @SuppressWarnings("unchecked")
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addFinancial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		String changedBy = "";
		Date startDate = new Date();
		Date endDate = new Date();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
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

		generalMap.put("startDate", startDate);
		generalMap.put("endDate", endDate);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List startDateList = new ArrayList();
		List endDateList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			startDateList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			endDateList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((startDateList.size() == 0 || startDateList == null)
				&& (endDateList.size() == 0 || endDateList == null)) {
			masStoreFinancial.setStartDate(startDate);
			masStoreFinancial.setEndDate(endDate);
			masStoreFinancial.setStatus("y");
	//		masStoreFinancial.setLastChgBy(changedBy);
			masStoreFinancial.setLastChgDate(currentDate);
			masStoreFinancial.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addFinancial(masStoreFinancial);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		else if ((startDateList.size() != 0 || startDateList != null)
				|| (endDateList.size() != 0) || endDateList != null) {
			if ((startDateList.size() != 0 || startDateList != null)
					&& (endDateList.size() == 0 || endDateList == null)) {
				message = "Start Date  already exists.";
			} else if ((endDateList.size() != 0 || endDateList != null)
					&& (startDateList.size() == 0 || startDateList == null)) {
				message = "End Date already exists.";
			} else if ((startDateList.size() != 0 || startDateList != null)
					&& (endDateList.size() != 0 || endDateList != null)) {
				message = "Start Date and End Date already exist.";
			}
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try {
			map = pharmacyMasterHandlerService.showFinancialJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FINANCIAL_JSP;
		title = "Add Financial";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView editFinancialToDatabase(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		int financialId = 0;
		Date startDate = null;
		Date endDate = null;
		String changedBy = "";

		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
		}
		
		

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			financialId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", financialId);
		generalMap.put("startDate", startDate);
		generalMap.put("endDate", endDate);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editFinancialToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try {
			map = pharmacyMasterHandlerService.showFinancialJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FINANCIAL_JSP;
		title = "Update Financial";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteFinancial(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int financialId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			financialId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteFinancial(financialId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showFinancialJsp";
		try {
			map = pharmacyMasterHandlerService.showFinancialJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FINANCIAL_JSP;
		title = "Delete Fianancial";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchFinancial(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Date startDate = new Date();
		;
		Date endDate = new Date();
		String searchField = null;

		if (request.getParameter(START_DATE) != null
				&& !(request.getParameter(START_DATE).equals(""))) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null
				&& !(request.getParameter(END_DATE).equals(""))) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
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
			// startDate=searchField;
			endDate = null;
		} else {
			startDate = null;
			// endDate=searchField;
		}
		map = pharmacyMasterHandlerService.searchFinancial(startDate, endDate);
		jsp = FINANCIAL_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Pharma Index
	// Report-------------------------------------------------------

	public ModelAndView reportPharmaIndex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Pharma_Index", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ------------------Pharma Index---------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPharmaIndexJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		jsp = PHARMA_INDEX_JSP;
		jsp += ".jsp";
		title = "Pharma Index";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPharmaIndex(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String pharmaIndexName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			pharmaIndexName = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService.searchPharmaIndex(pharmaIndexName);
		jsp = PHARMA_INDEX_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("pharmaIndexName", pharmaIndexName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPharmaIndex(HttpServletRequest request,
			HttpServletResponse response) {
		String pharmaIndexName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		MasStorePharmaIndex masStorePharmaIndex = new MasStorePharmaIndex();
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			pharmaIndexName = request.getParameter(SEARCH_NAME);
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
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List pharmaIndexNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			pharmaIndexNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((pharmaIndexNameList.size() == 0 || pharmaIndexNameList == null)) {
			masStorePharmaIndex.setPharmaIndexName(pharmaIndexName);
			masStorePharmaIndex.setStatus("y");
			masStorePharmaIndex.setLastChgBy(changedBy);
			masStorePharmaIndex.setLastChgDate(currentDate);
			masStorePharmaIndex.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addPharmaIndex(masStorePharmaIndex);

			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (pharmaIndexNameList.size() != 0) {
			message = "Pharma Index Name already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PHARMA_INDEX_JSP;
		title = "Add Pharma Index";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPharmaIndex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String pharmaIndexName = "";
		int pharmaIndexId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			pharmaIndexId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			pharmaIndexName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", pharmaIndexId);
		generalMap.put("pharmaIndexName", pharmaIndexName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editPharmaIndexToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showPharmaIndexJsp";
		try {
			map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PHARMA_INDEX_JSP;
		title = "Update Pharma Index";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePharmaIndex(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pharmaIndexId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			pharmaIndexId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deletePharmaIndex(
				pharmaIndexId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showPharmaIndexJsp";
		try {
			map = pharmacyMasterHandlerService.showPharmaIndexJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PHARMA_INDEX_JSP;
		title = "Delete Pharma Index";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Item Unit
	// Report-------------------------------------------------------

	public ModelAndView reportItemUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Unit", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// -------------------------Store
	// Unit----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showItemUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemUnitJsp();
		jsp = STORE_ITEM_UNIT_JSP;
		jsp += ".jsp";
		title = "Item Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchItemUnit(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String unitName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService.searchItemUnit(unitName);
		jsp = STORE_ITEM_UNIT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search", "search");
		map.put("title", title);
		map.put("unitName", unitName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemUnit(HttpServletRequest request,
			HttpServletResponse response) {
		String unitName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreUnit masStoreItemUnit = new MasStoreUnit();
	
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
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
		/*
		 * Code Commentd By Mukesh Narayan Singh
		 * Date 6 Aug 2010
		 */
		//generalMap.put("unitName", unitName);
		generalMap.put("name", unitName);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List unitNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			unitNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		//
		boolean successfullyAdded = false;
		if ((unitNameList.size() == 0 || unitNameList == null)) {
			masStoreItemUnit.setUnitName(unitName);
			masStoreItemUnit.setStatus("y");
			
			Users user = new Users();
			user.setId(userId);
			masStoreItemUnit.setLastChgBy(user);
			
			
			masStoreItemUnit.setLastChgDate(currentDate);
			masStoreItemUnit.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addItemUnit(masStoreItemUnit);

			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (unitNameList.size() != 0) {
			message = "Unit Name already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showItemUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_UNIT_JSP;
		title = "Add Item Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editItemUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String unitName = "";
		int itemUnitId = 0;
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemUnitId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", itemUnitId);
		generalMap.put("unitName", unitName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editItemUnitToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showItemUnitJsp";
		try {
			map = pharmacyMasterHandlerService.showItemUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_UNIT_JSP;
		title = "Update Item Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteItemUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemUnitId = 0;
		String message = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemUnitId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteItemUnit(itemUnitId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemUnitJsp";
		try {
			map = pharmacyMasterHandlerService.showItemUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_UNIT_JSP;
		title = "Delete Item Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------Item
	// Conversion-----------------------------------------------
	/*
	 * public ModelAndView showItemConversionJsp(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); session = request.getSession(); map =
	 * pharmacyMasterHandlerService.showItemConversionJsp(); jsp =
	 * STORE_ITEM_CONVERSION_JSP; jsp += ".jsp"; title = "Item Conversion";
	 * map.put("contentJsp",jsp); map.put("title", title); return new
	 * ModelAndView("index", "map", map); }
	 *
	 * public ModelAndView searchItemConversion(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletRequestBindingException {
	 *
	 * Map<String, Object> map= new HashMap<String, Object>(); String
	 * itemUnitName = null;
	 *
	 * if(request.getParameter(SEARCH_NAME) != null &&
	 * !(request.getParameter(SEARCH_NAME).equals(""))){ itemUnitName =
	 * request.getParameter(SEARCH_NAME); }
	 *
	 * map = pharmacyMasterHandlerService.searchItemConversion(itemUnitName);
	 * jsp=STORE_ITEM_CONVERSION_JSP; jsp += ".jsp"; map.put("contentJsp",jsp);
	 * map.put("title", title); map.put("itemUnitName",itemUnitName); return new
	 * ModelAndView("index", "map", map); }
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * addItemConversion(HttpServletRequest request, HttpServletResponse
	 * response) { Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String, Object> listMap = new HashMap<String, Object>(); Map<String,
	 * Object> generalMap = new HashMap<String, Object>();
	 * MasStoreItemConversion masStoreItemConversion = new
	 * MasStoreItemConversion(); String itemUnitName = ""; int purchaseUnitId=
	 * 0; int intermediateUnitId= 0; int issueUnitId= 0; String conversionFactor
	 * = ""; String conversionFactor2 = ""; Date changedDate = null; String
	 * changedBy = ""; String changedTime = "";
	 *
	 * if(request.getParameter(SEARCH_NAME) != null &&
	 * !(request.getParameter(SEARCH_NAME).equals(""))){ itemUnitName =
	 * request.getParameter(SEARCH_NAME); } if
	 * (request.getParameter(PURCHASE_UNIT_ID) != null) { purchaseUnitId =
	 * Integer.parseInt(request.getParameter(PURCHASE_UNIT_ID)); } if
	 * (request.getParameter(INTERMEDIATE_UNIT_ID) != null) { intermediateUnitId
	 * = Integer.parseInt(request.getParameter(INTERMEDIATE_UNIT_ID)); }
	 * if(request.getParameter(ISSUE_UNIT_ID) != null) { issueUnitId =
	 * Integer.parseInt(request.getParameter(ISSUE_UNIT_ID)); }
	 * if(request.getParameter(CONVERSION_FACTOR) != null) { conversionFactor =
	 * request.getParameter(CONVERSION_FACTOR); }
	 * if(request.getParameter(CONVERSION_FACTOR2) != null) { conversionFactor2
	 * = request.getParameter(CONVERSION_FACTOR2); }
	 * if(request.getParameter(CHANGED_BY) !=null){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null){ changedDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter("pojoName")
	 * != null){ pojoName = request.getParameter("pojoName"); }
	 * if(request.getParameter("pojoPropertyName") != null){ pojoPropertyName =
	 * request.getParameter("pojoPropertyName"); }
	 * if(request.getParameter("jspName") != null){ jspName =
	 * request.getParameter("jspName"); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 *
	 * generalMap.put("name", itemUnitName); generalMap.put("currentDate",
	 * currentDate); generalMap.put("currentTime", currentTime);
	 *
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoName", pojoName);
	 *
	 * listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	 *
	 * List titleCodeList = new ArrayList(); List titleNameList = new
	 * ArrayList();
	 *
	 * if(listMap.get("duplicateGeneralCodeList") != null){ titleCodeList =
	 * (List)listMap.get("duplicateGeneralCodeList"); }
	 * if(listMap.get("duplicateGeneralNameList") != null){ titleNameList =
	 * (List)listMap.get("duplicateGeneralNameList"); } boolean
	 * successfullyAdded = false; if((titleCodeList.size() == 0 || titleCodeList
	 * == null) && (titleNameList.size() == 0 || titleNameList == null)) {
	 * masStoreItemConversion.setItemUnitName(itemUnitName);
	 *
	 * MasStoreUnit purchaseUnitObj = new MasStoreUnit();
	 * purchaseUnitObj.setId(purchaseUnitId); purchaseUnitObj.set
	 *
	 * MasRoom roomObj = new MasRoom(); roomObj.setId(roomId);
	 * masStoreItemConversion.setRoom(roomObj);
	 *
	 * MasBedStatus bedStatusObj = new MasBedStatus();
	 * bedStatusObj.setId(bedStatusId);
	 * masStoreItemConversion.setBedStatus(bedStatusObj);
	 *
	 * masStoreItemConversion.setAdNo(conversionFactor);
	 * masStoreItemConversion.setDietType(conversionFactor2);
	 * masStoreItemConversion.setStatus("y");
	 * masStoreItemConversion.setLastChgBy(changedBy);
	 * masStoreItemConversion.setLastChgDate(changedDate);
	 * masStoreItemConversion.setLastChgTime(changedTime); successfullyAdded =
	 * pharmacyMasterHandlerService.addItemConversion(masStoreItemConversion);
	 * if(successfullyAdded == true){ message="Bed Information Added
	 * Successfully !!"; }else{ message = "Try Again !!"; }
	 *
	 * }else if((titleCodeList.size() != 0 || titleCodeList != null) ||
	 * (titleNameList.size() != 0) || titleNameList != null){
	 * if((titleCodeList.size() != 0 || titleCodeList != null) &&
	 * (titleNameList.size() == 0 || titleNameList == null)){ message = "Title
	 * Code already exists."; } else if((titleNameList.size() != 0 ||
	 * titleNameList != null) && (titleCodeList.size() == 0 || titleCodeList ==
	 * null) ){ message = "Title Name already exists."; } else
	 * if((titleCodeList.size() != 0 || titleCodeList != null) &&
	 * (titleNameList.size() != 0 || titleNameList != null)){ message = "Title
	 * Code and Title Name already exist."; } }
	 *
	 * url = "/hms/hms/pharmacy?method=showItemConversionJsp"; try{ map =
	 * pharmacyMasterHandlerService.showItemConversionJsp(); }catch (Exception
	 * e) { e.printStackTrace(); }
	 * jsp=BED_JSP; title="Add Bed"; jsp += ".jsp"; map.put("contentJsp", jsp);
	 * map.put("title", title); map.put("message", message); return new
	 * ModelAndView("index", "map", map); }
	 */

	// --------------------PO Delivery terms
	// Reports-------------------------------------------------------
	public ModelAndView reportPoDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Po_Delivery_Terms", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// --------------------PO Delivery
	// terms-------------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showPoDeliveryTermsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		jsp = PO_DELIVERY_JSP;
		jsp += ".jsp";
		title = "PoDelivery";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPoDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String poDeliveryType = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			poDeliveryType = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService
				.searchPoDeliveryTerms(poDeliveryType);
		jsp = PO_DELIVERY_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("poDeliveryTerms", poDeliveryType);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addPoDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStorePoDeliveryTerms masStorePoDeliveryTerms = new MasStorePoDeliveryTerms();
		String changedBy = "";
		String poType = "";
		String description = "";
		String pojoPropertyDescription="";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		Date changedDate = null;
		String changedTime = "";

		if (request.getParameter(SEARCH_NAME) != null) {
			poType = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DESCRIPTION) != null) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter("pojoPropertyDescription") != null) {
			pojoPropertyDescription=request.getParameter("pojoPropertyDescription");
		}

		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
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
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("name", poType);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("description", description);
		generalMap.put("pojoPropertyDescription", pojoPropertyDescription);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List poTypeList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			poTypeList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		boolean successfullyAdded = false;
		if (poTypeList.size() == 0) {
			masStorePoDeliveryTerms.setPoDeliveryTermsName(poType);
			masStorePoDeliveryTerms.setPoDeliveryTermsDescription(description);
			masStorePoDeliveryTerms.setStatus("y");
			masStorePoDeliveryTerms.setLastChgBy(changedBy);
			masStorePoDeliveryTerms.setLastChgDate(changedDate);
			masStorePoDeliveryTerms.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addPoDeliveryTerms(masStorePoDeliveryTerms);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}else{
			message = "Duplicate data !!";
		}
		try {
			map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PO_DELIVERY_JSP;
		title = "Add Supplier Order Delivery/Payment Terms";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editPoDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String poType = "";
		String description = "";
		int poDeliveryTermsId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poDeliveryTermsId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			poType = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(DESCRIPTION) != null
				&& !(request.getParameter(DESCRIPTION).equals(""))) {
			description = request.getParameter(DESCRIPTION);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", poDeliveryTermsId);
		generalMap.put("poType", poType);
		generalMap.put("description", description);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);

		boolean dataUpdated = false;

		dataUpdated = pharmacyMasterHandlerService
				.editPoDeliveryTermsToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showPoDeliveryTermsJsp";
		try {
			map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PO_DELIVERY_JSP;
		title = "Update poDelivery";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deletePoDeliveryTerms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int poDeliveryTermsId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			poDeliveryTermsId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deletePoDeliveryTerms(
				poDeliveryTermsId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		}

		else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showPoDeliveryTermsJsp";
		try {
			map = pharmacyMasterHandlerService.showPoDeliveryTermsJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = PO_DELIVERY_JSP;
		title = "Delete poDelivery";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------Budget
	// Report-------------------------------------------------------

	public ModelAndView reportBudget(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Budget", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ------------------------------Budget
	// Master-------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBudgetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showBudgetJsp();
		jsp = BUDGET_ENTRY_JSP;
		jsp += ".jsp";
		title = "Budget Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * @SuppressWarnings("deprecation") public ModelAndView
	 * addBudgetEntry(HttpServletRequest request, HttpServletResponse response)
	 * { Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String,Object> infoMap=new HashMap<String,Object>(); MasStoreBudget
	 * masStoreBudget = new MasStoreBudget(); int financialId= 0; String
	 * budgetCode=""; Float totalAllocatedAmount = null; Float crvComittedAmount
	 * = null; Float poCommitedAmount = null; Float utilizedAmount = null; Date
	 * changedDate = null; String changedBy = ""; String changedTime = ""; int
	 * pageNo=1; int noOfRecords=1; @SuppressWarnings("unused") int rows=0; int
	 * budgetId=0; if (request.getParameter("pageNo") != null) { pageNo=
	 * Integer.parseInt(request.getParameter("pageNo")); } if
	 * (request.getParameter(NO_OF_ROWS) != null) { noOfRecords=
	 * Integer.parseInt(request.getParameter(NO_OF_ROWS)); } if
	 * (request.getParameter(NO_OF_ROWS) != null) { rows =
	 * Integer.parseInt(request.getParameter(NO_OF_ROWS)); }
	 * if(request.getParameter(BUDGET_CODE) != null &&
	 * !(request.getParameter(BUDGET_CODE).equals(""))){ budgetCode =
	 * request.getParameter(BUDGET_CODE); }
	 * if(!request.getParameter(FINANCIAL_ID).equals("0")){ financialId =
	 * Integer.parseInt(request.getParameter(FINANCIAL_ID)); }
	 * if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null &&
	 * !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
	 * totalAllocatedAmount =
	 * Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT)); } if
	 * (request.getParameter(BUDGET_ID) != null) { budgetId=
	 * Integer.parseInt(request.getParameter(BUDGET_ID)); } if(pageNo!=1) {
	 * budgetId
	 * =pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt
	 * (budgetCode)); } if(request.getParameter(CRV_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
	 * crvComittedAmount =
	 * Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(PO_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
	 * poCommitedAmount =
	 * Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(UTILIZED_AMOUNT) != null &&
	 * !(request.getParameter(UTILIZED_AMOUNT).equals(""))){ utilizedAmount =
	 * Float.parseFloat(request.getParameter(UTILIZED_AMOUNT)); }
	 * if(request.getParameter(CHANGED_BY) !=null){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null){ changedDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); }
	 *
	 * String headerStored="no";
	 *
	 * if(pageNo==1){ try{ masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * MasStoreFinancial financialObj = new MasStoreFinancial();
	 * financialObj.setId(financialId);
	 * masStoreBudget.setFinancial(financialObj);
	 *
	 * masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
	 * masStoreBudget.setCrvComittedAmount(crvComittedAmount);
	 * masStoreBudget.setPoComittedAmount(poCommitedAmount);
	 * masStoreBudget.setUtilizedAmount(utilizedAmount);
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(changedTime);
	 *
	 * }catch (Exception e) { } }else{ headerStored="yes";
	 * infoMap.put("headerStored", headerStored); } int length=0;
	 * List<MasStoreBudgetT> masStoreBudgetTList = new
	 * ArrayList<MasStoreBudgetT>(); BigDecimal[] projectAmountArray=new
	 * BigDecimal[10]; BigDecimal[] budgetedAmountArray=new BigDecimal[10];
	 * BigDecimal[] additionalAmountArray=new BigDecimal[10];
	 *
	 * try{
	 *
	 * int srNo[] = JKTRequestUtils.getRequiredIntParameters(request,SR_NO);
	 * String[] authorityLetterNo =
	 * JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
	 * String xx[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * PROJECT_AMOUNT); int xxLegnt=xx.length; for(int i=0;i<xxLegnt;i++) {
	 * BigDecimal val1 = new BigDecimal(xx[i]); projectAmountArray[i]=val1; }
	 * String yy[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * BUDGETED_AMOUNT); int yyLegnt=yy.length; for(int i=0;i<yyLegnt;i++) {
	 * BigDecimal val2 = new BigDecimal(yy[i]); budgetedAmountArray[i]=val2; }
	 * String zz[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * ADDITIONAL_ALLOCATED_AMOUNT); int zzLegnt=zz.length; for(int
	 * i=0;i<zzLegnt;i++) { BigDecimal val3 = new BigDecimal(zz[i]);
	 * additionalAmountArray[i]=val3; }
	 *
	 *
	 *
	 * 
	 * 
	 * 
	 * 
	 * log.debug("additionalAmountArray[]
	 * "+additionalAmountArray.length); length = noOfRecords; for(int i = 0 ;
	 * i<length ; i++){
	 *
	 * MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
	 *
	 * masStoreBudgetTObj.setSrNo(srNo[i]);
	 *
	 * masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
	 *
	 * masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);
	 *
	 * masStoreBudgetTList.add(masStoreBudgetTObj); }
	 *
	 *
	 * }catch (Exception e) { e.printStackTrace(); }
	 *
	 *
	 * infoMap.put("pageNo",pageNo); infoMap.put("budgetCode",budgetCode);
	 * infoMap.put("budgetId",budgetId); boolean flag=false; try{
	 * flag=pharmacyMasterHandlerService.addBudgetEntry(masStoreBudget,
	 * masStoreBudgetTList,infoMap);
	 *
	 * }catch (Exception e) { e.printStackTrace(); } String
	 * messageTOBeVisibleToTheUser="";
	 *
	 * if(flag){
	 *
	 * pageNo++; messageTOBeVisibleToTheUser="Transaction Completed
	 * Successfully"; }else { messageTOBeVisibleToTheUser="Not Transaction
	 * Completed Successfully"; }
	 *
	 * jsp="messageBudgetEntry"; jsp += ".jsp";
	 *
	 * map.put("budgetCode",budgetCode); map.put("pageNo",pageNo);
	 * map.put("contentJsp",jsp);
	 * map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
	 * return new ModelAndView("index", "map", map);
	 *
	 *
	 * } @SuppressWarnings("unchecked") public ModelAndView
	 * searchBudgetEntry(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletRequestBindingException { String fromDate="";
	 * String toDate=""; int financialId=0; Map<String, Object> map = new
	 * HashMap<String, Object>(); Map<String, Object> tempMap = new
	 * HashMap<String, Object>(); Map<String, Object>searchFieldMap= new
	 * HashMap<String, Object>(); List<MasStoreBudget> searchBudgetList= new
	 * ArrayList<MasStoreBudget>(); try{ if (request.getParameter(FROM_DATE) !=
	 * null) { fromDate = request.getParameter(FROM_DATE); } if
	 * (request.getParameter(TO_DATE) != null) { }
	 * if(!request.getParameter(SEARCH_FINANCIAL_ID).equals("0")) { financialId
	 * = Integer.parseInt(request.getParameter(SEARCH_FINANCIAL_ID)); } }catch
	 * (Exception e) { e.printStackTrace(); }
	 * searchFieldMap.put("fromDate",fromDate);
	 * searchFieldMap.put("toDate",toDate);
	 * searchFieldMap.put("financialId",financialId);
	 * tempMap=pharmacyMasterHandlerService.showBudgetJsp();
	 * if(tempMap.get("searchBudgetList")!=null)
	 *
	 * searchBudgetList=(List)tempMap.get("searchBudgetList");
	 *
	 * map=pharmacyMasterHandlerService.searchMasStoreBudget(searchFieldMap);
	 * map.put("searchBudgetList",searchBudgetList);
	 *
	 * jsp = SEARCH_BUDGET_ENTRY_JSP; jsp += ".jsp"; title = "Budget Entry";
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView("index","map", map); }
	 *
	 *
	 *
	 * @SuppressWarnings("unchecked") public ModelAndView
	 * modifyBudgetEntry(HttpServletRequest request, HttpServletResponse
	 * response){  Map<String, Object> map
	 * = new HashMap<String, Object>(); Map<String, Object> map2 = new
	 * HashMap<String, Object>();  jsp =
	 * BUDGET_ENTRY_MODIFY; jsp += ".jsp"; int radio_str=0; if
	 * (request.getParameter("parent") != null) { radio_str =Integer.parseInt(
	 * request.getParameter("parent"));
	 * map=(Map)pharmacyMasterHandlerService.getBudgetEntryModifyMap(radio_str);
	 *  } List<MasStoreBudget>
	 * searchBudgetList= new ArrayList<MasStoreBudget>();
	 * List<MasStoreFinancial> finanacialList= new
	 * ArrayList<MasStoreFinancial>();
	 * map2=pharmacyMasterHandlerService.showBudgetJsp();
	 * searchBudgetList=(List) map2.get("searchBudgetList");
	 * finanacialList=(List) map2.get("finanacialList");
	 * map.put("searchBudgetList", searchBudgetList); map.put("finanacialList",
	 * finanacialList);
	 *
	 *  log.debug("
	 * radio_str ="+radio_str); map.put("contentJsp",jsp); map.put("title",
	 * title); map.put("radio_str",radio_str);
	 *
	 *
	 *
	 * return new ModelAndView("index","map", map);
	 *
	 * }
	 *
	 *
	 * @SuppressWarnings({ "unchecked", "deprecation" }) public ModelAndView
	 * updateNextBudgetEntry(HttpServletRequest request, HttpServletResponse
	 * response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String,Object> infoMap=new HashMap<String,Object>(); MasStoreBudget
	 * masStoreBudget = new MasStoreBudget(); int financialId= 0; String
	 * budgetCode=""; Float totalAllocatedAmount = null; Float crvComittedAmount
	 * = null; Float poCommitedAmount = null; Float utilizedAmount = null; Date
	 * changedDate = null; String changedBy = ""; String changedTime = ""; int
	 * noOfRecords=0; int rows=0; int budgetId=0; int totalRecords=0; int
	 * pageNo=1; try{ if (request.getParameter("pageNo") != null) { pageNo=
	 * Integer.parseInt(request.getParameter("pageNo"));
	 *  } if
	 * (request.getParameter("totalRecords") != null) { totalRecords=
	 * Integer.parseInt(request.getParameter("totalRecords"));
	 *  }
	 * if(request.getParameter(BUDGET_CODE) != null &&
	 * !(request.getParameter(BUDGET_CODE).equals(""))){ budgetCode =
	 * request.getParameter(BUDGET_CODE); }
	 * if(!request.getParameter(FINANCIAL_ID).equals("0")){ financialId =
	 * Integer.parseInt(request.getParameter(FINANCIAL_ID)); }
	 * if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null &&
	 * !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
	 * totalAllocatedAmount =
	 * Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT)); } if
	 * (request.getParameter(BUDGET_ID) != null) { budgetId=
	 * Integer.parseInt(request.getParameter(BUDGET_ID)); } if(pageNo!=1) {
	 * budgetId
	 * =pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt
	 * (budgetCode)); } if(request.getParameter(CRV_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
	 * crvComittedAmount =
	 * Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(PO_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
	 * poCommitedAmount =
	 * Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(UTILIZED_AMOUNT) != null &&
	 * !(request.getParameter(UTILIZED_AMOUNT).equals(""))){ utilizedAmount =
	 * Float.parseFloat(request.getParameter(UTILIZED_AMOUNT)); }
	 * if(request.getParameter(CHANGED_BY) !=null){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null){ changedDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if
	 * (request.getParameter(NO_OF_ROWS) != null) { noOfRecords=
	 * Integer.parseInt(request.getParameter(NO_OF_ROWS)); }
	 *
	 *
	 * if (request.getParameter(NO_OF_ROWS) != null) {
	 *
	 * rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
	 *  } }catch (Exception e) {
	 *  } String headerStored="no";
	 *
	 * if(pageNo==1){ try{ masStoreBudget.setId(budgetId);
	 * masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * MasStoreFinancial financialObj = new MasStoreFinancial();
	 * financialObj.setId(financialId);
	 * masStoreBudget.setFinancial(financialObj);
	 *
	 * masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
	 * masStoreBudget.setCrvComittedAmount(crvComittedAmount);
	 * masStoreBudget.setPoComittedAmount(poCommitedAmount);
	 * masStoreBudget.setUtilizedAmount(utilizedAmount);
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(changedTime);
	 *
	 *
	 *
	 * }catch (Exception e) { e.printStackTrace(); } }else{
	 * headerStored="yes"; infoMap.put("headerStored", headerStored); } int
	 * length=0; List<MasStoreBudgetT> masStoreBudgetTList = new
	 * ArrayList<MasStoreBudgetT>(); BigDecimal[] projectAmountArray=new
	 * BigDecimal[10]; BigDecimal[] budgetedAmountArray=new BigDecimal[10];
	 * BigDecimal[] additionalAmountArray=new BigDecimal[10];
	 *
	 * try{ int idArray[] =
	 * JKTRequestUtils.getRequiredIntParameters(request,BUDGET_T_ID); int srNo[]
	 * = JKTRequestUtils.getRequiredIntParameters(request,SR_NO); String[]
	 * authorityLetterNo =
	 * JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
	 * String xx[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * PROJECT_AMOUNT); int xxLegnt=xx.length; for(int i=0;i<xxLegnt;i++) {
	 * BigDecimal val1 = new BigDecimal(xx[i]); projectAmountArray[i]=val1; }
	 * String yy[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * BUDGETED_AMOUNT); int yyLegnt=yy.length; for(int i=0;i<yyLegnt;i++) {
	 * BigDecimal val2 = new BigDecimal(yy[i]); budgetedAmountArray[i]=val2; }
	 * String zz[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * ADDITIONAL_ALLOCATED_AMOUNT); int zzLegnt=zz.length; for(int
	 * i=0;i<zzLegnt;i++) { BigDecimal val3 = new BigDecimal(zz[i]);
	 * additionalAmountArray[i]=val3; }
	 *
	 *
	 *
	 * 
	 * 
	 * 
	 * 
	 * log.debug("additionalAmountArray[]
	 * "+additionalAmountArray.length); length = noOfRecords; for(int i = 0 ;
	 * i<length ; i++){
	 *
	 * MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
	 *
	 * masStoreBudgetTObj.setId(idArray[i]);
	 *
	 * MasStoreBudget masStoreBudget1 = new MasStoreBudget();
	 * masStoreBudget1.setId(budgetId);
	 * masStoreBudgetTObj.setBudget(masStoreBudget1);
	 *
	 * masStoreBudgetTObj.setSrNo(srNo[i]);
	 *
	 * masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
	 *
	 * masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);
	 *
	 * masStoreBudgetTList.add(masStoreBudgetTObj); }
	 *
	 *
	 * }catch (Exception e) { e.printStackTrace(); }
	 *
	 *  boolean flag=
	 * pharmacyMasterHandlerService
	 * .updateBudgetEntry(masStoreBudget,masStoreBudgetTList);
	 *
	 * infoMap.put("pageNo",pageNo); infoMap.put("budgetId", budgetId); String
	 * messageTOBeVisibleToTheUser="";
	 *
	 *
	 * if(flag){ if((totalRecords>pageNo*10)){ jsp="updateBudgetEntry"; }else{
	 * jsp="messageBudgetEntry"; messageTOBeVisibleToTheUser="Updated
	 * Successfully"; }
	 *
	 * pageNo++;  // }else {
	 *  messageTOBeVisibleToTheUser="Not
	 * Updated"; }
	 *
	 * jsp += ".jsp";
	 *
	 * Map<String,Object> map2=new HashMap<String,Object>();
	 * map2=(Map)pharmacyMasterHandlerService.showBudgetJsp();
	 * map=(Map)pharmacyMasterHandlerService.getBudgetAndTUpdate(budgetId);
	 * map.put("searchBudgetList",(List)map2.get("searchBudgetList"));
	 * 
	 *
	 * map.put("budgetId", budgetId); map.put("pageNo",pageNo);
	 * map.put("contentJsp",jsp);
	 * map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
	 * return new ModelAndView("index", "map", map);
	 *
	 * }
	 *
	 * @SuppressWarnings({ "deprecation", "unchecked" }) public ModelAndView
	 * nextBudgetEntry(HttpServletRequest request, HttpServletResponse
	 * response){
	 *
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String,Object> infoMap=new HashMap<String,Object>(); MasStoreBudget
	 * masStoreBudget = new MasStoreBudget(); int financialId= 0; String
	 * budgetCode=""; Float totalAllocatedAmount = null; Float crvComittedAmount
	 * = null; Float poCommitedAmount = null; Float utilizedAmount = null; Date
	 * changedDate = null; String changedBy = ""; String changedTime = ""; int
	 * noOfRecords=0; int rows=0; int budgetId=0; int totalRecords=0; int
	 * pageNo=1;
	 *
	 * try{if (request.getParameter("pageNo") != null) { pageNo=
	 * Integer.parseInt(request.getParameter("pageNo"));
	 *  } if
	 * (request.getParameter("totalRecords") != null) { totalRecords=
	 * Integer.parseInt(request.getParameter("totalRecords"));
	 *  }
	 * if(request.getParameter(BUDGET_CODE) != null &&
	 * !(request.getParameter(BUDGET_CODE).equals(""))){ budgetCode =
	 * request.getParameter(BUDGET_CODE); }
	 * if(!request.getParameter(FINANCIAL_ID).equals("0")){ financialId =
	 * Integer.parseInt(request.getParameter(FINANCIAL_ID)); }
	 * if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null &&
	 * !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
	 * totalAllocatedAmount =
	 * Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT)); } if
	 * (request.getParameter(BUDGET_ID) != null) { budgetId=
	 * Integer.parseInt(request.getParameter(BUDGET_ID)); } if(pageNo!=1) {
	 * budgetId
	 * =pharmacyMasterHandlerService.getMasStoreBudgetId(Integer.parseInt
	 * (budgetCode)); } if(request.getParameter(CRV_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
	 * crvComittedAmount =
	 * Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(PO_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
	 * poCommitedAmount =
	 * Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(UTILIZED_AMOUNT) != null &&
	 * !(request.getParameter(UTILIZED_AMOUNT).equals(""))){ utilizedAmount =
	 * Float.parseFloat(request.getParameter(UTILIZED_AMOUNT)); }
	 * if(request.getParameter(CHANGED_BY) !=null){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null){ changedDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if
	 * (request.getParameter(NO_OF_ROWS) != null) { noOfRecords=
	 * Integer.parseInt(request.getParameter(NO_OF_ROWS)); }
	 *
	 *
	 * if (request.getParameter(NO_OF_ROWS) != null) {
	 *
	 * rows = Integer.parseInt(request.getParameter(NO_OF_ROWS));
	 *  } }catch (Exception e) {
	 *  }
	 *
	 * String headerStored="no";
	 *
	 * if(pageNo==1){ try{ masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * MasStoreFinancial financialObj = new MasStoreFinancial();
	 * financialObj.setId(financialId);
	 * masStoreBudget.setFinancial(financialObj);
	 *
	 * masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
	 * masStoreBudget.setCrvComittedAmount(crvComittedAmount);
	 * masStoreBudget.setPoComittedAmount(poCommitedAmount);
	 * masStoreBudget.setUtilizedAmount(utilizedAmount);
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(changedTime);
	 *
	 *
	 * }catch (Exception e) { e.printStackTrace(); } }else{
	 * headerStored="yes"; infoMap.put("headerStored", headerStored); }
	 *
	 * int length=0; List<MasStoreBudgetT> masStoreBudgetTList = new
	 * ArrayList<MasStoreBudgetT>(); BigDecimal[] projectAmountArray=new
	 * BigDecimal[10]; BigDecimal[] budgetedAmountArray=new BigDecimal[10];
	 * BigDecimal[] additionalAmountArray=new BigDecimal[10];
	 *
	 * try{ int srNo[] =
	 * JKTRequestUtils.getRequiredIntParameters(request,SR_NO); String[]
	 * authorityLetterNo =
	 * JKTRequestUtils.getRequiredStringParameters(request,AUTHORITY_LETTER_NO);
	 * String xx[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * PROJECT_AMOUNT); int xxLegnt=xx.length; for(int i=0;i<xxLegnt;i++) {
	 * BigDecimal val1 = new BigDecimal(xx[i]); projectAmountArray[i]=val1; }
	 * String yy[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * BUDGETED_AMOUNT); int yyLegnt=yy.length; for(int i=0;i<yyLegnt;i++) {
	 * BigDecimal val2 = new BigDecimal(yy[i]); budgetedAmountArray[i]=val2; }
	 * String zz[]=JKTRequestUtils.getRequiredStringParameters(request,
	 * ADDITIONAL_ALLOCATED_AMOUNT); int zzLegnt=zz.length; for(int
	 * i=0;i<zzLegnt;i++) { BigDecimal val3 = new BigDecimal(zz[i]);
	 * additionalAmountArray[i]=val3; }
	 *
	 *
	 *
	 * 
	 * 
	 * 
	 * 
	 * log.debug("additionalAmountArray[]
	 * "+additionalAmountArray.length); length = noOfRecords; for(int i = 0 ;
	 * i<length ; i++){
	 *
	 * MasStoreBudgetT masStoreBudgetTObj=new MasStoreBudgetT();
	 *
	 * masStoreBudgetTObj.setSrNo(srNo[i]);
	 *
	 * masStoreBudgetTObj.setAuthorityLetterNo(authorityLetterNo[i]);
	 *
	 * masStoreBudgetTObj.setProjectAmount(projectAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setBudgetedAmount(budgetedAmountArray[i]);
	 *
	 * masStoreBudgetTObj.setAdditionalAmount(additionalAmountArray[i]);
	 *
	 * masStoreBudgetTList.add(masStoreBudgetTObj); }
	 *
	 *
	 * }catch (Exception e) { e.printStackTrace(); }
	 *
	 *
	 *
	 * 
	 * map=(Map)pharmacyMasterHandlerService.showBudgetJsp();
	 *
	 * jsp = "message";
	 *
	 * infoMap.put("pageNo",pageNo); infoMap.put("budgetId", budgetId); boolean
	 * flag=false; try{
	 * flag=pharmacyMasterHandlerService.addBudgetEntry(masStoreBudget,
	 * masStoreBudgetTList, infoMap);
	 * budgetId=pharmacyMasterHandlerService.getMasStoreBudgetId
	 * (Integer.parseInt(budgetCode));  }catch
	 * (Exception e) { e.printStackTrace(); } String
	 * messageTOBeVisibleToTheUser=""; if(flag){ jsp="budgetEntry"; pageNo++;
	 *  messageTOBeVisibleToTheUser="Added"; }else {
	 *  messageTOBeVisibleToTheUser="Not Added";
	 * }
	 *
	 * jsp += ".jsp";
	 *
	 * map.put("budgetId", budgetId); map.put("pageNo",pageNo);
	 * map.put("contentJsp",jsp);
	 * map.put("messageTOBeVisibleToTheUser",messageTOBeVisibleToTheUser);
	 * return new ModelAndView("index", "map", map); }
	 */

	public ModelAndView addBudgetDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> budgetMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = (Map<String, Object>) HMSUtil
				.getCurrentDateAndTime();
		List<MasStoreBudget> financialYearList = new ArrayList<MasStoreBudget>();

		MasStoreBudgetT masStoreBudgetT = new MasStoreBudgetT();
		MasStoreBudget masStoreBudgetObj = new MasStoreBudget();

		int budgetId = 0;
		int financialId = 0;
		BigDecimal crvAmount = null;
		float totalAmount = 0.0f;
		float poAmount = 0.0f;
		float spendAmount = 0.0f;
		String authorityLetterNo = "";
		float projectAmount = 0.0f;
		float budgetedAmount = 0.0f;
		float additionalAllocatedAmount = 0.0f;

		float prevSpendAmount = 0.0f;
		float currentSpendAmount = 0.0f;
		float balanceAmount = 0.0f;

		String currentDate = "";
		String currentTime = "";

		if (!request.getParameter(FINANCIAL_ID).equals("0")) {
			financialId = Integer.parseInt(request.getParameter(FINANCIAL_ID));
			
		}
		// List<MasStoreBudget> financialYearList =
		// pharmacyMasterHandlerService.getFinancialYearDetails(financialId);
		map = pharmacyMasterHandlerService.getFinancialYearDetails(financialId);

		if (map.get("financialYearList") != null) {
			financialYearList = (List<MasStoreBudget>) map
					.get("financialYearList");
		}

		for (MasStoreBudget masStoreBudget : financialYearList) {
			budgetId = masStoreBudget.getId();
			crvAmount = masStoreBudget.getCrvComittedAmount();
			totalAmount = masStoreBudget.getTotalAllocatedAmount().floatValue();
			poAmount = masStoreBudget.getPoComittedAmount().floatValue();
			spendAmount = masStoreBudget.getSpendAmount().floatValue();
			log.debug("FINANCIAL VALUES---" + crvAmount + "--"
					+ totalAmount + "--" + poAmount);
		}

		// MasStoreBudget details from budgetEntry.jsp
		if (request.getParameter(PREVIOUS_SPEND_AMOUNT) != null
				&& !request.getParameter(PREVIOUS_SPEND_AMOUNT).equals("")) {
			prevSpendAmount = Float.parseFloat(request
					.getParameter(PREVIOUS_SPEND_AMOUNT));
			budgetMap.put("prevSpendAmount", prevSpendAmount);
		}
		if (request.getParameter(SPEND_AMOUNT) != null
				&& !request.getParameter(SPEND_AMOUNT).equals("")) {
			currentSpendAmount = Float.parseFloat(request
					.getParameter(SPEND_AMOUNT));
			budgetMap.put("currentSpendAmount", currentSpendAmount);
		}
		if (request.getParameter(BALANCE_AMOUNT) != null
				&& !request.getParameter(BALANCE_AMOUNT).equals("")) {
			balanceAmount = Float.parseFloat(request
					.getParameter(BALANCE_AMOUNT));
			budgetMap.put("balanceAmount", balanceAmount);
		}

		currentDate = (String) utilMap.get("currentDate");
		currentTime = (String) utilMap.get("currentTime");
		budgetMap.put("currentDate", currentDate);
		budgetMap.put("currentTime", currentTime);

		// MasStoreBudgetT details from budgetEntry.jsp
		if (request.getParameter(AUTHORITY_LETTER_NO) != null) {
			authorityLetterNo = request.getParameter(AUTHORITY_LETTER_NO);
			masStoreBudgetT.setAuthorityLetterNo(authorityLetterNo);
		}
		if (request.getParameter(PROJECT_AMOUNT) != null) {
			projectAmount = Float.parseFloat(request
					.getParameter(PROJECT_AMOUNT));
			BigDecimal projectAmt = new BigDecimal(projectAmount);
			masStoreBudgetT.setProjectAmount(projectAmt);
		}
		if (request.getParameter(BUDGETED_AMOUNT) != null) {
			budgetedAmount = Float.parseFloat(request
					.getParameter(BUDGETED_AMOUNT));
			BigDecimal budgetedAmt = new BigDecimal(budgetedAmount);
			masStoreBudgetT.setBudgetedAmount(budgetedAmt);
		}
		if (request.getParameter(ADDITIONAL_ALLOCATED_AMOUNT) != null
				&& !request.getParameter(ADDITIONAL_ALLOCATED_AMOUNT)
						.equals("")) {
			additionalAllocatedAmount = Float.parseFloat(request
					.getParameter(ADDITIONAL_ALLOCATED_AMOUNT));
			BigDecimal additionalAllocatedAmt = new BigDecimal(
					additionalAllocatedAmount);
			masStoreBudgetT.setAdditionalAmount(additionalAllocatedAmt);
		}
		// int srNo = 1;
		MasStoreBudget masStoreBudget = new MasStoreBudget();
		masStoreBudget.setId(budgetId);
		masStoreBudgetT.setBudget(masStoreBudget);
		// masStoreBudgetT.setSrNo(srNo++);

		budgetMap.put("masStoreBudgetT", masStoreBudgetT);
		budgetMap.put("masStoreBudgetObj", masStoreBudgetObj);
		budgetMap.put("budgetId", budgetId);

		boolean flag = pharmacyMasterHandlerService.addBudgetDetails(budgetMap);
		String messageTOBeVisibleToTheUser = "";

		if (flag) {
			messageTOBeVisibleToTheUser = "Budget Details has been added successfully.";
		} else {
			messageTOBeVisibleToTheUser = "Budget Details has not been added successfully.";
		}

		map.put("crvAmount", crvAmount);
		map.put("totalAmount", totalAmount);
		map.put("poAmount", poAmount);
		map.put("spendAmount", spendAmount);
		url = "/hms/hms/pharmacy?method=showBudgetJsp";
		jsp = MESSAGE_JSP;

		jsp += ".jsp";
		map.put("url", url);
		map.put("contentJsp", jsp);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getFinancialYearDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasStoreBudget> financialYearList = new ArrayList<MasStoreBudget>();
		List<MasStoreBudget> budgetDetailsList = new ArrayList<MasStoreBudget>();

		int financialId = 0;
		BigDecimal crvAmount = null;
		float totalAmount = 0.0f;
		float poAmount = 0.0f;
		float spendAmount = 0.0f;

		if (!request.getParameter("financialId").equals("0")) {
			financialId = Integer.parseInt(request.getParameter("financialId"));
			
		}
		map = pharmacyMasterHandlerService.getFinancialYearDetails(financialId);

		if (map.get("financialYearList") != null) {
			financialYearList = (List<MasStoreBudget>) map
					.get("financialYearList");
		}
		if (map.get("budgetDetailsList") != null) {
			budgetDetailsList = (List<MasStoreBudget>) map
					.get("budgetDetailsList");
		}
		for (MasStoreBudget masStoreBudget : financialYearList) {
			
			crvAmount = masStoreBudget.getCrvComittedAmount();
			totalAmount = masStoreBudget.getTotalAllocatedAmount().floatValue();
			poAmount = masStoreBudget.getPoComittedAmount().floatValue();
			spendAmount = masStoreBudget.getSpendAmount().floatValue();
		}
		map.put("crvAmount", crvAmount);
		map.put("totalAmount", totalAmount);
		map.put("poAmount", poAmount);
		map.put("spendAmount", spendAmount);
		map.put("budgetDetailsList", budgetDetailsList);

		jsp = BUDGET_DETAILS_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 *
	 * public ModelAndView searchBudget(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletRequestBindingException {
	 *
	 * Map<String, Object> map= new HashMap<String, Object>(); String budgetCode
	 * = "";
	 *
	 * if(request.getParameter(CODE) != null &&
	 * !(request.getParameter(CODE).equals(""))){ budgetCode =
	 * request.getParameter(CODE); }
	 *
	 * map = pharmacyMasterHandlerService.searchBudget(budgetCode);
	 * jsp=BUDGET_ENTRY_JSP; jsp += ".jsp"; map.put("budgetCode", budgetCode);
	 * map.put("contentJsp",jsp); map.put("title", title);
	 *
	 * return new ModelAndView("index", "map", map); } public ModelAndView
	 * addBudget(HttpServletRequest request, HttpServletResponse response) {
	 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
	 * Object> listMap = new HashMap<String, Object>(); Map<String, Object>
	 * generalMap = new HashMap<String, Object>(); MasStoreBudget masStoreBudget
	 * = new MasStoreBudget(); int financialId= 0; String budgetCode=""; Float
	 * totalAllocatedAmount = null; Float crvComittedAmount = null; Float
	 * poCommitedAmount = null; Float utilizedAmount = null; Date changedDate =
	 * null; String changedBy = ""; String changedTime = "";
	 *
	 * if(request.getParameter(CODE) != null &&
	 * !(request.getParameter(CODE).equals(""))){ budgetCode =
	 * request.getParameter(CODE); }
	 * if(!request.getParameter(FINANCIAL_ID).equals("0")){ financialId =
	 * Integer.parseInt(request.getParameter(FINANCIAL_ID)); }
	 * if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null &&
	 * !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
	 * totalAllocatedAmount =
	 * Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT)); }
	 * if(request.getParameter(CRV_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
	 * crvComittedAmount =
	 * Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(PO_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
	 * poCommitedAmount =
	 * Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(UTILIZED_AMOUNT) != null &&
	 * !(request.getParameter(UTILIZED_AMOUNT).equals(""))){ utilizedAmount =
	 * Float.parseFloat(request.getParameter(UTILIZED_AMOUNT)); }
	 * if(request.getParameter(CHANGED_BY) !=null){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null){ changedDate =
	 * HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null){ changedTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter("pojoName")
	 * != null){ pojoName = request.getParameter("pojoName"); }
	 * if(request.getParameter("pojoPropertyCode") != null){ pojoPropertyCode =
	 * request.getParameter("pojoPropertyCode"); }
	 * if(request.getParameter("pojoPropertyName") != null){ pojoPropertyName =
	 * request.getParameter("pojoPropertyName"); }
	 * if(request.getParameter("jspName") != null){ jspName =
	 * request.getParameter("jspName"); } if(request.getParameter("title") !=
	 * null){ title = request.getParameter("title"); }
	 *
	 * generalMap.put("code", budgetCode); generalMap.put("currentDate",
	 * currentDate); generalMap.put("currentTime", currentTime);
	 * generalMap.put("pojoPropertyName", pojoPropertyName);
	 * generalMap.put("pojoPropertyCode", pojoPropertyCode);
	 * generalMap.put("pojoName", pojoName);
	 *
	 * listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
	 * List<MasStoreBudget> budgetCodeList = new ArrayList<MasStoreBudget>();
	 *
	 * if(listMap.get("duplicateGeneralCodeList") != null){ budgetCodeList =
	 * (List)listMap.get("duplicateGeneralCodeList"); }
	 *
	 * boolean successfullyAdded = false; if(budgetCodeList.size() == 0) {
	 * masStoreBudget.setBudgetCode(budgetCode);
	 *
	 * MasStoreFinancial financialObj = new MasStoreFinancial();
	 * financialObj.setId(financialId);
	 * masStoreBudget.setFinancial(financialObj);
	 *
	 * masStoreBudget.setTotalAllocatedAmount(totalAllocatedAmount);
	 * masStoreBudget.setCrvComittedAmount(crvComittedAmount);
	 * masStoreBudget.setPoComittedAmount(poCommitedAmount);
	 * masStoreBudget.setUtilizedAmount(utilizedAmount);
	 * masStoreBudget.setStatus("y"); masStoreBudget.setLastChgBy(changedBy);
	 * masStoreBudget.setLastChgDate(changedDate);
	 * masStoreBudget.setLastChgTime(changedTime); successfullyAdded =
	 * pharmacyMasterHandlerService.addBudget(masStoreBudget);
	 * if(successfullyAdded == true){ message="Record Added Successfully !!";
	 * }else{ message = "Try Again !!"; }
	 *
	 * }else if(budgetCodeList.size() != 0){ message = "Budget Code already
	 * exists."; } try{ map = pharmacyMasterHandlerService.showBudgetJsp();
	 * }catch (Exception e) { log.error("Exception in showBudgetJsp
	 * "+e); } jsp=BUDGET_JSP; title="Add Budget"; jsp += ".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); } public
	 * ModelAndView editBudget(HttpServletRequest request, HttpServletResponse
	 * response) { Map<String, Object> map = new HashMap<String, Object>();
	 * Map<String, Object> generalMap = new HashMap<String, Object>(); int
	 * budgetId=0; int financialId= 0; Float totalAllocatedAmount = null; Float
	 * crvComittedAmount = null; Float poCommitedAmount = null; Float
	 * utilizedAmount = null; String changedBy = ""; String changedTime=""; Date
	 * changedDate = new Date(); session = request.getSession();
	 *
	 * if(request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))){ budgetId
	 * =Integer.parseInt( request.getParameter(COMMON_ID)); }
	 * if(request.getParameter(CODE) != null &&
	 * !(request.getParameter(CODE).equals(""))){ code =
	 * request.getParameter(CODE); }
	 * if(!request.getParameter(FINANCIAL_ID).equals("0")){ financialId =
	 * Integer.parseInt(request.getParameter(FINANCIAL_ID)); }
	 * if(request.getParameter(TOTAL_ALLOCATED_AMOUNT) != null &&
	 * !(request.getParameter(TOTAL_ALLOCATED_AMOUNT).equals(""))){
	 * totalAllocatedAmount =
	 * Float.parseFloat(request.getParameter(TOTAL_ALLOCATED_AMOUNT)); }
	 * if(request.getParameter(CRV_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(CRV_COMMITTED_AMOUNT).equals(""))){
	 * crvComittedAmount =
	 * Float.parseFloat(request.getParameter(CRV_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(PO_COMMITTED_AMOUNT) != null &&
	 * !(request.getParameter(PO_COMMITTED_AMOUNT).equals(""))){
	 * poCommitedAmount =
	 * Float.parseFloat(request.getParameter(PO_COMMITTED_AMOUNT)); }
	 * if(request.getParameter(UTILIZED_AMOUNT) != null &&
	 * !(request.getParameter(UTILIZED_AMOUNT).equals(""))){ utilizedAmount =
	 * Float.parseFloat(request.getParameter(UTILIZED_AMOUNT)); }
	 * if(request.getParameter(CHANGED_BY) != null &&
	 * !(request.getParameter(CHANGED_BY).equals(""))){ changedBy =
	 * request.getParameter(CHANGED_BY); } if(request.getParameter(CHANGED_DATE)
	 * != null && !(request.getParameter(CHANGED_DATE).equals(""))){ changedDate
	 * = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)); }
	 * if(request.getParameter(CHANGED_TIME) != null &&
	 * !(request.getParameter(CHANGED_TIME).equals(""))){ currentTime =
	 * request.getParameter(CHANGED_TIME); } if(request.getParameter("pojoName")
	 * != null){ pojoName = request.getParameter("pojoName"); }
	 * if(request.getParameter("pojoPropertyCode") != null){ pojoPropertyCode =
	 * request.getParameter("pojoPropertyCode"); }
	 * if(request.getParameter("title") != null){ title =
	 * request.getParameter("title"); }
	 *
	 * changedDate = new Date(); changedTime =
	 * (String)HMSUtil.getCurrentDateAndTime().get("currentTime");
	 * generalMap.put("id", budgetId); generalMap.put("code", code);
	 * generalMap.put("financialId", financialId);
	 * generalMap.put("totalAllocatedAmount", totalAllocatedAmount);
	 * generalMap.put("crvComittedAmount", crvComittedAmount);
	 * generalMap.put("poCommitedAmount", poCommitedAmount);
	 * generalMap.put("utlizedAmount", utilizedAmount);
	 * generalMap.put("changedBy", changedBy); generalMap.put("changedDate",
	 * changedDate); generalMap.put("currentTime", changedTime); boolean
	 * dataUpdated=false;
	 * dataUpdated=pharmacyMasterHandlerService.editBudgetToDatabase
	 * (generalMap);
	 *
	 * if(dataUpdated==true){ message="Record Updated Successfully !!"; } else{
	 * message="Record Cant Be Updated !!"; } url =
	 * "/hms/hms/pharmacy?method=showBudgetJsp"; try{ map =
	 * pharmacyMasterHandlerService.showBudgetJsp(); }catch (Exception e) {
	 *  }
	 * jsp=BUDGET_ENTRY_JSP; title="Add Budget"; jsp += ".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 *
	 * public ModelAndView deletebudget(HttpServletRequest request,
	 * HttpServletResponse response) {
	 *
	 * Map<String, Object> map = new HashMap<String, Object>(); int budgetId=0;
	 * String message=null; String changedBy = ""; String changedTime = ""; Date
	 * changedDate = null;
	 *
	 * if(request.getParameter(COMMON_ID) != null &&
	 * !(request.getParameter(COMMON_ID).equals(""))){ budgetId
	 * =Integer.parseInt( request.getParameter(COMMON_ID)); }
	 * if(request.getParameter("title") != null){ title =
	 * request.getParameter("title"); } boolean dataDeleted=false;
	 * dataDeleted=pharmacyMasterHandlerService
	 * .deleteBudget(budgetId,generalMap); if (dataDeleted==true) {
	 * message="Record is InActivated successfully !!"; }
	 *
	 * else{ message="Record is Activated successfully !!"; } url =
	 * "/hms/hms/pharmacy?method=showBudgetJsp"; try{ map =
	 * pharmacyMasterHandlerService.showBudgetJsp(); }catch (Exception e) {
	 *  }
	 * jsp=BUDGET_ENTRY_JSP; title="delete Budget"; jsp += ".jsp";
	 * map.put("contentJsp", jsp); map.put("title", title); map.put("message",
	 * message); return new ModelAndView("index", "map", map); }
	 */
	// -----------------------Me Scale----------------------------------------
	public ModelAndView showMeScaleJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showMeScaleJsp();
		jsp = ME_SCALE_JSP;
		jsp += ".jsp";
		title = "MeScale";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMeScale(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		int meScaleNumber = 0;

		if (request.getParameter(ME_SCALE_NUMBER) != null
				&& !(request.getParameter(ME_SCALE_NUMBER).equals(""))) {
			meScaleNumber = Integer.parseInt(request
					.getParameter(ME_SCALE_NUMBER));
		}

		map = pharmacyMasterHandlerService.searchMeScale1(meScaleNumber);
		jsp = ME_SCALE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("meScaleNumber", meScaleNumber);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addMeScale(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
		int meScaleNumber = 0;
		String meScaleDescription = "";
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";

		if (request.getParameter(ME_SCALE_NUMBER) != null
				&& !(request.getParameter(ME_SCALE_NUMBER).equals(""))) {
			meScaleNumber = Integer.parseInt(request
					.getParameter(ME_SCALE_NUMBER));
		}
		if (request.getParameter(ME_SCALE_DESCRIPTION) != null
				&& !(request.getParameter(ME_SCALE_DESCRIPTION).equals(""))) {
			meScaleDescription = request.getParameter(ME_SCALE_DESCRIPTION);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
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
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("meScaleNumber", meScaleNumber);
		generalMap.put("meScaleDescription", meScaleDescription);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List meScaleNumberList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			meScaleNumberList = (List) listMap.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if (meScaleNumberList.size() == 0) {
			masStoreMeScale.setMeScale(meScaleNumber);
			masStoreMeScale.setMeScaleDescription(meScaleDescription);
			masStoreMeScale.setStatus("y");
			masStoreMeScale.setLastChgBy(changedBy);
			masStoreMeScale.setLastChgDate(changedDate);
			masStoreMeScale.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addMeScale(masStoreMeScale);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (meScaleNumberList.size() != 0) {
			message = "MeScale Number already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showMeScaleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ME_SCALE_JSP;
		title = "Add MeScale";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editMeScale(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		MasStoreMeScale masStoreMeScale = new MasStoreMeScale();
		int meScaleNumber = 0;
		int meScaleId = 0;
		String meScaleDescription = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = new Date();
		session = request.getSession();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			meScaleId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(ME_SCALE_NUMBER) != null
				&& !(request.getParameter(ME_SCALE_NUMBER).equals(""))) {
			meScaleNumber = Integer.parseInt(request
					.getParameter(ME_SCALE_NUMBER));
		}
		if (request.getParameter(ME_SCALE_DESCRIPTION) != null
				&& !(request.getParameter(ME_SCALE_DESCRIPTION).equals(""))) {
			meScaleDescription = request.getParameter(ME_SCALE_DESCRIPTION);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", meScaleId);
		generalMap.put("meScaleNumber", meScaleNumber);
		generalMap.put("meScaleDescription", meScaleDescription);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated = false;
		dataUpdated = pharmacyMasterHandlerService
				.editMeScaleToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showMeScaleJsp";
		try {
			map = pharmacyMasterHandlerService.showMeScaleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ME_SCALE_JSP;
		title = "Edit MeScale";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteMeScale(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int meScaleId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			meScaleId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteMeScale(meScaleId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showMeScaleJsp";
		try {
			map = pharmacyMasterHandlerService.showMeScaleJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = ME_SCALE_JSP;
		title = "delete MeScale";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------AirForce Unit Depot
	// Report-------------------------------------------------------

	public ModelAndView reportAirForceUnitDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Air_Force_Depot", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// --------------------------AirForce Unit
	// Depot-------------------------------------
	public ModelAndView showAirForceUnitDepotJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		jsp += ".jsp";
		title = "airForceUnitDepot";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAirForceUnitDepot(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		String airForceDepotName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			airForceDepotName = request.getParameter(SEARCH_NAME);
		}

		map = pharmacyMasterHandlerService
				.searchAirForceUnitDepot(airForceDepotName);
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("airForceDepotName", airForceDepotName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addAirForceUnitDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasStoreAirForceDepot masStoreAirForceDepot = new MasStoreAirForceDepot();
		String airForceDepotName = "";
		String type = "";
		Date changedDate = null;
		String changedBy = "";
		String changedTime = "";

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			airForceDepotName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE) != null) {
			type = request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (request.getParameter("jspName") != null) {
			jspName = request.getParameter("jspName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		generalMap.put("name", airForceDepotName);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List airForceDepotNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			airForceDepotNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}

		boolean successfullyAdded = false;
		if (airForceDepotNameList.size() == 0) {
			masStoreAirForceDepot.setAirForceDepotName(airForceDepotName);
			masStoreAirForceDepot.setAirForceDepotType(type);
			masStoreAirForceDepot.setStatus("y");
			masStoreAirForceDepot.setLastChgBy(changedBy);
			masStoreAirForceDepot.setLastChgDate(changedDate);
			masStoreAirForceDepot.setLastChgTime(changedTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addAirForceUnitDepot(masStoreAirForceDepot);
			if (successfullyAdded == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}

		} else if (airForceDepotNameList.size() != 0) {
			message = "AF Unit Depot Name already exists.";
		}
		try {
			map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		title = "Add AirForceUnitDepot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAirForceUnitDepot(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		// MasStoreAirForceDepot masStoreAirForceDepot = new
		// MasStoreAirForceDepot();
		String airForceDepotName = "";
		int airForceDepotId = 0;
		String type = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = new Date();
		session = request.getSession();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			airForceDepotId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			airForceDepotName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE) != null) {
			type = request.getParameter(AIR_FORCE_UNIT_DEPOT_TYPE);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", airForceDepotId);
		generalMap.put("airForceDepotName", airForceDepotName);
		generalMap.put("type", type);
		generalMap.put("changedBy", changedBy);
		generalMap.put("changedDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataUpdated = false;
		dataUpdated = pharmacyMasterHandlerService
				.editAirForceUnitDepotToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/pharmacy?method=showAirForceUnitDepotJsp";
		try {
			map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		title = "edit AirForceUnitDepot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAirForceUnitDepot(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		int airForceDepotId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			airForceDepotId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = pharmacyMasterHandlerService.deleteAirForceUnitDepot(
				airForceDepotId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showAirForceUnitDepotJsp";
		try {
			map = pharmacyMasterHandlerService.showAirForceUnitDepotJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = AIR_FORCE_UNIT_DEPOT_JSP;
		title = "delete AirForceUnitDepot";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Item Conversion
	// Report-------------------------------------------------------

	public ModelAndView reportItemConversion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = pharmacyMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Item_Conversion", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// -----------------------Item
	// Conversion--------------------------------------

	public ModelAndView searchItemConversion(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String itemUnitName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			itemUnitName = request.getParameter(SEARCH_NAME);
		}
		map = pharmacyMasterHandlerService.searchItemConversion(itemUnitName);

		jsp = STORE_ITEM_CONVERSION_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("itemUnitName", itemUnitName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showItemConversionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		map = pharmacyMasterHandlerService.showItemConversionJsp();
		jsp = STORE_ITEM_CONVERSION_JSP;
		jsp += ".jsp";
		title = "ItemConversion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addItemConversion(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
		int userId=0;
		session = request.getSession();
		int purchaseUnitId = 0;
		int intermediateUnitid = 0;
		int issueUnitId = 0;
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (!request.getParameter(PURCHASE_UNIT_ID).equals("0")) {
			purchaseUnitId = Integer.parseInt(request
					.getParameter(PURCHASE_UNIT_ID));

		}
		if (!request.getParameter(INTERMEDIATE_UNIT_ID).equals("0")) {
			intermediateUnitid = Integer.parseInt(request
					.getParameter(INTERMEDIATE_UNIT_ID));
		}
		if (!request.getParameter(ISSUE_UNIT_ID).equals("0")) {
			issueUnitId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));
		}
		if (!request.getParameter(CONVERSION_FACTOR).equals("0")) {
			try {
				conversionFactor1 = Integer.parseInt(request.getParameter(
						CONVERSION_FACTOR).trim());
			} catch (Exception e) {
				conversionFactor1 = 0;
			}
		}
		if (!request.getParameter(CONVERSION_FACTOR2).equals("0")) {
			try {
				conversionFactor2 = Integer.parseInt(request.getParameter(
						CONVERSION_FACTOR2).trim());
			} catch (Exception e) {
				conversionFactor2 = 0;
			}
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
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
	
		
		generalMap.put("name", name);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List itemUnitNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			itemUnitNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((itemUnitNameList.size() == 0 || itemUnitNameList == null))

		{
			masStoreItemConversion.setItemUnitName(name);

			MasStoreUnit masStoreUnitPurchase = new MasStoreUnit();
			masStoreUnitPurchase.setId(purchaseUnitId);
			masStoreItemConversion.setPurchaseUnit(masStoreUnitPurchase);

			MasStoreUnit masStoreUnitIntermediate = new MasStoreUnit();
			masStoreUnitIntermediate.setId(intermediateUnitid);
			masStoreItemConversion
					.setIntermediateUnit(masStoreUnitIntermediate);

			MasStoreUnit masStoreUnitIssue = new MasStoreUnit();
			masStoreUnitIssue.setId(issueUnitId);
			masStoreItemConversion.setIssueUnit(masStoreUnitIssue);

			masStoreItemConversion.setConversionFactor1(conversionFactor1);
			masStoreItemConversion.setConversionFactor2(conversionFactor2);

			masStoreItemConversion.setStatus("y");
			
			Users users = new Users();
			users.setId(userId);
			masStoreItemConversion.setLastChgBy(users);
			
			masStoreItemConversion.setLastChgDate(currentDate);
			masStoreItemConversion.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addItemConversion(masStoreItemConversion);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((itemUnitNameList.size() != 0) || itemUnitNameList != null) {
			message = "Item Unit Name  already exists.";
		}

		url = "/hms/hms/pharmacy?method=showCountryJsp";

		try {
			map = pharmacyMasterHandlerService.showItemConversionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_CONVERSION_JSP;
		title = "Add Item Conversion";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editItemConversion(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		// MasStoreItemConversion masStoreItemConversion=new
		// MasStoreItemConversion();
		int itemConversionId = 0;
		int purchaseUnitId = 0;
		int intermediateUnitid = 0;
		int issueUnitId = 0;
		int userId=0;
		int conversionFactor1 = 0;
		int conversionFactor2 = 0;
		Date changedDate = null;
		String changedTime = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		// Date currentDate = new Date();

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemConversionId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(PURCHASE_UNIT_ID) != null) {
			purchaseUnitId = Integer.parseInt(request
					.getParameter(PURCHASE_UNIT_ID));

		}
		if (request.getParameter(INTERMEDIATE_UNIT_ID) != null) {
			intermediateUnitid = Integer.parseInt(request
					.getParameter(INTERMEDIATE_UNIT_ID));

		}
		if (request.getParameter(ISSUE_UNIT_ID) != null) {
			issueUnitId = Integer.parseInt(request.getParameter(ISSUE_UNIT_ID));

		}
		if (request.getParameter(CONVERSION_FACTOR) != null) {
			conversionFactor1 = Integer.parseInt(request
					.getParameter(CONVERSION_FACTOR));
		}

		if (request.getParameter(CONVERSION_FACTOR2) != null) {
			conversionFactor2 = Integer.parseInt(request
					.getParameter(CONVERSION_FACTOR2));
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("id", itemConversionId);
		generalMap.put("name", name);
		generalMap.put("purchaseUnitId", purchaseUnitId);
		generalMap.put("intermediateUnitid", intermediateUnitid);
		generalMap.put("issueUnitId", issueUnitId);
		generalMap.put("conversionFactor1", conversionFactor1);
		generalMap.put("conversionFactor2", conversionFactor2);
		
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingItemConversionNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingItemConversionNameList.size() == 0) {

			dataUpdated = pharmacyMasterHandlerService
					.editItemConversionToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant Be Updated !!";
			}
		} else if (existingItemConversionNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/pharmacy?method=showItemConversionJsp";
		try {
			map = pharmacyMasterHandlerService.showItemConversionJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_CONVERSION_JSP;
		title = "Update Item Conversion ";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteItemConversion(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int itemConversionId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			itemConversionId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteItemConversion(
				itemConversionId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/pharmacy?method=showItemConversionJsp";
		try {
			map = pharmacyMasterHandlerService.showItemConversionJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_ITEM_CONVERSION_JSP;
		title = "delete Item Conversion";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------Mas Store
	// Group---------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showStoreGroupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = pharmacyMasterHandlerService.showStoreGroupJsp();
		jsp = STORE_GROUP_JSP;
		jsp += ".jsp";
		title = "PVMS/NIV Groups Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchStoreGroup(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String groupCode = null;
		String groupName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
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
			groupCode = searchField;
			groupName = null;

		} else {
			groupCode = null;
			groupName = searchField;
		}
		map = pharmacyMasterHandlerService.searchStoreGroup(groupCode,
				groupName);
		jsp = STORE_GROUP_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("groupCode", groupCode);
		map.put("groupName", groupName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addStoreGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreGroup masStoreGroup = new MasStoreGroup();
		int userId = 0;
		session = request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
/*if (request.getParameter(ITEM_TYPE_ID) != null) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}*/

	
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
		
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("code", code);
		generalMap.put("name", name);
		//generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List groupCodeList = new ArrayList();
		List groupNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			groupCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			groupNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((groupCodeList.size() == 0 || groupCodeList == null)
				&& (groupNameList.size() == 0 || groupNameList == null)) {
			masStoreGroup.setGroupCode(code);
			masStoreGroup.setGroupName(name);
			/*if (itemTypeId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(itemTypeId);
				masStoreGroup.setDepartment(masDepartment);
			}*/
			masStoreGroup.setStatus("y");
			Users users = new Users();
			users.setId(userId);
			masStoreGroup.setLastChgBy(users);
			
			masStoreGroup.setLastChgDate(currentDate);
			masStoreGroup.setLastChgTime(currentTime);
			successfullyAdded = pharmacyMasterHandlerService
					.addStoreGroup(masStoreGroup);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((groupCodeList.size() != 0 || groupCodeList != null)
				|| (groupNameList.size() != 0) || groupNameList != null) {
			if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() == 0 || groupNameList == null)) {
				message = "Group Code already exists.";
			} else if ((groupNameList.size() != 0 || groupNameList != null)
					&& (groupCodeList.size() == 0 || groupCodeList == null)) {
				message = "Group Name already exists.";
			} else if ((groupCodeList.size() != 0 || groupCodeList != null)
					&& (groupNameList.size() != 0 || groupNameList != null)) {
				message = "Group Code and Relation Name already exist.";
			}
		}
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title = "Add PVMS/NIV Group";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editStoreGroup(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String groupCode = "";
		String groupName = "";
		int groupId = 0;
		int itemTypeId = 0;
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			groupCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			groupName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(ITEM_TYPE_ID) != null
				&& !(request.getParameter(ITEM_TYPE_ID).equals(""))) {
			itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
		}

	
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
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
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", groupId);
		generalMap.put("groupCode", groupCode);
		generalMap.put("name", groupName);
		generalMap.put("itemTypeId", itemTypeId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingGroupNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingGroupNameList.size() == 0) {

			dataUpdated = pharmacyMasterHandlerService
					.editGroupToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingGroupNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title = "Update PVMS/NIV Groups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteStoreGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int groupId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			groupId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		int userId = 0;
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = pharmacyMasterHandlerService.deleteStoreGroup(groupId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showStoreGroupJsp";
		try {
			map = pharmacyMasterHandlerService.showStoreGroupJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = STORE_GROUP_JSP;
		title = "Delete PVMS/NIV Groups";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getGroupDepartmentWise(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int departmentId = 0;

		if (request.getParameter(ITEM_TYPE_ID) != null
				&& !(request.getParameter(ITEM_TYPE_ID).equals(""))) {
			departmentId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID)
					.toString());
		}

		generalMap.put("departmentId", departmentId);

		map = pharmacyMasterHandlerService.getGroupDepartmentWise(generalMap);

		jsp = "showGroupForDepartment";

		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}
	

	public ModelAndView getItemTypeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int group = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("group") != null) {
			group = Integer.parseInt(request.getParameter("group"));
		}
		dataMap.put("group", group);
		map = pharmacyMasterHandlerService.getItemTypeList(dataMap);

		jsp = "responseItemType";


		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	 
	 public ModelAndView getSectionList(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
			int itemType = 0;
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("itemType") != null) {
					itemType = Integer.parseInt(request.getParameter("itemType"));
				}
				dataMap.put("itemType", itemType);
				map = pharmacyMasterHandlerService.getSectionList(dataMap);
				jsp = "responseSection";
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}

	// ---------------------------Item  Master Gobal Med ----------------------------------------------
	 
	 

		public ModelAndView getItemTypeGLList(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int group = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("group") != null) {
				group = Integer.parseInt(request.getParameter("group"));
			}
			dataMap.put("group", group);
			map = pharmacyMasterHandlerService.getItemTypeGLList(dataMap);

			jsp = "responseItemTypeGL";


			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}

		 
		 public ModelAndView getSectionGLList(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
				int itemType = 0;
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("itemType") != null) {
						itemType = Integer.parseInt(request.getParameter("itemType"));
					}
					dataMap.put("itemType", itemType);
					map = pharmacyMasterHandlerService.getSectionGLList(dataMap);
					jsp = "responseSectionGL";
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("contentJsp", jsp);
				return new ModelAndView(jsp, "map", map);
			}
		 public ModelAndView getCategoryList(HttpServletRequest request,
					HttpServletResponse response) {
			 System.out.println("getCategoryList function call");
				Map<String, Object> map = new HashMap<String, Object>();
				int section = 0;
				try {
					Box box = HMSUtil.getBox(request);
					if (request.getParameter("section") != null) {
						section = Integer.parseInt(request.getParameter("section"));
					}
					box.put("section", section);
				map =pharmacyMasterHandlerService.getCategoryList(box);
					jsp = "responseForCategoryGL";
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("contentJsp", jsp);
				return new ModelAndView(jsp, "map", map);
			}

		public ModelAndView showItemGlobalMedJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			map = pharmacyMasterHandlerService.showItemGlobalMedJsp(deptId);
			jsp = "itemGlobalMed";
			jsp += ".jsp";
			title = "Item";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView searchItemGlobalMed(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String pvmsNo = null;
			String nomenclature = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				pvmsNo = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				nomenclature = request.getParameter(SEARCH_NAME);
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
			System.out.println("searchField"+searchField);
			if (searchRadio == 1) {
				pvmsNo = searchField;
				nomenclature = null;
			} else {
				pvmsNo = null;
				nomenclature = searchField;
			}
			map = pharmacyMasterHandlerService.searchItemGlobalMed(pvmsNo, nomenclature);

			jsp = "itemGlobalMed";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pvmsNo", pvmsNo);
			map.put("nomenclature", nomenclature);
			return new ModelAndView("index", "map", map);

		}

		@SuppressWarnings("unchecked")
		public ModelAndView addItemGlobalMed(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			MasStoreItem masStoreItem = new MasStoreItem();
			String message = null;
			int sectionId = 0;
			int itemTypeId = 0;
			int itemCategoryId = 0;
			int itemConversionId = 0;
			int groupId = 0;
			String pvms = "";
			String commonName = "";
			String specification = "";
			Date changedDate = null;
			String changedTime = "";
int route=0;
		

			String expiry = "";
			String tempreture = "";
			BigDecimal minTempreture = null;
			BigDecimal maxTempreture = null;
			BigDecimal uomQty  = null;
			int itemClassId=0;
			
			//String standardAvailability="";
			
			Map listMap = new HashMap();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			map.put("deptId", deptId);
			
			/*
			if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
				
				standardAvailability = request.getParameter("standardAvailability");
			}*/
			
			
			String standardAvailability = "";
			String[] standardAvailabilityArray = null;
			if (request.getParameterValues("standardAvailability") != null) {
				standardAvailabilityArray = (String[])request.getParameterValues("standardAvailability");
				for (int x = 0; x < standardAvailabilityArray.length; x++) {
					if (x == 0) {
						standardAvailability = standardAvailabilityArray[x];
					} else {
						standardAvailability = standardAvailability + ","	+ standardAvailabilityArray[x];
					}
				}
			}
			
			if (!request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}
			
			if (request.getParameter("otc") != null) {
				masStoreItem.setOtcType(request.getParameter("otc"));

			} else {
				masStoreItem.setOtcType("n");
			}
			
			if (request.getParameter(DANGEROUS_DRUG) != null) {
				masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));

			} else {
				masStoreItem.setDangerousDrug("n");
			}
			
			if (request.getParameter(CONTROLLED_DRUG) != null) {
				masStoreItem.setControlledDrug(request
						.getParameter(CONTROLLED_DRUG));
			} else {
				masStoreItem.setControlledDrug("n");
			}
			if (request.getParameter("phItem") != null) {
				masStoreItem.setPhItem(request
						.getParameter("phItem"));
			} else {
				masStoreItem.setPhItem("n");
			}
			
			if (request.getParameter("insulin") != null) {
				masStoreItem.setInsulinInjection(request.getParameter("insulin"));
			} else {
				masStoreItem.setInsulinInjection("n");
			}
			
			// added by amit das on 21-11-2016
			if (request.getParameter("mixable") != null) {
				masStoreItem.setMixable(request.getParameter("mixable"));
			}
			// added by amit das on 21-11-2016
			if (request.getParameter("mixtureQuantity")!= null && !request.getParameter("mixtureQuantity").trim().equals("")) {
				masStoreItem.setMixtureQuantity(Integer.parseInt(request.getParameter("mixtureQuantity")));
			}
			// added by amit das on 21-11-2016
			if (request.getParameter("mixtureUnit")!= null && !request.getParameter("mixtureUnit").trim().equals("")) {
					masStoreItem.setMixtureUnit(request.getParameter("mixtureUnit"));
			}
			
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				masStoreItem.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
			} else {
				masStoreItem.setHighValueDrug("n");
			}
			if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
				masStoreItem.setRateContractItem(request
						.getParameter(RATE_CONTRACT_ITEM));
			} else {
				masStoreItem.setRateContractItem("n");
			}
			if (request.getParameter("BagQuantity") != null && !request.getParameter("BagQuantity").equals("")) {
				masStoreItem.setBagQuantity(request
						.getParameter("BagQuantity"));
			}
			

			if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}
			String dispensingUnit = "";
			if (request.getParameter("dispensingUnit") != null) {
				dispensingUnit = request.getParameter("dispensingUnit");
			}
			if (request.getParameter("uomQty") != null
					&& !request.getParameter("uomQty").equals("")) {
				uomQty =  new BigDecimal(request
						.getParameter("uomQty"));
			}
			String kmscl_item_code="";
			if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
				kmscl_item_code = request.getParameter("kmscl_item_code");
			}
			String kmsclCategory="";
			if (request.getParameter("kmsclCategory") != null && !request.getParameter("kmsclCategory").equals("")) {
				kmsclCategory = request.getParameter("kmsclCategory");
			}

			if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}

			if (request.getParameter("route") != null
					&& !request.getParameter("route").equals("0")) {
				route = Integer.parseInt(request
						.getParameter("route"));
			}
			
			if (request.getParameter("tapered") != null) {
				masStoreItem.setTapered(request
						.getParameter("tapered"));
			} else {
				masStoreItem.setTapered("n");
			}
			int expiryDays = 0;
			
			if (request.getParameter("expiryDays") != null && !request.getParameter("expiryDays").equals("")) {
				expiryDays =Integer.parseInt(request.getParameter("expiryDays"));
			}

			if (request.getParameter(TEMPERATURE) != null
					&& !request.getParameter(TEMPERATURE).equals("")) {
				tempreture = (request.getParameter(TEMPERATURE));
			}
			if (request.getParameter("minTemperature") != null
					&& !request.getParameter("minTemperature").equals("")) {
				minTempreture =  new BigDecimal(request
						.getParameter("minTemperature"));
			}
			if (request.getParameter("maxTemperature") != null
					&& !request.getParameter("minTemperature").equals("")) {
				maxTempreture =  new BigDecimal(request
						.getParameter("maxTemperature"));
			}
			
		
		
			if (request.getParameter(CHANGED_DATE) != null) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				changedTime = request.getParameter(CHANGED_TIME);
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
			
			
			int userId = 0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));

			generalMap.put("name", name);
			generalMap.put("code", code);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List nomenclatureList = new ArrayList();

			if (listMap.get("duplicateGeneralNameList") != null) {
				nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
				try {
					masStoreItem.setNomenclature(name);
					masStoreItem.setPvmsNo(pvms);
					masStoreItem.setCommonName(commonName);
					

					if (sectionId != 0) {
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(sectionId);
						masStoreItem.setSection(masStoreSection);
					}

					


					if (itemTypeId != 0) {
						 MasItemType masStoreItemType = new MasItemType();
						 masStoreItemType.setId(itemTypeId);
						 masStoreItem.setItemType(masStoreItemType);
					}

					if (itemCategoryId != 0) {
						MasItemCategory masStoreItemCategory = new MasItemCategory();
						masStoreItemCategory.setId(itemCategoryId);
						masStoreItem.setItemCategory(masStoreItemCategory);
					}

					if (itemConversionId != 0) {
						MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
						masStoreItemConversion.setId(itemConversionId);
						masStoreItem.setItemConversion(masStoreItemConversion);
					}

					if (groupId != 0) {
						MasStoreGroup masStoreGroup = new MasStoreGroup();
						masStoreGroup.setId(groupId);
						masStoreItem.setGroup(masStoreGroup);
					}
					
					if (itemClassId != 0) {
						 MasItemClass masItemClass = new MasItemClass();
						 masItemClass.setId(itemClassId);
						 masStoreItem.setItemClass(masItemClass);
					}

					if (route != 0) {
						 RouteOfAdministration routeOfAdministration = new RouteOfAdministration();
						 routeOfAdministration.setId(route);
						 masStoreItem.setRoute(routeOfAdministration);
					}
					masStoreItem.setKmsclItemCode(kmscl_item_code);
					if(kmsclCategory != null){
						masStoreItem.setKmsclCategory(kmsclCategory);
					}
				
				
					if (!tempreture.equals("")) {
						masStoreItem.setTemprature(tempreture);
					}
					if (!standardAvailability.equals("")) {
						masStoreItem.setStandardAvailability(standardAvailability);
					}

		
					
					masStoreItem.setTempratureMax(maxTempreture);
					masStoreItem.setTempratureMin(minTempreture);
					masStoreItem.setADispQty(uomQty);
					
					
					if(expiryDays != 0){
						masStoreItem.setExpiryDays(expiryDays);
					}
				
			
					masStoreItem.setSpecification(specification);
					if(dispensingUnit != null){
					masStoreItem.setDispUnit(dispensingUnit);
					}
					
					
					masStoreItem.setExpiry(expiry);
				
					masStoreItem.setStatus("y");
					Users users = new Users();
					users.setId(userId);
					masStoreItem.setLastChgBy(users);
				
					masStoreItem.setLastChgDate(changedDate);
					masStoreItem.setCreatedOn(changedDate);
					masStoreItem.setLastChgTime(changedTime);
				} catch (Exception e) {
					e.printStackTrace();
				}

				successfullyAdded = pharmacyMasterHandlerService.addItemGlobalMed(masStoreItem,map);
				if (successfullyAdded == true) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if (nomenclatureList.size() != 0) {
				message = "Item Name already exists.";
			}
			try {
				map = pharmacyMasterHandlerService.showItemGlobalMedJsp(deptId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemGlobalMed";
			title = "Add Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editItemGlobalMed(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			MasStoreItem masStoreItem = new MasStoreItem();
			session = request.getSession();
			int itemId = 0;
					
			String pvms = "";
			
			String nomenclature = "";
			int sectionId = 0;
			int itemTypeId = 0;
			int itemCategoryId = 0;
			int itemConversionId = 0;
			int groupId = 0;
			String commonName = "";
			
			String specification = "";
			Date changedDate = null;
			String changedBy = "";
			String changedTime = "";
			String dangerousDrug = "n";
			String controlledDrug = "n";
			String rateContractItem = "n";
			String highValueDrug = "n";
			String otc = "n";
			String insulin="n";
			String phItem="n";
			String expiry = "";
			String tempreture = "";
			// added by amit das on 21-11-2016
			String mixable = null;
			int mixtureQuantity =0;
			String mixtureUnit = null;
			String tapered="";
			int route=0;
			BigDecimal minTempreture  = null;
			BigDecimal maxTempreture  = null;
			BigDecimal uomQty  = null;
		
			int itemClassId=0;
			int deptId = 0;
			//String standardAvailability="";
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			
		/*if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
				
				standardAvailability = request.getParameter("standardAvailability");
			}*/

			
			String standardAvailability = "";
			String[] standardAvailabilityArray = null;
			if (request.getParameterValues("standardAvailability") != null) {
				standardAvailabilityArray = (String[])request.getParameterValues("standardAvailability");
				for (int x = 0; x < standardAvailabilityArray.length; x++) {
					if (x == 0) {
						standardAvailability = standardAvailabilityArray[x];
					} else {
						standardAvailability = standardAvailability + ","	+ standardAvailabilityArray[x];
					}
				}
			}

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				nomenclature = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}
			if (request.getParameter(GROUP_ID) != null  && !request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			
			String kmscl_item_code="";
			if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
				kmscl_item_code = request.getParameter("kmscl_item_code");
			}
			String kmsclCategory ="";
			if (request.getParameter("kmsclCategory") != null && !request.getParameter("kmsclCategory").equals("")) {
				kmsclCategory = request.getParameter("kmsclCategory");
			}
			
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			
			// added by amit das on 21-11-2016
			if (request.getParameter("mixable") != null) {
				mixable = 	request.getParameter("mixable");
			}
			// added by amit das on 21-11-2016
			if (request.getParameter("mixtureQuantity")!= null && !request.getParameter("mixtureQuantity").trim().equals("")) {
				mixtureQuantity = Integer.parseInt(request.getParameter("mixtureQuantity"));
			}
			// added by amit das on 21-11-2016
			if (request.getParameter("mixtureUnit")!= null && !request.getParameter("mixtureUnit").trim().equals("")) {
				mixtureUnit = request.getParameter("mixtureUnit");
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}
			System.out.println("otc==="+request.getParameter("otc"));
			
			if (request.getParameter("otc") != null) {
				otc= request.getParameter("otc");

			} else {
				otc ="n";
			}
			
			if (request.getParameter(DANGEROUS_DRUG) != null) {
				dangerousDrug = request.getParameter(DANGEROUS_DRUG);

			} else {
				dangerousDrug ="n";
			}

			if (request.getParameter(CONTROLLED_DRUG) != null) {
				 controlledDrug = request.getParameter(CONTROLLED_DRUG);
			} else {
				controlledDrug ="n";
			}
			if (request.getParameter("phItem") != null) {
				 phItem = request.getParameter("phItem");
			} else {
				phItem ="n";
			}
			
			if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				highValueDrug =request.getParameter(HIGH_VALUE_DRUG);
			} else {
				highValueDrug ="n";
			}
			if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
				rateContractItem =request.getParameter(RATE_CONTRACT_ITEM);
			} else {
				rateContractItem ="n";
			}
			if (request.getParameter("insulin") != null) {
				insulin =request.getParameter("insulin");
			} else {
				insulin ="n";
			}
			

			if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}
			
			String dispensingUnit = "";
			if (request.getParameter("dispensingUnit") != null) {
				dispensingUnit = request.getParameter("dispensingUnit");
			}

			if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}
			if (request.getParameter("route") != null
					&& !request.getParameter("route").equals("0")) {
				route = Integer.parseInt(request
						.getParameter("route"));
			}
			
			if (request.getParameter("tapered") != null) {
				tapered= request.getParameter("tapered");
				
			} 
			else {
				tapered ="n";
			}
			int expiryDays = 0;

			if (request.getParameter("expiryDays") != null && !request.getParameter("expiryDays").equals("")) {
				expiryDays =Integer.parseInt(request.getParameter("expiryDays"));
			}
			generalMap.put("expiryDays", expiryDays);
			
			if (request.getParameter(TEMPERATURE) != null
					&& !request.getParameter(TEMPERATURE).equals("")) {
				tempreture = (request.getParameter(TEMPERATURE));
			}
			System.out.println("min temp===="+request.getParameter("minTemperature"));
			if (request.getParameter("minTemperature") != null && !request.getParameter("minTemperature").equals("")) {
				minTempreture =  new BigDecimal(request
						.getParameter("minTemperature"));
			}
			if (request.getParameter("uomQty") != null && !request.getParameter("uomQty").equals("")) {
				uomQty =  new BigDecimal(request.getParameter("uomQty"));
			}
			
			if (request.getParameter("maxTemperature") != null
					&& !request.getParameter("maxTemperature").equals("")) {
				maxTempreture =  new BigDecimal(request
						.getParameter("maxTemperature"));
			}

			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			
			int userId = 0;
			int hospitalId=0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			//added by govind 17-11-2016
			String bagQuantity="";
			if (request.getParameter("BagQuantity") != null && !request.getParameter("BagQuantity").equals("")) {
				bagQuantity = request.getParameter("BagQuantity");
			}
			generalMap.put("bagQuantity", bagQuantity);
			//added by govind 17-11-2016 end
			generalMap.put("tempreture", tempreture);
			generalMap.put("itemClassId", itemClassId);
			generalMap.put("id", itemId);
			generalMap.put("name", nomenclature);
			generalMap.put("sectionId", sectionId);
			generalMap.put("commonName", commonName);
			generalMap.put("pvms", pvms);
			generalMap.put("itemTypeId", itemTypeId);
			generalMap.put("itemCategoryId", itemCategoryId);
			generalMap.put("itemConversionId", itemConversionId);
			generalMap.put("minTempreture", minTempreture);
			generalMap.put("uomQty", uomQty);
			generalMap.put("maxTempreture", maxTempreture);
			generalMap.put("controlledDrug", controlledDrug);
			generalMap.put("route", route);
			generalMap.put("tapered", tapered);
			// added by amit das on 21-11-2016
			generalMap.put("mixable", mixable);
			generalMap.put("mixtureQuantity", mixtureQuantity);
			generalMap.put("mixtureUnit", mixtureUnit);
			
			
			
			generalMap.put("phItem", phItem);
			generalMap.put("highValueDrug", highValueDrug);
			generalMap.put("rateContractItem", rateContractItem);
			generalMap.put("dangerousDrug", dangerousDrug);
			generalMap.put("otc", otc);
			generalMap.put("insulin", insulin);
			generalMap.put("specification", specification);
			generalMap.put("dispensingUnit", dispensingUnit);
			generalMap.put("groupId", groupId);
			generalMap.put("expiry", expiry);
			generalMap.put("changedBy", changedBy);
			generalMap.put("changedDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("kmscl_item_code", kmscl_item_code);
			generalMap.put("kmsclCategory", kmsclCategory);
		
			generalMap.put("standardAvailability", standardAvailability);
			boolean dataUpdated = false;
			dataUpdated = pharmacyMasterHandlerService.editItemGlobalMed(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
			try {
				map = pharmacyMasterHandlerService.showItemGlobalMedJsp(deptId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemGlobalMed";
			title = "Edit Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteItemGlobalMed(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			int itemId = 0;
			String message = null;
			int userId = 0;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = pharmacyMasterHandlerService.deleteItemGlobalMed(itemId,
					generalMap);

			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemGlobalMedJsp";
			try {
				map = pharmacyMasterHandlerService.showItemGlobalMedJsp(deptId);

			} catch (Exception e){
				e.printStackTrace();
			}
			jsp = "itemGlobalMed";
			title = "Delete Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		// ---------------------------Item  Master Gobal Non-Med ----------------------------------------------
		public ModelAndView showItemGlobalNonMedJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			map = pharmacyMasterHandlerService.showItemGlobalNonMedJsp(deptId);
			jsp = "itemGlobalNonMed";
			jsp += ".jsp";
			title = "Item";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView searchItemGlobalNonMed(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String pvmsNo = null;
			String nomenclature = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				pvmsNo = request.getParameter(CODE);
				
				
			}
			
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				nomenclature = request.getParameter(SEARCH_NAME);
				
				
			}
			
			int searchRadio = 1;
			try {
				if (request.getParameter(SEARCH_FIELD) != null
						&& !(request.getParameter(SEARCH_FIELD).equals(""))) {
					searchField = request.getParameter(SEARCH_FIELD);
					System.out.println("searchField  "+searchField);
				}
				if (request.getParameter(SELECTED_RADIO) != null
						&& !(request.getParameter(SELECTED_RADIO).equals(""))) {
					searchRadio = Integer.parseInt(request
							.getParameter(SELECTED_RADIO));
					System.out.println("searchRadio  "+searchRadio);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (searchRadio == 1) {
				pvmsNo = searchField;
				nomenclature = null;
				
			} else {
				pvmsNo = null;
				nomenclature = searchField;
			}
			map = pharmacyMasterHandlerService.searchItemGlobalNonMed(pvmsNo, nomenclature);

			jsp = "itemGlobalNonMed";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pvmsNo", pvmsNo);
			map.put("nomenclature", nomenclature);
			return new ModelAndView("index", "map", map);

		}

		@SuppressWarnings("unchecked")
		public ModelAndView addItemGlobalNonMed(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			MasStoreItem masStoreItem = new MasStoreItem();
			String message = null;
			int sectionId = 0;
			int itemTypeId = 0;
			int itemCategoryId = 0;
			int itemConversionId = 0;
			int groupId = 0;
			String pvms = "";
			String commonName = "";
			String specification = "";
			Date changedDate = null;
			String changedTime = "";

		

			String expiry = "";
			
			int itemClassId=0;
			
			//String standardAvailability="";
			
			Map listMap = new HashMap();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			map.put("deptId", deptId);
			
			String kmscl_item_code="";
			if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
				kmscl_item_code = request.getParameter("kmscl_item_code");
			}
			String kmsclCategory ="";
			if (request.getParameter("kmsclCategory") != null && !request.getParameter("kmsclCategory").equals("")) {
				kmsclCategory = request.getParameter("kmsclCategory");
			}
			/*if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
				
				standardAvailability = request.getParameter("standardAvailability");
			}*/
			
			String standardAvailability = "";
			String[] standardAvailabilityArray = null;
			if (request.getParameterValues("standardAvailability") != null) {
				standardAvailabilityArray = (String[])request.getParameterValues("standardAvailability");
				for (int x = 0; x < standardAvailabilityArray.length; x++) {
					if (x == 0) {
						standardAvailability = standardAvailabilityArray[x];
					} else {
						standardAvailability = standardAvailability + ","	+ standardAvailabilityArray[x];
					}
				}
			}
			
			if (!request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}
			

			if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}
			
			

			if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}

		
			if (request.getParameter(CHANGED_DATE) != null) {
				changedDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null) {
				changedTime = request.getParameter(CHANGED_TIME);
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
			
			
			String bagQuantity="";
			if (request.getParameter("BagQuantity") != null && !request.getParameter("BagQuantity").equals("")) {
				bagQuantity = request.getParameter("BagQuantity");
			}

			int userId = 0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));

			generalMap.put("name", name);
			generalMap.put("code", code);
			generalMap.put("currentDate", currentDate);
			generalMap.put("currentTime", currentTime);
			generalMap.put("pojoPropertyName", pojoPropertyName);
			generalMap.put("pojoPropertyCode", pojoPropertyCode);
			generalMap.put("pojoName", pojoName);

			listMap = commonMasterHandlerService
					.checkForExistingMasters(generalMap);
			List nomenclatureList = new ArrayList();

			if (listMap.get("duplicateGeneralNameList") != null) {
				nomenclatureList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((nomenclatureList.size() == 0 || nomenclatureList == null)) {
				try {
					masStoreItem.setNomenclature(name);
					masStoreItem.setPvmsNo(pvms);
					masStoreItem.setCommonName(commonName);
					

					if (sectionId != 0) {
						MasStoreSection masStoreSection = new MasStoreSection();
						masStoreSection.setId(sectionId);
						masStoreItem.setSection(masStoreSection);
					}

					masStoreItem.setKmsclItemCode(kmscl_item_code);
					if(kmsclCategory != null){
						masStoreItem.setKmsclCategory(kmsclCategory);
					}


					if (itemTypeId != 0) {
						 MasItemType masStoreItemType = new MasItemType();
						 masStoreItemType.setId(itemTypeId);
						 masStoreItem.setItemType(masStoreItemType);
					}

					if (itemCategoryId != 0) {
						MasItemCategory masStoreItemCategory = new MasItemCategory();
						masStoreItemCategory.setId(itemCategoryId);
						masStoreItem.setItemCategory(masStoreItemCategory);
					}

					if (itemConversionId != 0) {
						MasStoreItemConversion masStoreItemConversion = new MasStoreItemConversion();
						masStoreItemConversion.setId(itemConversionId);
						masStoreItem.setItemConversion(masStoreItemConversion);
					}

					if (groupId != 0) {
						MasStoreGroup masStoreGroup = new MasStoreGroup();
						masStoreGroup.setId(groupId);
						masStoreItem.setGroup(masStoreGroup);
					}
					
					if (itemClassId != 0) {
						 MasItemClass masItemClass = new MasItemClass();
						 masItemClass.setId(itemClassId);
						 masStoreItem.setItemClass(masItemClass);
					}

					
					if(null !=bagQuantity && !bagQuantity.equals("")){
						masStoreItem.setBagQuantity(bagQuantity);
					}
				
				
					
					if (!standardAvailability.equals("")) {
						masStoreItem.setStandardAvailability(standardAvailability);
					}
				
			
					masStoreItem.setSpecification(specification);
					
					
					masStoreItem.setExpiry(expiry);
				
					masStoreItem.setStatus("y");
					Users users = new Users();
					users.setId(userId);
					masStoreItem.setLastChgBy(users);
				
					masStoreItem.setLastChgDate(changedDate);
					masStoreItem.setCreatedOn(changedDate);
					masStoreItem.setLastChgTime(changedTime);
				} catch (Exception e) {
					e.printStackTrace();
				}

				successfullyAdded = pharmacyMasterHandlerService.addItemGlobalNonMed(masStoreItem,map);
				if (successfullyAdded == true) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if (nomenclatureList.size() != 0) {
				message = "Item Name already exists.";
			}
			try {
				map = pharmacyMasterHandlerService.showItemGlobalNonMedJsp(deptId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemGlobalNonMed";
			title = "Add Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editItemGlobalNonMed(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			session = request.getSession();
			int itemId = 0;
					
			String pvms = "";
			
			String nomenclature = "";
			int sectionId = 0;
			int itemTypeId = 0;
			int itemCategoryId = 0;
			int itemConversionId = 0;
			int groupId = 0;
			String commonName = "";
			
			String specification = "";
			Date changedDate = null;
			String changedBy = "";
			String changedTime = "";

		
			String expiry = "";
					
			int itemClassId=0;
			int deptId = 0;
			//String standardAvailability="";
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			
		/*if (!request.getParameter("standardAvailability").equals(null) && !request.getParameter("standardAvailability").equals("")) {
				
				standardAvailability = request.getParameter("standardAvailability");
			}
*/
			
			String standardAvailability = "";
			String[] standardAvailabilityArray = null;
			if (request.getParameterValues("standardAvailability") != null) {
				standardAvailabilityArray = (String[])request.getParameterValues("standardAvailability");
				for (int x = 0; x < standardAvailabilityArray.length; x++) {
					if (x == 0) {
						standardAvailability = standardAvailabilityArray[x];
					} else {
						standardAvailability = standardAvailability + ","	+ standardAvailabilityArray[x];
					}
				}
			}
			
		String kmscl_item_code="";
		if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
			kmscl_item_code = request.getParameter("kmscl_item_code");
		}
		String kmsclCategory ="";
		if (request.getParameter("kmsclCategory") != null && !request.getParameter("kmsclCategory").equals("")) {
			kmsclCategory = request.getParameter("kmsclCategory");
		}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(SEARCH_NAME) != null) {
				nomenclature = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}
			if (!request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			
			
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}
			
		

			if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}
			


			if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}

		

			
		

			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			
			int userId = 0;
			int hospitalId=0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
	
			generalMap.put("itemClassId", itemClassId);
			generalMap.put("id", itemId);
			generalMap.put("name", nomenclature);
			generalMap.put("sectionId", sectionId);
			generalMap.put("commonName", commonName);
			generalMap.put("pvms", pvms);
			generalMap.put("itemTypeId", itemTypeId);
			generalMap.put("itemCategoryId", itemCategoryId);
			generalMap.put("itemConversionId", itemConversionId);
	
			generalMap.put("specification", specification);
			generalMap.put("groupId", groupId);
			generalMap.put("expiry", expiry);
			generalMap.put("changedBy", changedBy);
			generalMap.put("changedDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("standardAvailability", standardAvailability);
			generalMap.put("kmscl_item_code", kmscl_item_code);
			generalMap.put("kmsclCategory", kmsclCategory);
			boolean dataUpdated = false;
			dataUpdated = pharmacyMasterHandlerService.editItemGlobalNonMed(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
			try {
				map = pharmacyMasterHandlerService.showItemGlobalMedJsp(deptId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemGlobalMed";
			title = "Edit Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteItemGlobalNonMed(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			int itemId = 0;
			String message = null;
			int userId = 0;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = pharmacyMasterHandlerService.deleteItemGlobalNonMed(itemId,
					generalMap);

			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemGlobalNonMedJsp";
			try {
				map = pharmacyMasterHandlerService.showItemGlobalNonMedJsp(deptId);

			} catch (Exception e){
				e.printStackTrace();
			}
			jsp = "itemGlobalNonMed";
			title = "Delete Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView showItemLocalMedJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			map = pharmacyMasterHandlerService.showItemLocalMedJsp(deptId);
			jsp = "itemLocalMed";
			jsp += ".jsp";
			title = "Item";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView editItemLocalMed(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			MasStoreItem masStoreItem = new MasStoreItem();
			session = request.getSession();
			int itemId = 0;
					
			String pvms = "";
			
			String nomenclature = "";
			//int sectionId = 0;
			//int itemGenericId = 0;
			//int itemTypeId = 0;
			//int itemCategoryId = 0;
			//int itemConversionId = 0;
			//int groupId = 0;
			//String commonName = "";
			BigDecimal minStock = new BigDecimal(0);
			BigDecimal maxStock = null;
			String leadTime = "";
			String specification = "";
			Date changedDate = null;
			String changedBy = "";
			String changedTime = "";
			String dangerousDrug = "n";
			String controlledDrug = "n";
			String rateContractItem = "n";
			String highValueDrug = "n";
			int slowMovingDays = 0;
			int fastMovingDays = 0;
			int nonMovingDays = 0;
			//int route=0;
			//String allergy="";
			//String expiry = "";
			//String tempreture = "";
			//BigDecimal minTempreture  = new BigDecimal(0);
			//BigDecimal maxTempreture  = new BigDecimal(0);
			String rol="";
			String ved="";
			String abc="";
			//String tapered="";
			//int itemClassId=0;
			int deptId = 0;
			String standardAvailability="";
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			
	

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
				System.out.println(itemId+"itemIditemId");
			}
			int storeItemDetailsId =0;
			if (request.getParameter("storeItemDetailsId") != null
					&& !(request.getParameter("storeItemDetailsId").equals(""))) {
				storeItemDetailsId = Integer.parseInt(request.getParameter("storeItemDetailsId"));
			}
			
		/*	if (request.getParameter(SEARCH_NAME) != null) {
				nomenclature = request.getParameter(SEARCH_NAME);
			}
			*/
		/*	if ((request.getParameter("standardAvailability") != null)  && !request.getParameter("standardAvailability").equals("")) {
				standardAvailability = request.getParameter("standardAvailability");
			}*/
		/*	if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}*/
			/*if (!request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			
			
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}


			
			if (request.getParameter(DANGEROUS_DRUG) != null) {
				masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));

			} else {
				masStoreItem.setDangerousDrug("n");
			}

			if (request.getParameter(CONTROLLED_DRUG) != null) {
				masStoreItem.setControlledDrug(request
						.getParameter(CONTROLLED_DRUG));
			} else {
				masStoreItem.setControlledDrug("n");
			}
				if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				masStoreItem
						.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
			} else {
				masStoreItem.setHighValueDrug("n");
			}
			if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
				masStoreItem.setRateContractItem(request.getParameter(RATE_CONTRACT_ITEM));
			} else {
				masStoreItem.setRateContractItem("n");
			}*/
			
			String kmscl_item_code="";
			if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
				kmscl_item_code = request.getParameter("kmscl_item_code");
			}
			if (request.getParameter(MAX_STOCK) != null
					&& !(request.getParameter(MAX_STOCK).equals(""))) {
				maxStock =  new BigDecimal(request.getParameter(MAX_STOCK));
			}
			if (request.getParameter(MIN_STOCK) != null
					&& !(request.getParameter(MIN_STOCK).equals(""))) {
				minStock =  new BigDecimal(request.getParameter(MIN_STOCK));
			}
			if (request.getParameter(LEAD_TIME) != null) {
				leadTime = request.getParameter(LEAD_TIME);
			}
	

		/*	if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}*/
			if (!request.getParameter(SLOW_MOVING_DAYS).equals("")) {
				slowMovingDays = Integer.valueOf(request
						.getParameter(SLOW_MOVING_DAYS));
				

			}
			if (!request.getParameter(FAST_MOVING_DAYS).equals("")) {
				fastMovingDays = Integer.parseInt(request
						.getParameter(FAST_MOVING_DAYS));
				
			}
			if (!request.getParameter(NON_MOVING_DAYS).equals("")) {
				nonMovingDays = Integer.parseInt(request
						.getParameter(NON_MOVING_DAYS));
				
			}


			/*if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}*/

			if (request.getParameter(ROL) != null && !request.getParameter(ROL).equals("")) {
				rol = request.getParameter(ROL);
			}
			
		/*	if (request.getParameter(ALLERGY) != null && !request.getParameter(ALLERGY).equals("")) {
				allergy = request.getParameter(ALLERGY);
			}*/
			if (!request.getParameter("ved").equals("")) {
				ved = request.getParameter("ved");
			}
			if (!request.getParameter("abc").equals("")) {
				abc = request.getParameter("abc");
			}

			/*if (request.getParameter(TEMPERATURE) != null
					&& !request.getParameter(TEMPERATURE).equals("")) {
				tempreture = (request.getParameter(TEMPERATURE));
			}
			if (request.getParameter("minTemperature") != null
					&& !request.getParameter("minTemperature").equals("")) {
				minTempreture =  new BigDecimal(request
						.getParameter("minTemperature"));
			}
			if (request.getParameter("maxTemperature") != null
					&& !request.getParameter("maxTemperature").equals("")) {
				maxTempreture =  new BigDecimal(request
						.getParameter("maxTemperature"));
			}
*/
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			
			int userId = 0;
			int hospitalId=0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
		//	generalMap.put("tempreture", tempreture);
			generalMap.put("storeItemDetailsId", storeItemDetailsId);
			
			generalMap.put("id", itemId);
			generalMap.put("name", nomenclature);
		//	generalMap.put("sectionId", sectionId);
		//	generalMap.put("commonName", commonName);
			generalMap.put("pvms", pvms);
		//	generalMap.put("itemGenericId", itemGenericId);
		//	generalMap.put("itemTypeId", itemTypeId);
		//	generalMap.put("itemCategoryId", itemCategoryId);
		//	generalMap.put("itemConversionId", itemConversionId);
		//	generalMap.put("minTempreture", minTempreture);
		//	generalMap.put("maxTempreture", maxTempreture);
			generalMap.put("maxStock", maxStock);
			generalMap.put("minStock", minStock);
			generalMap.put("rol", rol);
			
			generalMap.put("ved", ved);
			generalMap.put("abc", abc);
			generalMap.put("controlledDrug", controlledDrug);
			generalMap.put("highValueDrug", highValueDrug);
			generalMap.put("rateContractItem", rateContractItem);
			generalMap.put("dangerousDrug", dangerousDrug);
			generalMap.put("leadTime", leadTime);
			generalMap.put("specification", specification);
	
		//	generalMap.put("groupId", groupId);
		//	generalMap.put("expiry", expiry);
		//	generalMap.put("allergy", allergy);
			generalMap.put("slowMovingDays", slowMovingDays);
			generalMap.put("fastMovingDays", fastMovingDays);
			generalMap.put("nonMovingDays", nonMovingDays);
			generalMap.put("changedBy", changedBy);
			generalMap.put("changedDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("standardAvailability", standardAvailability);
			generalMap.put("kmscl_item_code", kmscl_item_code);
			boolean dataUpdated = false;
			dataUpdated = pharmacyMasterHandlerService.editItemLocalMed(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
			try {
				map = pharmacyMasterHandlerService.showItemLocalMedJsp(deptId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemLocalMed";
			title = "Edit Item Local Med ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView deleteItemLocalMed(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			int itemId = 0;
			String message = null;
			int userId = 0;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = pharmacyMasterHandlerService.deleteItemLocalMed(itemId,
					generalMap);

			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemLocalMedJsp";
			try {
				map = pharmacyMasterHandlerService.showItemLocalMedJsp(deptId);

			} catch (Exception e){
				e.printStackTrace();
			}
			jsp = "itemLocalMed";
			title = "Delete Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView searchItemLocalMed(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String pvmsNo = null;
			String nomenclature = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				pvmsNo = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				nomenclature = request.getParameter(SEARCH_NAME);
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
				pvmsNo = searchField;
				nomenclature = null;
			} else {
				pvmsNo = null;
				nomenclature = searchField;
			}
			map = pharmacyMasterHandlerService.searchItemLocalMed(pvmsNo, nomenclature);

			jsp = "itemLocalMed";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pvmsNo", pvmsNo);
			map.put("nomenclature", nomenclature);
			return new ModelAndView("index", "map", map);

		}
		public ModelAndView showItemLocalNonMedJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}

			map = pharmacyMasterHandlerService.showItemLocalNonMedJsp(deptId);
			jsp = "itemLocalNonMed";
			jsp += ".jsp";
			title = "Item";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView editItemLocalNonMed(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			MasStoreItem masStoreItem = new MasStoreItem();
			session = request.getSession();
			int itemId = 0;
					
			String pvms = "";
			
			String nomenclature = "";
			//int sectionId = 0;
			//int itemGenericId = 0;
			//int itemTypeId = 0;
			//int itemCategoryId = 0;
			//int itemConversionId = 0;
			//int groupId = 0;
			//String commonName = "";
			BigDecimal minStock = new BigDecimal(0);
			BigDecimal maxStock = null;
			String leadTime = "";
			String specification = "";
			Date changedDate = null;
			String changedBy = "";
			String changedTime = "";
			String dangerousDrug = "n";
			String controlledDrug = "n";
			String rateContractItem = "n";
			String highValueDrug = "n";
			int slowMovingDays = 0;
			int fastMovingDays = 0;
			int nonMovingDays = 0;

			//String allergy="";
			//String expiry = "";
			//String tempreture = "";
			//BigDecimal minTempreture  = new BigDecimal(0);
			//BigDecimal maxTempreture  = new BigDecimal(0);
			String rol="";
			String ved="";
			String abc="";
			//int itemClassId=0;
			int deptId = 0;
			String standardAvailability="";
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			
	

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			int storeItemDetailsId =0;
			if (request.getParameter("storeItemDetailsId") != null
					&& !(request.getParameter("storeItemDetailsId").equals(""))) {
				storeItemDetailsId = Integer.parseInt(request.getParameter("storeItemDetailsId"));
			}
			/*if (request.getParameter(SEARCH_NAME) != null) {
				nomenclature = request.getParameter(SEARCH_NAME);
			}
			*/
		/*	if ((request.getParameter("standardAvailability") != null)  && !request.getParameter("standardAvailability").equals("")) {
				standardAvailability = request.getParameter("standardAvailability");
			}*/
			/*if (request.getParameter(CODE) != null) {
				pvms = request.getParameter(CODE);
			}*/
			/*if (!request.getParameter(GROUP_ID).equals("0")) {
				
				groupId = Integer.parseInt(request.getParameter(GROUP_ID));
			}
			if (!request.getParameter(ITEM_TYPE_ID).equals("0")) {
				
				itemTypeId = Integer.parseInt(request.getParameter(ITEM_TYPE_ID));
				
			}
			if (!request.getParameter(SECTION_ID).equals("0")) {
				sectionId = Integer.parseInt(request.getParameter(SECTION_ID));
			}
			
			
			if (request.getParameter("commonName") != null) {
				commonName = request.getParameter("commonName");
			}
			if (!request.getParameter(STORE_ITEM_CONVERSION_ID).equals("0")) {
				
				itemConversionId = Integer.parseInt(request
						.getParameter(STORE_ITEM_CONVERSION_ID));
			}
			
			if (!request.getParameter(ITEM_CLASS_ID).equals("0")) {
				
				itemClassId = Integer.parseInt(request.getParameter(ITEM_CLASS_ID));
			}
			if (!request.getParameter(ITEM_CATEGORY_ID).equals("0")) {
				
				itemCategoryId = Integer.parseInt(request
						.getParameter(ITEM_CATEGORY_ID));
			}


			
			if (request.getParameter(DANGEROUS_DRUG) != null) {
				masStoreItem.setDangerousDrug(request.getParameter(DANGEROUS_DRUG));

			} else {
				masStoreItem.setDangerousDrug("n");
			}

			if (request.getParameter(CONTROLLED_DRUG) != null) {
				masStoreItem.setControlledDrug(request
						.getParameter(CONTROLLED_DRUG));
			} else {
				masStoreItem.setControlledDrug("n");
			}
				if (request.getParameter(HIGH_VALUE_DRUG) != null) {
				masStoreItem
						.setHighValueDrug(request.getParameter(HIGH_VALUE_DRUG));
			} else {
				masStoreItem.setHighValueDrug("n");
			}
			if (request.getParameter(RATE_CONTRACT_ITEM) != null) {
				masStoreItem.setRateContractItem(request.getParameter(RATE_CONTRACT_ITEM));
			} else {
				masStoreItem.setRateContractItem("n");
			}*/
			
			String kmscl_item_code="";
			if (request.getParameter("kmscl_item_code") != null && !request.getParameter("kmscl_item_code").equals("")) {
				kmscl_item_code = request.getParameter("kmscl_item_code");
			}
			if (request.getParameter(MAX_STOCK) != null
					&& !(request.getParameter(MAX_STOCK).equals(""))) {
				maxStock =  new BigDecimal(request.getParameter(MAX_STOCK));
			}
			if (request.getParameter(MIN_STOCK) != null
					&& !(request.getParameter(MIN_STOCK).equals(""))) {
				minStock =  new BigDecimal(request.getParameter(MIN_STOCK));
			}
			if (request.getParameter(LEAD_TIME) != null) {
				leadTime = request.getParameter(LEAD_TIME);
			}

		/*	if (request.getParameter(SPECIFICATION) != null) {
				specification = request.getParameter(SPECIFICATION);
			}*/
			if (!request.getParameter(SLOW_MOVING_DAYS).equals("")) {
				slowMovingDays = Integer.valueOf(request
						.getParameter(SLOW_MOVING_DAYS));
				

			}
			if (!request.getParameter(FAST_MOVING_DAYS).equals("")) {
				fastMovingDays = Integer.parseInt(request
						.getParameter(FAST_MOVING_DAYS));
				
			}
			if (!request.getParameter(NON_MOVING_DAYS).equals("")) {
				nonMovingDays = Integer.parseInt(request
						.getParameter(NON_MOVING_DAYS));
				
			}


			/*if (request.getParameter(EXPIRY) != null && !request.getParameter(EXPIRY).equals("")) {
				expiry = request.getParameter(EXPIRY);
			}*/

			if (request.getParameter(ROL) != null && !request.getParameter(ROL).equals("")) {
				rol = request.getParameter(ROL);
			}
			
		/*	if (request.getParameter(ALLERGY) != null && !request.getParameter(ALLERGY).equals("")) {
				allergy = request.getParameter(ALLERGY);
			}*/
			if (!request.getParameter("ved").equals("")) {
				ved = request.getParameter("ved");
			}
			if (!request.getParameter("abc").equals("")) {
				abc = request.getParameter("abc");
			}

			/*if (request.getParameter(TEMPERATURE) != null
					&& !request.getParameter(TEMPERATURE).equals("")) {
				tempreture = (request.getParameter(TEMPERATURE));
			}
			if (request.getParameter("minTemperature") != null
					&& !request.getParameter("minTemperature").equals("")) {
				minTempreture =  new BigDecimal(request
						.getParameter("minTemperature"));
			}
			if (request.getParameter("maxTemperature") != null
					&& !request.getParameter("maxTemperature").equals("")) {
				maxTempreture =  new BigDecimal(request
						.getParameter("maxTemperature"));
			}
*/
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
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
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");
			
			int userId = 0;
			int hospitalId=0;
			session = request.getSession();
			if (session.getAttribute("userId") != null)
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
		//	generalMap.put("tempreture", tempreture);
	//		generalMap.put("itemClassId", itemClassId);
			generalMap.put("id", itemId);
			generalMap.put("storeItemDetailsId", storeItemDetailsId);
			generalMap.put("name", nomenclature);
		//	generalMap.put("sectionId", sectionId);
		//	generalMap.put("commonName", commonName);
			generalMap.put("pvms", pvms);
		//	generalMap.put("itemGenericId", itemGenericId);
		//	generalMap.put("itemTypeId", itemTypeId);
		//	generalMap.put("itemCategoryId", itemCategoryId);
		//	generalMap.put("itemConversionId", itemConversionId);
		//	generalMap.put("minTempreture", minTempreture);
		//	generalMap.put("maxTempreture", maxTempreture);
			generalMap.put("maxStock", maxStock);
			generalMap.put("minStock", minStock);
			generalMap.put("rol", rol);
			generalMap.put("ved", ved);
			generalMap.put("abc", abc);
			generalMap.put("controlledDrug", controlledDrug);
			generalMap.put("highValueDrug", highValueDrug);
			generalMap.put("rateContractItem", rateContractItem);
			generalMap.put("dangerousDrug", dangerousDrug);
			generalMap.put("leadTime", leadTime);
			generalMap.put("specification", specification);
		//	generalMap.put("groupId", groupId);
		//	generalMap.put("expiry", expiry);
		//	generalMap.put("allergy", allergy);
			generalMap.put("slowMovingDays", slowMovingDays);
			generalMap.put("fastMovingDays", fastMovingDays);
			generalMap.put("nonMovingDays", nonMovingDays);
			generalMap.put("changedBy", changedBy);
			generalMap.put("changedDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("userId", userId);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("standardAvailability", standardAvailability);
			generalMap.put("kmscl_item_code", kmscl_item_code);
			boolean dataUpdated = false;
			dataUpdated = pharmacyMasterHandlerService.editItemLocalMed(generalMap);
			if (dataUpdated == true) {
				message = "Record Updated Successfully !!";
			} else {
				message = "Record Cant be updated !!";
			}
			try {
				map = pharmacyMasterHandlerService.showItemLocalNonMedJsp(deptId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "itemLocalNonMed";
			title = "Edit Item Local Med ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView deleteItemLocalNonMed(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			int itemId = 0;
			String message = null;
			int userId = 0;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			session = request.getSession();
			int deptId = 0;

			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				itemId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = pharmacyMasterHandlerService.deleteItemLocalNonMed(itemId,
					generalMap);

			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showItemLocalNonMedJsp";
			try {
				map = pharmacyMasterHandlerService.showItemLocalNonMedJsp(deptId);

			} catch (Exception e){
				e.printStackTrace();
			}
			jsp = "itemLocalNonMed";
			title = "Delete Item ";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView searchItemLocalNonMed(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String pvmsNo = null;
			String nomenclature = null;
			String searchField = null;

			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				pvmsNo = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				nomenclature = request.getParameter(SEARCH_NAME);
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
				pvmsNo = searchField;
				nomenclature = null;
			} else {
				pvmsNo = null;
				nomenclature = searchField;
			}
			map = pharmacyMasterHandlerService.searchItemLocalNonMed(pvmsNo, nomenclature);

			jsp = "itemLocalNonMed";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("pvmsNo", pvmsNo);
			map.put("nomenclature", nomenclature);
			return new ModelAndView("index", "map", map);

		}
		
		public ModelAndView showHospitalWiseItemDetails(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hospitalId= 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId =  Integer.parseInt("" + session.getAttribute("hospitalId"));
			}
			
			Box box = HMSUtil.getBox(request);
			box.put("hospitalId", hospitalId);
			
			map = pharmacyMasterHandlerService.showHospitalWiseItemDetails(box);
			map.put("flag", box.getString("flag"));
			return new ModelAndView("responseForItemDetails", "map", map);
		}
		
		@SuppressWarnings("unchecked")
		public ModelAndView showEmpaneledJsp(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			map = (Map) pharmacyMasterHandlerService.showEmpaneled();
			String jsp = "empaneled";
			jsp += ".jsp";
			title = "empaneled";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addEmpaneled(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			MasEmpaneled masEmpaneled = new MasEmpaneled();
			HttpSession session = request.getSession();
			int userId = (Integer) session.getAttribute("userId");
	String contactPerson = "";
	Map<String, Object> objectMap = new HashMap<String, Object>();
			int cityId1 = 0;
			int stateId1 = 0;
			String mobileNo1 = "";
			String emailId1 = "";
			String cpMobileNo = "";
			String licenceNo1 = "";

			String address = "";
		
			int pinCode1 = 0;
			
			int tinNo1 = 0;
		String loginName="";
		String password="";
			Map<String, Object> listMap = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Date currentDate = new Date();
			int departmentId=0;
			try {
				

				if (request.getParameter("hospitalId") != null && !request.getParameter("hospitalId").equals("0")) {
					String[] hospitalList= request.getParameterValues("hospitalId");
					objectMap.put("hospitalList", hospitalList);
					
					
				}

				if (request.getParameter(LOGIN_NAME) != null) {
					loginName = request.getParameter(LOGIN_NAME);
				}
				
				if (request.getParameter(RequestConstants.PASSWORD) != null) {
					password = request.getParameter(RequestConstants.PASSWORD);
				}
				if (request.getParameter(CODE) != null) {
					code = request.getParameter(CODE);
				}

				if (request.getParameter(SEARCH_NAME) != null) {
					name = request.getParameter(SEARCH_NAME);
				}
				if (request.getParameter(CONTACT_PERSON) != null) {
					contactPerson = request.getParameter(CONTACT_PERSON);
				}
				if (request.getParameter(ADDRESS) != null) {
					address = request.getParameter(ADDRESS);
				}
				if (!request.getParameter(STATE_ID1).equals("0")) {
					stateId1 = Integer.parseInt(request.getParameter(STATE_ID1));
				}
				if (!request.getParameter(DISTRICT_ID1).equals("0")) {
					cityId1 = Integer.parseInt(request.getParameter(DISTRICT_ID1));
				}
				if (!request.getParameter(PINCODE1).equals("0")
						&& !request.getParameter(PINCODE1).equals("")) {
					pinCode1 = Integer.parseInt(request.getParameter(PINCODE1));
				}
				if (request.getParameter(MOBILE_NO1) != null && !request.getParameter(MOBILE_NO1).equals("")) {
					mobileNo1 = request.getParameter(MOBILE_NO1);
				}
				
				if (request.getParameter(TIN_NO1) != null && !request.getParameter(TIN_NO1).equals("")) {
					tinNo1 =Integer.parseInt(request.getParameter(TIN_NO1));
				}
				if (request.getParameter(LICENCE_NO1) != null && !request.getParameter(LICENCE_NO1).equals("")) {
					licenceNo1 = request.getParameter(LICENCE_NO1);
				}
				if (request.getParameter(EMAIL_ID1) != null) {
					emailId1 = request.getParameter(EMAIL_ID1);
				}

				if (request.getParameter("cpMobileNo") != null) {
					cpMobileNo = request.getParameter("cpMobileNo");
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
				
				if (request.getParameter("departmentId") != null) {
					departmentId= Integer.parseInt(request.getParameter("departmentId").toString());
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
			List empaneledCodeList = new ArrayList();
			List empaneledNameList = new ArrayList();
			if (listMap.get("duplicateGeneralCodeList") != null) {
				empaneledCodeList = (List) listMap.get("duplicateGeneralCodeList");
			}
			if (listMap.get("duplicateGeneralNameList") != null) {
				empaneledNameList = (List) listMap.get("duplicateGeneralNameList");
			}
			boolean successfullyAdded = false;

			if ((empaneledCodeList.size() == 0 || empaneledCodeList == null)
					&& (empaneledNameList.size() == 0 || empaneledNameList == null)) {
				masEmpaneled.setEmpaneledCode(code);
				masEmpaneled.setEmpaneledName(name);

				
				masEmpaneled.setLoginName(loginName);
				masEmpaneled.setPassword(HMSUtil.encryptPassword(password));
				Users users = new Users();
				users.setId(userId);
				masEmpaneled.setLastChgBy(users);
				masEmpaneled.setContactPerson(contactPerson);
				masEmpaneled.setAddress(address);
				if (cityId1 != 0) {
					MasDistrict masDistrict = new MasDistrict();
					masDistrict.setId(cityId1);
					masEmpaneled.setCity(masDistrict);
				}
				if (stateId1 != 0) {
					MasState masState = new MasState();
					masState.setId(stateId1);
					masEmpaneled.setState(masState);
				}
				masEmpaneled.setPinCode(pinCode1);
				masEmpaneled.setLicenceNo(licenceNo1);
				masEmpaneled.setMobileno(mobileNo1);
				masEmpaneled.setEmailId(emailId1);
				masEmpaneled.setTinNo(tinNo1);
				masEmpaneled.setCpMobileNo(cpMobileNo);
				if(departmentId!=0){
					MasDepartment department=new MasDepartment(departmentId);
					masEmpaneled.setDepartment(department);
				}
				masEmpaneled.setStatus("Y");
				masEmpaneled.setLastChgDate(currentDate);
				masEmpaneled.setLastChgTime(currentTime);
				successfullyAdded = pharmacyMasterHandlerService.addEmpaneled(masEmpaneled,objectMap);

				if (successfullyAdded) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}

			} else if ((empaneledCodeList.size() != 0 || empaneledCodeList != null)
					|| (empaneledNameList.size() != 0) || empaneledNameList != null) {
				if ((empaneledCodeList.size() != 0 || empaneledCodeList != null)
						&& (empaneledNameList.size() == 0 || empaneledNameList == null)) {
					message = "Empaneled Code already exists.";
				} else if ((empaneledNameList.size() != 0 || empaneledNameList != null)
						&& (empaneledCodeList.size() == 0 || empaneledCodeList == null)) {
					message = "Empaneled Name already exists.";
				} else if ((empaneledCodeList.size() != 0 || empaneledCodeList != null)
						&& (empaneledCodeList.size() != 0 || empaneledNameList != null)) {
					message = "Empaneled Code and Name exist.";
				}
			}
			try {
				map = pharmacyMasterHandlerService.showEmpaneled();

			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "empaneled";
			title = "Add empaneled";
			jsp += ".jsp";

			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView editEmpaneled(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			HttpSession session = request.getSession();
			String empaneledCode = "";
			String empaneledName = "";
			int empaneledId = 0;
			Date changedDate = null;
			String changedTime = "";
			Integer userId = (Integer) session.getAttribute("userId");
			int hospitalId = 0;
			String contactPerson = "";
			
			int cityId1 = 0;
			int stateId1 = 0;
			String mobileNo1 = "";
			String emailId1 = "";
			String cpMobileNo = "";
			String licenceNo1 = "";
			String loginName="";
			String password="";
			String address = "";
		
			int pinCode1 = 0;
			
			int tinNo1 = 0;
			try {
			
				if (request.getParameter(HOSPITAL_ID) != null
						&& !(request.getParameter(HOSPITAL_ID).equals("0"))) {
					hospitalId = Integer
							.parseInt(request.getParameter(HOSPITAL_ID));
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					empaneledId = Integer.parseInt(request.getParameter(COMMON_ID));
				}

				if (request.getParameter(LOGIN_NAME) != null) {
					loginName = request.getParameter(LOGIN_NAME);
				}
				
				if (request.getParameter(RequestConstants.PASSWORD) != null) {
					password = request.getParameter(RequestConstants.PASSWORD);
				}
				if (request.getParameter(CODE) != null
						&& !(request.getParameter(CODE).equals(""))) {
					empaneledCode = request.getParameter(CODE);
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					empaneledName = request.getParameter(SEARCH_NAME);
				}
				if (request.getParameter(CONTACT_PERSON) != null) {
					contactPerson = request.getParameter(CONTACT_PERSON);
				}
				if (request.getParameter(ADDRESS) != null) {
					address = request.getParameter(ADDRESS);
				}
				if (!request.getParameter(STATE_ID1).equals("0")) {
					stateId1 = Integer.parseInt(request.getParameter(STATE_ID1));
				}
				if (!request.getParameter(DISTRICT_ID1).equals("0")) {
					cityId1 = Integer.parseInt(request.getParameter(DISTRICT_ID1));
				}
				if (!request.getParameter(PINCODE1).equals("0")
						&& !request.getParameter(PINCODE1).equals("")) {
					pinCode1 = Integer.parseInt(request.getParameter(PINCODE1));
				}
				if (request.getParameter(MOBILE_NO1) != null && !request.getParameter(MOBILE_NO1).equals("")) {
					mobileNo1 = request.getParameter(MOBILE_NO1);
				}
				
				if (request.getParameter(TIN_NO1) != null && !request.getParameter(TIN_NO1).equals("")) {
					tinNo1 =Integer.parseInt(request.getParameter(TIN_NO1));
				}
				if (request.getParameter(LICENCE_NO1) != null && !request.getParameter(LICENCE_NO1).equals("")) {
					licenceNo1 = request.getParameter(LICENCE_NO1);
				}
				if (request.getParameter(EMAIL_ID1) != null) {
					emailId1 = request.getParameter(EMAIL_ID1);
				}
				
				if (request.getParameter("departmentId") != null) {
					generalMap.put("departmentId", request.getParameter("departmentId")); 
				}

				if (request.getParameter("cpMobileNo") != null) {
					cpMobileNo = request.getParameter("cpMobileNo");
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

				if (request.getParameter("hospitalId") != null && !request.getParameter("hospitalId").equals("0")) {
					String[] hospitalList= request.getParameterValues("hospitalId");
					generalMap.put("hospitalList", hospitalList);
					
					
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			changedDate = new Date();
			try {
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				generalMap.put("id", empaneledId);
				generalMap.put("empaneledCode", empaneledCode);
				generalMap.put("name", empaneledName);
				generalMap.put("hospitalId", hospitalId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("contactPerson", contactPerson);
				generalMap.put("address", address);
				generalMap.put("cityId1", cityId1);
				generalMap.put("stateId1", stateId1);
				generalMap.put("pinCode1", pinCode1);
				generalMap.put("licenceNo1", licenceNo1);
				generalMap.put("tinNo1", tinNo1);
				generalMap.put("mobileNo1", mobileNo1);
				generalMap.put("emailId1", emailId1);
				generalMap.put("cpMobileNo", cpMobileNo);
				generalMap.put("loginName", loginName);
				generalMap.put("password", password);
				
				generalMap.put("userId", userId);
				Map<String, Object> listMap = new HashMap<String, Object>();

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);
				generalMap.put("flag", true);

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingEmpaneledNameList = (List) listMap
						.get("duplicateMastersList");
				boolean dataUpdated = false;

				if (existingEmpaneledNameList.size() == 0) {
					dataUpdated = pharmacyMasterHandlerService
							.editEmpaneled(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant Be Updated !!";
					}
				} else if (existingEmpaneledNameList.size() > 0) {
					message = "Name already exists.";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				map = pharmacyMasterHandlerService.showEmpaneled();

			} catch (Exception e) {
				e.printStackTrace();
			}
			

			String jsp = "empaneled";
			title = " Edit empaneled";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView searchEmpaneled(HttpServletRequest request,
				HttpServletResponse response) throws ServletRequestBindingException {
			Map<String, Object> map = new HashMap<String, Object>();
			String searchField = null;
			String empaneledCode = null;
			String empaneledName = null;
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
				empaneledCode = searchField;
				empaneledName = null;

			} else {
				empaneledCode = null;
				empaneledName = searchField;
			}

System.out.println(empaneledName);
System.out.println(empaneledCode);
			map = pharmacyMasterHandlerService.searchEmpaneled(empaneledCode,
					empaneledName);

			jsp = "empaneled";

			jsp += ".jsp";
			map.put("search", "search");
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("empaneledCode", empaneledCode);
			map.put("empaneledName", empaneledName);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView deleteEmpaneled(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int empaneledId = 0;
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
				empaneledId = Integer.parseInt(request.getParameter(COMMON_ID));
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
			dataDeleted = pharmacyMasterHandlerService.deleteEmpaneled(empaneledId,
					generalMap);
			if (dataDeleted == true) {
				message = "Record is InActivated successfully !!";
			}

			else {
				message = "Record is Activated successfully !!";
			}
			url = "/hms/hms/pharmacy?method=showEmpaneledJsp";
			try {
				map = pharmacyMasterHandlerService.showEmpaneled();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "empaneled";
			title = "delete Empaneled";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("url", url);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		/*Added By Om Tripathi 19/08/2017 Starts*/
		public ModelAndView addOutsideMedicines(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			session = request.getSession();
			int deptId = 0;
			int hospitalId = 0;
			int userId = 0;
			Map maps=new HashMap();
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
				maps.put("deptId", deptId);
			}
			if(session.getAttribute("hospitalId")!=null){
				hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
				maps.put("hospitalId", hospitalId);
			}
			if(session.getAttribute("userId")!=null){
				userId = Integer.parseInt(session.getAttribute("userId").toString());
				maps.put("userId", userId);
			}
			String nomenclature=request.getParameter("nomenclatur");
			maps.put("nomenclature", nomenclature);
			map = pharmacyMasterHandlerService.addOutsideMedicineJsp(maps);
			
			url = "hms/hms/opd?method=getOPClinicalWaitingList";
			map.put("url", url);
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		/*Added By Om Tripathi 19/08/2017 End*/

	// --------------------------------------------------------------------

	public PharmacyMasterHandlerService getPharmacyMasterHandlerService() {
		return pharmacyMasterHandlerService;
	}

	public void setPharmacyMasterHandlerService(
			PharmacyMasterHandlerService pharmacyMasterHandlerService) {
		this.pharmacyMasterHandlerService = pharmacyMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
}
