<%@page import="jkt.hms.masters.business.MortuaryRegisterDetails"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	/* List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
	List<MasEmployee>employeeList = new ArrayList<MasEmployee>(); */
	List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	 
	if(map.get("mortuaryDetails") != null){
	mortuaryDetails =(List)map.get("mortuaryDetails");
     }
	
	/* if(map.get("doctorList") != null){
		doctorList =(List)map.get("doctorList");
	}
	if(map.get("employeeList") != null){
		employeeList =(List)map.get("employeeList");
	} */
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	/* int empId  = 0;
	String empName = "";
	if(map.get("empId") != null){
		empId = (Integer)map.get("empId");
	}
	if(map.get("empName") != null){
		empName = (String)map.get("empName");
	} */
%>	
<form name="postMortemDetailNotes" action="" method="post">
<div class="titleBg">
<h2>POST MORTEM DETAILED NOTES</h2>
</div>
<div class="Block">
<div class="titleBg">
<h4>Search</h4>
</div>
<label><span>*</span> UHID</label> 
<input type="text"  name="hinNo" id="hinNo" value="<%= (mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo():""%>">
</div>
<div class="Block">
<label>Name</label>
<input type="text" name="deceasedName" id="deceasedName" value="<%= (mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName():""%>">
<label class="small-medium">Gender</label>
<input type="text"  name="gender" id="gender" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName():""%>">

<label class="small-medium">Age</label>
<input type="text" name="ageId" id="age" class="dateTextSmall" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge():""%>">
<!-- <input type="hidden"  name="mlcId" id="mlcId" value="">
<input type="hidden"  name="hinId" id="hinId" value=""> -->
<input type="hidden"  name="mortuaryRegdDetailId" id="mortuaryRegdDetailId" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getId()!=null)?mortuaryDetails.get(0).getId():""%>">

<div class="clear"></div>
<label>Sent By</label>
<input type="text" name="sentBy" id="sentBy" value="" maxlength="128">

<label class="small-medium">Crime No</label>
<input type="text" name="crimeNoId" id="crimeNoId" class="dateTextSmall" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getCrimeNo()!=null)?mortuaryDetails.get(0).getCrimeNo():""%>">

<label class="small-medium">Crime Date</label>
<input type="text" id="crimeDate" name="crimeDate" class="dateTextSmall" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getCrimeDate()!=null)?mortuaryDetails.get(0).getCrimeDate():""%>" readonly="readonly">

<div class="clear"></div>
<label>H.C. / P.C. No</label>
<input type="text" name="hcPcNo" id="hcPcNo" value="" maxlength="128">

<label>Body Identified By</label>
<input type="text" name="bodyIdentifiedBy" id="bodyIdentifiedBy" value="" maxlength="256">

<div class="clear"></div>
<label>First Seen Time</label>
<input type="text" name="firstSeenTime" id="firstSeenTime" class="dateTextSmall" value="" maxlength="5" onkeyup="mask(this.value,this,'2',':');">
<label class="small-medium">Date</label>
<input type="text" id="firstSeenDate" name="firstSeenDate" class="dateTextSmall" value="<%=currentDate%>" readonly="readonly">
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.postMortemDetailNotes.firstSeenDate,event);" />

<label class="heightAuto">Postmortem Examination Commenced Time</label>
<input type="text" name="commencedTime" id="commencedTime" class="dateTextSmall" value="" maxlength="5"  onkeyup="mask(this.value,this,'2',':');">
<label class="small-medium">Date</label>
<input type="text" id="commencedDate" name="commencedDate" class="dateTextSmall" value="" readonly="readonly">
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.postMortemDetailNotes.commencedDate,event);" />

<div class="clear"></div>
<label class="heightAuto">Post Mortem Examination Conducted By</label>
<input type="text" name="conductedBy" id="conductedBy" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getDoctor()!=null && mortuaryDetails.get(0).getDoctor().getEmployeeName()!=null)?mortuaryDetails.get(0).getDoctor().getEmployeeName():""%>" readonly="readonly"">

