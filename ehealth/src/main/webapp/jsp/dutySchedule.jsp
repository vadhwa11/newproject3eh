<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Javed
 * Create Date: 6th Mar,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1
--%>
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrDutyScheduleM"%>
<%@page import="jkt.hms.masters.business.HrDutyScheduleT"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
	<%

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
		
		function abc(){
		
		 var mon = document.getElementById('month').value;
			
			if (mon=="4" || mon=="6" || mon=="8" || mon=="9" || mon=="11"){
				/*  document.getElementById('apr').style.display = "inline";
				 document.getElementById('jan').style.display = "none"; */
				 
				document.getElementById('apr').style.display = "none";
				
			} else{
				/* document.getElementById('apr').style.display = "none";
				 document.getElementById('jan').style.display = "inline"; */
				 document.getElementById('apr').style.display = "none";
			}
	
		} 

		function getEmpServiceCentre(empId,cnt){
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

			      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
					
			      	for (loop = 0; loop < items.childNodes.length; loop++) {
				   	    var item = items.childNodes[loop];
			        	var departments  = item.getElementsByTagName("departmentList")[0];
				        for(var i=1;i<=31;i++){
								if(document.getElementById('departmentId'+cnt+""+i)){
			        			var	obj = document.getElementById('departmentId'+cnt+""+i);
								obj.length = 1;
					           	for(var innerLoop = 0;innerLoop < departments.childNodes.length;innerLoop++){
					        		var department = departments.childNodes[innerLoop];
						        	var departmentId  = department.getElementsByTagName("departmentId")[0];
						        	var departmentName  = department.getElementsByTagName("departmentName")[0];
						        	obj.length++;
									obj.options[obj.length-1].value=departmentId.childNodes[0].nodeValue;
									obj.options[obj.length-1].text=departmentName.childNodes[0].nodeValue;
									}
				        	}
			        		
			        	}
			      	}
			      }
			    }
			    var url='/hms/hrms/attendance?method=getEmpServiceCentre&empId='+empId;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);

		}
		

		function displayShift(cnt,serviceCentreId){
			var empCate = document.getElementById('empCate').value;
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

			      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
					obj =document.getElementById('shift'+cnt);
					obj.length = 1;
			      	for (loop = 0; loop < items.childNodes.length; loop++) {
				   	    var item = items.childNodes[loop];
				        var shifts  = item.getElementsByTagName("shiftList")[0];

			           	for(innerLoop = 0;innerLoop < shifts.childNodes.length;innerLoop++){
			        		var shift = shifts.childNodes[innerLoop];
				        	var shiftId  = shift.getElementsByTagName("shiftId")[0];
				        	var shiftName  = shift.getElementsByTagName("shiftName")[0];
				        	obj.length++;
							obj.options[obj.length-1].value=shiftId.childNodes[0].nodeValue;
							obj.options[obj.length-1].text=shiftName.childNodes[0].nodeValue;

			        	}
			      	}
			      }
			    }
			    var url='/hms/hrms/attendance?method=displayShift&serviceCentreId='+serviceCentreId+'&categoryId='+empCate;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

			    xmlHttp.open("GET",url,true);
			    xmlHttp.setRequestHeader("Content-Type", "text/xml");
			    xmlHttp.send(null);


			  
		}
</script>



<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map1 = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");	

	Map<String,Object> map = null;
	if(request.getAttribute("map")!=null)
	{
		map = (Map)request.getAttribute("map");
	}
	
	if(map.get("map1")!=null)
	{
		map1 = (Map)map.get("map1");
	}
	List<HrMasShift> srchmasShiftList = new ArrayList<HrMasShift>();
//	List<Object[]> srchEmplList = new ArrayList<Object[]>();

