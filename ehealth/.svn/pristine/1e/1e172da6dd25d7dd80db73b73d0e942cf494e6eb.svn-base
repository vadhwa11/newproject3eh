<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientAdmissionSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitT"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
 <%@page import="jkt.hms.masters.business.MasRelation"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script>
<%
	
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<%
		Map<String, Object> map = new HashMap<String, Object>();

        List<Inpatient> inpatients = new ArrayList<Inpatient>();
        List<MasRelation> relationList = new ArrayList<MasRelation>();
        List<MasBed> beds  = new ArrayList<MasBed>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("inPatientSet") != null){
			inpatients= (List<Inpatient>)map.get("inPatientSet");
		}
		if(map.get("beds") != null){
			beds= (List<MasBed>)map.get("beds");
		}
		String ipdNo="";
		if(map.get("ipdNo") != null){
			ipdNo= (String)map.get("ipdNo");
		}
		System.out.println("ipdNo jsp   __>>"+ipdNo);
		
		if(map.get("relationList") != null){
			relationList= (List<MasRelation>)map.get("relationList");
		}
	%>
	
	<% Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap= (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");%>
	
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<div class="titleBg">
<h2>Bed Allocation</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop25"></div>
<% if(map.get("message")!=null){%>
<span><%= map.get("message")%></span>

<input type="button" name="print" value="print" class="button"	onclick="submitFormForDirectPrint('admissionAcceptance','/hms/hms/adt?method=showIPAdmissionReport&adNo=<%=ipdNo %>')" />

<%}%>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"hin"], [3,"patName"], [4,"address"],[5,"admittingDoctor"],[6,"reffereddep"]
			,[7,"gender"],[8,"mstatus"],[9,"age"],[10,"bgroup"],[11,"pcategory"],[12,"admtype"],[13,"lastipno"],[14,"admdate"]
			,[15,"admtime"],[16,"ward"],[17,"admitedby"],[18,"patientdiet"],[19,"remarks"],[20,"depname"],[21,"deprelation"]
			,[22,"depcontact"],[23,"depaddr"],[24,"ipdno"],[25,"dependent"],[26,"unit"],[27,"referdoctor"]
			,[28,"cCondition"]
			,[29,"mlc"],[30,"inpatientId"]];
			 statusTd = 28;
	</script>
</div>


