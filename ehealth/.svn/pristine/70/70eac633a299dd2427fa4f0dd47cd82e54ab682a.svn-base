<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	String chargeCodeName1="";
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<DgOrderdt>dgOrderDtList = new ArrayList<DgOrderdt>();
	List<DgOrderhd>dgOrderhdList = new ArrayList<DgOrderhd>();
	if(map.get("dgOrderDtList")!=null){
		dgOrderDtList = (List)map.get("dgOrderDtList");
	}
	if(map.get("dgOrderhdList")!=null){
		dgOrderhdList = (List)map.get("dgOrderhdList");
	}
	int  dgorderHdId = 0;
	if(map.get("dgorderHdId")!=null){
		dgorderHdId = (Integer)map.get("dgorderHdId");
	}
	int hinId = 0;
	if(map.get("hinId")!=null){
		hinId = (Integer)map.get("hinId");
	}
	
	%>

<div id="contentHolder">
<div class="titleBg">
<h2>Patient Investigation  Details</h2>
</div>
<div class="clear"></div>


<form name="patientInvestigation" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hinId" id = "hinId"  value="<%=hinId%>"/>
<label>Visit No</label>

<select name="visitNo" onchange="displayLabTestDetails(this.value);">
<option value="">Select</option>
<%if(dgOrderhdList.size()>0){
	for(DgOrderhd dgOrderhd : dgOrderhdList){
		if(dgOrderhd.getId()==dgorderHdId){
	%>
<option value="<%=dgOrderhd.getVisit().getId()%>" selected="selected"><%=dgOrderhd.getVisit().getVisitNo()%></option>
<%}else{ %>
<option value="<%=dgOrderhd.getVisit().getId()%>"><%=dgOrderhd.getVisit().getVisitNo()%></option>
<%}}} %>
</select>




<%if(dgOrderDtList.size() > 0){ %>

<div class="tableHolderAuto">
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<th scope="col">Test Name </th>
		<th scope="col">Result</th>
		
	</tr>
<%
int i=1;

for(DgOrderdt orderdt:dgOrderDtList)
{
	 
	String url="/hms/hms/enquiry?method=investigationResult&orderNo="+orderdt.getOrderhd().getOrderNo()+"&chargeCodeId="+orderdt.getChargeCode().getId(); 
%>


	<tr> 
		<td><%=orderdt.getChargeCode().getChargeCodeName()%></td>  
		<td><input type="button" accesskey="a" class="button" value="Result" 
			 onclick="popwindowresult('<%=url%>');" id="print" name="print"></td>
		
		
	</tr>
	<%i++;} %>
</table>
</div>
<div class="clear"></div>
<!-- <div id="edited"></div>
<input id="save" property="save" type="button" tabindex="1"	name="repeat" value="Repeat" class="button"	onclick="if(checkRepeat()){setValuesInParent(patientInvestigation)}" />
<input	type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 /> -->
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
<div class="clear"></div>
<%}else{ %>
<h4><span> No Records Found!</span></h4>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<%} %>
</form>
</div>

<script type="text/javascript">
function displayLabTestDetails(visitId){
	var hinId = document.getElementById('hinId').value;
	submitForm('patientInvestigation','/hms/hms/opd?method=displayLabTest&visitId='+visitId+'&hinId='+hinId);
}

function popwindowresult(url)
{  
 newwindow=window.open(url,'resultWindow','height=700,width=850,scrollbars=1');
 if (window.focus) 
 {
 newwindow.focus();
 }
 newwindow.createPopup();
}
</script>