List<MasEmployee> srchEmplList = new ArrayList<MasEmployee>();
	List<Object[]> masDepartmentList = new ArrayList<Object[]>();
	List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
	List<MasGrade> masGradeList = new ArrayList<MasGrade>();
	List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>();
	List<HrDutyScheduleM> hrDutyScheduleMList = new ArrayList<HrDutyScheduleM>();
	List<HrDutyScheduleT> hrDutyScheduleTList = new ArrayList<HrDutyScheduleT>();
	List<HrDutyScheduleM> validateHrDutyScheduleMList = new ArrayList<HrDutyScheduleM>();
	List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
	String month1="";
	int empCate =0;
	if(map!=null && map.get("masEmpCategoryList")!=null)
	{
		masEmpCategoryList = (List<MasEmpCategory>)map.get("masEmpCategoryList");
	}
	
	if(map.get("masShiftCodesList") != null){
		masShiftCodesList = (List<HrMasShiftCodes>)map.get("masShiftCodesList");
	}
	if(map.get("masDepartmentList") != null){
		masDepartmentList = (List<Object[]>)map.get("masDepartmentList");
	}

	if(map.get("masGradeList") != null){
		masGradeList = (List<MasGrade>)map.get("masGradeList");
	}
	if(map.get("masEmployeeDepartmentList") != null){
		masEmployeeDepartmentList = (List<MasEmployeeDepartment>)map.get("masEmployeeDepartmentList");
	}
	if(map1.get("srchEmplList") != null){
		srchEmplList = (List<MasEmployee>)map1.get("srchEmplList");
	}
	if(map1.get("hrDutyScheduleTList") != null){
		hrDutyScheduleTList = (List<HrDutyScheduleT>)map1.get("hrDutyScheduleTList");
	}
	if(map1.get("hrDutyScheduleMList") != null){
		hrDutyScheduleMList = (List<HrDutyScheduleM>)map1.get("hrDutyScheduleMList");
	}
	if(map1.get("validateHrDutyScheduleMList") != null){
		validateHrDutyScheduleMList = (List<HrDutyScheduleM>)map1.get("validateHrDutyScheduleMList");
	}
	if(map1.get("month") != null){
		month1 = (String)map1.get("month");
	}
	int year1=0;
	if(map1.get("year") != null){
		year1 = Integer.parseInt(""+map1.get("year"));
	}
	if(map1.get("empCate") != null){
		empCate = (Integer)map1.get("empCate");
	}
	int deptId=0;
	if(map1.get("deptId") != null){
		deptId = Integer.parseInt(""+map1.get("deptId"));
	}
//	System.out.println(">>>"+srchEmplList.size());
	String message = ""; 
	if(map.get("message")!=null)
	{
		message = (String)map.get("message");
	}
	if(map1.get("message")!=null)
	{
		message = (String)map1.get("message");
	}
	String monthArr[]={"January-1","February-2","March-3","April-4","May-5","June-6","July-7","August-8","September-9","October-10","November-11","December-12"};
	
	%>
<h4><span><%= message%></span></h4>
<div class="titleBg">
<h2>Duty Schedule</h2>
</div>
<form name="itemGrid" method="post">
<div class="Block">
<div id="searcharea">
<div id="searchbar">

<!-- <form name="search" method="post" action=""> -->

<label>Department<span>*</span></label> 
<select name="deptId" id='dept' validate="Department,string,yes">	
<option value="0">Select</option>
	<% for(MasEmployeeDepartment masEmployeeDepartment: masEmployeeDepartmentList){%>

	<option value="<%=masEmployeeDepartment.getId() %>"><%=masEmployeeDepartment.getEmpDeptName()%>
	</option>
	<%} %>
</select>
<script>
<% if(deptId!=0){%>

document.getElementById('dept').value='<%=deptId%>'
<%
}%>
</script>

<%-- <label>Speciality</label> 
<select name="dept" id='dept' validate="Department,string,no">	
<option value="">Select</option>
	<% for(MasEmpCategory emp: masEmpCategoryList){%>

	<option value="<%=emp.getId() %>"><%=emp.getEmpCategoryName()%>
	</option>
	<%} %>
</select> --%>

<label><span>*</span>Employee Category</label> 
<select name="<%=EMPLOYEE_CATEGORY %>" id='empCate' validate="Employee Category,alphanumeric,yes">	
<%if(empCate ==0){%>
<option value="">Select</option>
	<% 
	
	for(MasEmpCategory emp: masEmpCategoryList){%>

	<option value="<%=emp.getId() %>"><%=emp.getEmpCategoryName()%>
	</option>
	<%}}else{for(MasEmpCategory emp: masEmpCategoryList){
		if(emp.getId() == empCate){%>
		<option   value="<%=emp.getId() %>" selected><%=emp.getEmpCategoryName()%>
		<%}} %>
		
		<%for(MasEmpCategory emp: masEmpCategoryList){%>
		
		<option   value="<%=emp.getId() %>"><%=emp.getEmpCategoryName()%>
		<%}%>
		
	<%}%>	
	
</select>

<%-- 
<label><span>*</span>Grade</label> 
<select name="grade" id='grade' validate="Grade,alphanumeric,no">	
<option value="">Select</option>
	<% for(MasGrade gr: masGradeList){
		if(gr.getGradeName() != null){
	%>
			
	<option value="<%=gr.getId() %>"><%=gr.getGradeName()%>
	</option>
	<%} }%>
