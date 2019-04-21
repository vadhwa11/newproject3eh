 <%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferProcessing.jsp  
 * Purpose of the JSP -  This is for Employee Transfer Information.
 * @author  VKS  
  * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"src="/erp/jsp/js/proto.js"></script>

 

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
		
	</script> 
<%
	Map<String,Object> map = new HashMap<String,Object>();
	 
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}  
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
  	String msg="";
    List<MasHospital> institutionList = new ArrayList<MasHospital>();
    List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
    List<MasDistrict> masDistrictList=new ArrayList<MasDistrict>();
    List<HrTransferApproved> inactiveEmpList = new ArrayList<HrTransferApproved>();
    if(map.get("inactiveEmpList") != null){
    	inactiveEmpList=(List<HrTransferApproved>) map.get("inactiveEmpList");
	}
	
    if(map.get("institutionList") !=null){
		institutionList =(List) map.get("institutionList");
	}
	if(map.get("mhospitalTypetList") !=null){
		mhospitalTypetList =(List) map.get("mhospitalTypetList");
	}
	if(map.get("masDistrictList")!=null){
		masDistrictList=(List)map.get("masDistrictList");
	}
	
	if(map.get("msg")!=null){
		msg=(String)map.get("msg");
	} 	
%>
<title>Inactive Employee Processing</title>
<span><%=msg %></span>
<div class="titleBg">
<h2>Inactive Employee Processing</h2>
</div>
<h4>Inactive Employee Details</h4>
<div id="pageNavPosition"></div>
	<table >
		<tr>
			<th width="13%">Employee ID</th>
		    <th width="13%">Name</th>
		    <th width="13%">Designation</th>
		    <th width="13%">Department</th>
			<th width="13%">Previous Institution</th>
		</tr>
		<tbody id="tableData">
		<%
		if(inactiveEmpList.size()>0){ 
			int count=1;
		for(HrTransferApproved inactiveEmp:inactiveEmpList){
		%>
		<tr onclick="javascript:getRowValues(this);">
		    
		    <td><%=inactiveEmp.getEmployee().getId()!=null?inactiveEmp.getEmployee().getId():""%></td>
			<td><%=inactiveEmp.getEmployee().getEmployeeName()!=null?inactiveEmp.getEmployee().getEmployeeName():"" %></td>
			<td><%=inactiveEmp.getEmployee().getRank().getRankName()!=null?inactiveEmp.getEmployee().getRank().getRankName():""%></td>
			<td><%=inactiveEmp.getEmployee().getEmployeeDepartment().getEmpDeptName()!=null?inactiveEmp.getEmployee().getEmployeeDepartment().getEmpDeptName():""%></td>
			<td><%=inactiveEmp.getTransferApp().getCurHospital().getHospitalName()!=null?inactiveEmp.getTransferApp().getCurHospital().getHospitalName():"" %></td>
			<td style="visibility: hidden;"><%=inactiveEmp.getId()!=null?inactiveEmp.getId():"" %></td>
		</tr> 
		<%++count;} }%>
		</tbody>
	</table>
	<div class="clear"></div>
	<div class="paddingTop5"></div>
 	<% if(inactiveEmpList.size()==0){%>
	<h2>No Records Available.</h2>
	<%} %>
	
	<script>
		var pager = new Pager('tableData',5);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
</script> 
<div class="clear"></div>
<div class="paddingTop5"></div>
<div id="searcharea">
<div id="searchbar">
<form name="activeEmployee" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Assign Institute To Inactive Employee</h4>
<div class="clear"></div>
<div class="Block" >
 <div class="clear"></div>
 <input type="hidden" id="approvedId" name="approvedId" />
 <label>Employee Id</label> <input type="text" id="employeeId" name="employeeId" readonly="readonly" />

<label>Name </label> <input type="text" id="name" name="name" readonly="readonly" />

<label>Designation</label> <input type="text" id="designation" name="designation" readonly="readonly" />

<div class="clear"></div>
<label>Department</label> <input type="text" id="department" name="department" readonly="readonly"/>

<label>Previous Institution</label><input type="text" id="previousInstitution" name="previousInstitution" readonly="readonly"/>

<label><span>*</span>Joining Date</label> 
<input type="text"  name="joiningDate" value="<%=date %>" class="date"
	maxlength="30" validate="Pick a from date,date,yes" readonly="readonly"/>

<!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" tabindex="1"
	onclick=""/> -->