<label>Assisted By1</label>
<input type="text" name="assistedBy1" id="assistedBy1" value="<%= (mortuaryDetails.size()>0 && mortuaryDetails.get(0).getAssistedBy1()!=null && mortuaryDetails.get(0).getAssistedBy1().getEmployeeName()!=null)?mortuaryDetails.get(0).getAssistedBy1().getEmployeeName():""%>" readonly="readonly">

<label>Assisted By2</label>
<input type="text" name="assistedBy2" id="assistedBy2" value="<%= (mortuaryDetails.size()>0 &&  mortuaryDetails.get(0).getAssistedBy2()!=null && mortuaryDetails.get(0).getAssistedBy2().getEmployeeName()!=null)?mortuaryDetails.get(0).getAssistedBy2().getEmployeeName():""%>" readonly="readonly">
    
<div class="clear"></div>
<label class="heightAuto">Notes on Scene Examination</label>
<textarea name="sceneExamination" id="sceneExamination" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>
<label class="heightAuto">Clothes, Weapons Other Articles Sent with the Body</label>
<textarea name="otherArticles" id="otherArticles" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>
    
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="titleBg">
<h2>A. GENERAL</h2>
</div> 
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Body</label>
<select name="generalBody" id="generalBody" tabindex="1" validate="District,metachar,no" maxlength="128">
				<option value="0">Select</option>	
				<option value="1">Entire and Intact</option>
				<option value="2">Mutilated and in pieces</option>
				</select>   
 <!-- <label class="small-medium">Gender</label>
 <input type="text"  name="gender" id="gender" value="">
  -->
<label class="small-medium">Height</label><input type="text" name="height" id="height" class="dateTextSmall" value="">
<label class="small-medium">Weight</label><input type="text" name="weight" id="weight" class="dateTextSmall" value="">

<div class="clear"></div>
<label>Build</label>
<select name="build" id="build" tabindex="1" validate="District,metachar,no" >
				<option value="">Select</option>	
				<option value="Thin">Thin</option>
				<option value="Moderate">Moderate</option>
				<option value="Well">Well</option>
				</select>				
<label>Nourishment</label>
<select name="nourishment" id="nourishment" tabindex="1" validate="District,metachar,no">
				<option value="0">Select</option>	
				<option value="Poor">Poor</option>
				<option value="Moderate">Moderate</option>
				<option value="Well">Well</option>
				<option value="Obese">Obese</option>
				</select> 
<label>Smell</label><input type="text" name="smell" id="smell" value="128" >

<div class="clear"></div>
<label>Facial Appearance</label>
<select name="facialApp" id="facialApp" tabindex="1" validate="District,metachar,no">
				<option value="0">Select</option>	
				<option value="1">Pale</option>
				<option value="2">Normal</option>
				<option value="3">Livid</option>
				</select>				
<label>Eyes</label>
<select name="eyes" id="eyes" tabindex="1" validate="District,metachar,no">
				<option value="">Select</option>	
				<option value="Closed">Closed</option>
				<option value="Half Open">Half Open</option>
				<option value="Open">Open</option>
				</select>
<label>Corneae</label>
<select name="corneaeId" id="corneaeId" tabindex="1" validate="District,metachar,no">
				<option value="0">Select</option>	
				<option value="Clear">Clear</option>
				<option value="Hazy">Hazy</option>
				<option value="Opaque">Opaque</option>
				</select>  

<div class="clear"></div>
<label>Pupils</label>
<select name="pupils" id="pupils" tabindex="1" validate="District,metachar,no">
				<option value="">Select</option>	
				<option value="Constricted">Constricted</option>
				<option value="Dialated">Dialated</option>
				<option value="Regular">Regular</option>
				<option value="Irregular">Irregular</option>
				</select>				
<label>Conjunctivae</label>
<select name="conjunctivae" id="conjunctivae" tabindex="1" validate="District,metachar,no">
				<option value="">Select</option>	
				<option value="Pale">Pale</option>
				<option value="Normal">Normal</option>
				<option value="Congested">Congested</option>				
				</select> 
<label>Nostrils</label><input type="text" name="nostrils" id="nostrils" value="" maxlength="256">

