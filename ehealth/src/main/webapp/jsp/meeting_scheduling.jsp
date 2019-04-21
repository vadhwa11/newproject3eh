<%@page import="jkt.hms.masters.business.HrCommitteeHeader"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="java.util.*" %>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/controls.js?n=1"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
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

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
 map = (Map) request.getAttribute("map");
}

int meetingId=0;	
String message = ""; 

String meetingNo = "";
if (map.get("meetingNo") != null) {
	meetingNo = (String) map.get("meetingNo");
}	
List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();	
List<HrCommitteeHeader> committeeList = new ArrayList<HrCommitteeHeader>();
if(map.get("masEmployee") != null)
{
	masEmployeeList = (List)map.get("masEmployee");
}

if(map.get("committeeList") != null)
{
	committeeList = (List<HrCommitteeHeader>)map.get("committeeList");
}

/* List<LglBoardMember> bmList = new ArrayList<LglBoardMember>();	
if(map.get("bmList") != null)
{
	bmList = (List)map.get("bmList");
}

List<LglBoardMember> smList = new ArrayList<LglBoardMember>();	
if(map.get("smList") != null)
{
	smList = (List)map.get("smList");
} */
%>
<form name="meetingScheduling" method="post" action="" >

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");		
	}
if(!message.equalsIgnoreCase("")){
%>
<h3><%=message %></h3>
<%} %>

<div class="titleBg">
<h2>Meeting Scheduling</h2>
</div>
<%if(meetingId !=0){ %>
<input type="hidden" name="meetingId" value="<%=meetingId%>" id="meetingId" />
<%} else{%>
<input type="hidden" name="meetingId" value="0" id="meetingId" />
<%} %>
<!-- <h4>Meeting Scheduling Header</h4> -->
<div class="Block">
<label>Meeting No. <span>*</span></label>
<input type="text" name="meetingNo"   id="meetingNo" value="<%=meetingNo%>" readonly="readonly">
<label>Date <span>*</span></label>
<input type="text" tabindex="1" class="date" name="meetingDate" id="meetingDate" validate="Date,strSlash,yes" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'meetingDate');checkDateLessThanEqualToCurrent(this.value,this);" maxlength="10" size="7"/> 
<!-- <input type="text" id="meetingDate" name="meetingDate" validate="Date,dobHRMS,yes" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/>  -->
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%="meetingDate"%>',document.meetingScheduling.<%="meetingDate"%>,true);" />

<label>Meeting Type <span>*</span></label>
<input type="text" name="meetingType"  id="meetingType" value="" maxlength="16" validate="Meeting Type,metachar,yes">
<div class="Clear"></div>

<label>Schedule Date <span>*</span></label>
 <input type="text" tabindex="1" class="date" name="scheduleDate" id="scheduleDate" validate="Date,strSlash,yes" value="" onkeyup="mask(this.value,this,'2,5','/');"onblur="validateExpDate(this,'scheduleDate');checkDateLessThanEqualToCurrent(this.value,this);" maxlength="10" size="7"/> 
<!-- <input type="text" id="scheduleDate" name="scheduleDate" validate="Schedule Date,dobHRMS,yes" class="date" MAXLENGTH="30" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'td');"/>  -->
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onclick="javascript:setdate('<%="scheduleDate"%>',document.meetingScheduling.<%="scheduleDate"%>,true);" />

<label> From Time</label>
<input type="text" name="scheduleTimeFrom" id="scheduleTimeFrom" value="" validate="Venue,string,no" onBlur="checkValidTime(this.value,this.id);" maxlength="5" onkeyup="mask(this.value,this,'2',':');">

<label>To Time</label>
<input type="text" name="scheduleTimeTo" id="scheduleTimeTo"  value="" onBlur="checkValidTime(this.value,this.id);" maxlength="5" onkeyup="mask(this.value,this,'2',':');">
<div class="Clear"></div>

<label>Venue</label>
<input type="text" name="venue" value="" validate="Venue,metachar,no" maxlength="32">

<label>Chaired By <span>*</span></label>
<select name="chairedBy" validate="Chaired By,string,yes">
<option value="0">Select</option>
<%
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
				if( masEmployee.getEmployeeName() != null){
	%>

<option value=<%=masEmployee.getEmployeeName()%>><%=masEmployee.getEmployeeName()%></option>
	<%
		}}
		}
	%>
</select>

<div id="boardDiv" style="display: none">
<label>Chaired By <span>*</span></label>
<%-- <select name="chairedBy" validate="Chaired By,string,no">
<option value="0">Select</option>
<%
		if ( bmList!= null) {
			for (LglBoardMember bm : bmList) {
	%>

<option value="<%=bm.getNameBoard()%>"><%=bm.getNameBoard()%></option>
	<%
		}
		}
	%>
