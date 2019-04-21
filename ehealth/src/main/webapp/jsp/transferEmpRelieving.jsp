<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Javed
 * Create Date: 6th Mar,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.HrMasTransferNotification"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.MasOpSession"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
 
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
	%>
		serverdate = '<%=dateCal+"/"+month+"/"+year%>'
			 function abc(){
		
		 var mon = document.getElementById('month').value;
			
			if (mon=="4" || mon=="6" || mon=="8" || mon=="9" || mon=="11"){
				/*  document.getElementById('apr').style.display = "inline";
				 document.getElementById('jan').style.display = "none"; */
				 
				document.getElementById('apr').style.display = "none";
				
			} else{
				/* document.getElementById('apr').style.display = "none";
				 document.getElementById('jan').style.display = "inline"; */
				 document.getElementById('apr').style.display = "none";
			}
		} 

</script>
 
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map1 = new HashMap<String, Object>();
	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	if(map.get("map1")!=null)
	{
		map1 = (Map)map.get("map1");
	}

	List<MasEmployee> empList = new ArrayList<MasEmployee>();
	List<MasDepartment> masDepartmentList = new ArrayList<MasDepartment>();
	List<MasHospital> hosList = new ArrayList<MasHospital>();
	List<MasDistrict> distList = new ArrayList<MasDistrict>();
//	List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
	List transferNotificationList = new ArrayList();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasOpSession> sesList = new ArrayList<MasOpSession>();
	 
	if(map.get("masDepartmentList") != null){
		masDepartmentList = (List<MasDepartment>)map.get("masDepartmentList");
	}
	
	if(map.get("empList") != null){
		empList = (List<MasEmployee>)map.get("empList");
	}
	if(map.get("hosList") != null){
		hosList = (List<MasHospital>)map.get("hosList");
	}
	if(map.get("distList") != null){
		distList = (List<MasDistrict>)map.get("distList");
	}
	/* if(map.get("transferNotificationList") != null){
		transferNotificationList = (List<HrMasTransferNotification>)map.get("transferNotificationList");
	} */
	
	if(map.get("hrTransferApplicationMList") != null){
		hrTransferApplicationMList = (	List<HrTransferApplicationM>)map.get("hrTransferApplicationMList");
	}
	if(map.get("hrTransferApprovedList") != null){
		hrTransferApprovedList = (	List<HrTransferApproved>)map.get("hrTransferApprovedList");
	}
	 
	if(map.get("hrTerminationProcessList") != null){
		hrTerminationProcessList = (List<HrTerminationProcess>)map.get("hrTerminationProcessList");
	}
	
	if(map.get("sesList") != null){
		sesList = (List<MasOpSession>)map.get("sesList");
	}
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Relieving</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">
<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->
<form name="empReleive" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%if(hrTransferApplicationMList.size()>0){ %>
<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value="<%=hrTransferApplicationMList.get(0).getEmployee().getEmployeeName() %>"  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value="<%=hrTransferApplicationMList.get(0).getEmployee().getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<input type="hidden" id="transferApp_id" name="transferApp_id" value="<%=hrTransferApplicationMList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<input type="hidden" id="transferApprove_id" name="transferApprove_id" value="<%=hrTransferApprovedList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>

<label > PEN </label>
<input type="text" id="PEN" name="PEN" value="<%=hrTransferApplicationMList.get(0).getEmployee().getPEN() != null ? hrTransferApplicationMList.get(0).getEmployee().getPEN() :""%>" readonly MAXLENGTH="12" class="medium3" validate="PEN,String,no" />

<label > Designation </label>
<input type="text" id="designation" name="designation" value="<%=hrTransferApplicationMList.get(0).getEmployee().getRank().getRankName()%>" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />
 
<div class="clear"></div>

<label > Department </label>
<input type="text" id="department" name="department" value="<%=hrTransferApplicationMList.get(0).getEmployee().getEmployeeDepartment() != null ? hrTransferApplicationMList.get(0).getEmployee().getEmployeeDepartment().getEmpDeptName() :"" %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>

<label > Current Institute </label>
<input type="text" id="cur_institute" name="cur_institute" value="<%=hrTransferApplicationMList.get(0).getEmployee().getHospital().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="cur_instituteId" name="cur_instituteId" value="<%=hrTransferApplicationMList.get(0).getEmployee().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<label > Transfer Institute </label>
<input type="text" id="trans_institute" name="trans_institute" value="<%=hrTransferApprovedList.get(0).getTransferInstitute().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />
<input type="hidden" id="trans_instituteId" name="trans_instituteId" value="<%=hrTransferApprovedList.get(0).getEmployee().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<div class="clear"></div>

<label > Reliving date </label>
<%

DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Date joiningDate = null;
Calendar cal = Calendar.getInstance();
if(hrTransferApprovedList.get(0).getJoiningDate()!=null){
	joiningDate = hrTransferApprovedList.get(0).getJoiningDate();
	cal.setTime(joiningDate);
	 cal.add(Calendar.DATE, -1);
}
%>
<input type="text" id="reliving_date" name="reliving_date" value="<%=dateFormat.format(cal.getTime()) %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>
<!-- <label > Actual Reliving Date </label> -->
<label > Probable Joining Date </label>
<input type="text" id="actualRelivingDate" value="<%=dateCal+"/"+month+"/"+year%>" name="actualRelivingDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empReleive.actualRelivingDate,event)" validate="Pick a date" class="calender" />

<%-- <label >Session <span>*</span></label>
		<select  name="session" 	tabindex=1  id="session" 	  validate="Session,String,yes" />
		<option value="">Select</option>
		<%for(MasOpSession mos : sesList){ %>
			<option value='<%=mos.getId()%>'><%=mos.getSessionName()%></option>
		<%} %>
			
			
		 </select>
<div class="clear"></div> --%>

<label > Reason For Relieving </label>
 <input type="text" id="mode" name="mode" value="Transfer" MAXLENGTH="12" class="medium3" readonly validate="Mode of Reliving,String,no" />
<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="100" class="medium3" validate="Remarks,String,no" />
<%} %>

