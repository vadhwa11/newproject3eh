package jkt.hrms.timesheet.controller;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jkt.hms.masters.business.MasDepartment;
import jkt.hms.masters.business.MasEmployee;
import jkt.hms.masters.business.MasHospital;
import jkt.hms.masters.business.Users;
import jkt.hms.util.HMSUtil;
import jkt.hrms.timesheet.handler.TimeSheetHandlerService;
import jkt.hrms.masters.business.MstrProject;
import jkt.hrms.masters.business.MstrSiteHeader;
import jkt.hrms.masters.business.MstrTask;
import jkt.hrms.masters.business.TblFreezeTimeSheet;
import jkt.hrms.masters.business.Tbltimesheet;
import jkt.hrms.masters.business.TbltimesheetAprl;
import jkt.hrms.masters.handler.HrmsCommonMasterHandlerService;
import static jkt.hrms.util.HrmsRequestConstants.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class TimeSheetController extends MultiActionController
{
	TimeSheetHandlerService timesheetHandlerService= null;
	HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService =null;
	HttpSession session = null;
	Map<String, Object> map = new HashMap<String, Object>();
	String jsp="";
	String title="";
	String pojoPropertyName = "";
	String pojoPropertyCode = "";
	String pojoName = "";
	String userName = "";
	String currentDate = "";
	String currentTime = "";
	String message = "";
	String code = "";
	String name = "";
	String changedBy =""; 
	String jspName = "";
	String url="";
//	Users currentUser=null;
//	int currentEmpId=0;
	public TimeSheetHandlerService getTimesheetHandlerService() {
		return timesheetHandlerService;
	}
	public void setTimesheetHandlerService(TimeSheetHandlerService timesheetHandlerService) {
		this.timesheetHandlerService = timesheetHandlerService;
	}
	public HrmsCommonMasterHandlerService getHrmsCommonMasterHandlerService() {
		return hrmsCommonMasterHandlerService;
	}
	public void setHrmsCommonMasterHandlerService(
			HrmsCommonMasterHandlerService hrmsCommonMasterHandlerService) {
		this.hrmsCommonMasterHandlerService = hrmsCommonMasterHandlerService;
	}

	public ModelAndView showTimeSheetJsp(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		int currentEmpId=0;
		Users currentUser=null;
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		Date date = null;
		if(request.getParameter("date")!=null)
		{
			date = HMSUtil.convertStringTypeDateToDateType((request.getParameter("date")));
			//map.put("date", date);
		}else{
			date = new Date();
		}
		map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,date);
		jsp="ts_timeSheetEntryJsp";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
	
		
		return new ModelAndView("index","map",map);
	}
	public ModelAndView getTaskListJsp(HttpServletRequest request , HttpServletResponse response)
	{
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		int currentEmpId=0;
		Users currentUser=null;
//		if (session.getAttribute("users") != null) {
//			currentUser = (Users)session.getAttribute("users");
//			currentEmpId =currentUser.getEmployee().getId();
//		}
		if(request.getParameter("employeeId")!=null){
			currentEmpId=Integer.parseInt(request.getParameter("employeeId"));
		}
		int prjId= 0;
		if(request.getParameter("prjId")!=null)
		{
			prjId = new Integer(request.getParameter("prjId"));
		}
		
		map = timesheetHandlerService.getTaskList(currentEmpId,prjId);
		
		jsp="ts_taskList";
		
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView editTimeSheet(HttpServletRequest request , HttpServletResponse response)
	{
		Map map = new HashMap();
		int currentEmpId=0;
		Users currentUser=null;
		Tbltimesheet tblTimeSheet = new Tbltimesheet();
		session = request.getSession();
		if(request.getParameter("employeeId")!=null){
			currentEmpId=Integer.parseInt(request.getParameter("employeeId"));
		}
//		if (session.getAttribute("users") != null) {
//			currentUser = (Users)session.getAttribute("users");
//			currentEmpId =currentUser.getEmployee().getId();
//		}
			int timeSheetId= 0;
			if(request.getParameter("rowId")!=null)
			{
				timeSheetId = new Integer(request.getParameter("rowId"));
				map.put("timeSheetId", timeSheetId);
			}
			int prjId= 0;
			if(request.getParameter("project")!=null)
			{
				prjId = new Integer(request.getParameter("project"));
				map.put("prjId", prjId);
			}
			
			int siteId = 0;
			
			if(request.getParameter("site")!=null)
			{
				siteId = new Integer(request.getParameter("site"));
				map.put("siteId", siteId);
			}
			
			int taskId= 0;
			if(request.getParameter("task")!=null)
			{
				taskId = new Integer(request.getParameter("task"));
				map.put("taskId", taskId);
			}
			
			if(request.getParameter("lastSubmissiondate")!= null){
				Date lastSubmitDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastSubmissiondate"));
				map.put("lastSubmitDate", lastSubmitDate);
			}
			//-----------------------------------------
			if(request.getParameter("approverId")!=null && !(request.getParameter("approverId").equals("0")))
			{
				int approverId = Integer.parseInt(request.getParameter("approverId"));
				map.put("approverId", approverId);
				
			}
			
			if (request.getParameter("other")!= null) {
				if(request.getParameter(HEAD_ID)!=null && ! (request.getParameter(HEAD_ID).equals(0)))
				{
					int otherApproverId = Integer.parseInt(request.getParameter(HEAD_ID));
					map.put("otherApproverId", otherApproverId);
				}
			}
			
			float hrWorked= 0;
			if(request.getParameter("hrWorked")!=null)
			{
				hrWorked = new Float(request.getParameter("hrWorked"));
				//map.put("hrWorked", hrWorked);
			}
			
					
			float minWorked= 0f;
			if(request.getParameter("minWorked")!=null)
			{
				minWorked = new Float(request.getParameter("minWorked"));
				if(minWorked==60)
				{
					hrWorked++;
				}else{
				minWorked= minWorked/100;
				hrWorked=hrWorked+minWorked;
				}
				
			}
			map.put("hrWorked", hrWorked);
			String comment= "";
			if(request.getParameter("comment")!=null)
			{
				comment = new String(request.getParameter("comment"));
				map.put("comment", comment);
			}
			
			Date date=null;


			if(request.getParameter("date")!=null)
			{
				date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("date"));
				map.put("date", date);

			}
			
			boolean updated = timesheetHandlerService.editTimeSheet(map);
			String message ="";
			if(updated== true)
			{
				message = "Time Sheet updated sucessfull";
			}
			else{
				message = "Please try again";
			}
			map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,new Date());
			jsp="ts_timeSheetEntryJsp";
			jsp += ".jsp";
			title = "Time Sheet";		
			map.put("contentJsp", jsp);
			map.put("title", title);
			map.put("message", message);
			return new ModelAndView("index","map",map);
	}
	
	public ModelAndView submitTimeSheet(HttpServletRequest request , HttpServletResponse response)
	{
		Map map = new HashMap();
		int currentEmpId=0;
		Tbltimesheet tblTimeSheet = new Tbltimesheet();
		session = request.getSession();
		int totalMin =0;
		int depart_id =0;
		int listSize = 0;
		if(request.getParameter("listSize")!=null)
		{
			listSize=new Integer(request.getParameter("listSize"));
			
		}
		Date date=null;

		if(request.getParameter("date")!=null)
		{
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("date"));
		}
	

		if(request.getParameter("status").equalsIgnoreCase("save"))
		{
			int prjId= 0;
			if(request.getParameter("project")!=null)
			{
				prjId = new Integer(request.getParameter("project"));
			}
		
			int siteId = 0;
		
			if(request.getParameter("site")!=null)
			{
				siteId = new Integer(request.getParameter("site"));
			}
		
			int taskId= 0;
			if(request.getParameter("task")!=null)
			{
				taskId = new Integer(request.getParameter("task"));
			}
			
			
			if(request.getParameter("approverId")!=null && !(request.getParameter("approverId").equals("0")))
			{
				int approverId = Integer.parseInt(request.getParameter("approverId"));
				MasEmployee masEmployee = new MasEmployee();
				masEmployee.setId(approverId);
				tblTimeSheet.setApproverId(masEmployee);
				
			}
			
			if(request.getParameter("lastSubmissiondate")!= null){
				Date lastSubmitDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("lastSubmissiondate"));
				tblTimeSheet.setLastSubmissionDate(lastSubmitDate);
			}
			
			if (request.getParameter("other")!= null) {
				if(request.getParameter(HEAD_ID)!=null && ! (request.getParameter(HEAD_ID).equals(0)))
				{
					int otherApproverId = Integer.parseInt(request.getParameter(HEAD_ID));
					MasEmployee masEmployee = new MasEmployee();
					masEmployee.setId(otherApproverId);
					tblTimeSheet.setOtherApproverId(masEmployee);
				}
			}
			
			
			
			float hrWorked= 0f;
			if(request.getParameter("hrWorked")!=null)
			{
				hrWorked = new Float(request.getParameter("hrWorked"));
			}
			float minWorked= 0f;
			if(request.getParameter("minWorked")!=null && !(request.getParameter("minWorked").equals("")))
			{
				minWorked = new Float(request.getParameter("minWorked"));
				if(minWorked==60)
				{
					hrWorked++;
				}else{
				minWorked= minWorked/100;
				hrWorked=hrWorked+minWorked;
				}
			}
			
			// add by vishal
			if(request.getParameter("hrWorked")!=null)
			{
				totalMin =  Integer.parseInt((request.getParameter("hrWorked")));
				totalMin = totalMin * 60;
			}
			if(request.getParameter("minWorked")!=null && !(request.getParameter("minWorked").equals("")))
			{
				int minwrk = Integer.parseInt(request.getParameter("minWorked"));
				totalMin = totalMin + minwrk;
				
			}
			if(request.getParameter("depart_id")!=null)
			{
				depart_id =  Integer.parseInt((request.getParameter("depart_id")));
			}
			
			
			// end add
			//hrWorked=hrWorked+minWorked;
