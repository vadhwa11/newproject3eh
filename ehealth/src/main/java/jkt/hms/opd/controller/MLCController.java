package jkt.hms.opd.controller;

import static jkt.hms.util.RequestConstants.COMMON_ID;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.ADMISSION_NUMBER;
import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.Inpatient;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.MedicoLegalDetails;
import jkt.hms.masters.business.MortuaryRegisterDetails;
import jkt.hms.masters.business.OpdPatientDetails;
import jkt.hms.masters.business.OpdPatientHistory;
import jkt.hms.masters.business.Patient;
import jkt.hms.masters.business.PatientAddress;
import jkt.hms.masters.business.PatientWiseMlc;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.handler.CommonMasterHandlerService;
import jkt.hms.opd.handler.MLCHandlerService;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;
import jkt.hms.util.HMSUtil;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;




public class MLCController extends MultiActionController {
	MLCHandlerService mlcHandlerService = null;
	public MLCHandlerService getMlcHandlerService() {
		return mlcHandlerService;
	}
	public void setMlcHandlerService(MLCHandlerService mlcHandlerService) {
		this.mlcHandlerService = mlcHandlerService;
	}
	CommonMasterHandlerService commonMasterHandlerService = null;
	public CommonMasterHandlerService getCommonMasterHandlerService() {
		return commonMasterHandlerService;
	}
	public void setCommonMasterHandlerService(
			CommonMasterHandlerService commonMasterHandlerService) {
		this.commonMasterHandlerService = commonMasterHandlerService;
	}

	Map<String, Object> map = new HashMap<String, Object>();
	String title = "";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String jsp = "";
	String url = "";

	// ---------------------- Common UHID------------------//

	public void getPaitentDetail(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		String uhinId = "";
		//String mlcType="";
		if (request.getParameter("uhinId") != null
				&& !(request.getParameter("uhinId").equals(""))) {
			uhinId = request.getParameter("uhinId");
			detailsMap.put("uhinId", uhinId);
		}
		/*if (request.getParameter("mlcType") != null
				&& !(request.getParameter("mlcType").equals(""))) {
			mlcType = request.getParameter("mlcType");
			detailsMap.put("mlcType", mlcType);
		}*/
		List<Patient> patientHindIdList = new ArrayList<Patient>();
		map = mlcHandlerService.getPaitentDetail(detailsMap);
		if (map.get("patientHindIdList") != null) {
			patientHindIdList = (List) map.get("patientHindIdList");
		}
		List<MedicoLegalDetails> medicoLegalDetailsList = new ArrayList<MedicoLegalDetails>();
		if (map.get("medicoLegalDetailsList") != null) {
			medicoLegalDetailsList = (List) map.get("medicoLegalDetailsList");
		}
		StringBuffer sb = new StringBuffer();
		/*if(medicoLegalDetailsList.size() > 0){
			sb.append("<item>");
			sb.append("<msg>" + "Details already available for this patient UHID is "+uhinId + "</msg>");
			sb.append("</item>");
		}else{*/
			
			sb.append("<item>");
			for (Patient patient : patientHindIdList) {

				if (patient.getFullName() != null
						&& !patient.getFullName().equals("")) {
					sb.append("<name>" + patient.getFullName() + "</name>");
				} else {
					sb.append("<name>" + "" + "</name>");
				}
				if (patient.getAge() != null && !patient.getAge().equals("")) {
					sb.append("<age>" + patient.getAge() + "</age>");
				} else {
					sb.append("<age>" + " " + "</age>");
				}
				if (patient.getOccupation() != null
						&& !patient.getOccupation().equals("")) {
					sb.append("<Occupation>"
							+ patient.getOccupation().getOccupationName()
							+ "</Occupation>");
				} else {
					sb.append("<Occupation>" + " " + "</Occupation>");
				}
				if (patient.getSex() != null && !patient.getSex().equals("")) {
					sb.append("<Gender>"
							+ patient.getSex().getAdministrativeSexName()
							+ "</Gender>");
				} else {
					sb.append("<Gender>" + " " + "</Gender>");
				}

				if (patient.getId() != null && !patient.getId().equals("")) {
					sb.append("<hinId>" + patient.getId() + "</hinId>");
				} else {
					sb.append("<hinId>" + " " + "</hinId>");
				}
		//}
			sb.append("</item>");
		}
		response.setContentType("text/xml");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(
				"<?xml version='1.0' encoding='ISO-8859-1'?>");
		response.getWriter().write("<items>");
		response.getWriter().write(sb.toString());
		response.getWriter().write("</items>");
		//
	}


	// *********************---------------------------------------- Start of  Method by Mansi -------------------------------------***********************//


