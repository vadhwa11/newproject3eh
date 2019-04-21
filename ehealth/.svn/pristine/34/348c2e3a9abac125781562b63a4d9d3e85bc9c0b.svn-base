<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.HrMeetingSchedule"%>
<%@page import="jkt.hms.masters.business.HrMeetingMembers"%>
<%@page import="jkt.hms.masters.business.HrCommitteeHeader"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.HrMeetingAgendaPoint"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>
<script>
<%
	//System.gc();
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
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : "";

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength);
}
</script>

<%
Map<String,Object> map = new HashMap<String,Object>();

List<HrMeetingSchedule> lsList = new ArrayList<HrMeetingSchedule>();
if(request.getAttribute("map") != null)
{
 map = (Map) request.getAttribute("map");
}

int meetingId=0;
String meetingNo="";
String meetingDate="";
String meetingType="";
String scheduledTimeFrom="";
String scheduledTimeTo="";
String venue="";
String chairedBy="";
String scheduledDate="";
String actualDate="";
String actualTimeFrom="";
String actualTimeTo="";

Set<HrMeetingMembers> memberSet = new HashSet<HrMeetingMembers>();
Set<HrMeetingAgendaPoint> agendaPointSet = new HashSet<HrMeetingAgendaPoint>();
List<HrCommitteeHeader> committeeList = new ArrayList<HrCommitteeHeader>();

if(map.get("lsList") != null){
	lsList = (List<HrMeetingSchedule>)map.get("lsList");
}

if(map.get("committeeList") != null){
	committeeList = (List<HrCommitteeHeader>)map.get("committeeList");
}
HrMeetingSchedule ls = new HrMeetingSchedule();
if(lsList.size() > 0){
	ls = lsList.get(0);
	meetingId = ls.getId();
	meetingNo = ls.getMeetingNo();
	meetingDate = HMSUtil.convertDateToStringWithoutTime(ls.getDate());
	meetingType = ls.getMeetingType();
	scheduledTimeFrom = ls.getScheduledTimeFrom()!=null? ls.getScheduledTimeFrom():"";
	scheduledTimeTo = ls.getScheduledTimeTo()!=null? ls.getScheduledTimeTo():"";
	actualTimeFrom = ls.getActualTimeFrom()!=null? ls.getActualTimeFrom():"";
	actualTimeTo = ls.getActualTimeTo()!=null? ls.getActualTimeTo():"";
	venue=ls.getVenue()!=null? ls.getVenue():"";
	chairedBy=ls.getChairedBy()!=null? ls.getChairedBy():"";
	memberSet = ls.getHrMeetingMembers();
	agendaPointSet = ls.getHrMeetingAgendaPoints();
	scheduledDate=ls.getScheduledDate()!=null?HMSUtil.convertDateToStringWithoutTime(ls.getScheduledDate()):"";
	actualDate=ls.getActualDate()!=null?HMSUtil.convertDateToStringWithoutTime(ls.getActualDate()):"";
}
String message = "";
 
 


List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();	
if(map.get("masEmployee") != null)
{
	masEmployeeList = (List)map.get("masEmployee");
}

%>
<form name="minutesOfMeeting" method="post" action=""  enctype="multipart/form-data">

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div class="titleBg">
<h2>Meeting Scheduling</h2>
</div>
<div class="Clear"></div>
<%if(meetingId !=0){ %>
<input type="hidden" name="meetingId" value="<%=meetingId%>" id="meetingId" />
<%} else{%>
<input type="hidden" name="meetingId" value="0" id="meetingId" />
<%} %>

<h4>Meeting Scheduling Header</h4>
<div class="Block">


<label>Meeting No. <span>*</span></label>
<input type="text" name="meetingNo"   id="meetingNo" value="<%=meetingNo%>" readonly="readonly" >


<label>Mintues Of Meeting Date <span>*</span></label>
<!-- <input type="text" tabindex="1" class="calDate" name="mintuesOfMeetingDate" id="mintuesOfMeetingDate" validate="Mintues Of Meeting Date,strSlash,yes" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'mintuesOfMeetingDate');checkDateLessThanEqualToCurrent(this.value,this);" maxlength="10" size="7"/> -->
<input type="text" id="mintuesOfMeetingDate" name="mintuesOfMeetingDate" validate="Mintues Of Meeting Date,dobHRMS,yes" class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%="mintuesOfMeetingDate"%>',document.minutesOfMeeting.<%="mintuesOfMeetingDate"%>,true);" />


