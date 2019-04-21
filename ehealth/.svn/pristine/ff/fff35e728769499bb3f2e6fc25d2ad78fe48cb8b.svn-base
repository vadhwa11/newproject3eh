<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_trainingScheduling.jsp  
 * Purpose of the JSP -  This is for Training Scheduling 
 * @author  Rajendra
 * Create Date: 11th Feb,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@page import="jkt.hms.masters.business.MasRank"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hrms.masters.business.HrTrainingSchedule"%>
<%@ page import="jkt.hrms.masters.business.HrMasTraining"%>
<%@ page import="jkt.hrms.masters.business.HrMasInstructor"%>
<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	
	List<HrMasTraining> trainingMasterList = new ArrayList<HrMasTraining>();
	List<HrMasTraining> gridTrainingMasterList = new ArrayList<HrMasTraining>();
	
	List<HrMasInstructor> instructorMasterList =new ArrayList<HrMasInstructor>();
	List<HrMasInstructor> gridInstructorMasterList =new ArrayList<HrMasInstructor>();
	List<MasRank> desigList = new ArrayList<MasRank>();
		
	
	List<HrTrainingSchedule> searchTrainingScheduleList = new ArrayList<HrTrainingSchedule>();
	
	
	if(map.get("trainingMasterList") !=null){
		trainingMasterList =(List) map.get("trainingMasterList");
	}
	if(map.get("gridTrainingMasterList") !=null){
		gridTrainingMasterList =(List) map.get("gridTrainingMasterList");
	}
	
	if(map.get("instructorMasterList") !=null){
		instructorMasterList =(List)map.get("instructorMasterList");
	}
	
	if(map.get("gridInstructorMasterList") !=null){
		gridInstructorMasterList =(List)map.get("gridInstructorMasterList");
	}
	
	if (map.get("searchTrainingScheduleList") != null) {
		searchTrainingScheduleList = (List) map.get("searchTrainingScheduleList");
	}
	if (map.get("desigList") != null) {
		desigList = (List<MasRank>) map.get("desigList");
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
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	
function check(methodName){
	
	var SDate = document.trainingScheduling.<%= TRAINING_START_DATE%>.value;
	var EDate = document.trainingScheduling.<%= TRAINING_END_DATE %>.value;

	var	endDate = "";
	var startDate = "";
	if(SDate != "" && EDate != ""){
	 endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	 startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
	}
	
	if(startDate > endDate)
	{
		alert("Please ensure that the Training Start Date is greater than or equal to the Training End Date.");
		document.trainingScheduling.<%= TRAINING_END_DATE%>.focus();
		return false;
	}else{
		if(methodName =="add"){
			submitForm('trainingScheduling','training?method=addTrainingScheduling');
		}else if(methodName =="update"){
			submitForm('trainingScheduling','training?method=editTrainingScheduling');
		}
	}
}
		
	function checkDate(){
	
		var SDate = document.search.<%= FROM_DATE%>.value;
		var EDate = document.search.<%= TO_DATE %>.value;
	
		var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
		var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
	
		if(startDate > endDate)
		{
			alert("Please ensure that the To Date is greater than or equal to the From Date.");
			document.search.<%= FROM_DATE%>.focus(); 
			return false;
		}else{
			submitForm('search','training?method=showTrainingScheduling');
		}
	}	

</script>

<div class="titleBg">
<h2>Training </h2>
</div>
<%--
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action=""><label class="auto">From
Date </label> <input type="text" name="<%= FROM_DATE%>" value=""
	readonly="readonly" validate="From Date,string,yes"
	class="textbox_size20" MAXLENGTH="15" / tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.search.<%=FROM_DATE%>,event)" /> <label
	class="auto">To Date </label> <input type="text" name="<%= TO_DATE%>"
	value="" readonly="readonly" validate="To Date,string,yes"
	class="textbox_size20" MAXLENGTH="15" / tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onclick="setdate('',document.search.<%=TO_DATE%>,event)" /> <label>&nbsp;</label>
<input type="button" name="search" value="Search" class="button"
	onClick="checkDate()" tabindex=1 /></form> 
</div>
</div>
<div class="clear"></div>
</div>--%>

 <%--<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />--%>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div> 