<!-- <div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div> -->
<script type="text/javascript" language="javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Sl No."
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "slno";
	
	
	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.uhid") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
		
	data_header[3] = new Array;
	data_header[3][0] = "Address"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "address";
	
	data_header[4] = new Array;
	data_header[4][0] = "Admitting Doctor"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "addmittedBy";
	


	data_header[5] = new Array;
	data_header[5][0] = "Department"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "reffereddep";
	
	
	data_header[6] = new Array;
	data_header[6][0] = "Gender"
	data_header[6][1] = "hide";
	data_header[6][2] = "30%";
	data_header[6][3] = "gender";
	
	data_header[7] = new Array;
	data_header[7][0] = "Material Status"
	data_header[7][1] = "hide";
	data_header[7][2] = "30%";
	data_header[7][3] = "mstatus";
	
	data_header[8] = new Array;
	data_header[8][0] = "Age"
	data_header[8][1] = "hide";
	data_header[8][2] = "30%";
	data_header[8][3] = "age";
	
	data_header[9] = new Array;
	data_header[9][0] = "Blood Group"
	data_header[9][1] = "hide";
	data_header[9][2] = "30%";
	data_header[9][3] = "bgroup";
	
	data_header[10] = new Array;
	data_header[10][0] = "Patient Category"
	data_header[10][1] = "hide";
	data_header[10][2] = "30%";
	data_header[10][3] = "pcategory";
	
	data_header[11] = new Array;
	data_header[11][0] = "Admission Type"
	data_header[11][1] = "hide";
	data_header[11][2] = "30%";
	data_header[11][3] = "admtype";
	
	data_header[12] = new Array;
	data_header[12][0] = "Last IPD No."
	data_header[12][1] = "hide";
	data_header[12][2] = "30%";
	data_header[12][3] = "lastipno";
	
	data_header[13] = new Array;
	data_header[13][0] = "Admission date"
	data_header[13][1] = "hide";
	data_header[13][2] = "30%";
	data_header[13][3] = "admdate";
	
	data_header[14] = new Array;
	data_header[14][0] = "Admission Time"
	data_header[14][1] = "hide";
	data_header[14][2] = "30%";
	data_header[14][3] = "admtime";
	
	data_header[15] = new Array;
	data_header[15][0] = "ward"
	data_header[15][1] = "hide";
	data_header[15][2] = "30%";
	data_header[15][3] = "ward";
	
	data_header[16] = new Array;
	data_header[16][0] = "Referring doctor"
	data_header[16][1] = "hide";
	data_header[16][2] = "30%";
	data_header[16][3] = "admitedby";
	
	data_header[17] = new Array;
	data_header[17][0] = "Patient Diet"
	data_header[17][1] = "hide";
	data_header[17][2] = "30%";
	data_header[17][3] = "patientdiet";
	
	data_header[18] = new Array;
	data_header[18][0] = "remarks"
	data_header[18][1] = "hide";
	data_header[18][2] = "30%";
	data_header[18][3] = "remarks";
	
	data_header[19] = new Array;
	data_header[19][0] = "Dependent Name"
	data_header[19][1] = "hide";
	data_header[19][2] = "30%";
	data_header[19][3] = "depname";
	
	data_header[20] = new Array;
	data_header[20][0] = "Dependent Relation"
	data_header[20][1] = "hide";
	data_header[20][2] = "30%";
	data_header[20][3] = "deprelation";
	
	data_header[21] = new Array;
	data_header[21][0] = "Dependent Contact"
	data_header[21][1] = "hide";
	data_header[21][2] = "30%";
	data_header[21][3] = "depcontact";
	
	data_header[22] = new Array;
	data_header[22][0] = "Dependent Address"
	data_header[22][1] = "hide";
	data_header[22][2] = "30%";
	data_header[22][3] = "depaddr";
	
	data_header[23] = new Array;
	data_header[23][0] = "IPD NO"
	data_header[23][1] = "hide";
	data_header[23][2] = "30%";
	data_header[23][3] = "ipdno";
	
	data_header[24] = new Array;
	data_header[24][0] = "Dependent"
	data_header[24][1] = "hide";
	data_header[24][2] = "30%";
	data_header[24][3] = "dependent";
	
	
	data_header[25] = new Array;
	data_header[25][0] = "Unit"
	data_header[25][1] = "data";
	data_header[25][2] = "30%";
	data_header[25][3] = "unit";
	
	data_header[26] = new Array;
	data_header[26][0] = "Referring Doctor"
	data_header[26][1] = "data";
	data_header[26][2] = "30%";
	data_header[26][3] = "referdoctor";
	
	data_header[27] = new Array;
	data_header[27][0] = "Critical Condition"
	data_header[27][1] = "data";
	data_header[27][2] = "30%";
	data_header[27][3] = "cCondition";
	
	data_header[28] = new Array;
	data_header[28][0] = "MLC"
	data_header[28][1] = "data";
	data_header[28][2] = "30%";
	data_header[28][3] = "mlc";
	
	data_header[29] = new Array;
	data_header[29][0] = "inpatientId"
	data_header[29][1] = "hide";
	data_header[29][2] = "30%";
	data_header[29][3] = "inpatientId";
	data_arr = new Array();
	 <%
	    int  counter=0;
	 int inpatientId=0;
		if (inpatients != null && inpatients.size() > 0) {
			int loopIndex=1;
	 	for(Inpatient inpatient : inpatients){
		if(inpatient.getHin().getPatientStatus().equalsIgnoreCase("In Patient")){
			String patientName="";
			patientName=inpatient.getHin().getPFirstName();
			if(inpatient.getHin().getPMiddleName()!=null){
				patientName+=" "+inpatient.getHin().getPMiddleName();	
			}
			if(inpatient.getHin().getPLastName()!=null){
				patientName+=" "+inpatient.getHin().getPLastName();	
			}
			
			String address="";
			if(inpatient.getHin().getPatientAddress()!=null){
				address=inpatient.getHin().getPatientAddress();	
				address = address.replace("\n", "").replace("\r", "");
				//address = address.replaceAll("\'","");
				//address = address.replaceAll("^\"|\"$", "");
				
			}
			String referringDoctor="";
			if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getEmployee()!=null)
			{
				referringDoctor=inpatient.getOpdPatientDetails().getEmployee().getFirstName();
				if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
				{
					referringDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
				}
				if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
				{
					referringDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
				}
			}
					String addmittingDoctor="";
			if(inpatient.getOpdPatientDetails()!=null)
			{
				if(inpatient.getOpdPatientDetails().getEmployee()!=null){
					addmittingDoctor=inpatient.getOpdPatientDetails().getEmployee().getFirstName();
					if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
					{
						addmittingDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
					}
					if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
					{
						addmittingDoctor +=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
					}
				}
				
			}
			
			String addmittedBy="";
			if(inpatient.getDoctor()!=null)
			{
				addmittedBy=inpatient.getDoctor().getFirstName();
				if(inpatient.getDoctor().getMiddleName()!=null)
				{
					addmittedBy +=" "+inpatient.getDoctor().getMiddleName();
				}
				if(inpatient.getDoctor().getLastName()!=null)
				{
					addmittedBy +=" "+inpatient.getDoctor().getLastName();
				}
			}
			String refferedDepartment="-";
			if(inpatient.getDepartment()!=null && inpatient.getDepartment()!=null)
			{
				refferedDepartment=inpatient.getDepartment().getDepartmentName();
			}
			String unit="-";
			if(inpatient.getUnitM()!=null && inpatient.getUnitM()!=null)
			{
				unit=inpatient.getUnitM().getUnitCode();
			}
			String gender="";
			if(inpatient.getHin().getSex()!=null)
			{
				gender=inpatient.getHin().getSex().getAdministrativeSexName();
			}
			String materialStatus="";
			if(inpatient.getHin().getMaritalStatus()!=null)
			{
				materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
			}else
			{
				materialStatus="-";
			}
			
			String age="";
			String currentAge = "-";
			try
			{
					 age = inpatient.getHin().getAge()!=null?inpatient.getHin().getAge():"";
					try{
						if(!age.equals(""))
						currentAge = HMSUtil.calculateAgeForADT(age,inpatient.getHin().getRegDate());
					}catch(Exception ex){
						ex.printStackTrace();
					}
			}
			catch(Exception exception)
			{
				currentAge="-";
			}
			
			/* int currentAge = 0;
			if(inpatient.getHin().getDateOfBirth()!=null){
				currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
				currentAge = HMSUtil.getCurrentAgeByDoB(inpatient.getHin().getDateOfBirth());
			} */
			age=""+currentAge;
			String bloodGroup="";
			if(inpatient.getHin().getBloodGroup()!=null){
				bloodGroup = inpatient.getHin().getBloodGroup().getBloodGroupName();
			}
			else
			{
				bloodGroup="-";
			}
			String pCategory="";
			if(inpatient.getHin().getPatientType()!=null){
				pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
			}
			else
			{
				pCategory="-";
			}
			String admtype="";
			if(inpatient.getAdmissionType()!=null){
				pCategory = inpatient.getAdmissionType().getAdmissionTypeName();
			}
			
			String dependentName="";
			int dependentRelation=0;
			String dependentAddress="";
			String dependentStatus="";
			String dependentContact="";
			dependentStatus="y";
			String newAdd="";//added by govind 21-10-2016
			if(inpatient.getDependentName()!=null && !inpatient.getDependentName().equalsIgnoreCase(""))
			{
			dependentName=inpatient.getDependentName();
			}
			if(inpatient.getAddress()!=null)
			{
				if(inpatient.getAddress()!=null){
			dependentAddress=inpatient.getAddress();
			newAdd=dependentAddress;
			newAdd = newAdd.replace("\n", "").replace("\r", "");
			newAdd = newAdd.replaceAll("\'","");
			newAdd = newAdd.replaceAll("^\"|\"$", "");
			
				}
			//added by govind 21-10-2016
			/*System.out.println("old address "+dependentAddress);
			newAdd=dependentAddress.replaceAll("[\\t\\n\\r]"," ");
			System.out.println("replace "+dependentAddress.replaceAll("[\\t\\n\\r]"," "));
			System.out.println("new address "+newAdd);*/
			//added by govind 21-10-2016 end
			}
			if(inpatient.getContactNo()!=null && !inpatient.getContactNo().equalsIgnoreCase(""))
			{
			dependentContact=inpatient.getContactNo();
			}
			if(inpatient.getRelation()!=null)
			{
			dependentRelation=inpatient.getRelation().getId();
			}
			String cCondition="No";
			String mlc="No";
			if(inpatient.getCriticalCondition()!=null && inpatient.getCriticalCondition().equalsIgnoreCase("y"))
			{
				cCondition="Yes";
			}
			if(inpatient.getMlc()!=null && inpatient.getMlc().equalsIgnoreCase("y"))
			{
				mlc="Yes";
			}
			if(inpatient.getId()!=null && inpatient.getId()!=0)
			{
				inpatientId=inpatient.getId();
			}
			
	%>
	  		data_arr[<%= counter%>] = new Array();
	  		
			data_arr[<%= counter%>][0] = <%= inpatient.getHin().getId()%>
			data_arr[<%= counter%>][1] = <%=loopIndex%>
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			data_arr[<%= counter%>][4] = "<%=address%>"
			data_arr[<%= counter%>][5] = "<%=addmittedBy%>"
			data_arr[<%= counter%>][6] = "<%=refferedDepartment%>"
			data_arr[<%= counter%>][7] = "<%=gender%>"
			data_arr[<%= counter%>][8] = "<%=materialStatus%>"
			data_arr[<%= counter%>][9] = "<%=age%>"
			data_arr[<%= counter%>][10] = "<%=bloodGroup%>"
			data_arr[<%= counter%>][11] = "<%=pCategory%>"
			data_arr[<%= counter%>][12] = "<%=inpatient.getAdmissionType().getAdmissionTypeName()%>"
			data_arr[<%= counter%>][13] = "<%=inpatient.getAdNo()!=null?inpatient.getAdNo():""%>"
			data_arr[<%= counter%>][14] = "<%=HMSUtil.convertDateToStringTypeDateOnly(inpatient.getDateOfAddmission())%>"
			data_arr[<%= counter%>][15] = "<%=inpatient.getTimeOfAddmission()%>"
			data_arr[<%= counter%>][16] = "<%=inpatient.getAdWard().getDepartmentName()%>"
			data_arr[<%= counter%>][17] = "<%=addmittedBy%>";
			data_arr[<%= counter%>][18] = "-";
			data_arr[<%= counter%>][19] = ''.concat('<%=inpatient.getRemarks()!=null?inpatient.getRemarks().replaceAll("\r\n", "'\n+'"):""%>');
			data_arr[<%= counter%>][20] = "<%=dependentName%>";
			data_arr[<%= counter%>][21] = "<%=dependentRelation%>";
			data_arr[<%= counter%>][22] = "<%=dependentContact%>";
			data_arr[<%= counter%>][23] = "<%=newAdd%>"; //added by govind 21-10-2016
	
			data_arr[<%= counter%>][24] = "<%=inpatient.getAdNo()%>";
			data_arr[<%= counter%>][25] = "<%=dependentStatus%>"	;
			data_arr[<%= counter%>][26] = "<%=unit%>";
			data_arr[<%= counter%>][27] = "<%=referringDoctor%>";
			data_arr[<%= counter%>][28] = "<%=cCondition%>";
			data_arr[<%= counter%>][29] = "<%=mlc%>";
			data_arr[<%= counter%>][30] = "<%=inpatientId%>";
			<%counter++;
			loopIndex++;
		}
		
	}}
		%> 
		<%-- [0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"hin"], [3,"patName"], [4,"add"],[5,"refferedby"],[6,"reffereddep"]
		,[7,"gender"],[8,"mstatus"],[9,"age"],[10,"bgroup"],[11,"pcategory"],[12,"admtype"],[13,"lastipno"],[14,"admdate"]
		,[15,"admtime"],[16,"ward"],[17,"admitedby"],[18,"patientdiet"],[19,"remarks"],[20,"depname"],[21,"deprelation"]
		,[22,"depcontact"],[23,"depaddr"],[24,"ipdno"],[25,"dependent"] --%>
	
    formName = "admissionAcceptance"
	
	start = 0;
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
<form name="admissionAcceptance" method="post" action="">

	<div class="clear"></div>
	<div class="Block">
	
	<div id="testDiv">
	
