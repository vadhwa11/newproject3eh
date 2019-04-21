<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferByHinNo.jsp
 * Purpose of the JSP -  This is for Transfer By HIN.
 * @author  Ritu
 * Create Date: 07th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.9
--%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Transfer"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasBed> bedList = new ArrayList<MasBed>();
	List<Transfer> transferNoList = new ArrayList<Transfer>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Transfer> transferList = new ArrayList<Transfer>();
	List<Transfer> transferListForDuplicate = new ArrayList<Transfer>();
	
	List<MasAuthorizer> authorizerList = new ArrayList<MasAuthorizer>();

	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");


	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	
	

	if(patientMap.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)patientMap.get("inpatientList");
		session.setAttribute("inpatientList", inpatientList);
	}else if(session.getAttribute("inpatientList") != null){
		inpatientList = (List<Inpatient>)session.getAttribute("inpatientList");
	}
%>


<h2>Ward / Bed Transfer</h2>
<div class="clear"></div>

<%
	try{
	if(inpatientList != null && inpatientList.size() > 0){
		
		Inpatient inpatient = inpatientList.get(0);
		session.setAttribute("inpatient",inpatient);
		Patient patient = inpatient.getHin();
		String bedNo=inpatient.getBed().getBedNo();
		String age = "";
		String currentAge = "";
		if(patient.getAge() != null){
		age = patient.getAge();
		}
		try{
		if(age != null && !age.equals("")){	
		currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(detailsMap.get("transferListForDuplicate") != null){
			transferListForDuplicate = (List<Transfer>)detailsMap.get("transferListForDuplicate");
		}
		if(transferListForDuplicate.size()==0)
		{
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("bedList") != null){
			bedList = (List<MasBed>)detailsMap.get("bedList");
		}
		if(detailsMap.get("transferNoList") != null){
			transferNoList = (List<Transfer>)detailsMap.get("transferNoList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<MasEmployee>)detailsMap.get("employeeList");
		}
		if(detailsMap.get("authorizerList") != null){
			authorizerList = (List<MasAuthorizer>)detailsMap.get("authorizerList");
		}
		if(patientMap.get("transferList") != null){
			transferList = (List<Transfer>)patientMap.get("transferList");
		}
		
		int transferNo = 0;
		if(transferNoList.size() > 0){
			for(Transfer transfer : transferNoList){
				transferNo = transfer.getTransferNo()+1;
			}
		}else{
			transferNo = 1;
		}

		String adNo = "";
		Integer inpatientId = 0;
		String admissionDate = "";
		String admissionTime = "";

		adNo = inpatient.getAdNo();
		inpatientId = inpatient.getId();
		admissionDate = HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		admissionTime = inpatient.getTimeOfAddmission();


	%>


<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="Block">

<div class="clear"></div>

<%-- <label class="auto">Transfer No.</label> 
<label	class="valueAuto"><%=transferNo %></label>  --%>

<div class="clear"></div>
<div class="paddingTop25"></div>
<jsp:include page="searchResultBlock.jsp"  />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
 <form name="admissionAcceptance" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"uhid"], [2,"pname"],[3,"ipdno"],[4,"transfertype"],[5,"fward"]
			,[6,"fbed"],[7,"tward"],[8,"remarks"],[9,"status"]];
	 statusTd = 9;
	</script>
	</form>
</div>

<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "uhid";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "20%";
	data_header[1][3] = "pname";
	
	data_header[2] = new Array;
	data_header[2][0] = "IP No."
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "ipdno";
	
	data_header[3] = new Array;
	data_header[3][0] = "Transfer Type"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "transfertype";
	
	data_header[4] = new Array;
	data_header[4][0] = "From ward"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "fward";
	
	data_header[5] = new Array;
	data_header[5][0] = "From Bed"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "fbed";
	
	data_header[6] = new Array;
	data_header[6][0] = "To ward"
	data_header[6][1] = "data";
	data_header[6][2] = "20%";
	data_header[6][3] = "tward";

	data_header[7] = new Array;
	data_header[7][0] = "Remarks"
	data_header[7][1] = "data";
	data_header[7][2] = "20%";
	data_header[7][3] = "remarks";
	
	data_header[8] = new Array;
	data_header[8][0] = "Status"
	data_header[8][1] = "data";
	data_header[8][2] = "20%";
	data_header[8][3] = "status";
	
	data_arr = new Array();
	<%
	if(transferList.size()>0)
	{
		int j=0;
		%>
		
		<%
		for(Transfer transfer:transferList)
		{
			String transferPatientname="";
			if(transfer.getHin().getPFirstName()!=null)
			{
		 transferPatientname=transfer.getHin().getPFirstName();
			}
		if(transfer.getHin().getPMiddleName()!=null){
			transferPatientname += " "+transfer.getHin().getPMiddleName();
		}
		if(transfer.getHin().getPLastName()!=null){
			transferPatientname += " "+transfer.getHin().getPLastName();
	}
	%>
	
	    
		data_arr[<%=j%>] = new Array();
		data_arr[<%=j%>][0] = "<%=transfer.getHin().getId()%>"
		data_arr[<%=j%>][1] = '<%=transfer.getHin().getHinNo()%>'
		data_arr[<%=j%>][2] ="<%=transferPatientname%>"
		data_arr[<%=j%>][3] = "<%=transfer.getInpatient().getAdNo()%>"
		data_arr[<%=j%>][4] = "<%=transfer.getTransferType()%>"
		data_arr[<%=j%>][5] = "<%=transfer.getFromWard().getDepartmentName()%>"
		data_arr[<%=j%>][6] = "<%=transfer.getFromBed().getBedNo()%>"
		data_arr[<%=j%>][7] = "<%=transfer.getToWard().getDepartmentName()%> "
		data_arr[<%=j%>][8] = " "
		<%if(transfer.getRequestStatus().equalsIgnoreCase("p"))
		{
		%>
		data_arr[<%=j%>][9] = "Pending"
		<%} else if(transfer.getRequestStatus().equalsIgnoreCase("r"))
		{
		%>
		data_arr[<%=j%>][9] = "Rejected";
		<%}%>
		<%
		j++;
		}
		
	}
	%>
		
		
		
	
    formName = "admissionAcceptance"
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script> 
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<div class="clear"></div>
<h4>Transfer Schedule</h4>
<div class="clear"></div>
<form name="transferByHin" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" validate="hinId,int,no"/>
<input type="hidden" name="<%=AD_NO %>" value="<%=adNo%>" validate="adNo,string,no"/>
<input type="hidden" name="<%=INPATIENT_ID%>" value="<%=inpatientId%>" validate="inpatientId,int,no"/>
<label ><span>*</span> Transfer Date</label> 
<input type="text" id="tdate" name="<%=TRANSFER_DATE %>" tabindex="1" value="<%=currentDate %>" class="date" readonly="readonly" validate="Transfer Date,date,yes" MAXLENGTH="30"  />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('<%=currentDate %>',document.transferByHin.<%=TRANSFER_DATE%>,event)"	tabindex="1" />
<label class="">Transfer Time</label>
<input	type="text" class="date" name="<%=TRANSFER_TIME%>" value="<%=currentTime%>"	onKeyUp="mask(this.value,this,'2,5',':');" validate="Transfer Time,string,yes" 	 MAXLENGTH="8" />
<label class="">Admission Date</label> 
<label class="value"><%=admissionDate%></label>
<div class="clear"></div>
<label class="">Admission Time</label> <label class="value"><%=admissionTime %></label>

<label class="">Transfer Type</label> 
<select onchange="changeTransferType(this.value);" id="transferType" name="transferType">
<option value="bed">
Bed To Bed
</option>

<option value="ward" validate="Transfer Type,string,yes">
Ward To Ward
</option>
</select>


<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>

<%@include file="PatientDetails.jsp" %>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Transfer Details</h4>
<div class="clear"></div>



<div>
<label id="fromwardlabel" style="display: none;">From Ward</label>

 <input type="text" id="fromwardvalue" style="display: none;"	name="fromWardName"	value="<%=inpatient.getDepartment().getDepartmentName() %>"
	 class="readOnly" readonly="readonly" validate="fromWardName,metachar,no"/>
		
	<label id="frombedlabel">From Bed No.</label> 
	<label id="frombedvalue" class="value"><%=bedNo%></label>

<label id="towardlabel" style="display: none;"><span>*</span>  To Ward</label>

<select name="<%=TO_WARD %>"
	onchange="" id="wardId" style="display: none;"
	>
	<option value="0">Select</option>
	<%
				for (MasDepartment  masDepartment : departmentList){
					if(masDepartment.getDepartmentType() != null){
						if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
			%>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
					}
			}%>
			</select>
			
<%--  <select name="<%=TO_WARD %>"
	onchange="checkWardForTransfer(this.value);checkBed();" id="wardId"
	validate="To Ward,String,yes">
	<option value="0">Select</option>
</select>  --%>

<label id="tobedlabel" >To Bed No.</label> 
<input type="hidden"  name="<%=BED_ID%>" id="<%=BED_ID%>" class="" 
				readonly="readonly" />
				 <input type="text"  name="<%=TO_BED%>" id="<%=TO_BED%>" onclick="getAvailableBed();" class=""  readonly="readonly" />


<label id="reasonlabel">Reason For Transfer</label> 

<input type="text" name="reason" id="reason" validate="Transfer Reason,string,no" maxlength="80"/>
<!-- <select name="reason" id="reason" validate="Transfer Reason,string,yes">
<option value="Nurse Request">
Nurse Request
</option>

<option value="Patient Request">
Patient Request
</option>

<option value="Care Request">
Care Request
</option>

<option value="Doctor Request">
Doctor Request
</option>
</select> -->
 <label id="autherizerlabel"> Authorized By
 </label> 
 <select
	name="<%=AUTHORIZER_ID %>" validate="Authorized By,string,no">
	<option value="0">Select</option>
	<%
		for (MasEmployee  obj : employeeList){
			if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
				String doctorMiddleName = "";
				String doctorLastName = "";
				if(obj.getMiddleName()!= null){
					doctorMiddleName = obj.getMiddleName();
				}
				if(obj.getLastName()!= null){
					doctorLastName = obj.getLastName();
				}
	%>
	<option value="<%=obj.getId ()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<% }
	}%>
</select>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<input type="button" name="Submit" value="Submit" class="button" onclick="submitBedTransfer();" />
	<input type="reset" class="button" name="reset" value="reset" onclick="submitFormForButton('transferByHin','ipd?method=getTransferScreen');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('transferByHin','ipd?method=showPatientListNurseJsp');"/>
	
	<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
</form>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4><span><%=map.get("message") %></span></h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
 <%} }else{
		%>
		<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<h4><span>Patient is Ready to Discharge</span></h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<%}
	}catch(Exception ee){
		ee.printStackTrace();
	}
		 %>
