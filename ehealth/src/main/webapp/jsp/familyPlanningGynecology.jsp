<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.FamilyPlanningGynecology"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
 	 
<script type="text/javascript" language="javascript">
  <%	
  
  	Map<String, Object> map = new HashMap<String, Object>();
  	FamilyPlanningGynecology familyPlanningGynecology = new FamilyPlanningGynecology();
  	List<Visit> patientList = new ArrayList<Visit>();
	  	
  	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	 
  	if (map.size()>0) {
			 if (map.get("familyPlanningGynecology") != null)
	       {
			 familyPlanningGynecology = (FamilyPlanningGynecology) map.get("familyPlanningGynecology");		
			 
	       }
		}  
	List<MasEmployee> doctorList = new ArrayList<MasEmployee>();
	if(map.get("doctorList") !=null){
		doctorList=(List<MasEmployee>)map.get("doctorList");
	}
			
	if(map.get("patientList") != null)	{
		patientList=(List)map.get("patientList");
	}  
	
	String patientNameFp="", hinNo="", age="";
		Visit visit=null;
		if(patientList.size()>0){
		visit=patientList.get(0);
		patientNameFp=visit.getHin().getPFirstName();
		age=visit.getHin().getAge();
		}
		
		String gestationalAgeDays = ""; String gestationalAgeWeeks = "";
		OpdAntenatalCard op=null,op1;
		int antCardId=0;
		List<OpdAntenatalCard> opdAntenatalCardList1= new ArrayList<OpdAntenatalCard>();
			if(map.get("opdAntenatalCardList1") != null){
				opdAntenatalCardList1=(List<OpdAntenatalCard>)map.get("opdAntenatalCardList1");
			}
		
			 if(opdAntenatalCardList1.size()>0){

				op=opdAntenatalCardList1.get(opdAntenatalCardList1.size()-1); 
					op1=opdAntenatalCardList1.get(0);
					antCardId=op.getId();

			 for(OpdAntenatalCard opd:opdAntenatalCardList1){
				 
					if(opd.getGestationalAgeWeeks() != null){
						gestationalAgeWeeks = opd.getGestationalAgeWeeks();
						out.println("gestationalAgeWeeks"+gestationalAgeWeeks);
					}
					if(opd.getGestationalAgeDays() != null){
						gestationalAgeDays = opd.getGestationalAgeDays();
					out.println("gestationalAgeDays"+gestationalAgeDays);
					}
				 }
			 }
				%> 
		   
</script>
 
