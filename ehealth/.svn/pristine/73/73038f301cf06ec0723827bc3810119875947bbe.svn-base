
<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * patientDrugIssue.jsp
	 * Purpose of the JSP -  This is for issue to Dispensary.
	 * @author  Ritu
	 * Create Date: 26 Nov , 2009 .
	 * Revision Date:
	 * Revision By:
	 * @version 1.8
	--%>

<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.PatientStoreIndentDetails"%>
<%@page import="jkt.hms.masters.business.PatientStoreIndentHeader"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<PatientStoreIndentDetails> patientIndentDetailsList =  new ArrayList<PatientStoreIndentDetails>();
	//List<PatientStoreIndentHeader> patientIndentHeaderList =  new ArrayList<PatientStoreIndentHeader>();
	List<MasEmployee> employeeList =  new ArrayList<MasEmployee>();

	/* if(map.get("patientIndentHeaderList")!=null){
		patientIndentHeaderList=(List)map.get("patientIndentHeaderList");
	} */
	if(map.get("patientIndentDetailsList")!=null){
		patientIndentDetailsList=(List)map.get("patientIndentDetailsList");
	}
	if(map.get("employeeList")!=null){
		employeeList = (List)map.get("employeeList");
	}
	Users users = new Users();
	String userName = "";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("users") != null){
		users = (Users)session.getAttribute("users");
	}
 	if(session.getAttribute("userName") != null){
 		userName = (String)session.getAttribute("userName");
	}
 	PatientStoreIndentHeader patientStoreIndentHeader = new PatientStoreIndentHeader();
 	if(patientIndentDetailsList.size() > 0 && patientIndentDetailsList.get(0).getPatientStoreIndentHeader() != null)
 	{
 		patientStoreIndentHeader = patientIndentDetailsList.get(0).getPatientStoreIndentHeader();
 	}
 	System.out.println("patientIndentDetailsList"+patientIndentDetailsList.size());
 	//patientStoreIndentHeader = patientIndentHeaderList.get(0);
 	int hinId = 0;
 	int patientTypeId = 0;
 	if(patientStoreIndentHeader.getHin() != null){
 		hinId = patientStoreIndentHeader.getHin().getId();
 	}
 	System.out.println("hinId=="+hinId);
 	if(patientStoreIndentHeader.getHin().getPatientType() != null){
 		patientTypeId = patientStoreIndentHeader.getHin().getPatientType().getId();
 	}
 	

 	String deptCode = "";
 	if(map.get("deptCode") != null){
 		deptCode = (String)map.get("deptCode");
 	}
%>


<%-- Title --%>

<form name="patientDrugIssue" method="post">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Issue Details</h4>
<div class="clear"></div>
<div class="Block"><label>Issue No. </label> <input type="text"
	name="issueNo" id="issueNo" value="1" tabindex="1" class="readOnly"
	readonly="readonly" MAXLENGTH="8"/  ><label>Issue Date</label>
<input type="text" name="<%=ISSUE_DATE%>" tabindex="1" class="readOnly"
	readonly="readonly" value="<%=date %>" MAXLENGTH="30" />

<div class="clear"></div>
<%if(patientStoreIndentHeader.getInpatient()!=null){ %>
<label><%=prop.getProperty("com.jkt.hms.opd_no")%></label> <label class="value"><%=patientStoreIndentHeader.getInpatient().getAdNo() %></label>
<%}%>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label class="value"><%=patientStoreIndentHeader.getHin().getHinNo() %></label>
<label>Patient Name</label> <label class="value"><%=patientStoreIndentHeader.getHin().getPFirstName()+" "+patientStoreIndentHeader.getHin().getPMiddleName()+ " "+patientStoreIndentHeader.getHin().getPLastName()%></label>

<div class="clear"></div>
<label>Department</label> <label class="value"><%=patientStoreIndentHeader.getDepartment().getDepartmentName() %></label>

<label>Demand No.</label> <label class="value"><%= patientStoreIndentHeader.getDemandNo()%></label>

<label>Demand Date</label> <label class="value"><%=HMSUtil.convertDateToStringWithoutTime(patientStoreIndentHeader.getDemandDate()) %></label>
<div class="clear"></div>

<label>Request By</label> <label class="value"><%=users.getEmployee().getFirstName() + " "+ users.getEmployee().getMiddleName()+" "+  users.getEmployee().getLastName() %></label>

<label>Issued By</label> <select name="<%= ISSUED_BY%>" tabindex="1"
	id="issuedBy" validate="Issued By,String,Yes">
	<option value="">Select</option>
	<%for (MasEmployee masEmployee :employeeList ) {%>
	<option value=<%=masEmployee.getId()%>
		<%=HMSUtil.isSelected(masEmployee.getId().toString(),users.getId()) %>><%=masEmployee.getFirstName()+" "+masEmployee.getLastName()%></option>
	<%}%>
