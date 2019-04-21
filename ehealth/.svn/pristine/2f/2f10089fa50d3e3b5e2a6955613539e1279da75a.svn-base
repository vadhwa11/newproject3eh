/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.

 * Use is subject to license terms.
 * Class PurchaseOrderController.java 
 * Tables Used: store_po_detail, store_po_header
 * Purpose of the class - For Local Purchase (LP) of PVMS and NIV Items
 * @author  Deepti Tevatia
 * Create Date: 4th Feb,2008
 * Revision Date:      		Revision By:
 * @version 1.0
 * @see PurchaseOrderHandlerService.java, PurchaseOrderHandlerServiceImpl.java, PurchaseOrderDataService.java, PurchaseOrderDataServiceImpl.java
 **/
package jkt.hms.pubHealth.controller;

import static jkt.hms.util.RequestConstants.TABLET_DETAILS_REPORT;
import static jkt.hms.util.RequestConstants.BATCH_ID;
import static jkt.hms.util.RequestConstants.COMMON_ID;

import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.DISTRICT_ID;
import static jkt.hms.util.RequestConstants.HMIS_PARAMETER_MAPPING_RESPONSE_FOR_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.HMIS_PARAMETER_MAPPING_RESPONSE_FOR_ITEMS_AUTOCOMPLETE_JSP;
import static jkt.hms.util.RequestConstants.DISEASES_ICD_MAPPING_RESPONSE_FOR_ITEMS_AUTOCOMPLETE_JSP;
import static jkt.hms.util.RequestConstants.DISEASES_ICD_MAPPING_RESPONSE_FOR_ITEMS_JSP;

import static jkt.hms.util.RequestConstants.FROM_DATE;

import static jkt.hms.util.RequestConstants.ICD_INVESTIGATION_MAPPING_RESPONSE_FOR_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.IDSP_HOSPITAL_REPORT_FORML_RESPONSE_FOR_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.IDSP_HOSPITAL_REPORT_RESPONSE_FOR_ITEMS_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_NAME;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import jxl.Cell;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.AshaWorker;
import jkt.hms.masters.business.IdspHospitalReport;
import jkt.hms.masters.business.IdspHospitalReportForml;
import jkt.hms.masters.business.LocationParameterMapping;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasVillage;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MmMasRequestStatus;
import jkt.hms.masters.business.PhAtpJphnJhiDetails;
import jkt.hms.masters.business.PhDayBlock;
import jkt.hms.masters.business.PhDayBlockDetail;
import jkt.hms.masters.business.PhHouseSurvey;
import jkt.hms.masters.business.PhMasElectricalSection;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasParliyamentAssembly;
import jkt.hms.masters.business.PhSyndromicSurvcillenceMapping;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.StoreSetup;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.pubHealth.handler.PubHealthHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.security.masters.handler.UserMasterHandlerService;
import jxl.CellView;
import jxl.DateCell;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Border;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PubHealthController extends MultiActionController {
	PubHealthHandlerService pubHealthHandlerService = null;
	OPDHandlerService opdHandlerService = null;

	public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	public PubHealthHandlerService getPubHealthHandlerService() {
		return pubHealthHandlerService;
	}

	public void setPubHealthHandlerService(
			PubHealthHandlerService pubHealthHandlerService) {
		this.pubHealthHandlerService = pubHealthHandlerService;
	}

	CommonMasterHandlerService commonMasterHandlerService = null;

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	UserMasterHandlerService userMasterHandlerService = null;

	public UserMasterHandlerService getUserMasterHandlerService() {
		return userMasterHandlerService;
	}

	public void setUserMasterHandlerService(UserMasterHandlerService userMasterHandlerService) {
		this.userMasterHandlerService = userMasterHandlerService;
	}

	String jsp = "";
	String title = "";

	public ModelAndView showDayBlockAllocationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = pubHealthHandlerService.showDayBlockAllocationJsp(hospitalId);
		jsp = "dayBlockAllocation";
		jsp += ".jsp";
		title = "Day Block Allocation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView fillLoc(HttpServletRequest request,
			HttpServletResponse response) {
		String Val = request.getParameter("Val");
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int empId = (Integer) session.getAttribute("empId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		detailsMap.put("empId", empId);
		detailsMap.put("hospitalId", hospitalId);
		detailsMap.put("day", Integer.parseInt(request.getParameter("day")));
		map = pubHealthHandlerService.fillLoc(Val, detailsMap);
		jsp = "responseHouse";
		title = "House Survery";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView fillWard(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		detailsMap.put("hospitalId", hospitalId);
		map = pubHealthHandlerService.getWard(detailsMap);
		jsp = "resLocalityDayBlock";
		title = "Ward List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveDayBlockAllocation(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String flag = "";

		int userId = (Integer) session.getAttribute(USER_ID);
		int empId = (Integer) session.getAttribute("empId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		int day = 0;
		if (request.getParameter("day") != null
				&& !request.getParameter("day").equals("0")) {
			day = Integer.parseInt(request.getParameter("day"));
		}
		if (request.getParameter("flag") != null
				&& !request.getParameter("flag").equals("0")) {
			flag = request.getParameter("flag");
		}

		String[] house = {};
		if (request.getParameter("tempId") != null) {
			house = (String[]) request.getParameterValues("tempId");
		}

		String houseStr = "";
		if (house.length != 0) {
			houseStr = house[0];
		}
		for (int i = 1; i < house.length; i++) {
			houseStr = houseStr + "," + house[i];
		}
		detailsMap.put("houseStr", houseStr);
		detailsMap.put("house", house);
		detailsMap.put("day", day);
		detailsMap.put("empId", empId);
		detailsMap.put("userId", userId);
		detailsMap.put("hospitalId", hospitalId);
		detailsMap.put("flag", flag);
		map = pubHealthHandlerService.saveDayBlockAllocation(detailsMap);

		Boolean saved = (Boolean) map.get("saved");
		String message = "";
		String jsp = "";
		if (saved) {
			if (flag.equalsIgnoreCase("s")) {
				message = "Day Block Allocation Saved Successfully.";
			} else {
				message = "Day Block Allocation Updated Successfully.";
			}

		} else {
			message = "Some Problem Occured.";
		}
		jsp = "messageDayBlockAllocation";
		map.put("message", message);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAdvanceTourPlanJPHNAndJHIJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = pubHealthHandlerService
				.showAdvanceTourPlanJPHNAndJHIJsp(hospitalId);
		jsp = "advanceTourPlanJPHNAndJHI";
		jsp += ".jsp";
		title = "Advance Tour Plan JPHN And JHI";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getDayBlockId(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int day = 0;
		int ward = 0;
		// int userId = (Integer) session.getAttribute(USER_ID);
		int empId = (Integer) session.getAttribute("empId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		try {
			if (request.getParameter("day") != null
					&& !(request.getParameter("day").equals(""))) {
				day = Integer.parseInt(request.getParameter("day"));
				detailsMap.put("day", day);
			}
			if (request.getParameter("ward") != null
					&& !(request.getParameter("ward").equals("0"))) {
				ward = Integer.parseInt(request.getParameter("ward"));
				detailsMap.put("ward", ward);
			}
			if (empId != 0) {
				detailsMap.put("empId", empId);
			}

			detailsMap.put("hospitalId", hospitalId);

			patientMap = pubHealthHandlerService.getDayBlockId(detailsMap);

			List<PhDayBlock> pList = new ArrayList<PhDayBlock>();
			if (patientMap.get("pList") != null) {
				pList = (List<PhDayBlock>) patientMap.get("pList");
			}
			List<PhMasLocality> phMasLocalityList = new ArrayList<PhMasLocality>();

			List<PhHouseSurvey> phHouseSurveyList = new ArrayList<PhHouseSurvey>();
			if (patientMap.get("phMasLocalityList") != null) {
				phMasLocalityList = (List<PhMasLocality>) patientMap
						.get("phMasLocalityList");
			}

			if (patientMap.get("phHouseSurveyList") != null) {
				phHouseSurveyList = (List<PhHouseSurvey>) patientMap
						.get("phHouseSurveyList");
			}
			List<PhDayBlockDetail> pdList = new ArrayList<PhDayBlockDetail>();
			if (patientMap.get("pdList") != null) {
				pdList = (List<PhDayBlockDetail>) patientMap.get("pdList");
			}

			map.put("phHouseSurveyList", phHouseSurveyList);
			map.put("phMasLocalityList", phMasLocalityList);
			map.put("phDayBlockList", pList);

			map.put("phDayBlockDetailList", pdList);

			System.out.println(phMasLocalityList.size() + "in Java controller");
			System.out.println(pdList.size());

			jsp = "getDayBlock";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showAtpJphnJhiJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int empId = (Integer) session.getAttribute("empId");
		detailMap.put("empId", empId);
		detailMap.put("hospitalId", hospitalId);
		map = pubHealthHandlerService.showAtpJphnJhiJsp(detailMap);
		jsp = "ph_atpJphnJhi";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * public ModelAndView submitAtpJphnJhi(HttpServletRequest request,
	 * HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); HttpSession session = request.getSession();
	 * Box box = HMSUtil.getBox(request);
	 * 
	 * if (session.getAttribute("empId") != null) { int empId = (Integer)
	 * session.getAttribute("empId"); box.put("empId", empId); }
	 * 
	 * if (session.getAttribute("hospitalId") != null) { int hospitalId =
	 * (Integer) session.getAttribute("hospitalId"); box.put("hospitalId",
	 * hospitalId); } if (session.getAttribute("users") != null) { Users users =
	 * (Users) session.getAttribute("users"); int changedBy = users.getId();
	 * box.put("changedBy", changedBy); } map =
	 * pubHealthHandlerService.submitAtpJphnJhi(box); boolean saved = false;
	 * String message = ""; if (map.get("saved") != null) { saved = (Boolean)
	 * map.get("saved"); } if (saved) { message =
	 * "ATP JPHN JHI  Saved Successfully."; } else { message = "Try Again!"; }
	 * map.put("message", message);
	 * 
	 * String url = "/erp/erp/pubHealth?method=showAtpJphnJhiJsp";
	 * map.put("url", url); String jsp = "ph_msgForAtpJphnJhi" + ".jsp";
	 * map.put("contentJsp", jsp); return new ModelAndView("index", "map", map);
	 * }
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitAtpJphnJhi(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("empId") != null) {
			int empId = (Integer) session.getAttribute("empId");
			box.put("empId", empId);
		}

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		Map<String, Object> patientMap = new HashMap<String, Object>();
		try {
			patientMap = pubHealthHandlerService.submitAtpJphnJhi(box);
			List<PhAtpJphnJhiDetails> phAtpJphnJhiDetailsList = new ArrayList<PhAtpJphnJhiDetails>();
			if (patientMap.get("phAtpJphnJhiDetailsList") != null) {
				phAtpJphnJhiDetailsList = (List<PhAtpJphnJhiDetails>) patientMap
						.get("phAtpJphnJhiDetailsList");
			}
			List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
			if (patientMap.get("phDayBlockList") != null) {
				phDayBlockList = (List<PhDayBlock>) patientMap
						.get("phDayBlockList");
			}
			map.put("phDayBlockList", phDayBlockList);
			map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "ATP JPHN JHI  Saved Successfully.";
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			String url = "/erp/erp/pubHealth?method=showAtpJphnJhiJsp";
			map.put("url", url);
			jsp = "responseListAtpJphnJhi";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showAtpJphnJhiApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = pubHealthHandlerService.showAtpJphnJhiApprovalJsp(hospitalId);

		String jsp = "ph_atpJphnJhi_approval" + ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getAtpJphnJhiDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int atpHeaderId = 0;
		// int userId = (Integer) session.getAttribute(USER_ID);
		int empId = (Integer) session.getAttribute("empId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		try {
			if (request.getParameter("atpHeaderId") != null
					&& !(request.getParameter("atpHeaderId").equals(""))) {
				atpHeaderId = Integer.parseInt(request
						.getParameter("atpHeaderId"));
				detailsMap.put("atpHeaderId", atpHeaderId);
			}
			if (empId != 0) {
				detailsMap.put("empId", empId);
			}

			detailsMap.put("hospitalId", hospitalId);

			patientMap = pubHealthHandlerService
					.getAtpJphnJhiDetail(detailsMap);

			List<PhAtpJphnJhiDetails> phAtpJphnJhiDetailsObjList = new ArrayList<PhAtpJphnJhiDetails>();
			if (patientMap.get("phAtpJphnJhiDetailsObjList") != null) {
				phAtpJphnJhiDetailsObjList = (List<PhAtpJphnJhiDetails>) patientMap
						.get("phAtpJphnJhiDetailsObjList");
			}
			List<PhDayBlock> phDayBlockList = new ArrayList<PhDayBlock>();
			if (patientMap.get("phDayBlockList") != null) {
				phDayBlockList = (List<PhDayBlock>) patientMap
						.get("phDayBlockList");
			}
			List<MmMasRequestStatus> mmMasRequestStatusList = new ArrayList<MmMasRequestStatus>();
			if (patientMap.get("mmMasRequestStatusList") != null) {
				mmMasRequestStatusList = (List<MmMasRequestStatus>) patientMap
						.get("mmMasRequestStatusList");
			}
			List<Object[]> phAtpJphnJhiDetailsList = new ArrayList<Object[]>();
			if (patientMap.get("phAtpJphnJhiDetailsList") != null) {
				phAtpJphnJhiDetailsList = (List<Object[]>) patientMap
						.get("phAtpJphnJhiDetailsList");
			}
			map.put("phAtpJphnJhiDetailsObjList", phAtpJphnJhiDetailsObjList);
			map.put("phDayBlockList", phDayBlockList);
			map.put("mmMasRequestStatusList", mmMasRequestStatusList);

			map.put("phAtpJphnJhiDetailsList", phAtpJphnJhiDetailsList);

			jsp = "responseAtpJphnJhi";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView submitAtpJphnJhiApproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("empId") != null) {
			int empId = (Integer) session.getAttribute("empId");
			box.put("empId", empId);
		}

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = pubHealthHandlerService.submitAtpJphnJhiApproval(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "ATP JPHN JHI  Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String url = "/erp/erp/pubHealth?method=showAtpJphnJhiJsp";
		map.put("url", url);
		String jsp = "ph_msgForAtpJphnJhi" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showSchoolAnganwadiRegistrationJsp(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.showSchoolAnganwadiRegistrationJsp(box);
		jsp = "ph_schoolAnganwadi";
		jsp += ".jsp";
		title = "School Registration";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView submitSchoolAnganwadiRegistration(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}

		String facilitiesAvailables = "";
		String[] facilitiesAvailableArray = null;
		if (request.getParameterValues("facilitiesAvailable") != null) {
			facilitiesAvailableArray = (String[]) request
					.getParameterValues("facilitiesAvailable");
			for (int x = 0; x < facilitiesAvailableArray.length; x++) {
				if (x == 0) {
					facilitiesAvailables = facilitiesAvailableArray[x];
				} else {
					facilitiesAvailables = facilitiesAvailables + ","
							+ facilitiesAvailableArray[x];
				}
			}
			box.put("facilitiesAvailables", facilitiesAvailables);
			System.out.println(facilitiesAvailables
					+ "facilitiesAvailablefacilitiesAvailable");
		}

		map = pubHealthHandlerService.submitSchoolAnganwadiRegistration(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Record  Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String url = "/erp/erp/pubHealth?method=submitSchoolAnganwadiRegistration";
		map.put("url", url);
		String jsp = "ph_msgForSchoolAnganwadi" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getNameList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		 int localityId = 0;
		int schoolTypeVal = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			if (request.getParameter("localityId") != null) { 
				localityId = Integer.parseInt(request.getParameter("localityId")); 
			}
			 
			long hospitalId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Long.parseLong(session.getAttribute("hospitalId")
						.toString());
				dataMap.put("hospitalId", hospitalId);
			}
			System.out.println("hospitalId==" + hospitalId);
			if (request.getParameter("schoolTypeVal") != null) {
				schoolTypeVal = Integer.parseInt(request
						.getParameter("schoolTypeVal"));
			}
			dataMap.put("localityId", localityId);
			dataMap.put("schoolTypeVal", schoolTypeVal);
			map = pubHealthHandlerService.getNameList(dataMap);
			jsp = "responseName";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getPHC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = request.getSession();
		int phc = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
		
		
			if (request.getParameter("phc") != null) {
				phc = Integer.parseInt(request
						.getParameter("phc"));
			}
		
			dataMap.put("phc", phc);
			map = pubHealthHandlerService.getPHC(dataMap);
			jsp = "responsePHC";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getNameAnganvadi(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int localityId = 0;
		int schoolTypeVal = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			if (request.getParameter("localityId") != null) { 
				localityId = Integer.parseInt(request.getParameter("localityId")); }
			 
			long hospitalId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Long.parseLong(session.getAttribute("hospitalId")
						.toString());
				dataMap.put("hospitalId", hospitalId);
			}
			if (request.getParameter("schoolTypeVal") != null) {
				schoolTypeVal = Integer.parseInt(request
						.getParameter("schoolTypeVal"));
			}
			dataMap.put("localityId", localityId);
			dataMap.put("schoolTypeVal", schoolTypeVal);
			map = pubHealthHandlerService.getNameList(dataMap);
			jsp = "responseAngan";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getNameDetailList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int localityIdMap = 0;
		int schoolTypeMap = 0;
		int villageSurveyId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("localityIdMap") != null
					&& !request.getParameter("localityIdMap").equals("0")) {
				localityIdMap = Integer.parseInt(request
						.getParameter("localityIdMap"));
			}
			if (request.getParameter("schoolTypeMap") != null
					&& !request.getParameter("schoolTypeMap").equals("0")) {
				schoolTypeMap = Integer.parseInt(request
						.getParameter("schoolTypeMap"));
			}
			if (request.getParameter("villageSurveyId") != null
					&& !request.getParameter("villageSurveyId").equals("0")) {
				villageSurveyId = Integer.parseInt(request
						.getParameter("villageSurveyId"));
			}
			System.out.println(schoolTypeMap + "schoolTypeMapschoolTypeMap");
			dataMap.put("localityIdMap", localityIdMap);
			dataMap.put("schoolTypeMap", schoolTypeMap);
			dataMap.put("villageSurveyId", villageSurveyId);
			map = pubHealthHandlerService.getNameDetailList(dataMap);
			System.out.println(schoolTypeMap);
			if (schoolTypeMap == 1002) {
				jsp = "responseSchoolName";
			}
			if (schoolTypeMap == 1001) {
				jsp = "responseAnganwadiName";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showStudentRegistrationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		try {
			long hospitalId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Long.parseLong(session.getAttribute("hospitalId")
						.toString());
				box.put("hospitalId", hospitalId);
			}
			map = pubHealthHandlerService.showStudentRegistrationJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		jsp = "ph_studentRegistration";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getMemberSurveyList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Long uhid = new Long(0);
		String studentName = "";
		int genderIdSearch = 0;
		int age=0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("studentName") != null) {
				studentName = request.getParameter("studentName");
			}

			if (request.getParameter("genderIdSearch") != null
					&& !request.getParameter("genderIdSearch").equals("0")) {
				genderIdSearch = Integer.parseInt(request
						.getParameter("genderIdSearch"));
			}
			
			if (request.getParameter("ageSearch") != null && !request.getParameter("ageSearch").equals("0")) {
				age = Integer.parseInt(request.getParameter("ageSearch"));
			}
			
			if (request.getParameter("uhid") != null
					&& !request.getParameter("uhid").equals("")) {
				uhid = Long.parseLong(request.getParameter("uhid"));
			}
			
			dataMap.put("uhid", uhid);
			dataMap.put("genderIdSearch", genderIdSearch);
			dataMap.put("studentName", studentName);
			dataMap.put("age", age);

			map = pubHealthHandlerService.getMemberSurveyList(dataMap);
			jsp = "responseMemberSurvey";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getValueMemberSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int memberSurveyId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			long hospitalId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Long.parseLong(session.getAttribute("hospitalId")
						.toString());
				dataMap.put("hospitalId", hospitalId);
			}
			if (request.getParameter("memberSurveyId") != null) {
				memberSurveyId = Integer.parseInt(request
						.getParameter("memberSurveyId"));
			}

			dataMap.put("memberSurveyId", memberSurveyId);

			map = pubHealthHandlerService.getValueMemberSurvey(dataMap);
			jsp = "responseMemberSurveyValue";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSchoolNameList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int surveyId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("surveysId") != null) {
				surveyId = Integer.parseInt(request.getParameter("surveysId"));
			}

			dataMap.put("surveyId", surveyId);
			map = pubHealthHandlerService.getAnganwadiNameList(dataMap);
			jsp = "responseClassSection";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAnganwadiNameList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int surveyId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("surveyId") != null) {
				surveyId = Integer.parseInt(request.getParameter("surveyId"));
			}

			dataMap.put("surveyId", surveyId);
			map = pubHealthHandlerService.getAnganwadiNameList(dataMap);
			jsp = "responseClassDivision";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView populateSection(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String classId = "";
		int surveyIdMap = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("classId") != null) {
				classId = request.getParameter("classId");
			}
			if (request.getParameter("surveyIdMap") != null) {
				surveyIdMap = Integer.parseInt(request
						.getParameter("surveyIdMap"));
			}

			dataMap.put("classId", classId);
			dataMap.put("surveyIdMap", surveyIdMap);
			System.out.println(surveyIdMap);
			System.out.println(classId);
			map = pubHealthHandlerService.populateSection(dataMap);
			jsp = "responseSections";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView populateDivision(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String classId = "";
		int surveyIdMap = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("classId") != null) {
				classId = request.getParameter("classId");
			}
			if (request.getParameter("surveyIdMap") != null) {
				surveyIdMap = Integer.parseInt(request
						.getParameter("surveyIdMap"));
			}

			dataMap.put("classId", classId);
			dataMap.put("surveyIdMap", surveyIdMap);
			System.out.println(surveyIdMap);
			System.out.println(classId);
			map = pubHealthHandlerService.populateSection(dataMap);
			jsp = "responseDivision";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView uploadExcel(HttpServletRequest request,
			HttpServletResponse response) {
		// System.out.println("hello ssssIn controller");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		int studentId = 0;
		String grNo = "";
		/*
		 * if(request.getParameter("studentId")!= null){ studentId =
		 * Integer.parseInt(request.getParameter("studentId")); }
		 * System.out.println("studentId-------->>"+studentId);
		 * if(request.getParameter("grNo")!= null){ grNo
		 * =request.getParameter("grNo"); }
		 */
		/*
		 * System.out.println("grNo-------->>"+grNo); infoMap.put("grNo", grNo);
		 */
		infoMap.put("studentId", studentId);
		map = pubHealthHandlerService.uploadExcel(infoMap);
		String jsp = "uploadExcel";
		map.put("grNo", grNo);
		map.put("studentId", studentId);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("rawtypes")
	public ModelAndView addorUpdateStudentRescord(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String filename = "";

		if (request.getParameter("filename") != null) {
			filename = request.getParameter("filename");
		}
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				// System.out.println("request----->"+request);
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String fileExtension = null;
		// String uploadURL = getServletContext().getRealPath("/photo/");
		//String userHome = getServletContext().getRealPath("");
		//String fileSeparator = System.getProperty("file.separator");
		// String uploadURL =
		// userHome.substring(0,userHome.lastIndexOf(fileSeparator))+fileSeparator+"uploadedImage"+fileSeparator;
	/*	String uploadURL = userHome + fileSeparator + "uploadedImage"
				+ fileSeparator;*/

		String uploadURL = getServletContext().getRealPath("/uploadedImage/");
		int studentId = 0;
	
		List fileUploadedList = null;
		if (request.getParameter("filename") != null) {
			filename = request.getParameter("filename");
		}
		if (mrequest.getParameter("studentId") != null) {
			studentId = Integer.parseInt(mrequest.getParameter("studentId"));
			generalMap.put("studentId", studentId);
		}
	
		System.out.println("filename----->" + filename);
		StringTokenizer strToken = new StringTokenizer(filename, ".");
		//String f = strToken.nextToken();
		fileExtension = strToken.nextToken();

		String whiteList = "*." + fileExtension;
	//	filename = "A" + "." + fileExtension;

		System.out.println("filename--->" + filename);

		generalMap.put("filename", filename);
		/*try {
			File f = new File(uploadURL + "A.xls");
			if (f.exists()) {
				f.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
				whiteList, filename);

		generalMap.put("uploadURL", uploadURL);
		@SuppressWarnings("unused")
		boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}

		infoMap.put("filename", filename);
		infoMap.put("uploadURL", uploadURL);
		map = pubHealthHandlerService.addorUpdateStudentRescord(infoMap);
		String jsp = "uploadExcel";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitStudentRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}

		map = pubHealthHandlerService.submitStudentRegistration(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Record  Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String url = "/erp/erp/pubHealth?method=submitStudentRegistration";
		map.put("url", url);
		String jsp = "ph_msgForStudentRegistration" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------code by anamika-----------------------
	//------------------------Changed by arbind on 09-01-2017
	public ModelAndView showImmunizationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int tokeNo=0;
		String patientName;
		String uhid;
		int hospitalId = 0, deptId = 0;

		if(request.getParameter("tokenNo")!=null && !request.getParameter("tokenNo").equals("") ){
			tokeNo = Integer.parseInt(request.getParameter("tokenNo"));
			box.put("tokenNo",tokeNo);
		}
		if(request.getParameter("patientName")!=null && !request.getParameter("patientName").equals("")){
			patientName = request.getParameter("patientName");
			box.put("patientName", patientName);
		}
		if(request.getParameter("uhid")!=null){
			uhid = request.getParameter("uhid");
			box.put("uhid", uhid);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if(session.getAttribute("deptId")!=null){
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}
		box.put("hospitalId", hospitalId);
		map = pubHealthHandlerService.showImmunizationJsp(box);
		jsp = "immunizationSearch";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchImmunizationDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;

		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		map = pubHealthHandlerService.searchImmunizationDetail(box);
		jsp = "immunizationSearch";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	//-----------------Changed by arbind on 09-01-2017------------
	public ModelAndView showVaccineDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();;
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int visitId=0;
		int inpatientId=0;
		if(request.getParameter("visitId")!=null && !request.getParameter("visitId").equals("")){
			visitId=Integer.parseInt(request.getParameter("visitId"));	
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").equals("")){
			inpatientId=Integer.parseInt(request.getParameter("inpatientId"));	
		}
		box.put("hospitalId", hospitalId);
		box.put("visitId", visitId);
		box.put("inpatientId",inpatientId);
		map = opdHandlerService.showVaccineDetailJsp(box);
		jsp = "vaccineDetail";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	//-----------------Changed by arbind on 10-01-2017------------
	public ModelAndView submitVaccineDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int userId = 0;
		int departmentId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		
		if (session.getAttribute("departmentId") != null) {
			departmentId = Integer.parseInt(""
					+ session.getAttribute("departmentId"));
		}
		
		box.put("hospitalId", hospitalId);
		box.put("departmentId", departmentId);
		box.put("userId", userId);
		map = pubHealthHandlerService.submitVaccineDetail(box);
		if (box.getString("flag").equals("opd")) {
			map = opdHandlerService.showVaccineDetailJsp(box);
			jsp = "opdvaccineDetail";
			return new ModelAndView(jsp, "map", map);
		} else {
			jsp = "vaccineDetail";
			jsp += ".jsp";
			title = "Immunization";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	}

	public ModelAndView showJphnAndJhiMonthlyObservationsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = pubHealthHandlerService
				.showJphnAndJhiMonthlyObservationsJsp(hospitalId);
		jsp = "ph_jphn_jhi";
		jsp += ".jsp";
		title = "Day Block Allocation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitJphniJhi(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}

		map = pubHealthHandlerService.submitJphniJhi(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Record  Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);

		String url = "/erp/erp/pubHealth?method=submitJphniJhi";
		map.put("url", url);
		String jsp = "ph_msgForJphniJhi" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateStudentExcel(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HSSFWorkbook wb = new HSSFWorkbook();
		int schoolId = 0;
		if (request.getParameter("schoolNameId") != null) {
			schoolId = Integer.parseInt(request.getParameter("schoolNameId"));
		}
		HttpSession session = null;
		session = request.getSession();
		int hospitalId=0;
		String hospitalName = "";
		hospitalId= (Integer) session.getAttribute("hospitalId");
		
			hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
			infoMap.put("hospitalName", hospitalName);
		
		System.out.println(schoolId + "schoolId");
		infoMap.put("schoolId", schoolId);
		try {
			map = pubHealthHandlerService.generateStudentExcel(infoMap);
			if (map.get("wb") != null) {
				wb = (HSSFWorkbook) map.get("wb");
				String file = "student.xls";
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-disposition",
						"attachment; filename=" + file);
				wb.write(response.getOutputStream());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();

		}
		return null;
	}

	public ModelAndView getMonths(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String monthValue = "";
		String fromDate = "";
		String toDate = "";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			/*if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}*/
			if (request.getParameter("atpJphniJhiMonths") != null) {
				monthValue = request.getParameter("atpJphniJhiMonths");
			}
			if (request.getParameter("fromDate") != "" && request.getParameter("toDate") != "") {
				fromDate = (request.getParameter("fromDate"));
				toDate = (request.getParameter("toDate"));
			}

			dataMap.put("monthValue", monthValue);
			dataMap.put("fromDate", fromDate);
			dataMap.put("toDate", toDate);
			map = pubHealthHandlerService.getMonths(dataMap);
			jsp = "responseMonths";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showPhMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int userId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		int hospitalTypeId=0;
		if (session.getAttribute("hospitalTypeId") != null) {
			hospitalTypeId = Integer.parseInt("" + session.getAttribute("hospitalTypeId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("userId", userId);
		box.put("hospitalTypeId",hospitalTypeId);
		map = pubHealthHandlerService.showPhMappingJsp(box);
		jsp = "phMapping";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getPhcList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		map = pubHealthHandlerService.getPhcList(box);

		jsp = "responseForPhcList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getSubCenterList(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("#####hdhdhdhdhdhdhdhdh");
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getSubCenterList(box);

		jsp = "responseForSubCenterList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getbasicSectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getbasicSectionList(box);

		jsp = "responseForBasicSectionList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getParametersList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession(); //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getParametersList(box);
		jsp = "responseForParametersList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView showAtPhnJhiPrepairAndSubmmitJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int empId = (Integer) session.getAttribute("empId");
		String forMonth = "";
		String fromDate = "";
		String toDate = "";
		if (request.getParameter("atpJphniJhiMonths") != null) {
			forMonth = request.getParameter("atpJphniJhiMonths");
		}
		if (request.getParameter("fromDate") != "" && request.getParameter("toDate") != "") {
			fromDate = (request.getParameter("fromDate"));
			toDate = (request.getParameter("toDate"));
		}

		detailMap.put("empId", empId);
		detailMap.put("hospitalId", hospitalId);
		detailMap.put("forMonth", forMonth);
		detailMap.put("fromDate", fromDate);
		detailMap.put("toDate", toDate);

		map = pubHealthHandlerService
				.showAtPhnJhiPrepairAndSubmmitJsp(detailMap);
		jsp = "ph_atp_ApproveSubmmit";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDtailThroughDate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		System.out.println("ok");
		if (session.getAttribute("empId") != null) {
			int empId = (Integer) session.getAttribute("empId");
			box.put("empId", empId);
			detailMap.put("empId", empId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hsId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hsId", hsId);
		}
		if (request.getParameter("hiddenValueCharge") != null) {
			int count = Integer.parseInt(request
					.getParameter("hiddenValueCharge"));
			box.put("count", count);
		}

		map = pubHealthHandlerService.getDtailThroughDate(box);
		String jsp = "responceJspForJHiHiApprove";

		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addApproveSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		int empId = 0;
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
			box.put("empId", empId);
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		detailMap.put("hospitalId", hospitalId);
		detailMap.put("empId", empId);
		map = pubHealthHandlerService.addApproveSubmit(box);
		Boolean saved = (Boolean) map.get("saved");
		String message = "";
		String jsp = "";
		if (saved) {
			message = "Data Saved";

		} else {
			message = "Some Problem Occured.";
		}
		map = pubHealthHandlerService
				.showAtPhnJhiPrepairAndSubmmitJsp(detailMap);
		jsp = "ph_atp_ApproveSubmmit";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDateWiseDayBlockCompletion(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		System.out.println("ok here");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int empId = (Integer) session.getAttribute("empId");
		detailMap.put("empId", empId);
		detailMap.put("hospitalId", hospitalId);
		// map = pubHealthHandlerService.showDateWiseDayBlockCompletion(box);
		jsp = "dayblockWork";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView datewiseCompletion(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> detailMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		System.out.println("ok here");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.datewiseCompletion(box);
		String jsp = "responceDayBlock";

		title = "Day Block Complete Jsp";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView changeRequest(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = request.getSession();
		//session = request.getSession(true);  //commented by Om Tripathi unused reference
		//Box box = HMSUtil.getBox(request);
		String jsp = "changeRequest";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveDailyWork(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		String tempId[] = request.getParameterValues("tempId");
		for (int i = 0; i < tempId.length; i++) {
			box.put("tempId", tempId[i]);

			if (session.getAttribute("empId") != null) {
				int empId = (Integer) session.getAttribute("empId");
				box.put("empId", empId);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				int hsId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hsId", hsId);
			}
			System.out.println(request.getParameter("mainGroupId1")
					+ "Test--->" + request.getParameter("tempId"));

			map = pubHealthHandlerService.saveDailyWork(box);
		}
		Boolean saved = (Boolean) map.get("saved");
		String message = "";
		String jsp = "";
		if (saved) {
			message = "Data Saved";
		} else {
			message = "Some Problem Occured.";
		}

		map.put("message", message);

		jsp = "saveReaponceWork";
		jsp += ".jsp";
		title = "Atp Jphn Jhi Jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getlocality(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		String flag="";
		if(request.getParameter("flag")!=null){
			flag=request.getParameter("flag");
		}
		map = pubHealthHandlerService.getlocality(box);
		map.put("flag",flag);
		jsp = "responseForlocality";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getTalukList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int district = 0;
		String flag="";
		
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("district") != null) {
				district = Integer.parseInt(request.getParameter("district"));
			}
			if (request.getParameter("flag") != null) {
				flag = (request.getParameter("flag"));
			}
			dataMap.put("district", district);
			map = pubHealthHandlerService.getTalukList(dataMap);
			jsp = "responseforTaluk";
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("flag",flag);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getvilageList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taluk = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("taluk") != null) {
				taluk = Integer.parseInt(request.getParameter("taluk"));
			}
			dataMap.put("taluk", taluk);
			map = pubHealthHandlerService.getvilageList(dataMap);
			jsp = "responceLocalityForvillage";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getWardList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int lsg = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("lsg") != null) {
				lsg = Integer.parseInt(request.getParameter("lsg"));
			}
			dataMap.put("village", lsg);
			map = pubHealthHandlerService.getWardList(dataMap);
			jsp = "responceForWard";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getlocalityList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int ward = 0;
		String basicSectionId = "";
		String subcenterId = "";
		int distr=0;
		int lsgId=0;
		int wardId=0;
		MasDistrict masdistrict=new MasDistrict();
		if (request.getParameterValues("distr") != null
				&& !request.getParameterValues("distr").equals("")) {
			distr = Integer.parseInt(request.getParameter("distr"));
			masdistrict.setId(distr);
		}
		MasLsg maslsg=new MasLsg();
		if (request.getParameterValues("lsg") != null
				&& !request.getParameterValues("lsg").equals("")) {
			lsgId = Integer.parseInt(request.getParameter("lsg"));
			maslsg.setId(lsgId);
		}
		MasWard masward=new MasWard();
		if (request.getParameterValues("ward") != null
				&& !request.getParameterValues("ward").equals("")) {
			wardId = Integer.parseInt(request.getParameter("ward"));
			masward.setId(ward);
		}
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			basicSectionId = request.getParameter("basicSectionId");
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = request.getParameter("subcenterId");
		}
		int taluk=0;
		if (request.getParameter("taluk") != null) {
			taluk = Integer.parseInt(request.getParameter("taluk"));
		}
		
		int villSubcenterId=0;
		if (request.getParameterValues("villSubcenterId") != null
				&& !request.getParameterValues("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
			
		}
		dataMap.put("taluk", taluk);
		dataMap.put("distr", distr);
		dataMap.put("lsgId", lsgId);
		dataMap.put("wardId", wardId);
		dataMap.put("villSubcenterId", villSubcenterId);
		try {

			if (request.getParameter("ward") != null) {
				ward = Integer.parseInt(request.getParameter("ward"));
			}
			dataMap.put("ward", ward);
			dataMap.put("hospitalId", basicSectionId);
			dataMap.put("subcenterId", subcenterId);

			map = pubHealthHandlerService.getlocalityList(dataMap);
			jsp = "responceLocality";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveInlocationParameter(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		//LocationParameterMapping locmaPing = new LocationParameterMapping();
		//Box box = HMSUtil.getBox(request);
		int hsId = 0;
		int local = 0;
		int userId = 0;
		String tempId[] = null;
		//String parameterId = null;

		Date currentDate = new Date();
		String changedTime = "";
		int hospitalIdforvillageMapping=0; 
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalIdforvillageMapping= (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		MasHospital mashos = new MasHospital();

		Users user = new Users();

		//MasLsg lsg = new MasLsg();
		//PhMasElectricalSection electricalSection = new PhMasElectricalSection();
		if(request.getParameter("parametersId")!=null){
			if(request.getParameter("parametersId").equalsIgnoreCase("vill")){
				if (request.getParameterValues("tempId") != null
						&& !request.getParameterValues("tempId").equals("")) {
					tempId = request.getParameterValues("tempId");

					for (int k = 0; k < tempId.length; k++) {
						LocationParameterMapping locmaPingMap = new LocationParameterMapping();
						MasVillage phMaLoca = new MasVillage();
						phMaLoca.setId(Integer.parseInt(tempId[k]));
						locmaPingMap.setVillage(phMaLoca);

						if (request.getParameter("basicSectionId") != null) {
							hsId = Integer.parseInt(request
									.getParameter("basicSectionId"));
							//System.out.println("basicSectionId "+hsId);
							mashos.setId(hsId);
							locmaPingMap.setHospital(mashos);
						} else if (request.getParameter("subcenterId") != null) {
							hsId = Integer.parseInt(request
									.getParameter("subcenterId"));
							mashos.setId(hsId);
							//System.out.println("subcenterId "+hsId);
							locmaPingMap.setHospital(mashos);
						}
						//int villSubcenterId=0;
						/*if (request.getParameter("villSubcenterId") != null) {
						villSubcenterId = Integer.parseInt(request
								.getParameter("villSubcenterId"));
						mashos.setId(villSubcenterId);
						//System.out.println("subcenterId "+hsId);
						locmaPingMap.setSubCentre(mashos);
					}*/
						if(hospitalIdforvillageMapping>0){
							MasHospital mashospital=new MasHospital();
							mashospital.setId(hospitalIdforvillageMapping);
							//System.out.println("hospitalIdforvillageMapping "+hospitalIdforvillageMapping);
							locmaPingMap.setHospital(mashospital);
						}
						if (session.getAttribute(USER_ID) != null
								&& !session.getAttribute(USER_ID).equals("")) {
							userId = (Integer) session.getAttribute(USER_ID);
							user.setId(userId);
							locmaPingMap.setLastChgBy(user);
						}
						int talukId=0;
						if (request.getParameter("taluk") != null) {
							MasTaluk mastaluk=new MasTaluk();
							talukId = Integer.parseInt(request
									.getParameter("taluk"));
							mastaluk.setId(talukId);
							//System.out.println("talukId "+talukId);
							locmaPingMap.setMasTaluk(mastaluk);
						}

						/*int distrId=0;
					 if (request.getParameter("distr") != null) {
						 MasDistrict masdistrict=new MasDistrict();
						 distrId = Integer.parseInt(request
									.getParameter("distr"));
						 masdistrict.setId(distrId);
							//System.out.println("distrId "+distrId);
							locmaPingMap.setMasDistrict(masdistrict);
						}*/
						if (request.getParameter("changed_date") != null
								&& !(request.getParameter("changed_date")
										.equals(""))) {
							currentDate = HMSUtil.dateFormatterDDMMYYYY(request
									.getParameter("changed_date"));
							locmaPingMap.setLastChgDate(currentDate);
						}
						if (request.getParameter("changed_time") != null
								&& !(request.getParameter("changed_time")
										.equals(""))) {
							changedTime = request.getParameter("changed_time");
							locmaPingMap.setLastChgTime(changedTime);
						}

						locmaPingMap.setStatus("y");

						map = pubHealthHandlerService
								.saveIntoLocationParameter(locmaPingMap);
						Boolean duplicateStatus =false;
						if(null != map.get("duplicateStatus"))
							duplicateStatus = (Boolean) map.get("duplicateStatus");
						/* if(duplicateStatus){
						 break;
					 }*/
					}
				}
			}else
				if (request.getParameter("parametersId").equalsIgnoreCase("loc")) {

					int distr=0;
					int lsgId=0;
					int ward=0;
					int villSubcenterId=0;
					if (request.getParameterValues("villSubcenterId") != null
							&& !request.getParameterValues("villSubcenterId").equals("")) {
						villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));

					}else if (request.getParameter("institute") != null
							&& !request.getParameter("institute").equals("")) { // For PH Admin
						villSubcenterId = Integer.parseInt(request.getParameter("institute"));
					}



					if (request.getParameterValues("distr") != null
							&& !request.getParameterValues("distr").equals("")) {
						distr = Integer.parseInt(request.getParameter("distr"));

					}

					if (request.getParameterValues("lsg") != null
							&& !request.getParameterValues("lsg").equals("")) {
						lsgId = Integer.parseInt(request.getParameter("lsg"));

					}

					if (request.getParameterValues("ward") != null
							&& !request.getParameterValues("ward").equals("")) {
						ward = Integer.parseInt(request.getParameter("ward"));

					}

					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							PhMasLocality phMaLoca = new PhMasLocality();
							phMaLoca.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setLocality(phMaLoca);

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (request.getParameter("phMaLoca") != null
									&& !request.getParameter("phMaLoca").equals("")) {
								local = Integer.parseInt(request
										.getParameter("phMaLoca"));
								phMaLoca.setId(local);
								locmaPingMap.setLocality(phMaLoca);
							}
							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							//
							MasDistrict masdistrict=new MasDistrict();
							masdistrict.setId(distr);
							MasLsg maslsg=new MasLsg();
							maslsg.setId(lsgId);
							MasWard masward=new MasWard();
							masward.setId(ward);
							locmaPingMap.setMasDistrict(masdistrict);
							locmaPingMap.setLsg(maslsg);
							locmaPingMap.setWard(masward);
							MasHospital mashospital=new MasHospital();
							mashospital.setId(villSubcenterId);
							locmaPingMap.setHospital(mashospital);
							locmaPingMap.setStatus("y");

							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);
							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/* if(duplicateStatus){
						 break;
					 }*/
						}
					}
				} else if (request.getParameter("parametersId").equalsIgnoreCase("par")) {


					/*int distr=0;
			if (request.getParameterValues("distId") != null
			&& !request.getParameterValues("distId").equals("")) {
		distr = Integer.parseInt(request.getParameter("distId"));

			}*/
					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							PhMasParliyamentAssembly assembly = new PhMasParliyamentAssembly();
							System.out.println("Par   --" + tempId[k]);
							assembly.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setParliyament(assembly);
							// if (request.getParameterValues("tempId")!= null &&
							// !request.getParameterValues("tempId").equals("")) {
							// // tempId =request.getParameterValues("tempId");
							// assembly.setId(Integer.parseInt(tempId[k]));
							// locmaPingMap.setParliyament(assembly);
							// }

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							locmaPingMap.setStatus("y");
							int villSubcenterId=0;
							MasHospital hospital=new MasHospital();
							if (request.getParameter("villSubcenterId") != null) {
								villSubcenterId = Integer.parseInt(request
										.getParameter("villSubcenterId"));
								hospital.setId(villSubcenterId);
								//System.out.println("subcenterId "+hsId);
								locmaPingMap.setHospital(hospital);
							}else if (request.getParameter("institute") != null
									&& !request.getParameter("institute").equals("")) { // For PH Admin
								villSubcenterId = Integer.parseInt(request.getParameter("institute"));
								hospital.setId(villSubcenterId);
								locmaPingMap.setHospital(hospital);
							}
							/*MasDistrict masdistrict=new MasDistrict();
					masdistrict.setId(distr);

					locmaPingMap.setMasDistrict(masdistrict);*/
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);

							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/* if(duplicateStatus){
						 break;
					 }
							 */

						}
					}
				} else if (request.getParameter("parametersId").equalsIgnoreCase("ass")) {

					/*int distId=0;
			if (request.getParameterValues("distId") != null
					&& !request.getParameterValues("distId").equals("")) {
				distId = Integer.parseInt(request.getParameter("distId"));

			}*/
					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							PhMasParliyamentAssembly assembly = new PhMasParliyamentAssembly();
							assembly.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setAssembly(assembly);

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							locmaPingMap.setStatus("y");
							int villSubcenterId=0;
							MasHospital hospital=new MasHospital();
							if (request.getParameter("villSubcenterId") != null) {
								villSubcenterId = Integer.parseInt(request
										.getParameter("villSubcenterId"));
								hospital.setId(villSubcenterId);
								//System.out.println("subcenterId "+hsId);
								locmaPingMap.setHospital(hospital);
							}
							else if (request.getParameter("institute") != null
									&& !request.getParameter("institute").equals("")) { // For PH Admin
								villSubcenterId = Integer.parseInt(request.getParameter("institute"));
								hospital.setId(villSubcenterId);
								locmaPingMap.setHospital(hospital);
							}

							/*MasDistrict district=new MasDistrict();
					district.setId(distId);
					locmaPingMap.setMasDistrict(district);*/
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);

							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/* if(duplicateStatus){
						 break;
					 }*/

						}
					}
				} else if (request.getParameter("parametersId")
						.equalsIgnoreCase("lsgi")) {
					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							MasLsg masLsg = new MasLsg();
							masLsg.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setLsg(masLsg);

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							locmaPingMap.setStatus("y");
							int villSubcenterId=0;
							MasHospital hospital=new MasHospital();
							if (request.getParameter("villSubcenterId") != null) {
								villSubcenterId = Integer.parseInt(request
										.getParameter("villSubcenterId"));
								hospital.setId(villSubcenterId);
								//System.out.println("subcenterId "+hsId);
								locmaPingMap.setHospital(hospital);
							}else if (request.getParameter("institute") != null
									&& !request.getParameter("institute").equals("")) { // For PH Admin
								villSubcenterId = Integer.parseInt(request.getParameter("institute"));
								hospital.setId(villSubcenterId);
								locmaPingMap.setHospital(hospital);
							}
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);
						}
					}
				} else if (request.getParameter("parametersId")
						.equalsIgnoreCase("post")) {

					/*int distId=0;
			if (request.getParameterValues("distId") != null
					&& !request.getParameterValues("distId").equals("")) {
				distId = Integer.parseInt(request.getParameter("distId"));

			}*/

					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							MasPostCode code = new MasPostCode();
							code.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setPostCode(code);

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							locmaPingMap.setStatus("y");
							int villSubcenterId=0;
							MasHospital hospital=new MasHospital();
							if (request.getParameter("villSubcenterId") != null) {
								villSubcenterId = Integer.parseInt(request
										.getParameter("villSubcenterId"));
								hospital.setId(villSubcenterId);
								//System.out.println("subcenterId "+hsId);
								locmaPingMap.setHospital(hospital);
							}else if (request.getParameter("institute") != null
									&& !request.getParameter("institute").equals("")) { // For PH Admin
								villSubcenterId = Integer.parseInt(request.getParameter("institute"));
								hospital.setId(villSubcenterId);
								locmaPingMap.setHospital(hospital);
							}
							/*MasDistrict district=new MasDistrict();
					district.setId(distId);
					locmaPingMap.setMasDistrict(district);*/
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);
							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/*if(duplicateStatus){
						 break;
					 }*/

						}
					}
				} else if (request.getParameter("parametersId")
						.equalsIgnoreCase("esec")) {

					/*int distId=0;
			if (request.getParameterValues("distId") != null
					&& !request.getParameterValues("distId").equals("")) {
				distId = Integer.parseInt(request.getParameter("distId"));

			}*/

					int villSubcenterId=0;


					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							PhMasElectricalSection masElectricalSection = new PhMasElectricalSection();
							masElectricalSection.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setElectricalSection(masElectricalSection);

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}

							locmaPingMap.setStatus("y");
							MasHospital hospital=new MasHospital();
							if (request.getParameter("villSubcenterId") != null) {
								villSubcenterId = Integer.parseInt(request
										.getParameter("villSubcenterId"));
								hospital.setId(villSubcenterId);
								//System.out.println("subcenterId "+hsId);
								locmaPingMap.setHospital(hospital);
							}else if (request.getParameter("institute") != null
									&& !request.getParameter("institute").equals("")) { // For PH Admin
								villSubcenterId = Integer.parseInt(request.getParameter("institute"));
								hospital.setId(villSubcenterId);
								locmaPingMap.setHospital(hospital);
							}
							/*MasDistrict district=new MasDistrict();
					district.setId(distId);
					locmaPingMap.setMasDistrict(district);*/
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);
							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/* if(duplicateStatus){
						 break;
					 }*/

						}
					}
				}
			// ------------------
				else if (request.getParameter("parametersId").equalsIgnoreCase("sc")) {
					//System.out.println("sCCCCCCC");
					int villSubcenterId=0;
					if (request.getParameterValues("villSubcenterId") != null
							&& !request.getParameterValues("villSubcenterId").equals("")) {
						villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
					}else if (request.getParameter("institute") != null
							&& !request.getParameter("institute").equals("")) { // For PH Admin
						villSubcenterId = Integer.parseInt(request.getParameter("institute"));
					}

					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {
							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							MasHospital masHo = new MasHospital();

							//System.out.println("Par   --" + tempId[k]);
							masHo.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setSubCentre(masHo);
							// if (request.getParameterValues("tempId")!= null &&
							// !request.getParameterValues("tempId").equals("")) {
							// // tempId =request.getParameterValues("tempId");
							// assembly.setId(Integer.parseInt(tempId[k]));
							// locmaPingMap.setParliyament(assembly);
							// }

							if (request.getParameter("basicSectionId") != null && !request.getParameter("basicSectionId").equals("") && !request.getParameter("basicSectionId").equals("0")) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} 
							else if (request.getParameter("subcenterId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							locmaPingMap.setStatus("y");
							MasHospital hosp=new MasHospital();
							hosp.setId(villSubcenterId);
							locmaPingMap.setHospital(hosp);

							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);

							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/* if(duplicateStatus){
						 break;
					 }*/

						}
					}
				}
			// ---------------
				else if (request.getParameter("parametersId").equalsIgnoreCase("bs")) {

					int villSubcenterId=0;
					if (request.getParameter("villSubcenterId") != null
							&& !request.getParameter("villSubcenterId").equals("")) {
						villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
					}else if (request.getParameter("institute") != null
							&& !request.getParameter("institute").equals("")) { // For PH Admin
						villSubcenterId = Integer.parseInt(request.getParameter("institute"));
					}
					if (request.getParameterValues("tempId") != null
							&& !request.getParameterValues("tempId").equals("")) {
						tempId = request.getParameterValues("tempId");

						for (int k = 0; k < tempId.length; k++) {

							LocationParameterMapping locmaPingMap = new LocationParameterMapping();
							MasHospital masHo = new MasHospital();

							masHo.setId(Integer.parseInt(tempId[k]));
							locmaPingMap.setBasicSection(masHo);
							// if (request.getParameterValues("tempId")!= null &&
							// !request.getParameterValues("tempId").equals("")) {
							// // tempId =request.getParameterValues("tempId");
							// assembly.setId(Integer.parseInt(tempId[k]));
							// locmaPingMap.setParliyament(assembly);
							// }

							if (request.getParameter("basicSectionId") != null) {
								hsId = Integer.parseInt(request
										.getParameter("basicSectionId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							} else if (request.getParameter("subcenterId") != null && !request.getParameter("subcenterId").equals("") && request.getParameter("subcenterId").equals("0")) {
								hsId = Integer.parseInt(request
										.getParameter("subcenterId"));
								mashos.setId(hsId);
								locmaPingMap.setHospital(mashos);
							}

							if (session.getAttribute(USER_ID) != null
									&& !session.getAttribute(USER_ID).equals("")) {
								userId = (Integer) session.getAttribute(USER_ID);
								user.setId(userId);
								locmaPingMap.setLastChgBy(user);
							}

							if (request.getParameter("changed_date") != null
									&& !(request.getParameter("changed_date")
											.equals(""))) {
								currentDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter("changed_date"));
								locmaPingMap.setLastChgDate(currentDate);
							}
							if (request.getParameter("changed_time") != null
									&& !(request.getParameter("changed_time")
											.equals(""))) {
								changedTime = request.getParameter("changed_time");
								locmaPingMap.setLastChgTime(changedTime);
							}
							/*int distr=0;
					if (request.getParameterValues("distr") != null
							&& !request.getParameterValues("distr").equals("")) {
						distr = Integer.parseInt(request.getParameter("distr"));

					}*/
							locmaPingMap.setStatus("y");
							MasHospital hosp=new MasHospital();
							hosp.setId(villSubcenterId);
							locmaPingMap.setHospital(hosp);

							/*MasDistrict masdistrict=new MasDistrict();
					if(distr>0){
					masdistrict.setId(distr);
					locmaPingMap.setMasDistrict(masdistrict);
					}*/
							map = pubHealthHandlerService
									.saveIntoLocationParameter(locmaPingMap);
							Boolean duplicateStatus =false;
							if(null != map.get("duplicateStatus"))
								duplicateStatus = (Boolean) map.get("duplicateStatus");
							/*if(duplicateStatus){
						 break;
					 }*/


						}
					}
				}
		}
		String message = "";

		Boolean saved = (Boolean) map.get("saveFlag");
		
		Boolean duplicateStatus =false;
		if(null != map.get("duplicateStatus"))
			duplicateStatus = (Boolean) map.get("duplicateStatus");

		String jsp = "";
		//if(!duplicateStatus){
		if (saved) {
			message = "Data Saved";
		} else {
			message = "Some Problem Occured.";
		}
		//}else{
			//message="This Mapping  Already Exists";
		//}
		map.put("message", message);
		jsp = "responceForSubmit";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getDistrictList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = pubHealthHandlerService.getDistrictList(box);
		jsp = "responseForDisrictList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getParalamentList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		int subcenterId = 0;
		int hospitalId = 0;
		
		 session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		Box box = HMSUtil.getBox(request);
		session = request.getSession();

		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}
		box.put("subcenterId", subcenterId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.getParalamentList(box);
		jsp = "responseForParametersList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getDistrictForAssamblyList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getDistrictForAssamblyList(box);
		jsp = "responseForDisricAssamplytList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getAssamblyList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}

		box.put("subcenterId", subcenterId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.getAssamblyList(box);
		jsp = "responseForAssamblyList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getDistrictForLsgList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		map = pubHealthHandlerService.getDistrictForLsgList(box);
		jsp = "responseForDisricLsgList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getLsgiList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession(); //commented by Om Tripathi unused reference
		int subcenterId = 0;
		int hospitalId = 0;
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}

		box.put("subcenterId", subcenterId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.getLsgiList(box);
		jsp = "responseForlsgi";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getDistrictForElectricalSecList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		map = pubHealthHandlerService.getDistrictForElectricalSecList(box);
		jsp = "responseForDisricElSecList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getElectrickSectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}

		box.put("subcenterId", subcenterId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.getElectrickSectionList(box);
		jsp = "responseForElectrickSection";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getDistrictForPostOfficeList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession(); //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getDistrictForPostOfficeList(box);
		jsp = "responseForDisricPostCoList";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getPostOfficeList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int subcenterId = 0;
		int hospitalId = 0;
		
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}

		box.put("subcenterId", subcenterId);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.getPostOfficeList(box);
		jsp = "responseForPostCode";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView updateInlocationParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String tempId[] = null;
		String basicSec="";
		if (request.getParameter("basicSec") != null
				&& !request.getParameter("basicSec").equals("")) {
			basicSec=request.getParameter("basicSec");
			
			dataMap.put("basicSec", basicSec);
		}
		int distr=0;
		if (request.getParameterValues("distr") != null
				&& !request.getParameterValues("distr").equals("")) {
			distr = Integer.parseInt(request.getParameter("distr"));
			dataMap.put("distr", distr);
		}
		if (request.getParameterValues("distId") != null
				&& !request.getParameterValues("distId").equals("")) {
			distr = Integer.parseInt(request.getParameter("distId"));
			dataMap.put("distr", distr);
		}
		int lsgId=0;
		
		if (request.getParameterValues("lsg") != null
				&& !request.getParameterValues("lsg").equals("")) {
			lsgId = Integer.parseInt(request.getParameter("lsg"));
			dataMap.put("lsgId", lsgId);
		}
		int wardId=0;
		if (request.getParameterValues("ward") != null
				&& !request.getParameterValues("ward").equals("")) {
			wardId = Integer.parseInt(request.getParameter("ward"));
			dataMap.put("wardId", wardId);
		}
		
		int villSubcenterId=0;
		if (request.getParameter("villSubcenterId") != null
				&& !request.getParameter("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
			dataMap.put("villSubcenterId", villSubcenterId);
		}else if (request.getParameter("institute") != null
				&& !request.getParameter("institute").equals("")) { // For PH Admin
			villSubcenterId = Integer.parseInt(request.getParameter("institute"));
			dataMap.put("villSubcenterId", villSubcenterId);
		}
		int talukId=0;
		if (request.getParameter("taluk") != null
				&& !request.getParameter("taluk").equals("")) {
			talukId = Integer.parseInt(request.getParameter("taluk"));
			dataMap.put("talukId", talukId);
		}
		
		
		if (request.getParameterValues("tempId") != null
				&& !request.getParameterValues("tempId").equals("")) {
			tempId = request.getParameterValues("tempId");

			for (int k = 0; k < tempId.length; k++) {
				LocationParameterMapping locmaPingMap = new LocationParameterMapping();
				locmaPingMap.setId(Integer.parseInt(tempId[k]));
				map = pubHealthHandlerService
						.updateInlocationParameter(locmaPingMap, dataMap);

			}

		}
		String message = "";
		Boolean saved = (Boolean) map.get("saveFlag");

		if (saved) {
			message = "Data updated successfully";

		} else {
			message = "Some Problem Occured.";
		}

		map.put("message", message);
		jsp = "responceForUpdate";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// -----------------------------House Survey------------------------
	public ModelAndView showJHIJPHNHouseSurveyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int districtId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer) session.getAttribute("districtId");
			box.put("districtId", districtId);
		}
		
		map = pubHealthHandlerService.showJHIJPHNHouseSurveyJsp(box, details);
		jsp = "jhiJPHNHouseSurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHouseSurveyINDistrictJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int villageId = 0;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("village") != null
				&& !request.getParameter("village").equals("")) {
			villageId = Integer.parseInt(request.getParameter("village")
					.toString());
			box.put("villageId", villageId);
		}
		map = pubHealthHandlerService.showHouseSurveyINDistrict(box, details);
		jsp = "districtHouseSurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHouseSurveyInStateJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int villageId = 0;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (request.getParameter("village") != null
				&& !request.getParameter("village").equals("")) {
			villageId = Integer.parseInt(request.getParameter("village")
					.toString());
			box.put("villageId", villageId);
		}
		map = pubHealthHandlerService.showHouseSurveyInStateJsp(box, details);
		jsp = "stateHouseSurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPublicHealthHouseSurveyJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int districtId = 0;
		String hospitalName = "";
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		String instituteTypeShortName="";
		int page = 1;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer) session.getAttribute("districtId");
			box.put("districtId", districtId);
		}
		if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));    
		}
		details.put("page", page);
		//hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
	
		map = pubHealthHandlerService.getDistrictList();
		masDistrict = (List) map.get("masDistrict");

		map = pubHealthHandlerService.showPublicHealthHouseSurveyJsp(box, details);
		jsp = "publicHealthHouseSurvey" + ".jsp";
		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("masDistrict", masDistrict);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView phFamilySurveys(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.phFamilySurveys(box, details);
		jsp = "publicHealthFamilySurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView phEligibleCouple(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.phEligibleCouple(box, details);
		jsp = "publicHealthEligibleCouple" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getTalukForElSectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int district = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("disId") != null) {
				district = Integer.parseInt(request.getParameter("disId"));
			}
			dataMap.put("district", district);
			dataMap.put("hospitalId", hospitalId);
			map = pubHealthHandlerService.getTalukForElSectionList(dataMap);
			jsp = "responseforElSecTaluk";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getvilageElSectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taluk = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("taluk") != null) {
				taluk = Integer.parseInt(request.getParameter("taluk"));
			}
			dataMap.put("taluk", taluk);
			map = pubHealthHandlerService.getvilageElSectionList(dataMap);
			jsp = "responceForvillageElSection";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	// -----------------------------Village Survey------------------------

	public ModelAndView showPublicHealthVillageSurveyJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		//HttpSession session = request.getSession();

		map = pubHealthHandlerService.showPublicHealthVillageSurveyJsp(details);
		jsp = "publicHealthVillageSurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searChPublicHealthVillageSurveyJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> details = new HashMap<String, Object>(); //commented by Om Tripathi unused reference
		Box box = HMSUtil.getBox(request);
		int idFor = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		/*if (request.getParameter("clinical") != null
				&& !request.getParameter("clinical").equals("")) {
			System.out.println("type "+request.getParameter("clinical"));
		}*/

		map = pubHealthHandlerService.searChPublicHealthVillageSurveyJsp(box);
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");

		}
		if (map.get("idFor") != null) {
			idFor = (Integer) map.get("idFor");
		}
		if (idFor == 1001) {
			jsp = "searchListForSurvey";
		} else if (idFor == 1002) {
			jsp = "searchListForSchoolSurvey";
		} else if (idFor == 1003) {
			jsp = "searchListForCollageSurvey";
		} else if (idFor == 1004) {
			jsp = "searchListForHosClicSurvey";
		} else if (idFor == 1005) {
			jsp = "searchListForDignostickSurvey";
		} else if (idFor == 1006) {
			jsp = "searchListForPahrmecySurvey";
		} else if (idFor == 1007) {
			jsp = "searchListForOrgnaiSurvey";
		} else if (idFor == 1008) {
			jsp = "searchListReligusSurvey";
		}

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	// -------------------Approve By MO HI-------------

	public ModelAndView showApproveByMOHi(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> details = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		//int hospitalId = 0;

		jsp = "approveByHsMo" + ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMonthsForApprve(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String monthValue = "";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}

			dataMap.put("monthValue", monthValue);
			map = pubHealthHandlerService.getMonthsForApprve(dataMap);
			jsp = "responseMonthsForName";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getDetailByName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String monthValue = "";
		Box box = HMSUtil.getBox(request);
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			dataMap.put("monthValue", monthValue);
			map = pubHealthHandlerService.getDetailByName(box);
			jsp = "responseDetailList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	// ------------------ Mapping ------------------------------

	/*
	 * public ModelAndView getDistrictBesickSectionList(HttpServletRequest
	 * request, HttpServletResponse response) { Map<String, Object> map = new
	 * HashMap<String, Object>(); HttpSession session = null; Box box=
	 * HMSUtil.getBox(request); session = request.getSession(); map =
	 * pubHealthHandlerService.getDistrictBesickSectionList(box); jsp =
	 * "responseForDisricPostCoList"; return new ModelAndView(jsp, "map", map);
	 * 
	 * }
	 */

	public ModelAndView getBesicSectionlist(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int phcId = 0;
		int subcenterId = 0;
		int hospitalId = 0;
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			hospitalId = Integer.parseInt(request
					.getParameter("basicSectionId").toString());
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = Integer.parseInt(request.getParameter("subcenterId")
					.toString());
		}

		try {

			if (request.getParameter("phcId") != null) {
				phcId = Integer.parseInt(request.getParameter("phcId"));
			}
			dataMap.put("phcId", phcId);
			dataMap.put("subcenterId", subcenterId);
			dataMap.put("hospitalId", hospitalId);
			map = pubHealthHandlerService.getBesicSectionlist(dataMap);
			jsp = "responseforBesickSection";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getphSubcenterList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int phcId = 0;
		String basicSectionId = "";
		String subcenterId = "";
		int villSubcenterId=0;
		if (request.getParameterValues("villSubcenterId") != null
				&& !request.getParameterValues("villSubcenterId").equals("")) {
			villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
		}else if (request.getParameter("institute") != null
				&& !request.getParameter("institute").equals("")) { // For PH Admin
			villSubcenterId = Integer.parseInt(request.getParameter("institute"));
		}
		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			basicSectionId = request.getParameter("basicSectionId");
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = request.getParameter("subcenterId");
		}
		int hospialIdphcCHC=0;
		if (request.getParameter("hospialIdphcCHC") != null
				&& !request.getParameter("hospialIdphcCHC").equals("")) {
			hospialIdphcCHC = Integer.parseInt(request.getParameter("hospialIdphcCHC"));
		}

		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("phcId") != null) {
				phcId = Integer.parseInt(request.getParameter("phcId"));
			}

			dataMap.put("villSubcenterId", villSubcenterId);
			dataMap.put("hospitalId", basicSectionId);
			dataMap.put("hospialIdphcCHC", hospialIdphcCHC);
			dataMap.put("subcenterId", subcenterId);
			dataMap.put("phcId", phcId);
			map = pubHealthHandlerService.getSubcenterList(dataMap);
			jsp = "responseforSubcenterkSection";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView populateSubcenterList(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("dhananjay");
		Map<String, Object> map = new HashMap<String, Object>();
		int phcId = 0;
		String basicSectionId = "";
		String subcenterId = "";

		if (request.getParameter("basicSectionId") != null
				&& !request.getParameter("basicSectionId").equals("")) {
			basicSectionId = request.getParameter("basicSectionId");
		}
		if (request.getParameter("subcenterId") != null
				&& !request.getParameter("subcenterId").equals("")) {
			subcenterId = request.getParameter("subcenterId");
		}
 int hospialIdphcCHC=0;
		if (request.getParameter("hospialIdphcCHC") != null
				&& !request.getParameter("hospialIdphcCHC").equals("")) {
			hospialIdphcCHC = Integer.parseInt(request.getParameter("hospialIdphcCHC"));
		}

		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("phcId") != null) {
				phcId = Integer.parseInt(request.getParameter("phcId"));
			}

			
			int villSubcenterId=0;
			if (request.getParameter("villSubcenterId") != null
					&& !request.getParameter("villSubcenterId").equals("")) {
				villSubcenterId =Integer.parseInt(request.getParameter("villSubcenterId"));
			}else if (request.getParameter("institute") != null
					&& !request.getParameter("institute").equals("")) { // For PH Admin
				villSubcenterId = Integer.parseInt(request.getParameter("institute"));
			}
			
			dataMap.put("villSubcenterId", villSubcenterId);
			dataMap.put("hospitalId", basicSectionId);
			dataMap.put("hospialIdphcCHC", hospialIdphcCHC);
			dataMap.put("subcenterId", subcenterId);
			dataMap.put("phcId", phcId);
			map = pubHealthHandlerService.populateSubcenterList(dataMap);
			//jsp = "responseforSubcenterkSection";
			jsp="responseforBasicSubectionnew";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	// ------------- JPHN DAILY OBSERVATION ------------------

	public ModelAndView showDailyObservation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> details = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		//int hospitalId = 0;

		jsp = "obserVationJphn" + ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getMonthsAndVisit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String monthValue = "";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}

			dataMap.put("monthValue", monthValue);
			map = pubHealthHandlerService.getMonthsAndVisit(dataMap);
			jsp = "responseForName";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getlistbyVisit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String monthValue = "";
		try {
			//Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}

			map = pubHealthHandlerService.getlistbyVisit(box);
			jsp = "responsList";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String monthValue = "";
		try {
			//Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}

			map = pubHealthHandlerService.submitStatus(box);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "ATP Observation Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "submitResponce";
			jsp += ".jsp";
			title = "Immunization";
			map.put("contentJsp", jsp);
			map.put("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHSAndMOapproval(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String monthValue = "";
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int empId = (Integer) session.getAttribute("empId");
		try {
			//Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("monthValue") != null) {
				monthValue = request.getParameter("monthValue");
			}
			box.put("empId", empId);
			map = pubHealthHandlerService.submitHSAndMOapproval(box);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "Approval Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "submitResponceForMOHS";
			jsp += ".jsp";
			title = "Immunization";
			map.put("contentJsp", jsp);
			map.put("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ------------- Asha Worker -----------------------

	public ModelAndView showAshaWorker(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> datmap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int hospitalId = 0;
		int empId = 0;
		if (session.getAttribute("userId") != null) {
			empId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		if (session.getAttribute(HOSPITAL_ID) != null
				&& !session.getAttribute(HOSPITAL_ID).equals("")) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute(HOSPITAL_ID));
		}

		datmap.put("empId", empId);
		datmap.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.showAshaWorker(datmap);

		jsp = "ashaWorrker" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getAshaworkerDetail(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getAshaworkerDetail(box);

		jsp = "resAshaPerformence";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getAshaWorker(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getRegistrationDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = pubHealthHandlerService.getRegistrationDetail(box);

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getBirthRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getBirthRegistration(box);

		jsp = "resforBirthRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getDeathRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int empId = 0;
		if (session.getAttribute("userId") != null) {
			empId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		int rowNo = box.getInt("rowVal");

		box.put("empId", empId);

		map = pubHealthHandlerService.getDeathRegistration(box);
		map.put("rowNo", rowNo);
		jsp = "resforDeathRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getAncRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getAncRegistration(box);

		jsp = "resforAncRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getEcRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getEcRegistration(box);

		jsp = "resforAntiNanRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getFamilyPalRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getFamilyPalRegistration(box);

		jsp = "resforAntiNanRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getCDRRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getCDRRegistration(box);

		jsp = "resforComRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getNonCDRRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		map = pubHealthHandlerService.getNonCDRRegistration(box);

		jsp = "resforNonComRegistration";

		return new ModelAndView(jsp, "map", map);

	}

	// ----------------- PUBLIC HEALTH REPORT ------------------
	// ----------------- START ------------------

	public ModelAndView showAntenantalCare(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Antenatal Care Report";

		jsp = "antenatal_CareJSP";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateAntiCareReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String currentDate = "";
		String sDate = "";
		String eDate = "";
		Date startDate = null;
		Date endDate = null;
		int hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";
		String query = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			}
			/*if (instituteTypeShortName.equals("Admn")) {
				query +="  and md.district_id="+districtId;
			}*/
			if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
				query +="  and pas.hospital_id="+hospitalId;
			}
			requestParameters.put("query", query);
			
			if (request.getParameter("currentDate") != null
					&& !(request.getParameter("currentDate").equals(""))) {
				currentDate = request.getParameter("currentDate");
				requestParameters.put("currentDate", currentDate);
				String splitDate[]=currentDate.split("-");
				if(splitDate[1].equals("1") || splitDate[1].equals("2") || splitDate[1].equals("3")) {
					eDate = splitDate[0] + "-03-31";
					endDate = HMSUtil.convertStringyyyyMMddTypeToDateType(eDate);
					splitDate[0]=String.valueOf(Integer.parseInt(splitDate[0])-1);
					sDate = splitDate[0] + "-04-01";
					startDate = HMSUtil.convertStringyyyyMMddTypeToDateType(sDate);
					requestParameters.put("startDate", startDate);
					requestParameters.put("endDate", endDate);
				} else {
					sDate = splitDate[0] + "-04-01";
					startDate = HMSUtil.convertStringyyyyMMddTypeToDateType(sDate);
					splitDate[0]=String.valueOf(Integer.parseInt(splitDate[0])+1);
					eDate = splitDate[0] + "-03-31";
					endDate = HMSUtil.convertStringyyyyMMddTypeToDateType(eDate);
					requestParameters.put("startDate", startDate);
					requestParameters.put("endDate", endDate);
				}

			}
			
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("AntenatalCare", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// ----------- Ph Report For ---- Communicable Diseases-----

	public ModelAndView showCDiseases(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Communicable Diseases Report";

		jsp = "c_DiseasesJSP";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateCommunicableReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";
		String query="";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			}
			/*if (instituteTypeShortName.equals("Admn")) {
				query +="  and md.district_id="+districtId;
			}*/
			if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
				query +="  and ho.parent_institute_id="+hospitalId;
			}
			if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
				query +="  and dr.hospital_id="+hospitalId;
			}
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Communicable_Diseases", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// ---------- Ph Birth Registrtion -------------

	public ModelAndView showBirthRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
	
		map = pubHealthHandlerService.getDistrictList();
		title = "Birth Report";

		jsp = "birth_jsp";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateBirthReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		Box box = HMSUtil.getBox(request);
		int districtId = 0;
		int hospitalId = 0;
		String hospitalName = "";
		Date currentDate = null;
		int gender = 0;
		int deliveryType = 0;
		String qry="";
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				qry +="  and mh.district_id="+districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +="  and bdr.hospital_id="+hospitalId;
			}
			if (request.getParameter("currentDate") != null	&& !(request.getParameter("currentDate").equals(""))) {
				currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
				requestParameters.put("currentDate", currentDate);
			}
			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}

			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			if(request.getParameter("gender") != null && !(request.getParameter("gender").equals("0"))) {
				gender = Integer.parseInt(request.getParameter("gender").toString());
				qry +="  and ax.administrative_sex_id="+gender;
			}
			if(request.getParameter("deliveryType") != null && !(request.getParameter("deliveryType").equals("0"))) {
				deliveryType = Integer.parseInt(request.getParameter("deliveryType").toString());
				qry +=" and dt.delivery_type_id="+deliveryType;
			}
			System.out.println("fromDate"+fromDate);
			System.out.println("toDate"+toDate);
			System.out.println("qry"+qry);

			requestParameters.put("qry", qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> connectionMap = pubHealthHandlerService.getConnectionForReport();
		HMSUtil.generateReport("BirthDeathRegister", requestParameters,	
				(Connection) connectionMap.get("con"), response, getServletContext());
		return null;
	}

	// -----Ph Consolidate Death Registration--------------

	public ModelAndView showConDeathRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictList();

		title = "Consolidate Death Report";

		jsp = "consulated_deathJSP";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateCoDeathReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;

		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		int hospitalId = 0;
		String hospitalName = "";
		String query = "";
		String instituteTypeShortName="";
	
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			}
			/*if (instituteTypeShortName.equals("Admn")) {
				query +="  and md.district_id="+districtId;
			}*/
			if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
				query +="  and bdr.hospital_id="+hospitalId;
			}
			
			requestParameters.put("query", query);
			
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Consolidated_Deaths", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// -----Ph Death Registration--------------

	public ModelAndView shownDeathRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictList();

		title = "Death Report";

		jsp = "deathJSP";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateDeathReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		int hospitalId = 0;
		int districtId = 0;
		String hospitalName = "";
		String query = "";
		String cdeath[] = null;
		String bcsc = "";
		String base = null;
		int gender = 0;
		int fromAge = 0;
		int toAge = 0;
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				query +="  and mh.district_id="+districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				query +="  and bdr.hospital_id="+hospitalId;
			}
			if(request.getParameter("gender") != null && !(request.getParameter("gender").equals("0"))) {
				gender = Integer.parseInt(request.getParameter("gender").toString());
				query +="  and ax.administrative_sex_id="+gender;
			}
			if(request.getParameter("fromAge") != null && !(request.getParameter("fromAge").equals(""))) {
				fromAge = Integer.parseInt(request.getParameter("fromAge").toString());
			}
			if(request.getParameter("toAge") != null && !(request.getParameter("toAge").equals(""))) {
				toAge = Integer.parseInt(request.getParameter("toAge").toString());
				query +="  and (bdr.dob_death_date-ms.date_of_birth)/365 between " + fromAge + " and " +toAge;
			}
			if (request.getParameter("cdeath") != null	&& !(request.getParameter("cdeath").equals(""))) {
				cdeath = request.getParameterValues("cdeath");
				String str1 = Arrays.toString(cdeath);
				str1 = str1.substring(1, str1.length() - 1).replaceAll("", "");

				// String s ="'"+cdeath.toString().replace("[","").replace("]",
				// "").replace(" ","").replace(",","','")+"'";

				// System.out.println(s+">>>>>>>>>>>>>>>>");

				System.out.println(cdeath.length + "====len"
						+ request.getParameterValues("cdeath").length);

				// de=cdeath.toString();
				String de = "";

				for (int i = 0; i < cdeath.length - 1; i++) {
					System.out.println(cdeath[i]);
				}

				for (int i = 0; i < cdeath.length; i++) {
					if (i == (cdeath.length - 1)) {
						de += "'" + cdeath[i] + "'";
						System.out.println("If '" + cdeath[i] + "'");
					} else {
						de += "'" + cdeath[i] + "', ";
						System.out.println("else '" + cdeath[i] + "'");
					}
				}
				System.out.println("de---" + de);
				query += "  and bdr.cause_of_death in (" + de + ")";
//				requestParameters.put("Diseases", quer);
			}

			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			requestParameters.put("query", query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService.getConnectionForReport();
		HMSUtil.generateReport("Death_reg_report", requestParameters,
				(Connection) connectionMap.get("con"), response, getServletContext());
		return null;
	}

	// ----------- PH- Report For ---- Consolidate Communicable Diseases-----

	public ModelAndView showConsolidateCDiseases(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");

		title = "Communicable Diseases Report";

		jsp = "communicable_diseases";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateConsolidateCommunicableReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;

		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		Date fromDate = null;
		Date toDate = null;
		String vendorName = "";
		int hospitalId = 0;
		String hospitalName = "";
		session = request.getSession();
		String query = "";
		requestParameters.put("hospitalId", session.getAttribute("hospitalId"));
		// requestParameters.put("deptId", session.getAttribute("deptId"));

		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Communicable_Diseases", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// ----------- PH- Report For ----Vector Survey-----

	public ModelAndView showVectorSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictList();
		title = "Vector Survey Report";

		jsp = "v_survey";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateVectorSurveyReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String fileName = null;

		HttpSession session = request.getSession();
		Date fromDate = null;
		Date toDate = null;
		int districtId = 0;
		int hospitalId = 0;
		String hospitalName = "";
		String base = null;
		String qry="";
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				qry +="  and mh.district_id="+districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +="  and pov.hospital_id="+hospitalId;
			}

			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}

			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			
			requestParameters.put("qry", qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Vector_survey_report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// -----------Ph Consolidate Report of Communicable Diseases------

	public ModelAndView showConsolidat_communicable_diseases(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");

		title = "Communicable Diseases Report";

		jsp = "communicable_diseases";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateConsolidat_communicable_diseasesReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
		String hospitalName="";
		Box box = HMSUtil.getBox(request);
		Calendar calendar = Calendar.getInstance();
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		
		String fromApr = 01 + "/" + 04 + "/" + "" + box.get("year");
		String year_end = 31 + "/" + 12 + "/" + "" + box.get("year");
		String currentMonth = 01 + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String cu_Month_end = lastDate + "/" + box.get("month") + "/" + ""
				+ box.get("year");
		String fromDate = 1 + "/" + box.get("month") + "/" + ""
				+ box.get("year");

		hospitalId= (Integer) session.getAttribute("hospitalId");
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
					requestParameters.put("hospitalId", hospitalId);
					requestParameters.put("hospitalName", hospitalName);
					
		requestParameters.put("fromApr",
				HMSUtil.convertStringTypeDateToDateType(fromApr));
		requestParameters.put("year_end",
				HMSUtil.convertStringTypeDateToDateType(year_end));
		requestParameters.put("currentMonth",
				HMSUtil.convertStringTypeDateToDateType(currentMonth));
		requestParameters.put("cu_Month_end",
				HMSUtil.convertStringTypeDateToDateType(cu_Month_end));

		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("Consolidate_Comunicable_diseses",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;
	}

	// ------------ Ph- Dilevery Detail-----------------

	public ModelAndView showDileveryDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictList();

		title = "Delivery Detail Report";

		jsp = "delivery_detail";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unused" })
	public ModelAndView generateDeliveryDetailReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		HttpSession session=request.getSession();
		String hospitalName = "";
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;
		String instituteTypeShortName = "";
		String query = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			}
			/*if (instituteTypeShortName.equals("Admn")) {
				query +="  and md.district_id="+districtId;
			}*/
			if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
				query +="  and patm.hospital_id="+hospitalId;
			}
			requestParameters.put("query", query);
			
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();

		/*Map<String, Object> classMap = pubHealthHandlerService
				.runDilevery_detail_Procedure(hospitalId);*/
		HMSUtil.generateReport("Delivery_Details", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;

	}

	// ------------ Ph- Dilevery Place Detail-----------------

	public ModelAndView showDeliveryPlaceDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictList();

		title = "Delivery Detail Report";

		jsp = "delivery_place_detail";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unused" })
	public ModelAndView generateDeliveryPlaceDetailReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		String hospitalName="";
		Date fromDate = null;
		Date toDate = null;
		String instituteTypeShortName = "";
		String query = "";
		 
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			}
			/*if (instituteTypeShortName.equals("Admn")) {
				query +="  and md.district_id="+districtId;
			}*/
			if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
				query +="  and patm.hospital_id="+hospitalId;
			}
			requestParameters.put("query", query);
			
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();

		/*Map<String, Object> classMap = pubHealthHandlerService
				.runDelivryPlaceProcedure(fromDate, toDate);*/
		HMSUtil.generateReport("Delivery_Place_detail",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return null;

	}

	public ModelAndView getchclist(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		map = pubHealthHandlerService.getchclist(box);
		jsp = "responce_chc";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getBasicCenterListchc(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_center";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getBasicCenterListphc(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_center";
		return new ModelAndView(jsp, "map", map);

	}

	// -----------get CHC PHC ---Sub center List in Birth -----
	public ModelAndView getBirthchclist(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = pubHealthHandlerService.getchclist(box);
		jsp = "responce_chc_birt";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getBirthBasicCenterListchc(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_center_birth";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getBirthBasicCenterListphc(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_centerphc_birth";
		return new ModelAndView(jsp, "map", map);

	}

	// -----------get CHC PHC ---Sub center List in Vector Survey -----
	public ModelAndView getVectorSurveychclist(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getchclist(box);
		jsp = "responce_chc_vector";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getVectorSurveyBasicCenterListchc(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_center_vector";
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView getVectorSurveyBasicCenterListphc(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		//HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		//session = request.getSession();  //commented by Om Tripathi unused reference
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "responce_centerphc_vector";
		return new ModelAndView(jsp, "map", map);

	}

	// --------------- Total Count Of Survey -----------

	public ModelAndView showSurveyCountJSP(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "countSurvey";
		jsp += ".jsp";
		title = "Total Count Servey";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getSurveyCount(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		session = request.getSession();
		map = pubHealthHandlerService.getSurveyCount(box);
		jsp = "responce_survey";
		return new ModelAndView(jsp, "map", map);

	}

	// ----------------- PUBLIC HEALTH REPORT ------------------
	// ----------------- END ------------------

	// - ------------ Send Mail --------

	public ModelAndView sendMailOfSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = null;
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.sendMailOfSurvey(box);
		boolean saved = false;
		String message = "";
		if (map.get("successfullSends") != null) {
			saved = (Boolean) map.get("successfullSends");
		}
		if (saved) {
			message = "Send Successfully.";
		} else {
			message = "Try Again!";
		}
		
		map.put("message", message);
		jsp = "responce_survey";
		return new ModelAndView(jsp, "map", map);

	}

	// VK
	public ModelAndView showTransferMemberJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.showTransferMemberJsp(box);
		String jsp = "transfer_member_jsp";
		jsp += ".jsp";
		title = "Transferred Member";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView detailTransferMember(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.detailTransferMember(box, details);
		jsp = "transfer_member_jsp" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// VK
	public ModelAndView showNewTransferMember(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		int districtId = (Integer) session.getAttribute("districtId");
		Box box = HMSUtil.getBox(request);
		box.put("districtId", districtId);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		map = pubHealthHandlerService.showNewTransferMemberJsp(box);
		String jsp = "new_transfer_member_jsp";
		jsp += ".jsp";
		title = "New Transferred Member";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getTalukForTransferedMemberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int district = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("district") != null) {
				district = Integer.parseInt(request.getParameter("district"));
			}
			dataMap.put("district", district);
			map = pubHealthHandlerService
					.getTalukForTransferedMemberList(dataMap);
			jsp = "responseTalukForTransferedMember";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getVillageForTransferedMemberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taluk = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("taluk") != null) {
				taluk = Integer.parseInt(request.getParameter("taluk"));
			}
			dataMap.put("taluk", taluk);
			map = pubHealthHandlerService
					.getVillageForTransferedMemberList(dataMap);
			jsp = "responseVillageForTransferedMember";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getWardForTransferedMemberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int village = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("village") != null) {
				village = Integer.parseInt(request.getParameter("village"));
			}
			dataMap.put("village", village);
			map = pubHealthHandlerService
					.getWardForTransferedMemberList(dataMap);
			jsp = "responceForWardForTransferedMember";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSubCentreForTransferedMemberList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ward = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("ward") != null) {
				ward = Integer.parseInt(request.getParameter("ward"));
			}
			dataMap.put("ward", ward);
			map = pubHealthHandlerService
					.getSubCentreForTransferedMemberList(dataMap);
			jsp = "responceForSubCentreForTransferedMember";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addNewTransferMember(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}

		int subcenter = 0;
		if (request.getParameter("subcenter") != null) {
			subcenter = Integer.parseInt(request.getParameter("subcenter"));
			box.put("subcenter", subcenter);
		}

		map = pubHealthHandlerService.addNewTransferMember(box);
		map.putAll(pubHealthHandlerService.showTransferMemberJsp(box));
		/*
		 * boolean successfullyAdded = false; String message = ""; if
		 * (map.get("successfullyAdded") != null) { successfullyAdded =
		 * (Boolean) map.get("successfullyAdded"); } if (map.get("message") !=
		 * null) { message = (String) map.get("message"); } if
		 * (message.equals("")) { if (successfullyAdded) { message =
		 * "Record Added Successfully !!"; } else { message = "Try Again !!"; }
		 * } String backUrl="/hms/hms/pubHealth?method=showTransferMemberJsp";
		 */
		String jsp = "transfer_member_jsp";
		jsp += ".jsp";
		title = "Transferred Member";
		map.put("contentJsp", jsp);
		// map.put("message", message);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	// KM -------------------App Lock Password-----------------

	public ModelAndView showApplockPassword(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);

		map = pubHealthHandlerService.showApplockPassword(box);

		jsp = "applockPassword";
		jsp += ".jsp";
		title = "App Lock Password";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hospitalId", hospitalId);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView detailApplockPassword(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		int empId = (Integer) session.getAttribute("empId");
		box.put("empId", empId);
		map = pubHealthHandlerService.detailApplockPassword(box, details);
		jsp = "applockPassword" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// ---------------- Village ------------

	public ModelAndView getVillageListHouseSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int taluk = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("taluk") != null) {
				taluk = Integer.parseInt(request.getParameter("taluk"));
			}
			dataMap.put("taluk", taluk);
			map = pubHealthHandlerService.getVillageListHouseSurvey(dataMap);
			jsp = "responceForvillageHouseSurvey";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getTalukListHouseSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int district = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("disId") != null) {
				district = Integer.parseInt(request.getParameter("disId"));

			}
			dataMap.put("district", district);
			map = pubHealthHandlerService.getTalukListHouseSurvey(dataMap);
			jsp = "resHouseSurveyTaluk";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView phMemberSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		//System.out.println("controler");
		map = pubHealthHandlerService.phMemberSurvey(box, details);
		jsp = "publicHealthMemberSurvey" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIdspReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		jsp = "idspReport" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printIDSPReport(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		Date fromDate = null;

		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("IDSP_Report", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	public ModelAndView printIDSPLReport(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String, Object> map = new HashMap<String, Object>(); //commented by Om Tripathi unused reference
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		Date fromDate = null;

		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("IDSP_Report_L", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
	}

	// ------------------- OPD Main
	public ModelAndView showPhOpdMainJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);

		try {
			map = pubHealthHandlerService.showPhOpdMainJsp(box);

		} catch (Exception e) {
			e.printStackTrace();
		}
		String jsp = "";
		jsp = "ph_opd_main";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getClassList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int villageSurveyId = 0;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			if (request.getParameter("villageSurveyId") != null
					&& !request.getParameter("villageSurveyId").equals("0")) {
				villageSurveyId = Integer.parseInt(request
						.getParameter("villageSurveyId"));
			}
			dataMap.put("villageSurveyId", villageSurveyId);
			map = pubHealthHandlerService.getClassList(dataMap);

			jsp = "responseClass";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSectionList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String schoolClass = "";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();

			if (request.getParameter("schoolClass") != null
					&& !request.getParameter("schoolClass").equals("0")) {
				schoolClass = request.getParameter("schoolClass");
			}
			dataMap.put("schoolClass", schoolClass);
			map = pubHealthHandlerService.getSectionList(dataMap);

			jsp = "responseSec";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPhStudentRegistrationOpdMainList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String studentName = "";
		int villageSurveyId = 0;
		int sectionId = 0;
		String schoolClass = "";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("studentName") != null) {
				studentName = request.getParameter("studentName");
			}
			if (request.getParameter("sectionId") != null
					&& !request.getParameter("sectionId").equals("0")) {
				sectionId = Integer.parseInt(request.getParameter("sectionId"));
			}
			if (request.getParameter("villageSurveyId") != null
					&& !request.getParameter("villageSurveyId").equals("0")) {
				villageSurveyId = Integer.parseInt(request
						.getParameter("villageSurveyId"));
			}
			if (request.getParameter("schoolClass") != null
					&& !request.getParameter("schoolClass").equals("")) {
				schoolClass = request.getParameter("schoolClass");
			}
			dataMap.put("sectionId", sectionId);
			dataMap.put("schoolClass", schoolClass);
			dataMap.put("studentName", studentName);
			dataMap.put("villageSurveyId", villageSurveyId);

			map = pubHealthHandlerService
					.getPhStudentRegistrationOpdMainList(dataMap);
			jsp = "responseStudentRegistration";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getValueStudentRegistration(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		int studentRegistrationId = 0;
		if (request.getParameter("studentRegistrationId") != null
				&& !request.getParameter("studentRegistrationId").equals("0")) {
			studentRegistrationId = Integer.parseInt(request
					.getParameter("studentRegistrationId"));
		}
		box.put("studentRegistrationId", studentRegistrationId);

		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
			box.put("deptId", deptId);
		}

		// map = pubHealthHandlerService.showDepartmentSpeciality(map);

		map = pubHealthHandlerService.getValueStudentRegistration(box);
		jsp = "ph_valueStudentRegistration";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public void fillDataForDistrictHospitalType(HttpServletRequest request,
			HttpServletResponse response) {
		//HttpSession session = request.getSession();
		//session = request.getSession();

		int hospitalTypeId = 0;
		int districtId = 0;
		List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("districtId") != null
				&& !request.getParameter("districtId").equals("0")) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
		}
		if (request.getParameter("hospitalTypeId") != null
				&& !request.getParameter("hospitalTypeId").equals("0")) {
			hospitalTypeId = Integer.parseInt(request
					.getParameter("hospitalTypeId"));
		}

		dataMap.put("districtId", districtId);
		dataMap.put("hospitalTypeId", hospitalTypeId);

		map = pubHealthHandlerService.fillDataForDistrictHospitalType(dataMap);
		if (map.get("masHospitalList") != null) {
			masHospitalList = (List) map.get("masHospitalList");
		}
System.out.println("masHospitalList "+masHospitalList.size());
		StringBuffer sb = new StringBuffer();
		try {
			for (MasHospital masHospital : masHospitalList) {
				if(masHospital.getId()>=2541 && masHospital.getId()<=2547){
				}else{
				sb.append("<item>");
				sb.append("<hospitalId>" + masHospital.getId()
						+ "</hospitalId>");
				sb.append("<hospitalName>" + masHospital.getHospitalName()
						+ "</hospitalName>");
				sb.append("</item>");
				}
			}

			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
	
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ModelAndView getGroupAndParameterValues(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		Map generalMap = new HashMap();

		HttpSession session = request.getSession();

		String template = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("tempLate") != null
				&& !(request.getParameter("tempLate").equals(""))) {
			template = request.getParameter("tempLate");
		}

		generalMap.put("template", template);
		generalMap.put("deptId", deptId);

		map = pubHealthHandlerService.showGroupAndParameterValues(generalMap);
		String jsp = "ph_responseForSpeciality";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveStudentHealthReg(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("deptId", deptId);

		if (session.getAttribute("userId") != null) {
			int userId = (Integer) session.getAttribute("userId");
			mapForDS.put("userId", userId);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			mapForDS.put("hospitalId", hospitalId);
		}

		int hospitalStudId = 0;
		if (request.getParameter("hospitalId") != null
				&& !(request.getParameter("hospitalId").equals("0"))
				&& !(request.getParameter("hospitalId").equals(""))) {
			hospitalStudId = Integer.parseInt(request
					.getParameter("hospitalId"));
			mapForDS.put("hospitalStudId", hospitalStudId);
		}
		int hospitalTypeId = 0;
		if (request.getParameter("hospitalTypeId") != null
				&& !(request.getParameter("hospitalTypeId").equals("0"))
				&& !(request.getParameter("hospitalTypeId").equals(""))) {
			hospitalTypeId = Integer.parseInt(request
					.getParameter("hospitalTypeId"));
			mapForDS.put("hospitalTypeId", hospitalTypeId);
		}
		int districtId = 0;
		if (request.getParameter("districtId") != null
				&& !(request.getParameter("districtId").equals("0"))
				&& !(request.getParameter("districtId").equals(""))) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			mapForDS.put("districtId", districtId);
		}
		int age = 0;
		if (request.getParameter("age") != null
				&& !(request.getParameter("age").equals("0"))
				&& !(request.getParameter("age").equals(""))) {
			age = Integer.parseInt(request.getParameter("age"));
			mapForDS.put("age", age);
		}
		String allergy = "";
		if (request.getParameter("allergy") != null
				&& !(request.getParameter("allergy").equals(""))) {
			allergy = request.getParameter("allergy");
			mapForDS.put("allergy", allergy);
		}
		String allergyYesText = "";
		if (request.getParameter("allergyYesText") != null
				&& !(request.getParameter("allergyYesText").equals(""))) {
			allergyYesText = request.getParameter("allergyYesText");
			mapForDS.put("allergyYesText", allergyYesText);
		}
		String bcgDueDate = "";
		if (request.getParameter("bcgDueDate") != null
				&& !(request.getParameter("bcgDueDate").equals(""))) {
			bcgDueDate = request.getParameter("bcgDueDate");
			mapForDS.put("bcgDueDate", bcgDueDate);
		}
		String bcgImmDate = "";
		if (request.getParameter("bcgImmDate") != null
				&& !(request.getParameter("bcgImmDate").equals(""))) {
			bcgImmDate = request.getParameter("bcgImmDate");
			mapForDS.put("bcgImmDate", bcgImmDate);
		}
		int dbp = 0;
		if (request.getParameter("dbp") != null
				&& !(request.getParameter("dbp").equals("0"))
				&& !(request.getParameter("dbp").equals(""))) {
			dbp = Integer.parseInt(request.getParameter("dbp"));
			mapForDS.put("dbp", dbp);
		}
		int height = 0;
		if (request.getParameter("height") != null
				&& !(request.getParameter("height").equals("0"))
				&& !(request.getParameter("height").equals(""))) {
			height = Integer.parseInt(request.getParameter("height"));
			mapForDS.put("height", height);
		}
		int weight = 0;
		if (request.getParameter("weight") != null
				&& !(request.getParameter("weight").equals("0"))
				&& !(request.getParameter("weight").equals(""))) {
			weight = Integer.parseInt(request.getParameter("weight"));
			mapForDS.put("weight", weight);
		}
		BigDecimal bmi = new BigDecimal(0);
		if (request.getParameter("bmi") != null
				&& !(request.getParameter("bmi").equals("0"))
				&& !(request.getParameter("bmi").equals(""))) {
			bmi = new BigDecimal(request.getParameter("bmi"));
			mapForDS.put("bmi", bmi);
		}
		String hepatitiesBoDueDate = "";
		if (request.getParameter("hepatitiesBoDueDate") != null
				&& !(request.getParameter("hepatitiesBoDueDate").equals(""))) {
			hepatitiesBoDueDate = request.getParameter("hepatitiesBoDueDate");
			mapForDS.put("hepatitiesBoDueDate", hepatitiesBoDueDate);
		}
		String hepatitiesBoImmDate = "";
		if (request.getParameter("hepatitiesBoImmDate") != null
				&& !(request.getParameter("hepatitiesBoImmDate").equals(""))) {
			hepatitiesBoImmDate = request.getParameter("hepatitiesBoImmDate");
			mapForDS.put("hepatitiesBoImmDate", hepatitiesBoImmDate);
		}
		String opvODueDate = "";
		if (request.getParameter("opvODueDate") != null
				&& !(request.getParameter("opvODueDate").equals(""))) {
			opvODueDate = request.getParameter("opvODueDate");
			mapForDS.put("opvODueDate", opvODueDate);
		}

		String opvOImmDate = "";
		if (request.getParameter("opvOImmDate") != null
				&& !(request.getParameter("opvOImmDate").equals(""))) {
			opvOImmDate = request.getParameter("opvOImmDate");
			mapForDS.put("opvOImmDate", opvOImmDate);
		}
		int pulse = 0;
		if (request.getParameter("pulse") != null
				&& !(request.getParameter("pulse").equals("0"))
				&& !(request.getParameter("pulse").equals(""))) {
			pulse = Integer.parseInt(request.getParameter("pulse"));
			mapForDS.put("pulse", pulse);
		}
		int sbp = 0;
		if (request.getParameter("sbp") != null
				&& !(request.getParameter("sbp").equals("0"))
				&& !(request.getParameter("sbp").equals(""))) {
			sbp = Integer.parseInt(request.getParameter("sbp"));
			mapForDS.put("sbp", sbp);
		}

		int studentId = 0;
		if (request.getParameter("studentId") != null
				&& !(request.getParameter("studentId").equals("0"))
				&& !(request.getParameter("studentId").equals(""))) {
			studentId = Integer.parseInt(request.getParameter("studentId"));
		}
		/*
		 * int actionTakenId=0; if(request.getParameter("actionTakenId")!=null
		 * && !(request.getParameter("actionTakenId").equals("0")) &&
		 * !(request.getParameter("actionTakenId").equals(""))) {
		 * actionTakenId=Integer
		 * .parseInt(request.getParameter("actionTakenId")); }
		 */
		// mapForDS.put("actionTakenId", actionTakenId);
		mapForDS.put("studentId", studentId);
		int skip = 0;
		if (request.getParameter("skip") != null) {
			skip = Integer.parseInt(request.getParameter("skip"));
		}
		/*
		 * int specialtyId=0; if(request.getParameter("specialty")!=null){
		 * specialtyId = Integer.parseInt(request.getParameter("specialty")); }
		 */

		int parameterCounter = Integer.parseInt(request
				.getParameter("parameterCounter"));
		int actionTakenCounter = Integer.parseInt(request
				.getParameter("actionTakenCounter"));
		List<Integer> actionTakenList = new ArrayList<Integer>();
		List<String> parameterList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();

		for (int i = 1; i < parameterCounter; i++) {
			if (request.getParameter("parameterId" + i) != null)
				parameterList.add(request.getParameter("parameterId" + i));
			else
				parameterList.add("");

			if (request.getParameter("textValue" + i) != null)
				valueList.add(request.getParameter("textValue" + i));
			else
				valueList.add("");

			if (request.getParameter("actionTakenId" + i) != null)
				actionTakenList.add(Integer.parseInt(request
						.getParameter("actionTakenId" + i)));
			else
				actionTakenList.add(0);
		}

		// mapForDS.put("actionTakenCounter", actionTakenCounter);
		mapForDS.put("parameterList", parameterList);
		mapForDS.put("valueList", valueList);
		mapForDS.put("actionTakenList", actionTakenList);

		if (parameterList.size() > 0 && parameterList.size() > 0) {
			map = pubHealthHandlerService.saveSpeciality(mapForDS);
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Send Successfully.";
		} else {
			message = "Try Again!";
		}

		map.put("message", message);

		jsp = "msg_student_health_reg";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView shownXmplRepordt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		map = pubHealthHandlerService.getDistrictForXml();

		title = "Xml Report";

		jsp = "xmlReportJsp";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateHMISExcelReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {

		//HttpSession session = request.getSession();//commented by Om Tripathi unused reference
		//Box box = HMSUtil.getBox(request);
		// Map<String, Object> infoMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		String fromDate = null;
		String toDate = null;
		String districtID = null;

		if (request.getParameter(FROM_DATE) != null) {
			fromDate = request.getParameter(FROM_DATE);
		}
		if (request.getParameter(TO_DATE) != null) {
			toDate = request.getParameter(TO_DATE);
		}
		if (request.getParameter("district") != null) {
			districtID = request.getParameter("district");
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String dateSQL1 = formatterOut.format(formatterIn.parse(fromDate));
		String dateSQL2 = formatterOut.format(formatterIn.parse(toDate));

		java.sql.Date startDate = java.sql.Date.valueOf(dateSQL1);
		java.sql.Date endDate = java.sql.Date.valueOf(dateSQL2);

		System.out.println("DistrictID" + districtID);

		/*
		 * String queryForhmisDataExcel=
		 * "SELECT DISTINCT count(pas.*) AS anc , md.district_name AS districtName ,count(trimester) AS Trimester ,"
		 * + //--(count((current_date - date_of_birth)/365)) AS ageb,
		 * //--((current_date - date_of_birth)/365) AS AGE,
		 * " count(pas.jsy_flag != 'Yes') AS JSY," +
		 * " count(paf.tt1) AS TT1, count(paf.tt2) AS TT2 " +
		 * 
		 * " FROM ph_anc_survey pas INNER JOIN mas_hospital mh ON pas.hospital_id= mh.hospital_id"
		 * +
		 * " INNER JOIN mas_district md ON mh.district_id= md.district_id INNER JOIN ph_anc_termination_m patm ON pas.anc_reg_id=patm.anc_reg_id  "
		 * +
		 * " INNER JOIN ph_member_survey pms ON pas.member_id= pms.member_id   "
		 * +
		 * " INNER JOIN ph_anc_followup paf ON  pas.anc_reg_id=paf.anc_reg_id  "
		 * + " where  mh.district_id ="+districtID+"
		 * 
		 * " group BY md.district_name  ";
		 */

		String queryForhmisDataExcel = "select "
				+

				"(select count(*) as t1 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  "
				+ "    where district_id="
				+ districtID
				+ " and reg_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+ ",(select count((current_date - date_of_birth)/365) as t2 from ph_anc_survey pas "
				+ "left outer join ph_member_survey  pms on pas.member_id=pms.member_id  left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id "
				+ " where ((current_date - date_of_birth)/365) < 19  and district_id="
				+ districtID
				+ " and reg_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				" ,(select count(*) as t3 from ph_anc_survey pas left outer join mas_hospital mh on mh.hospital_id=pas.hospital_id  where lower(jsy_flag) =lower('Yes') and district_id="
				+ districtID
				+ " and reg_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+ ",(select count(*) as t4 from (select count(*) as cnt from ph_anc_followup  anc left outer join ph_anc_survey  anf on anc.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=anf.hospital_id  where mh.district_id="
				+ districtID
				+ " and followup_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' group by  anc.anc_reg_id having count(*)>3) t1 )  "
				+

				",(select count(*) as t5 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
				+ districtID
				+ " and followup_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' and tt1 is not null ) "
				+

				",(select count(*) as t6 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
				+ districtID
				+ " and followup_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' and  tt2 is not null ) "
				+

				",(select count(*) as t7 from ph_anc_followup  anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
				+ districtID
				+ " and followup_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' and iron_folic_qty  in ('100')) "
				+

				",(select count(*) as t8 from ph_anc_followup anf left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id  where mh.district_id="
				+ districtID
				+ " and followup_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' and iron_folic_qty  in ('200') ) "
				+

				",(select count(*) as t9 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
				+ districtID
				+ "  and reg_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' and delivery_place ='Home' )  "
				+

				",(select count(*) as t10 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
				+ districtID
				+ " and attended_by  in ('Doctor')  and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')"
				+

				",(select count(*) as t11  from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
				+ districtID
				+ " and attended_by in('Trained birth Attendant') and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t12 from ph_anc_termination_m pat left outer join  mas_hospital mh on mh.hospital_id=pat.hospital_id where mh.district_id="
				+ districtID
				+ "    and attended_by in('Trained birth Attendant','Doctor','Specialist Doctor','Untrained birth Attendant')  and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				",(select count(*) as t13 from ph_birth_death_reg pbr left outer join  mas_hospital mh on mh.hospital_id=pbr.hospital_id where mh.district_id="
				+ districtID
				+ " and delivery_place ='Government Hospital' and reg_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t14 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='PHC' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
				+ districtID
				+ " and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t15 from ph_anc_termination_m ptm left outer join mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id where mt.hospital_type_code='CHC' and ptm.delivery_type = 'C-Section(LSCS)' and  mh.district_id="
				+ districtID
				+ " and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",( select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where mt.hospital_type_code='DH' and ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
				+ districtID
				+ " and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				",(select count(*) as t17 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and delivery_out_come='Live Birth' and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t18 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and delivery_out_come='Live Birth' and gender_id = 3 and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				",(select count(*) as t19 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id  left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and delivery_out_come='Live Birth' and gender_id = 2 and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')"
				+

				",(select count(*) as t20 from ph_anc_termination_t anf left outer join ph_anc_termination_m patm on  anf.anc_reg_id=patm.anc_reg_id left outer join ph_anc_survey pas on pas.anc_reg_id=anf.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and delivery_out_come='Still Birth' and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' )"
				+

				",(select count(*) as t21 from ph_anc_survey pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and abortions in('1','2','3','4','5','6','7','8','9','10') and reg_date  between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "' ) "
				+

				",(select count(*) as t22 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and reg_type ='birth' and birth_weigth is not null  and reg_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				",(select count(*) as t23 from ph_birth_death_reg pas left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and reg_type ='birth' and birth_weigth < 2.50  and reg_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')  "
				+

				",(select count(*) as t24 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '84' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')"
				+

				",(select count(*) as t25 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and lmp_date between pas.lmp_date  and  lmp_date + integer '86' and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t26 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and termination_type='mtp' and anf.refer_to_type > 0 and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "') "
				+

				",(select count(*) as t27 from ph_anc_termination_m  pntm left outer join  ph_anc_survey  pas on  pas.anc_reg_id=pntm.anc_reg_id left outer join ph_anc_followup  anf on anf.anc_reg_id=pas.anc_reg_id left outer join  mas_hospital mh on mh.hospital_id=pas.hospital_id where mh.district_id="
				+ districtID
				+ " and termination_type='mtp' and anf.refer_to_type = 0 and termination_date between  '"
				+ startDate
				+ "' and '"
				+ endDate
				+ "')"
				+

				",(select district_name as disName from mas_district where district_id  ="
				+ districtID
				+ ")"
				+ ",(select count(*) as t16 from ph_anc_termination_m ptm left outer join  mas_hospital mh on  ptm.hospital_id=mh.hospital_id left outer join mas_hospital_type mt on mt.hospital_type_id=mh.hospital_type_id  where  ptm.delivery_type = 'C-Section(LSCS)' and mh.district_id="
				+ districtID
				+ " and termination_date between  '"
				+ startDate
				+ "' and '" + endDate + "')";

		System.out.println("list" + queryForhmisDataExcel.length());

		List<Object[]> aList = new ArrayList<Object[]>();

		aList = pubHealthHandlerService
				.generateHMISExcelReport(queryForhmisDataExcel);

		try {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition",
					"attachment; filename=HMIS_Data.xls");

			WritableWorkbook wb = Workbook.createWorkbook(response
					.getOutputStream());
			WritableSheet ws = wb.createSheet("HMIS Data", 0);
			// ws.setProtected(true);

			WritableFont wf = new WritableFont(WritableFont.ARIAL, 15,
					WritableFont.BOLD);
			wf.setUnderlineStyle(UnderlineStyle.SINGLE);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf.setAlignment(Alignment.CENTRE);

			WritableFont wfForFooter = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD);
			wfForFooter.setUnderlineStyle(UnderlineStyle.SINGLE);
			WritableCellFormat wcForFooter = new WritableCellFormat(wfForFooter);
			wcForFooter.setAlignment(Alignment.CENTRE);

			WritableFont wf2 = new WritableFont(WritableFont.ARIAL, 11,
					WritableFont.BOLD);
			WritableCellFormat wcf2 = new WritableCellFormat(wf2);
			wcf2.setWrap(true);
			wcf2.setShrinkToFit(true);
			wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf2.setVerticalAlignment(VerticalAlignment.TOP);

			WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10);
			WritableCellFormat wcf3 = new WritableCellFormat(wf3);
			wcf3.setWrap(true);
			wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf3.setVerticalAlignment(VerticalAlignment.TOP);
			;

			WritableFont wf21 = new WritableFont(WritableFont.ARIAL, 11,
					WritableFont.BOLD);
			WritableCellFormat wcf21 = new WritableCellFormat(wf2);
			wcf21.setWrap(true);
			wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf21.setVerticalAlignment(VerticalAlignment.TOP);
			wcf21.setBackground(Colour.GREY_25_PERCENT);

			WritableFont wf5 = new WritableFont(WritableFont.ARIAL, 11,
					WritableFont.BOLD);
			WritableCellFormat wcf5 = new WritableCellFormat(wf2);
			wcf5.setWrap(true);
			wcf5.setBorder(Border.ALL, BorderLineStyle.THIN);
			wcf5.setVerticalAlignment(VerticalAlignment.TOP);
			wcf5.setBackground(Colour.LIGHT_BLUE);

			ws.mergeCells(0, 0, 5, 0);
			Label label = new Label(0, 0,
					"Organisation Unit Wise Progress Report", wcf);
			ws.addCell(label);

			label = new Label(0, 2, "Facility", wcf2);
			ws.addCell(label);
			label = new Label(1, 2, "KERALA", wcf2);
			ws.addCell(label);

			label = new Label(0, 4, "From", wcf2);
			ws.addCell(label);
			label = new Label(1, 4, fromDate, wcf3);
			ws.addCell(label);

			label = new Label(2, 4, "To", wcf2);
			ws.addCell(label);
			label = new Label(3, 4, toDate, wcf3);
			ws.addCell(label);

			String districtName = ""; //

			String ancCount = ""; //
			String less19 = ""; //
			String jyFlag = ""; //
			String anc3 = ""; //

			String TT1 = ""; //
			String TT2 = ""; //
			String IFA100 = ""; //
			String IFA200 = ""; //

			String homeDilevery = ""; //

			String docAttand = ""; //
			String trainedbirthAttendant = ""; //
			String attandCount = ""; //
			String govDilevry = ""; //

			String cSectionPhc = ""; //
			String cSectionChc = ""; //

			String SectionDH = ""; //
			String totalCounCsection = ""; //

			String liveBirth = ""; //
			String liveBirthMale = "";
			String liveBirthfeMale = "";
			String tillBirthcount = ""; //
			String abortions = ""; //

			String birth_weigth = "";
			String birthless = "";

			String mtpReferr = "";
			String mtpReferr2 = "";
			String mtpReferrGov = "";
			String mtpReferrNonGov = "";

			for (Object[] obj1 : aList) {

				districtName = "" + obj1[27];
				ancCount = "" + obj1[0];
				less19 = "" + obj1[1];
				jyFlag = "" + obj1[2];
				anc3 = "" + obj1[3];

				TT1 = "" + obj1[4];
				TT2 = "" + obj1[5];
				IFA100 = "" + obj1[6];
				IFA200 = "" + obj1[7];

				docAttand = "" + obj1[9];
				trainedbirthAttendant = "" + obj1[10];
				attandCount = "" + obj1[11];
				govDilevry = "" + obj1[12];

				cSectionPhc = "" + obj1[13];
				cSectionChc = "" + obj1[14];
				SectionDH = "" + obj1[15];
				totalCounCsection = "" + obj1[28];

				liveBirth = "" + obj1[16];
				liveBirthMale = "" + obj1[17];
				liveBirthfeMale = "" + obj1[18];
				tillBirthcount = "" + obj1[19];
				abortions = "" + obj1[20];

				birth_weigth = "" + obj1[21];
				birthless = "" + obj1[22];

				mtpReferr = "" + obj1[23];
				mtpReferr2 = "" + obj1[24];
				mtpReferrGov = "" + obj1[25];
				mtpReferrNonGov = "" + obj1[26];

				/*
				 * JSY=""+obj1[3]; TT1=""+obj1[4]; TT2=""+obj1[5];
				 * 
				 * ageb=""+obj1[3]; anccheckups=""+obj1[4]; IFA100=""+obj1[3];
				 * IFA200=""+obj1[3]; newinstitution=""+obj1[3];
				 * pregnancykit=""+obj1[3];
				 */

			}

			label = new Label(3, 7, districtName, wcf2);
			ws.addCell(label);

			CellView cell = new CellView();
			cell.setSize(3000);
			ws.setColumnView(0, cell);
			cell.setSize(15000);
			ws.setColumnView(1, cell);
			cell.setSize(7000);
			ws.setColumnView(2, cell);
			cell.setSize(4000);
			ws.setColumnView(3, cell);
			cell.setSize(4000);
			ws.setColumnView(4, cell);
			cell.setSize(4000);
			/*
			 * ws.setColumnView(5, cell); cell.setSize(4000);
			 * ws.setColumnView(6, cell); cell.setSize(4000);
			 * ws.setColumnView(7, cell); cell.setSize(4000);
			 * ws.setColumnView(8, cell); cell.setSize(4000);
			 * ws.setColumnView(9, cell); cell.setSize(4000);
			 * ws.setColumnView(10, cell); cell.setSize(4000);
			 * ws.setColumnView(11, cell); cell.setSize(4000);
			 * ws.setColumnView(11, cell); cell.setSize(4000);
			 * ws.setColumnView(12, cell); cell.setSize(6000);
			 * ws.setColumnView(13, cell); cell.setSize(8000);
			 * ws.setColumnView(14, cell); cell.setSize(4000);
			 * ws.setColumnView(15, cell); cell.setSize(4000);
			 * ws.setColumnView(16, cell); cell.setSize(4000);
			 * ws.setColumnView(17, cell);
			 * 
			 * label = new Label(3, 7, "ALAPPUZHA District", wcf2);
			 * ws.addCell(label); label = new Label(4, 7, "ERNAKULAM District",
			 * wcf2); ws.addCell(label); label = new Label(5, 7,
			 * "IDUKKI District", wcf2); ws.addCell(label); label = new Label(6,
			 * 7, "KANNUR District", wcf2); ws.addCell(label); label = new
			 * Label(7, 7, "KASARAGOD District", wcf2); ws.addCell(label); label
			 * = new Label(8, 7, "KOLLAM District", wcf2); ws.addCell(label);
			 * label = new Label(9, 7, "KOTTAYAM District", wcf2);
			 * ws.addCell(label); label = new Label(10, 7, "KOZHIKODE District",
			 * wcf2); ws.addCell(label); label = new Label(11, 7,
			 * "MALAPPURAM District", wcf2); ws.addCell(label); label = new
			 * Label(12, 7, "PALAKKAD District", wcf2); ws.addCell(label); label
			 * = new Label(13, 7, "PATHANAMTHITTA District", wcf2);
			 * ws.addCell(label); label = new Label(14, 7,
			 * "THIRUVANANTHAPURAM District", wcf2); ws.addCell(label); label =
			 * new Label(15, 7, "THRISSUR District", wcf2); ws.addCell(label);
			 * label = new Label(16, 7, "WAYANAD District", wcf2);
			 * ws.addCell(label); label = new Label(17, 7, "KERALA", wcf2);
			 * ws.addCell(label);
			 */
			ws.mergeCells(0, 7, 2, 7);
			label = new Label(0, 7, "", wcf3);
			ws.addCell(label);
			label = new Label(0, 8, "Part A", wcf21);
			ws.addCell(label);
			label = new Label(1, 8, "REPRODUCTIVE AND CHILD HEALTH", wcf21);
			ws.addCell(label);
			label = new Label(2, 8, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 9, "M1", wcf5);
			ws.addCell(label);
			label = new Label(1, 9, "Ante Natal Care Services ANC", wcf5);
			ws.addCell(label);
			label = new Label(2, 9, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 10, "1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 10,
					"Total number of pregnant women Registered for ANC", wcf3);
			ws.addCell(label);
			label = new Label(2, 10, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 10, ancCount, wcf3);
			ws.addCell(label);

			label = new Label(0, 11, "1.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 11,
					"Of which Number registered within first trimester", wcf3);
			ws.addCell(label);
			label = new Label(2, 11, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 11, "", wcf3);
			ws.addCell(label);

			label = new Label(0, 12, "1.1.2", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					12,
					"Of Total ANC registered Number of pregnant women registered for ANC under 19 year",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 12, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 12, less19, wcf3);
			ws.addCell(label);

			label = new Label(0, 13, "1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 13, "New women registered under JSY", wcf3);
			ws.addCell(label);
			label = new Label(2, 13, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 13, jyFlag, wcf3);
			ws.addCell(label);

			label = new Label(0, 14, "1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 14,
					"Number of pregnant women received 3 ANC check ups", wcf3);
			ws.addCell(label);

			label = new Label(2, 14, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 14, anc3, wcf3);
			ws.addCell(label);

			label = new Label(0, 15, "1.4", wcf21);
			ws.addCell(label);
			label = new Label(1, 15, "Number of pregnant women given", wcf21);
			ws.addCell(label);
			label = new Label(2, 15, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 16, "1.4.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 16, "TT1", wcf3);
			ws.addCell(label);
			label = new Label(2, 16, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 16, TT1, wcf3);
			ws.addCell(label);

			label = new Label(0, 17, "1.4.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 17, "TT2 or Booster", wcf3);
			ws.addCell(label);
			label = new Label(2, 17, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 17, TT2, wcf3);
			ws.addCell(label);

			label = new Label(0, 18, "1.5", wcf3);
			ws.addCell(label);
			label = new Label(1, 18,
					"Total number of pregnant women given 100 IFA tablets",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 18, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 18, IFA100, wcf3);
			ws.addCell(label);

			label = new Label(0, 19, "1.6", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					19,
					"Total number of pregnant women given 200 IFA tablets (Therapeutic)",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 19, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 19, IFA200, wcf3);
			ws.addCell(label);

			label = new Label(0, 20, "1.7", wcf3);
			ws.addCell(label);
			label = new Label(1, 20,
					"Pregnant women with Hypertension (BP>140/90)", wcf3);
			ws.addCell(label);
			label = new Label(2, 20, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 21, "1.6.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 21, "New cases detected at institution", wcf3);
			ws.addCell(label);
			label = new Label(2, 21, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 22, "1.6.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 22,
					"Number of Eclampsia cases managed during delivery", wcf3);
			ws.addCell(label);
			label = new Label(2, 22, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 23, "1.7", wcf21);
			ws.addCell(label);
			label = new Label(1, 23, "Pregnant women with Anaemia", wcf21);
			ws.addCell(label);
			label = new Label(2, 23, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 24, "1.7.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 24,
					"Number having Hb level<11 (tested cases)", wcf3);
			ws.addCell(label);
			label = new Label(2, 24, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 25, "1.7.2", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					25,
					"Number having severe anaemia (Hb<7) treated at institution",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 25, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 26, "1.8", wcf3);
			ws.addCell(label);
			label = new Label(1, 26, "Number of Pregnancy test kits used", wcf3);
			ws.addCell(label);
			label = new Label(2, 26, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 27, "M2", wcf5);
			ws.addCell(label);
			label = new Label(1, 27, "Deliveries", wcf5);
			ws.addCell(label);
			label = new Label(2, 27, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 28, "2.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 28, "Deliveries conducted at Home:", wcf21);
			ws.addCell(label);
			label = new Label(2, 28, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 29, "2.1.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 29, "Number of Home Deliveries attended by:",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 29, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 30, "2.1.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 30, "SBA Trained (Doctor/Nurse/ANM)", wcf3);
			ws.addCell(label);
			label = new Label(2, 30, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 30, docAttand, wcf3);
			ws.addCell(label);
			label = new Label(0, 31, "2.1.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 31, "Non SBA (Trained TBA/Relatives/etc.)",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 31, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 31, trainedbirthAttendant, wcf3);
			ws.addCell(label);
			label = new Label(0, 32, "2.1.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 32, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 32, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 32, attandCount, wcf3);
			ws.addCell(label);
			label = new Label(0, 33, "2.1.2", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					33,
					"Number of newborns visited within 24 hours of Home Delivery",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 33, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 34, "2.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 34, "Delivery with two or more babies", wcf3);
			ws.addCell(label);
			label = new Label(2, 34, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 35, "2.1.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 35,
					"Number of mothers paid JSY incentive for Home deliveries",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 35, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 36, "2.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 36,
					"Deliveries conducted at Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 36, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 36, govDilevry, wcf3);
			ws.addCell(label);
			label = new Label(0, 37, "2.2.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 37,
					"Of which Number discharged under 48 hours of delivery",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 37, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 38, "2.2.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 38,
					"Number of cases where JSY incentive paid to", wcf21);
			ws.addCell(label);
			label = new Label(2, 38, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 39, "2.2.2.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 39, "Mothers", wcf3);
			ws.addCell(label);
			label = new Label(2, 39, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 40, "2.2.2.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 40, "ASHAs", wcf3);
			ws.addCell(label);
			label = new Label(2, 40, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 41, "2.2.2.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 41, "ANM or AWW (only for HPS States)", wcf3);
			ws.addCell(label);
			label = new Label(2, 41, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 42, "2.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 42,
					"Number of Deliveries  at accredited Private Institutions",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 42, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 43, "2.3.1", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					43,
					"Number of institutional delivery cases where JSY incentive paid to",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 43, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 44, "2.3.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 44, "Mothers", wcf3);
			ws.addCell(label);
			label = new Label(2, 44, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 45, "2.3.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 45, "ASHAs", wcf3);
			ws.addCell(label);
			label = new Label(2, 45, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 46, "2.3.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 46, "ANM or AWW (only for HPS States)", wcf3);
			ws.addCell(label);
			label = new Label(2, 46, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 47, "M3", wcf5);
			ws.addCell(label);
			label = new Label(1, 47,
					"Number of Caesarean C-Section deliveries performed at",
					wcf5);
			ws.addCell(label);
			label = new Label(2, 47, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 48, "3.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 48, "Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 48, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 49, "3.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 49, "PHC", wcf3);
			ws.addCell(label);
			label = new Label(2, 49, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 49, cSectionPhc, wcf3);
			ws.addCell(label);

			label = new Label(0, 50, "3.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 50, "CHC", wcf3);
			ws.addCell(label);
			label = new Label(2, 50, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 50, cSectionChc, wcf3);
			ws.addCell(label);

			label = new Label(0, 51, "3.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 51,
					"Sub-divisional hospital/District Hospital", wcf3);
			ws.addCell(label);
			label = new Label(2, 51, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 51, SectionDH, wcf3);
			ws.addCell(label);

			label = new Label(0, 52, "3.1.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 52,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 52, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 53, "3.1.5", wcf3);
			ws.addCell(label);
			label = new Label(1, 53, "Total{(3.1.1) to (3.1.4)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 53, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 53, totalCounCsection, wcf3);
			ws.addCell(label);

			label = new Label(0, 54, "3.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 54, "Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 54, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 55, "M4", wcf5);
			ws.addCell(label);
			label = new Label(1, 55, "Pregnancy outcome & weight of new-born",
					wcf5);
			ws.addCell(label);
			label = new Label(2, 55, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 56, "4.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 56, "Pregnancy Outcome (in number)", wcf21);
			ws.addCell(label);
			label = new Label(2, 56, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 57, "4.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 57, "Live Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 57, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 57, liveBirth, wcf3);
			ws.addCell(label);
			label = new Label(0, 58, "4.1.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 58, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 58, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 58, liveBirthMale, wcf3);
			ws.addCell(label);
			label = new Label(0, 59, "4.1.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 59, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 59, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 59, liveBirthfeMale, wcf3);
			ws.addCell(label);
			label = new Label(0, 60, "4.1.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 60, "Total ({a} + {b})", wcf3);
			ws.addCell(label);
			label = new Label(2, 60, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 60, liveBirth, wcf3);
			ws.addCell(label);
			label = new Label(0, 61, "4.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 61, "Still Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 61, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(3, 61, tillBirthcount, wcf3);
			ws.addCell(label);

			label = new Label(0, 62, "4.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 62, "Abortion (spontaneous/induced)", wcf3);
			ws.addCell(label);
			label = new Label(2, 62, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 62, abortions, wcf3);
			ws.addCell(label);

			label = new Label(0, 63, "4.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 63, "Details of Newborn children weighed",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 63, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 64, "4.2.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 64, "Number of Newborns weighed at birth",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 64, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 64, birth_weigth, wcf3);
			ws.addCell(label);

			label = new Label(0, 65, "4.2.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 65,
					"Number of Newborns having weight less than 2.5 kg", wcf3);
			ws.addCell(label);
			label = new Label(2, 65, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 65, birthless, wcf3);
			ws.addCell(label);
			label = new Label(0, 66, "4.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 66,
					"Number of Newborns breast fed within 1 hour", wcf3);
			ws.addCell(label);
			label = new Label(2, 66, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 67, "M5", wcf5);
			ws.addCell(label);
			label = new Label(1, 67, "Complicated pregnanices", wcf5);
			ws.addCell(label);
			label = new Label(2, 67, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 68, "5.1", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					68,
					"Number of cases of pregnant women with Obstetric Complications and attended at Public facilities",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 68, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 69, "5.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 69, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 69, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 70, "5.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 70, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 70, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 71, "5.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 71,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 71, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 72, "5.1.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 72,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 72, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 73, "5.1.5", wcf3);
			ws.addCell(label);
			label = new Label(1, 73, "Total {(5.1.1) to (5.1.4)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 73, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 74, "5.2", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					74,
					"Number of cases of pregnant women with Obstetric Complications and attended at Private facilities",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 74, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 75, "5.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 75,
					"Number of Complicated pregnancies treated with", wcf21);
			ws.addCell(label);
			label = new Label(2, 75, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 76, "5.3.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 76, "IV antibiotics", wcf3);
			ws.addCell(label);
			label = new Label(2, 76, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 77, "5.3.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 77, "IV antihypertensive/Magsulph injection",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 77, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 78, "5.3.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 78, "IV Oxytocis", wcf3);
			ws.addCell(label);
			label = new Label(2, 78, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 79, "5.3.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 79, "Blood Transfusion", wcf3);
			ws.addCell(label);
			label = new Label(2, 79, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 80, "M6", wcf5);
			ws.addCell(label);
			label = new Label(1, 80, "Post - Natal Care", wcf5);
			ws.addCell(label);
			label = new Label(2, 80, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 81, "6.1", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					81,
					"Women receiving post partum check-up within 48 hours after delivery",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 81, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 82, "6.2", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					82,
					"Women getting a post partum check up between 48 hours and 14 days",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 82, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 83, "6.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 83, "PNC maternal complications attended",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 83, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 84, "M7", wcf5);
			ws.addCell(label);
			label = new Label(1, 84, "Medical Termination of Pregnancy (MTP)",
					wcf5);
			ws.addCell(label);
			label = new Label(2, 84, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 85, "7.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 85,
					"Number of MTPs conducted at Public Institutions", wcf21);
			ws.addCell(label);
			label = new Label(2, 85, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 86, "7.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 86, "Up to 12 weeks of pregnancy", wcf3);
			ws.addCell(label);
			label = new Label(2, 86, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 86, mtpReferr, wcf3);
			ws.addCell(label);
			label = new Label(0, 87, "7.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 87, "More than 12 weeks of pregnancy", wcf3);
			ws.addCell(label);
			label = new Label(2, 87, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 87, mtpReferr2, wcf3);
			ws.addCell(label);
			label = new Label(0, 88, "7.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 88, "Total {(7.1.1) to (7.1.2)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 88, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 88, mtpReferrGov, wcf3);
			ws.addCell(label);
			label = new Label(0, 89, "7.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 89,
					"Number of MTPs conducted at Private Facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 86, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(3, 89, mtpReferrNonGov, wcf3);
			ws.addCell(label);

			label = new Label(0, 90, "M8", wcf5);
			ws.addCell(label);
			label = new Label(1, 90, "RTI/STI Cases", wcf5);
			ws.addCell(label);
			label = new Label(2, 90, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 91, "8.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 91,
					"Number of new RTI/STI for which treatment initiated",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 91, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 92, "8.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 92, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 92, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 93, "8.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 93, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 93, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 94, "8.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 94, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 94, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 95, "8.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 95, "Number of wet mount tests conducted",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 95, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 96, "M9", wcf5);
			ws.addCell(label);
			label = new Label(1, 96, "Family Planning", wcf5);
			ws.addCell(label);
			label = new Label(2, 96, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 97, "9.01", wcf21);
			ws.addCell(label);
			label = new Label(1, 97,
					"Number of NSV/Conventional Vasectomy conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 97, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 98, "9.1.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 98, "At Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 98, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 99, "9.1.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 99, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 99, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 100, "9.1.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 100, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 100, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 101, "9.1.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 101,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 101, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 102, "9.1.1.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 102,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 102, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 103, "9.1.1.e", wcf3);
			ws.addCell(label);
			label = new Label(1, 103, "Total {(a) to (d)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 103, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 104, "9.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 104, "At Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 104, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 105, "9.02", wcf21);
			ws.addCell(label);
			label = new Label(1, 105,
					"Number of Laparoscopic sterilizations conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 105, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 106, "9.2.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 106, "At Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 106, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 107, "9.2.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 107, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 107, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 108, "9.2.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 108, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 108, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 109, "9.2.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 109,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 109, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 110, "9.2.1.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 110,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 110, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 111, "9.2.1.e", wcf3);
			ws.addCell(label);
			label = new Label(1, 111, "Total {(a) to (d)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 111, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 112, "9.2.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 112, "At Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 112, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 113, "9.03", wcf21);
			ws.addCell(label);
			label = new Label(1, 113,
					"Number of Mini-lap sterilizations conducted ", wcf21);
			ws.addCell(label);
			label = new Label(2, 113, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 114, "9.3.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 114, "At Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 114, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 115, "9.3.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 115, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 115, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 116, "9.3.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 116, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 116, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 117, "9.3.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 117,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 117, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 118, "9.3.1.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 118,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 118, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 119, "9.3.1.e", wcf3);
			ws.addCell(label);
			label = new Label(1, 119, "Total {(a) to (d)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 119, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 120, "9.3.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 120, "At Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 120, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 121, "9.04", wcf21);
			ws.addCell(label);
			label = new Label(1, 121,
					"Number of Post-Partum sterilizations conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 121, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 122, "9.4.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 122, "Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 122, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 123, "9.4.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 123, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 123, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 124, "9.4.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 124, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 124, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 125, "9.4.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 125,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 125, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 126, "9.4.1.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 126,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 126, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 127, "9.4.1.e", wcf3);
			ws.addCell(label);
			label = new Label(1, 127, "Total {(a) to (d)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 127, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 128, "9.4.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 128, "Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 128, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 129, "9.05", wcf21);
			ws.addCell(label);
			label = new Label(1, 129, "Number of IUD Insertions", wcf21);
			ws.addCell(label);
			label = new Label(2, 129, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 130, "9.5.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 130, "Public facilities", wcf21);
			ws.addCell(label);
			label = new Label(2, 130, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 131, "9.5.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 131, "At PHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 131, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 132, "9.5.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 132, "At CHCs", wcf3);
			ws.addCell(label);
			label = new Label(2, 132, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 133, "9.5.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 133,
					"At Sub-divisional hospitals/ District Hospitals", wcf3);
			ws.addCell(label);
			label = new Label(2, 133, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 134, "9.5.1.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 134,
					"At Other State Owned Public Institutions", wcf3);
			ws.addCell(label);
			label = new Label(2, 134, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 135, "9.5.1.e", wcf3);
			ws.addCell(label);
			label = new Label(1, 135, "Total {(a) to (d)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 135, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 136, "9.5.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 136, "Private facilities", wcf3);
			ws.addCell(label);
			label = new Label(2, 136, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 137, "9.5.3", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					137,
					"Out of 9.5.1.f, Post partum (within 48 hours of delilvery) IUCD insertions",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 137, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 138, "9.06", wcf3);
			ws.addCell(label);
			label = new Label(1, 138, "Number of IUD removals", wcf3);
			ws.addCell(label);
			label = new Label(2, 138, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 139, "9.07", wcf3);
			ws.addCell(label);
			label = new Label(1, 139,
					"Number of Oral Pills cycles distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 139, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 140, "9.08", wcf3);
			ws.addCell(label);
			label = new Label(1, 140, "Number of Condom pieces distributed",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 140, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 141, "9.09", wcf3);
			ws.addCell(label);
			label = new Label(1, 141,
					"Number of Centchroman (weekly) pills given", wcf3);
			ws.addCell(label);
			label = new Label(2, 141, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 142, "9.10", wcf3);
			ws.addCell(label);
			label = new Label(1, 142,
					"Number of Emergency Contraceptive Pills distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 142, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 143, "9.11", wcf3);
			ws.addCell(label);
			label = new Label(1, 143, "Eligible couples for Sterilization",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 143, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 144, "9.12", wcf3);
			ws.addCell(label);
			label = new Label(1, 144,
					"Condom units (6(0, ieces) distributed for NSV cases", wcf3);
			ws.addCell(label);
			label = new Label(2, 144, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 145, "9.11", wcf21);
			ws.addCell(label);
			label = new Label(1, 145, "Quality in sterilization services",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 145, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 146, "9.11.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 146,
					"Number of complications following sterilization", wcf21);
			ws.addCell(label);
			label = new Label(2, 146, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 147, "9.11.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 147, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 147, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 148, "9.11.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 148, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 148, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 149, "9.11.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 149,
					"Number of failures following sterilization", wcf21);
			ws.addCell(label);
			label = new Label(2, 149, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 150, "9.11.2.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 150, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 150, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 151, "9.11.2.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 151, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 151, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 152, "9.11.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 152,
					"Number of deaths following sterilization", wcf21);
			ws.addCell(label);
			label = new Label(2, 152, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 153, "9.11.3.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 153, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 153, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 154, "9.11.3.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 154, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 154, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 155, "9.12", wcf3);
			ws.addCell(label);
			label = new Label(1, 155,
					"Number of Institutions having NSV trained doctors", wcf3);
			ws.addCell(label);
			label = new Label(2, 155, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 156, "M10", wcf5);
			ws.addCell(label);
			label = new Label(1, 156, "CHILD IMMUNIZATION", wcf5);
			ws.addCell(label);
			label = new Label(2, 156, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 157, "10.1", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					157,
					"Number of Infants 0 to 11 months old who received the following:",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 157, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 158, "10.1.01", wcf3);
			ws.addCell(label);
			label = new Label(1, 158, "BCG", wcf3);
			ws.addCell(label);
			label = new Label(2, 158, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 159, "10.1.02", wcf3);
			ws.addCell(label);
			label = new Label(1, 159, "DPT1", wcf3);
			ws.addCell(label);
			label = new Label(2, 159, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 160, "10.1.03", wcf3);
			ws.addCell(label);
			label = new Label(1, 160, "Pentavalent - 1", wcf3);
			ws.addCell(label);
			label = new Label(2, 160, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 161, "10.1.04", wcf3);
			ws.addCell(label);
			label = new Label(1, 161, "DPT2", wcf3);
			ws.addCell(label);
			label = new Label(2, 161, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 162, "10.1.05", wcf3);
			ws.addCell(label);
			label = new Label(1, 162, "Pentavalent - 2", wcf3);
			ws.addCell(label);
			label = new Label(2, 162, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 163, "10.1.06", wcf3);
			ws.addCell(label);
			label = new Label(1, 163, "DPT3", wcf3);
			ws.addCell(label);
			label = new Label(2, 163, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 164, "10.1.07", wcf3);
			ws.addCell(label);
			label = new Label(1, 164, "Pentavalent - 3", wcf3);
			ws.addCell(label);
			label = new Label(2, 164, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 165, "10.1.08", wcf3);
			ws.addCell(label);
			label = new Label(1, 165, "OPV 0 (Birth Dose)", wcf3);
			ws.addCell(label);
			label = new Label(2, 165, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 166, "10.1.09", wcf3);
			ws.addCell(label);
			label = new Label(1, 166, "OPV1", wcf3);
			ws.addCell(label);
			label = new Label(2, 166, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 167, "10.1.10", wcf3);
			ws.addCell(label);
			label = new Label(1, 167, "OPV2", wcf3);
			ws.addCell(label);
			label = new Label(2, 167, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 168, "10.1.11", wcf3);
			ws.addCell(label);
			label = new Label(1, 168, "OPV3", wcf3);
			ws.addCell(label);
			label = new Label(2, 168, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 169, "10.1.12", wcf3);
			ws.addCell(label);
			label = new Label(1, 169, "Hepatitis-B0", wcf3);
			ws.addCell(label);
			label = new Label(2, 169, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 170, "10.1.13", wcf3);
			ws.addCell(label);
			label = new Label(1, 170, "Hepatitis-B1", wcf3);
			ws.addCell(label);
			label = new Label(2, 170, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 171, "10.1.14", wcf3);
			ws.addCell(label);
			label = new Label(1, 171, "Hepatitis-B2", wcf3);
			ws.addCell(label);
			label = new Label(2, 171, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 172, "10.1.15", wcf3);
			ws.addCell(label);
			label = new Label(1, 172, "Hepatitis-B3", wcf3);
			ws.addCell(label);
			label = new Label(2, 172, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 173, "10.1.16", wcf3);
			ws.addCell(label);
			label = new Label(1, 173, "Measles", wcf3);
			ws.addCell(label);
			label = new Label(2, 173, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 174, "10.1.17", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					174,
					"Number of Children between Age Group 9-12 Months Given JE 1st Dose",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 174, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 175, "10.1.17", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					175,
					"Total number of children aged between 9 and 11 months who have been fully immunised (BCG+DPT123+OPV123+Measles) during the month",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 175, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 176, "10.1.17.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 176, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 176, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 177, "10.1.17.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 177, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 177, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 178, "10.1.17.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 178, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 178, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 179, "10.2", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					179,
					"Number of children more than 16 months who received the following",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 179, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 180, "10.2.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 180, "DPT Booster", wcf3);
			ws.addCell(label);
			label = new Label(2, 180, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 181, "10.2.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 181, "OPV Booster", wcf3);
			ws.addCell(label);
			label = new Label(2, 181, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 182, "10.2.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 182, "Measles 2nd Dose", wcf3);
			ws.addCell(label);
			label = new Label(2, 182, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 183, "10.2.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 183, "Measles, Mumps, Rubella (MMR) Vaccine",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 183, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 184, "10.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 184, "Immunisation Status", wcf21);
			ws.addCell(label);
			label = new Label(2, 184, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 185, "10.3.1", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					185,
					"Total number of children aged between 12 and 23 months who have been fully immunised (BCG+DPT123+OPV123+Measles) during the month",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 185, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 186, "10.3.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 186, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 186, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 187, "10.3.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 187, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 187, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 188, "10.3.1.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 188, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 188, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 189, "10.3.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 189, "Children more than 5 years given DT5",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 189, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 190, "10.3.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 190, "Children more than 10 years given TT10",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 190, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 191, "10.3.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 191, "Children more than 16 years given TT16",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 191, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 192, "10.3.5", wcf21);
			ws.addCell(label);
			label = new Label(1, 192,
					"Adverse Event Following Immunisation (AEFI)", wcf21);
			ws.addCell(label);
			label = new Label(2, 192, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 193, "10.3.5.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 193, "Abscess", wcf3);
			ws.addCell(label);
			label = new Label(2, 193, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 194, "10.3.5.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 194, "Death", wcf3);
			ws.addCell(label);
			label = new Label(2, 194, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 195, "10.3.5.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 195, "Others", wcf3);
			ws.addCell(label);
			label = new Label(2, 195, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 196, "10.4", wcf21);
			ws.addCell(label);
			label = new Label(1, 196,
					"Number of Immunisation sessions during the month", wcf21);
			ws.addCell(label);
			label = new Label(2, 196, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 197, "10.4.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 197, "Planned", wcf3);
			ws.addCell(label);
			label = new Label(2, 197, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 198, "10.4.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 198, "Held", wcf3);
			ws.addCell(label);
			label = new Label(2, 198, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 199, "10.4.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 199, "Sessions where ASHAs were present", wcf3);
			ws.addCell(label);
			label = new Label(2, 199, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 200, "10.5", wcf21);
			ws.addCell(label);
			label = new Label(1, 200, "Japanese Encephalitis (JE)", wcf21);
			ws.addCell(label);
			label = new Label(2, 200, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 201, "10.5.1", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					201,
					"Number of children more than 16 months who received Japanese Encephalitis (JE) vaccine",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 201, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 202, "M11", wcf5);
			ws.addCell(label);
			label = new Label(1, 202, "Number of Vitamin A doses", wcf5);
			ws.addCell(label);
			label = new Label(2, 202, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 203, "11.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 203,
					"Administered between 9 months and 5 years", wcf21);
			ws.addCell(label);
			label = new Label(2, 203, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 204, "11.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 204, "Dose-1", wcf3);
			ws.addCell(label);
			label = new Label(2, 204, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 205, "11.1.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 205, "Dose-5", wcf3);
			ws.addCell(label);
			label = new Label(2, 205, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 206, "11.1.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 206, "Dose-9", wcf3);
			ws.addCell(label);
			label = new Label(2, 206, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 207, "M12", wcf5);
			ws.addCell(label);
			label = new Label(
					1,
					207,
					"Number of cases of Childhood Diseases reported during the month0-5 years:",
					wcf5);
			ws.addCell(label);
			label = new Label(2, 207, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 208, "12.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 208, "Diphtheria", wcf3);
			ws.addCell(label);
			label = new Label(2, 208, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 209, "12.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 209, "Pertussis", wcf3);
			ws.addCell(label);
			label = new Label(2, 209, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 210, "12.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 210, "Tetanus Neonatorum", wcf3);
			ws.addCell(label);
			label = new Label(2, 210, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 211, "12.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 211, "Tetanus others", wcf3);
			ws.addCell(label);
			label = new Label(2, 211, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 212, "12.5", wcf3);
			ws.addCell(label);
			label = new Label(1, 212, "Polio", wcf3);
			ws.addCell(label);
			label = new Label(2, 212, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 213, "12.6", wcf3);
			ws.addCell(label);
			label = new Label(1, 213, "Measles", wcf3);
			ws.addCell(label);
			label = new Label(2, 213, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 214, "12.7", wcf3);
			ws.addCell(label);
			label = new Label(1, 214, "Diarrhoea and dehydration", wcf3);
			ws.addCell(label);
			label = new Label(2, 214, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 215, "12.8", wcf3);
			ws.addCell(label);
			label = new Label(1, 215, "Malaria", wcf3);
			ws.addCell(label);
			label = new Label(2, 215, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 216, "12.9", wcf3);
			ws.addCell(label);
			label = new Label(1, 216,
					"Number admitted with Respiratory Infections", wcf3);
			ws.addCell(label);
			label = new Label(2, 216, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 217, "Part B", wcf21);
			ws.addCell(label);
			label = new Label(1, 217, "Other Programmes", wcf21);
			ws.addCell(label);
			label = new Label(2, 217, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 219, "M13", wcf5);
			ws.addCell(label);
			label = new Label(1, 219, "Blindness Control Programme", wcf5);
			ws.addCell(label);
			label = new Label(2, 219, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 220, "13.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 220,
					"Number of Patients operated for cataract", wcf3);
			ws.addCell(label);
			label = new Label(2, 220, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 221, "13.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 221,
					"Number of Intraocular Lens(IOL) implantations", wcf3);
			ws.addCell(label);
			label = new Label(2, 221, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 222, "13.3", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					222,
					"Number of School children detected with Refractive errors",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 222, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 223, "13.4", wcf3);
			ws.addCell(label);
			label = new Label(1, 223,
					"Number of children provided free glasses", wcf3);
			ws.addCell(label);
			label = new Label(2, 223, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 224, "13.5", wcf3);
			ws.addCell(label);
			label = new Label(1, 224, "Number of eyes collected", wcf3);
			ws.addCell(label);
			label = new Label(2, 224, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 225, "13.6", wcf3);
			ws.addCell(label);
			label = new Label(1, 225, "Number of eyes utilised", wcf3);
			ws.addCell(label);
			label = new Label(2, 225, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 226, "Part C", wcf21);
			ws.addCell(label);
			label = new Label(1, 226, "Health Facility Services", wcf21);
			ws.addCell(label);
			label = new Label(2, 226, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 227, "M14", wcf5);
			ws.addCell(label);
			label = new Label(1, 227, "Patient Services", wcf5);
			ws.addCell(label);
			label = new Label(2, 227, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 228, "14.01", wcf3);
			ws.addCell(label);
			label = new Label(1, 228,
					"Number of CHC/ SDH/ DH functioning as an FRUs", wcf3);
			ws.addCell(label);
			label = new Label(2, 228, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 229, "14.02", wcf3);
			ws.addCell(label);
			label = new Label(1, 229,
					"Number of PHCs functioning  24X7 3 Staff Nurses?", wcf3);
			ws.addCell(label);
			label = new Label(2, 229, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 230, "14.03", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					230,
					"Number of Anganwadi centres reported to have conducted VHNDs",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 230, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 231, "14.04", wcf3);
			ws.addCell(label);
			label = new Label(1, 231,
					"Number of facilities having a Rogi Kalyan Samiti", wcf3);
			ws.addCell(label);
			label = new Label(2, 231, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 232, "14.05", wcf3);
			ws.addCell(label);
			label = new Label(1, 232,
					"Number of RKS meetings held during the month", wcf3);
			ws.addCell(label);
			label = new Label(2, 232, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 233, "14.06", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					233,
					"Number of  facilities having Ambulance services  Assured Referral Services available",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 233, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 234, "14.07", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					234,
					"Total Number of times the Ambulance was used for transporting patients during the month",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 234, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 235, "14.08", wcf3);
			ws.addCell(label);
			label = new Label(
					1,
					235,
					"Number of Institutions having Operational Sick New Born and Child Care Units",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 235, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 236, "14.09", wcf3);
			ws.addCell(label);
			label = new Label(1, 236,
					"Number of functional Laproscopes in CHC/SDH/DH", wcf3);
			ws.addCell(label);
			label = new Label(2, 236, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 237, "14.10", wcf21);
			ws.addCell(label);
			label = new Label(1, 237, "Inpatient", wcf21);
			ws.addCell(label);
			label = new Label(2, 237, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 238, "14.10.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 238, "Admissions", wcf21);
			ws.addCell(label);
			label = new Label(2, 238, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 239, 0, 240);
			label = new Label(0, 239, "14.10.1.a", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 239, 1, 240);
			label = new Label(1, 239, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 239, "Children", wcf3);
			ws.addCell(label);
			label = new Label(2, 240, "Adults", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 241, 0, 242);
			label = new Label(0, 241, "14.10.1.b", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 241, 1, 242);
			label = new Label(1, 241, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 241, "Children", wcf3);
			ws.addCell(label);
			label = new Label(2, 242, "Adults", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 243, 0, 244);
			label = new Label(0, 243, "14.10.1.c", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 243, 1, 244);
			label = new Label(1, 243, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 243, "Children", wcf3);
			ws.addCell(label);
			label = new Label(2, 244, "Adults", wcf3);
			ws.addCell(label);

			label = new Label(0, 245, "14.10.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 245, "Deaths", wcf21);
			ws.addCell(label);
			label = new Label(2, 245, "", wcf21);
			ws.addCell(label);

			label = new Label(0, 246, "14.10.2.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 246, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 246, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 247, "14.10.2.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 247, "Female", wcf3);
			ws.addCell(label);
			label = new Label(2, 247, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 248, "14.10.2.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 248, "Total {(a) to (b)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 248, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 249, "14.11", wcf3);
			ws.addCell(label);
			label = new Label(1, 249, "In-Patient Head Count at midnight", wcf3);
			ws.addCell(label);
			label = new Label(2, 249, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 250, "14.12", wcf21);
			ws.addCell(label);
			label = new Label(1, 250, "Outpatient", wcf21);
			ws.addCell(label);
			label = new Label(2, 250, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 251, "14.12.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 251, "OPD attendance (All)", wcf3);
			ws.addCell(label);
			label = new Label(2, 251, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 252, "14.13", wcf21);
			ws.addCell(label);
			label = new Label(1, 252, "Operation Theatre", wcf21);
			ws.addCell(label);
			label = new Label(2, 252, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 253, "14.13.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 253,
					"Operation major (General and spinal anaesthesia)", wcf3);
			ws.addCell(label);
			label = new Label(2, 253, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 254, "14.13.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 254,
					"Out of 14.13.1, Gynaecology-Hysterectomy surgeries", wcf3);
			ws.addCell(label);
			label = new Label(2, 254, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 255, "14.13.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 255,
					"Operation minor (No or local anaesthesia)", wcf3);
			ws.addCell(label);
			label = new Label(2, 255, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 256, "14.14", wcf21);
			ws.addCell(label);
			label = new Label(
					1,
					256,
					"Others (Include other services like Dental, Ophthalmology , AYUSH etc.)",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 256, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 257, "14.14.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 257, "AYUSH", wcf3);
			ws.addCell(label);
			label = new Label(2, 257, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 258, "14.14.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 258, "Dental Procedures", wcf3);
			ws.addCell(label);
			label = new Label(2, 258, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 259, "14.14.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 259, "Adolescent counselling services", wcf3);
			ws.addCell(label);
			label = new Label(2, 259, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 260, "M15", wcf5);
			ws.addCell(label);
			label = new Label(1, 260, "Laboratory Testing", wcf5);
			ws.addCell(label);
			label = new Label(2, 260, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 261, "15.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 261, "Laboratory Test Details", wcf3);
			ws.addCell(label);
			label = new Label(2, 261, "", wcf3);
			ws.addCell(label);
			label = new Label(0, 262, "15.1.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 262, "Hb Tests conducted", wcf3);
			ws.addCell(label);
			label = new Label(2, 262, "", wcf3);
			ws.addCell(label);
			label = new Label(0, 263, "15.1.1.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 263, "Number of Hb tests conducted", wcf3);
			ws.addCell(label);
			label = new Label(2, 263, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 264, "15.1.1.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 264, "Of which number having Hb < 7 mg", wcf3);
			ws.addCell(label);
			label = new Label(2, 264, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 265, "15.1.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 265, "HIV tests conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 265, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 266, 0, 267);
			label = new Label(0, 266, "15.1.2.a", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 266, 1, 267);
			label = new Label(1, 266, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 266, "Number Positive", wcf3);
			ws.addCell(label);
			label = new Label(2, 267, "Number tested", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 268, 0, 269);
			label = new Label(0, 268, "15.1.2.b", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 268, 1, 269);
			label = new Label(1, 268, "Female-Non ANC", wcf3);
			ws.addCell(label);
			label = new Label(2, 268, "Number Positive", wcf3);
			ws.addCell(label);
			label = new Label(2, 269, "Number tested", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 270, 0, 271);
			label = new Label(0, 270, "15.1.2.c", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 270, 1, 271);
			label = new Label(1, 270, "Female with ANC", wcf3);
			ws.addCell(label);
			label = new Label(2, 270, "Number Positive", wcf3);
			ws.addCell(label);
			label = new Label(2, 271, "Number tested", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 272, 0, 273);
			label = new Label(0, 272, "15.1.2.d", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 272, 1, 273);
			label = new Label(1, 272, "Total {(a) to (c)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 272, "Number Positive", wcf3);
			ws.addCell(label);
			label = new Label(2, 273, "Number tested", wcf3);
			ws.addCell(label);
			label = new Label(0, 274, "15.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 274, "Widal tests conducted", wcf3);
			ws.addCell(label);
			label = new Label(2, 274, "Number tested", wcf3);
			ws.addCell(label);

			label = new Label(0, 275, "15.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 275, "VDRL  tests conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 275, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 276, "15.3.a", wcf3);
			ws.addCell(label);
			label = new Label(1, 276, "Male", wcf3);
			ws.addCell(label);
			label = new Label(2, 276, "Number tested", wcf3);
			ws.addCell(label);
			label = new Label(0, 277, "15.3.b", wcf3);
			ws.addCell(label);
			label = new Label(1, 277, "Female-Non ANC", wcf3);
			ws.addCell(label);
			label = new Label(2, 277, "Number tested", wcf3);
			ws.addCell(label);
			label = new Label(0, 278, "15.3.c", wcf3);
			ws.addCell(label);
			label = new Label(1, 278, "Female with ANC", wcf3);
			ws.addCell(label);
			label = new Label(2, 278, "Number tested", wcf3);
			ws.addCell(label);
			label = new Label(0, 279, "15.3.d", wcf3);
			ws.addCell(label);
			label = new Label(1, 279, "Total {(a) to (c)}", wcf3);
			ws.addCell(label);
			label = new Label(2, 279, "Number tested", wcf3);
			ws.addCell(label);

			label = new Label(0, 280, "15.4", wcf21);
			ws.addCell(label);
			label = new Label(1, 280, "Malaria tests conducted", wcf21);
			ws.addCell(label);
			label = new Label(2, 280, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 281, "15.4.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 281, "Blood smears examined", wcf3);
			ws.addCell(label);
			label = new Label(2, 281, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 282, "15.4.2", wcf3);
			ws.addCell(label);
			label = new Label(1, 282, "Plasmodium Vivax test positive", wcf3);
			ws.addCell(label);
			label = new Label(2, 282, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 283, "15.5.3", wcf3);
			ws.addCell(label);
			label = new Label(1, 283, "Plasmodium Falciparum test positive",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 283, "TOTAL", wcf3);
			ws.addCell(label);

			label = new Label(0, 284, "Part D", wcf21);
			ws.addCell(label);
			label = new Label(1, 284, "Monthly Inventory Status", wcf21);
			ws.addCell(label);
			label = new Label(2, 284, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 285, "M16", wcf5);
			ws.addCell(label);
			label = new Label(1, 285, "Stock Position (During the month)", wcf5);
			ws.addCell(label);
			label = new Label(2, 285, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 286, "16.1", wcf21);
			ws.addCell(label);
			label = new Label(1, 286, "Vaccines", wcf21);
			ws.addCell(label);
			label = new Label(2, 286, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 287, 0, 291);
			label = new Label(0, 287, "16.1.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 287, 1, 291);
			label = new Label(1, 287, "DPT", wcf3);
			ws.addCell(label);
			label = new Label(2, 287, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 288, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 289, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 290, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 291, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 292, 0, 296);
			label = new Label(0, 292, "16.1.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 292, 1, 296);
			label = new Label(1, 292, "OPV", wcf3);
			ws.addCell(label);
			label = new Label(2, 292, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 293, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 294, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 295, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 296, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 297, 0, 301);
			label = new Label(0, 297, "16.1.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 297, 1, 301);
			label = new Label(1, 297, "TT", wcf3);
			ws.addCell(label);
			label = new Label(2, 297, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 298, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 299, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 300, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 301, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 302, 0, 306);
			label = new Label(0, 302, "16.1.4", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 302, 1, 306);
			label = new Label(1, 302, "DT", wcf3);
			ws.addCell(label);
			label = new Label(2, 302, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 303, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 304, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 305, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 306, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 307, 0, 311);
			label = new Label(0, 307, "16.1.5", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 307, 1, 311);
			label = new Label(1, 307, "BCG", wcf3);
			ws.addCell(label);
			label = new Label(2, 307, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 308, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 309, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 310, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 311, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 312, 0, 316);
			label = new Label(0, 312, "16.1.6", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 312, 1, 316);
			label = new Label(1, 312, "Measles", wcf3);
			ws.addCell(label);
			label = new Label(2, 312, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 313, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 314, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 315, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 316, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 317, 0, 321);
			label = new Label(0, 317, "16.1.7", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 317, 1, 321);
			label = new Label(1, 317, "JE", wcf3);
			ws.addCell(label);
			label = new Label(2, 317, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 318, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 319, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 320, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 321, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 322, 0, 326);
			label = new Label(0, 322, "16.1.8", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 322, 1, 326);
			label = new Label(1, 322, "Hepatitis B", wcf3);
			ws.addCell(label);
			label = new Label(2, 322, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 323, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 324, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 325, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 326, "Total Stock", wcf3);
			ws.addCell(label);

			label = new Label(0, 327, "16.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 327, "Family Planning", wcf21);
			ws.addCell(label);
			label = new Label(2, 327, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 328, 0, 332);
			label = new Label(0, 328, "16.2.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 328, 1, 332);
			label = new Label(1, 328, "IUD 380 A", wcf3);
			ws.addCell(label);
			label = new Label(2, 328, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 329, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 330, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 331, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 332, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 333, 0, 337);
			label = new Label(0, 333, "16.2.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 333, 1, 337);
			label = new Label(1, 333, "Condoms", wcf3);
			ws.addCell(label);
			label = new Label(2, 333, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 334, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 335, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 336, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 337, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 338, 0, 342);
			label = new Label(0, 338, "16.2.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 338, 1, 342);
			label = new Label(1, 338, "Oral Contraceptive", wcf3);
			ws.addCell(label);
			label = new Label(2, 338, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 339, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 340, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 341, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 342, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 343, 0, 347);
			label = new Label(0, 343, "16.2.4", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 343, 1, 347);
			label = new Label(1, 343, "Emergency Contraceptive Pills", wcf3);
			ws.addCell(label);
			label = new Label(2, 343, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 344, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 345, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 346, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 347, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 348, 0, 352);
			label = new Label(0, 348, "16.2.5", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 348, 1, 352);
			label = new Label(1, 348, "Tubal rings", wcf3);
			ws.addCell(label);
			label = new Label(2, 348, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 349, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 350, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 351, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 352, "Total Stock", wcf3);
			ws.addCell(label);
			label = new Label(0, 353, "16.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 353, "Other Items", wcf21);
			ws.addCell(label);
			label = new Label(2, 353, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 354, 0, 358);
			label = new Label(0, 354, "16.3.01", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 354, 1, 358);
			label = new Label(1, 354, "Injection Oxytocin", wcf3);
			ws.addCell(label);
			label = new Label(2, 354, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 355, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 356, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 357, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 358, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 359, 0, 363);
			label = new Label(0, 359, "16.3.02", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 359, 1, 363);
			label = new Label(1, 359, "Gloves", wcf3);
			ws.addCell(label);
			label = new Label(2, 359, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 360, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 361, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 362, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 363, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 364, 0, 368);
			label = new Label(0, 364, "16.3.03", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 364, 1, 368);
			label = new Label(1, 364, "MVA Syringes", wcf3);
			ws.addCell(label);
			label = new Label(2, 364, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 365, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 366, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 367, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 368, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 369, 0, 373);
			label = new Label(0, 369, "16.3.04", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 369, 1, 373);
			label = new Label(1, 369, "Tab. Fluconazole", wcf3);
			ws.addCell(label);
			label = new Label(2, 369, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 370, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 371, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 372, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 373, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 374, 0, 378);
			label = new Label(0, 374, "16.3.05", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 374, 1, 378);
			label = new Label(1, 374, "Blood Transfusion sets", wcf3);
			ws.addCell(label);
			label = new Label(2, 374, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 375, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 376, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 377, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 378, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 379, 0, 383);
			label = new Label(0, 379, "16.3.06", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 379, 1, 383);
			label = new Label(1, 379, "Gluteraldehyde 2%", wcf3);
			ws.addCell(label);
			label = new Label(2, 379, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 380, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 381, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 382, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 383, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 384, 0, 388);
			label = new Label(0, 384, "16.3.07", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 384, 1, 388);
			label = new Label(1, 384, "IFA tablets", wcf3);
			ws.addCell(label);
			label = new Label(2, 384, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 385, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 386, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 387, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 388, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 389, 0, 393);
			label = new Label(0, 389, "16.3.08", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 389, 1, 393);
			label = new Label(1, 389, "IFA Syrup (Paediatric)", wcf3);
			ws.addCell(label);
			label = new Label(2, 389, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 390, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 391, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 392, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 393, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 394, 0, 398);
			label = new Label(0, 394, "16.3.09", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 394, 1, 398);
			label = new Label(
					1,
					394,
					"Paediatrics Antibiotics (Cotrimaxozole and Injectable Gentamicin)",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 394, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 395, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 396, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 397, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 398, "Total Stock", wcf3);
			ws.addCell(label);
			ws.mergeCells(0, 399, 0, 403);
			label = new Label(0, 399, "16.3.10", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 399, 1, 403);
			label = new Label(1, 399, "Vitamin A solution", wcf3);
			ws.addCell(label);
			label = new Label(2, 399, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 400, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 401, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 402, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 403, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 404, 0, 408);
			label = new Label(0, 404, "16.3.11", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 404, 1, 408);
			label = new Label(1, 404, "ORS (New WHO)", wcf3);
			ws.addCell(label);
			label = new Label(2, 404, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 405, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 406, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 407, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 408, "Total Stock", wcf3);
			ws.addCell(label);

			label = new Label(0, 409, "16.4", wcf21);
			ws.addCell(label);
			label = new Label(1, 409, "Syringes", wcf21);
			ws.addCell(label);
			label = new Label(2, 409, "", wcf21);
			ws.addCell(label);

			ws.mergeCells(0, 410, 0, 414);
			label = new Label(0, 410, "16.4.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 410, 1, 414);
			label = new Label(1, 410, "0.1 ml (AD)", wcf3);
			ws.addCell(label);
			label = new Label(2, 410, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 411, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 412, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 413, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 414, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 415, 0, 419);
			label = new Label(0, 415, "16.4.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 415, 1, 419);
			label = new Label(1, 415, "0.5 ml (AD)", wcf3);
			ws.addCell(label);
			label = new Label(2, 415, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 416, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 417, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 418, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 419, "Total Stock", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 420, 0, 424);
			label = new Label(0, 420, "16.4.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 420, 1, 424);
			label = new Label(1, 420, "5.0 ml (Disposable)", wcf3);
			ws.addCell(label);
			label = new Label(2, 420, "Balance From Previous Month", wcf3);
			ws.addCell(label);
			label = new Label(2, 421, "Stocks Received", wcf3);
			ws.addCell(label);
			label = new Label(2, 422, "Unusable Stock", wcf3);
			ws.addCell(label);
			label = new Label(2, 423, "Stock Distributed", wcf3);
			ws.addCell(label);
			label = new Label(2, 424, "Total Stock", wcf3);
			ws.addCell(label);

			label = new Label(0, 426, "Part E", wcf21);
			ws.addCell(label);
			label = new Label(1, 426, "Mortality Details", wcf21);
			ws.addCell(label);
			label = new Label(2, 426, "", wcf21);
			ws.addCell(label);
			label = new Label(0, 427, "M17", wcf5);
			ws.addCell(label);
			label = new Label(
					1,
					427,
					"Details of deaths reported during the month with probable causes:",
					wcf5);
			ws.addCell(label);
			label = new Label(2, 427, "", wcf5);
			ws.addCell(label);
			label = new Label(0, 428, "17.1", wcf3);
			ws.addCell(label);
			label = new Label(1, 428, "Infant deaths within 24 hrs of birth",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 428, "TOTAL", wcf3);
			ws.addCell(label);
			label = new Label(0, 429, "17.2", wcf21);
			ws.addCell(label);
			label = new Label(1, 429, "Infant Deaths up to 4 weeks by cause",
					wcf21);
			ws.addCell(label);
			label = new Label(2, 429, "", wcf21);
			ws.addCell(label);

			ws.mergeCells(0, 430, 0, 432);
			label = new Label(0, 430, "17.2.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 430, 1, 432);
			label = new Label(1, 430, "Sepsis", wcf3);
			ws.addCell(label);
			label = new Label(2, 430, "Up to 1 Weeks of Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 431, "Between 1 week & 4 weeks of birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 432, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 433, 0, 435);
			label = new Label(0, 433, "17.2.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 433, 1, 435);
			label = new Label(1, 433, "Asphyxia", wcf3);
			ws.addCell(label);
			label = new Label(2, 433, "Up to 1 Weeks of Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 434, "Between 1 week & 4 weeks of birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 435, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 436, 0, 438);
			label = new Label(0, 436, "17.2.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 436, 1, 438);
			label = new Label(1, 436, "LBW", wcf3);
			ws.addCell(label);
			label = new Label(2, 436, "Up to 1 Weeks of Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 437, "Between 1 week & 4 weeks of birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 438, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 439, 0, 441);
			label = new Label(0, 439, "17.2.4", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 439, 1, 441);
			label = new Label(1, 439, "Others", wcf3);
			ws.addCell(label);
			label = new Label(2, 439, "Up to 1 Weeks of Birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 440, "Between 1 week & 4 weeks of birth", wcf3);
			ws.addCell(label);
			label = new Label(2, 441, "Total", wcf3);
			ws.addCell(label);

			label = new Label(0, 442, "17.3", wcf21);
			ws.addCell(label);
			label = new Label(1, 442,
					"Infant/Child Deaths up to 5 years by cause", wcf21);
			ws.addCell(label);
			label = new Label(2, 442, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 443, 0, 445);
			label = new Label(0, 443, "17.3.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 443, 1, 445);
			label = new Label(1, 443, "Pneumonia", wcf3);
			ws.addCell(label);
			label = new Label(2, 443, "Between 1 month and 11 months", wcf3);
			ws.addCell(label);
			label = new Label(2, 444, "Between 1 year & 5 years", wcf3);
			ws.addCell(label);
			label = new Label(2, 445, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 446, 0, 448);
			label = new Label(0, 446, "17.3.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 446, 1, 448);
			label = new Label(1, 446, "Diarrhoea", wcf3);
			ws.addCell(label);
			label = new Label(2, 446, "Between 1 month and 11 months", wcf3);
			ws.addCell(label);
			label = new Label(2, 447, "Between 1 year & 5 years", wcf3);
			ws.addCell(label);
			label = new Label(2, 448, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 449, 0, 451);
			label = new Label(0, 449, "17.3.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 449, 1, 451);
			label = new Label(1, 449, "Fever related", wcf3);
			ws.addCell(label);
			label = new Label(2, 449, "Between 1 month and 11 months", wcf3);
			ws.addCell(label);
			label = new Label(2, 450, "Between 1 year & 5 years", wcf3);
			ws.addCell(label);
			label = new Label(2, 451, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 452, 0, 454);
			label = new Label(0, 452, "17.3.4", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 452, 1, 454);
			label = new Label(1, 452, "Measles", wcf3);
			ws.addCell(label);
			label = new Label(2, 452, "Between 1 month and 11 months", wcf3);
			ws.addCell(label);
			label = new Label(2, 453, "Between 1 year & 5 years", wcf3);
			ws.addCell(label);
			label = new Label(2, 454, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 455, 0, 457);
			label = new Label(0, 455, "17.3.5", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 455, 1, 457);
			label = new Label(1, 455, "Others", wcf3);
			ws.addCell(label);
			label = new Label(2, 455, "Between 1 month and 11 months", wcf3);
			ws.addCell(label);
			label = new Label(2, 456, "Between 1 year & 5 years", wcf3);
			ws.addCell(label);
			label = new Label(2, 457, "Total", wcf3);
			ws.addCell(label);

			label = new Label(0, 458, "17.4", wcf21);
			ws.addCell(label);
			label = new Label(1, 458, "Adolescent/Adult deaths by cause", wcf21);
			ws.addCell(label);
			label = new Label(2, 458, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 459, 0, 462);
			label = new Label(0, 459, "17.4.1", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 459, 1, 462);
			label = new Label(1, 459, "Diarrhoeal diseases", wcf3);
			ws.addCell(label);
			label = new Label(2, 459, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 460, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 461, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 462, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 463, 0, 466);
			label = new Label(0, 463, "17.4.2", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 463, 1, 466);
			label = new Label(1, 463, "Tuberculosis", wcf3);
			ws.addCell(label);
			label = new Label(2, 463, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 464, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 465, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 466, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 467, 0, 470);
			label = new Label(0, 467, "17.4.3", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 467, 1, 470);
			label = new Label(
					1,
					467,
					"Respiratory diseases including infections (other than TB)",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 467, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 468, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 469, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 470, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 471, 0, 474);
			label = new Label(0, 467, "17.4.4", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 471, 1, 474);
			label = new Label(1, 471, "Malaria", wcf3);
			ws.addCell(label);
			label = new Label(2, 471, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 472, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 473, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 474, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 475, 0, 478);
			label = new Label(0, 467, "17.4.5", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 475, 1, 478);
			label = new Label(1, 475, "Other Fever Related", wcf3);
			ws.addCell(label);
			label = new Label(2, 475, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 476, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 477, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 478, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 479, 0, 482);
			label = new Label(0, 479, "17.4.6", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 479, 1, 482);
			label = new Label(1, 479, "HIV/AIDS", wcf3);
			ws.addCell(label);
			label = new Label(2, 479, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 480, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 481, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 482, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 483, 0, 486);
			label = new Label(0, 483, "17.4.7", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 483, 1, 486);
			label = new Label(1, 483, "Heart disease/Hypertension related",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 483, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 484, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 485, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 486, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 487, 0, 490);
			label = new Label(0, 487, "17.4.8", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 487, 1, 490);
			label = new Label(1, 487, "Neurological disease including strokes",
					wcf3);
			ws.addCell(label);
			label = new Label(2, 487, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 488, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 489, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 490, "Total", wcf3);
			ws.addCell(label);

			label = new Label(0, 491, "17.4.9", wcf21);
			ws.addCell(label);
			label = new Label(1, 491, "Maternal Deaths", wcf21);
			ws.addCell(label);
			label = new Label(2, 491, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 492, 0, 495);
			label = new Label(0, 492, "17.4.9(a)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 492, 1, 495);
			label = new Label(1, 492, "Abortion", wcf3);
			ws.addCell(label);
			label = new Label(2, 492, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 493, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 494, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 495, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 496, 0, 499);
			label = new Label(0, 496, "17.4.9(b)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 496, 1, 499);
			label = new Label(1, 496, "Obstructed/prolonged labour", wcf3);
			ws.addCell(label);
			label = new Label(2, 496, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 497, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 498, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 499, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 500, 0, 503);
			label = new Label(0, 500, "17.4.9(c)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 500, 1, 503);
			label = new Label(1, 500, "Severe hypertesnion/fits", wcf3);
			ws.addCell(label);
			label = new Label(2, 500, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 501, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 502, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 503, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 504, 0, 507);
			label = new Label(0, 504, "17.4.9(d)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 504, 1, 507);
			label = new Label(1, 504, "Bleeding", wcf3);
			ws.addCell(label);
			label = new Label(2, 504, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 505, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 506, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 507, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 508, 0, 511);
			label = new Label(0, 508, "17.4.9(e)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 508, 1, 511);
			label = new Label(1, 508, "High fever", wcf3);
			ws.addCell(label);
			label = new Label(2, 508, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 509, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 510, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 511, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 512, 0, 515);
			label = new Label(0, 512, "17.4.9(f)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 512, 1, 515);
			label = new Label(1, 512,
					"Other Causes (including causes not known)", wcf3);
			ws.addCell(label);
			label = new Label(2, 512, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 513, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 514, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 515, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 516, 0, 519);
			label = new Label(0, 516, "17.4.10", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 516, 1, 519);
			label = new Label(1, 516, "Trauma/Accidents/Burn cases", wcf3);
			ws.addCell(label);
			label = new Label(2, 516, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 517, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 518, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 519, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 520, 0, 523);
			label = new Label(0, 520, "17.4.11", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 520, 1, 523);
			label = new Label(1, 520, "Suicide", wcf3);
			ws.addCell(label);
			label = new Label(2, 520, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 521, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 522, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 523, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 524, 0, 527);
			label = new Label(0, 524, "17.4.12", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 524, 1, 527);
			label = new Label(1, 524, "Animal bites and stings", wcf3);
			ws.addCell(label);
			label = new Label(2, 524, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 525, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 526, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 527, "Total", wcf3);
			ws.addCell(label);

			label = new Label(0, 528, "17.4.13", wcf21);
			ws.addCell(label);
			label = new Label(1, 528, "Other Diseases", wcf21);
			ws.addCell(label);
			label = new Label(2, 528, "", wcf21);
			ws.addCell(label);
			ws.mergeCells(0, 529, 0, 532);
			label = new Label(0, 529, "17.4.13(a)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 529, 1, 532);
			label = new Label(1, 529, "Known Acute Disease", wcf3);
			ws.addCell(label);
			label = new Label(2, 529, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 530, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 531, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 532, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 533, 0, 536);
			label = new Label(0, 533, "17.4.13(b)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 533, 1, 536);
			label = new Label(1, 533, "Known Chronic Disease", wcf3);
			ws.addCell(label);
			label = new Label(2, 533, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 534, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 535, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 536, "Total", wcf3);
			ws.addCell(label);

			ws.mergeCells(0, 537, 0, 540);
			label = new Label(0, 537, "17.4.13(c)", wcf3);
			ws.addCell(label);
			ws.mergeCells(1, 537, 1, 540);
			label = new Label(1, 537, "Causes not known", wcf3);
			ws.addCell(label);
			label = new Label(2, 537, "6-14 yrs", wcf3);
			ws.addCell(label);
			label = new Label(2, 538, "15-55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 539, "Above 55 yrs.", wcf3);
			ws.addCell(label);
			label = new Label(2, 540, "Total", wcf3);
			ws.addCell(label);

			int srNo = 1;
			if (aList.size() > 0) {
				for (Object[] obj : aList) {
					label = new Label(10, 8, "" + srNo, wcf3);
					ws.addCell(label);

					label = new Label(11, 8, "" + obj[1], wcf3);
					ws.addCell(label);

					label = new Label(12, 8, "" + obj[2], wcf3);
					ws.addCell(label);

					srNo++;
				}
			}

			wb.write();
			wb.close();

			return null;
		} catch (Exception ioe) {
			ioe.printStackTrace();
			jsp = "xmlReportJsp";
			jsp += ".jsp";
			title = "Export CD";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	}
	
	
	// added by Amit Das on 28-04-2016
	public ModelAndView showFormPJsp(HttpServletRequest request,
				HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int userId = 0;
		if(session.getAttribute("userId")!=null){
			userId = (Integer)session.getAttribute("userId");
			map.put("userId", userId);
		}
		
		map =  pubHealthHandlerService.showFormPJsp(map);
		
		jsp = "idsp_hospital_report" + ".jsp";
		map.put("contentJsp", jsp);
				
		return new ModelAndView("index", "map", map);
	}
	
	
	// added by Amit Das on 29-04-2016
	public ModelAndView generatetIdspReportFormP(HttpServletRequest request,
					HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		List<IdspHospitalReport> idspHospitalReportList = new ArrayList<IdspHospitalReport>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		MasHospital masHospital = null;
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		int hospitalId = 0;
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				box.put(HOSPITAL_ID, hospitalId);
				map = pubHealthHandlerService.getIdspReportDataHospitalWise(box);
				
				if (map.get("idspHospitalReportByCountList") != null)
					idspHospitalReportList = (List<IdspHospitalReport>) map.get("idspHospitalReportByCountList");
				
				if(map.get("masHospital")!=null)
					masHospital = (MasHospital)map.get("masHospital");
				
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition","attachment; filename=FormP.xls");

					WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
					WritableSheet ws = wb.createSheet("Sheet", 0);

					WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
					WritableCellFormat wcf = new WritableCellFormat(wf);
					wcf.setAlignment(Alignment.CENTRE);
					wcf.setWrap(true);

					WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
					wcf2.setWrap(true);
					
					
					WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
					WritableCellFormat wcf3 = new WritableCellFormat(wf3);
					wcf3.setAlignment(Alignment.CENTRE);
					wcf3.setWrap(false);
					


					CellView cell = new CellView();
					cell.setSize(1000);
					ws.setColumnView(0, cell);
					cell.setSize(8000);
					ws.setColumnView(1, cell);
					cell.setSize(8000);
					ws.setColumnView(2, cell);
					cell.setSize(3000);
					ws.setColumnView(3, cell);
					cell.setSize(8000);
					ws.setColumnView(4, cell);
					cell.setSize(6000);
					ws.setColumnView(5, cell);
					cell.setSize(6000);
					ws.setColumnView(6, cell);
					cell.setSize(6000);
					ws.setColumnView(7, cell);
					
					

					Label label = new Label(3, 0, "FORM P", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 1, "(Weekly Reporting Format - IDSP)", wcf3);
					ws.addCell(label);
					
					label = new Label(1, 4, "Name Of Reporting Institution : ", wcf3);
					ws.addCell(label);
					
					label = new Label(1, 5, (masHospital.getHospitalName()!=null)?masHospital.getHospitalName():"", wcf3);
					ws.addCell(label);
					
					label = new Label(7, 4, "I.D. No.:", wcf3);
					ws.addCell(label);
					
					label = new Label(1, 5, "State:", wcf3);
					ws.addCell(label);
					
					label = new Label(2, 5, (masHospital.getAddress()!=null)?masHospital.getAddress():"", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 5, "District:", wcf3);
					ws.addCell(label);
					
					label = new Label(4, 5, (masHospital.getDistrict()!=null && masHospital.getDistrict().getDistrictName()!=null)?masHospital.getDistrict().getDistrictName():"", wcf3);
					ws.addCell(label);
					
					label = new Label(5, 5, "Block/Town/City", wcf3);
					ws.addCell(label);
					
					label = new Label(6, 5, (masHospital.getAdd3Locality()!=null && masHospital.getAdd3Locality().getLocalityName()!=null)?masHospital.getAdd3Locality().getLocalityName():"", wcf3);
					ws.addCell(label);
					
					label = new Label(1, 6, "Officer-in-Charge", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 6, "Name:", wcf3);
					ws.addCell(label);
					
					label = new Label(5, 6, "Signature:", wcf3);
					ws.addCell(label);
					
					label = new Label(1, 7, "IDSP Reporting Week:-", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 7, "Start Date:-", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 8, (box.get("fromDate")!=null)?box.get("fromDate"):"", wcf3);
					ws.addCell(label);
					
					label = new Label(5, 7, "End Date:-", wcf3);
					ws.addCell(label);
					
					label = new Label(5, 8, (box.get("toDate")!=null)?box.get("toDate"):"", wcf3);
					ws.addCell(label);
					
					label = new Label(7, 7, "Date of Reporting:-", wcf3);
					ws.addCell(label);
					
					label = new Label(7, 8, currentDate, wcf3);
					ws.addCell(label);
					
					
					label = new Label(1, 10, "S.no", wcf3);
					ws.addCell(label);
					
					label = new Label(2, 10, "Diseases/Syndromes", wcf3);
					ws.addCell(label);
					
					label = new Label(3, 10, "No. of cases", wcf3);
					ws.addCell(label);
					

					if (idspHospitalReportList!=null && idspHospitalReportList.size() > 0) {
						int count = 11;
						int sNo = 1;
					
						for(IdspHospitalReport idspHospitalReport : idspHospitalReportList) {
							
							label = new Label(1, count, Integer.toString(sNo), wcf2);
							ws.addCell(label);
							
							label = new Label(2, count, idspHospitalReport.getDiseasesName(), wcf2);
							ws.addCell(label);
							
							label = new Label(3, count, Integer.toString(idspHospitalReport.getNoOfCases()), wcf2);
							ws.addCell(label);
							
							sNo++;
							count++;
						}
						
						label = new Label(2, count, "Total New OPD attendance (Not to be filled up when data collected for indoor cases)", wcf3);
						ws.addCell(label);
						label = new Label(3, count, Integer.toString((Integer)map.get("noOfOpdAttendence")), wcf3);
						ws.addCell(label);
						count++;
						label = new Label(2, count, "Action taken in brief if unusual increase noticed in case/details for any of the above diseases", wcf3);
						ws.addCell(label);
						label = new Label(3, count, "", wcf3);
						ws.addCell(label);
					}

					wb.write();
					wb.close();

					
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;			
	}

	// added by Amit Das on 29-04-2016
		public ModelAndView generatetIdspReportFormL(HttpServletRequest request,
						HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			List<IdspHospitalReportForml> idspHospitalReportList = new ArrayList<IdspHospitalReportForml>();
			Map<String,Object> utilMap = new HashMap<String,Object>();
			List<Object[]> patientList = null;
			MasHospital masHospital = null;
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");
			int hospitalId = 0;
			try {
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
					box.put(HOSPITAL_ID, hospitalId);
					map = pubHealthHandlerService.getIdspReportDataFormLHospitalWise(box);
					
					if (map.get("idspHospitalReportByCountList") != null)
						idspHospitalReportList = (List<IdspHospitalReportForml>) map.get("idspHospitalReportByCountList");
					
					if (map.get("patientList") != null)
						patientList = (List<Object[]>) map.get("patientList");
					
					if(map.get("masHospital")!=null)
						masHospital = (MasHospital)map.get("masHospital");
					
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition","attachment; filename=FormL.xls");

						WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
						WritableSheet ws = wb.createSheet("Sheet", 0);

						WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
						WritableCellFormat wcf = new WritableCellFormat(wf);
						wcf.setAlignment(Alignment.CENTRE);
						wcf.setWrap(true);

						WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
						wcf2.setWrap(true);
						
						
						WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
						WritableCellFormat wcf3 = new WritableCellFormat(wf3);
						wcf3.setAlignment(Alignment.CENTRE);
						wcf3.setWrap(false);
						


						CellView cell = new CellView();
						cell.setSize(1000);
						ws.setColumnView(0, cell);
						cell.setSize(8000);
						ws.setColumnView(1, cell);
						cell.setSize(8000);
						ws.setColumnView(2, cell);
						cell.setSize(3000);
						ws.setColumnView(3, cell);
						cell.setSize(8000);
						ws.setColumnView(4, cell);
						cell.setSize(6000);
						ws.setColumnView(5, cell);
						cell.setSize(6000);
						ws.setColumnView(6, cell);
						cell.setSize(6000);
						ws.setColumnView(7, cell);
						
						

						Label label = new Label(3, 0, "FORM P", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 1, "(Weekly Reporting Format - IDSP)", wcf3);
						ws.addCell(label);
						
						label = new Label(1, 4, "Name Of Reporting Institution : ", wcf3);
						ws.addCell(label);
						
						label = new Label(1, 5, (masHospital.getHospitalName()!=null)?masHospital.getHospitalName():"", wcf3);
						ws.addCell(label);
						
						label = new Label(7, 4, "I.D. No.:", wcf3);
						ws.addCell(label);
						
						label = new Label(1, 5, "State:", wcf3);
						ws.addCell(label);
						
						label = new Label(2, 5, (masHospital.getAddress()!=null)?masHospital.getAddress():"", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 5, "District:", wcf3);
						ws.addCell(label);
						
						label = new Label(4, 5, (masHospital.getDistrict()!=null && masHospital.getDistrict().getDistrictName()!=null)?masHospital.getDistrict().getDistrictName():"", wcf3);
						ws.addCell(label);
						
						label = new Label(5, 5, "Block/Town/City", wcf3);
						ws.addCell(label);
						
						label = new Label(6, 5, (masHospital.getAdd3Locality()!=null && masHospital.getAdd3Locality().getLocalityName()!=null)?masHospital.getAdd3Locality().getLocalityName():"", wcf3);
						ws.addCell(label);
						
						label = new Label(1, 6, "Officer-in-Charge", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 6, "Name:", wcf3);
						ws.addCell(label);
						
						label = new Label(5, 6, "Signature:", wcf3);
						ws.addCell(label);
						
						label = new Label(1, 7, "IDSP Reporting Week:-", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 7, "Start Date:-", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 8, box.get("fromDate"), wcf3);
						ws.addCell(label);
						
						label = new Label(5, 7, "End Date:-", wcf3);
						ws.addCell(label);
						
						label = new Label(5, 8, box.get("toDate"), wcf3);
						ws.addCell(label);
						
						label = new Label(7, 7, "Date of Reporting:-", wcf3);
						ws.addCell(label);
						
						label = new Label(7, 8, currentDate, wcf3);
						ws.addCell(label);
						
						
						/*label = new Label(1, 10, "S.no", wcf3);
						ws.addCell(label);*/
						
						label = new Label(1, 10, "Diseases", wcf3);
						ws.addCell(label);
						
						label = new Label(2, 10, "No. Samples Tested", wcf3);
						ws.addCell(label);
						
						label = new Label(3, 10, "No. found Positive", wcf3);
						ws.addCell(label);
						
						int count = 11;
						if (idspHospitalReportList!=null && idspHospitalReportList.size() > 0) {
							//int sNo = 1;
						
							for(IdspHospitalReportForml idspHospitalReport : idspHospitalReportList) {
								
								/*label = new Label(1, count, Integer.toString(sNo), wcf2);
								ws.addCell(label);*/
								
								label = new Label(1, count, idspHospitalReport.getDiseasesName(), wcf2);
								ws.addCell(label);
								
								label = new Label(2, count, Integer.toString(idspHospitalReport.getNoOfSamplesTested()), wcf2);
								ws.addCell(label);
								
								//sNo++;
								count++;
							}
							count++;
							label = new Label(1, count++, "Line List of Positive Cases(Except Malaria cases))", wcf3);
							ws.addCell(label);
							
							label = new Label(1, count, "Name", wcf3);
							ws.addCell(label);
							
							label = new Label(2, count, "Age (Yrs)", wcf3);
							ws.addCell(label);
							
							label = new Label(3, count, "Sex (M/F)", wcf3);
							ws.addCell(label);
							
							label = new Label(4, count, "Address Village/Town", wcf3);
							ws.addCell(label);
							
							label = new Label(5, count, "Name of Test Done", wcf3);
							ws.addCell(label);
							
							label = new Label(6, count, "Diagnosis (Lab confirmed)", wcf3);
							ws.addCell(label);
							
						}
						count++;
						if(patientList!=null && patientList.size()>0){
							for(Object[] object : patientList){
								label = new Label(1, count, (String)object[0], wcf3);
								ws.addCell(label);
								
								label = new Label(2, count, (String)object[1], wcf3);
								ws.addCell(label);
								
								label = new Label(3, count, (String)object[2], wcf3);
								ws.addCell(label);
								
								label = new Label(4, count, (String)object[3], wcf3);
								ws.addCell(label);
								
								label = new Label(5, count, (String)object[4], wcf3);
								ws.addCell(label);
								
								label = new Label(6, count, "", wcf3);
								ws.addCell(label);
							}
						}

						wb.write();
						wb.close();

						
				}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return null;			
		}
		
		

		// added by Amit Das on 02-05-2016
	public ModelAndView getIdspReportDataFormLHospitalWise(HttpServletRequest request,
						HttpServletResponse response) {
			Map<String, Object> map = null;
			Box box = null;
			HttpSession session = null;
			int hospitalId = 0;
			try {
				session = request.getSession();
				box = HMSUtil.getBox(request);
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
					box.put(HOSPITAL_ID, hospitalId);
					map = pubHealthHandlerService.getIdspReportDataFormLHospitalWise(box);
					jsp = IDSP_HOSPITAL_REPORT_FORML_RESPONSE_FOR_ITEMS_JSP;
				}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
	}		
	
	// added by Amit Das on 02-05-2016
		public ModelAndView updateIdspReportFormLDataHospitalWise(HttpServletRequest request,
						HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			int hospitalId = 0;
			try {
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
					box.put(HOSPITAL_ID, hospitalId);
					
					map = pubHealthHandlerService.updateIdspReportFormLDataHospitalWise(box);
					jsp = "idsp_hospital_report_formL" + ".jsp";
					map.put("contentJsp", jsp);
							
				}
			} catch (Exception e) {
					e.printStackTrace();
			}
			return new ModelAndView("index", "map", map);
		}	
		
	
	
	// added by Amit Das on 28-04-2016
	public ModelAndView getIdspReportDataHospitalWise(HttpServletRequest request,
					HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				box.put(HOSPITAL_ID, hospitalId);
				map = pubHealthHandlerService.getIdspReportDataHospitalWise(box);
				jsp = IDSP_HOSPITAL_REPORT_RESPONSE_FOR_ITEMS_JSP;
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}	
	

	// added by Amit Das on 28-04-2016
	public ModelAndView updateIdspReportDataHospitalWise(HttpServletRequest request,
					HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				box.put(HOSPITAL_ID, hospitalId);
				
				map = pubHealthHandlerService.updateIdspReportDataHospitalWise(box);
				jsp = "idsp_hospital_report" + ".jsp";
				map.put("contentJsp", jsp);
						
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}	
	
	// added by Amit Das on 28-04-2016
	public ModelAndView showDiseasesIcdMappingJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();

			if(box.get("diseasesName")!=null)
				map.put("diseasesName", box.get("diseasesName"));
			
			jsp = "diseasesIcdMapping" + ".jsp";
			map.put("contentJsp", jsp);
				
			return new ModelAndView("index", "map", map);
	}
	
	// added by Amit Das on 28-04-2016
	public ModelAndView getItemListForAutoCompleteForDiseasesIcdMapping(HttpServletRequest request,
				HttpServletResponse response) {
			//HttpSession session = request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			String itemNameField = "";
			String autoHint = "";

			try {
				if (request.getParameter("requiredField") != null) {
					itemNameField = (request.getParameter("requiredField"));
				}
				if (request.getParameter(itemNameField) != null) {
					autoHint = (request.getParameter(itemNameField));
				}
				
				map.put("autoHint", autoHint);
				map = pubHealthHandlerService.getItemListForAutoCompleteForDiseasesIcdMapping(map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = DISEASES_ICD_MAPPING_RESPONSE_FOR_ITEMS_AUTOCOMPLETE_JSP;

			return new ModelAndView(jsp, "map", map);
		}
	
	// added by Amit Das on 28-04-2016
			public ModelAndView getItemListForIcdInvestigationMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				//HttpSession session = request.getSession();
				try {
					map = pubHealthHandlerService.getIcdInvestigationMapping(box);
					jsp = ICD_INVESTIGATION_MAPPING_RESPONSE_FOR_ITEMS_JSP;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
	
	
	// added by Amit Das on 28-04-2016
		public ModelAndView getItemListForDiseasesIcdMapping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			try {
				map = pubHealthHandlerService.getDiseasesIcdMapping(box);
				jsp = DISEASES_ICD_MAPPING_RESPONSE_FOR_ITEMS_JSP;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}

		// added by Amit Das on 22-04-2016
		public ModelAndView addDiseasesIcdMapping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			//HttpSession session = request.getSession();
			try {
				map = pubHealthHandlerService.addDiseasesIcdMapping(box);
				jsp = "responseForDiseasesIcdMapping";
				
				if(box.get("diseasesName")!=null)
					map.put("diseasesName", box.get("diseasesName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
		
		// added by Amit Das on 22-04-2016
		public ModelAndView deleteDiseasesIcdMapping(HttpServletRequest request,
							HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			try {
					map = pubHealthHandlerService.deleteDiseasesIcdMapping(box);
					jsp = "responseForDiseasesIcdMapping";
					
					if(box.get("diseasesName")!=null)
						map.put("diseasesName", box.get("diseasesName"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}
					
	
	// added by Amit Das on 22-04-2016
	public ModelAndView showHMISParameterMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();

		map = pubHealthHandlerService.getHMISParameters(box);
		jsp = "hmisParameterMapping" + ".jsp";
		map.put("contentJsp", jsp);
		if(box.get("hmisParameterId")!=null)
			map.put("hmisParameterId", box.get("hmisParameterId"));
			
		return new ModelAndView("index", "map", map);
	}

	// added by Amit Das on 22-04-2016
	public ModelAndView getItemListForAutoCompleteForHmisParameterMapping(HttpServletRequest request,
			HttpServletResponse response) {
		//HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String itemNameField = "";
		String autoHint = "";

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			if (request.getParameter("hmisParameterCategory") != null) {
				String hmisParameterCategory = request
						.getParameter("hmisParameterCategory");
				map.put("hmisParameterCategory", hmisParameterCategory);
			}
			
			map.put("autoHint", autoHint);
			map = pubHealthHandlerService.getItemListForAutoCompleteForHmisParameterMapping(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HMIS_PARAMETER_MAPPING_RESPONSE_FOR_ITEMS_AUTOCOMPLETE_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	// added by Amit Das on 22-04-2016
	public ModelAndView getItemListForHmisMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		try {
			map = pubHealthHandlerService.getHMISParameterMapping(box);
			jsp = HMIS_PARAMETER_MAPPING_RESPONSE_FOR_ITEMS_JSP;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}
	
	// added by Amit Das on 22-04-2016
		public ModelAndView addHmisParameterMapping(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			//HttpSession session = request.getSession();
			try {
				map = pubHealthHandlerService.addHmisParameterMapping(box);
				jsp = "responseForHmisParameterMapping";
				
				if(box.get("hmisParameterId")!=null)
					map.put("hmisParameterId", box.get("hmisParameterId"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new ModelAndView(jsp, "map", map);
		}


		// added by Amit Das on 22-04-2016
			public ModelAndView deleteHmisParameterMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				try {
					map = pubHealthHandlerService.deleteHmisParameterMapping(box);
					jsp = "responseForHmisParameterMapping";
					
					if(box.get("hmisParameterId")!=null)
						map.put("hmisParameterId", box.get("hmisParameterId"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
	
	
	// -------------- HMIS REPORT ---------------------

	public ModelAndView showHMISEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId;
		String reportName = box.get("reportName") ;
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Calendar now = Calendar.getInstance();
		box.put("year", now.get(Calendar.YEAR));
		box.put("month", now.get(Calendar.MONTH) + 1);

		if (session.getAttribute(HOSPITAL_ID) != null
				&& !session.getAttribute(HOSPITAL_ID).equals("")) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = pubHealthHandlerService.getPhReportDataFromDatabase(box);
		if(reportName!=null){
			
			if(reportName.equalsIgnoreCase("hmis"))
				map.putAll(pubHealthHandlerService.getHMISCountFromDatabase(box));
			
		
		}
		
		jsp = "hmisReportData" + ".jsp";
		map.put("contentJsp", jsp);
		map.put("reportName", reportName); // added by amit das on 06-12-2016
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHmisReportData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String counter = "";
		int hospitalId;
		String districtName = "";
		if(null != request.getParameter("districtName") && !request.getParameter("districtName").equals("")) {
			districtName = request.getParameter("districtName");
		}
		String reportName = request.getParameter("reportName");
		HttpSession session = request.getSession();
		session = request.getSession(true);
		try {
			//Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("counter") != null
					&& !request.getParameter("counter").equals("")) {
				counter = request.getParameter("counter");
				box.put("counter", counter);
			}
			if (session.getAttribute(HOSPITAL_ID) != null
					&& !session.getAttribute(HOSPITAL_ID).equals("")) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}

			box.put("districtName", districtName); // added by amit das on 06-12-2016
			map = pubHealthHandlerService.submitHmisReportData(box);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "hmisReportJsp";
			jsp += ".jsp";
			title = "Immunization";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("districtName", districtName); // added by amit das on 06-12-2016
			map.put("reportName", reportName); //Added by Arbind on 18-09-2017
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public ModelAndView genratehmisReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		List<StoreSetup> classList = new ArrayList<StoreSetup>();
		String reportName = request.getParameter("reportName"); // added by amit das on 06-12-2016
		String districtName = request.getParameter("districtName"); // added by amit das on 06-12-2016
		String reportFileName = null;
		String hospitalName = "";
		String fMonth = null;
		String tMonth = null;
		int fromMonth = 0;
		int toMonth = 0;
		int year = 0;

		try {
			
			Map<Integer,String> monthMap = new HashMap<Integer,String>();
			monthMap.put(1, "January");
			monthMap.put(2, "February");
			monthMap.put(3, "March");
			monthMap.put(4, "April");
			monthMap.put(5, "May");
			monthMap.put(6, "June");
			monthMap.put(7, "July");
			monthMap.put(8, "August");
			monthMap.put(9, "September");
			monthMap.put(10, "October");
			monthMap.put(11, "November");
			monthMap.put(12, "December");
			
			if (request.getParameter("frommonths") != null
					&& !request.getParameter("frommonths").equals("")) {
				fromMonth = Integer.parseInt(request.getParameter("frommonths"));
				fMonth = (String) monthMap.get(fromMonth);
				 System.out.println(fMonth);
				
				requestParameters.put("fromMonth", fromMonth);
				requestParameters.put("fMonth", fMonth);
			}
			if (request.getParameter("tomonths") != null
					&& !request.getParameter("tomonths").equals("")) {
				toMonth = Integer.parseInt(request.getParameter("tomonths"));
				tMonth = (String) monthMap.get(toMonth);
				 System.out.println(tMonth);
	
				requestParameters.put("toMonth", toMonth);
				requestParameters.put("tMonth", tMonth);
			}

			if (request.getParameter("year") != null
					&& !request.getParameter("year").equals("")) {
				year = Integer.parseInt(request.getParameter("year"));
				requestParameters.put("year", year);
			}
			
			// added by amit das on 06-12-2016
			if(districtName!=null){
				
				if (districtName.equalsIgnoreCase("THIRUVANANTHAPURAM")){
					districtName = "thiruvananthapuram_modify";
				} else if (districtName.equalsIgnoreCase("ALAPPUZHA")) {
					districtName = "alappuzha_modify";
				} else if (districtName.equalsIgnoreCase("Ernakulam")) {
					districtName = "ernakulam_modify";
				} else if (districtName.equalsIgnoreCase("Idukki")) {
					districtName = "idukki_modify";
				} else if (districtName.equalsIgnoreCase("Kannur")) {
					districtName = "kannur_modify";
				} else 	if (districtName.equalsIgnoreCase("Kasaragod")) {
					districtName = "kasaragod_modify";
				} else if (districtName.equalsIgnoreCase("Kollam")) {
					districtName = "kollam_modify";
				} else if (districtName.equalsIgnoreCase("Kottayam")) {
					districtName = "kottayam_modify";
				} else if (districtName.equalsIgnoreCase("Kozhikode")) {
					districtName = "kozhikode_modify";
				} else if (districtName.equalsIgnoreCase("Malappuram")) {
					districtName = "malappuram_modify";
				} else if (districtName.equalsIgnoreCase("Palakkad")) {
					districtName = "palakkad_modify";
				} else if (districtName.equalsIgnoreCase("Pathanamthitta")) {
					districtName = "pathanamthitta_modify";
				} else if (districtName.equalsIgnoreCase("Thrissur")) {
					districtName = "thrissur_modify";
				} else 	if (districtName.equalsIgnoreCase("Wayanad")) {
					districtName = "wayanad_modify";
				}
				
				requestParameters.put("year", year);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		
		if(reportName!=null){ // added by amit das on 06-12-2016
			if(reportName.equalsIgnoreCase("hmis"))
				reportFileName = "HMIS_Data_Report";
			else if(reportName.equalsIgnoreCase("goiMonthly"))
				reportFileName = "PH_GOI_Monthly_Report";
			
			HMSUtil.generateReport(reportFileName, requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());   // changed by amit das on 06-12-2016
		}
		return null;

	}

	// ===================== Upadate Hims Report Date for Month

	public ModelAndView updateHmisReportData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String counter = "";
		String reportName = null;
		int hospitalId;
		HttpSession session = request.getSession();
		session = request.getSession(true);
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("counter") != null
					&& !request.getParameter("counter").equals("")) {
				counter = request.getParameter("counter");
				box.put("counter", counter);
			}
			if (session.getAttribute(HOSPITAL_ID) != null
					&& !session.getAttribute(HOSPITAL_ID).equals("")) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}

			if(box.get("reportName")!=null){
				reportName = box.get("reportName");
			}
			
			
			map = pubHealthHandlerService.updateHmisReportData(box);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "hmisReportJsp";
			jsp += ".jsp";
			title = "HMIS";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("reportName", reportName); // added by amit das on 06-12-2016
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView gethmisbyMonthValue(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestmap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int fromMonth = 0;
		int currentMonth = 0;
		int currentYear = 0;
		int hospitalId = 0;

		if (request.getParameter("monthValue") != null
				&& !request.getParameter("monthValue").equals("")) {
			fromMonth = Integer.parseInt(request.getParameter("monthValue"));
			System.out.println(fromMonth);
			requestmap.put("fromMonth", fromMonth);
		}
		if (request.getParameter("months") != null
				&& !request.getParameter("months").equals("")) {
			currentMonth = Integer.parseInt(request.getParameter("months"));
			box.put("currentMonth", currentMonth);
		}

		int year = Calendar.getInstance().get(Calendar.YEAR);
		requestmap.put("year", year);
		if (session.getAttribute(HOSPITAL_ID) != null
				&& !session.getAttribute(HOSPITAL_ID).equals("")) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			requestmap.put("hospitalId", hospitalId);
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.gethmisbyMonthValue(requestmap);
		map.putAll(pubHealthHandlerService.getHMISCountFromDatabase(box));
		jsp = "hmisReportMonthJsp";

		title = "HMIS";

		return new ModelAndView(jsp, "map", map);

	}
				
				
	public ModelAndView createHmisbyMonthExcelList(HttpServletRequest request,
						HttpServletResponse response) {
					Box box = HMSUtil.getBox(request);
					Map<String, Object> map = new HashMap<String, Object>();
					String hospitalName = "";
					int fromMonth=0;
					int toMonth=0;
					int year=0;
						String monthFromName="";
						String monthToName="";	
					try {
						if(request.getParameter("frommonths")!=null &&! request.getParameter("frommonths").equals("")){
							fromMonth=Integer.parseInt(request.getParameter("frommonths"));
							box.put("fromMonth",fromMonth);
						}
						if(request.getParameter("tomonths")!=null &&! request.getParameter("tomonths").equals("")){
							toMonth=Integer.parseInt(request.getParameter("tomonths"));
							box.put("toMonth",toMonth);
							System.out.println(toMonth);
						}
						
						if(fromMonth == 1 )
						{
							monthFromName="Jan";
						}
						if(fromMonth == 2 )
						{
							monthFromName="Feb";
						}
						if(fromMonth == 3 )
						{
							monthFromName="Mar";
						}					
						if(fromMonth == 4 )
						{
							monthFromName="Apr";
						}
						if(fromMonth == 5)
						{
							monthFromName="May";
						}					
						if(fromMonth == 6)
						{
							monthFromName="Jun";
						}					
						if(fromMonth == 7  )
						{
							monthFromName="Jul";
						}					
						if(fromMonth == 8 )
						{
							monthFromName="Aug";
						}					
						if(fromMonth == 9 )
						{
							monthFromName="Sep";
						}					
						if(fromMonth == 10 )
						{
							monthFromName="Oct";
						}					
						if(fromMonth == 11 )
						{
							monthFromName="Nov";
						}					
						if(fromMonth == 12  )
						{
							monthFromName="Dec";
						}	
						
						if(toMonth == 1 )
						{
							monthToName="Jan";
						}
						if(toMonth == 2 )
						{
							monthToName="Feb";
						}
						if(toMonth == 3 )
						{
							monthToName="Mar";
						}					
						if(toMonth == 4 )
						{
							monthToName="Apr";
						}
						if(toMonth == 5)
						{
							monthToName="May";
						}					
						if(toMonth == 6)
						{
							monthToName="Jun";
						}					
						if(toMonth == 7  )
						{
							monthToName="Jul";
						}					
						if(toMonth == 8 )
						{
							monthToName="Aug";
						}					
						if(toMonth == 9 )
						{
							monthToName="Sep";
						}					
						if(toMonth == 10 )
						{
							monthToName="Oct";
						}					
						if(toMonth == 11 )
						{
							monthToName="Nov";
						}					
						if(toMonth == 12  )
						{
							monthToName="Dec";
						}
						if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
							year=Integer.parseInt(request.getParameter("year"));
							box.put("year",year);
							System.out.println(year);
						}
						

					} catch (Exception e) {
						e.printStackTrace();
					}
				
					map = pubHealthHandlerService.createHmisbyMonthExcelList(box);
					List<Object[]> hmisDistrictReportList = new ArrayList<Object[]>();
						if (map.get("hmisDistrictReportList") != null)
							hmisDistrictReportList = (List) map.get("hmisDistrictReportList");
						System.out.println(hmisDistrictReportList.size()+"---hmisDistrictReportListhmisDistrictReportList");
						try {
							response.setContentType("application/vnd.ms-excel");
							response.setHeader("Content-Disposition","attachment; filename=HmisByMonthExcel.xls");

							WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
							WritableSheet ws = wb.createSheet("Sheet", 0);

							WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf = new WritableCellFormat(wf);
							wcf.setAlignment(Alignment.CENTRE);
							wcf.setWrap(true);

							WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
							wcf2.setWrap(true);
							
							
							WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf3 = new WritableCellFormat(wf3);
							wcf3.setAlignment(Alignment.CENTRE);
							wcf3.setWrap(false);


							CellView cell = new CellView();
							cell.setSize(3000);
							ws.setColumnView(0, cell);
							cell.setSize(4000);
							ws.setColumnView(1, cell);
							cell.setSize(7000);
							ws.setColumnView(2, cell);
							cell.setSize(3000);
							ws.setColumnView(3, cell);
							cell.setSize(3000);
							ws.setColumnView(4, cell);
							
							

							Label label = new Label(3, 0, "Organisation Unit Wise Progress Report", wcf3);
							ws.addCell(label);
							
							label = new Label(3, 1, "Facility", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 1, "KERALA", wcf3);
							ws.addCell(label);
							
							label = new Label(3, 2, "From", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 2, monthFromName +"-"+ year, wcf3);
							ws.addCell(label);
							
							label = new Label(5, 2, "To", wcf3);
							ws.addCell(label);
							
							label = new Label(6, 2, monthToName +"-"+ year, wcf3);
							ws.addCell(label);

							label = new Label(3, 3, "ALAPPUZHA", wcf);
							ws.addCell(label);

							label = new Label(4, 3, "ERNAKULAM", wcf);
							ws.addCell(label);

							label = new Label(5, 3, "IDUKKI", wcf);
							ws.addCell(label);

							label = new Label(6, 3, "KANNUR", wcf);
							ws.addCell(label);

							label = new Label(7, 3, "KASARAGOD", wcf);
							ws.addCell(label);

							label = new Label(8, 3, "KOLLAM", wcf);
							ws.addCell(label);

							label = new Label(9, 3, "KOTTAYAM", wcf);
							ws.addCell(label);

							label = new Label(10, 3, "KOZHIKODE", wcf);
							ws.addCell(label);

							label = new Label(11, 3, "MALAPPURAM", wcf);
							ws.addCell(label);
							label = new Label(12, 3, "PALAKKAD", wcf);
							ws.addCell(label);
							label = new Label(13, 3, "PATHANAMTHITTA", wcf);
							ws.addCell(label);
							label = new Label(14, 3, "THIRUVANANTHAPURAM", wcf);
							ws.addCell(label);
							label = new Label(15, 3, "THRISSUR", wcf);
							ws.addCell(label);
							label = new Label(16, 3, "WAYANAD", wcf);
							ws.addCell(label);
							label = new Label(17, 3, "KERALA", wcf);
							ws.addCell(label);
							

							if (hmisDistrictReportList.size() > 0) {
								int count = 4;
								
								Iterator<Object[]> it = hmisDistrictReportList.iterator();

								while (it.hasNext()) {
									Object[] ob = it.next();
									String hmis_parameter = "";
									String hmis_id = "";
									String alappuzha_modify="";
									String ernakulam_modify="";
									String idukki_modify="";
									String kannur_modify="";
									String kasaragod_modify="";
									String kollam_modify="";
									String kottayam_modify="";
									String kozhikode_modify="";
									String malappuram_modify="";
									String palakkad_modify="";
									String pathanamthitta_modify="";
									String thiruvananthapuram_modify="";
									String thrissur_modify="";
									String wayanad_modify="";
									String total_kerala="";
									Integer sum_kerala=0;
									String total = "";
								
							
									if (ob[0] != null)
										hmis_id = "" + ob[0];
								
									if (ob[1] != null)
										hmis_parameter = "" + ob[1];
								
								if(!hmis_id.startsWith("M") && !hmis_id.startsWith("Part")) {
									total = "TOTAL";
									
									if (ob[2] != null) {
										alappuzha_modify =ob[2].toString();
										sum_kerala += (Integer)ob[2];
									}
									
									if (ob[3] != null) {
										ernakulam_modify = ob[3].toString();
										sum_kerala += (Integer)ob[3];
									}
								
									if (ob[4] != null) {
										idukki_modify =  ob[4].toString();
										sum_kerala += (Integer)ob[4];
									}
									
									if (ob[5] != null) {
										kannur_modify =  ob[5].toString();
										sum_kerala += (Integer)ob[5];
									}
									
									if (ob[6] != null) {
										kasaragod_modify =  ob[6].toString();
										sum_kerala += (Integer)ob[6];
									}
									
									if (ob[7] != null) {
										kollam_modify =  ob[7].toString();
										sum_kerala += (Integer)ob[7];
									}
									
									if (ob[8] != null) {
										kottayam_modify =  ob[8].toString();
										sum_kerala += (Integer)ob[8];
									}
									
									if (ob[9] != null) {
										kozhikode_modify =  ob[9].toString();
										sum_kerala += (Integer)ob[9];
									}
									
									if (ob[10] != null) {
										malappuram_modify =  ob[10].toString();
										sum_kerala += (Integer)ob[10];
									}
									
									if (ob[11] != null) {
										palakkad_modify =  ob[11].toString();
										sum_kerala += (Integer)ob[11];
									}
									
									if (ob[12] != null) {
										pathanamthitta_modify =  ob[12].toString();
										sum_kerala += (Integer)ob[12];
									}
									
									if (ob[13] != null) {
										thiruvananthapuram_modify =  ob[13].toString();
										sum_kerala += (Integer)ob[13];
									}
									
									if (ob[14] != null) {
										thrissur_modify = ob[14].toString();
										sum_kerala += (Integer)ob[14];
									}
									
									if (ob[15] != null) {
										wayanad_modify = ob[15].toString();
										sum_kerala += (Integer)ob[15];
									}
									
									total_kerala = sum_kerala.toString();
								}
									label = new Label(0, count, hmis_id, wcf2);
									ws.addCell(label);
									
									label = new Label(1, count, hmis_parameter, wcf2);
									ws.addCell(label);
									
									label = new Label(2, count, total, wcf2);
									ws.addCell(label);
									
									label = new Label(3, count,alappuzha_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(4, count, ernakulam_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(5, count, idukki_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(6, count, kannur_modify, wcf2);
									ws.addCell(label);
									
									
									label = new Label(7, count, kasaragod_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(8, count, kollam_modify, wcf2);
									ws.addCell(label);
									
									
									label = new Label(9, count, kottayam_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(10, count, kozhikode_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(11, count, malappuram_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(12, count, palakkad_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(13, count, pathanamthitta_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(14, count, thiruvananthapuram_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(15, count, thrissur_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(16, count, wayanad_modify, wcf2);
									ws.addCell(label);
									
									label = new Label(17, count, total_kerala, wcf2);
									ws.addCell(label);
									
									count++;
								}
							}

							wb.write();
							wb.close();

							return null;
						} catch (Exception ioe) {
							ioe.printStackTrace();
							jsp = "storeBalance";
							jsp += ".jsp";
							title = "Export CD";
							map.put("contentJsp", jsp);
							map.put("title", title);
							return new ModelAndView("index", "map", map);
						}
					
				}

				
				// added by Amit Das on 29-04-2016
				public ModelAndView showFormLJsp(HttpServletRequest request,
							HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Box box = HMSUtil.getBox(request);
					HttpSession session = request.getSession();

					jsp = "idsp_hospital_report_formL" + ".jsp";
					map.put("contentJsp", jsp);
							
					return new ModelAndView("index", "map", map);
				}
				
				
				public ModelAndView showHMISExcelMenuJsp(
						HttpServletRequest request, HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> details = new HashMap<String, Object>();
					Box box = HMSUtil.getBox(request);
					int hospitalId;
					HttpSession session = request.getSession();
				    session = request.getSession(true);
					
					jsp = "hmisReportJsp" + ".jsp";
					map.put("contentJsp", jsp);
					return new ModelAndView("index", "map", map);
				}
				
				public ModelAndView getItemListForAutoCompleteForICDandInvastigation(HttpServletRequest request,
						HttpServletResponse response) {
					HttpSession session = request.getSession();
					Map<String, Object> map = new HashMap<String, Object>();
					String itemNameField = "";
					String autoHint = "";
					String invNameField = "";
					String invName = "";
					try {
					
						if (request.getParameter("requiredFieldInv") != null) {
							invNameField = (request.getParameter("requiredFieldInv"));

						}
						if (request.getParameter(invNameField) != null) {
							invName = (request.getParameter(invNameField));

						}
						
						map.put("autoHint", autoHint);
						map.put("invName", invName);
						map = pubHealthHandlerService.getItemListForAutoCompleteForICDandInvastigation(map);
					} catch (Exception e) {
						e.printStackTrace();
					}
					jsp = "responseForInvAutocomplete";

					return new ModelAndView(jsp, "map", map);
				}
			
			public ModelAndView addInvastigationIcdMapping(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				try {
					
					map = pubHealthHandlerService.addInvastigationIcdMapping(box);
					jsp = "responseForDiseasesIcdMapping";
					
					if(box.get("invId")!=null)
						map.put("invId", box.getInt("invId"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
			
			// Added by Kaushal Mishra
			public ModelAndView getStudentAllDetailsById(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int studentId = 0;
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("studentId") != null) {
						studentId = Integer.parseInt(request.getParameter("studentId"));
					}
                   System.out.println(studentId);
					dataMap.put("studentId", studentId);
					map = pubHealthHandlerService.getStudentAllDetailsById(dataMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "studentDetailsById";
				jsp += ".jsp";
				title = "All Details";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
				
			}

			public ModelAndView getIndividualStudentDetails(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int phStudentsHealthDetailsId = 0;
				int studentId=0;
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("phStudentsHealthDetailsId") != null) {
						phStudentsHealthDetailsId = Integer.parseInt(request.getParameter("phStudentsHealthDetailsId"));
					}
					if (request.getParameter("studentId") != null) {
						studentId = Integer.parseInt(request.getParameter("studentId"));
					}
                   System.out.println(studentId);
                   System.out.println(phStudentsHealthDetailsId);
					dataMap.put("studentId", studentId);
					dataMap.put("phStudentsHealthDetailsId", phStudentsHealthDetailsId);
					map = pubHealthHandlerService.getIndividualStudentDetails(dataMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "individualStudentDetails.jsp";
				title = "All Details";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
				
			}
			
			public ModelAndView showStockReservationForImmunization(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				int deptId = 0;
				int userId = 0;
				session = request.getSession();

				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
							.toString());
				}
				if (session.getAttribute("deptId") != null) {
					deptId = Integer
							.parseInt(session.getAttribute("deptId").toString());
				}
				if (session.getAttribute("userId") != null) {
					userId = Integer
							.parseInt(session.getAttribute("userId").toString());
				}
				box.put("hospitalId", hospitalId);
				box.put("deptId", deptId);
				map = pubHealthHandlerService.showStockReservationForImmunization(box);
				jsp = "stockReservationForImmunization";
				jsp = jsp + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}
			
			public ModelAndView submitResrvedStockForImmunization(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					box.put("deptId", deptId);
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
					box.put("userId", userId);
				}
				String url = "";
				map = pubHealthHandlerService.submitResrvedStockForImmunization(box);
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				String messageTOBeVisibleToTheUser = "";
				if (flag) {
					messageTOBeVisibleToTheUser = "Record Saved Successfully";
				} else {
					messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
					map.put("messageType", "failure");
				}
				jsp = "annualIndentMessage";
				url = "/hms/hms/stores?method=showStockReservationJsp";
				// jsp = "annualDepartmentIndentCreationApproval";
				jsp = jsp + ".jsp";
				title = "GRN";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
				return new ModelAndView("index", "map", map);
			}
			public ModelAndView showStockConsumptionForImmunization(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				int deptId = 0;
				int userId = 0;
				session = request.getSession();

				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
							.toString());
				}
				if (session.getAttribute("deptId") != null) {
					deptId = Integer
							.parseInt(session.getAttribute("deptId").toString());
				}
				if (session.getAttribute("userId") != null) {
					userId = Integer
							.parseInt(session.getAttribute("userId").toString());
				}
				box.put("hospitalId", hospitalId);
				box.put("deptId", deptId);
				map = pubHealthHandlerService.showStockConsumptionForImmunization(box);
				jsp = "stockConsumptionForImmunization";
				jsp = jsp + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}
			public ModelAndView responseForStockConsumptionForImmunization(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				int deptId = 0;
				int userId = 0;
				session = request.getSession();

				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
							.toString());
				}
				if (session.getAttribute("deptId") != null) {
					deptId = Integer
							.parseInt(session.getAttribute("deptId").toString());
				}

				box.put("hospitalId", hospitalId);
				box.put("deptId", deptId);
				map = pubHealthHandlerService.responseForStockConsumptionForImmunization(box);
				jsp = "responseForConsumptionForImmuniztion";
				map.put("contentJsp", jsp);
				return new ModelAndView(jsp, "map", map);
			}
			
			public ModelAndView submitConsumptionForImmunization(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					box.put("deptId", deptId);
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
					box.put("userId", userId);
				}
				String url = "";
				map = pubHealthHandlerService.submitConsumptionForImmunization(box);
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				String messageTOBeVisibleToTheUser = "";
				if (flag) {
					messageTOBeVisibleToTheUser = "Record Saved Successfully";
				} else {
					messageTOBeVisibleToTheUser = "Records Not Added/Updated!... Try Again.....";
					map.put("messageType", "failure");
				}
				jsp = "annualIndentMessage";
				url = "/hms/hms/stores?method=showStockReservationJsp";
				// jsp = "annualDepartmentIndentCreationApproval";
				jsp = jsp + ".jsp";
				title = "GRN";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
				return new ModelAndView("index", "map", map);
			}
			public void fillItemsForDefectiveDrugs(HttpServletRequest request,
					HttpServletResponse response) {
				// --------------- Retriving User Name,Hospital Id,Department Id from
				// Session------'
				Map<String, Object> map = new HashMap<String, Object>();
				String userName = "";
				int deptId = 0;
				int hospitalId = 0;
				HttpSession session = request.getSession();
				if (session.getAttribute("userName") != null)
					userName = (String) session.getAttribute("userName");
				if (session.getAttribute("hospitalId") != null)
					hospitalId = Integer.parseInt(""
							+ session.getAttribute("hospitalId"));
				if (session.getAttribute("deptId") != null)
					deptId = Integer.parseInt("" + session.getAttribute("deptId"));
				// --------------------------------------------------------------------------------
				List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
				List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
				List<Object[]> batchList = new ArrayList<Object[]>();

				Box box = HMSUtil.getBox(request);
				String itemNameField = "";
				String pvmsNo = "";
				String blockFlag = "";
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (request.getParameter("pvmsNo") != null) {
					pvmsNo = (request.getParameter("pvmsNo"));
				}
				if (session.getAttribute("users") != null) {
					Users users = (Users) session.getAttribute("users");
					int userType = users.getUserType();
					dataMap.put("userType", userType);
				}
				
				if (request.getParameter("blockFlag") != null) {
					blockFlag = (request.getParameter("blockFlag"));
				}
				dataMap.put("pvmsNo", pvmsNo);
				dataMap.put("deptId", deptId);
				dataMap.put("userName", userName);
				dataMap.put("hospitalId", hospitalId);
				dataMap.put("blockFlag", blockFlag);
				map = pubHealthHandlerService.fillItemsForDefectiveDrugs(dataMap);
				if (map.get("itemList") != null) {
					itemList = (List) map.get("itemList");
				}
				/*
				 * if (map.get("brandList") != null) { brandList = (List)
				 * map.get("brandList"); }
				 */
				if (map.get("batchList") != null) {
					batchList = (List) map.get("batchList");
				}

				StringBuffer sb = new StringBuffer();
				try {
					
					sb.append("<item>");
				
					for (MasStoreItem masStoreItem : itemList) {
						
						sb.append("<id>" + masStoreItem.getId() + "</id>");
						sb.append("<pvms>" + masStoreItem.getPvmsNo() + "</pvms>");
						sb.append("<au>"+ masStoreItem.getItemConversion().getItemUnitName()+ "</au>");
						System.out.println("auId==="+masStoreItem.getItemConversion().getId());
						sb.append("<auId>"+ masStoreItem.getItemConversion().getId() + "</auId>");

						// sb.append("<manufacturerId>"+
						// masStoreItem.getManufacturer().getId() +"</manufacturerId>");
						// sb.append("<manufacturerName>" +
						// masStoreItem.getManufacturer().getManufacturerName()+
						// "</manufacturerName>");
					if(batchList.size()>0){
						sb.append("<batchs>");
						for (Object[] batch : batchList) {
							sb.append("<batch>");
						/*	sb.append("<batchId>" + batch.getId() + "</batchId>");*/
							sb.append("<batchName>" + batch[1]
									+ "</batchName>");
							sb.append("</batch>");
						}
						sb.append("</batchs>");

					}else{
						
						sb.append("<msg>" + "Item Batch Not Available" + "</msg>");
					}

				}
						sb.append("</item>");

					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					response.getWriter().write(
							"<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			public void getExpiryDateInAjax(HttpServletRequest request,
					HttpServletResponse response) throws ParseException {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				int deptId = 0;
				int batchId = 0;
				String batchNo = "";
				int itemId = 0;
				String manufactureDate = "";
				int manufactureId = 0;
				String manufactureName = "";
				String batchNoString = "";
				StoreItemBatchStock storeItemBatchStock = new StoreItemBatchStock();
				String batchName = "";
				Date expirydate = new Date();
				List<MasStoreBrand> brandList = new ArrayList<MasStoreBrand>();
				Map<String, Object> dataMap = new HashMap<String, Object>();
				if (session.getAttribute("deptId") != null)
					deptId = Integer.parseInt("" + session.getAttribute("deptId"));

				if (request.getParameter(BATCH_ID) != null) {
					batchNo = ("" + (request.getParameter(BATCH_ID)));
					dataMap.put("batchNo", batchNo);
				}
				else if (request.getParameter("batchName") != null) {
					batchName = ("" + (request.getParameter("batchName")));
					dataMap.put("batchName", batchName);
					
				}
				dataMap.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
				System.out.println("itemId==111==="+Integer.parseInt("" + (request.getParameter("itemId"))));
				if (request.getParameter("itemId") != null) {
					itemId = Integer.parseInt("" + (request.getParameter("itemId")));
				}
				dataMap.put("itemId", itemId);
				dataMap.put("deptId", deptId);
				
				String date4MySQL1 = "";
				try {
					map = pubHealthHandlerService.getExpiryDateInAjax(dataMap);
					SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat formatterOut = new SimpleDateFormat("dd/MM/yyyy");
					if (map.get("expiryDate") != null) {
						date4MySQL1 = formatterOut.format(formatterIn.parse(""
								+ map.get("expiryDate")));
					}
					storeItemBatchStock = (StoreItemBatchStock) map.get("storeItemBatchStock");
					if (map.get("manufactureDate") != null) {
						manufactureDate = formatterOut.format(formatterIn.parse(""
								+ map.get("manufactureDate")));
					}
					if (map.get("manufactureId") != null) {
						manufactureId = (Integer) map.get("manufactureId");
					}
					if (map.get("manufactureName") != null) {
						manufactureName = (String) map.get("manufactureName");
					}
					if (map.get("batchNoString") != null) {
						batchNoString = (String) map.get("batchNoString");
					}
					System.out.println("stock===-====="+ storeItemBatchStock.getClosingStock().intValue());
				} catch (Exception e) {
					e.printStackTrace();
				}
				int mId = 1;
				if (map.get("mId") != null) {
					mId = Integer.parseInt(("" + map.get("mId")));
				}
				StringBuffer sb = new StringBuffer();
				try {
					sb.append("<item>");
					sb.append("<expiryDate>" + date4MySQL1 + "</expiryDate>");
					sb.append("<manufactureDate>" + manufactureDate
							+ "</manufactureDate>");
					sb.append("<manufacturerId>" + manufactureId + "</manufacturerId>");
					sb.append("<manufacturerName>" + manufactureName
							+ "</manufacturerName>");
					sb.append("<mId>" + mId + "</mId>");
					sb.append("<costPrice>" + storeItemBatchStock.getCostPrice()
							+ "</costPrice>");
					sb.append("<stockId>" + storeItemBatchStock.getId() + "</stockId>");
					sb.append("<stockAvailable>"
							+ storeItemBatchStock.getClosingStock().intValue()
							+ "</stockAvailable>");
					sb.append("<batchNo>" + batchNoString + "</batchNo>");

					sb.append("</item>");
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					response.getWriter().write(
							"<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// added by Amit Das on 03-05-2016
			@SuppressWarnings("unused")
			public ModelAndView generateAntenatalCareReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				Date currentDate = null;
				
				try {
					if (session.getAttribute(HOSPITAL_ID) != null){
						hospitalId = Integer.parseInt(session.getAttribute(HOSPITAL_ID).toString());
						requestParameters.put("hospitalId", hospitalId);
						box.put(HOSPITAL_ID, hospitalId);
					 }
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				requestParameters.put("SUBREPORT_DIR",
						getServletContext().getRealPath("/Reports/"));
				pubHealthHandlerService.addTempDataForAntenatalCareReport(box);
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("AntenatalCare", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// added by Amit Das on 22-04-2016
			public ModelAndView deleteIcdInvestigationMapping(HttpServletRequest request,
								HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				try {
						map = pubHealthHandlerService.deleteIcdInvestigationMapping(box);
						jsp = "responseForDiseasesIcdMapping";
						
						/*
						if(box.get("diseasesName")!=null)
							map.put("diseasesName", box.get("diseasesName"));*/
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
			
			
			public ModelAndView vectoreSurvey(HttpServletRequest request,
					HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
						Box box = HMSUtil.getBox(request);
						HttpSession session = request.getSession();
						int hospitalId=(Integer)session.getAttribute("hospitalId");
						box.put("hospitalId", hospitalId);
						try {
							map = pubHealthHandlerService.vectorSurveyDetail(box); 
							} catch (Exception e) {
									e.printStackTrace();
							}
						String jsp = "phOsVectorSurvey.jsp";
						map.put("contentJsp", jsp);
						map.put("title", title);
						return new ModelAndView("index", "map", map);
			}
			
			public ModelAndView showVectorDetail(HttpServletRequest request,
					HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
						Box box = HMSUtil.getBox(request);
						HttpSession session = request.getSession();
						int hospitalId=(Integer)session.getAttribute("hospitalId");
						box.put("hospitalId", hospitalId);
						String[] loc = null;
						if(request.getParameterValues("location")!=null){
							loc = (String[])request.getParameterValues("location");
						}
						String locId = "";
						if(loc!=null){
							for (int i = 0; i < loc.length; i++) {
								if(!locId.equals("")){
									locId.concat(",");
								}
								locId.concat(loc[i].toString());
							}
						}
						box.put("locId", locId);
						try {
							map = pubHealthHandlerService.showVectorDetail(box,loc); 
							} catch (Exception e) {
									e.printStackTrace();
							}
						String jsp = "phOsVectorSurvey.jsp";
						map.put("contentJsp", jsp);
						map.put("title", title);
						map.put("locationId", box.getInt("location"));
						return new ModelAndView("index", "map", map);
			}

			// added by Arbind on 07-08-2017
			public ModelAndView showMCTSReportJsp(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				String jsp = "";
				jsp = "mctsJsp" + ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}

			// added by Amit Das on 02-06-2016
			public ModelAndView generatetMCTSReport(HttpServletRequest request,
							HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				List<Object[]> list = null;
				Map<String,Object> utilMap = new HashMap<String,Object>();
				MasHospital masHospital = null;
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				int hospitalId = 0;
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					if(session.getAttribute(HOSPITAL_ID)!=null){
						hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
						box.put(HOSPITAL_ID, hospitalId);
						map = pubHealthHandlerService.getMCTSReportData(box);
						
						if (map.get("list") != null)
							list = (List) map.get("list");
						
						
							response.setContentType("application/vnd.ms-excel");
							response.setHeader("Content-Disposition","attachment; filename=MCTS.xls");

							WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
							WritableSheet ws = wb.createSheet("Sheet", 0);

							WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf = new WritableCellFormat(wf);
							wcf.setAlignment(Alignment.CENTRE);
							wcf.setWrap(true);

							WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
							wcf2.setWrap(true);
							
							
							WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf3 = new WritableCellFormat(wf3);
							wcf3.setAlignment(Alignment.CENTRE);
							wcf3.setWrap(false);
							


							CellView cell = new CellView();
							cell.setSize(1000);
							ws.setColumnView(0, cell);
							cell.setSize(8000);
							ws.setColumnView(1, cell);
							cell.setSize(8000);
							ws.setColumnView(2, cell);
							cell.setSize(3000);
							ws.setColumnView(3, cell);
							cell.setSize(8000);
							ws.setColumnView(4, cell);
							cell.setSize(6000);
							ws.setColumnView(5, cell);
							cell.setSize(6000);
							ws.setColumnView(6, cell);
							cell.setSize(6000);
							ws.setColumnView(7, cell);
							
							

							Label label = new Label(3, 0, "Detailed Report Of Registered Mother", wcf3);
							ws.addCell(label);
							
							
							label = new Label(1, 7, "S.no", wcf3);
							ws.addCell(label);
							
							label = new Label(2, 7, "Registration Date", wcf3);
							ws.addCell(label);
							
							label = new Label(3, 7, "Updated Date", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 7, "Health Facility", wcf3);
							ws.addCell(label);
							
							label = new Label(5, 7, "SubFacility / SubCenter", wcf3);
							ws.addCell(label);
							
							label = new Label(6, 7, "Village", wcf3);
							ws.addCell(label);
							
							label = new Label(7, 7, "Address", wcf3);
							ws.addCell(label);
							
							label = new Label(8, 7, "Year", wcf3);
							ws.addCell(label);
							
							label = new Label(9, 7, "Mother ID", wcf3);
							ws.addCell(label);
							
							label = new Label(10, 7, "Mother Name", wcf3);
							ws.addCell(label);
							
							label = new Label(11, 7, "Husband's Name", wcf3);
							ws.addCell(label);
							
							label = new Label(12, 7, "Phone No.", wcf3);
							ws.addCell(label);
							
							label = new Label(13, 7, "Date Of Birth", wcf3);
							ws.addCell(label);
							
							label = new Label(14, 7, "Age", wcf3);
							ws.addCell(label);
							
							label = new Label(15, 7, "JSY Beneficiary", wcf3);
							ws.addCell(label);
							
							label = new Label(16, 7, "Caste", wcf3);
							ws.addCell(label);
							
							label = new Label(17, 7, "ASHA Name", wcf3);
							ws.addCell(label);
							
							label = new Label(18, 7, "ASHA Phone No.", wcf3);
							ws.addCell(label);
							
							label = new Label(19, 7, "Aadhaar No.", wcf3);
							ws.addCell(label);
							
							label = new Label(20, 7, "LMP Date", wcf3);
							ws.addCell(label);
							
							label = new Label(21, 7, "ANC1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(22, 7, "ANC2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(23, 7, "ANC3 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(24, 7, "ANC4 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(25, 7, "TT1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(26, 7, "TT2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(27, 7, "TTBooster Date", wcf3);
							ws.addCell(label);
							
							label = new Label(28, 7, "ANC Complication", wcf3);
							ws.addCell(label);
							
							label = new Label(29, 7, "Delivery/Abortion Date", wcf3);
							ws.addCell(label);
							
							label = new Label(30, 7, "Expected Date Of Delivery Date", wcf3);
							ws.addCell(label);
							
							label = new Label(31, 7, "Delivery Place (Home)", wcf3);
							ws.addCell(label);
							
							label = new Label(32, 7, "Delivery Place (Public Institution)", wcf3);
							ws.addCell(label);
							
							label = new Label(33, 7, "Delivery Place (Private Institution)", wcf3);
							ws.addCell(label);
							
							label = new Label(34, 7, "Delivery Type", wcf3);
							ws.addCell(label);
							
							label = new Label(35, 7, "Complications", wcf3);
							ws.addCell(label);
							
							label = new Label(36, 7, "Date Of Discharge From Institution", wcf3);
							ws.addCell(label);
							
							label = new Label(37, 7, "JSY Benefits Paid On (Date)", wcf3);
							ws.addCell(label);
							
							label = new Label(38, 7, "Abortion", wcf3);
							ws.addCell(label);
							
							label = new Label(39, 7, "PNC Home Visit", wcf3);
							ws.addCell(label);

							label = new Label(40, 7, "PNC Complication", wcf3);
							ws.addCell(label);
							
							label = new Label(41, 7, "PPC Method", wcf3);
							ws.addCell(label);
							
							label = new Label(42, 7, "PNC Checkup", wcf3);
							ws.addCell(label);
							
							label = new Label(43, 7, "Outcome No.", wcf3);
							ws.addCell(label);
							
							label = new Label(44, 7, "Child1 Name", wcf3);
							ws.addCell(label);
							
							label = new Label(45, 7, "Child1 Sex", wcf3);
							ws.addCell(label);
							
							label = new Label(46, 7, "Child1 Weight", wcf3);
							ws.addCell(label);
							
							label = new Label(47, 7, "Child1 Breast feeding", wcf3);
							ws.addCell(label);
							
							label = new Label(48, 7, "Child2 Name", wcf3);
							ws.addCell(label);
							
							label = new Label(49, 7, "Child2 Sex", wcf3);
							ws.addCell(label);
							
							label = new Label(50, 7, "Child2 Weight", wcf3);
							ws.addCell(label);
							
							label = new Label(51, 7, "Child2 Breast feeding", wcf3);
							ws.addCell(label);
							
							label = new Label(52, 7, "Is Upload", wcf3);
							ws.addCell(label);
							
							label = new Label(53, 7, "Status", wcf3);
							ws.addCell(label);
							
							label = new Label(54, 7, "Is Data Sent to CPSMS", wcf3);
							ws.addCell(label);
							
							label = new Label(55, 7, "Bank Name", wcf3);
							ws.addCell(label);
							
							label = new Label(56, 7, "Branch Name", wcf3);
							ws.addCell(label);
							
							label = new Label(57, 7, "IFSC Code", wcf3);
							ws.addCell(label);
							
							label = new Label(58, 7, "Account No.", wcf3);
							ws.addCell(label);
							
							label = new Label(59, 7, "Remarks", wcf3);
							ws.addCell(label);
							

							if (list!=null && list.size() > 0) {
								int count = 9;
								int sNo = 1;
								
								for(Object[] object : list) {
									
									label = new Label(1, count, Integer.toString(sNo), wcf2);
									ws.addCell(label);
									
									label = new Label(2, count, (object[0]!=null)?df.format((Date)object[0]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(3, count, (object[1]!=null)?df.format((Date)object[1]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(4, count, (String)object[2], wcf2);
									ws.addCell(label);
									
									label = new Label(5, count, (String)object[2], wcf2);
									ws.addCell(label);
									
									label = new Label(6, count, (String)object[3], wcf2);
									ws.addCell(label);
									
									label = new Label(7, count, (String)object[4], wcf2);
									ws.addCell(label);
									
									label = new Label(8, count, Double.toString((Double)object[5]), wcf2);
									ws.addCell(label);

									label = new Label(9, count, (String)object[6], wcf2);
									ws.addCell(label);
									
									label = new Label(10, count, (String)object[7], wcf2);
									ws.addCell(label);
									
									label = new Label(11, count, (String)object[8], wcf2);
									ws.addCell(label);
									
									label = new Label(12, count, (String)object[9], wcf2);
									ws.addCell(label);
									
									label = new Label(13, count, (object[10]!=null)?df.format((Date)object[10]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(14, count, Double.toString((Double)object[11]), wcf2);
									ws.addCell(label);
									
									label = new Label(15, count, (String)object[12], wcf2);
									ws.addCell(label);
									
									label = new Label(16, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(17, count, (object[13]!=null)?((BigInteger)object[13]).toString():"" , wcf2);
									ws.addCell(label);
									
									label = new Label(18, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(19, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(20, count, (object[14]!=null)?df.format((Date)object[14]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(21, count, (object[15]!=null)?df.format((Date)object[15]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(22, count, (object[16]!=null)?df.format((Date)object[16]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(23, count, (object[17]!=null)?df.format((Date)object[17]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(24, count, (object[18]!=null)?df.format((Date)object[18]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(25, count, (object[19]!=null)?df.format((Date)object[19]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(26, count, (object[20]!=null)?df.format((Date)object[20]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(27, count, (object[21]!=null)?df.format((Date)object[21]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(28, count, (object[22]!=null)?df.format((Date)object[22]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(29, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(30, count, (object[23]!=null)?df.format((Date)object[23]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(31, count, (String)object[24], wcf2);
									ws.addCell(label);
									
									label = new Label(32, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(33, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(34, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(35, count, (String)object[25], wcf2);
									ws.addCell(label);
									
									label = new Label(36, count, (String)object[26], wcf2);
									ws.addCell(label);
									
									label = new Label(37, count, (String)object[27], wcf2);
									ws.addCell(label);
									
									label = new Label(38, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(39, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(40, count, (String)object[28], wcf2);
									ws.addCell(label);
									
									label = new Label(41, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(42, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(43, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(44, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(45, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(46, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(47, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(48, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(49, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(50, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(51, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(52, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(53, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(54, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(55, count, (String)object[29], wcf2);
									ws.addCell(label);
									
									label = new Label(56, count, (String)object[29], wcf2);
									ws.addCell(label);
									
									label = new Label(57, count, (String)object[30], wcf2);
									ws.addCell(label);
									
									label = new Label(58, count, (String)object[31], wcf2);
									ws.addCell(label);
									
									label = new Label(59, count, (String)object[32], wcf2);
									ws.addCell(label);
									
								/*	label = new Label(1, count, (String)object[33], wcf2);
									ws.addCell(label);*/
									
									sNo++;
									count++;
								}
								
			
							}

							wb.write();
							wb.close();

							
					}
				} catch (Exception e) {
						e.printStackTrace();
				}
				return null;			
			}

			// added by Arbind 10-08-2017
			public ModelAndView generateMCTSChildReport(HttpServletRequest request,	HttpServletResponse response) {
			
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				List<Object[]> list = null;
				Map<String,Object> utilMap = new HashMap<String,Object>();
				MasHospital masHospital = null;
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				int hospitalId = 0;
				String hospitalName = "";
				Date fromDate = null;
				Date toDate = null;
				if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				}
				if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				}
				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				try {
					if(session.getAttribute(HOSPITAL_ID)!=null){
						hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
						box.put(HOSPITAL_ID, hospitalId);
						map = pubHealthHandlerService.getMCTSChildReportData(box);
						
						if (map.get("list") != null)
							list = (List) map.get("list");
						if (map.get("hospitalName") != null)
							hospitalName = (String) map.get("hospitalName");
						
						
							response.setContentType("application/vnd.ms-excel");
							response.setHeader("Content-Disposition","attachment; filename=MCTS_Child.xls");

							WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
							WritableSheet ws = wb.createSheet("Sheet", 0);

							WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf = new WritableCellFormat(wf);
							wcf.setAlignment(Alignment.CENTRE);
							wcf.setWrap(false);

							WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
							wcf2.setWrap(true);
							
							
							WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
							WritableCellFormat wcf3 = new WritableCellFormat(wf3);
							wcf3.setAlignment(Alignment.CENTRE);
							wcf3.setWrap(true);
							


							CellView cell = new CellView();
							cell.setSize(3000);
							ws.setColumnView(0, cell);
							cell.setSize(4000);
							ws.setColumnView(1, cell);
							cell.setSize(4000);
							ws.setColumnView(2, cell);
							cell.setSize(6000);
							ws.setColumnView(3, cell);
							cell.setSize(8000);
							ws.setColumnView(4, cell);
							cell.setSize(6000);
							ws.setColumnView(5, cell);
							cell.setSize(6000);
							ws.setColumnView(6, cell);
							cell.setSize(4500);
							ws.setColumnView(8, cell);
							cell.setSize(4500);
							ws.setColumnView(9, cell);
							cell.setSize(3000);
							ws.setColumnView(10, cell);
							cell.setSize(3000);
							ws.setColumnView(13, cell);
							cell.setSize(4000);
							ws.setColumnView(48, cell);
							

							Label label = new Label(3, 0, "Detailed Report Of Registered Children", wcf);
							ws.addCell(label);
							
							label = new Label(3, 2, "Facility", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 2, hospitalName, wcf);
							ws.addCell(label);
							
							label = new Label(3, 3, "From", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 3, df.format(fromDate), wcf3);
							ws.addCell(label);
							
							label = new Label(5, 3, "To", wcf3);
							ws.addCell(label);
							
							label = new Label(6, 3, df.format(toDate), wcf3);
							ws.addCell(label);
							
							
							label = new Label(0, 7, "Sl.no", wcf3);
							ws.addCell(label);
							
							label = new Label(1, 7, "Registration Date", wcf3);
							ws.addCell(label);
							
							label = new Label(2, 7, "Updated Date", wcf3);
							ws.addCell(label);
							
							label = new Label(3, 7, "Health Facility", wcf3);
							ws.addCell(label);
							
							label = new Label(4, 7, "Sub Facility / Sub Center", wcf3);
							ws.addCell(label);
							
							label = new Label(5, 7, "Village", wcf3);
							ws.addCell(label);
							
							label = new Label(6, 7, "Address", wcf3);
							ws.addCell(label);
							
							label = new Label(7, 7, "Year", wcf3);
							ws.addCell(label);
							
							label = new Label(8, 7, "Child ID", wcf3);
							ws.addCell(label);
							
							label = new Label(9, 7, "Child Name", wcf3);
							ws.addCell(label);
							
							label = new Label(10, 7, "Mother's Name", wcf3);
							ws.addCell(label);
							
							label = new Label(11, 7, "Mother Id", wcf3);
							ws.addCell(label);
							
							label = new Label(12, 7, "Phone No.", wcf3);
							ws.addCell(label);
							
							label = new Label(13, 7, "Date Of Birth", wcf3);
							ws.addCell(label);
							
							label = new Label(14, 7, "Place Of Birth", wcf3);
							ws.addCell(label);
							
							label = new Label(15, 7, "Blood Group", wcf3);
							ws.addCell(label);
							
							label = new Label(16, 7, "Sex", wcf3);
							ws.addCell(label);
							
							label = new Label(17, 7, "Caste", wcf3);
							ws.addCell(label);
							
							label = new Label(18, 7, "ASHA Name", wcf3);
							ws.addCell(label);
							
							label = new Label(19, 7, "ASHA Phone No.", wcf3);
							ws.addCell(label);
							
							label = new Label(20, 7, "BCG Date", wcf3);
							ws.addCell(label);
							
							label = new Label(21, 7, "OPV0 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(22, 7, "Hepatitis B0 Date", wcf3);
							ws.addCell(label);

							label = new Label(23, 7, "DPT1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(24, 7, "OPV1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(25, 7, "Hepatitis B1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(26, 7, "DPT2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(27, 7, "OPV2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(28, 7, "Hepatitis B2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(29, 7, "DPT3 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(30, 7, "OPV3 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(31, 7, "Hepatitis B3 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(32, 7, "Measles Date", wcf3);
							ws.addCell(label);
							
							label = new Label(33, 7, "Vit A Dose1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(34, 7, "MR Date", wcf3);
							ws.addCell(label);
							
							label = new Label(35, 7, "DPTBooster Date", wcf3);
							ws.addCell(label);
							
							label = new Label(36, 7, "OPVBooster Date", wcf3);
							ws.addCell(label);
							
							label = new Label(37, 7, "Vit A Dose2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(38, 7, "Vit A Dose3 Date", wcf3);
							ws.addCell(label);

							label = new Label(39, 7, "JE Date", wcf3);
							ws.addCell(label);
							
							label = new Label(40, 7, "Vit A Dose9 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(41, 7, "DT5 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(42, 7, "TT10 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(43, 7, "TT16 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(44, 7, "Measles 2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(45, 7, "Penta-valent 1 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(46, 7, "Penta-valent 2 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(47, 7, "Penta-valent 3 Date", wcf3);
							ws.addCell(label);
							
							label = new Label(48, 7, "Is Upload", wcf3);
							ws.addCell(label);
							
							label = new Label(49, 7, "Status", wcf3);
							ws.addCell(label);

							label = new Label(50, 7, "Remarks", wcf3);
							ws.addCell(label);
							

							if (list!=null && list.size() > 0) {
								int count = 9;
								int sNo = 1;
								
								for(Object[] object : list) {
									
									label = new Label(0, count, Integer.toString(sNo), wcf2);
									ws.addCell(label);
									
									label = new Label(1, count, (object[0]!=null)?df.format((Date)object[0]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(2, count, (object[1]!=null)?df.format((Date)object[1]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(3, count, (String)object[2], wcf2);
									ws.addCell(label);
									
									label = new Label(4, count, (String)object[3], wcf2);
									ws.addCell(label);
									
									label = new Label(5, count, (String)object[4], wcf2);
									ws.addCell(label);
									
									label = new Label(6, count, (String)object[5], wcf2);
									ws.addCell(label);
									
									label = new Label(7, count, (String)object[6], wcf2);
									ws.addCell(label);

									label = new Label(8, count, (String)object[7], wcf2);
									ws.addCell(label);
									
									label = new Label(9, count, (String)object[8], wcf2);
									ws.addCell(label);
									
									label = new Label(10, count, (String)object[9], wcf2);
									ws.addCell(label);
									
									label = new Label(11, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(12, count, (String)object[10], wcf2);
									ws.addCell(label);
									
									label = new Label(13, count, (object[11]!=null)?df.format((Date)object[11]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(14, count, (String)object[12], wcf2);
									ws.addCell(label);
									
									label = new Label(15, count, (String)object[13], wcf2);
									ws.addCell(label);
									
									label = new Label(16, count, (String)object[14], wcf2);
									ws.addCell(label);
									
									label = new Label(17, count, (String)object[15], wcf2);
									ws.addCell(label);
									
									label = new Label(18, count, (String)object[16], wcf2);
									ws.addCell(label);
									
									label = new Label(19, count, (String)object[17], wcf2);
									ws.addCell(label);
									
									label = new Label(20, count, (object[18]!=null)?df.format((Date)object[18]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(21, count, (object[19]!=null)?df.format((Date)object[19]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(22, count, (object[20]!=null)?df.format((Date)object[20]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(23, count, (object[21]!=null)?df.format((Date)object[21]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(24, count, (object[22]!=null)?df.format((Date)object[22]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(25, count, (object[23]!=null)?df.format((Date)object[23]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(26, count, (object[24]!=null)?df.format((Date)object[24]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(27, count, (object[25]!=null)?df.format((Date)object[25]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(28, count, (object[26]!=null)?df.format((Date)object[26]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(29, count, (object[27]!=null)?df.format((Date)object[27]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(30, count, (object[28]!=null)?df.format((Date)object[28]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(31, count, (object[29]!=null)?df.format((Date)object[29]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(32, count, (object[30]!=null)?df.format((Date)object[30]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(33, count, (object[31]!=null)?df.format((Date)object[31]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(34, count, (object[32]!=null)?df.format((Date)object[32]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(35, count, (object[33]!=null)?df.format((Date)object[33]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(36, count, (object[34]!=null)?df.format((Date)object[34]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(37, count, (object[35]!=null)?df.format((Date)object[35]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(38, count, (object[36]!=null)?df.format((Date)object[36]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(39, count, (object[37]!=null)?df.format((Date)object[37]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(40, count, (object[38]!=null)?df.format((Date)object[38]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(41, count, (object[39]!=null)?df.format((Date)object[39]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(42, count, (object[40]!=null)?df.format((Date)object[40]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(43, count, (object[41]!=null)?df.format((Date)object[41]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(44, count, (object[42]!=null)?df.format((Date)object[42]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(45, count, (object[43]!=null)?df.format((Date)object[43]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(46, count, (object[44]!=null)?df.format((Date)object[44]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(47, count, (object[45]!=null)?df.format((Date)object[45]):"", wcf2);
									ws.addCell(label);
									
									label = new Label(48, count, (String)object[46], wcf2);
									ws.addCell(label);
									
									label = new Label(49, count, "", wcf2);
									ws.addCell(label);
									
									label = new Label(50, count, "", wcf2);
									ws.addCell(label);
									
									
									sNo++;
									count++;
								}
								
			
							}

							wb.write();
							wb.close();

							
					}
				} catch (Exception e) {
						e.printStackTrace();
				}
				return null;			
			
			}
			
			public ModelAndView getlocalityList2(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> dataMap = new HashMap<String, Object>();
				int ward = 0;
				String basicSectionId = "";
				String subcenterId = "";

				if (request.getParameter("basicSectionId") != null
						&& !request.getParameter("basicSectionId").equals("")) {
					basicSectionId = request.getParameter("basicSectionId");
				}
				if (request.getParameter("subcenterId") != null
						&& !request.getParameter("subcenterId").equals("")) {
					subcenterId = request.getParameter("subcenterId");
				}

				try {

					if (request.getParameter("ward") != null) {
						ward = Integer.parseInt(request.getParameter("ward"));
					}
					dataMap.put("ward", ward);
					dataMap.put("hospitalId", basicSectionId);
					dataMap.put("subcenterId", subcenterId);

					map = pubHealthHandlerService.getlocalityList(dataMap);
					jsp = "responceLocality";
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
			
			public ModelAndView getTalukListForVillageMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int district = 0;
				String flag="";
				
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("district") != null) {
						district = Integer.parseInt(request.getParameter("district"));
					}
					if (request.getParameter("flag") != null) {
						flag = (request.getParameter("flag"));
					}
					dataMap.put("district", district);
					map = pubHealthHandlerService.getTalukListForVillageMapping(dataMap);
					jsp = "responseforTalukForVillageMapping";
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("flag",flag);
				return new ModelAndView(jsp, "map", map);
			}

			public ModelAndView getvilageListForVillageMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				session = request.getSession(true);
				int taluk = 0;
				int districtId=0;
				int hospitalId=0;
				int villSubcenterId=0;
				if(session.getAttribute(HOSPITAL_ID)!=null){
					hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				}
				try {
					Map<String, Object> dataMap = new HashMap<String, Object>();
					if (request.getParameter("taluk") != null) {
						taluk = Integer.parseInt(request.getParameter("taluk"));
					}
					if (request.getParameter("distr") != null) {
						districtId = Integer.parseInt(request.getParameter("distr"));
					}
					if (request.getParameter("villSubcenterId") != null) {
						villSubcenterId = Integer.parseInt(request.getParameter("villSubcenterId"));
					}
					dataMap.put("taluk", taluk);
					dataMap.put("districtId", districtId);
					dataMap.put("villSubcenterId", villSubcenterId);
					
					map = pubHealthHandlerService.getvilageListForVillageMapping(dataMap);
					jsp = "responseVillageListForVillageMapping";
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
			
			// ---------- Ph Immunization Services Report -------------

			public ModelAndView showImmuniztion(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();

				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				title = "Immunization Report";

				jsp = "phImmunizationJSP";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")			
			public ModelAndView generateImmunizationReportForPh(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				Date currentDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);
				

					if (request.getParameter("currentDate") != null
							&& !(request.getParameter("currentDate").equals(""))) {
						currentDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter("currentDate"));
						requestParameters.put("currentDate", currentDate);

					}

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);

					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

					//requestParameters.put("qry", qry);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				requestParameters.put("SUBREPORT_DIR",
						getServletContext().getRealPath("/Reports/"));
				HMSUtil.generateReport("immunization_services", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}

			// -----------get CHC PHC ---Sub center List in Immunization -----
			public ModelAndView getImmunizationChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_immunization";
				return new ModelAndView(jsp, "map", map);
			}

			// ---------- Ph Postnatal Care Details Report -------------

			public ModelAndView showPostnatalCare(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();

				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "PostnatalCare Report";

				jsp = "phPostnatalCareJSP";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generatePostnatalCareReportForPh(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				Date currentDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and mh.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);
				

					if (request.getParameter("currentDate") != null
							&& !(request.getParameter("currentDate").equals(""))) {
						currentDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter("currentDate"));
						requestParameters.put("currentDate", currentDate);

					}

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);

					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

					//requestParameters.put("qry", qry);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("postnatal_care_details", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			
			// ---------- Ph Family Planning Details Report -------------

			public ModelAndView showFamilyPlanning(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "Family Planning Report";
				jsp = "family_planning";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateFamilyPlanningReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter("currentDate") != null
							&& !(request.getParameter("currentDate").equals(""))) {
						currentDate = request.getParameter("currentDate");
						requestParameters.put("currentDate", currentDate);
						String splitDate[]=currentDate.split("-");
						if(splitDate[1].equals("1") || splitDate[1].equals("2") || splitDate[1].equals("3")) {
							eDate = splitDate[0] + "-03-31";
							endDate = HMSUtil.convertStringyyyyMMddTypeToDateType(eDate);
							splitDate[0]=String.valueOf(Integer.parseInt(splitDate[0])-1);
							sDate = splitDate[0] + "-04-01";
							startDate = HMSUtil.convertStringyyyyMMddTypeToDateType(sDate);
							requestParameters.put("startDate", startDate);
							requestParameters.put("endDate", endDate);
						} else {
							sDate = splitDate[0] + "-04-01";
							startDate = HMSUtil.convertStringyyyyMMddTypeToDateType(sDate);
							splitDate[0]=String.valueOf(Integer.parseInt(splitDate[0])+1);
							eDate = splitDate[0] + "-03-31";
							endDate = HMSUtil.convertStringyyyyMMddTypeToDateType(eDate);
							requestParameters.put("startDate", startDate);
							requestParameters.put("endDate", endDate);
						}

					}

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("Family_Planning_Activities", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}

			// ---------- Ph RCH Activities Report -------------

			public ModelAndView showRCHActivities(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "RCH Activities Report";
				jsp = "rch_activities";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateRCHActivitiesReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("Other_RCH_Activities", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// -----------get CHC PHC ---Sub center List in RCH -----
			public ModelAndView getRCHChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_rch";
				return new ModelAndView(jsp, "map", map);
			}

			// ---------- Ph AEFIs Report -------------

			public ModelAndView showAEFIs(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "AEFIs Report";
				jsp = "ph_aefis";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateAEFIsReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("AEFIs", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// -----------get CHC PHC ---Sub center List in AEFIs -----
			public ModelAndView getAEFIsChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_aefis";
				return new ModelAndView(jsp, "map", map);
			}

			// ---------- Ph Vaccine Preventable Diseases Report -------------

			public ModelAndView showVPDiseases(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "Vaccine Preventable Diseases Report";
				jsp = "vaccine_prevent_diseases";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateVPDiseasesReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("Vaccine_Preventable_Diseases", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// -----------get CHC PHC ---Sub center List in VPDiseases -----
			public ModelAndView getVPDiseasesChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_VPDiseases";
				return new ModelAndView(jsp, "map", map);
			}

			// ---------- Ph RCH Activities Report -------------

			public ModelAndView showImmunisationDropouts(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "Immunisation Dropouts Report";
				jsp = "immunisation_dropouts";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateImmunDropoutsReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("Immunisation_Dropouts", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// -----------get CHC PHC ---Sub center List in Dropouts -----
			public ModelAndView getImmunDropoutsChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_dropouts";
				return new ModelAndView(jsp, "map", map);
			}

			// ---------- Ph Vaccines and Other Items Report -------------

			public ModelAndView showVaccinesOtherItems(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				
				Integer deptId = 0;
				Integer hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName="";

				deptId = (Integer) session.getAttribute("deptId");
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
				map = pubHealthHandlerService.getDistrictList();
				
				title = "Vaccines and Other Items";
				jsp = "vaccines_other_items";
				jsp += ".jsp";

				map.put("instituteTypeShortName", instituteTypeShortName);
				map.put("hospitalName", hospitalName);
				map.put("hospitalId", hospitalId);
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unused")	
			public ModelAndView generateVaccinesItemsReport(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> parameters = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				String fileName = null;
				HttpSession session = request.getSession();
				Date fromDate = null;
				Date toDate = null;
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				String hospitalName = "";
				String instituteTypeShortName = "";
				String query = "";
				String currentDate = "";
				String sDate = "";
				String eDate = "";
				Date startDate = null;
				Date endDate = null;
				String qry="";
				try {
					if (session.getAttribute("hospitalId") != null) {
						hospitalId= (Integer) session.getAttribute("hospitalId");
						requestParameters.put("hospitalId", hospitalId);
						hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
						requestParameters.put("hospitalName", hospitalName);
						instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
					}
					/*if (instituteTypeShortName.equals("Admn")) {
						query +="  and md.district_id="+districtId;
					}*/
					if (instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("CHC")) {
						query +="  and mh.parent_institute_id="+hospitalId;
					}
					if (instituteTypeShortName.equals("FWC") || instituteTypeShortName.equals("BS")) {
						query +="  and fpr.hospital_id="+hospitalId;
					}
					requestParameters.put("query", query);

					if (request.getParameter(FROM_DATE) != null
							&& !(request.getParameter(FROM_DATE).equals(""))) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(FROM_DATE));
						requestParameters.put("fromDate", fromDate);
					}

					if (request.getParameter(TO_DATE) != null
							&& !(request.getParameter(TO_DATE).equals(""))) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request
								.getParameter(TO_DATE));
						requestParameters.put("toDate", toDate);
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				HMSUtil.generateReport("vaccines_and_other_items", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				return null;
			}
			
			// -----------get CHC PHC ---Sub center List in Vaccines Other Items -----
			public ModelAndView getVOItemsChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_items";
				return new ModelAndView(jsp, "map", map);
			}

			public ModelAndView getlocalitySearch(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> dataMap = new HashMap<String, Object>();
				int ward = 0;
			
				if (request.getParameterValues("ward") != null
						&& !request.getParameterValues("ward").equals("")) {
					ward = Integer.parseInt(request.getParameter("ward"));
					
				}
			
				dataMap.put("ward", ward);
				try {

					if (request.getParameter("ward") != null) {
						ward = Integer.parseInt(request.getParameter("ward"));
					}
					dataMap.put("ward", ward);
				
					map = pubHealthHandlerService.getlocalitySearch(dataMap);
					jsp = "responceLocalitySearch";
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ModelAndView(jsp, "map", map);
			}
			public ModelAndView showCampGroupJsp(HttpServletRequest request,HttpServletResponse response) {
				HttpSession session = request.getSession();
				session = request.getSession(true);
				Box box = HMSUtil.getBox(request);
				Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId = 0;
				int page = 1;
				int campGroupId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					box.put("hospitalId", hospitalId);
					
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = Integer.parseInt(""+ session.getAttribute("deptId"));
					box.put("deptId", deptId);
					
				}
				if(request.getParameter("page") != null){
		            page = Integer.parseInt(request.getParameter("page"));    
				}
				box.put("page", page);
				if(request.getParameter("campGroupId") != null){
					campGroupId = Integer.parseInt(request.getParameter("campGroupId")); 
					box.put("campGroupId", campGroupId);
				}
				map = pubHealthHandlerService.showCampGroupJsp(box);
				jsp = "campGroup";
				jsp += ".jsp";
				map.put("campGroupId", campGroupId);
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
			public ModelAndView submitCampGroup(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				session = request.getSession(true);
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					box.put("hospitalId", hospitalId);
					
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = Integer.parseInt(""+ session.getAttribute("userId"));
					box.put("userId", userId);
					
				}
				map = pubHealthHandlerService.submitCampGroup(box);
				String message = "";
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				if (flag) {
					message = "Record Saved Successfully";
				} else {
					message = "Some Problem Occured!!!";
					
				}
				map = pubHealthHandlerService.showCampGroupJsp(box);
				jsp = "campGroup";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
			public ModelAndView showCampJsp(HttpServletRequest request,HttpServletResponse response) {
				HttpSession session = request.getSession();
				session = request.getSession(true);
				Box box = HMSUtil.getBox(request);
				Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId = 0;
				int page = 1;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					box.put("hospitalId", hospitalId);
				}
				if(request.getParameter("page") != null){
		            page = Integer.parseInt(request.getParameter("page"));    
				}
				box.put("page", page);
				map = pubHealthHandlerService.showCampJsp(box);
				jsp = "camp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
			public ModelAndView submitCamp(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				session = request.getSession(true);
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
					box.put("hospitalId", hospitalId);
					
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = Integer.parseInt(""+ session.getAttribute("userId"));
					box.put("userId", userId);
					
				}
				map = pubHealthHandlerService.submitCamp(box);
				String message = "";
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				if (flag) {
					message = "Record Saved Successfully";
				} else {
					message = "Some Problem Occured!!!";
					
				}
				map = pubHealthHandlerService.showCampJsp(box);
				jsp = "camp";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			// -----------get CHC PHC ---Sub center List in Family -----
			public ModelAndView getAntenatalChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_antenatal";
				return new ModelAndView(jsp, "map", map);
			}

			// -----------get CHC PHC ---Sub center List in Family -----
			public ModelAndView getFamilyChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_family";
				return new ModelAndView(jsp, "map", map);
			}
			
			// -----------get CHC PHC ---Sub center List in ConDeath -----
			public ModelAndView getConDeathChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_condeath";
				return new ModelAndView(jsp, "map", map);
			}

			// -----------get CHC PHC ---Sub center List in ComDisease -----
			public ModelAndView getComDiseaseChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_comdisease";
				return new ModelAndView(jsp, "map", map);
			}
			
			// -----------get CHC PHC ---Sub center List in Delivery -----
			public ModelAndView getDeliveryChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_delivery";
				return new ModelAndView(jsp, "map", map);
			}
			
			// -----------get CHC PHC ---Sub center List in Postnatal -----
			public ModelAndView getPostnatalChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_postnatal";
				return new ModelAndView(jsp, "map", map);
			}
			
			// -----------get CHC PHC ---Sub center List in Place Delivery -----
			public ModelAndView getDelivery2ChcPhcList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				session = request.getSession();
				map = pubHealthHandlerService.getchclist(box);
				jsp = "responce_chc_phc_place";
				return new ModelAndView(jsp, "map", map);
			}
			
			public ModelAndView getBirthBasicCenterListchcphc(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				session = request.getSession();
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
				}
				map = pubHealthHandlerService.getBasicCenterListForPhcChc(hospitalId);
				jsp = "responce_center_birth";
				return new ModelAndView(jsp, "map", map);

			}
			
			public ModelAndView getBsFwsList(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				session = request.getSession();
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
				}
				map = pubHealthHandlerService.getBasicCenterListForPhcChc(hospitalId);
				jsp = "responce_center";
				return new ModelAndView(jsp, "map", map);
			}
			
			public ModelAndView getVectorSurveyBasicCenterListChcPhc(HttpServletRequest request,
					HttpServletResponse response) {

				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = null;
				session = request.getSession();
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
				}
				map = pubHealthHandlerService.getBasicCenterListForPhcChc(hospitalId);
				jsp = "responce_center_vector";
				return new ModelAndView(jsp, "map", map);
			}
			
			//----------------- ph_syndromic_survcillence_mapping-----------------------//
			@SuppressWarnings("unchecked")
			public ModelAndView showPhSyndromicSurvcillenceMappingJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map map = new HashMap();
				map = pubHealthHandlerService.showPhSyndromicSurvcillenceMappingJsp();
				String jsp = "ph_syndromic_survcillence_mapping";
				jsp += ".jsp";
				title = "ph_syndromic_survcillence_mapping";
				map.put("contentJsp", jsp);
				map.put("title", title);

				return new ModelAndView("index", "map", map);
			}

			@SuppressWarnings("unchecked")
			public ModelAndView addPhSyndromicSurvcillenceMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping = new PhSyndromicSurvcillenceMapping();
				String pojoPropertyName = "";
				String pojoPropertyCode = "";
				String pojoPropertyAddress = "";
				String pojoName = "";
				int mainGroupId = 0;
				String mainGroupName = "";
				int subGroupId = 0;
				String subGroupName = "";
				String name = "";
				String currentTime = "";
				int userId=0;
				String message="";
				HttpSession session=request.getSession();
				String local = "";
				Map<String, Object> listMap = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Date currentDate = new Date();

				if (request.getParameter("mainGroupName") != null && !request.getParameter("mainGroupName").equals("")) {
					mainGroupName = request.getParameter("mainGroupName");
				}
				if (request.getParameter("subGroupName") != null && !request.getParameter("subGroupName").equals("")) {
					subGroupName = request.getParameter("subGroupName");
				}
				if (request.getParameter("mainGroupId") != null && !request.getParameter("mainGroupId").equals("")) {
					mainGroupId = Integer.parseInt(request.getParameter("mainGroupId") );
				}
				if (request.getParameter("subGroupId") != null && !request.getParameter("subGroupId").equals("")) {
					subGroupId = Integer.parseInt(request.getParameter("subGroupId") );
				}
				if (request.getParameter(SEARCH_NAME) != null) {
					name = request.getParameter(SEARCH_NAME);
				}
				
				if(session.getAttribute("userId") != null){
					userId=(Integer)session.getAttribute("userId");
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

				if (request.getParameter("pojoPropertyName") != null) {
					pojoPropertyName = request.getParameter("pojoPropertyName");
				}
				 
				
				generalMap.put("name", name);

				generalMap.put("currentDate", currentDate);
				generalMap.put("currentTime", currentTime);

				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);

				listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
				List parameterNameList = new ArrayList();
				if (listMap.get("duplicateGeneralNameList") != null) {
					parameterNameList = (List) listMap.get("duplicateGeneralNameList");
				}
				boolean successfullyAdded = false;

				if ((parameterNameList.size() == 0 || parameterNameList == null)
						&& (parameterNameList.size() == 0 || parameterNameList == null)) {
					phSyndromicSurvcillenceMapping.setMainGroupId(mainGroupId);
					phSyndromicSurvcillenceMapping.setMainGroupName(mainGroupName);
					phSyndromicSurvcillenceMapping.setSubGroupId(subGroupId);
					phSyndromicSurvcillenceMapping.setSubGroupName(subGroupName);
					phSyndromicSurvcillenceMapping.setParameterName(name);
					phSyndromicSurvcillenceMapping.setStatus("y");
					phSyndromicSurvcillenceMapping.setLastChgDate(currentDate);
					phSyndromicSurvcillenceMapping.setLastChgTime(currentTime);
					Users user=new Users();
			        user.setId(userId);
			        phSyndromicSurvcillenceMapping.setLastChgBy(user);
			        
					successfullyAdded = pubHealthHandlerService.addPhSyndromicSurvcillenceMapping(phSyndromicSurvcillenceMapping);

					if (successfullyAdded) {
						message = "Record Added Successfully !!";
					} else {
						message = "Try Again !!";
					}
				} else if ((parameterNameList.size() != 0) || parameterNameList != null) {
					if ((parameterNameList.size() != 0 || parameterNameList != null)) {
						message = "Parameter Name already exists.";
					}
				}
				try {
					map = pubHealthHandlerService.showPhSyndromicSurvcillenceMappingJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "ph_syndromic_survcillence_mapping";
				title = "Add ph_syndromic_survcillence_mapping";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView editPhSyndromicSurvcillenceMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				Map<String, Object> listMap = new HashMap<String, Object>();
				String pojoPropertyName = "";
				String pojoName = "";
				String message="";
				String parameterName = "";
				int phSyndromicSurvcillenceMappingId = 0;
				String url="";
				PhSyndromicSurvcillenceMapping phSyndromicSurvcillenceMapping = new PhSyndromicSurvcillenceMapping();
				int mainGroupId = 0;
				String mainGroupName = "";
				int subGroupId = 0;
				String subGroupName = "";
		  		int userId=0;
				HttpSession session=request.getSession();
				Date changedDate = null;
				String changedTime = "";
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					phSyndromicSurvcillenceMappingId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter("mainGroupName") != null && !request.getParameter("mainGroupName").equals("")) {
					mainGroupName = request.getParameter("mainGroupName");
				}
				if (request.getParameter("subGroupName") != null && !request.getParameter("subGroupName").equals("")) {
					subGroupName = request.getParameter("subGroupName");
				}
				if (request.getParameter("mainGroupId") != null && !request.getParameter("mainGroupId").equals("")) {
					mainGroupId = Integer.parseInt(request.getParameter("mainGroupId") );
				}
				if (request.getParameter("subGroupId") != null && !request.getParameter("subGroupId").equals("")) {
					subGroupId = Integer.parseInt(request.getParameter("subGroupId") );
				}
				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					parameterName = request.getParameter(SEARCH_NAME);
				}
				if(session.getAttribute("userId") != null){
					userId=(Integer)session.getAttribute("userId");
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

		 		generalMap.put("id", phSyndromicSurvcillenceMappingId);
		 		generalMap.put("mainGroupId", mainGroupId);
		 		generalMap.put("mainGroupName", mainGroupName);
				generalMap.put("subGroupId", subGroupId);
				generalMap.put("subGroupName", subGroupName);
				generalMap.put("userId", userId);
				
				generalMap.put("name", parameterName);
				
		 		generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				generalMap.put("pojoPropertyName", pojoPropertyName);
				generalMap.put("pojoName", pojoName);

				generalMap.put("flag", true);

				listMap = commonMasterHandlerService
						.checkForExistingMasters(generalMap);
				List existingParameterNameList = (List) listMap.get("duplicateMastersList");

				boolean dataUpdated = false;
				if (existingParameterNameList.size() == 0) {
					dataUpdated = pubHealthHandlerService.editPhSyndromicSurvcillenceMapping(generalMap);

					if (dataUpdated == true) {
						message = "Data updated Successfully !!";
					} else {
						message = "Data Cant be updated !!";
					}
				} else if (existingParameterNameList.size() > 0) {
					message = "Name already exists.";
				}
				url = "/hms/hms/pubHealth?method=showPhSyndromicSurvcillenceMappingJsp";

				try {
					map = pubHealthHandlerService.showPhSyndromicSurvcillenceMappingJsp();

				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "ph_syndromic_survcillence_mapping";
				title = "Update ph_syndromic_survcillence_mapping";
				jsp += ".jsp";

				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView deletePhSyndromicSurvcillenceMapping(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> generalMap = new HashMap<String, Object>();
				int phSyndromicSurvcillenceMappingId = 0;
				String message = null;
				int userId=0;
				HttpSession session=request.getSession();
				String changedTime = "";
				Date changedDate = null;
				String flag = "";
				String url="";
				if (request.getParameter("flag") != null) {
					flag = request.getParameter("flag");
					generalMap.put("flag", flag);
				}
				if (request.getParameter(COMMON_ID) != null
						&& !(request.getParameter(COMMON_ID).equals(""))) {
					phSyndromicSurvcillenceMappingId = Integer.parseInt(request.getParameter(COMMON_ID));
				}
				if (request.getParameter("title") != null) {
					title = request.getParameter("title");
				}
				if(session.getAttribute("userId") != null){
					userId=(Integer)session.getAttribute("userId");
				 }
				changedDate = new Date();
				changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
						"currentTime");

				 Users user=new Users();
			     user.setId(userId);
				generalMap.put("currentDate", changedDate);
				generalMap.put("currentTime", changedTime);
				boolean dataDeleted = false;
				dataDeleted = pubHealthHandlerService.deletePhSyndromicSurvcillenceMapping(phSyndromicSurvcillenceMappingId,
						generalMap);
				if (dataDeleted == true) {
					message = "Record is InActivated successfully !!";
				}

				else {
					message = "Record is Activated successfully !!";
				}
				url = "/hms/hms/pubHealth?method=showPhSyndromicSurvcillenceMappingJsp";

				try {
					map = pubHealthHandlerService.showPhSyndromicSurvcillenceMappingJsp();
				} catch (Exception e) {
					e.printStackTrace();
				}
				jsp = "ph_syndromic_survcillence_mapping";
				title = "Delete ph_syndromic_survcillence_mapping";
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("url", url);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}

			
			
			public ModelAndView searchPhSyndromicSurvcillenceMapping(HttpServletRequest request,
					HttpServletResponse response) throws ServletRequestBindingException {
				Map<String, Object> map = new HashMap<String, Object>();
				String parameterName = null;

				if (request.getParameter(SEARCH_NAME) != null
						&& !(request.getParameter(SEARCH_NAME).equals(""))) {
					parameterName = request.getParameter(SEARCH_NAME);
				}
				map = pubHealthHandlerService.searchPhSyndromicSurvcillenceMapping(parameterName);
				jsp = "ph_syndromic_survcillence_mapping";
				jsp += ".jsp";
				map.put("search", "search");
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("parameterName", parameterName);
				return new ModelAndView("index", "map", map);
			}
			
			
			public ModelAndView showSyndromicSurvcillencepReportJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();

				jsp = "syndromicSurvcillenceRpt" + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}

			public ModelAndView printSyndromicSurvcillenceReport(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> requestParameters = new HashMap<String, Object>();
				HttpSession session=request.getSession();
				String fromDateS = null;
				String toDateS = null;
				int userId=0;
			
				Date fromDate= null;
				Date toDate = null;
		
				SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
				
				
				
		

				try {
					/*if (request.getParameter(FROM_DATE) != null			&& !(request.getParameter(FROM_DATE).equals(""))) 
						if (request.getParameter(FROM_DATE) != null) {
							fromDateS = request.getParameter(FROM_DATE);
						
						String dateSQL1 = formatterOut.format(formatterIn.parse(fromDateS));
						java.sql.Date startDate = java.sql.Date.valueOf(dateSQL1);
						
						requestParameters.put("from_date", startDate);
						System.out.println(startDate+"fromDate");
				}
					
					if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) 	if (request.getParameter(TO_DATE) != null) {
							toDateS = request.getParameter(TO_DATE);
						
						String dateSQL2 = formatterOut.format(formatterIn.parse(toDateS));
						java.sql.Date endDate = java.sql.Date.valueOf(dateSQL2);
						
						requestParameters.put("to_date", endDate);
						System.out.println(endDate+"toDate");
						
					}*/
					
					
					if(session.getAttribute("userId") != null){
						userId=(Integer)session.getAttribute("userId");
						requestParameters.put("userid", userId);
						System.out.println(userId+"userid");
					 }
		
	
				if (request.getParameter(FROM_DATE) != null
						&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(FROM_DATE));
					requestParameters.put("from_date", fromDate);
					
				}

				if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(TO_DATE));
					requestParameters.put("to_date", toDate);
				}
				requestParameters.put("SUBREPORT_DIR",
						getServletContext().getRealPath("/Reports/"));
				Map<String, Object> connectionMap = pubHealthHandlerService
						.getConnectionForReport();
				
				Map<String, Object> classMap = pubHealthHandlerService.fun_ph_form_s(fromDate, toDate, userId);
				
				/*HMSUtil.generateReport("form_s", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());*/
				
				HMSUtil.generateReportExl("form_s", requestParameters,
						(Connection) connectionMap.get("con"), response,
						getServletContext());
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
			
			
			public ModelAndView showPhReportsParametersMappingJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				
				HttpSession session = request.getSession();
				session = request.getSession(true);
				
				map = pubHealthHandlerService.getPhReportsParametersMappings(box);
				
				jsp = "phReportsParametersMapping" + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}
			
			public ModelAndView updatePhReportsParametersMappingJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				
				HttpSession session = request.getSession();
				session = request.getSession(true);
				
				map = pubHealthHandlerService.updatePhReportsParametersMappings(box);
				
				jsp = "phReportsParametersMapping" + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}

			/*public static void generateReportExl(String jasper_filename, Map parameters,
					Connection conn, HttpServletResponse response,
					ServletContext context) {
					byte bytes[] = null;
					try {
					//bytes = JasperRunManager.runReportToPdf(getCompiledReport(context,jasper_filename), parameters, conn);

					JasperReport jasperReport=getCompiledReport(context,jasper_filename);
					JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameters,conn);
					JRXlsExporter exporterXLS = new JRXlsExporter();
					ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
					exporterXLS.setExporterInput(new SimpleExporterInput(jasperPrint));
					exporterXLS.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));

					SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration ();
					configuration.setOnePagePerSheet(true);
					configuration.setDetectCellType(true);
					configuration.setFontSizeFixEnabled(true);
					configuration.setRemoveEmptySpaceBetweenColumns(true);
					configuration.setRemoveEmptySpaceBetweenRows(true);
					configuration.setIgnoreGraphics(true);
					configuration.setIgnoreCellBackground(true);
					configuration.setIgnoreCellBorder(true);
					configuration.setWhitePageBackground(true);
					configuration.setCellLocked(false);
					configuration.setShowGridLines(true);
					configuration.setIgnorePageMargins(true);
					configuration.setWrapText(false);
					exporterXLS.setConfiguration(configuration);


					exporterXLS.exportReport(); 
					bytes = byteArrayOutputStream.toByteArray();
					ServletOutputStream output=response.getOutputStream(); 
					if (response != null) {
					response.setContentLength(bytes.length);
					response.setContentType("application/vnd.ms-excel");
					response.setHeader("Content-Disposition", "attachment; filename="+jasper_filename+".xls");
					output.write(bytes);
					}
					if(!conn.isClosed())
					conn.close();
					} catch (JRException e) {
					e.printStackTrace();
					} catch (Exception e) {
					e.printStackTrace();
					}
					 
					}*/
			public ModelAndView getAshapage(HttpServletRequest request,	HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				session = request.getSession(true);
				
				map = pubHealthHandlerService.getAshapage(map);
				try{
				  PrintWriter out=response.getWriter();
				  List<AshaWorker>list=(List<AshaWorker>)map.get("ashaDetails");
				  for(AshaWorker aw:list){
					  out.println("<tr>"
					  			 +"<td>"+aw.getAshaName()+"</td>"
					  			 +"<td>"+aw.getAshaCode()!=null?aw.getAshaCode():""+"</td>"
					  			 +"<td>"+aw.getContactNo()!=null?aw.getContactNo():""+"</td>"
							  	 +"<td>"+aw.getQualification()!=null?aw.getQualification():""+"</td>"
					  			 +"<td>"+aw.getBankAccount()!=null?aw.getBankAccount():""+"</td>"
							     +"<td>"+aw.getBankName()!=null?aw.getBankName():""+"</td>"
							     +"<td>"+aw.getIfsc()!=null?aw.getIfsc():""+"</td>"
							     +"<td>"+aw.getLsg()!=null?aw.getLsg().getLsgTypeName():""+"</td>"
							     +"<td>"+aw.getHospital()!=null?aw.getHospital().getHospitalName():""+"</td>"
							     + "</tr>");
				  }
			    }catch(Exception e){
				  e.printStackTrace();
			    }
				jsp = "ashaPage" + ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
			}
			
			public ModelAndView getAshaEntity(HttpServletRequest request,	HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				session = request.getSession(true);
				Integer districtId=null;
				Integer hospitalId=null;
				
					if(request.getParameter("districtId")!=null){
						districtId=Integer.parseInt(request.getParameter("districtId"));
						map.put("districtId", districtId);
						map = pubHealthHandlerService.getAshaEntity(map);
			       }
				  
					if(request.getParameter("hospitalId")!=null){
						hospitalId=Integer.parseInt(request.getParameter("hospitalId"));
						map.put("hospitalId", hospitalId);
						map = pubHealthHandlerService.getAshaEntity(map);
			       }
					
				return new ModelAndView("responseAshaWorker", "map", map);
			}
			
			public ModelAndView getHospitals(HttpServletRequest request,	HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				//HttpSession session = request.getSession();
				//session = request.getSession(true);
				Integer hospitalTypeId=null;
				if(request.getParameter("ashaId")!=null){
					Integer ashaId=Integer.parseInt(request.getParameter("ashaId"));
					map.put("ashaId", ashaId);
					map=pubHealthHandlerService.getHospitals(map);
				}else{
					if(request.getParameter("hospitalTypeId")!=null){
						hospitalTypeId=Integer.parseInt(request.getParameter("hospitalTypeId"));
						map.put("hospitalTypeId", hospitalTypeId);
						map = pubHealthHandlerService.getHospitals(map);
					}
			  }
				return new ModelAndView("responseAshaWorker", "map", map);
			}
			
		  public ModelAndView submitAshaWorker(HttpServletRequest request,HttpServletResponse response){
			  Map<String, Object> map = new HashMap<String, Object>();
			  Box box=HMSUtil.getBox(request);	
			  map = pubHealthHandlerService.submitAshaWorker(box);
			  jsp = "ashaPage" + ".jsp";
			  map.put("contentJsp", jsp);
			  return new ModelAndView("index", "map", map);
		  }

	// --------------PH Registration Report Start by Arbind--------------

	// ---------- Ph Birth Registration -------------

	public ModelAndView showBirthRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Birth Register Report";

		jsp = "birth_resiter_jsp";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateBirthRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null, toDate = null, currentDate = null;
		Box box = HMSUtil.getBox(request);
		int districtId = 0, hospitalId = 0, gender = 0, deliveryType = 0, rankId = 0;
		String qry = "", empName = "", rankName = "";
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				qry += "  and district.district_id=" + districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				qry += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				qry += "  and bdr.hospital_id=" + hospitalId;
			}
			if (request.getParameter("currentDate") != null	&& !(request.getParameter("currentDate").equals(""))) {
				currentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("currentDate"));
				requestParameters.put("currentDate", currentDate);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			if (request.getParameter("gender") != null
					&& !(request.getParameter("gender").equals("0"))) {
				gender = Integer.parseInt(request.getParameter("gender")
						.toString());
				qry += "  and ax.administrative_sex_id=" + gender;
			}
			if (request.getParameter("deliveryType") != null
					&& !(request.getParameter("deliveryType").equals("0"))) {
				deliveryType = Integer.parseInt(request.getParameter(
						"deliveryType").toString());
				qry += " and dt.delivery_type_id=" + deliveryType;
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}

			System.out.println("qry" + qry);

			requestParameters.put("qry", qry);

			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("BirthRegistration", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------- Ph Death Registration -------------

	public ModelAndView showDeathRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Death Register Report";

		jsp = "deathRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateDeathRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Date fromDate = null, toDate = null;
		String hospitalName = "", query = "", cdeath[] = null, empName = "", rankName = "";
		int hospitalId = 0, districtId = 0, gender = 0, fromAge = 0, toAge = 0, rankId = 0;
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				query +="  and district.district_id="+districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				query +="  and bdr.hospital_id="+hospitalId;
			}
			if(request.getParameter("gender") != null && !(request.getParameter("gender").equals("0"))) {
				gender = Integer.parseInt(request.getParameter("gender").toString());
				query +="  and ax.administrative_sex_id="+gender;
			}
			if(request.getParameter("fromAge") != null && !(request.getParameter("fromAge").equals(""))) {
				fromAge = Integer.parseInt(request.getParameter("fromAge").toString());
			}
			if(request.getParameter("toAge") != null && !(request.getParameter("toAge").equals(""))) {
				toAge = Integer.parseInt(request.getParameter("toAge").toString());
				query +="  and (bdr.dob_death_date-ms.date_of_birth)/365 between " + fromAge + " and " +toAge;
			}
			if (request.getParameter("cdeath") != null	&& !(request.getParameter("cdeath").equals(""))) {
				cdeath = request.getParameterValues("cdeath");
				String str1 = Arrays.toString(cdeath);
				str1 = str1.substring(1, str1.length() - 1).replaceAll("", "");

				// String s ="'"+cdeath.toString().replace("[","").replace("]",
				// "").replace(" ","").replace(",","','")+"'";

				// System.out.println(s+">>>>>>>>>>>>>>>>");

				System.out.println(cdeath.length + "====len"
						+ request.getParameterValues("cdeath").length);

				// de=cdeath.toString();
				String de = "";

				for (int i = 0; i < cdeath.length - 1; i++) {
					System.out.println(cdeath[i]);
				}

				for (int i = 0; i < cdeath.length; i++) {
					if (i == (cdeath.length - 1)) {
						de += "'" + cdeath[i] + "'";
						System.out.println("If '" + cdeath[i] + "'");
					} else {
						de += "'" + cdeath[i] + "', ";
						System.out.println("else '" + cdeath[i] + "'");
					}
				}
				System.out.println("de---" + de);
				query += "  and bdr.cause_of_death in (" + de + ")";
//				requestParameters.put("Diseases", quer);
			}

			if (request.getParameter(FROM_DATE) != null	&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			requestParameters.put("query", query);

			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("DeathRegistration", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ----------- Communicable Diseases-----

	public ModelAndView showCDiseasesRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Communicable Diseases Report";

		jsp = "communDiseaseRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateCommunRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				query +="  and dr.hospital_id="+hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("CommunicableDiseaseRegistration", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// -----------Non Communicable Diseases-----

	public ModelAndView showNCDiseasesRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Non Communicable Diseases Report";

		jsp = "nonCommunDiseaseRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateNonCommunRegisterReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				query +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				query +="  and dr.hospital_id="+hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("NonCommunicableDiseaseRegistration", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	// ----------- Antenatal Care-----

	public ModelAndView showANCRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Antenatal Care Report";

		jsp = "ANCRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateANCRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pas.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("ANCRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Eligible Couple-----

	public ModelAndView showEligibleCoupleRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Eligible Couple Report";

		jsp = "EligibleCoupleRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateEligibleCoupleRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and per.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("EligibleCoupleRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Family Planning-----

	public ModelAndView showFamilyPlanRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Family Planning Report";

		jsp = "FamilyPlanningRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateFamilyPlanRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pfr.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("FamilyPlanningRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- BEDNET DISTRIBUTION-----

	public ModelAndView showBednetDistRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Bednet Distribution Report";

		jsp = "BednetDistributionRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateBednetDistRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pobd.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("BednetDistributionRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Syndromic Surviliances-----

	public ModelAndView showSyndromicSurvRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Syndromic Surviliances Report";

		jsp = "SyndromicSurvilianceRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateSyndromicSurvRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and drf.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("SyndromicSurviliancesRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Insectcides Spraying-----

	public ModelAndView showInsectSprayRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Insectcides Spraying Report";

		jsp = "InsectcideSprayRegistraton";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateInsectSprayRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pois.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("InsectcidesSprayRegistraton",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Vector Survey Registration-----

	public ModelAndView showVectorSurveyRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Vector Survey Registration Report";

		jsp = "VectorSurveyRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateVectorSurveyRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pov.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("VectorSurveyRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Well Chlorination-----

	public ModelAndView showWellChlorinRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Well Chlorination Report";

		jsp = "WellChlorinationRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateWellChlorinRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pow.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("WellChlorinationRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Community Education-----

	public ModelAndView showCommunityEducationRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";
        String flag="NVBD";
		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Community Education Report";

		jsp = "CommunityEducationRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("reportFlag", flag);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateCommunityEducationRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and poce.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("CommunityEducationRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Facility Inspection -----

	public ModelAndView showFacilityInspectionRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Facility Inspection Report";

		jsp = "FacilityInspectionRegistraton";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateFacilityInspectionRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pofi.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("FacilityInspectionRegistraton",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- JSY Registration-----

	public ModelAndView showJSYRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "JSY Registration Report";

		jsp = "JSYRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateJSYRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pjr.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("JSYRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Menopausal Activity-----

	public ModelAndView showMenopausalActivityRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Menopausal Activity Report";

		jsp = "MenopausalActivityRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateMenopausalActivityRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pom.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("MenopausalActivityRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Organ Donation-----

	public ModelAndView showOrganDonationRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Organ Donation Report";

		jsp = "OrganDonationRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateOrganDonationRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pood.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("OrganDonationRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Travel History-----

	public ModelAndView showTravelHistoryRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Travel History Report";

		jsp = "TravelHistoryRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateTravelHistoryRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and poth.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("TravelHistoryRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Treatment Aliments-----

	public ModelAndView showTreatmentAlimentsRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Treatment Aliments Report";

		jsp = "TreatmentAlimentsRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateTreatmentAlimentsRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pme.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("TreatmentAlimentsRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- CHILD HEALTH IMMUNIZATION-----

	public ModelAndView showChildHealthImmunRegister(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "CHILD HEALTH IMMUNIZATION";

		jsp = "ChildHealthImmunRegistration";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateChildHealthImmunRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and ovp.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("ChildHealthImmunRegistration",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Member Survey -----

	public ModelAndView showMemberSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Member Survey";

		jsp = "MemberSurvey";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateMemberSurveyReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pms.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("MemberSurvey",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- House Survey -----

	public ModelAndView showHouseSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "House Survey";

		jsp = "HouseSurvey";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateHouseSurveyReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and phs.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("HouseSurvey",
					requestParameters, (Connection) connectionMap.get("con"),
					response, getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// ----------- Village Survey -----

	public ModelAndView showVillageSurvey(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";

		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "Village Survey";

		jsp = "VillageSurvey";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView generateVillageSurveyReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0, surveyType = 0;
		String hospitalName = "", query = "", empName = "", rankName = "";

		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pvs.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			if (request.getParameter("survey") != null
					&& !(request.getParameter("survey").equals("0"))) {
				surveyType = Integer.parseInt(request.getParameter("survey")
						.toString());
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			if(surveyType == 1) {
				HMSUtil.generateReportExl("AnganwadiSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 2) {
				HMSUtil.generateReportExl("ClinicSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 3) {
				HMSUtil.generateReportExl("CollegeSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 4) {
				HMSUtil.generateReportExl("DiagnosticSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 5) {
				HMSUtil.generateReportExl("HospitalSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 6) {
				HMSUtil.generateReportExl("PharmacyStoreSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 7) {
				HMSUtil.generateReportExl("ReligiousPlaceSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 8) {
				HMSUtil.generateReportExl("SchoolSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 9) {
				HMSUtil.generateReportExl("OrganisationSurvey",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			} else if(surveyType == 10) {
				HMSUtil.generateReportExl("PublicUtilities",
						requestParameters, (Connection) connectionMap.get("con"), response, getServletContext());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// --------------PH Registration Report End by Arbind--------------
	
	// ----------- PH- Report For ---- National Vector Borne Disease Report-----//added by govind 26-12-2016

	public ModelAndView showNationalVectorBorneDisease(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = ""; 
		String flag="NVBD";
		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "National Vector Borne Disease Report";

		jsp = "nationalVectorBorneDisease";
		jsp += ".jsp";
		System.out.println("flag jsp "+flag);
		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("reportFlag", flag);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView generateNationalVectorBorneDiseaseReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and osm.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("NationalVectorBorneDisease", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}//added by govind 27-12-2016 end
	public ModelAndView showRevisedNationalTuberculosis(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";
		String flag="RNTC";
		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "National Vector Borne Disease Report";

		jsp = "nationalVectorBorneDisease";
		jsp += ".jsp";
		System.out.println("flag jsp "+flag);
		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("reportFlag", flag);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView generateRevisedNationalTuberculosis(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and prn.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("NationalVectorBorneDisease", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public ModelAndView showNationalLeprosyEradicationProgram(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";
		String flag="NLEP";
		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "National Vector Borne Disease Report";

		jsp = "nationalVectorBorneDisease";
		jsp += ".jsp";
		System.out.println("flag jsp "+flag);
		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("reportFlag", flag);

		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView generateNationalLeprosyEradicationProgram(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and pnl.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("NationalVectorBorneDisease", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//added by govind 27-12-2016 end
	
	public ModelAndView showMigrantSurvery(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer deptId = 0;
		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName = "";
		String flag="MIGR";
		HttpSession session = request.getSession();

		deptId = (Integer) session.getAttribute("deptId");
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService
				.getInstituteTypeName(hospitalId);

		map = pubHealthHandlerService.getDistrictList();
		title = "National Vector Borne Disease Report";

		jsp = "nationalVectorBorneDisease";
		jsp += ".jsp";
		System.out.println("flag jsp "+flag);
		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("reportFlag", flag);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView generateMigrantSurvery(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		Date fromDate = null, toDate = null;
		int hospitalId = 0, rankId = 0;
		String hospitalName ="", query="", empName = "", rankName = "";
		
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			if (request.getParameter("chcphc") != null
					&& !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc")
						.toString());
				query += "  and mh.parent_institute_id=" + hospitalId;
			}
			if (request.getParameter("base") != null
					&& !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base")
						.toString());
				query += "  and oms.hospital_id=" + hospitalId;
			}
			System.out.println("query  --> " + query);
			requestParameters.put("query", query);
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("fromDate", fromDate);

			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("toDate", toDate);
			}
			Users users = new Users();
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				empName = users.getEmployee().getEmployeeName();
				requestParameters.put("empName", empName);
				rankId = users.getEmployee().getRank().getId();
				rankName = pubHealthHandlerService.getRankName(rankId);
				requestParameters.put("rankName", rankName);
			}
			Map<String, Object> connectionMap = pubHealthHandlerService
					.getConnectionForReport();
			/*
			 * HMSUtil.generateReport("BirthRegistration", requestParameters,
			 * (Connection) connectionMap.get("con"), response,
			 * getServletContext());
			 */
			HMSUtil.generateReportExl("NationalVectorBorneDisease", requestParameters,
					(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	//-----------------Added by arbind on 10-01-2017------------
	public ModelAndView submitVaccineDetailPH(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int userId = 0;
		int departmentId = 0;
		int referedDeptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
			mapForDS.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		Users users=null;
		if(session!=null){
			users = (Users)session.getAttribute("users");
			mapForDS.put("userId",users.getId());
		}
		if (box.get("referdepartment") != null && box.getInt("referdepartment") != 0) {
			referedDeptId = box.getInt("referdepartment");
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = Integer.parseInt("" + session.getAttribute("deptId"));
			mapForDS.put("departmentId", departmentId);
		}
		if (box.get("visitId") != null && box.getInt("visitId") != 0) {
			mapForDS.put("visitId", box.getInt("visitId"));
		}
		if (box.get("hinId") != null && box.getInt("hinId") != 0) {
			mapForDS.put("hinId", box.getInt("hinId"));
		}
		if (box.get("referVisitDate") != null && !box.get("referVisitDate").equals("")) {
			mapForDS.put("referralDate", HMSUtil.convertStringTypeDateToDateType(box.get("referVisitDate")));
		}
		
		box.put("hospitalId", hospitalId);
		box.put("deptId", departmentId);
		box.put("userId", userId);
		if(box.get("saveImmun") != null && box.getInt("saveImmun") == 1) {
			map = pubHealthHandlerService.submitVaccineDetailPH(box);
			if(box.get("referral") != null && box.getInt("referral") == 1) {
				String referralCase="Yes";
				String referType="Internal";
				String admissionAdvised="n";
				boolean episodeCloseCheck=false;
				int referral=1;
				int refereddoctor=0;
				String submitFrom="5";
				mapForDS.put("referral", referral);
				mapForDS.put("referralCase", referralCase);
				mapForDS.put("referType", referType);
				mapForDS.put("referdepartment", referedDeptId);
				mapForDS.put("fromDepartment", departmentId);
				mapForDS.put("refereddoctor", users.getEmployee().getId());
				mapForDS.put("referdTo", null);
				mapForDS.put("admissionAdvised", admissionAdvised);
				mapForDS.put("episodeCloseCheck", episodeCloseCheck);
				mapForDS.put("submitFrom", submitFrom);
				if(map.get("referredSession") != null) {
					System.out.println("opsessionId in con --  "+(Integer) map.get("referredSession"));
					mapForDS.put("referredSession", map.get("referredSession"));
				}
				map=opdHandlerService.submitOPDPatientDetails(mapForDS);
			}
		}
		map = pubHealthHandlerService.showImmunizationJsp(box);
		jsp = "immunizationSearch";
		jsp += ".jsp";
		title = "Immunization";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getImmunNursingCareWaitingList(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			HttpSession session = request.getSession();
			
			Integer hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
			if(session.getAttribute("deptId")!=null){
				int deptId = (Integer) session.getAttribute("deptId");
				map.put("deptId", deptId);
			}
			Date FromDateId=new Date();
			if (request.getParameter("FromDateId") != null	|| request.getParameter("FromDateId") != "") {
				 FromDateId = HMSUtil.convertStringTypeDateToDateType(request.getParameter("FromDateId"));
				map.put("FromDateId",FromDateId);
			}
			Date ToDateId=new Date();
			if (request.getParameter("ToDateId") != null	|| request.getParameter("ToDateId") != "") {
				ToDateId = HMSUtil.convertStringTypeDateToDateType(request.getParameter("ToDateId"));
				map.put("ToDateId",ToDateId);
			}
			map=pubHealthHandlerService.getImmunNursingCareWaitingList(map);
			}
		catch(Exception e){
				e.printStackTrace();
			}
		    jsp = "immun_nursingcare_waiting_list.jsp";
		    map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getImmunNursingCareScreenJSP(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			String uhid=request.getParameter("hinNo");
			Integer injAppId=null;
			if (request.getParameter("injAppId") != null) {
				injAppId = Integer.parseInt(request.getParameter("injAppId"));
			}
			Integer departmentId =null;
			if (session.getAttribute("deptId") != null) {
				departmentId = (Integer) session.getAttribute("deptId");
			}
			Integer hospitalId=null;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			
			Date date=null;
			if (request.getParameter("opdDate") != null) {
				map.put("opdDate",request.getParameter("opdDate"));
			}
			// treat opdate as appointmentdate
			int visitId=0;
			if (request.getParameter("visitId") != null) {
				map.put("visitId",Integer.parseInt(request.getParameter("visitId")));
			}
			
		
			
			map.put("departmentId",departmentId);
			map.put("hospitalId",hospitalId);
			map.put("hinNo",uhid);
			map.put("injAppId",injAppId);
			map=pubHealthHandlerService.getDrugAndProcedureDetails(map);
		    jsp = "immun_nursing_care.jsp";
		    map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	}

	public ModelAndView openPopupForInjectionIssue(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		box.put("hospitalId", hospitalId);
		
		map = pubHealthHandlerService.getItemBatch(box);
		
		map.put("counter", box.getInt("counter"));
		map.put("flag", box.getString("flag"));
		
		String jsp = "issueInjectionPopupPh";
		return new ModelAndView(jsp,"map",map);
	}

	public ModelAndView submitNursingCare(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		Box box=HMSUtil.getBox(request);
		
		if(session.getAttribute("hospitalId")!=null){
			box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
		}
		
		
		map = pubHealthHandlerService.submitNursingCare(box);
		boolean flag = false;
		if (map.get("flag") != null) {
			flag = (Boolean) map.get("flag");
		}
		
		try
		{	
			PrintWriter pw = response.getWriter();
			pw.write("success~~~"+flag);				
			
		}
		
		catch(Exception e)
		{		
			e.printStackTrace();
		}
		
		String msg="Immunization Nursing submited successfully.";
		map.put("nursing_msg",msg);
		jsp = "immun_nursing_care.jsp";
		map.put("contentJsp", jsp);
		title = "Immunization Nursing Care";
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	//-----------------Added by arbind END------------
	
	//Added by Arbind on 07-07-2017 --Blood Smear Report--
	public ModelAndView showBloodSmearJsp(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		Integer hospitalId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";

		HttpSession session = request.getSession();

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
	
		map = pubHealthHandlerService.getDistrictList();
		title = "Blood Smear";

		jsp = "bloodSmear";
		jsp += ".jsp";

		map.put("instituteTypeShortName", instituteTypeShortName);
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unused")
	public ModelAndView generateBloodSmearReport(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Box box = HMSUtil.getBox(request);
		int districtId = 0;
		int hospitalId = 0;
		String hospitalName = "";
		String qry="";
		try {
			if (session.getAttribute("hospitalId") != null) {
				hospitalId= (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
			}
			if (request.getParameter("district") != null && !(request.getParameter("district").equals("0"))) {
				districtId = Integer.parseInt(request.getParameter("district").toString());
				qry +="  and mh.district_id="+districtId;
			}
			if (request.getParameter("chcphc") != null && !(request.getParameter("chcphc").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("chcphc").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +="  and mh.parent_institute_id="+hospitalId;
			}
			if (request.getParameter("base") != null && !(request.getParameter("base").equals("0"))) {
				hospitalId = Integer.parseInt(request.getParameter("base").toString());
				requestParameters.put("hospitalId", hospitalId);
				hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
				requestParameters.put("hospitalName", hospitalName);
				qry +=" and sample.sub_centre_id="+hospitalId;
			}
			System.out.println("qry"+qry);

			requestParameters.put("qry", qry);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, Object> connectionMap = pubHealthHandlerService.getConnectionForReport();
		HMSUtil.generateReport("BloodSmear", requestParameters,	
				(Connection) connectionMap.get("con"), response, getServletContext());
		return null;
	}
	
	// -----------get CHC PHC ---Sub center List in Search -----
	public ModelAndView getSearchPhcChclist(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = pubHealthHandlerService.getchclist(box);
		jsp = "responcePhcChcSearch";
		return new ModelAndView(jsp, "map", map);
	}
	
	// -----------Supervisory Dashboard by Arbind-------------
	
	public ModelAndView showSupervisoryDashboard(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		List<Object[]> hospitalList = new ArrayList<Object[]>();
		List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String superAdmin = "";
		box.put("hospitalId", hospitalId);
		int chcphc =0; int healthBlocksId=0; List healthBlock=null;int base=0;
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		
		int sessionDistrictId = 0;
		if(session.getAttribute("districtId")!=null){
			sessionDistrictId = (Integer)session.getAttribute("districtId");
			box.put("district", sessionDistrictId);
		}
		String hospitalName = "";
		String instituteTypeShortName="";
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		
			if(instituteTypeShortName.equals("CHC")){
				box.put("listOfCenterId", 1);
			}else if(instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("PHC-24x7") || instituteTypeShortName.equals("PHC-NHM")){
				box.put("listOfCenterId", 2);
			}
			else if(instituteTypeShortName.equals("PPU")){
				box.put("listOfCenterId", 3);
			}
		
		map = pubHealthHandlerService.getDistrictList();
		masDistrict = (List) map.get("masDistrict");
		if(userType ==2){
			map = pubHealthHandlerService.gethealthblocklist(box);
			if(map.get("healthBlocksId")!=null && map.get("healthBlocksId")!=null){
			  healthBlocksId=(int) map.get("healthBlocksId");
			}
			if(map.get("healthBlock")!=null && map.get("healthBlock")!=null){
				healthBlock=(List)map.get("healthBlock");
				}
		}
		
		map = pubHealthHandlerService.gethealthblocklist(box);
		if(map.get("healthBlocksId")!=null){
		 healthBlocksId=(int) map.get("healthBlocksId");
		 box.put("healthblock", healthBlocksId);
		 
		}
		map = pubHealthHandlerService.getPhcChclist(box);
		if(map.get("chcphc")!=null){
			chcphc =(Integer)map.get("chcphc");
		}
		box.put("chcphc", chcphc);
		map = pubHealthHandlerService.getBasicCenterList(box);
		if(map.get("chcList")!=null){
			List<MasHospital> chcList=(List)map.get("chcList");
			if(chcList.size()>0){
				if(chcList.size()>1){
					base=0;
				}else if (chcList.size()>0 && chcList.size()<2) {
					base =chcList.get(0).getId();
				}
			}
		}
		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ 
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			hospitalList = pubHealthHandlerService.getHospitalListForTemplateApplication(sessionDistrictId);
			mhospitalTypetList = pubHealthHandlerService.getHospitalTypeListForPH();
			map.put("masDistrict", masDistrict);
			map.put("hospitalList", hospitalList);
			map.put("districtList", districtList);
			map.put("mhospitalTypetList", mhospitalTypetList);
			
		}
		map.put("chcphc", chcphc);
		map.put("base", base);
		map.put("healthBlock", healthBlock);
		map.put("healthBlocksId", healthBlocksId);
		map.put("instituteTypeShortName", instituteTypeShortName);
		jsp = "supervisoryDashboard";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDashboardSurveyCount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int districtId = 0;
		int userType = 0;
		if(request.getParameter("userType") != null) {
			userType = Integer.parseInt(request.getParameter("userType"));
		}
		if(request.getParameter("districtId") != null && !(request.getParameter("districtId").equals("0"))) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			box.put("districtId", districtId);
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalIds", hospitalId);

		
		map = pubHealthHandlerService.showDashboardSurveyCount(box);
		map.put("userType", userType);
		jsp = "responseDashboard";
		return new ModelAndView(jsp, "map", map);

	}
	

	public ModelAndView showPhMappingAdminJsp(HttpServletRequest request,
			HttpServletResponse response) {Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = null;
			Box box = HMSUtil.getBox(request);
			session = request.getSession();
			int hospitalId = 0;
			int userId = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = Integer.parseInt(""
						+ session.getAttribute("hospitalId"));
			}
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt("" + session.getAttribute("userId"));
			}
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			int hospitalTypeId=0;
			if (session.getAttribute("hospitalTypeId") != null) {
				hospitalTypeId = Integer.parseInt("" + session.getAttribute("hospitalTypeId"));
			}
			box.put("hospitalId", hospitalId);
			box.put("userId", userId);
			box.put("hospitalTypeId",hospitalTypeId);
			box.put("userType", userType);
			map = pubHealthHandlerService.showPhMappingAdminJsp(box);
			jsp = "phMappingAdmin";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
}

	// -------------- HMIS Hospital Wise REPORT by Arbind on 23-09-2017 ---------------------

	public ModelAndView showHMISEntryHospital(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId;
		HttpSession session = request.getSession();
		session = request.getSession(true);
		Calendar now = Calendar.getInstance();
		box.put("year", now.get(Calendar.YEAR));
		box.put("month", now.get(Calendar.MONTH) + 1);

		if (session.getAttribute(HOSPITAL_ID) != null
				&& !session.getAttribute(HOSPITAL_ID).equals("")) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = pubHealthHandlerService.getHMISReportDataFromDatabase(box);
		map.putAll(pubHealthHandlerService.getHMISHospitalCountFromDatabase(box));
		
		jsp = "hmisHospitalReportData" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHmisHospitalReportData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String counter = "";
		int hospitalId = 0;
		int districtId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";
		HttpSession session = request.getSession();
		session = request.getSession(true);
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("counter") != null && !request.getParameter("counter").equals("")) {
				counter = request.getParameter("counter");
				box.put("counter", counter);
			}
			if (session.getAttribute(HOSPITAL_ID) != null && !session.getAttribute(HOSPITAL_ID).equals("")) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(DISTRICT_ID) != null && !session.getAttribute(DISTRICT_ID).equals("")) {
				districtId = (Integer) session.getAttribute(DISTRICT_ID);
				box.put("districtId", districtId);
			}

			map = pubHealthHandlerService.submitHmisHospitalReportData(box);
			hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
			instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		
			map.putAll( pubHealthHandlerService.getDistrictList());
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "hmisHospitalReportJsp";
			jsp += ".jsp";
			title = "HMIS Report";
			map.put("instituteTypeShortName", instituteTypeShortName);
			map.put("hospitalName", hospitalName);
			map.put("hospitalId", hospitalId);
			map.put("contentJsp", jsp);
			map.put("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	// ===================== Upadate Hims Report Date for Month

	public ModelAndView updateHmisHospitalReportData(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String counter = "";
		int hospitalId = 0;
		int districtId = 0;
		String hospitalName = "";
		String instituteTypeShortName="";
		HttpSession session = request.getSession();
		session = request.getSession(true);
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			if (request.getParameter("counter") != null
					&& !request.getParameter("counter").equals("")) {
				counter = request.getParameter("counter");
				box.put("counter", counter);
			}
			if (session.getAttribute(HOSPITAL_ID) != null
					&& !session.getAttribute(HOSPITAL_ID).equals("")) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}
			if (session.getAttribute(DISTRICT_ID) != null
					&& !session.getAttribute(DISTRICT_ID).equals("")) {
				districtId = (Integer) session.getAttribute(DISTRICT_ID);
				box.put("districtId", districtId);
			}

			map = pubHealthHandlerService.updateHmisHospitalReportData(box);
			hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
			instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
			map.putAll( pubHealthHandlerService.getDistrictList());
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "Saved Successfully.";
			} else {
				message = "Try Again!";
			}

			jsp = "hmisHospitalReportJsp";
			jsp += ".jsp";
			title = "HMIS Report";
			map.put("instituteTypeShortName", instituteTypeShortName);
			map.put("hospitalName", hospitalName);
			map.put("hospitalId", hospitalId);
			map.put("contentJsp", jsp);
			map.put("message", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView createHmisHospitalExcelList(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		session = request.getSession(true);
		String facilityName = "";
		int fromMonth=0;
		int toMonth=0;
		int year=0;
		String monthFromName="";
		String monthToName="";
		int hospitalId = 0;

		try {
			if (session.getAttribute(HOSPITAL_ID) != null && !session.getAttribute(HOSPITAL_ID).equals("")) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				box.put("hospitalId", hospitalId);
			}
			if(request.getParameter("frommonths")!=null &&! request.getParameter("frommonths").equals("")){
				fromMonth=Integer.parseInt(request.getParameter("frommonths"));
				box.put("fromMonth",fromMonth);
			}
			if(request.getParameter("tomonths")!=null &&! request.getParameter("tomonths").equals("")){
				toMonth=Integer.parseInt(request.getParameter("tomonths"));
				box.put("toMonth",toMonth);
			}
			
			if(fromMonth == 1 )
			{
				monthFromName="Jan";
			}
			if(fromMonth == 2 )
			{
				monthFromName="Feb";
			}
			if(fromMonth == 3 )
			{
				monthFromName="Mar";
			}					
			if(fromMonth == 4 )
			{
				monthFromName="Apr";
			}
			if(fromMonth == 5)
			{
				monthFromName="May";
			}					
			if(fromMonth == 6)
			{
				monthFromName="Jun";
			}					
			if(fromMonth == 7  )
			{
				monthFromName="Jul";
			}					
			if(fromMonth == 8 )
			{
				monthFromName="Aug";
			}					
			if(fromMonth == 9 )
			{
				monthFromName="Sep";
			}					
			if(fromMonth == 10 )
			{
				monthFromName="Oct";
			}					
			if(fromMonth == 11 )
			{
				monthFromName="Nov";
			}					
			if(fromMonth == 12  )
			{
				monthFromName="Dec";
			}	
			
			if(toMonth == 1 )
			{
				monthToName="Jan";
			}
			if(toMonth == 2 )
			{
				monthToName="Feb";
			}
			if(toMonth == 3 )
			{
				monthToName="Mar";
			}					
			if(toMonth == 4 )
			{
				monthToName="Apr";
			}
			if(toMonth == 5)
			{
				monthToName="May";
			}					
			if(toMonth == 6)
			{
				monthToName="Jun";
			}					
			if(toMonth == 7  )
			{
				monthToName="Jul";
			}					
			if(toMonth == 8 )
			{
				monthToName="Aug";
			}					
			if(toMonth == 9 )
			{
				monthToName="Sep";
			}					
			if(toMonth == 10 )
			{
				monthToName="Oct";
			}					
			if(toMonth == 11 )
			{
				monthToName="Nov";
			}					
			if(toMonth == 12  )
			{
				monthToName="Dec";
			}
			if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
				year=Integer.parseInt(request.getParameter("year"));
				box.put("year",year);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		map = pubHealthHandlerService.createHmisHospitalExcelList(box);
		List<Object[]> hmisDistrictReportList = new ArrayList<Object[]>();
			if (map.get("hmisDistrictReportList") != null)
				hmisDistrictReportList = (List) map.get("hmisDistrictReportList");
			if(map.get("facilityName") != null && !map.get("facilityName").equals(""))
				facilityName = (String) map.get("facilityName");
			System.out.println(hmisDistrictReportList.size()+"---hmisDistrictReportList");
			try {
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=HmisByMonthExcel.xls");

				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("Sheet", 0);

				WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);
				wcf.setWrap(true);

				WritableCellFormat wcf2 = new WritableCellFormat(NumberFormats.TEXT);
				wcf2.setWrap(true);
				
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL, 10,	WritableFont.BOLD);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setAlignment(Alignment.CENTRE);
				wcf3.setWrap(false);


				CellView cell = new CellView();
				cell.setSize(3000);
				ws.setColumnView(0, cell);
				cell.setSize(10000);
				ws.setColumnView(1, cell);
				cell.setSize(3000);
				ws.setColumnView(2, cell);
				cell.setSize(3000);
				ws.setColumnView(3, cell);
				cell.setSize(3000);
				ws.setColumnView(4, cell);
				
				

				Label label = new Label(1, 0, "Organisation Unit Wise Progress Report", wcf3);
				ws.addCell(label);
				
				label = new Label(0, 1, "Facility", wcf3);
				ws.addCell(label);
				
				label = new Label(1, 1, facilityName, wcf3);
				ws.addCell(label);
				
				label = new Label(0, 2, "From", wcf3);
				ws.addCell(label);
				
				label = new Label(1, 2, monthFromName +"-"+ year, wcf3);
				ws.addCell(label);
				
				label = new Label(2, 2, "To", wcf3);
				ws.addCell(label);
				
				label = new Label(3, 2, monthToName +"-"+ year, wcf3);
				ws.addCell(label);

				label = new Label(3, 3, "Data", wcf3);
				ws.addCell(label);
				

				if (hmisDistrictReportList.size() > 0) {
					int count = 4;
					
					Iterator<Object[]> it = hmisDistrictReportList.iterator();

					while (it.hasNext()) {
						Object[] ob = it.next();
						String hmis_parameter = "";
						String hmis_id = "";
						String data_modify="";
						String total = "";
					
				
						if (ob[0] != null)
							hmis_id = "" + ob[0];
					
						if (ob[1] != null)
							hmis_parameter = "" + ob[1];
					
					if(!hmis_id.startsWith("M") && !hmis_id.startsWith("Part")) {
						total = "TOTAL";
						
						if (ob[2] != null) {
							data_modify =ob[2].toString();
						}
					}
						label = new Label(0, count, hmis_id, wcf2);
						ws.addCell(label);
						
						label = new Label(1, count, hmis_parameter, wcf2);
						ws.addCell(label);
						
						label = new Label(2, count, total, wcf2);
						ws.addCell(label);
						
						label = new Label(3, count,data_modify, wcf2);
						ws.addCell(label);
						
						count++;
					}
				}

				wb.write();
				wb.close();

				return null;
			} catch (Exception ioe) {
				ioe.printStackTrace();
				jsp = "storeBalance";
				jsp += ".jsp";
				title = "Export CD";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
	}

	// -----------get CHC PHC ---Sub center List in Hmis -----
	public ModelAndView getHmischcphclist(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		map = pubHealthHandlerService.getchclist(box);
		jsp = "responseChcPhcHmis";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getHmisBasicCenterListchcphc(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		int hospitalId = 0;
		if (request.getParameter("chcphc") != null && !request.getParameter("chcphc").equals("0")) {
			hospitalId = Integer.parseInt(""+ request.getParameter("chcphc"));
		}
		map = pubHealthHandlerService.getBasicCenterListForPhcChc(hospitalId);
		jsp = "responseCenterHmis";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView gethmisHospitalbyMonthValue(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession(true);
		int fromMonth = 0;
		int currentMonth = 0;
		int currentYear = 0;
		int hospitalId = 0;

		if (request.getParameter("monthValue") != null
				&& !request.getParameter("monthValue").equals("")) {
			fromMonth = Integer.parseInt(request.getParameter("monthValue"));
			System.out.println(fromMonth);
			box.put("month", fromMonth);
		}
		if (request.getParameter("months") != null
				&& !request.getParameter("months").equals("")) {
			currentMonth = Integer.parseInt(request.getParameter("months"));
			box.put("currentMonth", currentMonth);
		}

		int year = Calendar.getInstance().get(Calendar.YEAR);
		box.put("year", year);
		if (session.getAttribute(HOSPITAL_ID) != null
				&& !session.getAttribute(HOSPITAL_ID).equals("")) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = pubHealthHandlerService.getHMISReportDataFromDatabase(box);
		map.putAll(pubHealthHandlerService.getHMISCountFromDatabase(box));
		jsp = "hmisHospitalReportMonth";

		title = "HMIS";

		return new ModelAndView(jsp, "map", map);

	}
	// Added by Om tripathi 4/10/2017
	public ModelAndView addSupervisoryDashboardTarget(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Map<String, Object> details = new HashMap<String, Object>();
		String hospitalName = "";
		String instituteTypeShortName = "";
		String superAdmin = "";
		int userType = 0; /* user type 4 for general user */
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			Integer userId = user.getId();
			superAdmin = user.getSuperuser() != null ? user.getSuperuser(): "n";
			userType = user.getUserType() != null ? user.getUserType() : 4;
			box.put("userId", userId);
		}
		String userName = "";
		if (session.getAttribute("userName") != "") {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}

		int districtId = 0;
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer) session.getAttribute("districtId");
			box.put("districtId", districtId);
		}

		Map<String, String> responseList = new HashMap<String, String>();
		responseList = pubHealthHandlerService.addSupervisoryDashboardTarget(box);
		if (responseList.get("responseList") != null) {
			String responsemessage = (String) responseList.get("message");
			request.setAttribute("responsemessage", responsemessage);
		}
		map.put("responseList", responseList);
		int page = 1;
		details.put("page", page);
		if (superAdmin.equalsIgnoreCase("y")|| session.getAttribute("userName").equals("admin")|| userType < 3) {
			
			hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
			instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

			map = pubHealthHandlerService.getDistrictList();
			masDistrict = (List) map.get("masDistrict");
			map = pubHealthHandlerService.showPublicHealthHouseSurveyJsp(box,details);
			map.put("hospitalName", hospitalName);
			map.put("instituteTypeShortName", instituteTypeShortName);
			map.put("hospitalId", hospitalId);
			map.put("masDistrict", masDistrict);

		}

		jsp = "supervisorytarget";

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView publicHealthPieChart(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		String superAdmin = "";
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			Integer userId= user.getId();
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userType = user.getUserType()!=null?user.getUserType():4;
			 box.put("userId", userId);
			 box.put("userType", userType);
		}
		String userName = "";
		if(session.getAttribute("userName") != ""){
		 userName = (String)session.getAttribute("userName");
		}
		String instType=null;
		if(request.getParameter("instType") != null ) {
			instType = (String)request.getParameter("instType");
			box.put("instType", instType);
			
		}
		String instName=null;
		if(request.getParameter("instName") != null ) {
			instName = (String)request.getParameter("instName");
			box.put("instName", instName);
			
		}int chc=0;
		if(box.getInt("chcphc")!=0){
			 chc = box.getInt("chcphc");
		}
		int districtId = 0; List<MasHospital> basicSubList = new ArrayList<MasHospital>();
		Map map2=new HashMap<>();
		if(request.getParameter("districtId") != null) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			box.put("districtId", districtId);
		}if(request.getParameter("ListOfCenterId") !=null){
			if(Integer.parseInt(request.getParameter("ListOfCenterId")) ==1){
				map2 = (Map) pubHealthHandlerService.getBasicCenterList(box); 
				basicSubList = (List<MasHospital>) map2.get("chcList");
			
			}else if(Integer.parseInt(request.getParameter("ListOfCenterId")) ==2){
				map2 = (Map) pubHealthHandlerService.getBasicCenterListForPhcChc(chc);
				basicSubList = (List<MasHospital>) map2.get("chcList");
			
			}else if(Integer.parseInt(request.getParameter("ListOfCenterId")) ==3){
			
			}
			}
			Map<String,Integer> responseMap = new HashMap<String,Integer>();
			responseMap = pubHealthHandlerService.publicHealthPieChart(box,basicSubList);
						
			request.setAttribute("responseMap", responseMap);
			
			
			

			String jsp = "pieChart";
		
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

public void showDashboardCumulativeSurveyCount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int districtId = 0;
		int userType = 0;
		String instName=null;
		String instType= null;
		if(request.getParameter("userType") != null) {
			userType = box.getInt("userType");
			box.put("userType", userType);
		}
		if(request.getParameter("districtId") != null && !(request.getParameter("districtId").equals("0"))) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			box.put("districtId", districtId);
		}
		if(request.getParameter("instName") != null ) {
			instName = (String)request.getParameter("instName");
			box.put("instName", instName);
		}
		if(request.getParameter("instType") != null ) {
			instType = (String)request.getParameter("instType");
			box.put("instType", instType);
		}
		int instituteType=0;
		if(request.getParameter("instituteType") != null ) {
			instituteType = Integer.parseInt(request.getParameter("instituteType"));
			box.put("instituteType", instituteType);
		}
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalIds", hospitalId);
		map = pubHealthHandlerService.showDashboardSurveyCount(box);
		
		
		int dayBlockMonthlyCount=0;
		int dayBlockCount=0;
		int houseVisitedMonthly=0;
		int memberCount=0;int counthouse=0; 
		if((Integer)map.get("countHouse")!=0){
			counthouse=(int) map.get("countHouse");
		}
		if((Integer)(map.get("memberCount"))!=0){
			memberCount=(int) map.get("memberCount");
		}
		if(map.get("dayBlockCount")!=null){
			dayBlockCount=(int) map.get("dayBlockCount");
		}
		if((map.get("dayBlockMonthlyCount"))!=null){
			dayBlockMonthlyCount=(int) map.get("dayBlockMonthlyCount"); 
		}
		if((map.get("houseVisitedMonthly"))!=null){
			houseVisitedMonthly=(int) map.get("houseVisitedMonthly"); 
		}   
		int totalhousecount=0;
		if((map.get("totalhousecount"))!=null){
			totalhousecount=(int) map.get("totalhousecount"); 
		}
		int totalmembercount=0;
		if((map.get("totalmembercount"))!=null){
			totalmembercount=(int) map.get("totalmembercount"); 
		}
		long monthlyHStarget=0;
		if((map.get("monthlyHStarget"))!=null){
			monthlyHStarget=(long) map.get("monthlyHStarget"); 
		}
		long annualHStarget=0;
		if((map.get("annualHStarget"))!=null){
			annualHStarget=(long) map.get("annualHStarget"); 
		}
		long annualMemberSurveyTarget=0;
		if((map.get("annualMemberSurveyTarget"))!=null){
			annualMemberSurveyTarget=(long) map.get("annualMemberSurveyTarget"); 
		}

		long monthlyMemberSurveyTarget=0;
		if((map.get("monthlyMemberSurveyTarget"))!=null){
			monthlyMemberSurveyTarget=(long) map.get("monthlyMemberSurveyTarget"); 
		}
		String status=null;
		if((map.get("status"))!=null){
			status=(String) map.get("status"); 
		}
		String remarks=null;
		if((map.get("remarks"))!=null){
			remarks=(String) map.get("remarks"); 
		}
		Date toDate=null;
		if((map.get("toDate"))!=null){
			toDate=(Date) map.get("toDate"); 
		}
		Date fromDate=null;
		if(map.get("fromDate")!=null){
			fromDate=(Date) map.get("fromDate"); 
		}
		int targetId =0;
		if(map.get("targetId")!=null){
			targetId=(int) map.get("targetId"); 
		}
		Long annualHVisitTarget=0l;
		if(map.get("annualHVisitTarget")!=null){
			annualHVisitTarget=(Long) map.get("annualHVisitTarget"); 
		}
		Map statusMaps=new HashMap<>();
		String phn="N";
		String dphn ="N";
		String phns="N";
		String hs="N";
		String hi="N";
		String dmo="N";
		String rcho="N";
		String mochc="N";
		String tag2="N";
		String mophc="N";
		if((map.get("statusMap"))!=null){
			statusMaps= (Map) map.get("statusMap"); 
			 phn =(String) statusMaps.get("PublicHealthNurse");
			 dphn=(String) statusMaps.get("DistrictPublicHealthNurse");
			 phns=(String) statusMaps.get("PublicHealthNurseSupervisor");
			 
			 hs =(String) statusMaps.get("HealthSupervisor");
			 hi=(String) statusMaps.get("HealthInspector");
			 
			 dmo=(String) statusMaps.get("DistrictMedicalOfficer");
			 rcho=(String) statusMaps.get("RCHO");
			 mochc=(String) statusMaps.get("MedicalOfficerCHC");
			 tag2=(String) statusMaps.get("TechnicalAssistantGradeII");
			 mophc=(String) statusMaps.get("MedicalOfficerPHC"); 
			
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item1>");
		sb.append("<alreadyIssued2>" + houseVisitedMonthly + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + dayBlockCount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + monthlyHStarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualHStarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + remarks + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + status + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + phn + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + dphn + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + phns + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + fromDate + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + toDate + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + targetId + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualMemberSurveyTarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + monthlyMemberSurveyTarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + counthouse + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + memberCount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + totalmembercount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + totalhousecount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + hs + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + hi + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualHVisitTarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + dmo + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + rcho + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + mochc + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + tag2 + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + mophc + "</alreadyIssued2>");
		
		
		sb.append("</item1>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items1>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public ModelAndView addTargetSupervisoryDashboard(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int chcphc =0; int healthBlocksId=0; List healthBlock=null;int base=0;
		int districtId = 0;
		String hospitalName = "";
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		String instituteTypeShortName="";
		int page = 1;
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer) session.getAttribute("districtId");
			box.put("districtId", districtId);
			box.put("district", districtId);
		}
		if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));    
		}
		details.put("page", page);
		//hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		
		if(instituteTypeShortName.equals("CHC")){
			box.put("listOfCenterId", 1);
		}else if(instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("PHC-24x7") || instituteTypeShortName.equals("PHC-NHM")){
			box.put("listOfCenterId", 2);
		}
		else if(instituteTypeShortName.equals("PPU")){
			box.put("listOfCenterId", 3);
		}
		
		map = pubHealthHandlerService.gethealthblocklist(box);
		if(map.get("healthBlocksId")!=null && map.get("healthBlocksId")!=null){
			  healthBlocksId=(int) map.get("healthBlocksId");
			  box.put("healthblock", healthBlocksId);
			}
			if(map.get("healthBlock")!=null && map.get("healthBlock")!=null){
				healthBlock=(List)map.get("healthBlock");
				}
				
			map = pubHealthHandlerService.getPhcChclist(box);
			if(map.get("chcphc")!=null){
				chcphc =(Integer)map.get("chcphc");
			}
			box.put("chcphc", chcphc);
		
			map = pubHealthHandlerService.getBasicCenterList(box);
			if(map.get("chcList")!=null){
				List<MasHospital> chcList=(List)map.get("chcList");
				if(chcList.size()>0){
					if(chcList.size()>1){
						base=0;
					}else if (chcList.size()>0 && chcList.size()<2) {
						base =chcList.get(0).getId();
					}
				}
			}
		map = pubHealthHandlerService.getDistrictList();
		masDistrict = (List) map.get("masDistrict");
		
		//map = pubHealthHandlerService.showPublicHealthHouseSurveyJsp(box, details);
		jsp = "supervisorytarget" + ".jsp";
		
		map.put("chcphc", chcphc);
		map.put("base", base);
		map.put("healthBlock", healthBlock);
		map.put("healthBlocksId", healthBlocksId);
		map.put("instituteTypeShortName", instituteTypeShortName);
		
		map.put("hospitalName", hospitalName);
		map.put("hospitalId", hospitalId);
		map.put("masDistrict", masDistrict);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	/**
	 * @param request
	 * @param response
	 * @return List of healthblock
	 */
	public ModelAndView gethealthblocklist(HttpServletRequest request,	HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		

		map = pubHealthHandlerService.gethealthblocklist(box);
		jsp = "responceHealthBlock";
		return new ModelAndView(jsp, "map", map);
	}
	
	/**
	 * @param request
	 * @param response
	 * @return name of CHC
	 */
	public ModelAndView getPhcChclist(HttpServletRequest request,HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		
		map = pubHealthHandlerService.getPhcChclist(box);
		jsp = "responcePhcChcPPunit";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showDashboardAuthenticate(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		String superAdmin = "";
		int chcphc =0; int healthBlocksId=0; List healthBlock=null;int base=0;
		int userType = 0; /* user type 4 for general user */
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userType = user.getUserType()!=null?user.getUserType():4;
		}
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		String loginName=null;
		if(session.getAttribute("loginName")!=null){
			loginName=(String)session.getAttribute("loginName");
		}
		MasHospital hospital = new MasHospital();
		int sessionDistrictId = 0;
		if(session.getAttribute("districtId")!=null){
			sessionDistrictId = (Integer)session.getAttribute("districtId");
			box.put("district", sessionDistrictId);
		}
		
		String hospitalName = "";
		String instituteTypeShortName="";
		hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
		instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);
		if(instituteTypeShortName.equals("CHC")){
			box.put("listOfCenterId", 1);
		}else if(instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("PHC-24x7") || instituteTypeShortName.equals("PHC-NHM")){
			box.put("listOfCenterId", 2);
		}
		else if(instituteTypeShortName.equals("PPU")){
			box.put("listOfCenterId", 3);
		}
		
		map = pubHealthHandlerService.gethealthblocklist(box);
		if(map.get("healthBlocksId")!=null && map.get("healthBlocksId")!=null){
			  healthBlocksId=(int) map.get("healthBlocksId");
			  box.put("healthblock", healthBlocksId);
			}
			if(map.get("healthBlock")!=null && map.get("healthBlock")!=null){
				healthBlock=(List)map.get("healthBlock");
				}
				
			map = pubHealthHandlerService.getPhcChclist(box);
			if(map.get("chcphc")!=null){
				chcphc =(Integer)map.get("chcphc");
			}
			box.put("chcphc", chcphc);
		
			map = pubHealthHandlerService.getBasicCenterList(box);
			if(map.get("chcList")!=null){
				List<MasHospital> chcList=(List)map.get("chcList");
				if(chcList.size()>0){
					if(chcList.size()>1){
						base=0;
					}else if (chcList.size()>0 && chcList.size()<2) {
						base =chcList.get(0).getId();
					}
				}
			}
		
		map = pubHealthHandlerService.getDistrictList();
		masDistrict = (List) map.get("masDistrict");
		
		map = pubHealthHandlerService.getPhcChclist(box);
		if(map.get("chcphc")!=null){
			chcphc =(Integer)map.get("chcphc");
		}
		box.put("chcphc", chcphc);
		map = pubHealthHandlerService.getBasicCenterList(box);
		if(map.get("chcList")!=null){
			List<MasHospital> chcList=(List)map.get("chcList");
			if(chcList.size()>0){
				if(chcList.size()>1){
					base=0;
				}else if (chcList.size()>0 && chcList.size()<2) {
					base =chcList.get(0).getId();
				}
			}
		}

		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3 || userType==5){ 
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = pubHealthHandlerService.getHospitalListForTemplateApplication(sessionDistrictId);
			List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
			mhospitalTypetList = pubHealthHandlerService.getHospitalTypeListForPH();
			map.put("mhospitalTypetList", mhospitalTypetList);
			map.put("hospitalList", hospitalList);
			map.put("masDistrict", masDistrict);
			
		}
		map.put("chcphc", chcphc);
		map.put("base", base);
		map.put("healthBlock", healthBlock);
		map.put("healthBlocksId", healthBlocksId);
		map.put("instituteTypeShortName", instituteTypeShortName);

		jsp = "dashboardAuthentication";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	/**
	 *  Using this method we get the target and 
	 *  survey for authentication.
	 * @param request
	 * @param response
	 */
	public void showDashboardTargetDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> targetmap = new HashMap<String, Object>();

		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int districtId = 0;
		int userType = 0;
		String instName=null;
		String instType= null;
		if(request.getParameter("userType") != null) {
			userType = box.getInt("userType");
			box.put("userType", userType);
		}
		if(request.getParameter("districtId") != null && !(request.getParameter("districtId").equals("0"))) {
			districtId = Integer.parseInt(request.getParameter("districtId"));
			box.put("districtId", districtId);
		}
		if(request.getParameter("instName") != null ) {
			instName = (String)request.getParameter("instName");
			box.put("instName", instName);
		}
		if(request.getParameter("instType") != null ) {
			instType = (String)request.getParameter("instType");
			box.put("instType", instType);
		}
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalIds", hospitalId);
		targetmap = pubHealthHandlerService.showDashboardTargetDetails(box);
		
		int dayBlockMonthlyCount=0;
		int dayBlockCount=0;
		int houseVisitedMonthly=0;
		int memberCount=0;int counthouse=0; 
		if((Integer)targetmap.get("countHouse")!=0){
			counthouse=(int) targetmap.get("countHouse");
		}
		if((Integer)(targetmap.get("memberCount"))!=0){
			memberCount=(int) targetmap.get("memberCount");
		}
		if(targetmap.get("dayBlockCount")!=null){
			dayBlockCount=(int) targetmap.get("dayBlockCount");
		}
		if((targetmap.get("dayBlockMonthlyCount"))!=null){
			dayBlockMonthlyCount=(int) targetmap.get("dayBlockMonthlyCount"); 
		}
		if((targetmap.get("houseVisitedMonthly"))!=null){
			houseVisitedMonthly=(int) targetmap.get("houseVisitedMonthly"); 
		}   
		int totalhousecount=0;
		if((targetmap.get("totalhousecount"))!=null){
			totalhousecount=(int) targetmap.get("totalhousecount"); 
		}
		int totalmembercount=0;
		if((targetmap.get("totalmembercount"))!=null){
			totalmembercount=(int) targetmap.get("totalmembercount"); 
		}
		long monthlyHStarget=0;
		if((targetmap.get("monthlyHStarget"))!=null){
			monthlyHStarget=(long) targetmap.get("monthlyHStarget"); 
		}
		long annualHStarget=0;
		if((targetmap.get("annualHStarget"))!=null){
			annualHStarget=(long) targetmap.get("annualHStarget"); 
		}
		long annualMemberSurveyTarget=0;
		if((targetmap.get("annualMemberSurveyTarget"))!=null){
			annualMemberSurveyTarget=(long) targetmap.get("annualMemberSurveyTarget"); 
		}

		long monthlyMemberSurveyTarget=0;
		if((targetmap.get("monthlyMemberSurveyTarget"))!=null){
			monthlyMemberSurveyTarget=(long) targetmap.get("monthlyMemberSurveyTarget"); 
		}
		String status=null;
		if((targetmap.get("status"))!=null){
			status=(String) targetmap.get("status"); 
		}
		String remarks=null;
		if((targetmap.get("remarks"))!=null){
			remarks=(String) targetmap.get("remarks"); 
		}
		Date toDate=null;
		if((targetmap.get("toDate"))!=null){
			toDate=(Date) targetmap.get("toDate"); 
		}
		Date fromDate=null;
		if(targetmap.get("fromDate")!=null){
			fromDate=(Date) targetmap.get("fromDate"); 
		}
		int targetId =0;
		if(targetmap.get("targetId")!=null){
			targetId=(int) targetmap.get("targetId"); 
		}
		Long annualHVisitTarget=0l;
		if(targetmap.get("annualHVisitTarget")!=null){
			annualHVisitTarget=(Long) targetmap.get("annualHVisitTarget"); 
		}
		Map statusMaps=new HashMap<>();
		String phn="N";
		String dphn ="N";
		String phns="N";
		String hs="N";
		String hi="N";
		if((targetmap.get("statusMap"))!=null){
			statusMaps= (Map) targetmap.get("statusMap"); 
			 phn =(String) statusMaps.get("Public Health Nurse");
			 dphn=(String) statusMaps.get("District Public Health Nurse");
			 phns=(String) statusMaps.get("Public Health Nurse Supervisor");
			 
			 hs =(String) statusMaps.get("Health Supervisor");
			 hi=(String) statusMaps.get("Health Inspector");
		
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item1>");
		sb.append("<alreadyIssued2>" + houseVisitedMonthly + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + dayBlockCount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + monthlyHStarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualHStarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + remarks + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + status + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + phn + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + dphn + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + phns + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + fromDate + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + toDate + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + targetId + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualMemberSurveyTarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + monthlyMemberSurveyTarget + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + counthouse + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + memberCount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + totalmembercount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + totalhousecount + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + hs + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + hi + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + annualHVisitTarget + "</alreadyIssued2>");
		sb.append("</item1>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items1>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ModelAndView dashboardAuthentication(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("hospitalId", hospitalId);
		List<MasDistrict> masDistrict = new ArrayList<MasDistrict>();
		Map<String, Object> details = new HashMap<String, Object>();
		String hospitalName = "";
		String instituteTypeShortName = "";
		String superAdmin = "";
		int userType = 0; /* user type 4 for general user */
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			Integer userId = user.getId();
			superAdmin = user.getSuperuser() != null ? user.getSuperuser(): "n";
			userType = user.getUserType() != null ? user.getUserType() : 4;
			box.put("userId", userId);
		}
		String userName = "";
		if (session.getAttribute("userName") != "") {
			userName = (String) session.getAttribute("userName");
			box.put("userName", userName);
		}

		int districtId = 0;
		if (session.getAttribute("districtId") != null) {
			districtId = (Integer) session.getAttribute("districtId");
			box.put("districtId", districtId);
		}

		Map<String, String> responseList = new HashMap<String, String>();
		responseList = pubHealthHandlerService.dashboardAuthentication(box);
		if (responseList.get("responseList") != null) {
			String responsemessage = (String) responseList.get("message");
			request.setAttribute("responsemessage", responsemessage);
		}
		map.put("responseList", responseList);
		int page = 1;
		details.put("page", page);
		if (superAdmin.equalsIgnoreCase("y")|| session.getAttribute("userName").equals("admin")|| userType < 4|| userType ==5) {
			
			hospitalName = pubHealthHandlerService.getHospitalName(hospitalId);
			instituteTypeShortName = pubHealthHandlerService.getInstituteTypeName(hospitalId);

			map = pubHealthHandlerService.getDistrictList();
			masDistrict = (List) map.get("masDistrict");
			map = pubHealthHandlerService.showPublicHealthHouseSurveyJsp(box,details);
			map.put("hospitalName", hospitalName);
			map.put("instituteTypeShortName", instituteTypeShortName);
			map.put("hospitalId", hospitalId);
			map.put("masDistrict", masDistrict);

		}

		jsp = "dashboardAuthentication";

		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getBasicCenterList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		
		map = pubHealthHandlerService.getBasicCenterList(box);
		jsp = "basic_center_list";
		return new ModelAndView(jsp, "map", map);

	}
	
	/**
	 * This Method used to search and upload the tablet details to db.
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView tabAssetsMaster(HttpServletRequest request,
			HttpServletResponse response) {

		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		String searchs="";
		if(request.getParameter("searchs")!=null){
		  searchs = (String)request.getParameter("searchs");
		  box.put("search",searchs);
		}
		
		List<MasHospital> masTablets= new ArrayList<MasHospital>();
		if(searchs.equals("Y")){
			map = pubHealthHandlerService.searchAssetTablet(box);
			if(map.get("masTablets")!=null){
				masTablets = (List<MasHospital>)map.get("masTablets");
			}
		}
		
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String superAdmin = "";
		int userType = 0; /* user type 4 for general user */
		int userId = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
			 userType = user.getUserType()!=null?user.getUserType():4;
			 userId = user.getId();
		}
		
		List<Object[]> departmentList = new ArrayList<Object[]>();
		departmentList = userMasterHandlerService.getDepartmentList(hospitalId);
		
		String userName = "";
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		
		int sessionDistrictId = 0;
		if(session.getAttribute("districtId")!=null){
			sessionDistrictId = (Integer)session.getAttribute("districtId");
		}
	
		if(superAdmin.equalsIgnoreCase("y") || session.getAttribute("userName").equals("admin") || userType<3){ 
			List<Object[]> districtList = new ArrayList<Object[]>();
			districtList = userMasterHandlerService.getDistrictList();
			
			List<Object[]> hospitalList = new ArrayList<Object[]>();
			hospitalList = userMasterHandlerService.getHospitalListForTemplateApplication(sessionDistrictId);
			
			List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
			mhospitalTypetList = userMasterHandlerService.getHospitalTypeListForTemplateApplication();
			map.put("mhospitalTypetList", mhospitalTypetList);
			map.put("hospitalList", hospitalList);
			map.put("districtList", districtList);
		}else if(userType == 5){ // PH admin
			List<Object[]> bsScInstList = new ArrayList<Object[]>();
			bsScInstList = userMasterHandlerService.getBsScInstList(userId);
			map.put("bsScInstList", bsScInstList);
		}
		
		map.put("departmentList", departmentList);
		map.put("masTablets", masTablets);
		jsp = "tablet_asset_master";
		jsp += ".jsp";
		title = "Tablet Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView addTabletAssetsDetails(HttpServletRequest request,
			HttpServletResponse response) {
		String url="";
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
			box.put("userId",userId);
		}
		map = pubHealthHandlerService.addTabletAssets(box);
		url="/hms/hms/pubHealth?method=tabAssetsMaster";
		
		jsp = "tablet_asset_master";
		jsp += ".jsp";
		title = "Tablet Master";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", "");
		
		return new ModelAndView("index", "map", map);
		
	}
	public void getHospitalDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		
		String hospitalCode =null;
		String hospitalName = null;
		
		Box box = HMSUtil.getBox(request);
		
		map = pubHealthHandlerService.getHospitalDetails(box);
		if(map.get("hospitals")!=null){
			List<MasHospital> hospital= (List<MasHospital>)map.get("hospitals");
			if (hospital.size()>0) {
				hospitalCode = hospital.get(0).getHospitalCode();
				hospitalName = hospital.get(0).getHospitalName();
			}
			
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item1>");
		sb.append("<alreadyIssued2>" + hospitalCode + "</alreadyIssued2>");
		sb.append("<alreadyIssued2>" + hospitalName + "</alreadyIssued2>");
		sb.append("</item1>");
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items1>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items1>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	public ModelAndView getHospitalDetailForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<MasHospital> hospitals=new ArrayList<MasHospital>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("autoCompleate","Y");
		map = pubHealthHandlerService.getHospitalDetails(box);
		if(map.get("hospitals")!=null){
			hospitals = (List<MasHospital>)map.get("hospitals");
		}
		map.put("hospitals", hospitals);
		jsp = "hospitalCodeDiv";
       return new ModelAndView(jsp, "map", map);
	 }
	
	public ModelAndView importAssetsDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MultipartFormDataRequest mrequest = null;
		String userName = "";
		String flag1 = "import";
		boolean succesfullyAdded = false;
		String msg = "";

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = (MultipartFormDataRequest) new MultipartFormDataRequest(
						request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Map<String, Object> uploadFileMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		String uploadURL = getServletContext().getRealPath("/stores/");
		String fileName = box.getString("filename");
		String whiteList = "*.xls";
		List fileUploadedList = null;

		List<String> instituteCode = new ArrayList<String>();
		List<String> UTID = new ArrayList<String>();
		List<String> MAC = new ArrayList<String>();
		List<Long> IMEI = new ArrayList<Long>();
		List<String> SIM = new ArrayList<String>();
		List<String> transferStatus = new ArrayList<String>();
		
		box.put("uploadURL", uploadURL);
		box.put("filename", box.getString("filename"));

		try {

			fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL,
					whiteList, box.getString("filename"));
			Boolean fileUploaded = false;
			if (fileUploadedList != null && fileUploadedList.size() != 0) {
				fileUploaded = (Boolean) fileUploadedList.get(0);
			}
			jxl.WorkbookSettings ws = null;
			jxl.Workbook workbook = null;
			jxl.Sheet s = null;
			Cell rowData[] = null;
			int rowCount = '0';
			int columnCount = '0';
			DateCell dc = null;
			int totalSheet = 0;

			try {
				ws = new WorkbookSettings();
				ws.setLocale(new Locale("en", "EN"));
				workbook = jxl.Workbook.getWorkbook(
						(new FileInputStream(box.getString("uploadURL") + "/"
								+ box.getString("filename"))), ws);

				totalSheet = workbook.getNumberOfSheets();

				s = workbook.getSheet(0);

				rowCount = s.getRows();

				columnCount = s.getColumns();
				
			

				for (int i = 1; i < rowCount; i++) {
					rowData = s.getRow(i);
					if (rowData[0].getContents().length() != 0) {

						for (int j = 0; j < columnCount; j++) {
							switch (j) {
							case 0:
								try {
									if (rowData[j].getContents().length() != 0) {
										instituteCode
												.add(rowData[j].getContents());
									} else {
										instituteCode.add("");
									}
								} catch (Exception e) {
									instituteCode.add("");
								}
								break;
							case 1:
								try {
									if (rowData[j].getContents().length() != 0) {
										
										MAC.add(rowData[j].getContents());
									} else {
										MAC.add("");
									}
								} catch (Exception e) {
									MAC.add("");
								}
								break;
							case 2:
								try {
									if (rowData[j].getContents().length() != 0) {
										
										UTID.add((rowData[j].getContents()));
									} else {
										UTID.add("");
									}
								} catch (Exception e) {
									UTID.add("");
								}
								break;
							case 3:
								try {
									if (rowData[j].getContents().length() != 0) {
										
										IMEI.add(Long.parseLong(rowData[j].getContents()));
									} else {
										IMEI.add(0l);
									}
								} catch (Exception e) {
									IMEI.add(0l);
								}
								break;
								
							case 4:
								try {
									if (rowData[j].getContents().length() != 0) {
										
										SIM.add((rowData[j].getContents()));
									} else {
										SIM.add("");
									}
								} catch (Exception e) {
									SIM.add("");
								}
								break;
							case 5:
								try {
									if (rowData[j].getContents().length() != 0) {
										
										transferStatus.add((rowData[j].getContents()));
									} else {
										transferStatus.add("");
									}
								} catch (Exception e) {
									transferStatus.add("");
								}
								break;
							}
							
						}
					}
				}
				workbook.close();
				utilMap.put("instituteCode", instituteCode);
				utilMap.put("UTID", UTID);
				utilMap.put("MAC", MAC);
				utilMap.put("SIM", SIM);
				utilMap.put("IMEI", IMEI);
				utilMap.put("transferStatus", transferStatus);
				
				utilMap.put("deptId", deptId);
				utilMap.put("hospitalId", hospitalId);
				utilMap.put("userName", userName);
				utilMap.put("userId", userId);
				box.put("deptId", deptId);
				box.put("userId", userId);
				box.put("hospitalId", hospitalId);
				box.put("numOfRows", 15);
				box.put("pageCount", 10);
				box.put("currPage", 1); 

				map = pubHealthHandlerService.importAssetsDetails(utilMap);

			} catch (IOException e) {
				e.printStackTrace();

			}

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		jsp = "tablet_asset_master";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public void downloadTabletDetails(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		final int BUFFER_SIZE = 4096;
		
		String filePath = "/excel/TABLET_DETAILS.xls";
		
		ServletContext context =  getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		String fullPath = appPath + filePath;		
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}
	
	public ModelAndView searchAssetTablet(
			HttpServletRequest request, HttpServletResponse response) {
		
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = null;
		session = request.getSession();
		Box box = HMSUtil.getBox(request);
		List<MasHospital> masTablets = new ArrayList<MasHospital>();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		box.put("autoCompleate","Y");
		map = pubHealthHandlerService.searchAssetTablet(box);
		if(map.get("masTablets")!=null){
			masTablets = (List<MasHospital>)map.get("masTablets");
		}
		map.put("masTablets", masTablets);
		jsp = "tablet_asset_master.jsp";
       return new ModelAndView(jsp, "map", map);
	 }
	
	public ModelAndView tabletAssetsMasterSearch(HttpServletRequest request,
			HttpServletResponse response) {

		String jsp = "";
		String title = "";
		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		List<MasHospital> masTablets= new ArrayList<MasHospital>();
		int hospitalIds=0;
		if(request.getParameter("hospitalIds")!=null){
			hospitalIds = Integer.valueOf(request.getParameter("hospitalIds")+"");
			box.put("hospitalIds", hospitalIds);
			box.put("search", "search");
		}
		List<MasHospital> masHospList =new ArrayList<MasHospital>();
		map = pubHealthHandlerService.searchAssetTablet(box);
		if(map.get("masHospList")!=null){
			masHospList =(List<MasHospital>)map.get("masHospList");
			map.put("masHospList", masHospList);
			}
		jsp = "tablet_asset_master_search";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView generateReportForTabletMasters(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int hospitalId = 0;
		HttpSession session=null;
		String hospitalName = "";
		int deptId = 0;
		String query = new String("");
		Box box = HMSUtil.getBox(request);
		String deptName = "";
		session = request.getSession();
		try {

				query = query + " and mas_hospital.hospital_id ="
						+(Integer) session.getAttribute("hospitalId");
			requestParameters.put("query", query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = pubHealthHandlerService
				.getConnectionForReport();
		String reportName = "";
			reportName = TABLET_DETAILS_REPORT;

		HMSUtil.generateReport(reportName, requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());

		return null;
	}
	
}
