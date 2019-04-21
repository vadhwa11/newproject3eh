<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hrQualificationMaster.jsp  
 * Purpose of the JSP -  This is for Qualification Master details 
 * @author  Rajendra
 * Create Date: 15th Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasSpecialQualification"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	

	List<HrMasSpecialQualification> searchSpecialQualificationMasterList = new ArrayList<HrMasSpecialQualification>();
			
	if (map.get("searchSpecialQualificationMasterList") != null)
	{
		searchSpecialQualificationMasterList = (List)map.get("searchSpecialQualificationMasterList");
	}
				
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
<div class="titleBg">
<h2>Special Qualification Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label class="auto">Special Qualification Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheck" /> 
<label class="auto">Special Qualification Name</label> 
<input type="radio" name="<%=SELECTED_RADIO %>"	value="2" class="radioCheck" /> 
<label>&nbsp;</label> 
<input	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Special Qualification Code,string,no" MAXLENGTH="8"	tabindex=1 /> 
<input type="button" name="search" value="Search"	class="button"	onclick="submitForm('search','educationMasters?method=searchSpecialQualificationMaster','checkSearch')"	tabindex=1 />
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
		if(searchSpecialQualificationMasterList.size()>0 )
		 {
			String strForCode = (String)map.get("specialQualificationCode");
			String strForCodeDescription = (String)map.get("specialQualificationName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>

<h4><a	href="educationMasters?method=showSpecialQualificationMasterJsp">Show All Records</a></h4>
<%
			}
		 }
	if(searchSpecialQualificationMasterList.size()==0 && map.get("search") != null)
	  {
    %>
<h4><a	href="educationMasters?method=showSpecialQualificationMasterJsp">Show All Records</a></h4>

<%
           }
         %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="specialQualification" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasSpecialQualification"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="SpecialQualificationName"><input type="hidden"
	name="title" value="Special Qualification"><input type="hidden"
	name="<%=JSP_NAME %>" value="hrSpecialQualification"><input
	type="hidden" name="pojoPropertyCode" value="SpecialQualificationCode"><label
	class="auto"><span>*</span> Special Qualification Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Special Qualification Code,string,yes" MAXLENGTH="8"
	/ tabindex=1><label class="auto"><span>*</span> Special Qualification Name</label> <input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Special Qualification Name,string,yes" MAXLENGTH="30"
	/ tabindex=1><script>
				document.specialQualification.<%=CODE%>.focus();
			</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('specialQualification','educationMasters?method=addSpecialQualificationMaster');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"	style="display: none;" class="button"	onClick="submitForm('specialQualification','educationMasters?method=editSpecialQualificationMaster')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"	style="display: none;" class="button"	onClick="submitForm('specialQualification','educationMasters?method=deleteSpecialQualificationMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="paddingtop40"></div>
</div>



<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Qualification Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>";

data_header[1] = new Array;
data_header[1][0] = "Qualification Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSpecialQualificationMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasSpecialQualification  hrMasSpecialQualification = (HrMasSpecialQualification)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasSpecialQualification.getId()%>
data_arr[<%= counter%>][1] = "<%= hrMasSpecialQualification.getSpecialQualificationCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasSpecialQualification.getSpecialQualificationName()%>"
data_arr[<%= counter%>][3] = "<%= hrMasSpecialQualification.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasSpecialQualification.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= hrMasSpecialQualification.getLastChgTime() %>" 
<% if(hrMasSpecialQualification.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "specialQualification"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
