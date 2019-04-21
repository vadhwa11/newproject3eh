<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hrms.masters.business.MasQualification"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdDermatologicalLeprosyExamination"%>
<%@page import="jkt.hms.masters.business.OpdDermatologicalNerveExamination"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<html>
<body>
<%
List<Object[]> generalProformaHeadersList = new ArrayList<Object[]>(); 
List<Object[]> firstLesionList = new ArrayList<Object[]>();
List<Object[]> secondLesionList = new ArrayList<Object[]>();
List<Object[]> findingLesionList = new ArrayList<Object[]>(); 

List<Object[]> previousComplaintListLeprosy = new ArrayList<Object[]>(); 
List<Object[]> historyList = new ArrayList<Object[]>();
List<OpdDermatologicalLeprosyExamination> opdDermLpsyProExm = new ArrayList<OpdDermatologicalLeprosyExamination>();
List<OpdDermatologicalNerveExamination> opdDermLpsyProNerveExm = new ArrayList<OpdDermatologicalNerveExamination>(); 

List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
List<MasQualification> educationList = new ArrayList<MasQualification>();
List<MasReligion> religionList = new ArrayList<MasReligion>();
List<Object[]> previousComplaintListPsychiatric = new ArrayList<Object[]>();

List<Object[]> previousComplaintListDeaddictionCentre = new ArrayList<Object[]>();
List<Object[]> deaddictionPerforma = new ArrayList<Object[]>();
List<OpdPatientDetails> systemicExmListDeaddictionCentre = new ArrayList<OpdPatientDetails>();

List<Object[]> previousComplaintListPsychogeriatricClinic = new ArrayList<Object[]>();
List<Object[]> psychogeriatricClinic = new ArrayList<Object[]>();
List<Object[]> systemicExmListpsychogeriatricClinic = new ArrayList<Object[]>();
List<PatientPrescriptionDetails> psychogeriatricClinic_prescriptionDetails = new ArrayList<PatientPrescriptionDetails>();

if((List) request.getAttribute("generalProformaHeadersList")!=null){
	generalProformaHeadersList = (List<Object[]>)request.getAttribute("generalProformaHeadersList");
}

if((List) request.getAttribute("firstLesionList")!=null){
	firstLesionList = (List<Object[]>)request.getAttribute("firstLesionList");
}
if((List) request.getAttribute("secondLesionList")!=null){
	secondLesionList = (List<Object[]>)request.getAttribute("secondLesionList");
}
if((List) request.getAttribute("findingLesionList")!=null){
	findingLesionList = (List<Object[]>)request.getAttribute("findingLesionList");
}

if((List) request.getAttribute("previousComplaintListLeprosy")!=null){
	previousComplaintListLeprosy = (List<Object[]>)request.getAttribute("previousComplaintListLeprosy");
}

if((List) request.getAttribute("historyList")!=null){
	historyList = (List<Object[]>)request.getAttribute("historyList");
}

if((List) request.getAttribute("opdDermLpsyProExm")!=null){
	opdDermLpsyProExm = (List<OpdDermatologicalLeprosyExamination>)request.getAttribute("opdDermLpsyProExm");
}

if((List) request.getAttribute("opdDermLpsyProNerveExm")!=null){
	opdDermLpsyProNerveExm = (List<OpdDermatologicalNerveExamination>)request.getAttribute("opdDermLpsyProNerveExm");
}

//code added by rajdeo
if((List)request.getAttribute("maritalStatusList")!=null){
	maritalStatusList = (List<MasMaritalStatus>)request.getAttribute("maritalStatusList");
}

if((List)request.getAttribute("educationList")!=null){
	educationList = (List<MasQualification>)request.getAttribute("educationList");
}

if((List)request.getAttribute("religionList")!=null){
	religionList = (List<MasReligion>)request.getAttribute("religionList");
}

if((List)request.getAttribute("previousComplaintListPsychiatric")!=null){
	previousComplaintListPsychiatric = (List<Object[]>)request.getAttribute("previousComplaintListPsychiatric");
}

if((List)request.getAttribute("previousComplaintListDeaddictionCentre")!=null){
	previousComplaintListDeaddictionCentre =  (List<Object[]>)request.getAttribute("previousComplaintListDeaddictionCentre");
}

if((List)request.getAttribute("deaddictionPerforma")!=null){
	deaddictionPerforma = (List<Object[]>)request.getAttribute("deaddictionPerforma");
}

if((List)request.getAttribute("systemicExmListDeaddictionCentre")!=null){
	systemicExmListDeaddictionCentre = (List<OpdPatientDetails>)request.getAttribute("systemicExmListDeaddictionCentre");
}

