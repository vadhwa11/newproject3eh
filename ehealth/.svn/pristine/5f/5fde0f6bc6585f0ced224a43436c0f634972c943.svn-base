<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants,java.math.BigDecimal"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreFyDocumentNo"%>
<%@page import="jkt.hms.masters.business.StoreIpIssueM"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<link rel="stylesheet" href="/hms/jsp/css/acnik.css" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/autocomplete.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<!-- <script type="text/javascript" src="/hms/jsp/js/actb.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common1.js"></script>
 -->
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">

var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);


</script>

<%
	 int pageNo=0;
	Map map = new HashMap();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	
	}
	if (map.get("pageNo") != null) {
		pageNo = Integer.parseInt(""+map.get("pageNo"));
		
	}
	int deptId=0;
	if (map.get("deptId") != null) {
		deptId = Integer.parseInt(""+map.get("deptId"));
		
	}
	
	//	int deptId = (Integer)map.get("deptId");
	//	String date=(String)map.get("date");
	//	String time=(String)map.get("time");
	//	String fromDateToDate=(String)map.get("fromDateToDate");
	
	
	List listOfItemsInStock=new ArrayList();
	List itemList= new ArrayList();
	List issueNoList= new ArrayList();
	List empList= new ArrayList();
	String date="";
	String time="";
	int hinId=0;
	String buttonFlagForNext="";
	String hinNo="";
	String prescription="";
	int consultantId=0;
	try {
				
					if(map.get("listOfItemsInStock") != null){
						listOfItemsInStock=(List)map.get("listOfItemsInStock");
					}
					
					if (map.get("itemList") != null) {
						itemList = (List)map.get("itemList");
					}
					if (map.get("issueNoList") != null) {
						issueNoList = (List)map.get("issueNoList");
					}
					if (map.get("date") != null) {
						date = (String)map.get("date");
					}
					if (map.get("time") != null) {
						time = (String)map.get("time");
					}
					if (map.get("hinId") != null) {
						hinId = (Integer)map.get("hinId");
					}
					if (map.get("hinNo") != null) {
						hinNo = (String)map.get("hinNo");
					}
					if (map.get("prescription") != null) {
						prescription = (String)map.get("prescription");
						
					}
					if (map.get("consultantId") != null) {
						consultantId = (Integer)map.get("consultantId");
						
					}
					if(map.get("empList") != null)
					{
						empList=(List)map.get("empList");
						
					}
					if (map.get("buttonFlag") != null) {
						buttonFlagForNext = (String)map.get("buttonFlag");
					}
					else{
						buttonFlagForNext="empty";
					}
					
					
	
		
	} catch (Exception exp) {
			out.println("-------------------------------------------"+ exp);
		exp.printStackTrace();
	}
	
	
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	%>

<!-- <div id="contentspace"> -->
<!-- <jsp:include page="searchResultPO.jsp" />-->

<!-- </form> -->

<form name="opdPatient" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="testDiv" size="height:500px;"><input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <%
		
		 List opdIssueNo=(List)map.get("opdIssueNo");
		 StoreFyDocumentNo storeFyDocumentNo= (StoreFyDocumentNo)opdIssueNo.get(0);
		
		String opdIssuenoIncremented=(String)map.get("opdIssuenoIncremented");
	%> <br />
<tr>
	<td><label class="bodytextB_blue"> Prescription No:</label> <%if(map.get("prescription") != null){ %>
	<input type="text" name="<%=RequestConstants.PRESCRIPTION_NO%>"
		id="prescriptionNo" tabindex="1" value="<%=prescription%>"
		class="textbox_date" MAXLENGTH="5" readonly /> <%}else{ %> <input
		type="text" name="<%=RequestConstants.PRESCRIPTION_NO%>"
		id="prescriptionNo" tabindex="1" value="" class="textbox_date"
		MAXLENGTH="5" /> <%} %>
	</td>
	<td><label class="bodytextB_blue"> Consultant Name:</label> <select
		name="<%=RequestConstants.CONSULTING_DOCTOR%>" id="consultant"
		validate="" tabindex="1">
		<option value="0">Select</option>
		<% 
	     	MasEmployee masEmployee=null;
	     	String consultantName="";
	     	if (empList!=null && empList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = empList.iterator(); iterator.hasNext();) {
	     			masEmployee = (MasEmployee)iterator.next();
	    				
	    				if(masEmployee.getFirstName() != null)
	    				{
	    					consultantName=masEmployee.getFirstName();
	    				}
	    				if(masEmployee.getMiddleName() != null)
	    				{
	    					consultantName+=masEmployee.getMiddleName();
	    				}
	    				if(masEmployee.getLastName() != null)
	    				{
	    					consultantName+=masEmployee.getLastName();
	    				}
	    				
				%>
		<%if(masEmployee.getId()==consultantId){ %>
		<option value="<%=masEmployee.getId()%>" selected><%=consultantName%>
		</option>
		<%}else{ %>
		<option value="<%=masEmployee.getId()%>"><%=consultantName%>
		</option>
		<%} %>
		<% } 
			} 
	     	 else
	     	 {
			 %>
		<script>
			 	document.getElementById('errorMsg').innerHTML='* No Record Found!!';
			 </script>
		<%
			  } 
	     	 %>
	</select></td>