<div id="statusMessage">
<h4></h4>
</div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
var bedsts=false;
var rcompleted=false;
function changeTransferType(transfertype)
{
	if(transfertype=='bed')
		{
		document.getElementById("fromwardlabel").style.display="none";
		document.getElementById("fromwardvalue").style.display="none";
		document.getElementById("towardlabel").style.display="none";
		document.getElementById("wardId").style.display="none";
		document.getElementById("tobedlabel").style.display="inline-block";
		document.getElementById("<%=TO_BED%>").style.display="inline-block";
		
		}else if(transfertype=='ward')
		{
			document.getElementById("fromwardlabel").style.display="inline-block";
			document.getElementById("fromwardvalue").style.display="inline-block";
			document.getElementById("towardlabel").style.display="inline-block";
			document.getElementById("wardId").style.display="inline-block";
			document.getElementById("tobedlabel").style.display="none";
			document.getElementById("<%=TO_BED%>").style.display="none";
		}
}

function submitBedTransfer(){
	/*checkBedAvailibility();
	
	 setTimeout(function(){
	   if(rcompleted)
		   {
		   alert('request is completed');
		   }
	   else
		   {
		   alert('request is incompleted');
		   }
	}, 100); */
		applyValidation();
		submitForm('transferByHin','/hms/hms/adt?method=submitTransferInformation');
}



