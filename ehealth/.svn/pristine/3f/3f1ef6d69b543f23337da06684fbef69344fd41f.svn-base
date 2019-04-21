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
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
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
	List<FaVoucherHeader> faVoucherHeaderList = new ArrayList<FaVoucherHeader>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	
	if(map.get("faVoucherHeaderList")!=null){
		faVoucherHeaderList =(List) map.get("faVoucherHeaderList");
		
	}
	
System.out.println("faVoucherHeaderList.size()---jsp->>"+faVoucherHeaderList.size());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	
	%>



<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</div>
<form name="voucherApproval" method="post">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"voucherNo"], [2,"voucherDate"], [3,"voucherType"], [4,"DrAmount"], [5,"CrAmount"]];
	 statusTd =5;
	</script>
<div class="clear"></div>

<div class="clear"></div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "voucher No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "voucherNo"

	data_header[1] = new Array;
	data_header[1][0] = "voucher Date"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "voucherDate";

	data_header[2] = new Array;
	data_header[2][0] = "voucher Type"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "voucherType";

	data_header[3] = new Array;
	data_header[3][0] = "Dr Amount"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "DrAmount"

	data_header[4] = new Array;
	data_header[4][0] = "Cr Amount"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "CrAmount";


	data_arr = new Array();
	<%

	    int  counter=0;
	
		if (faVoucherHeaderList != null && faVoucherHeaderList.size() > 0) { %>

	<% 	for(FaVoucherHeader faVoucherHeader : faVoucherHeaderList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= faVoucherHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=faVoucherHeader.getVoucherNo()%>"
			data_arr[<%= counter%>][2] = "<%=faVoucherHeader.getVoucherDate()%>"
				
			data_arr[<%= counter%>][3] = "<%=faVoucherHeader.getVoucherType()%> "
			<%
				if(faVoucherHeader.getDrAmount() != null && !faVoucherHeader.getDrAmount().equals(new BigDecimal(0))){
					
			%>
			data_arr[<%= counter%>][4] = "<%=faVoucherHeader.getDrAmount()%>";
			<%}else {%>
			data_arr[<%= counter%>][4] = "";
			<%}%>
			<%
				if(faVoucherHeader.getCrAmount() != null && !faVoucherHeader.getCrAmount().equals(new BigDecimal(0))){
			%>
			data_arr[<%= counter%>][5] = "<%=faVoucherHeader.getCrAmount()%>"
			<%}else {%>
			data_arr[<%= counter%>][5] = "";
			<%}%>
			
		<%

				counter++;
		    	}
			}
		%>

    formName = "voucherApproval"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);

	</script>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>