if((List)request.getAttribute("previousComplaintListPsychogeriatricClinic")!=null){
	previousComplaintListPsychogeriatricClinic = (List<Object[]>)request.getAttribute("previousComplaintListPsychogeriatricClinic");
}

if((List)request.getAttribute("psychogeriatricClinic")!=null){
	psychogeriatricClinic = (List<Object[]>)request.getAttribute("psychogeriatricClinic");
}

if((List)request.getAttribute("systemicExmListpsychogeriatricClinic")!=null){
	systemicExmListpsychogeriatricClinic = (List<Object[]>)request.getAttribute("systemicExmListpsychogeriatricClinic");
}

if((List)request.getAttribute("psychogeriatricClinic_prescriptionDetails")!=null){
	psychogeriatricClinic_prescriptionDetails =  (List<PatientPrescriptionDetails>)request.getAttribute("psychogeriatricClinic_prescriptionDetails");
}
%>


<h6>Speciality Clinical Summary</h6>
<div class="paddingTop5"></div>
<div id="clinicalSummaryDiv">
<div class="summaryDivMain">
<label>Previous Complaints</label>
<%
Date opdDate1 = null;
String presentingComplaints = "";
String presentingComplaintsDateWise = "";
String presentingComplaintsValue = "";
String presentingComplaintsValueDateWise = "";
String durationOfIllness = "";
String durationOfIllnessDateWise = "";
String pastHistory = "";
String pastHistoryValue = "";
String familyHistory = "";
String familyHistoryDateWise = "";
String familyHistoryValue = "";
String familyHistoryValueDateWise = "";
String drugHistory = "";

if(generalProformaHeadersList.size()>0){
	for(Object[] previousComplaints :generalProformaHeadersList){
	opdDate1 = (Date)previousComplaints[0];
	if( previousComplaints[2] != null && !previousComplaints[2].equals("")){
		presentingComplaintsValue = (String)previousComplaints[2];
	}
	if(!presentingComplaintsValue.equals("")){
	
		presentingComplaintsValueDateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate1);
		presentingComplaintsValueDateWise += " --  "+ presentingComplaintsValue+"<div class='clear'></div>";
		if(previousComplaints[3] != null && !previousComplaints[3].equals("")){
			durationOfIllness = (String)previousComplaints[3];
		}
		if(!durationOfIllness.equals("")){
			
			presentingComplaintsValueDateWise += " --  "+ durationOfIllness+"<div class='clear'></div>";
		}
	}
	
	if( previousComplaints[5] != null && !previousComplaints[5].equals("")){
		pastHistory = (String)previousComplaints[5];
	}
	
	if(!pastHistory.equals("")){
		pastHistoryValue += HMSUtil.convertDateToStringTypeDateOnly(opdDate1);
		pastHistoryValue += " --  "+ pastHistory+"<div class='clear'></div>";
		if(previousComplaints[6] != null && !previousComplaints[6].equals("")){
			familyHistory = (String)previousComplaints[6];
		}
		if(!familyHistory.equals("")){
			familyHistoryValueDateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate1);
			familyHistoryValueDateWise += " --  "+ familyHistory+"<div class='clear'></div>";
		}
		
		if(previousComplaints[7] != null && !previousComplaints[7].equals("")){
			familyHistoryValue = (String)previousComplaints[7];
		}
		if(!familyHistoryValue.equals("")){
			familyHistoryValueDateWise += " --  "+ familyHistoryValue+"<div class='clear'></div>";
		}
		
		if(previousComplaints[8] != null && !previousComplaints[8].equals("")){
			drugHistory = (String)previousComplaints[8];
		}
		if(!drugHistory.equals("")){
			familyHistoryValueDateWise += " --  "+ drugHistory+"<div class='clear'></div>";
		}
	}
	
	
	}

}

Date leprosyOpdDate = null;
String presentingComplaintsLeprosy = "";
String presentingComplaintsLeprosyDateWise = "";
String presentingComplaintsValueLeprosy = "";
String presentingComplaintsValueLeprosyDateWise = "";
Double durationLeprosy = 0.0;
String durationLeprosyValue ="";

