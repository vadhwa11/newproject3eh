<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : SampleCollection.jsp
	 * Tables Used         :
	 * Description         :
	 * @author    Name: Dipali
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="jkt.hms.masters.business.MasEmpaneled"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.DgCollectionCenter"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>

<form name="sampleCollection" method="post" action="">
	<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();

	List<DgCollectionCenter> collectionCenterList = new ArrayList<DgCollectionCenter>();
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgMasCollection> conatinerList = new ArrayList<DgMasCollection>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
	List<Patient> patientList = new ArrayList<Patient>();
	DgOrderhd dgOrderhd= new DgOrderhd();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	String patientType="";
	int hinId= 0;
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForNursing = properties.getProperty("empCategoryCodeForNursing");

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("dgOrderhdList") != null){
		dgOrderhdList=(List)map.get("dgOrderhdList");
	}
	if(dgOrderhdList != null) {
		dgOrderhd = (DgOrderhd) dgOrderhdList.get(0);
		if(dgOrderhd.getHin() != null){
			hinId =dgOrderhd.getHin().getId();
		}
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	if(map.get("collectionCenterList") != null){
	    collectionCenterList = (ArrayList)map.get("collectionCenterList");
	}
	if(map.get("investigationList") != null){
		investigationList = (ArrayList)map.get("investigationList");
	}
	if(map.get("conatinerList") != null){
		conatinerList = (ArrayList)map.get("conatinerList");
	}
	Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();
	dgOrderdtSet = dgOrderhd.getDgOrderdts();
	Patient patient = new Patient();
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
		if(session.getAttribute("patientType") != null){
			patientType = (String)session.getAttribute("patientType");
		}
String diagSeqNo="";
if(map.get("diagSeqNo")!=null)
{
	diagSeqNo=(String)map.get("diagSeqNo");
	}

%>
	<!--main content placeholder starts here-->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<div class="titleBg">
		<h2>Sample For Empanelled</h2>
	</div>
	<div class="clear"></div>

	<input type="hidden" name="diagNo" id="diagNo" value="<%=diagSeqNo%>" />
	<div class="clear"></div>
	<!--Block First Starts-->
	<h4>Patient Details</h4>
	<div class="clear"></div>

	<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	String mobileNo=null;
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	set = dgOrderhd.getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		currentAge = HMSUtil.calculateAgeForADT(age, dgOrderhd.getHin().getRegDate());
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		mobileNo=billHeader.getHin().getMobileNumber();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId(); 
		if(billHeader.getHin().getMaritalStatus() != null){
		maritalStatus = billHeader.getHin().getMaritalStatus().getMaritalStatusName();
		}
		}else {
			patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
			currentAge=billHeader.getAge(); 
			hinNo="--";
			maritalStatus="--";
		}
		}else{
			DgOrderhd  orderhd = orderDt.getOrderhd();
			if(orderhd.getHin() != null){
				patientName=orderhd.getHin().getPFirstName();
				age=orderhd.getHin().getAge();
				if(age!=null && !age.trim().equalsIgnoreCase("")&& !age.equalsIgnoreCase("0")){
					currentAge = HMSUtil.calculateAgeForADT(age, dgOrderhd.getHin().getRegDate());
				} 
				mobileNo=orderhd.getHin().getMobileNumber();
				if(orderhd.getHin().getMaritalStatus() != null){
				maritalStatus = orderhd.getHin().getMaritalStatus().getMaritalStatusName();
				}else{
					maritalStatus="--";
				}
				sex=orderhd.getHin().getSex().getAdministrativeSexName();
				hinNo=orderhd.getHin().getHinNo();
			}
		}
}%>
	<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" />
	<div class="Block">
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
		<%if(hinNo != null){ %>
		<label class="value"><%=hinNo%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label>Patient Name</label> <label class="value"><%=patientName%></label>

		<label> Gender</label> <label class="value"><%=sex %></label>
		<div class="clear"></div>
		<%if("IP".equalsIgnoreCase(patientType)){%>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label><label
			class="value">-</label>
		<%}%>
		<label>Blood Group</label> <label class="value">-</label>
		<label>Mobile No</label>
		<%if(mobileNo != null){ %>
		<label class="value"><%=mobileNo%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label>Unit</label><label class="value">-</label>
		<%if("IP".equalsIgnoreCase(patientType)){%>
		<div class="clear"></div>
		<label>Ward</label><label class="value">-</label>
		<%}%>
		<%if("IP".equalsIgnoreCase(patientType)){%>
		<label>Bed No</label> <label class="value">-</label>
		<%}%>
		<div class="clear"></div>
		<label>Doctor Name</label> <label class="value">-</label>
	</div>
	<%if( dgOrderhd.getInpatient() != null){%>
	<input type="hidden" name="<%=INPATIENT_ID %>"
		value="<%= dgOrderhd.getInpatient().getId()%>" />
	<%} %>
	<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" />
	<input type="hidden" name="<%=ORDER_BOOKING_ID %>"
		value="<%=dgOrderhd.getId()%>" />

	<div class="clear"></div>
	<!--Block First Ends-->
	<!-- Block Two Starts -->
	<h4>Sample Details</h4>
	<div class="clear"></div>
	<div class="Block">

		<label class="auto">Date</label> <label class="valueAuto"><%=date%></label>
		<label><span>*</span> Collected By</label> 
		<%MasEmpaneled user = (MasEmpaneled)session.getAttribute("users");
		Integer empId =user.getId();
		String empFName="";
		String empMName="";
		String empLName=""; 
		if(user.getEmpaneledName()!=null){
			empFName=user.getEmpaneledName();
		 }	/*if(user.getEmployee().getMiddleName()!=null){
			empMName=user.getEmployee().getMiddleName();
		}
		if(user.getEmployee().getLastName()!=null){
			empLName=user.getEmployee().getLastName();
		} */ %>
		<label class="valueAuto"><%=empFName+" "+empMName+" "+empLName%></label>
		<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=empId%>" /> 
		<%-- <select id="collectedBy"
			name="<%=EMPLOYEE_ID %>" validate="Collected By,string,yes">
			<option value="0">Select</option>
			<%
		Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		for (MasEmployee  obj : employeeList){

		if(obj.getEmpCategory() != null){


		String nurseFirstName = "";
		String nurseMiddleName = "";
		String nurseLastName = "";
		if(obj.getFirstName()!=null)
		{
			nurseFirstName=obj.getFirstName();
		}
		if(obj.getMiddleName()!=null)
		{
			nurseMiddleName=obj.getMiddleName();
		}
		if(obj.getLastName()!=null)
		{
			nurseLastName=obj.getLastName();
		}


	   if(empId.equals(obj.getId())){
%>
			<option value="<%=obj.getId()%>" selected="selected"><%=nurseFirstName+" "+nurseMiddleName+" "+nurseLastName%></option>
			<%  } else {%>
			<option value="<%=obj.getId()%>"><%=nurseFirstName+" "+nurseMiddleName+" "+nurseLastName%></option>
			<%	} }	} %>
		</select> --%>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<input type="hidden" value="0" name="pagecounter2" /> <input
			type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" />
	</div>
	<!-- Block two Ends -->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<!-- Table Starts -->
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<th scope="col">S.No.</th>
			 <th scope="col">Collected<input type="checkbox" name="checkall"
				class="radioCheck" value="Collected All" id="addbutton"
				onclick="checkAll(this);" align="right" /></th>
			<th scope="col">N/A<input type="checkbox" name="checkall"
				class="radioCheck" value="Not Avilable" id="removebutton"
				onclick="checkAllReject(this);" align="right" /></th>
			<th scope="col">Test Name</th>
			<th scope="col">Sample</th>
			<th scope="col">Container</th>
			<!-- <th scope="col">Quantity</th> -->
			<th scope="col">Remarks</th>
			<th scope="col">Available in Hospital</th>
		</tr>

		<%
int detailCounter=8;
int temp=0; 
int inc=1;
if(pageNo!=1)
{
temp=detailCounter*(pageNo-1);
}
%>
		<%
					for(DgOrderdt dgOrderdt :dgOrderdtSet){
						if(dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG") &&
								(dgOrderdt.getOrderStatus().equalsIgnoreCase("P"))){
						%>
		<tr>


			<td width="5%"><label name="<%=SR_NO%>"><%=temp+inc%><input
					type="hidden" name="orderDtId<%=inc%>" id="orderDtId<%=inc%>"
					value=<%= dgOrderdt.getId()%> /></label></td>
			 <td><input type="hidden" id="collected<%=inc%>"
				name="<%=COLLECTED_VALUE%><%=inc%>" value="n" /> <input
				id="checkId<%=inc%>" name="<%=COLLECTED%>" type="checkbox"
				class="radioCheck" value="n" onclick="accepted(this,<%=inc%>);" />
			</td> 
			<td><input type="hidden" id="<%=REJECTED%><%=inc%>"
				name="<%=REJECTED_FROM_EMPANELLED_SCREEN%><%=inc%>" value="n" /> <input
				id="rejectId<%=inc%>" name="<%=REJECTED_FROM_EMPANELLED_SCREEN%>" type="checkbox"
				class="radioCheck" value="n" onclick="notAccepted(this,<%=inc%>);" /></td>
			<input type="hidden" name="rowLength" id="rowLength"
				value="<%=inc%>" />
			<input type="hidden" name="<%=CHARGE_CODE_ID%>"
				id="chargeCodeId<%=inc %>"
				value="<%=dgOrderdt.getChargeCode().getId() %>" />
			<input type="hidden" name="mainCharge" id="mainChargeId<%=inc %>"
				value="<%=dgOrderdt.getMainChargecode().getId() %>" />
			<input type="hidden" name="subCharge" id="subChargeId<%=inc %>"
				value="<%=dgOrderdt.getSubChargeid().getId() %>" />
			<td>
				<%if(dgOrderdt.getChargeCode() !=null){ %> <label
				name="<%=INVESTIGATION_NAME%>" style="font-weight: bold;"><%=dgOrderdt.getChargeCode().getChargeCodeName() %>
			</label> <%}else { %> <label>-</label> <%} %>
			</td>

			<td>
				<%
               if(investigationList != null){
            	   for(DgMasInvestigation dgMasInvestigation : investigationList)
                   {

            		   if((dgMasInvestigation.getId()!=null)&& (dgOrderdt.getChargeCode().getId()!=null)) {
            			  
            			 if(((dgMasInvestigation.getChargeCode().getId()).equals(dgOrderdt.getChargeCode().getId()))&& (dgMasInvestigation.getSample()!=null)){
            		   	%><input type="hidden" name="<%=SAMPLE_ID%><%=inc%>"
				id="sampleId<%=inc%>"
				value="<%=dgMasInvestigation.getSample().getId() %>" /> <label
				name="<%=SAMPLE_NAME%>"><%=dgMasInvestigation.getSample().getSampleDescription() %></label>
				<% break;
            		  }else if((investigationList.indexOf(dgMasInvestigation)==((investigationList.size())-1))){
            		  %> <input type="hidden" name="<%=SAMPLE_ID%><%=inc%>"
				id="sampleId<%=inc%>" value="" /> <label>-</label> <%
				}
            			 }
                   }
               }%>
			</td>
			<td>
				<%
				boolean flag=true;
     if(investigationList != null){
     for (DgMasInvestigation  dgMasInvestigation : investigationList){
    	 if(dgMasInvestigation.getCollection() != null){
      if(dgOrderdt.getChargeCode().getId() == dgMasInvestigation.getChargeCode().getId()){
    	  for(DgMasCollection dgMasCollection :conatinerList){ 	  
    	  if(dgMasInvestigation.getCollection().getId() == dgMasCollection.getId()){
    		  flag=false;
    %> <lable><%=dgMasInvestigation.getCollection().getCollectionName() %></lable>
				<input type="hidden" name="<%=CONTAINER %><%=inc%>"
				value="<%=dgMasInvestigation.getCollection().getId() %>"></input> <%    }  
				}
      } 
      
     }
     }
	      	}if(flag){ 
	      	%> <input type="hidden" name="<%=CONTAINER %><%=inc%>" value=""></input>
				<%}%>

			</td>
			<%
	int investigationId = 0;
	 if(investigationList != null){
	 for (DgMasInvestigation  dgMasInvestigation : investigationList){
	if(dgOrderdt.getChargeCode().getId() == dgMasInvestigation.getChargeCode().getId()){
	investigationId = dgMasInvestigation.getId();
	 break;
    }else{
    	investigationId =0;
	} }
	}%>

			<input type="hidden" name="<%=INVESTIGATION_ID%><%=inc%>"
				id="investigationId<%=inc%>" value="<%=investigationId%>" />

			<td><input id="remarks<%=inc%>" type="text"
				name="<%=REMARKS%><%=inc%>" value="" MAXLENGTH="50" tabindex=1 /></td>
				
			<td><%="Y".equalsIgnoreCase(dgOrderdt.getNotApplicable())?"Not Available":"Available"%></td>
		</tr>

		<% inc++;
	}%>

		<%} %>
		<input type="hidden" value="<%=inc%>" name="totalRow" id="totalRowId"></input>
	</table>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="hidden" name="counter" value="<%=inc %>" /><input
		type="button" class="button" value="Submit"
		onclick="if(validateCollected())submitForm('sampleCollection','lab?method=submitSampleCollectionEmpnalled');"
		align="right" name="Submit11" /> <input type="reset"
		class="buttonHighlight" name="Reset" id="reset" value="Reset"
		onclick="resetClicked('sampleCollection',<%=inc %>);" accesskey="r" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
			Date</label> <label class="value"><%=date%></label> <label>Changed
			Time</label> <label class="value"><%=time%></label>
		<div class="clear"></div>
	</div>
	<!--Bottom labels ends-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!---------------Java Scripts Related to Sample Collection------------------------------>
<script type="text/javascript">

function validateCollected(){
	flag = true;
	 counter = document.getElementById('totalRowId').value;
	 			 for(var i = 1; i <counter; i++){
	 			  if(document.getElementById('rejectId'+i).checked || (document.getElementById('checkId'+i)!=null && document.getElementById('checkId'+i).checked))
	               {
	               	flag = false;
	      		  }
	   		}
	   		if(!flag)
	   		{
	 			return true;
	 		}
	 		else{
	 			alert("Please Collect atleast one Sample....");
	 			return false;
	 		}
}
 
	</script>
<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">
/* function CheckAll(chk){
var rowLength=document.getElementById('rowLength').value; 
			for(var j=1;j<=rowLength;j++)
			{
				if(chk.type == "checkbox" && chk.value=="Collected All" ){
					 
						document.getElementById('checkId'+j).value="y";
						document.getElementById('checkId'+j).checked=true; 
						document.getElementById('collected'+j).value="y"; 
						
						document.getElementById('rejectId'+j).value="n";
						document.getElementById('rejectId'+j).checked=false;  
						document.getElementById('rejected'+j).value="n"; 
						document.getElementById('removebutton').checked=false; 
						
						
				}else if(chk.type == "checkbox" && chk.value=="Not Avilable"){
					 
						document.getElementById('rejectId'+j).value="y";
						document.getElementById('rejectId'+j).checked=true;
						document.getElementById('rejected'+j).value="y";
						 
						document.getElementById('checkId'+j).value="n";
						document.getElementById('checkId'+j).checked=false;
						document.getElementById('collected'+j).value="n";
						document.getElementById('addbutton').checked=false; 
						 
				}
			 
				
			}  
} */

 function checkAll(checkall)
{
	var c =document.getElementById('rowLength').value; 
	if(checkall.checked ){
		for (var j=1;j <= c;j++) { 
  				document.getElementById('checkId'+j).value="y";
				document.getElementById('checkId'+j).checked=true; 
				document.getElementById('collected'+j).value="y"; 
				
				document.getElementById('rejectId'+j).value="n";
				document.getElementById('rejectId'+j).checked=false;  
				document.getElementById('rejected'+j).value="n"; 
				document.getElementById('removebutton').checked=false;  
 		}
	}else{
		checkall.checked == false ; 
	 	for (var j=1;j <= c;j++) {
  			document.getElementById("checkId"+j).checked =false;
  			document.getElementById('checkId'+j).value="n";
  			document.getElementById('collected'+j).value="n";
 	 	}
 	}
} 

function checkAllReject(checkAllRejected)
{

	var c = document.getElementById('rowLength').value; 
	if(checkAllRejected.checked ){
		for (var j=1;j <= c;j++) { 
  				document.getElementById('rejectId'+j).value="y";
				document.getElementById('rejectId'+j).checked=true;
				document.getElementById('rejected'+j).value="y";
				 
				 document.getElementById('checkId'+j).value="n";
				document.getElementById('checkId'+j).checked=false;
				document.getElementById('collected'+j).value="n";
				document.getElementById('addbutton').checked=false;  	 
 		}
	}else{
		checkAllRejected.checked == false ; 
	 	for (var j=1;j < c;j++) {
  			document.getElementById("rejectId"+j).checked =false; 
  			document.getElementById("rejectId"+j).value ="n";
  			document.getElementById('rejected'+j).value="n";
 	 	}
 	}
}


function checkFilledRow(){
   var msg ="";
	 if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  	var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}

	  			if(msg != ""){
	  				break;
	  			}

	  			}
	  		}
	  	if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
 }

 function accepted(chkObj,counter)
{
	 if(chkObj.checked){
	 if(chkObj.id == "checkId"+counter){ 
		 document.getElementById('collected'+counter).value="y";
		 document.getElementById('checkId'+counter).value="y";
		 document.getElementById('rejected'+counter).value="n";
		 document.getElementById('rejectId'+counter).checked=false; 
	 }
	 }
} 

 function notAccepted(chkObj,counter)
	{	 if(chkObj.checked){
		  if(chkObj.id == "rejectId"+counter){
			  	document.getElementById('rejected'+counter).value="y"; 
				document.getElementById('rejectId'+counter).value="y"; 
				 document.getElementById('checkId'+counter).checked=false;   
				 document.getElementById('collected'+counter).value="n"; 
	  }
	 } 
 }

 function validateSampleValidation(){
	 flag = true;
	 counter = document.getElementById('rowLength').value;
	 			 for(var i = 1; i < counter; i++){
	 			  if(document.getElementById('rejectedId'+i).checked)
	               {
	               	flag = false;
	      		  }
	   		}
	   		if(flag == false)
	   		{
	 			return true;
	 		}
	 		else{
	 			alert("Accept atleast one Test Name !!!!");
	 			return false;
	 		}
	 	} 
 </script>
<script type="text/javascript">

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