<%if(inpatients.size()>0){ %>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<input type="hidden" name="ipdno" value="" id="ipdno" validate="ipdno,metachar,yes" />
<label><%=prop.getProperty("com.jkt.hms.uhid") %></label>
<input name="hin"  id="hin" value="-" readonly="readonly" class="readOnly" /> 

<label>Patient Name</label>
<input name="patName"  id="patName" value="-" readonly="readonly" class="readOnly" />
<input type="hidden" name="<%=PATIENT_NAME %>" value="-" validate="patientName,metachar,no"/>


<label>Address</label>
<input name="address"  id="address" value="-" readonly="readonly" class="readOnly" />
<div class="clear"></div>
<label>Gender</label>
<input name="gender"  id="gender" value="-" readonly="readonly" class="readOnly" />


<label>Marital Status</label>
<input name="mstatus"  id="mstatus" value="-" readonly="readonly" class="readOnly" />
<label>Age</label>
<input name="age"  id="age" value="-" readonly="readonly"  class="readOnly" />
<!-- <label>Blood Group</label>
<label class="value"><input name="bgroup"  id="bgroup" value="-" readonly="readonly" class="readOnly" /></label>
 -->
<div class="clear"></div>

<label> Patient Category</label>
<input name="pcategory"  id="pcategory" value="-" readonly="readonly" class="readOnly" />

<label>Department</label>
<input name="reffereddep"  id="reffereddep" value="-" readonly="readonly" class="readOnly" />

<label>Unit</label>
<input name="unit"  id="unit" value="-" readonly="readonly" class="readOnly" />

<div class="clear"></div>
<label>Referring Doctor</label>
<input name="referdoctor"  id="referdoctor" value="-" readonly="readonly" class="readOnly" />
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>

<input type="text" value="-"	 readonly="readonly"   name="lastipno" id="lastipno" class="readOnly"   />
<label>Bed Allocation Date</label>
<input type="text" id="bedAllocationDate"   name="bedAllocationDate" validate="Bed Allocation Date,date,no" value="<%= currentDate %>" class="date"  onkeyup="mask(this.value,this,'2,5','/');"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"  onclick="javascript:setdate('<%=currentDate %>',document.admissionAcceptance.bedAllocationDate,true);" />
<div class="clear"></div>
<label>Bed Allocation Time</label>
<input type="text"   id="bedAllocationTime" name="bedAllocationTime"  value="<%= currentTime %>" onKeyUp="mask(this.value,this,'2,5',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="8"/>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<h4>Admission Details</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<label> Admission Type</label>
<input name="admtype"  id="admtype" value="-" readonly="readonly" class="readOnly"  />
 
<label>Admission Date </label>

	<input type="text" name="admdate" value="-" readonly="readonly"  id="admdate" class="readOnly" />

<label>Admission Time </label>

<input type="text" name="admtime" value="-"   id="admtime" readonly="readonly" class="readOnly" />
	<div class="clear"></div>
<%-- [0, "<%= HIN_ID%>", "id"],[4,"add"],[6,"reffereddep"]
			[19,"remarks"],[20,"depname"],[21,"deprelation"]
			,[22,"depcontact"],[23,"depaddr"],[24,"ipdno"],[25,"dependent"]] --%>
