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
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
<%@page import="jkt.hms.masters.business.HrMasTransferNotification"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.MasOpSession"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>


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
	List<HrTransferApproved> hrTransferApprovedList = new ArrayList<HrTransferApproved>();
	List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	List<MasOpSession> sesList = new ArrayList<MasOpSession>();
	
	
	
	if(map.get("sesList") != null){
		sesList = (List<MasOpSession>)map.get("sesList");
	}
	
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
	
	
	if(map.get("hrTransferApprovedList") != null){
		hrTransferApprovedList = (	List<HrTransferApproved>)map.get("hrTransferApprovedList");
	}
	
	if(map.get("hrTerminationProcessList") != null){
		hrTerminationProcessList = (List<HrTerminationProcess>)map.get("hrTerminationProcessList");
	}
	
	String mode = ""; 
	if(map.get("mode")!=null)
	{
		mode = (String)map.get("mode");
	}

	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Joining</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->
<form name="empJoin" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(mode.equalsIgnoreCase("Suspension")){ %>

<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getEmployeeName() != null ? hrTerminationProcessList.get(0).getEmployeeId().getEmployeeName() :""%>"  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<%-- <input type="hidden" id="transferApprove_id" name="transferApprove_id" value="<%=hrTransferApprovedList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>--%>
<input type="hidden" id="transferApp_id" name="transferApp_id" value="<%=hrTerminationProcessList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
 
<label > PEN </label>
<input type="text" id="PEN" name="PEN" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getPEN() != null ? hrTerminationProcessList.get(0).getEmployeeId().getPEN() :""%>" readonly MAXLENGTH="12" class="medium3" validate="PEN,String,no" />

<label > Designation </label>
<input type="text" id="designation" name="designation" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getRank().getRankName()%>" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />


<div class="clear"></div>

<label > Department </label>
<input type="text" id="department" name="department" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getEmployeeDepartment().getEmpDeptName() != null ? hrTerminationProcessList.get(0).getEmployeeId().getEmployeeDepartment().getEmpDeptName() :"" %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>


<label >Institution </label>
<input type="text" id="institute" name="institute" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getHospital().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="instituteId" name="instituteId" value="<%=hrTerminationProcessList.get(0).getEmployeeId().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />


<div class="clear"></div>
<%

DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
Calendar cal = Calendar.getInstance();
Date joiningDate = null;
if( hrTerminationProcessList.get(0).getToDate()!=null){
	joiningDate = hrTerminationProcessList.get(0).getToDate();
	cal.setTime(joiningDate);
	 cal.add(Calendar.DATE, 1);
}

%>

<label > Joining Date  </label>
<input type="text" id="joining_date" name="joining_date" value="<%=dateFormat.format(cal.getTime())  %>" MAXLENGTH="12" class="medium3" validate="Joining Date,String,no" readonly/>




<%}else{ %>
<label > Date of  Reliving  </label>
<input type="text" id="reliving_date" name="reliving_date" value="<%=hrTransferApprovedList.get(0).getActualReleivingDate()!=null?HMSUtil.getDateFormat(hrTransferApprovedList.get(0).getActualReleivingDate(),"dd/MM/yyyy"):"" %>" MAXLENGTH="12" class="medium3" validate="Reliving date,String,no" readonly/>
<div class="clear"></div>
<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value="<%=hrTransferApprovedList.get(0).getEmployee().getEmployeeName() != null ? hrTransferApprovedList.get(0).getEmployee().getEmployeeName() :""%>"  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value="<%=hrTransferApprovedList.get(0).getEmployee().getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<input type="hidden" id="transferApprove_id" name="transferApprove_id" value="<%=hrTransferApprovedList.get(0).getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>
<input type="hidden" id="transferApp_id" name="transferApp_id" value="<%=hrTransferApprovedList.get(0).getTransferApp().getId() %>"  readonly class="medium3"  MAXLENGTH="128"/>

<label > PEN </label>
<input type="text" id="PEN" name="PEN" value="<%=hrTransferApprovedList.get(0).getEmployee().getPEN() != null ? hrTransferApprovedList.get(0).getEmployee().getPEN() :""%>" readonly MAXLENGTH="12" class="medium3" validate="PEN,String,no" />

<label > Designation </label>
<input type="text" id="designation" name="designation" value="<%=hrTransferApprovedList.get(0).getEmployee().getRank().getRankName()%>" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />


<div class="clear"></div>

<label > Department </label>
<input type="text" id="department" name="department" value="<%=hrTransferApprovedList.get(0).getEmployee().getEmployeeDepartment().getEmpDeptName() != null ? hrTransferApprovedList.get(0).getEmployee().getEmployeeDepartment().getEmpDeptName() :"" %>" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>


<label >  Institution </label>
<input type="text" id="institute" name="institute" value="<%=hrTransferApprovedList.get(0).getTransferInstitute().getHospitalName() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="instituteId" name="instituteId" value="<%=hrTransferApprovedList.get(0).getTransferInstitute().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<label > From Institution </label>
<input type="text" id="from_institute" name="from_institute" value="<%=hrTransferApprovedList.get(0).getEmployee().getHospital().getHospitalName()%>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />
<input type="hidden" id="from_instituteId" name="from_instituteId" value="<%=hrTransferApprovedList.get(0).getEmployee().getHospital().getId() %>" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<div class="clear"></div>

<label > Joining Date </label>
<input type="text" id="joining_date" name="joining_date" value="<%=hrTransferApprovedList.get(0).getJoiningDate()!=null?(HMSUtil.getDateFormat(hrTransferApprovedList.get(0).getJoiningDate(),"dd/MM/yyyy")):""  %>" MAXLENGTH="12" class="medium3" validate="Joining Date,String,no" readonly/>
<%} %>
<label > Actual Joining Date <span>* </span></label>

 <input type="text" id="actualJoiningDate" value="<%=dateCal+"/"+month+"/"+year%>" name="actualJoiningDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empJoin.actualJoiningDate,event)" validate="Pick a date" class="calender" />

