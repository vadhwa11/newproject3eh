<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.util.RequestConstants"%>

<%@page import="jkt.hms.masters.business.HesEquipmentAmcDetailsEntry"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplierGroup"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar = Calendar.getInstance();
String month = String.valueOf((calendar.get(Calendar.MONTH))+1);
String date = String.valueOf(calendar.get(Calendar.DATE));
int year = calendar.get(calendar.YEAR);

	if(month.length() < 2)
	{
		month = "0" + month;
	}
	if(date.length() < 2)
	{
		date = "0" + date;
	}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script>

<%
		Map<String ,Object> map = new HashMap<String ,Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<HesEquipmentMaster> equipmentMasList = new ArrayList<HesEquipmentMaster>();
		List<HesEquipmentAmcDetailsEntry> amcDetailsList = new ArrayList<HesEquipmentAmcDetailsEntry>();
		List<MasStoreSupplierGroup> masStoreSuplierGroupList = new ArrayList<MasStoreSupplierGroup>();
		if(request.getAttribute("map") != null)
		{
			map = (Map<String ,Object>) request.getAttribute("map");
		}
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		String userName = "";
		if (map.get("equipmentMasList")!= null){
			equipmentMasList = (List<HesEquipmentMaster>)map.get("equipmentMasList");
		 }
		
		if (map.get("amcDetailsList")!= null){
			amcDetailsList = (List<HesEquipmentAmcDetailsEntry>)map.get("amcDetailsList");
		 }
		
		if (map.get("masStoreSuplierGroupList")!= null){
			masStoreSuplierGroupList = (List<MasStoreSupplierGroup>)map.get("masStoreSuplierGroupList");
		 }
		
		if(session.getAttribute("userName") != null)
		{
			userName = (String)session.getAttribute("userName");
		}
		
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
		}
%>

   <%
     
      for(HesEquipmentMaster equipmentMaster : equipmentMasList){%>
          <label>Serial No</label>

		<select name="serialNo" id="serialNo" validate="Serial No,String,yes" tabindex=1>
			<!--- <option value="0">-Select Serial No-</option> -->
			<option value=<%=equipmentMaster.getId()%>><%=equipmentMaster.getSerialNo()%></option>
		</select>
         
          <label>Date Of Installation</label>
        <input type="text" name="<%=RequestConstants.TO_DATE %>" value="<%=HMSUtil.changeDateToddMMyyyy(equipmentMaster.getDateOfInstallation()) %>" id="dateOfInstallation"  
	     MAXLENGTH="15"  readonly="readonly"/> 	  
	     <label>Warranty Start Date</label>
	       <% 
	         if(equipmentMaster.getWarrentyStartDate()!=null){%>
	        	 <input type="text" name="warentySdate" value="<%=HMSUtil.changeDateToddMMyyyy(equipmentMaster.getWarrentyStartDate())%>" id="warentySdate"  
	 				MAXLENGTH="15"  readonly="readonly" />
	        <%}
	         else{%>
	        	 No Warranty
	         <%}
			%>
		<label>Warranty End Date</label>
		 <%
		   if(equipmentMaster.getWarrentyEndDate()!= null){%>
			   <input type="text" name="warentyEdate" value="<%=HMSUtil.changeDateToddMMyyyy(equipmentMaster.getWarrentyEndDate()) %>" id="warentyEdate"  
					MAXLENGTH="15"  readonly="readonly" />	   
		   <%}
		   else{%>
			   No Warranty
		   <%}
		  %>	
	<%}
   %>
   
   
 <div class="cmntable">

<table cellspacing="0" cellpadding="0" border="0" align="center"
	colspan="11">
	<tbody>
		<tr>
			<th scope="col">AMC Company</th>
			<th scope="col">AMC Date From</th>
			<th scope="col">AMC Date To</th>
			<th scope="col">Cost of AMC</th>
			<th scope="col">Adv.Bill No.</th>
			<th scope="col">Adv.Bill Date</th>
			<th scope="col">Adv. Bill Amount</th>
			<th scope="col">Balance Bill No.</th>
			<th scope="col">Balance Bill Date</th>
			<th scope="col">Balance Bill Amount</th>
			<th scope="col">Remarks</th>
		</tr>
	</tbody>
	
	<tbody class="scrollContent bodyFormat">
		
		<%
			if (amcDetailsList.size() > 0) {
				for (HesEquipmentAmcDetailsEntry equipmentAmcObj : amcDetailsList) {
		%>
		<tr>
			<td width="5%">
			<%
				if (amcDetailsList.size() > 0) {
							for (MasStoreSupplierGroup masStoreSupplierGroupObj : masStoreSuplierGroupList) {
								if (masStoreSupplierGroupObj.getSupplier().getId()
										.equals(equipmentAmcObj.getSupplierGroup().getSupplier().getId())) {
			%> <label class="value"><%=masStoreSupplierGroupObj.getSupplier().getSupplierName()%></label>
			<%
				}
							}
						}
			%>
			</td>
							
			<td width="2%"><label class="value"><%=HMSUtil.changeDateToddMMyyyy(equipmentAmcObj.getAmcWarrentyStartDate())%> </label></td>
			<td width="2%"><label class="value"><%=HMSUtil.changeDateToddMMyyyy(equipmentAmcObj.getAmcWarrentyEndDate())%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getCostOfAmc()%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getAdvBillNo()%> </label></td>
			<td width="2%"><label class="value"><%=HMSUtil.changeDateToddMMyyyy(equipmentAmcObj.getAdvBillDate())%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getAdvBillAmount()%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getBalanceBillNo()%> </label></td>
			<td width="2%"><label class="value"><%=HMSUtil.changeDateToddMMyyyy(equipmentAmcObj.getBalanceBillDate())%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getBalanceBillAmount()%> </label></td>
			<td width="2%"><label class="value"><%=equipmentAmcObj.getRemarks()%> </label></td>
			<%}
			%>
			

		</tr>
		<%
			}

		%>
	</tbody>
</table>
</div>
   
   <!-- Grid view of AMC Details -->
  <%--<div id ="gridAMC" style="display: inline">
     <% 
         if(amcDetailsList.size()>0){
	         for(HesEquipmentAmcDetailsEntry equipmentAmcObj : amcDetailsList){%>
	       
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getSupplierGroup().getSupplier().getSupplierName()%>
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getAmcWarrentyStartDate()%>
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getAmcWarrentyEndDate()%>
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getAdvBillNo()%>
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getAdvBillDate()%>
	         <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getAdvBillAmount()%>
	    	 <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getBalanceBillNo()%>
	    	 <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getBalanceBillDate()%>
	    	 <%=equipmentAmcObj.getId()%>><%=equipmentAmcObj.getBalanceBillAmount()%>
    	   
       <%}
         }
     %>
   </div>
    --%> 
<div class="clear"></div>
<div class="clear"></div>