</select> --%>

<div class="clear"></div>
<label><span>*</span>Month</label> 
<select name="month" id="month" validate="Month,string,yes" onChange="abc();">	
<option value="">Select</option>
<% 
for(int i=0; i<monthArr.length;i++){%>
<option value="<%=monthArr[i].split("-")[1]%>"><%=monthArr[i].split("-")[0]%></option>
<%}%>
</select>
<script>
<%if(!month1.equals("")){%>
	document.getElementById('month').value='<%=month1%>'
<%}%>
</script>
<label><span>*</span>Year</label> 
<select name="year" id="year" validate="Year,string,yes" >	

<option value="">Select</option>
<%-- <option value="<%=year-1 %>"><%=year-1 %></option> --%>
<option value="<%=year %>"><%=year %></option>
<option value="<%=year+1 %>"><%=year+1 %></option>
</select>

<script>
<%if(year1!=0){%>
	document.getElementById('year').value='<%=year%>'
<%}%>
</script>
<div class="clear"></div>
<input type="button" name="search" value="GO" class="button" 	onClick="submitForm('itemGrid','/hms/hrms/attendance?method=searchDutyScheduleEmployee')"	tabindex=1 /> 
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<!-- <form name="itemGrid" method="post"> -->
<h4>Details</h4>
<input name="" value="" id="temp" type="hidden" /> 
<!-- <input type="button"	class="button" value="Add Row" onclick="addRow();" align="right" /> 
<input	type="button" class="button" value="Delete Row" onclick="removeRow()"	align="right" /> -->
<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />

<div class="tableForTab-duty-schedule" >
<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemDetails">


		<tr>
			<th width="13%" align="left">Employee</th>
			<th width="13%" align="left">Designation</th>
			
			<%
			int noOfDays =0;
			if(month1.equals("1") || month1.equals("3") || month1.equals("5") || month1.equals("7") || month1.equals("8") || month1.equals("10") || month1.equals("12") ){
				noOfDays = 31;
			}else if(month1.equals("2")){
				if(year1%4==0)
					noOfDays = 29;
				else
					noOfDays=28;
			}else {
				noOfDays = 30;
			}
				for(int i=1;i<=noOfDays;i++){ %>
			<th colspan="2" align="center"> <%=i %></th>
			<%}
				%>
		
		</tr>
		
	
<%	int j=1;
int newCnt = 1;
int scheduleMId = 0;
	//for(Object[] me: srchEmplList){
		for(MasEmployee emp : srchEmplList){
	%>
	<tr>
			<td>
		
			 <input type="text" name="employee<%=j  %>" value="<%=emp.getEmployeeName()!=null?emp.getEmployeeName():""%>"	tabindex=1  id="empName<%=j  %>" readonly="readonly" size="20"/>
			<input type="hidden" name="employee_id<%=j  %>" value="<%=emp.getId()%>"	tabindex=1  id="empId<%=j  %>"  size="20"/>
			
			</td>
			<td>
			<input type="text" name="desig<%=j  %>" value="<%=emp.getRank().getRankName() %>"	tabindex=1  id="fromTime<%=j  %>" readonly="readonly"/>
			<input type="hidden" name="changeFlag<%=j%>" id="changeFlag<%=j %>" value="n" />
			</td>

			<%	
			Set<EmpScMapping> deptSet = new HashSet<EmpScMapping>();
			if(emp.getEmpScMappings()!=null){
				deptSet = emp.getEmpScMappings();
			}
			scheduleMId = 0;
			
			for(int k=1;k<=noOfDays;k++){
				int shiftIdDb = 0;
				int deptIdDb = 0;
				
				int scheduleTId = 0;
			if(hrDutyScheduleTList.size()>0){
			
			
			for(HrDutyScheduleT hdstList: hrDutyScheduleTList){
				if(hdstList.getScheduleM().getEmployee().getId().equals(emp.getId()) && Integer.parseInt(hdstList.getDay())==k){
					shiftIdDb = hdstList.getShiftCode()!=null?hdstList.getShiftCode().getId():0;
					deptIdDb = hdstList.getScheduleDepartment()!=null?hdstList.getScheduleDepartment().getId():0;
					scheduleMId = hdstList.getScheduleM().getId();
					scheduleTId = hdstList.getId();
					
				break;
				}
			}
			}		
			if(deptIdDb!=0){
				%>
				<script>displayShift('<%=newCnt %><%=j%><%=k %>',<%=deptIdDb%>)</script>
			<%}
				%>
				
				<td>
					<input type="hidden" name="scheduleT<%=j %>" value="<%=scheduleTId %>"	tabindex=1  id="scheduleT_id<%=newCnt %><%=j%><%=k %>"  size="20"/>
							<select name="departmentId<%=j%>" id='departmentId<%=newCnt %><%=j%><%=k %>' class="" onChange="displayShift('<%=newCnt %><%=j%><%=k %>',this.value)" validate="Department,string,no" >	
					<option value="0">Select</option>
							<%
							//for(Object[] masDepartment:masDepartmentList){
							
								for(EmpScMapping empSc : deptSet){
									if(empSc.getDepartment()!=null)	{
								
								%>
						<option value="<%=empSc.getDepartment().getId() %>" ><%=empSc.getDepartment().getDepartmentName()%></option>
							<%} 
							}%>
						</select>
						<script type="text/javascript">
							document.getElementById('departmentId<%=newCnt %><%=j%><%=k %>').value='<%=deptIdDb%>';
</script>
	
			</td>
			
			<td>
				<select name="shift<%=j%>" id='shift<%=newCnt %><%=j%><%=k %>' class="small" validate="shift,string,no" onChange="changeFlagId(this.value,'<%=j%>','<%=k%>')">
				<option value="0">Select</option>
							<%-- <% for(HrMasShiftCodes shift: masShiftCodesList){
								%>
							<option value="<%=shift.getId() %>" ><%=shift.getShiftName()%></option>
							<%} %>
						</select>
						 --%>
</td>
<script type="text/javascript">
setTimeout(function(){ document.getElementById('shift<%=newCnt%><%=j%><%=k %>').value='<%=shiftIdDb%>' },2000)
							
</script>

<%}%>
<input type="hidden" name="scheduleM<%=j  %>" value="<%=scheduleMId%>"	tabindex=1  id="scheduleM_id<%=j  %>"  size="20"/>
			

<%j++;newCnt++;} %>


