package jkt.hms.appointment.controller;

/**
 * @ author: Priyanka Garg
 * Made on: 9th July 2008
 */
import static jkt.hms.util.RequestConstants.APPOINTMENT_CANCELLATION_REPORT_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_CANCELLATION_LIST;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INVESTIGATION_SETUP_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_INV_SLIP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_LIST_REPORT_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_MESSAGE_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENTS_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENT_CANCELLATION_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_PATIENT_CANCELLATION_LIST;
import static jkt.hms.util.RequestConstants.APPOINTMENT_REGISTERED_PATIENTS_JSP;
import static jkt.hms.util.RequestConstants.APPOINTMENT_SETUP_JSP;
import static jkt.hms.util.RequestConstants.APP_APP_SETUP;
import static jkt.hms.util.RequestConstants.APP_INVESTIGATION_CANCELLATION_LIST_REP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP_DAY_WISE_JSP;
import static jkt.hms.util.RequestConstants.APP_INVEST_SETUP_DAY_WISE_REP;
import static jkt.hms.util.RequestConstants.APP_SETUP_DAY_WISE_JSP;
import static jkt.hms.util.RequestConstants.APP_SETUP_DAY_WISE_REP;
import static jkt.hms.util.RequestConstants.DAY;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.EMPLOYEE_ID;
import static jkt.hms.util.RequestConstants.EQUIPMENT_ID;
import static jkt.hms.util.RequestConstants.FROMTIMESLOT;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.INVESTIGATION_LIST_REPORT_JSP;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.PATIENTS_APPOINTMENT_JSP;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_INVESTIGATION_EQUIPMENT_JSP;
import static jkt.hms.util.RequestConstants.SELECTED_RADIO;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.TOTIMESLOT;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.VALID_FROM_DATE;
import static jkt.hms.util.RequestConstants.VALID_TO_DATE;
import static jkt.hms.util.RequestConstants.WARD_ID;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.appointment.handler.AppointmentHandlerService;
import jkt.hms.masters.business.AppSetup;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DgOrderhd;
import jkt.hms.masters.business.DgSampleCollectionDetails;
import jkt.hms.masters.business.HospitalDoctorUnitM;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.gson.Gson;

public class AppointmentController extends MultiActionController {

	/**
	 * ------------------- GETTER AND SETTER METHODS -----------------------
	 *
	 * @return
	 */
	public AppointmentHandlerService getAppointmentHandlerService() {
		return appointmentHandlerService;
	}

	public void setAppointmentHandlerService(
			AppointmentHandlerService appointmentHandlerService) {
		this.appointmentHandlerService = appointmentHandlerService;
	}

	/**
	 * ----------------------------------------------------------------------
	 * ------------------ Start of coding --------------------
	 */

	AppointmentHandlerService appointmentHandlerService = null;
	RegistrationHandlerService registrationHandlerService = null;
	
	public RegistrationHandlerService getRegistrationHandlerService() {
		return registrationHandlerService;
	}

