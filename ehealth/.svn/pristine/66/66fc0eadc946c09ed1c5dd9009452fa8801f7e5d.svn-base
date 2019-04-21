<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * vendorServiceType.jsp  
 * Purpose of the JSP -  This is for Vendor Service Type  Details.
 * @author  Vishal
 * Create Date: 10th Aug,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9 
--%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.VendorServiceType" %>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchVendorServiceTypeList = (ArrayList)map.get("searchVendorServiceTypeList");
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
<h2>Vendor Service Type</h2></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Vendor Service Type Code:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Vendor Service Type Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Vendor Service Type Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTrackingMaster?method=searchVendorServiceType')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTrackingMaster?method=searchVendorServiceType','checkSearch')" tabindex=1  />
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
	 
		if(searchVendorServiceTypeList.size()>0)
		 {	String strForCode = (String)map.get("vendorServiceTypeCode");
			String strForCodeDescription = (String)map.get("vendorServiceTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{ 
		%> 
	<div class="clear"></div>
    
    <a href="projectTrackingMaster?method=showVendorServiceTypeJsp">Show All Records</a>
	<%
			}
		 }
	if(searchVendorServiceTypeList.size()==0 && map.get("search") != null)
	  {
		
	 %>
				<a href="projectTrackingMaster?method=showVendorServiceTypeJsp">Show All Records</a>

	 <%
    }
	%>
	<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="vendorServiceType" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block">
	

	<input type="hidden" name="<%= POJO_NAME %>" value = "VendorServiceType">
  	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="VendorServiceName">
  	<input type="hidden" name="title" value = "VendorServiceType">
  	<input type="hidden" name="<%=JSP_NAME %>" value = "vendorServiceType">
  	<input type="hidden" name="pojoPropertyCode" value = "VendorServiceCode">
<div class="division"></div>
	<label><span>*</span>Vendor Service Type Code: </label>
  	<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Vendor Service Type Code,string,yes" MAXLENGTH="8"/ tabindex=1 >
  	<label><span>*</span>Vendor Service Type Name:</label>
  	<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Vendor Service Type Name,string,yes" MAXLENGTH="50"/ tabindex=1 onkeypress="return submitenter(this,event,'projectTrackingMaster?method=addVendorServiceType')" >

<script>
	document.calendar.<%=CODE%>.focus();
</script>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

	<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('vendorServiceType','projectTrackingMaster?method=addVendorServiceType');" accesskey="a" tabindex=1/>

	<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('vendorServiceType','projectTrackingMaster?method=editVendorServiceType')" accesskey="u" tabindex=1 />

	<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;"  class="button" onClick="submitForm('vendorServiceType','projectTrackingMaster?method=deleteVendorServiceType&flag='+this.value)" accesskey="d" tabindex=1/>		

	<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
		
	<input type="hidden" name="<%=STATUS %>" value="" />
		
	<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
 			
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
<div class="clear"></div>
<div class="clear"></div>
			
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Vendor Service Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

	
data_header[1] = new Array;
data_header[1][0] = "Vendor Service Type Name"
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
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchVendorServiceTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  VendorServiceType  vendorServiceType = (VendorServiceType)itr.next(); 		
   %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= vendorServiceType.getId()%>
data_arr[<%= counter%>][1] = "<%=vendorServiceType.getVendorServiceCode()%>"
data_arr[<%= counter%>][2] = "<%= vendorServiceType.getVendorServiceName()%>"
data_arr[<%= counter%>][3] = "<%= vendorServiceType.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= vendorServiceType.getLastChgDate() %>"
data_arr[<%= counter%>][5] = "<%= vendorServiceType.getLastChgTime()%>"

<% if(vendorServiceType.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "vendorServiceType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  