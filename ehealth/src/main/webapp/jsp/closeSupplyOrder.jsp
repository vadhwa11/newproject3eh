<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* acknowledgment.jsp  
* Purpose of the JSP -  This is for Department Indent.
* @author  Mansi
* Create Date: 21th Apr, 2008
* Revision Date:      
* Revision By: 
* @version 1.5  
--%>


<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StoreIndentT"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.StoreSupplyOrderEntry"%>


<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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

<script language="Javascript">



function getIndent()
{
supplyOder.method="post";
var indentNo = document.getElementById('indentNo').value
alert(indentNo)
submitForm('supplyOder','stores?method=createGridSupplyOrderEntryData&<%=INDENT_NO%>='+indentNo);

}


//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
supplyOder.currPage.value = pidx;
supplyOder.method="post";
submitForm('supplyOder','stores?method=createGridSupplyOrderEntryData');
}
function showSupplyOrder(formName)
{
obj = eval('document.'+formName)
obj.action = "/hms/hms/stores?method=closeSupplyOrderJsp";
obj.submit();
}

</script>

<%
StringBuffer orderDateOnly = new StringBuffer();
GregorianCalendar gregorianCalendar1 = new GregorianCalendar();

int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
if (dateOfMonth < 10) {
orderDateOnly.append("0");
orderDateOnly.append(dateOfMonth);
} else {
orderDateOnly.append(dateOfMonth);
}

orderDateOnly.append("/");

int month1 = gregorianCalendar1.get(Calendar.MONTH) + 1;
if (month1 < 10) {
orderDateOnly.append("0");
orderDateOnly.append(month1);
} else {
orderDateOnly.append(month1);
}

orderDateOnly.append("/");
int year1 = gregorianCalendar1.get(Calendar.YEAR);
orderDateOnly.append(year1);
String currentDate = new String(orderDateOnly);
%>
<%
Map<String,Object> map = new HashMap<String,Object>();

Box box = HMSUtil.getBox(request);
HashMap[] gridData =null;
PagedArray pagedArray = null;
String flag = "";
int indentMId = 0;
List<StoreIndentM> searchStoreIndentMList = new ArrayList<StoreIndentM>();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
pagedArray = (PagedArray) map.get("pagedArray");
}
if (map.get("indentMId")!=null){
indentMId=Integer.parseInt(""+map.get("indentMId"));
}


if(map.get("searchStoreIndentMList")!=null)
searchStoreIndentMList = (List) map.get("searchStoreIndentMList");


Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();

String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
String userName = "";

if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}

int deptId=0;
if(session.getAttribute("deptId") != null){
deptId = (Integer)session.getAttribute("deptId");
}



if(map.get("message") != null){
String message = (String)map.get("message");
%>
<br> <br> <%
out.println(message);
}


%>

<div class="titleBg">
<h2>Supply Order Form</h2>
</div>
<div class="clear"></div>
<form name="supplyOder" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><input type="hidden" name="numOfRows" size="5"
	value="5"><input type="hidden" name="pageCount" size="5"
	value="10"><input type="hidden" name="deptId" size="5"
	value="<%=deptId %>"><input type="button" name="Add"
	value="Add" class="button"
	onClick="submitForm('supplyOder','stores?method=addSupplyOrder');"><input
	type="button" name="Modify" value="Modify" class="button"
	onClick="submitForm('supplyOder','stores?method=updateSupplyOrder');"><input
	type="button" name="Reset" value="Reset" class="buttonHighlight"
	onClick="showSupplyOrder('supplyOder');"><input type="button"
	name="Delete" value="Delete" class="button"><label>Indent
No.</label> <select id="indentNo" name="<%=INDENT_NO%>"
	validate="Indent No,String,no" onchange="getIndent();">
	<option value="0">Select</option>
	<%
for (StoreIndentM storeIndentM :searchStoreIndentMList ) {

%>
	<option value=<%=storeIndentM.getId()%>><%=storeIndentM.getIndentNo()%></option>
	<%	
}

