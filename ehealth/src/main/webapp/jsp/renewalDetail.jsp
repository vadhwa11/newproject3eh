
<%@page import="jkt.hms.masters.business.MasInsuranceCompany"%>
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
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<!-- <script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
 -->
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dates=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(dates.length()<2){
		dates="0"+dates;
	}
%>
serverdate = '<%=dates+"/"+month1+"/"+year1%>'
</script>
<%

Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String currentTime = (String)utilMap.get("currentTime");


%>
<%
Map<String,Object> map = new HashMap<String,Object>();
List<PrqInsuranceDetails> insuranceDetails=new ArrayList<PrqInsuranceDetails>();
List<MasInsuranceCompany> insuranceCompanies=new ArrayList<MasInsuranceCompany>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}

if (map.get("insuranceDetails")!= null){
	insuranceDetails = (List<PrqInsuranceDetails>)map.get("insuranceDetails");
}
if (map.get("insuranceCompanies")!= null){
	insuranceCompanies = (List<MasInsuranceCompany>)map.get("insuranceCompanies");
}
%>
<div class="clear"></div>
<form name="renewalDetails"  method="post" action="" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<h2>RENEWEL DETAILS</h2>
<div class="Block">
<label> Asset Code</label> 
<input type="text" name="assetCode" id="assetCode" value="<%=insuranceDetails.get(0).getAsset()!=null ? insuranceDetails.get(0).getAsset().getAssetCode():"" %>"  class="textbox_size20"  MAXLENGTH="32" tabindex="1"/> 


<label>Asset Name</label>
<input type="text" name="assetName" id="assetName" value="<%=insuranceDetails.get(0).getAsset()!=null ? insuranceDetails.get(0).getAsset().getAssetName():"" %>"  class="textbox_size20"  MAXLENGTH="32" tabindex="1"/> 
<div class="clear"></div>
<label>Policy No.</label>
<input type="text" name="policyNo." id="policyNo." value=""  class="textbox_size20"  MAXLENGTH="32" tabindex="1"/> 

<label>Insurance Company</label> 
<select name="insuranceComp">
<option value="">Select</option>
<%for(MasInsuranceCompany comp:insuranceCompanies){ %>
	<option value="<%=comp.getId()%>"><%=comp.getCompanyName()%></option>
	<%} %>
	</select>
<div class="clear"></div>


<label> Date of insurance</label> 
<input type="text" name="insuranceDetailDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.renewalDetails.insuranceDetailDate,true);" />
 
 <label>Insurance End date</label> 
<input type="text" name="insuranceEndDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.renewalDetails.insuranceEndDate,true);" />
 
<div class="clear"></div>

 <label>Insurance Due date</label> 
<input type="text" name="insuranceDueDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.renewalDetails.insuranceDueDate,true);" />
 
<label>Renewal Amount</label> 
<input type="text" name="renewalAmt" value=""  maxlength="30" tabindex=1 />

<div class="clear"></div>
<label>Renewal days</label> 
<select name="renewaDays" id="renewaDays" tabindex="1" >

<option value="0">Select</option>
<option value="10">10 Days</option>
<option value="20">20 days</option>
<option value="30">30 Days</option>
</select>
<input type="hidden" name="AssetId" value="<%=insuranceDetails.get(0).getAsset().getId() %>"/>
<div class="clear"></div>

</div>

<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>

<input type="button" name="add" id="addbutton"	value="Submit" class="button" onClick="submitForm('renewalDetails', 'procurement?method=submitrenewalInsuranceDetails')"	accesskey="a" tabindex="1" />
<input type="reset" name="add" id="addbutton"	value="Reset" class="button" onClick="" accesskey="g" tabindex="1" />	
<input type="button" value="Back" class="button" onclick="javascript: history.go(-1);">	
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">


<div class="Clear"></div>

</form>
