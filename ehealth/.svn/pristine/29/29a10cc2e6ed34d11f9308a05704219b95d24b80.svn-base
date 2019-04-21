<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestT"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
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
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>



<script language="javascript">
function onBlurInstrumentName(val)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var instrumentCode = val.substring(index1,index2);
	    document.getElementById('instrumentCode').value=instrumentCode;
}


function addAndRefreshAutoclaveRequestGrid()
{

var code = document.getElementById('instrumentCode').value;
var qty = document.getElementById('qty').value;
var orderBy = document.getElementById('orderBy').value;
var orderTime = document.getElementById('orderTime').value;

if (code=="" || qty=="" || orderBy ==0 || orderTime=="")
{
	alert("Instrument Code, Instrument Name, Quantity, Order By & Order Time are Mandatory!...");
	return;
}

if (isNaN(document.getElementById('qty').value))
{
	alert("Quantity should be numeric!...");
	return;
}
submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=addAndRefreshAutoclaveRequestGrid');
}

function getAutoclaveRequestGridData()
{
	submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData&pageno=1');
}

function GoPage() 
{	
	var pgno = parseInt(document.autoclaveRequestForm.gopage.value);
	var totalPages = parseInt(document.autoclaveRequestForm.totalPages.value);
	
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	  
	document.autoclaveRequestForm.pageno.value = pgno;
	submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData'); 
}


function goNext()
{
 var pgno = parseInt(document.autoclaveRequestForm.pageno.value)+1;
 
 if (pgno > document.autoclaveRequestForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 document.autoclaveRequestForm.pageno.value = pgno;
 submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData');
}


function goPrevious()
{
 var pgno = parseInt(document.autoclaveRequestForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
 document.autoclaveRequestForm.pageno.value = pgno;
 submitProtoAjax('autoclaveRequestForm','/hms/hms/cssd?method=getAutoclaveRequestStockGridData');
}

</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String orderNo = "";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("orderNo")!=null)
		orderNo = map.get("orderNo").toString();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	ArrayList<MasDepartment> masDepartmentList = (ArrayList<MasDepartment>)map.get("masDepartmentList");
	ArrayList<MasEmployee> masEmployeeList = (ArrayList<MasEmployee>)map.get("masEmployeeList");
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdInstrumentMaster> cssdInstrumentMasterList = (ArrayList<CssdInstrumentMaster>)map.get("cssdInstrumentMasterList");
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
%>


<!--main content placeholder starts here-->
<form name="autoclaveRequestForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Autoclave Request Entry</h2>
</div>
<div class="clear"></div>


<!--Block One Starts-->
<div class="Block"><label><span>*</span> Order No.</label> <select
	name="orderNo" id="orderNo" onChange="getAutoclaveRequestGridData()">
	<option value="<%=orderNo%>"><%=orderNo%></option>
	<%
for(CssdAutoclaveRequestM cssdAutoclaveRequestM : cssdAutoclaveRequestMList)
{%>
	<option value="<%=cssdAutoclaveRequestM.getOrderNo()%>"><%=cssdAutoclaveRequestM.getOrderNo()%></option>
	<%
}
%>

</select> <label>Department</label> <input name="deptName" type="text"
	value="<%=masDepartmentList.get(0).getDepartmentName()%>"
	class="readOnly" readonly="readonly" /> <label><span>*</span>
Order By</label> <select name="orderBy" id="orderBy">
	<option value="0">Select Employee</option>
	<%
for(MasEmployee masEmployee : masEmployeeList)
{
	StringBuffer empName = new StringBuffer();
	empName.append(masEmployee.getFirstName()==null?"":masEmployee.getFirstName());
	empName.append(" ");
	empName.append(masEmployee.getMiddleName()==null?"":masEmployee.getMiddleName());
	empName.append(" ");
	empName.append(masEmployee.getLastName()==null?"":masEmployee.getLastName());
%>
	<option value="<%=masEmployee.getId()%>"><%=empName%></option>
	<%
}
%>
</select>

<div class="clear"></div>

<label><span>*</span> Order Date</label> <input type="text"
	class="readOnly" id="orderDate" name="orderDate"
	value="<%=currentDate %>" readonly="readonly" MAXLENGTH="30" /> <!--
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.autoclaveRequestForm.orderDate,event)"/> 
  --> <label><span>*</span> Order Time</label> <input type="text"
	id="orderTime" name="orderTime" value="<%=time.substring(0,5) %>"
	class="readOnly" readonly="readonly" />


<div class="clear"></div>
</div>
<!--Block one Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Autoclave Request Addition</h4>
<div class="clear"></div>
<div id="testDiv">
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Instrument Code</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
		<th></th>
	</tr>
	<tr>
		<td><input id="instrumentCode" name="instrumentCode" type="text"
			size="10" MAXLENGTH="10" readonly="readonly" /></td>

		<td><input type="text" id="instrumentName" name="instrumentName"
			size="25" MAXLENGTH="25" onblur="onBlurInstrumentName(this.value)" />
		<div id="ac2update" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('instrumentName','ac2update','cssd?method=getAutoclaveRequestInstrumentNameForAutocomplete',{parameters:'requiredField=instrumentName&orderNo='+document.getElementById('orderNo').value });
	</script></td>

		
		<td><input id="qty" name="qty" type="text" size="3" MAXLENGTH="3" /></td>
		<td><input id="remarks" name="remarks" type="text" size="25"
			MAXLENGTH="25" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onClick="addAndRefreshAutoclaveRequestGrid()" /></td>
	</tr>
</table>
</div>
<!--Block Two Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Autoclave Request Details</h4>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Sr.No.</th>
		<th>Instrument Code</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
	</tr>
	<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>


</table>
</div>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="hidden" name="lastChgBy"
	value="<%=userName%>" /> <input type="hidden" name="lastChgDate"
	value="<%=currentDate%>" /> <input type="hidden" name="lastChgTime"
	value="<%=time%>" /> <label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time %></label>
<div class="clear"></div>


</div>
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>