<%if (searchTrainingScheduleList.size() == 0
			&& map.get("search") != null) {
%>
<h4><a href="training?method=showTrainingSchedulingJsp">Show
All Records</a></h4>
<%}%> <script type="text/javascript">
formFields = [[0, "<%= COMMON_ID%>", "id"], [1,"<%= TRAINING_ID%>"], [2,"<%= INSTRUCTOR_ID%>"], [3,"<%= TRAINING_SCHEDULE_DATE%>"], [4,"<%= TRAINING_START_DATE %>"], [5,"<%= TRAINING_END_DATE%>"],[6,"<%= TRAINING_TIME%>"], [7,"<%= TRAINING_DURATION %>"], [8,"<%= CLASS_SIZE%>"], [9,"<%= TRAINING_ADDRESS%>"],[10,"<%= REMARKS%>"], [11,"<%= CHANGED_BY%>"], [12,"<%= CHANGED_DATE %>"],[13,"<%= CHANGED_TIME %>"],[14,"<%=STATUS%>"] ];
	 statusTd = 14;
	</script></div>

<div class="Block">
<form name="trainingScheduling" method="post" action="">
	<input type="hidden" name="title" value="Training Scheduling">
	<input type="hidden" name="<%=JSP_NAME %>" value="hr_trainingScheduling">	
	<label><span>*</span>Designation</label> <select name="desig" validate="Designation,string,yes">
	<option value="">Select</option>
	<%
		for (MasRank mr: desigList) {
	%>

	<option value="<%=mr.getId()%>"><%=mr.getRankName()%></option>

	<%
		}
	%>
</select>
<label><span>*</span>Training</label> <select name="<%= TRAINING_ID%>" validate="Training,string,yes">
	<option value="">Select</option>
	<%
		for (HrMasTraining hrMasTraining: trainingMasterList) {
	%>

	<option value="<%=hrMasTraining.getId ()%>"><%=hrMasTraining.getTrainingCode()+"-"+ hrMasTraining.getTrainingName()%></option>

	<%
		}
	%>
</select> 
<label>From Date</label> <input type="text" id="startDateId"
	name="<%= TRAINING_START_DATE%>" value="" readonly="readonly"
	validate="Training Start Date,date,no" class="date" MAXLENGTH="15"
	tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingScheduling.<%=TRAINING_START_DATE%>,event);" />

<div class="clear"></div>
<label>To Date</label> <input type="text" id="endDateId"
	name="<%= TRAINING_END_DATE%>" value="" readonly="readonly"
	validate="Training End Date,date,no" class="date" MAXLENGTH="15"
	tabindex=1 /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="calender"
	onclick="setdate('',document.trainingScheduling.<%=TRAINING_END_DATE%>,event);" />

<label> Start Time</label> <input name="<%=TRAINING_TIME %>"
	type="text" id="trainingTimeId" title="Time Should be in 24 hr Format"
	validate="Training Time,string,no" value=""
	onKeyUp="mask(this.value,this,'2,5',':');"
	onBlur="IsValidTime(this.value,this.id);" maxlength="8" />
	<label> End Time</label> 
	<input name="END_TRAINING_TIME" type="text" id="trainingTimeId1" title="Time Should be in 24 hr Format" validate="Training Time,string,no"
	 value="" onKeyUp="mask(this.value,this,'2,5',':');" onBlur="IsValidTime(this.value,this.id);" maxlength="8" />
<%-- <label><span>*</span> Schedule Date</label> <input type="text"
	name="<%= TRAINING_SCHEDULE_DATE%>" value=<%= date%>
	readonly="readonly" validate="Schedule Date,date,yes" class="date"
	MAXLENGTH="15" tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onclick="setdate('',document.trainingScheduling.<%=TRAINING_SCHEDULE_DATE%>,event)" /> --%>
<div class="clear"></div>

<label><span>*</span> Trainer</label> <select
	name="<%= INSTRUCTOR_ID%>" validate="Instructor,string,yes">
	<option value="">Select</option>
	<%
		for (HrMasInstructor hrMasInstructor: instructorMasterList) {
	%>

	<option value="<%=hrMasInstructor.getId ()%>"><%=hrMasInstructor.getInstructorCode()+"-"+ hrMasInstructor.getInstructorName()%></option>

	<%
		}
	%>
</select>

<%-- <label>Training Duration</label> <input type="text"
	name=<%= TRAINING_DURATION%> vale=""
	validate="Training Duration,string,no" class="textbox_size20"
	MAXLENGTH="15" tabindex=1 /> <label><span> *</span>Class Size</label>
