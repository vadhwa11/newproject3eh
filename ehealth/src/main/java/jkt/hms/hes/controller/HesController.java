package jkt.hms.hes.controller;

import static jkt.hms.util.RequestConstants.BUGD_MAJOR_HEAD_JSP;
import static jkt.hms.util.RequestConstants.BUGD_MINOR_SUB_HEAD_JSP;
import static jkt.hms.util.RequestConstants.CHANGED_BY;
import static jkt.hms.util.RequestConstants.CHANGED_DATE;
import static jkt.hms.util.RequestConstants.CHANGED_TIME;
import static jkt.hms.util.RequestConstants.CODE;
import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.FINANCIAL_YEAR;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.GROUP_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SEQUENCE_NO;
import static jkt.hms.util.RequestConstants.STORE_PHYSICAL_STOCK_JSP;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.hes.handler.HesHandlerService;
import jkt.hms.masters.business.BudMajorHead;
import jkt.hms.masters.business.CommunicationMessages;
import jkt.hms.masters.business.HesCylinderTypeMaster;
import jkt.hms.masters.business.HesCylinderUsageMaster;
import jkt.hms.masters.business.HesEmergencyEquipmentBreakdown;
import jkt.hms.masters.business.HesEquipmentAmcDetailsEntry;
import jkt.hms.masters.business.HesEquipmentAssessories;
import jkt.hms.masters.business.HesEquipmentBreakdownEntry;
import jkt.hms.masters.business.HesEquipmentCallLogEntry;
import jkt.hms.masters.business.HesEquipmentEmergencyMaintenanceBreakdown;
import jkt.hms.masters.business.HesEquipmentMaintenance;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.HesMaintenanceJobMaster;
import jkt.hms.masters.business.HesWorkParticularMaster;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasStoreSupplier;
import jkt.hms.masters.business.MasStoreSupplierGroup;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class HesController extends MultiActionController
{
	HesHandlerService hesHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
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
	String changedBy = "";
	int id = 0;
	String userName = null;
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = null;
	
	public HesHandlerService getHesHandlerService() {
		return hesHandlerService;
	}
	public void setHesHandlerService(HesHandlerService hesHandlerService) {
		this.hesHandlerService = hesHandlerService;
	}
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}
	
	// Methods for Cylinder Usage Master ------- START
	public ModelAndView showCylinderUsageMasterJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession(true);
		map = hesHandlerService.showCylinderUsageMasterJsp();
		jsp = "hesCylinderUsageMaster";
		jsp += ".jsp";
		title = "Cylinder Usage Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addCylinderUsage(HttpServletRequest request,
			HttpServletResponse response)
	{	
		Date currentDate = new Date();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		List cylinderUsageCodeList = new ArrayList();
		List cylinderUsageNameList = new ArrayList();
		boolean successfullyAdded = false;
		int userId=0;
		session=request.getSession();
		HesCylinderUsageMaster master = new HesCylinderUsageMaster();
		
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
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
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
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
				
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		
		if (listMap.get("duplicateGeneralCodeList") != null) {
			cylinderUsageCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			cylinderUsageNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((cylinderUsageCodeList.size() == 0 || cylinderUsageCodeList == null)
				&& (cylinderUsageNameList.size() == 0 || cylinderUsageNameList == null))

		{
			Users users =new Users();
			users.setId(userId);
			master.setLastChgBy(users);
			master.setLastChgDate(currentDate);
			master.setLastChgTime(currentTime);
			master.setStatus("y");
			master.setCylinderUsageCode(code);
			master.setCylinderUsageName(name);
			
			successfullyAdded = hesHandlerService.addCylinderUsage(master);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
		
			}
		}
		else if ((cylinderUsageCodeList.size() != 0 || cylinderUsageCodeList != null)
				|| (cylinderUsageNameList.size() != 0) || cylinderUsageNameList != null) 
		{

			if ((cylinderUsageCodeList.size() != 0 || cylinderUsageCodeList != null)
					&& (cylinderUsageNameList.size() == 0 || cylinderUsageNameList == null)) {

				message = " Usage Code  already exists.";
			} else if ((cylinderUsageNameList.size() != 0 || cylinderUsageNameList != null)
					&& (cylinderUsageCodeList.size() == 0 || cylinderUsageCodeList == null)) {

				message = " Usage Name  already exists.";
			} else if ((cylinderUsageCodeList.size() != 0 || cylinderUsageCodeList != null)
					&& (cylinderUsageNameList.size() != 0 || cylinderUsageNameList != null)) {

				message = " Usage Code and Usage Name already exist.";
			}
		}
		
		url = "/hms/hms/cssd?method=showCylinderUsageMasterJsp";

		try {
			map = hesHandlerService.showCylinderUsageMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "hesCylinderUsageMaster";
		title = "Add Cylinder Usage Data";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editCylinderUsage(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String cylinderCode = "";
		String cylinderName = "";
		int cylinderId = 0;
		String changedBy = "";
		boolean dataUpdated = false;
		int userId=0;
		session=request.getSession();
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			cylinderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			cylinderCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			cylinderName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		generalMap.put("id", cylinderId);
		generalMap.put("code", cylinderCode);
		generalMap.put("name", cylinderName);
		generalMap.put("userId", userId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");
		
		if (existingWorkNameList.size() == 0) 
		{
			dataUpdated = hesHandlerService.editCylinderUsage(generalMap);

			if (dataUpdated == true)
			{
				message = "Data updated Successfully !!";
			}
			else
			{
				message = "Try Again !!";
			}
		}
		else if (existingWorkNameList.size() > 0)
		{
			message = "Name already exists.";
		}

		url = "/hms/hms/cssd?method=showCylinderUsageMasterJsp";

		try
		{
			map = hesHandlerService.showCylinderUsageMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesCylinderUsageMaster";
		title = "Edit Cylinder Usage Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteCylinderUsage(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int cylinderId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		int userId=0;
		boolean dataDeleted = false;
		String flag = "";
		session=request.getSession();
		
		if (request.getParameter(COMMON_ID) != null	&& !(request.getParameter(COMMON_ID).equals("")))
		{
			cylinderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null && !(request.getParameter("flag").equals("")))
		{
			flag = request.getParameter("flag");
		}
		/*if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals("")))
		{
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("flag", flag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		
		dataDeleted = hesHandlerService.deleteCylinderUsage(cylinderId,generalMap);
		
		if (dataDeleted == true)
		{
			message = "Record is InActivated successfully !!";
		}
		else
		{
			message = "Record is Activated successfully !!";
		}
		
		try
		{
			map = hesHandlerService.showCylinderUsageMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesCylinderUsageMaster";
		title = "Delete Cylinder Usage Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchCylinderUsage(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String CylinderUsageCode = null;
		String CylinderUsageName = null;
		String searchField = null;
		int searchRadio = 1;
		
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals("")))
		{
			CylinderUsageCode = request.getParameter(CODE);
		}
		
		if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals("")))
		{
			CylinderUsageName = request.getParameter(SEARCH_NAME);
		}

		try
		{
			if (request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals("")))
			{
				searchField = request.getParameter(SEARCH_FIELD);
			}
			
			if (request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals("")))
			{
				searchRadio = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (searchRadio == 1)
		{
			CylinderUsageCode = searchField;
			CylinderUsageName = null;
		}
		else
		{
			CylinderUsageCode = null;
			CylinderUsageName = searchField;
		}
		
		map = hesHandlerService.searchCylinderUsage(CylinderUsageCode,CylinderUsageName);
		
		jsp = "hesCylinderUsageMaster";
		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCode", CylinderUsageCode);
		map.put("workName", CylinderUsageName);
		return new ModelAndView("index", "map", map);
	}
		
	// Methods for Cylinder Usage Master ------- END
	
	// Methods for Maintenance Job Master ------- START
	public ModelAndView showMaintenanceJobMasterJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession(true);
		map = hesHandlerService.showMaintenanceJobMasterJsp();
		jsp = "hesMaintenanceJobMaster";
		jsp += ".jsp";
		title = "Maintenance Job Type Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addMaintenanceType(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Date currentDate = new Date();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		List maintenanceCodeList = new ArrayList();
		List maintenanceNameList = new ArrayList();
		boolean successfullyAdded = false;
		HesMaintenanceJobMaster master = new HesMaintenanceJobMaster();
		session=request.getSession();
		int userId=0;
		
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
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
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
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
		
				
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		
		if (listMap.get("duplicateGeneralCodeList") != null) {
			maintenanceCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			maintenanceNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((maintenanceCodeList.size() == 0 || maintenanceCodeList == null)
				&& (maintenanceNameList.size() == 0 || maintenanceNameList == null))

		{
			Users users=new Users();
			users.setId(userId);
			master.setLastChgBy(users);
			master.setLastChgDate(currentDate);
			master.setLastChgTime(currentTime);
			master.setStatus("y");
			master.setMaintenanceCode(code);
			master.setMaintenanceName(name);
			
			successfullyAdded = hesHandlerService.addMaintenanceType(master);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
		
			}
		}
		else if ((maintenanceCodeList.size() != 0 || maintenanceCodeList != null)
				|| (maintenanceNameList.size() != 0) || maintenanceNameList != null) 
		{

			if ((maintenanceCodeList.size() != 0 || maintenanceCodeList != null)
					&& (maintenanceNameList.size() == 0 || maintenanceNameList == null)) {

				message = " Usage Code  already exists.";
			} else if ((maintenanceNameList.size() != 0 || maintenanceNameList != null)
					&& (maintenanceCodeList.size() == 0 || maintenanceCodeList == null)) {

				message = " Usage Name  already exists.";
			} else if ((maintenanceCodeList.size() != 0 || maintenanceCodeList != null)
					&& (maintenanceNameList.size() != 0 || maintenanceNameList != null)) {

				message = " Usage Code and Usage Name already exist.";
			}
		}
		
		url = "/hms/hms/cssd?method=showMaintenanceJobMasterJsp";

		try {
			map = hesHandlerService.showMaintenanceJobMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "hesMaintenanceJobMaster";
		title = "Maintenance Job Type Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editMaintenanceType(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String machCode = "";
		String machName = "";
		int machId = 0;
		String changedBy = "";
		int userId=0;
		session=request.getSession();
		boolean dataUpdated = false;
		
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			machId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			machCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			machName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		generalMap.put("id", machId);
		generalMap.put("code", machCode);
		generalMap.put("name", machName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("userId", userId);
		
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");
		
		if (existingWorkNameList.size() == 0) 
		{
			dataUpdated = hesHandlerService.editMaintenanceType(generalMap);

			if (dataUpdated == true)
			{
				message = "Data updated Successfully !!";
			}
			else
			{
				message = "Try Again !!";
			}
		}
		else if (existingWorkNameList.size() > 0)
		{
			message = "Name already exists.";
		}

		url = "/hms/hms/cssd?method=showMaintenanceJobMasterJsp";

		try
		{
			map = hesHandlerService.showMaintenanceJobMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesMaintenanceJobMaster";
		title = "Edit Maintenance Job Type Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteMaintenanceType(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int userId=0;
		int cylinderId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		boolean dataDeleted = false;
		String flag = "";
		session=request.getSession();
		
		if (request.getParameter(COMMON_ID) != null	&& !(request.getParameter(COMMON_ID).equals("")))
		{
			cylinderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null && !(request.getParameter("flag").equals("")))
		{
			flag = request.getParameter("flag");
		}
		/*if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals("")))
		{
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("flag", flag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		
		dataDeleted = hesHandlerService.deleteMaintenanceType(cylinderId,generalMap);
		
		if (dataDeleted == true)
		{
			message = "Record is InActivated successfully !!";
		}
		else
		{
			message = "Record is Activated successfully !!";
		}
		
		try
		{
			map = hesHandlerService.showMaintenanceJobMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesMaintenanceJobMaster";
		title = "Delete Maintenance Job Type Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchMaintenanceType(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String MaintenanceCode = null;
		String MaintenanceName = null;
		String searchField = null;
		int searchRadio = 1;
		
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals("")))
		{
			MaintenanceCode = request.getParameter(CODE);
		}
		
		if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals("")))
		{
			MaintenanceName = request.getParameter(SEARCH_NAME);
		}

		try
		{
			if (request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals("")))
			{
				searchField = request.getParameter(SEARCH_FIELD);
			}
			
			if (request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals("")))
			{
				searchRadio = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (searchRadio == 1)
		{
			MaintenanceCode = searchField;
			MaintenanceName = null;
		}
		else
		{
			MaintenanceCode = null;
			MaintenanceName = searchField;
		}
		
		map = hesHandlerService.searchMaintenanceType(MaintenanceCode,MaintenanceName);
		
		jsp = "hesMaintenanceJobMaster";
		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCode", MaintenanceCode);
		map.put("workName", MaintenanceName);
		return new ModelAndView("index", "map", map);
	}
		
	// Methods for Maintenance Job Master ------- END
		
	// Methods for Cylinder Type Master ------- START
	public ModelAndView showCylinderTypeMasterJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession(true);
		map = hesHandlerService.showCylinderTypeMasterJsp();
		jsp = "hesCylinderTypeMaster";
		jsp += ".jsp";
		title = "Cylinder Type Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addCylinderType(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Date currentDate = new Date();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		List cylinderTypeCodeList = new ArrayList();
		List cylinderTypeNameList = new ArrayList();
		boolean successfullyAdded = false;
		session=request.getSession();
		int userId=0;
		HesCylinderTypeMaster cylinderTypeMaster = new HesCylinderTypeMaster();
		
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
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
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
		if (session.getAttribute(RequestConstants .USER_ID) != null) {
			userId=(Integer)session.getAttribute(RequestConstants .USER_ID);
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
				
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		
		if (listMap.get("duplicateGeneralCodeList") != null) {
			cylinderTypeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			cylinderTypeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((cylinderTypeCodeList.size() == 0 || cylinderTypeCodeList == null)
				&& (cylinderTypeNameList.size() == 0 || cylinderTypeNameList == null))

		{
			Users users=new Users();
			users.setId(userId);
			cylinderTypeMaster.setLastChgBy(users);
			cylinderTypeMaster.setLastChgDate(currentDate);
			cylinderTypeMaster.setLastChgTime(currentTime);
			cylinderTypeMaster.setStatus("y");
			cylinderTypeMaster.setCylinderTypeCode(code);
			cylinderTypeMaster.setCylinderTypeName(name);
			
			successfullyAdded = hesHandlerService.addCylinderType(cylinderTypeMaster);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
		
			}
		}
		else if ((cylinderTypeCodeList.size() != 0 || cylinderTypeCodeList != null)
				|| (cylinderTypeNameList.size() != 0) || cylinderTypeNameList != null) 
		{

			if ((cylinderTypeCodeList.size() != 0 || cylinderTypeCodeList != null)
					&& (cylinderTypeNameList.size() == 0 || cylinderTypeNameList == null)) {

				message = "Cylinder Type Code  already exists.";
			} else if ((cylinderTypeNameList.size() != 0 || cylinderTypeNameList != null)
					&& (cylinderTypeCodeList.size() == 0 || cylinderTypeCodeList == null)) {

				message = "Cylinder Type Name  already exists.";
			} else if ((cylinderTypeCodeList.size() != 0 || cylinderTypeCodeList != null)
					&& (cylinderTypeNameList.size() != 0 || cylinderTypeNameList != null)) {

				message = "Cylinder Type Code and Cylinder Type Name already exist.";
			}
		}
		
		url = "/hms/hms/cssd?method=showCylinderTypeMasterJsp";

		try {
			map = hesHandlerService.showCylinderTypeMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "hesCylinderTypeMaster";
		title = "Add Cylinder Type Data";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editCylinderType(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		String cylinderCode = "";
		String cylinderName = "";
		int cylinderId = 0;
		String changedBy = "";
		int userId=0;
		boolean dataUpdated = false;
		session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			cylinderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			cylinderCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			cylinderName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (session.getAttribute(RequestConstants.USER_ID) != null) {
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		generalMap.put("id", cylinderId);
		generalMap.put("code", cylinderCode);
		generalMap.put("name", cylinderName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		generalMap.put("userId", userId);
		
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");
		
		if (existingWorkNameList.size() == 0) 
		{
			dataUpdated = hesHandlerService.editCylinderType(generalMap);

			if (dataUpdated == true)
			{
				message = "Data updated Successfully !!";
			}
			else
			{
				message = "Try Again !!";
			}
		}
		else if (existingWorkNameList.size() > 0)
		{
			message = "Name already exists.";
		}

		url = "/hms/hms/cssd?method=showCylinderTypeMasterJsp";

		try
		{
			map = hesHandlerService.showCylinderTypeMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesCylinderTypeMaster";
		title = "Edit Cylinder Type Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteCylinderType(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int cylinderId = 0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		boolean dataDeleted = false;
		String flag = "";
		int userId=0;
		session=request.getSession();
		
		
		if (request.getParameter(COMMON_ID) != null	&& !(request.getParameter(COMMON_ID).equals("")))
		{
			cylinderId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null && !(request.getParameter("flag").equals("")))
		{
			flag = request.getParameter("flag");
		}
		if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals("")))
		{
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (session.getAttribute(RequestConstants.USERID )!=null)
		{
			userId =(Integer)session.getAttribute(RequestConstants.USERID);
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("flag", flag);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("userId", userId);
		dataDeleted = hesHandlerService.deleteCylinderType(cylinderId,generalMap);
		
		if (dataDeleted == true)
		{
			message = "Record is InActivated successfully !!";
		}
		else
		{
			message = "Record is Activated successfully !!";
		}
		
		try
		{
			map = hesHandlerService.showCylinderTypeMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesCylinderTypeMaster";
		title = "Delete Cylinder Type Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchCylinderType(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String CylinderTypeCode = null;
		String CylinderTypeName = null;
		String searchField = null;
		int searchRadio = 1;
		
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals("")))
		{
			CylinderTypeCode = request.getParameter(CODE);
		}
		
		if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals("")))
		{
			CylinderTypeName = request.getParameter(SEARCH_NAME);
		}

		try
		{
			if (request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals("")))
			{
				searchField = request.getParameter(SEARCH_FIELD);
			}
			
			if (request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals("")))
			{
				searchRadio = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (searchRadio == 1)
		{
			CylinderTypeCode = searchField;
			CylinderTypeName = null;
		}
		else
		{
			CylinderTypeCode = null;
			CylinderTypeName = searchField;
		}
		
		map = hesHandlerService.searchCylinderType(CylinderTypeCode,CylinderTypeName);
		
		jsp = "hesCylinderTypeMaster";
		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCode", CylinderTypeCode);
		map.put("workName", CylinderTypeName);
		return new ModelAndView("index", "map", map);
	}

	// Methods for Cylinder Type Master ------- END
		
	// Methods for Work Particular Master ------- START			
	public ModelAndView showWorkParticularMasterJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession(true);
		map = hesHandlerService.showWorkParticularMasterJsp();
		jsp = "hesworkparticularMaster";
		jsp += ".jsp";
		title = "Work Particular Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addWorkParticular(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Date currentDate = new Date();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		List workparticularCodeList = new ArrayList();
		List workparticularNameList = new ArrayList();
		boolean successfullyAdded = false;
		int userId=0;
		HesWorkParticularMaster hesWork = new HesWorkParticularMaster();
		session=request.getSession();
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
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
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
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
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);
				
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		
		if (listMap.get("duplicateGeneralCodeList") != null) {
			workparticularCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			workparticularNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		
		if ((workparticularCodeList.size() == 0 || workparticularCodeList == null)
				&& (workparticularNameList.size() == 0 || workparticularNameList == null))

		{
			
			Users users=new Users();
			users.setId(userId);
			hesWork.setLastChgBy(users);
			hesWork.setLastChgDate(currentDate);
			hesWork.setLastChgTime(currentTime);
			hesWork.setStatus("y");
			hesWork.setWorkParticularCode(code);
			hesWork.setWorkParticularName(name);
			
			successfullyAdded = hesHandlerService.addWorkParticularData(hesWork);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
		
			}
		}
		else if ((workparticularCodeList.size() != 0 || workparticularCodeList != null)
				|| (workparticularNameList.size() != 0) || workparticularNameList != null) 
		{

			if ((workparticularCodeList.size() != 0 || workparticularCodeList != null)
					&& (workparticularNameList.size() == 0 || workparticularNameList == null)) {

				message = "Work Particular Code  already exists.";
			} else if ((workparticularNameList.size() != 0 || workparticularNameList != null)
					&& (workparticularCodeList.size() == 0 || workparticularCodeList == null)) {

				message = "Work Particular Name  already exists.";
			} else if ((workparticularCodeList.size() != 0 || workparticularCodeList != null)
					&& (workparticularNameList.size() != 0 || workparticularNameList != null)) {

				message = "Work Particular Code and Work Particular Name already exist.";
			}
		}
		
		url = "/hms/hms/cssd?method=showInstrumentMasterJsp";

		try {
			map = hesHandlerService.showWorkParticularMasterJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}

		jsp = "hesworkparticularMaster";
		title = "Add Work Particular Data";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchWorkParticular(HttpServletRequest request,
			HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		String workCode = null;
		String workName = null;
		String searchField = null;
		int searchRadio = 1;
		
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals("")))
		{
			workCode = request.getParameter(CODE);
		}
		
		if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals("")))
		{
			workName = request.getParameter(SEARCH_NAME);
		}

		try
		{
			if (request.getParameter(SEARCH_FIELD) != null && !(request.getParameter(SEARCH_FIELD).equals("")))
			{
				searchField = request.getParameter(SEARCH_FIELD);
			}
			
			if (request.getParameter(SELECTED_RADIO) != null && !(request.getParameter(SELECTED_RADIO).equals("")))
			{
				searchRadio = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (searchRadio == 1)
		{
			workCode = searchField;
			workName = null;
		}
		else
		{
			workCode = null;
			workName = searchField;
		}
		
		map = hesHandlerService.searchWorkParticular(workCode,workName);
		
		jsp = "hesworkparticularMaster";
		jsp += ".jsp";
		
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("workCode", workCode);
		map.put("workName", workName);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView editWorkParticular(HttpServletRequest request,
			HttpServletResponse response)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		String workCode = "";
		String workName = "";
		int workId = 0;
		String changedBy = "";
		boolean dataUpdated = false;
		int userId=0;
		int hospitalId=0;
		session=request.getSession();
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			workId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			workCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			workName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}
		if (session.getAttribute(RequestConstants.USERID)!= null) {
			userId = (Integer)session.getAttribute(RequestConstants.USERID);
		}
		/*if (session.getAttribute(RequestConstants.HOSPITAL_ID)!= null) {
			hospitalId = (Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
		}*/
		
		generalMap.put("id", workId);
		generalMap.put("workCode", workCode);
		generalMap.put("name", workName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("userId", userId);
		//generalMap.put("hospitalId", hospitalId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List existingWorkNameList = (List) listMap.get("duplicateMastersList");
		
		if (existingWorkNameList.size() == 0) 
		{
			dataUpdated = hesHandlerService.editWorkParticularToDatabase(generalMap);

			if (dataUpdated == true)
			{
				message = "Data updated Successfully !!";
			}
			else
			{
				message = "Data Cant Be Updated !!";
			}
		}
		else if (existingWorkNameList.size() > 0)
		{
			message = "Name already exists.";
		}

		url = "/hms/hms/cssd?method=showInstrumentMasterJsp";

		try
		{
			map = hesHandlerService.showWorkParticularMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesworkparticularMaster";
		title = "Edit Work Particular Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteWorkParticular(HttpServletRequest request,HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		
		int workId = 0;
		int userId=0;
		String changedTime = "";
		Date changedDate = null;
		String changedBy = "";
		boolean dataDeleted = false;
		String flag = "";
		session=request.getSession();
		
		if (request.getParameter(COMMON_ID) != null	&& !(request.getParameter(COMMON_ID).equals("")))
		{
			workId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("flag") != null && !(request.getParameter("flag").equals("")))
		{
			flag = request.getParameter("flag");
		}
		/*if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals("")))
		{
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if(session.getAttribute(RequestConstants.USER_ID)!=null){
			userId=(Integer)session.getAttribute(RequestConstants.USER_ID);
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");

		generalMap.put("flag", flag);
		generalMap.put("userId", userId);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		
		dataDeleted = hesHandlerService.deleteWorkParticularMaster(workId,generalMap);
		
		if (dataDeleted == true)
		{
			message = "Record is InActivated successfully !!";
		}
		else
		{
			message = "Record is Activated successfully !!";
		}
		
		try
		{
			map = hesHandlerService.showWorkParticularMasterJsp();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		jsp = "hesworkparticularMaster";
		title = "Delete Work Particular Master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		
		return new ModelAndView("index", "map", map);
	}
	// Methods for Work Particular Master ------- END
	
	// Methods for Cylinder Usage Entry ------- START
	public ModelAndView showCylinderUsageEntryJsp(HttpServletRequest request,
			HttpServletResponse response)
	{
		int deptId = 0;
		int hospitalId= 0 ;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = hesHandlerService.showCylinderUsageEntryJsp(box);
		jsp = "hesCylinderUsageEntryJSP";
		jsp += ".jsp";
		title = "Cylinder Usage Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitCylinderUsageFormEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		int userId=0;
		int hospitalId=0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(RequestConstants .USERID) != null) {
			userId = Integer.parseInt("" + session.getAttribute(RequestConstants .USERID));
		}
		if (session.getAttribute(RequestConstants .HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants .HOSPITAL_ID));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);

		saved = hesHandlerService.submitCylinderUsageFormEntry(box, dataMap);
		map = hesHandlerService.showCylinderUsageEntryJsp(box);

		if (saved){
			message = "Record Added Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesCylinderUsageEntryJSP";
		jsp += ".jsp";
		title = "Cylinder Usage Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchCylinderUsageForm(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String toDate = "";
		String searchHead = "";
		int searchEntryNoId = 0;
		int searchCylinderTypeId = 0;
		String includedJsp = "";
		int deptId = 0;
		title = "View All";
		List headerList = new ArrayList();
		List hesEntryList = new ArrayList();
				
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		try
		{
			if (request.getParameter(FROM_DATE) != null){
				toDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter("searchHeadNo") != null){
				searchHead = request.getParameter("searchHeadNo");
			}
			if (request.getParameter("searchEntryNo") != null){
				searchEntryNoId = Integer.parseInt(request.getParameter("searchEntryNo"));
			}
			if (request.getParameter("searchCylinderNo") != null){
				searchCylinderTypeId = Integer.parseInt(request.getParameter("searchCylinderNo"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("searchHead", searchHead);
		searchFieldMap.put("searchEntryNoId", searchEntryNoId);
		searchFieldMap.put("searchCylinderTypeId", searchCylinderTypeId);
		
		poMap = (Map)hesHandlerService.showCylinderUsageEntryJsp(box);
		headerList = (List) poMap.get("headerList");
		hesEntryList = (List) poMap.get("hesEntryList");
				
		if (searchFieldMap.size() != 0){
			map = hesHandlerService.searchCylinderUsageForm(searchFieldMap);
			includedJsp = "done";
		}
		
		String jsp = "hesCylinderUsageMain";
		jsp += ".jsp";
		
		map.put("headerList", headerList);
		map.put("hesEntryList", hesEntryList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView modifyCylinderUsageForm(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		List hesEntryList = new ArrayList();
		List headerList = new ArrayList();
		List hesRoutineWorkList = new ArrayList();
		List orderminorList = new ArrayList();
		int radio_str = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		if(request.getParameter("parent") != null){
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) hesHandlerService.modifyCylinderUsageForm(radio_str,deptId);
		}
		
		poMap = (Map)hesHandlerService.showCylinderUsageEntryJsp(box);
		hesWorkList = (List) poMap.get("hesWorkList");
		headerList = (List) poMap.get("headerList");
		hesEntryList = (List) poMap.get("hesEntryList");
		
		hesRoutineWorkList = (List) map.get("hesRoutineWorkList");
		orderminorList = (List) map.get("orderminorList");
		
		jsp = "hesUpdateCylinderUsage";
		jsp += ".jsp";
		
		map.put("hesWorkList", hesWorkList);
		map.put("hesEntryList", hesEntryList);
		map.put("headerList", headerList);
		
		map.put("hesRoutineWorkList", hesRoutineWorkList);
		map.put("orderminorList", orderminorList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateCylinderUsageFormEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);

		saved = hesHandlerService.updateCylinderUsageFormEntry(box, dataMap);
		map = hesHandlerService.showCylinderUsageEntryJsp(box);

		if (saved){
			message = "Record Updated Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesCylinderUsageEntryJSP";
		jsp += ".jsp";
		title = "Cylinder Usage Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	// Methods for Cylinder Usage Entry ------- END
	
	// Methods for Refilled Cylinder Delivery Entry ------- START
	public ModelAndView showRefilledCylinderRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		int hospitalId= 0 ;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = hesHandlerService.showRefilledCylinderRequestJsp(box);
		jsp = "hesRefilledCylinderEntry";
		jsp += ".jsp";
		title = "Refilled Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitRefilledCylinderDeliveryEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		int hospitalId=0;
		int userId=0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
		}
		if (session.getAttribute(RequestConstants.USERID) != null) {
			userId = Integer.parseInt("" + session.getAttribute(RequestConstants.USERID));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);

		saved = hesHandlerService.submitRefilledCylinderDeliveryEntry(box, dataMap);
		map = hesHandlerService.showRefilledCylinderRequestJsp(box);

		if (saved){
			message = "Record Added Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesRefilledCylinderEntry";
		jsp += ".jsp";
		title = "Refilled Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchRefilledCylinderDeliveryForm(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		String toDate = "";
		String searchChallanNo = "";
		int searchEntryNoId = 0;
		String searchVehicleNo = "";
		String includedJsp = "";
		int deptId = 0;
		title = "View All";
		
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		try
		{
			if (request.getParameter(FROM_DATE) != null)
			{
				toDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter("searchChallanNo") != null)
			{
				searchChallanNo = request.getParameter("searchChallanNo");
			}
			if (request.getParameter("searchEntryNo") != null)
			{
				searchEntryNoId = Integer.parseInt(request.getParameter("searchEntryNo"));
			}
			if (request.getParameter("searchVehicleNo") != null)
			{
				searchVehicleNo = request.getParameter("searchVehicleNo");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("searchChallanNo", searchChallanNo);
		searchFieldMap.put("searchEntryNoId", searchEntryNoId);
		searchFieldMap.put("searchVehicleNo", searchVehicleNo);
		
		poMap = (Map)hesHandlerService.showRefilledCylinderRequestJsp(box);
		hesWorkList = (List) poMap.get("hesWorkList");
				
		if (searchFieldMap.size() != 0)
		{
			map = hesHandlerService.searchRefilledCylinderDeliveryForm(searchFieldMap);
			includedJsp = "done";
		}
		
		String jsp = "hesRefilledCylinderMain";
		jsp += ".jsp";
		
		map.put("hesWorkList", hesWorkList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView modifyRefilledCylinderDeliveryForm(HttpServletRequest request,
			HttpServletResponse response)
	{
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		List hesEntryList = new ArrayList();
		List masEmployeeList = new ArrayList();
		List hesRoutineWorkList = new ArrayList();
		List orderminorList = new ArrayList();
		int radio_str = 0;
		int deptId = 0;
		
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		if(request.getParameter("parent") != null){
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) hesHandlerService.modifyRefilledCylinderDeliveryForm(radio_str,deptId);
		}
		
		poMap = (Map)hesHandlerService.showRefilledCylinderRequestJsp(box);

		hesWorkList = (List) poMap.get("hesWorkList");
		hesEntryList = (List) poMap.get("hesEntryList");
		masEmployeeList = (List) poMap.get("masEmployeeList");
		
		hesRoutineWorkList = (List) map.get("hesRoutineWorkList");
		orderminorList = (List) map.get("orderminorList");

		jsp = "hesUpdateRefilledCylinder";
		jsp += ".jsp";
		
		map.put("hesWorkList", hesWorkList);
		map.put("hesEntryList", hesEntryList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("hesRoutineWorkList", hesRoutineWorkList);
		map.put("orderminorList", orderminorList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateRefilledCylinderDeliveryEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);

		saved = hesHandlerService.updateRefilledCylinderDeliveryEntry(box, dataMap);
		map = hesHandlerService.showRefilledCylinderRequestJsp(box);

		if (saved){
			message = "Record Updated Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesRefilledCylinderEntry";
		jsp += ".jsp";
		title = "Refilled Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	// Methods for Refilled Cylinder Delivery Entry ------- END
	
	// Methods for Empty Cylinders Dispatch Entry ------- START
	public ModelAndView showEmptyCylinderRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		int hospitalId= 0 ;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = hesHandlerService.showEmptyCylinderRequestJsp(box);
		jsp = "hesEmptyCylinderEntry";
		jsp += ".jsp";		title = "Empty Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public void getCylinderClosingStock(HttpServletRequest request, HttpServletResponse response)
	{
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List stockList = new ArrayList();
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("materialCode") != null)
		{
			pvmsNo = (request.getParameter("materialCode"));
		}
		
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		map = hesHandlerService.getCylinderClosingStock(dataMap);
		if (map.get("hesWorkList") != null) {
			stockList = (List) map.get("hesWorkList");
		}
		StringBuffer sb = new StringBuffer();
		try 
		{
			for (Iterator iterator = stockList.iterator(); iterator.hasNext();) 
			{
				Object[] object = (Object[]) iterator.next();
				sb.append("<item>");
				sb.append("<closingStock>"+object[0].toString()+"</closingStock>");
				sb.append("<itemId>"+object[1].toString()+"</itemId>");
				sb.append("</item>");
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try
		{
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public ModelAndView submitEmptyCylinderDispatchEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		int userId=0;
		int hospitalId=0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(RequestConstants.USERID ) != null) {
			userId = Integer.parseInt("" + session.getAttribute(RequestConstants.USERID));
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);

		saved = hesHandlerService.submitEmptyCylinderDispatchEntry(box, dataMap);
		map = hesHandlerService.showEmptyCylinderRequestJsp(box);

		if (saved){
			message = "Record Added Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesEmptyCylinderEntry";
		jsp += ".jsp";
		title = "Empty Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateEmptyCylinderDispatchEntry(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		String message = null;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);

		saved = hesHandlerService.updateEmptyCylinderDispatchEntry(box, dataMap);
		map = hesHandlerService.showEmptyCylinderRequestJsp(box);

		if (saved){
			message = "Record Updated Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesEmptyCylinderEntry";
		jsp += ".jsp";
		title = "Empty Cylinder Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
		
	public ModelAndView searchEmptyCylinderDispatchForm(HttpServletRequest request,
			HttpServletResponse response)
	{
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		String toDate = "";
		String searchChallanNo = "";
		int searchEntryNoId = 0;
		String searchVehicleNo = "";
		String includedJsp = "";
		int deptId = 0;
		title = "View All";
		
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		try
		{
			if (request.getParameter(FROM_DATE) != null)
			{
				toDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter("searchChallanNo") != null)
			{
				searchChallanNo = request.getParameter("searchChallanNo");
			}
			if (request.getParameter("searchEntryNo") != null)
			{
				searchEntryNoId = Integer.parseInt(request.getParameter("searchEntryNo"));
			}
			if (request.getParameter("searchVehicleNo") != null)
			{
				searchVehicleNo = request.getParameter("searchVehicleNo");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("searchChallanNo", searchChallanNo);
		searchFieldMap.put("searchEntryNoId", searchEntryNoId);
		searchFieldMap.put("searchVehicleNo", searchVehicleNo);
		
		poMap = (Map)hesHandlerService.showEmptyCylinderRequestJsp(box);
		hesWorkList = (List) poMap.get("hesWorkList");
				
		if (searchFieldMap.size() != 0)
		{
			map = hesHandlerService.searchEmptyCylinderDispatchForm(searchFieldMap);
			includedJsp = "done";
		}
		
		String jsp = "hesEmptyCylinderMain";
		jsp += ".jsp";
		
		map.put("hesWorkList", hesWorkList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView modifyEmptyCylinderDispatchForm(HttpServletRequest request,HttpServletResponse response)
	{
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List hesWorkList = new ArrayList();
		List hesEntryList = new ArrayList();
		List masEmployeeList = new ArrayList();
		List hesRoutineWorkList = new ArrayList();
		List orderminorList = new ArrayList();
		int radio_str = 0;
		int deptId = 0;
		
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		if(request.getParameter("parent") != null){
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) hesHandlerService.modifyEmptyCylinderDispatchForm(radio_str,deptId);
		}
		
		poMap = (Map)hesHandlerService.showEmptyCylinderRequestJsp(box);

		hesWorkList = (List) poMap.get("hesWorkList");
		hesEntryList = (List) poMap.get("hesEntryList");
		masEmployeeList = (List) poMap.get("masEmployeeList");
		
		hesRoutineWorkList = (List) map.get("hesRoutineWorkList");
		orderminorList = (List) map.get("orderminorList");

		jsp = "hesUpdateEmptyCylinder";
		jsp += ".jsp";
		
		map.put("hesWorkList", hesWorkList);
		map.put("hesEntryList", hesEntryList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("hesRoutineWorkList", hesRoutineWorkList);
		map.put("orderminorList", orderminorList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}
			
	// Methods for Empty Cylinders Dispatch Entry ------- END
	
	// Methods for Minor Routine Work ------- START
	public ModelAndView showAutoclaveRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		int hospitalId = 0;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		box.put("deptId", deptId);
		box.put("hospitalId", hospitalId);
		map = hesHandlerService.showMinorRoutineWorkJsp(box);
		jsp = "hesminorRoutineWorks";
		jsp += ".jsp";
		title = "Minor Routine Works Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getItemNamesForAutocomplete(HttpServletRequest request, HttpServletResponse response)
	{
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("requiredField") != null)
		{
			itemNameField = (request.getParameter("requiredField"));
		}
		if (request.getParameter(itemNameField) != null)
		{
			autoHint = (request.getParameter(itemNameField));
		}
		if(request.getParameter("hiddenValueCharge") != null)
		{
		}
		if(request.getParameter("incId") != null)
		{
		}
		dataMap.put("autoHint", autoHint);
		dataMap.put("deptId", deptId);
		
		map = hesHandlerService.getItemNamesForAutocomplete(dataMap);
		jsp = "autocompleteResultForItemNames";
		return new ModelAndView(jsp, "map", map);
	}
	
	public void getItemClosingStock(HttpServletRequest request, HttpServletResponse response)
	{
		String pvmsNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List stockList = new ArrayList();
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("materialCode") != null)
		{
			pvmsNo = (request.getParameter("materialCode"));
		}
		if(pvmsNo.contains("$"))
		{
			pvmsNo = pvmsNo.replace("$", "&");
		}
		dataMap.put("pvmsNo", pvmsNo);
		dataMap.put("deptId", deptId);
		map = hesHandlerService.getItemClosingStock(dataMap);
		if (map.get("hesWorkList") != null) {
			stockList = (List) map.get("hesWorkList");
		}
		StringBuffer sb = new StringBuffer();
		try 
		{
			for (Iterator iterator = stockList.iterator(); iterator.hasNext();) 
			{
				Object[] object = (Object[]) iterator.next();
				sb.append("<item>");
				sb.append("<closingStock>"+object[0].toString()+"</closingStock>");
				sb.append("<itemId>"+object[1].toString()+"</itemId>");
				sb.append("</item>");
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try
		{
			response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public ModelAndView submitMinorRoutineWorksEntry(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		String url = "";
		String entryNo = "";
		String message = null;
		int userId=0;
		int hospitalId=0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute(RequestConstants.USERID) != null) {
			userId = Integer.parseInt("" + session.getAttribute(RequestConstants.USERID));
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		box.put("userId", userId);
		box.put("hospitalId", hospitalId);

		saved = hesHandlerService.submitMinorRoutineWorksEntry(box, dataMap);
		map = hesHandlerService.showMinorRoutineWorkJsp(box);

		if (saved){
			message = "Record Added Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesminorRoutineWorks";
		jsp += ".jsp";
		title = "Minor Routine Works Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateMinorRoutineWorksEntry(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		boolean saved = false;
		int deptId = 0;
		String url = "";
		String entryNo = "";
		String message = null;
		
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		saved = hesHandlerService.updateMinorRoutineWorksEntry(box, dataMap);
		map = hesHandlerService.showMinorRoutineWorkJsp(box);

		if (saved){
			message = "Record Updated Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesminorRoutineWorks";
		jsp += ".jsp";
		title = "Minor Routine Works Entry";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchMinorRoutine(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> searchFieldMap = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List masDepartmentList = new ArrayList();
		List hesWorkList = new ArrayList();
		List hesEntryList = new ArrayList();
		String toDate = "";
		int searchWorkParticularId = 0;
		int searchEntryNoId = 0;
		int searchDeptNameId = 0;
		String includedJsp = "";
		int deptId = 0;
		String jsp = "hesMinorMain";
		title = "View All";
		jsp += ".jsp";

		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		
		try
		{
			if (request.getParameter(FROM_DATE) != null)
			{
				toDate = request.getParameter(FROM_DATE);
			}
			if (request.getParameter("searchWorkParticular") != null)
			{
				searchWorkParticularId = Integer.parseInt(request.getParameter("searchWorkParticular"));
			}
			if (request.getParameter("searchEntryNo") != null)
			{
				searchEntryNoId = Integer.parseInt(request.getParameter("searchEntryNo"));
			}
			if (request.getParameter("searchDeptName") != null)
			{
				searchDeptNameId = Integer.parseInt(request.getParameter("searchDeptName"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		searchFieldMap.put("toDate", toDate);
		searchFieldMap.put("searchWorkParticularId", searchWorkParticularId);
		searchFieldMap.put("searchEntryNoId", searchEntryNoId);
		searchFieldMap.put("searchDeptNameId", searchDeptNameId);
		
		poMap = (Map)hesHandlerService.showMinorRoutineWorkJsp(box);
		
		masDepartmentList = (List) poMap.get("masDepartmentList");
		hesWorkList = (List) poMap.get("hesWorkList");
		hesEntryList = (List) poMap.get("hesEntryList");
		
		if (searchFieldMap.size() != 0)
		{
			map = hesHandlerService.searchMinorRoutine(searchFieldMap);
			includedJsp = "done";
		}
		
		map.put("masDepartmentList", masDepartmentList);
		map.put("hesWorkList", hesWorkList);
		map.put("hesEntryList", hesEntryList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("includedJsp", includedJsp);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView modifyMinorRoutine(HttpServletRequest request, HttpServletResponse response)
	{
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> poMap = new HashMap<String, Object>();
		Map<String, Object> purchaseMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List masDepartmentList = new ArrayList();
		List hesWorkList = new ArrayList();
		List hesEntryList = new ArrayList();
		List masEmployeeList = new ArrayList();
		List hesRoutineWorkList = new ArrayList();
		List orderminorList = new ArrayList();
		jsp = "hes_update_minor_routine";
		jsp += ".jsp";
		int radio_str = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		box.put("deptId", deptId);
		if(request.getParameter("parent") != null){
			radio_str = Integer.parseInt(request.getParameter("parent"));
			map = (Map<String, Object>) hesHandlerService.modifyMinorRoutine(radio_str,deptId);
		}
		poMap = (Map)hesHandlerService.showMinorRoutineWorkJsp(box);

		masDepartmentList = (List) poMap.get("masDepartmentList");
		hesWorkList = (List) poMap.get("hesWorkList");
		hesEntryList = (List) poMap.get("hesEntryList");
		masEmployeeList = (List) poMap.get("masEmployeeList");
		hesRoutineWorkList = (List) map.get("hesRoutineWorkList");
		orderminorList = (List) map.get("orderminorList");

		map.put("masDepartmentList", masDepartmentList);
		map.put("hesWorkList", hesWorkList);
		map.put("hesEntryList", hesEntryList);
		map.put("masEmployeeList", masEmployeeList);
		map.put("hesRoutineWorkList", hesRoutineWorkList);
		map.put("orderminorList", orderminorList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}
	// Methods for Minor Routine Work ------- END
	
	// Methods for Equipment Details Master ------- START
	public ModelAndView showEquipmentDetailsMasterJsp(HttpServletRequest request,
			HttpServletResponse response)
	{   Map<String, Object> dataMap = new HashMap<String, Object>();
		int  deptId=0;
		int hospitalId= 0 ;
		session = request.getSession();
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
		}
		map.put("deptId", deptId);
		dataMap.put("hospitalId", hospitalId);
		
		map = hesHandlerService.showEquipmentDetailsMasterJsp(hospitalId);
		jsp = "hesEquipmentDetailsMaster";
		jsp += ".jsp";
		title = "Equipment Entry Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	// Method for Submit Equipment Entry Details Master and Assessory
	
	public ModelAndView submitEquipmentEntry(HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> commonMap = new HashMap<String, Object>();
		boolean saved = false;
		String message = null;
		String euipmentName="";
		String modelName="";
		String make="";
		String warrantyDetail="";
		String techSpecification="";
		String contactNo="";
		String entryNo="";
	    String serialNo="";
	    String changedBy="";
	    String lastChangedTime="";
		String asesryName="";
		String modelNo="";
		String assrySerialNo="";
		String warrantyStartDate="";
		String warrantyEndDate="";
		String date_Of_Installation="";
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		int quantity=0;
		String remarks="";
		String checkBox="";
		int deptId=0;
		int userId=0;
		int hospitalId=0;
	    Date changedDate= new Date();
		session = request.getSession();
		
		if((request.getParameter(RequestConstants.FROM_DATE)!=null) && !((request.getParameter(RequestConstants.FROM_DATE)).equals(""))){
			warrantyStartDate=(String)request.getParameter(RequestConstants.FROM_DATE) ;
			date1=HMSUtil.convertStringTypeDateToDateType(warrantyStartDate);
		}
		if((request.getParameter(RequestConstants.TO_DATE)!=null)&& !((request.getParameter(RequestConstants.TO_DATE)).equals(""))){
			warrantyEndDate=(String)request.getParameter(RequestConstants.TO_DATE) ;
			date2=HMSUtil.convertStringTypeDateToDateType(warrantyStartDate);
		}
		if((request.getParameter(RequestConstants.ON_DATE)!=null)&& !((request.getParameter(RequestConstants.ON_DATE)).equals(""))){
			date_Of_Installation=(String)request.getParameter(RequestConstants.ON_DATE);
			date3 =HMSUtil.convertStringTypeDateToDateType(date_Of_Installation) ;
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
		}
		if(request.getParameter("entryNo")!=null || request.getParameter("entryNo")!=""){
			entryNo=request.getParameter("entryNo");
			}
		if (request.getParameter("deptId") != null ) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		if(request.getParameter("SerialNo")!=null || request.getParameter("SerialNo")!=""){
			serialNo=request.getParameter("SerialNo");
		}
		if(request.getParameter("EquipmentName")!=null || request.getParameter("EquipmentName")!=""){
			euipmentName=request.getParameter("EquipmentName");
		}
		if(request.getParameter("ModelName")!=null || request.getParameter("ModelName")!=""){
			modelName=request.getParameter("ModelName");
		}
		if(request.getParameter("Make")!=null || request.getParameter("Make")!=""){
			make=request.getParameter("Make");
		}
		if(request.getParameter("WarrantyDetails")!=null || request.getParameter("WarrantyDetails")!=""){
			warrantyDetail=request.getParameter("WarrantyDetails");
		}
		if(request.getParameter("TechnicalSpecifications")!=null || request.getParameter("TechnicalSpecifications")!=""){
			techSpecification=request.getParameter("TechnicalSpecifications");
		}
		if(request.getParameter("ContactNoSalesService")!=null || request.getParameter("ContactNoSalesService")!=""){
			contactNo=request.getParameter("ContactNoSalesService");
		}
        if (session.getAttribute("userName") != null){
        	userName = (String) session.getAttribute("userName");
        }
        if (session.getAttribute(RequestConstants.USERID) != null){
        	userId = (Integer) session.getAttribute(RequestConstants.USERID);
        }
        if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
        	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
        if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
		}
        MasDepartment masDepartment = new MasDepartment();
        masDepartment.setId(deptId);
	   	HesEquipmentMaster hesEquipmentMaster=new HesEquipmentMaster();
    	hesEquipmentMaster.setEntryNo(entryNo);
    	hesEquipmentMaster.setSerialNo(serialNo);
    	hesEquipmentMaster.setEquipmentName(euipmentName);
    	hesEquipmentMaster.setModelName(modelName);
    	hesEquipmentMaster.setDepartment(masDepartment);
    	hesEquipmentMaster.setMake(make);
    	hesEquipmentMaster.setStatus("y");
    	hesEquipmentMaster.setWarrentyStartDate(date1);
    	hesEquipmentMaster.setWarrentyEndDate(date2);
    	hesEquipmentMaster.setDateOfInstallation(date3);
    	hesEquipmentMaster.setWarrantyDetails(warrantyDetail);
    	hesEquipmentMaster.setTechnicalSpecifications(techSpecification);
    	MasHospital masHospital=new  MasHospital();
    	masHospital.setId(hospitalId);
    	hesEquipmentMaster.setHospital(masHospital);
    	
    	Users users =new Users();
		users.setId(userId);
    	hesEquipmentMaster.setContactNoSalesService(contactNo);
    	hesEquipmentMaster.setLastChgBy(users);
    	hesEquipmentMaster.setLastChgTime(lastChangedTime);
    	hesEquipmentMaster.setLastChgDate(changedDate);
		commonMap.put("hesEquipmentMaster", hesEquipmentMaster);
	
		////////////////////////Code for EQUIPMENT Assessories  //////////////////////////
		
		int counter=0;
		if(request.getParameter("counter")!=null){
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		List<HesEquipmentAssessories> hesEquipmentAssessoriesList=new ArrayList<HesEquipmentAssessories>();
		    if(counter>0){
		       for(int i=1;i<=counter;i++){
		    	   if(request.getParameter("selectedChrage"+i)!=null || request.getParameter("selectedChrage"+i)!=""){
		    		   checkBox=request.getParameter("selectedChrage"+i);
		   		    }
		    	   if(request.getParameter("AssessoryName"+i)!=null || request.getParameter("AssessoryName"+i)!=""){
		   			asesryName=request.getParameter("AssessoryName"+i);
		   		  }
		    	   if(request.getParameter("ModelNo"+i)!=null || request.getParameter("ModelNo"+i)!=""){
		   			modelNo=request.getParameter("ModelNo"+i);
		   		    }
		    	   if(request.getParameter("Serial_No"+i)!=null || request.getParameter("Serial_No"+i)!=""){
		   			assrySerialNo=request.getParameter("Serial_No"+i);
		   		}
		    		if (request.getParameter("Quantity"+i) != null && !(request.getParameter("Quantity"+i).equals(""))) {
		    			quantity = Integer.parseInt(request.getParameter("Quantity"+i));
		    		}
		    		if(request.getParameter("Remarks"+i)!=null || request.getParameter("Remarks"+i)!=""){
		    			remarks=request.getParameter("Remarks"+i);
		    		}
			    	HesEquipmentAssessories hesAssessoryMaster = new HesEquipmentAssessories();
			   	    hesAssessoryMaster.setAssessoryName(asesryName);
			   		hesAssessoryMaster.setModelNo(modelNo);
			   		hesAssessoryMaster.setStatus("y");
			   		
			   	//commented for maven
			   		/*hesAssessoryMaster.setQuantity(quantity);*/
			   		hesAssessoryMaster.setSerialNo(assrySerialNo);
			   		hesAssessoryMaster.setRemarks(remarks);
			   		hesEquipmentAssessoriesList.add(hesAssessoryMaster);
			  }
		   }
		/////////////////////End/////////////////////////////
		commonMap.put("hesEquipmentAssessoriesList", hesEquipmentAssessoriesList);
		saved = hesHandlerService.submitEquipmentEntry(commonMap);
		map = hesHandlerService.showEquipmentDetailsMasterJsp(hospitalId);
		
		if (saved){
			message = "Record Added Successfully !!";
		}else{
			message = "Try Again !!";
		}
		jsp = "hesEquipmentDetailsMaster";
		jsp += ".jsp";
		title = "Equipment Entry Master";
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

//////////////////////////////Method by Amit for search Equipment details by entry no///////////////////////

public ModelAndView searchEquipmentEntry(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
	Map<String, Object> poMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	String entryIdTemp = "";
	int entry=0;
	try
	{
		if(request.getParameter("entryIdTemp")!=null){
			entryIdTemp=request.getParameter("entryIdTemp").trim();
			searchFieldMap.put("entryIdTemp", entryIdTemp);
		}
       if (session.getAttribute("userName") != null){
	        	userName = (String) session.getAttribute("userName");
	        	}
       }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	map = hesHandlerService.searchEquipmentEntry(searchFieldMap);
	String jsp = "hesEequipmentSearchJsp";
	title = "View All";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}


public ModelAndView getEntryListForEquipment(HttpServletRequest request,
		HttpServletResponse response) {
	
	String itemNameField = "";
	String autoHint = "";
	int equipmentId=0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("requiredField") != null) {
		itemNameField = (request.getParameter("requiredField"));
	}
	if (request.getParameter(itemNameField) != null) {
		autoHint = (request.getParameter(itemNameField));
	}
	dataMap.put("autoHint", autoHint);
	map = hesHandlerService.getEntryListForEquipment(dataMap);
	jsp = "resultEquipmentEntry";
	return new ModelAndView(jsp, "map", map);
}

public ModelAndView getEquipmentBreakdown(HttpServletRequest request,
		HttpServletResponse response) {
	
	String itemNameField = "";
	String autoHint = "";
	int equipmentId=0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("requiredField") != null) {
		itemNameField = (request.getParameter("requiredField"));
	}
	if (request.getParameter(itemNameField) != null) {
		autoHint = (request.getParameter(itemNameField));
	}
	dataMap.put("autoHint", autoHint);
	map = hesHandlerService.getEquipmentBreakdown(dataMap);
	jsp = "resultEquipmentBreakdownEntry";
	return new ModelAndView(jsp, "map", map);
}

public ModelAndView searchEquipmentBreakdownEntry(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
	Map<String, Object> poMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	String entryIdBreakdown = "";
	
	int deptId = 0;
	int equipmentId=0;
	int employeeIdTo=0;
	int employeeIdFrom=0;
	session = request.getSession();

	Map<String, Object> dataMap = new HashMap<String, Object>();
	/*if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}*/
	 if(session.getAttribute("deptId")!=null){
			deptId = Integer.parseInt((session.getAttribute("deptId")).toString());
		}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("empIdTo")!=null){
		employeeIdTo = Integer.parseInt(request.getParameter("empIdTo"));
	}
	if(request.getParameter("empIdFrom")!=null){
		employeeIdFrom = Integer.parseInt(request.getParameter("empIdFrom"));
	}
	//map.put("deptId", deptId);
	map.put("equipmentId", equipmentId);
	map.put("employeeIdTo", employeeIdTo);
	map.put("employeeIdFrom", employeeIdFrom);
	try
	{
		if(request.getParameter("entryIdBreakdown")!=null){
			
			entryIdBreakdown=request.getParameter("entryIdBreakdown").trim();
			searchFieldMap.put("entryIdBreakdown", entryIdBreakdown);
		}
       if (session.getAttribute("userName") != null){
	        	userName = (String) session.getAttribute("userName");
	      }
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	map = hesHandlerService.searchEquipmentBreakdownEntry(searchFieldMap);
	String jsp = "hesEequipmentBreakdownSearch";
	title = "View All";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView addEquipmentBreakdownEntry(HttpServletRequest request,
		HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();
	String changedBy = "";
	Map<String, Object> listMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Date currentDate = new Date();
	Date toDate = null;
	Date fromDate = null;
	session=request.getSession();
	String actionName="";
	String repair="";
	String comletedTimeId="";
	String serviceBy="";
	String entryNo="";
	String lastChangedTime="";
	int equipmentBreakdownId=0;
	Date changedDate= new Date();
	if (request.getParameter("actionTaken") != null) {
		actionName = request.getParameter("actionTaken");
	}
	if (request.getParameter("repair") != null) {
		repair = request.getParameter("repair");
	}
	if (request.getParameter("servicedBy") != null) {
		serviceBy = request.getParameter("servicedBy");
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
	if(request.getParameter("entryNoEmergeny")!=null && ! request.getParameter("entryNoEmergeny").equals("")){
		entryNo=request.getParameter("entryNoEmergeny");
	}
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if (session.getAttribute(CHANGED_BY) != null){
    	userName = (String) session.getAttribute(CHANGED_BY);
    }
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	   }
    
    if (request.getParameter("equipmentBreakdownId") != null) {
		equipmentBreakdownId = Integer.parseInt(request.getParameter("equipmentBreakdownId"));
	}
     HesEquipmentEmergencyMaintenanceBreakdown masterEmpergencyBreakdown = new HesEquipmentEmergencyMaintenanceBreakdown();
	 generalMap.put("actionTaken", actionName);
	 generalMap.put("repair", repair);
	 generalMap.put("completeTimeId", comletedTimeId);	 
	 generalMap.put("servicedBy", serviceBy);	
	 generalMap.put("changedBy", changedBy);
	 generalMap.put("pojoPropertyName", pojoPropertyName);
	 generalMap.put("pojoPropertyCode", pojoPropertyCode);
	 generalMap.put("pojoName", pojoName);
	
	 HesEquipmentBreakdownEntry breakDownEntry = new HesEquipmentBreakdownEntry();
	 breakDownEntry.setId(equipmentBreakdownId);
	boolean successfullyAdded = false;
		 masterEmpergencyBreakdown.setLastChgBy(userName);
	     masterEmpergencyBreakdown.setLastChgDate(changedDate);
	     masterEmpergencyBreakdown.setLastChgTime(lastChangedTime);
	     masterEmpergencyBreakdown.setEntryNo(entryNo);
	     masterEmpergencyBreakdown.setStatus("y");
	     masterEmpergencyBreakdown.setActionTaken(actionName);
	     masterEmpergencyBreakdown.setNatureOfRepairsCarriedOut(repair);
	     masterEmpergencyBreakdown.setTimeOfCompleteBreakd(lastChangedTime);
	     masterEmpergencyBreakdown.setServicedBy(serviceBy);
	     masterEmpergencyBreakdown.setEquipmentBreakdownEntry(breakDownEntry);
	    // masterEmpergencyBreakdown.setEquipmentBreakdownEntry(breakDownEntry);
		successfullyAdded = hesHandlerService.addEquipmentBreakdownEntry(masterEmpergencyBreakdown,equipmentBreakdownId);

		if (successfullyAdded) {
			message = "Record Added Successfully !!";
		} else {
			message = "Try Again !!";
		}
	url = "/hms/hms/hes?method=showEmergencyEquipmentBreakdownCallEntry";
	try {
		map = hesHandlerService.showEmergencyEquipmentBreakdownCallEntry(generalMap);
	} catch (Exception e) {
		e.printStackTrace();
	}
	String jsp = "hesEquipmentBreakdown";
	title = "Add Breakdown Entry";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("equipmentBreakdownId",equipmentBreakdownId );
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	return new ModelAndView("index", "map", map);

}
public ModelAndView deleteEmergencyEquipmentBreakdown(HttpServletRequest request,HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> listMap = new HashMap<String, Object>();
	int equipmentBreakId = 0;
	String changedTime = "";
	Date changedDate = null;
	String changedBy = "";
	boolean dataDeleted = false;
	String flag = "";
	if (request.getParameter(COMMON_ID) != null	&& !(request.getParameter(COMMON_ID).equals("")))
	{
		equipmentBreakId = Integer.parseInt(request.getParameter(COMMON_ID));
	}
	if (request.getParameter("flag") != null && !(request.getParameter("flag").equals("")))
	{
		flag = request.getParameter("flag");
	}
	if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals("")))
	{
		changedBy = request.getParameter(CHANGED_BY);
	}
	changedDate = new Date();
	changedTime = (String) HMSUtil.getCurrentDateAndTime().get("currentTime");
	generalMap.put("flag", flag);
	generalMap.put("changedBy", changedBy);
	generalMap.put("currentDate", changedDate);
	generalMap.put("currentTime", changedTime);
	dataDeleted = hesHandlerService.deleteEmergencyEquipmentBreakdown(equipmentBreakId,generalMap);
	if (dataDeleted == true)
	{
		message = "Record is InActivated successfully !!";
	}
	else
	{
		message = "Record is Activated successfully !!";
	}
	try
	{
		map = hesHandlerService.showEmergencyEquipmentBreakdownCallEntry(listMap);
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	jsp = "equiomentBreakDownSearch";
	title = "Update Equipment Breakdown Master";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("url", url);
	map.put("message", message);
	
	return new ModelAndView("index", "map", map);
}


//////////////////Code for show Equipment Preventive Maintenance Entry/////////////////

public ModelAndView showEquipmentMaintenanceEntryJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int equipmentId=0;
	int employeeId=0;
	int maintenanceJobId=0;
	int hospitalId= 0 ;
	String toDate = "";
	String searchEquipmentName="";
	String  searchEntryNo="";
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt("" + request.getParameter("deptId"));
	}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(""+request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeId = Integer.parseInt(""+request.getParameter("empId"));
	}
	if(request.getParameter("maintenanceId")!=null){
		maintenanceJobId = Integer.parseInt(""+request.getParameter("maintenanceId"));
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
	}
	dataMap.put("hospitalId",hospitalId);
	map.put("deptId", deptId);
	map.put("equipmentId", equipmentId);
	map.put("employeeId", employeeId);
	map.put("maintenanceJobId", maintenanceJobId);
	map.put("hospitalId", hospitalId);
	map = hesHandlerService.showEquipmentMaintenanceEntryJsp(dataMap);
	jsp = "hesPreventiveMaintenanceEntry";
	jsp += ".jsp";
	title = "Preventive Maintenance Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitEquipmentMaintenanceEntryJsp(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	boolean saved = false;
	int deptId = 0;
	String url = "";
	String entryNo = "";
	int equipmentId=0;
	int employeeId=0;
	String date="";
	int userId=0;
	int hospitalId=0;
	Date date1 = new Date();
	int maintenanceJobId=0;
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	
	if(request.getParameter(RequestConstants.FROM_DATE)!=null || request.getParameter(RequestConstants.FROM_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.FROM_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	if(request.getParameter("entryNo")!=null || request.getParameter("entryNo")!=""){
		entryNo=request.getParameter("entryNo");
	}
	if (request.getParameter("deptId") != null ) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(""+request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeId = Integer.parseInt(""+request.getParameter("empId"));
	}
	if(request.getParameter("maintenanceId")!=null ){
		maintenanceJobId = Integer.parseInt(""+request.getParameter("maintenanceId"));
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
	if (session.getAttribute("userId") != null){
		userId = (Integer) session.getAttribute("userId");
     }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	   }
    if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
	}
     HesEquipmentMaintenance hesEqpMaintenance = new  HesEquipmentMaintenance();
     MasDepartment masDepartment = new MasDepartment();
     masDepartment.setId(deptId);
     MasEmployee masEmployee = new MasEmployee();
     masEmployee.setId(employeeId);
     HesMaintenanceJobMaster maintenanceJobMaster = new HesMaintenanceJobMaster();
     maintenanceJobMaster.setId(maintenanceJobId);
     HesEquipmentMaster hesEquipmentMaster = new HesEquipmentMaster();
     hesEquipmentMaster.setId(equipmentId);
     hesEqpMaintenance.setDepartment(masDepartment);
     hesEqpMaintenance.setEmployee(masEmployee);
     hesEqpMaintenance.setMaintenance(maintenanceJobMaster);
     hesEqpMaintenance.setEquipment(hesEquipmentMaster);
     MasHospital masHospital=new MasHospital();
     masHospital.setId(hospitalId);
     hesEqpMaintenance.setHospital(masHospital);
     Users users=new Users();
     users.setId(userId);
     hesEqpMaintenance.setLastChgBy(users);
     hesEqpMaintenance.setLastChgDate(changedDate);
     hesEqpMaintenance.setLastChgTime(lastChangedTime);
     hesEqpMaintenance.setEntryNo(entryNo);
     hesEqpMaintenance.setDate(date1);
     hesEqpMaintenance.setScheduleDate(changedDate);
     hesEqpMaintenance.setScheduleTime(lastChangedTime);
     hesEqpMaintenance.setStatus("y");
     dataMap.put("hesEqpMaintenance", hesEqpMaintenance);
     dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.submitEquipmentMaintenanceEntryJsp(dataMap);
	map = hesHandlerService.showEquipmentMaintenanceEntryJsp(dataMap);
	if (saved){
		message = "Failed !!";
	}else{
		message = "Record Added Successfully !!";
	}
	jsp = "hesPreventiveMaintenanceEntry";
	jsp += ".jsp";
	title = "Preventive Maintenance Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchMaintenanceEntry(HttpServletRequest request, HttpServletResponse response){
	
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
  	Map<String, Object> map = new HashMap<String, Object>();
    String toDate = "";
	String searchEquipmentName="";
	String  searchEntryNo="";
	String includedJsp = "";
	Box box = HMSUtil.getBox(request);
	 if ((request.getParameter(RequestConstants.ON_DATE) != null) || !(request.getParameter(RequestConstants.ON_DATE).equals("")))
		{
			toDate=(String)request.getParameter(RequestConstants.ON_DATE)  ;
			searchFieldMap.put("toDate", toDate);
 		}
	    if (request.getParameter("searchEntryNo") != null || !request.getParameter("searchEntryNo").equals("0"))
		{
			searchEntryNo = (String)request.getParameter("searchEntryNo");
			searchFieldMap.put("searchEntryNo", searchEntryNo);
		}
		if (request.getParameter("searchEquipment") != null || !request.getParameter("searchEquipment").equals("0") )
		{
			searchEquipmentName = (String)request.getParameter("searchEquipment");
			searchFieldMap.put("searchEquipmentName", searchEquipmentName);
 		}
	  	map = hesHandlerService.searchMaintenanceEntry(searchFieldMap);
		jsp = "hes_Maintenance_Entry";
		jsp += ".jsp";
		title = "View All";
		map.put("contentJsp", jsp);
		map.put("title", title);
       return new ModelAndView("index", "map", map);

}

////////////////////////Code for Equipment Call Log Entry/////////////////////////////////

public ModelAndView showEquipmentCallLogEntryJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int equipmentId=0;
	int employeeId=0;
	int hospitalId=0 ;
	session=request.getSession();

	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt("" + request.getParameter("deptId"));
	}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(""+request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeId = Integer.parseInt(""+request.getParameter("empId"));
	}
	if (session.getAttribute(RequestConstants.HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(RequestConstants.HOSPITAL_ID));
	}
	map.put("deptId", deptId);
	map.put("equipmentId", equipmentId);
	map.put("employeeId", employeeId);
	dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.showEquipmentCallLogEntryJsp(dataMap);
	jsp = "hesEquipmentCallLogEntryJsp";
	jsp += ".jsp";
	title = "Equipment Call Log Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}


public ModelAndView submitEquipmentCallLogEntryJsp(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	boolean saved = false;
	int deptId = 0;
	String url = "";
	String entryNo = "";
	int equipmentId=0;
	String remarks="";
	int employeeId=0;
	int userId=0;
	int hospitalId=0;
	String date = "";
	Date date1 = new Date();
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	
	if(request.getParameter(RequestConstants.FROM_DATE)!=null || request.getParameter(RequestConstants.FROM_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.FROM_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	if(request.getParameter("entryNo")!=null || request.getParameter("entryNo")!=""){
		entryNo=request.getParameter("entryNo");
	}
	if (request.getParameter("deptId") != null ) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeId = Integer.parseInt(request.getParameter("empId"));
	}
	if(request.getParameter("remarks")!=null){
		remarks=request.getParameter("remarks");
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
	if (session.getAttribute("userId") != null){
		userId = (Integer) session.getAttribute("userId");
     }
	if (session.getAttribute("hospitalId") != null){
		hospitalId = (Integer) session.getAttribute("hospitalId");
     }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	   }
     HesEquipmentCallLogEntry hesEqpCall = new  HesEquipmentCallLogEntry();
     MasDepartment masDepartment = new MasDepartment();
     masDepartment.setId(deptId);
     MasEmployee masEmployee = new MasEmployee();
     masEmployee.setId(employeeId);
     HesEquipmentMaster hesEquipmentMaster = new HesEquipmentMaster();
     hesEquipmentMaster.setId(equipmentId);
     hesEqpCall.setDepartment(masDepartment);
     hesEqpCall.setEmployee(masEmployee);
     hesEqpCall.setEquipment(hesEquipmentMaster);
     Users users =new Users();
     users.setId(userId);
     hesEqpCall.setLastChgBy(users);
     hesEqpCall.setLastChgDate(changedDate);
     hesEqpCall.setLastChgTime(lastChangedTime);
     hesEqpCall.setEntryNo(entryNo);
     hesEqpCall.setRemarks(remarks);
     hesEqpCall.setDate(date1);
     MasHospital masHospital =new MasHospital();
     masHospital.setId(hospitalId);
     hesEqpCall.setHospital(masHospital);
     hesEqpCall.setDate(date1);
     hesEqpCall.setCallDate(changedDate);
     hesEqpCall.setCallTime(lastChangedTime);
     hesEqpCall.setStatus("y");
     dataMap.put("hesEqpCall", hesEqpCall);
     dataMap.put("hospitalId", hospitalId);
    map = hesHandlerService.submitEquipmentCallLogEntryJsp(dataMap);
	map = hesHandlerService.showEquipmentCallLogEntryJsp(dataMap);
	if (saved){
		message = "Failed !!";
	}else{
		message = "Record Added Successfully !!";
	}
	jsp = "hesEquipmentCallLogEntryJsp";
	jsp += ".jsp";
	title = "2.1.1.1Equipment Call Log Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchEquipmentCallLogEntryForm(HttpServletRequest request,
		HttpServletResponse response)
{
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List hesWorkList = new ArrayList();
	String toDate = "";
	String searchEquipmentName = "";
	String searchEntryNoId = "";
	String includedJsp = "";
	title = "View All";
	try
	{
		if (request.getParameter(RequestConstants.ON_DATE) != null)
		{
			toDate = request.getParameter(RequestConstants.ON_DATE);
		}
		if (request.getParameter("searchEquipment") != null)
		{
			searchEquipmentName = request.getParameter("searchEquipment");
		}
		if (request.getParameter("searchEntryNo") != null)
		{
			searchEntryNoId = request.getParameter("searchEntryNo");
		}
	}
	catch(Exception e)
	{	
		e.printStackTrace();
	}
	searchFieldMap.put("toDate", toDate);
	searchFieldMap.put("searchEquipmentName", searchEquipmentName);
	searchFieldMap.put("searchEntryNoId", searchEntryNoId);
	map = hesHandlerService.searchEquipmentCallLogEntryForm(searchFieldMap);
	String jsp = "hesEquipmentCallLogEntryGrid";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("includedJsp", includedJsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchEquipmentMaintenanceForm(HttpServletRequest request,
		HttpServletResponse response)
{
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List hesWorkList = new ArrayList();
	String toDate = "";
	String searchEquipmentName = "";
	String searchEntryNoId = "";
	String includedJsp = "";
	title = "View All";
	try
	{
		if (request.getParameter(RequestConstants.ON_DATE) != null)
		{
			toDate = request.getParameter(RequestConstants.ON_DATE);
		}
		if (request.getParameter("searchEquipment") != null)
		{
			searchEquipmentName = request.getParameter("searchEquipment");
		}
		if (request.getParameter("searchEntryNo") != null)
		{
			searchEntryNoId = request.getParameter("searchEntryNo");
		}
	}
	catch(Exception e)
	{	
		e.printStackTrace();
	}
	searchFieldMap.put("toDate", toDate);
	searchFieldMap.put("searchEquipmentName", searchEquipmentName);
	searchFieldMap.put("searchEntryNoId", searchEntryNoId);
	map = hesHandlerService.searchEquipmentMaintenanceForm(searchFieldMap);
	String jsp = "hesEquipmentMaintenanceEntryGrid";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("includedJsp", includedJsp);
	return new ModelAndView("index", "map", map);
}
////////////////////////Code for Equipment Break down Entry/////////////////////////////////

public ModelAndView showEquipmentBreakdownEntryJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int hospitalId = 0;
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
	}
	map.put("deptId", deptId);
	dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.showEquipmentBreakdownEntryJsp(dataMap);
	jsp = "hesEquipmentBreakdownEntry";
	jsp += ".jsp";
	title = "Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitEquipmentBreakdownEntryJsp(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	boolean saved = false;
	int deptId = 0;
	String url = "";
	String entryNo = "";
	int equipmentId=0;
	int employeeIdTo=0;
	int employeeIdFrom=0;
	String remarks="";
	Date date1 = new Date();
	String date = "";
	String natureOfBreakdown="";
	String message = null;
	String lastChangedTime="";
	int userId=0;
	int hospitalId=0;
    Date changedDate= new Date();
	session = request.getSession();
	
	if(request.getParameter(RequestConstants.ON_DATE)!=null || request.getParameter(RequestConstants.ON_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.ON_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	if(request.getParameter("entryNo")!=null || request.getParameter("entryNo")!=""){
		entryNo=request.getParameter("entryNo");
	}
	if(session.getAttribute("deptId")!=null){
			deptId = Integer.parseInt((session.getAttribute("deptId")).toString());
		}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("employeeIdTo")!=null){
		employeeIdTo = Integer.parseInt(request.getParameter("employeeIdTo"));
	}
	if(request.getParameter("employeeIdFrom")!=null){
		employeeIdFrom = Integer.parseInt(request.getParameter("employeeIdFrom"));
	}
	if(request.getParameter("breakId")!=null || request.getParameter("breakId")!=""){
		natureOfBreakdown=request.getParameter("breakId");
	}
	if(request.getParameter("remarks")!=null || request.getParameter("remarks")!=""){
		remarks=request.getParameter("remarks");
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
	if (session.getAttribute("hospitalId") != null){
		hospitalId = (Integer) session.getAttribute("hospitalId");
     }
	if (session.getAttribute("userId") != null){
     	userId = (Integer) session.getAttribute("userId");
     }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	   }
     HesEquipmentBreakdownEntry masterBreakdown = new HesEquipmentBreakdownEntry();
     MasDepartment masDepartment = new MasDepartment();
     masDepartment.setId(deptId);
     MasEmployee masEmployeeTo = new MasEmployee();
     masEmployeeTo.setId(employeeIdTo);
     MasEmployee masEmployeeFrom = new MasEmployee();
     masEmployeeFrom.setId(employeeIdFrom);
     HesEquipmentMaster hesEquipmentMaster = new HesEquipmentMaster();
     hesEquipmentMaster.setId(equipmentId);
     masterBreakdown.setDepartment(masDepartment);
     MasHospital masHospital =new MasHospital();
     masHospital.setId(hospitalId);
     masterBreakdown.setHospital(masHospital);
     masterBreakdown.setEmployeeIdTo(masEmployeeTo);
     masterBreakdown.setEmployeeIdFrom(masEmployeeFrom);
     masterBreakdown.setEquipment(hesEquipmentMaster);
     Users users =new Users();
     users.setId(userId);
     masterBreakdown.setLastChgBy(users);
     masterBreakdown.setLastChgDate(changedDate);
     masterBreakdown.setLastChgTime(lastChangedTime);
     masterBreakdown.setEntryNo(entryNo);
     masterBreakdown.setDate(date1);  
     masterBreakdown.setDateOfBreakdown(changedDate);
     masterBreakdown.setNatureOfBreakdown(natureOfBreakdown);
     masterBreakdown.setTimeOfBreakdown(lastChangedTime);
     masterBreakdown.setRemarks(remarks);
     masterBreakdown.setStatus("n");
     dataMap.put("masterBreakdown", masterBreakdown);
     dataMap.put("hospitalId", hospitalId);
     
	map = hesHandlerService.submitEquipmentBreakdownEntryJsp(dataMap);
	map = hesHandlerService.showEquipmentBreakdownEntryJsp(dataMap);
	if (saved){
		message = "Failed !!";
	}else{
		message = "Record Added Successfully !!";
	}
	jsp = "hesEquipmentBreakdownEntry";
	jsp += ".jsp";
	title = "Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchEquipmentBreakdownForm(HttpServletRequest request,
		HttpServletResponse response)
{
	Map<String, Object> searchFieldMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List hesWorkList = new ArrayList();
	String toDate = "";
	String searchEquipmentName = "";
	String searchEntryNoId = "";
	String includedJsp = "";
	title = "View All";
	try
	{
		if (request.getParameter(FROM_DATE) != null)
		{
			toDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter("searchEquipment") != null)
		{
			searchEquipmentName = request.getParameter("searchEquipment");
		}
		if (request.getParameter("searchEntryNo") != null)
		{
			searchEntryNoId = request.getParameter("searchEntryNo");
		}
	}
	catch(Exception e)
	{
	  e.printStackTrace();
	}
	searchFieldMap.put("toDate", toDate);
	searchFieldMap.put("searchEquipmentName", searchEquipmentName);
	searchFieldMap.put("searchEntryNoId", searchEntryNoId);
	map = hesHandlerService.searchEquipmentBreakdownForm(searchFieldMap);
	String jsp = "hesEquipmentBrakdownMainGrid";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("includedJsp", includedJsp);
	return new ModelAndView("index", "map", map);
}

public ModelAndView modifyEquipmentBreakdown(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> poMap = new HashMap<String, Object>();
	Map<String, Object> listMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	int radio_str = 0;
	boolean saved = false;
	int deptId = 0;
	String url = "";
	int equipmentId=0;
	int employeeIdTo=0;
	int employeeIdFrom=0;
	String remarks="";
	Date date1 = new Date();
	String date = "";
	String natureOfBreakdown="";
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	if(request.getParameter(RequestConstants.ON_DATE)!=null || request.getParameter(RequestConstants.ON_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.ON_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	if(session.getAttribute("deptId")!=null){
			deptId = Integer.parseInt((session.getAttribute("deptId")).toString());
		}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("employeeIdTo")!=null){
		employeeIdTo = Integer.parseInt(request.getParameter("employeeIdTo"));
	}
	if(request.getParameter("employeeIdFrom")!=null){
		employeeIdFrom = Integer.parseInt(request.getParameter("employeeIdFrom"));
	}
	if(request.getParameter("breakId")!=null || request.getParameter("breakId")!=""){
		natureOfBreakdown=request.getParameter("breakId");
	}
	if(request.getParameter("remarks")!=null || request.getParameter("remarks")!=""){
		remarks=request.getParameter("remarks");
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
    }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	  }
    if(request.getParameter("radio_str") != null){
		radio_str = Integer.parseInt(request.getParameter("radio_str"));
	}
    generalMap.put("date1", date1);
    generalMap.put("deptId", deptId);
    generalMap.put("equipmentId", equipmentId);
    generalMap.put("employeeIdTo", employeeIdTo);    
    generalMap.put("natureOfBreakdown", natureOfBreakdown); 
    generalMap.put("remarks", remarks);
    generalMap.put("userName", userName);
    generalMap.put("changedDate", changedDate);
    generalMap.put("lastChangedTime", lastChangedTime);
    generalMap.put("radio_str", radio_str);
    listMap = commonMasterHandlerService
	.checkForExistingMasters(generalMap);
    List existingCountryNameList = (List) listMap
	.get("duplicateMastersList");
    boolean dataUpdated = false;
	if (existingCountryNameList.size() == 0) {
		dataUpdated = hesHandlerService.modifyEquipmentBreakdown(generalMap);
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
	} else if (existingCountryNameList.size() > 0) {
		message = "Name already exists.";
	}
	url = "/hms/hms/hes?method=showEquipmentBreakdownEntryJsp";
	try {
		map = hesHandlerService.showEquipmentBreakdownEntryJsp(dataMap);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "hesEquipmentBreakdownUpdate";
	jsp += ".jsp";
	title = "Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

public ModelAndView modifyCallLogEntry(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> poMap = new HashMap<String, Object>();
	Map<String, Object> listMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	int radio_str = 0;
	boolean saved = false;
	int deptId = 0;
	String url = "";
	int equipmentId=0;
	int employeeIdTo=0;
	String remarks="";
	Date date1 = new Date();
	String date = "";
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	
	if(request.getParameter(RequestConstants.FROM_DATE)!=null || request.getParameter(RequestConstants.FROM_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.FROM_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	 if(session.getAttribute("deptId")!=null){
			deptId = Integer.parseInt((session.getAttribute("deptId")).toString());
		}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeIdTo = Integer.parseInt(request.getParameter("empId"));
	}
	if(request.getParameter("remarks")!=null || request.getParameter("remarks")!=""){
		remarks=request.getParameter("remarks");
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
			}
    if(request.getParameter("radio_str") != null){
		radio_str = Integer.parseInt(request.getParameter("radio_str"));
	}
    generalMap.put("date1", date1);
    generalMap.put("deptId", deptId);
    generalMap.put("equipmentId", equipmentId);
    generalMap.put("employeeIdTo", employeeIdTo);
    generalMap.put("remarks", remarks);
    generalMap.put("userName", userName);
    generalMap.put("changedDate", changedDate);
    generalMap.put("lastChangedTime", lastChangedTime);
    generalMap.put("radio_str", radio_str);
    listMap = commonMasterHandlerService
	.checkForExistingMasters(generalMap);
    List existingCountryNameList = (List) listMap
	.get("duplicateMastersList");
    
    boolean dataUpdated = false;
	if (existingCountryNameList.size() == 0) {
		dataUpdated = hesHandlerService.modifyCallLogEntry(generalMap);
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
	} else if (existingCountryNameList.size() > 0) {
		message = "Name already exists.";
	}
	url = "/hms/hms/hes?method=showEquipmentCallLogEntryJsp";
	try {
		map = hesHandlerService.showEquipmentCallLogEntryJsp(dataMap);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp="hesEquipmentCallLogEntryJsp";
	//jsp = "hesEquipmentCallLogUpdate";
	jsp += ".jsp";
	title = "Equipment Call Log Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}


public ModelAndView modifyMaintenanceEntry(HttpServletRequest request,HttpServletResponse response)
{	
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> listMap = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	int radio_str = 0;
	boolean saved = false;
	int deptId = 0;
	String url = "";
	int equipmentId=0;
	int employeeIdTo=0;
	int jobMaintenanceId=0;
	Date date1 = new Date();
	String date = "";
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	
	if(request.getParameter(RequestConstants.FROM_DATE)!=null || request.getParameter(RequestConstants.FROM_DATE)!=""){
		date=(String)request.getParameter(RequestConstants.FROM_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(date);
	}
	 if(session.getAttribute("deptId")!=null){
			deptId = Integer.parseInt((session.getAttribute("deptId")).toString());
		}
	if(request.getParameter("equipmentId")!=null){
		equipmentId=Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(request.getParameter("empId")!=null){
		employeeIdTo = Integer.parseInt(request.getParameter("empId"));
	}
	if(request.getParameter("maintenanceId")!=null || request.getParameter("maintenanceId")!=""){
	 jobMaintenanceId	=Integer.parseInt(request.getParameter("maintenanceId"));
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
			}
    if(request.getParameter("radio_str") != null){
		radio_str = Integer.parseInt(request.getParameter("radio_str"));
	}
    generalMap.put("date1", date1);
    generalMap.put("deptId", deptId);
    generalMap.put("equipmentId", equipmentId);
    generalMap.put("employeeIdTo", employeeIdTo);
    generalMap.put("jobMaintenanceId", jobMaintenanceId);
    generalMap.put("userName", userName);
    generalMap.put("changedDate", changedDate);
    generalMap.put("lastChangedTime", lastChangedTime);
    generalMap.put("radio_str", radio_str);
    listMap = commonMasterHandlerService
	.checkForExistingMasters(generalMap);
    List existingCountryNameList = (List) listMap
	.get("duplicateMastersList");
    boolean dataUpdated = false;
	if (existingCountryNameList.size() == 0) {
		dataUpdated = hesHandlerService.modifyMaintenanceEntry(generalMap);
		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant Be Updated !!";
		}
	} else if (existingCountryNameList.size() > 0) {
		message = "Name already exists.";
	}
	url = "/hms/hms/hes?method=showEquipmentMaintenanceEntryJsp";
	try {
		map = hesHandlerService.showEquipmentMaintenanceEntryJsp(dataMap);

	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "hesEquipmentMaintenanceUpdate";
	jsp += ".jsp";
	title = "Modify Equipment Maintenance Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}

//////////////////////////////End//////////////////////////////////////////////////////////


////////////////////////Start Code for Emergency Call Entry Equipment Break down////////////////////////////////

public ModelAndView showEmergencyEquipmentBreakdownCallEntry(HttpServletRequest request,
		HttpServletResponse response)
{
	session = request.getSession(true);
	String entryNo="";
	int hospitalId=0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if(request.getParameter("entryNoEmergeny")!=null){
		entryNo=request.getParameter("entryNoEmergeny");
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
	}
	map.put("hospitalId", hospitalId);
	map = hesHandlerService.showEmergencyEquipmentBreakdownCallEntry(dataMap);
	jsp = "hesEquipmentBreakdown";
	jsp += ".jsp";
	title = "Emergency Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView searchEmergencyEquipmentBreakdown(HttpServletRequest request,
		HttpServletResponse response) 
{
	Map<String, Object> map = new HashMap<String, Object>();
	String departmentName = null;
	String entryNo="";
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if(request.getParameter("entryNoEmergeny")!=null || request.getParameter("entryNoEmergeny")!=""){
		entryNo=request.getParameter("entryNoEmergeny");
	}
	if (request.getParameter(RequestConstants.DEPARTMENT_ID) != null && !(request.getParameter(RequestConstants.DEPARTMENT_ID).equals("")))
	{
		departmentName = request.getParameter(RequestConstants.DEPARTMENT_ID);
	}
	//map = hesHandlerService.showEmergencyEquipmentBreakdownCallEntry(dataMap);
	map = hesHandlerService.searchEmergencyEquipmentBreakdown(departmentName);
	jsp = "equiomentBreakDownSearch";
	jsp += ".jsp";
	title = "Emergency Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("search", "search");
	map.put("departmentName", departmentName);
	return new ModelAndView("index", "map", map);
}
//////////////////////////////End//////////////////////////////////////////////////////////

///////////////////////////Code for Communication//////////////////////////////////////////
public ModelAndView showCommunicationJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataObj = new HashMap<String, Object>();
	List<CommunicationMessages> messageList = new ArrayList<CommunicationMessages>();
	HttpSession session = request.getSession(true);
	String message = null;
	String lastChangedTime="";
	int messageFrom = 0;
	int messageTo = 0 ;
	String msgTxt = "";
	int employeeId=0;
	int empId=0;
    Date changedDate= new Date();
    Users users =new  Users();
    MasEmployee masEmployee=new MasEmployee();
    if(session.getAttribute("users")!=null){
    	users=(Users)session.getAttribute("users");
    	empId = users.getEmployee().getId();
    	masEmployee= users.getEmployee();
    	dataObj.put("empId", empId);
    }
  //  messageList = (List)map.get("messageList");
	map = hesHandlerService.showCommunicationJsp(dataObj);
	jsp = "communicationMessage";
	title = "Message Send/Receive";
	map.put("empId", empId);
	map.put("masEmployee", masEmployee);
	map.put("messageList", messageList);
	map.put("messageTo", messageTo);
	map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView submitCommunicationMessageJsp(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> msgMap = new HashMap<String, Object>();
	List<CommunicationMessages> commMsgList = new ArrayList<CommunicationMessages>();
	boolean saved = false;
	String url = "";
	int messageTo=0;
	int messageFrom=0;
	String msgTxt = "";
	String message = null;
	String lastChangedTime="";
	Date changedDate= new Date();
	session = request.getSession();
	int empId=0;
	Users users =new  Users();
	MasEmployee masEmployee=new MasEmployee();
	if(session.getAttribute("users")!=null){
		users=(Users)session.getAttribute("users");
		empId = users.getEmployee().getId();
		masEmployee= users.getEmployee();
		msgMap.put("empId", empId);
	}
	String[] toEmpIdArray = null;
	if(request.getParameterValues("toEmployee")!=null){
		int toEmpId=0;
		toEmpId=Integer.parseInt(request.getParameter("toEmployee"));
		toEmpIdArray = (String[]) (request.getParameterValues("toEmployee"));
		//masEmployeeTo.setId(toEmpId);
	}
	if(request.getParameter("MessageText")!=null || request.getParameter("MessageText")!=""){
		msgTxt=request.getParameter("MessageText");
	}

	// Code for selected checkBox when checkbox is true on behalf of checkBox Id
	boolean checkedAllFlag=false;
	String chk="";
	chk=request.getParameter("selectedChrage");

	if(chk==null){
		checkedAllFlag=false;
	}else{
		checkedAllFlag=true;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");
	if(checkedAllFlag){
		Map<String, Object> msgMapTemp = new HashMap<String, Object>();
		msgMapTemp.put("empId", empId);
		msgMapTemp = hesHandlerService.showCommunicationJsp(msgMapTemp);
		List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
		if (msgMapTemp.get("masEmployeeList") != null) {
			masEmployeeList = (List<MasEmployee>) msgMapTemp.get("masEmployeeList");
		}
		if (masEmployeeList.size() > 0) {
			for (MasEmployee masEmployeeTo : masEmployeeList) {
				CommunicationMessages commMsg = new CommunicationMessages();
				commMsg.setFromEmployee(masEmployee);
				commMsg.setToEmployee(masEmployeeTo);
				commMsg.setMessageText(msgTxt);
				commMsg.setStatus("y");
				commMsg.setLastChgBy(userName);
				commMsg.setMessageDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				commMsg.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
				commMsg.setLastChgTime(currentTime);
				commMsgList.add(commMsg);
			}
		}
	}else if(toEmpIdArray.length>0){
		for (int i = 0; i < toEmpIdArray.length; i++) {
			CommunicationMessages commMsg = new CommunicationMessages();
			int empIdFormJsp =Integer.parseInt(toEmpIdArray[i]);
			MasEmployee masEmployeeTo=new MasEmployee();
			masEmployeeTo.setId(empIdFormJsp);
			commMsg.setFromEmployee(masEmployee);
			commMsg.setToEmployee(masEmployeeTo);
			commMsg.setMessageText(msgTxt);
			commMsg.setStatus("y");
			commMsg.setLastChgBy(userName);
			commMsg.setMessageDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			commMsg.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(currentDate));
			commMsg.setLastChgTime(currentTime);
			commMsgList.add(commMsg);
		}
	}
	msgMap.put("checkedAllFlag", checkedAllFlag);
	msgMap.put("toEmpIdArray",toEmpIdArray);
	msgMap.put("commMsgList",commMsgList);
	map = hesHandlerService.submitCommunicationMessageJsp(msgMap);
	if (saved){
		message = "Message Send Successfully !!";
	}else{
		message = "Message Send Successfully !! !!";
	}
	jsp = "communicationMessage";
	//jsp += ".jsp";
	title = "Message Send/Receive";
	map.put("masEmployee", masEmployee);
	map.put("empId",empId);
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView showEquipmentBreakdownUpdateJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int radio_str=0;
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("parent") != null){
		radio_str = Integer.parseInt(request.getParameter("parent"));
	}
	map.put("radio_str",radio_str);
	map.put("deptId", deptId);
	map = hesHandlerService.showEquipmentBreakdownUpdateJsp(map);
	jsp = "hesEquipmentBreakdownUpdate";
	jsp += ".jsp";
	title = "Equipment Breakdown Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView showEquipmentCallLogUpdateJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int radio_str=0;
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("parent") != null){
		radio_str = Integer.parseInt(request.getParameter("parent"));
	}
	map.put("radio_str",radio_str);
	map.put("deptId", deptId);
	map = hesHandlerService.showEquipmentCallLogUpdateJsp(map);
	jsp = "hesEquipmentCallLogUpdate";
	jsp += ".jsp";
	title = "Equipment Call Log Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView showEquipmentMaintenanceUpdateJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int radio_str=0;
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("parent") != null){
		radio_str = Integer.parseInt(request.getParameter("parent"));
	}
	map.put("radio_str",radio_str);
	map.put("deptId", deptId);
	map = hesHandlerService.showEquipmentMaintenanceUpdateJsp(map);
	jsp = "hesEquipmentMaintenanceUpdate";
	jsp += ".jsp";
	title = "Equipment Maintenance Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

/*public ModelAndView showEquipmentMasterModify(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int radio_str=0;
	session=request.getSession();
	if(request.getParameter("parent") != null){
		radio_str = Integer.parseInt(request.getParameter("parent"));
	}
	map.put("radio_str",radio_str);
	map = hesHandlerService.showEquipmentMasterModify(map);
	jsp = "hesEquipmentMasterModify";
	jsp += ".jsp";
	title = "Equipment Entry Master";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}*/



public ModelAndView showEquipmentAmcDetails(HttpServletRequest request,
		HttpServletResponse response) {
	int deptId = 0;
	int hospitalId=0;
	session=request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
	}
	map.put("deptId", deptId);
	dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.showEquipmentAmcDetails(dataMap);
	jsp = "hesEquipmentAmcDetailsEntry";
	jsp += ".jsp";
	title = "Equipment AMC Details Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView showEquipmentMasterModify(HttpServletRequest request, HttpServletResponse response){
	Map<String,Object> dataMap = new HashMap<String,Object>();
	int radioId=0;
	
	if(request.getParameter("parent") != null){
		radioId = Integer.parseInt(request.getParameter("parent"));
	}
	map.put("radioId",radioId);
	map = hesHandlerService.showEquipmentMasterModify(dataMap);
	jsp = "hesEquipmentModify";
	jsp += ".jsp";
	title = "Equipment Entry Master";
	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView submitEquipmentAMCDetalis(HttpServletRequest request, HttpServletResponse response)
{
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	boolean saved = false;
	int deptId = 0;
	int hospitalId=0;
	int userId=0;
	String url = "";
	int amcCompanyID = 0;
	int equipmentId = 0;
	String serialNo="";
	String amcDateFrom = "";
	String amcDateTo = "";
	Float costOfAmc = new Float(0.0);
	String advBillNo="";
	String advBillDate="";
	Float advBillAmt = new Float(0.0);
	String balBillNo="";
	String balBillDate="";
	Float balBillAmt = new Float(0.0);
	String remarks="";
	Date date1 = new Date();
	Date date2 = new Date();
	Date date3 = new Date();
	Date date4 = new Date();
	String message = null;
	String lastChangedTime="";
    Date changedDate= new Date();
	session = request.getSession();
	
	if (request.getParameter("deptId") != null ) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
	}
	if(request.getParameter("serialNo")!=null || request.getParameter("serialNo")!=""){
		serialNo=request.getParameter("serialNo");
	}
	if(request.getParameter("equipmentId")!=null || request.getParameter("equipmentId")!=""){
		equipmentId=Integer.parseInt(""+request.getParameter("equipmentId"));
	}
	if(request.getParameter(RequestConstants.ON_DATE)!=null || request.getParameter(RequestConstants.ON_DATE)!=""){
		amcDateFrom=(String)request.getParameter(RequestConstants.ON_DATE) ;
		date1=HMSUtil.convertStringTypeDateToDateType(amcDateFrom);
	}
	if(request.getParameter(RequestConstants.AMC_END_DATE)!=null || request.getParameter(RequestConstants.AMC_END_DATE)!=""){
		amcDateTo=(String)request.getParameter(RequestConstants.AMC_END_DATE) ;
		date2=HMSUtil.convertStringTypeDateToDateType(amcDateTo);
	}
	if(request.getParameter("costOfAmc")!=null || request.getParameter("costOfAmc")!=""){
		costOfAmc=new Float(request.getParameter("costOfAmc")); 
	}
	if(request.getParameter("advBillNo")!=null){
		advBillNo=request.getParameter("advBillNo");
	}
	if(request.getParameter(RequestConstants.ADVANCE_BILL_DATE)!=null || request.getParameter(RequestConstants.ADVANCE_BILL_DATE)!=""){
		advBillDate=(String)request.getParameter(RequestConstants.ADVANCE_BILL_DATE) ;
		date3=HMSUtil.convertStringTypeDateToDateType(advBillDate);
	}
	if(request.getParameter("advBillAmt")!=null){
		advBillAmt =new Float(request.getParameter("advBillAmt"));
	}
	if(request.getParameter("balBillNo")!=null){
		balBillNo = request.getParameter("balBillNo");
	}
	if(request.getParameter(RequestConstants.BALANCE_BILL_DATE)!=null || request.getParameter(RequestConstants.BAL_BILL_DATE)!=""){
		balBillDate=request.getParameter(RequestConstants.BAL_BILL_DATE);
		date4 = HMSUtil.convertStringTypeDateToDateType(balBillDate);
	}
	if(request.getParameter("balBillAmt")!=null || request.getParameter("balBillAmt")!=""){
		balBillAmt= new Float(request.getParameter("balBillAmt"));
	}
	if(request.getParameter("remarks")!=null){
		remarks = request.getParameter("remarks");
	}
	if(request.getParameter("companyId")!=null){
		amcCompanyID = Integer.parseInt(""+request.getParameter("companyId"));
	}
	if (session.getAttribute("userName") != null){
     	userName = (String) session.getAttribute("userName");
     }
	if(session.getAttribute(HOSPITAL_ID)!=null)
	{
	    hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
	}
	if(session.getAttribute(RequestConstants.USER_ID)!=null)
	{
		userId=(Integer) session.getAttribute(RequestConstants.USER_ID);
	}
    if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
     	    changedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
    if(request.getParameter("lastChgTime")!=null || request.getParameter("lastChgTime")!=""){
			lastChangedTime=request.getParameter("lastChgTime");
	   }
     HesEquipmentAmcDetailsEntry amcDetailMaster = new HesEquipmentAmcDetailsEntry();
    // MasStoreSupplier supplierObj = new MasStoreSupplier();
    // supplierObj.setId(amcCompanyID);
     MasStoreSupplierGroup mStoreSupplierGroup = new MasStoreSupplierGroup();
     mStoreSupplierGroup.setId(amcCompanyID);
     amcDetailMaster.setSupplierGroup(mStoreSupplierGroup);
     
     MasDepartment deptMaster = new MasDepartment();
     deptMaster.setId(deptId);
     amcDetailMaster.setDepartment(deptMaster);
     
     HesEquipmentMaster equipmentMaster = new HesEquipmentMaster();
     equipmentMaster.setId(equipmentId);
     amcDetailMaster.setEpuipment(equipmentMaster);
      
    /* HesEquipmentMaster equpSerial = new HesEquipmentMaster();
     equpSerial.setSerialNo(serialNo);
     amcDetailMaster.setEpuipment(equpSerial);*/
     amcDetailMaster.setSerialNo(serialNo);
     amcDetailMaster.setAmcWarrentyStartDate(date1);
     amcDetailMaster.setAmcWarrentyEndDate(date2);
     
   //commented for maven
    /* amcDetailMaster.setCostOfAmc(costOfAmc);*/
     amcDetailMaster.setAdvBillNo(advBillNo);
     amcDetailMaster.setAdvBillDate(date3);
   //commented for maven
    /* amcDetailMaster.setAdvBillAmount(advBillAmt);*/
     amcDetailMaster.setBalanceBillNo(balBillNo);
     amcDetailMaster.setBalanceBillDate(date4);
   //commented for maven
     /*amcDetailMaster.setBalanceBillAmount(balBillAmt);*/
     amcDetailMaster.setRemarks(remarks);
     MasHospital masHospital =new MasHospital();
     masHospital.setId(hospitalId);
     amcDetailMaster.setHospital(masHospital);
     Users users=new Users();
     users.setId(userId);
     amcDetailMaster.setLastChgBy(users);
     amcDetailMaster.setLastChgDate(changedDate);
     amcDetailMaster.setLastChgTime(lastChangedTime);
     amcDetailMaster.setStatus("y");
     dataMap.put("amcDetailMaster", amcDetailMaster);
     dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.submitEquipmentAMCDetalis(dataMap);
	map = hesHandlerService.showEquipmentAmcDetails(dataMap);
	if (saved){
		message = "Failed !!";
	}else{
		message = "Record Added Successfully !!";
	}
	jsp = "hesEquipmentAmcDetailsEntry";
	jsp += ".jsp";
	title = "Equipment AMC Details Entry";
	map.put("contentJsp", jsp);
	map.put("title", title);
	map.put("message", message);
	return new ModelAndView("index", "map", map);
}


public ModelAndView getEquipmentAMCDetails(HttpServletRequest request,
		HttpServletResponse response) {
	
	session=request.getSession();
	int hospitalId=0;
	int equipmentId=0;
	Map<String, Object> dataMap = new HashMap<String, Object>();
	if (request.getParameter("equipmentId") != null) {
		equipmentId =Integer.parseInt(request.getParameter("equipmentId"));
	}
	if(session.getAttribute(RequestConstants.HOSPITAL_ID )!=null){
		hospitalId=(Integer)session.getAttribute(RequestConstants.HOSPITAL_ID);
	}
		
	dataMap.put("equipmentId", equipmentId);
	dataMap.put("hospitalId", hospitalId);
	map = hesHandlerService.getEquipmentAMCDetails(dataMap);
	jsp = "responseEquipmentAMCJsp";
	return new ModelAndView(jsp, "map", map);
}

////////////////////////////////////////////END/////////////////////////////////////////
	
}
