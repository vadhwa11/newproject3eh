 <%--
 * Copyright 2016 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * transferProcessing.jsp  
 * Purpose of the JSP -  This is for Employee Transfer  Approved Information.
 * @author  Kaushal Mishra  
  * Revision Date:      
 * Revision By: 
 * 
--%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrVacancyPost"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
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
	List<MasEmployeeDepartment> deptpartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasCadre> cadreList = new ArrayList<MasCadre>();
	List<MasRank> designationList = new ArrayList<MasRank>();
	List<HrTransferApproved> hrApprovalList=new ArrayList<HrTransferApproved>();
	  
	if(map.get("institutionList") !=null){
		institutionList =(List) map.get("institutionList");
	}
	if(map.get("mhospitalTypetList") !=null){
		mhospitalTypetList =(List) map.get("mhospitalTypetList");
	}
	if(map.get("masDistrictList")!=null){
		masDistrictList=(List)map.get("masDistrictList");
	}
	if(map.get("deptpartmentList") !=null){
		deptpartmentList =(List) map.get("deptpartmentList");
	}
	if (map.get("cadreList") != null) {
		cadreList = (List<MasCadre>) map.get("cadreList");
	}
	
	if (map.get("designationList") != null) {
		designationList = (List<MasRank>) map.get("designationList");
	}
	if(map.get("hrApprovalList") != null){
		hrApprovalList=(List<HrTransferApproved>)map.get("hrApprovalList");
	}
	if(map.get("msg")!=null){
		msg=(String)map.get("msg");
	}
 	
%>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 <div class="titleBg">
<span><%=msg %></span>
<div class="clear"></div>
 <h4>Approval Cancellation</h4>
</div>
<div class="Block" > 
 <label>District </label> 
<select id="district"	name="district" validate="District ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasDistrict  md : masDistrictList){%>
		<%if(md.getDistrictName()!=null){
			
			%>
		 
	<option value="<%=md.getId()%>"><%=md.getDistrictName()%></option>
	<%} %> 
	<%} %>
	</select>
	 
<label>Institution Type </label> 
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
	 
	<label>Institution<span>*</span></label><select name="institute" id="institute" validate="Institute,string,no">
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
 <label>Department<span>*</span></label> <select name="department" id="department" validate="Department,string,no">
	<option value="">Select</option>
	  <%
		for (MasEmployeeDepartment masDepartment: deptpartmentList) {
	%>
	<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getEmpDeptName()%></option>

	<%
		}
	%>  
</select> 

<label>Cadre </label> 
<select id="cadre"	name="cadre" validate="Cadre ,string,no" tabindex=1 onChange="populateDesignation(this.value,'designation')">
	<option value="">Select</option>
	 <% 
		for (MasCadre  mcl : cadreList)
		{
	%>
	<option value="<%=mcl.getId()%>"><%=mcl.getCadreName()%></option>
	<%
		}
	%> 
	</select>
 	
<label>Designation<span>*</span></label> <select name="designation" id="designation" validate="Designation,string,no">
	<option value="">Select</option>
	  <%
		for (MasRank masRank: designationList) {
	%>
	<option value="<%=masRank.getId ()%>"><%=masRank.getRankName()%></option>

	<%
		}
	%>  
</select>
<div class="clear"></div>
<input type="button" class="button" tabindex="1" value="Search" onclick="submitForm('search','training?method=cancleApprovalDetails');" />
<div class="clear"></div>
</div>
</form>
</div>
</div>