if(previousComplaintListLeprosy.size()>0){
	for(Object[] previousComplaintsLeprosy :previousComplaintListLeprosy){
	leprosyOpdDate = (Date)previousComplaintsLeprosy[0];
	if( previousComplaintsLeprosy[1] != null && !previousComplaintsLeprosy[1].equals("")){
		presentingComplaintsLeprosy = (String)previousComplaintsLeprosy[1];
	}
	if(!presentingComplaintsLeprosy.equals("")){
		presentingComplaintsLeprosyDateWise += HMSUtil.convertDateToStringTypeDateOnly(leprosyOpdDate);
		presentingComplaintsLeprosyDateWise += " --  "+ presentingComplaintsLeprosy+"<div class='clear'></div>";
		if( previousComplaintsLeprosy[2] != null && !previousComplaintsLeprosy[2].equals("") 
				&& previousComplaintsLeprosy[3] != null && !previousComplaintsLeprosy[3].equals("")){
			durationLeprosy = Double.parseDouble((previousComplaintsLeprosy[2]).toString());
			durationLeprosyValue = (String)previousComplaintsLeprosy[3];
		}
		if(durationLeprosy !=0 && durationLeprosyValue != null)
		{
			presentingComplaintsLeprosyDateWise += " --  "+ durationLeprosy+"<div class='clear'></div>";
			presentingComplaintsLeprosyDateWise += " --  "+ durationLeprosyValue+"<div class='clear'></div>";
	     }
		
		
		
	}
	}
}
//code added by rajdeo
String presentingComplaintsPsychiatric = "";
String presentingComplaintsPsychiatricDateWise="";
String durationPsychiatric="";
String durationPsychiatricValue="";
Date PsychiatricOpdDate=null;

if(previousComplaintListPsychiatric.size()>0){
	for(Object[] previousComplaintsPsychiatric :previousComplaintListPsychiatric){
		PsychiatricOpdDate = (Date)previousComplaintsPsychiatric[0];
	if( previousComplaintsPsychiatric[1] != null && !previousComplaintsPsychiatric[1].equals("")){
		presentingComplaintsPsychiatric = (String)previousComplaintsPsychiatric[1];
	}
	if(!presentingComplaintsPsychiatric.equals("")){
		presentingComplaintsPsychiatricDateWise += HMSUtil.convertDateToStringTypeDateOnly(PsychiatricOpdDate);
		presentingComplaintsPsychiatricDateWise += " --  "+ presentingComplaintsPsychiatric+"<div class='clear'></div>";
		if( previousComplaintsPsychiatric[2] != null && !previousComplaintsPsychiatric[2].equals("") 
				&& previousComplaintsPsychiatric[3] != null && !previousComplaintsPsychiatric[3].equals("")){
			durationPsychiatric = (String)previousComplaintsPsychiatric[2];
			durationPsychiatricValue = (String)previousComplaintsPsychiatric[3];
		}
		if(durationLeprosy !=0 && durationLeprosyValue != null)
		{
			presentingComplaintsPsychiatricDateWise += " --  "+ durationPsychiatric+"<div class='clear'></div>";
			presentingComplaintsPsychiatricDateWise += " --  "+ durationPsychiatricValue+"<div class='clear'></div>";
	     }
				
	}
	}
}

//previousComplaintListDeaddictionCentre
Date DeaddictionCentreOpdDate=null;
String presentingComplaintsDeaddictionCentre="";
String presentingComplaintsDeaddictionCentreDateWise="";
int durationDeaddictionCentre=0;
String durationDeaddictionCentreValue="";

if(previousComplaintListDeaddictionCentre.size()>0){
	for(Object[] previousComplaintsDeaddictionCentre :previousComplaintListDeaddictionCentre){
		DeaddictionCentreOpdDate = (Date)previousComplaintsDeaddictionCentre[0];
	if( previousComplaintsDeaddictionCentre[1] != null && !previousComplaintsDeaddictionCentre[1].equals("")){
		presentingComplaintsDeaddictionCentre = (String)previousComplaintsDeaddictionCentre[1];
	}
	if(!presentingComplaintsDeaddictionCentre.equals("")){
		presentingComplaintsDeaddictionCentreDateWise += HMSUtil.convertDateToStringTypeDateOnly(leprosyOpdDate);
		presentingComplaintsLeprosyDateWise += " --  "+ presentingComplaintsLeprosy+"<div class='clear'></div>";
		if( previousComplaintsDeaddictionCentre[2] != null && !previousComplaintsDeaddictionCentre[2].equals("") 
				&& previousComplaintsDeaddictionCentre[3] != null && !previousComplaintsDeaddictionCentre[3].equals("")){
			durationDeaddictionCentre = (Integer)previousComplaintsDeaddictionCentre[2];
			durationDeaddictionCentreValue = (String)previousComplaintsDeaddictionCentre[3];
		}
		if(durationDeaddictionCentre !=0 && durationDeaddictionCentreValue != null)
		{
			presentingComplaintsDeaddictionCentreDateWise += " --  "+ durationDeaddictionCentre+"<div class='clear'></div>";
			presentingComplaintsDeaddictionCentreDateWise += " --  "+ durationDeaddictionCentreValue+"<div class='clear'></div>";
	     }
				
	}
	}
}


