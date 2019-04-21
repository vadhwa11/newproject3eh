<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreTenderM"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreReTenderProposal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.PagedArray"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" language="javascrip"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


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

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	String manufacturer_lab_practice = "";
	String standing_certificate="";
	String no_conviction_issued="";
	String status="";
	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	
  	Map map = new HashMap();
	List<StoreTenderM> storeTenderMList = new ArrayList<StoreTenderM>();
	List<MasStoreGroup> masStoreGroupList = new ArrayList<MasStoreGroup>();
	List<MasStoreSupplier> masStoreSupplierList = new ArrayList<MasStoreSupplier>();
	List<StoreReTenderProposal> storeReTenderProposalList = new ArrayList<StoreReTenderProposal>();
	List objectList = new ArrayList();

	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
		
		if (map.get("storeTenderMList") != null)
		{
		storeTenderMList = (ArrayList)map.get("storeTenderMList");
		}
	
		if (map.get("masStoreGroupList") != null)
		masStoreGroupList = (ArrayList)map.get("masStoreGroupList");
		
		if (map.get("masStoreSupplierList") != null)
		masStoreSupplierList = (ArrayList)map.get("masStoreSupplierList");
		
		if (map.get("storeReTenderProposalList") != null)
			storeReTenderProposalList = (ArrayList)map.get("storeReTenderProposalList");

		
		if (map.get("objectList") != null)
			objectList = (List)map.get("objectList");
		
		
		if (map.get("pagedArray") != null)
			pagedArray = (PagedArray)map.get("pagedArray");
  }
	
	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 		
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>

<title>Tender - SO For Cancelled</title>

<script>


function onChangeProposal()
{
	if (ReTenderResupplyOrderForm.<%=PROPOSAL_ID%>.value!="" && ReTenderResupplyOrderForm.<%=TENDER_NO%>.value!="" && ReTenderResupplyOrderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value!="")
	{
	ReTenderResupplyOrderForm.method="post";
	submitForm('ReTenderResupplyOrderForm','tender?method=getReTenderSupplierListForReLPO&tenderId='+ReTenderResupplyOrderForm.<%=TENDER_NO%>.value);
	}
}

function onChangeTender()
{
	if (ReTenderResupplyOrderForm.<%=PROPOSAL_ID%>.value=="")
	{
	alert("Please select Proposal No!.....");
	ReTenderResupplyOrderForm.<%=TENDER_NO%>.value = "";
	return;
	}

ReTenderResupplyOrderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.options.length=1;
ReTenderResupplyOrderForm.method="post";
 submitForm('ReTenderResupplyOrderForm','tender?method=showReTenderReSupplyOrder&tenderId='+ReTenderResupplyOrderForm.<%=TENDER_NO%>.value);
//submitForm('ReTenderResupplyOrderForm','tender?method=getReTenderGroupListForReLPO');
}

function onChangeGroup()
{
if (ReTenderResupplyOrderForm.<%=PROPOSAL_ID%>.value=="" || ReTenderResupplyOrderForm.<%=TENDER_NO%>.value =="")
	{
	alert("Please select Proposal No & Tender No!.....");
	ReTenderResupplyOrderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value = "";
	return;
	}
ReTenderResupplyOrderForm.method="post";
submitForm('ReTenderResupplyOrderForm','tender?method=getReTenderSupplierListForReLPO');
}

function openPopupWindow(supplier_id,amount)
{
 var tender_id = ReTenderResupplyOrderForm.<%=TENDER_NO%>.value;
 var group_id = ReTenderResupplyOrderForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value;
 var dept_id = ReTenderResupplyOrderForm.deptId.value;
 var proposal_id = ReTenderResupplyOrderForm.<%=PROPOSAL_ID%>.value;
 if (tender_id =="" || group_id=="" || proposal_id == "")
 {
 	alert("Pl check your input!.....");
 	return;
 }
 
 var url="/hms/hms/tender?method=showReTenderReSupplyOrderSplitUp&tender_id="+tender_id + "&group_id=" + group_id + "&supplier_id="+ supplier_id + "&dept_id=" + dept_id + "&proposal_id=" + proposal_id;
 newwindow=window.open(url,'name','top=10, left=10, height=500,width=1000,status=1');
}

</script>

<form name="ReTenderResupplyOrderForm">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="numOfRows" size="5" value="20"><input type="hidden"
	name="pageCount" size="5" value="10"><input type="hidden"
	name="hospitalId" size="5" value="<%=hospitalId%>"><input
	type="hidden" name="deptId" size="5" value="<%=deptId%>"><input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <br />
