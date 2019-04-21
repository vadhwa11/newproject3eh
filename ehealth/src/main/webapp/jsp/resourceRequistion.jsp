<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrVacancyPost"%>
<%@page import="jkt.hms.masters.business.HrInstitutionalSanctionedPost"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hrms.masters.business.MasDesignation"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="jkt.hrms.masters.business.EtrApptbl"%>
<%@page import="jkt.hrms.masters.business.EtrFillbookeddtls"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="java.math.BigDecimal"%>


<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>

<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>
<script language="javascript">

var $j = jQuery.noConflict();
</script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
				int designation_order=0;
				Map<String, Object> map2= new HashMap<String, Object>();
				List<MasEmployee> empListToBeShortListed = new ArrayList<MasEmployee>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				Set<EtrApptbl> etrApptblSet = new HashSet<EtrApptbl>();
				Set<EtrFillbookeddtls> etrFillBookDetailSet= new HashSet();
				List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
				List<MasRank> designationList = new ArrayList<MasRank>();
				List<MasRank> masRank1 = new ArrayList<MasRank>();
				List<MasEmployeeDepartment> masEmployeeDepartmentList = new ArrayList<MasEmployeeDepartment>();
				List<MasGrade> gradeList = new ArrayList<MasGrade>();
				List<MasCadre> cadreList = new ArrayList<MasCadre>();
				List<Object[]> availPostList = new ArrayList<Object[]>();
				List<MasHospital> institutionList=new ArrayList<MasHospital>();
				List<MasRank> masRank=new ArrayList<MasRank>();
				List<HrInstitutionalSanctionedPost> sanctionPostInstituteMasterList = new ArrayList<HrInstitutionalSanctionedPost>();
				
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("userEmployeeList")!= null){
					userEmployeeList = (List)map.get("userEmployeeList");
				}
				
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				
				if(map.get("institutionList")!= null){
					institutionList = (List)map.get("institutionList");
				}
				if(map.get("sanctionPostInstituteMasterList")!= null){
					sanctionPostInstituteMasterList = (List)map.get("sanctionPostInstituteMasterList");
				}
				
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("designationList")!= null){
					designationList = (List)map.get("designationList");
				}
				if(map.get("masRank1")!= null){
					masRank1 = (List)map.get("masRank1");
				}
				if(map.get("masEmployeeDepartmentList")!= null){
					masEmployeeDepartmentList = (List)map.get("masEmployeeDepartmentList");
				}
				if(map.get("rankListFromEmp")!= null){
					availPostList = (List<Object[]>)map.get("rankListFromEmp");
				}
				if(map.get("gradeList")!= null){
					gradeList = (List<MasGrade>)map.get("gradeList");
				}
				if(map.get("cadreList")!= null){
					cadreList = (List<MasCadre>)map.get("cadreList");
				}
							
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
				int instituteId = 0;
				int cadreId = 0;
				int departmentId = 0;
				int designationId = 0; 
				if(map.get("instituteId") != null){
					instituteId = (Integer)map.get("instituteId");
				}
				if(map.get("cadreId") != null){
					cadreId = (Integer)map.get("cadreId");
				}
				if(map.get("departmentId") != null){
					departmentId = (Integer)map.get("departmentId");
				}
				if(map.get("designationId") != null){
					designationId = (Integer)map.get("designationId");
				}
					
				
				String userName = "";
			
				String flag="";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				
				if(map.get("map2") != null)
				{
				map2 = (Map<String, Object> )map.get("map2");
				}
				
				if(map2.get("promoEmpList") != null)
				{
				 empListToBeShortListed = (List<MasEmployee>)map2.get("promoEmpList");
				//session.setAttribute("searchResumeList",resumeListToBeShortListed);
				}
				if(map2.get("designation_order") != null)
				{
					designation_order = Integer.parseInt(""+map2.get("designation_order"));
				}
				
				if(map.get("flag") != null)
				{
				flag = (String )map.get("flag");
				}
			
				String desigOrder="";
				if(map.get("id") != null)
				{
					desigOrder = (String)map.get("id");
				}
				
				String locationName = "";
				String empName = "";
				int empId = 0;
				String designation = "";
				String department = "";
				String orgnization = "";
				if(userEmployeeList.size()>0){
					for(MasEmployee masEmployee1 :userEmployeeList){
						empName = masEmployee1.getFirstName()+" "+masEmployee1.getMiddleName()+" "+masEmployee1.getLastName()+"-"+masEmployee1.getEmployeeCode();
							
						if(masEmployee1.getDepartment() != null){
							department = masEmployee1.getDepartment().getDepartmentName();
							}
						if(masEmployee1.getRank() != null){
							designation = masEmployee1.getRank().getRankName();
							}
						if(masEmployee1.getHospital() != null){
							orgnization = masEmployee1.getHospital().getHospitalName();
							}
					}
				}
			
				
	%>
