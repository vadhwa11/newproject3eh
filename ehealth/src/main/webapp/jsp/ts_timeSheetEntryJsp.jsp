<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingRequisition.jsp  
 * Purpose of the JSP -  This is for Time Sheet
 * @author  Rajesh
 * Create Date:  
 * Revision Date:      
 * Revision By: 
 * 
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.NumberFormat"%>

<%@page import="jkt.hrms.masters.business.Tbltimesheet"%>
<%@page import="jkt.hrms.masters.business.TbltimesheetAprl"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hrms.masters.business.MstrSite"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>


<script>
var rowId=undefined;
var status;
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
		
</script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	MasEmployee masEmployee =new MasEmployee();
	List<MstrProject> mstrProjectList = new ArrayList<MstrProject>();
	List<Tbltimesheet> tblTimeSheetList = new ArrayList<Tbltimesheet>();
	List<TbltimesheetAprl> tbltimesheetAprlList = new ArrayList<TbltimesheetAprl>();
	List prjSiteList = new ArrayList();
	List<MstrTask> prjTaskList = new ArrayList<MstrTask>();
		
	if(map.get("masEmployee") !=null){
		masEmployee = (MasEmployee) map.get("masEmployee");
	}
	if(map.get("prjTaskList") !=null){
		prjTaskList = (List<MstrTask>) map.get("prjTaskList");
	}
	if(map.get("tbltimesheetAprlList") !=null){
		tbltimesheetAprlList = (List) map.get("tbltimesheetAprlList");
	}
	

	if(map.get("tblTimeSheetList") !=null){
		tblTimeSheetList = (List) map.get("tblTimeSheetList");
	}
	
	
	if (map.get("mstrProjectList") != null) {
		mstrProjectList = (List) map.get("mstrProjectList");
	}

	if(map.get("prjSiteList") !=null){
		prjSiteList = (List<PrjSiteResMap>) map.get("prjSiteList");
	}
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message="";
	if (map.get("message") != null) {
		message = (String) map.get("message");
		
	}
	String datePrev = "";
	if (map.get("datePrev") != null) {
		datePrev = HMSUtil.convertDateToStringWithoutTime((Date) map.get("datePrev"));
		
	}
	Double appTime= new Double(0);
	Double subTime= new Double(0);
	Double blockTime= new Double(0);
	Double saveTime= new Double(0);
	Double pendTime= new Double(0);
	NumberFormat ntf = NumberFormat.getInstance();
	ntf.setMaximumFractionDigits(2);       

	ntf.setMinimumFractionDigits(2);
	ntf.setMaximumIntegerDigits(2);
	ntf.setMinimumIntegerDigits(2);
%>



<div class="titleBg">
<h2>Time Sheet Entry</h2>
<div class="Block"><a href="javascript:refreshPage();">Refresh</a>
</div>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<form name="enterTimeSheet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4><span><%=message %></span></h4>
<div class="clear"></div>
<label>Employee Name</label> <label><%=masEmployee.getFirstName()+" "+masEmployee.getLastName() %></label>
<input type="hidden" name="employeeId" id="employeeId"
	value="<%=masEmployee.getId() %>"> <label>Department</label> <label><%=masEmployee.getDepartment().getDepartmentName() %></label>
<label>Designation</label> <label class="value"><%=masEmployee.getRank().getRankName() %></label>
<div class="clear"></div>
<label>Approver</label> <label id="lineManager"><%=(masEmployee.getLineManager()==null)?"Not Mentioned":masEmployee.getLineManager().getFirstName()+" "+masEmployee.getLineManager().getLastName() %></label>
<label>Organisation</label> <label><%=masEmployee.getHospital().getHospitalName()%></label>
<label>Location</label> <label><%=(masEmployee.getLocation())!=null ?masEmployee.getLocation().getLocationName():"Not Mentioned" %></label>
<div class="division"></div>


<label><span>*</span>Date</label> <input type="text" name="date"
	id="date" readonly validate='Date,string,yes' onchange=""
	value="<%=!(datePrev.equals(""))?datePrev:HMSUtil.convertDateToStringWithoutTime(new Date())%>"
	class="date" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" id="calToDate"
	onclick="javascript:setdate('',document.enterTimeSheet.date,event)" />


