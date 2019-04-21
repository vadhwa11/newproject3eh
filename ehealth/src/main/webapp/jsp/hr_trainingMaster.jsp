<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingMaster.jsp  
 * Purpose of the JSP -  This is for Training details 
 * @author  Rajendra
 * Create Date: 31rd Dec,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasDepartment> gridDepartmentList = new ArrayList<MasDepartment>();

	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasCountry> gridCountryList = new ArrayList<MasCountry>();

	List<MasState> stateList = new ArrayList<MasState>();
	List<MasState> gridStateList = new ArrayList<MasState>();

	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasDistrict> gridDistrictList = new ArrayList<MasDistrict>();

	List<HrMasTraining> searchTrainingMasterList = new ArrayList<HrMasTraining>();

	if (map.get("departmentList") != null) {
		departmentList = (List) map.get("departmentList");
	}

	if (map.get("gridDepartmentList") != null) {
		gridDepartmentList = (List) map.get("gridDepartmentList");
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

	if (map.get("searchTrainingMasterList") != null) {
		searchTrainingMasterList = (List) map
				.get("searchTrainingMasterList");
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
		removeAllOptions(sel1);
		var sel2 = document.getElementById("cityId");
		removeAllOptions(sel2);
		var sel = document.getElementById("stateId");
		sel.options.add(new Option('select', '0'));
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
		sel.options.add(new Option('select', '0'));
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

</script>

<div class="titleBg">
<h2>Training Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Training
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" class="radioCheck" /> <label>Training Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />
<label>&nbsp;</label> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="Training Code,string,no"
	MAXLENGTH="8" tabindex=1 /> <input type="button" name="search"
	value="Search" class="button"
	onclick="submitForm('search','training?method=searchTrainingMaster','checkSearch')"
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
	if (searchTrainingMasterList.size() > 0) {
		String strForCode = (String) map.get("trainingCode");
		String strForCodeDescription = (String) map.get("trainingName");
		if (strForCode != null && strForCode != ""
				|| strForCodeDescription != null
				&& strForCodeDescription != "") {
%>
<h4><a href="training?method=showTrainingMasterJsp">Show All
Records</a></h4>
<%
	}
	}
	if (searchTrainingMasterList.size() == 0
			&& map.get("search") != null) {
%>
<h4><a href="training?method=showTrainingMasterJsp">Show All
Records</a></h4>

<%
	}
%> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= TRAINING_TYPE %>"], [5,"<%= TRAINING_VENUE%>"], [6,"<%= DISTRICT %>"], [7,"<%= STATE %>"], [8,"<%= COUNTRY %>"], [9,"<%= PINCODE %>"], [10,"<%= PHONE_NO %>"], [11,"<%= SEAT_AVAILABLE %>"], [12,"<%= FEES_CHARGED %>"], [13,"<%= TOPICS_COVERED %>"], [14,"<%= REMARKS %>"], [15,"<%= CHANGED_BY%>"], [16,"<%= CHANGED_DATE %>"],[17,"<%= CHANGED_TIME %>"],[18,"<%=STATUS%>"] ];
	 statusTd = 18;
	</script></div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<form name="training" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrMasTraining"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="TrainingName"><input
	type="hidden" name="title" value="Training"><input
	type="hidden" name="<%=JSP_NAME %>" value="hr_trainingMaster"><input
	type="hidden" name="pojoPropertyCode" value="TrainingCode"><label><span>*</span>
Training Code</label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Training Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1><label><span>*</span>
Training Name</label> <input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Training Name,string,yes" class="textbox_size20"
	MAXLENGTH="25" / tabindex=1><script>
	document.training.<%=CODE%>.focus();
</script> <label><span>*</span> Training Type</label> <select
	name="<%= TRAINING_TYPE %>" validate="Training Type,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<option value="1">Advance Seminar</option>
	<option value="2">Advance Training</option>
	<option value="3">Elemetary Seminar</option>
	<option value="4">Elemetary Training</option>
	<option value="5">Others</option>
</select>
<div class="clear"></div>

<label> Department</label> <select name="<%= DEPARTMENT_ID %>"
	validate="Department,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasDepartment masDepartment : departmentList) {
	%>

	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>

	<%
		}
	%>

</select> <label><span>*</span> Venue</label> <input type="text"
	name="<%= TRAINING_VENUE %>" value="" validate="Venue,string,yes"
	class="large" MAXLENGTH="50" tabindex=1 />
<div class="clear"></div>

<label><span>*</span> Country</label> <select name="<%= COUNTRY %>"
	validate="Country,string,yes" tabindex=1
	onchange="getStateList(this.value);"
	onkeyUp="getStateList(this.value);">
	<option value="0">Select</option>
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
	<option value="0">Select</option>
	<%
		for (MasState masState : stateList) {
	%>

	<option value="<%=masState.getId ()%>"><%=masState.getStateName()%></option>

	<%
		}
	%>
</select> <label><span>*</span> City</label> <select id="cityId"
	name="<%= DISTRICT %>" validate="City,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasDistrict masDistrict : districtList) {
	%>

	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getDistrictName()%></option>

	<%
		}
	%>
