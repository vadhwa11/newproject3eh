<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : investigationOrderBooking.jsp
	 * Tables Used         :
	 * Description         : For OrderBooking For OP .
	 * @author Name        : Dipali
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>

<form name="investigationOrderBooking" method="post" action="">
	<script type="text/javascript">
		history.forward();
</script>
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
	<script type="text/javascript">
 function totalCost(){
	var amt = 0;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<=count; i++){
		var totalAmt = eval(document.getElementById("amount"+i));
		if(validateFloat(totalAmt.value)){
			if(amt != 0 && totalAmt.value != ""){
				amt = parseInt(amt)+parseInt(totalAmt.value);
			}else if(amt == 0 && totalAmt.value != ""){
				amt = parseInt(totalAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amount"+i).value = "";
			return false;
		}
	}
	document.getElementById('totalCostId').value = amt;
}





function validateChargeCodeForAutoComplete( strValue,inc ) {
 	if(strValue != "" && strValue !="No Items found")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		document.getElementById('chargeCode'+inc).value="";
		    		/* document.getElementById('chargeName'+inc).value=""; */
		    		document.getElementById('qty'+inc).value="";
	   				if(document.getElementById('rate'+inc) != null)
		    			document.getElementById('rate'+inc).value="";
		    		if(document.getElementById('resrate'+inc) != null)
		    			document.getElementById('resrate'+inc).value="";
 					return ;
 			}
		 		for(i=1;i<inc;i++){
	 			if(inc != 1){

					if(document.getElementById('chargeCode'+i).value==strValue)
					{
						alert("Test Code already selected...!")
						document.getElementById('chargeCode'+inc).value=""
						var e=eval(document.getElementById('chargeCode'+inc));
						e.focus();
						return false;
					} }  }

			document.getElementById('qty'+inc).value="1";
			document.getElementById('qty'+inc).readOnly = false;
	      	return true;

 		}else{
 			document.getElementById('chargeCode'+inc).value="";
 			/* document.getElementById('chargeName'+inc).value=""; */
			if(document.getElementById('rate'+inc) != null)
   			document.getElementById('rate'+inc).value="";
   			if(document.getElementById('resrate'+inc) != null)
   			document.getElementById('resrate'+inc).value="";
			document.getElementById('qty'+inc).value="";
 			return false;
 			}
}
function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);
		  	totalCost();
		}
	}
}
</script>
	<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		List chargeList = new ArrayList();
		Patient patient = new Patient();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");
		Integer doctorId=null;
		String admissionNumber = "";
		String userName ="";
		String deptType="";
		int dgOrderhdId = 0;
		int inpatientId =0;
		int hinId = 0;
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
		try {
			 properties.load(resourcePath.openStream());
		    } catch (Exception e) {
			e.printStackTrace();
		}
		String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
		Box box = HMSUtil.getBox(request);

		if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
		}

		if (session.getAttribute("deptType") != null) {
			deptType = (String) session.getAttribute("deptType");
		}

		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>)map.get("employeeList");
		}
		if(map.get("visitList") != null){
			visitList = (List<Visit>)map.get("visitList");
		}
		if(map.get("doctorId") != null){
		 	 doctorId = (Integer)map.get("doctorId");
		}
		if(map.get("dgOrderhdId") != null){
			dgOrderhdId=(Integer)map.get("dgOrderhdId");
		}
		if(detailsMap.get("mainChargeCodeList") != null){
			mainChargeCodeList = (List<MasMainChargecode>)detailsMap.get("mainChargeCodeList");
		}
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
		if(detailsMap.get("chargeList") != null){
			chargeList = (List)detailsMap.get("chargeList");
		}
		if(map.get("icdList") != null){
			icdList = (List<DischargeIcdCode>)map.get("icdList");
		}
		List<DgOrderhd>hdList=new ArrayList<DgOrderhd>();
		if(map.get("hdList") != null){
			hdList = (List<DgOrderhd>)map.get("hdList");
		}
		
		
