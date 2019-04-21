<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * administrativeSex.jsp  
 * Purpose of the JSP -  
 * @author  Dipali
 * @author  Vishal
 * Create Date: 14th April,2009 
 * Revision Date:      
 * Revision By:
 * @version 1.4  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BlPackageServicesDetails"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>

<%
	Map map = new HashMap();
	List<BlPackageServicesDetails> packageServicesList = new ArrayList<BlPackageServicesDetails>();
	List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeList = new ArrayList<MasSubChargecode>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	if(map.get("packageServicesList") != null){
		packageServicesList = (List<BlPackageServicesDetails>)map.get("packageServicesList");
	}
	if(map.get("mainChargeList") != null){
		mainChargeList = (List<MasMainChargecode>)map.get("mainChargeList");
	}
	if(map.get("subChargeList") != null){
		subChargeList = (List<MasSubChargecode>)map.get("subChargeList");
	}
	if(map.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)map.get("chargeCodeList");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	int packageId = 0;
	if(map.get("packageId") != null){
		packageId = (Integer)map.get("packageId");
	}
	String code = "";
	String desc = "";
	if(map.get("packageCode") != null){
		code = (String)map.get("packageCode");
	}
	if(map.get("packageDesc") != null){
		desc = (String)map.get("packageDesc");
	}
	%>
<% 
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<h4><span><%=message %></span></h4>
<% 		   
		   		  }
	%>

<div class="clear"></div>
<div class="titleBg">
<h2>Package Services</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript">
 
 formFields = [
   [0, "<%= PACKAGE_SERVICE_ID%>", "id"], [1,"<%= MAIN_CHARGECODE_ID%>"], [2,"<%= SUB_CHARGECODE_ID %>"], [3,"<%= CHARGE_CODE_ID %>"], [4,"<%= QUANTITY %>"], [5,"<%= AMOUNT %>"], [6,"<%= DISCOUNT_TYPE %>"], [7,"<%= DISCOUNT_PERCENTAGE %>"], [8,"<%= DISCOUNT_VALUE %>"], [9,"<%= CHANGED_BY %>"], [10,"<%= CHANGED_DATE %>"],[11,"<%=CHANGED_TIME %>"],[12,"<%=DISCOUNT_AMOUNT %>"],[13,"<%=STATUS%>"],[14,"prevDiscountValue"],[15,'prevDiscountAmount'],[16,'prevChargeAmount'] ];
  statusTd = 13;
 </script></div>

<form name="packageServices" method="post" action="">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><input type="hidden"
	name="<%=PACKAGE_SERVICE_ID %>" value="" /> <input type="hidden"
	name="<%=PACKAGE_ID %>" value="<%=packageId %>" /> <label>Package
Code</label> <input type="text" name="<%=PACKAGE_CODE %>" value="<%=code %>"
	class="readOnly" /> <label>Package Description</label> <input
	type="text" name="<%=PACKAGE_DESCRIPTION%>" value="<%=desc %>"
	class="readOnly" />

<div class="clear"></div>
<label>Main Charge</label> <select name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubChargeCode(this.value,'packageServices')">
	<option value="0">Select</option>
	<%
		for(MasMainChargecode mainChargecode : mainChargeList){
	%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName() %></option>
	<%} %>
</select> <script type="text/javascript">
        
		<%
			int count = 0;
			for (MasMainChargecode masMainChargecode :mainChargeList) 
			{
				
				for (MasSubChargecode masSubChargecode :subChargeList) 
				{
					if(masMainChargecode.getId().equals(masSubChargecode.getMainChargecode().getId())){
								%>
									subChargeArray1[<%=count%>] = new Array();
									subChargeArray1[<%=count%>][0] = <%=masMainChargecode.getId()%>;
									subChargeArray1[<%=count%>][1] = <%=masSubChargecode.getId()%>;									
									subChargeArray1[<%=count%>][2] = "<%=masSubChargecode.getSubChargecodeName()%>";
							
								<%
								count++;
						}	} } %>
		</script> 