</select>
<div class="clear"></div>

<label>Pincode</label> <input type="text" name="<%= PINCODE %>" value=""
	validate="Pincode,int,no" class="textbox_size20" MAXLENGTH="6"
	/ tabindex=1 /> <label>Phone No</label> <input type="text"
	name="<%= PHONE_NO %>" value="" validate="Phone No,string,no"
	class="textbox_size20" MAXLENGTH="20" / tabindex=1 /> <label>
Seat Available</label> <input type="text" name="<%= SEAT_AVAILABLE %>" value=""
	validate="Seat Available,int,no" class="textbox_size20" MAXLENGTH="4"
	/ tabindex=1 />
<div class="clear"></div>
<label> Fees Charged</label> <input type="text"
	name="<%= FEES_CHARGED %>" value="" validate="Fees Charged,float,no"
	class="textbox_size20" MAXLENGTH="10" tabindex=1 /> <label>
Topic Covered</label> <input type="text" name="<%= TOPICS_COVERED %>" value=""
	validate="Topic Covered,string,no" class="large" MAXLENGTH="100"
	tabindex=1 />
<div class="clear"></div>
<label>Remarks</label> <input type="text" name="<%= REMARKS %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="60" tabindex=1 />
<div class="clear"></div>
</div>
<div class="division"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('training','training?method=addTrainingMaster');"
	accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('training','training?method=editTrainingMaster')"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	class="button" style="display: none;"
	onClick="submitForm('training','training?method=deleteTrainingMaster&flag='+this.value)"
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
<div class="division"></div>


<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Training Code"
data_header[0][1] = "data";
data_header[0][2] = "";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Training Name"
data_header[1][1] = "data";
data_header[1][2] = "";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Department"
data_header[2][1] = "data";
data_header[2][2] = "";
data_header[2][3] = "<%= DEPARTMENT_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Training Type"
data_header[3][1] = "data";
data_header[3][2] = "";
data_header[3][3] = "<%= TRAINING_TYPE%>";

data_header[4] = new Array;
data_header[4][0] = "Training Venue"
data_header[4][1] = "data";
data_header[4][2] = "";
data_header[4][3] = "<%= TRAINING_VENUE%>";

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
data_header[10][0] = "Seat Available"
data_header[10][1] = "data";
data_header[10][2] = "";
data_header[10][3] = "<%= SEAT_AVAILABLE%>";

data_header[11] = new Array;
data_header[11][0] = "Fees Charged"
data_header[11][1] = "data";
data_header[11][2] = "";
data_header[11][3] = "<%= FEES_CHARGED%>";

data_header[12] = new Array;
data_header[12][0] = "Topic Covered"
data_header[12][1] = "data";
data_header[12][2] = "";
data_header[12][3] = "<%= TOPICS_COVERED%>";

data_header[13] = new Array;
data_header[13][0] = "Remarks"
data_header[13][1] = "data";
data_header[13][2] = "";
data_header[13][3] = "<%= REMARKS%>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%=CHANGED_BY %>"

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=CHANGED_DATE %>"

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "";
data_header[16][3] = "<%=CHANGED_TIME %>";