<%if(hrTerminationProcessList.size()>0){ %>
<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getEmployeeName() %>"  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
 <input type="hidden" id="transferApp_id" name="transferApp_id" value="<%=hrTerminationProcessList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<%--<input type="hidden" id="transferApprove_id" name="transferApprove_id" value="<%=hrTransferApprovedList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/> --%>

<label > PEN </label>
<input type="text" id="PEN" name="PEN" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getPEN() != null ? hrTerminationProcessList.get(0).getEmployeeId().getPEN() :""%>" readonly MAXLENGTH="12" class="medium3" validate="PEN,String,no" />

<label > Designation </label>
<input type="text" id="designation" name="designation" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getRank().getRankName()%>" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />
 
<div class="clear"></div>

<label > Department </label>
<input type="text" id="department" name="department" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getEmployeeDepartment() != null ? hrTerminationProcessList.get(0).getEmployeeId().getEmployeeDepartment() .getEmpDeptName() :"" %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>
 
<label > Current Institute </label>
<input type="text" id="cur_institute" name="cur_institute" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getHospital().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="cur_instituteId" name="cur_instituteId" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<%-- <label > Transfer Institute </label>
<input type="text" id="trans_institute" name="trans_institute" value="<%=hrTransferApprovedList.get(0).getTransferInstitute().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />
<input type="hidden" id="trans_instituteId" name="trans_instituteId" value="<%=hrTransferApprovedList.get(0).getEmployee().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" /> --%>

<div class="clear"></div>

<label > Relieving date </label>
<%
Date joiningDate= null;
DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
if(hrTerminationProcessList.get(0).getTerminationMode().equals("Suspension"))
 joiningDate = hrTerminationProcessList.get(0).getOrderDate();
if(hrTerminationProcessList.get(0).getTerminationMode().equals("Termination"))
 joiningDate = hrTerminationProcessList.get(0).getOrderDate();
Calendar cal = Calendar.getInstance();
cal.setTime(joiningDate);
//if(hrTerminationProcessList.get(0).getTerminationMode().equalsIgnoreCase("Suspension")) 
 //cal.add(Calendar.DATE, -1);
//else
	cal.add(Calendar.DATE, 0);
%>
 
<input type="text" id="reliving_date" name="reliving_date" value="<%=dateFormat.format(cal.getTime()) %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>

<label > Actual Relieving Date </label> 
<!-- <label > Probable Joining Date </label> -->

 <input type="text" id="actualRelivingDate" value="<%=dateCal+"/"+month+"/"+year%>" name="actualRelivingDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empReleive.actualRelivingDate,event)" validate="Pick a date" class="calender" />

<%--  <label >Session <span>*</span></label>
		<select  name="session" 	tabindex=1  id="session"  validate="Session,String,no" />
		<option value="">Select</option>
		<%for(MasOpSession mos : sesList){ %>
			<option value='<%=mos.getId()%>'><%=mos.getSessionName()%></option>
		<%} %> 
			
			
		 </select>
<div class="clear"></div> --%>

<label > Reason For Relieving </label>

	<input type="text" id="mode" name="mode" value="<%=hrTerminationProcessList.get(0).getTerminationMode() %>" MAXLENGTH="12" class="medium3" readonly validate="Mode of Reliving,String,no" />

<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="100" class="medium3" validate="Remarks,String,no" />
<%} %>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
 
</div>
</div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('empReleive','/hms/hrms/training?method=saveEmpRelieving')"  />

<input name="button"  type="reset"	value="Reset" />

<!-- <form name="itemGrid" method="post"> -->
 
<div class="paddingTop15"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="testDiv"></div>
 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%="admin"%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%="admin"%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden"	name="CHANGED_DATE" value="<%=date%>" /> 
<input type="hidden"	name="CHANGED_TIME" value="<%=time%>" />
</div>
 
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
 
function abc1(row,shift){
	alert(row+"  "+shift)
	var empcate= document.getElementById('empCate').value
	submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift&shift='+shift+'&row='+row+'&empcate='+empcate,'testDiv'+row);
	//submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift','testDiv'+row);
}
</script>
</form>