<div class="clear"></div>
<label>Mouth</label>
<input type="text" name="mouth" id="mouth" value="" maxlength="256">
<label>Tongue</label>
<input type="text" name="tongue" id="tongue" value="" maxlength="256"> 
<label>Lips</label>
<select name="lips" id="lips" tabindex="1" validate="District,metachar,no">
				<option value="">Select</option>	
				<option value="Pale">Pale</option>
				<option value="Blue">Blue</option>
				</select>
				
<div class="clear"></div>
<label>Circum Oral Regions</label><input type="text" name="circumOrReg" id="circumOrReg" value=""   maxlength="256">
<label>Oral Cavity</label><input type="text" name="oralCavity" id="oralCavity" value="" maxlength="256">
<label>Inner Aspects of Lips</label><input type="text" name="aspectsOfLips" id="aspectsOfLips" value="" maxlength="512">

<div class="clear"></div>
<label>Ears</label><input type="text" name="ear" id="ear" value="" maxlength="256">
<label>Urethral Orifice</label><input type="text" name="urethralOri" id="urethralOri" value="" maxlength="256">
<label>Anus</label><input type="text" name="anus" id="anus" value="" maxlength="512">

<div class="clear"></div>
<label>Rigor Mortis</label><input type="text" name="rigorMortis" id="rigorMortis" value="" maxlength="512">
<label>Postmortem Staining</label><input type="text" name="stainning" id="stainning" value="" maxlength="512">
<label>Dried Salivary Dribble Mark</label><input type="text" name="driedSaliMark" id="driedSaliMark" value="" maxlength="512">

<div class="clear"></div>
<label>Smearings on the Body</label><input type="text" name="smearingsBody" id="smearingsBody" value="" maxlength="512">
<label style="font-size:11px;">Postmortem Ant Bite Marks</label>
<input type="text" name="postmtBiteMarks" id="postmtBiteMarks" value="" maxlength="512">

<div class="clear"></div>
<label class="heightAuto">Postmortem aquatic or other animal bite marks</label>
<textarea name="postmtOthBitMarks" id="postmtOthBitMarks" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>
<label class="heightAuto">Postmortem burns due to exposure to sunlight</label>
<textarea name="burnsDueToSunlight" id="burnsDueToSunlight" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>

<div class="clear"></div>
<label>Decomposition Changes</label>
<textarea name="decompositionChanges" id="decompositionChanges" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>
<label>Any other Findings</label>
<textarea name="anyOthFindings" id="anyOthFindings"class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>

<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="heightAuto">Body Kept in Cold Room Time</label>
<input type="text" name="bodyKeptTime" id="bodyKeptTime" class="dateTextSmall" value=""  >
<label class="small-medium">Date</label>
<input type="text" name="bodyKeptDate" id="bodyKeptDate" class="dateTextSmall" value="" readonly="readonly">
<div class="clear"></div>
<div class="titleBg">
<h2>B. INJURIES (Ante-Mortem)</h2>
</div> 
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>External</label>
<textarea name="external" id="external" class="comorBiditylarge" cols="0" rows="0" maxlength="2048" ></textarea>
<label>Internal</label>
<textarea name="internal" id="internal" class="comorBiditylarge" cols="0" rows="0" maxlength="2048" ></textarea>
    
<div class="clear"></div>
<div class="paddingTop5"></div>
  
<div class="titleBg">
<h2>C. INTERNAL EXAMINATION</h2>
</div>   
<div class="clear"></div>
<h4>(I) Head and Neck</h4>
<div class="clear"></div>
<label>Scalp</label><input type="text" name="scalp" id="scalp" value="" maxlength="512">
<label>Skull</label><input type="text" name="skull" id="skull" value="" maxlength="512">
<label class="heightAuto">Meninges & Cerebral Vessels</label>
<input type="text" name="meningesCerVess" id="meningesCerVess" value="" maxlength="512">

<div class="clear"></div>
<label>Brain</label><input type="text" name="brain" id="brain" value="" maxlength="512">
<label class="heightAuto">Subcutaneous Tissues & Muscles of Neck</label>
<input type="text" name="musclesOfNeck" id="musclesOfNeck" value="" maxlength="512">
<label>Mouth and Pharynx</label><input type="text" name="mouthPyarynx" id="mouthPyarynx" value="" maxlength="512">

