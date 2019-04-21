<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Vishal
 * Create Date: 07th April,2009
 * Revision Date:
 * Revision By:
 * @version 1.15
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.EmployeeTeleDirec"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<Object[]>employeeTeleDirec=new ArrayList<Object[]>();
	//
	if(map.get("alist")!=null){
	employeeTeleDirec = (List<Object[]>)map.get("alist");
	}
	ArrayList searchCountryList = (ArrayList)map.get("searchCountryList");
	ArrayList gridCurrencyList = (ArrayList)map.get("gridCurrencyList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   String a="";
		   
		   %>
		   <h4><span><%=message %></span></h4>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<table style="
	width: 976px;
	border: 1px solid #036D92;
	border-right: 1px solid #036D92;
	text-align: center;
	overflow: auto;
	border-spacing: 0px;
	margin: 0px auto;">
<tr>
<th style="
	width: auto;
	height: 20px;
	font: bold 11px/ 18px Tahoma;
	color: #FFFFFF;
	background: #036D92;
	border-right: 1px solid #C0C0C0;
	border-bottom: 1px solid #C0C0C0;
	text-align:center;
	padding-left: 5px;">Name</th>
<th style="
	width: auto;
	height: 20px;
	font: bold 11px/ 18px Tahoma;
	color: #FFFFFF;
	background: #036D92;
	border-right: 1px solid #C0C0C0;
	border-bottom: 1px solid #C0C0C0;
	text-align:center;
	padding-left: 5px;">Address</th>
<th style="	width: auto;height: 20px;font: bold 11px/ 18px Tahoma;color: #FFFFFF;background: #036D92;border-right: 1px solid #C0C0C0;border-bottom: 1px solid #C0C0C0;text-align:center;padding-left: 5px;">Phone No.</th>
</tr>
<%for(Object[] etd:employeeTeleDirec){ %>
<tr>
<td style="
	width: auto;
	height: auto;
	font: normal 11px Tahoma;
	color: #000;
	border-right: 1px solid #C0C0C0;
	Border-Bottom: 1px solid #C0C0C0;
	text-align: left;
	line-height: normal;
	padding: 3px 0px 3px 0px;
	float: none;
	margin: 5px auto;"><%=(""+" "+etd[1]).toUpperCase() %></td>
<%if((""+etd[3].toString()).equals("")){ %>
<td style="
	width: auto;
	height: auto;
	font: normal 11px Tahoma;
	color: #000;
	border-right: 1px solid #C0C0C0;
	Border-Bottom: 1px solid #C0C0C0;
text-align: left;
	line-height: normal;
	padding: 3px 0px 3px 0px;
	float: none;
	margin: 5px auto;">-</td>

<%}else{ %>
<td style="
	width: auto;
	height: auto;
	font: normal 11px Tahoma;
	color: #000;
	border-right: 1px solid #C0C0C0;
	Border-Bottom: 1px solid #C0C0C0;
text-align: left;
	line-height: normal;
	padding: 3px 0px 3px 0px;
	float: none;
	margin: 5px auto;"><%=" "+etd[3] %></td>
	<%} %>
	<%if((""+etd[2].toString()).equals("")){ %>
<td style="
	width: auto;
	height: auto;
	font: normal 11px Tahoma;
	color: #000;
	border-right: 1px solid #C0C0C0;
	Border-Bottom: 1px solid #C0C0C0;
text-align: left;
	line-height: normal;
	padding: 3px 0px 3px 0px;
	float: none;
	margin: 5px auto;">-</td>

<%}else{ %><td style="
	width: auto;
	height: auto;
	font: normal 11px Tahoma;
	color: #000;
	border-right: 1px solid #C0C0C0;
	Border-Bottom: 1px solid #C0C0C0;
text-align: left;
	line-height: normal;
	padding: 3px 0px 3px 0px;
	float: none;
	margin: 5px auto;"><%="&nbsp;"+" "+etd[2] %></td>
	<%}	%>
</tr>
<%} %>


</table>