<script type="text/javascript">
	
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

<div class="titleBg"> <h2>Employee Promotion </h2></div>
<div class="Block">
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>Institution</label> <select name="institute" id="instituteId" validate="Institute,alphanumeric,yes">
	<option value="">Select</option>
	<%
		if(institutionList.size()>0){
		for (MasHospital masHospital: institutionList) {
			if(masHospital.getId().equals(instituteId)){
	%>

	<option value="<%=masHospital.getId()%>" selected="selected"><%=masHospital.getHospitalName()%></option>
	<%}else{ %>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%
		}}}
	%>
</select> 
	
	
<label><span>*</span>Department</label> <select name="department" id="departmentId" validate="Department,alphanumeric,yes">
	<option value="">Select</option>
	<%
	if(masEmployeeDepartmentList.size()>0){
		for (MasEmployeeDepartment masEmployeeDepartment: masEmployeeDepartmentList) {
			if(masEmployeeDepartment.getId().equals(departmentId)){
			
	%>

	<option value="<%=masEmployeeDepartment.getId ()%>" selected="selected"><%=masEmployeeDepartment.getEmpDeptName()%></option>
<%}else{ %>
	<option value="<%=masEmployeeDepartment.getId()%>"><%=masEmployeeDepartment.getEmpDeptName()%></option>
	<%
		}}}
	%>
</select> 
	
<label>Designation</label> <select name="designation" id="designationId" validate="Designation,alphanumeric,no">
	<option value="">Select</option>
	<%
		for (MasRank rank: designationList) {
	%>

	<option value="<%=rank.getId ()%>"><%=rank.getRankName()%></option>

	<%
		}
	%>
</select>
  
<div class="clear"></div>
 	
<%-- <label><span>*</span>Grade</label> <select name="grade" validate="Department,string,yes">
	<option value="">Select</option>
	<%
		for (MasGrade masGrade: gradeList) {
			if(masGrade.getGradeName()!=null){
	%>

	<option value="<%=masGrade.getId ()%>"><%=masGrade.getGradeName()%></option>

	<%}
		}
	%> --%>

 
<label>Cadre</label> <select name="cadre" id ="cadreId" validate="Cadre,alphanumeric,no">
	<option value="">Select</option>
	<%
		for (MasCadre masCadre: cadreList) {
	%>

	<option value="<%=masCadre.getId ()%>"><%=masCadre.getCadreName()%></option>

	<%
		}
	%>
</select>

<%--  <div class="clear"></div>

<label>From Date </label>
<input id="fromDateId" type="text"  name="<%=FROM_DATE %>" value="" class="calDate"  readonly="readonly" validate="From date ,date,no"  MAXLENGTH="30" /> --%>
 <!-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/> -->

<%-- <label>To Date </label>
<input id="toDateId" type="text"  name="<%=TO_DATE %>" value="" class="calDate"  readonly="readonly" validate="TO date ,date,no"  MAXLENGTH="30" /> --%>
 <!-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId'),event)"/> -->

<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','recruitment?method=searchResourceReqJsp')" tabindex=1  />
</form>
</div>
</div>
</div>

<div class="clear"></div>
<% 
if(map.get("search") != null)
{
%>
<a href="recruitment?method=showResourceReqJsp">Show All Records</a>

<%
}
%>

