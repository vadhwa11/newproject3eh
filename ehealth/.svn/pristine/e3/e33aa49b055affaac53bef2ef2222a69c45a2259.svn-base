<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * patientDetail.jsp  
 * Purpose of the JSP -  This is for Patient Details.
 * @author  Ritu
 * @author  Deepti
 * Create Date: 09th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>

<%@page import="jkt.hms.masters.business.OpdAntenatalCardMedicalHistory"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardTrimester"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<div id="contentspace">
<%	
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		String uhid = "";
		String patientName="";
		int patientAge = 0;
		String bloodGroup = "";
		String gravida = "";
		String lmpDate = "";
		String eddDate = "";
		String gestationalAgeWeeks = "";
		String gestationalAgeDays = "";
		String surgicalHistory = "";
		String infertility = "";
		String factor = "";
		String infertilityDetail = "";
		String yearMonth = "";
		
		List<OpdAntenatalCard>antenatalCardList=new ArrayList<OpdAntenatalCard>();
		List<OpdAntenatalCardMedicalHistory>comorbidityList = new ArrayList<OpdAntenatalCardMedicalHistory>();
		List<OpdAntenatalCardTrimester>trimsterList = new ArrayList<OpdAntenatalCardTrimester>();
		if(map.get("antenatalCardList") != null){
			antenatalCardList=(List)map.get("antenatalCardList");
		}
		if(map.get("comorbidityList") != null){
			comorbidityList=(List)map.get("comorbidityList");
		}
		if(antenatalCardList.size()>0){
			for(OpdAntenatalCard antenatalCard : antenatalCardList){
				
				if(antenatalCard.getHin() != null){
					uhid =antenatalCard.getHin() .getHinNo(); 
				}
				
				if(antenatalCard.getHin()!=null){
					patientName=antenatalCard.getHin().getPFirstName();
				}
				if(antenatalCard.getHin() != null && antenatalCard.getHin().getPMiddleName()!=null){
					patientName += " "+antenatalCard.getHin().getPMiddleName();
				}
				if(antenatalCard.getHin() != null && antenatalCard.getHin().getPLastName()!=null){
					patientName += " "+antenatalCard.getHin().getPLastName();
				}
				
				if(antenatalCard.getHin() != null && antenatalCard.getHin().getBloodGroup()!=null){
					bloodGroup= antenatalCard.getHin().getBloodGroup().getBloodGroupName();
				}
				if(antenatalCard.getGravida1() != null){
					gravida = antenatalCard.getGravida1();
				}
				if(antenatalCard.getGravida1() != null){
					gravida = antenatalCard.getGravida1();
				}
				if(antenatalCard.getLmp() != null && !antenatalCard.getLmp().equals("")){
					lmpDate = HMSUtil.convertDateToStringWithoutTime(antenatalCard.getLmp());
				}
				if(antenatalCard.getEdd() != null && !antenatalCard.getEdd().equals("")){
					eddDate = HMSUtil.convertDateToStringWithoutTime(antenatalCard.getEdd());
				}
				if(antenatalCard.getGestationalAgeWeeks() != null){
					gestationalAgeWeeks =antenatalCard.getGestationalAgeWeeks();
				}
				if(antenatalCard.getGestationalAgeDays() != null){
					gestationalAgeDays =antenatalCard.getGestationalAgeDays();
				}
				if(antenatalCard.getSurgicalHistory() != null){
					surgicalHistory =antenatalCard.getSurgicalHistory();
				}
				if(antenatalCard.getInfertility() != null){
					infertility =antenatalCard.getInfertility();
				}
				if(antenatalCard.getFactor() != null){
					factor =antenatalCard.getFactor();
				}
				if(antenatalCard.getInfertilityDetails() != null){
					infertilityDetail =antenatalCard.getInfertilityDetails();
				}
				if(antenatalCard.getHin().getDateOfBirth()!=null){
					Date dob=antenatalCard.getHin().getDateOfBirth();
					String ymd=HMSUtil.calculateYearMonthDay(dob);
					String d[]=ymd.split("&");
					int year1=Integer.parseInt(d[0].toString());
					int months1=Integer.parseInt(d[1].toString());
					int days1=Integer.parseInt(d[2].toString());
					yearMonth = year1 != 0 ? d[0] + " Y " : "";
					yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
					yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
				}
				
			}
			
		}
		String combordityName = "";
		if(comorbidityList.size()>0){
			for(OpdAntenatalCardMedicalHistory antenatalCardMedicalHistory : comorbidityList){
				if(antenatalCardMedicalHistory.getComorbidity() != null){
				combordityName = antenatalCardMedicalHistory.getComorbidity();
				}
				
			}
		}
		String obsetricRiskMeasure = "";
		if(trimsterList.size()>0){
			for(OpdAntenatalCardTrimester opdAntenatalCardTrimester : trimsterList){
				if(opdAntenatalCardTrimester.getObstetricRiskMeasure() != null){
					obsetricRiskMeasure = opdAntenatalCardTrimester.getObstetricRiskMeasure();
				}
				
			}
		}
		
		
%>
<script type="text/javascript">

window.onload= callRunRadioCheck;

