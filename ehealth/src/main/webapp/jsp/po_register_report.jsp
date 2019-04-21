
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript">
function checkk()
{
var SDate = document.poRegister.<%= FROM_DATE%>.value;
var EDate = document.poRegister.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
	if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
	getShadowWithObj(document.calldate.next_day);
//document.calldate.next_day.focus();
return false;
}
}


		function submitProtoAjaxWithDivNameToShowStatus(formName,action,divName){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)

		       	obj.action = action;
	    	   	var url=action+"&"+getNameAndData(formName)

	            var oOptions = {
	                asynchronous:true, evalScripts:true,
	                onFailure: function () {
	    	   		if(!displayAlert("An error occurred:"))
		    	   		alert("An error occurred:");
	                },
	                onLoaded : function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                },
	                onInteractive :function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                }
	               // onLoading : function () {
	               //    document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	               // }

	            }
	           } ;

</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();




	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	if(map.get("ponumberList") != null){
		poHeaderList =(List<StorePoHeader>) map.get("ponumberList");
	}


	if(map.get("supplierList") != null){
		supplierList =(List<MasStoreSupplier>) map.get("supplierList");
	}

	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>
<div class="titleBg">
<h2>PO Register Report</h2>
</div>
<form name="poRegister" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input 	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"
	class="date" validate="fromDate,date,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.poRegister.<%=FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> <input type="text"
	class="date" name="<%=TO_DATE%>" value="<%=currentDate%>"
	validate="toDate,date,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.poRegister.<%=TO_DATE%>,event);" />
<div class="clear"></div>

<label>Vendor Name </label>

<select name="<%= VENDOR_NAME%>"

	  onblur="submitProtoAjaxWithDivName('poRegister','purchaseOrder?method=getPONumberAgainstVendor','poNumberDiv')">
	<option value="">Select</option>

	<%for (MasStoreSupplier masStoreSupplier : supplierList) {%>
	<option value="<%=masStoreSupplier.getId()%>"><%=masStoreSupplier.getSupplierName() %></option>
	<%
	}
	%>
</select>

<div id='poNumberDiv'>
<label>PO Number </label>
<select name="ponumber">
	<option value="">Select</option>

	<%for (StorePoHeader poHeader :poHeaderList ) {%>
	<option value="<%=poHeader.getPoNumber()%>"><%=poHeader.getPoNumber() %></option>
	<%
	}
	%>
</select>
</div>
 
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report"
	class="buttonBig"
	onClick="submitForm('poRegister','purchaseOrder?method=generatePORegisterReport','checkk()');"
	accesskey="a" tabindex=1 />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
 