<label> Ward</label>
<input name="ward"  id="ward" value="-" readonly="readonly" class="readOnly"/>
<label> Admitting doctor</label>
<input name="admitedby"  id="admitedby" value="-" readonly="readonly" class="readOnly" />

<label>Remarks</label>
<input name="patientdiet"  id="patientdiet" value="-" readonly="readonly" class="readOnly" />
	
<label>Critical Condition</label>
<input name="cCondition"  id="cCondition" value="-" readonly="readonly" class="readOnly" />


<label>MLC</label>
<input name="mlc"  id="mlc" value="-" readonly="readonly" class="readOnly" />
	<input name="inpatientId"  id="inpatientId" value="0" readonly="readonly" class="readOnly" type="text"/>

	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<h4>Bystander/ Attendant</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

	<!-- <label>Dependent</label>
<label class="value"><input type="checkbox" disabled ="disabled " tabindex="1" name="dependent" value="1" id="dependent" class="radioCheck readOnly" />
</label> -->
<label>Dependent Name</label> 
<input name="depname"  id="depname" value="" readonly="readonly" />
<label> Relation</label>

<!-- <input type="text" name="deprelation"  id="deprelation" value=""  /> -->
 	 <select name="deprelation"	id="deprelation" size="1" disabled="disabled">
					 	<option value="0">Select</option>
					 	<% for(MasRelation relation : relationList) { %>
					 		<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
					 	<% } %>
					 </select>
