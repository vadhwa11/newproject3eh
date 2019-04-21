<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientType.jsp  
 * Purpose of the JSP -  This is for Patient Type.
 * @author Vishal
 * Create Date: 14th Jan,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.8
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPatientTypeList = (ArrayList)map.get("searchPatientTypeList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		 %>
	<h4><span><%=message %></span></h4>
<%} %>	 

<div class="titleBg">
<h2>Patient Type</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="clear"></div>

<label>Patient Type Code </label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Patient Type Name</label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="PatientType Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchPatientType')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchPatientType','checkSearch')" tabindex=1 />

	
<input type="hidden" name="colCode" value="patient_type_code">
<input type="hidden" name="colName" value="patient_type_name">
<%--- Report Button    <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_patient_type">	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>	
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchPatientTypeList.size()>0)
		 {
			String strForCode = (String)map.get("patientTypeCode");
			String strForCodeDescription = (String)map.get("patientTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showPatientTypeJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchPatientTypeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showPatientTypeJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"],[7,"dischargeWithoutSettlement"],[8,"validityDays"] ];
	 statusTd = 6;
	</script></div>
<div class="clear"></div>

<form name="patientType" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasPatientType"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PatientTypeName"><input
	type="hidden" name="title" value="PatientType"><input
	type="hidden" name="<%=JSP_NAME %>" value="patientType"><input
	type="hidden" name="pojoPropertyCode" value="PatientTypeCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Patient Type Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="PatientType Code,string,yes" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Patient Type Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="PatientType Name,string,yes" MAXLENGTH="30" / tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addPatientType')">
<label><span>*</span> Validity Days</label> 
<input type="text" name="validityDays" validate="Validity Days,num,yes" MAXLENGTH="3"/>
<label class="heightAuto"> Discharge Without Settlement</label> 
<input type="checkbox" name="dischargeWithoutSettlement" class="inputRadiobutton" value="y" />
<label> Category Type</label> 
<select name="categoryTypeName" id="categoryId">
<option value="-1">Select</option>
<option value="s">Social Category</option>
<option value="o">Other Category</option>
</select>
<!-- <input type="checkbox" name="categoryType class="radioCheck" value="y" /> -->
 <script>
		document.patientType.<%=CODE%>.focus();
</script>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('patientType','hospital?method=addPatientType');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('patientType','hospital?method=editPatientType')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button"	style="display: none;" onClick="submitForm('patientType','hospital?method=deletePatientType&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="bottom">
<label>Changed By</label> 
<label	class="value"><%=userName%></label> 
<label>Changed Date</label>
<label	class="value"><%=date%></label>
<label>Changed Time</label> 
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Patient Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Patient Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "dischargeWithoutSettlement";


data_header[7] = new Array;
data_header[7][0] = "Validity Days"
data_header[7][1] = "data";
data_header[7][2] = "25%";
data_header[7][3] = "validityDays";

data_arr = new Array();

<%
Iterator itr=searchPatientTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasPatientType  masPatientType = (MasPatientType)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPatientType.getId()%>
data_arr[<%= counter%>][1] = "<%=masPatientType.getPatientTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masPatientType.getPatientTypeName()%>"

data_arr[<%= counter%>][3] = "<%= masPatientType.getLastChgBy()!=null?(masPatientType.getLastChgBy().getId()!=null?masPatientType.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masPatientType.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masPatientType.getLastChgTime() %>"
<% if(masPatientType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
data_arr[<%= counter%>][7] = "<%= masPatientType.getDischargeWithoutSettlement() %>"
	<% if(masPatientType.getValidity()!=null){ %>
	data_arr[<%= counter%>][8] = "<%=masPatientType.getValidity() %>"
	<%}else{%>
	data_arr[<%= counter%>][8] = ""
	<%}%>

<%
		     counter++;
}
%>
 
formName = "patientType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