%>
	<div class="titleBg">
	<h2>Order Booking</h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
		<input type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
		<%
		String orderSeqNo="";
		if(map.get("orderSeqNo") != null){
			orderSeqNo = (String)map.get("orderSeqNo");
		}
%>
		<label>Order Number</label> <input id="orderId" type=hidden
			name="<%=ORDER_NO %>" value="<%=orderSeqNo %>" title="Order Number" />

		<label class="value"> <%=orderSeqNo %>
		</label> <input type="hidden" id="dgOrderhdId" name="dgOrderhdId"
			value="<%= dgOrderhdId%>" /> <input type="hidden" id="hinId"
			value="<%= hinId%>" /> <input type="hidden" id="admissionNumber"
			value="<%= admissionNumber%>" /> <label>Order Date</label> <label
			class="value"><%= date%></label> <label>Order Time</label> <label
			class="value"><%= time%></label>
		<div class="clear"></div>
		<%
      Iterator itr=visitList.iterator();
          int  counter=0;
          int hin = 0;
          int visitId=0;
          while(itr.hasNext()){
             Visit  visit = (Visit)itr.next();
             visitId = visit.getId();
             hinId=visit.getHin().getId();
             hin= visit.getHin().getId();
%>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=visit.getHin().getHinNo() %></label>

		<%
					String middleName = "";
					String lastName = "";
					if(visit.getHin().getPMiddleName() != null){
						middleName = visit.getHin().getPMiddleName();
					}
					if(visit.getHin().getPLastName() != null){
						lastName = visit.getHin().getPLastName();
					}

					%>
		<%-- <label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <label
			class="value"><%= visit.getVisitNo()%></label> --%> <label>Patient
			Name</label> <label class="value"><%= visit.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>
			<label>Gender</label> <label class="value"><%=visit.getHin().getSex().getAdministrativeSexName() %></label>
		<div class="clear"></div> 
		<label>Age</label>
		<%
					String age = "";
					String currentAge = "";
				if(visit.getHin().getAge() != null){
					age = visit.getHin().getAge();
				    currentAge = HMSUtil.calculateAgeForADT(age, visit.getHin().getRegDate());
				}
			
		if(currentAge != null){ %>
		 <label class="value"><%=currentAge%></label>
		 <%}else{ %>
		 <label class="value">-</label>
		 <%} %>
		 
		 
		  <label>Marital
			Status</label>
		<%
					String maritalStatus = "";
				if(visit.getHin().getMaritalStatus() != null){
					maritalStatus =visit.getHin() .getMaritalStatus().getMaritalStatusName();

				%>
		<label class="value"><%=maritalStatus%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<div class="clear"></div>
		<%-- <%
				String religion = "";
				if(visit.getHin().getReligion() != null){
					religion = visit.getHin().getReligion().getReligionName();
				%>
		<label>Religion</label> <label class="value"><%= religion%></label>
		<%} %> --%>
		<%-- <label>Test Type</label> <select name="<%=TEST_TYPE%>">
			<option value="Regular">Regular</option>
			<option value="Urgent">Urgent</option>
		</select> --%>

		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<%if(deptType.equalsIgnoreCase("radio")){%>
	<label><span>*</span> Clinical Notes</label> <input id="clinicalNote"
		type="text" name="<%= CLINICAL_NOTE%>" value=""
		validate="Clinical Notes,string,yes" MAXLENGTH="200" tabindex=1
		style="width: 600px;" />
	<%}else{ %>
	<label><span>*</span> Clinical Notes</label> <input id="clinicalNote"
		type="text" name="<%= CLINICAL_NOTE%>" value=""
		validate="Clinical Notes,string,yes" MAXLENGTH="200" tabindex=1
		style="width: 600px;" />


	<%} %>
	<div class="clear"></div>

	<label><span>*</span> Prescribed By</label> <select id="placedBy"
		name="<%=EMPLOYEE_ID %>" validate="Prescribed By,string,yes"
		tabindex=1>
		<option value="0">Select</option>
		<%
		String doctorFirstName = "";
		String doctorMiddleName = "";
		String doctorLastName = "";
		int empId=0;
		for(MasEmployee obj : employeeList){
			if(obj.getEmployeeName()!= null)
			{
				doctorFirstName = obj.getEmployeeName();
			}

			/* if(obj.getMiddleName()!= null)
			{
			doctorMiddleName = obj.getMiddleName();
			}

			if(obj.getLastName()!= null)
			{
				doctorLastName = obj.getLastName();
			} */
			empId=obj.getId();%>
			<option value="<%=empId%>"><%=doctorFirstName%></option>
		<%} %>
		<%-- <%
		Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		for (MasEmployee obj : employeeList){

		if(obj.getEmpCategory() != null){

		if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
		String doctorFirstName = "";
		String doctorMiddleName = "";
		String doctorLastName = "";

		if(obj.getFirstName()!= null)
		{
			doctorFirstName = obj.getFirstName();
		}

		if(obj.getMiddleName()!= null)
		{
		doctorMiddleName = obj.getMiddleName();
		}

		if(obj.getLastName()!= null)
		{
			doctorLastName = obj.getLastName();
		}

		if(doctorId !=0){

			if(doctorId.equals(obj.getId())){

%>
		<option value="<%=obj.getId()%>" selected="selected"><%=doctorFirstName+" "+doctorMiddleName+" "+doctorLastName%></option>
		<%  }}else {%>
		<option value="<%=obj.getId()%>"><%=doctorFirstName+" "+doctorMiddleName+" "+doctorLastName%></option>
		<%	} }	} }%> --%>
	</select>
	<%

for(Inpatient inpatient :inpatientSet){
	if(inpatient.getAdStatus().equals("A")){
		inpatientId = inpatient.getId();

	}
%>
	<input type="hidden" name="hin" value="<%=patient.getHinNo() %>" /> <input
		type="hidden" name="<%=DEPARTMENT_ID %>"
		value="<%=inpatient.getDepartment().getId() %>" />
	<%} %>
	<input type="hidden" name="visitId" value="<%=visit.getId() %>" /> <input
		type="hidden" name="hin" value="<%=visit.getHin().getHinNo() %>" /> <input
		type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>" />
	<input type="hidden" name="<%=HIN_NO %>"
		value="<%=visit.getHin().getHinNo() %>" /> <input type="hidden"
		name="<%=VISIT_ID %>" value="<%=visit.getId()%>" /> <input
		type="hidden" name="<%=VISIT_NUMBER %>"
		value="<%=visit.getVisitNo() %>" /> <input type="hidden"
		name="<%=INPATIENT_ID %>" value="<%=inpatientId%>" /> <input
		type=hidden value=0 name=pagecounter2 /> <input type="hidden"
		name="pageNo" id="pageNo" value="<%=pageNo%>" />
		<%-- <%
		int masChargeCodeId=0;
		for(MasMainChargecode mainChargecode : mainChargeCodeList){
							if("LAB".equalsIgnoreCase(mainChargecode.getMainChargecodeCode())){
								masChargeCodeId=mainChargecode.getId();
							
		}} %>
		<input type="hidden" name="<%=MAIN_CHARGECODE_ID %>" value="<%= masChargeCodeId%>" id="mainChargeCodeId"/>
		<input type="hidden" name="subChargeCodeId" id="subChargeCodeId" value="0"/>
		 --%>
		 <label>Main
		Group</label> <select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
		onchange="populateSubCharge(this.value,'investigationOrderBooking');">
		<option value="0">Select</option>
		<%
						for(MasMainChargecode mainChargecode : mainChargeCodeList){
							/* if("LAB".equalsIgnoreCase(mainChargecode.getMainChargecodeCode())){ */
								
							
					%>

		<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName().toUpperCase() %></option>
		<%/* } */}%>
	</select>  <label>Sub Group</label> <select id="subChargeCodeId"
		name="subChargeCode_id">
		<option value="0">Select</option>
		<%
			for(MasSubChargecode subChargecode : subChargeCodeList){
			%>
		<option value="<%=subChargecode.getId() %>"
			<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName().toUpperCase() %></option>
		<%}%>
	</select> 
	<script type="text/javascript">

<%

	int counter1 = 0;

	for (MasMainChargecode mainChargecode : mainChargeCodeList){
	for (MasSubChargecode subChargecode : subChargeCodeList) {
	if(subChargecode.getMainChargecode() != null){
	if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
%>
	subChargeArray[<%=counter1%>] = new Array();
	subChargeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
	subChargeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;
	subChargeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
	<%
	counter1++;
	} } } }

