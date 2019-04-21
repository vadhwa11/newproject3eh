<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * indent.jsp
 * Purpose of the JSP -  This is for indent.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 21th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.28
--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreAdjustmentM"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreAdjustmentT"%>

<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingT"%>
<%@page import="jkt.hms.masters.business.StoreStockTakingM"%>

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

	int monthSearch = gregorianCalendar1.get(Calendar.MONTH) + 1;
	if (monthSearch < 10) {
		orderDateOnly.append("0");
		orderDateOnly.append(monthSearch);
	} else {
		orderDateOnly.append(monthSearch);
	}

	orderDateOnly.append("/");
	int year1 = gregorianCalendar1.get(Calendar.YEAR);
	orderDateOnly.append(year1);
	String currentDate = new String(orderDateOnly);
%>
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
	List<StoreAdjustmentT> storeAdjustmentTList = new ArrayList<StoreAdjustmentT>();
	List<StoreStockTakingT> storeStockTakingTList = new ArrayList<StoreStockTakingT>();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if(map.get("storeAdjustmentTList") != null){
		storeAdjustmentTList = (List<StoreAdjustmentT>)map.get("storeAdjustmentTList");
	}
	if(map.get("storeStockTakingTList") != null){
		storeStockTakingTList = (List<StoreStockTakingT>)map.get("storeStockTakingTList");
	}
	String adjustmentNo = "";
	int adjustmentMId = 0;
	Date adjustmentDate = new Date();
	String reason = "";
	String remarks = "";
	if(storeAdjustmentTList.size()>0){
		for(StoreAdjustmentT storeAdjustmentT : storeAdjustmentTList){
			StoreAdjustmentM storeAdjustmentM = storeAdjustmentT.getAdjust();
			adjustmentMId = storeAdjustmentM.getId();
			if(storeAdjustmentM.getAdjustmentNo() != null){
				adjustmentNo = storeAdjustmentM.getAdjustmentNo();
			}
			if(storeAdjustmentM.getAdjustmentDate() != null){
				adjustmentDate = storeAdjustmentM.getAdjustmentDate();
			}
			if(storeAdjustmentM.getReason() != null){
				reason = storeAdjustmentM.getReason();
			}
			if(storeAdjustmentM.getRemarks() != null){
				remarks = storeAdjustmentM.getRemarks();
			}			
		}
	}	
%>

<div class="clear"></div>
<form name="adjustmentApproval" method="post">

