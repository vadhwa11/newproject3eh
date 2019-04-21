<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>


<link rel="stylesheet" type="text/css" href="/hms/jsp/css/h_style.css" />


<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>

<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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



<script type="text/javascript">
/***********************************************
* Textarea Maxlength script- 
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>



<%
	Map map = new HashMap();
	HashMap[] gridData =null;
	PagedArray pagedArray = null;

	String date = "";
	String time = "";
	String userName = "";
	String deptName = "";
	int deptId = 0;
	int hospitalId = 0;
	int tender_no = 0;
	int proposal_id = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> masterDataMap = new HashMap<String,Object>();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");

 	if (session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	
 	if (session.getAttribute("deptName") != null)
 	{
		deptName = (String)session.getAttribute("deptName");
	}

 	if (session.getAttribute("deptId") != null)
 	{
		Integer temp = (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
 	
	if (session.getAttribute("hospitalId") != null) 
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		pagedArray = (PagedArray) map.get("pagedArray");
		storeTenderMList = (List) map.get("storeTenderMList");
		if (map.get(TENDER_NO)!=null)
		{
			tender_no = Integer.parseInt(map.get(TENDER_NO).toString());
			box.put(TENDER_NO,tender_no);
		}
		
		if (map.get(PROPOSAL_ID)!=null)
		{
			proposal_id = Integer.parseInt(map.get(PROPOSAL_ID).toString());
			box.put(PROPOSAL_ID,proposal_id);
		}
	}
	
%>

<title>Re Tender Proposal</title>
<script>

function openPopupWindow()
{
 if (RetenderProposalForm.<%=TENDER_NO%>.value=="")
 {
 	alert("Please Select Tender No.....");
 	return;
 }
 
 var url="/hms/hms/tender?method=showAddReTenderItemsJsp&numOfRows=15&pageCount=10&tender_no="+RetenderProposalForm.<%=TENDER_NO%>.value + "&proposal_id=" + RetenderProposalForm.<%=PROPOSAL_ID%>.value ;
 newwindow=window.open(url,'name','top=50, left=50, height=600,width=950,status=1');
}

//this function will be called by the Bean (not from JSP)
function goPage(pidx) {	
	RetenderProposalForm.currPage.value = pidx;
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=showReTenderProposalJsp');
}

function validateTenderQty()
{
	if (RetenderProposalForm.<%=TENDER_ITEM_ID%> && RetenderProposalForm.<%=TENDER_ITEM_ID%>.length)
	{
			 for(var i = 0; i < RetenderProposalForm.<%=TENDER_ITEM_ID%>.length; i++)
			 {
			 	var total_qty = RetenderProposalForm.<%=TENDER_MMFQTY%>[i].value;
			 	var actual_qty = RetenderProposalForm.<%=TENDER_ANNREQ%>[i].value;
	   		    if (parseFloat(actual_qty) > parseFloat(total_qty)/2)
	   		    {
	   		    alert("Actual Tender Qty should not be more than Half of the Total Tender Qty!..."); 
	   		    return false;
	   		    }
			 }
		return true;
	}
	else
	{
	alert("Item(s) not found for Update!.....");
	return false;
	}
}

function upd()
{
RetenderProposalForm.method="post";
submitForm('RetenderProposalForm','tender?method=updateReTenderProposalGridItems');
}

function validateDeleteButton()
{
	if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length)
	{
			 for(var i = 0; i < RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.length; i++)
			 {
			  if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%> && RetenderProposalForm.<%=ITEMS_TO_BE_DELETED%>.checked == true)
			return true;
	}
	return false;
}

function del()
{
	if (validateDeleteButton())
	{
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=deleteReTenderProposalGridItems');
	}
	else
	{
	alert('No Item(s) Selected for delete!....');
	}
}

function printProposal()
{
<% if (pagedArray!=null) { %>
	RetenderProposalForm.method="post";
	submitForm('RetenderProposalForm','tender?method=printReTenderProposalItems');
<% } else { %>
	alert('No Items to print!.........');
<% } %>
}

	function pvmsSearch()
	 {
	 	RetenderProposalForm.method="post";	
	   var pvmsNo=document.RetenderProposalForm.pvmsNo.value;
	  // alert("value of pvmsNo--"+pvmsNo)
	   if(pvmsNo != ""){
	     submitForm('RetenderProposalForm','tender?method=showReTenderProposalJsp&flag=fresh&pvmsNo='+pvmsNo);
	   }else{
	     alert("Please select PVMS No.")
	   }
	 }


</script>

<br />

<h2 align="left" class="style1">Re Tender Proposal</h2>

<div id="contentspace">

<form name="RetenderProposalForm" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="numOfRows" size="5" value="15"><input
	type="hidden" name="pageCount" size="5" value="10"><input
	type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>"><input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"><input
	type="hidden" name="<%=PROPOSAL_ID %>" size="5"
	value="<%=box.get(PROPOSAL_ID)%>">
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Re Tender Proposal</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />
<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 90px; background-color: #f4f9fe;">

<br />


<label class="bodytextB">Proposal No:</label>
<div class="changebydt"><%=box.getInt(PROPOSAL_ID)%></div>


<label class="bodytextB">Tender No</label> <select name="<%=TENDER_NO%>">
	<option value="">Select Tender No</option>

	<%
			if (storeTenderMList!=null && storeTenderMList.size()>0)
			{
				for(int i=0;i<storeTenderMList.size();i++) 
				{
			%>
	<option value="<%=storeTenderMList.get(i).getId()%>"
		<%=HMSUtil.isSelected(storeTenderMList.get(i).getId(),box.getInt(TENDER_NO)) %>><%=storeTenderMList.get(i).getTenderNo()%></option>
	<% }
				}
			 %>
</select> <label class="bodytextB">Department:</label>
<div class="changebydt"><%=deptName%></div>

<br />
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>
</div>

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>
		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					class="toolbutton" onClick="openPopupWindow();"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Update" type="submit" value="Update"
					class="toolbutton" onClick="upd();"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Delete" type="submit" value="Delete"
					class="toolbutton" onClick="del();"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Print" type="submit" value="Print"
					class="toolbutton" onClick="printProposal();"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br />
<label class="bodytextB_blue">PVMS/NIV</label> <input type="text"
	name="pvmsNo" value="" tabindex=1 class="textbox_size20"
	onkeypress="submitenter(this,event,'tender?method=showReTenderProposalJsp&flag=fresh')" />
<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" tabindex=1
	HEIGHT="26" style="cursor: pointer;" onClick="javascript:pvmsSearch();"
	title="Click here to Search Pvms/Niv"> <%		
		if (pagedArray == null) {
		%> <br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 205px; height: 20px; float: left;">
<font class="boxtitle">Re Tender Proposal Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<div style="overflow: auto; width: 100%; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="30%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="15%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Disp
			Type</label></td>
			<td width="12%"><label valign="left" class="smalllabel">Stock
			in Hand</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Total
			Tender Qty</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Actual
			Tender Qty</label></td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=8 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>
<br />
<br />
<%  } else { %> <br />

<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 205px; height: 20px; float: left;">
<font class="boxtitle">Re Tender Proposal Item Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: auto; overflow-x: hidden; width: 100%; height: 195px; padding-left: 9px;">
<table width="100%" colspan="7" id="indentDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">PVMS
			No</label></td>
			<td width="30%"><label valign="left" class="smalllabel">Nomenclature</label></td>
			<td width="15%"><label valign="left" class="smalllabel">A/U</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Disp
			Type</label></td>
			<td width="12%"><label valign="left" class="smalllabel">Stock
			in Hand</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Total
			Tender Qty</label></td>
			<td width="15%"><label valign="left" class="smalllabel">Actual
			Tender Qty</label></td>
			<td width="6%"><label valign="left" class="smalllabel">DELETE</label></td>
		</tr>
	</thead>
	<tbody>


		<%
			    gridData = (HashMap[])pagedArray.getPagedArray();
				int iFirstRow = pagedArray.getFirstRowIdx();
			    for(int i=0;i<gridData.length;i++)
			    { %>
		<tr>
			<td width="5%"><input type="text" value="<%=iFirstRow++%>"
				class="smcaption" name="<%=TENDER_SRNO%>" readonly="readonly" /></td>
			<td width="10%"><input type="text"
				value="<%=gridData[i].get(TENDER_PVMS )%>" class="medcaption"
				name="<%=TENDER_PVMS %>" readonly="readonly" /></td>
			<td width="30%"><input type="text"
				value="<%=gridData[i].get(TENDER_NOMENCLATURE)%>" class="bigcaption"
				name="<%=TENDER_NOMENCLATURE %>" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get(TENDER_AU)%>" name="<%=TENDER_AU%>"
				class="medcaption" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=gridData[i].get("disp_type")%>" name="disp_type"
				class="medcaption" readonly="readonly" /></td>
			<td width="15%"><input type="text"
				value="<%=(gridData[i].get(TENDER_STOCK_IN_HAND)==null)?"0.000":gridData[i].get(TENDER_STOCK_IN_HAND)%>"
				name="<%=TENDER_STOCK_IN_HAND%>" class="medcaption"
				readonly="readonly" /></td>
			<td width="12%"><input type="text"
				value="<%=(gridData[i].get(TENDER_MMFQTY)==null)?"0.000":gridData[i].get(TENDER_MMFQTY)%>"
				class="medcaption" name="<%=TENDER_MMFQTY %>" readonly="readonly" />
			</td>
			<td width="13%"><input type="text"
				value="<%=(gridData[i].get(TENDER_ANNREQ)==null)?"0.000":gridData[i].get(TENDER_ANNREQ)%>"
				name="<%=TENDER_ANNREQ %>" class="medcaption"
				validate="Tender Qty,num,no" maxlength="16" /></td>
			<td width="6%"><input type="checkbox"
				name=<%=ITEMS_TO_BE_DELETED%>
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"></td>
			<td width="10%"><input type="hidden"
				value="<%=gridData[i].get(TENDER_ITEM_ID)%>"
				name="<%=TENDER_ITEM_ID%>" /></td>

		</tr>
		<% } %>
	</tbody>
</table>
</div>


<div style="padding-left: 250px;">

<div class="wardspan" style="float: left;"><%= pagedArray.showIndex()%></div>
<div class="wardspan" style="float: left;"><%= pagedArray.getPageIndexHiddenTag()%>
</div>
</div>
<br />
<br />
<% } %>
</form>

</div>

<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