<form name="manPowerRequisition" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<h4>Vacant Post Details:</h4>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table id="searchresulttable"  width="100%" cellspacing="0" cellpadding="0">
<tr>
<th>Select</th>
<th>Department</th>
<th>Vacant Designation</th>
<!-- <th>Post Approved</th>-->
<th>Post Available</th> 
<th>Post Vacant</th>
<!-- <th>Direct</th> 
 <th>Promotion</th> 
<th>Direct Req</th>
<th>Promotion Req</th>-->
</tr>
<tbody id="tableData">
<%

	int count = 0;
	int i = 0;
	int travelRequestId = 0;
	String hotelDesc = "";
	String approver = "";
	String cabDesc = "";
	String klass = "even";
	String statusTime = "";
	String statusDate = "";
	String bookStatus = "";
	String bookedStatusTime = "";
	String bookedStatusDate = "";
	Set<HrVacancyPost> vaccantPostSet = new HashSet<HrVacancyPost>();
 if(sanctionPostInstituteMasterList.size()>0){
	for (HrInstitutionalSanctionedPost institutionalSanctionedPost :sanctionPostInstituteMasterList) {
		//if(masranks.getGrade() != null && masranks.getCadre() != null){
			//if(true){
		if(institutionalSanctionedPost.getHrVacancyPosts() != null){
			vaccantPostSet = (Set)institutionalSanctionedPost.getHrVacancyPosts();
		}
	  			
		//System.out.println("institutionalSanctionedPost.getRank().getDesignationOrder() ===="+institutionalSanctionedPost.getRank().getDesignationOrder() );	 
	//System.out.println("desigOrder=="+desigOrder);	 	
%>

<tr>
<%if (desigOrder ==""){ %>
<td><%-- <input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=masranks.getDesignationOrder()%>" onClick="getEmp(this.value,<%=i%>)" ; /> --%>
		<input name="rb<%=i%>"  class="radioCheck" id="rb<%=i%>" type="radio" value="<%=institutionalSanctionedPost.getRank()!= null && institutionalSanctionedPost.getRank().getDesignationOrder() != null?institutionalSanctionedPost.getRank().getDesignationOrder():""%>" onclick="getEmp(this.value,<%=i%>)" />
		<input name="desigOrder"  class="radioCheck" id="desigOrder<%=i%>" type="hidden" value='' onclick="getEmp(this.value,<%=i%>)" />

</td>
<%}else{ %>
<td><%-- <input name="<%=TRAVEL_REQUEST_ID%><%=i%>"  class="radioCheck" id="rb<%=i%>" type="checkbox"  value="<%=masranks.getDesignationOrder()%>" onClick="getEmp(this.value,<%=i%>)" ; /> --%>
<%
if(institutionalSanctionedPost.getRank().getDesignationOrder() != null){
if(Integer.parseInt(desigOrder) == institutionalSanctionedPost.getRank().getDesignationOrder()) {%>
		<input name="rb<%=i%>"  class="radioCheck" id="rb<%=i%>" type="radio"  checked="checked" value="<%=(institutionalSanctionedPost.getRank()!= null && institutionalSanctionedPost.getRank().getDesignationOrder()!=null)?institutionalSanctionedPost.getRank().getDesignationOrder():""%>" onclick="getEmp(this.value,<%=i%>)" />
		<input name="desigOrder"  class="radioCheck" id="desigOrder<%=i%>" type="hidden" value='' onclick="getEmp(this.value,<%=i%>)" />
		<%}else{ %>
		<input name="rb<%=i%>"  class="radioCheck" id="rb<%=i%>" type="radio" value="<%=institutionalSanctionedPost.getRank()!= null && institutionalSanctionedPost.getRank().getDesignationOrder() != null?institutionalSanctionedPost.getRank().getDesignationOrder():""%>" onclick="getEmp(this.value,<%=i%>)" />
		<input name="desigOrder"  class="radioCheck" id="desigOrder<%=i%>" type="hidden" value='' onclick="getEmp(this.value,<%=i%>)" />
		<%}}else{ %>
		<input name="rb<%=i%>"  class="radioCheck" id="rb<%=i%>" type="radio" value="<%=institutionalSanctionedPost.getRank()!= null && institutionalSanctionedPost.getRank().getDesignationOrder() != null?institutionalSanctionedPost.getRank().getDesignationOrder():""%>" onclick="getEmp(this.value,<%=i%>)" />
		<input name="desigOrder"  class="radioCheck" id="desigOrder<%=i%>" type="hidden" value='' onclick="getEmp(this.value,<%=i%>)" />
		<%} %>

</td>
<%} %>

<td><%-- <%=masranks.getDepartment().getDepartmentName()%><input type="hidden" id="dept<%=i%>" name="dept<%=i%>" value="<%=masranks.getDepartment().getId()%>"/> --%>
 <%=institutionalSanctionedPost.getDepartment()!= null?institutionalSanctionedPost.getDepartment().getEmpDeptName():""%><input type="hidden" id="dept<%=i%>" name="dept<%=i%>" value="<%=institutionalSanctionedPost.getDepartment()!= null?institutionalSanctionedPost.getDepartment().getId():""%>"/>
</td>
<td><%=institutionalSanctionedPost.getRank()!= null?institutionalSanctionedPost.getRank().getRankName():"" %><input type="hidden" id="desig<%=i%>" name="desig<%=i%>" value="<%=institutionalSanctionedPost.getRank()!= null?institutionalSanctionedPost.getRank().getId():"" %>" />
</td>
<%-- <td><%=masranks.getPostApproved() %><input type="hidden" id="approve<%=i%>" name="approve<%=i%>" value="<%=masranks.getPostApproved()%>"/> </td> --%>


<%-- <%

int vacantPost=0;
int post=0;
int rankId=0;
for(Object[] availPost : availPostList){
 rankId=Integer.parseInt(""+availPost[1]);
 if(masranks.getId() ==rankId  ){
	post =Integer.parseInt(""+availPost[0]);
 }
 vacantPost = masranks.getCadre().getCadreStrength()-post; 
// vacantPost =11;
}
	%>
 --%>
<td><a href="#" onclick="openPopupWindow('<%=institutionalSanctionedPost.getRank()!= null?institutionalSanctionedPost.getRank().getId():""%>');" ><%=institutionalSanctionedPost.getPermanentPost()!= null?institutionalSanctionedPost.getPermanentPost():"" %></a><input type="hidden" id="avail<%=i%>" name="avail<%=i%>" value="<%=institutionalSanctionedPost.getPermanentPost()!= null?institutionalSanctionedPost.getPermanentPost():"" %>"/></td>

<%
int vacantPost = 0;
if(vaccantPostSet.size()>0){
	for(HrVacancyPost vacantPostObj : vaccantPostSet){
	if(vacantPostObj.getVpermanentPost() != null){
		vacantPost = (Integer)vacantPostObj.getVpermanentPost();
	}
	}
}
	

	
	%>

 <td><%=vacantPost %> <input type="hidden" id="vacant<%=i%>" name="vacant<%=i%>" value="<%=vacantPost%>" /></td> 
<td></td>
 <%

 /* String modeDirect = masranks.getModeDirect();
 String modePromotion = masranks.getModePromotion();
 String modeContract = masranks.getModeContract(); */
 
 String modeDirect = "";
 String modePromotion = "";
 String modeContract = "";
		 
 float directPost=0;
 float promotionPost=0;
 float contractPost=0;
 if(modeDirect != null && modeDirect.equals("y")){

	// BigDecimal directPer= masranks.getDirectPercent();
	
	 //directPost=(directPer.floatValue()*vacantPost)/100;
	 	 
	 //directPost = (directPer.intValue()%100)*masranks.getApprovePost();
	// System.out.println(vacantPost+"sec e---"+directPost);
 }
 
 /* if(modePromotion != null && modePromotion.equals("y") && masranks.getPromotionPercent() != null){
	 BigDecimal promotionPer= masranks.getPromotionPercent();
	 System.out.println("promotionPer>>"+promotionPer);
	 promotionPost=(promotionPer.floatValue()*vacantPost)/100;
	 
	//promotionPost = (promotionPer.intValue()/100)*masranks.getApprovePost();
 }
 if(modeContract != null && modeContract.equals("y")){
	 BigDecimal contractPer= masranks.getContractPercent();
	 if(contractPer != null){
	 contractPost=(contractPer.floatValue()*vacantPost)/100;
	 }
 } */
 
 %>
<%-- <td><%=  new Float((Math.round(directPost+contractPost))).intValue() %><input type="hidden" id="direct<%=i%>" name="direct<%=i%>" value="<%= new Float((Math.round(directPost+contractPost))).intValue()%>"/></td> 

<td><%= new Float((Math.round(2))).intValue() %><input type="hidden" id="prom<%=i%>" name="prom<%=i%>" value="<%= new Float((Math.round(2))).intValue()%>"/></td>

<td><input type="text" id="directReq<%=i%>" name="directReq<%=i%>" value="" onblur="checkDirectReq('<%=i%>','direct')" onkeyPress="return isNumber(event)"/></td>

<td><input type="text" id="promReq<%=i%>" name="promReq<%=i%>" value="" onblur="checkDirectReq('<%=i%>','prom')" onkeyPress="return isNumber(event)"/></td>--%>
</tr>

 		<%
 		i++;
 		 //}
		}
	}
 //}
