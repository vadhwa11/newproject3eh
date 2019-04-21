<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * storeBalance.jsp
 * Purpose of the JSP -  This is for indentBD.
 * @author  Mansi
 * Create Date: 21st Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%--For AutoComplete Through Ajax--%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.StoreBalanceT"%><script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

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
	StringBuffer orderDateOnly = new StringBuffer();
	GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

	int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
	if (dateOfMonth < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(dateOfMonth);
	} else {
		orderDateOnly.append(dateOfMonth);
	}
	orderDateOnly.append("/");
	int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (month < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(month);
	} else {
		orderDateOnly.append(month);
	}
	orderDateOnly.append("/");
	int year = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year);
	String currentDate = new String(orderDateOnly);
%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int pageNo=1;
	List<StoreBalanceT> storeBalanceTList = new ArrayList<StoreBalanceT>();
	List<MasEmployee>approvedByEmployeeList = new ArrayList<MasEmployee>();
	String maxBalanceNo="";
	//--------Hearder Variables-------
	
	//--------End -------- Hearder Variables-------
	if (request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
	
	if(map.get("storeBalanceTList") != null){
		storeBalanceTList = (ArrayList) map.get("storeBalanceTList");
	}
	System.out.println("storeBalanceTList==="+storeBalanceTList.size());
	if(map.get("approvedByEmployeeList") != null){
		approvedByEmployeeList = (ArrayList) map.get("approvedByEmployeeList");
	}
	String balanceNo = "";
	Date balanceDate = new Date();
	int approvedById = 0;
	int balanceId=0;
	String remarks = "";
	if(storeBalanceTList.size()>0){ 
		for(StoreBalanceT storeBalanceT : storeBalanceTList){
			StoreBalanceM storeBalanceMObj = storeBalanceT.getStoreBalanceM();
			if(storeBalanceMObj.getBalanceNo() != null){
			balanceNo = storeBalanceMObj.getBalanceNo();
			}
			if(storeBalanceMObj.getBalanceDate() != null){
				balanceDate = storeBalanceMObj.getBalanceDate();
			}
			if(storeBalanceMObj.getApprovedBy() != null && !storeBalanceMObj.getApprovedBy().getId().equals("")){
				approvedById = storeBalanceMObj.getApprovedBy().getId();
			}
			if(storeBalanceMObj.getRemarks() != null){
				remarks = storeBalanceMObj.getRemarks();
			}
			balanceId = storeBalanceMObj.getId();
		}
	}	
%>

<form name="openingBalanceEntryApproval" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<input type="hidden" name="pageNo"	value="<%=pageNo%>" id="pageNo" validate="pageNo,int,no"/>
<input type="hidden" size="2"	value="0" name="<%=NO_OF_ROWS%>" id="<%=NO_OF_ROWS%>" validate="NoOfRows,int,no"/>
<input	type="hidden" name="<%=BALANCE_ID %>" value="<%=balanceId%>" id="balanceId" />

<label> Balance Entry No.<span>*</span> </label>
<input	type="text" name="<%=BALANCE_NO %>" value="<%=balanceNo%>"	  readonly="readonly" MAXLENGTH="8"   tabindex=1 />
<input	type="hidden" name="storeBalanceMId" value="<%=balanceId%>"	 readonly="readonly" MAXLENGTH="8"  tabindex=1 />
<label>Balance Entry Date<span>*</span></label>
<input type="text"	name="<%=BALANCE_DATE%>" readonly="readonly"	value="<%=HMSUtil.convertDateToStringWithoutTime(balanceDate) %>" MAXLENGTH="30" tabindex=1 validate="balanceDate,date,no"/>
<%--
<label><span>*</span> Approved By</label>
<select	name="<%=APPROVED_BY_EMPLOYEE_ID_BALANCE%>"	validate="Approved By,String,yes" id="approvedBy" tabindex=1 >
	<option value="0">Select</option>
	<%
				for (MasEmployee approvedBy :approvedByEmployeeList ) {
			%>
	<option value=<%=approvedBy.getId()%>><%=approvedBy.getFirstName()%>
	<%=approvedBy.getLastName()%></option>
	<%
	}
			%>
</select>
--%>

<script type="text/javascript">
<%
				if(approvedById != 0){
			%>
			document.getElementById('approvedBy').value = '<%=approvedById%>';
			<%}%>
			</script>
<div class="clear"></div>
<label>Remarks</label>
<input type="text" name="<%=REMARKS %>" class="large"	value="<%=remarks!= null?remarks:"" %>" tabindex=1 maxlength="30" style="width:550px;"/> 
<div class="clear"></div>
</div>
<%-- <div id="pagination">Page No. >> <span><%=pageNo%></span></div>--%>
<div class="clear"></div>
<h4>Opening Balance details</h4>
<div class="clear"></div>
<div class="cmntable">
<table colspan="7" id="indentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th><input type="checkbox" name="itemApproval" id="srNoId1" onchange="toggle1()"></th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!--  <td width="10%"><label valign="left" class="smalllabel">Brand Name</label>      </td>-->
		<%-- 	<th>Manufacturer</th>--%>
			<th>Batch No./Serial No.</th>
			<th>DOM/DOS</th>
			<th>DOE/DWE</th>
			<th>Qty</th>
			<th>Unit Rate</th>
			<th>Amount</th>
			<%-- <th>Mrp</th>
			<th>Dispensing Price</th>--%>
 		</tr>
</thead>
<tbody>
 		<%
 		int inc = 1;
 	
 		if(storeBalanceTList.size()>0){
 		 for(StoreBalanceT storeBalanceT :storeBalanceTList){
 		
 		
 		%>
		<tr>
		<td><input type="checkbox" class="radioCheck" id="srNoId<%=inc %>" name="itemApproval" value="y"/></td>
		<td><%=storeBalanceT.getItem()!= null?storeBalanceT.getItem().getPvmsNo():""%>
		<input type="hidden" name="storeBalanceTId" id="storeBalanceTId<%=inc %>" value="<%=storeBalanceT.getId() %>"/></td>
		<td><%=storeBalanceT.getItem()!= null?storeBalanceT.getItem().getNomenclature():""%></td>
		<td><%=storeBalanceT.getItem()!= null && storeBalanceT.getItem().getItemConversion() != null?storeBalanceT.getItem().getItemConversion().getItemUnitName():""%></td>
	<%-- 	<td></td>--%>
		<td><%=storeBalanceT.getBatchNo()!= null?storeBalanceT.getBatchNo():"" %></td>
		<td><%=storeBalanceT.getManufactureDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeBalanceT.getManufactureDate()):"" %></td>
		<td><%=storeBalanceT.getExpiryDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeBalanceT.getExpiryDate()):"" %></td>
		<td><input type="text" name="qty" id="qty<%=inc%>" value="<%=storeBalanceT.getQty()!= null?storeBalanceT.getQty().intValue():"" %>" size="5" onblur="calculateAmountValue(<%=inc%>);" /></td>
		<td><input type="hidden" name="unitRate" id="unitRate<%=inc%>" value="<%=storeBalanceT.getUnitRate()!= null?storeBalanceT.getUnitRate().intValue():"" %>" size="10" /><%=storeBalanceT.getUnitRate()!= null?storeBalanceT.getUnitRate().intValue():"" %></td>
		<td><input type="text" name="amount" id="amount<%=inc%>" value="<%=storeBalanceT.getAmount()!= null?storeBalanceT.getAmount().intValue():"" %>" size="10" /></td>
			
 		</tr>
	<%inc++;}} %>
 	</tbody>