data_header[17] = new Array;
data_header[17][0] = "Status<br />"
data_header[17][1] = "data";
data_header[17][2] = "";
data_header[17][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchTrainingMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrMasTraining  hrMasTraining = (HrMasTraining)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasTraining.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasTraining.getTrainingCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasTraining.getTrainingName()%>"

<% if(hrMasTraining.getDepartment() !=null){%>
<%     Iterator itrGridDepartmentList=gridDepartmentList.iterator();
		 while(itrGridDepartmentList.hasNext())
            {try{
             MasDepartment MasDepartmentGrid = (MasDepartment)itrGridDepartmentList.next(); 
             if(hrMasTraining.getDepartment().getId() != 0){ 
             if(hrMasTraining.getDepartment().getId().equals(MasDepartmentGrid.getId()) && MasDepartmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=MasDepartmentGrid.getDepartmentName()%>"
			<%}else if(hrMasTraining.getId().equals(MasDepartmentGrid.getId()) && MasDepartmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=MasDepartmentGrid.getDepartmentName()%>";
				
			<%}}else{%>
				data_arr[<%= counter%>][3] = "-"
				<%}
            }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>
  data_arr[<%= counter%>][3] = "-"
				<%}%>

<% if(hrMasTraining.getCourseId() !=null){%>
<% if(hrMasTraining.getCourseId().equals("1")){ %>
data_arr[<%= counter%>][4] = "Advance Seminar"
<%}else if(hrMasTraining.getCourseId().equals("2")){%>
data_arr[<%= counter%>][4] = "Advance Training"
<%}else if(hrMasTraining.getCourseId().equals("3")){%>
data_arr[<%= counter%>][4] = "Elemetary Training"
<%}else if(hrMasTraining.getCourseId().equals("4")){%>
data_arr[<%= counter%>][4] = "Elemetary Training"
<%}else{%>
data_arr[<%= counter%>][4] = "Others"
<%}%>
<%}%>

data_arr[<%= counter%>][5] = "<%= hrMasTraining.getAddress()%>"

<%
		Iterator itrGridDistrictList=gridDistrictList.iterator();
		 while(itrGridDistrictList.hasNext())
            {try{
             MasDistrict  masDistrictGrid = (MasDistrict)itrGridDistrictList.next(); 
			 if(hrMasTraining.getDistrict().getId().equals(masDistrictGrid.getId()) && masDistrictGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][6] = "<%=masDistrictGrid.getDistrictName()%>"
			<%}else if(hrMasTraining.getId().equals(masDistrictGrid.getId()) && masDistrictGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masDistrictGrid.getDistrictName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>
            
 <%
		Iterator itrGridStateList=gridStateList.iterator();
		 while(itrGridStateList.hasNext())
            {try{
             MasState  masStateGrid = (MasState)itrGridStateList.next(); 
			 if(hrMasTraining.getState().getId().equals(masStateGrid.getId()) && masStateGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][7] = "<%=masStateGrid.getStateName()%>"
			<%}else if(hrMasTraining.getId().equals(masStateGrid.getId()) && masStateGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=masStateGrid.getStateName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>                     
   
            
            
 <%
		Iterator itrGridCountryList=gridCountryList.iterator();
		 while(itrGridCountryList.hasNext())
            {try{
             MasCountry  masCoutryGrid = (MasCountry)itrGridCountryList.next(); 
			 if(hrMasTraining.getCountry().getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][8] = "<%=masCoutryGrid.getCountryName()%>"
			<%}else if(hrMasTraining.getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masCoutryGrid.getCountryName()%>";
				
			<%}
            }catch(Exception e){e.printStackTrace();}}%>                     

            
data_arr[<%= counter%>][9] = "<%= hrMasTraining.getPincode()%>"
data_arr[<%= counter%>][10] = "<%= hrMasTraining.getPhoneNo()%>"
data_arr[<%= counter%>][11] = "<%= hrMasTraining.getSeatAvailable()%>"
data_arr[<%= counter%>][12] = "<%= hrMasTraining.getFeesCharged()%>"
data_arr[<%= counter%>][13] = "<%= hrMasTraining.getTopicsCovered()%>"      
data_arr[<%= counter%>][14] = "<%= hrMasTraining.getRemarks()%>"       
data_arr[<%= counter%>][15] = "<%= hrMasTraining.getLastChgBy() %>"
data_arr[<%= counter%>][16] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasTraining.getLastChgDate()) %>"
data_arr[<%= counter%>][17] = "<%= hrMasTraining.getLastChgTime() %>"
<% if(hrMasTraining.getStatus().equals("y")){ %>
data_arr[<%= counter%>][18] = "Active"
<%}else{%>
data_arr[<%= counter%>][18] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "training"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