%>
<div class="summaryDetails"><p><%=presentingComplaintsValueDateWise != null?presentingComplaintsValueDateWise : "" %><%=presentingComplaintsLeprosyDateWise != null?presentingComplaintsLeprosyDateWise : "" %>
<%=presentingComplaintsPsychiatricDateWise != null?presentingComplaintsPsychiatricDateWise : "" %>
</p></div>
</div>
</div>
<div class="summaryDivMain">
<label>History</label>
<%
Date leprosyHistDate = null;
String leprosyHistory="";
String leprosyHistoryDateWise="";
String tb = "";
String hypertension = "";
String diabetes ="";
String cardiac= "";
String hepatic= "";
String renal="";
String pastHistoryOthers="";
String pastHistoryOthersValue="";
String historyOfEpistaxis="";
String epistaxisPresentRelation=""; 
String familyHistoryOfLeprosy="";
String familyHistoryRelation="";
String familyMemberAffected="";
String historyOfLeprosyNeighbours="";
String leprosyNeighboursValue="";
String previousHistoryOfLeprosy="";
String treatmentOfLeprosyPresentValue=""; 
System.out.println("Leprosy History Size on JSP: "+historyList.size());
if(historyList.size()>0){
	for(Object[] historyLeprosy :historyList){
		leprosyHistDate = (Date)historyLeprosy[0];
		
		if( historyLeprosy[1] != null && !historyLeprosy[1].equals("")){
			leprosyHistory = (String)historyLeprosy[1];
		}
		if(!leprosyHistory.equals("")){
			leprosyHistoryDateWise += HMSUtil.convertDateToStringTypeDateOnly(leprosyOpdDate);
			leprosyHistoryDateWise += " --  "+ leprosyHistory+"<div class='clear'></div>";
			if(historyLeprosy[2] != null && !historyLeprosy[2].equals(""))
			{
				tb = (String)historyLeprosy[1];
			}
			if(!tb.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ tb+"<div class='clear'></div>";
			}
			
			if(historyLeprosy[3] != null && !historyLeprosy[3].equals(""))
			{
				diabetes = (String)historyLeprosy[3];
			}
			if(!diabetes.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ diabetes+"<div class='clear'></div>";
			}
			if(historyLeprosy[3] != null && !historyLeprosy[3].equals(""))
			{
				diabetes = (String)historyLeprosy[3];
			}
			
			if(historyLeprosy[4] != null && !historyLeprosy[4].equals(""))
			{
				cardiac = (String)historyLeprosy[4];
			}
			if(!cardiac.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ cardiac+"<div class='clear'></div>";
			}
			if(historyLeprosy[5] != null && !historyLeprosy[5].equals(""))
			{
				hepatic = (String)historyLeprosy[5];
			}
			if(!hepatic.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ hepatic+"<div class='clear'></div>";
			}
			if(historyLeprosy[6] != null && !historyLeprosy[6].equals(""))
			{
				renal = (String)historyLeprosy[6];
			}
			if(!renal.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ renal+"<div class='clear'></div>";
			}
			if(historyLeprosy[7] != null && !historyLeprosy[7].equals(""))
			{
				pastHistoryOthers = (String)historyLeprosy[7];
			}
			if(!pastHistoryOthers.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ pastHistoryOthers+"<div class='clear'></div>";
			}
			if(historyLeprosy[8] != null && !historyLeprosy[8].equals(""))
			{
				pastHistoryOthersValue = (String)historyLeprosy[8];
			}
			if(!pastHistoryOthersValue.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ pastHistoryOthersValue+"<div class='clear'></div>";
			}
			if(historyLeprosy[9] != null && !historyLeprosy[9].equals(""))
			{
				historyOfEpistaxis = (String)historyLeprosy[9];
			}
			if(!historyOfEpistaxis.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ historyOfEpistaxis+"<div class='clear'></div>";
			}
			if(historyLeprosy[10] != null && !historyLeprosy[10].equals(""))
			{
				epistaxisPresentRelation = (String)historyLeprosy[10];
			}
			if(!epistaxisPresentRelation.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ epistaxisPresentRelation+"<div class='clear'></div>";
			}
			if(historyLeprosy[11] != null && !historyLeprosy[11].equals(""))
			{
				familyHistoryOfLeprosy = (String)historyLeprosy[11];
			}
			if(!familyHistoryOfLeprosy.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ familyHistoryOfLeprosy+"<div class='clear'></div>";
			}
			if(historyLeprosy[12] != null && !historyLeprosy[12].equals(""))
			{
				familyHistoryRelation = (String)historyLeprosy[12];
			}
			if(!familyHistoryRelation.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ familyHistoryRelation+"<div class='clear'></div>";
			}
			if(historyLeprosy[13] != null && !historyLeprosy[13].equals(""))
			{
				familyMemberAffected = (String)historyLeprosy[13];
			}
			if(!familyMemberAffected.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ familyMemberAffected+"<div class='clear'></div>";
			}
			if(historyLeprosy[14] != null && !historyLeprosy[14].equals(""))
			{
				historyOfLeprosyNeighbours = (String)historyLeprosy[14];
			}
			if(!historyOfLeprosyNeighbours.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ historyOfLeprosyNeighbours+"<div class='clear'></div>";
			}
			if(historyLeprosy[15] != null && !historyLeprosy[15].equals(""))
			{
				leprosyNeighboursValue = (String)historyLeprosy[15];
			}
			if(!leprosyNeighboursValue.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ leprosyNeighboursValue+"<div class='clear'></div>";
			}
			if(historyLeprosy[16] != null && !historyLeprosy[16].equals(""))
			{
				previousHistoryOfLeprosy = (String)historyLeprosy[16];
			}
			if(!previousHistoryOfLeprosy.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ previousHistoryOfLeprosy+"<div class='clear'></div>";
			}
			if(historyLeprosy[17] != null && !historyLeprosy[17].equals(""))
			{
				treatmentOfLeprosyPresentValue = (String)historyLeprosy[17];
			}
			if(!treatmentOfLeprosyPresentValue.equals(""))
			{
				leprosyHistoryDateWise += " --  "+ treatmentOfLeprosyPresentValue+"<div class='clear'></div>";
			}
		}
		
	}
}

