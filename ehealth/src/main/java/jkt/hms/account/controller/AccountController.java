/**
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * BillingController.java �
 * Purpose of the class - This is for OP Billing.
 * @author  Mrityunjay
 * Updated and merged by Ujjwal Kashyap 
 * Create Date: 09th Sept,2015
 * Revision Date:
 * Revision By: Purpose
 * @version 1.0
 **/

package jkt.hms.account.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.account.handler.AccountHandlerService;
import jkt.hms.masters.business.AccountMainTransac;
import jkt.hms.masters.business.AccountSubLedTransac;
import jkt.hms.masters.business.FaAccountHospitalTypeMapping;
import jkt.hms.masters.business.FaMasAccount;
import jkt.hms.masters.business.FaMasAccountGroup;
import jkt.hms.masters.business.FaMasAccountSubGroup;
import jkt.hms.masters.business.FaMasNarration;
import jkt.hms.masters.business.FaMasSubLed;
import jkt.hms.masters.business.FaVoucherDetails;
import jkt.hms.masters.business.MasAccountSchedule;
import jkt.hms.masters.business.MasBankMaster;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasHospitalType;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreFinancial;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.ViewData;
import jkt.hms.masters.business.VwLedgerBalance;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hrms.masters.business.HrMasFinancialYear;
import jkt.hrms.util.LeaveManagementUtil;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Alignment;
import jxl.write.Border;
import jxl.write.Label;
import jxl.write.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.model.Model;
import org.apache.poi.hssf.record.formula.functions.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.logica.smpp.Session;

//commented for maven
/*import com.ibm.db2.jcc.a.f;
*/
public class AccountController extends MultiActionController {

	AccountHandlerService accountHandlerService = null;

	public AccountHandlerService getAccountHandlerService() {
		return accountHandlerService;
	}

	public void setAccountHandlerService(
			AccountHandlerService accountHandlerService) {
		this.accountHandlerService = accountHandlerService;
	}