<label>Meeting Type </label>
<input type="text" name="meetingType"  id="meetingType" value="<%=meetingType %>" readonly="readonly">

<div class="Clear"></div>


<label>Schedule Date <span>*</span></label>
<input type="text" tabindex="1" class="calDate" readonly="readonly" name="scheduleDate" id="scheduleDate" validate="Date,strSlash,yes" value="<%=scheduledDate %>" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'scheduleDate');checkDateLessThanEqualToCurrent(this.value,this);" maxlength="10" size="7"/> 
<%-- <input type="text" id="scheduleDate" name="scheduleDate" validate="Schedule Date,dobHRMS,yes" class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%="scheduleDate"%>',document.minutesOfMeeting.<%="scheduleDate"%>,true);" />
 --%>


<label>Schedule Time From</label>
<input type="text" name="scheduleTimeFrom" value="<%=scheduledTimeFrom %>" readonly="readonly">


<label>Schedule Time To</label>
<input type="text" name="scheduleTimeTo" value="<%=scheduledTimeTo %>" readonly="readonly">


<div class="Clear"></div>

<label>Venue</label>
<input type="text" name="venue" value="<%=venue %>" readonly="readonly">


<label>Chaired By</label>
<input type="text" name="chairedBy" value="<%=chairedBy %>" readonly="readonly">





<div class="Clear"></div>

<label>Actual Date <span>*</span></label>
<!-- <input type="text" tabindex="1" class="calDate" name="actualDate" id="actualDate" validate="Actual Date,strSlash,yes"  value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'actualDate');checkDateLessThanEqualToCurrent(this.value,this);" maxlength="10" size="7"/> -->
<input type="text" id="actualDate" name="actualDate" validate="Actual Date,dobHRMS,yes" class="date" MAXLENGTH="10" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%="actualDate"%>',document.minutesOfMeeting.<%="actualDate"%>,true);" />



<label>Actual Time From</label>
<input type="text" name="actualTimeFrom" id="actualTimeFrom"   value="" onBlur="checkValidTime(this.value,this.id);" maxlength="5" onkeyup="mask(this.value,this,'2',':');">


<label>Actual Time To</label>
<input type="text" name="actualTimeTo"  id="actualTimeTo" value="" onBlur="checkValidTime(this.value,this.id);" maxlength="5" onkeyup="mask(this.value,this,'2',':');">


<div class="Clear"></div>

<h4>Members</h4>

<!-- <label>Board Member </label>
<input type="radio" class="radioCheck" name="memberRadio"  id="boardId"  value="boardMember"   tabindex="1" onchange="displaySList('boardMember');"/>
 -->
   
<label> Committee</label>
<input type="radio" class="radioCheck" name="memberRadio" id="subCommitteeId" value="subCommitteeMember"  tabindex="1" onchange="displaySList('subCommitteeMember');"/>


<label>Employee</label>
<input type="radio" class="radioCheck" name="memberRadio" id="employeeId" value="employee"  tabindex="1" onchange="displaySList('employee');"/>


<div id="committ" style="display: none">
<label>Committee </label>
<select name="committeeId" validate="Committee,string,no">
<option value="0">Select</option>
<%
		if (committeeList != null) {
			for (HrCommitteeHeader committee : committeeList) {
	%>

<option value=<%=committee.getId()%>><%=committee.getCommitteeName()%></option>
	<%
		}}
	%>
</select>

</div>




</div>



<div class="clear"></div>

<div class="Block">

<div class="Clear"></div>

<input type="button" name="addButon" id="addButon" class="buttonAdd" onclick="addRow()"/>
<input type="button" name="delButton" id="delButton" class="buttonDel" onclick="removeSelectedRow('dinPanGrid');" />
<div class="Clear"></div>


<div class="cmntable">