%>
<div class="summaryDetails"><p><%=familyHistoryValueDateWise != null ? familyHistoryValueDateWise :"" %><%=leprosyHistoryDateWise != null ? leprosyHistoryDateWise :"" %></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Primary Lesion</label>

<%
Date lesionDate = null;
String parameterName = "";
String parameterValue = "";
String number = "";
String site = "";
String typeOfLesion= "";
String pigmentationStatus="";
String pigmentation="";
String charcter="";
String border="";
String surface="";
String smallestSize="";
String largestSize="";
String hairOnLesion="";
String aggravatingFactor="";
String secondaryLesionOther="";
if(firstLesionList.size()>0){
	for(Object[] firstLesion :firstLesionList){
	lesionDate = (Date)firstLesion[0];
	if( firstLesion[1] != null && !firstLesion[1].equals("")){
		parameterName = (String)firstLesion[1];
	}
	if(!parameterName.equals(""))
	{
		parameterValue += HMSUtil.convertDateToStringTypeDateOnly(lesionDate);
		parameterValue += " --  "+ parameterName+"<div class='clear'></div>";
		if( firstLesion[2] != null && !firstLesion[2].equals("")){
			number = (String)firstLesion[2];
		}
		if(!number.equals(""))
		{
			parameterValue += " --  "+ number+"<div class='clear'></div>";
	     }
		
		if( firstLesion[3] != null && !firstLesion[3].equals("")){
			site = (String)firstLesion[3];
		}
		if(!site.equals(""))
		{
			parameterValue += " --  "+ site+"<div class='clear'></div>";
	    }
		
		if( firstLesion[4] != null && !firstLesion[4].equals("")){
			typeOfLesion = (String)firstLesion[4];
		}
		if(!typeOfLesion.equals(""))
		{
			parameterValue += " --  "+ typeOfLesion+"<div class='clear'></div>";
	    }
		if( firstLesion[5] != null && !firstLesion[5].equals("")){
			pigmentationStatus = (String)firstLesion[5];
		}
		if(!pigmentationStatus.equals(""))
		{
			parameterValue += " --  "+ pigmentationStatus+"<div class='clear'></div>";
	    }
		
		if( firstLesion[6] != null && !firstLesion[6].equals("")){
			pigmentation = (String)firstLesion[6];
		}
		if(!pigmentationStatus.equals(""))
		{
			parameterValue += " --  "+ pigmentation+"<div class='clear'></div>";
	    }
		if( firstLesion[7] != null && !firstLesion[7].equals("")){
			charcter = (String)firstLesion[7];
		}
		if(!charcter.equals(""))
		{
			parameterValue += " --  "+ charcter+"<div class='clear'></div>";
	    }
		
		if( firstLesion[8] != null && !firstLesion[8].equals("")){
			border = (String)firstLesion[8];
		}
		if(!border.equals(""))
		{
			parameterValue += " --  "+ border+"<div class='clear'></div>";
	    }
		
		if( firstLesion[9] != null && !firstLesion[9].equals("")){
			surface = (String)firstLesion[9];
		}
		if(!surface.equals(""))
		{
			parameterValue += " --  "+ surface+"<div class='clear'></div>";
	    }
		
		if( firstLesion[10] != null && !firstLesion[10].equals("")){
			smallestSize = (String)firstLesion[10];
		}
		if(!smallestSize.equals(""))
		{
			parameterValue += " --  "+ smallestSize+"<div class='clear'></div>";
	    }
		
		if( firstLesion[11] != null && !firstLesion[11].equals("")){
			largestSize = (String)firstLesion[11];
		}
		if(!largestSize.equals(""))
		{
			parameterValue += " --  "+ largestSize+"<div class='clear'></div>";
	    }
		
		if( firstLesion[12] != null && !firstLesion[12].equals("")){
			hairOnLesion = (String)firstLesion[12];
		}
		if(!hairOnLesion.equals(""))
		{
			parameterValue += " --  "+ hairOnLesion+"<div class='clear'></div>";
	    }
		
		if( firstLesion[13] != null && !firstLesion[13].equals("")){
			aggravatingFactor = (String)firstLesion[13];
		}
		if(!aggravatingFactor.equals(""))
		{
			parameterValue += " --  "+ aggravatingFactor+"<div class='clear'></div>";
	    }
		
		if( firstLesion[14] != null && !firstLesion[14].equals("")){
			secondaryLesionOther = (String)firstLesion[14];
		}
		if(!secondaryLesionOther.equals(""))
		{
			parameterValue += " --  "+ secondaryLesionOther+"<div class='clear'></div>";
	    }
		
	}		
} 
}
%>

