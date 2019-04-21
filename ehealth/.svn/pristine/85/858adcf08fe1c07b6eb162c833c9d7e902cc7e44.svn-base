<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_ICD_Search.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.08.2008    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<SCRIPT LANGUAGE="JavaScript">
<!--
	function setServiceNo(serviceNo) {
		opener.setServiceNo(serviceNo);
		self.close();
	}
	
	function sub()
	{
	if (ICDSearchForm.icd_name.value=="")
    {
    	alert("Pl. Check your Input..... ");
    	return;
    }
    else
	{
		submitForm('ICDSearchForm','adt?method=showICDSearchJsp');
	}
	}
	
//-->
</SCRIPT>

<title>Patient Search</title>

<style type="text/css">
<!--
.schInput {
	BACKGROUND-COLOR: #ffffff;
	BORDER-BOTTOM: #bfbfbf 1px solid;
	BORDER-LEFT: #bfbfbf 1px solid;
	BORDER-RIGHT: #bfbfbf 1px solid;
	BORDER-TOP: #bfbfbf 1px solid;
	COLOR: #4a4a4a;
	FONT-FAMILY: Arial;
	FONT-SIZE: 11px;
	height: 15px;
}

#linetblhdr {
	BACKGROUND-COLOR: #EBE7E7;
	BORDER-BOTTOM: #d1bfe8 1px solid;
	BORDER-LEFT: #d1bfe8 1px solid;
	BORDER-RIGHT: #d1bfe8 1px solid;
	BORDER-TOP: #d1bfe8 1px solid;
	COLOR: #000000;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	font-weight: 400;
	MARGIN: 1px;
	vertical-align: middle;
	cursor: hand
}

#sel {
	BACKGROUND-COLOR: #CAE7EF;
	FONT-FAMILY: Verdana, Arial, Helvetica, sans-serif;
	FONT-SIZE: 8pt;
	cursor: hand
}
-->
</style>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
	List<MasRank> rankList = new ArrayList<MasRank>();
	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
	List<MasUnit> unitList = new ArrayList<MasUnit>();
	List<Patient> patientList = new ArrayList<Patient>();
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("inpatientList")!=null)
			inpatientList = (List)map.get("inpatientList");
	}
	if(map.get("serviceTypeList") != null){
		serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
	}
	if(map.get("rankList") != null){
		rankList= (List<MasRank>)map.get("rankList");
	}
	if(map.get("unitList") != null){
		unitList= (List<MasUnit>)map.get("unitList");
	}
%>

<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 12 Aug 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div id="mainIn">
<form name="patientSearchForm" action="" method="post">
<div class="titleBg">
<h2>Patient Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="50" id="hinNo" /> <%--
			<label class="bodytextB1">Service No:</label> 
			<input type="text" name="<%=SERVICE_NO %>" value="" class="textbox_size20" MAXLENGTH="20" id="serviceNo"/>
			--%> <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text" name="<%=AD_NO %>"
	value="" MAXLENGTH="20" id="serviceNo" />

<div class="clear"></div>

<label>Pt. First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="pFName" /> <label>Pt.
Mid Name</label> <input type="text" name="<%=P_MIDDLE_NAME %>" value=""
	MAXLENGTH="15" id="pMName" /> <label>Pt. Last Name</label> <input
	type="text" name="<%=P_LAST_NAME%>" value="" MAXLENGTH="15" id="pLName" />

<div class="clear"></div>

<%--
						<label class="bodytextB1">Ser. First Name:</label>
			<input type="text" name="<%=S_FIRST_NAME %>"  value="" class="textbox_size20" MAXLENGTH="15" id="sFName"/>
	 				
			<label class="bodytextB1">Ser. Mid Name:</label> 
			<input type="text" name="<%=S_MIDDLE_NAME %>"  value="" class="textbox_size20" MAXLENGTH="15" id="sMName"/>
			
			<label class="bodytextB1">Ser. Last Name:</label> 
			<input type="text" name="<%=S_LAST_NAME%>"  value="" class="textbox_size20" style="width: 110px;" MAXLENGTH="15" id="sLName"/>
			
		
				<br />	
	 		<label	class="bodytextB1">Service Type:</label>
			<select name="<%=SERVICE_TYPE_ID %>" class="NewSelectBox" id="serviceTypeId">
			<option value="0"><--Select Ser Type--></option>						
			<% 
			for(MasServiceType masServiceType : serviceTypeList)
			{
			%>
			<option value="<%=masServiceType.getId()%>" ><%=masServiceType.getServiceTypeName()%></option>
			<%
			}
			%>
			</select>	
	
			<label	class="bodytextB1">Rank:</label>
			<select name="<%=RANK_ID %>" class="NewSelectBox" id="rankId">
			<option value="0"><--Select Rank--></option>						
			<% for(MasRank masRank : rankList)
			{
			%>
			<option value="<%=masRank.getId()%>"><%=masRank.getRankName()%></option>
			<%
			}
			%>
			</select>
								
	 		<label	class="bodytextB1">Unit:</label>
			<select name="<%=UNIT_ID%>" class="NewSelectBox" id="unitId">
				<option value="0"><--Select Unit--></option>						
				<%
				for(MasUnit masUnit : unitList)
				{
				%>
				<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
				<%
				}
				%>
			</select>
 	     <br/>
 	     --%></div>

<div class="clear"></div>
<input type="button" class="button" value="Search" align="right"
	onClick="submitForm('patientSearchForm','adt?method=searchUpdatePatientDischarge');" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">

	<thead>
		<tr>
			<%--    <td width="15" class="gridheaderlabel">Service No</td>
  --%>
			<th><%=prop.getProperty("com.jkt.hms.registration_no") %></th>
			<th>Pt. Name</th>
			<th><%=prop.getProperty("com.jkt.hms.ipd_no") %></th>
		</tr>

	</thead>
	<tbody>
		<% if (inpatientList != null && inpatientList.size() > 0) {
	for(Inpatient inpatient : inpatientList)
	{%>
		<tr id="linetblhdr" onmouseover="this.id='sel'"
			onmouseout="this.id='linetblhdr'"
			onclick="javascript:setServiceNo('<%=inpatient.getHin().getHinNo()%>');">
			<%--<td height="12"><%=inpatient.getHin().getServiceNo()%></td>
	         --%>
			<td height="12"><%=inpatient.getHin().getHinNo()%></td>
			<%
			String patientName="";
			patientName=inpatient.getHin().getPFirstName();
			if(inpatient.getHin().getPMiddleName()!=null){
				patientName+=" "+inpatient.getHin().getPMiddleName();
			}
			if(inpatient.getHin().getPLastName()!=null){
				patientName+=" "+inpatient.getHin().getPLastName();
			}
			%>
			
			<td height="12"><%=patientName%></td>
			<td height="12"><%=inpatient.getAdNo()%></td>
		</tr>
		<%}}else{%>
		<tr>
			<td height="16" colspan=6 align="center">No Data Found</td>
		</tr>
		<%} %>
	</tbody>
</table>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>