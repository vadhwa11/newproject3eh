<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : orderStatusForWardManagment.jsp 
	 * Tables Used         : 
	 * Description         : For Viewing All Order No For IPD .
	 * @author Name        : Naresh Kumar
	 * Revision Date	   : Revision By: 
	 * @version 1.0  
--%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<DgOrderhd> diagList = new ArrayList<DgOrderhd>();
		if (request.getAttribute("map") != null) {
			map = (Map<String,Object>) request.getAttribute("map");
		}

		if (map.get("diagList") != null){
			diagList =(List)map.get("diagList");
		}
		String opOrString = "";
		if(map.get("opOrString") != null){
			opOrString = (String)map.get("opOrString");
		}
	%>

<div class="clear"></div>

<div class="clear"></div>
<h4>Diagnostics Details</h4>
<div class="clear"></div>
<%
		if (diagList != null && diagList.size() > 0)
		{ 
		%>

<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Order No.</th>
		<th scope="col">Order Date</th>
		<th scope="col">Order Time</th>
		<%
		if(opOrString.equals("0")){
	%>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.ipd_no") %>:</th>
		<%}else{ %>
		<th scope="col"><%=prop.getProperty("com.jkt.hms.opd_num") %>:</th>
		<%} %>
		<th scope="col">Doctor Name</th>
	</tr>
	<tbody id="tableData">
		<%
			for(DgOrderhd dgOrderhd: diagList){
	%>
		<tr style="cursor: pointer;"
			onclick="submitProtoAjaxWithDivName('patientAndAdDetails','/hms/hms/lab?method=viewAllTestForOrderNo&dgOrderHdId=<%=dgOrderhd.getId() %>','chargeDiv');">
			<td><%=dgOrderhd.getOrderNo() %></td>
			<td><%=HMSUtil.convertDateToStringWithoutTime(dgOrderhd.getOrderDate()) %></td>
			<td><%=dgOrderhd.getOrderTime() %></td>
			<%
		if(dgOrderhd.getInpatient() != null){
	%>
			<td><%=dgOrderhd.getInpatient().getAdNo() %></td>
			<%}else{ %>
			<td><%=dgOrderhd.getVisit().getVisitNo() %></td>
			<%} %>
			<td><%=dgOrderhd.getPrescribedBy().getFirstName()+" "+dgOrderhd.getPrescribedBy().getMiddleName()+" "+dgOrderhd.getPrescribedBy().getLastName() %></td>
		</tr>
		<%} %>
	</tbody>
</table>

<div id="chargeDiv"></div>
<%}else{ %>
<h6>No Diagnostics Records Found!</h6>
<%}%>