<script type="text/javascript">
 function refreshPage()
{
document.location.href = 'timeSheet?method=showTimeSheetJsp';
}
  function selectForDate()
  {
	document.getElementById("project").setAttribute("validate","");
	document.getElementById("hrWorked").setAttribute("validate","");
	//document.getElementById("minWorked").setAttribute("validate","");
	document.getElementById("task").setAttribute("validate","");
   
  	submitForm('enterTimeSheet','/hms/hrms/timeSheet?method=showTimeSheetJsp');
  }
   </script> <label><span>*</span>Project</label> <select name="project"
	id="project" validate='Project,string,yes'
	onchange="getTaskList(this.value);getsiteList(this);">
	<option value="0">select</option>
	<%
	if(mstrProjectList!=null)
	{
	for(MstrProject project : mstrProjectList)
	{%>
	<option value="<%=project.getId() %>"><%=project.getPrjName()%></option>
	<%}
	}
	%>
</select> <script type="text/javascript">
	function getTaskList(val)
	{
	if(val!=0)
	{
		var orGroupId ="";
    	var x=document.getElementById("taskDiv")
	
	 //----------------------AJAX PART------------Start------
  
  	var xmlHttp;
  	try {
    	// Firefox, Opera 8.0+, Safari
    	xmlHttp=new XMLHttpRequest();
  	}catch (e){
    	// Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("taskDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("taskDiv").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("taskDiv").innerHTML = xmlHttp.responseText;
      }
    }
    var employeeId=document.getElementById("employeeId").value
    xmlHttp.open("GET","/hms/hrms/timeSheet?method=getTaskListJsp&prjId="+val+"&employeeId="+employeeId+"&"+csrfTokenName+"="+csrfTokenValue,true);
    xmlHttp.send(null)
    }
    }
	</script> <script type="text/javascript">
	
