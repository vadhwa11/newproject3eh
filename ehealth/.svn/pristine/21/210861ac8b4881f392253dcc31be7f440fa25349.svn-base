<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * block.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: o7th April, 2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%-- <%@page import="jkt.hms.masters.business.MasHospital"%> --%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<!-- govind code -->
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasWard> masWardList = new ArrayList<MasWard>();
	//List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	List<MasVillage> masVillageList = new ArrayList<MasVillage>();
	//govind code
	List<MasLsg> masLsgList = new ArrayList<MasLsg>();
	List<MasDistrict> masDistrictList = new ArrayList<MasDistrict>();
	
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masWardList") != null){
		masWardList = (ArrayList)map.get("masWardList");
	}
	
	/* if(map.get("masHospitalList") != null){
		masHospitalList = (ArrayList)map.get("masHospitalList");
	} */
	if(map.get("masVillageList") != null){
		masVillageList = (ArrayList)map.get("masVillageList");
	}
	
	//govind code
	if(map.get("masLsgList") != null){
		masLsgList = (ArrayList)map.get("masLsgList");
	}
	
	if(map.get("masDistrictList") != null){
		masDistrictList = (ArrayList)map.get("masDistrictList");
		System.out.println("jsp district List size "+masDistrictList.size());
	}
	//end code
	
	if(map.get("message") != null){
		 
	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}
%>
<div class="titleBg">
<h2>Ward Master</h2>
</div>
<div class="Block">
<div class="Ward">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>Ward Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Ward Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 

<input type="hidden" name="colCode" value="ward_code">
<input type="hidden" name="colName" value="ward_name">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Ward Code,string,no" MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchWard')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchWard','checkSearch')"	tabindex=1 />
<input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_ward">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		//if(masVillageList.size()>0 || masWardList.size() > 0)
			if(masLsgList.size()>0 || masWardList.size() > 0)//govind code
		 {
			String strForCode = (String)map.get("wardCode");
			String strForCodeDescription = (String)map.get("wardName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="generalMaster?method=showWardJsp">Show All Records </a></h4>

<%
			}
		 }
	 //if(masVillageList.size()==0 && map.get("search") != null)
		 if(masLsgList.size()==0 && map.get("search") != null)//govind code
	  {
	 %> <h4><a href="generalMaster?method=showWardJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

<%--	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"villageId"] ,[4,"<%=HOSPITAL_ID%>"],[5,"<%=CHANGED_BY%>"], [6,"<%=CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"]];	 
		 statusTd = 8;--%>
		 //govind code
		 formFields = [
			 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"districtId"] ,[4,"lsgId"],[5,"<%=HOSPITAL_ID%>"],[6,"<%=CHANGED_BY%>"], [7,"<%=CHANGED_DATE%>"],[8,"<%=CHANGED_TIME%>"],[9,"<%=STATUS%>"],[10,"disId"]];	 
				 statusTd = 9;
	</script></div>

<form name="wardName" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasWard"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="WardName">
<input type="hidden" name="title" value="Ward"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="ward"> 
<input	type="hidden" name="pojoPropertyCode" value="WardCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Ward">
<div class="Block">
<label><span>*</span> Ward Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Ward Code,string,yes" class="textbox_size20" MAXLENGTH="20"	tabindex=1 /> 
<label><span>*</span> Ward Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Ward  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 />
 <script>
 		document.wardName.<%=CODE%>.focus();
			</script>


<!-- <label><span>*</span> Village </label>  -->
<!-- <select	name="villageId" validate="Village,string,yes" tabindex=1	> -->
<!-- 	<option value="0">Select</option> -->
<%-- 	<%  --%>
				
<!-- // 		for (MasVillage  masVillage : masVillageList){ -->
<%-- 				%> --%>
<%-- 	<option value="<%=masVillage.getId ()%>"><%=masVillage.getVillageName()%></option> --%>

<%-- 	<%}%> --%>
<!-- </select> -->

<!-- govind code 5-7-2016 -->
<label><span>*</span> District</label> 
<select	name="districtId" validate="District,string,yes" tabindex=1	onchange=" populateLsgByDistrictId(this.value)" id="districtId">
	<option value="0">Select</option>
	<% 
				
				for (MasDistrict  masDistrict : masDistrictList){
				%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>

	<%}%>
</select>
<div class="clear"></div>
<label><span>*</span> LSG</label> 
<select	name="lsgId" validate="Lsg,string,yes" tabindex=1 id="lsgId">
	<option value="0">Select</option>
<%-- 	<% 
				
				for (MasLsg  masLsg : masLsgList){
				%>
	<option value="<%=masLsg.getId ()%>"><%=masLsg.getLsgTypeName()%></option>

	<%}%> --%>
</select>

<div class="clear"></div>
<%-- <label><span>*</span> Sub Center </label> 
<select	name="<%=HOSPITAL_ID%>" validate="Sub Center,string,yes" tabindex=1	>
	<option value="0">Select</option>
	<% 
				
				for (MasHospital  masHospital : masHospitalList){
				%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>

	<%}%>
