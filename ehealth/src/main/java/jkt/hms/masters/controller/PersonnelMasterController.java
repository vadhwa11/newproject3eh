package jkt.hms.masters.controller;

import static jkt.hms.util.RequestConstants.*;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_AMOUNT;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_CODE;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.PAY_ELEMENT_TYPE;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.GroupApplication;
import jkt.hms.masters.business.Hospital;
import jkt.hms.masters.business.HrEmployeeAddress;
import jkt.hms.masters.business.HrEmployeeExitInterview;
import jkt.hms.masters.business.HrEmployeePerformanceReview;
import jkt.hms.masters.business.HrExitInterviewAnswers;
import jkt.hms.masters.business.HrExitInterviewQuestionsMasters;
import jkt.hms.masters.business.HrPerformanceReviewRatings;
import jkt.hms.masters.business.MasAddressType;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasCadre;
import jkt.hms.masters.business.MasCaste;
import jkt.hms.masters.business.MasCategory;
import jkt.hms.masters.business.MasCostCenter;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasDistrict;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmpStatus;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasEmployeeCaste;
import jkt.hms.masters.business.MasEmployeeDepartment;
import jkt.hms.masters.business.MasEmployeeDependent;
import jkt.hms.masters.business.MasEmployeeSubCaste;
import jkt.hms.masters.business.MasEmployeeTemp;
import jkt.hms.masters.business.MasFormation;
import jkt.hms.masters.business.MasGrade;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasLsg;
import jkt.hms.masters.business.MasManufacturer;
import jkt.hms.masters.business.MasMaritalStatus;
import jkt.hms.masters.business.MasPostCode;
import jkt.hms.masters.business.MasRank;
import jkt.hms.masters.business.MasRankCategory;
import jkt.hms.masters.business.MasRecordOfficeAddress;
import jkt.hms.masters.business.MasReferralDoctor;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasReligion;
import jkt.hms.masters.business.MasServiceType;
import jkt.hms.masters.business.MasStoreBrand;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MasStoreItemGeneric;
import jkt.hms.masters.business.MasStream;
import jkt.hms.masters.business.MasTaluk;
import jkt.hms.masters.business.MasTitle;
import jkt.hms.masters.business.MasTrade;
import jkt.hms.masters.business.MasUnit;
import jkt.hms.masters.business.MasWard;
import jkt.hms.masters.business.MasWing;
import jkt.hms.masters.business.PhMasLocality;
import jkt.hms.masters.business.PhMasLocalityType;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.masters.handler.PersonnelMasterHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.EmployeeEducationComparator;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.employeeExperienceComprator;
import jkt.hrms.masters.business.HrEmployeeBalanceNew;
import jkt.hrms.masters.business.HrEmployeeExperience;
import jkt.hrms.masters.business.HrEmployeePayElements;
import jkt.hrms.masters.business.HrEmployeePayStructure;
import jkt.hrms.masters.business.HrEmployeePersonelDetails;
import jkt.hrms.masters.business.HrMasCourse;
import jkt.hrms.masters.business.HrMasEmployeeEducation;
import jkt.hrms.masters.business.HrMasInstitute;
import jkt.hrms.masters.business.HrMasLeave;
import jkt.hrms.masters.business.HrMasLeaveTypeMediator;
import jkt.hrms.masters.business.HrMasLeaveTypeNew;
import jkt.hrms.masters.business.HrMasPayElement;
import jkt.hrms.masters.business.HrMasPayroll;
import jkt.hrms.masters.business.HrMasQualification;
import jkt.hrms.masters.business.HrMasSpecialQualification;
import jkt.hrms.masters.business.MasEmployeeContract;
import jkt.hrms.masters.business.MasEmployeeType;
import jkt.hrms.masters.business.MasLocation;
import jkt.hrms.masters.business.UserManager;
import jkt.hrms.recruitment.handler.ResumeHandlerService;
import jkt.hrms.recruitment.masters.business.Resumepersonaldetails;
import jkt.hrms.util.HrmsRequestConstants;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class PersonnelMasterController extends MultiActionController {

	PersonnelMasterHandlerService personnelMasterHandlerService = null;
	CommonMasterHandlerService commonMasterHandlerService = null;
	ResumeHandlerService resumeHandlerService = null;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> generalMap = new HashMap<String, Object>();
	String jsp = "";
	String title = "";
	String message = "";
	String msgForCard = null;
	String url = "";
	String code = "";
	String name = "";
	Date dob;
	String gender = "";
	String address = "";
	String jspName = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoPropertyAddress = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	HttpSession session = null;

	// --------------------------------- Employee
	// Status------------------------------------------------

	public ModelAndView searchEmpStatus(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String empStatusCode = null;
		String empStatusName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empStatusName = request.getParameter(SEARCH_NAME);
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
			empStatusCode = searchField;
			empStatusName = null;

		} else {
			empStatusCode = null;
			empStatusName = searchField;
		}
		map = personnelMasterHandlerService.searchEmpStatus(empStatusCode,
				empStatusName);
		jsp = EMP_STATUS_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("empStatusCode", empStatusCode);
		map.put("empStatusName", empStatusName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showEmpStatusJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showEmpStatusJsp();
		@SuppressWarnings("unused")
		ArrayList searchEmpStatusList = (ArrayList) map
				.get("searchEmpStatusList");
		jsp = EMP_STATUS_JSP;
		jsp += ".jsp";
		title = "Employee Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmpStatus masEmpStatus = new MasEmpStatus();
		 
		int userId=0;
		HttpSession session=request.getSession();
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
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
		if (request.getParameter("pojoPropertyCode") != null) {
			pojoPropertyCode = request.getParameter("pojoPropertyCode");
		}
		Users user=new Users();
		user.setId(userId);
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List empStatusCodeList = new ArrayList();
		List empStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			empStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			empStatusNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((empStatusCodeList.size() == 0 || empStatusCodeList == null)
				&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {
			masEmpStatus.setEmpStatusCode(code);
			masEmpStatus.setEmpStatusName(name);
			masEmpStatus.setStatus("y");
			 
			masEmpStatus.setLastChgDate(currentDate);
			masEmpStatus.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addEmpStatus(masEmpStatus);
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
				|| (empStatusNameList.size() != 0) || empStatusNameList != null) {

			if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {

				message = "Employee Status Code  already exists.";
			} else if ((empStatusNameList.size() != 0 || empStatusNameList != null)
					&& (empStatusCodeList.size() == 0 || empStatusCodeList == null)) {

				message = "Employee Status Name already exists.";
			} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() != 0 || empStatusNameList != null)) {

				message = "Employee Status Code and Employee Status Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";

		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Add Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String empStatusCode = "";
		String empStatusName = "";
		int empStatusId = 0;
 		int userId=0;
		HttpSession session=request.getSession();
		Date changedDate = null;
		String changedTime = "";

		empStatusCode = (String) session.getAttribute("empStatusCode");
		empStatusName = (String) session.getAttribute("empStatusName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			empStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			empStatusCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			empStatusName = request.getParameter(SEARCH_NAME);
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
		Users user=new Users();
	     user.setId(userId);

		generalMap.put("id", empStatusId);
		generalMap.put("empStatusCode", empStatusCode);
		generalMap.put("name", empStatusName);
	 
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editEmpStatusToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {

			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";
		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Edit Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmpStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int empStatusId = 0;
		String message = null;
 		int userId=0;
		HttpSession session=request.getSession();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			empStatusId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteEmpStatus(
				empStatusId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmpStatusJsp";
		try {
			map = personnelMasterHandlerService.showEmpStatusJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMP_STATUS_JSP;
		title = "Delete EmployeeStatus";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------Employee Dependent
	// ---------------------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeDependentJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeDependentJsp();
		@SuppressWarnings("unused")
		ArrayList searchEmployeeDependentList = (ArrayList) map
				.get("searchEmployeeDependentList");
		jsp = HR_EMPLOYEE_DEPENDENT_JSP;
		jsp += ".jsp";
		title = "Employee Dependent";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmployeeDependent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmployeeDependent masEmployeeDependent = new MasEmployeeDependent();
		@SuppressWarnings("unused")
		int personnelcodeId = 0;
		int employeecodeId = 0;
		int relationcodeId = 0;
	    int userId=0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int gender = 0;
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		String pen="";
		if (request.getParameter(PEN) != null) {
			pen = request.getParameter(PEN);
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_DOB) != null) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EMPLOYEE_DEPENDENT_DOB));
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_GENDER) != null
				&& !request.getParameter(EMPLOYEE_DEPENDENT_GENDER).equals("0")) {
			gender = Integer.parseInt(request
					.getParameter(EMPLOYEE_DEPENDENT_GENDER));
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS) != null) {
			address = request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS);
		}
		if (request.getParameter(HOSPITAL_ID) != null) {
			personnelcodeId = Integer.parseInt(request
					.getParameter(HOSPITAL_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeecodeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(RELATION_ID) != null) {
			relationcodeId = Integer
					.parseInt(request.getParameter(RELATION_ID));
		}
		if(session.getAttribute("userId") != null){
			userId=(Integer)session.getAttribute("userId");
			
		}
		
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
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
		if (request.getParameter("pojoPropertyAddress") != null) {
			pojoPropertyAddress = request.getParameter("pojoPropertyAddress");
		}
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("pen", pen);
		generalMap.put("address", address);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyAddress", pojoPropertyAddress);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);

		List employeeDependentCodeList = new ArrayList();
		List employeeDependentNameList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentDOBList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentGenderList = new ArrayList();
		@SuppressWarnings("unused")
		List employeeDependentAddressList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			employeeDependentCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			employeeDependentNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		if (listMap.get("duplicateGeneralDOBList") != null) {
			employeeDependentDOBList = (List) listMap
					.get("duplicateGeneralDOBList");
		}
		if (listMap.get("duplicateGeneralGenderList") != null) {
			employeeDependentGenderList = (List) listMap
					.get("duplicateGeneralGenderList");
		}
		if (listMap.get("duplicateGeneralAddressList") != null) {
			employeeDependentAddressList = (List) listMap
					.get("duplicateGeneralAddressList");
		}
		boolean successfullyAdded = false;

		if (true) {
			masEmployeeDependent.setEmployeeDependentCode(code);
			masEmployeeDependent.setEmployeeDependentName(name);
			masEmployeeDependent.setDateOfBirth(dob);
			if (gender != 0) {
				masEmployeeDependent
						.setGender(new MasAdministrativeSex(gender));
			}

			masEmployeeDependent.setAddress(address);

			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeecodeId);
			masEmployeeDependent.setEmployee(masEmployee);
			 
			MasRelation masRelation = new MasRelation();
			masRelation.setId(relationcodeId);
			masEmployeeDependent.setRelation(masRelation);

			masEmployeeDependent.setStatus("y");
			Users user=new Users();
			user.setId(userId);
			
			masEmployeeDependent.setLastChgBy(user);
			masEmployeeDependent.setLastChgDate(currentDate);
			masEmployeeDependent.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addEmployeeDependent(masEmployeeDependent);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		}

		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_EMPLOYEE_DEPENDENT_JSP;
		title = "Add EmployeeDependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchEmployeeDependent(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchField = null;
		String employeeDependentCode = null;
		String employeeDependentName = null;
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
			employeeDependentCode = searchField;
			employeeDependentName = null;

		} else {
			employeeDependentCode = null;
			employeeDependentName = searchField;
		}
		map = personnelMasterHandlerService.searchEmployeeDependent(
				employeeDependentCode, employeeDependentName);
		jsp = HR_EMPLOYEE_DEPENDENT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("employeeDependentcodeCode", employeeDependentCode);
		map.put("employeeDependentcodeName", employeeDependentName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editEmployeeDependent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String employeeDependentCode = "";
		String employeeDependentName = "";
		Date dob = new Date();

		String employeeDependentAddress = "";
		int personnelcodeId = 0;

		int relationcodeId = 0;
		int employeeDependentcodeId = 0;
		Integer changedBy =null;
		Date changedDate = null;
		String changedTime = "";
		int employeeDependentGender = 0;
		int empNameId = 0;
		if (request.getParameter(HOSPITAL_ID) != null
				&& !(request.getParameter(HOSPITAL_ID).equals(""))) {
			personnelcodeId = Integer.parseInt(request
					.getParameter(HOSPITAL_ID));
		}

		if (request.getParameter(RELATION_ID) != null
				&& !(request.getParameter(RELATION_ID).equals(""))) {
			relationcodeId = Integer
					.parseInt(request.getParameter(RELATION_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
			empNameId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeDependentcodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			employeeDependentCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			employeeDependentName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_DOB) != null) {
			dob = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(EMPLOYEE_DEPENDENT_DOB));
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_GENDER) != null
				&& !(request.getParameter(EMPLOYEE_DEPENDENT_GENDER).equals(""))) {
			employeeDependentGender = Integer.parseInt(request
					.getParameter(EMPLOYEE_DEPENDENT_GENDER));
		}
		if (request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS) != null
				&& !(request.getParameter(EMPLOYEE_DEPENDENT_ADDRESS)
						.equals(""))) {
			employeeDependentAddress = request
					.getParameter(EMPLOYEE_DEPENDENT_ADDRESS);
		}
		if (session.getAttribute(USERID) != null ) {
			changedBy =(Integer)session.getAttribute(USERID);
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

		generalMap.put("id", employeeDependentcodeId);
		generalMap.put("employeeDependentCode", employeeDependentCode);
		generalMap.put("name", employeeDependentName);
		generalMap.put("empNameId", empNameId);
		generalMap.put("employeeDependentDOB", dob);
		generalMap.put("employeeDependentGender", employeeDependentGender);
		generalMap.put("employeeDependentAddress", employeeDependentAddress);
		generalMap.put("personnelcodeId", personnelcodeId);

		generalMap.put("relationcodeId", relationcodeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingEmployeeDependentNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingEmployeeDependentNameList.size() == 0) {
			try {
				dataUpdated = personnelMasterHandlerService
						.editEmployeeDependent(generalMap);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingEmployeeDependentNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_EMPLOYEE_DEPENDENT_JSP;
		title = "Edit Employee Dependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeeDependent(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeDependentcodeId = 0;
		String message = null;
 		int userId=0;
		HttpSession session=request.getSession();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeDependentcodeId = Integer.parseInt(request
					.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteEmployeeDependent(
				employeeDependentcodeId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";

		try {
			map = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_EMPLOYEE_DEPENDENT_JSP;
		title = "Delete EmployeeDependent";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------ Employee Contract
	// --------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeeContractJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeContractJsp();
		jsp = EMPLOYEE_CONTRACT_JSP;
		jsp += ".jsp";
		title = "Employee Contract";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchEmployeeContract(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		HttpSession session = request.getSession();
		MasHospital hospital = null;
		if (session.getAttribute(HOSPITAL) != null) {
			hospital = (MasHospital) session.getAttribute(HOSPITAL);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapEmployeeContract = new HashMap<String, Object>();
		Integer employeeId = null;
		String searchField = null;

		if (request.getParameter(EMPLOYEE_CODE) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_CODE));
		}
		map = personnelMasterHandlerService.searchEmployeeContract(employeeId);

		jsp = EMPLOYEE_CONTRACT_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addEmployeeContract(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		HttpSession session = request.getSession();
		MasHospital hospital = new MasHospital();
		Integer hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		Users users = (Users)session.getAttribute("users");
		hospital.setId(hospitalId);
		Integer employeeId = 0;
		Integer employeeContractId = 0;
		String agency = "";
		String category = "";
		String agreementType = "";
		Date agreementStartDate = null;
		Date agreementEndDate = null;
		String agreementRemarks = "";
		String documentsSubmitted = "";
		String agreementRules = "";

		session = request.getSession(true);

		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(EMPLOYEE_CONTRACT_ID) != null
				&& !request.getParameter(EMPLOYEE_CONTRACT_ID).equals("")) {
			employeeContractId = new Integer(
					request.getParameter(EMPLOYEE_CONTRACT_ID));
		}
		if (request.getParameter(AGENCY) != null) {
			agency = request.getParameter(AGENCY);
		}
		if (request.getParameter(CATEGORY) != null) {
			category = request.getParameter(CATEGORY);
		}
		if (request.getParameter(AGREEMENT_TYPE) != null) {
			agreementType = request.getParameter(AGREEMENT_TYPE);
		}
		if (request.getParameter(AGREEMENT_START_DATE) != null) {
			agreementStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(AGREEMENT_START_DATE));
		}
		if (request.getParameter(AGREEMENT_END_DATE) != null) {
			agreementEndDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(AGREEMENT_END_DATE));
		}
		if (request.getParameter(AGREEMENT_REMARKS) != null) {
			agreementRemarks = request.getParameter(AGREEMENT_REMARKS);
		}
		if (request.getParameter(DOCUMENTS_SUBMITTED) != null) {
			documentsSubmitted = request.getParameter(DOCUMENTS_SUBMITTED);
		}
		if (request.getParameter(AGREEMENT_RULES) != null) {
			agreementRules = request.getParameter(AGREEMENT_RULES);
		}
		String consolidatedSal="";
		if (request.getParameter("conSal") != null) {
			consolidatedSal = request.getParameter("conSal");
		}
		
		MasEmployeeContract masEmployeeContract = null;
		MasEmployee masEmployee = null;
		if (employeeContractId.equals(0)) {
			masEmployeeContract = new MasEmployeeContract();
			masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			masEmployeeContract.setEmployee(masEmployee);
		} else {
			masEmployeeContract = personnelMasterHandlerService
					.getEmployeeContract(employeeContractId);
		}

		//

		masEmployeeContract.setAgreementType(agreementType);
		masEmployeeContract.setCategory(category);
		masEmployeeContract.setAgreementStartDate(agreementStartDate);
		masEmployeeContract.setAgreementEndDate(agreementEndDate);
		masEmployeeContract.setAgency(agency);
		masEmployeeContract.setAgreementRemark(agreementRemarks);
		masEmployeeContract.setDocumentsSubmitted(documentsSubmitted);
		masEmployeeContract.setAgreementRules(agreementRules);
		masEmployeeContract.setHospital(hospital);
		masEmployeeContract.setStatus("y");
		masEmployeeContract.setConSalary(Integer.parseInt(consolidatedSal));
		masEmployeeContract.setLastChgBy(users);
		Boolean successfullyAdded = personnelMasterHandlerService
				.addEmployeeContract(masEmployeeContract);
		String message = "";

		if (successfullyAdded) {
			if (employeeContractId.equals(0)) {
				message = "Employee contract has been added for employee - "
						+ masEmployeeContract.getEmployee().getFirstName()
						+ "--"
						+ masEmployeeContract.getEmployee().getEmployeeCode();
			} else {
				message = "Employee contract has been updated successfuly for employee - "
						+ masEmployeeContract.getEmployee().getFirstName()
						+ "--"
						+ masEmployeeContract.getEmployee().getEmployeeCode();
			}
		} else {
			message = "Problem in adding employee contract !";
		}
		String jsp = EMPLOYEE_CONTRACT_JSP;
		jsp += ".jsp";
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeeContractJsp();
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeeContract(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeContractId = 0;
		String message = "";
	/*	String changedBy = "";*/
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(EMPLOYEE_CONTRACT_ID) != null
				&& !(request.getParameter(EMPLOYEE_CONTRACT_ID).equals(""))) {
			employeeContractId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CONTRACT_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		
Users changedBy= null;
		
		if (session.getAttribute("users") != null) {
			changedBy = (Users) session.getAttribute("users");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteEmployeeContract(
				employeeContractId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeDependentJsp";

		try {
			map = personnelMasterHandlerService.showEmployeeContractJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_CONTRACT_JSP;
		title = "Delete Employee Contract";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------ Employee Pay
	// Structure--------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeePayStructureJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeePayStructureJsp();
		jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		jsp += ".jsp";
		title = "Employee Pay Structure";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchEmployeePayStructure(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> mapEmployee = new HashMap<String, Object>();
		Integer employeeId = null;

		employeeId = new Integer(request.getParameter(EMPLOYEE_CODE));
		map1 = personnelMasterHandlerService.showEmployeePayStructureJsp();
		map = personnelMasterHandlerService
				.searchEmployeePayStructure(employeeId);
		map1.putAll(map);
		jsp = EMPLOYEE_PAY_STRUCTURE_JSP;

		jsp += ".jsp";
		map1.put("search", "search");
		map1.put("contentJsp", jsp);
		map1.put("title", title);
		// map.put("employeeCode",employeeCode);

		return new ModelAndView("index", "map", map1);
	}

	public ModelAndView addEmployeePayStructure(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Integer employeePayStructureId = 0;
		Integer employeeId = 0;
		Integer payrollId = 0;
		BigDecimal basicPay = new BigDecimal(0);
		String paymentMode = "";
		Date fromdate = null;
		Date toDate = null;

		session = request.getSession(true);

		if (request.getParameter(COMMON_ID) != null
				&& !request.getParameter(COMMON_ID).equals("")) {
			employeePayStructureId = new Integer(
					request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(PAYROLL_ID) != null) {
			payrollId = new Integer(request.getParameter(PAYROLL_ID));
		}
		if (request.getParameter(BASIC_PAY) != null) {
			basicPay = new BigDecimal(request.getParameter(BASIC_PAY));
		}
		if (request.getParameter(PAYMENT_MODE) != null) {
			paymentMode = request.getParameter(PAYMENT_MODE);
		}
		if (request.getParameter(PAY_STR_FROM_DATE) != null) {
			fromdate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PAY_STR_FROM_DATE));
		}
		if (request.getParameter(PAY_STR_TO_DATE) != null) {
			toDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PAY_STR_TO_DATE));
		}

		HrEmployeePayStructure employeePayStructure = null;
		if (employeePayStructureId.equals(0)) {
			employeePayStructure = new HrEmployeePayStructure();
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			employeePayStructure.setEmployee(masEmployee);
		} else {
			employeePayStructure = personnelMasterHandlerService
					.getEmployeePayStructure(employeePayStructureId);
		}

		HrMasPayroll payroll = new HrMasPayroll();
		payroll.setId(payrollId);

		if (!payrollId.equals(0)) {
			employeePayStructure.setPayroll(payroll);
		}
		employeePayStructure.setBasicPay(basicPay);
		employeePayStructure.setPaymentMode(paymentMode);
		employeePayStructure.setFromDate(fromdate);
		employeePayStructure.setToDate(toDate);
		employeePayStructure.setStatus("y");

		personnelMasterHandlerService
				.addEmployeePayStructure(employeePayStructure);
		String message = "";
		if (employeePayStructureId.equals(0)) {
			message = "Pay Structure has been added for employee - "
					+ employeePayStructure.getEmployee().getFirstName() + " "
					+ employeePayStructure.getEmployee().getLastName() + "--"
					+ employeePayStructure.getEmployee().getEmployeeCode();
		} else {
			message = "Pay Structure has been updated for employee - "
					+ employeePayStructure.getEmployee().getFirstName() + " "
					+ employeePayStructure.getEmployee().getLastName() + "--"
					+ employeePayStructure.getEmployee().getEmployeeCode();
		}
		String jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		jsp += ".jsp";
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeePayStructureJsp();
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeePayStructure(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeePayStructureId = 0;
		String message = "";
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
			employeePayStructureId = Integer.parseInt(request
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
		dataDeleted = personnelMasterHandlerService.deleteEmployeePayStructure(
				employeePayStructureId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeePayStructureJsp";

		try {
			map = personnelMasterHandlerService.showEmployeePayStructureJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_PAY_STRUCTURE_JSP;
		title = "Delete Employee Pay Structure";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------ Employee Pay
	// Elements--------------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showEmployeePayElementJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeePayElementsJsp();
		jsp = EMPLOYEE_PAY_ELEMENTS_JSP;
		jsp += ".jsp";
		title = "Employee Pay Elements";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchEmployeePayElement(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapEmployee = new HashMap<String, Object>();
		Integer employeeId = null;

		employeeId = new Integer(request.getParameter(EMPLOYEE_CODE));

		map = personnelMasterHandlerService
				.searchEmployeePayElement(employeeId);

		jsp = EMPLOYEE_PAY_ELEMENTS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		// map.put("employeeCode",employeeCode);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addEmployeePayElement(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Integer commonId = 0;
		Integer employeeId = 0;
		Integer payElementId = 0;
		BigDecimal payAmount = new BigDecimal(0);
		Date payElementStartDate = null;
		String payElementType = "";
		Integer companyId=0;
		session = request.getSession(true);
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			companyId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		if (request.getParameter(COMMON_ID) != null
				&& request.getParameter(COMMON_ID) != "") {
			commonId = new Integer(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_ID));
		}
		if (request.getParameter(PAY_ELEMENT_CODE) != null) {
			payElementId = new Integer(request.getParameter(PAY_ELEMENT_CODE));
		}
		if (request.getParameter(PAY_AMOUNT) != null) {
			payAmount = new BigDecimal(request.getParameter(PAY_AMOUNT));
		}
		if (request.getParameter(PAY_ELEMENT_START_DATE) != null) {
			payElementStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PAY_ELEMENT_START_DATE));
		}
		if (request.getParameter(PAY_ELEMENT_TYPE) != null) {
			payElementType = request.getParameter(PAY_ELEMENT_TYPE);
		}
		HrEmployeePayElements employeePayElement = null;
		if (commonId.equals(0)) {
			employeePayElement = new HrEmployeePayElements();
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			employeePayElement.setEmployee(masEmployee);

		} else {
			employeePayElement = personnelMasterHandlerService
					.getEmployeePayElement(commonId);

		}

		if (!payElementId.equals(0)) {
			HrMasPayElement payElement = new HrMasPayElement();
			payElement.setId(payElementId);
			employeePayElement.setPayElement(payElement);
		}
		employeePayElement.setCompany(new MasHospital(companyId));
		employeePayElement.setPayAmount(payAmount);
		employeePayElement.setPayElementType(payElementType);
		employeePayElement.setStartDate(payElementStartDate);
		employeePayElement.setStatus("y");
		String message = "";
		Map returnMap = new HashMap();
		try {
			returnMap = personnelMasterHandlerService
					.addEmployeePayElement(employeePayElement);
			if (commonId.equals(0)) {
				message = "Employee Pay Element has been added successfully for employee -- "
						+ employeePayElement.getEmployee().getFirstName();
			} else {
				message = "Employee Pay Element has been modified succesfuly for employee --"
						+ employeePayElement.getEmployee().getFirstName();
			}
		} catch (Exception e) {
			message = "Oops..!!Problem in the transaction !!";
			e.printStackTrace();
		}
		if (returnMap.get("messageForDuplicate") != null) {
			message = (String) returnMap.get("messageForDuplicate");
		}
		String jsp = EMPLOYEE_PAY_ELEMENTS_JSP;
		jsp += ".jsp";
		Map<String, Object> map = personnelMasterHandlerService
				.showEmployeePayElementsJsp();
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeePayElement(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeePayElementId = 0;
		String message = "";
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
			employeePayElementId = Integer.parseInt(request
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
		dataDeleted = personnelMasterHandlerService.deleteEmployeePayElement(
				employeePayElementId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeePayElementJsp";

		try {
			map = personnelMasterHandlerService.showEmployeePayElementsJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_PAY_ELEMENTS_JSP;
		title = "Delete Employee Pay Element";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showAddEmployeePayElementJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map =personnelMasterHandlerService.showAddEmployeePayElementJsp();
		jsp = "hr_addEmployeePayelement";
		jsp += ".jsp";
		title = "Employee Pay Elements";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}
	public ModelAndView addMultipleEmployeePayElement(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List payElementIdList = new ArrayList();
		List payelementEmployeeList = new ArrayList();
		List payElementAmountList = new ArrayList();
		List payElementStartDateList = new ArrayList();
		List payElementTypeList = new ArrayList();
		List changedByList = new ArrayList();
		List currentTimeList = new ArrayList();
		List currentDateList = new ArrayList();

		int noOfPayElement = 0;
		if (request.getParameter("counter") != null) {
			noOfPayElement = Integer.parseInt(request.getParameter("counter"));
		}
		String changedBy = "";
		Date currentDate = null;
		String currentTime = "";
		for (int j = 0; j <noOfPayElement; j++) {
			if (request.getParameter("payElementId" + j) != null) {
				payElementIdList.add(Integer.parseInt(request.getParameter(PAY_ELEMENT_ID + j)));

				if (request.getParameter(EMPLOYEE_ID) != null) {
					payelementEmployeeList.add(Integer.parseInt(request.getParameter(EMPLOYEE_ID )));
				}


				if (request.getParameter("payElementAmount" + j) != null) {
					payElementAmountList.add(new BigDecimal(request.getParameter("payElementAmount" + j)));
				}

				if (request.getParameter("payElementType" + j) != null) {
					payElementTypeList.add(request.getParameter("payElementType" + j));
				}
				if (request.getParameter(PAY_ELEMENT_START_DATE + j) != null) {
					payElementStartDateList.add(request.getParameter(PAY_ELEMENT_START_DATE + j));
				}
				if (request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))) {
					changedByList.add(request.getParameter(CHANGED_BY));
				}


				if (request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))) {
					currentDateList.add(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE)));
				}


				if (request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))) {
					currentTimeList.add(request.getParameter(CHANGED_TIME));
				}

			}

		}
		generalMap.put("changedByList", changedByList);
		generalMap.put("currentDateList", currentDateList);
		generalMap.put("currentTimeList", currentTimeList);
		generalMap.put("payElementIdList", payElementIdList);
		generalMap.put("payelementEmployeeList", payelementEmployeeList);
		generalMap.put("payElementAmountList", payElementAmountList);
		generalMap.put("payElementTypeList", payElementTypeList);
		generalMap.put("payElementStartDateList", payElementStartDateList);

		 map = personnelMasterHandlerService.addMultipleEmployeePayElement(generalMap);
		jsp = "hr_addEmployeePayelement";
		jsp += ".jsp";
		title = "Employee Pay Elements";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}


	// ----------------------------------------
	// Employee-----------------------------------------
 
	public ModelAndView showEmployeeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		 session = request.getSession(true);
		 int hospitalId = 0;
	
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		int userType = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 dataMap.put("userId", user.getId());
		}
		dataMap.put("userType", userType);
		
		Map<String, Object> map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		Map<String, Object> empDepMap = null;
		Map<String, Object> empAdd_valMap = new HashMap<String, Object>();
		try {
			empDepMap = personnelMasterHandlerService.showEmployeeDependentJsp();
			empAdd_valMap = personnelMasterHandlerService.getListForEmpAddress();
					

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.putAll(empDepMap);
		map.put("empAdd_valMap", empAdd_valMap);
		List joinedCandidates = resumeHandlerService.getJoinedCandidates();
		jsp = EMPLOYEE_JSP;
		jsp += ".jsp";
		title = "Employee";
		map.put("joinedCandidates", joinedCandidates);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showAllJoinedCandidate(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute(USERS) == null) {
			return new ModelAndView("index");
		}

		Users user = (Users) session.getAttribute(USERS);
		MasEmployee employee = user.getEmployee();
		List approvedLeavesList = resumeHandlerService.getJoinedCandidates();

		Map<String, Object> map = new HashMap<String, Object>();

		// map.put(MAIN,APPROVED_LEAVES_JSP);
		// map.put(TITLE,"Approved Leaves");

		map.put("approvedLeavesList", approvedLeavesList);
		// map.put("approvedLeavesEncashment", approvedLeavesEncashment);

		String jsp = ALL_JOINED_CANDIDATE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmployee(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapEmployee = new HashMap<String, Object>();
		String employeeCode = null;
		String firstName = null;
		String lastName = null;
		String searchField = null;
		int hospitalId = 0;
		if(request.getParameter("bsScInst")!=null){
			hospitalId = Integer.parseInt(request.getParameter("bsScInst"));
		}else if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
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
		}
		/*if (searchRadio == 1) {
			employeeCode = searchField;
			firstName = null;
			lastName = null;
		} else if (searchRadio == 2) {
			employeeCode = null;
			firstName = searchField;
			lastName = null;
		} else if (searchRadio == 3) {
			employeeCode = null;
			firstName = null;
			lastName = searchField;
		}*/
		
		if (searchRadio == 1) {
			employeeCode = searchField;
			firstName=null;
		} else if (searchRadio == 2) {
			employeeCode = null;
			firstName = searchField;
			
		} 

		mapEmployee = personnelMasterHandlerService.searchEmployee(employeeCode,
				firstName, lastName,hospitalId);
		
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
		if(mapEmployee.get("searchEmployeeList")!=null){
			searchEmployeeList = (List<MasEmployee>)mapEmployee.get("searchEmployeeList");
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		int userType = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 dataMap.put("userId", user.getId());
		}
		dataMap.put("userType", userType);

		Map<String, Object> empAdd_valMap = new HashMap<String, Object>();
		empAdd_valMap = personnelMasterHandlerService.getListForEmpAddress();
		map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		map.put("searchEmployeeList", searchEmployeeList);
		map.put("empAdd_valMap", empAdd_valMap);
		jsp = EMPLOYEE_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("employeeCode", employeeCode);
		map.put("firstName", firstName);
		map.put("lastName", lastName);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDep = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MasEmployee masEmployee = new MasEmployee();
		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int titleId = 0;
		int departmentId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String permanentAddress = "";
		String residentialAddress = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String email = "";
		String employeeUrl = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountCode = "";
		String bankAccountNumber = "";
		String employeePhoto = "";
		String changedBy = "";
		Date joinDate = new Date();
		Date currentDate = new Date();

		// for employee education
		Integer qualificationId = 0;
		Integer courseId = 0;
		Integer splQualificationId = 0;
		Integer instituteId = 0;
		Date startDate = null;
		Date endDate = null;
		Integer courseDuration = 0;
		String courseDurationUnit = "";
		Date qualifiedDate = null;
		String awards = "";
		String[] primarySkills = null;
		String[] secondarySkills = null;

		// for employee dependent
		String employeeDependentCode = "";
		String employeeDependentName = "";
		Date dob = new Date();
		String employeeDependentGender = "";
		String employeeDependentAddress = "";
		int personnelcodeId = 0;
		int employeecodeId = 0;
		int relationcodeId = 0;
		int employeeDependentcodeId = 0;
		String nextEmployeeCode = "";
		session = request.getSession(true);
		int hospitalId = 0;
		
		if(request.getParameter("hospitalId")!=null){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(EMPLOYEE_JOB_CODE) != null) {
			jobCode = request.getParameter(EMPLOYEE_JOB_CODE);
		}
		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}
		if (request.getParameter(JOIN_DATE) != null
				&& !(request.getParameter(JOIN_DATE).equals(""))) {
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (!request.getParameter(COST_CENTER_ID).equals("0")) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EMPLOYEE_PERMANENT_ADDRESS) != null) {
			permanentAddress = request.getParameter(EMPLOYEE_PERMANENT_ADDRESS);
		}
		if (request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS) != null) {
			residentialAddress = request
					.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accounthead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}

		if (request.getParameter(QUALIFICATION) != null) {
			qualificationId = new Integer(request.getParameter(QUALIFICATION));
		}
		if (request.getParameter(COURSES_NAME) != null) {
			courseId = new Integer(request.getParameter(COURSES_NAME));
		}
		if (request.getParameter(SPL_QUALIFICATION) != null) {
			splQualificationId = new Integer(
					request.getParameter(SPL_QUALIFICATION));
		}
		if (request.getParameter(INSTITUTION) != null) {
			instituteId = new Integer(request.getParameter(INSTITUTION));
		}
		if (request.getParameter(START_DATE) != null) {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE));
		}
		if (request.getParameter(END_DATE) != null) {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE));
		}
		if (request.getParameter(COURSES_DURATION) != null) {
			courseDuration = new Integer(request.getParameter(END_DATE));
		}
		if (request.getParameter(COURSES_DURATION_UNIT) != null) {
			courseDurationUnit = request.getParameter(COURSES_DURATION_UNIT);
		}
		if (request.getParameter(QUALIFIED_DATE) != null) {
			qualifiedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(QUALIFIED_DATE));
		}
		if (request.getParameter(AWARDS) != null) {
			awards = request.getParameter(AWARDS);
		}

		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Users users= null;
		if (session.getAttribute("users") != null) {
			users =  (Users) session.getAttribute("users");
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
		List employeeCodeList = new ArrayList();
		List employeeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			employeeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			employeeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAddedEmp = false;
		boolean successfullyAddedEmpDep = false;
		if ((employeeCodeList.size() == 0) && (employeeNameList.size() == 0)) {
			masEmployee.setEmployeeCode(code);
			masEmployee.setServiceNo(serviceNo);
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setUrl(employeeUrl);
			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}
			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}
			
			/*if (departmentId != 0) {
				MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
				masEmployeeDepartment.setId(departmentId);
				masEmployee.setEmployeeDepartment(masEmployeeDepartment);
			}*/
			if (empStatusId != 0) {
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmployeeStatus(masEmpStatus);
			}

			if (costCenterId != 0) {
				MasCostCenter masCostCenter = new MasCostCenter();
				masCostCenter.setId(costCenterId);
				masEmployee.setCostCenter(masCostCenter);
			}
			if (empCategoryId != 0) {
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				masEmployee.setEmpCategory(masEmpCategory);
			}
			if (gradeId != 0) {
				MasGrade masGrade = new MasGrade();
				masGrade.setId(gradeId);
				masEmployee.setGrade(masGrade);
			}

			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				masEmployee.setRank(masRank);
			}
			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				masEmployee.setUnit(masUnit);
			}
			if (tradeId != 0) {
				MasTrade masTrade = new MasTrade();
				masTrade.setId(tradeId);
				masEmployee.setTrade(masTrade);
			}
			

			masEmployee.setJobCode(jobCode);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setPermanentAddress(permanentAddress);
			masEmployee.setResidentialAddress(residentialAddress);
			masEmployee.setEmail(email);
			masEmployee.setTelNoEmergency(emergencyTellNumber);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			masEmployee.setBankCode(bankCode);
			masEmployee.setAccountHead(accounthead);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setBankAccountCode(bankAccountCode);
			masEmployee.setEmpCategory(new MasEmpCategory(1));
			
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			masEmployee.setHospital(masHospital);

			masEmployee.setStatus("Y");
			masEmployee.setLastChgBy(users);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);
			

			// emp education
			/*
			 * HrMasEmployeeEducation employeeEducation = new
			 * HrMasEmployeeEducation();
			 *
			 * employeeEducation.setQualificationId(qualificationId);
			 * employeeEducation.setCourseId(courseId);
			 * employeeEducation.setSplQualificationId(splQualificationId);
			 * employeeEducation.setInstituteId(instituteId);
			 * employeeEducation.setStartDate(startDate);
			 * employeeEducation.setEndDate(endDate);
			 * employeeEducation.setCourseDuration(courseDuration);
			 * employeeEducation.setQualifiedDate(qualifiedDate);
			 * employeeEducation.setAwards(awards);
			 * //employeeEducation.setMasEmployee(masEmployee);
			 * masEmployee.setEmployeeEducation(employeeEducation);
			 *
			 * HrEmployeeExperience employeeExperience =
			 * setAndGetEmployeeExperience(request);
			 * //employeeExperience.setMasEmployee(masEmployee);
			 * masEmployee.setEmployeeExperience(employeeExperience);
			 */
			Map<String, Object> mapCode = new HashMap<String, Object>();

			mapCode = personnelMasterHandlerService.addEmployee(masEmployee,hospitalId);
			nextEmployeeCode = (String) mapCode.get("nextEmployeeCode");
			;
			successfullyAddedEmp = (Boolean) mapCode
					.get("successfullyAddedEmp");
			;

			if (successfullyAddedEmp == true) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if (employeeNameList.size() != 0) {
			message = "Employee Code already exists.";

		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
			mapDep = personnelMasterHandlerService.showEmployeeDependentJsp();
			map.putAll(mapDep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Add Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	/*public ModelAndView addEmployeeCliniRx(HttpServletRequest request,
			HttpServletResponse response) {
		Integer hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDep = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int empCategoryId = 0;
		int employeeTypeId = 0;
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int titleId = 0;
		String empCode = "";
		String cardNo = "";
		String salaryStatus = "";
		int departmentId = 0;
		// int costCenterId = 0;
		int empStatusId = 0;
    	int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		// int tradeId = 0;
		// String serviceNo = "";
		String permanentAddress = "";
		String residentialAddress = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		// String jobCode = "";
		String email = "";
		String employeeUrl = "";
		String bankCode = "";
		String accounthead = "";
		String bankAccountCode = "";
		String bankAccountNumber = "";
		String employeePhoto = "";
		String changedBy = "";
		Date joinDate = new Date();
		Date currentDate = new Date();
		Integer applicantId = 0;
		// for employee dependent
		String employeeDependentCode = "";
		String employeeDependentName = "";
		Date dob = new Date();
		String employeeDependentGender = "";
		String employeeDependentAddress = "";
		String viewAllDepartment="";
		int personnelcodeId = 0;
		int employeecodeId = 0;
		int relationcodeId = 0;
		int employeeDependentcodeId = 0;
		int employeeId = 0;
		int genderId = 0;
		Integer managerId = null;
		Boolean employeeTypeChanged = false;
		MasEmployee masEmployee = null;
		String nextEmployeeCode = "";
		session = request.getSession(true);

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(APPLICANT_ID) != null
				&& !request.getParameter(APPLICANT_ID).equals("")) {
			applicantId = new Integer(request.getParameter(APPLICANT_ID));
		}
		if (request.getParameter(EMPLOYEE_TYPE) != null
				&& !request.getParameter(EMPLOYEE_TYPE).equals("")) {
			employeeTypeId = new Integer(request.getParameter(EMPLOYEE_TYPE));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter(VIEW_ALL_DEPARTMENT) != null) {
			viewAllDepartment = request.getParameter(VIEW_ALL_DEPARTMENT).trim();
		}
		if (((request.getParameter(VIEW_ALL_DEPARTMENT)) != null)
				&& ((request.getParameter(VIEW_ALL_DEPARTMENT)).equalsIgnoreCase("on"))) {
			viewAllDepartment="y";
		} else {
			viewAllDepartment="n";
		}
		if (request.getParameter("managerId") != null
				&& !request.getParameter("managerId").equals("")) {
			managerId = new Integer(request.getParameter("managerId"));
		}
		if (request.getParameter(EMPLOYEE_CATEGORY_ID) != null
				&& !request.getParameter(EMPLOYEE_CATEGORY_ID).equals("")) {

		}
		if (request.getParameter(EMPLOYEE_CARD_NO) != null) {
			cardNo = request.getParameter(EMPLOYEE_CARD_NO);
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}

		if (request.getParameter(APPOINTMENT_DATE) != null
				&& !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}
		if (request.getParameter(JOIN_DATE) != null
				&& !(request.getParameter(JOIN_DATE).equals(""))) {
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}

		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter(SALARY_STATUS) != null
				&& !request.getParameter(SALARY_STATUS).equals("")) {
			salaryStatus = request.getParameter(SALARY_STATUS);
		}
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		int locationId = 0;
		if (request.getParameter(LOCATION) != null
				&& !request.getParameter(LOCATION).equals("0")) {
			locationId = Integer.parseInt(request.getParameter(LOCATION));
		}
		String relativeName = "";
		if (request.getParameter(RELATIVE_NAME) != null) {
			relativeName = request.getParameter(RELATIVE_NAME);
		}
		int religionId = 0;
		if (request.getParameter(RELIGION_ID) != null
				&& !request.getParameter(RELIGION_ID).equals("0")) {
			religionId = Integer.parseInt(request.getParameter(RELIGION_ID));
		}
		int casteId = 0;
		if (request.getParameter(CASTE_ID) != null
				&& !request.getParameter(CASTE_ID).equals("0")) {
			casteId = Integer.parseInt(request.getParameter(CASTE_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(EMPLOYEE_PERMANENT_ADDRESS) != null) {
			permanentAddress = request.getParameter(EMPLOYEE_PERMANENT_ADDRESS);
		}
		if (request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS) != null) {
			residentialAddress = request
					.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accounthead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(EMPLOYEE_CATEGORY_ID) != null
				&& !request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (request.getParameter(GENDER) != null
				&& !request.getParameter(GENDER).equals("0")) {
			genderId = Integer.parseInt(request.getParameter(GENDER));
		}
		if (request.getParameter(EMPLOYEE_GRADE_ID) != null
				&& !request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (request.getParameter(UNIT_ID) != null
				&& !request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
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
		List employeeCodeList = new ArrayList();
		List employeeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			employeeCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			employeeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		boolean successfullyAddedEmpDep = false;
		// (employeeCodeList.size() == 0 ) && (employeeNameList.size() == 0 )
		if (true) {
			if (employeeId != 0) {
				masEmployee = personnelMasterHandlerService
						.getEmployee(employeeId);
				if (!masEmployee.getEmployeeType().getId()
						.equals(employeeTypeId)) {
					employeeTypeChanged = true;
				}
				// masEmployee.setId(employeeId);
			} else {
				masEmployee = new MasEmployee();
			}
			MasEmployeeType masEmployeeType = new MasEmployeeType();
			masEmployeeType.setId(employeeTypeId);
			masEmployee.setEmployeeType(masEmployeeType);

			// masEmployee.setServiceNo(serviceNo);
			// masEmployee.set
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setUrl(employeeUrl);
			//masEmployee.setViewAllDepartment(viewAllDepartment);
			if (titleId != 0) {
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}

			if (departmentId != 0) {
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}
			if (empStatusId != 0) {
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmployeeStatus(masEmpStatus);
			}

			if (empCategoryId != 0) {
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				masEmployee.setEmpCategory(masEmpCategory);
			}

			if (rankId != 0) {
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				masEmployee.setRank(masRank);
			}
			if (religionId != 0) {
				MasReligion masReligion = new MasReligion();
				masReligion.setId(religionId);
				masEmployee.setReligion(masReligion);
			}
			if (casteId != 0) {
				MasCaste masCaste = new MasCaste();
				masCaste.setId(casteId);
				masEmployee.setCaste(masCaste);
			}
			if (locationId != 0) {
				//masEmployee.setLocationId(locationId);
			}
			if (genderId != 0) {
				MasAdministrativeSex gender = new MasAdministrativeSex();
				gender.setId(genderId);
				//masEmployee.setGender(gender);
			}
			if (gradeId != 0) {
				MasGrade grade = new MasGrade();
				grade.setId(gradeId);
				masEmployee.setGrade(grade);
			}
			if (unitId != 0) {
				MasUnit masUnit = new MasUnit();
				masUnit.setId(unitId);
				masEmployee.setUnit(masUnit);
			}

			masEmployee.setSalaryStatus(salaryStatus);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setPermanentAddress(permanentAddress);
			masEmployee.setResidentialAddress(residentialAddress);
			masEmployee.setEmail(email);
			masEmployee.setTelNoEmergency(emergencyTellNumber);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			masEmployee.setBankCode(bankCode);
			masEmployee.setAccountHead(accounthead);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setBankAccountCode(bankAccountCode);
			//masEmployee.setRelativeName(relativeName);
			if (!cardNo.equals("")) {
				masEmployee.setCardNo(cardNo);
			}

			int personnelId = (Integer) session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(personnelId);
			masEmployee.setHospital(masHospital);

			masEmployee.setStatus("y");
			masEmployee.setLastChgBy(changedBy);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);
			String lastAddedEmployeeCode = "";
			String codeString = "";
			String currentEmployeeCode = "";
			if (employeeId == 0) {
				// MasEmployee lastAddedEmployee =
				// personnelMasterHandlerService.getLastAddedEmployee();
				// if(lastAddedEmployee.getEmployeeCode()!=null&&!lastAddedEmployee.getEmployeeCode().equals("")){
				// lastAddedEmployeeCode = lastAddedEmployee.getEmployeeCode();
				//
				// Integer employeeCodeSeries =new Integer(0);
				// try{
				// employeeCodeSeries=new
				// Integer(lastAddedEmployeeCode.substring(3, 7));
				// }
				// catch (Exception e) {
				// // TODO: handle exception
				// }
				// employeeCodeSeries++;
				// codeString = employeeCodeSeries.toString();
				//
				// }
				// if(codeString.length() == 1)
				// {
				// currentEmployeeCode = "000"+codeString;
				// }
				// if(codeString.length() == 2)
				// {
				// currentEmployeeCode = "00"+codeString;
				// }
				// if(codeString.length() == 3)
				// {
				// currentEmployeeCode = "0" + codeString;
				// }
				// if(codeString.length() == 4)
				// {
				// currentEmployeeCode = codeString;
				// }
				//
				//
				//
				// MasHospital company =
				// personnelMasterHandlerService.getCompany(hospitalId);
				// String companyCode = company.getHospitalCode();
				//
				// MasEmployeeType employeeType =
				// personnelMasterHandlerService.getEmployeeType(employeeTypeId);
				//
				// empCode = companyCode + employeeType.getTypeCode() +
				// currentEmployeeCode ;
				// masEmployee.setEmployeeCode(empCode);

			} else {
				// if(employeeTypeChanged.equals(true))
				// {
				// String previousEmployeeCode = masEmployee.getEmployeeCode();
				// String companyCode = previousEmployeeCode.substring(0, 2);
				// String typeCode = previousEmployeeCode.substring(2, 3);
				// String employeeCode = previousEmployeeCode.substring(3, 7);
				//
				// MasEmployeeType employeeType =
				// personnelMasterHandlerService.getEmployeeType(employeeTypeId);
				// empCode = companyCode + employeeType.getTypeCode() +
				// employeeCode;
				// masEmployee.setEmployeeCode(empCode);
				//
				// }
			}
			String msgForCard = null;

			HrEmployeePersonelDetails employeePersonelDetails = null;
			employeePersonelDetails = setAndGetEmployeePersonelDetails(
					masEmployee, request);
			personnelMasterHandlerService
					.addEmployeePersonelDetails(employeePersonelDetails);

			HrEmployeeExperience employeeExperience = null;
			employeeExperience = setAndGetEmployeeExperience(masEmployee,
					request);
			personnelMasterHandlerService
					.addEmployeeExperience(employeeExperience);

			masEmployee.setEmployeePersonalDetails(employeePersonelDetails);
			masEmployee.setEmployeeExperience(employeeExperience);
			try {
				Map<String, Object> mapEmp = new HashMap<String, Object>();

				mapEmp = personnelMasterHandlerService.addEmployee(masEmployee,hospitalId);
				successfullyAdded = (Boolean) mapEmp.get("successfullyAdded");
				nextEmployeeCode = (String) mapEmp.get("nextEmployeeCode");

				UserManager userManager = null;
				List managerList = null;
				if (employeeId == 0) {
					userManager = new UserManager();
				} else {
					Set set = masEmployee.getUserManager();
					if (set != null && !set.isEmpty()) {
						managerList = new ArrayList(set);
						userManager = (UserManager) managerList.get(0);
					} else {
						userManager = new UserManager();
					}
				}

				MasEmployee manager = new MasEmployee();
				manager.setId(managerId);
				userManager.setManagers(manager);
				userManager.setManagerId(managerId);

				if (masEmployee != null) {
					MasEmployee user = new MasEmployee();
					user.setId(masEmployee.getId());
					userManager.setUsers(user);
					userManager.setEmpId(masEmployee.getId());
				}

				personnelMasterHandlerService.addUserManager(userManager);

				Set educationSet = masEmployee.getEmployeeEducation();
				List<HrMasEmployeeEducation> educationList = null;

				if (educationSet != null) {
					educationList = new ArrayList(educationSet);
				}
				for (int i = 0; i < educationList.size(); i++) {

					HrMasEmployeeEducation employeeEducation = null;
					employeeEducation = educationList.get(i);

					employeeEducation = setAndGetEmployeEducation(
							employeeEducation, request, i);

					employeeEducation.setEmployee(masEmployee);
					personnelMasterHandlerService
							.addEmployeeEducation(employeeEducation);
				}

			} catch (DataIntegrityViolationException e) {
				msgForCard = "Card No already occupied . Please enter another card no.";
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (successfullyAdded == true) {

				if (!applicantId.equals(0)) {
					// Resumepersonaldetails resume =
					// masEmployee.getResumepersonaldetails();
					// Resumestatus resumestatus = resume.getResumeStatus();
					// resumestatus.getResumestatusmaster().setId(19);
					// Resumestatushistory resumeStatusHistory =
					// resume.getResumeStatusHistory();
					// resumeStatusHistory.getResumestatusmaster().setId(19);
					// resumeHandlerService.addResumeStatus(resumestatus,
					// resumeStatusHistory);
					message = "Applicant Added Successfully !! \n Employee Code generated : "
							+ nextEmployeeCode;
				} else {
					message = "New Employee Added Successfully !! \n Employee Code generated : "
							+ nextEmployeeCode;
				}

			} else {
				message = "Try Again !!";
			}
		} else if (employeeNameList.size() != 0) {
			message = "Employee Code already exists.";

		}

		if (employeeId != 0) {

			message = "Record Updated Successfully";
			if (employeeTypeChanged.equals(true)) {
				message += " and new Employee Code generated is "
						+ nextEmployeeCode;
			}

		}
		if (msgForCard != null) {
			message = msgForCard;
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			map = personnelMasterHandlerService.showEmployeeJsp(hospitalId);
			mapDep = personnelMasterHandlerService.showEmployeeDependentJsp();
			map.putAll(mapDep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Add Employee";
		jsp += ".jsp";
		List joinedCandidates = resumeHandlerService.getJoinedCandidates();
		map.put("joinedCandidates", joinedCandidates);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
*/
	
	
	public ModelAndView addEmployeeCliniRx(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDep = new HashMap<String,Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		int employeeTypeId = 0;
		String firstName = "";
		String middleName= "";
		String lastName = "";
		int titleId = 0;
		String empCode = "";
		String cardNo = "";
		String salaryStatus = "";
		int departmentId = 0;
		String probationPeriod = "";
		Date confirmationDueDate = null;
		//int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		String equivalentDesignation = "";
		int locationId = 0;
		Date lastWorkingDay = null;
		Date dateOfResignation = null;
		//int unitId = 0;
		//int tradeId = 0;
		//String serviceNo = "";
		String permanentAddress = "";
		String residentialAddress = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "" ;
		String residenceTellNumber = "" ;
		String officeTellNumber = "" ;
		Date appointmentDate = new Date();
		//String jobCode = "";				
		String email = "";
		String employeeUrl ="";
		String bankCode = "";
		String accounthead="";
		String bankBranch="";
		String ifscCode="";
		String bankAccountCode="";
		String bankAccountNumber="";
		String employeePhoto = "";	
		//String changedBy = "";
		Date joinDate= new Date();
		Date currentDate = new Date();
		Integer applicantId = 0;
		//for employee dependent
		int employeeId = 0;
		Integer managerId = null;
		Boolean employeeTypeChanged = false;
		MasEmployee masEmployee= null;
		String pfNo="";
		String payMode ="";
		int joinOrganisation_id = 0;
		String code= "";
		String fatherOrHusbandName = "";
		int religId = 0;
		int category=0;
		int caste =0;
		int subCaste=0;
		int hospitalId = 0;
		HttpSession session = request.getSession(true);
		if(request.getParameter("hospitalId")!=null){
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}else{
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		int reportingRankId = 0;
		int reportingPersonId = 0;
		if (request.getParameter("reportingRankId") != null) {
			reportingRankId = Integer.parseInt(request.getParameter("reportingRankId"));
		}
		if (request.getParameter("reportingPersonId") != null) {
			reportingPersonId = Integer.parseInt(request.getParameter("reportingPersonId"));
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			employeeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(APPLICANT_ID) != null && !request.getParameter(APPLICANT_ID).equals("")) {
			applicantId = new Integer(request.getParameter(APPLICANT_ID));
		}
		if (request.getParameter(EMPLOYEE_TYPE) != null) {
			employeeTypeId = new Integer(request.getParameter(EMPLOYEE_TYPE));
		}
		/*if (request.getParameter(CATEGORY) != null) {
			empCategoryId = new Integer(request.getParameter(CATEGORY));
		}*/
		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		/*if (request.getParameter(EQUIVALENT_DESIGNATION) != null) {
			equivalentDesignation = request.getParameter(EQUIVALENT_DESIGNATION);
		}*/
		if (request.getParameter("managerId") != null && !request.getParameter("managerId").equals("0")) {
			managerId = new Integer(request.getParameter("managerId"));
		}
		/*if(!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}*/
		/*if (request.getParameter(EMPLOYEE_CARD_NO) != null) {
			cardNo = request.getParameter(EMPLOYEE_CARD_NO);
		}*/
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter("fatherOrHusbandName") != null) {
			fatherOrHusbandName = request.getParameter("fatherOrHusbandName");
		}
		
		if(request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto=request.getParameter(EMPLOYEE_PHOTO);
		}
		if(request.getParameter(APPOINTMENT_DATE) != null && !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(APPOINTMENT_DATE));	
		}
		/*if(request.getParameter(CONFIRMATION_DUE_DATE) != null && !(request.getParameter(CONFIRMATION_DUE_DATE).equals(""))) {
			confirmationDueDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CONFIRMATION_DUE_DATE));	
		}*/
		if (request.getParameter(PROBATION_PERIOD) != null) {
			probationPeriod = request.getParameter(PROBATION_PERIOD);
		}
		if(request.getParameter(JOIN_DATE) != null && !(request.getParameter(JOIN_DATE).equals(""))) {
			joinDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOIN_DATE));	
		}
		/*if(request.getParameter(LAST_WORKING_DAY) != null && !request.getParameter(LAST_WORKING_DAY).equals("") ) {
			lastWorkingDay= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(LAST_WORKING_DAY));	
		}
		if(request.getParameter(DATE_OF_RESIGNATION) != null && !request.getParameter(DATE_OF_RESIGNATION).equals("")) {
			dateOfResignation = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(DATE_OF_RESIGNATION));	
		}*/
		if(!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		/*if (request.getParameter(SALARY_STATUS)!=null && !request.getParameter(SALARY_STATUS).equals("")) {
			salaryStatus = request.getParameter(SALARY_STATUS);
		}*/
		if(!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if(request.getParameter(LOCATION)!=null && !request.getParameter(LOCATION).equals("0")) {
			locationId = Integer.parseInt(request.getParameter(LOCATION));
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if(request.getParameter(EMPLOYEE_PERMANENT_ADDRESS) != null) {
			permanentAddress =request.getParameter(EMPLOYEE_PERMANENT_ADDRESS);
		}
		if(request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS) != null) {
			residentialAddress =request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS);
		}
		if(request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber=request.getParameter(EMERGENCY_PHONE);
		}
		if(request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber=request.getParameter(EMERGENCY_MOBILE);
		}
		if(request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber=request.getParameter(TELL_NO_RESIDENCE);
		}
		if(request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber=request.getParameter(TELL_NO_OFFICE);
		}		
		if(request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode=request.getParameter(BANK_ACCOUNT_CODE);
		}
		if(request.getParameter(ACCOUNT_HEAD) != null) {
			accounthead=request.getParameter(ACCOUNT_HEAD);
		}
		if(request.getParameter(BANK_CODE) != null) {
			bankCode=request.getParameter(BANK_CODE);
		}
		if(request.getParameter(EMAIL) != null) {
			email=request.getParameter(EMAIL);
		}
		if(request.getParameter(URL) != null) {
			employeeUrl=request.getParameter(URL);
		}
		if(request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber=request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		
		
		if(request.getParameter("bankBranch") != null) {
			bankBranch=request.getParameter("bankBranch");
		}
		if(request.getParameter("ifscCode") != null) {
			ifscCode=request.getParameter("ifscCode");
		}
		if(!request.getParameter("religion").equals("0")) {
			religId = Integer.parseInt(request.getParameter("religion"));
		}
		if(!request.getParameter("caste").equals("0")) {
			caste = Integer.parseInt(request.getParameter("caste"));
		}
		/*if(!request.getParameter("subCaste").equals("0")) {
			subCaste = Integer.parseInt(request.getParameter("subCaste"));
		}*/
		if(!request.getParameter("category").equals("0")) {
			category = Integer.parseInt(request.getParameter("category"));
		}
		int hdbedu=0;
		if(!request.getParameter("hdbedu").equals("0")) {
			hdbedu = Integer.parseInt(request.getParameter("hdbedu"));
		}
		
		int hdbexp=0;
		if(!request.getParameter("hdbexp").equals("0")) {
			hdbexp = Integer.parseInt(request.getParameter("hdbexp"));
		}
		if(request.getParameter("pfNO") != null && !request.getParameter("pfNO").equals("") ) {
			pfNo= request.getParameter("pfNO");	
		}
		/*if(request.getParameter(PAY_MODE) != null && !request.getParameter(PAY_MODE).equals("") ) {
			payMode= request.getParameter(PAY_MODE);	
		}*/
		String handicapStatus = null;
		String insuranceType = null;
		String insuranceCompany = null;
		Date insuranceStartDate = null;
		Date insuranceEndDate = null;
		String medicalRemarks = null;
		String premium = "";
		String PEN="";
		String empName="";
		String uHID="";
		
		if(request.getParameter(HANDICAP_STATUS) != null && !request.getParameter(HANDICAP_STATUS).equals("") ) {
			handicapStatus = request.getParameter(HANDICAP_STATUS);	
		}
		if(request.getParameter(INSURANCE_TYPE) != null && !request.getParameter(INSURANCE_TYPE).equals("") ) {
			insuranceType= request.getParameter(INSURANCE_TYPE);	
		}
		if(request.getParameter(INSURANCE_COMPANY) != null && !request.getParameter(INSURANCE_COMPANY).equals("") ) {
			insuranceCompany= request.getParameter(INSURANCE_COMPANY);	
		}
		if(request.getParameter(INSURANCE_START_DATE) != null && !request.getParameter(INSURANCE_START_DATE).equals("") ) {
			insuranceStartDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(INSURANCE_START_DATE));
		}
		if(request.getParameter(INSURANCE_END_DATE) != null && !request.getParameter(INSURANCE_END_DATE).equals("") ) {
			insuranceEndDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(INSURANCE_END_DATE));
		}
		if(request.getParameter(MEDICAL_REMARKS) != null && !request.getParameter(MEDICAL_REMARKS).equals("") ) {
			medicalRemarks= request.getParameter(MEDICAL_REMARKS);	
		}
		
		if(request.getParameter("premium") != null && !request.getParameter("premium").equals("") ) {
			premium= request.getParameter("premium");	
		}

		if(request.getParameter("joinOrganisation") != null && !request.getParameter("joinOrganisation").equals("") ) {
			joinOrganisation_id = Integer.parseInt(request.getParameter("joinOrganisation"));	
		}
		if(request.getParameter("empName") != null && !request.getParameter("empName").equals("") ) {
			empName= request.getParameter("empName");	
		}
		if(request.getParameter("PEN") != null && !request.getParameter("PEN").equals("") ) {
			PEN= request.getParameter("PEN");	
		}
		if(request.getParameter("UHID") != null && !request.getParameter("UHID").equals("") ) {
			uHID= request.getParameter("UHID");	
		}
		/*if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		
		Users changedBy= null;
		
		if (session.getAttribute("users") != null) {
			changedBy = (Users) session.getAttribute("users");
		}
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		
		String P_DISTRICT="";
		String P_TALUK="";
		String P_LSG_NAME="";
		int P_WARD=0;
		String P_LOCALITY="";
		String P_LSG_HOUSE_NO="";
		String P_HOUSE_NO="";
		String P_POST_OFFICE="";
		String P_PINCODE="";
		
		String T_DISTRICT="";
		String T_TALUK="";
		String T_LSG_NAME="";
		int T_WARD=0;
		String T_LOCALITY="";
		String T_LSG_HOUSE_NO="";
		String T_HOUSE_NO="";
		String T_POST_OFFICE="";
		String T_PINCODE="";
		
		
		String T_Address1="";
		String T_Address2="";
		String T_Address3="";
		

		String P_Address1="";
		String P_Address2="";
		String P_Address3="";
		
		List pAddressList = new ArrayList();
		List tAddressList = new ArrayList();
		Map AddressMap = new HashMap();
		
		if(request.getParameter("P_DISTRICT") != null && !request.getParameter("P_DISTRICT").equals("0") ) {
			P_DISTRICT= request.getParameter("P_DISTRICT");	
		}
		if(request.getParameter("P_TALUK") != null && !request.getParameter("P_TALUK").equals("0") ) {
			P_TALUK= request.getParameter("P_TALUK");	
		}
		if(request.getParameter("P_LSG_NAME") != null && !request.getParameter("P_LSG_NAME").equals("") ) {
			P_LSG_NAME= request.getParameter("P_LSG_NAME");	
		}
		if(request.getParameter("P_WARD") != null && !request.getParameter("P_WARD").equals("0") ) {
			P_WARD=  Integer.parseInt(request.getParameter("P_WARD"));	
		}
		if(request.getParameter("P_LOCALITY") != null && !request.getParameter("P_LOCALITY").equals("") ) {
			P_LOCALITY= request.getParameter("P_LOCALITY");	
		}
		if(request.getParameter("P_LSG_HOUSE_NO") != null && !request.getParameter("P_LSG_HOUSE_NO").equals("") ) {
			P_LSG_HOUSE_NO= request.getParameter("P_LSG_HOUSE_NO");	
		}
		if(request.getParameter("P_HOUSE_NO") != null && !request.getParameter("P_HOUSE_NO").equals("") ) {
			P_HOUSE_NO= request.getParameter("P_HOUSE_NO");	
		}
		if(request.getParameter("P_POST_OFFICE") != null && !request.getParameter("P_POST_OFFICE").equals("") ) {
			P_POST_OFFICE= request.getParameter("P_POST_OFFICE");	
		}
		
		if(request.getParameter("P_PINCODE") != null && !request.getParameter("P_PINCODE").equals("") ) {
			P_PINCODE= request.getParameter("P_PINCODE");	
		}
		
		
		if(request.getParameter("P_Address1") != null && !request.getParameter("P_Address1").equals("") ) {
			P_Address1= request.getParameter("P_Address1");	
		}
		if(request.getParameter("P_Address2") != null && !request.getParameter("P_Address2").equals("") ) {
			P_Address2= request.getParameter("P_Address2");	
		}
		if(request.getParameter("P_Address3") != null && !request.getParameter("P_Address3").equals("") ) {
			P_Address3= request.getParameter("P_Address3");	
		}
		
		
		
		if(request.getParameter("T_DISTRICT") != null && !request.getParameter("T_DISTRICT").equals("0") ) {
			T_DISTRICT= request.getParameter("T_DISTRICT");	
		}
		if(request.getParameter("T_TALUK") != null && !request.getParameter("T_TALUK").equals("0") ) {
			T_TALUK= request.getParameter("T_TALUK");	
		}
		if(request.getParameter("T_LSG_NAME") != null && !request.getParameter("T_LSG_NAME").equals("") ) {
			T_LSG_NAME= request.getParameter("T_LSG_NAME");	
		}
		if(request.getParameter("T_WARD") != null && !request.getParameter("T_WARD").equals("0") ) {
			T_WARD=  Integer.parseInt(request.getParameter("T_WARD"));	
		}
		if(request.getParameter("T_LOCALITY") != null && !request.getParameter("T_LOCALITY").equals("") ) {
			T_LOCALITY= request.getParameter("T_LOCALITY");	
		}
		if(request.getParameter("T_LSG_HOUSE_NO") != null && !request.getParameter("T_LSG_HOUSE_NO").equals("") ) {
			T_LSG_HOUSE_NO= request.getParameter("T_LSG_HOUSE_NO");	
		}
		if(request.getParameter("T_HOUSE_NO") != null && !request.getParameter("T_HOUSE_NO").equals("") ) {
			T_HOUSE_NO= request.getParameter("T_HOUSE_NO");	
		}
		if(request.getParameter("T_POST_OFFICE") != null && !request.getParameter("T_POST_OFFICE").equals("") ) {
			T_POST_OFFICE= request.getParameter("T_POST_OFFICE");	
		}
		
		if(request.getParameter("T_PINCODE") != null && !request.getParameter("T_PINCODE").equals("") ) {
			T_PINCODE= request.getParameter("T_PINCODE");	
		}
		if(request.getParameter("T_Address1") != null && !request.getParameter("T_Address1").equals("") ) {
			T_Address1= request.getParameter("T_Address1");	
		}
		if(request.getParameter("T_Address2") != null && !request.getParameter("T_Address2").equals("") ) {
			T_Address2= request.getParameter("T_Address2");	
		}
		if(request.getParameter("T_Address3") != null && !request.getParameter("T_Address3").equals("") ) {
			T_Address3= request.getParameter("T_Address3");	
		}
		
		
		
		/*int sbuId=0;
		if(request.getParameter("sbuId") != null){
			sbuId = Integer.parseInt(""+request.getParameter("sbuId")); 
		}
		
		int holidaycal=0;
		if(request.getParameter("holidayAsPer") != null){
			holidaycal = Integer.parseInt(""+request.getParameter("holidayAsPer")); 
		}*/
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List employeeNameList = new ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			employeeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAddedEmp = false;
		boolean addEmployeeLeaveBalance = false;
		//(employeeCodeList.size() == 0 ) && (employeeNameList.size() == 0 )
		if(true){
			if(employeeId != 0){
				masEmployee = personnelMasterHandlerService.getEmployee(employeeId);
				if(masEmployee.getEmployeeType()!=null && !masEmployee.getEmployeeType().getId().equals(employeeTypeId)){
					employeeTypeChanged = true;
				}
				masEmployee.setId(employeeId);
			}else{
				addEmployeeLeaveBalance = true;
				masEmployee = new MasEmployee();
			}
			if(employeeTypeId != 0){
				MasEmployeeType masEmployeeType = new MasEmployeeType();
				masEmployeeType.setId(employeeTypeId);
				masEmployee.setEmployeeType(masEmployeeType);
			}
			//masEmployee.setServiceNo(serviceNo);
			//masEmployee.set
			
			
			// comment by javed  on 10-03-2015
			
			/*Resumepersonaldetails resumepersonaldetails = new Resumepersonaldetails();
			if(!applicantId.equals(0)){
				 resumepersonaldetails.setId(applicantId);
				 masEmployee.setResumepersonaldetails(resumepersonaldetails);
			}*/
			
			
			masEmployee.setFirstName(empName);
			masEmployee.setLastName(lastName);
			masEmployee.setPEN(PEN);
			masEmployee.setUHID(uHID);
			masEmployee.setEmployeeName(empName);
			masEmployee.setFatherHusbandName(fatherOrHusbandName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setConfirmationDueDate(confirmationDueDate);
			masEmployee.setLastWorkingDay(lastWorkingDay);
			masEmployee.setDateOfResignation(dateOfResignation);
			masEmployee.setProbationPeriod(probationPeriod);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setIfscCode(ifscCode);
			masEmployee.setBankBranch(bankBranch);
			masEmployee.setEquivalentDesignation(equivalentDesignation);
			masEmployee.setUrl(employeeUrl);
			if(titleId != 0){
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}
			/*if(departmentId != 0){
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}*/
			
			if (departmentId != 0) {
				MasEmployeeDepartment masEmployeeDepartment = new MasEmployeeDepartment();
				masEmployeeDepartment.setId(departmentId);
				masEmployee.setEmployeeDepartment(masEmployeeDepartment);
			}
			if(reportingRankId != 0){
				MasRank rank = new MasRank();
				rank.setId(reportingRankId);
				masEmployee.setReportingRank(rank);
			}
			if(reportingPersonId != 0){
				System.out.println("reportingPersonId=="+reportingPersonId);
				MasEmployee masEmp = new MasEmployee();
				masEmp.setId(reportingPersonId);
				masEmployee.setLineManager(masEmp);
			}
			
			
			/*if(sbuId != 0){
				MasSbu masSbu = new MasSbu();
				masSbu.setId(sbuId);
				masEmployee.setSbu(masSbu);
			}*/
			//System.out.println("sbuId>>>>"+sbuId);
			if(empStatusId !=0){
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmployeeStatus(masEmpStatus);
			}
			if(gradeId != 0){
				MasGrade masGrade = new MasGrade();
				masGrade.setId(gradeId);
				masEmployee.setGrade(masGrade);
			}
			if(empCategoryId != 0){
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				masEmployee.setEmpCategory(masEmpCategory);
			}
			if(rankId != 0){
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				masEmployee.setRank(masRank);
			}
			if(religId != 0){
				MasReligion masReligion = new MasReligion();
				masReligion.setId(religId);
				masEmployee.setEmpReligion(masReligion);
			}
			if(caste != 0){
				/*MasEmployeeCaste mec = new MasEmployeeCaste();
				mec.setId(caste);
				masEmployee.setEmpCaste(mec);*/
				MasCategory masCategory = new MasCategory();
				masCategory.setId(caste);
				masEmployee.setMasCategory(masCategory);
			}
			if(subCaste != 0){
				MasEmployeeSubCaste mesc = new MasEmployeeSubCaste();
				mesc.setId(subCaste);
				masEmployee.setEmpSubCaste(mesc);
			}
			if(category != 0){
			
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(category);
				masEmployee.setEmpCategory(masEmpCategory);
			}
			/*if(locationId != 0){
				masEmployee.setLocationId(locationId);
			}*/
			
			/*if(holidaycal != 0){
				MasLocation masLocation = new MasLocation();
				masLocation.setId(holidaycal);
				masEmployee.setHolidayAsPer(masLocation);
			} */
			masEmployee.setSalaryStatus(salaryStatus);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setPermanentAddress(permanentAddress);
			masEmployee.setResidentialAddress(residentialAddress);
			masEmployee.setEmail(email);
			masEmployee.setTelNoEmergency(emergencyTellNumber);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			//System.out.println(bankCode+"bankCode");
			masEmployee.setBankCode(bankCode);
			masEmployee.setAccountHead(accounthead);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setBankAccountCode(bankAccountCode);
			if(managerId!=null){
				MasEmployee emp = new MasEmployee();
				emp.setId(managerId);
				masEmployee.setLineManager(emp);
			}/*else{
				masEmployee.setLineManager(null);
			}*/
			if(!cardNo.equals("")){
				masEmployee.setCardNo(cardNo);				
			}
			if(!pfNo.equals("")){
				masEmployee.setPfNo(pfNo);
			}
			if(!payMode.equals("")){
				masEmployee.setPaymentMode(payMode);
			}
			
			//if(!handicapStatus.equals("")){
				masEmployee.setHandicapStatus(handicapStatus);
			//}
			//if(!insuranceType.equals("")){
				masEmployee.setInsuranceType(insuranceType);
			//}
			//if(!insuranceCompany.equals("")){
				masEmployee.setInsuranceCompany(insuranceCompany);
			//}
			//if(insuranceStartDate != null){
				masEmployee.setInsuranceStartDate(insuranceStartDate);
			//}
			//if(insuranceEndDate != null){
				masEmployee.setInsuranceEndDate(insuranceEndDate);
			//}
			//if(!medicalRemarks.equals("")){
				masEmployee.setMedicalRemarks(medicalRemarks);
			//}
				masEmployee.setPremium(premium);
			
			int InstituteId = (Integer)session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			//masHospital.setId(joinOrganisation_id);
			masHospital.setId(hospitalId);
			masEmployee.setHospital(masHospital);
			
			masEmployee.setStatus("y");
			masEmployee.setLastChgBy(changedBy);
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);
			String lastAddedEmployeeCode = "";
			Integer employeeCodeSeries = 0; 
			
			// comment by javed khan for save manually employee code
			
			/*if(employeeId == 0 ){
				MasEmployee lastAddedEmployee = personnelMasterHandlerService.getLastAddedEmployee(employeeTypeId, joinOrganisation_id);
				if(lastAddedEmployee!= null){
					lastAddedEmployeeCode = lastAddedEmployee.getEmployeeCode();
					employeeCodeSeries = new Integer(lastAddedEmployeeCode.substring(2,6 ));
				}else{
					employeeCodeSeries =0000;
				}
				employeeCodeSeries++;
				String codeString = employeeCodeSeries.toString();
				String currentEmployeeCode = "";
				if(codeString.length() == 1){
					currentEmployeeCode = "000"+codeString;
				}
				if(codeString.length() == 2){
					currentEmployeeCode = "00"+codeString;
				}
				if(codeString.length() == 3){
					currentEmployeeCode = "0" + codeString;
				}
				if(codeString.length() == 4){
					currentEmployeeCode = codeString;
				}
				MasHospital company =  personnelMasterHandlerService.getCompany(joinOrganisation_id);
				String companyCode = company.getHospitalCode();
				MasEmployeeType employeeType = personnelMasterHandlerService.getEmployeeType(employeeTypeId);
				empCode = companyCode + employeeType.getTypeCode() + currentEmployeeCode ;
				masEmployee.setEmployeeCode(empCode);
			}else{
				if(employeeTypeChanged.equals(true)){
					String previousEmployeeCode = masEmployee.getEmployeeCode();
					String companyCode = previousEmployeeCode.substring(0, 2);
					String employeeCode = previousEmployeeCode.substring(3, 7);
					MasEmployeeType employeeType = personnelMasterHandlerService.getEmployeeType(employeeTypeId);
					empCode = companyCode + employeeType.getTypeCode() + employeeCode;
					masEmployee.setEmployeeCode(empCode);
				}
			}*/
			
			// comment by javed khan for save manually employee code
			
			 // added by javed khan for save manually employee code
			
			if(request.getParameter("employee_Code") != null && !request.getParameter("employee_Code").equals("") ) {
				empCode= request.getParameter("employee_Code");	
			}
			int education=0;
			if(request.getParameter("hdb") != null && !request.getParameter("hdb").equals("") ) {
				education= Integer.parseInt(""+request.getParameter("hdb"));	
				//System.out.println("education>>>>"+education);
			}
			
			//System.out.println("empCode>>>>"+empCode);
			masEmployee.setEmployeeCode(empCode);
			
			String name_emer1="";
			String name_emer2="";
			String rel_emer1="";
			String rel_emer2="";
			String contact_emer1="";
			String contact_emer2="";
			String decimalCard="";
			if(request.getParameter("emer_name1") != null && !request.getParameter("emer_name1").equals("") ) {
				name_emer1= request.getParameter("emer_name1");	
			}
			
			if(request.getParameter("emer_name2") != null && !request.getParameter("emer_name2").equals("") ) {
				name_emer2= request.getParameter("emer_name2");	
			}
			
			if(request.getParameter("emer_rel1") != null && !request.getParameter("emer_rel1").equals("") ) {
				rel_emer1= request.getParameter("emer_rel1");	
			}
			
			if(request.getParameter("emer_rel2") != null && !request.getParameter("emer_rel2").equals("") ) {
				rel_emer2= request.getParameter("emer_rel2");	
			}
			
			if(request.getParameter("emer_cont1") != null && !request.getParameter("emer_cont1").equals("") ) {
				contact_emer1= request.getParameter("emer_cont1");	
			}
			
			if(request.getParameter("emer_cont2") != null && !request.getParameter("emer_cont2").equals("") ) {
				contact_emer2= request.getParameter("emer_cont2");	
			}
			
			if(request.getParameter("Decimal_CARD_NO") != null && !request.getParameter("Decimal_CARD_NO").equals("") ) {
				decimalCard= request.getParameter("Decimal_CARD_NO");	
			}
			
			/*masEmployee.setNameEmergancy1(name_emer1);
			masEmployee.setNameEmergancy2(name_emer2);
			masEmployee.setRelationEmergancy1(rel_emer1);
			masEmployee.setRelationEmergancy2(rel_emer2);
			masEmployee.setContactEmergancy1(contact_emer1);
			masEmployee.setContactEmergancy2(contact_emer2);
			masEmployee.setDecimalCardNo(decimalCard);*/
			
			
			HrEmployeePersonelDetails employeePersonelDetails = null;
			employeePersonelDetails = setAndGetEmployeePersonelDetails(masEmployee,request);
			personnelMasterHandlerService.addEmployeePersonelDetails(employeePersonelDetails);
			
			
			/*HrEmployeeExperience employeeExperience = null;
			employeeExperience = setAndGetEmployeeExperience(masEmployee,request,j);
			personnelMasterHandlerService.addEmployeeExperience(employeeExperience);	
			masEmployee.setEmployeeExperience(employeeExperience);*/
			masEmployee.setPersonalDetails(employeePersonelDetails);
			
			
			try{
				successfullyAddedEmp = personnelMasterHandlerService.addEmployee(masEmployee);		
				UserManager userManager = null;
				List managerList = null;
				if(employeeId == 0){
					userManager = new UserManager();
				}else{
					Set set = masEmployee.getUserManager();
					if(set!=null && !set.isEmpty()){
					 managerList =new ArrayList(set);
					 userManager = (UserManager)managerList.get(0);
					}else{
						userManager = new UserManager();
					}
				}
				
				
				
				// for employee Address
				
				System.out.println("Addd>>1>"+request.getParameter("permAddr"));
					
				 /*if( request.getParameter("permAddr")!=null && !request.getParameter("permAddr").equals("")){
						if(request.getParameter("permAddr").equalsIgnoreCase("y")){*/
				if(employeeId !=0){
					boolean b = personnelMasterHandlerService.deleteEmpAddress(employeeId);
				}
							HrEmployeeAddress employeeAddressPerma =  new HrEmployeeAddress();
							
							MasAddressType masAddrType=new MasAddressType();	
								masAddrType.setId(1);
								employeeAddressPerma.setAddressType(masAddrType);
								System.out.println(P_DISTRICT+"P_DISTRICT");
								if(!P_DISTRICT.equals("")){
									MasDistrict masDist=new MasDistrict();
									masDist.setId(Integer.parseInt(P_DISTRICT));
									employeeAddressPerma.setDistrict(masDist);;
									
								}
								
								if(!P_TALUK.equals("")){
									MasTaluk masTaluk=new MasTaluk();
									masTaluk.setId(Integer.parseInt(P_TALUK));
									employeeAddressPerma.setTaluk(masTaluk);
									
								}
								if(!P_LSG_NAME.equals("")){
									MasLsg maslsg=new MasLsg();
									maslsg.setId(Integer.parseInt(P_LSG_NAME));
									employeeAddressPerma.setLsgName(maslsg);
									
								}
								if(P_WARD!=0){
									MasWard mw=new MasWard();
									mw.setId(P_WARD);
									employeeAddressPerma.setWardNo(mw);
									//employeeAddressPerma.setEmpWardNo(P_WARD);
									
								}
								if(!P_LOCALITY.equals("")){
									/*PhMasLocality locality=new PhMasLocality();
									locality.setId(Integer.parseInt(P_LOCALITY));
									employeeAddressPerma.setLocality(locality);*/
									employeeAddressPerma.setEmpLocality(P_LOCALITY);

									
								}
								if(!P_Address1.equals("")){
									System.out.println("P_Address1 "+P_Address1);
									employeeAddressPerma.setAddress(P_Address1);
								}
								if(!P_Address2.equals("")){
									employeeAddressPerma.setAddress2(P_Address2);
								}
								if(!P_Address3.equals("")){
									employeeAddressPerma.setAddress3(P_Address3);
								}
							
								employeeAddressPerma.setLsgHouseNo(P_LSG_HOUSE_NO);
								employeeAddressPerma.setHouseNo(P_HOUSE_NO);
								
								if(!P_POST_OFFICE.equals("")){
									MasPostCode mpc=new MasPostCode();
									mpc.setId(Integer.parseInt(P_POST_OFFICE));
									employeeAddressPerma.setPostOffice(mpc);
									
								}
								employeeAddressPerma.setEmployee(masEmployee);
								employeeAddressPerma.setAddEditBy(changedBy);
								employeeAddressPerma.setAddEditDateTime(currentDate);
								
								
								 AddressMap.put("employeeAddressPerma", employeeAddressPerma);
					/*	}
				 }*/
				 
				 System.out.println("Addd>>2>"+request.getParameter("pTempAddr"));
				/* if(request.getParameter("pTempAddr")!=null && !request.getParameter("pTempAddr").equals("")){
						
						if(request.getParameter("pTempAddr").equalsIgnoreCase("y")){	*/
							HrEmployeeAddress employeeAddressTemp =  new HrEmployeeAddress();
							
							
							MasAddressType masAddrType1=new MasAddressType();	
								masAddrType1.setId(4);
								employeeAddressTemp.setAddressType(masAddrType1);
								
								if(!T_DISTRICT.equals("")){
									MasDistrict masDist=new MasDistrict();
									masDist.setId(Integer.parseInt(T_DISTRICT));
									employeeAddressTemp.setDistrict(masDist);;
									
								}
								
								if(!T_TALUK.equals("")){
									MasTaluk masTaluk=new MasTaluk();
									masTaluk.setId(Integer.parseInt(T_TALUK));
									employeeAddressTemp.setTaluk(masTaluk);
									
								}
								if(!T_LSG_NAME.equals("")){
									MasLsg maslsg=new MasLsg();
									maslsg.setId(Integer.parseInt(T_LSG_NAME));
									employeeAddressTemp.setLsgName(maslsg);
									
								}
								if(T_WARD!=0){
									System.out.println("T_WARD>>"+T_WARD);
									MasWard mw=new MasWard();
									mw.setId(T_WARD);
									employeeAddressTemp.setWardNo(mw);
									
									//employeeAddressTemp.setEmpWardNo(T_WARD);
									
								}
								if(!T_LOCALITY.equals("")){
									/*MasLoc mw=new MasWard();*/
									/*mw.setId(Integer.parseInt(T_LOCALITY));*/
									employeeAddressTemp.setEmpLocality(T_LOCALITY);
									
								}
								if(!T_Address1.equals("")){
									employeeAddressTemp.setAddress(T_Address1);
								}
								if(!T_Address2.equals("")){
									employeeAddressTemp.setAddress2(T_Address2);
								}
								if(!T_Address3.equals("")){
									employeeAddressTemp.setAddress3(T_Address3);
								}
							
								employeeAddressTemp.setLsgHouseNo(T_LSG_HOUSE_NO);
								employeeAddressTemp.setHouseNo(T_HOUSE_NO);
								
								if(!T_POST_OFFICE.equals("")){
									MasPostCode mpc=new MasPostCode();
									mpc.setId(Integer.parseInt(T_POST_OFFICE));
									employeeAddressTemp.setPostOffice(mpc);
									
								}
								employeeAddressTemp.setEmployee(masEmployee);
								employeeAddressTemp.setAddEditBy(changedBy);
								employeeAddressTemp.setAddEditDateTime(currentDate);
								
								AddressMap.put("employeeAddressTemp", employeeAddressTemp);
								
					/*	}
				 }*/
				
				
				personnelMasterHandlerService.addEmployeeAddress(AddressMap);
				
				//end for employee Address
				
				// added by javed khan
				
				//boolean incrementFlag = true;
				//System.out.println(masEmployee.getEmployeeExperience());
				/*if(masEmployee.getEmployeeExperience()!=null && masEmployee.getEmployeeExperience().size() == 0){
					System.out.println("experience 0");
					for(int j = 1; j <= hdbexp ; j++) {
						HrEmployeeExperience employeeExperience = null;						
						employeeExperience = setAndGetEmployeeExperience(employeeExperience,request,j);
						employeeExperience.setExpYrs(hdbexp);
						employeeExperience.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
					}
				} else {
					System.out.println("experience not 0");
					int j= 1;
					List<HrEmployeeExperience> sortedList = new ArrayList<HrEmployeeExperience>();
					sortedList.addAll(masEmployee.getEmployeeExperience());
					Collections.sort(sortedList, new employeeExperienceComprator());
					boolean b = personnelMasterHandlerService.removeOldExper(masEmployee);
					if(b){
					for(int j1 = 1; j1 <= hdbexp ; j1++) {
						HrEmployeeExperience employeeExperience = null;						
						employeeExperience = setAndGetEmployeeExperience(employeeExperience,request,j1);							
						employeeExperience.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
					}
					}
				}*/
				
				if(masEmployee.getEmployeeExperience()!=null){
					System.out.println("experience not 0");
					int j= 1;
					List<HrEmployeeExperience> sortedList = new ArrayList<HrEmployeeExperience>();
					sortedList.addAll(masEmployee.getEmployeeExperience());
					Collections.sort(sortedList, new employeeExperienceComprator());
					boolean b = personnelMasterHandlerService.removeOldExper(masEmployee);
					if(b){
					for(int j1 = 1; j1 <= hdbexp ; j1++) {
						HrEmployeeExperience employeeExperience = null;						
						employeeExperience = setAndGetEmployeeExperience(employeeExperience,request,j1);							
						employeeExperience.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
					}
					}
				} else {
					System.out.println("experience 0");
					for(int j = 1; j <= hdbexp ; j++) {
						HrEmployeeExperience employeeExperience = null;						
						employeeExperience = setAndGetEmployeeExperience(employeeExperience,request,j);
						employeeExperience.setExpYrs(hdbexp);
						employeeExperience.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
					}
				}
				
				
				MasEmployee manager = new MasEmployee();
				manager.setId(managerId);
				userManager.setManagers(manager);
				userManager.setManagerId(managerId);
				if(masEmployee!= null){
					MasEmployee user = new MasEmployee();
					user.setId(masEmployee.getId());
					userManager.setUsers(user);
					userManager.setEmpId(masEmployee.getId());
				}
				if(masEmployee!= null && addEmployeeLeaveBalance){
					int sexid = 0;
					Date birthday=null;
					Date mrgday=null;
					if(masEmployee.getPersonalDetails()!=null) {
						 sexid=masEmployee.getPersonalDetails().getGender().getId();
						  birthday= masEmployee.getPersonalDetails().getDateOfBirth();
						  mrgday = masEmployee.getPersonalDetails().getMarriageDate();
						 
					}
					String mnthORyear="";
					
					// Leave code comment by javed khan  on 10-03-2015 
					
					Properties properties1 = new Properties();
					URL resourcePath = Thread.currentThread().getContextClassLoader()
							.getResource("HR.properties");
					try {
						properties1.load(resourcePath.openStream());
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					String conditionNormal = properties1.getProperty("MaternityLeaveId");
					String PaternityLeaveId = properties1.getProperty("PaternityLeaveId");
					List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = personnelMasterHandlerService.getMasLeaveTypeMediatorList();
					
					for(HrMasLeaveTypeMediator mediator : hrMasLeaveTypeMediatorList){
						HrMasLeaveTypeNew hrMasLeaveTypeNewobj = mediator.getLeaveType();
						HrMasLeave leaveType=hrMasLeaveTypeNewobj.getLeaveType();
						mnthORyear = hrMasLeaveTypeNewobj.getMonthlyOrYearly();
						int leaveTypeId=0;
						leaveTypeId=leaveType.getId();
					
						double noOfDaysAllowed =0;
						
						noOfDaysAllowed=Double.valueOf(hrMasLeaveTypeNewobj.getAllowedDays());
						
						HrEmployeeBalanceNew hrEmployeeBalanceNew = new HrEmployeeBalanceNew();
						hrEmployeeBalanceNew.setAlreadyAvailedPatMat("n");
						hrEmployeeBalanceNew.setTotalLeaveTaken("0");;
						hrEmployeeBalanceNew.setBalanceAdjustedBy("0");
						hrEmployeeBalanceNew.setOpeningBalance("0");
						hrEmployeeBalanceNew.setOpeningBalanceYearly("0");
						hrEmployeeBalanceNew.setLeaveType(mediator);
						hrEmployeeBalanceNew.setStatus("y");
						hrEmployeeBalanceNew.setTaken(new DecimalFormat("0.##").format((double)0));
						hrEmployeeBalanceNew.setTotalLeaveTaken(new DecimalFormat("0.##").format((double)0));
						boolean addEmpBalance = false;
						System.out.println(sexid+"elseif>>>> "+leaveTypeId);
					//	if(((sexid==3) && (leaveTypeId==4)) || ((sexid==2)&&(leaveTypeId==3))) {
						if(((sexid==2)&&(leaveTypeId==3))) { // for maternity
							hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(noOfDaysAllowed));
							addEmpBalance = true;
							hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(noOfDaysAllowed));
						}else{
		    				if(leaveTypeId != 3 && leaveTypeId != 4 ){ // not for mat,pat		    					
		    					System.out.println(mediator.getId()+"<<<<elseif1111>>>> "+leaveTypeId);
		    					Calendar cal = Calendar.getInstance();
								cal.setTime(masEmployee.getJoinDate());
								
								int joiningMonth = cal.get(Calendar.MONTH)+1;
								int joiningDateDay = cal.get(Calendar.DATE);
								double entitlementAccJoinDate = 0;
								double multiplier = 0;
								
								double closingBalance = 0;
								double adj = 0;
								double earned = 0;
								double accrued = 0;
								
								entitlementAccJoinDate = (12-joiningMonth);
								//System.out.println(leaveTypeId+"mnthORyear> 22>>> "+mnthORyear);
								if(mnthORyear.equalsIgnoreCase("m") || leaveTypeId == 20 || leaveTypeId == 22){
									
									multiplier =  noOfDaysAllowed;
									System.out.println("this one"+noOfDaysAllowed);
									//if(joiningDateDay <=20){
									//	System.out.println("20 days");
										//closingBalance = noOfDaysAllowed;
										//earned = noOfDaysAllowed;
										//adj =  noOfDaysAllowed;
										//accrued = noOfDaysAllowed;
										//if(employeeTypeId == 4){ // added by javed khan ... if employee is in Probation period
											//System.out.println("employeeTypeId>>>"+employeeTypeId);
										//	multiplier =  noOfDaysAllowed/2;
											//closingBalance = noOfDaysAllowed/2;
											//earned = noOfDaysAllowed/2;
											//adj =  noOfDaysAllowed/2;
											//accrued = noOfDaysAllowed/2;
										//}
										
									//} else {
										closingBalance = 0.0;
										earned = 0.0;
										adj = 0.0;
										accrued = 0.0;
									//}
									// for birthday leave add in PL
									
									//if(leaveTypeId == 13 && birthday.getDate() >= new Date().getDate() && (birthday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance =closingBalance+ 1.0;
									//}
									
									// for Mrgday leave add in PL
									
									//if(leaveTypeId == 13 && masEmployee.getEmployeePersonalDetails().getMaritalStatus().getMaritalStatusCode().equals("M")){
										//if(  mrgday.getDate() >= new Date().getDate()  && (mrgday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance =closingBalance+ 1.0;
										//}
									//}
									
								} else if(mnthORyear.equalsIgnoreCase("y")){
									//System.out.println(joiningDateDay+"<<<joiningDateDay  mnthORyear 333>>>> "+mnthORyear);
									//System.out.println("in y");
									//if(leaveTypeId !=5){ // not applicable for birth day
									multiplier =  noOfDaysAllowed/12.0;
									//if(joiningDateDay <=20){
										//closingBalance = noOfDaysAllowed/12.0;
										//earned = noOfDaysAllowed/12.0;
										//adj =  noOfDaysAllowed/12.0;
										//accrued = noOfDaysAllowed/12.0;
										
									//} else {
										closingBalance = 0.0;
										earned = 0.0;
										adj = 0.0;
										accrued = 0.0;
										//}
									//}
									//if(leaveTypeId == 5 && birthday.getDate() >= new Date().getDate()  && (birthday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance = 1.0;
										//earned = 1.0;
										
									//}
									
									//if(leaveTypeId == 24 ){ // for rh
									//	closingBalance = 0.0;
									//	earned = 0.0;
										
									//}
									
									
									//if(leaveTypeId == 6 && mrgday.getDate() >= new Date().getDate()  && (mrgday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance = 1.0;
										//earned = 1.0;
										
									//}
								}
								//entitlementAccJoinDate = (12-joiningMonth)*(Float.valueOf(new DecimalFormat("0.##").format(multiplier))) + adj;
								entitlementAccJoinDate = noOfDaysAllowed;
								//System.out.println("entitlementAccJoinDate>>>>  "+entitlementAccJoinDate);
								if(leaveTypeId == 20 ) {
									//closingBalance = noOfDaysAllowed;
									//earned = noOfDaysAllowed;
									entitlementAccJoinDate = earned;
									//accrued = noOfDaysAllowed;
								}			
								if(leaveTypeId == 21 || leaveTypeId == 23  || leaveTypeId == 13){ // for EL
									hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(0));	
									hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(0));	
									addEmpBalance = true;
								}else{
								hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format(earned));
								hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(entitlementAccJoinDate));	
								//hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(closingBalance));
								hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(entitlementAccJoinDate));
								hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format(entitlementAccJoinDate));
								hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(accrued));	
								addEmpBalance = true;
								}
		    				}
						}
						hrEmployeeBalanceNew.setCompany(masHospital);
						hrEmployeeBalanceNew.setEmp(masEmployee);
						hrEmployeeBalanceNew.setLastChgBy(changedBy);
						hrEmployeeBalanceNew.setLastChgDate(currentDate);
						hrEmployeeBalanceNew.setLastChgTime(currentTime);
						System.out.println("addEmpBalance>>>>> "+addEmpBalance);
						if(addEmpBalance){
							System.out.println("addEmpBalance1>>>"+addEmpBalance);
							personnelMasterHandlerService.addEmployeeBalanceDetails(hrEmployeeBalanceNew);	
						}
					}
					
					 
					// Leave code comment by javed khan  on 10-03-2015 
				}

				personnelMasterHandlerService.addUserManager(userManager);
				personnelMasterHandlerService.refreshObject(masEmployee);
				//personnelMasterHandlerService.UpdateSecurityDepositeStatus(masEmployee);// add by javed khan
				boolean incrementFlag = true;
				//System.out.println(masEmployee.getEmployeeEducation());
				if(masEmployee.getEmployeeEducation().size() == 0){
					System.out.println("education 0"+hdbedu);
					for(int i = 1; i <= hdbedu; i++) {
						HrMasEmployeeEducation employeeEducation = null;
						employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i,incrementFlag );
						employeeEducation.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
					}
				} else {
					System.out.println("education not 0");
					int i= 1;
					incrementFlag = true;
					List<HrMasEmployeeEducation> sortedList = new ArrayList<HrMasEmployeeEducation>();
					sortedList.addAll(masEmployee.getEmployeeEducation());
					Collections.sort(sortedList, new EmployeeEducationComparator());
					
				/*	for(HrMasEmployeeEducation employeeEducation : sortedList) {
				
						employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i,incrementFlag);
						
						employeeEducation.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
						i++;
					}*/
					boolean b = personnelMasterHandlerService.removeOldEdu(masEmployee);
					if(b){
					for(int i1 = 1; i1 <= hdbedu; i1++) {
						HrMasEmployeeEducation employeeEducation = null;
						employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i1,incrementFlag );
						employeeEducation.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
					}
				}
				}
			} catch(DataIntegrityViolationException e) {
				msgForCard = "Card No already occupied . Please enter another card no.";
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(successfullyAddedEmp == true){
				if(!applicantId.equals(0)){
					
					// commnet by javed khan for through application on 10-03-2015 
					
					/*Resumepersonaldetails resume = (Resumepersonaldetails)personnelMasterHandlerService.loadObject(Resumepersonaldetails.class, applicantId);
					Resumestatus resumestatus = resume.getResumeStatus();
					resumestatus.setStatusId(19);
					Resumestatushistory resumeStatusHistory = resume.getResumeStatusHistory();
					resumeStatusHistory.setStatusId(19);
					resumeHandlerService.addResumeStatus(resumestatus, resumeStatusHistory);
					migrateResumePayElementsToEmployeePayElements(request,masEmployee,resume);*/
					
					
					//message = "Applicant Added Successfully !! \n Employee Code generated : " +empCode;
					message = "Applicant Added Successfully.  ";
				}else{
					message = "New Employee Added Successfully.";
				}
			}else{
				message = "Try Again !!";
			}
		}else if(employeeNameList.size() != 0){
			message = "Employee Code already exists.";
		}
		if(employeeId != 0 ){
			message = "Record Updated Successfully";
			if(employeeTypeChanged.equals(true)){
				message += " and new Employee Code generated is " + 	empCode;
			}
		}
		if(msgForCard != null){
			message = msgForCard;
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try{
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 userType = user.getUserType()!=null?user.getUserType():4;
				 dataMap.put("userId", user.getId());
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		   
		   mapDep = personnelMasterHandlerService.showEmployeeDependentJsp();
		   map.putAll(mapDep);
		}catch (Exception e) {
		    e.printStackTrace();
		}
		jsp=EMPLOYEE_JSP;
		title="Add Employee";
		jsp += ".jsp";		    
		List joinedCandidates = resumeHandlerService.getJoinedCandidates();
		map.put("joinedCandidates", joinedCandidates);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	/*public HrMasEmployeeEducation setAndGetEmployeEducation(
			HrMasEmployeeEducation employeeEducation,
			HttpServletRequest request, int i) {

		// for employee education
		Integer qualificationId = 0;
		Integer courseId = 0;
		Integer splQualificationId = 0;
		Integer instituteId = 0;
		Date startDate = null;
		Date endDate = null;
		Integer courseDuration = 0;
		String courseDurationUnit = "";
		Date qualifiedDate = null;
		String awards = "";
		String[] primarySkills = null;
		String[] secondarySkills = null;
		int percentage = 0;
		String division = "";

		if (request.getParameter(PERCENTAGE + i) != null
				&& request.getParameter(PERCENTAGE + i) != "0") {
			percentage = new Integer(request.getParameter(PERCENTAGE + i));
		}
		if (request.getParameter(CLASS + i) != null
				&& request.getParameter(CLASS + i) != "") {
			division = (request.getParameter(CLASS + i));
		}
		if (request.getParameter(QUALIFICATION + i) != null
				&& request.getParameter(QUALIFICATION + i) != "0") {
			qualificationId = new Integer(request.getParameter(QUALIFICATION
					+ i));
		}
		if (request.getParameter(COURSES_NAME + i) != null
				&& request.getParameter(COURSES_NAME + i) != "0") {
			courseId = new Integer(request.getParameter(COURSES_NAME + i));
		}
		if (request.getParameter(SPL_QUALIFICATION + i) != null
				&& request.getParameter(SPL_QUALIFICATION + i) != "0") {
			splQualificationId = new Integer(
					request.getParameter(SPL_QUALIFICATION + i));
		}
		if (request.getParameter(INSTITUTION + i) != null
				&& request.getParameter(INSTITUTION + i) != "0") {
			instituteId = new Integer(request.getParameter(INSTITUTION + i));
		}
		if (request.getParameter(START_DATE + i) != null
				&& request.getParameter(START_DATE + i) != "") {
			startDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(START_DATE + i));
		}
		if (request.getParameter(END_DATE + i) != null
				&& request.getParameter(END_DATE + i) != "") {
			endDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(END_DATE + i));
		}
		if (request.getParameter(COURSES_DURATION + i) != null) {
			courseDuration = new Integer(request.getParameter(COURSES_DURATION
					+ i));
		}
		if (request.getParameter(COURSES_DURATION_UNIT + i) != null) {
			courseDurationUnit = request
					.getParameter(COURSES_DURATION_UNIT + i);
		}
		if (request.getParameter(QUALIFIED_DATE + i) != null
				&& request.getParameter(QUALIFIED_DATE + i) != "") {
			qualifiedDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(QUALIFIED_DATE + i));
		}
		if (request.getParameter(AWARDS + i) != null) {
			awards = request.getParameter(AWARDS + i);
		}

		if (employeeEducation == null) {
			employeeEducation = new HrMasEmployeeEducation();
		}

		if (!qualificationId.equals(0)) {
			HrMasQualification qualification = new HrMasQualification();
			qualification.setId(qualificationId);
			employeeEducation.setQualification(qualification);
		}

		if (!courseId.equals(0)) {
			HrMasCourse course = new HrMasCourse();
			course.setId(courseId);
			employeeEducation.setCourse(course);
		}

		if (!splQualificationId.equals(0)) {
			HrMasSpecialQualification splQualification = new HrMasSpecialQualification();
			splQualification.setId(splQualificationId);
			employeeEducation.setSplQualification(splQualification);
		}

		if (!instituteId.equals(0)) {
			HrMasInstitute institute = new HrMasInstitute();
			institute.setId(instituteId);
			employeeEducation.setInstitute(institute);
		}

		if (percentage != 0) {
			employeeEducation.setPercentage(percentage);
		}
		employeeEducation.setDivision(division);
		employeeEducation.setStartDate(startDate);
		employeeEducation.setEndDate(endDate);
		employeeEducation.setCourseDuration(courseDuration);
		employeeEducation.setQualifiedDate(qualifiedDate);
		employeeEducation.setAwards(awards);

		return employeeEducation;
	}*/

/*	public HrEmployeeExperience setAndGetEmployeeExperience(
			MasEmployee masEmployee, HttpServletRequest request) {
		Integer expYears = null;
		;
		Integer expMonths = null;
		Date serviceStartDate = null;
		Date serviceEndDate = null;
		String previousEmployer = "";
		String designation = "";
		String awards = "";
		String serviceEndReason = "";
		String phone_no = "";
		String address = "";
		Integer countryId = 0;
		Integer cityId = 0;
		Integer stateId = 0;
		String skills = "";

		if (request.getParameter(YEARS) != null
				&& request.getParameter(YEARS) != "") {
			expYears = new Integer(request.getParameter(YEARS));
		}
		if (request.getParameter(MONTHS) != null
				&& request.getParameter(MONTHS) != "") {
			expMonths = new Integer(request.getParameter(MONTHS));
		}
		if (request.getParameter(SERVICE_START_DATE) != null
				&& request.getParameter(SERVICE_START_DATE) != "") {
			serviceStartDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(SERVICE_START_DATE));
		}
		if (request.getParameter(SERVICE_END_DATE) != null
				&& request.getParameter(SERVICE_END_DATE) != "") {
			serviceEndDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(SERVICE_END_DATE));
		}
		if (request.getParameter(PREVIOUS_EMPLOYER) != null
				&& request.getParameter(PREVIOUS_EMPLOYER) != "") {
			previousEmployer = request.getParameter(PREVIOUS_EMPLOYER);
		}
		if (request.getParameter(DESIGNATION) != null
				&& request.getParameter(DESIGNATION) != "") {
			designation = request.getParameter(DESIGNATION);
		}
		if (request.getParameter(AWARDS) != null
				&& request.getParameter(AWARDS) != "") {
			awards = request.getParameter(AWARDS);
		}
		if (request.getParameter(PREVIOUS_SERVICE_END_REASON) != null
				&& request.getParameter(PREVIOUS_SERVICE_END_REASON) != "") {
			serviceEndReason = request
					.getParameter(PREVIOUS_SERVICE_END_REASON);
		}
		if (request.getParameter(EMPLOYER_PHONE_NO) != null
				&& request.getParameter(EMPLOYER_PHONE_NO) != "") {
			phone_no = request.getParameter(EMPLOYER_PHONE_NO);
		}
		if (request.getParameter(EMPLOYER_ADDRESS) != null
				&& request.getParameter(EMPLOYER_ADDRESS) != "") {
			address = request.getParameter(EMPLOYER_ADDRESS);
		}
		
		 * if (request.getParameter(COUNTRY) != null &&
		 * request.getParameter(COUNTRY) != "") { countryId = new
		 * Integer(request.getParameter(COUNTRY)); } if
		 * (request.getParameter(STATE) != null && request.getParameter(STATE)
		 * != "") { stateId = new Integer(request.getParameter(STATE)); } if
		 * (request.getParameter(CITY) != null && request.getParameter(CITY) !=
		 * "") { cityId = new Integer(request.getParameter(CITY)); }
		 
		if (request.getParameter(EXPERIENCE_SKILLS) != null
				&& request.getParameter(EXPERIENCE_SKILLS) != "") {
			skills = request.getParameter(EXPERIENCE_SKILLS);
		}

		HrEmployeeExperience employeeExperience = null;
		if (masEmployee.getEmployeeExperience() != null) {
			employeeExperience = masEmployee.getEmployeeExperience();
		} else {
			employeeExperience = new HrEmployeeExperience();
		}
		employeeExperience.setExpYrs(expYears);
		employeeExperience.setExpMonths(expMonths);
		employeeExperience.setServiceStartDate(serviceStartDate);
		employeeExperience.setPreviousEmployer(previousEmployer);
		employeeExperience.setDesignation(designation);
		employeeExperience.setAwards(awards);
		employeeExperience.setPreviousServiceEndReason(serviceEndReason);
		if (!countryId.equals(0)) {
			employeeExperience.setCountryId(countryId);
		}
		if (!stateId.equals(0)) {
			employeeExperience.setStateId(stateId);
		}
		if (!cityId.equals(0)) {
			employeeExperience.setCityId(cityId);
		}
		employeeExperience.setAddress(address);
		employeeExperience.setSkills(skills);
		return employeeExperience;
	}*/

	
		
		public HrMasEmployeeEducation setAndGetEmployeEducation(HrMasEmployeeEducation employeeEducation, HttpServletRequest request,int i
				,boolean incrementFlag)
		{
			
			//for employee education
			Integer qualificationId = 0;
			Integer courseId = 0;
			Integer splQualificationId = 0;
			Integer instituteId = 0;
			Date startDate = null;
			Date endDate  = null;
			Integer courseDuration = 0;
			Date qualifiedDate = null;
			String awards = "";
			String skill = "";
			String passingYear= "";
			String courseDurationUnit="";
			
			if(request.getParameter(QUALIFICATION+i) != null && !request.getParameter(QUALIFICATION+i).equals("0") ) {
				qualificationId = new Integer(request.getParameter(QUALIFICATION+i));
				System.out.println("qualificationId"+qualificationId);
			}
			if(request.getParameter(COURSES_NAME+i) != null && !request.getParameter(COURSES_NAME+i).equals("0")) {
				courseId = new Integer(request.getParameter(COURSES_NAME+i));
				System.out.println("coursesName"+courseId);
			}
			String splQualification="";
			if(request.getParameter(SPL_QUALIFICATION+i) != null && !request.getParameter(SPL_QUALIFICATION+i).equals("")) {
				//splQualificationId = new Integer(request.getParameter(SPL_QUALIFICATION+i));
				splQualification = request.getParameter(SPL_QUALIFICATION+i);
				
				System.out.println("splQualificationId"+splQualification);
			}
			if(request.getParameter(INSTITUTION+i) != null && !request.getParameter(INSTITUTION+i).equals("0")) {
				instituteId = new Integer(request.getParameter(INSTITUTION+i));
			}
			if(request.getParameter(START_DATE+i) != null && !request.getParameter(START_DATE+i).equals("")) {
				startDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(START_DATE+i));
			}
			if(request.getParameter(END_DATE+i) != null && !request.getParameter(END_DATE+i).equals("")) {
				endDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(END_DATE+i));
			}
			if(request.getParameter(HrmsRequestConstants.COURSES_DURATION+i) != null && !request.getParameter(HrmsRequestConstants.COURSES_DURATION+i).equals("") ) {
				courseDuration = new Integer(request.getParameter(HrmsRequestConstants.COURSES_DURATION+i));
			}
			 
	 		if(request.getParameter(HrmsRequestConstants.COURSES_DURATION_UNIT+i) != null) {
				courseDurationUnit = request.getParameter(HrmsRequestConstants.COURSES_DURATION_UNIT+i);
			} 
			 
			if(request.getParameter(QUALIFIED_DATE+i) != null && !request.getParameter(QUALIFIED_DATE+i).equals("")) {
				qualifiedDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(QUALIFIED_DATE+i));
			}
			if(request.getParameter(AWARDS+i) != null) {
				awards = request.getParameter(AWARDS+i);
			}
			if(request.getParameter(EDUCATION_SKILLS+i) != null) {
				skill = request.getParameter(EDUCATION_SKILLS+i);
			}
			 
			if(request.getParameter(HrmsRequestConstants.YEARPASSING+i) != null) {
				passingYear = request.getParameter(HrmsRequestConstants.YEARPASSING+i);
				System.out.println("passingYear>>>>>>>>>>passingYear"+passingYear);
			}
			
			if(employeeEducation == null)
				employeeEducation = new HrMasEmployeeEducation();
			
			if(!qualificationId.equals(0)){
				HrMasQualification masQualification = new HrMasQualification();
				masQualification.setId(qualificationId);
				employeeEducation.setQualification(masQualification);
			}
			if(!courseId.equals(0)){
				HrMasCourse course = new HrMasCourse();
				course.setId(courseId);
				employeeEducation.setCourse(course);
			}
			/*if(!splQualificationId.equals(0)){
				HrMasSpecialQualification specialQualification = new HrMasSpecialQualification();
				specialQualification.setId(splQualificationId);
				employeeEducation.setSplQualification(specialQualification);
			}*/
			
		//	employeeEducation.setSplQualification(splQualification);
			
			if(!instituteId.equals(0)){
				HrMasInstitute institute = new HrMasInstitute();
				institute.setId(instituteId);
				employeeEducation.setInstitute(institute);
			}
			employeeEducation.setSkillDetails(skill);
			if(incrementFlag){
				employeeEducation.setEducationTypeCode(i);	
			}
			employeeEducation.setStartDate(startDate);
			employeeEducation.setEndDate(endDate);
			if(courseDuration != 0){
				employeeEducation.setCourseDuration(courseDuration);	
			}
			employeeEducation.setQualifiedDate(qualifiedDate);
			employeeEducation.setAwards(awards);
			employeeEducation.setCourseDurationUnit(courseDurationUnit);
			employeeEducation.setPassingYear(passingYear);
			return employeeEducation;
		}	
		
		
		
	// added by javed khan
	public HrEmployeeExperience setAndGetEmployeeExperience(HrEmployeeExperience employeeExperience,HttpServletRequest request, int j)
	{
		Integer expYears = null;;
		Integer expMonths=null;
		Date serviceStartDate = null;
		Date serviceEndDate = null;
		String previousEmployer = "";
		String designation = "";
		String awards = "";
		String serviceEndReason = "";
		String phoneNo = "";
		String address = "";
		Integer countryId = 0;
		Integer cityId = 0;
		Integer stateId=0;
		String skills = "";
		
		if (request.getParameter(YEARS+j) != null && !request.getParameter(YEARS+j).equals("")) {
			expYears = new Integer(request.getParameter(YEARS+j));
			System.out.println("expYears>>."+expYears);
		}
		if (request.getParameter(MONTHS+j) != null && !request.getParameter(MONTHS+j).equals("")) {
			expMonths = new Integer(request.getParameter(MONTHS+j));
			System.out.println("expMonths>>."+expMonths);
		}
		if (request.getParameter(SERVICE_START_DATE+j) != null && !request.getParameter(SERVICE_START_DATE+j).equals("")) {
			serviceStartDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SERVICE_START_DATE+j));
			System.out.println("serviceStartDate>>."+serviceStartDate);
		}
		if (request.getParameter(SERVICE_END_DATE+j) != null && !request.getParameter(SERVICE_END_DATE+j).equals("")) {
			serviceEndDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SERVICE_END_DATE+j));
			System.out.println("serviceEndDate>>."+serviceEndDate);
		}
		if (request.getParameter(PREVIOUS_EMPLOYER+j) != null && !request.getParameter(PREVIOUS_EMPLOYER+j).equals("")) {
			previousEmployer = request.getParameter(PREVIOUS_EMPLOYER+j);
		}
		if (request.getParameter(HrmsRequestConstants.DESIGNATION+j) != null && !request.getParameter(HrmsRequestConstants.DESIGNATION+j).equals("")) {
			designation = request.getParameter(HrmsRequestConstants.DESIGNATION+j);
			System.out.println("designation>>."+designation);
		}
		if (request.getParameter(EX_AWARDS+j) != null && !request.getParameter(EX_AWARDS+j).equals("")) {
			awards = request.getParameter(EX_AWARDS+j);
			System.out.println("awards>>."+awards);
		}
		if (request.getParameter(HrmsRequestConstants.PREVIOUS_SERVICE_END_REASON+j) != null && !request.getParameter(HrmsRequestConstants.PREVIOUS_SERVICE_END_REASON+j).equals("")) {
			serviceEndReason = request.getParameter(HrmsRequestConstants.PREVIOUS_SERVICE_END_REASON+j);
			System.out.println("serviceEndReason>>."+serviceEndReason);
		}
		if (request.getParameter(EMPLOYER_PHONE_NO+j) != null && !request.getParameter(EMPLOYER_PHONE_NO+j).equals("")) {
			phoneNo = request.getParameter(EMPLOYER_PHONE_NO+j);
			System.out.println("phoneNo>>."+phoneNo);
		}
		if (request.getParameter(EMPLOYER_ADDRESS+j) != null && !request.getParameter(EMPLOYER_ADDRESS+j).equals("")) {
			address = request.getParameter(EMPLOYER_ADDRESS+j);
			System.out.println("address>>."+address);
		}
