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
<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryT"%>
<%@page import="jkt.hms.masters.business.StoreBroadcastEnquiryM"%>
<%@page import="jkt.hms.masters.business.MasHospital"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
	List<StoreBroadcastEnquiryT> storeBroadcastEnquiryTList = new ArrayList<StoreBroadcastEnquiryT>();
	List<MasHospital> instituteList = new ArrayList<MasHospital>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	if(map.get("storeBroadcastEnquiryTList") != null){
		storeBroadcastEnquiryTList = (List)map.get("storeBroadcastEnquiryTList");
	}
	if(map.get("instituteList") != null){
		instituteList = (List)map.get("instituteList");
	}
	String broadCastNo = "";
	String broadCastType = "";
	Date broadCastDate = new Date();
	int instituteId = 0;
	if(storeBroadcastEnquiryTList.size()>0){
		for(StoreBroadcastEnquiryT storeBroadcastEnquiryT :storeBroadcastEnquiryTList){
			StoreBroadcastEnquiryM storeBroadcastEnquiryM = storeBroadcastEnquiryT.getEnquiryM();
			if(storeBroadcastEnquiryM.getBroadcastNo() != null){
				broadCastNo = (String)storeBroadcastEnquiryM.getBroadcastNo();
			}
			if(storeBroadcastEnquiryM.getBroadcastType() != null){
				broadCastType = (String)storeBroadcastEnquiryM.getBroadcastType();
			}
			if(storeBroadcastEnquiryM.getBroadcastDate() != null){
				broadCastDate = (Date)storeBroadcastEnquiryM.getBroadcastDate();
			}
			if(storeBroadcastEnquiryM.getInstitute() != null){
				instituteId = (Integer)storeBroadcastEnquiryM.getInstitute().getId();
			}
	}
	}
 
%>
<form name="enquiryBroadCastAcknowledgement" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Enquiry BroadCast Acknowledgement</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>
<div class="Block">
<label>Broad Cast No.</label>
 <input type="text" name="broadCastNo" value="<%=broadCastNo %>" readonly="readonly" MAXLENGTH="8"  validate="broadCastNo,metachar,no"/> 
	
	<label>BroadCast Date</label>
	 <input type="text" name="broadCastDate" value="<%=HMSUtil.convertDateToStringWithoutTime(broadCastDate) %>" readonly="readonly" class="date"  validate="broadCastDate,date,no"/>
	 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.departmentIndent.<%= DEMAND_DATE%>,event)" />
	 


<label>BroadCast Type </label>
<input type="text" name="typeOfIndent" value="<%=broadCastType %>" validate="typeOfIndent,metachar,no"/>

			

<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>
 <label>Institute </label>
  <select name="instituteId" validate="Institute,metachar,no">
	<option value="0">Select</option>
	<%if(instituteList.size()>0){
		for(MasHospital masHospital:instituteList){
			if(masHospital.getId().equals(instituteId)){
		%>
		<option value="<%=masHospital.getId()%>" selected="selected"><%=masHospital.getHospitalName()%></option>
		<%}else{ %>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
		
	<%}}}%>
</select>


<div class="clear"></div>
</div>
<div class="clear"></div>


<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Item Details</h4>
<div class="clear"></div>

  <div class="clear"></div>
<table border="0" cellpadding="0" cellspacing="0">

					<tr>

						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						 <th>Available Stock</th>
						<th>Demanded Qty</th>
						<th>Available Stock For Dispatch</th>
						<th>Remarks</th>
					</tr>
					<%
						if(storeBroadcastEnquiryTList.size()>0){
							for(StoreBroadcastEnquiryT storeBroadcastEnquiryT :storeBroadcastEnquiryTList){
						
					
					
					
					%>
					<tr>
							
						<td><input type="text" size="8" value="<%=storeBroadcastEnquiryT.getItem()!= null?storeBroadcastEnquiryT.getItem().getPvmsNo():"" %>" name="pvms"  readonly="readonly" validate="pvms,metachar,no"/></td>
							
							
						<td><input type="text" value="<%=storeBroadcastEnquiryT.getItem()!= null?storeBroadcastEnquiryT.getItem().getNomenclature():""%>" name="nomenclature"  readonly="readonly"  validate="nomenclature,metachar,no"/></td>
						<td><input type="text" size="8" value="<%=storeBroadcastEnquiryT.getItem() != null && storeBroadcastEnquiryT.getItem().getItemConversion() != null?storeBroadcastEnquiryT.getItem().getItemConversion().getItemUnitName():"" %>" name="au"  readonly="readonly" validate="au,metachar,no"/></td>
						<td><input type="text" size="8" value="<%=storeBroadcastEnquiryT.getStock()!= null?storeBroadcastEnquiryT.getStock():"" %>" name="stock" validate="Stock In Hand,float,no"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeBroadcastEnquiryT.getDemandedQty()!= null?storeBroadcastEnquiryT.getDemandedQty():"" %>" name="demandedQty" validate="Demanded Qty,float,no" /></td>
						<td><input type="text" size="8" value="" name="availableStockForDispatch" validate="availableStockForDispatch,float,no" /></td>
							<td><input type="text" size="8" value="" name="remarks" validate="Remarks,metachar,no" /></td>
						
						
					</tr>
					
			<%}} %>
</table>
 
<div class="clear"></div>


<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('enquiryBroadCastAcknowledgement','stores?method=submitEnquiryBroadCastAcknowledgement');" class="button" />
<input	type="button" name="Submit" type="submit" value="Reset" 	class="button" />

<script type="text/javascript">

function openPopupWindow()
{
 var url="/hms/hms/stores?method=showInstituteDataJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