<div class="summaryDetails"><p><%= parameterValue %></p></div>
</div>

<div class="summaryDivMain">
<label>Secondary Lesion</label>
<%
Date secondarylesionDate = null;
String parameterNameLesion = "";
String parameterValueLesion = "";
String parameterValueLesion1 = "";
String numberLesion = "";
String numberLesionValue = "";
String siteLesion = "";
String typeOfLesionLesion= "";
String pigmentationStatusLesion="";
String pigmentationLesion="";
String charcterLesion="";
String borderLesion="";
String surfaceLesion="";
String smallestSizeLesion="";
String largestSizeLesion="";
String hairOnLesionLesion="";
String aggravatingFactorLesion="";
String secondaryLesionOtherLesion="";

if(secondLesionList.size()>0){
	for(Object[] secondLesion :secondLesionList){
		secondarylesionDate = (Date)secondLesion[0];
	if( secondLesion[1] != null && !secondLesion[1].equals("")){
		parameterNameLesion = (String)secondLesion[1];
	}
	if(!parameterNameLesion.equals(""))
	{
		parameterValueLesion += HMSUtil.convertDateToStringTypeDateOnly(secondarylesionDate);
		parameterValueLesion += " --  "+ parameterNameLesion+"<div class='clear'></div>";
		if( secondLesion[2] != null && !secondLesion[2].equals("")){
			numberLesion = (String)secondLesion[2];
		}
		if(!numberLesion.equals(""))
		{
			parameterValueLesion += " --  "+ numberLesion+"<div class='clear'></div>";
	     }
	
		if( secondLesion[3] != null && !secondLesion[3].equals("")){
			siteLesion = (String)secondLesion[3];
		}
		if(!siteLesion.equals(""))
		{
			parameterValueLesion += " --  "+ siteLesion+"<div class='clear'></div>";
	    }
		
		 if( secondLesion[4] != null && !secondLesion[4].equals("")){
			typeOfLesionLesion = (String)secondLesion[4];
		}
		if(!typeOfLesionLesion.equals(""))
		{
			parameterValueLesion += " --  "+ typeOfLesionLesion+"<div class='clear'></div>";
	    }
			if( secondLesion[5] != null && !secondLesion[5].equals("")){
			pigmentationStatusLesion = (String)secondLesion[5];
		} 
	}
		if(!pigmentationStatus.equals(""))
		{
			parameterValueLesion1 += HMSUtil.convertDateToStringTypeDateOnly(secondarylesionDate);
			parameterValueLesion1 += " --  "+ pigmentationStatusLesion+"<div class='clear'></div>";
		
		if( secondLesion[6] != null && !secondLesion[6].equals("")){
			pigmentationLesion = (String)secondLesion[6];
		}
		if(!pigmentationLesion.equals(""))
		{
			parameterValueLesion1 += " --  "+ pigmentationLesion+"<div class='clear'></div>";
	    }
		if( secondLesion[7] != null && !secondLesion[7].equals("")){
			charcterLesion = (String)secondLesion[7];
		}
		if(!charcterLesion.equals(""))
		{
			parameterValueLesion1 += " --  "+ charcterLesion+"<div class='clear'></div>";
	    }
		
		if( secondLesion[8] != null && !secondLesion[8].equals("")){
			borderLesion = (String)secondLesion[8];
		}
		if(!borderLesion.equals(""))
		{
			parameterValueLesion1 += " --  "+ borderLesion+"<div class='clear'></div>";
	    } 
		
		if( secondLesion[9] != null && !secondLesion[9].equals("")){
			surfaceLesion = (String)secondLesion[9];
		}
		if(!surfaceLesion.equals(""))
		{
			parameterValueLesion += " --  "+ surfaceLesion+"<div class='clear'></div>";
	    }
		
		 if( secondLesion[10] != null && !secondLesion[10].equals("")){
			smallestSizeLesion = (String)secondLesion[10];
		}
		if(!smallestSizeLesion.equals(""))
		{
			parameterValueLesion += " --  "+ smallestSizeLesion+"<div class='clear'></div>";
	    }
		
		if( secondLesion[11] != null && !secondLesion[11].equals("")){
			largestSizeLesion = (String)secondLesion[11];
		}
		if(!largestSizeLesion.equals(""))
		{
			parameterValueLesion += " --  "+ largestSizeLesion+"<div class='clear'></div>";
	    }
		
		if( secondLesion[12] != null && !secondLesion[12].equals("")){
			hairOnLesionLesion = (String)secondLesion[12];
		}
		if(!hairOnLesionLesion.equals(""))
		{
			parameterValueLesion += " --  "+ hairOnLesionLesion+"<div class='clear'></div>";
	    }
		
		if( secondLesion[13] != null && !secondLesion[13].equals("")){
			aggravatingFactorLesion = (String)secondLesion[13];
		}
		if(!aggravatingFactorLesion.equals(""))
		{
			parameterValueLesion += " --  "+ aggravatingFactorLesion+"<div class='clear'></div>";
	    }
		
		if( secondLesion[14] != null && !secondLesion[14].equals("")){
			secondaryLesionOtherLesion = (String)secondLesion[14];
		}
		if(!secondaryLesionOtherLesion.equals(""))
		{
			parameterValueLesion += " --  "+ secondaryLesionOtherLesion+"<div class='clear'></div>";
	    }
		 
	}
	}
}		




