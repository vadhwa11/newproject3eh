<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * vital.jsp  
 * Purpose of the JSP -  This is for Task Type  Details.
 * @author  Vishal
 * Create Date: 14th August,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrVitals" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchVitalsList = (ArrayList)map.get("searchVitalsList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>

<div class="titleBg"> 
<h2> Vitals Master</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Vitals Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Vitals Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Vitals  Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchVitals')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchVitals','checkSearch')" tabindex=1  />
	<%--- Report Button   <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mstr_TaskType">  --%>
    
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
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchVitalsList.size()>0)
		 {	String strForCode = (String)map.get("vitalsCode");
			String strForCodeDescription = (String)map.get("vitalsName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showVitalsJsp">Show All Records</a>
	<%
			}
		 }
	if(searchVitalsList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showVitalsJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= VITALS_FLAG %>"],[4,"<%= AMOUNT_FLAG %>"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="vitals" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
<script type="text/javascript">
function showComboAccordingToVisitFlag(flag){
	if(flag=='V'){
		document.getElementById('amount_flag').style.display='block';
	}
	else{
		document.getElementById('amount_flag').style.display='none';
		}
	}
</script>
	<input type="hidden" name="<%= POJO_NAME %>" value = "MstrVitals">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VitalDescription">
  	<input type="hidden" name="title" value = "Vitals">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "vital">
  	<input type="hidden" name="pojoPropertyCode" value = "VitalCode">
<div class="division"></div>
	<label><span>*</span>Vitals Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Vitals Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Vitals Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Vitals Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addVitals')" >
  	<div class="clear"></div>
  	<label>Flag</label>
    <select name="<%=VITALS_FLAG %>" id="flag" validate="Flag,string,no" onchange="showComboAccordingToVisitFlag(this.value);">
    <option value="">Select</option>
    <option value="V">Value</option>
	<option value="D">Date</option>
	</select>
	<div id="amount_flag" style="display:none;">
	<label>Amount Flag</label>
    <select name="<%=AMOUNT_FLAG %>" id="amount_flag" validate="Amount Flag,string,no">
    <option value="">Select</option>
    <option value="yes">Yes</option>
	<option value="no">No</option>
	</select>

<script>
	document.vitals.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
			
	<label>Changed By:</label>   
	<label class="value"><%=userName%></label>
			        
	<label>Changed Date:</label>   
	<label class="value"><%=date%></label>
			 
	<label>Changed Time:</label>   
	<label class="value"><%=time%></label>
			 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
	<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
	<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
	
<div class="division"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('vitals','projectTrackingMaster?method=addVitals');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('vitals','projectTrackingMaster?method=editVitals')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('vitals','projectTrackingMaster?method=deleteVitals&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Vitals Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Vitals Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Flag"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%= VITALS_FLAG %>";

data_header[3] = new Array;
data_header[3][0] = "Amount Flag"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= AMOUNT_FLAG %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchVitalsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MstrVitals  mstrVitals = (MstrVitals)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] =  <%= mstrVitals.getId()%>
data_arr[<%= counter%>][1] = "<%= mstrVitals.getVitalCode()%>"
data_arr[<%= counter%>][2] = "<%= mstrVitals.getVitalDescription()%>"
<%if(mstrVitals.getFlag() != null){%>
data_arr[<%= counter%>][3] = "<%= mstrVitals.getFlag()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
data_arr[<%= counter%>][4] = "<%= mstrVitals.getAmountFlag()%>"
data_arr[<%= counter%>][5] = "<%= mstrVitals.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= mstrVitals.getLastChgDate() %>"
data_arr[<%= counter%>][7] = "<%= mstrVitals.getLastChgTime()%>"

<% if(mstrVitals.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "vitals"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  