%>
</script>
	<script type="text/javascript">
var amtArray = new Array();
<%
	if(chargeList!=null){
	Iterator ite = chargeList.iterator();
	while ( ite.hasNext() ) {
	Object[] pair = (Object[]) ite.next();
	MasChargeCode masChargeCode = (MasChargeCode) pair[0];

%>
	amtArray[<%=counter%>] = new Array();
	amtArray[<%=counter%>][0]=<%=masChargeCode.getId()%>;
	amtArray[<%=counter%>][1] = <%=masChargeCode.getChargeCodeCode()%>;

<%
counter++;
}}
%>
</script>
	<div class="clear"></div>
	<!--

<label>Common</label>
<input type="radio" id="rareCommon1"	name="<%=RARE_COMMON  %>" class="radioCheck" value="c"	checked="checked" />
<label class="auto">Rare</label>
<input	type="radio" id="rareCommon2" name="<%=RARE_COMMON  %>"	class="radioCheck" value="r" /> -->
	<label>Routine</label> <input type="radio" id="routine1"
		name="<%=ROUTINE%>" class="radioCheck" value="r" checked="checked"
		onclick="showUrgentDetails(this.value);" /> <label class="auto">Urgent</label>
	<input type="radio" id="routine2" name="<%=ROUTINE%>"
		class="radioCheck" value="u" onclick="showUrgentDetails(this.value);" />
	<input type="text" name="<%=URGENT_DETAILS%>" id="urgentDetails"
		style="display: none;" maxlength="50">
		<div class="clear"></div>
		<label>Pending Investigation</label>
		<select name="pendingName" id="pendingId" onclick="submitProtoAjaxWithDivName('investigationOrderBooking','lab?method=getInvestigationDetailsForNewRequest&val='+this.value,'newReqDiv');">
		<option value="0">Select</option>
		<%if(hdList!=null && hdList.size()>0){
		System.out.println("hdList.size() --- ----  >>"+hdList.size());
		for(DgOrderhd hd:hdList){ 
		if(hd.getVisit()!=null){%>
		<option value="<%=hd.getId()%>"><%=""+hd.getVisit().getVisitNo()+"["+hd.getOrderDate()+"]"%></option>
		<%} }}%>
		</select>
		<div class="clear"></div> <input type="button" name="delete" value=""
		class="buttonDel" onclick="removeRow();" /> <input type="hidden"
		size="2" value="" name="noOfRecords" id="noOfRecords" />
		<div class="clear"></div>
		<div id="newReqDiv">
		<div class="tableHolderAuto">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"
				id="chargeDetails">
				<tr>
					<th scope="col"></th>
					<th scope="col">Test Name</th>
					<!-- <th scope="col">Test Name</th> -->
					<th scope="col">Qty</th>
					<th scope="col">Rate</th>
					<th scope="col">Amount</th>
					<th scope="col">&nbsp;</th>
				</tr>

				<%
		int inc = 1;
	%>
				<tr>
					<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
						id="dgOrderhdId" />
					<td><input type="checkbox" value="<%=inc%>"
						name="selectedChrage" class="radioCheck" /></td>
					<td><input type="text" name="chargeCode<%=inc%>"
						id="chargeCode<%=inc%>"
						onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){submitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=1&hin=<%=hin%>','rateVal');}"
						tabindex="1" />
						<div id="ac2update" style="display: none;" class="autocomplete"></div>
						<script type="text/javascript" language="javascript"
							charset="utf-8">
			  function eventCallback(element, entry){
			 //var r;
			// if(document.getElementById('rareCommon1').checked == true){
			// r=document.getElementById('rareCommon1').value;
			// }else {
			// r=document.getElementById('rareCommon2').value;
			// }
						return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value;
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});

			</script></td>
					<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
						id="chargeCodeId<%=inc %>" />
					<input type="hidden" value="" name="<%=MAIN_CHARGECODE_ID%>"
						id="mainChargeId<%=inc %>" />
					<input type="hidden" value="" name="<%=SUB_CHARGECODE_ID%>"
						id="subCharegId<%=inc %>" />
					<%-- <td><input type="text" id="chargeName<%=inc%>"
						name="<%=CHARGE_NAME%>" value="" class="readonly" /></td> --%>

					<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>"
						value="" readonly="readonly" validate="Qty,int,yes" MAXLENGTH="3" tabindex="1"
						onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost();}" />
					</td>

					<td id="rateVal"><input type="text" value=""
						id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
						validate="Rate,float,no"
						onblur="calculateAmt(<%=inc %>);totalCost();" readonly="readonly"
						size="15" maxlength="12" /></td>

					<td><input type="text" id="amount<%=inc%>" value=""
						name="<%=AMOUNT%><%=inc%>" onblur="totalCost();" class="readonly"
						readonly="readonly" /></td>
					<td><input type="button" name="add" value="" class="buttonAdd"
						onclick="addRow();" tabindex="1" /></td>

				</tr>

				<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
					id="dgOrderhdId" />
			</table>

			<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
				id="hiddenValueCharge" />
		</div></div>

		<div class="clear"></div>
		<div class="paddFltRight110">
			<label class="medium"><a>Total Cost</a></label> <input type="text"
				id="totalCostId" name="<%=TOTAL_AMOUNT%>" value="0" class="readOnly"
				readOnly />
		</div>
		<div class="clear"></div>
		<div class="division"></div> <%
			String diagnosis = "";
			if(icdList.size() > 0){
				for(DischargeIcdCode dischargeIcdCode : icdList){
					if(diagnosis.equals("")){
						if(dischargeIcdCode.getDiagnosisStatus().equalsIgnoreCase("p"))
						diagnosis = dischargeIcdCode.getIcd().getIcdName();
					}else{
						if(dischargeIcdCode.getDiagnosisStatus().equalsIgnoreCase("p"))
						diagnosis = diagnosis.concat(" , ").concat(dischargeIcdCode.getIcd().getIcdName());
					}
				}
			}
			if(diagnosis!=null && !"".equalsIgnoreCase(diagnosis.trim())){%> <label>Provisional
			Diagnosis</label> <label class="valueAuto"><%=diagnosis %></label>
	<%}
		%>

	<div class="clear"></div>
	<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	<%} %>


	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" value="Submit"
		id="submitForDisable"
		onclick="if(checkTestRow()){submitFormToDisableSubmit1('investigationOrderBooking','lab?method=submitOrderBookingForInvestigation');}" />
	<input type="button" class="buttonHighlight" value="Reset"
		onclick="form.reset();resetAjaxValueForBilling();" /> <input
		type="hidden" name="rows" id="rr" value="1" /> <input name="Back"
		type="button" src="images/phaseII/delete.gif" alt="Back" value="Back"
		class="button" onclick="history.go(-1);return false;" align="right" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
	</div>
	<!--Bottom labels ends-->
	<div class="clear"></div>
	<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