<label>Sub Charge</label> 
<select name="<%=SUB_CHARGECODE_ID %>"
	onchange="populateCharge(this.value,'packageServices');">
	<option value="0">Select</option>
	<%
		for(MasSubChargecode subChargecode : subChargeList){
	%>
	<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
	<%} %>
</select> 
<script type="text/javascript">
        
		<%
			int count1 = 0;
			for (MasSubChargecode masSubChargecode :subChargeList) 
			{
				
				for (MasChargeCode masChargeCode : chargeCodeList) 
				{
					if(masSubChargecode.getId().equals(masChargeCode.getSubChargecode().getId())){
								%>
									chargeCodeArray[<%=count1%>] = new Array();
									chargeCodeArray[<%=count1%>][0] = <%=masSubChargecode.getId()%>;
									chargeCodeArray[<%=count1%>][1] = <%=masChargeCode.getId()%>;									
									chargeCodeArray[<%=count1%>][2] = "<%=masChargeCode.getChargeCodeName().replace("\"", "")%>";  
									/* Changed by Amit Das on 08-03-2016 */
								<%
								count1++;
						}	} } %>
</script> 
 <script type="text/javascript">
  	var chargeAmtArray = new Array();
 </script> 
  
<label><span>*</span> Charge Code</label> <select
	name="<%=CHARGE_CODE_ID %>" onchange="displayChargeAmount(this.value);">
	<option value="0">Select</option>
	<%
	int i=0;
		for(MasChargeCode chargeCode : chargeCodeList){
	%>
	<script type="text/javascript">
			chargeAmtArray[<%=i%>] = new Array();
			chargeAmtArray[<%=i%>][0] = <%=chargeCode.getId()%>;
			chargeAmtArray[<%=i%>][1] = '<%=chargeCode.getCharge()%>';
			
	</script>
	<option value="<%=chargeCode.getId() %>"><%=chargeCode.getChargeCodeName() %></option>

	<%		i++;
				
			
	} %>
</select>


<div class="clear"></div>

<label><span>*</span> Quantity</label> <input type="text" id="qtyId"
	name="<%=QUANTITY %>" value=""
	onblur="calculateChargeAmount(this.value);" /> <label><span>*</span>
Charge Amount</label> <input type="text" id="chargeAmtId" name="<%= AMOUNT%>"
	value="" readonly="readonly" /> <input type="hidden" name="<%=RATE %>"
	id="rateId" /> 
	<%-- <label><span>*</span> Discount Type</label> <select
	name="<%=DISCOUNT_TYPE%>" id="discountTypeId"
	validate="Discount Type,string,yes" onchange="changeLabel(this.value)">
	<option value="">Select</option>
	<option value="D">Discount</option>
	<option value="T">Tariff</option>
</select>

<div class="clear"></div>
<label id="distrfPerLbl"><span>*</span> Discount(%)</label> <input
	type="text" name="<%=DISCOUNT_PERCENTAGE %>" id="discounPercentId"
	value="" validate="Discount percentage,float,yes"
	onblur="calculateDiscountAmt(this.value);" MAXLENGTH="3" tabindex=1 />
<label id="distrfValLbl">Discount Value</label> <input type="text"
	name="<%=DISCOUNT_VALUE %>" id="discountValId" value=""
	onblur="calculateDiscountPercent(this.value);"
	validate="Discount value,float,no" MAXLENGTH="9" tabindex=1 /> <label>Net
Amount</label> <input type="text" name="<%=NET_VALUE_SERVICES %>"
	id="discountAmtId" value="" readonly="readonly"
	onblur="calculateDiscountPercent(this.value);"
	validate="Discount value,float,no" MAXLENGTH="9" tabindex=1 /> <input
	type="hidden" name="prevDiscountValue" value="" /> <input
	type="hidden" name="prevDiscountAmount" value="" />  --%><input
	type="hidden" name="prevChargeAmount" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="Submit11" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('packageServices','packageBilling?method=savePackageServices');"
	accesskey="a" tabindex=1 /> <input type="button" name="Submit11"
	id="editbutton" value="Update" class="button" style="display: none;"
	onClick="submitForm('packageServices','packageBilling?method=updatePackageServices')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('packageServices','generalMaster?method=deleteAdministrativeSex&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="button"
	name="back" value="Back" class="button"
	onClick="submitFormCancel('packageServices','packageBilling?method=showBillingPackageListJsp')" />

