<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author  Mukesh Narayan Singh
 * Create Date: 1st Jun,2012 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	
	if(map.get("masEmployeeList")!=null){
		masEmployeeList =(List) map.get("masEmployeeList");
		
	}
	if(map.get("masHospitalList")!=null){
		masHospitalList =(List) map.get("masHospitalList");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	String superAdmin = "";
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
	int hospitalId=0;
	if(map.get("hospitalId")!=null){
		hospitalId= (Integer)map.get("hospitalId");
	}else if(session.getAttribute("hospitalId")!=null){
		hospitalId= (Integer)session.getAttribute("hospitalId");
	}
	int districtId = 0;
	if(map.get("districtId")!=null){
		districtId = (Integer)map.get("districtId");
	}else if(session.getAttribute("districtId")!=null){
		districtId = (Integer)session.getAttribute("districtId");
	}
	%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>


<form name="showUserAssinedTemplet" method="post">
<%if(message!=null && !message.equals("")){ %>
<h4><%=message %></h4>
<%} %>

<div class="titleBg">
<h2>Institute Wise Authority Level</h2>
</div>
<div class="Block">
<label>Institution</label>
<select name="hospital" id="hospitalId">
<option value="0">Select</option>
<%for(MasHospital mh:masHospitalList){ %>
<option value="<%=mh.getId() %>"><%=mh.getHospitalName() %></option>
<%} %>
</select>
<label>Authority Level</label>
<select name="authLevel" id="AuthLevelId" onchange="populateForAuthLevel(this.value);">
<option value="0">Select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
</div>
<div class="clear"></div>
<div id="valueDiv" ></div>
<%-- <table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
<!-- 		<th scope="col">Amount</th>
		<th scope="col">Cheque Status</th>
		<th scope="col">Clearing Date</th>
		<th scope="col">&nbsp;</th>
 -->	</tr>
	<%
for(int i=1;i<=4;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text"  name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			<input type="hidden" name="name" value=""/>
			<select name="name" id="name<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>
</div>
<div id="tabId3" style="display: none;">
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
<!-- 		<th scope="col">Amount</th>
		<th scope="col">Cheque Status</th>
		<th scope="col">Clearing Date</th>
		<th scope="col">&nbsp;</th>
 -->	</tr>
	<%
for(int i=1;i<=3;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text" readonly="readonly" name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			<input type="hidden" name="name" value=""/>
			<select name="name" id="chequeNoId<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>
</div>
<div id="tabId2" style="display: none;">
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
<!-- 		<th scope="col">Amount</th>
		<th scope="col">Cheque Status</th>
		<th scope="col">Clearing Date</th>
		<th scope="col">&nbsp;</th>
 -->	</tr>
	<%
for(int i=1;i<=2;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text" readonly="readonly" name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i %>" name="DesigNation" value=""/>
			</td>


			 <td>
			<input type="hidden" name="name" value=""/>
			<select name="name" id="chequeNoId<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>
</div>
<div id="tabId1" style="display: none;">
<table  width="100%" border="0" id="accId" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Sl No.</th>
		<th scope="col">DesigNation</th>
		<th scope="col">Employee Name</th>
<!-- 		<th scope="col">Amount</th>
		<th scope="col">Cheque Status</th>
		<th scope="col">Clearing Date</th>
		<th scope="col">&nbsp;</th>
 -->	</tr>
	<%
for(int i=1;i<=1;i++){
		int vrHdId = 0;

				//for(FaVoucherDetails voucherDetails : voucherDtList){
				//	if(voucherDetails.getVoucherHeader().getChequeNo()!=null){
				//	vrHdId = voucherDetails.getVoucherHeader().getId();
	%>
		<tr>
			<td>
			<input type="text" readonly="readonly" name="slNo" id="slNoId<%=i %>" value="<%=i%>"/>
			</td>
			
			<td><input type="text"  id="DesigNation<%=i  %>" name="DesigNation" value=""/>
			</td>


			 <td>
			<input type="hidden" name="name" value=""/>
			<select name="name" id="chequeNoId<%=i %>" >
			<option value="0">Select</option>
			<%for(MasEmployee me:masEmployeeList){
				//if(d.getVoucherHeader().getChequeNo()!=null){
				%>
			<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
			<%}
				//} %>
			</select>
			
			</td>
		</tr>
		<%	}	//i++;
		//}//}
	%>

</table>
</div> --%>
<div class="clear"></div>
<script>
function populateForAuthLevel(val){
	submitProtoAjaxWithDivName('showUserAssinedTemplet','user?method=getResponeValueForAuhorizationLevel&value='+val,'valueDiv');
}


</script>

<script>
function updateData(rowVal,headerId){
	var srNo=document.getElementById('slNoId'+rowVal).value;
	var designation=document.getElementById('DesigNation'+rowVal).value;
	var empId=document.getElementById('name'+rowVal).value
	//alert(designation+""+srNo);
	submitForm('showUserAssinedTemplet','user?method=updateDataForAuthLeve&srNo='+srNo+'&designation='+designation+'&empId='+empId+'&headerId='+headerId);
}
function saveData(val,headermainId){
	var srNo=document.getElementById('slNoId'+val).value;
	var designation=document.getElementById('DesigNation'+val).value;
	var empId=document.getElementById('name'+val).value
/* 	//alert(designation+""+srNo); */
	submitForm('showUserAssinedTemplet','user?method=saveDataForAuthLeve&srNo='+srNo+'&designation='+designation+'&empId='+empId+'&headerId='+headermainId);
}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>