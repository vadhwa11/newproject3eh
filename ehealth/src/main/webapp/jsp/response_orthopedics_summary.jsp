<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOrthopedicSpeciality"%>

<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<OpdOrthopedicSpeciality> opdOrthopedicSpeciality = new ArrayList<OpdOrthopedicSpeciality>();
		
if (map.get("opdOrthopedicSpeciality") != null) {
	opdOrthopedicSpeciality = (List<OpdOrthopedicSpeciality>) map.get("opdOrthopedicSpeciality");			
}
%>

<div class="Block">
			<h6>Speciality Clinical Summary</h6>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			<div class="summaryDivMain">
			<label>Mode of Injury</label>
			<%
					String modeOfInjury = "";
					String presentingComplaints = "";
					String localExamination = "";
					String historySpeciality = "";
					String historySpecialityShow = "";
				if(opdOrthopedicSpeciality.size()>0){
				for(OpdOrthopedicSpeciality psh :opdOrthopedicSpeciality){
					
					Date opdDate = null;
					String opdSDate = "";
					if(psh.getOpdPatientDetails() != null) {
						if(psh.getOpdPatientDetails().getOpdDate() != null) {
							opdDate = (Date)psh.getOpdPatientDetails().getOpdDate();
							opdSDate = HMSUtil.convertDateToStringTypeDateOnly(opdDate);
						}
					}
					if(psh.getNatureOfInjuryValue() != null && !psh.getNatureOfInjuryValue().equals("")) {
						if(!opdSDate.equals(""))
							modeOfInjury += opdSDate+"<div class='clear'></div>";
						modeOfInjury += (String)psh.getNatureOfInjuryValue()+"<div class='clear'></div>";
						if(psh.getNatureOfInjuryOthers() != null && !psh.getNatureOfInjuryOthers().equals("")) {
							modeOfInjury += "Others--"+(String)psh.getNatureOfInjuryOthers()+"<div class='clear'></div>";
						}
					}
					if(!opdSDate.equals(""))
						presentingComplaints += opdSDate+"<div class='clear'></div>";
					if(psh.getNeck() != null && !psh.getNeck().equals("")) {
						presentingComplaints += "Neck--"+(String)psh.getNeck()+"<div class='clear'></div>";
					}
					if(psh.getMidBack() != null && !psh.getMidBack().equals("")) {
						presentingComplaints += "Midback--"+(String)psh.getMidBack()+"<div class='clear'></div>";
					}
					if(psh.getGirdle() != null && !psh.getGirdle().equals("")) {
						presentingComplaints += "Girdle--"+(String)psh.getGirdle()+"<div class='clear'></div>";
					}
					if(psh.getLowBack() != null && !psh.getLowBack().equals("")) {
						presentingComplaints += "Lowback--"+(String)psh.getLowBack()+"<div class='clear'></div>";
					}
					if(psh.getHip() != null && !psh.getHip().equals("")) {
						presentingComplaints += "Hip--"+(String)psh.getHip();
						if(psh.getHipValue() != null && !psh.getHipValue().equals(""))
							presentingComplaints += "  "+(String)psh.getHipValue();
						if(psh.getHipValueAnother() != null && !psh.getHipValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getHipValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getSacroiliac() != null && !psh.getSacroiliac().equals("")) {
						presentingComplaints += "Sacroiliac--"+(String)psh.getSacroiliac();
						if(psh.getSacroiliacValue() != null && !psh.getSacroiliacValue().equals(""))
							presentingComplaints += "  "+(String)psh.getSacroiliacValue();
						if(psh.getSacroiliacValueAnother() != null && !psh.getSacroiliacValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getSacroiliacValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getPelvis() != null && !psh.getPelvis().equals("")) {
						presentingComplaints += "Pelvis--"+(String)psh.getPelvis();
						if(psh.getPelvisValue() != null && !psh.getPelvisValue().equals(""))
							presentingComplaints += "  "+(String)psh.getPelvisValue();
						if(psh.getPelvisValueAnother() != null && !psh.getPelvisValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getPelvisValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getThigh() != null && !psh.getThigh().equals("")) {
						presentingComplaints += "Thigh--"+(String)psh.getThigh();
						if(psh.getThighValue() != null && !psh.getThighValue().equals(""))
							presentingComplaints += "  "+(String)psh.getThighValue();
						if(psh.getThighValueAnother() != null && !psh.getThighValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getThighValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getKnee() != null && !psh.getKnee().equals("")) {
						presentingComplaints += "Knee--"+(String)psh.getKnee();
						if(psh.getKneeValue() != null && !psh.getKneeValue().equals(""))
							presentingComplaints += "  "+(String)psh.getKneeValue();
						if(psh.getKneeValueAnother() != null && !psh.getKneeValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getKneeValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getLeg() != null && !psh.getLeg().equals("")) {
						presentingComplaints += "Leg--"+(String)psh.getLeg();
						if(psh.getLegValue() != null && !psh.getLegValue().equals(""))
							presentingComplaints += "  "+(String)psh.getLegValue();
						if(psh.getLegValueAnother() != null && !psh.getLegValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getLegValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getAnkle() != null && !psh.getAnkle().equals("")) {
						presentingComplaints += "Ankle--"+(String)psh.getAnkle();
						if(psh.getAnkleValue() != null && !psh.getAnkleValue().equals(""))
							presentingComplaints += "  "+(String)psh.getAnkleValue();
						if(psh.getAnkleValueAnother() != null && !psh.getAnkleValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getAnkleValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getFoot() != null && !psh.getFoot().equals("")) {
						presentingComplaints += "Foot--"+(String)psh.getFoot();
						if(psh.getFootValue() != null && !psh.getFootValue().equals(""))
							presentingComplaints += "  "+(String)psh.getFootValue();
						if(psh.getFootValueAnother() != null && !psh.getFootValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getFootValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getShoulder() != null && !psh.getShoulder().equals("")) {
						presentingComplaints += "Shoulder--"+(String)psh.getShoulder();
						if(psh.getShoulderValue() != null && !psh.getShoulderValue().equals(""))
							presentingComplaints += "  "+(String)psh.getShoulderValue();
						if(psh.getShoulderValueAnother() != null && !psh.getShoulderValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getShoulderValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getInterscapular() != null && !psh.getInterscapular().equals("")) {
						presentingComplaints += "Interscapular--"+(String)psh.getInterscapular();
						if(psh.getInterscapularValue() != null && !psh.getInterscapularValue().equals(""))
							presentingComplaints += "  "+(String)psh.getInterscapularValue();
						if(psh.getInterscapularValueAnother() != null && !psh.getInterscapularValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getInterscapularValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getArm() != null && !psh.getArm().equals("")) {
						presentingComplaints += "Arm--"+(String)psh.getArm();
						if(psh.getArmValue() != null && !psh.getArmValue().equals(""))
							presentingComplaints += "  "+(String)psh.getArmValue();
						if(psh.getArmValueAnother() != null && !psh.getArmValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getArmValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getElbow() != null && !psh.getElbow().equals("")) {
						presentingComplaints += "Elbow--"+(String)psh.getElbow();
						if(psh.getElbowValue() != null && !psh.getElbowValue().equals(""))
							presentingComplaints += "  "+(String)psh.getElbowValue();
						if(psh.getElbowValueAnother() != null && !psh.getElbowValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getElbowValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getForearm() != null && !psh.getForearm().equals("")) {
						presentingComplaints += "Forearm--"+(String)psh.getForearm();
						if(psh.getForearmValue() != null && !psh.getForearmValue().equals(""))
							presentingComplaints += "  "+(String)psh.getForearmValue();
						if(psh.getForearmValueAnother() != null && !psh.getForearmValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getForearmValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getWrist() != null && !psh.getWrist().equals("")) {
						presentingComplaints += "Wrist--"+(String)psh.getWrist();
						if(psh.getWristValue() != null && !psh.getWristValue().equals(""))
							presentingComplaints += "  "+(String)psh.getWristValue();
						if(psh.getWristValueAnother() != null && !psh.getWristValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getWristValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getHand() != null && !psh.getHand().equals("")) {
						presentingComplaints += "Hand--"+(String)psh.getHand();
						if(psh.getHandValue() != null && !psh.getHandValue().equals(""))
							presentingComplaints += "  "+(String)psh.getHandValue();
						if(psh.getHandValueAnother() != null && !psh.getHandValueAnother().equals(""))
							presentingComplaints += "  "+(String)psh.getHandValueAnother();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getLimb() != null && !psh.getLimb().equals("")) {
						presentingComplaints += "Upper Limb--"+(String)psh.getLimb();
						if(psh.getLimbValue() != null && !psh.getLimbValue().equals(""))
							presentingComplaints += "  "+(String)psh.getLimbValue();
						if(psh.getLimbLength() != null && psh.getLimbLength() != 0)
							presentingComplaints += "  Length  "+(Integer)psh.getLimbLength();
						if(psh.getDiscrepancy() != null && !psh.getDiscrepancy().equals(""))
							presentingComplaints += "  Discrepancy  "+(String)psh.getDiscrepancy();
						if(psh.getAnyOther() != null && !psh.getAnyOther().equals(""))
							presentingComplaints += "  Any Other  "+(String)psh.getAnyOther();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getLowerLimb() != null && !psh.getLowerLimb().equals("")) {
						presentingComplaints += "Lower Limb--"+(String)psh.getLowerLimb();
						if(psh.getLowerLimbValue() != null && !psh.getLowerLimbValue().equals(""))
							presentingComplaints += "  "+(String)psh.getLowerLimbValue();
						if(psh.getLowerLimbLength() != null && psh.getLowerLimbLength() != 0)
							presentingComplaints += "  Length  "+(Integer)psh.getLowerLimbLength();
						if(psh.getLowerDiscrepancy() != null && !psh.getLowerDiscrepancy().equals(""))
							presentingComplaints += "  Discrepancy  "+(String)psh.getLowerDiscrepancy();
						if(psh.getLowerLimbAnyOther() != null && !psh.getLowerLimbAnyOther().equals(""))
							presentingComplaints += "  Any Other  "+(String)psh.getLowerLimbAnyOther();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getNameOfDiscomfort() != null && !psh.getNameOfDiscomfort().equals("")) {
						presentingComplaints += "Nature of Discomfort--"+(String)psh.getNameOfDiscomfort();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getPain() != null && !psh.getPain().equals("")) {
						presentingComplaints += "Pain--"+(String)psh.getPain();
						if(psh.getSite() != null && !psh.getSite().equals(""))
							presentingComplaints += "  Site  "+(String)psh.getSite();
						if(psh.getNatureOfPain() != null && !psh.getNatureOfPain().equals(""))
							presentingComplaints += "  Nature of Pain  "+(String)psh.getNatureOfPain() + "<div class='clear'></div>";
						if(psh.getRadition() != null && !psh.getRadition().equals(""))
							presentingComplaints += "  Radiation  "+(String)psh.getRadition();
						if(psh.getExacerbatingFactor() != null && !psh.getExacerbatingFactor().equals(""))
							presentingComplaints += "  Exacerbating Factor  "+(String)psh.getExacerbatingFactor();
						if(psh.getRelievingFactor() != null && !psh.getRelievingFactor().equals(""))
							presentingComplaints += "  Relieving Factor  "+(String)psh.getRelievingFactor();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getStiffness() != null && !psh.getStiffness().equals("")) {
						presentingComplaints += "Stiffness--"+(String)psh.getStiffness();
						if(psh.getStiffnessValue() != null && !psh.getStiffnessValue().equals(""))
							presentingComplaints += "  "+(String)psh.getStiffnessValue();
						if(psh.getMorningStiffness() != null && !psh.getMorningStiffness().equals(""))
							presentingComplaints += "  Morning Stiffness  "+(String)psh.getMorningStiffness();
						if(psh.getMorningStiffnessValue() != null && !psh.getMorningStiffnessValue().equals(""))
							presentingComplaints += "  "+(String)psh.getMorningStiffnessValue();
						if(psh.getWeakness() != null && !psh.getWeakness().equals(""))
							presentingComplaints += "  Weakness  "+(String)psh.getWeakness();
						if(psh.getWeaknessValue() != null && !psh.getWeaknessValue().equals(""))
							presentingComplaints += "  "+(String)psh.getWeaknessValue() + "<div class='clear'></div>";
						if(psh.getInabilityToUseALimb() != null && !psh.getInabilityToUseALimb().equals(""))
							presentingComplaints += "  Inability to use a Limb  "+(String)psh.getInabilityToUseALimb();
						if(psh.getInabilityToUseLimbValue() != null && !psh.getInabilityToUseLimbValue().equals(""))
							presentingComplaints += "  "+(String)psh.getInabilityToUseLimbValue();
						if(psh.getDisabilityInUsingALimb() != null && !psh.getDisabilityInUsingALimb().equals(""))
							presentingComplaints += "  Disability in using a Limb  "+(String)psh.getDisabilityInUsingALimb();
						if(psh.getDisabilityInUsingALimbValue() != null && !psh.getDisabilityInUsingALimbValue().equals(""))
							presentingComplaints += "  "+(String)psh.getDisabilityInUsingALimbValue();
						if(psh.getSwelling() != null && !psh.getSwelling().equals(""))
							presentingComplaints += "  Swelling  "+(String)psh.getSwelling();
						if(psh.getSwellingValue() != null && !psh.getSwellingValue().equals(""))
							presentingComplaints += "  "+(String)psh.getSwellingValue();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getConstitutionalSymptoms() != null && !psh.getConstitutionalSymptoms().equals("")) {
						presentingComplaints += "Constitutional Symptoms--"+(String)psh.getConstitutionalSymptoms();
						presentingComplaints += "<div class='clear'></div>";
					}
					if(psh.getSwelling2() != null && !psh.getSwelling2().equals("")) {
						if(!opdSDate.equals(""))
							localExamination += opdSDate+"<div class='clear'></div>";
						localExamination += "Swelling--"+(String)psh.getSwelling2();
						if(psh.getSite2() != null && !psh.getSite2().equals(""))
							localExamination += "  Site  "+(String)psh.getSite2();
						if(psh.getNatureOfGrowth() != null && !psh.getNatureOfGrowth().equals(""))
							localExamination += "  Nature of Growth  "+(String)psh.getNatureOfGrowth() + "<div class='clear'></div>";
						if(psh.getSize() != null && !psh.getSize().equals(""))
							localExamination += "  Size  "+(String)psh.getSize();
						if(psh.getShape() != null && !psh.getShape().equals(""))
							localExamination += "  Surface  "+(String)psh.getShape();
						if(psh.getShape1() != null && !psh.getShape1().equals(""))
							localExamination += "  Shape  "+(String)psh.getShape1() + "<div class='clear'></div>";
						if(psh.getConsistency() != null && !psh.getConsistency().equals(""))
							localExamination += "  Consistency  "+(String)psh.getConsistency();
						if(psh.getPlaneOfSwelling() != null && !psh.getPlaneOfSwelling().equals(""))
						localExamination += "  Plane of the Swelling  "+(String)psh.getPlaneOfSwelling();
						localExamination += "<div class='clear'></div>";
					}
					if(psh.getOccupationalHistory() != null && !psh.getOccupationalHistory().equals("")) {
						historySpeciality += "Occupational History--"+(String)psh.getOccupationalHistory()+"<div class='clear'></div>";
					}
					if(psh.getTreatmentHistory() != null && !psh.getTreatmentHistory().equals("")) {
						historySpeciality += "Treatment History--"+(String)psh.getTreatmentHistory()+"<div class='clear'></div>";
					}
					if(psh.getDevelopmentHistory() != null && !psh.getDevelopmentHistory().equals("")) {
						historySpeciality += "Developmental History--"+(String)psh.getDevelopmentHistory()+"<div class='clear'></div>";
					}
					if(psh.getDevelopmentMilestones() != null && !psh.getDevelopmentMilestones().equals("")) {
						historySpeciality += "Developmental Milestones--"+(String)psh.getDevelopmentMilestones()+"<div class='clear'></div>";
					}
					if(psh.getParinatalAndAntenatalHistory() != null && !psh.getParinatalAndAntenatalHistory().equals("")) {
						historySpeciality += "Perinatal & Antenatal History--"+(String)psh.getParinatalAndAntenatalHistory()+"<div class='clear'></div>";
					}
					if(!historySpeciality.equals("")) {
						if(!opdSDate.equals(""))
							historySpecialityShow += opdSDate+"<div class='clear'></div>";
						historySpecialityShow += historySpeciality;
					}
				}}
			  %>
			<div class="summaryDetails"><p><%=modeOfInjury %></p></div>
			
			</div>
			
			<div class="summaryDivMain">
			<label>Presenting Complaints</label>
			<div class="summaryDetails"><p><%=presentingComplaints %></p></div>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			
			<div class="summaryDivMain">
			<label>Local Examination</label>
			<div class="summaryDetails"><p><%=localExamination %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>History</label>
			<div class="summaryDetails"><p><%=historySpecialityShow %></p></div>
			</div>
			<div class="clear"></div>
			</div>

 
 <div class="clear"></div>