<label>Contact No. </label>
 <input name="depcontact"  id="depcontact" value=""  readonly="readonly" class="readOnly"/>

<div class="clear"></div>
<label>Address</label>
                       <textarea class="readonly" name="depaddr" id="depaddr" cols="20" rows="2"  readonly="readonly">
               </textarea>
               
              
              
        
  <div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Bed Details</h4>
<div class="clear"></div>

<div class="clear"></div>
<%if(beds.size()>0)
{
%>
	<div class="cmnTable">
<table id="investigationGrid" class="cmntable">
	<tr>		
<th scope="col">Available Bed No.</th>
<th scope="col">Unit</th>
<th scope="col">Unit Head</th>
<th scope="col">Deapartment</th>
<th scope="col">Select Bed</th>
	</tr>
	<%
	int i=0;
	Set<OtMasUnitDay> unitDaySet = new HashSet<OtMasUnitDay>();
	Set<HospitalDoctorUnitT> doctorUnitTSet = new HashSet<HospitalDoctorUnitT>();
	for(MasBed bed:beds)
	{
	//	if(i<=3)
		//{
		
	%>
	<tr>
	<td><%=bed.getBedNo() %></td>
	<%
	 String unitCode= "";
	String unitHeadName= "";
	 if(bed.getBedType().equalsIgnoreCase("v")){
		 unitDaySet = bed.getVBed().getOtMasUnitDays()!=null?bed.getVBed().getOtMasUnitDays():new HashSet<OtMasUnitDay>();
	 }else{
		 unitDaySet =  bed.getOtMasUnitDays()!=null?bed.getOtMasUnitDays():new HashSet<OtMasUnitDay>();
	 }
	for(OtMasUnitDay masUnitDays: unitDaySet){
		unitCode = masUnitDays.getUnitM().getUnitCode();
		doctorUnitTSet = masUnitDays.getUnitM().getHospitalDoctorUnitTs();
	}
	
		
	%>
	<td><%=unitCode%></td>
	<%
	for(HospitalDoctorUnitT hospitalDoctorUnitT :doctorUnitTSet){
		if(hospitalDoctorUnitT.getHeadFleg().equalsIgnoreCase("y")){
			unitHeadName = hospitalDoctorUnitT.getEmployee().getEmployeeName();
			
			
		}
	}
	
	%>
	<%
	if(!unitHeadName.equals("")){
	%>
	<td><%=unitHeadName%></td>
	<%}else{ %>
	<td></td>
	<%} %>
	<td><%=bed.getDepartment().getDepartmentName() %></td>
	<td><input type="radio" name="bedId" value="<%=bed.getId()%>"  /> </td>
	</tr>
	<%
//	}
		i++;
	}
	%>
</table>


<!-- 

<div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" >
<option value="0">Select</option>
</select>
</div> 

-->
<%
}
else
{
	%>
	<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<h4>No Beds Available</h4>
<div class="clear"></div>
	<%
}
%>
 </div>
 