</table>
</div>
<input  type="hidden" name="count" id="hdb" value="<%=inc %>"/>
<div class="clear"></div>
<%-- <label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	
</select>--%>
<div class="clear"></div>
<div class="paddingTop5"></div>

<label>Remarks</label>
<textarea name="approvalRemarks" class="large" cols="0" rows="0"  maxlength="198" tabindex="1" validate="remarks,remarks,no" ></textarea>


<div class="clear"></div>

<div class="clear"></div>
 <input type="button" class="button" value="Approve" onclick="submitForm('openingBalanceEntryApproval','stores?method=submitOpeningBalanceEntryApproval&flag=Approved','validateRows')"	align="right" />
 <input type="button" class="button" value="Reject" onclick="submitForm('openingBalanceEntryApproval','stores?method=submitOpeningBalanceEntryApproval&flag=Reject')"	align="right" />
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></form>
<script type="text/javascript">

function toggle1() {
	 checkboxes = document.getElementsByName('itemApproval');
	if(document.getElementById('srNoId1').checked)
		{
	  for(var i=0, n=checkboxes.length;i<n;i++) {
	    checkboxes[i].checked = true;
	  }
		}
	else
		{
		 for(var i=0, n=checkboxes.length;i<n;i++) {
			    checkboxes[i].checked = false;
			  }
		}
	}
 		function checkForFilledRows(){
		 var count = document.getElementById('noOfRows').value;

			if(count<= 0){
				alert("Please fill at least one row to submit.");
				return false;
			}
			return true;
		}
 		
 		
 		function jsImportForPVMS()
 		{
 			var fname =document.getElementById('uploadFilename').value;
 			if (document.departmentInd.<%=UPLOAD_FILENAME%>.value=="")
 			{
 			alert('Pl. Select the Excel file to Import!.....');
 			return;
 			}
 			var fname = document.departmentInd.<%=UPLOAD_FILENAME%>.value;
 			var st = fname.length;
 			st = st-3;
 			if (fname.substring(st)!="xls")
 			{
 			alert('Only Excel files are Allowed.');
 			return;
 			}
 			//var deptId= document.getElementById('departmentId').value;
 			document.departmentInd.encoding="multipart/form-data";
 				//alert(document.departmentIndentGrid.encoding);
 			var ind = fname.lastIndexOf("\\");
 			var filename = fname.substring(ind+1);
 			//document.departmentIndentGrid.method="post";
 			submitForm('departmentInd','stores?method=importPVMSOpeningBalance&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue,'checkDepartment');
 		} 	
 		
 		function validateRows(){
 			var count = document.getElementById('hdb').value;
 			
 			for(var i=1;i<count;i++){
 				if(document.getElementById('srNoId'+i).checked){
 					return true;
 				}

 			}
 			alert("Please select at least one row.");
 			return false;
 		}
 		
</script>