</select> --%>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('wardName','generalMaster?method=addWard');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('wardName','generalMaster?method=editWard')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('wardName','generalMaster?method=deleteWard&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
</div>
</div>

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
data_header[0][0] = "Ward Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Ward Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

// data_header[2] = new Array;
// data_header[2][0] = "Village"
// data_header[2][1] = "data";
// data_header[2][2] = "40%";
// data_header[2][3] = "talukId";

//govind code
data_header[2] = new Array;
data_header[2][0] = "District";
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "districtId";

data_header[3] = new Array;
data_header[3][0] = "LSG";
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "lsgId";
//end

data_header[4] = new Array;
data_header[4][0] = "Sub Center";
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%=HOSPITAL_ID%>";

data_header[5] = new Array;
data_header[5][0] = "";
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY%>";

data_header[6] = new Array;
data_header[6][0] = "Admin";
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE%>"

data_header[7] = new Array;
data_header[7][0] = "";
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME%>";


data_header[8] = new Array;
data_header[8][0] = "Status";
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";



data_header[9] = new Array;
data_header[9][0] = "disId";
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "disId";

data_arr = new Array();

<%
Iterator itr=masWardList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasWard  masWard = (MasWard)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masWard.getId()%>
data_arr[<%= counter%>][1] = "<%=masWard.getWardCode()%>"
data_arr[<%= counter%>][2] = "<%= masWard.getWardName()%>"


<%--<%
Iterator itrmasVillageList=masVillageList.iterator();
 while(itrmasVillageList.hasNext())
    {
     MasVillage  masVillage = (MasVillage)itrmasVillageList.next(); 
    
	 if(masWard.getVillage()!=null && masWard.getVillage().getId().equals(masVillage.getId()) && masVillage.getStatus().equals("Y")){
	
	 %>
		data_arr[<%= counter%>][3] = "<%=masVillage.getVillageName().trim()%>"
	<%}else if(masWard.getVillage()!=null  && masWard.getVillage().getId().equals(masVillage.getId()) && masVillage.getStatus().equals("N")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masVillage.getVillageName().trim()%>";
		
	<%}
}%>--%>

/* Changed by Arbind on 01-08-2017 -------District and Lsg */

//govind code
<%-- <%
Iterator itrmasDistrictList=masDistrictList.iterator();
while(itrmasDistrictList.hasNext())
   {
    MasDistrict  masDistrict = (MasDistrict)itrmasDistrictList.next(); 
   
	 if(masWard.getDistrict()!=null && masWard.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equals("Y")){
	
	 %>
		data_arr[<%= counter%>][3] = "<%=masDistrict.getDistrictName().trim()%>";
	<%}else if(masWard.getDistrict()!=null  && masWard.getDistrict().getId().equals(masDistrict.getId()) && masDistrict.getStatus().equals("N")){%>
		data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masDistrict.getDistrictName().trim()%>";
	<%}
}%> --%>

<%if(masWard.getDistrict() != null && masWard.getDistrict().getStatus().equals("Y")) { %>
data_arr[<%= counter%>][3] = "<%=masWard.getDistrict().getDistrictName().trim()%>";
data_arr[<%= counter%>][10] = "<%=masWard.getDistrict().getId()%>";
<% } else if(masWard.getDistrict() != null && masWard.getDistrict().getStatus().equals("N")) { %>
data_arr[<%= counter%>][3] = "<span>*</span>Parent InActivated--<%=masWard.getDistrict().getDistrictName().trim()%>";
data_arr[<%= counter%>][10] = "<%=masWard.getDistrict().getId()%>";
<% } else { %>
data_arr[<%= counter%>][3] = "-";
data_arr[<%= counter%>][10] = "0";
<% } %>

<%-- <%
Iterator itrmasLsgList=masLsgList.iterator();
 while(itrmasLsgList.hasNext())
    {
     MasLsg  masLsg = (MasLsg)itrmasLsgList.next(); 
    
	 if(masWard.getLsg()!=null && masWard.getLsg().getId().equals(masLsg.getId()) && masLsg.getStatus().equals("Y")){
	
	 %>
		data_arr[<%= counter%>][4] = "<%=masLsg.getLsgTypeName().trim()%>";
	<%}else if(masWard.getLsg()!=null  && masWard.getLsg().getId().equals(masLsg.getId()) && masLsg.getStatus().equals("N")){%>
		data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masLsg.getLsgTypeName().trim()%>";
	<%}
}%> --%>

<%if(masWard.getLsg() != null && masWard.getLsg().getStatus().equalsIgnoreCase("Y")) { %>
data_arr[<%= counter%>][4] = "<%=masWard.getLsg().getLsgTypeName().trim()%>";
<% } else if(masWard.getLsg() != null && masWard.getLsg().getStatus().equalsIgnoreCase("N")) { %>
data_arr[<%= counter%>][4] = "<span>*</span>Parent InActivated--<%=masWard.getLsg().getLsgTypeName().trim()%>";
<% } else { %>
data_arr[<%= counter%>][4] = "-";
<% } %>

//end

<%-- <%
Iterator itrmasBasicSectionList=masHospitalList.iterator();
 while(itrmasBasicSectionList.hasNext())
    {
     MasHospital  masHospital = (MasHospital)itrmasBasicSectionList.next(); 
    
	 if(masWard.getSubCenter()!=null && masWard.getSubCenter().getId().equals(masHospital.getId()) && masHospital.getStatus().equals("y")){
	
	 %>
		data_arr[<%= counter%>][4] = "<%=masHospital.getHospitalName().trim()%>"
	<%}else if(masWard.getSubCenter()!=null && masWard.getSubCenter().getId().equals(masHospital.getId()) && masHospital.getStatus().equals("n")){%>
		data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=masHospital.getHospitalName().trim()%>";
		
	<%}
}%> --%>

data_arr[<%= counter%>][6] = "<%= masWard.getLastChgBy()!=null?(masWard.getLastChgBy().getId()!=null?masWard.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masWard.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masWard.getLastChgTime() %>"
<% if(masWard.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive";
<%}%>

<%
	     counter++;
}
%>
 
formName = "wardName"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script type="text/javascript" src="/hms/jsp/js/ward.js"></script>