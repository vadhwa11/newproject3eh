<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * mainChargeCode.jsp
 * Purpose of the JSP -  This is for Main Charge Code.
 * @author  Mansi
 * @author  Vishal
 * Create Date: 08th April,2009
 * Revision Date:
 * Revision By:
 * @version 1.11
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment" %>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	ArrayList searchMainChargecodeList = (ArrayList)map.get("searchMainChargecodeList");
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	departmentList=(List<MasDepartment>)map.get("departmentList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo = 0;
	if(map.get("pageNo") != null){
		pageNo = (Integer)map.get("pageNo");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <% }%>

<div class="titleBg">
<h2>Main Service Head Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<label>Main Service Head Code</label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" />
<label>Main Service Head Name</label>
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />

<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>"
 value="" validate="MainCharge Code,string,no" MAXLENGTH="8" 
 tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchMainChargecode')" /> 
	
<input type="hidden" name="colCode" value="main_chargecode_code">
<input type="hidden" name="colName" value="main_chargecode_name">
<input type="button" name="search" value="Search" 
class="button" onclick="submitForm('search','hospital?method=searchMainChargecode','checkSearch')" tabindex=1 />
<%--- Report Button     <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" 	class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_main_chargecode">

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
<!-- <h4>No Records Found</h4> -->
<%
		if(searchMainChargecodeList.size()>0)
		 {
			String strForCode = (String)map.get("mainChargecodeCode");
			String strForCodeDescription = (String)map.get("mainChargecodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="hospital?method=showMainChargecodeJsp">Show All Records</a></h4>
<%
			}
		 }
	 if(searchMainChargecodeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showMainChargecodeJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">

	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"],
			[4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"],[7,"departmentName"] ];
	 statusTd = 6;
	</script></div>

<form name="mainChargecode" method="post" action="">
<input 	type="hidden" name="<%= POJO_NAME %>" value="MasMainChargecode">
<input 	type="hidden" name="<%=POJO_PROPERTY_NAME %>" 	value="MainChargecodeName">
	<input type="hidden" name="title" value="MainChargecode">
	<input type="hidden" name="<%=JSP_NAME %>" value="mainChargecode">
	<input 	type="hidden" name="pojoPropertyCode" value="MainChargecodeCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Main Service Head Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="MainCharge Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1>
<label><span>*</span> Main Service Head Name</label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="MainChargeCode Name,string,yes" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addMainChargecode')" />
<script>
				document.mainChargecode.<%=CODE%>.focus();
			</script>
		 <div style="display: show;">
 <label><span>*</span>Department</label>
<select name="departmentName" validate="Department Name,string,yes">
<option value="0">-Select-</option>
<%
if(departmentList!=null && departmentList.size()>0){
for(MasDepartment department:departmentList){ %>
<option value="<%=department.getId()%>" ><%= department.getDepartmentName()%></option>
<%}} %> 
</select>

</div>
			<script>
				document.getElementsByName("departmentName")[0].selectedIndex=1;
			</script> 
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('mainChargecode','hospital?method=addMainChargecode');"
	accesskey="a" tabindex=1 />
	 <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('mainChargecode','hospital?method=editMainChargecode')"
	accesskey="u" tabindex=1 />
	 <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('mainChargecode','hospital?method=deleteMainChargecode&flag='+this.value)"
	accesskey="d" tabindex=1 />	
	<input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" />
	<input type="hidden"
	name="<%=STATUS %>" value="" />
	<input type="hidden" 	name="<%= COMMON_ID%>" value="" />
<input type="hidden" id="pageNoEdit" name="pageNoEdit" value="<%=pageNo %>"/>
<div class="clear"></div>
</div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Main Service Head Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Main Service Head Name"
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
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_TIME %>";


/* data_header[5] = new Array;
data_header[5][0] = "Department Name"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "departmentName";
 */
data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

/*  data_header[6] = new Array;
data_header[6][0] = "Department Name"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "departmentName";
  */

data_arr = new Array();

<%
Iterator itr=searchMainChargecodeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             MasMainChargecode  masMainChargecode = (MasMainChargecode)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masMainChargecode.getId()%>
data_arr[<%= counter%>][1] = "<%=masMainChargecode.getMainChargecodeCode()%>"
data_arr[<%= counter%>][2] = "<%= masMainChargecode.getMainChargecodeName()%>"

data_arr[<%= counter%>][3] = "<%= masMainChargecode.getLastChgBy()!=null?masMainChargecode.getLastChgBy().getUserName():"" %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masMainChargecode.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masMainChargecode.getLastChgTime() %>"

<%
if(departmentList!=null && departmentList.size()>0){


Iterator itrGridMainChargeList=departmentList.iterator();
		 while(itrGridMainChargeList.hasNext())
            {
             MasDepartment  mainChargeGrid = (MasDepartment)itrGridMainChargeList.next();
			 if(masMainChargecode.getDepartment().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][3] = "<%=mainChargeGrid.getDepartmentName()%>"
			<%}else if(masMainChargecode.getDepartment().getId().equals(mainChargeGrid.getId()) && mainChargeGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=mainChargeGrid.getDepartmentName()%>";

			<%}
}}else{


%>
	data_arr[<%= counter%>][3] = "";
<%
}
if(masMainChargecode.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

data_arr[<%= counter%>][7] = "<%=masMainChargecode.getDepartment()!=null?masMainChargecode.getDepartment().getId():0%>"
<%

		     counter++;

}
%>

formName = "mainChargecode"
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