<%-- function checkBedAvailibility()
{		
	bedsts=false;
	rcompleted=false;
	if(document.getElementById("transferType").value=='bed')
		{
	var bedId=document.getElementById("<%=BED_ID%>").value
		new Ajax.Request('/hms/hms/ipd?method=checkBedStatus&bedId='+bedId, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  alert(response.responseText.trim());
	    	    	  bedsts= false;
	    	    	  }
	    	      else
	    	    	  {
	    	    	  bedsts= true;
	    	    	  }
	    	      rcompleted=true;
	    	    	  
	    	  }
	    	});
	
		}
	else
		{
		bedsts=true;
		rcompleted=true;
		alert('completed');
		}
	    	return true;
} --%>

function applyValidation()
{
	if(document.getElementById("transferType").value=='ward')
		{
		 document.getElementById('<%=TO_BED%>').setAttribute("validate", "Bed,string,no");
		 document.getElementById('wardId').setAttribute("validate", "Ward,int,yes");
		}
	else
		{
		document.getElementById('<%=TO_BED%>').setAttribute("validate", "Bed,string,yes");
		 document.getElementById('wardId').setAttribute("validate", "Ward,int,no");
		}
}

function getAvailableBed(){
	var sessionWard=<%=(Integer)session.getAttribute(DEPT_ID)%>;
	if(document.getElementById("transferType").value=='ward')
		{
		return;
		}
	var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
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
	      if(xmlHttp.readyState==4){
	      
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
		        var bedId  = item.getElementsByTagName("bedId")[0];
		        
		       if(bedStatus.childNodes[0].nodeValue=='yes'){
		    		openPopupWindowForBedSelection(sessionWard);
		       //	document.getElementById("bedId").value=bedId.childNodes[0].nodeValue
		       return true
		       }else{
		       	alert("No Bed Available in this ward..!")
		       	document.getElementById("wardId").selectedIndex=0
		       		document.getElementById("bedId").value=0
		       	return false;
		       }
	        	
	      	} 
	      }
	      }
	    var url="/hms/hms/adt?method=chechBed&wardId="+sessionWard;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	     
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	}
 
</script>
 