<div class="titleBg">
<h2>Adjustment Approval</h2>
</div>
<div class="Block">
<input type="hidden" name="adjustmentId" value="<%=adjustmentMId %>"/>
<label><span>*</span> Adjustment No </label>
<input type="text" name="<%=ADJUSTMENT_NO %>" value="<%=adjustmentNo!= null?adjustmentNo:"" %>"	validate="Adjustment No.,string,yes" class="textbox_size20"	MAXLENGTH="12"/>
<label><span>*</span> Adjustment Date</label>
<input type="text" name="<%=ADJUSTMENT_DATE%>" class="readOnly"	readonly="readonly" value="<%=adjustmentDate != null?HMSUtil.convertDateToStringWithoutTime(adjustmentDate):"" %>" class="textbox_size20" MAXLENGTH="100" />
<label><span>*</span> Reason</label>
<input	type="text" name="<%=REASON %>" value="<%=reason != null?reason:"" %>" 	tabindex=3 maxlength="100" />
<div class="clear"></div>
<label><span>*</span> Remarks</label>
<input type="text"	name="<%=REMARKS %>" value="<%=remarks != null?remarks:"" %>"  tabindex=3	maxlength="100" />
<%-- 
<label><span>*</span> Approved By</label>
<input	type="text" name="<%=APPROVED_BY_EMPLOYEE_ID_ADJUSTMENT %>" value="" class="textbox_size20" tabindex=3 maxlength="12" />--%>
</div>
<div class="clear"></div>
<h4>Adjustment details</h4>
<table width="100%"  id="indentDetails"  cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th>S.No.</th>
			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!-- <td width="10%"><label valign="left" class="smalllabel">Brand Name</label></td> -->
			<th>Batch No.</th>
			<th>Expiry Date</th>
			<th>Computed Stock</th>
			<th>Surplus</th>
			<th>Deficient</th>
			<th>Final Stock</th>
		</tr>
	</thead>
	<tbody>

		<%
   			int i=1; 
		if(storeAdjustmentTList.size()>0){
			for(StoreAdjustmentT storeAdjustmentT : storeAdjustmentTList){
		%>
		<tr>

	<td><input type="text" size="2" value="<%=i%>" name="srNo"  readonly="readonly" id="" /></td>
	<td><input type="text" size="6" name="<%=ITEM_PVMS_NO%>" value="<%=storeAdjustmentT.getItem()!= null?storeAdjustmentT.getItem().getPvmsNo():""%>"  readonly="readonly"  /></td>
	<td><input type="text" size="30" value="<%=storeAdjustmentT.getItem()!= null?storeAdjustmentT.getItem().getNomenclature():""%>" name="<%=ITEM_NOMENCLATURE%>"  readonly="readonly"  /></td>
	<td><input type="text" size="5" value="<%=storeAdjustmentT.getItem()!= null && storeAdjustmentT.getItem().getItemConversion() != null ?storeAdjustmentT.getItem().getItemConversion().getItemUnitName():""%>" name="<%=ITEM_AV%>"  readonly="readonly"  /></td>

	<td><input type="text" size="8" value="<%=storeAdjustmentT.getBatchNo()!= null?storeAdjustmentT.getBatchNo():"" %>" name="<%=BATCH%>" id="" class="readOnly" readonly="readonly" /></td>


	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=storeAdjustmentT.getExpiryDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeAdjustmentT.getExpiryDate()):"" %>" name="" MAXLENGTH="8" readonly="readonly" /></td>
	<%
	BigDecimal surplus = new BigDecimal(0);
	BigDecimal defficient = new BigDecimal(0);
	BigDecimal compStock = new BigDecimal(0);
	BigDecimal finalStock = new BigDecimal(0);
	//Added by Arbind on 04-03-2017 
	if(storeStockTakingTList.size()>0){
		for(StoreStockTakingT storeStockTakingT : storeStockTakingTList){
			if(storeStockTakingT.getBatchNo().equals(storeAdjustmentT.getBatchNo())) {
				if(!storeStockTakingT.getStockSurplus().equals("")){
					surplus = storeStockTakingT.getStockSurplus();
				}
				if(!storeStockTakingT.getStockDeficient().equals("")){
					defficient = storeStockTakingT.getStockDeficient();
				}
				if(!storeStockTakingT.getComputedStock().equals("")){
					compStock = storeStockTakingT.getComputedStock();
				}
				finalStock = compStock.add(surplus).subtract(defficient);
				break;
			}
		}
	}
	//Commented by Arbind on 03-03-2017
	/* 	Set<StoreStockTakingT>  storeStocktTakingTSet = storeAdjustmentT.getAdjust().getStoreStockTakingM().getStoreStockTakingTs();
	for(StoreStockTakingT storeStockTakingT : storeStocktTakingTSet){
		if(!storeStockTakingT.getStockSurplus().equals("")){
			surplus = storeStockTakingT.getStockSurplus();
		}
		if(!storeStockTakingT.getStockSurplus().equals("")){
			defficient = storeStockTakingT.getStockDeficient();
		}
		if(!storeStockTakingT.getStockSurplus().equals("")){
			surplus = storeStockTakingT.getStockSurplus();
		}
		if(!storeStockTakingT.getComputedStock().equals("")){
			compStock = storeStockTakingT.getComputedStock();
		}
		finalStock = compStock.add(surplus).subtract(defficient);
	} */
	%>
	<td><input type="text" size="6"  readonly="readonly" value="<%=compStock != null?compStock.intValue():""%>" name="<%=COMPUTED_STOCK %>" MAXLENGTH="8" readonly="readonly" /></td>

	<td><input type="text" size="6"  readonly="readonly" value="<%=surplus != null?surplus.intValue():""%>" name="<%=SURPLUS_STOCK %>" MAXLENGTH="8" readonly="readonly" /></td>

	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=defficient != null?defficient.intValue():""%>" name="<%=DEFICIENT %>" MAXLENGTH="8" readonly="readonly" /></td>
	
	<!-- Changed by Arbind on 03-03-2017 -->
	<%-- <td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=storeAdjustmentT.getAdjustQty()!= null?storeAdjustmentT.getAdjustQty().intValue():"" %>" name="finalStock" MAXLENGTH="8" readonly="readonly" /></td> --%>
	
	<td width="5%"><input type="text" size="6"  readonly="readonly" value="<%=finalStock != null?finalStock.intValue():"" %>" name="finalStock" MAXLENGTH="8" readonly="readonly" /></td>

	<%-- 		<%
           BigDecimal finalStock = new BigDecimal(0);
           try
           {
           		BigDecimal compStock = storeStockTakingT.getComputedStock();
           		BigDecimal defi = storeStockTakingT.getStockDeficient();
           		BigDecimal surplus = storeStockTakingT.getStockSurplus();
           		finalStock = compStock.add(surplus).subtract(defi);
           }
           catch(Exception e)
           {
				finalStock = new BigDecimal(0);
           }

           %>--%>
	
		</tr>
		<%	i++;
				 }
			}%>
	</tbody>
</table>
<div class="paddingTop15"></div>
<label>Remarks</label>
<textarea name="remarks"   validate="Remarks,string,no" cols="0" rows="0" class="large" maxlength="300" tabindex="1" ></textarea>

<div class="clear"></div>
<input	type="button" name="Approve" value="Approve" class="button"	onclick="submitForm('adjustmentApproval','stores?method=submitAdjustmentApproval&flag=Approve');" tabindex=1 />
<input	type="button" name="Reject" value="Reject" class="button"	onclick="submitForm('adjustmentApproval','stores?method=submitAdjustmentApproval&flag=Reject');" tabindex=1 />

<div class="paddingTop40"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />
<div class="paddingTop40"></div>