<div class="clear"></div>
<label>Cartilages of Neck</label><input type="text" name="cartilagesNeck" id="cartilagesNeck" value="" maxlength="512">
<label>Hyoid Bone</label><input type="text" name="hyoidBone" id="hyoidBone" value="" maxlength="512">

<div class="clear"></div>
<h4>(II) Chest</h4>
<div class="clear"></div>
<label>Ribs and Chest Wall</label><input type="text" name="ribsChestWall" id="ribsChestWall" value="" maxlength="512">
<label>Pleural Cavities</label><input type="text" name="pleuralCaviti" id="pleuralCaviti" value="" maxlength="512">
<label>Diaphragm</label><input type="text" name="diaphram" id="diaphram" value="" maxlength="512">

<div class="clear"></div>
<label>Mediastinum and Thymus</label><input type="text" name="mediastinumThymus" id="mediastinumThymus" value="" maxlength="512">
<label>Oesophagus</label><input type="text" name="oesophagus" id="oesophagus" value="" maxlength="512">
<label>Trachea and Bronchi</label><input type="text" name="tracheaBronchi" id="tracheaBronchi" value="" maxlength="512">

<div class="clear"></div>
<label>Lungs Right</label><input type="text" name="lungsRight" id="lungsRight" value="" maxlength="512">
<label>Lungs Left</label><input type="text" name="lungsLeft" id="lungsLeft" value="" maxlength="512">
<label>Pericardial Sac</label><input type="text" name="pericaldialSec" id="pericaldialSec" value="" maxlength="512">

<div class="clear"></div>
<label>Heart</label>
<select name="heart" id="heart" tabindex="1" validate="District,metachar,no">
				<option value="">Select</option>	
				<option value="General">General</option>
				<option value="Walls">Walls</option>
				<option value="Valves">Valves</option>
				<option value="Chambers">Chambers</option>				
				</select>
<label>Coronaries</label><input type="text" name="coronaries" id="coronaries" value="" maxlength="512">
<label>Aorta</label><input type="text" name="aorta" id="aorta" value="" maxlength="512">

<div class="clear"></div>
<h4>(III) Abdomen</h4>
<div class="clear"></div>
<label>Abdominal Wall</label><input type="text" name="abdominalWall" id="abdominalWall" value="" maxlength="512">
<label>Peritoneal Cavity</label><input type="text" name="peritonealCavity" id="peritonealCavity" value="" maxlength="512">
<label>Liver</label><input type="text" name="liver" id="liver" value="" maxlength="512">

<div class="clear"></div>
<label class="heightAuto">Gall Bladder & Billary Passages</label>
<input type="text" name="gallBillaryPass" id="gallBillaryPass" value="" maxlength="512">
<label>Spleen</label><input type="text" name="spleen" id="spleen" value="" maxlength="512">
<label>Kidneys Right</label><input type="text" name="kindeyRight" id="kindeyRight" value="" maxlength="256">

<div class="clear"></div>
<label>Kidneys Left</label><input type="text" name="kindeyLeft" id="kindeyLeft" value="" maxlength="256">
<label>Pancreas</label><input type="text" name="pancreas" id="pancreas" value="" maxlength="512">
<label>Adrenal Glands Right</label><input type="text" name="adrenalGlandRight" id="adrenalGlandRight" value="" maxlength="256">

<div class="clear"></div>
<label>Adrenal Glands Left</label><input type="text" name="adrenalGlandLeft" id="adrenalGlandLeft" value="" maxlength="256"> 
<label>Stomach & Contents</label><input type="text" name="stomachContents" id="stomachContents" value="" maxlength="512">
<label>Intestines & Mesentery</label><input type="text" name="intestimesMesentery" id="intestimesMesentery" value="" maxlength="512"> 

<div class="clear"></div>
<label>Urinary Bladder</label><input type="text" name="urinaryBladder" id="urinaryBladder" value="" maxlength="512">
<label>Genital Organs</label><input type="text" name="genitalOrgans" id="genitalOrgans" value="" maxlength="512">
<label>Spinal Column & Cord</label><input type="text" name="spinalColumn" id="spinalColumn" value="" maxlength="512">


