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

<%@page import="jkt.hms.masters.business.MasDeathCause"%>
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
	List<MasDeathCause> deathCauseList = new ArrayList<MasDeathCause>();
//	List<HrMasTransferNotification> transferNotificationList = new ArrayList<HrMasTransferNotification>();
	List transferNotificationList = new ArrayList();
	List<HrTransferApplicationM> hrTransferApplicationMList = new ArrayList<HrTransferApplicationM>();
	
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
	
	if(map.get("deathCauseList") != null){
		deathCauseList = (List<MasDeathCause>)map.get("deathCauseList");
	}
	/* if(map.get("transferNotificationList") != null){
		transferNotificationList = (List<HrMasTransferNotification>)map.get("transferNotificationList");
	} */
	
	if(map.get("hrTransferApplicationMList") != null){
		hrTransferApplicationMList = (	List<HrTransferApplicationM>)map.get("hrTransferApplicationMList");
	}
	System.out.println("hrTransferApplicationMList>>>"+hrTransferApplicationMList.size());
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Death</h2>
</div>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->
<form name="empDepute" method="post">


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">


<label > PEN <span>* </span></label>
<input type="text" id="PEN" name="PEN" value=""  MAXLENGTH="12" class="medium3" validate="PEN,String,yes" onblur="getEmpInfoByAjax1(this.value)"/>


<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value=""  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value=""  readonly class="medium3"  MAXLENGTH="128"/>

<label > Designation <span>* </span></label>
<input type="text" id="designation" name="designation" value="" MAXLENGTH="12" class="medium3" validate="Designation,String,yes" readonly />


<div class="clear"></div>

<label > Department <span>* </span></label>
<input type="text" id="department" name="department" value="" MAXLENGTH="12" class="medium3" validate="Department,String,yes" readonly/>


<label > Institution <span>* </span></label>
<input type="text" id="cur_institute" name="cur_institute" value="" MAXLENGTH="12" class="medium3" validate=" Institute,String,yes" readonly />
<input type="hidden" id="cur_instituteId" name="cur_instituteId" value="" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<!-- <label > Death On Duty <span>* </span></label>
<select  name="onDuty" 	tabindex=1  id="onDuty"  validate="Death On Duty,string,yes" />
			<option value="">Select</option>
			<option value="y">Yes</option>
			<option value="n">No</option>
						
			  </select>

<div class="clear"></div> -->

<label > Cause of Death</label>
<select  name="causeOfDeath" 	tabindex=1  id="causeOfDeath"  validate="Death On Duty,string,no" />
			<option value="">Select</option>
				<%if(deathCauseList != null){ 
					for (MasDeathCause deathCauseL :deathCauseList) {	%>
					<option value="<%=deathCauseL.getId()%>"><%=deathCauseL.getDeathCauseName() %></option> 
				        <%	}} %>
			 
			  </select>
<div class="clear"></div>

<label >Date of Death </label>
<input type="text" id="deathDate" value="<%=dateCal+"/"+month+"/"+year%>" name="deathDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Death date,date,yes"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empDepute.deathDate,event)" validate="Pick a date" class="calender" />




<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="199" class="medium3" validate="Remarks,String,no" />

<div class="clear"></div>
<label> Death On Duty</label>  

 <label>Yes</label>     
<input type="radio" name="<%=SELECTED_RADIO %>"   value="y" class="inputRadiobutton" class="radioCheck" tabindex=1 />



<label>No</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="n"  class="inputRadiobutton"  tabindex=1 MAXLENGTH="128" />
			    	
<div class="clear"></div>
</div>
</div>
<!-- <form name="itemGrid" method="post"> -->
<div class="paddingTop15"></div>
<div class="clear"></div>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="abc();"  />

<input type="reset" value="Reset">
<!-- <input name="button"  type="button"	value="Upload" class="button"	onclick="openPopupWindow()"; /> -->
</div>


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
function abc(){
	submitForm('empDepute','/hms/hrms/training?method=saveEmpDeath')
}

function getEmpInfoByAjax1(pen){
	if(pen ==""){
		alert("Please Type PEN ")
		
	}else{
		getEmpInfoByAjax(pen);
	}
	
}

function getEmpInfoByAjax(pen){
	//  alert(""+pen)
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
	      
				if(items.childNodes.length>0){
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	 	var status  = item.getElementsByTagName("status")[0];
		   	 	if(status.childNodes[0].nodeValue == "Death" ){ 
		   	 			alert("This Employee allready Dead.")
		   	 		document.getElementById('PEN').value="";
		   	 		}else{
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
	        	
	        	document.getElementById('cur_institute').value = instiName.childNodes[0].nodeValue
	        	document.getElementById('cur_instituteId').value = instiId.childNodes[0].nodeValue
	        	
	          	} 
	      }
	      }else{
	    	  alert("Wrong PEN. Please enter correct PEN.");
	    	  document.getElementById('PEN').value="";
	      }
	      }
	    }
	     url="training?method=getEmpInfoForEmpSuspension&PEN="+pen;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }
	 
function chkDate()
{
	
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	obj1 = document.<%="empDepute"%>.deathDate.value;
	
	fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));

	if(obj1 != "")
	{
		
		 if(fromDate > currentDate)
		{
			errorMsg += "Death Date  should be smaller than and equal To Current Date.\n ";
			return false;
		}
		
		
	}
	
}

function openPopupWindow()
{
	/* var id = document.getElementById('transferApp_id').value;
	var mode = document.getElementById('mode').value;
	alert(""+id); */
	var PEN = document.getElementById('PEN').value;
	if(PEN != ""){
	var url="/hms/hrms/training?method=displaySubmitAttachment";
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}else{
		alert("Please Type PEN")
	}
}

function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   }
   return this
}

var dtCh= "/";
var minYear=1900;
var maxYear=2100;
function isDate(dtStr,fieldId){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
	if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
	alert("The date format should be : DD/MM/YYYY" );
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strMonth.length<1 || month<1 || month>12){
	alert("Please enter a valid month");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
	alert("Please enter a valid day");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
	alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear+"");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
	alert("Please enter a valid date ");
	document.getElementById(fieldId).value="";
	document.getElementById(fieldId).focus();
	return false
	}
	return true
	}

function validateExpDate(dt,fieldId){
	
	if(dt.value!=""){
	if (isDate(dt.value,fieldId)==false){
	return false
	}}
	return true
	}
function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}
function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function clearFields()
    {
        document.getElementById("empDepute").value="";
        return false;
    }
</script>
</script>

</form>