<input type="text" name=<%= CLASS_SIZE%> vale=""
	validate="Class Size,int,yes" class="textbox_size20" MAXLENGTH="4"
	tabindex=1 /> --%>

<label>Venue</label> <input type="text" name="<%= TRAINING_ADDRESS%>"
	value="" validate="Address,string,no" class="textbox_size20" MAXLENGTH="50"
	tabindex=1 />	
		<label>Order No</label>
	    <input type="text" name="orderNo" id="orderNo" value=""	validate="Order No,string,no" class="textbox_size20" MAXLENGTH="16" tabindex=1 />
 
<div class="clear"></div>
<%-- <label>Remarks</label> <input type="text" name="<%= REMARKS %>" value=""
	validate="Remarks,string,no" class="large" MAXLENGTH="60" tabindex=1 /> --%>
	
<label>In House</label>     
<input type="radio" name="SELECTED_RADIO"   value="In House" checked="checked" class="inputRadiobutton" tabindex=1  onClick="notify(this.value)"/>
			    	
<label>OutBound</label>
<input type="radio" name="SELECTED_RADIO" value="OutBound"  class="inputRadiobutton"  tabindex=1  onClick="notify(this.value)"/>
<div class="clear"></div>
<!-- <h4>Add Session</h4> -->
<div class="paddingTop5"></div>
<input name="" value="" id="temp" type="hidden" /> 
<input type="button"	class="button" value="Add Row" onclick="addRow();" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	/>
<div class="clear"></div>
</form>
</div>
<div class="Block">
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
<table width="100%" colspan="0" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0" class="cmntable">
		<tr>
			<th >Employee Name</th>
			<th >Designation</th>
			<th >Remark</th>
			<th >Select</th>			
		</tr>	
		<%int i = 1;		
		%>
		<tr>
			<td>
			<input type="text" name="empName" value=""	tabindex=1  id="empName<%=i %>"  size="32" onblur="fillMemberDetails(this.value,1)"/>
		
			<div id="ac2update1" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
					 new Ajax.Autocompleter('empName1','ac2update1','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=empName'});
				</script>		
			
			<input type="hidden" name="emp_id" value=""	tabindex=1  id="emp_id<%=i  %>"  size="32"/>
			</td>
			<td>
			<input type="text" name="desig<%=i  %>" value=""	tabindex=1  id="desig<%=i  %>" size="32"  maxlength="32"/>
			</td>
			
			<td>
			<input type="text" name="remark<%=i  %>" value=""	tabindex=1  id="remark<%=i %>"  size="32" maxlength="100" />
			</td>
			<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
		</tr>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Submit"
	class="button" onClick="check('add');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button" onClick="check('update');"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('trainingScheduling','training?method=deleteTrainingScheduling&flag='+this.value)"
	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="division"></div>
</div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=COMMON_ID%>" value="" />
<div class="clear"></div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Training"
data_header[0][1] = "hide";
data_header[0][2] = "";
data_header[0][3] = "<%= TRAINING_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Instructor"
data_header[1][1] = "hide";
data_header[1][2] = "";
data_header[1][3] = "<%= INSTRUCTOR_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Schedule Date"
data_header[2][1] = "hide";
data_header[2][2] = "";
data_header[2][3] = "<%= TRAINING_SCHEDULE_DATE%>";

data_header[3] = new Array;
data_header[3][0] = "Training Start Date"
data_header[3][1] = "hide";
data_header[3][2] = "";
data_header[3][3] = "<%= TRAINING_START_DATE%>";

data_header[4] = new Array;
data_header[4][0] = "Training End Date"
data_header[4][1] = "hide";
data_header[4][2] = "";
data_header[4][3] = "<%= TRAINING_END_DATE%>";

data_header[5] = new Array;
data_header[5][0] = "Time"
data_header[5][1] = "hide";
data_header[5][2] = "";
data_header[5][3] = "<%= TRAINING_TIME%>";

data_header[6] = new Array;
data_header[6][0] = "Duration"
data_header[6][1] = "hide";
data_header[6][2] = "";
data_header[6][3] = "<%= TRAINING_DURATION%>";

