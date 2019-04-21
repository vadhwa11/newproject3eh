<%@page import="jkt.hms.masters.business.PrqQuotationVendorDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationItemDetails"%>
<%@page import="jkt.hms.masters.business.PrqQuotationHeader"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
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
	List<PrqQuotationVendorDetails> vendor=new ArrayList<PrqQuotationVendorDetails>();
	List<PrqQuotationHeader> hdr=new ArrayList<PrqQuotationHeader>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("vendorList")!=null){
		vendor=(List<PrqQuotationVendorDetails>)map.get("vendorList");
	}
	if(map.get("pendinglist")!=null){
		hdr=(List<PrqQuotationHeader>)map.get("pendinglist");
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

	%>

<div class="titleBg">
<h2>Quotation Submission</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<div class="Block">
<form name="searchPanel" method="post">
<div class="clear"></div>
<label>Quotation Date</label>
<input type="text" name="quotationRequisitionDate"	value="<%= hdr.get(0)!=null ?  hdr.get(0).getQuotationDate():""%>" class="date" maxlength="30" tabindex=1 readonly="readonly"/>
<label>Quotation No. </label>
<input type="text" name="quotationRequisitionNo" value="<%=hdr.get(0)!=null ?  hdr.get(0).getQuotationNo():""%>"	tabindex=1   id="quotationRequisitionNo" readonly="readonly" />
<label>Quotation By</label>
<input type="text" name="quotationRequisitionNo" value="<%=hdr.get(0).getQuotationBy()!=null ? hdr.get(0).getQuotationBy().getEmployee().getEmployeeName():"" %>"	tabindex=1   id="quotationRequisitionNo" readonly="readonly" />
<div class="clear"></div>
<label>Approved By</label>
<input type="text" name="quotationRequisitionNo" value="<%=hdr.get(0).getApprovalBy()!=null ? hdr.get(0).getApprovalBy().getEmployee().getEmployeeName():"" %>"	tabindex=1   id="quotationRequisitionNo" readonly="readonly"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<form name="itemGrid" method="post">

<div class="Block">

<label>Submission Date </label>
<input type="text" name="quotationSubmissionDate" id="quotationSubmissionDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.searchPanel.quotationSubmissionDate,event);" />


</div>
<h4>Vendor Details</h4>
<!-- <input name="button"  type="button"	value="AddVendor" class="button"	onclick="""; /> -->
<div class="cmntable">

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0" id="prqtable">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Vendor Name</th>
			<th width="10%">Vendor Address</th>
			<th width="13%">Select</th>
		</tr>
	</thead>
	<tbody>
		 	<%
	      	PrqQuotationHeader header=null;
	      	int i=0;
			if (vendor.size() > 0) {
				
				for (PrqQuotationVendorDetails st : vendor) {
					header=st.getHeader();
					i++;
					String add="";
					if(st.getVendor().getAddress1()!=null)
					{
						add=st.getVendor().getAddress1();
					}
		%>
		<tr>
		<%-- <tr onclick="submitFormForButton('itemGrid','/procurement?method=showQuotationSubmissionJsphgfgyuhg&headerId=<%=header.getId()%>');"> --%>
			<%-- <td><%=i %> <input type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="" /></td> --%>
			<td width="5%"><%=i %></td>
			<td width="5%"><%=st.getVendor().getSupplierName() %></td>
			
			<td width="5%"><%=add %></td>
			<td><input name="selectCheckBox<%=i%>" id="selectCheckBox<%=i%>" type="checkbox" value="<%=st.getId() %>" onClick="javascript:openPopupWindow(this,'<%=i%>');" /></td>
			</tr>
		<%
				}}%>
				</tbody>
    <!--  <input type="button" name="add" value="" class="buttonDel"  />
   <input name="delete" type="button" class="buttonAdd" value=""  /> -->
    <input type="hidden" name="vendorCount" value="<%=i%>" />
	 <input type="hidden"  name="headerId" value="<%=header!=null?header.getId():""%>" /> 
	<!-- </tbody> -->
</table>
</div>
<div class="clear"></div>
<!-- <input name="button"  type="button"	value="Submit" class="button"	onclick="""; />
<input name="button"  type="reset"	value="Reset" class="button"	onclick=""; /> -->
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

<script type="text/javascript">
var  openedIndex=0;
function openPopupWindow(obj,index){
	openedIndex=index;
	if(obj.checked){
		 var url="/hms/hms/procurement?method=showQuotationSubmissionSelectJsp&requestId="+obj.value;
		 newwindow=window.open(url,'name',"left=100,top=100,height=400,width=850,status=1,scrollbars=1,resizable=0");
	}
}
function addRow()
{
	var tbl = document.getElementById('prqtable');
	var lastRow = tbl.rows.length;

	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage';
	e0.className = 'radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	
	e1.name = 'nomenclature';
	e1.id = 'nomenclature';
	e1.tabIndex="1";
	e1.size='50';
   	cell1.appendChild(e1);

	

 	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.id='closeStock'+iteration;
	e4.name='closeStock'+iteration;
	e4.size='20';
 	cell3.appendChild(e4);


	var cell4 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.id='compQuantity'+iteration;
	e5.name='compQuantity'+iteration;
 	e5.size='20';
 	cell4.appendChild(e5);

	var e6 = document.createElement('input');
	e6.type = 'hidden';
	e6.id = 'ItemId'+iteration;
	e6.name = 'ItemId'+iteration;
	e6.readOnly = true;
	e6.size='5';
	cell4.appendChild(e6);
}

function removeRow()
{
	
	var tbl = document.getElementById('prqtable');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	         
  	for(abc=0;abc<document.getElementsByName('selectedChrage').length;abc++)
	{
		if (document.getElementsByName('selectedChrage')[abc].checked == true)
		{
		  	tbl.deleteRow(abc+1);
		}
	}
}

</script>
