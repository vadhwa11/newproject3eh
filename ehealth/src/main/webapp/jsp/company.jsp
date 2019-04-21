<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * subCharge.jsp  
 * Purpose of the JSP -  This is for Sub Charge.
 * @author  Dipali
 * @author  vishal
 * Create Date: 08th April,2009 
 * Revision Date:      
 * Revision By:  
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>();
	List<MasCompany> companyList = new ArrayList<MasCompany>();
	
	if(map.get("patientTypeList") != null){
		patientTypeList = (ArrayList)map.get("patientTypeList");
	}
	if(map.get("companyList") != null){
		companyList = (List<MasCompany>)map.get("companyList") ;
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message =  "";
	if(map.get("message") != null){
		   message = (String)map.get("message");
		  }
%>

<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<div class="clear"></div>
<%
	if(!message.equals("")){
%>
<H4><span><%=message %></span></H4>

<%} %>
<div class="titleBg">
<h2>Company Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Company Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Company Name </label>  
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Company Code,string,no" MAXLENGTH="8" tabindex=1
onkeypress="return submitenter(this,event,'hospital?method=searchSubCharge')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchCompany','checkSearch')" tabindex=1 /> 
<%--- Report Button  --%> 
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_company"></form>
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
	if(companyList.size()>0 || patientTypeList.size() > 0)
		 {
			String strForCode = (String)map.get("companyCode");
			String strForCodeDescription = (String)map.get("companyName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showCompanyJsp">Show All Records </a></h4><%
			}
		 }
	 if(patientTypeList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="generalMaster?method=showCompanyJsp">Show All Records</a></h4><%
     }
%>

<script type="text/javascript">
	
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"companyType"], [4,"<%= CONTACT_PERSON%>"], [5,"<%= CONTACT_NUMBER %>"],[6,"<%= ADDRESS %>"],[7,"<%=STATUS%>"],[8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>

<form name="company" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="CompanyName"><input
	type="hidden" name="title" value="Company"><input type="hidden"
	name="<%=JSP_NAME %>" value="company"><input type="hidden"
	name="pojoPropertyCode" value="CompanyCode"><input
	type="hidden" name="pojoName" value="MasCompany">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Company Code</label> <input
	type="text" name="<%= CODE%>" value=""
	validate="Company Code,string,yes" class="textbox_size20" MAXLENGTH="8"
	tabindex=1 /> <label><span>*</span> Company Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Company Name,string,yes" class="textbox_size20"
	MAXLENGTH="30" tabindex=1 /> <label class="bodytextB_blue"><span>*</span>
Company Type</label> <select name="companyType"
	validate="Company Type,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 
			for (MasPatientType  patientType : patientTypeList){
				if(patientType.getId() != 2 && patientType.getId() != 6 && patientType.getId() != 8 && patientType.getId() != 9 ){
          %>
	<option value="<%=patientType.getId ()%>"><%=patientType.getPatientTypeName()%></option>

	<%}
		  }%>
</select>

<div class="clear"></div>
<label><span>*</span> Contact Person</label>
<input type="text"	name="<%= CONTACT_PERSON%>" value="" validate="Contact Person,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=1 />
<label><span>*</span> Contact No.</label>
<input type="text" name="<%= CONTACT_NUMBER%>" value="" validate="Contact No,int,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div> 
<label><span>*</span> Address</label>
<input type="text" tabindex="1" name="<%=ADDRESS %>" rows="4" cols="5" validate="Address,string,yes" size="100" style="width:549px;" />
<label> Coordinator Code</label>
<input type="text" name="coordinatorCode" value="" validate="Coordinator Code,string,no" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('company','generalMaster?method=addCompanyDetails');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('company','generalMaster?method=updateCompanyDetails')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('company','generalMaster?method=deleteCompany&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Company Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Company Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Company Type"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "companyType";

data_header[3] = new Array;
data_header[3][0] = "Contact Person"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%=CONTACT_PERSON %>"

data_header[4] = new Array;
data_header[4][0] = "Contact No."
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%=CONTACT_NUMBER %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=ADDRESS %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "coordinatorCode";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_BY %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_DATE %>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_TIME %>"

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();

<%
	int counter = 0;
	for(MasCompany company : companyList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= company.getId()%>;
data_arr[<%= counter%>][1] = "<%=company.getCompanyCode()%>";
data_arr[<%= counter%>][2] = "<%= company.getCompanyName()%>";

<%
		 for(MasPatientType masPatientType : patientTypeList){
            
			 if(company.getPatientType().getId().equals(masPatientType.getId()) && masPatientType.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=masPatientType.getPatientTypeName()%>"
			<%}else if(company.getPatientType().getId().equals(masPatientType.getId()) && masPatientType.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masPatientType.getPatientTypeName()%>";
				
			<%}
}%>
<%
	if( company.getContactPerson() != null){
%>
data_arr[<%= counter%>][4] = "<%= company.getContactPerson() %>";
<%}else{
	%>
data_arr[<%= counter%>][4] = "";	
<%}
	if(company.getContactNo() != null){
%>
data_arr[<%= counter%>][5] = "<%= company.getContactNo() %>";
<%}else{
	%>
	data_arr[<%= counter%>][5] = ""; 
<%}%>
<%
	if(company.getAddress() != null){
%>
data_arr[<%= counter%>][6] = "<%= company.getAddress() %>";
<%}else{%>	data_arr[<%= counter%>][6] = "";
	
<%}%>
<%
	if(company.getCoordinatorCode() != null){
%>
data_arr[<%= counter%>][7] = "<%= company.getCoordinatorCode() %>";
<%}else{
	%>
	data_arr[<%= counter%>][7] = "";
<%}%>

data_arr[<%= counter%>][8] = "<%= company.getLastChgBy()!=null?(company.getLastChgBy().getId()!=null?company.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(company.getLastChgDate()) %>";
data_arr[<%= counter%>][10] = "<%= company.getLastChgTime() %>";
<% if(company.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active";
<%}else{%>
data_arr[<%= counter%>][11] = "InActive";
<%}%>
<%
		     counter++;
}
%>
 
formName = "company"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