<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop25"></div>

<div class="paddingTop15"></div>
<div id="edited" style="display: none;" ></div>
<div class="clear"></div>
<input type="button" class="button" value="Accept" onClick="submitAcceptance()" />
<input type="button" class="button" value="Reset" id="reset" onclick="submitFormForButton('admissionAcceptance','ipd?method=showPatientAdmissionAcceptJsp')" />
<div style="display: none;">
<input type="button" name="add" id="addbutton" value="Add"	class="button" style="display: none;" /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none;"	 />
</div>

<%}else {%>
<h4>No Record Found</h4>
<%} %>
<div class="clear"></div>
<div class="paddingTop25"></div>
</div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>

<script type="text/javascript">
function submitAcceptance()
{
	var check=getCheckedBoxes('bedId');
	if(check==null || check.length==0)
		{
		alert("Please select Bed for Patient");
		return;
		}
	
submitForm('admissionAcceptance','/hms/hms/ipd?method=submitPatientAdmissionAcceptJsp','chkDate');
}

function getCheckedBoxes(chkboxName) {
	  var checkboxes = document.getElementsByName(chkboxName);
	  var checkboxesChecked = [];
	  // loop over them all
	  for (var i=0; i<checkboxes.length; i++) {
	     // And stick the checked ones onto an array...
	     if (checkboxes[i].checked) {
	        checkboxesChecked.push(checkboxes[i]);
	     }
	  }
	  // Return the array if it is non-empty, or null
	  return checkboxesChecked.length > 0 ? checkboxesChecked : null;
	}
	

function chkDate()
{
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1),serverdate.substring(0,2));
	obj1 = document.<%="admissionAcceptance"%>.<%="bedAllocationDate"%>.value;
	date= new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	if(date>currentDate){
		errorMsg += "Bed Allocation Date Not Valid";
		return false;
	}

    return true;
}
</script>
 