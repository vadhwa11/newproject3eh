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
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationT"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.MasCadre"%>
<%@page import="jkt.hms.masters.business.HrVacancyPost"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
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
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	List<HrVacancyPost> hrVacancyPosts=new ArrayList<HrVacancyPost>();
	List<HrTransferApplicationT> hrTransferApplicationTs=new ArrayList<HrTransferApplicationT>();
	if(map.get("hrVacancyPosts") != null){
		hrVacancyPosts=(List<HrVacancyPost>)map.get("hrVacancyPosts");
	}
	if(map.get("hrTransferApplicationTs") != null){
		hrTransferApplicationTs=(List<HrTransferApplicationT>)map.get("hrTransferApplicationTs");
	}
	int balancePost=0;
	if(hrVacancyPosts.get(0).getBalancePost()!=null){
		balancePost=hrVacancyPosts.get(0).getBalancePost();
	}else{balancePost=hrVacancyPosts.get(0).getVpermanentPost();}
	
%>


<form name="search" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 <div class="titleBg">
<title>Transfer Processing</title>
 <h2>Transfer Processing Details</h2>
</div>
<div class="clear"></div>

	<div class="Block">
	 
	<label>Designation</label> 
	<label class="value"><%=hrVacancyPosts.get(0).getSanctionedPost().getRank()!=null?hrVacancyPosts.get(0).getSanctionedPost().getRank().getRankName():"" %></label>
	<label>Institution</label> 
	<label class="value"><%=hrVacancyPosts.get(0).getSanctionedPost().getInstitution().getHospitalName() %></label>
	<label>Department</label> 
	<label class="value"><%=hrVacancyPosts.get(0).getSanctionedPost().getDepartment()!=null?hrVacancyPosts.get(0).getSanctionedPost().getDepartment().getEmpDeptName():"" %></label>
	<div class="clear"></div>
	<label>Vacant Post</label> 
	<label class="value"><%=hrVacancyPosts.get(0).getVpermanentPost() %></label>
	<label>Allocated Post</label> 
	<label class="value" id="allocatedPost"><%=hrVacancyPosts.get(0).getAllocatedPost()!=null?hrVacancyPosts.get(0).getAllocatedPost():"0" %></label>
	<label>Balance Post</label> 
	<label class="value" id="balancePost"><%=balancePost%></label>
 
<div class="clear"></div>
</div>
</form>
<h4>Details</h4>
<form name="transferDetails" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%int count=1;
if(hrTransferApplicationTs.size()>0){ %>
<div id="pageNavPosition"></div>
	<table class="cmntable">
		<tr>
			<th width="13%">CheckBox</th>
			<th width="13%">Employee Name</th>
			<th width="13%">PEN</th>
			<th width="13%">Current Designation</th>
			<th width="13%">Current Department</th>
		</tr>
		<%  
		for(HrTransferApplicationT hrTransferApplicationT:hrTransferApplicationTs){
		%>
		<tr>
			<td><input type="checkbox" onclick="return allotedPost('EmployeeId<%=count %>')" id="EmployeeId<%=count %>" name="EmployeeName<%=count%>" value="<%=hrTransferApplicationT.getTransferApp().getId() %>" /></td>
			<td><%=hrTransferApplicationT.getTransferApp().getEmployee().getEmployeeName() %></td>
			<td><%=hrTransferApplicationT.getTransferApp().getEmployee().getPEN() %></td>
			<td><%=hrTransferApplicationT.getTransferApp().getEmployee().getRank().getRankName() %></td>
			<td><%=hrTransferApplicationT.getTransferApp()!= null && hrTransferApplicationT.getTransferApp().getEmployee()!= null && hrTransferApplicationT.getTransferApp().getEmployee().getEmployeeDepartment().getEmpDeptName()!= null?hrTransferApplicationT.getTransferApp().getEmployee().getEmployeeDepartment().getEmpDeptName():"" %></td>
		</tr> 
		<%++count; }%>
	</table>
<%
	if(map.get("search") != null)
	{
%>
		<a href="training?method=showTransferProcessingJsp">Show All Records</a>
<%
	}
%>
<input type="hidden" name="requestHospitalId" value="<%=request.getParameter("requestHospitalId") %>" />
<input type="hidden" name="vacancyPostId" value="<%=request.getParameter("requestId") %>" />
<input type="hidden" name="count" value="<%=count %>" />
<%if(map.get("userType").equals(1)) {%>
<input class="button" type="button" onclick="if(selectedData()){submitForm('transferDetails','training?method=saveProcessingDetails');}" value="Save" tabindex="2">
<%} else {%>
<input class="button" type="button" onclick="if(selectedData()){submitForm('transferDetails','training?method=saveProcessingDetails');}" value="Save" tabindex="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="button" type="button" onclick="if(selectedData()){submitForm('transferDetails','training?method=forwardProcessingDetails');}" value="Forward" tabindex="2">
<%} %>

 <%}else{ %>
 	<div class="Block"><span>No Records Available.</span></div>
 <%} %>
 </form>
<div class="paddingTop40"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="indentTrackingDetails"></div>
<div class="clear"></div>
<script type="text/javascript">
		function selectedData(){
			var count=parseInt(<%=count%>);
			var selectName=0;
			for(var i=1;i<count;i++){
				if(document.getElementById("EmployeeId"+i).checked)
					selectName=selectName+1
			}
			if(selectName==0){alert("You have not Selected Employee.");return false;}
				return true;
		}
		function allotedPost(employeeId){
			var balance=parseInt(<%=balancePost%>);
			var count=parseInt(<%=count%>)-1;
			var allocatedPost=document.getElementById("allocatedPost").innerHTML;
			var balancePost=document.getElementById("balancePost").innerHTML;
			if(document.getElementById(employeeId).checked){
				if(balancePost>0){
					document.getElementById("allocatedPost").innerHTML=parseInt(allocatedPost)+1;
					document.getElementById("balancePost").innerHTML=parseInt(balancePost)-1;
					return true;
				}else{
					alert("Vacant Post is not Available");
					return false;
				}
				
			}else{
				document.getElementById("allocatedPost").innerHTML=parseInt(allocatedPost)-1;
				document.getElementById("balancePost").innerHTML=parseInt(balancePost)+1;
				return true;
			}
		}
</script>
 