<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * billupdatePackageMaster.jsp  
 * Purpose of the JSP -  This is for Package master 
 * @author  Ritu
 * Create Date: 16 July,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>

<%@page import="jkt.hms.masters.business.BlPackageHeader"%>
<%@page import="java.math.BigDecimal"%>

<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%
	Map map = new HashMap();
	List<BlPackageHeader> packageList = new ArrayList<BlPackageHeader>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	List<FaMasAccount> accountList = new ArrayList<FaMasAccount>();

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("packageList") != null){
		packageList = (List<BlPackageHeader>)map.get("packageList");
	}
	
	if(map.get("departmentList") != null){
		departmentList = (List<MasDepartment>)map.get("departmentList");
	}
	
	if(map.get("sexList") != null){
		sexList = (List<MasAdministrativeSex>)map.get("sexList");
	}
	
	/* if(map.get("accountList") != null){
		accountList = (List<FaMasAccount>)map.get("accountList");
	} */
	System.out.println(packageList.size());
	BlPackageHeader packageHeader = packageList.get(0);
%>
<form name="updatePackageMaster" method="post" action="">
<div class="titleBg">
<h2>Update Package Master</h2>
</div>

<div class="clear"></div>
<h4>Package Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><input type="hidden" name="<%= PACKAGE_ID %>"
	value="<%=packageHeader.getId() %>" /> <label>Package Code</label> <input
	type="text" name="<%= PACKAGE_CODE %>"
	value="<%=packageHeader.getPackageCode() %>" readonly="readonly"
	tabindex=1 /> <label><span>*</span> Package Desc</label> <input
	type="text" name="<%= PACKAGE_DESCRIPTION %>"
	value="<%=packageHeader.getPackageDesc() %>" MAXLENGTH="30" tabindex=1 />

<%-- <label><span>*</span> Department</label> <select id="deptId"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
		for(MasDepartment department : departmentList){
	%>
	<option value="<%=department.getId() %>"><%= department.getDepartmentName()%></option>
	<%} %>
</select> <script type="text/javascript">
document.getElementById('deptId').value = <%=packageHeader.getDepartment().getId()%>
</script> --%>
<div class="clear"></div>

<%-- <label><span>*</span> Effective From Date</label> <input type="text"
	name="<%=EFFECTIVE_DATE_FROM %>"
	value="<%=HMSUtil.convertDateToStringTypeDateOnly(packageHeader.getEffectiveFromDate()) %>"
	class="date" readonly="readonly"
	validate="Effective From Date,date,yes" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('',document.updatePackageMaster.<%=EFFECTIVE_DATE_FROM%>,event)" />


<label>Effective To Date</label> <input type="text"
	name="<%=EFFECTIVE_DATE_TO %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(packageHeader.getEffectiveToDate()) %>"
	class="date" readonly="readonly" validate="Effective To Date,date,no"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date"
	onclick="setdate('',document.updatePackageMaster.<%=EFFECTIVE_DATE_TO%>,event)" />



<label>Account Code</label> <select id="accountId"
	name="<%= ACCOUNT_ID%>" validate="Account Code,string,no">
	<option value="0">Select</option>
	<%
for(FaMasAccount masAccount :accountList) {
	
%>
	<option value="<%=masAccount.getId()%>"><%=masAccount.getAccDesc()%></option>
	<%}%>

</select>
<div class="clear"></div>
<label>Sex</label> <select id="sexId" name="<%=SEX_ID %>">
	<option value="0">Select</option>
	<%
	for(MasAdministrativeSex sex : sexList){
%>
	<option value="<%=sex.getId() %>"><%=sex.getAdministrativeSexName() %></option>

	<%} %>
</select> <script type="text/javascript">
<%
	if(packageHeader.getSex() != null){
%>
document.getElementById('sexId').value = <%=packageHeader.getSex().getId()%>
<%}%>
</script> <label>From Age</label> <input type="text" name="<%=FROM_AGE %>"
	value="<%=packageHeader.getFromAge() %>" /> <label>To Age</label> <input
	type="text" name="<%=TO_AGE %>" value="<%=packageHeader.getToAge() %>" />

<div class="clear"></div>

<script type="text/javascript">
<%
	if(packageHeader.getAccount() != null){
%>
document.getElementById('accountId').value = <%=packageHeader.getAccount().getId()%>

<%}%>
</script>

<div class="clear"></div>

<label>Additional Medicine Amount</label> <%
	if(packageHeader.getAdditionalMedicineAmt() != null){
%> <input type="text" name="<%=ADDITIONAL_MEDICINE_AMOUNT %>"
	value="<%=packageHeader.getAdditionalMedicineAmt() %>" /> <%}else{ %> <input
	type="text" name="<%=ADDITIONAL_MEDICINE_AMOUNT %>" value="" /> <%} %> <label>Frozen</label>
