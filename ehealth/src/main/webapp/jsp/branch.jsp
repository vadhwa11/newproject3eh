<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientType.jsp
 * Purpose of the JSP -  This is for Patient Type.
 * @author Ujjwal
 * Create Date: 25th Feb,2009
 * Revision Date:
 * Revision By:
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasBranch> searchBranchList = new ArrayList<MasBranch>();
	List<MasDepartment>departmentList = new ArrayList<MasDepartment>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("searchBranchList")!= null){
		
		searchBranchList = (List<MasBranch>)map.get("searchBranchList");
	}
	if(map.get("departmentList")!= null){
		
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   
<%@page import="jkt.hms.masters.business.MasDepartment"%><h4><span><%=message %></span></h4>
<%} %>

<div class="titleBg">
<h2>Branch</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="clear"></div>

<label>Branch Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" validate="Administrative Sex Code,int,no" />
<label>Branch Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" validate="Administrative Sex Code,int,no" />
<!-- <label>&nbsp;</label> -->
 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="PatientType Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchPatientType')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchPatientType','checkSearch')" tabindex=1 />
	<%--- Report Button    <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
 <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_patient_type" validate="Administrative Sex Code,string,no">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
 <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=DEPARTMENT_ID%>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<div class="clear"></div>

<form name="branch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasBranch" />
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BranchDesc" />
<input type="hidden" name="title" value="Branch" />
<input type="hidden" name="<%=JSP_NAME %>" value="branch" />
<input type="hidden" name="pojoPropertyCode" value="BranchCode" />
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Branch Code</label>
 <input id="codeId" type="text" name="<%= CODE%>" value="" validate="Branch Code,string,yes" MAXLENGTH="8"  tabindex=1 />
 <label><span>*</span> Branch Name</label>
 <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Branch Name,string,yes" MAXLENGTH="30"  tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addPatientType')" />

<label><span>*</span>Department</label>
<select  id="deptId" name="<%=DEPARTMENT_ID %>">
<option value="0">Select</option>
<%if(departmentList.size()>0){
	for(MasDepartment masDepartment :departmentList){
	%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%}
	}%>	
</select>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('branch','generalMaster?method=addBranch');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('branch','generalMaster?method=editBranch')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('patientType','hospital?method=deletePatientType&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
 <input type="hidden" name="<%=STATUS %>" value="" />
  <input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label>
 <label class="value"><%=userName%></label>
 <label>Changed Date:</label>
  <label class="value"><%=date%></label>
   <label>Changed Time:</label>
    <label class="value"><%=time%></label>
     <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
      <input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
      <input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
      </div>
      </form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Branch Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Branch Name"
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
data_header[5][0] = "Department"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=DEPARTMENT_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchBranchList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             MasBranch  masBranch = (MasBranch)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBranch.getId()%>
data_arr[<%= counter%>][1] = "<%=masBranch.getBranchCode()%>"
data_arr[<%= counter%>][2] = "<%= masBranch.getBranchDesc()%>"

data_arr[<%= counter%>][3] = "<%=masBranch.getLastChgBy()!=null? masBranch.getLastChgBy():"" %>"
data_arr[<%= counter%>][4] = "<%= masBranch.getLastChgDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masBranch.getLastChgDate()):"" %>"
data_arr[<%= counter%>][5] = "<%= masBranch.getLastChgTime()!=null?masBranch.getLastChgTime():"" %>"
<%if(departmentList.size()>0){
	for(MasDepartment masDepartment :departmentList){
	if(masBranch.getDepartment().getId()!=null && masDepartment.getId().equals(masBranch.getDepartment().getId())){
%>
data_arr[<%= counter%>][6] = "<%=masDepartment.getDepartmentName() !=null ?masDepartment.getDepartmentName():"" %>"
<%}}}%>
<% if(masBranch.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>


<%
		     counter++;
}
%>




formName = "branch"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
