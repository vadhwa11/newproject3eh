package jkt.hms.ot.controller;

import static jkt.hms.util.RequestConstants.APPOINTMENT_DATE;
import static jkt.hms.util.RequestConstants.DATE;
import static jkt.hms.util.RequestConstants.DEPT_ID;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.LOGIN_NAME;
import static jkt.hms.util.RequestConstants.OPD_RESPONSE_FOR_SURGEON_JSP;
import static jkt.hms.util.RequestConstants.OPD_RESPONSE_FOR_SURGEY_JSP;
import static jkt.hms.util.RequestConstants.OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_EMERGENCY_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_GET_ENTRY_NO_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_GET_HIN_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_MSG_HUMAN_BODY_DISPOSAL;
import static jkt.hms.util.RequestConstants.OT_MSG_OT_PROCEDURE;
import static jkt.hms.util.RequestConstants.OT_MSG_PAC_CLEARANCE;
import static jkt.hms.util.RequestConstants.OT_MSG_POST_ANESTHESIA_PROCEDURE;
import static jkt.hms.util.RequestConstants.OT_MSG_PRE_ANESTHESIA;
import static jkt.hms.util.RequestConstants.OT_PAC_CLEARANCE_LIST_JSP;
import static jkt.hms.util.RequestConstants.OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
import static jkt.hms.util.RequestConstants.OT_POP_UP_FOR_INVESTIGATION;
import static jkt.hms.util.RequestConstants.OT_POST_ANAESTHESIA_FOR_INPATIENT_JSP;
import static jkt.hms.util.RequestConstants.OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.OT_PRE_ANESTHESIA_JSP;
import static jkt.hms.util.RequestConstants.OT_RESPONSE_FOR_CHARGE_CODE_NAME_JSP;
import static jkt.hms.util.RequestConstants.OT_RESPONSE_FOR_EMP_NAME_JSP;
import static jkt.hms.util.RequestConstants.OT_SEARCH_HUMAN_BODY_PARTS_DISPOSAL_JSP;
import static jkt.hms.util.RequestConstants.OT_SPECIMEN_DISPATCH_ENTRY_FOR_INPATIENT_JSP;
import static jkt.hms.util.RequestConstants.OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP;
import static jkt.hms.util.RequestConstants.OT_SURGEON_LIST_JSP;
import static jkt.hms.util.RequestConstants.OT_SURGERY_RESPONSE_JSP;
import static jkt.hms.util.RequestConstants.OT_WORK_LOAD_REGISTER;
import static jkt.hms.util.RequestConstants.PATIENT_NAME;
import static jkt.hms.util.RequestConstants.PATIENT_TYPE;
import static jkt.hms.util.RequestConstants.P_FIRST_NAME;
import static jkt.hms.util.RequestConstants.P_LAST_NAME;
import static jkt.hms.util.RequestConstants.P_MIDDLE_NAME;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_ENTRY_HIN_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_ENTRY_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_HIN_NO;
import static jkt.hms.util.RequestConstants.RESPONSE_FOR_OT_VISIT_NO;
import static jkt.hms.util.RequestConstants.SEARCH_OT_POST_ANESTHESIA_PROCEDURE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_SHOW_OT_POST_ANESTHESIA_PROCEDURE_JSP;
import static jkt.hms.util.RequestConstants.SEARCH_SHOW_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
import static jkt.hms.util.RequestConstants.SERVICE_NO;
import static jkt.hms.util.RequestConstants.START_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.USER_ID;
import static jkt.hms.util.RequestConstants.VISIT_NUMBER;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.adt.handler.RegistrationHandlerService;
import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MasRelation;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.OtBookSurgeon;
import jkt.hms.masters.business.OtBooking;
import jkt.hms.masters.business.OtConsent;
import jkt.hms.masters.business.OtIntraOperativeTimeOut;
import jkt.hms.masters.business.OtMasUnitDay;
import jkt.hms.masters.business.OtPreOperativeCheckList;
import jkt.hms.masters.business.OtSignOut;
import jkt.hms.masters.business.OtSignOutItemConsume;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.Users;
import jkt.hms.opd.handler.OPDHandlerService;
import jkt.hms.ot.handler.OTHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.TaperedMedicineUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class OTController extends MultiActionController {
	OPDHandlerService opdHandlerService = null;
	RegistrationHandlerService registrationHandlerService = null;
	OTHandlerService otHandlerService = null;
	String jsp = "";
	String title = "";
	String message = "";
	String userName = "";
	Map<String, Object> map = new HashMap<String, Object>();

	public OTHandlerService getOtHandlerService() {
		return otHandlerService;
	}

	public void setOtHandlerService(OTHandlerService otHandlerService) {
		this.otHandlerService = otHandlerService;
	}
	
	public OPDHandlerService getOpdHandlerService() {
		return opdHandlerService;
	}

	public void setOpdHandlerService(OPDHandlerService opdHandlerService) {
		this.opdHandlerService = opdHandlerService;
	}

	// ---------------------- methods changed by vikas--------------------
	public ModelAndView showPACClearanceList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			mapForDS.put(HIN_NO, request.getParameter("uhid"));
		}
		
		if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
		}
		
		if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
		{
			mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
		}
		
		if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
		{
			mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		String fromScreen="";
		if(request.getParameter("screenFrom")!=null){
			fromScreen=request.getParameter("screenFrom");
			mapForDS.put("fromScreen",fromScreen);
		}
		map = otHandlerService.getPacClearanceList(mapForDS);
		jsp = OT_PAC_CLEARANCE_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView searchPatient(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String patientName = "";
		String hinNo = "";
		String patientType = "";

		int deptId = (Integer) session.getAttribute("deptId");

		if (request.getParameter(HIN_NO) != null
				&& !(request.getParameter(HIN_NO).equals(""))) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}
		if (request.getParameter(PATIENT_NAME) != null
				&& !(request.getParameter(PATIENT_NAME).equals(""))) {
			patientName = request.getParameter(PATIENT_NAME);
			mapForDS.put("patientName", patientName);
		}
		if (request.getParameter(PATIENT_TYPE) != null
				&& !(request.getParameter(PATIENT_TYPE).equals(""))) {
			patientType = request.getParameter(PATIENT_TYPE);
			mapForDS.put("patientType", patientType);
		}
		mapForDS.put("deptId", deptId);

		map = otHandlerService.searchpatient(mapForDS);
		jsp = OT_PAC_CLEARANCE_LIST_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPreAnesthesiaForm(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		int opdSurgeryId = Integer.parseInt(request
				.getParameter("opdSurgeryId"));
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("opdSurgeryId", opdSurgeryId);

		map = otHandlerService.showPreAnesthesiaForm(mapForDS);
		jsp = OT_PRE_ANESTHESIA_JSP;
		jsp += ".jsp";
		title = "Pre-Anesthesia Form";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView openPopUPWindowForInvestigationJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int visitId = 0;
		int hinId = 0;
		int inpatientId = 0;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		String patientStatus = request.getParameter("patientStatus");
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		dataMap.put(HOSPITAL_ID, hospitalId);
		hinId = Integer.parseInt(request.getParameter("hinId"));
		if (patientStatus.equals("OutPatient")) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
			dataMap.put("visitId", visitId);
		} else {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			dataMap.put("inpatientId", inpatientId);
		}
		dataMap.put("hinId", hinId);
		dataMap.put("patientStatus", patientStatus);
		map = otHandlerService.getInvestigationDetails(dataMap);

		jsp = OT_POP_UP_FOR_INVESTIGATION;
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitPreAnesthesiaDetails(HttpServletRequest request,
			HttpServletResponse response) {

		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		System.out.println("hospitalId=="+hospitalId);
		int userId = 0;
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		String[] bloodDetails=null;
		if(request.getParameterValues("blood")!=null ){
			bloodDetails=request.getParameterValues("blood");
		}
		String blood="";
		if(bloodDetails!=null && bloodDetails.length>0){
		for(String str:bloodDetails){
			blood=blood+","+str;
		}
		}
		int unitForBloodComponent=0;
		if(request.getParameter("unitForBloodComponent")!=null && !request.getParameter("unitForBloodComponent").equals("")){
			unitForBloodComponent=Integer.parseInt(request.getParameter("unitForBloodComponent"));
		}
		System.out.println(""+blood);
		mapForDS.put(USER_ID, userId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("box", box);
		box.put("blood",blood);
		box.put("unitForBloodComponent",unitForBloodComponent);

		try {
			boolean bool = otHandlerService
					.submitPreAnesthesiaDetails(mapForDS);
			if (bool) {
				map = otHandlerService.getPacClearanceList(mapForDS);
				System.out.println("orderNo"+box.getInt("orderNo"));
				System.out.println("hinId"+box.getInt("hinId"));
				System.out.println("pastHistory"+box.getInt("pastHistory"));
				System.out.println("presentHistory"+box.getInt("presentHistory"));
				System.out.println("drugTherapy"+box.getInt("drugTherapy"));
				map.put("orderNo", box.getInt("orderNo"));
				map.put("hinId", box.getInt("hinId"));
				map.put("pastHistory", box.getString("pastHistory"));
				map.put("presentHistory", box.getString("presentHistory"));
				map.put("drugTherapy", box.getString("drugTherapy"));
				jsp = OT_MSG_PAC_CLEARANCE;
				message = "PAC Form Completed Successfully!! Do you want to print?";

			} else {
				map = otHandlerService.getPacClearanceList(mapForDS);
				message = "Error occured!! Try Again ?";
				jsp = OT_PAC_CLEARANCE_LIST_JSP;
			}

			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {

			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);

		/*
		 * 
		 * Box box = HMSUtil.getBox(request); HttpSession session =
		 * request.getSession(); Map<String, Object> mapForDS = new
		 * HashMap<String, Object>(); // Map<String, Object> map = new
		 * HashMap<String, Object>();.
		 * 
		 * mapForDS.put("box", box);
		 * 
		 * try { boolean bool = otHandlerService
		 * .submitPreAnesthesiaDetails(mapForDS); if (bool) { map =
		 * otHandlerService.getPacClearanceList(mapForDS); map.put("orderNo",
		 * box.getInt("orderNo")); map.put("hinId", box.getInt("hinId")); //
		 * map.put("pastHistory", box.getString("pastHistory"));
		 * map.put("pastRecords", box.getString("pastHistory"));
		 * map.put("presentHistory", box.getString("presentHistory"));
		 * map.put("drugTherapy", box.getString("drugTreatment")); jsp =
		 * OT_MSG_PAC_CLEARANCE; message =
		 * "PAC Form Completed Successfully!! Do you want to print?";
		 * 
		 * } else { map = otHandlerService.getPacClearanceList(mapForDS);
		 * message = "Error occured!! Try Again ?"; jsp =
		 * OT_PAC_CLEARANCE_LIST_JSP; }
		 * 
		 * jsp += ".jsp"; map.put("message", message); map.put("contentJsp",
		 * jsp); map.put("title", title); } catch (RuntimeException e) {
		 * 
		 * e.printStackTrace(); }
		 * 
		 * return new ModelAndView("index", "map", map); // return null;
		 */

	}

	public ModelAndView showPacClearedListForOTBookingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
		jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOTBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int surgeryHdId = Integer.parseInt(request.getParameter("surgeryHdId"));
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		int deptId = 0;
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		
		int empId = 0;
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
		}
		String otType = "";
		if(request.getParameter("otType") != null && !request.getParameter("otType").equals("")) {
			otType = request.getParameter("otType");
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("surgeryHdId", surgeryHdId);
		mapForDS.put(DEPT_ID, deptId);
		mapForDS.put("empId", empId);

		map = otHandlerService.showOTBookingJsp(mapForDS);

		jsp = OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("otType", otType);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	public void displayOtTableForUnit(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OtMasUnitDay> otMasUnitDayList = new ArrayList<OtMasUnitDay>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			box.put("hospitalId", hospitalId);
		}
		int deptId = 0;
		if(request.getParameter("theaterId")!=null){
			deptId=Integer.valueOf(request.getParameter("theaterId"));
			box.put("deptId", deptId);
		}else if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
			box.put("deptId", deptId);
		}
		int unitId = 0;
		if (request.getParameter("unitId") != null) {
			unitId =Integer.parseInt(request.getParameter("unitId"));
			box.put("unitId", unitId);
		}
		map = otHandlerService.displayOtTableForUnit(box);
		if(map.get("otMasUnitDayList") != null){
			otMasUnitDayList = (List)map.get("otMasUnitDayList");
		}
		
		if(request.getParameter("fromtableWiseReport")!=null && request.getParameter("fromtableWiseReport").equalsIgnoreCase("yes")){
			List<String> tableList=new ArrayList<String>();
			if(otMasUnitDayList.size()>0){
				for(OtMasUnitDay otMasUnitDay : otMasUnitDayList){
					tableList.add(otMasUnitDay.getMasBed().getId()+":"+otMasUnitDay.getMasBed().getBedNo());
				}
			}
			try {
				response.getWriter().print(tableList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			StringBuffer sb = new StringBuffer();
			try {
					sb.append("<item>");
					sb.append("<tables>");
					for (OtMasUnitDay otMasUnitDay : otMasUnitDayList) {
						sb.append("<table>");
						sb.append("<tableId>" +otMasUnitDay.getMasBed().getId() + "</tableId>");
						sb.append("<tableNo>" + otMasUnitDay.getMasBed().getBedNo()
								+ "</tableNo>");
						sb.append("</table>");
					}
					sb.append("</tables>");

					// sb.append("<brands>");
					// for (MasStoreBrand brand : brandList) {
					// sb.append("<brand>");
					// sb.append("<brandId>" + brand.getId() + "</brandId>");
					// sb.append("<brandName>" + brand.getBrandName()
					// + "</brandName>");
					// sb.append("</brand>");
					// }
					// sb.append("</brands>");

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
		
	}
	
		
	
	//By Vishnu
	 public void fillMemberForName(HttpServletRequest request,HttpServletResponse response) {
         Map<String, Object> map = new HashMap<String, Object>();
         System.out.println("fillMemberForName");
         Map<String, Object> dataMap = new HashMap<String, Object>();
         HttpSession session = request.getSession();
         String nameMember = "";
         try {
        	 int hospitalId = 0;
 			if (session.getAttribute(HOSPITAL_ID) != null) {
 				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
 			}
 			dataMap.put(HOSPITAL_ID, hospitalId);
             if (request.getParameter("nameMember") != null) {
                 nameMember = request.getParameter("nameMember");
             }
         
             List<MasEmployee> eList = new ArrayList<MasEmployee>();
             
             dataMap.put("nameMember", nameMember);
             map =otHandlerService.fillMemberForName(dataMap);
         
             if (map.get("eList") != null) {
                 eList = (List) map.get("eList");
             }
             StringBuffer sb = new StringBuffer();
          if(eList.size()>0){
                 for (MasEmployee e : eList) {
                     sb.append("<item>");
                     sb.append("<nameMember>" + e.getFirstName() + "</nameMember>");
                     sb.append("<idMember>" + e.getId() + "</idMember>");
                     sb.append("<designation>");
                     if (e.getRank()!= null)
                     {
                         sb.append("<drt>");
                         System.out.println("e.getRank().getRankName()=="+e.getRank().getRankName());
                         sb.append("<dName>"+e.getRank().getRankName()+ "</dName>");
                    sb.append("</drt>");
                     }
                     else{
                         sb.append("<drt>");
                         sb.append("<dName>" + "NA" + "</dName>");
                         //sb.append("<designationId>" + "0" + "</designationId>");
                         sb.append("</drt>");
                     }
                     sb.append("</designation>");
                     sb.append("</item>");
                 }
                 }
             System.out.println("sb>>>>"+sb);
             response.setContentType("text/xml");
             response.setHeader("Cache-Control", "no-cache");

             response.getWriter().write("<?xml version='1.0' encoding='ISO-8859-1'?>");
             response.getWriter().write("<items>");
             response.getWriter().write(sb.toString());
             response.getWriter().write("</items>");
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


	@SuppressWarnings("unused")
	public ModelAndView getSurgeonListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String departmentIdField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			int hospitalId = 0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			map.put(HOSPITAL_ID, hospitalId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getSurgeonListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_SURGEON_LIST_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOTBookingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * String jsp = ""; Box box = HMSUtil.getBox(request); HttpSession
		 * session = request.getSession(); Map<String, Object> mapForDS = new
		 * HashMap<String, Object>(); Map<String, Object> map = new
		 * HashMap<String, Object>(); List empIdList = new ArrayList();
		 * mapForDS.put("box", box); String date = box.getString("surgeryDate");
		 * int deptId = Integer.parseInt(request. getParameter("deptId"));
		 * mapForDS.put("deptId", deptId); int hiddenValue = Integer.parseInt
		 * (request.getParameter ("hiddenValue")); for (int i = 1; i <=
		 * hiddenValue; i++) { String surgeonName = request.getParameter
		 * ("surgeonName" + i); if (!surgeonName.equals("")) { int index1 =
		 * surgeonName.indexOf("["); index1 = index1 + 1; int index2 =
		 * surgeonName.lastIndexOf("]"); String surgeonId =
		 * surgeonName.substring(index1, index2); int empId =
		 * Integer.parseInt(surgeonId); empIdList.add(empId); } }
		 * mapForDS.put("empIdList", empIdList); try { map = otHandlerService
		 * .submitOTBookingDetails (mapForDS); String succesfullyAdded =
		 * (String) map.get("succesfullyAdded"); String value = (String)
		 * map.get("value"); if (map.get("succesfullyAdded") != null) { if
		 * (succesfullyAdded.equalsIgnoreCase ("true")) { map = otHandlerService
		 * .showPACClearedListForOTBooking (mapForDS); message = value; } else {
		 * map = otHandlerService .showPACClearedListForOTBooking (mapForDS);
		 * message = value; } } else { map = otHandlerService.
		 * showPACClearedListForOTBooking (mapForDS); message =
		 * "Error In Submitting OT details." ;
		 * 
		 * } jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP ; jsp += ".jsp";
		 * map.put("message", message); map.put("contentJsp", jsp);
		 * map.put("title", title); } catch (RuntimeException e) {
		 * e.printStackTrace(); } return new ModelAndView("index", "map", map);
		 */

		String jsp = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List empIdList = new ArrayList();
		List<String> roleList = new ArrayList<String>();
		mapForDS.put("box", box);
		String date = box.getString("surgeryDate");
		// int deptId = Integer.parseInt(request.getParameter("deptId"));
		int deptId = (Integer) (session.getAttribute("deptId"));
		int hospitalId = 0;
		int userId = 0;
		String abscondRemark=null;
		String abscondPatient= null; 
		if (request.getParameter("abscondPatient") != null
				&& !request.getParameter("abscondPatient").equals("")) {
			abscondPatient = (String)request.getParameter("abscondPatient");
			if(abscondPatient!="False"){
				
				
				if (request.getParameter("abscondRemark") != null
						&& !request.getParameter("abscondRemark").equals("")) {
					    abscondRemark=(String)request.getParameter("abscondRemark");
					    
				    }
				}
			}
		mapForDS.put("abscondPatient",abscondPatient);	
		mapForDS.put("abscondRemark",abscondRemark);
		String cancelPatient=null;
		String cancelRemark=null;
		if (request.getParameter("cancelPatient") != null
				&& !request.getParameter("cancelPatient").equals("")) {
			cancelPatient = (String)request.getParameter("cancelPatient");
			if(cancelPatient!="False"){
				if (request.getParameter("cancelRemark") != null
						&& !request.getParameter("cancelRemark").equals("")) {
					         cancelRemark=(String)request.getParameter("cancelRemark");    
				    }
				}
			}
		mapForDS.put("cancelPatient",cancelPatient);
		mapForDS.put("cancelRemark",cancelRemark);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}

		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		int bookedById = 0;
		if (session.getAttribute("empId") != null) {
			bookedById = (Integer) session.getAttribute("empId");
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put(USER_ID, userId);
		mapForDS.put("deptId", deptId);
		box.put("bookedById", bookedById);
		int hiddenValue = 0;
		if (request.getParameter("hiddenValue") != null
				&& !request.getParameter("hiddenValue").equals("")) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		for (int i = 1; i <= hiddenValue; i++) {
			String surgeonName = request.getParameter("surgeonName" + i);
			if (!surgeonName.equals("")) {
				int index1 = surgeonName.indexOf("[");
				index1 = index1 + 1;
				int index2 = surgeonName.lastIndexOf("]");
				String surgeonId = surgeonName.substring(index1, index2);
				int empId = Integer.parseInt(surgeonId);
				empIdList.add(empId);
			}
			String role = request.getParameter("role" + i);
			if (!role.equals("")) {
				roleList.add(role);
			} else {
				roleList.add("0");
			}
			
		}
		mapForDS.put("empIdList", empIdList);
		mapForDS.put("roleList", roleList);
		try {
			map = otHandlerService.submitOTBookingDetails(mapForDS);
			String succesfullyAdded = (String) map.get("succesfullyAdded");
			String value = (String) map.get("value");
			if (map.get("succesfullyAdded") != null) {
				if (succesfullyAdded.equalsIgnoreCase("true")) {
					map = otHandlerService
							.showPACClearedListForOTBooking(mapForDS);
					message = value;
				} else {
					map = otHandlerService
							.showPACClearedListForOTBooking(mapForDS);
					message = value;
				}
			} else {
				map = otHandlerService.showPACClearedListForOTBooking(mapForDS);
				message = "Error In Submitting OT details.";

			}
			//map = otHandlerService.showWaitingListForSurgery(mapForDS);

			jsp = "waiting_list_for_surgery";
			jsp += ".jsp";
			/*jsp = OT_PAC_CLEARED_LIST_FOR_OT_BOOKING_JSP;
			jsp += ".jsp";*/
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView showOTPatientSearchForDisposalJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showHumanBodyPartsDisposalJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		mapForDS.put("hinNo", hinNo);
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		mapForDS.put("bookingId", bookingId);
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);
//		int hinId = Integer.parseInt(request.getParameter("hinId"));
//		mapForDS.put("hinId", hinId);
		try {

			if (request.getParameter("flag") != null) {
				if (request.getParameter("flag").equals("existingRecord")) {
					int entryNo = Integer.parseInt(request
							.getParameter("entryNo"));
					mapForDS.put("entryNo", entryNo);
					map = otHandlerService
							.searchHumanBodyPartsDisposal(mapForDS);
				}
			} else {
				map = otHandlerService.showHumanBodyPartsDisposalJsp(mapForDS);
			}

			jsp = OT_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView searchPatientDetailsForDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hospitalId=0;

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			/*
			 * if (request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
			 * serviceNo); }
			 */
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			mapForDS.put(HOSPITAL_ID, hospitalId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService.searchPatientDetailsForDisposal(mapForDS);
		String jsp = "";
		jsp = OT_PATIENT_SEARCH_FOR_DISPOSAL_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitHumanBodyPartsDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		String message = "";
		int entryNo = 0;
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		int userId=(Integer)session.getAttribute(USER_ID);
		mapForDS.put(USER_ID, userId);
		if (request.getParameter("entryNo") != null
				&& !request.getParameter("entryNo").equals("")) {
			entryNo = Integer.parseInt(request.getParameter("entryNo"));
		}
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("box", box);
		try {
			boolean bool = otHandlerService
					.submitHumanBodyPartsDisposal(mapForDS);
			if (bool) {
				message = "Human Body Parts Disposal Submitted Successfully!! Do you want to print?";
			} else {
				message = "Error Ocurred!! Try Again !!";
			}
			String jsp = OT_MSG_HUMAN_BODY_DISPOSAL;
			jsp += ".jsp";
			map.put("entryNo", entryNo);
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchHumanBodyPartsDisposal(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = OT_SEARCH_HUMAN_BODY_PARTS_DISPOSAL_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getHinNoList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";

		try {
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
			List<Object> hinNoList = new ArrayList<Object>();
			List<Object> entryNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("hin")) {
				hinNoList = otHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);
				jsp = OT_GET_HIN_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			}
			if (flag.equals("entry")) {
				mapForDS.put("hinNo", hinNo);
				map = otHandlerService
						.getEntryNoListForHumanBodyPartsDisposal(mapForDS);
				jsp = OT_GET_ENTRY_NO_FOR_HUMAN_BODY_PARTS_DISPOSAL_JSP;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("message", message);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showEmergencyOTBookingPatientSearch(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView searchPatientDetailsForEmergencyOTBooking(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			/*
			 * if (request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
			 * serviceNo); }
			 */
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService
				.searchPatientDetailsForEmergencyOTBooking(mapForDS);
		String jsp = "";
		jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showEmergencyOTBookingJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		mapForDS.put("hinId", hinId);
		mapForDS.put("deptId", deptId);

		map = otHandlerService.showEmergencyOTBookingJsp(mapForDS);

		jsp = OT_EMERGENCY_OT_BOOKING_JSP;
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("deptId", deptId);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	public ModelAndView submitEmergencyOTBookingDetails(
			HttpServletRequest request, HttpServletResponse response) {
		String jsp = "";
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		List empIdList = new ArrayList();
		mapForDS.put("box", box);
		String date = box.getString("surgeryDate");
		int deptId = Integer.parseInt(request.getParameter("deptId"));
		mapForDS.put("deptId", deptId);
		int hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		for (int i = 1; i <= hiddenValue; i++) {
			String surgeonName = request.getParameter("surgeonName" + i);
			if (!surgeonName.equals("")) {
				int index1 = surgeonName.indexOf("[");
				index1 = index1 + 1;
				int index2 = surgeonName.lastIndexOf("]");
				String surgeonId = surgeonName.substring(index1, index2);
				int empId = Integer.parseInt(surgeonId);
				empIdList.add(empId);
			}
		}
		mapForDS.put("empIdList", empIdList);
		try {
			boolean succesfullyAdded = otHandlerService
					.submitEmergencyOTBookingDetails(mapForDS);
			if (succesfullyAdded) {
				message = "OT Booked For the Patient.";
			} else {
				message = "OT is Not booked For the patient.";

			}

			jsp = OT_PATIENT_SEARCH_FOR_EMERGENCY_OT_BOOKING_JSP;
			jsp += ".jsp";
			map.put("message", message);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		return new ModelAndView("index", "map", map);
	}

	// ---------------------methods changed by
	// vikas-----------------------------------
	/**
	 * ----- Priyanka Garg--------------OT List Change-------------
	 */

	public ModelAndView showOTListChangeJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView getOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		mapForDS.put("deptId", deptId);
		String bookingDate = new String();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("bookingDate") != null) {
			bookingDate = request.getParameter("bookingDate");
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("bookingDate", bookingDate);
		map = otHandlerService.getOTSchedule(mapForDS);

		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}

	public ModelAndView changeOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String bookingDate = new String();
		map.put(HOSPITAL_ID, hospitalId);
		map.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		map.put("bookingId", bookingId);
		map.put("bookingDate", bookingDate);
		map = otHandlerService.changeOTSchedule(map);
		jsp = "otListChangeSub";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView updateOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String bookingDate = new String();
		box.put(HOSPITAL_ID, hospitalId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		map.put("bookingId", bookingId);
		map.put("bookingDate", bookingDate);
		map = otHandlerService.updateOTSchedule(box);
		boolean dataSaved = false;
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}

		if (dataSaved == true) {
			map.put("message", "Data Updated Successfully");
		}
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView cancelOTSchedule(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Box box = HMSUtil.getBox(request);
		int bookingId = 0;
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		String bookingDate = new String();
		box.put(HOSPITAL_ID, hospitalId);
		map.put(HOSPITAL_ID, hospitalId);
		map.put("deptId", deptId);
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
			box.put("bookingId", bookingId);
		}
		if (request.getParameter("date") != null) {
			bookingDate = request.getParameter("date");
		}
		map = otHandlerService.cancelOTSchedule(box);
		boolean dataSaved = false;
		if (map.get("dataSaved") != null) {
			dataSaved = (Boolean) map.get("dataSaved");
		}
		if (dataSaved == true) {
			map.put("message", "Data Updated Successfully");
		}
		jsp = "otListChange";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	/**
	 * -------------------------- PRE- ANAESTHESIA NOTES ENTRY PROCEDURE
	 * ----------------------
	 */

	public ModelAndView showOtPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
        String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		 String otProcedure = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			 
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			 if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
				mapForDS.put("otProcedure", otProcedure);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			mapForDS.put(HIN_NO, request.getParameter("uhid"));
		}
		
		if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
		}
		
		if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
		{
			mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
		}
		
		if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
		{
			mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
		}
		//mapForDS.put("box", HMSUtil.getBox(request));
		patientMap = otHandlerService.searchOtPatientDetails(mapForDS);

		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearch" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = "";
		if (request.getParameter("hinNo") != null) {
			hinNo = request.getParameter("hinNo");
		}
		int surgeryHdId = Integer.parseInt(request.getParameter("surgeryHdId"));
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}

		mapForDS.put("hinNo", hinNo);
		mapForDS.put("surgeryHdId", surgeryHdId);
		mapForDS.put(HOSPITAL_ID, hospitalId);


		try {
			map = otHandlerService.showOtProcedureNotesEntryJsp(mapForDS);
			jsp = "OT_ProcedureNotesEntry";

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getStoreItemForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String itemNameField = "";
		String autoHint = "";
		int hospitalid = 0;
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalid = (Integer) session.getAttribute(HOSPITAL_ID);
			}

			map.put(HOSPITAL_ID, hospitalid);
			map.put("autoHint", autoHint);
			map = otHandlerService.getStoreItemForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ot_responseForPvmsNo";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView fillStoreItem(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		String rowVal = request.getParameter("rowVal");
		String itemNameWithId = request.getParameter("itemName" + rowVal);
		int index1 = itemNameWithId.lastIndexOf("[");
		int index2 = itemNameWithId.lastIndexOf("]");

		String storeItem = itemNameWithId.substring(0, index1);
		map = otHandlerService.getNomenclature(storeItem);
		jsp = "ot_responseForStoreItem";

		title = "Store Item Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitPreAneaesthesiaProcNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		String hinNo = request.getParameter("hinNo");
		String otProcedure = null;
		int hospitalId = 0;
		int userId = 0;
		String yearlySerialNo = "";
		String[] pvmsNoId = request.getParameterValues("pvmsNoId");
		List<Integer> pvmsNoList = new ArrayList<Integer>();
		boolean dataSaved = false;
       if(pvmsNoId!=null && pvmsNoId.length>0){
    	   for (int i = 0; i < pvmsNoId.length; i++) {
   			int pvmsNo = Integer.parseInt(pvmsNoId[i]);
   			pvmsNoList.add(pvmsNo);
   		}  
       }
		
		if (request.getParameter("otProcedure") != null
				&& !(request.getParameter("otProcedure").equals(""))) {
			otProcedure = request.getParameter("otProcedure");
		}

		if (request.getParameter("yearlySqNo") != null) {
			yearlySerialNo = request.getParameter("yearlySqNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		if (session.getAttribute(LOGIN_NAME) != null) {
			userName = (String) session.getAttribute(LOGIN_NAME);
			mapForDS.put("userName", userName);
		}
		mapForDS.put("hinNo", hinNo);
		Box box = HMSUtil.getBox(request);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(USER_ID) != null) {
			userId = (Integer) session.getAttribute(USER_ID);
		}
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
		try {
			map = otHandlerService.submitPreAneaesthesiaProcNotesEntryJsp(box,
					pvmsNoList);
			map.put("otProcedure", "no");
			if (map.get("dataSaved") != null) {
				dataSaved = (Boolean) map.get("dataSaved");
			}
			if (dataSaved == true) {
				message = "Data Saved Sucessfully!! Do you want to print?";
				map.put("message", message);
			}
			jsp = OT_MSG_PRE_ANESTHESIA;
			jsp += ".jsp";
			map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ------------------------------- OT PROCEDURE NOTES ENTRY
	 * --------------------
	 */
	public ModelAndView showPreAneaesthesiaProcNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
	    Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bookingId = Integer.parseInt(request.getParameter("surgeryHdId"));
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		 
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("bookingId", bookingId);
		try {
			map = otHandlerService
					.showPreAneaesthesiaProcNotesEntryJsp(mapForDS);
			jsp = "OT_preAnaesthesiaProcedureNotesEntry";

			jsp += ".jsp";
		 
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getEmpNameForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
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
			map = otHandlerService.getEmpNameForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ot_responseForEmployee";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView submitOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		String YearlySrNo="";
		int count = Integer.parseInt(request.getParameter("hiddenValue"));
		int hinId = Integer.parseInt(request.getParameter("hinId1"));
		String consultationDate = request.getParameter("consultationDate");
		String consultationTime = request.getParameter("consultationTime");
		List<Integer> employeeId = new ArrayList<Integer>();
		String employeeName = null;
		String otProcedure = null;
		boolean dataSaved = false;

		for (int i = 1; i <= count; i++) {
			if (request.getParameter("empName" + i) != null
					&& !request.getParameter("empName" + i).equals("")) {
				int start = 0;
				int end = 0;
				employeeName = request.getParameter("empName" + i);
				start = employeeName.lastIndexOf("[");
				end = employeeName.lastIndexOf("]");
				employeeId.add(Integer.parseInt(employeeName.substring(
						start + 1, end)));
			}
		}

		if (request.getParameter("otProcedure") != null
				&& !(request.getParameter("otProcedure").equals(""))) {
			otProcedure = request.getParameter("otProcedure");
		}
		Box box = HMSUtil.getBox(request);
		box.put(HOSPITAL_ID, hospitalId);
		box.put(USER_ID, userId);
        	String ipNo="";
		String wardName="";
		if(box.getString("ipNo")!=null&&box.getString("ipNo")!=""){
			ipNo=box.getString("ipNo");
	}
		if(box.getString("wardName")!=null&&box.getString("wardName")!=""){
			wardName=box.getString("wardName");
		}		
		//Added By Awadhesh 
		/* Prescription grid: start*/
		List<String> pvmsNoList = new ArrayList<String>();
		List<String> manufacturerList=new ArrayList<String>();
		List<String> manufacturerIdList=new ArrayList<String>();
		List<String> brandIdList=new ArrayList<String>();

		List<Integer> parkPrescriptionIds = new ArrayList<Integer>();
		List<Integer> frequencyList = new ArrayList<Integer>();
		List<Float> dosageList = new ArrayList<Float>();
		List<Float> totalList = new ArrayList<Float>();
		List<Float> actualTotalAfterMixList = new ArrayList<Float>(); //added by amit das on 19-11-2016
		List<Integer> noOfDaysList = new ArrayList<Integer>();
		List<Integer> routes = new ArrayList<Integer>();
		List<Integer> instrunctionList = new ArrayList<Integer>();
		List<String> spLinstrunctionList = new ArrayList<String>();
		
		List<Date> startDates = new ArrayList<Date>();
		List<Date> endDates = new ArrayList<Date>();
		List<String> dpStatus = new ArrayList<String>();
		List<String> durationPrescriptionList = new ArrayList<String>();
		List<String> prescription_availableStatusList = new ArrayList<String>();
		String prescription_availableStatus="";
		
		Integer surgeryId = 0;
		if (null !=request.getParameter("surgeryId") && Integer.parseInt(request.getParameter("surgeryId")) >= 0) {
			surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
		}
		Integer pHeaderId = 0;
		if (null !=request.getParameter("pHeaderId") && Integer.parseInt(request.getParameter("pHeaderId")) >= 0) {
			pHeaderId = Integer.parseInt(request.getParameter("pHeaderId"));
		}
		int hdb = 0;
		if (null !=request.getParameter("OtTabhdb") && Integer.parseInt(request.getParameter("OtTabhdb")) >= 0) {
			hdb = Integer.parseInt(request.getParameter("OtTabhdb"));
		}
		String[] pvmsArr = new String[hdb+1];
		int j = 0;
		StringBuffer parkPrescriptions=new StringBuffer();
		for (int i = 0; i <=hdb; i++)  {
			if (request.getParameter("nomenclatureOtTab" + j)!=null && !request.getParameter("nomenclatureOtTab" + j).equals("")) {

				String nomenclature = request.getParameter("nomenclatureOtTab" + j);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsArr[i] = nomenclature.substring(index1,	index2);
				parkPrescriptions.append(nomenclature.substring(0, index1-1)+"|");
				String pvmsNo=null;
                if(request.getParameter("pvmsNoOtTab"+j)!=null)
                {
                	pvmsNo = request.getParameter("pvmsNoOtTab"+j);

                }
                
               /* String durationPrescription=null;
        		if(request.getParameter("durationPrescriptionTab"+j)!=null){
        			durationPrescription = request.getParameter("durationPrescriptionTab"+j);
        			durationPrescriptionList.add(durationPrescription);
        		}*/
        	
                
                
                int parkPrescriptionId=0;
		 		if(request.getParameter("parkPrescriptionOtIds"+ j)!=null && !request.getParameter("parkPrescriptionOtIds"+ j).equals("")){
		 			parkPrescriptionId = Integer.parseInt(request.getParameter("parkPrescriptionOtIds"+ j));
		 		}
                
				int frequencyId=0;
		 		if(request.getParameter("frequencyOtTab"+ j)!=null && !request.getParameter("frequencyOtTab"+ j).equals("")){
		 			frequencyId = Integer.parseInt(request.getParameter("frequencyOtTab"+ j));
		 		}
				
		 		int noOfDays=0;
		 		if(request.getParameter("noOfDaysOtTab"+ j)!=null && !request.getParameter("noOfDaysOtTab"+ j).equals("")){
		 			noOfDays = Integer.parseInt(request.getParameter("noOfDaysOtTab"+ j));
		 		}
		 		Float dosage=0.0f;
		 		if(request.getParameter("dosageOtTab" + j)!=null && !request.getParameter("dosageOtTab" + j).equals("")){
		 			dosage = Float.valueOf(request.getParameter("dosageOtTab" + j));
		 		}
		 		
		 		Integer instrunction=0;
		 		if(request.getParameter("instrunctionOtTab" + j)!=null && !request.getParameter("instrunctionOtTab" + j).equals("")){
		 			instrunction = Integer.parseInt(request.getParameter("instrunctionOtTab" + j));
		 		}
		 		String splInstrunctionpTab="";
		 		if(request.getParameter("splInstrunctionOtTab" + j)!=null && !request.getParameter("splInstrunctionOtTab" + j).equals("")){
		 			splInstrunctionpTab = request.getParameter("splInstrunctionOtTab" + j);
		 		}
		 		
		 		Integer route=0;
		 		if(request.getParameter("routeOtTab" + j)!=null && !request.getParameter("routeOtTab" + j).equals("")){
		 			route = Integer.parseInt(request.getParameter("routeOtTab" + j));
		 		}
		 		
		 		// added by amit das on 19-11-2016
		 		float actualTotalAfterMix=0.0f;
		 		if(request.getParameter("mixable" + j)!=null && request.getParameter("mixable" + j).equalsIgnoreCase("Y")){
		 			
		 			if(request.getParameter("actualTotalAfterMix" + j)!=null && !request.getParameter("actualTotalAfterMix" + j).equals("")){
		 				actualTotalAfterMix = Float.parseFloat(request.getParameter("actualTotalAfterMix" + j));
			 		}
		 			
		 		}
		 		
		 		float total=0.0f;
		 		if(request.getParameter("totalOtTab" + j)!=null && !request.getParameter("totalOtTab" + j).equals("")){
		 			total = Float.parseFloat(request.getParameter("totalOtTab" + j));
		 		}
		 		
		 		
		 		
		 		
		 		
		 		Date startDate=new Date();
		 		Date endDate=new Date();
	 			if(request.getParameter("startDate" + j)!=null && !request.getParameter("startDate" + j).equals("")){
		 			startDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("startDate" + j));
		 		}
	 			if(request.getParameter("endDate" + j)!=null && !request.getParameter("endDate" + j).equals("")){
		 			endDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("endDate" + j));
		 		}
	 			
	 			if(request.getParameter("prescription_availableStatusOtTab" + j)!=null && !request.getParameter("prescription_availableStatusOtTab" + j).equals("")){
	 				prescription_availableStatus = request.getParameter("prescription_availableStatusOtTab" + j);
		 		}else{
		 			prescription_availableStatus = null;
		 		}
	 			prescription_availableStatusList.add(prescription_availableStatus);
	 			parkPrescriptionIds.add(parkPrescriptionId);
				pvmsNoList.add(pvmsArr[i]);
				frequencyList.add(frequencyId);
				dosageList.add(dosage);
				actualTotalAfterMixList.add(actualTotalAfterMix); // added by amit das in 19-11-2016
				totalList.add(total);
				noOfDaysList.add(noOfDays);
				
				spLinstrunctionList.add(splInstrunctionpTab);
				instrunctionList.add(instrunction);
				routes.add(route);
				startDates.add(startDate);
				endDates.add(endDate);
			}
			j++;
		}
		
		int taperHdb=0;
		if (null !=request.getParameter("taperedMedicineHdb") && Integer.parseInt(request.getParameter("taperedMedicineHdb")) >= 0) {
			taperHdb = Integer.parseInt(request.getParameter("taperedMedicineHdb"));
		}
		//added by govind 31-10-2017
				System.out.println("taperHdb---"+taperHdb);
				List<TaperedMedicineUtil> taperUtilList=new ArrayList<TaperedMedicineUtil>();
				for (int i = 0; i <=hdb; i++)  {
				Integer itemId =0;//System.out.println("i "+i);
				if (request.getParameter("nomenclatureOtTab" + i)!=null && !request.getParameter("nomenclatureOtTab" + i).equals("")) {

					 String nomencls = request.getParameter("nomenclatureOtTab" + i);
					 System.out.println("nomencls "+nomencls);
					 int index1 = nomencls.lastIndexOf("(");
						int index2 = nomencls.lastIndexOf(")");
						if(index1>=0 ){
							index1++;
							itemId = Integer.parseInt(nomencls.substring(index1,index2));
						}
							for(int t=1;t<=taperHdb;t++){//System.out.println("taperHdb "+taperHdb+" t "+t);
									if(box.get("taperedItemId"+i+"_"+t)!=null){
										Integer itemId2=box.getInt("taperedItemId"+i+"_"+t);//System.out.println("itemId2 "+itemId2);
									if(itemId.equals(itemId2)){
										TaperedMedicineUtil tap=new TaperedMedicineUtil();
										tap.setItemId(box.getInt("taperedItemId"+i+"_"+t));
									if(box.get("taperedFrequency"+i+"_"+t)!=null){
										tap.setFrequency(box.getInt("taperedFrequency"+i+"_"+t));
									}
									if(box.get("taperedDosage"+i+"_"+t)!=null){
										tap.setDosage(box.getString("taperedDosage"+i+"_"+t));
									}
									if(box.get("taperedDosageCount"+i+"_"+t)!=null){
										tap.setDosageCount(new BigDecimal(box.getString("taperedDosageCount"+i+"_"+t)));
									}
									if(box.get("taperedDuration"+i+"_"+t)!=null){
										tap.setDuration(box.getInt("taperedDuration"+i+"_"+t));
									}
									if(box.get("total"+i+"_"+t)!=null){
										tap.setTotal(new BigDecimal(box.getString("total"+i+"_"+t)));
									}
									taperUtilList.add(tap);
								  }
								}
							}
						}
				}
				System.out.println("taperUtilList------"+taperUtilList.size());
				mapForDS.put("taperUtilList", taperUtilList);
				//added by govind 31-10-2017 end
		mapForDS.put("consultationDate", consultationDate);
		mapForDS.put("consultationTime", consultationTime);
		mapForDS.put("prescriptionNo", generatePrecriptionNo(hinId));
		mapForDS.put("durationPrescriptionList",durationPrescriptionList);
		mapForDS.put("prescription_availableStatusList", prescription_availableStatusList);
		mapForDS.put("pHeaderId", pHeaderId);
		mapForDS.put("parkPrescriptionIds", parkPrescriptionIds);
		mapForDS.put("parkPrescriptions", parkPrescriptions);
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("manufacturerList", manufacturerList);
		mapForDS.put("manufacturerIdList", manufacturerIdList);
		mapForDS.put("brandIdList", brandIdList);

		mapForDS.put("frequencyList", frequencyList);
		mapForDS.put("dosageList", dosageList);
 		mapForDS.put("noOfDaysList", noOfDaysList);
		mapForDS.put("routes", routes);
		mapForDS.put("instrunctionsList", instrunctionList);
		mapForDS.put("spLinstrunctionList", spLinstrunctionList);
		mapForDS.put("totalList", totalList);
		mapForDS.put("actualTotalAfterMixList", actualTotalAfterMixList); // added by amit das in 19-11-2016
		mapForDS.put("startDatesList", startDates);
		mapForDS.put("endDatesList", endDates);
		mapForDS.put("dpStatusList", dpStatus);
		mapForDS.put("surgeryId", surgeryId);
		/* Prescription grid: end*/

		try {
			/*map = otHandlerService.submitOtProcedureNotesEntryJsp(box,
					employeeId);*/
			map = otHandlerService.submitOtProcedureNotesEntryJsp(box,
					employeeId,mapForDS);
			if (map.get("dataSaved") != null) {
				dataSaved = (Boolean) map.get("dataSaved");
			}
			if (map.get("YearlySrNo") != null) {
				YearlySrNo = (String) map.get("YearlySrNo");
			}
			if (dataSaved == true) {
				message = "OT Procedure Notes Entry Saved Sucessfully!!";
				map.put("message", message);
			}
			jsp = OT_MSG_OT_PROCEDURE;

			jsp += ".jsp";
			map.put("ipNumber", ipNo);
			map.put("wardName", wardName);
			map.put("deptId", deptId);
			map.put("YearlySrNo", YearlySrNo);
			map.put("otProcedure", otProcedure);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	
	public String generatePrecriptionNo(int hinId) {
		String precriptionNo = "";
		try {

			precriptionNo = otHandlerService.generatePrecriptionNo(hinId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return precriptionNo;
	}

	public ModelAndView searchOtProcedureNotes(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "ot_procedureNotesSearch" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getOtProcedureDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String yearlyNo = "";
		try {
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
			if (request.getParameter("yearlySerialNo") != null
					&& !(request.getParameter("yearlySerialNo").equals(""))) {
				yearlyNo = request.getParameter("yearlySerialNo");
				detailsMap.put("yearlySerialNo", yearlyNo);
			}
			List<Object> yearlySerialNoList = new ArrayList<Object>();
			List<String> hinNoList = new ArrayList<String>();
			List<Object> patientDetailList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("yearlySerialNo")) {
				yearlySerialNoList = otHandlerService
						.getYearlySerialNoList(detailsMap);
				map.put("yearlySerialNoList", yearlySerialNoList);
				jsp = "ot_responseForYearlySerialNo";

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getOtProcHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "ot_responseForProcHinNo";

			} else if (flag.equals("patientDetail")) {
				patientDetailList = otHandlerService
						.getOtProcPatientDetailList(detailsMap);
				map.put("patientDetailList", patientDetailList);

				jsp = "ot_responseForPatientDetails";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	public ModelAndView searchPreAnaesthesiaProcedureNotes(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "ot_PreAnaesthesiaProcedureNotesSearch" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView getPreAnaesthesiaProcedureDetails(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		String yearlyNo = "";
		try {
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
			if (request.getParameter("yearlySerialNo") != null
					&& !(request.getParameter("yearlySerialNo").equals(""))) {
				yearlyNo = request.getParameter("yearlySerialNo");
				detailsMap.put("yearlySerialNo", yearlyNo);
			}
			List<Object> yearlySerialNoList = new ArrayList<Object>();
			List<String> hinNoList = new ArrayList<String>();
			List<Object> patientDetailList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("yearlySerialNo")) {
				yearlySerialNoList = otHandlerService
						.getPreAnaesthesiaYearlySerialNoList(detailsMap);
				map.put("yearlySerialNoList", yearlySerialNoList);
				jsp = "ot_responseForPreAnasesthesiaYearlySerialNo";

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService
						.getPreAnaesthesiaHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = "ot_responseForPreAnasesthesiaProcHinNo";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);

	}

	/*
	 * ------------------------------------------------ Post Anaesthesia
	 * Patient---------------------------
	 */
	public ModelAndView showOtPostAnaesthesiaPatientSearchJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		map.put(HOSPITAL_ID, hospitalId);
		
		if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			map.put(HIN_NO, request.getParameter("uhid"));
		}
		
		if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
		{
			map.put(PATIENT_NAME, request.getParameter("pname"));
		}
		
		if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
		{
			map.put(RequestConstants.AD_NO, request.getParameter("ipno"));
		}
		
		if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
		{
			map.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
		}

		patientMap = otHandlerService.searchPostAnaesthesiaPatientDetails(map);

		String jsp = OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("patientMap", patientMap);
		return new ModelAndView("index", "map", map);
	}

	 
	public ModelAndView showPostAnaesthesiaPatientDetails(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			/*
			 * if (request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
			 * serviceNo); }
			 */

			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		patientMap = otHandlerService
				.searchPostAnaesthesiaPatientDetails(mapForDS);
		String jsp = "";
		jsp = OT_POST_ANAESTHESIA_PATIENT_SEARCH_JSP + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showPostAnaesthesiaJspFromPatientList(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		//System.out.println(">>>>"+request.getParameter("bookingId"));
		int otBookId = Integer.parseInt(request.getParameter("bookingId"));
		String orderNo = request.getParameter("orderNo");
		String yearlySrNo = "";
		String monthlySrNo = "";
		List<OtBooking> patientDetailList = new ArrayList<OtBooking>();
		int hin = 0;
		String chargeCode = "";
		mapForDS.put("hinNo", hinNo);
		mapForDS.put("otBookId", otBookId);
		mapForDS.put("orderNo", orderNo);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		try {
			map = otHandlerService.showPostAnaesthesiaJspForHin(mapForDS);
			patientDetailList = (List<OtBooking>) map.get("patientDetailList");
			if (patientDetailList.size() > 0) {
				hin = patientDetailList.get(0).getHin().getId();
				if(patientDetailList.get(0).getSurgery() != null) {
					chargeCode = patientDetailList.get(0).getSurgery()
						.getChargeCode().getChargeCodeCode();
				}
				map1 = otHandlerService.getChargeCodeDetailsForOT(chargeCode,
						hin);

			}
			yearlySrNo = otHandlerService.getYearlySeqForDisplay();
			if (yearlySrNo != null) {
				map.put("yearlySrNo", yearlySrNo);
			}

			monthlySrNo = otHandlerService.getMonthlySeqForDisplay();

			if (monthlySrNo != null) {
				map.put("monthlySrNo", monthlySrNo);
			}
			jsp = OT_POST_ANAESTHESIA_FOR_INPATIENT_JSP;
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("map1", map1);
			map.put("title", title);
		} catch (RuntimeException e) {

			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView showPACDetailJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int visitId = 0;
		int inpatientId = 0;
		if (request.getParameter("visitId") != null) {

			visitId = Integer.parseInt(request.getParameter("visitId"));
			map = otHandlerService.showPACDetailJsp(orderNo, hinId, visitId);
			map.put("visitId", visitId);
		} else if (request.getParameter("inpatientId") != null) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			map = otHandlerService.showPACDetailInJsp(orderNo, hinId,
					inpatientId);
			map.put("inpatientId", inpatientId);
		} else if (request.getParameter("visitId") == null
				&& request.getParameter("inpatientId") == null) {
			map = otHandlerService.showPACDetailHnJsp(orderNo, hinId);
			map.put("hinid", hinId);
		}
		jsp = "pacDetail";
		title = "PAC List";
		map.put("orderNo", orderNo);
		map.put("hinId", hinId);

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView fillChargeCode(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String chargeCodeNameWithId = request.getParameter("chargeCodeName"
				+ rowVal);
		int index1 = chargeCodeNameWithId.lastIndexOf("[");
		int index2 = chargeCodeNameWithId.lastIndexOf("]");

		String chargeCodeName = chargeCodeNameWithId.substring(0, index1);
		map = otHandlerService.getChargeCodeValue(chargeCodeName);

		jsp = OT_RESPONSE_FOR_CHARGE_CODE_NAME_JSP;

		title = "Patient Surgey Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView getSurgeyForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
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
			map = otHandlerService.getSurgeyForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEY_JSP;
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView fillEmpNameAnesthesiologist(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empName" + rowVal);
		// int index1 = empNameWithId.lastIndexOf("[");
		// int index2 = empNameWithId.lastIndexOf("]");

		// String empName = empNameWithId.substring(0, index1);

		int index1 = empNameWithId.indexOf("[");
		index1 = index1 + 1;
		int index2 = empNameWithId.lastIndexOf("]");
		String anasthId = empNameWithId.substring(index1, index2);
		int empId = Integer.parseInt(anasthId);

		mapForDS.put("empId", empId);
		map = otHandlerService.getEmpValue(mapForDS);
		jsp = OT_RESPONSE_FOR_EMP_NAME_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView fillEmpNameSergon(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String rowVal = request.getParameter("rowVal");
		String empNameWithId = request.getParameter("empNameS" + rowVal);
		// int index1 = empNameWithId.lastIndexOf("[");
		// int index2 = empNameWithId.lastIndexOf("]");

		// String empName = empNameWithId.substring(0, index1);

		int index1 = empNameWithId.indexOf("[");
		index1 = index1 + 1;
		int index2 = empNameWithId.lastIndexOf("]");
		String anasthId = empNameWithId.substring(index1, index2);
		int empId = Integer.parseInt(anasthId);

		mapForDS.put("empId", empId);
		map = otHandlerService.getEmpValue(mapForDS);
		jsp = OT_RESPONSE_FOR_EMP_NAME_JSP;

		title = "Patient Surgeon Details";
		map.put("rowVal", rowVal);
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);

	}

	@SuppressWarnings("unused")
	public ModelAndView getAnesthesiologistForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
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
			map = otHandlerService.getSurgeonForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEON_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	/*
	 * @SuppressWarnings("unused") public ModelAndView
	 * fillEmpNameSergon(HttpServletRequest request, HttpServletResponse
	 * response) {
	 * 
	 * HttpSession session = request.getSession(); String rowVal =
	 * request.getParameter("rowVal"); String empNameWithId =
	 * request.getParameter("empNameS" + rowVal);
	 * 
	 * int index1 = empNameWithId.lastIndexOf("["); int index2 =
	 * empNameWithId.lastIndexOf("]");
	 * 
	 * String empName = empNameWithId.substring(0, index1); map =
	 * otHandlerService.getEmpValue(empName);
	 * 
	 * jsp = OT_RESPONSE_FOR_EMP_NAME_JSP;
	 * 
	 * title = "Patient Surgeon Details"; map.put("rowVal", rowVal);
	 * map.put("contentJsp", jsp); map.put("title", title); return new
	 * ModelAndView(jsp, "map", map); }
	 */
	@SuppressWarnings("unused")
	public ModelAndView getSergonForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
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
			map = otHandlerService.getSurgeonForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OPD_RESPONSE_FOR_SURGEON_JSP;

		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		patientMap.put("hospitalId",hospitalId);
		int userId = (Integer) session.getAttribute(USER_ID);
		int anesthesia_id = 0;
		String dateOfPost = "";
		String yearlySlNo = "";
		String monthlySlNo = "";
		String surgey_from_time = "";
		String surgey_to_time = "";
		String asa_grade_details = "";
		String anaesthesia_from_time = "";
		String anaesthesia_to_time = "";
		String ett_lma = "";
		int ett_lma_text = 0;
		String userName = null;
		String ecg = null;
		String nibp = null;
		String cvp = null;
		String temp = null;
		String sp02 = null;
		String labp = null;
		boolean submitData = false;
		String uo = "";
		int neostigmine = 0;
		int glycophyrrolate = 0;
		int others = 0;
		String recovery = "";
		String risk_grade = "";
		String e_others = "";
		String levelOfAnesthesia="";
		int height=0;
		int weight=0;
		String bmi="";
		String bmiStatus="";
		String pulse="";
		String bp="";
		String resp="";
		String remarks = "";
		String[] careOf=null;
		String patientStatus = "";
		int inpatientId = 0;
		int VisitId = 0;
		int otBookingId = 0;
		String reamarksForDisschargeVitals="";
		
		if(request.getParameter("reamarksForDisschargeVitals")!=null){
			reamarksForDisschargeVitals=request.getParameter("reamarksForDisschargeVitals");
		}
		
		if(request.getParameterValues("careOf")!=null){
			careOf=request.getParameterValues("careOf");
		}
		if (request.getParameter("otBookingId") != null) {
			otBookingId = Integer.parseInt(request.getParameter("otBookingId"));
			patientMap.put("otBookingId",otBookingId);
		}

		if (request.getParameter("patientStatus") != null) {
			patientStatus = request.getParameter("patientStatus");
		}
		if (request.getParameter("visitId") != null
				&& !request.getParameter("visitId").equals("")) {
			VisitId = Integer.parseInt(request.getParameter("visitId"));
		}
		if (request.getParameter("inpatientId") != null
				&& !request.getParameter("inpatientId").equals("")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		if (request.getParameter(START_DATE) != null) {
			dateOfPost = request.getParameter(START_DATE);
		}
		if ((request.getParameter("anesthesia_id")) != null
				&& !(request.getParameter("anesthesia_id").equals("0"))) {
			anesthesia_id = Integer.parseInt(request
					.getParameter("anesthesia_id"));
		}

		if (!request.getParameter("remarks").equals("")) {
			remarks = request.getParameter("remarks");
		}
		if (!request.getParameter("e_others").equals("")) {
			e_others = request.getParameter("e_others");
		}
		if (!request.getParameter("levelOfAnesthesia").equals("")) {
			levelOfAnesthesia = request.getParameter("levelOfAnesthesia");
		}
		if (request.getParameter("height")!=null && !request.getParameter("height").equals("")) {
			height =Integer.parseInt( request.getParameter("height"));
		}
		if (request.getParameter("weight")!=null && !request.getParameter("weight").equals("")) {
			weight =Integer.parseInt( request.getParameter("weight"));
		}
		if (request.getParameter("bmi")!=null && !request.getParameter("bmi").equals("")) {
			bmi =request.getParameter("bmi");
		}
		if (request.getParameter("bmiStatus")!=null && !request.getParameter("bmiStatus").equals("")) {
			bmiStatus =request.getParameter("bmiStatus");
		}
		if (request.getParameter("pulse")!=null && !request.getParameter("pulse").equals("")) {
			pulse =request.getParameter("pulse");
		}
		if (request.getParameter("bp")!=null && !request.getParameter("bp").equals("")) {
			bp =request.getParameter("bp");
		}
		if (request.getParameter("resp")!=null && !request.getParameter("resp").equals("")) {
			resp =request.getParameter("resp");
		}
		if (!request.getParameter("risk_grade").equals("")) {
			risk_grade = request.getParameter("risk_grade");
		}
		if (!request.getParameter("recovery").equals("")) {
			recovery = request.getParameter("recovery");
		}
		if (!request.getParameter("others").equals("")) {
			others = Integer.parseInt(request.getParameter("others"));
		}
		if (!request.getParameter("temp").equals("")) {
			temp = request.getParameter("temp");
		}
		if (!request.getParameter("sp02").equals("")) {
			sp02 = request.getParameter("sp02");
		}
		if (!request.getParameter("labp").equals("")) {
			labp = request.getParameter("labp");
		}
		if (!request.getParameter("glycophyrrolate").equals("")) {
			glycophyrrolate = Integer.parseInt(request
					.getParameter("glycophyrrolate"));
		}
		if (!request.getParameter("uo").equals("")) {
			uo = request.getParameter("uo");
		}
		if (!request.getParameter("neostigmine").equals("")) {
			neostigmine = Integer.parseInt(request.getParameter("neostigmine"));
		}

		if (!request.getParameter("yearlySlNo").equals("")) {
			yearlySlNo = request.getParameter("yearlySlNo");
		}
		if (!request.getParameter("monthlySlNo").equals("")) {
			monthlySlNo = request.getParameter("monthlySlNo");
		}
		if (!request.getParameter("surgey_from_time").equals("")) {
			surgey_from_time = request.getParameter("surgey_from_time");
		}
		if (!request.getParameter("surgey_to_time").equals("")) {
			surgey_to_time = request.getParameter("surgey_to_time");
		}
		if (request.getParameter("asa_grade_details") != null
				|| request.getParameter("asa_grade_details") != "") {
			asa_grade_details = request.getParameter("asa_grade_details");
		}
		if (request.getParameter("anaesthesia_from_time") != null
				|| request.getParameter("anaesthesia_from_time") != "") {
			anaesthesia_from_time = request
					.getParameter("anaesthesia_from_time");
		}
		if (!request.getParameter("anaesthesia_to_time").equals("")) {
			anaesthesia_to_time = request.getParameter("anaesthesia_to_time");
		}
		if (!request.getParameter("ett_lma").equals("")) {
			ett_lma = request.getParameter("ett_lma");
		}

		if (!request.getParameter("ett_lma_text").equals("")) {
			ett_lma_text = Integer.parseInt(request
					.getParameter("ett_lma_text"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}

		if (!request.getParameter("ecg").equals("")) {
			ecg = request.getParameter("ecg");
		}
		if (!request.getParameter("nibp").equals("")) {
			nibp = request.getParameter("nibp");
		}
		if (!request.getParameter("cvp").equals("")) {
			cvp = request.getParameter("cvp");
		}
		// details captured for Iv Fluids header table
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> volumeList = new ArrayList<Integer>();
		List<String> fluidNameList = new ArrayList<String>();
		int hiddenValueFluids = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueFluids")) != 1) {
			hiddenValueFluids = Integer.parseInt(request
					.getParameter("hiddenValueFluids"));
		}
		String[] pvmsArr = new String[hiddenValueFluids];
		int j = 1;
		for (int i = 0; i < hiddenValueFluids; i++) {
			if (request.getParameter("nomenclature" + j) != null) {
				if (!request.getParameter("nomenclature" + j).equals("")) {

					String nomenclature = request.getParameter("nomenclature"
							+ j);
					int volume = Integer
							.parseInt(request.getParameter("v" + j));
					String fluidName = request.getParameter("fluidName" + j);
					int index1 = nomenclature.lastIndexOf("[");
					int index2 = nomenclature.lastIndexOf("]");
					index1++;
					pvmsArr[i] = nomenclature.substring(index1, index2);

					pvmsNoList.add(pvmsArr[i]);
					volumeList.add(volume);
					fluidNameList.add(fluidName);

				}
			}
			j++;
		}

		// details captured for Procedure Details table
		List<String> pvmsNoProList = new ArrayList<String>();
		List<String> anesthesiaList = new ArrayList<String>();
		List<String> dosageList = new ArrayList<String>();
		List<String> levelList = new ArrayList<String>();
		List<String> catheterList = new ArrayList<String>();

		/*
		 * int hiddenValueProcedure = 1; if
		 * (Integer.parseInt(request.getParameter("hiddenValueProcedure")) != 1)
		 * { hiddenValueProcedure = Integer.parseInt(request
		 * .getParameter("hiddenValueProcedure")); } String[] pvmsProArr = new
		 * String[hiddenValueProcedure]; int x = 1; for (int y = 0; y <
		 * hiddenValueProcedure; y++) { if
		 * (!request.getParameter("nomenclatureP" + x).equals("")) {
		 * 
		 * String nomenclature = request.getParameter("nomenclatureP" + x);
		 * String anesthesia = request.getParameter("anesthesia" + x); String
		 * dosage = request.getParameter("d" + x); String level =
		 * request.getParameter("level" + x); String catheter =
		 * request.getParameter("c" + x);
		 * 
		 * int index1 = nomenclature.lastIndexOf("["); int index2 =
		 * nomenclature.lastIndexOf("]"); index1++; pvmsProArr[y] =
		 * nomenclature.substring(index1, index2);
		 * pvmsNoProList.add(pvmsProArr[y]); anesthesiaList.add(anesthesia);
		 * dosageList.add(dosage); levelList.add(level);
		 * catheterList.add(catheter); } x++; }
		 */

		// details captured for Premedication/Induction/Maintenance Details
		// table
		List<String> pvmsNoPrList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		List<String> agePrList = new ArrayList<String>();
		List<String> routeList = new ArrayList<String>();
		List<String>premedicateTimeList=new ArrayList<String>();

		int hiddenValuePremedication = 1;
		if (Integer.parseInt(request.getParameter("hiddenValuePremedication")) != 1) {
			hiddenValuePremedication = Integer.parseInt(request
					.getParameter("hiddenValuePremedication"));
		}
		String[] pvmsPrArr = new String[hiddenValuePremedication];
		int t = 1;
		for (int r = 0; r < hiddenValuePremedication; r++) {
			if (request.getParameter("nomenclaturePr" + t) != null
					&& !request.getParameter("nomenclaturePr" + t).equals("")) {

				String nomenclature = request
						.getParameter("nomenclaturePr" + t);
				String typePIM = request.getParameter("typePIM" + t);
				String agePr = request.getParameter("dv" + t);
				String route = request.getParameter("route" + t);
				String preMedicateTime=request.getParameter("premedicateTime"+t);
				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsPrArr[r] = nomenclature.substring(index1, index2);

				pvmsNoPrList.add(pvmsPrArr[r]);
				typeList.add(typePIM);
				agePrList.add(agePr);
				routeList.add(route);
				premedicateTimeList.add(preMedicateTime);
			}
			t++;
		}

		// details captured for Anesthesiologist(s) table
		List<String> empNameList = new ArrayList<String>();

		int hiddenValueAnesthesiologist = 1;
		if (Integer.parseInt(request
				.getParameter("hiddenValueAnesthesiologist")) != 1) {
			hiddenValueAnesthesiologist = Integer.parseInt(request
					.getParameter("hiddenValueAnesthesiologist"));
		}
		String[] empArr = new String[hiddenValueAnesthesiologist];
		int w = 1;
		for (int q = 0; q < hiddenValueAnesthesiologist; q++) {
			if (request.getParameter("empName" + w) != null
					&& !request.getParameter("empName" + w).equals("")) {

				String empName = request.getParameter("empName" + w);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				empArr[q] = empName.substring(index1, index2);
				empNameList.add(empArr[q]);
			}
			w++;
		}

		// details captured for Sergon(s) table
		List<String> empNameSList = new ArrayList<String>();

		int hiddenValueSergon = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueSergon")) != 1) {
			hiddenValueSergon = Integer.parseInt(request
					.getParameter("hiddenValueSergon"));
		}
		String[] empArrS = new String[hiddenValueSergon];
		int e = 1;
		for (int o = 0; o < hiddenValueSergon; o++) {
			if (request.getParameter("empNameS" + e) != null
					&& !request.getParameter("empNameS" + e).equals("")) {

				String empName = request.getParameter("empNameS" + e);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				empArrS[o] = empName.substring(index1, index2);
				empNameSList.add(empArrS[o]);
			}
			e++;
		}

		// details captured for Surgery Details table
		List<String> chargeCodeList = new ArrayList<String>();

		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		String[] chargeCodeArr = new String[hiddenValue];
		int b = 1;
		for (int n = 0; n < hiddenValue; n++) {
			if (request.getParameter("chargeCodeName" + b) != null
					&& !request.getParameter("chargeCodeName" + b).equals("")) {

				String chargeCodeName = request.getParameter("chargeCodeName"
						+ b);

				int index1 = chargeCodeName.lastIndexOf("[");
				int index2 = chargeCodeName.lastIndexOf("]");
				index1++;
				chargeCodeArr[n] = chargeCodeName.substring(index1, index2);
				chargeCodeList.add(chargeCodeArr[n]);
			}
			n++;
		}

		mapForDS.put("otBookingId", otBookingId);
		mapForDS.put("patientStatus", patientStatus);
		mapForDS.put("inpatientId", inpatientId);
		mapForDS.put("VisitId", VisitId);

		// ----------data for Surgery------
		mapForDS.put("chargeCodeList", chargeCodeList);
		// ----------data for Anesthesiologist------
		mapForDS.put("empNameList", empNameList);
		// ----------data for Sergon------
		mapForDS.put("empNameSList", empNameSList);
		// ----------data for Premedication------
		mapForDS.put("typeList", typeList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("premedicateTimeList",premedicateTimeList);
		mapForDS.put("pvmsNoPrList", pvmsNoPrList);
		mapForDS.put("agePrList", agePrList);
		// ----------data for Procedure------
		mapForDS.put("pvmsNoProList", pvmsNoProList);
		mapForDS.put("catheterList", catheterList);
		mapForDS.put("anesthesiaList", anesthesiaList);
		mapForDS.put("levelList", levelList);
		mapForDS.put("dosageList", dosageList);
		// ----------data for IV Fuide------
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("volumeList", volumeList);
		mapForDS.put("fluidNameList", fluidNameList);

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("dateOfPost", dateOfPost);
		mapForDS.put("anesthesia_id", anesthesia_id);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		// mapForDS.put("visitId", visitId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put(USER_ID, userId);
		mapForDS.put("anaesthesia_from_time", anaesthesia_from_time);
		mapForDS.put("anaesthesia_to_time", anaesthesia_to_time);
		mapForDS.put("yearlySlNo", yearlySlNo);
		mapForDS.put("monthlySlNo", monthlySlNo);
		mapForDS.put("surgey_from_time", surgey_from_time);
		mapForDS.put("surgey_to_time", surgey_to_time);
		mapForDS.put("ett_lma", ett_lma);
		mapForDS.put("ett_lma_text", ett_lma_text);
		mapForDS.put("ecg", ecg);
		mapForDS.put("nibp", nibp);
		mapForDS.put("cvp", cvp);
		mapForDS.put("temp", temp);
		mapForDS.put("sp02", sp02);
		mapForDS.put("userName", userName);
		mapForDS.put("labp", labp);
		mapForDS.put("uo", uo);
		mapForDS.put("neostigmine", neostigmine);
		mapForDS.put("glycophyrrolate", glycophyrrolate);
		mapForDS.put("others", others);
		mapForDS.put("recovery", recovery);
		mapForDS.put("risk_grade", risk_grade);
		mapForDS.put("e_others", e_others);
		mapForDS.put("height", height);
		mapForDS.put("weight", weight);
		mapForDS.put("bmi", bmi);
		mapForDS.put("bmiStatus", bmiStatus);
		mapForDS.put("pulse", pulse);
		mapForDS.put("bp", bp);
		mapForDS.put("resp", resp);
		
		if(careOf!=null){
		mapForDS.put("careOf", careOf);
		}
		if(reamarksForDisschargeVitals!=null && !reamarksForDisschargeVitals.equals("")){
			mapForDS.put("reamarksForDisschargeVitals", reamarksForDisschargeVitals);
		}
		mapForDS.put("remarks", remarks);
		boolean bool = otHandlerService
				.submitOtPostAnesthesiaProcedure(mapForDS);
		String message = null;
		map = otHandlerService.saveOtPostAnaesthesiaFinalReadingJsp(patientMap);
		if (bool) {
			message = "Post Anesthesia Procedure Submitted Successfully !!Do you want to print ?";
		} else {
			message = "Error Occurred !! Try Again !!";
		}
		jsp = OT_MSG_POST_ANESTHESIA_PROCEDURE;
		jsp += ".jsp";
		map.put("yearlySlNo", yearlySlNo);
		map.put("deptId", departmentId);
		map.put("message", message);
		title = "Post Anesthesia Procedure Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getItemListForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
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
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getItemPrListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemPrList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
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
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getItemPListForAutoComplete(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("deptId", deptId);
			map.put("autoHint", autoHint);
			map = otHandlerService.getItemListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "opd_responseInGrid";

		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView getItemPList(HttpServletRequest request,
			HttpServletResponse response) {

		String itemNameField = "";
		int visitId = 0;
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
			map = otHandlerService.getItemList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "responseInGrid";
		return new ModelAndView(jsp, "map", map);
	}

	public ModelAndView searchOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SEARCH_OT_POST_ANESTHESIA_PROCEDURE_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView showOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String visitNo = "";
		String serviceNo = "";
		String hinNo = "";
		/*
		 * if (request.getParameter(SERVICE_NO) != null) { serviceNo =
		 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
		 * serviceNo); }
		 */
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
			mapForDS.put("visitNo", visitNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		map = otHandlerService.showOtPostAnesthesiaProcedure(mapForDS);

		jsp = SEARCH_SHOW_OT_POST_ANESTHESIA_PROCEDURE_JSP;
		jsp += ".jsp";
		title = "show Ot Post Anesthesia Procedure";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getOpdReportList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		int departmentId = 0;
		String submitData = "";
		int hospitalId = 0;
		try {
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
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			detailsMap.put(HOSPITAL_ID, hospitalId);
			List<Object> visitNoList = new ArrayList<Object>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("visit")) {
				visitNoList = otHandlerService.getVisitNoList(detailsMap);
				map.put("visitNoList", visitNoList);
				jsp = RESPONSE_FOR_OT_VISIT_NO;

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = RESPONSE_FOR_OT_HIN_NO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView updateOtPostAnesthesiaProcedure(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		int userId = (Integer)session.getAttribute(USER_ID);
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		// details captured for Ot Post Anesthesia Procedure table
		int anesthesia_id = 0;
		int postId = 0;
		String yearlySlNo = "";
		String monthlySlNo = "";
		String surgey_from_time = "";
		String surgey_to_time = "";
		String asa_grade_details = "";
		String anaesthesia_from_time = "";
		String anaesthesia_to_time = "";
		String ett_lma = "";
		int ett_lma_text = 0;
		String userName = null;
		String ecg = null;
		String nibp = null;
		String cvp = null;
		String temp = null;
		String sp02 = null;
		String labp = null;
		boolean submitData = false;
		String uo = "";
		int neostigmine = 0;
		int glycophyrrolate = 0;
		int others = 0;
		String recovery = "";
		String risk_grade = "";
		String e_others = "";
		String remarks = "";
		String dateOfPost = "";
		if (request.getParameter(START_DATE) != null) {
			dateOfPost = request.getParameter(START_DATE);
		}
		if ((request.getParameter("postId")) != null
				&& !(request.getParameter("postId").equals("0"))) {
			postId = Integer.parseInt(request.getParameter("postId"));

		}
		if ((request.getParameter("anesthesia_id")) != null
				&& !(request.getParameter("anesthesia_id").equals("0"))) {
			anesthesia_id = Integer.parseInt(request
					.getParameter("anesthesia_id"));

		}
		if (!request.getParameter("remarks").equals("")) {
			remarks = request.getParameter("remarks");
		}
		if (!request.getParameter("e_others").equals("")) {
			e_others = request.getParameter("e_others");
		}

		if (!request.getParameter("risk_grade").equals("")) {
			risk_grade = request.getParameter("risk_grade");
		}
		if (!request.getParameter("recovery").equals("")) {
			recovery = request.getParameter("recovery");
		}
		if (!request.getParameter("others").equals("")) {
			others = Integer.parseInt(request.getParameter("others"));
		}
		if (!request.getParameter("temp").equals("")) {
			temp = request.getParameter("temp");
		}
		if (!request.getParameter("sp02").equals("")) {
			sp02 = request.getParameter("sp02");
		}
		if (!request.getParameter("labp").equals("")) {
			labp = request.getParameter("labp");
		}
		if (!request.getParameter("glycophyrrolate").equals("")) {
			glycophyrrolate = Integer.parseInt(request
					.getParameter("glycophyrrolate"));
		}
		if (!request.getParameter("uo").equals("")) {
			uo = request.getParameter("uo");
		}
		if (!request.getParameter("neostigmine").equals("")) {
			neostigmine = Integer.parseInt(request.getParameter("neostigmine"));
		}

		if (!request.getParameter("yearlySlNo").equals("")) {
			yearlySlNo = request.getParameter("yearlySlNo");
		}
		if (!request.getParameter("monthlySlNo").equals("")) {
			monthlySlNo = request.getParameter("monthlySlNo");
		}
		if (!request.getParameter("surgey_from_time").equals("")) {
			surgey_from_time = request.getParameter("surgey_from_time");
		}
		if (!request.getParameter("surgey_to_time").equals("")) {
			surgey_to_time = request.getParameter("surgey_to_time");
		}
		if (request.getParameter("asa_grade_details") != null
				|| request.getParameter("asa_grade_details") != "") {
			asa_grade_details = request.getParameter("asa_grade_details");
		}
		if (request.getParameter("anaesthesia_from_time") != null
				|| request.getParameter("anaesthesia_from_time") != "") {
			anaesthesia_from_time = request
					.getParameter("anaesthesia_from_time");
		}
		if (!request.getParameter("anaesthesia_to_time").equals("")) {
			anaesthesia_to_time = request.getParameter("anaesthesia_to_time");
		}
		if (!request.getParameter("ett_lma").equals("")) {
			ett_lma = request.getParameter("ett_lma");
		}

		if (!request.getParameter("ett_lma_text").equals("")) {
			ett_lma_text = Integer.parseInt(request
					.getParameter("ett_lma_text"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}

		if (!request.getParameter("ecg").equals("")) {
			ecg = request.getParameter("ecg");
		}
		if (!request.getParameter("nibp").equals("")) {
			nibp = request.getParameter("nibp");
		}
		if (!request.getParameter("cvp").equals("")) {
			cvp = request.getParameter("cvp");
		}

		// details captured for Iv Fluids header table
		List<String> pvmsNoList = new ArrayList<String>();
		List<Integer> volumeList = new ArrayList<Integer>();
		List<String> fluidNameList = new ArrayList<String>();
		int hiddenValueFluids = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueFluids")) != 1) {
			hiddenValueFluids = Integer.parseInt(request
					.getParameter("hiddenValueFluids"));
		}
		String[] pvmsArr = new String[hiddenValueFluids];
		int j = 1;
		for (int i = 0; i < hiddenValueFluids; i++) {
			if (request.getParameter("nomenclature" + j) != null) {
				if (!request.getParameter("nomenclature" + j).equals("")) {

					String nomenclature = request.getParameter("nomenclature"
							+ j);
					int volume = Integer
							.parseInt(request.getParameter("v" + j));
					String fluidName = request.getParameter("fluidName" + j);
					int index1 = nomenclature.lastIndexOf("[");
					int index2 = nomenclature.lastIndexOf("]");
					index1++;
					pvmsArr[i] = nomenclature.substring(index1, index2);
					pvmsNoList.add(pvmsArr[i]);
					volumeList.add(volume);
					fluidNameList.add(fluidName);
				}
			}
			j++;
		}

		// details captured for Procedure Details table
		List<String> pvmsNoProList = new ArrayList<String>();
		List<String> anesthesiaList = new ArrayList<String>();
		List<String> dosageList = new ArrayList<String>();
		List<String> levelList = new ArrayList<String>();
		List<String> catheterList = new ArrayList<String>();

		int hiddenValueProcedure = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueProcedure")) != 1) {
			hiddenValueProcedure = Integer.parseInt(request
					.getParameter("hiddenValueProcedure"));
		}
		String[] pvmsProArr = new String[hiddenValueProcedure];
		int x = 1;
		for (int y = 0; y < hiddenValueProcedure; y++) {
			if (!request.getParameter("nomenclatureP" + x).equals("")) {

				String nomenclature = request.getParameter("nomenclatureP" + x);
				String anesthesia = request.getParameter("anesthesia" + x);
				String dosage = request.getParameter("d" + x);
				String level = request.getParameter("level" + x);
				String catheter = request.getParameter("c" + x);

				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsProArr[y] = nomenclature.substring(index1, index2);

				pvmsNoProList.add(pvmsProArr[y]);
				anesthesiaList.add(anesthesia);
				dosageList.add(dosage);
				levelList.add(level);
				catheterList.add(catheter);
			}
			x++;
		}

		// details captured for Premedication/Induction/Maintenance Details
		// table
		List<String> pvmsNoPrList = new ArrayList<String>();
		List<String> typeList = new ArrayList<String>();
		List<String> agePrList = new ArrayList<String>();
		List<String> routeList = new ArrayList<String>();

		int hiddenValuePremedication = 1;
		if (Integer.parseInt(request.getParameter("hiddenValuePremedication")) != 1) {
			hiddenValuePremedication = Integer.parseInt(request
					.getParameter("hiddenValuePremedication"));
		}
		String[] pvmsPrArr = new String[hiddenValuePremedication];
		int t = 1;
		for (int r = 0; r < hiddenValuePremedication; r++) {
			if (!request.getParameter("nomenclaturePr" + t).equals("")) {

				String nomenclature = request
						.getParameter("nomenclaturePr" + t);
				String typePIM = request.getParameter("typePIM" + t);
				String agePr = request.getParameter("dv" + t);
				String route = request.getParameter("route" + t);

				int index1 = nomenclature.lastIndexOf("[");
				int index2 = nomenclature.lastIndexOf("]");
				index1++;
				pvmsPrArr[r] = nomenclature.substring(index1, index2);

				pvmsNoPrList.add(pvmsPrArr[r]);
				typeList.add(typePIM);
				agePrList.add(agePr);
				routeList.add(route);

			}
			t++;
		}

		// details captured for Anesthesiologist(s) table
		List<String> empNameList = new ArrayList<String>();

		int hiddenValueAnesthesiologist = 1;
		if (Integer.parseInt(request
				.getParameter("hiddenValueAnesthesiologist")) != 1) {
			hiddenValueAnesthesiologist = Integer.parseInt(request
					.getParameter("hiddenValueAnesthesiologist"));
		}
		String[] empArr = new String[hiddenValueAnesthesiologist];
		int w = 1;
		for (int q = 0; q < hiddenValueAnesthesiologist; q++) {
			if (!request.getParameter("empName" + w).equals("")) {

				String empName = request.getParameter("empName" + w);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				empArr[q] = empName.substring(index1, index2);

				empNameList.add(empArr[q]);
			}
			w++;
		}

		// details captured for Sergon(s) table
		List<String> empNameSList = new ArrayList<String>();

		int hiddenValueSergon = 1;
		if (Integer.parseInt(request.getParameter("hiddenValueSergon")) != 1) {
			hiddenValueSergon = Integer.parseInt(request
					.getParameter("hiddenValueSergon"));
		}
		String[] empArrS = new String[hiddenValueSergon];
		int e = 1;
		for (int o = 0; o < hiddenValueSergon; o++) {
			if (!request.getParameter("empNameS" + e).equals("")) {

				String empName = request.getParameter("empNameS" + e);

				int index1 = empName.lastIndexOf("[");
				int index2 = empName.lastIndexOf("]");
				index1++;
				empArrS[o] = empName.substring(index1, index2);
				empNameSList.add(empArrS[o]);
			}
			e++;
		}

		// details captured for Surgery Details table
		List<String> chargeCodeList = new ArrayList<String>();

		int hiddenValue = 1;
		if (Integer.parseInt(request.getParameter("hiddenValue")) != 1) {
			hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
		}
		String[] chargeCodeArr = new String[hiddenValue];
		int b = 1;
		for (int n = 0; n < hiddenValue; n++) {
			if (!request.getParameter("chargeCodeName" + b).equals("")) {

				String chargeCodeName = request.getParameter("chargeCodeName"
						+ b);

				int index1 = chargeCodeName.lastIndexOf("[");
				int index2 = chargeCodeName.lastIndexOf("]");
				index1++;
				chargeCodeArr[n] = chargeCodeName.substring(index1, index2);

				chargeCodeList.add(chargeCodeArr[n]);
			}
			n++;
		}
		
		mapForDS.put(USER_ID, userId);

		// ----------data for Surgery------
		mapForDS.put("chargeCodeList", chargeCodeList);
		// ----------data for Anesthesiologist------
		mapForDS.put("empNameList", empNameList);
		// ----------data for Sergon------
		mapForDS.put("empNameSList", empNameSList);
		// ----------data for Premedication------
		mapForDS.put("typeList", typeList);
		mapForDS.put("routeList", routeList);
		mapForDS.put("pvmsNoPrList", pvmsNoPrList);
		mapForDS.put("agePrList", agePrList);
		// ----------data for Procedure------
		mapForDS.put("pvmsNoProList", pvmsNoProList);
		mapForDS.put("catheterList", catheterList);
		mapForDS.put("anesthesiaList", anesthesiaList);
		mapForDS.put("levelList", levelList);
		mapForDS.put("dosageList", dosageList);
		// ----------data for IV Fuide------
		mapForDS.put("pvmsNoList", pvmsNoList);
		mapForDS.put("volumeList", volumeList);
		mapForDS.put("fluidNameList", fluidNameList);

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("dateOfPost", dateOfPost);
		mapForDS.put("postId", postId);
		mapForDS.put("anesthesia_id", anesthesia_id);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("anaesthesia_from_time", anaesthesia_from_time);
		mapForDS.put("anaesthesia_to_time", anaesthesia_to_time);
		mapForDS.put("yearlySlNo", yearlySlNo);
		mapForDS.put("monthlySlNo", monthlySlNo);
		mapForDS.put("surgey_from_time", surgey_from_time);
		mapForDS.put("surgey_to_time", surgey_to_time);
		mapForDS.put("ett_lma", ett_lma);
		mapForDS.put("ett_lma_text", ett_lma_text);
		mapForDS.put("ecg", ecg);
		mapForDS.put("nibp", nibp);
		mapForDS.put("cvp", cvp);
		mapForDS.put("temp", temp);
		mapForDS.put("sp02", sp02);
		mapForDS.put("userName", userName);
		mapForDS.put("labp", labp);
		mapForDS.put("uo", uo);
		mapForDS.put("neostigmine", neostigmine);
		mapForDS.put("glycophyrrolate", glycophyrrolate);
		mapForDS.put("others", others);
		mapForDS.put("recovery", recovery);
		mapForDS.put("risk_grade", risk_grade);
		mapForDS.put("e_others", e_others);
		mapForDS.put("remarks", remarks);

		boolean bool = otHandlerService
				.updateOtPostAnesthesiaProcedure(mapForDS);
		String message = null;
		if (bool) {
			message = "Post Anesthesia Procedure Updated successfully!!";
		} else {

			message = "Error Occurred!! Try Again !!";
		}
		jsp = "postAnesthesiaProcedureJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("message", message);
		title = "Post Anesthesia Procedure Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);
	}

	// ------------------------------------------------Specimen Dispatch
	// Entry---------------------------

	public ModelAndView showSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();

		String jsp = OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView showSpecimenDispatchEntryPatientDetails(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		int hospitalId = 0;

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			/*
			 * if (request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
			 * serviceNo); }
			 */
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			mapForDS.put(HOSPITAL_ID, hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService
				.searchSpecimenDispatchEntryPatientDetails(mapForDS);
		String jsp = "";
		jsp = OT_SPECIMEN_DISPATCH_ENTRY_SEARCH_JSP + ".jsp";
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView showSpecimenDispatchEntryJspFromPatientList(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute(DEPT_ID);
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		// String hinNo = request.getParameter("hinNo");
//		int hinId = Integer.parseInt(request.getParameter("hinId"));
		String orderNo = request.getParameter("orderNo");
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		String entryNo = "";
//		mapForDS.put("hinId", hinId);
		mapForDS.put("orderNo", orderNo);
		mapForDS.put("bookingId", bookingId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		try {
			map = otHandlerService.showSpecimenDispatchEntryJspForHin(mapForDS);

			entryNo = otHandlerService.getEntryNoForDisplay();
			if (entryNo != null) {
				map.put("entryNo", entryNo);
			}
			jsp = OT_SPECIMEN_DISPATCH_ENTRY_FOR_INPATIENT_JSP;
			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView submitOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int userId = (Integer)session.getAttribute(USER_ID);

		int visitId = 0;
		if ((request.getParameter("visitId")) != null
				&& !(request.getParameter("visitId").equals(""))) {
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		int empBy = 0;
		int empRev = 0;
		String entryNo = "";
		String timeOfDispatch = "";
		String examinationRequired = "";
		String clinicalNotes = "";
		String tissueOrgan = "";
		String dateOfDispatch = "";
		String userName = null;

		boolean submitData = false;

		if ((request.getParameter("empBy")) != null
				&& !(request.getParameter("empBy").equals("0"))) {
			empBy = Integer.parseInt(request.getParameter("empBy"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}
		if ((request.getParameter("empRev")) != null
				&& !(request.getParameter("empRev").equals("0"))) {
			empRev = Integer.parseInt(request.getParameter("empRev"));
		}
		if (!request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (!request.getParameter("timeOfDispatch").equals("")) {
			timeOfDispatch = request.getParameter("timeOfDispatch");
		}
		if (request.getParameter("dateOfDispatch") != null) {
			dateOfDispatch = request.getParameter("dateOfDispatch");
		}
		if (!request.getParameter("examinationRequired").equals("")) {
			examinationRequired = request.getParameter("examinationRequired");
		}
		if (!request.getParameter("clinicalNotes").equals("")) {
			clinicalNotes = request.getParameter("clinicalNotes");
		}
		if (!request.getParameter("tissueOrgan").equals("")) {
			tissueOrgan = request.getParameter("tissueOrgan");
		}

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("tissueOrgan", tissueOrgan);
		mapForDS.put(USER_ID, userId);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("clinicalNotes", clinicalNotes);
		mapForDS.put("examinationRequired", examinationRequired);
		mapForDS.put("timeOfDispatch", timeOfDispatch);
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("empRev", empRev);
		mapForDS.put("empBy", empBy);
		mapForDS.put("userName", userName);
		mapForDS.put("dateOfDispatch", dateOfDispatch);

		boolean bool = otHandlerService.submitOtSpecimenDispatchEntry(mapForDS);
		String message = null;
		if (bool) {
			message = "Specimen Dispatch Entry Submitted Successfully!!Do you want to print ? ";
		} else {

			message = " Try Again !!";
		}
		jsp = "specimenDispatchEntryJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("message", message);
		title = "Specimen Dispatch EntryDetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView searchOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = SEARCH_OT_SPECIMEN_DISPATCH_ENTRY_JSP + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings({ "unchecked", "unchecked" })
	public ModelAndView showOtSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String visitNo = "";
		String serviceNo = "";
		String hinNo = "";
		if (request.getParameter(SERVICE_NO) != null) {
			serviceNo = request.getParameter(SERVICE_NO);
			mapForDS.put("serviceNo", serviceNo);
		}
		if (request.getParameter(VISIT_NUMBER) != null) {
			visitNo = request.getParameter(VISIT_NUMBER);
			mapForDS.put("visitNo", visitNo);
		}
		if (request.getParameter(HIN_NO) != null) {
			hinNo = request.getParameter(HIN_NO);
			mapForDS.put("hinNo", hinNo);
		}

		map = otHandlerService.showOtSpecimenDispatchEntry(mapForDS);

		jsp = SEARCH_SHOW_OT_SPECIMEN_DISPATCH_ENTRY_JSP;
		jsp += ".jsp";
		title = "Show Ot Specimen Dispatch Entry";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unchecked")
	public ModelAndView getOTSpecimenDispatchList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String serviceNo = "";
		String hinNo = "";
		try {
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
			List<Object> visitNoList = new ArrayList<Object>();
			List<Object> hinNoList = new ArrayList<Object>();
			String flag = "";

			if (request.getParameter("flag") != null) {
				flag = request.getParameter("flag");
			}
			if (flag.equals("visit")) {
				visitNoList = otHandlerService.getEntryNoList(detailsMap);
				map.put("visitNoList", visitNoList);
				jsp = RESPONSE_FOR_OT_ENTRY_NO;

			} else if (flag.equals("hin")) {
				hinNoList = otHandlerService.getEntryHinNoList(serviceNo);
				map.put("hinNoList", hinNoList);

				jsp = RESPONSE_FOR_OT_ENTRY_HIN_NO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(jsp, "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView updateOtSpecimenDispatchEntry(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hinId = Integer.parseInt(request.getParameter("hinId"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int visitId = Integer.parseInt(request.getParameter("visitId"));
		int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
		int userId=(Integer)session.getAttribute(USER_ID);
		// details captured for Ot Post Anesthesia Procedure table
		int empBy = 0;
		int empRev = 0;
		String entryNo = "";
		String timeOfDispatch = "";
		String examinationRequired = "";
		String clinicalNotes = "";
		String tissueOrgan = "";
		String dateOfDispatch = "";
		String userName = null;
		int specimenId = 0;
		boolean submitData = false;

		if ((request.getParameter("specimenId")) != null
				&& !(request.getParameter("specimenId").equals("0"))) {
			specimenId = Integer.parseInt(request.getParameter("specimenId"));

		}
		if ((request.getParameter("empBy")) != null
				&& !(request.getParameter("empBy").equals("0"))) {
			empBy = Integer.parseInt(request.getParameter("empBy"));

		}
		if (!request.getParameter("userName").equals("")) {
			userName = request.getParameter("userName");
		}
		if ((request.getParameter("empRev")) != null
				&& !(request.getParameter("empRev").equals("0"))) {
			empRev = Integer.parseInt(request.getParameter("empRev"));

		}
		if (!request.getParameter("entryNo").equals("")) {
			entryNo = request.getParameter("entryNo");
		}
		if (!request.getParameter("timeOfDispatch").equals("")) {
			timeOfDispatch = request.getParameter("timeOfDispatch");
		}
		if (request.getParameter("dateOfDispatch") != null) {
			dateOfDispatch = request.getParameter("dateOfDispatch");
		}
		if (!request.getParameter("examinationRequired").equals("")) {
			examinationRequired = request.getParameter("examinationRequired");
		}
		if (!request.getParameter("clinicalNotes").equals("")) {
			clinicalNotes = request.getParameter("clinicalNotes");
		}
		if (!request.getParameter("tissueOrgan").equals("")) {
			tissueOrgan = request.getParameter("tissueOrgan");
		}

		// ----------data for Post Anesthesia Procedure ------
		mapForDS.put("tissueOrgan", tissueOrgan);
		mapForDS.put("specimenId", specimenId);
		mapForDS.put("hinId", hinId);
		mapForDS.put("departmentId", departmentId);
		mapForDS.put("visitId", visitId);
		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("clinicalNotes", clinicalNotes);
		mapForDS.put("examinationRequired", examinationRequired);
		mapForDS.put("timeOfDispatch", timeOfDispatch);
		mapForDS.put("entryNo", entryNo);
		mapForDS.put("empRev", empRev);
		mapForDS.put("empBy", empBy);
		mapForDS.put("userName", userName);
		mapForDS.put(USER_ID, userId);
		mapForDS.put("dateOfDispatch", dateOfDispatch);

		boolean bool = otHandlerService.updateOtSpecimenDispatchEntry(mapForDS);
		String message = null;
		if (bool) {
			message = "Specimen Dispatch Entry updated successfully!!";
		} else {
			message = "Error Occurred !!Try Again !!";
		}
		jsp = "specimenDispatchEntryJsp";
		jsp += ".jsp";

		map.put("deptId", departmentId);
		map.put("message", message);
		title = "Specimen Dispatch EntryDetails";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("submitData", submitData);
		return new ModelAndView("index", "map", map);

	}

	/**
	 * -------------------- COMMON METHOD FOR REPORT ----------------
	 */
	// -------------Jasper Compiled Report
	// --------------------------------------
	private JasperReport getCompiledReport(String fileName) throws JRException {

		File reportFile = new File(getServletContext().getRealPath(
				"/Reports/" + fileName + ".jasper"));
		JasperReport jasperReport = (JasperReport) JRLoader
				.loadObject(reportFile);

		return jasperReport;
	}

	/**
	 * --------------------- OT LIST REPORT ----------------------
	 */
	public ModelAndView showOtListReportJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "otListReport" + ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOtListReport(HttpServletRequest request,
			HttpServletResponse response) {

		Date fromDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (request.getParameter("bookingDate") != null
					&& !(request.getParameter("bookingDate").equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter("bookingDate"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		detailsMap = otHandlerService.getConnectionForReport();
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("surgeryDate", fromDate);
		try {
			byte[] bytes = null;
			try {
				bytes = JasperRunManager.runReportToPdf(
						getCompiledReport("ot_list"), parameters,
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
	}

	/**
	 * --------------------- OT Post Anaesthesia REPORT ----------------------
	 */
	public ModelAndView showOtPostAnaesthesiaReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Post Anaesthesia Report";
		jsp = "showOtPostAnaesthesiaReportJsp";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateOtPostAnaesthesiaReport(
			HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("otPostMain", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	/**
	 * --------------------- OT Specimen Dispatch REPORT ----------------------
	 */
	public ModelAndView showSpecimenDispatchReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "Specimen Dispatch Report";
		jsp = "ot_specimenDispatchReport";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateSpecimenDispatchReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			int hospitalId=0;
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_SpecimenDispatchReport", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ---------------------printHumanBodyDisposal BY
	// Dipali----------------------
	public ModelAndView printHumanBodyDisposal(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int entryNo = 0;
		int hospitalId=0;

		try {
			if (request.getParameter("entryNo") != null
					&& !request.getParameter("entryNo").equals("")) {
				entryNo = Integer.parseInt(request.getParameter("entryNo"));
				requestParameters.put("entryNo", entryNo);
			}
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_HumanBodyPartsDisposalEntryNOReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// -------------generateHumanBodyPartsReport By
	// Dipali--------------------------------
	public ModelAndView generateHumanBodyPartsReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId=0;
		try {
			if (request.getParameter(FROM_DATE) != null
					&& !(request.getParameter(FROM_DATE).equals(""))) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(FROM_DATE));
				requestParameters.put("FROM_DATE", fromDate);
			}
			if (request.getParameter(TO_DATE) != null
					&& !(request.getParameter(TO_DATE).equals(""))) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request
						.getParameter(TO_DATE));
				requestParameters.put("TO_DATE", toDate);
			}
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_HumanBodyPartsDisposalReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// -------------------printSpecimenDispatchEntry---By
	// Dipali--------------------

	public ModelAndView printSpecimenDispatchEntry(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String entryNo = "";
		int hospitalId=0;
		try {
			if (request.getParameter("entryNo") != null
					&& !request.getParameter("entryNo").equals("")) {
				entryNo = (request.getParameter("entryNo"));
				requestParameters.put("entryNo", entryNo);
			}
			
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_SpecimenDispatchEntryNoReport",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ---------------------HumanBodyPartsDisposalReport---By
	// Dipali---------------------------------------
	public ModelAndView showHumanBodyPartsDisposalReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "HumanBodyPartsDisposal";
		jsp = "ot_HumanBodyPartDisposalReport";
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	// -------------------printSpecimenDispatchEntry---By
	// Dipali--------------------

	public ModelAndView printOtProcedureNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String YearlySrNo = "";
		int hospitalId=0;
		String ipNo="";
		String wardName="";
		try {
			if (request.getParameter("YearlySrNo") != null
					&& !request.getParameter("YearlySrNo").equals("")) {
				YearlySrNo = (request.getParameter("YearlySrNo"));
				requestParameters.put("YearlySrNo", YearlySrNo);
			}
			
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
			
			if(request.getParameter("ipNo")!=null){
				ipNo=request.getParameter("ipNo");
			}
			if(request.getParameter("wardName")!=null){
			   wardName=request.getParameter("wardName");	
			}
			requestParameters.put("ipNo", ipNo);
			requestParameters.put("wardName", wardName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("OT_procedureNotesEntry", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// -------------------printOtPostAnesthesiaProcedureReport---By
	// Dipali--------------------

	public ModelAndView printOtPostAnesthesiaProcedureReport(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		String yearlySlNo = "";
		int hospitalId=0;
		try {
			if (request.getParameter("yearlySlNo") != null
					&& !request.getParameter("yearlySlNo").equals("")) {
				yearlySlNo = (request.getParameter("yearlySlNo"));
				requestParameters.put("YearlySrNo", yearlySlNo);
			}
			if(session.getAttribute(HOSPITAL_ID)!=null)
			{
				hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
			}
			requestParameters.put("hospitalId", hospitalId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("OT_postAnaesthesiaProcedureNotesEntry",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	// ---------------------WorkLoadRegisterReportReport---By
	// Dipali---------------------------------------
	public ModelAndView showWorkLoadRegisterReportJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		title = "WorkLoadRegisterReport";
		jsp = OT_WORK_LOAD_REGISTER;
		jsp = jsp + ".jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	}

	public ModelAndView generateWorkLoadRegisterReport(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		int postYear = 0;
		Box box = HMSUtil.getBox(request);
		postYear = box.getInt("postYear");

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		requestParameters.put("postYear", postYear);
		HMSUtil.generateReport("ot_WorkLoadReport", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return new ModelAndView("index", "map", map);
	}

	/**
	 * ----------------------- Print PAC Report
	 * -----------------------------------
	 */
	public ModelAndView printPAC(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int orderNo = 0;
		int hinId = 0;
		String pastRecords = "";
		String presentHistory = "";
		String drugTherapy = "";
		try {
			if (request.getParameter("orderNo") != null) {
				orderNo = Integer.parseInt(request.getParameter("orderNo"));
				requestParameters.put("orderNo", orderNo);
			}
			if (request.getParameter("hinId") != null) {
				hinId = Integer.parseInt(request.getParameter("hinId"));
				requestParameters.put("hinId", hinId);
			}
			if (request.getParameter("pastRecords") != null) {
				pastRecords = (String) map.get("pastRecords");
				requestParameters.put("pastRecords", pastRecords);
			} else {
				requestParameters.put("pastRecords", "");
			}
			if (request.getParameter("presentHistory") != null) {
				presentHistory = (String) map.get("presentHistory");
				requestParameters.put("presentHistory", presentHistory);
			} else {
				requestParameters.put("presentHistory", "");
			}
			if (request.getParameter("drugTherapy") != null) {
				drugTherapy = (String) map.get("drugTherapy");
				requestParameters.put("drugTherapy", drugTherapy);
			} else {
				requestParameters.put("drugTherapy", "");
			}
			map = otHandlerService.printPAC(hinId);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		// requestParameters.put("SUBREPORT_DIR",
		// getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		// if(map.get("PatientStatus").equals("inpatient"))
		// {
		// HMSUtil.generateReport("OT_preAnaestheticAssesmentFormEntryForIP",requestParameters,(Connection)connectionMap.get("con"),response,
		// getServletContext());
		// }
		// else if(map.get("PatientStatus").equals("outpatient"))
		// {
		HMSUtil.generateReport("OT_preAnaestheticAssesmentFormEntry",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		// }
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);

	}

	public ModelAndView printOtPreAnesthesiaNotesEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		String YearlySrNo = "";
		try {
			if (request.getParameter("yearlySerialNo") != null
					&& !request.getParameter("yearlySerialNo").equals("")) {
				YearlySrNo = (request.getParameter("yearlySerialNo"));
				requestParameters.put("YearlySrNo", YearlySrNo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports/"));

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("ot_preAnaesthesiaProcedureNotes",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		//return new ModelAndView("index", "map", map);
		return null;
	}

	@SuppressWarnings("unused")
	public ModelAndView getInvestigationListForRequestionForIP(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String departmentIdField = "";
		String autoHint = "";
		int otId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}

			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("userName", userName);
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			// map.put("otId", otId);
			map1 = otHandlerService.getInvestigationListForRequestionForIP(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_SURGERY_RESPONSE_JSP;

		return new ModelAndView(jsp, "map", map1);
	}

	// ------------Added By dipali---
	public ModelAndView showOtConsentDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		// String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			/*
			 * if (request.getParameter(SERVICE_NO) != null &&
			 * !(request.getParameter(SERVICE_NO).equals(""))) { serviceNo =
			 * request.getParameter(SERVICE_NO); mapForDS.put("serviceNo",
			 * serviceNo); }
			 */
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (request.getParameter(HIN_NO) != null
//				// || request.getParameter(SERVICE_NO) != null
//				|| request.getParameter(P_FIRST_NAME) != null
//				|| request.getParameter(P_MIDDLE_NAME) != null
//				|| request.getParameter(P_LAST_NAME) != null) {
//			patientMap = otHandlerService
//					.searchOtPatientConsentDetails(mapForDS);
//		}
		patientMap = otHandlerService.searchOtPatientConsentDetails(mapForDS);
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearchForConsent" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showConsentEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		int inpatientId = 0;
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").trim().equals("")){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		
		
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		mapForDS.put("hinNo", hinNo);

		try {
			map = otHandlerService.showConsentEntryJsp(mapForDS);
			jsp = "OT_ConsentEntryDetails";

			jsp += ".jsp";
			// map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("inpatientId", inpatientId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitConsentForOt(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hinId = 0;
		int relationId = 0;
		String name = "";
		Date date = new Date();
		String procedureExplained = "";
		String phone = "";
		String address = "";
		String procedureTemplate = null; // added by amit das on 26-09-2016
		int inpatientId = 0; // added by amit das on 26-09-2016
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		if (request.getParameter("relation") != null
				&& !request.getParameter("relation").equals("")) {
			relationId = Integer.parseInt(request.getParameter("relation"));
		}
		if (request.getParameter("legalName") != null) {
			name = request.getParameter("legalName");
		}
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE));
		}
		if (request.getParameter("checkpro") != null) {
			procedureExplained = request.getParameter("checkpro");
		}
		if (request.getParameter("phone") != null) {
			phone = request.getParameter("phone");
		}
		if (request.getParameter("address") != null) {
			address = request.getParameter("address");
		}
		
		if (request.getParameter("procedureTemplate") != null && !request.getParameter("procedureTemplate").trim().equals("")) {
			procedureTemplate = request.getParameter("procedureTemplate");
		}
		
		if (request.getParameter("inpatientId") != null && !request.getParameter("inpatientId").trim().equals("")) {
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}

		Box box = HMSUtil.getBox(request);

		OtConsent otConsent = new OtConsent();
		otConsent.setName(name);
		otConsent.setDate(date);
		otConsent.setPhone(phone);
		otConsent.setAddress(address);
		otConsent.setProcedureExplianed(procedureExplained);
		MasRelation masRelation = new MasRelation();
		masRelation.setId(relationId);
		otConsent.setRalation(masRelation);
		Patient pat = new Patient();
		pat.setId(hinId);
		otConsent.setHin(pat);
		otConsent.setProcedureTemplate(procedureTemplate); // added by amit das on 26-09-2016
		map = otHandlerService.submitConsentForOt(otConsent, box);
		String save = "";
		if (map.get("save") != null) {
			save = (String) map.get("save");
		}
		if (save != null) {
			message = "Record Added Successfully !! <br /> Do you wish to print??";
		} else {
			message = "Error occured !! ";
		}
		int otConsentId = 0;
		otConsentId = otConsent.getId();
		String jsp = "";
		jsp = "messageForOtConsent" + ".jsp";
		map.put("message", message);
		map.put("otConsentId", otConsentId);
		map.put("inpatientId", inpatientId); // added by amit das on 26-09-2016
		map.put("procedureTemplate", procedureTemplate); // added by amit das on 26-09-2016
		map.put("hinId", hinId); // added by amit das on 26-09-2016
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printotConsent(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;

		String returnNumber = null;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String hospitalName = "";
		String address = "";
		int otConsentId = 0;
		int inpatientId = 0; // added by amit das on 26-09-2016
		int hinId = 0; // added by amit das on 26-09-2016
		String procedureTemplate = null; // added by amit das on 26-09-2016
		String reportFileName = null; // added by amit das on 26-09-2016
		map = otHandlerService.getHospitalName(hospitalId);
		
		// added by amit das on 26-09-2016
		if (request.getParameter("procedureTemplate") != null
				&& !(request.getParameter("procedureTemplate").equals(""))) {

			procedureTemplate =request.getParameter("procedureTemplate");
		}
		
		// added by amit das on 26-09-2016
		if (request.getParameter("inpatientId") != null
						&& !(request.getParameter("inpatientId").equals(""))) {

			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
			requestParameters.put("inpatientId", inpatientId);
		}
		
		
		
		// added by amit das on 26-09-2016
		if(procedureTemplate!=null && procedureTemplate.equalsIgnoreCase("Angiography"))
			reportFileName = "Consent_form_Angiography";
		else if(procedureTemplate!=null && procedureTemplate.equalsIgnoreCase("Angioplasty"))
			reportFileName = "Consent_form_Angioplasty";
		else
			reportFileName = "ot_consent";
		
		
		if (map.get("hospitalName") != null
				&& !map.get("hospitalName").equals("")) {
			hospitalName = (String) map.get("hospitalName");
		}
		if (map.get("address") != null && !map.get("address").equals("")) {
			address = (String) map.get("address");
		}
		requestParameters.put("address", address);
		requestParameters.put("hospitalName", hospitalName);
		try {
			if (request.getParameter("otConsentId") != null
					&& !(request.getParameter("otConsentId").equals(""))) {

				otConsentId = Integer.parseInt(request
						.getParameter("otConsentId"));
				requestParameters.put("otConsentId", otConsentId);
			}
			
			// added by amit das on 26-09-2016
			if (request.getParameter("hinId") != null
					&& !(request.getParameter("hinId").equals(""))) {

				hinId = Integer.parseInt(request
						.getParameter("hinId"));
				requestParameters.put("hinId", hinId);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport(reportFileName), requestParameters,
					(Connection) connectionMap.get("con"));

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
		return null;
	}

	public ModelAndView showPreOperativeCheckList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		// String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";

		try {
			if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
			{
				mapForDS.put(HIN_NO, request.getParameter("uhid"));
			}
			
			if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
			}
			
			if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
			{
				mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
			}
			
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
			{
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}
			
			
			if(request.getParameter("otProcedure")!=null && !request.getParameter("otProcedure").equals(""))
			{
				otProcedure=request.getParameter("otProcedure");
				mapForDS.put("otProcedure", request.getParameter("otProcedure"));
			}
			
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (request.getParameter(HIN_NO) != null
//				// || request.getParameter(SERVICE_NO) != null
//				|| request.getParameter(P_FIRST_NAME) != null
//				|| request.getParameter(P_MIDDLE_NAME) != null
//				|| request.getParameter(P_LAST_NAME) != null) {
//			patientMap = otHandlerService.searchPreOperativeCheckList(mapForDS);
//		}
		patientMap = otHandlerService.searchPreOperativeCheckList(mapForDS);
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearchForPreOperative" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showPreOperativeCheckListEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		mapForDS.put("hinNo", hinNo);
		mapForDS.put("bookingId", bookingId);

		try {
			map = otHandlerService.showPreOperativeCheckListEntryJsp(mapForDS);
			jsp = "OT_PreOperativeDetails";

			jsp += ".jsp";
			// map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitPreOTCheckList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hinId = 0;
		String temp = "";
		String pulse = "";

		Date date = new Date();
		String resp = "";
		String bp = "";
		String wt = "";
		String ht = "";
		String pcfc = "";
		String issm = "";
		String xraydtl = "";
		String niddm = "";
		String iddm = "";
		String intra_operative_surgery_status = "n";
		if (request.getParameter("NIDDM") != null) {
			niddm = request.getParameter("NIDDM");
		}
		if (request.getParameter("IDDM") != null) {
			iddm = request.getParameter("IDDM");
		}

		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}
		if (request.getParameter("temp") != null) {
			temp = request.getParameter("temp");
		}
		if (request.getParameter("pulse") != null) {
			pulse = request.getParameter("pulse");
		}
		if (request.getParameter(DATE) != null) {
			date = HMSUtil.convertStringTypeDateToDateType(request
					.getParameter(DATE));
		}
		if (request.getParameter("resp") != null) {
			resp = request.getParameter("resp");
		}
		if (request.getParameter("wt") != null) {
			wt = request.getParameter("wt");
		}
		if (request.getParameter("ht") != null) {
			ht = request.getParameter("ht");
		}
		if (request.getParameter("pcfc") != null) {
			pcfc = request.getParameter("pcfc");
		}
		if (request.getParameter("issm") != null) {
			issm = request.getParameter("issm");
		}
		if (request.getParameter("xraydtl") != null) {
			xraydtl = request.getParameter("xraydtl");
		}
		String asd = "";
		if (request.getParameter("asd") != null) {
			asd = request.getParameter("asd");
		}
		String ia = "";
		if (request.getParameter("ia") != null) {
			ia = request.getParameter("ia");
		}
		String cma = "";
		if (request.getParameter("cma") != null) {
			cma = request.getParameter("cma");
		}
		String pregnant = "";
		if (request.getParameter("pregnant") != null) {
			pregnant = request.getParameter("pregnant");
		}
		String diabetic = "";
		if (request.getParameter("diabetic") != null) {
			diabetic = request.getParameter("diabetic");
		}
		String oci = "";
		if (request.getParameter("oci") != null) {
			oci = request.getParameter("oci");
		}
		String lfi = "";
		if (request.getParameter("lfi") != null) {
			lfi = request.getParameter("lfi");
		}
		String fluid = "";
		if (request.getParameter("fluid") != null) {
			fluid = request.getParameter("fluid");
		}
		String omt = "";
		if (request.getParameter("omt") != null) {
			omt = request.getParameter("omt");
		}
		String mw = "";
		if (request.getParameter("mw") != null) {
			mw = request.getParameter("mw");
		}
		String group = "";
		if (request.getParameter("group") != null) {
			group = request.getParameter("group");
		}
		String inr = "";
		if (request.getParameter("inr") != null) {
			inr = request.getParameter("inr");
		}
		String bcm = "";
		if (request.getParameter("bcm") != null) {
			bcm = request.getParameter("bcm");
		}
		String bpr = "";
		if (request.getParameter("bpr") != null) {
			bpr = request.getParameter("bpr");
		}
		String eip = "";
		if (request.getParameter("eip") != null) {
			eip = request.getParameter("eip");
		}
		String dental = "";
		if (request.getParameter("dental") != null) {
			dental = request.getParameter("dental");
		}
		String pos = "";
		if (request.getParameter("pos") != null) {
			pos = request.getParameter("pos");
		}
		String sa = "";
		if (request.getParameter("sa") != null) {
			sa = request.getParameter("sa");
		}
		String removal = "";
		if (request.getParameter("removal") != null) {
			removal = request.getParameter("removal");
		}
		String opSitePrep = "";
		if (request.getParameter("opSitePrep") != null) {
			opSitePrep = request.getParameter("opSitePrep");
		}
		String glasses = "";
		if (request.getParameter("glasses") != null) {
			glasses = request.getParameter("glasses");
		}
		String hearing = "";
		if (request.getParameter("hearing") != null) {
			hearing = request.getParameter("hearing");
		}
		String passUrine = "";
		if (request.getParameter("passUrine") != null) {
			passUrine = request.getParameter("passUrine");
		}
		String daaa = "";
		if (request.getParameter("daaa") != null) {
			daaa = request.getParameter("daaa");
		}
		String risk = "";
		if (request.getParameter("risk") != null) {
			risk = request.getParameter("risk");
		}

		Box box = HMSUtil.getBox(request);

		OtPreOperativeCheckList otConsent = new OtPreOperativeCheckList();
		otConsent.setNiddm(niddm);
		otConsent.setIddm(iddm);
		otConsent.setTemp(temp);
		otConsent.setPulse(pulse);
		otConsent.setBp(bp);
		otConsent.setWeight(wt);
		otConsent.setHeight(ht);
		otConsent.setProcConsentFormStatus(pcfc);
		otConsent.setIssMarkedBySurgeon(issm);
		otConsent.setAllergyStatus(asd);
		otConsent.setXrayImagingPacs(xraydtl);
		// otConsent.setInfectionAlerts(ia);
		otConsent.setCytoMediAdminSevenDays(cma);
		otConsent.setPregnant(pregnant);
		otConsent.setDiabeticStatus(diabetic);
		otConsent.setOtherChronicalIllness(oci);
		otConsent.setLastFoodIntake(lfi);
		otConsent.setLastFluidIntake(fluid);
		otConsent.setOtherMedicationTaken(omt);
		otConsent.setMedicationWithheld(mw);
		otConsent.setBlooodGroup(group);
		otConsent.setInr(inr);
		otConsent.setBloodCrossMatch(bcm);
		otConsent.setBloodProductRefusal(bpr);
		otConsent.setExistingImplant(eip);
		otConsent.setRespiratoryRate(resp);
		otConsent.setInfectionAlerts(ia);// (inr)
		otConsent.setCapsCrownLooseTeethDamageDocumneted(cma);
		otConsent
				.setIntraOperativeSurgeryStatus(intra_operative_surgery_status);
		otConsent.setPreOpShower(pos);
		otConsent.setSurgicalAttire(sa);
		otConsent.setRemoval(removal);
		otConsent.setOperationSitePrepared(opSitePrep);
		otConsent.setGlasses(glasses);
		otConsent.setHearingAid(hearing);
		otConsent.setPassedUrine(passUrine);
		otConsent.setDiffAirwayAspiratinAvl(daaa);
		otConsent.setRisk(risk);

		Patient pat = new Patient();
		pat.setId(hinId);
		otConsent.setHin(pat);
		MasHospital hospital = new MasHospital();
		hospital.setId(1);
		otConsent.setHospital(hospital);
		map = otHandlerService.submitPreOTCheckList(otConsent, box);
		String jsp = "";
		jsp = "ot_patientSearchForPreOperative" + ".jsp";
		String message = "Data Added Successfully!!";
		map.put("message", message);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView showOtSignoutList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";

		try {
			if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
			{
				mapForDS.put(HIN_NO, request.getParameter("uhid"));
			}
			
			if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
			}
			
			if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
			{
				mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
			}
			
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
			{
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}
			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
			}
			
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (request.getParameter(HIN_NO) != null
//				|| request.getParameter(P_FIRST_NAME) != null
//				|| request.getParameter(P_MIDDLE_NAME) != null
//				|| request.getParameter(P_LAST_NAME) != null) {
//			patientMap = otHandlerService.searchOtSignoutList(mapForDS);
//		}
		patientMap = otHandlerService.searchOtSignoutList(mapForDS);
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearchForSignOut" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// setter Methods for Billing
	public ModelAndView showOtSignoutListEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		int hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		int userId = (Integer) session.getAttribute(USER_ID);
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		
		//String hinNo = request.getParameter("hinNo");
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
//		mapForDS.put("hinNo", hinNo);
		mapForDS.put("bookingId", bookingId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put(USER_ID, userId);

		try {
			map = otHandlerService.showOtSignoutListEntryJsp(mapForDS);
			jsp = "OT_SignOutDetails";

			jsp += ".jsp";
			// map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitOtSignOutEntryJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		int userId=(Integer)session.getAttribute(USER_ID);
		int bookingId=0;
		String ipNo="";
		String wardName="";
		if (request.getParameter("bookingId") != null
				&& !request.getParameter("bookingId").equals("")) {
			bookingId = Integer.parseInt(request
					.getParameter("bookingId"));
		}
		String name_of_operative_proc = "";
		if (request.getParameter("name_of_operative_proc") != null
				&& !request.getParameter("name_of_operative_proc").equals("")) {
			name_of_operative_proc = request
					.getParameter("name_of_operative_proc");
		}
		String spec_identified_and_labeled = "";
		if (request.getParameter("spec_identified_and_labeled") != null
				&& !request.getParameter("spec_identified_and_labeled").equals(
						"")) {
			spec_identified_and_labeled = request
					.getParameter("spec_identified_and_labeled");
		}
		String any_equip_prob_address = "";
		if (request.getParameter("any_equip_prob_address") != null
				&& !request.getParameter("any_equip_prob_address").equals("")) {
			any_equip_prob_address = request
					.getParameter("any_equip_prob_address");
		}
		String key_concern_for_recovery = "";
		if (request.getParameter("key_concern_for_recovery") != null
				&& !request.getParameter("key_concern_for_recovery").equals("")) {
			key_concern_for_recovery = request
					.getParameter("key_concern_for_recovery");
		}
		Box box = HMSUtil.getBox(request);
		if(box.getString("ipNo")!=null){
			ipNo=box.getString("ipNo");
		}
		if(box.getString("wardName")!=null){
			wardName=box.getString("wardName");
		}
		int counter = 0;
		List<String> issueQtyAndBatchList = new ArrayList<String>();// array1

		List<String> itemIdList = new ArrayList<String>();// totalQuantityRequested
		counter = Integer.parseInt(request.getParameter("hiddenValue"));
		OtSignOut otSignOut = new OtSignOut();
		otSignOut.setAnyEquipProblem(any_equip_prob_address);
		otSignOut.setKeyConcernForRecovery(key_concern_for_recovery);
		otSignOut.setNameOfOperativeProcedure(name_of_operative_proc);
		otSignOut.setSpecimenIdentified(spec_identified_and_labeled);
		int hinId = 0;
		if (request.getParameter("hinId") != null
				&& !request.getParameter("hinId").equals("")) {
			Patient pat = new Patient();
			pat.setId(Integer.parseInt(request.getParameter("hinId")));
			otSignOut.setHin(pat);
		}
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalId);
		otSignOut.setHospital(hospital);
		Users users=new Users();
		users.setId(userId);
		otSignOut.setLastChgBy(users);
		otSignOut.setLastChgDate(new Date());
		OtBooking otBooking=new OtBooking();    //Added by Srikanth 12/09/2017
		otBooking.setId(bookingId);
		otSignOut.setOtBooking(otBooking);
		hinId = Integer.parseInt(request.getParameter("hinId"));
		map = otHandlerService.submitOtSignOutEntryJsp(otSignOut, bookingId);
		int otSignOutId = otSignOut.getId();
		if (counter > 0) {
			for (int i = 1; i <= counter; i++) {
				OtSignOutItemConsume otSignItemConsume = new OtSignOutItemConsume();
				otSignItemConsume.setQtyUsed(request.getParameter("qty" + i));

				String itemName = request.getParameter("itemName" + i);
				int itemId = 0;
				itemId = otHandlerService.getItemId(itemName);
				MasStoreItem item = new MasStoreItem();
				item.setId(itemId);
				otSignItemConsume.setItem(item);
				OtSignOut otSignOut2 = new OtSignOut();
				otSignOut2.setId(otSignOutId);
				otSignItemConsume.setOtSignOut(otSignOut2);

				map = otHandlerService
						.submitOtSignOutEntryJsp(otSignItemConsume);
			}
		}
		
		map.put("ipNo", ipNo);
		map.put("wardName", wardName);
		String jsp = "";
		String message = "Data Added Successfully!! <br /> Do you wish to print??";
		jsp = "messageForOtSignOut" + ".jsp";
		map.put("message", message);
		map.put("otSignOutId", otSignOutId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printotSignOut(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;

		// String returnNumber = null;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String hospitalName = "";
		String address = "";
		int otSignOutId = 0;
		String surgeryRefDoc="";
		String ipNo="";
		String wardName="";
		if(session.getAttribute("SurgeryRefDoc")!=null&&session.getAttribute("SurgeryRefDoc")!=""){
			surgeryRefDoc=(String)session.getAttribute("SurgeryRefDoc");
			session.setAttribute(surgeryRefDoc, "");
		}
		map = otHandlerService.getHospitalName(hospitalId);
		if (map.get("hospitalName") != null
				&& !map.get("hospitalName").equals("")) {
			hospitalName = (String) map.get("hospitalName");
		}
		if (map.get("address") != null && !map.get("address").equals("")) {
			address = (String) map.get("address");
		}
		requestParameters.put("address", address);
		requestParameters.put("hospitalName", hospitalName);
		try {
			if (request.getParameter("otSignOutId") != null
					&& !(request.getParameter("otSignOutId").equals(""))) {

				otSignOutId = Integer.parseInt(request
						.getParameter("otSignOutId"));
				requestParameters.put("signOutId", otSignOutId);

			}
			if(request.getParameter("ipNo")!=null){
				ipNo=request.getParameter("ipNo");
			}
			if(request.getParameter("wardName")!=null){
				wardName=request.getParameter("wardName");
			}
			String surgeryDoctors=otHandlerService.getSurgeryDoctors(otSignOutId);
			requestParameters.put("DoneByDoc", surgeryDoctors);
			requestParameters.put("surgeryRefDoc", surgeryRefDoc);
			requestParameters.put("ipNo", ipNo);
			requestParameters.put("wardName", wardName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		requestParameters.put("SUBREPORT_DIR",
				getServletContext().getRealPath("/Reports//"));
		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		HMSUtil.generateReport("sign_out",
				requestParameters, (Connection) connectionMap.get("con"),
				response, getServletContext());
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView printintraOp(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		byte[] bytes = null;

		String returnNumber = null;
		HttpSession session = request.getSession();
		int hospitalId = (Integer) session.getAttribute("hospitalId");
		String hospitalName = "";
		String address = "";
		int intraOpId = 0;
		map = otHandlerService.getHospitalName(hospitalId);
		if (map.get("hospitalName") != null
				&& !map.get("hospitalName").equals("")) {
			hospitalName = (String) map.get("hospitalName");
		}
		if (map.get("address") != null && !map.get("address").equals("")) {
			address = (String) map.get("address");
		}
		requestParameters.put("address", address);
		requestParameters.put("hospitalName", hospitalName);
		try {
			if (request.getParameter("intraOpId") != null
					&& !(request.getParameter("intraOpId").equals(""))) {

				intraOpId = Integer.parseInt(request.getParameter("intraOpId"));
				requestParameters.put("intraOpId", intraOpId);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Object> connectionMap = otHandlerService
				.getConnectionForReport();
		try {
			bytes = JasperRunManager.runReportToPdf(
					getCompiledReport("intra_op"), requestParameters,
					(Connection) connectionMap.get("con"));

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
		return null;
	}

	public ModelAndView showIntraOperativeCheckList(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		// String serviceNo = "";
		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";

		try {
			if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
			{
				mapForDS.put(HIN_NO, request.getParameter("uhid"));
			}
			
			if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
			}
			
			if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
			{
				mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
			}
			
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
			{
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}
			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
				mapForDS.put("otProcedure" , otProcedure);
			}
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (request.getParameter(HIN_NO) != null
//				// || request.getParameter(SERVICE_NO) != null
//				|| request.getParameter(P_FIRST_NAME) != null
//				|| request.getParameter(P_MIDDLE_NAME) != null
//				|| request.getParameter(P_LAST_NAME) != null) {
//			patientMap = otHandlerService
//					.searchIntraOperativeCheckList(mapForDS);
//		}
		patientMap = otHandlerService.searchIntraOperativeCheckList(mapForDS);
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearchForIntraOperativeTimeOut" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	// setter Methods for Billing
	public ModelAndView showIntraOperativeCheckListEntryJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		//String hinNo = request.getParameter("hinNo");
		String yearlySerialNo = "";
		if (request.getParameter("yearlySerialNo") != null) {
			yearlySerialNo = request.getParameter("yearlySerialNo");
			mapForDS.put("yearlySerialNo", yearlySerialNo);
		}
		
		int bookingId = Integer.parseInt(request.getParameter("bookingId"));
		//mapForDS.put("hinNo", hinNo);
		mapForDS.put("bookingId", bookingId);
		mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		try {
			map = otHandlerService
					.showIntraOperativeCheckListEntryJsp(mapForDS);
			jsp = "OT_IntraOperativeDetails.jsp";

			// jsp += ".jsp";
			// map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}

	public ModelAndView submitIntrOperatioveForOt(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		int hospitalid=(Integer)session.getAttribute(HOSPITAL_ID);
		int bookingId = 0;
		int hinId = 0;
		String confirmAll = "";
		int surgeonId = 0;
		int anestheticId = 0;
		int nurseId = 0;
		int assisstantId = 0;
		String identity = "";
		String proc_site = "";
		String consent_confrm = "";
		String site_mark = "";
		String ralavant_image = "";
		String surgical_pos = "";
		String equip_concern = "";
		String anticipated_critical_event = "";
		String critical_steps = "";
		String case_duration = "";

		String blood_loss = "";

		String antibiotic_prophylaxis = "";

		String additional_concern = "";

		String sterlization_indicator = "";
		String ster_additional_concern = "";
		String procSiteConfirm = "";
		if (request.getParameter("bookingId") != null) {
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		}
		
		if (request.getParameter("hinId") != null) {
			hinId = Integer.parseInt(request.getParameter("hinId"));
		}

		if (request.getParameter("Procedure") != null) {
			procSiteConfirm = request.getParameter("Procedure");
		}

		if (request.getParameter("surgeonId") != null
				&& !request.getParameter("surgeonId").equals(" ")) {
			surgeonId = Integer.parseInt(request.getParameter("surgeonId"));
		}
		if (request.getParameter("anestheticId") != null
				&& !request.getParameter("anestheticId").equals(" ")) {
			anestheticId = Integer.parseInt(request
					.getParameter("anestheticId"));
		}
		if (request.getParameter("nurseId") != null
				&& !request.getParameter("nurseId").equals(" ")) {
			nurseId = Integer.parseInt(request.getParameter("nurseId"));
		}
		if (request.getParameter("assisstantId") != null
				&& !request.getParameter("assisstantId").equals(" ")) {
			assisstantId = Integer.parseInt(request
					.getParameter("assisstantId"));
		}

		if (request.getParameter("confirmAll") != null) {
			confirmAll = request.getParameter("confirmAll");
		}
		if (request.getParameter("identity") != null) {
			identity = request.getParameter("identity");
		}
		if (request.getParameter("proc_site") != null) {
			proc_site = request.getParameter("proc_site");
		}
		if (request.getParameter("consent_confrm") != null) {
			consent_confrm = request.getParameter("consent_confrm");
		}
		if (request.getParameter("site_mark") != null) {
			site_mark = request.getParameter("site_mark");
		}
		if (request.getParameter("ralavant_image") != null) {
			ralavant_image = request.getParameter("ralavant_image");
		}
		if (request.getParameter("surgical_pos") != null) {
			surgical_pos = request.getParameter("surgical_pos");
		}
		if (request.getParameter("equip_concern") != null) {
			equip_concern = request.getParameter("equip_concern");
		}
		if (request.getParameter("anticipated_critical_event") != null) {
			anticipated_critical_event = request
					.getParameter("anticipated_critical_event");
		}
		if (request.getParameter("critical_steps") != null) {
			critical_steps = request.getParameter("critical_steps");
		}
		if (request.getParameter("case_duration") != null) {
			case_duration = request.getParameter("case_duration");
		}
		if (request.getParameter("blood_loss") != null) {
			blood_loss = request.getParameter("blood_loss");
		}
		if (request.getParameter("antibiotic_prophylaxis") != null) {
			antibiotic_prophylaxis = request
					.getParameter("antibiotic_prophylaxis");
		}
		if (request.getParameter("additional_concern") != null) {
			additional_concern = request.getParameter("additional_concern");
		}
		OtIntraOperativeTimeOut SSS = new OtIntraOperativeTimeOut();
		// if(confirmAll.equalsIgnoreCase("Y")){

		if (anestheticId != 0) {
			MasEmployee emp = new MasEmployee();
			emp.setId(anestheticId);
			SSS.setAnesthetic(emp);
		}
		if (assisstantId != 0) {
			MasEmployee assisstant = new MasEmployee();
			assisstant.setId(assisstantId);
			SSS.setAssisstant(assisstant);
		}
		SSS.setConfirmAll(confirmAll);
		if (nurseId != 0) {
			MasEmployee nurse = new MasEmployee();
			nurse.setId(nurseId);
			SSS.setNurse(nurse);
		}
		if (surgeonId != 0) {
			MasEmployee surgeon = new MasEmployee();
			surgeon.setId(surgeonId);
			SSS.setSurgeon(surgeon);
		}
		// }
		SSS.setAdditionalConcern(additional_concern);
		SSS.setAntibioticProphylaxis(antibiotic_prophylaxis);
		SSS.setAnticipatedCriticalEvent(anticipated_critical_event);

		SSS.setBloodLoss(blood_loss);
		SSS.setCaseDuration(case_duration);
		SSS.setConsentConfrm(consent_confrm);
		SSS.setCriticalSteps(critical_steps);
		SSS.setEquipConcern(equip_concern);
		SSS.setIdentityConfirm(identity);

		Patient patient = new Patient();
		patient.setId(hinId);
		SSS.setHin(patient);
		MasHospital hospital=new MasHospital();
		hospital.setId(hospitalid);
		SSS.setHospital(hospital);
		
		SSS.setProcSiteConfrm(proc_site);
		SSS.setProcedureConfirm(procSiteConfirm);
		SSS.setRalavantImage(ralavant_image);
		SSS.setSiteMark(site_mark);
		SSS.setSterAdditionalConcern(ster_additional_concern);
		SSS.setSterlizationIndicator(sterlization_indicator);
		SSS.setSurgicalPos(surgical_pos);
		SSS.setSignOutStatus("n");
		
		// Added By Srikanth 03/10/2017
		List<Integer> surgeonsList=new ArrayList<Integer>();
		List<String> roleList=new ArrayList<String>();
		int surgeonsCount=0;
		if(request.getParameter("hiddenValue")!=null){
			surgeonsCount=Integer.parseInt(request.getParameter("hiddenValue"));
		}
		int surgeonEmpId=0;
		String surgeonRole="";
		for(int i=0;i<=surgeonsCount;i++){
			if(request.getParameter("surgeonName" + i)!=null && !request.getParameter("surgeonName" + i).equals("")){
				OtBookSurgeon otSurgeon=new OtBookSurgeon();
				MasEmployee employee=new MasEmployee();
				String surgeon=request.getParameter("surgeonName" + i);
				int index1 = surgeon.lastIndexOf("[");
				int index2 = surgeon.lastIndexOf("]");
				if(index1>=0 ){
					index1++;
					surgeonEmpId = Integer.parseInt(surgeon.substring(index1,index2));
					surgeonsList.add(surgeonEmpId);
				}
				surgeonRole=request.getParameter("role" + i);
				roleList.add(surgeonRole);
			}
			
		}
       Map<String,Object> dataMap=new HashMap<String,Object>();
       dataMap.put("surgeonsList", surgeonsList);
       dataMap.put("roleList", roleList);
		map = otHandlerService.submitIntrOperatioveForOt(SSS, bookingId,dataMap);
		int intraOpId = 0;
		intraOpId = SSS.getId();
		/*String jsp = "";
		message = "Data Added Successfully!! <br /> Do you wish to print??";
		jsp = "messageForOtIntraForm" + ".jsp";*/
		mapForDS.put(HOSPITAL_ID, hospitalid);
		patientMap = otHandlerService.searchIntraOperativeCheckList(mapForDS);
		message = "Data Added Successfully!!";
		String jsp = "";
		jsp = "ot_patientSearchForIntraOperativeTimeOut" + ".jsp";
		map.put("message", message);
		map.put("intraOpId", intraOpId);
		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}

	@SuppressWarnings("unused")
	public ModelAndView getOtTime(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String departmentIdField = "";
		String chargeName = "";
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		try {
			if (request.getParameter("chargeName") != null) {
				chargeName = request.getParameter("chargeName");
			}
			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("userName", userName);
			map.put("chargeName", chargeName);
			map1 = otHandlerService.getOtTime(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "otTimeResponseJsp";

		return new ModelAndView(jsp, "map", map1);
	}

	@SuppressWarnings("unused")
	public ModelAndView getChargeCodeListForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String itemNameField = "";
		int deptId = 0;
		String departmentIdField = "";
		String autoHint = "";
		int otId = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map1 = new HashMap<String, Object>();

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}

			if (request.getParameter("otId") != null) {
				otId = Integer.parseInt(request.getParameter("otId"));
			}

			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}

			if (request.getParameter("deptId") != null) {
				deptId = Integer.parseInt(request.getParameter("deptId"));
			}
			map.put("userName", userName);
			map.put("autoHint", autoHint);
			map.put("deptId", deptId);
			map.put("otId", otId);
			map1 = otHandlerService.getInvestigationListForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = OT_SURGERY_RESPONSE_JSP;

		return new ModelAndView(jsp, "map", map1);
	}

	public ModelAndView getStoreConsumableItemForAutoComplete(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		String itemNameField = "";
		String autoHint = "";
		Map<String, Object> map = new HashMap<String, Object>();
		int hospitalId=0;
		if(session.getAttribute(HOSPITAL_ID)!=null)
		{
			hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		}

		try {
			if (request.getParameter("requiredField") != null) {
				itemNameField = (request.getParameter("requiredField"));
			}
			if (request.getParameter(itemNameField) != null) {
				autoHint = (request.getParameter(itemNameField));
			}
			map.put("autoHint", autoHint);
			map.put("hospitalId", hospitalId);
			map = otHandlerService.getStoreConsumableItemForAutoComplete(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsp = "ot_responseForPvmsNoConsumable";
		return new ModelAndView(jsp, "map", map);
	}
 
	 //By Vishnu
	public ModelAndView waitingList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		String date = "";
		int depart = 0;
		String unit = "";
		String hinNo = "";
		String IPNo = "";
		String pname = "";
		int deptId = 0;
		String ot="";
		String surgeonName="";
		int page = 1;
		Date appointmentDate = null;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
		 if(request.getParameter("page") != null){
	            page = Integer.parseInt(request.getParameter("page"));    
		 }
		 mapForDS.put("page", page);
		if(request.getParameter("pname") !=null && !request.getParameter("pname").equals("")){
			pname = request.getParameter("pname");
			mapForDS.put("pname1", pname);
		}
		/*if(request.getParameter("unit") !=null && !request.getParameter("unit").equals("")){
			unit = request.getParameter("unit");
			mapForDS.put("unit", unit);
		}*/
		if(request.getParameter("hinNo") !=null && !request.getParameter("hinNo").equals("")){
			hinNo = request.getParameter("hinNo");
			mapForDS.put("hinNo", hinNo);
		}
		if(request.getParameter(APPOINTMENT_DATE) !=null && !request.getParameter(APPOINTMENT_DATE).equals("")){
			appointmentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(APPOINTMENT_DATE));
			mapForDS.put("appointmentDate", appointmentDate);
		}
		if(request.getParameter("department") !=null && !request.getParameter("department").equals("")){
			depart = Integer.parseInt(request.getParameter("department"));
			mapForDS.put("depart", depart);
		}
		if(request.getParameter("ipno") !=null && !request.getParameter("ipno").equals("")){
			IPNo = request.getParameter("ipno");
			mapForDS.put("IPNo", IPNo);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);	
		map = otHandlerService.showWaitingListForSurgery(mapForDS);

		jsp = "waiting_list_for_surgery";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	 }
	
	public ModelAndView showOtStatus(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int surgeryId=0;
		int deptId=0;
		int empId=0;
		int month=0;
		int year=0;
		String surgeonName="";
		Calendar calendar=Calendar.getInstance();

		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (session.getAttribute(DEPT_ID) != null) {
			deptId = (Integer) session.getAttribute(DEPT_ID);
		}
		if (session.getAttribute("empId") != null) {
			empId = (Integer) session.getAttribute("empId");
		}
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		

		if(request.getParameter("surgeryId") !=null){
			surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
		}
		if(request.getParameter("month") !=null){
			month = Integer.parseInt(request.getParameter("month"));
		}
		else
		{
			month=calendar.get(Calendar.MONTH);
		}
		if(request.getParameter("year") !=null){
			year = Integer.parseInt(request.getParameter("year"));
		}
		else
		{
			year=calendar.get(Calendar.YEAR);
		}

		
		mapForDS.put("empId", empId);
		mapForDS.put(DEPT_ID, deptId);
		mapForDS.put(HOSPITAL_ID, hospitalId);
		mapForDS.put("surgeryId", surgeryId);
		mapForDS.put("month", month);
		mapForDS.put("year", year);

		map = otHandlerService.showCalenderForOt(mapForDS);

		jsp = "otschedule";
		jsp += ".jsp";
		title = "Ot Schedule";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("month", month);
		map.put("year", year);
		map.put("surgeryId", surgeryId);
		return new ModelAndView("index", "map", map);
	 }
	public ModelAndView showAllergy(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int requestId=0;
		Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getParameter("requestId")!=null){
			requestId = Integer.parseInt(""+request.getParameter("requestId"));
		}
		map = otHandlerService.showAllergy(box, dataMap);
//for check request from Landing Page
		if(box.getString("LP").trim().equalsIgnoreCase("y"))
			map.put("LP", true);
		  
		
		jsp = "allergyList";
		map.put("contentJsp", jsp);
		map.put("requestId", requestId);
		return new ModelAndView(jsp, "map", map);
	}
	public void getSurgeryInfoForPatient (HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		/*List objectList = new ArrayList();*/
		int inaptientId=0;
		if(request.getParameter("inaptientId")!=null){
			inaptientId=Integer.parseInt(request.getParameter("inaptientId"));
		}
		
		dataMap.put("inaptientId", inaptientId);

		List<OtBooking> bookingList = new ArrayList<OtBooking>();
		map = otHandlerService.getSurgeryInfoForPatient(inaptientId);
		boolean matched=false;
		bookingList = (List) map.get("bookingList");
		if(bookingList.size()>0){
			matched=true;
		}
		System.out.println("matched--->>>"+matched);
		StringBuffer sb = new StringBuffer();
		sb.append("<item>");
		sb.append("<surgeryString>" + matched + "</surgeryString>");
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
	public ModelAndView showOpSurgeryPlanningJsp(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		int hinId=0;
		int inpatientId=0;
		int visitId=0;
		List<Inpatient>ipList=new ArrayList<Inpatient>();
		System.out.println("parent-->"+request.getParameter("parent"));
		if(request.getParameter("parent")!=null){
			inpatientId=Integer.parseInt(request.getParameter("parent"));
			ipList=otHandlerService.getHinId(inpatientId);
		}else if(request.getParameter("hinId")!=null){
			hinId=Integer.parseInt(request.getParameter("hinId"));
		} 
		if(request.getParameter("visitId")!=null){
			visitId=Integer.parseInt(request.getParameter("visitId"));
		}
		
		Map<String,Object>mapForDS=new HashMap<String,Object>();

		mapForDS.put("hospitalId", hospitalId);
		mapForDS.put("hinId", hinId);
		
		map = otHandlerService.showOpSurgeryPlanningJsp(mapForDS);
		map.put("ipList",ipList);
		System.out.println("ipList.size() --->>"+ipList.size());
		map.put("visitId", visitId);
		jsp = "opSurgeryPlanning";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
		// return null;
	}
	public ModelAndView getUnitDays(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String,Object>mapForDS=new HashMap<String,Object>();
		mapForDS.put("hospitalId", hospitalId);
		int unitId=0;
		if(request.getParameter("unitNmae")!=null){
			unitId=Integer.parseInt(request.getParameter("unitNmae"));
		}
		int hinId=0;
		if(request.getParameter("hinId")!=null){
			hinId=Integer.parseInt(request.getParameter("hinId"));
		}
		map = otHandlerService.getUnitDays(unitId);
		jsp = "opSurgeryPlanning2";
		//jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hinId",hinId);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}
	public ModelAndView  getBookingDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Map<String,Object>mapForDS=new HashMap<String,Object>();
		mapForDS.put("hospitalId", hospitalId);
		int unitId=0;
		if(request.getParameter("unitNmae")!=null){
			unitId=Integer.parseInt(request.getParameter("unitNmae"));
		}
		String dayName="";
		if(request.getParameter("dayName")!=null){
			dayName=(request.getParameter("dayName"));
		}
		Date bookingDate=new Date();
		if(request.getParameter("bookingDate")!=null){
			bookingDate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("bookingDate"));
		}
		int hinId=0;
		if(request.getParameter("hinId")!=null){
			hinId=Integer.parseInt(request.getParameter("hinId"));
		}
		map = otHandlerService.getBookingDetails(hospitalId,unitId,dayName,bookingDate);
		jsp = "opSurgeryPlanningForBooking";
		//jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("hinId",hinId);
		return new ModelAndView(jsp, "map", map);
		// return null;
	}
	public ModelAndView updateForOtBooking(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		Box box = HMSUtil.getBox(request);
		Vector prescStatus=box.getVector("canPrescStatus");
		Vector detailPrescId=box.getVector("detailPrescId");
		Vector SurgeryDate=box.getVector("surgerydate");
		int dtId=0;
		Date SurgeryDate2=new Date();
		for (int i = 0; i < prescStatus.size(); i++) {
			String prescStatus1 = "";
			if (prescStatus.get(i) != null && !prescStatus.get(i).equals("")) {
				prescStatus1 = (prescStatus.get(i).toString());
			}
			if(prescStatus1.equals("y")){
				if(detailPrescId.get(i)!=null && !detailPrescId.get(i).equals("") && !detailPrescId.get(i).equals("0")){
				dtId=Integer.parseInt(detailPrescId.get(i).toString());
				}
				if(SurgeryDate.get(i)!=null && !SurgeryDate.get(i).equals("") && !SurgeryDate.get(i).equals("0")){
					SurgeryDate2=HMSUtil.convertStringTypeDateToDateType(SurgeryDate.get(i).toString());
					}
			boolean cancelled=false;
			System.out.println("in if --->>"+dtId);
			cancelled=otHandlerService.cancelServiceInv(dtId,SurgeryDate2);
			String message="";
			if(cancelled==true){
				message="Reschedule/Cancelled Successfully!!";
			}else{
				message="Try Agaian!!";
			}
			}
			
		}
		if(box.getString("canPrescStatus")!=null){
		
		}
		int hinId=0;
		 if(request.getParameter("hinId")!=null){
				hinId=Integer.parseInt(request.getParameter("hinId"));
			} 
			
			
			Map<String,Object>mapForDS=new HashMap<String,Object>();

			mapForDS.put("hospitalId", hospitalId);
			mapForDS.put("hinId", hinId);
			map = otHandlerService.showOpSurgeryPlanningJsp(mapForDS);
		jsp = "opSurgeryPlanning";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("message",message);
		//map.put("hinId",hinId);
		return new ModelAndView("index", "map", map);
		// return null;
	}
	
	// added by amit das on 22-09-2016
	public ModelAndView showSurgerySafetyCheckWaitngListJsp(HttpServletRequest request,
					HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		String otProcedure = null;
		String jsp = null;
		
			if(request.getParameter("uhid")!=null && !request.getParameter("uhid").trim().equals(""))
				mapForDS.put(HIN_NO, request.getParameter("uhid"));
			
			if(request.getParameter("pname")!=null && !request.getParameter("pname").trim().equals(""))
				mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
			
			if(request.getParameter("ipno")!=null && !request.getParameter("ipno").trim().equals(""))
				mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
			
			if(request.getParameter("gender")!=null && !request.getParameter("gender").trim().equals("") && !request.getParameter("gender").equals("0"))
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
		
			if(request.getParameter("otProcedure")!=null && !request.getParameter("otProcedure").trim().equals(""))
				mapForDS.put("otProcedure", request.getParameter("otProcedure"));
			
			if(session.getAttribute(HOSPITAL_ID)!=null)
				mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		
		patientMap = otHandlerService.searchSurgerySafetyCheckList(mapForDS);
		map.put("otProcedure", otProcedure);
		jsp = "ot_patientSearchForSurgerySafetyCheckList" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
		
	}
	
	// added by amit das on 22-09-2016
	public ModelAndView showSurgerySafetyCheckListJsp(HttpServletRequest request,
				HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
		int deptId = 0;
		String hinNo = null;
		int bookingId = 0; 
				
		if(session.getAttribute("deptId")!=null)
			deptId = (Integer) session.getAttribute("deptId");
		
		if(request.getParameter("hinNo")!=null && !request.getParameter("hinNo").trim().equals(""))
			hinNo = request.getParameter("hinNo");
		
		if(request.getParameter("bookingId")!=null && !request.getParameter("bookingId").trim().equals(""))
			bookingId = Integer.parseInt(request.getParameter("bookingId"));
		
		
		mapForDS.put("hinNo", hinNo);
		mapForDS.put("bookingId", bookingId);

		try {
			map = otHandlerService.showSurgerySafetyCheckListJsp(mapForDS);
			jsp = "surgerySafetyChecklist";

			jsp += ".jsp";
			// map.put("yearlySerialNo", yearlySerialNo);
			map.put("deptId", deptId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	// added by amit das on 22-09-2016
	public ModelAndView submitSurgerySafetyCheckList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = null;
		HttpSession session = request.getSession(); 
		Box box = HMSUtil.getBox(request);
		
		int hospitalId = 0;
		
		if(session.getAttribute("hospitalId")!=null){
				hospitalId  = 	(Integer)session.getAttribute("hospitalId");
				box.put("hospitalId",hospitalId);
		}
		
		
		map = otHandlerService.submitSurgerySafetyCheckList(box);
		
		jsp = "ot_patientSearchForSurgerySafetyCheckList";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//Added by Arbind on 14-07-2017
	public ModelAndView showMinorOtWaitingList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		String date = "";
		int depart = 0;
		String unit = "";
		String hinNo = "";
		String IPNo = "";
		String pname = "";
		int deptId = 0;
		String ot="";
		String surgeonName="";
		int page = 1;
		Date appointmentDate = null;
		
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		
		 if(request.getParameter("page") != null){
	            page = Integer.parseInt(request.getParameter("page"));    
		 }
		 mapForDS.put("page", page);
		if(request.getParameter("pname") !=null && !request.getParameter("pname").equals("")){
			pname = request.getParameter("pname");
			mapForDS.put("pname1", pname);
		}
		/*if(request.getParameter("unit") !=null && !request.getParameter("unit").equals("")){
			unit = request.getParameter("unit");
			mapForDS.put("unit", unit);
		}*/
		if(request.getParameter("hinNo") !=null && !request.getParameter("hinNo").equals("")){
			hinNo = request.getParameter("hinNo");
			mapForDS.put("hinNo", hinNo);
		}
		if(request.getParameter(APPOINTMENT_DATE) !=null && !request.getParameter(APPOINTMENT_DATE).equals("")){
			appointmentDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(APPOINTMENT_DATE));
			mapForDS.put("appointmentDate", appointmentDate);
		}
		if(request.getParameter("department") !=null && !request.getParameter("department").equals("")){
			depart = Integer.parseInt(request.getParameter("department"));
			mapForDS.put("depart", depart);
		}
		if(request.getParameter("ipno") !=null && !request.getParameter("ipno").equals("")){
			IPNo = request.getParameter("ipno");
			mapForDS.put("IPNo", IPNo);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);	
		map = otHandlerService.showMinorOtWaitingList(mapForDS);

		jsp = "minor_ot_surgery";
		jsp += ".jsp";
		title = "Waiting Patient List";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	 }

	//Added by Arbind on 18-07-2017
	public ModelAndView showMinorOtPatientDetails(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
        String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		 String otProcedure = "";

		try {
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			 
			if (request.getParameter(P_FIRST_NAME) != null
					&& !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientFName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientFName", patientFName);
			}
			if (request.getParameter(P_MIDDLE_NAME) != null
					&& !(request.getParameter(P_MIDDLE_NAME).equals(""))) {
				patientMName = request.getParameter(P_MIDDLE_NAME);
				mapForDS.put("patientMName", patientMName);
			}
			if (request.getParameter(P_LAST_NAME) != null
					&& !(request.getParameter(P_LAST_NAME).equals(""))) {
				patientLName = request.getParameter(P_LAST_NAME);
				mapForDS.put("patientLName", patientLName);
			}
			 if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
				mapForDS.put("otProcedure", otProcedure);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		}
		int hospitalId = 0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		mapForDS.put(HOSPITAL_ID, hospitalId);
		if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			mapForDS.put(HIN_NO, request.getParameter("uhid"));
		}
		
		if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
		{
			mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
		}
		
		if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
		{
			mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
		}
		
		if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
		{
			mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
		}
		//mapForDS.put("box", HMSUtil.getBox(request));
		patientMap = otHandlerService.searchMinorOtPatientDetails(mapForDS);

		map.put("otProcedure", otProcedure);
		map.put("minorOt","yes");
		String jsp = "";
		jsp = "ot_patientSearch" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//Added by Arbind on 22-07-2017
	public ModelAndView showMinorOtSignoutList(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientFName = "";
		String patientMName = "";
		String patientLName = "";
		String otProcedure = "";

		try {
			if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
			{
				mapForDS.put(HIN_NO, request.getParameter("uhid"));
			}
			
			if(request.getParameter("pname")!=null && !request.getParameter("pname").equals(""))
			{
				mapForDS.put(PATIENT_NAME, request.getParameter("pname"));
			}
			
			if(request.getParameter("ipno")!=null && !request.getParameter("ipno").equals(""))
			{
				mapForDS.put(RequestConstants.AD_NO, request.getParameter("ipno"));
			}
			
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("") && !request.getParameter("gender").equals("0"))
			{
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}
			if (request.getParameter("otProcedure") != null
					&& !(request.getParameter("otProcedure").equals(""))) {
				otProcedure = request.getParameter("otProcedure");
			}
			
			mapForDS.put(HOSPITAL_ID, (Integer)session.getAttribute(HOSPITAL_ID));

		} catch (Exception e) {
			e.printStackTrace();
		}
//		if (request.getParameter(HIN_NO) != null
//				|| request.getParameter(P_FIRST_NAME) != null
//				|| request.getParameter(P_MIDDLE_NAME) != null
//				|| request.getParameter(P_LAST_NAME) != null) {
//			patientMap = otHandlerService.searchOtSignoutList(mapForDS);
//		}
		patientMap = otHandlerService.searchMinorOtSignoutList(mapForDS);
		map.put("otProcedure", otProcedure);
		String jsp = "";
		jsp = "ot_patientSearchForSignOut" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("detailsMap", detailsMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	//Added by Arbind on 27-07-2017
	public ModelAndView showUploadOtConsentLetter(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session=request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		String hinNo = "";
		String patientName = "";
		int hospitalId=(Integer)session.getAttribute(HOSPITAL_ID);
		mapForDS.put(HOSPITAL_ID, hospitalId);

		try {
			if (request.getParameter(HIN_NO) != null && !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDS.put("hinNo", hinNo);
			}
			if (request.getParameter(P_FIRST_NAME) != null && !(request.getParameter(P_FIRST_NAME).equals(""))) {
				patientName = request.getParameter(P_FIRST_NAME);
				mapForDS.put("patientName", patientName);
			}
			if(request.getParameter("gender")!=null && !request.getParameter("gender").equals("0"))
			{
				mapForDS.put(RequestConstants.GENDER , Integer.parseInt(request.getParameter("gender")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		patientMap = otHandlerService.searchOtPatientConsentLetter(mapForDS);
		String jsp = "";
		jsp = "ot_patientConsentLetter" + ".jsp";

		map.put("patientMap", patientMap);
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView uploadOtConsentLetter(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		int deptId = (Integer) session.getAttribute("deptId");
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		String hinNo = request.getParameter("hinNo");
		int inpatientId = 0;
		int visitId = 0;
		if(request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").trim().equals("")){
			inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
		}
		if(request.getParameter("visitId")!=null && !request.getParameter("visitId").trim().equals("")){
			visitId = Integer.parseInt(request.getParameter("visitId"));
		}
		mapForDS.put("hinNo", hinNo);

		try {
			map = otHandlerService.uploadOtConsentLetter(mapForDS);
			jsp = "OT_ConsentLetterStored";

			jsp += ".jsp";
			map.put("deptId", deptId);
			map.put("inpatientId", inpatientId);
			map.put("visitId", visitId);
			map.put("contentJsp", jsp);
			map.put("title", title);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView openUploadPopWindow(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int hinId=0;
		
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if(request.getParameter("hinId")!=null){
			details.put("hinId", Integer.parseInt(request.getParameter("hinId")));
	    }
		if(request.getParameter("visitId")!=null){
	       	 details.put("visitId", Integer.parseInt((String)request.getParameter("visitId")));
        }
		if(request.getParameter("inpatientId")!=null){
	       	 details.put("inpatientId", Integer.parseInt((String)request.getParameter("inpatientId")));
		}
		
		details.put("flag", "n");
		
		map = otHandlerService.uploadAndViewDocuments(details);
		String jsp = "consentUploadAndViewDocuments";

		return new ModelAndView(jsp, "map", map);
	}


	public ModelAndView uploadAndViewDocuments(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int hinId=0;
		String flag="n";	
		String uploadFrom ="NA";
		
		 MultipartFormDataRequest mrequest = null;
	     if (MultipartFormDataRequest.isMultipartFormData(request))
	        {
	             try
	             {
	                 mrequest = new MultipartFormDataRequest(request);
	             }
	             catch (UploadException e)
	             {
	                 e.printStackTrace();
	             }
	             catch (IOException e)
	             {
	                 e.printStackTrace();
	             }
	        }
	     if(mrequest.getParameter("hinId")!=null){
	    	 hinId= Integer.parseInt((String)mrequest.getParameter("hinId"));
	       	 details.put("hinId", Integer.parseInt((String)mrequest.getParameter("hinId")));
	        }
	     
	     if(mrequest.getParameter("uploadFrom")!=null){
	    	 uploadFrom= (String)mrequest.getParameter("uploadFrom");
	       	 details.put("uploadFrom", (String)mrequest.getParameter("uploadFrom"));
	        }
	     
	     if(mrequest.getParameter("visitId")!=null){
	    	
	       	 details.put("visitId", Integer.parseInt((String)mrequest.getParameter("visitId")));
	        }
	     
	     if(mrequest.getParameter("inpatientId")!=null){
	    	
	       	 details.put("inpatientId", Integer.parseInt((String)mrequest.getParameter("inpatientId")));
	        }
	     
	    
	     String filename = "";
	     String uploadURL="";
	     if(uploadFrom.equalsIgnoreCase("OPD"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/OPD/"+hinId+"/");
	     }
	     if(uploadFrom.equalsIgnoreCase("IP"))
	     {
	    	 uploadURL = getServletContext().getRealPath("/UploadedDocuments/IP/"+hinId+"/");
	     }
	    
	     String comments = "";
	     String fileExtension=null;
	     
	     if (mrequest.getParameter("department") != null) {
	 		departmentId = Integer.parseInt(request.getParameter("department"));
	 	}if (departmentId!=0) {
	 		details.put("departmentId", departmentId);
	 	}
	 	if(mrequest.getParameter("fileName")!= null){
	        filename = mrequest.getParameter("fileName");
	    }

	    
	    
	    if(mrequest.getParameter("flag")!=null){
	      	 flag = (String)mrequest.getParameter("flag");
	       }
	    details.put("flag", flag);
	    
	    if( mrequest.getParameter("comments")!= null){
	        comments = mrequest.getParameter("comments");
	        details.put("comments", comments);
	    }
	    details.put("uploadURL", uploadURL);
	    
	    if(flag.equalsIgnoreCase("y"))
	    {    
	      
	            List fileUploadedList = null;           
	            details.put("filename", filename);
	            StringTokenizer strToken=new StringTokenizer(filename,".");
	            Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	            filename=strToken.nextToken();
	            fileExtension=strToken.nextToken();
	            String whiteList = "*."+fileExtension;             
	            fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
	    }    
	         
	        
	     map = otHandlerService.uploadAndViewDocuments(details);
	     String jsp = "consentUploadAndViewDocuments";
	     String msg="File Successfuly Uploaded.";
	     //jsp += ".jsp";
	     //map.put("contentJsp", jsp);
	     map.put("message", msg);
	     
	     return new ModelAndView(jsp, "map", map);

	}
	public ModelAndView referBackPatientToOpd(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		Map<String, Object> mapForDS = new HashMap<String, Object>();
		HttpSession session  = request.getSession();
		Users users=null;
		int userId=0;
		if(session!=null){
			users = (Users)session.getAttribute("users");
			userId=users.getEmployee().getId();
		}
		int surgeryId=0;
		String submitForm="5";
		
		int flag=0;
		boolean duplicateVisitSatatus=false;
		boolean successfullyAdded = false;
		if(request.getParameter("surgeryId")!=null){
		 surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
	       }
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
		mapForDs = otHandlerService.referBackPatientToOpd(surgeryId,submitForm,userId);
		 boolean sameDayVisit=(Boolean)mapForDs.get("sameDayVisit");
		if(sameDayVisit!=true){
			
		
		String currentDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");
		Date date = HMSUtil.convertStringTypeDateToDateType(currentDate);
		  int visitId=(Integer)mapForDs.get("visitId");
		  int empId=(Integer)mapForDs.get("empId");
		  String doctorName=(String)mapForDs.get("doctorName");
		  int departmentId=(Integer)mapForDs.get("departmentId");
		  int hospitalId=(Integer)mapForDs.get("hospitalId");
		  int refferedSession=otHandlerService.getRefferedSession(departmentId,hospitalId);
		  
		  
		  
		  String hospitalCode=(String)mapForDs.get("hospitalCode");
		  String patientName=(String)mapForDs.get("patientName");
		  String hinNo=(String)mapForDs.get("hinNo");
		  String mobileNo=(String)mapForDs.get("mobileNo");
		  int hinId=(Integer)mapForDs.get("hinId");
			String referralCase=(String)mapForDs.get("referralCase");
			String referType=(String)mapForDs.get("referType");
			String admissionAdvised=(String)mapForDs.get("admissionAdvised");
			boolean episodeCloseCheck=(Boolean)mapForDs.get("episodeCloseCheck");
			String cashRecieved=(String)mapForDs.get("cashRecieved");
			int age=(Integer)mapForDs.get("age");
			int CurrentVisitNo=(Integer)mapForDs.get("CurrentVisitNo");
			int referral=1;
			mapForDS.put("referredSession", refferedSession);
			mapForDS.put("referral", referral);
			mapForDS.put("userId",userId);
			mapForDS.put("empId",empId);
			mapForDS.put("doctorName",doctorName);
			mapForDS.put("refereddoctor", users.getEmployee().getId());
			mapForDS.put("hinId",hinId);
			mapForDS.put("departmentId",departmentId);
			mapForDS.put("visitId",visitId);
			mapForDS.put("CurrentVisitNo",CurrentVisitNo);
			mapForDS.put("hospitalCode",hospitalCode);
			mapForDS.put("departmentId",departmentId);
			mapForDS.put("patientName",patientName);
			mapForDS.put("age",age);
			mapForDS.put("hinNo",hinNo);
			mapForDS.put("hospitalId",hospitalId);
			mapForDS.put("flag",flag);
			mapForDS.put("referralStatus","y");
			mapForDS.put("submitFrom",submitForm);
			mapForDS.put("cashRecieved",cashRecieved);
			mapForDS.put("onlineAppId","");
			mapForDS.put("mobileNo",mobileNo);
			mapForDS.put("referdTo", null);
			mapForDS.put("referType", referType);
			mapForDS.put("admissionAdvised", admissionAdvised);
			mapForDS.put("episodeCloseCheck", episodeCloseCheck);
			mapForDS.put("referdepartment", departmentId);
			mapForDS.put("fromDepartment", departmentId);
			mapForDS.put("referralCase", referralCase);
			mapForDS.put("referralDate",date);
			
	        map=opdHandlerService.submitOPDPatientDetails(mapForDS);
	        String msg=null;
		if(null !=map.get("duplicateVisitSatatus"))
		duplicateVisitSatatus=(Boolean)map.get("duplicateVisitSatatus");
		if(!duplicateVisitSatatus){
				if(null !=map.get("successfullyAdded")){
					successfullyAdded=(Boolean)map.get("successfullyAdded");
				}
			/*if(null !=map.get("visitId")){
				patientVisitId=(Integer)map.get("visitId");
			}
		*/
			/*OpdPatientDetails opdPatientDetails=new OpdPatientDetails();
			int visitId=0;
			visitId=visit.getId();
			Visit visit1=new Visit();
			visit1.setId(visitId);
			opdPatientDetails.setVisit(visit1);*/
			int consultingDoctorId2 =0;
			boolean queueStatus=false;
			if (successfullyAdded) {
				    msg="Successfully send to Opd....";
				   map.put("message", msg);
				  }else{
					  msg="Error in refering Patient..";
					   map.put("message", msg);
				  }
		}
		else{
			message = "Visit already created for this Department.";
		}
			
		jsp = "waiting_list_for_surgery";
		jsp += ".jsp";
		
	     map.put("contentJsp", jsp);
	     map.put("title", title);
	     map.put("message", msg);
		}else{
			String msg="Successfully send to Opd....";
			jsp = "waiting_list_for_surgery";
			jsp += ".jsp";
			
			title = "Waiting Patient List";
		     map.put("contentJsp", jsp);
		     map.put("title", title);
		     map.put("message", msg);
			
		}
		//
		return new ModelAndView("index", "map", map);
	}
	 
	public ModelAndView referBackPatientToOpd1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapForDs = new HashMap<String, Object>();
		HttpSession session  = request.getSession();
		Users users=null;
		int userId=0;
		if(session!=null){
			users = (Users)session.getAttribute("users");
			userId=users.getEmployee().getId();
		}
		int surgeryId=0;
		String submitForm="7";
		int flag=0;
		if(request.getParameter("surgeryId")!=null){
		 surgeryId = Integer.parseInt(request.getParameter("surgeryId"));
	       }
		mapForDs = otHandlerService.referBackPatientToOpd(surgeryId,submitForm,userId);
		
		  flag=(Integer)map.get("flag");
		  if(flag==1){
		   String msg="Successfully send to Opd....";
		   map.put("message", msg);
		  }else{
			  String msg="Error in refering Patient..";
			   map.put("message", msg);
		  }
		   return new ModelAndView(jsp, "map", map);
	  }
	public ModelAndView saveOtPostAnaesthesiaFinalReadingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int hospitalId = 0;
		int otBooking=0;
		String flag="false";
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		patientMap.put(HOSPITAL_ID, hospitalId);
		if(request.getParameter("otBookingId")!=null && !request.getParameter("otBookingId").equals(""))
		{
			otBooking=Integer.parseInt(request.getParameter("otBookingId"));
			patientMap.put("otBookingId",otBooking);
		}
		if(request.getParameter("flag")!=null && !request.getParameter("flag").equals(""))
		{
			flag=request.getParameter("flag");
			patientMap.put("flag",flag);
			map.put("flag",flag);
		}
		           
		map = otHandlerService.saveOtPostAnaesthesiaFinalReadingJsp(patientMap);
		String result=(String)map.get("msg");
		if(result.equals("success")){
			String msg="Data Saved Successfully....";
			   map.put("message", msg);
		}else{
			String msg="Error in Saving Data....";
			   map.put("message", msg);
		}
		String jsp = "ot_painManagementResponse";
		return new ModelAndView(jsp, "map", map);
	}
	
	
	
	public ModelAndView saveOtPostAnaesthesiaReadingJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int hospitalId = 0;
		String flag="false";
		int userId=0;
		if(session!=null){
			Users users = (Users)session.getAttribute("users");
			userId=users.getEmployee().getId();
		}
		patientMap.put("userId", userId);
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		patientMap.put(HOSPITAL_ID, hospitalId);
		
		if(request.getParameter("uhid")!=null && !request.getParameter("uhid").equals(""))
		{
			patientMap.put(HIN_NO, request.getParameter("uhid"));
		}
		if(request.getParameter("bodyPart")!=null && !request.getParameter("bodyPart").equals(""))
		{
			patientMap.put("bodyPart", request.getParameter("bodyPart"));
		}
		if(request.getParameter("periscopeValue")!=null && !request.getParameter("periscopeValue").equals(""))
		{
			patientMap.put("periscopeValue", Integer.parseInt(request.getParameter("periscopeValue")));
		}
		if(request.getParameter("periscopeName")!=null && !request.getParameter("periscopeName").equals(""))
		{
			patientMap.put("periscopeName", request.getParameter("periscopeName"));
		}
		
		if(request.getParameter("otBookingId")!=null && !request.getParameter("otBookingId").equals("") && !request.getParameter("otBookingId").equals("0"))
		{
			patientMap.put("otBookingId" , Integer.parseInt(request.getParameter("otBookingId")));
		}

		
		map = otHandlerService.saveOtPostAnaesthesiaReadingJsp(patientMap);
		String jsp = "ot_painManagementResponse";
		//jsp += ".jsp";
		title = "Patient Pain Management";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
		
		
	}
	
	
	public ModelAndView showPatientAllPeriscopeReading(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		int hospitalId = 0;
		int otBookingId=0;
		int hinNo=0;
		String flag="false";
		if(request.getParameter("otBookingId")!=null && !request.getParameter("otBookingId").equals("") && !request.getParameter("otBookingId").equals("0"))
		{
			patientMap.put("otBookingId" , Integer.parseInt(request.getParameter("otBookingId")));
		}
		if(request.getParameter("hospitalId")!=null && !request.getParameter("hospitalId").equals("") && !request.getParameter("hospitalId").equals("0"))
		{
			patientMap.put("hospitalId" , Integer.parseInt(request.getParameter("hospitalId")));
		}
		if(request.getParameter("hinNo")!=null && !request.getParameter("hinNo").equals("") && !request.getParameter("hinNo").equals("0"))
		{
			patientMap.put("hinNo" , request.getParameter("hinNo"));
		}
		map=otHandlerService.showPatientAllPeriscopeReading(patientMap);
		String jsp = "ot_showPatientAllPeriscopeReading";
		
		return new ModelAndView(jsp, "map", map);
	 }

	
	public ModelAndView getPacHistory(HttpServletRequest request,
			HttpServletResponse response) {
		int orderId=0;
		
		if(request.getParameter("orderId")!=null){
			orderId=Integer.parseInt(request.getParameter("orderId"));
		}
		
		Map<String,Object> dataMap=otHandlerService.getPacHistory(orderId);
		
		return new ModelAndView("otPacHistory", "map", dataMap);
		
	}
	
	public ModelAndView getPreAnesthesiaHistory(HttpServletRequest request,
			HttpServletResponse response) {
		int bookingId=0;
		
		if(request.getParameter("bookingId")!=null){
			bookingId=Integer.parseInt(request.getParameter("bookingId"));
		}
		
		Map<String,Object> dataMap=otHandlerService.getPreAnesthesiaHistory(bookingId);
		
		return new ModelAndView("otPreAnesthesiaHistory", "map", dataMap);
		
	}
	
	
public ModelAndView showOpPreAnesthesiaForm(HttpServletRequest request,HttpServletResponse response){
		
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String, Object> mapForDS = new HashMap<String, Object>();

		int opdSurgeryId = Integer.parseInt(request
						.getParameter("opdSurgeryId"));
				int hospitalId = 0;
				if (session.getAttribute(HOSPITAL_ID) != null) {
					hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				}
				mapForDS.put(HOSPITAL_ID, hospitalId);
				mapForDS.put("opdSurgeryId", opdSurgeryId);
		
		map = otHandlerService.showOpPreAnesthesiaForm(mapForDS);
		
		
		jsp = "opPacClearance";
		jsp += ".jsp";
		title = "Anesthesia Assesment Clinic";

		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}

public ModelAndView submitAac(HttpServletRequest request,HttpServletResponse response){
	
	Box box = HMSUtil.getBox(request);
	HttpSession session = request.getSession();
	Map<String, Object> mapForDS = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	
	/*Prescription Data Start*/
	
	int hdb = 0;
	if (null !=request.getParameter("hdb") && Integer.parseInt(request.getParameter("hdb")) >= 0) {
		hdb = Integer.parseInt(request.getParameter("hdb"));
	}
	
	String[] pvmsArr = new String[hdb+1];
	int j = 0;
	
	StringBuffer parkPrescriptions=new StringBuffer();
	
	String prescription_availableStatus="";
	List<String> prescription_availableStatusList=new ArrayList<String>();
	List<String> pvmsNoList=new ArrayList<String>();
	List<Integer> frequencyList=new ArrayList<Integer>();
	List<Float> dosageList=new ArrayList<Float>();
	List<Float> actualTotalAfterMixList=new ArrayList<Float>();
	List<Float> totalList=new ArrayList<Float>();
	List<Integer> noOfDaysList =new ArrayList<Integer>();
	List<String> spLinstrunctionList=new ArrayList<String>();
	List<Integer> instrunctionList=new ArrayList<Integer>();
	List<Integer> routes =new ArrayList<Integer>();
	
	List<String> blockMedicineList=new ArrayList<String>();
	List<Integer> blockDaysList=new ArrayList<Integer>();
	
	for (int i = 0; i <=hdb; i++)  {
		if (request.getParameter("nomenclature" + j)!=null && !request.getParameter("nomenclature" + j).equals("")) {
			
			String nomenclature = request.getParameter("nomenclature" + j);
			int index1 = nomenclature.lastIndexOf("[");
			int index2 = nomenclature.lastIndexOf("]");
			index1++;
			
			String block=request.getParameter("blockMedicine" + j);
			if(request.getParameter("blockMedicine" + j)!=null && request.getParameter("blockMedicine" + j).equalsIgnoreCase("y")){
				String medicineToBlock=nomenclature.substring(0,nomenclature.lastIndexOf("("));
				blockMedicineList.add(medicineToBlock);
				if(request.getParameter("blockDays" + j)!=null){
					blockDaysList.add(Integer.parseInt(request.getParameter("blockDays" + j)));
				}
				
			}else{
				
				pvmsArr[i] = nomenclature.substring(index1,	index2);
				
				parkPrescriptions.append(nomenclature.substring(0, index1-1)+"|");
				String pvmsNo=null;
				if(request.getParameter("pvmsNo"+j)!=null)
	            {
	            	pvmsNo = request.getParameter("pvmsNo"+j);

	            }
				
				int frequencyId=0;
		 		if(request.getParameter("frequency"+ j)!=null && !request.getParameter("frequency"+ j).equals("")){
		 			frequencyId = Integer.parseInt(request.getParameter("frequency"+ j));
		 		}
		 		
		 		int noOfDays=0;
		 		if(request.getParameter("noOfDays"+ j)!=null && !request.getParameter("noOfDays"+ j).equals("")){
		 			noOfDays = Integer.parseInt(request.getParameter("noOfDays"+ j));
		 		}
		 		
		 		Float dosage=0.0f;
		 		if(request.getParameter("dosage" + j)!=null && !request.getParameter("dosage" + j).equals("")){
		 			dosage = Float.valueOf(request.getParameter("dosage" + j));
		 		}
		 		
		 		Integer instrunction=0;
		 		if(request.getParameter("instrunction" + j)!=null && !request.getParameter("instrunction" + j).equals("")){
		 			instrunction = Integer.parseInt(request.getParameter("instrunction" + j));
		 		}
		 		
		 		String splInstrunctionpTab="";
		 		if(request.getParameter("splInstrunction" + j)!=null && !request.getParameter("splInstrunction" + j).equals("")){
		 			splInstrunctionpTab = request.getParameter("splInstrunction" + j);
		 		}
		 		
		 		Integer route=0;
		 		if(request.getParameter("route" + j)!=null && !request.getParameter("route" + j).equals("")){
		 			route = Integer.parseInt(request.getParameter("route" + j));
		 		}
		 		
		 		float actualTotalAfterMix=0.0f;
		 		if(request.getParameter("mixable" + j)!=null && request.getParameter("mixable" + j).equalsIgnoreCase("Y")){
		 			
		 			if(request.getParameter("actualTotalAfterMix" + j)!=null && !request.getParameter("actualTotalAfterMix" + j).equals("")){
		 				actualTotalAfterMix = Float.parseFloat(request.getParameter("actualTotalAfterMix" + j));
			 		}
		 			
		 		}
		 		
		 		float total=0.0f;
		 		if(request.getParameter("total" + j)!=null && !request.getParameter("total" + j).equals("")){
		 			total = Float.parseFloat(request.getParameter("total" + j));
		 		}
		 		
		 		if(request.getParameter("prescription_availableStatus" + j)!=null && !request.getParameter("prescription_availableStatus" + j).equals("")){
	 				prescription_availableStatus = request.getParameter("prescription_availableStatus" + j);
		 		}else{
		 			prescription_availableStatus = null;
		 		}
		 		prescription_availableStatusList.add(prescription_availableStatus);
		 		pvmsNoList.add(pvmsArr[i]);
		 		frequencyList.add(frequencyId);
				dosageList.add(dosage);
				actualTotalAfterMixList.add(actualTotalAfterMix); // added by amit das in 19-11-2016
				totalList.add(total);
				noOfDaysList.add(noOfDays);
				
				spLinstrunctionList.add(splInstrunctionpTab);
				instrunctionList.add(instrunction);
				routes.add(route);
			}
			
		}
		j++;
	}
	int hospitalId=0;
	if(session.getAttribute("hospitalId")!=null){
		hospitalId=(Integer)session.getAttribute("hospitalId");
	}
	int userId=0;
	if(session!=null){
		Users users = (Users)session.getAttribute("users");
		mapForDS.put("userId",users.getId());
		mapForDS.put("user",users);
		
	}
	int hinId=0;
	if (request.getParameter("hinId")!=null && !request.getParameter("hinId").equals("")) {
		hinId = Integer.parseInt(request.getParameter("hinId"));
	}
	int visitId=0;
	if (request.getParameter("visitId")!=null && !request.getParameter("visitId").equals("")) {
		visitId = Integer.parseInt(request.getParameter("visitId"));
	}
	int inpatientId=0;
	if (request.getParameter("inpatientId")!=null && !request.getParameter("inpatientId").equals("")) {
		inpatientId = Integer.parseInt(request.getParameter("inpatientId"));
	}
	int opdSurgeryId=0;
	if (request.getParameter("surgeryId")!=null && !request.getParameter("surgeryId").equals("")) {
		opdSurgeryId = Integer.parseInt(request.getParameter("surgeryId"));
	}
	
	int deptId = (Integer) session.getAttribute("deptId");
	
	mapForDS.put("deptId", deptId);
	mapForDS.put("hinId", hinId);
	mapForDS.put("opdSurgeryId", opdSurgeryId);
	//mapForDS.put("userId", userId);
	mapForDS.put("hospitalId", hospitalId);
	mapForDS.put("prescription_availableStatusList", prescription_availableStatusList);
	mapForDS.put("parkPrescriptions", parkPrescriptions);
	mapForDS.put("pvmsNoList", pvmsNoList);

	mapForDS.put("frequenciesList", frequencyList);
	mapForDS.put("dosageList", dosageList);
	mapForDS.put("noOfDaysList", noOfDaysList);
	mapForDS.put("routes", routes);
	mapForDS.put("instrunctionsList", instrunctionList);
	mapForDS.put("spLinstrunctionList", spLinstrunctionList);
	mapForDS.put("totalList", totalList);
	mapForDS.put("actualTotalAfterMixList", actualTotalAfterMixList);
	mapForDS.put("prescriptionNo", generatePrecriptionNo(hinId));
	mapForDS.put("visitId", visitId);
	mapForDS.put("inpatientId", inpatientId);
	mapForDS.put("blockMedicineList", blockMedicineList);
	mapForDS.put("blockDaysList", blockDaysList);
	/*Prescription Data End*/
	
	/*Investigation Grid Data Start*/
	
	int hiddenValue = 0;
	if (request.getParameter("hiddenValue")!=null && !request.getParameter("hiddenValue").equals("")) {
		hiddenValue = Integer.parseInt(request.getParameter("hiddenValue"));
	}
	
	String[] chargeCodeIdArr = new String[hiddenValue+1];
	StringBuffer parkInvestigations=new StringBuffer();
	List<String> chargeCodeIdList=new ArrayList<String>();
	String clinicalNotes="";
	List<String> clinicalList=new ArrayList<String>();
	String availableStatus="";
	List<String> availableStatusList=new ArrayList<String>();
	List<String> parkInvestigationIds=new ArrayList<String>();
	List<String> isPackageList=new ArrayList<String>();
	
	for (int i = 0; i <=hiddenValue; i++) {
		if (request.getParameter("chargeCodeName" + i)!=null && !request.getParameter("chargeCodeName" + i).equals("") ) {
			String chargeCodeNameWithId = request.getParameter("chargeCodeName" + i);
			
			int index1 = chargeCodeNameWithId.lastIndexOf("[");
			int index2 = chargeCodeNameWithId.lastIndexOf("]");
			index1++;
			chargeCodeIdArr[i] = chargeCodeNameWithId.substring(index1,index2);
			parkInvestigations.append(chargeCodeNameWithId.substring(0, index1-1)+"|");
			chargeCodeIdList.add(chargeCodeIdArr[i]);
			
			clinicalNotes = request.getParameter("clinicalNotes"+ i);
			clinicalList.add(clinicalNotes);
			
			availableStatus = request.getParameter("availableStatus"+ i);
			availableStatusList.add(availableStatus);
			
			String parkInvestigationIdDtId= request.getParameter("parkInvestigationId"+ i);
	 		parkInvestigationIds.add(parkInvestigationIdDtId);
	 		
	 		String isPackageFlag=request.getParameter("isPackageFlag"+ i);
	 		isPackageList.add(isPackageFlag);
		}
	}
	
	mapForDS.put("isPackageList", isPackageList);
	mapForDS.put("parkInvestigationIds", parkInvestigationIds);
	mapForDS.put("parkInvestigations", parkInvestigations);
	mapForDS.put("chargeCodeIdList", chargeCodeIdList);
	mapForDS.put("clinicalList", clinicalList);
	mapForDS.put("availableStatusList", availableStatusList);
	
	/*Investigation Grid Data End*/
	
	/*Multiple Refferal Start*/
	
	String[] serviceCenters=request.getParameterValues("serviceCenter");
	String[] opSessions=request.getParameterValues("opSession");
	
	List<Integer> serviceCentersList=new ArrayList<Integer>();
	List<Integer> opSessionList=new ArrayList<Integer>();
	
	if(serviceCenters!=null &&opSessions!=null&&serviceCenters.length>0&&opSessions.length>0&&serviceCenters.length==opSessions.length){
		for(int i=0;i<serviceCenters.length;i++){
			int serviceCenterId=Integer.parseInt(serviceCenters[i]);
			int opSessionId=Integer.parseInt(opSessions[i]);
			
			
			if(serviceCenterId!=0){
				if(opSessionId!=0){
					serviceCentersList.add(serviceCenterId);
					opSessionList.add(opSessionId);
				}
			}
		}
	}
	
	mapForDS.put("visitFrom", "OpClinic PAC");
	mapForDS.put("serviceCentersList", serviceCentersList);
	mapForDS.put("opSessionList", opSessionList);
	
	String hospitalCode = "";
	if (session.getAttribute("hospitalCode") != null) {
		hospitalCode = (String) session.getAttribute("hospitalCode");
		mapForDS.put("hospitalCode", hospitalCode);
	}
	String deptCode="";
	if (session.getAttribute("deptCode") != null) {
		deptCode = (String) session.getAttribute("deptCode");
		mapForDS.put("deptCode", deptCode);
	}
	
	
	
	
	
	/*Multiple Refferal End*/
	
	mapForDS.put("box",box);
	map=otHandlerService.submitAac(mapForDS);
	boolean success=false;
	if(map.get("status")!=null){
		success=(boolean)map.get("status");
	}
	mapForDS.put("success", success);
	
	jsp = "messageForAac";
	jsp += ".jsp";
	title = "Anesthesia Assesment Clinic";

	mapForDS.put("contentJsp", jsp);
	mapForDS.put("title", title);
	return new ModelAndView("index", "map", mapForDS);
	
}
public ModelAndView showOpPacHistory(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	if(request.getParameter("lastVisit")!=null){
		int lastVisit=Integer.parseInt(request.getParameter("lastVisit"));
		map.put("lastVisit", lastVisit);
	}
	if(request.getParameter("otPreAnesthesiaDtlId")!=null){
		int otPreAnesthesiaDtlId=Integer.parseInt(request.getParameter("otPreAnesthesiaDtlId"));
		map.put("otPreAnesthesiaDtlId", otPreAnesthesiaDtlId);
	}
	
	int opdSurgeryId = Integer.parseInt(request
			.getParameter("opdSurgeryId"));
	int hospitalId = 0;
	if (session.getAttribute(HOSPITAL_ID) != null) {
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map.put(HOSPITAL_ID, hospitalId);
	map.put("opdSurgeryId", opdSurgeryId);
	
	map=otHandlerService.showOpPacHistory(map);
	
	return new ModelAndView("opPacHistory", "map", map);
	
}

public ModelAndView showOtPatientsReportJsp(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	
	String jsp="otPatientsReportJsp.jsp";
	String title = "OT Patient Pending Report Jsp";

	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView PrintOtPendingPatients(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	Map<String, Object> parameters = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	String query = "";
	Date fromDate = new Date();
	Date toDate = new Date();
	
	int hospitalId = (Integer) session.getAttribute("hospitalId");
	String hospitalName = "";
	String address = "";
	
	map = otHandlerService.getHospitalName(hospitalId);
	if (map.get("hospitalName") != null
			&& !map.get("hospitalName").equals("")) {
		hospitalName = (String) map.get("hospitalName");
	}
	if (map.get("address") != null && !map.get("address").equals("")) {
		address = (String) map.get("address");
	}
	parameters.put("address", address);
	parameters.put("hospitalName", hospitalName);
	
	int employeeId=0;
	if((Integer)session.getAttribute("userId")!=null && (Integer)session.getAttribute("userId")!=0){
		employeeId=otHandlerService.getEmployeeIdFromUser((Integer)session.getAttribute("userId"));
	}
	
	
	//int hospitalId = (Integer) session.getAttribute("hospitalId");
	if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
		fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));

	}
	if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
		toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));

	}
	
	query+="hdr.employee_id="+employeeId+" and hdr.requisition_date between '"+fromDate+"' and '"+toDate+"'  and hdr.booking_status='pending'  and hdr.hospital_id="+hospitalId;
	
	detailsMap = otHandlerService.getConnectionForReport();
	parameters.put("query", query);
	
	try {
		byte[] bytes = null;
		try {
			String reportName = "otPendingPatients";
			
			bytes = JasperRunManager.runReportToPdf(getCompiledReport(reportName), parameters,
					(Connection) detailsMap.get("con"));

		} catch (JRException e) {
			e.printStackTrace();
		}
		response.setHeader("Content-Disposition", "inline; filename=" + "otPendingPatients" + ".pdf");
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
	
	return null;
}

public ModelAndView showTableWiseOtList(HttpServletRequest request,HttpServletResponse response){
	Map<String,Object> map=new HashMap<String,Object>();
	HttpSession session = request.getSession();
	Map<String,Object> dataMap=new HashMap<String,Object>();
	int hospitalId=0;
	Date fromDate = new Date();
	Date toDate = new Date();
	int theaterId=0;
	int unitId=0;
	int tableId=0;
	int doctorId=0;
	
	if(request.getParameter("theaterId")!=null && !request.getParameter("theaterId").equals("0")){
		theaterId=Integer.parseInt(request.getParameter("theaterId"));
		map.put("theaterId", theaterId);
	}
	
	if(request.getParameter("unitId")!=null && !request.getParameter("unitId").equals("0")){
		unitId=Integer.parseInt(request.getParameter("unitId"));
		map.put("unitId", unitId);
	}
	
	if(request.getParameter("tableId")!=null && !request.getParameter("tableId").equals("0")){
		tableId=Integer.parseInt(request.getParameter("tableId"));
		map.put("tableId", tableId);
	}
	
	if(request.getParameter("doctorId")!=null && !request.getParameter("doctorId").equals("0")){
		doctorId=Integer.parseInt(request.getParameter("doctorId"));
		map.put("doctorId", doctorId);
	}
	
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
	}
	map.put("hospitalId", hospitalId);
	
	if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
		fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		map.put("fromDate", fromDate);
	}
	if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
		toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		map.put("toDate", toDate);
	}
	
	map=otHandlerService.showTableWiseOtList(map);
	String jsp = "tableWiseOtList.jsp";
	String title = "Table Wise Ot List";

	map.put("contentJsp", jsp);
	map.put("title", title);
	return new ModelAndView("index", "map", map);
}

public ModelAndView PrintTableWisePatients(HttpServletRequest request,HttpServletResponse response) {
	HttpSession session = request.getSession();
	Map<String,Object> map=new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	Map<String, Object> parameters = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	String query = "";
	String surgeonQry="";
	Date fromDate = new Date();
	Date toDate = new Date();
	int hospitalId=0;
	int theaterId=0;
	int unitId=0;
	int tableId=0;
	int doctorId=0;
	
	if (request.getParameter(FROM_DATE) != null && !(request.getParameter(FROM_DATE).equals(""))) {
		fromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(FROM_DATE));
		String fromdtStr=HMSUtil.getDateFormat(fromDate, "yyyy-MM-dd");
		query=query+" where booking.surgery_date between '"+fromdtStr+"'";
	}
	if (request.getParameter(TO_DATE) != null && !(request.getParameter(TO_DATE).equals(""))) {
		toDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(TO_DATE));
		String toDtStr=HMSUtil.getDateFormat(toDate, "yyyy-MM-dd");
		query=query+" and '"+toDtStr+"'";
	}
	
	if(request.getParameter("theaterId")!=null && !request.getParameter("theaterId").equals("0")){
		theaterId=Integer.parseInt(request.getParameter("theaterId"));
		query=query+" and booking.department_id="+theaterId;
	}
	
	if(request.getParameter("unitId")!=null && !request.getParameter("unitId").equals("0")){
		unitId=Integer.parseInt(request.getParameter("unitId"));
		query=query+" and booking.unit_id="+unitId;
	}
	
	if(request.getParameter("tableId")!=null && !request.getParameter("tableId").equals("0")){
		tableId=Integer.parseInt(request.getParameter("tableId"));
		query=query+" and booking.bed_id="+tableId;
	}
	
	if(request.getParameter("doctorId")!=null && !request.getParameter("doctorId").equals("0")){
		doctorId=Integer.parseInt(request.getParameter("doctorId"));
		surgeonQry=surgeonQry+"inner join ot_book_surgeon surgeon on surgeon.booking_id=booking.booking_id";
		//query=query+" and surgeon.employee_id="+doctorId;
		query=query+" and surgeon.booking_id in (select booking_id from ot_book_surgeon where employee_id = "+doctorId+") and surgeon.role='Surgeon'";
	} 
	
	if(session.getAttribute(HOSPITAL_ID)!=null){
		hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		query=query+" and booking.hospital_id="+hospitalId;
	}
	query=query+" order by bed.bed_id asc";
	
	detailsMap = otHandlerService.getConnectionForReport();
	parameters.put("query", query);
	parameters.put("surgeonQry", surgeonQry);
	
	String hospitalName = "";
	String address = "";
	
	map = otHandlerService.getHospitalName(hospitalId);
	if (map.get("hospitalName") != null
			&& !map.get("hospitalName").equals("")) {
		hospitalName = (String) map.get("hospitalName");
	}
	if (map.get("address") != null && !map.get("address").equals("")) {
		address = (String) map.get("address");
	}
	parameters.put("address", address);
	parameters.put("hospitalName", hospitalName);
	
	HMSUtil.generateReport("Table_Wise_OT_Patients_Report", parameters,
			(Connection) detailsMap.get("con"), response,
			getServletContext());
	
	return null;
}

}
	