data_header[7] = new Array;
data_header[7][0] = "Class Size"
data_header[7][1] = "hide";
data_header[7][2] = "";
data_header[7][3] = "<%= CLASS_SIZE%>";

data_header[8] = new Array;
data_header[8][0] = "Address"
data_header[8][1] = "hide";
data_header[8][2] = "";
data_header[8][3] = "<%=TRAINING_ADDRESS %>";


data_header[9] = new Array;
data_header[9][0] = "Remarks"
data_header[9][1] = "hide";
data_header[9][2] = "";
data_header[9][3] = "<%= REMARKS%>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=CHANGED_BY %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_DATE %>"

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "";
data_header[12][3] = "<%=CHANGED_TIME %>";

data_header[13] = new Array;
data_header[13][0] = "Status"
data_header[13][1] = "hide";
data_header[13][2] = "";
data_header[13][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchTrainingScheduleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrTrainingSchedule  hrTrainingSchedule= (HrTrainingSchedule)itr.next(); 
            

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrTrainingSchedule.getId()%>

<% if(hrTrainingSchedule.getTraining() !=null){%>
<%
	Iterator itrGridTrainingList=gridTrainingMasterList.iterator();
	while(itrGridTrainingList.hasNext())
	   {try{
		    HrMasTraining hrMasTraining = (HrMasTraining)itrGridTrainingList.next(); 
			 if(hrTrainingSchedule.getTraining().getId().equals(hrMasTraining.getId()) && hrMasTraining.getStatus().equals("y")){
			%>
			data_arr[<%= counter%>][1] = "<%=hrMasTraining.getTrainingCode()+"-"+ hrMasTraining.getTrainingName()%>"
			<%}else if(hrTrainingSchedule.getTraining().getId().equals(hrMasTraining.getId()) && hrMasTraining.getStatus().equals("n")){%>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=hrMasTraining.getTrainingName() %>";
				
			<%}
	   }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][1] ="-";<%}%>

<% if(hrTrainingSchedule.getInstructor() !=null){%>
<%
	Iterator itrGridInstructorList=gridInstructorMasterList.iterator();
	while(itrGridInstructorList.hasNext())
	   {try{
		    HrMasInstructor hrMasInstructor = (HrMasInstructor)itrGridInstructorList.next(); 
			 if(hrTrainingSchedule.getInstructor().getId().equals(hrMasInstructor.getId()) && hrMasInstructor.getStatus().equals("y")){
			%>
			data_arr[<%= counter%>][2] = "<%=hrMasInstructor.getInstructorCode()+"-"+ hrMasInstructor.getInstructorName()%>"
			<%}else if(hrTrainingSchedule.getInstructor().getId().equals(hrMasInstructor.getId()) && hrMasInstructor.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=hrMasInstructor.getInstructorName() %>";
				
			<%}
	   }catch(Exception e){e.printStackTrace();}}%>
<%}else{%>data_arr[<%= counter%>][2] ="-";<%}%>

<% if(hrTrainingSchedule.getTrainingDate() !=null) {%> 
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingSchedule.getTrainingDate())%>"
<%}else {%>data_arr[<%= counter%>][3] ="-"<%}%>

<% if(hrTrainingSchedule.getTrainingStartDate() !=null) {%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingSchedule.getTrainingStartDate())%>"
<%}else {%>data_arr[<%= counter%>][4] =""<%}%>

<% if(hrTrainingSchedule.getTrainingEndDate() !=null) {%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingSchedule.getTrainingEndDate())%>"
<%}else {%>data_arr[<%= counter%>][5] =""<%}%>

<% if(hrTrainingSchedule.getTrainingTime() !=null) {%>
data_arr[<%= counter%>][6] = "<%= hrTrainingSchedule.getTrainingTime()%>"
<%}else {%>data_arr[<%= counter%>][6] =""<%}%>

<% if(hrTrainingSchedule.getDuration() !=null) {%>
data_arr[<%= counter%>][7] = "<%= hrTrainingSchedule.getDuration()%>"
<%}else {%>data_arr[<%= counter%>][7] ="-"<%}%>

<% if(hrTrainingSchedule.getClassSize() !=null) {%>
data_arr[<%= counter%>][8] = "<%= hrTrainingSchedule.getClassSize()%>"
<%}else {%>data_arr[<%= counter%>][8] =""<%}%>