</select> --%>
</div>

<div id="subCommiteeDiv" style="display: none">
<label>Chaired By <span>*</span></label>
<%-- <select name="chairedBy" validate="Chaired By,string,no">
<option value="0">Select</option>
<%
		if ( smList!= null) {
			for (LglBoardMember sm : smList) {
	%>

<option value="<%=sm.getNameBoard()%>"><%=sm.getNameBoard()%></option>
	<%
		}
		}
	%>
</select> --%>
</div>

<div id="employeeDiv" style="display: none">
<label>Chaired By <span>*</span></label>
<%-- <select name="chairedBy" validate="Chaired By,string,no">
<option value="0">Select</option>
<%
		if (masEmployeeList != null) {
			for (MasEmployee masEmployee : masEmployeeList) {
	%>

<option value=<%=masEmployee.getId()%>><%=masEmployee.getFirstName()%><%=masEmployee.getLastName()%></option>
	<%
		}
		}
	%>
</select> --%>
</div>

<div class="Clear"></div>
 <h4>Members</h4>
<!-- <label>Board Member </label>
<input type="radio" class="radioCheck" name="memberRadio"  id="boardId"  value="boardMember"   tabindex="1" onchange="displaySList('boardMember');"/> -->
   
<label> Committee</label>
<input type="radio" class="inputRadiobutton" name="memberRadio" id="subCommitteeId" value="subCommitteeMember"  tabindex="1" onchange="displaySList('subCommitteeMember');"/>

<label>Employee</label>
<input type="radio" class="inputRadiobutton" name="memberRadio" id="employeeId" value="employee"  tabindex="1" onchange="displaySList('employee');"/> 

<div id="committ" style="display: none">
<label>Committee </label>
<select name="committeeId" validate="Committee,string,no" onchange="getMember(this.value)">
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
<div class="Block">
<h4>Members Details</h4>
<div class="paddingTop5"></div>
<div class="clear"></div> 
<input type="button" name="addButon" id="addButon" class="buttonAdd" onclick="addRow()"/>
<input type="button" name="delButton" id="delButton" class="buttonDel" onclick="removeSelectedRow('dinPanGrid');" />
<div id="testDiv">
<div class="cmntable">
<table id="dinPanGrid" >
<tr>
<th></th>
<th>Members</th>
<th>Designation</th>
<th>Remarks</th>
</tr>
<tr>
<td><input type="checkbox" class="radioCheck" id="chk" name="chk" value="0" /></td>
<td><input type="text"  size="50" value="" id="nameMember1"  name="nameMember1"  tabindex="1" onblur="fillMemberDetails(this.value,1)"/>
<div id="ac2update1" style="display: none;" class="autocomplete"></div>
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
		
		  new Ajax.Autocompleter('nameMember1','ac2update1','/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember1',callback: eventCallback});
		</script>
</td>

<td><input type="text"  id="designation1"  name="designation"  tabindex="1" validate="Designation,string,no" readonly="readonly">
<input type="hidden"  id="emp_id1"  name="emp_id"  tabindex="1"  readonly="readonly">
<input type="hidden"  id="memberId1"  name="memberId"  tabindex="1" readonly="readonly"/>
</td>
<td><input type="text" name="remarks" id="remarks1" size="30" value="" maxlength="80"/></td>
</tr>
</table>
</div>
<input type="hidden" name="counter" id="counter" value="1" />
</div>
</div>
<div class="Block">
<h4>Agenda Points</h4>
<div class="paddingTop5"></div>
<input type="button" name="addButon" id="addButon" class="buttonAdd" onclick="addAgendaRow()"/>
<input type="button" name="delButton" id="delButton" class="buttonDel" onclick="removeSelectedRow('agendaGrid');" />
<div id="nameDiv">
<div class="cmntable">
<table id="agendaGrid" >
<tr>
<th></th>
<th>Agenda Points</th>
<th>Reference(s)</th>
<th>Remarks</th>
</tr>
<tr>
<td><input type="checkbox" class="radioCheck" id="chk" name="achk" value="0" /></td>
<td><input type="text" name="agendaPoints" id="agendaPoints1" size="30" value="" maxlength="32"/></td>
<td><input type="text" name="reference" id="reference1" size="30" value="" maxlength="80"/></td>
<td><input type="text" name="remarka" id="remarka1" size="30" value="" maxlength="80"/></td>
</tr>
</table>
</div>
</div>
<input type="hidden" name="countera" id="countera" value="1" />

