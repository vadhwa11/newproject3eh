<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * departmentIndentjsp
 * Purpose of the JSP -  This is for Department Indent.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 08th Feb, 2008
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.EmpScMapping"%>
<%@page import="jkt.hms.masters.business.ItemGroup"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	List<StoreInternalIndentM> indentTrackingList = new ArrayList<StoreInternalIndentM>();
	List<EmpScMapping> employeeList = new ArrayList<EmpScMapping>();
	//List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<Object[]> iList = new ArrayList<Object[]>();
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	 	if(map.get("message") != null)
	 	{
			String message = (String)map.get("message");
		   	out.println("<h4>"+message+"</h4>");
		}	 
	}
	
	if(map.get("indentTrackingList")!=null){
		indentTrackingList = (List) map.get("indentTrackingList");
	}
	System.out.println("employeeListinjsp=="+map.get("employeeList"));
	if(map.get("employeeList")!=null){
		employeeList = (List) map.get("employeeList");
	}
	if(map.get("iList")!=null){
		iList = (List) map.get("iList");
	}
	
%>


<form name="search" method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="titleBg">
		<h2>Tracking of Indent</h2>
	</div>

	<div class="Block">
		<label>Indent No.</label>
		<select name="indentNo" id="iNo"  >
			<option value="">Select</option>
<%
			for(int i=0; i<iList.size(); i++)
			{
%>
				<option value="<%=iList.get(i) %>"><%=iList.get(i) %></option>
<%
			}
%>	
		</select>

		<label>From Date</label>
		<input type="text" name="fromDate" tabindex="1" id="fromDate" value="<%=date %>" onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromDate');" maxlength="10" validate="fromDate,date,no" class="date" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('<%=date %>',document.getElementById('fromDate'),event)"  />
		
		<label>To Date</label>
		<input type="text"  name="toDate" tabindex="1" id="toDate" value="<%=date %>" validate="toDate,date,no" class="date" onkeyup="mask(this.value,this,'2,5','/');"      onblur="validateExpDate(this,'toDate');" maxlength="10"/>
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('<%=date %>',document.getElementById('toDate'),event)"  />
		
		<div class="clear"></div>
		
		<label>Item Code</label>
		<input type="text" name="pvmsNo" tabindex="1" id="pvmsNo" maxlength=25  />
		<div id="autoUpdatep"  style="display: none;" class="autocomplete"></div>
		<script type="text/javascript">
		new Ajax.Autocompleter('pvmsNo','autoUpdatep','stores?method=getItemForAutoComplete',{parameters:'pvmsNo='+this.value});
		</script>
		
		<label>Item name</label>
		<input type="text" name="nomenclature" tabindex="1" id="nomenclature" maxlength=250  />
		<div id="autoUpdate"  style="display: none;" class="autocomplete"></div>
		<script type="text/javascript">
		new Ajax.Autocompleter('nomenclature','autoUpdate','stores?method=getItemForAutoComplete',{parameters:'nomenclature='+this.value});
		</script>
		
		<div class="clear"></div>
	

	<input type="button" class="button" tabindex="1" value="Search" onclick="submitForm('search','stores?method=searchIndentTrackingList');" />