/*		if (request.getParameter(COUNTRY) != null && request.getParameter(COUNTRY) != "") {
			countryId = new Integer(request.getParameter(COUNTRY));
		}
		if (request.getParameter(STATE) != null && request.getParameter(STATE) != "") {
			stateId = new Integer(request.getParameter(STATE));
		}
		if (request.getParameter(CITY) != null && request.getParameter(CITY) != "") {
			cityId = new Integer(request.getParameter(CITY));
		}*/
		if (request.getParameter(EXPERIENCE_SKILLS+j) != null && !request.getParameter(EXPERIENCE_SKILLS+j).equals("")) {
			skills = request.getParameter(EXPERIENCE_SKILLS+j);
			System.out.println("skills>>."+skills);
		}
		
		//HrEmployeeExperience employeeExperience  = null;
		if(employeeExperience == null)
			employeeExperience = new HrEmployeeExperience();
		/*if(masEmployee.getEmployeeExperience()!=null){
			employeeExperience = masEmployee.getEmployeeExperience();
		}else{
			employeeExperience = new HrEmployeeExperience();
		}*/
		employeeExperience.setExpYrs(expYears);
		employeeExperience.setExpMonths(expMonths);
		employeeExperience.setServiceStartDate(serviceStartDate);
		employeeExperience.setServiceEndDate(serviceEndDate);
		employeeExperience.setPreviousEmployer(previousEmployer);
		employeeExperience.setDesignation(designation);
		employeeExperience.setAwards(awards);
		employeeExperience.setPreviousServiceEndReason(serviceEndReason);
		employeeExperience.setPhoneNo(phoneNo);
		
		if(!countryId.equals(0)) {
			employeeExperience.setCountryId(countryId);
		}
		if(!stateId.equals(0)) {
			employeeExperience.setStateId(stateId);
		}
		if(!cityId.equals(0)) {
			employeeExperience.setCityId(cityId);
		}
		employeeExperience.setAddress(address);
		employeeExperience.setSkills(skills);
		employeeExperience.setExperienceTypeCode(j);
		return employeeExperience;
	}
	
	
	public HrEmployeePersonelDetails setAndGetEmployeePersonelDetails(
			MasEmployee masEmployee, HttpServletRequest request) {
		Date dateOfBirth = null;
		String passportNo = "";
		Date passportIssueDate = null;
		Date passportExpiryDate = null;
		String passportIssuePlace = "";
		String visaDetails = "";
		String panNo = "";
		String drivingLicence = "";
		Integer maritalStatusId = 0;
		Date marriageDate = null;
		Integer genderId = 0;

		if (null !=request.getParameter(DATE_OF_BIRTH) && !request.getParameter(DATE_OF_BIRTH).equals("") ) {
			dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(DATE_OF_BIRTH));
		}
		if (request.getParameter("passportNumber") != null && !request.getParameter("passportNumber").equals("")) {
			passportNo = request.getParameter("passportNumber");
		}
		if (request.getParameter(PASSPORTISSUEDATE) != null && !request.getParameter(PASSPORTISSUEDATE).equals("")) {
			passportIssueDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PASSPORTISSUEDATE));
		}
		if (request.getParameter(PASSPORTEXPIRYDATE) != null && !request.getParameter(PASSPORTEXPIRYDATE).equals("")) {
			passportExpiryDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(PASSPORTEXPIRYDATE));
		}
		if (request.getParameter(PASSPORTISSUEPLACE) != null && !request.getParameter(PASSPORTISSUEPLACE).equals("")) {
			passportIssuePlace = request.getParameter(PASSPORTISSUEPLACE);
		}
		if (request.getParameter(VISADETAILS) != null && !request.getParameter(VISADETAILS).equals("")) {
			visaDetails = request.getParameter(VISADETAILS);
		}
		if (request.getParameter(DRIVING) != null && !request.getParameter(DRIVING).equals("")) {
			drivingLicence = request.getParameter(DRIVING);
		}
		if (request.getParameter(PANNO) != null && !request.getParameter(PANNO).equals("")) {
			panNo = request.getParameter(PANNO);
		}
		if (request.getParameter(MARITAL_STATUS_ID) != null && !request.getParameter(MARITAL_STATUS_ID).equals("")) {
			maritalStatusId = new Integer(
					request.getParameter(MARITAL_STATUS_ID));
		}
		if (request.getParameter(MARRIAGE_DATE) != null && !request.getParameter(MARRIAGE_DATE).equals("")) {
			marriageDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(MARRIAGE_DATE));
		}
		if (request.getParameter(GENDER) != null) {
			genderId = new Integer(request.getParameter(GENDER));
		}

		HrEmployeePersonelDetails employeePersonelDetails = null;
		if (masEmployee.getPersonalDetails() != null) {
			employeePersonelDetails = masEmployee.getPersonalDetails();
		} else {
			employeePersonelDetails = new HrEmployeePersonelDetails();
		}

		employeePersonelDetails.setDateOfBirth(dateOfBirth);
		System.out.println("passportNo>>"+passportNo);
		employeePersonelDetails.setPassportNo(passportNo);
		employeePersonelDetails.setPassportIssueDate(passportIssueDate);
		employeePersonelDetails.setPassportExpiryDate(passportExpiryDate);
		employeePersonelDetails.setPassportIssuePlace(passportIssuePlace);
		employeePersonelDetails.setVisaDetails(visaDetails);
		employeePersonelDetails.setPanNo(panNo);
		employeePersonelDetails.setDrivingLicence(drivingLicence);
		employeePersonelDetails.setMarriageDate(marriageDate);

		if (!genderId.equals(0)) {
			MasAdministrativeSex gender = new MasAdministrativeSex();
			gender.setId(genderId);
			employeePersonelDetails.setGender(gender);
		}

		if (!maritalStatusId.equals(0)) {
			MasMaritalStatus maritalStatus = new MasMaritalStatus();
			maritalStatus.setId(maritalStatusId);
			employeePersonelDetails.setMaritalStatus(maritalStatus);
		}

		return employeePersonelDetails;
	}

	public ModelAndView editEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int departmentId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		String bankBranch="";
		String ifscCode="";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = new Date();
		Date changedDate = new Date();
		@SuppressWarnings("unused")
		String changedTime = "";
		int employeeId = 0;
		String bankAccountNumber = "";
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
		}
		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (request.getParameter(EMPLOYEE_JOB_CODE) != null) {
			jobCode = request.getParameter(EMPLOYEE_JOB_CODE);
		}
		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if (request.getParameter(EMPLOYEE_GRADE) != null) {
			grade = request.getParameter(EMPLOYEE_GRADE);
		}
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accountHead = request.getParameter(ACCOUNT_HEAD);
		}
		if(request.getParameter("bankBranch") != null) {
			bankBranch=request.getParameter("bankBranch");
		}
		if(request.getParameter("ifscCode") != null) {
			ifscCode=request.getParameter("ifscCode");
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		if (request.getParameter(APPOINTMENT_DATE) != null) {
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}
		if (request.getParameter(JOIN_DATE) != null) {
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		if (request.getParameter(EMPLOYEE_CATEGORY_ID) != null
				&& !request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (!request.getParameter(COST_CENTER_ID).equals("0")) {
			costCenterId = Integer.parseInt(request
					.getParameter(COST_CENTER_ID));
		}
		if (!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if (!request.getParameter(UNIT_ID).equals("0")) {
			unitId = Integer.parseInt(request.getParameter(UNIT_ID));
		}
		if (!request.getParameter(TRADE_ID).equals("0")) {
			tradeId = Integer.parseInt(request.getParameter(TRADE_ID));
		}
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", employeeId);
		generalMap.put("personnelId", personnelId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		generalMap.put("serviceNo", serviceNo);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);
		generalMap.put("jobCode", jobCode);
		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);
		generalMap.put("emergencyTellNumber", emergencyTellNumber);
		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		generalMap.put("joinDate", joinDate);
		generalMap.put("gradeId", gradeId);
		generalMap.put("empCategoryId", empCategoryId);
		generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("costCenterId", costCenterId);
		generalMap.put("grade", grade);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("bankAccountNumber", bankAccountNumber);
		generalMap.put("bankAccountCode", bankAccountCode);
		generalMap.put("bankBranch", bankBranch);
		generalMap.put("ifscCode", ifscCode);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		boolean dataUpdated = false;
		dataUpdated = personnelMasterHandlerService
				.editEmployeeToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "update Employee";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView editEmployeeCliniRx(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		String employeeCode = "";
		String firstName = "";
		String middleName = "";
		String lastName = "";
		int departmentId = 0;
		int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int personnelId = 0;
		int gradeId = 0;
		int rankId = 0;
		int unitId = 0;
		int tradeId = 0;
		String serviceNo = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "";
		String residenceTellNumber = "";
		String officeTellNumber = "";
		Date appointmentDate = new Date();
		String jobCode = "";
		String changedBy = "";
		String email = "";
		String bankCode = "";
		String employeePhoto = "";
		String employeeUrl = "";
		String accountHead = "";
		int titleId = 0;
		String bankAccountCode = "";
		String grade = "";
		Date joinDate = new Date();
		Date changedDate = new Date();
		@SuppressWarnings("unused")
		String changedTime = "";
		int employeeId = 0;
		String bankAccountNumber = "";
		session = request.getSession(true);
		int hospitalId = (Integer) session.getAttribute("hospitalId");

		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(EMPLOYEE_CODE) != null
				&& !(request.getParameter(EMPLOYEE_CODE).equals(""))) {
			employeeCode = request.getParameter(EMPLOYEE_CODE);
		}

		if (!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}

		if (request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber = request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		/*
		 * if(request.getParameter(EMPLOYEE_GRADE) != null) {
		 * grade=request.getParameter(EMPLOYEE_GRADE); }
		 */
		if (request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode = request.getParameter(BANK_ACCOUNT_CODE);
		}
		if (request.getParameter(ACCOUNT_HEAD) != null) {
			accountHead = request.getParameter(ACCOUNT_HEAD);
		}
		if (request.getParameter(BANK_CODE) != null) {
			bankCode = request.getParameter(BANK_CODE);
		}
		if (request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber = request.getParameter(EMERGENCY_PHONE);
		}
		if (request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber = request.getParameter(EMERGENCY_MOBILE);
		}
		if (request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber = request.getParameter(TELL_NO_RESIDENCE);
		}
		if (request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber = request.getParameter(TELL_NO_OFFICE);
		}
		if (request.getParameter(EMAIL) != null) {
			email = request.getParameter(EMAIL);
		}
		if (request.getParameter(APPOINTMENT_DATE) != null) {
			appointmentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(APPOINTMENT_DATE));
		}
		if (request.getParameter(JOIN_DATE) != null) {
			joinDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(JOIN_DATE));
		}
		/*
		 * if(!request.getParameter(EMPLOYEE_CATEGORY_ID).equals("0")) {
		 * empCategoryId =
		 * Integer.parseInt(request.getParameter(EMPLOYEE_CATEGORY_ID)); }
		 */
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}

		/*
		 * if(!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) { gradeId =
		 * Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID)); }
		 */
		if (!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}

		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if (request.getParameter("pojoPropertyName") != null) {
			pojoPropertyName = request.getParameter("pojoPropertyName");
		}

		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto = request.getParameter(EMPLOYEE_PHOTO);
		}
		if (request.getParameter(URL) != null) {
			employeeUrl = request.getParameter(URL);
		}
		personnelId = (Integer) session.getAttribute(HOSPITAL_ID);

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", employeeId);
		generalMap.put("personnelId", personnelId);
		generalMap.put("titleId", titleId);
		generalMap.put("employeeCode", employeeCode);
		// generalMap.put("serviceNo", serviceNo);
		generalMap.put("firstName", firstName);
		generalMap.put("middleName", middleName);
		generalMap.put("personnelId", personnelId);
		generalMap.put("lastName", lastName);
		// generalMap.put("jobCode", jobCode);
		generalMap.put("bankCode", bankCode);
		generalMap.put("employeePhoto", employeePhoto);
		generalMap.put("employeeUrl", employeeUrl);
		generalMap.put("emergencyTellNumber", emergencyTellNumber);
		generalMap.put("emergencyCellNumber", emergencyCellNumber);
		generalMap.put("residenceTellNumber", residenceTellNumber);
		generalMap.put("officeTellNumber", officeTellNumber);
		generalMap.put("email", email);
		generalMap.put("accountHead", accountHead);
		generalMap.put("appointmentDate", appointmentDate);
		generalMap.put("joinDate", joinDate);
		// generalMap.put("gradeId", gradeId);
		// generalMap.put("empCategoryId", empCategoryId);
		// generalMap.put("tradeId", tradeId);
		generalMap.put("rankId", rankId);
		// generalMap.put("unitId", unitId);
		generalMap.put("departmentId", departmentId);
		generalMap.put("empStatusId", empStatusId);
		// generalMap.put("costCenterId", costCenterId);
		// generalMap.put("grade", grade);
		generalMap.put("empStatusId", empStatusId);
		generalMap.put("bankAccountNumber", bankAccountNumber);
		generalMap.put("bankAccountCode", bankAccountCode);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("hospitalId", hospitalId);
		boolean dataUpdated = false;
		dataUpdated = personnelMasterHandlerService
				.editEmployeeToDatabase(generalMap);
		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";
		} else {
			message = "Record Cant Be Updated !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "update Employee";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId = 0;
		String message = null;
		//String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		int hospitalId = 0;
		Users changedBy = null;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		
		if (session.getAttribute("users") != null) {
			changedBy = (Users) session.getAttribute("users");
		}
		
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteEmployee(employeeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = EMPLOYEE_JSP;
		title = "Delete Employee";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -------------------------------------- Referral
	// Doctor--------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showReferralDoctorJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showReferralDoctorJsp();
		@SuppressWarnings("unused")
		ArrayList searchReferralDoctorList = (ArrayList) map
				.get("searchReferralDoctorList");
		jsp = REFERRAL_DOCTOR_JSP;
		jsp += ".jsp";
		title = "ReferralDoctor";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasReferralDoctor masReferralDoctor = new MasReferralDoctor();
		int departmentId = 0;
		int changedBy = 0;
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(DEPARTMENT_ID) != null) {
			departmentId = Integer.valueOf(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(ADDRESS_1) != null) {
			address1 = request.getParameter(ADDRESS_1);
		}
		if (request.getParameter(ADDRESS_2) != null) {
			address2 = request.getParameter(ADDRESS_2);
		}
		if (request.getParameter(PHONE) != null) {
			phoneNo = request.getParameter(PHONE);
		}
		if (request.getParameter(MOBILE) != null) {
			mobileNo = request.getParameter(MOBILE);
		}
		if (request.getParameter(REFERRAL_TYPE) != null) {
			referralType = Integer.valueOf(request.getParameter(REFERRAL_TYPE));
		}
		changedBy  = (Integer) session.getAttribute("userId");
		
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
		List referralDoctorNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			referralDoctorNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((referralDoctorNameList.size() == 0 || referralDoctorNameList == null)) {
			masReferralDoctor.setDoctorName(name);

			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			masReferralDoctor.setDepartment(masDepartment);

			masReferralDoctor.setAddress1(address1);
			masReferralDoctor.setAddress2(address2);
			masReferralDoctor.setPhoneNo(phoneNo);
			masReferralDoctor.setMobileNo(mobileNo);
			masReferralDoctor.setReferralType(referralType);
			masReferralDoctor.setStatus("y");
			Users users = new Users();
			users.setId(changedBy);
			masReferralDoctor.setLastChgBy(users);
			masReferralDoctor.setLastChgDate(currentDate);
			masReferralDoctor.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addReferralDoctor(masReferralDoctor);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((referralDoctorNameList.size() != 0)
				|| referralDoctorNameList != null) {

			if ((referralDoctorNameList.size() != 0 || referralDoctorNameList != null)) {
				message = "Referral Doctor Name  already exists.";
			}
		}
		url = "/hms/hms/personnel?method=showReferralDoctorJsp";
		try {
			map = personnelMasterHandlerService.showReferralDoctorJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "add ReferralDoctor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String referralDoctorName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referralDoctorName = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService
				.searchReferralDoctor(referralDoctorName);
		jsp = REFERRAL_DOCTOR_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("referralDoctorName", referralDoctorName);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String referralDoctorName = "";
		int departmentId = 0;
		int referralDoctorId = 0;
		int changedBy = 0;
		Date changedDate = null;
		String changedTime = "";
		String address1 = "";
		String address2 = "";
		String phoneNo = "";
		String mobileNo = "";
		int referralType = 0;

		referralDoctorName = (String) session
				.getAttribute("referralDoctorName");
		if (request.getParameter(ADDRESS_1) != null) {
			address1 = request.getParameter(ADDRESS_1);
		}
		if (request.getParameter(ADDRESS_2) != null) {
			address2 = request.getParameter(ADDRESS_2);
		}
		if (request.getParameter(PHONE) != null) {
			phoneNo = request.getParameter(PHONE);
		}
		if (request.getParameter(MOBILE) != null) {
			mobileNo = request.getParameter(MOBILE);
		}
		if (request.getParameter(REFERRAL_TYPE) != null) {
			referralType = Integer.valueOf(request.getParameter(REFERRAL_TYPE));
		}

		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			referralDoctorId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			referralDoctorName = request.getParameter(SEARCH_NAME);
		}
		changedBy  = (Integer) session.getAttribute("userId");
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

		generalMap.put("id", referralDoctorId);
		generalMap.put("name", referralDoctorName);
		generalMap.put("departmentId", departmentId);
		generalMap.put("addressOne", address1);
		generalMap.put("addressTwo", address2);
		generalMap.put("phoneNo", phoneNo);
		generalMap.put("mobileNo", mobileNo);
		generalMap.put("referralType", referralType);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingReferralDoctorNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingReferralDoctorNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editReferralDoctorToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showReferralDoctorJsp";
			try {
				map = personnelMasterHandlerService.showReferralDoctorJsp();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingReferralDoctorNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "edit ReferralDoctor";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteReferralDoctor(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int referralDoctorId = 0;
		String message = null;
		int changedBy = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			referralDoctorId = Integer
					.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedBy  = (Integer) session.getAttribute("userId");
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteReferralDoctor(
				referralDoctorId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showReferralDoctorJsp";
		try {
			map = personnelMasterHandlerService.showReferralDoctorJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = REFERRAL_DOCTOR_JSP;
		title = "delete ReferralDoctor";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	// -----------------------------------Rank------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRankJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showRankJsp();
		jsp = RANK_JSP;
		jsp += ".jsp";
		title = "Rank";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		MasRank masRank = new MasRank();
		int serviceTypeId = 0;
		int rankCategoryId = 0;
		int serviceStatusId = 0;
		int wing_id=0;
		int stream_id=0;
		int grade_id=0;
		int cadre_id=0;
		/*String changedBy = "";*/
		Users changedBy = null;
		String desc="";
		int designationOrder=0;
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		if (request.getParameter(CODE) != null && !request.getParameter(CODE).equals("")) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null && !request.getParameter(SEARCH_NAME).equals("")) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(RANK_CATEGORY_ID) != null && !request.getParameter(RANK_CATEGORY_ID).equals("")) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY_ID));
		}
		if (request.getParameter(SERVICE_STATUS_ID) != null && !request.getParameter(SERVICE_STATUS_ID).equals("")) {
			serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null && !request.getParameter(SERVICE_TYPE_ID).equals("")) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if (session.getAttribute("users")!= null ) {
			changedBy = (Users)session.getAttribute("users");
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
		if (request.getParameter("wing") != null && !request.getParameter("wing").equals("")) {
			wing_id = Integer.parseInt(request.getParameter("wing"));				
		}
		if (request.getParameter("grade") != null && !request.getParameter("grade").equals("")) {
			grade_id = Integer.parseInt(request.getParameter("grade"));					
		}
		if (request.getParameter("stream") != null && !request.getParameter("stream").equals("")) {
			stream_id = Integer.parseInt(request.getParameter("stream"));					
		}
		if (request.getParameter("cadre") != null && !request.getParameter("cadre").equals("")) {
			cadre_id = Integer.parseInt(request.getParameter("cadre"));					
		}
		if (request.getParameter("designationOrder") != null && !request.getParameter("designationOrder").equals("")) {
			designationOrder =  Integer.parseInt(request.getParameter("designationOrder"));
		}
		if (request.getParameter("description") != null && !(request.getParameter("description").equals(""))) {
			desc = request.getParameter("description");					
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null && !request.getParameter(SERVICE_TYPE_ID).equals("")) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
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
		List rankCodeList = new ArrayList();
		List rankNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			rankCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			rankNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((rankCodeList.size() == 0 || rankCodeList == null)
				&& (rankNameList.size() == 0 || rankNameList == null)) {
			masRank.setRankCode(code);
			masRank.setRankName(name);

			/*
			 * MasServiceStatus masServiceStatus= new MasServiceStatus();
			 * masServiceStatus.setId(serviceStatusId);
			 * masRank.setServiceStatus(masServiceStatus);
			 *
			 * MasServiceType masServiceType= new MasServiceType();
			 * masServiceType.setId(serviceTypeId);
			 * masRank.setServiceType(masServiceType);
			 *
			 * MasRankCategory masRankCategory= new MasRankCategory();
			 * masRankCategory.setId(rankCategoryId);
			 * masRank.setRankCategory(masRankCategory);
			 */
			
			MasWing mw = new MasWing();
			mw.setId(wing_id);
			masRank.setWing(mw);
			
			MasGrade mg = new MasGrade();
			mg.setId(grade_id);
			masRank.setGrade(mg);
			
			MasStream ms = new MasStream();
			ms.setId(stream_id);
			masRank.setStream(ms);
			
			MasCadre mc = new MasCadre();
			mc.setId(cadre_id);
			masRank.setCadre(mc);
			
			masRank.setDesignationOrder(designationOrder);
			masRank.setDescription(desc);
			masRank.setStatus("y");
			masRank.setLastChgBy(changedBy);
			masRank.setLastChgDate(currentDate);
			masRank.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService.addRank(masRank);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((rankCodeList.size() != 0 || rankCodeList != null)
				|| (rankNameList.size() != 0) || rankNameList != null) {

			if ((rankCodeList.size() != 0 || rankCodeList != null)
					&& (rankNameList.size() == 0 || rankNameList == null)) {

				message = "Rank Code  already exists.";
			} else if ((rankNameList.size() != 0 || rankNameList != null)
					&& (rankCodeList.size() == 0 || rankCodeList == null)) {
				message = "Rank Name  already exists.";
			} else if ((rankCodeList.size() != 0 || rankCodeList != null)
					&& (rankNameList.size() != 0 || rankNameList != null)) {

				message = "Rank Code and Rank Name already exist.";
			}
		}

		url = "/hms/hms/personnel?method=showRankJsp";
		try {
			map = personnelMasterHandlerService.showRankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_JSP;
		title = "Add Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRank(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String rankCode = null;
		String rankName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankName = request.getParameter(SEARCH_NAME);
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
			rankCode = searchField;
			rankName = null;

		} else {
			rankCode = null;
			rankName = searchField;
		}
		map = personnelMasterHandlerService.searchRank(rankCode, rankName);
		jsp = RANK_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("rankCode", rankCode);
		map.put("rankName", rankName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editRank(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String rankCode = "";
		String rankName = "";
		int rankCategoryId = 0;
		int serviceStatusId = 0;
		int serviceTypeId = 0;
		int rankId = 0;
		/*String changedBy = "";*/
		Users changedBy = null;
		Date changedDate = null;
		String changedTime = "";
		int wing_id=0;
		int stream_id=0;
		int grade_id=0;
		int cadre_id=0;
		int designationOrder =0 ;
		String desc="";

		if (request.getParameter(SERVICE_TYPE_ID) != null && !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(RANK_CATEGORY_ID) != null && !(request.getParameter(RANK_CATEGORY_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(RANK_CATEGORY_ID));
		}
		if (request.getParameter(SERVICE_STATUS_ID) != null && !request.getParameter(SERVICE_STATUS_ID).equals("")) {
			serviceStatusId = Integer.parseInt(request.getParameter(SERVICE_STATUS_ID));
		}
		if (request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null && !(request.getParameter(CODE).equals(""))) {
			rankCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null && !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankName = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if (session.getAttribute("users")!= null ) {
			changedBy = (Users)session.getAttribute("users");
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
		if (request.getParameter("wing") != null && !request.getParameter("wing").equals("")) {
			wing_id = Integer.parseInt(request.getParameter("wing"));				
		}
		if (request.getParameter("grade") != null && !request.getParameter("grade").equals("")) {
			grade_id = Integer.parseInt(request.getParameter("grade"));					
		}
		if (request.getParameter("stream") != null && !request.getParameter("stream").equals("")) {
			stream_id = Integer.parseInt(request.getParameter("stream"));					
		}
		if (request.getParameter("cadre") != null && !request.getParameter("cadre").equals("")) {
			cadre_id = Integer.parseInt(request.getParameter("cadre"));					
		}
		if (request.getParameter("designationOrder") != null && !request.getParameter("designationOrder").equals("")) {
			designationOrder =  Integer.parseInt(request.getParameter("designationOrder"));
		}
		if (request.getParameter("description") != null && !(request.getParameter("description").equals(""))) {
			desc = request.getParameter("description");					
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", rankId);
		generalMap.put("rankCode", rankCode);
		generalMap.put("name", rankName);
		generalMap.put("rankCategoryId", rankCategoryId);
		generalMap.put("serviceStatusId", serviceStatusId);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		
		generalMap.put("grade", grade_id);
		generalMap.put("wing", wing_id);
		generalMap.put("stream", stream_id);
		generalMap.put("cadre", cadre_id);
		generalMap.put("designationOrder", designationOrder);
		generalMap.put("desc", desc);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRankNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRankNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editRankToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showRankJsp";

			try {
				map = personnelMasterHandlerService.showRankJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingRankNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = RANK_JSP;
		title = "Edit Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteRank(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rankId = 0;
		String message = null;
		/*String changedBy = "";*/
		Users changedBy = null;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			rankId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if (session.getAttribute("users")!= null ) {
			changedBy = (Users)session.getAttribute("users");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteRank(rankId,
				generalMap);
		if (dataDeleted == true) {

			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showRankJsp";
		try {
			map = personnelMasterHandlerService.showRankJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_JSP;
		title = "delete Rank";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// -----------------------------------formation
	// -------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showFormationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showFormationJsp();
		@SuppressWarnings("unused")
		ArrayList searchFormationList = (ArrayList) map
				.get("searchFormationList");
		jsp = FORMATION_JSP;
		jsp += ".jsp";
		title = "Formation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unchecked")
	public ModelAndView addFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasFormation masFormation = new MasFormation();
		int serviceTypeId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}

		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.valueOf(request
					.getParameter(SERVICE_TYPE_ID));
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
		List formationCodeList = new ArrayList();
		List formationNameList = new ArrayList();
		if (listMap.get("duplicateGeneralCodeList") != null) {
			formationCodeList = (List) listMap.get("duplicateGeneralCodeList");

		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			formationNameList = (List) listMap.get("duplicateGeneralNameList");

		}
		boolean successfullyAdded = false;
		if ((formationCodeList.size() == 0 || formationCodeList == null)
				&& (formationNameList.size() == 0 || formationNameList == null))

		{
			masFormation.setFormationCode(code);
			masFormation.setFormationName(name);
			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masFormation.setServiceType(masServiceType);

			masFormation.setStatus("y");
			masFormation.setLastChgBy(changedBy);
			masFormation.setLastChgDate(currentDate);
			masFormation.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addFormation(masFormation);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((formationCodeList.size() != 0 || formationCodeList != null)
				|| (formationNameList.size() != 0) || formationNameList != null) {

			if ((formationCodeList.size() != 0 || formationCodeList != null)
					&& (formationNameList.size() == 0 || formationNameList == null)) {

				message = "Formation Code  already exists.";
			} else if ((formationNameList.size() != 0 || formationNameList != null)
					&& (formationCodeList.size() == 0 || formationCodeList == null)) {
				message = "Formation Name  already exists.";
			} else if ((formationCodeList.size() != 0 || formationCodeList != null)
					&& (formationNameList.size() != 0 || formationNameList != null)) {

				message = "Formation Code and Formation Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showFormationJsp";
		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "Add Formation";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchFormation(HttpServletRequest request,
			HttpServletResponse response) throws

	ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String formationCode = null;
		String formationName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			formationCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formationName = request.getParameter(SEARCH_NAME);
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
			formationCode = searchField;
			formationName = null;

		} else {
			formationCode = null;
			formationName = searchField;
		}
		map = personnelMasterHandlerService.searchFormation(formationCode,
				formationName);
		jsp = FORMATION_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		map.put("formationCode", formationCode);
		map.put("formationName", formationName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String formationCode = "";
		String formationName = "";
		int serviceTypeId = 0;
		int formationId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		formationCode = (String) session.getAttribute("formationCode");
		formationName = (String) session.getAttribute("formationName");
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			formationId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			formationCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			formationName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", formationId);
		generalMap.put("formationCode", formationCode);
		generalMap.put("name", formationName);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingFormationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingFormationNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editFormationToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingFormationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showFormationJsp";

		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "Edit Formation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteFormation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int formationId = 0;
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
			formationId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteFormation(
				formationId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showFormationJsp";

		try {
			map = personnelMasterHandlerService.showFormationJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = FORMATION_JSP;
		title = "delete Formation";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------------------ Trade
	// -----------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showTradeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showTradeJsp();
		jsp = TRADE_JSP;
		jsp += ".jsp";
		title = "Trade";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasTrade masTrade = new MasTrade();

		int serviceTypeId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.valueOf(request
					.getParameter(SERVICE_TYPE_ID));
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
		List tradeNameList = new ArrayList();

		if (listMap.get("duplicateGeneralNameList") != null) {
			tradeNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((tradeNameList.size() == 0 || tradeNameList == null)) {
			masTrade.setTradeName(name);
			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masTrade.setServiceType(masServiceType);

			masTrade.setStatus("y");
			masTrade.setLastChgBy(changedBy);
			masTrade.setLastChgDate(currentDate);
			masTrade.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addTrade(masTrade);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((tradeNameList.size() != 0) || tradeNameList != null) {

			if ((tradeNameList.size() != 0 || tradeNameList != null)) {
				message = "Trade Name already exists.";
			}
		}
		url = "/hms/hms/personnel?method=showTradeJsp";
		try {
			map = personnelMasterHandlerService.showTradeJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRADE_JSP;
		title = "Add Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchTrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String tradeName = null;
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			tradeName = request.getParameter(SEARCH_NAME);

		}
		map = personnelMasterHandlerService.searchTrade(tradeName);

		jsp = TRADE_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("tradeName", tradeName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String tradeName = "";
		int serviceTypeId = 0;
		int tradeId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

		tradeName = (String) session.getAttribute("tradeName");
		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			tradeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			tradeName = request.getParameter(SEARCH_NAME);
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

		generalMap.put("id", tradeId);

		generalMap.put("name", tradeName);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);
		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingTradeNameList = (List) listMap.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingTradeNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editTradeToDatabase(generalMap);
			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
			url = "/hms/hms/personnel?method=showTradeJsp";
			try {
				map = personnelMasterHandlerService.showTradeJsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (existingTradeNameList.size() > 0) {

			message = "Name already exists.";
		}
		jsp = TRADE_JSP;
		title = "Edit Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteTrade(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int tradeId = 0;
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
			tradeId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteTrade(tradeId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showTradeJsp";
		try {
			map = personnelMasterHandlerService.showTradeJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = TRADE_JSP;
		title = "delete Trade";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Unit
	// ----------------------------------

	public ModelAndView searchUnit(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String unitName = null;

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService.searchUnit(unitName);
		jsp = UNIT_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("unitName", unitName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showUnitJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map map = new HashMap();
		map = personnelMasterHandlerService.showUnitJsp();
		String jsp = UNIT_JSP;
		jsp += ".jsp";
		title = "Unit";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasUnit masUnit = new MasUnit();
		String unitAddress = "";
		//String changedBy = "";
		int userId=0;
		HttpSession session=request.getSession();
		String local = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(UNIT_ADDRESS) != null) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		
		if(session.getAttribute("userId") != null){
			userId=(Integer)session.getAttribute("userId");
		 }
		 
		if (request.getParameter(LOCAL_UNIT) != null) {
			masUnit.setLocalUnit("y");
		} else {
			masUnit.setLocalUnit("n");
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
		 
		Users user=new Users();
        user.setId(userId);
		generalMap.put("name", name);

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
		boolean successfullyAdded = false;

		if ((unitNameList.size() == 0 || unitNameList == null)
				&& (unitNameList.size() == 0 || unitNameList == null)) {
			masUnit.setUnitAddress(unitAddress);
			masUnit.setUnitName(name);
			masUnit.setStatus("y");
 			masUnit.setLastChgDate(currentDate);
			masUnit.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService.addUnit(masUnit);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((unitNameList.size() != 0) || unitNameList != null) {
			if ((unitNameList.size() != 0 || unitNameList != null)) {
				message = "Unit Name already exists.";
			}
		}
		try {
			map = personnelMasterHandlerService.showUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "Add Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		MasUnit masUnit = new MasUnit();
		session = request.getSession();
		String unitAddress = "";
		String unitName = "";
		int unitId = 0;
		String local = "";
  		int userId=0;
		HttpSession session=request.getSession();
		Date changedDate = null;
		String changedTime = "";
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			unitId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(UNIT_ADDRESS) != null
				&& !(request.getParameter(UNIT_ADDRESS).equals(""))) {
			unitAddress = request.getParameter(UNIT_ADDRESS);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			unitName = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(LOCAL_UNIT) != null) {
			local = "y";
		} else {
			local = "n";
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

	     Users user=new Users();
	     user.setId(userId);
 		generalMap.put("id", unitId);
		generalMap.put("unitAddress", unitAddress);
		generalMap.put("name", unitName);
		generalMap.put("local", local);
 		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService
					.editUnitToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showUnitJsp";

		try {
			map = personnelMasterHandlerService.showUnitJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "update Unit";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteUnit(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int unitId = 0;
		String message = null;
		//String changedBy = "";
		int userId=0;
		HttpSession session=request.getSession();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			unitId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteUnit(unitId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showUnitJsp";

		try {
			map = personnelMasterHandlerService.showUnitJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = UNIT_JSP;
		title = "delete Unit";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------RecordOfficeAddress--------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showRecordOfficeAddressJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		jsp += ".jsp";
		title = "RecordOfficeAddress";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRecordOfficeAddress masRecordOfficeAddress = new MasRecordOfficeAddress();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		int serviceTypeId = 0;
		String changedBy = "";

		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(SERVICE_TYPE_ID) != null) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
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
		List recordOfficeAddressList = new ArrayList();

		if (listMap.get("duplicateGeneralAddressList") != null) {
			recordOfficeAddressList = (List) listMap
					.get("duplicateGeneralAddressList");
		}
		boolean successfullyAdded = false;
		if (recordOfficeAddressList.size() == 0) {
			masRecordOfficeAddress.setAddress(address);

			MasServiceType masServiceType = new MasServiceType();
			masServiceType.setId(serviceTypeId);
			masRecordOfficeAddress.setServiceType(masServiceType);

			masRecordOfficeAddress.setStatus("y");
			masRecordOfficeAddress.setLastChgBy(changedBy);
			masRecordOfficeAddress.setLastChgDate(currentDate);
			masRecordOfficeAddress.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addRecordOfficeAddress(masRecordOfficeAddress);

			if (successfullyAdded) {

				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";

			}
		} else if ((recordOfficeAddressList.size() != 0)
				|| recordOfficeAddressList != null) {

			if ((recordOfficeAddressList.size() != 0 || recordOfficeAddressList != null)) {
				message = "Record Office Address already exists.";
			}
		}

		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";
		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "Add Record Office Address";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String recordOfficeAddress = "";

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			recordOfficeAddress = request.getParameter(SEARCH_NAME);
		}
		map = personnelMasterHandlerService
				.searchRecordOfficeAddress(recordOfficeAddress);
		jsp = RECORD_OFFICE_ADDRESS_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("recordOfficeAddress", recordOfficeAddress);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView editRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String address = "";
		int serviceTypeId = 0;
		int recordOfficeAddressId = 0;
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";

		if (request.getParameter(SERVICE_TYPE_ID) != null
				&& !(request.getParameter(SERVICE_TYPE_ID).equals(""))) {
			serviceTypeId = Integer.parseInt(request
					.getParameter(SERVICE_TYPE_ID));
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			recordOfficeAddressId = Integer.parseInt(request
					.getParameter(COMMON_ID));
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter("pojoPropertyAddress") != null) {
			pojoPropertyAddress = request.getParameter("pojoPropertyAddress");
		}
		if (request.getParameter("pojoName") != null) {
			pojoName = request.getParameter("pojoName");
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("id", recordOfficeAddressId);
		generalMap.put("name", name);
		generalMap.put("serviceTypeId", serviceTypeId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyAddress", pojoPropertyAddress);
		generalMap.put("pojoName", pojoName);

		boolean dataUpdated = false;

		dataUpdated = personnelMasterHandlerService
				.editRecordOfficeAddress(generalMap);

		if (dataUpdated == true) {
			message = "Data updated Successfully !!";
		} else {
			message = "Data Cant be updated !!";
		}
		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";

		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "Edit RecordOfficeAddress";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView deleteRecordOfficeAddress(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int recordOfficeAddressId = 0;
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
			recordOfficeAddressId = Integer.parseInt(request
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
		dataDeleted = personnelMasterHandlerService.deleteRecordOfficeAddress(
				recordOfficeAddressId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showRecordOfficeAddressJsp";
		try {
			map = personnelMasterHandlerService.showRecordOfficeAddressJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RECORD_OFFICE_ADDRESS_JSP;
		title = "delete RecordOfficeAddress";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// ---------------------------Rank Category----------------------------
	@SuppressWarnings("unchecked")
	public ModelAndView showRankCategoryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = personnelMasterHandlerService.showRankCategoryJsp();
		@SuppressWarnings("unused")
		ArrayList searchRankCategoryList = (ArrayList) map
				.get("searchRankCategoryList");
		jsp = RANK_CATEGORY_JSP;
		jsp += ".jsp";
		title = "rankCategory";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchRankCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String rankCategoryCode = null;
		String rankCategoryName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankCategoryName = request.getParameter(SEARCH_NAME);
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
			rankCategoryCode = searchField;
			rankCategoryName = null;
		} else {
			rankCategoryCode = null;
			rankCategoryName = searchField;
		}
		map = personnelMasterHandlerService.searchRankCategory(
				rankCategoryCode, rankCategoryName);
		jsp = RANK_CATEGORY_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("rankCategoryCode", rankCategoryCode);
		map.put("rankCategoryName", rankCategoryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addRankCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasRankCategory masRankCategory = new MasRankCategory();
		String changedBy = "";
		int userId=0;
		HttpSession session=request.getSession();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();

		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute("userId")!= null
				&& !(session.getAttribute("userId").equals(""))) {
			userId = (Integer)session.getAttribute("userId");
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
		List rankCategoryCodeList = new ArrayList();
		List rankCategoryNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			rankCategoryCodeList = (List) listMap
					.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			rankCategoryNameList = (List) listMap
					.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((rankCategoryCodeList.size() == 0 || rankCategoryCodeList == null)
				&& (rankCategoryNameList.size() == 0 || rankCategoryNameList == null)) {
			masRankCategory.setRankCategoryCode(code);
			masRankCategory.setRankCategoryName(name);
			masRankCategory.setStatus("y");
			Users user=new Users();
			user.setId(userId);
			masRankCategory.setLastChgBy(user);
			masRankCategory.setLastChgDate(currentDate);
			masRankCategory.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addRankCategory(masRankCategory);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
				|| (rankCategoryNameList.size() != 0)
				|| rankCategoryNameList != null) {
			if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
					&& (rankCategoryNameList.size() == 0 || rankCategoryNameList == null)) {
				message = "Rank Category Code  already exists.";
			} else if ((rankCategoryNameList.size() != 0 || rankCategoryNameList != null)
					&& (rankCategoryCodeList.size() == 0 || rankCategoryCodeList == null)) {
				message = "Rank Category Name already exists.";
			} else if ((rankCategoryCodeList.size() != 0 || rankCategoryCodeList != null)
					&& (rankCategoryNameList.size() != 0 || rankCategoryNameList != null)) {
				message = "Rank Category Code and Rank Category Name already exist.";
			}

		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "Add Rank Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editRankCategory(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();

		session = request.getSession();
		String rankCategoryCode = "";
		String rankCategoryName = "";
		int rankCategoryId = 0;
		String changedBy = "";
		int userId=0;
		HttpSession session=request.getSession();
		
		Date changedDate = null;
		String changedTime = "";
		rankCategoryCode = (String) session.getAttribute("rankCategoryCode");

		rankCategoryName = (String) session.getAttribute("rankCategoryName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			rankCategoryCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			rankCategoryName = request.getParameter(SEARCH_NAME);
		}
		if (session.getAttribute("userId")!= null
				&& !(session.getAttribute("userId").equals(""))) {
			userId = (Integer)session.getAttribute("userId");
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
		
		Users user=new Users();
		user.setId(userId);
		generalMap.put("id", rankCategoryId);
		generalMap.put("rankCategoryCode", rankCategoryCode);
		generalMap.put("name", rankCategoryName);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingRankCategoryNameList = (List) listMap
				.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingRankCategoryNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editRankCategoryToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingRankCategoryNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "update RankCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView deleteRankCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int rankCategoryId = 0;
		String message = null;
		 
		int userId=0;
		HttpSession session=request.getSession();
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			rankCategoryId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		if (session.getAttribute("userId")!= null
				&& !(session.getAttribute("userId").equals(""))) {
			userId = (Integer)session.getAttribute("userId");
		}
		
		 
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		Users user=new Users();
		user.setId(userId);
 		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteRankCategory(
				rankCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showRankCategoryJsp";
		try {
			map = personnelMasterHandlerService.showRankCategoryJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = RANK_CATEGORY_JSP;
		title = "Delete Rank Category";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	// --------------------Brand
	// Report-------------------------------------------------------

	public ModelAndView reportBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		parameters = personnelMasterHandlerService.getConnection();
		HMSUtil.generateReport("Mas_Store_Brand", parameters,
				(Connection) parameters.get("conn"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);

	}

	// ----------------------------Brand
	// ---------------------------------------------------------

	@SuppressWarnings("unchecked")
	public ModelAndView showBrandJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = personnelMasterHandlerService.showBrandJsp();
		jsp = BRAND_JSP;
		jsp += ".jsp";
		title = "brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBrandJspPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		map = personnelMasterHandlerService.showBrandJsp();
		jsp = "brand_popup";
		title = "brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchBrand(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String brandCode = null;
		String brandName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}

		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
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
			brandCode = searchField;
			brandName = null;

		} else {
			brandCode = null;
			brandName = searchField;
		}

		map = personnelMasterHandlerService.searchBrand(brandCode, brandName);
		jsp = BRAND_JSP;
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("brandCode", brandCode);
		map.put("brandName", brandName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreBrand masBrand = new MasStoreBrand();
		// int itemGenericId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		int manufacturerId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String currentTime="";
		String changedTime = "";
		HttpSession session = request.getSession();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 */if (request.getParameter(CHANGED_BY) != null
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
		
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("userId", userId);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List brandCodeList = new ArrayList();
		List brandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			brandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			brandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((brandCodeList.size() == 0 || brandCodeList == null)
				&& (brandNameList.size() == 0 || brandNameList == null)) {
			masBrand.setBrandCode(code);
			masBrand.setBrandName(name);

			MasManufacturer masManufacturer = new MasManufacturer();
			masManufacturer.setId(manufacturerId);
			masBrand.setManufacturer(masManufacturer);

			
			  MasStoreItemGeneric masStoreItemGeneric = new  MasStoreItemGeneric(); 
			  masStoreItemGeneric.setId(3);
			  masBrand.setItemGeneric(masStoreItemGeneric);
			 

			MasStoreItem masStoreItem = new MasStoreItem();
			if (itemId != 0) {
				masStoreItem.setId(itemId);
				masBrand.setItem(masStoreItem);
			}

			masBrand.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masBrand.setLastChgBy(user);
			
			
			masBrand.setLastChgDate(currentDate);
			masBrand.setLastChgTime(changedTime);
			successfullyAdded = personnelMasterHandlerService
					.addBrand(masBrand);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((brandCodeList.size() != 0 || brandCodeList != null)
				|| (brandNameList.size() != 0) || brandNameList != null) {
			if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() == 0 || brandNameList == null)) {
				message = "Brand Code  already exists.";
			} else if ((brandNameList.size() != 0 || brandNameList != null)
					&& (brandCodeList.size() == 0 || brandCodeList == null)) {
				message = "Brand Name already exists.";
			} else if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() != 0 || brandNameList != null)) {
				message = "Brand Code and Brand Name already exist.";
			}

		}
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Add Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasStoreBrand masBrand = new MasStoreBrand();
		// int itemGenericId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		int manufacturerId = 0;
		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		String currentTime="";
		HttpSession session = request.getSession();
		int userId=0;
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(CODE) != null) {
			code = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null) {
			name = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.parseInt(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 */if (request.getParameter(CHANGED_BY) != null
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
		generalMap.put("userId", userId);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List brandCodeList = new ArrayList();
		List brandNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			brandCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			brandNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;
		if ((brandCodeList.size() == 0 || brandCodeList == null)
				&& (brandNameList.size() == 0 || brandNameList == null)) {
			masBrand.setBrandCode(code);
			masBrand.setBrandName(name);

			MasManufacturer masManufacturer = new MasManufacturer();
			masManufacturer.setId(manufacturerId);
			masBrand.setManufacturer(masManufacturer);

			/*
			 * MasStoreItemGeneric masStoreItemGeneric = new
			 * MasStoreItemGeneric(); masStoreItemGeneric.setId(itemGenericId);
			 * masBrand.setItemGeneric(masStoreItemGeneric);
			 */

			MasStoreItem masStoreItem = new MasStoreItem();
			if (itemId != 0) {
				masStoreItem.setId(itemId);
				masBrand.setItem(masStoreItem);
			}

			masBrand.setStatus("y");
			Users user = new Users();
			user.setId(userId);
			masBrand.setLastChgBy(user);

			masBrand.setLastChgDate(currentDate);
			masBrand.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService
					.addBrand(masBrand);

			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((brandCodeList.size() != 0 || brandCodeList != null)
				|| (brandNameList.size() != 0) || brandNameList != null) {
			if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() == 0 || brandNameList == null)) {
				message = "Brand Code  already exists.";
			} else if ((brandNameList.size() != 0 || brandNameList != null)
					&& (brandCodeList.size() == 0 || brandCodeList == null)) {
				message = "Brand Name already exists.";
			} else if ((brandCodeList.size() != 0 || brandCodeList != null)
					&& (brandNameList.size() != 0 || brandNameList != null)) {
				message = "Brand Code and Brand Name already exist.";
			}

		}
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "brand_popup";
		title = "Add Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView editBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String brandCode = "";
		String brandName = "";
		int brandId = 0;
		// int itemGenericId = 0;
		int manufacturerId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		int userId = 0;
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.valueOf(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
		 */
	
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
		generalMap.put("id", brandId);
		generalMap.put("brandCode", brandCode);
		generalMap.put("name", brandName);
		// generalMap.put("itemGenericId",itemGenericId);
		generalMap.put("manufacturerId", manufacturerId);
		generalMap.put("itemId", itemId);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBrandNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBrandNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editBrandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBrandNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Update Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String brandCode = "";
		String brandName = "";
		int brandId = 0;
		// int itemGenericId = 0;
		int manufacturerId = 0;
		String nomen = request.getParameter(NAME_ITEM);
		int index1 = nomen.lastIndexOf("[");
		int index2 = nomen.lastIndexOf("]");
		index1++;
		String pvms = nomen.substring(index1, index2).toString();
		int itemId = 0;
		itemId = personnelMasterHandlerService.getItemId(pvms);
		String changedBy = "";
		@SuppressWarnings("unused")
		Date changedDate = null;
		@SuppressWarnings("unused")
		String changedTime = "";
		Date currentDate = null;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			brandCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			brandName = request.getParameter(SEARCH_NAME);
		}
		/*
		 * if (!request.getParameter(ITEM_GENERIC_ID) .equals("0")) {
		 * itemGenericId =
		 * Integer.valueOf(request.getParameter(ITEM_GENERIC_ID)); }
		 */
		if (!request.getParameter(MANUFACTURER_ID).equals("0")) {
			manufacturerId = Integer.valueOf(request
					.getParameter(MANUFACTURER_ID));
		}
		/*
		 * if (!request.getParameter(ITEM_ID) .equals("0")) { itemId =
		 * Integer.valueOf(request.getParameter(ITEM_ID)); }
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
		generalMap.put("id", brandId);
		generalMap.put("brandCode", brandCode);
		generalMap.put("name", brandName);
		// generalMap.put("itemGenericId",itemGenericId);
		generalMap.put("manufacturerId", manufacturerId);
		generalMap.put("itemId", itemId);
		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		Map<String, Object> listMap = new HashMap<String, Object>();
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);
		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingBrandNameList = (List) listMap.get("duplicateMastersList");

		boolean dataUpdated = false;
		if (existingBrandNameList.size() == 0) {

			dataUpdated = personnelMasterHandlerService
					.editBrandToDatabase(generalMap);

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant Be Updated !!";
			}
		} else if (existingBrandNameList.size() > 0) {
			message = "Name already exists.";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "brand_popup";
		title = "Update Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView deleteBrand(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int brandId = 0;
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
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteBrand(brandId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Delete Brand";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteBrandPopup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int brandId = 0;
		String message = null;
		int userId = 0;
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		session = request.getSession();
		if (session.getAttribute("userId") != null)
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			brandId = Integer.parseInt(request.getParameter(COMMON_ID));
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
		dataDeleted = personnelMasterHandlerService.deleteBrand(brandId,
				generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated Successfully !!";
		} else {
			message = "Record is Activated Successfully !!";
		}
		url = "/hms/hms/personnel?method=showBrandJsp";
		try {
			map = personnelMasterHandlerService.showBrandJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = BRAND_JSP;
		title = "Delete Brand";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showEmployeeExitInterviewJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MasHospital hospital = null;
		Integer hospitalId = 0;
		Users user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL) != null) {

			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			hospital = new MasHospital();
			hospital.setId(hospitalId);
		}
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		Map parameterMap = new HashMap<String, Object>();
		parameterMap.put("hospital", hospital);

		String jsp = HR_EMPLOYEE_EXIT_INTERVIEW_JSP;
		jsp += ".jsp";

		map = personnelMasterHandlerService
				.showEmployeeExitInterviewJsp(parameterMap);
		map.put("contentJsp", jsp);
		map.put("user", user);

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView addOrUpdateexitInterview(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		MasHospital hospital = null;
		Integer hospitalId = 0;
		Users user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL) != null) {

			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			hospital = new MasHospital();
			hospital.setId(hospitalId);
		}
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		MasEmployee employee = user.getEmployee();
		Date dateOfRelieving = new Date();
		String[] quest1 = {};
		String quest2 = "";
		String quest3 = "";
		String quest4 = "";
		String quest5a = "";
		String quest5b = "";
		String quest5c = "";
		String quest5d = "";
		String quest5e = "";
		String quest5f = "";
		String quest5g = "";
		String quest5h = "";
		String quest6 = "";
		String quest7 = "";
		String quest8 = "";

		if (request.getParameter(DATE_OF_RELIEVING) != null
				&& !request.getParameter(DATE_OF_RELIEVING).equals("")) {
			dateOfRelieving = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_RELIEVING));
		}
		if (request.getParameter(QUEST1) != null) {
			quest1 = (String[]) request.getParameterValues(QUEST1);
		}

		String quest1Str = "";
		if (quest1.length != 0) {
			quest1Str = quest1[0];
		}
		for (int i = 1; i < quest1.length; i++) {
			quest1Str = quest1Str + " , " + quest1[i];

		}

		if (request.getParameter(QUEST2) != null) {
			quest2 = request.getParameter(QUEST2);
		}
		if (request.getParameter(QUEST3) != null) {
			quest3 = request.getParameter(QUEST3);
		}
		if (request.getParameter(QUEST4) != null) {
			quest4 = request.getParameter(QUEST4);
		}
		if (request.getParameter(QUEST5a) != null) {
			quest5a = request.getParameter(QUEST5a);
		}
		if (request.getParameter(QUEST5b) != null) {
			quest5b = request.getParameter(QUEST5b);
		}
		if (request.getParameter(QUEST5c) != null) {
			quest5c = request.getParameter(QUEST5c);
		}
		if (request.getParameter(QUEST5d) != null) {
			quest5d = request.getParameter(QUEST5d);
		}
		if (request.getParameter(QUEST5e) != null) {
			quest5e = request.getParameter(QUEST5e);
		}
		if (request.getParameter(QUEST5f) != null) {
			quest5f = request.getParameter(QUEST5f);
		}
		if (request.getParameter(QUEST5g) != null) {
			quest5g = request.getParameter(QUEST5g);
		}
		if (request.getParameter(QUEST5h) != null) {
			quest5h = request.getParameter(QUEST5h);
		}
		if (request.getParameter(QUEST6) != null) {
			quest6 = request.getParameter(QUEST6);
		}
		if (request.getParameter(QUEST7) != null) {
			quest7 = request.getParameter(QUEST7);
		}
		if (request.getParameter(QUEST8) != null) {
			quest8 = request.getParameter(QUEST8);
		}

		HrEmployeeExitInterview exitInterview = new HrEmployeeExitInterview();
		exitInterview.setEmployee(employee);
		exitInterview.setDateOfRelieving(dateOfRelieving);

		personnelMasterHandlerService
				.addOrUpdateEmployeeExitInterview(exitInterview);

		List exitInterviewAnswersList = new ArrayList();

		HrExitInterviewQuestionsMasters questionMaster = new HrExitInterviewQuestionsMasters();
		questionMaster.setId(1);
		HrExitInterviewAnswers answer1 = new HrExitInterviewAnswers();
		answer1.setAnswer(quest1Str);
		answer1.setQuestion(questionMaster);
		answer1.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer1);

		HrExitInterviewQuestionsMasters questionMaster2 = new HrExitInterviewQuestionsMasters();
		questionMaster2.setId(2);
		HrExitInterviewAnswers answer2 = new HrExitInterviewAnswers();
		answer2.setAnswer(quest2);
		answer2.setQuestion(questionMaster2);
		answer2.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer2);

		HrExitInterviewQuestionsMasters questionMaster3 = new HrExitInterviewQuestionsMasters();
		questionMaster3.setId(3);
		HrExitInterviewAnswers answer3 = new HrExitInterviewAnswers();
		answer3.setAnswer(quest3);
		answer3.setQuestion(questionMaster3);
		answer3.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer3);

		HrExitInterviewQuestionsMasters questionMaster4 = new HrExitInterviewQuestionsMasters();
		questionMaster4.setId(4);
		HrExitInterviewAnswers answer4 = new HrExitInterviewAnswers();
		answer4.setAnswer(quest4);
		answer4.setQuestion(questionMaster4);
		answer4.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer4);

		HrExitInterviewQuestionsMasters questionMaster5 = new HrExitInterviewQuestionsMasters();
		questionMaster5.setId(5);
		HrExitInterviewAnswers answer5 = new HrExitInterviewAnswers();
		answer5.setAnswer(quest5a);
		answer5.setQuestion(questionMaster5);
		answer5.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer5);

		HrExitInterviewQuestionsMasters questionMaster6 = new HrExitInterviewQuestionsMasters();
		questionMaster6.setId(6);
		HrExitInterviewAnswers answer6 = new HrExitInterviewAnswers();
		answer6.setAnswer(quest5b);
		answer6.setQuestion(questionMaster6);
		answer6.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer6);

		HrExitInterviewQuestionsMasters questionMaster7 = new HrExitInterviewQuestionsMasters();
		questionMaster7.setId(7);
		HrExitInterviewAnswers answer7 = new HrExitInterviewAnswers();
		answer7.setAnswer(quest5c);
		answer7.setQuestion(questionMaster7);
		answer7.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer7);

		HrExitInterviewQuestionsMasters questionMaster8 = new HrExitInterviewQuestionsMasters();
		questionMaster8.setId(8);
		HrExitInterviewAnswers answer8 = new HrExitInterviewAnswers();
		answer8.setAnswer(quest5c);
		answer8.setQuestion(questionMaster8);
		answer8.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer8);

		HrExitInterviewQuestionsMasters questionMaster9 = new HrExitInterviewQuestionsMasters();
		questionMaster9.setId(9);
		HrExitInterviewAnswers answer9 = new HrExitInterviewAnswers();
		answer9.setAnswer(quest5d);
		answer9.setQuestion(questionMaster9);
		answer9.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer9);

		HrExitInterviewQuestionsMasters questionMaster10 = new HrExitInterviewQuestionsMasters();
		questionMaster10.setId(10);
		HrExitInterviewAnswers answer10 = new HrExitInterviewAnswers();
		answer10.setAnswer(quest5e);
		answer10.setQuestion(questionMaster10);
		answer10.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer10);

		HrExitInterviewQuestionsMasters questionMaster11 = new HrExitInterviewQuestionsMasters();
		questionMaster11.setId(11);
		HrExitInterviewAnswers answer11 = new HrExitInterviewAnswers();
		answer11.setAnswer(quest5e);
		answer11.setQuestion(questionMaster11);
		answer11.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer11);

		HrExitInterviewQuestionsMasters questionMaster12 = new HrExitInterviewQuestionsMasters();
		questionMaster12.setId(12);
		HrExitInterviewAnswers answer12 = new HrExitInterviewAnswers();
		answer12.setAnswer(quest5f);
		answer12.setQuestion(questionMaster12);
		answer12.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer12);

		HrExitInterviewQuestionsMasters questionMaster13 = new HrExitInterviewQuestionsMasters();
		questionMaster13.setId(13);
		HrExitInterviewAnswers answer13 = new HrExitInterviewAnswers();
		answer13.setAnswer(quest5g);
		answer13.setQuestion(questionMaster13);
		answer13.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer13);

		HrExitInterviewQuestionsMasters questionMaster14 = new HrExitInterviewQuestionsMasters();
		questionMaster14.setId(14);
		HrExitInterviewAnswers answer14 = new HrExitInterviewAnswers();
		answer14.setAnswer(quest5h);
		answer14.setQuestion(questionMaster14);
		answer14.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer14);

		HrExitInterviewQuestionsMasters questionMaster15 = new HrExitInterviewQuestionsMasters();
		questionMaster15.setId(15);
		HrExitInterviewAnswers answer15 = new HrExitInterviewAnswers();
		answer15.setAnswer(quest6);
		answer15.setQuestion(questionMaster15);
		answer15.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer15);

		HrExitInterviewQuestionsMasters questionMaster16 = new HrExitInterviewQuestionsMasters();
		questionMaster16.setId(16);
		HrExitInterviewAnswers answer16 = new HrExitInterviewAnswers();
		answer16.setAnswer(quest7);
		answer16.setQuestion(questionMaster16);
		answer16.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer16);

		HrExitInterviewQuestionsMasters questionMaster17 = new HrExitInterviewQuestionsMasters();
		questionMaster17.setId(17);
		HrExitInterviewAnswers answer17 = new HrExitInterviewAnswers();
		answer17.setAnswer(quest8);
		answer17.setQuestion(questionMaster17);
		answer17.setInterview(exitInterview);
		exitInterviewAnswersList.add(answer17);

		personnelMasterHandlerService
				.addOrUpdateExitInterviewAnswers(exitInterviewAnswersList);
		Map parameterMap = new HashMap();
		parameterMap.put("hospital", hospital);
		map = personnelMasterHandlerService
				.showEmployeeExitInterviewJsp(parameterMap);

		String jsp = "hr_exitInterview.jsp";
		map.put("contentJsp", jsp);
		map.put("message", "Interview Details have been added succesfully");
		map.put("user", user);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateReportForEmployeeInformation(HttpServletRequest request,HttpServletResponse response)
	{
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		
		Map<String, Object> parameters = new HashMap();
		int hospitalId=0;
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
				//hospital.setId(hospitalId);
			}
			
			//String query = "Where mas_employee.status = 'y' and mas_employee.hospital_Id= "+hospitalId;
			String query = "Where UPPER(mas_employee.status) = 'Y' and mas_employee.hospital_Id= "+hospitalId;
		parameters.put("query", query);

		/*
		 * parameters.put("EmpId", EmpId); parameters.put("Dept",Dept);
		 * parameters.put("DesignationId",DesignationId);
		 * parameters.put("LocationId", LocationId);
		 */

		Map<String, Object> connectionMap = personnelMasterHandlerService.getConnection();
		HMSUtil.generateReport("mas_employee_report", parameters,
				(Connection) connectionMap.get("conn"), response,
				getServletContext());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
		/*
	Map mapEmployee = (Map)session.getAttribute("mapEmployee");
	List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();
	if(mapEmployee.get("searchEmployeeList") != null){
		searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
	}
	
	byte[] bytes = null;
	ServletContext context = request.getSession().getServletContext();
	Map parameters = new HashMap();
	try
	{
		JasperReport jasperReport = HMSUtil.getCompiledReport(context, "employeeInformation");
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(searchEmployeeList);
		bytes = JasperRunManager.runReportToPdf(jasperReport,parameters,ds);
	}
	catch(Exception e)
	{
		e.printStackTrace(); 
	}
	String fileName = "employeeInformation_" + new Date();
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition","attachment;filename="+fileName);
	
	int b = bytes.length;
	response.setContentLength(b);
	try
	{
		ServletOutputStream ouputStream  = response.getOutputStream();
		
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	return null;*/

}

	public ModelAndView generateReportForEmployeeContract(
			HttpServletRequest request, HttpServletResponse response) {
		Map mapEmployeeContract = (Map) session
				.getAttribute("mapEmployeeContract");
		List<MasEmployeeContract> searchEmployeeContractList = new ArrayList<MasEmployeeContract>();
		if (mapEmployeeContract.get("searchEmployeeContractList") != null) {
			searchEmployeeContractList = (List) mapEmployeeContract
					.get("searchEmployeeContractList");
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"employeeContract");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchEmployeeContractList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "employeeContract_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView generateReportForEmployeeDependent(
			HttpServletRequest request, HttpServletResponse response) {
		Map mapEmployeeDependent = (Map) session
				.getAttribute("mapEmployeeDependent");
		List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>();
		if (mapEmployeeDependent.get("searchEmployeeDependentList") != null) {
			searchEmployeeDependentList = (List) mapEmployeeDependent
					.get("searchEmployeeDependentList");
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"employeeDependent");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchEmployeeDependentList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "employeeDependent_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView generateReportForEmployeePayStructure(
			HttpServletRequest request, HttpServletResponse response) {
		Map mapEmployeePayStructure = (Map) session
				.getAttribute("mapEmployeePayStructure");
		List<HrEmployeePayStructure> searchEmployeePayStructureList = new ArrayList<HrEmployeePayStructure>();
		if (mapEmployeePayStructure.get("searchEmployeePayStructureList") != null) {
			searchEmployeePayStructureList = (List) mapEmployeePayStructure
					.get("searchEmployeePayStructureList");
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"employeePayStructure");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchEmployeePayStructureList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "employeePayStructure_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView generateReportForEmployeePayElement(
			HttpServletRequest request, HttpServletResponse response) {
		Map mapEmployeePayElement = (Map) session
				.getAttribute("mapEmployeePayElement");
		List<HrEmployeePayElements> searchEmployeePayElementList = new ArrayList<HrEmployeePayElements>();
		if (mapEmployeePayElement.get("searchEmployeePayElementsList") != null) {
			searchEmployeePayElementList = (List) mapEmployeePayElement
					.get("searchEmployeePayElementsList");
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"employeePayElement");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					searchEmployeePayElementList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "employeePayElement_" + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ModelAndView addPhotoToTempFolder(HttpServletRequest request,
			HttpServletResponse response) {
		MultipartFormDataRequest mrequest = null;
		String whiteList = "*.jpg,*.txt,*.rtf,*.DOC,*.TXT,*.RTF";
		Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
		String firstName = "Rajat";
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int id = 0 + 1;
			String fileNameToBeAssigned = "temp";

			List fileUploadedList = null;
			// Connection connection = resumeHandlerService.getDBConnection();
			fileUploadedList = HMSUtil.uploadFile(mrequest,
					"C:\\WTP\\apache-tomcat-6.0.18\\webapps\\hms\\photos",
					whiteList, fileSizeLimit, fileNameToBeAssigned);
			Boolean fileUploaded = false;
			if (fileUploadedList != null && fileUploadedList.size() != 0) {
				fileUploaded = (Boolean) fileUploadedList.get(0);
			}
		}
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		int userType = 0;
		if(session.getAttribute("users") != null){
			 Users user = (Users)session.getAttribute("users");
			 userType = user.getUserType()!=null?user.getUserType():4;
			 
		}
		dataMap.put("userType", userType);
		map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		map.put("contentJsp", "employee.jsp");

		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showEmployeePerformanceReviewJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MasHospital hospital = new MasHospital();
		Integer hospitalId = 0;
		Users user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			hospital.setId(hospitalId);
		}

		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		Map parameterMap = new HashMap<String, Object>();
		parameterMap.put("hospital", hospital);

		String jsp = HR_EMPLOYEE_PERFORMANCE_REVIEW_JSP;
		jsp += ".jsp";

		map = personnelMasterHandlerService
				.showEmployeePerformanceReviewJsp(parameterMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addOrUpdateEmployeePerformaceReview(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MasHospital company = null;
		Integer hospitalId = null;
		Users user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}

		Integer commonId = null;
		Integer employeeId = null;
		Integer assessmentPerformanceGoals = null;
		Integer assessmentBehaviour = null;
		Integer overAllAssessment = null;
		Integer year = null;
		Float incrementPercentage = 0.0f;
		Float incrementAmount = 0.0f;
		String promotion = "";
		String comments = "";

		Integer companyId = null;
		String lastChgBy = "";
		String lastChgDate = "";
		String lastChgTime = "";

		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_ID));
		}

		if (request.getParameter(ASSESSMENT_PERFORMANCE_GOALS) != null
				&& !request.getParameter(ASSESSMENT_PERFORMANCE_GOALS).equals(
						"")) {
			assessmentPerformanceGoals = new Integer(
					request.getParameter(ASSESSMENT_PERFORMANCE_GOALS));
		}

		if (request.getParameter(ASSESSMENT_BEHAVIOUR) != null
				&& !request.getParameter(ASSESSMENT_BEHAVIOUR).equals("")) {
			assessmentBehaviour = new Integer(
					request.getParameter(ASSESSMENT_BEHAVIOUR));
		}
		if (request.getParameter(OVERALL_ASSESSMENT) != null
				&& !request.getParameter(OVERALL_ASSESSMENT).equals("")) {
			overAllAssessment = new Integer(
					request.getParameter(OVERALL_ASSESSMENT));
		}

		if (request.getParameter(YEAR) != null) {
			year = new Integer(request.getParameter(YEAR));
		}

		if (request.getParameter(INCREMENT_PERCENTAGE) != null) {
			incrementPercentage = new Float(
					request.getParameter(INCREMENT_PERCENTAGE));
		}

		if (request.getParameter(INCREMENT_AMOUNT) != null
				&& !request.getParameter(INCREMENT_AMOUNT).equals("")) {
			incrementAmount = new Float(request.getParameter(INCREMENT_AMOUNT));
		}

		if (request.getParameter(PROMOTION) != null) {
			promotion = request.getParameter(PROMOTION);
		}

		if (request.getParameter(COMMENTS) != null) {
			comments = request.getParameter(COMMENTS);
		}

		if (request.getParameter(COMMON_ID) != null
				&& !request.getParameter(COMMON_ID).equals("")) {
			commonId = new Integer(request.getParameter(COMMON_ID));
		}

		HrEmployeePerformanceReview performanceReview = null;
		if (commonId != null) {
			performanceReview = personnelMasterHandlerService
					.getEmployeePerformanceReview(commonId);
		} else {
			performanceReview = new HrEmployeePerformanceReview();
		}

		if (employeeId != null) {
			MasEmployee employee = new MasEmployee();
			employee.setId(employeeId);
			performanceReview.setEmployee(employee);
		}

		if (assessmentPerformanceGoals != null) {
			HrPerformanceReviewRatings rating = new HrPerformanceReviewRatings();
			rating.setId(assessmentPerformanceGoals);
			performanceReview.setAssesmentPerformanceGoals(rating);
		}

		if (assessmentBehaviour != null) {
			HrPerformanceReviewRatings rating = new HrPerformanceReviewRatings();
			rating.setId(assessmentBehaviour);
			performanceReview.setAssesmentBehaviour(rating);
		}

		if (overAllAssessment != null) {
			HrPerformanceReviewRatings rating = new HrPerformanceReviewRatings();
			rating.setId(overAllAssessment);
			performanceReview.setOverallAssesment(rating);
		}

		performanceReview.setYear(year);
		performanceReview.setIncrementAmount(incrementAmount);
		performanceReview.setIncrementPercentage(incrementPercentage);
		performanceReview.setPromotion(promotion);
		performanceReview.setComments(comments);

		company = new MasHospital();
		company.setId(hospitalId);
		performanceReview.setCompany(company);

		performanceReview.setStatus("y");
		String message = "";
		try {
			personnelMasterHandlerService
					.addOrUpdateEmployeePerformanceReview(performanceReview);
			if (commonId == null) {
				message = "Performance Review has been done for employee  "
						+ performanceReview.getEmployee().getEmployeeCode()
						+ " - "
						+ performanceReview.getEmployee().getFirstName();
			} else {
				message = "Performance Review has been updated for employee "
						+ performanceReview.getEmployee().getEmployeeCode()
						+ " - "
						+ performanceReview.getEmployee().getFirstName();
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Problem adding record";
		}

		Map parameterMap = new HashMap<String, Object>();
		parameterMap.put("hospital", company);

		String jsp = HR_EMPLOYEE_PERFORMANCE_REVIEW_JSP;
		jsp += ".jsp";

		map = personnelMasterHandlerService
				.showEmployeePerformanceReviewJsp(parameterMap);
		map.put("message", message);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmployeePerformanceReview(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletRequestBindingException {
		HttpSession session = request.getSession();
		MasHospital hospital = null;
		Integer hospitalId = null;
		Map parameterMap = new HashMap();
		if (session.getAttribute(HOSPITAL) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL);
		}
		Map<String, Object> map = new HashMap<String, Object>();

		Integer employeeId = null;
		String searchField = null;

		if (request.getParameter(EMPLOYEE_CODE) != null) {
			employeeId = new Integer(request.getParameter(EMPLOYEE_CODE));
		}
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("employeeId", employeeId);
		map = personnelMasterHandlerService
				.searchEmployeePerformanceReview(parameterMap);

		jsp = HR_EMPLOYEE_PERFORMANCE_REVIEW_JSP;

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeePerformanceReview(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeePerformanceReviewId = 0;
		String message = "";
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String flag = "";
		HttpSession session = request.getSession();
		Integer hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			employeePerformanceReviewId = Integer.parseInt(request
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
		dataDeleted = personnelMasterHandlerService
				.deleteEmployeePerformanceReview(employeePerformanceReviewId,
						generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showEmployeePerformanceReviewJsp";

		Map parameterMap = new HashMap();
		parameterMap.put("hospitalId", hospitalId);
		try {
			map = personnelMasterHandlerService
					.showEmployeePerformanceReviewJsp(parameterMap);

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = HR_EMPLOYEE_PERFORMANCE_REVIEW_JSP;
		title = "Delete Employee Performance Review";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getsubordinateList(HttpServletRequest request,
			HttpServletResponse response) {
		Integer employeeId = 0;

		if (request.getParameter("empId") != null
				&& !request.getParameter("empId").equals("0")) {
			employeeId = new Integer(request.getParameter("empId"));
		}
		MasEmployee employee = personnelMasterHandlerService
				.getEmployee(employeeId);
		List<MasEmployee> subordinateList = personnelMasterHandlerService
				.getSubordinatesList(employeeId);
		String jsp = "responseSubordinatesList";
		Map map = new HashMap();
		map.put("subordinateList", subordinateList);
		map.put("employee", employee);
		// map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView printSubordinateList(HttpServletRequest request,
			HttpServletResponse response) {
		Integer employeeId = 0;
		session = request.getSession();
		Map map = new HashMap();
		if (session.getAttribute("map") != null) {
			map = (Map) session.getAttribute("map");
		}

		List<MasEmployee> subordinateList = new ArrayList<MasEmployee>();

		if (map.get("subordinateList") != null) {
			subordinateList = (List) map.get("subordinateList");
		}
		MasEmployee employee = null;
		if (map.get("employee") != null) {
			employee = (MasEmployee) map.get("employee");
		}
		String employeeName = "";
		if (employee != null) {
			employeeName = employee.getFirstName() + " "
					+ employee.getLastName() + " - "
					+ employee.getEmployeeCode();
		}
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		parameters.put("employee", employeeName);
		try {
			JasperReport jasperReport = HMSUtil.getCompiledReport(context,
					"subordinatesList");
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(
					subordinateList);
			bytes = JasperRunManager.runReportToPdf(jasperReport, parameters,
					ds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String fileName = "subordinatesList_" + employeeName + new Date();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName);

		int b = bytes.length;
		response.setContentLength(b);
		try {
			ServletOutputStream ouputStream = response.getOutputStream();

			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public ModelAndView showLocationJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		map = personnelMasterHandlerService.showLocationJsp();
		jsp = LOCATION_JSP;
		jsp += ".jsp";
		title = "Location view";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchLocation(HttpServletRequest request,
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

		map = personnelMasterHandlerService.searchLocation(itemCategoryCode,
				itemCategoryName);

		jsp = LOCATION_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("search", "search");
		map.put("itemCategoryCode", itemCategoryCode);
		map.put("itemCategoryName", itemCategoryName);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView addLocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasLocation masLocation = new MasLocation();

		String changedBy = "";
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
		HttpSession session = request.getSession();
		String userName = "";
		userName = (String) session.getAttribute("userName");
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");

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

		changedBy = userName;

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
		generalMap.put("code", code);
		generalMap.put("name", name);

		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService
				.checkForExistingMastersForHrms(generalMap);

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
			masLocation.setLocationCode(code);
			masLocation.setLocationName(name);

			masLocation.setStatus("y");
			masLocation.setLastChgBy(changedBy);
			masLocation.setLastChgDate(currentDate);
			masLocation.setLastChgTime(currentTime);
			MasHospital masHospital = new MasHospital(hospitalId);
			masLocation.setCompany(masHospital);

			successfullyAdded = personnelMasterHandlerService
					.addLocation(masLocation);

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
				message = "Location Code  already exists.";
			} else if ((itemCategoryNameList.size() != 0 || itemCategoryNameList != null)
					&& (itemCategoryCodeList.size() == 0 || itemCategoryCodeList == null)) {
				message = "Location Name  already exists.";
			} else if ((itemCategoryCodeList.size() != 0 || itemCategoryCodeList != null)
					&& (itemCategoryNameList.size() != 0 || itemCategoryNameList != null)) {
				message = "Location Code and Location Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showLocationJsp";
		try {
			map = personnelMasterHandlerService.showLocationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_JSP;
		title = "Location View";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editLocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		session = request.getSession();
		String itemCategoryCode = "";
		String itemCategoryName = "";

		int itemCategoryId = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";
		String userName = "";
		int hospitalId = 0;
		hospitalId = (Integer) session.getAttribute("hospitalId");
		userName = (String) session.getAttribute("userName");
		String lastChangedDate = "";
		String lastChangedTime = "";
		listMap1 = HMSUtil.getCurrentDateAndTime();
		lastChangedTime = (String) listMap1.get("currentTime");
		lastChangedDate = (String) listMap1.get("currentDate");

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

		changedBy = userName;

		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}

		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("id", itemCategoryId);
		generalMap.put("itemCategoryCode", itemCategoryCode);
		generalMap.put("name", itemCategoryName);

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate",
				HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
		generalMap.put("currentTime", lastChangedTime);
		generalMap.put("hospitalId", hospitalId);
		boolean dataUpdated = false;

		dataUpdated = personnelMasterHandlerService
				.editLocationToDatabase(generalMap);

		if (dataUpdated == true) {
			message = "Record Updated Successfully !!";

		} else {
			message = "Record Cant be updated !!";
		}
		url = "/hms/hms/personnel?method=showLocationJsp";
		try {
			map = personnelMasterHandlerService.showLocationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_JSP;
		title = "Edit Location";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteLocation(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> listMap1 = new HashMap<String, Object>();

		int ItemCategoryId = 0;
		String message = null;
		String changedBy = "";
		String changedTime = "";
		Date changedDate = null;
		String userName = "";
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

		changedBy = userName;

		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate",
				HMSUtil.convertStringTypeDateToDateType(lastChangedDate));
		generalMap.put("currentTime", lastChangedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteLocation(
				ItemCategoryId, generalMap);
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		}

		else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showLocationJsp";
		try {
			map = personnelMasterHandlerService.showLocationJsp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = LOCATION_JSP;
		title = "delete Location";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmployeeCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = personnelMasterHandlerService.showEmployeeCategory();
		jsp = "employeeCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView addEmployeeCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		MasEmpCategory masEmpCategory = new MasEmpCategory();
		session = request.getSession();
		String empCategoryCode = "";
		if (request.getParameter(EMP_CATEGORY_CODE) != null) {
			empCategoryCode = request.getParameter(EMP_CATEGORY_CODE);
			masEmpCategory.setEmpCategoryCode(empCategoryCode);
		}

		String empCategoryName = "";
		if (request.getParameter(EMP_CATEGORY_NAME) != null) {
			empCategoryName = request.getParameter(EMP_CATEGORY_NAME);
			masEmpCategory.setEmpCategoryName(empCategoryName);
		}
		String empCategoryDesc = "";
		if (request.getParameter("category_desc") != null) {
			empCategoryDesc = request.getParameter("category_desc");
			masEmpCategory.setEmpCategoryDesc(empCategoryDesc);
		}
		/*String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		masEmpCategory.setLastChgBy(changedBy);
		*/
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		Users user=null;
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users");
		}
		masEmpCategory.setLastChgBy(user);
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");

		Date currentDate = null;
		/*if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}*/
		currentDate = HMSUtil.dateFormatterDDMMYYYY(date);
		masEmpCategory.setLastChgDate(currentDate);
		/*String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}*/
		masEmpCategory.setLastChgTime(currentTime);
		masEmpCategory.setStatus("y");
		map = personnelMasterHandlerService.addEmployeeCategory(masEmpCategory);
		jsp = "employeeCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editEmployeeCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int empCategoryId = 0;
		session = request.getSession();
		if (request.getParameter(EMP_CATEGORY_ID) != null) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMP_CATEGORY_ID));
			generalMap.put("empCategoryId", empCategoryId);
		}
		String empCategoryCode = "";
		if (request.getParameter(EMP_CATEGORY_CODE) != null) {
			empCategoryCode = request.getParameter(EMP_CATEGORY_CODE);
			generalMap.put("empCategoryCode", empCategoryCode);
		}
		String empCategoryName = "";
		if (request.getParameter(EMP_CATEGORY_NAME) != null) {
			empCategoryName = request.getParameter(EMP_CATEGORY_NAME);
			generalMap.put("empCategoryName", empCategoryName);
		}
		String empCategoryDesc = "";
		if (request.getParameter("category_desc") != null) {
			empCategoryDesc = request.getParameter("category_desc");
			generalMap.put("empCategoryDesc", empCategoryDesc);
		}
		String changedBy = "";
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
			generalMap.put("changedBy", changedBy);
		}*/

		Date currentDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
			generalMap.put("currentDate", currentDate);
		}

		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
			generalMap.put("currentTime", currentTime);
		}
		Users user=null;
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		map = personnelMasterHandlerService.editEmployeeCategory(generalMap);
		jsp = "employeeCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		//map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteEmployeeCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		String message = "";
		String flag = "";
		session = request.getSession();
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		int empCategoryId = 0;
		if (request.getParameter(EMP_CATEGORY_ID) != null
				&& !(request.getParameter(EMP_CATEGORY_ID).equals(""))) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMP_CATEGORY_ID));
		}
		String changedBy = "";
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		Date currentDate = new Date();
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request
					.getParameter(CHANGED_DATE));
		}
		String currentTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		Users user=null;
		if(session.getAttribute("users") != null){
			user = (Users)session.getAttribute("users");
			generalMap.put("changedBy", user);
		}
		generalMap.put("empCategoryId", empCategoryId);
		//generalMap.put("changedBy", changedBy);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = personnelMasterHandlerService.deleteEmployeeCategory(generalMap);
		jsp = "employeeCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		//map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchEmpCategory(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String empCategoryCode = "";
		if (request.getParameter(EMP_CATEGORY_CODE) != null) {
			empCategoryCode = request.getParameter(EMP_CATEGORY_CODE);
		}

		String empCategoryName = "";
		if (request.getParameter(EMP_CATEGORY_NAME) != null) {
			empCategoryName = request.getParameter(EMP_CATEGORY_NAME);
		}
		int searchRadio = 1;
		String searchField = "";
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
			empCategoryCode = searchField;
			empCategoryName = null;

		} else {
			empCategoryCode = null;
			empCategoryName = searchField;
		}
		map = personnelMasterHandlerService.searchEmpCategory(empCategoryCode,
				empCategoryName);
		jsp = "employeeCategory";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
 		map.put("search", "search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showEmployeeInformationReportJsp(HttpServletRequest request,HttpServletResponse response) {
		Integer employeeId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession(true);
		
		String jsp = EMPLOYEE_FIELDS_JSP+".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView generateReportForEmployeeInformationExcel(HttpServletRequest request,HttpServletResponse response) {
		//boolean flag = false;
		HSSFWorkbook wb = new HSSFWorkbook();
		session = request.getSession(true);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		
		int counter = 0;
		if(request.getParameter("counter") != null 
				&& !request.getParameter("counter").equals("")){
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		List<String> headingList = new ArrayList<String>();
		Map<Integer, String> headingMap = new HashMap<Integer, String>();
		
		for(int i=1; i <= counter; i++){
			if(request.getParameter("chkId"+i) != null){
				headingMap.put(i, request.getParameter("heading"+i));
			} else {
				headingMap.put(i, "");
			}
		}
		mapForDs.put("headingMap", headingMap);
		mapForDs.put("counter", counter);
		
		map  = personnelMasterHandlerService.generateReportForEmployeeInformationExcel(mapForDs);
		wb = (HSSFWorkbook)map.get("wb");

		try{
			String file = "PersonalInformationReport.xls";

			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename="+ file);
			
			wb.write(response.getOutputStream());
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			
		}
		return null;
}	
	
	public ModelAndView showWingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession(true);
		map = personnelMasterHandlerService.showWingJsp();
		jsp = "wing";
		jsp += ".jsp";
		title = "Employee Status";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView addWing(HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		MasWing masWing = new MasWing();
		String changedBy = "";
		Map listMap = new HashMap();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date currentDate = new Date();
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
		Users users = null;
		if(session.getAttribute("users") != null){
			users = (Users)session.getAttribute("users");
			
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
		List empStatusCodeList = new ArrayList();
		List empStatusNameList = new ArrayList();

		if (listMap.get("duplicateGeneralCodeList") != null) {
			empStatusCodeList = (List) listMap.get("duplicateGeneralCodeList");
		}
		if (listMap.get("duplicateGeneralNameList") != null) {
			empStatusNameList = (List) listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAdded = false;

		if ((empStatusCodeList.size() == 0 || empStatusCodeList == null)
				&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {
			masWing.setWingCode(code);
			masWing.setWingName(name);
			masWing.setStatus("Y");
			masWing.setLastChgBy(users);
			masWing.setLastChgDate(currentDate);
			masWing.setLastChgTime(currentTime);
			successfullyAdded = personnelMasterHandlerService.addWing(masWing);
					
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
		} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
				|| (empStatusNameList.size() != 0) || empStatusNameList != null) {

			if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() == 0 || empStatusNameList == null)) {

				message = "Wing Code  already exists.";
			} else if ((empStatusNameList.size() != 0 || empStatusNameList != null)
					&& (empStatusCodeList.size() == 0 || empStatusCodeList == null)) {

				message = "Wing Name already exists.";
			} else if ((empStatusCodeList.size() != 0 || empStatusCodeList != null)
					&& (empStatusNameList.size() != 0 || empStatusNameList != null)) {

				message = "WingCode and Wing Name already exist.";
			}
		}
		url = "/hms/hms/personnel?method=showWingJsp";

		try {
			map = personnelMasterHandlerService.showWingJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "wing";
		title = "Add Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView editWing(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		session = request.getSession();
		String wingCode = "";
		String wing_name = "";
		int wing_id = 0;
		String changedBy = "";
		Date changedDate = null;
		String changedTime = "";

	//	empStatusCode = (String) session.getAttribute("empStatusCode");
	//	empStatusName = (String) session.getAttribute("empStatusName");
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			wing_id = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			wingCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			wing_name = request.getParameter(SEARCH_NAME);
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		*/
		Users users = null;
		if(session.getAttribute("users") != null){
			users = (Users)session.getAttribute("users");
			
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

		generalMap.put("id", wing_id);
		generalMap.put("empStatusCode", wingCode);
		generalMap.put("name", wing_name);
		generalMap.put("changedBy", users);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoName", pojoName);

		generalMap.put("flag", true);

		listMap = commonMasterHandlerService
				.checkForExistingMasters(generalMap);
		List existingOccupationNameList = (List) listMap
				.get("duplicateMastersList");
		boolean dataUpdated = false;
		if (existingOccupationNameList.size() == 0) {
			dataUpdated = personnelMasterHandlerService.editWing(generalMap);
					

			if (dataUpdated == true) {
				message = "Data updated Successfully !!";
			} else {
				message = "Data Cant be updated !!";
			}
		} else if (existingOccupationNameList.size() > 0) {

			message = " Wing Name already exists.";
		}
		url = "/hms/hms/personnel?method=showWingJsp";
		try {
			map = personnelMasterHandlerService.showWingJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "wing";
		title = "Edit Employee Status";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView deleteWing(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int wingId = 0;
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
			wingId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		if (request.getParameter("title") != null) {
			title = request.getParameter("title");
		}
		/*if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		
		Users users = null;
		if(session.getAttribute("users") != null){
			users = (Users)session.getAttribute("users");
		}
		changedDate = new Date();
		changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
				"currentTime");

		generalMap.put("changedBy", users);
		generalMap.put("currentDate", changedDate);
		generalMap.put("currentTime", changedTime);
		boolean dataDeleted = false;
		dataDeleted = personnelMasterHandlerService.deleteWing(wingId, generalMap);
			
		if (dataDeleted == true) {
			message = "Record is InActivated successfully !!";
		} else {
			message = "Record is Activated successfully !!";
		}
		url = "/hms/hms/personnel?method=showWingJsp";
		try {
			map = personnelMasterHandlerService.showWingJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "wing";
		title = "Delete Wing";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView wingSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		String wingCode = null;
		String wingName = null;
		String searchField = null;

		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			wingCode = request.getParameter(CODE);
		}
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			wingName = request.getParameter(SEARCH_NAME);
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
			wingCode = searchField;
			wingName = null;

		} else {
			wingCode = null;
			wingName = searchField;
		}
		map = personnelMasterHandlerService.wingSearch(wingCode,wingName);
				
		jsp = "wing";
		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("wingCode", wingCode);
		map.put("wingName", wingCode);
		return new ModelAndView("index", "map", map);
	}
//-------------------- Employee Aprroved --------
	
	public ModelAndView showEmployeeApprovedJsp(HttpServletRequest request,	HttpServletResponse response) {

		 session = request.getSession(true);
		 int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
		}
		Map<String, Object> map = personnelMasterHandlerService.showEmployeeApprovedJsp(hospitalId);
		Map<String, Object> empDepMap = null;
		try {
			empDepMap = personnelMasterHandlerService.showEmployeeDependentJsp();

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.putAll(empDepMap);
		List joinedCandidates = resumeHandlerService.getJoinedCandidates();
		jsp = "employeeApp";
		jsp += ".jsp";
		title = "Employee";
		map.put("joinedCandidates", joinedCandidates);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	
		/*
		Map<String, Object> map = new HashMap<String, Object>();
		session = request.getSession();
		
		int hospitalId = hospitalId = (Integer) session.getAttribute("hospitalId");
		
		
		map = personnelMasterHandlerService.showEmployeeApprovedJsp(hospitalId);
		jsp ="employeeApproved"; 
		title = "Employee Approved";
		jsp += ".jsp";
		map.put("hospitalId", hospitalId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	*/}
	public ModelAndView submitApproveEmployee(HttpServletRequest request,
			HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				session = request.getSession();
				String message = null;
				int hospitalId = (Integer) session.getAttribute("hospitalId");
				String[] str = request.getParameterValues("employeeId");
				System.out.println(str);
				List employeeList = new ArrayList();
				if (str != null) {
					for (int j = 0; j < str.length; j++) {
						int employeeId = Integer.parseInt(str[j]);
						employeeList.add(employeeId);
					}
				}
				System.out.println(employeeList);
				
				map.put("employeeList", employeeList);
				boolean successfullyAdded = personnelMasterHandlerService.submitApproveEmployee(map);
				if (successfullyAdded) {
				
					map = personnelMasterHandlerService.showEmployeeApprovedJsp(hospitalId);
					message = "Employee Confirmed";
					
				}
				jsp = "employeeApp.jsp";
				
				map.put("hospitalId", hospitalId);
				map.put("message", message);
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
	public ModelAndView searchEmployeeApp(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapEmployee = new HashMap<String, Object>();
		String employeeCode = null;
		String firstName = null;
		String lastName = null;
		String searchField = null;
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null){
			hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
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
		}
		/*if (searchRadio == 1) {
			employeeCode = searchField;
			firstName = null;
			lastName = null;
		} else if (searchRadio == 2) {
			employeeCode = null;
			firstName = searchField;
			lastName = null;
		} else if (searchRadio == 3) {
			employeeCode = null;
			firstName = null;
			lastName = searchField;
		}*/
		
		if (searchRadio == 1) {
			employeeCode = searchField;
			firstName=null;
		} else if (searchRadio == 2) {
			employeeCode = null;
			firstName = searchField;
			
		} 

		map = personnelMasterHandlerService.searchEmployee(employeeCode,
				firstName, lastName,hospitalId);

		jsp = "employeeApp";

		jsp += ".jsp";
		map.put("search", "search");
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("employeeCode", employeeCode);
		map.put("firstName", firstName);
		map.put("lastName", lastName);

		return new ModelAndView("index", "map", map);
	}
	
	//-------------------------------- Shift Parameter Master-------------------------------------
	
	
	public ModelAndView showShiftParameterMasterJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MasHospital hospital = new MasHospital();
		int hospitalId = 0;
		Users user = null;
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			hospital.setId(hospitalId);
		}

		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		Map parameterMap = new HashMap<String, Object>();
		parameterMap.put("hospital", hospital);

		String jsp = "shiftParameter";
		jsp += ".jsp";

		map = personnelMasterHandlerService.showShiftParameterMasterJsp(parameterMap);
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	
	// added by javed khan
	
	public ModelAndView editEmployeeTemp(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDep = new HashMap<String,Object>();
		Map<String, Object> listMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		int employeeTypeId = 0;
		String firstName = "";
		String middleName= "";
		String lastName = "";
		int titleId = 0;
		String empCode = "";
		String cardNo = "";
		String salaryStatus = "";
		int departmentId = 0;
		String probationPeriod = "";
		Date confirmationDueDate = null;
		//int costCenterId = 0;
		int empStatusId = 0;
		int empCategoryId = 0;
		int gradeId = 0;
		int rankId = 0;
		String equivalentDesignation = "";
		int locationId = 0;
		Date lastWorkingDay = null;
		Date dateOfResignation = null;
		//int unitId = 0;
		//int tradeId = 0;
		//String serviceNo = "";
		String permanentAddress = "";
		String residentialAddress = "";
		String emergencyTellNumber = "";
		String emergencyCellNumber = "" ;
		String residenceTellNumber = "" ;
		String officeTellNumber = "" ;
		Date appointmentDate = new Date();
		//String jobCode = "";				
		String email = "";
		String employeeUrl ="";
		String bankCode = "";
		String accountHead = "";
		String bankBranch="";
		String ifscCode="";
		String accounthead="";
		String bankAccountCode="";
		String bankAccountNumber="";
		String employeePhoto = "";	
		String changedBy = "";
		Date joinDate= new Date();
		Date currentDate = new Date();
		Integer applicantId = 0;
		//for employee dependent
		int employeeId = 0;
		Integer managerId = null;
		Boolean employeeTypeChanged = false;
		MasEmployeeTemp masEmployee= null;
		String pfNo="";
		String payMode ="";
		int joinOrganisation_id = 0;
		String code= "";
		String fatherOrHusbandName = "";
		int religId = 0;
		int category=0;
		int caste =0;
		int subCaste=0;
		int hospitalId = 0;
		Users users = null;
		session = request.getSession(true);
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if (session.getAttribute("users") != null) {
			users =  (Users) session.getAttribute("users");
		}
		if(request.getParameter(COMMON_ID) != null && !(request.getParameter(COMMON_ID).equals(""))){
			employeeId =Integer.parseInt( request.getParameter(COMMON_ID));
		}
		if (request.getParameter(APPLICANT_ID) != null && !request.getParameter(APPLICANT_ID).equals("")) {
			applicantId = new Integer(request.getParameter(APPLICANT_ID));
		}
		if (request.getParameter(EMPLOYEE_TYPE) != null) {
			employeeTypeId = new Integer(request.getParameter(EMPLOYEE_TYPE));
		}
		/*if (request.getParameter(CATEGORY) != null) {
			empCategoryId = new Integer(request.getParameter(CATEGORY));
		}*/
		if (request.getParameter(EMPLOYEE_CODE) != null) {
			code = request.getParameter(EMPLOYEE_CODE);
		}
		/*if (request.getParameter(EQUIVALENT_DESIGNATION) != null) {
			equivalentDesignation = request.getParameter(EQUIVALENT_DESIGNATION);
		}*/
		if (request.getParameter("managerId") != null && !request.getParameter("managerId").equals("0")) {
			managerId = new Integer(request.getParameter("managerId"));
		}
		/*if(!request.getParameter(EMPLOYEE_GRADE_ID).equals("0")) {
			gradeId = Integer.parseInt(request.getParameter(EMPLOYEE_GRADE_ID));
		}*/
		/*if (request.getParameter(EMPLOYEE_CARD_NO) != null) {
			cardNo = request.getParameter(EMPLOYEE_CARD_NO);
		}*/
		if (request.getParameter(FIRST_NAME) != null) {
			firstName = request.getParameter(FIRST_NAME);
		}
		if (request.getParameter(MIDDLE_NAME) != null) {
			middleName = request.getParameter(MIDDLE_NAME);
		}
		if (request.getParameter(LAST_NAME) != null) {
			lastName = request.getParameter(LAST_NAME);
		}
		if (request.getParameter("fatherOrHusbandName") != null) {
			fatherOrHusbandName = request.getParameter("fatherOrHusbandName");
		}
		
		if(request.getParameter(EMPLOYEE_PHOTO) != null) {
			employeePhoto=request.getParameter(EMPLOYEE_PHOTO);
		}
		if(request.getParameter(APPOINTMENT_DATE) != null && !(request.getParameter(APPOINTMENT_DATE).equals(""))) {
			appointmentDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(APPOINTMENT_DATE));	
		}
		/*if(request.getParameter(CONFIRMATION_DUE_DATE) != null && !(request.getParameter(CONFIRMATION_DUE_DATE).equals(""))) {
			confirmationDueDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CONFIRMATION_DUE_DATE));	
		}*/
		if (request.getParameter(PROBATION_PERIOD) != null) {
			probationPeriod = request.getParameter(PROBATION_PERIOD);
		}
		if(request.getParameter(JOIN_DATE) != null && !(request.getParameter(JOIN_DATE).equals(""))) {
			joinDate= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(JOIN_DATE));	
		}
		/*if(request.getParameter(LAST_WORKING_DAY) != null && !request.getParameter(LAST_WORKING_DAY).equals("") ) {
			lastWorkingDay= HMSUtil.dateFormatterDDMMYYYY(request.getParameter(LAST_WORKING_DAY));	
		}
		if(request.getParameter(DATE_OF_RESIGNATION) != null && !request.getParameter(DATE_OF_RESIGNATION).equals("")) {
			dateOfResignation = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(DATE_OF_RESIGNATION));	
		}*/
		if(!request.getParameter(TITLE_ID).equals("0")) {
			titleId = Integer.parseInt(request.getParameter(TITLE_ID));
		}
		if (!request.getParameter(EMP_STATUS_ID).equals("0")) {
			empStatusId = Integer.parseInt(request.getParameter(EMP_STATUS_ID));
		}
		/*if (request.getParameter(SALARY_STATUS)!=null && !request.getParameter(SALARY_STATUS).equals("")) {
			salaryStatus = request.getParameter(SALARY_STATUS);
		}*/
		if(!request.getParameter(RANK_ID).equals("0")) {
			rankId = Integer.parseInt(request.getParameter(RANK_ID));
		}
		if(request.getParameter(LOCATION)!=null && !request.getParameter(LOCATION).equals("0")) {
			locationId = Integer.parseInt(request.getParameter(LOCATION));
		}
		if(!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		if(request.getParameter(EMPLOYEE_PERMANENT_ADDRESS) != null) {
			permanentAddress =request.getParameter(EMPLOYEE_PERMANENT_ADDRESS);
		}
		if(request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS) != null) {
			residentialAddress =request.getParameter(EMPLOYEE_RESIDENTIAL_ADDRESS);
		}
		if(request.getParameter(EMERGENCY_PHONE) != null) {
			emergencyTellNumber=request.getParameter(EMERGENCY_PHONE);
		}
		if(request.getParameter(EMERGENCY_MOBILE) != null) {
			emergencyCellNumber=request.getParameter(EMERGENCY_MOBILE);
		}
		if(request.getParameter(TELL_NO_RESIDENCE) != null) {
			residenceTellNumber=request.getParameter(TELL_NO_RESIDENCE);
		}
		if(request.getParameter(TELL_NO_OFFICE) != null) {
			officeTellNumber=request.getParameter(TELL_NO_OFFICE);
		}		
		if(request.getParameter(BANK_ACCOUNT_CODE) != null) {
			bankAccountCode=request.getParameter(BANK_ACCOUNT_CODE);
		}
		if(request.getParameter(ACCOUNT_HEAD) != null) {
			accounthead=request.getParameter(ACCOUNT_HEAD);
		}
		if(request.getParameter(BANK_CODE) != null) {
			bankCode=request.getParameter(BANK_CODE);
		}
		if(request.getParameter("bankBranch") != null) {
			bankBranch=request.getParameter("bankBranch");
		}
		if(request.getParameter("ifscCode") != null) {
			ifscCode=request.getParameter("ifscCode");
		}
		if(request.getParameter(EMAIL) != null) {
			email=request.getParameter(EMAIL);
		}
		if(request.getParameter(URL) != null) {
			employeeUrl=request.getParameter(URL);
		}
		if(request.getParameter(BANK_ACCOUNT_NUMBER) != null) {
			bankAccountNumber=request.getParameter(BANK_ACCOUNT_NUMBER);
		}
		if(!request.getParameter("religion").equals("0")) {
			religId = Integer.parseInt(request.getParameter("religion"));
		}
		if(!request.getParameter("caste").equals("0")) {
			caste = Integer.parseInt(request.getParameter("caste"));
		}
		if(!request.getParameter("subCaste").equals("0")) {
			subCaste = Integer.parseInt(request.getParameter("subCaste"));
		}
		if(!request.getParameter("category").equals("0")) {
			category = Integer.parseInt(request.getParameter("category"));
		}
		/*if(request.getParameter(PFNO) != null && !request.getParameter(PFNO).equals("") ) {
			pfNo= request.getParameter(PFNO);	
		}
		if(request.getParameter(PAY_MODE) != null && !request.getParameter(PAY_MODE).equals("") ) {
			payMode= request.getParameter(PAY_MODE);	
		}*/
		String handicapStatus = null;
		String insuranceType = null;
		String insuranceCompany = null;
		Date insuranceStartDate = null;
		Date insuranceEndDate = null;
		String medicalRemarks = null;
		String premium = "";
		String PEN="";
		String empName="";
		
		if(request.getParameter(HANDICAP_STATUS) != null && !request.getParameter(HANDICAP_STATUS).equals("") ) {
			handicapStatus = request.getParameter(HANDICAP_STATUS);	
		}
		if(request.getParameter(INSURANCE_TYPE) != null && !request.getParameter(INSURANCE_TYPE).equals("") ) {
			insuranceType= request.getParameter(INSURANCE_TYPE);	
		}
		if(request.getParameter(INSURANCE_COMPANY) != null && !request.getParameter(INSURANCE_COMPANY).equals("") ) {
			insuranceCompany= request.getParameter(INSURANCE_COMPANY);	
		}
		if(request.getParameter(INSURANCE_START_DATE) != null && !request.getParameter(INSURANCE_START_DATE).equals("") ) {
			insuranceStartDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(INSURANCE_START_DATE));
		}
		if(request.getParameter(INSURANCE_END_DATE) != null && !request.getParameter(INSURANCE_END_DATE).equals("") ) {
			insuranceEndDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(INSURANCE_END_DATE));
		}
		if(request.getParameter(MEDICAL_REMARKS) != null && !request.getParameter(MEDICAL_REMARKS).equals("") ) {
			medicalRemarks= request.getParameter(MEDICAL_REMARKS);	
		}
		
		if(request.getParameter("premium") != null && !request.getParameter("premium").equals("") ) {
			premium= request.getParameter("premium");	
		}

		if(request.getParameter("joinOrganisation") != null && !request.getParameter("joinOrganisation").equals("") ) {
			joinOrganisation_id = Integer.parseInt(request.getParameter("joinOrganisation"));	
		}
		if(request.getParameter("empName") != null && !request.getParameter("empName").equals("") ) {
			empName= request.getParameter("empName");	
		}
		if(request.getParameter("PEN") != null && !request.getParameter("PEN").equals("") ) {
			PEN= request.getParameter("PEN");	
		}
		/*if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title"); 
		}
		if(request.getParameter("pojoName") != null){
			pojoName = request.getParameter("pojoName"); 
		}
		if(request.getParameter("pojoPropertyName") != null){
			pojoPropertyName = request.getParameter("pojoPropertyName"); 
		}
		if(request.getParameter("pojoPropertyCode") != null){
			pojoPropertyCode = request.getParameter("pojoPropertyCode"); 
		}
		
		
		generalMap.put("code", code);
		generalMap.put("name", name);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		generalMap.put("pojoPropertyName", pojoPropertyName);
		generalMap.put("pojoPropertyCode", pojoPropertyCode);
		generalMap.put("pojoName", pojoName);

		listMap = commonMasterHandlerService.checkForExistingMasters(generalMap);
		List employeeNameList = new ArrayList();

		if(listMap.get("duplicateGeneralNameList") != null){
			employeeNameList = (List)listMap.get("duplicateGeneralNameList");
		}
		boolean successfullyAddedEmp = false;
		boolean addEmployeeLeaveBalance = false;
		//(employeeCodeList.size() == 0 ) && (employeeNameList.size() == 0 )
		if(true){
			if(employeeId != 0){
				masEmployee = personnelMasterHandlerService.getEmployeeTemp(employeeId);
				if(masEmployee != null){
				if(!masEmployee.getEmployeeType().getId().equals(employeeTypeId)){
					employeeTypeChanged = true;
				}
				}else{
					masEmployee = new MasEmployeeTemp();
				}
				//masEmployee.setId(employeeId);
			}else{
				addEmployeeLeaveBalance = true;
				masEmployee = new MasEmployeeTemp();
			}
			if(employeeTypeId != 0){
				MasEmployeeType masEmployeeType = new MasEmployeeType();
				masEmployeeType.setId(employeeTypeId);
				masEmployee.setEmployeeType(masEmployeeType);
			}
			//masEmployee.setServiceNo(serviceNo);
			//masEmployee.set
			
			
			// comment by javed  on 10-03-2015
			
			/*Resumepersonaldetails resumepersonaldetails = new Resumepersonaldetails();
			if(!applicantId.equals(0)){
				 resumepersonaldetails.setId(applicantId);
				 masEmployee.setResumepersonaldetails(resumepersonaldetails);
			}*/
			
			
			masEmployee.setFirstName(firstName);
			masEmployee.setLastName(lastName);
			masEmployee.setPeNo(PEN);
			masEmployee.setEmpName(empName);
			masEmployee.setFatherHusbandName(fatherOrHusbandName);
			masEmployee.setMiddleName(middleName);
			masEmployee.setEmployeePhoto(employeePhoto);
			masEmployee.setConfirmationDueDate(confirmationDueDate);
			masEmployee.setLastWorkingDay(lastWorkingDay);
			masEmployee.setDateOfResignation(dateOfResignation);
			masEmployee.setProbationPeriod(probationPeriod);
			masEmployee.setBankAccountNumber(bankAccountNumber);
			masEmployee.setEquivalentDesignation(equivalentDesignation);
			masEmployee.setUrl(employeeUrl);
			if(titleId != 0){
				MasTitle masTitle = new MasTitle();
				masTitle.setId(titleId);
				masEmployee.setTitle(masTitle);
			}
			if(departmentId != 0){
				MasDepartment masDepartment = new MasDepartment();
				masDepartment.setId(departmentId);
				masEmployee.setDepartment(masDepartment);
			}
			/*if(sbuId != 0){
				MasSbu masSbu = new MasSbu();
				masSbu.setId(sbuId);
				masEmployee.setSbu(masSbu);
			}*/
			//System.out.println("sbuId>>>>"+sbuId);
			if(empStatusId !=0){
				MasEmpStatus masEmpStatus = new MasEmpStatus();
				masEmpStatus.setId(empStatusId);
				masEmployee.setEmployeeStatus(masEmpStatus);
			}
			if(gradeId != 0){
				MasGrade masGrade = new MasGrade();
				masGrade.setId(gradeId);
				masEmployee.setGrade(masGrade);
			}
			if(empCategoryId != 0){
				MasEmpCategory masEmpCategory = new MasEmpCategory();
				masEmpCategory.setId(empCategoryId);
				masEmployee.setEmpCategory(masEmpCategory);
			}
			if(rankId != 0){
				MasRank masRank = new MasRank();
				masRank.setId(rankId);
				masEmployee.setRank(masRank);
			}
			if(religId != 0){
				MasReligion masReligion = new MasReligion();
				masReligion.setId(religId);
				masEmployee.setEmpReligion(masReligion);
			}
			if(caste != 0){
				MasEmployeeCaste mec = new MasEmployeeCaste();
				mec.setId(caste);
				masEmployee.setEmpCaste(mec);
			}
			if(subCaste != 0){
				MasEmployeeSubCaste mesc = new MasEmployeeSubCaste();
				mesc.setId(subCaste);
				masEmployee.setEmpSubCaste(mesc);
			}
			if(category != 0){
			/*	MasCategory masCategory = new MasCategory();
				masCategory.setId(category);
				masEmployee.setEmpCategory(masCategory);*/
			}
			/*if(locationId != 0){
				masEmployee.setLocationId(locationId);
			}*/
			
			/*if(holidaycal != 0){
				MasLocation masLocation = new MasLocation();
				masLocation.setId(holidaycal);
				masEmployee.setHolidayAsPer(masLocation);
			} */
			masEmployee.setSalaryStatus(salaryStatus);
			masEmployee.setAppointmentDate(appointmentDate);
			masEmployee.setPermanentAddress(permanentAddress);
			masEmployee.setResidentialAddress(residentialAddress);
			masEmployee.setEmail(email);
			masEmployee.setTelNoEmergency(emergencyTellNumber);
			masEmployee.setCellNoEmergency(emergencyCellNumber);
			masEmployee.setTelNoResidence(residenceTellNumber);
			masEmployee.setTelNoOffice(officeTellNumber);
			masEmployee.setBankCode(bankCode);
			masEmployee.setBankBranch(bankBranch);
			masEmployee.setIfscCode(ifscCode);
			masEmployee.setBankCode(bankCode);
			masEmployee.setAccountHead(accounthead);
			masEmployee.setJoinDate(joinDate);
			masEmployee.setBankAccountCode(bankAccountCode);
			if(managerId!=null){
				MasEmployee emp = new MasEmployee();
				emp.setId(managerId);
				masEmployee.setLineManager(emp);
				
			}else{
				masEmployee.setLineManager(null);
			}
			if(!cardNo.equals("")){
				masEmployee.setCardNo(cardNo);				
			}
			if(!pfNo.equals("")){
				//masEmployee.setPFNo(pfNo);
			}
			if(!payMode.equals("")){
				masEmployee.setPaymentMode(payMode);
			}
			
			//if(!handicapStatus.equals("")){
				masEmployee.setHandicapStatus(handicapStatus);
			//}
			//if(!insuranceType.equals("")){
				masEmployee.setInsuranceType(insuranceType);
			//}
			//if(!insuranceCompany.equals("")){
				masEmployee.setInsuranceCompany(insuranceCompany);
			//}
			//if(insuranceStartDate != null){
				masEmployee.setInsuranceStartDate(insuranceStartDate);
			//}
			//if(insuranceEndDate != null){
				masEmployee.setInsuranceEndDate(insuranceEndDate);
			//}
			//if(!medicalRemarks.equals("")){
				masEmployee.setMedicalRemarks(medicalRemarks);
			//}
				masEmployee.setInsurancePremium(premium);
			
		//	int personnelId = (Integer)session.getAttribute(HOSPITAL_ID);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(joinOrganisation_id);
			masEmployee.setHospital(masHospital);
			
			masEmployee.setStatus("y");
			masEmployee.setLastChgBy(users);
			
			 MasEmployee me = new MasEmployee();
			 me.setId(employeeId);
			 me.setStatus("e");
			 
			 masEmployee.setEmployee(me);
			 
			 
			masEmployee.setLastChgDate(currentDate);
			masEmployee.setLastChgTime(currentTime);
			String lastAddedEmployeeCode = "";
			Integer employeeCodeSeries = 0; 
			
			// comment by javed khan for save manually employee code
			
			/*if(employeeId == 0 ){
				MasEmployee lastAddedEmployee = personnelMasterHandlerService.getLastAddedEmployee(employeeTypeId, joinOrganisation_id);
				if(lastAddedEmployee!= null){
					lastAddedEmployeeCode = lastAddedEmployee.getEmployeeCode();
					employeeCodeSeries = new Integer(lastAddedEmployeeCode.substring(2,6 ));
				}else{
					employeeCodeSeries =0000;
				}
				employeeCodeSeries++;
				String codeString = employeeCodeSeries.toString();
				String currentEmployeeCode = "";
				if(codeString.length() == 1){
					currentEmployeeCode = "000"+codeString;
				}
				if(codeString.length() == 2){
					currentEmployeeCode = "00"+codeString;
				}
				if(codeString.length() == 3){
					currentEmployeeCode = "0" + codeString;
				}
				if(codeString.length() == 4){
					currentEmployeeCode = codeString;
				}
				MasHospital company =  personnelMasterHandlerService.getCompany(joinOrganisation_id);
				String companyCode = company.getHospitalCode();
				MasEmployeeType employeeType = personnelMasterHandlerService.getEmployeeType(employeeTypeId);
				empCode = companyCode + employeeType.getTypeCode() + currentEmployeeCode ;
				masEmployee.setEmployeeCode(empCode);
			}else{
				if(employeeTypeChanged.equals(true)){
					String previousEmployeeCode = masEmployee.getEmployeeCode();
					String companyCode = previousEmployeeCode.substring(0, 2);
					String employeeCode = previousEmployeeCode.substring(3, 7);
					MasEmployeeType employeeType = personnelMasterHandlerService.getEmployeeType(employeeTypeId);
					empCode = companyCode + employeeType.getTypeCode() + employeeCode;
					masEmployee.setEmployeeCode(empCode);
				}
			}*/
			
			// comment by javed khan for save manually employee code
			
			 // added by javed khan for save manually employee code
			
			if(request.getParameter("employee_Code") != null && !request.getParameter("employee_Code").equals("") ) {
				empCode= request.getParameter("employee_Code");	
			}
			int education=0;
			if(request.getParameter("hdb") != null && !request.getParameter("hdb").equals("") ) {
				education= Integer.parseInt(""+request.getParameter("hdb"));	
				//System.out.println("education>>>>"+education);
			}
			
			//System.out.println("empCode>>>>"+empCode);
			masEmployee.setEmployeeCode(empCode);
			
			String name_emer1="";
			String name_emer2="";
			String rel_emer1="";
			String rel_emer2="";
			String contact_emer1="";
			String contact_emer2="";
			String decimalCard="";
			if(request.getParameter("emer_name1") != null && !request.getParameter("emer_name1").equals("") ) {
				name_emer1= request.getParameter("emer_name1");	
			}
			
			if(request.getParameter("emer_name2") != null && !request.getParameter("emer_name2").equals("") ) {
				name_emer2= request.getParameter("emer_name2");	
			}
			
			if(request.getParameter("emer_rel1") != null && !request.getParameter("emer_rel1").equals("") ) {
				rel_emer1= request.getParameter("emer_rel1");	
			}
			
			if(request.getParameter("emer_rel2") != null && !request.getParameter("emer_rel2").equals("") ) {
				rel_emer2= request.getParameter("emer_rel2");	
			}
			
			if(request.getParameter("emer_cont1") != null && !request.getParameter("emer_cont1").equals("") ) {
				contact_emer1= request.getParameter("emer_cont1");	
			}
			
			if(request.getParameter("emer_cont2") != null && !request.getParameter("emer_cont2").equals("") ) {
				contact_emer2= request.getParameter("emer_cont2");	
			}
			
			if(request.getParameter("Decimal_CARD_NO") != null && !request.getParameter("Decimal_CARD_NO").equals("") ) {
				decimalCard= request.getParameter("Decimal_CARD_NO");	
			}
			
			/*masEmployee.setNameEmergancy1(name_emer1);
			masEmployee.setNameEmergancy2(name_emer2);
			masEmployee.setRelationEmergancy1(rel_emer1);
			masEmployee.setRelationEmergancy2(rel_emer2);
			masEmployee.setContactEmergancy1(contact_emer1);
			masEmployee.setContactEmergancy2(contact_emer2);
			masEmployee.setDecimalCardNo(decimalCard);*/
			
			
			HrEmployeePersonelDetails employeePersonelDetails = null;
			 //later open
			/*employeePersonelDetails = setAndGetEmployeePersonelDetails(masEmployee,request);
			personnelMasterHandlerService.addEmployeePersonelDetails(employeePersonelDetails);*/
			
			
			/*HrEmployeeExperience employeeExperience = null;
			employeeExperience = setAndGetEmployeeExperience(masEmployee,request,j);
			personnelMasterHandlerService.addEmployeeExperience(employeeExperience);	
			masEmployee.setEmployeeExperience(employeeExperience);*/
			masEmployee.setPersonalDetails(employeePersonelDetails);
			
			
			try{
				Map map1 = new HashMap();
				map1.put("masEmployee", masEmployee);
				map1.put("me", me);
				successfullyAddedEmp = personnelMasterHandlerService.addEmployeeTemp(map1);		
				UserManager userManager = null;
				List managerList = null;
				if(employeeId == 0){
					userManager = new UserManager();
				}else{
					Set set = masEmployee.getUserManager();
					if(set!=null && !set.isEmpty()){
					 managerList =new ArrayList(set);
					 userManager = (UserManager)managerList.get(0);
					}else{
						userManager = new UserManager();
					}
				}
				
				// added by javed khan
				
				
				/*if(masEmployee.getEmployeeExperience().size() == 0){
				//if(education == 0){
					System.out.println("experience 0");
					for(int j = 1; j <= 5; j++) {
						
						HrEmployeeExperience employeeExperience = null;						
						employeeExperience = setAndGetEmployeeExperience(employeeExperience,request,j);							
						employeeExperience.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
						
					}
				} else {
					System.out.println("experience not 0");
					int j= 1;
					//incrementFlag = true;
					//List<HrMasEmployeeEducation> sortedList = new ArrayList<HrMasEmployeeEducation>();
					List<HrEmployeeExperience> sortedList = new ArrayList<HrEmployeeExperience>();
					sortedList.addAll(masEmployee.getEmployeeExperience());
					Collections.sort(sortedList, new employeeExperienceComprator());
					
					for(HrEmployeeExperience employeeExperience : sortedList) {
						//employeeExperience =new HrEmployeeExperience();
						 employeeExperience = setAndGetEmployeeExperience(employeeExperience,request, j);
						employeeExperience.setEmployee(masEmployee);	
						//personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
						personnelMasterHandlerService.addEmployeeExperience(employeeExperience);
						j++;
					}
				}
				*/
				
				MasEmployee manager = new MasEmployee();
				manager.setId(managerId);
				userManager.setManagers(manager);
				userManager.setManagerId(managerId);
				if(masEmployee!= null){
					MasEmployee user = new MasEmployee();
					user.setId(masEmployee.getId());
					userManager.setUsers(user);
					userManager.setEmpId(masEmployee.getId());
				}
				if(masEmployee!= null && addEmployeeLeaveBalance){
					int sexid = 0;
					Date birthday=null;
					Date mrgday=null;
					if(masEmployee.getPersonalDetails()!=null) {
						 sexid=masEmployee.getPersonalDetails().getGender().getId();
						  birthday= masEmployee.getPersonalDetails().getDateOfBirth();
						  mrgday = masEmployee.getPersonalDetails().getMarriageDate();
						 
					}
					String mnthORyear="";
					
					// Leave code comment by javed khan  on 10-03-2015 
					
				
					/*
					
					List<HrMasLeaveTypeMediator> hrMasLeaveTypeMediatorList = personnelMasterHandlerService.getMasLeaveTypeMediatorList();
					//System.out.println("mediotor size>>>"+hrMasLeaveTypeMediatorList.size());
					for(HrMasLeaveTypeMediator mediator : hrMasLeaveTypeMediatorList){
						HrMasLeaveTypeNew hrMasLeaveTypeNewobj = mediator.getLeaveType();
						HrMasLeave leaveType=hrMasLeaveTypeNewobj.getLeaveType();
						mnthORyear = hrMasLeaveTypeNewobj.getMonthlyOrYearly();
						int leaveTypeId=0;
						leaveTypeId=leaveType.getId();
					
						double noOfDaysAllowed =0;
						
						noOfDaysAllowed=Double.valueOf(hrMasLeaveTypeNewobj.getAllowedDays());
						
						HrEmployeeBalanceNew hrEmployeeBalanceNew = new HrEmployeeBalanceNew();
						hrEmployeeBalanceNew.setAlreadyAvailedPatMat("n");
						hrEmployeeBalanceNew.setTotalLeaveTaken("0");;
						hrEmployeeBalanceNew.setBalanceAdjustedBy("0");
						hrEmployeeBalanceNew.setOpeningBalance("0");
						hrEmployeeBalanceNew.setOpeningBalanceYearly("0");
						hrEmployeeBalanceNew.setLeaveType(mediator);
						hrEmployeeBalanceNew.setStatus("y");
						hrEmployeeBalanceNew.setTaken(new DecimalFormat("0.##").format((double)0));
						hrEmployeeBalanceNew.setTotalLeaveTaken(new DecimalFormat("0.##").format((double)0));
						boolean addEmpBalance = false;
						System.out.println(sexid+"elseif>>>> "+leaveTypeId);
					//	if(((sexid==3) && (leaveTypeId==4)) || ((sexid==2)&&(leaveTypeId==3))) {
						if(((sexid==2)&&(leaveTypeId==3))) { // for maternity
							hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format((double)noOfDaysAllowed));
							hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(noOfDaysAllowed));
							addEmpBalance = true;
							hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(noOfDaysAllowed));
						}else{
		    				if(leaveTypeId != 3 && leaveTypeId != 4 ){ // not for mat,pat		    					
		    					//System.out.println(mediator.getId()+"<<<<elseif1111>>>> "+leaveTypeId);
		    					Calendar cal = Calendar.getInstance();
								cal.setTime(masEmployee.getJoinDate());
								
								int joiningMonth = cal.get(Calendar.MONTH)+1;
								int joiningDateDay = cal.get(Calendar.DATE);
								double entitlementAccJoinDate = 0;
								double multiplier = 0;
								
								double closingBalance = 0;
								double adj = 0;
								double earned = 0;
								double accrued = 0;
								
								entitlementAccJoinDate = (12-joiningMonth);
								//System.out.println(leaveTypeId+"mnthORyear> 22>>> "+mnthORyear);
								if(mnthORyear.equalsIgnoreCase("m") || leaveTypeId == 20 || leaveTypeId == 22){
									
									multiplier =  noOfDaysAllowed;
									System.out.println("this one"+noOfDaysAllowed);
									//if(joiningDateDay <=20){
									//	System.out.println("20 days");
										//closingBalance = noOfDaysAllowed;
										//earned = noOfDaysAllowed;
										//adj =  noOfDaysAllowed;
										//accrued = noOfDaysAllowed;
										//if(employeeTypeId == 4){ // added by javed khan ... if employee is in Probation period
											//System.out.println("employeeTypeId>>>"+employeeTypeId);
										//	multiplier =  noOfDaysAllowed/2;
											//closingBalance = noOfDaysAllowed/2;
											//earned = noOfDaysAllowed/2;
											//adj =  noOfDaysAllowed/2;
											//accrued = noOfDaysAllowed/2;
										//}
										
									//} else {
										closingBalance = 0.0;
										earned = 0.0;
										adj = 0.0;
										accrued = 0.0;
									//}
									// for birthday leave add in PL
									
									//if(leaveTypeId == 13 && birthday.getDate() >= new Date().getDate() && (birthday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance =closingBalance+ 1.0;
									//}
									
									// for Mrgday leave add in PL
									
									//if(leaveTypeId == 13 && masEmployee.getEmployeePersonalDetails().getMaritalStatus().getMaritalStatusCode().equals("M")){
										//if(  mrgday.getDate() >= new Date().getDate()  && (mrgday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance =closingBalance+ 1.0;
										//}
									//}
									
								} else if(mnthORyear.equalsIgnoreCase("y")){
									//System.out.println(joiningDateDay+"<<<joiningDateDay  mnthORyear 333>>>> "+mnthORyear);
									//System.out.println("in y");
									//if(leaveTypeId !=5){ // not applicable for birth day
									multiplier =  noOfDaysAllowed/12.0;
									//if(joiningDateDay <=20){
										//closingBalance = noOfDaysAllowed/12.0;
										//earned = noOfDaysAllowed/12.0;
										//adj =  noOfDaysAllowed/12.0;
										//accrued = noOfDaysAllowed/12.0;
										
									//} else {
										closingBalance = 0.0;
										earned = 0.0;
										adj = 0.0;
										accrued = 0.0;
										//}
									//}
									//if(leaveTypeId == 5 && birthday.getDate() >= new Date().getDate()  && (birthday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance = 1.0;
										//earned = 1.0;
										
									//}
									
									//if(leaveTypeId == 24 ){ // for rh
									//	closingBalance = 0.0;
									//	earned = 0.0;
										
									//}
									
									
									//if(leaveTypeId == 6 && mrgday.getDate() >= new Date().getDate()  && (mrgday.getMonth()+1) == (new Date().getMonth()+1)){
										//closingBalance = 1.0;
										//earned = 1.0;
										
									//}
								}
								//entitlementAccJoinDate = (12-joiningMonth)*(Float.valueOf(new DecimalFormat("0.##").format(multiplier))) + adj;
								entitlementAccJoinDate = noOfDaysAllowed;
								//System.out.println("entitlementAccJoinDate>>>>  "+entitlementAccJoinDate);
								if(leaveTypeId == 20 ) {
									//closingBalance = noOfDaysAllowed;
									//earned = noOfDaysAllowed;
									entitlementAccJoinDate = earned;
									//accrued = noOfDaysAllowed;
								}			
								if(leaveTypeId == 21 || leaveTypeId == 23  || leaveTypeId == 13){ // for EL
									hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(0));	
									hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format(0));
									hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(0));	
									addEmpBalance = true;
								}else{
								hrEmployeeBalanceNew.setEarned(new DecimalFormat("0.##").format(earned));
								hrEmployeeBalanceNew.setEntitlementAccJoinDate(new DecimalFormat("0.##").format(entitlementAccJoinDate));	
								//hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(closingBalance));
								hrEmployeeBalanceNew.setClosingBalance(new DecimalFormat("0.##").format(entitlementAccJoinDate));
								hrEmployeeBalanceNew.setClosingBalanceYearly(new DecimalFormat("0.##").format(entitlementAccJoinDate));
								hrEmployeeBalanceNew.setAccrued(new DecimalFormat("0.##").format(accrued));	
								addEmpBalance = true;
								}
		    				}
						}
						hrEmployeeBalanceNew.setCompany(masHospital);
						hrEmployeeBalanceNew.setEmp(masEmployee);
						hrEmployeeBalanceNew.setLastChgBy(changedBy);
						hrEmployeeBalanceNew.setLastChgDate(currentDate);
						hrEmployeeBalanceNew.setLastChgTime(currentTime);
						//System.out.println("addEmpBalance>>>>> "+addEmpBalance);
						if(addEmpBalance){
							System.out.println("addEmpBalance1>>>"+addEmpBalance);
							personnelMasterHandlerService.addEmployeeBalanceDetails(hrEmployeeBalanceNew);	
						}
					}*/ 
					// Leave code comment by javed khan  on 10-03-2015 
				}
				if(managerId!=null){
				personnelMasterHandlerService.addUserManager(userManager);
				}
				personnelMasterHandlerService.refreshObject(masEmployee);
				//personnelMasterHandlerService.UpdateSecurityDepositeStatus(masEmployee);// add by javed khan
				boolean incrementFlag = true;
				
				/*if(masEmployee.getEmployeeEducation().size() == 0){
				//if(education == 0){
					System.out.println("education 0");
					for(int i = 1; i <= 5; i++) {
						HrMasEmployeeEducation employeeEducation = null;
						employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i,incrementFlag );
						employeeEducation.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
					}
				} else {
					System.out.println("education not 0");
					int i= 1;
					incrementFlag = true;
					List<HrMasEmployeeEducation> sortedList = new ArrayList<HrMasEmployeeEducation>();
					sortedList.addAll(masEmployee.getEmployeeEducation());
					Collections.sort(sortedList, new EmployeeEducationComparator());
					
					for(HrMasEmployeeEducation employeeEducation : sortedList) {
					//for(int i=1; i<=education; i++){
						 //employeeEducation =new HrMasEmployeeEducation();
						
						// System.out.println("---"+i);
						//System.out.println(i+"education enter"+employeeEducation);
						//employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i,incrementFlag);
						employeeEducation = setAndGetEmployeEducation(employeeEducation,request, i,incrementFlag);
						//System.out.println("education enter2"+employeeEducation);
						employeeEducation.setEmployee(masEmployee);	
						personnelMasterHandlerService.addEmployeeEducation(employeeEducation);
						i++;
					}
				}*/
			} catch(DataIntegrityViolationException e) {
				msgForCard = "Card No already occupied . Please enter another card no.";
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(successfullyAddedEmp == true){
				if(!applicantId.equals(0)){
					
					// commnet by javed khan for through application on 10-03-2015 
					
					/*Resumepersonaldetails resume = (Resumepersonaldetails)personnelMasterHandlerService.loadObject(Resumepersonaldetails.class, applicantId);
					Resumestatus resumestatus = resume.getResumeStatus();
					resumestatus.setStatusId(19);
					Resumestatushistory resumeStatusHistory = resume.getResumeStatusHistory();
					resumeStatusHistory.setStatusId(19);
					resumeHandlerService.addResumeStatus(resumestatus, resumeStatusHistory);
					migrateResumePayElementsToEmployeePayElements(request,masEmployee,resume);*/
					
					
					message = "Applicant Added Successfully !! \n Employee Code generated : " +empCode;
				}else{
					message = "New Employee Added Successfully !! \n Employee Code generated : " +empCode;
				}
			}else{
				message = "Try Again !!";
			}
		}else if(employeeNameList.size() != 0){
			message = "Employee Code already exists.";
		}
		if(employeeId != 0 ){
			message = "Record Updated Successfully";
			if(employeeTypeChanged.equals(true)){
				message += " and new Employee Code generated is " + 	empCode;
			}
		}
		if(msgForCard != null){
			message = msgForCard;
		}
		url = "/hms/hms/personnel?method=showEmployeeJsp";
		try{
			/*Map<String, Object> dataMap = new HashMap<String, Object>();
			String centreId =""+session.getAttribute("locationId");
			dataMap.put("centreId",centreId);*/
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
			dataMap.put("userName", userName);
			dataMap.put("hospitalId", hospitalId);
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 
			}
			dataMap.put("userType", userType);
			map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
		   
		   mapDep = personnelMasterHandlerService.showEmployeeDependentJsp();
		   map.putAll(mapDep);
		}catch (Exception e) {
		    e.printStackTrace();
		}
		jsp=EMPLOYEE_JSP;
		title="Add Employee";
		jsp += ".jsp";		    
		List joinedCandidates = resumeHandlerService.getJoinedCandidates();
		map.put("joinedCandidates", joinedCandidates);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}
	
	// add by javed khan for PEN mannual 06-05-2014
	
		public void getEmployeeCode(HttpServletRequest request,HttpServletResponse response) {
			
			
			String userName = "";
			int deptId = 0;
		
			session = request.getSession();
			if (session.getAttribute("userName") != null)
				userName = (String) session.getAttribute("userName");
			if (session.getAttribute("deptId") != null)
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			// --------------------------------------------------------------------------------
			Map<String, Object> dataMap = new HashMap<String, Object>();
			String PEN = "";
			try {
				if (request.getParameter("empCode") != null) {
					PEN = request.getParameter("empCode");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println("empCode------------>>>>>>"+empCode);
			dataMap.put("PEN", PEN);
			String status="";
			map = personnelMasterHandlerService.getEmployeeCode(dataMap);
			if (map.get("status") != null) {
				status = (String) map.get("status");
			}

			System.out.println(status);
			StringBuffer sb = new StringBuffer();
				sb.append("<item>");
				sb.append("<status>" + status + "</status>");

				sb.append("</item>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<items>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</items>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			// return new ModelAndView(jsp, "map", map);
		}
		
		
		public ModelAndView getEducationAndExper(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("getEducationAndExper"+request.getParameter("empId"));
			Map<String, Object> map = new HashMap<String, Object>();
			int empId = Integer.parseInt(request.getParameter("empId"));

			map = personnelMasterHandlerService.getEducationAndExperForEdit(empId);
			System.out.println("first");
			String jsp = "responseForEmployee";
			return new ModelAndView(jsp, "map", map);
		}
		
		
		public ModelAndView removeEmployee(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int employeeId = 0;
			String message = null;
			Users changedBy = null;
			String changedTime = "";
			Date changedDate = null;
			String flag = "";
			int hospitalId = 0;
			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
			}
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
				generalMap.put("flag", flag);
			}
			if (request.getParameter(COMMON_ID) != null
					&& !(request.getParameter(COMMON_ID).equals(""))) {
				employeeId = Integer.parseInt(request.getParameter(COMMON_ID));
			}
			if (request.getParameter("title") != null) {
				title = request.getParameter("title");
			}
			if (session.getAttribute("users") != null) {
				changedBy = (Users) session.getAttribute("users");
			}
			changedDate = new Date();
			changedTime = (String) HMSUtil.getCurrentDateAndTime().get(
					"currentTime");

			generalMap.put("changedBy", changedBy);
			generalMap.put("currentDate", changedDate);
			generalMap.put("currentTime", changedTime);
			boolean dataRemoved = false;
			dataRemoved = personnelMasterHandlerService.removeEmployee(employeeId,
					generalMap);
			if (dataRemoved == true) {
				message = "Record is Removed successfully !!";
			} else {
				message = "Record is Removed successfully !!";
			}
			url = "/hms/hms/personnel?method=showEmployeeJsp";
			try {
				Map<String, Object> dataMap = new HashMap<String, Object>();
				dataMap.put("districtId", (Integer)session.getAttribute("districtId"));
				dataMap.put("userName", userName);
				dataMap.put("hospitalId", hospitalId);
				int userType = 0;
				if(session.getAttribute("users") != null){
					 Users user = (Users)session.getAttribute("users");
					 userType = user.getUserType()!=null?user.getUserType():4;
					 
				}
				dataMap.put("userType", userType);
				map = personnelMasterHandlerService.showEmployeeJsp(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsp = EMPLOYEE_JSP;
			title = "Delete Employee";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showRemovedEmployeeInstitutionMappingJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId = 0;
			String message="";  //Added By Om Tripathi 23/11/2017
			if(request.getParameter("bsScInst")!=null){
				hospitalId = Integer.parseInt(request.getParameter("bsScInst"));
				box.put("hospitalId", hospitalId);
			}else if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
				box.put("hospitalId", hospitalId);
			}
			String pen = "";
			if (request.getParameter("pen") != null){
				pen =request.getParameter("pen");
				box.put("pen", pen);
			}
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 box.put("userId", user.getId());
			}
			box.put("userType", userType);
			map = personnelMasterHandlerService.showRemovedEmployeeInstitutionMappingJsp(box); 
			jsp = "removedEmployeeInstitutionMapping";
			title = "Delete Employee";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView searchRemovedEmployeeInstitutionMappingJsp(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId = 0; 
			String message=""; //Added By Om Tripathi 23/11/2017
			
			if(request.getParameter("bsScInst")!=null){
				hospitalId = Integer.parseInt(request.getParameter("bsScInst"));
				box.put("hospitalId", hospitalId);
			}else if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
				box.put("hospitalId", hospitalId);
			}
			String pen = "";
			if (request.getParameter("pen") != null){
				pen =request.getParameter("pen");
				box.put("pen", pen);
			}
			int userType = 0;  //Added By Om Tripathi
			if(session.getAttribute("users") != null && session.getAttribute("users") != ""){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 box.put("userId", user.getId());
			}
			box.put("userType", userType);
			map = personnelMasterHandlerService.searchRemovedEmployeeInstitutionMappingJsp(box);
			jsp = "removedEmployeeInstitutionMapping";
			title = "Delete Employee";
			jsp += ".jsp";
			map.put("hospitalId", hospitalId);
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showRemovedEmployeeDetail(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId = 0;
			if (session.getAttribute("hospitalId") != null){
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
				box.put("hospitalId", hospitalId);
			}
			int employeeId = 0;
			if (request.getParameter("employeeId") != null){
				employeeId = Integer.parseInt(request.getParameter("employeeId"));
				box.put("employeeId", employeeId);
			}
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
				 box.put("userId", user.getId());
			}
			box.put("userType", userType);
			map = personnelMasterHandlerService.showRemovedEmployeeDetail(box);
			jsp = "removedEmployeeInstitutionMapping";
			title = "Delete Employee";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView assignInstituteForRemovedEmployee(HttpServletRequest request,HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int userId = 0;
			String message="";  // Added By Om Tripathi 23/11/2017
			boolean successfullyAdded = false;
			if (session.getAttribute("userId") != null) {
				userId = Integer.parseInt(""+session.getAttribute("userId"));
				box.put("userId", userId);
			}
			if (session.getAttribute("hospitalId") != null) {//changed by govind 16-12-2016
				int hospitalId = Integer.parseInt(""+session.getAttribute("hospitalId"));
				box.put("hospitalId", hospitalId);
			}
			int userType = 0;
			if(session.getAttribute("users") != null){
				 Users user = (Users)session.getAttribute("users");
				 userType = user.getUserType()!=null?user.getUserType():4;
			}
			box.put("userType", userType);
			map = personnelMasterHandlerService.assignInstituteForRemovedEmployee(box);
			if(map.get("successfullyAdded") != null){
				successfullyAdded = (boolean)map.get("successfullyAdded");
			}
			if (successfullyAdded) {
				message = "Record Added Successfully !!";
			} else {
				message = "Try Again !!";
			}
			jsp = "removedEmployeeInstitutionMapping";
			title = "Delete Employee";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index", "map", map);
		}
	
	// --------------------------------------------------------------------------------------------
	public PersonnelMasterHandlerService getPersonnelMasterHandlerService() {
		return personnelMasterHandlerService;
	}

	public void setPersonnelMasterHandlerService(
			PersonnelMasterHandlerService personnelMasterHandlerService) {
		this.personnelMasterHandlerService = personnelMasterHandlerService;
	}

	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}

	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	public ResumeHandlerService getResumeHandlerService() {
		return resumeHandlerService;
	}

	public void setResumeHandlerService(
			ResumeHandlerService resumeHandlerService) {
		this.resumeHandlerService = resumeHandlerService;
	}
	
	public ModelAndView getMasInstituteEmployeeDepartment(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=Integer.parseInt(request.getParameter("hospitalId"));System.out.println("hospitalIdhospitalId "+hospitalId);
		map.put("hospitalId", hospitalId);
		map=personnelMasterHandlerService.getMasInstituteEmployeeDepartment(map);
		return new ModelAndView("responseForHospitalEmployeeDepartment","map",map);
	}
	
	//added by govind 07-01-2017
		public ModelAndView fillInstHospital(HttpServletRequest request,
				HttpServletResponse response) {
			int districtId=0,instType=0;
			session = request.getSession(true);
			String parameter="";
			if(request.getParameter("districtId")!=null){
				districtId=Integer.parseInt(request.getParameter("districtId"));
			}
			if(request.getParameter("instType")!=null){
				instType=Integer.parseInt(request.getParameter("instType"));
			}
			if(request.getParameter("parameter")!=null){
				parameter=request.getParameter("parameter");
			}
			map = personnelMasterHandlerService.fillInstHospital(districtId,instType);
			jsp = "responseHospitalByDiv";
			
			/*jsp += ".jsp";*/
			title = "Hospital";
			map.put("contentJsp", jsp);
			map.put("parameter", parameter);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}//added by govind 07-01-2017 end
		
		public void showTabletDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();

			
			String hospitalName ="";
			int districtId = 0;
			if(request.getParameter("districtId")!=null){
				districtId= Integer.parseInt(request.getParameter("districtId"));
			}
			if(request.getParameter("hospitalId")!=null){
				hospitalName = request.getParameter("hospitalId");
			}String mac="";
			String utid="";
			String sim="";
			Long imei=0l;
			List<MasHospital> hospitalList=new ArrayList<MasHospital>();
			map = personnelMasterHandlerService.showTabletDetails(hospitalName, districtId);
			if(map.get("tabletDetails")!=null){
				hospitalList = (List<MasHospital>)map.get("tabletDetails");
				if(hospitalList.size()>0){
					sim = hospitalList.get(0).getSimNo();
					imei = hospitalList.get(0).getImeiNo();
					utid = hospitalList.get(0).getUtid();
					mac = hospitalList.get(0).getMac();
				}
				
			}
			StringBuffer sb = new StringBuffer();
			sb.append("<tablet>");
			sb.append("<simNo>" + sim + "</simNo>");
			sb.append("<imeiNo>" + imei + "</imeiNo>");
			sb.append("<macNo>" + mac + "</macNo>");
			sb.append("<utidNo>" + utid + "</utidNo>");
			sb.append("</tablet>");
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");

			try {
				response.getWriter().write(
						"<?xml version='1.0' encoding='ISO-8859-1'?>");
				response.getWriter().write("<tablet>");
				response.getWriter().write(sb.toString());
				response.getWriter().write("</tablet>");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//Added By Om Tripathi  
		public ModelAndView generateReportRemovedEmployee(HttpServletRequest request,
				HttpServletResponse response) {

			ServletContext context = request.getSession().getServletContext();
			
			Map<String, Object> parameters = new HashMap();
			int hospitalId=0;
			try {
				
			String query = "where mas_employee.status='D'";
			parameters.put("query", query);

			Map<String, Object> connectionMap = personnelMasterHandlerService.getConnection();
			HMSUtil.generateReport("removed_employee_report", parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());

			
			}catch(Exception e){
				
		}
			return null;
		}
		
		public void hrInstituteWiseDeptList(HttpServletRequest request,HttpServletResponse response) throws IOException{
			Map<String,Object> map=new HashMap<String,Object>();
			List<String> empDepts=new ArrayList<String>();
			if(request.getParameter("hospitalId")!=null){
				int hospitalId=Integer.parseInt(request.getParameter("hospitalId"));
				map=personnelMasterHandlerService.hrInstituteWiseDeptList(hospitalId);
				
				if(map.get("employeeDepartmentList")!=null){
					List<MasEmployeeDepartment> deptList=(List<MasEmployeeDepartment>)map.get("employeeDepartmentList");
					if(deptList.size()>0){
						for(MasEmployeeDepartment dept:deptList){
							empDepts.add(dept.getId()+":"+dept.getEmpDeptName());
						}
					}
				}
				PrintWriter out=response.getWriter();
				out.print(empDepts);
			}
			
		}
		
}