<% if(hrTrainingSchedule.getAddress() !=null) {%>
data_arr[<%= counter%>][9] = "<%= hrTrainingSchedule.getAddress()%>"
<%}else {%>data_arr[<%= counter%>][9] ="-"<%}%>

<% if(hrTrainingSchedule.getRemarks() !=null) {%>
data_arr[<%= counter%>][10] = "<%= hrTrainingSchedule.getRemarks()%>"    
<%}else {%>data_arr[<%= counter%>][10] ="-"<%}%>

data_arr[<%= counter%>][11] = "<%= hrTrainingSchedule.getLastChgBy() %>"
data_arr[<%= counter%>][12] = "<%= HMSUtil.convertDateToStringWithoutTime(hrTrainingSchedule.getLastChgDate()) %>"
data_arr[<%= counter%>][13] = "<%= hrTrainingSchedule.getLastChgTime() %>"

<% if(hrTrainingSchedule.getStatus().equals("y")){ %>
data_arr[<%= counter%>][14] = "Active"
<%}else{%>
data_arr[<%= counter%>][14] = "InActive"
<%}
		     counter++;
}
%>
 
formName = "trainingScheduling"

nonEditable = "";
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<script>

function addRow(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;
	//var v=document.getElementById('v').value;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name='empName'+iteration;
	e0.id='empName'+(iteration);
	//e0.setAttribute('validate','Session,string,no');
	e0.size="32";
	e0.value="";
	e0.tabIndex="1";
	cell0.appendChild(e0);
	

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='desig'+iteration;
	e1.id='desig'+(iteration);
	//e1.setAttribute('validate','From Time,string,no');
	e1.value='';
	e1.size="32";
	e1.tabIndex="1";
	/* e1.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e1.onblur = function(){
				  IsValidTime(this.value,this.id);
		} */
	cell1.appendChild(e1);

	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='remark'+(iteration);
	e2.id='remark'+(iteration);
	//e2.setAttribute('validate','To Time,string,no');
	e2.value="";
	e2.size="32";
	e2.tabIndex="1";
/* 	e2.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e2.onblur = function(){
				  IsValidTime(this.value,this.id);
		} */
	cell2.appendChild(e2);
	


	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'radio';
	e3.name='selectedChrage';
	e3.className='radioAuto';
	e3.value=(iteration);
	cell3.appendChild(e3);
	
}
function removeRow(){
	
	var tbl = document.getElementById('itemDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

 	if(tblRows.length-2==0){
        	alert("Can not delete all rows")
        	return false;
    }
 	var count = 0;
	count = document.getElementById('hiddenValueCharge').value;
	
	var i=0;
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{ i++;
		  	tbl.deleteRow(counter+1);

		}
	}
	if(i==0){
		alert("Please select any row")
		return false;
	}

	
}


function fillMemberDetails(val,inc)
{

	if(val!=''){
		var xmlHttp;
		try {
		  // Firefox, Opera 8.0+, Safari
		  xmlHttp=new XMLHttpRequest();
		}catch (e){
		  // Internet Explorer
		  try{
		    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		  }catch (e){
		  	alert(e)
		    try{
		      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		    }catch (e){
		      alert("Your browser does not support AJAX!");
		      return false;
		    }
		   }
		 }
		    xmlHttp.onreadystatechange=function()
		    {
		      if(xmlHttp.readyState==4){
		      
		      	obj = document.getElementById('desig'+inc);
				obj.length = 1;
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	   var idMember = item.getElementsByTagName("idMember")[0];	
			   	    var nameMember  = item.getElementsByTagName("nameMember")[0];
			        var designation  = item.getElementsByTagName("designation")[0];
			    	if(designation.childNodes[0]!=undefined){
			          	for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
			        	{
			        		var dr = designation.childNodes[innerLoop];
				        	//var dId  = dr.getElementsByTagName("dId")[0];
				        	var dName  = dr.getElementsByTagName("dName")[0];
				           	document.getElementById('emp_id'+inc).value = idMember.childNodes[0].nodeValue
				        	//obj.length++;
							//obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
							document.getElementById('desig'+inc).value=dName.childNodes[0].nodeValue;
				        	
			        	}
						}
			
				
		      	}
		
		      }
		    }
		  
	        var url='/hms/hrms/training?method=fillMemberForName&nameMember='+val;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}else{
			document.getElementById('nameMember'+inc).value='';
		}
    
}

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
