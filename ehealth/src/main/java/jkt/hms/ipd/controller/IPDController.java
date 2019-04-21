package jkt.hms.ipd.controller;

import static jkt.hms.util.RequestConstants.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.ipd.handler.IPDHandlerService;
import jkt.hms.masters.business.BioWasteDisposal;
import jkt.hms.masters.business.BioWasteHandOver;
import jkt.hms.masters.business.Birthdeathreg;
import jkt.hms.masters.business.BlDispensingDetails;
import jkt.hms.masters.business.BlFinalBillDetails;
import jkt.hms.masters.business.DgOrderdt;
import jkt.hms.masters.business.DischargeIcdCode;
import jkt.hms.masters.business.EmpAfmsfDet;
import jkt.hms.masters.business.HospitalParameters;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.InpatientDocument;
import jkt.hms.masters.business.InpatientPrescriptionDetails;
import jkt.hms.masters.business.IpdGatepassDetails;
import jkt.hms.masters.business.LaborRoom;
import jkt.hms.masters.business.LrFetalDetails;
import jkt.hms.masters.business.LrInduction;
import jkt.hms.masters.business.LrProcedureDone;
import jkt.hms.masters.business.LrDilatationDescent;
import jkt.hms.masters.business.LrContraction;
import jkt.hms.masters.business.LrPulseBp;
import jkt.hms.masters.business.LrTemperature;
import jkt.hms.masters.business.LrUrineAnalysis;
import jkt.hms.masters.business.MasAdministrativeSex;
import jkt.hms.masters.business.MasChargeCode;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasWasteDisposal;
import jkt.hms.masters.business.OneToOne;
import jkt.hms.masters.business.OpdAntenatalCard;
import jkt.hms.masters.business.OpdAntenatalCardMedicalHistory;
import jkt.hms.masters.business.OpdAntenatalCardPregnancy;
import jkt.hms.masters.business.OpdAntenatalCardTrimester;
import jkt.hms.masters.business.OpdAntenatalUsg;
import jkt.hms.masters.business.OpdPatientAllergyT;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAllergicDrugsDt;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.TempCheckInOutFinal;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.google.gson.Gson;

public class IPDController extends MultiActionController {

	IPDHandlerService ipdHandlerService = null;
	OPDHandlerService opdHandlerService = null;
	public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	public IPDHandlerService getIpdHandlerService() {
		return ipdHandlerService;
	}

	public void setIpdHandlerService(IPDHandlerService ipdHandlerService) {
		this.ipdHandlerService = ipdHandlerService;
	}
	
	String jsp = "";
	String title = "";
	String userName = null;
	String message = null;
	
	Map<String, Object> map = new HashMap<String, Object>();

	/*
	 * methfsysteod to show the patient list on main screen
	 */

	@SuppressWarnings("rawtypes")
	public ModelAndView showPatientListJsp(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * int deptId = 0; HttpSession session = request.getSession(); int
		 * hospitalId = 0; if (session.getAttribute(HOSPITAL_ID) != null) {
		 * hospitalId = (Integer) session.getAttribute(HOSPITAL_ID); } else {
		 * hospitalId = 1; } if (request.getParameter("deptId") != null) {
		 * deptId = Integer.parseInt(request.getParameter("deptId"));
		 * session.setAttribute("deptId", deptId); } else if
		 * (session.getAttribute("deptId") != null) { deptId = (Integer)
		 * session.getAttribute("deptId"); } // String title =
		 * request.getParameter("title");
		 * 
		 * map = ipdHandlerService.updateMLCData(); map =
		 * ipdHandlerService.getPatientList(deptId, hospitalId); List set =
		 * (List) map.get("inpatientSet"); map.put("inPatientSet", set); jsp =
		 * PATIENT_LIST_JSP; jsp += ".jsp"; title = "Admitted Patient List";
		 * map.put("deptId", deptId); map.put("contentJsp", jsp);
		 * map.put("title", title); return new ModelAndView("index", "map",
		 * map);
		 */

		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Users users = (Users) session.getAttribute("users");
		dataMap.put("users", users);
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
		} else if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			//box.put("userId",userId);
		}
		String title = request.getParameter("title");
		map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);

		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "Admitted Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("rawtypes")
	public ModelAndView showPatientListNurseJsp(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * int deptId = 0; HttpSession session = request.getSession(); int
		 * hospitalId = 0; if (session.getAttribute(HOSPITAL_ID) != null) {
		 * hospitalId = (Integer) session.getAttribute(HOSPITAL_ID); } else {
		 * hospitalId = 1; } if (request.getParameter("deptId") != null) {
		 * deptId = Integer.parseInt(request.getParameter("deptId"));
		 * session.setAttribute("deptId", deptId); } else if
		 * (session.getAttribute("deptId") != null) { deptId = (Integer)
		 * session.getAttribute("deptId"); } // String title =
		 * request.getParameter("title");
		 * 
		 * map = ipdHandlerService.updateMLCData(); map =
		 * ipdHandlerService.getPatientList(deptId, hospitalId); List set =
		 * (List) map.get("inpatientSet"); map.put("inPatientSet", set); jsp =
		 * PATIENT_LIST_JSP; jsp += ".jsp"; title = "Admitted Patient List";
		 * map.put("deptId", deptId); map.put("contentJsp", jsp);
		 * map.put("title", title); return new ModelAndView("index", "map",
		 * map);
		 */

		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Users users = (Users) session.getAttribute("users");
		dataMap.put("users", users);
		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
		} else if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		String title = request.getParameter("title");
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			//box.put("userId",userId);
		}
		map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);

		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_NURSE_JSP;
		jsp += ".jsp";
		title = "Admitted Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to search for the particular patient on the basis of admission
	 * number
	 */
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String takeSetFromSessionInJsp = "true";
		int adNo = Integer.parseInt(request.getParameter(ADMISSION_NUMBER));

		String hinNumber = null;
		String deptName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		if (adNo > 0) {
			adNo = Integer.parseInt(request.getParameter(ADMISSION_NUMBER));
			map.put("adNo", adNo);
		}

		if (!request.getParameter(HIN_NO).equals("")) {
			hinNumber = request.getParameter(HIN_NO);
			map.put("hinNumber", hinNumber);
		}
		if (request.getParameter("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		map.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
		map.put("deptId", deptId);
		map = ipdHandlerService.searchPatient(map);
		jsp = SEARCH_PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "title";
		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to show the nursing care setup screen for the purticular patient
	 * to set up the cares to be given to the patient with the number of times.
	 */
	public ModelAndView showNursingCareJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
//		int inPatient = Integer.parseInt(request.getParameter("parent"));
		box.put(HOSPITAL_ID,(Integer)session.getAttribute(HOSPITAL_ID));
		box.put(DEPT_ID,(Integer)session.getAttribute(DEPT_ID));
		
		Map<String, Object> map = new HashMap<String, Object>();
//		String deptName = request.getParameter("deptName");
		
		map = ipdHandlerService.nursingCareSetup(box);
		
		jsp = CLINICAL_SETUP_JSP;
		jsp += ".jsp";
		title = "Clinical Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
//		map.put("deptName", deptName);

		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to add the nursing cares for the patient with the number of times
	 * per day to be given to the patient.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addNursingCare(HttpServletRequest request,
			HttpServletResponse response) {
		String takeSetFromSessionInJsp = "true";
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int userId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		box.put(DEPT_ID, deptId);
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String deptName = request.getParameter("deptName");
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		box.put("hinId", hinId);
		box.put("deptName", deptName);
		box.put("inpatientId", inpatientId);
// 		map=ipdHandlerService.nursingCareSetup(inPatient);
//		List list = new ArrayList();
//		List frequencyList = new ArrayList();
//		int hinId = Integer.parseInt(request.getParameter("hinId"));
//		String deptName = request.getParameter("deptName");
//		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
//		String admissionNumber = (String) session
//				.getAttribute("admissionNumber");
//		String[] frequency = request.getParameterValues("frequency");
//		String[] str = request.getParameterValues("cares");
//
//		for (int j = 0; j < frequency.length; j++) {
//			int frequencyId = Integer.parseInt(frequency[j]);
//			if (frequencyId != 0) {
//				frequencyList.add(frequencyId);
//			}
//		}
//		if (str != null) {
//			for (int i = 0; i < str.length; i++) {
//				int nursingId = Integer.parseInt(str[i]);
//				list.add(nursingId);
//			}
//		}
//		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
//		map.put("list", list);
//		map.put("frequencyList", frequencyList);
//		map.put("admissionNumber", admissionNumber);
//		map.put("userName", userName);
//		map.put("hinId", hinId);
//		map.put("inpatientId", inpatientId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put(USER_ID, userId);
		boolean successfullyAdded = ipdHandlerService.addNursingCare(box);
		if (successfullyAdded) {
			message = "Cares has been Setup Successfully !!";
		} else {
			message = "Try Again !!";
		}
		//int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			//box.put("userId",userId);
		}
		map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_NURSE_JSP;
		jsp += ".jsp";
		title = "Patient List";
//		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	/*
	 * method to show the food tasting jsp with showing the details if any entry
	 * is done regarding the food tasting for the purticular date.
	 */

	/** --discharge Status wise Report-- */
	public ModelAndView showDischargeStatusWiseReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptType = (String) session.getAttribute("deptType");
		map = ipdHandlerService.showDischargeStatusWiseReport();
		String title = "Discharge Status Wise Report";
		String jsp = Discharge_Status_Report + ".jsp";

		map.put("deptType", deptType);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateDischargeStatusWiseReport(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		Date fromDate = null;
		Date toDate = null;
		int departmentId = 0;
		int dischargeStatusId = 0;
		int hospitalId = 0;
		byte[] bytes = null;
		String reportName = "";

		try {
			Map<String, Object> detailsMap = ipdHandlerService
					.getConnectionForReport();
			Map<String, Object> connectionMap = ipdHandlerService
					.getConnectionForReport();
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				parameters.put("from_date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				parameters.put("to_date", toDate);
			}
			if ((request.getParameter(DEPARTMENT_ID)) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
				departmentId = Integer.parseInt(request
						.getParameter(DEPARTMENT_ID));
				parameters.put("ward_id", departmentId);
			}
			if (request.getParameter("reportName") != null
					&& !(request.getParameter("reportName").equals(""))) {
				reportName = (request.getParameter("reportName"));

			}

			if (request.getParameter(DISCHARGE_STATUS_ID) != null
					&& !(request.getParameter(DISCHARGE_STATUS_ID).equals(""))) {
				dischargeStatusId = Integer.parseInt(request
						.getParameter(DISCHARGE_STATUS_ID));
				parameters.put("status", dischargeStatusId);
			}
			parameters.put("hospitalId",
					(Integer) session.getAttribute(HOSPITAL_ID));

			/*
			 * bytes =
			 * JasperRunManager.runReportToPdf(getCompiledReport(reportName
			 * ),parameters, (Connection) connectionMap .get("con"));
			 */
			HMSUtil.generateReport(reportName, parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		/*
		 * response.setContentType("application/pdf");
		 * response.setHeader("Content-Disposition"
		 * ,"attachment;filename="+reportName+".pdf");
		 * 
		 * int b = bytes.length; response.setContentLength(b); try {
		 * ServletOutputStream outputStream = response.getOutputStream();
		 * 
		 * outputStream.write(bytes, 0, bytes.length); outputStream.flush();
		 * outputStream.close(); } catch (Exception e) { e.printStackTrace(); }
		 */
		return null;
	}

	/*
	 * method to show the food tasting jsp with showing the details if any entry
	 * is done regarding the food tasting for the purticular date.
	 */
	public ModelAndView showFoodTastingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = request.getParameter("deptName");
		map = ipdHandlerService.showFoodTesting(deptId);
		jsp = FOOD_TASTING_JSP;
		jsp += ".jsp";
		title = "Food Tasting";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to insert the record for food tasting for the purticular date.
	 */
	public ModelAndView insertFoodTesting(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String takeSetFromSessionInJsp = "true";
		boolean successfullyAdded = false;
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = request.getParameter("deptName");
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		String breakFastStatus = request.getParameter("breakFastStatus");
		String lunchStatus = request.getParameter("lunchStatus");
		String dinnerStatus = request.getParameter("dinnerStatus");
		String breakFastDetails = request.getParameter("breakFastDetails");
		String lunchDetails = request.getParameter("lunchDetails");
		String dinnerDetails = request.getParameter("dinnerDetails");
		String breakFastTime = request.getParameter("breakFastTime");
		String breakFastRemarks = request.getParameter("breakFastRemarks");
		String breakFastCheckedByEmp = request
				.getParameter("breakFastCheckedBy");
		String lunchTime = request.getParameter("lunchTime");
		String lunchRemarks = request.getParameter("lunchRemarks");
		String lunchCheckedByEmp = request.getParameter("lunchCheckedBy");
		String dinnerTime = request.getParameter("dinnerTime");
		String dinnerRemarks = request.getParameter("dinnerRemarks");
		String dinnerCheckedByEmp = request.getParameter("dinnerCheckedBy");
		if (!(breakFastStatus.equals("")) && breakFastDetails.equals("unDone")) {
			map.put("breakFastStatus", breakFastStatus);
			map.put("breakFastTime", breakFastTime);
			map.put("breakFastRemarks", breakFastRemarks);
			map.put("breakFastCheckedByEmp", breakFastCheckedByEmp);
		}
		if (!(lunchStatus.equals("")) && lunchDetails.equals("unDone")) {

			map.put("lunchStatus", lunchStatus);
			map.put("lunchTime", lunchTime);
			map.put("lunchRemarks", lunchRemarks);
			map.put("lunchCheckedByEmp", lunchCheckedByEmp);
		}
		if (!(dinnerStatus.equals("")) && dinnerDetails.equals("unDone")) {
			map.put("dinnerStatus", dinnerStatus);

			map.put("dinnerTime", dinnerTime);
			map.put("dinnerRemarks", dinnerRemarks);
			map.put("dinnerCheckedByEmp", dinnerCheckedByEmp);
		}
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("userName", userName);
		successfullyAdded = ipdHandlerService.insertFoodTestingDetails(map);
		if (successfullyAdded
				&& (breakFastDetails.equals("unDone")
						|| lunchDetails.equals("unDone") || dinnerDetails
							.equals("unDone"))) {
			message = "Food Tasting Details Added Successfully !!";
		} else if (successfullyAdded && breakFastDetails.equals("done")
				&& lunchDetails.equals("done") && dinnerDetails.equals("done")) {
			message = "Sorry ! Data Has Already been Entered for Food Details !!";
		} else {
			message = "Try Again !!";
		}
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "";
		map.put("takeSetFromSessionInJsp", takeSetFromSessionInJsp);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to show the list of cares can be given to the purticular patient.
	 */
	public ModelAndView showNursingCareEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		 HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
//		String deptName = request.getParameter("deptName");
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int userId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		box.put(DEPT_ID, deptId);
		map = ipdHandlerService.searchPatientOnBasisOfCare(box);
//		map = ipdHandlerService.showCaresList(box);

		jsp = NURSING_CARE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Nursing Entry";
//		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to enter the care given to the patient and show the detail of how
	 * many times the care has already been given and wheather the care has been
	 * given for the next time or not.
	 */

	public ModelAndView showNursingCareEntryDetailJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int careId = Integer.parseInt(request.getParameter("cares"));
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String caretime = request.getParameter("caretime");
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		dataMap.put("careId", careId);
		dataMap.put("deptId", deptId);
		dataMap.put(HOSPITAL_ID, hospitalId);
		
		map = ipdHandlerService.getPatientListOnBasisOfCare(dataMap);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_DETAIL_JSP;
		// jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("deptName", deptName);
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * search method for all patient on basis of care and the list will be
	 * displayed and from the list of patient purticular patient can be selected
	 * on the basis of admission number.
	 */

	public ModelAndView searchPatientOnBasisOfCare(HttpServletRequest request,
			HttpServletResponse response) {
		int nursingCareSetupId = 0;
		if (request.getParameter(RequestConstants.ADMISSION_NUMBER) != null) {
			nursingCareSetupId = Integer.parseInt(request
					.getParameter(RequestConstants.ADMISSION_NUMBER));

		}
		String deptName = request.getParameter("deptName");
		String caretime = request.getParameter("caretime");
		Map<String, Object> map = new HashMap<String, Object>();

		// int careId=(Integer)session.getAttribute("careId");
		map.put("nursingCareSetupId", nursingCareSetupId);
		// map.put("careId", careId);
		//map = ipdHandlerService.searchPatientOnBasisOfCare(map);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_JSP;
		jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("deptName", deptName);
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView showNursingCareEntryDetailForPatientJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int careId = Integer.parseInt(request.getParameter("cares"));
		String caretime = request.getParameter("caretime");
		int nursingId = Integer.parseInt(request.getParameter("nursingId"));
		// Map<String ,Object> map =new HashMap<String, Object>();
		map.put("nursingCareSetupId", nursingId);
		//map = ipdHandlerService.searchPatientOnBasisOfCare(map);
		// Set set=(Set)map.get("patientSet");
		jsp = NURSING_CARE_ENTRY_DETAIL_JSP;
		// jsp += ".jsp";
		title = "Nursing Entry Detail";
		map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to submit the details of the care given to all the patient and
	 * updating the database.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitNursingCareEntryDetails(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			int deptId = (Integer) session.getAttribute(DEPT_ID);
			int userId = (Integer) session.getAttribute(USER_ID);
			
			/*int counter = Integer.parseInt(request.getParameter("counter"));
			List nursingCareSetupIdList = new ArrayList();
			List careList = new ArrayList();
			List adNoList = new ArrayList();
			List hinIdList = new ArrayList();
			List ipdcaredetailIdList = new ArrayList();
			List timeOfCareList = new ArrayList();
			List careRemarksList = new ArrayList();

			
			String userName = (String) session.getAttribute("userName");
			for (int j = 0; j < counter; j++) {
				String care = request.getParameter("care" + j);
				String timeOfCare = request.getParameter("caretime" + j);
				String careRemarks = request.getParameter("careremarks" + j);
				if (request.getParameter("care" + j) != null) {
					String careValue = request.getParameter("care" + j);
					int nursingcareSetupId = Integer.parseInt(request
							.getParameter("nursingId" + j));
					String admissionNumber = request.getParameter("adNo" + j);
					int hin = Integer.parseInt(request
							.getParameter("hinId" + j));
					nursingCareSetupIdList.add(nursingcareSetupId);
					timeOfCareList.add(timeOfCare);
					careList.add(careValue);
					adNoList.add(admissionNumber);
					hinIdList.add(hin);
					careRemarksList.add(careRemarks);
					ipdcaredetailIdList.add(request
							.getParameter("ipdcaredetailId" + j));
				}
			}
			map.put("nursingCareSetupIdList", nursingCareSetupIdList);
			map.put("careList", careList);
			map.put("adNoList", adNoList);
			map.put("hinIdList", hinIdList);
			map.put("ipdcaredetailIdList", ipdcaredetailIdList);
			map.put("userName", userName);
			map.put("timeOfCareList", timeOfCareList);
			map.put("careRemarksList", careRemarksList);*/
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
			box.put(USER_ID, userId);
			boolean successfullyAdded = ipdHandlerService
					.submitNursingCareEntryDetails(box);
			if (successfullyAdded) {
				map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				message = "Cares has been submitted Successfully !!";
			} else {
				map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				message = " Error Ocurred Please Try Again !!";
			}

			// jsp = NURSING_DETAILS_JSP;
			jsp += ".jsp";
			// title = "Nursing Details";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to show the ward list for sealection and ajax is called on
	 * selecting the purticular ward.
	 */

	public ModelAndView showWardList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = request.getSession();
		String buttonFlag = "";
		String issueNoOfWard = "";
		String fromDate = "";
		String toDate = "";
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = (String) session.getAttribute("deptName");
		deptId = (Integer) session.getAttribute("deptId");
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		

		map = ipdHandlerService.showWardList(deptId, hospitalId);

		/*
		 * if (request.getParameter("buttonFlag") != null) { buttonFlag =
		 * request.getParameter("buttonFlag"); int pageNo =
		 * Integer.parseInt(request.getParameter("pageNo")); if
		 * (buttonFlag.equals("next")) { deptId =
		 * Integer.parseInt(request.getParameter("deptId")); issueNoOfWard =
		 * request.getParameter("issueNoOfWard"); fromDate =
		 * request.getParameter("fromDate"); toDate =
		 * request.getParameter("toDate"); pageNo++; map.put("pageNo", pageNo);
		 * map.put("deptId", deptId); map.put("buttonFlag", buttonFlag);
		 * map.put("issueNoOfWard", issueNoOfWard); map.put("fromDate",
		 * fromDate); map.put("toDate", toDate); } }
		 */
		jsp = WARD_LIST_JSP;
		jsp += ".jsp";
		title = "Ward Consumption";
		map.put("deptName", deptName);
		map.put("deptId", deptId);

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to show the ward consumption screen with grid populating while
	 * selecting the brand name and list of stock is displayed.
	 */

	public ModelAndView showWardConsumptionJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String issueNoOfWard = "";
		String buttonFlag = "";
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String fromDate = request.getParameter(RequestConstants.FROM_DATE);
		String toDate = request.getParameter(RequestConstants.TO_DATE);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);

		buttonFlag = request.getParameter("buttonFlag");
		issueNoOfWard = request.getParameter("issueNoOfWard");
		map.put("issueNoOfWard", issueNoOfWard);

		if (!request.getParameter("buttonFlag").equals("")
				&& buttonFlag != null) {
			if (buttonFlag.equals("next")) {
				buttonFlag = request.getParameter("buttonFlag");
				issueNoOfWard = request.getParameter("issueNoOfWard");
				map.put("buttonFlag", buttonFlag);
				map.put("issueNoOfWard", issueNoOfWard);
			}
		}
		map = ipdHandlerService.showWardConsumptionJsp(map);

		jsp = WARD_CONSUMPTION_JSP;
		title = "Ward Consumption";
		// map.put("issueNoOfWard", issueNoOfWard);
		map.put("pageNo", pageNo);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("date", date);
		map.put("time", time);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * method to open the pop up screen after selecting the brand name and
	 * window will populate the grid with the data and user can issue the
	 * quantity there onn the screen.
	 */
	public ModelAndView showStockDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		int brandId = 0;
		if (request.getParameter("brandId") != null
				&& !request.getParameter("brandId").equals("")) {
			brandId = Integer.parseInt(request.getParameter("brandId"));
		}
		// int wardIssueNo=Integer.parseInt(request.getParameter("ipissueno"));
		// int
		// storeFyDocumentNoId=Integer.parseInt(request.getParameter("storeFyDocumentNoId"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptName", deptName);
		map.put("deptId", deptId);
		map.put("brandId", brandId);
		map.put("rowVal", rowVal);
		map = ipdHandlerService.showStockDetailsJsp(map);

		jsp = STOCK_DETAILS_JSP;

		title = "Ward Consumption";
		map.put("deptId", deptId);

		map.put("date", date);
		map.put("time", time);
		// map.put("fromDateToDate", fromDateToDate);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to take the records from the jsp and passing those parameters to
	 * the dataservice layer for submitting the records whose quantity has been
	 * entered in the tesxt field.
	 */

	@SuppressWarnings("unchecked")
	public ModelAndView submitWardConsumptionDetails(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		// List issQtyList = new ArrayList();
		List amountList = new ArrayList();
		List pvmsList = new ArrayList();
		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List<String> expiryDateList = new ArrayList<String>();
		List<String> reasonList = new ArrayList<String>();
		List<String> remarksList = new ArrayList<String>();
		List costPriceList = new ArrayList();

		List storeItemBatchStockIdList = new ArrayList();
		int deptId1 = 0;
		try {
			
			int deptId = (Integer) session.getAttribute(DEPT_ID);

		//	int deptId = Integer.parseInt(request.getParameter("deptId"));
			deptId1 = (Integer) session.getAttribute("deptId");
			String date = request.getParameter("date");
			String time = request.getParameter("time");

			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int userId = (Integer) session.getAttribute("userId");
			String userName = (String) session.getAttribute("userName");
			String consumptionNo = "";
			if(request.getParameter("consumptionNo") != null){
				consumptionNo =""+request.getParameter("consumptionNo");
			}

			int counter = 1;
			if (Integer.parseInt(request.getParameter("hiddenValueCharge")) != 1) {
				counter = Integer.parseInt(request
						.getParameter("hiddenValueCharge"));
			}
			int j = 1;
			for (int i = 0; i < counter; i++) {
				if (request.getParameter("ItemId" + j) != null) {
					pvmsList.add(request.getParameter("ItemId" + j));
				}
				if (request.getParameter("batchNo" + j) != null) {
					batchNumberList.add(request.getParameter("batchNo" + j));
				}
				// brandNameList.add(request.getParameter("brandId"+i));
				if (request.getParameter("expDate" + j) != null) {
					expiryDateList.add(request.getParameter("expDate" + j));
				}
				if (request.getParameter("closeStock" + j) != null) {
					costPriceList.add(request.getParameter("closeStock" + j));
				}
				if (request.getParameter("storeItemBatchStockId" + j) != null) {
					storeItemBatchStockIdList.add(request
							.getParameter("storeItemBatchStockId" + j));
				}
				if (request.getParameter("compQuantity" + j) != null) {
					amountList.add(request.getParameter("compQuantity" + j));
				}
				if (request.getParameter("reason" + j) != null) {
					reasonList.add(request.getParameter("reason" + j));
				}
				if (request.getParameter("remark" + j) != null) {
					remarksList.add(request.getParameter("remark" + j));
				}
				j++;
			}
			map.put("deptId", deptId);
			map.put("deptId1", deptId1);
			map.put("consumptionNo", consumptionNo);
			map.put("hospitalId", hospitalId);
			map.put("userId", userId);
			map.put("date", date);
			map.put("time", time);
			map.put("userName", userName);
			map.put("pvmsList", pvmsList);
			map.put("batchNumberList", batchNumberList);
			// map.put("brandNameList", brandNameList);
			map.put("expiryDateList", expiryDateList);
			map.put("reasonList", reasonList);
			map.put("remarksList", remarksList);
			// map.put("issQtyList", issQtyList);
			map.put("costPriceList", costPriceList);
			map.put("amountList", amountList);
			map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
			boolean successfullyAdded = ipdHandlerService
					.submitWardConsumptionDetails(map);
			String url = "ipd?method=showWardList";
			// url = "ipd?method=showWardList";
			map.put("url", url);
			if (successfullyAdded) {

				message = "Stock  has been Updated Successfully !!";
			} else {
				message = "Error Ocurred Please Try Again!!";
			}
			jsp = STOCK_UPDATED_MESSAGE_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("deptId1", deptId1);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return new ModelAndView("index", "map", map);
	}

	/*
	 * This is the method to display a pop up screen with the records for the
	 * current issue number and the user can select the records for removing
	 * from the stock.
	 */

	public ModelAndView modifyWardConsumptionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("ipIssueNo"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = MODIFY_WARD_CONSUMPTION_JSP;
		title = "Modify Ward Consumption";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This is the method to delete the records for the current issue number and
	 * the user can select the records from the list and delete that and the
	 * stock will be updated for that record.
	 */

	public ModelAndView deleteStockDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int ipIssueTId = Integer.parseInt(request.getParameter("parent"));
		map.put("ipIssueTId", ipIssueTId);
		boolean successfullyDeleted = ipdHandlerService.deleteStockDetails(map);

		if (successfullyDeleted) {
			message = "Stock  has been Deleted Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_JSP;
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is to view the stock details for the purticular issue number.
	 */
	public ModelAndView viewStockDetailsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("issueNo"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = VIEW_STOCK_DETAILS_JSP;
		title = "View Stock Details";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to show patient issue screen while taking the details from the
	 * patient list screen and passing those values to the dataservice layer.
	 */
	public ModelAndView showPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		String buttonFlag = "";
		HttpSession session = request.getSession();
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);
		if (request.getParameter("buttonFlag") != null) {
			buttonFlag = request.getParameter("buttonFlag");
			int pageNo = Integer.parseInt(request.getParameter("pageNo"));
			int issueNoOfPatient = Integer.parseInt(request
					.getParameter("issueNoOfPatient"));
			if (buttonFlag.equals("next")) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
				pageNo++;
				map.put("pageNo", pageNo);
				map.put("deptId", deptId);
				map.put("buttonFlag", buttonFlag);
				map.put("issueNoOfPatient", issueNoOfPatient);
			}
		}
		map = ipdHandlerService.showPatientIssueJsp(map);
		jsp = PATIENT_ISSUE_JSP;
		jsp += ".jsp";
		title = "Patient Issue";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	/*
	 * This method is to get the list of items in the grid for the auto complete
	 * functionality while entering the value for the Brand name it will show
	 * the list for the matching pattern and user can select from the list.
	 */
	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {
		// --------------- Retriving User Name,Hospital Id,Department Id from
		// Session-----

		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemListForWardConsume(HttpServletRequest request,
			HttpServletResponse response) {
		// ------ Retriving User Name,Hospital Id,Department Id from
		// Session-----

		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}

		String itemNameField = "";
		String autoHint = "";
		int counter = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("counter") != null) {
				counter = Integer.parseInt(request.getParameter("counter"));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map.put("counter", counter);

			map.put("hospitalId", hospitalId);
			map = ipdHandlerService.getItemListForWardConsume(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for filing the items in the grid after selecting the value
	 * of Brand name in the grid it will populate the grid with the records
	 * corresponding to that pucticular Brand.
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public void fillItemsInGrid(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		// --- Retriving User Name,Hospital Id,Department Id from Session-----
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;

		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""
					+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		// --------------------------------------------------------------------------------
		String itemNameField = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<StoreItemBatchStock> itemList = new ArrayList<StoreItemBatchStock>();
		String brandName = "";
		try {
			if (request.getParameter("brandName") != null) {
				brandName = request.getParameter("brandName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("brandName", brandName);
		dataMap.put("deptId", deptId);
		dataMap.put("userName", userName);
		dataMap.put("hospitalId", hospitalId);
		map = ipdHandlerService.fillItemsInGrid(dataMap);
		if (map.get("itemList") != null) {
			itemList = (List) map.get("itemList");
		}
		StringBuffer sb = new StringBuffer();
		try {
			for (StoreItemBatchStock storeItem : itemList) {
				sb.append("<item>");
				sb.append("<itemId>" + storeItem.getItem().getId()
						+ "</itemId>");
				sb.append("<uom>"
						+ storeItem.getItem().getItemConversion()
								.getItemUnitName() + "</uom>");
				// sb.append("<stockIn>" + stockIn + "</stockIn>");
				sb.append("</item>");
			}
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
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

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return new ModelAndView(jsp, "map", map);
	}

	/*
	 * method to show the stock details pop up window with the data loaded in
	 * the grid for issuing the quantity and updating the records.
	 */
	@SuppressWarnings("unused")
	public ModelAndView showPatientIssueStockDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("itemId", box.getInt("itemId"));

		map = ipdHandlerService.showStockDetailsJsp(map);
		map.put("rowVal", rowVal);
		jsp = PATIENT_ISSUE_STOCK_DETAILS_JSP;
		title = "Ward Consumption";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showWardConsumptionIssueStockDetailsJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int deptId = 0;
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		int rowVal = Integer.parseInt(request.getParameter("rowVal"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deptId", deptId);
		map.put("itemId", box.getInt("itemId"));

		map = ipdHandlerService.showStockDetailsJsp(map);
		map.put("rowVal", rowVal);
		jsp = WARD_CONSUMPTION_ISSUE_STOCK_DETAILS_JSP;
		title = "Ward Consumption";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for taking all the parameters from the form which displays
	 * the stock for that Brand name including the parameters from the parent
	 * window of patient issue and tranfers those values to the DS layer which
	 * will update the stock as well as entering the quantity issued for the
	 * particular brand in master and transaction tables.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView submitPatientIssueDetails(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();

		// List pvmsList= new ArrayList();

		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int hinId = 0;
		if ((request.getParameter("hinId") != null)
				&& (!request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		String admissionNumber = request.getParameter("admissionNumber");

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName = (String) session.getAttribute("userName");
		int storeFyDocumentNoId = 0;
		if ((request.getParameter("storeFyDocumentNoId") != null)
				&& (!request.getParameter("storeFyDocumentNoId").equals(""))) {
			storeFyDocumentNoId = Integer.parseInt(request
					.getParameter("storeFyDocumentNoId"));
		}
		int patientIssueNo = 0;
		if ((request.getParameter("ipissueno") != null)
				&& (!request.getParameter("ipissueno").equals(""))) {
			patientIssueNo = Integer
					.parseInt(request.getParameter("ipissueno"));
		}
		int counter = 0;
		if ((request.getParameter("counter") != null)
				&& (!request.getParameter("counter").equals(""))) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		for (int i = 0; i < counter; i++) {
			String str = request.getParameter("issueQty" + i);
			if (str.length() > 0) {
				// int qty=Integer.parseInt(request.getParameter("issueQty"+i));
				issQtyList.add(request.getParameter("issueQty" + i));
				// pvmsList.add(itemId);
				batchNumberList.add(request.getParameter("batchNo" + i));
				brandNameList.add(request.getParameter("brandId" + i));
				expiryDateList.add(request.getParameter("expiryDate" + i));
				costPriceList.add(request.getParameter("costprice" + i));
				storeItemBatchStockIdList.add(request
						.getParameter("storeItemBatchStockId" + i));
				amountList.add(request.getParameter("amount" + i));
			}
		}
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("date", date);
		map.put("time", time);
		map.put("itemId", itemId);
		map.put("userName", userName);
		// map.put("pvmsList", pvmsList);
		map.put("batchNumberList", batchNumberList);
		map.put("brandNameList", brandNameList);
		map.put("expiryDateList", expiryDateList);
		map.put("issQtyList", issQtyList);
		map.put("costPriceList", costPriceList);
		map.put("amountList", amountList);
		map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
		map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		map.put("patientIssueNo", patientIssueNo);
		map.put("hinId", hinId);
		map.put("admissionNumber", admissionNumber);
		boolean successfullyAdded = ipdHandlerService
				.submitPatientIssueDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_FOR_PI_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitWardConsumptionIssueDetails(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List issQtyList = new ArrayList();
		List amountList = new ArrayList();

		// List pvmsList= new ArrayList();

		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List expiryDateList = new ArrayList();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int hinId = 0;
		if ((request.getParameter("hinId") != null)
				&& (!request.getParameter("hinId").equals(""))) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		String admissionNumber = request.getParameter("admissionNumber");

		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String userName = (String) session.getAttribute("userName");
		int storeFyDocumentNoId = 0;
		if ((request.getParameter("storeFyDocumentNoId") != null)
				&& (!request.getParameter("storeFyDocumentNoId").equals(""))) {
			storeFyDocumentNoId = Integer.parseInt(request
					.getParameter("storeFyDocumentNoId"));
		}

		int patientIssueNo = 0;
		if ((request.getParameter("ipissueno") != null)
				&& (!request.getParameter("ipissueno").equals(""))) {
			patientIssueNo = Integer
					.parseInt(request.getParameter("ipissueno"));
		}
		int counter = 0;
		if ((request.getParameter("counter") != null)
				&& (!request.getParameter("counter").equals(""))) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		for (int i = 0; i < counter; i++) {
			String str = request.getParameter("issueQty" + i);
			if (str.length() > 0) {
				// int qty=Integer.parseInt(request.getParameter("issueQty"+i));
				issQtyList.add(request.getParameter("issueQty" + i));
				// pvmsList.add(itemId);
				batchNumberList.add(request.getParameter("batchNo" + i));
				brandNameList.add(request.getParameter("brandId" + i));
				expiryDateList.add(request.getParameter("expiryDate" + i));
				costPriceList.add(request.getParameter("costprice" + i));
				storeItemBatchStockIdList.add(request
						.getParameter("storeItemBatchStockId" + i));
				amountList.add(request.getParameter("amount" + i));
			}
		}
		map.put("deptId", deptId);
		map.put("hospitalId", hospitalId);
		map.put("date", date);
		map.put("time", time);
		map.put("itemId", itemId);
		map.put("userName", userName);
		// map.put("pvmsList", pvmsList);
		map.put("batchNumberList", batchNumberList);
		map.put("brandNameList", brandNameList);
		map.put("expiryDateList", expiryDateList);
		map.put("issQtyList", issQtyList);
		map.put("costPriceList", costPriceList);
		map.put("amountList", amountList);
		map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
		map.put("storeFyDocumentNoId", storeFyDocumentNoId);
		map.put("patientIssueNo", patientIssueNo);
		map.put("hinId", hinId);
		map.put("admissionNumber", admissionNumber);
		boolean successfullyAdded = ipdHandlerService
				.submitWardConsumptionIssueDetails(map);
		if (successfullyAdded) {
			message = "Stock  has been Updated Successfully !!";
		} else {
			message = "Error Ocurred Please Try Again!!";
		}
		jsp = STOCK_UPDATED_MESSAGE_FOR_PI_JSP;

		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is for displaying the stock for the purticular patient with
	 * the admission number in the pop up window and the user can delete the
	 * records.
	 */
	@SuppressWarnings("unused")
	public ModelAndView showModifyPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int ipIssueNo = Integer.parseInt(request.getParameter("ipIssueNo"));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ipIssueNo", ipIssueNo);
		map = ipdHandlerService.modifyWardConsumptionJsp(map);

		jsp = MODIFY_WARD_CONSUMPTION_JSP;
		title = "Modify Ward Consumption";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * This method is to
	 */
	@SuppressWarnings("unused")
	public ModelAndView viewPatientIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String admissionNumber = request.getParameter("admissionNumber");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admissionNumber", admissionNumber);
		map = ipdHandlerService.viewPatientIssueDetails(map);

		jsp = VIEW_PATIENT_ISSUE_JSP;
		title = "Modify Ward Consumption";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showPatientDiagnosisJsp(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		int deptId = 0;
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String deptName = request.getParameter("deptName");
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);

		map = ipdHandlerService.showPatientDiagnosisJsp(map);
		jsp = PATIENT_DIAGNOSIS_JSP;
		jsp += ".jsp";
		title = "Patient Diagnosis";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getICDList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String itemNameField = "";
		String autoHint = "";
		String Z09 = "";
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter("XX") != null) {
				Z09 = (request.getParameter("XX"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getICDList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForSilDil";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView addPatientDiagnosisInformation(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hinId = 0;
		int inpatientId = 0;
		String addEditTime = "";
		String deptName = "";
		Date addEditDate = null;
		String dType = "p";
		String pastHistory = "";
		String personalHistory = "";
		String familyHistory = "";

		if (request.getParameter(HIN_ID) != null) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
		}
		if (request.getParameter("parent") != null) {
			dType = (request.getParameter("parent"));
		}
		int deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		if (request.getParameter(INPATIENT_ID) != null) {
			inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
		}
		if (request.getParameter("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		Users user = (Users) session.getAttribute("users");
		int userId = user.getId();
		String userName = user.getUserName();
		int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}

		if (request.getParameter("date") != null) {
			addEditDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("date"));

		}
		if (request.getParameter("time") != null) {
			addEditTime = request.getParameter("time");

		}
		if (request.getParameter("pastHistory") != null) {
			pastHistory = request.getParameter("pastHistory");
		}

		if (request.getParameter("personalHistory") != null) {
			personalHistory = request.getParameter("personalHistory");
		}

		if (request.getParameter("familyHistory") != null) {
			familyHistory = request.getParameter("familyHistory");
		}

		Map<String, Object> dischargeMap = new HashMap<String, Object>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));
		}

		String[] icdIdArr = new String[hdb];
		String diagnosisStatus[] = new String[hdb];
		String str = "";
		try {
			for (int i = 0; i < hdb; i++) {
				if (request.getParameter("icd" + str) != null
						&& !request.getParameter("icd" + str).equals("")) {
					String icd = request.getParameter("icd" + str);
					int index1 = icd.lastIndexOf("[");
					int index2 = icd.lastIndexOf("]");
					index1++;
					icdIdArr[i] = (icd.substring(index1, index2));
					diagnosisStatus[i] = request.getParameter("parent" + str);
					str = (i + 1 + 1) + "";
				} else {
					icdIdArr[i] = "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DischargeIcdCode> icdCodeList = new ArrayList<DischargeIcdCode>();

		try {
			for (int i = 0; i < hdb; i++) {
				DischargeIcdCode dischargeIcdCode = new DischargeIcdCode();
				if (!icdIdArr[i].equals("")) {
					Patient patient = new Patient();
					patient.setId(hinId);
					dischargeIcdCode.setHin(patient);
					Inpatient inpatient = new Inpatient();
					inpatient.setId(inpatientId);
					dischargeIcdCode.setInpatient(inpatient);
					if (request.getParameter(Z03) != null) {
						dischargeIcdCode.setZ03("y");
					} else {
						dischargeIcdCode.setZ03("n");
					}
					if (request.getParameter(Z09) != null) {
						dischargeIcdCode.setZ09("y");
					} else {
						dischargeIcdCode.setZ09("n");
					}

					Users userObject = new Users();
					userObject.setId(userId);
					dischargeIcdCode.setAddEditBy(userObject);
					MasHospital hospital = new MasHospital();
					hospital.setId(hospitalId);
					dischargeIcdCode.setHospital(hospital);

					dischargeIcdCode.setAddEditDate(addEditDate);
					dischargeIcdCode.setAddEditTime(addEditTime);
					dischargeIcdCode.setStatus("y");
					dischargeIcdCode.setDiagnosisStatus(diagnosisStatus[i]);
					icdCodeList.add(dischargeIcdCode);
				}
			}
			dischargeMap.put("icdCodeList", icdCodeList);
			dischargeMap.put("icdIdArr", icdIdArr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dischargeMap.put("pastHistory", pastHistory);
		dischargeMap.put("personalHistory", personalHistory);
		dischargeMap.put("familyHistory", familyHistory);
		dischargeMap.put("hinId", hinId);
		dischargeMap.put("hospitalId", hospitalId);
		dischargeMap.put("inpatientId", inpatientId);
		dischargeMap.put("deptId", deptId);
		dischargeMap.put("userName", userName);
		dischargeMap.put("addEditDate", addEditDate);
		dischargeMap.put("addEditTime", addEditTime);
		String message = "";
		try {
			boolean dischargeInfoSave = false;
			dischargeInfoSave = ipdHandlerService
					.addPatientDiagnosisInformation(dischargeMap);
			if (dischargeInfoSave) {
				message = " Diagnosis Information has been submitted Successfully.";

			} else {
				message = "Problem Occured! Try Again.";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (dType.equals("f")) {
			map.put("inPatientId", inpatientId);
			map.put("deptId", deptId);
			map = ipdHandlerService.showPatientDiagnosisJsp(map);
			map.put("deptName", deptName);
			jsp = PATIENT_DIAGNOSIS_JSP;

		} else {
			jsp = PATIENT_LIST_JSP;
			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
		}
		jsp += ".jsp";

		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("parent", inpatientId);
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView showSilDilJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map = ipdHandlerService.showSilDilJsp(map);
		map.put("deptName", deptName);
		jsp = SIL_DIL_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public ModelAndView submitSilDilStatus(HttpServletRequest request,
			HttpServletResponse response) {
		String conditionStatus = "";
		String patientCondition = "";
		String message = "";
		HttpSession session = request.getSession();
		String diagnosisStatus = request.getParameter("parent");
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		String deptName = request.getParameter("deptName");
		String date = request.getParameter("date");
		String treatment = request.getParameter("treatment");
		String remarks = request.getParameter("remarks");
		String time = request.getParameter("time");
		String silDilTime = request.getParameter("silDilTime");
		String nokType = request.getParameter("nokType");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String adt = "";
		if (request.getParameter("adt") != null) {
			adt = (request.getParameter("adt"));
		}
		String icdCode = "";
		int placedBy = Integer.parseInt(request.getParameter("placedBy"));
		String icd = request.getParameter("icd");
		if (!icd.equals("")) {
			int index1 = icd.lastIndexOf("[");
			int index2 = icd.lastIndexOf("]");
			index1++;
			icdCode = "" + icd.substring(index1, index2);
		}
		String andNo = request.getParameter(AD_NO);

		String userName = request.getParameter("userName");
		Map<String, Object> map = new HashMap<String, Object>();

		String[] diagnosidIdArray = null;
		try {
			StringBuffer diagnosidStr = new StringBuffer();
			int tempdiagnosid = 0;
			if (request.getParameterValues(DIAGNOSIS_ID) != null) {
				diagnosidIdArray = (String[]) (request
						.getParameterValues(DIAGNOSIS_ID));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (diagnosisStatus.equals("normal")) {
			conditionStatus = "Normal";
			patientCondition = "Normal";
		} else {
			if (diagnosisStatus.equals("sil")) {
				conditionStatus = "SIL";
				patientCondition = "Critical";
			} else {
				conditionStatus = "DIL";
				patientCondition = "Critical";
			}
		}
		map.put("patientCondition", patientCondition);
		map.put("conditionStatus", conditionStatus);
		map.put("icdCode", icdCode);
		map.put("inpatientId", inpatientId);
		map.put("date", date);
		map.put("deptId", deptId);
		map.put("treatment", treatment);
		map.put("remarks", remarks);
		map.put("time", time);
		map.put("userName", userName);
		map.put("silDilTime", silDilTime);
		map.put("placedBy", placedBy);
		map.put("nokType", nokType);
		map.put("hinId", hinId);
		map.put("deptName", deptName);
		map.put("diagnosidIdArray", diagnosidIdArray);
		boolean successfullyUpadated = ipdHandlerService
				.submitSilDilStatus(map);
		if (successfullyUpadated) {
			if (adt.equals("yes")) {
				jsp = MESSAGE_FOR_SILDIL_IN_ADT;
			} else {
				jsp = MESSAGE_FOR_SILDIL;
			}
			message = " Sil Dil Information saved Successfully. Do you want to print ?";
		} else {
			if (adt.equals("yes")) {
				jsp = MESSAGE_FOR_SILDIL_IN_ADT;
			} else {
				jsp = MESSAGE_FOR_SILDIL;
			}
			message = "Error in Submitting the Information !!";
		}
		jsp += ".jsp";
		title = "";
		map.put("andNo", andNo);
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);

	}

	// ------------------------------End of the methods written by
	// vikas---------------------------------

	// -------------------------------Nursing Clinical
	// Chart--------------------------------------
	public ModelAndView showNursingClinicalChartJsp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = (Integer) session.getAttribute(DEPT_ID);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptName = request.getParameter("deptName");
		Box box=HMSUtil.getBox(request);
		box.put(DEPT_ID, departmentId);
		box.put(HOSPITAL_ID, hospitalId);
		map = ipdHandlerService.showNursingClinicalChartJsp(box);
		String jsp = CLINICAL_CHART_JSP;
		jsp += ".jsp";
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public ModelAndView submitNursingClinicalChart(HttpServletRequest request,
			HttpServletResponse response) {
		/*Box box = HMSUtil.getBox(request);
		@SuppressWarnings("unused")
		String lastChgBy = "";
		String currentTime = "";
		int noOfRecords = 0;
		int length = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> map = new HashMap<String, Object>();

		int departmentId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTime");
		String currentDate = (String) utilMap.get("currentDate");
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		String cTime = "";
		if (request.getParameter("timeForAll") != null
				&& !(request.getParameter("timeForAll").equals(""))) {
			cTime = request.getParameter("timeForAll");
		}
		@SuppressWarnings("unused")
		String admissionNumber;
		List intakeList = new ArrayList();
		List tempList = new ArrayList();
		try {
			int hinIdArr[] = JKTRequestUtils.getIntParameters(request, HIN_ID);
			String[] adNoArr = JKTRequestUtils.getStringParameters(request,
					AD_NO);
			float[] tempArr = JKTRequestUtils.getFloatParameters(request,
					TEMPERATURE);
			int pulseArr[] = JKTRequestUtils.getIntParameters(request, PULSE);
			int respirationArr[] = JKTRequestUtils.getIntParameters(request,
					RESPIRATION);
			String[] bpArr = JKTRequestUtils.getStringParameters(request, BP);
			String[] bowelArr = JKTRequestUtils.getStringParameters(request,
					BOWEL);
			String[] painArr = JKTRequestUtils.getStringParameters(request,
					PAIN);
			String[] fhrArr = JKTRequestUtils.getRequiredStringParameters(
					request, FHR);
			String[] statusArr = JKTRequestUtils.getRequiredStringParameters(
					request, STATUS);
			String[] remarksArr = JKTRequestUtils.getRequiredStringParameters(
					request, REMARKS);
			String[] timeArr = JKTRequestUtils.getRequiredStringParameters(
					request, CHANGED_TIME);
			for (int i = 0; i < hinIdArr.length; i++) {

				if (!statusArr[i].equals("n")) {
					IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();
					ipdIntakeOutputChart
							.setDepartment(new MasDepartment(deptId));
					MasHospital masHospital = new MasHospital();
					masHospital.setId(hospitalId);
					ipdIntakeOutputChart.setHospital(masHospital);
					Patient patientObj = new Patient();
					patientObj.setId(hinIdArr[i]);
					ipdIntakeOutputChart.setHin(patientObj);
					ipdIntakeOutputChart.setAdNo(adNoArr[i]);
					Users users = new Users();
					users.setId(userId);
					ipdIntakeOutputChart.setLastChgBy(users);
					ipdIntakeOutputChart.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdIntakeOutputChart.setLastChgTime(lastChgTime);
					ipdIntakeOutputChart.setDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdIntakeOutputChart.setTime(timeArr[i]);
					ipdIntakeOutputChart.setTreatment("");
					ipdIntakeOutputChart.setDate(HMSUtil
							.convertStringTypeDateToDateType(currentDate));
					Date[] temperatureDateArray = new Date[100];
					Date[] intakeDateArray = new Date[100];
					Date[] outputDateArray = new Date[100];
					// ----------------------------------Temperature
					// Grid------------------------------------------

					IpdTemperature ipdTemperature = new IpdTemperature();
					ipdTemperature.setDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					if (tempArr[i] != 0) {
						ipdTemperature.setTemperature(tempArr[i]);
					}
					try {
						ipdTemperature.setPulse(pulseArr[i]);
					} catch (Exception e) {
					}
					try {
						ipdTemperature.setRespiration(respirationArr[i]);
					} catch (Exception e) {
					}
					try {
						ipdTemperature.setBp(bpArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBp("");
					}
					// ---New Fields Added
					try {
						if (!bowelArr[i].equals("emptyString")) {
							ipdTemperature.setBowel(bowelArr[i]);
						}
					} catch (Exception e) {
						ipdTemperature.setBowel("");
					}
					try {
						if (!painArr[i].equals("emptyString")) {
							ipdTemperature.setPain(painArr[i]);
						}
					} catch (Exception e) {
						ipdTemperature.setPain("");
					}
					try {
						if (!fhrArr[i].equals("emptyString")) {
							ipdTemperature.setFhr(fhrArr[i]);
						}
					} catch (Exception e) {
						ipdTemperature.setFhr("");
					}
					// -------------------------
					try {
						if (!remarksArr[i].equals("emptyString")) {
							ipdTemperature.setRemarks(remarksArr[i]);
						}
					} catch (Exception e) {
						ipdTemperature.setRemarks("");
					}
					try {
						ipdTemperature.setTime(timeArr[i]);
					} catch (Exception e) {
						ipdTemperature.setTime("");
					}
					try {
						ipdTemperature.setBowel(bowelArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBowel("");
					}

					ipdTemperature.setLastChgBy(users);
					ipdTemperature.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdTemperature.setLastChgTime(lastChgTime);
					intakeList.add(ipdIntakeOutputChart);
					tempList.add(ipdTemperature);
				}
			}
			map.put("statusArr", statusArr);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		HttpSession session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
//		dataMap.put("intakeList", intakeList);
//		dataMap.put("tempList", tempList);
		boolean successfullyAdded = ipdHandlerService
				.addNursingClinicalChart(box);
		if (successfullyAdded) {
			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);

			jsp = PATIENT_LIST_JSP;
			message = "Record Added Successfully !!";
		} else {
			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_JSP;
			message = " Error Ocurred Please Try Again !!";
		}

		jsp += ".jsp";
		title = "Clinical Chart";
		map.put("message", message);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showViewClinicalChartJsp(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String radio_str = "";
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String deptName = request.getParameter("deptName");
		if (request.getParameter("parent") != null) {
			radio_str = request.getParameter("parent");
			dataMap.put("radio_str", radio_str);
			dataMap.put("deptId", deptId);
			map = (Map) ipdHandlerService.getViewClinicalChart(dataMap);
		}
		jsp = VIEW_CLINICAL_CHART;
		jsp += ".jsp";
		// map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("radio_str", radio_str);

		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------Intake/Output Chart Of
	// Particular Patient----------------------------------------

	public ModelAndView showIntakeOutputJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatient = Integer.parseInt(request.getParameter("parent"));
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.showIntakeOutputJsp(inPatient);
		jsp = INTAKE_OUTPUT_JSP;
		jsp += ".jsp";
		title = "IntakeOutput";
		map.put("deptName", deptName);
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("inpatientId", inPatient);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public ModelAndView submitIntakeOutput(HttpServletRequest request,
			HttpServletResponse response) {
		String lastChgBy = "";
		/*Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String lastChgDate = (String) utilMap.get("currentDate");
		String lastChgTime = (String) utilMap.get("currentTime");
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		String intakeOutputTime = (String) utilMap.get("currenTime");
		String intakeOutputDate = (String) utilMap.get("currenDate");
		@SuppressWarnings("unused")
		Date temperatureDate = new Date();
		Date intakeDate = new Date();
		Date outputDate = new Date();
		int hinId = 0;
		String adNo = null;
		String treatment = null;
		@SuppressWarnings("unused")
		String currentTime;
		List ipdTemperatureObjList = new ArrayList();
		List ipdIntakeObjList = new ArrayList();
		List ipdOutputObjList = new ArrayList();
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int userId = (Integer) session.getAttribute(USER_ID);
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		List list = new ArrayList();
		int departmentId = (Integer) session.getAttribute("deptId");

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		IpdIntakeOutputChart ipdIntakeOutputChart = new IpdIntakeOutputChart();

		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdIntakeOutputChart.setDepartment(masDepartment);

		MasHospital masHospital = new MasHospital();
		masHospital.setId(hospitalId);
		ipdIntakeOutputChart.setHospital(masHospital);
		int inpatientId = 0;
		if (!request.getParameter("inpatientId").equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (!request.getParameter(HIN_ID).equals("0")) {
			hinId = Integer.parseInt(request.getParameter(HIN_ID));
			Patient patientObj = new Patient();
			patientObj.setId(hinId);
			ipdIntakeOutputChart.setHin(patientObj);
		}
		if (request.getParameter(AD_NO) != null) {
			adNo = String.valueOf(request.getParameter(AD_NO));
			Inpatient inpatientObj = new Inpatient();
			inpatientObj.setAdNo(adNo);
			ipdIntakeOutputChart.setAdNo(adNo);
		}
		//
		if (request.getParameter(TREATMENT) != null) {
			treatment = request.getParameter(TREATMENT);
		}
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_DATE) != null
				&& !(request.getParameter(CHANGED_DATE).equals(""))) {
			lastChgDate = request.getParameter(CHANGED_DATE);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			lastChgTime = request.getParameter(CHANGED_TIME);
		}
		Users users = new Users();
		users.setId(userId);
		ipdIntakeOutputChart.setLastChgBy(users);

		ipdIntakeOutputChart.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(lastChgDate));
		ipdIntakeOutputChart.setLastChgTime(lastChgTime);
		ipdIntakeOutputChart.setDate(HMSUtil
				.convertStringTypeDateToDateType(intakeOutputDate));
		ipdIntakeOutputChart.setTime(intakeOutputTime);
		ipdIntakeOutputChart.setTreatment(treatment);
		ipdIntakeOutputChart.setDate(HMSUtil
				.convertStringTypeDateToDateType(currentDate));
		ipdIntakeOutputChart.setTime(time);
		int deptId = (Integer) session.getAttribute("deptId");
		Date[] temperatureDateArray = new Date[100];
		Date[] intakeDateArray = new Date[100];
		Date[] outputDateArray = new Date[100];
		// ----------------------------------Temperature
		// Grid------------------------------------------
		try {
			float[] temperatureArr = JKTRequestUtils
					.getRequiredFloatParameters(request, TEMPERATURE);
			String zz[] = JKTRequestUtils.getRequiredStringParameters(request,
					TEMPERATURE_DATE);
			int zzLegnt = zz.length;
			for (int i = 0; i < zzLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(zz[i]));
				temperatureDate = java.sql.Date.valueOf(date4MySQL);
				temperatureDateArray[i] = temperatureDate;
			}
			String[] temperatureTimeArr = JKTRequestUtils.getStringParameters(
					request, TEMPERATURE_TIME);
			int pulseArr[] = JKTRequestUtils.getIntParameters(request, PULSE);
			int respirationArr[] = JKTRequestUtils.getIntParameters(request,
					RESPIRATION);
			String[] bpArr = JKTRequestUtils.getStringParameters(request, BP);
			String[] temperatureRemarksArr = JKTRequestUtils
					.getStringParameters(request, TEMPERATURE_REMARKS);
			String[] bowelArr = JKTRequestUtils.getStringParameters(request,
					BOWEL);
			String[] painArr = JKTRequestUtils.getStringParameters(request,
					PAIN);
			String[] fhrArr = JKTRequestUtils.getStringParameters(request, FHR);

			int templength = temperatureArr.length;
			int pulselength = pulseArr.length;
			int resplength = respirationArr.length;
			int bplength = bpArr.length;

			if (pulselength != 0 || resplength != 0 || bplength != 0) {
				if (request.getParameter(CHANGED_BY) != null
						&& !(request.getParameter(CHANGED_BY).equals(""))) {
					lastChgBy = request.getParameter(CHANGED_BY);
				}
				if (request.getParameter(CHANGED_TIME) != null
						&& !(request.getParameter(CHANGED_TIME).equals(""))) {
					lastChgTime = request.getParameter(CHANGED_TIME);
				}

				for (int i = 0; i < temperatureArr.length; i++) {
					IpdTemperature ipdTemperature = new IpdTemperature();

					if (temperatureDateArray[i] != null) {
						ipdTemperature.setDate(temperatureDateArray[i]);
					}
					if (temperatureArr[i] != 0) {
						ipdTemperature.setTemperature(temperatureArr[i]);
					}

					try {
						ipdTemperature.setPulse(pulseArr[i]);
					} catch (Exception e) {
						// ipdTemperature.setPulse(0);
					}

					try {
						ipdTemperature.setRespiration(respirationArr[i]);
					} catch (Exception e) {
						// ipdTemperature.setRespiration(0);
					}

					try {
						ipdTemperature.setBp(bpArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBp("");
					}

					try {
						ipdTemperature.setRemarks(temperatureRemarksArr[i]);
					} catch (Exception e) {
						ipdTemperature.setRemarks("");
					}

					if (temperatureTimeArr[i] != null) {
						ipdTemperature.setTime(temperatureTimeArr[i]);
					}
					ipdTemperature.setLastChgBy(users);
					try {
						ipdTemperature.setFhr(fhrArr[i]);
					} catch (Exception e) {
						ipdTemperature.setFhr("");
					}
					try {
						ipdTemperature.setPain(painArr[i]);
					} catch (Exception e) {
						ipdTemperature.setPain("");
					}
					try {
						ipdTemperature.setBowel(bowelArr[i]);
					} catch (Exception e) {
						ipdTemperature.setBowel("");
					}

					ipdTemperature.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdTemperature.setLastChgTime(lastChgTime);
					ipdTemperatureObjList.add(ipdTemperature);
				}
			}
			// ----------------------------------------Intake
			// Grid--------------------------------------
			String intakeArr[] = JKTRequestUtils.getStringParameters(request,
					INTAKE);
			String aa[] = JKTRequestUtils.getRequiredStringParameters(request,
					INTAKE_DATE);
			int aaLegnt = aa.length;
			for (int i = 0; i < aaLegnt; i++) {

				SimpleDateFormat formatterIn = new SimpleDateFormat(
						"dd/MM/yyyy");
				SimpleDateFormat formatterOut = new SimpleDateFormat(
						"yyyy-MM-dd");
				String date4MySQL = formatterOut.format(formatterIn
						.parse(aa[i]));
				intakeDate = java.sql.Date.valueOf(date4MySQL);

				intakeDateArray[i] = intakeDate;
			}
			String intakeTimeArr[] = JKTRequestUtils.getStringParameters(
					request, INTAKE_TIME);
			String[] oralArr = JKTRequestUtils.getStringParameters(request,
					ORAL);

			String[] ptrArr = JKTRequestUtils.getStringParameters(request, PTR);
			String[] ivArr = JKTRequestUtils.getStringParameters(request, IV);
			String[] ivCountArr = JKTRequestUtils.getStringParameters(request,
					IV_COMBO);
			String[] intakeRemarksArr = JKTRequestUtils.getStringParameters(
					request, INTAKE_REMARKS);
			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				currentTime = request.getParameter(CHANGED_TIME);
			}

			int intakelength = intakeArr.length;
			int orallength = oralArr.length;
			int ptrlength = ptrArr.length;
			int ivlength = ivArr.length;
			int ivcountlength = ivCountArr.length;

			if (ptrlength != 0 || intakelength != 0 || orallength != 0
					|| ivlength != 0 || ivcountlength != 0) {

				for (int i = 0; i < intakeArr.length; i++) {

					IpdIntake ipdIntake = new IpdIntake();
					try {
						ipdIntake.setIntake(intakeArr[i]);
						ipdIntake.setDate(HMSUtil
								.convertStringTypeDateToDateType(lastChgDate));
						ipdIntake.setTime(lastChgTime);
					} catch (Exception e) {
						ipdIntake.setIntake("");
					}

					// for(int i=0; i<oralArr.length;i++)
					try {
						ipdIntake.setOral(oralArr[i]);
					} catch (Exception e) {
						ipdIntake.setOral("");
					}

					// for(int i=0;i<ptrArr.length;i++){
					try {
						ipdIntake.setPtr(ptrArr[i]);
					} catch (Exception e) {
						ipdIntake.setOral("");
					}
					// }
					// for(int i=0;i<ivArr.length;i++){
					try {
						ipdIntake.setIv(ivArr[i]);
					} catch (Exception e) {
						ipdIntake.setIv("");
					}
					// }
					// for(int i=0;i<ivCountArr.length;i++){
					try {

						ipdIntake.setIvCount(ivCountArr[i]);
					} catch (Exception e) {
						ipdIntake.setIvCount("");
					}
					// }
					// for(int i=0;i<intakeRemarksArr.length;i++){
					try {
						ipdIntake.setRemarks(intakeRemarksArr[i]);
					} catch (Exception e) {
						ipdIntake.setRemarks("");
					}
					// }
					ipdIntake.setLastChgBy(users);
					ipdIntake.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(lastChgDate));
					ipdIntake.setLastChgTime(lastChgTime);
					ipdIntakeObjList.add(ipdIntake);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// -----------------------------------------Output
		// Grid-------------------------------------------
		String outputArr[] = JKTRequestUtils.getStringParameters(request,
				OUTPUT_DATE);
		String bb[] = null;
		try {
			bb = JKTRequestUtils.getRequiredStringParameters(request,
					OUTPUT_DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int bbLegnt = bb.length;
		//
		
		 * for (int i = 0; i < bbLegnt; i++) {
		 * 
		 * SimpleDateFormat formatterIn = new SimpleDateFormat( "dd/MM/yyyy");
		 * SimpleDateFormat formatterOut = new SimpleDateFormat( "yyyy-MM-dd");
		 * 
		 * String date4MySQL = formatterOut.format(formatterIn.parse(bb[i]));
		 * outputDate = java.sql.Date.valueOf(date4MySQL); outputDateArray[i] =
		 * outputDate; }
		 String outputTimeArr[] = JKTRequestUtils.getStringParameters(
				request, OUTPUT_TIME);
		String[] urineArr = JKTRequestUtils.getStringParameters(request, URINE);
		String[] stoolArr = JKTRequestUtils.getStringParameters(request, STOOL);
		//
		String[] vomArr = JKTRequestUtils.getStringParameters(request, VOM);
		String[] aspArr = JKTRequestUtils.getStringParameters(request, ASP);
		String outputRemarksArr[] = JKTRequestUtils.getStringParameters(
				request, OUTPUT_REMARKS);
		String drainTimeArr[] = JKTRequestUtils.getStringParameters(request,
				DRAIN_TIME);
		String[] drainArr = JKTRequestUtils.getStringParameters(request, DRAIN);
		String girthTimeArr[] = JKTRequestUtils.getStringParameters(request,
				GIRTH_TIME);
		String[] girthArr = JKTRequestUtils.getStringParameters(request, GIRTH);
		String insulinTimeArr[] = JKTRequestUtils.getStringParameters(request,
				INSULIN_TIME);
		String[] insulinArr = JKTRequestUtils.getStringParameters(request,
				INSULIN);
		String bloodsugarTimeArr[] = JKTRequestUtils.getStringParameters(
				request, BLOOD_SUGAR_TIME);
		String[] bloodSugarArr = JKTRequestUtils.getStringParameters(request,
				BLOOD_SUGAR);
		String drainRemarksArr[] = JKTRequestUtils.getStringParameters(request,
				DRAIN_REMARKS);
		if (request.getParameter(CHANGED_BY) != null
				&& !(request.getParameter(CHANGED_BY).equals(""))) {
			lastChgBy = request.getParameter(CHANGED_BY);
		}
		if (request.getParameter(CHANGED_TIME) != null
				&& !(request.getParameter(CHANGED_TIME).equals(""))) {
			currentTime = request.getParameter(CHANGED_TIME);
		}
		int outputlength = outputArr.length;
		int urinelength = urineArr.length;
		int stoollength = stoolArr.length;
		int vomlength = vomArr.length;
		int asplength = aspArr.length;
		int drainlength = drainArr.length;
		int girthlength = girthArr.length;
		int insulinlength = insulinArr.length;
		int bloodsugarlength = bloodSugarArr.length;

		if (outputlength != 0 || urinelength != 0 || stoollength != 0
				|| vomlength != 0 || asplength != 0 || drainlength != 0
				|| girthlength != 0 || insulinlength != 0
				|| bloodsugarlength != 0) {

			for (int i = 0; i < outputArr.length; i++) {

				IpdOutput ipdOutput = new IpdOutput();
				if (outputArr[i] != null) {
					try {
						ipdOutput.setOutput(outputArr[i]);
					} catch (Exception e) {
						ipdOutput.setOutput("");
					}
				}

				// for (int i = 0; i < urineArr.length; i++) {

				ipdOutput.setDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));

				if (urineArr.length > 0 && urineArr[i] != null) {
					ipdOutput.setUrine(urineArr[i]);
				}
				// }

				// for (int i2 = 0; i2 < stoolArr.length; i2++) {

				try {
					ipdOutput.setStool(stoolArr[i]);
				} catch (Exception e) {
					ipdOutput.setStool("");
				}
				// }

				// for (int i3 = 0; i3 < vomArr.length; i3++) {

				try {
					ipdOutput.setVom(vomArr[i]);
				} catch (Exception e) {
					ipdOutput.setVom("");
				}
				// }

				// for (int i4 = 0; i4 < aspArr.length; i4++) {

				try {
					ipdOutput.setAsp(aspArr[i]);
				} catch (Exception e) {
					ipdOutput.setAsp("");
				}
				// }

				// for (int i5 = 0; i5 < drainTimeArr.length; i5++) {

				
				 * if (drainTimeArr!=null && drainTimeArr.length>0 &&
				 * drainTimeArr[i] != null) {
				 * ipdOutput.setDrainTime(drainTimeArr[i]); } try {
				 * ipdOutput.setDrain(drainArr[i]); } catch (Exception e) {
				 * ipdOutput.setDrain(""); }
				 
				// }

				// for (int i6 = 0; i6 < girthTimeArr.length; i6++) {

				try {
					if (girthTimeArr != null && girthTimeArr.length > 0
							&& girthTimeArr[i] != null) {
						ipdOutput.setGirthTime(girthTimeArr[i]);
					}
				} catch (Exception e) {
					ipdOutput.setGirthTime("");
				}
				// }

				// for (int i7 = 0; i7 < girthArr.length; i7++) {

				try {
					ipdOutput.setGirth(girthArr[i]);
				} catch (Exception e) {
					ipdOutput.setGirth("");
				}
				// }

				// for(int i8=0; i8<insulinTimeArr.length;i8++){
				try {
					if (insulinTimeArr != null && insulinTimeArr.length > 0
							&& insulinTimeArr[i] != null) {
						ipdOutput.setInsulinTime(insulinTimeArr[i]);
					}
				} catch (Exception e) {
					ipdOutput.setInsulinTime("");
				}
				// }
				// for(int i9=0; i9<insulinArr.length;i9++){
				try {
					ipdOutput.setInsulin(insulinArr[i]);
				} catch (Exception e) {
					ipdOutput.setInsulin("");
				}
				// }

				// for(int i9=0; i9<bloodsugarTimeArr.length;i9++){
				try {
					if (bloodsugarTimeArr != null
							&& bloodsugarTimeArr.length > 0
							&& bloodsugarTimeArr[i] != null) {
						ipdOutput.setBloodSugarTime(bloodsugarTimeArr[i]);
					}
				} catch (Exception e) {
					ipdOutput.setBloodSugarTime("");
				}
				// }

				// for(int i9=0; i9<bloodSugarArr.length;i9++){
				try {
					ipdOutput.setBloodSugar(bloodSugarArr[i]);
				} catch (Exception e) {
					ipdOutput.setBloodSugar("");
				}

				// }

				// for(int i9=0; i9<outputRemarksArr.length;i9++){
				try {
					ipdOutput.setRemarks(outputRemarksArr[i]);
				} catch (Exception e) {
					ipdOutput.setRemarks("");
				}
				// }
				// for(int i9=0; i9<drainRemarksArr.length;i9++){
				try {
					ipdOutput.setDrainRemarks(drainRemarksArr[i]);
				} catch (Exception e) {
					ipdOutput.setDrainRemarks("");
				}
				// }

				// for(int i9=0; i9<outputTimeArr.length;i9++){
				try {
					if (outputRemarksArr != null && outputTimeArr[i] != null) {
						ipdOutput.setTime(outputTimeArr[i]);
					}
				} catch (Exception e) {
					ipdOutput.setTime("");
				}
				// }
				ipdOutput.setLastChgBy(users);
				ipdOutput.setLastChgDate(HMSUtil
						.convertStringTypeDateToDateType(lastChgDate));
				ipdOutput.setLastChgTime(lastChgTime);
				ipdOutputObjList.add(ipdOutput);
				ipdOutput.setTime(lastChgTime);

			}
		}

		Map<String, Object> objMap = new HashMap<String, Object>();
		objMap.put("admissionNumber", adNo);
		objMap.put("ipdIntakeOutputChart", ipdIntakeOutputChart);
		if (ipdTemperatureObjList.size() > 0) {
			objMap.put("ipdTemperatureObjList", ipdTemperatureObjList);
		}
		if (ipdIntakeObjList.size() > 0) {
			objMap.put("ipdIntakeObjList", ipdIntakeObjList);
		}
		if (ipdOutputObjList.size() > 0) {
			objMap.put("ipdOutputObjList", ipdOutputObjList);
		}*/
		
		HttpSession session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		int empId = (Integer) session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		String message = "";
		Map<String, Object> datamap = new HashMap<String, Object>();
		datamap = ipdHandlerService.addIntakeOutput(box);
		boolean successfullyAdded = false;
		int intakeoutput_id=0;
		if(datamap.get("successfullyAdded")!=null) {
			successfullyAdded = (Boolean)datamap.get("successfullyAdded");
		}
		if(datamap.get("intakeoutput_id")!=null) {
			intakeoutput_id = (Integer)datamap.get("intakeoutput_id");
		}
		if (successfullyAdded) {

			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
			List inpatientSet = (List) map.get("inpatientSet");
			map.put("inPatientSet", inpatientSet);
			map.put("andNo", box.getInt(AD_NO));
			map.put("intakeoutput_id", intakeoutput_id);
			
			map.put("inpatientId", box.getInt(INPATIENT_ID));
			jsp = "messageForIntakeOutputId";
			//jsp = PATIENT_LIST_NURSE_JSP;
			message = "Record Added Successfully .Do you want to print ?";

		} else {
			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
			List inpatientSet = (List) map.get("inpatientSet");
			map.put("inPatientSet", inpatientSet);
			jsp = MESSAGE_FOR_INTAKE_OUTPUT;
			message = " Error Ocurred Please Try Again !!";

		}
		jsp += ".jsp";
		title = "IntakeOutput";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showViewIntakeOutputJsp(HttpServletRequest request,
			HttpServletResponse response) throws ServletRequestBindingException {

		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String radio_str = "";
		String deptName = "";
		int departmentId = 0;
		String jsp = "";
		try {
			departmentId = (Integer) session.getAttribute("deptId");
			deptName = request.getParameter("deptName");
			if (request.getParameter(AD_NO) != null) {
				radio_str = request.getParameter(AD_NO);
				map = (Map) ipdHandlerService.getViewIntakeOutput(radio_str);
			}
			jsp = VIEW_INTAKE_OUTPUT;
			jsp += ".jsp";

		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptName", deptName);
		map.put("radio_str", radio_str);
		return new ModelAndView("index", "map", map);
	}

	// --------------------------------IntakeOutputChartReport----------------------------------
	public ModelAndView showIntakeOutputChartReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		String andNo = "";

		if (request.getParameter("hinNo") != null
				&& !(request.getParameter("hinNo").equals(""))) {
			hinNo = request.getParameter("hinNo");
		}
		if (request.getParameter("andNo") != null
				&& !(request.getParameter("andNo").equals(""))) {
			andNo = (request.getParameter("andNo"));
		}
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		requestParameters.put(hinNo, hinNo);
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		map = ipdHandlerService.getAdmissionNumberList(requestParameters);
		jsp = INTAKE_OUTPUT_REPORT_JSP;
		jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hinNo", hinNo);
		map.put("andNo", andNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showIntakeOutputChartReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String admissionNumber = null;
		Date toDate = new Date();
		Date fromDate = new Date();
		byte[] bytes = null;
		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = request.getParameter("adNo");
			}else if (request.getParameter(ADMISSION_NUMBER) != null) {
				 admissionNumber = request.getParameter(ADMISSION_NUMBER);
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = ipdHandlerService.getDBConnection();
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("adNo", admissionNumber);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		map.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		HMSUtil.generateReport("IntakeOutput", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	public ModelAndView showPatientSearchJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();

		if (request.getParameter("patientName") != null
				&& request.getParameter("patientName") != "") {
			requestParameters.put("patientName",
					request.getParameter("patientName"));
		}
		if (request.getParameter("hinNo") != null
				&& request.getParameter("hinNo") != "") {
			requestParameters.put("hinNo", request.getParameter("hinNo"));
		}
		if (request.getParameter("SearchFlag") != null
				&& request.getParameter("SearchFlag") != "") {
			requestParameters.put("SearchFlag",
					request.getParameter("SearchFlag"));
		}
		if (request.getParameter("adNo") != null
				&& request.getParameter("adNo") != "") {
			requestParameters.put("adNo", request.getParameter("adNo"));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		requestParameters.put("deptId", deptId);
		map = ipdHandlerService.getSearchPatientComboDetails(requestParameters);
		jsp = INTAKE_OUTPUT_PATIENT_SEARCH;
		title = "Patient Search Screen";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	// --------------------------------Method for Admission
	// Number-----------------------------------
	public ModelAndView getAdmissionNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}

		if (flag.equals("admission")) {
			admissionNoList = ipdHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = RESPONSE_FOR_ADMISSION_NO;
		} else if (flag.equals("hin")) {
			hinNoList = ipdHandlerService.getHinNoList(serviceNo);
			map.put("hinNoList", hinNoList);
			jsp = IPD_RESPONSE_INTAKE_OUTPUT_HIN_NO;
		}
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAdmissionNumberList(HttpServletRequest request,
			HttpServletResponse response) {
		String serviceNo = null;
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		if (request.getParameter(SERVICE_NO) != null
				&& request.getParameter(SERVICE_NO) != "") {
			serviceNo = request.getParameter(SERVICE_NO);
			requestParameters.put(SERVICE_NO, serviceNo);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.getAdmissionNumberList(requestParameters);
		jsp = "ipdAdmissionNumberPopulate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getAdmissionNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Object> hinNoList = new ArrayList<Object>();
		String flag = "";

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
		}

		if (flag.equals("admission")) {
			admissionNoList = ipdHandlerService.getAdmissionNoList(detailsMap);
			map.put("admissionNoList", admissionNoList);
			jsp = RESPONSE_DISCHARGE_AD_NO;
		} else if (flag.equals("hin")) {
			hinNoList = ipdHandlerService.getHinNoList(serviceNo);
			map.put("hinNoList", hinNoList);
			jsp = IPD_RESPONSE_FOR_HIN_NO;
		}

		return new ModelAndView(jsp, "map", map);

	}

	// -----------------------------DischargeSlip
	// Report-------------------------------------------
	public ModelAndView showDischargeSlipJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = DISCHARGE_SLIP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDischargeSlipReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int inpatientId = 0;
		int dischargeId = 0;
		int hospitalId = 0;
		String hinNo = "";
		try {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			if (request.getParameter(HIN_NO) != null && !request.getParameter(HIN_NO).equals("")) {
				hinNo = request.getParameter(HIN_NO);
			}
			if (request.getParameter(INPATIENT_ID) != null) {
				inpatientId = Integer.parseInt(request
						.getParameter(INPATIENT_ID));
			} else if (request.getParameter(ADMISSION_NUMBER) != null) {
				String adNo = request.getParameter(ADMISSION_NUMBER);
				inpatientId = ipdHandlerService.getInpatientId(adNo, hinNo);

			} else {
				if (request.getParameter("parent") != null) {
					dischargeId = Integer.parseInt(request
							.getParameter("parent"));
					tempMap.put(HOSPITAL_ID, hospitalId);
					tempMap.put("dischargeId", dischargeId);
					tempMap = ipdHandlerService.getIpIdFormDischargeId(tempMap);
					if (tempMap.get("inpatientId") != null) {
						inpatientId = Integer.parseInt(""
								+ tempMap.get("inpatientId"));
					}

				}
			}
			parameters.put("inpatientId", inpatientId);
			parameters.put("hospitalId", hospitalId);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("inpatientId", inpatientId);
			dataMap.put(HOSPITAL_ID, hospitalId);
			detailsMap = ipdHandlerService.getDiagnosisAndDocumentInit(dataMap);
			String docInit = "";
			String diagnosis = "";
			String icdNos = "";
			List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
			List<InpatientDocument> inpatientDocumentList = new ArrayList<InpatientDocument>();
			dischargeIcdCodeList = (List<DischargeIcdCode>) detailsMap
					.get("dischargeIcdCodeList");

			inpatientDocumentList = (List<InpatientDocument>) detailsMap
					.get("inpatientDocumentList");
			for (InpatientDocument inpatientDocument : inpatientDocumentList) {
				docInit = docInit
						+ inpatientDocument.getDocument().getDocumentName()
						+ ",";
			}
			for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
				/*if (dischargeIcdCode.getZ09().equals("y")) {
					diagnosis = diagnosis
							+ dischargeIcdCode.getIcd().getIcdSubCategory()
									.getIcdSubCategoryName() + " : "
							+ dischargeIcdCode.getIcd().getIcdName() + "{OLD},";
				} else {*/
					diagnosis = diagnosis
							+ dischargeIcdCode.getIcd().getIcdSubCategory()
									.getIcdSubCategoryName() + " : "
							+ dischargeIcdCode.getIcd().getIcdName() + ",";
			//	}

			}
			for (DischargeIcdCode dischargeIcdCode : dischargeIcdCodeList) {
				/*if (dischargeIcdCode.getZ09().equals("y")) {
					icdNos = icdNos + dischargeIcdCode.getIcd().getIcdCode()
							+ " : Z09,";
				} else {*/
					icdNos = icdNos + dischargeIcdCode.getIcd().getIcdCode()
							+ ",";
				//}
			}
			
			
			System.out.println(diagnosis.toUpperCase()+"diagnosis.toUpperCase()");
			parameters.put("docInit", docInit);
			parameters.put("diagnosis", diagnosis.toUpperCase());
			parameters.put("icdNos", icdNos);
			byte[] bytes = null;
			// try {
			// try {
			// bytes
			// =JasperRunManager.runReportToPdf(getCompiledReport("Hospital_Discharge_Slip"),parameters,(Connection)detailsMap.get("conn"));
			// HMSUtil.generateReport("Hospital_Discharge_Slip", map,
			// (Connection)map.get("conn"), response, getServletContext());
			// } catch (Exception e) {
			//
			// e.printStackTrace();
			// }
			// response.setContentType("application/pdf");
			// response.setContentLength(bytes.length);
			// ServletOutputStream ouputStream;
			//
			// ouputStream = response.getOutputStream();
			// ouputStream.write(bytes, 0, bytes.length);
			// ouputStream.flush();
			// ouputStream.close();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			String flag="1";
			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			
			if (flag.equals("1"))
			{
				HMSUtil.generateReport("Hospital_Discharge_Slip", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			}

			else if(flag.equals("2")) {
						HMSUtil.generateHTMLReport("Hospital_Discharge_Slip", parameters,
								(Connection) detailsMap.get("conn"), response,
								getServletContext());
			}
			
		}
		
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ------------------------Food tasting
	// Report--------------------------------
	public ModelAndView showFoodTastingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId=0;
		if(session.getAttribute("hospitalId")!=null){
			hospitalId=(Integer)session.getAttribute("hospitalId");
		}
		map = ipdHandlerService.showFoodTastingReportJsp(hospitalId);
		jsp = FOOD_TASTING;
		jsp += ".jsp";
		title = "foodTastingReport";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showFoodTastingReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int departmentId = 0;
		int stringVariable = 0;
		Date toDate = null;
		Date fromDate = null;

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));
			stringVariable = departmentId;
		} else {
			stringVariable =0;
		}

		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		// parameters.put("stringVariable", stringVariable);
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("food_tasting"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("food_tasting", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(JRException e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (IllegalStateException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("food_tasting", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	// -----------------------------------NursingCare
	// Report------------------------------------------
	public ModelAndView showNursingCareReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int deptId = 0;
		int careType = 0;
		int patientId = 0;
		int nursingCareType = 0;
		String admissionNumber = "";
		if (request.getParameter("cares") != null) {
			careType = Integer.parseInt("" + request.getParameter("cares"));
		}
		int counter = 0;
		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
		}

		int hin = 0;
		for (int j = 0; j < counter; j++) {
			if (request.getParameter("hinId" + j) != null) {
				patientId = Integer.parseInt(request.getParameter("hinId" + j));
				admissionNumber = request.getParameter("adNo" + j);
			}
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		if (request.getParameter("cares") != null) {
			nursingCareType = Integer.parseInt(""
					+ request.getParameter("cares"));
		}

		String deptType = (String) session.getAttribute("deptType");
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("patientId", patientId);
		map = ipdHandlerService.showNursingCareReportJsp(dataMap);
		patientList = (List<Patient>) map.get("patientList");
		if (patientList.size() > 0) {
			for (Patient patient : patientList) {
				hinNo = ("" + patient.getHinNo());
			}
		}

		jsp = NURSING_CARE_REPORT;
		jsp += ".jsp";
		title = "nursingCareReport";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("nursingCareType", nursingCareType);
		map.put("deptType", deptType);
		map.put("hinNo", hinNo);
		map.put("careType", careType);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView getAdmissionNumberListForNusingcare(HttpServletRequest request,
			HttpServletResponse response) {
		String hinNo = null;
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		if (request.getParameter("hinNo") != null
				&& !(request.getParameter("hinNo").equals(""))) {
			hinNo = request.getParameter("hinNo");
		}
		
		requestParameters.put(hinNo, hinNo);
		map = ipdHandlerService.getAdmissionNumberList(requestParameters);
		jsp = "ipdNoInNursingCare";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	
	
	

	public ModelAndView showNursingCareReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String hinNo = "";
		int hospitalId = 0;
		Date toDate = new Date();
		int nursingCareId = 0;
		String stringVariable = "";
		Date fromDate = new Date();
		int dept = 0;
		String qry = "";
		byte[] bytes = null;
		try {
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter(DEPARTMENT_ID) != null
					&& !(request.getParameter(DEPARTMENT_ID).equals(""))) {
				dept =Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (!request.getParameter(NURSING_CARE_ID).equals("0")) {
				nursingCareId = Integer.parseInt(request
						.getParameter(NURSING_CARE_ID));
				stringVariable = "" + nursingCareId;
				qry = " and ncs.nursing_id=" + nursingCareId
						+ " ";
			} else {
				stringVariable = "";
				qry = "";
			}

			if (request.getParameter(HIN_NO) != null) {
				hinNo = request.getParameter(HIN_NO);
				parameterMap.put("hinNo", hinNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		int deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		map = ipdHandlerService.getDBConnection();

		map.put("qry", qry);
		map.put("fromDate", fromDate);
		map.put("toDate", toDate);
		map.put("Ward", dept);
		map.put("hinNo", hinNo);
		map.put("hospitalId", hospitalId);
		// map.put("nId", Integer.parseInt(stringVariable));

		// try {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("NursingCareReport"),
		// map,(Connection) map.get("conn"));
		// HMSUtil.generateReport("food_tasting", map,
		// (Connection)map.get("conn"), response, getServletContext());
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// try {
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("NursingCareReport", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}

	// -------------------------------------------------------------------------------------------------------------

	public ModelAndView getHinNo(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String flag = "";
		if (request.getParameter(SERVICE_NO) != null
				&& !(request.getParameter(SERVICE_NO).equals(""))) {
			serviceNo = request.getParameter(SERVICE_NO);
			detailsMap.put("serviceNo", serviceNo);
		}
		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			detailsMap.put("hinNo", hinNo);
		}
		if (request.getParameter("flag") != null
				&& !(request.getParameter("flag").equals(""))) {
			flag = request.getParameter("flag");
			map.put("flag", flag);
		}

		List<Object> hinNoList = new ArrayList<Object>();
		hinNoList = ipdHandlerService.getHinNo(serviceNo);
		map.put("hinNoList", hinNoList);

		String jsp = "populateHinNoForUpdate";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getPatientName(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		String patientName = "";
		patientName = ipdHandlerService.getMothersName(hinNo);

		String jsp = "populatePatientNameForUpdate";
		map.put("name", patientName);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getIpNoForReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
		}
		
		map=ipdHandlerService.getIpNoForReport(hinNo);

		String jsp = "responseIPNo";
		
		return new ModelAndView(jsp, "map", map);
	}
		
	

	// ------------------------ Common Method for Report
	// ---------------------------

	// ------Duty Nursing Officer report------------
	public ModelAndView showDutyNursingReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String deptType = (String) session.getAttribute("deptType");
		map = ipdHandlerService.showDutyNursingReportJsp();
		jsp = DUTY_NURSING_OFFICERS;
		jsp += ".jsp";
		title = "DutyNursingReport";
		map.put("deptType", deptType);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDutyNursingReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int departmentId = 0;
		Date date = new Date();

		// if(request.getParameter(DATE) != null &&
		// !(request.getParameter(DATE).equals(""))){
		// date =
		// HMSUtil.convertStringTypeDateToDateType(request.getParameter(DATE));
		// }
		if (!request.getParameter(DEPARTMENT_ID).equals("0")) {
			departmentId = Integer
					.parseInt(request.getParameter(DEPARTMENT_ID));

		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		String deptName = "";
		if (!request.getParameter("deptName").equals("0")) {
			deptName = (request.getParameter("deptName"));

		}

		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("toDate", date);
		parameters.put("deptId", departmentId);
		parameters.put("hospitalId",
				(Integer) session.getAttribute(HOSPITAL_ID));
		parameters.put("department_name", deptName);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("DutyNursingOfficersReport"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("DutyNursingOfficersReport", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(JRException e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (IllegalStateException e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("DutyNursingOfficersReport", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	private JasperReport getCompiledReport(String fileName) throws JRException {
		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);
		return jasperReport;
	}

	// -------------At Bangalore-----------

	public ModelAndView showSilDilJspInAdt(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		String adt = "";
		HttpSession session = request.getSession();
		int inPatientId = Integer.parseInt(request.getParameter(AD_NO));
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if (request.getParameter("adt") != null) {
			adt = ("" + request.getParameter("adt"));
		}
		String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("inPatientId", inPatientId);
		map.put("deptId", deptId);
		map = ipdHandlerService.showSilDilJsp(map);
		map.put("deptName", deptName);
		jsp = SIL_DIL_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("adt", adt);
		return new ModelAndView("index", "map", map);
	}

	// -----------------Added at bangalore on 26-07-08-----------------------
	public ModelAndView getICDCodeList(HttpServletRequest request,
			HttpServletResponse response) {

		int deptId = 0;
		@SuppressWarnings("unused")
		int hospitalId = 0;

		HttpSession session = request.getSession();

		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		String itemNameField = "";
		String autoHint = "";

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("userName", userName);
			map = ipdHandlerService.getICDCodeList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseForSilDil2";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showWaitingList(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataMap.put("deptId", deptId);
		map = ipdHandlerService.showWaitingList(dataMap);

		jsp = WAITING_LIST;
		jsp += ".jsp";
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitWaitingList(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int deptId = 0;
		String saved = "no";
		String messageTOBeVisibleToTheUser = "";
		String messageType = "success";
		HttpSession session = request.getSession();
		try {
			if (session.getAttribute("deptId") != null) {
				deptId = Integer.parseInt("" + session.getAttribute("deptId"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Box box = HMSUtil.getBox(request);
		dataMap.put("box", box);
		map = ipdHandlerService.submitWaitingList(dataMap);
		if (map.get("saved") != null) {
			saved = "" + map.get("saved");
		}
		if (saved.equals("yes")) {
			messageTOBeVisibleToTheUser = "Admitted Successfully";
		} else {
			messageTOBeVisibleToTheUser = "Some problem occured .Try again ...!";
		}
		jsp = STORES_MESSAGE_JSP;
		jsp += ".jsp";
		@SuppressWarnings("unused")
		List set = (List) map.get("inpatientSet");
		String url = "/hms/hms/ipd?method=showWaitingList";
		map.put("url", url);
		map.put("messageTOBeVisibleToTheUser", messageTOBeVisibleToTheUser);
		map.put("messageType", messageType);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showWardRemarksJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		int inpatientId = 0;

		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
		}
		map = ipdHandlerService.showWardRemarksJsp(inpatientId);
		jsp = WARD_REMARKS_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveWardRemarks(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		int userId = 0;
		HttpSession session = null;
		String saved = "";
		String message = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		userId = (Integer) session.getAttribute(USER_ID);

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put("deptId", deptId);
		box.put("userName", userName);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		dataMap.put("box", box);
		map = ipdHandlerService.saveWardRemarks(dataMap);
		if (map.get("saved") != null) {
			saved = "" + map.get("saved");
		}
		if (saved.equals("yes")) {
			message = "Remarks Added Successfully";
		} else {
			message = "Some problem Occured .Try again.";
		}
		jsp = WARD_REMARKS_JSP;
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getWardRemarksDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String remarksDate = "";
		int deptId = 0;

		jsp = RESPONCE_FOR_WARD_DETAILS;
		if (request.getParameter("remarksDate") != null
				&& !(request.getParameter("remarksDate").equals(""))) {
			remarksDate = (request.getParameter("remarksDate"));
		}
		if (request.getParameter("deptId") != null
				&& !(request.getParameter("deptId").equals(""))) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
		}
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null
				&& !(request.getParameter("inpatientId").equals(""))) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("remarksDate", remarksDate);
		dataMap.put("deptId", deptId);
		dataMap.put("inpatientId", inpatientId);
		map = ipdHandlerService.getWardRemarksDetails(dataMap);

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getProgressNoteDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		String remarksDate = "";
		int inpatientId = 0;

		jsp = "responseProgressDetails";
		if (request.getParameter("remarksDate") != null
				&& !(request.getParameter("remarksDate").equals(""))) {
			remarksDate = (request.getParameter("remarksDate"));
		}
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("remarksDate", remarksDate);
		dataMap.put("inpatientId", inpatientId);
		map = ipdHandlerService.getProgressNoteDetails(dataMap);

		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showDutyNursingOfficersRemarks(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalid = 0;
		Date date = new Date();

		if (request.getParameter(DATE_OF_WARD_MASTER) != null
				&& !(request.getParameter(DATE_OF_WARD_MASTER).equals(""))) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE_OF_WARD_MASTER));
		}
		if (request.getParameter(DEPARTMENT_ID_TEMP) != null) {
			departmentId = Integer.parseInt(request
					.getParameter(DEPARTMENT_ID_TEMP));

		}
		String deptName = "";
		if (!request.getParameter("deptNameForRemarks").equals("0")) {
			deptName = (request.getParameter("deptNameForRemarks"));

		}
		hospitalid = (Integer) session.getAttribute(HOSPITAL_ID);
		detailsMap = ipdHandlerService.getDBConnection();

		parameters.put("Date", date);
		parameters.put("Dept_Id", departmentId);
		parameters.put("wardName", deptName);
		parameters.put("hospitalId", hospitalid);
		parameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		// try {
		// byte bytes[] = null;
		// try
		// {
		// bytes =
		// JasperRunManager.runReportToPdf(getCompiledReport("wardremarksForOfficers"),parameters,(Connection)detailsMap.get("conn"));
		// HMSUtil.generateReport("wardremarksForOfficers", parameters,
		// (Connection)map.get("conn"), response, getServletContext());
		// }
		// catch(Exception e)
		// {
		// e.printStackTrace();
		// }
		// response.setContentType("application/pdf");
		// response.setContentLength(bytes.length);
		// ServletOutputStream ouputStream;
		// try {
		// ouputStream = response.getOutputStream();
		// ouputStream.write(bytes, 0, bytes.length);
		// ouputStream.flush();
		// ouputStream.close();
		// } catch (IOException e)
		// {
		// e.printStackTrace();
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		HMSUtil.generateReport("wardremarksForOfficers", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showSmsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.getDoctorList();
		String jsp = "doctorsMessage";
		map.put("msgType", request.getParameter("msgType"));
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView saveMessageForDoctors(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		boolean flag = false;
		flag = ipdHandlerService.saveMessageForDoctors(box);
		String msg = "";
		if (flag) {
			msg = "Message Saved Successfully";
		} else {
			msg = "Try Again!";
		}
		map = ipdHandlerService.getDoctorList();
		String jsp = "doctorsMessage";
		map.put("message", msg);
		return new ModelAndView(jsp, "map", map);

	}

	// ----------Hand /Take over By Dipali---19/oct
	@SuppressWarnings("unused")
	public ModelAndView showHandTakeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int deptId = 0;
		int inaptientId=0;
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		String deptName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		map.put("userId", userId);
		if (session.getAttribute("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		if(request.getParameter("parent")!=null && !request.getParameter("parent").equals(""))
		{
			inaptientId=Integer.parseInt(request.getParameter("parent"));
		}
		
		
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put(INPATIENT_ID, inaptientId);
		
		map = ipdHandlerService.showHandTakeJsp(map);
		String entrySeqNo = request.getParameter("entrySeqNo");
		entrySeqNo = ipdHandlerService.getEntrySeqForDisplay("HEN");
		if (entrySeqNo != null) {
			map.put("entrySeqNo", entrySeqNo);
		}
		jsp = HAND_OVER_JSP;
		jsp += ".jsp";
		title = "Hand Take Over";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView submitHandTakeOver(HttpServletRequest request,
			HttpServletResponse response) {
		/*Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		
		
		IpdHandTakeOver ipdHandTakeOver = new IpdHandTakeOver();*/
		Box box=HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId=0;
		int departmentId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		 userId=(Integer)session.getAttribute(USER_ID);
		 departmentId=(Integer)session.getAttribute(DEPT_ID);
		 //int empId=(Integer)
		 box.put(HOSPITAL_ID, hospitalId);
		 box.put(USER_ID, userId);
		 box.put(DEPT_ID, departmentId);
		
		/*String entrySeqNo = "";
		String shiftStartFrom = "";
		String remarksPendingwork = "";
		int handOverId = 0;
		int takeOverId = 0;
		int hospitalId = 0;
		String date = "";
		date = (String) utilMap.get("currentDate");
		Date currentDate = new Date();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (hospitalId != 0) {
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			ipdHandTakeOver.setHospital(masHospital);
		}
		
		Inpatient inpatient=new Inpatient();
		inpatient.setIcdId(box.getInt(INPATIENT_ID));
		ipdHandTakeOver.setInpatient(inpatient);
		
		Patient patient=new Patient();
		patient.setId(box.getInt(HIN_ID));
		ipdHandTakeOver.setHin(patient);
		
		ipdHandTakeOver.setWardBedTransferRequired("n");
		
		
		ipdHandTakeOver.setEntryDate(HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TRANSFER_DATE)));
		ipdHandTakeOver.setEntryTime(request.getParameter(TRANSFER_TIME));
		int fromDepartmentId=Integer.parseInt(request.getParameter(FROM_WARD));
		MasDepartment fromDepartment = new MasDepartment();
		fromDepartment.setId(fromDepartmentId);
		ipdHandTakeOver.setFromDepartment(fromDepartment);
		
		int handById= Integer.parseInt(request.getParameter("fromDoctor"));
		System.out.println("taken by id == "+handById);
		MasEmployee handBy=new MasEmployee();
		handBy.setId(handById);
		ipdHandTakeOver.setHandBy(handBy);
		
		int toDepartmentId=Integer.parseInt(request.getParameter(TO_WARD));
		MasDepartment toDepartment = new MasDepartment();
		fromDepartment.setId(toDepartmentId);
		ipdHandTakeOver.setDepartment(toDepartment);
		
		int takeById= Integer.parseInt(request.getParameter("doctorId"));
		System.out.println("taken by id == "+takeById);
		MasEmployee takeBy=new MasEmployee();
		handBy.setId(takeById);
		ipdHandTakeOver.setTakeBy(takeBy);
		
		
		int departmentId = (Integer) session.getAttribute("deptId");
		MasDepartment masDepartment = new MasDepartment();
		masDepartment.setId(departmentId);
		ipdHandTakeOver.setDepartment(masDepartment);
		
		
		int authorisedById= Integer.parseInt(request.getParameter(AUTHORIZER_ID));
		System.out.println("taken by id == "+takeById);
		MasEmployee authorisedBy=new MasEmployee();
		authorisedBy.setId(authorisedById);
		ipdHandTakeOver.setAuthorisedBy(authorisedBy);

//		if (request.getParameter(ENTRY_NO) != null) {
//			entrySeqNo = request.getParameter(ENTRY_NO);
//		}
		 entrySeqNo = ipdHandlerService.generateEntryNumber();
		ipdHandTakeOver.setEntryNo(entrySeqNo);
		
		ipdHandTakeOver.setLastChgDate(HMSUtil
				.convertStringTypeDateToDateType(date));
		ipdHandTakeOver.setLastChgTime((String)utilMap.get("currentTime"));
		Users users=new Users();
		users.setId((Integer)session.getAttribute(USER_ID));
		ipdHandTakeOver.setLastChgBy(users);*/

		/*if (request.getParameter(FROM_HAND_OVER) != null
				&& !request.getParameter(FROM_HAND_OVER).equals("0")) {
			handOverId = Integer.parseInt(request.getParameter(FROM_HAND_OVER));
		}
		MasEmployee fromHand = new MasEmployee();
		fromHand.setId(handOverId);
		ipdHandTakeOver.setHandBy(fromHand);

		if (request.getParameter(TO_HAND_OVER) != null
				&& !request.getParameter(TO_HAND_OVER).equals("0")) {
			takeOverId = Integer.parseInt(request.getParameter(TO_HAND_OVER));
		}
		MasEmployee takeHand = new MasEmployee();
		takeHand.setId(takeOverId);
		ipdHandTakeOver.setTakeBy(takeHand);

		if (request.getParameter(SHIFT_START_FROM) != null
				&& !request.getParameter(TO_HAND_OVER).equals("")) {
			shiftStartFrom = request.getParameter(SHIFT_START_FROM);
		}
		if (request.getParameter("ampm") != null
				&& !request.getParameter("ampm").equals("")) {
			shiftStartFrom = shiftStartFrom + " "
					+ request.getParameter("ampm");
		}
		ipdHandTakeOver.setShiftTime(shiftStartFrom);
		if (request.getParameter(REMARKS_PENDING_WORK) != null
				&& !request.getParameter(REMARKS_PENDING_WORK).equals("")) {
			remarksPendingwork = request.getParameter(REMARKS_PENDING_WORK);
		}
		ipdHandTakeOver.setRemarksPendingWork(remarksPendingwork);

		ipdHandTakeOver.setEntryDate(HMSUtil
				.convertStringTypeDateToDateType(date));*/
		boolean saved = false;
		String message = "";
		saved = ipdHandlerService.submitHandTakeOver(box);
		if (saved) {
			map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);

			jsp = PATIENT_LIST_NURSE_JSP;
			message = "Record Added Successfully !!";
		} else {
			map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_NURSE_JSP;
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("message", message);

		String jsp = PATIENT_LIST_JSP + ".jsp";
		map.put("contentJsp", jsp);
		//map.put("entrySeqNo", entrySeqNo);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView viewHandTakeOver(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> infoMap = new HashMap<String, Object>();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		infoMap.put(HOSPITAL_ID, hospitalId);
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		infoMap.put(DEPT_ID, deptId);

		Date toDate = null;
		if (request.getParameter("toDate") != null) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter("toDate"));
			infoMap.put("toDate", toDate);
		}
		map = ipdHandlerService.viewHandTakeOver(infoMap);
		jsp = HAND_TAKE_VIEW_JSP;
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showHandTakeOverReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.showHandTakeOverReportJsp();
		jsp = HAND_TAKE_REPORT_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHandTakeOverReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String deptName = "";
		Date date = new Date();

		Date fromDate = null;
		Date toDate = null;
		if (request.getParameter(FROM_DATE) != null
				&& !(request.getParameter(FROM_DATE).equals(""))) {
			fromDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(FROM_DATE));
		}
		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if ((request.getParameter(DEPARTMENT_NAME)) != null
				&& !(request.getParameter(DEPARTMENT_NAME).equals(""))) {
			deptName = request.getParameter(DEPARTMENT_NAME);
		}
		detailsMap = ipdHandlerService.getDBConnection();

		parameters.put("fromDate", fromDate);
		parameters.put("toDate", toDate);
		parameters.put("Ward", deptName);
		HMSUtil.generateReport("ipd_hand_take_over", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}



	public ModelAndView showPrescriptionJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = Integer
				.parseInt(session.getAttribute("deptId").toString());
		int inPatient = 0;
		if (request.getParameter("parent") != null
				&& request.getParameter("parent") != "") {
			inPatient = Integer.parseInt(request.getParameter("parent"));
		}
		map.put("deptId", deptId);
		map.put("inPatient", inPatient);
		map = ipdHandlerService.showPrescriptionJsp(map);
		jsp = PRESCRIPTION_GRID + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPrescriptionDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		List<String> pvmsNoList = new ArrayList<String>();
		List<String> manufacturerList = new ArrayList<String>();
		List<String> manufacturerIdList = new ArrayList<String>();
		List<String> brandIdList = new ArrayList<String>();

		List<Integer> frequencyList = new ArrayList<Integer>();
		List<String> dosageList = new ArrayList<String>();
		List<Integer> totalList = new ArrayList<Integer>();
		List<Integer> noOfDaysList = new ArrayList<Integer>();

		int hdb = 1;
		if (Integer.parseInt(request.getParameter("hdb")) != 1) {
			hdb = Integer.parseInt(request.getParameter("hdb"));

		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("deptId") != null) {
			int deptId = Integer.parseInt(session.getAttribute("deptId")
					.toString());
			map.put("deptId", deptId);
		}
		int hinId = 0;
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
			map.put("hinId", hinId);
		}
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			map.put("inpatientId", inpatientId);
		}
		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = (String) (request.getParameter("hinNo"));
			map.put("hinNo", hinNo);
		}
		String lastChgDate = "";
		if (request.getParameter("lastChgDate") != null) {
			lastChgDate = (String) request.getParameter("lastChgDate");
			map.put("lastChgDate", lastChgDate);
		}
		String lastChgTime = "";
		if (request.getParameter("lastChgTime") != null) {
			lastChgTime = (String) request.getParameter("lastChgTime");
			map.put("lastChgTime", lastChgTime);
		}

		String lastChgBy = "";
		if (request.getParameter("lastChgBy") != null) {
			lastChgBy = (String) request.getParameter("lastChgBy");
			map.put("lastChgBy", lastChgBy);
		}

		String[] pvmsArr = new String[hdb];
		int j = 1;
		for (int i = 0; i < hdb; i++) {
			if (!request.getParameter("nomenclature" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclature" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;

				pvmsArr[i] = nomenclature.substring(index1, index2);

				int frequencyId = Integer.parseInt(request
						.getParameter("frequency" + j));
				String manufacturer = null;
				if (request.getParameter("manufacturer" + j) != null) {
					manufacturer = request.getParameter("manufacturer" + j);

				}
				String brandId = null;
				if (request.getParameter("brandId" + j) != null) {
					brandId = request.getParameter("brandId" + j);

				}
				String manufactureId = null;
				if (request.getParameter("manufactureId" + j) != null) {
					manufactureId = request.getParameter("manufactureId" + j);

				}

				int total = Integer.parseInt(request.getParameter("total" + j));

				int noOfDays = Integer.parseInt(request.getParameter("noOfDays"
						+ j));
				String dosage = request.getParameter("dosage" + j);
				// String pvmsNo=null;
				/*
				 * if(request.getParameter("pvmsNo"+j)!=null) { pvmsNo =
				 * request.getParameter("pvmsNo"+j);
				 * 
				 * }
				 */
				pvmsNoList.add(pvmsArr[i]);
				manufacturerList.add(manufacturer);
				manufacturerIdList.add(manufactureId);
				brandIdList.add(brandId);

				frequencyList.add(frequencyId);
				dosageList.add(dosage);
				totalList.add(total);
				noOfDaysList.add(noOfDays);
			}
			j++;
		}
		map.put("pvmsNoList", pvmsNoList);
		map.put("manufacturerList", manufacturerList);
		map.put("manufacturerIdList", manufacturerIdList);
		map.put("brandIdList", brandIdList);

		map.put("frequencyList", frequencyList);
		map.put("dosageList", dosageList);
		map.put("totalList", totalList);
		map.put("noOfDaysList", noOfDaysList);
		map = ipdHandlerService.submitPrescriptionDetails(map);
		String url = "/hms/hms/ipd?method=showPatientListJsp";
		map.put("url", url);
		message = "Prescription Details has been Saved Successfully ";
		jsp = "message.jsp";
		map.put("messageTOBeVisibleToTheUser", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showInPatientPreviousPrescription(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int ipdNo = Integer.parseInt(request.getParameter("ipdNo"));
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		int deptId = 0;
		if (session.getAttribute("deptId") != null
				&& session.getAttribute("deptId") != "") {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		String nomenclature1 = request.getParameter("nomenclature1");
		mapForDS.put("nomenclature1", nomenclature1);
		mapForDS.put("ipdNo", ipdNo);
		mapForDS.put("hinId", hinId);
		mapForDS.put("inpatientId", inpatientId);
		mapForDS.put("deptId", deptId);

		map = ipdHandlerService.showInPatientPreviousPrescription(mapForDS);

		jsp = OPD_INPATIENT_PRESCRIPTION_JSP;

		title = "Patient Previous Visit";
		map.put("nomenclature1", nomenclature1);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView reportHandTakeOver(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int departmentId = 0;
		int hospitalId = 0;
		Date toDate = null;

		if (request.getParameter(TO_DATE) != null
				&& !(request.getParameter(TO_DATE).equals(""))) {
			toDate = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(TO_DATE));
		}
		if (session.getAttribute("deptId") != null) {
			departmentId = Integer.parseInt(session.getAttribute("deptId")
					.toString());
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("toDate", toDate);
		parameters.put("departmentId", departmentId);
		parameters.put("hospitalId", hospitalId);

		HMSUtil.generateReport(HAND_TAKE_OVER_REPORT, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView getItemStock(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String flag = "";
		int ItemId = 0;
		int counter = 0;
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
			dataMap.put("deptId", deptId);
		}
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(session.getAttribute(HOSPITAL_ID).toString());
			dataMap.put(HOSPITAL_ID, hospitalId);
		}

		if (request.getParameter("ItemId") != null) {
			ItemId = Integer.parseInt(request.getParameter("ItemId"));
			dataMap.put("ItemId", ItemId);
		}

		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
			dataMap.put("counter", counter);
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			dataMap.put("flag", flag);
		}
		map = ipdHandlerService.getItemStock(dataMap);
		jsp = WARD_CONSUMPTION_STOCK;
		title = "Ward Consumption Batch No";
		map.put("counter", counter);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemClosingStock(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String flag = "";
		int ItemId = 0;
		int counter = 0;
		int deptId = 0;
		String batchNo = "";
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer
					.parseInt(session.getAttribute(HOSPITAL_ID).toString());
			dataMap.put(HOSPITAL_ID, hospitalId);
		}
		
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
			dataMap.put("deptId", deptId);
		}

		if (request.getParameter("ItemId") != null) {
			ItemId = Integer.parseInt(request.getParameter("ItemId"));
			dataMap.put("ItemId", ItemId);
		}
		if (request.getParameter("batchNo") != null) {
			batchNo = request.getParameter("batchNo");
			dataMap.put("batchNo", batchNo);
		}

		if (request.getParameter("counter") != null) {
			counter = Integer.parseInt(request.getParameter("counter"));
			dataMap.put("counter", counter);
		}

		if (request.getParameter("flag") != null) {
			flag = request.getParameter("flag");
			dataMap.put("flag", flag);
		}
		map = ipdHandlerService.getItemClosingStock(dataMap);
		jsp = WARD_CONSUMPTION_CLOSING_STOCK;
		title = "Ward Consumption Closing Stock ";
		map.put("counter", counter);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView generateConsumptionReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int deptId = 0;
		int IpIssueMId = 0;
		if (request.getParameter("IpIssueMId") != null
				&& !(request.getParameter("IpIssueMId").equals(""))) {
			IpIssueMId = Integer.parseInt(request.getParameter("IpIssueMId"));

		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer
					.parseInt(session.getAttribute("deptId").toString());
		}
		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("IpIssueMId", IpIssueMId);
		parameters.put("deptId", deptId);

		HMSUtil.generateReport(WARD_CONSUMPTION_REPORT, parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	@SuppressWarnings("unused")
	public ModelAndView showSendSmsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		String deptName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		mapDetail.put("userId", userId);
		mapDetail.put(HOSPITAL_ID, hospitalId);
		if (session.getAttribute("deptName") != null) {
			deptName = request.getParameter("deptName");
		}
		mapDetail.put("deptId", deptId);
		map = ipdHandlerService.showSendSmsJsp(mapDetail);
		/*
		 * String entrySeqNo = request.getParameter("entrySeqNo"); entrySeqNo =
		 * ipdHandlerService.getEntrySeqForDisplay("HEN"); if (entrySeqNo !=
		 * null) { map.put("entrySeqNo", entrySeqNo); }
		 */
		jsp = "showSendSmsJsp";
		jsp += ".jsp";
		title = "Send SMS";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitSendSms(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapDetail = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		String deptName = "";
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		int userId = 0;
		if (session.getAttribute("userId") != null) {
			userId = Integer.parseInt("" + session.getAttribute("userId"));
		}
		mapDetail.put("userId", userId);
		if (session.getAttribute("deptName") != null) {
			deptName = request.getParameter("deptName");
		}

		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		String mobileNo = "";
		String message = "";

		if (request.getParameter(MESSAGE_FOR_WARD_JSP) != null) {
			message = request.getParameter(MESSAGE_FOR_WARD_JSP).trim();

		}
		if (request.getParameter(MOBILE_NO) != null) {
			mobileNo = request.getParameter(MOBILE_NO).trim();

		}
		int empCategoryId = 0;

		if (request.getParameter("selectedChrage") != null
				&& request.getParameter("selectedChrage").equals("y")) {

			if (request.getParameter(EMPLOYEE_CATEGORY_ID) != null) {
				empCategoryId = Integer.parseInt(request
						.getParameter(EMPLOYEE_CATEGORY_ID));
			}
			List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
			masEmployeeList = ipdHandlerService.getEmplist(empCategoryId,
					hospitalId);

			for (MasEmployee masEmployee : masEmployeeList) {
				OneToOne smsout = new OneToOne();
				if (masEmployee.getTelNoOffice() != null
						&& !masEmployee.getTelNoOffice().equals("")) {
					smsout.setSentDate(HMSUtil
							.convertStringTypeDateToDateType(currentDate));
					smsout.setSentTime(time);
					smsout.setStatus("U");
					smsout.setType("N");
					smsout.setMobileNo(masEmployee.getTelNoOffice());
					smsout.setMessage(message);
					mapDetail.put("smsout", smsout);
					mapDetail.put("deptId", deptId);
					map = ipdHandlerService.submitSendSms(mapDetail);
				}
			}
		} else {
			// Vector empId=
			Box box = HMSUtil.getBox(request);
			Vector empId = box.getVector(EMPLOYEE_ID);

			for (int i = 0; i < empId.size(); i++) {
				int employeeId = 0;
				if (empId.get(i) != null && !empId.get(i).equals("")) {
					employeeId = Integer.parseInt(empId.get(i).toString());
				}

				mobileNo = ipdHandlerService.getMobileNo(employeeId);
				OneToOne smsout = new OneToOne();
				smsout.setSentDate(HMSUtil
						.convertStringTypeDateToDateType(currentDate));
				smsout.setSentTime(time);
				smsout.setStatus("U");
				smsout.setType("N");
				smsout.setMobileNo(mobileNo);
				smsout.setMessage(message);
				mapDetail.put("smsout", smsout);
				mapDetail.put("deptId", deptId);
				map = ipdHandlerService.submitSendSms(mapDetail);
			}

		}
		map = ipdHandlerService.showSendSmsJsp(mapDetail);
		jsp = "showSendSmsJsp";
		jsp += ".jsp";
		title = "Send SMS";
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		// boolean sendmsg=false;
		// //Service srv;
		// OutboundMessage msg;
		// /srv = new Service();
		// SerialModemGateway smg;
		// smg=new SerialModemGateway("modem.com1", "COM16", 57600, "Nokia",
		// "6310i");
		// BulkSmsHTTPGateway gateway = new BulkSmsHTTPGateway("bulksms.http.1",
		// "username", "password");
		// gateway.setOutbound(true);
		// msg = new OutboundMessage(mobileNo, message);

		try {
			// srv.addGateway(smg);
			// //
			//
			// srv.startService();
			/*
			 * Phonebook phone=new Phonebook(); phone.getContacts();
			 * InboundMessage im; ArrayList<InboundMessage> messageList = new
			 * ArrayList<InboundMessage>(); readMessages(messageList, msgClass,
			 * smg.getGatewayId()); messageList.toArray(new InboundMessage[0]);
			 * MessageClasses msc; // msc.READ;
			 * Collection<InboundMessage>msgList=msgList.add(im.);
			 * org.smslib.Message.MessageClasses msgClass;
			 * 
			 * //srv.readMessages(im.addText(message), msgClass);
			 * srv.readMessage(smg.getGatewayId(), im.getMemLocation(),
			 * im.getMemIndex());
			 */// OutboundMessage om=new OutboundMessage(mobileNo,message);
				// om.addText(message);
				// srv.sendMessage(om);
				//
				// srv.stopService();
				// boolean flag=srv.sendMessage(msg);
			//
			/*
			 * Scw8 heduler sch; JobListener jl; jl=new JobListener(); jl.
			 */
			// sch.addGlobalJobListener(msg);
			// SendMessage app = new SendMessage();
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Query the service to find out our credit balance.
		try {
			//
		} catch (Exception e) {
			e.printStackTrace();
		}// Send a message synchronously.

		// org.smslib.test.TestGateway test;//=new TestGateway();
		// try{sendMessage(msg);
		// } // srv.sendMessage(msg);
		//
		//
		// System.in.read();
		try {
			// srv.stopService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		// sendmsg="";
		/*
		 * String entrySeqNo = request.getParameter("entrySeqNo"); entrySeqNo =
		 * ipdHandlerService.getEntrySeqForDisplay("HEN"); if (entrySeqNo !=
		 * null) { map.put("entrySeqNo", entrySeqNo); }
		 */
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showWardWiseDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		map = ipdHandlerService.showWardWiseDetails(deptId, hospitalId);
		String jsp = SINGLE_WARD_WISE_PATIENT_POPUP_JSP;
		jsp += ".jsp";
		String title = "Ward Wise Patient Display";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(SINGLE_WARD_WISE_PATIENT_POPUP_JSP, "map", map);
	}

	// ///---Added By Manjul on 10/10/2011-------////

	public ModelAndView getItemListForAutoCompleteItemIpd(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		int counter = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();

		try {
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			map.put(HOSPITAL_ID, hospitalId);
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute("deptId");
				map.put("deptId", deptId);
			}
			// if (request.getParameter("deptId") != null) {
			// deptId = Integer.parseInt(request.getParameter("deptId"));
			// }

			if (request.getParameter("counter") != null) {
				counter = Integer.parseInt(request.getParameter("counter"));
			}

			map.put("userName", userName);
			map.put("autoHint", autoHint);

			map1 = ipdHandlerService.getItemListForAutoCompleteIpd(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map1.put("counter", counter);
		jsp = "opd_responseInGridNew";

		return new ModelAndView(jsp, "map", map1);
	}

	public ModelAndView showClinicalSheetReportScreen(
			HttpServletRequest request, HttpServletResponse response) {

		jsp = "PaientIssueDateWise.jsp";
		// jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView showPatinetIssueRpt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		String regNo = "";
		int hospitalId=0;
		String qry="";
		HttpSession session = request.getSession();
		session = request.getSession();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		try {
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				parameters.put("fromDate", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				parameters.put("toDate", toDate);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				regNo = request.getParameter(HIN_NO);
				qry = "and b.hin_no='"+ regNo + "'";
			} else {
				
				qry = "";
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		detailsMap = ipdHandlerService.getDBConnection();
		parameters.put("qry", qry);
		parameters.put("hospitalId", hospitalId);
		
		
		HMSUtil.generateReport("IP_Patient_Issue", parameters,	(Connection) detailsMap.get("conn"), response,	getServletContext());

		return null;
	}

	public ModelAndView showPatinetissueReport(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		Date fromDate = null;
		Date toDate = null;
		int departmentId = 0;
		int dischargeStatusId = 0;
		byte[] bytes = null;
		String regNo = "";
		HttpSession session = request.getSession();
		List<BlDispensingDetails> itemList = new ArrayList<BlDispensingDetails>();
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				map.put("from_date", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				map.put("to_date", toDate);
			}
			
			if (request.getParameter(HIN_NO) != null
			&& !(request.getParameter(HIN_NO).equals(""))) {
		regNo = request.getParameter(HIN_NO);
		map.put("regNo", regNo);
	} else if (request.getParameter("regNo") != null
					&& !(request.getParameter("regNo").equals(""))) {
				regNo = request.getParameter("regNo");
				map.put("regNo", regNo);
			}
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			
			map = ipdHandlerService.showPatinetissueReport(fromDate, toDate,regNo,hospitalId);
			if (map.get("itemList") != null) {
				itemList = (List<BlDispensingDetails>) map.get("itemList");
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		map.put("itemList", itemList);

		jsp = "PaientIssueDateWiseSearch.jsp";
		// jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAttendanceReportScreen(HttpServletRequest request,
			HttpServletResponse response) {

		jsp = "attendaceReport.jsp";
		// jsp += ".jsp";
		title = "title";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateAttendanceReport(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String month = "";
		String year = "";
		String days = "";
		int noOfUser = 0;
		String monthName = "";
		String month1 = "";
		String years = "";
		List<TempCheckInOutFinal> tcfinallist = new ArrayList<TempCheckInOutFinal>();
		if (request.getParameter("year") != null
				&& !(request.getParameter("year").equals(""))) {
			year = request.getParameter("year");
		}
		if (request.getParameter("month") != null) {
			month = request.getParameter("month").toString();
		}
		tcfinallist = ipdHandlerService.getNumberOfUser(year, month);
		monthName = HMSUtil.getMonthName(month);
		if (tcfinallist.size() < 0 || tcfinallist.size() == 0) {
			days = HMSUtil.countNoOfDays(year, month);
			parameters = ipdHandlerService.getQuery(year, month, days);
		}
		detailsMap = ipdHandlerService.getDBConnection();
		month1 = monthName;
		years = year;
		parameters.put("years", years);
		parameters.put("month1", month1);
		parameters.put("month", month);
		HMSUtil.generateReport("attd_report", parameters,
				(Connection) detailsMap.get("conn"), response,
				getServletContext());
		return null;
	}

	public ModelAndView showEmployee(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> tempMap = new HashMap<String, Object>();
		int hintId = 0;

		int empCategoryId = 0;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		// session = request.getSession();
		if (request.getParameter(EMPLOYEE_CATEGORY_ID) != null
				&& !(request.getParameter(EMPLOYEE_CATEGORY_ID).equals(""))) {
			empCategoryId = Integer.parseInt(request
					.getParameter(EMPLOYEE_CATEGORY_ID));
		}
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		map = ipdHandlerService.showEmployee(empCategoryId, hospitalId);
		if (map.get("employeeList") != null) {
			employeeList = (List<MasEmployee>) map.get("employeeList");
		}

		jsp = "empList";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("employeeList", employeeList);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView showProgressNoteJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		int inpatientId = 0;

		if (request.getParameter("parent") != null) {
			inpatientId = Integer.parseInt(request.getParameter("parent"));
		}
		mapForDs.put("inpatientId", inpatientId);
		map = ipdHandlerService.showProgressNoteJsp(mapForDs);
		jsp = "showProgressNoteJsp";
		// jsp = "empList";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView saveProgressNotes(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = "";
		int deptId = 0;
		int hospitalId = 0;
		HttpSession session = null;
		String saved = "";
		String message = "";
		session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}

		Map<String, Object> map = new HashMap<String, Object>();
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		box.put("deptId", deptId);
		box.put("userName", userName);
		dataMap.put("box", box);
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		dataMap.put("inpatientId", inpatientId);
		map = ipdHandlerService.saveProgressNotes(dataMap);
		if (map.get("saved") != null) {
			saved = "" + map.get("saved");
		}
		if (saved.equals("yes")) {
			message = "Remarks Added Successfully";
		} else {
			message = "Some problem Occured .Try again.";
		}
		jsp = "showProgressNoteJsp";
		jsp += ".jsp";
		title = "";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("deptId", deptId);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPhysiotherapyPatientList(
			HttpServletRequest request, HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		String pFirstName = "";
		String pMiddleName = "";
		String pLastName = "";
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}
		if (request.getParameter(P_FIRST_NAME) != null) {
			pFirstName = request.getParameter(P_FIRST_NAME);
			mapForDS.put("pFirstName", pFirstName);
		}
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			pMiddleName = request.getParameter(P_MIDDLE_NAME);
			mapForDS.put("pMiddleName", pMiddleName);
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			pLastName = request.getParameter(P_LAST_NAME);
			mapForDS.put("pLastName", pLastName);
		}

		// int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("filter") != null) {
			if (request.getParameter("consultingDoc") != null) {
				int empId = Integer.parseInt(request
						.getParameter("consultingDoc"));
				mapForDS.put("empId", empId);
			}
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}

		String title = request.getParameter("title");
		map = ipdHandlerService.getPhysiotherapistPatientList(mapForDS);

		jsp = "ipd_physiotherapy_waitingList";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showIPDPhysiotherapyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		// int token = Integer.parseInt(request.getParameter("token"));
		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = "";
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		mapForDS.put("deptId", deptId);
		mapForDS.put("inpatientId", inpatientId);
		// mapForDS.put("token", token);
		map = ipdHandlerService.getPhysiotherapistList(mapForDS);
		map.put("inpatientId", inpatientId);
		deptName = ipdHandlerService.getDepartmentNameFromId(deptId);
		jsp = "ipd_physiotherapy";
		jsp += ".jsp";
		title = "Patient Details";
		// map.put("inpatientId", inpatientId);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}// showIPDDialysisListDetails

	public ModelAndView showIPDDialysisListDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int inpatientId = 0;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		// int token = Integer.parseInt(request.getParameter("token"));
		int deptId = (Integer) session.getAttribute("deptId");
		String deptName = "";
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		mapForDS.put("deptId", deptId);
		mapForDS.put("inpatientId", inpatientId);
		// mapForDS.put("token", token);
		map = ipdHandlerService.getPhysiotherapistList(mapForDS);
		map.put("inpatientId", inpatientId);
		deptName = ipdHandlerService.getDepartmentNameFromId(deptId);
		jsp = "ipd_dialysis";
		jsp += ".jsp";
		title = "Patient Details";
		// map.put("inpatientId", inpatientId);
		map.put("deptId", deptId);
		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showDialysisPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		String pFirstName = "";
		String pMiddleName = "";
		String pLastName = "";
		String hinNo = "";

		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}
		if (request.getParameter(P_FIRST_NAME) != null) {
			pFirstName = request.getParameter(P_FIRST_NAME);
			mapForDS.put("pFirstName", pFirstName);
		}
		if (request.getParameter(P_MIDDLE_NAME) != null) {
			pMiddleName = request.getParameter(P_MIDDLE_NAME);
			mapForDS.put("pMiddleName", pMiddleName);
		}
		if (request.getParameter(P_LAST_NAME) != null) {
			pLastName = request.getParameter(P_LAST_NAME);
			mapForDS.put("pLastName", pLastName);
		}

		// int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		if (request.getParameter("filter") != null) {
			if (request.getParameter("consultingDoc") != null) {
				int empId = Integer.parseInt(request
						.getParameter("consultingDoc"));
				mapForDS.put("empId", empId);
			}
		}

		if (request.getParameter("deptId") != null) {
			deptId = Integer.parseInt(request.getParameter("deptId"));
			session.setAttribute("deptId", deptId);
			mapForDS.put("deptId", deptId);
		} else {
			deptId = (Integer) session.getAttribute("deptId");
			mapForDS.put("deptId", deptId);
		}

		String title = request.getParameter("title");
		map = ipdHandlerService.getDialysisPatientList(mapForDS);

		jsp = "ipd_dialysis_waitingList";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchPatientFOrAdvance(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientName = "";
		String mobileNo = "";
		/*String patientFName = "";
		String patientMName = "";
		String patientLName = "";*/
		int hinId = 0;
		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo);
			}
			if (request.getParameter("patientName") != null && !(request.getParameter("patientName").equals(""))) {
				patientName = request.getParameter("patientName");
				mapForDs.put("patientName", patientName);
			}
			if (request.getParameter("mobileNo") != null && !(request.getParameter("mobileNo").equals(""))) {
				mobileNo = request.getParameter("mobileNo");
				mapForDs.put("mobileNo", mobileNo);
			}
			/*if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDs.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDs.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDs.put("patientLName", patientLName);
			}*/
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				mapForDs.put("hinId", hinId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		HospitalParameters hospitalParameters = new HospitalParameters();

		map = ipdHandlerService.getSystemParamDetails();
		if (map.get("hospitalParameters") != null) {
			hospitalParameters = (HospitalParameters) map
					.get("hospitalParameters");
		}
		int allowAdvForOp = 0;
		if (hospitalParameters != null) {
			if (hospitalParameters.getAllowOpAdvance() != null) {
				allowAdvForOp = hospitalParameters.getAllowOpAdvance();
			}
		}
		String jsp = "";
		patientMap = ipdHandlerService.getPatientDetailsForAdvance(mapForDs);

		List<Patient> patientList = new ArrayList<Patient>();
		if (patientMap.get("patientDetailsList") != null) {
			patientList = (List<Patient>) patientMap.get("patientDetailsList");
		}
		if ((!hinNo.equals("") && patientList.size() > 0) || hinId != 0) {
			/*if (patientList.get(0).getPatientStatus().equals("Out Patient")
					&& allowAdvForOp == 0) {
				String message = "Advance not allowed for OP Patients.";
				map.put("message", message);
				jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
			} else {*/
				String receiptNo = "";
				receiptNo = ipdHandlerService.generateReceiptNo("display");
				map.put("receiptNo", receiptNo);
				jsp = "depositsForAdvance" + ".jsp";
			//}
		} else {
			jsp = SEARCH_PATIENT_FOR_ADVANCE_JSP + ".jsp";
		}

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientAdmissionAcceptJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		int hospitalId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDs.put(DEPT_ID, deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		map = ipdHandlerService.getDetailOfWaitingInPatient(mapForDs);
		jsp = PATIENT_ADMISSION_ACCEPTANCE + ".jsp";
		// map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPatientAdmissionAcceptJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = 0;
		int hospitalId = 0;
		String ipdNo = "";
		int bedId = 0;
		String bedAllocationTime="";
		Date bedAllocationDate= new Date();
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int empId=0;
		if(session.getAttribute("empId")!=null){
			empId=(Integer)session.getAttribute("empId");
		}
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
		}
		
		if (request.getParameter("inpatientId") != null) {
			ipdNo = request.getParameter("inpatientId");
		}
		int inpatientId=0;
		if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if (request.getParameter("bedId") != null
				&& !request.getParameter("bedId").equals("")) {
			bedId = Integer.parseInt(request.getParameter("bedId"));
		}
		if (request.getParameter("bedAllocationDate") != null
				&& !request.getParameter("bedAllocationDate").equals("")) {
			bedAllocationDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter("bedAllocationDate"));
		}
		if (request.getParameter("bedAllocationTime") != null
				&& !request.getParameter("bedAllocationTime").equals("")) {
			bedAllocationTime = request.getParameter("bedAllocationTime");
		}
		//added by govind 02-02-2017
		String dependentName=null;
		int relation =0;
		if (request.getParameter("depname") != null
				&& !request.getParameter("depname").equals("")) {
			dependentName = request.getParameter("depname");
		}
		if (request.getParameter("deprelation") != null) {
			relation = Integer.parseInt(request.getParameter("deprelation"));
		}
		
		System.out.println("dependentName "+dependentName+" relation "+relation);
		mapForDs.put("dependentName", dependentName);
		mapForDs.put("relation", relation);
		//added by govind 02-02-2017 end
		
		mapForDs.put("userId", userId);
		mapForDs.put("empId", empId);
		mapForDs.put(DEPT_ID, deptId);
		mapForDs.put(HOSPITAL_ID, hospitalId);
		mapForDs.put("bedId", bedId);
		mapForDs.put("ipdNo", ipdNo);
		mapForDs.put("inpatientId", inpatientId);
		System.out.println("inpatient id"+inpatientId);
		mapForDs.put("bedAllocationDate", bedAllocationDate);
		mapForDs.put("bedAllocationTime", bedAllocationTime);
		map=ipdHandlerService.patientAdmissionAccept(mapForDs);
		
		map.putAll(ipdHandlerService.getDetailOfWaitingInPatient(mapForDs));

		jsp = PATIENT_ADMISSION_ACCEPTANCE + ".jsp";
		// map.put("patientMap", patientMap);
		map.put("ipdNo", ipdNo);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPatientKitIssueJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		map = ipdHandlerService.getPatientDetailsForKitIssue(box);
		
		jsp = "patientKitIssue.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCaseSheetJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		
		if (session.getAttribute(DEPT_ID) != null)
		{
			box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
			mapForDs.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
		}
		if (session.getAttribute(HOSPITAL_ID) != null)
		{
			box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
			mapForDs.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
		}
		// map = ipdHandlerService.showCaseSheetJsp(box);
		int userId=0;
		if(session.getAttribute("userId")!=null){
			userId=(Integer)session.getAttribute("userId");
			box.put("userId",userId);
			mapForDs.put("userId", userId);
		}
		int empId=0,hinId=0;
		if(session.getAttribute("empId")!=null){
			empId=(Integer)session.getAttribute("empId");
		}
		map = ipdHandlerService.showNewCaseSheetJsp(box);
		
		if(map.get("inpatientId")!=null){
			hinId=Integer.parseInt(map.get("inpatientId").toString());
		}
		mapForDs = ipdHandlerService.showDepartmentSpeciality(mapForDs);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService
				.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if (detailsMap.get("diagnosisList") != null) {
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if (detailsMap.get("disabilityList") != null) {
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		// String jsp = "ipdCaseSheet.jsp";
		
	    //added by govind 23-01-2017
	      String orderNo="";
	      int inpatientId=0;
	      int OrderId=0;
	      if(hinId>0){
			//box.put("visitId", visit.getId());
			box.put("hinId", hinId);
			  System.out.println("hinId "+hinId);
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2 = ipdHandlerService.showPatientLabResultIP(box);
			if(map2.get("orderNo")!=null){
				orderNo=map2.get("orderNo").toString();
			}
			if(map2.get("OrderId")!=null){
				OrderId=(Integer)map2.get("OrderId");
			}
	      }
	      map.put("orderNo", orderNo);
	      map.put("OrderId",OrderId);
	      System.out.println("opd OrderNo "+orderNo+" OrderId "+OrderId);
	      //added by govind 23-01-2017 end
		String jsp = "ipdCaseSheetNew.jsp";
		
		map.putAll(mapForDs);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitIpdCaseSheetDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		String tempalteName = "";
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		box.put("deptId", (Integer) session.getAttribute("deptId"));
		Users users = (Users)session.getAttribute("users");
		if (session.getAttribute("hospitalCode") != null) {
			String hospitalCode=(String) session.getAttribute("hospitalCode");
			box.put("hospitalCode", hospitalCode);
		}
		box.put("userId", users.getId());
		box.put("userName", users.getUserName());
		box.put("empId", users.getEmployee().getId());
		int deptId = (Integer) session.getAttribute("deptId");
		List mlcNameList = new ArrayList();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");
		box.put("time", time);
		if (request.getParameterValues("mlscasetype")!=null && !request.getParameterValues("mlscasetype").equals("")) {
			String[] mlcStr=request.getParameterValues("mlscasetype");
			for (int j = 0; j < mlcStr.length; j++) {
				String mlcName =(mlcStr[j]);
				mlcNameList.add(mlcName);
			}
			generalMap.put("mlcNameList", mlcNameList);
	    }
		
		// start of code by amit das on 22-07-2016
		//persisting speciality    
		int specialtyId=0;
		String[] parameterId=null;
		String[] textValue =null;
		if(request.getParameter("specialty")!=null)
					specialtyId = Integer.parseInt(request.getParameter("specialty"));
		
		if(request.getParameterValues("parameterId")!=null)
			parameterId=request.getParameterValues("parameterId");
		
		if(request.getParameterValues("textValue")!=null)
			textValue=request.getParameterValues("textValue");
		
		generalMap.put("specialtyId", specialtyId); 
		
		Map<String, Object> mapForSpeciality = null;
		if(specialtyId!=0 && parameterId.length>0 && textValue.length>0){
					 mapForSpeciality =	ipdHandlerService.saveSpeciality(generalMap); 
		}
		// ended by amit das on 22-07-2016
		
		String praganancy="";
		if(request.getParameter("preganancy")!=null && request.getParameter("preganancy").equalsIgnoreCase("y") ){
			praganancy=request.getParameter("preganancy");
			generalMap.put("praganancy", "y");
		}
		else{
			generalMap.put("preganancy", "n");
		}
		String lactation="";
		if(request.getParameter("lactation")!=null && request.getParameter("lactation").equalsIgnoreCase("y") ){
			praganancy=request.getParameter("lactation");
			generalMap.put("lactation", "y");
		}
		else{
			generalMap.put("lactation", "n");
		}
		int period=0;
		
		if(request.getParameter("period")!=null && !request.getParameter("period").equalsIgnoreCase("") ){
			period=Integer.parseInt(request.getParameter("period")) ;
			generalMap.put("period", period);
		}
		String remarks="";
		if(request.getParameter("remarks")!=null && !request.getParameter("remarks").equalsIgnoreCase("") ){
			remarks=request.getParameter("remarks") ;
			generalMap.put("remarks", remarks);
		}
		
		datamap = ipdHandlerService.submitIpdCaseSheetDetails(box,generalMap);
		
		
		int opdPatientDetailId=0;
		OpdPatientDetails opdPatientDetails =null;
		if(datamap.get("OpdPatientDetails")!=null){
			opdPatientDetails=(OpdPatientDetails)datamap.get("OpdPatientDetails");
			box.put("opdPatientDetailId", opdPatientDetails.getId());
			opdPatientDetailId=opdPatientDetails.getId();
		}
		
		
		int hinId=0;
		if(datamap.get("hinId")!=null) {
			hinId = (Integer)datamap.get("hinId");
			box.put("hinId",hinId);
		}
		int inpatientId=0;
		if(datamap.get("inpatientId")!=null) {
			inpatientId = (Integer)datamap.get("inpatientId");
		}
		int visitId = 0;
		if(datamap.get("visitId")!=null) {
			visitId = (Integer)datamap.get("visitId");
		}
		
		
		 Map<String, Object> mapForGeneralSurgery = null;
		

			String lymphadenopathyValueSelect = "";
			String[] lymphadenopathyValueSelectArray = null;
			if (request.getParameterValues("lymphadenopathyValue1") != null) {
				lymphadenopathyValueSelectArray = (String[]) request
						.getParameterValues("lymphadenopathyValue1");
				for (int x = 0; x < lymphadenopathyValueSelectArray.length; x++) {
					if (x == 0) {
						lymphadenopathyValueSelect = lymphadenopathyValueSelectArray[x];
					} else {
						lymphadenopathyValueSelect = lymphadenopathyValueSelect + ","
								+ lymphadenopathyValueSelectArray[x];
					}
				}
				box.put("lymphadenopathyValueSelect", lymphadenopathyValueSelect);
				
			}
		 Map<String, Object> mapForNicuCaseRecord = null;
		 if(box.getString("generalSurgeryFlag").equalsIgnoreCase("General Surgery")){
			 mapForGeneralSurgery =	ipdHandlerService.saveGeneralSurgery(box); // added by amit das on 22-07-2016
			 tempalteName = "General Surgery";
			 map.put("opdPatientDetailId",opdPatientDetailId);
		}
			 
		if(mapForGeneralSurgery!=null)
			map.putAll(mapForGeneralSurgery);
		
		 Map<String, Object> mapForNeonatal = null;
		
		 if(box.getString("neonatalFlag").equalsIgnoreCase("Neonatal")){
			 mapForNeonatal =	ipdHandlerService.saveNeonatal(box); // added by amit das on 22-07-2016
			 if(mapForNeonatal!=null)
					map.putAll(mapForNeonatal);
			 tempalteName = "Neonatal";
			 map.put("opdPatientDetailId",opdPatientDetailId);
		}
		
		 
	
		
		
		Map<String, Object> antenatalCardMap = null;
		
		if(box.getString("antenatalCardFlag").equalsIgnoreCase("AntenatalCard")){
			Map<String, Object> infoMap = null;
			
			infoMap = addAntenatalCardForTemplate(request);
			
			infoMap.put("opdPatientDetailId",opdPatientDetails.getId());
			infoMap.put("inpatientId",inpatientId);
			
			antenatalCardMap = opdHandlerService.addAntenatalCard2(infoMap);
			tempalteName = "Antenatal Card";
		}
		
		String backUrl="";
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}
		String adNo="";
		if(datamap.get("adNo")!=null) {
			adNo = (String)datamap.get("adNo");
		}
		String hinNo="";
		if(datamap.get("hinNo")!=null) {
			hinNo = (String)datamap.get("hinNo");
		}
		System.out.println("inpatientId=====below===="+inpatientId);
		
		List set = (List) map.get("inpatientSet");
		if (flag) {
			message = "Case Sheet Details submitted successfully.Do you to print Case Sheet?";
		map.put("printUrl", "/hms/hms/ipd?method=showPatientMedicalCaseSheetReportNew&adNo="+adNo+"&hinNo="+hinNo+"&inpatientId="+inpatientId+"&fromDate="+currentDate);
//			map.put("printUrl", "/hms/hms/ipd?method=showPatientMedicalCaseSheetReportNew&adNo="+box.getString("adNo")+"&hinNo="+box.getString("hinNo")+"&fromDate="+currentDate);
			backUrl="/hms/hms/ipd?method=showPatientListJsp";
			//map.put("backUrl", "/hms/hms/ipd?method=showPatientListJsp");
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("hinId",hinId);
		map.put("tempalteName",tempalteName);
		map.put("visitId",visitId);
		jsp = "messageForWard.jsp";
		map.put("messageTOBeVisibleToTheUser", message);
		map.put("message", message);
		map.put("backUrl", backUrl);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewMotherCashSheet(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		String hinNo = "";
		String msg = "";
		if(request.getParameter("motherHinNo") != null){
			hinNo = request.getParameter("motherHinNo");
			box.put("hinNo", hinNo);
		}
		map = ipdHandlerService.viewMotherCashSheet(box);
		String adNo = "";
		int inpatientId = 0;
		if(map.get("adNo") != null){
			adNo = (String)map.get("adNo");
		}
		if(map.get("inPatientId") != null){
			inpatientId = (Integer)map.get("inPatientId");
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		System.out.println("inpatientId=========>"+inpatientId);
		System.out.println("hospitalId=========>"+hospitalId);
		System.out.println("hinNo=========>"+hinNo);
		
		parameters.put("inpatientId", inpatientId);
		parameters.put("hospitalId", hospitalId);
		//parameters.put("visitNo", visiNo);
		parameters.put("hin_no", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));
		try {
			
			HMSUtil.generateReport("medicalCaseSheetnewforstorageIP", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		return null;
	
	}
	
	
	
	
	
	
	
	
	@SuppressWarnings( { "unchecked", "unchecked" })
	public void showPatientMedicalCaseSheetReportNew(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		String visiNo = "";
		String hinNo = "";
		int inpatientId = 0;
		
		if (request.getParameter("adNo") != null) {
			visiNo = request
					.getParameter("adNo");
		}
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		if(request.getParameter("inpatientId")!= null){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		detailsMap = ipdHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();
		System.out.println("inpatientId=========>"+inpatientId);
		System.out.println("hospitalId=========>"+hospitalId);
		System.out.println("hinNo=========>"+hinNo);
		
		parameters.put("inpatientId", inpatientId);
		parameters.put("hospitalId", hospitalId);
		//parameters.put("visitNo", visiNo);
		parameters.put("hin_no", hinNo);
		parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
				"/Reports/"));
		try {
			/*byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("medicalCaseSheetnewforstorage"), parameters,
						(Connection) detailsMap.get("conn"));
				System.out.println("bytes-------------->"+bytes.length);

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
			HMSUtil.generateReport("medicalCaseSheetnewforstorageIPD", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

			*/
			HMSUtil.generateReport("medicalCaseSheetnewforstorageIP", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());

		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
	
	}
	
	
	public ModelAndView showPrescriptionEntryDetailHomeJsp(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("showPrescriptionEntryDetailHomeJsp calling "+(request.getParameter("hinId")!=null));

		HttpSession session = request.getSession();
		
		Box box=HMSUtil.getBox(request);
		//System.out.println("hinid "+box.get("hinId"));
		int patId = Integer.parseInt(request.getParameter("hinId"));
	//	String caretime = request.getParameter("caretime");
	//	String deptName = request.getParameter("deptName");
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = 0;
		int hospitalId=0;
		if (session.getAttribute("deptId") != null) {
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}
		box.put("deptId", deptId);
		box.put(HOSPITAL_ID, hospitalId);
		
		map = ipdHandlerService.getPrescriptionListForPatient(box);
		
		//added by govind 23-09-2016
		map.put("deptId", deptId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put("hinId", patId);
		

		// Set set=(Set)map.get("patientSet");
		jsp = PRESCRIPTION_ENTRY_DETAILS;
		jsp += ".jsp";
		title = "Prescription Entry Detail";
	//	map.put("deptName", deptName);
	//	map.put("caretime", caretime);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView submitWardConsumption(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("In submit method con");
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
			box.put("deptId", (Integer) session.getAttribute("deptId"));
			Users users = (Users)session.getAttribute("users");
			box.put("userId", users.getId());
			box.put("userName", users.getUserName());
			box.put("empId", users.getEmployee().getId());
			int deptId = (Integer) session.getAttribute("deptId");
			boolean successfullyAdded = ipdHandlerService.submitWardConsumption(box);
			
			if (successfullyAdded) {

				map = ipdHandlerService.getPatientList(deptId, hospitalId,users.getId());
				List inpatientSet = (List) map.get("inpatientSet");
				map.put("inPatientSet", inpatientSet);
				map.put("andNo", box.getInt(AD_NO));
				map.put("inpatientId", box.getInt(INPATIENT_ID));
//				jsp = MESSAGE_FOR_INTAKE_OUTPUT;
				jsp = PATIENT_LIST_NURSE_JSP;
				message = "Record Added Successfully.";

			} else {
				map = ipdHandlerService.getPatientList(deptId, hospitalId,users.getId());
				List inpatientSet = (List) map.get("inpatientSet");
				map.put("inPatientSet", inpatientSet);
				jsp = MESSAGE_FOR_INTAKE_OUTPUT;
				message = " Error Ocurred Please Try Again !!";

			}
			jsp += ".jsp";
			//title = "IntakeOutput";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("deptId", deptId);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	

	public ModelAndView showMedicineIssueDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int inPatientId = 0;
		if (request.getParameter("parent") != null
				&& request.getParameter("parent") != "") {
			inPatientId = Integer.parseInt(request.getParameter("parent"));
		}
		Box box = HMSUtil.getBox(request);
		int deptId = (Integer) (session.getAttribute("deptId"));
		box.put("inPatientId", inPatientId);
		box.put("deptId", deptId);
		map = ipdHandlerService.showMedicineIssueDetailJsp(box);
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = ipdHandlerService
				.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
		if (detailsMap.get("diagnosisList") != null) {
			map.put("diagnosisList", detailsMap.get("diagnosisList"));
		}
		if (detailsMap.get("disabilityList") != null) {
			map.put("disabilityList", detailsMap.get("disabilityList"));
		}
		jsp = "medicine_issue_jsp";
		jsp += ".jsp";
		title = "Medicine Issue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showAlergyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer) session.getAttribute(DEPT_ID);
		int userId=(Integer) session.getAttribute(USER_ID);
		int empId=(Integer) session.getAttribute("empId");
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID	, deptId);
		box.put(USER_ID	, userId);
		box.put("empId", empId);
		map=ipdHandlerService.getPatientAllergy(box);
		jsp = "alergy_jsp";
		jsp += ".jsp";
		title = "Medicine Issue";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitAlergyJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		int hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer) session.getAttribute(DEPT_ID);
		int userId=(Integer) session.getAttribute(USER_ID);
		int empId=(Integer) session.getAttribute("empId");
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID	, deptId);
		box.put(USER_ID	, userId);
		box.put("empId", empId);
//		Box box=HMSUtil.getBox(request);
		map=ipdHandlerService.submitPatientAllergy(box);
		
		boolean flag = false;
		if(map.get("flag")!=null) {
			flag = (Boolean)map.get("flag");
		}

//		Map<String, Object> utilMap = new HashMap<String, Object>();
//		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
//		String currentDate = (String) utilMap.get("currentDate");
		if (flag) {
			message = "Patient Allergy Details submitted successfully";
//			map.put("printUrl", "/hms/hms/ipd?method=showPatientMedicalCaseSheetReportForWard&adNo="+box.getString("adNo")+"&hinNo="+box.getString("hinNo")+"&serviceNo="+box.getString("serviceNo")+"&fromDate="+currentDate);
//			map.put("backUrl", "/hms/hms/ipd?method=showPatientListJsp");
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		
		
		map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);

		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_JSP;
		jsp += ".jsp";
		title = "Admitted Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message", message);
		
		/*if()
		jsp = "alergy_jsp";
		jsp += ".jsp";
		title = "Medicine Issue";
		map.put("contentJsp", jsp);
		map.put("title", title);*/
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPendingBloodRequestEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		jsp = "bld_pndingacknowledge";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showBloodRequestAcknowledgeJsp(
			HttpServletRequest request, HttpServletResponse response) {
		jsp = "bld_acknowledge";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showDietSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map=ipdHandlerService.getDetailForDietSchedule(box);
		map.put("box", box);
		jsp = "dietScheduling";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	public ModelAndView submitDietSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map=ipdHandlerService.submitDetailForDietSchedule(box);
		map=ipdHandlerService.getDetailForDietSchedule(box);
		map.put("message", "Diet Scheduled Successfully.");
		map.put("box", box);
		jsp = "dietScheduling";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	
	public ModelAndView showIssueDietJsp(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = "dietScheduling";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showWardTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map=ipdHandlerService.getDetailsForBedTransferAcceptance(box);
		
		jsp = "wardtransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitWardTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		map=ipdHandlerService.submitWardTransferAcceeptance(box);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map.putAll(ipdHandlerService.getDetailsForBedTransferAcceptance(box));
		jsp = "wardtransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showCareTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		map=ipdHandlerService.getCareTransferAccepJsp(box);
		
//		map.putAll(ipdHandlerService.getDetailsForBedTransferAcceptance(box));
		
		
		jsp = "caretransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitCareTransferAccepJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		map=ipdHandlerService.submitcareTransferAcceeptance(box);
		
		map.putAll(ipdHandlerService.getCareTransferAccepJsp(box));
		jsp = "caretransferaccept";
		jsp += ".jsp";
		title = "Pending Acknowledge List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView showUploadingDocumentsJsp(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); Map<String,
		 * Object> mapForDS = new HashMap<String, Object>(); int visitId = 0;
		 * if(request.getParameter("visitId")!=null &&
		 * !request.getParameter("visitId").equals("")){ visitId =
		 * Integer.parseInt(request.getParameter("visitId")); } int token = 0;
		 * if(request.getParameter("token")!=null){ token =
		 * Integer.parseInt(request.getParameter("token")); } String backFlag =
		 * ""; if(request.getParameter("backFlag")!=null){ backFlag
		 * =request.getParameter("backFlag"); } int inpatientId = 0;
		 * if(request.getParameter("parent")!=null &&
		 * !request.getParameter("parent").equals("")){ inpatientId =
		 * Integer.parseInt(request.getParameter("parent")); } String
		 * reportingFor=""; if(request.getParameter("reportingFor")!=null){
		 * reportingFor = request.getParameter("reportingFor");
		 * mapForDS.put("reportingFor", reportingFor); } // map =
		 * opdHandlerService
		 * .showUploadingDocumentsJsp(visitId,inpatientId,mapForDS);
		 * map.put("visitId", visitId); map.put("token", token);
		 * map.put("backFlag", backFlag); map.put("inpatientId", inpatientId);
		 * // jsp = "opd_uploadpatientdoc" + ".jsp"; // map.put("contentJsp",
		 * jsp); String jsp = ""; if(backFlag.equals("OPD") ||
		 * backFlag.equals("dental") || backFlag.equals("fp") ){ //jsp =
		 * "opd_uploadpatientdoc";// comment by javed khan for CSRF protection
		 * on 10-03-2013
		 */map.put("contentJsp", "opd_uploadpatientdoc.jsp"); // added by javed
																// khan for CSRF
																// protection on
																// 10-03-2013
		/*
		 * jsp = "indexPop"; // added by javed khan for CSRF protection on
		 * 10-04-2013 }else{
		 * 
		 * map.put("contentJsp", "opd_uploadpatientdoc.jsp"); // comment by
		 * javed khan for CSRF protection on 10-03-2013 jsp = "index"; }
		 */
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showGeneratepassJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID,deptId);
		box.put(USER_ID,userId);
		
		map=ipdHandlerService.getDetailForPassPrinting(box);
		
		jsp = "generatepass";
		jsp += ".jsp";
		title = "Generate Pass";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitGeneratepassJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		String message="";
		
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID,deptId);
		box.put(USER_ID,userId);
		
		
		map=ipdHandlerService.submitGeneratepass(box);
		if(map.get("saveMess")!=null){
		
		Boolean saveMess=(Boolean)map.get("saveMess");
			

		if(saveMess==true){
			message="AllReady Have Pass On Selected Date";
		}
	  else if(saveMess==false){
			message="AllReady Have Pass";
		}
				
		}
			
		box.put("parent", box.getInt(INPATIENT_ID));
		
		if(map.get("ipdGatepassDetails")!=null){
		try {
		
			
			IpdGatepassDetails ipdGatepassDetails=(IpdGatepassDetails)map.get("ipdGatepassDetails");
			String reportName = "";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			Map<String, Object> detailsMap = ipdHandlerService
					.getConnectionForReport();
			Map<String, Object> connectionMap = ipdHandlerService
					.getConnectionForReport();
			
			parameters.put("hospitalId",hospitalId);
			parameters.put("ipdgatepassdetailId",ipdGatepassDetails.getId());

			
			parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
			reportName = "gatepass";
			 
			HMSUtil.generateReport(reportName, parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
			map.put("message", "Gate pass generated successfully. ");
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		}
		map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
		
		map.put("message", message);
		System.out.println(message);
		
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = PATIENT_LIST_NURSE_JSP;
		jsp += ".jsp";
		title = "Admitted Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPrintpassJsp(HttpServletRequest request,
			HttpServletResponse response) {
		jsp = "printpass";
		jsp += ".jsp";
		title = "Print Pass";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getTemplateDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box =HMSUtil.getBox(request);
		map = ipdHandlerService.getTemplateDetails(box);
		return new ModelAndView("responseIPDKitIssue", "map", map);
	}
	
	public ModelAndView submitPatientKitIssue(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> datamap = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put("hospitalId", hospitalId);
		Users users = (Users)session.getAttribute("users");
		box.put("userId", users.getId());
		int deptId = (Integer) session.getAttribute("deptId");
		int inpatientId=Integer.parseInt(request.getParameter("inpatientId"));
        box.put("inpatientId", inpatientId);
		datamap = ipdHandlerService.submitPatientKitIssue(box);
		boolean flag = false;
		if(datamap.get("flag")!=null) {
			flag = (Boolean)datamap.get("flag");
		}

		map = ipdHandlerService.getPatientList(deptId,hospitalId,users.getId());
		List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);
		jsp = "messageForWard.jsp";
		String backUrl = "/hms/hms/ipd?method=showPatientListNurseJsp";
		if (flag) {
			map.put("printUrl", "/hms/hms/ipd?method=printIssuedKitListReport&adNo="+box.getString("adNo")+"&hinNo="+box.getString("hinNo")+"&serviceNo="+box.getString("serviceNo")+"&hospitalId="+hospitalId);	
			message = "Kit Issue Details submitted successfully !!";
		} else {
			message = " Error Ocurred Please Try Again !!";
		}
		map.put("backUrl", backUrl);
		map.put("message", message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView searchNextOfKinPatient(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		box.put(NEXT_OF_KIN_UHID, request.getParameter(NEXT_OF_KIN_UHID));
		map = ipdHandlerService.searchNextOfKinPatient(box);
		
		return new ModelAndView("nextOfKinSearchJsp", "map", map);
	}
	
	public ModelAndView showCreateVirtualBed(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID,deptId);
		map = ipdHandlerService.showCreateVirtualBed(box);
		jsp="VirtualBedJsp";
		jsp +=".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitCreateVirtualBed(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID,deptId);
		box.put(USER_ID,userId);
		ipdHandlerService.submitCreateVirtualBed(box);
//		map=ipdHandlerService.getPatientList(deptId, hospitalId);
//		jsp = PATIENT_LIST_JSP;
//		jsp += ".jsp";
//		map.put("contentJsp", jsp);
		return new ModelAndView("redirect:ipd?method=showPatientListNurseJsp");
	}
	
	public ModelAndView updateItemUnit(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		map=ipdHandlerService.getItemUnit(box);

		return new ModelAndView("updateunit","map",map);
	}
	
	public ModelAndView showPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		String hinNo = "";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		dataMap.put("hinNo", hinNo);
		map = ipdHandlerService.showPatientDetails(dataMap);
		String jsp = PATIENT_DETAILS + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("patientAndAdDetails", "map", map);
	}
	
	public ModelAndView checkBedStatus(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int bedId=0;
		if(request.getParameter("bedId")!=null && !request.getParameter("bedId").equals("") )
		{
		 bedId=Integer.parseInt(request.getParameter("bedId"));
		}
		 boolean status=false;
		 if(bedId!=0)
		 {
		 status=ipdHandlerService.checkBedStatus(bedId);
		 }
		 map.put("status", status);
		String jsp = "checkBedStatus";
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
	}
	
	
	
	public ModelAndView showWardConsList(HttpServletRequest request,
			HttpServletResponse response) {
		int deptId = 0;
		int hospitalId=0;
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String deptName = (String)session.getAttribute("deptName");
		deptId = (Integer)session.getAttribute("deptId");
		hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		map = ipdHandlerService.showWardConsList(deptId,hospitalId);

		jsp = WARD_CON_LIST_JSP;
		jsp += ".jsp";
		title = "Ward Consumption";
		map.put("deptName", deptName);
		map.put("deptId", deptId);

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitWardConsDetails(HttpServletRequest request, HttpServletResponse response) 
	{		
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
	//	List issQtyList = new ArrayList();
		List amountList = new ArrayList();
		List pvmsList = new ArrayList();
		List batchNumberList = new ArrayList();
		List brandNameList = new ArrayList();
		List<String> expiryDateList = new ArrayList<String>();
		List costPriceList = new ArrayList();
		List storeItemBatchStockIdList = new ArrayList();
		try {

			int deptId = Integer.parseInt(request.getParameter("deptId"));
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			int userId=0;

			int hospitalId=0;
			if(session.getAttribute("hospitalId")!=null)
 			{
			hospitalId = (Integer) session.getAttribute("hospitalId");
 			}
			if(session.getAttribute("userName")!=null)
 			{
			String userName = (String) session.getAttribute("userName");
 			}
			if(session.getAttribute("userId")!=null)
 			{
			 userId = (Integer) session.getAttribute("userId");
 			}
			
			int storeFyDocumentNoId=0;
			int wardIssueNo=0;
			if((request.getParameter("storeFyDocumentNoId"))!=null)
 			{
				storeFyDocumentNoId	= Integer.parseInt(request.getParameter("storeFyDocumentNoId"));
 			}
			
			if(request.getParameter("wardIssueNo")!=null)
 			{
				wardIssueNo	= Integer.parseInt(request.getParameter("wardIssueNo"));
 			}
			
			
			int counter = 1;
 			if((request.getParameter("counter"))!=null)
 			{
 					counter	= Integer.parseInt(request.getParameter("counter"));
 			}
 			int j=1;
 			for (int i = 0; i <counter; i++) {
 				if(request.getParameter("ItemId" + j)!=null)
 				{
 			 	   	pvmsList.add(request.getParameter("ItemId" +j));
 				}
 				if(request.getParameter("batchNo" + j)!=null)
 				{
 			 	   	batchNumberList.add(request.getParameter("batchNo" + j));
 				}
 			 	   	// brandNameList.add(request.getParameter("brandId"+i));
 				if(request.getParameter("expDate" + j)!=null)
 				{
					expiryDateList.add(request.getParameter("expDate" + j));
 				}
 				if(request.getParameter("closeStock" + j)!=null)
 				{
					costPriceList.add(request.getParameter("closeStock" + j));
 				}
 				if(request.getParameter("storeItemBatchStockId" + j)!=null){
					storeItemBatchStockIdList.add(request.getParameter("storeItemBatchStockId" + j));
 				}
 				if(request.getParameter("compQuantity" + j)!=null)
 				{
					amountList.add(request.getParameter("compQuantity" + j));
 				}
					j++;
			 }
			map.put("deptId", deptId);
			map.put("hospitalId", hospitalId);
			map.put("userId", userId);
			map.put("date", date);
			map.put("time", time);
 			map.put("userName", userName);
			map.put("pvmsList", pvmsList);
			map.put("batchNumberList", batchNumberList);
			// map.put("brandNameList", brandNameList);
			map.put("expiryDateList", expiryDateList);
//			map.put("issQtyList", issQtyList);
			map.put("costPriceList", costPriceList);
			map.put("amountList", amountList);
			map.put("storeItemBatchStockIdList", storeItemBatchStockIdList);
			map.put("storeFyDocumentNoId", storeFyDocumentNoId);
			map.put("wardIssueNo", wardIssueNo);
			
			
			
 			boolean successfullyAdded = ipdHandlerService.submitWardConsDetails(map);

 			String url = "ipd?method=showPatientListNurseJsp";
 			map.put("url", url);
 			if (successfullyAdded) {
				message = "Stock  has been Updated Successfully !!";
			} else {
				message = "Error Ocurred Please Try Again!!";
			}
			jsp = STOCK_UPDATED_MESSAGE_JSP;
			jsp +=".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
			} catch (Exception e) {
				e.printStackTrace();
			}

		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getNursingCareSttus(HttpServletRequest request, HttpServletResponse response) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		//List<IpdCareDetails> ipdCareDetailList=new ArrayList<IpdCareDetails>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		box.put(DEPT_ID, deptId);
		box.put(HOSPITAL_ID, hospitalId);
		box.put("setupId", request.getParameter("setupId"));
		map=ipdHandlerService.getNursingCareSttus(box);
		
		jsp = "proscedureStatus";
		//map.put("ipdCareDetailList", ipdCareDetailList);
		
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView showAmbulanceRunRegister(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		box.put(DEPT_ID, deptId);
		box.put(HOSPITAL_ID, hospitalId);
		map = ipdHandlerService.showAmbulanceRunRegister(box);
		String jsp = "ambulanceRunRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView saveAmbulanceRunRegisterDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int chargeSlipNo = 0;
		if(box.getInt("ambulanceCharge") != 0){
		chargeSlipNo = ipdHandlerService.getChargeSlipNo("save",hospitalId);
		System.out.println("chargeSlipNo=="+chargeSlipNo);
		box.put("chargeSlipNo", chargeSlipNo);
		}
		map = ipdHandlerService.saveAmbulanceRunRegisterDetails(box);
		boolean flag = (Boolean)map.get("flag");
		String message = ""; 
		if(flag){
			message = "Record Saved Successfully.";
		}else{
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp="ambulanceRunRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	
	public ModelAndView getProcedureForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int inPatientId = Integer.parseInt(request.getParameter("parent"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);
		detailsMap.put(HOSPITAL_ID, hospitalId);

		map = ipdHandlerService.getProcedureForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);
		

		jsp = "procedureForDischargeSummary";
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	
	
	
	public ModelAndView getTreatmentDetailsForDischargeSummary(
			HttpServletRequest request, HttpServletResponse response) {

		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = ipdHandlerService.getTreatmentDetailsForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);

		jsp = "treatmentForDischargeSummary";
		
		map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView showExtraDietJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));

		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put("deptId", deptId);

		map = ipdHandlerService.getTreatmentDetailsForDischargeSummary(detailsMap);
		map.put("inPatientId", inPatientId);

		jsp = "extradietjsp";
		
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);
		
	}
	
	public ModelAndView autoCompleteForDietItem(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		//int deptId = (Integer) session.getAttribute("deptId");
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		
		String rquiredField=request.getParameter("requiredField");
		System.out.println("required field is == "+rquiredField);
		String searchQuery=request.getParameter(rquiredField);
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		//detailsMap.put("inPatientId", inPatientId);
		//detailsMap.put("deptId", deptId);
		detailsMap.put("searchQuery", searchQuery);

		map = ipdHandlerService.getDietItemForAutoComplete(detailsMap);
		map.put("inPatientId", inPatientId);

		jsp = "dietautocomplete";
		
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);		
	}
	
	public ModelAndView showDietCombinationjsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int inPatientId = Integer.parseInt(request.getParameter("parent"));
		int mas_diet_id = Integer.parseInt(request.getParameter(DIET_TYPE_ID));
		int diet_menu_type_id = Integer.parseInt(request.getParameter(DIET_MENU_ITEM_ID));
		String requitiondate = request.getParameter("dietForDate");
		
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap.put("inPatientId", inPatientId);
		detailsMap.put(DEPT_ID, deptId);
		detailsMap.put(HOSPITAL_ID, hospitalId);
		detailsMap.put(DIET_TYPE_ID, mas_diet_id);
		detailsMap.put(DIET_MENU_ITEM_ID, diet_menu_type_id);
		detailsMap.put("requitiondate", requitiondate);

		map = ipdHandlerService.getDietCombinationItems(detailsMap);
		map.put("inPatientId", inPatientId);
		map.put(DIET_TYPE_ID, mas_diet_id);
		map.put(DIET_MENU_ITEM_ID, diet_menu_type_id);
		

		jsp = "dietcombinationjsp";
		
		//map.put("contentJsp", jsp);
		return new ModelAndView(jsp, "map", map);		
	}
	
	
	public ModelAndView showDietForIndoorPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		 map = ipdHandlerService.getDietForIndoorPatientList(box);
		 map.put("box", box);
		 
		jsp = DIET_INDOOR_PATIENT_JSP;
		jsp += ".jsp";
		title = "Chart of diet for indoor patient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitDietForIndoorPatientList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		 map = ipdHandlerService.submitDietForIndoorPatient(box);
		 map.put("box", box);
		 map.put("message", "Diet issued successfully. ");
		 
		jsp = DIET_INDOOR_PATIENT_JSP;
		jsp += ".jsp";
		title = "Chart of diet for indoor patient";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showSaveTreatmentTamplate(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int empId=(Integer)session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		 map.put("box", box);
		
		 
		jsp = "treatmentTemplate";
		jsp += ".jsp";
		title = "Save As Treatment Tamplate";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getPaywardWaitingList(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		System.out.println("dept id is "+deptId);
		box.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
		map = ipdHandlerService.getPaywardWaitingList(box);
		String jsp ="payward_waiting_list.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getItemId(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		map = ipdHandlerService.getItemId(box);
		map.put("counter", box.getInt("counter"));
		String jsp ="responseForBatchNo";
		return new ModelAndView(jsp,"map",map);
	}
	
	public ModelAndView submitPayward(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int deptId = 0;
		HttpSession session = request.getSession();
		if (session.getAttribute("deptId") != null)
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		box.put("deptId", deptId);
		System.out.println("dept id is "+deptId);
		box.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));
		map = ipdHandlerService.submitPayward(box);
		String jsp ="payward_waiting_list.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView getPrescriptionTemplateOP(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			HttpSession session=request.getSession();
			Integer hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
			Integer userId=(Integer) session.getAttribute(USER_ID);
			Integer deptId=(Integer) session.getAttribute(DEPT_ID);
			Box box=HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(USER_ID, userId);
			box.put(DEPT_ID, deptId);
			map.put("hospitalId", hospitalId);
			map=ipdHandlerService.getPrescriptionTemplate(box);
			}
		catch(Exception e){
				e.printStackTrace();
			}
		    jsp = "ipd_responseForPrescriptionTemplate";
		    map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getLabInvestigationTemplate(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			HttpSession session=request.getSession();
			Integer hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
			Integer userId=(Integer) session.getAttribute(USER_ID);
			Integer deptId=(Integer) session.getAttribute(DEPT_ID);
			Box box=HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(USER_ID, userId);
			box.put(DEPT_ID, deptId);
			map.put("hospitalId", hospitalId);
			map=ipdHandlerService.getLabInvestigationTemplate(box);
			map.put("hinId", Integer.parseInt(box.get("hinId")));
			}
		catch(Exception e){
				e.printStackTrace();
			}
		    jsp = "ipd_responseForLabInvestigationTemplate";
		    map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView showHouseKeepingSetupJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box =HMSUtil.getBox(request);
		box.put(HOSPITAL_ID,(Integer)session.getAttribute(HOSPITAL_ID));
		box.put(DEPT_ID,(Integer)session.getAttribute(DEPT_ID));
		Map<String, Object> map = new HashMap<String, Object>();
		map = ipdHandlerService.houseKeepingSetup(box);		
		jsp = "housekeepingSetup";
		jsp += ".jsp";
		title = "Clinical Setup";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/*
	 * method to add the House Keeping for the Hospital with the number of times
	 * per day frequency.
	 */
	@SuppressWarnings("unchecked")
	public ModelAndView addHouseKeepingSetup(HttpServletRequest request,
			HttpServletResponse response) {
		String takeSetFromSessionInJsp = "true";
		HttpSession session = request.getSession();
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		box.put(DEPT_ID, deptId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put(USER_ID, userId);
		boolean successfullyAdded = ipdHandlerService.addHouseKeeping(box);
		if (successfullyAdded) {
			message = "Cares has been Setup Successfully !!";
		} else {
			message = "Try Again !!";
		}
		/*map = ipdHandlerService.getPatientList(deptId, hospitalId);*/
		/*List set = (List) map.get("inpatientSet");
		map.put("inPatientSet", set);*/
		map = ipdHandlerService.houseKeepingSetup(box);		
		jsp = "housekeepingSetup";		jsp += ".jsp";
		title = "Patient List";
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showHousekeepingEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		 HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
//		String deptName = request.getParameter("deptName");
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int userId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		Box box=HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		box.put(DEPT_ID, deptId);
		map = ipdHandlerService.searchHouseKeeping(box);
//		map = ipdHandlerService.showCaresList(box);

		jsp = "houseKeepingEntry";
		jsp += ".jsp";
		title = "Nursing Entry";
//		map.put("deptName", deptName);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	
	@SuppressWarnings("unchecked")
	public ModelAndView submitHouseKeepingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Box box=HMSUtil.getBox(request);
			int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			int deptId = (Integer) session.getAttribute(DEPT_ID);
			int userId = (Integer) session.getAttribute(USER_ID);
			
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
			box.put(USER_ID, userId);
			boolean successfullyAdded = ipdHandlerService
					.submitHouseKeepingDetails(box); 
			if (successfullyAdded) {
			map = ipdHandlerService.searchHouseKeeping(box);
			jsp = "houseKeepingEntry";
			message="Successfully Added!!";
			} else{
				map = ipdHandlerService.searchHouseKeeping(box);
				jsp = "houseKeepingEntry";
				message="Try Again!!";
			}
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showBloodRequestEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		String adNo="";
		String hinNo="";
		HttpSession session = request.getSession();
		if(request.getParameter(AD_NO)!=null){
			adNo=request.getParameter(AD_NO);
		}
		if(request.getParameter(HIN_NO)!=null){
			hinNo=request.getParameter(HIN_NO);
		}
		
		
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		//System.out.println("adNo-->"+adNo);
		//System.out.println("hinNo-->"+hinNo);
		//fdfgdgdfgddg
		int hinId=0;
		hinId=ipdHandlerService.getHinId(adNo);
		if (hinId != 0) {
			map = ipdHandlerService.showBloodRequestEntryJsp(hinId,hospitalId);
			String orderSeqNo = "";
			orderSeqNo = ipdHandlerService.getOrderSeqForDisplay("RON",hospitalId);
			if (orderSeqNo != null) {
				map.put("orderSeqNo", orderSeqNo);
			}
		}
		jsp = BLOOD_REQUEST + ".jsp";

		map.put("contentJsp", jsp);
		map.put("hinId", hinId);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView 	showPostPaidSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		
		map=ipdHandlerService.searchPatientForPostPaid(box);
		jsp = "search_postpaid" + ".jsp";

		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView 	submitPostPaid(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box=HMSUtil.getBox(request);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		int empId = (Integer) session.getAttribute("empId");
		box.put(HOSPITAL_ID, hospitalId);
		box.put(DEPT_ID, deptId);
		box.put(USER_ID, userId);
		box.put("empId", empId);
		
		map=ipdHandlerService.submitForPostPaid(box);
		boolean status=(Boolean) map.get("status");
		if(status)
		{
			map.put("message", "PAtient Updated Successfully");
		}
		else
		{
			map.put("message", "Error Occured. Please Try After Some Time!!!");

		}
		map.putAll(ipdHandlerService.searchPatientForPostPaid(box));
		jsp = "search_postpaid" + ".jsp";

		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView 	showAmbulanceRunRequest(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		HttpSession session=request.getSession();
		Box box=HMSUtil.getBox(request);
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		box.put(DEPT_ID, deptId);
		box.put(HOSPITAL_ID, hospitalId);
		int inpatientId=0;
		if(box.getInt("parent")!=0){
			inpatientId=box.getInt("parent");
		}
		box.put("inpatientId",inpatientId);
		map = ipdHandlerService.showAmbulanceRunRequest(box);
		String jsp = "ambulanceRunRequest.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView saveAmbulanceRunRequestDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = ipdHandlerService.saveAmbulanceRunRequestDetails(box);
		boolean flag = (Boolean)map.get("flag");
		String message = ""; 
		if(flag){
			message = "Record Saved Successfully.";
		}else{
			message = "Try Again.";
		}
		map.put("message", message);
		String jsp="ambulanceRunRegister.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView  showWaitingForBlodTransfusionJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		map = ipdHandlerService.showWaitingForBlodTransfusionJsp(box);
		/*boolean flag = (Boolean)map.get("flag");*/
		/*String message = ""; 
		if(flag){
			message = "Record Saved Successfully.";
		}else{
			message = "Try Again.";
		}
		map.put("message", message);*/
		String jsp="waitingListForIPDBloodTransfusion.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView showWardWasteHandoverjsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		
		map=ipdHandlerService.showWardWasteHandoverjsp(box);
		String jsp="wasteHandOverJsp.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView addWasteHandOver(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		boolean saved=false;
		map=ipdHandlerService.addWasteHandOver(box);
		if(map.get("saved")!=null){
			saved=(Boolean)map.get("saved");
		}
		if(saved==true){
			message="Handed Over Succesfully!!";
		}else{
			message="Try Again!!";
		}
		String jsp="wasteHandOverJsp.jsp";
		map.put("message",message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView showWardWasteDisposaljsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		
		map=ipdHandlerService.showWardWasteDisposaljsp(box);
		String jsp="wasteDisposal.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView getDetailsForwasteDisposal(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
	 int headerId=0;
	 if(request.getParameter("headerId")!=null){
		 headerId=Integer.parseInt(request.getParameter("headerId"));
	 }
		map=ipdHandlerService.getDetailsForwasteDisposal(headerId,hospitalId);
		String jsp="wasteDisposalDetails.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	
	}
	public ModelAndView saveDispDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
	
	 int headerId=0;
	 if(request.getParameter("headerId")!=null){
		 headerId=Integer.parseInt(request.getParameter("headerId"));
	 }
	 
	 int disposalId=0;
	 if(request.getParameter("dispName")!=null){
		 disposalId=Integer.parseInt(request.getParameter("dispName"));
	 }
	  
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

		BioWasteDisposal BioWasteDisposal=new BioWasteDisposal();
		
		BioWasteHandOver  BioWasteHandOver=new BioWasteHandOver();
		BioWasteHandOver.setId(headerId);
		BioWasteDisposal.setHandOver(BioWasteHandOver);
		
		BioWasteDisposal.setLasChgDate(new Date());
		BioWasteDisposal.setLastChgTime(time);
		
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			user.setId(user.getId());
			BioWasteDisposal.setLastChgBy(user);
		}
		
		MasWasteDisposal masWaste=new MasWasteDisposal();
		masWaste.setId(disposalId);
		BioWasteDisposal.setDisposal(masWaste);
		
		
		boolean updated=false;
	    updated=ipdHandlerService.saveDispDetails(BioWasteDisposal,headerId);
	    String message="";
	    if(updated==true){
		 message="Updated SuccessFully!!";
	 }else{
		 message="Try Again!!";
	 }
	 String jsp="wasteDisposalDetails.jsp";
	 map.put("message",message);
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView showWardServiceCanCelledJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int inpatientId=box.getInt("parent");
		map=ipdHandlerService.showWardServiceCanCelledJsp(inpatientId);
		String jsp="IpServiceCancellation.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView getServiceGridIP(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		String service="";
		String hinNo="";
		if(request.getParameter("hinNo")!=null){
			hinNo=request.getParameter("hinNo");
		}
		if(request.getParameter("service")!=null){
			service=request.getParameter("service");
		}
		map=ipdHandlerService.getServiceGrid(service,hinNo);
		String jsp="responseForIpServiceCancellation";
		map.put("contentJsp", jsp);
		map.put("service",service);
		return new ModelAndView(jsp,"map",map);
		}
	public ModelAndView cancelServiceInv(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int dtId=0;
		if(request.getParameter("dtId")!=null){
			dtId=Integer.parseInt(request.getParameter("dtId"));
		}
		String service="";
		if(request.getParameter("service")!=null){
		service=request.getParameter("service");	
		}
		
		Map<String,Object>map1=new HashMap<String,Object>();
		boolean cancelled=false;
		cancelled=ipdHandlerService.cancelServiceInv(dtId,service);
		int parent=box.getInt("parent");
		map=ipdHandlerService.showWardServiceCanCelledJsp(parent);
		String message="";
		if(cancelled==true){
			message="Cancelled Successfully!!";
		}else{
			message="Try Agaian!!";
		}
		
		String jsp="IpServiceCancellation.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView cancelServiceInv2(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session= request.getSession();
		int hospitalId = 0;
		int deptId=(Integer)session.getAttribute(DEPT_ID);
		box.put(DEPT_ID, deptId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		if (session.getAttribute("users") != null) {
			Users user = (Users) session.getAttribute("users");
			box.put("userId", user.getId());
		}
		int dtId=0;
		/*if(request.getParameter("dtId")!=null){
			dtId=Integer.parseInt(request.getParameter("dtId"));
		}*/
		
		Vector status = box.getVector("canStatus");
		Vector detailId=box.getVector("detailId");
		System.out.println(detailId+""+status);
		int parent=box.getInt("parent");
		for (int i = 0; i < status.size(); i++) {
			String status1 = "";
			if (status.get(i) != null && !status.get(i).equals("")) {
				status1 = (status.get(i).toString());
			}
			if(status1.equals("y")){
				if(detailId.get(i)!=null && !detailId.get(i).equals("") && !detailId.get(i).equals("0")){
				dtId=Integer.parseInt(detailId.get(i).toString());
				}
			boolean cancelled=false;
			System.out.println("in if --->>"+dtId);
			cancelled=ipdHandlerService.cancelServiceInv(dtId,"inv");
			String message="";
			if(cancelled==true){
				message="Cancelled Successfully!!";
			}else{
				message="Try Agaian!!";
			}
			}
			
		}
		
		/*for(int k=0;k<)*/
		map=ipdHandlerService.showWardServiceCanCelledJsp(parent);
		String jsp="IpServiceCancellation.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	
	public ModelAndView	cancelServicePresc(HttpServletRequest request,HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		Vector prescStatus=box.getVector("canPrescStatus");
		Vector detailPrescId=box.getVector("detailPrescId");
		System.out.println(detailPrescId+"<---detailPrescId------prescStatus---------->"+prescStatus);
		int dtId=0;
		for (int i = 0; i < prescStatus.size(); i++) {
			String prescStatus1 = "";
			if (prescStatus.get(i) != null && !prescStatus.get(i).equals("")) {
				prescStatus1 = (prescStatus.get(i).toString());
			}
			if(prescStatus1.equals("y")){
				if(detailPrescId.get(i)!=null && !detailPrescId.get(i).equals("") && !detailPrescId.get(i).equals("0")){
				dtId=Integer.parseInt(detailPrescId.get(i).toString());
				}
			boolean cancelled=false;
			System.out.println("in if --->>"+dtId);
			cancelled=ipdHandlerService.cancelServiceInv(dtId,"presc");
			String message="";
			if(cancelled==true){
				message="Cancelled Successfully!!";
			}else{
				message="Try Agaian!!";
			}
			}
			
		}
		int parent=box.getInt("parent");
		map=ipdHandlerService.showWardServiceCanCelledJsp(parent);
		String jsp="IpServiceCancellation.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView	 cancelServiceDiet(HttpServletRequest request,HttpServletResponse response){
		Box box = HMSUtil.getBox(request);
		Vector dietStatus=box.getVector("canDietStatus");
		Vector detailDietId=box.getVector("detailDietId");
		System.out.println(dietStatus+"<---detailPrescId------prescStatus---------->"+detailDietId);
		int dtId=0;
		for (int i = 0; i < dietStatus.size(); i++) {
			String dietStatus1 = "";
			if (dietStatus.get(i) != null && !dietStatus.get(i).equals("")) {
				dietStatus1 = (dietStatus.get(i).toString());
			}
			if(dietStatus1.equals("y")){
				if(detailDietId.get(i)!=null && !detailDietId.get(i).equals("") && !detailDietId.get(i).equals("0")){
				dtId=Integer.parseInt(detailDietId.get(i).toString());
				}
			boolean cancelled=false;
			System.out.println("in if --->>"+dtId);
			cancelled=ipdHandlerService.cancelServiceInv(dtId,"diet");
			String message="";
			if(cancelled==true){
				message="Cancelled Successfully!!";
			}else{
				message="Try Agaian!!";
			}
			}
			
		}
		int parent=box.getInt("parent");
		map=ipdHandlerService.showWardServiceCanCelledJsp(parent);
		String jsp="IpServiceCancellation.jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index","map",map);
	}
	public ModelAndView printOutOfStockMedicine(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		HttpSession session = request.getSession();

		try {
			Map<String, Object> detailsMap = ipdHandlerService
					.getConnectionForReport();
		
			if (request.getParameter(RequestConstants.AD_NO) != null && !(request.getParameter(RequestConstants.AD_NO).equals(""))) {
				String ad_no =request.getParameter(RequestConstants.AD_NO);
				parameters.put("ad_no", ad_no);
			}
			if (request.getParameter(RequestConstants.HIN_NO) != null && !(request.getParameter(RequestConstants.HIN_NO).equals(""))) {
				String hinNo =request.getParameter(RequestConstants.HIN_NO);
				parameters.put("hinNo", hinNo);
			}
			parameters.put("hospitalId",(Integer) session.getAttribute(HOSPITAL_ID));

			HMSUtil.generateReport("PatientPrescriptionFormatForOutOfStock", parameters,
					(Connection) detailsMap.get("conn"), response,
					getServletContext());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void getItemForAllergy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*List objectList = new ArrayList();*/
		String val="";
		if(request.getParameter("val")!=null){
			val=request.getParameter("val");
		}
		
		String itemCode = "";
		if (request.getParameter("id") != null) {
			itemCode = (request.getParameter("id"));
		}
		dataMap.put("itemCode", itemCode);
		dataMap.put("val", val);
		int hinId=0;
		if(request.getParameter("visitId")!=null && !request.getParameter("visitId").equals("0")){
			hinId=Integer.parseInt(request.getParameter("visitId"));
		}
		List<OpdPatientAllergyT> allergyTList = new ArrayList<OpdPatientAllergyT>();
		map = ipdHandlerService.getItemForAllergy(val,hinId);
		boolean matched=false;
		if(map.get("matched")!=null){
			matched=(Boolean)map.get("matched");
		}
		allergyTList = (List) map.get("allergyTList");
		String allergyString = "";
		for (OpdPatientAllergyT masIcd : allergyTList) {
			allergyString = allergyString.concat(masIcd.getAllergen()).concat(" ");
		}
		System.out.println("matched--->>>"+matched);
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<allergyString>" + matched + "</allergyString>");
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
	}
	
	
	public ModelAndView showIntakeOutputChartIdReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		//String admissionNumber = null;
		//Date toDate = new Date();
		//Date fromDate = new Date();
		byte[] bytes = null;
		int intakeoutput_id=0;
		HttpSession session = request.getSession();
		requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		try {
			/*if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
			}
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
			}
			if (request.getParameter("adNo") != null
					&& !(request.getParameter("adNo").equals(""))) {
				admissionNumber = request.getParameter("adNo");
			}*/
			if (request.getParameter("intakeoutput_id") != null
					&& !(request.getParameter("intakeoutput_id").equals(""))) {
				intakeoutput_id = Integer.parseInt(request.getParameter("intakeoutput_id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		map = ipdHandlerService.getDBConnection();
		//map.put("fromDate", fromDate);
		//map.put("toDate", toDate);
		//map.put("adNo", admissionNumber);
		map.put("intakeoutput_id", intakeoutput_id);
		map.put("SUBREPORT_DIR", getServletContext().getRealPath("/Reports/"));
		map.put(HOSPITAL_ID, session.getAttribute("hospitalId"));
		HMSUtil.generateReport("IntakeOutput_id", map,
				(Connection) map.get("conn"), response, getServletContext());
		return null;
	}
	
	public void	getDetailsForPendingServices(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int inpatientId=0;
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").equals("0")){
			inpatientId=Integer.parseInt(request.getParameter("inpatientId"));
		}
		map=ipdHandlerService.ggetDetailsForPendingServices(inpatientId);
		List<InpatientPrescriptionDetails>inpatientPrescriptionDetailsList=new ArrayList<InpatientPrescriptionDetails>();
		List<DgOrderdt>dtList=new ArrayList<DgOrderdt>();
		
		
		if(map.get("ippDetailsList")!=null){
			inpatientPrescriptionDetailsList=(List<InpatientPrescriptionDetails>)map.get("ippDetailsList");
		}
		if(map.get("dtList")!=null){
			dtList=(List<DgOrderdt>)map.get("dtList");
		}
		boolean matched=false;
		if(inpatientPrescriptionDetailsList.size()>0 || dtList.size()>0 ){
			matched=true;
		}
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<pendingString>" + matched + "</pendingString>");
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
	}
public void	getDetailsForFinalBill(HttpServletRequest request,
		HttpServletResponse response){
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	int inpatientId=0;
	if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").equals("0")){
		inpatientId=Integer.parseInt(request.getParameter("inpatientId"));
	}
	map=ipdHandlerService.getDetailsForFinalBill(inpatientId);
	List<BlFinalBillDetails>finalBillDetailsList=new ArrayList<BlFinalBillDetails>();
	
	
	
	if(map.get("finalBillDetailsList")!=null){
		finalBillDetailsList=(List<BlFinalBillDetails>)map.get("finalBillDetailsList");
	}
	
	boolean matched=false;
	if(finalBillDetailsList.size()==0 ){
		matched=true;
	}
	StringBuffer sb = new StringBuffer();
	sb.append("<item>");
	sb.append("<pendingString>" + matched + "</pendingString>");
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
}


public void populateChargeAmoutForAmbulance(HttpServletRequest request,
		HttpServletResponse response) throws IOException {
	
	Map<String, Object> dataMap = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	int chargeId = 0;
	if (request.getParameter("chargeId") != null) {
		chargeId = Integer.parseInt(request.getParameter("chargeId"));
	}
	int hospitalId = 0;
	HttpSession session = request.getSession();
	if (session.getAttribute("hospitalId") != null){
		hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
	}
	List<MasChargeCode> masChargeCodeList = new ArrayList<MasChargeCode>();
	dataMap.put("hospitalId", hospitalId);
	dataMap.put("chargeId", chargeId);
	detailsMap = ipdHandlerService.populateChargeAmoutForAmbulance(dataMap);
	
	int chargeAbleAmount = 0;
	if(detailsMap.get("chargeAbleAmount") != null){
		chargeAbleAmount =(Integer)detailsMap.get("chargeAbleAmount");
	}
	masChargeCodeList = (List<MasChargeCode>) detailsMap.get("masChargeCode");
	// ------------Response------------------
	StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<Charge>" +chargeAbleAmount+"</Charge>");
		
		sb.append("</item>");
	
	response.setContentType("text/xml");
	response.setHeader("Cache-Control", "no-cache");
	response.getWriter().write(
			"<?xml version='1.0' encoding='ISO-8859-1'?>");
	response.getWriter().write("<items>");
	response.getWriter().write(sb.toString());
	response.getWriter().write("</items>");
	//
}

public ModelAndView getReferedPatientList(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute(DEPT_ID) != null)
	{
		box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
	}
	if (session.getAttribute(HOSPITAL_ID) != null)
	{
		box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
	}
	// map = ipdHandlerService.showCaseSheetJsp(box);
	int userId=0;
	if(session.getAttribute("userId")!=null){
		userId=(Integer)session.getAttribute("userId");
		box.put("userId",userId);
	}
	int hospitalId=0;
	hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
	map=ipdHandlerService.getReferalList(hospitalId,userId);
	
	String jsp="";
	jsp="internalReferalIP.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
	}

/*public ModelAndView showDetailsReferalRecord(HttpServletRequest request,
		HttpServletResponse response) {
	int remarksId=0;
	if(request.getParameter("reamrksId")!=null){
		remarksId=Integer.parseInt(request.getParameter("reamrksId"));
	}
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute(DEPT_ID) != null)
	{
		box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
	}
	if (session.getAttribute(HOSPITAL_ID) != null)
	{
		box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
	}
	// map = ipdHandlerService.showCaseSheetJsp(box);
	int userId=0;
	if(session.getAttribute("userId")!=null){
		userId=(Integer)session.getAttribute("userId");
		box.put("userId",userId);
	}
	int hospitalId=0;
	hospitalId=(Integer) session.getAttribute(HOSPITAL_ID);
	map=ipdHandlerService.getReferalDetailsList(remarksId);
	String jsp="";
	jsp="internalReferalIPDetails.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
}*/
public ModelAndView showDetailsReferalRecord(HttpServletRequest request,
		HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	Box box = HMSUtil.getBox(request);
	if (session.getAttribute(DEPT_ID) != null)
	{
		box.put(DEPT_ID, (Integer) session.getAttribute(DEPT_ID));
	}
	if (session.getAttribute(HOSPITAL_ID) != null)
	{
		box.put(HOSPITAL_ID, (Integer) session.getAttribute(HOSPITAL_ID));
	}
	// map = ipdHandlerService.showCaseSheetJsp(box);
	int userId=0;
	if(session.getAttribute("userId")!=null){
		userId=(Integer)session.getAttribute("userId");
		box.put("userId",userId);
	}
	int empId=0;
	if(session.getAttribute("empId")!=null){
		empId=(Integer)session.getAttribute("empId");
	}
	int remarksId=0;
	if(request.getParameter("reamrksId")!=null){
		remarksId=Integer.parseInt(request.getParameter("reamrksId"));
	}
	System.out.println("remarksId=222==="+remarksId);
	box.put("empId", empId);
	box.put("parent", remarksId);
	map = ipdHandlerService.showDetailsReferalRecord(box);
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap = ipdHandlerService
			.getPatientLatestDiagnosisAndDisability(box.getInt("parent"));
	if (detailsMap.get("diagnosisList") != null) {
		map.put("diagnosisList", detailsMap.get("diagnosisList"));
	}
	if (detailsMap.get("disabilityList") != null) {
		map.put("disabilityList", detailsMap.get("disabilityList"));
	}
	// String jsp = "ipdCaseSheet.jsp";
	String jsp = "ipdCaseSheetNew.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index", "map", map);
}
public ModelAndView updateReferal(HttpServletRequest request,HttpServletResponse response){
	int remarksId=0;
	if(request.getParameter("remarksId")!=null){
		remarksId=Integer.parseInt(request.getParameter("remarksId"));
	}
	String Remarks="";
	if(request.getParameter("newRemarks")!=null){
		Remarks=(request.getParameter("newRemarks"));
	}
	Map<String, Object> map = new HashMap<String, Object>();
	boolean updated=false;
	updated=ipdHandlerService.updateReferal(Remarks,remarksId);
	String message="";
	
	if(updated==true){
		message="Updated Successfully!!";
	}else{
		message="Not Updated Successfully!!";
	}
	String jsp="";
	jsp="internalReferalIPDetails.jsp";
	map.put("contentJsp", jsp);
	map.put("message",message);
	return new ModelAndView("index","map",map);
}
public ModelAndView displayUnitWiseBed(HttpServletRequest request,
		HttpServletResponse response) {
	// --------------- Retriving User Name,Hospital Id,Department Id from
	// Session-----

	int deptId = 0;
	int hospitalId = 0;
	String unitCode="";
	int inpatientId=0;
	HttpSession session = request.getSession();

	if (session.getAttribute("deptId") != null) {
		deptId = Integer.parseInt("" + session.getAttribute("deptId"));
	}
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}

	String itemNameField = "";
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	try {
		if (request.getParameter("unitCode") != null) {
			unitCode = (request.getParameter("unitCode"));
		}
		if (request.getParameter("inpatientId") != null && !request.getParameter("inpatientId").equals("0")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		System.out.println(inpatientId+"inpatientId");
		System.out.println(unitCode+"unitCode");
		dataMap.put("unitCode", unitCode);
		dataMap.put("deptId", deptId);
		dataMap.put("inpatientId", inpatientId);
		dataMap.put("hospitalId", hospitalId);
		map = ipdHandlerService.displayUnitWiseBed(dataMap);
	} catch (Exception e) {
		e.printStackTrace();
	}
	jsp = "responseUnitWiseBed";
	return new ModelAndView(jsp, "map", map);
}

public ModelAndView showAmbulanceRegisterReport(HttpServletRequest request, HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	String jsp = "ambulanceRegisterReport.jsp";
	map.put("contentJsp", jsp);
	return new ModelAndView("index","map",map);
	
}

public ModelAndView printAmbulanceRegisterReport(HttpServletRequest request, HttpServletResponse response) {
	Date fromDate = new Date();
	Date toDate = new Date();

	if (request.getParameter(FROM_DATE) != null) {
		fromDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(FROM_DATE));
	}
	if (request.getParameter(TO_DATE) != null) {
		toDate = HMSUtil.convertStringTypeDateToDateType(request
				.getParameter(TO_DATE));
	}
	
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap =ipdHandlerService.getConnectionForReport();
	Map<String, Object> parameters = new HashMap<String, Object>();
	HttpSession session = request.getSession();
	parameters.put("hospitalId", (Integer)session.getAttribute("hospitalId"));

	parameters.put("fromDate", fromDate);
	parameters.put("toDate", toDate);
	HMSUtil.generateReport("AmbulanceRunRegisterReport", parameters,
			(Connection) detailsMap.get("conn"), response,
			getServletContext());
	return null;

}


public ModelAndView getAllIcdForDischargeSummary(
		HttpServletRequest request, HttpServletResponse response) {

	Map<String, Object> map = new HashMap<String, Object>();

	HttpSession session = request.getSession();
	
	int deptId = (Integer) session.getAttribute("deptId");
	int inPatientId = Integer.parseInt(request.getParameter("parent"));

	Map<String, Object> detailsMap = new HashMap<String, Object>();
	detailsMap.put("inPatientId", inPatientId);
	detailsMap.put("deptId", deptId);

	map = ipdHandlerService.getAllIcdForDischargeSummary(detailsMap);
	map.put("inPatientId", inPatientId);

	jsp = "allICDForDischargeSummary";
	
	map.put("contentJsp", jsp);
	return new ModelAndView(jsp, "map", map);
	
}
public ModelAndView getAllWardRemarks(
HttpServletRequest request, HttpServletResponse response) {

Map<String, Object> map = new HashMap<String, Object>();

HttpSession session = request.getSession();

int deptId = (Integer) session.getAttribute("deptId");
int inPatientId = Integer.parseInt(request.getParameter("parent"));

Map<String, Object> detailsMap = new HashMap<String, Object>();
detailsMap.put("inPatientId", inPatientId);
detailsMap.put("deptId", deptId);

map = ipdHandlerService.getAllWardRemarks(detailsMap);
map.put("inPatientId", inPatientId);

jsp = "allWardRemarks";

map.put("contentJsp", jsp);
return new ModelAndView(jsp, "map", map);

}
public String submitAdmissionInformationFromLean(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();  
		//int hospitaId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		//map.put("hospitalId", hospitaId);
		map=ipdHandlerService.saveObject(map, box);
	if(map.get("success")!=null){
		return "success";
	}else{
		return "failure";
	}
	
}



// Added method By Amit Das on 23-02-2016

/*public ModelAndView showChangeSchemeJsp(HttpServletRequest request,
		HttpServletResponse response) {
	int inpatientId = 0;
	if (request.getParameter("parent") != null) {
		inpatientId = Integer.parseInt(request.getParameter("parent"));
	} 
	
	map = ipdHandlerService.getPatientScheme(inpatientId);

	jsp = PATIENT_SCHEME_JSP;
	jsp += ".jsp";
	map.put("contentJsp", jsp);

	return new ModelAndView("index", "map", map);
 
}
*/

// Added method By Amit Das on 23-02-2016
public ModelAndView updateInpatientScheme(HttpServletRequest request,
		HttpServletResponse response) {
	Box box=HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	Map<String, Object> dataMap = new HashMap<String, Object>();
	
	int deptId = 0;
	int hospitalId = 0;
	
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		box.put(HOSPITAL_ID, hospitalId);
	}
	
	
	if (request.getParameter("deptId") != null) {
		deptId = Integer.parseInt(request.getParameter("deptId"));
		session.setAttribute("deptId", deptId);
		box.put(DEPARTMENT_ID, deptId);
	} else if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute(DEPT_ID);
		box.put(DEPARTMENT_ID, deptId);
	}
	
	map = ipdHandlerService.updatePatientScheme(box);
	
	
	jsp = PATIENT_SCHEME_JSP;
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	
	return new ModelAndView("index", "map", map);
}


public ModelAndView showDeathReportJsp(HttpServletRequest request,
		HttpServletResponse response) {
	Box box=HMSUtil.getBox(request);
	int hospitalId=0;
	HttpSession session=request.getSession();
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	
	jsp = "patientDeathReport";
	jsp += ".jsp";
	map.put("contentJsp", jsp);
	
	return new ModelAndView("index", "map", map);
}

public String submitIPDInformationFromLean(HttpServletRequest request,
		HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();  
		//int hospitaId=(Integer)session.getAttribute(HOSPITAL_ID);
		Box box=HMSUtil.getBox(request);
		//map.put("hospitalId", hospitaId);
		map=ipdHandlerService.saveIpdObjectToServer(map, box);
	if(map.get("success")!=null){
		return "success";
	}else{
		return "faliure";
	}
	
}
		
		public ModelAndView getInpatientDetails(HttpServletRequest request,
				HttpServletResponse response) {

			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			Map<String, Object> patientMap = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();
			Map<String, Object> patientDiagnosisMap = new HashMap<String, Object>();

			String hinNo = "";
			int wardId = 0;
			String adNo = "";
			int inpatientId = 0;
			String serviceNo = "";

			try {
				if (request.getParameter("parent") != null) {
					inpatientId = Integer.parseInt(request.getParameter("parent"));
					mapForDs.put("inpatientId", inpatientId);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			patientMap = ipdHandlerService.getMotherBabyDeatils(mapForDs);

			String jsp = "";
			String message = "";

			jsp = ADD_MOTHER_BABY_DETAILS_INFORMATION + ".jsp";

			map.put("patientMap", patientMap);
			map.put("detailsMap", detailsMap);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}

		@SuppressWarnings("unchecked")
		public ModelAndView addMotherBabyDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Box box=HMSUtil.getBox(request);
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();	
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			HttpSession session = request.getSession();
			int hinId = 0;
			String motherName="";
			int inpatientId = 0;
			String bloodLoss = "";
			String placenta = "";
			String treatment = "";
			Date dateOnSet = new Date();
			String timeOnSet = "";
			String purperium = "";
			String motherCondition = "";
			int pulse = 0;
			int perineum = 0;
			String bP = "";
			String bp2="";
			int masEmpIdConductedBy = 0;
			int masEmpIdAssistedBy = 0;
			int hospitalId = 0;
			String additionalNotes = "";
			String complications = "";
			int patientTypeId=0;
			String hiNumber="";
			String bplStatus="";
			String nationalDobStatus="";
			int hinIdMother=0;
			try {

				if (session.getAttribute("hospitalId") != null){
					hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
					mapForDs.put("hospitalId", hospitalId);
				}
				if (session.getAttribute("userId") != null){
					int userId = Integer.parseInt(session.getAttribute("userId").toString());
					box.put("userId", userId);
				}
				/*if (request.getParameter(CONDUCTED_BY) != null
						&& !(request.getParameter(CONDUCTED_BY).equals(""))) {
					masEmpIdConductedBy = Integer.parseInt(request
							.getParameter(CONDUCTED_BY));
					mapForDs.put("masEmpIdConductedBy", masEmpIdConductedBy);
				}
				if (request.getParameter(ASSISTED_BY) != null
						&& !(request.getParameter(ASSISTED_BY).equals(""))) {
					masEmpIdAssistedBy = Integer.parseInt(request
							.getParameter(ASSISTED_BY));
					mapForDs.put("masEmpIdAssistedBy", masEmpIdAssistedBy);
				}*/
				if (request.getParameter(HIN_ID) != null
						&& !(request.getParameter(HIN_ID).equals(""))) {
					hinId = Integer.parseInt(request.getParameter(HIN_ID));
					mapForDs.put("hinId", hinId);
				}
				if (request.getParameter(INPATIENT_ID) != null) {
					inpatientId = Integer.parseInt(request
							.getParameter(INPATIENT_ID));
					mapForDs.put("inpatientId", inpatientId);
				}
				/*if (request.getParameter(BLOOD_LOSS) != null
						&& !(request.getParameter(BLOOD_LOSS).equals(""))) {
					bloodLoss = request.getParameter(BLOOD_LOSS);
					mapForDs.put("bloodLoss", bloodLoss);
				}
				if (request.getParameter(PLACENTA) != null
						&& !(request.getParameter(PLACENTA).equals(""))) {
					placenta = request.getParameter(PLACENTA);
					mapForDs.put("placenta", placenta);
				}
				if (request.getParameter(TREATMENT) != null
						&& !(request.getParameter(TREATMENT).equals(""))) {
					treatment = request.getParameter(TREATMENT);
					mapForDs.put("treatment", treatment);
				}
				if (request.getParameter(DATE_ON_SET) != null
						&& !(request.getParameter(DATE_ON_SET).equals(""))) {
					dateOnSet = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(DATE_ON_SET));
					mapForDs.put("dateOnSet", dateOnSet);
				}
				if (request.getParameter(TIME_ON_SET) != null
						&& !(request.getParameter(TIME_ON_SET).equals(""))) {
					timeOnSet = request.getParameter(TIME_ON_SET);
					mapForDs.put("timeOnSet", timeOnSet);
				}
				if (request.getParameter(PUERPERIUM) != null
						&& !(request.getParameter(PUERPERIUM).equals(""))) {
					purperium = request.getParameter(PUERPERIUM);
					mapForDs.put("purperium", purperium);
				}
				if (request.getParameter(MOTHER_CONDITION) != null
						&& !(request.getParameter(MOTHER_CONDITION).equals(""))) {
					motherCondition = request.getParameter(MOTHER_CONDITION);
					mapForDs.put("motherCondition", motherCondition);
				}
				if (request.getParameter(PULSE) != null
						&& !(request.getParameter(PULSE).equals(""))) {
					pulse = Integer.parseInt(request.getParameter(PULSE));
					mapForDs.put("pulse", pulse);
				}
				if (request.getParameter(PERINEUM) != null
						&& !(request.getParameter(PERINEUM).equals(""))) {
					perineum = Integer.parseInt(request.getParameter(PERINEUM));
					mapForDs.put("perineum", perineum);
				}
				if (request.getParameter(BP) != null
						&& !(request.getParameter(BP).equals(""))) {
					bP = request.getParameter(BP);
					mapForDs.put("bP", bP);
				}
				if (request.getParameter("bp2") != null
						&& !(request.getParameter("bp2").equals(""))) {
					bp2 = request.getParameter("bp2");
					mapForDs.put("bp2", bp2);
				}
				
				if (request.getParameter(ADDITIONAL_NOTES) != null
						&& !(request.getParameter(ADDITIONAL_NOTES).equals(""))) {
					additionalNotes = request.getParameter(ADDITIONAL_NOTES);
					mapForDs.put("additionalNotes", additionalNotes);
				}
				if (request.getParameter(COMPLICATIONS) != null
						&& !(request.getParameter(COMPLICATIONS).equals(""))) {
					complications = request.getParameter(COMPLICATIONS);
					mapForDs.put("complications", complications);
				}*/
			
				if (request.getParameter(PATIENT_NAME) != null
						&& !(request.getParameter(PATIENT_NAME).equals(""))) {
					motherName = request.getParameter(PATIENT_NAME);
				
				}
				if (request.getParameter("hinIdMother") != null && !request.getParameter("hinIdMother").equals("0")) {
					hinIdMother = Integer.parseInt(request.getParameter("hinIdMother"));
					
				}
				
				if (request.getParameter("patientTypeId") != null && !request.getParameter("patientTypeId").equals("0")) {
					patientTypeId = Integer.parseInt(request
							.getParameter("patientTypeId"));
					
				}
				mapForDs.put("patientTypeId", patientTypeId);
				if (request.getParameter("bplStatus") != null) {
					bplStatus = request
							.getParameter("bplStatus");
					mapForDs.put("bplStatus", bplStatus);
				}
				if (request.getParameter("hiNumber") != null) {
					hiNumber = request
							.getParameter("hiNumber");
					mapForDs.put("hiNumber", hiNumber);
				}
				
				if (request.getParameter("nationalDobStatus") != null) {
					nationalDobStatus = request
							.getParameter("nationalDobStatus");
					mapForDs.put("nationalDobStatus", nationalDobStatus);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			map = ipdHandlerService.addMotherDetails(mapForDs,box);
			String message="";
			message = "Baby Details Added Successfully !!";
			String jsp = "";
			jsp = "msg_baby" + ".jsp";
			map.put("message", message);
			//map.put("hinIdMother", hinIdMother);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);

		}
			/*map = ipdHandlerService.getBabyDetails(mapForDs);
			String hinNo="";
			if(map.get("hinNo")!=null){
				hinNo=(String)map.get("hinNo");
			}
			String jsp = "";
			jsp = ADD_BABY_DETAILS_INFORMATION + ".jsp"; 
			map.put("motherName", motherName);
			map.put("patientTypeId", patientTypeId);
			map.put("contentJsp", jsp);
			map.put("inpatientId", inpatientId);
			map.put("bplStatus", bplStatus);
			map.put("hiNumber", hiNumber);
			map.put("hinIdMother",hinIdMother);
			map.put("nationalDobStatus", nationalDobStatus);
			map.put("hinNo",hinNo);
			return new ModelAndView("index", "map", map);
		}*/
		
		@SuppressWarnings("unchecked")
		public ModelAndView addBabyDetails(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();

			HttpSession session = request.getSession();

			int deliveryType = 0;
			int babyNo = 0;
			Date dateOfBirth = new Date();
			String timeOfBirth = "";
			String birthCertificationNo = "";
			Date birthCertificationDate = new Date();
			int babySex = 0;
			int csIndication = 0;
			int gestation = 0;
			double headCircumferance = 0.0;
			String csNo = "";
			String gestationAge = "";
			double lenght = 0.0;
			double apgarScore = 0.0;
			String estGestAge = "";
			String weight = "";
			int neonatalProblems = 0;
			int babyStatus = 0;
			String outCome = "";
			int hospitalId=0;
			String babyOfMotherName="";
			int inpatientId=0;
			int patientTypeId=0;
			String hiNumber="";
			String bplStatus="";
			String nationalDobStatus="";
			int hinIdMother=0;
			String motherHinNo="";
			try {
				if (session.getAttribute("hospitalId") != null){
					hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
					mapForDs.put("hospitalId", hospitalId);
				}
				if (request.getParameter("inpatientId") != null) {
					inpatientId = Integer.parseInt(request
							.getParameter("inpatientId"));
					mapForDs.put("inpatientId", inpatientId);
				}
				
				if (request.getParameter("hinIdMother") != null && !request.getParameter("hinIdMother").equals("0")) {
					hinIdMother = Integer.parseInt(request
							.getParameter("hinIdMother"));
					mapForDs.put("hinIdMother", hinIdMother);
				}
				
				if (request.getParameter("motherHinNo") != null && !request.getParameter("motherHinNo").equals("0")) {
					motherHinNo = (request
							.getParameter("motherHinNo"));
					mapForDs.put("motherHinNo", motherHinNo);
				}
				
				if (request.getParameter("patientTypeId") != null) {
					patientTypeId = Integer.parseInt(request
							.getParameter("patientTypeId"));
					mapForDs.put("patientTypeId", patientTypeId);
				}
				if (request.getParameter("bplStatus") != null) {
					bplStatus = request
							.getParameter("bplStatus");
					mapForDs.put("bplStatus", bplStatus);
				}
				if (request.getParameter("hiNumber") != null) {
					hiNumber = request
							.getParameter("hiNumber");
					mapForDs.put("hiNumber", hiNumber);
				}
				
				if (request.getParameter("nationalDobStatus") != null) {
					nationalDobStatus = request
							.getParameter("nationalDobStatus");
					mapForDs.put("nationalDobStatus", nationalDobStatus);
				}
				if (request.getParameter(DELIVERY_TYPE) != null
						&& !(request.getParameter(DELIVERY_TYPE).equals(""))) {
					deliveryType = Integer.parseInt(request
							.getParameter(DELIVERY_TYPE));
					mapForDs.put("deliveryType", deliveryType);
				}
				if (request.getParameter(BABY_NO) != null
						&& !(request.getParameter(BABY_NO).equals(""))) {
					babyNo = Integer.parseInt(request.getParameter(BABY_NO));
					mapForDs.put("babyNo", babyNo);
				}
				if (request.getParameter(DATE_OF_BIRTH) != null
						&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
					dateOfBirth = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(DATE_OF_BIRTH));
					mapForDs.put("dateOfBirth", dateOfBirth);
				}
				if (request.getParameter(TIME_OF_BIRTH) != null
						&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
					timeOfBirth = request.getParameter(TIME_OF_BIRTH);
					mapForDs.put("timeOfBirth", timeOfBirth);
				}
				if (request.getParameter(BIRTH_CERTIFICATE_NO) != null
						&& !(request.getParameter(BIRTH_CERTIFICATE_NO).equals(""))) {
					birthCertificationNo = request
							.getParameter(BIRTH_CERTIFICATE_NO);
					mapForDs.put("birthCertificationNo", birthCertificationNo);
				}
				if (request.getParameter(BIRTH_CERTIFICATE_DATE) != null
						&& !(request.getParameter(BIRTH_CERTIFICATE_DATE)
								.equals(""))) {
					birthCertificationDate = HMSUtil.dateFormatterDDMMYYYY(request
							.getParameter(BIRTH_CERTIFICATE_DATE));
					mapForDs.put("birthCertificationDate", birthCertificationDate);
				}
				if (request.getParameter(SEX) != null
						&& !(request.getParameter(SEX).equals("0"))) {
					babySex = Integer.parseInt(request.getParameter(SEX));
					mapForDs.put("babySex", babySex);
				}
				if (request.getParameter(CS_INDICATION) != null
						&& !(request.getParameter(CS_INDICATION).equals(""))) {
					csIndication = Integer.parseInt(request
							.getParameter(CS_INDICATION));
					mapForDs.put("csIndication", csIndication);
				}
				if (request.getParameter(GESTATION) != null
						&& !(request.getParameter(GESTATION).equals(""))) {
					gestation = Integer.parseInt(request.getParameter(GESTATION));
					mapForDs.put("gestation", gestation);
				}
				if (request.getParameter(HEAD_CIRCUMFERANCE) != null
						&& !(request.getParameter(HEAD_CIRCUMFERANCE).equals(""))) {
					headCircumferance = Double.parseDouble(request
							.getParameter(HEAD_CIRCUMFERANCE));
					mapForDs.put("headCircumferance", headCircumferance);
				}
				if (request.getParameter(CS_No) != null
						&& !(request.getParameter(CS_No).equals(""))) {
					csNo = request.getParameter(CS_No);
					mapForDs.put("csNo", csNo);
				}
				if (request.getParameter(GESTATION_AGE) != null
						&& !(request.getParameter(GESTATION_AGE).equals(""))) {
					gestationAge = request.getParameter(GESTATION_AGE);
					mapForDs.put("gestationAge", gestationAge);
				}
				if (request.getParameter(LENGTH) != null
						&& !(request.getParameter(LENGTH).equals(""))) {
					lenght = Double.parseDouble(request.getParameter(LENGTH));
					mapForDs.put("lenght", lenght);
				}
				if (request.getParameter(APGAR_SCORE) != null
						&& !(request.getParameter(APGAR_SCORE).equals(""))) {
					apgarScore = Double.parseDouble(request
							.getParameter(APGAR_SCORE));
					mapForDs.put("apgarScore", apgarScore);
				}
				if (request.getParameter(EST_GEST_AGE) != null
						&& !(request.getParameter(EST_GEST_AGE).equals(""))) {
					estGestAge = request.getParameter(EST_GEST_AGE);
					mapForDs.put("estGestAge", estGestAge);
				}
				if (request.getParameter(WEIGHT) != null
						&& !(request.getParameter(WEIGHT).equals(""))) {
					weight = request.getParameter(WEIGHT);
					mapForDs.put("weight", weight);
				}
				if (request.getParameter(NEONATAL_PROBLEMS) != null
						&& !(request.getParameter(NEONATAL_PROBLEMS).equals(""))) {
					neonatalProblems = Integer.parseInt(request
							.getParameter(NEONATAL_PROBLEMS));
					mapForDs.put("neonatalProblems", neonatalProblems);
				}
				if (request.getParameter(BABY_STATUS) != null
						&& !(request.getParameter(BABY_STATUS).equals(""))) {
					babyStatus = Integer
							.parseInt(request.getParameter(BABY_STATUS));
					mapForDs.put("babyStatus", babyStatus);
				}
				if (request.getParameter(OUT_COME) != null
						&& !(request.getParameter(OUT_COME).equals(""))) {
					outCome = request.getParameter(OUT_COME);
					mapForDs.put("outCome", outCome);
				}
				
				if (request.getParameter("babyOfMotherName") != null
						&& !(request.getParameter("babyOfMotherName").equals(""))) {
					babyOfMotherName = request.getParameter("babyOfMotherName");
					mapForDs.put("babyOfMotherName", babyOfMotherName);
				}
				synchronized (session) {
					Users user = (Users) session.getAttribute("users");
					int userId = user.getId();
					mapForDs.put("userId", userId);
				}
				if (request.getParameter(CHANGED_DATE) != null) {
					Date addEditDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(CHANGED_DATE));
					mapForDs.put("addEditDate", addEditDate);
				}
				if (request.getParameter(CHANGED_TIME) != null) {
					String addEditTime = request.getParameter(CHANGED_TIME);
					mapForDs.put("addEditTime", addEditTime);
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			map=ipdHandlerService.addBabyDetails(mapForDs);
			
			
			String message="";
			message = "Baby Details Added Successfully !!";
			String jsp = "";
			jsp = "msg_baby" + ".jsp";
			map.put("message", message);
			map.put("hinIdMother", hinIdMother);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);

		}
		
		public ModelAndView fillPatinetDetailsAjax(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();

			String hinNo = "";
			if (request.getParameter("hinNo") != null) {
				hinNo = request.getParameter("hinNo");

			}

			map = ipdHandlerService.getPatinetDetails(hinNo);
			String jsp = "";
			jsp = RESPONSE_PATINET_DETAILS;

			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);

		}


		
		
		// ---    Vaital View --------------------


		public ModelAndView showViewVitalPopUp(HttpServletRequest request,
				HttpServletResponse response) {
			Box box=HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			int ipId=0;
			if (request.getParameter("inpatientId") != null) {
				ipId = Integer.parseInt(request.getParameter("inpatientId").toString());
			
			}
			
			box.put("hospitalId", hospitalId);
			box.put("ipId", ipId);
			map = ipdHandlerService.showViewVitalPopUp(box);

			jsp ="vatalIfoJsp";
			map.put("contentJsp", jsp);
			return new ModelAndView(jsp, "map", map);
		}
		
		// -------------------------Birth
		// Certificate------------------------------------------
		public ModelAndView showBirthCertificateJsp(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			map = ipdHandlerService.showBirthCertificateJsp();
			String jsp = BIRTH_CERTIFICATE;
			jsp += ".jsp";
			title = "birth Certificate";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}

		public ModelAndView showBirth(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> tempMap = new HashMap<String, Object>();
			int hintId = 0;
			int inpatientId = 0;  
			HttpSession session = request.getSession();
			if (request.getParameter(INPATIENT_ID) != null
					&& !(request.getParameter(INPATIENT_ID).equals(""))) {
				inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hintId = Integer.parseInt(request.getParameter(HIN_ID));
			}
			List<EmpAfmsfDet> empAfmsfDetList = new ArrayList<EmpAfmsfDet>();
			map = ipdHandlerService.showBirth(inpatientId);
			if (map.get("empAfmsfDetList") != null) {
				empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
			}
			Map<String, Object> utilMap = new HashMap<String, Object>();
			utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
			String date = (String) utilMap.get("currentDate");
			String year = date.substring(date.lastIndexOf("/") + 1);
			Map<String, Object> regMap = new HashMap<String, Object>();
			regMap.put("year", year);
			regMap.put("bOrD", "birth");
			String regNo = "";
			int serNo = 0;
			String message="";
			String jsp="";
					
			if (empAfmsfDetList.size() == 0) {
				// ------------------- don't delete this for Birth Auto generation

				// tempMap = misHandlerService.generateRegNumber(regMap);
				// if(tempMap.get("regNo") !=null){
				// regNo =""+tempMap.get("regNo");
				// }
				// if(tempMap.get("serNo") !=null){
				// serNo =Integer.parseInt(""+tempMap.get("serNo"));
				// }
			} else {
				message = "Already added";
			}
			jsp = BIRTH;
			map.put("contentJsp", jsp);
			map.put("regNo", regNo);
			map.put("serNo", serNo);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}

		public ModelAndView submitBirthCertificate(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> generalMap = new HashMap<String, Object>();
			Birthdeathreg birthdeathreg = new Birthdeathreg();
			HttpSession session = request.getSession();
			String regNo = "";
			int inpatientId = 0;
			String hintNo = "";
			String patientName = "";
			String motherName = "";
			String fatherName = "";
			int sexId = 0;
			Date dob = new Date();
			Date dor = new Date();
			String lastChgBy = "";
			String lastChgTime = "";
			int noOfCopies = 0;
			int amount = 0;
			Date lastChgDate = new Date();
			int hintId = 0;
			int employeeId = 0;
			int hospitalId = 0;
			Users user = (Users)session.getAttribute("users");
			if (session.getAttribute(HOSPITAL_ID)!=null){
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (request.getParameter(INPATIENT_ID) != null) {
				inpatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			if (request.getParameter(PATIENT_NAME) != null) {
				patientName = request.getParameter(PATIENT_NAME);
				
			}
			String address="";
			if (request.getParameter(ADDRESS) != null
					&& !(request.getParameter(ADDRESS).equals(""))) {
				address = request.getParameter(ADDRESS);
			}
			if (request.getParameter(MOTHER_NAME) != null 	&& !(request.getParameter(MOTHER_NAME).equals(""))) {
				motherName = request.getParameter(MOTHER_NAME);
			}
			if (request.getParameter(FATHER_NAME) != null) {
				fatherName = request.getParameter(FATHER_NAME);
			}
			if (request.getParameter(DATE_OF_BIRTH) != null
					&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
				dob = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(DATE_OF_BIRTH));
			}
			
			if (request.getParameter(REG_DATE) != null
					&& !(request.getParameter(REG_DATE).equals(""))) {
				dor = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(REG_DATE));
			}
			if (request.getParameter(REG_NO) != null) {
				regNo = request.getParameter(REG_NO);
				birthdeathreg.setRegno(regNo);
			}
			String birthCirtificateNo="";
			if (request.getParameter(BIRTH_CERTIFICATE_NO) != null) {
				birthCirtificateNo = request.getParameter(BIRTH_CERTIFICATE_NO);
				birthdeathreg.setBirthCertificateNo(Integer.parseInt(birthCirtificateNo));
			}

			if (request.getParameter(CHANGED_BY) != null
					&& !(request.getParameter(CHANGED_BY).equals(""))) {
				lastChgBy = request.getParameter(CHANGED_BY);
			}
			if (request.getParameter(CHANGED_DATE) != null
					&& !(request.getParameter(CHANGED_DATE).equals(""))) {
				lastChgDate = HMSUtil.dateFormatterDDMMYYYY(request
						.getParameter(CHANGED_DATE));
			}
			if (request.getParameter(CHANGED_TIME) != null
					&& !(request.getParameter(CHANGED_TIME).equals(""))) {
				lastChgTime = request.getParameter(CHANGED_TIME);
			}
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hintNo = request.getParameter(HIN_NO);
			}
			if (request.getParameter(HIN_ID) != null
					&& !(request.getParameter(HIN_ID).equals(""))) {
				hintId = Integer.parseInt(request.getParameter(HIN_ID));
			}
			if (request.getParameter(SEX_ID) != null
					&& !(request.getParameter(SEX_ID).equals(""))) {
				sexId = Integer.parseInt(request.getParameter(SEX_ID));
			}
			/*if (request.getParameter("serNo") != null
					&& !(request.getParameter("serNo").equals(""))) {
				serNo = Integer.parseInt(request.getParameter("serNo"));
			}*/
			if (request.getParameter(EMPLOYEE_ID) != null
					&& !(request.getParameter(EMPLOYEE_ID).equals(""))) {
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			}
			if (request.getParameter(NO_OF_COPIES) != null
					&& !request.getParameter(NO_OF_COPIES).equals("")) {
				noOfCopies = Integer.parseInt(""
						+ request.getParameter(NO_OF_COPIES));
			}
			if (request.getParameter(AMOUNT) != null
					&& !request.getParameter(AMOUNT).equals("")) {
				amount = Integer.parseInt("" + request.getParameter(AMOUNT));
			}
			String time = "";
			if (request.getParameter(TIME) != null
					&& !request.getParameter(TIME).equals("")) {
				time = ("" + request.getParameter(TIME));
				birthdeathreg.setTime(time);
			}
			//------------------------
			String antenatalCheckup="";
			if (request.getParameter(ANTENATAL_CHECKUP) != null
					&& !(request.getParameter(ANTENATAL_CHECKUP).equals(""))) {
				antenatalCheckup = request.getParameter(ANTENATAL_CHECKUP);
				birthdeathreg.setAntenatalCheckup(antenatalCheckup);
			}
			String motherIpdDate="";
			if (request.getParameter(MOTHER_IPD_DATE) != null
					&& !(request.getParameter(MOTHER_IPD_DATE).equals(""))) {
				motherIpdDate = request.getParameter(MOTHER_IPD_DATE);
				birthdeathreg.setDateOfAdmOfMother(HMSUtil.dateFormatterDDMMYYYY(motherIpdDate));
			}
			String birthDateId="";
			if (request.getParameter(DATE_OF_BIRTH) != null
					&& !(request.getParameter(DATE_OF_BIRTH).equals(""))) {
				birthDateId = request.getParameter(DATE_OF_BIRTH);
				birthdeathreg.setBabyDeliveryDate(HMSUtil.dateFormatterDDMMYYYY(birthDateId));
			}
			String timeOfBirth="";
			if (request.getParameter(TIME_OF_BIRTH) != null
					&& !(request.getParameter(TIME_OF_BIRTH).equals(""))) {
				timeOfBirth = request.getParameter(TIME_OF_BIRTH);
				birthdeathreg.setBabyDeliveryTime(timeOfBirth);
			}
			String deliveryType="";
			if (request.getParameter(DELIVERY_TYPE) != null
					&& !(request.getParameter(DELIVERY_TYPE).equals(""))) {
				deliveryType = request.getParameter(DELIVERY_TYPE);
				birthdeathreg.setDeliveryType(deliveryType);
			}
			String babyStatus="";
			if (request.getParameter(BABY_STATUS) != null
					&& !(request.getParameter(BABY_STATUS).equals(""))) {
				babyStatus = request.getParameter(BABY_STATUS);
				birthdeathreg.setBabyStatus(babyStatus);
			}
			String cry="";
			if (request.getParameter(CRY) != null
					&& !(request.getParameter(CRY).equals(""))) {
				cry = request.getParameter(CRY);
				birthdeathreg.setCry(cry);
			}
			String babyColor="";
			if (request.getParameter(BABY_COLOR) != null
					&& !(request.getParameter(BABY_COLOR).equals(""))) {
				babyColor = request.getParameter(BABY_COLOR);
				birthdeathreg.setColor(babyColor);
			}
			String resuscitatino="";
			if (request.getParameter(RESUSCITATINO) != null
					&& !(request.getParameter(RESUSCITATINO).equals(""))) {
				resuscitatino = request.getParameter(RESUSCITATINO);
				birthdeathreg.setResuscitatino(resuscitatino);
			}
			String anyCongAbnormality="";
			if (request.getParameter(ANY_CONG_ABNORMALITY) != null
					&& !(request.getParameter(ANY_CONG_ABNORMALITY).equals(""))) {
				anyCongAbnormality = request.getParameter(ANY_CONG_ABNORMALITY);
				birthdeathreg.setAnyCongAbnormality(anyCongAbnormality);
			}

			String apgarScoreAtBirth="";
			if (request.getParameter(APGAR_ACORE_AT_BIRTH) != null
					&& !(request.getParameter(APGAR_ACORE_AT_BIRTH).equals(""))) {
				apgarScoreAtBirth = request.getParameter(APGAR_ACORE_AT_BIRTH);
				birthdeathreg.setApgarScoreAtBirth(apgarScoreAtBirth);
			}
			String birthWeight="";
			if (request.getParameter(BIRTH_WEIGHT) != null
					&& !(request.getParameter(BIRTH_WEIGHT).equals(""))) {
				birthWeight = request.getParameter(BIRTH_WEIGHT);
				System.out.println(""+birthWeight);
				birthdeathreg.setBirthWeight(new BigDecimal(birthWeight));
			}
			String finalDiagnosis="";
			if (request.getParameter(FINAL_DIAGNOSIS) != null
					&& !(request.getParameter(FINAL_DIAGNOSIS).equals(""))) {
				finalDiagnosis = request.getParameter(FINAL_DIAGNOSIS);
				birthdeathreg.setFinalDiagnosis(finalDiagnosis);
			}
			String dischargeDate="";
			if (request.getParameter(DISCHARGE_DATE) != null
					&& !(request.getParameter(DISCHARGE_DATE).equals(""))) {
				dischargeDate = request.getParameter(DISCHARGE_DATE);
				birthdeathreg.setDischargeDate(HMSUtil.dateFormatterDDMMYYYY(dischargeDate));
			}
			String conditionAtDischarge="";
			if (request.getParameter(CONDITION_AT_DISCHARGE) != null
					&& !(request.getParameter(CONDITION_AT_DISCHARGE).equals(""))) {
				conditionAtDischarge = request.getParameter(CONDITION_AT_DISCHARGE);
				birthdeathreg.setConditionAtdischarge(conditionAtDischarge);
			}
			 
			
			 
			
			birthdeathreg.setBdtype("b");
			birthdeathreg.setDob(dob);
			birthdeathreg.setDor(dor);
			birthdeathreg.setName(patientName);
			birthdeathreg.setFname(fatherName);
			birthdeathreg.setMname(patientName);
			birthdeathreg.setRegno(birthCirtificateNo);
//			birthdeathreg.setLastChgBy(lastChgBy);
			birthdeathreg.setDateOfIssue(lastChgDate);
			birthdeathreg.setLastChgDate(lastChgDate);
			birthdeathreg.setLastChgTime(lastChgTime);
			birthdeathreg.setAmount(amount);
			birthdeathreg.setNoOfCopies(noOfCopies);
			birthdeathreg.setTime(time);
			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			birthdeathreg.setHospital(masHospital);
			if (employeeId != 0) {
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(employeeId);
				birthdeathreg.setEmp(masEmployee);
			}

			Inpatient inpatient = new Inpatient();
			inpatient.setId(inpatientId);
			birthdeathreg.setInpatient(inpatient);

			Patient patient = new Patient();
			patient.setHinNo(hintNo);
			patient.setId(hintId);
			birthdeathreg.setHin(patient);
			birthdeathreg.setAddressPermanent(address);
			MasAdministrativeSex masAdministrativeSex1 = new MasAdministrativeSex();
			masAdministrativeSex1.setId(sexId);
			birthdeathreg.setAdministrativeSex(masAdministrativeSex1);
			generalMap.put("hintId", hintId);
			generalMap.put("dob", dob);
			generalMap.put("dor", dor);
			generalMap.put("sexId", sexId);
			generalMap.put("employeeId", employeeId);
			generalMap.put("hospitalId", hospitalId); 
			generalMap.put("user", user.getId());
			generalMap.put("currentDate", lastChgDate);
			generalMap.put("currentTime", lastChgTime);
			generalMap.put("birthdeathreg",birthdeathreg); 
			generalMap.put("patientName",patientName);
			generalMap.put("motherName", motherName);
			//generalMap.put("birthCirtificateNo",birthCirtificateNo); 
			 		/*
			generalMap.put("time", time);
			generalMap.put("serNo", serNo);
			generalMap.put("noOfCopies", noOfCopies);
			generalMap.put("amount", amount);
			generalMap.put("patientName", patientName);
			
			generalMap.put("fatherName", fatherName);
			//generalMap.put("gender", gender);
			generalMap.put("regNo", regNo);
		
			generalMap.put("gender", gender);
			generalMap.put("hospitalId", hospitalId);
			generalMap.put("lastChgBy", lastChgBy);
			generalMap.put("currentDate", lastChgDate);
			generalMap.put("currentTime", lastChgTime);
			generalMap.put("hintNo", hintNo);
		
			generalMap.put("sexId", sexId);
			generalMap.put("employeeId", employeeId);*/
			generalMap.put("inpatientId", inpatientId);
			String message;
			String messageType = "";
			generalMap = ipdHandlerService.addBirthCertificate(generalMap);
			message = (String) generalMap.get("isRecordAlreadyExists");
			messageType = (String) generalMap.get("messageType");
			jsp = MESSAGE_FOR_MIS_JSP;
			title = "Add birthCertificate";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("flag", "birth");
			map.put("message", message);
			map.put("messageType", messageType);
			map.put("inpatientId", inpatientId);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView getMotherAdmissionNumberList(
				HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> detailsMap = new HashMap<String, Object>();

			String hinNo = "";
			
			if (request.getParameter(HIN_NO) != null) {
				hinNo = request.getParameter(HIN_NO);
				detailsMap.put("hinNo", hinNo);
			}
			List<Object> admissionNoList = new ArrayList<Object>();
			List<Object> motherHinList = new ArrayList<Object>();
			String flag = "";
			String fatalCase = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (request.getParameter("fatalCase") != null) {
				fatalCase = request.getParameter("fatalCase");
				map.put("fatalCase", fatalCase);
			}
			if (flag.equals("admission")) {

				admissionNoList = ipdHandlerService.getAdmissionNoHinNoList(detailsMap);
				map.put("admissionNoList", admissionNoList);
				jsp = MIS_RESPONSE_FOR_ADNO_BIRTH;
			} else if (flag.equals("hin")) {
				motherHinList = ipdHandlerService.getMotherHin(hinNo);
				map.put("hinNoList", motherHinList);
				map.put("birthJsp", "birthJsp");
				jsp = MIS_RESPONSE_FOR_HIN_NO;
			}
			return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView getInvestigationDetails(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			String jsp = "patientInvestigationList.jsp";
			int inpatientId = 0;
			try {
				if (request.getParameter("parent") != null) {
					inpatientId = Integer.parseInt(request.getParameter("parent"));
					map.put("inpatientId", inpatientId);
					map = ipdHandlerService.getPatientInvestigationList(map);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitInvestigationMonitoring(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box  = HMSUtil.getBox(request);
			int deptId = 0;
			HttpSession session = request.getSession();
			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			Users users = (Users) session.getAttribute("users");
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
				session.setAttribute("deptId", deptId);
			} else if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute(DEPT_ID);
			}
			int userId=0;
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
				box.put("userId",userId);
			}
			box.put("hospitalId",hospitalId);
			
			map = ipdHandlerService.submitInvestigationMonitoring(box);
			
			
			String title = request.getParameter("title");
			map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);

			List set = (List) map.get("inpatientSet");
			map.put("inPatientSet", set);
			jsp = PATIENT_LIST_JSP;
			jsp += ".jsp";
			title = "Admitted Patient List";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showInvestigationTrend(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			int inpatientId = 0;
			try {
				if (request.getParameter("parent") != null) {
					inpatientId = Integer.parseInt(request.getParameter("parent"));
					map.put("inpatientId", inpatientId);
					map = ipdHandlerService.showInvestigationTrend(map);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			String jsp = "patientInvestigationTrend.jsp";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		public ModelAndView getInvResultForTrend(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			map = ipdHandlerService.getInvResultForTrend(box);
			String jsp = "responseInvestigationTrend";
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView showPreDialysisChechupJsp(HttpServletRequest request,
				HttpServletResponse response) {
			 HttpSession session = request.getSession();
			Map<String, Object> map = new HashMap<String, Object>();
			if (session.getAttribute("userName") != null) {
				userName = (String) session.getAttribute("userName");
			}
			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			int userId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				userId = (Integer) session.getAttribute(USER_ID);
			}
			int deptId = 0;
			if (session.getAttribute(DEPT_ID) != null) {
				deptId = (Integer) session.getAttribute(DEPT_ID);
			}
			Box box=HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(USER_ID, userId);
			box.put(DEPT_ID, deptId);
			map = ipdHandlerService.showPreDialysisChechupJsp(box);
			
			jsp = "preDialysisChechup";
			jsp += ".jsp";
			title = "Pre Dialysis Chechup";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView submitPreConsultationAssessmentDetails(HttpServletRequest request,	HttpServletResponse response) {
			 Box box = HMSUtil.getBox(request);
			 Map<String, Object> datamap = new HashMap<String, Object>();
			 Map<String, Object> map = new HashMap<String, Object>();
			 HttpSession session=request.getSession();
			 int hospitalId=0;
			 int deptId = 0;
			int empId=0;
			if (session.getAttribute(DEPT_ID) != null) {
						deptId = (Integer) session.getAttribute(DEPT_ID);
					}
			 hospitalId=(Integer)request.getSession().getAttribute(HOSPITAL_ID);
			 box.put("hostpitalId", hospitalId);
			 String savedName=box.get("patientname");
			 if(session.getAttribute("userId")!=null){
			       empId =(Integer) session.getAttribute("userId");
			      box.put("docId", empId);
			 }
			 			 
			 datamap=ipdHandlerService.submitPreConsultationAssessmentDetails(box);
			
			  boolean flag = false;
				if(datamap.get("flag")!=null) {
					flag = (Boolean)datamap.get("flag");
				}
				Users users = (Users) session.getAttribute("users");
				map = ipdHandlerService.getPatientList(deptId,hospitalId,users.getId());
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = "messageFoPreDialysisCheckup.jsp";
				String backUrl = "/hms/hms/ipd?method=showPatientListNurseJsp";
				if (flag) {
					message = "Pre Dialysis Checkup submitted successfully !!";
				} else {
					message = " Error Ocurred Please Try Again !!";
				}
				map.put("backUrl", backUrl);
			 
				map.put("message", message);
			 map.put("contentJsp", jsp);
			 return new ModelAndView("index", "map", map);
		}	
		
		public ModelAndView getInvestigationResultForTrend(HttpServletRequest request,	HttpServletResponse response) {
			 Map<String, Object> map = new HashMap<String, Object>();
			 Box box = HMSUtil.getBox(request);
			 map = ipdHandlerService.getInvestigationResultForTrend(box);
			 String jsp ="";
			 if(box.getString("resultType").equalsIgnoreCase("m")){
				 jsp = "viewMultipleInvestigationForTrend";
			 }else if(box.getString("resultType").equalsIgnoreCase("t")){
				 jsp = "viewTemplateInvestigationForTrend";
			 }
			 return new ModelAndView(jsp, "map", map);
		}
		public ModelAndView showDialysisProcessJsp(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			 Box box = HMSUtil.getBox(request);
			 HttpSession session=request.getSession();
				int hospitalId = 0;
			 if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
				}
				box.put("hospitalId", hospitalId);
				box.put("userId", userId);
				box.put("deptId", deptId);
				map = ipdHandlerService.showDialysisProcessJsp(box);
				jsp = "dialysisProcess";
				jsp += ".jsp";
				title = "Dialysis Process";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("message", message);
				return new ModelAndView("index", "map", map);
			}
		
		public ModelAndView saveDialysisProcess(HttpServletRequest request,	HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			 Box box = HMSUtil.getBox(request);
			 HttpSession session=request.getSession();
				int hospitalId = 0;
				boolean flag = false;
				String message = "";
			 if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
				}
				int userId = 0;
				if (session.getAttribute("userId") != null) {
					userId = (Integer) session.getAttribute("userId");
				}
				int deptId = 0;
				if (session.getAttribute("deptId") != null) {
					deptId = (Integer) session.getAttribute("deptId");
				}
				box.put("hospitalId", hospitalId);
				box.put("userId", userId);
				box.put("deptId", deptId);
				map = ipdHandlerService.saveDialysisProcess(box);
					if(map.get("flag")!=null) {
						flag = (Boolean)map.get("flag");
					}
				if (flag) {
					message = " Dialysis  submitted successfully !!";
				} else {
					message = " Error Ocurred Please Try Again !!";
				}
				jsp = "dialysisProcess";
				jsp += ".jsp";
				title = "Dialysis Process";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
			
		
		// added by amit das on 07-06-2016
		public ModelAndView	showChangeSchemeJsp(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			
			int deptId = 0;
			int hospitalId = 0;
			int userId=0;
			String hinNo = null;
			String patientName = null;
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				dataMap.put(HOSPITAL_ID, hospitalId);
			}
			
			Users users = (Users) session.getAttribute("users");
			dataMap.put("users", users);
			
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
				session.setAttribute("deptId", deptId);
				dataMap.put(DEPARTMENT_ID, deptId);
			} else if (session.getAttribute("deptId") != null) {
				deptId = (Integer) session.getAttribute(DEPT_ID);
				dataMap.put(DEPARTMENT_ID, deptId);
			}
			
			if(session.getAttribute("userId")!=null){
				userId=(Integer)session.getAttribute("userId");
				dataMap.put("userId", userId);
			}
			
			if (request.getParameter("hinNo") != null && !request.getParameter("hinNo").trim().equals("")) {
				hinNo = request.getParameter("hinNo");
				dataMap.put("hinNo", hinNo);
			}
			
			if (request.getParameter("patientName") != null  && !request.getParameter("patientName").trim().equals("")) {
				patientName = request.getParameter("patientName");
				dataMap.put("patientName", patientName);
			}
			
			
			map = ipdHandlerService.getInpatientListForSchemeChange(dataMap);

			jsp = PATIENT_SCHEME_JSP;
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			
			return new ModelAndView("index", "map", map);
			
		}	
		
		// added by amit das on 22-07-2016
		public ModelAndView	getGroupAndParameterValues(HttpServletRequest request, HttpServletResponse response){
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
			
			map = ipdHandlerService.showGroupAndParameterValues(generalMap);
			String jsp = "opd_responseForSpeciality";
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView getOutSideAvailableBloodBankList(HttpServletRequest request,
				HttpServletResponse response) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			String group = "";
			int hospitalId=0;
			HttpSession session=request.getSession();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				dataMap.put(HOSPITAL_ID, hospitalId);
			}
			
			
			if (request.getParameter("group") != null) {
				group = request.getParameter("group");
			}
			dataMap.put("group", group);
			map = ipdHandlerService.getOutSideAvailableBloodBankList(dataMap);

			jsp = "responseForBloodBankList";


			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}
		
		public ModelAndView showLaborRoom1Jsp(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("showLabourRoom1Jsp calling");
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
		
		    map = ipdHandlerService.getPatientDetailsForLaborRoom1(box);	
		    List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		    if(map.get("inpatientList")!=null){
		    	inpatientList = (List<Inpatient>) map.get("inpatientList");
		    }
		    System.out.println("controller inpatientList "+inpatientList.size());
			jsp = "Labor_Room1.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView addLaborRoom1(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("addLaborRoom1 controller calling");
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			List<LrProcedureDone> lrProcedureDoneList=new ArrayList<LrProcedureDone>();
			List<LrInduction> lrInductionList=new ArrayList<LrInduction>();
			LaborRoom laborRoom=null;
			LrProcedureDone lrProcedureDone=null;
			LrInduction lrInduction=null;
			int hinId=0,visitId=0,hdb=0,inPatientId=0,doctor_id=0,lbRoomCount=0;
			HttpSession session = request.getSession();
			int departmentId = (Integer) session.getAttribute("deptId");
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int userId=(Integer)session.getAttribute(USER_ID);
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
		
			if (!request.getParameter(INPATIENT_ID).equals("")) {
				inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			
			if (!request.getParameter("doctor_id").equals("")) {
				doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
			}
			boolean successfullyAdded = false;
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, departmentId);
			
			
			Patient patient = new Patient();
			patient.setId(hinId);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			
			Users users=new Users();
			users.setId(userId);
			
			Inpatient inpatient=new Inpatient();
			inpatient.setId(inPatientId);
			
				
			MasEmployee employee=new MasEmployee();
			employee.setId(doctor_id);

			if (!request.getParameter("hdb").equals("")) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}
			
			if (!request.getParameter("lbRoomCount").equals("")) {
				lbRoomCount = Integer.parseInt(request.getParameter("lbRoomCount"));
			}
			System.out.println("lbRoomCount "+lbRoomCount+" hdb "+hdb);
			Long longValue=null;
			
			int count=0;
			String lbtime=null,lbdate=null,lbLungBase=null,lbContaction=null,lbIO=null;
			Long lbMaterPulse=0L,lbRespRate=0L,lbBP=0L,lbKneeJerk=0L,lbFatalHeart=0L,lbNst=0L;
	if(lbRoomCount==1){
				for(int u=0;u<=hdb;u++){
					
					System.out.println("u value "+u);
									
					if (request.getParameter("lb1date"+u) != null && !request.getParameter("lb1date"+u).equals("")) {
				 		lbdate=	(String)request.getParameter("lb1date"+u);
						count=count+1;
					}
					if (request.getParameter("lb1Time"+u)!=null && !request.getParameter("lb1Time"+u).equals("")) {
						lbtime=(String)request.getParameter("lb1Time"+u);
						count=count+1;
					}
    				if (request.getParameter("lb1MaterPulse"+u)!=null && !request.getParameter("lb1MaterPulse"+u).equals("")) {
						
						lbMaterPulse=Long.parseLong((String)request.getParameter("lb1MaterPulse"+u));
                     
                     count=count+1;
					}
					if (request.getParameter("lb1RespRate"+u)!=null && !request.getParameter("lb1RespRate"+u).equals("")) {
					
						lbRespRate=Long.parseLong((String)request.getParameter("lb1RespRate"+u));
                     count=count+1;
					}
					if (request.getParameter("lb1BP"+u)!=null && !request.getParameter("lb1BP"+u).equals("")) {
						
						lbBP=Long.parseLong((String)request.getParameter("lb1BP"+u));
	                     count=count+1;
					}
					if (request.getParameter("lb1LungBase"+u)!=null && !request.getParameter("lb1LungBase"+u).equals("")) {
						
						 lbLungBase=(String)request.getParameter("lb1LungBase"+u);
						 count=count+1;
					}
					if (request.getParameter("lb1KneeJerk"+u)!=null && !request.getParameter("lb1KneeJerk"+u).equals("")) {
						
						lbKneeJerk=Long.parseLong((String)request.getParameter("lb1KneeJerk"+u));
					    count=count+1;
					}
					
					if (request.getParameter("lb1FatalHeart"+u)!=null && !request.getParameter("lb1FatalHeart"+u).equals("")) {
						
						lbFatalHeart=Long.parseLong((String)request.getParameter("lb1FatalHeart"+u));
	                     count=count+1;
					}
					
					if (request.getParameter("lb1NST"+u)!=null && !request.getParameter("lb1NST"+u).equals("")) {
					
						lbNst=Long.parseLong((String)request.getParameter("lb1NST"+u));
	                     count=count+1;
					}
										
					if (request.getParameter("lb1Contraction"+u)!=null && !request.getParameter("lb1Contraction"+u).equals("")) {
					
						lbContaction=request.getParameter("lb1Contraction"+u);
	                     count=count+1;
					}
					
					if (request.getParameter("lb1IO"+u)!=null && !request.getParameter("lb1IO"+u).equals("")) {
						
						lbIO=request.getParameter("lb1IO"+u);
	                     count=count+1;
					}
					
					System.out.println("final count=="+count);
					if(count==11){
					
					laborRoom=new LaborRoom();
					laborRoom.setHin(patient);
					laborRoom.setDepartment(masDepartment);
					laborRoom.setHospital(masHospital);
					laborRoom.setLastChgBy(users);
					laborRoom.setInpatient(inpatient);
					laborRoom.setEmployee(employee);		
					laborRoom.setLaborRoomDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
					laborRoom.setLaborRoomTime(lbtime);
					laborRoom.setMaternalPulseRate(lbMaterPulse);
					laborRoom.setRespRate(lbRespRate);
					laborRoom.setLabRoomBp(lbBP);
					laborRoom.setLungBases(lbLungBase);
					laborRoom.setKneeJerk(lbKneeJerk);
					laborRoom.setFetalHeart(lbFatalHeart);
					laborRoom.setNst(lbNst);
					laborRoom.setContraction(lbContaction);
					laborRoom.setLabRoomIo(lbIO);					
					laborRoom.setLastChgTime(time);
					laborRoom.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
					laborRoom.setLaborRoomType(1L);	
					
					laborRoomList.add(laborRoom);
					}
				}
			
			map.put("laborRoomList", laborRoomList);
	}
			System.out.println("controller laborRoomList size "+laborRoomList.size());
			
//Babita Dangwal
			int hdbpv =0;
			String lbfindings=null;
			if (!request.getParameter("hdbpv").equals("")) {
				hdbpv = Integer.parseInt(request.getParameter("hdbpv"));
			}

			for(int u=1;u<=hdbpv;u++){
			if (request.getParameter("lb1Findings"+u)!=null && !request.getParameter("lb1Findings"+u).equals("")) {
				count=0;
				             lbfindings=request.getParameter("lb1Findings"+u);
				             count=count+1;
						if (request.getParameter("lb1pvdate"+u) != null && !request.getParameter("lb1pvdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb1pvdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb1pvTime"+u)!=null && !request.getParameter("lb1pvTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb1pvTime"+u);
							count=count+1;
						} 
						
	                   if(count==3){
	                    lrProcedureDone=new LrProcedureDone();
	 					lrProcedureDone.setDepartment(masDepartment);
	 					lrProcedureDone.setHospital(masHospital);
	 					lrProcedureDone.setLastChgBy(users);
	 					lrProcedureDone.setInpatient(inpatient);
	 					lrProcedureDone.setEmployee(employee);	
	 					lrProcedureDone.setFindings("lbfindings");
	 					lrProcedureDone.setProcedureDoneDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
	 					lrProcedureDone.setProcedureDoneTime(lbtime);
	 					lrProcedureDone.setLaborRoomType(1);
	 					lrProcedureDoneList.add(lrProcedureDone);
	                   }
				}
			}
			
			if(lrProcedureDoneList!=null)
				map.put("lrProcedureDoneList", lrProcedureDoneList);
			Box box1 =HMSUtil.getBox(request);
			
			int hdbInduction =0;
			String lb1MedicineGiven= null, lb1ARM=null,lb1armDetails=null;
			if (!request.getParameter("hdbInduction").equals("")) {
				hdbInduction = Integer.parseInt(request.getParameter("hdbInduction"));
			}

			for(int u=1;u<=hdbInduction;u++){
			if (request.getParameter("lb1MedicineGiven"+u)!=null && !request.getParameter("lb1MedicineGiven"+u).equals("")) {
				count=0;
				lb1MedicineGiven=request.getParameter("lb1MedicineGiven"+u);
				             count=count+1;
						
						if (request.getParameter("lb1ARM"+u) != null && !request.getParameter("lb1ARM"+u).equals("")) {
							lb1ARM=	(String)request.getParameter("lb1ARM"+u);
							count=count+1;
						}
						if (request.getParameter("lb1armDetails"+u) != null && !request.getParameter("lb1armDetails"+u).equals("")) {
							lb1armDetails=	(String)request.getParameter("lb1armDetails"+u);
						}
						if (request.getParameter("lb1InductionTime"+u)!=null && !request.getParameter("lb1InductionTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb1InductionTime"+u);
							count=count+1;
						} 
						
	                   if(count==3){
	                    lrInduction =new LrInduction();
	 					lrInduction.setDepartment(masDepartment);
	 					lrInduction.setHospital(masHospital);
	 					lrInduction.setLastChgBy(users);
	 					lrInduction.setInpatient(inpatient);
	 					lrInduction.setEmployee(employee);	
	 					lrInduction.setMedicineGiven(lb1MedicineGiven);
	 					lrInduction.setArm(lb1ARM);
	 					lrInduction.setArmDetails(lb1armDetails);
	 					lrInduction.setInductionTime(lbtime);
	 					lrInduction.setLaborRoomType(1);
	 					lrInductionList.add(lrInduction);
	 					
	                   }
				}
			}
			
			if(lrInductionList!=null)
				map.put("lrInductionList", lrInductionList);
			
			
			try {
				successfullyAdded=ipdHandlerService.addLaborRoom1(map);
				
						
				if (successfullyAdded) {
					message = "Labor Room Stage I has been done Successfully..";
				} else {
					message = "Labor Room Stage I has not been done Successfully..";
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

			  
            		
			 	map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			 	
			 	map.put("message", message);
			 	  
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showLaborRoom2Jsp(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("showLabourRoom2Jsp calling");
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
		
		    map = ipdHandlerService.getPatientDetailsForLaborRoom2(box);	
		    List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		    if(map.get("inpatientList")!=null){
		    	inpatientList = (List<Inpatient>) map.get("inpatientList");
		    }
		    System.out.println("controller inpatientList "+inpatientList.size());
			jsp = "Labor_Room2.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView addLaborRoom2(HttpServletRequest request,
				HttpServletResponse response) {
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			List<LrProcedureDone> lrProcedureDoneList=new ArrayList<LrProcedureDone>();
			List<LrFetalDetails> lrfetalDetailsList=new ArrayList<LrFetalDetails>();
			List<LrDilatationDescent> lrDilatationDescentList =new ArrayList<LrDilatationDescent>();
			List<LrContraction> lrContractionList =new ArrayList<LrContraction>();
			List<LrPulseBp> lrPulseBpList =new ArrayList<LrPulseBp>();
			List<LrTemperature> lrTemperatureList =new ArrayList<LrTemperature>();
			List<LrUrineAnalysis> lrUrineAnalysisList =new ArrayList<LrUrineAnalysis>();
			LaborRoom laborRoom=null;
			LrProcedureDone lrProcedureDone=null;
			LrFetalDetails lrFetalDetails = null;
			LrDilatationDescent lrDilatationDescent = null;
			LrContraction lrContraction = null;
			LrPulseBp lrPulseBp = null;
			LrTemperature lrTemperature = null;
			LrUrineAnalysis lrUrineAnalysis =null;
			int hinId=0,visitId=0,hdb=0,inPatientId=0,doctor_id=0,lbRoomCount=0;
			HttpSession session = request.getSession();
			int departmentId = (Integer) session.getAttribute("deptId");
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int userId=(Integer)session.getAttribute(USER_ID);
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
		
			if (!request.getParameter(INPATIENT_ID).equals("")) {
				inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			
			if (!request.getParameter("doctor_id").equals("")) {
				doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
			}
			boolean successfullyAdded = false;
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, departmentId);
			
			
			Patient patient = new Patient();
			patient.setId(hinId);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			
			Users users=new Users();
			users.setId(userId);
			
			Inpatient inpatient=new Inpatient();
			inpatient.setId(inPatientId);
			
				
			MasEmployee employee=new MasEmployee();
			employee.setId(doctor_id);

			if (!request.getParameter("hdb").equals("")) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}
			
			if (!request.getParameter("lbRoomCount").equals("")) {
				lbRoomCount = Integer.parseInt(request.getParameter("lbRoomCount"));
			}
			System.out.println("lbRoomCount "+lbRoomCount+" hdb "+hdb);
			Long longValue=null;
			
			int count=0;
			String lbtime=null,lbdate=null,lbLungBase=null,lbOxyInfRate=null,lbIO=null,lbContaction=null;
			Long lbMaterPulse=0L,lbRespRate=0L,lbBP=0L,
				 lbKneeJerk=0L,lbFatalHeart=0L,
				 lbNst=0L;
	if(lbRoomCount==1){
				for(int u=0;u<=hdb;u++){
					if (request.getParameter("lb2date"+u) != null && !request.getParameter("lb2date"+u).equals("")) {
				 		lbdate=	(String)request.getParameter("lb2date"+u);
						count=count+1;
					}
					if (request.getParameter("lb2Time"+u)!=null && !request.getParameter("lb2Time"+u).equals("")) {
						lbtime=(String)request.getParameter("lb2Time"+u);
						count=count+1;
					}
    				if (request.getParameter("lb2MaterPulse"+u)!=null && !request.getParameter("lb2MaterPulse"+u).equals("")) {
						
						lbMaterPulse=Long.parseLong((String)request.getParameter("lb2MaterPulse"+u));
                     
                     count=count+1;
					}
					if (request.getParameter("lb2RespRate"+u)!=null && !request.getParameter("lb2RespRate"+u).equals("")) {
					
						lbRespRate=Long.parseLong((String)request.getParameter("lb2RespRate"+u));
                     count=count+1;
					}
					if (request.getParameter("lb2BP"+u)!=null && !request.getParameter("lb2BP"+u).equals("")) {
						
						lbBP=Long.parseLong((String)request.getParameter("lb2BP"+u));
	                     count=count+1;
					}
					if (request.getParameter("lb2LungBase"+u)!=null && !request.getParameter("lb2LungBase"+u).equals("")) {
						
						 lbLungBase=(String)request.getParameter("lb2LungBase"+u);
						 count=count+1;
					}
					if (request.getParameter("lb2KneeJerk"+u)!=null && !request.getParameter("lb2KneeJerk"+u).equals("")) {
						
						lbKneeJerk=Long.parseLong((String)request.getParameter("lb2KneeJerk"+u));
					    count=count+1;
					}
					
					if (request.getParameter("lb2FatalHeart"+u)!=null && !request.getParameter("lb2FatalHeart"+u).equals("")) {
						
						lbFatalHeart=Long.parseLong((String)request.getParameter("lb2FatalHeart"+u));
	                     count=count+1;
					}
					
					if (request.getParameter("lb2NST"+u)!=null && !request.getParameter("lb2NST"+u).equals("")) {
					
						lbNst=Long.parseLong((String)request.getParameter("lb2NST"+u));
	                     count=count+1;
					}
										
					if (request.getParameter("lb2Contraction"+u)!=null && !request.getParameter("lb2Contraction"+u).equals("")) {
					
						lbContaction=request.getParameter("lb2Contraction"+u);
	                     count=count+1;
					}
					
					if (request.getParameter("lb2IO"+u)!=null && !request.getParameter("lb2IO"+u).equals("")) {
						
						lbIO=request.getParameter("lb2IO"+u);
	                     count=count+1;
					}
					
	               if (request.getParameter("lb2OxyInfRate"+u)!=null && !request.getParameter("lb2OxyInfRate"+u).equals("")) {
						
	            	   lbOxyInfRate=request.getParameter("lb2OxyInfRate"+u);
	                     count=count+1;
					}
					System.out.println("final count=="+count);
					if(count==12){
					
					laborRoom=new LaborRoom();
					laborRoom.setHin(patient);
					laborRoom.setDepartment(masDepartment);
					laborRoom.setHospital(masHospital);
					laborRoom.setLastChgBy(users);
					laborRoom.setInpatient(inpatient);
					laborRoom.setEmployee(employee);		
					laborRoom.setLaborRoomDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
					laborRoom.setLaborRoomTime(lbtime);
					laborRoom.setMaternalPulseRate(lbMaterPulse);
					laborRoom.setRespRate(lbRespRate);
					laborRoom.setLabRoomBp(lbBP);
					laborRoom.setLungBases(lbLungBase);
					laborRoom.setKneeJerk(lbKneeJerk);
					laborRoom.setFetalHeart(lbFatalHeart);
					laborRoom.setNst(lbNst);
					laborRoom.setOxyinfoRate(lbOxyInfRate);
					laborRoom.setContraction(lbContaction);
					laborRoom.setLabRoomIo(lbIO);					
					laborRoom.setLastChgTime(time);
					laborRoom.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
					laborRoom.setLaborRoomType(2L);	
					
					laborRoomList.add(laborRoom);
					}
				}
			
			map.put("laborRoomList", laborRoomList);
	}
			
			int hdbpv =0;
			String lbfindings=null;
			if (!request.getParameter("hdbpv").equals("")) {
				hdbpv = Integer.parseInt(request.getParameter("hdbpv"));
			}
		System.out.println("box= "+box);
			for(int u=1;u<=hdbpv;u++){
			if (request.getParameter("lb1Findings"+u)!=null && !request.getParameter("lb1Findings"+u).equals("")) {
				count=0;
				             lbfindings=request.getParameter("lb1Findings"+u);
				             count=count+1;
						if (request.getParameter("lb1pvdate"+u) != null && !request.getParameter("lb1pvdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb1pvdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb1pvTime"+u)!=null && !request.getParameter("lb1pvTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb1pvTime"+u);
							count=count+1;
						} 
						
		               if(count==3){
		                lrProcedureDone=new LrProcedureDone();
							lrProcedureDone.setDepartment(masDepartment);
							lrProcedureDone.setHospital(masHospital);
							lrProcedureDone.setLastChgBy(users);
							lrProcedureDone.setInpatient(inpatient);
							lrProcedureDone.setEmployee(employee);	
							lrProcedureDone.setFindings("lbfindings");
							lrProcedureDone.setProcedureDoneDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrProcedureDone.setProcedureDoneTime(lbtime);
							lrProcedureDone.setLaborRoomType(2);
							lrProcedureDoneList.add(lrProcedureDone);
		               }
				}
			}
			
			if(lrProcedureDoneList!=null)
				map.put("lrProcedureDoneList", lrProcedureDoneList);
			///////////////////////////////////////////////////////////////
			
			int hdbfetal =0;
			String fetalAmFluid=null,fetalMouldingSkull =null;
			int fetalheartbeat =0;
			if (!request.getParameter("hdbfetal").equals("")) {
				hdbfetal = Integer.parseInt(request.getParameter("hdbfetal"));
			}
		
			for(int u=1;u<=hdbpv;u++){
			if (request.getParameter("fetalheartbeat"+u)!=null && !request.getParameter("fetalheartbeat"+u).equals("")) {
				count=0;
				        fetalheartbeat= Integer.parseInt(request.getParameter("fetalheartbeat"+u));
				             count=count+1;
						if (request.getParameter("lb2pfdate"+u) != null && !request.getParameter("lb2pfdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb2pfdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb2fdTime"+u)!=null && !request.getParameter("lb2fdTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb2fdTime"+u);
							count=count+1;
						} 
						if (request.getParameter("fetalAmFluid"+u)!=null && !request.getParameter("fetalAmFluid"+u).equals("")) {
							fetalAmFluid=(String)request.getParameter("fetalAmFluid"+u);
							count=count+1;
						} 
						
						if (request.getParameter("fetalMouldingSkull"+u)!=null && !request.getParameter("fetalMouldingSkull"+u).equals("")) {
							fetalMouldingSkull=(String)request.getParameter("fetalMouldingSkull"+u);
							count=count+1;
						} 
						
		               if(count==5){
		                lrFetalDetails =new LrFetalDetails();
		                    lrFetalDetails.setPulse(fetalheartbeat);
		                    lrFetalDetails.setAmnioticFluid(fetalAmFluid);
		                    lrFetalDetails.setFetalSkullMoulding(fetalMouldingSkull);
							lrFetalDetails.setDepartment(masDepartment);
							lrFetalDetails.setHospital(masHospital);
							lrFetalDetails.setLastChgBy(users);
							lrFetalDetails.setInpatient(inpatient);
							lrFetalDetails.setEmployee(employee);	
							lrFetalDetails.setFetalDetailsDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrFetalDetails.setFetalDetailsTime(lbtime);
							lrFetalDetails.setLaborRoomType(2);
							lrfetalDetailsList.add(lrFetalDetails);
		               }
				}
			}
			
			if(lrfetalDetailsList!=null)
				map.put("lrfetalDetailsList", lrfetalDetailsList);
			///////////////////////////////////////////////////////////////
			int hdbdd =0;
			float dilatation=0,descent=0;
			if (!request.getParameter("hdbpv").equals("")) {
				hdbpv = Integer.parseInt(request.getParameter("hdbpv"));
			}
		
			for(int u=1;u<=hdbpv;u++){
			if (request.getParameter("dilatation"+u)!=null && !request.getParameter("dilatation"+u).equals("")) {
				count=0;
				   dilatation=Float.parseFloat(request.getParameter("dilatation"+u));
				             count=count+1;
						if (request.getParameter("lb1pvdate"+u) != null && !request.getParameter("lb1pvdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb1pvdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb1pvTime"+u)!=null && !request.getParameter("lb1pvTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb1pvTime"+u);
							count=count+1;
						} 
						
						if (request.getParameter("descent"+u)!=null && !request.getParameter("descent"+u).equals("")) {
							descent = Float.parseFloat(request.getParameter("descent"+u));
							count=count+1;
						} 
						
				
						
		               if(count==4){
		            	   lrDilatationDescent = new LrDilatationDescent();
		            	    lrDilatationDescent.setDilatation(dilatation);
		            	    lrDilatationDescent.setDescent(descent);
							lrDilatationDescent.setDepartment(masDepartment);
							lrDilatationDescent.setHospital(masHospital);
							lrDilatationDescent.setLastChgBy(users);
							lrDilatationDescent.setInpatient(inpatient);
							lrDilatationDescent.setEmployee(employee);	
							lrDilatationDescent.setDilatationDescentDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrDilatationDescent.setDilatationDescentTime(lbtime);
							lrDilatationDescent.setLaborRoomType(2);
							lrDilatationDescentList.add(lrDilatationDescent);
		               }
				}
			}
			
			if(lrDilatationDescentList!=null)
				map.put("lrDilatationDescentList", lrDilatationDescentList);
			///////////////////////////////////////////////////////////////
			
			int hdbCont =0;
			String contraction_type=null;
			if (!request.getParameter("hdbCont").equals("")) {
				hdbCont = Integer.parseInt(request.getParameter("hdbCont"));
			}
		
			for(int u=1;u<=hdbCont;u++){
			if (request.getParameter("contraction_type"+u)!=null && !request.getParameter("contraction_type"+u).equals("")) {
				count=0;
				contraction_type=request.getParameter("contraction_type"+u);
				             count=count+1;
						if (request.getParameter("lb2Cdate"+u) != null && !request.getParameter("lb2Cdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb2Cdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb2CTime"+u)!=null && !request.getParameter("lb2CTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb2CTime"+u);
							count=count+1;
						} 
						
		               if(count==3){
		                lrContraction = new LrContraction();
		                    lrContraction.setContractionType(contraction_type);
							lrContraction.setDepartment(masDepartment);
							lrContraction.setHospital(masHospital);
							lrContraction.setLastChgBy(users);
							lrContraction.setInpatient(inpatient);
							lrContraction.setEmployee(employee);	
							lrContraction.setContractionDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrContraction.setContractionTime(lbtime);
							lrContraction.setLaborRoomType(2);
							lrContractionList.add(lrContraction);
		               }
				}
			}
			
			if(lrContractionList!=null)
				map.put("lrContractionList", lrContractionList);
			///////////////////////////////////////////////////////////////
			
			int hdbprbp =0;String pulse=null;
			int systolic=0,diastolic=0;
			if (!request.getParameter("hdbprbp").equals("")) {
				hdbprbp = Integer.parseInt(request.getParameter("hdbprbp"));
			}
		
			for(int u=1;u<=hdbprbp;u++){
			if (request.getParameter("pulse"+u)!=null && !request.getParameter("pulse"+u).equals("")) {
				count=0;
							pulse= request.getParameter("pulse"+u);
				             count=count+1;
						if (request.getParameter("lb1pvdate"+u) != null && !request.getParameter("lb1pvdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb1pvdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb1pvTime"+u)!=null && !request.getParameter("lb1pvTime"+u).equals("")) {
							lbtime= request.getParameter("lb1pvTime"+u);
							count=count+1;
						} 
						
						if (request.getParameter("systolic"+u)!=null && !request.getParameter("systolic"+u).equals("")) {
							systolic= Integer.parseInt(request.getParameter("systolic"+u));
							count=count+1;
						} 
						
						if (request.getParameter("diastolic"+u)!=null && !request.getParameter("diastolic"+u).equals("")) {
							diastolic=Integer.parseInt(request.getParameter("diastolic"+u));
							count=count+1;
						} 
		               if(count==5){
		                lrPulseBp = new LrPulseBp();
		                	lrPulseBp.setPulseBeat(pulse);
		                	lrPulseBp.setBpSystolic(systolic);
		                	lrPulseBp.setBpDiastolic (diastolic);
							lrPulseBp.setDepartment(masDepartment);
							lrPulseBp.setHospital(masHospital);
							lrPulseBp.setLastChgBy(users);
							lrPulseBp.setInpatient(inpatient);
							lrPulseBp.setEmployee(employee);	
							lrPulseBp.setPulseBpDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrPulseBp.setPulseBpTime(lbtime);
							lrPulseBp.setLaborRoomType(2);
							lrPulseBpList.add(lrPulseBp);
		               }
				}
			}
			
			if(lrPulseBpList!=null)
				map.put("lrPulseBpList", lrPulseBpList);
			///////////////////////////////////////////////////////////////
			
			int hdbtemp =0;
			float temperature=0;
			if (!request.getParameter("hdbtemp").equals("")) {
				hdbtemp = Integer.parseInt(request.getParameter("hdbtemp"));
			}
		
			for(int u=1;u<=hdbtemp;u++){
			if (request.getParameter("temperature"+u)!=null && !request.getParameter("temperature"+u).equals("")) {
				count=0;
							temperature=Float.parseFloat(request.getParameter("temperature"+u));
				             count=count+1;
						if (request.getParameter("lb2tempdate"+u) != null && !request.getParameter("lb2tempdate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb2tempdate"+u);
							count=count+1;
						}
						if (request.getParameter("lb2tempTime"+u)!=null && !request.getParameter("lb2tempTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb2tempTime"+u);
							count=count+1;
						} 
						
		               if(count==3){
		                lrTemperature=new LrTemperature();
							lrTemperature.setDepartment(masDepartment);
							lrTemperature.setHospital(masHospital);
							lrTemperature.setLastChgBy(users);
							lrTemperature.setInpatient(inpatient);
							lrTemperature.setEmployee(employee);	
							lrTemperature.setTemperature(temperature);
							lrTemperature.setTemperatureDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrTemperature.setTemperatureTime(lbtime);
							lrTemperature.setLaborRoomType(2);
							lrTemperatureList.add(lrTemperature);
		               }
				}
			}
			
			if(lrTemperatureList!=null)
				map.put("lrTemperatureList", lrTemperatureList);
			///////////////////////////////////////////////////////////////
			
			int hdbua =0;
			String volume=null,albumin=null,acetone=null,glucose=null;
			if (!request.getParameter("hdbua").equals("")) {
				hdbua = Integer.parseInt(request.getParameter("hdbua"));
			}
		
			for(int u=1;u<=hdbua;u++){
			if (request.getParameter("volume"+u)!=null && !request.getParameter("volume"+u).equals("")) {
				count=0;
				volume=request.getParameter("volume"+u);
				             count=count+1;
						if (request.getParameter("lb2uadate"+u) != null && !request.getParameter("lb2uadate"+u).equals("")) {
					 		lbdate=	(String)request.getParameter("lb2uadate"+u);
							count=count+1;
						}
						if (request.getParameter("lb2uaTime"+u)!=null && !request.getParameter("lb2uaTime"+u).equals("")) {
							lbtime=(String)request.getParameter("lb2uaTime"+u);
							count=count+1;
						} 
						
						if (request.getParameter("albumin"+u)!=null && !request.getParameter("albumin"+u).equals("")) {
							albumin=(String)request.getParameter("albumin"+u);
							count=count+1;
						} 
						if (request.getParameter("acetone"+u)!=null && !request.getParameter("acetone"+u).equals("")) {
							acetone=(String)request.getParameter("acetone"+u);
							count=count+1;
						} 
						if (request.getParameter("glucose"+u)!=null && !request.getParameter("glucose"+u).equals("")) {
							glucose=(String)request.getParameter("glucose"+u);
							count=count+1;
						} 
		               if(count==6){
		            	   	lrUrineAnalysis=new LrUrineAnalysis();
		            	   	lrUrineAnalysis.setAcetone(acetone);
		            	   	lrUrineAnalysis.setAlbumin(albumin);
		            	   	lrUrineAnalysis.setGlucose(glucose);
		            	   	lrUrineAnalysis.setVolume(volume);
							lrUrineAnalysis.setDepartment(masDepartment);
							lrUrineAnalysis.setHospital(masHospital);
							lrUrineAnalysis.setLastChgBy(users);
							lrUrineAnalysis.setInpatient(inpatient);
							lrUrineAnalysis.setEmployee(employee);	
							lrUrineAnalysis.setUrineAnalysisDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
							lrUrineAnalysis.setUrineAnalysisTime(lbtime);
							lrUrineAnalysis.setLaborRoomType(2);
							lrUrineAnalysisList.add(lrUrineAnalysis);
		               }
				}
			}
			
			if(lrUrineAnalysisList!=null)
				map.put("lrUrineAnalysisList", lrUrineAnalysisList);
			
			
			try {
				successfullyAdded=ipdHandlerService.addLaborRoom2(map);
				
						
				if (successfullyAdded) {
					message = "Labor Room Stage 2 has been done Successfully..";
				} else {
					message = "Labor Room Stage 2 has not been done Successfully..";
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

			  
            		
			 	map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			 	
			 	map.put("message", message);
			 	  
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
		}
		
		//add by govind 5-9-2016
		public ModelAndView showLaborRoom3Jsp(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("showLabourRoom3Jsp calling");
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
		
		    map = ipdHandlerService.getPatientDetailsForLaborRoom3(box);	
		    List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		    if(map.get("inpatientList")!=null){
		    	inpatientList = (List<Inpatient>) map.get("inpatientList");
		    }
		    System.out.println("controller inpatientList "+inpatientList.size());
			jsp = "Labor_Room3.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showLaborRoom4Jsp(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("showLabourRoom4Jsp calling");
			Map<String, Object> map = new HashMap<String, Object>();
			HttpSession session=request.getSession();
			int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			int deptId=(Integer)session.getAttribute(DEPT_ID);
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, deptId);
		
		    map = ipdHandlerService.getPatientDetailsForLaborRoom4(box);	
		    List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		    if(map.get("inpatientList")!=null){
		    	inpatientList = (List<Inpatient>) map.get("inpatientList");
		    }
		    System.out.println("controller inpatientList "+inpatientList.size());
			jsp = "Labor_Room4.jsp";
			map.put("contentJsp", jsp);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView addLaborRoom3(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("addLaborRoom3 controller calling");
			
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			LaborRoom laborRoom=null;
			int hinId=0,visitId=0,hdb=0,inPatientId=0,doctor_id=0,lbRoomCount=0;
			HttpSession session = request.getSession();
			int departmentId = (Integer) session.getAttribute("deptId");
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int userId=(Integer)session.getAttribute(USER_ID);
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
		
			if (!request.getParameter(INPATIENT_ID).equals("")) {
				inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			
			if (!request.getParameter("doctor_id").equals("")) {
				doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
			}
			boolean successfullyAdded = false;
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, departmentId);
			
			
			Patient patient = new Patient();
			patient.setId(hinId);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			
			Users users=new Users();
			users.setId(userId);
			
			Inpatient inpatient=new Inpatient();
			inpatient.setId(inPatientId);
			
				
			MasEmployee employee=new MasEmployee();
			employee.setId(doctor_id);

			if (!request.getParameter("hdb").equals("")) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}
			
			if (!request.getParameter("lbRoomCount").equals("")) {
				lbRoomCount = Integer.parseInt(request.getParameter("lbRoomCount"));
			}
			System.out.println("lbRoomCount "+lbRoomCount+" hdb "+hdb);
			Long longValue=null;
			
			int count=0;
			String lbtime=null,lbdate=null,lbLungBase=null,lbContaction=null,lbIO=null,lbOxyInfRate=null;
			Long lbMaterPulse=0L,lbRespRate=0L,lbBP=0L,
				 lbKneeJerk=0L,lbFatalHeart=0L,
				 lbNst=0L;
	if(lbRoomCount==1){
				for(int u=0;u<=hdb;u++){
					
					System.out.println("u value "+u);
									
					if (request.getParameter("lb3date"+u) != null && !request.getParameter("lb3date"+u).equals("")) {
				 		lbdate=	(String)request.getParameter("lb3date"+u);
						count=count+1;
					}
					if (request.getParameter("lb3Time"+u)!=null && !request.getParameter("lb3Time"+u).equals("")) {
						lbtime=(String)request.getParameter("lb3Time"+u);
						count=count+1;
					}
    				if (request.getParameter("lb3MaterPulse"+u)!=null && !request.getParameter("lb3MaterPulse"+u).equals("")) {
						
						lbMaterPulse=Long.parseLong((String)request.getParameter("lb3MaterPulse"+u));
                     
                     count=count+1;
					}
					if (request.getParameter("lb3RespRate"+u)!=null && !request.getParameter("lb3RespRate"+u).equals("")) {
					
						lbRespRate=Long.parseLong((String)request.getParameter("lb3RespRate"+u));
                     count=count+1;
					}
					if (request.getParameter("lb3BP"+u)!=null && !request.getParameter("lb3BP"+u).equals("")) {
						
						lbBP=Long.parseLong((String)request.getParameter("lb3BP"+u));
	                     count=count+1;
					}
					if (request.getParameter("lb3LungBase"+u)!=null && !request.getParameter("lb3LungBase"+u).equals("")) {
						
						 lbLungBase=(String)request.getParameter("lb3LungBase"+u);
						 count=count+1;
					}
					if (request.getParameter("lb3KneeJerk"+u)!=null && !request.getParameter("lb3KneeJerk"+u).equals("")) {
						
						lbKneeJerk=Long.parseLong((String)request.getParameter("lb3KneeJerk"+u));
					    count=count+1;
					}
					
					if (request.getParameter("lb3FatalHeart"+u)!=null && !request.getParameter("lb3FatalHeart"+u).equals("")) {
						
						lbFatalHeart=Long.parseLong((String)request.getParameter("lb3FatalHeart"+u));
	                     count=count+1;
					}
					
					if (request.getParameter("lb3NST"+u)!=null && !request.getParameter("lb3NST"+u).equals("")) {
					
						lbNst=Long.parseLong((String)request.getParameter("lb3NST"+u));
	                     count=count+1;
					}
										
					if (request.getParameter("lb3Contraction"+u)!=null && !request.getParameter("lb3Contraction"+u).equals("")) {
					
						lbContaction=request.getParameter("lb3Contraction"+u);
	                     count=count+1;
					}
					
					if (request.getParameter("lb3IO"+u)!=null && !request.getParameter("lb3IO"+u).equals("")) {
						
						lbIO=request.getParameter("lb3IO"+u);
	                     count=count+1;
					}
					
	               if (request.getParameter("lb3OxyInfRate"+u)!=null && !request.getParameter("lb3OxyInfRate"+u).equals("")) {
						
	            	   lbOxyInfRate=request.getParameter("lb3OxyInfRate"+u);
	                     count=count+1;
					}
					System.out.println("final count=="+count);
					if(count==12){
					
					laborRoom=new LaborRoom();
					laborRoom.setHin(patient);
					laborRoom.setDepartment(masDepartment);
					laborRoom.setHospital(masHospital);
					laborRoom.setLastChgBy(users);
					laborRoom.setInpatient(inpatient);
					laborRoom.setEmployee(employee);		
					laborRoom.setLaborRoomDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
					laborRoom.setLaborRoomTime(lbtime);
					laborRoom.setMaternalPulseRate(lbMaterPulse);
					laborRoom.setRespRate(lbRespRate);
					laborRoom.setLabRoomBp(lbBP);
					laborRoom.setLungBases(lbLungBase);
					laborRoom.setKneeJerk(lbKneeJerk);
					laborRoom.setFetalHeart(lbFatalHeart);
					laborRoom.setNst(lbNst);
					laborRoom.setOxyinfoRate(lbOxyInfRate);
					laborRoom.setContraction(lbContaction);
					laborRoom.setLabRoomIo(lbIO);					
					laborRoom.setLastChgTime(time);
					laborRoom.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
					laborRoom.setLaborRoomType(3L);	
					
					laborRoomList.add(laborRoom);
					}
				}
			
			map.put("laborRoomList", laborRoomList);
	}
			System.out.println("controller laborRoomList size "+laborRoomList.size());
			
			
			try {
				successfullyAdded=ipdHandlerService.addLaborRoom1(map);
				
						
				if (successfullyAdded) {
					message = "Labor Room Stage 3 has been done Successfully..";
				} else {
					message = "Labor Room Stage 3 has not been done Successfully..";
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

			  
            		
			 	map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			 	
			 	map.put("message", message);
			 	  
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView addLaborRoom4(HttpServletRequest request,
				HttpServletResponse response) {
			System.out.println("addLaborRoom4 controller calling");
			
			List<LaborRoom> laborRoomList=new ArrayList<LaborRoom>();
			LaborRoom laborRoom=null;
			int hinId=0,visitId=0,hdb=0,inPatientId=0,doctor_id=0,lbRoomCount=0;
			HttpSession session = request.getSession();
			int departmentId = (Integer) session.getAttribute("deptId");
			int hospitalId = (Integer) session.getAttribute("hospitalId");
			int userId=(Integer)session.getAttribute(USER_ID);
			
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");	 
			String time = (String)utilMap.get("currentTime");
			
			if (request.getParameter(HIN_ID) != null) {
				hinId = Integer.parseInt(request.getParameter(HIN_ID));
			}
		
			if (!request.getParameter(INPATIENT_ID).equals("")) {
				inPatientId = Integer.parseInt(request.getParameter(INPATIENT_ID));
			}
			
			if (!request.getParameter("doctor_id").equals("")) {
				doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
			}
			boolean successfullyAdded = false;
			Box box = HMSUtil.getBox(request);
			box.put(HOSPITAL_ID, hospitalId);
			box.put(DEPT_ID, departmentId);
			
			
			Patient patient = new Patient();
			patient.setId(hinId);
			
			MasDepartment masDepartment = new MasDepartment();
			masDepartment.setId(departmentId);
			

			MasHospital masHospital = new MasHospital();
			masHospital.setId(hospitalId);
			
			Users users=new Users();
			users.setId(userId);
			
			Inpatient inpatient=new Inpatient();
			inpatient.setId(inPatientId);
			
				
			MasEmployee employee=new MasEmployee();
			employee.setId(doctor_id);

			if (!request.getParameter("hdb").equals("")) {
				hdb = Integer.parseInt(request.getParameter("hdb"));
			}
			
			if (!request.getParameter("lbRoomCount").equals("")) {
				lbRoomCount = Integer.parseInt(request.getParameter("lbRoomCount"));
			}
			System.out.println("lbRoomCount "+lbRoomCount+" hdb "+hdb);
			Long longValue=null;
			
			int count=0;
			String lbtime=null,lbdate=null,lbLungBase=null,lbContaction=null,lbIO=null,lbOxyInfRate=null;
			Long lbMaterPulse=0L,lbRespRate=0L,lbBP=0L,
				 lbKneeJerk=0L,lbFatalHeart=0L,
				 lbNst=0L;
	if(lbRoomCount==1){
				for(int u=0;u<=hdb;u++){
					
					System.out.println("u value "+u);
									
					if (request.getParameter("lb4date"+u) != null && !request.getParameter("lb4date"+u).equals("")) {
				 		lbdate=	(String)request.getParameter("lb4date"+u);
						count=count+1;
					}
					if (request.getParameter("lb4Time"+u)!=null && !request.getParameter("lb4Time"+u).equals("")) {
						lbtime=(String)request.getParameter("lb4Time"+u);
						count=count+1;
					}
    				if (request.getParameter("lb4MaterPulse"+u)!=null && !request.getParameter("lb4MaterPulse"+u).equals("")) {
						
						lbMaterPulse=Long.parseLong((String)request.getParameter("lb4MaterPulse"+u));
                     
                     count=count+1;
					}
					if (request.getParameter("lb4RespRate"+u)!=null && !request.getParameter("lb4RespRate"+u).equals("")) {
					
						lbRespRate=Long.parseLong((String)request.getParameter("lb4RespRate"+u));
                     count=count+1;
					}
					if (request.getParameter("lb4BP"+u)!=null && !request.getParameter("lb4BP"+u).equals("")) {
						
						lbBP=Long.parseLong((String)request.getParameter("lb4BP"+u));
	                     count=count+1;
					}
					if (request.getParameter("lb4LungBase"+u)!=null && !request.getParameter("lb4LungBase"+u).equals("")) {
						
						 lbLungBase=(String)request.getParameter("lb4LungBase"+u);
						 count=count+1;
					}
					if (request.getParameter("lb4KneeJerk"+u)!=null && !request.getParameter("lb4KneeJerk"+u).equals("")) {
						
						lbKneeJerk=Long.parseLong((String)request.getParameter("lb4KneeJerk"+u));
					    count=count+1;
					}
					
					if (request.getParameter("lb4FatalHeart"+u)!=null && !request.getParameter("lb4FatalHeart"+u).equals("")) {
						
						lbFatalHeart=Long.parseLong((String)request.getParameter("lb4FatalHeart"+u));
	                     count=count+1;
					}
					
					if (request.getParameter("lb4NST"+u)!=null && !request.getParameter("lb4NST"+u).equals("")) {
					
						lbNst=Long.parseLong((String)request.getParameter("lb4NST"+u));
	                     count=count+1;
					}
										
					if (request.getParameter("lb4Contraction"+u)!=null && !request.getParameter("lb4Contraction"+u).equals("")) {
					
						lbContaction=request.getParameter("lb4Contraction"+u);
	                     count=count+1;
					}
					
					if (request.getParameter("lb4IO"+u)!=null && !request.getParameter("lb4IO"+u).equals("")) {
						
						lbIO=request.getParameter("lb4IO"+u);
	                     count=count+1;
					}
					
	               if (request.getParameter("lb4OxyInfRate"+u)!=null && !request.getParameter("lb4OxyInfRate"+u).equals("")) {
						
	            	   lbOxyInfRate=request.getParameter("lb4OxyInfRate"+u);
	                     count=count+1;
					}
					System.out.println("final count=="+count);
					if(count==12){
					
					laborRoom=new LaborRoom();
					laborRoom.setHin(patient);
					laborRoom.setDepartment(masDepartment);
					laborRoom.setHospital(masHospital);
					laborRoom.setLastChgBy(users);
					laborRoom.setInpatient(inpatient);
					laborRoom.setEmployee(employee);		
					laborRoom.setLaborRoomDate(HMSUtil.convertStringTypeDateToDateType(lbdate));
					laborRoom.setLaborRoomTime(lbtime);
					laborRoom.setMaternalPulseRate(lbMaterPulse);
					laborRoom.setRespRate(lbRespRate);
					laborRoom.setLabRoomBp(lbBP);
					laborRoom.setLungBases(lbLungBase);
					laborRoom.setKneeJerk(lbKneeJerk);
					laborRoom.setFetalHeart(lbFatalHeart);
					laborRoom.setNst(lbNst);
					laborRoom.setOxyinfoRate(lbOxyInfRate);
					laborRoom.setContraction(lbContaction);
					laborRoom.setLabRoomIo(lbIO);					
					laborRoom.setLastChgTime(time);
					laborRoom.setLastChgDate(HMSUtil
							.convertStringTypeDateToDateType(date));
					laborRoom.setLaborRoomType(4L);	
					
					laborRoomList.add(laborRoom);
					}
				}
			
			map.put("laborRoomList", laborRoomList);
	}
			System.out.println("controller laborRoomList size "+laborRoomList.size());
			
			
			try {
				successfullyAdded=ipdHandlerService.addLaborRoom1(map);
				
						
				if (successfullyAdded) {
					message = "Labor Room Stage 4 has been done Successfully..";
				} else {
					message = "Labor Room Stage 4 has not been done Successfully..";
				}


			} catch (Exception e) {
				e.printStackTrace();
			}

			  
            		
			 	map = ipdHandlerService.getPatientList(departmentId, hospitalId,userId);
			 	
			 	map.put("message", message);
			 	  
				List set = (List) map.get("inpatientSet");
				map.put("inPatientSet", set);
				jsp = PATIENT_LIST_NURSE_JSP;
				jsp += ".jsp";
				map.put("contentJsp", jsp);
				return new ModelAndView("index", "map", map);
		}
		//add by govind 5-9-2016 end
		
		//added by govind 20-9-2016
				@SuppressWarnings("unchecked")
				public void checkItem(HttpServletRequest request,
						HttpServletResponse response) {
					HttpSession session=request.getSession();
					int hospitalId=0;
					if(session!=null){
						hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
					}
					
					Map<String, Object> dataMap = new HashMap<String, Object>();
					Map<String, Object> map = new HashMap<String, Object>();
					List<PatientAllergicDrugsDt> patientAllergicDrugsDtList = new ArrayList<PatientAllergicDrugsDt>();

					
					String pvmsNo = "";
					if (request.getParameter("pvmsNo") != null) {
						pvmsNo = request.getParameter("pvmsNo");
					}

					dataMap.put("pvmsNo", pvmsNo);
					dataMap.put(HOSPITAL_ID, hospitalId);
					map.put(HOSPITAL_ID, hospitalId);
					map = ipdHandlerService.checkItem(dataMap);

					int itemId = 0;
					StringBuffer sb = new StringBuffer();

					    response.setContentType("text/xml");
					    response.setHeader("Cache-Control", "no-cache");

					try{

						response.getWriter().write(
								"<?xml version='1.0' encoding='ISO-8859-1'?>");
						response.getWriter().write("<items>");
						response.getWriter().write(sb.toString());
						StoreItemBatchStock itemBatchStock = (StoreItemBatchStock) map.get("itemBatchStock");
						if(itemBatchStock==null)
						{
							response.getWriter().write("<stocks>");
							response.getWriter().write("<stock>");
							response.getWriter().write("0");
							response.getWriter().write("</stock>");
							response.getWriter().write("</stocks>");
						}
						else
						{
							response.getWriter().write("<stocks>");
							response.getWriter().write("<stock>");
							response.getWriter().write("1");
							response.getWriter().write("</stock>");
							response.getWriter().write("</stocks>");
						}
						response.getWriter().write("</items>");
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
				
				public ModelAndView openPopupForInjectionIssue(HttpServletRequest request, HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Box box = HMSUtil.getBox(request);
					int deptId = 0;
					int hospitalId = 0;
					int hinId=0;
					HttpSession session = request.getSession();
					
					if (box.get("hinId") != null)
						hinId = Integer.parseInt("" + box.getInt("hinId"));
					
					if (session.getAttribute("deptId") != null)
						deptId = Integer.parseInt("" + session.getAttribute("deptId"));
					box.put("deptId", deptId);
					if (session.getAttribute("hospitalId") != null)
						hospitalId = Integer.parseInt("" + session.getAttribute("hospitalId"));
					box.put("hospitalId", hospitalId);
					
					System.out.println("hinId "+hinId);
					System.out.println("hospitalId "+hospitalId);
					System.out.println("deptId "+deptId);
					
					map = ipdHandlerService.getItemBatch(box);
					map.put("IPModule", "IP");
					map.put("hinId", hinId);
					map.put("counter", box.getInt("counter"));
					map.put("flag", box.getString("flag"));
					
					String jsp = "issueInjectionIPPopup";
					return new ModelAndView(jsp,"map",map);
				}
				public ModelAndView submitIPNursingCare(HttpServletRequest request,HttpServletResponse response){
					Map<String, Object> map = new HashMap<String, Object>();
					HttpSession session = request.getSession();
					
					Box box=HMSUtil.getBox(request);
					
					// added by amit das on 16-09-2016
					if(session.getAttribute("hospitalId")!=null){
						box.put("hospitalId", (Integer)session.getAttribute("hospitalId"));
					}
					
					
					map = ipdHandlerService.submitIPNursingCare(box);
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
					
					String msg="IP Nursing submited successfully.";
					map.put("nursing_msg",msg);
					jsp = PATIENT_LIST_NURSE_JSP;
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					title = "IP Nursing Care";
					map.put("title", title);
					return new ModelAndView("index", "map", map);
				}
				//added by govind 20-9-2016 end

				
				@SuppressWarnings("unchecked")
				public ModelAndView showGeneralSurgrySpecialityTemplateJsp(HttpServletRequest request,
						HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					Box box =HMSUtil.getBox(request);
					map = ipdHandlerService.showGeneralSurgrySpecialityTemplateJsp(box);
					
					String jsp = "generalSurgeryCaseSheetSpeciality";
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView(jsp, "map", map);
				}

				
				
				@SuppressWarnings("unchecked")
				public ModelAndView showNeonatalSpecialityScreenJsp(HttpServletRequest request,
						HttpServletResponse response) {

					Map<String, Object> map = new HashMap<String, Object>();
					int inpatientId=0;
					System.out.println("-------------------"+request.getParameter("inpatientId"));
					if (request.getParameter("inpatientId") != null) {
						inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
					}
					String motherHinNo="";
					if (request.getParameter("motherHinNo") != null) {
						motherHinNo = request.getParameter("motherHinNo");
					}
					int hinId=0;
					if (request.getParameter("hinId") != null) {
						hinId = Integer.parseInt(request.getParameter("hinId"));
					}
					map = ipdHandlerService.showNeonatalSpecialityScreenJsp(inpatientId,motherHinNo,hinId);

					String jsp = "neonatal";
					map.put("contentJsp", jsp);
					
					map.put("title", title);
					return new ModelAndView(jsp, "map", map);
				}

				public void showPatientSpecialityReport(
						HttpServletRequest request, HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					HttpSession session = request.getSession();
					Map<String, Object> parameters = new HashMap<String, Object>();
					Map<String, Object> detailsMap = new HashMap<String, Object>();
					
					int hinId = 0;
					String specialityTemplateName = null;
					String reportName = null;
					int visitId = 0;
					int opdPatientDetailId=0;
					detailsMap = ipdHandlerService.getConnectionForReport();
					if(request.getParameter("hinId")!= null){
						hinId = Integer.parseInt(request.getParameter("hinId"));
						
					}
					if(request.getParameter("visitId")!= null){
						visitId = Integer.parseInt(request.getParameter("visitId"));
					}
				
					if(request.getParameter("opdPatientDetailId")!= null){
						opdPatientDetailId = Integer.parseInt(request.getParameter("opdPatientDetailId"));
					
					}
					if(request.getParameter("specialityTemplateName")!= null){
						specialityTemplateName = request.getParameter("specialityTemplateName");
					
					}
					
					int hospitalId = 0;
					if(request.getParameter("hospitalId")!=null){
						hospitalId =Integer.parseInt(request.getParameter("hospitalId"));
					}else{
						hospitalId =(Integer) session.getAttribute("hospitalId");
					}
					
					if(specialityTemplateName!=null && specialityTemplateName.equalsIgnoreCase("General Surgery")){
						reportName="generalSurgery";
						parameters.put("opdPatientDetailId", opdPatientDetailId);
						parameters.put("hinId", hinId);
						
					}
					
					if(specialityTemplateName!=null && specialityTemplateName.equalsIgnoreCase("Neonatal")){
						reportName="neonatal";
						parameters.put("opdPatientDetailId", opdPatientDetailId);
						parameters.put("hospitalId", hospitalId);
					}
					
					if(specialityTemplateName!=null && specialityTemplateName.equalsIgnoreCase("Antenatal Card")){
						reportName="AntenatalCard";
						
						parameters.put("opdvid", visitId);
						parameters.put("hinId", hinId);
						parameters.put("hospitalId", hospitalId);
					}
					
								
					parameters.put("SUBREPORT_DIR", getServletContext().getRealPath(
							"/Reports/"));
					try {
						
						HMSUtil.generateReport(reportName, parameters,
								(Connection) detailsMap.get("conn"), response,
								getServletContext());

					} catch (IllegalStateException e) {
						e.printStackTrace();
					}
				}
//added by govind 03-02-2017
				public ModelAndView showIPStickerReprint(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> datamap = new HashMap<String, Object>();
					  HttpSession session = request.getSession();
				   String hinNo=null,adNo=null;
				   int hospitalId=0;
				   if(request.getParameter("hin_no")!=null){
					   hinNo= request.getParameter("hin_no");
					   if(hinNo.equals("")){
						   hinNo=null; 
					   }
					  
				   }
				   if(request.getParameter("adNo")!=null){
					   adNo= request.getParameter("adNo");
					   if(adNo.equals("")){
						   adNo=null; 
					   }
				   }
				   
				 
					if (session.getAttribute(HOSPITAL_ID) != null) {
						hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
					}
					 System.out.println("hospitalId "+hospitalId+" hinNo "+hinNo+" adNo "+adNo);
				   datamap.put("hinNo",hinNo);
				   datamap.put("adNo",adNo);
				   datamap.put("hospitalId",hospitalId);
				    map= ipdHandlerService.searchIPStickerReprint(datamap);
				 	
					String jsp="IPStickerReprint";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					map.put("hinNo", hinNo);
					map.put("adNo", adNo);
					return new ModelAndView("index", "map", map);
				}
				
				//added by govind 22-03-2017 for get IP medicine in Discharge Medication
				public ModelAndView	getIPPrescriptionDetails(HttpServletRequest request, HttpServletResponse response){
					System.out.println("getIPPrescriptionDetails calling");
					HttpSession session = request.getSession();
					Box box =HMSUtil.getBox(request);
					Map<String,Object> detMap=new HashMap<String,Object>();
					Map<String,Object>map=new HashMap<String,Object>();
					String dischargeParam=null;
					if(request.getParameter("dischargeParam")!=null){
						dischargeParam=request.getParameter("dischargeParam");
					}
					//detMap.put("inpatientId", value);
					map=ipdHandlerService.getIPPrescriptionDetails(box);
					
					jsp = "ipd_patientPrescriptionList";
                    map.put("dischargeParam",dischargeParam);
					return new ModelAndView(jsp, "map", map);
					
				}
				
				public ModelAndView	showPrescribedMedicineJspForNurse(HttpServletRequest request, HttpServletResponse response){
					Map<String,Object>map=new HashMap<String,Object>();
					HttpSession session = request.getSession();
					Box box=HMSUtil.getBox(request);
					int deptId=(Integer)session.getAttribute(DEPT_ID);
					int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
					box.put(DEPT_ID, deptId);
					box.put(HOSPITAL_ID, hospitalId);
					int inpatientId=0;
					if(box.getInt("parent")!=0){
						inpatientId=box.getInt("parent");
					}
					System.out.println("inpatientId===="+inpatientId);
					box.put("inpatientId",inpatientId);
					map = ipdHandlerService.showPrescribedMedicineJspForNurse(box);
					String jsp="medicinePrescriptionByNurse";
					jsp += ".jsp";
					map.put("contentJsp", jsp);
					return new ModelAndView("index", "map", map);
				}
				public ModelAndView submitMedicinePrescriptionByNurse(HttpServletRequest request, HttpServletResponse response){
					Map<String,Object>map=new HashMap<String,Object>();
					HttpSession session = request.getSession();
					boolean flag  =  false;
					String msg = "";
					Box box=HMSUtil.getBox(request);
				try {
					int deptId=(Integer)session.getAttribute(DEPT_ID);
					int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
					Users users = (Users)session.getAttribute("users");
					int userId = users.getId();
					box.put("userId", users.getId());
					box.put("userName", users.getUserName());
					box.put("empId", users.getEmployee().getId());
					box.put(DEPT_ID, deptId);
					box.put(HOSPITAL_ID, hospitalId);
					map = ipdHandlerService.submitMedicinePrescriptionByNurse(box);
					if(map.get("flag") != null){
						flag = (Boolean) map.get("flag");
					}
					if (flag) {
						map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
						List set = (List) map.get("inpatientSet");
						map.put("inPatientSet", set);
						jsp = PATIENT_LIST_NURSE_JSP;
						message = "Record Saved Successfully.!!";
					} else {
						map = ipdHandlerService.getPatientList(deptId, hospitalId,userId);
						List set = (List) map.get("inpatientSet");
						map.put("inPatientSet", set);
						jsp = PATIENT_LIST_NURSE_JSP;
						message = " Error Ocurred Please Try Again !!";
					}
					map.put("message", message);
					jsp += ".jsp";
					map.put("contentJsp", jsp);
				} catch (Exception e) {
					e.printStackTrace();
				}
					return new ModelAndView("index", "map", map);
				}
				
				
				@SuppressWarnings("unchecked")
				public Map<String,Object> addAntenatalCardForTemplate(HttpServletRequest request) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> utilMap = new HashMap<String, Object>();
					Map<String, Object> infoMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					List<OpdAntenatalCardTrimester> antCardTrimeList=new ArrayList<OpdAntenatalCardTrimester>();
					List<OpdAntenatalCardPregnancy> antCardPregList=new ArrayList<OpdAntenatalCardPregnancy>();
					List<OpdAntenatalCardMedicalHistory> antCardMedHistList=new ArrayList<OpdAntenatalCardMedicalHistory>();
					List<OpdAntenatalUsg> usgReportFirstTrimList=new ArrayList<OpdAntenatalUsg>();
					List<OpdAntenatalUsg> usgReportSecondTrimList=new ArrayList<OpdAntenatalUsg>();
					List<OpdAntenatalUsg> usgReportThirdTrimList=new ArrayList<OpdAntenatalUsg>();
					int hinId = 0;
					int visitId = 0;

					int para = 0, abortions = 0, ectopic = 0, vesicular = 0, mtp = 0, liveBirth = 0, iud = 0, stillBirth = 0, nnd = 0;
					Date lmp = null;
					Date edd = null;
					Date scannedEdc = null;
					int menarche = 0;
					String gravida = "", cycle = "", days = "", cycle1="", days1="", cycle2="", days2="", cycle3="", days3="";
					String years="", months="", consanguineous="", degree="", infertility="", factor="", infertilityDetails="";
					String year = "", pregnancyOutcome="", placeDelivery="", deliveryOutcome="", sex="", antenatal="", intraPartum="", postPartum="", bloodTransfusion="", medicalDisord="";
					int age = 0; String previousGestationalAge = "";String placeOfDeliveryOthers = ""; String preTermValue = "";
					double birthWeight =0.0;
					String comorbidity="", comChronicDisease="", comOtherDisease="", comYears="", comMonths="", comRemarks="";
					String surgicalHistory="", familyHistory="", personalHistory="";
					String height = "", weight = "", bmi="", bmiStatus="", breast = "", nipple = "", thyriod="";
					Date tetanusOnestDoseDate = null;
					Date tetanusTwondDoseDate = null;
					String referredFromPrivate="";
					String referredFromPrivateValue = "";

					String date = "";
					String time = "";
					
					Date nextVisitOn = new Date();
					int exist=0,antCardId=0,AntCount=0,pmhCount=0;
						
					HttpSession session = request.getSession();
					date = (String) utilMap.get("currentDate");
					time = (String) utilMap.get("currentTime");
					int departmentId = (Integer) session.getAttribute("deptId");
					int hospitalId = (Integer) session.getAttribute("hospitalId");
					 String templateName = "";
					 if (request.getParameter("templateName") != null && (!request.getParameter("templateName").equals(""))) {
						 templateName = request.getParameter("templateName");
						 infoMap.put("templateName", templateName);
						}
				
					if (request.getParameter(GRAVIDA) != null
							&& (!request.getParameter(GRAVIDA).equals(""))) {
						gravida = request.getParameter(GRAVIDA);
					}
					if (request.getParameter(PARA) != null
							&& (!request.getParameter(PARA).equals(""))) {
						para = Integer.parseInt(request.getParameter(PARA));
					}
					if (request.getParameter(ABORTIONS) != null
							&& (!request.getParameter(ABORTIONS).equals(""))) {
						abortions = Integer.parseInt(request.getParameter(ABORTIONS));
					}
					if ((request.getParameter(ECTOPIC) != null)
							&& (!request.getParameter(ECTOPIC).equals(""))) {
						ectopic = Integer.parseInt(request.getParameter(ECTOPIC));
					}
					if ((request.getParameter(VESICULAR) != null)
							&& (!request.getParameter(VESICULAR).equals(""))) {
						vesicular = Integer.parseInt(request.getParameter(VESICULAR));
					}
					if ((request.getParameter(MTP) != null)
							&& (!request.getParameter(MTP).equals(""))) {
						mtp = Integer.parseInt(request.getParameter(MTP));
					}
					if (request.getParameter(LIVE) != null
							&& (!request.getParameter(LIVE).equals(""))) {
						liveBirth = Integer.parseInt(request.getParameter(LIVE));
					}
					if (request.getParameter(IUD) != null
							&& (!request.getParameter(IUD).equals(""))) {
						iud = Integer.parseInt(request.getParameter(IUD));
					}
					if (request.getParameter(STILLBIRTH) != null
							&& (!request.getParameter(STILLBIRTH).equals(""))) {
						stillBirth = Integer.parseInt(request.getParameter(STILLBIRTH));
					}
					if (request.getParameter(NND) != null
							&& (!request.getParameter(NND).equals(""))) {
						nnd = Integer.parseInt(request.getParameter(NND));
					}
					if (request.getParameter(LMP) != null
							&& !(request.getParameter(LMP).equals(""))) {
						lmp = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(LMP));
					}
					if (request.getParameter(EDD) != null
							&& !(request.getParameter(EDD).equals(""))) {
						edd = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EDD));
					}
					if (request.getParameter(SCANNED_EDC) != null
							&& !(request.getParameter(SCANNED_EDC).equals(""))) {
						scannedEdc = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(SCANNED_EDC));
					}
					String gestationalAgeWeeks ="";
					if (request.getParameter("gestationalAgeWeeks") != null && !(request.getParameter("gestationalAgeWeeks").equals(""))) {
						gestationalAgeWeeks =request.getParameter("gestationalAgeWeeks");
					}
					String gestationalAgeDays ="";
					if (request.getParameter("gestationalAgeDays") != null && !(request.getParameter("gestationalAgeDays").equals(""))) {
						gestationalAgeDays =request.getParameter("gestationalAgeDays");
					}
					

					if (request.getParameter(MENARCHE) != null
							&& (!request.getParameter(MENARCHE).equals(""))) {
						menarche = Integer.parseInt(request.getParameter(MENARCHE));
					}
					if (request.getParameter(CYCLE) != null) {
						cycle = request.getParameter(CYCLE);
					}
					if (request.getParameter(DAYS) != null) {
						days = request.getParameter(DAYS);
					}
					if (request.getParameter(CYCLE1) != null) {
						cycle1 = request.getParameter(CYCLE1);
					}
					if (request.getParameter(DAYS1) != null) {
						days1 = request.getParameter(DAYS1);
					}
					if (request.getParameter(CYCLE2) != null) {
						cycle2 = request.getParameter(CYCLE2);
					}
					if (request.getParameter(DAYS2) != null) {
						days2 = request.getParameter(DAYS2);
					}
					if (request.getParameter(CYCLE3) != null) {
						cycle3 = request.getParameter(CYCLE3);
					}
					if (request.getParameter(DAYS3) != null) {
						days3 = request.getParameter(DAYS3);
					}

					if (request.getParameter(YEARS) != null) {
						years = request.getParameter(YEARS);
					}
					if (request.getParameter(MONTHS) != null) {
						months = request.getParameter(MONTHS);
					}
					String durationOfMarriageYear = "";
					if (request.getParameter("durationOfMarriageYear") != null) {
						durationOfMarriageYear = request.getParameter("durationOfMarriageYear");
					}
					String durationOfMarriageMonth = "";
					if (request.getParameter("durationOfMarriageMonth") != null) {
						durationOfMarriageMonth = request.getParameter("durationOfMarriageMonth");
					}
					if (request.getParameter("consanguineousYes") != null
							&& (!request.getParameter("consanguineousYes").equals(""))) {
						consanguineous =request.getParameter("consanguineousYes");
					}
					if (request.getParameter("referredFromPrivate") != null
							&& (!request.getParameter("referredFromPrivate").equals(""))) {
						referredFromPrivate =request.getParameter("referredFromPrivate");
					}
					
					if (request.getParameter("referredFromPrivateValue") != null
							&& (!request.getParameter("referredFromPrivateValue").equals(""))) {
						referredFromPrivateValue =request.getParameter("referredFromPrivateValue");
					}
					if (request.getParameter("degree") != null
							&& (!request.getParameter("degree").equals(""))) {
						degree =request.getParameter("degree");
					}
					if (request.getParameter("infertilityYes") != null
							&& (!request.getParameter("infertilityYes").equals(""))) {
						infertility =request.getParameter("infertilityYes");
					}
					if (request.getParameter("factor") != null
							&& (!request.getParameter("factor").equals(""))) {
						factor =request.getParameter("factor");
					}
					if (request.getParameter(INFERTILITY_DETAILS) != null) {
						infertilityDetails = request.getParameter(INFERTILITY_DETAILS);
					}
					String pastSurgicalHistoryRadio = "";
					if (request.getParameter("pastSurgicalHistoryRadio") != null) {
						pastSurgicalHistoryRadio = request.getParameter("pastSurgicalHistoryRadio");
					}
					
					if (request.getParameter("pastSurgHist") != null) {
						surgicalHistory = request.getParameter("pastSurgHist");
					}
					if (request.getParameter("familyHist") != null) {
						familyHistory = request.getParameter("familyHist");
					}
					if (request.getParameter("personalHist") != null) {
						personalHistory = request.getParameter("personalHist");
					}
					String otherImmunizationDetail = "";
					if (request.getParameter("otherImmunizationDetail") != null) {
						otherImmunizationDetail = request.getParameter("otherImmunizationDetail");
					}

					if (request.getParameter("existAnte") != null
						&& (!request.getParameter("existAnte").equals(""))) {
						exist = Integer.parseInt(request.getParameter("existAnte"));
					}
							
							
					if (request.getParameter("antCardId") != null
						&& (!request.getParameter("antCardId").equals(""))) {
						antCardId = Integer.parseInt(request.getParameter("antCardId"));
					}
							
					if (request.getParameter("AntCount") != null
						&& (!request.getParameter("AntCount").equals(""))) {
						AntCount = Integer.parseInt(request.getParameter("AntCount"));
					}
					if (request.getParameter("pmhCount") != null
						&& (!request.getParameter("pmhCount").equals(""))) {
						pmhCount = Integer.parseInt(request.getParameter("pmhCount"));
					}
							
							
					if (request.getParameter(HIN_ID) != null) {
						hinId = Integer.parseInt(request.getParameter(HIN_ID));
					}
					if (!request.getParameter(VISIT_ID).equals("")) {
						visitId = Integer.parseInt(request.getParameter(VISIT_ID));
					}
						
							
							if (request.getParameter(NIPPLE) != null) {
								nipple = request.getParameter(NIPPLE);
							}
							if (request.getParameter(BREAST) != null) {
								breast = request.getParameter(BREAST);
							}
							
							if (request.getParameter("weightValue") != null) {
								weight = request.getParameter("weightValue");
								infoMap.put("weight", weight);
							}
							
							if (request.getParameter("heightValue") != null) {
								height = request.getParameter("heightValue");
								infoMap.put("height", height);
							}
							if (request.getParameter("bmiValue") != null) {
								bmi = request.getParameter("bmiValue");
								infoMap.put("bmi", bmi);
							}
						
							if (request.getParameter("bmicat") != null) {
								bmiStatus = request.getParameter("bmicat");
							}
							if (request.getParameter(THYROID) != null) {
								thyriod = request.getParameter(THYROID);
							}
							String pallorGenExam = "";
							if (request.getParameter("pallorGenExam") != null) {
								pallorGenExam = request.getParameter("pallorGenExam");
							}
							String icterusGenExam = "";
							if (request.getParameter("icterusGenExam") != null) {
								icterusGenExam = request.getParameter("icterusGenExam");
							}
							String cyanosisGenExam = "";
							if (request.getParameter("cyanosisGenExam") != null) {
								cyanosisGenExam = request.getParameter("cyanosisGenExam");
							}
							String lymphadenopathyGenExam = "";
							if (request.getParameter("lymphadenopathyGenExam") != null) {
								lymphadenopathyGenExam = request.getParameter("lymphadenopathyGenExam");
							}
							String lymphadenopathyGenExamValue = "";
							if (request.getParameter("lymphadenopathyGenExamValue") != null) {
								lymphadenopathyGenExamValue = request.getParameter("lymphadenopathyGenExamValue");
							}
							String edemaGenExam = "";
							if (request.getParameter("edemaGenExam") != null) {
								edemaGenExam = request.getParameter("edemaGenExam");
							}
							
							String spine = "";
							if (request.getParameter("spine") != null) {
								spine = request.getParameter("spine");
							}
							String gait = "";
							if (request.getParameter("gait") != null) {
								gait = request.getParameter("gait");
							}
							String otherGeneralEamination = "";
							if (request.getParameter("otherGeneralEamination") != null) {
								otherGeneralEamination = request.getParameter("otherGeneralEamination");
							}
							
							if (request.getParameter(TETANUS_ONE_DOSE_DATE) != null
									&& !(request.getParameter(TETANUS_ONE_DOSE_DATE).equals(""))) {
								tetanusOnestDoseDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter(TETANUS_ONE_DOSE_DATE));
								infoMap.put("tetanusOnestDoseDate", tetanusOnestDoseDate);
							}
							if (request.getParameter(TETANUS_TWO_DOSE_DATE) != null
									&& !(request.getParameter(TETANUS_TWO_DOSE_DATE).equals(""))) {
								tetanusTwondDoseDate = HMSUtil.dateFormatterDDMMYYYY(request
										.getParameter(TETANUS_TWO_DOSE_DATE));
								infoMap.put("tetanusTwondDoseDate", tetanusTwondDoseDate);
							}
							String otherTTDetails = "";
							if (request.getParameter("otherTTDetails") != null && (!request.getParameter("otherTTDetails").equals(""))) {
								otherTTDetails = request.getParameter("otherTTDetails");
							}

							if (request.getParameter(MEDICAL_DISORDER) != null
									&& (!request.getParameter(MEDICAL_DISORDER).equals(""))) {
								medicalDisord = request.getParameter(MEDICAL_DISORDER);
							}
							String obstetricComplications = "";
							if (request.getParameter("obstetricComplications") != null && (!request.getParameter("obstetricComplications").equals(""))) {
								obstetricComplications = request.getParameter("obstetricComplications");
							}
							String obstetricValues = "";
							if (request.getParameter("obstetricValues") != null && (!request.getParameter("obstetricValues").equals(""))) {
								obstetricValues = request.getParameter("obstetricValues");
							}
							
							Users user = (Users) session.getAttribute("users");
							int userId = user.getId();
							OpdAntenatalCard antenatalCard =null;
							OpdAntenatalCardPregnancy antCardPregnancy = null;
							OpdAntenatalCardMedicalHistory antCardMedicalHistory = null;
							
							try {
								
								int opdhdb=0;
								if (request.getParameter("opdhdb") != null
										&& (!request.getParameter("opdhdb").equals(""))) {
									opdhdb = Integer.parseInt(request.getParameter("opdhdb"));
								}
								int pmhhdb=0;
								if (request.getParameter("pmhhdb") != null
										&& (!request.getParameter("pmhhdb").equals(""))) {
									pmhhdb = Integer.parseInt(request.getParameter("pmhhdb"));
								}

								MasDepartment masDepartment = new MasDepartment();
								masDepartment.setId(departmentId);
								

								MasHospital masHospital = new MasHospital();
								masHospital.setId(hospitalId);
								infoMap.put("masHospital", masHospital); 
								

								Patient patient = new Patient();
								patient.setId(hinId);
								infoMap.put("patient", patient); 
								
								

								Visit visit = new Visit();
								visit.setId(visitId);
								
								if(opdhdb >= 0){
									for(int op=0;op<=opdhdb;op++){
										int count=0;
										if (request.getParameter(YEAR+op) != null
												&& !(request.getParameter(YEAR+op).equals(""))) {
											year = request.getParameter(YEAR+op);
											count = 1;
										}
										if ((request.getParameter(AGE_UNIT+op) != null)
												&& (!request.getParameter(AGE_UNIT+op).equals(""))) {
											age = Integer.parseInt(request.getParameter(AGE_UNIT+op));
											count = 1;
										}
										if (request.getParameter(PREGNANCY_OUTCOME+op) != null) {
											pregnancyOutcome = request.getParameter(PREGNANCY_OUTCOME+op);
											count = 1;
										}
										if (request.getParameter("preTermValue"+op) != null) {
											preTermValue = request.getParameter("preTermValue"+op);
											count = 1;
										}
										
										if (request.getParameter(PLACE_OF_DELIVERY+op) != null) {
											placeDelivery = request.getParameter(PLACE_OF_DELIVERY+op);
											count = 1;
										}
										if (request.getParameter("placeOfDeliveryOthers"+op) != null) {
											placeOfDeliveryOthers = request.getParameter("placeOfDeliveryOthers"+op);
											count = 1;
										}
										if (request.getParameter("deliveryOutcome"+op) != null
												&& (!request.getParameter("deliveryOutcome"+op).equals(""))) {
											deliveryOutcome = request.getParameter("deliveryOutcome"+op);
											count = 1;
										}
										
										if (request.getParameter(SEX+op) != null) {
											sex = request.getParameter(SEX+op);
											count = 1;
										}
										if (request.getParameter("previousGestationalAge"+op) != null) {
											previousGestationalAge = request.getParameter("previousGestationalAge"+op);
											count = 1;
										}
										if (request.getParameter(BIRTH_WEIGHT+op) != null
												&& (!request.getParameter(BIRTH_WEIGHT+op).equals(""))) {
											birthWeight = Integer.parseInt(request.getParameter(BIRTH_WEIGHT+op));
											count = 1;
										}
										if (request.getParameter("antenatal"+op) != null) {
											antenatal = request.getParameter("antenatal"+op);
											count = 1;
										}
										if (request.getParameter("intraPartum"+op) != null) {
											intraPartum = request.getParameter("intraPartum"+op);
											count = 1;
										}
										if (request.getParameter("postPartum"+op) != null) {
											postPartum = request.getParameter("postPartum"+op);
											count = 1;
										}
										if (request.getParameter(BLOOD_TRANSFUSION+op) != null) {
											bloodTransfusion = request.getParameter(BLOOD_TRANSFUSION+op);
											count = 1;
										}
										

										if(count == 1) {
											antCardPregnancy = new OpdAntenatalCardPregnancy();
											antCardPregnancy.setYear(year);
											antCardPregnancy.setAge(age);
											antCardPregnancy.setPregnancyOutcome(pregnancyOutcome);
											if(pregnancyOutcome.equalsIgnoreCase("Pre Term")){
												antCardPregnancy.setPregnancyOutcomePreTermValue(preTermValue);
											}
											antCardPregnancy.setPlaceDelivery(placeDelivery);
											if(placeDelivery.equalsIgnoreCase("Others")){
												antCardPregnancy.setPlaceOfDeliveryOthersValue(placeOfDeliveryOthers);
											}
											antCardPregnancy.setDeliveryOutcome(deliveryOutcome);
											antCardPregnancy.setSex(sex);
											antCardPregnancy.setPreviousGestationalAge(previousGestationalAge);
											antCardPregnancy.setBirthWeight(birthWeight);
											antCardPregnancy.setAntenatal(antenatal);
											antCardPregnancy.setIntraPartum(intraPartum);
											antCardPregnancy.setPostPartum(postPartum);
											antCardPregnancy.setBloodTransfusion(bloodTransfusion);
											
											antCardPregList.add(antCardPregnancy);
										}
										year = null; pregnancyOutcome=null; placeDelivery=null; deliveryOutcome=null; sex=null; antenatal=null; intraPartum=null; postPartum=null; bloodTransfusion=null;
										age = 0; birthWeight = 0;
									}
								}
								
								if(pmhhdb >= 0){
									for(int op=0;op<=pmhhdb;op++){
										if (request.getParameter(COMORBIDITY+op) != null
												&& (!request.getParameter(COMORBIDITY+op).equals(""))) {
											comorbidity = request.getParameter(COMORBIDITY+op);
										}
										if (request.getParameter(COM_CHRONIC_DISEASE+op) != null
												&& (!request.getParameter(COM_CHRONIC_DISEASE+op).equals(""))) {
											comChronicDisease = request.getParameter(COM_CHRONIC_DISEASE+op);
										}
										if (request.getParameter(COM_OHTER_DISEASE+op) != null
												&& (!request.getParameter(COM_OHTER_DISEASE+op).equals(""))) {
											comOtherDisease = request.getParameter(COM_OHTER_DISEASE+op);
										}
										if (request.getParameter(COM_YEARS+op) != null
												&& (!request.getParameter(COM_YEARS+op).equals(""))) {
											comYears = request.getParameter(COM_YEARS+op);
										}
										if (request.getParameter(COM_MONTHS+op) != null
												&& (!request.getParameter(COM_MONTHS+op).equals(""))) {
											comMonths = request.getParameter(COM_MONTHS+op);
										}
										if (request.getParameter(COM_REMARKS+op) != null
												&& (!request.getParameter(COM_REMARKS+op).equals(""))) {
											comRemarks = request.getParameter(COM_REMARKS+op);
										}

										if(comorbidity != "" || comYears != "" || comMonths != "" || comMonths != "" || comRemarks != "") {
											antCardMedicalHistory = new OpdAntenatalCardMedicalHistory();
											antCardMedicalHistory.setComorbidity(comorbidity);
											antCardMedicalHistory.setChronicDisease(comChronicDisease);
											antCardMedicalHistory.setOtherDisease(comOtherDisease);
											antCardMedicalHistory.setYears(comYears);
											antCardMedicalHistory.setMonths(comMonths);
											antCardMedicalHistory.setRemarks(comRemarks);
											
											antCardMedHistList.add(antCardMedicalHistory);
										}
										comorbidity=null; comChronicDisease=null; comOtherDisease=null; comYears=null; comMonths=null; comRemarks=null;
									}
								}
								
							  for(int i=1;i<=11;i++){
								  OpdAntenatalUsg opdAntenatalUsg = new OpdAntenatalUsg();
								  
								if (request.getParameter("usgFirstTrimOne"+i) != null && (!request.getParameter("usgFirstTrimOne"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameter(request.getParameter("usgFirstTrimOne"+i));
								}else{
									opdAntenatalUsg.setUsgParameter(null);
								}
							
								if (request.getParameter("usgFirstTrimTwo"+i) != null && (!request.getParameter("usgFirstTrimTwo"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue1(request.getParameter("usgFirstTrimTwo"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue1(null);
								}
								if (request.getParameter("usgFirstTrimThree"+i) != null && (!request.getParameter("usgFirstTrimThree"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue2(request.getParameter("usgFirstTrimThree"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue2(null);
								}
								if (request.getParameter("usgFirstTrimFour"+i) != null && (!request.getParameter("usgFirstTrimFour"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue3(request.getParameter("usgFirstTrimFour"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue3(null);
								}
								opdAntenatalUsg.setTrimister("First");
								usgReportFirstTrimList.add(opdAntenatalUsg); 
								
							 }
							  
							  for(int i=1;i<=5;i++){
								  OpdAntenatalUsg opdAntenatalUsg = new OpdAntenatalUsg();
								  
								if (request.getParameter("usgSecondTrimOne"+i) != null && (!request.getParameter("usgSecondTrimOne"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameter(request.getParameter("usgSecondTrimOne"+i));
								}else{
									opdAntenatalUsg.setUsgParameter(null);
								}
							
								if (request.getParameter("usgSecondTrimTwo"+i) != null && (!request.getParameter("usgSecondTrimTwo"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue1(request.getParameter("usgSecondTrimTwo"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue1(null);
								}
								if (request.getParameter("usgSecondTrimThree"+i) != null && (!request.getParameter("usgSecondTrimThree"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue2(request.getParameter("usgSecondTrimThree"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue2(null);
								}
								if (request.getParameter("usgSecondTrimFour"+i) != null && (!request.getParameter("usgSecondTrimFour"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue3(request.getParameter("usgSecondTrimFour"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue3(null);
								}
								opdAntenatalUsg.setTrimister("Second");
								usgReportSecondTrimList.add(opdAntenatalUsg); 
								
							 }
							
							  for(int i=1;i<=11;i++){
								  OpdAntenatalUsg opdAntenatalUsg = new OpdAntenatalUsg();
								  
								if (request.getParameter("usgThirdTrimOne"+i) != null && (!request.getParameter("usgThirdTrimOne"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameter(request.getParameter("usgThirdTrimOne"+i));
								}else{
									opdAntenatalUsg.setUsgParameter(null);
								}
							
								if (request.getParameter("usgThirdTrimTwo"+i) != null && (!request.getParameter("usgThirdTrimTwo"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue1(request.getParameter("usgThirdTrimTwo"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue1(null);
								}
								if (request.getParameter("usgThirdTrimThree"+i) != null && (!request.getParameter("usgThirdTrimThree"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue2(request.getParameter("usgThirdTrimThree"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue2(null);
								}
								if (request.getParameter("usgThirdTrimFour"+i) != null && (!request.getParameter("usgThirdTrimFour"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue3(request.getParameter("usgThirdTrimFour"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue3(null);
								}
								
								if (request.getParameter("usgThirdTrimFive"+i) != null && (!request.getParameter("usgThirdTrimFive"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue4(request.getParameter("usgThirdTrimFive"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue4(null);
								}
								
								if (request.getParameter("usgThirdTrimSix"+i) != null && (!request.getParameter("usgThirdTrimSix"+i).equals(""))) {
									opdAntenatalUsg.setUsgParameterValue5(request.getParameter("usgThirdTrimSix"+i));
								}else{
									opdAntenatalUsg.setUsgParameterValue5(null);
								}
								opdAntenatalUsg.setTrimister("Third");
								usgReportThirdTrimList.add(opdAntenatalUsg); 
								
							 }
								
								
								int count=0;
								if(AntCount==1 && exist==1){
									System.out.println("AntCount==1 && exist==1");
									antenatalCard = new OpdAntenatalCard();
									count=1;
								}
								if(exist==0 && AntCount==0){
									System.out.println("exist==0 && AntCount==0");
									antenatalCard = new OpdAntenatalCard();
									count=1;
								}
								if(exist==0 && AntCount==1){
									System.out.println("exist==0 && AntCount==1");
									antenatalCard = new OpdAntenatalCard();
									count=1;
								}
								if(exist!=1){
								antenatalCard.setHospital(masHospital);
								antenatalCard.setHin(patient);
								antenatalCard.setVisit(visit);
								antenatalCard.setDepartment(masDepartment);
								antenatalCard.setLastChgTime(time);
								antenatalCard.setLastChgBy(userId);
								antenatalCard.setStatus("y");
								antenatalCard.setLastChgDate(HMSUtil
										.convertStringTypeDateToDateType(date));

								antenatalCard.setAbortions(abortions);
								antenatalCard.setVesicular(vesicular);
								antenatalCard.setMtp(mtp);
								antenatalCard.setIud(iud);
								antenatalCard.setStillBirth(stillBirth);
								antenatalCard.setNnd(nnd);
								antenatalCard.setScannedEdc(scannedEdc);
								antenatalCard.setEctopic(ectopic);
								antenatalCard.setEdd(edd);
								
								antenatalCard.setGravida1(gravida);
								antenatalCard.setLive(liveBirth);
								
								antenatalCard.setLmp(lmp);

								antenatalCard.setMenarche(menarche);
								antenatalCard.setCycle(cycle);
								antenatalCard.setDays(days);
								antenatalCard.setCycle1(cycle1);
								antenatalCard.setDays1(days1);
								antenatalCard.setCycle2(cycle2);
								antenatalCard.setDays2(days2);
								antenatalCard.setCycle3(cycle3);
								antenatalCard.setDays3(days3);
								
								antenatalCard.setAgeYear(years);
								antenatalCard.setAgeMonth(months);
								antenatalCard.setConsanguineous(consanguineous);
								antenatalCard.setDegree(degree);
								antenatalCard.setInfertility(infertility);
								antenatalCard.setFactor(factor);
								antenatalCard.setInfertilityDetails(infertilityDetails);
								
								antenatalCard.setNextVisitOn(nextVisitOn);
								antenatalCard.setPara(para);
								antenatalCard.setMedicalDisord(medicalDisord);
								antenatalCard.setObstetricComplications(obstetricComplications);
								if(!obstetricValues.equals("")){
									antenatalCard.setObstetricValues(obstetricValues);
								}
								if(pastSurgicalHistoryRadio != null && pastSurgicalHistoryRadio.equalsIgnoreCase("Yes")){
									antenatalCard.setSurgicalHistoryRadio(pastSurgicalHistoryRadio);
									antenatalCard.setSurgicalHistory(surgicalHistory);
								}else{
									antenatalCard.setSurgicalHistoryRadio(pastSurgicalHistoryRadio);
								}
								
								
								/*if (request.getParameter("dateUsgReport") != null && (!request.getParameter("dateUsgReport").equals(""))) {
									antenatalCard.setDateUsgReport(request.getParameter("dateUsgReport"));
								}
								
								if (request.getParameter("dateUsgOne") != null && (!request.getParameter("dateUsgOne").equals(""))) {
									antenatalCard.setDateUsgOne(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateUsgOne")));
								}
								
								if (request.getParameter("dateUsgTwo") != null && (!request.getParameter("dateUsgTwo").equals(""))) {
									antenatalCard.setDateUsgTwo(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateUsgTwo")));
								}
								
								if (request.getParameter("dateUsgThree") != null && (!request.getParameter("dateUsgThree").equals(""))) {
									antenatalCard.setDateUsgThree(HMSUtil.convertStringTypeDateToDateType(request.getParameter("dateUsgThree")));
								}
								
								
								
								if (request.getParameter("lmpGaUsgReport") != null && (!request.getParameter("lmpGaUsgReport").equals(""))) {
									antenatalCard.setLmpGaUsgReport(request.getParameter("lmpGaUsgReport"));
								}
								
								if (request.getParameter("lmpGaOne") != null && (!request.getParameter("lmpGaOne").equals(""))) {
									antenatalCard.setLmpGaOne(request.getParameter("lmpGaOne"));
								}
								
								if (request.getParameter("lmpGaTwo") != null && (!request.getParameter("lmpGaTwo").equals(""))) {
									antenatalCard.setLmpGaTwo(request.getParameter("lmpGaTwo"));
								}
								
								if (request.getParameter("lmpGaThree") != null && (!request.getParameter("lmpGaThree").equals(""))) {
									antenatalCard.setLmpGaThree(request.getParameter("lmpGaThree"));
								}
								
							
								if (request.getParameter("usgGaUsgReport") != null && (!request.getParameter("usgGaUsgReport").equals(""))) {
									antenatalCard.setUsgGaUsgReport(request.getParameter("usgGaUsgReport"));
								}
								
								if (request.getParameter("usgGaOne") != null && (!request.getParameter("usgGaOne").equals(""))) {
									antenatalCard.setUsgGaOne(request.getParameter("usgGaOne"));
								}
								
								if (request.getParameter("usgGaTwo") != null && (!request.getParameter("usgGaTwo").equals(""))) {
									antenatalCard.setUsgGaTwo(request.getParameter("usgGaTwo"));
								}
								
								if (request.getParameter("usgGaThree") != null && (!request.getParameter("usgGaThree").equals(""))) {
									antenatalCard.setUsgGaThree(request.getParameter("usgGaThree"));
								}
								
								
								
								if (request.getParameter("afiUsgReport") != null && (!request.getParameter("afiUsgReport").equals(""))) {
									antenatalCard.setAfiUsgReport(request.getParameter("afiUsgReport"));
								}
								
								if (request.getParameter("afiOne") != null && (!request.getParameter("afiOne").equals(""))) {
									antenatalCard.setAfiOne(request.getParameter("afiOne"));
								}
								
								if (request.getParameter("afiTwo") != null && (!request.getParameter("afiTwo").equals(""))) {
									antenatalCard.setAfiTwo(request.getParameter("afiTwo"));
								}
								
								if (request.getParameter("afiThree") != null && (!request.getParameter("afiThree").equals(""))) {
									antenatalCard.setAfiThree(request.getParameter("afiThree"));
								}
								
								
								if (request.getParameter("bppUsgReport") != null && (!request.getParameter("bppUsgReport").equals(""))) {
									antenatalCard.setBppUsgReport(request.getParameter("bppUsgReport"));
								}
								
								if (request.getParameter("bppOne") != null && (!request.getParameter("bppOne").equals(""))) {
									antenatalCard.setBppOne(request.getParameter("bppOne"));
								}
							
								if (request.getParameter("bppTwo") != null && (!request.getParameter("bppTwo").equals(""))) {
									antenatalCard.setBppTwoUsg(request.getParameter("bppTwo"));
								}
								
								if (request.getParameter("bppThree") != null && (!request.getParameter("bppThree").equals(""))) {
									antenatalCard.setBppThree(request.getParameter("bppThree"));
								}
								
								
								
								if (request.getParameter("bpdUsgReport") != null && (!request.getParameter("bpdUsgReport").equals(""))) {
									antenatalCard.setBpdUsgReport(request.getParameter("bpdUsgReport"));
								}
								
								if (request.getParameter("bpdOne") != null && (!request.getParameter("bpdOne").equals(""))) {
									antenatalCard.setBpdOne(request.getParameter("bpdOne"));
								}
								
								if (request.getParameter("bpdTwo") != null && (!request.getParameter("bpdTwo").equals(""))) {
									antenatalCard.setBppTwo(request.getParameter("bpdTwo"));
								}
								
								if (request.getParameter("bpdThree") != null && (!request.getParameter("bpdThree").equals(""))) {
									antenatalCard.setBpdThree(request.getParameter("bpdThree"));
								}
								
								
								if (request.getParameter("flUsgReport") != null && (!request.getParameter("flUsgReport").equals(""))) {
									antenatalCard.setFlUsgReport(request.getParameter("flUsgReport"));
								}
								
								if (request.getParameter("flOne") != null && (!request.getParameter("flOne").equals(""))) {
									antenatalCard.setFlOne(request.getParameter("flOne"));
								}
								
								if (request.getParameter("flTwo") != null && (!request.getParameter("flTwo").equals(""))) {
									antenatalCard.setFlTwo(request.getParameter("flTwo"));
								}
								
								if (request.getParameter("flThree") != null && (!request.getParameter("flThree").equals(""))) {
									antenatalCard.setFlThree(request.getParameter("flThree"));
								}
								
							
								if (request.getParameter("acUsgReport") != null && (!request.getParameter("acUsgReport").equals(""))) {
									antenatalCard.setAcUsgReport(request.getParameter("acUsgReport"));
								}
								
								if (request.getParameter("acOne") != null && (!request.getParameter("acOne").equals(""))) {
									antenatalCard.setAcOne(request.getParameter("acOne"));
								}
								
								if (request.getParameter("acTwo") != null && (!request.getParameter("acTwo").equals(""))) {
									antenatalCard.setAcTwo(request.getParameter("acTwo"));
								}
								
								if (request.getParameter("acThree") != null && (!request.getParameter("acThree").equals(""))) {
									antenatalCard.setAcThree(request.getParameter("acThree"));
								}
								
								
								if (request.getParameter("hcUsgReport") != null && (!request.getParameter("hcUsgReport").equals(""))) {
									antenatalCard.setHcUsgReport(request.getParameter("hcUsgReport"));
								}
								
								if (request.getParameter("hcOne") != null && (!request.getParameter("hcOne").equals(""))) {
									antenatalCard.setHcOne(request.getParameter("hcOne"));
								}
								
								if (request.getParameter("hcTwo") != null && (!request.getParameter("hcTwo").equals(""))) {
									antenatalCard.setHcTwo(request.getParameter("hcTwo"));
								}
								
								if (request.getParameter("hcThree") != null && (!request.getParameter("hcThree").equals(""))) {
									antenatalCard.setHcThree(request.getParameter("hcThree"));
								}
								
								
								if (request.getParameter("ebwUsgReport") != null && (!request.getParameter("ebwUsgReport").equals(""))) {
									antenatalCard.setEbwUsgReport(request.getParameter("ebwUsgReport"));
								}
								
								if (request.getParameter("ebwOne") != null && (!request.getParameter("ebwOne").equals(""))) {
									antenatalCard.setEbwOne(request.getParameter("ebwOne"));
								}
								
								if (request.getParameter("ebwTwo") != null && (!request.getParameter("ebwTwo").equals(""))) {
									antenatalCard.setEbwTwo(request.getParameter("ebwTwo"));
								}
								
								if (request.getParameter("ebwThree") != null && (!request.getParameter("ebwThree").equals(""))) {
									antenatalCard.setEbwThree(request.getParameter("ebwThree"));
								}
								
							
								if (request.getParameter("dopplerUsgReport") != null && (!request.getParameter("dopplerUsgReport").equals(""))) {
									antenatalCard.setDopplerUsgReport(request.getParameter("dopplerUsgReport"));
								}
								
								if (request.getParameter("dopplerOne") != null && (!request.getParameter("dopplerOne").equals(""))) {
									antenatalCard.setDopplerOne(request.getParameter("dopplerOne"));
								}
								
								if (request.getParameter("dopplerTwo") != null && (!request.getParameter("dopplerTwo").equals(""))) {
									antenatalCard.setDopplerTwo(request.getParameter("dopplerTwo"));
								}
								
								if (request.getParameter("dopplerThree") != null && (!request.getParameter("dopplerThree").equals(""))) {
									antenatalCard.setDopplerThree(request.getParameter("dopplerThree"));
								}
								
								if (request.getParameter("usgRemarks") != null && (!request.getParameter("usgRemarks").equals(""))) {
									antenatalCard.setUsgRemarks(request.getParameter("usgRemarks"));
								}*/
								
								if (request.getParameter("usgFirstTrimRemarks") != null && (!request.getParameter("usgFirstTrimRemarks").equals(""))) {
									antenatalCard.setUsgRemarks(request.getParameter("usgFirstTrimRemarks"));
								}
								if (request.getParameter("usgSecondTrimRemarks") != null && (!request.getParameter("usgSecondTrimRemarks").equals(""))) {
									antenatalCard.setUsgSecondRemarks(request.getParameter("usgSecondTrimRemarks"));
								}
								if (request.getParameter("usgThirdTrimRemarks") != null && (!request.getParameter("usgThirdTrimRemarks").equals(""))) {
									antenatalCard.setUsgThirdRemarks(request.getParameter("usgThirdTrimRemarks"));
								}

								antenatalCard.setFamilyHistory(familyHistory);
								antenatalCard.setPersonalHistory(personalHistory);
								antenatalCard.setOtherImmunizationDetail(otherImmunizationDetail);
								
								
								antenatalCard.setWeight(weight);
								antenatalCard.setHeight(height);
								antenatalCard.setBmi(bmi);
								antenatalCard.setBmiStatus(bmiStatus);
								antenatalCard.setBreast(breast);
								antenatalCard.setNipple(nipple);
								antenatalCard.setThyriod(thyriod);
								
								antenatalCard.setPallor(pallorGenExam);
								antenatalCard.setIcterus(icterusGenExam);
								antenatalCard.setCyanosis(cyanosisGenExam);
								antenatalCard.setLymphadenopathy(lymphadenopathyGenExam);
								antenatalCard.setLymphadenopathyValue(lymphadenopathyGenExamValue);
								antenatalCard.setEdema(edemaGenExam);
								antenatalCard.setSpine(spine);
								antenatalCard.setGait(gait);
								antenatalCard.setOthersGeneralExamination(otherGeneralEamination);
								
								antenatalCard.setTetanusOnestDoseDate(tetanusOnestDoseDate);
								antenatalCard.setTetanusTwondDoseDate(tetanusTwondDoseDate);
								antenatalCard.setOthersTtDetails(otherTTDetails);
								
								antenatalCard.setGestationalAgeWeeks(gestationalAgeWeeks);
								antenatalCard.setGestationalAgeDays(gestationalAgeDays);
								antenatalCard.setDurationOfMarriageYear(durationOfMarriageYear);
								antenatalCard.setDurationOfMarriageMonth(durationOfMarriageMonth);
								
								antenatalCard.setReferredFromPrivate(referredFromPrivate);
								antenatalCard.setReferredFromPrivateDetail(referredFromPrivateValue);
								

								String referredDept = "";
								String[] referredToDeptArray = null;
								if (request.getParameterValues(DEPARTMENT_ID) != null) {
									referredToDeptArray = (String[]) request
											.getParameterValues(DEPARTMENT_ID);
									for (int i = 0; i < referredToDeptArray.length; i++) {
										if (i == 0) {
											referredDept = referredToDeptArray[i];
										} else {
											referredDept = referredDept + ","
													+ referredToDeptArray[i];
										}
									}
								}
								infoMap.put("referredDept", referredDept);
								
							   }
								System.out.println("antenatalCard "+(antenatalCard!=null));
							
								infoMap.put("antenatalCard", antenatalCard);
								infoMap.put("antCardPregList", antCardPregList);
								infoMap.put("antCardMedHistList", antCardMedHistList);
								infoMap.put("usgReportFirstTrimList", usgReportFirstTrimList);
								infoMap.put("usgReportSecondTrimList", usgReportSecondTrimList);
								infoMap.put("usgReportThirdTrimList", usgReportThirdTrimList);
								infoMap.put("visitId", visitId);
								infoMap.put("hospitalId", hospitalId);
								
								infoMap.put("referredDepartment", masDepartment);
								
								infoMap.put("hinId", hinId);
								infoMap.put("userId", userId);
								infoMap.put("time", time);
								infoMap.put("date", date);
								infoMap.put("exist", exist);
								infoMap.put("AntCount", AntCount);
								infoMap.put("antCardId", antCardId);
								infoMap.put("count", count);
								
								antCardTrimeList=getOpdAntenatalCardTrimester2(request);
								
								System.out.println("antCardTrimeList "+antCardTrimeList.size());
								
								infoMap.put("antCardTrimeList", antCardTrimeList);
								
							}

							catch (Exception e) {
								e.printStackTrace();
							}

							return infoMap;
						}
				
				public List<OpdAntenatalCardTrimester> getOpdAntenatalCardTrimester2(HttpServletRequest request){
					List<OpdAntenatalCardTrimester> antCardTrimeList=new ArrayList<OpdAntenatalCardTrimester>();
					int hdb=0,hdb1=0,hdb2=0,hdb3=0,weight=0;
					String ftdate="",gaWeeks=null,gaDays=null,bpSystolics=null,bpDiastolics=null,pvTrimes=null,paTrimes=null,urinAlbumin=null;
					Date trimesDate=null;

					if (request.getParameter("hdb") != null
							&& (!request.getParameter("hdb").equals(""))) {
						hdb = Integer.parseInt(request.getParameter("hdb"));//first trimester total data count
						antCardTrimeList=getTrimester2(request, antCardTrimeList, hdb, 1, "ft");
					}
					if (request.getParameter("hdb1") != null
							&& (!request.getParameter("hdb1").equals(""))) {
						hdb1 = Integer.parseInt(request.getParameter("hdb1"));//second trimester total data count
						antCardTrimeList=getTrimester2(request, antCardTrimeList, hdb1, 2, "st");
					}
					if (request.getParameter("hdb2") != null
							&& (!request.getParameter("hdb2").equals(""))) {
						hdb2 = Integer.parseInt(request.getParameter("hdb2"));//third trimester total data count
						antCardTrimeList=getTrimester2(request, antCardTrimeList, hdb2, 3, "tt");
					}
						
					return antCardTrimeList;
				}
				
				public List<OpdAntenatalCardTrimester> getTrimester2(HttpServletRequest request,List<OpdAntenatalCardTrimester> antCardTrimeList,
						int hdb,int type,String trimType){
					BigDecimal weight= new BigDecimal(0);
					int fhs=0,flag=1;
					String ftdate="",gaWeeks=null,gaDays=null,bpSystolics=null,bpDiastolics=null,pvTrimes=null,paTrimes=null,urinAlbumin=null;
					String pallor=null,odemia=null,systemicExamin=null,obstetricRiskMeasure=null;
					Date trimesDate=null;
					OpdAntenatalCardTrimester antCardTrime=null;
					String cvs="",respSystem="",antFtdate="",antFtAdvise="";
					String  othersFirstTrimster = "";
					String generalExamination = "";
					String localExamination = "";
					
					for(int u=0;u<=hdb;u++){
									
						if (request.getParameter(trimType+"date"+u) != null
								&& (!request.getParameter(trimType+"date"+u).equals(""))) {
							ftdate = request.getParameter(trimType+"date"+u);
							trimesDate=HMSUtil.convertStringTypeDateToDateType(ftdate);
						}
						if (request.getParameter(trimType+"GA1"+u) != null
								&& (!request.getParameter(trimType+"GA1"+u).equals(""))) {
							gaWeeks = request.getParameter(trimType+"GA1"+u);
						}
						if (request.getParameter(trimType+"GA2"+u) != null
								&& (!request.getParameter(trimType+"GA2"+u).equals(""))) {
							gaDays = request.getParameter(trimType+"GA2"+u);
						}				
						if (request.getParameter(trimType+"systolic"+u) != null
								&& (!request.getParameter(trimType+"systolic"+u).equals(""))) {
							bpSystolics = request.getParameter(trimType+"systolic"+u);
						}
						if (request.getParameter(trimType+"diastolic"+u) != null
								&& (!request.getParameter(trimType+"diastolic"+u).equals(""))) {
							bpDiastolics = request.getParameter(trimType+"diastolic"+u);
						}
						if (request.getParameter(trimType+"PA"+u) != null
								&& (!request.getParameter(trimType+"PA"+u).equals(""))) {
							paTrimes = request.getParameter(trimType+"PA"+u);
						}
						
						if (request.getParameter(trimType+"PA"+u) != null
								&& (!request.getParameter(trimType+"PA"+u).equals(""))) {
							paTrimes = request.getParameter(trimType+"PA"+u);
						}
						
						
						if (request.getParameter(trimType+"Weight"+u) != null
								&& (!request.getParameter(trimType+"Weight"+u).equals(""))) {
							weight = new BigDecimal(request.getParameter(trimType+"Weight"+u));
						}
						if (request.getParameter(trimType+"Pallor"+u) != null
								&& (!request.getParameter(trimType+"Pallor"+u).equals(""))) {
							pallor = request.getParameter(trimType+"Pallor"+u);
						}
						if (request.getParameter(trimType+"Odemia"+u) != null
								&& (!request.getParameter(trimType+"Odemia"+u).equals(""))) {
							odemia = request.getParameter(trimType+"Odemia"+u);
						}
						if (request.getParameter(trimType+"SystemicExam"+u) != null
								&& (!request.getParameter(trimType+"SystemicExam"+u).equals(""))) {
							systemicExamin = request.getParameter(trimType+"SystemicExam"+u);
						}
						if (request.getParameter(trimType+"ObsRi"+u) != null
								&& (!request.getParameter(trimType+"ObsRi"+u).equals(""))) {
							obstetricRiskMeasure = request.getParameter(trimType+"ObsRi"+u);
						}
						if (request.getParameter(trimType+"Fhs"+u) != null
								&& (!request.getParameter(trimType+"Fhs"+u).equals(""))) {
							fhs = Integer.parseInt(request.getParameter(trimType+"Fhs"+u));
						}
						
						if (request.getParameter(trimType+"GeneralExaminationTrim"+u) != null
								&& (!request.getParameter(trimType+"GeneralExaminationTrim"+u).equals(""))) {
							generalExamination = request.getParameter(trimType+"GeneralExaminationTrim"+u);
						}
						
						if (request.getParameter(trimType+"LocalExaminationTrim"+u) != null
								&& (!request.getParameter(trimType+"LocalExaminationTrim"+u).equals(""))) {
							localExamination = request.getParameter(trimType+"LocalExaminationTrim"+u);
						}
						


						if(trimesDate!=null || gaWeeks!=null || gaDays!=null || bpSystolics!=null
								|| bpDiastolics!=null || paTrimes!=null || weight.compareTo(new BigDecimal(0))>0){
						antCardTrime=new OpdAntenatalCardTrimester();
							
						antCardTrime.setTrimesDate(trimesDate);
						antCardTrime.setGaWeeks(gaWeeks);
						antCardTrime.setGaDays(gaDays);
						antCardTrime.setBpSystolics(bpSystolics);
						antCardTrime.setBpDiastolics(bpDiastolics);
						antCardTrime.setPaTrimes(paTrimes);
						antCardTrime.setWeight(weight);
						antCardTrime.setPallor(pallor);
						antCardTrime.setOdemia(odemia);
						antCardTrime.setSystemicExamin(systemicExamin);
						antCardTrime.setObstetricRiskMeasure(obstetricRiskMeasure);
						antCardTrime.setFhs(fhs);
						antCardTrime.setTrimesterType(type);
						antCardTrime.setGeneralExamination(generalExamination);
						antCardTrime.setLocalExamination(localExamination);

						if(trimType.equals("ft")){
							if (request.getParameter(trimType+"PV"+u) != null
									&& (!request.getParameter(trimType+"PV"+u).equals(""))) {
								pvTrimes = request.getParameter(trimType+"PV"+u);
								antCardTrime.setPvTrimes(pvTrimes);
							}
							
						}else{
							if (request.getParameter(trimType+"UrinAl"+u) != null
									&& (!request.getParameter(trimType+"UrinAl"+u).equals(""))) {
								urinAlbumin = request.getParameter(trimType+"UrinAl"+u);
								antCardTrime.setUrinAlbumin(urinAlbumin);
							}
							
						}
						
						if(type==1 && flag==1){
							flag=0;
							System.out.print("trimester type==1");
						if (request.getParameter("ftCVS") != null
								&& (!request.getParameter("ftCVS").equals(""))) {
							cvs = request.getParameter("ftCVS");
							antCardTrime.setCvs(cvs);
						}
						
						if (request.getParameter("ftRespSys") != null
								&& (!request.getParameter("ftRespSys").equals(""))) {
							respSystem = request.getParameter("ftRespSys");
							antCardTrime.setRespSystem(respSystem);
						}
						
						if (request.getParameter("ftOthersFirstTrimster") != null
								&& (!request.getParameter("ftOthersFirstTrimster").equals(""))) {
							othersFirstTrimster = request.getParameter("ftOthersFirstTrimster");
							antCardTrime.setOthersFirstTrimster(othersFirstTrimster);
						}
						
						if (request.getParameter("ftSubDate") != null
								&& (!request.getParameter("ftSubDate").equals(""))) {
							antFtdate = request.getParameter("ftSubDate");
							antCardTrime.setAntFtdae(HMSUtil.convertStringTypeDateToDateType(antFtdate));
							
						}
						
						if (request.getParameter("ftAdvise") != null
								&& (!request.getParameter("ftAdvise").equals(""))) {
							antFtAdvise = request.getParameter("ftAdvise");
							antCardTrime.setFtAdvice(antFtAdvise);
						}
						}
						
						antCardTrimeList.add(antCardTrime);
						}
						
						ftdate="";gaWeeks=null;gaDays=null;bpSystolics=null;bpDiastolics=null;pvTrimes=null;paTrimes=null;urinAlbumin=null;
						trimesDate=null;weight=new BigDecimal(0);
					}
					
					return antCardTrimeList;
				}
				
				
				
	
				
				public ModelAndView printIssuedKitListReport(HttpServletRequest request, HttpServletResponse response) {

                    HttpSession session = request.getSession();

                    //int hospitalId=0;

                    String adNo="";

                    String serviceNo="";

                    String hinNo="";

                    int hinId=0;

                    int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);

                    if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {

                                    adNo = request.getParameter("adNo");

                    }

                    if (request.getParameter("serviceNo") != null && request.getParameter("serviceNo") !="") {

                                    serviceNo = request.getParameter("serviceNo");

                    }

                    if (request.getParameter("hinNo") != null && request.getParameter("hinNo") !="") {

                                    hinNo = request.getParameter("hinNo");

                    }

                    if (request.getParameter("flag1") != null && request.getParameter("flag1") !="") {

                                    hinId=Integer.parseInt(request.getParameter("hinId"));

                              //      hinNo=ipdHandlerService.getHinNoForCaseSheet(hinId,hospitalId);

                    }

                    Map<String, Object> detailsMap = new HashMap<String, Object>();



                    detailsMap = ipdHandlerService.getDBConnection();

                    Map<String, Object> parameters = new HashMap<String, Object>();



                    parameters.put("hospitalId", hospitalId);

                    parameters.put("adNo", adNo);

                    parameters.put("serviceNo", serviceNo);

                    parameters.put("hinNo", hinNo);

                    //parameters.put("timeFor", timeFor);

                    /*parameters.put("SUBREPORT_DIR", getServletContext().getRealPath("/reports/"));

                    if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("prescription"))){

                    HMSUtil.generateReport("InpatientPrescriptionFormat", parameters,

                                                    (Connection) detailsMap.get("conn"), response, getServletContext());

                    }else if(request.getParameter("flag")!=null && (request.getParameter("flag").equals("investigation"))){*/

                                    HMSUtil.generateReport("issuedKitListReport", parameters,

                                                                    (Connection) detailsMap.get("conn"), response, getServletContext());

                    /*}*/

                    return null;

    }
				
				public ModelAndView showPatientPrescriptionDetails(HttpServletRequest request, HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> utilMap = new HashMap<String, Object>();
					Map<String, Object> infoMap = new HashMap<String, Object>();
					utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
					int inPatientId=0;
					int hinId=0;
					String hinNo="";
					
					if (request.getParameter("inPatientId") != null) {
						inPatientId =Integer.parseInt(request.getParameter("inPatientId"));
						infoMap.put("inPatientId", inPatientId);
					}
					
					if (request.getParameter("hinId") != null) {
						inPatientId =Integer.parseInt(request.getParameter("hinId"));
						infoMap.put("hinId", hinId);
					}
					
					if (request.getParameter("hinNo") != null) {
						hinNo =request.getParameter("hinNo");
						infoMap.put("hinNo", hinNo);
					}
					
					
					map=ipdHandlerService.getPatientPrescriptionDetails(infoMap);
					
					jsp =   "showprescriptiondetails.jsp";
					map.put("contentJsp", jsp);
					return new ModelAndView("showprescriptiondetails", "map", map);
				}
				
				public ModelAndView printAmbulanceSlip(HttpServletRequest request, HttpServletResponse response) {

                    HttpSession session = request.getSession();

                    //int hospitalId=0;
                   
                    String adNo="";
                    int hospitalId=0;
                    int inpatient=0;
                    int hinId=0;

                    if (request.getParameter("adNo") != null && request.getParameter("adNo") !="") {

                                    adNo = request.getParameter("adNo");

                    }

                    if (request.getParameter("hospitalId") != null && request.getParameter("hospitalId") !="") {

                    	hospitalId =Integer.parseInt(request.getParameter("hospitalId"));

                    }

                    if (request.getParameter("hinId") != null && request.getParameter("hinId") !="") {

                    	hinId =Integer.parseInt(request.getParameter("hinId"));

                    }

                    if (request.getParameter("inpatientId") != null && request.getParameter("inpatientId") !="") {

                    	inpatient =Integer.parseInt(request.getParameter("inpatientId"));

                    }

                    Map<String, Object> detailsMap = new HashMap<String, Object>();



                    detailsMap = ipdHandlerService.getDBConnection();

                    Map<String, Object> parameters = new HashMap<String, Object>();

                    parameters.put("HOSPITAL_ID", hospitalId);

                    parameters.put("adNo", adNo);

                    parameters.put("hinId", hinId);

                    parameters.put("inpatient", inpatient);

                                   HMSUtil.generateReport("IPAmbulanceRegister", parameters,

                                                                    (Connection) detailsMap.get("conn"), response, getServletContext());

                         return null;

    }		
				
				
				public ModelAndView showPatientSpecialityReportExcel(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> map = new HashMap<String, Object>();
					Map<String, Object> requestParameters = new HashMap<String, Object>();
					HttpSession session=request.getSession();
					
					int opdPatientDetailId=0;
					int hinId=0;
					if(request.getParameter("hinId")!= null){
						hinId = Integer.parseInt(request.getParameter("hinId"));
						
					}
					try {
				
						
						if(request.getParameter("opdPatientDetailId")!= null){
							opdPatientDetailId = Integer.parseInt(request.getParameter("opdPatientDetailId"));
						
						}
					
					requestParameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/Reports/"));
					requestParameters.put("opdPatientDetailId",opdPatientDetailId);
					requestParameters.put("hinId",hinId);
					Map<String, Object> connectionMap = ipdHandlerService.getConnectionForReport();
					
					HMSUtil.generateReportExl("generalSurgery", requestParameters,(Connection) connectionMap.get("conn"), response,getServletContext());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
				
public void checkForBlockedMedicine(HttpServletRequest request,HttpServletResponse response) throws IOException{
	HttpSession session=request.getSession();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	Map<String,Object> map=new HashMap<String,Object>();
	int hinId=Integer.parseInt(request.getParameter("hinId"));
	String medicineName=request.getParameter("val");
	
	dataMap.put("hinId",hinId);
	dataMap.put("medicineName",medicineName);
	
	map=ipdHandlerService.checkForBlockedMedicine(dataMap);
	Gson gsonObj = new Gson();
	String jsonResponse = gsonObj.toJson(map);
	PrintWriter out=response.getWriter();
	out.print(jsonResponse);
	
}
				
}