	public void setRegistrationHandlerService(
			RegistrationHandlerService registrationHandlerService) {
		this.registrationHandlerService = registrationHandlerService;
	}
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp = null;
	String title = null;
	static final Logger LOGGER = Logger.getLogger(AppointmentController.class);
	/**
	 * ---------------------------- APPOINTMENT SET UP JSP -------------------
	 */
	public ModelAndView showAppSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppSetupJsp();
		map.put("deptIdinMap", session.getAttribute("deptId"));
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getRecords(HttpServletRequest request,
			HttpServletResponse response) {
		//LOGGER.info("calling");
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		int deptId=0;
		Box box = HMSUtil.getBox(request);
		// int departmentId=box.getInt(DEPARTMENT_ID);

		HttpSession session = request.getSession();
		/*if (box.getInt(DEPARTMENT_ID) == 0) {

			box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
		}*/
		if(null !=request.getParameter("deptId") && !request.getParameter("deptId").equals("")){
			deptId=Integer.parseInt(request.getParameter("deptId"));
			LOGGER.info("Department Id "+Integer.parseInt(request.getParameter("deptId")));
			box.put(DEPARTMENT_ID, Integer.parseInt(request.getParameter("deptId")));
		}

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = appointmentHandlerService.getRecords(box);
		map.put("deptIdinMap", box.getInt(DEPARTMENT_ID));
		map.put("deptId",deptId);
		
		map.put("drIdinMap", box.getInt(RequestConstants.CONSULTING_DOCTOR));
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getServiceCentreWiseSession(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = appointmentHandlerService.getServiceCentreWiseSession(box);
		
		return new ModelAndView("responseForSession", "map", map);
	}

	public ModelAndView submitAppointmentSetup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		Users users= null;

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			box.put("usersId", users.getId());
		}
		dataSaved = appointmentHandlerService.submitAppointmentSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";

		} else {
			message = "Data cannot be saved !!";
		}
		//map = appointmentHandlerService.showAppSetupJsp();
		map = appointmentHandlerService.getRecords(box);
		map.put("deptIdinMap", box.getInt(WARD_ID));
		map.put("drIdinMap", box.getInt(RequestConstants.CONSUNTANT));
		map.put("message", message);
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAppointmentSetup(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		Users users = null; 
		if (session.getAttribute("users") != null) {
			users = (Users) session.getAttribute("users");
			box.put("usersId", users.getId());
		}
		List<AppSetup> appSetupList = new ArrayList<AppSetup>();
		dataSaved = appointmentHandlerService.updateAppointmentSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
			//map = appointmentHandlerService.showAppSetupJsp();
			map = appointmentHandlerService.getRecords(box);
		} else {
			message = "Data cannot be saved !!";
		}
		//map.put("message", message);
		map.put("deptIdinMap", box.getInt(WARD_ID));
		//map.put("drIdinMap", box.getInt(RequestConstants.CONSULTING_DOCTOR));
		map = appointmentHandlerService.getRecords(box);
		jsp = APPOINTMENT_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("message", message);
		map.put("appSetupList", appSetupList);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- PATIENT APPOINTMENTS -------------------
	 */
	public ModelAndView showAppointmentPatientJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dtailsMap = new HashMap<String, Object>();
		HttpSession session= request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			dtailsMap.put("hospitalId", hospitalId);
		}
		
		map = appointmentHandlerService.showAppointmentPatientJsp(dtailsMap);

		jsp = APPOINTMENT_PATIENTS_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentPatientDepartmentWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		map = appointmentHandlerService.showAppointmentPatientDepartmentWise(box);
		
		jsp = APPOINTMENT_PATIENTS_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showExistingPatients(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean recordExists = true;
		String message = null;
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		

		map = appointmentHandlerService.showExistingPatients(box);

		recordExists = (Boolean) map.get("recordExists");
		if (recordExists == false) {
			message = "No Data Found!!";
			map.put("message", message);
		}
		jsp = APPOINTMENT_REGISTERED_PATIENTS_JSP;
		title = "Patient Appointments";
		map.put("rowCount", box.getInt("counter"));
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showListBasedonHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean hinNoExist = true;
		String message = null;
		Box box = HMSUtil.getBox(request);
		//String hinNo = box.getString(HIN_NO);
		map = appointmentHandlerService.showListBasedonHinNo(box);
		hinNoExist = (Boolean) map.get("hinNoExist");
		int inc = box.getInt("inc");
		if (hinNoExist == false) {
			message = "No Data Found!!";
			map.put("message", message);
		}
		jsp = "appointmentPatientDetails";
		map.put("inc", inc);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showListBasedonNone(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//boolean hinNoExist = true;
		//String message = null;
		Box box = HMSUtil.getBox(request);
		int inc = box.getInt("inc");
		jsp = "appointmentPatientDetailsForValueNone";
		map.put("inc", inc);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public ModelAndView getPriorityQueueByDepartId(HttpServletRequest request,
			HttpServletResponse response) {
		LOGGER.info("getPriorityQueueByDepartId() Method");		
		Map<String, Object> map = new HashMap<String, Object>();
		String appointmentDate=null;		
		int hospitalId=0;
		
		Box box = HMSUtil.getBox(request);
		String appointmentType=null;
		if(box.getString("appointType")!=null){
			appointmentType=box.getString("appointType");
		}
		
		int departmentId = box.getInt("department");
		
		if(box.getString("appointmentDate")!=null && !box.getString("appointmentDate").equals("")){
			appointmentDate=box.getString("appointmentDate");
		}

		String appointmentTime=box.getString("visitTime");
		String visitTime = box.getString("visitTime");
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		map = appointmentHandlerService.getPriorityQueueByDepartId(departmentId,hospitalId,appointmentDate,appointmentTime,visitTime);
		
	
		if(appointmentType.equals("personal")){
			LOGGER.info("Personal Review");
			return new ModelAndView("responsepersonalReview", "map", map);
		}else{
			LOGGER.info("Online Appoinment");
			return new ModelAndView("responseOnlineAppointmentNo", "map", map);	
		}
		
	}

	/** Method to submit online appointment
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	public ModelAndView submitPatientAppointment(HttpServletRequest request,
			HttpServletResponse response) throws ParseException {
		logger.info("Method submitPatientAppointment()");
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		String userName = "";
		String message = null;
		String appointmentNo = null;
		String flag = "appointment";
		boolean typeStaus=false;
		int maxday=0;
		int minday=0;
		boolean uhidStatus=true;
		int departmentId = box.getInt("department");
		String sameHosp="N";
		String appointmentDate = box.get("appointmentDate");
		String review="";
		 maxday=box.getInt("maxday");
		 minday=box.getInt("minday");
		 
		
	  boolean datesStatus=checkAppointmentDate(minday,maxday,appointmentDate);

		
		if(true){
		String mobileNo = box.get("mob");
		
		int doctorId = box.getInt("loddrs");
		String serviceNo = box.getString(SERVICE_NO);
		
		
		
		String hinId = box.getString("uhid");

		String url = null;

		boolean dataSaved = false;
		boolean duplicateRecord = false;
		int queuePriority = 0;
		boolean patientNameExist=false;
		boolean recordExists=false;
		
		String existingDept ="";
		String existingStartTime = "";
		String existingEndTime ="";
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("Review")!=null){
			logger.info("Review");
			review=request.getParameter("Review");
			box.put("review", review);
		}
		String appointmentType="";
		
		if(null !=request.getParameter("appointmentType") && !request.getParameter("appointmentType").equals("")){
			hospitalId = Integer.parseInt(request.getParameter("hospitalName"));
			box.put("hospitalId", hospitalId);
			typeStaus=true;
		}else{
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		}
		
		if(appointmentType.equals("")){
			sameHosp="Y";
		}
		
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		Users user= null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		detailsMap.put("hospitalId", hospitalId);
		
		map = appointmentHandlerService.submitPatientAppointment(box);
		if(null!=map.get("message")){
			message = (String) map.get("message");
		}
		if(null!=map.get("dataSaved"))
		dataSaved = (Boolean) map.get("dataSaved");
		if(null!=map.get("duplicateRecord"))
		duplicateRecord = (Boolean) map.get("duplicateRecord");
		if(null!=map.get("appointmentNo"))
		appointmentNo = (String) map.get("appointmentNo");
		
		if(null!=map.get("patientNameExist"))
		 patientNameExist = (Boolean) map.get("patientNameExist");
		
		if(null!=map.get("recordExists"))
		 recordExists = (Boolean) map.get("recordExists");
		 
		if(null!=map.get("queuePriority"))
			queuePriority = (int) map.get("queuePriority");
			 
		
		//map.put("typeStaus", typeStaus);
		
		if (dataSaved == true) {
			//message = "Your Appointment No. is -" + appointmentNo +" Token No. is -"+queuePriority +" and Date of appoinment  is -"+appointmentDate; //commented by swaurp on 04-02-218
			message = "Appointment confirmed. Date of appoinment  is <b style='color:red'>"+appointmentDate+"</b> and Token No. is <b style='color:red'>" +queuePriority+"</b>";  
			url = "submitForm('messageForm','appointment?method=showAppointmentPatientJsp');";
			map.put("url", url);
			map.put("message", message);
			map.put("duplicateRecord", duplicateRecord);
			
			if(!typeStaus && review !="R" && !review.equalsIgnoreCase("R")){
			jsp = APPOINTMENT_MESSAGE_JSP;
			}else if(review.equalsIgnoreCase("R")){
				jsp="responseOnlineAdvancedAppointmentNo";
			}else{
			jsp="otherAppointmentMessage";
			}

		}  else if (duplicateRecord == false && recordExists == true) {
			message = (String) map.get("message");
			map = appointmentHandlerService.showAppointmentPatientJsp(detailsMap);
			/*map.put("fromTimeSlot", fromTimeSlot);
			map.put("toTimeSlot", toTimeSlot);*/
			map.put("departmentId", departmentId);
			map.put("appointmentDate", appointmentDate);
			/*map.put("patientName", patientName);
			map.put("sex", sex);*/
			/*map.put("age", age);
			map.put("ageUnit", ageUnit);*/
			map.put("mobileNo", mobileNo);
			map.put("doctorId", doctorId);
			map.put("serviceNo", serviceNo);
			map.put("hinId", hinId);

			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			map.put("duplicateRecord", duplicateRecord);
			map.put("message", message);
			map.put("duplicateRecord", duplicateRecord);
			if(!typeStaus && review !="R" && !review.equalsIgnoreCase("R")){
				jsp = "onlineAppointment";
				}else if(review.equalsIgnoreCase("R")){
					jsp="responseOnlineAdvancedAppointmentNo";
				}else{
					jsp="otherAppointmentMessage";
				}
		} else {
			if (patientNameExist == false && recordExists == false) {
				//message = "Data cannot be saved !!";
				//message = "UHID is not Valid ";
				logger.info("Message " +message);
				uhidStatus=false;
			}
			map = appointmentHandlerService.showAppointmentPatientJsp(detailsMap);
			/*map.put("fromTimeSlot", fromTimeSlot);
			map.put("toTimeSlot", toTimeSlot);*/
			map.put("departmentId", departmentId);
			map.put("appointmentDate", appointmentDate);
			/*map.put("patientName", patientName);
			map.put("sex", sex);
			map.put("age", age);
			map.put("ageUnit", ageUnit);*/
			map.put("mobileNo", mobileNo);
			map.put("doctorId", doctorId);
			map.put("serviceNo", serviceNo);
			map.put("hinId", hinId);
			
			/*map.put("servicePerson", servicePerson);*/

			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			map.put("duplicateRecord", duplicateRecord);
			map.put("message", message);
			if(!typeStaus && review !="R" && !review.equalsIgnoreCase("R")){
				jsp = APPOINTMENT_MESSAGE_JSP;
				}else if(review.equalsIgnoreCase("R")){
					jsp="responseOnlineAdvancedAppointmentNo";
				}else{
				jsp="otherAppointmentMessage";
				}
		}
		// -----------------------Vishal Code Start----------
		map.put("flag", flag);
		map.put("appointmentNo", appointmentNo);
		// -----------------------Vishal Code End----------
		map.put("patientNameExist", patientNameExist);
		map.put("recordExists", recordExists);
		}
		else{
			message="Online Appointment is not available for this date ";
			map.put("message", message);
			if(!typeStaus && review !="R" && !review.equalsIgnoreCase("R")){
				jsp = APPOINTMENT_MESSAGE_JSP;
				}else if(review.equalsIgnoreCase("R")){
					jsp="responseOnlineAdvancedAppointmentNo";
				}else{
				jsp="otherAppointmentMessage";
				}
		}
		if(review.equalsIgnoreCase("R")){
			jsp="responseOnlineAdvancedAppointmentNo";
		}else{
			jsp += ".jsp";
		}
		title = "Appointment Setup";
		map.put("departmentId", departmentId);
		map.put("appointmentDateOp", appointmentDate);
		map.put("sameHosp", sameHosp);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("uhidStatus", uhidStatus);
		if(review.equalsIgnoreCase("R")){
			return new ModelAndView(jsp, "map", map);
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDulicatePatientNameAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		String userName = "";
		String message = null;
		String appointmentNo = null;

		String url = null;

		boolean dataSaved = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		detailsMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		map = appointmentHandlerService
				.submitDulicatePatientNameAppointment(box);
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		appointmentNo = (String) map.get("appointmentNo");

		if (dataSaved == true) {
			message = "Your Appointment No. is " + appointmentNo;
			url = "submitForm('message','appointment?method=showAppointmentPatientJsp');";
			map.put("url", url);
			map.put("message", message);
			map.put("flag", "appointment");
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else {
			message = "Data cannot be saved !!";
			map = appointmentHandlerService.showAppointmentPatientJsp(detailsMap);
			map.put("message", message);
			jsp = APPOINTMENT_PATIENTS_JSP;
		}

		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- INVESTIGATION SET UP JSP -------------------
	 */
	public ModelAndView showAppointmentInvestigationSetupJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.showAppointmentInvestigationSetupJsp(detailMap);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------- get list of investigation equipments through ajax
	 * ---------------
	 *
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getInvestigationList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		// map=appointmentHandlerService.getInvestigationList();
		jsp = RESPONSE_FOR_INVESTIGATION_EQUIPMENT_JSP;
		jsp += ".jsp";
		title = "Appointment Investigation";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentInvestigationSetupDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}

		map = appointmentHandlerService
				.showAppointmentInvestigationSetupDetails(box);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitAppointmentInvestigationSetup(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
	
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			
		}
		detailMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		Users user = null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}

		dataSaved = appointmentHandlerService.submitAppointmentInvestigationSetup(box);
			
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";

		} else {
			message = "Data cannot be saved !!";
		}
		map = appointmentHandlerService.showAppointmentInvestigationSetupJsp(detailMap);
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateAppointmentInvestigationSetup(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		String userName = "";
		String message = null;
		Users user = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		detailMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}

		dataSaved = appointmentHandlerService
				.updateAppointmentInvestigationSetup(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
			map = appointmentHandlerService.showAppointmentInvestigationSetupJsp(detailMap);
					
		} else {
			message = "Data cannot be saved !!";
		}
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_SETUP_JSP;
		jsp += ".jsp";
		title = "Investigation Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- APPOINTMENT INVSTIGATION
	 * ---------------------------------- started on 26th Aug 2008 Author :
	 * Priyanka Garg
	 */
	public ModelAndView showAppointmentInvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.showAppointmentInvestigationJsp(detailMap);
		jsp = APPOINTMENT_INVESTIGATION_JSP;
		jsp += ".jsp";
		title = "Investigation Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAppointmentInvestigationWise(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		
		map = appointmentHandlerService.showAppointmentInvestigationWise(box);
		/*jsp = APPOINTMENT_INVESTIGATION_JSP;
		jsp += ".jsp";
		title = "Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);*/
		return new ModelAndView("responseInvestivationApp", "map", map);
	}

	/** Method for investigation appointment
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView submitInvestigationAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		String userName = "";
		String message = null;
		String appointmentNo = null;
		String flag = "investigation";
		//StringBuffer stf = new StringBuffer();
		//String newLine = System.getProperties().getProperty("line.separator");
		Box box = HMSUtil.getBox(request);

	/*	String fromTimeSlot = box.getString(FROMTIMESLOT);
		String toTimeSlot = box.getString(TOTIMESLOT);
		int departmentId = box.getInt(WARD_ID);
		
		int equipId = box.getInt(EQUIP_ID);
		String appointmentDate = box.get(APMT_DATE);
		String patientName = box.getString(PATIENT_NAME);
		String sex = box.getString(SEX);
		String age = box.getString(AGE);
		String ageUnit = box.getString(AGE_UNIT);
		int mobileNo = box.getInt(MOBILE_NO);
		
		int doctorId = box.getInt(EMPLOYEE_ID);
		String hinId = box.getString(HIN_ID);
*/
		String url = null;

		boolean dataSaved = false;
		boolean duplicateRecord = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		detailMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}

		Users user= null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		
		String investigationListValue="";
		//List<String> patientInvestigationList =new ArrayList<String>();
			String investigation[]=request.getParameterValues("investigationName");
			//String tempIn=investigation.split("\\[");
			for(String s:investigation){
				investigationListValue=investigationListValue+s+",";
				//patientInvestigationList.add(s);
				
			}
			LOGGER.info("investigationListValue"+investigationListValue);
			LOGGER.info("investigationListValue"+investigationListValue.trim());
			/*List<String> patientInvestigationList = Arrays.asList(investigation);*/
			
			box.put("patientInvestigationList", investigationListValue.trim());
		map = appointmentHandlerService.submitInvestigationAppointment(box);
		dataSaved = (Boolean) map.get("dataSaved");
		duplicateRecord = (Boolean) map.get("duplicateRecord");
		appointmentNo = (String) map.get("appointmentNo");
		boolean patientNameExist = (Boolean) map.get("patientNameExist");
		boolean recordExists = (Boolean) map.get("recordExists");
		String existingDept = (String) map.get("existingDept");
		String existingStartTime = (String) map.get("existingStartTime");
		String existingEndTime = (String) map.get("existingEndTime");
		url = "submitForm('messageForm','appointment?method=showAppointmentInvestigationJsp');";
		map.put("url", url);
		if (dataSaved == true) {
			message = "Your Investigation Appointment No. is " + appointmentNo;
			map.put("message", message);
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else if (duplicateRecord == true) {
			message = (String) map.get("message");
			map = appointmentHandlerService.showAppointmentInvestigationJsp(detailMap);
			map.put("message", message);
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		} else if (duplicateRecord == false && recordExists == true) {
			message = (String) map.get("message");
			map = appointmentHandlerService.showAppointmentInvestigationJsp(detailMap);
			//map.put("fromTimeSlot", fromTimeSlot);
			//map.put("toTimeSlot", toTimeSlot);
			//map.put("departmentId", departmentId);
			//map.put("equipId", equipId);
			//map.put("appointmentDate", appointmentDate);
			//map.put("patientName", patientName);
			//map.put("sex", sex);
			//map.put("age", age);
			//map.put("ageUnit", ageUnit);
			//map.put("mobileNo", mobileNo);
			///map.put("doctorId", doctorId);
			//map.put("hinId", hinId);
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);
			map.put("message", message);
			map.put("duplicateRecord", duplicateRecord);
			jsp = APPOINTMENT_MESSAGE_JSP;
		} else {
			if (patientNameExist == false && recordExists == false) {
				message = "Data cannot be saved !!";
			}

			map = appointmentHandlerService.showAppointmentInvestigationJsp(detailMap);
		//	map.put("fromTimeSlot", fromTimeSlot);
		//	map.put("toTimeSlot", toTimeSlot);
		//	map.put("departmentId", departmentId);
		//	map.put("equipId", equipId);
		//	map.put("appointmentDate", appointmentDate);
		//	map.put("patientName", patientName);
		//	map.put("sex", sex);
		//	map.put("age", age);
		//	map.put("ageUnit", ageUnit);
		//	map.put("mobileNo", mobileNo);
		//	map.put("doctorId", doctorId);
			//map.put("hinId", hinId);
			map.put("existingDept", existingDept);
			map.put("existingStartTime", existingStartTime);
			map.put("existingEndTime", existingEndTime);

			map.put("message", message);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		}
		// -----------------------Vishal Code Start----------
		map.put("flag", flag);
		map.put("appointmentNo", appointmentNo);
		// -----------------------Vishal Code End----------

		jsp += ".jsp";
		title = "Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientNameExist", patientNameExist);
		map.put("recordExists", recordExists);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitDulicatePatientNameInvAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId=0;
		String userName = "";
		String message = null;
		String appointmentNo = null;

		String url = null;

		boolean dataSaved = false;

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		detailMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
	
		map = appointmentHandlerService
				.submitDulicatePatientNameInvAppointment(box);
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		appointmentNo = (String) map.get("appointmentNo");

		if (dataSaved == true) {
			message = "Your Appointment No. is " + appointmentNo;
			url = "submitForm('messageForm','appointment?method=showAppointmentInvestigationJsp');";
			map.put("url", url);
			map.put("message", message);
			map.put("flag", "investigation");
			jsp = APPOINTMENT_MESSAGE_JSP;

		} else {
			message = "Data cannot be saved !!";
			map = appointmentHandlerService.showAppointmentInvestigationJsp(detailMap);
			map.put("message", message);
			jsp = APPOINTMENT_INVESTIGATION_JSP;
		}

		jsp += ".jsp";
		title = "Appointment Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- CANCELLATION FOR PATIENT AAPOINTMENTS
	 * ---------------------------------- started on 1st Sept 2008 Author :
	 * Priyanka Garg
	 */
	public ModelAndView showAppointmentPatientCancellationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView patientAppointmentList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		map = appointmentHandlerService.patientAppointmentList(box);
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView patientAppointmentRegisterList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		map = appointmentHandlerService.patientAppointmentRegisterList(box);
		jsp = PATIENTS_APPOINTMENT_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCancelPatientAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);
		Users user=null;

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("UserId", user.getId());
		}

		dataSaved = appointmentHandlerService.submitCancelPatientAppointment(box);
			
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		map.put("message", message);
		jsp = APPOINTMENT_PATIENT_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Patient Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------------------- CANCELLATION FOR INVESTIGATION
	 * APOINTMENTS ---------------------------------- started on 4st Sept 2008
	 * Author : Priyanka Garg
	 */
	public ModelAndView showAppointmentInvestigationCancellationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);			
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.showAppointmentInvestigationCancellationJsp(detailMap);				
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView investigationAppointmentList(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId;
		String userName = "";
		String jsp = "";
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
	
		map = appointmentHandlerService.investigationAppointmentList(box);
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointment";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCancelInvestigationAppointment(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		String userName = "";
		String message = null;
		boolean dataSaved = false;
		Box box = HMSUtil.getBox(request);

		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		detailMap.put("hospitalId", hospitalId);
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			box.put("userName", userName);
		}
		
		Users user = null;
		if (session.getAttribute("users") != null) {
			user = (Users) session.getAttribute("users");
			box.put("UserId", user.getId());
		}


		dataSaved = appointmentHandlerService
				.submitCancelInvestigationAppointment(box);
		if (dataSaved == true) {
			message = "Data Successfully Saved !!";
		} else {
			message = "Data cannot be saved !!";
		}
		//map = appointmentHandlerService.showAppointmentPatientCancellationJsp();
		map = appointmentHandlerService.showAppointmentInvestigationCancellationJsp(detailMap);		
		map.put("message", message);
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_JSP;
		jsp += ".jsp";
		title = "Cancel for Investigation Appointments";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------ uploading documents JSP-----------------
	 */
	public ModelAndView showUploadingDocumentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "upload_documents" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		String whiteList = "*.jpg";

		// Long fileSizeLimit = 2097152l;

		List fileUploadedList = null;
		fileUploadedList = HMSUtil.uploadFile(mrequest, uploadURL, whiteList,
				box.getString("filename"));
		Boolean fileUploaded = false;
		if (fileUploadedList != null && fileUploadedList.size() != 0) {
			fileUploaded = (Boolean) fileUploadedList.get(0);
		}
		box.put("uploadURL", uploadURL);
		box.put("filename", box.getString("filename"));
		map = appointmentHandlerService.submitUploadDocuments(box);
		jsp = "upload_documents";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewUploadDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		MultipartFormDataRequest mrequest = null;

		if (MultipartFormDataRequest.isMultipartFormData(request)) {
			try {
				mrequest = new MultipartFormDataRequest(request);
			} catch (UploadException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		String uploadURL = getServletContext().getRealPath("/upload/");

		box.put("uploadURL", uploadURL);

		box.put("filename", box.getString("filename"));
		map = appointmentHandlerService.viewUploadDocuments(box);
		try {
			response.setContentType("image/jpg");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ box.getString("filename") + ".jpg");

			File f = new File(uploadURL + "/" + box.getString("filename")
					+ ".jpg");
			InputStream in = new FileInputStream(f);
			ServletOutputStream outs = response.getOutputStream();
			int bit = 256;
			//int i = 0;
			while ((bit) >= 0) {
				bit = in.read();
				outs.write(bit);
			}
			outs.flush();
			outs.close();
			in.close();
			if (f.exists()) {
				f.delete();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		jsp = "upload_documents";
		jsp += ".jsp";
		title = "Import CD";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ---------------------------- Start code for Report by Vishal
	 * -------------------
	 */
	// ---------------------------Print Appointment
	// Setup---------------------------------------------
	public ModelAndView printAppointmentSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int departmentId = 0;
		//String period = null;
		String query = "";
		int hospitalId=0;
		HttpSession session = request.getSession();

		try {
			
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				query = " where  mas_hospital.hospital_id = " + hospitalId;
			}
			
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				departmentId = Integer.parseInt(""
						+ request.getParameter(DEPARTMENT_ID));
				query += " and  app_setup.dept_id = " + departmentId;
			}

		
			requestParameters.put("QUERY", query);
			//LOGGER.info(">>>>"+query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = appointmentHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(APP_APP_SETUP), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ APP_APP_SETUP + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//return new ModelAndView("index", "map", map);
		return null;
	}

	// -------------------Print Investigation
	// Setup-----------------------------------
	public ModelAndView printInvestigationSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		int departmentId = 0;
		int equipmentId = 0;
		//String period = null;
		String query = "";

		try {
			int hospitalId=0;

			if (session.getAttribute(HOSPITAL_ID) != null) {
				
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			query =" where mas_hospital.hospital_id= "+hospitalId ;
			
			LOGGER.info("equipmentId"+request.getParameter("equipmentId"));
			if (request.getParameter("departmentId") != null
					&& !(request.getParameter("departmentId").equals("0"))
					&& request.getParameter("equipmentId") != null
					&& !(request.getParameter("equipmentId").equals("0"))) {
				
						
				departmentId = Integer.parseInt(""+ request.getParameter("departmentId"));
				equipmentId = Integer.parseInt(""+ request.getParameter("equipmentId"));
						
				query += " and app_investigation_setup.department_id = "+ departmentId
						+ " and app_investigation_setup.equipment_id = "+ equipmentId;
			}		
						
			
			if ( request.getParameter("departmentId").equals("0")
					&& request.getParameter("equipmentId") != null && !(request.getParameter("equipmentId").equals("0"))) {
				equipmentId = Integer.parseInt(""+ request.getParameter("equipmentId"));
				query += " and  app_investigation_setup.equipment_id = "+ equipmentId;
			
			}

			if (request.getParameter("departmentId") != null && !(request.getParameter("departmentId").equals("0"))
						&& request.getParameter("equipmentId").equals("0")) {
				
				departmentId = Integer.parseInt(""+ request.getParameter("departmentId"));
				query += " and app_investigation_setup.department_id = "+ departmentId;
				
			}
			

			requestParameters.put("QUERY", query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = appointmentHandlerService
				.getConnectionForReport();
		byte[] bytes = null;

		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(APP_INVEST_SETUP), requestParameters,
					(Connection) connectionMap.get("con"));
		} catch (JRException e) {
			e.printStackTrace();
		}

		response.setHeader("Content-Disposition", "attachment; filename="
				+ APP_INVEST_SETUP + ".pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream;
		try {
			ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//return new ModelAndView("index", "map", map);
		return null;
	}

	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}
	public static JasperReport getCompiledReport(ServletContext context,String fileName)
	throws JRException {
		File reportFile = new File(context.getRealPath("/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportFile);
		return jasperReport;
		}


	// ----------------Print OPD Appointment List-------------------------
	public ModelAndView showOPDAppointmentListReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEmployeeDepartmentCategory(detailMap);

		jsp = APPOINTMENT_LIST_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDAppointmentReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int doctor = 0;
		int status = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		try {
			if (request.getParameter(VALID_FROM_DATE) != null &&

			!(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate

				= sdf.format(HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null &&

			!(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate =

				sdf.format(HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(VALID_TO_DATE)));
			}
			if (request.getParameter(DEPARTMENT_ID) != null &&

			!(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = " where app_patient_appointments.appointment_date between '"
						+ fromDate+ "' and '"+ toDate + "' and app_patient_appointments.department_id = "+ department;
						
			} else {
				query = " where app_patient_appointments.appointment_date between '"+ fromDate + "' and '"+ toDate + "'";
		
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				doctor = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query + " and app_patient_appointments.employee_id = "	+ doctor;
					
			}
			if (request.getParameter(SELECTED_RADIO) != null &&

			!(request.getParameter(SELECTED_RADIO).equals("0"))) {
				status = Integer.parseInt(request.getParameter(SELECTED_RADIO));
				if (status == 1) {
					query = query+ " and app_patient_appointments.appointment_status = 'v'";
						
				} else if (status == 2) {
					query = query+ " and app_patient_appointments.appointment_status = 'y'";
							
				} else if (status == 3) {
					query = query+ " and app_patient_appointments.appointment_status != 'c'";
							
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		query += " and mas_hospital.hospital_id="+hospitalId;
		parameters.put("QUERY", query);

		detailsMap = appointmentHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

		HMSUtil.generateReport("app_patient_list_common", parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());

		return null;
		/*try {
			byte[] bytes = null;
			try {
				bytes

				= JasperRunManager.runReportToPdf(
						getCompiledReport("app_patient_list_common"),
						parameters, (Connection) detailsMap.get("con"))

				;

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
*/	}

	// ----------------Print OPD Investigation List-------------------------

	public ModelAndView showOPDInvestigationListReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEquipmentDepartmentCategory(detailMap);
		jsp = INVESTIGATION_LIST_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDInvestigationReport(
			HttpServletRequest request, HttpServletResponse response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int equipment = 0;
		String query = "";
		//int status = 0;
		int hospitalId=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				
				fromDate= sdf.format(HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE)));	
			}

			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				
				toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(request	.getParameter(TO_DATE)));			
			}

			if (request.getParameter(DEPARTMENT_ID) != null &&!(request.getParameter(DEPARTMENT_ID).equals("0"))) {

				department = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
						
				query = " where app_investigation_appointments.investigation_date between '"	+ fromDate+ "' and '"
						+ toDate+ "' and app_investigation_appointments.department_id = "+ department;
					
			} else {
				query = " where app_investigation_appointments.investigation_date between '"+ fromDate+ "' and '" + toDate + "'";		
										
			}
			if (request.getParameter(EQUIPMENT_ID) != null && !(request.getParameter(EQUIPMENT_ID).equals("0"))) {

				equipment = Integer.parseInt(request.getParameter(EQUIPMENT_ID));		
				query = query+ " and app_investigation_appointments.equipment_id = "+ equipment;
						
						
			}

			/*
			 * if(request.getParameter(SELECTED_RADIO) != null &&
			 *
			 * !(request.getParameter(SELECTED_RADIO).equals("0"))){ status
			 * =Integer.parseInt(request.getParameter(SELECTED_RADIO)); if
			 * (status == 1) { query = query + " and
			 * app_investigation_appointments.`investigation_status` = 'v'" ; }
			 * else if(status == 2 ) { query = query + " and
			 * app_investigation_appointments.`investigation_status` = 'y'" ; }
			 * else if(status == 3 ) { query = query + " and
			 * app_investigation_appointments.`investigation_status` != 'c'" ; }
			 * }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		query += " and mas_hospital.hospital_id= "+ hospitalId;
		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes

				= JasperRunManager.runReportToPdf(
						getCompiledReport("app_investigation_list"),
						parameters, (Connection) detailsMap.get("con")

				);

			} catch (JRException e) {

				e.printStackTrace();
			}
			//response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ "app_investigation_list" + ".pdf");
			response.setContentLength(bytes.length);
			
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	}

	// ---------------------------report for Appointment
	// Cancellation------------------------------------

	public ModelAndView showOPDAppointmentCancellationReportJsp(
			HttpServletRequest request, HttpServletResponse

			response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEmployeeDepartmentCategory(detailMap);

		jsp = APPOINTMENT_CANCELLATION_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDAppointmentCancellationReport(HttpServletRequest request, HttpServletResponse response) {
		
		String fromDate = null;
		String toDate = null;
		int department = 0;
		int doctor = 0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		try {
			if (request.getParameter(VALID_FROM_DATE) != null &&

			!(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate

				= sdf.format(HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null &&

			!(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(

				request.getParameter(VALID_TO_DATE)));
			}
			query = " where app_patient_appointments.appointment_cancel_date between '"+ fromDate+ "' and '"+ toDate
					+ "' and app_patient_appointments.appointment_status = 'c' ";
					
			/*
			 * if(request.getParameter(REPORT_TYPE).equals("appointment")){
			 * query = " where app_patient_appointments.appointment_date between
			 * '"+ fromDate +"' and '"
			 *
			 *
			 *
			 * +toDate+"'and app_patient_appointments.`appointment_status` = 'c' "
			 * ; } if(request.getParameter(REPORT_TYPE).equals("cancellation")){
			 * query = " where
			 * app_patient_appointments.`appointment_cancel_date` between '"+
			 * fromDate +"'
			 *
			 * and '" +toDate+"' and
			 * app_patient_appointments.`appointment_status` = 'c' " ; }
			 */
			if (request.getParameter(DEPARTMENT_ID) != null &&

			!(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = query + " and  mas_department.department_id = "
						+ department;
			}
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals("0"))) {
				doctor = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				query = query + " and mas_employee.employee_id = " + doctor;
			}
			query = query + " and mas_hospital.hospital_id = " + hospitalId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
//LOGGER.info("can>>"+query);
		parameters.put("QUERY", query);

		try {
			byte[] bytes = null;
			try {
				bytes =

				JasperRunManager
						.runReportToPdf(
								getCompiledReport(APPOINTMENT_PATIENT_CANCELLATION_LIST),
								parameters, (Connection) detailsMap.

								get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			//response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ "app_patient_cancellation_list" + ".pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("index", "map", map);
		return null;
	}

	// ------------------------Report for Investigation
	// Cancellation------------------------------------------

	public ModelAndView showOPDInvestigationCancellationReportJsp(
			HttpServletRequest request, HttpServletResponse

			response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEquipmentDepartmentCategory(detailMap);
		jsp = APPOINTMENT_INVESTIGATION_CANCELLATION_LIST + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOPDInvestigationCancellationReport(
			HttpServletRequest request, HttpServletResponse

			response) {

		String fromDate = null;
		String toDate = null;
		int department = 0;
		int equip = 0;
		//int hos_id=0;
		String query = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			
			int hospitalId=0;
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			
			if (request.getParameter(VALID_FROM_DATE) != null &&

			!(request.getParameter(VALID_FROM_DATE).equals(""))) {
				fromDate

				= sdf.format(HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(VALID_FROM_DATE)));
			}
			if (request.getParameter(VALID_TO_DATE) != null &&

			!(request.getParameter(VALID_TO_DATE).equals(""))) {
				toDate = sdf.format(HMSUtil.convertStringTypeDateToDateType(

				request.getParameter(VALID_TO_DATE)));
			}

			query = " where app_investigation_appointments.investigation_cancel_date between '"
					+ fromDate
					+ "' and '"
					+ toDate
					+ "'and app_investigation_appointments.investigation_status = 'c' and mas_hospital.hospital_id="+hospitalId;

			/*
			 * if(request.getParameter(REPORT_TYPE).equals("appointment")){
			 * query = " where app_investigation_appointments.investigation_date
			 * between '"+ fromDate +"'
			 *
			 * and '" +toDate+"'and
			 * app_investigation_appointments.`investigation_status` = 'c' "; }
			 * if(request.getParameter(REPORT_TYPE).equals("cancellation")){
			 * query = " where
			 * app_investigation_appointments.investigation_cancel_date between
			 * '"+
			 *
			 * fromDate +"' and '" +toDate+"'and
			 * app_investigation_appointments.`investigation_status` = 'c' "; }
			 */

			if (request.getParameter(DEPARTMENT_ID) != null &&

			!(request.getParameter(DEPARTMENT_ID).equals("0"))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query = query + " and  mas_department.department_id = "
						+ department;
			}
			if (request.getParameter(EQUIPMENT_ID) != null &&

			!(request.getParameter(EQUIPMENT_ID).equals("0"))) {
				equip = Integer.parseInt(request.getParameter(EQUIPMENT_ID));
				query = query + " and app_equipment_master.equipment_id = "
						+ equip;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);

		try {
			byte[] bytes = null;
			try {
				bytes =
				JasperRunManager.runReportToPdf(
								getCompiledReport(APP_INVESTIGATION_CANCELLATION_LIST_REP),
								parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			//response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=app_investigation_cancelation_list" + ".pdf");
					
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("index", "map", map);
		return null;
	}

	// ----------------Print OPD Appointment Setup Day Wise
	// List-------------------------
	public ModelAndView showAppointmentSetupDayWiseReportJsp(
			HttpServletRequest request, HttpServletResponse response)

	{
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEmployeeDepartmentCategory(detailMap);
		jsp = APP_SETUP_DAY_WISE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAppointmentSetupDayWiseReport(
			HttpServletRequest request, HttpServletResponse	response) {

		int department = 0;
		String day = "";
		String query = "";
		int hospitalId=0;

		try {
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			if (request.getParameter(DAY) != null
					&& !(request.getParameter(DAY).equals("")) &&

					request.getParameter(DEPT_ID) != null
					&& !(request.getParameter(DEPT_ID).equals("0"))) {

				day = (request.getParameter(DAY));
				query = "where app_setup.days = '" + day + "'";

				department = Integer.parseInt(request.getParameter(DEPT_ID));
				query = query + " and app_setup.dept_id = " + department;
			} else if (request.getParameter(DAY) != null
					&& !(request.getParameter(DAY).equals(""))
					&&

					!(request.getParameter(DEPT_ID) != null && !(request
							.getParameter(DEPT_ID).equals("0")))) {
				day = (request.getParameter(DAY));
				query = "where app_setup.days = '" + day + "'";
			} else if (!(request.getParameter(DAY) == null && (request
					.getParameter(DAY).equals("")))
					&&

					request.getParameter(DEPT_ID) != null
					&& !(request.getParameter(DEPT_ID).equals("0"))) {
				department = Integer.parseInt(request.getParameter(DEPT_ID));
				query = query + "where app_setup.dept_id = " + department;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	/*	detailsMap = appointmentHandlerService.getConnectionForReport();*/
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		if(query.equals("")){
			query += " where mas_hospital.hospital_id= "+hospitalId;		
		}else{
			query += " and mas_hospital.hospital_id= "+hospitalId;
		}
		

		detailsMap = appointmentHandlerService.getConnectionForReport();
		
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));

				
		HMSUtil.generateReport(APP_SETUP_DAY_WISE_REP, parameters, (Connection) detailsMap
				.get("con"), response, getServletContext());

		return null;
		/*try {
			byte[] bytes = null;
			try {
				bytes =

				JasperRunManager.runReportToPdf(
						getCompiledReport(APP_SETUP_DAY_WISE_REP), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
		*/

	}

	// ----------------Print OPD Appointment Investigation Setup Day Wise
	// List-------------------------
	public ModelAndView showAppointmentInvestigationSetupDayWiseReportJsp(
			HttpServletRequest request,

			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailMap = new HashMap<String, Object>();
		int hospitalId=0;
		HttpSession session = request.getSession();

		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailMap.put("hospitalId", hospitalId);
		map = appointmentHandlerService.getEmployeeDepartmentCategory(detailMap);
		jsp = APP_INVEST_SETUP_DAY_WISE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAppointmentInvestigationSetupDayWiseReport(
			HttpServletRequest request,

			HttpServletResponse response) {

		int department = 0;
		String day = "";
		String query = "";

		int hospitalId=0;

		try {
			HttpSession session = request.getSession();

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			query="where  mas_hospital.hospital_id=  "+hospitalId;
			if (request.getParameter(DEPARTMENT_ID) != null &&

			!(request.getParameter(DEPARTMENT_ID).equals("0"))
					&& request.getParameter(DAY) != null &&

					!(request.getParameter(DAY).equals("0"))) {

				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query += " and app_investigation_setup.department_id = "
						+ department;
				day = (request.getParameter(DAY));
				query = query + " and app_investigation_setup.days = '" + day
						+ "'";
				

			}

			else if (request.getParameter(DEPARTMENT_ID) != null &&

			!(request.getParameter(DEPARTMENT_ID).equals("0"))
					&& !(request.getParameter(DAY) != null &&

					!(request.getParameter(DAY).equals("0")))) {
				department = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				query += " and app_investigation_setup.department_id = "
						+ department;
				
			} else if (request.getParameter(DAY) != null
					&& !(request.getParameter(DAY).equals("0"))
					&&

					!(request.getParameter(DEPARTMENT_ID) != null && !(request
							.getParameter(DEPARTMENT_ID).equals("0")))) {
				day = (request.getParameter(DAY));
				query = query + " and  app_investigation_setup.days = '"
						+ day + "'";
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		try {
			byte[] bytes = null;
			try {
				/*
				 * if(day.equals("") && department != 0) {
				 * parameters.put("QUERY","query"); bytes =
				 *
				 *
				 * JasperRunManager.runReportToPdf(getCompiledReport(
				 * APP_INVEST_SETUP_DAY_WISE_REP
				 * ),parameters,(Connection)detailsMap.get("con
				 *
				 * ")); } else {
				 */
				parameters.put("QUERY", query);

				bytes =

				JasperRunManager.runReportToPdf(
						getCompiledReport(APP_INVEST_SETUP_DAY_WISE_REP),
						parameters, (Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			//response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=app_invest_setup_day_wise" + ".pdf");
					//LOGGER.info(">>"+query);
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("index", "map", map);
		return null;
	}

	// ---------------------------Print Appointment slip
	// ------------------------------------------
	public ModelAndView printAppointmentSlip(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> requestParameters = new HashMap<String, Object>();
		String appointmentNo = null;
		String query = "";
		int hinId = 0;
		if (request.getParameter("hinId") != null &&	!(request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		
		 int hospitalId=0;
		 HttpSession session=request.getSession();
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				
			}
		try {
			if (request.getParameter("appointmentNo") != null &&

			!(request.getParameter("appointmentNo").equals(""))) {
				appointmentNo = (request.getParameter("appointmentNo"));
				query = "where app_patient_appointments.appointment_no = '"
						+ appointmentNo + "'";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sameHosp="";
		if(request.getParameter("sameHosp") !=null)
		{
			sameHosp =(String)request.getParameter("sameHosp");
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
	//	detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		String hospitalName="";
		hospitalName = registrationHandlerService.getHospitalName(hospitalId);
		parameters.put("hospitalName", hospitalName);
		parameters.put("QUERY", query);
        LOGGER.info("query "+query);
		detailsMap = appointmentHandlerService.getConnectionForReport();
		// parameters.put("toRefundDate",
		// HMSUtil.convertStringTypeDateToDateType(toDate));
//added by govind 11-01-2017
//		HMSUtil.generateReport("app_slip", parameters, (Connection) detailsMap
//				.get("con"), response, getServletContext());
//		return null;
		
		if(sameHosp.equalsIgnoreCase("y")){
			LOGGER.info("hinId--"+hinId);
			map.put("Report_Path", request.getContextPath()+"/Reports/"+"app_slip_sameHospital"+hinId+""+hospitalId+".pdf");
			HMSUtil.generateReportForDirectPrintPatient("app_slip_sameHospital", parameters, (Connection)detailsMap.get("con"), response, getServletContext(), getServletContext().getRealPath("/Reports/"),hinId,hospitalId);
		}else{
			map.put("Report_Path", request.getContextPath()+"/Reports/"+"app_slip"+hinId+""+hospitalId+".pdf");
		     HMSUtil.generateReportForDirectPrintPatient("app_slip", parameters, (Connection)detailsMap.get("con"), response, getServletContext(), getServletContext().getRealPath("/Reports/"),hinId,hospitalId);
		}
		return new ModelAndView("printReports", "map", map);
		//added by govind 11-01-2017 end


		/*try {
			byte[] bytes = null;
			try {
				bytes =

				JasperRunManager.runReportToPdf(
						getCompiledReport(APPOINTMENT_SLIP), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);*/
	}

	public ModelAndView printAppointmentSlipWebPortal(HttpServletRequest request,
			HttpServletResponse response) {
		//Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> requestParameters = new HashMap<String, Object>();
		String appointmentNo = null;
		String query = "";
		try {
			if (request.getParameter("appointmentNo") != null &&

			!(request.getParameter("appointmentNo").equals(""))) {
				appointmentNo = (request.getParameter("appointmentNo"));
				query = "where app_patient_appointments.appointment_no = '"
						+ appointmentNo + "'";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
        LOGGER.info("query "+query);
		detailsMap = appointmentHandlerService.getConnectionForReport();
	
		HMSUtil.generateReport("app_slip", parameters, (Connection) detailsMap.get("con"), response, getServletContext());
		return null;
	
	}
	// ---------------------------Print Appointment Investigation slip
	// ------------------------------------------
	public ModelAndView printAppointmentInvestigationSlip(
			HttpServletRequest request, HttpServletResponse response) {
		//Map<String, Object> map = new HashMap<String, Object>();
		//Map<String, Object> requestParameters = new HashMap<String, Object>();
		String appointmentNo = null;
		String query = "";
		try {
			if (request.getParameter("appointmentNo") != null &&

			!(request.getParameter("appointmentNo").equals(""))) {
				appointmentNo = (request.getParameter("appointmentNo"));
				query = "where app_investigation_appointments.investigation_appointment_no = '"
						+

						appointmentNo + "'";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = appointmentHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("QUERY", query);
		try {
			byte[] bytes = null;
			try {
				bytes =

				JasperRunManager.runReportToPdf(
						getCompiledReport(APPOINTMENT_INV_SLIP), parameters,
						(Connection) detailsMap.get("con"));

			} catch (JRException e) {

				e.printStackTrace();
			}
			//response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ APPOINTMENT_INV_SLIP + ".pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(bytes, 0, bytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		//return new ModelAndView("index", "map", map);
		return null;
	}

	/**
	 * ----------------------------------------------- END OF CLASS
	 * -------------------------------------
	 */
	//Added by Kishore for Online appoinment on 23rd mar 2015
	
		public ModelAndView showOnlineAppointment(HttpServletRequest request,
				HttpServletResponse response) {
			
			Map<String, Object> map = new HashMap<String, Object>();	
			String jsp = "onlineAppointment";
			jsp += ".jsp";
			map.put("contentJsp", jsp);

			return new ModelAndView("index", "map", map);
		
		}	
		
		 public boolean checkAppointmentDate(int minday,int maxday,String appointmentDate ) throws ParseException{
		    	

		    	
	    	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		     Date minimdate = sdf.parse(appointmentDate);
		     LOGGER.info("appointmentDate "+sdf.format(minimdate));
		     
		     Calendar cal = Calendar.getInstance();
		      
		        //adding one day to current date
		        cal.add(Calendar.DAY_OF_MONTH, minday);
		        Date mintommrrow = cal.getTime();
		        LOGGER.info(sdf.format(mintommrrow) );
		       
		        
		        
		        Calendar cal1 = Calendar.getInstance();
		        cal1.add(Calendar.DAY_OF_MONTH, maxday);
		        Date maxtommrrow = cal1.getTime();
		        
		        LOGGER.info("maxtommrrow"+sdf.format(maxtommrrow)  );
		        cal1.add(Calendar.DAY_OF_MONTH, maxday+1);
		        //Date nextmaxtommrrow = cal1.getTime();
		        LOGGER.info(sdf.format(maxtommrrow)  );
		        
		        
		       /* if (minimdate .after(mintommrrow)
						&& maxtommrrow.before(minimdate)) {
		        	 
					
					LOGGER.info("###true");
					return true;
	 
				}
		        */
		        
		        if (minimdate.before(maxtommrrow)) {
		        	 
					
					LOGGER.info("true");
					return true;
	 
				}else {
	 
					LOGGER.info("false");
					return false;
	 
				}

	       
	    
	    }
		 
		 /**
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		 
		public void populatePatientinvestigation(HttpServletRequest request,
					HttpServletResponse response) throws IOException{
			 
			 Map<String,Object> map=new HashMap<String,Object>();
			 
			 String UhidNo=request.getParameter("uhidNo");
			 int orderId=Integer.parseInt(request.getParameter("orderId"));
			 
			 
			 int hospitalId=0;
			 HttpSession session=request.getSession();
				
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					
				}
			 
			 map=appointmentHandlerService.populatePatientinvestigation(UhidNo,orderId,hospitalId);
			 
			// List<DgSampleCollectionDetails>  sampleCollectionDetails=new ArrayList<DgSampleCollectionDetails>();
			 
			// List<DgOrderhd> dgOrderhdList=new ArrayList<DgOrderhd>();
			 List<DgOrderdt> dgOrderdtList=new ArrayList<DgOrderdt>();
			 
			/* if(null !=map.get("sampleCollectionDetails")){
				 sampleCollectionDetails=(List<DgSampleCollectionDetails> )map.get("sampleCollectionDetails");
			 }*/
			 if(null !=map.get("dgOrderdtList")){
				 dgOrderdtList=( List<DgOrderdt> )map.get("dgOrderdtList");
			 }
			 
			 String patientName="";
			 if(null !=map.get("patientName")){
				 patientName=(String)map.get("patientName");
			 }
			 
			 StringBuffer sb = null;
				sb = new StringBuffer();
				
				
				if(null !=dgOrderdtList && dgOrderdtList.size()>0 ){
					for(DgOrderdt dgOrderdt:dgOrderdtList)
					{
						
						sb.append("<item>");
						sb.append("<dgOrderdtId>"+dgOrderdt.getId() + "</dgOrderdtId>");
						sb.append("<dgOrderName>"+dgOrderdt.getChargeCode().getChargeCodeName()+ "</dgOrderName>");
						
						
						sb.append("</item>");
					}
				}
				else{
					sb.append("<item>");
					;
					sb.append("<dgOrderdtId>" +""+"</dgOrderdtId>");
					sb.append("<dgOrderName>"+""+ "</dgOrderName>");
					sb.append("</item>");
				}
				

				
				/*
				if(null !=sampleCollectionDetails && sampleCollectionDetails.size()>0 ){
					for(DgSampleCollectionDetails sampleCollectionH:sampleCollectionDetails)
					{
						
						sb.append("<item>");
						sb.append("<dgSampleDetailsId>"+sampleCollectionH.getId() + "</dgSampleDetailsId>");
						sb.append("<investigationName>"+sampleCollectionH.getInvestigation().getInvestigationName()+ "</investigationName>");
						
						sb.append("<patientName>"+patientName + "</patientName>");
						sb.append("</item>");
					}
				}
				else{
					sb.append("<item>");
					sb.append("<patientName>"+patientName + "</patientName>");
					sb.append("<dgSampleDetailsId>" +""+"</unitId>");
					sb.append("<investigationName>"+""+ "</investigationName>");
					sb.append("</item>");
				}
				
*/
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			LOGGER.info(sb.toString());

		 }
	
		 /**
		 * @param request
		 * @param response
		 * @throws IOException
		 */
		public void populateInvestigationOrder(HttpServletRequest request,
					HttpServletResponse response) throws IOException{
			 
			 Map<String,Object> map=new HashMap<String,Object>();
			 
			 int departmentId=0;
			 String UhidNo=request.getParameter("uhidNo");
			/*  departmentId=Integer.parseInt(request.getParameter("departmentId"));
			 LOGGER.info("departmentId "+departmentId);*/
			 
			 int hospitalId=0;
			 HttpSession session=request.getSession();
				
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					
				}
			 
			 map=appointmentHandlerService.populateInvestigationOrder(UhidNo,departmentId,hospitalId);
			 
			 List<DgSampleCollectionDetails>  sampleCollectionDetails=new ArrayList<DgSampleCollectionDetails>();
			 
			 List<DgOrderhd> dgOrderhdList=new ArrayList<DgOrderhd>();
			 
			 if(null !=map.get("sampleCollectionDetails")){
				 sampleCollectionDetails=(List<DgSampleCollectionDetails> )map.get("sampleCollectionDetails");
			 }
			 if(null !=map.get("dgOrderhdList")){
				 dgOrderhdList=( List<DgOrderhd> )map.get("dgOrderhdList");
			 }
			 
			 String patientName="";
			 if(null !=map.get("patientName")){
				 patientName=(String)map.get("patientName");
			 }
			 
			 StringBuffer sb = null;
				sb = new StringBuffer();
				
				
				if(null !=dgOrderhdList && dgOrderhdList.size()>0 ){
					for(DgOrderhd dgOrderhd:dgOrderhdList)
					{
						
						sb.append("<item>");
						sb.append("<dgOrderHdId>"+dgOrderhd.getId() + "</dgOrderHdId>");
						sb.append("<dgOrderNo>"+dgOrderhd.getOrderNo()+ "</dgOrderNo>");
						
						sb.append("<patientName>"+patientName + "</patientName>");
						sb.append("</item>");
					}
				}
				else{
					sb.append("<item>");
					sb.append("<dgOrderHdId>"+patientName + "</dgOrderHdId>");
					sb.append("<dgOrderNo>" +""+"</dgOrderNo>");
					sb.append("<dgOrderHdId>"+""+ "</dgOrderHdId>");
					sb.append("</item>");
				}
				

				
				/*
				if(null !=sampleCollectionDetails && sampleCollectionDetails.size()>0 ){
					for(DgSampleCollectionDetails sampleCollectionH:sampleCollectionDetails)
					{
						
						sb.append("<item>");
						sb.append("<dgSampleDetailsId>"+sampleCollectionH.getId() + "</dgSampleDetailsId>");
						sb.append("<investigationName>"+sampleCollectionH.getInvestigation().getInvestigationName()+ "</investigationName>");
						
						sb.append("<patientName>"+patientName + "</patientName>");
						sb.append("</item>");
					}
				}
				else{
					sb.append("<item>");
					sb.append("<patientName>"+patientName + "</patientName>");
					sb.append("<dgSampleDetailsId>" +""+"</unitId>");
					sb.append("<investigationName>"+""+ "</investigationName>");
					sb.append("</item>");
				}
				
*/
			
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(
					"<?xml version='1.0' encoding='ISO-8859-1'?>");
			response.getWriter().write("<items>");
			response.getWriter().write(sb.toString());
			response.getWriter().write("</items>");
			LOGGER.info(sb.toString());

		 }
	
		 public void getAppDetails(HttpServletRequest request,
					HttpServletResponse response) throws IOException {
				
				Map<String, Object> map = new HashMap<String, Object>();	
				int deptId=0;
				int hospitalId=0;
				int sessionId = 0;
				if(request.getParameter("deptId")!=null && !request.getParameter("deptId").equals("0")){
					deptId=Integer.parseInt(request.getParameter("deptId"));
				}
				if(request.getParameter("sessionId")!=null && !request.getParameter("sessionId").equals("")){
					sessionId=Integer.parseInt(request.getParameter("sessionId"));
				}
				HttpSession session=request.getSession();
				Box box = HMSUtil.getBox(request);
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				List<AppSetup> appSetupList = new ArrayList<AppSetup>();
				LOGGER.info("deptId "+deptId+" hospitalId "+hospitalId);
				map=appointmentHandlerService.getAppDetails(deptId,hospitalId,sessionId);				
				
				if(null !=map.get("setupList")){
					appSetupList=(List<AppSetup>)map.get("setupList");
				}
				StringBuffer sb = null;
				sb = new StringBuffer();
				
				String tokenStartNo1="";
		    	 String tokenInterval1="";
		    	 String totalToken1="";
		    	 String maxNo1="";
		    	 String minNo1="";
		    	 String numberOfPatients1="";
				if(null !=appSetupList && appSetupList.size()>0 ){
					for(AppSetup appSetup:appSetupList)
					{
						tokenStartNo1="";
				    	  tokenInterval1="";
				    	  totalToken1="";
				    	  maxNo1="";
				    	  minNo1="";
				    	  numberOfPatients1="";
						
			     		if(null !=appSetup.getStartToken()){
			     	 	tokenStartNo1=String.valueOf(appSetup.getStartToken());
			     		}else{
			     			tokenStartNo1="";
			     		}
			     		if(null !=appSetup.getTotalInterval()){
			     			tokenInterval1=String.valueOf(appSetup.getTotalInterval());
			         		}else{
			         			tokenInterval1="";
				     		}
			     		if(null !=appSetup.getTotalToken()){
			     			totalToken1=String.valueOf(appSetup.getTotalToken());
			         		}else{
			         			totalToken1="";
				     		}
			     		if(null !=appSetup.getMaxNoOfDays() && appSetup.getMaxNoOfDays()>0){
			     			maxNo1=String.valueOf(appSetup.getMaxNoOfDays());
			         		}else{
			         			maxNo1="";
				     		}
			     		if(null !=appSetup.getMinNoOfDays() && appSetup.getMinNoOfDays()>0){
			     			minNo1=String.valueOf(appSetup.getMinNoOfDays());
			         		}else{
			         			minNo1="";
				     		}
			     		if(null !=appSetup.getNumberOfPatients() && appSetup.getNumberOfPatients()>0){
			     			numberOfPatients1=String.valueOf(appSetup.getNumberOfPatients());
			         		}else{
			         			numberOfPatients1="";
				     		}
			     		
						sb.append("<item>");
						sb.append("<appId>"+appSetup.getId() + "</appId>");
						sb.append("<tokenStartNo>"+tokenStartNo1+ "</tokenStartNo>");
						sb.append("<tokenInterval>"+tokenInterval1 + "</tokenInterval>");
						sb.append("<totalToken>"+totalToken1+ "</totalToken>");
						sb.append("<maxDaysNo>"+maxNo1 + "</maxDaysNo>");
						sb.append("<minDaysNo>"+minNo1+ "</minDaysNo>");
						sb.append("<numberOfPatients>"+numberOfPatients1+ "</numberOfPatients>");
						
						
						sb.append("</item>");
						 
					}
				}
				else{
					for(int i=0; i<7;i++){
					sb.append("<item>");
					
					sb.append("<appId>"+"" + "</appId>");
					sb.append("<tokenStartNo>"+""+ "</tokenStartNo>");
					sb.append("<tokenInterval>"+"" + "</tokenInterval>");
					sb.append("<totalToken>"+""+ "</totalToken>");
					sb.append("<maxDaysNo>"+"" + "</maxDaysNo>");
					sb.append("<minDaysNo>"+""+ "</minDaysNo>");
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
			LOGGER.info(sb.toString());

				
			
			}	
		 public ModelAndView ShowDialysisSchedulingSetUpJsp(HttpServletRequest request,
				HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId;
				Box box = HMSUtil.getBox(request);

				HttpSession session = request.getSession();
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				if(session.getAttribute("deptId")!=null)
				{
					box.put(DEPARTMENT_ID, (Integer) session.getAttribute("deptId"));
				}
				
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				map = appointmentHandlerService.ShowDialysisSchedulingSetUpJsp(box);
				map.put("deptIdinMap", box.getInt(DEPARTMENT_ID));

				map.put("drIdinMap", box.getInt(RequestConstants.CONSULTING_DOCTOR));
				jsp = "dialysisSchedulingSetup";
				jsp += ".jsp";
				title = "Appointment Setup";
				map.put("contentJsp", jsp);
				map.put("title", title);
			return new ModelAndView("index", "map", map);
		
		}
		 public ModelAndView submitDialysisSetup(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId;
				//String userName = "";
				String message = null;
				int deptId = 0;
				boolean dataSaved = false;
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				if (session.getAttribute("users") != null) {
					Users users = (Users) session.getAttribute("users");
					box.put("usersId", users.getId());
				}
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					box.put("deptId", deptId);
				}
				
				String drName="";
				if (request.getParameter("drName") != null) {
					drName = (String) request.getParameter("drName");
					//LOGGER.info("drName--Con---->>"+drName);
				}
				
				map = appointmentHandlerService.submitDialysisSetup(box);
				if(map.get("dataSaved") != null){
					dataSaved =(Boolean) map.get("dataSaved");
				}
				if (dataSaved == true) {
					message = "Data Successfully Saved !!";

				} else {
					message = "Data cannot be saved !!";
				}
				map = appointmentHandlerService.ShowDialysisSchedulingSetUpJsp(box);
				
				int wardId=0;
				wardId = box.getInt(WARD_ID);
				map.put("drName", drName);
				map.put("deptIdinMap", wardId);
			//	LOGGER.info("ward id------------In submit-->>"+wardId);
				
				
				int drId=0;
				drId = box.getInt("drId");
				
				map.put("drIdinMap", drId);
				//LOGGER.info("dr id------------In submit-->>"+drId);
				
				map.put("message", message);
				jsp = "dialysisSchedulingSetup";
				jsp += ".jsp";
				title = "Appointment Setup";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
		 public ModelAndView updateDialysisSetup(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId;
				//String userName = "";
				String message = null;
				boolean dataSaved = false;
				Box box = HMSUtil.getBox(request);
				HttpSession session = request.getSession();
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				if (session.getAttribute("users") != null) {
					Users users = (Users) session.getAttribute("users");
					box.put("usersId", users.getId());
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
					box.put("deptId", deptId);
				}
				
				String drName="";
				if (request.getParameter("drName") != null) {
					drName = (String) request.getParameter("drName");
				//	LOGGER.info("drName--Con---->>"+drName);
				}

				
				
				map = appointmentHandlerService.updateDialysisSetup(box);
				if(map.get("dataSaved") != null){
					dataSaved =(Boolean) map.get("dataSaved");
				}
				if (dataSaved == true) {
					message = "Data Successfully Saved !!";
					map = appointmentHandlerService.ShowDialysisSchedulingSetUpJsp(box);
				} else {
					message = "Data cannot be saved !!";
				}
				map.put("message", message);
				
				map.put("drName", drName);
				map.put("deptIdinMap", box.getInt(WARD_ID));
				
			//	LOGGER.info("Ward Id----update --COn-->"+box.getInt(WARD_ID));
				
				map.put("drIdinMap", box.getInt("drId"));
				
			//	LOGGER.info("dr Id---update ---COn-->"+box.getInt("drId"));
				
				
				
				jsp = "dialysisSchedulingSetup";
				jsp += ".jsp";
				title = "Appointment Setup";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
		 
		 
		 public ModelAndView showDialysisSchedulingJsp(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				int deptId = 0;
				int hospitalId = 0;
				
				//Box box=HMSUtil.getBox(request);

				HttpSession session = request.getSession();
				synchronized (session) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				}
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
				}

				map = appointmentHandlerService.showDialysisSchedulingJsp(deptId, hospitalId);

			
				String jsp = "dialysisScheduling";
				jsp += ".jsp";
				map.put("contentJsp", jsp);

				return new ModelAndView("index", "map", map);
				
				
			}
		/*
			public ModelAndView saveOnlineAppointment(HttpServletRequest request,HttpServletResponse response){
				Map<String, Object> map = new HashMap<String, Object>();
				
				int hospitalId = 0;
				int departmentId = 0;
				HttpSession session = request.getSession();
				Box box=HMSUtil.getBox(request);
				departmentId=box.getInt("department");
				int tokenNo=0;
				
				
				synchronized (session) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				int maxTokenNo = 0;
				int visitSession=0;
				maxTokenNo = registrationHandlerService
						.getTokenNoForDepartment(departmentId, hospitalId,visitSession);
				tokenNo = maxTokenNo + 1;
				box.put("tokenNo", tokenNo);
				
				map = registrationHandlerService.saveOnlineAppointment(box);
				
				String jsp = "onlineAppointment";
				jsp += ".jsp";
				map.put("contentJsp", jsp);

				return new ModelAndView("index", "map", map);
				
			}*/

			public ModelAndView getPriorityQueueByDepartIdDialysis(HttpServletRequest request,
					HttpServletResponse response) {
				
				
				HttpSession session = request.getSession();
				Map<String, Object> map = new HashMap<String, Object>();
							
				Box box = HMSUtil.getBox(request);
				
				int hospitalId=0;
				int departmentId =0;
				if (session.getAttribute("deptId") != null) {
					departmentId = (Integer) session.getAttribute("deptId");
				}
				String appointmentDate=box.getString("appointmentDate");
				
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					
				}
				box.put("hospitalId", hospitalId);
				box.put("appointmentDate", appointmentDate);
				box.put("departmentId", departmentId);
				int consultId=0;
				
				map = appointmentHandlerService.getPriorityQueueByDepartIdDialysis(box);
				if(map.get("consultId") !=null){
					consultId=(Integer)map.get("consultId") ;
				}
				
				//map = appointmentHandlerService.getPriorityQueueByDepartIdDialysis(departmentId,hospitalId,appointmentDate);
				
			/*	if(map.get("queueList")!=null){
					queueList=(List<Integer>)map.get("queueList");
				}*/
				
				return new ModelAndView("responseDialysisScheduling", "map", map);
					}
		 
			
			public ModelAndView submitDialysisScheduling(HttpServletRequest request,
					HttpServletResponse response) throws ParseException {
				Map<String, Object> map = new HashMap<String, Object>();
				Map<String, Object> detailsMap = new HashMap<String, Object>();
				Box box = HMSUtil.getBox(request);
				int hospitalId=0;
				String userName = "";
				String message = null;
				String appointmentNo = null;
				String flag = "appointment";
				
				
				boolean uhidStatus=true;
				int departmentId = box.getInt("department");
				
				//String appointmentDate = box.get("appointmentDate");
				String appointmentDays = box.getString("appointmentDays");
	
				String mobileNo = box.get("mob");
				
				String serviceNo = box.getString(SERVICE_NO);
				
				
				String hinId = box.getString("uhid");
				String url = null;

				boolean dataSaved = false;
				boolean duplicateRecord = false;
				
				boolean patientNameExist=false;
				boolean recordExists=false;
				
			
				HttpSession session = request.getSession();
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					box.put("hospitalId", hospitalId);
				}
				box.put("departmentId", departmentId);
				if (session.getAttribute(LOGIN_NAME) != null) {
					userName = (String) session.getAttribute(LOGIN_NAME);
					box.put("userName", userName);
				}
				
				Users user= null;
				if (session.getAttribute("users") != null) {
					user = (Users) session.getAttribute("users");
					box.put("userId", user.getId());
				}
				detailsMap.put("hospitalId", hospitalId);
				String t="";
				if (request.getParameter(TOTIMESLOT) != null) {
					t = (String) request.getParameter(TOTIMESLOT);
					
				}
				box.put("TOTIMESLOT", t);
				String f="";
				if (request.getParameter(FROMTIMESLOT) != null) {
					f = (String) request.getParameter(FROMTIMESLOT);
				}
				box.put("FROMTIMESLOT", f);
				map = appointmentHandlerService.submitDialysisScheduling(box);
				
				if(null!=map.get("dataSaved"))
				dataSaved = (Boolean) map.get("dataSaved");
				if(null!=map.get("duplicateRecord"))
				duplicateRecord = (Boolean) map.get("duplicateRecord");
				if(null!=map.get("appointmentNo"))
				appointmentNo = (String) map.get("appointmentNo");
				
				if(null!=map.get("patientNameExist"))
				 patientNameExist = (Boolean) map.get("patientNameExist");
				
				if(null!=map.get("recordExists"))
				 recordExists = (Boolean) map.get("recordExists");
				 
				
				
				if (dataSaved == true) {
					message = "Data Save sucessfully!";
					url = "submitForm('messageForm','appointment?method=ShowDialysisSchedulingSetUpJsp');";
					map.put("url", url);
					map.put("message", message);
					map.put("duplicateRecord", duplicateRecord);
					jsp = "dialysisSchedulingMsg";

				}  else if (duplicateRecord == false && recordExists == true) {
					message = (String) map.get("message");
					map = appointmentHandlerService.ShowDialysisSchedulingSetUpJsp(box);
					map.put("fromTimeSlot", f);
					map.put("toTimeSlot", t);
					box.put("departmentId", departmentId);
					map.put("appointmentDays", appointmentDays);
					/*map.put("patientName", patientName);
					map.put("sex", sex);*/
					/*map.put("age", age);
					map.put("ageUnit", ageUnit);*/
					map.put("mobileNo", mobileNo);
					map.put("serviceNo", serviceNo);
					map.put("hinId", hinId);
					map.put("message", message);
			
					
					jsp = "dialysisScheduling";
				} else {
					if (patientNameExist == false && recordExists == false) {
						//message = "Data cannot be saved !!";
						message = "UHID is not Valid ";
						uhidStatus=false;
					}
					map = appointmentHandlerService.ShowDialysisSchedulingSetUpJsp(box);
					map.put("fromTimeSlot", f);
					map.put("toTimeSlot", t);
					map.put("departmentId", departmentId);
					map.put("appointmentDays", appointmentDays);
						map.put("mobileNo", mobileNo);
					map.put("serviceNo", serviceNo);
					map.put("hinId", hinId);
					
					map.put("message", message);
					jsp = "dialysisSchedulingMsg";
				}
				// -----------------------Vishal Code Start----------
				map.put("flag", flag);
				map.put("appointmentNo", appointmentNo);
				// -----------------------Vishal Code End----------
				map.put("patientNameExist", patientNameExist);
				map.put("recordExists", recordExists);
						
				jsp += ".jsp";
				title = "Appointment Setup";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("uhidStatus", uhidStatus);
				return new ModelAndView("index", "map", map);
			}
			
			/**
			 * @param request
			 * @param response
			 * @return
			 * @throws IOException 
			 * @throws JSONException 
			 */
			
			public ModelAndView getPriorityQueueByDepartIdOtherHosp(HttpServletRequest request,
					HttpServletResponse response) {
				
				
				Map<String, Object> map = new HashMap<String, Object>();
				//Map<String, Object> detailsMap = new HashMap<String, Object>();
				
				List<Integer> queueList=new ArrayList<Integer>();
				
				Box box = HMSUtil.getBox(request);
				
				int hospitalId=0;
				int departmentId = box.getInt("department");
				String appointmentTime = null;
				String appointmentDate=null;
				if(box.getString("appointmentDate")!=null && !box.getString("appointmentDate").equals("")){
					appointmentDate =box.getString("appointmentDate");
				}
				if(box.getString("appointmentTime")!=null && !box.getString("appointmentTime").equals("")){
					appointmentTime =box.getString("appointmentTime");
				}
				String visitTime = box.getString("visitTime");
				String appointmentType="";
				if(null !=request.getParameter("hospitalName") && !request.getParameter("hospitalName").equals("")){
					hospitalId = Integer.parseInt(request.getParameter("hospitalName"));

				}
				int sessionId = box.getInt("opsession");
				LOGGER.info("hospitalId  "+hospitalId);
				map = appointmentHandlerService.getPriorityQueueByDepartId(departmentId,hospitalId,appointmentDate,appointmentTime,visitTime);
				
				if(map.get("queueList")!=null){
					queueList=(List<Integer>)map.get("queueList");
				}
				
				return new ModelAndView("otherResponseOnlineAppointmentNo", "map", map);
					}

			//method added by Om Tripathi 2/8/2017
			
			public ModelAndView getPriorityQueueByDepartment(HttpServletRequest request,
					HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<Integer> queueList=new ArrayList<Integer>();
				
				Box box = HMSUtil.getBox(request);
				
				int hospitalId=0;
				int doctorId=0;
				Integer departmentId = Integer.parseInt(request.getParameter("department"));
				String appointmentDate=request.getParameter("appointmentDate");
				hospitalId = Integer.parseInt(request.getParameter(HOSPITAL_ID));
				//String appointmentDate=box.getString("appointmentDate");
				String visitTime = box.getString("visitTime");
				String appointmentTime=null;
				String uhid= request.getParameter("uhid");
				HttpSession session = request.getSession();
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					
				}
				if (session.getAttribute("consultingDoctor") != null) {
					doctorId = (Integer) session.getAttribute("consultingDoctor");
					
				}
				int sessionId = box.getInt("opsession");
				map = appointmentHandlerService.getPriorityQueueByDepartId(departmentId,hospitalId,appointmentDate,appointmentTime,visitTime);
				
				if(map.get("queueList")!=null){
					queueList=(List<Integer>)map.get("queueList");
				}
				map.put("departmentId", departmentId);
				map.put("hospitalId", hospitalId);
				map.put("appointmentDate", appointmentDate);
				map.put("docorId", doctorId);
				//LOGGER.info("department id"+map.get("departmentId") +"Doctor Id"+doctorId+"appointmentDate"+appointmentDate+"hospitalId"+hospitalId);
				map.put("uhid", uhid);
				return new ModelAndView("responseOnlineAdvancedAppointmentNo", "map", map);
		}
			
			// added by amit das on 10-08-2017
			public void saveClientAppointmentPatientToServer(HttpServletRequest request,
					HttpServletResponse response){
				Map<String, Object> map = new HashMap<String, Object>();  
				Box box=HMSUtil.getBox(request);
				map=appointmentHandlerService.saveClientAppointmentPatientToServer(box);
				PrintWriter printWriter;
				try {
					printWriter = response.getWriter();
				
				
				if(map.get("success")!=null){
					printWriter.write("success");
				}else{
					printWriter.write("faliure");
				} 
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}

			public void getServiceCentreSession(HttpServletRequest request,
					HttpServletResponse response) {

				LOGGER.info("in doc Unit !");

				Map<String, Object> map = new HashMap<String, Object>();
				int hospitalId=0;
				if(request.getParameter("hospitalId")!=null){
					hospitalId=Integer.parseInt(request.getParameter("hospitalId"));
				}
				String appointmentDate=request.getParameter("appointmentDate");
				int departmentId=Integer.parseInt(request.getParameter("departmentId"));
				map.put("departmentId", departmentId);
				map.put("hospitalId", hospitalId);
				map.put("appointmentDate", appointmentDate);
				Box box = HMSUtil.getBox(request);
				map=appointmentHandlerService.getServiceCentreWiseSession(box);
				List<Object[]> sessionList = new ArrayList<Object[]>();
				List<Object[]> hospitalSessionList = new ArrayList<Object[]>();
				if (map.get("sessionList") != null) {
					sessionList = (List<Object[]>) map.get("sessionList");
			 	}
				if (map.get("hospitalSessionList") != null) {
					hospitalSessionList = (List<Object[]>) map.get("hospitalSessionList");
			 	}
				List<String> list=new ArrayList<String>();
				for(Object[] obj :hospitalSessionList){
					list.add(obj[0]+":"+obj[1]);
				}
				for(Object[] obj :sessionList){
					list.add(obj[0]+":"+obj[1]);
				}
				try {
					PrintWriter out=response.getWriter();
					out.print(list);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
					
			
			// added by amit das on 22-08-2017
			public void updateClientAppointmentPatientToServer(HttpServletRequest request,
								HttpServletResponse response){
							Map<String, Object> map = new HashMap<String, Object>();  
							//Box box=HMSUtil.getBox(request);
							//map=appointmentHandlerService.updateClientAppointmentPatientToServer(box);  commentted by om tripathi
							PrintWriter printWriter;
							try {
								printWriter = response.getWriter();
							
							
							if(map.get("success")!=null){
								printWriter.write("success");
							}else{
								printWriter.write("faliure");
							} 
							} 
							catch (IOException e) {
								e.printStackTrace();
							}
							
			}
			
public void getDoctorUnit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId = 0;
		if (request.getParameter("hospitalId") != null) {
			hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		}
		String appointmentDate = request.getParameter("appointmentDate");
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		map.put("departmentId", departmentId);
		map.put("hospitalId", hospitalId);
		map.put("appointmentDate", appointmentDate);
		if (request.getParameter("personalReview") != null
				&& request.getParameter("personalReview").equalsIgnoreCase(
						"yes")) {
			map.put("personalReview", "yes");
			if (session.getAttribute("empId") != null) {
				map.put("doctor", session.getAttribute("empId"));
			}

		}
		map = appointmentHandlerService.getDoctorUnit(map);
		@SuppressWarnings("unchecked")
		List<HospitalDoctorUnitM> unitList = (List<HospitalDoctorUnitM>) map.get("unitList");
		PrintWriter out = response.getWriter();

		if (request.getParameter("personalReview") != null
				&& request.getParameter("personalReview").equalsIgnoreCase("yes")) {
			Map<String, String> unitMap = new HashMap<String, String>();

			String unitStr = "";String days=null;
			for (HospitalDoctorUnitM unit : unitList) {
				unitStr = unit.getId() + ":" + unit.getUnitCode();
				days=unit.getMonday()!= null && unit.getMonday().equalsIgnoreCase("y")?"1#":"";
				days+= unit.getTuesday()!=null && unit.getTuesday().equalsIgnoreCase("y")?"2#":"";
				days+=unit.getWednesday()!=null&&unit.getWednesday().equalsIgnoreCase("y")?"3#":"";
				days+=unit.getThursday()!=null&&unit.getThursday().equalsIgnoreCase("y")?"4#":"";
				days+=unit.getFriday()!=null&&unit.getFriday().equalsIgnoreCase("y")?"5#":"";
				days+=unit.getSaturday()!=null&&unit.getSaturday().equalsIgnoreCase("y")?"6#":"";
				days+=unit.getSunday()!=null&&unit.getSunday().equalsIgnoreCase("y")?"7":"";
				unitMap.put("days", days.trim());
			}
			unitMap.put("unit", unitStr);
			
			if (map.get("message") != null) {
				unitMap.put("message", String.valueOf(map.get("message")));
			}
			Gson gsonObj = new Gson();
			String jsonStr = gsonObj.toJson(unitMap);
			out.print(jsonStr);
		} else {
			List<String> list = new ArrayList<String>();
			for (HospitalDoctorUnitM unit : unitList) {
				list.add(unit.getId() + ":" + unit.getUnitCode());
			}
			out.print(list);
		}

	}

	public void getCounterTimingForDepartment(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);

		String appointmentType = null;
		if (box.getString("appointType") != null) {
			appointmentType = box.getString("appointType");
		}
		
		int departmentId=0;
		int hospitalId = 0;
		if(box.getInt("department")>0){
			departmentId = box.getInt("department");			
		}

		HttpSession session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		map = appointmentHandlerService.getCounterTimingForDepartment(departmentId, hospitalId);
		List<String> list=new ArrayList<String>();
		if(map.get("openTime")!=null && !"".equals(map.get("openTime")) && map.get("closeTime")!=null && !"".equals(map.get("closeTime"))){
			String openTime = (String)map.get("openTime");
			String closeTime = (String)map.get("closeTime");
			String[] open= openTime.split(":"); 
			String[] close = closeTime.split(":");
			int startTime = Integer.parseInt(open[0]);
			String times=null;
			for(int i=0;i<(Integer.parseInt(close[0])-Integer.parseInt(open[0]));i++){
				times= (startTime+i)+":"+(startTime+i)+"-"+(startTime+i+1);
				list.add(times);
			}
		}
		
		LOGGER.info("timings  "+list);
		PrintWriter out=response.getWriter();
		out.print(list);

	}
	// To get Session based on Service Center
		public void getSessionForDepartment(final HttpServletRequest request, final HttpServletResponse response)
				throws IOException {

			LOGGER.debug("Inside getSessionForDepartment in appointment ");
			HttpSession session = request.getSession();
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int deptId = Integer.parseInt(request.getParameter("deptId"));
			String appointmentTime = (String)(request.getParameter("appointmentTime"));
			List<String> masSessionList = appointmentHandlerService.getSessionForDepartment(deptId, hospitalId,appointmentTime);
			PrintWriter out = response.getWriter();
			out.print(masSessionList);
		}
		
		public void getCounterTimingForDepartmentNew(HttpServletRequest request,
				HttpServletResponse response) throws IOException {

			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);

			String appointmentType = null;
			if (box.getString("appointType") != null) {
				appointmentType = box.getString("appointType");
			}
			
			int departmentId=0;
			int hospitalId = 0;
			if(box.getInt("department")>0){
				departmentId = box.getInt("department");			
			}

			HttpSession session = request.getSession();
			
			if(StringUtils.isNotBlank(request.getParameter("hospitalId"))){
				hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
			}else if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			map = appointmentHandlerService.getCounterTimingForDepartment(departmentId, hospitalId);
			Map<String,String> timingSlotMap = new LinkedHashMap<String,String>();
			if(map.get("openTime")!=null && !"".equals(map.get("openTime")) && map.get("closeTime")!=null && !"".equals(map.get("closeTime"))){
				String openTime = (String)map.get("openTime");
				String closeTime = (String)map.get("closeTime");
				String[] open= openTime.split(":"); 
				String[] close = closeTime.split(":");
				int startHour = Integer.parseInt(open[0]);
				String startMinutes = open[1];
				for(int i=0;i<(Integer.parseInt(close[0])-Integer.parseInt(open[0]));i++){
					
					String timeSlot = HMSUtil.convertTimeSlotRangeTo12HourFormat((startHour+i)+":"+startMinutes);
					timingSlotMap.put((startHour+i)+":"+startMinutes, timeSlot);
				}
			}
			
			PrintWriter out=response.getWriter();
			out.print(timingSlotMap);

		}
}