%>


<div class="summaryDetails"><p><%= parameterValueLesion != null ?parameterValueLesion : "" %><%= parameterValueLesion1 != null ?parameterValueLesion1 : "" %></p></div>
</div>

<div class="summaryDivMain">
<label>Findings</label>
<%
Date findingDate = null;
String findingValues = "";
String findingValues1 = "";
String findingValues2 = "";
String distribution = "";
String mucousMembrane = ""; 
String mucouMenbraneValue= ""; 
String hair= "";
String hairValue= "";
String nails=""; 
String nailsValue="";
String systemIllness=""; 
String systemIllnessValue=""; 
String signs=""; 
String signsValue="";
System.out.println("findingLesionList size: "+findingLesionList.size());
if(findingLesionList.size()>0){
	for(Object[] findingLesion :findingLesionList){
		findingDate = (Date)findingLesion[0];
	if( findingLesion[1] != null && !findingLesion[1].equals("")){
		distribution = (String)findingLesion[1];
	}
	if(!distribution.equals("")){
		
		findingValues += HMSUtil.convertDateToStringTypeDateOnly(findingDate);
		findingValues += " --  "+ distribution+"<div class='clear'></div>";
		if( findingLesion[2] != null && !findingLesion[2].equals("")){
			mucouMenbraneValue = (String)findingLesion[2];
		}	
		if(!mucouMenbraneValue.equals(""))
		{
			
			findingValues += "-- "+ mucouMenbraneValue+"<div class='clear'></div>";
		}
		if( findingLesion[3] != null && !findingLesion[3].equals("")){
			hairValue = (String)findingLesion[3];
		}
		if(!hairValue.equals(""))
		{
			
			findingValues += "-- "+ hairValue+"<div class='clear'></div>";
		}
		if( findingLesion[4] != null && !findingLesion[4].equals("")){
			nailsValue = (String)findingLesion[4];
		}
		if(!nailsValue.equals(""))
		{
			
			findingValues += "-- "+ nailsValue+"<div class='clear'></div>";
		}
		}
	if( findingLesion[5] != null && !findingLesion[5].equals("")){
		systemIllnessValue = (String)findingLesion[5];
	}
	if(!systemIllnessValue.equals("")){
	
		findingValues1 += HMSUtil.convertDateToStringTypeDateOnly(findingDate);
		findingValues1 += " --  "+ systemIllnessValue+"<div class='clear'></div>";
		if(findingLesion[6] != null && !findingLesion[6].equals("")){
			signsValue = (String)findingLesion[6];
	}
		if(!signsValue.equals(""))
		{
			
			findingValues1 += "-- "+ signsValue+"<div class='clear'></div>";
		}
	
	}
	}
}

