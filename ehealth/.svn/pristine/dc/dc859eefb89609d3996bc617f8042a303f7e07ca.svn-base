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

<%@page import="jkt.hms.masters.business.UserHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/users.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList<UserHospital> searchUserUsergroupHospitalList = (ArrayList<UserHospital>)map.get("searchUserUsergroupHospitalList");
	List<Users> usersList = new ArrayList<Users>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	hospitalList = (ArrayList)map.get("hospitalList");
	usersList = (ArrayList)map.get("usersList");
	
	List<MasHospital> gridMasHospitalList = new ArrayList<MasHospital>();
	//List<UserGroups> gridGroupList = new ArrayList<UserGroups>();
	List<Users> gridUsersList = new ArrayList<Users>();
	gridMasHospitalList = (ArrayList)map.get("gridMasHospitalList");
	//gridGroupList=(ArrayList)map.get("gridGroupList");
	gridUsersList =(ArrayList)map.get("gridUsersList");
	
	int changedBy = 0;
	if(session.getAttribute("userId") != null){
		changedBy = (Integer)session.getAttribute("userId");
	}
	
	List<MasDistrict> mdistrictList = new ArrayList<MasDistrict>();
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	 if(map.get("mhospitalTypetList")!=null){
		 mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
		}
	 if(map.get("mdistrictList")!=null){
		 mdistrictList=(List<MasDistrict>)map.get("mdistrictList");
		}
	 String message ="";
	 if(map.get("message") != null){
		   message = (String)map.get("message");
		  }
	 String loginName="";
	 if(map.get("loginName") != null){
		 loginName = (String)map.get("loginName");
	 }
	 int incr=0;
	 int inc=0;
 %>

<html>
<head>
<h4><span><%=message %></span></h4>
</head>
<div class="titleBg">
<h2 align="left" class="style1">User Hospital Maintenance</h2>
</div>
<div class="clear"></div>

<body>

<form name="userHospitalMaintenance" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div id="searcharea" class="Block">
<div id="searchbar">
<label>Login Name</label> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" validate="User Name,string,no" MAXLENGTH="8" tabindex=1 value="<%=loginName%>" />
<input type="button" name="search" value="Search" class="button"	onclick="if(checkSearchField()){submitForm('userHospitalMaintenance','user?method=searchUserHospitalMaintenance')}"	tabindex=1 />
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>

<div class="Block">
<!-- <label><span>*</span>Login Name</label>
<input type="text" name="userIDF" id="userIDF" tabindex="1" onblur="getEmployeeName(this.value);" validate="Login Name,string,no">
<div id="userIDFDiv" style="display: none;"
												class="autocomplete"></div> 
				<script type="text/javascript"
												language="javascript" charset="utf-8">
				new Ajax.Autocompleter('userIDF','userIDFDiv','user?method=getUserListForAutoCompleteItem',{minChars:3,parameters:'requiredField=userIDF'});
					</script> -->
<input type="hidden" id="loginName"  name="loginName" value="<%=searchUserUsergroupHospitalList!=null && searchUserUsergroupHospitalList.size()>0?searchUserUsergroupHospitalList.get(0).getUser().getLoginName():"" %>" />
<input type="hidden" id="userId"  name="userId" value="<%=searchUserUsergroupHospitalList!=null && searchUserUsergroupHospitalList.size()>0?searchUserUsergroupHospitalList.get(0).getUser().getId():0 %>" />
<input type="hidden" id="employeeName"  name="employeeName" value="<%=searchUserUsergroupHospitalList!=null && searchUserUsergroupHospitalList.size()>0?searchUserUsergroupHospitalList.get(0).getUser().getEmployee().getEmployeeName():"" %>" />
<input type="hidden" id="<%=CHANGED_BY%>" name="<%=CHANGED_BY%>" value="<%=changedBy%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date1%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<!-- <label>Employee Name</label>
<input type="text" id="employee_name" disabled="disabled" tabindex=1/> -->
<div class="clear"></div>
<div style="width:-26px;background-color:floralwhite;float: right;">
<input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="assignInstitute();">
<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeInstitute();"> 
</div>
<div class="clear"></div>
<table id="tblAssignedInstitutes">
<thead>
<th></th>
<th>Login Name</th>
<th>Employee Name</th>
<th>District</th>
<th>Institute Type</th>
<th>Institution</th>
<th style="display:none">HosId</th>
</thead>

