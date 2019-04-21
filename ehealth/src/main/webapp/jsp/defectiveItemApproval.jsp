<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugT"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<%@page import="jkt.hms.util.HMSUtil"%>



<script>

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
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	List<StoreDefectiveDrugT> storeDefectiveTList = new ArrayList<StoreDefectiveDrugT>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("storeDefectiveTList") != null){
		storeDefectiveTList = (List)map.get("storeDefectiveTList");
	}
	String entryNo = "";
	int storeDefectiveMId = 0;
	Date entryDate = new Date();
	String reason = "";
	String remarks = "";
	if(storeDefectiveTList.size()>0){
		for(StoreDefectiveDrugT storeDefectiveDrugT : storeDefectiveTList){
			StoreDefectiveDrugM storeDefectiveM = storeDefectiveDrugT.getDefectM();
			storeDefectiveMId = storeDefectiveM.getId();
			if(storeDefectiveM.getEntryNo() != null){
				entryNo = storeDefectiveM.getEntryNo();
			}
			if(storeDefectiveM.getEntryDate() != null){
				entryDate = storeDefectiveM.getEntryDate();
			}
			
			
		}
	}
	
%>

<div class="clear"></div>
<form name="defectiveItemApproval" method="post">

<div class="titleBg">
<h2>Defective Item Approval</h2>
</div>
<div class="Block">
<input type="hidden" name="defectiveMId" value="<%=storeDefectiveMId %>"/>
<label><span>*</span> Entry No. </label>
<input type="text" name="<%=ADJUSTMENT_NO %>" value="<%=entryNo!= null?entryNo:"" %>"	validate="Adjustment No.,string,yes" class="textbox_size20"	MAXLENGTH="12"/>
<label><span>*</span> Entry Date</label>
<input type="text" name="<%=ADJUSTMENT_DATE%>" class="readOnly"	readonly="readonly" value="<%=entryDate != null?HMSUtil.convertDateToStringWithoutTime(entryDate):"" %>" class="textbox_size20" MAXLENGTH="100" />

<%-- 
<label><span>*</span> Approved By</label>
<input	type="text" name="<%=APPROVED_BY_EMPLOYEE_ID_ADJUSTMENT %>" value="" class="textbox_size20" tabindex=3 maxlength="12" />--%>
<div class="clear"></div>
</div>

<table width="100%"  id="indentDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>
				<th>S.No.</th>
				<th>Item Code.</th>
				<th>Item Name.</th>
				<th>Unit.</th>
				<th>Batch No.</th>
				<th>DOM</th>
				<th>DOE</th>
				<th>Qty</th>
				<th>Remarks</th>
			</tr>
		
	</thead>
	<tbody>

		<%
   			int i=1; 
		if(storeDefectiveTList.size()>0){
			System.out.println("storeDefectiveTList"+storeDefectiveTList.size());
			for(StoreDefectiveDrugT storeDefectiveDrugT : storeDefectiveTList){
		%>
		<tr>

	<td><input type="text" size="2" value="<%=i%>" name="srNo" class="readOnly" readonly="readonly" id="srNo<%=i%>" />
	<input type="hidden" size="2" value="<%=storeDefectiveDrugT.getId()!= null?storeDefectiveDrugT.getId():"" %>" name="defectiveDrugTId" class="readOnly" readonly="readonly" id="defectiveDrugTId<%=i%>" /></td>

	<td><input type="text" size="6" name="<%=ITEM_PVMS_NO%>" value="<%=storeDefectiveDrugT.getItem()!= null?storeDefectiveDrugT.getItem().getPvmsNo():""%>" class="readOnly" readonly="readonly"  /></td>

	<td><input type="text" size="12" value="<%=storeDefectiveDrugT.getItem()!= null?storeDefectiveDrugT.getItem().getNomenclature():""%>" name="<%=ITEM_NOMENCLATURE%>"  readonly="readonly"  /></td>


	<td><input type="text" size="2" value="<%=storeDefectiveDrugT.getItem()!= null && storeDefectiveDrugT.getItem().getItemConversion() != null ?storeDefectiveDrugT.getItem().getItemConversion().getItemUnitName():""%>" name="<%=ITEM_AV%>"  readonly="readonly"  /></td>

	<td><input type="text" size="8" value="<%=storeDefectiveDrugT.getBatchNo()!= null?storeDefectiveDrugT.getBatchNo():"" %>" name="<%=BATCH%>" id=""  readonly="readonly" /></td>
	
	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=storeDefectiveDrugT.getManufacturerDate() != null?storeDefectiveDrugT.getManufacturerDate():"" %>" name="" MAXLENGTH="8" readonly="readonly" /></td>


	<td><input type="text" size="6"  readonly="readonly" value="<%=storeDefectiveDrugT.getExpiryDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeDefectiveDrugT.getExpiryDate()):"" %>" name="" MAXLENGTH="8" readonly="readonly" /></td>
	
	
	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=storeDefectiveDrugT.getDefectQty()!= null?storeDefectiveDrugT.getDefectQty().intValue():"" %>" name="defectQty" id="defectQty<%=i %>" MAXLENGTH="8" readonly="readonly" /></td>
	
	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=storeDefectiveDrugT.getRemarks()!= null?storeDefectiveDrugT.getRemarks():"" %>" name="remarks" MAXLENGTH="8" readonly="readonly" /></td>
	
		</tr>
		<%	i++;
				 }
			}%>
	</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Remarks</label>
<textarea name="remarks"   validate="Remarks,string,no" cols="0" rows="0" class="large" maxlength="300" tabindex="1" ></textarea>

<div class="clear"></div>
<input	type="button" name="Approve" value="Approve" class="button"	onclick="submitForm('defectiveItemApproval','stores?method=submitDefectiveItemApproval&flag=Approve');" tabindex=1 />
<input	type="button" name="Reject" value="Reject" class="button"	onclick="submitForm('defectiveItemApproval','stores?method=submitDefectiveItemApproval&flag=Reject');" tabindex=1 />

<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


