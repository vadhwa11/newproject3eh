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
<%@page import="jkt.hms.masters.business.MmAuctionParticipent"%>
<%@page import="java.math.BigDecimal"%>
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
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
	

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
		
		  
		window.onbeforeunload = closingCode;
		 
		 function closingCode(){
			 	var biddivId = document.getElementById("highestAmountDiv").value;
			 	var biddivValue = 	document.getElementById("maxBid").value;
			 	var bidderdivId = document.getElementById("highestBidderDiv").value;
			 	var bidderdivValue = 	document.getElementById("maxBidder").value;
				window.opener.setMaxBid(biddivId,biddivValue,bidderdivId,bidderdivValue);
		 }
	</script>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> storeInternalIndentTList = new ArrayList<Object[]>();
	List<MmAuctionParticipent> mmAutionParticipentList = new ArrayList<MmAuctionParticipent>();
	List<Object[]> maxAuctionParticipentList = new ArrayList<Object[]>();
	Box box = HMSUtil.getBox(request);
	

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("mmAutionParticipentList")!=null)
	{
		mmAutionParticipentList = (List<MmAuctionParticipent>)map.get("mmAutionParticipentList");
	}
	if(map.get("maxAuctionParticipentList")!=null)
	{
		maxAuctionParticipentList = (List<Object[]>)map.get("maxAuctionParticipentList");
	}
	
	
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	int requestId = 0;
	if(map.get("requestId") != null){
		requestId =(Integer)map.get("requestId");
	}
	String formNo = "";
	if(map.get("formNo") != null){
		formNo =(String)map.get("formNo");
	}
	 String message = "";
	 if(map.get("message") != null){
		 message =(String)map.get("message");
		}
	
%>
<form name="partyDetailForAuction" method="post">
<h4><span><%=message %> </span></h4>
<div class="titleBg">
<h2>Add Party Detail</h2>
</div>

<div class="Block">
<%if(mmAutionParticipentList.size()>0){ %>
	
<table>
	<tr><th>S.No.</th><th>Party Name</th><th>Amount</th></tr>
	
	<% 
		 int  counter=0;
		if (true) { %>
	<% 	for(MmAuctionParticipent auctionParticipent:mmAutionParticipentList){
	%>
	<tr>
			<td><%= counter+1%></td>
			<td><%=auctionParticipent.getPartyName()%></td>
			<td><%=(auctionParticipent.getAmount()!=null)?auctionParticipent.getAmount():0.00%></td>
	</tr>	    
<%		++counter;
				}

	    	}
	%>
 </table>
  <%} %>  
 </div>
<div class="Block">



<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
  <input type="hidden" name="requestId" value="<%=requestId%>" />
  <input type="hidden" name="formNo" value="<%=formNo%>" />
  
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table border="0" cellpadding="0" cellspacing="0" id="partyDetail">
	
					<tr>
						<th>Part Name</th>
						<th>Value</th>
						
						
					</tr>
					<%int i=1; %>
					<tr>
					
					<td><input name="partyName<%=i %>" id="partyNameId" value = ""/>
					<input type="hidden"  name="serviceId<%=i %>" value="<%=requestId %>"  id="serviceId" />
					<input type="hidden"  name="formNo<%=i %>" value="<%=formNo %>"  id="formNo" /></td>
					<td><input name="amount<%=i %>" id="amountId" value = ""/></td>
						
						
					</tr>
					
			</table>
			
			 <input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="clear"></div>
</div>

	 
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

<input name="highestBidderDiv" id="highestBidderDiv" value="<%=(String)map.get("highestBidderDiv")%>" type="hidden" />
<input name="highestAmountDiv" id="highestAmountDiv" value="<%=(String)map.get("highestAmountDiv")%>" type="hidden" />
<input name="maxBid" id="maxBid" value="<%=((maxAuctionParticipentList!=null && maxAuctionParticipentList.size()>0) && (maxAuctionParticipentList.get(0)!=null)) ? maxAuctionParticipentList.get(0)[0]:0.00%>" type="hidden" />
<input name="maxBidder" id="maxBidder" value="<%=((maxAuctionParticipentList!=null && maxAuctionParticipentList.size()>0) && (maxAuctionParticipentList.get(0)!=null)) ? maxAuctionParticipentList.get(0)[1]:""%>" type="hidden" />