</select> <input type="hidden" name="patientIndentHeaderId"
	value="<%=patientStoreIndentHeader.getId() %>" /> <input type="hidden"
	id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
	value="<%=patientTypeId %>" /> 
	<%if(patientStoreIndentHeader.getInpatient()!=null){ %>
	<input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"	value="<%=patientStoreIndentHeader.getInpatient().getDoctor().getId() %>" />
<input type="hidden" id="" name="<%=CONSULTING_DOCTOR %>"
	value="<%=patientStoreIndentHeader.getInpatient().getDoctor().getFirstName()+" "+patientStoreIndentHeader.getInpatient().getDoctor().getMiddleName()+" "+patientStoreIndentHeader.getInpatient().getDoctor().getLastName() %>" />
<%} %>
<%
if(patientStoreIndentHeader.getHin().getCompany() != null){
%> <input type="hidden" id="companyId" name="companyId"
	value="<%=patientStoreIndentHeader.getHin().getCompany().getId() %>" />
<%} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=patientStoreIndentHeader.getHin().getId() %>" />
	 <%if(patientStoreIndentHeader.getInpatient()!=null){ %>
	  <input	type="hidden" name="<%=INPATIENT_ID%>" 	value="<%=patientStoreIndentHeader.getInpatient().getId() %>" />
	 <input	type="hidden" name="<%=AD_NO%>" value="<%=patientStoreIndentHeader.getInpatient().getAdNo() %>" />
	 <%} %>
	  <input 	type="hidden" name="<%=HIN_NO %>"
	value="<%=patientStoreIndentHeader.getHin().getHinNo() %>" /> <input
	type="hidden" name="<%=PATIENT_NAME%>"
	value="<%=patientStoreIndentHeader.getHin().getPFirstName() %> <%=patientStoreIndentHeader.getHin().getPMiddleName()%> <%=patientStoreIndentHeader.getHin().getPLastName()%>" />
<input type="hidden" name="<%=AGE%>"
	value="<%=patientStoreIndentHeader.getHin().getAge() %>" /> <input
	type="hidden" name="<%=SEX_ID%>"
	value="<%=patientStoreIndentHeader.getHin().getSex().getId() %>" />
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Item Details</h4>
<div class="clear"></div>
<table colspan="7" id="indentDetails">
	<thead>
		<tr>
			<th width="5%">S.No.</th>
			<th width="13%">Item No</th>
			<th width="10%">Item Name</th>
			<th width="13%">A/U</th>
			<th width="13%">Available Stock</th>
			<th width="13%">Qty Requested</th>
			<th width="13%">Qty Issued</th>
			<th width="13%">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<% int inc = 1;
	  	for(PatientStoreIndentDetails patientStoreIndentDetails : patientIndentDetailsList){
	  		String pvmsNo="";
	  		if(patientStoreIndentDetails.getItem()!=null){
		  		pvmsNo=patientStoreIndentDetails.getItem().getPvmsNo();
	  		}
		  %>
		<tr>
			<td><input type="hidden" size="2"
				value="<%=patientStoreIndentDetails.getId() %>" MAXLENGTH="7"
				name="patientIndentDetailsId<%=inc %>"
				id="patientIndentHeaderId<%=inc %>" /> <input type="text" size="2"
				tabindex="1" value="<%=inc %>" id="srNo<%=inc %>" name="<%=SR_NO%>"
				readonly="readonly" /></td>
			<td><input type="text" size="8" tabindex="1"
				name="<%=ITEM_CODE%><%=inc %>"
				value="<%=pvmsNo %>"
				id="itemCode<%=inc %>" /> <input type="hidden" size="2"
				value="<%=patientStoreIndentDetails.getItem().getId() %>"
				MAXLENGTH="7" name="<%=ITEM_ID%><%=inc %>" id="itemId<%=inc %>" />
			</td>
			<td><input type="text" size="50" tabindex="1"
				value="<%=patientStoreIndentDetails.getItem().getNomenclature() %>"
				id="" name="<%=NOMENCLATURE%><%=inc %>" /></td>
			<td><input type="text" size="8" value="" id="au<%=inc %>"
				readonly /></td>
			<td><input type="text" size="8" value=""
				id="availableStock<%=inc %>" readonly /></td>
			<td><input type="text" size="8"
				value="<%=patientStoreIndentDetails.getQtyRequest() %>"
				readonly="readonly" name="<%=QTY_IN_REQUEST%><%=inc %>" id="" /></td>
			<td><input type="text" size="8" tabindex="1" readonly="readonly"
				value="" name="<%=QUANTITY%><%=inc %>" tabindex="2"
				id="qty<%=inc %>" /></td>
			<td><input type="button" class="buttonIssue" tabindex="1"
				onclick="{openPopupForItem(<%=inc%>);}" name="Submit2"  />
			<input type="hidden" size="10" value="" id="amount<%=inc%>"
				name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
				readonly="readonly" /> <input type="hidden" value="" size="11"
				id="salesTaxAmt<%=inc%>" name="<%=SALES_TAX_AMOUNT %><%=inc%>"
				readonly="readonly" validate="Sales Tax Persentage,string,no" /> <input
				type="hidden" value="" id="dispercent<%=inc%>"
				name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="8"
				validate="Discount Persentage,string,no"
				onchange="if(checkDiscountAmt(<%=inc %>)){calculateBatchWiseDiscount(<%=inc %>); calculateDiscountAmt(<%=inc%>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();};"
				maxlength="3" /> <input type="hidden" value=""
				id="disamount<%=inc%>" size="10" name="<%=DISCOUNT %><%=inc%>"
				validate="Discount Amount,string,no"
				onchange="validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateBatchWiseDiscount(<%=inc %>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();"
				maxlength="7" /> <input type="hidden" value=""
				id="prprtnlDis<%=inc%>" name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
				validate="Proporational Discount,string,no" readonly="readonly"
				size="12" /> <input type="hidden" size="10" value=""
				id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
				validate="Net Amount,float,no" readonly="readonly" /> <input
				type="hidden" id="itemBatchCount<%=inc %>" value="" /> <input
				type="hidden" name="<%=FA_ACCOUNT_ID %><%=inc%>"
				id="accountId<%=inc%>" value="" /> <input type="hidden"
				name="<%=FA_SUB_LED_ID %><%=inc%>" id="subAccountId<%=inc%>"
				value="" /> <input type="hidden" name="issued<%=inc%>"
				id="issued<%=inc%>" value="" /></td>
		</tr>
		<%inc++;} %>

	</tbody>

