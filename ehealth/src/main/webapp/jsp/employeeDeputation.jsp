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
<%@page import="jkt.hms.masters.business.HrEmployeeDeputation"%>
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
	//System.out.println("hrTransferApplicationMList>>>"+hrTransferApplicationMList.size());
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}	
	
	  HrEmployeeDeputation deputeEmployee =null;
	
	if(map.get("deputeEmployee")!=null)
	{
		deputeEmployee = (HrEmployeeDeputation)map.get("deputeEmployee");
	}
	  
	%>
	 
	 
	 <%if(!message.equals("")){ %>
<h4><span><%=message %></span></h4>  
   <%} %>  
  
 
<div class="titleBg">
<h2> Deputation Order Entry</h2>
</div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<!-- <form name="search" method="post" action=""> -->

<form name="empDepute" method="post" enctype="multipart/form-data">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label > PEN <span>* </span></label>
<input type="text" id="PEN" name="PEN" value=""  MAXLENGTH="12" class="medium3" validate="PEN,String,no" onblur="getEmpInfoByAjax(this.value)"/>

<label>Employee Name <span>* </span></label>
<input type="text" id="empName" name="empName" value=""  readonly class="medium3" validate="Employee Name,string,yes"  MAXLENGTH="128"/>	
<input type="hidden" id="empid" name="empid" value=""  readonly class="medium3"  MAXLENGTH="128"/>

<label > Designation <span>* </span></label>
<input type="text" id="designation" name="designation" value="" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />
<input type="hidden" id="designationId" name="designationId" value="" MAXLENGTH="12" class="medium3" validate="Designation,String,no" readonly />

<div class="clear"></div>

<label > Department <span>* </span></label>
<input type="text" id="department" name="department" value="" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>
<input type="hidden" id="departmentId" name="departmentId" value="" MAXLENGTH="12" class="medium3" validate="Department,String,no" readonly/>

<label > Current Institution <span>* </span></label>
<input type="text" id="cur_institute" name="cur_institute" value="" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" readonly />
<input type="hidden" id="cur_instituteId" name="cur_instituteId" value="" MAXLENGTH="12" class="medium3" validate="Current Institute,String,no" />

<label > Deputation Institution<span>* </span></label>

<!-- <input type="text"  name="depute_instituteId" id="depute_instituteId" validate="Deputation Institution,string,yes" />  --> 
 
 <select name="depute_instituteId" tabindex=1  id="depute_instituteId" validate="Deputation Institution,string,no" onchange="disableOther2();" />
			<option value="">Select</option>
						<%
							for(MasHospital md: hosList) {
						%>
							<option value="<%=md.getId() %>"><%=md.getHospitalName()%></option>
						<%} %>
			  </select>  

<div class="clear"></div>

<label>Other Institution </label> 
<input type="checkbox"	name="others" id="others" value="y"	onclick="selectEnchashablePerc();disableOther();" class="checkboxMargin" />

<div id="divEnchashment" style="display: none;">

<label>Other Institution Name </label> 
<input	type="text"  maxlength=""	name="othersName"  value="" />

</div>
 <div class="clear"></div>

<%-- <label > From date </label>
<input type="text" id="fromDate" value="<%=dateCal+"/"+month+"/"+year%>" name="fromDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empDepute.fromDate,event)" validate="Pick a date" class="calender" />

<label > To Date </label>

 <input type="text" id="toDate" value="<%=dateCal+"/"+month+"/"+year%>" name="toDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,no"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empDepute.toDate,event)" validate="Pick a date" class="calender" />
 --%>


<label><span>*</span>Deputation Period</label>
<input type="text" id="deputePeriod" name="deputePeriod" validate="Deputation Period,string,yes" maxlength="3" onkeypress="return isNumber(event)" />
			<select id="deputePeriodUnit" name="deputePeriodUnit"  validate="Deputation Period,string,yes" tabindex=1 style="width:162px;">
			<option value="0">Select</option>
			<option value="Year"><%="Year"%></option>
			<option value="Month"><%="Month"%></option>
			<option value="Days"><%="Days"%></option>			
			</select> 
 
 <label ><span>*</span> Order No  </label>
