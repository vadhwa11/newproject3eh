package jkt.hrms.etravel.controller;

import static jkt.hrms.util.HrmsRequestConstants.*;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;


import org.hibernate.Session;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import jkt.hms.masters.business.MasCurrency;
import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hrms.etravel.handler.EtravelHandlerService;
import jkt.hrms.masters.business.EtrApptbl;
import jkt.hrms.masters.business.EtrBookeddtlsAttach;
import jkt.hrms.masters.business.EtrExpsubmit;
import jkt.hrms.masters.business.EtrFillbookeddtls;
import jkt.hrms.masters.business.EtrTravelreq;
import jkt.hrms.masters.business.EtrTrvdetails;
import jkt.hrms.masters.business.EtrTrvreqcmts;
import jkt.hrms.masters.business.MstrCode;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.util.SendMail;

public class EtravelController  extends MultiActionController{
	EtravelHandlerService etravelHandlerService = null;

	public EtravelHandlerService getEtravelHandlerService() {
		return etravelHandlerService;
	}

	public void setEtravelHandlerService(EtravelHandlerService etravelHandlerService) {
		this.etravelHandlerService = etravelHandlerService;
	}
	public ModelAndView showTravelRequestJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int employeeId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		 generalMap.put("employeeId", employeeId);
		}
		map = etravelHandlerService.showTravelRequestJsp(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	 // map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView addNewTravelRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int empId = users.getEmployee().getId();
		map = etravelHandlerService.addNewTravelRequest(empId);
		String jsp = NEW_TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView getProjectSiteDetailFromAjax(HttpServletRequest request ,HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
		}
		int projectId = 0;
		if (!(request.getParameter("project").equals("0")) && (request.getParameter("project") != null)) {
			 projectId = Integer.parseInt(request.getParameter("project"));
		}
		map = etravelHandlerService.getProjectSiteDetailFromAjax(projectId,employeeId);
		
		return new ModelAndView("hr_responseForNewTravelRequest", "map", map);
	}
	public ModelAndView searchTravelRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		int employeeId;
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		
		if(session.getAttribute("users")!= null){
			 users=(Users)session.getAttribute("users");
			 employeeId = users.getEmployee().getId();
			 generalMap.put("employeeId", employeeId);
			}
		
		int searchRefNoId = 0;
		if(request.getParameter("searchRefNoId")!= null ){
			searchRefNoId =Integer.parseInt(request.getParameter("searchRefNoId"));
			generalMap.put("searchRefNoId", searchRefNoId);
		}
		String searchStatusId = "";
		if(request.getParameter("searchStatusId")!= null ){
			searchStatusId =request.getParameter("searchStatusId");
			generalMap.put("searchStatusId", searchStatusId);
		}
		if (request.getParameter(FROM_DATE)!= null  && !(request.getParameter(FROM_DATE).equals("")) ) {
			Date fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
			
		}
		
		if (request.getParameter(TO_DATE)!= null  && !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}	
		map = etravelHandlerService.searchTravelRequest(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitNewTravelRequest(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		Map<String, Object> generalMap = new HashMap<String, Object>();
		EtrTravelreq etrTravelreq = new EtrTravelreq();
		EtrTrvdetails etrTrvdetails = new EtrTrvdetails();
		EtrApptbl etrApptbl = new EtrApptbl();
		EtrTrvreqcmts etrTrvreqcmts = new EtrTrvreqcmts();
		
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketBookingDateList =new ArrayList();
		List beforeTimeList =new ArrayList();
		List beforeTimeList1 =new ArrayList();
		List ticketBookingRemarkList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
		}
		generalMap.put("employeeId", employeeId);
		MasEmployee masEmployee = new MasEmployee();
		masEmployee.setId(employeeId);
		etrTravelreq.setEmp(masEmployee);
		etrTravelreq.setCreatedBy(masEmployee);
		etrTravelreq.setModifiedBy(masEmployee);
		
		if(! request.getParameter(HEAD_HIDDEN_ID).equals("0")){
			int headId = Integer.parseInt(request.getParameter(HEAD_HIDDEN_ID));
			generalMap.put("headId", headId);
		}
		if(request.getParameter(FROM_DATE)!= null ){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			etrTravelreq.setJfdate(fromDate);
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter(TO_DATE)!= null ) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			etrTravelreq.setJtdate(toDate);
			generalMap.put("toDate", toDate);
		}
		int projectBasedOrNonPrijectBasedTrip=0;
		if(request.getParameter(PROJECT_BASED_TRIP) != null && !(request.getParameter(PROJECT_BASED_TRIP).equals(""))){
			projectBasedOrNonPrijectBasedTrip =Integer.parseInt(request.getParameter(PROJECT_BASED_TRIP)) ;
			etrTravelreq.setProjectTrip(projectBasedOrNonPrijectBasedTrip);
		}
		int projectId = 0;
		if( ! request.getParameter(PROJECT_HIDDEN_ID).equals("0")){
			 projectId = Integer.parseInt(request.getParameter(PROJECT_HIDDEN_ID));
			MstrProject mstrProject = new MstrProject();
			mstrProject.setId(projectId);
			etrTravelreq.setPrj(mstrProject);
		 }
		generalMap.put("projectId", projectId);
		if(request.getParameter(TRIP_HIDDEN_ID)!= null){
			int tripId = Integer.parseInt(request.getParameter(TRIP_HIDDEN_ID));
			MstrCode mstrCode = new MstrCode();
			mstrCode.setId(tripId);
			etrTravelreq.setTrip(mstrCode);
		}
		if(! request.getParameter(SITE_HIDDEN_ID).equals("0") && request.getParameter(SITE_HIDDEN_ID)!= null){
			int siteId =Integer.parseInt(request.getParameter(SITE_HIDDEN_ID));
			MstrSiteHeader mstrSiteHeader = new MstrSiteHeader();
			mstrSiteHeader.setId(siteId);
			etrTravelreq.setSite(mstrSiteHeader);
		}
		String ticketBooking = "";
		if(request.getParameter(TICKET_BOOKING)!= null){
			
			etrTravelreq.setNAFTicket("y");
		}else{
			
			etrTravelreq.setNAFTicket("n");
		}
		if(request.getParameter(NEED_ADVANCE)!= null){	
			etrTravelreq.setAvdReq("y");
		}else{
			etrTravelreq.setAvdReq("n");
		}
		if(request.getParameter(HOTEL_BOOKING)!= null){
			etrTravelreq.setNAFHotel("y");
		}else{
			etrTravelreq.setNAFHotel("n");
		}
		
		if(request.getParameter(CAB_BOOKING)!= null){
			etrTravelreq.setNAFLocalCab("y");
		}else{
			etrTravelreq.setNAFLocalCab("n");
		}
		if(request.getParameter(HOTEL_BOOKING_DESC)!= null){
			etrTravelreq.setHotelDesc(request.getParameter(HOTEL_BOOKING_DESC));
		}
		
		if(request.getParameter(CAB_BOOKING_DESC)!= null){
			etrTravelreq.setLocalCabDesc(request.getParameter(CAB_BOOKING_DESC));
		}
		
		Date currentDate = new Date();
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			 currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
		}
		etrTravelreq.setCreatedAt(currentDate);
		etrTravelreq.setModifiedAt(currentDate);
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		//etrTravelreq.setLastChgBy(time);
		
		BigDecimal  advanceAmount = new BigDecimal("0");
		if (request.getParameter(TRAVEL_ADVANCE_AMOUNT)!= null && ! request.getParameter(TRAVEL_ADVANCE_AMOUNT).equals("") ) {
				  advanceAmount = new BigDecimal(request.getParameter(TRAVEL_ADVANCE_AMOUNT));
				etrTravelreq.setAdvAmt(advanceAmount);
			}
		if (request.getParameter(EXPECTED_ON_DATE)!= null && !(request.getParameter(EXPECTED_ON_DATE).equals(""))) {
			Date expectedOnDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(EXPECTED_ON_DATE));
			etrTravelreq.setAdvExpDate(expectedOnDate);
		}
		if (! request.getParameter(CURRENCY_ID).equals("0")) {
			int currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
			MasCurrency masCurrency = new MasCurrency();
			masCurrency.setId(currencyId);
			etrTravelreq.setAdvcurid(masCurrency);
		}
		if (request.getParameter(DESCRIPTION)!= null) {
			String description = request.getParameter(DESCRIPTION);
			etrTravelreq.setAdvDesc(description);
		}
		if (request.getParameter(COMMENTS)!= null) {
			String comments = request.getParameter(COMMENTS);
			etrTravelreq.setComment(comments);
		}
		
		int noOfTravelBooking = 0;
		if (request.getParameter("hiddenValueTicketBooking")!= null) {
			noOfTravelBooking = Integer.parseInt(request.getParameter("hiddenValueTicketBooking"));
		}
		for(int j=1;j<=noOfTravelBooking;j++)
		{
		
			if(request.getParameter(COUNTRY_HIDDEN_ID+j) != null  && !request.getParameter(COUNTRY_HIDDEN_ID+j).equals("")){
				fromCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_HIDDEN_ID+j)));
			}else{
				fromCountryList.add("");
			}
			if(request.getParameter(COUNTRY_HIDDEN_ID1+j) != null &&  !request.getParameter(COUNTRY_HIDDEN_ID1+j).equals("")){
				toCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_HIDDEN_ID1+j)));
			}else{
				toCountryList.add("");
			}
			
			if(request.getParameter(CITY_HIDDEN_ID+j) != null  &&  ! request.getParameter(CITY_HIDDEN_ID+j).equals("")){
				fromPlaceList.add(Integer.parseInt(request.getParameter(CITY_HIDDEN_ID+j)));
			}else{
				fromPlaceList.add("");
			}
			
			if(request.getParameter(CITY_HIDDEN_ID1+j) != null  &&  !request.getParameter(CITY_HIDDEN_ID1+j).equals("")){
				toPlaceList.add(Integer.parseInt(request.getParameter(CITY_HIDDEN_ID1+j)));
			}else{
				toPlaceList.add("");
			}
			
			if(request.getParameter(TRAVEL_MODE_HIDDEN_ID+j)!= null && ! request.getParameter(TRAVEL_MODE_HIDDEN_ID+j).equals("")){
				travelModeList.add(Integer.parseInt(request.getParameter(TRAVEL_MODE_HIDDEN_ID+j)));
			}else{
				travelModeList.add("");
			}
			if(request.getParameter(TICKET_BOOKING_DATE+j)!= null){
				ticketBookingDateList.add(request.getParameter(TICKET_BOOKING_DATE+j));
			}
			
			if(request.getParameter(BEFORE_TIME+j)!= null){
				beforeTimeList.add(request.getParameter(BEFORE_TIME+j));
			}
			
			if(request.getParameter(TIME_SLOAT+j)!= null){
				beforeTimeList1.add(request.getParameter(TIME_SLOAT+j));
			}
			if(request.getParameter(REMARKS+j)!= null){
				ticketBookingRemarkList.add(request.getParameter(REMARKS+j));
			}
			
		}
		
		
		int selectLineManagerAndOther=0;
		if(request.getParameter(LINE_MANAGER_AND_OTHER) != null && !(request.getParameter(LINE_MANAGER_AND_OTHER).equals(""))){
			selectLineManagerAndOther =Integer.parseInt(request.getParameter(LINE_MANAGER_AND_OTHER)) ;
		}
		
		generalMap.put("selectLineManagerAndOther", selectLineManagerAndOther);
		generalMap.put("fromPlaceList", fromPlaceList);
		generalMap.put("toPlaceList", toPlaceList);
		generalMap.put("travelModeList", travelModeList);
		generalMap.put("ticketBookingDateList", ticketBookingDateList);
		generalMap.put("ticketBookingRemarkList", ticketBookingRemarkList);
		generalMap.put("toCountryList", toCountryList);
		generalMap.put("beforeTimeList", beforeTimeList);
		generalMap.put("beforeTimeList1", beforeTimeList1);
		generalMap.put("fromCountryList", fromCountryList);
		generalMap.put("etrTravelreq", etrTravelreq);
		
		map = etravelHandlerService.submitNewTravelRequest(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView viewTravelRequest(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int employeeId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		}
		int travelRequestId= 0;
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.viewTravelRequest(travelRequestId,employeeId);
		String jsp = HR_VIEW_TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		//map.put("users", users);
		return new ModelAndView("index", "map", map);
	
	}
	
	
	public ModelAndView editTravelRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int employeeId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		}
		int travelRequestId= 0;
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.editTravelRequest(travelRequestId,employeeId);
		String jsp = HR_EDIT_TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users); 
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView updateTravelRequest(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		
		List travelModeList =new ArrayList();
		List ticketBookingDateList =new ArrayList();
		List ticketBookingRemarkList =new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List beforeTimeList = new ArrayList();
		List etrTrvDetailIdList =new ArrayList();
		int travelRequestId= 0;
		if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		generalMap.put("travelRequestId", travelRequestId);
		String status = "";
		if(request.getParameter(TRV_STATUS)!= null){
			status = request.getParameter(TRV_STATUS);
			generalMap.put("status", status);
		}
		
		
		
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			generalMap.put("employeeId", employeeId);
		}
		
		/*if(! request.getParameter(HEAD_HIDDEN_ID).equals("0")){
			int headId = Integer.parseInt(request.getParameter(HEAD_HIDDEN_ID));
			generalMap.put("headId", headId);
		}*/
		
		
		if(request.getParameter("fromEditDate")!= null){
			Date fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("fromEditDate"));
			generalMap.put("fromDate", fromDate);
		}
		if (request.getParameter("toEditDate")!= null) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("toEditDate"));
			generalMap.put("toDate", toDate);
		}
		int projectBasedOrNonPrijectBasedTrip=0;
		if(request.getParameter(PROJECT_BASED_TRIP) != null && !(request.getParameter(PROJECT_BASED_TRIP).equals(""))){
			projectBasedOrNonPrijectBasedTrip =Integer.parseInt(request.getParameter(PROJECT_BASED_TRIP)) ;
			generalMap.put("projectBasedOrNonPrijectBasedTrip", projectBasedOrNonPrijectBasedTrip);
		}
		
		if(! request.getParameter("projectHiddenId").equals("0")){
			int projectId = Integer.parseInt(request.getParameter("projectHiddenId"));
			generalMap.put("projectId", projectId);
		}
		
		if(request.getParameter("tripHiddenId")!= null){
			int tripId = Integer.parseInt(request.getParameter("tripHiddenId"));
			generalMap.put("tripId", tripId);
		}
		if(! request.getParameter("siteHiddenId").equals("0")){
			int siteId = Integer.parseInt(request.getParameter("siteHiddenId"));
			generalMap.put("siteId", siteId);
		}	
		Date currentDate = new Date();
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			 currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			 generalMap.put("currentDate", currentDate);
		}
		//etrTravelreq.setCreatedAt(currentDate);
		//etrTravelreq.setModifiedAt(currentDate);

			if(request.getParameter("needEditAdvance")!= null){
				String needAdvance = "y";
				 generalMap.put("needAdvance", needAdvance);
			}else{
				String needAdvance = "n";
				 generalMap.put("needAdvance", needAdvance);
			}
			
			if(request.getParameter("hotelEditBooking")!= null){
				String hotelBooking = "y";
				generalMap.put("hotelBooking", hotelBooking);
			}else{
				String hotelBooking = "n";
				generalMap.put("hotelBooking", hotelBooking);
			}
			
			if(request.getParameter("cabEditBooking")!= null){
				String cabBooking = "y";
				generalMap.put("cabBooking", cabBooking);
			}else{
				String cabBooking = "n";
				generalMap.put("cabBooking", cabBooking);
			}
			
			if(request.getParameter("ticketEditBooking")!= null){
				String ticketBooking = "y";
				generalMap.put("ticketBooking", ticketBooking);
			}else{
				String ticketBooking = "n";
				generalMap.put("ticketBooking", ticketBooking);
			}
			if(request.getParameter(HOTEL_BOOKING_DESC)!= null){
				String hotelDesc =  request.getParameter(HOTEL_BOOKING_DESC);
				generalMap.put("hotelDesc", hotelDesc);
			}
			
			if(request.getParameter(CAB_BOOKING_DESC)!= null){
				String cabDesc = request.getParameter(CAB_BOOKING_DESC);
				generalMap.put("cabDesc", cabDesc);
			}
			if (request.getParameter(TRAVEL_ADVANCE_AMOUNT)!= null && !request.getParameter(TRAVEL_ADVANCE_AMOUNT).equals("")) {
				BigDecimal  advanceAmount = new BigDecimal(request.getParameter(TRAVEL_ADVANCE_AMOUNT));
				generalMap.put("advanceAmount", advanceAmount);
			}
			if (request.getParameter(EXPECTED_ON_DATE)!= null  && !(request.getParameter(EXPECTED_ON_DATE).equals(""))) {
				Date expectedOnDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(EXPECTED_ON_DATE));
				generalMap.put("expectedOnDate", expectedOnDate);
			}
			if (! request.getParameter(CURRENCY_ID).equals("0") &&  request.getParameter(CURRENCY_ID)!= null) {
				int currencyId = Integer.parseInt(request.getParameter(CURRENCY_ID));
				generalMap.put("currencyId", currencyId);
			}
			if (request.getParameter(DESCRIPTION)!= null) {
				String description = request.getParameter(DESCRIPTION);
				generalMap.put("description", description);
				}
			if (request.getParameter(COMMENTS)!= null) {
				String comments = request.getParameter(COMMENTS);
				generalMap.put("comments", comments);
				}
		
		int noOfTravelBooking = 0;
		if (request.getParameter("count")!= null && ! request.getParameter("count").equals("")) {
			noOfTravelBooking = Integer.parseInt(request.getParameter("count"));
		}

		
			for(int j=1;j<=noOfTravelBooking;j++)
			{
				if(request.getParameter(ETR_TRV_DETAIL_ID+j)!= null){
					etrTrvDetailIdList.add(Integer.parseInt(request.getParameter(ETR_TRV_DETAIL_ID+j)));
				}
				if(! request.getParameter("fromCountryHiddenId"+j).equals("0")){
					fromCountryList.add(Integer.parseInt(request.getParameter("fromCountryHiddenId"+j)));
				}	
				if(! request.getParameter("toCountryHiddenId"+j).equals("0")){
					toCountryList.add(Integer.parseInt(request.getParameter("toCountryHiddenId"+j)));
				}
				
				if(! request.getParameter("fromCityHiddenId"+j).equals("0")){
					fromPlaceList.add(Integer.parseInt(request.getParameter("fromCityHiddenId"+j)));
				}
				if(! request.getParameter("toCityHiddenId"+j).equals("0")){
					toPlaceList.add(Integer.parseInt(request.getParameter("toCityHiddenId"+j)));
				}
				if(request.getParameter("travelModeHiddenId"+j)!= null){
					travelModeList.add(Integer.parseInt(request.getParameter("travelModeHiddenId"+j)));
				}
				if(request.getParameter("editBookingDate"+j)!= null){
					ticketBookingDateList.add(request.getParameter("editBookingDate"+j));
				}
				if(request.getParameter("editTicketTime"+j)!= null){
					beforeTimeList.add(request.getParameter("editTicketTime"+j));
				}
				if(request.getParameter("editRemak"+j)!= null){
					ticketBookingRemarkList.add(request.getParameter("editRemak"+j));
				}
				
			 }
		
		int selectLineManagerAndOther=0;
		if(request.getParameter(LINE_MANAGER_AND_OTHER) != null && !(request.getParameter(LINE_MANAGER_AND_OTHER).equals(""))){
			selectLineManagerAndOther =Integer.parseInt(request.getParameter(LINE_MANAGER_AND_OTHER)) ;
			generalMap.put("selectLineManagerAndOther", selectLineManagerAndOther);
		}
			
		generalMap.put("fromPlaceList", fromPlaceList);
		generalMap.put("toPlaceList", toPlaceList);
		generalMap.put("travelModeList", travelModeList);
		generalMap.put("ticketBookingDateList", ticketBookingDateList);
		generalMap.put("ticketBookingRemarkList", ticketBookingRemarkList);
		generalMap.put("toCountryList", toCountryList);
		generalMap.put("fromCountryList", fromCountryList);
		generalMap.put("beforeTimeList", beforeTimeList);
		generalMap.put("etrTrvDetailIdList", etrTrvDetailIdList);
		map = etravelHandlerService.updateTravelRequest(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView cancelNewTravelRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int travelRequestId= 0;
		if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		generalMap.put("travelRequestId", travelRequestId);
		if(request.getParameter(REMARKS_FOR_CANCELATION)!= null){
			String remarksForCancelation = request.getParameter(REMARKS_FOR_CANCELATION);
			generalMap.put("remarksForCancelation", remarksForCancelation);
		}
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			generalMap.put("employeeId", employeeId);
		}
		map = etravelHandlerService.cancelNewTravelRequest(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTravelApprovalRequest(HttpServletRequest  request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		map = etravelHandlerService.showTravelApprovalRequest(employeeId);
		String jsp = SHOW_TRAVEL_APPROVAL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("employeeId", employeeId);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView sendMailToApprover(HttpServletRequest request ,HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List travelRequestIdList =new ArrayList();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		int count = 0;
		if (request.getParameter("counter")!= null) {
			count = Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<count;j++)
		{
			if (request.getParameter(TRAVEL_REQUEST_ID+j)!= null && !(request.getParameter(TRAVEL_REQUEST_ID+j).equals(""))) {
				travelRequestIdList .add(Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID+j)));
			
			}
		 }
			String approvalStatus = "";
			if(request.getParameter(STATUS)!= null){
				approvalStatus = request.getParameter(STATUS);
			}
			String remark = "";
			if(request.getParameter(REMARK)!= null){
				 remark = request.getParameter(REMARK);
			}
			
			int lineManagerId = 0;
			if (! request.getParameter(LINE_MANAGER).equals("0")) {
				lineManagerId =Integer.parseInt(request.getParameter(LINE_MANAGER));
			 }
			String other = "";
			if(request.getParameter("other")!= null){
				other = "y";
			}else{
				other = "n";
			}
			int headeId = 0;
			
				if(!(request.getParameter(HEAD_ID).equals(""))) {
					headeId =Integer.parseInt(request.getParameter(HEAD_ID));
				 }
			
			generalMap.put("travelRequestIdList", travelRequestIdList);
			generalMap.put("approvalStatus", approvalStatus);
			generalMap.put("remark", remark);
			generalMap.put("lineManagerId", lineManagerId);
			generalMap.put("other", other);
			generalMap.put("headeId", headeId);
			
			map = etravelHandlerService.updateApprovalStatus(generalMap);
			/*String  mailSubject="";
			String mailText="";
			
			String addressTo[] = new String[travelRequestIdList.size()];
			for(int i = 0; i < travelRequestIdList.size() ; i++)
			{
				
				MasEmployee employee = tempMailList.get(i);
				addressTo[i] = employee.getEmail();
			}
			
			if(request.getParameter(MAIL_SUBJECT) !=null && !(request.getParameter(MAIL_SUBJECT).equals(""))){
				mailSubject =request.getParameter(MAIL_SUBJECT);
			}
			if(request.getParameter(MAIL_BODY) !=null && !(request.getParameter(MAIL_BODY).equals(""))) {
				mailText =request.getParameter(MAIL_BODY);
			}
			Properties mailProperty = new Properties();
			URL resourcePath =  Thread.currentThread().getContextClassLoader().getResource("mail.properties");
			mailProperty.load(new FileInputStream(new File(resourcePath.getFile())));
			String trainingMailId = mailProperty.getProperty("TrainingMailId");
			
			String [] ccTo = {};
			
			Boolean sent = false;
			try 
			{
				 sent = SendMail.sendHTMLMail("", addressTo, trainingMailId, ccTo, "", mailSubject, mailText, "");
			}
			catch(Exception e)
			{
				
			}
			String message = "Problem sending mail";
			if(sent)
			{
				message = "Mail has been sent to selected employees successfuly";
			}
			else
			{
				message = "Problem sending mail";
			}*/
		
		String jsp = SHOW_TRAVEL_APPROVAL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("employeeId", employeeId);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchTravelApprovalRequest(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int searchEmployeeId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		generalMap.put("employeeId", employeeId);
		
		if(request.getParameter("searchEmployeeId")!= null ){
			searchEmployeeId =Integer.parseInt(request.getParameter("searchEmployeeId"));
			generalMap.put("searchEmployeeId", searchEmployeeId);
		}
		int searchRefNoId = 0;
		if(request.getParameter("searchRefNoId")!= null ){
			searchRefNoId =Integer.parseInt(request.getParameter("searchRefNoId"));
			generalMap.put("searchRefNoId", searchRefNoId);
		}
		
		if (request.getParameter(FROM_DATE)!= null  && !(request.getParameter(FROM_DATE).equals("")) ) {
			Date fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
			
		}
		
		if (request.getParameter(TO_DATE)!= null  && !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}	
		map = etravelHandlerService.searchTravelApprovalRequest(generalMap);
		String jsp = SHOW_TRAVEL_APPROVAL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewTravelApprovalRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId =users.getEmployee().getId();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.viewTravelApprovalRequest(travelRequestId);
		String jsp = HR_VIEW_TRAVEL_APPROVAL_REQUEST_JSP;
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("employeeId", employeeId);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateTravelApprovalRequest(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		/*HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}*/
		//String emailIdOfUser = users.getEmployee().getEmail();
		//generalMap.put("emailIdOfUser", emailIdOfUser);
		int travelRequestId = 0;
		if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
			travelRequestId =Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
			String approvalStatus = "";
			if(request.getParameter(STATUS)!= null){
				approvalStatus = request.getParameter(STATUS);
			}
			String remark = "";
			if(request.getParameter(REMARK)!= null){
				 remark = request.getParameter(REMARK);
			}
			int lineManagerId = 0;
			if (!(request.getParameter(LINE_MANAGER).equals(""))) {
				lineManagerId =Integer.parseInt(request.getParameter(LINE_MANAGER));
			 }
			String other = "";
			if(request.getParameter("other")!= null){
				other = "y";
			}else{
				other = "n";
			}
			int headeId = 0;
			
				if(!(request.getParameter(HEAD_ID).equals(""))) {
					headeId =Integer.parseInt(request.getParameter(HEAD_ID));
				 }
			generalMap.put("travelRequestId", travelRequestId);
			generalMap.put("approvalStatus", approvalStatus);
			generalMap.put("remark", remark);
			generalMap.put("lineManagerId", lineManagerId);
			generalMap.put("headeId", headeId);
			generalMap.put("other", other);
		map = etravelHandlerService.updateTravelApprovalRequest(generalMap);
		String jsp = SHOW_TRAVEL_APPROVAL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		//map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showTicketUpdateListJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		int employeeId = 0;
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		 generalMap.put("employeeId", employeeId);
		}
		map = etravelHandlerService.showTicketUpdateListJsp(generalMap);
		String jsp = HR_TICKET_UPDATE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchTravelBookingUpdateList(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int searchEmployeeId = 0;
		if(request.getParameter(EMPLOYEE_ID)!= null ){
			searchEmployeeId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("searchEmployeeId", searchEmployeeId);
		}
		int searchRefNoId = 0;
		if(request.getParameter("searchRefNoId")!= null ){
			searchRefNoId =Integer.parseInt(request.getParameter("searchRefNoId"));
			generalMap.put("searchRefNoId", searchRefNoId);
		}
		
		if (request.getParameter(FROM_DATE)!= null  && !(request.getParameter(FROM_DATE).equals("")) ) {
			Date fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
			
		}
		
		if (request.getParameter(TO_DATE)!= null  && !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}	
		map = etravelHandlerService.searchTravelBookingUpdateList(generalMap);
		String jsp = HR_TICKET_UPDATE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView filledBookedDetailsByAdmin(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		if(request.getParameter("travelId")!= null){
			travelRequestId = Integer.parseInt(request.getParameter("travelId"));
		}
		map = etravelHandlerService.filledBookedDetailsByAdmin(travelRequestId);
		String jsp = HR_Filled_BOOKED_DETAILS_BY_ADMIN_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displayAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.displayAttachment(travelRequestId);
		String jsp = HR_ATTACH_DOCUMENT_POPUP_JSP;
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView addAttachFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
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
		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/Attendance/");
		String filename = "";
		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");
		   	
			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	
		   	fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
			
			String comments = "";
			if( mrequest.getParameter("comments")!= null){
				comments = mrequest.getParameter("comments");
				generalMap.put("comments", comments);
			}
			int travelRequestId = 0;
			if(mrequest.getParameter(TRAVEL_REQUEST_ID)!= null){
				travelRequestId = Integer.parseInt(mrequest.getParameter(TRAVEL_REQUEST_ID));
				generalMap.put("travelRequestId", travelRequestId);
			}
			int employeeId = 0;
			if(mrequest.getParameter(EMPLOYEE_ID)!= null){
				employeeId = Integer.parseInt(mrequest.getParameter(EMPLOYEE_ID));
				generalMap.put("employeeId", employeeId);
			}
			generalMap.put("uploadURL", uploadURL);
			
		map = etravelHandlerService.addAttachFile(generalMap);
		String jsp = HR_ATTACH_DOCUMENT_POPUP_JSP;
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView deleteAttachFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List ticketAttachIdList = new ArrayList();
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
		int travelRequestId = 0;
		if(mrequest.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(mrequest.getParameter(TRAVEL_REQUEST_ID));
			generalMap.put("travelRequestId", travelRequestId);
		}
		int noOfFiles = 0;
		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}
		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(TICKET_ATTACH_ID+j)!= null && !(mrequest.getParameter(TICKET_ATTACH_ID+j).equals(""))) {
				ticketAttachIdList .add(Integer.parseInt(mrequest.getParameter(TICKET_ATTACH_ID+j)));
			}
			
		}
		generalMap.put("ticketAttachIdList", ticketAttachIdList);
		map = etravelHandlerService.deleteAttachFile(generalMap);
		String jsp = HR_ATTACH_DOCUMENT_POPUP_JSP;
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	
	

	public ModelAndView sendTicketDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		EtrBookeddtlsAttach etrBookeddtlsAttach = new EtrBookeddtlsAttach();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		int adminEmployeeId = 0;
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 adminEmployeeId = users.getEmployee().getId();
		 generalMap.put("adminEmployeeId", adminEmployeeId);
		}
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketclassList =new ArrayList();
		List departureList =new ArrayList();
		List arrivalList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List ticketNoList =new ArrayList();
		List ticketTypeList =new ArrayList();
		List ticketAmtList =new ArrayList();
		List currencyList =new ArrayList();
		EtrFillbookeddtls etrFillbookeddtls = new EtrFillbookeddtls();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
			EtrTravelreq etrTravelreq = new EtrTravelreq();
			etrTravelreq.setId(travelRequestId);
			etrFillbookeddtls.setTrv(etrTravelreq);
		}
		if(request.getParameter(FILL_DATE)!= null){
			Date fillDate  = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FILL_DATE));
			etrFillbookeddtls.setFillDate(fillDate);
		}
		if(request.getParameter(HOTEL_BOOKING_DESC)!= null){
			String hotelDesc = request.getParameter(HOTEL_BOOKING_DESC);
			etrFillbookeddtls.setHotelDesc(hotelDesc);
		}
		if(request.getParameter(REMARKS)!= null){
			String remark = request.getParameter(REMARKS);
			etrFillbookeddtls.setTktDesc(remark);
		}
		if(request.getParameter(CAB_BOOKING_DESC)!= null){
			String cabDesc = request.getParameter(CAB_BOOKING_DESC);
			etrFillbookeddtls.setLocalCABDesc(cabDesc);
		}
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			 employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			etrFillbookeddtls.setCreatedBy(masEmployee);
			etrFillbookeddtls.setModifiedBy(masEmployee);
			generalMap.put("employeeId", employeeId);
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String time = (String)utilMap.get("currentTime");
		Date currentDate = new Date();
		etrFillbookeddtls.setCreatedAt(currentDate);
		//etrFillbookeddtls.setTicketBookTime(time);
		
		if(request.getParameter(UPLOAD_FILENAME)!= null){
			String uploadName = request.getParameter(UPLOAD_FILENAME);
			etrBookeddtlsAttach.setOrgFilename(uploadName);
			etrBookeddtlsAttach.setSysFilename(uploadName);
		}
		if(request.getParameter("comments")!= null){
			String comments = request.getParameter("comments");
			etrBookeddtlsAttach.setCmts(comments);
		}
		
		int noOfTicket = 0;
		if(request.getParameter("hiddenValueTicket")!= null){
			noOfTicket =Integer.parseInt(request.getParameter("hiddenValueTicket"));
		}
		for(int j=1;j<=noOfTicket;j++)
		{
			if(request.getParameter(COUNTRY_ID+j) != null ){
				fromCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_ID+j)));
			}	
			if( request.getParameter(COUNTRY_ID1+j)!= null ){
				toCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_ID1+j)));
			}
			if( request.getParameter(CITY_ID+j)!= null ){
				fromPlaceList.add(Integer.parseInt(request.getParameter(CITY_ID+j)));
			}	
			if( request.getParameter(CITY_ID1+j)!= null ){
				toPlaceList.add(Integer.parseInt(request.getParameter(CITY_ID1+j)));
			}
			if(request.getParameter(TRAVEL_MODE_ID+j)!= null && ! request.getParameter(TRAVEL_MODE_ID+j).equals("0")){
				travelModeList.add(Integer.parseInt(request.getParameter(TRAVEL_MODE_ID+j)));
			}
			if(request.getParameter(TRAVEL_CLASS_ID+j)!= null  && ! request.getParameter(TRAVEL_CLASS_ID+j).equals("0")){
				ticketclassList.add(request.getParameter(TRAVEL_CLASS_ID+j));
			}
			if(request.getParameter(DEPARTURE_TIME+j)!= null){
				departureList.add(request.getParameter(DEPARTURE_TIME+j));
			}
			if(request.getParameter(ARRIVAL_TIME+j)!= null){
				arrivalList.add(request.getParameter(ARRIVAL_TIME+j));
			}
			if(request.getParameter(TICKET_NO+j)!= null){
				ticketNoList.add(request.getParameter(TICKET_NO+j));
			}
			if(request.getParameter(TICKET_TYPE_ID+j)!= null  && ! request.getParameter(TICKET_TYPE_ID+j).equals("0")){
				ticketTypeList.add(request.getParameter(TICKET_TYPE_ID+j));
			}
			if(request.getParameter(TICKET_AMT+j)!= null){
				ticketAmtList.add(request.getParameter(TICKET_AMT+j));
			}
			if(request.getParameter(CURRENCY_ID+j) != null && !request.getParameter(CURRENCY_ID+j).equals("0")){
				currencyList.add(Integer.parseInt(request.getParameter(CURRENCY_ID+j)));
			}
		}
		generalMap.put("travelRequestId", travelRequestId);	
		generalMap.put("fromCountryList", fromCountryList);
		generalMap.put("toCountryList", toCountryList);
		generalMap.put("fromPlaceList", fromPlaceList);
		generalMap.put("toPlaceList", toPlaceList);
		generalMap.put("travelModeList", travelModeList);
		generalMap.put("ticketclassList", ticketclassList);
		generalMap.put("departureList", departureList);
		generalMap.put("arrivalList", arrivalList);
		generalMap.put("ticketNoList", ticketNoList);
		generalMap.put("ticketTypeList", ticketTypeList);
		generalMap.put("ticketAmtList", ticketAmtList);
		generalMap.put("currencyList", currencyList);
		generalMap.put("etrFillbookeddtls", etrFillbookeddtls);
		generalMap.put("etrBookeddtlsAttach", etrBookeddtlsAttach);
		
		map = etravelHandlerService.sendTicketDetail(generalMap);
		String jsp = HR_TICKET_UPDATE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showUpdateBookedDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		int employeeId = 0;
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId = users.getEmployee().getId();
		 generalMap.put("employeeId", employeeId);
		}
		map = etravelHandlerService.showUpdateBookedDetails(generalMap);
		String jsp = "updateBookingDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView editBookingDetail(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		generalMap.put("travelRequestId", travelRequestId);
		map = etravelHandlerService.editBookingDetail(generalMap);
		
		String jsp = "editTicketBookingDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateBookingDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List travelClassList =new ArrayList();
		List travelModeList =new ArrayList();
		List ticketBookingIdList =new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List departureTimeList =new ArrayList();
		List arrivalTimeList =new ArrayList();
		List ticketNoList =new ArrayList();
		List ticketTypeList =new ArrayList();
		List ticketAmountList =new ArrayList();
		List currencyList =new ArrayList();
		
		int fillBookingDetailId= 0;
		if (request.getParameter("fillBookingDetail")!= null && !(request.getParameter("fillBookingDetail").equals(""))) {
			fillBookingDetailId = Integer.parseInt(request.getParameter("fillBookingDetail"));
		}
		generalMap.put("fillBookingDetailId", fillBookingDetailId);
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			generalMap.put("employeeId", employeeId);
		}
		
	
			if(request.getParameter(HOTEL_BOOKING_DESC)!= null){
				String hotelDesc =  request.getParameter(HOTEL_BOOKING_DESC);
				generalMap.put("hotelDesc", hotelDesc);
			}
			
			if(request.getParameter(CAB_BOOKING_DESC)!= null){
				String cabDesc = request.getParameter(CAB_BOOKING_DESC);
				generalMap.put("cabDesc", cabDesc);
			}
			
		int noOfTravelBooking = 0;
		if (request.getParameter("count")!= null && ! request.getParameter("count").equals("")) {
			noOfTravelBooking = Integer.parseInt(request.getParameter("count"));
		}
		
			for(int j=1;j<=noOfTravelBooking;j++)
			{
				if(request.getParameter(ETR_TRV_DETAIL_ID+j)!= null){
					ticketBookingIdList.add(Integer.parseInt(request.getParameter(ETR_TRV_DETAIL_ID+j)));
				}
				if(request.getParameter("fromCountryHidden"+j)!= null  && !request.getParameter("fromCountryHidden"+j).equals("0")){
					fromCountryList.add(Integer.parseInt(request.getParameter("fromCountryHidden"+j)));
				}	
				if(request.getParameter("toCountryHiddenId"+j)!= null && !request.getParameter("toCountryHiddenId"+j).equals("0")){
					toCountryList.add(Integer.parseInt(request.getParameter("toCountryHiddenId"+j)));
				}
				
				if(request.getParameter("fromHidden"+j) != null && !request.getParameter("fromHidden"+j).equals("0")){
					fromPlaceList.add(Integer.parseInt(request.getParameter("fromHidden"+j)));
				}
				if(request.getParameter("toHidden"+j) != null &&  ! request.getParameter("toHidden"+j).equals("0")){
					toPlaceList.add(Integer.parseInt(request.getParameter("toHidden"+j)));
				}
				if(request.getParameter("travelModeHidden"+j) != null &&  !request.getParameter("travelModeHidden"+j).equals("0")){
					travelModeList.add(Integer.parseInt(request.getParameter("travelModeHidden"+j)));
				}
				if(request.getParameter("travelClassHidden"+j) != null &&   ! request.getParameter("travelClassHidden"+j).equals("0")){
					travelClassList.add(Integer.parseInt(request.getParameter("travelClassHidden"+j)));
				}
				
				if(request.getParameter("departureTimeGrid"+j)!= null){
					departureTimeList.add(request.getParameter("departureTimeGrid"+j));
				}
				if(request.getParameter("arrivalTimeGrid"+j)!= null){
					arrivalTimeList.add(request.getParameter("arrivalTimeGrid"+j));
				}
				if(request.getParameter("ticketNoGrid"+j)!= null){
					ticketNoList.add(request.getParameter("ticketNoGrid"+j));
				}
				if(request.getParameter("ticketTypeHidden"+j) != null &&  !request.getParameter("ticketTypeHidden"+j).equals("0")){
					ticketTypeList.add(Integer.parseInt(request.getParameter("ticketTypeHidden"+j)));
				}
				if(request.getParameter("ticketAmountGrid"+j)!= null){
					ticketAmountList.add(request.getParameter("ticketAmountGrid"+j));
				}
				if(request.getParameter("currencyHidden"+j) != null &&  ! request.getParameter("currencyHidden"+j).equals("0")){
					currencyList.add(Integer.parseInt(request.getParameter("currencyHidden"+j)));
				}
				
			 }
		generalMap.put("ticketBookingIdList", ticketBookingIdList);
		generalMap.put("fromCountryList", fromCountryList);
		generalMap.put("toCountryList", toCountryList);
		generalMap.put("fromPlaceList", fromPlaceList);
		generalMap.put("toPlaceList", toPlaceList);
		generalMap.put("travelModeList", travelModeList);
		generalMap.put("travelClassList", travelClassList);
		generalMap.put("departureTimeList", departureTimeList);
		generalMap.put("arrivalTimeList", arrivalTimeList);
		generalMap.put("ticketNoList", ticketNoList);
		generalMap.put("ticketTypeList", ticketTypeList);
		generalMap.put("ticketAmountList", ticketAmountList);
		generalMap.put("currencyList", currencyList);
		
		
		map = etravelHandlerService.updateBookingDetails(generalMap);
		String jsp = "updateBookingDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewBookedDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.viewBookedDetails(travelRequestId);
		String jsp = HR_VIEW_BOOKED_DETAIL_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView cancelBookedDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int noOfTicketCancel = 0;
		List cancelCheckBoxList = new ArrayList();
		List ticketDetailIdList = new ArrayList();
		if(request.getParameter("counter")!= null){
			noOfTicketCancel =Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<noOfTicketCancel;j++)
		{
			if(request.getParameter("ticketCancelDetail"+j) != null){
				cancelCheckBoxList.add("y");
			}else{
				cancelCheckBoxList.add("n");
			}
			if(request.getParameter(ETR_TICKET_DETAIL_ID+j) != null){
				ticketDetailIdList.add(Integer.parseInt(request.getParameter(ETR_TICKET_DETAIL_ID+j)));
			}
		}
		int fillBookedDetailId = 0;
		if(request.getParameter(ETR_FILL_BOOK_DETAIL_ID) != null){
			fillBookedDetailId = Integer.parseInt(request.getParameter(ETR_FILL_BOOK_DETAIL_ID));
			generalMap.put("fillBookedDetailId", fillBookedDetailId);
		}
		String cancelHotelCheckBox = "";
		if(request.getParameter("hotelCancelChekBox") != null){
			cancelHotelCheckBox = "y";
		}else{
			cancelHotelCheckBox = "n";
		}
		generalMap.put("cancelHotelCheckBox", cancelHotelCheckBox);
		String cancelHotelcomment = "";
		if(request.getParameter("hotelCancelComments") != null){
			cancelHotelcomment = request.getParameter("hotelCancelComments");
			generalMap.put("cancelHotelcomment", cancelHotelcomment);
		}
		
		String cancelCabCheckBox = "";
		if(request.getParameter("cabCancelCheckBox") != null){
			cancelCabCheckBox = "y";
		}else{
			cancelCabCheckBox = "n";
		}
		generalMap.put("cancelCabCheckBox", cancelCabCheckBox);
		
		String cancelCabcomment = "";
		if(request.getParameter("cabCancelComments") != null){
			cancelCabcomment = request.getParameter("cabCancelComments");
			generalMap.put("cancelCabcomment", cancelCabcomment);
		}
		generalMap.put("cancelCabcomment", cancelCabcomment);
		
		generalMap.put("cancelCheckBoxList", cancelCheckBoxList);
		generalMap.put("ticketDetailIdList", ticketDetailIdList);
		map = etravelHandlerService.cancelBookedDetails(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTravelCancellationApproval(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		generalMap.put("employeeId", employeeId);
		map = etravelHandlerService.showTravelCancellationApproval(generalMap);
		String jsp = TRAVEL_REQUEST_FOR_CANCELLATION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		//map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView approveCancelBookedDetails(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		int travelRequestId= 0;
		if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.approveCancelBookedDetails(travelRequestId);
		String jsp = HR_APPROVE_CANCEL_BOOKED_DETAILS_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("employeeId", employeeId);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView approveCancelBookedDetailsByAdmin(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 int userId = users.getEmployee().getId();
		 generalMap.put("userId", userId);
		}
		
		
		int travelRequestId = 0;
		if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
			travelRequestId =Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
			String approvalStatus = "";
			if(request.getParameter(STATUS)!= null){
				approvalStatus = request.getParameter(STATUS);
			}
			String remark = "";
			if(request.getParameter(REMARK)!= null){
				 remark = request.getParameter(REMARK);
			}
			int lineManagerId = 0;
			if (!(request.getParameter(LINE_MANAGER).equals(""))) {
				lineManagerId =Integer.parseInt(request.getParameter(LINE_MANAGER));
			 }
			String other = "";
			if(request.getParameter("other")!= null){
				other = "y";
			}else{
				other = "n";
			}
			int headeId = 0;
			
				if(!(request.getParameter(HEAD_ID).equals(""))) {
					headeId =Integer.parseInt(request.getParameter(HEAD_ID));
				 }
			generalMap.put("travelRequestId", travelRequestId);
			generalMap.put("approvalStatus", approvalStatus);
			generalMap.put("remark", remark);
			generalMap.put("lineManagerId", lineManagerId);
			generalMap.put("headeId", headeId);
			generalMap.put("other", other);
		map = etravelHandlerService.approveCancelBookedDetailsByAdmin(generalMap);
		String jsp = TRAVEL_REQUEST_FOR_CANCELLATION;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTravelAdvanceJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
	
		map = etravelHandlerService.showTravelAdvanceJsp();
		String jsp = HR_TRAVEL_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewTravelRequestForPayAdvance(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId= 0;
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.viewTravelRequestForPayAdvance(travelRequestId);
		String jsp = "hr_viewTravelRequestForPayAdvance";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView paidTravelAdvanceAmount(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int travelRequestId = 0;
			if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
				travelRequestId =  Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
			}
			int employeeId = 0;
			if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null && !(request.getParameter(EMPLOYEE_HIDDEN_ID).equals(""))) {
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			}
			generalMap.put("travelRequestId", travelRequestId);
			generalMap.put("employeeId", employeeId);
		
		String modeOFPayment = "";
		if(request.getParameter(PAYMENT_MODE)!= null){
			modeOFPayment = request.getParameter(PAYMENT_MODE);
			generalMap.put("modeOFPayment", modeOFPayment);
		}
		if(request.getParameter(DISBURSEMENT_DATE)!= null){
			Date disbursementDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISBURSEMENT_DATE));
			generalMap.put("disbursementDate", disbursementDate);
		}
		
		if(request.getParameter(ADVANCE_PAID)!= null){
			BigDecimal advancePaid =  new BigDecimal(request.getParameter(ADVANCE_PAID));
			generalMap.put("advancePaid", advancePaid);
		}
		map = etravelHandlerService.paidTravelAdvanceAmount(generalMap);
		String jsp = HR_TRAVEL_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView paidTravelAdvanceByAccounts(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List travelRequestIdList = new ArrayList();
		List advancePaidList = new ArrayList();
		List paidStatusList = new ArrayList();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = users.getEmployee().getId();
		int count = 0;
		if (request.getParameter("counter")!= null) {
			count = Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<count;j++)
		{
			if (request.getParameter(TRAVEL_REQUEST_ID+j)!= null && !(request.getParameter(TRAVEL_REQUEST_ID+j).equals(""))) {
				travelRequestIdList .add(Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID+j)));
			
			if (request.getParameter(ADVANCE_PAID+j)!= null && !(request.getParameter(ADVANCE_PAID+j).equals(""))) {
				advancePaidList .add(new BigDecimal(request.getParameter(ADVANCE_PAID+j)));
			}	
			/*if(request.getParameter("paidStatus"+j) != null){
				paidStatusList.add("Paid");
			}else{
				paidStatusList.add("Pending");
			}*/
			}
		 }
		String modeOFPayment = "";
		if(request.getParameter(PAYMENT_MODE)!= null){
			modeOFPayment = request.getParameter(PAYMENT_MODE);
			generalMap.put("modeOFPayment", modeOFPayment);
		}
		if(request.getParameter(DISBURSEMENT_DATE)!= null){
			Date disbursementDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISBURSEMENT_DATE));
			generalMap.put("disbursementDate", disbursementDate);
		}
		
		
		generalMap.put("employeeId", employeeId);
		generalMap.put("travelRequestIdList", travelRequestIdList);
		generalMap.put("advancePaidList", advancePaidList);
		generalMap.put("paidStatusList", paidStatusList);
		map = etravelHandlerService.paidTravelAdvanceByAccounts(generalMap);
		
		
		String jsp = HR_TRAVEL_ADVANCE_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView submitTravelExpenses(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.submitTravelExpenses(travelRequestId);
		String jsp = HR_SUBMIT_TRAVEL_EXPENSES_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showUpdateExpensesJsp(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int travelRequestId = 0;
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
			generalMap.put("travelRequestId", travelRequestId);
		}
		map = etravelHandlerService.showUpdateExpensesJsp(generalMap);
		String jsp = "hr_updateExpenses";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView updateExpenseDetails(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List expenseIdList =new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		List fromDateList =new ArrayList();
		List toDateList =new ArrayList();
		List expenseAmountList =new ArrayList();
		List currencyList =new ArrayList();
		List remarkList =new ArrayList();
		List expenseHeadList =new ArrayList();
		int employeeId = 0;
		String refNo = "";
		if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			generalMap.put("employeeId", employeeId);
		}
		if(request.getParameter("refNo")!= null){
			refNo =  request.getParameter("refNo");
		}
		int expSubmitId= 0;
		if (request.getParameter("expSubmit")!= null && !(request.getParameter("expSubmit").equals(""))) {
			expSubmitId = Integer.parseInt(request.getParameter("expSubmit"));
		}
		generalMap.put("expSubmitId", expSubmitId);
		
			
		int noOfExpenses = 0;
		if (request.getParameter("count")!= null && ! request.getParameter("count").equals("")) {
			noOfExpenses = Integer.parseInt(request.getParameter("count"));
		}
		
			for(int j=1;j<=noOfExpenses;j++)
			{
				if(request.getParameter("expDetailId"+j)!= null){
					expenseIdList.add(Integer.parseInt(request.getParameter("expDetailId"+j)));
				}
				if(request.getParameter("expenseHeadGridHidden"+j)!= null  && !request.getParameter("expenseHeadGridHidden"+j).equals("0")){
					expenseHeadList.add(Integer.parseInt(request.getParameter("expenseHeadGridHidden"+j)));
				}
				if(request.getParameter("fromCountryHidden"+j)!= null  && !request.getParameter("fromCountryHidden"+j).equals("0")){
					fromCountryList.add(Integer.parseInt(request.getParameter("fromCountryHidden"+j)));
				}	
				if(request.getParameter("toCountryHiddenId"+j)!= null && !request.getParameter("toCountryHiddenId"+j).equals("0")){
					toCountryList.add(Integer.parseInt(request.getParameter("toCountryHiddenId"+j)));
				}
				
				if(request.getParameter("fromHidden"+j) != null && !request.getParameter("fromHidden"+j).equals("0")){
					fromPlaceList.add(Integer.parseInt(request.getParameter("fromHidden"+j)));
				}
				if(request.getParameter("toHidden"+j) != null &&  ! request.getParameter("toHidden"+j).equals("0")){
					toPlaceList.add(Integer.parseInt(request.getParameter("toHidden"+j)));
				}
				
				if(request.getParameter("fromDateGrid"+j)!= null){
					fromDateList.add(request.getParameter("fromDateGrid"+j));
				}
				if(request.getParameter("toDateGrid"+j)!= null){
					toDateList.add(request.getParameter("toDateGrid"+j));
				}
				if(request.getParameter("expenseAmountGrid"+j)!= null){
					expenseAmountList.add(request.getParameter("expenseAmountGrid"+j));
				}
				if(request.getParameter("currencyHidden"+j) != null &&  ! request.getParameter("currencyHidden"+j).equals("0")){
					currencyList.add(Integer.parseInt(request.getParameter("currencyHidden"+j)));
				}
				if(request.getParameter("remarkGrid"+j)!= null){
					remarkList.add(request.getParameter("remarkGrid"+j));
				}
			 }
			generalMap.put("remarkList", remarkList);
			generalMap.put("expenseIdList", expenseIdList);
			generalMap.put("expenseHeadList", expenseHeadList);
			generalMap.put("fromCountryList", fromCountryList);
			generalMap.put("toCountryList", toCountryList);
			generalMap.put("fromPlaceList", fromPlaceList);
			generalMap.put("toPlaceList", toPlaceList);
			generalMap.put("fromDateList", fromDateList);
			generalMap.put("toDateList", toDateList);
			generalMap.put("expenseAmountList", expenseAmountList);
			generalMap.put("currencyList", currencyList);
			generalMap.put("refNo", refNo);
			map  = etravelHandlerService.updateExpenseDetails(generalMap);
		String jsp = TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
	
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView displaySubmitExpensesAttachment(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.displaySubmitExpensesAttachment(travelRequestId);
		String jsp = HR_ATTACH_EXPENSES_DOCUMENT_POPUP_JSP;
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	public ModelAndView addAttachExpensesFile(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
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
		String fileExtension=null;
		String uploadURL = getServletContext().getRealPath("/Attendance/");
		String filename = "";
		List fileUploadedList = null;
			if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
			generalMap.put("filename", filename);
			StringTokenizer strToken=new StringTokenizer(filename,".");
		   	
			filename=strToken.nextToken();
		   	fileExtension=strToken.nextToken();
		   	String whiteList = "*."+fileExtension;
		   	
		   	fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
			
			String comments = "";
			if( mrequest.getParameter("comments")!= null){
				comments = mrequest.getParameter("comments");
				generalMap.put("comments", comments);
			}
			int travelRequestId = 0;
			if(mrequest.getParameter(TRAVEL_REQUEST_ID)!= null){
				travelRequestId = Integer.parseInt(mrequest.getParameter(TRAVEL_REQUEST_ID));
				generalMap.put("travelRequestId", travelRequestId);
			}
			int employeeId = 0;
			if(mrequest.getParameter(EMPLOYEE_ID)!= null){
				employeeId = Integer.parseInt(mrequest.getParameter(EMPLOYEE_ID));
				generalMap.put("employeeId", employeeId);
			}
			generalMap.put("uploadURL", uploadURL);
			
		map = etravelHandlerService.addAttachExpensesFile(generalMap);
		String jsp = HR_ATTACH_EXPENSES_DOCUMENT_POPUP_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView deleteAttachExpenseFile(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List ticketAttachIdList = new ArrayList();
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
		int travelRequestId = 0;
		if(mrequest.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(mrequest.getParameter(TRAVEL_REQUEST_ID));
			generalMap.put("travelRequestId", travelRequestId);
		}
		int noOfFiles = 0;
		if(mrequest.getParameter("counter")!= null){
			noOfFiles = Integer.parseInt(mrequest.getParameter("counter"));
		}
		for(int j=0;j<noOfFiles;j++)
		{
			if (mrequest.getParameter(TICKET_ATTACH_ID+j)!= null && !(mrequest.getParameter(TICKET_ATTACH_ID+j).equals(""))) {
				ticketAttachIdList .add(Integer.parseInt(mrequest.getParameter(TICKET_ATTACH_ID+j)));
			}
			
		}
		generalMap.put("ticketAttachIdList", ticketAttachIdList);
		map = etravelHandlerService.deleteAttachExpenseFile(generalMap);
		String jsp = HR_ATTACH_EXPENSES_DOCUMENT_POPUP_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveSubmitExpensesDetails(HttpServletRequest request , HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List expenseList = new ArrayList();
		List fromdateList = new ArrayList();
		List todateList = new ArrayList();
		List descList = new ArrayList();
		List currencyList = new ArrayList();
		List amountList = new ArrayList();
		List fromPlaceList =new ArrayList();
		List toPlaceList =new ArrayList();
		List fromCountryList =new ArrayList();
		List toCountryList =new ArrayList();
		EtrExpsubmit etrExpsubmit = new EtrExpsubmit();
		HttpSession session = request.getSession();
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		int employeeId = 0;
		employeeId = users.getEmployee().getId();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
			EtrTravelreq etrTravelreq = new EtrTravelreq();
			etrTravelreq.setId(travelRequestId);
			etrExpsubmit.setTrv(etrTravelreq);
		}
		
		if(request.getParameter(EMPLOYEE_HIDDEN_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			MasEmployee masEmployee = new MasEmployee();
			masEmployee.setId(employeeId);
			etrExpsubmit.setAct(masEmployee);
		}
		Date actualJFromDate = null;
		if (request.getParameter(ACTUAL_J_FROM_DATE)!= null  && !(request.getParameter(ACTUAL_J_FROM_DATE).equals(""))) {
			actualJFromDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_J_FROM_DATE));
			etrExpsubmit.setActFrmDate(actualJFromDate);
		}
		Date actualJToDate = null;
		if (request.getParameter(ACTUAL_J_TO_DATE)!= null  && !(request.getParameter(ACTUAL_J_TO_DATE).equals(""))) {
			actualJToDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(ACTUAL_J_TO_DATE));
			etrExpsubmit.setActTodate(actualJToDate);
		}
		
		String actualDepartureTime = "";
		if(request.getParameter(ACTUAL_DEPARTURE_TIME)!= null){
			actualDepartureTime = request.getParameter(ACTUAL_DEPARTURE_TIME);
			etrExpsubmit.setActDeptTime(actualDepartureTime);
		}
		String actualArrivalTime = "";
		if(request.getParameter(ACTUAL_ARRIVAL_TIME)!= null){
			actualArrivalTime = request.getParameter(ACTUAL_ARRIVAL_TIME);
			etrExpsubmit.setActRtnTime(actualArrivalTime);
		}
		String startTime = "";
		if(request.getParameter(START_TIME)!= null){
			startTime = request.getParameter(START_TIME);
			etrExpsubmit.setExpenseStartTime(startTime);
		}
		String endTime = "";
		if(request.getParameter(END_TIME)!= null){
			endTime = request.getParameter(END_TIME);
			etrExpsubmit.setExpenseEndTime(endTime);
		}
		String totalTime = "";
		if(request.getParameter("totalTime")!= null){
			totalTime = request.getParameter("totalTime");
			etrExpsubmit.setExpenseTotalTime(totalTime);
		}
		Date currentDate = new Date();
		etrExpsubmit.setEntryDate(currentDate);
		int noOfExpenses = 0;
		if(request.getParameter("hiddenValueTicket")!= null){
			noOfExpenses =Integer.parseInt(request.getParameter("hiddenValueTicket"));
		}
		for(int j=1;j<=noOfExpenses;j++)
		{
			if(request.getParameter(EXPENSE_TYPE_ID+j) != null && !request.getParameter(EXPENSE_TYPE_ID+j).equals("0") ){
				expenseList.add(Integer.parseInt(request.getParameter(EXPENSE_TYPE_ID+j)));
			}	
			if( request.getParameter(FROM_DATE+j)!= null ){
				fromdateList.add(request.getParameter(FROM_DATE+j));
			}
			if( request.getParameter(TO_DATE+j)!= null ){
				todateList.add(request.getParameter(TO_DATE+j));
			}	
			if( request.getParameter(DESCRIPTION+j)!= null ){
				descList.add(request.getParameter(DESCRIPTION+j));
			}
			if(request.getParameter(CITY_ID+j) != null && !request.getParameter(CITY_ID+j).equals("0")){
				fromPlaceList.add(Integer.parseInt(request.getParameter(CITY_ID+j)));
			}
			if(request.getParameter(CITY_ID1+j) != null && !request.getParameter(CITY_ID1+j).equals("0") ){
				toPlaceList.add(Integer.parseInt(request.getParameter(CITY_ID1+j)));
			}
			if(((request.getParameter(COUNTRY_ID+j) != null) && !request.getParameter(COUNTRY_ID+j).equals("0"))){
				fromCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_ID+j)));
			}
			if((request.getParameter(COUNTRY_ID1+j) != null) &&(!request.getParameter(COUNTRY_ID1+j).equals("0"))){
				toCountryList.add(Integer.parseInt(request.getParameter(COUNTRY_ID1+j)));
			}
			if(request.getParameter(CURRENCY_ID+j) != null && !request.getParameter(CURRENCY_ID+j).equals("0")){
				currencyList.add(Integer.parseInt(request.getParameter(CURRENCY_ID+j)));
			}
			if(request.getParameter(TICKET_AMT+j)!= null){
				amountList.add(request.getParameter(TICKET_AMT+j));
			}
		  }
			
		
		/*
				EtrTrvsubAttach etrTrvsubAttach = new EtrTrvsubAttach();
			if(request.getParameter(UPLOAD_FILENAME)!= null){
				String uploadName = request.getParameter(UPLOAD_FILENAME);
				etrTrvsubAttach.setDsDfilename(uploadName);
				etrTrvsubAttach.setDsOfilename(uploadName);
			}
			if(request.getParameter("comments")!= null){
				String comments = request.getParameter("comments");
				etrTrvsubAttach.setDsDesc(comments);
				
			}*/
			generalMap.put("employeeId", employeeId);
			//generalMap.put("etrTrvsubAttach", etrTrvsubAttach);
			generalMap.put("travelRequestId", travelRequestId);
			generalMap.put("expenseList", expenseList);
			generalMap.put("fromdateList", fromdateList);
			generalMap.put("todateList", todateList);
			generalMap.put("descList", descList);
			generalMap.put("fromPlaceList", fromPlaceList);
			generalMap.put("toPlaceList", toPlaceList);
			generalMap.put("fromCountryList", fromCountryList);
			generalMap.put("toCountryList", toCountryList);
			generalMap.put("currencyList", currencyList);
			generalMap.put("amountList", amountList);
			generalMap.put("etrExpsubmit", etrExpsubmit);
			map = etravelHandlerService.saveSubmitExpensesDetails(generalMap);
		String jsp =TRAVEL_REQUEST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView viewTravelExpenses(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		
		if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
			travelRequestId = Integer.parseInt(request.getParameter("rb"));
		}
		map = etravelHandlerService.viewTravelExpenses(travelRequestId);
		String jsp =HR_VIEW_EXPENSES_DETAIL;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewExpensesAttachment(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.viewExpensesAttachment(travelRequestId);
		String jsp = HR_EXPENSES_POPUP_JSP;
		//jsp += ".jsp";
		//map.put("contentJsp", jsp);
		
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView viewExpenseDocuments(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		//Box box = HMSUtil.getBox(request);
		String filename=null;
		String fileExtension=null;
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
		   
		   if(request.getParameter("filename")!= null){
				filename = request.getParameter("filename");
			}
		    Map<String, Object> uploadFileMap = new HashMap<String, Object>();

		   	String uploadURL = getServletContext().getRealPath("/Attendance/");

		   StringTokenizer st1=new StringTokenizer(filename,".");
			filename=st1.nextToken();
			fileExtension=st1.nextToken();
		   
		   //box.put("filename", box.getString("filename"));
		   //map = mrdHandlerService.viewUploadDocuments(box);
		   try
		   {
			   if (fileExtension== "doc" || fileExtension == "docx")
			   {
			   response.setContentType( "application/vnd.ms-word" );
			   }
			   else if (fileExtension == "xls" || fileExtension == "xlsx")
			   {
			   response.setContentType( "application/vnd.ms-excel" );
			   }
			   else if (fileExtension == "pdf")
			   {
			   response.setContentType( "application/pdf" );
			   }else if (fileExtension.trim().equalsIgnoreCase("txt"))
			   {
			   response.setContentType( "text/plain" );
			   }else if (fileExtension.trim().equalsIgnoreCase("ppt"))
			   {
			   response.setContentType( "application/ppt" );
			   }else if (fileExtension == "png" )
			   {
			   response.setContentType( "image/png" );
			   }else if (fileExtension == "jpeg" )
			   {
				   
			   response.setContentType( "image/jpeg" );
			   }else if (fileExtension == "wbmp" )
			   {
			   response.setContentType( "image/vnd.wap.wbmp" );
			   }else if (fileExtension == "gif" )
			   {
			   response.setContentType( "image/gif");
			   }else if (fileExtension == "jpg" )
			   {
			   response.setContentType( "image/jpg" );
			   }
			   else
			   {
			   response.setContentType( "application/octet-stream" );
			   }
			   //set the header and also the Name by which user will be prompted to save
			   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
	          // response.setContentType("image/"+fileExtension);
	          // response.setHeader("Content-Disposition", "attachment; filename="+filename+"."+fileExtension);

		       File f = new File(uploadURL+"/"+filename+"."+fileExtension);
		       InputStream in = new FileInputStream(f);
		       response.getOutputStream().flush();
		       ServletOutputStream outs = response.getOutputStream();
		       
		       
		       long length = f.length();
			    
	    	     if (length > Integer.MAX_VALUE) {
	            // File is too large
	    	     }
	    
	    	     // Create the byte array to hold the data
	    	     byte[] bytes = new byte[(int)length];
	    
	    	     int offset = 0;
	    	     int numRead = 0;
	    	     while (offset < bytes.length
	    	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
	    	    	 offset += numRead;
	    	     }
	    
	    	     if (offset < bytes.length) {
	    	     }
	    	     outs.write(bytes);
	    	     in.close();
		  
		   } 
		   catch (IOException ioe) 
		   {
			   ioe.printStackTrace();
		   }
	   
		   String jsp = HR_EXPENSES_POPUP_JSP;
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
public ModelAndView viewBookingDetailsAttachment(HttpServletRequest request ,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	int travelRequestId = 0;
	
	if (request.getParameter("rb")!= null && !(request.getParameter("rb").equals(""))) {
		travelRequestId = Integer.parseInt(request.getParameter("rb"));
	}
	map = etravelHandlerService.viewBookingDetailsAttachment(travelRequestId);
	String jsp = VIEW_BOOKING_DETAIL_POPUP;
	//jsp += ".jsp";
	//map.put("contentJsp", jsp);
	
	return new ModelAndView(jsp, "map", map);
}
public ModelAndView viewBookingDetailDocuments(HttpServletRequest request ,HttpServletResponse response) {
	Map<String, Object> map = new HashMap<String, Object>();
	//Box box = HMSUtil.getBox(request);
	String filename=null;
	String fileExtension=null;
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
	   System.out.println("==============");
	    Map<String, Object> uploadFileMap = new HashMap<String, Object>();
	   	String uploadURL = getServletContext().getRealPath("/");

		if(request.getParameter("filename")!= null){
			filename = request.getParameter("filename");
		}
		
	   StringTokenizer st1=new StringTokenizer(filename,".");
		filename=st1.nextToken();
		fileExtension=st1.nextToken();
	   //box.put("filename", box.getString("filename"));
	   //map = mrdHandlerService.viewUploadDocuments(box);
		try
		   {
			   if (fileExtension =="doc" || fileExtension =="docx" )
			   {
			   response.setContentType( "application/vnd.ms-word" );
			   }
			   else if (fileExtension == "xls" || fileExtension == "xlsx")
				   
			   {
			   response.setContentType( "application/vnd.ms-excel" );
			   }
			   else if (fileExtension == "pdf")
			   {
			   response.setContentType( "application/pdf" );
			   }else if (fileExtension.trim().equalsIgnoreCase("txt"))
			   {
			   response.setContentType( "text/plain" );
			   }else if (fileExtension.trim().equalsIgnoreCase("ppt"))
			   {
			   response.setContentType( "application/ppt" );
			   }else if (fileExtension == "png" )
			   {
			   response.setContentType( "image/png" );
			   }else if (fileExtension == "jpeg" )
			   {
				   
			   response.setContentType( "image/jpeg" );
			   }else if (fileExtension == "wbmp" )
			   {
			   response.setContentType( "image/vnd.wap.wbmp" );
			   }else if (fileExtension == "gif" )
			   {
			   response.setContentType( "image/gif");
			   }else if (fileExtension == "jpg" )
			   {
			   response.setContentType( "image/jpg" );
			   }
			   else
			   {
			   response.setContentType( "application/octet-stream" );
			   }
		   //set the header and also the Name by which user will be prompted to save
		   response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(request.getParameter("filename"))+"");
		   //response.setHeader ("Content-Disposition", "attachment;filename="+java.net.URLEncoder.encode(box.getString("filename"))+"");
          // response.setContentType("image/"+fileExtension);
          // response.setHeader("Content-Disposition", "attachment; filename="+filename+"."+fileExtension);
		   System.out.println("===="+uploadURL+"/"+filename+"."+fileExtension);
	       File f = new File(uploadURL+"/"+filename+"."+fileExtension);
	       InputStream in = new FileInputStream(f);
	       response.getOutputStream().flush();
	      ServletOutputStream outs = response.getOutputStream();
	       
	       long length = f.length();
    	     if (length > Integer.MAX_VALUE) {
            // File is too large
    	     }
    	     // Create the byte array to hold the data
    	     byte[] bytes = new byte[(int)length];
    
    	     int offset = 0;
    	     int numRead = 0;
    	     while (offset < bytes.length
    	    		 && (numRead=in.read(bytes, offset, bytes.length-offset)) >= 0) {
    	    	 offset += numRead;
    	     }
    
    	     if (offset < bytes.length) {
    	     }
    	     outs.write(bytes);
    	     in.close();
	  
	   } 
	   catch (IOException ioe) 
	   {
		   ioe.printStackTrace();
	   }
   
	   String jsp = VIEW_BOOKING_DETAIL_POPUP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		
		return new ModelAndView("index", "map", map);
	}
	/*****************  Methods For E-Travel Reports Start ****************************/
	
	public ModelAndView showTravelsBetweenDates(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showTravelsBetweenDates(generalMap);
		String jsp = TRAVELS_BETWEEN_DATES;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView printTravelsBetweenDates(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int projectId   = 0;
		int departmentId = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
		String query = "";
		String projName = null;
		String deptName = null;
		String travelWithCost = "";
			
				try
				{ 
					if(request.getParameter("allTravelWithCost") != null && !(request.getParameter("allTravelWithCost").equals(""))){
						travelWithCost = request.getParameter("allTravelWithCost");
					}
					if(request.getParameter("projName") !=null && !(request.getParameter("projName").equals(""))){
						projName = request.getParameter("projName");
					}
					if(request.getParameter("deptName") != null && !(request.getParameter("deptName").equals(""))){
						deptName = request.getParameter("deptName");
					}
					if(projName == null || projName == ""){
						projName = "All";
					}
					if(deptName == null || deptName == ""){
						deptName = "All";
					}
					
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
					if (request.getParameter(PROJECT_ID)!= null && Integer.parseInt(request.getParameter(PROJECT_ID)) != 0) {
						projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
						query = " and secondfinal.prj_id = "+ projectId;
					}
					if(request.getParameter(DEPARTMENT_ID) != null && Integer.parseInt(request.getParameter(DEPARTMENT_ID)) != 0){
						departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
						query = query + "  and department_id = "+ departmentId;
					}
				
				parameters.put("query", query);
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
				parameters.put("ProjectName", projName);
				parameters.put("DepartMentName", deptName);
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				if(travelWithCost.equals("y")){
					HMSUtil.generateReport("ETravelTrports",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}else{
					HMSUtil.generateReport("ETravelTrportsWTCost",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
	}	

	
	public ModelAndView showMyTravelReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showMyTravelReport(generalMap);
		String jsp = MY_TRAVEL_REPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	
	public ModelAndView getProjectFromAjax(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int employeeId = 0;
		if(request.getParameter(EMPLOYEE_ID)!= null){
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("employeeId", employeeId);
		}
		map = etravelHandlerService.getProjectFromAjax(generalMap);
		
		return new ModelAndView("hr_responseForEmployeeProject", "map", map);
	}
	
	public ModelAndView showTravelExpenseClaimJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = etravelHandlerService.showTravelExpenseClaimJsp();
		String jsp = HR_TRAVEL_EXPENSES_CLAIM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchTravelExpenseSettlementList(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		
		int searchRefNoId = 0;
		if(request.getParameter("searchRefNoId")!= null ){
			searchRefNoId =Integer.parseInt(request.getParameter("searchRefNoId"));
			generalMap.put("searchRefNoId", searchRefNoId);
		}
		int empId = 0;
		if(request.getParameter(EMPLOYEE_ID)!= null ){
			empId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("empId", empId);
		}
		if (request.getParameter(FROM_DATE)!= null  && !(request.getParameter(FROM_DATE).equals("")) ) {
			Date fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
			
		}
		
		if (request.getParameter(TO_DATE)!= null  && !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}	
		map = etravelHandlerService.searchTravelExpenseSettlementList(generalMap);
		String jsp = HR_TRAVEL_EXPENSES_CLAIM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView viewTravelRequestForExpenseClaim(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.viewTravelRequestForExpenseClaim(travelRequestId);
		String jsp = VIEW_TRAVEL_REQUEST_FOR_EXPENSE_CLAIM_JSP;
		
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView paidTravelExpensesClaim(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List travelRequestIdList = new ArrayList();
		List employeeIdList = new ArrayList();
		int userId = 0;
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 userId = users.getEmployee().getId();
		 generalMap.put("userId", userId);
		}
		int count = 0;
		if (request.getParameter("counter")!= null) {
			count = Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<count;j++)
		{
			if (request.getParameter(TRAVEL_REQUEST_ID+j)!= null && !(request.getParameter(TRAVEL_REQUEST_ID+j).equals(""))) {
				travelRequestIdList .add(Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID+j)));
			}
			if (request.getParameter(EMPLOYEE_ID+j)!= null && !(request.getParameter(EMPLOYEE_ID+j).equals(""))) {
				employeeIdList .add(Integer.parseInt(request.getParameter(EMPLOYEE_ID+j)));
			}
		 }
		generalMap.put("travelRequestIdList", travelRequestIdList);
		generalMap.put("employeeIdList", employeeIdList);
		String modeOFPayment = "";
		if(request.getParameter(PAYMENT_MODE)!= null){
			modeOFPayment = request.getParameter(PAYMENT_MODE);
			generalMap.put("modeOFPayment", modeOFPayment);
		}
		if(request.getParameter(DISBURSEMENT_DATE)!= null){
			Date disbursementDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISBURSEMENT_DATE));
			generalMap.put("disbursementDate", disbursementDate);
		}
		
		map = etravelHandlerService.paidTravelExpensesClaim(generalMap);
		
		
		String jsp = HR_TRAVEL_EXPENSES_CLAIM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView paidTravelExpenseSettlement(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int userId = 0;
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 userId = users.getEmployee().getId();
		 generalMap.put("userId", userId);
		}
		int travelRequestId = 0;
			if (request.getParameter(TRAVEL_REQUEST_ID)!= null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))) {
				travelRequestId =  Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
			}
			int employeeId = 0;
			if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null && !(request.getParameter(EMPLOYEE_HIDDEN_ID).equals(""))) {
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			}
			generalMap.put("travelRequestId", travelRequestId);
			generalMap.put("employeeId", employeeId);
		
		String modeOFPayment = "";
		if(request.getParameter(PAYMENT_MODE)!= null){
			modeOFPayment = request.getParameter(PAYMENT_MODE);
			generalMap.put("modeOFPayment", modeOFPayment);
		}
		if(request.getParameter(DISBURSEMENT_DATE)!= null){
			Date disbursementDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(DISBURSEMENT_DATE));
			generalMap.put("disbursementDate", disbursementDate);
		}
		
		map = etravelHandlerService.paidTravelExpenseSettlement(generalMap);
		
		
		String jsp = HR_TRAVEL_EXPENSES_CLAIM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView showTravelExpenseApprovalJsp(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int lineManagerId = 0;
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 lineManagerId = users.getEmployee().getId();
		 generalMap.put("lineManagerId", lineManagerId);
		}
		map = etravelHandlerService.showTravelExpenseApprovalJsp(generalMap);
		String jsp = TRAVEL_APPROVAL_EXPENSE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView approveTravelExpensesClaim(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		int employeeId1 = 0;
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 employeeId1 = users.getEmployee().getId();
		}
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		map = etravelHandlerService.approveTravelExpensesClaim(travelRequestId);
		String jsp = APPROVE_EXPENSE_CLAIM_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("employeeId1", employeeId1);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView saveStatusOfexpenseDetail(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		List approvedAmountList = new ArrayList();
		List standardAmountList = new ArrayList();
		List expDetailIdList = new ArrayList();
		int expenseSubmitId = 0;
		if(request.getParameter("expenseSubmitId")!= null){
			expenseSubmitId =Integer.parseInt(request.getParameter("expenseSubmitId"));
		}
		int employeeId = 0;
		if (request.getParameter(EMPLOYEE_HIDDEN_ID)!= null && !(request.getParameter(EMPLOYEE_HIDDEN_ID).equals(""))) {
			employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_HIDDEN_ID));
			generalMap.put("employeeId", employeeId);
		}
		generalMap.put("expenseSubmitId", expenseSubmitId);
		int count = 0;
		if(request.getParameter("counter")!= null){
			count =Integer.parseInt(request.getParameter("counter"));
		}
		for(int j=0;j<count;j++)
		{
			if (request.getParameter(ETR_EXPDETAIL_ID+j)!= null && !(request.getParameter(ETR_EXPDETAIL_ID+j).equals(""))) {
				expDetailIdList .add(Integer.parseInt(request.getParameter(ETR_EXPDETAIL_ID+j)));
			}
			if (request.getParameter(STANDARD_AMOUNT+j)!= null && !(request.getParameter(STANDARD_AMOUNT+j).equals(""))) {
				standardAmountList .add(request.getParameter(STANDARD_AMOUNT+j));
			}
			if (request.getParameter(EXPENSE_AMOUNT+j)!= null && !(request.getParameter(EXPENSE_AMOUNT+j).equals(""))) {
				approvedAmountList .add(request.getParameter(EXPENSE_AMOUNT+j));
			}
			
		 }
		int travelRequestId = 0;
		if(request.getParameter(TRAVEL_REQUEST_ID)!= null){
			travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
		}
		String approvalStatus = "";
		if(request.getParameter(STATUS)!= null){
			approvalStatus = request.getParameter(STATUS);
		}
		String remark = "";
		if(request.getParameter(REMARK)!= null){
			 remark = request.getParameter(REMARK);
		}
		int lineManagerId = 0;
		if (request.getParameter(LINE_MANAGER)!= null && !(request.getParameter(LINE_MANAGER).equals(""))) {
			lineManagerId =Integer.parseInt(request.getParameter(LINE_MANAGER));
		 }
		
		String other = "";
		if(request.getParameter("other")!= null){
			other = "y";
		}else{
			other = "n";
		}
		int headeId = 0;
		
			if(!(request.getParameter(HEAD_ID).equals(""))) {
				headeId =Integer.parseInt(request.getParameter(HEAD_ID));
			}
		generalMap.put("expDetailIdList", expDetailIdList);
		generalMap.put("standardAmountList", standardAmountList);
		generalMap.put("approvedAmountList", approvedAmountList);
		generalMap.put("other", other);
		generalMap.put("headeId", headeId);
		generalMap.put("travelRequestId", travelRequestId);
		generalMap.put("approvalStatus", approvalStatus);
		generalMap.put("remark", remark);
		generalMap.put("lineManagerId", lineManagerId);
		map = etravelHandlerService.saveStatusOfexpenseDetail(generalMap);
		String jsp = TRAVEL_APPROVAL_EXPENSE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView searchTravelExpenseApprovelList(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		int searchRefNoId = 0;
		if(request.getParameter("searchRefNoId")!= null ){
			searchRefNoId =Integer.parseInt(request.getParameter("searchRefNoId"));
			generalMap.put("searchRefNoId", searchRefNoId);
		}
		int empId = 0;
		if(request.getParameter(EMPLOYEE_ID)!= null ){
			empId =Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			generalMap.put("empId", empId);
		}
		if (request.getParameter(FROM_DATE)!= null  && !(request.getParameter(FROM_DATE).equals("")) ) {
			Date fromDate =HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			generalMap.put("fromDate", fromDate);
			
		}
		
		int lineManagerId = 0;
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		 lineManagerId = users.getEmployee().getId();
		 generalMap.put("lineManagerId", lineManagerId);
		}
		
		if (request.getParameter(TO_DATE)!= null  && !(request.getParameter(TO_DATE).equals(""))) {
			Date toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			generalMap.put("toDate", toDate);
		}	
		map = etravelHandlerService.searchTravelExpenseApprovelList(generalMap);
		String jsp = TRAVEL_APPROVAL_EXPENSE_LIST_JSP;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("search","search");
		return new ModelAndView("index", "map", map);
	}
	