</tr>
<br />
<br />
<tr>
	<td><label class="bodytextB">OPD Issue No </label>
	<div
		style="float: left; font-size: 13px; background-image: url(/hms/jsp/images/tablehead.gif); height: 25px; font-weight: bold; text-align: center; color: #000000; width: 90px; font-size: 13px;">
	<%= opdIssuenoIncremented%></div>
	<input type="hidden" id="opdIssueno"
		value="<%= opdIssuenoIncremented%>" readonly /> <input type="hidden"
		id="storeFyDocumentNoId" value="<%= storeFyDocumentNo.getId()%>" /></td>
</tr>

<!-- if(checkForNext()){submitForm('wardConsumption','ipd?method=showWardConsumptionJsp&buttonFlag=next');} -->
<label class="bodytextB">Page No:</label>
<div class="changebydt" style="width: 50px;"><%=pageNo%></div>

<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" value="<%=deptId %>"
	name="deptId" id="deptId" /> <input type="hidden" value=""
	name="empId" id="empId" /> <input type="hidden" value="<%=hinId %>"
	name="hinId" id="hinId" /> <input type="hidden" value=""
	name="prescription" id="prescription" /> <input type="hidden"
	name="date" id="date" value="<%=date %>" /> <input type="hidden"
	name="time" id="time" value="<%=time %>" /> <input type="hidden"
	name="buttonFlagForNext" id="buttonFlagForNext"
	value="<%=buttonFlagForNext %>" /> <br />
<fieldset style="width: 99%; padding-left: 9px;"><legend>Ward
Consumption Details</legend>


<div style="overflow: auto; height: 250px; padding-left: 9px;">
<table width="100%" colspan="7" id="stockDetails" class="grid_header"
	border="1" cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<td width="5%"><label valign="left" class="smalllabel">S.No.</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Lot
			Number</label></td>
			<td width="10%"><label valign="left" class="smalllabel">Nomenclature</label>
			</td>

			<td width="13%"><label valign="left" class="smalllabel">PVMS
			No</label></td>


			<td width="16%"><label valign="left" class="smalllabel">Quantity
			Issued</label></td>

		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	    	
    	if(pageNo!=1)
    	{
    		temp=detailCounter*(pageNo-1);
    	}
     	 for(int inc=1;inc<=8;inc++){
     		
     %>
		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				class="smcaption" name="<%=RequestConstants.SR_NO%>"
				readonly="readonly" /></td>
			<td width="5%"><input type="text" size="2" value=""
				class="smcaption" name="lotNo<%=inc %>" id="lotNo<%=inc %>"
				onblur="if(validateConsultant(opdPatient,<%=inc %>)){fillValuesForLotNo(this.value,<%=inc%>,<%=deptId %>,opdPatient);}" /></td>
			<td width="13%"><input type="text" value="" tabindex="1"
				name="nomenclature<%=inc%>" id="nomenclature<%=inc%>"
				class="bigcaption"
				onblur="if(validateConsultant(opdPatient,<%=inc %>)){checkForNomenclature(this.value, '<%=inc %>','<%=deptId %>');}" />
			<div id="ac2update"
				style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature<%=inc%>','ac2update','stores?method=getItemListForOPD',{parameters:'requiredField=nomenclature<%=inc%>'});
			</script></td>
			<td width="13%"><input type="text" class="medcaption"
				name="pvmsNo<%=inc%>" readonly="readonly" id="pvmsNo<%=inc%>" /></td>
			<input type="hidden" name="itemId<%=inc%>" id="itemId<%=inc %>"
				value="" />
			<td width="16%"><input type="text" value="" class="medcaption"
				name="<%=RequestConstants.QTY_ISSUED%>" id="qtyIssued<%=inc%>"
				value="" readonly /></td>
		</tr>
		<%
     	}
     %>

	</tbody>
</table>
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>
</fieldset>


<br />
<div style="padding-left: 280px; float: left;"><input
	type="button" class="button" value="Next"
	onclick=" submitForm('opdPatient','stores?method=showOPDPatientIssue&buttonFlag=next&hinId=<%=hinId%>&issueNo=<%=opdIssuenoIncremented %>&hinNo=<%=hinNo%>','checkTargetForNo');"
	align="right" /> <input type="button" class="button" value="Delete"
	onclick="openPopupForDelete('<%=opdIssuenoIncremented%>');"
	align="right" /></div>
</div>
</form>
<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />










