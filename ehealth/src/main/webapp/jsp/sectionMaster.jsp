<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sectionMaster.jsp  
 * Purpose of the JSP -  This is for Section details 
 * @author  Rajendra
 * Create Date: 03rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrMasSection"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>


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
	List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();
	List<HrMasSection> searchSectionMasterList = new ArrayList<HrMasSection>();
			
	if (map.get("departmentList") != null)
	{
		departmentList = (List)map.get("departmentList");
	}
	
	if (map.get("gridDepartmentList") != null)
	{
		gridDepartmentList = (List)map.get("gridDepartmentList");
	}
	if (map.get("searchSectionMasterList") != null)
	{
		searchSectionMasterList = (List)map.get("searchSectionMasterList");
	}
				
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
<h2>Section Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Section Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" /> 
<label>Section Name</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<label>&nbsp;</label> 
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Section Code,string,no" MAXLENGTH="8" tabindex=1 /> 
<input type="button" name="search"	value="Search" class="button"	onclick="submitForm('search','sectionMaster?method=searchSectionMaster','checkSearch')"	tabindex=1 />
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

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
		if(searchSectionMasterList.size()>0 )
		 {
			String strForCode = (String)map.get("sectionCode");
			String strForCodeDescription = (String)map.get("sectionName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<h4><a href="sectionMaster?method=showSectionMasterJsp">Show All Records</a></h4>
<%
			}
		 }
	if(searchSectionMasterList.size()==0 && map.get("search") != null)
	  {
    %>
<h4><a href="sectionMaster?method=showSectionMasterJsp">Show
All Records</a></h4>

<%
           }
         %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="section" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input type="hidden"	name="<%= POJO_NAME %>" value="HrMasSection"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SectionName">
<input type="hidden" name="title" value="Section"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="sectionMaster"> 
<input	type="hidden" name="pojoPropertyCode" value="SectionCode"> 
<label><span>*</span> Section Code</label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Section Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1> 
<label><span>*</span> Section Name</label> 
<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Section,string,yes" class="textbox_size20" MAXLENGTH="30"	/ tabindex=1> 
<script>
				document.section.<%=CODE%>.focus();
			</script> 
<label><span>*</span> Department Name</label> 
<select	name="<%= DEPARTMENT_ID %>" validate="Department Name,string,yes"	tabindex=1>
	<option value="">Select</option>
	<% 
				for (MasDepartment  masDepartment : departmentList){
				%>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%}%>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('section','sectionMaster?method=addSectionMaster');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"	style="display: none;" class="button" onClick="submitForm('section','sectionMaster?method=editSectionMaster')"	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"	style="display: none;" class="button" onClick="submitForm('section','sectionMaster?method=deleteSectionMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Section Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Section Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Department Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=DEPARTMENT_ID%>";

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
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSectionMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasSection  hrMasSection = (HrMasSection)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasSection.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasSection.getSectionCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasSection.getSectionName()%>"

<%
		Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {try{
             MasDepartment  departmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
			 if(hrMasSection.getDepartment().getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=departmentGrid.getDepartmentName()%>"
			<%}else if(hrMasSection.getId().equals(departmentGrid.getId()) && departmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=departmentGrid.getDepartmentName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            
        
data_arr[<%= counter%>][4] = "<%= hrMasSection.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasSection.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= hrMasSection.getLastChgTime() %>"
<% if(hrMasSection.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "section"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
