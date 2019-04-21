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

<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%@page import="jkt.hms.masters.business.MasDistrict"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasHospital>instituteList = new ArrayList<MasHospital>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List<StoreInternalIndentT>)map.get("storeInternalIndentTList");
	}int deptId = 0;

	if (session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(session.getAttribute("deptId").toString());
	}
	
	if(map.get("departmentList") != null){
		departmentList = (ArrayList) map.get("departmentList");
	}
	if(map.get("instituteList") != null){
		instituteList = (ArrayList) map.get("instituteList");
	}
	
	if(map.get("districtList") != null){
		districtList = (List<MasDistrict>)map.get("districtList");
	}
	
	if(map.get("storeInternalIndentTList") != null){
		storeInternalIndentTList = (List<StoreInternalIndentT>)map.get("storeInternalIndentTList");
	}
	String fromMonth = "";
	String fromYear = "";
	String toMonth = "";
	String toYear = "";
	
	if(map.get("fromMonth") != null){
		fromMonth = (String)map.get("fromMonth");
	}
	if(map.get("fromYear") != null){
		fromYear = (String)map.get("fromYear");
	}
	if(map.get("toMonth") != null){
		toMonth = (String)map.get("toMonth");
	}
	if(map.get("toYear") != null){
		toYear = (String)map.get("toYear");
	}
	Date indentDate = new Date();
	String districtName = "";
	int districtId = 0;
	String hospitalName = "";
	String indentTo = "";
	String requestedBy = "";
	int requestedById = 0;
	int indentToId = 0;
	int hospitalId = 0;
	int internalIndentMId = 0;
	int instituteId = 0;
	StoreInternalIndentM storeInternalIndentM = new StoreInternalIndentM();
if(storeInternalIndentTList.size()>0){
	for(StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList){
		 storeInternalIndentM = storeInternalIndentT.getInternal();
		 System.out.println("hospital type==="+storeInternalIndentM.getHospital().getHospitalType().getHospitalTypeName());
	
		/*if(storeInternalIndentM.getDistrict()!= null){
			districtName = storeInternalIndentM.getDistrict().getDistrictName();
		}
		if(storeInternalIndentM.getDistrict()!= null){
			districtId = storeInternalIndentM.getDistrict().getId();
		}*/
		if(storeInternalIndentM.getHospital()!= null){
			hospitalName = storeInternalIndentM.getHospital().getHospitalName();
		}
		if(storeInternalIndentM.getHospital()!= null){
			hospitalId = storeInternalIndentM.getHospital().getId();
		}
		if(storeInternalIndentM.getInstitute()!= null){
			instituteId = storeInternalIndentM.getInstitute().getId();
		}
		System.out.println("instituteId=="+instituteId);
		
	
		if(storeInternalIndentM.getDemandDate() != null){
			indentDate = (Date)storeInternalIndentM.getDemandDate();
		}
		internalIndentMId =  storeInternalIndentM.getId();
		//deptId = storeInternalIndentM.getDepartment().getId();
	}
	
}



	
%>
<form name="emergencyIndentProcessingByKMSCl" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Intrim Indent Processing KMSCl</h2>
</div>

<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>


<div class="division"></div>

<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
<h4>Details</h4>
<div class="clear"></div>

<div class="Block">
<%--<label>Demand No.</label> <input type="text"
	name="<%=DEMAND_NO %>" value="" readonly="readonly"
	MAXLENGTH="8" class="readOnly" /> --%>
	
	<label>Indent Date<span>*</span></label>
	<%if(indentDate != null){ %>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(indentDate) %>" readonly="readonly"  validate="Demand Date,String,yes"  />
	 <%}else{ %>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly"  validate="Demand Date,String,yes"  />
	 <%} %>
	 

 <input type="hidden" name="storeInternalIndentM" value="<%=internalIndentMId %>" readonly="readonly"   />
 
<label>Type Of Indent<span>*</span> </label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Intrim" readonly="readonly" validate="Type Of Indent,String,yes"  />
			

<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>





	
<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
<%-- 
<label>Indent To </label> 
<select name="<%=TO_WARD%>" validate="To Ward,String,yes">
	<option value="0">Select</option>
	<%if(departmentList.size()>0){
		for(MasDepartment masDepartment:departmentList){
			if(masDepartment.getId().equals(indentToId)){
		%>
		<option value="<%=masDepartment.getId()%>"  selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%}else{ %>
		<option value="<%=masDepartment.getId()%>" ><%=masDepartment.getDepartmentName()%></option>
		
	<%}}}%>
	
	</select>--%>
	<div class="clear"></div>	
	<label>Institute<span>*</span> </label> 
