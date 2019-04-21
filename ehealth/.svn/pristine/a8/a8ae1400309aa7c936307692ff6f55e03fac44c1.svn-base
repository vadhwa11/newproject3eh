<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

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

<form name="deposit" id="form1" method="post" action="">
<%

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> patientMap = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient> patientDetailsList = new ArrayList<Patient>();
	List<MasBankMaster> bankList = new ArrayList<MasBankMaster>();
	List<PhMemberSurvey> memberSurveyDetailList = new ArrayList<PhMemberSurvey>();


	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");

	if(map.get("patientMap") != null){
		patientMap= (Map<String, Object>)map.get("patientMap");
	}

	if(patientMap.get("patientDetailsList") != null){
		patientDetailsList = (List<Patient>)patientMap.get("patientDetailsList");
	}
	if(patientMap.get("memberSurveyDetailList") != null){
		memberSurveyDetailList = (List<PhMemberSurvey>)patientMap.get("memberSurveyDetailList");
	}
	if (patientMap.get("bankList") != null) {
		bankList = (List<MasBankMaster>) patientMap.get("bankList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	String hinNo = "";
	int patTypeId=0;
	   	if(patientDetailsList.size() > 0){
	   		for(Patient patient12 : patientDetailsList){
	   		hinNo = patient12.getHinNo();
	   		patTypeId=	patient12.getPatientType().getId();
	   		}}
	   	
	   	
	   	
	   	%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<h4><span><%=message %></span></h4>
<%if(patTypeId==13){

%>
<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
<div class="clear"></div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="titleBg">
<h2>Patient Advance</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%-- <%
			String receiptNo = "";
			if(map.get("receiptNo") != null){
				receiptNo = (String)map.get("receiptNo");
			}

		%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
Time</label> <label class="value"><%=time %></label> --%>
<div class="clear"></div>

<%
   String patientName = "";
   String hin = "";
   String pastDue = "";
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   			patientName = patient.getPFirstName();
   			if(patient.getPMiddleName()!=null){
   				patientName +=" "+patient.getPMiddleName();
   			}
   			if(patient.getPLastName()!=null){
   				patientName +=" "+patient.getPLastName();
   			}
   			hin = patient.getHinNo();
   			if(patient.getPastDue() != null){
   				pastDue = patient.getPastDue();
   			}

		    String adNo = "";
		    int inpatientId = 0;
		    if(patient.getInpatients() != null)
		    {
				Set<Inpatient> inpatientSet = patient.getInpatients();
				for(Inpatient inpatient :inpatientSet){
					if(!inpatient.getAdStatus().equals("D")){
						inpatientId = inpatient.getId();
						adNo = inpatient.getAdNo();
					}
				}
		    }
	    	if(!adNo.equals("")){
	    %>
<%-- <label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
 <label class="value"><%=adNo%></label> --%> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value"><%=patient.getHinNo() %></label> <label>Patient
Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
<label class="value"> <%=patient.getAge() %></label> 
<div class="clear"></div>

<label>Gender</label>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%-- <%
	    	if(!pastDue.equals("")){
	    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
<%} %> --%>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
	type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

		}%>
<div class="clear"></div></div>
<h4>Nominee Details</h4>
<div class="clear"></div>
	<div id="pageNavPosition"></div>
	
		<table width="100%" border="0" cellpadding="0" cellspacing="0">

			<tr>
				<th scope="col">Name</th>
				<th scope="col">Relation</th>
				<th scope="col">Date Of Birth</th>
				<th scope="col">Mobile No</th>
			</tr>
		<tbody id="tableData">
		
		<%
		if(memberSurveyDetailList.size()>0){
			for(PhMemberSurvey memberSurvey : memberSurveyDetailList){
			
			
			
		
		
		%>
		
			<tr style="cursor: pointer;"
				onclick="submitForm('patientAdvanceMemberDetail','/hms/hms/opBilling?method=getMemberDetailsForPatientAdvance&surveyId=<%=memberSurvey.getId()%>')">
				
				<td><%=memberSurvey.getName() != null?memberSurvey.getName():"" %></td>
				<td><%=memberSurvey.getRelationshipName()!= null?memberSurvey.getRelationshipName():"" %></td>
				<td><%=memberSurvey.getDateOfBirth() != null?memberSurvey.getDateOfBirth():""%></td>
				<td><%=memberSurvey.getContactNo() != null?memberSurvey.getContactNo():"" %></td>
				
				</tr>
			</tbody>
<%} %>
		</table>
		<%}else{ %>
		<h4>No Record Found</h4>
		<%} %> 


		<div class="clear"></div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowForPayment();" />

<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="paymentDetails">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Advance Type</th>
		<th scope="col">Advance Amt</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>
		<th scope="col"></th>
	</tr>
	<%
     	int i = 1;

    	%>

	<tr>
		<td><input type="radio" value="<%=i%>" name="selectedPayMode"
			class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %><%=i %>"
			id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
			id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
			maxlength="100"/></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
			id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
			id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			style="display: none;" validate="Pick a date" class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
		</td>
		<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
			disabled="disabled" tabindex="6">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (MasBankMaster bankMaster : bankList) {
			%>
			<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
			bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>
		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRowForPayment('deposit');" tabindex="7" /></td>
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Amount</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
	readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" tabindex="8" value="Submit"
	name="Submit"
	onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
	align="right" />

<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
<div class="clear"></div>
<div class="division"></div>

<% }if(patTypeId==21){%>


%>
<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
<div class="clear"></div>

<script type="text/javascript">
var bankArray=new Array();
</script>

<div class="titleBg">
<h2></h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%
			String receiptNo = "";
			if(map.get("receiptNo") != null){
				receiptNo = (String)map.get("receiptNo");
			}

		%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
Time</label> <label class="value"><%=time %></label>
<div class="clear"></div>

<%
   String patientName = "";
   String hin = "";
   String pastDue = "";
   	if(patientDetailsList.size() > 0){
   		for(Patient patient : patientDetailsList){
   			patientName = patient.getPFirstName();
   			if(patient.getPMiddleName()!=null){
   				patientName +=" "+patient.getPMiddleName();
   			}
   			if(patient.getPLastName()!=null){
   				patientName +=" "+patient.getPLastName();
   			}
   			hin = patient.getHinNo();
   			if(patient.getPastDue() != null){
   				pastDue = patient.getPastDue();
   			}

		    String adNo = "";
		    int inpatientId = 0;
		    if(patient.getInpatients() != null)
		    {
				Set<Inpatient> inpatientSet = patient.getInpatients();
				for(Inpatient inpatient :inpatientSet){
					if(!inpatient.getAdStatus().equals("D")){
						inpatientId = inpatient.getId();
						adNo = inpatient.getAdNo();
					}
				}
		    }
	    	if(!adNo.equals("")){
	    %>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
 <label class="value"><%=adNo%></label> <input
	type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
	type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<label class="value"><%=patient.getHinNo() %></label> <label>Patient
Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
<%
	    	if(!pastDue.equals("")){
	    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
<%} %>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
	type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

		}%>
<div class="clear"></div></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Payment Details</h4>
<div class="clear"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowForPayment();" />

<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="paymentDetails">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Payment Mode</th>
		<th scope="col">Advance Type</th>
		<th scope="col">Advance Amt</th>
		<th scope="col">Cheque/Credit Card No</th>
		<th scope="col">Cheque/Credit Date</th>
		<th scope="col">Bank</th>
		<th scope="col"></th>
	</tr>
	<%
     	int i = 1;

    	%>

	<tr>
		<td><input type="radio" value="<%=i%>" name="selectedPayMode"
			class="radioCheck" /></td>
		<td><select name="<%=PAYMENT_MODE %><%=i %>"
			id="paymentModeId<%=i %>"
			onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
			<option value="">Select</option>
			<option value="C" selected="selected">Cash</option>
			<option value="Q">Cheque</option>
			<option value="R">Credit Card</option>
		</select></td>
		<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
			id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
			maxlength="100"/></td>
		<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
			id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
			maxlength="9"
			onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
			id="cqeId<%=i %>" maxlength="20" readonly="readonly"
			onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
		<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
			id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			style="display: none;" validate="Pick a date" class="calender"
			onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
		</td>
		<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
			disabled="disabled" tabindex="6">
			<option value="0">Select</option>
			<%
				int j = 0;
				for (MasBankMaster bankMaster : bankList) {
			%>
			<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
			<script>
			bankArray[<%=j%>]= new Array();
			bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
			bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

		</script>
			<%
				j++;
				}
			%>
		</select></td>
		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRowForPayment('deposit');" tabindex="7" /></td>
	</tr>
</table>
<input type="hidden" value="1" name="hiddenValuePayment"
	id="hiddenValuePayment" />

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label>Total Amount</label> <input type="text"
	id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
	readonly="readonly" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" tabindex="8" value="Submit"
	name="Submit"
	onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
	align="right" />

<input type="button" class="button" value="Back" align="left"
	onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
<div class="clear"></div>
<div class="division"></div>

<% 


}if(patTypeId==9){
	
	%>
	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<div class="clear"></div>

	<script type="text/javascript">
	var bankArray=new Array();
	</script>

	<div class="titleBg">
	<h2></h2>
	</div>
	<div class="clear"></div>
	<!--Block One Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
	<%
				String receiptNo = "";
				if(map.get("receiptNo") != null){
					receiptNo = (String)map.get("receiptNo");
				}

			%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

	<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
	Time</label> <label class="value"><%=time %></label>
	<div class="clear"></div>

	<%
	   String patientName = "";
	   String hin = "";
	   String pastDue = "";
	   	if(patientDetailsList.size() > 0){
	   		for(Patient patient : patientDetailsList){
	   			patientName = patient.getPFirstName();
	   			if(patient.getPMiddleName()!=null){
	   				patientName +=" "+patient.getPMiddleName();
	   			}
	   			if(patient.getPLastName()!=null){
	   				patientName +=" "+patient.getPLastName();
	   			}
	   			hin = patient.getHinNo();
	   			if(patient.getPastDue() != null){
	   				pastDue = patient.getPastDue();
	   			}

			    String adNo = "";
			    int inpatientId = 0;
			    if(patient.getInpatients() != null)
			    {
					Set<Inpatient> inpatientSet = patient.getInpatients();
					for(Inpatient inpatient :inpatientSet){
						if(!inpatient.getAdStatus().equals("D")){
							inpatientId = inpatient.getId();
							adNo = inpatient.getAdNo();
						}
					}
			    }
		    	if(!adNo.equals("")){
		    %>
	<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
	 <label class="value"><%=adNo%></label> <input
		type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
		type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
	<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
	<label class="value"><%=patient.getHinNo() %></label> <label>Patient
	Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
	<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
	<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
	<%
		    	if(!pastDue.equals("")){
		    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
	<%} %>
	<div class="clear"></div>
	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
		type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

			}%>
	<div class="clear"></div></div>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<h4>Payment Details</h4>
	<div class="clear"></div>
	<input type="button" name="delete" value="" class="buttonDel"
		onclick="removeRowForPayment();" />

	<div class="clear"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		id="paymentDetails">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Payment Mode</th>
			<th scope="col">Advance Type</th>
			<th scope="col">Advance Amt</th>
			<th scope="col">Cheque/Credit Card No</th>
			<th scope="col">Cheque/Credit Date</th>
			<th scope="col">Bank</th>
			<th scope="col"></th>
		</tr>
		<%
	     	int i = 1;

	    	%>

		<tr>
			<td><input type="radio" value="<%=i%>" name="selectedPayMode"
				class="radioCheck" /></td>
			<td><select name="<%=PAYMENT_MODE %><%=i %>"
				id="paymentModeId<%=i %>"
				onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
				<option value="">Select</option>
				<option value="C" selected="selected">Cash</option>
				<option value="Q">Cheque</option>
				<option value="R">Credit Card</option>
			</select></td>
			<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
				id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
				maxlength="100"/></td>
			<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
				id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
				maxlength="9"
				onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
				id="cqeId<%=i %>" maxlength="20" readonly="readonly"
				onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
				id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				style="display: none;" validate="Pick a date" class="calender"
				onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
			</td>
			<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
				disabled="disabled" tabindex="6">
				<option value="0">Select</option>
				<%
					int j = 0;
					for (MasBankMaster bankMaster : bankList) {
				%>
				<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
				<script>
				bankArray[<%=j%>]= new Array();
				bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
				bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

			</script>
				<%
					j++;
					}
				%>
			</select></td>
			<td><input type="button" name="add" value="" class="buttonAdd"
				onclick="addRowForPayment('deposit');" tabindex="7" /></td>
		</tr>
	</table>
	<input type="hidden" value="1" name="hiddenValuePayment"
		id="hiddenValuePayment" />

	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div class="Block"><label>Total Amount</label> <input type="text"
		id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
		readonly="readonly" />
	<div class="clear"></div>
	</div>

	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" tabindex="8" value="Submit"
		name="Submit"
		onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
		align="right" />

	<input type="button" class="button" value="Back" align="left"
		onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
	<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
	<div class="clear"></div>
	<div class="division"></div>

	<% } else if(patTypeId==12){
		
		%>
		<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
		<div class="clear"></div>

		<script type="text/javascript">
		var bankArray=new Array();
		</script>

		<div class="titleBg">
		<h2>Patient Advance</h2>
		</div>
		<div class="clear"></div>
		<!--Block One Starts-->
		<h4>Patient Details</h4>
		<div class="clear"></div>
		<div class="Block">
		<%
					String receiptNo = "";
					if(map.get("receiptNo") != null){
						receiptNo = (String)map.get("receiptNo");
					}

				%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

		<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
		Time</label> <label class="value"><%=time %></label>
		<div class="clear"></div>

		<%
		   String patientName = "";
		   String hin = "";
		   String pastDue = "";
		   	if(patientDetailsList.size() > 0){
		   		for(Patient patient : patientDetailsList){
		   			patientName = patient.getPFirstName();
		   			if(patient.getPMiddleName()!=null){
		   				patientName +=" "+patient.getPMiddleName();
		   			}
		   			if(patient.getPLastName()!=null){
		   				patientName +=" "+patient.getPLastName();
		   			}
		   			hin = patient.getHinNo();
		   			if(patient.getPastDue() != null){
		   				pastDue = patient.getPastDue();
		   			}

				    String adNo = "";
				    int inpatientId = 0;
				    if(patient.getInpatients() != null)
				    {
						Set<Inpatient> inpatientSet = patient.getInpatients();
						for(Inpatient inpatient :inpatientSet){
							if(!inpatient.getAdStatus().equals("D")){
								inpatientId = inpatient.getId();
								adNo = inpatient.getAdNo();
							}
						}
				    }
			    	if(!adNo.equals("")){
			    %>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
		 <label class="value"><%=adNo%></label> <input
			type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
			type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
		<label class="value"><%=patient.getHinNo() %></label> <label>Patient
		Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
		<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
		<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
		<%
			    	if(!pastDue.equals("")){
			    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
		<%} %>
		<div class="clear"></div>
		<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
			type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

				}%>
		<div class="clear"></div></div>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<h4>Payment Details</h4>
		<div class="clear"></div>
		<input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForPayment();" />

		<div class="clear"></div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="paymentDetails">
			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Payment Mode</th>
				<th scope="col">Advance Type</th>
				<th scope="col">Advance Amt</th>
				<th scope="col">Cheque/Credit Card No</th>
				<th scope="col">Cheque/Credit Date</th>
				<th scope="col">Bank</th>
				<th scope="col"></th>
			</tr>
			<%
		     	int i = 1;

		    	%>

			<tr>
				<td><input type="radio" value="<%=i%>" name="selectedPayMode"
					class="radioCheck" /></td>
				<td><select name="<%=PAYMENT_MODE %><%=i %>"
					id="paymentModeId<%=i %>"
					onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
					<option value="">Select</option>
					<option value="C" selected="selected">Cash</option>
					<option value="Q">Cheque</option>
					<option value="R">Credit Card</option>
				</select></td>
				<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
					id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
					maxlength="100"/></td>
				<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
					id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
					maxlength="9"
					onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
				<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
					id="cqeId<%=i %>" maxlength="20" readonly="readonly"
					onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
				<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
					id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
					src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					style="display: none;" validate="Pick a date" class="calender"
					onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
				</td>
				<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
					disabled="disabled" tabindex="6">
					<option value="0">Select</option>
					<%
						int j = 0;
						for (MasBankMaster bankMaster : bankList) {
					%>
					<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
					<script>
					bankArray[<%=j%>]= new Array();
					bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
					bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

				</script>
					<%
						j++;
						}
					%>
				</select></td>
				<td><input type="button" name="add" value="" class="buttonAdd"
					onclick="addRowForPayment('deposit');" tabindex="7" /></td>
			</tr>
		</table>
		<input type="hidden" value="1" name="hiddenValuePayment"
			id="hiddenValuePayment" />

		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<div class="Block"><label>Total Amount</label> <input type="text"
			id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
			readonly="readonly" />
		<div class="clear"></div>
		</div>

		<div class="clear"></div>
		<div class="division"></div>
		<input type="button" class="button" tabindex="8" value="Submit"
			name="Submit"
			onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
			align="right" />

		<input type="button" class="button" value="Back" align="left"
			onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
		<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
		<div class="clear"></div>
		<div class="division"></div>

		<% } 
 else if(patTypeId==14){ %>

	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<input type="button" name="Report" value="Receipt Print" class="buttonBig"onClick="submitForm('deposit','generalMaster?method=generateReceipt&hinNo=<%=hinNo%>');"/>

<%}
else if(patTypeId==15){ %>

	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<input type="button" name="Report" value="Receipt Print" class="buttonBig"onClick="submitForm('deposit','generalMaster?method=generateReceipt&hinNo=<%=hinNo%>');"/>


<%
}else if(patTypeId==16){ %>

	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<input type="button" name="Report" value="Receipt Print" class="buttonBig"onClick="submitForm('deposit','generalMaster?method=generateReceipt&hinNo=<%=hinNo%>');"/>

<%}else if(patTypeId==17){  %>
<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<input type="button" name="Report" value="Receipt Print" class="buttonBig"onClick="submitForm('deposit','generalMaster?method=generateReceipt&hinNo=<%=hinNo%>');"/>

<%}else  if(patTypeId==18){
	
	%>
	<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
	<div class="clear"></div>

	<script type="text/javascript">
	var bankArray=new Array();
	</script>

	<div class="titleBg">
	<h2>Patient Advance</h2>
	</div>
	<div class="clear"></div>
	<!--Block One Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
	<%
				String receiptNo = "";
				if(map.get("receiptNo") != null){
					receiptNo = (String)map.get("receiptNo");
				}

			%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

	<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
	Time</label> <label class="value"><%=time %></label>
	<div class="clear"></div>

	<%
	   String patientName = "";
	   String hin = "";
	   String pastDue = "";
	   	if(patientDetailsList.size() > 0){
	   		for(Patient patient : patientDetailsList){
	   			patientName = patient.getPFirstName();
	   			if(patient.getPMiddleName()!=null){
	   				patientName +=" "+patient.getPMiddleName();
	   			}
	   			if(patient.getPLastName()!=null){
	   				patientName +=" "+patient.getPLastName();
	   			}
	   			hin = patient.getHinNo();
	   			if(patient.getPastDue() != null){
	   				pastDue = patient.getPastDue();
	   			}

			    String adNo = "";
			    int inpatientId = 0;
			    if(patient.getInpatients() != null)
			    {
					Set<Inpatient> inpatientSet = patient.getInpatients();
					for(Inpatient inpatient :inpatientSet){
						if(!inpatient.getAdStatus().equals("D")){
							inpatientId = inpatient.getId();
							adNo = inpatient.getAdNo();
						}
					}
			    }
		    	if(!adNo.equals("")){
		    %>
	<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
	 <label class="value"><%=adNo%></label> <input
		type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
		type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
	<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
	<label class="value"><%=patient.getHinNo() %></label> <label>Patient
	Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
	<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
	<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
	<%
		    	if(!pastDue.equals("")){
		    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
	<%} %>
	<div class="clear"></div>
	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
		type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

			}%>
	<div class="clear"></div></div>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<h4>Payment Details</h4>
	<div class="clear"></div>
	<input type="button" name="delete" value="" class="buttonDel"
		onclick="removeRowForPayment();" />

	<div class="clear"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		id="paymentDetails">
		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Payment Mode</th>
			<th scope="col">Advance Type</th>
			<th scope="col">Advance Amt</th>
			<th scope="col">Cheque/Credit Card No</th>
			<th scope="col">Cheque/Credit Date</th>
			<th scope="col">Bank</th>
			<th scope="col"></th>
		</tr>
		<%
	     	int i = 1;

	    	%>

		<tr>
			<td><input type="radio" value="<%=i%>" name="selectedPayMode"
				class="radioCheck" /></td>
			<td><select name="<%=PAYMENT_MODE %><%=i %>"
				id="paymentModeId<%=i %>"
				onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
				<option value="">Select</option>
				<option value="C" selected="selected">Cash</option>
				<option value="Q">Cheque</option>
				<option value="R">Credit Card</option>
			</select></td>
			<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
				id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
				maxlength="100"/></td>
			<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
				id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
				maxlength="9"
				onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
				id="cqeId<%=i %>" maxlength="20" readonly="readonly"
				onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
			<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
				id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				style="display: none;" validate="Pick a date" class="calender"
				onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
			</td>
			<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
				disabled="disabled" tabindex="6">
				<option value="0">Select</option>
				<%
					int j = 0;
					for (MasBankMaster bankMaster : bankList) {
				%>
				<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
				<script>
				bankArray[<%=j%>]= new Array();
				bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
				bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

			</script>
				<%
					j++;
					}
				%>
			</select></td>
			<td><input type="button" name="add" value="" class="buttonAdd"
				onclick="addRowForPayment('deposit');" tabindex="7" /></td>
		</tr>
	</table>
	<input type="hidden" value="1" name="hiddenValuePayment"
		id="hiddenValuePayment" />

	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div class="Block"><label>Total Amount</label> <input type="text"
		id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
		readonly="readonly" />
	<div class="clear"></div>
	</div>

	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" tabindex="8" value="Submit"
		name="Submit"
		onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
		align="right" />

	<input type="button" class="button" value="Back" align="left"
		onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
	<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
	<div class="clear"></div>
	<div class="division"></div>

	<% }else  if(patTypeId==19){
		
		%>
		<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
		<div class="clear"></div>

		<script type="text/javascript">
		var bankArray=new Array();
		</script>

		<div class="titleBg">
		<h2>Patient Advance</h2>
		</div>
		<div class="clear"></div>
		<!--Block One Starts-->
		<h4>Patient Details</h4>
		<div class="clear"></div>
		<div class="Block">
		<%
					String receiptNo = "";
					if(map.get("receiptNo") != null){
						receiptNo = (String)map.get("receiptNo");
					}

				%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

		<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
		Time</label> <label class="value"><%=time %></label>
		<div class="clear"></div>

		<%
		   String patientName = "";
		   String hin = "";
		   String pastDue = "";
		   	if(patientDetailsList.size() > 0){
		   		for(Patient patient : patientDetailsList){
		   			patientName = patient.getPFirstName();
		   			if(patient.getPMiddleName()!=null){
		   				patientName +=" "+patient.getPMiddleName();
		   			}
		   			if(patient.getPLastName()!=null){
		   				patientName +=" "+patient.getPLastName();
		   			}
		   			hin = patient.getHinNo();
		   			if(patient.getPastDue() != null){
		   				pastDue = patient.getPastDue();
		   			}

				    String adNo = "";
				    int inpatientId = 0;
				    if(patient.getInpatients() != null)
				    {
						Set<Inpatient> inpatientSet = patient.getInpatients();
						for(Inpatient inpatient :inpatientSet){
							if(!inpatient.getAdStatus().equals("D")){
								inpatientId = inpatient.getId();
								adNo = inpatient.getAdNo();
							}
						}
				    }
			    	if(!adNo.equals("")){
			    %>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
		 <label class="value"><%=adNo%></label> <input
			type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
			type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
		<label class="value"><%=patient.getHinNo() %></label> <label>Patient
		Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
		<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
		<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
		<%
			    	if(!pastDue.equals("")){
			    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
		<%} %>
		<div class="clear"></div>
		<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
			type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

				}%>
		<div class="clear"></div></div>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
		<h4>Payment Details</h4>
		<div class="clear"></div>
		<input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRowForPayment();" />

		<div class="clear"></div>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			id="paymentDetails">
			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Payment Mode</th>
				<th scope="col">Advance Type</th>
				<th scope="col">Advance Amt</th>
				<th scope="col">Cheque/Credit Card No</th>
				<th scope="col">Cheque/Credit Date</th>
				<th scope="col">Bank</th>
				<th scope="col"></th>
			</tr>
			<%
		     	int i = 1;

		    	%>

			<tr>
				<td><input type="radio" value="<%=i%>" name="selectedPayMode"
					class="radioCheck" /></td>
				<td><select name="<%=PAYMENT_MODE %><%=i %>"
					id="paymentModeId<%=i %>"
					onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
					<option value="">Select</option>
					<option value="C" selected="selected">Cash</option>
					<option value="Q">Cheque</option>
					<option value="R">Credit Card</option>
				</select></td>
				<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
					id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
					maxlength="100"/></td>
				<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
					id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
					maxlength="9"
					onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
				<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
					id="cqeId<%=i %>" maxlength="20" readonly="readonly"
					onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
				<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
					id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
					src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
					style="display: none;" validate="Pick a date" class="calender"
					onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
				</td>
				<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
					disabled="disabled" tabindex="6">
					<option value="0">Select</option>
					<%
						int j = 0;
						for (MasBankMaster bankMaster : bankList) {
					%>
					<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
					<script>
					bankArray[<%=j%>]= new Array();
					bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
					bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

				</script>
					<%
						j++;
						}
					%>
				</select></td>
				<td><input type="button" name="add" value="" class="buttonAdd"
					onclick="addRowForPayment('deposit');" tabindex="7" /></td>
			</tr>
		</table>
		<input type="hidden" value="1" name="hiddenValuePayment"
			id="hiddenValuePayment" />

		<div class="paddingTop15"></div>
		<div class="clear"></div>
		<div class="Block"><label>Total Amount</label> <input type="text"
			id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
			readonly="readonly" />
		<div class="clear"></div>
		</div>

		<div class="clear"></div>
		<div class="division"></div>
		<input type="button" class="button" tabindex="8" value="Submit"
			name="Submit"
			onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
			align="right" />

		<input type="button" class="button" value="Back" align="left"
			onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
		<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
		<div class="clear"></div>
		<div class="division"></div>

		<% }else if( patTypeId==20 ){
			
			%>
			<input type="button" name="Report" value="Generate BarCode" class="buttonBig"onClick="submitForm('deposit','registration?method=generateBarCode&hinNo=<%=hinNo%>');"/>
			<div class="clear"></div>

			<script type="text/javascript">
			var bankArray=new Array();
			</script>

			<div class="titleBg">
			<h2>Patient Advance</h2>
			</div>
			<div class="clear"></div>
			<!--Block One Starts-->
			<h4>Patient Details</h4>
			<div class="clear"></div>
			<div class="Block">
			<%
						String receiptNo = "";
						if(map.get("receiptNo") != null){
							receiptNo = (String)map.get("receiptNo");
						}

					%> <label>Receipt No.</label> <label class="value"><%=receiptNo %></label>

			<label>Receipt Date</label> <label class="value"><%=date %></label> <label>Receipt
			Time</label> <label class="value"><%=time %></label>
			<div class="clear"></div>

			<%
			   String patientName = "";
			   String hin = "";
			   String pastDue = "";
			   	if(patientDetailsList.size() > 0){
			   		for(Patient patient : patientDetailsList){
			   			patientName = patient.getPFirstName();
			   			if(patient.getPMiddleName()!=null){
			   				patientName +=" "+patient.getPMiddleName();
			   			}
			   			if(patient.getPLastName()!=null){
			   				patientName +=" "+patient.getPLastName();
			   			}
			   			hin = patient.getHinNo();
			   			if(patient.getPastDue() != null){
			   				pastDue = patient.getPastDue();
			   			}

					    String adNo = "";
					    int inpatientId = 0;
					    if(patient.getInpatients() != null)
					    {
							Set<Inpatient> inpatientSet = patient.getInpatients();
							for(Inpatient inpatient :inpatientSet){
								if(!inpatient.getAdStatus().equals("D")){
									inpatientId = inpatient.getId();
									adNo = inpatient.getAdNo();
								}
							}
					    }
				    	if(!adNo.equals("")){
				    %>
			<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
			 <label class="value"><%=adNo%></label> <input
				type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
				type="hidden" name="<%=AD_NO %>" value="<%=adNo%>"/> <%} %>
			<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
			<label class="value"><%=patient.getHinNo() %></label> <label>Patient
			Name</label> <label class="value"> <%=patientName %></label> <label>Age</label>
			<label class="value"> <%=patient.getAge() %></label> <label>Sex</label>
			<label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>
			<%
				    	if(!pastDue.equals("")){
				    %> <label>Past Due</label> <label class="value"> <%=pastDue %></label>
			<%} %>
			<div class="clear"></div>
			<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
				type="hidden" name="<%=HIN_NO %>" value="<%=hin %>"/> <%}

					}%>
			<div class="clear"></div></div>
			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<h4>Payment Details</h4>
			<div class="clear"></div>
			<input type="button" name="delete" value="" class="buttonDel"
				onclick="removeRowForPayment();" />

			<div class="clear"></div>
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="paymentDetails">
				<tr>
					<th scope="col">S.No.</th>
					<th scope="col">Payment Mode</th>
					<th scope="col">Advance Type</th>
					<th scope="col">Advance Amt</th>
					<th scope="col">Cheque/Credit Card No</th>
					<th scope="col">Cheque/Credit Date</th>
					<th scope="col">Bank</th>
					<th scope="col"></th>
				</tr>
				<%
			     	int i = 1;

			    	%>

				<tr>
					<td><input type="radio" value="<%=i%>" name="selectedPayMode"
						class="radioCheck" /></td>
					<td><select name="<%=PAYMENT_MODE %><%=i %>"
						id="paymentModeId<%=i %>"
						onchange="checkPaymentMode(this.value,<%=i %>);" tabindex="1">
						<option value="">Select</option>
						<option value="C" selected="selected">Cash</option>
						<option value="Q">Cheque</option>
						<option value="R">Credit Card</option>
					</select></td>
					<td><input type="text" name="<%=ADVANCE_AMOUNT_TYPE %><%=i %>"
						id="advanceAmountTypeId<%=i %>" value="" validate="Advance Amount Type ,string,no" tabindex="2"
						maxlength="100"/></td>
					<td><input type="text" name="<%=AMOUNT_RECEIVED %><%=i %>"
						id="amt<%=i %>" value="" validate="Amount,string,no" tabindex="3"
						maxlength="9"
						onblur="if(validateAmount(this.value,<%=i %>)){totalAdvAmt();}" /></td>
					<td><input type="text" value="" name="<%=CHEQUE_NO%><%=i %>"
						id="cqeId<%=i %>" maxlength="20" readonly="readonly"
						onblur="validateCheque(this.value,<%=i%> );" tabindex="4" /></td>
					<td><input type="text" value="" name="<%=CHEQUE_DATE %><%=i %>"
						id="chqDate<%=i %>" readonly="readonly" tabindex="5" /> <img id="calId<%=i %>"
						src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
						style="display: none;" validate="Pick a date" class="calender"
						onclick="setdate('',document.getElementById('chqDate<%=i %>'),event)" />
					</td>
					<td><select name="<%=BANK_NAME %><%=i %>" id="bankId<%=i %>"
						disabled="disabled" tabindex="6">
						<option value="0">Select</option>
						<%
							int j = 0;
							for (MasBankMaster bankMaster : bankList) {
						%>
						<option value="<%=bankMaster.getId() %>"><%=bankMaster.getBankName()%></option>
						<script>
						bankArray[<%=j%>]= new Array();
						bankArray[<%=j%>][0] = "<%=bankMaster.getId()%>";
						bankArray[<%=j%>][1] = "<%=bankMaster.getBankName()%>";

					</script>
						<%
							j++;
							}
						%>
					</select></td>
					<td><input type="button" name="add" value="" class="buttonAdd"
						onclick="addRowForPayment('deposit');" tabindex="7" /></td>
				</tr>
			</table>
			<input type="hidden" value="1" name="hiddenValuePayment"
				id="hiddenValuePayment" />

			<div class="paddingTop15"></div>
			<div class="clear"></div>
			<div class="Block"><label>Total Amount</label> <input type="text"
				id="totalAmt" name="<%=TOTAL_AMOUNT %>" class="readOnly"
				readonly="readonly" />
			<div class="clear"></div>
			</div>

			<div class="clear"></div>
			<div class="division"></div>
			<input type="button" class="button" tabindex="8" value="Submit"
				name="Submit"
				onclick="if(checkAdvAmt()){submitFormToDisableSubmitDeposit('deposit','billing?method=submitDepositDetails','validateFieldsOnSubmit','validateChequeAndCreditCardDate');}"
				align="right" />

			<input type="button" class="button" value="Back" align="left"
				onClick="submitForm('deposit','billing?method=showSearchJspForDepositAndSettlement&flag=searchDeposit');" tabindex="9" />
			<input type="reset" class="buttonHighlight" value="Reset" tabindex="10"/>
			<div class="clear"></div>
			<div class="division"></div>

			<% } %>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

function checkAdvAmt()
{
	if(document.getElementById('totalAmt').value == "" || document.getElementById('totalAmt').value == "0")
	{
		alert("Please enter Advance Amount.");
		return false;
	}
	return true;
}

function checkPaymentMode(val, count){
	if(val == "C"){
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "";
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bankId"+count).disabled = true;
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'none';
	}
	else if(val == "Q" || val == "R"){
		document.getElementById("amt"+count).readOnly = false;
		document.getElementById("cqeId"+count).readOnly = false;
		document.getElementById("bankId"+count).disabled = false;
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
		document.getElementById("received"+count).readOnly = false;
		document.getElementById("calId"+count).style.display = 'inline';
	}else{
		document.getElementById("amt"+count).value = "";
		document.getElementById("cqeId"+count).value = "";
		document.getElementById("chqDate"+count).value = "";
		document.getElementById("bankId"+count).value = "";
		// code added by shailesh
		if(document.getElementById("received"+count)!=null)
		document.getElementById("received"+count).value = "";
		document.getElementById("amt"+count).readOnly = true;
		document.getElementById("cqeId"+count).readOnly = true;
		document.getElementById("bankId"+count).disabled = true;
		document.getElementById("received"+count).readOnly = true;
		document.getElementById("calId"+count).style.display = 'none';
	}
	totalAdvAmt();
}

function totalAdvAmt(){
	var amt = 0;
	var count = document.getElementById('hiddenValuePayment').value;
	for(var i=1; i<=count; i++){
		var advAmt = eval(document.getElementById("amt"+i));
		if(validateFloat(advAmt.value)){
			if(amt != 0 && advAmt.value != ""){
				amt = parseInt(amt)+parseInt(advAmt.value);
			}else if(amt == 0 && advAmt.value != ""){
				amt = parseInt(advAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amt"+i).value = "";
			document.getElementById("amt"+i).focus();
			return false;
		}
	}
	document.getElementById('totalAmt').value = amt;
}
function submitFormToDisableSubmitDeposit(formName,action,extraFunction,extraFunction2,extraFunction3){

	errorMsgDisableSubmit="";
			ob1 = true;
			ob2 = true;
			ob3 = true;
			obj = eval('document.'+formName);

			if(eval("window."+extraFunction))
		    	ob1 =  eval(extraFunction+"()")

				if(eval("window."+extraFunction2))
		        	ob2 = eval(extraFunction2+"()")

				if(eval("window."+extraFunction3))
		        	ob3 = eval(extraFunction3+"()")

				if(validateFieldsForDisableSubmit(formName)== true & ob1 & ob2 &ob3){
					if(document.getElementById('submitForDisable') != null){
						document.getElementById('submitForDisable').disabled=true
					}
		        	obj.action = action;
					obj.submit();
				}else{
					if(errorMsgDisableSubmit != ""){
						alert(errorMsgDisableSubmit);
			       		return false;
			       	}
			       	return true;
		    	}
		}
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<% 
bankList.clear();
patientDetailsList.clear();

%>