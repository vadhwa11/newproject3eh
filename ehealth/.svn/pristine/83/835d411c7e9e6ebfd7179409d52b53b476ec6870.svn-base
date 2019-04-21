<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%

	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> itemBatchList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	int inpatientId = 0;
	if(map.get("inpatientId") !=null){
		inpatientId=(Integer)map.get("inpatientId");
	}
	String adNo="";
	if(map.get("adNo") !=null){
		adNo=(String)map.get("adNo");
	}
	int hinId=0;
	if(map.get("hinId") !=null){
		hinId=(Integer)map.get("hinId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Box box =HMSUtil.getBox(request);
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	int rowVal = 0;
	if(map.get("rowVal") !=null){
		rowVal=Integer.parseInt((String)map.get("rowVal"));
	}
%>
<div class="titleBg">
<h2>Other Items</h2>
</div>

<form name="otherItemForFinalBill" action="" method="post">
<input type="hidden" value="<%= inpatientId%>" name="<%=INPATIENT_ID %>" id="inpatientId"/>
<input type="hidden" value="<%=box.get("adNo") %>" name="<%=AD_NO%>" id="adNo"/>
<input type="hidden" value="<%= box.get("hinId")%>" name="<%=HIN_ID%>" id="hinId"/>
<input type="hidden" value="<%= box.get("hinNo")%>" name="<%=HIN_NO%>" id="hinNo"/>
<input type="hidden" value="<%=box.get("age")%>"  name="<%=AGE %>" id="age"/> 
<input type="hidden" value="<%=box.get("sexId")%>" name="<%=SEX_ID %>"  /> 
<input type="hidden" value="<%=box.get("patientName")%>" name="<%=PATIENT_NAME %>"  /> 
<input type="hidden" name="ConsultId" value="<%=box.get("ConsultId") %>"/>
<input type="hidden" name="patientTypeId" value="<%=box.get("patientTypeId") %>"/>
<%if(!box.get("companyId").equals("")){ %>
<input type="hidden" name="companyId" value="<%=box.get("companyId") %>"/><%} %>
<input type="hidden" value="<%=box.get("changed_date")%>" name="<%=CHANGED_DATE %>"  /> 
<input type="hidden" value="<%=box.get("changed_time")%>" name="<%=CHANGED_TIME %>"  /> 

<div class="clear"></div>
<input type="button" class="buttonDel" tabindex="3" value=""	onclick="removeRowOtherItem();" align="right" />
<input type="button" class="buttonAdd" tabindex="4" onclick="addRowOtherItem();" value="" align="right" />
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="othergrid">
	<tr>
		<th>Item Name</th>
		<th>Batch</th>
		<th>Quantity</th>
		<th>Rate</th>
		<th>Expiry Date</th>
		<th>Amount</th>
	</tr>
	<tr>
	<%
		int inc = 1;
	%>
	<td><input type="text" value="" id="item<%=inc%>" size="30" name="item<%=inc%>"  tabindex="5" />
		</td>
	<td><input type="text" value="" id="batch<%=inc%>" name="batch<%=inc%>" size="10"  tabindex="5" /></td>
	<td><input type="text" value="" id="qty<%=inc%>" name="qty<%=inc%>" size="10"  tabindex="5" 
					onblur="calculateAmount(<%=inc%>);"/></td>
	<td><input type="text" value="" id="rate<%=inc%>" name="rate<%=inc%>" size="10"  tabindex="5" 
					onblur="calculateAmount(<%=inc%>); totalCost();"/></td>
	<td><input type="text" value="" id="expDate<%=inc%>" name="expDate<%=inc%>" size="10"  tabindex="5" />
	 <img id="calId<%=inc %>" src="/hms/jsp/images/cal.gif" width="16" 	height="16" border="0" 
		  validate="Pick a date" class="calender"
			onclick="setdate('<%=date %>',document.getElementById('expDate<%=inc %>'),event);" /></td>
	<td><input type="text" value="" id="amount<%=inc%>" name="amount<%=inc%>" size="10"  tabindex="5" 
									readonly="readonly"/></td>
	</tr>
	</table>
	<input type="hidden" name="hiddenValue" value="1" id="hiddenValue" />
	<input type="text" id="totalCostDisId" name="totalAmount" value="0" readonly="readonly" />
	<input type="hidden" id="totalQtyDisId" name="totalQuantity" value="0" readonly="readonly" />
	
	<input name="Submit11" type="button" tabindex="9"  align="right" class="button" value="Submit"	
		onclick="window.opener.totalGrossDisCost();submitForm('otherItemForFinalBill','billing?method=submitOtherItemFinalBill');window.close();" />
	<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" />
	<input type="button" name="close" value="Close" class="button" onclick="window.close();" />
	<div class="clear"></div>
	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	<script>
	function removeRowOtherItem()
	{
	  var tbl = document.getElementById('othergrid');
	  var lastRow = tbl.rows.length;

	  if (lastRow > 2){
	   tbl.deleteRow(lastRow - 1);
	   }
	  var hiddenValue = document.getElementById('hiddenValue');

	  hiddenValue.value=hiddenValue.value-1

	}
	function addRowOtherItem(){
		  var tbl = document.getElementById('othergrid');
		  var lastRow = tbl.rows.length;

		  // if there's no header row in the table, then iteration = lastRow + 1
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hiddenValue = document.getElementById('hiddenValue');
		  iteration = parseInt(hiddenValue.value)+1;
		  hiddenValue.value=iteration;


		  var cellRight0 = row.insertCell(0);
		  var e0 = document.createElement('input');
		  e0.type = 'text';
		  e0.name='item'+iteration;
		  e0.id='item'+iteration;
		  e0.size='30'
		  cellRight0.appendChild(e0);

		  var cellRight1 = row.insertCell(1);
		  var e1 = document.createElement('input');
		  e1.name='batch'+iteration;
		  e1.id='batch'+iteration;
		  e1.size='10'
		  cellRight1.appendChild(e1);


		  var cellRight2 = row.insertCell(2);
		  var e2 = document.createElement('input');
		  e2.name='qty'+iteration;
		  e2.id='qty'+iteration;
		  e2.size='10'
		  e2.onblur=function(){
			  calculateAmount(iteration);totalCost();
		  };
		  cellRight2.appendChild(e2);


		  var cellRight3 = row.insertCell(3);
		  var e3 = document.createElement('input');
		  e3.type = 'text';
		  e3.name='rate'+iteration;
		  e3.id='rate'+iteration;
		  e3.size='10'
		  e3.onblur=function(){
			  calculateAmount(iteration);totalCost();
		  };
		 cellRight3.appendChild(e3);


		 var cellRight4 = row.insertCell(4);
		 var e4 = document.createElement('input');
		 e4.type = 'text';
		 e4.name='expDate'+iteration;
		 e4.id='expDate'+iteration;
		 e4.size='10'

		 var eImg = document.createElement('img');
			eImg.src = '/hms/jsp/images/cal.gif';
			eImg.class = 'calender';
			eImg.id = 'calId'+iteration;
			eImg.onclick = function(event){
							setdate('',document.getElementById('expDate'+iteration),event) };
			cellRight4.appendChild(e4);
			cellRight4.appendChild(eImg);

		 var cellRight5 = row.insertCell(5);
		 var e5 = document.createElement('input');
		 e5.type = 'text';
		 e5.name='amount'+iteration;
		 e5.id='amount'+iteration;
		 e5.size='10'
		 cellRight5.appendChild(e5);
	}


	function calculateAmount(inc){
		var qtyObj = document.getElementById('qty'+inc).value;
		var rateObj =document.getElementById('rate'+inc).value;
		var amount = 0;
		amount = parseFloat(qtyObj)*parseFloat(rateObj);
		document.getElementById('amount'+inc).value=amount;
	}

	function totalCost(){
		var amt = 0;
		var qty = 0;
		var count = document.getElementById('hiddenValue').value;
		for(var i=1; i<=count; i++){
			var totalAmt = eval(document.getElementById("amount"+i));
			var totalQty = eval(document.getElementById("qty"+i));

			if(totalQty !=null ){
				if(validateInteger(totalQty.value)){
					if(totalQty.value != ""){
						qty = parseInt(qty)+parseInt(totalQty.value);
					}
				}else{
					alert("Please enter valid Quantity value.\n");
					document.getElementById("qty"+i).value = "";
					return false;
				}
			}
			if(totalAmt !=null ){
			if(validateFloat(totalAmt.value)){
				if(amt != 0 && totalAmt.value != ""){
					amt = parseInt(amt)+parseInt(totalAmt.value);
				}else if(amt == 0 && totalAmt.value != ""){
					amt = parseInt(totalAmt.value);
				}
			}else{
				alert("Please enter valid Amount value.\n");
				document.getElementById("amount"+i).value = "";
				return false;
			}
		}
		}
		document.getElementById('totalQtyDisId').value = qty;
		document.getElementById('totalCostDisId').value = amt;
	}


	function setQtyCostInParentDis(){
		if(document.getElementById('totalQtyDisId') != null){
			window.opener.document.getElementById('totalQtyDisId<%=rowVal%>').value = 
				document.getElementById('totalQtyDisId').value;
			}
		if(document.getElementById('totalCostDisId') != null){
			window.opener.document.getElementById('totalCostDisId<%=rowVal%>').value = 
			document.getElementById('totalCostDisId').value;
		}
		window.opener.document.getElementById('totalAmtId').focus();
		return true;
	}
	</script>