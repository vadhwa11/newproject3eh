<%@page import="jkt.hms.masters.business.StoreReservationT"%>
<%@page import="jkt.hms.masters.business.StoreReservationM"%>
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
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemClass"%>
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
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<StoreReservationM> reservationNoList = new ArrayList<StoreReservationM>();
	List<StoreReservationM> storeReservationMList = new ArrayList<StoreReservationM>();
	List<StoreReservationT> storeReservationTList = new ArrayList<StoreReservationT>();
	if(map.get("storeReservationMList") != null){
		storeReservationMList = (List)map.get("storeReservationMList");
	}
	
	if(map.get("reservationNoList") != null){
		reservationNoList = (List)map.get("reservationNoList");
	}
	
	if(map.get("storeReservationTList") != null){
		storeReservationTList = (List)map.get("storeReservationTList");
	}
	

	
%>


<div id = "testDiv">
<div class="Block">
<label>Reservation No.</label>
<select name="reservationId" >
<option value="">Select</option>
<%if(storeReservationMList.size()>0){
	for(StoreReservationM reservationM :storeReservationMList){
		if(reservationNoList.size()>0){
		if(reservationM.getId().equals(reservationNoList.get(0))){	
		
	%>
	<option value="<%=reservationM.getId()%>" selected="selected"><%=reservationM.getReservationNo() %></option>
<%}}else{ %>
<option value="<%=reservationM.getId()%>" selected="selected"><%=reservationM.getReservationNo() %></option>
<%}} }%>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">	
			<table width="100%"  id="blockDetails" >
				
					<tr>

						<th>S.No.</th>
						<th>Item Code</th>
						<th>Item Name</th>
						<th>Unit</th>
						<th>Batch No.</th>
					 	<th>DOE</th>
					  	<th>Stock</th>
					  	<th>Reserved Stock</th>
					  	<th>UnReserved Stock</th>
					  	<th>Till date</th>
					<%--  	<th>Extension</th>
					  	<th>Extension Date</th> --%>
						
						
					</tr>
					<%
					int i =1;
					if(storeReservationTList.size()>0){
						for(StoreReservationT storeReservationT:storeReservationTList ){
					%>
					<tr>
		<td><input type="checkbox" class="radioCheck" size="2" value="y" name="srNo" id="srNoId<%=i %>"  /></td>
		<td><input type="text" size="6" tabindex="1" readonly="readonly" value="<%=storeReservationT.getItem()!= null?storeReservationT.getItem().getPvmsNo():"" %>" name="pvms" id="pvms<%=i %>" />
		<input type="hidden" value="<%=storeReservationT.getItem()!= null?storeReservationT.getItem().getId():"" %>" name="itemId" id="itemId<%=i %>" /></td>
		
							
	<td><input type="text" readonly="readonly" value="<%=storeReservationT.getItem()!= null?storeReservationT.getItem().getNomenclature():"" %>" tabindex="1" name="nomenclature" size="20" id="nomenclature<%=i %>" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=i %>');;"  />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('nomenclature<%=i %>','ac2update','stores?method=getItemListForIndent',{minChars:3,parameters:'requiredField=nomenclature'});
			</script></td>
		<td><input type="text" size="6" tabindex="1" disabled value="<%=storeReservationT.getItem()!= null && storeReservationT.getItem().getItemConversion()!= null?storeReservationT.getItem().getItemConversion().getItemUnitName():"" %>" name="au" id="au<%=i %>" class="readOnly" readonly="readonly" /></td>
		<td><input type="text" size="8" readonly="readonly" value="<%=storeReservationT.getStock() != null && storeReservationT.getStock().getBatchNo()!= null?storeReservationT.getStock().getBatchNo():"" %>"  name="batchNo"  id="batchNo<%=i %>"/>
		<input type="hidden" size="8" readonly="readonly" value="<%=storeReservationT.getStock() != null && storeReservationT.getStock().getId()!= null?storeReservationT.getStock().getId():"" %>"  name="batchId"  id="batchId<%=i %>"/></td>
		<td><input type="text" size="8" readonly="readonly" value="<%=storeReservationT.getStock() != null && storeReservationT.getStock().getExpiryDate()!= null?HMSUtil.convertDateToStringWithoutTime(storeReservationT.getStock().getExpiryDate()):"" %>"  name="doe"  id="doe<%=i %>"/></td>
		<td><input type="text" size="7" readonly="readonly" tabindex=1 value="<%=storeReservationT.getActualStock()!= null ?storeReservationT.getActualStock().intValue():"" %>" name="stock" id="stock<%=i%>" readonly />
		</td>
		<td><input type="text" size="7" tabindex=1 readonly="readonly" value="<%=storeReservationT.getReservedStock()!= null ?storeReservationT.getReservedStock().intValue():"" %>" name="reservedStock" id="reservedStock<%=i%>"  />
		</td>
		<td><input type="text" size="7" tabindex=1 value="" maxlength="10" name="unreservedStock" id="unreservedStock<%=i%>" onblur="checkStock(this.value,<%=i%>);" />
		</td>
		<td><input type="text" size="8" value="<%=storeReservationT.getReservationTillDate()!= null ?HMSUtil.convertDateToStringWithoutTime(storeReservationT.getReservationTillDate()):"" %>"  name="tillDate" id="tillDate<%=i %>"  />
		<input type="hidden" name="reservationTId"  value="<%=storeReservationT.getId()%>"/>
		
	 </td>
		<%-- 
			<td><input type="text" value="<%=storeReservationT.getExtension()!= null ?storeReservationT.getExtension():"" %>" /></td>
			<td><input type="text" size="8" value="<%=storeReservationT.getExtensionDate()!= null ?HMSUtil.convertDateTypeToStringWithoutTime(storeReservationT.getExtensionDate()):"" %>"  name="extensionDate" id="extensionDate<%=i %>"  />--%>
	 </td>
					</tr>
					
					<%i++;}} %>
			</table>
</div>			
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
</div>