function callRunRadioCheck(){
	runRadioCheck('<%=infertility%>','<%=factor%>');
}
function runRadioCheck(consanguineousYes, degree, infertilityYes, factor) {


	if (infertilityYes == "Yes") {
		document.getElementById("infertilityYes").checked = true;
	} else {
		document.getElementById("infertilityYes").checked = false;
	}
	if (infertilityYes == "No") {
		document.getElementById("infertilityNo").checked = true;
	} else {
		document.getElementById("infertilityNo").checked = false;
	}

	if (factor == "Male Factor") {
		document.getElementById("maleFactor").checked = true;
	} else {
		document.getElementById("maleFactor").checked = false;
	}
	if (factor == "Female Factor") {
		document.getElementById("femaleFactor").checked = true;
	} else {
		document.getElementById("femaleFactor").checked = false;
	}
	if (factor == "Both") {
		document.getElementById("both").checked = true;
	} else {
		document.getElementById("both").checked = false;
	}
	if (factor == "Un Explained") {
		document.getElementById("unExplained").checked = true;
	} else {
		document.getElementById("unExplained").checked = false;
	}
}
</script>
<div class="Block" >
<form name="preConsultationScreen" action="" method="post">
<h4>ANC Details</h4>
<div class="clear"></div>
<label>UHID</label>
<input name="uhid" id="uhid" type="text" value="<%=uhid != null?uhid:"" %>" validate="uhid,string,no"  readonly="readonly" />
<label>Patient Name</label>
<input name="patientname" id="patientname" type="text" value="<%=patientName != null?patientName:"" %>"	validate="patientname,string,no" readonly="readonly" />

<div class="clear"></div>
<label>Age</label>
<input name="fathername" type="text" value="<%=yearMonth != null?yearMonth:"" %>"	validate="patientname,string,no" readonly="readonly" />

<label>Blood Group</label>
<input name="gender" id="gender" type="text" value="<%=bloodGroup != null?bloodGroup:"" %>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>
<label>Gravida</label>
<input name="gender" id="gender" type="text" value="<%=gravida != null?gravida:"" %>"	validate="gender,string,no"   readonly="readonly"/>
<label>LMP Date</label>
<input name="age" id="age" type="text" value="<%=lmpDate != null?lmpDate:"" %>"	validate="age,string,no" maxlength="3"  readonly="readonly" />

<div class="clear"></div>
<label>EDD Date</label>
<input type="text" value="<%=eddDate != null?eddDate:"" %>"	validate="age,string,no" maxlength="3"  readonly="readonly" />

<label>Gestational Age</label>
<input  type="text" value="<%=gestationalAgeWeeks != null?gestationalAgeWeeks:"" %>" style="width: 50px"	validate="gender,string,no"   readonly="readonly"/>
<label class="smallAuto">Weeks</label>
<input  type="text" value="<%=gestationalAgeDays != null?gestationalAgeDays:"" %>" style="width: 50px" validate="gender,string,no"   readonly="readonly"/>
<label	class="smallAuto">Days</label>

<div class="clear"></div>
<label>Obstetric Risk Measure</label>
<input type="text" value="<%=obsetricRiskMeasure != null?obsetricRiskMeasure:"" %>"	validate="gender,string,no"  readonly="readonly"/>



<label>Past Surgical History</label>
<input  type="text" value="<%=surgicalHistory != null?surgicalHistory:"" %>"	validate="gender,string,no"   readonly="readonly"/>
<div class="clear"></div>

<label>Treatment for Infertility</label>
		
		<label class="smallAuto">
				<input class="radioCheckCol2" name="infertilityYes" id="infertilityYes"
				onchange="selectYesNo('infertilityYes','infertilityNo','degree','degree')"
				onclick="return displayFactor()"
				type="radio" value="Yes"> Yes	</label>
		<label class="smallAuto">
			<input class="radioCheckCol2" name="infertilityYes" id="infertilityNo"
			onchange="selectYesNo('infertilityNo','infertilityYes','degree','degree')"
			onclick="return displayFactorNo()"
			type="radio" value="No"> No
		</label> 
		<div class="" style="display: inline;" id="factorYes">
		<label class="smallAuto">
				<input class="radioCheckCol2" name="factor" id="maleFactor"
				onchange="selectYesNo('heartDisYes','heartDisNo','heartDis','Heart Diseases')"
				type="radio" value="Male Factor"> Male Factor </label>
		<label class="smallAuto">
				<input class="radioCheckCol2" name="factor" id="femaleFactor"
				onchange="selectYesNo('heartDisYes','heartDisNo','heartDis','Heart Diseases')"
				type="radio" value="Female Factor"> Female Factor </label>
				<label class="smallAuto">
				<input class="radioCheckCol2" name="factor" id="both"
				onchange="selectYesNo('heartDisYes','heartDisNo','heartDis','Heart Diseases')"
				type="radio" value="Both"> Both </label>
		<label class="smallAuto">
				<input class="radioCheckCol2" name="factor" id="unExplained"
				onchange="selectYesNo('heartDisYes','heartDisNo','heartDis','Heart Diseases')"
				type="radio" value="Un Explained"> Un Explained </label>
			<div class="clear"></div>
			<label>Medical Comorbidity</label>
<input  type="text" value="<%=combordityName != null?combordityName:"" %>"	validate="gender,string,no"  readonly="readonly"/>

			<label style="height:auto !important">Infertility Treatment Details</label> 
			<textarea class="opdMainTextArea" id="infertilityDetailsId" name="infertilityDetails"
				tabindex="0" maxlength="200" validate="Infertility Details,string,no"><%=infertilityDetail != null?infertilityDetail:"" %></textarea>
			<div class="clear"></div>
		</div>




<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div style="margin-left:80px">
<input type="button" class="button" value="Close" onclick='window.close()'/>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
</div>

</div>

<style>
input {height:25px!important;}
.smallAuto {
    float: left;
    font: 10px/22px Tahoma;
    margin-right: 6px;
    padding-right: 5px;
    text-align: left;
    width: auto !important;
}
.Block input.radioCh{margin-top:-1px!important;}


.Block input.radioCheckCol2 {
    
    margin-top: -1px!important;
   
}

</style>