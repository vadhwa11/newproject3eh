<%@page import="java.util.*"%>
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * wardWisePatientPopupJsp
 * Purpose of the JSP -  To DIsplay The Patient Details Ward Wise.
 * @author Ramdular
 * Create Date: 05th Sept,2011
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>


<head>
<meta http-equiv="refresh" content="1000"></meta>
<meta http-equiv="refresh" content="1000;  url=/hms/hms/ipd?method=showWardWiseDetails"></meta>
</head>
<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	String deptName="";
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("deptName") != null) {
		deptName = (String)map.get("deptName");
	}
	List<Inpatient> inPatientList = new ArrayList<Inpatient>();
	if (map.get("inPatientList") != null) {
		inPatientList = (List<Inpatient>)map.get("inPatientList");
	}
	int counter=1;
	String color_code = "#6698FF";
	//Translate.setHttpReferrer("http://www.google.co.in/");
%>
<%if(inPatientList.size()>0){ %>
<center><font face="arial" size="18" color="#6698FF"><BLINK><%=inPatientList.get(0).getDepartment().getDepartmentName().toUpperCase()%></BLINK></font></center>
<div class="clear"></div><div class="clear"></div><div class="clear"></div>
<table width="100%">
	<tr>
		<th valign="top" width="5%"  bgcolor="eee9e9" align="left"><font size="6" face="arial">S_no</font></th>
		<th valign="top" width="15%"  bgcolor="eee9e9" align="left"><font size="6" face="arial">Reg_no&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></th>
		<th valign="top" width="20%" bgcolor="eee9e9" align="left"><font size="6" face="arial">Bed_no</font></th>
		<th valign="top" width="60%" bgcolor="eee9e9" align="left"><font size="6" face="arial">Patient_name</font></th>
		<th valign="top" width="20%" bgcolor="eee9e9" align="left"><font size="6" face="arial">Village</font></th>
	</tr>
</table>
<%}else{ %>
<center><font face="arial" size="18" color="RED"><BLINK>PLEASE CHECK LOGIN DEPARTMENT</BLINK></font></center>
<%} %>
<marquee scrollamount="3.5" direction="up" loop="true" width="100%" height="100%">
<table width="100%">	
	<%
		for(Inpatient inpatient:inPatientList){
			String village ="-";	
			if(inpatient.getHin().getVillage()!=null){	
				village	= inpatient.getHin().getVillage().getVillageName().toUpperCase();
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Semi Deluxe"))
			{
			 color_code ="#3BB9FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Aseptic NICU"))
			{
			 color_code ="#FF0000";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Male Medical Ward"))
			{
			 color_code ="#00FFFF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Female Medical Ward"))
			{
			 color_code ="#9AFEFF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Deluxe"))
			{
			 color_code ="#C7A317";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Male Surgical Ward"))
			{
			 color_code ="#FF0080";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Gynec Old Ward"))
			{
			 color_code ="#F9B7FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Labour Room"))
			{
			 color_code ="#FDEEF4";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Paediatric Ward"))
			{
			 color_code ="#3BB9FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Septic NICU"))
			{
			 color_code ="#82CAFA";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Orthopedic Ward"))
			{
			 color_code ="#95B9C7";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Opthalmology Ward"))
			{
			 color_code ="#5FFB17";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("ICU"))
			{
			 color_code ="#FDD017";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("PICU"))
			{
			 color_code ="#C9BE62";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Super Deluxe"))
			{
			 color_code ="#3BB9FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("T.B. Ward"))
			{
			 color_code ="#F87431";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Isolation ICU"))
			{
			 color_code ="#3BB9FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Burns Unit"))
			{
			 color_code ="#F76541";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Prisoner Ward"))
			{
			 color_code ="#F9966B";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Waiting Area"))
			{
			 color_code ="#F665AB";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Cradle New Ward"))
			{
			 color_code ="#FF0000";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Cradle Old Ward"))
			{
			 color_code ="#FAAFBA";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Observation Room"))
			{
			 color_code ="#C48793";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Gynec New Ward"))
			{
			 color_code ="#C5908E";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Female Surgical Ward"))
			{
			 color_code ="#3BB9FF";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("PEDIATRIC ICU"))
			{
			 color_code ="#FFE87C";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("OPTHALMIC WARD"))
			{
			 color_code ="#FFF8C6";
			}
			if(inpatient.getDepartment().getDepartmentName().equalsIgnoreCase("Mental Ward"))
			{
			 color_code ="#FAF8CC";
			}
		%>
	<tr>
	    <td valign="top" width="5%"  bgcolor="<%=color_code%>"><font size="6"><%=counter%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>
		<td valign="top" width="15%"  bgcolor="<%=color_code%>"><font size="6"><%=inpatient.getHinNo()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>
		<td valign="top" width="20%" bgcolor="<%=color_code%>"><font size="6"><%=inpatient.getBed().getBedNo()%>&nbsp;</font></td>
		<td valign="top" width="60%" bgcolor="<%=color_code%>"><font size="6"><%=inpatient.getHin().getPFirstName().toUpperCase()%>  <%=inpatient.getHin().getPMiddleName().toUpperCase()%>  <%=inpatient.getHin().getPLastName().toUpperCase()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>
		<td valign="top" width="20%" bgcolor="<%=color_code%>"><font size="6"><%=village%></font></td>
	</tr>
<% counter++ ;}%>
</table>
</marquee>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">