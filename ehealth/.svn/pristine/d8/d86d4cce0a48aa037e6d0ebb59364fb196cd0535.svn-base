package jkt.hrms.attendance.controller;

import static jkt.hms.util.RequestConstants.EMPLOYEE_CATEGORY;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.SEARCH_FIELD;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.USERS;
import static jkt.hrms.util.HrmsRequestConstants.ATTENDANCE_DATE;
import static jkt.hrms.util.HrmsRequestConstants.ATTENDANCE_LOADER;
import static jkt.hrms.util.HrmsRequestConstants.ATTENDANCE_MARK;
import static jkt.hrms.util.HrmsRequestConstants.CARD_NO;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_BY;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_DATE;
import static jkt.hrms.util.HrmsRequestConstants.CHANGED_TIME;
import static jkt.hrms.util.HrmsRequestConstants.CODE;
import static jkt.hrms.util.HrmsRequestConstants.COMMON_ID;
import static jkt.hrms.util.HrmsRequestConstants.DEPARTMENT_ID;
import static jkt.hrms.util.HrmsRequestConstants.DISPLAY_DATE;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ATTENDANCE_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ATTENDANCE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_ID;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_NAME;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_SHIFT_DETAILS;
import static jkt.hrms.util.HrmsRequestConstants.EMPLOYEE_SHIFT_DETAILS_ID;
import static jkt.hrms.util.HrmsRequestConstants.END_DATE;
import static jkt.hrms.util.HrmsRequestConstants.END_TIME;
import static jkt.hrms.util.HrmsRequestConstants.FRIDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.FROM_DATE;
import static jkt.hrms.util.HrmsRequestConstants.HR_ATTENDANCE_CARD_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_DATAWISE_ATTENDANCE_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_EMPLOYEE_ATTENDANCE_POPUP;
import static jkt.hrms.util.HrmsRequestConstants.HR_LATE_ATTENDANCE_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.HR_MONTHLY_ATTENDANCE_REPORT_JSP;
import static jkt.hrms.util.HrmsRequestConstants.MONDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.MONTH;
import static jkt.hrms.util.HrmsRequestConstants.MONTHLY_ATTENDANCE_STATUS_JSP;
import static jkt.hrms.util.HrmsRequestConstants.OUT_DATE;
import static jkt.hrms.util.HrmsRequestConstants.REMARK;
import static jkt.hrms.util.HrmsRequestConstants.SATURDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.SEARCH_NAME;
import static jkt.hrms.util.HrmsRequestConstants.SHIFT;
import static jkt.hrms.util.HrmsRequestConstants.SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.SHIFT_CODE_JSP;
import static jkt.hrms.util.HrmsRequestConstants.SHIFT_ID;
import static jkt.hrms.util.HrmsRequestConstants.START_DATE;
import static jkt.hrms.util.HrmsRequestConstants.START_TIME;
import static jkt.hrms.util.HrmsRequestConstants.SUNDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.THURSDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.TIME_IN;
import static jkt.hrms.util.HrmsRequestConstants.TIME_OUT;
import static jkt.hrms.util.HrmsRequestConstants.TO_DATE;
import static jkt.hrms.util.HrmsRequestConstants.TUESDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.VALIDATE;
import static jkt.hrms.util.HrmsRequestConstants.VERIFIED;
import static jkt.hrms.util.HrmsRequestConstants.WEDNESDAY_SHIFT_CODE_ID;
import static jkt.hrms.util.HrmsRequestConstants.YEAR;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.masters.business.HrAbsentRegister;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmpCategory;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.DateNotMatchedException;
import jkt.hms.util.HMSUtil;
import jkt.hrms.attendance.handler.AttendanceHandlerService;
import jkt.hrms.masters.business.HrAttendanceLoader;
import jkt.hrms.masters.business.HrEmployeeShiftDetails;
import jkt.hrms.masters.business.HrMasShift;
import jkt.hrms.masters.business.HrMasShiftCodes;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AttendanceController extends MultiActionController {

	AttendanceHandlerService attendanceHandlerService = null;

	public AttendanceHandlerService getAttendanceHandlerService() {
		return attendanceHandlerService;
	}

	public void setAttendanceHandlerService(
			AttendanceHandlerService attendanceHandlerService) {
		this.attendanceHandlerService = attendanceHandlerService;
	}

	public ModelAndView showEmployeeDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showEmployeeDetails();
		String jsp = EMPLOYEE_SHIFT_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveEmployeeShiftDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrEmployeeShiftDetails hrEmployeeShiftDetails = new HrEmployeeShiftDetails();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrEmployeeShiftDetails.setHospital(masHospital);
		}
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			hrEmployeeShiftDetails.setEmployee(masEmployee);
		}

		int mondayShiftId = 0;
		if (request.getParameter(MONDAY_SHIFT_CODE_ID) != null) {
			mondayShiftId = Integer.parseInt(request
					.getParameter(MONDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(mondayShiftId);
			hrEmployeeShiftDetails.setMondayShift(hrMasShiftCodes);
		}
		int tuesdayShiftId = 0;
		if (request.getParameter(TUESDAY_SHIFT_CODE_ID) != null) {
			tuesdayShiftId = Integer.parseInt(request
					.getParameter(TUESDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(tuesdayShiftId);
			hrEmployeeShiftDetails.setTuesdayShift(hrMasShiftCodes);
		}
		int wednesdayShiftId = 0;
		if (request.getParameter(WEDNESDAY_SHIFT_CODE_ID) != null) {
			wednesdayShiftId = Integer.parseInt(request
					.getParameter(WEDNESDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(wednesdayShiftId);
			hrEmployeeShiftDetails.setWednesdayShift(hrMasShiftCodes);
		}
		int thursdayShiftId = 0;
		if (request.getParameter(THURSDAY_SHIFT_CODE_ID) != null) {
			thursdayShiftId = Integer.parseInt(request
					.getParameter(THURSDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(thursdayShiftId);
			hrEmployeeShiftDetails.setThursdayShift(hrMasShiftCodes);
		}
		int fridayShiftId = 0;
		if (request.getParameter(FRIDAY_SHIFT_CODE_ID) != null) {
			fridayShiftId = Integer.parseInt(request
					.getParameter(FRIDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(fridayShiftId);
			hrEmployeeShiftDetails.setFridayShift(hrMasShiftCodes);
		}
		int saturdayShiftId = 0;
		if (request.getParameter(SATURDAY_SHIFT_CODE_ID) != null) {
			saturdayShiftId = Integer.parseInt(request
					.getParameter(SATURDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(saturdayShiftId);
			hrEmployeeShiftDetails.setSaturdayShift(hrMasShiftCodes);
		}
		int sundayShiftId = 0;
		if (request.getParameter(SUNDAY_SHIFT_CODE_ID) != null) {
			sundayShiftId = Integer.parseInt(request
					.getParameter(SUNDAY_SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(sundayShiftId);
			hrEmployeeShiftDetails.setSundayShift(hrMasShiftCodes);
		}
		Date shiftStartDate = null;
		if (request.getParameter(START_DATE) != null) {
			shiftStartDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(START_DATE));
			hrEmployeeShiftDetails.setShiftStartDate(shiftStartDate);
		}
		Date shiftEndDate = null;
		if (request.getParameter(END_DATE) != null) {
			shiftEndDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(END_DATE));
			hrEmployeeShiftDetails.setShiftEndDate(shiftEndDate);
		}
		String lastchangeBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
			hrEmployeeShiftDetails.setLastChgBy(lastchangeBy);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			hrEmployeeShiftDetails.setLastChgDate(changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			hrEmployeeShiftDetails.setLastChgTime(changedTime);
		}
		hrEmployeeShiftDetails.setStatus("y");

		map = attendanceHandlerService
				.saveEmployeeShiftDetails(hrEmployeeShiftDetails);
		String jsp = EMPLOYEE_SHIFT_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editEmployeeShiftDetail(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeShiftDetailId = 0;
		if (request.getParameter(EMPLOYEE_SHIFT_DETAILS_ID) != null
				&& !(request.getParameter(EMPLOYEE_SHIFT_DETAILS_ID).equals(""))) {
			employeeShiftDetailId = Integer.parseInt(request
					.getParameter(EMPLOYEE_SHIFT_DETAILS_ID));
		}
		map = attendanceHandlerService
				.editEmployeeShiftDetail(employeeShiftDetailId);
		String jsp = EMPLOYEE_SHIFT_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateEmployeeShiftDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int employeeShiftDetailId = 0;

		if (request.getParameter(EMPLOYEE_SHIFT_DETAILS_ID) != null) {
			employeeShiftDetailId = Integer.parseInt(request
					.getParameter(EMPLOYEE_SHIFT_DETAILS_ID));
			parameterMap.put("employeeShiftDetailId", employeeShiftDetailId);
		}
		if (request.getParameter(EMPLOYEE_ID) != null) {
			int employeeId = Integer
					.parseInt(request.getParameter(EMPLOYEE_ID));
			parameterMap.put("employeeId", employeeId);
		}
		int mondayShiftId = 0;
		if (request.getParameter(MONDAY_SHIFT_CODE_ID) != null) {
			mondayShiftId = Integer.parseInt(request
					.getParameter(MONDAY_SHIFT_CODE_ID));
			parameterMap.put("mondayShiftId", mondayShiftId);
		}
		if (request.getParameter(TUESDAY_SHIFT_CODE_ID) != null) {
			int tuesdayShiftId = Integer.parseInt(request
					.getParameter(TUESDAY_SHIFT_CODE_ID));
			parameterMap.put("tuesdayShiftId", tuesdayShiftId);
		}
		if (request.getParameter(WEDNESDAY_SHIFT_CODE_ID) != null) {
			int wednesdayShiftId = Integer.parseInt(request
					.getParameter(WEDNESDAY_SHIFT_CODE_ID));
			parameterMap.put("wednesdayShiftId", wednesdayShiftId);
		}
		if (request.getParameter(THURSDAY_SHIFT_CODE_ID) != null) {
			int thursdayShiftId = Integer.parseInt(request
					.getParameter(THURSDAY_SHIFT_CODE_ID));
			parameterMap.put("thursdayShiftId", thursdayShiftId);
		}
		if (request.getParameter(FRIDAY_SHIFT_CODE_ID) != null) {
			int fridayShiftId = Integer.parseInt(request
					.getParameter(FRIDAY_SHIFT_CODE_ID));
			parameterMap.put("fridayShiftId", fridayShiftId);
		}
		if (request.getParameter(SATURDAY_SHIFT_CODE_ID) != null) {
			int saturdayShiftId = Integer.parseInt(request
					.getParameter(SATURDAY_SHIFT_CODE_ID));
			parameterMap.put("saturdayShiftId", saturdayShiftId);
		}
		if (request.getParameter(SUNDAY_SHIFT_CODE_ID) != null) {
			int sundayShiftId = Integer.parseInt(request
					.getParameter(SUNDAY_SHIFT_CODE_ID));
			parameterMap.put("sundayShiftId", sundayShiftId);
		}
		Date shiftStartDate = null;
		if (request.getParameter(START_DATE) != null) {
			shiftStartDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(START_DATE));
			parameterMap.put("shiftStartDate", shiftStartDate);
		}

		Date shiftEndDate = null;
		if (request.getParameter(END_DATE) != null) {
			shiftEndDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(END_DATE));
			parameterMap.put("shiftEndDate", shiftEndDate);
		}

		if (request.getParameter(CHANGED_BY) != null) {
			String lastchangeBy = request.getParameter(CHANGED_BY);
			parameterMap.put("lastchangeBy", lastchangeBy);

		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			parameterMap.put("changedDate", changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("changedTime", changedTime);
		}

		map = attendanceHandlerService.updateEmployeeShiftDetails(parameterMap);
		String jsp = EMPLOYEE_SHIFT_DETAILS;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showShiftJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		
		
		map = attendanceHandlerService.showShiftJsp(hospitalId);
		String jsp = SHIFT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveShiftDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HrMasShift hrMasShift = new HrMasShift();
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasShift.setDepartment(masDepartment);
		}
		
		int empCatId = 0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY).equals("0"))) {
			empCatId = Integer
					.parseInt(request.getParameter(EMPLOYEE_CATEGORY));
			MasEmpCategory masEmpCategory = new MasEmpCategory();
			masEmpCategory.setId(empCatId);
			hrMasShift.setEmployeeCategory(masEmpCategory);
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasShift.setHospital(masHospital);

		}
		int shiftCodeId = 0;
		if (request.getParameter(SHIFT_CODE_ID) != null
				&& !(request.getParameter(SHIFT_CODE_ID).equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter(SHIFT_CODE_ID));
			HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrMasShift.setShiftCodes(hrMasShiftCodes);
		}
		String shiftStartTime = "";
		if (request.getParameter(START_TIME) != null
				&& !(request.getParameter(START_TIME).equals(""))) {
			shiftStartTime = request.getParameter(START_TIME);
			hrMasShift.setShiftStartTime(shiftStartTime);

		}
		String shiftEndTime = "";
		if (request.getParameter(END_TIME) != null
				&& !(request.getParameter(END_TIME).equals(""))) {
			shiftEndTime = request.getParameter(END_TIME);
			hrMasShift.setShiftEndTime(shiftEndTime);

		}
		if (request.getParameter(CHANGED_BY) != null) {
			Integer users=(Integer)session.getAttribute("userId");
			Users user=new Users(users);
			hrMasShift.setLastChgBy(user);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			hrMasShift.setLastChgDate(changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			hrMasShift.setLastChgTime(changedTime);
		}
		hrMasShift.setStatus("y");
		map = attendanceHandlerService.saveShiftDetails(hrMasShift,hospitalId);

		String jsp = SHIFT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editShiftDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int ShiftId = 0;
		if (request.getParameter(SHIFT_ID) != null
				&& !(request.getParameter(SHIFT_ID).equals(""))) {
			ShiftId = Integer.parseInt(request.getParameter(SHIFT_ID));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		
		map = attendanceHandlerService.editShiftDetails(ShiftId,hospitalId);

		String jsp = SHIFT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateShiftDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		String jsp = SHIFT;
		int shiftId = 0;
		if (request.getParameter(SHIFT_ID) != null
				&& !(request.getParameter(SHIFT_ID).equals(""))) {
			shiftId = Integer.parseInt(request.getParameter(SHIFT_ID));
			parameterMap.put("shiftId", shiftId);
		}

		int shiftCodeId = 0;
		if (request.getParameter(SHIFT_CODE_ID) != null
				&& !(request.getParameter(SHIFT_CODE_ID).equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter(SHIFT_CODE_ID));
			parameterMap.put("shiftCodeId", shiftCodeId);
		}
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			parameterMap.put("departmentId", departmentId);
		}
		
		
		int empCatId = 0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY).equals("0"))) {
			empCatId = Integer
					.parseInt(request.getParameter(EMPLOYEE_CATEGORY));
			parameterMap.put("empCatId", empCatId);
		}
		String shiftStartTime = "";
		if (request.getParameter(START_TIME) != null
				&& !(request.getParameter(START_TIME).equals(""))) {
			shiftStartTime = request.getParameter(START_TIME);
			parameterMap.put("shiftStartTime", shiftStartTime);

		}
		String shiftEndTime = "";
		if (request.getParameter(END_TIME) != null
				&& !(request.getParameter(END_TIME).equals(""))) {
			shiftEndTime = request.getParameter(END_TIME);
			parameterMap.put("shiftEndTime", shiftEndTime);
		}

		if (request.getParameter(CHANGED_BY) != null) {
			String lastchangeBy = request.getParameter(CHANGED_BY);
			parameterMap.put("lastchangeBy", lastchangeBy);

		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			parameterMap.put("changedDate", changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			parameterMap.put("changedTime", changedTime);
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer)session.getAttribute("hospitalId");
		parameterMap.put("hospitalId", hospitalId);
		map = attendanceHandlerService.updateShiftDetails(parameterMap);
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAttendanceLoaderJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = ATTENDANCE_LOADER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView importAttendanceFile(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		MultipartFormDataRequest mrequest = null;

		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("recruitmentFile.properties");
		Properties properties = new Properties();
		properties.load(resourcePath.openStream());

		// String uploadURL = properties.getProperty("uploadAttendanceSheet");
		String uploadURL = getServletContext().getRealPath(
				"/uploads/attendence/");
		String whiteList = "*.xls,*xlsx";
		Long fileSizeLimit = 5242880L;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String attendanceDate = "";
		if (mrequest.getParameter(ATTENDANCE_DATE) != null) {
			if (!(mrequest.getParameter(ATTENDANCE_DATE).equals(""))) {
				attendanceDate = mrequest.getParameter(ATTENDANCE_DATE);
			}
		}
		Date attendanceDateObj = HMSUtil
				.convertStringTypeDateToDateType(attendanceDate);

		String splitDate[] = attendanceDate.split("/");
		String todayAttendanceDate = splitDate[0] + "" + splitDate[1] + ""
				+ splitDate[2];
		String fileNameToBeAssigned = todayAttendanceDate;// HMSUtil.getDateFormat(new
		// Date(),"ddMMyyyy").toString();
		// upload
		List fileUploadedList = null;
		fileUploadedList = HMSUtil.uploadAttendanceFile(mrequest, uploadURL,
				whiteList, fileSizeLimit, fileNameToBeAssigned);
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}

		generalMap.put("uploadURL", uploadURL);
		generalMap.put("attendanceDate", attendanceDate);
		File file = new File(getServletContext().getRealPath(
				"uploads/attendence/" + fileNameToBeAssigned + ".xls"));
		generalMap.put("file", file);
		String message = "";
		try {
			map = attendanceHandlerService.importAttendanceFile(generalMap);
		} catch (DateNotMatchedException e) {
			message = e.getMessage();
			e.printStackTrace();
		}
		String jsp = ATTENDANCE_LOADER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView processDataInAttendanceFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List employeeAttendanceList = new ArrayList();
		String lastchangeBy = "";
		HttpSession session=request.getSession();
		Integer users=(Integer)session.getAttribute("userId");
		Users user=new Users(users);
		
		if (request.getParameter(CHANGED_BY) != null) {
			lastchangeBy = request.getParameter(CHANGED_BY);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		int counter = 0;
		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}

		for (int j = 0; j < counter; j++) {

			String cardNo = "";
			if (request.getParameter(CARD_NO + j) != null) {
				cardNo = request.getParameter(CARD_NO + j);
			}
			String employeeName = "";
			if (request.getParameter(EMPLOYEE_NAME + j) != null) {
				employeeName = request.getParameter(EMPLOYEE_NAME + j);
			}

			Date displayDate = null;

			if (request.getParameter(DISPLAY_DATE + j) != null
					&& !(request.getParameter(DISPLAY_DATE + j).equals(""))) {
				displayDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(DISPLAY_DATE + j));
			}
			String timeIn = "";
			if (request.getParameter(TIME_IN + j) != null) {
				timeIn = request.getParameter(TIME_IN + j);
			}
			String timeOut = "";
			if (request.getParameter(TIME_OUT + j) != null) {
				timeOut = request.getParameter(TIME_OUT + j);
			}
			String verified = "";
			if (request.getParameter(VERIFIED + j) != null) {
				verified = request.getParameter(VERIFIED + j);
			}
			String validate = "";
			if (request.getParameter(VALIDATE + j) != null) {
				validate = request.getParameter(VALIDATE + j);
			}
			String remark = "";
			if (request.getParameter(REMARK + j) != null) {
				remark = request.getParameter(REMARK + j);
			}
			HrAttendanceLoader hrAttendanceLoader = new HrAttendanceLoader();
			// MasEmployee masEmployee = new MasEmployee();
			// masEmployee.setId(employeeId);
			hrAttendanceLoader.setEmployeeName(employeeName);
			hrAttendanceLoader.setCardNo(cardNo);
			hrAttendanceLoader.setDate(displayDate);
			hrAttendanceLoader.setOutDate(displayDate);
			hrAttendanceLoader.setTimeIn(timeIn);
			hrAttendanceLoader.setTimeOut(timeOut);
			hrAttendanceLoader.setVerified(verified);
			hrAttendanceLoader.setValidate(validate);
			hrAttendanceLoader.setRemark(remark);
			hrAttendanceLoader.setLastChgBy(user);
			hrAttendanceLoader.setLastChgDate(changedDate);
			hrAttendanceLoader.setLastChgTime(changedTime);
			employeeAttendanceList.add(hrAttendanceLoader);
		}
		generalMap.put("employeeAttendanceList", employeeAttendanceList);
		map = attendanceHandlerService.processDataInAttendanceFile(generalMap);
		String jsp = ATTENDANCE_LOADER;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showShiftCodeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showShiftCodeJsp();
		String jsp = SHIFT_CODE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveShiftCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String shiftCode = "";
		if (request.getParameter(CODE) != null) {
			shiftCode = request.getParameter(CODE);
		}
		String shiftName = "";
		if (request.getParameter(SEARCH_NAME) != null) {
			shiftName = request.getParameter(SEARCH_NAME);
		}
		String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}
		Date currentDate = null;
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
		HttpSession session = request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		Users user=new Users();
		user.setId(userId);
		
		HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
		hrMasShiftCodes.setShiftCode(shiftCode);
		hrMasShiftCodes.setShiftName(shiftName);
		hrMasShiftCodes.setLastChgBy(user);
		hrMasShiftCodes.setLastChgDate(currentDate);
		hrMasShiftCodes.setLastChgTime(currentTime);
		hrMasShiftCodes.setStatus("y");
		map = attendanceHandlerService.saveShiftCode(hrMasShiftCodes);
		String jsp = SHIFT_CODE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView editShiftCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int shiftCodeId = 0;
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		String shiftCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			shiftCode = request.getParameter(CODE);
		}
		String shiftName = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			shiftName = request.getParameter(SEARCH_NAME);
		}
		/*String changedBy = "";
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			changedBy = request.getParameter(CHANGED_BY);
		}*/
		Date currentDate = null;
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
		HttpSession session = request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		generalMap.put("shiftCodeId", shiftCodeId);
		generalMap.put("shiftCode", shiftCode);
		generalMap.put("shiftName", shiftName);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);

		map = attendanceHandlerService.editShiftCode(generalMap);
		String jsp = SHIFT_CODE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView deleteShiftCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int shiftCodeId = 0;
		String message = "";
		String flag = "";
		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			generalMap.put("flag", flag);
		}
		if (request.getParameter(COMMON_ID) != null
				&& !(request.getParameter(COMMON_ID).equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter(COMMON_ID));
		}
		
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
		
		HttpSession session = request.getSession();
		Integer userId=(Integer)session.getAttribute("userId");
		
		generalMap.put("shiftCodeId", shiftCodeId);
		generalMap.put("userId", userId);
		generalMap.put("currentDate", currentDate);
		generalMap.put("currentTime", currentTime);
		map = attendanceHandlerService.deleteShiftCode(generalMap);
		String jsp = SHIFT_CODE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchShiftCode(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String shiftCode = "";
		if (request.getParameter(CODE) != null
				&& !(request.getParameter(CODE).equals(""))) {
			shiftCode = request.getParameter(CODE);
		}
		String shiftName = "";
		if (request.getParameter(SEARCH_NAME) != null
				&& !(request.getParameter(SEARCH_NAME).equals(""))) {
			shiftName = request.getParameter(SEARCH_NAME);
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
			shiftCode = searchField;
			shiftName = null;

		} else {
			shiftCode = null;
			shiftName = searchField;
		}
		map = attendanceHandlerService.searchShiftCode(shiftCode, shiftName);
		String jsp = SHIFT_CODE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmployeeAttendanceJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Users user = null;
		int new_employee_id = 0;
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		Date date = null;
		
		date = HMSUtil.convertStringTypeDateToDateType(HMSUtil.convertDateToStringTypeDate(new Date()));
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("date", date);
		
		
		if(session.getAttribute(USERS)!=null)
		{
			user = (Users)session.getAttribute(USERS);
			if(user.getLoginName().equalsIgnoreCase("admin")){
				map = attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap);
			}
			else
			{
				new_employee_id = user.getEmployee().getId();
				//map = attendanceHandlerService.showEmployeeAttendanceJsp(new_employee_id);
				map = attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap);
			}
		}
		//map = attendanceHandlerService.showEmployeeAttendanceJsp();
		//String jsp = EMPLOYEE_ATTENDANCE_JSP;
		String jsp = "employeeAttendance1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveEmployeeAttenadance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int employeeId = 0;
		int new_employee_id = 0;
		Users user = null;
		HttpSession session = request.getSession();
		
		Box box = null;
		
		
		box = HMSUtil.getBox(request);
		Vector empidList = box.getVector("empId");
		Vector attendnaceList = box.getVector("att_Status");
		Vector remarkList = box.getVector("remarks");	
		//System.out.println("saveEmployeeAttenadance>>>"+empidList.size());
		
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");

		}

		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		Date attendanceDate = null;
		if (request.getParameter(ATTENDANCE_DATE) != null
				&& !(request.getParameter(ATTENDANCE_DATE).equals(""))) {
			attendanceDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(ATTENDANCE_DATE));
		}
		String timeIn = "";
		if (request.getParameter(TIME_IN) != null) {
			timeIn = request.getParameter(TIME_IN);
		}
		String timeOut = "";
		if (request.getParameter(TIME_OUT) != null) {
			timeOut = request.getParameter(TIME_OUT);
		}
		/*String lastChgBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}*/
		
		Users lastChgBy = null;
		if(session.getAttribute(USERS)!=null)
		{
			lastChgBy = (Users)session.getAttribute(USERS);
		}
		
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		String remark = "";
		if (request.getParameter(REMARK) != null) {
			remark = request.getParameter(REMARK);
		}
		String attendanceMark = "";
		if (request.getParameter(ATTENDANCE_MARK) != null) {
			attendanceMark = request.getParameter(ATTENDANCE_MARK);
		}

		Date outDate = null;
		if (request.getParameter(OUT_DATE) != null
				&& !(request.getParameter(OUT_DATE).equals(""))) {
			outDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(OUT_DATE));
		}
		int shiftCodeId = 0;
		/*if (request.getParameter(SHIFT_CODE_ID)!= null) {
			shiftCodeId = Integer.parseInt(request.getParameter(SHIFT_CODE_ID));
		 }*/
		
		if (request.getParameter("shift")!= null) {
			shiftCodeId = Integer.parseInt(request.getParameter("shift"));
		 }
		for(int c=0 ; c<empidList.size();c++){
				if((""+attendnaceList.get(c)).equalsIgnoreCase("P")){
		HrAttendanceLoader hrAttendanceLoader = new HrAttendanceLoader();
		MasEmployee masEmployee = new MasEmployee();
		//masEmployee.setId(employeeId);
		masEmployee.setId(Integer.parseInt(""+empidList.get(c)));
		//masEmployee.seti
		hrAttendanceLoader.setEmployee(masEmployee);
		
		HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
		hrMasShiftCodes.setId(shiftCodeId);
		hrAttendanceLoader.setShiftCodes(hrMasShiftCodes);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrAttendanceLoader.setHospital(masHospital);
		
		hrAttendanceLoader.setDate(attendanceDate);
		hrAttendanceLoader.setTimeIn(timeIn);
		hrAttendanceLoader.setTimeOut(timeOut);
		hrAttendanceLoader.setVerified("n");
		hrAttendanceLoader.setValidate("n");
		hrAttendanceLoader.setLastChgBy(lastChgBy);
		hrAttendanceLoader.setLastChgDate(changedDate);
		hrAttendanceLoader.setLastChgTime(changedTime);
		hrAttendanceLoader.setFlag("m");
		hrAttendanceLoader.setStatus("y");
		
		
		//hrAttendanceLoader.setRemark(remark);
		hrAttendanceLoader.setRemark(""+remarkList.get(c));
		
		hrAttendanceLoader.setAuthorized("no");
		hrAttendanceLoader.setProcessed("no");
		
		//hrAttendanceLoader.setAttendanceMark(attendanceMark);
		hrAttendanceLoader.setAttendanceMark(""+attendnaceList.get(c));
		
		hrAttendanceLoader.setOutDate(outDate);

		map = attendanceHandlerService.saveEmployeeAttenadance(hrAttendanceLoader);
		
	}else if((""+attendnaceList.get(c)).equalsIgnoreCase("A")){
		HrAbsentRegister hrAbsentRegister = new HrAbsentRegister();
		
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(Integer.parseInt(""+empidList.get(c)));
		hrAbsentRegister.setEmployee(masEmployee);
		
		hrAbsentRegister.setAbsentDate(attendanceDate);
		
		HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
		hrMasShiftCodes.setId(shiftCodeId);
		hrAbsentRegister.setShiftCodes(hrMasShiftCodes);
		
		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		hrAbsentRegister.setHospital(masHospital);
		
		hrAbsentRegister.setLastChgBy(lastChgBy);
		hrAbsentRegister.setLastChgDate(changedDate);
		hrAbsentRegister.setLastChgTime(changedTime);
		hrAbsentRegister.setStatus("y");
		
		 attendanceHandlerService.saveEmployeeAbsent(hrAbsentRegister);
		
	}
				
		
		
		}
	
		Date date = null;
		date = HMSUtil.convertStringTypeDateToDateType(HMSUtil.convertDateToStringTypeDate(new Date()));
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("date", date);
		if(session.getAttribute(USERS)!=null)
		{
			user = (Users)session.getAttribute(USERS);
			if(user.getLoginName().equalsIgnoreCase("admin")){
				map2 = attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap);
			}
			else
			{
				new_employee_id = user.getEmployee().getId();
				map2 = attendanceHandlerService.showEmployeeAttendanceJsp(new_employee_id);
			}
		}


		map.putAll(map2);
		/*String jsp = EMPLOYEE_ATTENDANCE_JSP;*/
		String jsp = "employeeAttendance1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	
	
	public ModelAndView updateEmployeeAttenadanceNew(HttpServletRequest request,HttpServletResponse response) {
			
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		int employeeId = 0;
		int new_employee_id = 0;
		Users user = null;
		HttpSession session = request.getSession();
		
		Box box = null;
		
		box = HMSUtil.getBox(request);
		Vector attendanceIdList = box.getVector("attendanceId");
		Vector empidList = box.getVector("empId1");
		Vector attendnaceStatusList = box.getVector("att_Status1");
		Vector remarkList = box.getVector("remarks1");	
		
		
		Vector absentIdList = box.getVector("absentId");
		Vector empid2List = box.getVector("empId2");
		Vector attendnaceStatus2List = box.getVector("att_Status2");
		Vector remark2List = box.getVector("remarks2");	

		
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");

		}

		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		Date attendanceDate = null;
		if (request.getParameter(ATTENDANCE_DATE) != null
				&& !(request.getParameter(ATTENDANCE_DATE).equals(""))) {
			attendanceDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(ATTENDANCE_DATE));
		}
		String timeIn = "";
		if (request.getParameter(TIME_IN) != null) {
			timeIn = request.getParameter(TIME_IN);
		}
		String timeOut = "";
		if (request.getParameter(TIME_OUT) != null) {
			timeOut = request.getParameter(TIME_OUT);
		}
	
		
		Users lastChgBy = null;
		if(session.getAttribute(USERS)!=null)
		{
			lastChgBy = (Users)session.getAttribute(USERS);
		}
		
		//Date changedDate = null;
		String changedDate="";
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			/*changedDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(CHANGED_DATE));*/
					
			changedDate = request.getParameter(CHANGED_DATE);
					
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		String remark = "";
		if (request.getParameter(REMARK) != null) {
			remark = request.getParameter(REMARK);
		}
		String attendanceMark = "";
		if (request.getParameter(ATTENDANCE_MARK) != null) {
			attendanceMark = request.getParameter(ATTENDANCE_MARK);
		}

		Date outDate = null;
		if (request.getParameter(OUT_DATE) != null
				&& !(request.getParameter(OUT_DATE).equals(""))) {
			outDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(OUT_DATE));
		}
		int shiftCodeId = 0;
		
		
		if (request.getParameter("shift")!= null) {
			shiftCodeId = Integer.parseInt(request.getParameter("shift"));
		 }
		parameterMap.put("attendanceIdList", attendanceIdList);
		parameterMap.put("empidList", empidList);
		parameterMap.put("attendnaceStatusList", attendnaceStatusList);
		parameterMap.put("remarkList", remarkList);
		parameterMap.put("absentIdList", absentIdList);
		parameterMap.put("empid2List", empid2List);
		parameterMap.put("attendnaceStatus2List", attendnaceStatus2List);
		parameterMap.put("remark2List", remark2List);
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("changedTime", changedTime);
		parameterMap.put("changedDate", changedDate);
		parameterMap.put("lastChgBy", lastChgBy);
		
		
		
		System.out.println(attendnaceStatusList.size()+" in cont>>."+attendanceIdList.size());
		map = attendanceHandlerService.updateEmployeeAttenadanceNew(parameterMap);
		
	
		Date date = null;
		date = HMSUtil.convertStringTypeDateToDateType(HMSUtil.convertDateToStringTypeDate(new Date()));
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("date", date);
		if(session.getAttribute(USERS)!=null)
		{
			user = (Users)session.getAttribute(USERS);
			if(user.getLoginName().equalsIgnoreCase("admin")){
				map2 = attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap);
			}
			else
			{
				new_employee_id = user.getEmployee().getId();
				map2 = attendanceHandlerService.showEmployeeAttendanceJsp(new_employee_id);
			}
		}


		map.putAll(map2);
		String jsp = "employeeAttendance1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView editEmployeeAttendance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		Users user = null;
		int new_employee_id = 0;
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");

		}
		int employeeAttendanceId = 0;
		if (request.getParameter(EMPLOYEE_ATTENDANCE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ATTENDANCE_ID).equals(""))) {
			employeeAttendanceId = Integer.parseInt(request
					.getParameter(EMPLOYEE_ATTENDANCE_ID));
		}
		map = attendanceHandlerService
				.editEmployeeAttendance(employeeAttendanceId);
		Date date = null;
		date = HMSUtil.convertStringTypeDateToDateType(HMSUtil.convertDateToStringTypeDate(new Date()));
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("date", date);
		if(session.getAttribute(USERS)!=null)
		{
			user = (Users)session.getAttribute(USERS);
			if(user.getLoginName().equalsIgnoreCase("admin")){
				map2 = attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap);
			}
			else
			{
				new_employee_id = user.getEmployee().getId();
				map2 = attendanceHandlerService.showEmployeeAttendanceJsp(new_employee_id);
			}
		}
		map.putAll(map2);
		String jsp = EMPLOYEE_ATTENDANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateEmployeeAttendance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int employeeAttendanceId = 0;
		if (request.getParameter(EMPLOYEE_ATTENDANCE_ID) != null
				&& !(request.getParameter(EMPLOYEE_ATTENDANCE_ID).equals(""))) {
			employeeAttendanceId = Integer.parseInt(request
					.getParameter(EMPLOYEE_ATTENDANCE_ID));
			generalMap.put("employeeAttendanceId", employeeAttendanceId);
		}
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		Date attendanceDate = null;
		if (request.getParameter(ATTENDANCE_DATE) != null
				&& !(request.getParameter(ATTENDANCE_DATE).equals(""))) {
			attendanceDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(ATTENDANCE_DATE));
			generalMap.put("attendanceDate", attendanceDate);
		}
		String timeIn = "";
		if (request.getParameter(TIME_IN) != null) {
			timeIn = request.getParameter(TIME_IN);
			generalMap.put("timeIn", timeIn);
		}
		String timeOut = "";
		if (request.getParameter(TIME_OUT) != null) {
			timeOut = request.getParameter(TIME_OUT);
			generalMap.put("timeOut", timeOut);
		}
		String lastChgBy = "";
		if (request.getParameter(CHANGED_BY) != null) {
			lastChgBy = request.getParameter(CHANGED_BY);
			generalMap.put("lastChgBy", lastChgBy);
		}
		Date changedDate = null;
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			generalMap.put("changedDate", changedDate);
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null) {
			changedTime = request.getParameter(CHANGED_TIME);
			generalMap.put("changedTime", changedTime);
		}
		String remark = "";
		if (request.getParameter(REMARK) != null) {
			remark = request.getParameter(REMARK);
			generalMap.put("remark", remark);
		}
		String attendanceMark = "";
		if (request.getParameter(ATTENDANCE_MARK) != null) {
			attendanceMark = request.getParameter(ATTENDANCE_MARK);
			generalMap.put("attendanceMark", attendanceMark);
		}

		Date outDate = null;
		if (request.getParameter(OUT_DATE) != null
				&& !(request.getParameter(OUT_DATE).equals(""))) {
			outDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(OUT_DATE));
			generalMap.put("outDate", outDate);
		}
		int shiftCodeId = 0;
		if (request.getParameter(SHIFT_CODE_ID) != null) {
			shiftCodeId = Integer.parseInt(request.getParameter(SHIFT_CODE_ID));
			generalMap.put("shiftCodeId", shiftCodeId);
		}
		map = attendanceHandlerService.updateEmployeeAttendance(generalMap);
		String jsp = EMPLOYEE_ATTENDANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView displayEmployeeAttenadance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int employeeId = 0;
		if (request.getParameter("employeeId") != null) {
			employeeId = Integer.parseInt(request.getParameter("employeeId"));
		}

		Date fromDate = null;
		if (request.getParameter("fromDateId") != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("fromDateId"));
		}
		Date toDate = null;
		if (request.getParameter("toDateId") != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("toDateId"));
		}

		generalMap.put("employeeId", employeeId);
		generalMap.put("fromDate", fromDate);
		generalMap.put("toDate", toDate);
		map = attendanceHandlerService.displayEmployeeAttenadance(generalMap);
		String jsp = HR_EMPLOYEE_ATTENDANCE_POPUP;

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDatawiseAttendanceReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		map = attendanceHandlerService.showDatawiseAttendanceReportJsp();
		String jsp = HR_DATAWISE_ATTENDANCE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printDatawiseAttendanceReport(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		Date toDate = null;
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}

		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = formatterOut.format(formatterIn.parse(request
				.getParameter(FROM_DATE)));

		SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = formatterOut.format(formatterIn2.parse(request
				.getParameter(TO_DATE)));
		detailsMap = attendanceHandlerService.getConnectionForReport();
		parameters.put("emp_id", employeeId);
		parameters.put("fromDate", java.sql.Date.valueOf(date4MySQL));
		parameters.put("toDate", java.sql.Date.valueOf(date4MySQL2));
		if ((Connection) detailsMap.get("conn") != null) {
		}
		if (employeeId != 0) {
			HMSUtil.generateReport("employee_datawise_attendance", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else {
			HMSUtil.generateReport("employee_datawise_attendancefor_all",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	public ModelAndView showLateAttendanceReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showLateAttendanceReportJsp();
		String jsp = HR_LATE_ATTENDANCE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printLateAttendanceReport(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		Date fromDate = null;
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		Date toDate = null;
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String inTimeFrom = "";
		if (request.getParameter(TIME_IN) != null) {
			inTimeFrom = request.getParameter(TIME_IN);
		}
		String inTimeTo = "";
		if (request.getParameter(TIME_OUT) != null) {
			inTimeTo = request.getParameter(TIME_OUT);
		}
		/*
		 * SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		 * SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		 * String
		 * date4MySQL=formatterOut.format(formatterIn.parse(request.getParameter
		 * (FROM_DATE)));
		 *
		 * SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		 * SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		 * String
		 * date4MySQL2=formatterOut.format(formatterIn2.parse(request.getParameter
		 * (TO_DATE)));
		 */

		detailsMap = attendanceHandlerService.getConnectionForReport();
		parameters.put("emp_id", employeeId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("inTimeFrom", inTimeFrom);
		parameters.put("inTimeTo", inTimeTo);
		if (employeeId != 0) {
			HMSUtil.generateReport("employee_late_attendence", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else {
			HMSUtil.generateReport("employee_late_attendence_for_all",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	public ModelAndView showAttendanceCardReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showAttendanceCardReportJsp();
		String jsp = HR_ATTENDANCE_CARD_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printEmployeeAttendanceCardReport(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_ID) != null
				&& !request.getParameter(EMPLOYEE_ID).equals("")) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
		}
		int departmentId = 0;
		if (request.getParameter(DEPARTMENT_ID) != null
				&& !request.getParameter(DEPARTMENT_ID).equals("")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
		}
		Date fromDate = new Date();
		if (request.getParameter(FROM_DATE) != null) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		Date toDate = new Date();
		if (request.getParameter(TO_DATE) != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL = formatterOut.format(formatterIn.parse(request
				.getParameter(FROM_DATE)));

		// code for getting offdays
		Date startDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(FROM_DATE));
		Date endDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(TO_DATE));
		int offDays = calculateNoOfOffDays(startDate, endDate);
		float offDays1 = new Float(offDays);
		// code for getting legal holidays
		int legalHolidays = attendanceHandlerService.getNoOfLegalHolidays(
				startDate, endDate);
		float legalHolidays1 = new Float(legalHolidays);
		// code for getting no working days
		Calendar startCal, endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		int totalDays = (startCal.get(Calendar.DAY_OF_YEAR) - endCal
				.get(Calendar.DAY_OF_YEAR));
		double totalDays1 = new Double(totalDays);
		SimpleDateFormat formatterIn2 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatterOut2 = new SimpleDateFormat("yyyy-MM-dd");
		String date4MySQL2 = formatterOut.format(formatterIn2.parse(request
				.getParameter(TO_DATE)));
		parameters.put("dept_id", departmentId);
		parameters.put("emp_id", employeeId);
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("offDays", offDays1);
		parameters.put("legalHolidays", legalHolidays1);
		parameters.put("totalDays", totalDays1);
		detailsMap = attendanceHandlerService.getConnectionForReport();
		if (employeeId != 0) {
			HMSUtil.generateReport("employee_attendance_card_for_employee",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (employeeId == 0 && departmentId != 0) {
			HMSUtil.generateReport("employee_attendance_card_for_department",
					parameters, (Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (employeeId == 0 && departmentId == 0) {
			HMSUtil.generateReport(
					"employee_attendance_card_for_all_department", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}

		return null;
	}

	public ModelAndView getEmployeeList(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		int departmentId = 0;
		if (request.getParameter("departmentId") != null
				&& !request.getParameter("departmentId").equals("")) {

			departmentId = Integer.parseInt(request
					.getParameter("departmentId"));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.getEmployeeList(departmentId);
		String jsp = "responseForEmployeeList";

		return new ModelAndView(jsp, "map", map);

	}

	public int calculateNoOfOffDays(Date startDate, Date endDate) {
		Calendar startCal, endCal;
		startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		endCal = Calendar.getInstance();
		endCal.setTime(endDate);
		int offDays = 0;
		int workDays = 0;
		List<Integer> weekendList = new ArrayList<Integer>();
		weekendList = attendanceHandlerService.getWeekands();

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}
		// Just in case the dates were transposed this prevents infinite loop
		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(endDate);
			endCal.setTime(startDate);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);
			if (weekendList.size() == 2) {
				if (startCal.get(Calendar.DAY_OF_WEEK) == weekendList.get(0)
						|| startCal.get(Calendar.DAY_OF_WEEK) == weekendList
								.get(1)) {
					++offDays;
				}
			} else {
				if (startCal.get(Calendar.DAY_OF_WEEK) == weekendList.get(0)) {
					++offDays;
				}
			}
		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
		return offDays;
	}

	public ModelAndView showMonthlyAttendanceReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showMonthlyAttendanceReportJsp();
		String jsp = HR_MONTHLY_ATTENDANCE_REPORT_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMonthlyAttendanceReport(
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException {

		ServletContext context = request.getSession().getServletContext();
		Map<String, Object> parameters = new HashMap<String, Object>();
		int empId = 0;
		int month = 0;
		int year = 0;
		int departmentId = 0;
		String repName = "";

		try {

			if (request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
			}

			if (request.getParameter(EMPLOYEE_ID) != null) {
				empId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			}

			if (request.getParameter(MONTH) != null) {
				month = Integer.parseInt(request.getParameter(MONTH));
			}

			if ((request.getParameter(YEAR) != null)
					&& !(request.getParameter(YEAR).equals("0"))) {
				year = Integer.parseInt(request.getParameter(YEAR));
			}

			parameters.put("month", month);
			parameters.put("year", year);
			parameters.put("departmentId", departmentId);
			if ((request.getParameter(EMPLOYEE_ID) != null)
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				parameters.put("empId", empId);
				repName = "monthly_attendance_employee";
			} else {
				repName = "monthly_attendance";
			}

			Map<String, Object> connectionMap = attendanceHandlerService
					.getConnectionForReport();

			HMSUtil.generateReport(repName, parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ModelAndView showMonthlyAttendanceStatusReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showMonthlyAttendanceStatusReportJsp();
		String jsp = MONTHLY_ATTENDANCE_STATUS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printMonthlyAttendanceStatusReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		String qry = "";
		int departmentId = 0;
		if (!request.getParameter(DEPARTMENT_ID).equals("")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			qry += " where final.department_id = " + departmentId + "";
		}
		String attendenceDate = "";
		if (request.getParameter(FROM_DATE) != null) {
			attendenceDate = request.getParameter(FROM_DATE);
		}
		String splitDate[] = attendenceDate.split("/");
		attendenceDate = splitDate[0] + "" + splitDate[1] + "" + splitDate[2];
		int attendenceDate1 = Integer.parseInt(attendenceDate.substring(0, 2));
		int attendenceMonth = Integer.parseInt(attendenceDate.substring(2, 4));
		int attendenceYear = Integer.parseInt(attendenceDate.substring(4, 8));
		int DateStart = 01;
		String attDate = DateStart + "/" + attendenceMonth + "/"
				+ attendenceYear;

		detailsMap = attendanceHandlerService.getConnectionForReport();
		parameters.put("departmentId", qry);
		parameters.put("month", attendenceMonth);
		parameters.put("year", attendenceYear);
		parameters.put("DateStart",
				HMSUtil.convertStringTypeDateToDateType(attDate));

		if (attendenceMonth == 1 || attendenceMonth == 3
				|| attendenceMonth == 5 || attendenceMonth == 7
				|| attendenceMonth == 8 || attendenceMonth == 10
				|| attendenceMonth == 12) {
			HMSUtil.generateReport("MonthlyEmployeeStatus31", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (attendenceMonth == 4 || attendenceMonth == 6
				|| attendenceMonth == 9 || attendenceMonth == 11) {
			HMSUtil.generateReport("MonthlyEmployeeStatus30", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} else if (attendenceMonth == 2) {
			HMSUtil.generateReport("MonthlyEmployeeStatus28", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		}
		return null;
	}

	public ModelAndView showAttendanceVerifyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int dept = 0;
		int shift =0;
		int designation=0;
		
		
		Date date = null;
		if(request.getParameter("attendanceDate") != null)
		 date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("attendanceDate"));
		else
			 date = HMSUtil.convertStringTypeDateToDateType(HMSUtil.convertDateToStringTypeDate(new Date()));
				
		String message = "";
		if (date == null) {
			message = "no record found";
		}
		
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}
		
		if (request.getParameter("dept") != null && !(request.getParameter("dept").equals(""))) {
			dept = Integer.parseInt(""+request.getParameter("dept"));
	
		}
		if (request.getParameter("shift") != null && !(request.getParameter("shift").equals(""))) {
			shift = Integer.parseInt(""+request.getParameter("shift"));
	
		}
		if (request.getParameter("designation") != null && !(request.getParameter("designation").equals(""))) {
			designation = Integer.parseInt(""+request.getParameter("designation"));
	
		}
		//System.out.println(designation+"   "+dept);
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("dept", dept);	
		parameterMap.put("shift", shift);
		parameterMap.put("designation", designation);
		parameterMap.put("date", date);

		// date = HMSUtil.convertStringTypeDateToDateType("23/01/2009");
		//map = attendanceHandlerService.showAttendanceVerifyJsp(date);
		map = attendanceHandlerService.showAttendanceVerifyJsp(parameterMap);
		map.put("messgae", message);
		//String jsp = "attendanceVerifiy";
		String jsp = "attendanceVerifiy1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveAttendanceVerify(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List hrAttendanceVerifyList = new ArrayList();
		int count = 0;

		if ((request.getParameter("count") != null)) {
			count = Integer.parseInt(request.getParameter("count"));
		}
		System.out.println("count>>>"+count);
		for (int j = 1; j <= count; j++) {
			String timeIn = "";
			String timeOut = "";
			int id = 0;
			System.out.println(j+"count loop>>>"+request.getParameter("validate"+j));
			if (request.getParameter("validate"+j)!= null && !(request.getParameter("validate"+j).equals(""))) {
				/*travelRequestIdList .add(Integer.parseInt(request.getParameter(validate+j)));*/
			
			
			if (request.getParameter("id" + j) != null) {
				id = Integer.parseInt(request.getParameter("id" + j));
			}
			if (request.getParameter(TIME_IN + j) != null) {
				timeIn = request.getParameter(TIME_IN + j);
			}

			if (request.getParameter(TIME_OUT + j) != null) {
				timeOut = request.getParameter(TIME_OUT + j);
			}
			String verified = "yes";
			String validate = "yes";

			HrAttendanceLoader hrAttendanceLoader = new HrAttendanceLoader();
			hrAttendanceLoader.setId(id);
			hrAttendanceLoader.setTimeIn(timeIn);
			hrAttendanceLoader.setTimeOut(timeOut);
			hrAttendanceLoader.setValidate("yes");
			hrAttendanceLoader.setVerified("yes");
			hrAttendanceVerifyList.add(hrAttendanceLoader);
		}
		}
		System.out.println("hrAttendanceVerifyList>>>"+hrAttendanceVerifyList.size());
		// controler--"+hrAttendanceVerifyList.size());
		// map = attendanceHandlerService.showAttendanceVerifyJsp(date);
		generalMap.put("hrAttendanceVerifyList", hrAttendanceVerifyList);
		map = attendanceHandlerService.saveAttendanceVerify(generalMap);

		String jsp = "attendanceVerifiy1";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showManualEmployeeAttendanceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = attendanceHandlerService.showManualEmployeeAttendanceJsp();
		String jsp = "manualEmployeeAttendance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveManualEmployeeAttenadance(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List attendanceIdList = new ArrayList();
		List attendanceDateList = new ArrayList();
		List outDateList = new ArrayList();
		List timeInList = new ArrayList();
		List timeOutList = new ArrayList();
		int count = 0;

		if ((request.getParameter("counter") != null)) {
			count = Integer.parseInt(request.getParameter("counter"));
		}
		for (int j = 0; j < count; j++) {
			if (request.getParameter(EMPLOYEE_ATTENDANCE_ID + j) != null
					&& !request.getParameter(EMPLOYEE_ATTENDANCE_ID + j)
							.equals("")) {
				attendanceIdList.add(Integer.parseInt(request
						.getParameter(EMPLOYEE_ATTENDANCE_ID + j)));
			} else {
				attendanceIdList.add("");
			}
			if (request.getParameter(ATTENDANCE_DATE + j) != null
					&& !request.getParameter(ATTENDANCE_DATE + j).equals("")) {
				attendanceDateList.add(request
						.getParameter(ATTENDANCE_DATE + j));
			} else {
				attendanceDateList.add("");
			}
			if (request.getParameter(OUT_DATE + j) != null
					&& !request.getParameter(OUT_DATE + j).equals("")) {
				outDateList.add(request.getParameter(OUT_DATE + j));
			} else {
				outDateList.add("");
			}
			if (request.getParameter(TIME_IN + j) != null
					&& !request.getParameter(TIME_IN + j).equals("")) {
				timeInList.add(request.getParameter(TIME_IN + j));
			} else {
				timeInList.add("");
			}
			if (request.getParameter(TIME_OUT + j) != null
					&& !request.getParameter(TIME_OUT + j).equals("")) {
				timeOutList.add(request.getParameter(TIME_OUT + j));
			} else {
				timeOutList.add("");
			}
		}
		generalMap.put("attendanceIdList", attendanceIdList);
		generalMap.put("attendanceDateList", attendanceDateList);
		generalMap.put("outDateList", outDateList);
		generalMap.put("timeInList", timeInList);
		generalMap.put("timeOutList", timeOutList);
		map = attendanceHandlerService
				.saveManualEmployeeAttenadance(generalMap);
		String jsp = "manualEmployeeAttendance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView saveShiftParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();
		HrMasShift hrMasShift = new HrMasShift();
		int departmentId = 0;
		int cate_id = 0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY).equals("0"))) {
			cate_id = Integer
					.parseInt(request.getParameter(EMPLOYEE_CATEGORY));
			 MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasShift.setDepartment(masDepartment); 
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasShift.setHospital(masHospital);*/

		}
		int shiftCodeId = 0;
		if (request.getParameter("shiftName") != null
				&& !(request.getParameter("shiftName").equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter("shiftName"));
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrMasShift.setShiftCodes(hrMasShiftCodes);*/
		}
		/*String shiftStartTime = "";
		if (request.getParameter(START_TIME) != null
				&& !(request.getParameter(START_TIME).equals(""))) {
			shiftStartTime = request.getParameter(START_TIME);
			hrMasShift.setShiftStartTime(shiftStartTime);

		}
		String shiftEndTime = "";
		if (request.getParameter(END_TIME) != null
				&& !(request.getParameter(END_TIME).equals(""))) {
			shiftEndTime = request.getParameter(END_TIME);
			hrMasShift.setShiftEndTime(shiftEndTime);

		}*/
		Users user = null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");

		}
		/*if (request.getParameter(CHANGED_BY) != null) {
			String lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasShift.setLastChgBy(lastchangeBy);
		}*/
		
		/*Date changedDate = null;*/
		String changedDate = "";
		
		if (request.getParameter("CHANGED_DATE") != null
				&& !(request.getParameter("CHANGED_DATE").equals(""))) {
			/*changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			hrMasShift.setLastChgDate(changedDate);*/
			changedDate = request.getParameter("CHANGED_DATE");

		}

		String changedTime = "";
		if (request.getParameter("CHANGED_TIME") != null
				&& !(request.getParameter("CHANGED_TIME").equals(""))) {
			changedTime = request.getParameter("CHANGED_TIME");
			/*hrMasShift.setLastChgTime(changedTime);*/
		}
	
		int row=0;
		if (request.getParameter("hiddenValueCharge") != null && !(request.getParameter("hiddenValueCharge").equals(""))) {
			row =Integer.parseInt(""+request.getParameter("hiddenValueCharge"));
	
		}
		List sesList= new ArrayList();
		List fromTimeList= new ArrayList();
		List toTimeList= new ArrayList();
		//System.out.println("row>>"+row);

		for(int i=1;i<=row;++i){
		//	System.out.println(i+"in sess>>"+request.getParameter("session2"));
			if (request.getParameter("session"+i) != null && !(request.getParameter("session"+i).equals(""))) {
				//System.out.println(i+"<<in sess>>"+request.getParameter("session"+i));
				sesList.add(request.getParameter("session"+i));
		
			}
			if (request.getParameter("fromTime"+i) != null && !(request.getParameter("fromTime"+i).equals(""))) {
				fromTimeList.add(request.getParameter("fromTime"+i));
		
			}
			if (request.getParameter("toTime"+i) != null && !(request.getParameter("toTime"+i).equals(""))) {
				toTimeList.add(request.getParameter("toTime"+i));
		
			}
		}
		
		/*hrMasShift.setStatus("y");*/
		valueMap.put("sesList", sesList);
		valueMap.put("fromTimeList", fromTimeList);
		valueMap.put("toTimeList", toTimeList);
		valueMap.put("cate_id", cate_id);
		valueMap.put("shiftCodeId", shiftCodeId);
		valueMap.put("changedDate", changedDate);
		valueMap.put("changedTime", changedTime);
		valueMap.put("user", user);
		valueMap.put("hospitalId", hospitalId);
		map = attendanceHandlerService.saveShiftParameterDetails(valueMap);

		String jsp = "shiftParameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchShiftParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();
		HrMasShift hrMasShift = new HrMasShift();
		int departmentId = 0;
		int cate_id = 0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY).equals("0"))) {
			cate_id = Integer
					.parseInt(request.getParameter(EMPLOYEE_CATEGORY));
			 MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasShift.setDepartment(masDepartment); 
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasShift.setHospital(masHospital);*/

		}
		int shiftCodeId = 0;
		if (request.getParameter("shiftName") != null
				&& !(request.getParameter("shiftName").equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter("shiftName"));
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrMasShift.setShiftCodes(hrMasShiftCodes);*/
		}
		
		valueMap.put("cate_id", cate_id);
		valueMap.put("shiftCodeId", shiftCodeId);
		valueMap.put("hospitalId", hospitalId);
		map = attendanceHandlerService.searchShiftParameter(valueMap);

		String jsp = "shiftParameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView updateShiftParameter(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> valueMap = new HashMap<String, Object>();
		HrMasShift hrMasShift = new HrMasShift();
		int departmentId = 0;
		int cate_id = 0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY).equals("0"))) {
			cate_id = Integer
					.parseInt(request.getParameter(EMPLOYEE_CATEGORY));
			/*MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			hrMasShift.setDepartment(masDepartment);*/
		}
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrMasShift.setHospital(masHospital);*/

		}
		int shiftCodeId = 0;
		if (request.getParameter("shiftName") != null
				&& !(request.getParameter("shiftName").equals(""))) {
			shiftCodeId = Integer.parseInt(request.getParameter("shiftName"));
			/*HrMasShiftCodes hrMasShiftCodes = new HrMasShiftCodes();
			hrMasShiftCodes.setId(shiftCodeId);
			hrMasShift.setShiftCodes(hrMasShiftCodes);*/
		}
		/*String shiftStartTime = "";
		if (request.getParameter(START_TIME) != null
				&& !(request.getParameter(START_TIME).equals(""))) {
			shiftStartTime = request.getParameter(START_TIME);
			hrMasShift.setShiftStartTime(shiftStartTime);

		}
		String shiftEndTime = "";
		if (request.getParameter(END_TIME) != null
				&& !(request.getParameter(END_TIME).equals(""))) {
			shiftEndTime = request.getParameter(END_TIME);
			hrMasShift.setShiftEndTime(shiftEndTime);

		}*/
		Users user = null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");

		}
		/*if (request.getParameter(CHANGED_BY) != null) {
			String lastchangeBy = request.getParameter(CHANGED_BY);
			hrMasShift.setLastChgBy(lastchangeBy);
		}*/
		
		/*Date changedDate = null;*/
		String changedDate = "";
		
		if (request.getParameter("CHANGED_DATE") != null
				&& !(request.getParameter("CHANGED_DATE").equals(""))) {
			/*changedDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(CHANGED_DATE));
			hrMasShift.setLastChgDate(changedDate);*/
			changedDate = request.getParameter("CHANGED_DATE");

		}

		String changedTime = "";
		if (request.getParameter("CHANGED_TIME") != null
				&& !(request.getParameter("CHANGED_TIME").equals(""))) {
			changedTime = request.getParameter("CHANGED_TIME");
			/*hrMasShift.setLastChgTime(changedTime);*/
		}
	
		int row=0;
		if (request.getParameter("hiddenValueCharge") != null && !(request.getParameter("hiddenValueCharge").equals(""))) {
			row =Integer.parseInt(""+request.getParameter("hiddenValueCharge"));
	
		}
		List sesList= new ArrayList();
		List fromTimeList= new ArrayList();
		List toTimeList= new ArrayList();
		List idList= new ArrayList();
		//System.out.println("row>>>>>>>>>>>>>>"+row);
		for(int i=1;i<=row;i++){
			//System.out.println(i+"in sess from>>"+request.getParameter("fromTime"+i)+" --   "+request.getParameter("toTime"+i));
			if (!request.getParameter("session"+i).equals(null) ) {
				//System.out.println(i+"<<in sess>>"+request.getParameter("session"+i));
				sesList.add(request.getParameter("session"+i));
		
			}
			if (request.getParameter("fromTime"+i) != null && !(request.getParameter("fromTime"+i).equals(""))) {
				fromTimeList.add(request.getParameter("fromTime"+i));
		
			}
			if (request.getParameter("toTime"+i) != null && !(request.getParameter("toTime"+i).equals(""))) {
				toTimeList.add(request.getParameter("toTime"+i));
		
			}
			if (request.getParameter("id"+i) != null && !(request.getParameter("id"+i).equals(""))) {
				idList.add(request.getParameter("id"+i));
		
			}
		}
		
		/*hrMasShift.setStatus("y");*/
		valueMap.put("idList", idList);
		valueMap.put("sesList", sesList);
		valueMap.put("fromTimeList", fromTimeList);
		valueMap.put("toTimeList", toTimeList);
		valueMap.put("cate_id", cate_id);
		valueMap.put("shiftCodeId", shiftCodeId);
		valueMap.put("changedDate", changedDate);
		valueMap.put("changedTime", changedTime);
		valueMap.put("user", user);
		valueMap.put("hospitalId", hospitalId);
		map = attendanceHandlerService.updateShiftParameterDetails(valueMap);

		String jsp = "shiftParameter";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showDutyScheduleJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		//MasHospital hospital = new MasHospital();
		int hospitalId = 0;
		
		Users user = null;
		
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}
		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		
		parameterMap.put("hospital", hospitalId);

		map = attendanceHandlerService.showDutyScheduleJsp(parameterMap);
		String jsp = "dutySchedule.jsp";
		//jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	public ModelAndView  searchDutyScheduleEmployee(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		
		int empCate=0;
		String month="";
		String year="";
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}
		int deptId = 0;
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		parameterMap.put("deptId", deptId);
		String flag="";
		if (request.getParameter("flag") != null && !(request.getParameter("flag").equals(""))) {
			flag = ""+request.getParameter("flag");
	
		}
		
		if (request.getParameter(EMPLOYEE_CATEGORY) != null && !(request.getParameter(EMPLOYEE_CATEGORY).equals(""))) {
			empCate = Integer.parseInt(""+request.getParameter(EMPLOYEE_CATEGORY));
	
		}
		if (request.getParameter("month") != null && !(request.getParameter("month").equals(""))) {
			month = request.getParameter("month");
	
		}
		if (request.getParameter("year") != null && !(request.getParameter("year").equals(""))) {
			year = request.getParameter("year");
	
		}
		
		parameterMap.put("empCate", empCate);
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("month", month);
		parameterMap.put("year", year);
		
		
		map1 = attendanceHandlerService.searchDutyScheduleEmployee(parameterMap);
		map = attendanceHandlerService.showDutyScheduleJsp(parameterMap);
		map1.put("deptId", deptId);
		String jsp="";
		if(flag.equalsIgnoreCase("v"))
			 jsp = "validateDutySchedule.jsp";
		else
			 jsp = "dutySchedule.jsp";
		//jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("map1", map1);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView  getSessForShift(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		System.out.println("getSessForShift");
		int hospitalId = 0;
		int empCate=0;
		int shift=0;
		String row="";
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}
	
		if (request.getParameter("empcate") != null && !(request.getParameter("empcate").equals(""))) {
			empCate = Integer.parseInt(""+request.getParameter("empcate"));
	
		}
		if (request.getParameter("shift") != null && !(request.getParameter("shift").equals(""))) {
			shift = Integer.parseInt(""+request.getParameter("shift"));
	
		}
		if (request.getParameter("row") != null && !(request.getParameter("row").equals(""))) {
			row = request.getParameter("row");
	
		}
		//System.out.println("in jsp>>"+row);
		parameterMap.put("empCate", empCate);
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("shift", shift);
		parameterMap.put("row", row);
		
		//map1 = attendanceHandlerService.searchDutyScheduleEmployee(parameterMap);
		map = attendanceHandlerService.getSessForShift(parameterMap);
		String jsp = "responseDutySchedule";
		//jsp += ".jsp";
		/*map.put("contentJsp", jsp);
		map.put("map1", map1);*/
	
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView saveDutySchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		HrEmployeeShiftDetails hrEmployeeShiftDetails = new HrEmployeeShiftDetails();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			/*MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			hrEmployeeShiftDetails.setHospital(masHospital);*/
		}
		
		int totRow = 0;
		if (request.getParameter("hiddenValueCharge") != null) {
			totRow = Integer.parseInt(request.getParameter("hiddenValueCharge"));
		}
		
		List empIdList = new ArrayList();
		List ScheduleMList = new ArrayList();
		List ScheduleTList = new ArrayList();
		List shiftIdList = new ArrayList();
		List ScheduleList = new ArrayList();
		List departmentList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		for(int i=1;i<=totRow;i++){
			
			int employeeId = 0;
			if (request.getParameter("employee_id"+i) != null) {
				employeeId = Integer.parseInt(request.getParameter("employee_id"+i));
				empIdList.add(employeeId);
			}
			int scheduleM = 0;
			if (request.getParameter("scheduleM"+i) != null) {
				scheduleM = Integer.parseInt(request.getParameter("scheduleM"+i));
				ScheduleMList.add(scheduleM);
			}
			int scheduleT = 0;
			
			/*for(int k=1;k<=30;k++){
				if (request.getParameter("shift"+i+k) != null && !request.getParameter("shift"+i+k).equalsIgnoreCase("0")) {
					shiftIdList.add(Integer.parseInt(request.getParameter("shift"+i+k)));
				}
				if (request.getParameter("departmentId"+i+k) != null && !request.getParameter("departmentId"+i+k).equals("0")) {

					departmentList.add(Integer.parseInt(request.getParameter("departmentId"+i+k)));
				}

				System.out.println("scheduleT=="+Integer.parseInt(request.getParameter("scheduleT"+i+k)));
				if (request.getParameter("scheduleT"+i+k) != null) {
					scheduleT = Integer.parseInt(request.getParameter("scheduleT"+i+k));
					ScheduleTList.add(scheduleT);
				}

			
			}*/

	
		}
		Users lastchangeBy = null ;
		if (session.getAttribute("users") != null) {
			 lastchangeBy = (Users) session.getAttribute("users");
		
		}
		/*Date changedDate = null;*/
		String chDate="";
		if (request.getParameter("CHANGED_DATE") != null
				&& !(request.getParameter("CHANGED_DATE").equals(""))) {
			/*changedDate = HMSUtil.convertStringTypeDateToDateType(request	.getParameter(CHANGED_DATE));*/
				
			chDate =request.getParameter("CHANGED_DATE");
			/*hrEmployeeShiftDetails.setLastChgDate(changedDate);*/
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
			//hrEmployeeShiftDetails.setLastChgTime(changedTime);
		}
		String month = "";
		if (request.getParameter("month") != null
				&& !(request.getParameter("month").equals(""))) {
			month = request.getParameter("month");
			//hrEmployeeShiftDetails.setLastChgTime(changedTime);
		}
		String year="";
		if (request.getParameter("year") != null
				&& !(request.getParameter("year").equals(""))) {
			year = request.getParameter("year");
			//hrEmployeeShiftDetails.setLastChgTime(changedTime);
		}
		int empCate=0;
		if (request.getParameter(EMPLOYEE_CATEGORY) != null && !(request.getParameter(EMPLOYEE_CATEGORY).equals(""))) {
			empCate = Integer.parseInt(""+request.getParameter(EMPLOYEE_CATEGORY));
	
		}
		//hrEmployeeShiftDetails.setStatus("y");
		Map parameterMap = new HashMap();
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("empIdList", empIdList);
		parameterMap.put("lastchangeBy", lastchangeBy);
		parameterMap.put("chDate", chDate);
		parameterMap.put("changedTime", changedTime);
		parameterMap.put("month", month);
		parameterMap.put("year", year);
		parameterMap.put("empCate", empCate);
		parameterMap.put("shiftIdList", shiftIdList);
		parameterMap.put("ScheduleList", ScheduleList);
		parameterMap.put("ScheduleMList", ScheduleMList);
		parameterMap.put("ScheduleTList", ScheduleTList);
		parameterMap.put("departmentList", departmentList);
		parameterMap.put("box", box);
		
		map1 = attendanceHandlerService.saveDutySchedule(parameterMap);
		map = attendanceHandlerService.showDutyScheduleJsp(parameterMap);
		map.put("map1", map1);	
		String jsp = "dutySchedule";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showValidateDutyScheduleJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		//MasHospital hospital = new MasHospital();
		int hospitalId = 0;
		Users user = null;
		
		if (session == null) {
			return new ModelAndView("index", "map", map);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}

		if (session.getAttribute(USERS) != null) {
			user = (Users) session.getAttribute(USERS);
		}
		
		parameterMap.put("hospital", hospitalId);

		map = attendanceHandlerService.showDutyScheduleJsp(parameterMap);
		String jsp = "validateDutySchedule.jsp";
		//jsp += ".jsp";
		map.put("contentJsp", jsp);

		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView  searchEmployeeForAttenadance(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int dept = 0;
		int shift =0;
		int designation=0;
		
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//hospital.setId(hospitalId);
		}
		
		if (request.getParameter("dept") != null && !(request.getParameter("dept").equals(""))) {
			dept = Integer.parseInt(""+request.getParameter("dept"));
	
		}
		if (request.getParameter("shift") != null && !(request.getParameter("shift").equals(""))) {
			shift = Integer.parseInt(""+request.getParameter("shift"));
	
		}
		if (request.getParameter("designation") != null && !(request.getParameter("designation").equals(""))) {
			designation = Integer.parseInt(""+request.getParameter("designation"));
	
		}
		//System.out.println(designation+"   "+dept);
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("dept", dept);	
		parameterMap.put("shift", shift);
		parameterMap.put("designation", designation);
		
		map = attendanceHandlerService.searchEmployeeForAttenadance(parameterMap);
		map.putAll(attendanceHandlerService.showEmployeeAttendanceForAdminJsp(parameterMap));
		//String jsp = "employeeAttendance.jsp";
		String jsp = "employeeAttendance1.jsp";
		//jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("map1", map1);
		//System.out.println("END");
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView validateDutySchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		HrEmployeeShiftDetails hrEmployeeShiftDetails = new HrEmployeeShiftDetails();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		
		int totRow = 0;
		if (request.getParameter("hiddenValueCharge") != null) {
			totRow = Integer.parseInt(request.getParameter("hiddenValueCharge"));
		}
		
		List empIdList = new ArrayList();
		List ScheduleMList = new ArrayList();
		List ScheduleTList = new ArrayList();
		List shiftIdList = new ArrayList();
		List ScheduleList = new ArrayList();
		Box box = HMSUtil.getBox(request);
		for(int i=1;i<=totRow;i++){
			int employeeId = 0;
			if (request.getParameter("employee_id"+i) != null) {
				employeeId = Integer.parseInt(request.getParameter("employee_id"+i));
				empIdList.add(employeeId);
			}
			int scheduleM = 0;
			if (request.getParameter("scheduleM"+i) != null) {
				scheduleM = Integer.parseInt(request.getParameter("scheduleM"+i));
				ScheduleMList.add(scheduleM);
			}
			int scheduleT = 0;
			/*for(int k=1;k<=30;k++){
				String s=""+i+k;
				if (request.getParameter("shift"+i+k) != null) {		
					shiftIdList.add(Integer.parseInt(request.getParameter("shift"+i+k)));
				}
				
				if (request.getParameter("scheduleT"+i+k) != null) {
					scheduleT = Integer.parseInt(request.getParameter("scheduleT"+i+k));
					ScheduleTList.add(scheduleT);
				}
				
			}*/
	
		
			}
		Users lastchangeBy = null ;
		if (session.getAttribute("users") != null) {
			 lastchangeBy = (Users) session.getAttribute("users");
		}
		
		String chDate="";
		if (request.getParameter("CHANGED_DATE") != null
				&& !(request.getParameter("CHANGED_DATE").equals(""))) {
			
			chDate =request.getParameter("CHANGED_DATE");
		}
		String changedTime = "";
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			changedTime = request.getParameter(CHANGED_TIME);
		}
		String month = "";
		if (request.getParameter("month") != null
				&& !(request.getParameter("month").equals(""))) {
			month = request.getParameter("month");
		}
		String year="";
		if (request.getParameter("year") != null
				&& !(request.getParameter("year").equals(""))) {
			year = request.getParameter("year");
		}
		
		Map parameterMap = new HashMap();
		parameterMap.put("hospitalId", hospitalId);
		parameterMap.put("empIdList", empIdList);
		parameterMap.put("lastchangeBy", lastchangeBy);
		parameterMap.put("chDate", chDate);
		parameterMap.put("changedTime", changedTime);
		parameterMap.put("month", month);
		parameterMap.put("year", year);
		parameterMap.put("shiftIdList", shiftIdList);
		parameterMap.put("ScheduleList", ScheduleList);
		parameterMap.put("ScheduleMList", ScheduleMList);
		parameterMap.put("ScheduleTList", ScheduleTList);
		parameterMap.put("box", box);
		map1 = attendanceHandlerService.validateDutySchedule(parameterMap);
		map = attendanceHandlerService.showDutyScheduleJsp(parameterMap);
		map.put("map1", map1);	
		String jsp = "validateDutySchedule";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public void displayShift(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int hospitalId = 0;
	
		HttpSession session = request.getSession();
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = attendanceHandlerService.getShiftForSchedule(box);
		List<Object[]> shiftList = new ArrayList<Object[]>();
		if(map.get("shiftList")!=null){
			shiftList = (List<Object[]>)map.get("shiftList");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<shiftList>");
		try {
			for (Object[] obj :shiftList) {

				sb.append("<shifts>");
				sb.append("<shiftId>" + obj[0] + "</shiftId>");
				sb.append("<shiftName>" + obj[1] + "</shiftName>");
				sb.append("</shifts>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</shiftList>");
		sb.append("</item>");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getEmpServiceCentre(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		int hospitalId = 0;
	
		HttpSession session = request.getSession();
		
		if (session.getAttribute("hospitalId") != null)
			hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
		
		Box box = HMSUtil.getBox(request);
		box.put("hospitalId", hospitalId);
		map = attendanceHandlerService.getEmpServiceCentre(box);
		List<Object[]> departmentList = new ArrayList<Object[]>();
		if(map.get("departmentList")!=null){
			departmentList = (List<Object[]>)map.get("departmentList");
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<departmentList>");
		try {
			for (Object[] obj :departmentList) {

				sb.append("<departments>");
				sb.append("<departmentId>" + obj[0] + "</departmentId>");
				sb.append("<departmentName>" + obj[1] + "</departmentName>");
				sb.append("</departments>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sb.append("</departmentList>");
		sb.append("</item>");
		response.setHeader("Cache-Control", "no-cache");

		try {
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