</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueItem"
	id="hiddenValueCharge" />
<div class="Block" style="display: none;">
<div class="clear"></div>

<input type="text" class="readOnlySmall" id="totalAmtId"
	name="<%=BILL_AMOUNT %>" readonly="readonly" /> <input type="text"
	id="outstandingId" name="<%=OUTSTANDING %>" class="readOnlySmall"
	readonly="readonly" /> <input type="text" id="compDiscountId"
	name="compDiscount" class="readOnlySmall" readonly="readonly" value="" />
<input type="hidden" id="totalDisId" name="<%=DISCOUNT_AMOUNT %>"
	class="readOnlySmall" readonly="readonly" /> <input type="text"
	id="charityId" name="charity" class="readOnlySmall" readonly="readonly"
	value="" /> <input type="text" id="totalNetId"
	name="<%=TOTAL_AMOUNT%>" value="" class="readOnlySmall" readOnly />
<div class="clear"></div>
<input type="text" id="discountOnBillId" name="<%=DISCOUNT_ON_BILL %>"
	class="small" validate="Discount On Bill,float,no" maxlength="5" /><label
	class="smallAuto">(%)</label> <input type="text" id="roundId"
	name="<%=ROUND_OF_VALUE %>" class="readOnlySmall" readonly="readonly" />
<input type="text" id="payableAmtId" name="<%=PAYABLE_AMOUNT %>"
	value="" class="readOnlySmall" readOnly />
<div class="clear"></div>
</div>
<table style="display: none;" id="batchDetails">



</table>
<input type="hidden" id="totalBatchId" name="batchNoCounter" value="<%=inc%>" />
<input type="button" tabindex="1" name="Submit1" class="button"
	value="Submit"
	onclick="{submitForm('patientDrugIssue','billing?method=submitPatientDrugIssueAndBillingDetails');}" />
<input type="button" name="back" id="back" value="Back" class="button" onclick="{submitForm('patientDrugIssue','billing?method=showPatientDrugIssueJsp');}" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<div class="paddingTop40"></div>
<%-- End of Main form --%>


<script type="text/javascript">

function confirm()
{
	formName="patientDrugIssue";
	obj = eval('document.'+formName);
	if((document.getElementById('issuedBy').value != "") &&(document.getElementById('departmentIdTemp').value != "") &&(document.getElementById('requestBy').value != "")&&(document.getElementById('approvedBy').value != ""))
	{
    	obj.action = "/hms/hms/stores?method=searchInternalIndentDetails";
    	obj.submit();
    }
	else
	{
		alert("Pl. check the Input Values!.........")
		return false
	}
}


function isToDepartmentSelected(){

	if(document.getElementById('toDeptId').value==""){
	alert("Department Name...!")
		return false;
	}else{
		submitProtoAjax('searchPanel','stores?method=getIssueList&toDeptId='+document.getElementById('toDeptId').value);
	}
	}



function openPopupForItem(rowVal){
var code = "";
code = document.getElementById('itemCode'+rowVal).value;
	if(code !=""){
		window.open('opBilling?method=showItemBatchNoPopUp&itemCode='+encodeURIComponent(code)+'&rowVal='+rowVal+'&hinId='+<%=hinId%>+'&patientTypeId=<%=patientTypeId%>&deptCode=<%=deptCode%>','mywindow','target="_blank", width=780,height=300');

	}

}

</script>