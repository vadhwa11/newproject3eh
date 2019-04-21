<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreIssueT>indentFromInstituteList = new ArrayList<StoreIssueT>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if(map.get("indentFromInstituteList")!=null){
		indentFromInstituteList = (List<StoreIssueT>) map.get("indentFromInstituteList");
	}
	System.out.println("indentFromInstituteList=="+ indentFromInstituteList);
	Date indentDate = new Date();
	if(indentFromInstituteList.size()>0){
		for(StoreIssueT storeIssueT: indentFromInstituteList){
			
			
			if(storeIssueT.getIssueM() != null && storeIssueT.getIssueM().getRequestNo() != null && storeIssueT.getIssueM().getRequestNo().getDemandDate() != null){
				indentDate = storeIssueT.getIssueM().getRequestNo().getDemandDate();
			}
		}
	}
%>



<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>
<div id="indentDiv">



<label><span>*</span> Indent Date</label>
<input type="text" name="indentDate" value="<%=indentDate != null?HMSUtil.convertDateToStringWithoutTime(indentDate):"" %>" class="date" readonly="readonly" validate="Indent Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.indentDate,event)" />

<label><span>*</span> Date Received</label>
<input type="text" name="dateReceived"	value="" class="date" readonly="readonly" validate="Date Received,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.dateReceived,event)" />
<div class="clear"></div>
<label><span>*</span> Invoice No</label>
<input name="invoiceNo" id="indentCombo" value="" validate="Invoice No,string,yes" tabindex=1 />

<label><span>*</span> Invoice Date</label>
<input type="text" name="invoiceDate"	value="" class="date" readonly="readonly" validate="Invoice Date,date,yes"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.invoiceDate,event)" />

<label>Delivery Challan No</label>
<input type="text" name="challanNo" id="challanNo" value="" validate="Challan No,string,no" />
<div class="clear"></div>
<%-- 
<label><span>*</span> PO Date</label>
<input type="text" name="poDate"	value="" class="date" readonly="readonly"	MAXLENGTH="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.createGrn.poDate,event)" />--%>
<div class="clear"></div>
</div>

<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="cmntable">
<table border="0" cellpadding="0" cellspacing="0" id="indentGrid" >


<tr>
						<th>S. No.</th>
						<th>Item Code</th>
						<%-- <th>KMSCL Item Code</th>--%>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
						<th>DOM/DOS</th>
						<th>DOE/DWE</th>
						<th>Manufacture</th>
						<th>Approved Qty</th>
						<th>Received Qty</th>
					  	<th>Surplus</th>
						<th>Defficency</th>
						<th>Remarks</th>
						</tr>
						
						<%
						int i = 1;
						if(indentFromInstituteList.size()>0){
							for(StoreIssueT storeIssueT :indentFromInstituteList){
							
						
						
						
						%>
						
						
						
						<tr>
						<td><%=i %></td>
						<td><input type="text" size="5" value="<%=storeIssueT.getItem() != null && storeIssueT.getItem().getPvmsNo()!= null?storeIssueT.getItem().getPvmsNo():"" %>" name="pvms" id="pvms<%=i %>"  readonly="readonly" />
						<input type="hidden" size="5" value="<%=storeIssueT.getItem() != null && storeIssueT.getItem().getId()!= null?storeIssueT.getItem().getId():"" %>" name="itemId" id="itemId<%=i %>"  readonly="readonly" /></td>
						<%-- <td></td>--%>
						<td><input type="text" value="<%=storeIssueT.getItem() != null ?storeIssueT.getItem().getNomenclature():"" %>" tabindex="1" validate="Item Name,string,yes" name="nomenclature" size="30" id="nomenclature<%=i %>"  /></td>
						<td><input type="text" size="5" value="<%=storeIssueT.getItem().getItemConversion()!= null?storeIssueT.getItem().getItemConversion().getItemUnitName():"" %>" validate="Unit,string,yes" name="au" id="au<%=i %>" readonly="readonly" /></td>
						
						<td><input type="text" size="8" value="<%=storeIssueT.getBatchNo()!= null?storeIssueT.getBatchNo():"" %>" name="batchNo" id="batchNo<%=i %>" validate="Batch No,string,yes" readonly="readonly" />
						<input type="hidden" size="8" value="<%=storeIssueT.getStock().getId() != null?storeIssueT.getStock().getId():"" %>" name="batchId" id="batchId<%=i %>" validate="Batch Id,int,no" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIssueT.getStock() != null && storeIssueT.getStock().getManufactureDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeIssueT.getStock().getManufactureDate()):"" %>" name="manufacturingDate" id="manufacturingDate<%=i %>" validate="Manufacture Date,date,yes" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIssueT.getExpiryDate() != null?HMSUtil.convertDateToStringWithoutTime(storeIssueT.getExpiryDate()):"" %>" name="expiryDate" id="expiryDate<%=i %>" readonly="readonly" validate="Expiry Date,date,yes" /></td>
						<td><input type="text" size="12" value="<%=storeIssueT.getStock() != null && storeIssueT.getStock().getManufacturer() != null?storeIssueT.getStock().getManufacturer().getManufacturerName():"" %>" validate="Manufacture,string,yes" name="manufacture" id="manufacture<%=i %>" readonly="readonly" />
						<input type="hidden" size="8" value="<%=storeIssueT.getStock() != null && storeIssueT.getStock().getManufacturer() != null?storeIssueT.getStock().getManufacturer().getId():"" %>" name="manufacturerId" id="manufacturerId<%=i %>" readonly="readonly" /></td>
						<td><input type="text" size="8" value="<%=storeIssueT.getQtyIssued() != null ?storeIssueT.getQtyIssued().intValue():"" %>" name="issuedQty" id="issuedQty<%=i %>" validate="Approved Qty,float,yes" readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="quantityReceived" id="quantityReceived<%=i %>" onblur="calulateStock(<%=i %>);" validate="Received Qty,float,yes" /></td>
						<td><input type="text" size="8" value="" name="surplus" id="surplus<%=i %>" readonly="readonly" validate="Surplus,float,no"/></td>
						<td><input type="text" size="8" value="" name="deficient" id="deficient<%=i %>" readonly="readonly" validate="Defficency,float,no"/></td>
						<td><input type="text" size="15" value="" name="remarks" id="remarks<%=i %>"  validate="Remarks,string,no"/></td>
						</tr>
			
						<%	
							i++;}
						} %>
									</table>
						</div>