<table id="dinPanGrid" >
<tr>
<th></th>
<th>Member</th>
<th>Designation</th>
<th>Attendance</th>
<th>Remarks</th>
</tr>
	<tbody id="tableData">
<%int inc = 0; %>
	<%
		if(memberSet.size() > 0){
			
			for(HrMeetingMembers lmm : memberSet){
				inc=inc+1;
	%>
	<tr>
<td><input type="checkbox" class="radioCheck" id="chk" name="chk" value="0" /></td>
<td>
<input type="hidden"  id="meetingMemberId<%=inc %>" name="meetingMemberId"  value="<%= lmm.getId()%>" />
<input type="text" class="auto" size="50" value="<%=lmm.getMemberName()!=null?lmm.getMemberName():""%>" readonly="readonly" id="nameMember<%=inc %>"  name="nameMember"  tabindex="1" onblur="fillMemberDetails(this.value,<%=inc %>);"/>
<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	function eventCallback(element, entry){
		var boardId = '';
		var subCommitteeId = '';
		var employeeId ='';
	/* 	if(document.getElementById('boardId').checked){
			boardId = document.getElementById('boardId').value;
		}else */ if(document.getElementById('subCommitteeId').checked){
			subCommitteeId = document.getElementById('subCommitteeId').value;
		}else if(document.getElementById('employeeId').checked){
			employeeId = document.getElementById('employeeId').value;
		}
			
				return entry + "&subCommitteeId=" + subCommitteeId+ "&employeeId=" + employeeId;
			}
			
		  new Ajax.Autocompleter('nameMember<%=inc %>','ac2update<%=inc %>','legal?method=getMemberListForName',{parameters:'requiredField=nameMember',callback: eventCallback}); 
		  <%-- new Ajax.Autocompleter('nameMember<%=inc %>','ac2update<%=inc %>','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember'}); --%>
		</script>
</td>

<td><input type="text" id="designation<%=inc %>"  readonly="readonly" name="designation" value="<%=lmm.getDesignation()!=null?lmm.getDesignation():""%>" tabindex="1" validate="Designation,string,no">

</td>
<td><input type="text" id="attendance<%=inc %>"  name="attendance" value="<%=lmm.getAttendance()!=null?lmm.getAttendance():""%>" tabindex="1" validate="attendance,metachar,no" maxlength="10">

</td>
<td><input type="text" name="remarks" id="remarks<%=inc %>" size="30"  value="<%=lmm.getRemarks()!=null?lmm.getRemarks():""%>" maxlength="80"/></td>


</tr>
	
	<%}
			}else{ %>
	
<tr>
<td><input type="checkbox" class="radioCheck" id="chk" name="chk" value="0" /></td>
<td>
<input type="hidden"  id="meetingMemberId<%=inc %>" name="meetingMemberId"  value="0" />
<input type="text" class="auto" size="50" value="" id="nameMember<%=inc %>"  name="nameMember"  tabindex="1" onblur="testMember(<%=inc %>);fillMemberDetails(this.value,<%=inc %>)"/>
<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	function eventCallback(element, entry){
		var boardId = '';
		var subCommitteeId = '';
		var employeeId ='';
		var committeeId ='';
	/* 	if(document.getElementById('boardId').checked){
			boardId = document.getElementById('boardId').value;
		}else */ if(document.getElementById('subCommitteeId').checked){
			subCommitteeId = document.getElementById('subCommitteeId').value;
			committeeId = document.getElementById('committeeId').value;
		}else if(document.getElementById('employeeId').checked){
			employeeId = document.getElementById('employeeId').value;
		}
			
				return entry  + "&subCommitteeId=" + subCommitteeId+ "&employeeId=" + employeeId+"&committeeId=" + committeeId;
			}
			
	 <%--  new Ajax.Autocompleter('nameMember<%=inc %>','ac2update<%=inc %>','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember'});--%>
		 new Ajax.Autocompleter('nameMember<%=inc %>','ac2update<%=inc %>','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember',callback: eventCallback}); 
		
		</script>
</td>

<td><input type="text" id="designation<%=inc %>"  name="designation"  tabindex="1" validate="Designation,string,no">

