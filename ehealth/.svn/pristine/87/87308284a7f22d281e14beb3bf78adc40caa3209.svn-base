package jkt.hms.hes.controller;

import static jkt.hms.util.RequestConstants.HIN_NO;
import static jkt.hms.util.RequestConstants.HOSPITAL_ID;
import static jkt.hms.util.RequestConstants.DEPARTMENT_ID;
import static jkt.hms.util.RequestConstants.MESSAGE_FOR_BILLING_JSP;
import static jkt.hms.util.RequestConstants.FROM_DATE;
import static jkt.hms.util.RequestConstants.TO_DATE;
import static jkt.hms.util.RequestConstants.TO_STORE_ID;
import static jkt.hrms.util.HrmsRequestConstants.HR_ATTACH_DOCUMENT_POPUP_JSP;
import static jkt.hrms.util.HrmsRequestConstants.TICKET_ATTACH_ID;
import static jkt.hrms.util.HrmsRequestConstants.TRAVEL_REQUEST_ID;
import static jkt.hrms.util.HrmsRequestConstants.VIEW_BOOKING_DETAIL_POPUP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadException;
import jkt.hms.hes.handler.MaintenanceHandlerService;
import jkt.hms.masters.business.Department;
import jkt.hms.masters.business.HesEquipmentMaster;
import jkt.hms.masters.business.MasStoreItem;
import jkt.hms.masters.business.MmPreventiveCheckList;
import jkt.hms.masters.business.MmServiceRequest;
import jkt.hms.masters.business.StoreItemBatchStock;
import jkt.hms.masters.business.UserDepartment;
import jkt.hms.masters.business.Users;
import jkt.hms.masters.business.Visit;
import jkt.hms.util.Box;
import jkt.hms.util.HMSUtil;
import jkt.hms.util.RequestConstants;









//commented for maven
/*import org.exolab.jms.authentication.User;*/
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;




//commented for maven
/*import com.lowagie.text.pdf.codec.postscript.ParseException;*/
import com.oreilly.servlet.MultipartRequest;

public class MaintenanceController extends MultiActionController{
	Map<String, Object> map = new HashMap<String, Object>();
	MaintenanceHandlerService maintenanceHandlerService=null;
	HttpSession session = null;
	String jsp = "";
	String title = "";
	
	
	public MaintenanceHandlerService getMaintenanceHandlerService() {
		return maintenanceHandlerService;
	}


	public void setMaintenanceHandlerService(
			MaintenanceHandlerService maintenanceHandlerService) {
		this.maintenanceHandlerService = maintenanceHandlerService;
	}


	public ModelAndView showCreateServiceRequestJsp(HttpServletRequest request,
			HttpServletResponse response) {
		int hospitalId = 0;
		String flag="";
		session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}
		map = maintenanceHandlerService.getDepartment(hospitalId);
		if (request.getParameter("ItemType") != null && request.getParameter("ItemType") != "") {
			detail.put("itemType", request.getParameter("ItemType"));
		}
		if (request.getParameter("Section") != null && request.getParameter("Section") != "") {
			detail.put("section", request.getParameter("Section"));
		}
		if (request.getParameter("Category") != null && request.getParameter("Category") != "") {
			detail.put("category", request.getParameter("Category"));
		}
		if (request.getParameter("Class") != null && request.getParameter("Class") != "") {
			detail.put("class", request.getParameter("Class"));
		}
		int searchDepartmentId =0;
		if (request.getParameter("department") != null && request.getParameter("department") != "") {
			detail.put("department", request.getParameter("department"));
			searchDepartmentId = Integer.parseInt(request.getParameter("department"));
		}
		
