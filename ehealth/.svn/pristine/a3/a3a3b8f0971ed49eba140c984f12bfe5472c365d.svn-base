<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : billCompanySettlement.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasCompany"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript">

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

<form name="companySettlement" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<MasCompany> companyList = new ArrayList<MasCompany>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("companyList") != null){
			companyList= (List<MasCompany>)map.get("companyList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%>
<h4><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Company Settlement</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Company</label>
<select	name="<%=COMPANY %>" validate="Company,string,yes">
	<option value="0">Select</option>
	<%
     for(MasCompany company : companyList){
   %>
	<option value="<%=company.getId() %>"><%=company.getCompanyName() %></option>
	<%
     }
    	 %>
</select>
<label>OP</label>
<input type="radio" name="patientTypeRadio"	value="op" checked="checked" class="radioCheck"	onclick="setPtypeValue(this.value);">
<label class="auto">IP</label>
<input type="radio" name="patientTypeRadio" value="ip"	class="radioCheck" onclick="setPtypeValue(this.value);">
<label	class="auto">Both</label>
<input type="radio" name="patientTypeRadio"	value="both" class="radioCheck" onclick="setPtypeValue(this.value);">
<input	type="hidden" id="patientType" name="patientType" value="op">
<input	type="button" name="Search" id="addbutton"	onclick="submitProtoAjax('companySettlement','/hms/hms/opBilling?method=getCompanyPatientListForSettlement','testDiv');" value="Search" class="button" accesskey="a" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="testDiv"></div>
<script type="text/javascript">
		function calculateTotalPaidAmt(){
			var count = document.getElementById('billCount').value;
			var totalPaid = 0;
			for(var i=1;i<count;i++){
				if(document.getElementById('billId'+i).checked){
					totalPaid = parseFloat(totalPaid) + parseFloat(document.getElementById('paidAmtId'+i).value);
				}
			}
			document.getElementById('totalsettledid').value = totalPaid;
			document.getElementById('totalbalanceid').value = parseFloat(document.getElementById('totaldueid').value) - parseFloat(totalPaid);
		}

		function setPtypeValue(val){
			document.getElementById('patientType').value = val;

		}

		function checkPaidAmount(){
			var paidAmt = document.getElementById('amtId').value;
			var settledamt = document.getElementById('totalsettledid').value;
			if(parseFloat(paidAmt) != parseFloat(settledamt)){
				alert("Paid Amount should be equal to Settled Amount.");
				return false;
			}
			return true;
		}
		function checkAllOPS(){
			var count = document.getElementById('countOPD').value;

			if(document.getElementById('checkallOPS').checked == true){
				for(var i=1;i<=count;i++){
					if(document.getElementById('billId'+i).disabled == false)
						document.getElementById('billId'+i).checked = true;
				}
			}else if(document.getElementById('countOPD').checked == false){
				for(var i=1;i<count;i++){
					document.getElementById('billId'+i).checked = false;
				}

			}

		}

		function checkAllOPD(){
			var count = document.getElementById('countOPD').value;

			if(document.getElementById('checkallOPD').checked == true){
				for(var i=1;i<=count;i++){
					if(document.getElementById('billId'+i).disabled == false)
						document.getElementById('billId'+i).checked = true;
				}
			}else if(document.getElementById('countOPD').checked == false){
				for(var i=1;i<count+1;i++){
					document.getElementById('billId'+i).checked = false;
				}

			}

		}

	</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