	public ModelAndView showAccountsGroupMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * if (session.getAttribute("locationId") != null) { int locationId =
		 * (Integer) session.getAttribute("locationId");
		 * generalMap.put("locationId", locationId); }
		 */
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}

		map = accountHandlerService.showAccountsGroupMasterJsp(generalMap);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * if (session.getAttribute("locationId") != null) { int locationId =
		 * (Integer) session.getAttribute("locationId");
		 * generalMap.put("locationId", locationId); }
		 */
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		String accountGroupName = "";
		if (request.getParameter(SEARCH_FIELD) != null
				&& !request.getParameter(SEARCH_FIELD).equals("")) {
			accountGroupName = request.getParameter(SEARCH_FIELD);
			generalMap.put("accountGroupName", accountGroupName);
		}

		map = accountHandlerService.searchAccountGroupNew(generalMap);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int groupCode = 0;
		HttpSession session = request.getSession();
		if (request.getParameter(SEARCH_NAME) != null
				&& !request.getParameter(SEARCH_NAME).equals("")) {
			groupCode = Integer.parseInt(request.getParameter(SEARCH_NAME));
		}
		String groupDescription = "";
		if (request.getParameter("discription") != null
				&& !request.getParameter("discription").equals("")) {
			groupDescription = request.getParameter("discription");
		}
		int fYear = 1;
		/*
		 * if (session.getAttribute("financialYear") != null) { fYear =
		 * (Integer) session.getAttribute("financialYear");
		 * 
		 * }
		 */

		FaMasAccountGroup fag = new FaMasAccountGroup();
		fag.setAccountGroupCode(groupCode);
		fag.setAccountGroupDesc(groupDescription);
		fag.setClBalanceCr(new BigDecimal(0));
		fag.setClBalanceDr(new BigDecimal(0));

		MasStoreFinancial mfy = new MasStoreFinancial();
		mfy.setId(1);
		fag.setFYear(mfy);

		Users users = new Users();
		int changedBy = 0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
		}
		Users user = new Users();
		user.setId(changedBy);
		fag.setLastChgBy(user);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		fag.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		fag.setLastChgTime(time);

		fag.setOpBalanceDr(new BigDecimal(0));
		fag.setOpBalanceCr(new BigDecimal(0));
		fag.setStatus("y");
		fag.setYtdAmountCr(new BigDecimal(0));
		fag.setYtdAmountDr(new BigDecimal(0));

		generalMap.put("fag", fag);
		generalMap.put("fYear", fYear);
		map = accountHandlerService.addAccountGroupNew(generalMap);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.deleteAccountGroupNew(box);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAccountGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.updateAccountGroupNew(box);
		String jsp = "accountGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * if (session.getAttribute("locationId") != null) { int locationId =
		 * (Integer) session.getAttribute("locationId");
		 * generalMap.put("locationId", locationId); }
		 */
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}

		map = accountHandlerService.showAccountSubGroupNew(generalMap);
		String jsp = "accountSubGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * Searching subGroup
	 */
	public ModelAndView searchAccountSubGroup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		/*
		 * if (session.getAttribute("locationId") != null) { int locationId =
		 * (Integer) session.getAttribute("locationId");
		 * generalMap.put("locationId", locationId); }
		 */
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		String accountGroupName = "";
		if (request.getParameter(SEARCH_FIELD) != null
				&& !request.getParameter(SEARCH_FIELD).equals("")) {
			accountGroupName = request.getParameter(SEARCH_FIELD);
			generalMap.put("accountGroupName", accountGroupName);
		}
		int radioValue = 0;

		if (request.getParameter(SELECTED_RADIO) != null
				&& !request.getParameter(SELECTED_RADIO).equals("")) {
			radioValue = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			generalMap.put("radioValue", radioValue);
		}
		System.out.println("generalMap controller===>" + generalMap);
		map = accountHandlerService.searchAccountSubGroup(generalMap);
		String jsp = "accountSubGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("accountGroupName", accountGroupName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addAccountSubGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int subGroupCode = 0;
		HttpSession session = request.getSession();

		if (request.getParameter(CODE) != null
				&& !request.getParameter(CODE).equals("")) {
			subGroupCode = Integer.parseInt(request.getParameter(CODE));
		}

		String subgroupName = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !request.getParameter(SEARCH_NAME).equals("")) {
			subgroupName = request.getParameter(SEARCH_NAME);
		}
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");

		}
		int accountGroupId = 0;
		if (request.getParameter(DISTRICT_ID) != null) {
			accountGroupId = Integer
					.parseInt(request.getParameter(DISTRICT_ID));
		}
		FaMasAccountSubGroup fasg = new FaMasAccountSubGroup();

		FaMasAccountGroup fag = new FaMasAccountGroup();
		fag.setId(accountGroupId);
		fasg.setAccountGroup(fag);
		
		if(request.getParameter("subGroupType") != null){
			fasg.setFlag(request.getParameter("subGroupType"));
		}

		fasg.setAccountSubGroupCode(subGroupCode);
		fasg.setAccountSubGroupName(subgroupName);
		fasg.setClBalanceCr(new BigDecimal(0));
		fasg.setClBalanceDr(new BigDecimal(0));

		MasStoreFinancial mfy = new MasStoreFinancial();
		mfy.setId(fYear);
		fasg.setFYear(mfy);

		Users users = new Users();
		int changedBy = 0;
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
		}
		Users user = new Users();
		user.setId(changedBy);
		fasg.setLastChgBy(user);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		fasg.setLastChgDate(HMSUtil.convertStringTypeDateToDateType(date));
		fasg.setLastChgTime(time);

		fasg.setOpBalanceDr(new BigDecimal(0));
		fasg.setOpBalanceCr(new BigDecimal(0));
		fasg.setStatus("y");
		fasg.setYtdAmountCr(new BigDecimal(0));
		fasg.setYtdAmountDr(new BigDecimal(0));

		generalMap.put("fasg", fasg);
		generalMap.put("fYear", fYear);
		map = accountHandlerService.addAccountSubGroupNew(generalMap);

		String jsp = "accountSubGroupNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAccountSubGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String accountSubGroupCode = "";
		String name = "";
		int accountGroupId = 0;
		int accountSubGroupId = 0;
		String changedBy = "";
		String title = "";
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		String message = "";
		String jsp = "";
		String url = "";
		String subGroupType = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		try {
			if (request.getParameter(DISTRICT_ID) != null
					&& !(request.getParameter(DISTRICT_ID).equals(""))) {
				accountGroupId = Integer.parseInt(request
						.getParameter(DISTRICT_ID));
			}
			if(request.getParameter("subGroupType") != null){
				subGroupType= request.getParameter("subGroupType");
			}

			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				accountSubGroupId = Integer.parseInt(request
						.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				accountSubGroupCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
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

			generalMap.put("id", accountSubGroupId);
			generalMap.put("blockCode", accountSubGroupCode);
			generalMap.put("name", name);
			generalMap.put("districtId", accountGroupId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			generalMap.put("subGroupType", subGroupType);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = accountHandlerService
					.updateAccountSubGroupNew(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant be updated !!";
		}

		try {
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}

			map = accountHandlerService.showAccountSubGroupNew(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "accountSubGroupNew";
		title = "Edit Block";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForGeneralMasters(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapResponse = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
		int storeId = 0;
		String hospitalName = "";
		String qry = "";
		if (session.getAttribute("storeId") != null) {
			storeId = (Integer) session.getAttribute("storeId");
			mapForDs.put("storeId", storeId);
			mapResponse = accountHandlerService.getHospitalName(mapForDs);
		}
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
		}

		String jasper = null;
		if (request.getParameter(JASPER_FILE_NAME) != null) {
			jasper = request.getParameter(JASPER_FILE_NAME);
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("qry", qry);
		parameters.put("hospitalName", hospitalName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/reports/"));
		Map<String, Object> connectionMap = accountHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport(jasper, parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView deleteAccountSubGroupNew(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String accountSubGroupCode = "";
		String name = "";
		int accountGroupId = 0;
		int accountSubGroupId = 0;
		String changedBy = "";
		String title = "";
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		String message = "";
		String jsp = "";
		String url = "";

		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");

		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			accountSubGroupId = Integer.parseInt(request
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

		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = accountHandlerService.deleteAccountSubGroupNew(
				accountSubGroupId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/generalMaster?method=showBlockJsp";

		try {
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}

			map = accountHandlerService.showAccountSubGroupNew(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "accountMaster";
		title = "Edit Block";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showAccountMasterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			generalMap.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("locationId", locationId);
		}
		
		
		int accountSubGroupId = 0;
		if (request.getParameter("accountSubGroupId") != null) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter("accountSubGroupId"));
			generalMap.put("accountSubGroupId", accountSubGroupId);
		}
		map = accountHandlerService.showAccountMasterNew(generalMap);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String accountSubGroupCode = "";
		String name = "";
		int accountGroupId = 0;
		int accountSubGroupId = 0;
		int accountId = 0;
		String changedBy = "";
		String title = "";
		Date changedDate = null;
		String changedTime = "";
		int userId = 0;
		String message = "";
		String jsp = "";
		String url = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = (Integer) session.getAttribute("userId");
		try {
			if (request.getParameter("subGroupName") != null
					&& !(request.getParameter("subGroupName").equals(""))) {
				accountSubGroupId = Integer.parseInt(request
						.getParameter("subGroupName"));
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				accountId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter(CODE) != null
					&& !(request.getParameter(CODE).equals(""))) {
				accountSubGroupCode = request.getParameter(CODE);
			}
			if (request.getParameter(SEARCH_NAME) != null
					&& !(request.getParameter(SEARCH_NAME).equals(""))) {
				name = request.getParameter(SEARCH_NAME);
			}
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				changedBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (request.getParameter(DISTRICT_ID) != null
					&& !request.getParameter(DISTRICT_ID).equals("")) {
				accountGroupId = Integer.parseInt(request
						.getParameter(DISTRICT_ID));
			}
			if (request.getParameter("scheduleDr") != null && !request.getParameter("scheduleDr").equals(0)) {
				int scheduleDrId =  Integer.parseInt(request.getParameter("scheduleDr"));
				generalMap.put("scheduleDrId", scheduleDrId);
			}
			if (request.getParameter("scheduleCr") != null && !request.getParameter("scheduleCr").equals(0)) {
				int scheduleCrId =  Integer.parseInt(request.getParameter("scheduleCr"));
				generalMap.put("scheduleCrId", scheduleCrId);
			}
			String[] strHospitalType = request.getParameterValues("hospitalTypeId");
			List hospitalTypeAccountList = new ArrayList();
			if (strHospitalType != null) {
				for (int j = 0; j < strHospitalType.length; j++) {
					String hospitalTypeId =(strHospitalType[j]);
					generalMap.put("hospitalTypeId", hospitalTypeId);
					hospitalTypeAccountList.add(hospitalTypeId);
					generalMap.put("hospitalTypeAccountList", hospitalTypeAccountList);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		changedDate = new Date();
		try {
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("id", accountId);
			generalMap.put("blockCode", accountSubGroupCode);
			generalMap.put("name", name);
			generalMap.put("accountGroupId", accountGroupId);
			generalMap.put("accountSubGroupId", accountSubGroupId);
			generalMap.put("userId", userId);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean dataUpdated = false;
		try {
			dataUpdated = accountHandlerService.editAccountMaster(generalMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant be updated !!";
		}

		try {
			int fYear = 0;
			if (session.getAttribute("financialYear") != null) {
				fYear = (Integer) session.getAttribute("financialYear");
				generalMap.put("fYear", fYear);
			}

			map = accountHandlerService.showAccountMasterNew(generalMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "accountMaster";
		title = "Edit Block";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		FaMasAccount faMasAccount = new FaMasAccount();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		/*
		 * int locationId = 0; if (session.getAttribute("locationId") != null) {
		 * locationId = (Integer) session.getAttribute("locationId");
		 * MasHospital masHospital = new MasHospital();
		 * masHospital.setId(locationId); faMasAccount.setHospital(masHospital);
		 * generalMap.put("locationId", locationId); }
		 */
		Integer accountCode = 0;
		if (request.getParameter(CODE) != null) {
			accountCode = Integer.parseInt(request.getParameter(CODE));
			faMasAccount.setAccCode(accountCode);
		}
		String accountName = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			accountName = request.getParameter(SEARCH_NAME);
			faMasAccount.setAccDesc(accountName);
		}

		int fYear = 1;
		/*
		 * if (session.getAttribute("financialYear") != null) { fYear =
		 * (Integer) session.getAttribute("financialYear");
		 * 
		 * }
		 */
		MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
		masStoreFinancial.setId(fYear);
		faMasAccount.setFYear(masStoreFinancial);
		generalMap.put("fYear", fYear);
		if (request.getParameter("parentStatus") != null) {
			faMasAccount.setParentStatus("y");
		} else {
			faMasAccount.setParentStatus("n");
		}
		if (request.getParameter("subLedgerStatus") != null) {
			faMasAccount.setSubLedger("y");
		} else {
			faMasAccount.setSubLedger("n");
		}
		if (request.getParameter("bankId") != null
				&& !(request.getParameter("bankId").equals("0"))) {
			int bankId = Integer.parseInt(request.getParameter("bankId"));
			MasBankMaster masBankMaster = new MasBankMaster();
			masBankMaster.setId(bankId);
			faMasAccount.setBank(masBankMaster);
		}
		int accountgroupId = 0;
		if (request.getParameter(DISTRICT_ID) != null
				&& !(request.getParameter(DISTRICT_ID).equals("0"))) {
			accountgroupId = Integer
					.parseInt(request.getParameter(DISTRICT_ID));
			generalMap.put("accountgroupId", accountgroupId);
		}
		int accountSubGroupId = 0;
		if (request.getParameter("subGroupName") != null
				&& !(request.getParameter("subGroupName").equals("0"))) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter("subGroupName"));
			FaMasAccountSubGroup faMasAccountSubGroup = new FaMasAccountSubGroup();
			faMasAccountSubGroup.setId(accountSubGroupId);
			faMasAccount.setAccountSubGroup(faMasAccountSubGroup);
			generalMap.put("accountSubGroupId", accountSubGroupId);

		}
		String accountRight = "";

		if (request.getParameter("accountRight") != null
				&& !(request.getParameter("accountRight").equals(""))) {
			accountRight = request.getParameter("accountRight");
			faMasAccount.setAccountRight(accountRight);
			generalMap.put("accountRight", accountRight);

		}
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null
				&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			FaMasAccount famasAccount2 = new FaMasAccount();
			famasAccount2.setId(accountId);
			faMasAccount.setParent(famasAccount2);
		}
		String accountTypeA = "";
		if (request.getParameter("accountTypeA") != null
				&& !request.getParameter("accountTypeA").equals("")) {
			accountTypeA = request.getParameter("accountTypeA");
		}
		String[] strHospitalType = request.getParameterValues("hospitalTypeId");
		List hospitalTypeAccountList = new ArrayList();
		if (strHospitalType != null) {
			for (int j = 0; j < strHospitalType.length; j++) {
				String hospitalTypeId =(strHospitalType[j]);
				generalMap.put("hospitalTypeId", hospitalTypeId);
				hospitalTypeAccountList.add(hospitalTypeId);
			}
		}
		

		/*
		 * if (accountTypeA.equals("Dr")) { BigDecimal opDrBalance = new
		 * BigDecimal("0"); if (request.getParameter("openingBalance") != null
		 * && !request.getParameter("openingBalance").equals("")) { opDrBalance
		 * = new BigDecimal( request.getParameter("openingBalance"));
		 * faMasAccount.setOpBalanceDr(opDrBalance);
		 * faMasAccount.setClBalanceDr(opDrBalance);
		 * generalMap.put("opDrBalance", opDrBalance); } } else if
		 * (accountTypeA.equals("Cr")) { BigDecimal opCrBalance = new
		 * BigDecimal("0"); if (request.getParameter("openingBalance") != null
		 * && !request.getParameter("openingBalance").equals("")) { opCrBalance
		 * = new BigDecimal( request.getParameter("openingBalance"));
		 * faMasAccount.setOpBalanceCr(opCrBalance);
		 * faMasAccount.setClBalanceCr(opCrBalance);
		 * generalMap.put("opCrBalance", opCrBalance); }
		 * 
		 * }
		 */

		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			Users user = new Users();
			user.setId(changedBy);
			faMasAccount.setLastChgBy(user);
		}

		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			faMasAccount.setLastChgDate(currentDate);
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			faMasAccount.setLastChgTime(currentTime);
		}
		if (request.getParameter("scheduleDr") != null && !request.getParameter("scheduleDr").equals("0")) {
			MasAccountSchedule scheduleDr = new MasAccountSchedule();
			scheduleDr.setId(Integer.parseInt(request.getParameter("scheduleDr")));
			faMasAccount.setScheduleDr(scheduleDr);
		}
		if (request.getParameter("scheduleCr") != null && !request.getParameter("scheduleCr").equals("0")) {
			MasAccountSchedule scheduleCr = new MasAccountSchedule();
			scheduleCr.setId(Integer.parseInt(request.getParameter("scheduleCr")));
			faMasAccount.setScheduleCr(scheduleCr);
		}
		faMasAccount.setStatus("y");
		faMasAccount.setOpBalanceCr(new BigDecimal(0));
		faMasAccount.setOpBalanceDr(new BigDecimal(0));
		faMasAccount.setYtdAmountCr(new BigDecimal(0));
		faMasAccount.setYtdAmountDr(new BigDecimal(0));
		faMasAccount.setClBalanceCr(new BigDecimal(0));
		faMasAccount.setClBalanceDr(new BigDecimal(0));
		generalMap.put("faMasAccount", faMasAccount);
		generalMap.put("box", box);
		generalMap.put("hospitalTypeAccountList", hospitalTypeAccountList);
		generalMap.put("accountId", accountId);

		map = accountHandlerService.addAccountMaster(generalMap);
		/* map = accountHandlerService.showAccountMasterNew(generalMap); */
		List<FaMasAccountSubGroup> faMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		if (map.get("faMasAccountSubGroupList") != null) {
			faMasAccountSubGroupList = (List<FaMasAccountSubGroup>) map
					.get("faMasAccountSubGroupList");
		}
		List<FaMasAccountSubGroup> gridMasAccountSubGroupList = new ArrayList<FaMasAccountSubGroup>();
		if (map.get("gridMasAccountSubGroupList") != null) {
			gridMasAccountSubGroupList = (ArrayList) map
					.get("gridMasAccountSubGroupList");
		}
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("faMasAccountSubGroupList", faMasAccountSubGroupList);
		map.put("gridMasAccountSubGroupList", gridMasAccountSubGroupList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountMaster(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}
		String accountName = "";
		if (request.getParameter(SEARCH_FIELD) != null
				&& !request.getParameter(SEARCH_FIELD).equals("")) {
			accountName = request.getParameter(SEARCH_FIELD);
			box.put("accountGroupName", accountName);
		}
		int radioValue = 0;
		if (request.getParameter(SELECTED_RADIO) != null
				&& !request.getParameter(SELECTED_RADIO).equals("")) {
			radioValue = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			box.put("radioValue", radioValue);
		}

		System.out.println("accountName------>>" + accountName);
		System.out.println("radioValue------>>" + radioValue);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.searchAccountMaster(box);
		String jsp = "accountMaster";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountSubLedgerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<Object[]> growerList = new ArrayList<Object[]>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			detailsMap.put("locationId",locationId);
		}
		Box box = HMSUtil.getBox(request);

		box.put("locationId", locationId);
		// growerList = marketingHandlerService.getGrowerList(box);
		detailsMap.put("fYear", fYear);
		detailsMap.put("locationId", locationId);
		map = accountHandlerService.showAccountSubLedgerJsp(detailsMap);
		String jsp = "fa_accountSubLedgerNew.jsp";
		map.put("contentJsp", jsp);
		map.put("growerList", growerList);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		FaMasSubLed faMasSubLed = new FaMasSubLed();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String subLedgerCode = "";
		/*
		 * if (request.getParameter("subLedgerType") != null &&
		 * !request.getParameter("subLedgerType").equals("")) {
		 * faMasSubLed.setSubLedType(request.getParameter("subLedgerType")); if
		 * (request.getParameter("centreName") != null &&
		 * !request.getParameter("centreName").equals("0")) { MasHospital
		 * masHospital=new MasHospital();
		 * masHospital.setId(Integer.parseInt(request
		 * .getParameter("centreName"))); faMasSubLed.setCentre(masHospital); }
		 * 
		 * }
		 */if (session.getAttribute("hospitalId") != null
				&& !session.getAttribute("hospitalId").equals("0")) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(Integer.parseInt(""
					+ session.getAttribute("hospitalId")));
			faMasSubLed.setCentre(masHospital);
		}
		if (request.getParameter(CODE) != null) {
			subLedgerCode = request.getParameter(CODE);
			faMasSubLed.setSubLedCode(subLedgerCode);
		}

		String subLedgerName = "";
		System.out.println("subLed Name------>>>"+request.getParameter(SEARCH_NAME));
		if (request.getParameter(SEARCH_NAME) != null) {
			subLedgerName = request.getParameter(SEARCH_NAME);
			faMasSubLed.setSubLedDesc(request.getParameter(SEARCH_NAME));
		}
		
		if(request.getParameter(EMPLOYEE_ID)!=null && !request.getParameter(EMPLOYEE_ID).equals("0")){
			MasEmployee me=new MasEmployee();
			me.setId(Integer.parseInt(request.getParameter(EMPLOYEE_ID)));
			faMasSubLed.setEmployee(me);
			String EmpName=accountHandlerService.getEmployeeName(Integer.parseInt(request.getParameter(EMPLOYEE_ID)));
			faMasSubLed.setSubLedDesc(EmpName);
		}

	
	if(request.getParameter("fname11")!=null && !request.getParameter("fname11").equals("0")){
		MasEmployee me=new MasEmployee();
		me.setId(Integer.parseInt(request.getParameter("fname11")));
		faMasSubLed.setEmployee(me);
	}
		int accountgroupId = 0;
		if (request.getParameter(ACCOUNT_GROUP_ID) != null
				&& !(request.getParameter(ACCOUNT_GROUP_ID).equals("0"))) {
			accountgroupId = Integer.parseInt(request
					.getParameter(ACCOUNT_GROUP_ID));
			generalMap.put("accountgroupId", accountgroupId);
		}
		int accountSubGroupId = 0;
		if (request.getParameter(ACCOUNT_SUB_GROUP_ID) != null
				&& !(request.getParameter(ACCOUNT_SUB_GROUP_ID).equals("0"))) {
			accountSubGroupId = Integer.parseInt(request
					.getParameter(ACCOUNT_SUB_GROUP_ID));
			generalMap.put("accountSubGroupId", accountSubGroupId);

		}
		System.out.println("account Id ----  >>"+request.getParameter(ACCOUNT_ID));
		int accountMasterId = 0;
		if (request.getParameter(ACCOUNT_ID) != null
				&& !(request.getParameter(ACCOUNT_ID).equals("0"))) {
			accountMasterId = Integer
					.parseInt(request.getParameter(ACCOUNT_ID));
			FaMasAccount faMasAccount = new FaMasAccount();
			faMasAccount.setId(Integer.parseInt(request.getParameter(ACCOUNT_ID)));
			faMasSubLed.setAccount(faMasAccount);
			generalMap.put("accountMasterId", accountMasterId);
		}

		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(locationId);
			faMasSubLed.setHospital(masHospital);
			generalMap.put("locationId", locationId);
		}
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			MasStoreFinancial masStoreFinancial = new MasStoreFinancial();
			masStoreFinancial.setId(fYear);
			faMasSubLed.setFYear(masStoreFinancial);
			generalMap.put("fYear", fYear);
		}
		String accountTypeA = "";
		if (request.getParameter("accountTypeA") != null
				&& !request.getParameter("accountTypeA").equals("")) {
			accountTypeA = request.getParameter("accountTypeA");
		}

		if (accountTypeA.equals("Dr")) {
			BigDecimal opDrBalance = new BigDecimal("0");
			if (request.getParameter("openingBalance") != null
					&& !request.getParameter("openingBalance").equals("")) {
				opDrBalance = new BigDecimal(
						request.getParameter("openingBalance"));
				faMasSubLed.setOpBalanceDr(opDrBalance);
				faMasSubLed.setClBalanceDr(opDrBalance);
				generalMap.put("opDrBalance", opDrBalance);
			}
		} else if (accountTypeA.equals("Cr")) {
			BigDecimal opCrBalance = new BigDecimal("0");
			if (request.getParameter("openingBalance") != null
					&& !request.getParameter("openingBalance").equals("")) {
				opCrBalance = new BigDecimal(
						request.getParameter("openingBalance"));
				faMasSubLed.setOpBalanceCr(opCrBalance);
				faMasSubLed.setClBalanceCr(opCrBalance);
				generalMap.put("opCrBalance", opCrBalance);
			}

		}

		int changedBy = 0;
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			changedBy = users.getId();
			Users users2 = new Users();
			users2.setId(changedBy);
			faMasSubLed.setLastChgBy(users2);
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		faMasSubLed.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		faMasSubLed.setLastChgTime(time);

		faMasSubLed.setStatus("y");
		generalMap.put("faMasSubLed", faMasSubLed);
		//box.put("", value)
		generalMap.put("box", box);
		map = accountHandlerService.addAccountSubLedger(generalMap);
		String jsp = "fa_accountSubLedgerNew.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int accountSubledgerId = 0;
		if (request.getParameter("selecetedRecord") != null)
			accountSubledgerId = Integer.parseInt(request
					.getParameter("selecetedRecord"));
		box.put("accountSubledgerId", accountSubledgerId);
	
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}

		map = accountHandlerService.editAccountSubLedger(box);
		String jsp = "fa_accountSubLedgerNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear");
			box.put("fYear", financialYearId);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.deleteAccountSubLedger(box);
		String jsp = "fa_accountSubLedgerNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchAccountSubLedger(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			generalMap.put("fYear", fYear);
		}
		String accountGroupName = "";
		if (request.getParameter(SEARCH_FIELD) != null
				&& !request.getParameter(SEARCH_FIELD).equals("")) {
			accountGroupName = request.getParameter(SEARCH_FIELD);
			generalMap.put("accountGroupName", accountGroupName);
		}
		Box box = HMSUtil.getBox(request);
		int radioValue = 0;
		if (request.getParameter(SELECTED_RADIO) != null
				&& !request.getParameter(SELECTED_RADIO).equals("")) {
			radioValue = Integer.parseInt(request.getParameter(SELECTED_RADIO));
			box.put("radioValue", radioValue);
		}
		System.out.println("radioValue--->" + radioValue);
		System.out.println("accountGroupName--->"
				+ request.getParameter(SEARCH_FIELD));
		map = accountHandlerService.searchAccountSubLedger(box);
		String jsp = "fa_accountSubLedgerNew";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showJournalVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=(Integer)session.getAttribute("authLevel");
		}
		map = accountHandlerService.showJournalVoucherJsp(box);
		String jsp = FA_JOURNAL_VOUCHER_JSP + ".jsp";
		map.put("contentJsp", jsp);
		map.put("authLevel",authLevel);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getAccountCodeForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		/*
		 * int financialYearId = 0; if(request.getParameter("financialYearId")!=
		 * null){ financialYearId
		 * =Integer.parseInt(request.getParameter("financialYearId")); }
		 * parameterMap.put("financialYearId", financialYearId);
		 */
		HttpSession session = request.getSession();
		int locationId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			locationId = (Integer) session.getAttribute(HOSPITAL_ID);
			parameterMap.put("locationId", locationId);
		}
		int hospitalTypeId=0;
		if(session.getAttribute("hospitalTypeId")!=null ){
			hospitalTypeId=(Integer)session.getAttribute("hospitalTypeId");
		}
	
		String fieldName = "";
		String accountNameStr = "";
		int scheme=0;
		if(request.getParameter("schemeId")!=null && !request.getParameter("schemeId").equals("0")){
			scheme=Integer.parseInt(request.getParameter("schemeId"));
		}
		
		
		if (request.getParameter("requiredField") != null) {
			fieldName = request.getParameter("requiredField");
		}
		if (request.getParameter(fieldName) != null) {
			accountNameStr = request.getParameter(fieldName);
		}
		if (request.getParameter("amtType") != null) {
			String amtType = request.getParameter("amtType");
			parameterMap.put("amtType", amtType);
		}

		if (request.getParameter("salesVoucherType") != null) {
			String salesVoucherType = request.getParameter("salesVoucherType");
			parameterMap.put("salesVoucherType", salesVoucherType);
		}
		parameterMap.put("accountNameStr", accountNameStr);
		parameterMap.put("scheme",scheme);
		parameterMap.put("hospitalTypeId", hospitalTypeId);
		System.out.println("scheme===>>"+scheme);
		map = accountHandlerService.getAccountCodeForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForCashVoucher";
		// map.put("financialYearId", financialYearId);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getSubLedgerForAccount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		parameterMap.put("fYear", fYear);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		parameterMap.put("locationId", locationId);

		// -----------commented by anamika on 20th august----------
		/*
		 * String flagForSL = ""; if(request.getParameter("flagForSL11")!=
		 * null){ flagForSL = request.getParameter("flagForSL11"); }
		 */
		String accName = "";
		if (request.getParameter("accName") != null) {
			accName = request.getParameter("accName");
		}

		Integer index1 = 0;
		index1 = accName.lastIndexOf("[") + 1;

		int index2 = accName.lastIndexOf("]");
		String accountName = accName.substring(index1, index2);

		parameterMap.put("accountName", accountName);
		map = accountHandlerService.getSubLedgerForAccount(parameterMap);
		map.put("rowVal", request.getParameter("rowVal"));
		// map.put("flagForSL", flagForSL);
		// map.put("financialYearId", financialYearId);
		String jsp = "";
		jsp = "responseForSubLedger";

		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getSubLedgerForAccount1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		parameterMap.put("fYear", fYear);
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		parameterMap.put("locationId", locationId);

		// -----------commented by anamika on 20th august----------
		/*
		 * String flagForSL = ""; if(request.getParameter("flagForSL11")!=
		 * null){ flagForSL = request.getParameter("flagForSL11"); }
		 */
		String accName = "";
		if (request.getParameter("accName") != null) {
			accName = request.getParameter("accName");
		}

	/*	Integer index1 = 0;
		index1 = accName.lastIndexOf("[") + 1;

		int index2 = accName.lastIndexOf("]");
		String accountName = accName.substring(index1, index2);*/

		parameterMap.put("accountName", accName);
		map = accountHandlerService.getSubLedgerForAccount1(parameterMap);
		map.put("rowVal", request.getParameter("rowVal"));
		// map.put("flagForSL", flagForSL);
		// map.put("financialYearId", financialYearId);
		String jsp = "";
		jsp = "responseForSubLedgerWardWise";

		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView getAccountNarrationForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();

		String fieldName = "";
		String accountNarration = "";
		if (request.getParameter("requiredField") != null) {
			fieldName = request.getParameter("requiredField");
		}
		if (request.getParameter(fieldName) != null) {
			accountNarration = request.getParameter(fieldName);
		}

		parameterMap.put("accountNarration", accountNarration);
		map = accountHandlerService
				.getAccountNarrationForAutoComplete(parameterMap);
		String jsp = "";
		jsp = "responseForAccountNarration";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitJournalVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitJournalVoucher(box);
		String voucherNo = "";
		if (map.get("voucherNo1") != null) {
			voucherNo = (String) map.get("voucherNo1");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "JV";
		if (saved) {
			message = "Journal Voucher Saved Successfully with Voucher No="
					+ voucherType1 + "/" + voucherNo
					+ ".Do You want to  Print Report";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/hms/hms/account?method=showJournalVoucher";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPaymentVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.showPaymentVoucherJsp(box);
		String jsp = "fa_payment_voucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPaymentVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fyear", fyear);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitPaymentVoucher(box);
		String voucherNo = "";
		if (map.get("voucherNo") != null) {
			voucherNo = (String) map.get("voucherNo");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "PV";
		if (saved) {
			message = "Payment Voucher Saved Successfully with voucher No="
					+ voucherType1 + "/" + voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		// map = accountHandlerService.showPaymentVoucherJsp(box);
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		map.put("fyear", fyear);
		map.put("accountId", accountId);
		String url = "/hms/hms/account?method=showPaymentVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void showAccountCrBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fyear", fyear);
		}

		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}

		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}

		map = accountHandlerService.showAccountBalance(box);
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		if (map.get("accountList") != null) {
			accountList = (List) map.get("accountList");
		}
		BigDecimal closingBalanceCr = new BigDecimal(0);
		BigDecimal closingBalanceDr = new BigDecimal(0);
		int groupId = 0;
		int subGroupId = 0;
		if (accountList.size() > 0) {
			for (AccountMainTransac faMasAccount : accountList) {
				if (faMasAccount.getClBalanceCr() != null
						&& faMasAccount.getClBalanceCr().compareTo(new BigDecimal(0)) != 0) {
					closingBalanceCr = faMasAccount.getClBalanceCr();
				} else {
					closingBalanceDr = faMasAccount.getClBalanceDr();
				}
				groupId = faMasAccount.getAccount().getAccountSubGroup()
						.getAccountGroup().getId();
				subGroupId = faMasAccount.getAccount().getAccountSubGroup()
						.getId();
			}
		}
		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (closingBalanceDr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceDr + " Dr </balance>");
			} else {
				sb.append("<balance>" + closingBalanceCr + " Cr </balance>");
			}
			sb.append("<groupId>" + groupId + " </groupId>");
			sb.append("<subGroupId>" + subGroupId + " </subGroupId>");
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items1>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items1>");
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public ModelAndView showSalesVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("financialYear1") != null) {
			int fyear = (Integer) session.getAttribute("financialYear1");
			generalMap.put("fyear", fyear);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			generalMap.put("fYearDesc", fYearDesc);
		}
		String unitType = "";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
			generalMap.put("unitType", unitType);
		}
		map = accountHandlerService.showSalesVoucherJsp(generalMap);
		String jsp = "fa_salesVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSalesVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitSalesVoucher(box);
		String voucherNo = "";
		if (map.get("voucherNo1") != null) {
			voucherNo = (String) map.get("voucherNo1");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "SV";
		if (saved) {
			message = "Sales Voucher Saved Successfully with Voucher No="
					+ voucherType1 + "/" + voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/hms/hms/account?method=showSalesVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printVoucherReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		String voucherType = "";
		if (request.getParameter("voucherType") != null) {
			voucherType = request.getParameter("voucherType");
		}
		System.out.println("voucherType==" + voucherType);
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		System.out.println("locationId==" + locationId);
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
		}
		Date voucherDate = new Date();
		if (request.getParameter("voucherDate") != null) {
			voucherDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("voucherDate"));
		}
		int vhId = 0;
		if (request.getParameter("vhId") != null) {
			vhId = Integer.parseInt(request.getParameter("vhId"));
		}
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("voucherType", voucherType);
		parameters.put("hospital_id", locationId);
		parameters.put("fYearId", fYear);
		parameters.put("voucherDate", voucherDate);
		parameters.put("vhId", vhId);

		String userHome = getServletContext().getRealPath("");
		System.out.println("userHome=" + userHome);
		String imagePath = userHome + "/jsp/images/logo.jpg";
		parameters.put("path", imagePath);
