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

<%@page import="jkt.hms.masters.business.HrMasTransferNotification"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
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
	List<MasEmployee> suspendByList = new ArrayList<MasEmployee>();
	 	
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
	
	if(map.get("suspendByList") != null){
		suspendByList = (List<MasEmployee>)map.get("suspendByList");
	} 
	
	/* if(map.get("hrTransferApplicationMList") != null){
		hrTransferApplicationMList = (	List<MasEmployee>)map.get("hrTransferApplicationMList");
	} */
	
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	 
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Termination Order Entry</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar"> 
<form name="empTerminate" method="post" enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label ><span>* </span> PEN </label>
<input type="text" id="PEN" name="PEN" value=""  MAXLENGTH="12" class="medium3" validate="PEN,String,yes" onblur="getEmpInfoByAjax(this.value);"/>

<label><span>* </span>Employee Name </label>
<input type="text" id="empName" name="empName" value=""  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value=""  readonly class="medium3"  MAXLENGTH="128"/>
 
<label > <span>* </span> Designation </label>
<input type="text" id="designation" name="designation" value="" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly onblur="getSuspendByList()" />
 
<div class="clear"></div>
<label ><span>*</span> Department </label>
<input type="text" id="department" name="department" value="" MAXLENGTH="12" class="medium3" validate="Department,String,yes" readonly/>
 
<label ><span>*</span> Institution </label>
<input type="text" id="institute" name="institute" value="" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="instituteId" name="instituteId" value="" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />
<div id="testDiv">
<label > <span>*</span> Order Issued By </label>
<select  name="suspendBy" 	tabindex=1  id="suspendBy" 	  validate="Order Issued By,string,yes" />
<option value="">Select</option>
<option value="1">Order By GOK</option>
 </select>
</div>
<div class="clear"></div>
<label > <span>*</span> Effective From date </label>
<input type="text" id="fromDate" value="<%=dateCal+"/"+month+"/"+year%>" name="fromDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,yes"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empTerminate.fromDate,event)" validate="Pick a date" class="calender" />
 <label ><span>*</span>Order No </label>
<input type="text" id="order_no" name="order_no" value="" MAXLENGTH="30" class="medium3" validate="Order No,String,Yes" />
<label ><span>*</span> Order Date </label>
<input type="text" id="orderDate" value="<%=dateCal+"/"+month+"/"+year%>" name="orderDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empTerminate.orderDate,event)" validate="Pick a date" class="calender" />

<div class="clear"></div>
<label >Reason </label>
<input type="text" id="reason" name="reason" value="" MAXLENGTH="199" class="medium3" validate="Remarks,String,no" /> 
<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="199" class="medium3" validate="Remarks,String,no" />
<input type="hidden" id="mode" name="mode" value="Termination" MAXLENGTH="12" class="medium3" validate="Remarks,String,no" />

</form> 
</div>
</div>
</div>

<div class="clear"></div>
<input type="file" name="<%= UPLOAD_FILENAME%>" id="fileNameId" class="browse" tabindex="1" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<!-- <form name="itemGrid" method="post"> -->
<input name="button"  type="button"	value="Submit" class="button"  onClick="submitForm('empTerminate','/hms/hrms/training?method=saveEmpTermination&'+csrfTokenName+'='+csrfTokenValue)"  />
<input name="reset"  type="reset"	value="Reset" />
<!--   <input name="button"  type="button"	value="Upload" class="button"	onclick="openPopupWindow();" />  --> 

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

<script type="text/javascript">
 
function getEmpInfoByAjax(pen){
	//alert(""+pen)
	     if(pen != "" ){
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
				if(items.childNodes.length >0){
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var empName  = item.getElementsByTagName("empName")[0];
		        var empId  = item.getElementsByTagName("empId")[0];
		        var desig=item.getElementsByTagName("desig")[0];
		        var depart  = item.getElementsByTagName("depart")[0];
		        var instiName  = item.getElementsByTagName("insti")[0];
		        var instiId  = item.getElementsByTagName("instiId")[0];
		      
	        	document.getElementById('empName').value = empName.childNodes[0].nodeValue
	        	document.getElementById('empid').value = empId.childNodes[0].nodeValue
 	        	document.getElementById('designation').value = desig.childNodes[0].nodeValue
	        	document.getElementById('department').value = depart.childNodes[0].nodeValue
	        	document.getElementById('institute').value = instiName.childNodes[0].nodeValue
	        	document.getElementById('instituteId').value = instiId.childNodes[0].nodeValue
	        	
	          	} 
	      }else{
	    	  alert("Please Type Correct PEN");
	      }
	      	getSuspendByList();
	      	
	      }
	    }
	     url="training?method=getEmpInfoForEmpSuspension&PEN="+pen+'&'+csrfTokenName+"="+csrfTokenValue;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	     }else{
	    	 alert("Please Type  PEN");
	     }
	 } 

	 
function getSuspendByList(){
	 
	 
	var PEN= document.getElementById('PEN').value
	if(PEN != ""){
		var emp_id = document.getElementById('empid').value
		//alert(emp_id)
		if(emp_id !=""){
	submitProtoAjaxWithDivName('empTerminate','/hms/hrms/training?method=getSuspendByList&empId='+emp_id+'&'+csrfTokenName+'='+csrfTokenValue,'testDiv');
		}
	}else{
		alert("Plz type Pen No");
	}
 
}
	 
		function chkDate()
		{
			
			var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
			obj1 = document.<%="empTerminate"%>.fromDate.value;
			obj2 = document.<%="empTerminate"%>.toDate.value;
			
			
			fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
			toDate= new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
			
			
			if(obj1 != "" && obj2 != "" )
			{
				
				 if(fromDate > toDate)
				{
					errorMsg += "From Date should be smaller than and equal To Date.\n ";
					return false;
				}
				
				
			}
		    return true;
		}
		
		function openPopupWindow()
		{
			/* var id = document.getElementById('transferApp_id').value;
			var mode = document.getElementById('mode').value;
			alert(""+id); */
			var PEN = document.getElementById('PEN').value;
			if(PEN != ""){
			var url="/hms/hrms/training?method=displaySubmitAttachment&"+csrfTokenName+"="+csrfTokenValue;
		 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
			}else{
				alert("Please Type PEN")
			}
		}

</script>