<h4>Transfer Approved Details</h4>
<div id="pageNavPosition"></div>
<form name="approvalDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<%
		if(hrApprovalList.size()!=0){ 
			int count=1;
		for(HrTransferApproved hrApproval:hrApprovalList){			
		%>
<table>
		<tr>
		    <th width="13%">CheckBox</th>
		    <th width="13%">Employee ID</th>
		    <th width="13%">Name</th>
		    <th width="13%">Designation</th>
		    <th width="13%">Department</th>
			<th width="13%">Current Institution</th>
			<th width="13%">Transferred Institution</th>			
		</tr>
<tbody id="tableData">
		<%-- <%
		if(hrApprovalList.size()!=0){ 
			int count=1;
		for(HrTransferApproved hrApproval:hrApprovalList){			
		%> --%>		
	<tr>	
			<td><input type="checkbox"  id="EmployeeId<%=count %>" name="EmployeeName<%=count%>" value="<%=hrApproval.getId() %>" /></td>
			<td><%=hrApproval.getEmployee().getId()!=null?hrApproval.getEmployee().getId():""%></td>
			<td><%=hrApproval.getEmployee().getEmployeeName()!=null?hrApproval.getEmployee().getEmployeeName():"" %></td>
			<td><%=hrApproval.getEmployee().getRank().getRankName()!=null?hrApproval.getEmployee().getRank().getRankName():""%></td>
			<td><%=hrApproval.getEmployee().getEmployeeDepartment().getEmpDeptName()!=null?hrApproval.getEmployee().getEmployeeDepartment().getEmpDeptName():""%></td>
			<td><%=hrApproval.getTransferApp().getCurHospital().getHospitalName()!=null?hrApproval.getTransferApp().getCurHospital().getHospitalName():"" %></td>
			<td><%=hrApproval.getTransferApp().getTrHospital().getHospitalName()!=null?hrApproval.getTransferApp().getTrHospital().getHospitalName():""%></td>
			</tr> 
		
		<%++count;} 
		%>
	</tbody>
</table>

<div class="clear"></div>
<input type="hidden" name="count" id="count" value="<%=count %>" />
<input class="button" type="button" onclick="if(selectedData()){submitForm('approvalDetails','training?method=cancelApproval');}" value="Cancel Approval" tabindex="2">
 <%}else{%>
 <div class="clear"></div>
 <h2>No Records Available.</h2>
	<%} %>
</form>
<div class="clear"></div>


 <script>
 	searchSelected();
 	function searchSelected(){
 		<%if(request.getParameter("institute")!=null && request.getParameter("institute")!=""){%>
 		var institute=<%=request.getParameter("institute")%>;
 		if(institute!=null){
 			document.getElementById("institute").value=institute;
 		}
 		<%}if(request.getParameter("department")!=null && request.getParameter("department")!=""){%>
 		var department=<%=request.getParameter("department")%>;
 		if(department!=null){
 			document.getElementById("department").value=department;
 		}
 		<%}if(request.getParameter("designation")!=null && request.getParameter("designation")!=""){%>
 		var designation=<%=request.getParameter("designation")%>;
 		if(designation!=null){
 			document.getElementById("designation").value=designation;
 		}
 		<%}%>
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
 
function populateDesignation(cadre,id){	
		var sel = document.getElementById(id);
		removeAllOptions(sel);
		if(cadre !="0"){
				<% 
				for(MasRank mr:designationList){%>
				<%if(mr.getCadre()!=null){%>
				 if(<%=mr.getCadre().getId() %> == cadre){ <% 
							if(mr.getStatus().equalsIgnoreCase("y")){
						%>
					optionRepMan = new Option("<%=mr.getRankName()%>" , "<%=mr.getId()%>","true");				
					sel.options.add(optionRepMan);
					<%}%>
					}
				 <%}%>
					<%}%>
					optionRepMan = new Option("<%="Select"%>" , "0","true");				
					sel.options.add(optionRepMan);
		}
}
</script>
<script type="text/javascript">
		function selectedData(){
			var count=document.getElementById("count").value;
			var selectName=0;
			for(var i=1;i<count;i++){
				if(document.getElementById("EmployeeId"+i).checked)
					selectName=selectName+1
			}
			if(selectName==0){alert("You have not Selected Employee.");return false;}
				return true;
		}
		</script>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
</script>  

	
					
			
