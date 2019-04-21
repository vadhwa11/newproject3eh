<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * bedStatus.jsp  
 * Purpose of the JSP -  This is for Bed Status Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 14th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.12 
--%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBedStatus"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasDepartment> searchBedStatusList =new ArrayList<MasDepartment>();
	List<MasInstituteDepartment> wardList =new ArrayList<MasInstituteDepartment>();
			if(map.get("departmentList")!=null){
				searchBedStatusList=	(List<MasDepartment>)map.get("departmentList");
			}
			if(map.get("wardList")!=null){
				wardList=	(List<MasInstituteDepartment>)map.get("wardList");
			}
			
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
		 <script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<div class="titleBg">
<h2>Unit Wise Table/Bed</h2>
</div>
<div class="clear"></div>
<form name="unitWiseTable" method="post">
<div class="Block">
<label>OT </label>
<input type="radio" class="radiobutMargin" name="deptType" value="O" checked="checked" id="deptId1" onclick="checkForDeptType(this.value);" />
<label>Ward</label>
<input type="radio" class="radiobutMargin" name="deptType" value="W" id="deptId11" onclick="checkForDeptType(this.value);" />
<div id="otDiv" style="display: inline;">
<label>Department <span>*</span></label>
<select name="departmentName" id="departmentId2" validate="Department,int,no" onchange="submitProtoAjaxWithDivName('unitWiseTable','/hms/hms/inPatientMaster?method=getTableBasedOnUnit&dept_id=this.value','unitDiv');" >
<option value="0">Select</option>
<%for(MasDepartment dept:searchBedStatusList){ %>
<option value="<%=dept.getId()%>"><%=dept.getDepartmentName() %></option>
<%} %>
</select>
</div>
<div id="wardDiv" style="display: none;">
<label>Department <span>*</span></label>
<select name="departmentName2" id="departmentId" validate="Department,int,no" onchange="submitProtoAjaxWithDivName('unitWiseTable','/hms/hms/inPatientMaster?method=getTableBasedOnUnit&dept_id=this.value','unitDiv');" >
<option value="0">Select</option>
<%for(MasInstituteDepartment dept:wardList){ %>
<option value="<%=dept.getDepartment().getId()%>"><%=dept.getDepartment().getDepartmentName() %></option>
<%} %>
</select>
</div>
<input type="hidden" name="depType2" id="departmentTypeId" value="O" />

<div id="unitDiv"></div>

<input type="button" value="save" onclick="submitForm('unitWiseTable','/hms/hms/inPatientMaster?method=saveUnitWiseTable');" />
</div>
<div class="clear"></div>
<script>
function checkForDeptType(val){
	//alert(val);
	if(val=='O')
	{
	document.getElementById('otDiv').style.display="inline";
	document.getElementById('wardDiv').style.display="none";
	document.getElementById('departmentTypeId').value="O";
	document.getElementById('departmentId2').value="0";
	document.getElementById('departmentId').value="0";
	
	}else if(val=='W'){
		document.getElementById('wardDiv').style.display="inline";
		document.getElementById('otDiv').style.display="none";
		document.getElementById('departmentTypeId').value="W";
		document.getElementById('departmentId').value="0";
		document.getElementById('departmentId2').value="0";

	}
}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
