<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_instructorMaster.jsp  
 * Purpose of the JSP -  This is for Instructor details 
 * @author  Rajendra
 * Create Date: 23rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrMasInstructor"%>
<%@ page import="jkt.hrms.masters.business.HrMasQualification"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<HrMasQualification> qualificationList = new ArrayList<HrMasQualification>();
	List<HrMasQualification> gridQualificationList = new ArrayList<HrMasQualification>();

	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

	List<MasState> stateList = new ArrayList<MasState>();
	List<MasState> gridStateList = new ArrayList<MasState>();

	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

	List<HrMasInstructor> searchInstructorMasterList = new ArrayList<HrMasInstructor>();

	if (map.get("qualificationList") != null) {
		qualificationList = (List) map.get("qualificationList");
	}

	if (map.get("gridQualificationList") != null) {
		gridQualificationList = (List) map.get("gridQualificationList");
	}

	if (map.get("countryList") != null) {
		countryList = (List) map.get("countryList");
	}

	if (map.get("gridCountryList") != null) {
		gridCountryList = (List) map.get("gridCountryList");
	}

	if (map.get("stateList") != null) {
		stateList = (List) map.get("stateList");
	}

	if (map.get("gridStateList") != null) {
		gridStateList = (List) map.get("gridStateList");
	}
   	if (map.get("districtList") != null) {
		districtList = (List) map.get("districtList");
	}
	if (map.get("gridDistrictList") != null) {
		gridDistrictList = (List) map.get("gridDistrictList");
	}

	if (map.get("searchInstructorMasterList") != null) {
		searchInstructorMasterList = (List) map.get("searchInstructorMasterList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
%>



<script>

function getStateList(idvalue){
		var sel1 = document.getElementById("stateId");
		var sel2 = document.getElementById("cityId");
		removeAllOptions(sel1);
		removeAllOptions(sel2);
		var sel = document.getElementById("stateId");
		sel.options.add(new Option('Select', '0'));
		var sel3 = document.getElementById("cityId");
		sel3.options.add(new Option('Select', '0'));
	<%
		for (MasState masState : stateList) {
	%>
		
		if(idvalue ==<%=masState.getCountry().getId()%>){
			sel.options.add(new Option('<%=masState.getStateName()%>' , '<%=masState.getId()%>'));
	}

	<%
		}
	%>
	}
	
	
	function getCityList(idvalue){
		var sel1 = document.getElementById("cityId");
		removeAllOptions(sel1);
		var sel = document.getElementById("cityId");
		sel.options.add(new Option('Select', '0'));
	<%
		for (MasDistrict masDistrict : districtList) {
	%>
		
		if(idvalue ==<%=masDistrict.getState().getId()%>){
			sel.options.add(new Option('<%=masDistrict.getDistrictName()%>' , '<%=masDistrict.getId()%>'));
	}

	<%
		}
	%>
	}

	function removeAllOptions(selectbox)
	{
		var i;
		for(i=selectbox.options.length-1;i>=0;i--)
		{
			selectbox.remove(i);
		}
	}
	
	function getPinCode(){
		document.getElementById("pinCodeId").value="";
	}
	
</script>

<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>

<div class="titleBg">
<h2>Instructor Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Instructor
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" class="radioCheck" /> <label>Instructor Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2"
	class="radioCheck" /> <label>&nbsp;</label> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Instructor Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','training?method=searchInstructorMaster','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
 		if (searchInstructorMasterList.size() > 0) {
 			String strForCode = (String) map.get("instructorCode");
 			String strForCodeDescription = (String) map
 					.get("instructorName");
 			if (strForCode != null && strForCode != ""
 					|| strForCodeDescription != null
 					&& strForCodeDescription != "") {
 	%>
<h4><a href="training?method=showInstructorMasterJsp">Show All
Records</a></h4>
<%
		}
		}
		if (searchInstructorMasterList.size() == 0
				&& map.get("search") != null) {
	%>
<h4><a href="training?method=showInstructorMasterJsp">Show All
Records</a></h4>

<%
    	}
    %> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= INSTRUCTOR_TYPE %>"], [4,"<%= QUALIFICATION_ID %>"], [5,"<%= INSTRUCTOR_ADDRESS %>"], [6,"<%= DISTRICT %>"], [7,"<%= STATE %>"], [8,"<%= COUNTRY %>"], [9,"<%= PINCODE %>"], [10,"<%= PHONE_NO %>"], [11,"<%= REMARKS %>"], [12,"<%= CHANGED_BY%>"], [13,"<%= CHANGED_DATE %>"],[14,"<%= CHANGED_TIME %>"],[15,"<%=STATUS%>"] ];
	 statusTd = 15;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="instructor" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasInstructor"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="InstructorName"><input
	type="hidden" name="title" value="Instructor"><input
	type="hidden" name="<%=JSP_NAME %>" value="hr_instructorMaster"><input
	type="hidden" name="pojoPropertyCode" value="InstructorCode"><label><span>*</span>
Instructor Code</label> <input id="codeId" type="text" name="<%= CODE%>"
	value="" validate="Instructor Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1><label><span>*</span>
Instructor Name</label> <input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Instructor Name,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1><script>
				document.instructor.<%=CODE%>.focus();
			</script> <label><span>*</span> Instructor Type</label> <select
	name="<%= INSTRUCTOR_TYPE %>" validate="Instructor Type,string,yes"
	tabindex=1>

	<option value="">Select</option>
	<option value="y">Internal</option>
	<option value="n">External</option>
</select>
<div class="clear"></div>

<label><span>*</span> Instructor Qualification</label> <select
	name="<%= QUALIFICATION_ID %>"
	validate="Instructor Qualification,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			  	for (HrMasQualification hrMasQualification : qualificationList) {
			  %>

	<option value="<%=hrMasQualification.getId ()%>"><%=hrMasQualification.getQualificationName()%></option>

	<%}%>
</select> <label><span>*</span> Address</label> <input type="text" value=""
	name="<%=INSTRUCTOR_ADDRESS  %>" id="<%=INSTRUCTOR_ADDRESS  %>"
	validate="" class="large" MAXLENGTH="50" tabindex="1" />

<div class="clear"></div>

<label><span>*</span> Country</label> <select name="<%= COUNTRY %>"
	validate="Country,string,yes" tabindex=1
	onchange="getStateList(this.value);"
	onkeyUp="getStateList(this.value);">
	<option value="1">India</option>
	<%
				for (MasCountry masCountry : countryList) {
			%>

	<option value="<%=masCountry.getId ()%>"><%=masCountry.getCountryName()%></option>

	<%
				}
			%>
</select> <label><span>*</span> State</label> <select id="stateId"
	name="<%= STATE %>" validate="State,string,yes"
	onchange="getCityList(this.value);" onkeyUp="getCityList(this.value);"
	tabindex=1>
	<option value="10">Delhi</option>
	<%
					for (MasState masState : stateList) {
				%>

	<option value="<%=masState.getId ()%>"><%=masState.getStateName()%></option>

	<%
					}
				%>
</select> <label><span>*</span> City</label> <select id="cityId"
	name="<%= DISTRICT %>" validate="City,string,yes"
	onChange="getPinCode();" onkeyUp="getPinCode();" tabindex=1>
	<option value="102">Delhi</option>
	<%
					for (MasDistrict masDistrict : districtList) {
				%>

	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>

	<%
					}
				%>
</select>

<div class="clear"></div>

<label>Pincode</label> <input type="text" id="pinCodeId"
	name="<%= PINCODE %>" value="" validate="Pincode,int,no"
	class="textbox_size20" MAXLENGTH="6" / tabindex=1 /> <label>Phone
No</label> <input type="text" name="<%= PHONE_NO %>" value=""
	validate="Phone No,string,no" class="textbox_size20" MAXLENGTH="20"
	/ tabindex=1 />
<div class="clear"></div>

<label>Remarks</label> <input type="text" name="<%= REMARKS %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="60" tabindex=1 />

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('instructor','training?method=addInstructorMaster');"
	accesskey="a" tabindex=1 />

<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('instructor','training?method=editInstructorMaster')"
	accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('instructor','training?method=deleteInstructorMaster&flag='+this.value)"
	accesskey="d" tabindex=1 />

<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />

<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
<div class="paddingTop40"></div>


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Instructor Code"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Instructor Name"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Instructor Type"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= INSTRUCTOR_TYPE%>";

data_header[3] = new Array;
data_header[3][0] = "Instructor Qualification"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= QUALIFICATION_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Address"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "<%= INSTRUCTOR_ADDRESS%>";

data_header[5] = new Array;
data_header[5][0] = "City"
data_header[5][1] = "data";
data_header[5][2] = "";
data_header[5][3] = "<%= DISTRICT%>";

data_header[6] = new Array;
data_header[6][0] = "State"
data_header[6][1] = "data";
data_header[6][2] = "";
data_header[6][3] = "<%= STATE%>";

data_header[7] = new Array;
data_header[7][0] = "Country"
data_header[7][1] = "data";
data_header[7][2] = "";
data_header[7][3] = "<%= COUNTRY%>";

data_header[8] = new Array;
data_header[8][0] = "Pincode"
data_header[8][1] = "data";
data_header[8][2] = "";
data_header[8][3] = "<%= PINCODE%>";

data_header[9] = new Array;
data_header[9][0] = "Phone No"
data_header[9][1] = "data";
data_header[9][2] = "";
data_header[9][3] = "<%= PHONE_NO%>";

data_header[10] = new Array;
data_header[10][0] = "Remarks"
data_header[10][1] = "data";
data_header[10][2] = "";
data_header[10][3] = "<%= REMARKS%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_BY %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "<%=CHANGED_DATE %>"

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "";
data_header[13][3] = "<%=CHANGED_TIME %>";

data_header[14] = new Array;
data_header[14][0] = "Status"
data_header[14][1] = "data";
data_header[14][2] = "";
data_header[14][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchInstructorMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasInstructor  hrMasInstructor = (HrMasInstructor)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasInstructor.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasInstructor.getInstructorCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasInstructor.getInstructorName()%>"

<% if(hrMasInstructor.getInstructorType().equals("y")){ %>
data_arr[<%= counter%>][3] = "Internal"
<%}else{%>
data_arr[<%= counter%>][3] = "External"
<%}%>

<%
		Iterator itrGridQualificationList=gridQualificationList.iterator();
		 while(itrGridQualificationList.hasNext())
            {try{
             HrMasQualification  hrMasQualificationGrid = (HrMasQualification)itrGridQualificationList.next(); 
			 if(hrMasInstructor.getQualification().getId().equals(hrMasQualificationGrid.getId()) && hrMasQualificationGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=hrMasQualificationGrid.getQualificationName()%>"
			<%}else if(hrMasInstructor.getId().equals(hrMasQualificationGrid.getId()) && hrMasQualificationGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=hrMasQualificationGrid.getQualificationName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
   
  
data_arr[<%= counter%>][5] = "<%= hrMasInstructor.getAddress()%>"

<%
		Iterator itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {try{
             MasDistrict  masDistrictGrid = (MasDistrict)itrGridDistrictList.next(); 
			 if(hrMasInstructor.getDistrict().getId().equals(masDistrictGrid.getId()) && masDistrictGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][6] = "<%=masDistrictGrid.getDistrictName()%>"
			<%}else if(hrMasInstructor.getId().equals(masDistrictGrid.getId()) && masDistrictGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masDistrictGrid.getDistrictName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            
 <%
		Iterator itrGridStateList=gridStateList.iterator();
		 while(itrGridStateList.hasNext())
            {try{
             MasState  masStateGrid = (MasState)itrGridStateList.next(); 
			 if(hrMasInstructor.getState().getId().equals(masStateGrid.getId()) && masStateGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][7] = "<%=masStateGrid.getStateName()%>"
			<%}else if(hrMasInstructor.getId().equals(masStateGrid.getId()) && masStateGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masStateGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>                     
   
            
            
 <%
		Iterator itrGridCountryList=gridCountryList.iterator();
		 while(itrGridCountryList.hasNext())
            {try{
             MasCountry  masCoutryGrid = (MasCountry)itrGridCountryList.next(); 
			 if(hrMasInstructor.getCountry().getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][8] = "<%=masCoutryGrid.getCountryName()%>"
			<%}else if(hrMasInstructor.getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masCoutryGrid.getCountryName()%>";
			<%}
            }catch(Exception e){e.printStackTrace();}}%>                     

            
data_arr[<%= counter%>][9] = "<%= hrMasInstructor.getPincode()%>"
data_arr[<%= counter%>][10] = "<%= hrMasInstructor.getPhoneNo()%>"
data_arr[<%= counter%>][11] = "<%= hrMasInstructor.getRemarks()%>"       
data_arr[<%= counter%>][12] = "<%= hrMasInstructor.getLastChgBy() %>"
data_arr[<%= counter%>][13] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasInstructor.getLastChgDate()) %>"
data_arr[<%= counter%>][14] = "<%= hrMasInstructor.getLastChgTime() %>"
<% if(hrMasInstructor.getStatus().equals("y")){ %>
data_arr[<%= counter%>][15] = "Active"
<%}else{%>
data_arr[<%= counter%>][15] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "instructor"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
