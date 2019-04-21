
 <%@page import="jkt.hms.masters.business.OpdDermatologicalNerveExamination"%>
<%@page import="jkt.hms.masters.business.OpdDermatologicalLeprosyExamination"%>
<%@page import="java.util.Date"%>
 <%@page import="java.util.HashMap"%>
 <%@page import="java.util.HashMap"%>
 <%@page import="java.util.ArrayList"%>
 <%@page import="java.util.List"%>
 <%@page import="java.util.Map"%>
 <%@page import="java.math.BigDecimal"%>
 <%@page import="jkt.hms.util.HMSUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	/* added by swarup 03/01/2017 for general proforma*/
	List<Object[]> generalProformaHeadersList = new ArrayList<Object[]>();
	List<Object[]> firstLesionList = new ArrayList<Object[]>();
	List<Object[]> secondLesionList = new ArrayList<Object[]>();
	List<Object[]> findingLesionList = new ArrayList<Object[]>();
 
	if(map.get("generalProformaHeadersList")!=null){
		generalProformaHeadersList = (List<Object[]>)map.get("generalProformaHeadersList");
    }
 	  if(map.get("firstLesionList")!=null){
		firstLesionList = (List<Object[]>)map.get("firstLesionList");
    }
	  if(map.get("secondLesionList")!=null){
		secondLesionList = (List<Object[]>)map.get("secondLesionList");
    }
 	if(map.get("findingLesionList")!=null){
		findingLesionList = (List<Object[]>)map.get("findingLesionList");
	}  
 	
 	/* added by swarup 03/01/2017 for leprosy */
	List<Object[]> previousComplaintListLeprosy = new ArrayList<Object[]>();
	List<Object[]> historyList = new ArrayList<Object[]>();
	//List<Object[]> opdDermLpsyProExm = new ArrayList<Object[]>();
	//List<Object[]> opdDermLpsyProNerveExm = new ArrayList<Object[]>();
				
	if(map.get("previousComplaintListLeprosy")!=null){
		previousComplaintListLeprosy = (List<Object[]>)map.get("previousComplaintListLeprosy");
	}
	if(map.get("historyList")!=null){
		historyList = (List<Object[]>)map.get("historyList");
	}
 
	
 	List<OpdDermatologicalLeprosyExamination> opdDermLpsyProExm = new ArrayList<OpdDermatologicalLeprosyExamination>();
	if(map.get("opdDermLpsyProExm") != null){
		opdDermLpsyProExm=(List)map.get("opdDermLpsyProExm");
	}
	
	List<OpdDermatologicalNerveExamination> opdDermLpsyProNerveExm = new ArrayList<OpdDermatologicalNerveExamination>();
	if(map.get("opdDermLpsyProNerveExm") != null){
		opdDermLpsyProNerveExm=(List)map.get("opdDermLpsyProNerveExm");
	}
%>

<div class="Block">
 <h6>Speciality Clinical Summary</h6>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="summaryDivMain">

