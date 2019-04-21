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
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
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
		
		//List<DgOrderhd> dgOrderhdList = new ArrayList<DgOrderhd>();
		List<DgOrderdt> dgOrderdtList = new ArrayList<DgOrderdt>();
		
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasHospitalType>hospitalTypeList=new ArrayList<MasHospitalType>();
		List<MasDistrict>districtList=new ArrayList<MasDistrict>();
		List<MasHospital>hospitalList=new ArrayList<MasHospital>();
		Map<Integer,String> blockedChargeCodeMap=new HashMap<Integer,String>();
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
		if(map.get("dgOrderdtList") != null){
			dgOrderdtList=(List<DgOrderdt>)map.get("dgOrderdtList");
		}
		if(dgOrderdtList != null) {
			for(DgOrderdt orderDt:dgOrderdtList){
			if(orderDt.getOrderhd().getHin() != null){
		hinId =orderDt.getOrderhd().getHin().getId();
			}
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
		if(map.get("districtList")!=null){
			districtList=(ArrayList<MasDistrict>)map.get("districtList");
		}	
		if(map.get("hospitalTypeList")!=null){
			hospitalTypeList=(ArrayList<MasHospitalType>)map.get("hospitalTypeList");
		}
		if(map.get("hospitalList")!=null){
			hospitalList=(ArrayList<MasHospital>)map.get("hospitalList");
		}
		
		if(map.get("blockedChargeCodeMap")!=null){
			blockedChargeCodeMap=(Map<Integer,String>)map.get("blockedChargeCodeMap");
		}
		List<PatientAddress> patientAddress=new ArrayList<PatientAddress>();
		if(map.get("patientAddress")!=null){
			patientAddress=(List<PatientAddress>)map.get("patientAddress");
		}
		String district="";
		String taluk="";
		String postoffice="";
		String pincode="";
		
		if(null !=patientAddress){
			for(PatientAddress address:patientAddress){
				if (address.getAddressType() != null
						&& address.getAddressType().getId() == 1) {
					if (null != address.getDistrict()) {
						district = address.getDistrict().getDistrictName();
					}
					if (null != address.getTaluk()) {
						taluk = address.getTaluk().getTalukName();
					}
					if (null != address.getPostOffice()) {
						postoffice = address.getPostOffice()
								.getPostCodeName();
					}
					if (null != address.getPinCode()
							&& address.getPinCode() > 0)
						pincode = String.valueOf(address.getPinCode());
				}
			}
		}

		Patient patient = new Patient();
		int deptId = 0;
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		if (session.getAttribute("patientType") != null) {
			patientType = (String) session.getAttribute("patientType");
		}
		String diagSeqNo = "";
		if (map.get("diagSeqNo") != null) {
			diagSeqNo = (String) map.get("diagSeqNo");
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
		<h2>Sample Collection</h2>
	</div>
	<div class="clear"></div>

	<input type="hidden" name="diagNo" id="diagNo" value="<%=diagSeqNo%>" validate="diagNo,metachar,no"/>
	<%-- <div class="Block"><label class="auto">Order Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgOrderhd.getOrderDate())%></label>
<label class="auto">Order Time</label> <label class="value"><%=dgOrderhd.getOrderTime()%></label>
<label class="auto">Order No.</label> <label class="value"><%=dgOrderhd.getOrderNo()%></label>
<label class="auto">Order By</label> <label class="valueAuto"><%=dgOrderhd.getDepartment().getDepartmentName()%></label>
<div class="clear"></div>
</div> --%>
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
	String orderHdId="";
	Map<Integer,Integer> temMap=new HashMap<Integer,Integer>();
	
	for(DgOrderdt orderDt : dgOrderdtList){
		
		if(!temMap.containsKey(orderDt.getOrderhd().getId())){
			temMap.put(orderDt.getOrderhd().getId(),orderDt.getOrderhd().getId());
			orderHdId=orderHdId+","+orderDt.getOrderhd().getId();
			//System.out.println("orderDt   "+orderHdId);
		}
		//orderHdId= String.valueOf(orderDt.getOrderhd().getId()) ;
	if(orderDt.getBill() != null){
		dgOrderhd = orderDt.getOrderhd();
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		if(age==null){
			age="0";
		}
		//currentAge = HMSUtil.calculateAgeForADT(age, dgOrderhd.getHin().getRegDate());
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
			dgOrderhd = orderDt.getOrderhd();
			DgOrderhd  orderhd = orderDt.getOrderhd();
			if(orderhd.getHin() != null){
				patientName=orderhd.getHin().getPFirstName();
				age=orderDt.getOrderhd().getHin().getAge();
				
				/* if(age!=null && !age.trim().equalsIgnoreCase("")&& !age.equalsIgnoreCase("0")){
					currentAge = HMSUtil.calculateAgeForADT(age, dgOrderhd.getHin().getRegDate());
				}  */
				mobileNo=orderhd.getHin().getMobileNumber();
				if(orderhd.getHin().getMaritalStatus() != null){
				maritalStatus = orderhd.getHin().getMaritalStatus().getMaritalStatusName();
				}else{
					maritalStatus="--";
				}
				if(orderhd.getHin().getSex()!=null)
				sex=orderhd.getHin().getSex().getAdministrativeSexName();
				hinNo=orderhd.getHin().getHinNo();
			}
		}
}
	
		if(dgOrderhd.getHin() != null){
			patientName=dgOrderhd.getHin().getPFirstName();
			age=dgOrderhd.getHin().getAge();
			
			/* if(age!=null && !age.trim().equalsIgnoreCase("")&& !age.equalsIgnoreCase("0")){
				currentAge = HMSUtil.calculateAgeForADT(age, dgOrderhd.getHin().getRegDate());
			}  */
			mobileNo=dgOrderhd.getHin().getMobileNumber();
			if(dgOrderhd.getHin().getMaritalStatus() != null){
			maritalStatus = dgOrderhd.getHin().getMaritalStatus().getMaritalStatusName();
			}else{
				maritalStatus="--";
			}
			if(dgOrderhd.getHin().getSex()!=null)
			sex=dgOrderhd.getHin().getSex().getAdministrativeSexName();
			hinNo=dgOrderhd.getHin().getHinNo();
		}

%>
	<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId%>" validate="hinId,int,no"/>
	<div class="Block">
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
		<%if(hinNo != null){ %>
		<label class="value" validate="hinNo,metachar,no"><%=hinNo%></label>
		<%}else{ %>
		<label class="value">-</label>
		<% }%>
		<label>Patient Name</label> <label class="value" validate="Patient Name,metachar,no"><%=patientName%></label>

		<label> Sex</label> <label class="value" validate="Sex,metachar,no"><%=sex %></label>
		<%-- <label class="medium">Age</label>
		<%if(currentAge != null){ %>
		<label class="valueMedium"><%=currentAge%></label>
		<%}else{ %>
		<label class="valueMedium">-</label>
		<% }%> --%>

		<div class="clear"></div>
		<%if("IP".equalsIgnoreCase(patientType)){%>
		<label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label><label
			class="value" validate="ipd_no,metachar,no"><%=dgOrderhd.getInpatient().getAdNo() %></label> <label>Ward</label><label
			class="value" validate="Ward,metachar,no"><%=dgOrderhd.getDepartment().getDepartmentName() %></label>
		<label>Bed No</label> <label class="value" validate="Bed No,int,no"><%=dgOrderhd.getInpatient().getBed().getBedNo() %></label>
		<div class="clear"></div>
		<%}%>
		<%
		String bloodGroup="-";
		 if(dgOrderhd.getHin().getConfirmedStatus()!=null && dgOrderhd.getHin().getConfirmedStatus().equalsIgnoreCase("y") && dgOrderhd.getHin()!=null && dgOrderhd.getHin().getBloodGroupValue()!=null){
			bloodGroup=dgOrderhd.getHin().getBloodGroupValue();
		} 
		
		/* if(dgOrderhd.getHin().getMobileNumber()!=null && !"".equalsIgnoreCase(dgOrderhd.getHin().getMobileNumber().trim())){
			mobileNumber=dgOrderhd.getHin().getMobileNumber();
		} */
		String unit="-";
		if(dgOrderhd.getInpatient()!=null){
		if(dgOrderhd.getInpatient().getUnitM()!=null && !"".equalsIgnoreCase(dgOrderhd.getInpatient().getUnitM().getUnitCode().trim())){
			unit=dgOrderhd.getInpatient().getUnitM().getUnitCode();
		}
		}else{
			if(dgOrderhd.getVisit().getUnit()!=null && !"".equalsIgnoreCase(dgOrderhd.getVisit().getUnit().getUnitCode().trim())){
				unit=dgOrderhd.getVisit().getUnit().getUnitCode();
			}	
			
		}
		%>
		<label>Blood Group</label> <label class="value" validate="Blood Group,metachar,no"><%=bloodGroup%></label> 
		<label>Mobile No</label> <label class="value" validate="Mobile No,metachar,no"><%=mobileNo!=null?mobileNo:""%></label>
		<label>Unit</label><label class="value" validate="Unit,metachar,no"><%=unit%></label>
		<div class="clear"></div>
		<%
		String fName="";
		String lName="";
		String mName="";
		if(dgOrderhd.getPrescribedBy()!=null){
			if(dgOrderhd.getPrescribedBy().getFirstName()!=null){
				fName=dgOrderhd.getPrescribedBy().getFirstName();
			}if(dgOrderhd.getPrescribedBy().getLastName()!=null){
				lName=dgOrderhd.getPrescribedBy().getLastName();
			}
			if(dgOrderhd.getPrescribedBy().getMiddleName()!=null){
				mName=dgOrderhd.getPrescribedBy().getMiddleName();
			} 
		}
		%>

		<label>Doctor Name</label> <label class="value" validate="Doctor Name,metachar,no"><%=fName+" "+mName+" "+lName%></label>
	
	
	<label>District</label> <label class="value"><%=district %></label> 
	<label>Taluk</label> <label class="value"><%=taluk %></label> <div class="clear"></div>
	<label>PostOffice</label> <label class="value" ><%=postoffice %></label> 
	
	<label>PinCode</label> <label class="value" ><%=pincode %></label> 
	<%if( dgOrderhd.getInpatient() != null){%>
	<input type="hidden" name="<%=INPATIENT_ID %>"
		value="<%= dgOrderhd.getInpatient().getId()%>" validate="inpatientId,int,no"/>
	<%} %>
	<div class="clear"></div>
	<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" validate="departmentId,int,no"/>
	<input type="hidden" name="<%=ORDER_BOOKING_ID %>"
		value="<%=orderHdId%>" />

	<div class="clear"></div>
	</div>
	<!--Block First Ends-->
	<!-- Block Two Starts -->
	<h4>Sample Details</h4>
	<div class="clear"></div>
	<div class="Block">

		<label class="medium">Date</label> <label class="valueAuto" validate="Date,date,no"><%=date%></label>
		<label class="medium">Time</label> <label class="valueAuto" validate="Time,metachar,no"><%=time%></label>
		<label class="medium"><span>*</span> Collected By</label>
		<%Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		String empFName="";
		String empMName="";
		String empLName=""; 
		if(user.getEmployee().getFirstName()!=null){
			empFName=user.getEmployee().getFirstName();
		}if(user.getEmployee().getMiddleName()!=null){
			empMName=user.getEmployee().getMiddleName();
		}
		if(user.getEmployee().getLastName()!=null){
			empLName=user.getEmployee().getLastName();
		} %>
		<label class="valueAuto" validate="Collected By,metachar,yes"><%=empFName+" "+empMName+" "+empLName%></label>
		<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=empId%>" validate="employeeId,int,no"/>

<label class="medium">Refer</label>
<input id="refer" type="checkbox"  onclick="showReferHospital();"	name="refer" value="" MAXLENGTH="50" tabindex=1 validate="refer,metachar,no"/>

<div class="clear"></div>
<div id="referDivId" style="display: none;">
<h4>Refer Details</h4>
<div class="clear"></div>
<label class="medium">District</label>
<select name="districtName" id="districtId">
<option value="0">Select</option>
<%for(MasDistrict md:districtList){ %>
<option value="<%=md.getId() %>"><%=md.getDistrictName() %></option>
<%} %>
</select>
<label class="medium">Hospital Type</label>
<select name="hospitalTypeName" id="hospitalTypeId" onchange="bmitbmitProtoAjaxWithDivName('sampleCollection','/hms/hms/lab?method=getHospitalForDistrict','hospitalNameDiv')">
<option value="0">Select</option>
<%for(MasHospitalType mht:hospitalTypeList){ %>
<option value="<%=mht.getId() %>"><%=mht.getHospitalTypeName() %></option>
<%} %>

</select>
<div id="hospitalNameDiv">
<label class="medium">Hospital </label>
<select name="hospitalName" id="hospitalNameId" >
<option value="0">Select</option>
<%for(MasHospital mh:hospitalList){ %>
<option value="<%=mh.getId() %>"><%=mh.getHospitalName() %></option>
<%} %>

</select>
</div>
<% Map<String,Integer> testMap=new HashMap<String,Integer>();
String tempString="";
int count=0;
for(DgOrderdt dgOrderdt1 :dgOrderdtList){
	tempString="";
	boolean successOrder1=false;
	if(dgOrderdt1.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG") && (dgOrderdt1.getOrderStatus().equalsIgnoreCase("P"))){
		successOrder1=true;
	}else if((dgOrderdt1.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG"))&&(dgOrderdt1.getOrderStatus().equalsIgnoreCase("P")) &&("IP".equalsIgnoreCase(dgOrderdt1.getOrderhd().getPatientType()))){
		successOrder1=true;
	}
	if(successOrder1){
		tempString=dgOrderdt1.getChargeCode().getSubChargecode().getSubChargecodeName()+"@";
			if(investigationList != null){
         	   for(DgMasInvestigation dgMasInvestigation : investigationList)
                {
				 if((dgMasInvestigation.getId()!=null)&& (dgOrderdt1.getChargeCode().getId()!=null)) {
         			  if(((dgMasInvestigation.getChargeCode().getId()).equals(dgOrderdt1.getChargeCode().getId()))&& (dgMasInvestigation.getSample()!=null)){
         				 tempString=tempString+dgMasInvestigation.getSample().getSampleDescription()+"@";
						}
         			  }
                
		    	 if((dgMasInvestigation.getChargeCode().getId()).equals(dgOrderdt1.getChargeCode().getId()) && dgMasInvestigation.getCollection() != null){
		      if(dgOrderdt1.getChargeCode().getId() == dgMasInvestigation.getChargeCode().getId()){
		    	  for(DgMasCollection dgMasCollection :conatinerList){ 	  
		    	  if(dgMasInvestigation.getCollection().getId() == dgMasCollection.getId()){
		    		  tempString=tempString+dgMasInvestigation.getCollection().getCollectionName()+"@" ;
		    	  }
		    	  }  
		    	  }
		    	 }
			}
		}
			
}
	if(testMap.containsKey(tempString)){
		testMap.put(tempString, testMap.get(tempString)+1);
	
}else{
	testMap.put(tempString,1);
}
	}%>
</div>
		
		<%-- <select id="collectedBy"
			name="<%=EMPLOYEE_ID %>" validate="Collected By,string,yes">
			<option value="0">Select</option>
			<%
		Users user = (Users)session.getAttribute("users");
		Integer empId =user.getEmployee().getId();
		String empFName="";
		String empMName="";
		String empLName=""; 
		if(user.getEmployee().getFirstName()!=null){
			empFName=user.getEmployee().getFirstName();
		}if(user.getEmployee().getMiddleName()!=null){
			empMName=user.getEmployee().getMiddleName();
		}
		if(user.getEmployee().getLastName()!=null){
			empLName=user.getEmployee().getLastName();
		}
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

		<%-- <label><span>*</span> Collection Center</label> <select
			name="<%= COLLECTION_CENTER_ID %>"
			validate="Collection Center,string,yes" tabindex="1">
			<!-- <option value="0">Select</option> -->
			<%
				   if(collectionCenterList != null){
					for (DgCollectionCenter  dgCollectionCenter : collectionCenterList){
					%>
			<option value="<%=dgCollectionCenter.getId ()%>"><%=dgCollectionCenter.getCollectionCenterName()%></option>
			<%}
				  }else{ %>
			<option value="0">Select</option>
			<%} %>
		</select> --%>
		<div class="clear"></div>

		<%-- <label>Brief Clinical Notes</label> <% if(dgOrderhd.getClinicalNote() != null){ %>
			<label class="valueAuto"><%=dgOrderhd.getClinicalNote()%></label> <%}else{ %>
			<label class="valueAuto"></label> <%} %> --%>

		<div class="clear"></div>
		<%-- <label>Reason for Urgency</label> <% if(dgOrderhd.getUrgentRemarks() != null){ %>
				<label class="valueAutoBold"><span><%=dgOrderhd.getUrgentRemarks()%></span></label>
				<%}else{ %> <label class="valueAuto"></label> <%} %> --%>
		<div class="clear"></div>
		<input type="hidden" value="0" name="pagecounter2" validate="pagecounter2,int,no"/> <input
			type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" validate="pageNo,int,no"/>
	</div>
	<!-- Block two Ends -->
	<div class="clear"></div>

	<div class="cmntable">	
	<table width="100%" border="0" cellspacing="0" cellpadding="0" id="totalInvestigationCount">
		<tr>
			<th scope="col">Modality </th>			
			<th scope="col">Sample</th>
			<th scope="col">Container</th>
			<th scope="col">Number of Investigation</th>
			</tr>
			
<%	Set<String> keyss = testMap.keySet();
for(String ch:keyss){ 
	String tempch=ch;
String ss[]=ch.split("@");

if(ss.length>=3){
%>
<tr>
<td><%=ss[0] %></td>
<td><%=ss[1] %></td>
<td><%=ss[2] %></td>
<td><%=testMap.get(tempch)%></td>
</tr>
   
<%}}%>
</table>
</div>

<!-- Table Starts -->

		<%
int detailCounter=8;
int temp=0; 
int inc=1;
if(pageNo!=1)
{
temp=detailCounter*(pageNo-1);
}
%>
		<% System.out.println(dgOrderdtList.isEmpty());
		if(!dgOrderdtList.isEmpty()){ %>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="sampleCollectionTabId">

		<tr>
			<th scope="col">S.No.</th>
			<th scope="col">Collected<input type="checkbox" name="checkall"
				class="radioCheck" value="Collected All" id="addbutton"
				onclick="checkAll(this);" align="right" /></th>
			<th scope="col">Not Available<input type="checkbox" name="checkall"
				class="radioCheck" value="Not Avilable" id="removebutton"
				onclick="checkAllReject(this);" align="right" /></th>
			<th scope="col">Test Name</th>
			<th scope="col">Sample</th>
			<th scope="col">Container</th>
			<!-- <th scope="col">Refer
			<input type="checkbox" name="checkall"
				class="radioCheck" value="Refer" id="referbutton"
				onclick="checkAllRefer(this);" align="right" />
			</th> -->
			<!-- <th scope="col">Quantity</th> -->
			<th scope="col">Remarks</th>
		</tr>
		
					<%for(DgOrderdt dgOrderdt :dgOrderdtList){
						boolean successOrder=false;
						if(dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG") && (dgOrderdt.getOrderStatus().equalsIgnoreCase("P"))){
							successOrder=true;
						}else if((dgOrderdt.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode().equalsIgnoreCase("DIAG"))&&(dgOrderdt.getOrderStatus().equalsIgnoreCase("P")) &&("IP".equalsIgnoreCase(dgOrderdt.getOrderhd().getPatientType()))){
							successOrder=true;
						}
						if(successOrder){
						%>
		<tr>


			<td width="5%"><label name="<%=SR_NO%>"><%=temp+inc%><input
					type="hidden" name="orderDtId<%=inc%>" id="orderDtId<%=inc%>"
					value=<%= dgOrderdt.getId()%> /></label></td>
			<td>
			<%if(blockedChargeCodeMap.get(dgOrderdt.getChargeCode().getId())!=null){%>
				<input  type="checkbox"
				class="radioCheck" value="n" disabled="disabled" /> 
			<%}else{%>
				<input
				id="checkId<%=inc%>" name="<%=COLLECTED%>" type="checkbox"
				class="radioCheck" value="n" onclick="accepted(this,<%=inc%>);" />
				<input type="hidden" id="collected<%=inc%>"
				name="<%=COLLECTED_VALUE%><%=inc%>" value="n" />
			<%}%>
			
			 
			</td>
			<td><input type="hidden" id="<%=REJECTED%><%=inc%>"
				name="<%=REJECTED%><%=inc%>" value="n" /> <input
				id="rejectId<%=inc%>" name="<%=REJECTED%>" type="checkbox"
				class="radioCheck" value="n" onclick="notAccepted(this,<%=inc%>);" /></td>
			<input type="hidden" name="rowLength" id="rowLength"
				value="<%=dgOrderdtList.size()%>" />
			<input type="hidden" name="<%=CHARGE_CODE_ID%>"
				id="chargeCodeId<%=inc %>"
				value="<%=dgOrderdt.getChargeCode().getId() %>" />
			<input type="hidden" name="mainCharge" id="mainChargeId<%=inc %>"
				value="<%=dgOrderdt.getMainChargecode().getId() %>" />
			<input type="hidden" name="subCharge" id="subChargeId<%=inc %>"
				value="<%=dgOrderdt.getSubChargeid().getId() %>" />
			<td>
				<%if(dgOrderdt.getChargeCode() !=null){ %> <label
				name="<%=INVESTIGATION_NAME%>" style="font-weight: bold;" validate="investigationName,metachar,no"><%=dgOrderdt.getChargeCode().getChargeCodeName() %>
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
				value="<%=dgMasInvestigation.getSample().getId() %>" validate="sample_id,metachar,no"/> <label
				name="<%=SAMPLE_NAME%>" validate="sampleName,metachar,no"><%=dgMasInvestigation.getSample().getSampleDescription() %></label>
				<% break;
            		  }else if((investigationList.indexOf(dgMasInvestigation)==((investigationList.size())-1))){
            		  %> <input type="hidden" name="<%=SAMPLE_ID%><%=inc%>"
				id="sampleId<%=inc%>" value="" validate="sample_id,metachar,no" /> <label>-</label> <%
				}
            			 }
                   }
               }%>
			</td>
			<%-- <% if(investigationList != null){
            	   for(DgMasInvestigation dgMasInvestigation : investigationList)
                   {

            		   if((dgMasInvestigation.getId()!=null)&& (dgOrderdt.getChargeCode().getId()!=null)){ 
            			     //if(((dgMasInvestigation.getId()).equals(dgOrderdt.getChargeCode().getId()))&& (dgMasInvestigation.getSample()!=null)){
            				   if(((dgMasInvestigation.getChargeCode().getId()).equals(dgOrderdt.getChargeCode().getId()))&& (dgMasInvestigation.getSample()!=null)){	
            		   	%>
			<input type="hidden" name="<%=SAMPLE_ID%><%=inc%>" id="sampleId<%=inc %>"
				value="<%=dgMasInvestigation.getSample().getId() %>" />

			<% break;
            		  }else if((investigationList.indexOf(dgMasInvestigation)==((investigationList.size())-1))){%>
			<input type="hidden" name="<%=SAMPLE_ID%><%=inc%>" id="sampleId<%=inc %>"
				value="" />
			<%}}
                   }
               }}%> --%>

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
    %> <label><%=dgMasInvestigation.getCollection().getCollectionName() %></label>
				<input type="hidden" name="<%=CONTAINER %><%=inc%>"
				value="<%=dgMasInvestigation.getCollection().getId() %>" validate="container,metachar,no"></input> <%    }  
				}
      } 
      
     }
     }
	      	}if(flag){
	      	%> <input type="hidden" name="<%=CONTAINER %><%=inc%>" value="" validate="container,metachar,no"></input>
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

	<%-- <td><input id="refer<%=inc%>" type="checkbox"  onclick="showReferHospital(<%=inc %>);"	name="refer<%=inc%>" value="" MAXLENGTH="50" tabindex=1 validate="refer,metachar,no"/>
	<input id="referStatus<%=inc%>" type="hidden"  name="referStatus<%=inc%>" value="n" MAXLENGTH="50" tabindex=1 validate="refer,metachar,no"/>
	
	</td> --%>

			<td><input id="remarks<%=inc%>" type="text"
				name="<%=REMARKS%><%=inc%>" value="" MAXLENGTH="50" tabindex=1 validate="remarks,metachar,no"/>
				
				</td>
		</tr>

		<% inc++;
	}%>