</td>
<td><input type="text" id="attendance<%=inc %>"  name="attendance" value="" tabindex="1" validate="Attendance,metachar,no" maxlength="10">

</td>
<td><input type="text" name="remarks" id="remarks<%=inc %>" size="30" value="" maxlength="80"/></td>


</tr>
<%} %>
</tbody>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
</div>




<div class="Clear"></div>
<h4>Agenda Points</h4>
<div class="Block">
<div class="Clear"></div>

<input type="button" name="addButon" id="addButon" class="buttonAdd" onclick="addAgendaRow()"/>
<input type="button" name="delButton" id="delButton" class="buttonDel" onclick="removeSelectedRow('agendaGrid');" />
<div class="Clear"></div>

<div id="nameDiv">
<div class="cmntable">
<table id="agendaGrid" >
<tr>
<th></th>
<th>Agenda Points</th>
<th>Decision</th>
<th>Action</th>
<th>Info</th>
<th>Upload Docs</th>
<th>Remarks</th>

</tr>
<tbody id="tableData">
<%int incs = 0; %>
	<%
		if(agendaPointSet.size() > 0){
			
			for(HrMeetingAgendaPoint lmap : agendaPointSet){
				incs=incs+1;
	%>
		<tr>
	
	
<td>

<input type="checkbox" class="radioCheck" id="chk" name="achk" value="0" /></td>
<td>
<input type="hidden"  id="meetingAgendaPointId<%=incs %>" name="meetingAgendaPointId"  value="<%= lmap.getId()%>" />
<input type="text" name="agendaPoints" id="agendaPoints<%=incs %>" readonly="readonly" size="30" value="<%=lmap.getAgendaPoint()!=null?lmap.getAgendaPoint():""%>" maxlength="32"/></td>
<td><input type="text" name="decision" id="decision<%=incs %>" size="30" value="<%=lmap.getDecision()!=null?lmap.getDecision():""%>" maxlength="100"/></td>
<td><input type="text" name="action" id="action<%=incs %>" size="30" value="<%=lmap.getAction()!=null?lmap.getAction():""%>" maxlength="100"/></td>
<td><input type="text" name="info" id="info<%=incs %>" size="30" value="<%=lmap.getInfo()!=null?lmap.getInfo():""%>" maxlength="100"/></td>
<td><input type="file" id="uploadFile<%=incs %>" name="upload_filename<%=incs %>" class="Browse" /></td>
<td><input type="text" name="remarka" id="remarka<%=incs %>" size="30" value="<%=lmap.getRemarks()!=null?lmap.getRemarks():""%>" maxlength="100"/></td>
</tr>
	<%}
			}else{ 
				incs=incs+1;
			%>
	<tr>
	
	
<td><input type="checkbox" class="radioCheck" id="chk" name="achk" value="0" /></td>
<td>
<input type="hidden" value="0" id="meetingAgendaPointId<%=incs %>"  name="meetingAgendaPointId" />
<input type="text" name="agendaPoints" id="agendaPoints<%=incs %>" size="30" value="" maxlength="32"/></td>
<td><input type="text" name="decision" id="decision<%=incs %>" size="30" value="" maxlength="100"/></td>
<td><input type="text" name="action" id="action<%=incs %>" size="30" value="" maxlength="100"/></td>
<td><input type="text" name="info" id="info<%=incs %>" size="30" value="" maxlength="100"/></td>
<td><input type="file" id="uploadFile<%=incs %>" name="upload_filename<%=incs %>" class="Browse" /></td>
<td><input type="text" name="remarka" id="remarka<%=incs %>" size="30" value="" maxlength="100"/></td>
</tr>
<%} %>
</tbody>
</table>
</div>
</div>
<input type="hidden" name="countera" id="countera" value="<%=incs %>" />
</div>
<div class="Clear"></div>
<label> Remarks</label>
<textarea rows="" cols="" maxlength="250" name="remarks"  onkeyup="chkLength(this,250);"></textarea>
<div class="Clear"></div>
<input type="button" class="button" value="Submit" onclick="submitRecords('save');"/>
<input type="reset" name="reset" class="button" value="Reset"  />





<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<script type="text/javascript">


