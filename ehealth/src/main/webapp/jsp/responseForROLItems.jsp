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

<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object> map = new HashMap<String,Object>();



if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<Object[]>reorderLevelItemList = new ArrayList<Object[]>();

if(map.get("reorderLevelItemList") != null){
	reorderLevelItemList = (List)map.get("reorderLevelItemList");
}
%>


<table border="0" cellpadding="0" cellspacing="0" id="indentGrid" >

					<tr>
						<th></th>
						<th>Item Code</th>
						<th>KMSCL Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Consumption</th>
						 <th>Available Stock</th>
						  <th>Lead Time</th>
						   <th>Consumption In Lead Time</th>
						  <th>Days</th>
						  <th>Incremental Qty</th>
							<th>Pending Qty</th>
						<th>Required Qty</th>
						 <th>Additional qty</th>
						<th>Demanded Qty</th>
						<th>Remarks</th>
					</tr>
					
					<%
						int i = 1;
						String nomenclature="nomenclature";
					  String au="au";
					  String pvms="pvms";
					  String stock="stock";
					  String qtyRequest="qtyRequest";
					  String itemId="itemId";
					  if(reorderLevelItemList.size() > 0){
					  for(Object[] obj : reorderLevelItemList){
						 
					%>
					
					<tr>
						<td><input type="checkbox" size="3"  value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly" /></td>
						<td><input type="text" size="6" tabindex="1"  value="<%=obj[1]!= null?obj[1]:"" %>" name="pvms" id="<%=pvms+i %>"readonly="readonly" /></td>
						<td><input type="text" size="5" tabindex="1"  value="" name="kmsclItemCode" id="kmsclItemCode<%=i %>" /></td>
							
							
						<td><input type="text" value="<%=obj[2]!= null?obj[2]:"" %>" tabindex="1" name="nomenclature" size="30" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  validate="item Name,string,yes" />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
						</td>
						<td><input type="text" size="6" tabindex="1"  value="<%=obj[3]!= null?obj[3]:"" %>" name="au" id="<%="au"+""+i %>"  readonly="readonly" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" id="previousYearConsumptionId<%=i %>" validate="Previous Year Consumption,float,no" /></td>
						<td><input type="text" size="8" readonly="readonly" tabindex="1" value="<%=obj[4]!= null?obj[4]:"" %>" id="<%=stock+i %>" name="stock" validate="Stock,float,no" /></td>
						
						<td><input type="text" size="8" value="" name="leadTime" validate="Lead Time,float,no" id="leadTimeId<%=i %>" onblur="calculateIndentQty(<%=i %>);"    /></td>
					<td><input type="text" size="8" value="" name="consumptionInLeadTime" validate="Consumption In Lead Time,float,no" id="consumptionInLeadTimeId<%=i%>"   /></td>
					<td><input type="text" size="8" value="" name="days" id="daysId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Days,float,no" /></td>
					<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="IncrementalQty,float,no" /></td>
					<td><input type="text" size="8" value="" name="pendingIndentQty" id="pendingIndentQtyId<%=i %>" onblur="calculateIndentQty(<%=i %>);" validate="Pending Indent Qty,float,no" /></td>
					<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,no" /></td>
					<td><input type="text" size="8" value="" name="additionalQty" id="additionalQtyId<%=i %>" validate="Additional,float,no" onblur="calculateIndentQty(<%=i %>);"   /></td>
					<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,num,yes" /></td>
					<td><input type="text" size="20" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,string,no" /></td>
					<input type="hidden" value="<%=obj[0]!= null?obj[0]:"" %>" name="itemId" id="<%=itemId+i %>" /></td>
						
						
					</tr>
					<%
					  i++;}}else{ %>
					
					<tr><td>No Record</td></tr>
					<%} %>
			</table>
			<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />