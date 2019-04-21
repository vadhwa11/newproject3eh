<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StoreReTenderProposal"%>
<%@page import="jkt.hms.util.Box"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>


<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> cancelMap = new HashMap<String,Object>();
	Map<String,Object> remarksMap = new HashMap<String,Object>();
	;

	
	List objectList = new ArrayList();
	List poList = new ArrayList();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}
 	
  	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("objectList")!=null)
			objectList = (List)map.get("objectList");
		
		if (map.get("poList")!=null)
			poList = (List)map.get("poList");
		
		if (map.get("cancelMap")!=null)
			cancelMap = (Map)map.get("cancelMap");

		if (map.get("remarksMap")!=null)
			remarksMap = (Map)map.get("remarksMap");
	}
	
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

%>

<title>Supply Order - Split Up</title>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="../style/pdb_style.css" rel="stylesheet" type="text/css" />
<script>

function selectAll()
{
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
	{
		 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
	 	 {
	  	 	ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked = true;
	 	 }
	}
	else
	{
		ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked = true;
	}
}

function validateAddButton()
{
var net_amount = parseFloat(0);
var check = false;
var delivary = document.getElementById('delivery').value;
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
				  	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
				  	 var amount = parseFloat(0);
				  	 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
				  	 net_amount = net_amount + parseFloat(cal)
				    check = true;	
				  	 }
			 	 }
			}
			else
			{
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				   var amount = parseFloat(0);
				   var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				  	 net_amount = net_amount + parseFloat(cal)
				  check =true;
				 // return true;
				}
			}
			
		if(check){
		if(delivary != ""){
	 	  if(confirm("Total Amount is : "+net_amount+"\nAre You Sure,You want Generate SO ? ")){
		    return true;
		  }else{
			return false;
		  }
		}else{
		   alert("Delivery Date should not be blank !!!")
		   document.getElementById('delivary').focus();
		   return false;
		}  
	   }else{
	      alert('No Item(s) Selected to Generate SO!....');
	      return false;
	   }	
	}
	return false;
}
function roundVal(val,dec){
	var result = Math.round(val*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
}
function gettotalAmt(){
var net_amount = parseFloat(0);
if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length)
			{
			var check = true;
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.length; i++)
			 	 {
				 	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>[i].checked == true){
					  	 var amount = parseFloat(0);
					  	 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>[i].value 
					  	 net_amount = net_amount + parseFloat(cal)
					  	 document.getElementById('totalAmt').value = roundVal(net_amount,3);
					        check = false;
	        		 }
	        	 }
			 	  if(check){
        		 	   net_amount = parseFloat(0);
						document.getElementById('totalAmt').value = net_amount;
        		  }
			}
			else
			{ 
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_ADDED%>.checked == true){
				 var amount = parseFloat(0);
				 var cal = ReTenderReSupplyOrderForm.<%=AMOUNT_FOR_CAL%>.value 
				 net_amount = net_amount + parseFloat(cal)
				document.getElementById('totalAmt').value = roundVal(net_amount,3);
				}else{
		          net_amount = parseFloat(0);
				document.getElementById('totalAmt').value = net_amount;
				}
			}
   }else {
      document.getElementById('totalAmt').value = net_amount;
   }
}


function generateLPO()
{
		if (validateAddButton())
		{
			ReTenderReSupplyOrderForm.method="post";	
			submitForm('ReTenderReSupplyOrderForm','tender?method=generateReTenderReLocalPurchaseOrder');
		}
}

function printLPO()
{
		if (ReTenderReSupplyOrderForm.<%=PO_NO%>.value!="")
		{
			ReTenderReSupplyOrderForm.method="post";	
			submitForm('ReTenderReSupplyOrderForm','tender?method=printLocalSupplyOrder');
		}
}


function validateCancelButton()
{
	if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>)
	{
			if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length)
			{
				 for(var i = 0; i < ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 	 {
			  	 if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 	 }
			}
			else
			{
				if (ReTenderReSupplyOrderForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
				return true;
			}
	}
	return false;
}

function jsClose()
{
  self.close();
}



</script>
</head>
<div id="contentspace">
<form name="ReTenderReSupplyOrderForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="numOfRows" size="5" value="15"><input
	type="hidden" name="pageCount" size="5" value="10"><input
	type="hidden" name="search" size="5" value="true"><input
	type="hidden" name="tender_id" size="5"
	value="<%=box.get("tender_id")%>"><input type="hidden"
	name="dept_id" size="5" value="<%=box.get("dept_id")%>"><input
	type="hidden" name="supplier_id" size="5"
	value="<%=box.get("supplier_id")%>"><input type="hidden"
	name="group_id" size="5" value="<%=box.get("group_id")%>"><input
	type="hidden" name="<%=PROPOSAL_ID%>" size="5"
	value="<%=box.get("proposal_id")%>"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"><input
	type="hidden" name="<%=CHANGED_BY%>" size="5" value="<%=userName%>"><input
	type="hidden" name="<%=CHANGED_DATE%>" size="5" value="<%=date%>"><input
	type="hidden" name="<%=CHANGED_TIME%>" size="5" value="<%=time%>">
<% if (objectList!=null && objectList.size() >0) {
			Object obj[] = (Object[]) objectList.get(0); 
		%>
<h2><%=obj[0].toString() %></h2>
<% } %> <%		
		if (objectList==null) {
		%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 100%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Tender
			Qty</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Disp.Type</label></td>
			<td width="10%"><label valign="left" class="smalllabel">MDQ</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Rate/MDQ</label></td>
			<!--
				      <td width="15%"><label valign="left" class="smalllabel">Unit Rate</label></td>
				      -->
			<td width="15%"><label valign="left" class="smalllabel">Amount</label></td>
			<td width="15%"><label valign="left" class="smalllabel">SO</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<input type="button" name="Close" onClick="jsClose()" value="Close"
	class="button" /> <%  } else { %>

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Item Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: scroll; width: 100%; height: 300px; BORDER: #202020 1px solid;">
<table align="center" width="100%" colspan="7" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">

	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Tender
			Qty</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Disp.Type</label></td>
			<td width="10%"><label valign="left" class="smalllabel">MDQ</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Rate/MDQ</label></td>
			<!--<td width="15%"><label valign="left" class="smalllabel">Unit Rate</label></td>
				      -->
			<td width="15%"><label valign="left" class="smalllabel">Amount</label></td>
			<td width="15%"><label valign="left" class="smalllabel">SO</label></td>
		</tr>
	</thead>
	<tbody>

		<%
			    int slno=0; 
			    for (Iterator iterator = objectList.iterator(); iterator.hasNext();) 
			    {
			    	Object[] obj = (Object[]) iterator.next();
			    	int item_id = (Integer)obj[10];
			    %>
		<tr>
			<td><%=++slno%></td>
			<td><input type="text" value="<%=obj[1]%>" class="medcaption"
				readonly="readonly" title="<%=obj[2]%>"></td>
			<td><%=obj[3]%></td>
			<td><%=obj[4]%></td>
			<td><%=obj[5]%></td>
			<td><%=obj[6]%></td>
			<!--<td><%=obj[7]%></td>
				-->
			<td><%=obj[8]%></td>
			<% if (obj[12]!=null) { %>
			<td><input type="text" value="Re-SO Raised" class="medcaption"
				readonly="readonly"></td>
			<% } else { %>
			<td><input type="checkbox" name="<%=ITEMS_TO_BE_ADDED%>"
				value="<%=obj[10]%>" onclick="gettotalAmt();" class="smcaption"></td>
			<input type="hidden" id="<%=AMOUNT_FOR_CAL%>"
				name="<%=AMOUNT_FOR_CAL%>" value="<%=obj[8]%>" class="smcaption">
			<%}%> <% } %>
			
		</tr>
	</tbody>
</table>
</div>
<div><br />
<table>
	<tr>
		<td><select name="<%=PO_NO%>">
			<%
				 for (Iterator iterator = poList.iterator(); iterator.hasNext();) 
			     {
			    	String obj =  (String)iterator.next();
				 %>

			<option value=<%=obj%>><%=obj%></option>
			<%
					}
				%>
		</select></td>
		<td><input type="button" name="Add" onClick="printLPO()"
			value="Print SO" class="button" /></td>
		<% } %>
		<td><input type="button" name="sel" onClick="selectAll()"
			value="Select All" class="button" /></td>
		<td><input type="text" name="delivery" readonly id="delivery"
			value="" title="Delivery Date"
			style="height: 24px; background-color: #D5DDE6; width: 80px; Border: 5px; color: red;" />
		</td>
		<td><img id="calendar" src="/hms/jsp/images/cal.gif" width="16"
			title="Delivery Date" height="16" border="0" validate="Pick a date"
			class="calender"
			onClick="setdate('',document.ReTenderReSupplyOrderForm.<%="delivery"%>,event)" />
		</td>
		<td><input type="button" name="Add" onClick="generateLPO()"
			value="Generate SO" class="button" /></td>
		<td><input type="button" name="Close" onClick="jsClose()"
			value="Close" class="button" /></td>
		<td><input type="text" name="totalAmt" disabled id="totalAmt"
			style="height: 24px; background-color: #D5DDE6; Border: none; font-weight: bold; font-size: 15px; color: red;"></td>
	</tr>
</table>
</div>
</div>
</form>