%>
</select> <input type="hidden" name="<%=CHANGED_BY %>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <input
	type="hidden" name="indentMId"
	value="<%=map.get("indentMId") == null?0:map.get("indentMId")%>" />
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<% if (pagedArray == null) { %>
<h4>Details</h4>
<div class="clear"></div>
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="0" cellpadding="0" cellspacing="0">
	<tr>
		<th>S.No.</th>
		<th>PVMS No</th>
		<th>Nomenclature</th>

		<th>A/U</th>
		<th>MMF</th>
		<th>Supply Order No.</th>
		<th>First Rec. No.</th>
		<th>First Rec. Date</th>
		<th>Second Rec. No.</th>
		<th>Second Rec. Date</th>
		<th>Rate</th>
	</tr>


	<tr>
		<td colspan=6>No Data Found</td>
	</tr>

</table>

<% } else { %>
<h4>Acknowledgment Details</h4>
<div class="clear"></div>
<table width="100%" colspan="7" id="indentDetails" border="0"
	cellpadding="0" cellspacing="0">
	<tr>
		<th>S.No.</th>
		<th>PVMS No</th>
		<th>Nomenclature</th>
		<th>A/U</th>
		<th>MMF</th>
		<th>Supply Order No.</th>
		<th>First Rec. No.</th>
		<th>First Rec. Date</th>
		<th>Second Rec. No.</th>
		<th>Second Rec. Date</th>
		<th>Rate</th>
	</tr>

	<%
gridData = (HashMap[])pagedArray.getPagedArray();
int iFirstRow = pagedArray.getFirstRowIdx();
for(int i=0;i<gridData.length;i++)
{ %>
	<tr>
		<td><input type="text" value="<%=iFirstRow++%>" name="srno"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text" value="<%=gridData[i].get("pvms")%>"
			name="pvms" class="readOnly" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("nomenclature")%>" name="nomenclature"
			class="readOnly" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("au")==null?"":gridData[i].get("au")%>"
			name="au" class="readOnly" readonly="readonly" /></td>
		<td><input type="text" value="<%=gridData[i].get("mmf")%>"
			name="mmf" validate="mmf,float,no" class="readOnly"
			readonly="readonly" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("supplyOrderNo")%>" name="supplyOrderNo"
			validate="supplyOrderNo Qty,string,no" /></td>
		<td><input type="text" value="<%=gridData[i].get("firstRecNo")%>"
			name="firstRecNo" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("firstRecDate")==null?"":gridData[i].get("firstRecDate")%>"
			name="firstRecDate" class="textbox_date" readonly /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date,,yes"
			onClick="setdate('',document.supplyOder.firstRecDate);"
			class="calender" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("secondRecNo")%>" name="secondRecNo" /></td>
		<td><input type="text"
			value="<%=gridData[i].get("secondRecDate")==null?"":gridData[i].get("secondRecDate")%>"
			name="secondRecDate" class="textbox_date" readonly /> <img
			id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
			border="0" validate="Pick a date,,yes"
			onClick="setdate('',document.supplyOder.secondRecDate);"
			class="calender" /></td>
		<td><input type="text" value="<%=gridData[i].get("rate")%>"
			name="rate" validate="rate,float,no" /></td>
		<td><input type="hidden"
			value="<%=gridData[i].get("indentTId")%>" name="indentTId" /></td>
		<td><input type="hidden" value="<%=gridData[i].get("indentId")%>"
			name="indentId" /></td>
		<td><input type="hidden" value="<%=gridData[i].get("itemId")%>"
			name="itemId" /></td>
		<td><input type="hidden"
			value="<%=gridData[i].get("supplyOrderId")%>" name="supplyOrderId" />
		</td>
	</tr>
	<% } %>
	<tr>
		<td colspan=7 align="center"><%= pagedArray.showIndex()%> <%=pagedArray.getPageIndexHiddenTag()%></td>
	</tr>

</table>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="update" id="updatebutton" value="Update"
	class="button"
	onClick="submitForm('supplyOder','stores?method=updateSupplyOrder');"
	accesskey="a" tabindex=1 /> <input type="button" name="close"
	id="closebutton" value="Close" class="button"
	onClick="showSupplyOrder('supplyOder')" accesskey="u" tabindex=1 /> <% } %>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>