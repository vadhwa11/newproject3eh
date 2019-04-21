<%@page import="jkt.hms.masters.business.MasInsuranceCompany"%>
<%@page import="jkt.hms.masters.business.PrqAssetDetails"%>
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
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<PrqAssetDetails> assetDetails=new ArrayList<PrqAssetDetails>();
	List<MasInsuranceCompany> insuranceDetails=new ArrayList<MasInsuranceCompany>();
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
	 if(map.get("insuranceDetails")!=null)
	   {
		 insuranceDetails=(List<MasInsuranceCompany>)map.get("insuranceDetails");
	   } 
	 if(map.get("prqInsuranceDetails")!=null)
	   {
		 assetDetails=(List<PrqAssetDetails>)map.get("prqInsuranceDetails");
	   } 
	 
       System.out.println("jsp"+insuranceDetails.size());
	%>

<div class="titleBg">
<h2>Insurance Detail</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>

<label>Asset Code</label>
<input type="text" name="assetCode" value=""	tabindex=1   id="assetCode" validate="Asset Code,String,no" />

<label>Asset Name </label>
<input type="text" name="assetname" value=""	tabindex=1   id="assetname" />

<label>Insurance Detail Date </label>
<input type="text" name="insuranceDetailDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.insuranceDetailDate,true);" />

<!-- <label>Catogery</label>
<td>
<select name="catogery">
<option value="0">Select</option>
<option value="1">movable</option>
<option value="2">Immovable</option>
</select>
</td> -->
<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('searchPanel', 'procurement?method=showInsuranceDetailJsp')"; />



</form>
</div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h4>Asset Detail</h4>
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
<%

int i=1;

	%>
	<thead>
		<tr>
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
				for (PrqAssetDetails st : assetDetails) { %>
		<tr>
			<td><%=i %></td>
			<td><%=st.getAssetCode()!=null ? st.getAssetCode() :""  %></td>
			<td><%=st.getAssetName()!=null ? st.getAssetName():""%></td>
			<td><%=st.getModalNo()!=null ? st.getModalNo():"" %></td>
			<td></td>
			<td><%=st.getManufacturer()!=null ?st.getManufacturer().getManufacturerName():""  %></td>
			<td><input type="hidden" name="assetId" value=<%=st.getId()%>></input></td>
		</tr>
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
<div class="clear"></div>	
<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Insurance Company</th>
			<th width="13%">Address</th>
			<th width="10%">Contact No.</th>
			<th width="10%">Policy No.</th>
			<th width="10%">Insurance Type</th>
			<th width="10%">Date of Insurance</th>
			<th width="10%">Ins. End date</th>
			<th width="10%">Premiumm</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<select name="insuranceCompany">
			<option value="0">Select</option>
			<%
		for (MasInsuranceCompany insuranceCompany : insuranceDetails) {
	       %>
	        <option value="<%=insuranceCompany.getId ()%>"><%=insuranceCompany.getCompanyName()%></option>
	      <%
		 }
        	%>
	
			</select>
			</td>
			<td>
			<input type="text" name="address" value=""	tabindex=1   id="address"  validate="Adress,String,yes"/>
			</td>
			<td>
			<input type="text" name="contactNo" value=""	tabindex=1  id="contactNo" validate="ContactNo.,int,yes" maxlength="12"/>
			</td>
			<td>
			<input type="text" name="policyNo" value=""	tabindex=1  id="policyNo" validate="policyNo.,String,yes" />
			</td>
			<td>
			<input type="text" name="insuranceType" value=""	tabindex=1  id="insuranceType"validate="Insurancetype.,String,yes"/>
			</td>
			<td>
			<input type="text" name="endOfInsurance"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 style="width:78px;"/>
			<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemGrid.dateOfInsurance,event);" />
			</td>
			<td>
			<input type="text" name="dateOfInsurance" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 style="width:78px;" />
			<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.itemGrid.dateOfInsurance,event);" />
			</td>
			<td>
			<input type="text" name="premiumm" value=""	tabindex=1   id="premiumm" validate="premium,int,yes"/>
			</td>
		</tr>
	</tbody>
</table>
</div>
<div class="paddingTop5"></div>
<div class="Block">
<label>Remarks</label>
<textarea rows="" cols="" name="remarks" class="comorBiditylarge"></textarea>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('itemGrid', 'procurement?method=submitInsuranceDetails')" />
<input type="reset" name="add" id="addbutton" value="Reset" class="button" onClick="" accesskey="a" tabindex=1 />

</form>