<div class="clear"></div>
<label>Additional Observations</label>
<textarea name="additionalObservation" id="additionalObservation" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>

<div class="clear"></div>
<h4>Viscera and other Material Objects for Chemical and Other Examinations</h4>
<div class="clear"></div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow();" />
  <div class="clear"></div>
<table width="700" cellspacing="0" cellpadding="0" border="0" style="width:700px; float:left; margin:0px 0px 0px 5px" id="chemicalGrid">
<thead>
<tr>
<th>Select</th>
<th>Object</th>
<th>Chemical</th>
</tr>
</thead>
<tbody>
<%int inc = 1;
%>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo1" id="slNo1" value="y"></td>
<td><input type="text" name="object1" id="object1" value="Stomatch,small intestine and contents"></td>
<td><input type="checkbox" name="chemical1" id="chemical1" value="y"></td>
</tr>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo2" id="slNo2" value="y"></td>
<td><input type="text" name="object2" id="object2" value="Part of Liver and Kidney"></td>
<td><input type="checkbox" name="chemical2" id="chemical2" value="y"></td>
</tr>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo3" id="slNo3" value="y"></td>
<td><input type="text" name="object3" id="object3" value="Blood"></td>
<td><input type="checkbox" name="chemical4" id="chemical4" value="y"></td>
</tr>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo4" id="slNo4" value="y"></td>
<td><input type="text" name="object4" id="object4" value="Urine"></td>
<td><input type="checkbox" name="chemical4" id="chemical4" value="y"></td>
</tr>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo5" id="slNo5" value=""y></td>
<td><input type="text" name="object5" id="object5" value="Preservation For 1 and 2 saturated saline"></td>
<td><input type="checkbox" name="chemical5" id="chemical5" value="y"></td>
</tr>
<tr class="odd" style="background-color: #F5F5DC" id="2187814">
<td><input type="checkbox" name="slNo6" id="slNo6" value="y"></td>
<td><input type="text" name="object6" id="object6" value="Preservation For 3 and 4 Sodium fluoride"></td>
<td><input type="checkbox" name="chemical6" id="chemical6" value="y"></td>
</tr>
</tbody>
</table>

<input type="hidden" name="hdb" id="hdb" value="<%=6 %>" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<label class="heightAuto">Post Mortem Examination Concluded Time</label>
<input type="text" name="postmortConcludedTime" id="postmortConcludedTime" class="dateTextSmall" value="" onkeyup="mask(this.value,this,'2',':');" maxlength="5">
<label class="small-medium">Date</label>
<input type="text" name="postmortConcludedDate" id="postmortConcludedDate" value="<%=currentDate%>" class="dateTextSmall" value="" readonly="readonly">
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.postMortemDetailNotes.postmortConcludedDate,event);" />

<label class="heightAuto">Opinion as to Couse of Death</label>
<textarea name="opinionCouseDeath" id="opinionCouseDeath" class="comorBiditylarge" cols="0" rows="0" maxlength="1024" ></textarea>   
<div class="clear"></div>
<input type="button" class="buttonBig" id="Submit" name="Submit"  value="Submit" onclick="submitForm('postMortemDetailNotes','mlc?method=updatePostMortemDetailedNotes');">
<input type="reset" tabindex="1" onclick="resetCheck();" accesskey="r" class="buttonHighlight" value="Reset" id="reset" name="Reset">
<div class="clear"></div>      
</div>

<script type="text/javascript">

function getMedicoLegalDetails(val)
{
	ajaxFunctionForPostmortemDetails('postMortemDetailNotes','mlc?method=getPostmortemDetails&hinNo='+val);
		
}  
function addRow(){
	
	  var tbl = document.getElementById('chemicalGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='slNo'+iteration;
	  e0.id='slNo'+iteration;
	  //e0.size='3'
	  e0.value='y'
	  e0.className = 'radioCheck'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='object'+iteration;
	  e1.id='object'+iteration;
	  //e1.size='8'
	 cellRight2.appendChild(e1);
	  
	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'checkbox';
	  e2.name='chemical'+iteration;
	  e2.id='chemical'+iteration;
	  e2.value = 'y';
	  //e2.size='8'
	 cellRight3.appendChild(e2);	
	}
</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