	public ModelAndView showWaitinListExamOfMaleAccusedSexualOffence(HttpServletRequest request,HttpServletResponse response)
    {
    	HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map=mlcHandlerService.getWaitingListExamOfMaleAccusedSexualOffence();
        
        String jsp = "examOfMaleAccused_waiting_mlcJsp";
        jsp += ".jsp";
        map.put("contentJsp", jsp);
        return new ModelAndView("index", "map", map);
    }
	
	
	public ModelAndView showExamOfMaleAccusedSexualOffenceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        Box box = HMSUtil.getBox(request);
        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		int id=0;
		String orderNo=""; 
        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
        	id=Integer.parseInt(request.getParameter("requestId").toString());
          
        } 
        int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
 		map = mlcHandlerService.getExamOfMaleAccusedSexual(box);
 		 if(map.get("patientAddress")!=null){
 	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
 	        }
 		 
 		if(map.get("patientWiseMlcs")!=null){
 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
 	        }
 		if(map.get("mlcList")!=null){
 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
 	        }
 		
 		 
		jsp = "mlc_examOfMaleAccusedSexualOffence";
		jsp += ".jsp";
		title = "Male Accused Sexual Offence";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("patientWiseMlcs", patientWiseMlcs);
		
		map.put("mlcList", mlcList);
		map.put("patientAddress", patientAddress);
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView showWaitinListExamOfFemaleVictimOfSexualAssault(HttpServletRequest request,HttpServletResponse response)
    {
    	HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map=mlcHandlerService.getWaitingListExamOfFemaleVictimOfSexualAssault();
        
        String jsp = "examOfFemalAccused_waiting_mlcJsp";
        jsp += ".jsp";
        map.put("contentJsp", jsp);
        return new ModelAndView("index", "map", map);
    }
	
	

	public ModelAndView showExamOfFemaleVictimOfSexualAssaultJsp(
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
        Map<String, Object> map = new HashMap<String, Object>();
        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
        Box box = HMSUtil.getBox(request);
		int id=0;
		String orderNo="";
        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
        	id=Integer.parseInt(request.getParameter("requestId").toString());
          
        } 
        int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
		map = mlcHandlerService.getExamOfFemaleVictimOfSexualAssault(box);
		 if(map.get("patientAddress")!=null){
	 	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
	 	        }
		 if(map.get("patientWiseMlcs")!=null){
	 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
	 	        }
	 		if(map.get("mlcList")!=null){
	 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
	 	        }
		orderNo = (String) map.get("orderNo");
		jsp = "mlc_examOfFemaleVictimOfSexualAssault";
		jsp += ".jsp";
		title = "Female Victim Of Sexual Assault";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("orderNo", orderNo);
		map.put("patientAddress", patientAddress);
		map.put("mlcList", mlcList);
        map.put("patientWiseMlcs", patientWiseMlcs);
		return new ModelAndView("index", "map", map);

	}
	
	
	public ModelAndView showWaitinListExamOfVictimOfUnnaturalSexualOffence(HttpServletRequest request,HttpServletResponse response)
    {
    	HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map=mlcHandlerService.getWaitingListExamOfVictimOfUnnaturalSexualOffence();
        
        String jsp = "VictimOfUnnatural_waiting_mlcJsp";
        jsp += ".jsp";
        map.put("contentJsp", jsp);
        return new ModelAndView("index", "map", map);
    }
	

	public ModelAndView showExamOfVictimOfUnnaturalSexualOffenceJsp(
			HttpServletRequest request, HttpServletResponse response) {
		  Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
	        HttpSession session = request.getSession();
		int id=0;
		String orderNo="";
        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
        	id=Integer.parseInt(request.getParameter("requestId").toString());
          
        } 
        int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
		map = mlcHandlerService.getExamOfVictimOfUnnaturalSexualOffence(box);
		 if(map.get("patientAddress")!=null){
	 	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
	 	        }
		 if(map.get("patientWiseMlcs")!=null){
	 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
	 	        }
	 		if(map.get("mlcList")!=null){
	 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
	 	        }
		orderNo = (String) map.get("orderNo");
		jsp = "mlc_examVictimOfUnnaturalSexualOffence";
		jsp += ".jsp";
		title = " Victim Of Unnatural Assault";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("orderNo", orderNo);
		map.put("patientAddress", patientAddress);
		map.put("mlcList", mlcList);
        map.put("patientWiseMlcs", patientWiseMlcs);
		return new ModelAndView("index", "map", map);

	}
	
	public ModelAndView showWaitinListOfEvidenceOfRecentDelivery(HttpServletRequest request,HttpServletResponse response)
    {
    	HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        
        map=mlcHandlerService.getWaitingListExamOfEvidenceOfRecentDelivery();
        
        String jsp = "evidenceOfRecentDelivery_waiting_mlcJsp";
        jsp += ".jsp";
        map.put("contentJsp", jsp);
        return new ModelAndView("index", "map", map);
    }
	
	
	
	public ModelAndView showExamOfEvidenceOfRecentDeliveryJsp(
			HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession();
        Map<String, Object> map = new HashMap<String, Object>();
        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
        Box box = HMSUtil.getBox(request);
        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
        String orderNo="";
	     int id=0;
	     
	     int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        } 
			map = mlcHandlerService.getEvidenceOfRecentDelivery(box);
			orderNo = (String) map.get("orderNo");
			if(map.get("patientAddress")!=null){
	 	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
	 	        }
			if(map.get("patientWiseMlcs")!=null){
	 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
	 	        }
	 		if(map.get("mlcList")!=null){
	 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
	 	        }
		jsp = "mlc_examOfEvidenceOfRecentDelivery";
		jsp += ".jsp";
		title = "Evidence Of Recent Delivery";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("orderNo", orderNo);
		map.put("patientAddress", patientAddress);
		map.put("mlcList", mlcList);
        map.put("patientWiseMlcs", patientWiseMlcs);
		return new ModelAndView("index", "map", map);

	}
	
	
	  public ModelAndView addExamOfMaleAccusedSexualOffence(HttpServletRequest request,HttpServletResponse response)
	    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			int userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			
			int empId = (Integer) session.getAttribute("empId");
			box.put("empId", empId);
			int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
			map = mlcHandlerService.addExamOfMaleAccusedSexualOffence(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 


	  
	  public ModelAndView addExamOfFemaleVictimOfSexualAssault(HttpServletRequest request,HttpServletResponse response)
	    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			
			
			int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}

			map = mlcHandlerService.addExamOfFemaleVictimOfSexualAssault(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 
	  
	  
	  
	  public ModelAndView addExamOfVictimOfUnnaturalSexualOffence(HttpServletRequest request,HttpServletResponse response)
	    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
			map = mlcHandlerService.addExamOfVictimOfUnnaturalSexualOffence(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 
	  public ModelAndView addExamOfEvidenceOfRecentDelivery(HttpServletRequest request,HttpServletResponse response)
	    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
			map = mlcHandlerService.addExamOfEvidenceOfRecentDelivery(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 
	  
	  
		public ModelAndView generateReportForMLC(HttpServletRequest request,HttpServletResponse response) {
			HttpSession session = request.getSession();
			Map<String, Object> mapResponse = new HashMap<String, Object>();
			Map<String, Object> mapForDs = new HashMap<String, Object>();
			List<MasHospital> masHospitaList = new ArrayList<MasHospital>();
			int hospitalId = 0;
			String hospitalName = "";
			String qry = "";
			String hinNo="";
			String jasper = null;
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				mapForDs.put("hospitalId", hospitalId);
				mapResponse = mlcHandlerService.getHospitalName(mapForDs);
			}
			if (mapResponse.get("masHospitaList") != null) {
				masHospitaList = (List) mapResponse.get("masHospitaList");
				hospitalName = masHospitaList.get(0).getHospitalName();
			}
			String mlcType = "";
			if (request.getParameter("mlcType") != null
					&& !(request.getParameter("mlcType").equals(""))) {
				mlcType = request.getParameter("mlcType");
				mapForDs.put("mlcType", mlcType); // added by amit das on 13-10-2016
			}
			if (request.getParameter("mlcNameForReport") != null
					&& !(request.getParameter("mlcNameForReport").equals(""))) {
				mlcType = request.getParameter("mlcNameForReport");
				mapForDs.put("mlcType", mlcType);
			}
			
			if (request.getParameter(HIN_NO) != null
					&& !(request.getParameter(HIN_NO).equals(""))) {
				hinNo = request.getParameter(HIN_NO);
				mapForDs.put("hinNo", hinNo); // added by amit das on 13-10-2016
			}
			if (request.getParameter("UhidForMlcReport") != null
					&& !(request.getParameter("UhidForMlcReport").equals(""))) {
				hinNo = request.getParameter("UhidForMlcReport");
				mapForDs.put("hinNo", hinNo);
			}
		
			int medicoLegalDetailsId  = 0;
			if (request.getParameter("mlcNo") != null && !request.getParameter("mlcNo").equals("0")){
				medicoLegalDetailsId = Integer.parseInt(request.getParameter("mlcNo"));
				mapForDs.put("medicoLegalDetailsId", medicoLegalDetailsId);
			}else if (request.getParameter("medicoLegalDetailsId") != null		&& !(request.getParameter("medicoLegalDetailsId").equals(""))) {
				medicoLegalDetailsId = Integer.parseInt(request.getParameter("medicoLegalDetailsId"));
				mapForDs.put("medicoLegalDetailsId", medicoLegalDetailsId);
			}else{
				
				
			
				List<Integer> mlcIdList = new ArrayList<Integer>();
				mlcIdList = mlcHandlerService.getMLCIdList(mapForDs);
				if(null !=mlcIdList && mlcIdList.size()>0 && null != mlcIdList.get(0)){
					medicoLegalDetailsId = mlcIdList.get(0);
				}
			}
			mlcHandlerService.getMLCIdList(mapForDs);
			if(mlcType.equalsIgnoreCase("Examination of a male accused in sexual offence"))
			{
				jasper="reportOfExaminationOfAMaleAccusedInSexualOffence";
			} 
			if(mlcType.equalsIgnoreCase("Examination of a female victim of sexual assault"))
			{
				jasper="REPORT_OF_ EXAMINATION_OF_ A_FEMALE_VICTIM_OF_SEXUAL_ASSAULT";
			}
			if(mlcType.equalsIgnoreCase("Examination of a victim of unnatural sexual offence"))
			{
				jasper="REPORT_OF_EXAMINATION_OF_A_VICTIM_OF_UNNATURAL_SEXUAL_OFFENCE_new";
			}
			if(mlcType.equalsIgnoreCase("Examination for evidence of recent delivery"))
			{
				jasper="REPORT_OF_EXAMINATION_FOR_EVIDENCE_OF_RECENT_DELIVERY";
			}
			if(mlcType.equalsIgnoreCase("Mortuary Register"))
			{
				jasper="Mortuary Register";
			}
			if(mlcType.equalsIgnoreCase("Register of Postmortem Examinations"))
			{
				jasper="Register of Postmortem Examinations";
			}
			if(mlcType.equalsIgnoreCase("POST MORTEM DETAILED NOTES"))
			{
				jasper="POST-MORTEM DETAILED NOTES";
			}
			if(mlcType.equalsIgnoreCase("Final opinion as to cause of death"))
			{
				jasper="FINAL OPINION AS TO CAUSE OF DEATH";
			}
			if(mlcType.equalsIgnoreCase("Examination of a victim alleged to have been drugged"))
			{
				jasper="Report_of_examination_of_a_victim_alleged_to_have_been_drugged";
			}
	
			if(mlcType.equalsIgnoreCase("Certificate Of Drunkness"))
			{
				jasper="CERTIFICATE_OF_DRUNKENNESS";
			}
			if(mlcType.equalsIgnoreCase("Examination for estimation of age"))
			{
				jasper="REPORT OF EXAMINATION FOR ESTIMATION OF AGE";
			}
			if(mlcType.equalsIgnoreCase("Chemical Analysis"))
			{
				jasper="Report to be forwarded with material objects sent for chemical analysis";
			}
			if(mlcType.equalsIgnoreCase("Certificate of collection of material objects from the body of a person for chemical examination, DNA profiling, examination at FSL, etc"))
			{
				jasper="Certificate of collection of material objects from the body of a person for chemical examination";
			}
			if(mlcType.equalsIgnoreCase("POSTMORTEM CERTIFICATE") )
			{
				jasper="POSTMORTEM CERTIFICATE";
			}
			if(mlcType.equalsIgnoreCase("Examination by a Medical Officer"))
			{
				jasper="Certificate of Examination by a Medical Officer";
			}
			if(mlcType.equalsIgnoreCase("Examination by a Specialist Medical Officer/Team of Specialist Medical Officers"))
			{
				jasper="Certificate of Examination by a Specialist Medical Officer Team of Specialist Medical Officers";
			}
			
			if(mlcType.equalsIgnoreCase("Accident Register-cum-Wound Certificate"))
			{
				jasper="accidentRegisterCumWoundCertificate";
			}
					
			if(mlcType.equalsIgnoreCase("Treatment / Discharge Certificate"))
			{
				jasper="trearmentDischargeCertificate_new";
			}
			if(mlcType.equalsIgnoreCase("Application cum No Objection Certificate"))
			{
				jasper="FormOfApplicationCumNoObjectionCertificate";
			}
			
			System.out.println(hinNo);
			System.out.println(hospitalId);
			System.out.println(medicoLegalDetailsId);
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("qry", qry);
			parameters.put("hospitalName", hospitalName);
			parameters.put("medicoLegalDetailsId", medicoLegalDetailsId);
			parameters.put("hospitalId", hospitalId);
			parameters.put("UHID_No", hinNo);
			
			parameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/reports/"));

			Map<String, Object> connectionMap = mlcHandlerService.getConnection();

			HMSUtil.generateReport(jasper, parameters,
					(Connection) connectionMap.get("conn"), response,
					getServletContext());

			return null;
		}
		
		
		
		public ModelAndView getAdmissionNumberList(HttpServletRequest request,
				HttpServletResponse response) {
			String uhinId = null;
			HttpSession session = request.getSession();
			Map<String, Object> requestParameters = new HashMap<String, Object>();
			session = request.getSession(false);
			requestParameters.put(HOSPITAL_ID, session.getAttribute("hospitalId"));

			if (request.getParameter("uhinId") != null && request.getParameter("uhinId") != "") {
				uhinId = request.getParameter("uhinId");
				requestParameters.put("uhinId", uhinId);
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map = mlcHandlerService.getAdmissionNumberList(requestParameters);
			jsp = "mlc_admissionNumberPopulate";

			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);
		}

	  
	// *********************---------------------------------------- End of  Method by Mansi -------------------------------------***********************//


		//---------- Avinash -- (2016-01-07)-----

		  
			
		    public ModelAndView showNoObjectionCertificateJSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	HttpSession session = request.getSession();
			 	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
			 	if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
			        	id=Integer.parseInt(request.getParameter("requestId").toString());
			          
			        } 
				   
				 map=mlcHandlerService.getNoObjectionCertificate(box);
				 if(map.get("patientAddress")!=null){
				        patientAddress = (List<PatientAddress>) map.get("patientAddress");
				        }
				    
			 	jsp = "No_Objection_Certificate";
				jsp += ".jsp";
				title = "No Objection Certificate";
				map.put("contentJsp", jsp);
				map.put("patientAddress", patientAddress);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
		    
		    
		    // Added by Amit Das on 19-04-2016
		    public ModelAndView showAuthenticityCertificateJSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 
			 	  Box box = HMSUtil.getBox(request);
			        int id=0;
				 	if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
				        	id=Integer.parseInt(request.getParameter("requestId").toString());
				          
				        } 	
				 	map=mlcHandlerService.getAuthenticityCertificate(box);	
			
			 	jsp = "authenticity_Certificate";
				jsp += ".jsp";
				title = "Authenticity Certificate";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
			
		    public ModelAndView showPostMartemOrignalJSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
				
			 	jsp = "postamteam_orignal_jsp";
				jsp += ".jsp";
				title = "PostMartem";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
		  
		    
		    public ModelAndView showCAUSE_OF_DEATHJSP(HttpServletRequest request, HttpServletResponse response) {
			   	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
			   
			 map=mlcHandlerService.getCAUSE_OF_DEATH(box);
			 	jsp = "cause_of_death_jsp";
				jsp += ".jsp";
				title = "CAUSE OF DEATH";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
		    
		    public ModelAndView showWaitinListTreatmentDischargr_JSP(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        
		        map=mlcHandlerService.getWaitingListTreatment_Dischargr_JSP();
		        
		        String jsp = "treatmentdichargr_waiting_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
		    
		    
		    
		    public ModelAndView showTreatment_Dischargr_JSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	 Box box = HMSUtil.getBox(request);
			 	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
			 	HttpSession session = request.getSession();
			 	String orderNo="";
				int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
		    	String uhinId="";
		        if(request.getParameter("uhinId")!=null && !request.getParameter("uhinId").equals("")){
		        	uhinId=request.getParameter("uhinId").toString();
		          
		        } 
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}

		        box.put("uhinId", uhinId);
		        //	map = mlcHandlerService.showUHIDJsp(); 	
			 	map = mlcHandlerService.getTreatment_Dischargr(box);
			 	orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
			        patientAddress = (List<PatientAddress>) map.get("patientAddress");
			        }
			     
			 	jsp = "treatment_dichargr_jsp";
				jsp += ".jsp";
				title = "Tratement Discharge";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("orderNo", orderNo);
				map.put("patientAddress", patientAddress);
				return new ModelAndView("index", "map", map);

				}
		    
		    public ModelAndView show_EVIDENCE_OF_RECENTDELIVERY_JSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
				
			 	jsp = "evidence_recent_dilevery";
				jsp += ".jsp";
				title = "CAUSE OF DEATH";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
	
		    public ModelAndView submmitTreetmentDischarge(HttpServletRequest request, HttpServletResponse response){
		    
		    	int hinId=0;
		    	String address="";
		    	String remarks1="";
		    	String adForter="";
		    	String conDis="";
		    	String treet="";
		    	String wocer="";
		    	String inresult="";
		    	String conatAdmi="";
		    	int docName=0;
		    	Date disDate=new Date();
		    	Date adDate=new Date();
		         String ipno="";
		    	int inpatientId=0;
		    	String mlcType="";
		    	String currentTime="";
		        Date currentDate =new Date();
		        int opdId=0;
		        int inPatientId=0;
		        HttpSession session=request.getSession();
		        String refNo = null;
		        Box box = HMSUtil.getBox(request);
		        Date refMLDate=null;
		        int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
		        box.put("userId", userId);
			    int hospitalId=0;
			    if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
				}
			      if(box.getString("flag").equalsIgnoreCase("submit")){
			      
			    	  
		          if (request.getParameter("refMLDate") != null  && !request.getParameter("refMLDate").equals("")) {
		        	  refMLDate= HMSUtil.convertStringTypeDateToDateType(request.getParameter("refMLDate"));
		     			     }

		          if (request.getParameter("refMLNo") != null  && !request.getParameter("refMLNo").equals("")) {
			        	
		        	  refNo=request.getParameter("refMLNo");
		    
		    		
				}
		          if (request.getParameter("address") != null  && !request.getParameter("address").equals("")) {
			        	
		        	  address=request.getParameter("address");
		    
		    		
				}
		    	if (request.getParameter("hinId") != null  && !request.getParameter("hinId").equals("0")) {
		    		hinId = Integer.parseInt(request.getParameter("hinId"));
				}
		    	    	
		    	if (request.getParameter("remarks1") != null  && !request.getParameter("remarks1").equals("")) {
		    		remarks1 = request.getParameter("remarks1");
				}
		    	if (session.getAttribute("hospitalId") != null) {
						hospitalId = (Integer) session.getAttribute("hospitalId");
						
					
					}
		    	if (request.getParameter("adForter") != null  && !request.getParameter("adForter").equals("")) {
		    		adForter = request.getParameter("adForter");
				}
		    	if (request.getParameter("conDis") != null  && !request.getParameter("conDis").equals("")) {
		    		conDis = request.getParameter("conDis");
				}
		    	

		    	if (request.getParameter("treet") != null  && !request.getParameter("treet").equals("")) {
		    		treet = request.getParameter("treet");
				}
		    	
		    	if (request.getParameter("wocer") != null  && !request.getParameter("wocer").equals("")) {
		    		wocer = request.getParameter("wocer");
				}
		    	

		    	if (request.getParameter("inresult") != null  && !request.getParameter("inresult").equals("")) {
		    		inresult = request.getParameter("inresult");
				}
		    	
		    	
		    	if (request.getParameter("conatAdmi") != null  && !request.getParameter("conatAdmi").equals("")) {
		    		conatAdmi = request.getParameter("conatAdmi");
				}
		    	

		    	if (request.getParameter("docName") != null  && !request.getParameter("docName").equals("")) {
		    		docName =Integer.parseInt(request.getParameter("docName"));
				}
		    	
		    	if (request.getParameter("disDate") != null  && !request.getParameter("disDate").equals("")) {
		    		disDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("disDate"));
				}
		    	

		    	if (request.getParameter("adDate") != null  && !request.getParameter("adDate").equals("")) {
		    		adDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("adDate"));
				}
		    	
		     if (request.getParameter(ADMISSION_NUMBER) != null  && !request.getParameter(ADMISSION_NUMBER).equals("")) {
		    		ipno =request.getParameter(ADMISSION_NUMBER);
				}
		    	       
				if (request.getParameter(RequestConstants.CHANGED_DATE) != null
						&& !(request.getParameter(RequestConstants.CHANGED_DATE).equals(""))) {
					currentDate = HMSUtil.convertStringTypeDateToDateType(request
							.getParameter(RequestConstants.CHANGED_DATE));
				}
				if (request.getParameter(RequestConstants.CHANGED_TIME) != null
						&& !(request.getParameter(RequestConstants.CHANGED_TIME).equals(""))) {
					currentTime = request.getParameter(RequestConstants.CHANGED_TIME);
				}
		    
		    	
				
		    	if (request.getParameter(ADMISSION_NUMBER) != null  && !request.getParameter(ADMISSION_NUMBER).equals("0")) {
		    		inpatientId = Integer.parseInt(request.getParameter(ADMISSION_NUMBER));
				}
		    	
		    	if (request.getParameter("detailId") != null  && !request.getParameter("detailId").equals("0")) {
		    		opdId = Integer.parseInt(request.getParameter("detailId"));
				}
		    	
		    	
		    	MedicoLegalDetails details=new MedicoLegalDetails();
		    	
		    	details.setAdmissionDate(adDate);
		    	details.setDischargeDate(disDate);
		    	details.setConditionAtDischarge(conDis);
		    	//details.setAdNo(ipno);
		    	if(inpatientId!=0)
		    	{
		    	Inpatient inpatient = new Inpatient();
		    	inpatient.setId(inpatientId);
		    	details.setInpatient(inpatient);
		    	}
		    	details.setInvResult(inresult);
		    	
		    	if(docName!=0){
		    		MasEmployee emp=new MasEmployee();
		    		emp.setId(docName);
		    		details.setDoctor(emp);
		    	}
		    	if(opdId != 0){
	    		OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	    			opdPatientDetails.setId(opdId);
	    			details.setOpdPatientDetail(opdPatientDetails);
		    		
		    	}
		    	
		    	details.setPatientAddress(address);
		    	details.setRefDate(refMLDate);
		    	details.setSerialNo(refNo);
		        Patient patient=new Patient();
		        patient.setId(hinId);
		        details.setTreatment(treet);
		    	details.setHin(patient);
		    	details.setPatientCondition(conatAdmi);
		    	details.setRemarks(remarks1);
		    	details.setAdviseOnDischarge(adForter);
		        details.setMlcType("TREATMENT / DISCHARGE CERTIFICATE");
		        details.setInjuryDetails(wocer);
		    	
		    	Users user=new Users();
		    	user.setId(userId);
		    	
		    	details.setLastChgBy(user);
		    	details.setLastChgDate(currentDate);
		    	details.setLastChgTime(currentTime);
		    

                if(request.getParameter(ADMISSION_NUMBER)!=null && !request.getParameter(ADMISSION_NUMBER).equals("0")){
                	inPatientId=Integer.parseInt(request.getParameter(ADMISSION_NUMBER));
                Inpatient inp=new Inpatient();
               inp.setId(inPatientId);
               details.setInpatient(inp);	
                       }
		    	   	map=mlcHandlerService.submmitTreetmentDischarge(details,opdId,hospitalId,refNo);
		    }
			      else{
			    	  	
			    	 	map=mlcHandlerService.updateTreetmentDischarge(box);
			      }
		    	
		    	
		    	
			 	String message = "";
				int medicoLegalDetailsId=0;
			 	Boolean saved = (Boolean) map.get("saveFlag");
			 	mlcType = (String) map.get("mlcType");
				medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
				String jsp = "";
				
				if (saved) {
					message="Record Added Successfully.";
				} else {
					message = "Some Problem Occured.";
				}
		//		map = mlcHandlerService.showUHIDJsp();
				map.put("message", message);
				map.put("hin_no", request.getParameter("uhinId"));
				map.put("inpatientId", inpatientId);
				map.put("medicoLegalDetailsId", medicoLegalDetailsId);
				
				map.put("mlcType", mlcType);
				jsp = "mlc_msg_MLC";
				jsp += ".jsp";
				title = "Tratement Discharge";
				map.put("contentJsp", jsp);
				map.put("title", title);
		    	
		    	
		    	return new ModelAndView("index", "map", map);
		    }
		    
			public ModelAndView showWaitinListshowDunknnessJSP(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        
		        map=mlcHandlerService.getWaitingListDunknness();
		        
		        String jsp = "certificate_waiting_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
			 
		    
		    
		    public ModelAndView showDunknnessJSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
				 Box box = HMSUtil.getBox(request);
			 	int id=0;
			 	String orderNo="";
			 	HttpSession session = request.getSession();
			 	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
			    if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		        } 
			    List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
		        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
		 		map = mlcHandlerService.getDunknness(box);
		 	     if(map.get("patientAddress")!=null){
		 	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		 	        }
		 	
		  		 
		  		if(map.get("patientWiseMlcs")!=null){
		  			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
		  	        }
		  		if(map.get("mlcList")!=null){
		  			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
		  	        }
		 		 
		 		 
			 //	map = mlcHandlerService.showTreatment_Dischargr_JSP();
			 	jsp = "certificate_of_drunkness";
				jsp += ".jsp";
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				map.put("mlcList", mlcList);
				map.put("patientWiseMlcs", patientWiseMlcs);
				map.put("patientAddress", patientAddress);
				return new ModelAndView("index", "map", map);

				}
		   

		    public ModelAndView submmitDrunknessCertifikate(HttpServletRequest request, HttpServletResponse response){
		    	int hinId=0;
		    	String policestation =null;
		        Date examinDate =null;
		        Date arrestdate =null;
		        Date exdate=null;
		        
		        String hcpcNo=null; 
		    	String address =null;
		    	String consent =null;
		    	String arrest =null;
		    	String reqname =null;
		    	String time =null;
		    	
		    	String extime =null;
		    	String marks1 =null;
		    	String marks2=null;
		    	String	alco1 =null;
		    	String alco2=null;
		    	String smell=null;
		    	String	cloth=null;
		    	String	disposition=null;
		    	String	speech=null;
		    	String	conjuntiva=null;
		    	String	pupils=null;
		    	String	high=null;
		    	String	memory=null;
		    	String	space=null;
		    	String	retime=null;
		    	String	gait=null;
		    	int	pulse=0;
		    	String	bp=null;
		    	String	romberg=null;
		    	String	injury=null;
		    	String	breath=null;
		    	int mediCoId=0;
		    	String	special=null;
		    	String finger=null;
		    	String reflexes=null;
		    	String urine=null;
		    	String blood=null;
		    	String opinion=null;
		         String currentTime="";
		         int opdId=0;
		         int inPatientId=0;
		         String serNo=null;
		        Date currentDate =new Date();
	        HttpSession session=request.getSession();
	      int userId = (Integer) session.getAttribute(RequestConstants.USER_ID);
	      Box box = HMSUtil.getBox(request);
	      int hospitalId=0;
	      if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				
			
			}
	      if(box.getString("flag").equalsIgnoreCase("submit")){
	      
	    	  
	    	  
		   	MedicoLegalDetails details=new MedicoLegalDetails();
		    	
		    	if (request.getParameter("hinId") != null  && !request.getParameter("hinId").equals("")) {
		    		hinId = Integer.parseInt(request.getParameter("hinId"));
		    		Patient patient=new Patient();
		    		patient.setId(hinId);
		    		details.setHin(patient);
				}
		    	
		    	if (request.getParameter("examinDate") != null  && !request.getParameter("examinDate").equals("")) {
		    		examinDate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("examinDate"));
		    		   		
		    		details.setRequisitionDate(examinDate);
		    	
				}
		    	 if (request.getParameter("policestation") != null  && !request.getParameter("policestation").equals("")) {
		    		 policestation=request.getParameter("policestation");
			    	details.setPoliceStation(policestation);
			    		
					}
		    	
		    	 if (request.getParameter("reflexes") != null  && !request.getParameter("reflexes").equals("")) {
		    		 reflexes=request.getParameter("reflexes");
			    	details.setReflexes(reflexes);
			    		
					}
		    	
		        if (request.getParameter("arrestdate") != null  && !request.getParameter("arrestdate").equals("")) {
		        	
		        	arrestdate=HMSUtil.convertStringTypeDateToDateType(request.getParameter("arrestdate"));
		    		details.setArrestDate(arrestdate);
		    		
				}
		          if (request.getParameter("hcpcNo") != null  && !request.getParameter("hcpcNo").equals("")) {
		        	  hcpcNo=request.getParameter("hcpcNo");
		    		details.setAdNo(hcpcNo);
		    		
				}
		          if (request.getParameter("serNo") != null  && !request.getParameter("serNo").equals("")) {
		        	  serNo=request.getParameter("serNo");
		    		details.setSerialNo(serNo);
		    		
				}
		      if (request.getParameter("exdate") != null  && !request.getParameter("exdate").equals("")) {
		    	  exdate= HMSUtil.convertStringTypeDateToDateType(request.getParameter("exdate"));
		    	   details.setExaminationDate(exdate);
		    	   
		     }

	          if (request.getParameter(RequestConstants.CHANGED_DATE) != null
		          && !(request.getParameter(RequestConstants.CHANGED_DATE).equals(""))) {
	               currentDate = HMSUtil.convertStringTypeDateToDateType(request
			.getParameter(RequestConstants.CHANGED_DATE));
	               details.setLastChgDate(currentDate);  
	               }
	           if (request.getParameter(RequestConstants.CHANGED_TIME) != null
		           && !(request.getParameter(RequestConstants.CHANGED_TIME).equals(""))) {
	           currentTime = request.getParameter(RequestConstants.CHANGED_TIME);
	           details.setLastChgTime(currentTime); 
	                }

		//-----------
		    	

               if(request.getParameter("inPatientId")!=null && !request.getParameter("inPatientId").equals("0")){
               	inPatientId=Integer.parseInt(request.getParameter("inPatientId"));
               Inpatient inp=new Inpatient();
              inp.setId(inPatientId);
              details.setInpatient(inp);	
                      }

		    	if (request.getParameter("consent") != null  && !request.getParameter("consent").equals("")) {
		    		consent=request.getParameter("consent");
		    		details.setConsent(consent);
				}
		    	
		    	if (request.getParameter("arrest") != null  && !request.getParameter("arrest").equals("")) {
		    		arrest=request.getParameter("arrest");
		    		details.setUnderArrest(arrest);
				}

		    	if (request.getParameter("reqname") != null  && !request.getParameter("reqname").equals("")) {
		    		reqname=request.getParameter("reqname");
		    		details.setRequisitionFrom(reqname);
				}
		    	
		    	if (request.getParameter("time") != null  && !request.getParameter("time").equals("")) {
		    		time =request.getParameter("time");
		    		details.setArrestTime(time);
				}

		    	if (request.getParameter("extime") != null  && !request.getParameter("extime").equals("")) {
		    		extime=request.getParameter("extime");
		    		details.setExaminationTime(extime);
				}
		    	
		    	
		    	if (request.getParameter("marks1") != null  && !request.getParameter("marks1").equals("")) {
		    		marks1=request.getParameter("marks1");
		    		details.setIdMark1(marks1);
		    	}
		    	

		    	if (request.getParameter("marks2") != null  && !request.getParameter("marks2").equals("")) {
		    		marks2=request.getParameter("marks2") ;
		    		
		    		details.setIdMark2(marks2);
				}
		    	
		    	if (request.getParameter("alco1") != null  && !request.getParameter("alco1").equals("")) {
		    	
		    		alco1=request.getParameter("alco1");
		    		details.setHistoryAlcoholConsumption(alco1);
				}
		    	

		    	if (request.getParameter("alco2") != null  && !request.getParameter("alco2").equals("")) {
		    		alco2=request.getParameter("alco2");
		    		
		    		details.setHistoryOfIllness(alco2);
				}
		     
		    
		    	
		        if (request.getParameter("cloth") != null  && !request.getParameter("cloth").equals("")) {
			   cloth=request.getParameter("cloth") ;
		    		
		    		details.setClothing(cloth);
				}
		      if (request.getParameter("disposition") != null  && !request.getParameter("disposition").equals("")) {
			
			    disposition=request.getParameter("disposition");
			   details.setGeneralDisposition(disposition);
		       }
		        if (request.getParameter("speech") != null  && !request.getParameter("speech").equals("")) {
			   speech=request.getParameter("speech") ;
			
			   details.setSpeech(speech);
		         }
		        if (request.getParameter("conjuntiva") != null  && !request.getParameter("conjuntiva").equals("")) {
			conjuntiva=request.getParameter("conjuntiva");
			
			    details.setConjunctiva(conjuntiva);
		        }
		         if (request.getParameter("pupils") != null  && !request.getParameter("pupils").equals("")) {
			        pupils=request.getParameter("pupils");
			
			     details.setPupils(pupils);
		           }
		          if (request.getParameter("high") != null  && !request.getParameter("high").equals("")) {
			
			    high=request.getParameter("high");
			     details.setSelfControl(high);
		        }
		          if (request.getParameter("memory") != null  && !request.getParameter("memory").equals("")) {
			
			       memory=request.getParameter("memory");
			
			          details.setMemory(memory);
		       }
		          
		        if (request.getParameter("space") != null  && !request.getParameter("space").equals("")) {
			   space=request.getParameter("space");
			
			       details.setOrientation(space);
		          }
		         if (request.getParameter("retime") != null  && !request.getParameter("retime").equals("")) {
			   retime=request.getParameter("retime");
			
			     details.setReactionTime(retime);
		          }

		    if (request.getParameter("gait") != null  && !request.getParameter("gait").equals("")) {
			  gait=request.getParameter("gait");
			
			   details.setGait(gait);
		      }
		    
		  if (request.getParameter("pulse") != null  && !request.getParameter("pulse").equals("")) {
			
			  pulse=Integer.parseInt(request.getParameter("pulse"));
			  details.setPulse(pulse);
		    }
		  
		   if (request.getParameter("bp") != null  && !request.getParameter("bp").equals("")) {
			
			 bp=request.getParameter("bp") ;
			 details.setBp(bp);
		     }
		   if (request.getParameter("finger") != null  && !request.getParameter("finger").equals("")) {
				
			   finger=request.getParameter("finger");
				details.setFingerNoseTest(finger);
			}
		   

		           if (request.getParameter("romberg") != null  && !request.getParameter("romberg").equals("")) {
			
			     romberg=request.getParameter("romberg");
			     details.setRombergsSign(romberg);
		          }

		      if (request.getParameter("injury") != null  && !request.getParameter("injury").equals("")) {
			
			 injury=request.getParameter("injury");
			     details.setInjuryOnBody(injury);
		          }
		      
		  	
		    	if (request.getParameter("smell") != null  && !request.getParameter("smell").equals("")) {
		    		smell=request.getParameter("smell");
		    		
		    		details.setAlcoholSmell(smell);
				}

		      if (request.getParameter("breath") != null  && !request.getParameter("breath").equals("")) {
			
			         breath=request.getParameter("breath");
			    details.setBreath(breath);
		           }

	
		       if (request.getParameter("blood") != null  && !request.getParameter("blood").equals("")) {
		    	   blood=request.getParameter("blood");
		    	   details.setBloodExamination(blood);
			    	 
			     }
		       if (request.getParameter("urine") != null  && !request.getParameter("urine").equals("")) {
		    	   urine=request.getParameter("urine");
		    	   details.setUrinated(urine); 
			     }
		       
		       if (request.getParameter("opinion") != null  && !request.getParameter("opinion").equals("")) {
		    	   opinion=request.getParameter("opinion");
		    		details.setOpinion(opinion);
				}
		       
		       details.setMlcType("Certificate Of Drunkness");
		     if(userId!=0){
		       Users user=new Users();
		    	user.setId(userId);
		      	details.setLastChgBy(user);
		         }
		     details.setLastChgDate(currentDate);
		    	details.setLastChgTime(currentTime);
		    	
	           if (request.getParameter("detailId") != null  && !request.getParameter("detailId").equals("")) {
	        	   opdId=Integer.parseInt(request.getParameter("detailId"));
	        	   OpdPatientDetails opdPatientDetails = new OpdPatientDetails();
	        	   opdPatientDetails.setId(opdId);
	        	   details.setOpdPatientDetail(opdPatientDetails);
				}
	           
		      
		   	map=mlcHandlerService.submmitDrunknessCertifikate(details,opdId,hospitalId);
	      }
	      else{
	    	  
	    	
	    	  
	    	   userId = (Integer) session.getAttribute("userId");
				box.put("userId", userId);
					
	    	 	map=mlcHandlerService.updateDrunknessCertifikate(box);
	      }
	      
			 	String message = "";
			 	String mlcType="";
			 	int medicoLegalDetailsId=0;
			 	Boolean saved = (Boolean) map.get("saveFlag");
			 	mlcType = (String) map.get("mlcType");
			 	medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
				String jsp = "";
				
				if (saved) {
					message = "Record Added Successfully.";
				} else {
					message = "Some Problem Occured.";
				}
				map.put("hin_no", request.getParameter("uhinId"));
				map.put("mlcType", mlcType);
				map.put("message", message);
				map.put("medicoLegalDetailsId", medicoLegalDetailsId);
				jsp = "mlc_msg_MLC";
				jsp += ".jsp";
				title = "Certificate Of Drunkness";
				map.put("contentJsp", jsp);
				map.put("title", title);
		    	
		    	
		    	return new ModelAndView("index", "map", map);
		    }
		        
		    
		    
		    public ModelAndView showMedicolegalRegisterJSP(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
		         map = mlcHandlerService.showUHIDJsp();
			 	map = mlcHandlerService.showTreatment_Dischargr_JSP();
			 	jsp = "medico_legalRegister";
				jsp += ".jsp";
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);

			}
		    
		    
		    public ModelAndView getMedicolegalRegisterDetail(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 		 
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
			    
			    
			 	map = mlcHandlerService.getMedicolegalRegisterDetail(box);
			 	jsp = "responce_Register";
				
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);

			}
		      
		    public ModelAndView getUhid(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
				HttpSession session = request.getSession();
				Box box = HMSUtil.getBox(request);
				int hospitalId = 0;
				if (session.getAttribute("hospitalId") != null) 
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId",hospitalId);
			    
				if (session.getAttribute("empId") != null) {
					box.put("empId", (Integer)session.getAttribute("empId"));
				}
			 	map = mlcHandlerService.getUhid(box);
			 	jsp = "responce_Uhid";
				
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);

			}
		      		    
		    
		    public ModelAndView getDetailAndDisplay(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 		 
				HttpSession session = null;
				Box box = HMSUtil.getBox(request);
				 map = mlcHandlerService.showUHIDJsp();
				map = mlcHandlerService.showTreatment_Dischargr_JSP();     
			 	map = mlcHandlerService.getDetailAndDisplay(box);
			 	jsp = "responce_Detail";
				
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);

			}
		    
		

		    public ModelAndView submmitMedicoRegister(HttpServletRequest request, HttpServletResponse response){
		    
		    	int hinId=0;
		   	
		    	String policestation =null;
		        Date regDate =null;
		        Date reqDate =null;
		        
		        String  rfNo =null;
		        String  reqForm=null;
		        String crno=null;


		    	String exareq =null;
		    	int docName =0;
		      	String refNo = null;
		    	
		    	
		    	MedicoLegalDetails details=new MedicoLegalDetails();
		    	
		    	
		    	if (request.getParameter("hinId") != null  && !request.getParameter("hinId").equals("")) {
		    		hinId = Integer.parseInt(request.getParameter("hinId"));
		    		Patient patient=new Patient();
		    		patient.setId(hinId);
		    		details.setHin(patient);
				}
		    	
		    	
		          if (request.getParameter("policestation") != null  && !request.getParameter("policestation").equals("")) {
		        	
		        	  policestation=request.getParameter("policestation");
		    		details.setPoliceStation(policestation);
		    		
				}
		          
		          if (request.getParameter("reqDate") != null  && !request.getParameter("reqDate").equals("")) {
		        	  reqDate= HMSUtil.convertStringTypeDateToDateType(request.getParameter("reqDate"));
		        	  details.setRequisitionDate(reqDate);
				
			     }
		          
		          if (request.getParameter("regDate") != null  && !request.getParameter("regDate").equals("")) {
		        	  reqDate= HMSUtil.convertStringTypeDateToDateType(request.getParameter("regDate"));
		        	//  details.setRe
				
			     }

		          
		          
		          
		          if (request.getParameter("refNo") != null  && !request.getParameter("refNo").equals("")) {
			        	
		        	  rfNo=request.getParameter("refNo");
		    //		details.setref
		    		
				}
		          if (request.getParameter("reqForm") != null  && !request.getParameter("reqForm").equals("")) {
			        	
		        	  reqForm=request.getParameter("reqForm");
		    		details.setRequisitionFrom(reqForm);
		    		
				}
		          if (request.getParameter("crno") != null  && !request.getParameter("crno").equals("")) {
			        	
		        	  crno=request.getParameter("crno");
		    		details.setCrimeNo(crno);
		    		
				}
			        if (request.getParameter("exareq") != null  && !request.getParameter("exareq").equals("")) {
			        	
			        	exareq=request.getParameter("exareq");
			    //		details.setex
			    		
					}  
		        
	          if (request.getParameter("docName") != null  && !request.getParameter("docName").equals("")) {
			        	
	        	  docName=Integer.parseInt(request.getParameter("docName"));
	        	  MasEmployee doctor=new MasEmployee();
	        	  doctor.setId(docName);
	        	  details.setDoctor(doctor);
			    		
					} 
			        
		    	
		      
		      
		      details.setMlcType("Medico-Legal Register");


		    	map=mlcHandlerService.submmitMedicoRegister(details);
		  
			 	String message = "";

			 	Boolean saved = (Boolean) map.get("saveFlag");
				
				String jsp = "";
				
				if (saved) {
					message="Data Saved";
				} else {
					message = "Some Problem Occured.";
				}
				
				map.put("message", message);
				jsp = "certificate_of_drunkness";
				jsp += ".jsp";
				title = "Tratement Discharge";
				map.put("contentJsp", jsp);
				map.put("title", title);
		    	
		    	
		    	return new ModelAndView("index", "map", map);
		    }
		
		 
					    
		   
			   @SuppressWarnings("unused")
				public ModelAndView generateReportofAccident(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> parameters = new HashMap<String, Object>();
					Map<String, Object> requestParameters = new HashMap<String, Object>();
					String fileName = null;
					int hinId=0;
					HttpSession session = request.getSession();
					String institute=null;
					int hospitalId = 0;
					session = request.getSession();
					String grnType = "";
					requestParameters.put("hospitalId", session.getAttribute("hospitalId"));
				  try{
				if (request.getParameter("hinId") != null  && !request.getParameter("hinId").equals("")) {
				    		hinId = Integer.parseInt(request.getParameter("hinId"));
				    		requestParameters.put("UHID_No", hinId);
						}
					  
				  }catch(Exception e){
					  
				  }
				
				    requestParameters.put("SUBREPORT_DIR",
					getServletContext().getRealPath("/Reports/"));

									    
					Map<String, Object> connectionMap = mlcHandlerService.getConnection();
					HMSUtil.generateReport("policeIntimation", requestParameters,
							(Connection) connectionMap.get("con"), response,
							getServletContext());
					

					
					return null;
				}
				
				
				
				   @SuppressWarnings("unused")
				public ModelAndView generateReportofAccidentWound(HttpServletRequest request,
						HttpServletResponse response) {
					Map<String, Object> parameters = new HashMap<String, Object>();
					Map<String, Object> requestParameters = new HashMap<String, Object>();
					String fileName = null;
					HttpSession session = request.getSession();
					String hinNo="";
					int hospitalId = 0;
					String hospitalName = "";
					session = request.getSession();
					String grnType = "";
					Box box = HMSUtil.getBox(request);
					int medicoLegalId = 0;
					requestParameters.put("hospitalId", session.getAttribute("hospitalId"));
				
					  
							if (request.getParameter("hinNo") != null  && !request.getParameter("hinNo").equals("")) {
								hinNo = request.getParameter("hinNo");
							    		requestParameters.put("UHID_No", hinNo);
							    		box.put("hinNo", hinNo);
								}
							if (request.getParameter("medicoLegalId") != null  && !request.getParameter("medicoLegalId").equals("")) {
								medicoLegalId = Integer.parseInt(request.getParameter("medicoLegalId"));
					    		requestParameters.put("medico_legal_details_id", medicoLegalId);
							}
							
					  map = mlcHandlerService.updateWoundCertificateStatus(box);
					
					requestParameters.put("SUBREPORT_DIR",
							getServletContext().getRealPath("/Reports/"));
					Map<String, Object> connectionMap = mlcHandlerService.getConnection();
					HMSUtil.generateReport("accidentRegisterCumWoundCertificate", requestParameters,
							(Connection) connectionMap.get("conn"), response,
							getServletContext());
					return null;
				}
				
		public void checkWoundCertificate(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String,Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			Map<String, Object> utilMap = new HashMap<String, Object>();
			String uhid = "";
			String hospitalName = "";
			if(request.getParameter("uhid") != null){
				uhid = request.getParameter("uhid");
				box.put("uhid", uhid);
			}
			if(session.getAttribute("hospitalName") != null){
				hospitalName = (String)session.getAttribute("hospitalName");
			}
			map = mlcHandlerService.checkWoundCertificate(box);
			List<MedicoLegalDetails> medicoLegalList = new ArrayList<MedicoLegalDetails>();
			if(map.get("medicoLegalList") != null){
				medicoLegalList = (List)map.get("medicoLegalList");
			}
			String date = "";
			String currentTime = "";
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			date = (String) utilMap.get("currentDate");
			currentTime = (String) utilMap.get("currentTime");
			try {
				StringBuffer sb = new StringBuffer();
				sb.append("<item>");
				
					if (medicoLegalList.size()>0) {
						Date examinationDate =medicoLegalList.get(0) .getExaminationDate();
						String examDate =HMSUtil.convertDateToStringTypeDate(examinationDate);
						String curDate = date+" "+currentTime;
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
						Date d1 = null;
						Date d2 = null;
						 try {
						    d1 = format.parse(examDate);
						    d2 = format.parse(curDate);
							} catch (ParseException e) {
							    e.printStackTrace();
							}    
								 long diff = d2.getTime() - d1.getTime();
								 long diffHours = diff / (60 * 60 * 1000);
								 long diffInDays = diff / (24 * 60 * 60 * 1000);
					 if(diffInDays>30){
						sb.append("<msg>" + "Wound Certificate Already generated on "+HMSUtil.convertDateToStringWithoutTime(examinationDate)+" in "+hospitalName+" . Do You Want to Continue.  " + "</msg>");
					 }/*else{
						 
					 }
					} else {
						//sb.append("<msg>" + "" + "</msg>");
*/					}
					
					
					sb.append("</item>");
					response.setContentType("text/xml");
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().write(
							"<?xml version='1.0' encoding='ISO-8859-1'?>");
					response.getWriter().write("<items>");
					response.getWriter().write(sb.toString());
					response.getWriter().write("</items>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//
			}
			
	
		    
		  //------------------ END Avinash --------------------------------
		
		
 
	//-------------------------------------------code by anamika-----------------------------------------------------------
	    
	    public ModelAndView showMortuaryRegisterJsp(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String,Object>();
			HttpSession session = request.getSession();
			Box box = HMSUtil.getBox(request);
			int opdPatientDetailId=0;
			int dischargeId=0;
			int empId  = 0;
			int number=0;
			String empName = "";
			if (session.getAttribute("users") != null) {
				Users users = (Users) session.getAttribute("users");
				empId = users.getEmployee().getId();
				empName = users.getEmployee().getEmployeeName();
				
			}
			if(request.getParameter("pType") != null )
			{
			   number =Integer.parseInt(request.getParameter("numberId"));
		       box.put("number", number);
			}
			if(request.getParameter("pType") != null )
			{
				String type=request.getParameter("pType");
				if(type.equals("OP")){
				opdPatientDetailId =Integer.parseInt(request.getParameter("opdPatientDetailId"));
			    box.put("opdPatientDetailId", opdPatientDetailId);
				}else{
					dischargeId =Integer.parseInt(request.getParameter("dischargeId"));
				    box.put("dischargeId", dischargeId);
				}
			}
			
			System.out.println(opdPatientDetailId);
			int hospitalId=(Integer)session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			String hospitalCode = "";
			String financialYearDesc = "";
			if (session.getAttribute("hospitalCode") != null) {
				hospitalCode = (String) session.getAttribute("hospitalCode");
			}
			box.put("hospitalCode", hospitalCode);
			if (session.getAttribute("fYearDesc1") != null) {
				financialYearDesc = (String) session.getAttribute("fYearDesc1");
			}
			box.put("financialYearDesc", financialYearDesc);
			map = mlcHandlerService.showMortuaryRegisterJsp(box);
	    	jsp = "mortuaryRegisterJsp";
			jsp += ".jsp";
			title = "CAUSE OF DEATH";
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("empId", empId);
			map.put("empName", empName);
			return new ModelAndView("index", "map", map);

			}
		
		public void getMedicoLegalDetailsForMortuary(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String,Object>();
			Box box = HMSUtil.getBox(request);
			String hinNo = "";
			if (request.getParameter("hinNo") != null && !(request.getParameter("hinNo").equals("0"))) {
				hinNo = request.getParameter("hinNo");
					box.put("hinNo", hinNo);
				}
			List<MedicoLegalDetails> medicoLegalList = new ArrayList<MedicoLegalDetails>();
				map = mlcHandlerService.getMedicoLegalDetailsForMortuary(box);
				if (map.get("medicoLegalList") != null) {
					medicoLegalList = (List) map.get("medicoLegalList");
				}
			
					try {
						StringBuffer sb = new StringBuffer();
						sb.append("<item>");
						for (MedicoLegalDetails medicoLegalDetails : medicoLegalList) {
							if (medicoLegalDetails.getHin().getId()!= null && !medicoLegalDetails.getHin().getId().equals("")) {
								sb.append("<hinId>" + medicoLegalDetails.getHin().getId() + "</hinId>");
							} else {
								sb.append("<hinId>" + "" + "</hinId>");
							}
							
							if (medicoLegalDetails.getId()!= null && !medicoLegalDetails.getId().equals("")) {
								sb.append("<mlcId>" + medicoLegalDetails.getId() + "</mlcId>");
							} else {
								sb.append("<mlcId>" + "" + "</mlcId>");
							}
							
							if (medicoLegalDetails.getHin().getFullName()!= null && !medicoLegalDetails.getHin().equals("")) {
								sb.append("<name>" + medicoLegalDetails.getHin().getFullName() + "</name>");
							} else {
								sb.append("<name>" + "" + "</name>");
							}
							if (medicoLegalDetails.getHin().getAge() != null	&& !medicoLegalDetails.getHin().getAge().equals("")) {
								sb.append("<age>" + medicoLegalDetails.getHin().getAge()+ "</age>");
							} else {
								sb.append("<age>" + " " + "</age>");
							}
							
							if (medicoLegalDetails.getHin().getSex() != null && !medicoLegalDetails.getHin().getSex().equals("")) {
								sb.append("<Gender>" + medicoLegalDetails.getHin().getSex().getAdministrativeSexName()
										+ "</Gender>");
							} else {
								sb.append("<Gender>" + " " + "</Gender>");
							}
						}
							sb.append("</item>");
							response.setContentType("text/xml");
							response.setHeader("Cache-Control", "no-cache");
							response.getWriter().write(
									"<?xml version='1.0' encoding='ISO-8859-1'?>");
							response.getWriter().write("<items>");
							response.getWriter().write(sb.toString());
							response.getWriter().write("</items>");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//
					}
		
		public ModelAndView submitMortuaryRegister(HttpServletRequest request, HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String,Object>();
			HttpSession httpSession=request.getSession();
			Box box = HMSUtil.getBox(request);  
			String hospitalCode = "";
			String financialYearDesc = "";
			int hospitalId=(Integer)httpSession.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
			if (httpSession.getAttribute("hospitalCode") != null) {
				hospitalCode = (String) httpSession.getAttribute("hospitalCode");
			}
			box.put("hospitalCode", hospitalCode);
			if (httpSession.getAttribute("fYearDesc1") != null) {
				financialYearDesc = (String) httpSession.getAttribute("fYearDesc1");
			}
			box.put("financialYearDesc", financialYearDesc);
			map = mlcHandlerService.submitMortuaryRegister(box);
			boolean flag = true;
			if (map.get("flag") != null) {
				flag = (Boolean) map.get("flag");
			}
			String msg = "";
			
			if(box.getString("flagStatus").equalsIgnoreCase("save")){
				msg = "Record Saved Successfully";
				map = mlcHandlerService.showMortuaryRegisterJsp(box); 
				 jsp = "mortuaryRegisterJsp";
				 jsp += ".jsp";
			}else{
				if (flag) {
					msg = "Record Saved Successfully";
				} else {
					msg = "Records Not Added/Updated!... Try Again.....";
					map.put("messageType", "failure");
				}
				//url = "/hms/hms/mlc?method=showMortuaryRegisterJsp";
				
				jsp = "msgForMlc";
				jsp += ".jsp";
		}
			String title = "CAUSE OF DEATH";
			map.put("contentJsp", jsp);
			map.put("title", title);
			//map.put("url", url);
			map.put("msg", msg);
			return new ModelAndView("index", "map", map);

			}
		
		
		public ModelAndView showPostmortemDetailNotesJsp(HttpServletRequest request,HttpServletResponse response)
		{
			
			Map<String, Object> map = new HashMap<String,Object>();
			Box box = HMSUtil.getBox(request);
			int mortuaryRegdDetailId=0;
			if(request.getParameter("mortuaryRegdDetailId")!=null && !request.getParameter("mortuaryRegdDetailId").equals(""))
			{
			mortuaryRegdDetailId=Integer.parseInt(request.getParameter("mortuaryRegdDetailId").toString());
			box.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
			}
			
			map = mlcHandlerService.showPostmortemDetailNotesJsp(box);
				
			jsp = "postMortemDetailedNotes";
				
			jsp += ".jsp";	
			title = "CAUSE OF DEATH";	
			map.put("contentJsp", jsp);
			map.put("title", title);
				return new ModelAndView("index", "map", map);

				}
			
		
		
		public void getPostmortemDetails(HttpServletRequest request, HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String,Object>();
				Box box = HMSUtil.getBox(request);
				String hinNo = "";
				if (request.getParameter("hinNo") != null && !(request.getParameter("hinNo").equals("0"))) {
					hinNo = request.getParameter("hinNo");
						box.put("hinNo", hinNo);
					}
				List<MortuaryRegisterDetails> mortuaryDetailList = new ArrayList<MortuaryRegisterDetails>();
					map = mlcHandlerService.getPostmortemDetails(box);
					if (map.get("mortuaryDetailList") != null) {
						mortuaryDetailList = (List) map.get("mortuaryDetailList");
					}
				
						try {
							StringBuffer sb = new StringBuffer();
							sb.append("<item>");
							for (MortuaryRegisterDetails mortuaryRegisterDetails : mortuaryDetailList) {
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getId()!= null && !mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getId().equals("")) {
									sb.append("<hinId>" + mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getId() + "</hinId>");
								} else {
									sb.append("<hinId>" + "" + "</hinId>");
								}
								
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getId()!= null && !mortuaryRegisterDetails.getMedicoLegalDetails().getId().equals("")) {
									sb.append("<mlcId>" + mortuaryRegisterDetails.getMedicoLegalDetails().getId() + "</mlcId>");
								} else {
									sb.append("<mlcId>" + "" + "</mlcId>");
								}
								
								if (mortuaryRegisterDetails.getId()!= null && !mortuaryRegisterDetails.getId().equals("")) {
									sb.append("<mortuaryId>" + mortuaryRegisterDetails.getId() + "</mortuaryId>");
								} else {
									sb.append("<mortuaryId>" + "" + "</mortuaryId>");
								}
								
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getFullName()!= null && !mortuaryRegisterDetails.getMedicoLegalDetails().getHin().equals("")) {
									sb.append("<name>" + mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getFullName() + "</name>");
								} else {
									sb.append("<name>" + "" + "</name>");
								}
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getAge() != null	&& !mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getAge().equals("")) {
									sb.append("<age>" + mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getAge()+ "</age>");
								} else {
									sb.append("<age>" + " " + "</age>");
								}
								
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getSex() != null && !mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getSex().equals("")) {
									sb.append("<Gender>" + mortuaryRegisterDetails.getMedicoLegalDetails().getHin().getSex().getAdministrativeSexName()
											+ "</Gender>");
								} else {
									sb.append("<Gender>" + " " + "</Gender>");
								}
								
								if (mortuaryRegisterDetails.getCrimeNo() != null && !mortuaryRegisterDetails.getCrimeNo().equals("")) {
									sb.append("<crimeNo>" + mortuaryRegisterDetails.getCrimeNo() + "</crimeNo>");
								} else {
									sb.append("<crimeNo>" + "" + "</crimeNo>");
								}
								
								if (mortuaryRegisterDetails.getCrimeDate() != null && !mortuaryRegisterDetails.getCrimeDate().equals("")) {
									sb.append("<crimeDate>" + HMSUtil.convertDateToStringWithoutTime(mortuaryRegisterDetails.getCrimeDate()) + "</crimeDate>");
								} else {
									sb.append("<crimeDate>" + "" + "</crimeDate>");
								}
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getHeight() != null && !mortuaryRegisterDetails.getMedicoLegalDetails().getHeight().equals("")) {
									sb.append("<height>" + mortuaryRegisterDetails.getMedicoLegalDetails().getHeight() + "</height>");
								} else {
									sb.append("<height>" + "" + "</height>");
								}
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getWeight() != null && !mortuaryRegisterDetails.getMedicoLegalDetails().getWeight().equals("")) {
									sb.append("<weight>" + mortuaryRegisterDetails.getMedicoLegalDetails().getWeight()+ "</weight>");
								} else {
									sb.append("<weight>" + "" + "</weight>");
								}
								
								if (mortuaryRegisterDetails.getDeadBodyKeptDate() != null && !mortuaryRegisterDetails.getDeadBodyKeptDate().equals("")) {
									sb.append("<keptDate>" + HMSUtil.convertDateToStringWithoutTime(mortuaryRegisterDetails.getDeadBodyKeptDate())+ "</keptDate>");
								} else {
									sb.append("<keptDate>" + "" + "</keptDate>");
								}
								
								if (mortuaryRegisterDetails.getDeadBodyKeptTime() != null && !mortuaryRegisterDetails.getDeadBodyKeptTime().equals("")) {
									sb.append("<keptTime>" + mortuaryRegisterDetails.getDeadBodyKeptTime()+ "</keptTime>");
								} else {
									sb.append("<keptTime>" + "" + "</keptTime>");
								}
								
								if (mortuaryRegisterDetails.getMedicoLegalDetails().getPoliceStation() != null && !mortuaryRegisterDetails.getMedicoLegalDetails().getPoliceStation() .equals("")) {
									sb.append("<policeStation>" + mortuaryRegisterDetails.getMedicoLegalDetails().getPoliceStation() + "</policeStation>");
								} else {
									sb.append("<policeStation>" + "" + "</policeStation>");
								}
							}
								sb.append("</item>");
								response.setContentType("text/xml");
								response.setHeader("Cache-Control", "no-cache");
								response.getWriter().write(
										"<?xml version='1.0' encoding='ISO-8859-1'?>");
								response.getWriter().write("<items>");
								response.getWriter().write(sb.toString());
								response.getWriter().write("</items>");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							//
						}
			
			public ModelAndView showPostmortemExaminationJsp(HttpServletRequest request,HttpServletResponse response){
				Map<String, Object> map = new HashMap<String,Object>();
				
				   Box box = HMSUtil.getBox(request);
					int id=0;
					int mortuaryRegdDetailId=0;
			        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
			        	id=Integer.parseInt(request.getParameter("requestId").toString());
			          
			        } 
			        if(request.getParameter("mortuaryRegdDetailId")!=null && !request.getParameter("mortuaryRegdDetailId").equals("")){
			        	mortuaryRegdDetailId=Integer.parseInt(request.getParameter("mortuaryRegdDetailId").toString());
			        	box.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
			        }
			        
				map = mlcHandlerService.showPostmortemExaminationJsp(box);
					jsp = "postmortemExaminations";
					jsp += ".jsp";
					title = "CAUSE OF DEATH";
					map.put("contentJsp", jsp);
					map.put("title", title);
					return new ModelAndView("index", "map", map);
                 }
			
			public ModelAndView updatePostMortemExamination(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String,Object>();
				Box box = HMSUtil.getBox(request);
				
				map = mlcHandlerService.updatePostMortemExamination(box);
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				String msg = "";
					if (flag) {
						msg = "Record update Successfully";
					} else {
						msg = "Records Not Added/Updated!... Try Again.....";
						map.put("messageType", "failure");
					}
					//url = "/hms/hms/mlc?method=showPostmortemExaminationJsp";
					
					jsp = "msgForPostmortem";
					jsp += ".jsp";
			
				map.put("contentJsp", jsp);
				map.put("title", title);
				//map.put("url", url);
				map.put("msg", msg);
				return new ModelAndView("index", "map", map);	
			}
			
			
			public ModelAndView updatePostMortemDetailedNotes(HttpServletRequest request,HttpServletResponse response) {
				Map<String, Object> map = new HashMap<String,Object>();
				Box box = HMSUtil.getBox(request);
				
				map = mlcHandlerService.updatePostMortemDetailedNotes(box);
				boolean flag = true;
				if (map.get("flag") != null) {
					flag = (Boolean) map.get("flag");
				}
				String msg = "";
				
					if (flag) {
						msg = "Record update Successfully";
					} else {
						msg = "Records Not Added/Updated!... Try Again.....";
						map.put("messageType", "failure");
					}
					//url = "/hms/hms/mlc?method=showPostmortemDetailNotesJsp";
					
					jsp = "msgForPostmortemDetailedNote";
					jsp += ".jsp";
			
				map.put("contentJsp", jsp);
				map.put("title", title);
				//map.put("url", url);
				map.put("msg", msg);
				return new ModelAndView("index", "map", map);	
			}
			
			//===========================End of code by anamika============================================================//
	    
	  
		
		  	public ModelAndView showWaitingListAccidentalRegistration(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		    	int detailId=0;
		        Map<String, Object> map = new HashMap<String, Object>();
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	detailId=Integer.parseInt(request.getParameter("requestId").toString());
		        } 
		        map=mlcHandlerService.getWaitingListAccidentalRegistration();
		        
		        String jsp = "accident_woundcertificate_waiting_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	 
	    public ModelAndView showAccidentalRegistrationJsp(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	        int id=0;
	        String orderNo="";
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        } 
	        int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
	        map=mlcHandlerService.getAccidentalRegistration(box);
	        orderNo = (String) map.get("orderNo");
	        if(map.get("patientAddress")!=null){
	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
	        }
	        String jsp = "accident_register_cum_wound_certificate";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        map.put("orderNo", orderNo);
	        map.put("patientAddress", patientAddress);
	        return new ModelAndView("index", "map", map);
	    } 
	    