<%if(searchUserUsergroupHospitalList!=null && searchUserUsergroupHospitalList.size()>0){ %>

<%for(UserHospital userHospital:searchUserUsergroupHospitalList){ %>
<%if(userHospital.getHospital()!=null && userHospital.getUser()!=null && userHospital.getHospital().getHospitalName()!=null){  %>
<%if(searchUserUsergroupHospitalList.get(inc).getHospital().getId()!=null && (searchUserUsergroupHospitalList.get(inc).getHospital().getId()!=null?searchUserUsergroupHospitalList.get(inc).getHospital().getId():"").equals(searchUserUsergroupHospitalList.get(0).getUser().getEmployee().getHospital().getId()!=null?searchUserUsergroupHospitalList.get(0).getUser().getEmployee().getHospital().getId():"")){ %>
<tr bgcolor="#aff441">
<% }else{%>
<tr>
<%} %>
<td><input type="checkbox" class="radioCheck" id="instituteRadio<%=incr%>" name="instituteRadio<%=incr%>" ></td>
<td><%=userHospital.getUser().getLoginName() %></td>
<td><%=userHospital.getUser().getEmployee().getEmployeeName() %></td>

<td><%=userHospital.getHospital().getDistrict().getDistrictName() %></td>
<td><%=userHospital.getHospital().getHospitalType().getHospitalTypeName() %></td>

<td><%=userHospital.getHospital().getHospitalName() %></td>
<td style="display:none"><input type="text" id="hospitalId<%=incr%>" name="hospitalId<%=incr%>" value="<%=userHospital.getHospital().getId() %>" /></td>

<%-- <%if(userHospital.getStatus().equalsIgnoreCase("y")){ %>
<td><input type="checkbox" id="status<%=incr%>" checked="checked"  /></td>
<%}else{ %>
<td><input type="checkbox" id="status<%=incr%>"   /></td>
<%} %> --%>

</tr>

<% incr++;inc++;}} %>

<%} %>
</table>
<input type="hidden" id="count" name="count" value="<%=incr-1%>" />
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
</div>

<div class="Block">
<input type="button" value="Submit" class="button" onclick="checkSubmit();" style="margin-left: 0px" />
<input type="button" name="Back" value="Back" class="button" accesskey="b" onclick="submitFormForButton('userHospitalMaintenance','superAdmin?method=showModuleManagementJsp')" tabindex="1" />
</div>

</form>

</body>
</html>

<script>

function assignInstitute(){
	
	var count=parseInt(document.getElementById('count').value);
	if(count>=0){
		if(document.getElementById('userId').value=="0"){
			alert("Please fill above row to add Next row !");
			return;
		}
	}
	
	var tbl = document.getElementById('tblAssignedInstitutes');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('count');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	
	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'instituteRadio' + iteration;
	e1.id = 'instituteRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);
	
	var cellRight2 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'loginName' + iteration;
	e1.id = 'loginName' + iteration;
	e1.value=document.getElementById("loginName").value;
	e1.onblur = function() {
		getEmployeeNameForGrid(this.value, iteration);
	};
	cellRight2.appendChild(e1);
	
	var cellRight3 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'employeeName' + iteration;
	e1.id = 'employeeName' + iteration;
	e1.value=document.getElementById("employeeName").value;
	cellRight3.appendChild(e1);
	
	var cellRight4 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'districtId'+ iteration;
	e1.id = 'districtId' + iteration;
	var i=0;
	e1.options[i] = new Option('Select', '0');
	
	<%for(MasDistrict md:mdistrictList){%>
	i++;
	e1.options[i] = new Option('<%=md.getDistrictName()%>', '<%=md.getId()%>');
	<%}%>
	cellRight4.appendChild(e1);
	
	var cellRight5 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'instituteType'+ iteration;
	e1.id = 'instituteType' + iteration;
	var i=0;
	e1.options[i] = new Option('Select', '0');
	
	<%for(MasHospitalType mht:mhospitalTypetList){%>
	i++;
	e1.options[i] = new Option('<%=mht.getHospitalTypeName()%>', '<%=mht.getId()%>');
	<%}%>
	cellRight5.appendChild(e1);
	
	var cellRight6 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'institute' + iteration;
	e1.id = 'institute' + iteration;
	e1.onblur = function() {
		getHospitalId(iteration);
		
	};
	e1.onkeypress=function(){
		checkDistrictAndType(iteration);
	};
	cellRight6.appendChild(e1);
	
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'instDiv' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	
	new Ajax.Autocompleter('institute' + iteration,
			'instDiv' + iteration,
			'generalMaster?method=getHospitalListForAutoCompleteItem', {
				minChars : 3,
				callback : function(element, entry) {
					var dist=0,ins=0;
					if(document.getElementById("districtId"+iteration)!=null){
					dist= document.getElementById("districtId"+iteration).value;
					}
					if(document.getElementById("instituteType"+iteration)!=null){
					ins= document.getElementById("instituteType"+iteration).value;
					}
						return entry+"&districtId=" + dist+"&instType="+ins;
				},
				parameters : 'requiredField=institute' + iteration
			});
	
	var cellRight7 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'hospitalId' + iteration;
	e1.id = 'hospitalId' + iteration;
	cellRight7.appendChild(e1);
	cellRight7.style.display='none';
}