<div class="clear"></div>
<input	type="button" name="Close" type="submit" value="Save" 	onClick="submitForm('partyDetailForAuction','maintenance?method=savePartyAuctionDetail');" class="button" />
<input	type="button" name="Close" type="submit" value="Close" 	onClick="window.close();" class="button" />

<script type="text/javascript">
function addRow(){
	  var tbl = document.getElementById('partyDetail');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	 var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='partyName'+iteration;
	  e1.id='partyNameId';
	  e1.size='28'
	 cellRight1.appendChild(e1);
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name='serviceId'+iteration;
	  e11.id='serviceId';
	  e11.size='28'
	  e11.value ='<%=requestId%>'
	 cellRight1.appendChild(e11);
	  var e12 = document.createElement('input');
	  e12.type = 'hidden';
	  e12.name='formNo'+iteration;
	  e12.id='formNo';
	  e12.size='28'
	  e12.value ='<%=formNo%>'
	 cellRight1.appendChild(e12);

	  var cellRight2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name = 'amount'+iteration;
	  e2.setAttribute('validate', 'Item Name,string,yes');
	  e2.id = 'amountId' + iteration;
	  e2.size = '30';
	  cellRight2.appendChild(e2);
	  
	}


function removeRow()
{
	var tbl = document.getElementById('blockDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
	if(tblRows.length-2==0){
       	alert("Can not delete all rows")
       	return false;
   }
	         
	for(abc=0;abc<document.getElementsByName('selectedEquipment').length;abc++)
	{
		if (document.getElementsByName('selectedEquipment')[abc].checked == true)
		{
		  	tbl.deleteRow(abc+1);
		}
	}
}

	function calculateTotalDemandedQty(){
		var count = 0;
		var demandedQty = 0;
		var totalDemandedQty = 0;
		count = document.getElementById('count').value;
			for(i=1; i<=count; i++){
				if(document.getElementById('qtyRequest'+i) != null){
					demandedQty = document.getElementById('qtyRequest'+i).value;
					totalDemandedQty = parseFloat(totalDemandedQty)+parseFloat(demandedQty);
				}
			}
			if(totalDemandedQty != 0){
			document.getElementById('totalDemandedQty').value = totalDemandedQty;
			}
	}

	

<%-- function setTotalDemandeQty(){
	var incrementQty= window.opener.document.getElementById('incrementalQtyId<%=rowVal%>').value;
	var consInLeadTime = window.opener.document.getElementById('consumptionInLeadTimeId<%=rowVal%>').value;
	var stock = window.opener.document.getElementById('stock<%=rowVal%>').value;
	var pendingIndentQuantity = window.opener.document.getElementById('pendingIndentQtyId<%=rowVal%>').value;
	var additionalQuantity = window.opener.document.getElementById('additionalQtyId<%=rowVal%>').value;
	var totalDemandQuantity = document.getElementById('totalDemandedQty').value;
	var newQtyRequired = 0;
	var newQtyDemanded = 0;
	
	if(incrementQty !="" && consInLeadTime!= "" && stock != "" && pendingIndentQuantity != "" && totalDemandQuantity != "" && additionalQuantity != ""){
		newQtyRequired =(parseFloat(totalDemandQuantity)+parseFloat(incrementQty)+parseFloat(consInLeadTime))-(parseFloat(stock)+parseFloat(pendingIndentQuantity));
		newQtyDemanded = parseFloat(newQtyRequired)+parseFloat(additionalQuantity);
		
	if(document.getElementById('totalDemandedQty') != null){
		window.opener.document.getElementById('requiredQtyId<%=rowVal%>').value = Math.round(parseFloat(newQtyRequired).toFixed(2));
		window.opener.document.getElementById('qtyRequest<%=rowVal%>').value = Math.round(parseFloat(newQtyDemanded).toFixed(2));
		
	}
	}else{
		if(document.getElementById('totalDemandedQty') != null){
			window.opener.document.getElementById('qtyRequest<%=rowVal%>').value =Math.round(parseFloat(totalDemandQuantity).toFixed(2));
		}
		
	}
} --%>



<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