<div id="contentspace">
<div style="float: left;">
<h2 align="left" class="style1">Re Tender - Re SO For Cancelled</h2>
</div>

<div style="padding-left: 25px;"><br />
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Re Tender ReSO Cancelled</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 750px; height: 100px; background-color: #f4f9fe;">
<br />


<label class="bodytextB_blue">Proposal No:</label> <select
	name="<%=PROPOSAL_ID%>" onChange="onChangeProposal();">
	<option value="">--Select Proposal No--</option>

	<%
		for (Iterator iterator = storeReTenderProposalList.iterator(); iterator.hasNext();) 
		{
			int proposal_id = (Integer) iterator.next();
		%>
	<option value="<%=proposal_id%>"
		<%=HMSUtil.isSelected(proposal_id,Integer.valueOf(box.getInt(PROPOSAL_ID)))%>><%=proposal_id%></option>
	<%
		}
		%>
</select> <label class="bodytextB_blue">Tender No</label> <select
	name="<%=TENDER_NO%>" onChange="onChangeTender();">
	<option value="">--Select Tender No--</option>
	<%
		for (Iterator iterator = storeTenderMList.iterator(); iterator.hasNext();) 
		{
			StoreTenderM storeTenderM = (StoreTenderM)iterator.next();
		%>
	<option value="<%=storeTenderM.getId()%>"
		<%=HMSUtil.isSelected(storeTenderM.getId(),Integer.valueOf(box.getInt(TENDER_NO)))%>><%=storeTenderM.getTenderNo()%></option>
	<%
		}
		%>
</select> <label class="bodytextB_blue">Group</label> <select
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
</select> <br />
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<br />
<% if (pagedArray !=null && map.get("status").toString().equalsIgnoreCase("o")) 
		{ %> <input type="button" name="Submit" onClick="onUpdate()"
	value="Update" class="button" accesskey="u" /> <!--  <input type="button" name="Generate LPO" onClick="generateLPO()" value="Generate LPO" class="button" accesskey="o" />  -->
<% } else {%> <!-- <input type="button" name="Print LPO" onClick="printLPO()" value="Print LPO" class="button" accesskey="o" /> -->
<% } %>
</div>
<br />

<%
		if (objectList == null || objectList.size()==0) {
		%>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Vendor Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: hidden; width: 80%; BORDER: #202020 1px solid;">
<table width="100%" colspan="7" class="grid_header" border="1"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td><label valign="left" class="smalllabel">S.No.</label></td>
			<td><label valign="left" class="smalllabel">Vendor Name</label></td>
			<td><label valign="left" class="smalllabel">No. Of Items</label></td>
			<td><label valign="left" class="smalllabel">Total Amount
			</label></td>
			<td><label valign="left" class="smalllabel">Supply Order</label></td>

		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan=6 align="center">No Items Found</td>
		</tr>
	</tbody>
</table>
</div>

<%  } else { %>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 130px; height: 20px; float: left;">
<font class="boxtitle">Vendor Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />

<div
	style="overflow: scroll; overflow-x: scroll; height: 215px; width: 80%; BORDER: #202020 1px solid;">
<table width="100%" colspan="7" class="grid_header" border="1"
	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td><label valign="left" class="smalllabel">S.No.</label></td>
			<td><label valign="left" class="smalllabel">Vendor Name</label></td>
			<td><label valign="left" class="smalllabel">No. Of Items</label></td>
			<td><label valign="left" class="smalllabel">Total Amount
			</label></td>
			<td><label valign="left" class="smalllabel">Supply Order</label></td>
		</tr>
	</thead>
	<tbody>

		<%
			    int slno=0; 
			    for (Iterator iterator = objectList.iterator(); iterator.hasNext();) 
			    {
			    	Object[] obj = (Object[]) iterator.next();
			    %>
		<tr>
			<td><%=++slno%></td>
			<td><%=obj[0]%></td>
			<td><%=obj[1]%></td>
			<td><%=obj[2]%></td>
			<td><input type="button" name="Supply Order"
				onClick="openPopupWindow(<%=obj[3]%>,<%=obj[2]%>)"
				value="Re-Supply Order" class="button" accesskey="o" /></td>
		</tr>
		<% } %>
	</tbody>
</table>
</div>
<br />
<% } %>
</div>
</div></form>