function getHospitalId(iteration){
	var instName=document.getElementById("institute"+iteration).value;
	if(instName==""){
		document.getElementById("hospitalId"+iteration).value=0;
	}else{
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
	        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
	        	
	        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
	  	   	    var item = chargeCodes.childNodes[loop];
	  	   	 
	  	   	 
	  	        var hospitalName  = item.getElementsByTagName("hospitalName")[0];
	  	        var hosid  = item.getElementsByTagName("hospitalId")[0]; 
	  	        var id= hosid.childNodes[0].nodeValue;			  	      
	  	      document.getElementById("hospitalId"+iteration).value=id;
	  	    checkDuplicateInstitute(iteration);

	        	}
            	   }
               }
	        
	 
	    var url='/hms/hms/generalMaster?method=getHospitalId&hospitalName='+instName;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

		
	      }
}

function removeInstitute(){
	var tbl = document.getElementById('tblAssignedInstitutes');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('count');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("instituteRadio" + i) != null
				&& (typeof document.getElementById("instituteRadio" + i).checked) != 'undefined'
				&& document.getElementById("instituteRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	
	 /* if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
		return;
	}else */ if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
		return;
	}else if (lastRow >= 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("instituteRadio" + i) != null
					&& (typeof document.getElementById("instituteRadio" + i).checked) != 'undefined'
					&& document.getElementById("instituteRadio" + i).checked) {
				var deleteRow = document.getElementById("instituteRadio" + i).parentNode.parentNode;
				document.getElementById("instituteRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
				document.getElementById("count").value=parseInt(document.getElementById("count").value)-1;
			}
		}
	}
	
}

function getEmployeeNameForGrid(empId,iteration){
	//alert("getEmployeeName");
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
          //  if(xmlHttp.responseXML.getElementsByTagName('items')[0]!=null){
        	var chargeCodes =xmlHttp.responseXML.getElementsByTagName('items')[0];
        	
        	for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {
  	   	    var item = chargeCodes.childNodes[loop];
  	   	 
  	   	 
  	        var empNameNode  = item.getElementsByTagName("employeeName")[0];
  	        var userIdNode=item.getElementsByTagName("employeeId")[0];
  	        var userId=userIdNode.childNodes[0].nodeValue;
  	        var loginNameNode=item.getElementsByTagName("loginName")[0];
  	        var loginName=loginNameNode.childNodes[0].nodeValue;
  	        var empName= empNameNode.childNodes[0].nodeValue;	
  	        document.getElementById("employeeName").value=empName;
  	        document.getElementById("employeeName"+iteration).value=empName;
  	        document.getElementById("userId").value=userId;
  	        document.getElementById("loginName").value=loginName;
        	}
        	   }
           }
        
  // alert("empId "+empId);
    var url='/hms/hms/user?method=getEmployeeNameById&employeeId='+empId;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
}
      
function checkSearchField(){
	var searchField=document.getElementById("searchField").value;
	if(searchField==""){
		alert("please enter Login Name !");
		return false;
	}
	return true;
}

</script>

<script>
function checkDuplicateInstitute(iteration){
	
	var hospIdNew=parseInt(document.getElementById("hospitalId"+iteration).value);
	
	for(var i=0;i<iteration;i++){
		var hospIdPrev=parseInt(document.getElementById("hospitalId"+i).value);
		if(hospIdNew==hospIdPrev){
			//alert("This Institute is Already Added !");
			document.getElementById("hospitalId"+iteration).value="";
			document.getElementById("institute"+iteration).value="";
			return false;
		}
	}
	return true;
}

function checkSubmit(){
	
	var userId=parseInt(document.getElementById("userId").value);
	var loginName=document.getElementById("loginName").value;
	
	if(userId==0 || loginName==""){
		alert("Please Enter User Data to Submit !");
		return;
	}else{
		submitForm('userHospitalMaintenance','user?method=addUserHospitalMaintenance');
	}
	
}
function checkDistrictAndType(iteration){
	var district=parseInt(document.getElementById("districtId"+iteration).value);
	var instituteType=parseInt(document.getElementById("instituteType"+iteration).value);
	
	if(district==0){
		alert("Please Select District !");
		document.getElementById("institute"+iteration).value="";
	}else if(instituteType==0){
		alert("Please Select Institute Type !");
		document.getElementById("institute"+iteration).value="";
	}
}
</script>