<input type="text" id="order_no" name="order_no" value="" MAXLENGTH="30" class="medium3" validate="Order No,String,yes" />
 <div class="clear"></div>
 <label ><span>* </span> Order Date </label>

 <input type="text" id="orderDate" value="<%=dateCal+"/"+month+"/"+year%>" name="orderDate" class="date" onkeyup="mask(this.value,this,'2,5','/');"	 maxlength="10" onblur="validateExpDate(this,'td');" validate="Actual Reliving date,date,yes"   MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.empDepute.orderDate,event)" validate="Pick a date" class="calender" />
  
<label >Remarks </label>
<input type="text" id="remarks" name="remarks" value="" MAXLENGTH="199" class="medium3" validate="Remarks,String,no" />
<div class="clear"></div>

<input type="file" name="<%=UPLOAD_FILENAME%>" id="fileNameId" class="browse" tabindex="1" />
<div class="clear"></div>
<div class="paddingTop5"></div>

<input name="button"  type="button"	value="Submit" class="button"	 onClick="if(checkInstitute()){submitForm('empDepute','/hms/hrms/training?method=saveEmpDeputaion&'+csrfTokenName+'='+csrfTokenValue)}"  />
 <input name="button"  type="reset"	value="Reset"  />
 
<!--  <input class="button" type="button" ;="" onclick="openPopupWindow()" value="Upload" name="button"> -->
<!-- <label>Upload Document</label> --> 

</form>
<!-- <input name="button"  type="button"	value="Reset" class="button"	onclick="submitForm('empDepute','/hms/hrms/training?method=showDeputationJsp');" /> -->

</div>
</div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div id="testDiv"></div>

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
function checkInstitute(){
	var institute=document.getElementById("depute_instituteId");
	var others=document.getElementById("others");
	var flag=false;
	if(institute.value!=""){
		flag=true;
	}
	if(others.checked){
		flag=true;
	}
	if(flag){
		return flag;
	}else{alert("Please Select Deputation Institution/Other Institution.");return flag;}
} 
function abc1(row,shift){
//	alert(row+"  "+shift)
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

function getEmpInfoByAjax(pen){
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
	        if(items.childNodes.length >0 ){
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var empName  = item.getElementsByTagName("empName")[0];
		        var empId  = item.getElementsByTagName("empId")[0];
		        var desig=item.getElementsByTagName("desig")[0];
		        var desigId=item.getElementsByTagName("desigId")[0];
		        var depart  = item.getElementsByTagName("depart")[0];
		        var departId  = item.getElementsByTagName("departId")[0];
		        var instiName  = item.getElementsByTagName("insti")[0];
		        var instiId  = item.getElementsByTagName("instiId")[0];
		      
	        	document.getElementById('empName').value = empName.childNodes[0].nodeValue
	        	document.getElementById('empid').value = empId.childNodes[0].nodeValue
 	        	document.getElementById('designation').value = desig.childNodes[0].nodeValue
	        	document.getElementById('designationId').value = desigId.childNodes[0].nodeValue
	        	document.getElementById('department').value = depart.childNodes[0].nodeValue
	        	document.getElementById('departmentId').value = departId.childNodes[0].nodeValue
	        	document.getElementById('cur_institute').value = instiName.childNodes[0].nodeValue
	        	document.getElementById('cur_instituteId').value = instiId.childNodes[0].nodeValue
	        	
	          	} 
	      }else{
	    	  alert("Please Type Correct PEN.");
	      document.getElementById('PEN').value="";
	      }
	      }
	    }
	     url="training?method=getEmpInfoForEmpSuspension&PEN="+pen;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }else{
		  alert("Please Type PEN.");
	  }
	 } 


function chkDate()
{
	
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	obj1 = document.<%="empDepute"%>.fromDate.value;
	obj2 = document.<%="empDepute"%>.toDate.value;
	 
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

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;

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

function selectEnchashablePerc(){

	if(document.empDepute.others.checked){
		document.getElementById("divEnchashment").style.display ='block';
	}
	else{
		document.getElementById("divEnchashment").style.display ='none';
	}
	
}

function disableOther()
{
	
	if(document.empDepute.others.checked){
		
		document.empDepute.depute_instituteId.disabled=true;
		
	}else{
		document.empDepute.depute_instituteId.disabled=false;
	}
	
}
function disableOther2()
{
	
	if(document.empDepute.depute_instituteId.value){
		
		document.empDepute.others.disabled=true;
		
	}else{
		document.empDepute.others.disabled=false;
	}
	 
}
 
</script>