<input type="hidden" value="" name="nosample" id="nosampleId"/>
		<%}}else{%>
		<input type="hidden" value="nosample" name="nosample" id="nosampleId"/>
		<h3>No Investigation Prescribed</h3>
		 <%}%>
		<input type="hidden" value="<%=inc%>" name="totalRow" id="totalRowId" validate="totalRow,int,no"></input>
	</table>
	</div>
	
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="hidden" name="counter" value="<%=inc %>" validate="counter,int,no"/><input
		type="button" class="button" value="Submit"
		onclick="if(validateCollected())submitForm('sampleCollection','lab?method=submitSampleCollection');"
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
	var sampleNotAvailable;
	flag = true;
	 counter = document.getElementById('totalRowId').value;
	 if(undefined != document.getElementById('nosampleId') ){
		sampleNotAvailable= document.getElementById('nosampleId').value;
	 }
	 			 for(var i = 1; i <counter; i++){
	 			  if(document.getElementById('rejectId'+i).checked || (document.getElementById('checkId'+i)!=null && document.getElementById('checkId'+i).checked))
	               {
	               	flag = false;
	      		  }
	   		}
	   		if(!flag && sampleNotAvailable =="")
	   		{
	   			flag= true;
	 		}
	   		else if(sampleNotAvailable !=""){
	   			
	   			flag= true;
	   		}
	 		else{
	 			alert("Please Collect atleast one Sample....");
	 			flag= false;
	 		}
	   		
	   		
	   		return flag;
}
/* var msg="";
var count=document.getElementsByName('collected').length;
		 for(var i = 0; i < document.getElementsByName('collected').length; i++){

			  if(document.getElementsByName('collected')[i].checked == true )
              {
				count=count-1
				//alert("Please Collect atleast one Sample....")
				//return false;
			}
  		}
  		 if(count == document.getElementsByName('collected').length )
              {

				alert("Please Collect atleast one Sample....")
				return false;
			}
  		 if(msg != ""){
			 	alert(msg);
			 	return false;
		}
		return true;

	} */
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
  			if(document.getElementById('checkId'+j) != null){
  				document.getElementById('checkId'+j).value="y";
				document.getElementById('checkId'+j).checked=true; 
				document.getElementById('collected'+j).value="y"; 
  			}
				
				
				document.getElementById('rejectId'+j).value="n";
				document.getElementById('rejectId'+j).checked=false;  
				document.getElementById('rejected'+j).value="n"; 
				document.getElementById('removebutton').checked=false;
  			
 			 
 		}
	}else{
		checkall.checked == false ; 
	 	for (var j=1;j <= c;j++) {
	 		if(document.getElementById('checkId'+j) != null){
  			document.getElementById("checkId"+j).checked =false;
  			document.getElementById('checkId'+j).value="n";
  			document.getElementById('collected'+j).value="n";
	 		}
  			
 	 	
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
				
				
				if(document.getElementById('checkId'+j)!= null){
				document.getElementById('checkId'+j).value="n";
				document.getElementById('checkId'+j).checked=false;
				document.getElementById('collected'+j).value="n";
  				}
				
				document.getElementById('addbutton').checked=false; 
 			 
 		}
	}else{
		checkAllRejected.checked == false ; 
	 	for (var j=1;j <= c;j++) {
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
	 			  if(document.getElementById('rejectedId'+i).checked || document.getElementById('checkId'+i).checked)
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


 /* function numberForCheckBoxClicked(checkObj,counter)
 {

 //var rowLength=document.getElementById('rowLength').value;

 if(document.getElementById('checkId'+counter).id==checkObj.id)
 {
	 document.getElementById('collected'+counter).value="y";
	 document.getElementById('rejected'+counter).value="n";
	 document.getElementById('rejectId'+counter).checked=false; 
	 
 }else if(document.getElementById('rejectId'+counter).id==checkObj.id){
	 document.getElementById('rejected'+counter).value="y"; 
	 document.getElementById('checkId'+counter).checked=false;   
	 document.getElementById('collected'+counter).value="n";
 
 }
 else if(document.getElementById('checkId'+counter).checked==false)
 { 
  document.getElementById('collected'+counter).value="n";
 }
 else if(document.getElementById('rejectId'+counter).checked==false)
 { 
	document.getElementById('rejected'+counter).value="n";
 }  

 }
 */
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

<script>
function showReferHospital(val){
	//alert(val);
	
	
	var table=document.getElementById("sampleCollectionTabId");
	var r=1;
	while(row=table.rows[r++])
	{
		//alert("row--->>"+row.value);
	}
	
	
	
	
	
	
	 if(document.getElementById('refer').checked==true){
		// alert("in if");
		 document.getElementById('referDivId').style.display="inline";
		// document.getElementById('referStatus'+val).value="y";
	 }else if(document.getElementById('refer').checked==false){
		 //alert("in else");
		 //document.getElementById('hospitalNameId').value="0";
		 //document.getElementById('hospitalTypeId').value="0";
		 //document.getElementById('districtId').value="0";
		 document.getElementById('referDivId').style.display="none";
		 document.getElementById('referStatus'+val).value="n";
	 }
}

</script>

<style>
.cmntable table th {background:#bdd6ee;}
</style>