%>
</tbody>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="countId" name="travelId" value="">
<script type="text/javascript">
</script>
 <script>
	  var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

	  </script>
<div class="clear"></div>
	
	<% if(empListToBeShortListed != null && empListToBeShortListed.size()!= 0) {
	 %>
	<h4><u>Employee List For Promotion :</u></h4>
	<!-- <a href="#" onClick="twolevel()"> show next two level</a> -->
 	<div class="clear"></div> 
 	<%
 	int i1 = 0;
 	int counter = 0;
	String klass1 = "";
 	if(empListToBeShortListed.size()!=0){ %>
 	<table cellspacing="0" cellpadding="0" width="100%">
 		<tr>
 			<th><input type="checkbox" name="allIds" value="yes" onClick="checkAll()" class="radioCheck"  /></th>
 			<th>PEN</th>
			<th>Employee Name</th>
			<th>Present Designation</th>
			<th>Institute</th>		
			<!-- <th>Exp(in yrs)</th>				
			<th>Expected CTC</th>	
			<th>Status</th> -->
 		</tr>
 		<tbody>
 			<%
 				
 				for(MasEmployee me : empListToBeShortListed ){
 					counter++;
 					
 				if(i1%2 == 0)
 				{
 					klass1="even";
 				}
 				else
 				{
 					klass1="odd";
 				}
 				
 				%>
 			
 			<tr class=<%=klass1%>">
 
 			<%-- <%if(designation_order+1 == me.getRank().getDesignationOrder()){ %> --%>
 			<td><input type="checkbox" name="id<%=i1%>" value="<%=me.getId()%>" onClick="unCheck(this)" class="radioCheck" /></td>
 			<td><%=me.getPEN() != null ? me.getPEN() :""%> </td>
 			<td><%=me.getEmployeeName()%> </td>
 			<td><%=me.getRank().getRankName()%><input type="hidden" name="rankId<%=i1%>" id="rankId" value="<%=me.getRank().getId()%>"> </td>
 			<td><%=me.getHospital().getHospitalName()%> </td>
 			<%-- <td><%=resume.getExperienceYear()%> </td>
 			<td><%=expectedCTC%> </td>
 			<td><%=resume.getResumeStatus().getResumestatusmaster().getStatusDesc()%> </td> --%>
 			
 			</tr>
 			
 			<%-- <%} %> --%>
 			<%i1++;} %>
 			<input type="hidden" name="empcount" id="empcount" value="<%=empListToBeShortListed.size()%>">
 		</tbody>
 	</table>
 	<%} 
 	else
 	{%>
 		<h4>No Employee are there For promotion .</h4>
 	<%}
 	%> 
	
	<%} else if(empListToBeShortListed.size()== 0 && flag.equalsIgnoreCase("s")){%>
	<h4>No Employee are there For promotion .</h4>
	
	<%} %>