System.out.println("voucherType------>>"+voucherType);
System.out.println("parameters------>>"+parameters);
		if (voucherType.equalsIgnoreCase("JV")) {
			HMSUtil.generateReport("journalVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("PRV")) {
			HMSUtil.generateReport("purchaseVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("RV")) {

			int accountId = 0;
			if (request.getParameter("accountId") != null) {
				accountId = Integer.parseInt(request.getParameter("accountId"));
			}
			parameters.put("accId", accountId);
			HMSUtil.generateReport("receiptVoucherReportId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("SV")) {
			HMSUtil.generateReport("salesVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("SR")) {
			HMSUtil.generateReport("salesReturnVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("PV")) {
			int accountId = 0;
			if (request.getParameter("accountId") != null) {
				accountId = Integer.parseInt(request.getParameter("accountId"));
			}
			parameters.put("accId", accountId);
			HMSUtil.generateReport("paymentVoucherId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (voucherType.equalsIgnoreCase("PR")) {
			HMSUtil.generateReport("purchaseReturnId", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;

	}

	public ModelAndView showSalesReturnVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			generalMap.put("fYearDesc", fYearDesc);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			generalMap.put("fYear", fYear);
		}
		String unitType = "";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
			generalMap.put("unitType", unitType);
		}
		map = accountHandlerService.showSalesReturnVoucherJsp(generalMap);
		String jsp = "fa_sales_return_voucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitSalesReturnVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitSalesReturnVoucher(box);
		String voucherNo = "";
		if (map.get("voucherNo1") != null) {
			voucherNo = (String) map.get("voucherNo1");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}

		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "SR";
		if (saved) {
			message = "Sales return Voucher Saved Successfully with Voucher No="
					+ voucherType1
					+ "/"
					+ voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/hms/hms/account?method=showSalesReturnVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPurchaseVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			generalMap.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			generalMap.put("fYearDesc", fYearDesc);
		}

		String unitType = "";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
			generalMap.put("unitType", unitType);
		}
		map = accountHandlerService.showPurchaseVoucherJsp(generalMap);
		String jsp = "fa_purchase_voucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPurchaseVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitPurchaseVoucher(box);
		int voucherNo = 0;
		if (map.get("voucherNo") != null) {
			voucherNo = (Integer) map.get("voucherNo");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "PRV";
		if (saved) {
			message = "Purchase Voucher Saved Successfully with Voucher No="
					+ voucherType1 + "/" + voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/erp/erp/account?method=showPurchaseVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPurchaseReturnVoucherJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			generalMap.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			generalMap.put("hospitalId", hospitalId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			generalMap.put("fYearDesc", fYearDesc);
		}

		String unitType = "";
		if (session.getAttribute("unitType") != null) {
			unitType = (String) session.getAttribute("unitType");
			generalMap.put("unitType", unitType);
		}
		map = accountHandlerService.showPurchaseReturnVoucherJsp(generalMap);
		String jsp = "fa_purchase_return_voucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPurchaseReturnVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitPurchaseReturnVoucher(box);
		int voucherNo = 0;
		if (map.get("voucherNo") != null) {
			voucherNo = (Integer) map.get("voucherNo");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "PR";
		if (saved) {
			message = "Purchase return Voucher Saved Successfully with Voucher No="
					+ voucherType1
					+ "/"
					+ voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/erp/erp/account?method=showPurchaseReturnVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCashVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.showCashVoucherJsp(box);

		String jsp = FA_CASH_VOUCHER;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitReceiptVoucher(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		/*
		 * if(session.getAttribute("branchId")!= null){ int branchId =
		 * (Integer)session.getAttribute("branchId"); box.put("branchId",
		 * branchId); }
		 */
		/*
		 * int voucherNo = 0; if(request.getParameter(VOUCHER_NO)!= null){
		 * voucherNo = Integer.parseInt(request.getParameter(VOUCHER_NO)); }
		 */
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}
		box.put("authLevel",authLevel);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}

		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.submitReceiptVoucher(box);
		String voucherNo = "";
		if (map.get("voucherNo") != null) {
			voucherNo = (String) map.get("voucherNo");
		}
		String voucherType = "";
		if (map.get("voucherType") != null) {
			voucherType = (String) map.get("voucherType");
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		String voucherType1 = "RV";
		if (saved) {
			message = "Reciept Voucher Saved Successfully with voucher No="
					+ voucherType1 + "/" + voucherNo
					+ ".Do You want to  Print Report?";
		} else {
			message = "Try Again!";
		}
		// map = accountHandlerService.showCashVoucherJsp(box);
		map.put("message", message);
		map.put("accountId", accountId);

		map.put("voucherType1", voucherType1);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		map.put("fyear", fyear);
		String url = "/erp/erp/account?method=showCashVoucherJsp";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showJournalVoucherJsp(box);
		String jsp = "fa_AcountOpeningBalance" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getSubLedgerForAccountOP(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		parameterMap.put("fYear", fYear);
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		parameterMap.put("locationId", locationId);

		// -----------commented by anamika on 20th august----------
		/*
		 * String flagForSL = ""; if(request.getParameter("flagForSL11")!=
		 * null){ flagForSL = request.getParameter("flagForSL11"); }
		 */
		String accName = "";
		if (request.getParameter("accName") != null) {
			accName = request.getParameter("accName");
		}

		Integer index1 = 0;
		index1 = accName.lastIndexOf("[") + 1;

		int index2 = accName.lastIndexOf("]");
		String accountName = accName.substring(index1, index2);

		parameterMap.put("accountName", accountName);
		map = accountHandlerService.getSubLedgerForAccount(parameterMap);
		map.put("rowVal", request.getParameter("rowVal"));
		// map.put("flagForSL", flagForSL);
		// map.put("financialYearId", financialYearId);
		String jsp = "";
		jsp = "responseForSubLedgerOP";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOpeningBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("users") != null) {
			Users users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fyear);
		}
		int authLevel=0;
		if(session.getAttribute("authLevel")!=null){
			authLevel=Integer.parseInt(""+session.getAttribute("authLevel"));
		}

		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		map = accountHandlerService.submitOpeningBalance(box);
		String voucherNo = "";
		if (map.get("voucherNo1") != null) {
			voucherNo = (String) map.get("voucherNo1");
		}
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Opening Balanace Saved Successfully with Voucher No=OP/"
					+ voucherNo + ".Do You want to  Print Report";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String voucherType = "JV";
		map.put("voucherType1", voucherType);
		if (map.get("voucherNo") != null) {
			map.put("voucherNo", map.get("voucherNo"));
		}
		map.put("fyear", fyear);
		map.put("voucherDate", box.getString(VOUCHER_DATE));
		String url = "/erp/erp/account?method=showJournalVoucher";
		map.put("url", url);
		String jsp = "fa_msgForVoucher" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBankReconciliationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		map = accountHandlerService.showBankReconciliationJsp(fYear);
		String jsp = FA_BANK_RECONCILIATION_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getBankAccountDetailsForReconciliation(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		int locationId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
		}
		box.put("fYear", fYear);
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		box.put("locationId", locationId);
		map = accountHandlerService.getBankAccountDetailsForReconciliation(box);
		String jsp = "responseForBankReconciliationDetails";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView saveBankReconciliationDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		int locationId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
		}
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		box.put("fYear", fYear);
		box.put("locationId", locationId);
		boolean saved = false;
		saved = accountHandlerService.saveBankReconciliationDetails(box);
		String message = "";
		if (saved) {
			message = "Reconciliation Details Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map = accountHandlerService.showBankReconciliationJsp(fYear);
		map.put("message", message);
		String jsp = FA_BANK_RECONCILIATION_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showLedgerJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		map = accountHandlerService.showLedgerJsp(box);
		String jsp = "ledgerBook.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView displayLedgerBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayLedgerBook(box);
		String jsp = "ledger.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountName", box.getString("accountName"));
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView checkForAccountType(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int accountId = 0;
		if (request.getParameter(ACCOUNT_ID) != null) {
			accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
		}
		System.out.println("accountId====" + accountId);
		int accountSubGroupId = 0;
		accountSubGroupId = accountHandlerService.getAccountSubGroup(accountId);
		String flag=accountHandlerService.getAccountSubGroupFlag(accountId);
		map.put("accountSubGroupId", accountSubGroupId);
		map.put("flag", flag);
		return new ModelAndView("responseForAccountSubGroupDetails", "map", map);
	}

	public ModelAndView showIpSalesVoucherMappingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showIpSalesVoucherMappingJsp(box);

		String jsp = "fa_ip_sales_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyIpSalesBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.dispalyIpSalesBillingAmount(box);
		String jsp = "fa_ip_sales_voucher.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postSalesIpVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postSalesIpVoucherMapping(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showRefundVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_refundVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView dispalyRefundBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.dispalyRefundBillingAmount(box);
		String jsp = "fa_refundVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView postRefundVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		if (session.getAttribute("financialYear") != null) {
			int fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postRefundVoucherMapping(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public void showAccountBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);

		int fyear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fyear = (Integer) session.getAttribute("financialYear1");
			box.put("fyear", fyear);
		}

		int locationId = 0;
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}

		int accountId = 0;
		if (request.getParameter("accountId") != null) {
			accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}

		map = accountHandlerService.showAccountBalance(box);
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		if (map.get("accountList") != null) {
			accountList = (List) map.get("accountList");
		}
		BigDecimal closingBalanceDr = new BigDecimal(0.0);
		BigDecimal closingBalanceCr = new BigDecimal(0.0);
		int groupId = 0;
		int subGroupId = 0;
		if (accountList.size() > 0) {
			for (AccountMainTransac faMasAccount : accountList) {
				if (faMasAccount.getClBalanceDr() != null
						&& faMasAccount.getClBalanceDr().compareTo(
								new BigDecimal(0)) != 0) {
					closingBalanceDr = faMasAccount.getClBalanceDr();
				} else if (faMasAccount.getClBalanceCr() != null
						&& faMasAccount.getClBalanceCr().compareTo(
								new BigDecimal(0)) != 0) {
					closingBalanceCr = faMasAccount.getClBalanceCr();
				}
				groupId = 0;
				subGroupId = 0;
			}
		}

		try {
			// ------------Response------------------

			StringBuffer sb = new StringBuffer();
			sb.append("<item>");
			if (closingBalanceDr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceDr + " Dr </balance>");
			} else if (closingBalanceCr.compareTo(new BigDecimal(0)) > 0) {
				sb.append("<balance>" + closingBalanceCr + " Cr </balance>");
			} else {
				sb.append("<balance>" + 0 + "  </balance>");
			}
			sb.append("<groupId>" + groupId + " </groupId>");
			sb.append("<subGroupId>" + subGroupId + " </subGroupId>");
			sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
		} catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public ModelAndView showAdvanceVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = "fa_advanceVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showVoucherMappingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showVoucherMappingJsp(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAccountParameterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
		}
		map = accountHandlerService.showAccountParameterJsp(fYear);
		String jsp = "fa_account_parameter.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAccountsParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = accountHandlerService.submitAccountsParameter(box);
		String jsp = "fa_account_parameter.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView	submitAccountsParameterMainCharge(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int fYear = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = accountHandlerService.submitAccountsParameterMainCharge(box);
		String jsp = "fa_account_parameter.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showAccountTransactionDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object[]> accountList = new ArrayList<Object[]>();
		List<Object[]> subledgerList = new ArrayList<Object[]>();
		List<Object[]> financialYearList = new ArrayList<Object[]>();
		List<Object[]> centreList = new ArrayList<Object[]>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		String fYearDesc = "";
		if (session.getAttribute("fYearDesc") != null) {
			fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}

		centreList = accountHandlerService.getCentreList();
		accountList = accountHandlerService.getAccountList(box);
		subledgerList = accountHandlerService.getSubledgerList(box);
		// map = accountHandlerService.showJournalVoucherJsp(box);
		map.put("accountList", accountList);
		map.put("subledgerList", subledgerList);
		map.put("financialYearList", financialYearList);
		map.put("centreList", centreList);
		String jsp = "fa_account_transaction_details" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getConsolidatedTransactionDetails(
			HttpServletRequest request, HttpServletResponse response)

	{

		Map<String, Object> map = new HashMap<String, Object>();
		List<AccountMainTransac> accountList = new ArrayList<AccountMainTransac>();
		List<AccountSubLedTransac> subledgerList = new ArrayList<AccountSubLedTransac>();

		Box box = HMSUtil.getBox(request);

		String TransactionType = "";
		TransactionType = box.getString("TransactionType");

		HttpSession session = request.getSession();
		int locationId = 0;
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
		}
		map = accountHandlerService.getConsolidatedTransactionDetails(box);

		if (map.get("accountList") != null) {
			accountList = (ArrayList) map.get("accountList");
		}

		if (map.get("subledgerList") != null) {
			subledgerList = (ArrayList) map.get("subledgerList");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		if (TransactionType.equalsIgnoreCase("Account")) {
			try {
				PrintWriter pw = response.getWriter();

				pw.write("[");
				int counter = 1;

				for (AccountMainTransac list : accountList) {

					if (counter != accountList.size()) {

						pw.write("{\"Id\": \""
								+ list.getAccount().getId()
								+ "\",\"LastChangedDate\": \""
								+ (list.getTransactionDate() != null ? HMSUtil
										.changeDateToddMMyyyy(list
												.getTransactionDate()) : "")
								+ "\",\"Name\": \""
								+ (list.getAccount() != null ? list
										.getAccount().getAccDesc() : "")
								+ "\",\"ytd_dr\": \"" + list.getYtdAmountDr()
								+ "\",\"ytd_cr\": \"" + list.getYtdAmountCr()
								+ "\",\"opening_dr\": \""
								+ list.getOpBalanceDr()
								+ "\",\"opening_cr\": \""
								+ list.getOpBalanceCr()
								+ "\",\"closing_dr\": \""
								+ list.getClBalanceDr()
								+ "\",\"closing_cr\": \""
								+ list.getClBalanceCr()
								+ "\",\"totalRecords\":\"" + totalRecords
								+ "\"},");

					} else {
						pw.write("{\"Id\": \""
								+ list.getAccount().getId()
								+ "\",\"LastChangedDate\": \""
								+ (list.getTransactionDate() != null ? HMSUtil
										.changeDateToddMMyyyy(list
												.getTransactionDate()) : "")
								+ "\",\"Name\": \""
								+ (list.getAccount() != null ? list
										.getAccount().getAccDesc() : "")
								+ "\",\"ytd_dr\": \"" + list.getYtdAmountDr()
								+ "\",\"ytd_cr\": \"" + list.getYtdAmountCr()
								+ "\",\"opening_dr\": \""
								+ list.getOpBalanceDr()
								+ "\",\"opening_cr\": \""
								+ list.getOpBalanceCr()
								+ "\",\"closing_dr\": \""
								+ list.getClBalanceDr()
								+ "\",\"closing_cr\": \""
								+ list.getClBalanceCr()
								+ "\",\"totalRecords\":\"" + totalRecords
								+ "\"}");

					}

					counter++;
				}

				pw.write("]");

			}

			catch (Exception e) {
				accountList.clear();
				e.printStackTrace();
			}
		}

		if (TransactionType.equalsIgnoreCase("Subledger")) {
			try {
				PrintWriter pw = response.getWriter();

				pw.write("[");
				int counter = 1;

				for (AccountSubLedTransac list : subledgerList) {

					if (counter != subledgerList.size()) {

						pw.write("{\"Id\": \""
								+ list.getSubLed().getId()
								+ "\",\"LastChangedDate\": \""
								+ (list.getTransactionDate() != null ? HMSUtil
										.changeDateToddMMyyyy(list
												.getTransactionDate()) : "")
								+ "\",\"Name\": \""
								+ (list.getSubLed() != null ? list.getSubLed()
										.getSubLedDesc() : "")
								+ "\",\"ytd_dr\": \"" + list.getYtdAmountDr()
								+ "\",\"ytd_cr\": \"" + list.getYtdAmountCr()
								+ "\",\"opening_dr\": \""
								+ list.getOpBalanceDr()
								+ "\",\"opening_cr\": \""
								+ list.getOpBalanceCr()
								+ "\",\"closing_dr\": \""
								+ list.getClBalanceDr()
								+ "\",\"closing_cr\": \""
								+ list.getClBalanceCr()
								+ "\",\"totalRecords\":\"" + totalRecords
								+ "\"},");

					} else {
						pw.write("{\"Id\": \""
								+ list.getSubLed().getId()
								+ "\",\"LastChangedDate\": \""
								+ (list.getTransactionDate() != null ? HMSUtil
										.changeDateToddMMyyyy(list
												.getTransactionDate()) : "")
								+ "\",\"Name\": \""
								+ (list.getSubLed() != null ? list.getSubLed()
										.getSubLedDesc() : "")
								+ "\",\"ytd_dr\": \"" + list.getYtdAmountDr()
								+ "\",\"ytd_cr\": \"" + list.getYtdAmountCr()
								+ "\",\"opening_dr\": \""
								+ list.getOpBalanceDr()
								+ "\",\"opening_cr\": \""
								+ list.getOpBalanceCr()
								+ "\",\"closing_dr\": \""
								+ list.getClBalanceDr()
								+ "\",\"closing_cr\": \""
								+ list.getClBalanceCr()
								+ "\",\"totalRecords\":\"" + totalRecords
								+ "\"}");

					}

					counter++;
				}

				pw.write("]");

			}

			catch (Exception e) {
				subledgerList.clear();
				e.printStackTrace();
			}
		}
		accountList.clear();
		subledgerList.clear();
		return null;

	}

	public ModelAndView popUpOfViewTransactionHistory(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * List<Object[]> seedCategoryList = new ArrayList<Object[]>();
		 * List<Object[]> financialYearList = new ArrayList<Object[]>();
		 * 
		 * seedCategoryList = marketingHandlerService.getSeedCategoryList();
		 * financialYearList = marketingHandlerService.getFinancialYearList();
		 * 
		 * map.put("financialYearList", financialYearList);
		 * map.put("seedCategoryList", seedCategoryList);
		 */

		return new ModelAndView("popUpOfTransactionHistory", "map", map);
	}

	public ModelAndView getTransactionHistory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FaVoucherDetails> voucherDetails = new ArrayList<FaVoucherDetails>();

		Box box = HMSUtil.getBox(request);
		String TransactionType = "";
		TransactionType = box.getString("TransactionType");

		map = accountHandlerService.getTransactionHistory(box);

		if (map.get("voucherDetails") != null) {
			voucherDetails = (ArrayList) map.get("voucherDetails");
		}

		int totalRecords = 0;
		if (map.get("totalRecords") != null) {
			totalRecords = (Integer) map.get("totalRecords");
		}

		if (TransactionType.equalsIgnoreCase("S")) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write("[");
				int counter = 1;

				for (FaVoucherDetails list : voucherDetails) {

					if (counter != voucherDetails.size()) {
						pw.write("{\"Id\": \""
								+ list.getId()
								+ "\",\"Date\": \""
								+ HMSUtil.convertDateToStringWithoutTime(list
										.getVoucherHeader().getVoucherDate())
								+ "\",\"Name\": \""
								+ (list.getSubLed() != null ? list.getSubLed()
										.getSubLedDesc() : "")
								+ "\",\"DrAmount\": \""
								+ (list.getDrAmount() != null ? list
										.getDrAmount().doubleValue() : "0")
								+ "\",\"CrAmount\": \""
								+ (list.getCrAmount() != null ? list
										.getCrAmount().doubleValue() : "0")
								+ "\",\"Narration\": \""
								+ (list.getVoucherHeader().getNarration() != null ? list
										.getVoucherHeader().getNarration() : "")
								+ "\",\"LastChgBy\":\""
								+ (list.getVoucherHeader().getLastChgBy() != null ? list
										.getVoucherHeader().getLastChgBy()
										.getEmployee().getFirstName()
										: "") + "\",\"totalRecords\":\""
								+ totalRecords + "\"},");
					} else {
						pw.write("{\"Id\": \""
								+ list.getId()
								+ "\",\"Date\": \""
								+ HMSUtil.convertDateToStringWithoutTime(list
										.getVoucherHeader().getVoucherDate())
								+ "\",\"Name\": \""
								+ (list.getSubLed() != null ? list.getSubLed()
										.getSubLedDesc() : "")
								+ "\",\"DrAmount\": \""
								+ (list.getDrAmount() != null ? list
										.getDrAmount().doubleValue() : "0")
								+ "\",\"CrAmount\": \""
								+ (list.getCrAmount() != null ? list
										.getCrAmount().doubleValue() : "0")
								+ "\",\"Narration\": \""
								+ (list.getVoucherHeader().getNarration() != null ? list
										.getVoucherHeader().getNarration() : "")
								+ "\",\"LastChgBy\":\""
								+ (list.getVoucherHeader().getLastChgBy() != null ? list
										.getVoucherHeader().getLastChgBy()
										.getEmployee().getFirstName()
										: "") + "\",\"totalRecords\":\""
								+ totalRecords + "\"}");
					}

					counter++;
				}

				pw.write("]");

			}

			catch (Exception e) {
				voucherDetails.clear();
				e.printStackTrace();
			}
		}

		if (TransactionType.equalsIgnoreCase("A")) {
			try {
				PrintWriter pw = response.getWriter();
				pw.write("[");
				int counter = 1;

				for (FaVoucherDetails list : voucherDetails) {

					if (counter != voucherDetails.size()) {
						pw.write("{\"Id\": \""
								+ list.getId()
								+ "\",\"Date\": \""
								+ HMSUtil.convertDateToStringWithoutTime(list
										.getVoucherHeader().getVoucherDate())
								+ "\",\"Name\": \""
								+ (list.getAccount() != null ? list
										.getAccount().getAccDesc() : "")
								+ "\",\"DrAmount\": \""
								+ (list.getDrAmount() != null ? list
										.getDrAmount().doubleValue() : "0")
								+ "\",\"CrAmount\": \""
								+ (list.getCrAmount() != null ? list
										.getCrAmount().doubleValue() : "0")
								+ "\",\"Narration\": \""
								+ (list.getVoucherHeader().getNarration() != null ? list
										.getVoucherHeader().getNarration() : "")
								+ "\",\"LastChgBy\":\""
								+ (list.getVoucherHeader().getLastChgBy() != null ? list
										.getVoucherHeader().getLastChgBy()
										.getEmployee().getFirstName()
										: "") + "\",\"totalRecords\":\""
								+ totalRecords + "\"},");
					} else {
						pw.write("{\"Id\": \""
								+ list.getId()
								+ "\",\"Date\": \""
								+ HMSUtil.convertDateToStringWithoutTime(list
										.getVoucherHeader().getVoucherDate())
								+ "\",\"Name\": \""
								+ (list.getAccount() != null ? list
										.getAccount().getAccDesc() : "")
								+ "\",\"DrAmount\": \""
								+ (list.getDrAmount() != null ? list
										.getDrAmount().doubleValue() : "0")
								+ "\",\"CrAmount\": \""
								+ (list.getCrAmount() != null ? list
										.getCrAmount().doubleValue() : "0")
								+ "\",\"Narration\": \""
								+ (list.getVoucherHeader().getNarration() != null ? list
										.getVoucherHeader().getNarration() : "")
								+ "\",\"LastChgBy\":\""
								+ (list.getVoucherHeader().getLastChgBy() != null ? list
										.getVoucherHeader().getLastChgBy()
										.getEmployee().getFirstName()
										: "") + "\",\"totalRecords\":\""
								+ totalRecords + "\"}");
					}

					counter++;
				}

				pw.write("]");

			}

			catch (Exception e) {
				voucherDetails.clear();
				e.printStackTrace();
			}
		}
		voucherDetails.clear();
		return null;

	}

	public ModelAndView showTrialBalanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		/*
		 * Box box = HMSUtil.getBox(request); HttpSession session =
		 * request.getSession(); int fYear = 0; //int locationId = 0;
		 * if(session.getAttribute("financialYear") != null){ fYear =
		 * (Integer)session.getAttribute("financialYear"); box.put("fYear",
		 * fYear); }
		 */
		// map = accountHandlerService.showTrialBalanceJsp(box);
		String jsp = "trialBalance.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getTrialBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		String accountType = "";
		if (request.getParameter("accountTypeId") != null) {
			accountType = request.getParameter("accountTypeId");
			box.put("accountType", accountType);
		}
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getTrialBalance(box);
		String jsp = "";
		jsp = "viewTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		map.put("accountType", box.getString("accountType"));
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showBalanceSheet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear1") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.showBalanceSheet(box);
		String jsp = "fa_balanceSheet.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayScheduleDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int financialYearId = 0;
		if (session.getAttribute("financialYear1") != null) {
			financialYearId = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", financialYearId);
		}
		if (session.getAttribute("hospitalId") != null) {
			int locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayScheduleDetail(box);

		String jsp = "schedule.jsp";
		map.put("contentJsp", jsp);
		map.put("currentYearDesc", box.getString("currentYearDesc"));
		map.put("lastYearDesc", box.getString("lastYearDesc"));
		map.put("particular", box.getString("particular"));
		map.put("schedule", box.getInt("schedule"));

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDayBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "fa_day_book_report" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDayBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospital_id = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Date from_date = null;
		if (request.getParameter("from_date") != null) {
			from_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("from_date"));
			generalMap.put("from_date", from_date);
		}
		Date to_date = null;
		if (request.getParameter("to_date") != null) {
			to_date = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter("to_date"));
			generalMap.put("to_date", to_date);
		}
		int branchId = 0;
		if (session.getAttribute("branchId") != null) {
			branchId = (Integer) session.getAttribute("branchId");
		}

		int financialYearId = accountHandlerService
				.getFinancialYearList(generalMap);
		parameters.put("hospital_id", hospital_id);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);
		// parameters.put("crAccountClBalance", crAccountClBalance);
		// parameters.put("drAccountClBalance", drAccountClBalance);
		parameters.put("branchId", branchId);
		// parameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/Reports/"));

		detailsMap = accountHandlerService.getConnectionForReport();
		System.out.println("parameters------->>" + parameters);
		//if (financialYearId != 0) {
			HMSUtil.generateReport("dayBookReport", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		/*} else {
			map = accountHandlerService.showLedgerBookJsp();
			map.put("message", "Please select Correct Financial Year");

		}
		String jsp = "fa_day_book_report" + ".jsp";
		map.put("contentJsp", jsp);*/
		return null;
	}
	public ModelAndView showCashRegisterJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		map = accountHandlerService.showCashRegisterJsp(box);

		String jsp = "fa_cas_register" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayCashBook(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		int locationId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			locationId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("locationId", locationId);
		}
		map = accountHandlerService.displayCashBook(box);
		String jsp = "fa_cashBook.jsp";
		map.put("contentJsp", jsp);
		map.put("mainAccountId", box.getInt(ACCOUNT_ID));
		map.put("accountName", box.getString("accountName"));
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showBankVoucherJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		map = accountHandlerService.showBankRegisterJsp();
		String jsp = "";
		String title = "";
		jsp += "fa_bankBook";
		jsp += ".jsp";
		title = "Bank Voucher Report";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView printBankBookReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospital_id = 0;
