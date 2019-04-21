<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigationReportTemplate"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgMasInvestigationReportTemplate> investigationReportTemplateList = new ArrayList<DgMasInvestigationReportTemplate>();
	investigationList = (ArrayList)map.get("investigationList");
	investigationReportTemplateList = (ArrayList)map.get("investigationReportTemplateList");
	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>
<% 
if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		  <h4><span><%=message %></span></h4>
		 <%} %>
<div class="clear"></div>
<div class="titleBg">
<h2>Investigation Template Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<label>Report Name</label>
 	 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="LionC Class,string,yes"
	MAXLENGTH="12" tabindex=1 /> 
	<input type="button" name="search" value="Search" class="button"onclick="submitForm('search','lab?method=searchInvestigationReportTemplate')">
</form>

</div>
</div>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(investigationReportTemplateList.size()>0 )
		 {
			
	%> <h4><a href="lab?method=showInvestigationReportTemplateJsp">Show All
Records</a></h4> <%
			}
		 
	if(investigationReportTemplateList.size()==0 )
	  {
    %><h4> <a href="lab?method=showInvestigationReportTemplateJsp">Show
All Records</a></h4> <%
           }
         %> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= REPORT_NAME%>"],[2,"<%= INVESTIGATION_ID%>"], [3,"<%= SEQUENCE_NO %>"], [4,"<%= GROUP_NAME %>"],[5,"<%= GROUP_SEQUENCE %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>

<form name="investigationTemplateReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDepartment"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="DepartmentName"><input
	type="hidden" name="title" value="Department"><input
	type="hidden" name="<%=JSP_NAME %>" value="department"><input
	type="hidden" name="pojoPropertyCode" value="DepartmentCode">
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="Block">
	
	<input type="hidden" name="<%=COMMON_ID%>" value=""/>
	 <label><span>*</span> Report Name</label>
	 <input type="text" id="reportName" name="<%= REPORT_NAME %>" validate="Report Name,alphanumeric,yes" tabindex=1>

<label><span>*</span> Charge Name</label> <select
	name="<%= INVESTIGATION_ID %>" validate="Charge Name,integer,yes" tabindex=1>
	
	<option value="0">Select</option>
	<% 
				if(investigationList.size() >0){
				for (DgMasInvestigation chargeCode : investigationList){
				
				%>
	<option value="<%=chargeCode.getId ()%>"><%=chargeCode.getInvestigationName()%></option>	

	<%}}%>
</select>

	<label><span>*</span> Sequence No.</label>
	 <input type="text" id="sequenceNo" name="<%= SEQUENCE_NO %>" validate="Sequence No,integer,yes" tabindex=1>
	<div class="clear"></div>
	<label><span>*</span> Group Name</label>
	<%-- <input type="text" id="groupName" name="<%= GROUP_NAME %>" validate="Group Name,string,yes" tabindex=1> --%>
	 
	
	<select id="groupName" name="<%= GROUP_NAME %>" tabindex=1 validate="Group Name,alphanumeric,yes">
	<option value"">-Select- </option>
	<option value="Test for Choiera">Test for Choiera </option>
	<option value="Test for Other bacterial enteropathogens">Test for Other bacterial enteropathogens </option>
	<option value="Test for Typhoid">Test for Typhoid </option>
	<option value="Leptospira Serology">Leptospira Serology </option>
	<option value="Dengue Serology">Dengue Serology </option>
	<option value="Test for Meningococcal Meningitis">Test for Meningococcal Meningitis </option>
	<option value="JE Serology">JE Serology </option>
	<option value="Measles Serology">Measles Serology </option>
	<option value="Test for Diphtheria">Test for Diphtheria</option>
	<option value="Antimicrobial susceptibility testing in bacterial pathgens">Antimicrobial susceptibility testing in bacterial pathgens</option>
	<option value="Test for hepatitis A">Test for hepatitis A</option>
	<option value="Test for hepatitis E">Test for hepatitis E </option>
	<option value="Test for Malaria">Test for Malaria </option>
	<option value="Bacteriological tests for Water">Bacteriological tests for Water</option>
	<option value="outbreaks confirmed by the laboratory(details of each outbreak):">outbreaks confirmed by the laboratory(details of each outbreak):</option>
	<option value="Any other laboratory initiatives/achivements">Any other laboratory initiatives/achivements</option>
	</select>
	 <label><span>*</span> Group Sequence No.</label>
	 <input type="text" id="groupSequenceNo" name="<%= GROUP_SEQUENCE %>" validate="Group Sequence,integer,no" tabindex=1>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('investigationTemplateReport','lab?method=addInvestigationReportTemplate');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('investigationTemplateReport','lab?method=editInvestigationReportTemplate')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onClick="submitForm('investigationTemplateReport','lab?method=deleteInvestigationReportTemplate&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>"/> <input type="hidden"
	name="<%=CHANGED_TIME%>" value="<%=time%>" /></div></form>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Report name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= REPORT_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "Investigation Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= INVESTIGATION_ID %>";


data_header[2] = new Array;
data_header[2][0] = "Sequence No"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "<%=SEQUENCE_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Group Name"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%=GROUP_NAME %>";

data_header[4] = new Array;
data_header[4][0] = "Group Sequence"
data_header[4][1] = "hide";
data_header[4][2] = "25%";
data_header[4][3] = "<%=GROUP_SEQUENCE %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=investigationReportTemplateList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DgMasInvestigationReportTemplate  masLioncSubClass = (DgMasInvestigationReportTemplate)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masLioncSubClass.getId()%>

data_arr[<%= counter%>][1] = "<%= masLioncSubClass.getReportName()%>"
<%
		Iterator itrGridDepartmentTypeList=investigationList.iterator();
		 while(itrGridDepartmentTypeList.hasNext())
            {try{
             DgMasInvestigation  departmentTypeGrid = (DgMasInvestigation)itrGridDepartmentTypeList.next(); 
			 if(masLioncSubClass.getInvestigationId().getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=departmentTypeGrid.getInvestigationName()%>"
			<%}else if(masLioncSubClass.getId().equals(departmentTypeGrid.getId()) && departmentTypeGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=departmentTypeGrid.getInvestigationName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>



		


data_arr[<%= counter%>][3] = "<%= masLioncSubClass.getSeq()%>"
data_arr[<%= counter%>][4] = "<%= masLioncSubClass.getGroupName()%>"
data_arr[<%= counter%>][5] = "<%= masLioncSubClass.getGroupSeq()%>"

<% if(masLioncSubClass.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "investigationTemplateReport"

nonEditable = ['<%= STATUS%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	

function checkLionClass()
{

var lionId=document.getElementById('lionNo');

if(lionId==null)
{
alert("Select LionC Class");
return false;
}
else
{
return true;
}

}	
</script>