<div class="clear"></div>
<!-- <input name="Submit" type="button" class="button" value="Submit" onClick="submitForm('manPowerRequisition','recruitment?method=saveManPowerRequisitionDetail','chkCheckBoxes');"/> -->
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" name="assignto" value="Submit" class="button" onClick="checkAndSubmit()" >
</form>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"><%=userName%></label>

<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>

</div>
		
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			

<script type="text/javascript">

function checkAndSubmit()
	{

	var url;
	var radioButton;
	for(i = 0 ;i<<%=sanctionPostInstituteMasterList.size()%>;i++)
	{
		radioButton = document.getElementById('rb'+i);
		//alert("radioButton=="+radioButton);
		if(radioButton.checked == true)
		{
		 url = '/hms/hrms/resume?method=saveEmpPromo&requestId='+ radioButton.value;
		}
	}
	//alert("url==="+url);
	if(url == '')
		{
		alert('Please select a manpower request');
		}
		else
		{
		submitForm('manPowerRequisition',url,'chkCheckBoxesForAuthorization');
		}
	}

function disableCheckBoxes(cnt){
	var count = document.getElementById('countId').value;
	for(var i=0;i<count;i++){
		if(i != cnt){
			if(document.getElementById('rb'+cnt).checked){
				document.getElementById('rb'+i).disabled = true;
			}else{
				document.getElementById('rb'+i).disabled = false;
			}
		}
	}
}

