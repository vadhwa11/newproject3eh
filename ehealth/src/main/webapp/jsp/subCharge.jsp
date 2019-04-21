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

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@ page import="jkt.hms.masters.business.MasMainChargecode"%>



<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList=(List<MasDepartment>)map.get("departmentList");
	mainChargeCodeList = (ArrayList)map.get("mainChargeCodeList");
	ArrayList searchSubChargeList = (ArrayList)map.get("searchSubChargeList");
	ArrayList gridMainChargeList = (ArrayList)map.get("gridMainChargeList");
	ArrayList gridDepartmentList = (ArrayList)map.get("gridDepartmentList");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
<%}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
%>

<div class="titleBg">
<h2>Sub Service Head Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Sub Service Head Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Sub Service Head Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Sub Service Head Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchSubCharge')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchSubCharge','checkSearch')" tabindex=1 /> 
<%--- Report Button     <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_subcharge"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
<h4>NO Records Found</h4>
<%
		if(searchSubChargeList.size()>0 && mainChargeCodeList.size() > 0)
		 {
			String strForCode = (String)map.get("subChargecodeCode");
			String strForCodeDescription = (String)map.get("subChargecodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="hospital?method=showSubChargeJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchSubChargeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showSubChargeJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">


	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= MAIN_CHARGECODE_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"departmentId"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>

<form name="subCharge" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasSubChargecode" />
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SubChargecodeName"/> 
<input type="hidden" name="title" value="SubCharge"/> 
<input type="hidden" name="<%=JSP_NAME %>" value="subCharge"/> <input type="hidden" name="pojoPropertyCode" value="SubChargecodeCode"/>
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Sub Service Head Code</label> 
<input type="text" name="<%= CODE%>" value="" validate="Sub Service Head Code,string,yes" class="textbox_size20" MAXLENGTH="8"  tabindex=1 /> 

<label><span>*</span> Sub Service Head Name </label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Sub Service Head Description,string,yes" class="textbox_size20" MAXLENGTH="30"  tabindex=1/> 

<label class="bodytextB_blue"><span>*</span> Main Service Head </label> 
<select name="<%= MAIN_CHARGECODE_ID %>" validate="Main Service Head,string,yes" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addSubCharge')"> <option value="">Select</option>
<% 
			for (MasMainChargecode  masMainChargecode : mainChargeCodeList){
          %>
	<option value="<%=masMainChargecode.getId ()%>"><%=masMainChargecode.getMainChargecodeName()%></option>

	<%}%>
</select>
<div class="clear"></div>
<div style="display: none;">
<label><span>*</span>Department</label>
<select name="departmentId" validate="Department Name,string,yes">
<option value="0">-Select-</option>
<%
if(departmentList!=null && departmentList.size()>0){
for(MasDepartment department:departmentList){ %>
<option value="<%=department.getId()%>"><%= department.getDepartmentName().trim()%></option>
<%}} %> 
</select>
			<script>
				document.getElementsByName("departmentId")[0].selectedIndex=1;
			</script>
</div>
<div class="clear"></div>

<div id="edited"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('subCharge','hospital?method=addSubCharge');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('subCharge','hospital?method=editSubCharge')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('subCharge','hospital?method=deleteSubCharge&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" id="pageNoEdit" name="pageNoEdit" value="<%=pageNo %>"/>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sub Service Head Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Sub Service Head Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Main Service Head"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=MAIN_CHARGECODE_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Department Name"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "departmentId";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSubChargeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             MasSubChargecode  masSubChargecode = (MasSubChargecode)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSubChargecode.getId()%>
data_arr[<%= counter%>][1] = "<%=masSubChargecode.getSubChargecodeCode()%>"
data_arr[<%= counter%>][2] = "<%= masSubChargecode.getSubChargecodeName()%>"

<%
		Iterator itrGridMainChargeList=gridMainChargeList.iterator();
		 while(itrGridMainChargeList.hasNext())
            {
             MasMainChargecode  mainChargeGrid = (MasMainChargecode)itrGridMainChargeList.next();
			 if(masSubChargecode.getMainChargecode().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=mainChargeGrid.getMainChargecodeName()%>"
			<%}else if(masSubChargecode.getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=mainChargeGrid.getMainChargecodeName()%>";

			<%}
}%>
data_arr[<%= counter%>][4] = "<%= masSubChargecode.getLastChgBy()!=null?(masSubChargecode.getLastChgBy().getId()!=null?masSubChargecode.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masSubChargecode.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masSubChargecode.getLastChgTime() %>"

<%
if(gridDepartmentList!=null && gridDepartmentList.size()>0){

Iterator deptItr=gridDepartmentList.iterator();
		 while(deptItr.hasNext())
            {
             MasDepartment  masDept = (MasDepartment)deptItr.next();
             if(masSubChargecode.getDepartment()!=null ){
			 if(masSubChargecode.getDepartment().getId().equals(masDept.getId()) && masDept.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][7] = "<%=masDept.getDepartmentName().trim()%>"
			<%}else if(masSubChargecode.getDepartment().getId().equals(masDept.getId()) && masDept.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masDept.getDepartmentName().trim()%>";

			<%}
             }else{
				%>
				data_arr[<%= counter%>][7] = "";
			<%}
}}else{


%>
	data_arr[<%= counter%>][7] = "";
<%
}%>


<% if(masSubChargecode.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>

formName = "subCharge"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
//makeTable(start,end);
pgNo = '<%=pageNo%>';
totalPages = Math.ceil(data_arr.length/rowsPerPage);
if(totalPages == 0){
pgNo = pgNo-1;
}
goToPage(pgNo);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
