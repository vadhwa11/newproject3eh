<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ADT_Bed_Selection.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 04.03.2009    Name: Othivadivel K R   
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 * @see 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.masters.business.MasBed"%><head>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"
	id="vbulletin_css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<SCRIPT LANGUAGE="JavaScript">
function setBedId(bedId,bedNo) {
	window.opener.document.getElementById('<%=BED_ID%>').value=bedId;
	window.opener.document.getElementById('<%=TO_BED%>').value=bedNo;
	window.close();
}

	/* function setBedId(bedId,bedNo) {
		opener.jsSetBedId(bedId);
		window.opener.document.getElementById("bedNo").value=bedNo;
		if(window.opener.document.getElementById("bedNoTemp"))
			window.opener.document.getElementById("bedNoTemp").value=bedNo;
		if(window.opener.document.getElementById("roomTypeId"))
			window.opener.document.getElementById("roomTypeId").value=document.getElementById("roomTypeId").value;
		self.close();
	} */
	   
 

</SCRIPT>

<title>Bed Status</title>

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

</head>
<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	List<MasBed> masBedList = new ArrayList<MasBed>();
	MasBed masBed= new MasBed();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("masBedList")!=null)
			masBedList = (List)map.get("masBedList");
	}
	
%>



<div id="mainIn">
<!-- <form name="BedForm" action=""> -->
<div class="tableAuto">
<table border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th>Available Bed Nos</th>
		<th>Status</th>
	</tr>


	<%
String icdNameString ="";
if (masBedList != null && masBedList.size() > 0) { %>

	<% for(int i=0;i<masBedList.size();i++)
	{
		masBed = (MasBed)masBedList.get(i);
	%>
	<tr>
		<td><input type="hidden" id="roomTypeId"
			name="<%=ROOM_TYPE_ID %>"
			value="<%=masBed.getRoom().getRoomType().getId() %>" /> <input
			type="submit" name="Submit11" id="linetblhdr" tabindex="1"
			value="<%=masBed.getBedNo()%>"
			onselect="javascript:setBedId('<%=masBed.getId()%>','<%=masBed.getBedNo()%>');"
			onclick="javascript:setBedId('<%=masBed.getId()%>','<%=masBed.getBedNo()%>');" /></td>
		<td><%=masBed.getBedStatus().getBedStatusName()%></td>
	</tr>
	<%
	}
	%>
	<% } 
	else
	{
	%>
	<tr>
		<td>No Data Found</td>
	</tr>
	<% } %>
</table>
</div>
<!-- </form> -->
</div>
<%masBedList.clear();
%>