//			Date date1= new Date();
//			date1.setHours(hrWorked);
//			date1.setMinutes(minWorked);
//			String time = HMSUtil.getDateFormat(date1, "HH:MM");
			int hospitalId = 0;
			if (session.getAttribute("hospitalId")!= null) {
				hospitalId = (Integer)session.getAttribute("hospitalId");
			}
			
			
			String comment= "";
			if(request.getParameter("comment")!=null)
			{
				comment = new String(request.getParameter("comment"));
			}
//			if (session.getAttribute("users") != null) {
//				currentUser = (Users)session.getAttribute("users");
//				currentEmpId =currentUser.getEmployee().getId();
//			}
			if(request.getParameter("employeeId")!=null){
				currentEmpId=Integer.parseInt(request.getParameter("employeeId"));
			}
			MasEmployee emp = new MasEmployee();
			emp.setId(currentEmpId);
			// add by Vishal
			
			MasHospital company =new MasHospital();
			company.setId(hospitalId);	
			tblTimeSheet.setCompanyID(company);
			
		    MasDepartment masDepartment = new MasDepartment();
		    masDepartment.setId(depart_id);
		    tblTimeSheet.setDepartmentID(masDepartment);
		    tblTimeSheet.setTotalMin(totalMin);
		    // add end
			tblTimeSheet.setEmpId(emp);
			tblTimeSheet.setEntryDate(date);
			tblTimeSheet.setHrsWorked(new BigDecimal(hrWorked));
		
			MstrProject project = new MstrProject();
			project.setId(prjId);
			tblTimeSheet.setProjectID(project);
		
			tblTimeSheet.setComments(comment);
			if(siteId!=0 )
			{
				MstrSiteHeader site = new MstrSiteHeader();
				site.setId(siteId);
				tblTimeSheet.setSiteID(site);
			}
			MstrTask task = new MstrTask();
			task.setId(taskId);
			tblTimeSheet.setTaskID(task);
			
			
			
			
			
			tblTimeSheet.setStatus("Saved");
			
			boolean saved = timesheetHandlerService.submitTimeSheet(tblTimeSheet);
			if (session.getAttribute("users") != null) {
				
				map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,date);
			}
			
		}
		else if(request.getParameter("status").equalsIgnoreCase("submit"))
		{
			for(int ilop = 1 ;ilop<=listSize;ilop++)
			{
				int prjId= 0;
				
				if((request.getParameter("chkAction"+ilop)!=null) && !(request.getParameter("chkAction"+ilop).equals(new Integer(0))))
				{
					prjId = new Integer(request.getParameter("chkAction"+ilop));
					boolean submitted = timesheetHandlerService.submitTimeSheet(prjId);
					
					if(request.getParameter("employeeId")!=null){
						currentEmpId=Integer.parseInt(request.getParameter("employeeId"));
					}
					if (session.getAttribute("users") != null) {
						
						if(submitted){
							boolean markSubmission = timesheetHandlerService.markNoOfSubmission(currentEmpId,date);
							if (markSubmission){
								map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,new Date());
								
							}
						}
					}
					
				}
			}
			if (session.getAttribute("users") != null) {
				
				
				map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,date);
			}
			
		}else if(request.getParameter("status").equalsIgnoreCase("delete"))
		{
			if(request.getParameter("employeeId")!=null){
				currentEmpId=Integer.parseInt(request.getParameter("employeeId"));
			}
			
			for(int ilop = 1 ;ilop<=listSize;ilop++)
			{
				int prjId= 0;
				
				if((request.getParameter("chkAction"+ilop)!=null) && !(request.getParameter("chkAction"+ilop).equals(new Integer(0))))
				{
					prjId = new Integer(request.getParameter("chkAction"+ilop));
					boolean submitted = timesheetHandlerService.deleteTimeSheet(prjId);
				}
			}
			if (session.getAttribute("users") != null) {
				map = timesheetHandlerService.showTimeSheetJsp(currentEmpId,date);
			}
		}
		
		
		jsp="ts_timeSheetEntryJsp";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		map.put("date",date);
		return new ModelAndView("index","map",map);
		
		
	}
	public ModelAndView copyOtherDateTimeSheet(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> generalMap = new HashMap<String, Object>();
		Date date=null;
		session = request.getSession();
		int currentEmpId=0;
		Users currentUser=null;
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
			generalMap.put("currentEmpId", currentEmpId);
		}
		if(request.getParameter("date")!=null)
		{
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("date"));
			generalMap.put("date", date);
		}
		Date timesheetDate = null;
		if(request.getParameter("timesheetDate")!=null)
		{
			timesheetDate = HMSUtil.convertStringTypeDateToDateType(request.getParameter("timesheetDate"));
			generalMap.put("timesheetDate", timesheetDate);
		}
		
		map = timesheetHandlerService.copyOtherDateTimeSheet(generalMap);
		jsp="ts_timeSheetEntryJsp";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
		
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView showTimeSheetApprovalJsp(HttpServletRequest request , HttpServletResponse response)
	{Users currentUser=null;
	int currentEmpId=0;
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		
		map = timesheetHandlerService.showTimeSheetApprovalJsp(currentEmpId);
		jsp="ts_timeSheetApproval";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
	
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView setTimeSheetStatus(HttpServletRequest request , HttpServletResponse response)
	{Users currentUser=null;
	int currentEmpId=0;
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		int len= 0;
		if(request.getParameter("len")!=null)
		{
			len = new Integer(request.getParameter("len"));
		}
		int tbSheetSize= 0;
		if(request.getParameter("tbSheetSize")!=null)
		{
			tbSheetSize = new Integer(request.getParameter("tbSheetSize"));
		}
		String status="";
		int id= 0;
		BigDecimal hrs=null;
		String appComment="";
		String manager="0";
		for(int ilop=0 ; ilop<tbSheetSize ; ilop++)
		{
			if(request.getParameter("chkAction"+ilop)!=null)
			{
				status=request.getParameter("chkAction"+ilop);
				if(request.getParameter("hide"+ilop)!=null)
				{
					id=new Integer(request.getParameter("hide"+ilop));
				}
				TbltimesheetAprl tbltimesheetAprl = new TbltimesheetAprl();
				tbltimesheetAprl.setTmshtId(id);
				tbltimesheetAprl.setApprover(currentEmpId);
				if(request.getParameter("hrs"+ilop)!=null)
				{
					hrs=(new BigDecimal(request.getParameter("hrs"+ilop)));
				}
				tbltimesheetAprl.setAppHrs(hrs);
				if(request.getParameter("appCom"+ilop)!=null)
				{
					appComment=(request.getParameter("appCom"+ilop));
				}
				if((request.getParameter("manager"+ilop)!=null) && !(request.getParameter("manager"+ilop).equals("")))
				{
					manager=(request.getParameter("manager"+ilop));
				}
				tbltimesheetAprl.setAppCmts(appComment);
				map = timesheetHandlerService.setTimeSheetStatus(id,status,tbltimesheetAprl,new Integer(manager));
			}
		}
		map = timesheetHandlerService.showTimeSheetApprovalJsp(currentEmpId);
		jsp="ts_timeSheetApproval";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unchecked")
	public ModelAndView loadTimeSheet(HttpServletRequest request , HttpServletResponse response)
	{Users currentUser=null;
	int currentEmpId=0;
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		
		int empId= 0;
		int approverId= 0;
		int otherId= 0;
		if(request.getParameter("rowId")!=null)
		{
			empId = new Integer(request.getParameter("rowId"));
			
		}
		if(request.getParameter("approverId")!=null)
		{
			approverId = new Integer(request.getParameter("approverId"));
			
		}
		if(request.getParameter("otherId")!=null)
		{
			otherId = new Integer(request.getParameter("otherId"));
			
		}
		Date date= null;
		if(request.getParameter("date")!=null)
		{
			date = HMSUtil.convertStringTypeDateToDateType(request.getParameter("date"));
			
			
		}
		map = timesheetHandlerService.loadTimeSheet(empId,date,currentEmpId,approverId,otherId);
		jsp="ts_timeSheetData";
		//jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
	
		return new ModelAndView(jsp,"map",map);
	}
	public ModelAndView showFreezTimeSheet(HttpServletRequest request , HttpServletResponse response)
	{Users currentUser=null;
	int currentEmpId=0;
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		Date date = null;
		if(request.getParameter("date")!=null)
		{
			date = HMSUtil.convertStringTypeDateToDateType((request.getParameter("date")));
			map.put("date", date);
		}else{
			date = new Date();
		}
		String year="";
		if(request.getParameter("year")!=null)
		{
			year = request.getParameter("year");
			
		}else{
		Calendar cale =Calendar.getInstance();
		year= cale.get(Calendar.YEAR)+"";
		}
		
		map = timesheetHandlerService.showFreezTimeSheet(year);
		jsp="ts_freezTimeSheet";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
	
		return new ModelAndView("index","map",map);
	}
	public ModelAndView saveFreezTimeSheet(HttpServletRequest request , HttpServletResponse response)
	{
		Users currentUser=null;
		int currentEmpId=0;
		String year="";
		String maxTime="";
		String minTime="";
		String noOfSubmission="";
		Map<String, Object> map =new HashMap<String, Object>();
		session = request.getSession();
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		if(request.getParameter("year")!=null && !(request.getParameter("year").equals("")))
		{
			year=(request.getParameter("year"));
			
		}
		for(int ilop=1;ilop<=12;ilop++)
		{
			TblFreezeTimeSheet tblFreezeTimeSheet = new TblFreezeTimeSheet();
		
			tblFreezeTimeSheet.setYear(year);
		
		
			int day=0;
			if(request.getParameter("date"+ilop)!=null && !(request.getParameter("date"+ilop).equals("")))
			{
				day=new Integer(request.getParameter("date"+ilop));
				
				tblFreezeTimeSheet.setDate(day);
				
			}
			if(request.getParameter("weekOne"+ilop)!=null && !(request.getParameter("weekOne"+ilop).equals("")))
			{
				int week1=Integer.parseInt(request.getParameter("weekOne"+ilop));
				tblFreezeTimeSheet.setWeek1(week1);
			}
			if(request.getParameter("weekTwo"+ilop)!=null && !(request.getParameter("weekTwo"+ilop).equals("")))
			{
				int week2=Integer.parseInt(request.getParameter("weekTwo"+ilop));
				tblFreezeTimeSheet.setWeek2(week2);
			}
			
			if(request.getParameter("weekThree"+ilop)!=null && !(request.getParameter("weekThree"+ilop).equals("")))
			{
				int week3=Integer.parseInt(request.getParameter("weekThree"+ilop));
				tblFreezeTimeSheet.setWeek3(week3);
			}
			if(request.getParameter("weekFour"+ilop)!=null && !(request.getParameter("weekFour"+ilop).equals("")))
			{
				int week4=Integer.parseInt(request.getParameter("weekFour"+ilop));
				tblFreezeTimeSheet.setWeek4(week4);
			}
			if(request.getParameter("weekFive"+ilop)!=null && !(request.getParameter("weekFive"+ilop).equals("")))
			{
				int week5=Integer.parseInt(request.getParameter("weekFive"+ilop));
				tblFreezeTimeSheet.setWeek5(week5);
			}
			
			if(request.getParameter("time"+ilop)!=null && !(request.getParameter("time"+ilop).equals("")))
			{
				maxTime=request.getParameter("time"+ilop);
				tblFreezeTimeSheet.setMaxTime(maxTime);
				tblFreezeTimeSheet.setMonth(""+ilop);
			}
			if(request.getParameter("mintime"+ilop)!=null && !(request.getParameter("mintime"+ilop).equals("")))
			{
				minTime=request.getParameter("mintime"+ilop);
				tblFreezeTimeSheet.setMinTime(minTime);
			}
			if(request.getParameter("submitTimeSheetRecord"+ilop)!=null && !(request.getParameter("submitTimeSheetRecord"+ilop).equals("")))
			{
				int noOfTimeSheetRecord=Integer.parseInt(request.getParameter("submitTimeSheetRecord"+ilop));
				tblFreezeTimeSheet.setNoOfRecordSubmit(noOfTimeSheetRecord);
			}
			if(request.getParameter("submission"+ilop)!=null && !(request.getParameter("submission"+ilop).equals("")))
			{
				noOfSubmission=request.getParameter("submission"+ilop);
				tblFreezeTimeSheet.setNoOfSubmission(noOfSubmission);
			}

		
		if(request.getParameter(CHANGED_BY) != null && !(request.getParameter(CHANGED_BY).equals(""))){
			changedBy = request.getParameter(CHANGED_BY);
			
		}
		
		Date currentDate = new Date();
		if(request.getParameter(CHANGED_DATE) != null && !(request.getParameter(CHANGED_DATE).equals(""))){
			currentDate = HMSUtil.dateFormatterDDMMYYYY(request.getParameter(CHANGED_DATE));
			
		}
		if(request.getParameter(CHANGED_TIME) != null && !(request.getParameter(CHANGED_TIME).equals(""))){
			currentTime = request.getParameter(CHANGED_TIME);
			
		}
		
		tblFreezeTimeSheet.setLastChgBy(changedBy);
		tblFreezeTimeSheet.setLastChgDate(currentDate);
		tblFreezeTimeSheet.setLastChgTime(currentTime);
		map.put("tblFreezeTimeSheet"+ilop, tblFreezeTimeSheet);
		
		
		}
		map.put("year",year);
		timesheetHandlerService.saveFreezTimeSheet(map);
		
		map = timesheetHandlerService.showFreezTimeSheet(year);
		jsp="ts_freezTimeSheet";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
	@SuppressWarnings("unused")
	public ModelAndView approveAll(HttpServletRequest request , HttpServletResponse response)
	{Users currentUser=null;
	int currentEmpId=0;
		Map map = new HashMap();
		Tbltimesheet tblTimeSheet = new Tbltimesheet();
		session = request.getSession();
		if (session.getAttribute("users") != null) {
			currentUser = (Users)session.getAttribute("users");
			currentEmpId =currentUser.getEmployee().getId();
		}
		Date fromDate = null;
		if(request.getParameter(FROM_DATE)!=null)
		{
			fromDate=HMSUtil.convertStringTypeDateToDateType((request.getParameter(FROM_DATE)));
			
		}
		
		Date toDate = null;
		if(request.getParameter(TO_DATE)!=null)
		{
			toDate=HMSUtil.convertStringTypeDateToDateType((request.getParameter(TO_DATE)));
			
		}
		
		boolean approveAll= timesheetHandlerService.approveAll(fromDate,toDate,currentEmpId);
		
		map = timesheetHandlerService.showTimeSheetApprovalJsp(currentEmpId);
		jsp="ts_timeSheetApproval";
		jsp += ".jsp";
		title = "Time Sheet";		
		map.put("contentJsp", jsp);
		map.put("title", title);
		return new ModelAndView("index","map",map);
	}
}