</table>
</div>
<!-- </div> -->
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="hidden" value="<%=srchEmplList.size()%>" name="hiddenValueCharge" id="hiddenValueCharge" /> 
<div id="testDiv"></div>
<%	if(hrDutyScheduleTList.size()==0){ %>
<input name="button"  type="button"	value="Submit" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/attendance?method=saveDutySchedule')"  />
<%}else if(hrDutyScheduleTList.size() >0){ %>
<input name="button"  type="button"	value="Update" class="button"	 onClick="submitForm('itemGrid','/hms/hrms/attendance?method=saveDutySchedule')"  />
<%} %>

<div class="clear"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%="admin"%></label>
<label>Changed Date</label> <label class="value"><%=date%></label>
<label>Changed Time</label> <label class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%="admin"%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<input type="hidden"	name="CHANGED_DATE" value="<%=date%>" /> 
<input type="hidden"	name="CHANGED_TIME" value="<%=time%>" />
</div>
<div class="clear"></div>

<script type="text/javascript">

function changeFlagId(val,j,k){
	if(val != 0){
		document.getElementById('changeFlag'+j).value='y';
	}else{
		document.getElementById('changeFlag'+j).value='n';
	}
	
}
function addRow(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name='session'+(iteration);
	e0.id='session'+(iteration);
	//e0.setAttribute('validate','Session,string,no');
	e0.size="20";
	e0.value="Sess2";
	e0.tabIndex="1";
	cell0.appendChild(e0);
	

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='fromTime'+iteration;
	e1.id='fromTime'+(iteration);
	//e1.setAttribute('validate','From Time,string,no');
	e1.value='12';
	e1.size="20";
	e1.tabIndex="1";
	e1.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e1.onblur = function(){
				  IsValidTime(this.value,this.id);
		}
	cell1.appendChild(e1);

	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='toTime'+(iteration);
	e2.id='toTime'+(iteration);
	//e2.setAttribute('validate','To Time,string,no');
	e2.value="";
	e2.size="20";
	e2.tabIndex="1";
	e2.onkeyup = function(){
		mask(this.value,this,'2,5',':');
			  }
	e2.onblur = function(){
				  IsValidTime(this.value,this.id);
		}
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
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);

		}
	}

	
}

function abc1(row,shift){
	//alert(row+"  "+shift)
	var empcate= document.getElementById('empCate').value
	submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift&shift='+shift+'&row='+row+'&empcate='+empcate,'testDiv'+row);
	//submitProtoAjaxWithDivName('itemGrid','/hms/hrms/attendance?method=getSessForShift','testDiv'+row);
}
</script>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>