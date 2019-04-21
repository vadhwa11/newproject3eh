

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
List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();

if(map.get("itemList") != null){
	itemList = (List<MasStoreItem>)map.get("itemList");
}
%>


<table border="0" cellpadding="0" cellspacing="0" id="indentGrid" >

					<tr>
						<th></th>
						
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Year1 Indent Qty</th>
						<th>Year2 Indent Qty</th>
						<th>Previous Year Cons. Qty</th>
						<%--  <th>Available Stock</th>--%>
						<th>Incremental(%)</th>
						<th>IncrementalQty</th>
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
					  String itemUnitName="";
						List<Integer> itemIdList=new ArrayList<Integer>();
					  if(itemList.size() > 0){
					  for(MasStoreItem obj : itemList){
						  if(!itemIdList.contains(obj.getId()))
							{
						itemIdList.add(obj.getId());
						if(null !=obj.getItemConversion()){
							itemUnitName=obj.getItemConversion().getItemUnitName();
						}
					%>
					
					<tr>
						<td><input type="checkbox" size="3"  value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly" /></td>
						<td><input type="text" size="6" tabindex="1"  value="<%=obj.getPvmsNo() %>" name="pvms" id="<%=pvms+i %>"readonly="readonly" /></td>
							
						<td><input type="text" value="<%=obj.getNomenclature() %>" tabindex="1" name="nomenclature" size="30" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  validate="item Name,string,yes" />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
						</td>
						
						<td><input type="text" size="6" tabindex="1" disabled value="<%=itemUnitName %>" name="au" id="<%="au"+""+i %>"  readonly="readonly" /></td>
						
						<td><input type="text" size="8" value="" name="year1IndentQty" id="year1IndentQtyId<%=i %>" maxlength="10" validate="year1 Indent Qty,float,no"  /></td>
						<td><input type="text" size="8" value="" name="year2IndentQty" id="year2IndentQtyId<%=i %>" maxlength="10"  validate="year2 Indent Qty,float,no" /></td>
						<td><input type="text" size="8" value="" name="previousYearConsumption" id="previousYearConsumptionId<%=i %>" maxlength="10" validate="Previous Year Consumption,float,no" /></td>
						<td><input type="text" size="8" value="" name="incrementalPercentage" id="incrementalPercentageId<%=i %>" maxlength="3"  validate="Incremental Percentage,float,no"  onblur="calculateIndentQty(<%=i %>);"  /></td>
						<td><input type="text" size="8" value="" name="incrementalQty" id="incrementalQtyId<%=i %>" validate="Incremental Qty,float,no" maxlength="10" onblur="calculateIndentQty(<%=i %>);"  readonly="readonly"/></td>
						
						<%-- <td><input type="text" size="6" readonly="readonly" tabindex="1" value="" id="<%=stock+i %>" name="stock" validate="Stock In Hand,Intger,no" /></td>--%>
						<td><input type="text" size="8" value="" name="requiredQty" id="requiredQtyId<%=i %>" validate="Required Qty,float,no" maxlength="10" /></td>
						<td><input type="text" size="8" value="" name="additionalQty" id="additionalQtyId<%=i %>" validate="additional Qty,float,no" maxlength="10" onblur="calculateIndentQty(<%=i %>);"  /></td>
						<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Demanded Qty,float,no"  maxlength="12"/></td>
						<td><input type="text" size="10" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,remarks,no" maxlength="50"/></td>
						<input type="hidden" value="<%=obj.getId() %>" name="itemId" id="<%=itemId+i %>" /></td>
						
					</tr>
					<%}
					  i++;}}else{ %>
					
					<tr><td>Past Record Not Available</td></tr>
					<%} %>
			</table>