function addRow(){
	

	  var tbl = document.getElementById('dinPanGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('counter');
	  var prevCnt = hdb.value;
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  row.id=iteration;
	  
	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.id='chk';
	  e0.value='0';
	  e0.setAttribute('tabindex','1');
	  cell0.appendChild(e0);
	  
	


	  var cell3 = row.insertCell(1);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='nameMember';
	  e3.size = '50';
	  e3.id='nameMember'+iteration;
	  e3.onblur=function(){testMember(iteration);fillMemberDetails(this.value,iteration);};
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);
	  
	  var e31 = document.createElement('div');
	  e31.id='ac2update'+iteration;
	  e31.style.display='none';
	  e31.className='autocomplete';
	  cell3.appendChild(e31);
	  new Ajax.Autocompleter('nameMember'+iteration,'ac2update'+iteration,'/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember',callback: eventCallback});


	  var e111 = document.createElement('input');
	  e111.type = 'hidden';
	  e111.name='meetingMemberId';
	  e111.id='meetingMemberId'+iteration;
	  e111.value="0";
	  e111.setAttribute('tabindex','1');
	  cell3.appendChild(e111);
	  
	  var cell4 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='designation';
	  e4.id='designation'+iteration;
	  e4.setAttribute('validate','Designation,string,no');
	  e4.setAttribute('tabindex','1');
	  cell4.appendChild(e4);

	  
	  var cell21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.size = '30';
	  e21.name='attendance';
	  e21.id='attendance'+iteration;
	  e21.setAttribute('tabindex','1');
	  cell21.appendChild(e21);
	  
	  var cell8 = row.insertCell(4);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='remark';
	  e8.size = '20';
	  e8.id='remark'+iteration;
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);


	  
}
function submitRecords(buttonName){
	var inc = document.getElementById('countera').value;
	var cnt = 0;
	var flag = '';
	var fileNames = '';
	var filename = '';
	for(i=1;i<=inc;i++ ){
		if (document.getElementById('uploadFile'+i) && document.getElementById('uploadFile'+i).value!="")
		{
			flag='exists';
			var fname = document.getElementById('uploadFile'+i).value;
			var ind = fname.lastIndexOf("\\");
			var filename = fname.substring(ind+1);
			
			
			fileNames +='&filename'+i+'='+filename;
		}
		cnt++;
	}
	/*if(flag==''){
		alert("Please upload atleast one file.");
		return false;
	}*/
	document.minutesOfMeeting.method="post";
	submitForm('minutesOfMeeting','/hms/hrms/training?method=saveMinutesOfMeeting'+fileNames +'&uploadCount='+cnt+'&buttonName='+buttonName+'&'+csrfTokenName+'='+csrfTokenValue);
	
	
}


function testMember(inc)
{
	if(document.getElementById('boardId').checked){
		return true;
	}else if(document.getElementById('subCommitteeId').checked){
		return true;
	}else if(document.getElementById('employeeId').checked){
		return true;
	}else{
		document.getElementById('nameMember'+inc).value="";
		document.getElementById('designation'+inc).value="";
		alert("Please Select any one Members");
		return false;
	}
	return true;
	
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
		      
		      	obj = document.getElementById('designation'+inc);
				obj.length = 1;
		      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		      	for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	//    var idMember = item.getElementsByTagName("idMember")[0];	
			   	    var nameMember  = item.getElementsByTagName("nameMember")[0];
			        var designation  = item.getElementsByTagName("designation")[0];
			    	if(designation.childNodes[0]!=undefined){
			          	for(innerLoop = 0;innerLoop <designation.childNodes.length;innerLoop++)
			        	{
			        		var dr = designation.childNodes[innerLoop];
				        	//var dId  = dr.getElementsByTagName("dId")[0];
				        	var dName  = dr.getElementsByTagName("dName")[0];
				        	
				        	//obj.length++;
							//obj.options[obj.length-1].value=dId.childNodes[0].nodeValue;
							document.getElementById('designation'+inc).value=dName.childNodes[0].nodeValue;
				        	
			        	}
						}
			
				
		      	}
		
		      }
		    }
		  
	        var url='/hms/hrms/training?method=fillMemberForName&nameMember='+val+'&'+csrfTokenName+'='+csrfTokenValue;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		     
		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}else{
			document.getElementById('nameMember'+inc).value='';
		}
	


    
}



