<%@page import="jkt.hms.masters.business.PrqInsuranceDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'

function disableFun()
{//alert(document.getElementById("claimStatusID").value);
	if(document.getElementById("claimStatusID").value="close"){
		//alert();
		document.getElementById("disbursedAmount").setAttribute("disabled","disabled");
	}
	else{
		document.getElementById("disbursedAmount").setAttribute("enable","enable");
	}
// 	document.getElementById("priceprefrence").disabled = true;
}
</script>

<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqInsuranceDetails> assetDetails=new ArrayList<PrqInsuranceDetails>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	 if(map.get("prqInsuranceDetails")!=null)
	   {
		 assetDetails=(List<PrqInsuranceDetails>)map.get("prqInsuranceDetails");
	   } 
  //  System.out.println("jufrhufryh"+assetDetails.size());
	%>

<div class="titleBg">
<h2>Insurance Claim & Tracking</h2>
</div>
<div class="Block">
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label>Asset Code</label>
<input type="text" name="assetCode" value=""	tabindex=1   id="assetCode" />
<label>Asset Name </label>
<input type="text" name="assetname" value=""	tabindex=1   id="assetname" />

<%-- <label>Insurance Detail Date </label>
<input type="text" name="insuranceDetailDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.insuranceDetailDate,true);" />
 --%>
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('searchPanel', 'procurement?method=showInsuranceClaimAndTrackingJsp')"; />
</form>
</div>
<form name="itemGrid" method="post">
<div class="Block">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Asset Detail</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<%int i=1; %>
			<th width="13%">Sl No.</th>
			<th width="13%">Asset Code</th>
			<th width="10%">Asset Name</th>
			<th width="10%">Model No.</th>
			<th width="10%">Serial No.</th>
			<th width="10%">Manufacture</th>
		</tr>
	</thead>
	<tbody>
	 <% if (assetDetails.size() > 0) {
				for (PrqInsuranceDetails st : assetDetails) { %>
		<tr>
			<td><%=i %></td>
			<td><%=st.getAsset().getAssetCode()!=null ? st.getAsset().getAssetCode() :""  %></td>
			<td><%=st.getAsset().getAssetName()!=null ? st.getAsset().getAssetName():""%></td>
			<td><%=st.getAsset().getModalNo()!=null ? st.getAsset().getModalNo():"" %></td>
			<td></td>
			<td><%=st.getAsset().getManufacturer()!=null ?st.getAsset().getManufacturer().getManufacturerName():""  %></td>
			<input type="hidden" name="assetId" value="<%=st.getAsset().getId()%>"/>
		</tr>
			<%
		i++;
					}}%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<h4>Insurance Detail</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
		<%int i1=1; %>
		  <th>SI</th>
			<th>Insurance Company</th>
			<th>Address</th>
			<th>Contact No.</th>
			<th>Policy No.</th>
			<th>Insurance Type</th>
			<th>Date of Insurance</th>
			<th>Ins. End date</th>
			<th>Premiumm</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			 <% if (assetDetails.size() > 0) {
				for (PrqInsuranceDetails st : assetDetails) { %>
		<tr>
			<td><%=i1%></td>
			<td><%=st.getInsuranceCompany().getCompanyName()!=null ?st.getInsuranceCompany().getCompanyName() :""  %></td>
			<td><%=st.getAddress()!=null ? st.getAddress():""%></td>
			<td><%=st.getContactNo()!=null ? st.getContactNo():""%></td>
			<td><%=st.getPolicyNo()!=null ? st.getPolicyNo():"" %></td>
			<td><%=st.getInsuranceType()!=null ? st.getInsuranceType():""%></td>
			<td><%=st.getInsuranceDate()!=null ?st.getInsuranceDate():""  %></td>
			<td><%=st.getInsuranceEndDate()!=null ?st.getInsuranceEndDate():""  %></td>
			<td><%=st.getPremiumAmount()!=null ?st.getPremiumAmount():""  %></td>
			<input type="hidden" name="insuranceId" value="<%=st.getId()%>"/>
		</tr>
			</tr>
			<%
		i++;
					}}%>
		</tr>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<h4>Claim Detail</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="claimDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Claim Date</th>
			<th width="13%">Claim Type</th>
			<th width="10%">Claim Description</th>
			<th width="10%">Claim Amount</th>
			<th width="10%">Claim Status</th>
			<th width="10%">Claim Disbursement Date</th>
			<th width="10%">Disbursed Amount</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<input type="text" name="claimDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 readonly="readonly" />
			<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemGrid.claimDate,event);" />
			</td>
			<td>
			<select name="claimType" readonly="readonly" >
			<option value="0">Select</option>
			<option value="full">Full</option>
			<option value="partial">Partial</option>
			</select>
			</td>
			<td>
			<input type="text" name="claimDescription" value=""	tabindex=1   id="claimDescription"/>
			</td>
			<td>
			<input type="text" name="claimAmount" value=""	tabindex=1  id="claimAmount" validate="ClaimAmout,int,yes"/>
			</td>
			<td>
			<select name="claimStatus" readonly="readonly" id="claimStatusID" >
			<option value="0">Select</option>
			<option value="open">Open</option>
		     <option value="close">Close</option>
			</select>
			</td>
		   <td>
			<input type="text" name="claimDisbursementDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 readonly="readonly" />
			<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemGrid.claimDisbursementDate,event);" />
			</td>
			<td>
			<input type="text" name="disbursedAmount" value=""	tabindex=1   id="disbursedAmount" />
			</td>
		</tr>
	</tbody>
</table>
</div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<label>Remarks</label>
<textarea rows="" cols="" name="remarks" class="comorBiditylarge"></textarea>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onclick="submitForm('itemGrid', 'procurement?method=submitInsuranceClaimTracking')"; accesskey="a" tabindex=1 />
<input type="reset" name="add" id="addbutton" value="Reset" class="button" onClick="" accesskey="a" tabindex=1 />

</div>
</form>

