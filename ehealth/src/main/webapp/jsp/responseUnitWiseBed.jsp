<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<OtMasUnitDay> otMasUnitDay= new ArrayList<OtMasUnitDay>();
if(map.get("otMasUnitDay") != null){
	otMasUnitDay = (List<OtMasUnitDay>)map.get("otMasUnitDay");
}
List<Inpatient> inpatientss = new ArrayList<Inpatient>();

if(map.get("inPatientSetss") != null){
	inpatientss= (List<Inpatient>)map.get("inPatientSetss");
}
List<MasBed> masBed  = new ArrayList<MasBed>();
if(map.get("masBed") != null){
	masBed= (List<MasBed>)map.get("masBed");
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

<div class="clear"></div>
	
<%
if(inpatientss.size()>0){  
 int inpatientId=0;

	    int  counter=0;
		int loopIndex=1;
	 	for(Inpatient inpatient : inpatientss){
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
					 age = inpatient.getHin().getAge()!=null? inpatient.getHin().getAge():"";
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
			
			String dependentName="-";
			String dependentRelation="-";
			String dependentAddress="-";
			String dependentStatus="-";
			String dependentContact="-";
			dependentStatus="y";
			if(inpatient.getDependentName()!=null && !inpatient.getDependentName().equalsIgnoreCase(""))
			{
			dependentName=inpatient.getDependentName();
			}
			if(inpatient.getAddress()!=null && !inpatient.getAddress().equalsIgnoreCase(""))
			{
			dependentAddress=inpatient.getAddress();
			}
			if(inpatient.getContactNo()!=null && !inpatient.getContactNo().equalsIgnoreCase(""))
			{
			dependentContact=inpatient.getContactNo();
			}
			if(inpatient.getRelation()!=null)
			{
			dependentRelation=inpatient.getRelation().getRelationName();
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
			
			inpatientId=inpatient.getId();
		
		%> 

<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>

<input type="hidden" name="ipdno" value="<%=inpatient.getAdNo() %>" id="ipdno" validate="ipdno,metachar,yes" />
<label><%=prop.getProperty("com.jkt.hms.uhid") %></label>
<input name="hin"  id="hin" value="<%=inpatient.getHin().getHinNo() %>" readonly="readonly" class="readOnly" /> 

<label>Patient Name</label>

<input name="patName"  id="patName" value="<%=patientName %>" readonly="readonly" class="readOnly" />
<input type="hidden" name="<%=PATIENT_NAME %>" value="-" validate="patientName,metachar,no"/>


<label>Address</label>
<input name="add"  id="add" value="-" readonly="readonly" class="readOnly" />
<div class="clear"></div>
<label>Gender</label>
<input name="gender"  id="gender" value="<%=gender %>" readonly="readonly" class="readOnly" />


<label>Marital Status</label>
<input name="mstatus"  id="mstatus" value="<%=materialStatus %>" readonly="readonly" class="readOnly" />
<label>Age</label>
<input name="age"  id="age" value="<%=age%>" readonly="readonly"  class="readOnly" />
<!-- <label>Blood Group</label>
<label class="value"><input name="bgroup"  id="bgroup" value="-" readonly="readonly" class="readOnly" /></label>
 -->
<div class="clear"></div>

<label> Patient Category</label>
<input name="pcategory"  id="pcategory" value="<%=pCategory %>" readonly="readonly" class="readOnly" />

<label>Department</label>
<input name="reffereddep"  id="reffereddep" value="<%=refferedDepartment%>" readonly="readonly" class="readOnly" />

<label>Unit</label>
<input name="unit"  id="unit" value="<%=unit %>" readonly="readonly" class="readOnly" />

<div class="clear"></div>
<label>Referring Doctor</label>
<input name="referdoctor"  id="referdoctor" value="<%=referringDoctor %>" readonly="readonly" class="readOnly" />
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
<%
if(inpatient!=null){
%>
<input type="text" value="<%=inpatient.getAdNo()!=null?inpatient.getAdNo():"" %>"	 readonly="readonly"   name="lastipno" id="lastipno" class="readOnly"   />
<%}else{ %>
<input type="text" value="-"	 readonly="readonly"   name="lastipno" id="lastipno" class="readOnly"   />
<%} %>
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
<input name="admtype"  id="admtype" value="<%=inpatient.getAdmissionType()!=null?inpatient.getAdmissionType().getAdmissionTypeName():""%>" readonly="readonly" class="readOnly"  />
 
<label>Admission Date </label>

	<input type="text" name="admdate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(inpatient.getDateOfAddmission())%>" readonly="readonly"  id="admdate" class="readOnly" />

<label>Admission Time </label>

<input type="text" name="admtime" value="<%=inpatient.getTimeOfAddmission()%>"   id="admtime" readonly="readonly" class="readOnly" />
	<div class="clear"></div>
<%-- [0, "<%= HIN_ID%>", "id"],[4,"add"],[6,"reffereddep"]
			[19,"remarks"],[20,"depname"],[21,"deprelation"]
			,[22,"depcontact"],[23,"depaddr"],[24,"ipdno"],[25,"dependent"]] --%>
<label> Ward</label>
<input name="ward"  id="ward" value="<%=inpatient.getAdWard()!=null?inpatient.getAdWard().getDepartmentName():""%>" readonly="readonly" class="readOnly"/>
<label> Admitting doctor</label>
<input name="admitedby"  id="admitedby" value="<%=addmittedBy%>" readonly="readonly" class="readOnly" />

<label>Remarks</label>
<input name="patientdiet"  id="patientdiet" value="<%=inpatient.getRemarks()!=null?inpatient.getRemarks():""%>" readonly="readonly" class="readOnly" />
	
<label>Critical Condition</label>
<input name="cCondition"  id="cCondition" value="<%=cCondition %>" readonly="readonly" class="readOnly" />


<label>MLC</label>
<input name="mlc"  id="mlc" value="<%=mlc %>" readonly="readonly" class="readOnly" />
	
	<input name="inpatientId"  id="inpatientId" value="<%=inpatientId %>" readonly="readonly" class="readOnly" type="hidden"/>
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
<input name="depname"  id="depname" value="<%=dependentName %>" readonly="readonly" class="readOnly"  />
<label> Relation</label>

<input type="text" name="deprelation"  id="deprelation" value="<%=dependentRelation %>" readonly="readonly" class="readOnly" />
 
<label>Contact No. </label>
 <input name="depcontact"  id="depcontact" value="<%=dependentContact %>" readonly="readonly" class="readOnly" />

<div class="clear"></div>
<label>Address</label>

                       <textarea class="readonly" readonly="readonly" name="depaddr" id="depaddr" cols="20" rows="2" class="readOnly">
<%=dependentAddress %>
               </textarea>
               
     <%counter++;
			loopIndex++;
		}
		
	}
		%> 
              
              
        
               <div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>


<h4>Bed Details</h4>
<div class="clear"></div>
<%if(otMasUnitDay.size()>0)
{
%>
	<div class="cmnTable">
<table id="investigationGrid" class="cmntable">
	<tr>		
<th scope="col">Available Bed No.</th>
<th scope="col">Unit</th>
<th scope="col">Deapartment</th>
<th scope="col">Select Bed</th>
	</tr>
	<%
	int i=0;
		for(OtMasUnitDay ot :otMasUnitDay){
			String unitcode = "";
			Set<OtMasUnitDay> unitDaySet = new HashSet<OtMasUnitDay>();
			 if(ot.getMasBed().getBedType().equalsIgnoreCase("v")){
				 
			
				 unitDaySet = ot.getMasBed().getVBed().getOtMasUnitDays()!=null?ot.getMasBed().getVBed().getOtMasUnitDays():new HashSet<OtMasUnitDay>();
				 for(OtMasUnitDay masUnitDays: unitDaySet){
						unitcode = masUnitDays.getUnitM().getUnitCode();
					}
					
				 
			 }else{
				 unitcode = ot.getUnitM().getUnitCode();
			 }
		
	%>
	<tr>
	<td><%=unitcode %></td>
	<td><%=ot.getUnitM()!= null?ot.getUnitM().getUnitCode():"" %></td>
	<td><%=ot.getMasBed().getDepartment().getDepartmentName() %></td>
	<td><input type="radio" name="bedId" value="<%=ot.getMasBed().getId()%>"  /> </td>
	</tr>
	<%
	i++;
	}
	%>
</table>
</div>
<%
%>

<%}else if(masBed.size()>0)
{
%>
	<div class="cmnTable">
<table id="investigationGrid" class="cmntable">
	<tr>		
<th scope="col">Available Bed No.</th>
<th scope="col">Unit</th>
<th scope="col">Deapartment</th>
<th scope="col">Select Bed</th>
	</tr>
	<%
	int i=0;
	Set<OtMasUnitDay> unitDaySet = new HashSet<OtMasUnitDay>();
	for(MasBed bed:masBed)
	{
	//	if(i<=3)
		//{
		
	%>
	<tr>
	<td><%=bed.getBedNo() %></td>
	<%
	 String hospitalUnitCode = "";
	 
	 Set<OtMasUnitDay> unitSet = new HashSet<OtMasUnitDay>();
	 
	 if(bed.getBedType().equalsIgnoreCase("v")){
		 unitSet = bed.getVBed().getOtMasUnitDays()!=null?bed.getVBed().getOtMasUnitDays():new HashSet<OtMasUnitDay>();
	 }else{
		 unitSet =  bed.getOtMasUnitDays()!=null?bed.getOtMasUnitDays():new HashSet<OtMasUnitDay>();
	 }
		for(OtMasUnitDay masUnitDays: unitSet){
			hospitalUnitCode = masUnitDays.getUnitM().getUnitCode();
		}
	%>
	<td><%=hospitalUnitCode %></td>
	
	<td><%=bed.getDepartment().getDepartmentName() %></td>
	<td><input type="radio" name="bedId" value="<%=bed.getId()%>"  /> </td>
	</tr>
	<%
//	}
		i++;
	}
	%>
</table>
</div>


<%
}else
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