//VK
	    public ModelAndView addAccidentalRegistration(HttpServletRequest request,HttpServletResponse response)
	    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			String jsp="";
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
			map = mlcHandlerService.addAccidentalRegistration(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
		
			if(map.get("message") != null && !map.get("message").equals("")){
				message = "Record already exist!!!!!";
				 jsp = "accident_register_cum_wound_certificate";
				
			}else{
				if (successfullyAdded) {
					message = "Record Saved Successfully";
				} else {
					message = "Records Not Added/Updated!... Try Again.....";
					map.put("messageType", "failure");
				}
				url = "/hms/hms/mlc?method=showAccidentalRegistrationJsp";
				
				jsp = "mlc_msg_MLC";
				
			}
			
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 
	  
	  
	    
	  //VK   
	  //Form of Application cum Certificate of Authenticity
	  	
	  	  public ModelAndView certificateOfAuthenticityJsp(HttpServletRequest request,
	  				HttpServletResponse response) {
	  			Map<String, Object> map = new HashMap<String, Object>();
	  		 
	  		   String jsp ="certificate_of_authenticity" + ".jsp";
	  			 
	  			title = "Certificate Of Authenticity";
	  			map.put("contentJsp", jsp);
	  			map.put("title", title);

	  			return new ModelAndView("index", "map", map);
	  		}

	  //VK
	   //	AMBULANCE / CREMATION / BURIAL/ EMBALMING CERTIFICATE
	  	  
	  	  public ModelAndView ambulanceEmbalmingCertificateJsp(HttpServletRequest request,
	  				HttpServletResponse response) {
	  			Map<String, Object> map = new HashMap<String, Object>();
	  		 
	  		   String jsp ="ambulance_embalming_certificate" + ".jsp";
	  			 
	  			title = "AMBULANCE /CREMATION/BURIAL/EMBALMING CERTIFICATE";
	  			map.put("contentJsp", jsp);
	  			map.put("title", title);

	  			return new ModelAndView("index", "map", map);
	  		} 
	 
	  	//VK
	   // CERTIFICATE OF DRUNKENNESS
	  	  
	  	  public ModelAndView certificateOfDrunknessJsp(HttpServletRequest request,
	  				HttpServletResponse response) {
	  			Map<String, Object> map = new HashMap<String, Object>();
	  		 
	  		   String jsp ="certificate_of_drunkness" + ".jsp";
	  			 
	  			title = "Certificate Of Drunkness";
	  			map.put("contentJsp", jsp);
	  			map.put("title", title);

	  			return new ModelAndView("index", "map", map);
	  		}

   //VK	  	 
	  	  
	  	  public ModelAndView druggedMlcJsp(HttpServletRequest request,
	  				HttpServletResponse response) {
	  			Map<String, Object> map = new HashMap<String, Object>();
	  		 
	  		   String jsp ="drugged_mlc" + ".jsp";
	  			 
	  			title = "VICTIM ALLEGED TO HAVE BEEN DRUGGED";
	  			map.put("contentJsp", jsp);
	  			map.put("title", title);

	  			return new ModelAndView("index", "map", map);
	  		}
	
//---------------
	  	  
	  	public ModelAndView showWaitinListCouseOfDeathFinal(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListCouseOfDeathFinal();
	        
	        String jsp = "couseOfdeath_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
  	  
	  	  
	  	  public ModelAndView showCouseOfDeathFinal(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
		        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
		        String orderNo="";
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		        
		        } 
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
		      map=mlcHandlerService.getCouseOfDeathFinal(box);
		        
		      orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
		        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		        }
		        if(map.get("patientWiseMlcs")!=null){
		 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
		 	        }
		 		if(map.get("mlcList")!=null){
		 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
		 	        }
			      String jsp = "couseOfdeath_mlcJsp";
			      
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        map.put("mlcList", mlcList);
		        map.put("patientWiseMlcs", patientWiseMlcs);
		        map.put("orderNo", orderNo);
		        map.put("patientAddress", patientAddress);
		        return new ModelAndView("index", "map", map);
		    }
	  	  
	  	public ModelAndView submitCouseOfDeathFinal(HttpServletRequest request,HttpServletResponse response)
		    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			  int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
			map = mlcHandlerService.addCouseOfDeathFinal(box);
			boolean successfullyAdded = false;
			String message = "";
			
			int medicoLegalDetailsId=0;
			String mlcType=""; 
			medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (map.get("mlcType") != null) {
				mlcType = (String) map.get("mlcType");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.Do you want to Report?";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("mlcType", mlcType);
			map.put("medicoLegalDetailsId", medicoLegalDetailsId);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);
	
	    } 
	
	  	 
	  	  
	  	public ModelAndView showWaitingListPostMartemCertificate(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListPostMartemCertificate();
	        
	        String jsp = "postcertificate_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
  	  
	  	  
	  	 public ModelAndView showPostMartemCertificate(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        }   
		        
		        map=mlcHandlerService.getPostMartemCertificate(id);   
		        String jsp = "postcertificate_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	  	 
	  	public ModelAndView submitPostMartemCertificate(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		int medicoLegalDetailsId=0;
		String mlcType=""; 
		map = mlcHandlerService.addPostMartemCertificate(box);
		boolean successfullyAdded = false;
		
		medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		
		if (map.get("mlcType") != null) {
			mlcType = (String) map.get("mlcType");
		}
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.Do you want to Report?";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		map.put("mlcType", mlcType);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		return new ModelAndView("index", "map", map);

    } 
	
	  	public ModelAndView showWaitingListEstimationofAge(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map=mlcHandlerService.getWaitingListEstimationofAge();
	     
	        String jsp = "estimationofAge_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	  	 public ModelAndView showEstimationofAge(HttpServletRequest request,HttpServletResponse response)
		    {

		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
		        String orderNo="";
			 	List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
					    List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
		        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
		        map=mlcHandlerService.getEstimationofAge(box);   
		        
		        orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
		        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		        }  
		         
		        if(map.get("patientWiseMlcs")!=null){
		 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
		 	        }
		 		if(map.get("mlcList")!=null){
		 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
		 	        }
		        String jsp = "estimationofAge_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        map.put("mlcList", mlcList);
				map.put("orderNo", orderNo);
		        map.put("patientWiseMlcs", patientWiseMlcs);
				map.put("patientAddress", patientAddress);
				
		        return new ModelAndView("index", "map", map);
		    } 
	  	
	  	public ModelAndView submitEstimationofAge(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		String mlcType=""; 
	 	int medicoLegalDetailsId=0;
	 	int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
		map = mlcHandlerService.addEstimationofAge(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		
	
	 	mlcType = (String) map.get("mlcType");
	 	medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("mlcType", mlcType);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    } 
	  	 
	  	 
	  	 
	 
	 	public ModelAndView showWaitingListChemicalAnalysis(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	      
	        map=mlcHandlerService.getWaitingListChemicalAnalysis();
	        
	        String jsp = "chemicalAnalysis_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	  	 
	  	 
	  	 public ModelAndView showChemicalAnalysis(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
		        String orderNo="";
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        }   
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
			 	
		        
		        map=mlcHandlerService.getChemicalAnalysis(box);
		        orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
		        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		        }  
		        
		        
		        map.put("orderNo", orderNo);
		        map.put("patientAddress", patientAddress);
		        String jsp = "chemicalAnalysis_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	  	 
	  	
	 	public ModelAndView submitChemicalAnalysis(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		String mlcType=""; 
	 	int medicoLegalDetailsId=0;
	    int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
	 	
	 	
		map = mlcHandlerService.addChemicalAnalysis(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		mlcType = (String) map.get("mlcType");
	 	medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("mlcType", mlcType);		
		return new ModelAndView("index", "map", map);

    }
  	 
	  	public ModelAndView showWaitingListVictimAllegedDrugged(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListVictimAllegedDrugged();
	        
	        String jsp = "victimAllegedDrugged_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	  	 public ModelAndView showVictimAllegedDrugged(HttpServletRequest request,HttpServletResponse response)
		    {
	  		HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        int id=0;
	        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
	        List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
	        
	        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
	        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
			String orderNo="";
	        
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        }  
	        int hospitalId=0;
	        if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				box.put("hospitalId", hospitalId);
			
			}
	        
	        
		    map=mlcHandlerService.getVictimAllegedDrugged(box);       
		    
		    orderNo = (String) map.get("orderNo");
	        if(map.get("patientAddress")!=null){
	        patientAddress = (List<PatientAddress>) map.get("patientAddress");
	        }  
	        if(map.get("patientHistories")!=null){
	        	patientHistories = (List<OpdPatientHistory>) map.get("patientHistories");
		        }  
	        if(map.get("patientWiseMlcs")!=null){
	 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
	 	        }
	 		if(map.get("mlcList")!=null){
	 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
	 	        }
		        String jsp = "victimAllegedDrugged_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        map.put("patientHistories", patientHistories);
		        map.put("patientWiseMlcs", patientWiseMlcs);
		        map.put("mlcList", mlcList);
		        map.put("patientAddress", patientAddress);
		        map.put("orderNo", orderNo);
		        return new ModelAndView("index", "map", map);
		    }
	  	 

		 	public ModelAndView submitVictimAllegedDrugged(HttpServletRequest request,HttpServletResponse response)
		    {
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);
			  int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
			map = mlcHandlerService.addVictimAllegedDrugged(box);
			boolean successfullyAdded = false;
			String mlcType=""; 
			String message = "";
			int medicoLegalDetailsId=0;
			medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (map.get("mlcType") != null) {
				mlcType = (String) map.get("mlcType");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.Do you want to Report?";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("mlcType", mlcType);
			map.put("medicoLegalDetailsId", medicoLegalDetailsId);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);

	    }
	 	public ModelAndView showWaitingListMedicalOfficerCertificate(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListMedicalOfficerCertificate();
	        
	        String jsp = "medicalOfficerCertificate_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	  	 public ModelAndView showMedicalOfficerCertificate(HttpServletRequest request,HttpServletResponse response)
		    {
	    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
		        List<OpdPatientHistory> patientHistories = new ArrayList<OpdPatientHistory>();
		        
		        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
		        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
				String orderNo="";
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
		        map=mlcHandlerService.geMedicalOfficerCertificatet(box);         
		        orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
		        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		        }  
		        if(map.get("patientHistories")!=null){
		        	patientHistories = (List<OpdPatientHistory>) map.get("patientHistories");
			        }  
		        if(map.get("patientWiseMlcs")!=null){
		 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
		 	        }
		 		if(map.get("mlcList")!=null){
		 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
		 	        }
		        
		        
		        String jsp = "medicalOfficerCertificate_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        map.put("orderNo", orderNo);
		        map.put("patientAddress", patientAddress);
		        map.put("patientHistories", patientHistories);
		        map.put("mlcList", mlcList);
		        map.put("patientWiseMlcs", patientWiseMlcs);
		        return new ModelAndView("index", "map", map);
		    }
	  	 
	  	public ModelAndView submitMedicalOfficerCertificate(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		int hospitalId=0;
		String mlcType=""; 
		int medicoLegalDetailsId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
		map = mlcHandlerService.addMedicalOfficerCertificate(box);
		mlcType = (String) map.get("mlcType");
		medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("mlcType", mlcType);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    }
  	
	 	public ModelAndView showWaitingListExaminationbySMOTTmember(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListExaminationbySMOTTmember();
	        
	        String jsp = "examinationBySMOTTmember_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	  	 public ModelAndView showExaminationbySMOTTmember(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
		        List<PatientAddress> patientAddress= new ArrayList<PatientAddress>();
		        List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
				
				String orderNo=""; 
		        
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        }  
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
		        
		        
		        map=mlcHandlerService.getExaminationbySMOTTmember(box);       
			    
			    orderNo = (String) map.get("orderNo");
		        if(map.get("patientAddress")!=null){
		        patientAddress = (List<PatientAddress>) map.get("patientAddress");
		        }  
		        if(map.get("patientWiseMlcs")!=null){
		 			patientWiseMlcs = (List<PatientWiseMlc>) map.get("patientWiseMlcs");
		 	        }
		 		if(map.get("mlcList")!=null){
		 			mlcList = (List<OpdPatientDetails>) map.get("mlcList");
		 	        }
		        
		         
		        
		        String jsp = "examinationBySMOTTmember_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        map.put("mlcList", mlcList);
		        map.put("patientWiseMlcs", patientWiseMlcs);
		        map.put("patientAddress", patientAddress);
		        map.put("orderNo", orderNo);
		        return new ModelAndView("index", "map", map);
		    }
	  	 
	   	public ModelAndView submitExaminationbySMOTTmember(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		int medicoLegalDetailsId=0;
		String mlcType=""; 
		int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
        
		map = mlcHandlerService.addExaminationbySMOTTmember(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
	
		if (map.get("mlcType") != null) {
			mlcType = (String) map.get("mlcType");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		map.put("mlcType", mlcType);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		return new ModelAndView("index", "map", map);

    }
	  	public ModelAndView showWaitingListDNAprofilingexaminationFSL(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        
	        map=mlcHandlerService.getWaitingListDNAprofilingexaminationFSL();
	        
	        String jsp = "dNAprofilingexaminationFSL_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	  	 
	 	 public ModelAndView showDNAprofilingexaminationFSL(HttpServletRequest request,HttpServletResponse response)
		    {
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
		        int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				}
			 	
		        map=mlcHandlerService.getDNAprofilingexaminationFSL(box);   
		             
		        String jsp = "dNAprofilingexaminationFSL_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	 	 
	 	public ModelAndView submitDNAprofilingexaminationFSL(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
	    int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}
	 	
		box.put("userId", userId);
		String mlcType=""; 
	 	int medicoLegalDetailsId=0;
		map = mlcHandlerService.addDNAprofilingexaminationFSL(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		
		if (map.get("mlcType") != null) {
			mlcType = (String) map.get("mlcType");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("mlcType", mlcType);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    }
	 	 
	 	 
	 	public ModelAndView showWaitingListPreserveDuringPostmortem(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	     
	            
	        map=mlcHandlerService.getWaitingListPreserveDuringPostmortem();
	        
	        String jsp = "preserveDuringPostmortem_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }

	 	 public ModelAndView showPreserveDuringPostmortem(HttpServletRequest request,HttpServletResponse response)
		    {
	 	
		    	HttpSession session = request.getSession();
		        Map<String, Object> map = new HashMap<String, Object>();
		        Box box = HMSUtil.getBox(request);
		        int id=0;
		        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
		        	id=Integer.parseInt(request.getParameter("requestId").toString());
		          
		        } 
		      map=mlcHandlerService.getPreserveDuringPostmortem(box);   
		        
		        
		        String jsp = "preserveDuringPostmortem_mlcJsp";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	 	public ModelAndView submitPreserveDuringPostmortem(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);

		map = mlcHandlerService.addPreserveDuringPostmortem(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.Do you want to Report?";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    } 
	 	 
 	public ModelAndView showWaitingListFormatForReferring(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map=mlcHandlerService.getWaitingListFormatForReferring();
            String jsp = "formatForReferring_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	 	 
	 	public ModelAndView showFormatForReferring(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        int id=0;
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        } 
	        map=mlcHandlerService.getFormatForReferring(box);   
	        
	        
	        String jsp = "formatForReferring_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
		
	 	public ModelAndView showWaitingListPostExaminToPoliceSurgun(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map=mlcHandlerService.getWaitingListPostExaminToPoliceSurgun();
            String jsp = "policeSurgun_waiting_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	 	
 	 
		public ModelAndView showPostExaminToPoliceSurgun(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        int id=0;
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        }         
	        map=mlcHandlerService.getPostExaminToPoliceSurgun(box);

	        String jsp = "postExaminToPoliceSurgun_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
 	 
	// -------------- MLC Waiting List ------------------------------
		

		public ModelAndView showPatientMlcWaitingList(HttpServletRequest request,HttpServletResponse response)
	    {
	    	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        int hospitalId = 0;
	        int empId = 0;
	        if (session.getAttribute("hospitalId") != null) 
	        	hospitalId = (Integer) session.getAttribute("hospitalId");
	        
	        if (session.getAttribute("empId") != null) {
	        	empId = (Integer) session.getAttribute("empId");
	        }
					
	        map=mlcHandlerService.getAllMlcWaitingList(hospitalId, empId);
	        
	        String jsp = "patient_mlcWaiting_ListJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
	
		
		public ModelAndView addReffringPostmortamExam(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);

		map = mlcHandlerService.addReffringPostmortamExam(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.Do you want to Report?";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    } 
		
		
		public ModelAndView showProformforRecording(HttpServletRequest request,HttpServletResponse response){
			 	HttpSession session = request.getSession();
	        Map<String, Object> map = new HashMap<String, Object>();
	        Box box = HMSUtil.getBox(request);
	        int id=0;
	        
	        
	        if(request.getParameter("requestId")!=null && !request.getParameter("requestId").equals("")){
	        	id=Integer.parseInt(request.getParameter("requestId").toString());
	          
	        } 
	      map=mlcHandlerService.getProformforRecording(box);   
	       
	        String jsp = "proformforRecording_mlcJsp";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map); 
			
		}
		
		
		public ModelAndView addProformforRecording(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);

		map = mlcHandlerService.addProformforRecording(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.Do you want to Report?";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    } 
		
		public ModelAndView submmitNOObjectionCerificate(HttpServletRequest request,HttpServletResponse response)
	    {
	  	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		box.put("userId", userId);
		int medicoLegalDetailsId=0;
		String mlcType="";
		map = mlcHandlerService.submmitNOObjectionCerificate(box);
		boolean successfullyAdded = false;
		String message = "";
		if (map.get("successfullyAdded") != null) {
			successfullyAdded = (Boolean) map.get("successfullyAdded");
		}
		if (map.get("message") != null) {
			message = (String) map.get("message");
		}
		medicoLegalDetailsId= (Integer) map.get("medicoLegalDetailsId");
		
		if (map.get("mlcType") != null) {
			mlcType = (String) map.get("mlcType");
		}
		if (message.equals("")) {
			if (successfullyAdded) {
				message = "Record Added Successfully.Do you want to Report?";
			} else {
				message = "Try Again !!";
			}
		}
		String jsp = "mlc_msg_MLC";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("message", message);
		map.put("mlcType", mlcType);
		map.put("medicoLegalDetailsId", medicoLegalDetailsId);
		map.put("hin_no", request.getParameter("uhinId"));
		return new ModelAndView("index", "map", map);

    } 
		public ModelAndView addAuthenticityCertificate(HttpServletRequest request,HttpServletResponse response){
		  	Map<String, Object> map = new HashMap<String, Object>();
			Box box = HMSUtil.getBox(request);
			HttpSession session = request.getSession();
			session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			box.put("userId", userId);

			map = mlcHandlerService.addAuthenticityCertificate(box);
			boolean successfullyAdded = false;
			String message = "";
			if (map.get("successfullyAdded") != null) {
				successfullyAdded = (Boolean) map.get("successfullyAdded");
			}
			if (map.get("message") != null) {
				message = (String) map.get("message");
			}
			if (message.equals("")) {
				if (successfullyAdded) {
					message = "Record Added Successfully.Do you want to Report?";
				} else {
					message = "Try Again !!";
				}
			}
			String jsp = "mlc_msg_MLC";
			jsp += ".jsp";
			map.put("contentJsp", jsp);
			map.put("message", message);
			map.put("hin_no", request.getParameter("uhinId"));
			return new ModelAndView("index", "map", map);

	    }

	  	 public ModelAndView showMlcReportJsp(HttpServletRequest request,HttpServletResponse response)
		    {
		        Map<String, Object> map = new HashMap<String, Object>();
		        String jsp = "mlcReport";
		        jsp += ".jsp";
		        map.put("contentJsp", jsp);
		        return new ModelAndView("index", "map", map);
		    }
	  	 
		
	    public ModelAndView getUhidReport(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	Box box = HMSUtil.getBox(request);
			 	HttpSession session = request.getSession();
				session = request.getSession();
				
				int hospitalId=0;
		        if (session.getAttribute("hospitalId") != null) {
					hospitalId = (Integer) session.getAttribute("hospitalId");
					box.put("hospitalId", hospitalId);
				
				} 		    
			 	map = mlcHandlerService.getUhidReport(box);
			 	jsp = "responseForMlcType";
				
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);

			}
	    
	    public ModelAndView   getMlcTypeReport(HttpServletRequest request, HttpServletResponse response) {
			 	Map<String, Object> map = new HashMap<String, Object>();
			 	Box box = HMSUtil.getBox(request);
			    		    
			 	map = mlcHandlerService.getMlcTypeReport(box);
			 	jsp = "responseForMlcNumber";
				
				title = "";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView(jsp, "map", map);

			}
	
	    
	    
	    public ModelAndView showPostmortemCertificateReportJsp(HttpServletRequest request,HttpServletResponse response)
	    {
	        Map<String, Object> map = new HashMap<String, Object>();
	        String jsp = "postmortemCertificateReport";
	        jsp += ".jsp";
	        map.put("contentJsp", jsp);
	        return new ModelAndView("index", "map", map);
	    }
  	 
	
    public ModelAndView getPMNoReport(HttpServletRequest request, HttpServletResponse response) {
		 	Map<String, Object> map = new HashMap<String, Object>();
		 	Box box = HMSUtil.getBox(request);
		    		    
		 	map = mlcHandlerService.getPMNoReport(box);
		 	jsp = "responseForPMNo";
			
			title = "";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView(jsp, "map", map);

		}
		
    //Added by Kaushal Mishra
    
    public ModelAndView showMortuaryRegisteredDetails(HttpServletRequest request, HttpServletResponse response) {
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	Box box = HMSUtil.getBox(request);
	    		    
	 	map = mlcHandlerService.showMortuaryRegistedDetails(box);
	 	jsp = "mortuaryMlcWaitingList.jsp";
		
		title = "Mortuary Registered Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
    
    public ModelAndView showPostmortemRegisteredDetails(HttpServletRequest request, HttpServletResponse response) {
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	Box box = HMSUtil.getBox(request);
	    		    
	 	map = mlcHandlerService.showPostmortemRegisteredDetails(box);
	 	jsp = "postmortemMlcWaitingList.jsp";
		
		title = "Postmortem Registered Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);

	}
    
    public ModelAndView generateReportForMortuary(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int patientMlcId =0;
		int mortuaryRegdDetailId = 0;
		String hinNo = "";
		String patientName = "";
		String age = "";
		String sex = "";
		String address="";
		String deadBodyRecBy= "";
		
		try {
			    if (session.getAttribute("hospitalId") != null) 
			{
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			    if(request.getParameter("patientMlcId")!=null && !request.getParameter("patientMlcId").equals(""))
            {
			    patientMlcId=Integer.parseInt(request.getParameter("patientMlcId").toString());
                box.put("patientMlcId", patientMlcId);
                System.out.println("patientMlcId"+patientMlcId);
            }
			    
			    System.out.println("mmm=========="+Integer.parseInt(request.getParameter("mortuaryRegdDetailId")));
			    if(request.getParameter("mortuaryRegdDetailId")!=null && !request.getParameter("mortuaryRegdDetailId").equals(""))
	            {
			    	mortuaryRegdDetailId=Integer.parseInt(request.getParameter("mortuaryRegdDetailId"));
	                box.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
	                System.out.println("mortuaryRegdDetailId"+mortuaryRegdDetailId);
	            }
			
			    List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
			    mortuaryDetails= mlcHandlerService.getMortuaryRegisterDetailsForReport(box);
			    System.out.println("mortuaryDetails==="+mortuaryDetails.size());
			    System.out.println("mortuaryRegdDetailId==="+mortuaryDetails.get(0).getId());
			    System.out.println("hinNo==="+mortuaryDetails.get(0).getHin().getHinNo());
			    System.out.println("age==="+mortuaryDetails.get(0).getHin().getAge() != null?mortuaryDetails.get(0).getHin().getAge():"");
			    System.out.println("sex==="+mortuaryDetails.get(0).getHin().getSex().getAdministrativeSexName());
			    System.out.println("deadBodyRecBy==="+mortuaryDetails.get(0).getDeadBodyReceivedBy() != null && mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName() != null ?mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName():"");
			    
			    	 mortuaryRegdDetailId=mortuaryDetails.get(0).getId();
				     hinNo=mortuaryDetails.get(0).getHin().getHinNo();
				     patientName=mortuaryDetails.get(0).getHin().getFullName();
				     age=mortuaryDetails.get(0).getHin().getAge() != null?mortuaryDetails.get(0).getHin().getAge():"";
				     sex=mortuaryDetails.get(0).getHin().getSex().getAdministrativeSexName();
				     deadBodyRecBy=mortuaryDetails.get(0).getDeadBodyReceivedBy() != null && mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName() != null ?mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName():"";
				     
			   
			   
			    
			    requestParameters.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
			    requestParameters.put("hinNo", hinNo);
			    requestParameters.put("patientName", patientName);
			    requestParameters.put("age", age);
			    requestParameters.put("sex", sex);
			    requestParameters.put("address", address);
			    requestParameters.put("deadBodyRecBy", deadBodyRecBy);
			    
			    System.out.println(mortuaryRegdDetailId);
			    System.out.println(hinNo);
			    System.out.println(patientName);
			    
		    }   catch (Exception e) {
			    e.printStackTrace();
		    }
		
		

		requestParameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = mlcHandlerService.getConnection();
		HMSUtil.generateReport("Mortuary_Register_Report", requestParameters,(Connection) connectionMap.get("conn"), response, getServletContext());
		return null;
	}
    
    
    public ModelAndView generateReportForPostmortem(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int mortuaryRegdDetailId =0;
		
		try {
			    if (session.getAttribute("hospitalId") != null) 
			{
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			    if(request.getParameter("mortuaryRegdDetailId")!=null && !request.getParameter("mortuaryRegdDetailId").equals(""))
            {
			    	mortuaryRegdDetailId=Integer.parseInt(request.getParameter("mortuaryRegdDetailId").toString());
                box.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
                System.out.println("mortuaryRegdDetailId"+mortuaryRegdDetailId);
            }
			
			    List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
			    mortuaryDetails= mlcHandlerService.getMortuaryRegisterDetailsForReport(box);
			    
			    //mortuaryRegdDetailId=mortuaryDetails.get(0).getId();
			    String hinNo=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo();
			    String patientName=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName();
			    String age=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge();
			    String sex=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName();
			    String address="";
			    String deadBodyRecBy=mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName();
			    String assistedOne=mortuaryDetails.get(0).getAssistedBy1().getFirstName();
			    String assistedTwo=mortuaryDetails.get(0).getAssistedBy2().getFirstName();
			    String doctorName=mortuaryDetails.get(0).getDoctor().getFirstName();
			    String designation=mortuaryDetails.get(0).getDoctor().getRank().getRankName();
			    
			    requestParameters.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
			    requestParameters.put("hinNo", hinNo);
			    requestParameters.put("patientName", patientName);
			    requestParameters.put("age", age);
			    requestParameters.put("sex", sex);
			    requestParameters.put("assistedOne", assistedOne);
			    requestParameters.put("assistedTwo", assistedTwo);
			    requestParameters.put("doctorName", doctorName);
			    requestParameters.put("designation", designation);
			    
		    }   catch (Exception e) {
			    e.printStackTrace();
		    }
		
		

		requestParameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = mlcHandlerService.getConnection();
		HMSUtil.generateReport("Register of Postmortem Examinations", requestParameters,(Connection) connectionMap.get("conn"), response, getServletContext());
		return null;
	}
    
    
    public ModelAndView generateReportPostmortemDetailesNote(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		int mortuaryRegdDetailId =0;
		
		try {
			    if (session.getAttribute("hospitalId") != null) 
			{
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
			    if(request.getParameter("mortuaryRegdDetailId")!=null && !request.getParameter("mortuaryRegdDetailId").equals(""))
            {
			    	mortuaryRegdDetailId=Integer.parseInt(request.getParameter("mortuaryRegdDetailId").toString());
                box.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
                System.out.println("mortuaryRegdDetailId"+mortuaryRegdDetailId);
            }
			
			    List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
			    mortuaryDetails= mlcHandlerService.getMortuaryRegisterDetailsForReport(box);
			    
			    //mortuaryRegdDetailId=mortuaryDetails.get(0).getId();
			    String hinNo=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo();
			    String patientName=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName();
			    String age=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge();
			    String sex=mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName();
			    String address="";
			   // String deadBodyRecBy=mortuaryDetails.get(0).getDeadBodyReceivedBy().getFirstName();
			    String assistedOne=mortuaryDetails.get(0).getAssistedBy1().getFirstName();
			    String assistedTwo=mortuaryDetails.get(0).getAssistedBy2().getFirstName();
			    String doctorName=mortuaryDetails.get(0).getDoctor().getFirstName();
			    String designation=mortuaryDetails.get(0).getDoctor().getRank().getRankName();
			    
			    requestParameters.put("mortuaryRegdDetailId", mortuaryRegdDetailId);
			    requestParameters.put("hinNo", hinNo);
			    requestParameters.put("patientName", patientName);
			    requestParameters.put("age", age);
			    requestParameters.put("sex", sex);
			    requestParameters.put("assistedOne", assistedOne);
			    requestParameters.put("assistedTwo", assistedTwo);
			    requestParameters.put("doctorName", doctorName);
			    requestParameters.put("designation", designation);
			    
		    }   catch (Exception e) {
			    e.printStackTrace();
		    }
		
		

		requestParameters.put("SUBREPORT_DIR",getServletContext().getRealPath("/Reports/"));
		Map<String, Object> connectionMap = mlcHandlerService.getConnection();
		HMSUtil.generateReport("POST-MORTEM DETAILED NOTES", requestParameters,(Connection) connectionMap.get("conn"), response, getServletContext());
		return null;
	}
    
    public ModelAndView getMlcReportByDifferentParameter(HttpServletRequest request, HttpServletResponse response) {
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	Box box = HMSUtil.getBox(request);
	 	HttpSession session = request.getSession();
		session = request.getSession();
		
		int hospitalId=0;
        if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
			box.put("hospitalId", hospitalId);
		
		}	    
	 	map = mlcHandlerService.getUhidReport(box);
	 	jsp = "mlcReport.jsp";
		
		title = "MLC REPORT";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);


	}
}