public ModelAndView printMyTravel(HttpServletRequest request,HttpServletResponse response){
		
	byte[] bytes = null;
	ServletContext context = request.getSession().getServletContext();
	Map parameters = new HashMap();
	int projectId   = 0;
	int employeeId = 0;
	Date fromDate = null;
	Date toDate = null;
	String a = "";
	String query = "";
	String projName = null;
			
			try
			{ 
				if(request.getParameter("projName") !=null && !(request.getParameter("projName").equals(""))){
					projName = request.getParameter("projName");
				}
				if(projName == null || projName == ""){
					projName = "All";
				}
								
				if (request.getParameter(FROM_DATE)!= null) {
					fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
					
				}
				
				if (request.getParameter(TO_DATE)!= null) {
					toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
				}		
				
				if (request.getParameter(EMPLOYEE_ID)!= null && Integer.parseInt(request.getParameter(EMPLOYEE_ID)) != 0) {
					employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
				}
				
				if (request.getParameter(PROJECT_ID)!= null && Integer.parseInt(request.getParameter(PROJECT_ID)) != 0) {
					projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
					query = " and mstr_project.Prj_Id = "+ projectId;
				}
							
			parameters.put("query", query);
			parameters.put("FDate", fromDate);
			parameters.put("TDate", toDate);
			parameters.put("EmpId", employeeId);
			parameters.put("ProjectName", projName);
							
			Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
			HMSUtil.generateReport("MyTravelrports",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
					return null;
	}

    /************** Method For Employee Travle Report Start ************************************/
	public ModelAndView showEmployeeTravelReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showEmployeeTravelReport(generalMap);
		String jsp = EMPLOYEE_TRAVEL_REPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
    
	public ModelAndView printEmployeeTravel(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int employeeId = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
		String travelWithCost = "";
		
		
				
				try
				{ 
							
					if(request.getParameter("empTravelWithCost") != null && !(request.getParameter("empTravelWithCost").equals(""))){
						travelWithCost = request.getParameter("empTravelWithCost");
					}
					
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
					if (request.getParameter(EMPLOYEE_ID)!= null && Integer.parseInt(request.getParameter(EMPLOYEE_ID)) != 0) {
						employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
					}
					
					
				
				
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
				parameters.put("EmpId", employeeId);
												
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				if(travelWithCost.equals("y")){
					HMSUtil.generateReport("EmployeeTravel",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}else{
					HMSUtil.generateReport("EmployeeTravelWTCost",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}
	
    /************** Method For Department Travle Report Start ************************************/
	public ModelAndView showDepartmentTravelReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showDepartmentTravelReport(generalMap);
		String jsp = DEPARTMENT_TRAVEL_REPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
    
public ModelAndView printDepartmentTravel(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int projectId   = 0;
		int departmentId = 0;
		int employeeId = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
		String query = "";
		String deptName = null;
				
				try
				{ 
					if(request.getParameter("deptName") != null && !(request.getParameter("deptName").equals(""))){
						deptName = request.getParameter("deptName");
					}
					if(deptName == null || deptName == ""){
						deptName = "All";
					}
									
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
					if(request.getParameter(DEPARTMENT_ID) != null && Integer.parseInt(request.getParameter(DEPARTMENT_ID)) != 0){
						departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
						query = query + "  and department_id = "+ departmentId;
					}
				
				parameters.put("query", query);
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
				parameters.put("DepartMentName", deptName);
								
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("DepartMentTravel",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}

	
/************** Method For Department Wise Total Travle Report Start ************************************/
	public ModelAndView showDepartmentWiseTotalTravel(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showDepartmentWiseTotalTravel(generalMap);
		String jsp = DEPARTMENT_WISE_TOTAL_TRAVEL;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView printDepartmentWiseTravelCost(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int departmentId = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
							
				try
				{ 
													
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
					if(request.getParameter(DEPARTMENT_ID) != null && Integer.parseInt(request.getParameter(DEPARTMENT_ID)) != 0){
						departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
					}
				
				parameters.put("DeptId", departmentId);
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
												
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("DepartmentWiseTravelCost",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}

	
	/************** Method For Project Wise Travle Report Start ************************************/
	public ModelAndView showProjectWiseTravelReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showProjectWiseTravelReport(generalMap);
		String jsp = PROJECT_WISE_TRAVEL_REPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	
public ModelAndView printProjectWiseTravel(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int projectId   = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
		String query = "";
								
				try
				{ 
																		
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
						
					if (request.getParameter(PROJECT_ID)!= null && Integer.parseInt(request.getParameter(PROJECT_ID)) != 0) {
						projectId = Integer.parseInt(request.getParameter(PROJECT_ID));
					}
								
				parameters.put("ProjID", projectId);
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
								
								
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("ProjectWiseTravel",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}
	
	
	/************** Method For Total Travle Cost Report Start ************************************/
	public ModelAndView showTotalTravelCostReport(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showTotalTravelCostReport(generalMap);
		String jsp = TOTAL_TRAVEL_COST_REPORT;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
     
public ModelAndView printTotalTravelCost(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		Date fromDate = null;
		Date toDate = null;
		String a = "";
								
				try
				{ 
															
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
							
								
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("TotalTravelCost",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}
	
	
	
	/************** Method For Employee Wise Travle Cost Report Start ************************************/
	public ModelAndView showEmployeeWiseTravelCost(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		HttpSession session = request.getSession(true);
		Users users = new Users();
		if(session.getAttribute("users")!= null){
		 users=(Users)session.getAttribute("users");
		}
		generalMap.put("users", users);
		map = etravelHandlerService.showEmployeeWiseTravelCost(generalMap);
		String jsp = EMPLOYEE_WISE_TRAVEL_COST;
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		map.put("users", users);
		return new ModelAndView("index", "map", map);
	}
	
	
public ModelAndView printEmployeeWiseTotalTravelCost(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int employeeId = 0;
		Date fromDate = null;
		Date toDate = null;
		String a = "";
								
				try
				{ 
													
					if (request.getParameter(FROM_DATE)!= null) {
						fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
						
					}
					
					if (request.getParameter(TO_DATE)!= null) {
						toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
					}		
					
					if (request.getParameter(EMPLOYEE_ID)!= null && Integer.parseInt(request.getParameter(EMPLOYEE_ID)) != 0) {
						employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
					}
					
									
				parameters.put("EmpId", employeeId);
				parameters.put("FDate", fromDate);
				parameters.put("TDate", toDate);
												
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("EmployeeWiseTravelCost",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}
	public ModelAndView showEmployeeExpenseReport(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = etravelHandlerService.showEmployeeExpenseReport();
		String jsp = "hr_employeeExpenseDetail";
		jsp += ".jsp";
		map.put("contentJsp", jsp);
		return new ModelAndView("index", "map", map);
	}
	public ModelAndView exportToExcelEmployeeExpenseReport(HttpServletRequest request ,HttpServletResponse response) {
		Map parameters = new HashMap();
		int projectId = 0;
		int departmentId = 0;
		int employeeId = 0;
		Date fromDate = null;
		Date toDate = null;
		Map<String, Object> map = new HashMap();
		Map<String, Object> mapForDs = new HashMap();
		HttpSession session = request.getSession();

		int hospitalId = 0;
		if(session.getAttribute(HOSPITAL_ID) != null){
			hospitalId = (Integer)session.getAttribute(HOSPITAL_ID);
			mapForDs.put("hospitalId", hospitalId);
		}

		try {
			if (request.getParameter("projectId") != null) {
				projectId = Integer.parseInt(request.getParameter("projectId"));
			}
			
			if (!request.getParameter(DEPARTMENT_ID).equals("")  &&  request.getParameter(DEPARTMENT_ID) != null) {
				departmentId = Integer.parseInt(request.getParameter(DEPARTMENT_ID));
			}
			if (!request.getParameter(EMPLOYEE_ID).equals("")  && request.getParameter(EMPLOYEE_ID) != null) {
				employeeId = Integer.parseInt(request.getParameter(EMPLOYEE_ID));
			}
			if (request.getParameter(FROM_DATE) != null) {
				fromDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(FROM_DATE));
			}

			if (request.getParameter(TO_DATE) != null) {
				toDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter(TO_DATE));
			}
			List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
			String companyname = "";
			map = etravelHandlerService.getHospitalName(mapForDs);
			if(map.get("masHospitalList") != null){
				masHospitalList = (List)map.get("masHospitalList");
			}
			if(masHospitalList.size() > 0){
				companyname = masHospitalList.get(0).getHospitalName();
			}
			
		
			parameters.put("hospital_name", companyname);
			parameters.put("project_id", projectId);
			parameters.put("Department_id", departmentId);
			parameters.put("emp_id", employeeId);
			parameters.put("fromdate", fromDate);
			parameters.put("todate", toDate);

			Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
			HMSUtil.generateReport("Employee Expenses", parameters,(Connection) connectionMap.get("con"), response,
					getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public ModelAndView printTravelExpenses(HttpServletRequest request,HttpServletResponse response){
		
		byte[] bytes = null;
		ServletContext context = request.getSession().getServletContext();
		Map parameters = new HashMap();
		int travelRequestId   = 0;
	
		try
				{ 
					if(request.getParameter(TRAVEL_REQUEST_ID) !=null && !(request.getParameter(TRAVEL_REQUEST_ID).equals(""))){
						travelRequestId = Integer.parseInt(request.getParameter(TRAVEL_REQUEST_ID));
					}
								
				parameters.put("req_id", travelRequestId);
				
								
				Map<String, Object> connectionMap = etravelHandlerService.getConnectionForReport();
				HMSUtil.generateReport("etravelExpenses",parameters,(Connection)connectionMap.get("con"),response, getServletContext());
				}
				catch(Exception e)
				{
					e.printStackTrace(); 
				}
						return null;
		}
	
	
	
	
}
	