<select name="instituteId" validate="Institute,String,yes">
	<option value="0">Select</option>
	<%if(instituteList.size()>0){
		for(MasHospital masHospital:instituteList){
			if(masHospital.getId().equals(instituteId)){
		%>
		<option value="<%=masHospital.getId()%>"  selected="selected"><%=masHospital.getHospitalName()%></option>
	<%}else{ %>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
		
	<%}}}%>
	
	</select>
	<div class="clear"></div>
 
</div>
<div class="clear"></div>
<h4>Period</h4>
<div class="clear"></div>
<div class="Block">


<label>From Date<span>*</span></label>
<input type="text" name="<%=FROM_DATE %>" value="<%=date %>" readonly="readonly" class="date"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.enquiryBroadcast.<%= FROM_DATE%>,event)" />
	

<label>To Date<span>*</span></label>
<input type="text" name="<%=TO_DATE %>" value="<%=date %>" readonly="readonly" class="date"  />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.enquiryBroadcast.<%= TO_DATE%>,event)" />


<div class="clear"></div>
</div>

<div class="clear"></div>

<div class="paddingTop15"></div>

<div class="clear"></div>

<h4>Indent Details</h4>
<div class="clear"></div><%-- 
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" />--%>
  <div class="clear"></div>
<table border="0" cellpadding="0" cellspacing="0">
	
			
					<tr>
						<th>SL No.</th>
						<th>Item Code</th>
						<th>KMSCL Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						
						<th>Status</th>
						<th>MIN No</th>
						<th>Generate NAC</th>
						<th>Remarks</th>
					</tr>
					<%int i = 1;
			        	String nomenclature="nomenclature";
					  String au="au";
					  String pvms="pvms";
					  String stock="stock";
					  String qtyRequest="qtyRequest";
					  String itemId="itemId";
					  if(storeInternalIndentTList.size()>0){
							for(StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList){
					
					%>
					<tr>
						<td width="%5"><input type="text" size="3" value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly" /></td>
							
						<td><input type="text" size="5" value="<%=storeInternalIndentT.getItem().getPvmsNo()!= null?storeInternalIndentT.getItem().getPvmsNo():"" %>" name="pvms" id="<%=pvms+i %>"  readonly="readonly" />
						<td><input type="text" size="5" value="" name="kmsclItemCode" id="kmsclItemCodeId<%=i %>"  readonly="readonly" />
						<input type="hidden" size="5" value="<%=storeInternalIndentT.getId()!= null?storeInternalIndentT.getId():"" %>" name="storeInternalTId" id="storeInternalTId<%=i %>"  readonly="readonly" /></td>
						<td><input type="text" value="<%=storeInternalIndentT.getItem().getNomenclature()!= null?storeInternalIndentT.getItem().getNomenclature():"" %>" tabindex="1" name="nomenclature" size="50" validate="Item name,string,yes" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
								new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&toWard='+document.instituteDpartmentIndent.<%=TO_WARD%>.value+''});
								</script></td>
									<td><input type="text" size="5" value="<%=storeInternalIndentT.getItem().getItemConversion()!= null?storeInternalIndentT.getItem().getItemConversion().getItemUnitName():"" %>" name="au" id="<%=au+i %>"  readonly="readonly" />
								<td><select name="status" id="status<%=i%>">
								<option value="">Select</option>
								<option value="NAC">NAC</option>
								<option value="MIN">MIN</option>
								
								</select></td>
							<td><input type="text" size="8" value="" name="minNo" id="minNo<%=i%>" validate="Min no.,string,no" /></td>
								
							<td><input type="checkbox" size="8" value="" name="nac" id="nac"  /></td>
							<td><input type="text" size="8" value="" name="remarks" id="remarks<%=i%>" maxlength="50" validate="Remarks,string,no" /></td>
							
						
						<input type="hidden" value="" name="itemId" id="<%=itemId+i %>" /></td>
						
					</tr>
					<%i++;}} %>
			</table>
			
 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="clear"></div>
<%-- 
<label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	<option value="Approve">Send Back</option>
	
</select>--%>

<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Submit"	onClick="submitForm('emergencyIndentProcessingByKMSCl','stores?method=submitEmergencyIndentProcessingByKMSCL');" class="button">
<input type="button" name="Next/Update" type="submit" value="Upload"	onClick="submitForm('emergencyIndentProcessingByKMSCl','stores?method=submitAnnualIndentProcessingByKMSCL');" class="button">

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>


