<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
 	if (map.get("masStoreGroupList") != null){
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
 	}
   }	
 	String message = null;
	
%>

<title>Supply Order Summary</title>

<script>

function showReport()
{
//if (SupplyOrderSummary.<%=FROM_DATE%>.value != "" || SupplyOrderSummary.<%=TO_DATE %>.value == "" )
//{
//alert('Pl. Check Your Inputs ');
//return;
//}

SupplyOrderSummary.method="post";
submitForm('SupplyOrderSummary','tender?method=generateSupplyOrderSummaryReport');
}
</script>
</head>

<body>
<form name="SupplyOrderSummary"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"> <input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"> <input
	type="hidden" name="date" size="5" value="<%=date%>"> <br />
<div id="contentspace">
<div style="float: left;">
<h2 align="left" class="style1">Supply Order Summary</h2>
</div>
<br />
<div style="padding-left: 15px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Supply Order Summary</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 660px; height: 150px; background-color: #f4f9fe;">
<br />


<label class="bodytextB">From Date:</label> <input type="text"
	id="FromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderSummary.<%=FROM_DATE%>,event)" />

<label class="bodytextB">To Date:</label> <input type="text"
	id="ToDateId" name="<%=TO_DATE %>" value="<%=currentDate %>"
	class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('',document.SupplyOrderSummary.<%=TO_DATE%>,event)" />
<br> <br />
<label class="bodytextB">Supply Order No. From </label> <input
	type="text" id="SoNFrom" name=<%=SUPPLYNOFROM%> value=""
	class="textbox_date" MAXLENGTH="30" /> <label class="bodytextB">Supply
Order No. To </label> <input type="text" id="SoNTo" name=<%=SUPPLYNOTO%>
	value="" class="textbox_date" MAXLENGTH="30" /> <br />
<br />
<label class="bodytextB">Group</label> <select
	name="<%=TENDER_SUPPLIER_GROUP_ID%>" onChange="onChangeGroup();">
	<option value="">--Select Group--</option>
	<%
			for (Iterator iterator = masStoreGroupList.iterator(); iterator.hasNext();) 
			{
				MasStoreGroup masStoreGroup = (MasStoreGroup)iterator.next();
			%>
	<option value="<%=masStoreGroup.getId()%>"
		<%=HMSUtil.isSelected(masStoreGroup.getId(),Integer.valueOf(box.getInt(TENDER_SUPPLIER_GROUP_ID)))%>><%=masStoreGroup.getGroupName()%></option>
	<%
			}
			%>
</select> <label class="bodytextB">Supplier/Vendor</label> <input type="text"
	value="" class="large" id="<%=TENDER_VENDOR_SUPPLIER_ID%>"
	name="<%=TENDER_VENDOR_SUPPLIER_ID%>" />
<div id="ac2update"
	style="height: 150px; overflow: scroll; display: none; border: 1px solid #000"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=TENDER_VENDOR_SUPPLIER_ID%>','ac2update','tender?method=getSupplierListByAutocomplete',{parameters:'requiredField=<%=TENDER_VENDOR_SUPPLIER_ID%>'});
		</script> <br />
<br />
<input type="button" name="report" onClick="showReport()" value="Submit"
	class="button">
</div>
</div>
</div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</body>
</html>