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

<form name="investigationOrderBooking" id="investigationOrderBooking" method="post" action="">
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
 function totalCost(inc){
	 
	var amt = 0;
	
	var count = document.getElementById('hiddenValueCharge').value;
	
	for(var i=inc; i>0; i--){
		var totalAmt = document.getElementById("amount"+i).value;
		
		if(totalAmt){
			
			if(amt != 0 && totalAmt.value != ""){
				amt = parseFloat(amt)+parseFloat(totalAmt);
				
			}else if(amt == 0 && totalAmt != ""){
				amt = parseFloat(totalAmt);
				
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
		  	totalCost(counter);
		  	var inc=document.getElementById('hiddenValueCharge').value;
		  	document.getElementById('hiddenValueCharge').value=(inc-1);
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
		List<DgOrderhd>hdList=new ArrayList<DgOrderhd>();
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
		int deptId=0;
		int hospitalId=0;
		String billingScreen = null;
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
		if(map.get("hospitalId") != null){
			hospitalId = (Integer)map.get("hospitalId");
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
		if(map.get("hdList")!=null){
			hdList=(List<DgOrderhd>)map.get("hdList");
		}
		if(map.get("deptId")!=null){
			deptId=(Integer)map.get("deptId");
		}
		int pharmacyLabQueueId=0;
		if(map.get("pharmacyLabQueueId")!=null){
			pharmacyLabQueueId=(Integer)map.get("pharmacyLabQueueId");
		}
		String orderDetailsFlag = "";
		if(map.get("orderDetailsFlag")!=null){
			orderDetailsFlag=(String)map.get("orderDetailsFlag");
		}
		int orderId = 0;
		if(map.get("orderId")!=null){
			orderId=(Integer)map.get("orderId");
		}
		int dgOrderHdId = 0;
		if(hdList.size()>0){
			dgOrderHdId = hdList.get(0).getId();
		}
		
		
		if(map.get("billingScreen")!=null){
			billingScreen=(String)map.get("billingScreen");
		}
		//Added by govind 27-07-2017 for IP Lab OrderBooking
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		if(map.get("inpatientList")!=null){
			inpatientList=(List<Inpatient>)map.get("inpatientList");
		}
		System.out.println("mainChargeCodeList jsp "+mainChargeCodeList.size());
		System.out.println("subChargeCodeList jsp "+subChargeCodeList.size());
		System.out.println("visitList jsp "+visitList.size());
		System.out.println("inpatientList jsp "+inpatientList.size());
		int  hin=0;
		String patientType="";
		//Added by govind 27-07-2017 for IP Lab OrderBooking end
%>
	<div class="titleBg">
	<h2>Order Booking</h2>
	</div>
	<div class="clear"></div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="Block">
	<input type="hidden" name="orderDetailsFlag" id="orderDetailsFlag" value="<%=orderDetailsFlag%>" />
	<input type="hidden" name="orderId" id="orderId" value="<%=orderId%>" /> <!-- this is hin_id named as order id -->
	<input type="hidden" name="dgOrderHdId" id="dgOrderHdId" value="<%=dgOrderhdId%>" />
	<input type="hidden" name="pharmacyLabQueueId" id="pharmacyLabQueueId" value="<%=pharmacyLabQueueId%>" />
	<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId%>" />
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
		<%if(visitList.size()>0){ %>
		<%patientType="OP";
      Iterator itr=visitList.iterator();
          int  counter=0;
         // int hin = 0;
          int visitId=0;
          
          while(itr.hasNext()){
             Visit  visit = (Visit)itr.next();
             visitId = visit.getId();
            // hospitalId=visit.getHospital().getId();
             if(visit.getHin()!=null)
             hinId=visit.getHin().getId();
             
             if(visit.getHin()!=null)
             hin= visit.getHin().getId();
%>
		<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
			class="value"><%=(visit.getHin()!=null)?visit.getHin().getHinNo():""%></label>
<input type="hidden" id="hinIdd" name="hinIdd"
			value="<%= visit.getHin().getId()%>" />
			
		<%
					String middleName = "";
					String lastName = "";
					if(visit.getHin()!=null && visit.getHin().getPMiddleName() != null){
						middleName = visit.getHin().getPMiddleName();
					}
					if(visit.getHin()!=null && visit.getHin().getPLastName() != null){
						lastName = visit.getHin().getPLastName();
					}

					%>
		<%-- <label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <label
			class="value"><%= visit.getVisitNo()%></label> --%> <label>Patient
			Name</label> <label class="value"><%=(visit.getHin()!=null)? visit.getHin().getPFirstName()+" "+middleName+" "+lastName : ""%></label>
			<label>Gender</label> <label class="value"><%=(visit.getHin()!=null) ? visit.getHin().getSex().getAdministrativeSexName() : "" %></label>
		<div class="clear"></div> 
		<label>Age</label>
		<%
					String age = "";
					String currentAge = "";
				if(visit.getHin()!=null && visit.getHin().getAge() != null){
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
				if(visit.getHin()!=null && visit.getHin().getMaritalStatus() != null){
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
	<label> Clinical Notes</label> <input id="clinicalNote"
		type="text" name="<%= CLINICAL_NOTE%>" value=""
		validate="Clinical Notes,string,no" MAXLENGTH="200" tabindex=1
		style="width: 600px;" />
	<%}else{ %>
	<label> Clinical Notes</label> <input id="clinicalNote"
		type="text" name="<%= CLINICAL_NOTE%>" value=""
		validate="Clinical Notes,string,no" MAXLENGTH="200" tabindex=1
		style="width: 600px;" />


	<%} %>
	<div class="clear"></div>

	<label> Prescribed By</label> <select id="placedBy"
		name="<%=EMPLOYEE_ID %>" validate="Prescribed By,string,no"
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
	<input type="hidden" id="hinId" name="hin" value="<%=patient.getHinNo() %>" /> <input
		type="hidden" name="<%=DEPARTMENT_ID %>"
		value="<%=inpatient.getDepartment().getId() %>" />
	<%} %>
	<input type="hidden" name="visitId" value="<%=visit.getId() %>" /> <input
		type="hidden" name="hin" value="<%=(visit.getHin()!=null) ? visit.getHin().getHinNo() : "" %>" /> <input
		type="hidden" name="<%=HIN_ID %>" value="<%=(visit.getHin()!=null)? visit.getHin().getId() : "" %>" />
	<input type="hidden" name="<%=HIN_NO %>"
		value="<%=(visit.getHin()!=null)?visit.getHin().getHinNo() : "" %>" /> <input type="hidden"
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
								System.out.println("deptId   "+deptId);
								if(mainChargecode.getMainChargecodeName().equalsIgnoreCase("Laboratory")){
					%>

		<option value="<%=mainChargecode.getId() %>" selected="selected"><%=mainChargecode.getMainChargecodeName().toUpperCase() %></option>
		<%}else{%>
		<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName().toUpperCase() %></option>
		<%}}%>
	</select>  <label>Sub Group</label> <select id="subChargeCodeId"
		name="subChargeCode_id" onchange="showPatientHistory(this.value)">
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
		<div class="clear"></div> <input type="button" name="delete" value=""
		class="buttonDel" onclick="removeRow();" /> <input type="hidden"
		size="2" value="" name="noOfRecords" id="noOfRecords" />
		<div class="clear"></div>
		<label>Pending Investigation</label>
		<select name="pendingName" id="pendingId" onChange="getDetails('<%=hin%>');">
		<option value="0">Select</option>
		<%if(hdList!=null && hdList.size()>0){
		System.out.println("hdList.size() --- ----  >>"+hdList.size());
		for(DgOrderhd hd:hdList){ 
		if(hd.getVisit()!=null){%>
		<option value="<%=hd.getId()%>"><%=""+hd.getOrderNo()+"["+hd.getOrderDate()+"]"%></option>
		<%} }}%>
		</select>
		<div class="clear"></div>
		
		
		
		<div id="newReqDiv">
		<div class="tableHolderAuto">
			<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
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
						onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=<%=inc %>&hin=<%=hin%>','rateVal<%=inc %>');test(<%=inc %>)}"
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
						return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&hospitalId="+document.getElementById('hospitalId').value;
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
						onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost(<%=inc%>);}" />
					</td>

					<td id="rateVal<%=inc%>"><input type="text" value=""
						id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
						validate="Rate,float,no"
						onblur="calculateAmt(<%=inc %>);totalCost(<%=inc%>);" readonly="readonly"
						size="15" maxlength="12" /></td>

					<td><input type="text" id="amount<%=inc%>" value=""
						name="<%=AMOUNT%><%=inc%>" onblur="totalCost(<%=inc%>);" class="readonly"
						readonly="readonly" /></td>
					<td><input type="button" name="add" value="" class="buttonAdd"
						onclick="addRow();" tabindex="1" /></td>

				</tr>

				<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
					id="dgOrderhdId" />
			</table>

			<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
				id="hiddenValueCharge" />
				<input type="hidden" value="" name="selectPrevInvestigation"
				id="selectPrevInvestigation" />
		</div>
</div>
		<div class="clear"></div>
		<div class="paddFltRight110">
			<label class="medium"><a>Total Cost</a></label> <input type="text"
				id="totalCostId" name="<%=TOTAL_AMOUNT%>" value="" class="readOnly"
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
	<input type="hidden" name="selectedInvestigationId" id="selectedInvestigationId" value="" />
	<%} }%>
<%--Added by govind 27-07-2017 for IP Lab OrderBooking --%>
<%if(inpatientList.size()>0){
	// int hin = 0;
	 int  counter=0;
	 patientType="IP";
  for(Inpatient inpatient:inpatientList){ 

      
      if(inpatient.getHin()!=null)
      hinId=inpatient.getHin().getId();
      
      if(inpatient.getHin()!=null)
      hin= inpatient.getHin().getId();
%>
	<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
		class="value"><%=(inpatient.getHin()!=null)?inpatient.getHin().getHinNo():""%></label>
<input type="hidden" id="hinIdd" name="hinIdd"
		value="<%= inpatient.getHin().getId()%>" />
	<%
				String middleName = "";
				String lastName = "";
				if(inpatient.getHin()!=null && inpatient.getHin().getPMiddleName() != null){
					middleName = inpatient.getHin().getPMiddleName();
				}
				if(inpatient.getHin()!=null && inpatient.getHin().getPLastName() != null){
					lastName = inpatient.getHin().getPLastName();
				}

				%>
	<%-- <label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <label
		class="value"><%= inpatient.getinpatientNo()%></label> --%> <label>Patient
		Name</label> <label class="value"><%=(inpatient.getHin()!=null)? inpatient.getHin().getPFirstName()+" "+middleName+" "+lastName : ""%></label>
		<label>Gender</label> <label class="value"><%=(inpatient.getHin()!=null) ? inpatient.getHin().getSex().getAdministrativeSexName() : "" %></label>
	<div class="clear"></div> 
	<label>Age</label>
	<%
				String age = "";
				String currentAge = "";
			if(inpatient.getHin()!=null && inpatient.getHin().getAge() != null){
				age = inpatient.getHin().getAge();
			    currentAge = HMSUtil.calculateAgeForADT(age, inpatient.getHin().getRegDate());
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
			if(inpatient.getHin()!=null && inpatient.getHin().getMaritalStatus() != null){
				maritalStatus =inpatient.getHin() .getMaritalStatus().getMaritalStatusName();

			%>
	<label class="value"><%=maritalStatus%></label>
	<%}else{ %>
	<label class="value">-</label>
	<% }%>
	<div class="clear"></div>
	<%-- <%
			String religion = "";
			if(inpatient.getHin().getReligion() != null){
				religion = inpatient.getHin().getReligion().getReligionName();
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
<label> Clinical Notes</label> <input id="clinicalNote"
	type="text" name="<%= CLINICAL_NOTE%>" value=""
	validate="Clinical Notes,string,no" MAXLENGTH="200" tabindex=1
	style="width: 600px;" />
<%}else{ %>
<label> Clinical Notes</label> <input id="clinicalNote"
	type="text" name="<%= CLINICAL_NOTE%>" value=""
	validate="Clinical Notes,string,no" MAXLENGTH="200" tabindex=1
	style="width: 600px;" />


<%} %>
<div class="clear"></div>

<label> Prescribed By</label> <select id="placedBy"
	name="<%=EMPLOYEE_ID %>" validate="Prescribed By,string,no"
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

for(Inpatient inpatient1 :inpatientSet){
if(inpatient1.getAdStatus().equals("A")){
	inpatientId = inpatient1.getId();

}
%>
<input type="hidden" id="hinId" name="hin" value="<%=patient.getHinNo() %>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient1.getDepartment().getId() %>" />
<%} %>
 <input
	type="hidden" name="hin" value="<%=(inpatient.getHin()!=null) ? inpatient.getHin().getHinNo() : "" %>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=(inpatient.getHin()!=null)? inpatient.getHin().getId() : "" %>" />
<input type="hidden" name="<%=HIN_NO %>"
	value="<%=(inpatient.getHin()!=null)?inpatient.getHin().getHinNo() : "" %>" /> 
	 <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>" /> <input
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
							System.out.println("deptId   "+deptId);
							if(mainChargecode.getMainChargecodeName().equalsIgnoreCase("Laboratory")){
				%>

	<option value="<%=mainChargecode.getId() %>" selected="selected"><%=mainChargecode.getMainChargecodeName().toUpperCase() %></option>
	<%}else{%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName().toUpperCase() %></option>
	<%}}%>
</select>  <label>Sub Group</label> <select id="subChargeCodeId"
	name="subChargeCode_id" onchange="showPatientHistory(this.value)">
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
	<div class="clear"></div> <input type="button" name="delete" value=""
	class="buttonDel" onclick="removeRow();" /> <input type="hidden"
	size="2" value="" name="noOfRecords" id="noOfRecords" />
	<div class="clear"></div>
	<label>Pending Investigation</label>
	<select name="pendingName" id="pendingId" onChange="getDetails('<%=hin%>');">
	<option value="0">Select</option>
	<%if(hdList!=null && hdList.size()>0){
	System.out.println("hdList.size() --- ----  >>"+hdList.size());
	for(DgOrderhd hd:hdList){ 
	if(hd.getInpatient()!=null){%>
	<option value="<%=hd.getId()%>"><%=""+hd.getOrderNo()+"["+hd.getOrderDate()+"]"%></option>
	<%} }}%>
	</select>
	<div class="clear"></div>
	
	
	
	<div id="newReqDiv">
	<div class="tableHolderAuto">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="chargeDetails">
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
					onblur="checkInvestigationItem(<%=inc %>);if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=<%=inc %>&hin=<%=hin%>','rateVal<%=inc %>');test(<%=inc %>)}"
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
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&hospitalId="+document.getElementById('hospitalId').value;
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
					onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost(<%=inc%>);}" />
				</td>

				<td id="rateVal<%=inc%>"><input type="text" value=""
					id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
					validate="Rate,float,no"
					onblur="calculateAmt(<%=inc %>);totalCost(<%=inc%>);" readonly="readonly"
					size="15" maxlength="12" /></td>

				<td><input type="text" id="amount<%=inc%>" value=""
					name="<%=AMOUNT%><%=inc%>" onblur="totalCost(<%=inc%>);" class="readonly"
					readonly="readonly" /></td>
				<td><input type="button" name="add" value="" class="buttonAdd"
					onclick="addRow();" tabindex="1" /></td>

			</tr>

			<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
				id="dgOrderhdId" />
		</table>

		<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
			id="hiddenValueCharge" />
			<input type="hidden" value="" name="selectPrevInvestigation"
			id="selectPrevInvestigation" />
	</div>
</div>
	<div class="clear"></div>
	<div class="paddFltRight110">
		<label class="medium"><a>Total Cost</a></label> <input type="text"
			id="totalCostId" name="<%=TOTAL_AMOUNT%>" value="" class="readOnly"
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
<input type="hidden" name="selectedInvestigationId" id="selectedInvestigationId" value="" />
<%}}%>
<%--Added by govind 27-07-2017 for IP Lab OrderBooking end--%>
	<div class="clear"></div>
	
	<div class="division"></div>
	<input type="button" class="button" value="Submit"
		id="submitForDisable"
		onclick="if(checkTestRow()){submitFormToDisableSubmit1('investigationOrderBooking','lab?method=submitOrderBookingForInvestigation&patientType=<%=patientType %>');}" />
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
<input type="hidden" name="billingScreen" value="<%=billingScreen%>">
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
		if(validateChargeCodeForAutoComplete(this.value, (iteration))){dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal='+(iteration)+'&hin=<%=hin%>','rateVal'+(iteration));};test(iteration)

			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update'+iteration,'lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});

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
					validateQty(this.value,this.id);calculateAmt(iteration);totalCost(iteration);
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
	cell5.id='rateVal'+(iteration);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.readOnly = true;
	e5.id='amount'+(iteration);
	e5.onblur = function(){
					totalCost(iteration);
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
<%-- function addRowInvest(str){
	var strInv=str.split(",");
	var tbl = document.getElementById('chargeDetails');
	tbl.deleteRow(1);
	var lastRow = tbl.rows.length;
	for(var ind=0;ind<strInv.length;ind++){
	var row = tbl.insertRow(lastRow+ind);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = ind;
	hdb.value = iteration;
//alert(iteration);
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
	e1.value=strInv[ind];
	e1.onblur=function(){
		//checkInvestigationItem(iteration);
		if(validateChargeCodeForAutoComplete(this.value, (iteration))){dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCode&rowVal='+(iteration)+'&hin=<%=hin%>','rateVal'+(iteration));};test(iteration)

			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.style.background = '#FFF';
   	newdiv.style.border = '1px solid #000';
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update'+iteration,'lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});

	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=CHARGE_NAME%>'+ (iteration);
	e2.id = 'chargeName'+(iteration)
	e2.tabIndex="1";
	e2.readOnly = true;
	cell2.appendChild(e2);
	e2.size='20';

	var cell3 = row.insertCell(2);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=QUANTITY%>'+ (iteration);
	e3.id = 'qty'+(iteration)
	e3.maxLength="3";
	e3.onblur = function(){
					validateQty(this.value,this.id);calculateAmt(iteration);totalCost(iteration);
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
					totalCost(iteration);
			};
	cell5.appendChild(e5);

	var cell6 = row.insertCell(5);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.onclick = function(){
	           	addRow();
	}
	cell6.appendChild(e6);
	}//end for loop

} --%>
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

function getDetails(val){
	var orderId=document.getElementById('pendingId').value;
	
	submitProtoAjaxWithDivName('investigationOrderBooking','lab?method=getInvestigationDetailsForNewRequest&val='+orderId+'&hin='+val,'newReqDiv');
	
}
function test(inc){
	
	if(null !=document.getElementById('qty'+inc))
	var qtyObj = document.getElementById('qty'+inc).value;
	if(null !=document.getElementById('resrate'+inc))
	var rateObj =document.getElementById('resrate'+inc).value;
	
	var amount = 0;
	amount = parseFloat(qtyObj)*parseFloat(rateObj);
	document.getElementById('amount'+inc).value=amount;
	//document.getElementById('netamount'+inc).value=amount;
	//alert("1")
	var sum=0.0;
	for (i = 1; i <= inc; i++) {
	var value=	document.getElementById('amount'+i).value;
	sum=parseFloat(sum)+parseFloat(value);
}
	//alert("123")
	document.getElementById('totalCostId').value=sum;
	//alert("1234")
}
function showPatientHistory(subChargeId){
    var mainChargeCodeId = document.getElementById("mainChargeCodeId").value;
   // alert(mainChargeCodeId);
    var hin=document.getElementById('hinIdd').value;
	 //alert(hin);
	var hiddenValueCharge=document.getElementById('hiddenValueCharge').value;
	 
	 // alert(hiddenValueCharge);
    var url='/hms/hms/lab?method=showInvestigationBySubChargeId&subChargeId='+subChargeId+'&mainChargeCodeId='+mainChargeCodeId;
    newwindow=window.open(url,'investigationOrderBooking',"left=100,top=10,height=630,width=1024,status=1,scrollbars=yes,resizable=0");
}

function getTableValue(){
	

	var mainChargeCodeId = document.getElementById("mainChargeCodeId").value;
	var sdValues=document.getElementById('selectedInvestigationId').value;
	 var hin=document.getElementById('hinIdd').value;
	 addRowInvest(sdValues);
	// alert(sdValues);
	 
	//var hiddenValueCharge=document.getElementById('hiddenValueCharge').value;
	//oList=document.getElementById('langOpt2');
	
	 //  alert(window.opener.document.getElementById("investigationOrderBooking").value)
<%-- 	   dsubmitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCoded&rowVal=1&hin=<%=hin%>&mainCharge=17','rateVal');
 --%>
	 <%-- submitProtoAjaxWithDivName('investigationOrderBooking','/hms/hms/lab?method=fillChargeCoded&rowVal=1&hin=<%=hin%>','rateVal'); --%>   
	  // window.close(); 
	  // return sdValues;
	
}

</script>