<input type="hidden" name="<%=STATUS %>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Main Charge Code"
data_header[0][1] = "hide";
data_header[0][2] = "25%";
data_header[0][3] = "<%= MAIN_CHARGECODE_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Sub Charge Code"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SUB_CHARGECODE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Charge Code"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHARGE_CODE_ID %>"

data_header[3] = new Array;
data_header[3][0] = "Quantity"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= QUANTITY%>"

data_header[4] = new Array;
data_header[4][0] = "Amount"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%= AMOUNT%>";

data_header[5] = new Array;
data_header[5][0] = "Discount Type"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=DISCOUNT_TYPE %>";


data_header[6] = new Array;
data_header[6][0] = "Discount Percentage"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=DISCOUNT_PERCENTAGE %>";

data_header[7] = new Array;
data_header[7][0] = "Discount Amount"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=DISCOUNT_VALUE %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=CHANGED_BY %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=CHANGED_DATE %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=CHANGED_TIME %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%= DISCOUNT_AMOUNT%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "prevDiscountValue";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "prevDiscountAmount";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "prevChargeAmount";

data_arr = new Array();

<%
	int counter = 0;
	for(BlPackageServicesDetails packageServicesDetails : packageServicesList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= packageServicesDetails.getId()%>
<%
for(MasChargeCode masChargeCode : chargeCodeList){
	if(packageServicesDetails.getChargeCode().getId().equals(masChargeCode.getId())){
		for(MasMainChargecode mainChargecode : mainChargeList){
			if(masChargeCode.getMainChargecode().getId().equals(mainChargecode.getId())){
%>

data_arr[<%= counter%>][1] = "<%=mainChargecode.getMainChargecodeName()%>"
<%}
	}
	}
}%>
<%
for(MasChargeCode masChargeCode : chargeCodeList){
	if(packageServicesDetails.getChargeCode().getId().equals(masChargeCode.getId())){
	for(MasSubChargecode subChargecode : subChargeList){
		if(masChargeCode.getSubChargecode().getId().equals(subChargecode.getId())){
%>
data_arr[<%= counter%>][2] = "<%= subChargecode.getSubChargecodeName()%>"
<%}
	}
	}
}%>
<%
	for(MasChargeCode masChargeCode : chargeCodeList){
		if(packageServicesDetails.getChargeCode().getId().equals(masChargeCode.getId())){
%>
data_arr[<%= counter%>][3] = "<%=masChargeCode.getChargeCodeName() %>"
<%}
}%>
data_arr[<%= counter%>][4] = "<%= packageServicesDetails.getQuantity() %>"
data_arr[<%= counter%>][5] = "<%= packageServicesDetails.getChargeAmount() %>"
	<%if( packageServicesDetails.getDiscountType()  != null){%>
data_arr[<%= counter%>][6] = "<%= packageServicesDetails.getDiscountType() %>"
<%}%>
<%if( packageServicesDetails.getDiscountPercent()!= null){%>
data_arr[<%= counter%>][7] = "<%= packageServicesDetails.getDiscountPercent() %>"
	<%}%>
	<%if(packageServicesDetails.getDiscountAmount()!= null){%>
data_arr[<%= counter%>][8] = "<%= packageServicesDetails.getDiscountAmount() %>"
	<%}%>
	<%if(packageServicesDetails.getLastChgBy()!= null){%>
data_arr[<%= counter%>][9] = "<%= packageServicesDetails.getLastChgBy() %>"
	<%}%>
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(packageServicesDetails.getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= packageServicesDetails.getLastChgTime() %>"

	<%if( packageServicesDetails.getDiscountType()!= null){%>
<%
	if(packageServicesDetails.getDiscountType().equalsIgnoreCase("d")){
%>
	data_arr[<%= counter%>][12] = "<%= packageServicesDetails.getChargeAmount().subtract(packageServicesDetails.getDiscountAmount()) %>"
<%}else if(packageServicesDetails.getDiscountType().equalsIgnoreCase("t")){%>
	data_arr[<%= counter%>][12] = "<%= packageServicesDetails.getChargeAmount().add(packageServicesDetails.getDiscountAmount()) %>"
<%}}%>

<% if(packageServicesDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>

<%if(packageServicesDetails.getDiscountAmount()!= null){%>
data_arr[<%=counter%>][14] = "<%=packageServicesDetails.getDiscountAmount() %>";
<%}%>
<%if(packageServicesDetails.getNetChargeAmt()!= null){%>
data_arr[<%=counter%>][15] = "<%=packageServicesDetails.getNetChargeAmt() %>";
<%}%>
data_arr[<%=counter%>][16] = "<%=packageServicesDetails.getChargeAmount() %>";
<%
       counter++;
}
%>
 
formName = "packageServices"

nonEditable = ['<%= MAIN_CHARGECODE_ID%>','<%=SUB_CHARGECODE_ID%>','<%= CHARGE_CODE_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  


function displayChargeAmount(chargeId){
		
	for(var i=0;i<chargeAmtArray.length;i++){
		if(chargeId == chargeAmtArray[i][0]){
		
			document.getElementById('chargeAmtId').value = chargeAmtArray[i][1]; 
			document.getElementById('qtyId').value = '1'; 
			document.getElementById('rateId').value = chargeAmtArray[i][1]; 
			break;
		}
	}

}

function calculateChargeAmount(qty){
	var charge = 0;
	if(qty != ""){
		if(validateInteger(qty)){
			charge = document.getElementById('chargeAmtId').value;
				document.getElementById('chargeAmtId').value = (parseFloat(qty)*parseFloat(charge)).toFixed(2);
		}else{
			alert("Qunatity should be integer.");
			return false;
		}
	}
}

function calculateDiscountAmt(disPercent){
	var charge = 0;	
	var disAmt= 0;
	charge = document.getElementById('chargeAmtId').value;
	if(disPercent != ""){
		if(validateFloat(disPercent)){
			disAmt = parseFloat(charge)*parseFloat(disPercent)/100;
			document.getElementById('discountValId').value = disAmt.toFixed(2);
			if(document.getElementById('discountTypeId').value == "D"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(disAmt.toFixed(2));
			}else if(document.getElementById('discountTypeId').value == "T"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(disAmt.toFixed(2));
			}
		}else{
			alert("Discount Amount should be integer or decimal.");
			return false;
		}
	}

}

function calculateDiscountPercent(disAmt){
	var charge = 0;	
	var disPercent= 0;
	charge = document.getElementById('chargeAmtId').value;
	if(disAmt != ""){
		if(validateFloat(disAmt)){
			disPercent = parseFloat(disAmt)*100/parseFloat(charge);
			document.getElementById('discounPercentId').value = disPercent;
			if(document.getElementById('discountTypeId').value == "D"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(disAmt.toFixed(2));
			}else if(document.getElementById('discountTypeId').value == "T"){
				document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(disAmt.toFixed(2));
			}
		}else{
			alert("Discount Percent should be integer or decimal.");
			return false;
		}
	}


}


function changeLabel(distype){
	if(distype != ""){
		if(distype == "D"){
			document.getElementById('distrfPerLbl').innerHTML = 'Discount (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Discount Value';
		}else if(distype == "T"){
			document.getElementById('distrfPerLbl').innerHTML = 'Tariff (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Tariff Value';
		}
		
	var charge = 0;	
	charge = document.getElementById('chargeAmtId').value;
	
	if(distype == "D"){
		document.getElementById('discountAmtId').value = parseFloat(charge)	- parseFloat(document.getElementById('discountValId').value);
	}else if(distype == "T"){
		document.getElementById('discountAmtId').value = parseFloat(charge)	+ parseFloat(document.getElementById('discountPercentId').value);
	}
			
	}

}
</script>