<input type="checkbox" name="frozen" class="radioCheck" value="1" /> --%>
<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>Package Value Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label
	class="subHeading">Cost of Services</label> <%
	if(packageHeader.getTotalValueOfServices() != null){
%> <input type="text" class="date" id="totalServValue"
	name="<%=COST_OF_SERVICES %>"
	value="<%=packageHeader.getTotalValueOfServices() %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="date"
	id="totalServValue" name="<%=COST_OF_SERVICES %>" value=""
	readonly="readonly" /> <%} %> 
	<label class="subHeading">Medicines</label>
<%
	if(packageHeader.getTotalValueOfMedicines() != null){
%> <input type="text" class="date" id="totalMedValue"
	name="<%=COST_OF_MEDICINES %>"
	value="<%=packageHeader.getTotalValueOfMedicines() %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="date"
	id="totalMedValue" name="<%=COST_OF_MEDICINES %>" value=""
	readonly="readonly" /> <%} %> 
	<label class="subHeading">Package</label>
<%
	if(packageHeader.getTotalValueOfPackage() != null){
%> <input type="text" class="date" id="totalPkgValue"
	name="<%=COST_OF_PACKAGE %>"
	value="<%=packageHeader.getTotalValueOfPackage() %>"
	 /> <%}else{ %> <input type="text" class="date"
	id="totalPkgValue" name="<%=COST_OF_PACKAGE %>" value=""
	readonly="readonly" /> <%} %>

<div class="clear"></div>

 <%-- <label class="subHeading">Disc. Value of Services</label>
<%
	if(packageHeader.getDiscountedValueOfServices() != null){
%> <input type="text" id="discServVal" class="date"
	name="<%=DISCOUNTED_VALUE_SERVICES %>"
	value="<%=packageHeader.getDiscountedValueOfServices() %>"
	readonly="readonly" /> <%}else{ %> <input type="text" id="discServVal"
	class="date" name="<%=DISCOUNTED_VALUE_SERVICES %>" value=""
	readonly="readonly" /> <%} %> <label class="subHeading">Medicines</label>
<%
	if(packageHeader.getDiscountedValueOfMedicines() != null){
%> <input type="text" id="discMedVal" class="date"
	name="<%=DISCOUNTED_VALUE_MEDICINES %>"
	value="<%=packageHeader.getDiscountedValueOfMedicines() %>"
	readonly="readonly" /> <%}else{ %> <input type="text" id="discMedVal"
	class="date" name="<%=DISCOUNTED_VALUE_MEDICINES %>" value=""
	readonly="readonly" /> <%} %> <label class="subHeading">Package</label>
<%
	if(packageHeader.getDiscountedValueOfPackage() != null){
%> <input type="text" class="date" id="discPkgValue"
	name="<%=DISCOUNTED_VALUE_PACKAGE %>"
	value="<%=packageHeader.getDiscountedValueOfPackage() %>"
	readonly="readonly" /> <%}else{ %> <input type="text" class="date"
	id="discPkgValue" name="<%=DISCOUNTED_VALUE_PACKAGE %>" value=""
	readonly="readonly" /> <%} %>

 --%>
<div class="division"></div>
<div class="clear"></div>

<%-- label>Distributed Discount/Tariff</label> <%
BigDecimal dtdPkgDis = new BigDecimal(0);
BigDecimal dtdPkgTrf = new BigDecimal(0);

if(packageHeader.getDistributedPkgDiscount() != null){
	dtdPkgDis  = packageHeader.getDistributedPkgDiscount();
}

if(packageHeader.getDistributedPkgTariff() != null){
	dtdPkgTrf = packageHeader.getDistributedPkgTariff();
}
%> <input type="text" name="<%=DISTRIBUTED_DISCOUNT_TARIFF %>"
	value="<%=dtdPkgDis.subtract(dtdPkgTrf)%>" readonly="readonly" /> <label>Disc.
On Base Amt</label> <input type="radio" name="<%=DISCOUNT_ON %>" value="1"
	class="radioCheck" /> <label>Disc. On Discounted Amt</label> <input
	type="radio" name="<%=DISCOUNT_ON %>" value="2" class="radioCheck" />
<div class="clear"></div> --%>

<%-- <label> Discount Type</label> <select name="<%=DISCOUNT_TYPE%>"
	id="discountTypeId" validate="Discount Type,string,no"
	onchange="changeLabel(this.value)">
	<option value="">Select</option>
	<option value="D">Discount</option>
	<option value="T">Tariff</option>