		if (request.getParameter("requestId") != null && request.getParameter("requestId") != "") {
			detail.put("requestId", request.getParameter("requestId"));
		}
		map.putAll(maintenanceHandlerService.getEquipmentDetails(detail));
		jsp = "mCreateServiceRequest.jsp";
		title = "Create Service Request";
		map.put("eL", flag);
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("searchDepartmentId", searchDepartmentId);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListForApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		int hospitalId = 0;
		int user = 0;
		session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			user = (Integer)session.getAttribute("userId");
			details.put("user", user);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		map=maintenanceHandlerService.getPendingServiceRequest(details);
		jsp = "mPendingListForApproval.jsp";
		title = "Pending List For Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAllPendingListForApprovalJsp(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		int hospitalId = 0;
		int user = 0;
		session = request.getSession();
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			user = (Integer)session.getAttribute("userId");
			details.put("user", user);
		}
		
		map=maintenanceHandlerService.getAllPendingServiceRequest(details);
		jsp = "mPendingListForApproval.jsp";
		title = "Pending List For Approval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	

	public ModelAndView serviceRequest(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}if(request.getParameter("requestId") != null){
			detail.put("requestId", request.getParameter("requestId"));
		}
		map=maintenanceHandlerService.getRequestDetails(detail);
		jsp = "mServiceRequest.jsp";
		title = "Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListOfInspctionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		if(request.getParameter("RequestedFrom")!=null && request.getParameter("RequestedFrom")!=""){
			details.put("RequestedFrom", request.getParameter("RequestedFrom"));
		}
			map=maintenanceHandlerService.getPendingListOfInspection(details);
			jsp = "mPendingListOfInspection.jsp";
			title = "Pending List Of Inspection";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	public ModelAndView showAllPendingListOfInspctionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
			map=maintenanceHandlerService.showAllPendingListOfInspctionJsp(details);
			jsp = "mPendingListOfInspection.jsp";
			title = "Pending List Of Inspection";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
		
		public ModelAndView showRequestTrackerConfigJsp(HttpServletRequest request, HttpServletResponse response){
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> details = new HashMap<String, Object>();
			session = request.getSession();
			int hospitalId=0;
			if (session.getAttribute(HOSPITAL_ID) != null) {
				hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
				details.put("hospitalId", hospitalId);
			}
			map=maintenanceHandlerService.showRequestTrackerConfig(details);
				jsp = "mRequestTrackerConfig.jsp";
				title = "Pending List Of Inspection";
				map.put("contentJsp", jsp);
				map.put("title", title);
				return new ModelAndView("index", "map", map);
			}
		
		public ModelAndView addConfig(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> details = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int departmentId = 0;
			int hospitalId = 0;
			int userId=0;
			synchronized (session) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
				userId = (Integer) session.getAttribute("userId");
			}
			if (request.getParameter("department") != null) {
				departmentId = Integer.parseInt(request.getParameter("department"));
			}if (departmentId!=0) {
				details.put("departmentId", departmentId);
			}
			if (hospitalId != 0) {
				details.put("hospitalId", hospitalId);
			}
			if (userId != 0) {
				details.put("userId", userId);
			}
			if(request.getParameter("Resource")!=null){
				details.put("employeeId", Integer.parseInt(""+request.getParameter("Resource").trim()));
			}
			if(request.getParameter("FromDay")!=null && request.getParameter("FromDay")!=""){
				details.put("fromDay", Integer.parseInt(""+request.getParameter("FromDay").trim()));
			}
			if(request.getParameter("ToDay")!=null && request.getParameter("ToDay")!=""){
				details.put("toDay", Integer.parseInt(""+request.getParameter("ToDay").trim()));
			}
			if(request.getParameter("designationLabel")!=null){
				details.put("designationLabel", Integer.parseInt(""+request.getParameter("designationLabel")));
			}
			if(request.getParameter("lastChgDate")!=null){
				details.put("lastChgDate", request.getParameter("lastChgDate"));
			}
			if(request.getParameter("lastChgTime")!=null){
				details.put("lastChgTime", request.getParameter("lastChgTime"));
			}
			if(request.getParameter("configId")!=null && request.getParameter("configId")!=""){
				details.put("configId", Integer.parseInt(""+request.getParameter("configId")));
			}
			map = maintenanceHandlerService.addConfig(details);
			jsp = "mRequestTrackerConfig.jsp";
			title = "Pending List Of Inspection";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView showPendingServiceRequestJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
			details.put("empId", (Integer)session.getAttribute("empId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("itemCode")!=null && request.getParameter("itemCode")!=""){
			details.put("itemCode", request.getParameter("itemCode"));
		}
		if(request.getParameter("priority")!=null && request.getParameter("priority")!=""){
			details.put("priority", request.getParameter("priority"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("status")!=null && request.getParameter("status")!=""){
			details.put("status", request.getParameter("status"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getPendingServiceRequestList(details);
		jsp = "mPendingServiceRequest.jsp";
		title = "Pending Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
public ModelAndView submitAssignResorce(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("Resource")!=null && request.getParameter("Resource")!=""){
			details.put("Resource", request.getParameter("Resource"));
		}
		if(request.getParameter("department")!=null && request.getParameter("department")!=""){
			details.put("department", request.getParameter("department"));
		}
		if(request.getParameter("ResourceRemark")!=null && request.getParameter("ResourceRemark")!=null){
			details.put("ResourceRemark", request.getParameter("ResourceRemark"));
		}
		if(request.getParameter("priorityId")!=null && !"".equalsIgnoreCase(request.getParameter("priorityId"))){
			details.put("priorityId", request.getParameter("priorityId"));
		}
		map = maintenanceHandlerService.saveAssignResource(details);
		map.putAll(maintenanceHandlerService.getPendingListOfInspection(details));
		jsp = "mPendingListOfInspection.jsp";
		title = "Pending Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showAssignResourceJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detail = new HashMap<String, Object>();
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			detail.put("hospitalId", hospitalId);
		}
		if(request.getParameter("requestId")!=null){
			detail.put("requestId", request.getParameter("requestId"));
		}
			map=maintenanceHandlerService.getAssignResource(detail);
			jsp = "mAssignResource.jsp";
			title = "Assign Resource";
			map.put("contentJsp", jsp);
			map.put("title", title);
			return new ModelAndView("index", "map", map);
		}
	
	public ModelAndView showEquipmentHistory(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		int equipmentId=0;
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("eqId")!=null){
			details.put("eqId", Integer.parseInt(request.getParameter("eqId")));
			map=maintenanceHandlerService.getEquipmentHistory(details);
		}
		jsp = "mEquipmentHistory.jsp";
		title = "Equipment History";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showEquipmentDashBoard(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		int equipmentId=0;
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("eqId")!=null && request.getParameter("eqId")!=""){
			details.put("equipmentId", request.getParameter("eqId"));
			map=maintenanceHandlerService.getEquipmentHistory(details);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		map=maintenanceHandlerService.equipmentDashBoard(details);
		jsp = "mEquipmentDashBoard.jsp";
		title = "Equipment History";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
		
	public ModelAndView showInspectionReport(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		session=request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		map=maintenanceHandlerService.getInspectionDetails(details);
		jsp = "mInspectionReport.jsp";
		title = "Inspection Report";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPendingListForServiceCompletionJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("Priority")!=null && request.getParameter("Priority")!=""){
			details.put("Priority", request.getParameter("Priority"));
		}
		if(request.getParameter("WorkOrderNo")!=null && request.getParameter("WorkOrderNo")!=""){
			details.put("WorkOrderNo", request.getParameter("WorkOrderNo"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getPendingServiceServiceOrderList(details);
		
		jsp = "mPendingForServiceCompletion.jsp";
		title = "Pending For Service Completion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView serviceOrderCompletion(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", request.getParameter("requestId"));
		}
		map=maintenanceHandlerService.getServiceOrderDetails(details);
		jsp = "mServiceOrderCompletion.jsp";
		title = "Service Order Completion";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showTransferServiceRequestToAnotherEngineer(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("empId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("EquipmentNo")!=null && request.getParameter("EquipmentNo")!=""){
			details.put("EquipmentNo", request.getParameter("EquipmentNo"));
		}
		if(request.getParameter("Priority")!=null && request.getParameter("Priority")!=""){
			details.put("Priority", request.getParameter("Priority"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getTransferServiceRequestList(details);
		
		jsp = "mTransferServiceRequest.jsp";
		title = "Transfer Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPreventiveMaintenanceJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("ItemCode")!=null && request.getParameter("ItemCode")!=""){
			details.put("ItemCode", request.getParameter("ItemCode"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("ModelNo")!=null && request.getParameter("ModelNo")!=""){
			details.put("ModelNo", request.getParameter("ModelNo"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getPreventiveMaintenanceList(details);
		
		jsp = "mPreventiveMaintenance.jsp";
		title = "Preventive Maintenance";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showRequestTrackerJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
			details.put("empId", (Integer)session.getAttribute("empId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getRequestTrackerList(details);
		
		jsp = "mRequestTracker.jsp";
		title = "Request Tracker";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showInpectionDetail(HttpServletRequest request, HttpServletResponse response){
		jsp = "mInpectionDetails.jsp";
		title = "Inpection Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showRequestTrackerDetail(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt(request.getParameter("requestId")));
		}
		map=maintenanceHandlerService.getRequestTrackerDetail(details);
		jsp = "mRequestTrackerDetails.jsp";
		title = "Inpection Details";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showTransferService(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details=new HashMap<String, Object>();
		session = request.getSession();
		int hospitalId=0;
		if (session.getAttribute(HOSPITAL_ID) != null && session.getAttribute("userId")!=null) {
			hospitalId = Integer.parseInt("" + session.getAttribute(HOSPITAL_ID));
			details.put("hospitalId", hospitalId);
			details.put("user", (Integer)session.getAttribute("userId"));
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		map=maintenanceHandlerService.getTransferEquipmentDetails(details);
		jsp = "mTransferRequest.jsp";
		title = "Transfer Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPreventiveManitenance(HttpServletRequest request, HttpServletResponse response){
		jsp = "mCreateServiceRequest.jsp";
		title = "Create Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showPerformanceAnalysisJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("WorkOrderNo")!=null && request.getParameter("WorkOrderNo")!=""){
			details.put("requestId", request.getParameter("WorkOrderNo"));
		}
		map=maintenanceHandlerService.getPerformanceAnalysisList(details);
		jsp = "mPerformanceAnalysis.jsp";
		title = "Performance Analysis";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView showCondemnationJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map = maintenanceHandlerService.getCondemnationList(details);
		jsp = "mCondemnatione.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getEquipmentList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		List<HesEquipmentMaster> hesEquipmentMaster = new ArrayList<HesEquipmentMaster>();
		hesEquipmentMaster = maintenanceHandlerService.getEquipmentList(details);
		String jsp = "populateEquipmentList";
		map.put("equipmentList", hesEquipmentMaster);
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getEquipmentFile(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		if(request.getParameter("RequestId")!=null){
			details.put("request_id", Integer.parseInt((String)request.getParameter("RequestId")));
        }
		details.put("flag", "v");
		map = maintenanceHandlerService.addAttachFile(details);
		String jsp = "populateEquipmentFile";
//		map.put("equipmentList", hesEquipmentMaster);
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
	            //String uploadURL = getServletContext().getRealPath("/Attendance/");
	            String uploadURL = getServletContext().getRealPath("/");
	            System.out.println(mrequest.getParameter("requestId")+">>>1000>>"+uploadURL);
	            String filename = "";
	            List fileUploadedList = null;
	                if(mrequest.getParameter("fileName")!= null){
	                    filename = mrequest.getParameter("fileName");
	                }
//	            	if(mrequest.getParameter("upload_filename")!=null){
//	            		filename= (String)mrequest.getParameter("upload_filename");
//	            	}
	                if(mrequest.getParameter("RequestId")!=null){
	                	generalMap.put("request_id", Integer.parseInt((String)mrequest.getParameter("RequestId")));
	                }
	                generalMap.put("filename", filename);
	                StringTokenizer strToken=new StringTokenizer(filename,".");
	                Long fileSizeLimit = RequestConstants.MAX_FILE_SIZE;
	                filename=strToken.nextToken();
	                   fileExtension=strToken.nextToken();
	                   String whiteList = "*."+fileExtension;
	                  /*System.out.println("jk>>>>"+uploadURL);
	                   System.out.println("whiteList>>>>"+whiteList);
	                   System.out.println("filename>>>>"+filename);*/
	            
	                   //fileUploadedList = HMSUtil.uploadTicketFile(mrequest,uploadURL, whiteList,filename);
	                   fileUploadedList = HMSUtil.uploadFileMaintenance(mrequest,uploadURL, whiteList,fileSizeLimit,filename);
	                
	                String comments = "";
	                if( mrequest.getParameter("comments")!= null){
	                    comments = mrequest.getParameter("comments");
	                    generalMap.put("comments", comments);
	                }
	                generalMap.put("uploadURL", uploadURL);
	            map = maintenanceHandlerService.addAttachFile(generalMap);
	            String jsp = "populateEquipmentFile";
	            String msg="File Successfuly Uploaded.";
	            //jsp += ".jsp";
	            //map.put("contentJsp", jsp);
	            map.put("message", msg);
	            
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
	    	       File f = new File(uploadURL+""+filename+"."+fileExtension);
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
	    		
	    		//return new ModelAndView("index", "map", map);
	    		return null;
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
			System.out.println("======"+mrequest.getParameterValues("DocumentId"));
			if(mrequest.getParameterValues("DocumentId")!=null){
			for(int j=0;j<mrequest.getParameterValues("DocumentId").length;j++)
			{
				if (mrequest.getParameterValues("DocumentId")[j]!= null && !(mrequest.getParameterValues("DocumentId")[j]).equals("")) {
					ticketAttachIdList .add(Integer.parseInt((String)mrequest.getParameterValues("DocumentId")[j]));
				}
				
			}
			}
			generalMap.put("ticketAttachIdList", ticketAttachIdList);
			map = maintenanceHandlerService.deleteAttachFile(generalMap);
			String jsp = "populateEquipmentFile";
			//jsp += ".jsp";
			//map.put("contentJsp", jsp);
			
			return new ModelAndView(jsp, "map", map);
		}
	    
		public ModelAndView getSupplierList(HttpServletRequest request,
				HttpServletResponse response) {
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> details = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			int supplierTypeId = 0;
			int hospitalId = 0;
			synchronized (session) {
				hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			}
			if (request.getParameter("SupplierType") != null) {
				supplierTypeId = Integer.parseInt(request.getParameter("SupplierType"));
			}
			if (supplierTypeId!=0) {
				details.put("supplierTypeId", supplierTypeId);
			}
			if (hospitalId != 0) {
				details.put("hospitalId", hospitalId);
			}
			map = maintenanceHandlerService.getSupplierList(details);
			String jsp = "populateSpplierList";
			return new ModelAndView(jsp, "map", map);
		}
	
	public ModelAndView getEquipmentDetails(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		int equipmentId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (request.getParameter("equipment") != null) {
			equipmentId = Integer.parseInt(request.getParameter("equipment"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}if (equipmentId != 0) {
			details.put("equipmentId", equipmentId);
		}
		String jsp = "populateEquipmentDetail";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView submitCreateServiceRequest(HttpServletRequest request,
			HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int userId=0;
		int hospitalId=0;
		synchronized (session) {
			 userId = (Integer)session.getAttribute("userId");
			 hospitalId =  (Integer)session.getAttribute(HOSPITAL_ID);
		}
		if(request.getParameter("equipmentId")!=null && request.getParameter("equipmentId")!="")
		details.put("equipmentId", request.getParameter("equipmentId"));
		if(request.getParameter("warrantyStatus")!=null && request.getParameter("warrantyStatus")!="")
		details.put("warranty", request.getParameter("warrantyStatus"));
		if(request.getParameter("RequestType")!=null && request.getParameter("RequestType")!="")
		details.put("requestType", request.getParameter("RequestType"));
		if(request.getParameter("Priority")!=null && request.getParameter("Priority")!="")
		details.put("priority", request.getParameter("Priority"));
		if(request.getParameter("requiredDate")!=null && request.getParameter("requiredDate")!="")
		details.put("requiredDate", request.getParameter("requiredDate"));
		if(request.getParameter("description")!=null && request.getParameter("description")!="")
		details.put("description", request.getParameter("description"));
		if(userId!=0){details.put("userId", userId);}
		if(hospitalId!=0){details.put("hospitalId", hospitalId);}
		if(request.getParameter("lastChgDate")!=null && request.getParameter("lastChgDate")!=""){
			details.put("lastChgDate", request.getParameter("lastChgDate"));
		}
		if(request.getParameter("lastChgTime")!=null && request.getParameter("lastChgTime")!=""){
			details.put("lastChgTime", request.getParameter("lastChgTime"));
			}
		if(request.getParameter("amcId")!=null && request.getParameter("amcId")!=""){
			details.put("amcId", request.getParameter("amcId"));
			}
		if(request.getParameter("sms")!=null && request.getParameter("sms")!=""){
			details.put("sms", request.getParameter("sms"));
			}
		if(request.getParameter("mail")!=null && request.getParameter("mail")!=""){
			details.put("mail", request.getParameter("mail"));
			}
		if(request.getParameter("serviceRequestId")!=null && request.getParameter("serviceRequestId")!=null && !request.getParameter("serviceRequestId").equalsIgnoreCase("null")){
			details.put("serviceRequestId", request.getParameter("serviceRequestId"));
		}
		map=maintenanceHandlerService.saveServiceDetails(details);
		map.putAll(maintenanceHandlerService.getEquipmentDetails(details));
		map.putAll(maintenanceHandlerService.getDepartment(hospitalId));
		jsp = "mCreateServiceRequest.jsp";
		title="Service Request";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView submitServiceRequest(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			details.put("hospitalId", hospitalId);
			details.put("approvedBy", session.getAttribute("userId"));
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("forwardTo")!=null){
			details.put("forwardTo", request.getParameter("forwardTo"));
		}
		if(request.getParameter("Remark")!=null){
			details.put("Remark", request.getParameter("Remark"));
		}
		if(request.getParameter("Status")!=null){
			details.put("status", request.getParameter("Status"));
		}
		map=maintenanceHandlerService.saveServiceRequest(details);
		details.remove("requestId");
		map.putAll(maintenanceHandlerService.getPendingServiceRequest(details));
		map.putAll(maintenanceHandlerService.getDepartment(hospitalId));
		jsp = "mPendingListForApproval.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
	public ModelAndView getResourceList(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		map = maintenanceHandlerService.getResourceList(details);
		String jsp = "populateResourceList";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getResourceListForConfig(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
		if (request.getParameter("department") != null) {
			departmentId = Integer.parseInt(request.getParameter("department"));
		}if (departmentId!=0) {
			details.put("departmentId", departmentId);
		}
		if (hospitalId != 0) {
			details.put("hospitalId", hospitalId);
		}
		map = maintenanceHandlerService.getResourceListForConfig(details);
		String jsp = "populateResourceList";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView getItemListAutoComplet(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		String query = request.getParameter("ItemName");
		int departmentId = 0;
		int hospitalId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
		}
//		if (request.getParameter("department") != null) {
//			departmentId = Integer.parseInt(request.getParameter("department"));
//		}
//		if (departmentId!=0) {
//			details.put("departmentId", departmentId);
//		}
//		
//		if (hospitalId != 0) {
//			details.put("hospitalId", hospitalId);
//		}
		if(request.getParameter("type")!=null && request.getParameter("type")!=""){
			details.put("type", request.getParameter("type"));
		}
		details.put("query", query);
		map = maintenanceHandlerService.getItemListForAutoComplet(details);
		String jsp = "itemDetail";
		return new ModelAndView(jsp, "map", map);
	}
	
	public ModelAndView submitInspectionReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		List<Integer> mmCheckLists=new ArrayList<Integer>();
		List<Integer> allCheckLists=new ArrayList<Integer>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
			details.put("user", userId);
		}
		if(request.getParameter("CloseType")!=null && request.getParameter("CloseType")!=""){
			details.put("CloseType", request.getParameter("CloseType"));
		}
		if(request.getParameter("WorkOrderType")!=null && request.getParameter("WorkOrderType")!=""){
			details.put("WorkOrderType", request.getParameter("WorkOrderType"));
		}
		if(request.getParameter("ResourceRequirment")!=null && request.getParameter("ResourceRequirment")!=""){
			details.put("ResourceRequirment", request.getParameter("ResourceRequirment"));
		}
		if(request.getParameter("DescriptionOfWork")!=null && request.getParameter("DescriptionOfWork")!=""){
			details.put("DescriptionOfWork", request.getParameter("DescriptionOfWork"));
		}
		if(request.getParameter("obDate")!=null && request.getParameter("obDate")!=""){
			details.put("obDate", request.getParameter("obDate"));
		}
		if(request.getParameter("ObservationTime")!=null && request.getParameter("ObservationTime")!=""){
			details.put("ObservationTime", request.getParameter("ObservationTime"));
		}
		if(request.getParameter("ObservationRemark")!=null && request.getParameter("ObservationRemark")!=""){
			details.put("ObservationRemark", request.getParameter("ObservationRemark"));
		}
		if(request.getParameter("ServiceCost")!=null && request.getParameter("ServiceCost")!=""){
			details.put("ServiceCost", request.getParameter("ServiceCost"));
		}
		if(request.getParameter("MeterialCost")!=null && request.getParameter("MeterialCost")!=""){
			details.put("MeterialCost", request.getParameter("MeterialCost"));
		}
		/*if(request.getParameter("TotalDuration")!=null && request.getParameter("TotalDuration")!=""){
			details.put("TotalDuration", request.getParameter("TotalDuration"));
		}*/
		if(request.getParameter("PlannedCost")!=null && request.getParameter("PlannedCost")!=""){
			details.put("PlannedCost", request.getParameter("PlannedCost"));
		}
		if(request.getParameter("CostCenter")!=null && request.getParameter("CostCenter")!=""){
			details.put("CostCenter", request.getParameter("CostCenter"));
		}
		if(request.getParameter("AccountCode")!=null && request.getParameter("AccountCode")!=""){
			details.put("AccountCode", request.getParameter("AccountCode"));
		}
		if(request.getParameter("SupplierType")!=null && request.getParameter("SupplierType")!=""){
			details.put("SupplierType", request.getParameter("SupplierType"));
		}
		if(request.getParameter("SupplierName")!=null && request.getParameter("SupplierName")!=""){
			details.put("SupplierName", request.getParameter("SupplierName"));
		}
		if(request.getParameter("WorkOrderRemark")!=null && request.getParameter("WorkOrderRemark")!=""){
			details.put("WorkOrderRemark", request.getParameter("WorkOrderRemark"));
		}
		if(request.getParameter("type")!=null && request.getParameter("type")!=""){
			details.put("type", request.getParameter("type"));
		}
		if(request.getParameter("ServiceRequestId")!=null && request.getParameter("ServiceRequestId")!=""){
			details.put("ServiceRequestId", request.getParameter("ServiceRequestId"));
		}
		if(request.getParameter("equipmentId")!=null && request.getParameter("equipmentId")!=""){
			details.put("equipmentId", request.getParameter("equipmentId"));
		}
		if(request.getParameter("ActionType")!=null && request.getParameter("ActionType")!=""){
			details.put("ActionType", request.getParameter("ActionType"));
		}
		if(request.getParameter("WorkOrderRemark")!=null && request.getParameter("WorkOrderRemark")!=""){
			details.put("WorkOrderRemark", request.getParameter("WorkOrderRemark"));
		}
		if(request.getParameter("ObservationRemark")!=null && request.getParameter("ObservationRemark")!=""){
			details.put("ObservationRemark", request.getParameter("ObservationRemark"));
		}
		if(request.getParameter("PreventiveDoneOn")!=null && request.getParameter("PreventiveDoneOn")!=""){
			details.put("PreventiveDoneOn", request.getParameter("PreventiveDoneOn"));
		}
		if(request.getParameter("ScheduledDate")!=null && request.getParameter("ScheduledDate")!=""){
			details.put("ScheduledDate", request.getParameter("ScheduledDate"));
		}
		if(request.getParameter("ScheduledTime")!=null && request.getParameter("ScheduledTime")!=""){
			details.put("ScheduledTime", request.getParameter("ScheduledTime"));
		}
		if(request.getParameter("ContactPerson")!=null && request.getParameter("ContactPerson")!=""){
			details.put("ContactPerson", request.getParameter("ContactPerson"));
		}
		if(request.getParameter("OnHoldReason")!=null && request.getParameter("OnHoldReason")!=""){
			details.put("OnHoldReason", request.getParameter("OnHoldReason"));
		}
		if(request.getParameter("lastChgDate")!=null && request.getParameter("lastChgDate")!=""){
			details.put("lastChgDate", request.getParameter("lastChgDate"));
		}
		if(request.getParameter("lastChgTime")!=null && request.getParameter("lastChgTime")!=""){
			details.put("lastChgTime", request.getParameter("lastChgTime"));
		}
		
		if(request.getParameter("ItemId")!=null && request.getParameter("ItemId")!=""){
			details.put("ItemId", request.getParameterValues("ItemId"));
		}
		if(request.getParameter("RequiredQty")!=null && request.getParameter("RequiredQty")!=""){
			details.put("RequiredQty", request.getParameterValues("RequiredQty"));
		}
		if(request.getParameter("specification")!=null && request.getParameter("specification")!=""){
			details.put("specification", request.getParameterValues("specification"));
		}
		if(request.getParameterValues("checkList")!=null){
			for(int i=0;i<request.getParameterValues("checkList").length;i++){
				mmCheckLists.add(Integer.parseInt((String)request.getParameterValues("checkList")[i]));
			}
			details.put("mmCheckLists", mmCheckLists);
		}
		if(request.getParameterValues("AllCheckList")!=null){
			for(int i=0;i<request.getParameterValues("AllCheckList").length;i++){
				allCheckLists.add(Integer.parseInt((String)request.getParameterValues("AllCheckList")[i]));
			}
			details.put("AllCheckList", allCheckLists);
		}
		if(request.getParameter("ImergencyIndent")!=null && request.getParameter("ImergencyIndent")!=""){
			details.put("ImergencyIndent", request.getParameter("ImergencyIndent"));
		}
		if(request.getParameter("WORequiredDate")!=null && request.getParameter("WORequiredDate")!=""){
			details.put("WORequiredDate", request.getParameter("WORequiredDate"));
		}
		if(request.getParameter("PlannedEndDate")!=null && request.getParameter("PlannedEndDate")!=""){
			details.put("PlannedEndDate", request.getParameter("PlannedEndDate"));
		}
		if(request.getParameter("PlannedStartDate")!=null && request.getParameter("PlannedStartDate")!=""){
			details.put("PlannedStartDate", request.getParameter("PlannedStartDate"));
		}
		if(request.getParameter("Account")!=null && request.getParameter("Account")!=""){
			details.put("Account", request.getParameter("Account"));
		}
		map=maintenanceHandlerService.submitInspectionReport(details);
		map.putAll(maintenanceHandlerService.getPendingServiceRequestList(details));
		jsp = "mPendingServiceRequest.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
	
    public void getItemDetail(HttpServletRequest request,HttpServletResponse response) {
        
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
        List<MasStoreItem> emplList = new ArrayList<MasStoreItem>();
        MasStoreItem masStoreItem=new MasStoreItem();
        StoreItemBatchStock storeItemBatchStock=new StoreItemBatchStock();
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        if (request.getParameter("requestId") != null && request.getParameter("requestId")!="") {
            details.put("requestId", request.getParameter("requestId"));
            map = maintenanceHandlerService.getItemDetail(details);
        }
        	
        	masStoreItem = (MasStoreItem)map.get("masStoreItem");
        	StringBuffer sb = new StringBuffer();
        	if(map.get("storeItemBatchStock")!=null){
        	storeItemBatchStock = (StoreItemBatchStock)map.get("storeItemBatchStock");
        try {
            if(masStoreItem!=null){
            sb.append("<item>");
            if(masStoreItem.getId() != null)
            {
            sb.append("<itemId>" + masStoreItem.getId() + "</itemId>");
            }else{
                sb.append("<itemId>"+ "</itemId>");
            }
            sb.append("<itemCode>" + masStoreItem.getPvmsNo() + "</itemCode>");
            sb.append("<itemAvl>" + storeItemBatchStock.getClosingStock() + "</itemAvl>");
            sb.append("<itemRate>" + masStoreItem.getCostPrice() + "</itemRate>");
            sb.append("</item>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        	}else{
        		if(masStoreItem!=null){
                    sb.append("<item>");
                    if(masStoreItem.getId() != null)
                    {
                    sb.append("<itemId>" + masStoreItem.getId() + "</itemId>");
                    }else{
                        sb.append("<itemId>"+ "</itemId>");
                    }
                    sb.append("<itemCode>" + masStoreItem.getPvmsNo() + "</itemCode>");
                    sb.append("<itemAvl>" + 0 + "</itemAvl>");
                    sb.append("<itemRate>" + masStoreItem.getCostPrice() + "</itemRate>");
                    sb.append("</item>");
                    }
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
    
    public ModelAndView submitServiceOrderCompletion(HttpServletRequest request,HttpServletResponse response ){
    	Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("WorkedOn")!=null && request.getParameter("WorkedOn")!=""){
			details.put("WorkedOn", request.getParameter("WorkedOn"));
		}
		if(request.getParameter("WOChallanNo")!=null && request.getParameter("WOChallanNo")!=""){
			details.put("WOChallanNo", request.getParameter("WOChallanNo"));
		}
		if(request.getParameter("ChallanDate")!=null && request.getParameter("ChallanDate")!=""){
			details.put("ChallanDate", request.getParameter("ChallanDate"));
		}
		if(request.getParameter("WOChallanAmount")!=null && request.getParameter("WOChallanAmount")!=""){
			details.put("WOChallanAmount", request.getParameter("WOChallanAmount"));
		}
		if(request.getParameter("ServiceReportDate")!=null && request.getParameter("ServiceReportDate")!=""){
			details.put("ServiceReportDate", request.getParameter("ServiceReportDate"));
		}
		if(request.getParameter("ServiceReportNo")!=null && request.getParameter("ServiceReportNo")!=""){
			details.put("ServiceReportNo", request.getParameter("ServiceReportNo"));
		}
		if(request.getParameter("WORemark")!=null && request.getParameter("WORemark")!=""){
			details.put("WORemark", request.getParameter("WORemark"));
		}
		if(request.getParameter("closeDate")!=null && request.getParameter("closeDate")!=""){
			details.put("closeDate", request.getParameter("closeDate"));
		}
		if(request.getParameter("WorkOrderStatus")!=null && request.getParameter("WorkOrderStatus")!=""){
			details.put("WorkOrderStatus", request.getParameter("WorkOrderStatus"));
		}
		if(request.getParameterValues("ItemRemark")!=null){
			details.put("ItemRemark", request.getParameterValues("ItemRemark"));
		}
		if(request.getParameterValues("SerialNo")!=null){
			details.put("SerialNo", request.getParameterValues("SerialNo"));
		}
		if(request.getParameterValues("ModelNo")!=null){
			details.put("ModelNo", request.getParameterValues("ModelNo"));
		}
		if(request.getParameterValues("SafetyProcedureMaterialId")!=null ){
			details.put("SafetyProcedureMaterialId", request.getParameterValues("SafetyProcedureMaterialId"));
		}
		if(request.getParameter("InspectionReportId")!=null && request.getParameter("InspectionReportId")!=""){
			details.put("InspectionReportId", request.getParameter("InspectionReportId"));
		}
		if(request.getParameter("ServiceRequestId")!=null && request.getParameter("ServiceRequestId")!=""){
			details.put("ServiceRequestId", request.getParameter("ServiceRequestId"));
		}
		if(request.getParameter("lastChgDate")!=null && request.getParameter("lastChgDate")!=""){
			details.put("lastChgDate", request.getParameter("lastChgDate"));
		}
		if(request.getParameter("lastChgTime")!=null && request.getParameter("lastChgTime")!=""){
			details.put("lastChgTime", request.getParameter("lastChgTime"));
		}
		
		map = maintenanceHandlerService.submitServiceOrderCompletion(details);
		map.putAll(maintenanceHandlerService.getPendingServiceServiceOrderList(details));
		
		jsp = "mPendingForServiceCompletion.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView submitTransferServiceRequst(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
			details.put("user", userId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("TransferDetails")!=null){
			details.put("TransferDetails", request.getParameter("TransferDetails"));
		}
    	map = maintenanceHandlerService.submitTransferServiceRequst(details);
    	map.putAll(maintenanceHandlerService.getTransferServiceRequestList(details));
		jsp = "mTransferServiceRequest.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showRejectedRequestJsp(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("WorkOrderNo")!=null && request.getParameter("WorkOrderNo")!=""){
			details.put("WorkOrderNo", request.getParameter("WorkOrderNo"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getRejectedRquest(details);
    	jsp = "mRejectedServiceRequest.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView cancelRequest(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		map=maintenanceHandlerService.getCancelRquest(details);
		map.putAll(maintenanceHandlerService.getRejectedRquest(details));
    	jsp = "mRejectedServiceRequest.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showCreateServiceRequestDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("serviceRequestId")!=null){
			details.put("serviceRequestId", request.getParameter("serviceRequestId"));
		}
		map=maintenanceHandlerService.getEquipmentDetails(details);
    	jsp = "mCreateServiceRequestDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showServiceRequestFeedBack(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("empId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("WorkOrderNo")!=null && request.getParameter("WorkOrderNo")!=""){
			details.put("WorkOrderNo", request.getParameter("WorkOrderNo"));
		}
		if(request.getParameter("requestId")!=null){
			details.put("requestId", request.getParameter("requestId"));
		}
		if(request.getParameter("flag")!=null){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getFeedBack(details);
    	jsp = "mServiceRequestFeedBack.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showRequestFeedBack(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0){
			details.put("userId", userId);
		}
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		map=maintenanceHandlerService.showFeedBackDetails(details);
    	jsp = "mFeedBackDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView submitFeedBack(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		if(request.getParameter("FeedBackSatisfaction")!=null && request.getParameter("FeedBackSatisfaction")!=""){
			details.put("FeedBackSatisfaction", request.getParameter("FeedBackSatisfaction"));
		}
		if(request.getParameter("FeedBackCloser")!=null && request.getParameter("FeedBackCloser")!=""){
			details.put("FeedBackCloser", request.getParameter("FeedBackCloser"));
		}
		if(request.getParameter("FeedBackRemark")!=null && request.getParameter("FeedBackRemark")!=""){
			details.put("FeedBackRemark", request.getParameter("FeedBackRemark"));
		}
		map=maintenanceHandlerService.submitFeedBack(details);
		map.putAll(maintenanceHandlerService.showFeedBackDetails(details));
    	jsp = "mServiceRequestFeedBack.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showFeedBack(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("WorkOrderNo")!=null && request.getParameter("WorkOrderNo")!=""){
			details.put("WorkOrderNo", request.getParameter("WorkOrderNo"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getFeedBackList(details);
		jsp = "mViewFeedBack.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showCondemnationApproval(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		map=maintenanceHandlerService.getCondemnationApprovalList(details);
		jsp = "mCondemnationApproval.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView approvedCondemnation(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		map=maintenanceHandlerService.approvedCondemnation(details);
		jsp = "mCondemnationApprovalDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    // Added By Amit Das on 30-03-2016
    public ModelAndView showDepartmentApproval(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int departmentId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
			departmentId = (Integer) session.getAttribute("deptId");
		}
		
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		
		if(departmentId>0){
			details.put("departmentId", departmentId);
		}		
		
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			details.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			details.put("toDate", request.getParameter("toDate"));
		}
		if(request.getParameter("RequestNo")!=null && request.getParameter("RequestNo")!=""){
			details.put("RequestNo", request.getParameter("RequestNo"));
		}
		if(request.getParameter("ItemName")!=null && request.getParameter("ItemName")!=""){
			details.put("ItemName", request.getParameter("ItemName"));
		}
		if(request.getParameter("flag")!=null && request.getParameter("flag")!=""){
			details.put("flag", request.getParameter("flag"));
		}
		
		map=maintenanceHandlerService.getCondemnationApprovalList(details);
		jsp = "departmentCondemnationApproval.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    // Added By Amit Das on 30-03-2016
    public ModelAndView approveCondemnationFromDepartment(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		int departmentId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
			departmentId = (Integer) session.getAttribute("deptId");
		}
		
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		
		if(departmentId>0){
			details.put("departmentId", departmentId);
		}		
		
		Box box = HMSUtil.getBox(request);
		
		if(hospitalId>0){
			box.put("hospitalId", hospitalId);
		}
		if(userId>0)
			box.put("userId", userId);
		
		map=maintenanceHandlerService.approveCondemnationFromDepartment(box);
		jsp = "departmentCondemnationApproval.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    // added by Amit Das on 31-03-2016
    public ModelAndView showCommitteCondemnationJsp(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map=new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		
		int hospitalId = 0;
		//int userId= 0;
		int empId = 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			//userId = (Integer) session.getAttribute("userId");
			empId = (Integer) session.getAttribute("empId");
		}
		Box box = HMSUtil.getBox(request);
		
		if(hospitalId>0){
			box.put("hospitalId", hospitalId);
		}
		/*if(userId>0)
			box.put("userId", userId);*/

		if(empId>0)
			box.put("empId", empId);
		
		if(request.getParameter("fromDate")!=null && request.getParameter("fromDate")!=""){
			box.put("fromDate", request.getParameter("fromDate"));
		}
		if(request.getParameter("toDate")!=null && request.getParameter("toDate")!=""){
			box.put("toDate", request.getParameter("toDate"));
		}
		
		map = maintenanceHandlerService.showCommiteeApproval(box);
		jsp = "committeCondemnatione.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
    
    // Added by Amit Das on 31-03-2016
    public ModelAndView approveCondemnationFromCommitte(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		boolean flag = false;
		String kfcFormNo = null;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		
		Box box = HMSUtil.getBox(request);
		
		if(hospitalId>0){
			box.put("hospitalId", hospitalId);
		}
		if(userId>0)
			box.put("userId", userId);
		
		kfcFormNo = box.get("kfcFormNo");
		
		
		flag=maintenanceHandlerService.approveCondemnationFromCommitte(box);
		String message = "";
		String printUrl = "";
		if (flag == true) {
			printUrl = "submitForm('messageBilling','billing?method=printCondomnationByCommitee&kfcFormNo="
					+ kfcFormNo + "')";
			map.put("printUrl", printUrl);
			message = "Record saved successfully! Do you want to print?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
	//	map=maintenanceHandlerService.submitCondemnationApproved(details);
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("kfcFormNo", kfcFormNo);
		map.put("contentJsp", jsp);
		//map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    // added by Amit Das on 31-03-2016
    public ModelAndView displayEquipmentDetailForCommitee(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int empId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		
		if (session.getAttribute("empId") != null) {
			empId = Integer.parseInt(""+ session.getAttribute("empId"));
		}
		String kfcFormNo = "";
		
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			 box.put("kfcFormNo", kfcFormNo);
		}
		box.put("hospitalId", hospitalId);
		box.put("empId", empId);
		map = maintenanceHandlerService.displayEquipmentDetailForCommitee(box);
    	String jsp = "committeCondemnatione.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("kfcFormNo", kfcFormNo);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView condemnDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		map=maintenanceHandlerService.approvedCondemnation(details);
		jsp = "mCondemnationDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView submitCondemnationApproved(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		int requestId=0;
		boolean flag = false;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		requestId=Integer.parseInt((String)request.getParameter("requestId"));
		System.out.println("requestId"+requestId);
		if(request.getParameter("CondemnationStatus")!=null && request.getParameter("CondemnationStatus")!=""){
			details.put("CondemnationStatus", (String)request.getParameter("CondemnationStatus"));
		}
		if(request.getParameter("CondemnationRemark")!=null && request.getParameter("CondemnationRemark")!=""){
			details.put("CondemnationRemark", (String)request.getParameter("CondemnationRemark"));
		}
		if(request.getParameter("ReplacementValue")!=null && request.getParameter("ReplacementValue")!=""){
			details.put("ReplacementValue", (String)request.getParameter("ReplacementValue"));
		}
		flag=maintenanceHandlerService.submitCondemnationApproved(details);
		String message = "";
		String printUrl = "";
		if (flag == true) {
			printUrl = "submitForm('messageBilling','billing?method=printCondomnation&requestId="
					+ requestId + "')";
			map.put("printUrl", printUrl);
			message = "Record saved successfully! Do you want to print?";
		} else {
			message = "Try Again!";
		}
		map.put("message", message);
	//	map=maintenanceHandlerService.submitCondemnationApproved(details);
		map.put("message", message);
		String jsp = MESSAGE_FOR_BILLING_JSP + ".jsp";
		map.put("requestId", requestId);
		map.put("contentJsp", jsp);
		//map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView submitCondemnation(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		if(request.getParameter("CondemnationRemark")!=null && request.getParameter("CondemnationRemark")!=""){
			details.put("CondemnationRemark", (String)request.getParameter("CondemnationRemark"));
		}
		map=maintenanceHandlerService.submitCondemnation(details);
		map.putAll(maintenanceHandlerService.getCondemnationList(details));
		jsp = "mCondemnatione.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView showPerformanceDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if(hospitalId>0){
			details.put("hospitalId", hospitalId);
		}
		if(userId>0)
			details.put("userId", userId);
		if(request.getParameter("requestId")!=null && request.getParameter("requestId")!=""){
			details.put("requestId", Integer.parseInt((String)request.getParameter("requestId")));
		}
		jsp = "mPerformanceDetails.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    public ModelAndView getVendorAddress(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int vendorId = 0;
	
		if (request.getParameter("SupplierName") != null) {
			vendorId = Integer.parseInt(request.getParameter("SupplierName"));
		}
		if (vendorId!=0) {
			details.put("vendorId", vendorId);
		}
		
		map = maintenanceHandlerService.getVendorAddress(details);
		String jsp = "populateVendorAddress";
		return new ModelAndView(jsp, "map", map);
	}
    
    public ModelAndView showInstituteHeadApproval(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		map = maintenanceHandlerService.showInstituteHeadApproval(box);
		String jsp = "instituteHeadApprovalForCondemnation.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView displayEquipmentDetail(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		String kfcFormNo = "";
		System.out.println("kfcFormNo=="+request.getParameter("kfcFormNo"));
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			box.put("kfcFormNo", kfcFormNo);
		}
		box.put("hospitalId", hospitalId);
		map = maintenanceHandlerService.displayEquipmentDetail(box);
    	String jsp = "instituteHeadApprovalForCondemnation.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("kfcFormNo", kfcFormNo);
		return new ModelAndView("index", "map", map);
    }
    
    
    public ModelAndView displayInstitueEmployee(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		
		map = maintenanceHandlerService.displayInstitueEmployee(box);
    	String jsp = "responseForEmployeeListForComittee";
		//map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
    }
    
    
    public ModelAndView displayInstitutes(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		
		map = maintenanceHandlerService.displayInstitues(box);
    	String jsp = "responseForInstituteListForComittee";
		//map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView(jsp, "map", map);
    }
    
    
    public ModelAndView submitInstituteHeadApproval(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	Map<String, Object> generalMap = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		boolean flag = false;
		String message = "";
		int hospitalId = 0;
		String url ="";
		int deptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		if(request.getParameterValues("condemnationComiteeId") != null){
		String[] condemnationComitee = request.getParameterValues("condemnationComiteeId");
		List condemnationComiteeIdList = new ArrayList();
		if (condemnationComitee != null) {
			for (int j = 0; j < condemnationComitee.length; j++) {
				String condemnationComiteeId =(condemnationComitee[j]);
				condemnationComiteeIdList.add(condemnationComiteeId);
				generalMap.put("condemnationComiteeIdList", condemnationComiteeIdList);
			}
			}
		}
		
		map =maintenanceHandlerService.submitInstituteHeadApproval(box,generalMap);
		if(map.get("flag") != null){
			flag = (Boolean)map.get("flag");
		}
		if (flag) {
			message = "Head Approved successfully ";
		} else {
			message = "Head Approved not done successfully";
		}
		jsp = "mmMessage";
		jsp += ".jsp";
		url = "/hms/hms/maintenance?method=showInstituteHeadApproval";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("url", url);
		map.put("message", message);
		return new ModelAndView("index", "map", map);
    }
    public ModelAndView showAuctionPendingList(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		box.put("deptId", deptId);
		map = maintenanceHandlerService.showAuctionApprovalJsp(box);
		jsp = "auctionList";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
    public ModelAndView displayAuctionDetail(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		String kfcFormNo = "";
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			box.put("kfcFormNo", kfcFormNo);
		}
		box.put("hospitalId", hospitalId);
		map = maintenanceHandlerService.displayAuctionDetail(box);
    	String jsp = "auctionList.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("kfcFormNo", kfcFormNo);
		return new ModelAndView("index", "map", map);
    }
    public ModelAndView addPartyDetail(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
    	Box box = HMSUtil.getBox(request);
    	int hospitalId = 0;
    	session = request.getSession();

    	if (session.getAttribute("hospitalId") != null) {
    		hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
    				.toString());
    	}
    	box.put("hospitalId", hospitalId);
    	int requestId = 0;
    	String formNo = "";
    	if(request.getParameter("requestId") != null){
    		requestId = Integer.parseInt(request.getParameter("requestId"));
    	}
    	if(request.getParameter("formNo") != null){
    		formNo =request.getParameter("formNo");
    	}
    	map = maintenanceHandlerService.addPartyDetail(box);
    	jsp = "partyDetailForAuction";
    	// jsp = jsp + ".jsp";
    	// title = "GRN";
    	map.put("contentJsp", jsp);
    	map.put("requestId", requestId);
    	map.put("formNo", formNo);
    	map.put("highestAmountDiv", request.getParameter("highestAmountDiv"));
    	map.put("highestBidderDiv", request.getParameter("highestBidderDiv"));
    	return new ModelAndView(jsp, "map", map);
    }
    public ModelAndView savePartyAuctionDetail(HttpServletRequest request, HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
    	Box box = HMSUtil.getBox(request);
    	int hospitalId = 0;
    	session = request.getSession();
    	boolean flag = false;
    	String message = "";

    	if (session.getAttribute("hospitalId") != null) {
    		hospitalId = Integer.parseInt(session.getAttribute("hospitalId")
    				.toString());
    	}
    	box.put("hospitalId", hospitalId);
    	int requestId = 0;
    	String formNo = "";
    	if(request.getParameter("requestId") != null){
    		requestId = Integer.parseInt(request.getParameter("requestId"));
    	}
    	if(request.getParameter("formNo") != null){
    		formNo =request.getParameter("formNo");
    	}
    	
    	map = maintenanceHandlerService.savePartyAuctionDetail(box);
    	if(map.get("flag") != null){
			flag = (Boolean)map.get("flag");
		}
		if (flag) {
			message = "Date Save successfully ";
		} else {
			message = "Some Problem Occured";
		}
    	jsp = "partyDetailForAuction";
    	// jsp = jsp + ".jsp";
    	// title = "GRN";
    	map.put("contentJsp", jsp);
    	map.put("message", message);
    	map.put("requestId", requestId);
    	map.put("formNo", formNo);
    	map.put("highestAmountDiv", request.getParameter("highestAmountDiv"));
    	return new ModelAndView(jsp, "map", map);
    }
	
    // added by Amit Das on 31-03-2016
    public ModelAndView getMaxAmountBid(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		
		
		map = maintenanceHandlerService.getMaxAmountBid(box);
		jsp = "responseForMaxbid";
		jsp = jsp + ".jsp";
		title = "Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
    
    public ModelAndView showCondemnationItemReport(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		jsp = "condemnationItemReport";
		jsp += ".jsp";

		map.put("contentJsp", jsp);
		map.put("title", title);

		return new ModelAndView("index", "map", map);
	} 
    
    public ModelAndView generateCondemnationItem(HttpServletRequest request,
			HttpServletResponse response) {

		Map<String, Object> requestParameters = new HashMap<String, Object>();
		Date fromDate = null;
		Date toDate = null;
		int hospitalId = 0;

		HttpSession session = request.getSession();
		requestParameters.put("DEPART", session.getAttribute("deptId"));
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
			if (session.getAttribute("hospitalId") != null) {
				hospitalId = (Integer) session.getAttribute("hospitalId");
				requestParameters.put("hospitalId", hospitalId);
			}
	

		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> connectionMap = maintenanceHandlerService.getConnectionForReport();
		HMSUtil.generateReport("condemnationItem", requestParameters,
				(Connection) connectionMap.get("con"), response,
				getServletContext());
		return null;
    } 
    
    
    // Added by Amit Das on 31-03-2016
    public ModelAndView submitAuctionDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		int deptId = 0;
		boolean flag = false;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		
		Box box = HMSUtil.getBox(request);
		String kfcFormNo = "";
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			box.put("kfcFormNo", kfcFormNo);
		}
		if(hospitalId>0){
			box.put("hospitalId", hospitalId);
		}
		if(userId>0)
			box.put("userId", userId);
		
		if(deptId>0)
			box.put("deptId", deptId);
		
		
		map=maintenanceHandlerService.submitAuctionDetails(box);
    	
		jsp = "auctionList.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    // Added by Amit Das on 31-03-2016
    public ModelAndView showReauctionPendingList(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
		Box box = HMSUtil.getBox(request);
		int hospitalId = 0;
		int deptId = 0;
		session = request.getSession();
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		box.put("hospitalId", hospitalId);
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		box.put("deptId", deptId);
		map = maintenanceHandlerService.showAuctionApprovalJsp(box);
		jsp = "reauctionList";
		jsp = jsp + ".jsp";
		title = "Pending list for Auction";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
	}
    
    // added by Amit Das on 01-04-2016
    public ModelAndView displayReauctionDetail(HttpServletRequest request,HttpServletResponse response) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	HttpSession session = null;
		Box box = HMSUtil.getBox(request);
		session = request.getSession();
		int hospitalId = 0;
		int deptId = 0;
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = Integer.parseInt(""+ session.getAttribute("hospitalId"));
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		box.put("hospitalId", hospitalId);
		box.put("deptId", deptId);
		String kfcFormNo = "";
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			box.put("kfcFormNo", kfcFormNo);
		}
		box.put("hospitalId", hospitalId);
		map = maintenanceHandlerService.displayAuctionDetail(box);
    	String jsp = "reauctionList.jsp";
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("kfcFormNo", kfcFormNo);
		return new ModelAndView("index", "map", map);
    }
    
    // Added by Amit Das on 04-04-2016
    public ModelAndView submitReauctionDetails(HttpServletRequest request, HttpServletResponse response){
    	Map<String, Object> map=new HashMap<String, Object>();
    	Map<String, Object> details = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		int hospitalId = 0;
		int userId= 0;
		int deptId = 0;
		boolean flag = false;
		synchronized (session) {
			hospitalId = (Integer) session.getAttribute(HOSPITAL_ID);
			userId = (Integer) session.getAttribute("userId");
		}
		if (session.getAttribute("deptId") != null){
			deptId = Integer.parseInt("" + session.getAttribute("deptId"));
		}
		
		
		Box box = HMSUtil.getBox(request);
		String kfcFormNo = "";
		if(request.getParameter("kfcFormNo") != null){
			 kfcFormNo = request.getParameter("kfcFormNo");
			box.put("kfcFormNo", kfcFormNo);
		}
		if(hospitalId>0){
			box.put("hospitalId", hospitalId);
		}
		if(userId>0)
			box.put("userId", userId);
		
		if(deptId>0)
			box.put("deptId", deptId);
		
		
		map=maintenanceHandlerService.submitReauctionDetails(box);
    	
		jsp = "reauctionList.jsp";
		title = "Condemnatione";
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index", "map", map);
    }
    
    public ModelAndView deleteAttachFiles(HttpServletRequest request ,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		int documentId=0;
		Box box = HMSUtil.getBox(request);
		if(box.getInt("documentId")!=0){
			documentId = box.getInt("documentId");	
			generalMap.put("documentId", documentId);
		}
		
		map=maintenanceHandlerService.deleteAttachFiles(generalMap);
		String jsp = "uploadAndViewDocuments";
		
		return new ModelAndView(jsp, "map", map);
	}
}