<div class="Clear"></div>
<div class="paddingTop5"></div>
<div class="Clear"></div>
<label> Remarks</label>
<textarea rows="" cols="" maxlength="200" name="remarks"  onkeyup="chkLength(this,200);" class="textareaMediua"></textarea>
<div class="Clear"></div>
<input type="button" class="button" value="Submit" onclick="submitRecords('save');"/>
<input type="reset" name="reset" class="button" value="Reset"  />
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function getMember(val){
	//alert(val)
	submitProtoAjax('meetingScheduling','training?method=getCommitteeMember&committeeId='+val);
}


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
	  e3.name='nameMember'+iteration;
	  e3.size = '50';
	  e3.class='auto';
	  e3.id='nameMember'+iteration;
	  e3.onblur=function(){fillMemberDetails(this.value,iteration);}
	  e3.setAttribute('tabindex','1');
	  cell3.appendChild(e3);
	  
	  var e31 = document.createElement('div');
	  e31.id='ac2update'+iteration;
	  e31.style.display='none';
	  e31.className='autocomplete';
	  cell3.appendChild(e31);
	  new Ajax.Autocompleter('nameMember'+iteration,'ac2update'+iteration,'/hms/hrms/training?method=getMemberListForName',{parameters:'requiredField=nameMember'+iteration,callback: eventCallback});
	   
	  
	  var cell4 = row.insertCell(2);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name='designation';
	  e4.id='designation'+iteration;
	  e4.setAttribute('validate','Designation,string,no');
	  e4.setAttribute('tabindex','1');
	  cell4.appendChild(e4);
	  

	   var e41 = document.createElement('input');
	  e41.type = 'hidden';
	  e41.name='emp_id';
	  e41.id='emp_id'+iteration;
	  cell4.appendChild(e41);
	  
	  var e411 = document.createElement('input');
	  e411.type = 'hidden';
	  e411.name='memberId';
	  e411.id='memberId'+iteration;
	  cell4.appendChild(e411);

	  
	  var cell8 = row.insertCell(3);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='remark';
	  e8.size = '30';
	  e8.id='remark'+iteration;
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);
	  
}
function submitRecords(buttonName){
	submitForm('meetingScheduling','/hms/hrms/training?method=saveMeetingScheduling&buttonName='+buttonName,'chkDate');
}


function displaySList(val){
	if(val!="")
	{
	/* if(val=="boardMember")
	{
		document.getElementById('memberDiv').style.display = 'inline';
				
	
	}
	if(document.getElementById('boardId').checked==true)
	{
		document.getElementById('memberDiv').style.display = 'inline';
				
	
	} */
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
	/* else
	{
		document.getElementById('memberDiv').style.display = 'none';
	
	} */
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
							document.getElementById('designation'+inc).value=dName.childNodes[0].nodeValue;
				        	
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


function displayEmpCategoryList(val){
	if(val!="")
	{
	if(val=="bm")
	{
		document.getElementById('boardDiv').style.display = 'inline';
		document.getElementById('employeeDiv').style.display = 'none';
		document.getElementById('subCommiteeDiv').style.display = 'none';
				
	
	}
	if(val=="sm")
	{
		document.getElementById('subCommiteeDiv').style.display = 'inline';
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('employeeDiv').style.display = 'none';
				
	
	}
	if(val=="emp")
	{
		document.getElementById('employeeDiv').style.display = 'inline';
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('subCommiteeDiv').style.display = 'none';	
	
	}
	
	}
	else
	{
		document.getElementById('boardDiv').style.display = 'none';
		document.getElementById('employeeDiv').style.display = 'none';
		document.getElementById('subCommiteeDiv').style.display = 'none';
		
	
	}
} 

function addAgendaRow(){
	

	  var tbl = document.getElementById('agendaGrid');
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
	  
	  var cell1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '30';
	  e1.name='agendaPoints';
	  e1.id='agendaPoints'+iteration;
	  e1.setAttribute('tabindex','1');
	  cell1.appendChild(e1);
	  
	  var cell2 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.size = '30';
	  e2.name='reference';
	  e2.id='reference'+iteration;
	  e2.setAttribute('tabindex','1');
	  cell2.appendChild(e2);

	  
	  var cell8 = row.insertCell(3);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.name='remarka';
	  e8.size = '30';
	  e8.id='remarka'+iteration;
	  e8.setAttribute('tabindex','1');
	  cell8.appendChild(e8);
	  
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


function chkDate()
{
	
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	obj1 = document.<%="meetingScheduling"%>.<%="meetingDate"%>.value;
	obj2 = document.<%="meetingScheduling"%>.<%="scheduleDate"%>.value;


	
	date= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	scheduleDate= new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
	
	if(date<currentDate){
	
		errorMsg += "Date Not Valid";
		return false;
	}
	
	
	
	if(obj1 != "" && obj2 != "" )
	{
		
		 if(date > scheduleDate)
		{
			errorMsg += "Date should be smaller than To Schedule Date.\n ";
			return false;
		}
		
		
	}
	
	

    return true;
}


</script>