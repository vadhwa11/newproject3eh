<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital;"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

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
ArrayList searchHospitalList = (ArrayList)map.get("searchHospitalList");
List<MasHospital> masHospitalList = (List<MasHospital>)map.get("searchHospitalList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
List<MasHospitalType> masHospitalTypeList = new ArrayList<MasHospitalType>();
if(map.get("masHospitalTypeList") != null){
	masHospitalTypeList = (List<MasHospitalType>)map.get("masHospitalTypeList");
	
}


List<MasDistrict> districtList = new ArrayList<MasDistrict>();
districtList = (ArrayList)map.get("districtList");

if(map.get("message") != null){
	   String message = (String)map.get("message");
	 %>
<h4><span><%=message %></span></h4>
<%}

%>

<!--main content placeholder starts here-->

<h2>Institution Master</h2>
<div class="clear"></div>
<!--Block One Starts-->
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">

<label>Institution Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"	checked="checked" class="radioCheck" onClick="showInsDis(this)"/> 

<label>Institution Name</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" onClick="showInsDis(this)"/>

<label>District</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="3" class="radioCheck" onClick="showInsDis(this)"/>

<label>Institute Type</label> 
<input	type="radio" name="<%=SELECTED_RADIO %>" value="4" class="radioCheck" onClick="showInsDis(this)"/>

  <div id="code" style="display: inline;">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""	validate="Institution Code,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'user?method=searchHospital','checkSearch')" />
</div>

  <div id="dis" style="display: none;">


<select name="<%= SEARCH_FIELD%>1" id="searchField"  validate="District,string,no" tabindex=1 tabindex=1>
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict d = (MasDistrict) iterator.next();
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getDistrictName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
</div>

  <div id="ins" style="display: none;">

<select  name="<%= SEARCH_FIELD%>2" id="searchField" validate="Institution ,string,no">
<option value="0">Select</option>
 <%
				         		if(masHospitalTypeList != null){ 	
				         				for (MasHospitalType masHospitalTyp :masHospitalTypeList) {
				         					if(masHospitalTyp.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masHospitalTyp.getId()%>"><%=masHospitalTyp.getHospitalTypeName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select>
</div>

<!-- <input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=searchHospital','checkSearch')"	tabindex=1 /> -->
 <input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','user?method=searchHospital')"	tabindex=1 /> 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchHospitalList.size()>0)
		 {
			String strForCode = (String)map.get("hospitalCode");
			String strForCodeDescription = (String)map.get("hospitalName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="user?method=showHospitalJsp">Show All Records</a> <%
			}
		 }
	 if(searchHospitalList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="user?method=showHospitalJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"sparkid"], [4,"institutionShortName"],[5,"hospitalTypeId"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"<%= ADDRESS %>"],[10,"<%= CONTACT_NUMBER %>"],[11,"<%= CHANGED_BY%>"]
			,[12,"nameChange"],[13,"typeChange"],[14,"districtId"],[15,"parentInstitute"],[16,"talukId"]];
	 statusTd = 8;
	</script>
<div class="clear"></div>
</div>
<form name="hospital" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasHospital"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HospitalName"><input
	type="hidden" name="title" value="Hospital"><input
	type="hidden" name="<%=JSP_NAME %>" value="hospital"><input
	type="hidden" name="pojoPropertyCode" value="HospitalCode">
<div class="Clear"></div>
<div class="paddingTop15"></div>
<div class="Block">

<label><span>*</span> Institution Code </label>
 <input id="codeId"  type="text"	name="<%= CODE%>" value="" validate="Institution Code,string,no"	MAXLENGTH="8" tabindex=1 />
  <label ><span>*</span> Institution Name</label> 
  <input id="hospitalName" type="text" name="<%= SEARCH_NAME %>" value="" validate="Institution Name,string,no"	MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'user?method=addHospital')" />
  <input id="nameChange" type="hidden" name="nameChange" value="" 	MAXLENGTH="30" tabindex=1	 />
  
  <script>
document.hospital.<%=CODE%>.focus();
</script> 

<label>Spark ID</label> 
<input type="text"	 name="sparkId" id="sparkId" value=""	validate="Spark ID,num,no" MAXLENGTH="12" tabindex=1 /> 


<div class="clear"></div>
<label>Institution Short Name</label> 
<input type="text"	 name="institutionShortName" id="institutionShortName" value=""	validate="Institution Short Name,string,no" MAXLENGTH="12" tabindex=1 /> 



<label><span>*</span> Institution Type</label> 
<select name="hospitalTypeId" id="hospitalTypeId" validate="Institution Type,string,yes">
<option value="0">Select</option>
 <%
				         		if(masHospitalTypeList != null){ 	
				         				for (MasHospitalType masHospitalType :masHospitalTypeList) {
				         				
				         %>
					  
						 <option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName() %></option> 
				        <%		
				        			}
				        		 } 
				        %>
			      </select>

</select>
<input id="typeChange" type="hidden" name="typeChange" value="" 	MAXLENGTH="30" tabindex=1	 />

<label>Parent Institutions</label> 
<select name="parentInstitute" id="parentInstitute">
<option value="0">Select</option>
 <%
				         		if(masHospitalList != null){ 	
				         				for (MasHospital masHospital :masHospitalList) {
				         					if(masHospital.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select>
			     <div class="clear"></div>
			     <label>Head of Insttution</label> 
<select name="hoi" id="hoi">
<option value="0">Select</option>
 <%
				         		if(masHospitalList != null){ 	
				         				for (MasHospital masHospital :masHospitalList) {
				         					if(masHospital.getStatus().equalsIgnoreCase("y")){
				         					
				         				
				         %>
					  
						 <option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName() %></option> 
				        <%	}	
				        			}
				        		 } 
				        %>
			      </select>




<label>Address</label> <!--<textarea maxlength="5	0" rows="0" name="<%=ADDRESS %>" onkeyup="return ismaxlength(this)"  tabindex="1"></textarea>-->

<input type="text" name="<%= ADDRESS %>" id="hospitalAdd"	value="" validate="Address Name,string,no" MAXLENGTH="70" tabindex=1 />


<label>Street</label>

<input type="text" name="street"  id="street"	value="" validate="Address Street,string,no" MAXLENGTH="70" tabindex=1 />

<div class="clear"></div>
<label>Locality</label>

<input type="text" name="locality"  id="locality"	value="" validate="Address Locality,string,no" MAXLENGTH="70" tabindex=1 />

<label><span>*</span> District</label>
<select name="districtId" id="districtId"  validate="District,string,yes" tabindex=1 onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getTalukList&district='+this.value,'testDiv');" tabindex=1>
<%	if(districtList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = districtList.iterator(); iterator.hasNext();) {
					 MasDistrict d = (MasDistrict) iterator.next();
				  %>
				  <option value="<%=d.getId ()%>"><%=d.getDistrictName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


<div id="testDiv">
<label> Taluk</label>
<select name="talukId" validate="Taluk,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>

</div>	
<div class="clear"></div>

<label>Contact Number</label> 
<input type="text" 	name="<%= CONTACT_NUMBER %>" id="hospitalContact" value=""	validate="Contact Number,num,no" MAXLENGTH="12" tabindex=1 /> 

<label>LSG</label> 
<select name="lsg" id="lsg" onchange="lsgData();">
 <option value="">Select</option>
 <option value="Panchayath">Panchayath</option>
 <option value="Municipality">Municipality</option>
 <option value="Corporation">Corporation</option>
</select>
   <div id="panchayathId" style="display: none;">
   <label>LSG Panchayath Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Panchayath Name,string,no" MAXLENGTH="20" tabindex=1 />
   </div>
   
   <div id="municipalityId" style="display: none;">
   <label>LSG Municipality Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Municipality Name,string,no" MAXLENGTH="20" tabindex=1 />
   </div>
   
   <div id="corporationId" style="display: none;">
   <label>LSG Corporation Name</label>
    <input type="text" name="lsgName"  id="lsgName"	value="" validate="LSG Corporation Name,string,no" MAXLENGTH="20" tabindex=1 />
   </div>

<label>Ward</label>
    <select name="wardId" id="wardId">
    <option value="0">Select</option>
        </select>
<div class="clear"></div>
<label>Post Office</label>
    <select name="postOfficeId" id="postOfficeId">
    <option value="0">Select</option>
        </select>
  
  <label>PIN</label>
   <input type="text" name="pin"  id="pin"	value="" validate="PIN,string,no" MAXLENGTH="20" tabindex=1 />
 
  <label>Assembly</label>
   
   
   <select name="assembly"  id="assembly" validate="Assembly,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>


<div class="clear"></div>
  <label>Parliament</label>
  
    <select name="parliament"  id="parliament" validate="Parliament,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
<label>Village</label>
  
    <select name="village"  id="village" validate="Village,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
<label>Revenue Block</label>
  
    <select name="rev_block"  id="rev_block" validate="Revenue Block,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
<div class="clear"></div>
<label>Land Line</label>
   <input type="text" name="landline"  id="landline"	value="" validate="Land Line,string,no" MAXLENGTH="20" tabindex=1 />
   <label>Email Id</label>
   <input type="text" name="email"  id="email"	value="" validate="Email Id,string,no" MAXLENGTH="20" tabindex=1 />
   
   
   
    <label>Sanction Bed</label>
   <input type="text" name="bedCapacity"  id="bedCapacity"	value="" validate="Bed Capacity,string,no" MAXLENGTH="20" tabindex=1 />
   
</div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" 	class="button"	onClick="submitForm('hospital','user?method=addHospital','checkBlankForAddHospital');"	accesskey="a" tabindex=1 />

<input type="button" name="edit"	id="editbutton" value="Update" style="display: none;" class="button"	onClick="submitForm('hospital','user?method=editHospital')"	accesskey="u" tabindex=1 /> 

<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	class="button"	onClick="submitForm('hospital','user?method=deleteHospital&flag='+this.value)"	accesskey="d" tabindex=1 />

<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" /> 

<input type="button"	name="Back" value="Back" class="button" accesskey="b"	onclick="submitFormForButton('hospital','superAdmin?method=showModuleManagementJsp')"	tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=date%></label> 

<label>Changed Time</label> <label class="value"><%=time%></label>
 <input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
 </div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Institution Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Institution Name"
data_header[1][1] = "data";
data_header[1][2] = "35%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = "Saprk ID"
data_header[2][1] = "hide";
data_header[2][2] = "25%";
data_header[2][3] = "sparkid"

data_header[3] = new Array;
data_header[3][0] = "Institute Short Name"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "institutionShortName";



data_header[4] = new Array;
data_header[4][0] = "Institute Type"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "hospitalTypeId";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";


data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Address"
data_header[8][1] = "data";
data_header[8][2] = "25%";
data_header[8][3] = "<%= ADDRESS%>"

data_header[9] = new Array;
data_header[9][0] = "Contact Number"
data_header[9][1] = "hide";
data_header[9][2] = "40%";
data_header[9][3] = "<%= CONTACT_NUMBER %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%= CHANGED_BY%>";

data_header[11] = new Array;
data_header[11][0] = "Institute Name Change Count"
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "nameChange";

data_header[12] = new Array;
data_header[12][0] = "Institute type Change Count"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "typeChange";

data_header[13] = new Array;
data_header[13][0] = "District"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "districtId";

data_header[14] = new Array;
data_header[14][0] = "Parent Institution"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "parentInstitute";

data_header[15] = new Array;
data_header[15][0] = "Taluk"
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "talukId";


data_arr = new Array();

<%
Iterator itr=searchHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasHospital  masHospital = (MasHospital)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHospital.getId()%>
data_arr[<%= counter%>][1] = "<%=masHospital.getHospitalCode()%>"
data_arr[<%= counter%>][2] = "<%= masHospital.getHospitalName()%>"

data_arr[<%= counter%>][3] = "<%=masHospital.getSparkId()%>"
data_arr[<%= counter%>][4] = "<%= masHospital.getShortName()%>"
	
data_arr[<%= counter%>][5] = "<%= masHospital.getHospitalType()!=null? masHospital.getHospitalType().getHospitalTypeName():""%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masHospital.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masHospital.getLastChgTime() %>"
<% if(masHospital.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

data_arr[<%= counter%>][9] = "<%=masHospital.getAddress()%>"
	data_arr[<%= counter%>][10] = "<%= masHospital.getContactNumber()%>"
	data_arr[<%= counter%>][11] = "<%= masHospital.getLastChgBy()!=null?(masHospital.getLastChgBy().getId()!=null?masHospital.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][12] =  "<%= masHospital.getHospitalNameChangeCount()!=null? masHospital.getHospitalNameChangeCount():"0"%>"
	data_arr[<%= counter%>][13] =  "<%= masHospital.getHospitalTypeChangeCount()!=null? masHospital.getHospitalTypeChangeCount():"0"%>"
	data_arr[<%= counter%>][14] =  "<%= masHospital.getDistrict()!=null ? masHospital.getDistrict().getDistrictName():""%>"
			
		
		data_arr[<%= counter%>][15] = "<%= masHospital.getParentInstitute()!=null ? masHospital.getParentInstitute().getHospitalName():""%>"
			data_arr[<%= counter%>][16] =  "<%= masHospital.getTaluk()!=null ? masHospital.getTaluk().getTalukName():""%>"
				
<%
		     counter++;
}
%>
 
formName = "hospital"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script>

function lsgData(){

var lsgId=document.getElementById('lsg').value;

if(lsgId=="Panchayath"){
       document.getElementById('panchayathId').style.display = "inline";
       document.getElementById('municipalityId').style.display = "none";
       document.getElementById('corporationId').style.display = "none";
}
if(lsgId=="Municipality"){
    document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "inline";
    document.getElementById('corporationId').style.display = "none";
}
if(lsgId=="Corporation"){
    document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "none";
    document.getElementById('corporationId').style.display = "inline";
}
if(lsgId==""){
	document.getElementById('panchayathId').style.display = "none";
    document.getElementById('municipalityId').style.display = "none";
    document.getElementById('corporationId').style.display = "none";
    document.getElementById('lsg').value="";
	
}
}

function showInsDis(val){
	
	<%-- var val=document.getElementById('<%=SELECTED_RADIO  %>'); --%>
	
	if(val.value=="1"){
	       document.getElementById('code').style.display = "inline";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "none";
	}
	if(val.value=="2"){
		document.getElementById('code').style.display = "inline";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "none";
	}
	if(val.value=="3"){
		document.getElementById('code').style.display = "none";
	       document.getElementById('ins').style.display = "none";
	       document.getElementById('dis').style.display = "inline";
	}
	if(val.value=="4"){
		document.getElementById('code').style.display = "none";
	       document.getElementById('ins').style.display = "inline";
	       document.getElementById('dis').style.display = "none";
		
	}
	
	
}
</script>
