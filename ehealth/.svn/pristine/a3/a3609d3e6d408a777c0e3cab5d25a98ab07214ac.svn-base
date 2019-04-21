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
<%@page import="jkt.hms.masters.business.HrVacancyPost"%>
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
	List<MasEmployeeDepartment> deptpartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasCadre> cadreList = new ArrayList<MasCadre>();
	List<MasRank> designationList = new ArrayList<MasRank>();
	List<HrVacancyPost> hrVacancyPosts=new ArrayList<HrVacancyPost>();
	  
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
	if(map.get("hrVacancyPosts") != null){
		hrVacancyPosts=(List<HrVacancyPost>)map.get("hrVacancyPosts");
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
 <h2>Transfer Processing</h2>
</div>
<div class="clear"></div>
<div class="Block" >
 
 <label>District </label> 
<select id="district"	name="district" validate="District ,string,no" tabindex=1 onChange="populateInst('temp')" >
	<option value="0">Select</option>
	 <% 
		for (MasDistrict  md : masDistrictList){%>
		<%if(md.getDistrictName()!=null){ 
			if(md.getState().getId() == 32){
		%>
		 
	<option value="<%=md.getId()%>"><%=md.getDistrictName()%></option>
	<%}
			}%> 
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
	 
	<label>Institution</label> <select name="institute" id="institute" validate="Institute,string,no">
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
 <label>Department</label> <select name="department" id="department" validate="Department,string,no">
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
 	
<label>Designation</label> <select name="designation" id="designation" validate="Designation,string,no">
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
<input type="button" class="button" tabindex="1" value="Search" onclick="submitForm('search','training?method=showTransferProcessingJsp');" />
<div class="clear"></div>
</div>
</form>
</div>
</div>
<div class="clear"></div>
<h4>Details</h4>
<div id="pageNavPosition"></div>
	<table class="cmntable">
		<tr>
			<th width="13%">Institution</th>
			<th width="13%">Department</th>
			<th width="13%">Designation</th>
			<th width="13%">Vacant Post</th>
			<th width="13%">Allocated Post</th>
			<th width="13%">Balance</th>
		</tr>
		<%
		if(hrVacancyPosts.size()>0){ 
			int count=1;
		for(HrVacancyPost hrVacancyPost:hrVacancyPosts){
			int balancePost=0;
			if(hrVacancyPost.getBalancePost()!=null){
				balancePost=hrVacancyPost.getBalancePost();
			}else{
				balancePost=hrVacancyPost.getVpermanentPost();}
		%>
		<form method="post" name="transferProcessing<%=count %>">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="requestId" value="<%=hrVacancyPost.getId() %>" />
		<input type="hidden" name="rankId" value="<%=hrVacancyPost.getSanctionedPost()!=null?hrVacancyPost.getSanctionedPost().getRank()!=null?hrVacancyPost.getSanctionedPost().getRank().getId():"":"" %>" />
		<input type="hidden" name="requestHospitalId" value="<%=hrVacancyPost.getSanctionedPost().getInstitution().getId() %>" />
		<tr onclick="submitForm('transferProcessing<%=count %>', 'training?method=showTransferProcessingDetailsJsp')">
			<td><%=hrVacancyPost.getSanctionedPost().getInstitution().getHospitalName() %></td>
			<td><%=hrVacancyPost.getSanctionedPost().getDepartment().getEmpDeptName() %></td>
			<td><%=hrVacancyPost.getSanctionedPost().getRank()!=null?hrVacancyPost.getSanctionedPost().getRank().getRankName():"" %></td>
			<td><%=hrVacancyPost.getVpermanentPost()!=null?hrVacancyPost.getVpermanentPost():"0" %></td>
			<td><%=hrVacancyPost.getAllocatedPost()!=null?hrVacancyPost.getAllocatedPost():"0" %></td>
			<td><%=balancePost %></td>
		</tr> 
		</form>
		<%++count;} }%>
	</table>
<%
	if(map.get("search") != null)
	{
%>
		<a href="training?method=showTransferProcessingJsp">Show All Records</a>
<%
	}
%> 

<div class="clear"></div>
<div id="indentTrackingDetails"></div>
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
					
			