function submitFormToDisableSubmit1(formName,action,extraFunction,extraFunction2,extraFunction3){

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

function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

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
	e1.onblur=function(){
		checkInvestigationItem(iteration);
		if(validateChargeCodeForAutoComplete(this.value, (iteration))){submitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal='+(iteration)+'&hin=<%=hin%>','rateVal'+(iteration));}

			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});

	<%-- var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=CHARGE_NAME%>'+ (iteration);
	e2.id = 'chargeName'+(iteration)
	e2.tabIndex="1";
	e2.readOnly = true;
	cell2.appendChild(e2);
	e2.size='20'; --%>

	var cell3 = row.insertCell(2);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=QUANTITY%>'+ (iteration);
	e3.id = 'qty'+(iteration)
	e3.maxLength="3";
	e3.tabIndex="1";
	e3.onblur = function(){
					validateQty(this.value,this.id);calculateAmt(iteration);totalCost();
	};
	cell3.appendChild(e3);
	e3.size='20';


	var cell4 = row.insertCell(3);
	cell4.id='rateVal'+(iteration);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=RATE%>'+ (iteration);
	e4.readOnly = true;
	e4.id='rate'+(iteration);
	e4.onblur = function(){
					calculateAmt((iteration));
			};
	cell4.appendChild(e4);
	e4.size='15';

	var cell5 = row.insertCell(4);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.readOnly = true;
	e5.id='amount'+(iteration);
	e5.onblur = function(){
					totalCost();
			};
	cell5.appendChild(e5);

	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.tabIndex="1";
	e6.onclick = function(){
	           	addRow();
	}
	cell6.appendChild(e6);

}
function showUrgentDetails(val)
{


if(val=="u")
{

document.getElementById('urgentDetails').style.display = 'inline';

}
else
{
document.getElementById('urgentDetails').style.display = 'none';
}
}

