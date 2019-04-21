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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

<%
	Map<String,Object> map = new HashMap<String,Object>();

	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<StoreInternalIndentT> storeInternalIndentTList = new ArrayList<StoreInternalIndentT>();
	List<MasStoreGroup> storeGroupList = new ArrayList<MasStoreGroup>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
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
	List<MasEmployee> requestByEmployeeList = new ArrayList<MasEmployee>();
	if(map.get("requestByEmployeeList") != null){
		requestByEmployeeList = (ArrayList) map.get("requestByEmployeeList");
	}
	if(map.get("hospitalTypeList") != null){
		hospitalTypeList = (List<MasHospitalType>)map.get("hospitalTypeList");
	}
	if(map.get("hospitalList") != null){
		hospitalList = (List<MasHospital>)map.get("hospitalList");
	}
	if(map.get("storeGroupList") != null){
		storeGroupList = (List<MasStoreGroup>)map.get("storeGroupList");
	}
	if(map.get("itemTypeList") != null){
		itemTypeList = (List<MasItemType>)map.get("itemTypeList");
	}
	if(map.get("sectionList") != null){
		sectionList = (List<MasStoreSection>)map.get("sectionList");
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
	String hospitalType = "";
	int hospitalTypeId = 0;
	String hospitalName = "";
	String indentTo = "";
	String requestedBy = "";
	int requestedById = 0;
	int indentToId = 0;
	int hospitalId = 0;
	int internalIndentMId = 0;
	StoreInternalIndentM storeInternalIndentM = new StoreInternalIndentM();
if(storeInternalIndentTList.size()>0){
	for(StoreInternalIndentT storeInternalIndentT : storeInternalIndentTList){
		 storeInternalIndentM = storeInternalIndentT.getInternal();
		 System.out.println("hospital type==="+storeInternalIndentM.getHospital().getHospitalType().getHospitalTypeName());
	
		if(storeInternalIndentM.getHospital().getHospitalType()!= null){
			hospitalType = storeInternalIndentM.getHospital().getHospitalType().getHospitalTypeName();
		}
		if(storeInternalIndentM.getHospital().getHospitalType()!= null){
			hospitalTypeId = storeInternalIndentM.getHospital().getHospitalType().getId();
		}
		
		if(storeInternalIndentM.getHospital()!= null){
			hospitalName = storeInternalIndentM.getHospital().getHospitalName();
		}
		if(storeInternalIndentM.getHospital()!= null){
			hospitalId = storeInternalIndentM.getHospital().getId();
		}
		if(storeInternalIndentM.getToStore()!= null){
			indentTo = storeInternalIndentM.getToStore().getDepartmentName();
		}
		if(storeInternalIndentM.getToStore()!= null){
			indentToId = storeInternalIndentM.getToStore().getId() ;
		}
		if(storeInternalIndentM.getRequestedBy()!= null){
			requestedBy = storeInternalIndentM.getRequestedBy().getFirstName()+" "+storeInternalIndentM.getRequestedBy().getFirstName();
		}
		if(storeInternalIndentM.getRequestedBy()!= null){
			requestedById = storeInternalIndentM.getRequestedBy().getId();
		}
		if(storeInternalIndentM.getDemandDate() != null){
			indentDate = (Date)storeInternalIndentM.getDemandDate();
		}
		internalIndentMId =  storeInternalIndentM.getId();
		//deptId = storeInternalIndentM.getDepartment().getId();
	}
	
}



	
%>
<form name="annualInstituteIndentApproval" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Institute Indent Approval</h2>
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
	
	<label>Indent Date</label>
	<%if(indentDate != null){ %>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=HMSUtil.convertDateToStringTypeDateOnly(indentDate) %>" readonly="readonly"  validate="demandDate,date,no" />
	 <%}else{ %>
	 <input type="text" name="<%=DEMAND_DATE %>" value="<%=date %>" readonly="readonly"  validate="demandDate,date,no" />
	 <%} %>
	 

 <input type="hidden" name="storeInternalIndentM" value="<%=internalIndentMId %>" readonly="readonly"  />
<label>Type Of Indent </label>
 <input type="text" name="<%=TYPE_OF_INDENT %>" value="Annual" readonly="readonly"   />
			

<%-- <label>From </label>
<select name="<%=FROM_WARD%>"	>
			<option value="0">Select</option>
	
			</select>--%>

<label>Hospital Type </label>
<select name="hospitalTypeId" id="hospitalTypeId" validate="hospitalTypeId,metachar,no">
	<option value="0">Select</option>
	<%
	
	if(hospitalTypeList.size()>0){
		for(MasHospitalType masHospitalType:hospitalTypeList){
			if(masHospitalType.getId().equals(hospitalTypeId)){
				System.out.println("masHospitalType.getId()=="+masHospitalType.getId());
		%>
	<option value="<%=masHospitalType.getId()%>" selected="selected" ><%=masHospitalType.getHospitalTypeName()%></option>
	<%}else{ %>
	<option value="<%=masHospitalType.getId()%>" ><%=masHospitalType.getHospitalTypeName()%></option>
	<%}}} %>
	
	</select>

<div class="clear"></div>

	<label>Hospital Name </label>
<select name="hospitalId" id="hospitalId" validate="HospitalName ,metachar,no">
	<option value="0">Select</option>
	<%if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
			if(masHospital.getId().equals(hospitalId)){
		%>
		<option value="<%=masHospital.getId()%>" selected="selected"><%=masHospital.getHospitalName()%></option>
		<%}else{ %>
		<option value="<%=masHospital.getId()%>" ><%=masHospital.getHospitalName()%></option>
		
	<%}}}%>
	
	</select>