function addAgendaRow(){
	

	  var tbl = document.getElementById('agendaGrid');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('countera');
	  var prevCnt = hdb.value;
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;
	  row.id=iteration;
	  
	  var cell0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.id='chk';
	  e0.value='0';
	  e0.setAttribute('tabindex','1');
	  cell0.appendChild(e0);
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '30';
	  e1.name='agendaPoints';
	  e1.id='agendaPoints'+iteration;
	  e1.setAttribute('tabindex','1');
	  cell1.appendChild(e1);

	  var e111 = document.createElement('input');
	  e111.type = 'hidden';
	  e111.name='meetingAgendaPointId';
	  e111.id='meetingAgendaPointId'+iteration;
	  e111.value="0";
	  e111.setAttribute('tabindex','1');
	  cell1.appendChild(e111);
	  
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '30';
	  e2.name='decision';
	  e2.id='decision'+iteration;
	  e2.setAttribute('tabindex','1');
	  cell2.appendChild(e2);
	  
	  var cell21 = row.insertCell(3);
	  var e21 = document.createElement('input');
	  e21.type = 'text';
	  e21.size = '30';
	  e21.name='action';
	  e21.id='action'+iteration;
	  e21.setAttribute('tabindex','1');
	  cell21.appendChild(e21);

	  
	  var cell22 = row.insertCell(4);
	  var e22 = document.createElement('input');
	  e22.type = 'text';
	  e22.size = '30';
	  e22.name='info';
	  e22.id='info'+iteration;
	  e22.setAttribute('tabindex','1');
	  cell22.appendChild(e22);


	  var cell23 = row.insertCell(5);
	  var e23 = document.createElement('input');
	  e23.type = 'file';
	  e23.className="Browse"
	  e23.name='upload_filename'+iteration;
	  e23.id='uploadFile'+iteration;
	  cell23.appendChild(e23);
	  
	  var cell8 = row.insertCell(6);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='remarka';
	  e8.size = '20';
	  e8.id='remarka'+iteration;
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);
}

function displaySList(val){
	if(val!="")
	{
	
	if(val=="subCommitteeMember")
	{
		/* document.getElementById('memberDiv').style.display = 'inline'; */
	document.getElementById('committ').style.display = 'inline';
				
	
	}
	if(document.getElementById('subCommitteeId').checked==true )
	{
		/* document.getElementById('memberDiv').style.display = 'inline'; */
		document.getElementById('committ').style.display = 'inline';

	}
	if(val=="employee")
	{
		/* document.getElementById('memberDiv').style.display = 'inline'; */
				
		document.getElementById('committ').style.display = 'none';
	}
	if(document.getElementById('employeeId').checked==true )
	{
		/* document.getElementById('memberDiv').style.display = 'inline'; */
		document.getElementById('committ').style.display = 'none';

	}
	}
	
} 


function removeSelectedRow(tableId)
{

	
    var table=document.getElementById(tableId);
    var tblRows  = table.getElementsByTagName("tr");
    var check=0;
    
   for(i=tblRows.length-1;i>0;i--)
   {         
    var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
    
    
          for(j=0;j<tblCtrl.length;j++)
          {
             if(tblCtrl[j].type == 'checkbox')
              {    
               if(tblCtrl [j].checked)
                         check=check+1;
              }
          }
          
          
   }
   if(check==0){
	   alert("Please select the row to delete")
   		return false;
   }
   
    if(tblRows.length-1==check){
    	alert("Can not delete all rows")
    	return false;
    }
	
   for(i=tblRows.length-1;i>0;i--)
   {         
    var tblCtrl =  tblRows[i].getElementsByTagName("input"); 
    
          for(j=0;j<tblCtrl.length;j++)
          {
             if(tblCtrl[j].type == 'checkbox')
              {    
               if(tblCtrl [j].checked){
            	   document.getElementById(tableId).deleteRow(i);
         	 }
              }
          }
   }
   


}	
</script>