Date opdDermLpsyProDate= null;
String pallor = "";
String jaundice = "";
String cyanosis = "";
String lymph = "";
String edema = "";
String pastHistoryOthersL = "";
String pastHistoryOthersLCalue = "";
String bp = "";
String earLob = "";
String opdDermLpsyProExmination = "";

if(opdDermLpsyProExm.size()>0){
	for(OpdDermatologicalLeprosyExamination opdDermLpsyPro :opdDermLpsyProExm){
		
		if(secondarylesionDate!=null){
		if( opdDermLpsyPro.getLeprosyProforma().getOpdPatientDetails().getOpdDate() != null && !opdDermLpsyPro.getLeprosyProforma().getOpdPatientDetails().getOpdDate().equals("")){
			opdDermLpsyProDate = (Date)opdDermLpsyPro.getLeprosyProforma().getOpdPatientDetails().getOpdDate();
		}
		if( opdDermLpsyPro.getLeprosyProforma().getPallor()!= null && !opdDermLpsyPro.getLeprosyProforma().getPallor().equals("")){
			pallor = (String)opdDermLpsyPro.getLeprosyProforma().getPallor();
		}
		if(!pallor.equals("") && pallor != null)
		{
			opdDermLpsyProExmination += HMSUtil.convertDateToStringTypeDateOnly(secondarylesionDate);
			opdDermLpsyProExmination += " --  "+ pallor+"<div class='clear'></div>";
	    }
		if( opdDermLpsyPro.getLeprosyProforma().getJaundice()!= null && !opdDermLpsyPro.getLeprosyProforma().getJaundice().equals("")){
			jaundice = (String)opdDermLpsyPro.getLeprosyProforma().getJaundice();
		}
		if(!jaundice.equals("") && jaundice != null)
		{
			opdDermLpsyProExmination += " --  "+ jaundice+"<div class='clear'></div>";
	}
		
		if( opdDermLpsyPro.getLeprosyProforma().getLymphadenopathy()!= null && !opdDermLpsyPro.getLeprosyProforma().getLymphadenopathy().equals("")){
			lymph = (String)opdDermLpsyPro.getLeprosyProforma().getLymphadenopathy();
		}
		if(!lymph.equals("") && lymph != null)
		{
			opdDermLpsyProExmination += " --  "+ lymph+"<div class='clear'></div>";
	    }
		
		if( opdDermLpsyPro.getLeprosyProforma().getEdema()!= null && !opdDermLpsyPro.getLeprosyProforma().getEdema().equals("")){
			edema = (String)opdDermLpsyPro.getLeprosyProforma().getEdema();
		}
		if(!edema.equals("") && edema != null)
		{
			opdDermLpsyProExmination += " --  "+ edema+"<div class='clear'></div>";
	    }
		
		if( opdDermLpsyPro.getLeprosyProforma().getPastHistoryOthers()!= null && !opdDermLpsyPro.getLeprosyProforma().getPastHistoryOthers().equals("")){
			pastHistoryOthersL = (String)opdDermLpsyPro.getLeprosyProforma().getEdema();
		}
		if(!pastHistoryOthersL.equals("") && pastHistoryOthersL != null)
		{
			opdDermLpsyProExmination += " --  "+ pastHistoryOthersL+"<div class='clear'></div>";
	    }
		if( opdDermLpsyPro.getLeprosyProforma().getPastHistoryOthersValue()!= null && !opdDermLpsyPro.getLeprosyProforma().getPastHistoryOthersValue().equals("")){
			pastHistoryOthersLCalue = (String)opdDermLpsyPro.getLeprosyProforma().getPastHistoryOthersValue();
		}
		if(!pastHistoryOthersLCalue.equals("") && pastHistoryOthersLCalue != null)
		{
			opdDermLpsyProExmination += " --  "+ pastHistoryOthersLCalue+"<div class='clear'></div>";
	    }
		
		if( opdDermLpsyPro.getEarLobe()!= null && !opdDermLpsyPro.getEarLobe().equals("")){
			earLob = (String)opdDermLpsyPro.getEarLobe();
		}
		if(!earLob.equals("") && earLob != null)
		{
			opdDermLpsyProExmination += " --  "+ earLob+"<div class='clear'></div>";
	    }
	}
}
}

%>
<div class="summaryDetails"><p><%=findingValues %><%=findingValues1 %><%=opdDermLpsyProExmination %><%=opdDermLpsyProExmination %></p></div>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="clear"></div>
</body>
</html>