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
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	
	
	List<HrMasTransferNotification> hmtnList = new ArrayList<HrMasTransferNotification>();
	

	if(map.get("transferNotificationList") != null){
		hmtnList = (List<HrMasTransferNotification>)map.get("transferNotificationList");
	}
	System.out.println("  >>> "+hmtnList.size());
	
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	/* int hosId= empList.get(0).getId(); */
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Contract</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!-- <label>Dependent Code</label>  -->
<%-- <input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" />  --%>
<input type="hidden" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" /> 
<label>Employee Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Employee Dependent Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchEmployeeDependent')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','trainingl?method=searchEmployeeContract','checkSearch')" tabindex=1 /> 
<%--- Report Button  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','personnel?method=generateReportForEmployeeDependent');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee_dependent">
</form>
</div>
</div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" /> 
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>"], [1,"Notification_Date"],  [2,"notification"],[3,"fromDate"], [4,"toDate"], [5,"<%=CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->
<form name="empCont" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="clear"></div>

<label ><span>*</span> Employee Name </label>
<input type="text" id="emp_name" name="emp_name" value="" MAXLENGTH="12" class="medium3" validate="Employee Name,String,yes" />


<label ><span>*</span> Agency </label>
<select name="agency" validate="Agency,string,no" tabindex=1  >
<option value="0">Select</option>

</select>

<label ><span>*</span> Category </label>
<select name="category" validate="Category,string,no" tabindex=1  >
<option value="0">Select</option>

</select>

<div class="clear"></div>


<label ><span>*</span> Agreement Type </label>
<select name="agreementType" validate="Agreement Type,string,no" tabindex=1  >
<option value="0">Select</option>

</select>



<label > Agreement Start Date </label>

<input type="text" name="fromDate" id="fromDate"  validate='Application From Date,date,yes' value=""  class="date" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate" onclick="javascript:setdate('',document.<%="itemGrid"%>.<%="fromDate"%>,event)" /> 


<label > Agreement End Date </label>

<input type="text" name="toDate" id="toDate"  validate='Application To Date,date,yes' value=""  class="date" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="calToDate" onclick="javascript:setdate('',document.<%="itemGrid"%>.<%="toDate"%>,event)" /> 

<div class="clear"></div>

<label > Remarks </label>
<textarea name="remarks"  validate="Remarks,string,no" cols="0" rows="0"  maxlength="200" tabindex="1" ></textarea>

<label > Document Submitted </label>
<textarea name="doc_submit"  validate="Document Submitted,string,no" cols="0" rows="0"  maxlength="200" tabindex="1" ></textarea>

<label > Agreement Rules </label>
<textarea name="agreement_rules"  validate="Agreement Rules,string,no" cols="0" rows="0"  maxlength="200" tabindex="1" ></textarea>

</div>
</div>
<div class="clear"></div>
</div>

<div class="clear"></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>



<input type="button" name="add" id="addbutton" value="Add"	class="button" onClick="submitForm('itemGrid','/hms/hrms/training?method=saveContractEmployee','chkDate')"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('itemGrid','training?method=saveTransferNotification')" accesskey="u"	tabindex=1 /> 
<input type="hidden" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('itemGrid','generalMaster?method=deleteCadre&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onClick="submitFormForButton('itemGrid','/hms/hrms/training?method=showTransferNotificationJsp')" accesskey="r" />

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
<input type="hidden"	name="<%= COMMON_ID%>" value="" /> 
</div>



<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">



function chkDate()
{
	
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	obj1 = document.<%="itemGrid"%>.<%="fromDate"%>.value;
	obj2 = document.<%="itemGrid"%>.<%="toDate"%>.value;
	obj3 = document.<%="itemGrid"%>.<%="Notification_Date"%>.value;

	
	fromDate= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	toDate= new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
	Notification_Date = new Date(obj3.substring(6),(obj3.substring(3,5) - 1) ,obj3.substring(0,2));
	
	var nextDate=new Date(serverdate.substring(6),(serverdate.substring(3,5)),serverdate.substring(0,2));
	
	if(obj1 != "" && obj2 != "" && obj3 != "")
	{
		 if(fromDate > toDate)
		{
			errorMsg += "Application From Date should be smaller than Application To Date.\n ";
			return false;
		}
		else if( Notification_Date > fromDate  &&  Notification_Date > toDate)
		{
			errorMsg += "Notfication Date should be greater than both dates.\n ";
			return false;
		}
		else if(  Notification_Date > fromDate)
		{
			errorMsg += "Notification Date should be less than From date.\n ";
			return false;
		}
		else if( Notification_Date > toDate )
		{
			errorMsg += "Notification Date should be less than To Date.\n ";
			return false;
		}
	}

	

    return true;
}
</script>

</form>
<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Notification Date"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "Notification_Date"

data_header[1] = new Array;
data_header[1][0] = "Notification no"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "notification";
	
data_header[2] = new Array;
data_header[2][0] = "Application From Date"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "fromDate";


data_header[3] = new Array;
data_header[3][0] = "Application To Date"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "toDate"



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"
	
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=hmtnList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrMasTransferNotification  hrMasTransferNotification = (HrMasTransferNotification)itr.next(); 
        		System.out.println("hmtnList>>>>"+hrMasTransferNotification.getNotificationNo());
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasTransferNotification.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasTransferNotification.getReleaseDate()!=null?HMSUtil.convertDateToStringWithoutTime(hrMasTransferNotification.getReleaseDate()):" "%>"
	data_arr[<%= counter%>][2] = "<%=hrMasTransferNotification.getNotificationNo() !=null?hrMasTransferNotification.getNotificationNo():" " %>"
data_arr[<%= counter%>][3] = "<%=hrMasTransferNotification.getApplicableFromDate()!=null? HMSUtil.convertDateToStringWithoutTime(hrMasTransferNotification.getApplicableFromDate()):" " %>"
	data_arr[<%= counter%>][4] = "<%=hrMasTransferNotification.getApplicableToDate()!=null?HMSUtil.convertDateToStringWithoutTime(hrMasTransferNotification.getApplicableToDate()):" " %>"
data_arr[<%= counter%>][5] = "<%= hrMasTransferNotification.getLastChgBy()!=null?(hrMasTransferNotification.getLastChgBy().getId()!=null?hrMasTransferNotification.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasTransferNotification.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= hrMasTransferNotification.getLastChgTime() %>"
<% if(hrMasTransferNotification.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "itemGrid"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

