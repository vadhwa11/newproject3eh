
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
	int groupId = 0;
	int itemTypeId = 0;
	int sectionId = 0;
	int categoryId = 0;
	int classId = 0;
	if(map.get("groupId") != null){
		groupId = (Integer)map.get("groupId");
	}
	if(map.get("itemTypeId") != null){
		itemTypeId = (Integer)map.get("itemTypeId");
	}
	if(map.get("sectionId") != null){
		sectionId = (Integer)map.get("sectionId");
	}
	if(map.get("categoryId") != null){
		categoryId = (Integer)map.get("categoryId");
	}
	if(map.get("classId") != null){
		classId = (Integer)map.get("classId");
	}
System.out.println("groupId=="+groupId);
System.out.println("itemTypeId=="+itemTypeId);
System.out.println("sectionId=="+sectionId);
System.out.println("categoryId=="+categoryId);
System.out.println("classId=="+classId);
	
%>






<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<input type="hidden" name="groupId" id="groupId"  value="<%=groupId %>"/>
<input type="hidden" name="itemTypeId" id="itemTypeId"  value="<%=itemTypeId %>"/>
<input type="hidden" name="categoryId" id="categoryId"  value="<%=categoryId %>"/>
<input type="hidden" name="classId" id="classId"  value="<%=classId %>"/>
  <div id="gridDiv">

<table border="0" cellpadding="0" cellspacing="0" id="indentGrid">
					<tr>
						<th>SL No.</th>
						
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						 <th>Available Stock</th>
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
					%>
					
					<tr>
						<td width="%5"><input type="hidden" size="5" value="<%=i %>" name="srno" id="srNoId<%=i %>"  readonly="readonly" /></td>
							
						<td><input type="text" size="6" tabindex="1"  value="" name="pvms" id="<%=pvms+i %>" /></td>
							
							
						<td><input type="text" value="" tabindex="1" name="nomenclature" size="50" id="<%=nomenclature+i %>" onblur="getOtherItemsForDepartmentIndent(<%=i %>);"  />
							<div id="ac2update" class="autocomplete" style="display: none;"></div>
							<script type="text/javascript" language="javascript" charset="utf-10">
							new Ajax.Autocompleter('<%="nomenclature"+""+i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=<%=nomenclature%>&groupId='+document.getElementById('itemGroupId').value+'&itemTypeId='+document.getElementById('itemTypeId').value+'&sectionId='+document.getElementById('sectionId').value+'&categoryId='+document.getElementById('categoryId').value+'&classId='+document.getElementById('classId').value+''});
								</script></td>
					<td><input type="text" size="6" tabindex="1" disabled value="" name="au" id="<%="au"+""+i %>" class="readOnly" readonly="readonly" /></td>
						<td><input type="text" size="6" readonly="readonly" tabindex="1" value="" id="<%=stock+i %>" name="stock" validate="Stock In Hand,Intger,no" /></td>
						<td><input type="text" size="8" value="" name="qtyRequest" id="<%=qtyRequest+i %>" validate="Requested Qty,num,no" /></td>
						<td><input type="text" size="8" value="" name="remarks" id="remarks<%=i %>" validate="Remarks,string,no" /></td>
						<input type="hidden" value="" name="itemId" id="<%=itemId+i %>" /></td>
						
					</tr>
		
</table>
</div>