<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * labAntibioticsMst.jsp  
 * Purpose of the JSP -  This is for Antibiotics Master.
 * @author  Vishal Jain
 * Create Date: 12th August,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAntibioticLab"%>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList searchAntibioticList = (ArrayList)map.get("searchAntibioticList");
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
<h2>Antibiotic Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Antibiotic Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Antibiotic Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Antibiotic Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=searchAntibioticLab')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchAntibioticLab','checkSearch')" tabindex=1 />
<%--- Report Button   
<input type="button" name="report" value="Generate Report Based on Search" class="button" onclick="submitForm('search','laboratory?method=generateReportForLabAntibiotic')" tabindex=1  /> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="AntibioticMaster"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchAntibioticList.size()>0)
		 {
			String strForCode = (String)map.get("antibioticCode");
			String strForCodeDescription = (String)map.get("antibioticName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="laboratory?method=showAntibioticLabJsp">Show All
Records</a></h4> <%
			}
		 }
		
	 if(searchAntibioticList.size()==0 && map.get("search") != null)
	  {
		 
	 %> <h4><a href="laboratory?method=showAntibioticLabJsp">Show All
Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<form name="labAntibiotic" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasAntibioticLab">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AntibioticLabName">
<input type="hidden" name="title" value="labAntibiotic">
<input type="hidden" name="<%=JSP_NAME %>" value="labAntibioticsMst">
<input type="hidden" name="pojoPropertyCode" value="AntibioticLabCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Antibiotic Code </label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Antibiotic Code,string,yes" class="textbox_date" MAXLENGTH="8" / tabindex=1>
<label><span>*</span> Antibiotic Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Antibiotic Name,string,yes" class="textbox_date" MAXLENGTH="30" / tabindex=1 onkeypress="return submitenter(this,event,'laboratory?method=addAntibioticLab')">
<script>
	document.labAntibiotic.<%=CODE%>.focus();
	</script>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('labAntibiotic','laboratory?method=addAntibioticLab');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('labAntibiotic','laboratory?method=editAntibioticLab')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('labAntibiotic','laboratory?method=deleteAntibioticLab&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden" name="<%= COMMON_ID%>" value="" />
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
		data_header[0][0] = "Antibiotic Code"
		data_header[0][1] = "data";
		data_header[0][2] = "10%";
		data_header[0][3] = "<%= CODE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Antibiotic Name"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";
		
		data_header[2] = new Array;
		data_header[2][0] = ""
		data_header[2][1] = "hide";
		data_header[2][2] = 0;
		data_header[2][3] = "<%= CHANGED_BY%>"
		
		data_header[3] = new Array;
		data_header[3][0] = ""
		data_header[3][1] = "hide";
		data_header[3][2] = 0;
		data_header[3][3] = "<%= CHANGED_DATE%>"
		
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
	
	  
	Iterator itr = searchAntibioticList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	             MasAntibioticLab  MasAntibioticLab = (MasAntibioticLab)itr.next(); 
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= MasAntibioticLab.getId()%>
		data_arr[<%= counter%>][1] = "<%= MasAntibioticLab.getAntibioticLabCode()%>"
		data_arr[<%= counter%>][2] = "<%= MasAntibioticLab.getAntibioticLabName()%>"
		data_arr[<%= counter%>][3] = "<%= MasAntibioticLab.getLastChgBy() %>"
		data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(MasAntibioticLab.getLastChgDate())%>"
		data_arr[<%= counter%>][5] = "<%= MasAntibioticLab.getLastChgTime() %>"
		<% if(MasAntibioticLab.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][6] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][6] = "InActive"
		<%}%>
		<%
				     counter++;
		}
		%>
 
		formName = "labAntibiotic"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		</script>
