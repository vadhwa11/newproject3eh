<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * issueToDispensary.jsp
	 * Purpose of the JSP -  This is for issue to Dispensary.
	 * @author  Vivek
	 * @author  Abha
	 * Create Date: 21th Feb,2008
	 * Revision Date:
	 * Revision By:
	 * @version 1.8
	--%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.math.BigDecimal"%>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
 
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
	

<%
	Map map = new HashMap();
	String userName="";
	/* String date=""; */
	String time="";
	String deptName="";
    int userId=0;
	int pageNo=1;
	int indentId=0;
	int internalIndentId=0;
	int listSize=0;
	int issueId=0;
	String max="";
	int issueIdForBarcode=0;
// 	List<MasEmployee> employeeDeptByList = new ArrayList<MasEmployee>();
	List<Object[]> storeInternalIndentMList = new ArrayList<Object[]>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Box box=HMSUtil.getBox(request);


		
		if(map.get("storeInternalIndentPendingList")!=null){
			storeInternalIndentMList=(List<Object[]>)map.get("storeInternalIndentPendingList");
		}
		System.out.println(storeInternalIndentMList.size()+"-----"+map.get("storeInternalIndentPendingList"));
		
		String messageType ="";

%>


<%-- Start of Content Div --%>
<%-- Start of Main Form --%>

<%-- Title --%>
<h4><span id="msgId"></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Pending Indent Approval</h2>
</div>
<form name="pendingIndent" method="post">
<div class="clear" ></div>
<div class="Block" >
<label><span>*</span> From Date </label> 
<input	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 validate="fromDate,date,no"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.pendingIndent.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 validate="toDate,date,no"/> <img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.pendingIndent.<%= TO_DATE%>,true);" />
<input type="button" class="button" value="Search"	onclick="submitForm('pendingIndent','/hms/hms/stores?method=showPendingIndentApproval');"></input>
</div>
<div class="clear" ></div>


<div>
<!--<input type="button"tabindex="1" name="print" type="button" class="button" value="Print" onClick="submitForm('issueDispensaryForm','stores?method=showGrnReportJsp');">
--></div>
<%----------------------Start of show pending Indent------------------%>
<div id="update">
<% int  counter=1; int slNumber = 0;%>
<div id="pageNavPosition"></div>
<h4>Pending Indent</h4>
<div class="clear"></div>
<%if (storeInternalIndentMList != null && storeInternalIndentMList.size() > 0) {  %>
<table id="searchresulttable" width="100%" cellspacing="0"
	cellpadding="0">
	<tr>
		<th>SI No.</th>
		<th>Indent No</th>
		<th>Indent Date</th>
		<th>Type Of Indent</th>
		<th>Department</th>
		<!-- <th>Requested By</th> -->
	</tr>
	<tbody id="tableData">
		<%
			String klass = "even";

		 	//for(StoreInternalIndentM storeInternalIndentM : storeInternalIndentPendingList){
		 		for (Object[] object:storeInternalIndentMList) {
			
		 		if(counter%2==0){
		 			klass = "even";
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}

		%>

		<tr class=<%= klass%> id="<%=counter%>">
		<td><%=counter%></td>
			<td><a href="javascript:Request('<%= object[0]%>','pendingIndent')"><%= object[1]%></a></td>
			<td><%= object[2]%></td>
			<td><%= object[3]%></td>
			 <td><%= ((MasDepartment)object[4]).getDepartmentName()%></td>
			<!--<td></td> -->
			
		</tr>

		<%
		++counter;	}
		 		
		 		
		  	%>
	</tbody>
</table>
<input type="hidden" name="pageEditNo" id="pageEditNo" value="<%=pageNo %>" validate="pageEditNo,int,no"/>
<script> function Request(obj,formName){
	
	if(formName == 'pendingIndent'){
		
		obj1 = eval('document.'+formName)
		var hin = obj;
		//alert(hin);
		url = "/hms/hms/stores?method=getDetailsPendingIndentApproval&id="+hin;
	   	obj1 .action = url;
		obj1 .submit(); 
	}
}
			var pager = new Pager('tableData',5);
			pager.init();
			pager.showPageNav('pager', 'pageNavPosition');
			pager.showPage(1);
		  </script>
<div class="clear"></div>
<%
		 }
		else{
		%>
<h4><span>No Record Exists</span></h4>
<div class="clear"></div>
<%}%>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<%----------------------End of show pending Indent---------------------%>
	