<img border="0" width="16" height="16" class="calender" validate="Pick a date" onclick="javascript:setdate('',document.activeEmployee.joiningDate,event)" src="/hms/jsp/images/cal.gif">

<div class="clear"></div>
 <label>District<span>*</span></label>
<select id="district"	name="district" validate="District ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasDistrict  md : masDistrictList){%>
		<%if(md.getDistrictName()!=null){ %>
		 
	<option value="<%=md.getId()%>"><%=md.getDistrictName()%></option>
	<%} %> 
	<%} %>
	</select>
	 
<label>Institution Type<span>*</span></label> 
<select id="instituteType"	name="instituteType" validate="Institute type ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasHospitalType  mht : mhospitalTypetList)
		{
	%>
	<option value="<%=mht.getId()%>"><%=mht.getHospitalTypeName()%></option>
	<%
		}
	%> 
	</select>
	 
	<label>Institution<span>*</span></label> <select name="institute" id="institute" validate="Institute,string,no">
	<option value="">Select</option>
	  <%
		for (MasHospital masHospital: institutionList) {
	%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>

	<%
		}
	%>  
</select> 
<div class="clear"></div>
<input type="button" class="button" tabindex="1" value="Active Employee" onclick="activateEmployee();" />
<div class="clear"></div>
</div>
</form>
</div>
</div>
<div class="clear"></div>

<script type="text/javascript">
function activateEmployee(){
	 var empId=document.getElementById("employeeId").value;
	 var district=document.getElementById("district").value;
	 var instituteType=document.getElementById("instituteType").value;
	 var institute=document.getElementById("institute").value;
	 
	 if(empId==""){
		 alert("Please select Employee !");
		 return;
	 }else if(district=="0"){
		 alert("Please select District !");
		 return;
	 }else if(instituteType=="0"){
		 alert("Please select Institute Type !");
		 return;
	 }else if(institute=="0"){
		 alert("Please select Institute !");
		 return;
	 }else{
		 submitForm('activeEmployee','training?method=assignHospitalToEmployee');
	 }
}
</script>

 <script type="text/javascript">
 
function removeAllOptions(selectbox)
{
	var i;
	for(i=selectbox.options.length-1;i>=0;i--)
	{
		selectbox.remove(i);
	}
}

  function populateInst(id)
  {
	var hosType=document.getElementById("instituteType").value; 
	var dist=document.getElementById("district").value;
	//alert(hosType+" -- "+dist)
	var sel = document.getElementById("institute");
	removeAllOptions(sel);
	if(hosType!="0" && dist==0){
		//alert(hosType+" hosType not zero dist- "+dist)
	var size = <%=institutionList.size()%>  
	optionRepMan = new Option("Select" , "0","true");
	sel.options.add(optionRepMan);
		 	<%
			for(MasHospital mid:institutionList){%>
				if(<%=mid.getHospitalType().getId()%> == hosType){<%
				if(mid.getStatus().equalsIgnoreCase("y")){
			%>
				optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
				sel.options.add(optionRepMan);
			<%}
			%>
				}
				<%}%>
		}
	
	if(dist!="0" && hosType =="0"){
		//alert(hosType+" not zero dist- "+dist)
		var size = <%=institutionList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);

		<%
				for(MasHospital mid:institutionList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
				
			}
	
	if(dist!="0" && hosType !="0"){
		var size = <%=institutionList.size()%>
		optionRepMan = new Option("Select" , "0","true");
		sel.options.add(optionRepMan);
				<%
				for(MasHospital mid:institutionList){%>
				<%if(mid.getDistrict()!=null){%>
					if(<%=mid.getDistrict().getId()%> == dist && <%=mid.getHospitalType().getId()%> == hosType){<%
					if(mid.getStatus().equalsIgnoreCase("y")){
				%>
					optionRepMan = new Option("<%=mid.getHospitalName()%>" , "<%=mid.getId()%>","true");				
					sel.options.add(optionRepMan);
						
				<%}
				%>
					}
					<%}%>
					<%}%>
			}
}

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;
   return true;
}
 
</script>
<script language="javascript" type="text/javascript">
function getRowValues(row)
{
var x=row.cells;
document.getElementById("employeeId").value = x[0].innerHTML;
document.getElementById("name").value = x[1].innerHTML;
document.getElementById("designation").value = x[2].innerHTML;
document.getElementById("department").value = x[3].innerHTML;
document.getElementById("previousInstitution").value = x[4].innerHTML;
document.getElementById("approvedId").value = x[5].innerHTML;
}
</script>
					