<% 
/*  swarup for General proforma */
		String historyGp= "";
		String presentComplaintsGp = "";
	if(generalProformaHeadersList.size()>0){
	for(Object[] patientHistoryGp :generalProformaHeadersList){
	 	Date opdDate = (Date)patientHistoryGp[0];
	 	presentComplaintsGp =HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
		if(patientHistoryGp[1] != null && !patientHistoryGp[1].equals("")){
			presentComplaintsGp += "Presenting complaint value	:	"+(String)patientHistoryGp[1];
		}
 		if(patientHistoryGp[2] != null && !patientHistoryGp[2].equals("")){
 			presentComplaintsGp += "Presenting complaint other value	:	"+(String)patientHistoryGp[2]+"<div class='clear'></div>";
		}
		if(patientHistoryGp[3] != null && !patientHistoryGp[3].equals("")){
			presentComplaintsGp += "Duration of illness	:	"+(String)patientHistoryGp[3]+"<div class='clear'></div>";
		}
		historyGp=HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
		if(patientHistoryGp[4] != null && !patientHistoryGp[4].equals("")){
			historyGp += "Past history value	:	"+(String)patientHistoryGp[4]+"<div class='clear'></div>";
		}
		if(patientHistoryGp[5] != null && !patientHistoryGp[5].equals("")){
			historyGp += "Past history other value	:	"+(String)patientHistoryGp[5]+"<div class='clear'></div>";
		}
		if(patientHistoryGp[6] != null && !patientHistoryGp[6].equals("")){
			historyGp += "family History	:	"+(String)patientHistoryGp[6]+"<div class='clear'></div>";
		}
		 
		if(patientHistoryGp[7] != null && !patientHistoryGp[7].equals("")){
			historyGp += "family History Value	:	"+(String)patientHistoryGp[7]+"<div class='clear'></div>";
		}
	 	if(patientHistoryGp[8] != null && !patientHistoryGp[8].equals("")){
	 		historyGp += "Drug history :	"+(String)patientHistoryGp[8]+"<div class='clear'></div>";
			}
	 	if(patientHistoryGp[9] != null && !patientHistoryGp[9].equals("")){
	 		historyGp += "Drug history value :	"+(String)patientHistoryGp[9]+"<div class='clear'></div>";
			}
		}
	}
	
  
 	String firstLesion = "";
 	if(firstLesionList.size()>0){
		for(Object[] firstLesionGp :firstLesionList){
	 		Date opdDate = (Date)firstLesionGp[0];
	 		firstLesion = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			if(firstLesionGp[1] != null && !firstLesionGp[1].equals("")){
				firstLesion += "Parameter Name	:	"+(String)firstLesionGp[1];
			}
		 	if(firstLesionGp[2] != null && !firstLesionGp[2].equals("")){
	 			firstLesion += "Number	:	"+(String)firstLesionGp[2]+"<div class='clear'></div>";
			}
			if(firstLesionGp[3] != null && !firstLesionGp[3].equals("")){
				firstLesion += "Site	:	"+(String)firstLesionGp[3]+"<div class='clear'></div>";
			}
			if(firstLesionGp[4] != null && !firstLesionGp[4].equals("")){
				firstLesion += "Type of lesion	:	"+(String)firstLesionGp[4]+"<div class='clear'></div>";
			}
			if(firstLesionGp[5] != null && !firstLesionGp[5].equals("")){
				firstLesion += "Pigmentation Status	:	"+(String)firstLesionGp[5]+"<div class='clear'></div>";
			}
			if(firstLesionGp[6] != null && !firstLesionGp[6].equals("")){
				firstLesion += "Pigmentation	:	"+(String)firstLesionGp[6]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[7] != null && !firstLesionGp[7].equals("")){
				firstLesion += "Characher	:	"+(String)firstLesionGp[7]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[8] != null && !firstLesionGp[8].equals("")){
				firstLesion += "Border	:	"+(String)firstLesionGp[8]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[9] != null && !firstLesionGp[9].equals("")){
				firstLesion += "Surface	:	"+(String)firstLesionGp[9]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[10] != null && !firstLesionGp[10].equals("")){
				firstLesion += "Smallest size	:	"+(String)firstLesionGp[10]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[11] != null && !firstLesionGp[11].equals("")){
				firstLesion += "Largest size	:	"+(String)firstLesionGp[11]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[12] != null && !firstLesionGp[12].equals("")){
				firstLesion += "Hair on lesion	:	"+(String)firstLesionGp[12]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[13] != null && !firstLesionGp[13].equals("")){
				firstLesion += "Additional feature	:	"+(String)firstLesionGp[13]+"<div class='clear'></div>";
			}
		 	if(firstLesionGp[14] != null && !firstLesionGp[14].equals("")){
				firstLesion += "Secondary lesion other	:	"+(String)firstLesionGp[14]+"<div class='clear'></div>";
			}		 	 
		}
	}
 	
 	
 	String secondLesion = "";
 	if(secondLesionList.size()>0){
		for(Object[] secondLesionGp :secondLesionList){
	 		Date opdDate = (Date)secondLesionGp[0];
	 		secondLesion = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			if(secondLesionGp[1] != null && !secondLesionGp[1].equals("")){
				secondLesion += "Parameter Name	:	"+(String)secondLesionGp[1];
			}
		 	if(secondLesionGp[2] != null && !secondLesionGp[2].equals("")){
	 			secondLesion += "Number	:	"+(String)secondLesionGp[2]+"<div class='clear'></div>";
			}
			if(secondLesionGp[3] != null && !secondLesionGp[3].equals("")){
				secondLesion += "Site	:	"+(String)secondLesionGp[3]+"<div class='clear'></div>";
			}
			if(secondLesionGp[4] != null && !secondLesionGp[4].equals("")){
				secondLesion += "Type of lesion	:	"+(String)secondLesionGp[4]+"<div class='clear'></div>";
			}
			if(secondLesionGp[5] != null && !secondLesionGp[5].equals("")){
				secondLesion += "Pigmentation Lesion	:	"+(String)secondLesionGp[5]+"<div class='clear'></div>";
			}
			if(secondLesionGp[6] != null && !secondLesionGp[6].equals("")){
				secondLesion += "Pigmentation	:	"+(String)secondLesionGp[6]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[7] != null && !secondLesionGp[7].equals("")){
				secondLesion += "Characher	:	"+(String)secondLesionGp[7]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[8] != null && !secondLesionGp[8].equals("")){
				secondLesion += "Border	:	"+(String)secondLesionGp[8]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[9] != null && !secondLesionGp[9].equals("")){
				secondLesion += "Surface	:	"+(String)secondLesionGp[9]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[10] != null && !secondLesionGp[10].equals("")){
				secondLesion += "Smallest size	:	"+(String)secondLesionGp[10]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[11] != null && !secondLesionGp[11].equals("")){
				secondLesion += "Largest size	:	"+(String)secondLesionGp[11]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[12] != null && !secondLesionGp[12].equals("")){
				secondLesion += "Hair on lesion	:	"+(String)secondLesionGp[12]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[13] != null && !secondLesionGp[13].equals("")){
				secondLesion += "Additional feature	:	"+(String)secondLesionGp[13]+"<div class='clear'></div>";
			}
		 	if(secondLesionGp[14] != null && !secondLesionGp[14].equals("")){
				secondLesion += "Secondary lesion other	:	"+(String)secondLesionGp[14]+"<div class='clear'></div>";
			}		 	 
		}
	}
 	
 	String findingGp = "";
 	if(findingLesionList.size()>0){
		for(Object[] findingLesionGp :findingLesionList){
	 		Date opdDate = (Date)findingLesionGp[0];
	 		findingGp = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			if(findingLesionGp[1] != null && !findingLesionGp[1].equals("")){
				findingGp +="Distribution	:	" +(String)findingLesionGp[1];
			}
		 	if(findingLesionGp[2] != null && !findingLesionGp[2].equals("")){
	 			findingGp += "Mucous membrane value	:	"+(String)findingLesionGp[2]+"<div class='clear'></div>";
			}
			if(findingLesionGp[3] != null && !findingLesionGp[3].equals("")){
				findingGp += "Mucous membrane other value	:	"+(String)findingLesionGp[3]+"<div class='clear'></div>";
			}
			if(findingLesionGp[4] != null && !findingLesionGp[4].equals("")){
				findingGp += "Hair value	:	"+(String)findingLesionGp[4]+"<div class='clear'></div>";
			}
			if(findingLesionGp[5] != null && !findingLesionGp[5].equals("")){
				findingGp += "Hair value other	:	"+(String)findingLesionGp[5]+"<div class='clear'></div>";
			}
			if(findingLesionGp[6] != null && !findingLesionGp[6].equals("")){
				findingGp += "Nails	value :	"+(String)findingLesionGp[6]+"<div class='clear'></div>";
			}
		 	if(findingLesionGp[7] != null && !findingLesionGp[7].equals("")){
				findingGp += "Nails Value other	:	"+(String)findingLesionGp[7]+"<div class='clear'></div>";
			}
		 	if(findingLesionGp[8] != null && !findingLesionGp[8].equals("")){
				findingGp += "System illnes value	:	"+(String)findingLesionGp[8]+"<div class='clear'></div>";
			}
		 	if(findingLesionGp[9] != null && !findingLesionGp[9].equals("")){
				findingGp += "System illnes other value	:	"+(String)findingLesionGp[9]+"<div class='clear'></div>";
			}
		 	if(findingLesionGp[10] != null && !findingLesionGp[10].equals("")){
				findingGp += "signs	value:	"+(String)findingLesionGp[10]+"<div class='clear'></div>";
			}
		 	if(findingLesionGp[11] != null && !findingLesionGp[11].equals("")){
				findingGp += "Signs other value	:	"+(String)findingLesionGp[11]+"<div class='clear'></div>";
			}
		}
	}
 	
 	/*  swarup for General proforma ended----------------------------------------------------------------------------------*/
 	
 		String presentComplaintsLp = "";
	if(previousComplaintListLeprosy.size()>0){
		for(Object[] patientHistoryLp :previousComplaintListLeprosy){
	 		Date opdDate = (Date)patientHistoryLp[0];
	 		presentComplaintsLp = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			if(patientHistoryLp[1] != null && !patientHistoryLp[1].equals("")){
			presentComplaintsLp += "Presenting complaints for leprosy	:	"+(String)patientHistoryLp[1];
			}
 			if(patientHistoryLp[2] != null && !patientHistoryLp[2].equals("")){
 			presentComplaintsLp += "Duration for leprosy	:	"+(BigDecimal)patientHistoryLp[2]+"<div class='clear'></div>";
			}
			if(patientHistoryLp[3] != null && !patientHistoryLp[3].equals("")){
			presentComplaintsLp += "Duration parameter leprosy	:	"+(String)patientHistoryLp[3]+"<div class='clear'></div>";
			}
	 	}
	}
	
	
	String historyLp = "";
 	if(historyList.size()>0){
		for(Object[] patientHistoryListLp :historyList){
	 		Date opdDate = (Date)patientHistoryListLp[0];
	 		historyLp = HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			if(patientHistoryListLp[1] != null && !patientHistoryListLp[1].equals("")){
				historyLp += "Tb	:	"+(String)patientHistoryListLp[1];
			}
		 	if(patientHistoryListLp[2] != null && !patientHistoryListLp[2].equals("")){
	 			historyLp += "Hypertension	:	"+(String)patientHistoryListLp[2]+"<div class='clear'></div>";
			}
			if(patientHistoryListLp[3] != null && !patientHistoryListLp[3].equals("")){
				historyLp += "Diabetes	:	"+(String)patientHistoryListLp[3]+"<div class='clear'></div>";
			}
			if(patientHistoryListLp[4] != null && !patientHistoryListLp[4].equals("")){
				historyLp += "Cardiac	:	"+(String)patientHistoryListLp[4]+"<div class='clear'></div>";
			}
			if(patientHistoryListLp[5] != null && !patientHistoryListLp[5].equals("")){
				historyLp += "Hepatic	:	"+(String)patientHistoryListLp[5]+"<div class='clear'></div>";
			}
			if(patientHistoryListLp[6] != null && !patientHistoryListLp[6].equals("")){
				historyLp += "Rental	:	"+(String)patientHistoryListLp[6]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[7] != null && !patientHistoryListLp[7].equals("")){
				historyLp += "Past history others	:	"+(String)patientHistoryListLp[7]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[8] != null && !patientHistoryListLp[8].equals("")){
				historyLp += "Past history other value	:	"+(String)patientHistoryListLp[8]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[9] != null && !patientHistoryListLp[9].equals("")){
				historyLp += "History of epistaxis	:	"+(String)patientHistoryListLp[9]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[10] != null && !patientHistoryListLp[10].equals("")){
				historyLp += "Epistaxis present relation	:	"+(String)patientHistoryListLp[10]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[11] != null && !patientHistoryListLp[11].equals("")){
				historyLp += "family history of leprosy	:	"+(String)patientHistoryListLp[11]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[12] != null && !patientHistoryListLp[12].equals("")){
				historyLp += "family history relation	:	"+(String)patientHistoryListLp[12]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[13] != null && !patientHistoryListLp[13].equals("")){
				historyLp += "family members affeted	:	"+(String)patientHistoryListLp[13]+"<div class='clear'></div>";
			}
		 	if(patientHistoryListLp[14] != null && !patientHistoryListLp[14].equals("")){
				historyLp += "history of leprosy neighbours	:	"+(String)patientHistoryListLp[14]+"<div class='clear'></div>";
			}	
		 	if(patientHistoryListLp[15] != null && !patientHistoryListLp[15].equals("")){
				historyLp += "Leprosy neighbours value	:	"+(String)patientHistoryListLp[14]+"<div class='clear'></div>";
			}	
		 	if(patientHistoryListLp[15] != null && !patientHistoryListLp[15].equals("")){
				historyLp += "Previous history leprosy	:	"+(String)patientHistoryListLp[14]+"<div class='clear'></div>";
			}	
		 	if(patientHistoryListLp[16] != null && !patientHistoryListLp[16].equals("")){
				historyLp += "Treatment of leprosy present value	:	"+(String)patientHistoryListLp[16]+"<div class='clear'></div>";
			}	
		}
	}
 	
 	
 		//Date opdDate = null;
		String opdSDate = "";
	  	String primaryLp="";    
		if(opdDermLpsyProExm.size()>0){
			for(OpdDermatologicalLeprosyExamination opdLpPrExm :opdDermLpsyProExm){
				primaryLp = HMSUtil.convertStringDateFormat(opdLpPrExm.getLeprosyProforma().getOpdPatientDetails().getOpdDate().toString())+"<div class='clear'></div>";
	if(opdLpPrExm.getLesion() != null && !opdLpPrExm.getLesion().equals("")) {
	primaryLp += "Lesion--"+(String)opdLpPrExm.getLesion()+"<div class='clear'></div>";
	}
	if(opdLpPrExm.getEarLobe() != null && !opdLpPrExm.getEarLobe().equals("")) {
	primaryLp += "EarLobe--"+(String)opdLpPrExm.getEarLobe()+"<div class='clear'></div>";
	}
	if(opdLpPrExm.getMadarosis() != null && !opdLpPrExm.getMadarosis().equals("")) {
	primaryLp += "Madarosis--"+(String)opdLpPrExm.getMadarosis()+"<div class='clear'></div>";
	}
 
	if(opdLpPrExm.getFace() != null && !opdLpPrExm.getFace().equals("")) {
	primaryLp += "Face--"+(String)opdLpPrExm.getFace()+"<div class='clear'></div>";
	}
	if(opdLpPrExm.getUpperLimb() != null && !opdLpPrExm.getUpperLimb().equals("")) {
	primaryLp += "UpperLimb--"+(String)opdLpPrExm.getUpperLimb()+"<div class='clear'></div>";
	}
	if(opdLpPrExm.getAnteriorTrunk() != null && !opdLpPrExm.getAnteriorTrunk().equals("")) {
	primaryLp += "AnteriorTrunk--"+(String)opdLpPrExm.getAnteriorTrunk()+"<div class='clear'></div>";
	}
 
	if(opdLpPrExm.getPosteriorTrunk() != null && !opdLpPrExm.getPosteriorTrunk().equals("")) {
	primaryLp += "PosteriorTrunk--"+(String)opdLpPrExm.getPosteriorTrunk()+"<div class='clear'></div>";
	}
	if(opdLpPrExm.getLowerLimb() != null && !opdLpPrExm.getLowerLimb().equals("")) {
	primaryLp += "LowerLimb--"+(String)opdLpPrExm.getLowerLimb()+"<div class='clear'></div>";
			}
		}	
	}
		
		
		//Date opdDate = null;
		//String opdSDate = "";
	  	String secondaryLp="";    
		if(opdDermLpsyProNerveExm.size()>0){
			for(OpdDermatologicalNerveExamination opdLpPrNrExm :opdDermLpsyProNerveExm){
				secondaryLp = HMSUtil.convertStringDateFormat(opdLpPrNrExm.getLeprosyProforma().getOpdPatientDetails().getOpdDate().toString())+"<div class='clear'></div>";
	if(opdLpPrNrExm.getRightNerve() != null && !opdLpPrNrExm.getRightNerve().equals("")) {
	secondaryLp += "RightNerve--"+(String)opdLpPrNrExm.getRightNerve()+"<div class='clear'></div>";
	}
	if(opdLpPrNrExm.getLeftNerve() != null && !opdLpPrNrExm.getLeftNerve().equals("")) {
	secondaryLp += "LeftNerve--"+(String)opdLpPrNrExm.getLeftNerve()+"<div class='clear'></div>";
	}
	if(opdLpPrNrExm.getFlag() != null && !opdLpPrNrExm.getFlag().equals("")) {
	secondaryLp += "Flag--"+(String)opdLpPrNrExm.getFlag()+"<div class='clear'></div>";
	}
  	if(opdLpPrNrExm.getSite() != null && !opdLpPrNrExm.getSite().equals("")) {
	secondaryLp += "Site--"+(String)opdLpPrNrExm.getSite()+"<div class='clear'></div>";
	}
	if(opdLpPrNrExm.getTemperature() != null && !opdLpPrNrExm.getTemperature().equals("")) {
	secondaryLp += "Temperature--"+(String)opdLpPrNrExm.getTemperature()+"<div class='clear'></div>";
	}
	if(opdLpPrNrExm.getTouch() != null && !opdLpPrNrExm.getTouch().equals("")) {
	secondaryLp += "Touch--"+(String)opdLpPrNrExm.getTouch()+"<div class='clear'></div>";
	}
  	if(opdLpPrNrExm.getPain() != null && !opdLpPrNrExm.getPain().equals("")) {
	secondaryLp += "Pain--"+(String)opdLpPrNrExm.getPain()+"<div class='clear'></div>";
			}
	 	}	
	}
%>

<label>Previous Complaints</label>
<div class="summaryDetails">  
<b>General Proforma</b>
<p><%=presentComplaintsGp %></p>
<hr><b>Leprosy Proforma</b>
<p><%=presentComplaintsLp%></p>
</div>
</div>

<div class="summaryDivMain">
<label>History</label>
<div class="summaryDetails">
<b>General Proforma</b>
<p><%=historyGp%></p>
<hr><b>Leprosy Proforma</b>
<p><%=historyLp%></p>
</div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Primary Lesion</label>
<div class="summaryDetails">
<b>General Proforma</b>
<p><%=firstLesion %></p>
<hr><b>Leprosy Proforma</b>
<p><%=primaryLp %></p>


</div>
</div>

<div class="summaryDivMain">
<label>Seconday Lesion</label>
<div class="summaryDetails">
<b>General Proforma</b>
<p><%=secondLesion %></p>
<hr><b>Leprosy Proforma</b>
<p><%=secondaryLp %></p>
</div>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Findings</label>
<div class="summaryDetails"><p>
<b>General Proforma</b>
<%=findingGp %></p>
</div>
</div>
</div>


</body>
</html>