<%-- <label><span>*</span> Approved By</label> <select
	name="<%=APPROVED_BY_EMPLOYEE_ID_DEPENDENT_INDENT%>"
	validate="Approved By,String,no">
	<option value="0">Select</option>
	
</select>--%>
<%-- 
<label><span>*</span>Indent To </label> 
<select name="<%=TO_WARD%>" validate="Indent To,String,yes">
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
 
</div>
<div class="clear"></div>
<h4>Period</h4>
<div class="clear"></div>
<div class="Block">

<label>From Month</label>
<input type="text" name="fromMonth" value="<%=fromMonth %>"  />
<label>Year</label>
<input type="text" name="fromYear" value="<%=fromYear %>"  />


<div class="clear"></div>
<label>To Month</label>
<input type="text" name="toMonth" value="<%=toMonth %>" />
<label>Year</label>
<input type="text" name="toYear" value="<%=toYear %>"  />

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
  <div class="cmntable">
<table border="0" cellpadding="0" cellspacing="0">
	
			
					<tr>
						<th><input type="checkbox" name="srno1" id="srNoId1" onchange="toggle1()"></th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Year1 Indent Qty</th>
						<th>Year2 Indent Qty</th>
						<th>Prev Year Cons. Qty</th>
						 <th> Stock</th>
						 <th>Lead Time</th>
					 	<th>Cons.in Lead Time</th>
					 	<th>Incremental (%)</th>
					 	<th>Incremental Qty</th>
						<th>Pending Indent Qty</th>
						<th>Required Qty</th>
						  <th>Additional qty</th>
						<th>Demanded Qty</th>
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
						<td><input type="checkbox" size="5" class="radioCheck" value="y" name="srno" id="srNoId<%=i %>"  readonly="readonly"  /></td>
							
						<td><input type="text" size="5" value="<%=storeInternalIndentT.getItem().getPvmsNo()!= null?storeInternalIndentT.getItem().getPvmsNo():"" %>" name="pvms" id="<%=pvms+i %>"  readonly="readonly"  />
						<input type="hidden" size="5" value="<%=storeInternalIndentT.getId()!= null?storeInternalIndentT.getId():"" %>" name="storeInternalTId" id="storeInternalTId<%=i %>"  readonly="readonly"  /></td>
						<td><input type="text" value="<%=storeInternalIndentT.getItem().getNomenclature()!= null?storeInternalIndentT.getItem().getNomenclature():"" %>" tabindex="1" name="nomenclature" size="20" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
								new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&toWard='+document.instituteDpartmentIndent.<%=TO_WARD%>.value+''});
								</script></td>
						<td><input type="text" size="4" value="<%=storeInternalIndentT.getItem().getItemConversion()!= null?storeInternalIndentT.getItem().getItemConversion().getItemUnitName():"" %>" name="au" id="<%="au"+""+i %>" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getPrevYearIndQty()!= null?storeInternalIndentT.getPrevYearIndQty().intValue():"" %>" name="year1IndentQty" id="year1IndentQtyId<%=i %>" readonly="readonly" validate="year1IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getPrevToPrevYearIndQty()!= null?storeInternalIndentT.getPrevToPrevYearIndQty().intValue():"" %>" name="year2IndentQty" id="year2IndentQtyId<%=i %>"  readonly="readonly" validate="year2IndentQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getPrevYearConsmQty()!= null?storeInternalIndentT.getPrevYearConsmQty().intValue():"" %>" name="previousYearConsumption"  id="previousYearConsumptionId<%=i %>"  readonly="readonly" validate="previousYearConsumption,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getStockInHand()!= null?storeInternalIndentT.getStockInHand().intValue():"" %>" name="stock" validate="Stock In Hand,float,no" id="<%=stock+i %>"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getLeadTime()!= null?storeInternalIndentT.getLeadTime().intValue():"" %>" name="leadTime"   id="leadTimeId<%=i %>" readonly="readonly"  /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getConsInLeadTime()!= null?storeInternalIndentT.getConsInLeadTime().intValue():"" %>" name="consumptionInLeadTime"   id="consumptionInLeadTimeId<%=i%>" readonly="readonly"   /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getIncrementalPercentage()!= null?storeInternalIndentT.getIncrementalPercentage().intValue():"" %>" name="incrementalPercentage" id="incrementalPercentageId<%=i %>"  readonly="readonly"   /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getIncrementalQuantity()!= null?storeInternalIndentT.getIncrementalQuantity().intValue():"" %>" name="incrementalQty" id="incrementalQtyId<%=i %>" readonly="readonly" validate="incrementalQty,float,no"/></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getPendingIndentQty()!= null?storeInternalIndentT.getPendingIndentQty().intValue():"" %>" name="pendingIndentQty" id="pendingIndentQtyId<%=i %>" validate="Pending Indent Qty,float,no" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getRequiredQty()!= null?storeInternalIndentT.getRequiredQty().intValue():"" %>" name="requiredQty" id="requiredQtyId<%=i %>" validate="Requested Qty,float,no" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getAdditionalQty()!= null?storeInternalIndentT.getAdditionalQty().intValue():"" %>" name="additionalQty" validate="Stock In Hand,float,no" id="additionalQtyId<%=i %>"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeInternalIndentT.getQtyRequest()!= null?storeInternalIndentT.getQtyRequest().intValue():"" %>" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,no" readonly="readonly" /></td>
						<td><input type="text" size="10" value="<%=storeInternalIndentT.getRemarks()!= null?storeInternalIndentT.getRemarks():"" %>" name="remarks" id="remarks<%=i %>" validate="Remarks,remarks,no"  readonly="readonly"/>
						<input type="hidden" value="<%=storeInternalIndentT.getId()!= null?storeInternalIndentT.getId():"" %>" name="itemId" id="<%=itemId+i %>" validate="itemId,int,no"/></td>
						
					</tr>
					
					<%i++;}} %>
			</table>
	</div>		
 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />
<div class="clear"></div>
<%-- 
<label><span>*</span> Status</label>
<select	name="status"	validate="Approved By,String,yes" id="approvedBy" tabindex=1>
	<option value="0">Select</option>
	<option value="Approve">Approve</option>
	<option value="Approve">Reject</option>
	<option value="Approve">Send Back</option>
	
</select>--%>
<label> SMO Remarks</label>
<textarea name="smoRemarks"   validate="Remarks,remarks,no" cols="0" rows="0" class="large" maxlength="198" tabindex="1" ></textarea>

<div class="paddingTop40"></div>
<div class="clear"></div>




<div class="clear"></div>
<input type="button" name="Next/Update" type="submit" value="Approve"	onClick="submitForm('annualInstituteIndentApproval','stores?method=submitAnnualInstituteApproval','validateRows');" class="button">
<input type="button" name="Next/Update" type="submit" value="SendBack"	onClick="submitForm('annualInstituteIndentApproval','stores?method=submitAnnualDepartmentApproval');" class="button">


<script type="text/javascript">
function toggle1() {
	 checkboxes = document.getElementsByName('srno');
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
 