</select> <label id="distrfPerLbl">Discount(%)</label> <input type="text"
	name="<%=DISCOUNT_PERCENTAGE %>" id="discountPercentId" value=""
	validate="Discount percentage,float,no"
	onblur="calculateDiscountAmtPercent(this.value,this.id);" MAXLENGTH="3"
	tabindex=1 /> <label id="distrfValLbl"> Discount Value</label> <input
	type="text" class="date" name="<%=DISCOUNT_VALUE %>" id="discountValId"
	value="" onblur="calculateDiscountAmtPercent(this.value,this.id);"
	validate="Discount value,float,no" MAXLENGTH="9" tabindex=1 />


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

 <label class="subHeading">Net Value of Services</label> <input
	type="text" class="date" name="<%=NET_VALUE_SERVICES %>"
	id="netValServId" value="" readonly="readonly"
	validate="Discount Amount,float,no" MAXLENGTH="9" tabindex=1 /> <label
	class="subHeading">Medicines</label> <input type="text" class="date"
	name="<%=NET_VALUE_MEDICINES %>" id="netValMedId" value=""
	readonly="readonly" validate="Discount Amount,float,no" MAXLENGTH="9"
	tabindex=1 /> <label class="subHeading">Package</label> <input
	type="text" class="date" name="<%=NET_VALUE_PACKAGE %>"
	id="netValPkgId" value="" readonly="readonly"
	validate="Discount Amount,float,no" MAXLENGTH="9" tabindex=1 /> --%>



</div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="update" value="Update" class="button"
	onClick="submitForm('updatePackageMaster','packageBilling?method=updatePackageDetails');"
	tabindex=1 /> <input type="reset" name="Reset" value="Reset"
	class="buttonHighlight" accesskey="r" /> <input type="button"
	name="back" value="Back" class="button"
	onClick="submitFormCancel('updatePackageMaster','packageBilling?method=showBillingPackageListJsp')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">


function changeLabel(distype){
	if(distype != ""){
		if(distype == "D"){
			document.getElementById('distrfPerLbl').innerHTML = 'Discount (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Discount Value';
		}else if(distype == "T"){
			document.getElementById('distrfPerLbl').innerHTML = 'Tariff (%)';
			document.getElementById('distrfValLbl').innerHTML = 'Tariff Value';
		}
	}
}



function calculateDiscountAmtPercent(val,id){
	var pkgAmt = 0;	
	var pkgDisAmt= 0;
	var servAmt = 0;	
	var servDisAmt= 0;
	var medAmt = 0;	
	var medDisAmt= 0;
	var disPercent = 0
	for (var i=0; i < document.updatePackageMaster.discountOn.length; i++)
   	{
   		if (document.updatePackageMaster.discountOn[i].checked)
     	 {
     	 var rad_val = document.updatePackageMaster.discountOn[i].value;
     	 }
   }

	if(val != ""){
		if(validateFloat(val)){
		
			if(rad_val == 2){
				pkgAmt = document.getElementById('discPkgValue').value;
				if(document.getElementById('discServVal').value != "")
					servAmt = document.getElementById('discServVal').value;
				if(document.getElementById('discMedVal').value != "")	
					medAmt = document.getElementById('discMedVal').value;
					
			}else if(rad_val == 1){
				pkgAmt = document.getElementById('totalPkgValue').value;
				if(document.getElementById('totalServValue').value != "")
					servAmt = document.getElementById('totalServValue').value;
				if(document.getElementById('totalMedValue').value != "")
					medAmt =  document.getElementById('totalMedValue').value;
					
			}
			
			if(id == 'discountPercentId'){
				disPercent = val;
				pkgDisAmt = parseFloat(pkgAmt)*parseFloat(val)/100;
				document.getElementById('discountValId').value = pkgDisAmt.toFixed(2);
			}else if(id == 'discountValId'){
				pkgDisAmt = val;
				disPercent = parseFloat(pkgDisAmt)*100/parseFloat(pkgAmt);
				document.getElementById('discountPercentId').value = disPercent.toFixed(2);
			}
			
			if(servAmt != 0)
				servDisAmt = parseFloat(servAmt)*parseFloat(disPercent)/100;
			if(medAmt != 0)
				medDisAmt =  parseFloat(medAmt)*parseFloat(disPercent)/100;
			
			
			if(document.getElementById('discountTypeId').value == "D"){
				document.getElementById('netValPkgId').value = (parseFloat(document.getElementById('discPkgValue').value)- parseFloat(pkgDisAmt.toFixed(2))).toFixed(2);
				if(servAmt != 0)
					document.getElementById('netValServId').value = (parseFloat(document.getElementById('discServVal').value)- parseFloat(servDisAmt.toFixed(2))).toFixed(2);
				if(medAmt != 0)
					document.getElementById('netValMedId').value = (parseFloat(document.getElementById('discMedVal').value)- parseFloat(medDisAmt.toFixed(2))).toFixed(2);
			
			}else if(document.getElementById('discountTypeId').value == "T"){
				document.getElementById('netValPkgId').value = (parseFloat(document.getElementById('discPkgValue').value)+ parseFloat(pkgDisAmt.toFixed(2))).toFixed(2);
				if(servAmt != 0)
					document.getElementById('netValServId').value = (parseFloat(document.getElementById('discServVal').value)+ parseFloat(servDisAmt.toFixed(2))).toFixed(2);
				if(medAmt != 0)
					document.getElementById('netValMedId').value = (parseFloat(document.getElementById('discMedVal').value)+ parseFloat(medDisAmt.toFixed(2))).toFixed(2);
			
			}
		}else{
			alert("Discount Amount should be integer or decimal.");
			return false;
		}
	}

}
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