function checkTestRow()
{


	var msg ="";
	if(document.getElementById('routine2').checked==true)
	{
	if(document.getElementById('urgentDetails').value=="")
	{
	alert("please give Urgent Details");
	return false;
	}
	}
	var count = document.getElementById('hiddenValueCharge').value;
	  	for(var i=1;i<=count;i++){

	  	 	if(document.getElementById('chargeCode'+i) != null){
	  	 		if(document.getElementById('chargeCode'+i).value != ""){
		  			if(document.getElementById('qty'+i).value == ""){
		  				msg += "Quantity can not be blank.\n";
		  			}
		  			if(document.getElementById('amount'+i).value == ""){
		  				msg += "Amount can not be blank.\n";
		  			}

		  			if(msg != ""){
		  				break;
		  			}
	  			}
	  			else{
	  				alert("Please fill atleast one charge to submit.");
	  				return false;
	  			}
	  		}
	  	}
	  	if(msg != ""){
	  		alert(msg)
	  		return false;
	  	}else{
	  		return true;
	  	}
	}

</script>
<script>
function checkInvestigationItem(cnt){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	var iteration = lastRow-1;
	var chargeCodeName = document.getElementById("chargeCode"+cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
    var indexForBrandName=index1;
    var index2 = chargeCodeName.lastIndexOf("]");
    	index1++;

    var chargeCode = chargeCodeName.substring(index1,index2);
   // alert("chargeCode---->>"+chargeCode);
	if(chargeCode !=""){
	var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }

	    xmlHttp.onreadystatechange=function()
	    {
	     	if(xmlHttp.readyState==4){
	     		jQuery(function ($) {
	    	      if(xmlHttp.response!="A"){
	    	    	  $("#chargeCode"+cnt).css({ 'color': 'red', 'font-size': '125%' });
	    	    	  $("#availableStatus"+cnt).val("nav");
			       }else{
			    	   $("#availableStatus"+cnt).val("av");
			       }
	     		 });
	      	}  
	    }
	    var url="/hms/hms/opd?method=checkInvestigationItem&chargeCode="+chargeCode;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	} 
}


</script>