<!-- <label >Joining Time </label> -->
<input type="hidden" id="joining_time" name="joining_time" value="" MAXLENGTH="5" onkeyup="mask(this.value,this,'2',':');"	 class="medium3" validate="Joining Time,String,no" />



<label >Session <span>*</span></label>
		<select  name="session" 	tabindex=1  id="session" 	  validate="Session,String,yes" />
		<option value="">Select</option>
		<%for(MasOpSession mos : sesList){ %>
			<option value='<%=mos.getId()%>'><%=mos.getSessionName()%></option>
		<%} %>
		
		 </select>
<div class="clear"></div>
<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="12" class="medium3" validate="Remarks,String,no" />
<input type="hidden" id="mode" name="mode" value="<%=mode %>" MAXLENGTH="12" class="medium3" validate="Remarks,String,no" />

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
<div class="clear"></div>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('empJoin','/hms/hrms/training?method=saveEmpJoining')"  />

<!-- <input name="button"  type="button"	value="Reset" class="button"	onclick=""; />
<input name="Send" type="button" class="button" value="Upload" onClick="javascript:openPopupWindow();" /> -->

<div class="clear"></div>
<!-- <form name="itemGrid" method="post"> -->


<div class="paddingTop15"></div>


<div class="clear"></div>

	
<!-- <div class="tableForTab" style="width:984px;"   >

</div> -->




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

function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}

<%-- function populateInstitute(val,row){
	
	var sel = document.getElementById('instiName'+row);
	removeAllOptions(sel);
	
		
	if(val !=""){ 
		
	
			<% 
			for(MasHospital mid:hosList){%>
		
				if(<%=mid.getDistrict().getId()%> == val){<%
					if(mid.getId() != hosId){
				if(mid.getStatus().equalsIgnoreCase("y")){
				
			%>
			
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
					
			<%}}
			%>
				}
				
				<%}%>
				optionRepMan = new Option("select" , "0","true");
				sel.options.add(optionRepMan);
		
		 } 


		
	
} --%>

function openPopupWindow()
{
	var id = document.getElementById('transferApp_id').value;
	var mode = document.getElementById('mode').value;
	alert(""+id);
	var url="/hms/hrms/training?method=displaySubmitAttachment&RequestId="+id+"&mode="+mode;
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

</script>

</form>
