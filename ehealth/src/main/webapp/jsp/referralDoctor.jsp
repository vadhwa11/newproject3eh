<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * referralDoctor.jsp  
 * Purpose of the JSP -  This is for Referral Doctor.
 * @author Dipali
 * @author Vishal
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasReferralDoctor"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList = (ArrayList)map.get("departmentList");
	
	ArrayList searchReferralDoctorList = (ArrayList)map.get("searchReferralDoctorList");
	ArrayList gridDepartmentList = (ArrayList)map.get("gridDepartmentList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Referral Doctor Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label> Referral Doctor Name </label> 
<input type="text" id="searchField" name="<%= SEARCH_NAME%>" value="" validate="ReferralDoctor Name,string,no" MAXLENGTH="50" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchReferralDoctor')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchReferralDoctor','checkSearch')" tabindex=1 /> 
<%--- Report Button     <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_referal_doctor">
</form>
</div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchReferralDoctorList.size()>0 && departmentList.size() > 0)
		 {
			String strForName = (String)map.get("referralDoctorName");
			if(strForName!= null && strForName!= "" )
			{
	%><h4> <a href="personnel?method=showReferralDoctorJsp">Show All
Records</a></h4> <%
			}
		 }
	 if(searchReferralDoctorList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="personnel?method=showReferralDoctorJsp">Show All
Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= DEPARTMENT_ID%>"], [3,"<%= ADDRESS_1%>"],[4,"<%= ADDRESS_2%>"],[5,"<%= PHONE%>"],[6,"<%= MOBILE%>"], [7,"<%= REFERRAL_TYPE%>"],  [8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>

<form name="referralDoctor" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasReferralDoctor">
<input type="hidden" name="title" value="ReferralDoctor"> 
<input type="hidden" name="<%=JSP_NAME %>" value="referralDoctor"> 
<input type="hidden" name="pojoPropertyName" value="DoctorName">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Doctor Name</label> 
<input id="codeId" type="text" name="<%= SEARCH_NAME%>" value="" validate="ReferralDoctor Name,string,yes" class="textbox_size20" MAXLENGTH="50" tabindex=1> 
<script>
		document.referralDoctor.<%=SEARCH_NAME%>.focus();
	</script> 
<label><span>*</span> Department </label> 
<select name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>" validate="Deparment,string,yes" tabindex=1>
<option value="">Select</option>
	<% 
			for (MasDepartment  masDepartment : departmentList){
		 %>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
	<%}%>
</select> 
<label><span>*</span> Address1 </label> 
<input type="text" name="<%= ADDRESS_1%>" value="" validate="Address1,address,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
<label><span>*</span>Address2</label> 
<input type="text" name="<%= ADDRESS_2%>" value="" validate="Address2,address,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 /> 
<label><span>*</span> Phone No </label> 
<input	type="text" name="<%= PHONE%>" value="" validate="Phone No,phone,yes" class="textbox_size20" MAXLENGTH="10" tabindex=1 /> 
<label><span>*</span> Mobile No </label> 
<input type="text" name="<%= MOBILE%>" value="" validate="Mobile No,phone,yes" class="textbox_size20" MAXLENGTH="10" tabindex=1 />
<div class="clear"></div>
<label><span>*</span> Referral Type </label> 
<select
name="<%= REFERRAL_TYPE%>" validate="Referral Type,int,yes" tabindex=1
onkeypress="return submitenter(this,event,'personnel?method=addReferralDoctor')">
<option value="">Select</option>
<option value="1">doctor</option>
<option value="2">person</option>
<option value="3">others</option>
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('referralDoctor','personnel?method=addReferralDoctor');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('referralDoctor','personnel?method=editReferralDoctor')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('referralDoctor','personnel?method=deleteReferralDoctor&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Referral Doctor Name"
data_header[0][1] = "data";
data_header[0][2] = "14%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Department"
data_header[1][1] = "data";
data_header[1][2] = "14%";
data_header[1][3] = "<%=DEPARTMENT_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Address1"
data_header[2][1] = "data";
data_header[2][2] = "14%";
data_header[2][3] = "<%= ADDRESS_1 %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "14%";
data_header[3][3] = "<%=ADDRESS_2 %>";

data_header[4] = new Array;
data_header[4][0] = "Phone No"
data_header[4][1] = "data";
data_header[4][2] = "14%";
data_header[4][3] = "<%=PHONE %>";

data_header[5] = new Array;
data_header[5][0] = "Mobile No"
data_header[5][1] = "data";
data_header[5][2] = "14%";
data_header[5][3] = "<%=MOBILE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=REFERRAL_TYPE%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_BY%>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_DATE%>"

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_TIME%>"

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "14%";
data_header[10][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr = searchReferralDoctorList.iterator();
          int  counter=0;
          while(itr.hasNext()) {
             MasReferralDoctor masReferralDoctor = (MasReferralDoctor)itr.next(); 
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masReferralDoctor.getId()%>
data_arr[<%= counter%>][1] = "<%= masReferralDoctor.getDoctorName()%>"

<%
		Iterator itrGridDepartmentList = gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(masReferralDoctor.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("Y")){
			 %>
				data_arr[<%= counter%>][2] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(masReferralDoctor.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
			<%}
}%>
data_arr[<%= counter%>][3] = "<%= masReferralDoctor.getAddress1()%>"
data_arr[<%= counter%>][4] = "<%= masReferralDoctor.getAddress2() %>"
data_arr[<%= counter%>][5] = "<%= masReferralDoctor.getPhoneNo() %>"
data_arr[<%= counter%>][6] = "<%= masReferralDoctor.getMobileNo() %>"
data_arr[<%= counter%>][7] = "<%= masReferralDoctor.getReferralType() %>"
	 data_arr[<%= counter%>][8] = "<%= masReferralDoctor.getLastChgBy()!=null?(masReferralDoctor.getLastChgBy().getId()!=null?masReferralDoctor.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masReferralDoctor.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= masReferralDoctor.getLastChgTime() %>"
<% if(masReferralDoctor.getStatus().equals("y")){ 
%>

data_arr[<%= counter%>][11] = "Active"
<%}else{
%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "referralDoctor"

nonEditable = ['<%= SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