</div>
</form>
<form name="indentTracking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Details</h4>
<div id="pageNavPosition"></div>
	<table class="cmntable">
		<tr>
			<th>Indent No.</th>
			<th>Indent Date</th>
			<th>Indent To</th>
			<th>Indent From</th>
			<th>Status</th>
			<th>Responsible Person</th>
			<th>PEN</th>
			<th>Remarks</th>
		</tr>
		<tbody id="tableData"><%
		int count = 0;
			if(indentTrackingList.size()>0)
			{
				Iterator<StoreInternalIndentM> iterate = indentTrackingList.iterator();
				
				while(iterate.hasNext())
				{
					StoreInternalIndentM storeInternalIndentM = iterate.next();
%>
					<tr onclick="submitProtoAjaxWithDivName('indentTracking','stores?method=displayIndentTrackingList&indentId=<%=storeInternalIndentM.getId() %>','indentTrackingDetails');">
						<td><%=storeInternalIndentM.getDemandNo()!= null?storeInternalIndentM.getDemandNo():"" %></td>
						<td><%=storeInternalIndentM.getDemandDate() != null?HMSUtil.convertDateToStringWithoutTime(storeInternalIndentM.getDemandDate()):"" %>
						<input type="hidden" name="storeInternalIndentMId" id="storeInternalIndentMId<%=count %>" value="<%=storeInternalIndentM.getId()%>"/></td>
						<td><%=storeInternalIndentM.getToStore() != null?storeInternalIndentM.getToStore().getDepartmentName():"" %></td>
						<td><%=storeInternalIndentM.getDepartment() != null?storeInternalIndentM.getDepartment().getDepartmentName():"" %></td>
						
						
						
						<%if(storeInternalIndentM.getStatus().trim().equalsIgnoreCase("Intra Indent Waiting")){ %>
						<td>Indent Waiting</td>
						<%}else if(storeInternalIndentM.getStatus().trim().equalsIgnoreCase("intra indent reject")){ %>
							<td>Indent Reject</td>
							<%}else if(storeInternalIndentM.getStatus().trim().equalsIgnoreCase("intra indent approved")){ %>
							<td>Indent Approved</td>
							<%}else if(storeInternalIndentM.getStatus().trim().equalsIgnoreCase("issue")){ %>
							<td>Indent Issue</td>
						<%} %>
						
						<td>
						
						
			<%-- 			<Select name="pen" id="pen<%=count %>"  onchange="getEmployeeName(this.value,<%=count%>);">
						<option value="">Select</option>
						<%if(employeeList.size()>0){
							for(EmpScMapping masEmployee :employeeList){
								if(storeInternalIndentM.getPeNo() != null && !storeInternalIndentM.getPeNo().equals("")){
								if(storeInternalIndentM.getPeNo().equals(masEmployee.getEmployee().getPEN())){
							%>
							<option value="<%=masEmployee.getEmployee().getPEN()%>"selected="selected"><%=masEmployee.getEmployee().getPEN()%></option>
							<%}}else{ %>
								<%if(masEmployee.getEmployee().getPEN()!=null){%>
								<option value="<%=masEmployee.getEmployee().getPEN()%>"><%=masEmployee.getEmployee().getPEN()%></option>
							<%}}}} %>
						</Select></td>
						<td> --%>
						
						
						<Select name="employeeId" id="employeeId<%=count %>"  onchange="getEmployeeName(this.value,<%=count%>);">
						<option value="">Select</option>
						<%if(employeeList.size()>0){
							for(EmpScMapping masEmployee :employeeList){
								if(storeInternalIndentM.getResponsiblePerson() != null && !storeInternalIndentM.getResponsiblePerson().equals("")){
								if(storeInternalIndentM.getResponsiblePerson().getId().equals(masEmployee.getEmployee().getId())){
							%>
							<option value="<%=storeInternalIndentM.getResponsiblePerson().getId()%>"selected="selected"><%=storeInternalIndentM.getResponsiblePerson().getEmployeeName()%></option>
							<%}}else{ %>
								<%if(masEmployee.getEmployee().getId()!=null){%>
								<option value="<%=masEmployee.getEmployee().getId()%>"><%=masEmployee.getEmployee().getEmployeeName()%></option>
							<%}}}} %>
						</Select></td>
								
						<%if(storeInternalIndentM.getPeNo() != null){ %>
						<td><input type="text" name="pen" value="<%=storeInternalIndentM.getPeNo()%>"  id="pen<%=count%>" />
						</td>
						<%}else{ %>
						<td><input type="text" name="pen" value=""  id="pen<%=count%>" />
						</td>
						<%} %>
						
						
				<%-- 		<%if(storeInternalIndentM.getResponsiblePerson() != null){ %>
						<td><input type="text" name="employeeName" value="<%=storeInternalIndentM.getResponsiblePerson().getEmployeeName()%>"  id="employeeName<%=count%>" validate="employeeName,metachar,no"/>
						<input type="hidden" name="employeeId" value="<%=storeInternalIndentM.getResponsiblePerson().getId() %>"  id="employeeId<%=count%>" validate="employeeId,int,no"/></td>
						<%}else{ %>
						<td><input type="text" name="employeeName" value=""  id="employeeName<%=count%>" validate="employeeName,metachar,no"/>
						<input type="hidden" name="employeeId" value=""  id="employeeId<%=count%>" validate="employeeId,int,no"/></td>
						<%} %> --%>
						
						<td><%=storeInternalIndentM.getRemarks()!= null?storeInternalIndentM.getRemarks():"" %></td>
						
							
					</tr><%
					count++;
				}
			}
			else
			{
				%><tr><td colspan=3><label id="NoData" class="labelError">No Data Found</label></td></tr><%
			}
		%></tbody>
	</table>
	
	
<input type="button" name="Submit" type="submit" value="Submit"	onClick="submitForm('indentTracking','stores?method=submitIndentTracking');" class="button" />
	
	
	
<%
	if(map.get("search") != null)
	{
%>
		<a href="stores?method=showIndentTrackerJsp">Show All Records</a>
<%
	}
%>


<div class="paddingTop40"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="indentTrackingDetails"></div>
<div class="clear"></div>



</form>
<script type="text/javascript">
var pager = new Pager('tableData',5);
pager.init();
pager.showPageNav('pager', 'pageNavPosition');
pager.showPage(1);

/* 
function getEmployeeName(peNo,rowVal){


	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];

		        var employeeId  = item.getElementsByTagName("employeeId")[0];
		        var employeeName  = item.getElementsByTagName("employeeName")[0];

		      
	        	document.getElementById('employeeId'+rowVal).value = employeeId.childNodes[0].nodeValue
	        	document.getElementById('employeeName'+rowVal).value = employeeName.childNodes[0].nodeValue
	        	
	      	}
	      }
	    }
	     url="stores?method=getEmployeeName&peNo="+peNo;
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	 }
	  */
	 <!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	
	
	
	
function getEmployeeName(empId,rowVal){


	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];

 				var pen  = item.getElementsByTagName("pen")[0];
	      			document.getElementById('pen'+rowVal).value = pen.childNodes[0].nodeValue;
	      	}
	      }
	    }
	     url="stores?method=getEmployeeName&empId="+empId;
 	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	 }
</script>