<form method="post" name="familyPlanningGynecology">
<input id="familyPlanGynecologyFlag" name="familyPlanGynecologyFlag" tabindex="1"	value="FamilyPlanningGynecology" type="hidden" /> <input
		type="hidden" name="templateName" value="Family Planning" />
	<div class="clear"></div>
	<div class="paddingTop5"></div>
	
	<div class="titleBg"><h2>Family Planning</h2></div>
	
	<div class="Block">		
			<h4>RMP Opinion Form</h4>
			<div class="clear"></div>			
			<label style="background:none; box-shadow:none;margin-left:167px;">Referral</label>
			<label style="background: none; box-shadow: none; margin-left:197px;">MTP</label>
			<div class="clear"></div>
			<label>Medical Practioner</label>
			<select name="medicalPractionerReferral" id="medicalPractionerReferral" 
			validate=" " onChange="">
			<option value="0">Select</option><%for(MasEmployee masEmployee : doctorList){%>
			<option value="<%=masEmployee.getEmployeeName()%>"><%=masEmployee.getEmployeeName()%></option>
			<% }%></select>  
			
			  <label>Medical Practioner</label>
			<select name="medicalPractionerMtp" id="medicalPractionerMtp" 
			validate="" onChange="">
			<option value="0">Select</option><%for(MasEmployee masEmployee : doctorList){%>
			<option value="<%=masEmployee.getEmployeeName()%>"><%=masEmployee.getEmployeeName()%></option>
			<% }%></select>    
			
			<div class="clear"></div>
			<div class="paddingTop5"></div>
		 
			<label class="heightAuto">Address for Medical Practioner</label> 
			<textarea type="text" id="" name="addressForMedPractMtp" maxlength="500" validate="" class="textareaMediua"></textarea>
			<label	class="heightAuto">Address for Medical Practioner</label> 
			<textarea	type="text" id="" name="addressForMedPractRef" maxlength="500" validate="" class="textareaMediua"></textarea>
			
			<div class="clear"></div>
			<div class="paddingTop5"></div>			
			
			<label>Patient Name</label> <input type="text" id="" name="patientNameFp" value="<%=patientNameFp %>" readonly="readonly" maxlength="60" validate=""> 
			<label class="auto">Age</label> 
			<input	type="text" id="" name="age"  value="<%=age%>" maxlength="3" validate="" onPaste="return false" readonly="readonly" class="medium"> 
			<!-- <label class="smallAuto">Years</label> -->
		 
			<label class="auto">Gestation Age(in weeks)</label>
			<input type="text" id=""name="gestationAge" onkeypress="javascript:return isNumber(event)"   onPaste="return false" maxlength="15" validate="" class="medium"> 
			<label class="auto">Weeks</label>
			<input type="text" id="s" name="gestationalAgeDays" maxlength="500" validate="" onkeypress="javascript:return isNumber(event)" maxlength="15" onPaste="return false" class="medium">
			<label class="smallAuto">Days</label>
			
			<label class="auto">Gender</label>
		    <select id="genderId" name="gender" style="width:140px;">
			<option value="0">Select</option>
			<option value="Male">Male</option>
			<option value="Female">Female</option>
			<option value="Ambiguous Genitalia">Ambiguous Genitalia</option>
		 </select>
		 
           <div class="clear"></div>
			<div class="paddingTop5"></div>
 			
			<label class="auto">Reason for family planning:</label> <select	id="resonForFamilyPlanning" name="resonForFamilyPlanning" style="width:880px;">
			<option value="0">Select</option>
			<option value="in order to save the life of the pregnant women.">in order to save the life of the pregnant women.</option>
			<option value="in order to prevent grave injury to the physical and mental health of the pregnant women.">in order to prevent grave injury to the physical and mental health of the pregnant women.</option>
			<option value="in view of the substantial risk that if the child was born it would suffer from such physical or mental abnormalities </br> as to be seriously handicapped.">in view of the substantial risk that if the child was born it would suffer from such physical or mental abnormalities </br> as to be seriously handicapped.</option>
			<option value="as the pregnancy is alleged by pregnant women to have been caused by rape.">as the pregnancy is alleged by pregnant	women to have been caused by rape.</option>
			<option value="as the pregnancy has occured as a result	of failure of any contraceptive device or methods used by married women or her husband for the purpose of limiting the number of children">as the pregnancy has occured as a result	of failure of any contraceptive device or methods used by married women or her husband for the purpose of limiting the number of children</option>
		</select>
		
		<div class="clear"></div>
		<div class="paddingTop5"></div>
	
	<label>Type of termination Used:</label>
<select id="typeOfTerminationUsed" name="typeOfTerminationUsed" validate="" onchange="displayWeaknessValue1(this.value)">
<option value="" >Select</option>
<option value="MVA(Manual Vaccum Aspiration)">MVA(Manual Vaccum Aspiration)</option>
<option value="EVA(Electrical Vaccum Aspiration)">EVA(Electrical Vaccum Aspiration)</option>
<option value="MMA(Medical Methods of abortion)">MMA(Medical Methods of abortion)</option>
<option value="D and C(Duration and Curettage)">D and C(Duration and Curettage)</option>
<option value="Yes">Others</option> 
</select>
<textarea type="text" id="othersValue" name="othersValue" maxlength="500" validate="" class="textareaMediua" style="width:height:55px; "display:none""></textarea>  
<div class="clear"></div> 
 
</div>
</form>