//		if (session.getAttribute("locationId") != null) {
//			hospital_id = (Integer) session.getAttribute("locationId");
//		}
		if (session.getAttribute("hospitalId") != null) {//added by govind 19-11-2016
			hospital_id = (Integer) session.getAttribute("hospitalId");
		}
		int accountId = 0;
		if (request.getParameter("accId") != null) {
			accountId = Integer.parseInt(request.getParameter("accId"));
		}
		Date from_date = null;
		if (request.getParameter(FROM_DATE) != null) {
			from_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));

		}
		Date to_date = null;
		if (request.getParameter(TO_DATE) != null) {
			to_date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));

		}
		
		detailsMap = accountHandlerService.getConnectionForReport();
		parameters.put("hospital_id", hospital_id);
		parameters.put("accountId", accountId);
		parameters.put("from_date", from_date);
		parameters.put("to_date", to_date);

		HMSUtil.generateReport("bankBook", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());

		return null;

	}
	public ModelAndView dispalySalesBillingAmount(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("financialYear") != null) {
			int fyear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fyear);
		}
		
		if (session.getAttribute("locationId") != null) {
			int locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.dispalySalesBillingAmount(box);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("fromMDateReturn",request.getParameter(FROM_DATE));
		map.put("toDateReturn",request.getParameter(TO_DATE));
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}	
	public ModelAndView postSalesVoucherMapping(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute("hospitalId") != null) {
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("financialYear1") != null) {
			int fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("fYearDesc") != null) {
			String fYearDesc = (String) session.getAttribute("fYearDesc");
			box.put("fYearDesc", fYearDesc);
		}
		Users users = new Users();
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			int changedBy = users.getId();
			box.put("changedBy", changedBy);
		}
		map = accountHandlerService.postSalesVoucherMapping(box);
		boolean saved = false;
		String message = "";
		if (map.get("saved") != null) {
			saved = (Boolean) map.get("saved");
		}
		if (saved) {
			message = "Data Saved Successfully.";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
		String jsp = "fa_accountsVoucherMapping.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getSubGroupWiseTrialBalance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("groupId") != null) {
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			box.put("groupId", groupId);
		}
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getSubGroupWiseTrialBalance(box);
		// String jsp = "responseForSubGroupWiseTrialBalane";
		String jsp = "subGroupWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getAccountWiseWiseTrialBalance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("subGroupId") != null) {
			int subGroupId = Integer.parseInt(request
					.getParameter("subGroupId"));
			box.put("subGroupId", subGroupId);
		}
		if (session.getAttribute("financialYear1") != null) {
			fYear = (Integer) session.getAttribute("financialYear1");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("hospitalId") != null) {
			locationId = (Integer) session.getAttribute("hospitalId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getAccountWiseTrialBalance(box);
		String jsp = "accountWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}	public ModelAndView getVoucherWiseWiseTrialBalance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int fYear = 0;
		int locationId = 0;
		if (request.getParameter("accountId") != null) {
			int accountId = Integer.parseInt(request.getParameter("accountId"));
			box.put("accountId", accountId);
		}
		if (session.getAttribute("financialYear") != null) {
			fYear = (Integer) session.getAttribute("financialYear");
			box.put("fYear", fYear);
		}
		if (session.getAttribute("locationId") != null) {
			locationId = (Integer) session.getAttribute("locationId");
			box.put("locationId", locationId);
		}
		map = accountHandlerService.getVoucherWiseWiseTrialBalance(box);
		String jsp = "voucherWiseTrialBalance.jsp";
		map.put("contentJsp", jsp);
		map.put("fromDate", box.getString(FROM_DATE));
		map.put("toDate", box.getString(TO_DATE));
		return new ModelAndView("index", "map", map);
	}
	 public ModelAndView generateBalanceSheetJsp(HttpServletRequest request,
				HttpServletResponse response) {
			List<AccountMainTransac> currentFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			List<AccountMainTransac> lastFinancialYearAccountList = new ArrayList<AccountMainTransac>();
			int lastYearDesc = 0;
			int currentYearDesc = 0;
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			Box box = HMSUtil.getBox(request);
			int financialYearId = 0;
			String hospitalName = "";
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				box.put("fYear", financialYearId);
			}
			if (session.getAttribute("hospitalId") != null) {
				int locationId = (Integer) session.getAttribute("hospitalId");
				box.put("locationId", locationId);
				mapForDs.put("storeId", locationId);
				mapResponse = accountHandlerService.getHospitalName(mapForDs);
			}
		
		
		if (mapResponse.get("masHospitaList") != null) {
			masHospitaList = (List) mapResponse.get("masHospitaList");
			hospitalName = masHospitaList.get(0).getHospitalName();
			
		}
		BigDecimal currentCrBalance3 = new BigDecimal(0.00);
		BigDecimal currentDrBalance3 = new BigDecimal(0.00);
		BigDecimal currentCrBalance4 = new BigDecimal(0.00);
		BigDecimal currentDrBalance4 = new BigDecimal(0.00);
		BigDecimal currentCrBalance5 = new BigDecimal(0.00);
		BigDecimal currentDrBalance5 = new BigDecimal(0.00);
		BigDecimal currentCrBalance6 = new BigDecimal(0.00);
		BigDecimal currentDrBalance6 = new BigDecimal(0.00);
		BigDecimal currentCrBalance7 = new BigDecimal(0.00);
		BigDecimal currentDrBalance7 = new BigDecimal(0.00);
		BigDecimal currentCrBalance8 = new BigDecimal(0.00);
		BigDecimal currentDrBalance8 = new BigDecimal(0.00);
		BigDecimal currentCrBalance9 = new BigDecimal(0.00);
		BigDecimal currentDrBalance9 = new BigDecimal(0.00);
		BigDecimal currentCrBalance10 = new BigDecimal(0.00);
		BigDecimal currentDrBalance10 = new BigDecimal(0.00);
		BigDecimal currentCrBalance11 = new BigDecimal(0.00);
		BigDecimal currentDrBalance11 = new BigDecimal(0.00);
		BigDecimal currentCrBalance12 = new BigDecimal(0.00);
		BigDecimal currentDrBalance12 = new BigDecimal(0.00);
		BigDecimal currentCrBalance13 = new BigDecimal(0.00);
		BigDecimal currentDrBalance13 = new BigDecimal(0.00);
		BigDecimal currentCrBalance14 = new BigDecimal(0.00);
		BigDecimal currentDrBalance14 = new BigDecimal(0.00);
		BigDecimal currentCrBalance15 = new BigDecimal(0.00);
		BigDecimal currentDrBalance15 = new BigDecimal(0.00);
		BigDecimal currentCrBalance16 = new BigDecimal(0.00);
		BigDecimal currentDrBalance16 = new BigDecimal(0.00);
		BigDecimal currentCrBalance17 = new BigDecimal(0.00);
		BigDecimal currentDrBalance17 = new BigDecimal(0.00);
		BigDecimal currentSchedule3Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule4Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule5Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule6Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule7Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule8Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule9Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule10Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule11Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule12Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule13Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule14Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule15Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule16Amt = new BigDecimal(0.00);
		BigDecimal currentSchedule17Amt = new BigDecimal(0.00);

		

		map = accountHandlerService.generateBalanceSheetJsp(box);
			String jsp="";
			
			
			if(map.get("sucFlag") != null && (Boolean)map.get("sucFlag"))
				{
				currentFinancialYearAccountList = (List) map.get("currentFinancialYearAccountList");
				lastFinancialYearAccountList = (List) map.get("lastFinancialYearAccountList");
				currentYearDesc = (Integer) map.get("currentYearDesc");
				lastYearDesc = (Integer) map.get("lastYearDesc");
					try
					{
						response.setContentType("application/vnd.ms-excel");
						response.setHeader("Content-Disposition","attachment; filename=balance_sheet.xls");
						
						WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
						WritableSheet ws = wb.createSheet("Balance Sheet", 0);
						
						WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
						wf.setUnderlineStyle(UnderlineStyle.SINGLE);
						WritableCellFormat wcf = new WritableCellFormat(wf);
						wcf.setAlignment(Alignment.CENTRE);
						
						WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
						WritableCellFormat wcf2 = new WritableCellFormat(wf2);
						wcf2.setWrap(true);
						wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf2.setVerticalAlignment(VerticalAlignment.TOP);
						
						
						WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
						WritableCellFormat wcf222 = new WritableCellFormat(wf222);
						wcf222.setWrap(true);
						wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf222.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
						WritableCellFormat wcf3 = new WritableCellFormat(wf3);
						wcf3.setWrap(true);
						wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf3.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
						WritableCellFormat wcf4 = new WritableCellFormat(wf4);
						wcf4.setWrap(true);
						wcf4.setVerticalAlignment(VerticalAlignment.TOP);
						
						WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
						WritableCellFormat wcf22 = new WritableCellFormat(wf22);
						wcf22.setWrap(true);
						wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
						wcf22.setVerticalAlignment(VerticalAlignment.TOP);
						
						ws.mergeCells(0,0,3,0);
						Label label = new Label(0,0,hospitalName,wcf);
						ws.addCell(label);

						ws.mergeCells(0,1,3,1);
						label = new Label(0,1,"Balance Sheet",wcf);
						ws.addCell(label);
						
			
						label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
						ws.addCell(label);
						/*ws.mergeCells(3,2,10,2);
						label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
						ws.addCell(label);*/
						
						label = new Label(0,4,"Particulars",wcf2);
						ws.addCell(label);
						label = new Label(1,4,"Note No.",wcf2);
						ws.addCell(label);
						label = new Label(2,4,"For the Year ended 31st March"+ currentYearDesc+"(in Rs.)",wcf2);
						ws.addCell(label);
						label = new Label(3,4,"For the Year ended 31st March"+ lastYearDesc+"(in Rs.)",wcf2);
						ws.addCell(label);
						
						
						label = new Label(0,5,"<b>Equity And Liabilities</b>",wcf22);
						ws.addCell(label);
						
						label = new Label(0,6,"Shareholder's funds",wcf22);
						ws.addCell(label);
						
						label = new Label(0,7,"Share Capital",wcf22);
						ws.addCell(label);

						
						label = new Label(0,8,"Reserves and surplus",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,9,"Share application money pending allotment",wcf22);
						ws.addCell(label);
						
						label = new Label(0,10,"Non-current liabilities",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,11,"Other Long term liabilities",wcf22);
						ws.addCell(label);
						
						label = new Label(0,12,"Long-term provisions",wcf22);
						ws.addCell(label);
						

						label = new Label(0,13,"Current liabilities",wcf22);
						ws.addCell(label);
						
						label = new Label(0,14,"Short-term borrowings",wcf22);
						ws.addCell(label);
						
						label = new Label(0,15,"Trade payables",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,16,"Other current liabilities",wcf22);
						ws.addCell(label);
						
						label = new Label(0,17,"Short-term provisions",wcf22);
						ws.addCell(label);
						
						label = new Label(0,18,"TOTAL",wcf222);
						ws.addCell(label);
						
						label = new Label(0,19,"ASSETS",wcf222);
						ws.addCell(label);
						
						label = new Label(0,20,"Non-current assets",wcf22);
						ws.addCell(label);
						
						label = new Label(0,21,"Fixed assets",wcf22);
						ws.addCell(label);
						
						label = new Label(0,22,"Tangible assets",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,23,"Intangible assets",wcf22);
						ws.addCell(label);
						
						label = new Label(0,24,"Capital work-in-progress",wcf22);
						ws.addCell(label);
						
						
						
						
						label = new Label(0,25,"Long-term loans and advances",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,26,"Current assets",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,27,"Inventories",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,28,"Trade receivables",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,29,"Cash and bank balances",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,30,"Short-term loans and advances",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,31,"Other current assets",wcf22);
						ws.addCell(label);
						
						
						label = new Label(0,32,"Total",wcf222);
						ws.addCell(label);
						
					
						if(currentFinancialYearAccountList.size()>0){
							for(AccountMainTransac masAccount : currentFinancialYearAccountList){
								if(masAccount.getAccount()!=null && masAccount.getAccount().getScheduleDr() != null){
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==3){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance3 =currentCrBalance3.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance3 =currentDrBalance3.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance3.compareTo(currentDrBalance3)>0){
										currentSchedule3Amt = currentCrBalance3.subtract(currentDrBalance3);
									}else if(currentDrBalance3.compareTo(currentCrBalance3)>0){
										currentSchedule3Amt = currentDrBalance3.subtract(currentCrBalance3);
									}else if(currentDrBalance3.compareTo(currentCrBalance3)==0){
										currentSchedule3Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==4){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance4 =currentCrBalance4.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance4 =currentDrBalance4.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance4.compareTo(currentDrBalance4)>0){
										currentSchedule4Amt = currentCrBalance4.subtract(currentDrBalance4);
									}else if(currentDrBalance4.compareTo(currentCrBalance4)>0){
										currentSchedule4Amt = currentDrBalance4.subtract(currentCrBalance4);
									}else if(currentDrBalance4.compareTo(currentCrBalance4)==0){
										currentSchedule4Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==5){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentCrBalance5 =currentCrBalance5.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance5.compareTo(currentDrBalance5)>0){
										currentSchedule5Amt = currentCrBalance5.subtract(currentDrBalance5);
									}else if(currentDrBalance5.compareTo(currentCrBalance4)>0){
										currentSchedule5Amt = currentDrBalance5.subtract(currentCrBalance5);
									}else if(currentDrBalance5.compareTo(currentCrBalance5)==0){
										currentSchedule5Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==6){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance6 =currentCrBalance6.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance6 =currentDrBalance6.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance6.compareTo(currentDrBalance6)>0){
										currentSchedule6Amt = currentCrBalance6.subtract(currentDrBalance6);
									}else if(currentDrBalance6.compareTo(currentCrBalance6)>0){
										currentSchedule6Amt = currentDrBalance6.subtract(currentCrBalance6);
									}else if(currentDrBalance6.compareTo(currentCrBalance6)==0){
										currentSchedule6Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==7){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance7 =currentCrBalance7.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance7 =currentDrBalance7.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance7.compareTo(currentDrBalance7)>0){
										currentSchedule7Amt = currentCrBalance7.subtract(currentDrBalance7);
									}else if(currentDrBalance7.compareTo(currentCrBalance7)>0){
										currentSchedule7Amt = currentDrBalance7.subtract(currentCrBalance7);
									}else if(currentDrBalance7.compareTo(currentCrBalance7)==0){
										currentSchedule7Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==8){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance8 =currentCrBalance8.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance8 =currentDrBalance8.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance8.compareTo(currentDrBalance8)>0){
										currentSchedule8Amt = currentCrBalance8.subtract(currentDrBalance8);
									}else if(currentDrBalance8.compareTo(currentCrBalance8)>0){
										currentSchedule8Amt = currentDrBalance8.subtract(currentCrBalance8);
									}else if(currentDrBalance8.compareTo(currentCrBalance8)==0){
										currentSchedule8Amt =new BigDecimal(0.00);
									}
								}
								if(masAccount.getAccount().getScheduleDr().getScheduleCode()==9){
									if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
										currentCrBalance9 =currentCrBalance9.add(masAccount.getClBalanceCr());
									}
									if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
										currentDrBalance9 =currentDrBalance9.add(masAccount.getClBalanceDr());
									}
									if(currentCrBalance9.compareTo(currentDrBalance9)>0){
										currentSchedule9Amt = currentCrBalance9.subtract(currentDrBalance9);
									}else if(currentDrBalance9.compareTo(currentCrBalance9)>0){
										currentSchedule9Amt = currentDrBalance9.subtract(currentCrBalance9);
									}else if(currentDrBalance9.compareTo(currentCrBalance9)==0){
										currentSchedule9Amt =new BigDecimal(0.00);
									}
								}
								
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==10){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance10 =currentCrBalance10.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance10 =currentDrBalance10.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance10.compareTo(currentDrBalance10)>0){
									currentSchedule10Amt = currentCrBalance10.subtract(currentDrBalance10);
								}else if(currentDrBalance10.compareTo(currentCrBalance10)>0){
									currentSchedule10Amt = currentDrBalance10.subtract(currentCrBalance10);
								}else if(currentDrBalance10.compareTo(currentCrBalance10)==0){
									currentSchedule10Amt =new BigDecimal(0.00);
								}
							}
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==11){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance11 =currentCrBalance11.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance11 =currentDrBalance11.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance11.compareTo(currentDrBalance11)>0){
									currentSchedule11Amt = currentCrBalance11.subtract(currentDrBalance11);
								}else if(currentDrBalance11.compareTo(currentCrBalance11)>0){
									currentSchedule11Amt = currentDrBalance11.subtract(currentCrBalance11);
								}else if(currentDrBalance11.compareTo(currentCrBalance11)==0){
									currentSchedule11Amt =new BigDecimal(0.00);
								}
							}
							
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==12){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance12 =currentCrBalance12.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance12 =currentDrBalance12.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance12.compareTo(currentDrBalance12)>0){
									currentSchedule12Amt = currentCrBalance12.subtract(currentDrBalance12);
								}else if(currentDrBalance12.compareTo(currentCrBalance12)>0){
									currentSchedule12Amt = currentDrBalance12.subtract(currentCrBalance12);
								}else if(currentDrBalance12.compareTo(currentCrBalance12)==0){
									currentSchedule12Amt =new BigDecimal(0.00);
								}
							}
							
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==13){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance13 =currentCrBalance13.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance13 =currentDrBalance13.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance13.compareTo(currentDrBalance13)>0){
									currentSchedule13Amt = currentCrBalance13.subtract(currentDrBalance13);
								}else if(currentDrBalance13.compareTo(currentCrBalance13)>0){
									currentSchedule13Amt = currentDrBalance13.subtract(currentCrBalance13);
								}else if(currentDrBalance13.compareTo(currentCrBalance13)==0){
									currentSchedule13Amt =new BigDecimal(0.00);
								}
							}
							
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==14){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance14 =currentCrBalance14.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance14 =currentDrBalance14.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance14.compareTo(currentDrBalance14)>0){
									currentSchedule14Amt = currentCrBalance14.subtract(currentDrBalance14);
								}else if(currentDrBalance14.compareTo(currentCrBalance14)>0){
									currentSchedule14Amt = currentDrBalance14.subtract(currentCrBalance14);
								}else if(currentDrBalance14.compareTo(currentCrBalance14)==0){
									currentSchedule14Amt =new BigDecimal(0.00);
								}
							}
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==15){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance15 =currentCrBalance15.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance15 =currentDrBalance15.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance15.compareTo(currentDrBalance15)>0){
									currentSchedule15Amt = currentCrBalance15.subtract(currentDrBalance15);
								}else if(currentDrBalance15.compareTo(currentCrBalance15)>0){
									currentSchedule15Amt = currentDrBalance15.subtract(currentCrBalance15);
								}else if(currentDrBalance15.compareTo(currentCrBalance15)==0){
									currentSchedule15Amt =new BigDecimal(0.00);
								}
							}
							
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==16){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance16 =currentCrBalance16.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance16 =currentDrBalance16.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance16.compareTo(currentDrBalance16)>0){
									currentSchedule16Amt = currentCrBalance16.subtract(currentDrBalance16);
								}else if(currentDrBalance16.compareTo(currentCrBalance16)>0){
									currentSchedule16Amt = currentDrBalance16.subtract(currentCrBalance16);
								}else if(currentDrBalance16.compareTo(currentCrBalance16)==0){
									currentSchedule16Amt =new BigDecimal(0.00);
								}
							}
							
							if(masAccount.getAccount().getScheduleDr().getScheduleCode()==17){
								if(masAccount.getClBalanceCr() != null && masAccount.getClBalanceCr() != new BigDecimal(0.00)){
									currentCrBalance17 =currentCrBalance17.add(masAccount.getClBalanceCr());
								}
								if(masAccount.getClBalanceDr() != null && masAccount.getClBalanceDr() != new BigDecimal(0.00)){
									currentDrBalance17 =currentDrBalance17.add(masAccount.getClBalanceDr());
								}
								if(currentCrBalance17.compareTo(currentDrBalance17)>0){
									currentSchedule17Amt = currentCrBalance17.subtract(currentDrBalance17);
								}else if(currentDrBalance17.compareTo(currentCrBalance17)>0){
									currentSchedule17Amt = currentDrBalance17.subtract(currentCrBalance17);
								}else if(currentDrBalance17.compareTo(currentCrBalance17)==0){
									currentSchedule17Amt =new BigDecimal(0.00);
								}
							}
							
							
							}
						}
					}
						
							BigDecimal currentshareHoldersAmt = currentSchedule3Amt.add(currentSchedule4Amt);
							BigDecimal nonCurrentLiabilities =  currentSchedule5Amt.add(currentSchedule6Amt);
							BigDecimal currentLiabilities =currentSchedule7Amt.add(currentSchedule8Amt).add(currentSchedule9Amt).add(currentSchedule10Amt); 
							BigDecimal currentAssets =currentSchedule13Amt.add(currentSchedule14Amt).add(currentSchedule15Amt).add(currentSchedule16Amt).add(currentSchedule17Amt); 
							label = new Label(1,7,"3",wcf3);
							ws.addCell(label);
							label = new Label(2,7,currentSchedule3Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,7,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,8,"4",wcf3);
							ws.addCell(label);
							label = new Label(2,8,currentSchedule4Amt+"-------------- "+currentshareHoldersAmt.toString() ,wcf3);
							ws.addCell(label);
							label = new Label(3,8,"",wcf3);
							ws.addCell(label);
							
							label = new Label(1,9,"",wcf3);
							ws.addCell(label);
							label = new Label(2,9,"",wcf3);
							ws.addCell(label);
							label = new Label(3,9,"",wcf3);
							ws.addCell(label);
							
							
							
							label = new Label(1,10,"",wcf3);
							ws.addCell(label);
							label = new Label(2,10,"",wcf3);
							ws.addCell(label);
							label = new Label(3,10,"",wcf3);
							ws.addCell(label);
							
							

							
							
							label = new Label(1,11,"5",wcf3);
							ws.addCell(label);
							label = new Label(2,11,currentSchedule5Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,11,"",wcf3);
							ws.addCell(label);
							
												
							
							label = new Label(1,12,"6",wcf3);
							ws.addCell(label);
							label = new Label(2,12,currentSchedule6Amt +"-------------- "+nonCurrentLiabilities.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,12,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,13,"",wcf3);
							ws.addCell(label);
							label = new Label(2,13,currentSchedule5Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,13,"",wcf3);
							ws.addCell(label);
							
							label = new Label(1,14,"7",wcf3);
							ws.addCell(label);
							label = new Label(2,14,currentSchedule7Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,14,"",wcf3);
							ws.addCell(label);

							label = new Label(1,15,"8",wcf3);
							ws.addCell(label);
							label = new Label(2,15,currentSchedule8Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,15,"",wcf3);
							ws.addCell(label);
							
							label = new Label(1,16,"9",wcf3);
							ws.addCell(label);
							label = new Label(2,16,currentSchedule9Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,16,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,17,"10",wcf3);
							ws.addCell(label);
							label = new Label(2,17,currentSchedule10Amt +"--------------"+currentLiabilities.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,17,"",wcf3);
							ws.addCell(label);
							
							label = new Label(2,18,currentshareHoldersAmt.add(nonCurrentLiabilities).add(currentLiabilities).toString(),wcf3);
							ws.addCell(label);
							
							
							
							
							label = new Label(1,21,"11",wcf3);
							ws.addCell(label);
							label = new Label(2,21,currentSchedule11Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,21,"",wcf3);
							ws.addCell(label);
						
						
							
							label = new Label(1,25,"12",wcf3);
							ws.addCell(label);
							label = new Label(2,25,currentSchedule12Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,25,"",wcf3);
							ws.addCell(label);
							
							
							
							label = new Label(1,27,"13",wcf3);
							ws.addCell(label);
							label = new Label(2,27,currentSchedule13Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,27,"",wcf3);
							ws.addCell(label);
							
							
							
							label = new Label(1,28,"14",wcf3);
							ws.addCell(label);
							label = new Label(2,28,currentSchedule14Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,28,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,29,"15",wcf3);
							ws.addCell(label);
							label = new Label(2,29,currentSchedule15Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,29,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,30,"16",wcf3);
							ws.addCell(label);
							label = new Label(2,30,currentSchedule16Amt.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,30,"",wcf3);
							ws.addCell(label);
							
							
							label = new Label(1,31,"17",wcf3);
							ws.addCell(label);
							label = new Label(2,31,currentSchedule17Amt+"  -------------------                    "+currentAssets.toString(),wcf3);
							ws.addCell(label);
							label = new Label(3,31,"",wcf3);
							ws.addCell(label);
							
					
							label = new Label(2,32,currentSchedule11Amt.add(currentSchedule12Amt).add(currentAssets).toString(),wcf3);
							ws.addCell(label);
				
							
						CellView cell = new CellView();
					    cell.setSize(8000);
					    ws.setColumnView(0, cell);
					    
					    cell.setSize(6000);
					    ws.setColumnView(2, cell);
					    
					    cell.setSize(6000);
					    ws.setColumnView(3, cell);
					    
					    cell.setSize(600);
					    ws.setColumnView(5, cell);
					    
					    cell.setSize(3000);
					    ws.setColumnView(7, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(10, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(11, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(12, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(13, cell);
					    
					    cell.setSize(2000);
					    ws.setColumnView(14, cell);
					    
					    cell.setSize(1500);
					    ws.setColumnView(15, cell);
					
						wb.write();
						wb.close();
						return null;
					}
					catch(Exception e)
					{
						e.printStackTrace();
						jsp = "fa_balanceSheet";
						jsp += ".jsp";
						String title = "Profit And Loss";
						map.put("contentJsp", jsp);
						map.put("title", title);
						map.put("message","Some Error Occured");
						return new ModelAndView("index", "map", map);
					}
				}
				else
				{
					jsp = "fa_balanceSheet";
					jsp += ".jsp";
					String title = "Profit And Loss";
					map.put("contentJsp", jsp);
					map.put("title", title);
					map.put("message","No Data Found");
					return new ModelAndView("index", "map", map);
				}
	 }
	 public ModelAndView printTrialReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			int fYear=0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			String accountType = "";
			if (request.getParameter("accountType") != null) {
				accountType = (request.getParameter("accountType"));
			}
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			if (session.getAttribute("financialYear1") != null) {
				fYear = (Integer) session.getAttribute("financialYear1");
				
			}
	System.out.println(hospital_id);
	System.out.println(from_date);
	System.out.println(to_date);
	System.out.println(fYear);
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospital_id", hospital_id);
			parameters.put("from_date", from_date);
			parameters.put("to_date", to_date);
			parameters.put("year_id", fYear);

			if (accountType.equals("group")) {
				HMSUtil.generateReport("trialGroup", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (accountType.equals("subgroup")) {
				HMSUtil.generateReport("trailSubGroup", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			} else if (accountType.equals("account")) {
				HMSUtil.generateReport("trailAccount", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
			}
			return null;
		}
	 public ModelAndView printLedgerReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			int accountId = 0;
			if (request.getParameter("accId") != null) {
				accountId = Integer.parseInt(request.getParameter("accId"));
			}
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			
			String userHome = getServletContext().getRealPath("");
			System.out.println("userHome="+userHome);
			String imagePath = userHome+"/jsp/images/logo.jpg";
			parameters.put("path", imagePath);
			
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospital_id", hospital_id);
			parameters.put("accountId", accountId);
			parameters.put("from_date", from_date);
			parameters.put("to_date", to_date);

			HMSUtil.generateReport("ledger", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
	 
	 
	 
	 public ModelAndView printLedgerReportNew(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			
			String userHome = getServletContext().getRealPath("");
			System.out.println("userHome="+userHome);
			String imagePath = userHome+"/jsp/images/logo.jpg";
			parameters.put("path", imagePath);
			
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);

			HMSUtil.generateReport("Ledger_Report", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView printCashReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			int accountId = 0;
			if (request.getParameter(ACCOUNT_ID) != null && !request.getParameter(ACCOUNT_ID).equals("")) {
				
				accountId = Integer.parseInt(request.getParameter(ACCOUNT_ID));
			}
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			String flag="";
			if(request.getParameter("flag")!=null && !request.getParameter("flag").equals("")){
				flag=request.getParameter("flag");
			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);
			parameters.put("accountId", accountId);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/reports/"));

			if(flag.equals("subCentre")){
			HMSUtil.generateReport("Double_Column_Cash_Bank_Book_Sub_Centre", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			}else if(flag.equals("VHNSC")){
				HMSUtil.generateReport("Double_Column_Cash_Bank_Book_VHNSC", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());
				}else{
					HMSUtil.generateReport("Double_Column_Cash_Bank_Book", parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
					}
			return null;

		}
		public ModelAndView showChequeRegisterJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			//map = accountHandlerService.showChequeRegisterJsp(box);

			String jsp = "fa_cheque_register" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printChequeRegisterReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			//parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);

			HMSUtil.generateReport("Cheque_Issued_Register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;

		}
		public ModelAndView showJournalRegisterJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			//map = accountHandlerService.showChequeRegisterJsp(box);

			String jsp = "fa_journal_register" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printJournalRegisterReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			//parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);

			HMSUtil.generateReport("Joural_Register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;

		}
		public ModelAndView showBankReconcillationReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showBankReconcillationReportJsp(box);

			String jsp = "fa_bank_reconcillation_JSP" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView 	printBankRecocillation(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			detailsMap = accountHandlerService.getConnectionForReport();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			String year="";
			int month=0;
			if(request.getParameter("year")!=null && !request.getParameter("year").equals("")){
				year=request.getParameter("year");
			}
			if(request.getParameter("month")!=null && !request.getParameter("month").equals("")){
				month=Integer.parseInt(request.getParameter("month"));
			}
			int days=LeaveManagementUtil.getNumberOfDaysOfMonth(year, month);
			String month1="";
			if(month==1){
				month1="January";
			}else if(month==2){
				month1="February";
			}else if(month==3){
				month1="March";
			}else if(month==4){
				month1="April";
			}else if(month==5){
				month1="May";
			}else if(month==6){
				month1="June";
			}else if(month==7){
				month1="July";
			}else if(month==8){
				month1="August";
			}else if(month==9){
				month1="September";
			}else if(month==10){
				month1="October";
			}else if(month==11){
				month1="November";
			}else if(month==12){
				month1="December";
			} 
			System.out.println("days-===========>>"+days);
			String date1="01/"+month+"/"+year;
			String date2=days+"/"+month+"/"+year;
			Date fromDate=new Date();
			Date toDate=new Date();
			fromDate=HMSUtil.convertStringTypeDateToDateType(date1);
			toDate=HMSUtil.convertStringTypeDateToDateType(date2);
			parameters.put("hospitalId", hospital_id);
			parameters.put("month", month1);
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("year", year);
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/reports/"));

			HMSUtil.generateReport("Bank_Reconsillation_Report", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView showReceiptPaymentReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			//map = accountHandlerService.showChequeRegisterJsp(box);

			String jsp = "fa_receipt_payment_report" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView 		getReceiptPaymentReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			Date fromDate=new Date();
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			
			Date toDate=new Date();
			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			System.out.println(""+getServletContext().getRealPath("/Reports/"));
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			
			System.out.println("parameters=============>>>>"+parameters);
			HMSUtil.generateReport("Receipt_Payment_Account", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView showIncomeExpenditureReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showIncomeExpenditureReportJsp(box);

			String jsp = "fa_income_expenditure_JSP" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView printIncomeExpenditureReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			int hospitalId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			int financialYearId=0;
			/*if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
			}*/
			if(request.getParameter("year")!=null && !request.getParameter("year").equals("0")){
				financialYearId=Integer.parseInt(request.getParameter("year"));
			}
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				
			}
			String fromDate="";
			String toDate="";
			if(request.getParameter(FROM_DATE)!=null){
				fromDate=(request.getParameter(FROM_DATE));
			}
			fromDate=fromDate.substring(6,10).concat("-").concat(fromDate.substring(3,5)).concat("-").concat(fromDate.substring(0,2));
			
			System.out.println("fromDate ----- --->>"+fromDate);
			if(request.getParameter(TO_DATE)!=null){
				toDate=(request.getParameter(TO_DATE));
			}
			toDate=toDate.substring(6,10).concat("-").concat(toDate.substring(3,5)).concat("-").concat(toDate.substring(0,2));
			int groupId=0;
			int groupId2=0;
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("account.properties");
		       try
		       {
		    	   prop.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       groupId=Integer.parseInt(prop.getProperty("accountGroupIdIncome"));
		       groupId2=Integer.parseInt(prop.getProperty("accountGroupIdExpense"));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		       
		       String query="";
		       if(fYearId!=0){
		       query="where h.f_year_id="+financialYearId+" and h.hospital_id="+hospitalId+" and h.voucher_no ilike '%PV%' and d.dr_amount is not null ";
		       }else{
	    	   query="where h.voucher_date between  '"+fromDate+"' and '"+toDate+"' and h.hospital_id="+hospitalId+" and h.voucher_no ilike '%PV%' and d.dr_amount is not null ";   
		       }
		       System.out.println("query--->>"+query);
			parameters.put("financialYearId",fYearId);
			parameters.put("groupId",groupId);
			parameters.put("groupId2",groupId2);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("hospitalId",hospitalId);
			parameters.put("query",query);
			//parameters.put("toDate", toDate);
			//System.out.println("parameters======>>"+parameters);
			System.out.println("hospitalId======>>"+hospitalId);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("Income_Expenditure_Report", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView showFixedAssetReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showFixedAssetReportJsp(box);

			String jsp = "fa_Fixed_Asset_JSP" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView 		printFixedAssetReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int hospital_id=0;
			if(session.getAttribute("hospitalId")!=null){
				hospital_id=Integer.parseInt(""+session.getAttribute("hospitalId"));
			}
			
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			Date fromDate=new Date();
			Date toDate=new Date();
			List<MasStoreFinancial>masStoreFinancialList=new ArrayList<MasStoreFinancial>();
			masStoreFinancialList=accountHandlerService.getmasStoreFinancialList(fYearId);
			for(MasStoreFinancial MasStoreFinancial:masStoreFinancialList){
				fromDate=MasStoreFinancial.getStartDate();
				toDate=MasStoreFinancial.getEndDate();
			}
			int groupId=0;
			int groupId2=0;
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("account.properties");
		       try
		       {
		    	   prop.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       groupId=Integer.parseInt(prop.getProperty("accountGroupIdAsset"));
		       groupId2=Integer.parseInt(prop.getProperty("accountGroupIdExpense"));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
			parameters.put("financialYearId",fYearId);
			parameters.put("groupId",groupId);
			parameters.put("groupId2",groupId2);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("hospitalId", hospital_id);
			parameters.put("fromDate", fromDate);
			parameters.put("toDate", toDate);
			//parameters.put("toDate", toDate);
			System.out.println("parameters======>>"+parameters);
			HMSUtil.generateReport("Fixed_Asset_register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView	showSubLedghmsopupJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();

			HttpSession session = request.getSession();
			if (request.getParameter("accountId") != null) {
				generalMap.put("accountId",
						Integer.parseInt(request.getParameter("accountId")));
			}
			int locationId = 0;
			if (session.getAttribute("hospitalId") != null) {
				locationId = (Integer) session.getAttribute("hospitalId");
				generalMap.put("locationId", locationId);
			}
			map = accountHandlerService.showSubLedgerPopupJsp(generalMap);
			String jsp = "subLedDetailPopUp";
			return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView showOpeningClosingReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showFixedAssetReportJsp(box);

			String jsp = "fa_Opening_Closing_JSP" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView 		printOpeningandClosingReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}

			
			int groupId=0;
			int groupId2=0;
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("account.properties");
		       try
		       {
		    	   prop.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       groupId=Integer.parseInt(prop.getProperty("accountGroupIdAsset"));
		       groupId2=Integer.parseInt(prop.getProperty("accountGroupIdExpense"));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
			parameters.put("financialYearId",fYearId);
		//	parameters.put("groupId",groupId);
		//	parameters.put("groupId2",groupId2);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			//parameters.put("toDate", toDate);
			System.out.println("parameters======>>"+parameters);
			HMSUtil.generateReport("Opening_Closing_Account_Register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		
		

		 

		public ModelAndView showSchemeWiseFundAllocateJsp(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = accountHandlerService.showSchemeWiseFundAllocateJsp();
			String jsp = "schemeWiseFundAllocate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
			
		public ModelAndView addSchemeWiseFundAllocate(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				box.put("financialYearId", financialYearId);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			}
			Users users = new Users();
			int changedBy = 0;
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				changedBy = users.getId();
				box.put("changedBy", changedBy);
				
			}
			
			map = accountHandlerService.addSchemeWiseFundAllocate(box);
			boolean successfullyAdded = false;
			String message ="";
			if(map.get("successfullyAdded")!=null){
				successfullyAdded = (Boolean)map.get("successfullyAdded");
			}
			if(map.get("message")!=null){
				message = (String)map.get("message");
			}
			if(message.equals("")){
				if (successfullyAdded ) {
					message = "Record Added Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "schemeWiseFundAllocate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView updateSchemeWiseFundAllocate(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session=request.getSession();
			
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			}
			Users users = new Users();
			int changedBy = 0;
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				changedBy = users.getId();
				box.put("changedBy", changedBy);
				
			}
			map = accountHandlerService.updateSchemeWiseFundAllocate(box);
			boolean successfullyAdded = false;
			String message ="";
			if(map.get("successfullyAdded")!=null){
				successfullyAdded = (Boolean)map.get("successfullyAdded");
			}
			if(map.get("message")!=null){
				message = (String)map.get("message");
			}
			if(message.equals("")){
				if (successfullyAdded ) {
					message = "Record Updated Successfully !!";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "schemeWiseFundAllocate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView deleteSchemeWiseFundAllocate(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session=request.getSession();
			
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			}
			Users users = new Users();
			int changedBy = 0;
			if (session.getAttribute("users") != null) {
				users = (Users) session.getAttribute("users");
				changedBy = users.getId();
				box.put("changedBy", changedBy);
				
			}
			boolean dataDeleted = false;
			String jsp="";
			String message="";
			dataDeleted = accountHandlerService.deleteSchemeWiseFundAllocate(box);
			if (dataDeleted == true) {
				if( box.getString("flag").equals("InActivate"))
					message = "Record is InActivated successfully !!";
				else if( box.getString("flag").equals("Activate"))
					message = "Record is Activated successfully !!";
			}
			else {
				message = "Some Problem occured!";
			}
			try {
				map = accountHandlerService.showSchemeWiseFundAllocateJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = "schemeWiseFundAllocate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView searchSchemeWiseFundAllocate(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String jsp="";
			String message="";
			Box box = HMSUtil.getBox(request);
			map = accountHandlerService.searchSchemeWiseFundAllocate(box);
			jsp = "schemeWiseFundAllocate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("search", "search");
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showSOEReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			map = accountHandlerService.showFixedAssetReportJsp(box);
			map=accountHandlerService.getSchemeDetails();
			String jsp = "fa_SOE" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printSOEReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			int subLedId=0;
			if(request.getParameter(SUB_LEDGER_CODE)!=null && !request.getParameter(SUB_LEDGER_CODE).equals("0")){
				subLedId=Integer.parseInt(request.getParameter(SUB_LEDGER_CODE));
			}else if(request.getParameter(SUB_LEDGER_CODE_BANK)!=null && !request.getParameter(SUB_LEDGER_CODE_BANK).equals("0")){
				subLedId=Integer.parseInt(request.getParameter(SUB_LEDGER_CODE_BANK));
			}
			int schemeId=0;
			if(request.getParameter("schemeName")!=null && !request.getParameter("schemeName").equals("0")){
				schemeId=Integer.parseInt(request.getParameter("schemeName"));
			}
			int groupId=0;
			int groupId2=0;
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("account.properties");
		       try
		       {
		    	   prop.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       groupId=Integer.parseInt(prop.getProperty("accountGroupIdIncome"));
		       groupId2=Integer.parseInt(prop.getProperty("accountGroupIdExpense"));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		       
		       String month=request
						.getParameter(TO_DATE).substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				parameters.put("month", monthName);
				parameters.put("year", request
						.getParameter(TO_DATE).substring(6,10));
				parameters.put("hospitalId",hospital_id);
				
				//parameters.put("accountId", accountId);
				parameters.put("fromDate", from_date);
				parameters.put("toDate", to_date);
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				parameters.put("subLedId",subLedId);
				parameters.put("schemeId",schemeId);
				System.out.println("subLedId==>"+subLedId);
				System.out.println("schemeId==>"+schemeId);
				if(subLedId!=0){
			HMSUtil.generateReport("SOE_New", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
				}else if(schemeId!=0){
					System.out.println("in else!!!");
					HMSUtil.generateReport("SOE_NewSchemeWise", parameters,
							(Connection) detailsMap.get("conn"), response,
							getServletContext());
						}
			return null;
		}
		public ModelAndView showIncomeAndExpenseForTheMonth(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showFixedAssetReportJsp(box);

			String jsp = "IncomeAndExpenseForMonth" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printIncomeAndExpenseForMonthReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String dateValue = "01"+"/"+month+"/"+year;
			Date vDate = HMSUtil.convertStringTypeDateToDateType(dateValue);
			//System.out.println("date2==="+dateValue);
			//System.out.println("date3=="+HMSUtil.convertStringTypeDateToDateType(dateValue));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		   String monthStr = HMSUtil.convertMonth(Integer.parseInt(month.toString()));
			parameters.put("financialYearId",fYearId);
			parameters.put("vDate",vDate);
			parameters.put("hospitalId",hospitalId);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("month",Integer.parseInt(month.toString()));
			parameters.put("monthStr",monthStr);
			
			HMSUtil.generateReport("incomeAndExpenditureReportForMonth", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		public ModelAndView showSanctionAmountReportJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showFixedAssetReportJsp(box);

			String jsp = "fa_sanctionAmount" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printSanctionAmountReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			int year1=0;
			if(request.getParameter("year")!=null && !request.getParameter("year").equals("0")){
				year1=Integer.parseInt(request.getParameter("year"));
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String dateValue = "01"+"/"+month+"/"+year;
			Date vDate = HMSUtil.convertStringTypeDateToDateType(dateValue);
			//System.out.println("date2==="+dateValue);
			//System.out.println("date3=="+HMSUtil.convertStringTypeDateToDateType(dateValue));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		   String monthStr = HMSUtil.convertMonth(Integer.parseInt(month.toString()));
			parameters.put("financialYearId",year1);
			parameters.put("vDate",vDate);
			parameters.put("hospitalId",hospitalId);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("month",Integer.parseInt(month.toString()));
			parameters.put("monthStr",monthStr);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("uc_reporting", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		public ModelAndView showStatementOfExpenditureFoNationalHealthMission(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showFixedAssetReportJsp(box);

			String jsp = "fa_statementOfExpenditure" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printStatementOfExpenditureReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String dateValue = "01"+"/"+month+"/"+year;
			Date vDate = HMSUtil.convertStringTypeDateToDateType(date);
			//System.out.println("date2==="+dateValue);
			//System.out.println("date3=="+HMSUtil.convertStringTypeDateToDateType(dateValue));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		   String monthStr = HMSUtil.convertMonth(Integer.parseInt(month.toString()));
			parameters.put("financialYearId",fYearId);
			parameters.put("vDate",vDate);
			parameters.put("hospitalId",hospitalId);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("month",Integer.parseInt(month.toString()));
			parameters.put("monthStr",monthStr);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("statementofExpense", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		public ModelAndView printStatementOfExpenditureReportForNRHM(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String dateValue = "01"+"/"+month+"/"+year;
			Date vDate = HMSUtil.convertStringTypeDateToDateType(date);
			//System.out.println("date2==="+dateValue);
			//System.out.println("date3=="+HMSUtil.convertStringTypeDateToDateType(dateValue));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		   String monthStr = HMSUtil.convertMonth(Integer.parseInt(month.toString()));
			parameters.put("financialYearId",fYearId);
			parameters.put("vDate",vDate);
			parameters.put("hospitalId",hospitalId);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("month",Integer.parseInt(month.toString()));
			parameters.put("monthStr",monthStr);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("statementofExpenseForNRHM", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		public ModelAndView showFundReceiveAndExpenseReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			map.put("hospitalId",hospitalId);
			map=accountHandlerService.showFundReceiveAndExpenseReport(map);
			
			String jsp = "fundsReceivedAndExpense" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printFundsReceivedAndExpenseReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			String month=request
					.getParameter(TO_DATE).substring(3,5);
			String monthName=HMSUtil.getMonthName(month);
System.out.println(financialYearId+"financialYearId");			 
			parameters.put("financialYearId",financialYearId);
			
			//parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			parameters.put("month", monthName);
			parameters.put("year", request
					.getParameter(TO_DATE).substring(6,10));
			HMSUtil.generateReport("fundsReceivedAndExpense", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;

		}
		
		public ModelAndView showAdvanceRegisterReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			map = accountHandlerService.showFixedAssetReportJsp(box);
			
			String jsp = "fa_advance_register" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printAdvanceRegisterReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String month = date.substring(3,5);
			String year = date.substring(6,10);
			String dateValue = "01"+"/"+month+"/"+year;
			Date vDate = HMSUtil.convertStringTypeDateToDateType(dateValue);
			//System.out.println("date2==="+dateValue);
			//System.out.println("date3=="+HMSUtil.convertStringTypeDateToDateType(dateValue));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		   String monthStr = HMSUtil.convertMonth(Integer.parseInt(month.toString()));
			parameters.put("financialYearId",fYearId);
			parameters.put("vDate",vDate);
			parameters.put("hospitalId",hospitalId);
			parameters.put("fyear", fYear);
			parameters.put("fyear1", fYear1);
			parameters.put("month",Integer.parseInt(month.toString()));
			parameters.put("monthStr",monthStr);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			HMSUtil.generateReport("advance_register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		public ModelAndView showAgingOfAdvanceReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			
			String jsp = "fa_agingOfAdvance" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView printAgingOfAdvanceReport(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			//parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));

			HMSUtil.generateReport("advance_outstanding", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;

		}
		
		public ModelAndView printVoucherRpt(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String jsp = "";
			String title = "";
			jsp = "voucher";
			jsp = jsp + ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);

			return new ModelAndView("index", "map", map);
		}

		public ModelAndView generateVoucherRpt(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int storeId = 0;
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			Date fromDate = null;
			Date toDate = null;
			String hospitalName = "";
			try {
				int hospital_id = 0;
				if (session.getAttribute("hospitalId") != null) {
					hospital_id = (Integer) session.getAttribute("hospitalId");
					mapForDs.put("storeId", hospital_id);
					requestParameters.put("hospital_id", hospital_id);
					mapResponse = accountHandlerService.getHospitalName(mapForDs);
				}
				if (mapResponse.get("masHospitaList") != null) {
					masHospitaList = (List) mapResponse.get("masHospitaList");
					hospitalName = masHospitaList.get(0).getHospitalName();
					requestParameters.put("hospitalName", hospitalName);
				}

				if (request.getParameter(FROM_DATE) != null
						&& !(request.getParameter(FROM_DATE).equals(""))) {
					fromDate = HMSUtil.convertStringTypeDateToDateType((request
							.getParameter(FROM_DATE)));

				}
				if (request.getParameter(TO_DATE) != null
						&& !(request.getParameter(TO_DATE).equals(""))) {
					toDate = HMSUtil.convertStringTypeDateToDateType((request
							.getParameter(TO_DATE)));

				}
				Map<String, Object> conMap = accountHandlerService.getConnectionForReport();
				String voucherType = "";
				if (request.getParameter("voucherType") != null) {
					voucherType = request.getParameter("voucherType");
				}
				requestParameters.put("voucherType", voucherType);
				requestParameters.put("fromDate", fromDate);
				requestParameters.put("toDate", toDate);
				
				
				if (voucherType.equalsIgnoreCase("JV")) {
					HMSUtil.generateReport("journalVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} 
				else if (voucherType.equalsIgnoreCase("PU")) {
					HMSUtil.generateReport("purchaseVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} 
				else if (voucherType.equalsIgnoreCase("RV")) {

					int accountId = 0;
					if (request.getParameter("accountId") != null) {
						accountId = Integer.parseInt(request.getParameter("accountId"));
					}
					requestParameters.put("accId", accountId);
					HMSUtil.generateReport("receiptVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} else if (voucherType.equalsIgnoreCase("SV")) {
					HMSUtil.generateReport("salesVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} else if (voucherType.equalsIgnoreCase("SR")) {
					HMSUtil.generateReport("salesReturnVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} else if (voucherType.equalsIgnoreCase("PV")) {
					int accountId = 0;
					if (request.getParameter("accountId") != null) {
						accountId = Integer.parseInt(request.getParameter("accountId"));
					}
					requestParameters.put("accId", accountId);
					HMSUtil.generateReport("paymentVoucher", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				} else if (voucherType.equalsIgnoreCase("PR")) {
					HMSUtil.generateReport("purchaseReturn", requestParameters,
							(Connection) conMap.get("conn"), response,
							getServletContext());
				}

		

				


			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;

						
 }	
		public ModelAndView showIncomeExpenditureReportWardLevelJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			map = accountHandlerService.showIncomeExpenditureReportWardLevelJsp(box);

			String jsp = "fa_income_expenditure_ward_wise_JSP" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView 		printIncomeExpenditureReportWardWise(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			detailsMap = accountHandlerService.getConnectionForReport();
			int fYearId=0;
			if(request.getParameter("year")!=null){
				fYearId=Integer.parseInt(request.getParameter("year"));
			}
			HttpSession session=request.getSession();
			int financialYearId=0;
			if (session.getAttribute("financialYear1") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			int subLedId=0;
			if(request.getParameter(SUB_LEDGER_CODE)!=null && !request.getParameter(SUB_LEDGER_CODE).equals("0") && !request.getParameter(SUB_LEDGER_CODE).equals("")){
				subLedId=Integer.parseInt(request.getParameter(SUB_LEDGER_CODE));
			}else if(request.getParameter(SUB_LEDGER_CODE_BANK)!=null && !request.getParameter(SUB_LEDGER_CODE_BANK).equals("0")){
				subLedId=Integer.parseInt(request.getParameter(SUB_LEDGER_CODE_BANK));
			}
			
			int groupId=0;
			int groupId2=0;
			Properties prop = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("account.properties");
		       try
		       {
		    	   prop.load(resourcePath.openStream());
		       }
		       catch (Exception e)
		       {
		               e.printStackTrace();
		       }
		       groupId=Integer.parseInt(prop.getProperty("accountGroupIdIncome"));
		       groupId2=Integer.parseInt(prop.getProperty("accountGroupIdExpense"));
		       String fYear="";
		       String fYear1="";
		       String financialYear=accountHandlerService.getFinancialYear(financialYearId);
		       if(!financialYear.equals("")){
		    	   fYear=financialYear.substring(7,9);
		    	   fYear1=financialYear.substring(2,4);
		       }
		       
		       String month=request
						.getParameter(TO_DATE).substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				parameters.put("month", monthName);
				parameters.put("year", request
						.getParameter(TO_DATE).substring(6,10));
				parameters.put("hospitalId",hospital_id);
				
				//parameters.put("accountId", accountId);
				parameters.put("fromDate", from_date);
				parameters.put("toDate", to_date);
				parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
				parameters.put("subLedId",subLedId);
			HMSUtil.generateReport("IncomeExpenditure", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		
		public ModelAndView showDataForTrnsaction(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String,Object>map=new HashMap<String,Object>();
			int rowNum=0;
			if(request.getParameter("rowNum")!=null){
				rowNum=Integer.parseInt(request.getParameter("rowNum"));
			}
			String jsp = "accountDataForTransaction";
			//jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("rowNum", rowNum);
			return new ModelAndView(jsp, "map", map);
			
		}
		public ModelAndView showAdvanceRegisterJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			if (session.getAttribute("financialYear1") != null) {
				int fyear = (Integer) session.getAttribute("financialYear1");
				//box.put("fYear", fyear);
			}
			int hospitalId=0;
			if (session.getAttribute("hospitalId") != null) {
				 hospitalId = (Integer) session.getAttribute("hospitalId");
				//box.put("fYear", fyear);
			}
			
			//map = accountHandlerService.showChequeRegisterJsp(box);

			String jsp = "fa_advance_register" + ".jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		
		public ModelAndView printAdvanceRegisterReport2(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> parameters = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int hospital_id = 0;
			if (session.getAttribute("hospitalId") != null) {
				hospital_id = (Integer) session.getAttribute("hospitalId");
			}
			
			Date from_date = null;
			if (request.getParameter(FROM_DATE) != null) {
				from_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));

			}
			Date to_date = null;
			if (request.getParameter(TO_DATE) != null) {
				to_date = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));

			}
			detailsMap = accountHandlerService.getConnectionForReport();
			parameters.put("hospitalId", hospital_id);
			//parameters.put("accountId", accountId);
			parameters.put("fromDate", from_date);
			parameters.put("toDate", to_date);

			HMSUtil.generateReport("advance_register", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			return null;

		}
		public void getValueForchequeNo(
				HttpServletRequest request, HttpServletResponse response) {
			int chqueId=0;
			if(request.getParameter("chequeNo")!=null){
				chqueId=Integer.parseInt(request.getParameter("chequeNo"));
			}
			System.out.println("chequeId---->"+chqueId);
			Map<String,Object>map=new HashMap<String,Object>();
			List<FaVoucherDetails>voucherHeaderList=new ArrayList<FaVoucherDetails>();
			map = accountHandlerService.getValueForchequeNo(chqueId);
			if (map.get("voucherHeaderList") != null) {
				voucherHeaderList = (List) map.get("voucherHeaderList");
			}
		
			StringBuffer sb = new StringBuffer();
			try {
				for (FaVoucherDetails masStoreItem : voucherHeaderList) {
					System.out.println("expiry=="+ masStoreItem.getDrAmount());
					sb.append("<item>");
					sb.append("<id>" + masStoreItem.getId() + "</id>");
					sb.append("<amount>" + masStoreItem.getDrAmount() + "</amount>");
					sb.append("<voucherType>" + masStoreItem.getVoucherHeader().getVoucherType() + "</voucherType>");
					sb.append("<checkDate>" + masStoreItem.getVoucherHeader().getIssueDate() + "</checkDate>");
					/*
					 * if(masStoreItem.getManufacturer()!=null){
					 * sb.append("<manufacturerId>" +
					 * masStoreItem.getManufacturer().getId() +
					 * "</manufacturerId>");
					 * 
					 * }else{ sb.append("<manufacturerId>"+" "+"</manufacturerId>");
					 * 
					 * } if(masStoreItem.getManufacturer()!=null){
					 * sb.append("<manufacturerName>" +
					 * masStoreItem.getManufacturer().getManufacturerName() +
					 * "</manufacturerName>"); }else{ sb.append("<manufacturerName>"
					 * + " " + "</manufacturerName>"); }
					 */
					/*for (MasManufacturer manu : manufacturerList) {
						if (manu.getId() != null) {
							sb.append("<manufacturerId>" + manu.getId()
									+ "</manufacturerId>");

						} else {
							sb.append("<manufacturerId>" + " "
									+ "</manufacturerId>");

						}
						if (manu.getManufacturerName() != null) {
							sb.append("<manufacturerName>"
									+ manu.getManufacturerName()
									+ "</manufacturerName>");
						} else {
							sb.append("<manufacturerName>" + " "
									+ "</manufacturerName>");
						}
					}*/
					
					
					sb.append("</item>");
				}

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
			}		}
		
		public ModelAndView printPettyCashVoucherExcel(HttpServletRequest request,
				HttpServletResponse response) {
			String fromDate="";
			String HospitalName="";
			HttpSession session =request.getSession();
			if(session.getAttribute("hospitalName")!=null){
				HospitalName=(String)session.getAttribute("hospitalName");
			}
			int hospitalId=0;
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			String toDate="";
			Map<String,Object>map=new HashMap<String,Object>();
			Map<String,Object>mapForDataExcel=new HashMap<String,Object>();
			Map<String,Object>generalMap=new HashMap<String,Object>();
			if(request.getParameter(FROM_DATE)!=null){
				fromDate=(request.getParameter(FROM_DATE));
			}
			
			if(request.getParameter(TO_DATE)!=null){
				toDate=(request.getParameter(TO_DATE));
			}
			generalMap.put("fromDate", fromDate);
			generalMap.put("toDate", toDate);
			generalMap.put("hospitalId", hospitalId);
			map=accountHandlerService.getDataForExcel(generalMap);
			List<Object[]>aList=new ArrayList<Object[]>();
			List<Object[]>otherExpenseList=new ArrayList<Object[]>();
			List<Object[]>TotalExpense=new ArrayList<Object[]>();
			List<Object[]>cleaningAccountList=new ArrayList<Object[]>();
			List<Object[]>minorModificationAccount=new ArrayList<Object[]>();
			List<Object[]>	transportForEmergenciesList=new ArrayList<Object[]>();
			List<Object[]>	rewardToAshaList=new ArrayList<Object[]>();
			if(map.get("minorModificationAccount")!=null){
				minorModificationAccount=(List<Object[]>)map.get("minorModificationAccount");
			}
			if(map.get("transportForEmergenciesList")!=null){
				transportForEmergenciesList=(List<Object[]>)map.get("transportForEmergenciesList");
			}
			
			
			if(map.get("aList")!=null){
				aList=(List<Object[]>)map.get("aList");
			}
			if(map.get("otherExpenseList")!=null){
				otherExpenseList=(List<Object[]>)map.get("otherExpenseList");
			}
				if(map.get("TotalExpense")!=null){
					TotalExpense=(List<Object[]>)map.get("TotalExpense");
				}
				if(map.get("cleaningAccountList")!=null){
					cleaningAccountList=(List<Object[]>)map.get("cleaningAccountList");
				}
				
				if(map.get("rewardToAshaList")!=null){
					rewardToAshaList=(List<Object[]>)map.get("rewardToAshaList");
				}
				
				
				System.out.println("aList.size()-------->>>>>"+aList.size());
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=petty_cash_Sub_Centre.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("PettyCash", 0);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);
				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
				wcf2.setWrap(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				
				ws.mergeCells(0,0,3,0);
				Label label = new Label(0,0,HospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,3,1);
				label = new Label(0,1,"Petty Cash Book For Sub Centre",wcf);
				ws.addCell(label);
				
	
				label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);
				/*ws.mergeCells(3,2,10,2);
				label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				
				label = new Label(0,4,"Date ",wcf2);
				ws.addCell(label);
				label = new Label(1,4,"S. No.",wcf2);
				ws.addCell(label);
				label = new Label(2,4,"Particulars"+ "(in Rs.)",wcf2);
				ws.addCell(label);
				label = new Label(3,4,"Receipts",wcf2);
				ws.addCell(label);
				label = new Label(4,4,"Total Expenditure",wcf2);
				ws.addCell(label);
				label = new Label(6,4,"CLeaning Sub Centre      ",wcf21);
				ws.addCell(label);
				label = new Label(7,4,"Minor Modification, and repar",wcf2);
				ws.addCell(label);
				label = new Label(8,4,"Transport of Emergencies",wcf2);
				ws.addCell(label);
				label = new Label(9,4,"Payment Reward To ASHA",wcf2);
				ws.addCell(label);
				label = new Label(10,4,"Other Expense",wcf2);
				ws.addCell(label);
				
				label = new Label(2,38,"Total",wcf3);
				ws.addCell(label);
				
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
				
			int a=5;
			int a1=4;
			label = new Label(1,5,"1",wcf3);
			ws.addCell(label);
			label = new Label(1,6,"2",wcf3);
			ws.addCell(label);
			label = new Label(1,7,"3",wcf3);
			ws.addCell(label);
			label = new Label(1,8,"4",wcf3);
			ws.addCell(label);
			label = new Label(1,9,"5",wcf3);
			ws.addCell(label);
			label = new Label(1,10,"6",wcf3);
			ws.addCell(label);
			label = new Label(1,11,"7",wcf3);
			ws.addCell(label);
			label = new Label(1,12,"8",wcf3);
			ws.addCell(label);
			label = new Label(1,13,"9",wcf3);
			ws.addCell(label);
			label = new Label(1,14,"10",wcf3);
			ws.addCell(label);
			label = new Label(1,15,"11",wcf3);
			ws.addCell(label);
			label = new Label(1,16,"12",wcf3);
			ws.addCell(label);
			label = new Label(1,17,"13",wcf3);
			ws.addCell(label);
			label = new Label(1,18,"14",wcf3);
			ws.addCell(label);
			label = new Label(1,19,"15",wcf3);
			ws.addCell(label);
			label = new Label(1,20,"16",wcf3);
			ws.addCell(label);
			label = new Label(1,21,"17",wcf3);
			ws.addCell(label);
			label = new Label(1,22,"18",wcf3);
			ws.addCell(label);
			label = new Label(1,23,"19",wcf3);
			ws.addCell(label);
			label = new Label(1,24,"20",wcf3);
			ws.addCell(label);
			label = new Label(1,25,"21",wcf3);
			ws.addCell(label);
			label = new Label(1,26,"22",wcf3);
			ws.addCell(label);
			label = new Label(1,27,"23",wcf3);
			ws.addCell(label);
			label = new Label(1,28,"24",wcf3);
			ws.addCell(label);
			label = new Label(1,29,"25",wcf3);
			ws.addCell(label);
			label = new Label(1,30,"26",wcf3);
			ws.addCell(label);
			label = new Label(1,31,"27",wcf3);
			ws.addCell(label);
			label = new Label(1,32,"28",wcf3);
			ws.addCell(label);
			label = new Label(1,33,"29",wcf3);
			ws.addCell(label);
			label = new Label(1,34,"30",wcf3);
			ws.addCell(label);
			label = new Label(1,35,"31",wcf3);
			ws.addCell(label);

			
			
			BigDecimal sum=new BigDecimal(0);

			
			
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a1+Integer.parseInt(obj[0].toString().substring(8,10)),""+obj[0].toString().substring(8, 10).concat("/").concat(obj[0].toString().substring(5, 7)).concat(obj[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					sum=sum.add(new BigDecimal(obj[1].toString()));
					label = new Label(2,a,"",wcf3);
					ws.addCell(label);
					label = new Label(3,a1+Integer.parseInt(obj[0].toString().substring(8,10)),obj[1].toString(),wcf3);
					ws.addCell(label);
					label = new Label(4,a,"",wcf3);
					ws.addCell(label);	
					label = new Label(5,a,"",wcf3);
					ws.addCell(label);
					label = new Label(6,a,"",wcf3);
					ws.addCell(label);
					label = new Label(7,a,"",wcf3);
					ws.addCell(label);
					label = new Label(8,a,"",wcf3);
					ws.addCell(label);
					label = new Label(9,a,"",wcf3);
					ws.addCell(label);
					a++;
					slNo++;
					}
				}
			label = new Label(3,38,""+sum,wcf3);
			ws.addCell(label);
			
			BigDecimal sumTotal=new BigDecimal(0);
			if(TotalExpense.size()>0){
				for(Object[] totalExp:TotalExpense){
					label = new Label(4,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),totalExp[1].toString(),wcf3);
					ws.addCell(label);
					sumTotal=sumTotal.add(new BigDecimal(totalExp[1].toString()));
				}
			}
			label = new Label(4,38,""+sumTotal,wcf3);
			ws.addCell(label);
			
			BigDecimal sumOther=new BigDecimal(0);
			if(otherExpenseList.size()>0){
						for(Object[] orherExp:otherExpenseList){
							label = new Label(10,a1+Integer.parseInt(orherExp[0].toString().substring(8,10)),orherExp[1].toString(),wcf3);
							ws.addCell(label);
							sumOther=sumOther.add(new BigDecimal(orherExp[1].toString()));
						}
					}
					
			
			label = new Label(10,38,""+sumOther,wcf3);
			ws.addCell(label);
					if(cleaningAccountList.size()>0){
						for(Object[] cleaningAcc:cleaningAccountList){
							label = new Label(6,a1+Integer.parseInt(cleaningAcc[0].toString().substring(8,10)),cleaningAcc[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(minorModificationAccount.size()>0){
						for(Object[] minor:minorModificationAccount){
							label = new Label(7,a1+Integer.parseInt(minor[0].toString().substring(8,10)),minor[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(transportForEmergenciesList.size()>0){
						for(Object[] transport:transportForEmergenciesList){
							label = new Label(8,a1+Integer.parseInt(transport[0].toString().substring(8,10)),transport[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(rewardToAshaList.size()>0){
						for(Object[] reward:rewardToAshaList){
							label = new Label(9,a1+Integer.parseInt(reward[0].toString().substring(8,10)),reward[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
				CellView cell = new CellView();
			    cell.setSize(8000);
			    ws.setColumnView(0, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
System.out.println(""+map.get("download_path").toString());
				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			/*	HMSUtil.generateReport("Advance_register", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());*/

				return null;
			
		}
		
		public ModelAndView printPettyCashVoucherVHNSCExcel(HttpServletRequest request,
				HttpServletResponse response) {
			String fromDate="";
			String HospitalName="";
			HttpSession session =request.getSession();
			if(session.getAttribute("hospitalName")!=null){
				HospitalName=(String)session.getAttribute("hospitalName");
			}
			int hospitalId=0;
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			String toDate="";
			Map<String,Object>map=new HashMap<String,Object>();
			Map<String,Object>mapForDataExcel=new HashMap<String,Object>();
			Map<String,Object>generalMap=new HashMap<String,Object>();
			if(request.getParameter(FROM_DATE)!=null){
				fromDate=(request.getParameter(FROM_DATE));
			}
			
			if(request.getParameter(TO_DATE)!=null){
				toDate=(request.getParameter(TO_DATE));
			}
			generalMap.put("fromDate", fromDate);
			generalMap.put("toDate", toDate);
			generalMap.put("hospitalId", hospitalId);
			map=accountHandlerService.printPettyCashVoucherVHNSCExcel(generalMap);
			List<Object[]>aList=new ArrayList<Object[]>();
			List<Object[]>otherExpenseList=new ArrayList<Object[]>();
			List<Object[]>TotalExpense=new ArrayList<Object[]>();
			List<Object[]>VillageHealthActivityList=new ArrayList<Object[]>();
			List<Object[]>RevolvingFundsList=new ArrayList<Object[]>();
			List<Object[]>	NutritionList=new ArrayList<Object[]>();
			List<Object[]>	EducationandSanitizationList=new ArrayList<Object[]>();
			if(map.get("RevolvingFundsList")!=null){
				RevolvingFundsList=(List<Object[]>)map.get("RevolvingFundsList");
			}
			if(map.get("NutritionList")!=null){
				NutritionList=(List<Object[]>)map.get("NutritionList");
			}
			
			
			if(map.get("aList")!=null){
				aList=(List<Object[]>)map.get("aList");
			}
			if(map.get("otherExpenseList")!=null){
				otherExpenseList=(List<Object[]>)map.get("otherExpenseList");
			}
				if(map.get("TotalExpense")!=null){
					TotalExpense=(List<Object[]>)map.get("TotalExpense");
				}
				if(map.get("VillageHealthActivityList")!=null){
					VillageHealthActivityList=(List<Object[]>)map.get("VillageHealthActivityList");
				}
				
				if(map.get("EducationandSanitizationList")!=null){
					EducationandSanitizationList=(List<Object[]>)map.get("EducationandSanitizationList");
				}
				
				
				System.out.println("aList.size()-------->>>>>"+aList.size());
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=petty_cash_Sub_Centre.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("PettyCash", 0);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);
				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
				wcf2.setWrap(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				
				ws.mergeCells(0,0,3,0);
				Label label = new Label(0,0,HospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,3,1);
				label = new Label(0,1,"Petty Cash Book For VHNSC",wcf);
				ws.addCell(label);
				
	
				label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);
				/*ws.mergeCells(3,2,10,2);
				label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				
				label = new Label(0,4,"Date ",wcf2);
				ws.addCell(label);
				label = new Label(1,4,"S. No.",wcf2);
				ws.addCell(label);
				label = new Label(2,4,"Particulars"+ "(in Rs.)",wcf2);
				ws.addCell(label);
				label = new Label(3,4,"Receipts",wcf2);
				ws.addCell(label);
				label = new Label(4,4,"Total Expenditure",wcf2);
				ws.addCell(label);
				label = new Label(6,4,"Village Level public Health Activity \n (Cleanliness drive etc)",wcf21);
				ws.addCell(label);
				label = new Label(7,4,"Revolving Fund For house-holds",wcf2);
				ws.addCell(label);
				label = new Label(8,4,"Nutrition",wcf2);
				ws.addCell(label);
				label = new Label(9,4,"Education & Sanitation",wcf2);
				ws.addCell(label);
				label = new Label(10,4,"Other Expense",wcf2);
				ws.addCell(label);
				label = new Label(11,4,"Daily Balance",wcf2);
				ws.addCell(label);
				
				
				label = new Label(2,38,"Total",wcf3);
				ws.addCell(label);
				
				BigDecimal sum=new BigDecimal(0);
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
				
			int a=5;
			int a1=4;
			label = new Label(1,5,"1",wcf3);
			ws.addCell(label);
			label = new Label(1,6,"2",wcf3);
			ws.addCell(label);
			label = new Label(1,7,"3",wcf3);
			ws.addCell(label);
			label = new Label(1,8,"4",wcf3);
			ws.addCell(label);
			label = new Label(1,9,"5",wcf3);
			ws.addCell(label);
			label = new Label(1,10,"6",wcf3);
			ws.addCell(label);
			label = new Label(1,11,"7",wcf3);
			ws.addCell(label);
			label = new Label(1,12,"8",wcf3);
			ws.addCell(label);
			label = new Label(1,13,"9",wcf3);
			ws.addCell(label);
			label = new Label(1,14,"10",wcf3);
			ws.addCell(label);
			label = new Label(1,15,"11",wcf3);
			ws.addCell(label);
			label = new Label(1,16,"12",wcf3);
			ws.addCell(label);
			label = new Label(1,17,"13",wcf3);
			ws.addCell(label);
			label = new Label(1,18,"14",wcf3);
			ws.addCell(label);
			label = new Label(1,19,"15",wcf3);
			ws.addCell(label);
			label = new Label(1,20,"16",wcf3);
			ws.addCell(label);
			label = new Label(1,21,"17",wcf3);
			ws.addCell(label);
			label = new Label(1,22,"18",wcf3);
			ws.addCell(label);
			label = new Label(1,23,"19",wcf3);
			ws.addCell(label);
			label = new Label(1,24,"20",wcf3);
			ws.addCell(label);
			label = new Label(1,25,"21",wcf3);
			ws.addCell(label);
			label = new Label(1,26,"22",wcf3);
			ws.addCell(label);
			label = new Label(1,27,"23",wcf3);
			ws.addCell(label);
			label = new Label(1,28,"24",wcf3);
			ws.addCell(label);
			label = new Label(1,29,"25",wcf3);
			ws.addCell(label);
			label = new Label(1,30,"26",wcf3);
			ws.addCell(label);
			label = new Label(1,31,"27",wcf3);
			ws.addCell(label);
			label = new Label(1,32,"28",wcf3);
			ws.addCell(label);
			label = new Label(1,33,"29",wcf3);
			ws.addCell(label);
			label = new Label(1,34,"30",wcf3);
			ws.addCell(label);
			label = new Label(1,35,"31",wcf3);
			ws.addCell(label);

			
			
			
			
			
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a1+Integer.parseInt(obj[0].toString().substring(8,10)),""+obj[0].toString().substring(8, 10).concat("/").concat(obj[0].toString().substring(5, 7)).concat(obj[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					sum=sum.add(new BigDecimal(obj[1].toString()));
					label = new Label(2,a,"",wcf3);
					ws.addCell(label);
					label = new Label(3,a1+Integer.parseInt(obj[0].toString().substring(8,10)),obj[1].toString(),wcf3);
					ws.addCell(label);
					label = new Label(4,a,"",wcf3);
					ws.addCell(label);	
					label = new Label(5,a,"",wcf3);
					ws.addCell(label);
					label = new Label(6,a,"",wcf3);
					ws.addCell(label);
					label = new Label(7,a,"",wcf3);
					ws.addCell(label);
					label = new Label(8,a,"",wcf3);
					ws.addCell(label);
					label = new Label(9,a,"",wcf3);
					ws.addCell(label);
					a++;
					slNo++;
					}
				}
			label = new Label(3,38,""+sum,wcf3);
			ws.addCell(label);
			BigDecimal totalSum=new BigDecimal(0);
			if(TotalExpense.size()>0){
				for(Object[] totalExp:TotalExpense){
					label = new Label(4,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),totalExp[1].toString(),wcf3);
					ws.addCell(label);
					totalSum=totalSum.add(new BigDecimal(totalExp[1].toString()));
				}
			}
			label = new Label(4,38,""+totalSum,wcf3);
			ws.addCell(label);	
					
					if(VillageHealthActivityList.size()>0){
						for(Object[] cleaningAcc:VillageHealthActivityList){
							label = new Label(6,a1+Integer.parseInt(cleaningAcc[0].toString().substring(8,10)),cleaningAcc[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(RevolvingFundsList.size()>0){
						for(Object[] minor:RevolvingFundsList){
							label = new Label(7,a1+Integer.parseInt(minor[0].toString().substring(8,10)),minor[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(NutritionList.size()>0){
						for(Object[] transport:NutritionList){
							label = new Label(8,a1+Integer.parseInt(transport[0].toString().substring(8,10)),transport[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(EducationandSanitizationList.size()>0){
						for(Object[] reward:EducationandSanitizationList){
							label = new Label(9,a1+Integer.parseInt(reward[0].toString().substring(8,10)),reward[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
					if(otherExpenseList.size()>0){
						for(Object[] orherExp:otherExpenseList){
							label = new Label(10,a1+Integer.parseInt(orherExp[0].toString().substring(8,10)),orherExp[1].toString(),wcf3);
							ws.addCell(label);
						}
					}
				CellView cell = new CellView();
			    cell.setSize(8000);
			    ws.setColumnView(0, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
System.out.println(""+map.get("download_path").toString());
				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			/*	HMSUtil.generateReport("Advance_register", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());*/

				return null;
			
		}		
		
		
		public ModelAndView printDoubleColumnCashBook(HttpServletRequest request,
				HttpServletResponse response) {
			String fromDate="";
			String HospitalName="";
			HttpSession session =request.getSession();
			if(session.getAttribute("hospitalName")!=null){
				HospitalName=(String)session.getAttribute("hospitalName");
			}
			int hospitalId=0;
			if(session.getAttribute("hospitalId")!=null){
				hospitalId=(Integer)session.getAttribute("hospitalId");
			}
			String toDate="";
			Map<String,Object>map=new HashMap<String,Object>();
			Map<String,Object>mapForDataExcel=new HashMap<String,Object>();
			Map<String,Object>generalMap=new HashMap<String,Object>();
			if(request.getParameter(FROM_DATE)!=null){
				fromDate=(request.getParameter(FROM_DATE));
			}
			
			if(request.getParameter(TO_DATE)!=null){
				toDate=(request.getParameter(TO_DATE));
			}
			generalMap.put("fromDate", fromDate);
			generalMap.put("toDate", toDate);
			generalMap.put("hospitalId", hospitalId);
			map=accountHandlerService.printDoubleColumnCashBook(generalMap);
			List<Object[]>aList=new ArrayList<Object[]>();
			
			List<Object[]>TotalExpense=new ArrayList<Object[]>();
			
			
			
			
			if(map.get("aList")!=null){
				aList=(List<Object[]>)map.get("aList");
			}
			
				if(map.get("TotalExpense")!=null){
					TotalExpense=(List<Object[]>)map.get("TotalExpense");
				}
				
				
				System.out.println("aList.size()-------->>>>>"+aList.size());
			try{
				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition","attachment; filename=double_column_cash_book.xls");
				
				WritableWorkbook wb = Workbook.createWorkbook(response.getOutputStream());
				WritableSheet ws = wb.createSheet("PettyCash", 0);
				
				WritableFont wf = new WritableFont(WritableFont.ARIAL,15,WritableFont.BOLD);
				wf.setUnderlineStyle(UnderlineStyle.SINGLE);
				WritableCellFormat wcf = new WritableCellFormat(wf);
				wcf.setAlignment(Alignment.CENTRE);
				
				WritableFont wf2 = new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf2 = new WritableCellFormat(wf2);
				wcf2.setWrap(true);
				wcf2.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf2.setVerticalAlignment(VerticalAlignment.TOP);
				
				
				WritableFont wf21= new WritableFont(WritableFont.ARIAL,11,WritableFont.BOLD);
				WritableCellFormat wcf21 = new WritableCellFormat(wf2);
				wcf21.setWrap(false);
				wcf21.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf21.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf222 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
				WritableCellFormat wcf222 = new WritableCellFormat(wf222);
				wcf222.setWrap(true);
				wcf222.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf222.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf3 = new WritableFont(WritableFont.ARIAL,8);
				WritableCellFormat wcf3 = new WritableCellFormat(wf3);
				wcf3.setWrap(true);
/*				wcf3.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf3.setVerticalAlignment(VerticalAlignment.TOP);
*/				
				WritableFont wf4 = new WritableFont(WritableFont.ARIAL,8,WritableFont.BOLD);
				WritableCellFormat wcf4 = new WritableCellFormat(wf4);
				wcf4.setWrap(true);
				wcf4.setVerticalAlignment(VerticalAlignment.TOP);
				
				WritableFont wf22 = new WritableFont(WritableFont.ARIAL,8,WritableFont.NO_BOLD);
				WritableCellFormat wcf22 = new WritableCellFormat(wf22);
				wcf22.setWrap(true);
				wcf22.setBorder(Border.ALL, BorderLineStyle.THIN);
				wcf22.setVerticalAlignment(VerticalAlignment.TOP);
				
				ws.mergeCells(0,0,3,0);
				Label label = new Label(0,0,HospitalName,wcf);
				ws.addCell(label);

				ws.mergeCells(0,1,9,1);
				label = new Label(0,1,"Double Column Cash / Bank Book",wcf);
				ws.addCell(label);
				

				ws.mergeCells(0,1,3,1);
				label = new Label(0,2,"Receipt",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,2,"Payment",wcf);
				ws.addCell(label);
				

				ws.mergeCells(0,1,3,1);
				label = new Label(0,3,"Dr",wcf);
				ws.addCell(label);

				ws.mergeCells(4,5,7,5);
				label = new Label(8,3,"Cr",wcf);
				ws.addCell(label);
				
				
				
				
			/*	label = new Label(3,2,"Date :"+new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				/*ws.mergeCells(3,2,10,2);
				label = new Label(3,2,new SimpleDateFormat("dd/MM/yyyy").format(new Date()),wcf4);
				ws.addCell(label);*/
				
				label = new Label(0,4,"Date ",wcf2);
				ws.addCell(label);
				label = new Label(1,4,"Particulars",wcf2);
				ws.addCell(label);
				label = new Label(2,4,"V.S. No.",wcf2);
				ws.addCell(label);
				label = new Label(3,4,"L.F. No.",wcf2);
				ws.addCell(label);
				label = new Label(4,4,"Amount(Rs)",wcf2);
				ws.addCell(label);
				label = new Label(6,4,"Date ",wcf21);
				ws.addCell(label);
				label = new Label(7,4,"Particulars",wcf2);
				ws.addCell(label);
				label = new Label(8,4,"V.S. No.",wcf2);
				ws.addCell(label);
				label = new Label(9,4,"L.F. No.",wcf2);
				ws.addCell(label);
				label = new Label(10,4,"Amount",wcf2);
				ws.addCell(label);
/*				label = new Label(10,4,"Daily Balance",wcf2);
				ws.addCell(label);
*/				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");
				String time = (String)utilMap.get("currentTime");
				String month=currentDate.substring(3,5);
				String monthName=HMSUtil.getMonthName(month);
				int slNo=1;
				if(Integer.parseInt(month)==1||Integer.parseInt(month)==3 || Integer.parseInt(month)==5 || Integer.parseInt(month)==7 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 ||Integer.parseInt(month)==12){
					slNo=31;
				}
				else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4==0){
					slNo=29;
				}else if(Integer.parseInt(month)==2 && Integer.parseInt(currentDate.substring(6,10))%4!=0){
					slNo=28;
				}else if(Integer.parseInt(month)==4 || Integer.parseInt(month)==6 || Integer.parseInt(month)==9 || Integer.parseInt(month)==11){
					slNo=30;
				}
				
				
			int a=5;
			int a1=4;
			/*label = new Label(1,5,"1",wcf3);
			ws.addCell(label);
			label = new Label(1,6,"2",wcf3);
			ws.addCell(label);
			label = new Label(1,7,"3",wcf3);
			ws.addCell(label);
			label = new Label(1,8,"4",wcf3);
			ws.addCell(label);
			label = new Label(1,9,"5",wcf3);
			ws.addCell(label);
			label = new Label(1,10,"6",wcf3);
			ws.addCell(label);
			label = new Label(1,11,"7",wcf3);
			ws.addCell(label);
			label = new Label(1,12,"8",wcf3);
			ws.addCell(label);
			label = new Label(1,13,"9",wcf3);
			ws.addCell(label);
			label = new Label(1,14,"10",wcf3);
			ws.addCell(label);
			label = new Label(1,15,"11",wcf3);
			ws.addCell(label);
			label = new Label(1,16,"12",wcf3);
			ws.addCell(label);
			label = new Label(1,17,"13",wcf3);
			ws.addCell(label);
			label = new Label(1,18,"14",wcf3);
			ws.addCell(label);
			label = new Label(1,19,"15",wcf3);
			ws.addCell(label);
			label = new Label(1,20,"16",wcf3);
			ws.addCell(label);
			label = new Label(1,21,"17",wcf3);
			ws.addCell(label);
			label = new Label(1,22,"18",wcf3);
			ws.addCell(label);
			label = new Label(1,23,"19",wcf3);
			ws.addCell(label);
			label = new Label(1,24,"20",wcf3);
			ws.addCell(label);
			label = new Label(1,25,"21",wcf3);
			ws.addCell(label);
			label = new Label(1,26,"22",wcf3);
			ws.addCell(label);
			label = new Label(1,27,"23",wcf3);
			ws.addCell(label);
			label = new Label(1,28,"24",wcf3);
			ws.addCell(label);
			label = new Label(1,29,"25",wcf3);
			ws.addCell(label);
			label = new Label(1,30,"26",wcf3);
			ws.addCell(label);
			label = new Label(1,31,"27",wcf3);
			ws.addCell(label);
			label = new Label(1,32,"28",wcf3);
			ws.addCell(label);
			label = new Label(1,33,"29",wcf3);
			ws.addCell(label);
			label = new Label(1,34,"30",wcf3);
			ws.addCell(label);
			label = new Label(1,35,"31",wcf3);
			ws.addCell(label);*/

			
			label = new Label(3,20,"Total",wcf3);
			ws.addCell(label);
			
			
			BigDecimal sum=new BigDecimal(0);
			if(aList.size()>0){
					for(Object[] obj : aList){
					label = new Label(0,a1+Integer.parseInt(obj[0].toString().substring(8,10)),""+obj[0].toString().substring(8, 10).concat("/").concat(obj[0].toString().substring(5, 7)).concat("/").concat(obj[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					label=new Label(1, a, obj[2].toString(), wcf3);
					ws.addCell(label);
					label = new Label(2,a,"",wcf3);
					ws.addCell(label);
					label = new Label(3,a,"",wcf3);
					ws.addCell(label);
					label = new Label(4,a1+Integer.parseInt(obj[0].toString().substring(8,10)),obj[1].toString(),wcf3);
					
					sum=sum.add(new BigDecimal(obj[1].toString()));
					ws.addCell(label);	
					label = new Label(5,a,"",wcf3);
					ws.addCell(label);
					label = new Label(6,a,"",wcf3);
					ws.addCell(label);
					label = new Label(7,a,"",wcf3);
					ws.addCell(label);
					label = new Label(8,a,"",wcf3);
					ws.addCell(label);
					label = new Label(9,a,"",wcf3);
					ws.addCell(label);
					a++;
					slNo++;
					}
				}

			label = new Label(4,20,""+sum,wcf3);
			ws.addCell(label);
			
			BigDecimal sumTotal=new BigDecimal(0);
			
			if(TotalExpense.size()>0){
				for(Object[] totalExp:TotalExpense){
					label = new Label(6,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),""+totalExp[0].toString().substring(8, 10).concat("/").concat(totalExp[0].toString().substring(5, 7)).concat("/").concat(totalExp[0].toString().substring(0, 4)),wcf3);
					ws.addCell(label);
					
					label = new Label(10,a1+Integer.parseInt(totalExp[0].toString().substring(8,10)),totalExp[1].toString(),wcf3);
					ws.addCell(label);
					sumTotal=sumTotal.add(new BigDecimal(totalExp[1].toString()));
				}
			}
			
			label = new Label(10,20,""+sumTotal,wcf3);
			ws.addCell(label);
			
			
			
			
			
			
				CellView cell = new CellView();
			    cell.setSize(8000);
			    ws.setColumnView(0, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(2, cell);
			    
			    cell.setSize(6000);
			    ws.setColumnView(3, cell);
			    
			    cell.setSize(600);
			    ws.setColumnView(5, cell);
			    
			    cell.setSize(3000);
			    ws.setColumnView(7, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(10, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(11, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(12, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(13, cell);
			    
			    cell.setSize(2000);
			    ws.setColumnView(14, cell);
			    
			    cell.setSize(1500);
			    ws.setColumnView(15, cell);
			
				wb.write();
				wb.close();
				return null;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			try {
System.out.println(""+map.get("download_path").toString());
				response.setContentType("application/vnd.ms-excel");
				response.setHeader(
						"Content-Disposition",
						"attachment; filename="
								+ map.get("download_path").toString());
				File f = new File(map.get("download_path").toString());
				InputStream in = new FileInputStream(f);
				ServletOutputStream outs = response.getOutputStream();
				int bit = 256;
				int i = 0;
				while ((bit) >= 0) {
					bit = in.read();
					outs.write(bit);
				}
				outs.flush();
				outs.close();
				in.close();
				if (f.exists())
					f.delete();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			/*	HMSUtil.generateReport("Advance_register", parameters,
						(Connection) detailsMap.get("conn"), response,
						getServletContext());*/

				return null;
			
		}	
		public ModelAndView showWaitingListForVoucherApproval(HttpServletRequest request,HttpServletResponse response){
				int employeeLevel=0;
				int hospitalId=0;
				HttpSession session=request.getSession();
				if(session.getAttribute("employeeLevel")!=null){
					employeeLevel=(Integer)session.getAttribute("employeeLevel");
				}
				if(session.getAttribute("hospitalId")!=null){
					hospitalId=(Integer)session.getAttribute("hospitalId");
				}
			Map<String,Object>map=new HashMap<String,Object>();
			map=accountHandlerService.getWaitingListForVoucherApproval(employeeLevel,hospitalId);
			map.put("employeeLevel", employeeLevel);
			String jsp="waitingForVoucherApproval.jsp";
			
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	
		}
		public ModelAndView getDetailsForVoucherApproval(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			int voucherId=0;
			if(request.getParameter("voucherId")!=null){
				voucherId=Integer.parseInt(request.getParameter("voucherId"));
			}
			System.out.println("voucherId----"+request.getParameter("voucherId"));
			map=accountHandlerService.getDetailsForVoucherApproval(voucherId);
			String jsp="voucherApprovalDetails.jsp";

			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView 	aproveVoucher(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			int employeeLevel=0;
			int voucherId=0;
			if(request.getParameter("voucherId")!=null && !request.getParameter("voucherId").equals("0")){
				voucherId=Integer.parseInt(request.getParameter("voucherId"));
			}
			HttpSession session=request.getSession();
			if(session.getAttribute("employeeLevel")!=null){
				employeeLevel=(Integer)session.getAttribute("employeeLevel");
			}
			boolean approved=false;
			approved=accountHandlerService.aproveVoucher(employeeLevel,voucherId);
			String message="";
			if(approved==true){
				message="Voucher Approved Successfully!!";
			}else {
				message="Voucher Not Approved !!";

			}
			String jsp="voucherApprovalDetails.jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
	}
		public ModelAndView rejecttVoucher(HttpServletRequest request,HttpServletResponse response){
			Map<String,Object>map=new HashMap<String,Object>();
			int employeeLevel=0;
			int voucherId=0;
			if(request.getParameter("voucherId")!=null && !request.getParameter("voucherId").equals("0")){
				voucherId=Integer.parseInt(request.getParameter("voucherId"));
			}
			HttpSession session=request.getSession();
			if(session.getAttribute("employeeLevel")!=null){
				employeeLevel=(Integer)session.getAttribute("employeeLevel");
			}
			String remarksForReject="";
				
			if(request.getParameter("remarksForReject")!=null && !request.getParameter("remarksForReject").equals(""))
			{
				remarksForReject=request.getParameter("remarksForReject");
			}
			boolean approved=false;
			approved=accountHandlerService.rejectVoucher(employeeLevel,voucherId,remarksForReject);
			String message="";
			if(approved==true){
				message="Voucher Rejected Successfully!!";
			}else {
				message="Voucher Not Rejected !!";

			}
			String jsp="voucherApprovalDetails.jsp";

			map.put("contentJsp", jsp);
			map.put("message",message);
			return new ModelAndView("index", "map", map);
	}
		/*
		 * EMD Screen By Ujjwal
		 * 
		 */
		public ModelAndView showEMDRegisterJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int financialYearId = 0;
			if (session.getAttribute("financialYear") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear");
				box.put("fYear", financialYearId);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				box.put("locationId", locationId);
			}
			map = accountHandlerService.showEMDRegisterJsp(box);
			String jsp = "fa_emdRegister.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView submitEMDRegister(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int financialYearId = 0;
			if (session.getAttribute("financialYear") != null) {
				financialYearId = (Integer) session.getAttribute("financialYear");
				box.put("fYear", financialYearId);
			}
			if (session.getAttribute("locationId") != null) {
				int locationId = (Integer) session.getAttribute("locationId");
				box.put("locationId", locationId);
			}
			int userId = 0;
			if (session.getAttribute("userId") != null) {
				userId = (Integer) session.getAttribute("userId");
				box.put("userId", userId);
			}
			map = accountHandlerService.submitEMDRegister(box);
			boolean saved = false;
			String message = "";
			if (map.get("saved") != null) {
				saved = (Boolean) map.get("saved");
			}
			if (saved) {
				message = "EMD Register Saved Successfully.Do you want to print ?";
			} else {
				message = "Try Again!";
			}
			map.put("message", message);
			map.put("saved", saved);
			String jsp = "fa_emdRegister.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);

		}

		public ModelAndView editEMDRegister(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			int emdRegisterId = 0;
			if (request.getParameter("emdRegisterId") != null) {
				emdRegisterId = Integer.parseInt(request
						.getParameter("emdRegisterId"));
				box.put("emdRegisterId", emdRegisterId);
			}
			map = accountHandlerService.editEMDRegister(box);
			String jsp = "fa_emdRegister.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
}
