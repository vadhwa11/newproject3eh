<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * DepartmentTaskMap.jsp  
 * Purpose of the JSP -  This is for Rating Details.
 * @author  Vishal
 * Create Date: 15th July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>

<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrInstEmpDept"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.*" %>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<EmpScMapping>   searchEmpScMappingList = new ArrayList<EmpScMapping>();
	
	List<MasInstituteDepartment> masInstituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	
	List<MasEmployee>   employeeList = new ArrayList<MasEmployee>();
	
	List<MasInstituteDepartment> instituteDepartmentList = new ArrayList<MasInstituteDepartment>();
	
	List<MasEmpCategory> employeeCategoryList = new ArrayList<MasEmpCategory>();
	
	String userName = "";
	int scId=0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	

	
	
	 if(map.get("searchEmpScMappingList")!=null){
		 searchEmpScMappingList=(List<EmpScMapping>)map.get("searchEmpScMappingList");
		}
		if(map.get("employeeList")!=null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
			}

	

	 if(map.get("instituteDepartmentList")!=null){
		 instituteDepartmentList=(List<MasInstituteDepartment>)map.get("instituteDepartmentList");
		}
	 
	 if(map.get("masInstituteDepartmentList")!=null){
		 masInstituteDepartmentList=(List<MasInstituteDepartment>)map.get("masInstituteDepartmentList");
	}
	 if(map.get("scId")!=null){
		 scId=(Integer)map.get("scId");
	} 
	 
	 if(map.get("employeeCategoryList")!=null){
		 employeeCategoryList=(List<MasEmpCategory>)map.get("employeeCategoryList");
	} 
	  
	 
	 
		int hospitalId=0;
		hospitalId= (Integer)session.getAttribute("hospitalId");
		
%>



<div class="titleBg"> 
<h2>Employee Service Centre Mapping</h2>
</div>

<div class="clear"></div>

<form name="task" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">


<label><span>* </span>Service Centre</label>
<select name="seviceCenterrId" id="seviceCenterrId" onchange="empCategoryList()" >
<option value="0">select</option>
    <%for(MasInstituteDepartment md : masInstituteDepartmentList){ %>
     <option value="<%=md.getDepartment().getId()%>"><%=md.getDepartment().getDepartmentName()%></option>
     <%} %>
</select>

<%-- <label><span>* </span>Employee</label>
<select name="empId" id="empId" onchange="selectEmployee(this.value)">
<option value="0">Select</option>
 <%for(MasEmployee h : employeeList){
	%>
	
    	  <option value="<%=h.getId()%>"><%=h.getEmployeeName()%></option>
 <%}%>

</select> --%>

<label><span>* </span>Employee Type</label>
<select name="empcategoryId" id="empcategoryId"  onchange="selectEmployee(this.value)">
<option value="0">Select</option>
 <%for(MasEmpCategory h : employeeCategoryList){
	%>
	
    	  <option value="<%=h.getId()%>"><%=h.getEmpCategoryName()%></option>
 <%}%>

</select>
<div class="clear"></div> 
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<label class="bgNone"> Employee List</label>
<label class="bgNoneAuto" style="margin-left:268px;">  To Be Assigned Employees</label>
<div class="clear"></div>
<label class="bgNone"></label>
<div id="inst">
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="7" class="listBig3" style="margin-top:0;">
    <%-- <%for(MasInstituteDepartment md : masInstituteDepartmentList){ %>
     <option value="<%=md.getDepartment().getId()%>"><%=md.getDepartment().getDepartmentName()%></option>
     <%} %> --%>
</select>

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />
<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>
</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3" style="margin-top:0;">
<%-- <%if(instituteDepartmentList.size()>0){ 
System.out.println("checking list");
%>
       <%for(MasInstituteDepartment d : instituteDepartmentList){ %>
            	 <option value="<%=d.getDepartment().getId()%>" selected><%=d.getDepartment().getDepartmentName()%></option>
   					<%} %>
   					<%} %> --%>
</select>

<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="bgNone"></label>
<%if(instituteDepartmentList.size()>0){ %>

  <input type="hidden" value="<%=scId%>" name="scId"/>
  <input type="button" class="button" style="margin-left:330px;" name="Assign" value="Save" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveEmpSCMapping&flag=u');}">
  <%}else{ %>
    <input type="hidden" value="0" name="scId"/>
  <input type="button" class="button" style="margin-left:330px;" name="Assign" value="Add Move" onclick="if(chk()){submitForm('task','/hms/hms/generalMaster?method=saveEmpSCMapping&flag=s');}">
<% }%> 
</div>
 <div class="clear"></div>
 <div class="paddingTop5"></div>
</div>	
</form>

<script>
function selectEmployee(val1){

	var val=document.getElementById("seviceCenterrId").value;
	var empcategoryId=val1;
		
	if(empcategoryId !=''){
	submitProtoAjaxWithDivName('task','/hms/hms/generalMaster?method=fillEmployee&Val='+val+'&empcategoryId='+empcategoryId,'inst');
	}
	else{
		alert("select employee type");
	}
}	

function empCategoryList(){
	document.getElementById("empcategoryId").value=0;
}
/* function populateEmployeeByCategory(val){
	
	submitProtoAjaxWithDivName('task','/hms/hms/generalMaster?method=populateEmployeeByCategory&Val='+val,'inst');
}	

(this.value) */


function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}
function chk() {
	/*var s = document.getElementById("tempId").value;

	if (s==""){ 
	alert("Please Choose Select List of Employee Department");
	return false;
	}*/ //changed by govind 13-12-2016
	return true;
}

function hasOptions(obj) {
	if (obj!=null && obj.options!=null) { return true; }
	return false;
	}
function copySelectedOptions() {
	   from =document.getElementById("mainGroupId")
	   to =document.getElementById("tempId")
		var options = new Object();
		if (hasOptions(to)) {
			for (var i=0; i<to.options.length; i++) {
				options[to.options[i].value] = to.options[i].text;
				to.options[i].selected=true;
				}
			}
		if (!hasOptions(from)) { return; }
		for (var i=0; i<from.options.length; i++) {
			var o = from.options[i];
			if (o.selected) {
				if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
					if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
					to.options[index] = new Option( o.text, o.value, true, false);
					to.options[index].selected=true;
					}
				}
			}
		if ((arguments.length<3) || (arguments[2]==true)) {
			sortSelect(to);
			}
		from.selectedIndex = -1;
		to.selectedIndex = -1;
		var objTemp = document.getElementById("tempId");
		for (var k=0; k<objTemp.options.length; k++) {
			objTemp.options[k].selected=true;
			}
		}
		
		
function removeSelectedOptions() {
	 from =document.getElementById("tempId") 
		if (!hasOptions(from)) { return; }
		if (from.type=="select-one") {
			from.options[from.selectedIndex] = null;
			}
		else {
			for (var i=(from.options.length-1); i>=0; i--) { 
				var o=from.options[i]; 
				if (o.selected) { 
					from.options[i] = null; 
					} 
				}
			}
		from.selectedIndex = -1; 
		} 
		


</script>



 