function getsiteList(obj)
{

var sel=document.getElementById("site");
removeAllOptions(sel);
sel.options.add(new Option('Select' , '0'));
	<%
	Set<MstrSite> siteList = new HashSet<MstrSite>();
	

		for( int ilop = 0; ilop<prjSiteList.size();ilop++){
			
			Object[] obj = (Object[])prjSiteList.get(ilop);
		
	%>
		
		if(obj.value == <%=(((MstrSite)obj[4]).getId())%>){
			sel=document.getElementById("site");
			removeAllOptions(sel);
			sel.options.add(new Option('Select' , '0'));
			<%siteList.add((MstrSite)obj[4]);%>
		}
	<%}%>
	<%if(siteList.size()>0)
	{
	
	for(MstrSite prjSite : siteList)
	{
		%>
		
		sel.options.add(new Option("<%=prjSite.getSiteName()%>" ,"<%=prjSite.getId()%>"));
			
	<%}
	}
	%>
	}
	function removeAllOptions(selectbox)
	{
		
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
	
	function chkProjectSelect()
	{
		if(document.getElementById("project").options[0].selected==true)
		{
			alert("Please First Select the Project");
		}
		
	}
	
	</script> <label>Site</label> <select name="site" id="site">

</select>

<div class="clear"></div>
<label><span>*</span>Task</label>
<div id="taskDiv"><select name="taskID" id="task"
	validate='Task,string,yes' " onclick="chkProjectSelect()">
	<option value="">Select</option>


</select></div>
<label><span>*</span>Hrs.Worked(hh:mm)</label> <label
	style="background-color: white; vertical-align: top; height: 12px;">
<input type="text" name="hrWorked" value=""
	style="width: 20px; height: 12px" id="hrWorked" maxlength="2"
	onkeyup="switchToMins(this);" onblur="chkHrs(this);"
	validate='Hrs. Worked,float,yes'> <input type="text"
	name="minWorked" value="" style="width: 20px; height: 12px"
	id="minWorked" maxlength="2" onblur="chkMinutes(this);"></label> <label>Comments</label>
<input type="text" name="comment" id="comment" maxlength="1000">

<div class="clear"></div>


<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="submitButtonDiv" style="display: block;"><input
	type="button" name="apply" value="Save" class="button"
	onclick="chkHrsWorkrd();" /></div>
<div id="editButtonDiv" style="display: none;"><input
	type="button" name="edit" value="Modify" class="button"
	onclick="submitToUpdate();" /></div>
<input type="button" name="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" /> <input type="button" name="prvsRecord"
	value="Previous/Post Date Time Sheet" class="buttonBig2"
	onclick="selectForDate()" />
</div>
<div class="division"></div>


<script type="text/javascript">
   function switchToMins(field)
   {
   	if(field.value.length===2)
   		{
   			document.getElementById("minWorked").focus();
   		}
   		
   }
    function chkHrs(field)
    {
    	if((field.value!=null) && (field.value>24))
   		{
   			alert("Hours can't be more than 24 !!");
   			field.value="";
   		}
   		if(field.value.length<2){
   		 field.value="0"+field.value
   		// field.focus();
   		}
   		
    }
   function chkMinutes(field)
   {
   		if((field.value!=null) && field.value>60)
   		{
   			alert("Minutes can't be more than 60 !!");
   			field.value="";
   		}
   		if(field.value.length<2){
   		 field.value="0"+field.value
   		// field.focus();
   		}
   }
  	function clearVal(field)
  	{
  		if(field.value==="hh:mm")
  		{
  			field.value="";
  		}
  	}
   function timeFormat(field)
   {
   
   	val=field.value;
   	//alert(field.value);
   	if(val.length<2)
   	{
   		//field.value="0"+val;
   	}
   	
   	else if(val.length===2)
   	{
   	//	field.value=val+":";
   	}
   	
   }
   function roundOffTime(field)
   {
   	val=field.value;
   	len=val.length;
   	//	alert(len);
   	hrs=val.substring(0,(val.indexOf(".") ));
  	mins=val.substring((val.indexOf("."))+1,len );
  		//	alert(hrs);
  					
  					if(mins>60)
  					{	
  			//			alert(parseInt(mins/60))
  			//			alert(Math.abs(mins%60));
  					}
	//alert(val.substring(0,(val.indexOf(".")) ));
   	 
   }
    function submitToUpdate()
   {
  		var enteredHrs= 0.0
  		var enteredMin= 0.0
   		var previousHrs= 0.0
    enteredHrs =parseFloat(document.getElementById("hrWorked").value)-hrs;
   	enteredMins =parseFloat(document.getElementById("minWorked").value)-mins;
   	if(document.getElementById("blockTime")!=null)
   	{
   		previousHrs= parseFloat(document.getElementById("blockTime").value);
   	}
   if(enteredMins==60)
   	{
   		enteredHrs=enteredHrs+1;
   	}
   	if(enteredMins<60 && enteredMins>0)
   	{
   		enteredHrs=enteredHrs+(enteredMins/100);
   		
   	}
   	if((previousHrs + enteredHrs) > 24 )
   	{
   		alert("You can't save more than 24hrs Time sheet!.You have already saved time sheet for "+previousHrs+" hours.");
   		
   	}
   	else if((previousHrs + enteredHrs)<= 24 ){
   	var employeeId=document.getElementById("employeeId").value;
    url = "timeSheet?method=editTimeSheet&rowId="+rowId+"&employeeId="+employeeId+"";
    submitForm('enterTimeSheet',url);	
    }
   }
   function chkHrsWorkrd()
   {
  
  // alert(document.getElementById("saveTime").value);
  		var enteredHrs= 0.0
  		var enteredMin= 0.0
   		var previousHrs= 0.0
   		//var previousMins= 0.0
   		document.getElementById("project").setAttribute("validate","Project,string,yes");
    document.getElementById("date").setAttribute("validate","Date,string,yes");
	document.getElementById("hrWorked").setAttribute("validate","Hrs. Worked,float,yes");
	document.getElementById("task").setAttribute("validate","Task,string,yes");
   
    enteredHrs =parseFloat(document.getElementById("hrWorked").value);
   	enteredMins =parseFloat(document.getElementById("minWorked").value);
   	if(enteredMins==60)
   	{
   		enteredHrs=enteredHrs+1;
   	}
   	if(enteredMins<60 && enteredMins>0)
   	{
   		enteredHrs=enteredHrs+(enteredMins/100);
   		
   	}
   	if(document.getElementById("blockTime")!=null)
   	{
   		previousHrs= parseFloat(document.getElementById("blockTime").value);
   	}
   if(!isNaN(previousHrs) && !isNaN(previousHrs) )
   {
   	if((previousHrs + enteredHrs) > 24 )
   	{	
   		alert("You can't save more than 24hrs Time sheet!.You have already saved time sheet for "+previousHrs+" hours.");
   	}
   	 if((previousHrs + enteredHrs)<= 24)
   	{
   		 	var employeeId=document.getElementById("employeeId").value;
   		submitForm('enterTimeSheet','timeSheet?method=submitTimeSheet&status=save&employeeId='+employeeId+'');
   		//refreshPage();
   	}
   	 if(isNaN(enteredHrs))
   	{
   
   	alert("Please Enter Numeric values as working hours");
   	}
   	}
     }
   </script>
<script type="text/javascript">
  
   
   function resetCheck()
   {
      document.getElementById("date").value="";
      document.getElementById("hrWorked").value="";
      
      if( typeof (document.getElementById("task").options[0])!== 'undefined')
     	{
      	document.getElementById("task").options[0].selected=true;
        }
     	if( typeof (document.getElementById("project").options[0])!== 'undefined')
     	{
      	document.getElementById("project").options[0].selected=true;
      }
      document.getElementById("comment").value="";
      document.getElementById("submitButtonDiv").style.display="block";
      document.getElementById("editButtonDiv").style.display="none";
      
   }
  function submitRow()
   {
   if(document.getElementById("lineManager").innerHTML!="Not Mentioned")
   {
 		if(typeof rowId !== 'undefined' || rowId)
			{
				document.getElementById("date").setAttribute("validate","");
				document.getElementById("hrWorked").setAttribute("validate","");
				//document.getElementById("minWorked").setAttribute("validate","");
				document.getElementById("project").setAttribute("validate","");
				document.getElementById("task").setAttribute("validate","");
				
				if(document.getElementById("blockTime")!=null && document.getElementById("blockTime").value <= 24)
				{
				var employeeId=document.getElementById("employeeId").value;
      			url = "timeSheet?method=submitTimeSheet&status=submit&employeeId="+employeeId+"";
      			
				submitForm('enterTimeSheet',url);	
				}else{
				alert("Your Time sheet exceeding time Limit");
      			}
		   }
		else{
			 alert("Please select atleast 1 record");
	 		return false;
		}
		}else{
		alert("Approver is not Mentioned.Please Contact Your Manager");
		}
   }
   function deleteRow()
   {
 		if(typeof rowId !== 'undefined' || rowId)
			{
				document.getElementById("date").setAttribute("validate","");
				document.getElementById("hrWorked").setAttribute("validate","");
				//document.getElementById("minWorked").setAttribute("validate","");
				document.getElementById("project").setAttribute("validate","");
				document.getElementById("task").setAttribute("validate","");
      			var employeeId=document.getElementById("employeeId").value;
      			url = "timeSheet?method=submitTimeSheet&status=delete&employeeId="+employeeId+"";
				submitForm('enterTimeSheet',url);	
		   }
		else{
			 alert("Please select atleast 1 record");
	 		return false;
		}
   }
   function submitThisForm()
   {
	var i=0;
		var employeeId=document.getElementById("employeeId").value;
	submitForm('enterTimeSheet','timeSheet?method=submitTimeSheet&employeeId='+employeeId+'');
	}
   </script>

<% BigDecimal workHrs =new BigDecimal(0);
	if(tblTimeSheetList!=null && tblTimeSheetList.size() > 0)
	{
		
%>
<input type="hidden" value="<%= tblTimeSheetList.size()%>"
	name="listSize" id="listSize" />
<%
NumberFormat nf = NumberFormat.getInstance();

nf.setMaximumFractionDigits(2);       

nf.setMinimumFractionDigits(2);

for(Tbltimesheet obj:tblTimeSheetList)
{
	if(obj.getStatus().equalsIgnoreCase("Approved"))
	{
		//appTime=appTime.add(obj.getHrsWorked());	
		double tempHrs=0;
		appTime=appTime+obj.getHrsWorked().doubleValue();
		int temp = appTime.intValue();
		tempHrs=appTime.intValue();
		Double rem=null;
		if(temp!=0)
		{
		 rem = new Double(appTime%temp);
		}
		else
		{
			 rem=appTime;
		}
		//Double rem = new Double(appTime%temp);
		rem = new Double(nf.format(rem));
		
		if(rem==0.60)
		{
			tempHrs++;
			
			
		}
		if(rem > 0.60)
		{
			tempHrs++;
			double pt= new Double(nf.format(rem-0.60));
			tempHrs=tempHrs+pt;
			
		}
		if( rem <0.60 )
		{
			tempHrs=tempHrs+rem;
		}
		appTime=tempHrs;	
	}
	if(obj.getStatus().equalsIgnoreCase("saved") || obj.getStatus().equalsIgnoreCase("back")||obj.getStatus().equalsIgnoreCase("forwarded"))
	{
		
		 
		double tempHrs=0;
		saveTime=saveTime+obj.getHrsWorked().doubleValue();
		int temp = saveTime.intValue();
		tempHrs=saveTime.intValue();
		Double rem =null;
		if(temp!=0)
		{
		 rem = new Double(saveTime%temp);
		}
		else
		{
			 rem=saveTime;
		}
		//Double rem = new Double(saveTime%temp);
		if(!rem.isNaN()){
		rem = new Double(nf.format(rem));
		}
		if(rem==0.60)
		{
			tempHrs++;
			
			
		}
		if(rem > 0.60)
		{
			tempHrs++;
			double pt= new Double(nf.format(rem-0.60));
			tempHrs=tempHrs+pt;
			
		}
		if(rem <0.60)
		{
			tempHrs=tempHrs+rem;
		}
		saveTime=tempHrs;	
	}
	if(obj.getStatus().equalsIgnoreCase("submitted"))
	{
		//subTime=subTime+obj.getHrsWorked().doubleValue();
		
		double tempHrs=0;
		subTime=subTime+obj.getHrsWorked().doubleValue();
		int temp = subTime.intValue();
		tempHrs=subTime.intValue();
		Double rem =null;
		if(temp!=0)
		{
		 rem = new Double(subTime%temp);
		}
		else
		{
			 rem=subTime;
		}
		if(!rem.isNaN())
		{
		rem = new Double(nf.format(rem));
		}
		if(rem==0.60)
		{
			tempHrs++;
			
			
		}
		if(rem > 0.60)
		{
			tempHrs++;
			double pt= new Double(nf.format(rem-0.60));
			tempHrs=tempHrs+pt;
			
		}
		if(rem <0.60)
		{
			tempHrs=tempHrs+rem;
		}
		subTime=tempHrs;	
	}
	
		blockTime=saveTime+(subTime)+(appTime);
		double tempHrs=0;
		//subTime=subTime+obj.getHrsWorked().doubleValue();
		int temp = blockTime.intValue();
		tempHrs=blockTime.intValue();
		Double rem=null;
		if(temp!=0)
		{
		 rem = new Double(blockTime%temp);
		}
		else
		{
			 rem=blockTime;
		}
		//Double rem = new Double(blockTime%temp);
		if(!rem.isNaN()){
		rem = new Double(nf.format(rem));
		}
		if(rem==0.60)
		{
			tempHrs++;
			
			
		}
		if(rem > 0.60)
		{
			tempHrs++;
			double pt= new Double(nf.format(rem-0.60));
			tempHrs=tempHrs+pt;
			
		}
		if(rem <0.60)
		{
			tempHrs=tempHrs+rem;
		}
		blockTime=tempHrs;	
	//double tempblock= blockTime.doubleValue();

	//BigDecimal reminder=(blockTime.remainder(new BigDecimal(blockTime.intValue())));
	//(reminder);
	//if(reminder.compareTo(new BigDecimal(0.60))>=0)
//	{
//		blockTime=blockTime.add(new BigDecimal(1));
//		BigDecimal temp = reminder.subtract(new BigDecimal(0.60));
//		
//		blockTime=blockTime.subtract(temp);
		
//	}
	//pendTime= saveTime.subtract(subTime);
	//balTime= balTime.subtract(subTime);
	
}

%>
<input type="hidden" id="saveTime" value="<%=saveTime %>"> <input
	type="hidden" id="subTime" value="<%=subTime %>"> <input
	type="hidden" id="pendTime" value="<%=pendTime %>"> <input
	type="hidden" id="appTime" value="<%=appTime %>"> <input
	type="hidden" id="blockTime" value="<%=blockTime %>"> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Time
Blocked: <%=ntf.format(blockTime.doubleValue()) %></label> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Time
Submitted:<%=(subTime.doubleValue()<0)?00.00:ntf.format(subTime.doubleValue()) %></label><label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Not
Submitted: <%= ntf.format(saveTime.doubleValue())%></label><label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Approved
Time: <%=ntf.format(appTime.doubleValue()) %></label>
<div id="clear"></div>
<div id="pageNavPosition"></div>
<table id="leaveTypeList">
	<tr>
		<th><input type="checkbox" id="selectAll" class="radioCheck"
			onclick="selectAllRec(this);"> Select</th>
		<th>Date</th>
		<th>Project</th>
		<th>Site</th>
		<th>Task</th>
		<th>Hrs. Worked</th>
		<th>Status</th>
		<th>Comments</th>
	</tr>
	<tbody id="tableData">
		<%int i=1;
		String comment="";
		int status =0;
		for(Tbltimesheet obj : tblTimeSheetList){
			if(!obj.getStatus().equalsIgnoreCase("rejected"))
			{
				workHrs = workHrs .add(obj.getHrsWorked());
				if(obj.getComments()!=null && !(obj.getComments().equals("")))
				{
					comment=obj.getComments();
					if(obj.getStatus().equalsIgnoreCase("Saved")||obj.getStatus().equalsIgnoreCase("submitted"))
					{
						status=1;
					}
					else{
						status=0;
					}
				}
				else{
					
					comment="-";
				}
			}
			int count=0;
			if(tbltimesheetAprlList!=null && tbltimesheetAprlList.size()>0 )
			{
				for(TbltimesheetAprl tblApp : tbltimesheetAprlList)
				{
					if( obj.getId().equals(tblApp.getTmshtId()))
					{	
						if((status==1) && ((tblApp.getTaStatus().equalsIgnoreCase("back"))||(tblApp.getTaStatus().equalsIgnoreCase("submitted"))))
						{
							
						}else{
						count++;
						if(!tblApp.getAppCmts().equalsIgnoreCase("")){
							
						comment= tblApp.getAppCmts();
						}
						
						}
					}
				}
				if(count==0)
				{
					//comment="";
				}
			}
			
		if(i%2==0)
		{%>
		<tr class="odd"
			onclick="populate('<%=i%>',<%=obj.getId()%>,<%= (obj.getProjectID()!=null?obj.getProjectID().getId():0)%>,<%=(obj.getTaskID()!=null?obj.getTaskID().getId():0) %>,<%=(obj.getSiteID()!=null? obj.getSiteID().getId():0)%>,'<%=obj.getComments()%>','<%=HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate()) %>',<%=obj.getHrsWorked() %>,'<%=obj.getStatus() %>');">
			<%}else{%>
			<tr class="even"
				onclick="populate('<%=i%>',<%=obj.getId()%>,<%= (obj.getProjectID()!=null?obj.getProjectID().getId():0)%>,<%=(obj.getTaskID()!=null?obj.getTaskID().getId():0) %>,<%=(obj.getSiteID()!=null? obj.getSiteID().getId():0)%>,'<%=obj.getComments()%>','<%=HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate()) %>',<%=obj.getHrsWorked() %>,'<%=obj.getStatus() %>');">
				<%} 
		if(obj.getStatus().equalsIgnoreCase("saved")||obj.getStatus().equalsIgnoreCase("back"))
		{
		%>
				<td><input type="checkbox" style="background-color: maroon;"
					name="chkAction<%=i%>" id="chkAction<%=i%>"
					value="<%=obj.getId()%>"
					onclick="selectRow('<%=obj.getStatus() %>','<%=i %>');"></td>
				<%} else{%>
				<td><input type="checkbox" disabled="disabled"
					name="chkAction<%=i%>" id="chkAction<%=i%>"
					value="<%=obj.getId()%>"
					onclick="selectRow('<%=obj.getStatus() %>','<%=i %>');"></td>
				<%} %>
				<td><%=HMSUtil.convertDateToStringWithoutTime(obj.getEntryDate()) %></td>
				<td><%=obj.getProjectID().getPrjName() %></td>
				<%if(obj.getSiteID()!=null){ %>
				<td><%=obj.getSiteID().getSiteName() %></td>
				<%}else{ %>
				<td>-------</td>
				<%} %>
				<td><%=obj.getTaskID().getTaskName() %></td>
				<td><%=ntf.format(obj.getHrsWorked().doubleValue()) %></td>
				<td><%=obj.getStatus() %></td>
				<td><%=comment %></td>
			</tr>
			<%i++;
		}%>
			<input type="hidden" value="<%=workHrs%>" name="prvHrsWorked"
				id="prvHrsWorked" />
			<%	}else{ %>
			<h4>No Record Found</h4>
			<input type="hidden" value="<%=0%>" name="prvHrsWorked"
				id="prvHrsWorked" />
			<%} %>
		
	</tbody>

</table>
<script type="text/javascript">
	function selectAllRec(field)
	{
	rowId=0
	//alert(rowId);
	val = document.getElementById("listSize").value;
	
	for(i=1;i<=val;i++)
	{
		
		if(field.checked)
			{
				if(!document.getElementById('chkAction'+i).disabled)
					   {
					   	document.getElementById('chkAction'+i).checked='checked';
					   }
		   	}
		   		if(!field.checked)
				{
					   	document.getElementById('chkAction'+i).checked='';
		   		}
			
		
		
		
	}
	}
</script>
<div class="clear"></div>

<input type="button" name="Submit" value="Submit" class="button"
	onclick="submitRow();" /> <input type="button" name="delete"
	value="Delete" class="button" onclick="deleteRow();" />
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
	function selectRow(status,index)
	{
		var str="chkAction"+index;
		//alert(document.getElementById(str).value);
		//alert(str);
		if(status ==="Back" || status ==="Saved")
		{
			
			return true;
		}else{
			
			alert("You cannot update "+status +" time sheet");
			//document.getElementById(str).checked=false;
			return false;
		}
	}
	var hrs;
	var mins;
	function populate(index,rId,valId,taskId,siteId,comment,date,hours,status)
	{
	
	
	  
	
	if(status ==="Back" || status ==="Saved")
	{
	 document.getElementById("submitButtonDiv").style.display="none";
	document.getElementById("editButtonDiv").style.display="block";
		rowId= rId;
		status=status
		
		tt= hours+"";
		
			len=tt.length;
			if(tt.indexOf(".")>0)
			{
			  hrs=tt.substring(0,(tt.indexOf(".") ));
			  mins=tt.substring((tt.indexOf("."))+1,len );
			}else{
			hrs=tt;
			mins=00;
			}
		
		
	  document.getElementById("date").value=date;
	  if(hrs.length<2)
	  {
	  document.getElementById("hrWorked").value="0"+hrs;
	  }
	  else{
	  document.getElementById("hrWorked").value=hrs;
	  }
	   document.getElementById("minWorked").value=mins;
	 var k =0;
	  while(k < document.getElementById("site").length)
	  {
	  	 if(document.getElementById("site").options[k].value == siteId )
	 	 {
	       document.getElementById("site").options[k].selected= true;
	  	 }
	  	k=k+1;
	  }
	   var j =0;
	  while(j < document.getElementById("task").length)
	  {
	  	 if(document.getElementById("task").options[j].value == taskId )
	 	 {
	       document.getElementById("task").options[j].selected= true;
	  	 }
	  	j=j+1;
	  }
	  
	  document.getElementById("comment").value=comment;
	  	
	 return true;
	}else{
	document.getElementById("editButtonDiv").style.display="none";
	 document.getElementById("submitButtonDiv").style.display="block";
	 
		alert("You cannot update "+status +" time sheet");
	
	}
	  
	}

	</script> <script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>