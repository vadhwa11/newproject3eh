<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockM"%>
<%@page import="jkt.hms.masters.business.CssdMaterialStockT"%>
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

<script language="javascript">
function onBlurInstrumentName(val)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var instrumentCode = val.substring(index1,index2);
	    document.getElementById('instrumentCode').value=instrumentCode;
}


function addAndRefreshGrid()
{
var code = document.getElementById('instrumentCode').value;
var qty = document.getElementById('qty').value;
var approvedBy = document.getElementById('approvedBy').value;

if (code=="")
{
	alert("Instrument Code is Mandatory!... Pl Check your Inputs!....");
	return;
}


 if (qty=="")
 {
 alert("Quantity is Mandatory!... Pl Check your Inputs!....");
 return;
 } 
 
 
  if (approvedBy==0)
  {
    alert("Approved By is Mandatory!... Pl Check your Inputs!....");
	return;
  }
  

if (isNaN(document.getElementById('qty').value))
{
	alert("Quantity should be numeric!...");
	return;
}

submitProtoAjax('materialStockForm','/hms/hms/cssd?method=addAndRefreshGrid');
}

function getStockGridData()
{
	submitProtoAjax('materialStockForm','/hms/hms/cssd?method=getStockGridData&pageno=1');
}

function GoPage() 
{	
	var pgno = parseInt( document.materialStockForm.gopage.value);
	var totalPages = parseInt( document.materialStockForm.totalPages.value);
	
	if (pgno < 1 || pgno > totalPages)
	{
	alert('Invalid Page No!.....');
	return;
	}
	  
	 document.materialStockForm.pageno.value = pgno;
	submitProtoAjax('materialStockForm','/hms/hms/cssd?method=getStockGridData'); 
}


function goNext()
{
 var pgno = parseInt( document.materialStockForm.pageno.value)+1;
 
 if (pgno >  document.materialStockForm.totalPages.value)
 {
 alert('End of the File Reached!... ');
 return;
 }
 
 document.materialStockForm.pageno.value = pgno;
 submitProtoAjax('materialStockForm','/hms/hms/cssd?method=getStockGridData');
}


function goPrevious()
{
 var pgno = parseInt( document.materialStockForm.pageno.value)-1;
 
 if (pgno < 1)
 {
 alert('Beginning of the File Reached!... ');
 return;
 }
 
  document.materialStockForm.pageno.value = pgno;
 submitProtoAjax('materialStockForm','/hms/hms/cssd?method=getStockGridData');
}

</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	String entryNo = "";
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	
	if (map.get("entryNo")!=null)
		entryNo = map.get("entryNo").toString();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasDepartment> masDepartmentList = (ArrayList<MasDepartment>)map.get("masDepartmentList");
	ArrayList<MasEmployee> masEmployeeList = (ArrayList<MasEmployee>)map.get("masEmployeeList");
	List<CssdMaterialStockM> cssdMaterialStockMList = (ArrayList<CssdMaterialStockM>)map.get("cssdMaterialStockMList");  
	
	String userName = "";
	String nameItem = "nameItem";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
%>


<!--main content placeholder starts here-->
<form name="materialStockForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Opening Balance Entry</h2>
</div>
<div class="clear"></div>


<!--Block One Starts-->
<div class="Block"><label><span>*</span> Receipt No.</label> <select
	name="entryNo" onChange="getStockGridData()">
	<option value="<%=entryNo%>"><%=entryNo%></option>
	<%
for(CssdMaterialStockM cssdMaterialStockM : cssdMaterialStockMList)
{%>
	<option value="<%=cssdMaterialStockM.getEntryNo()%>"><%=cssdMaterialStockM.getEntryNo()%></option>
	<%
}
%>

</select> <label>Department</label> <input name="deptName" type="text"
	value="<%=masDepartmentList.get(0).getDepartmentName()%>"
	class="readOnly" readonly="readonly" /> <label><span>*</span>
Received by</label> <select name="approvedBy" id="approvedBy">
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
<label>Receipt Date</label>
<label><%=date %></label>
<div class="clear"></div>
</div>
<!--Block one Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Stock Addition</h4>
<div class="clear"></div>

<!--Block Two Starts-->
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Instrument  Code</th>
		<th>Instrument  Name</th>
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
	new Ajax.Autocompleter('instrumentName','ac2update','cssd?method=getInstrumentNamesForAutocomplete',{parameters:'requiredField=instrumentName'});
	</script></td>

		<td><input id="qty" name="qty" type="text" size="3" MAXLENGTH="3" /></td>
		<td><input id="remarks" name="remarks" type="text" size="25"
			MAXLENGTH="25" /></td>
		<td><input name="Button" type="button" class="buttonAdd" value=""
			onClick="addAndRefreshGrid()" /></td>
	</tr>
</table>
</div>

<!--Block Two Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="testDiv">
<h4>Stock Entry Details</h4>
<div class="clear"></div>
<div class="tableHolderAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>S.No.</th>
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
	</tr>


</table>
</div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="hidden" name="lastChgBy"
	value="<%=userName%>" /> <input type="hidden" name="lastChgDate"
	value="<%=date%>" /> <input type="hidden" name="lastChgTime"
	value="<%=time%>" /> <label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time %></label>
<div class="clear"></div>


</div>
<!--Bottom labels ends--> <!--main content placeholder ends here--></form>
<div class="clear"></div>
<div class="paddingTop40"></div>