function openPopupWindow(rankId)
{ 
var id = 0; 
	 for(var i = 0; i < document.getElementsByName('rb').length; i++){
		  if(document.getElementsByName('rb')[i].checked == true)
          {
			id = document.getElementsByName('rb')[i].value;
		  }		
		}
		var url="/hms/hrms/recruitment?method=viewPost&rankId="+rankId+"";
		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	
}


function checkDirectReq(rowval,val)
{ 
if(val=='direct'){

var dirPost=document.getElementById('direct'+rowval).value
var dirReqPost=document.getElementById('directReq'+rowval).value
	if(dirReqPost <= dirPost){
		
	}else
		{
		alert("Direct Requistion can not greater than Direct Vacancy.")
		document.getElementById('directReq'+rowval).value='';
		
		}
	
}else if(val=='prom'){
	var promPost=document.getElementById('prom'+rowval).value
	var promReqPost=document.getElementById('promReq'+rowval).value
		if(promReqPost <= promPost){
			
		}else
			{
			alert("Promotion Requistion can not greater than Promotion Vacancy.")
			document.getElementById('promReq'+rowval).value='';
			}
	
}
	
}

function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31 && (charCode<48 || charCode >57))
      return false;

   return true;
}

function chkCheckBoxes()
{

	inps = document.getElementsByTagName('input');
	flag=false;
	for(i=0;i<inps.length;i++)
	{
			if(inps[i].type == 'checkbox')
			{
			if(inps[i].checked)
			{
   	            flag=true;
 			     break;
			}
		}
	}
	if(!flag)
	{
	
		alert("Please select one of the Row.");
		return false;
	}
	return true;
}


function getEmp(id,i){
	//alert("dsfdsf");
	var department =document.getElementById('departmentId').value;
	var designation =document.getElementById('designationId').value
	var cadre =document.getElementById('cadreId').value
	var institute =document.getElementById('instituteId').value
	// document.getElementById("desigOrder"+i).value = id;
	//document.getElementById('desigOrder').value =order;
	//var url ='/hms/hrms/resume?method=showShortListEmpForPromo&flag=s&id='+id
	if(id!=null && id!=''){
	var url ='/hms/hrms/recruitment?method=searchResourceReqJsp&flag=s&id='+id+'&department='+department+'&designation='+designation+'&cadre='+cadre+'&institute='+institute;	
	submitForm('manPowerRequisition',url);	
}
}


function unCheck(obj)
{
	if(obj.checked==false)
	{
	document.shortlistResume.allIds.checked=false;
	}
}


function checkAll()
{
	var no = <%=empListToBeShortListed.size()%>;

	for(j=0;j<=no;j++)
	{
		var obj = "document.manPowerRequisition." + "id" +j;
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
			if(document.manPowerRequisition.allIds.checked==true)
			{
			obj.checked=true;
			}
			else
			{
			obj.checked=false;
			}
		}
	}
} 

</script>