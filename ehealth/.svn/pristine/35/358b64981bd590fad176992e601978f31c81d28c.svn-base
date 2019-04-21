<%@page import="jkt.hms.masters.business.ExternalAdmissionDetails"%>
<%@page import="jkt.hms.util.ComparatorForLabTestDate"%>
<%@page import="jkt.hms.masters.business.ExternalLabReportCommon"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalUsg"%>
<%@page import="org.syntax.jedit.InputHandler.document_end"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardTrimester"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardMedicalHistory"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCardPregnancy"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.CommonLabTestReport"%>

<script>jQuery.noConflict();
jQuery(function($) {
	
    function split( val ) {
        return val.split( /,\s*/ );
    }
    function extractLast( term ) {
        return split( term ).pop();
    }
    
  
	$( ".historyAutoComplete" )
    .autocomplete({
	    minLength: 1,
		source: function( request, response ) {
            // delegate back to autocomplete, but extract the last term
			var arTerm=request.term.split(",");
			var searchTerm=arTerm[arTerm.length-1].trim();
			console.log("terms :: "+searchTerm);
			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;
			var refsetidParam = document.getElementById('refsetId').value;
			servURL +="?term="+searchTerm+"&state=active&semantictag=all&acceptability=all&returnlimit=10&refsetid="+refsetidParam;
            $.getJSON(servURL,
            		function (data)
			{ 
            	var array = data.error ? [] : $.map(data, function(m) {
					return {
						label: m.term ,
						 value:  m.conceptId 
					};
				});
				response(array);
			
            });
        },
        focus: function() {
            // prevent value inserted on focus
            return false;
        },
        select: function( event, ui ) {
            var terms = split( this.value );
         	// remove the current input
            terms.pop();
          
            terms.push( ui.item.label );
            // add placeholder to get the comma-and-space at the end
            terms.push( "" );
            var snomedCount =   $('#snomedCount').val();
            snomedCount = parseInt(snomedCount)+1;
            $('#snomedCount').val(snomedCount) ;
           
            var fieldType = $(this).prev().text().replace(/\s+/g," ");
       		if(fieldType == 'GIS'){
       			fieldType = 'Systemic Examination';
       		}
           $('#termTable').append("<input type='text' name ='snomedId"+snomedCount+"' value ='"+ui.item.value+"' />"+"<input type='text' name ='snomedDesc"+snomedCount+"' value ='"+ui.item.label+"'/><input type='text' name ='fieldType"+snomedCount+"' value ='"+fieldType+"'/>");
       /*    $('#termTable').append("<tr>");
          $('#termTable').append("<td><input type='text' name ='termValue' value ='"+ui.item.value+"' /></td>");
          $('#termTable').append("<td><input type='text' name ='termLabel' value ='"+ui.item.label+"'/></td>");
          $('#termTable').append("<td><input type='text' name ='termType' value ='Present Complaint'/></td>");
          $('#termTable').append("</tr>"); */
           	
       		 $("#termTable td").each(function () {
       		    var tdText = $(this).text();
       		    $("#termTable td").filter(function () { 
       		            return tdText == $(this).text(); 
       		        }).not(":first").remove();
       		});
		   
            this.value = terms.join( "," );
            return false;
        }
    });
});
</script>

<Script>
function toggleCalender(checkboxId,toggleID)
{
	 var checkbox = document.getElementById(checkboxID);
	  var toggle = document.getElementById(toggleID);
	  updateToggle = checkbox.checked ? toggle.disabled=true : toggle.disabled=false;
}


function openPopupWindowAllergyForLP(csrf)  {
	var requestId = document.getElementById("requestId").value.trim();

	window
			.open(
					"/hms/hms/ot?method=showAllergy&requestId=" + requestId
							+ "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue + "&LP=y",
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}

</script>



<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
		month="0"+month;
		}
		if(getDate.length()<2){
		getDate="0"+getDate;
		}

        session.removeAttribute("prevPregnancyDt");
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		

		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String templateName= "Antenatal Card";
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		List<String> riskList = new ArrayList<String>();
		int exist=0,antCardId=0;
		int waistValue=0,hipValue=0;
		String menarche="";		 
		String Cycle="",Cycle1="",Cycle2="",Cycle3="",cycleFlow="", day="",day1="",day2="",day3="",lmp=null,unknownLmpStatus=null, edd=null,scannedEdc=null,gravida="",para="",abortion="",live="",ectopic="",vesicular="",mtp="",iud="",stillBirth="",nnd="",medicalDisor="",edcDate=null;
		String years="",months="";
		String ocps="",ppiucd="",tubalLigation="",vasectomy="",condom="",intervalIUCD="",fpLam="",fpNone="";
		String respSystem="",cvs="",ftAdvise="",ftDate="";
		String othersFirstTrimster = "";
		String  d2Weight="",d2Height="",d2Bmi="",bmiStatus="",d2Thyroid="",d2Breast="",d2Nipple="";
		String consanguineousYes="",degree="",infertilityYes="",factor="",infertilityDetails="";
		String comorbidity="",comYears="",comMonths="",comRemarks="",comChronicDis="",comOtherDis="";
		String infections="",infectionYears="",infectionMonths="",infectionRemarks="";
		String surgicalHistory="",familyHistory="",personalHistory="";
		String firstDose = "", secondDose = ""; String gestationalAgeDays = ""; String gestationalAgeWeeks = ""; String maritalStatus=""; String durationOfMarriageYear = "", other="";
		String marritalHistoryRemarks = "";
		String durationOfMarriageMonth = "";
		String referredFromPrivate = "";
		String referredFromPrivateValue = "",pallorGenExam="",icterusGenExam="",clubbing="",cyanosisGenExam="",edemaGenExam="",SpineGenExam=null,gaitGenExam="",lymphadenopathyGenExam="",lymphadenopathyValueGenExam="",otherGenExam="",obstetricComplications = "",obstetricValues = "";
		String otherImmunizationDetail = "";
		String dateUsgReport = "";Date dateUsgOne =null;Date dateUsgTwo = null;Date dateUsgThree = null;String lmpGaUsgReport = "";String lmpGaOne = "";	String lmpGaTwo = "";
		String lmpGaThree = "";String usgGaUsgReport = "";String usgGaOne = "";String usgGaTwo = "";String usgGaThree = "";String afiUsgReport = "";String afiOne = "";String afiTwo = "";
		String afiThree = "";String bppUsgReport = "";String bppOne = "";String bppTwo = "";String bppThree = "";String bpdUsgReport = "";String bpdOne = "";String bpdTwo = "";
		String bpdThree = "";	String flUsgReport = "";String flOne = "";String flTwo = "";String flThree = "";String acUsgReport = "";String acOne = "";String acTwo = "";
		String acThree = "";String hcUsgReport = "";String hcOne = "";	String hcTwo = "";String hcThree = "";	String ebwUsgReport = "";String ebwOne = "";String ebwTwo = "";
		String ebwThree = "";String dopplerUsgReport = "";String dopplerOne = "";String dopplerTwo = "";String dopplerThree = "";String usgRemarks = "";String usgSecondRemarks = "";String usgThirdRemarks = "";
		String reffredHospital=""; String refferedGA="";
		int patAge=0;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		String lastPrescription =null;
		if (map.get("lastPrescriptionStr") != null) {
			lastPrescription = (String) map.get("lastPrescriptionStr");
		}
		
		
		 if (map.get("sexList") != null)
	       {
	               sexList = (List<MasAdministrativeSex>) map.get("sexList");
	       }
		 if (map.get("exist") != null)
	       {
	               exist = (Integer)map.get("exist");
	       }
		
		 String allergyStr ="";
			if(map.get("allergyStr") != null)
			{
				allergyStr=(String)map.get("allergyStr");
			}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String dateC = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		
		List<OpdPatientAllergyT>opdPatientAllergyTs= new ArrayList<OpdPatientAllergyT>();
		if(map.get("opdPatientAllergyTs") != null)
		{
			opdPatientAllergyTs=(List<OpdPatientAllergyT>)map.get("opdPatientAllergyTs");
		}	

		List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
		if(map.get("allergyProductsList") != null){
			allergyProductsList=(List)map.get("allergyProductsList");
		}
		
		 List patientDataList = new ArrayList();
		 List<OpdAntenatalUsg> usgFirstTrimList= new ArrayList<OpdAntenatalUsg>();
		 List<OpdAntenatalUsg> usgFirstTrimListWeek14= new ArrayList<OpdAntenatalUsg>();
		 List<OpdAntenatalUsg> usgSecondTrimList= new ArrayList<OpdAntenatalUsg>();
		 List<OpdAntenatalUsg> usgThirdTrimList= new ArrayList<OpdAntenatalUsg>();
		 List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		 List<DgResultEntryHeader>dgResultHeaderDetailsListForFirstTrim = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader>dgResultHeaderDetailsListForSecondTrim = new ArrayList<DgResultEntryHeader>();
		List<DgResultEntryHeader>dgResultHeaderDetailsListForThirdTrim = new ArrayList<DgResultEntryHeader>();
		List<ExternalLabReportCommon> externalLabListCommonFirstTrim = new ArrayList<ExternalLabReportCommon>();
		List<ExternalLabReportCommon> externalLabListCommonSecondTrim = new ArrayList<ExternalLabReportCommon>();
		List<ExternalLabReportCommon> externalLabListCommonThirdTrim = new ArrayList<ExternalLabReportCommon>();
		List<Inpatient> ipAdmissionList = new ArrayList<Inpatient>();
		List<Inpatient> managementList = new ArrayList<Inpatient>();
		List<Inpatient> diagnosisList = new ArrayList<Inpatient>();
		List<Inpatient> adviceList = new ArrayList<Inpatient>();
		List<ExternalAdmissionDetails> admissionDetailsList = new ArrayList<ExternalAdmissionDetails>();
		
		
		List<OpdAntenatalUsg> usgFirstTrimDateListFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimDateListSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimDateListThirdVisit= new ArrayList<OpdAntenatalUsg>();
		
		List<OpdAntenatalUsg> usgFirstTrimMeanSacFirstVisitList= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimMeanSacSecondVisitList= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimMeanSacThirdVisitList= new ArrayList<OpdAntenatalUsg>();	
		
		
		List<OpdAntenatalUsg> usgFirstTrimYolkSacFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimYolkSacSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimYolkSacThirdVisit= new ArrayList<OpdAntenatalUsg>();
		
		
		List<OpdAntenatalUsg> usgFirstTrimFetalPoleFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimFetalPoleSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimFetalPoleThirdVisit= new ArrayList<OpdAntenatalUsg>();


		List<OpdAntenatalUsg> usgFirstTrimFetalHeartFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimFetalHeartSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimFetalHeartThirdVisit= new ArrayList<OpdAntenatalUsg>();


		List<OpdAntenatalUsg> usgFirstTrimCrownRumpFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimCrownRumpSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimCrownRumpThirdVisit= new ArrayList<OpdAntenatalUsg>();

		List<OpdAntenatalUsg> usgFirstTrimScanEDCFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimScanEDCSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimScanEDCThirdVisit= new ArrayList<OpdAntenatalUsg>();


		List<OpdAntenatalUsg> usgFirstTrimRemarksFirstVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimRemarksSecondVisit= new ArrayList<OpdAntenatalUsg>();
		List<OpdAntenatalUsg> usgFirstTrimRemarksThirdVisit= new ArrayList<OpdAntenatalUsg>();
		
		
		//USG (10-14 Weeks) changes	start
		
List<OpdAntenatalUsg> usgFirstTrimGrid2DateListFirstVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid2DateListSecondVisit= new ArrayList<OpdAntenatalUsg>();
List<OpdAntenatalUsg> usgFirstTrimGrid2DateListThirdVisit= new ArrayList<OpdAntenatalUsg>();


	   //USG (10-14 Weeks) changes	End
		 
	 if(map.get("dgResultHeaderDetailsListForFirstTrim") != null){
		 dgResultHeaderDetailsListForFirstTrim=(List)map.get("dgResultHeaderDetailsListForFirstTrim");
	 }
	 if(map.get("dgResultHeaderDetailsListForSecondTrim") != null){
		 dgResultHeaderDetailsListForSecondTrim=(List)map.get("dgResultHeaderDetailsListForSecondTrim");
	 }
	 if(map.get("dgResultHeaderDetailsListForThirdTrim") != null){
		 dgResultHeaderDetailsListForThirdTrim=(List)map.get("dgResultHeaderDetailsListForThirdTrim");
	 }
		
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList=(List)map.get("bloodGroupList");
	}
	
	if(map.get("usgFirstTrimList") != null){
		usgFirstTrimList=(List)map.get("usgFirstTrimList");
	}
	if(map.get("usgSecondTrimList") != null){
		usgSecondTrimList=(List)map.get("usgSecondTrimList");
	}
	if(map.get("usgFirstTrimListWeeks14") != null){
		usgFirstTrimListWeek14=(List<OpdAntenatalUsg>)map.get("usgFirstTrimListWeeks14");
	}
	
	// changes for usg
	
	if(map.get("usgFirstTrimDateListFirstVisit") != null){
		usgFirstTrimDateListFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimDateListFirstVisit");
	}
	request.setAttribute("usgFirstTrimDateListFirstVisit", usgFirstTrimDateListFirstVisit);
	
	if(map.get("usgFirstTrimDateListSecondVisit") != null){
		usgFirstTrimDateListSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimDateListSecondVisit");
	}
	request.setAttribute("usgFirstTrimDateListSecondVisit", usgFirstTrimDateListSecondVisit);
	
	if(map.get("usgFirstTrimDateListThirdVisit") != null){
		usgFirstTrimDateListThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimDateListThirdVisit");
	}
	
	request.setAttribute("usgFirstTrimDateListThirdVisit", usgFirstTrimDateListThirdVisit);
	
	if(map.get("usgFirstTrimMeanSacFirstVisitList") != null){
		usgFirstTrimMeanSacFirstVisitList=(List<OpdAntenatalUsg>)map.get("usgFirstTrimMeanSacFirstVisitList");
	}
	
	request.setAttribute("usgFirstTrimMeanSacFirstVisitList", usgFirstTrimMeanSacFirstVisitList);
	
	if(map.get("usgFirstTrimMeanSacSecondVisitList") != null){
		usgFirstTrimMeanSacSecondVisitList=(List<OpdAntenatalUsg>)map.get("usgFirstTrimMeanSacSecondVisitList");
	}
	request.setAttribute("usgFirstTrimMeanSacSecondVisitList", usgFirstTrimMeanSacSecondVisitList);
	
	if(map.get("usgFirstTrimMeanSacThirdVisitList") != null){
		usgFirstTrimMeanSacThirdVisitList=(List<OpdAntenatalUsg>)map.get("usgFirstTrimMeanSacThirdVisitList");
	}
	request.setAttribute("usgFirstTrimMeanSacThirdVisitList", usgFirstTrimMeanSacThirdVisitList);
	
	if(map.get("usgFirstTrimYolkSacFirstVisit") != null){
		usgFirstTrimYolkSacFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimYolkSacFirstVisit");
	}
	if(map.get("usgFirstTrimYolkSacSecondVisit") != null){
		usgFirstTrimYolkSacSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimYolkSacSecondVisit");
	}
	if(map.get("usgFirstTrimYolkSacThirdVisit") != null){
		usgFirstTrimYolkSacThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimYolkSacThirdVisit");
	}
	//----
	
	if(map.get("usgFirstTrimFetalPoleFirstVisit") != null){
		usgFirstTrimFetalPoleFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalPoleFirstVisit");
	}
	if(map.get("usgFirstTrimFetalPoleSecondVisit") != null){
		usgFirstTrimFetalPoleSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalPoleSecondVisit");
	}
	if(map.get("usgFirstTrimFetalPoleThirdVisit") != null){
		usgFirstTrimFetalPoleThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalPoleThirdVisit");
	}
	
	//---
	
	if(map.get("usgFirstTrimFetalHeartFirstVisit") != null){
		usgFirstTrimFetalHeartFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalHeartFirstVisit");
	}
	if(map.get("usgFirstTrimFetalHeartSecondVisit") != null){
		usgFirstTrimFetalHeartSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalHeartSecondVisit");
	}
	if(map.get("usgFirstTrimFetalHeartThirdVisit") != null){
		usgFirstTrimFetalHeartThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimFetalHeartThirdVisit");
	}
	
	//---	
		if(map.get("usgFirstTrimCrownRumpFirstVisit") != null){
			usgFirstTrimCrownRumpFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimCrownRumpFirstVisit");
		}
		if(map.get("usgFirstTrimCrownRumpSecondVisit") != null){
			usgFirstTrimCrownRumpSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimCrownRumpSecondVisit");
		}
		if(map.get("usgFirstTrimCrownRumpThirdVisit") != null){
			usgFirstTrimCrownRumpThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimCrownRumpThirdVisit");
		}
		//---	
			if(map.get("usgFirstTrimScanEDCFirstVisit") != null){
				usgFirstTrimScanEDCFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimScanEDCFirstVisit");
			}
			if(map.get("usgFirstTrimScanEDCSecondVisit") != null){
				usgFirstTrimScanEDCSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimScanEDCSecondVisit");
			}
			if(map.get("usgFirstTrimScanEDCThirdVisit") != null){
				usgFirstTrimScanEDCThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimScanEDCThirdVisit");
			}	
			
		//---	
		if(map.get("usgFirstTrimRemarksFirstVisit") != null){
			usgFirstTrimRemarksFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimRemarksFirstVisit");
		}
		if(map.get("usgFirstTrimRemarksSecondVisit") != null){
			usgFirstTrimRemarksSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimRemarksSecondVisit");
		}
		if(map.get("usgFirstTrimRemarksThirdVisit") != null){
			usgFirstTrimRemarksThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimRemarksThirdVisit");
		}
		
		String revisitFlag="";
		if(map.get("revisitFlag") != null){
			revisitFlag=(String)map.get("revisitFlag");
		}
		request.setAttribute("revisitFlag", revisitFlag);
		
		String revisitFlagSecondGrid="";
		if(map.get("revisitFlagSecondGrid") != null){
			revisitFlagSecondGrid=(String)map.get("revisitFlagSecondGrid");
		}
		String revisitFlagSecondTrim="";
		if(map.get("revisitFlagSecondTrim") != null){
			revisitFlagSecondTrim=(String)map.get("revisitFlagSecondTrim");
		}
		String revisitFlagThirdTrim="";
		if(map.get("revisitFlagThirdTrim") != null){
			revisitFlagThirdTrim=(String)map.get("revisitFlagThirdTrim");
		}
		
		request.setAttribute("revisitFlagSecondTrim", revisitFlagSecondTrim);
		request.setAttribute("revisitFlagThirdTrim", revisitFlagThirdTrim);
		
//--10-24Weeks


if(map.get("usgFirstTrimGrid2DateListFirstVisit") != null){
	usgFirstTrimGrid2DateListFirstVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListFirstVisit");
}

if(map.get("usgFirstTrimGrid2DateListSecondVisit") != null){
	usgFirstTrimGrid2DateListSecondVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListSecondVisit");
}
if(map.get("usgFirstTrimGrid2DateListThirdVisit") != null){
	usgFirstTrimGrid2DateListThirdVisit=(List<OpdAntenatalUsg>)map.get("usgFirstTrimGrid2DateListThirdVisit");
}


//end
	if(map.get("usgThirdTrimList") != null){
		usgThirdTrimList=(List)map.get("usgThirdTrimList");
	}

	if(map.get("externalLabListCommonFirstTrim") != null){
		externalLabListCommonFirstTrim=(List)map.get("externalLabListCommonFirstTrim");
	}
	if(map.get("externalLabListCommonSecondTrim") != null){
		externalLabListCommonSecondTrim=(List)map.get("externalLabListCommonSecondTrim");
	}
	if(map.get("externalLabListCommonThirdTrim") != null){
		externalLabListCommonThirdTrim=(List)map.get("externalLabListCommonThirdTrim");
	}
	
	List<Object[]> usgFirstTrimusgParameterList = new ArrayList<Object[]>();
	List<Object[]> usgFirstTrimusgParameterValue3List = new ArrayList<Object[]>();
	List<Object[]> usgFirstTrimusgParameterValue1List = new ArrayList<Object[]>();
	List<Object[]> usgFirstTrimusgParameterValue2List = new ArrayList<Object[]>();
	
	if(map.get("usgFirstTrimusgParameterValue3List") != null){
		usgFirstTrimusgParameterValue3List=(List<Object[]>)map.get("usgFirstTrimusgParameterValue3List");
	}
	
	
	if(map.get("usgFirstTrimusgParameterValue2List") != null){
		usgFirstTrimusgParameterValue2List=(List<Object[]>)map.get("usgFirstTrimusgParameterValue2List");
	}
	
	
	if(map.get("usgFirstTrimusgParameterValue1List") != null){
		usgFirstTrimusgParameterValue1List=(List<Object[]>)map.get("usgFirstTrimusgParameterValue1List");
	}
	request.setAttribute("usgFirstTrimusgParameterValue1List", usgFirstTrimusgParameterValue1List);
	request.setAttribute("usgFirstTrimusgParameterValue2List", usgFirstTrimusgParameterValue2List);
	request.setAttribute("usgFirstTrimusgParameterValue3List", usgFirstTrimusgParameterValue3List);
	
	List<OpdAntenatalUsg> usgFlagList= new ArrayList<OpdAntenatalUsg>();
	List<OpdAntenatalUsg> secondGridUsgFlagList= new ArrayList<OpdAntenatalUsg>();
	
	if(map.get("usgFlagList") != null){
		usgFlagList=(List<OpdAntenatalUsg>)map.get("usgFlagList");
	}
	
	List<OpdAntenatalUsg> usgFlagThirdTrimList= new ArrayList<OpdAntenatalUsg>();
	if(map.get("usgFlagThirdTrimList") != null){
		usgFlagThirdTrimList=(List<OpdAntenatalUsg>)map.get("usgFlagThirdTrimList");
	}
	List<OpdAntenatalUsg> usgFlagSecondTrimList= new ArrayList<OpdAntenatalUsg>();
	if(map.get("usgFlagSecondTrimList") != null){
		usgFlagSecondTrimList=(List<OpdAntenatalUsg>)map.get("usgFlagSecondTrimList");
	}
	if(map.get("secondGridUsgFlagList") != null){
		secondGridUsgFlagList=(List<OpdAntenatalUsg>)map.get("secondGridUsgFlagList");
	}
	
	
	List<OpdAntenatalUsg> usgThirdTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
	List<OpdAntenatalUsg>  usgThirdTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
	List<OpdAntenatalUsg>  usgThirdTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();
	if(map.get("usgThirdTrimFirstVisitList") != null){
		usgThirdTrimFirstVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimFirstVisitList");
	}
	if(map.get("usgThirdTrimSecondVisitList") != null){
		usgThirdTrimSecondVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimSecondVisitList");
	}
	if(map.get("usgThirdTrimThirdVisitList") != null){
		usgThirdTrimThirdVisitList=(List<OpdAntenatalUsg>)map.get("usgThirdTrimThirdVisitList");
	}
	
	List<OpdAntenatalUsg> usgSecondTrimFirstVisitList= new ArrayList<OpdAntenatalUsg>();
	List<OpdAntenatalUsg>  usgSecondTrimSecondVisitList= new ArrayList<OpdAntenatalUsg>();
	List<OpdAntenatalUsg>  usgSecondTrimThirdVisitList= new ArrayList<OpdAntenatalUsg>();
	
	if(map.get("usgSecondTrimFirstVisitList") != null){
		usgSecondTrimFirstVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimFirstVisitList");
	}
	if(map.get("usgSecondTrimSecondVisitList") != null){
		usgSecondTrimSecondVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimSecondVisitList");
	}
	if(map.get("usgSecondTrimThirdVisitList") != null){
		usgSecondTrimThirdVisitList=(List<OpdAntenatalUsg>)map.get("usgSecondTrimThirdVisitList");
	}
	if(map.get("admissionDetailsList") != null){
		admissionDetailsList=(List)map.get("admissionDetailsList");
	 }
	
	StringBuilder ipAdmissionDetailText=new StringBuilder();
	
	if(admissionDetailsList.size()>0){
		for(ExternalAdmissionDetails admissionDetails:admissionDetailsList){			
			if(admissionDetails.getDateOfAdmission()!= null && !admissionDetails.getDateOfAdmission().equals("")) {
				String ipDateOfAdmission = admissionDetails.getDateOfAdmission();
				String ipNo = admissionDetails.getIpNo();
				String ipDiagnosis = admissionDetails.getDiagnosis();
				String ipManagement = admissionDetails.getManagement();
				String ipAdvice = admissionDetails.getAdvice();
				String ipDateOfDischarge = admissionDetails.getDateOfDischarge();
			//	ipAdmissionDetailText.append("<br/>Date Of Admission:<b> "+infection+"</b>");
				
				if(ipDateOfAdmission !=null && !ipDateOfAdmission.equals(""))
					ipAdmissionDetailText.append("<b>Date Of Admission: </b>"+ipDateOfAdmission);
				
				if(ipNo !=null && !ipNo.equals(""))
					ipAdmissionDetailText.append(" <b>IP No: </b>"+ipNo);
				
				if(ipDiagnosis !=null && !ipDiagnosis.equals(""))
					ipAdmissionDetailText.append(" <b>Diagnosis: </b>"+ipDiagnosis);
				
				if(ipManagement !=null && !ipManagement.equals(""))
					ipAdmissionDetailText.append(" <b>Management: </b>"+ipManagement);
				
				if(ipAdvice !=null && !ipAdvice.equals(""))
					ipAdmissionDetailText.append(" <b>Advice: </b>"+ipAdvice);
				
				if(ipDateOfDischarge !=null && !ipDateOfDischarge.equals(""))
					ipAdmissionDetailText.append(" <b>Date Of Discharge: </b>"+ipDateOfDischarge);
				
			}
			ipAdmissionDetailText.append("<br/>");
			}
			}
	
	
	
	/* Date lmpDate=null;
	if(map.get("lmpDt") != null){
		lmpDate=(Date)map.get("lmpDt");
	}
	String lmpDate1 = "";
	if(lmpDate !=null && !lmpDate.equals("")){
		Calendar c1 = Calendar.getInstance();
		c1.setTime(lmpDate);    
		System.out.println("Week number:" +   c1.get(Calendar.WEEK_OF_YEAR)); 
	   lmpDate1=HMSUtil.convertDateToStringWithoutTime(lmpDate);
	   System.out.println("lmpDate1:" + lmpDate1);
	} */
	String usgFlag="";
	if(usgFlagList.size() >0){
	for(OpdAntenatalUsg usgFlagS:usgFlagList){
	usgFlag = usgFlagS.getUsgFlag();
	}
	request.setAttribute("usgFlag", usgFlag);
	}
	
	String usgThirdTrimFlag="";
	if(usgFlagThirdTrimList.size() >0){
	for(OpdAntenatalUsg usgThirdTrimFlagObj:usgFlagThirdTrimList){
		usgThirdTrimFlag = usgThirdTrimFlagObj.getUsgFlag();
	}}
	
	request.setAttribute("usgSecondTrimFirstVisitList", usgSecondTrimFirstVisitList);
	request.setAttribute("usgSecondTrimSecondVisitList", usgSecondTrimSecondVisitList);
	request.setAttribute("usgSecondTrimThirdVisitList", usgSecondTrimThirdVisitList);
	request.setAttribute("usgThirdTrimFlag", usgThirdTrimFlag);
	
	
	String usgSecondTrimFlag="";
	if(usgFlagSecondTrimList.size() >0){
	for(OpdAntenatalUsg usgSecondTrimFlagObj:usgFlagSecondTrimList){
		usgSecondTrimFlag = usgSecondTrimFlagObj.getUsgFlag();
	}}
	
	request.setAttribute("usgThirdTrimFirstVisitList", usgThirdTrimFirstVisitList);
	request.setAttribute("usgThirdTrimSecondVisitList", usgThirdTrimSecondVisitList);
	request.setAttribute("usgThirdTrimThirdVisitList", usgThirdTrimThirdVisitList);
	request.setAttribute("usgSecondTrimFlag", usgSecondTrimFlag);
	
	String usgFlagSecondGrid="";
	
	if(secondGridUsgFlagList.size() >0){
		for(OpdAntenatalUsg usgFlagSgrid:secondGridUsgFlagList){
			usgFlagSecondGrid = usgFlagSgrid.getUsgFlag();
		}
		}
	
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	//first trimester Lab test combined Start
	
	List<CommonLabTestReport> commonLabTestReports = new ArrayList();
	
	if(dgResultHeaderDetailsListForFirstTrim.size() > 0){
		
		for(DgResultEntryHeader dgResultEntryHeaderFirstTrim :dgResultHeaderDetailsListForFirstTrim)
		{   
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
			
			 if (dgResultEntryHeaderFirstTrim.getDgResultEntryDetails().size() > 0) {
				dgResultEntryDetail = dgResultEntryHeaderFirstTrim.getDgResultEntryDetails().iterator().next();
										commonLabTestReport.setDgId((Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId());
			} 
			 
			commonLabTestReport.setInvestigationId(dgResultEntryHeaderFirstTrim.getInvestigation().getId());
			commonLabTestReport.setResultDate(dgResultEntryHeaderFirstTrim.getResultDate().toString());
			commonLabTestReport.setResultTime(dgResultEntryHeaderFirstTrim.getVerifiedTime().toString());
			commonLabTestReport.setTestName(dgResultEntryHeaderFirstTrim.getInvestigation().getInvestigationName());
		    commonLabTestReport.setTestType("Internal Test");
			commonLabTestReports.add(commonLabTestReport);
		}
		
	}
	
	int firstTrimLabResultSize=0;
	firstTrimLabResultSize = externalLabListCommonFirstTrim.size();	
	if(externalLabListCommonFirstTrim.size() > 0)
	{
		for(ExternalLabReportCommon externalList:externalLabListCommonFirstTrim){
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			commonLabTestReport.setResultDate(externalList.getTestDate().toString());
			commonLabTestReport.setResultTime(externalList.getTestTime() != null?externalList.getTestTime().toString():"");
			commonLabTestReport.setTestName(externalList.getTestName());
			commonLabTestReport.setTestResult(externalList.getTestResult());
			commonLabTestReport.setTestStatus(externalList.getResultStatus());
			commonLabTestReport.setTestType("External Test");
			commonLabTestReport.setInvestigationId(externalList.getInvestigation() != null ?externalList.getInvestigation().getId():0);
			commonLabTestReports.add(commonLabTestReport);
		}
		
	}	
	
	Collections.sort(commonLabTestReports, new ComparatorForLabTestDate());
	
	Set<String> firstTrimTestdate = new HashSet<String>();
	for(CommonLabTestReport externalListTemp : commonLabTestReports) {
		firstTrimTestdate.add(externalListTemp.getResultDate());
		}
	List<String> sortedfirstTrimTestdate = new ArrayList<String>(firstTrimTestdate);
	Collections.sort(sortedfirstTrimTestdate);
	
	int firstTrimTestDateSize=0;
	firstTrimTestDateSize = sortedfirstTrimTestdate.size();
	
	
	Map<String,List<CommonLabTestReport>> commonLabTestReportsMap = new HashMap<String,List<CommonLabTestReport>>();
	List<CommonLabTestReport> testsObjList = null ;
	for(CommonLabTestReport externalListTemp : commonLabTestReports) {
		String testName = externalListTemp.getTestName();
		if(commonLabTestReportsMap.containsKey(testName)){
			testsObjList = commonLabTestReportsMap.get(testName);
		}else{
			testsObjList = new ArrayList<CommonLabTestReport>();
		}
		 testsObjList.add(externalListTemp);
		 commonLabTestReportsMap.put(testName,testsObjList);
		   
	}
	
	//----first trimester Lab test combined End---
	
	//Second trimester Lab test combined Start
	
	List<CommonLabTestReport> commonLabTestSecondReports = new ArrayList();
	
	if(dgResultHeaderDetailsListForSecondTrim.size() > 0){
		
		for(DgResultEntryHeader dgResultEntryHeaderSecondTrim :dgResultHeaderDetailsListForSecondTrim)
		{   
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
			
			 if (dgResultEntryHeaderSecondTrim.getDgResultEntryDetails().size() > 0) {
				dgResultEntryDetail = dgResultEntryHeaderSecondTrim.getDgResultEntryDetails().iterator().next();
										commonLabTestReport.setDgId((Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId());
			} 
			 
			commonLabTestReport.setInvestigationId(dgResultEntryHeaderSecondTrim.getInvestigation().getId());
			commonLabTestReport.setResultDate(dgResultEntryHeaderSecondTrim.getResultDate().toString());
			commonLabTestReport.setResultTime(dgResultEntryHeaderSecondTrim.getVerifiedTime().toString());
			commonLabTestReport.setTestName(dgResultEntryHeaderSecondTrim.getInvestigation().getInvestigationName());
		    commonLabTestReport.setTestType("Internal Test");
		    commonLabTestSecondReports.add(commonLabTestReport);		   
		}
		
	}
	
	if(externalLabListCommonSecondTrim.size() > 0)
	{
		for(ExternalLabReportCommon externalListSecondTrim:externalLabListCommonSecondTrim){
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			commonLabTestReport.setResultDate(externalListSecondTrim.getTestDate().toString());
			commonLabTestReport.setResultTime(externalListSecondTrim.getTestTime() != null?externalListSecondTrim.getTestTime().toString():"");
			commonLabTestReport.setTestName(externalListSecondTrim.getTestName());
			commonLabTestReport.setTestResult(externalListSecondTrim.getTestResult());
			commonLabTestReport.setTestStatus(externalListSecondTrim.getResultStatus());
			commonLabTestReport.setTestType("External Test");
			commonLabTestReport.setInvestigationId(externalListSecondTrim.getInvestigation().getId());
			commonLabTestSecondReports.add(commonLabTestReport);
		}
		
	}	
	
	Collections.sort(commonLabTestSecondReports, new ComparatorForLabTestDate());
	
	//changes on 15/03/2018
	
	Set<String> secondTrimTestdate = new HashSet<String>();
	for(CommonLabTestReport externalListSecondTemp : commonLabTestSecondReports) {
		secondTrimTestdate.add(externalListSecondTemp.getResultDate());
		}
	List<String> sortedSecondTrimTestdate = new ArrayList<String>(secondTrimTestdate);
	Collections.sort(sortedSecondTrimTestdate);
	
	int secondTrimTestDateSize=0;
	secondTrimTestDateSize = sortedSecondTrimTestdate.size();
	
	
	Map<String,List<CommonLabTestReport>> commonLabTestReportsSecondMap = new HashMap<String,List<CommonLabTestReport>>();
	List<CommonLabTestReport> secondTestsObjList = null ;
	for(CommonLabTestReport externalListSecondTemp : commonLabTestSecondReports) {
		String testName = externalListSecondTemp.getTestName();
		if(commonLabTestReportsSecondMap.containsKey(testName)){
			secondTestsObjList = commonLabTestReportsSecondMap.get(testName);
		}else{
			secondTestsObjList = new ArrayList<CommonLabTestReport>();
		}
		secondTestsObjList.add(externalListSecondTemp);
		commonLabTestReportsSecondMap.put(testName,secondTestsObjList);
		   
	}
	
	
 //Second trimester Lab test combined End
	
   //Third trimester Lab test combined End
	
   List<CommonLabTestReport> commonLabTestThirdReports = new ArrayList();
	if(dgResultHeaderDetailsListForThirdTrim.size() > 0){
		for(DgResultEntryHeader dgResultEntryHeaderThirdTrim :dgResultHeaderDetailsListForThirdTrim)
		{   
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			DgResultEntryDetail dgResultEntryDetail =  new DgResultEntryDetail();
			
			 if (dgResultEntryHeaderThirdTrim.getDgResultEntryDetails().size() > 0) {
				dgResultEntryDetail = dgResultEntryHeaderThirdTrim.getDgResultEntryDetails().iterator().next();
										commonLabTestReport.setDgId((Integer)dgResultEntryDetail.getSampleCollectionDetails().getSampleCollectionHeader().getOrder().getId());
			} 
			 
			commonLabTestReport.setInvestigationId(dgResultEntryHeaderThirdTrim.getInvestigation().getId());
			commonLabTestReport.setResultDate(dgResultEntryHeaderThirdTrim.getResultDate().toString());
			commonLabTestReport.setResultTime(dgResultEntryHeaderThirdTrim.getVerifiedTime().toString());
			commonLabTestReport.setTestName(dgResultEntryHeaderThirdTrim.getInvestigation().getInvestigationName());
		    commonLabTestReport.setTestType("Internal Test");
		    commonLabTestThirdReports.add(commonLabTestReport);	
		    
		}
	}
	
	if(externalLabListCommonThirdTrim.size() > 0)
	{
		for(ExternalLabReportCommon externalList:externalLabListCommonThirdTrim){
			CommonLabTestReport commonLabTestReport = new CommonLabTestReport();
			commonLabTestReport.setResultDate(externalList.getTestDate().toString());
			commonLabTestReport.setResultTime(externalList.getTestTime() != null?externalList.getTestTime().toString():"");
			commonLabTestReport.setTestName(externalList.getTestName());
			commonLabTestReport.setTestResult(externalList.getTestResult());
			commonLabTestReport.setTestStatus(externalList.getResultStatus());
			commonLabTestReport.setTestType("External Test");
			commonLabTestReport.setInvestigationId(externalList.getInvestigation().getId());
			commonLabTestThirdReports.add(commonLabTestReport);
		}
		
	}	
	
	Collections.sort(commonLabTestThirdReports, new ComparatorForLabTestDate());
	
	//changes on 16/03/2018
	
		Set<String> thirdTrimTestdate = new HashSet<String>();
		for(CommonLabTestReport externalListThirdTemp : commonLabTestThirdReports) {
			thirdTrimTestdate.add(externalListThirdTemp.getResultDate());
			}
		List<String> sortedThirdTrimTestdate = new ArrayList<String>(thirdTrimTestdate);
		Collections.sort(sortedThirdTrimTestdate);
		
		
		int thirdTrimTestDateSize=0;
		thirdTrimTestDateSize = sortedThirdTrimTestdate.size();
		
		Map<String,List<CommonLabTestReport>> commonLabTestReportsThirdMap = new HashMap<String,List<CommonLabTestReport>>();
		List<CommonLabTestReport> thirdTestsObjList = null ;
		for(CommonLabTestReport externalListThirdTemp : commonLabTestThirdReports) {
			String testName = externalListThirdTemp.getTestName();
			if(commonLabTestReportsThirdMap.containsKey(testName)){
				thirdTestsObjList = commonLabTestReportsThirdMap.get(testName);
			}else{
				thirdTestsObjList = new ArrayList<CommonLabTestReport>();
			}
			thirdTestsObjList.add(externalListThirdTemp);
			commonLabTestReportsThirdMap.put(testName,thirdTestsObjList);
			   
		}
	
		
	
   
   //Third trimester Lab test combined End	
	
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	String patientDob="";

	if(visit.getHin().getDateOfBirth()!= null){
		patientDob=HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth());
	}
	int ageInDays = 0;
	int ageInMonth = 0;
	if(visit.getHin().getDateOfBirth()!= null){
		String DOB =HMSUtil.convertDateToStringWithoutTime(visit.getHin().getDateOfBirth())+" "+time;
		String curDate = dateC+" "+time;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
		Date d1 = null;
		Date d2 = null;
		 try {
		    d1 = format.parse(DOB);
		    d2 = format.parse(curDate);
	} catch (ParseException e) {
	    e.printStackTrace();
	}    
		 
		 Calendar startCalendar = new GregorianCalendar();
		 startCalendar.setTime(d1);
		 Calendar endCalendar = new GregorianCalendar();
		 endCalendar.setTime(d2);

		 int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		  ageInMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		
	}

	List opdAntenatalCardList= new ArrayList();
	if(map.get("opdAntenatalCardList") != null){
		opdAntenatalCardList=(List)map.get("opdAntenatalCardList");
	}
	List<Object[]> reVisitList = new ArrayList<Object[]>();
	if(map.get("reVisitList") != null){
		reVisitList=(List)map.get("reVisitList");
	}
	
	if(map.get("ipAdmissionList") != null){
		ipAdmissionList=(List<Inpatient>)map.get("ipAdmissionList");
	}
	
	if(map.get("managementList") != null){
		managementList=(List<Inpatient>)map.get("managementList");
	}
	if(map.get("diagnosisList") != null){
		diagnosisList=(List<Inpatient>)map.get("diagnosisList");
	}
	if(map.get("adviceList") != null){
		adviceList=(List<Inpatient>)map.get("adviceList");
	}
	
	String management = "";
	String diagnosis = "";
	String advice = "";
	for (int i=0; i < managementList.size();i++ ){
		management = management +", "+managementList.get(i); 
	}
	for (int i=0; i < diagnosisList.size();i++ ){
		diagnosis = diagnosis +", "+diagnosisList.get(i); 
	}
	for (int i=0; i < adviceList.size();i++ ){
		advice = advice +", "+adviceList.get(i); 
	}
	double height = 0;
	double weight = 0.0;
	float bmi = 0;
	if(reVisitList.size()>0){
		for(Object[] obj : reVisitList){
			if(obj[0] != null){
				height = (Double)obj[0];
			}
			
			if(obj[1] != null){
				weight = (Double)obj[1];
			}
			
			if(obj[2] != null){
				bmi = (Float)obj[2];
			}
			
		}
	}
	

	OpdAntenatalCard op=null,op1;
	int opdAntenatalCardId=0;
	List<OpdAntenatalCard> opdAntenatalCardList1= new ArrayList<OpdAntenatalCard>();
		if(map.get("opdAntenatalCardList1") != null){
			opdAntenatalCardList1=(List<OpdAntenatalCard>)map.get("opdAntenatalCardList1");
		}
	
		 if(opdAntenatalCardList1.size()>0){

			op=opdAntenatalCardList1.get(opdAntenatalCardList1.size()-1); 
				op1=opdAntenatalCardList1.get(0);
				antCardId=op.getId();

		 for(OpdAntenatalCard opd:opdAntenatalCardList1){
			 
			 if(opd.getVisit()!=null && !opd.getVisit().getVisitStatus().equalsIgnoreCase("w"))
				 opdAntenatalCardId=opd.getId();
			 
			if(opd.getMenarche() != null && !opd.getMenarche().equals("")){
				 menarche=opd.getMenarche().toString();
			}
			
			if(opd.getCycle() != null && !opd.getCycle().equals("")){
				Cycle=opd.getCycle();
			}
			if(opd.getCycleFlow() != null && !opd.getCycleFlow().equals("")){
				cycleFlow=opd.getCycleFlow(); 
			}
			if(opd.getLmp() != null && !opd.getLmp().equals("")){
				lmp = HMSUtil.convertDateToStringWithoutTime(opd.getLmp());
			}
			if(opd.getEdd() != null && !opd.getEdd().equals("")){
				edd = HMSUtil.convertDateToStringWithoutTime(opd.getEdd());
			}
			if(opd.getGravida1() != null && !opd.getGravida1().equals("")){
			 	gravida=opd.getGravida1().toString();
			}
			if(opd.getPara() != null && !opd.getPara().equals("")){
				para=opd.getPara().toString();
			}
			if(opd.getAbortions() != null && !opd.getAbortions().equals("")){
				abortion=opd.getAbortions().toString();
			}
			if(opd.getLive() != null && !opd.getLive().equals("")){
				live=opd.getLive().toString();
			}
			if(opd.getEctopic() != null && !opd.getEctopic().equals("")){
				ectopic=opd.getEctopic().toString();
			}
			if(opd.getVesicular() != null && !opd.getVesicular().equals("")){
				vesicular=opd.getVesicular().toString();
			}
			if(opd.getMtp() != null && !opd.getMtp().equals("")){
				mtp=opd.getMtp().toString();
			}
			if(opd.getIud() != null && !opd.getIud().equals("")){
				iud=opd.getIud().toString();
			}
			if(opd.getStillBirth() != null && !opd.getStillBirth().equals("")){
				stillBirth=opd.getStillBirth().toString();
			}
			if(opd.getNnd() != null && !opd.getNnd().equals("")){
				nnd=opd.getNnd().toString();
			}
			if(opd.getScannedEdc() != null && !opd.getScannedEdc().equals("")){
				scannedEdc = HMSUtil.convertDateToStringWithoutTime(opd.getScannedEdc());
			}
			if(opd.getUnknownLmpStatus() != null && opd.getUnknownLmpStatus().equalsIgnoreCase("y")){
				unknownLmpStatus =opd.getUnknownLmpStatus();
			}
			
			
			if(opd.getEdcDate() != null && !opd.getEdcDate().equals("")){
				edcDate = HMSUtil.convertDateToStringWithoutTime(opd.getEdcDate());
			}
			
			if(opd.getDays() != null && !opd.getDays().equals("")){
				day=opd.getDays().toString();
			}
			if(opd.getMedicalDisord() != null && !opd.getMedicalDisord().equals("")){
				medicalDisor=opd.getMedicalDisord();
			}
			if(opd.getObstetricComplications()!= null && !opd.getObstetricComplications().equals("")){
				obstetricComplications=opd.getObstetricComplications();
			}
			if(opd.getObstetricValues()!= null && !opd.getObstetricValues().equals("")){
				obstetricValues=opd.getObstetricValues();
			}
			if(opd.getHeight() != null && !opd.getHeight().equals("")){
				d2Height=opd.getHeight();
			}
			if(opd.getWeight() != null && !opd.getWeight().equals("")){
				d2Weight=opd.getWeight();
			}
			if(opd.getBreast() != null && !opd.getBreast().equals("")){
				d2Breast=opd.getBreast();
			}
			if(opd.getNipple() != null && !opd.getNipple().equals("")){
				d2Nipple=opd.getNipple();
			}
			if(opd.getBmi() != null && !opd.getBmi().equals("")){
				d2Bmi=opd.getBmi();
			}
			if(opd.getBmiStatus() != null && !opd.getBmiStatus().equals("")){
				bmiStatus=opd.getBmiStatus();
			}
			if(opd.getThyriod() != null && !opd.getThyriod().equals("")){
				d2Thyroid=opd.getThyriod();
			}
			if(opd.getAgeYear()!=null && !opd.getAgeYear().equals("")){
				years=opd.getAgeYear();
			}
			if(opd.getAgeMonth()!=null && !opd.getAgeMonth().equals("")){
				months=opd.getAgeMonth();
			}
			if(opd.getConsanguineous()!=null && !opd.getConsanguineous().equals("")){
				consanguineousYes=opd.getConsanguineous();
			}
			if(opd.getDegree()!=null && !opd.getDegree().equals("")){
				degree=opd.getDegree();
			}
			if(opd.getInfertility() !=null && !opd.getInfertility().equals("")){
				infertilityYes=opd.getInfertility();
			}
			if(opd.getFactor() != null && !opd.getFactor().equals("")){
				factor=opd.getFactor();
			}
			if(opd.getInfertilityDetails() != null && !opd.getInfertilityDetails().equals("")){
				infertilityDetails=opd.getInfertilityDetails();
			}
			
			if(opd.getFamilyHistory() != null && !opd.getFamilyHistory().equals("")){
				familyHistory=opd.getFamilyHistory();
			}
			if(opd.getSurgicalHistory() != null && !opd.getSurgicalHistory().equals("")){
				surgicalHistory=opd.getSurgicalHistory();
			}
			if(opd.getPersonalHistory() != null && !opd.getPersonalHistory().equals("")){
				personalHistory=opd.getPersonalHistory();
			}
			if(opd.getOtherImmunizationDetail() != null && !opd.getOtherImmunizationDetail() .equals("")){
				otherImmunizationDetail=opd.getOtherImmunizationDetail() ;
			}
			if(opd.getCycle1() != null && !opd.getCycle1().equals("")){
				Cycle1=opd.getCycle1().toString();
			}
			if(opd.getDays1() != null && !opd.getDays1().equals("")){
				day1=opd.getDays1().toString();
			}
			if(opd.getCycle2() != null && !opd.getCycle2().equals("")){
				Cycle2=opd.getCycle2().toString();
			}
			if(opd.getDays2() != null && !opd.getDays2().equals("")){
				day2=opd.getDays2().toString();
			}
			if(opd.getCycle3() != null && !opd.getCycle3().equals("")){
				Cycle3=opd.getCycle3().toString();
			}
			if(opd.getDays3() != null && !opd.getDays3().equals("")){
				day3=opd.getDays3().toString();
			}
			if(opd.getTetanusOnestDoseDate()!=null){
				String fisDoseDate[]=opd.getTetanusOnestDoseDate().toString().split("-");
				firstDose=fisDoseDate[2].substring(0, 2)+"/"+fisDoseDate[1]+"/"+fisDoseDate[0];
			}
			if(opd.getTetanusTwondDoseDate()!=null){
				String secDoseDate[]=opd.getTetanusTwondDoseDate().toString().split("-");			   
				secondDose=secDoseDate[2].substring(0, 2)+"/"+secDoseDate[1]+"/"+secDoseDate[0];
			}
			
			if(opd.getTetanusTwondDoseDate()!=null){
				other = opd.getOthersTtDetails();
			}
			if(opd.getGestationalAgeWeeks() != null){
				gestationalAgeWeeks = opd.getGestationalAgeWeeks();
			}
			if(opd.getGestationalAgeDays() != null){
				gestationalAgeDays = opd.getGestationalAgeDays();
			}
			if(opd.getMaritalStatus() != null){
				maritalStatus = opd.getMaritalStatus();
			}
			if(opd.getMarritalHistoryRemarks() != null){
				marritalHistoryRemarks = opd.getMarritalHistoryRemarks();
			}
			if(opd.getDurationOfMarriageYear() != null){
				durationOfMarriageYear = opd.getDurationOfMarriageYear();
			}
			if(opd.getDurationOfMarriageMonth() != null){
				durationOfMarriageMonth = opd.getDurationOfMarriageMonth();
			}
			if(opd.getReferredFromPrivate() != null){
				referredFromPrivate = opd.getReferredFromPrivate();
			}
			if(opd.getReferredFromPrivateDetail() != null){
				referredFromPrivateValue = opd.getReferredFromPrivateDetail();
			}
			if(opd.getPallor() != null){
				pallorGenExam = opd.getPallor();
			}
			if(opd.getIcterus() != null){
				icterusGenExam = opd.getIcterus();
			}
			if(opd.getCyanosis() != null){
				cyanosisGenExam = opd.getCyanosis();
			}
			if(opd.getClubbing() != null){
				clubbing = opd.getClubbing();
			}
			if(opd.getRefferedHospital() != null){
				reffredHospital = opd.getRefferedHospital();
			}
			if(opd.getRefferedGA() != null){
				refferedGA = opd.getRefferedGA();
			}
			if(opd.getLymphadenopathy() != null){
				lymphadenopathyGenExam = opd.getLymphadenopathy();
			}
			if(opd.getLymphadenopathyValue() != null){
				lymphadenopathyValueGenExam = opd.getLymphadenopathyValue();
			}
			if(opd.getEdema() != null){
				edemaGenExam = opd.getEdema();
			}
			if(opd.getSpine() != null){
				SpineGenExam = opd.getSpine().trim();
			}
			if(opd.getGait() != null){
				gaitGenExam = opd.getGait();
			}
			if(opd.getGait() != null){
				cvs = opd.getCvsGenExam();
			}
			if(opd.getWaist() != null){
				waistValue = opd.getWaist();
			}
			if(opd.getHip() != null){
				hipValue = opd.getHip();
			}
			if(opd.getOthersGeneralExamination() != null){
				otherGenExam = opd.getOthersGeneralExamination();
			}
			
			if(opd.getDateUsgReport() != null){
				dateUsgReport = opd.getDateUsgReport();
			}
			if(opd.getDateUsgOne() != null){
				dateUsgOne =(Date)opd.getDateUsgOne();
			}
			if(opd.getDateUsgTwo() != null){
				dateUsgTwo = (Date)opd.getDateUsgTwo();
			}
			if(opd.getDateUsgThree() != null){
				dateUsgThree = (Date)opd.getDateUsgThree();
			}
			
			if(opd.getLmpGaUsgReport() != null){
				lmpGaUsgReport = opd.getLmpGaUsgReport();
			}
			if(opd.getLmpGaOne() != null){
				lmpGaOne =(String)opd.getLmpGaOne();
			}
			if(opd.getLmpGaTwo() != null){
				lmpGaTwo = (String)opd.getLmpGaTwo();
			}
			if(opd.getLmpGaThree() != null){
				lmpGaThree = (String)opd.getLmpGaThree();
			}
			
			if(opd.getUsgGaUsgReport() != null){
				usgGaUsgReport = opd.getUsgGaUsgReport();
			}
			if(opd.getUsgGaOne() != null){
				usgGaOne =(String)opd.getUsgGaOne();
			}
			if(opd.getUsgGaTwo() != null){
				usgGaTwo = (String)opd.getUsgGaTwo();
			}
			if(opd.getUsgGaThree() != null){
				usgGaThree = (String)opd.getUsgGaThree();
			}
			
			if(opd.getAfiUsgReport() != null){
				afiUsgReport = opd.getAfiUsgReport();
			}
			if(opd.getAfiOne() != null){
				afiOne =(String)opd.getAfiOne();
			}
			if(opd.getAfiTwo() != null){
				afiTwo = (String)opd.getAfiTwo();
			}
			if(opd.getAfiThree() != null){
				afiThree = (String)opd.getAfiThree();
			}
			
			
			if(opd.getBppUsgReport() != null){
				bppUsgReport = opd.getBppUsgReport();
			}
			if(opd.getBppOne() != null){
				bppOne =(String)opd.getBppOne();
			}
			if(opd.getBppTwoUsg() != null){
				bppTwo = (String)opd.getBppTwoUsg();
			}
			if(opd.getBppThree() != null){
				bppThree = (String)opd.getBppThree();
			}
			
			
			if(opd.getBpdUsgReport() != null){
				bpdUsgReport = opd.getBpdUsgReport();
			}
			if(opd.getBpdOne() != null){
				bpdOne =(String)opd.getBpdOne();
			}
			if(opd.getBppTwo() != null){
				bpdTwo = (String)opd.getBppTwo();
			}
			if(opd.getBpdThree() != null){
				bpdThree = (String)opd.getBpdThree();
			}
			
			
			if(opd.getFlUsgReport() != null){
				flUsgReport = opd.getFlUsgReport();
			}
			if(opd.getFlOne() != null){
				flOne =(String)opd.getFlOne();
			}
			if(opd.getFlTwo() != null){
				flTwo = (String)opd.getFlTwo();
			}
			if(opd.getFlThree() != null){
				flThree = (String)opd.getFlThree();
			}
			
			if(opd.getAcUsgReport() != null){
				acUsgReport = opd.getAcUsgReport();
			}
			if(opd.getAcOne() != null){
				acOne =(String)opd.getAcOne();
			}
			if(opd.getAcTwo() != null){
				acOne = (String)opd.getAcTwo();
			}
			if(opd.getAcThree() != null){
				acThree = (String)opd.getAcThree();
			}
			
			
			if(opd.getHcUsgReport() != null){
				hcUsgReport = opd.getHcUsgReport();
			}
			if(opd.getHcOne() != null){
				hcOne =(String)opd.getHcOne();
			}
			if(opd.getHcTwo() != null){
				hcTwo = (String)opd.getHcTwo();
			}
			if(opd.getHcThree() != null){
				hcThree = (String)opd.getHcThree();
			}
			
			if(opd.getEbwUsgReport() != null){
				ebwUsgReport = opd.getEbwUsgReport();
			}
			if(opd.getEbwOne() != null){
				ebwOne =(String)opd.getEbwOne();
			}
			if(opd.getEbwTwo() != null){
				ebwTwo = (String)opd.getEbwTwo();
			}
			if(opd.getEbwThree() != null){
				ebwThree = (String)opd.getEbwThree();
			}
			
			if(opd.getDopplerUsgReport() != null){
				dopplerUsgReport = opd.getDopplerUsgReport();
			}
			if(opd.getDopplerOne() != null){
				dopplerOne =(String)opd.getDopplerOne();
			}
			if(opd.getDopplerTwo() != null){
				dopplerTwo = (String)opd.getDopplerTwo();
			}
			if(opd.getDopplerThree() != null){
				dopplerThree = (String)opd.getDopplerThree();
			}
			
			if(opd.getUsgRemarks() != null){
				usgRemarks = (String)opd.getUsgRemarks();
			}
			
			if(opd.getUsgSecondRemarks() != null){
				usgSecondRemarks = (String)opd.getUsgSecondRemarks();
			}
			
			if(opd.getUsgRemarks() != null){
				usgThirdRemarks = (String)opd.getUsgRemarks();
			}
			/* ---FP changes--- */
			
			if(opd.getOcpS() != null){
				ocps = (String)opd.getOcpS();
			}
			if(opd.getPpiucd() != null){
				ppiucd = (String)opd.getPpiucd();
			}
			if(opd.getTubalLigation() != null){
				tubalLigation = (String)opd.getTubalLigation();
			}
			if(opd.getVasectomy() != null){
				vasectomy = (String)opd.getVasectomy();
			}
			if(opd.getCondom() != null){
				condom = (String)opd.getCondom();
			}
			if(opd.getIntervalIucd() != null){
				intervalIUCD = (String)opd.getIntervalIucd();
			}
			if(opd.getLam() != null){
				fpLam = (String)opd.getLam();
			}
			if(opd.getNone() != null){
				fpNone = (String)opd.getNone();
			}
		  }
		}
		 
		  /*  String familyHistoryDetail= "";
		 String personalHistoryDetail = "";
		 if(opdAntenatalCardList1.size()>0){
			 for(OpdAntenatalCard opdAntenatalCard :opdAntenatalCardList1){
				 if(opdAntenatalCard.getFamilyHistory() != null &&  !opdAntenatalCard.getFamilyHistory().equals("")){
					 familyHistoryDetail = opdAntenatalCard.getFamilyHistory();
					}
				 if(opdAntenatalCard.getPersonalHistory() != null &&  !opdAntenatalCard.getPersonalHistory().equals("")){
					 personalHistoryDetail = opdAntenatalCard.getPersonalHistory();
					}
			 }
		 }  */

		List<OpdAntenatalCardPregnancy> opdAntenatalCardPreg= new ArrayList<OpdAntenatalCardPregnancy>();
		List<OpdAntenatalCardMedicalHistory> opdAntenatalCardMedHist= new ArrayList<OpdAntenatalCardMedicalHistory>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim1= new ArrayList<OpdAntenatalCardTrimester>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim2= new ArrayList<OpdAntenatalCardTrimester>();
		List<OpdAntenatalCardTrimester> opdAntenatalCardTrim3= new ArrayList<OpdAntenatalCardTrimester>();

		if(map.get("opdAntenatalCardPregnancyList") != null){
			opdAntenatalCardPreg=(List<OpdAntenatalCardPregnancy>)map.get("opdAntenatalCardPregnancyList");
		}
		if(map.get("opdAntenatalCardMedicalHistoryList") != null){
			opdAntenatalCardMedHist=(List<OpdAntenatalCardMedicalHistory>)map.get("opdAntenatalCardMedicalHistoryList");
		}
		if(map.get("opdAntenatalCardTrim1") != null){
			opdAntenatalCardTrim1=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim1");
		}
		if(map.get("opdAntenatalCardTrim2") != null){
			opdAntenatalCardTrim2=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim2");
		}
		if(map.get("opdAntenatalCardTrim3") != null){
			opdAntenatalCardTrim3=(List<OpdAntenatalCardTrimester>)map.get("opdAntenatalCardTrim3");
		}		
		String risk="";
		if (map.get("riskList") != null) {
			riskList = (List<String>) map.get("riskList");
	
		}
		if(riskList.size() >0){
				 for (int i=0; i < riskList.size() ; i++) {	
				risk = riskList.get(i);
				if(risk.equalsIgnoreCase("high"))
				break;
				
			}
		}
		StringBuilder comorbidityText = new StringBuilder();
		String comorbidityText1 = "";
		StringBuilder infectionText =new StringBuilder();
		StringBuilder surgeryText = new StringBuilder();
		if(opdAntenatalCardMedHist.size()>0){
			comorbidityText.append("<b>Past History:</b><br/>");
			for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){				
				if(opdMH.getComorbidity() != null && !opdMH.getComorbidity().trim().equals("")) {
					String comorbidityValue = opdMH.getComorbidity();
					String comorbidityOtherValue = opdMH.getOtherDisease();
					String comorbidityYear = opdMH.getYears();
					String comorbidityMonths = opdMH.getMonths();
					String comorbidityRemarks = opdMH.getRemarks();						
					comorbidityText.append("Patient is having "+"<b>"+comorbidityValue+"</b>");
					
					if(comorbidityOtherValue !=null && !comorbidityOtherValue.trim().equals(""))
						comorbidityText.append("---<b> "+comorbidityOtherValue+" </b>");
					
					if(comorbidityYear !=null && !comorbidityYear.trim().equals(""))
						comorbidityText.append(" for<b> "+comorbidityYear+" </b>years ");	
					if(comorbidityMonths !=null && !comorbidityMonths.trim().equals(""))
						comorbidityText.append(" for<b> "+comorbidityMonths+" </b>Months");	
					if(comorbidityRemarks !=null && !comorbidityRemarks.trim().equals(""))
						comorbidityText.append("--Remarks :<b>"+comorbidityRemarks+"</b>");
					comorbidityText.append("<br/>");
				}	
				
			}
			
				}
		
		if(opdAntenatalCardMedHist.size()>0){
			for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){			
				if(opdMH.getInfection()!= null && !opdMH.getInfection().equals("")) {
					String infection = opdMH.getInfection();
					String infectionOthersValue = opdMH.getInfectionOthers();
					String infectionRemark = opdMH.getInfectionRemarks();					
					infectionText.append("<br/>Patient had<b> "+infection+"</b>");
					
					if(infectionOthersValue !=null && !infectionOthersValue.equals(""))
						infectionText.append("----<b>"+infectionOthersValue+"</b>");
					
					if(infectionRemark !=null && !infectionRemark.equals(""))
						infectionText.append("--Remarks :<b>"+infectionRemark+"</b>");
					
				}
				
				}
				}
		if(opdAntenatalCardMedHist.size()>0){
			for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){			
				if(opdMH.getPastSurgeryName()!= null && !opdMH.getPastSurgeryName().equals("")) {
					String surgery = opdMH.getPastSurgeryName();
					String surgeryYear = opdMH.getPastSurgeryYears();
					String hospital = opdMH.getPastSurgeryHospital();
					String surgeryRemarks = opdMH.getPastSurgeryRemarks();
					surgeryText.append("<br/> Patient under gone<b> "+surgery+"</b>");
					if(surgeryYear !=null && !surgeryYear.trim().equals(""))
						surgeryText.append(" on<b> "+surgeryYear+" </b>");
					if(hospital !=null && !hospital.trim().equals(""))
						surgeryText.append(" at "+hospital);
					if(surgeryRemarks !=null && !surgeryRemarks.trim().equals(""))
						surgeryText.append("---Remarks :<b>"+surgeryRemarks+"</b>");
				}
				}
				}
		
		 Date firstTrimesterDate= null;
		 Date secondTrimesterDate= null;
		 Date thirdTrimesterDate= null;
if(map.get("firstTrimesterDate") != null){
	firstTrimesterDate = (Date)map.get("firstTrimesterDate");
}
if(map.get("secondTrimesterDate") != null){
	secondTrimesterDate = (Date)map.get("secondTrimesterDate");
}
if(map.get("thirdTrimesterDate") != null){
	thirdTrimesterDate = (Date)map.get("thirdTrimesterDate");
}
		 
		
%>
<script type="text/javascript">
setTimeout(function(){ callRunRadioCheck(); }, 1000);
 setTimeout(function(){ calculateGestationalAge(); }, 1000);
 setTimeout(function(){ displayPreviousPregnancyDetail('<%=gravida%>'); }, 1000);
 /* setTimeout(function(){ enableOpDetail('n'); }, 100); */
 /*setTimeout(function(){ calculateSecondTrimsterGestationalAge(1);3000});
 setTimeout(function(){ calculateThirdTrimsterGestationalAge(1); 3000}); */
 
function callRunRadioCheck(){
	runRadioCheck('<%=consanguineousYes%>','<%=degree%>','<%=infertilityYes%>','<%=factor%>');
}

var icdArray=new Array();
</script>

<!--main content placeholder starts here-->
<!-- <div class="OpdOphthamology-maindiv" onload="callFunction();"> -->
	<!-- <form name="antenatalCard2" action="" method="post"> -->
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>
		<input id="antenatalCardFlag" name="antenatalCardFlag" value="AntenatalCard" type="hidden"  />
			<input type="hidden" id="pastHistoryText" value="<%=comorbidityText%><%=infectionText%><%=surgeryText%>"/>
		<input type="hidden" name="templateName" value="Antenatal Card"/>
	 <input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
	 <input type="hidden" name="visitSessionId" value="<%=visit.getVisitSession().getId()!= null?visit.getVisitSession().getId():"" %>" />
	 <input type="hidden" name="totalHospitalVisit" value="<%=visit.getTotalHospitalVisit()!= null?visit.getTotalHospitalVisit():"" %>" />
	 <%if(opdAntenatalCardId!=0){%>
	 <input type="hidden" name="opdAntenatalCardId" value="<%=opdAntenatalCardId %>" />
	 <%}%>
	 
	 
<%if(visit.getDepartment()!= null){ %>
<input id="inputDate" name="inputDate" type="hidden" value="<%=dateC%>" />
	<input id="inputTime" name="inputTime" type="hidden" value="<%=time%>" />
	<input id="currentYear" name="currentYear" type="hidden" value="<%=year%>" />

	
	<div class="Block">
			 
			<label class="medium1">UHID:<%-- <%=prop.getProperty("com.jkt.hms.registration_no") %> --%></label>
			<%if(visit.getHin().getHinNo()!= null){ %>
			<%-- <input type="text" class="auto" readonly="readonly" value=<%=visit.getHin().getHinNo() %> /> --%>
			 <label class="auto bgNone"><%=visit.getHin().getHinNo()%></label>
			<%}else{ %>
			<label class="auto"></label>
			<%} %>
			
			<%if(patientName!= null){ %>
			<label style="font-size:15px;" class="auto bgNone"><%=patientName.toUpperCase() %></label>
			<%}else{ %>
			<label class="auto"></label>
			<%} %>
			
		 	<!-- <label class="auto">Age</label> -->
			<%if(visit.getHin().getDateOfBirth()!= null){
				/* Added by Arbind on 26-04-2017 */
				String yearMonth = "";
				if(visit.getHin().getDateOfBirth()!=null){
					Date dob=visit.getHin().getDateOfBirth();
					String ymd=HMSUtil.calculateYearMonthDay(dob);
				String d[]=ymd.split("&");
				int year1=Integer.parseInt(d[0].toString());
				patAge = year1;
				int months1=Integer.parseInt(d[1].toString());
				int days1=Integer.parseInt(d[2].toString());
				yearMonth = year1 != 0 ? d[0] + " Y " : "";
				yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
				yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
			}%>
			<label style="font-size:15px;" class="auto bgNone"><%=yearMonth %>     /</label>
			<%}else{ %>
			<label class="valueAuto">-</label>
			<%} %>  
			  
			    <%if(visit.getHin().getSex()!= null && !visit.getHin().getSex().equals("")){%>
				 <label style="font-size:15px;"  class="auto bgNone"><%=visit.getHin().getSex().getAdministrativeSexName()%></label>
	 			<%}else{%>
				<label class="valueAuto">-</label>
				<%} %>
			  
			   <!-- <label style="width: 105px;">Blood Group</label> -->
			<%-- <% if(visit.getHin().getBloodGroupValue() !=null && !visit.getHin().getBloodGroupValue().equals("")) {%>
			<input type="text" readonly="readonly"   value=<%=visit.getHin().getBloodGroupValue()%> >
			<label style="background:none;box-shadow:none;" class="auto" >( <%=visit.getHin().getBloodGroupValue()%> )</label>
			<%}else{ %>
			<!-- <input type="text" readonly="readonly" value="" /> -->
			<label style="background:none;box-shadow:none;font-size:15px;"  class="auto" >( - )</label>
			<%} %>   --%>
			  
			   <%--  <%if(visit.getHin().getBloodGroup()!= null && !visit.getHin().getBloodGroup().equals("")){%>
			<label style="background:none;box-shadow:none;"  class="auto" ><%=visit.getHin().getBloodGroup().getBloodGroupName()%></label>
		 <%}else{%>
		<label style="background:none;box-shadow:none;"  class="auto" >-</label>
		<%} %> --%>
			  
			  
	 	 	<label class="auto">ph:</label>
			<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
			<%-- <input type="text" readonly="readonly" value=<%=visit.getHin().getMobileNumber() %> > --%>
			<label class="auto bgNone" ><%=visit.getHin().getMobileNumber() %></label>
			<%}else{%>
			<label class="auto bgNone" >-</label>
			<%}%>
			  
		 	<label class="auto">Risk:</label>
			<% if(risk.equalsIgnoreCase("high")){%>
			<label style="width:30px; background: red;" class="bgNone"><%=risk %></label>
			<%} else { %>
			<label style="width:30px;" class="bgNone"><%=risk %></label>
			<%} %>	
		<input type="hidden" id="riskId" value="<%=risk%>"/>
		<label class="auto">Blood Group:</label>			
		<label class="auto bgNone"><%=visit.getHin().getBloodGroupValue()!=null && !visit.getHin().getBloodGroupValue().equals("0")?visit.getHin().getBloodGroupValue():""  %></label>
		
			
			
		   	<label  class="auto">EDC :</label>
		   
		   	<label class="bgNone" id="edcDisplay" style="width:66px;" ><%=edcDate!=null?edcDate:scannedEdc!=null?scannedEdc:edd!=null?edd:""%></label>
		   	
		   		<label  class="auto">Unit :</label>
		   
		   	<label class="bgNone" id="edcDisplay" style="width:66px;" ><%=visit.getUnit()!= null && visit.getUnit().getUnitCode()!= null?visit.getUnit().getUnitCode():"" %></label>
		   	
		   	<div class="clear"></div>
		   	 <label class="medium1">Obstetric Score:</label>
		   	<label class="bgNone" style="width:250px;"><%=obstetricValues != null?obstetricValues:"" %></label>
		   	
	<label class="medium1">Allergies:</label>
    <textarea class="textareaMediua" readonly="readonly" cols="0" rows="0" maxlength="300" style="font-weight: bold;color:red;margin:0 5px 5px 0"><%=allergyStr %></textarea>		
	<label  class="medium1">Referred From:</label>
	<label class="bgNone" style="width:348px;"><%=reffredHospital != null?reffredHospital:"" %></label>
<div class="clear"></div>
			  <label class="auto">Obstetric Complication</label>
			  <textarea readonly="readonly" style="width:219px;" class="textareaMediua" id="ObsComplicationDisplay"><%=obstetricComplications != null?obstetricComplications:"" %></textarea>
			  
			  <label class="medium1">Medical Disorder</label>
			  <textarea readonly="readonly" class="textareaMediua" id="medDisorderDisplay"><%=medicalDisor%></textarea>
     
			<label  class="medium1">Referred GA:</label>
			<label class="bgNone" style="width:30px;"><%=refferedGA != null?refferedGA:"" %></label>
			<% if(refferedGA != null && !refferedGA.equals("")){%>
			<label class="smallAuto">Weeks</label><%} %>
</div>
			 	 
	<div class="Block">
	<h2>Antenatal Card Details</h2>
</div>
<div class="clear"></div>

<!-- =====Inner Tab start here===== -->
<div class="inTab">
<% if(firstTrimesterDate != null && secondTrimesterDate != null && thirdTrimesterDate != null){ %>
  <div class="tablinks" id='gen' onclick="javascript:openAncCity(event, 'inAncTab1','gen');enableOpDetail('n');">GENERAL DETAILS</div>
  <%
  if(firstTrimesterDate != null && HMSUtil.convertStringTypeDateToDateType(dateC).before(firstTrimesterDate)){ %>
  <div class="tablinks inActive" id="1st" onclick="javascript:openAncCity(event, 'inAncTab2','1st');enableOpDetail('y');">FIRST TRIMESTER</div>
  <script> openAncCity(event, 'inAncTab2','1st');enableOpDetail('y');</script>
  <%}else{ %>
   <div class="tablinks" id="1st" onclick="javascript:openAncCity(event, 'inAncTab2','1st');enableOpDetail('y');">FIRST TRIMESTER</div>
  <%} %>
   <%
   if(secondTrimesterDate != null && (HMSUtil.convertStringTypeDateToDateType(dateC).after(firstTrimesterDate) && HMSUtil.convertStringTypeDateToDateType(dateC).before(secondTrimesterDate))){ %>
  <div class="tablinks inActive" id="2nd" onclick="javascript:openAncCity(event, 'inAncTab3','2nd');enableOpDetail('y');">SECOND TRIMESTER</div>
  <script>
		  	openAncCity(event,'inAncTab3','2nd');
   			enableOpDetail('y');
  </script>
  <%}else{ %>
    <div class="tablinks" onclick="javascript:openAncCity(event, 'inAncTab3','2nd');enableOpDetail('y');">SECOND TRIMESTER</div>
  <%} %>
  <%

  if(thirdTrimesterDate != null &&  (HMSUtil.convertStringTypeDateToDateType(dateC).after(secondTrimesterDate) && HMSUtil.convertStringTypeDateToDateType(dateC).before(thirdTrimesterDate))){ %>
  <div class="tablinks inActive" id="3rd" onclick="javascript:openAncCity(event, 'inAncTab4','3rd');enableOpDetail('y');">THIRD TRIMESTER</div>
  <script> openAncCity(event, 'inAncTab4','3rd');enableOpDetail('y');</script>
  <%}else{ %>
   <div class="tablinks" id="3rd" onclick="javascript:openAncCity(event, 'inAncTab4','3rd');enableOpDetail('y');">THIRD TRIMESTER</div>
  <%} %>
  <div class="tablinks" id="4th" onclick="javascript:openAncCity(event, 'inAncTab5','4th');enableOpDetail('y');">IP ADMISSION & FAMILY PLANNING</div>
  <%}else{ %>
   <script>
		  
   			enableOpDetail('n');
  </script>
   <div class="tablinks inActive" id="gen" onclick="javascript:openAncCity(event, 'inAncTab1','gen');enableOpDetail('n');">GENERAL DETAILS</div>
   <div class="tablinks" id="1st" onclick="javascript:openAncCity(event, 'inAncTab2','1st');enableOpDetail('y');">FIRST TRIMESTER</div>
   <div class="tablinks" id="2nd"  onclick="javascript:openAncCity(event, 'inAncTab3','2nd');enableOpDetail('y');">SECOND TRIMESTER</div>
    <div class="tablinks" id="3rd" onclick="javascript:openAncCity(event, 'inAncTab4','3rd');enableOpDetail('y');">THIRD TRIMESTER</div>
     <div class="tablinks" id="4th" onclick="javascript:openAncCity(event, 'inAncTab5','4th');enableOpDetail('y');">IP ADMISSION & FAMILY PLANNING</div>
   
   
  <%} %>
</div>
<div id="inAncTab1" class="inAncTabcontent" style="display:block;">
<div class="clear"></div>
<!--Block One Starts-->
		<h4>Patient Details</h4>
		<div class="clear"></div>
		<div class="Block">
			<%--  <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
			<%if(visit.getHin().getHinNo()!= null){ %>
			<label class="value"><%=visit.getHin().getHinNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>
			<label>Patient Name. </label>
			<%if(patientName!= null){ %>
			<label class="value"><%=patientName %> </label>
			<%}else{ %>
			<label class="value">- </label>
			<%} %>
		<div class="clear"></div>
			<label>Age</label>
			<%if(visit.getHin().getDateOfBirth()!= null){
				/* Added by Arbind on 26-04-2017 */
				String yearMonth = "";
				if(visit.getHin().getDateOfBirth()!=null){
					Date dob=visit.getHin().getDateOfBirth();
					String ymd=HMSUtil.calculateYearMonthDay(dob);
				String d[]=ymd.split("&");
				int year1=Integer.parseInt(d[0].toString());
				int months1=Integer.parseInt(d[1].toString());
				int days1=Integer.parseInt(d[2].toString());
				yearMonth = year1 != 0 ? d[0] + " Y " : "";
				yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
				yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
			}%>
			<label class="value"><%=yearMonth %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>  
			  
			  <label class="auto">Contact Number</label>
			<% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
			<label class="value"style="width:80px;"><%=visit.getHin().getMobileNumber() %></label>
			<%}else{ %>
			<label class="value"style="width:80px;">-</label>
			<%} %>
			  <div class="clear"></div>
			  
			 <label>Obstetric Score</label>
		<input name="obstetricValues" type="text"  id="ObstetricValues" placeholder="" readonly="readonly" value="<%=obstetricValues != null?obstetricValues:"" %>" />
			 --%>
			 <div class="paddingTop5"></div>
	 	  	<label class="medium">Date of Birth</label>
			<%if(patientDob != null){ %>
			<label class="value" style="width:65px;"><%=patientDob %></label>
			<%}else{ %>
			<label class="value" style="width:65px;">-</label>
			<%} %>
			<%-- commented by swarup 
			<label class="auto">Visit Date </label>
			<%if(visitDateInString != null){ %>
			<label class="value" style="width:65px;"><%=visitDateInString %></label>
			<%}else{ %>
			<label class="value" style="width:65px;">-</label>
			<%} %> --%>
			
			 <%-- <label><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
			<%if(visit.getVisitNo()!= null){ %>
			<label class="value"><%=visit.getVisitNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>   --%>		
			
			<%-- <label>Token No. </label>
			<%if(visit.getTokenNo()!= null){ %>
			<label class="value"><%=visit.getTokenNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %> --%>
			
		<%--  <label>Prev. Diag </label>
			<%if(visit.getDiagnosis()!= null){ %>
			<label class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>  --%>
			
			<%--<label>ECHS No. </label>
			<%if(visit.getHin().getEchsNo()!= null){ %>
			<label class="value"><%=visit.getHin().getEchsNo() %></label>
			<%}else{ %>
			<label class="value">-</label>
			<%} %>			
			<div class="clear"></div>  --%> 
			
	 		<label class="medium">Blood Group</label>
			<%if(visit.getHin() != null && visit.getHin().getConfirmedStatus() != null  && !visit.getHin().getConfirmedStatus().equals("") && visit.getHin().getConfirmedStatus().equalsIgnoreCase("y")){
				
				%>
			<label class="auto" id="bloodGroupName"><%=visit.getHin().getBloodGroupValue()  %></label>
			<input type="radio" name="bloodStatus" value="Confirm" checked="checked" disabled="disabled"  class="checkboxMargin"  />
			 <label class="auto">Confirm</label> 
			<%	if(visit.getHin() != null && visit.getHin().getVerbalStatus() != null  && !visit.getHin().getVerbalStatus().equals("") && visit.getHin().getVerbalStatus().equalsIgnoreCase("y") ){%>
			<input type="radio" name="bloodStatus"  value="Verbal" checked="checked" disabled="disabled"  class="checkboxMargin" />
			<label class="auto">Verbal</label>
			<%}else{ %>
			<input type="radio" name="bloodStatus" value="Verbal"   disabled="disabled" class="checkboxMargin" />
			<label class="auto">Verbal</label>
			<%} %>
			
			<%
			}else if(visit.getHin().getBloodGroupValue() != null &&   !visit.getHin().getBloodGroupValue().equals("") && !visit.getHin().getBloodGroupValue().equals("0")){
			%>
			<label class="auto" id="bloodGroupName"><%=visit.getHin().getBloodGroupValue()  %>
			<%-- <input type="hidden" name="bloodGroupName" id="bloodGroupName" value="<%=visit.getHin().getBloodGroupValue()  %>"  /> --%>
			</label>
			
			<%if(visit.getHin() != null && visit.getHin().getConfirmedStatus() != null  && !visit.getHin().getConfirmedStatus().equals("")&& visit.getHin().getConfirmedStatus().equalsIgnoreCase("y")){ %>
			<%}else{%>
			<select name="bloodGroupName"	id="bloodGroupName"  style="width:105px;">
				<option value="0">Select</option>
			<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
				<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
			<%} %>
			</select>
			<%} %>
			
			
			<%if(visit.getHin() != null && visit.getHin().getConfirmedStatus() != null  && !visit.getHin().getConfirmedStatus().equals("") && visit.getHin().getConfirmedStatus().equalsIgnoreCase("y")){ %>
			<input type="radio" name="displayBloodStatus" id="displayBloodStatus" value="y" checked="checked"  disabled="disabled" class="checkboxMargin"  />
			<label class="auto">Confirm</label>
			<%}else{ %>
			<input type="radio" name="bloodStatus"  value="Confirm"  class="checkboxMargin" />
			<label class="auto">Confirm</label>
			<%} %>
			
			
			
			<%	if(visit.getHin() != null && visit.getHin().getVerbalStatus() != null  && !visit.getHin().getVerbalStatus().equals("") && visit.getHin().getVerbalStatus().equalsIgnoreCase("y") ){
				if(visit.getHin().getConfirmedStatus() != null  && !visit.getHin().getConfirmedStatus().equals("") && visit.getHin().getConfirmedStatus().equalsIgnoreCase("y")){
					
			%>
			<!-- <input type="checkbox" name="displayVerbalBloodStatus" id="displayVerbalBloodStatus" value="y" checked="checked" disabled="disabled"  /> -->
			<input type="radio" name="bloodStatus"  value="Verbal"  class="checkboxMargin" />
			<label class="auto">Verbal</label>	
			<%}else{
				
				%>
				<input type="radio" name="bloodStatus"  value="Verbal" checked="checked" class="checkboxMargin"/>	
				<label class="auto">Verbal</label>				
			
			<%}}else{
				%>
			<input type="radio" name="bloodStatus"  value="Verbal" class="checkboxMargin" />
			<label class="auto">Verbal</label>
			
			<%} %>
			
		<%}else{ %>
			<select name="bloodGroupName"	id="bloodGroupName" tabindex=1 style="width:105px;">
				<option value="0">Select</option>
			<%for(MasBloodGroup masBloodGroup : bloodGroupList){ %>
				<option value="<%=masBloodGroup.getBloodGroupName()%>"><%=masBloodGroup.getBloodGroupName()%></option>
			<%} %>
			</select>				
			<input type="radio" name="bloodStatus"  value="Confirm" class="checkboxMargin" />
			<label class="auto">Confirm</label>
			
			
		<%	if(visit.getHin() != null && visit.getHin().getVerbalStatus() != null  && !visit.getHin().getVerbalStatus().equals("") && visit.getHin().getVerbalStatus().equalsIgnoreCase("y") ){ 
			%>
				<input type="radio" name="bloodStatus"  value="Verbal" checked="checked" disabled="disabled" class="checkboxMargin" />
				<label class="auto">Verbal</label>
				<%}else{ %>
				<input type="radio" name="bloodStatus"  value="Verbal"  class="checkboxMargin" />
				<label class="auto">Verbal</label>
				<%} %>
			<%} %>
			
			<label class="auto">Referred Hospital</label>
			<%if(reffredHospital != null && !reffredHospital.equals("")){ %>
			<input type="text" id="refferedHospital" name="refferedHospital" value="<%=reffredHospital %>" readonly="readonly" maxlength="128" style="width:250px;" /> 
			<%}else{ %>
			<input type="text" id="refferedHospital" name="refferedHospital" value="" maxlength="128" style="width:250px;" />
			<%} %>
			<label class="medium">Referred GA</label>
			<%if(refferedGA != null && !refferedGA.equals("")) {%>
			<input type="text" id="refferedGA" name="refferedGA" value="<%=refferedGA %>" readonly="readonly" maxlength="2" class="ageWidth" /> 
			<label class="smallAuto">Weeks</label>
			<%} else { %>
			<input type="text" id="refferedGA" name="refferedGA" value="" maxlength="2" class="ageWidth" onkeypress="javascript:return isNumber(event)"/> 
			<label class="smallAuto">Weeks</label>
            <%} %>  

		<div class="clear"></div>
         <!-- Allergy Tab -->
 		
<h4>Allergies</h4> 	
<div class="clear"></div>
						<div id="divTemplet" style="width:550px; height:59px; margin-left:5px; overflow:auto; overflow-x:hidden;float:left; border:1px solid #036D92;">
							<table style="width:100%; border-top: solid 1px #C0C0C0" id="alergyGrid1">
								<tr>
									<th style="background: rgb(189, 214, 238);padding:0px;">&nbsp;</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Type</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Allergen</th>
									<th style="background: rgb(189, 214, 238);padding:0px;">Remarks</th>									
								</tr>
								<% int incr=0 ;
	 int len=1;
	Integer allergyHeaderId=0;
	Integer allergyDetailId=0;
	if(opdPatientAllergyTs.size()>0){
		len=opdPatientAllergyTs.size();
	}
	MasAllergyProduct masAllergyProductPark=null;
	String allergyName=null;
	MasSeverityCode masSeverityCodePark=null;
	String allergyyear=null;
	String allergymonth=null;
	String allergyRemarks =null;
	for(;incr<len;incr++){
		OpdPatientAllergyT opdPatientAllergyT=null;
		if(opdPatientAllergyTs.size()>0 ){
			opdPatientAllergyT=opdPatientAllergyTs.get(incr);
		}
		if(opdPatientAllergyT!=null){
			masAllergyProductPark=opdPatientAllergyT.getAllergy();
			allergyName=opdPatientAllergyT.getAllergen();
			masSeverityCodePark=opdPatientAllergyT.getSeverity();
			allergyyear=opdPatientAllergyT.getFromYear();
			allergymonth=opdPatientAllergyT.getFromMonth();
			allergyHeaderId=opdPatientAllergyT.getOpdPatientAllergy().getId();
			allergyDetailId=opdPatientAllergyT.getId();
			allergyRemarks = opdPatientAllergyT.getAllergyRemarks();
		}		
	%>
								<tr>
									<td><input type="checkbox" class="radioCheck"
										name="allergyRadio<%=incr%>" id="allergyRadio<%=incr%>" /> <input
										type="hidden"
										value="<%=!allergyDetailId.equals(0)?allergyDetailId:0 %>"
										name="allergyDetailId<%=incr%>" id="allergyDetailId<%=incr%>" />
									</td>
									<td><select class="textYellow" 
										name="allergyType<%=incr%>" id="allergyType<%=incr%>" onchange="validateForAllergy(this.id,'<%=incr%>')">
											<option value="0">Select</option>
											<%for(MasAllergyProduct msap:allergyProductsList){%>
											<%if(masAllergyProductPark!=null && (msap.getId()==masAllergyProductPark.getId())){ %>
											<option selected="selected" value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%}else{ %>
											<option value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
											<%} %>
											<%} %>
									</select> <%
				MasAllergyProduct  masAllergyProduct = new MasAllergyProduct();
				         for (int i = 0; i < allergyProductsList.size(); i++) {
				        	 masAllergyProduct = (MasAllergyProduct) allergyProductsList.get(i);
	     			 %> <script>
	     			allergyTypeArray[<%=i%>]= new Array();
	     			allergyTypeArray[<%=i%>][0] = "<%=masAllergyProduct.getId()%>";
	     			allergyTypeArray[<%=i%>][1] = "<%=masAllergyProduct.getProductName()%>";
	            </script> <% }%></td>
									<td><input type="text" style="width:166px;" class="historyAutoComplete ui-autocomplete-input "
										value="<%=allergyName!=null && !allergyName.equals("")?allergyName:"" %>"
										id="allergyName<%=incr%>" size="35" maxlength="485"
										name="allergyName<%=incr%>" readonly="readonly" /> <div id="allergy_ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div></td>							
									<td><input style="width:166px;" id="allergy_remarks<%=incr%>" name="allergy_remarks<%=incr%>" maxlength="700" readonly="readonly" value="<%=allergyRemarks!=null && !allergyRemarks.equals("")?allergyRemarks:"" %>" /></td>
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="allergyHeaderIds"
								id="allergyHeaderIds" value="<%=allergyHeaderId%>" />
						</div>
						<div style="float:left;width:115px;"><input class="addButSmll" alt="Add" value="&nbsp;" type="button" onclick="addRowForAllergyAntenatal();">
				 <input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForAllergyAntenatal();"> 
				 <input name="" id="" class="buttonAuto" value="Allergy History" style="padding:0px 4px;height:19px; font-size:10px;"  onclick="openPopupWindowAllergyForANC(csrfTokenName+'='+csrfTokenValue);"
				type="button">
				</div>
						
					<input type="hidden" name="allergyCount" id="allergyCount"
						value="<%=incr-1%>" />
<div class="clear"></div>		
<div class="paddingTop5"></div>
		</div>
		<!--Block one Ends-->
         
         <!-- Allergy Tab end -->
		<!--Block two Start-->
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Obstetric Score')" id="obstetricScoreDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Obstetric Score</h4></div>
		 <input name="obstetricValues" type="text"  id="ObstetricValues" style="width: 265px;" placeholder="" readonly="readonly" value="<%=obstetricValues != null?obstetricValues:"" %>" /> 
		 <%-- <label class="auto" name="obstetricValues"   id="ObstetricValues"  value="<%=obstetricValues != null?obstetricValues:"" %>" >  </label>--%>
		<div class="clear"></div>
		<div  id="obstetricScoreDiv" >
		<div class="indArrow"></div>
		<div class="Block" >
			<div class="clear"></div>
			<div class="clear"></div>
			<label class="medium" style="background: yellow;">Gravida </label> 			
			<select name="<%=GRAVIDA %>" class="midium" id="b4"	onchange="gravidaAbortionTwo(); displayPreviousPregnancyDetail(this.value);checkPrimiValue(this.id);displayObstetricScoreValues()">
				<%-- <%if(!gravida.equals("")){			%>
				<option value="<%=gravida%>"><%=gravida%></option>
				<%}else{ %> --%>
				<option value="0" selected="selected">select</option>
				<option value="Primi">Primi</option>
				<!-- <option value="G1">G1</option> -->
				<option value="G2">G2</option>
				<option value="G3">G3</option>
				<option value="G4">G4</option>
				<option value="G5">G5</option>
				<option value="G6">G6</option>
				<option value="G7">G7</option>
				<option value="G8">G8</option>
				<option value="G9">G9</option>
				<option value="G10">G10</option>
				<%-- <%} %> --%>
			</select>
		
			<script>
			document.getElementById('b4').value = '<%=gravida%>';</script> 
			<label class="medium" style="background: yellow;">Parity</label>
		    <input name="<%=PARA %>" type="text" class="inputSmall" id="b5" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Parity,int,no" onchange="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=para%>" />
				
		    <label class="medium" style="background: yellow;">Live Birth</label>
		    <input name="<%=LIVE %>" type="text" class="inputSmall" id="b10" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Live Birth,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=live%>" />
			<!-- <div class="clear"></div> -->	
				
			<label class="medium">Abortion</label>
		    <input name="<%=ABORTIONS %>" type="text" class="inputSmall" id="b6" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Abortion,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=abortion%>" />
				
			<label class="medium">IUD</label>
			 <input name="<%=IUD %>" type="text" class="inputSmall" id="b11" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="IUD,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=iud%>" />				
			
			<div class="clear"></div>	
			<label class="medium">Still Birth</label>
			 <input name="<%=STILLBIRTH %>" type="text" class="inputSmall" id="b12" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Still Birth,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=stillBirth%>" />
			<!-- <div class="clear"></div> -->			
			
			<label class="auto">Neonatal Death</label>
			 <input name="<%=NND %>" type="text" class="inputSmall" id="b13" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Neonatal Death,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=nnd%>" />
			<!-- <div class="clear"></div> -->
				
	  		<label class="medium">MTP</label>
			<input name="<%=MTP %>" type="text" class="inputSmall" id="b9" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="MTP,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=mtp%>" />
			<!-- <div class="clear"></div> -->				
	  
	        <label class="medium">Ectopic</label>
	        <input name="<%=ECTOPIC %>" type="text" class="inputSmall" id="b7" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Ectopic,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=ectopic%>" />
							
	        <label class="medium">Vesicular Mole</label>
	        <input name="<%=VESICULAR %>" type="text" class="inputSmall" id="b8" placeholder="0" 
onkeypress="javascript:return isNumber(event)" validate="Vesicular Mole,int,no" onblur="gravidaAbortionTwo();" onkeyup="displayObstetricScoreValues();" maxlength="2" value="<%=vesicular%>" />	
			
		</div>
	</div>
	
	<div class="Block">
	<label class="auto">LMP</label>
			 <input type="text" class="small" id="lmpId" 
onkeypress="javascript:return isNumber(event)"  validate="LMP,date,no" value="<%=lmp!=null?lmp:""%>" name="<%=LMP %>" readonly="readonly" MAXLENGTH="30"   onblur="checkDate();addMonths();calculateGestationalAgeForScanEdc();displayEDCValue();calculateWeeksForUSG14();"/>
			<%if(scannedEdc != null && !scannedEdc.equals("")){ %>
			
			 <div id="lmpCalenderDiv" style="display: none;">
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('lmpId'),event);"/>
			 </div> 
			 <%}else{ %>
			 <div id="lmpCalenderDiv">
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="myimg" onClick="if(checkUnknownLMP()){setdate('',document.getElementById('lmpId'),event);}"/>
			 </div> 
			 <%} %>		
			 <label class="auto">Unknown</label>
			 <input type="checkbox" name="UnknownLmpStatus" id="UnknownLmpStatus" value="y" class="checkboxMargin" onclick="unknownLmp()" <%=unknownLmpStatus!=null?"checked":""%> <%=lmp!=null?"disabled":""%>/>		 			
			<label class="auto">EDC (LMP)</label> <input
				value="<%=edd!=null?edd:""%>" type="text" id="eddId" name="<%=EDD %>"
				class="inputSmall" readonly="readonly" onblur="eddF();" />					 
					
			<label class="auto">EDC(USG)</label> 
			<input type="text" class="small" id="scannedEdc"
				validate="SCANNED_EDC,date,no" value="<%=scannedEdc!=null?scannedEdc:""%>" name="<%=SCANNED_EDC %>"	readonly="readonly" MAXLENGTH="30" onblur="checkDate();calculateGestationalAgeForScanEdc();displayEDCValue();calculateWeeksForUSG14();" /> 
				<%if(scannedEdc != null && !scannedEdc.equals("")){ %>
				 <div id="lmpCalenderDiv" style="display: none;">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('scannedEdc'),event);" /> </div>  	
		 	 <%}else{ %>
			 <div id="lmpCalenderDiv">
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('scannedEdc'),event);"/>
			 </div> 
			 <%} %>		
				 
		 		<!--  EDC cal field -->	
				
				<label class="auto" style="background: yellow;">Corrected EDC</label>
				<input type="text" class="small" id="edcDate"
				validate="EDC Date,date,no" readonly="readonly" value="<%=edcDate!=null?edcDate:""%>" name="edcDate"	 MAXLENGTH="30"	onblur="checkDate();calculateGestationalAgeForScanEdc();displayEDCValue();calculateWeeksForUSG14();" /> 
				<%if(edcDate != null && !edcDate.equals("")){ %>
				 <div id="lmpCalenderDiv" style="display: none;">
				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('edcDate'),event);" />
				</div>
				<%}else{ %>
			 <div id="lmpCalenderDiv">
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('edcDate'),event);" />
			 </div> 
			 <%} %>		
				
				
				<!-- End EDC -->	
				
				  <label class="auto">Gestational Age</label>
				  <input id="gestationalAgeWeeksId" name="gestationalAgeWeeks" readonly="readonly" validate="Gestational Age,int,no" type="text" maxlength="2" onfocus="calculateGestationalAge();"  class="ageWidth" value="<%=gestationalAgeWeeks%>" /> 
				<label class="smallAuto">Weeks</label>
				<input id="gestationalAgeDaysId" name="gestationalAgeDays" readonly="readonly" validate="Gestational Ag,int,no" type="text" maxlength="2" class="ageWidth" value="<%=gestationalAgeWeeks %>" /> 
				<label class="smallAuto">Days</label>
				
				<input id="duplicateLMP" name="duplicateLMP"  type="hidden" value="" />
	</div>

<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showHideMenstrualHistory()" id="menstrualHistoryDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Menstrual History</h4></div>		
<div class="clear"></div>
<div class="clear"></div>		
<div class="clear"></div>		
		<div  id="menstrualHistoryDiv"  >
		<div class="indArrow"></div>
		<div class="Block">
		<div class="clear"></div>
		<label class="mediumAuto">Menarche</label> <input id="b1" name="<%=MENARCHE %>" onkeypress="javascript:return isNumber(event)"	validate="Menraeche Code,num,no" type="text" maxlength="2"  class="ageWidth" value="<%=menarche%>" /> 
		<label class="smallAuto autoSpace">Years</label>
		<label class="auto">Previous Three Cycle</label>
		
		<select  class="midium" name="<%=CYCLE %>" id="b3" validate="Cycle,string,no" onchange="checkValue(this.value,'1');">
			<%if(!Cycle.equals("")){			%>
			<option value="<%=Cycle%>"><%=Cycle%></option>
			<%}else{ %>
			<option value="">Select</option>			
			<option value="Regular" selected="selected">Regular</option>
			<option value="Irregular">Irregular</option>
			<%} %>
			</select>
		
		<select  class="midium" name="cycleFlow" id="cycleFlow" validate="Cycle,string,no" onchange="checkValue(this.value,'1');">
			<%if(!Cycle.equals("")){			%>
			<option value="<%=cycleFlow%>"><%=cycleFlow%></option>
			<%}else{ %>
			<option value="">Select</option>
			<option value="Normal flow" selected="selected">Normal flow</option>
			<option value="Sub-normal flow">Sub-normal flow</option>			
			<%} %>
			
		</select> 
		<div class="clear"></div>
		<%-- <h4>Previous Three Cycle</h4>
		<div class="clear"></div>
		<label class="auto">Cycle 1 </label><label class="smallAuto autoSpace">(Reg/Irreg)</label>
		<select  class="midium" name="<%=CYCLE1 %>" id="<%=CYCLE1 %>" validate="Cycle1,string,no" onchange="checkValue(this.value,'2');">
			<%if(!Cycle1.equals("")){			%>
			<option value="<%=Cycle1%>"><%=Cycle1%></option>
			<%}else{ %>
			<option value="">Select</option>
			<option value="Normal">Normal</option>
			<option value="AbNormal">AbNormal</option>
			<!-- <option value="Regular">Regular</option>
			<option value="Irregular">Irregular</option>
			<option value="Absent">Absent</option> -->
			<%} %>
		</select> <input id="<%=DAYS1 %>" name="<%=DAYS1 %>" type="text" class="ageWidth"
				validate="Days1,num,no" value="<%=day1%>" maxlength="15" /> <label
				class="smallAuto autoSpace">Days</label>
		
		<label class="auto">Cycle 2 </label>
		<label class="smallAuto autoSpace">(Reg/Irreg)</label>
		<select  class="midium" name="<%=CYCLE2 %>" id="<%=CYCLE2 %>" validate="Cycle2,string,no" onchange="checkValue(this.value,'3');">
			<%if(!Cycle2.equals("")){			%>
			<option value="<%=Cycle2%>"><%=Cycle2%></option>
			<%}else{ %>
			<option value="">Select</option>
			<option value="Normal">Normal</option>
			<option value="AbNormal">AbNormal</option>
			<!-- <option value="Regular">Regular</option>
			<option value="Irregular">Irregular</option>
			<option value="Absent">Absent</option> -->
			
			<%} %>
		</select> <input id="<%=DAYS2 %>" name="<%=DAYS2 %>" type="text" class="ageWidth"
				validate="Days2,num,no" value="<%=day2%>" maxlength="15" /> <label
				class="smallAuto autoSpace">Days</label>
		
		<label class="auto">Cycle 3 </label>
		<label class="smallAuto autoSpace">(Reg/Irreg)</label>
		<select  class="midium" name="<%=CYCLE3 %>" id="<%=CYCLE3 %>" validate="Cycle3,string,no" onchange="checkValue(this.value,'4');" style="width:85px;">
			<%if(!Cycle3.equals("")){			%>
			<option value="<%=Cycle3%>"><%=Cycle3%></option>
			<%}else{ %>
			<option value="">Select</option>
			<option value="Normal">Normal</option>
			<option value="AbNormal">AbNormal</option>
			<!-- <option value="Regular">Regular</option>
			<option value="Irregular">Irregular</option>
			<option value="Absent">Absent</option> -->
			<%} %>
		</select> <input id="<%=DAYS3 %>" name="<%=DAYS3 %>" type="text" class="ageWidth"
				validate="Days3,num,no" value="<%=day3%>" maxlength="15" /> <label
				class="smallAuto autoSpace">Days</label> --%>
        <div class="clear"></div>
		
		</div>
		</div>	
		
		<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showHide();" id="maritalHistoryDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Marital History</h4></div>		
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="maritalHistoryDiv"  >
<div class="indArrow"></div>
		<div class="Block">
		<div class="clear"></div>
		<label>Marital Status</label>
		<%if(maritalStatus != null){
	     String select = "Selected" ;%>
	     <select id="maritalStatus" name="maritalStatus"  class="midium" onchange="diabledAgeAtMarriage(this.value)">
		<option value="Married" <%=maritalStatus.equals("Married")?"selected":""%>>Married</option>
		<option value="Unmarried" <%=maritalStatus.equals("Unmarried")?"selected":""%>>Unmarried</option>
		<option value="Separated" <%=maritalStatus.equals("Separated")?"selected":"" %>>Separated</option>
		<option value="Divorced" <%=maritalStatus.equals("Divorced")?"selected":"" %>>Divorced</option>
		<option value="Living Together" <%=maritalStatus.equals("Living Together")?"selected":"" %>>Living Together</option>
		<option value="II Marriage" <%=maritalStatus.equals("II Marriage")?"selected":"" %>>II Marriage</option>
		<option value="III Marriage" <%=maritalStatus.equals("III Marriage")?"selected":"" %>>III Marriage</option>
		</select>
	     <%}%>

		<!-- <label class="auto">Remarks</label> -->
		<%-- <textarea  type="text" id="marritalHistoryRemarks" name="marritalHistoryRemarks"	style="width: 169px;height: 23px;" maxlength="256" placeholder="Marital status" ><%=marritalHistoryRemarks!=null?marritalHistoryRemarks:"" %> </textarea> --%>
		<textarea type="text" style="width:169px;height:23px" id="marritalHistoryRemarks" name="marritalHistoryRemarks" maxlength="256" placeholder="Marital status" ><%=marritalHistoryRemarks!=null?marritalHistoryRemarks:"" %></textarea>  
		<label class="auto">Age at Marriage</label> <input id="b14" name="<%=YEARS %>" validate="marriage age,num,no" onkeypress="javascript:return isNumber(event)" type="text" maxlength="2"  class="ageWidth" value="<%=years%>" onblur="validationForAgeAtMarriage();" /> 
			<label class="smallAuto">Years</label>
		<input id="b15" name="<%=MONTHS %>" validate="marriage,num,no" type="text" maxlength="2" onkeypress="javascript:return isNumber(event)"  class="ageWidth" value="<%=months%>" onblur="monthValidationForAge(this.value);validationForAgeAtMarriage();" /> 
			<label class="smallAuto">Months</label>
			
		<input id="patientAgeInDaysId" name="patientAgeInDays" onkeypress="javascript:return isNumber(event)" type="hidden" value="<%=ageInDays%>"  /> 
		<input id="patientAgeInMonthId" name="patientAgeInMonthId" onkeypress="javascript:return isNumber(event)" type="hidden" value="<%=ageInMonth%>"  />			
			
			<label class="auto-">Duration of Marriage</label> <input id="durationOfMarriageYearId" name="durationOfMarriageYear" readonly="readonly"
			validate="marriage,num,no" type="text" maxlength="2"   class="ageWidth" value="<%=durationOfMarriageYear %>" /> 
			<label class="smallAuto">Years</label>
		<input  name="durationOfMarriageMonth" id="durationOfMarriageMonthId" validate="marriage,num,no" type="text" maxlength="2" readonly="readonly" class="ageWidth" value="<%=durationOfMarriageMonth %>" /> 
			<label class="smallAuto">Months</label>
		
		<div class="clear"></div>	
		<label>Consanguineous</label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="consanguineousYes" id="consanguineousYes" onclick="return displayYes()"
				type="radio" value="Yes"> Yes</label>
		<label class="autoSpace">
			<input class="radioCheckCol2" name="consanguineousYes" id="consanguineousNo"
			onclick="return displayNo()"
			type="radio" value="No"> No
		</label> 
		<div class="" style="display: none;" id="degreeYes">
		<label class="autoSpace">
				<input class="radioCheckCol2" name="degree" id="degree1"
				type="radio" value="Degree 1"> Degree 1 </label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="degree" id="degree2"
				type="radio" value="Degree 2"> Degree 2 </label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="degree" id="degree3"
				type="radio" value="Degree 3"> Degree 3 </label>
		</div>
		
		<div class="clear"></div>
		<label>Treatment for Infertility</label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="infertilityYes" id="infertilityYes"
				onclick="return displayFactor()"
				type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace">
			<input class="radioCheckCol2" name="infertilityYes" id="infertilityNo"
			onclick="return displayFactorNo()"
			type="radio" value="No"> No
		</label> 
		<div class="" style="display: none;" id="factorYes">
		<label class="autoSpace">
				<input class="radioCheckCol2" name="factor" id="maleFactor"
				type="radio" value="Male Factor"> Male Factor </label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="factor" id="femaleFactor"
				type="radio" value="Female Factor"> Female Factor </label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="factor" id="both"
				type="radio" value="Both"> Both </label>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="factor" id="unExplained"
				type="radio" value="Un Explained"> Un Explained </label>
			
			<label>Infertility Treatment Details</label> 
			<textarea style="width:312px; height:39px;" class="opdMainTextArea" id="<%=INFERTILITY_DETAILS %>" name="<%=INFERTILITY_DETAILS %>"
				 maxlength="200" validate="Infertility Details,string,no"><%=infertilityDetails %></textarea>
			<div class="clear"></div>
		</div>		
		<div class="clear"></div>		
		</div>		
		</div>
<div class="clear"></div>
 <%--	
  <div id="previousPregnancyDetailsDiv">		
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showHidePreviousPregnancyDetails()" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Previous Pregnancy Details</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="previousPregnancyDiv"  >
<div class="indArrow"></div>
<div class="Block">
		<div class="clear"></div>		
			<div class="tableHolderAuto">			
				<div class="floatRight" style="width:130px;">
					<input type="button" class="buttonDel" value=""    onclick="removeRow1('opdAntTable');" /> 
						<input type="button" class="buttonAdd"   onclick="addRowAntTable();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab" style="width:910px">
						<div id="divTemplet2">
							<table border="0" cellspacing="0" cellpadding="0"
								id="opdAntTable">
								<tr>
									<th rowspan="2" scope="col"
										style="border-right-color: #000000;"></th>
									<th colspan="4" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Mother</th>
									<th colspan="4" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Baby</th>
									<th colspan="4" scope="col"
										style="text-align: center; border-bottom-color: #000000; border-right-color: #000000;">Complications</th>

								</tr>
								<tr>
									<th scope="col">No. of Pregnancy</th>
									<th scope="col">Age of Mother at birth</th>
									<th scope="col">Pregnancy Outcome</th>
									<th scope="col" style="border-right-color: #000000;">Place of Delivery</th>
									<th scope="col">Delivery Outcome</th>
									<th scope="col">Gender</th>
									<th scope="col">GA <br/>(weeks Term)</th>
									<th scope="col" style="border-right-color: #000000;">Birth Weight<br/>(kg)</th>
									<th scope="col">Antenatal</th>
									<th scope="col">Intra Partum</th>
									<th scope="col">Post Partum</th>
									<th scope="col" style="border-right-color: #000000;">Blood Transfusion</th>										
								</tr>
								<%
									int opcount = 0;
								int inc = 0;
								int row = 1;
									if (opdAntenatalCardPreg.size() > 0) {
										for (OpdAntenatalCardPregnancy opdP : opdAntenatalCardPreg) {
											if(!opdP.getYear().equals("")){
												opcount = opcount + 1;
								%>

								<tr>
									<td scope="col" align="center" ><%=opcount%></td>
									<td><input type="text" size=3 value="<%=opdP.getYear()%>"
										readonly="readonly" maxlength="2" /></td>
									<td scope="col"><input type="text" size=3
										readonly="readonly" maxlength="2" value="<%=opdP.getAge()%>" /></td>

									<td scope="col"><select  class="smallnew">
											<option value="<%=opdP.getPregnancyOutcome()%>"><%=opdP.getPregnancyOutcome()%></option>
									</select>
									<input type="text" size="11" value="<%=opdP.getPregnancyOutcomePreTermValue() != null?opdP.getPregnancyOutcomePreTermValue():"" %>" readonly="readonly" style="margin-top:5px;"  />
									</td>
									

									<td scope="col"><select  class="smallnew">
											<option value="<%=opdP.getPlaceDelivery()%>"><%=opdP.getPlaceDelivery()%></option>
									</select>
									<input type="text" size="11" value="<%=opdP.getPlaceOfDeliveryOthersValue() != null?opdP.getPlaceOfDeliveryOthersValue():"" %>" readonly="readonly" style="margin-top:5px;"  />
									</td>

									<td><select class="smallnew">
											<option value="<%=opdP.getDeliveryOutcome()%>"><%=opdP.getDeliveryOutcome()%></option>

									</select></td>

									<td><select  class="smallnew">
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
																if (!opdP.getSex().equals("")
																		&& opdP.getSex() != null) {
																	if (masAdministrativeSex.getId().equals(
																			Integer.parseInt(opdP.getSex()))) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex
											.getAdministrativeSexName()%></option>
											<%
												}
																} else {

																}
															}
											%>
									</select></td>
									<td>
									<input type="text" value="<%=opdP.getPreviousGestationalAge() != null?opdP.getPreviousGestationalAge():""%>" maxlength="3" readonly="readonly" style="width:35px;" />
										<div id="element1" style="float: left;"><div style="float: left; width: 110px;">
											<input type="text" value="<%=opdP.getPreviousGestationalAge() != null?opdP.getPreviousGestationalAge():""%>" size=5
												maxlength="2" readonly="readonly" />
										</div>
										<div id="element2" style="padding-left: 20px; float: left;">
											<label>weeks</label>
										</div></div>
									</td>

									<td><input type="text" value="<%=opdP.getBirthWeight()%>" maxlength="5" onkeypress="javascript:return isNumber(event)" readonly="readonly" style="width:35px;" />
										<div id="element1" style="float: left;"><div style="float: left; width: 110px;">
											<input type="text" value="<%=opdP.getBirthWeight()%>" size=5
												maxlength="2" readonly="readonly" />
										</div>
										<div id="element2" style="padding-left: 20px; float: left;">
											<label>/kg</label>
										</div></div>
									</td>

									<td><input type="text" readonly="readonly" maxlength="300" value="<%=opdP.getAntenatal()%>" style="width:60px;" placeholder="NIL"/></td>
									<td><input type="text" readonly="readonly" maxlength="300" value="<%=opdP.getIntraPartum()%>" style="width:60px;" placeholder="NIL" /></td>
									<td><input type="text" readonly="readonly" maxlength="300" value="<%=opdP.getPostPartum()%>" style="width:60px;" placeholder="NIL" /></td>

									<td> <select class="YesNo">
											<option value="<%=opdP.getBloodTransfusion()%>"><%=opdP.getBloodTransfusion()%></option>

									</select></td>
								</tr>
								<%
								row = row+1;
										}
									}
										}
									
								%>
						
								<%
									int opdincr = 0, opdlen = 1;
									int opdinxRow = 1;
									int opdinxCol = 0;
									// 								if(exist==1){
									// 									opdlen=0;

									// 								}
									for (; opdincr < opdlen; opdincr++, opdinxRow++) {
										opdincr=opdincr+1;
								%>
								<tr>
									<td scope="col"><input type="checkbox"  class="radioCheck" id="itemRadioAnt<%=opdincr%>" name="itemRadioAnt<%=opdincr%>" onchange="checkPrescriptionCheck(<%=opdincr%>)" /></td>

									<td scope="col"><input name="<%=YEAR%><%=opdincr%>" id="<%=YEAR%><%=opdincr%>" value="<%=opdincr%>" type="text" size=3 maxlength="2" onkeypress="javascript:return isNumber(event)"  validate="Year,num,no"
										 oninput="callAge('<%=YEAR%><%=opdincr%>','<%=AGE_UNIT%><%=opdincr%>');"/></td>

									<td scope="col"><input id="<%=AGE_UNIT%><%=opdincr%>" onblur="checkMotherPreviousPregnancyAge(this.value,this.id);checkNoOfPreganancy(<%=opdincr%>);" name="<%=AGE_UNIT%><%=opdincr%>" type="text" size=3 
onkeypress="javascript:return isNumber(event)" validate="Age,num,no"	 maxlength="2" /></td>

									<td scope="col"><select  class="smallnew"
										name="<%=PREGNANCY_OUTCOME%><%=opdincr%>"
										id="<%=PREGNANCY_OUTCOME%><%=opdincr%>"
										 onchange="displayPreTermValue(this.value,<%=opdincr%>);">
											<option value="">select</option>
											<option value="FTND">FTND</option>
											<option value="Vacuum">Vacuum</option>
											<option value="Forceps">Forceps</option>
											<option value="LSCS">LSCS</option>
											<option value="Abortion">Abortion</option>
											<option value="Ectopic">Ectopic</option>
											<option value="Vesicular Mole">Vesicular Mole</option>
											<option value="Pre Term">Pre Term</option>
											<option value="VBAC">VBAC</option>
									</select>
									<input name="preTermValue<%=opdincr%>" 
										id="preTermValueId<%=opdincr%>" type="text" size="11" maxlength="100" validate="Others,string,no"
										 style="display:none; margin-top:5px;"   />
									
									</td>
									
									<td scope="col"><select  class="smallnew"
										name="<%=PLACE_OF_DELIVERY%><%=opdincr%>"
										id="<%=PLACE_OF_DELIVERY%><%=opdincr%>"
										  onchange="displayOthersValue(this.value,<%=opdincr%>);">
											<option value="">select</option>
											<option value="CHC">CHC</option>
											<option value="PHC">PHC</option>
											<option value="District Hospital">District Hospital</option>
											<option value="Private">Private</option>
											<option value="Others">Others</option>
									</select>
									<input name="placeOfDeliveryOthers<%=opdincr%>" 
										id="placeOfDeliveryOtherId<%=opdincr%>" type="text" size="11" maxlength="100" validate="Others,string,no"
										 style="display:none; margin-top:5px;" />
									
									</td>

									<td scope="col"><select id="deliveryOutcome<%=opdincr%>"  class="smallnew"
										name="deliveryOutcome<%=opdincr%>" onchange="displayLiveBirthValue(this.value,<%=opdincr%>);"
										>
											<option value="">select</option>
											<option value="Live">Live</option>
											<option value="Still Birth">Still Birth</option>
											<option value="IUD">IUD</option>
											<option value="NND">NND</option>
									</select></td>

									<td scope="col"><select name="<%=SEX%><%=opdincr%>"  class="smallnew"
										id="<%=SEX%><%=opdincr%>"
										>
											<option value="0">Select</option>
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
											<%
												}
											%>
									</select></td>
									
									<td scope="col"><!-- <div style="float: left; width: 110px;"> --><input id="previousGestationalAgeId<%=opdincr%>"
										name="previousGestationalAge<%=opdincr%>" type="text" style="width:35px;" onkeypress="javascript:return isNumber(event)" validate="Gestational Age,int,no" onblur="checkGAInPreviousPregnancy(this.value,this.id);"
										maxlength="3"  /><!-- <label
										class="smallAuto autoSpace">weeks</label></div> --></td>
									

									<td scope="col"><!-- <div style="float: left; width: 110px;"> --><input id="<%=BIRTH_WEIGHT%><%=opdincr%>"
										name="<%=BIRTH_WEIGHT%><%=opdincr%>" type="text" style="width:35px;" onkeypress="javascript:return isNumber(event)" maxlength="5"   /><!-- <label
										class="smallAuto autoSpace">/kg</label></div> --></td>

									<td scope="col"><input type="text"
											id="antenatal<%=opdincr%>"
											name="antenatal<%=opdincr%>" maxlength="220" placeholder="NIL"
											 style="width:60px;" /></td>
									<td scope="col"><input type="text"
											id="intraPartum<%=opdincr%>"
											name="intraPartum<%=opdincr%>" maxlength="220" placeholder="NIL"
											 style="width:60px;" /></td>
									<td scope="col"><input type="text"
											id="postPartum<%=opdincr%>"
											name="postPartum<%=opdincr%>" maxlength="220" placeholder="NIL"
											 style="width:60px;" /></td>
									
									<td scope="col"><select id="<%=BLOOD_TRANSFUSION%><%=opdincr%>" class="YesNo"
										name="<%=BLOOD_TRANSFUSION%><%=opdincr%>"
										>
											<option value="">select</option>
											<option value="Yes">Yes</option>
											<option value="No">No</option>
									</select></td>
								</tr>
								<% } %>
							</table>
							<input type="hidden" name="opdhdb" value="<%=opdincr -1%>"
								id="opdhdb" /> <input type="hidden" name="opdhdbTabIndex"
								id="opdhdbTabIndex" value="<%=opdinxRow - 1%>" />
						</div>
					</div>
				</div>
			
			</div>  --%>
			
			<!-- swarup------------------------------start------------------------------------------- -->
  <div id="previousPregnancyDetailsDiv">		
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showHidePreviousPregnancyDetails()" id="previousPregnancyDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab" style="font-size:14px;">Previous Pregnancy Details</h4></div>
<div class="clear"></div>

<div  id="previousPregnancyDiv"  >
<div class="indArrow"></div>
<div class="Block">
		<div class="clear"></div>		
			   		<div class="tableHolderAuto">			
				<div class="floatRight" style="width:130px;">
					<!-- <input type="button" class="buttonDel" value=""    onclick="removeRow1('opdAntTable');" /> 
						<input type="button" class="buttonAdd"   onclick="addRowAntTable();" value="" /> -->
				</div>
				<div class="clear"></div>
				<div class="">
				<input name="<%=YEAR%>" id="<%=YEAR%>" value="<%=visit.getHin().getDateOfBirth()!=null && !visit.getHin().getDateOfBirth().equals("")? HMSUtil.getCurrentAgeByDoB(visit.getHin().getDateOfBirth()):"" %>" type="hidden" size=3 maxlength="2"   validate="Year,num,no"/>
					<div class="tableForTab" style="width:1160px" id="prevPregnancyDtDiv">
						<div id="divTemplet2">
						
			 				<div class="tableForTab fixedWidth900">
							<%int counter = 0;
							int c=0;
							Map<Integer, OpdAntenatalCardPregnancy> prevPregnancyDt = null;
							OpdAntenatalCardPregnancy opcd =null;
							if(opdAntenatalCardPreg.size()>0)
							prevPregnancyDt = new HashMap<Integer, OpdAntenatalCardPregnancy>();
							
							for (OpdAntenatalCardPregnancy opdP : opdAntenatalCardPreg){
								counter++;
							 	opcd = new OpdAntenatalCardPregnancy();
								opcd.setNoOfPregnancy(counter);
								opcd.setAntenatal(opdP.getAntenatal());
								opcd.setAge(opdP.getAge());
								opcd.setPlaceDelivery(opdP.getPlaceDelivery());
								opcd.setDeliveryOutcome(opdP.getDeliveryOutcome());
								opcd.setPregnancyOutcomePreTermValue(opdP.getPregnancyOutcomePreTermValue());
								opcd.setPregnancyOutcome(opdP.getPregnancyOutcome());
								opcd.setSex(opdP.getSex());
								opcd.setPreviousGestationalAge(opdP.getPreviousGestationalAge());
								opcd.setBirthWeight(opdP.getBirthWeight());
								opcd.setIntraPartum(opdP.getIntraPartum());
								opcd.setPostPartum(opdP.getPostPartum());
								opcd.setRemarks(opdP.getRemarks());
								prevPregnancyDt.put(counter-1, opcd); 
							
							
							 
							%>
								<p>
								  <b>Pregnancy No:</b><%=opdP.getNoOfPregnancy()%>
									   <b>Age of Mother:</b><%=opdP.getAge()%>Yrs 
									   
									   <%if(opdP.getPlaceDelivery()!=null && !opdP.getPlaceDelivery().isEmpty()){%> 
									   <b>Pregnancy Outcome:</b><%=opdP.getPregnancyOutcome()%>
									   <%}%>
									   
									    <%if(opdP.getPregnancyOutcomePreTermValue()!=null && !opdP.getPregnancyOutcomePreTermValue().isEmpty()){%> 
									   <b>Pre Term Remarks:</b><%=opdP.getPregnancyOutcomePreTermValue()%>
									   <%}%>
									   
									  <%if(opdP.getPlaceDelivery()!=null && !opdP.getPlaceDelivery().isEmpty()){%>
									   <b>Place of Outcome:</b><%=opdP.getPlaceDelivery()%> 
									  <%}%>
									  
									  <%if(!opdP.getDeliveryOutcome().isEmpty()){%>
										 <b>Delivery Outcome:</b><%=opdP.getDeliveryOutcome()%> 
										<%}%>
										
										<%if(opdP.getSex()!=null&&!opdP.getSex().isEmpty()){%>
										 <b>Gender:</b>
										<%if(!opdP.getSex().isEmpty()){for (MasAdministrativeSex masAdministrativeSex : sexList) {
											if(masAdministrativeSex.getId()==Integer.parseInt(opdP.getSex())){%>
										<%=masAdministrativeSex.getAdministrativeSexName()%> 		
											
											<%break;}
										}}%>
										<%}%>
										
										<%if(opdP.getPreviousGestationalAge()!=null && !opdP.getPreviousGestationalAge().isEmpty()){%>
										 <b>GA:</b><%=opdP.getPreviousGestationalAge()%>
										in Weeks: <%}%>
										
										<%if(opdP.getBirthWeight()!=null && opdP.getBirthWeight()!=0.0){%>
										 <b>Birth Weight:</b><%=opdP.getBirthWeight()%> kg
										<%}%>
										
										<%if(opdP.getBloodTransfusion()!=null && !opdP.getBloodTransfusion().isEmpty()){%>
										 <b>Blood Transfusion:</b> <%=opdP.getBloodTransfusion()%>
										<%}%>
										
										<%if(opdP.getPostPartum()!=null && !opdP.getPostPartum().isEmpty()){%>
										 <b>Antenatal:</b><%=opdP.getAntenatal()%> 
										<%}%>
										<%if(opdP.getPostPartum()!=null && !opdP.getPostPartum().isEmpty()){%>
										  <b>Intra Partum:</b><%=opdP.getIntraPartum()%> 
										 <%}%>
										 <%if(opdP.getPostPartum()!=null && !opdP.getPostPartum().isEmpty()){%>
										  <b>Post Partum:</b><%=opdP.getPostPartum()%> 
										 <%}%>
										 <%if(opdP.getRemarks()!=null && opdP.getRemarks()!=null&&!opdP.getRemarks().isEmpty()){%>
										 <b>Remarks:</b><%=opdP.getRemarks()%>
										<%}%>
										</p>
										<div class="clear"></div>
										<div class="divisionSolid"></div>
								        <div class="clear"></div>
								
							
							<%}
							if(prevPregnancyDt!=null)
								session.setAttribute("prevPregnancyDt", prevPregnancyDt);
							%>
							</div> 
						
						
						
					<%-- 	     <%
									int opcount = 0;
								int inc = 0;
								int row = 1;
									if (opdAntenatalCardPreg.size() > 0) {
										for (OpdAntenatalCardPregnancy opdP : opdAntenatalCardPreg) {
											if(!opdP.getYear().equals("")){
												opcount = opcount + 1;
								%>

								 
								<%
								row = row+1;
										}
									}
										}
									
								%>
								 
								<%
									int opdincr = 0, opdlen = 1;
									int opdinxRow = 1;
									int opdinxCol = 0;
								 	for (; opdincr < opdlen; opdincr++, opdinxRow++) {
										opdincr=opdincr+1;
								%>    --%>
						  
						 
						
<!-- 						 <label style="background:none;box-shadow:none;" class="auto">Previous Pregnancy Details</label> --> 
						<!-- <input type="text" style="width: 800px;height: 108px;" readonly="readonly"> --> 
						<%-- <textarea name="previousValues1" type="text" style="width: 800px;height: 108px;" id="PreviousPregnancyDetails" placeholder="" readonly="readonly" value="<%=obstetricValues != null?obstetricValues:"" %>" ></textarea> --%>
						<%---Start preg dt --%>
						
						<div class="clear"></div>
						<div class="paddingTop5"></div>
						<label  class="auto">Mother</label> 
						
						
						<%-- <label class="auto bgNone">Pregnancy No.</label> 
						<label class="auto"><%=counter+1%> <input type="hidden" name="noOfPregnancy" id="noOfPregnancy" value="<%=counter+1%>"></label>   
						 --%>
						<label class="auto bgNone">Pregnancy No.</label> 
                        <label ><input type="text" size=3 maxlength="2" name="noOfPregnancy" id="noOfPregnancy" value="<%=counter+1%>" onkeypress="javascript:return isNumber(event)" style="width: 20px;height:20px;"></label>   
						 
						 
						<label class="auto bgNone">Age of Mother</label> 
						<input id="<%=AGE_UNIT%>"  onblur="checkMotherPreviousPregnancyAge(this.value,this.id);" name="<%=AGE_UNIT%>" type="text" size=3 onkeypress="javascript:return isNumber(event)" validate="Age,num,no"  maxlength="2"  style="width: 20px;height:20px;"/>  
 
						<label class="smallAuto">Yrs</label> 
				 		<label class="auto bgNone">Pregnancy Outcome</label> 
						<select class="medium" multiple="5" style="height:65px;" name="<%=PREGNANCY_OUTCOME%>" onchange="displayPreTermValue(this.value);toggleBabyDetails();displayPregnancyOutComeSelection(this.value);checkForFTND();" id="<%=PREGNANCY_OUTCOME%>">
											<option value="" dis>Select</option>
											<option value="FTND">FTND</option>
											<option value="Vacuum">Vacuum</option>
											<option value="Forceps">Forceps</option>
											<option value="LSCS">LSCS</option>
											<option value="Abortion">Abortion</option>
											<option value="Ectopic">Ectopic</option>
											<option value="Vesicular Mole">Vesicular Mole</option>
											<option value="Pre Term">Pre Term</option>
											<option value="VBAC">VBAC</option>
											<option value="Normal vaginal delivery">Normal vaginal delivery</option>
											</select>											
									<input name="preTermValue" 
										id="preTermValueId" type="text" size="11" maxlength="100" validate="Others,string,no"
										 style="display:none; margin-top:5px;"/>
										 <textarea name="pregnancyOutComeSelection" id="pregnancyOutComeSelection" readonly="readonly" cols="0" rows="0" maxlength="256" style="width:169px;height:30px; display: none"></textarea>
										 
							<div class="clear"></div>		
						<label class="auto bgNone">Place of Outcome</label> 
						
						<select  style="width:140px;" name="<%=PLACE_OF_DELIVERY%>" id="<%=PLACE_OF_DELIVERY%>" onchange="displayOthersValue(this.value);">
											<option value="">Select</option>
											<option value="CHC">CHC</option>
											<option value="PHC">PHC</option>
											<option value="DH">DH</option>
											<option value="Private Hospital">Private Hospital</option>
											<option value="W&C">W&C</option>
											<option value="Private-Multispecialty">Private-Multispecialty</option>
											<option value="Home Delivery">Home Delivery</option>
											<option value="Others">Others</option>
											</select>
									<input name="placeOfDeliveryOthers"  id="placeOfDeliveryOtherId" type="text" size="11" maxlength="100" validate="Others,string,no"	style="display:none;" />
						
					 	<div class="clear"></div>
						<label  class="auto" style="width: 40px;">Baby</label>						
						<label style="background:none;box-shadow:none" class="auto">Delivery Outcome</label> 
						
						<!-- <select id="deliveryOutcome" class="medium2" name="deliveryOutcome" onchange="displayLiveBirthValue(this.value,);" > -->
						<select id="deliveryOutcome" class="medium2" name="deliveryOutcome">
											<option value="">Select</option>
											<option value="Live">Live</option>
											<option value="Still Birth">Still Birth</option>
											<option value="IUD">IUD</option>
											<option value="NND">NND</option>
											</select> 
						
									
				 		<label class="auto bgNone">Gender</label> 
						<select name="<%=SEX%>" class="medium2" id="<%=SEX%>">
											<option value="0">Select</option>
											<%
												for (MasAdministrativeSex masAdministrativeSex : sexList) {
											%>
											<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
											<%
												}
											%>
											</select>
						
						<label class="auto bgNone">GA</label> 
						<input id="previousGestationalAgeId" name="previousGestationalAge" type="text" style="width: 20px;height:20px;" onkeypress="javascript:return isNumber(event)" validate="Gestational Age,int,no" onblur="checkGAInPreviousPregnancy(this.value,this.id);" maxlength="3" autocomplete="off"/>
						<label class="smallAuto">Weeks</label> 
						
						<label class="auto bgNone">Birth Weight</label> 
						<input id="<%=BIRTH_WEIGHT%>" id="b100" name="<%=BIRTH_WEIGHT%>" type="text" style="width:35px;" onkeypress="javascript:return isNumber(event)" maxlength="5" autocomplete="off" onblur="checkMaxLimit(this.value,this.id,'10')"/>
						<label class="smallAuto">Kg</label>
						<label class="auto">Blood Transfusion</label>
						<select id="<%=BLOOD_TRANSFUSION%>" class="YesNo"
										name="<%=BLOOD_TRANSFUSION%>" >
											<option value="">Select</option>
											<option value="Yes">Yes</option>
											<option value="No" selected="selected">No</option>
									</select>
						<div class="clear"></div>
						<h4 style="text-align:left;">Complications</h4> 						
						<div class="clear"></div>
						 <label class="medium">Antenatal</label> 
						<textarea type="text" style="width:465px;height:60px" id="antenatal" name="antenatal" maxlength="220" placeholder="NIL" style="width:60px;" ></textarea>  
						
						
						 <label class="medium">Intra Partum</label> 
						<textarea type="text" style="width:465px;height:60px" id="intraPartum" name="intraPartum" maxlength="220" placeholder="NIL" style="width:60px;" ></textarea>  
						
						<div class="clear"></div>
						 <label class="medium">Post Partum</label> 
						<textarea type="text" style="width:465px;height:60px" id="postPartum"   name="postPartum" maxlength="220" placeholder="NIL" style="width:60px;" ></textarea>  
						
						<label class="medium">Remarks</label>
						<textarea type="text" style="width:465px;height:60px" id="remarkforPrePreg" name="remarkforPrePregs" maxlength="220"></textarea>
						
						<div class="clear"></div>
						<div class="paddingTop5"></div>						
						<%-- <input type="button" value="Save & Next>" style="float:right;margin-right:16px;" onclick="displayNSavePregnancyDetails(<%=counter%>,'n');"> --%>
				<%-- 				<%if(counter!=0){
						%>
						<input type="button" style="margin-left:930px;" value="<Previous" onclick="displayNSavePregnancyDetails(<%=counter-1%>,'y')"><%}%> --%>
						<input type="button" style="float:right;margin-right:16px;" value="Save & Next>" onclick="displayNSavePregnancyDetails(<%=counter%>,'n');">
						
						<%-- <% } %> --%>
						
						<%---Start preg dt --%>
							<%-- <input type="hidden" name="opdhdb" value="<%=opdincr -1%>"
								id="opdhdb" /> <input type="hidden" name="opdhdbTabIndex"
								id="opdhdbTabIndex" value="<%=opdinxRow - 1%>" /> --%>
								<input type="hidden" name="totalPreDt" value="<%=counter%>" id="totalPreDt"/>
								<input type="hidden" name="prevTotal" value="<%=counter%>" id="prevTotal"/> 
								
						<div class="clear"></div>
						<div class="clear"></div>		
						</div>
					</div>
				</div>
			
			</div>    
<!-- swarup -------------------------------------------------------------->			
			
		
		<div class="clear"></div>
			<label>Medical Disorders</label> 
			<textarea class="opdMainTextArea" name="medicalDisord" id="medicalDisord" maxlength="250" onblur="populateLabelValue(this.value,'medDisorderDisplay')"><%=medicalDisor %></textarea>
			
			<label class="heightAuto">Present Obstetric Complications </label> 
			<textarea class="opdMainTextArea" name="obstetricComplications" id="obstetricComplications" maxlength="250" onblur="populateLabelValue(this.value,'ObsComplicationDisplay')"><%=obstetricComplications != null?obstetricComplications:"" %></textarea>
			
			<div class="clear"></div>
		
				<%-- <div class="division"></div>
			<div class="clear"></div>
			<div class="floatLeft" style="width: 250px;">
				<table width="40%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col">MEDICAL DISORDERS</th>
					</tr>
					<tr>
						<td><textarea class="opdMainTextArea" name="medicalDisord"
								id="medicalDisord" maxlength="300"><%=medicalDisor %></textarea></td>
					</tr>
				</table>
			</div>
		</div> 
		<div class="division"></div>--%>
		</div>
		</div>
		</div>
		<div class="clear"></div>
		
<div class="plusDiv"><input class="plusMinus" onclick="displayCollapsibleTab('Past Medical History')" id="pastMedicalHistoryId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Past Medical History</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="pastMedicalHistory"  >
<div class="indArrow"></div>

        <div class="clear"></div>
		<div class="Block" >
		<div class="summaryDivMain-" onclick="populatePastHistorySummary();">
		<label>Past History Summary</label>
		<div style="width:975px;height:65px;margin-left:0;" class="summaryDetails"><p id="pastHistorySummary" ><%=comorbidityText.toString()%><%=infectionText.toString()%><%=surgeryText.toString()%></p></div>
		</div>
</div>

<div class="clear"></div>
<div class="Block">
		
<div class="tableLeftDiv">
<h4 style="float:left;width:200px;">Comorbidity</h4>
<div class="floatRight" style="width:122px;">
<input type="button" class="buttonDel" value=""  onclick="removeRowForPastMedicalHistory('pastMedHistTable');" />
<input type="button" class="buttonAdd" onclick="addPMHRow();" value="" />
</div>
			<div class="clear"></div>
				<div class="tableForTab" style="width:574px">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="pastMedHistTable">
							<input type="hidden" name="patAge" id="patAge" value="<%= patAge%>">
							<tr>
								<th scope="col">Sl No.</th>
								<th colspan="1" scope="col">Comorbidity</th>
								<th colspan="1" scope="col">Since</th>
								<th colspan="1" scope="col">Remarks</th>
							</tr>
							<%	
							int mhcount = 0;
							int mhinc = 0;
							int mhrow = 1;
							if(opdAntenatalCardMedHist.size()>0){
								for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){
									mhcount = mhcount + 1;
									if(opdMH.getComorbidity() != null && !opdMH.getComorbidity().equals("")) {
							%>
									<tr>
								<%-- 	<td scope="col" align="center"><%=mhcount%></td> --%>
								<td><input type="checkbox" class="radioCheck" disabled="disabled" /></td>
								
									<td scope="col"><select>
										<% if(opdMH.getComorbidity() != null && !opdMH.getComorbidity().equals("")) { %>
											<option value="<%=opdMH.getComorbidity()%>"><%=opdMH.getComorbidity()%></option>
										<% } %>
										</select>
										<% if(opdMH.getChronicDisease() != null && !opdMH.getChronicDisease().equals("")) { %>
											<textarea readonly="readonly" maxlength="300"><%=opdMH.getChronicDisease()%></textarea>
										<% } %>
										<% if(opdMH.getOtherDisease() != null && !opdMH.getOtherDisease().equals("")) { %>
											<textarea readonly="readonly" maxlength="300"><%=opdMH.getOtherDisease()%></textarea>
										<% } %>
									</td>
									<td>
									<div style="width:196px; float:left;">
										<% if(opdMH.getYears() != null && !opdMH.getYears().equals("")) { %>
											<input type="text" size=3 value="<%=opdMH.getYears()%>"
												readonly="readonly" maxlength="2" /><label class="smallAuto">Years</label>
										<% } %>
										<% if(opdMH.getMonths() != null && !opdMH.getMonths().equals("")) { %>
											<input type="text" size=3 readonly="readonly" maxlength="2" value="<%=opdMH.getMonths()%>" />
											<label class="smallAuto">Months</label>
										<% } %>
										</div>
									</td>
									<td>
										<% if(opdMH.getRemarks() != null && !opdMH.getRemarks().equals("")) { %>
											<textarea readonly="readonly" maxlength="300"><%=opdMH.getRemarks()%></textarea>
										<% } %>
									</td>
								</tr>
									<%}
									mhrow = mhrow + 1;
								}
							} %>
							<%
							int pmhincr = 0, lenPmh = 1;
							int pmhinxRow = 1;
							int pmhinxCol = 0;
							for (; pmhincr < lenPmh; pmhincr++, pmhinxRow++) {
						%>
							<tr>
								<td><input type="checkbox"
									 class="radioCheck"
									id="pmhitemRadio<%=pmhincr%>" name="pmhitemRadio<%=pmhincr%>"
									onchange="checkPrescriptionCheck(<%=pmhincr%>);" /></td>
								<td scope="col"><select
									name="<%=COMORBIDITY%><%=pmhincr%>"
									id="<%=COMORBIDITY%><%=pmhincr%>"
									 onchange="ShowHideDisease(<%=pmhincr%>);chronicDisease(<%=pmhincr%>);populatePastHistorySummary();" >
										<option value="">select</option>
										<option value="Diabetes Mellitus - Type I">Diabetes Mellitus - Type I</option>
										<option value="Diabetes Mellitus - Type II">Diabetes Mellitus - Type II</option>
										<option value="Hypertension">Hypertension</option>
										<option value="Coronary Artery Disease">Coronary Artery Disease</option>
										<option value="Cancer">Cancer</option>
										<option value="Chronic Kidney Disease">Chronic Kidney Disease</option>
									    <option value="Seizure disorder">Seizure disorder</option>
									     <option value="Heart disease">Heart disease</option>
									     <option value="Asthma">Asthma</option>
									     <option value="Psychiatric disease">Psychiatric disease</option>
									     <option value="Thrombotic disease">Thrombotic disease</option>
									     <option value="Hematological disease">Hematological disease</option>
									     <option value="Renal disease">Renal disease</option>
									     <option value="SLE">SLE</option>
									     <option value="PCOD">PCOD</option>
									     <option value="Hepatitis B Carrier">Hepatitis B Carrier</option>
									     <option value="VDRL +ve">VDRL +ve</option>
									     <option value="HCV carrier">HCV carrier</option>
									     <option value="HIV +ve">HIV +ve</option>
									     <option value="APLA">APLA</option>									     
									     <option value="Osteoporosis">Osteoporosis</option>
									     <option value="Osteogenesis">Osteogenesis</option>
									     <option value="Connective tissue disorder">Connective tissue disorder</option>
									     <option value="CPD">CPD</option>
									     <option value="Congenital diseases">Congenital diseases</option>
									     
										<option value="Others">Others</option>
									</select>
									<textarea style="display: none; placeholder="Chronic Disease"
										name="<%=COM_CHRONIC_DISEASE%><%=pmhincr%>" id="<%=COM_CHRONIC_DISEASE%><%=pmhincr%>"
										maxlength="300" onkeyup="populatePastHistorySummary();" ></textarea>
									<textarea placeholder="Other Disease"  style="display: none;"
										name="<%=COM_OHTER_DISEASE%><%=pmhincr%>" id="<%=COM_OHTER_DISEASE%><%=pmhincr%>"
										maxlength="300" onkeyup="populatePastHistorySummary();"></textarea>
								</td>
								
								<td>
								<div style="width:196px; float:left;">
								<input id="<%=COM_YEARS%><%=pmhincr%>" name="<%=COM_YEARS%><%=pmhincr%>"
									 validate="comYears,num,no" onkeypress="javascript:return isNumber(event)" type="text" maxlength="2"  size="3"  onblur="yearValidation(this.id,'<%= patAge%>')" onkeyup="populatePastHistorySummary();"/> 
									<label class="smallAuto">Years</label>
									<input id="<%=COM_MONTHS%><%=pmhincr%>" name="<%=COM_MONTHS%><%=pmhincr%>"
									 validate="comMonths,num,no" onkeypress="javascript:return isNumber(event)" type="text" maxlength="2"  size="3" onblur="monthValidation(this.value,this.id);" onkeyup="populatePastHistorySummary();" /> 
									<label class="smallAuto">Months</label></div>
									</td>
								
								<td><textarea id="<%=COM_REMARKS%><%=pmhincr%>" name="<%=COM_REMARKS%><%=pmhincr%>"
										maxlength="250" class="historyAutoComplete" onkeyup="populatePastHistorySummary();"></textarea></td>
								
							</tr>
							<% } %>
						</table>
						<input type="hidden" name="pmhhdb" value="<%=pmhincr -1%>"
							id="pmhhdb" /> <input type="hidden" name="pmhhdbTabIndex"
							id="pmhhdbTabIndex" value="<%=pmhinxRow - 1%>" />
						<!-- Jyotish changes for infection and surgery -->
					</div>
				</div>	
<div class="clear"></div>
</div>

<div class="tableRightDiv">
<h4 style="float:left;width:200px;">Infections</h4>
<div class="floatRight" style="width:122px;">
<input type="button" class="buttonDel" value=""  onclick="removeRowForPastMedicalHistory('infectionTable');" />
<input type="button" class="buttonAdd"  onclick="addInfectRow();" value="" />
</div>
<div class="clear"></div>
<div class="tableForTab" style="width:574px">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="infectionTable">
							<tr>
								<th scope="col">Sl No.</th>
								<th colspan="1" scope="col">Infections</th>
								<!-- <th colspan="1" scope="col">Since</th> -->
								<th colspan="1" scope="col">Remarks</th>
							</tr>
							<%	
							 int infecCount = 0;
							int infectInc = 0;
							int infectRow = 1;
							if(opdAntenatalCardMedHist.size()>0){
								for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){
									infecCount = infecCount + 1;
									if(opdMH.getInfection() != null && !opdMH.getInfection().equals("")) { 
							%>
									<tr>
								<td><input type="checkbox"  class="radioCheck" disabled="disabled" /></td>
									<td scope="col"><select>
										<% if(opdMH.getInfection() != null && !opdMH.getInfection().equals("")) { %>
											<option value="<%=opdMH.getInfection()%>"><%=opdMH.getInfection()%></option>
										<% } %>
										</select>
										<% if(opdMH.getInfectionOthers() != null && !opdMH.getInfectionOthers().equals("")) { %>
											<textarea readonly="readonly" maxlength="300" style="float: right;"><%=opdMH.getInfectionOthers()%></textarea>
										<% } %>
									</td>
									<td>
										<% if(opdMH.getInfectionRemarks() != null && !opdMH.getInfectionRemarks().equals("")) { %>
											<textarea readonly="readonly" maxlength="300"><%=opdMH.getInfectionRemarks()%></textarea>
										<% } %>
									</td>
								</tr>
									<%}
									infectRow = infectRow + 1;
								}
							} %>
							<%
								
							int infecIncr = 0, lenInfection = 1;
							int infectionRow = 1;
							int infectionCol = 0;
							for (; infecIncr < lenInfection; infecIncr++, infectionRow++) {
						%>
							<tr>
								<td><input type="checkbox" class="radioCheck" id="ancInfRadio<%=infecIncr%>" name="ancInfRadio<%=infecIncr%>" /></td>
								<td scope="col"><select
									name="ancInfection<%=infecIncr%>"
									id="ancInfection<%=infecIncr%>"
									 onchange="showInfectOthers(<%=infecIncr%>);populatePastHistorySummary();">
										<option value="">select</option>
										<option value="Chicken pox">Chicken pox</option>
										<option value="Rubella">Rubella</option>
										<option value="Toxoplasma">Toxoplasma</option>
										<option value="Cytomegalovirus">Cytomegalovirus</option>
										<option value="Upper respiratory Infection">Upper respiratory Infection</option>
										<option value="Urinary Tract Infection">Urinary Tract Infection</option>
										<option value="Malaria">Malaria</option>										
										<option value="Others">Others</option>
									</select>	
									<textarea placeholder="Other Disease"  style="display: none; float: right;"
										name="infectOthers<%=infecIncr%>" id="infectOthers<%=infecIncr%>"
										maxlength="300" ></textarea>								
								</td>
								<td><textarea id="infectRemarks<%=infecIncr%>" name="infectRemarks<%=infecIncr%>"
										maxlength="250" class="historyAutoComplete" onkeyup="populatePastHistorySummary();"></textarea></td>
								
							</tr>
							<% } %>
						</table>
						
						<input type="hidden" name="ancInfCount" value="<%=infecIncr -1%>" id="ancInfCount" />
						<input type="hidden" name="ancTabIndex" id="ancTabIndex" value="<%=infectionRow - 1%>" />											
						
					</div>
					</div>
					<div class="clear"></div>

</div>

<div class="clear"></div>

<h4 style="float:left;width:200px;">Past Surgical History</h4>
			<div class="floatRight" style="width: 130px;">
				<input type="button" class="buttonDel" value="" onclick="removeRowForPastMedicalHistory('surgeryTable');" />
				 <input type="button" class="buttonAdd" onclick="addPastSurgeryRow();" value="" />
			</div>
			<div class="clear"></div>
				<div class="tableForTab" style="width:1160px">
					<div id="divTemplet1">

						<table border="0" align="center" cellpadding="0" cellspacing="0"
							id="surgeryTable">
							<tr>
								<th scope="col">Sl No.</th>
								<th colspan="1" scope="col">Surgery Name</th>
								<th colspan="1" scope="col">Year</th>
								<th colspan="1" scope="col">Hospital</th>
								<th colspan="1" scope="col">Remarks</th>
							</tr>
							<%	
							int surgeryCount = 0;
							int surgeryInc = 0;
							int surgeryRow = 1;
							if(opdAntenatalCardMedHist.size()>0){
								for(OpdAntenatalCardMedicalHistory opdMH:opdAntenatalCardMedHist){
									surgeryCount = surgeryCount + 1;
									if(opdMH.getPastSurgeryName() != null && !opdMH.getPastSurgeryName().equals("")) {
							%>
									<tr>
									<td><input type="checkbox" class="radioCheck" disabled="disabled" /></td>
									<td>
										<% if(opdMH.getPastSurgeryName() != null && !opdMH.getPastSurgeryName().equals("")) { %>
											<textarea readonly="readonly" maxlength="300" style="width:215px;"><%=opdMH.getPastSurgeryName()%></textarea>
										<% } %>
									</td>
									<td>
										<% if(opdMH.getPastSurgeryYears() != null && !opdMH.getPastSurgeryYears().equals("")) { %>
											<input type="text" size=4 value="<%=opdMH.getPastSurgeryYears()%>" readonly="readonly" maxlength="4" />
										<% } %>										
									</td>
									<td>
										<% if(opdMH.getPastSurgeryHospital() != null && !opdMH.getPastSurgeryHospital().equals("")) { %>
											<input type="text" value="<%=opdMH.getPastSurgeryHospital()%>" readonly="readonly" />
										<% } %>										
									</td>
									<td>
										<% if(opdMH.getPastSurgeryRemarks() != null && !opdMH.getPastSurgeryRemarks().equals("")) { %>
											<textarea readonly="readonly" maxlength="300" style="width:215px;"><%=opdMH.getPastSurgeryRemarks()%></textarea>
										<% } %>
									</td>
								</tr>
									<%}
									surgeryRow = surgeryRow + 1;
								}
							} %>
							<%
								
							
						    int surgeryIncr = 0, lenSurgery = 1;
							int pastSurgeryRow = 1;
							int surgeryCol = 0;
							for (; surgeryIncr < lenSurgery; surgeryIncr++, pastSurgeryRow++) {%>
							<tr>
								<td><input type="checkbox" class="radioCheck" id="surgeryRadio<%=surgeryIncr%>" name="surgeryRadio<%=surgeryIncr%>" /></td>
								<td>	
									<textarea class="historyAutoComplete" placeholder="Nil Relevant"  style="display: block; float: left; width:215px;"
										name="pastSurgeryName<%=surgeryIncr%>" id="pastSurgeryName<%=surgeryIncr%>"
										maxlength="256" onkeyup="populatePastHistorySummary();"></textarea>								
								</td>
								<td><input id="pastSurgeryYear<%=surgeryIncr%>" name="pastSurgeryYear<%=surgeryIncr%>"
									 validate="Infection Years,num,no" onkeypress="javascript:return isNumber(event)" onblur="validateSurgeryYear(this.id)" type="text" maxlength="4"  size="5" /> 
									</td>
								<td><input id="pastSurgeryHostpital<%=surgeryIncr%>" name="pastSurgeryHostpital<%=surgeryIncr%>"
									 validate="Surgery Hospital,string,no" type="text" maxlength="128" onkeyup="populatePastHistorySummary();" /> 
									</td>
								<td><textarea id="pastSurgeryRemarks<%=surgeryIncr%>" name="pastSurgeryRemarks<%=surgeryIncr%>"
										maxlength="250" class="historyAutoComplete" style="width:215px;" onkeyup="populatePastHistorySummary();"></textarea></td>
								
							</tr>
							<% } %>
						</table>
						<input type="hidden" name="surgeryRowsCount" value="<%=surgeryIncr -1%>" id="surgeryRowsCount" />
						<input type="hidden" name="surgeryTabIndex" id="surgeryTabIndex" value="<%=pastSurgeryRow - 1%>" />
						<!-- Jyotish Changes Infections and surgery end -->	
					</div>
					</div>


		<div class="clear"></div>
		<!-- <a href="javascript:changeClass('title6','t6')"><h5 id='t6'>Past Surgical History</h5></a> -->
		<div class="clear"></div>
		<!-- <div class="Block" id="title6"> -->
			<div class="clear"></div>
			<%-- <label>Past Surgical History</label> 
			<!-- <label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="pastSurgicalHistoryRadio" id="pastSurgicalHistoryRadioId"   onclick="selectPastSurgicalHistory(this.value)" type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace"
			style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
			<input class="radioCheckCol2" name="pastSurgicalHistoryRadio" id="pastSurgicalHistoryRadioId"   onclick="selectPastSurgicalHistory(this.value)" checked="checked"  type="radio" value="No"> No</label>
		<div id="pastSurgHistDiv" style="display: none"> -->
			<textarea class="opdMainTextArea historyAutoComplete"  name="pastSurgHist" id="pastSurgHist" placeholder="Nil Relevant"	maxlength="250" ><%=surgicalHistory != null?surgicalHistory:"" %></textarea> --%>
			<!-- </div> -->
		<div class="clear"></div>	
		</div>
		</div>
		<div class="clear"></div>
		<label class="medium1">Personal History</label> 
			<textarea class="opdMainTextArea historyAutoComplete" name="personalHist" id="personalHist"	maxlength="250" ><%=personalHistory %></textarea>
			
			<label class="medium1">Family History</label> 			
			<textarea class="opdMainTextArea historyAutoComplete" name="familyHist" id="familyHist" maxlength="250" ><%=familyHistory %></textarea>
					
			<label>Other Immunization Detail</label> 
			<textarea type="text" class="opdMainTextArea historyAutoComplete" name="otherImmunizationDetail" id="otherImmunizationDetail" maxlength="240" value=""  validate="Other Immunization Detail,string,no"><%=otherImmunizationDetail != null?otherImmunizationDetail:"" %></textarea>
			<div class="clear"></div>
		<div class="clear"></div>

	 <%--  <h4>If referred from Private</h4>
		<div class="clear"></div>
		<div class="Block" id="title12">
		<div class="clear"></div>
		<%if(referredFromPrivate != null && referredFromPrivate.equalsIgnoreCase("yes")){ %>
		<label class="autoSpace">
				<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivateId"  checked="checked" onclick="selectReferredFrom(this.value)" type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace">
			<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivateId"  onclick="selectReferredFrom(this.value)"  type="radio" value="No"> No</label> 
			
			<%}else{ %>
			<label class="autoSpace">
				<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivate"   onclick="selectReferredFrom(this.value)" type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace">
			<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivate"  onclick="selectReferredFrom(this.value)" checked="checked" type="radio" value="No"> No</label> 
			<%} %>
		<%if(referredFromPrivateValue != null && !referredFromPrivateValue.equals("")){ %>
		<textarea class="opdMainTextArea" name="referredFromPrivateValue" id="referredFromPrivateValue"	  maxlength="240" ><%=referredFromPrivateValue != null?referredFromPrivateValue:"" %></textarea>
		
		<%}else{ %>	
		<div id="referredFromPrivateValueDiv" style="display: none">
			<label>Referred Detail</label> 
			<textarea class="opdMainTextArea" name="referredFromPrivateValue" id="referredFromPrivateValue"	 maxlength="240" ></textarea>
			<!-- <input class="opdMainTextArea" name="referredFromPrivateValue" id="referredFromPrivateValue"	 maxlength="240" />  -->
			</div>
			<%} %> 
			<div class="clear"></div>
			<div class="division"></div>
		</div> --%>  

<div class="clear"></div>
</div>
 
<div id="inAncTab2" class="inAncTabcontent">
 <div class="clear"></div>		
<div class="plusDiv"><input class="plusMinus" onclick="displayCollapsibleTab('General Examination')" id="generalExaminationId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">General Examination</h4></div>	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	
		<div  id="generalExamination" >
		<div class="indArrow"></div>
		<div class="clear"></div>
		<div class="Block" >
			<div class="clear"></div>
			<label class="auto">Weight</label>
			<%if(weight != 0){ %>
			 <input id="b16" name="weightValue" type="text" value="<%=weight%>" style="width:36px" maxlength="5" onkeypress="javascript:return isNumber(event);"  class="ageWidth" readonly="readonly" onblur="bmiCalculate();checkValidWeight(this.value)" validate="Weight,float,no" />
			 <%}else{ %>
 			 <input id="b16" name="weightValue" type="text" value="" maxlength="5" style="width:36px" class="ageWidth" onblur="bmiCalculate();checkValidWeight(this.value)"  onkeypress="javascript:return isNumber(event)" validate="Weight,float,no" />
			 <%} %>
			  <label class="smallAuto">Kg</label>
			<label class="auto">Height</label>
			<%if(height != 0){ %>
			 <input id="b17" name="heightValue" type="text" value="<%=height != 0?height:"" %>"  onkeypress="javascript:return isNumber(event)" readonly="readonly" maxlength="3" class="ageWidth" onblur="bmiCalculate();"   />
			 <%}else{ %>
 			 <input id="b17" name="heightValue" type="text" value="" onkeypress="javascript:return isNumber(event)" maxlength="3" class="ageWidth" onblur="bmiCalculate();"   />
			 <%} %>
			  <label class="smallAuto">cm</label>
			<label class="auto">BMI</label> 
			<input id="b18" name="bmiValue" type="text" value="<%=bmi != 0?bmi:"" %>" style="width:40px" readonly="readonly" validate="Bmi,string,no" />
			<input name="bmicat" id="bmicat" type="text" value="<%=bmiStatus %>" readonly="readonly" class="inputSmall"/>
			
			<label class="auto">Breast</label> <input id="b19" name="<%=BREAST %>" type="text"  value="<%=d2Breast %>" maxlength="128" validate="Breast,string,no" class="inputSmall" placeholder="NAD" />
			<label class="auto">Nipple</label> <input id="b20" name="<%=NIPPLE %>" type="text"  value="<%=d2Nipple %>" maxlength="128" validate="Nipple,string,no" class="inputSmall" placeholder="NAD" />
			<label class="auto">Thyroid</label> <input id="b20" name="<%=THYROID %>" type="text"  value="<%=d2Thyroid %>" maxlength="128" validate="Thyroid,string,no" class="inputSmall" placeholder="NAD" />
			<div class="clear"></div>
			
			<label class="auto">Pallor</label> 
			<%
			if(pallorGenExam.trim().equalsIgnoreCase("Yes")){ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="pallorGenExam" id="pallorYesId" checked="checked"  type="radio"  value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="pallorGenExam" id="pallorNoId"    type="radio" value="No"> No</label>
			<%}else{ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="pallorGenExam" id="pallorYesId"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="pallorGenExam" id="pallorNoId" checked="checked"  type="radio" value="No"> No</label>
			
			<%} %>
			
			<label  class="auto">Icterus</label> 
				<%if(icterusGenExam.equalsIgnoreCase("Yes")){ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="icterusGenExam" id="icterusYesId" checked="checked"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="icterusGenExam" id="icterusNoId"    type="radio" value="No"> No</label>
			<%}else{ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="icterusGenExam" id="icterusYesId"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="icterusGenExam" id="icterusNoId" checked="checked" type="radio" value="No"> No</label>
			<%} %>
			
			
			<label  class="auto">Cyanosis</label> 
			<%if(cyanosisGenExam.equalsIgnoreCase("Yes")){ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="cyanosisGenExam" id="cyanosisYesId"  type="radio" checked="checked"  value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="cyanosisGenExam" id="cyanosisNoId"   type="radio" value="No"> No</label>
			<%}else{ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="cyanosisGenExam" id="cyanosisYesId"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="cyanosisGenExam" id="cyanosisNoId"  checked="checked" type="radio" value="No"> No</label>
			<%} %>
			
			<!-- adding clubbing option -->

		
		<label  class="auto">Clubbing</label>
			<%if(clubbing != null && !clubbing.equals("") && clubbing.equalsIgnoreCase("Yes")){  %>
				
			<label class="auto">Yes</label>
								<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"  type="radio" value="Yes"  checked="checked">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"  type="radio" value="No"> No</label> 
			<% }else{  %>
							<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"  checked="checked" type="radio" value="No"> No</label> 
				<%} %>
<%-- 		<%}  if(clubbing == null && clubbing.equalsIgnoreCase("")){%> 
				
				<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"  type="radio"  value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="ancClubbing" id="ancClubbing"     type="radio" value="No"> No</label> 
			<%} %> --%>
			<!-- adding clubbing option end -->
			
			<label  class="auto">Lymphadenopathy</label> 
		<%if(lymphadenopathyGenExam.equalsIgnoreCase("Yes")){ %>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="lymphadenopathyGenExam" id="lymphadenopathyYesId"  type="radio" checked="checked" value="Yes" onclick="displayTextValue(this.value,'LymphadenopathyGEN')">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="lymphadenopathyGenExam" id="lymphadenopathyNoId"  type="radio" value="No" onclick="displayTextValue(this.value,'LymphadenopathyGEN')"> No</label>
			<input type="text" name="lymphadenopathyGenExamValue" id="lymphadenopathyGenExamValue" maxlength="200" value="<%=lymphadenopathyValueGenExam != null?lymphadenopathyValueGenExam:"" %>"   validate="Lymphadenopathy,string,no"/>
		
		<%}else{ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="lymphadenopathyGenExam" id="lymphadenopathyYesId" type="radio" value="Yes" onclick="displayTextValue(this.value,'LymphadenopathyGEN')">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="lymphadenopathyGenExam" id="lymphadenopathyNoId" checked="checked"  type="radio" value="No" onclick="displayTextValue(this.value,'LymphadenopathyGEN')"> No</label>
			<input type="text" name="lymphadenopathyGenExamValue" id="lymphadenopathyGenExamValue" value="" style="display: none" maxlength="200"  validate="Lymphadenopathy,string,no"/>
			<%} %>
			 	
			<!-- <div class="clear"></div> -->
			<label  class="auto">Edema</label> 
	<%if(edemaGenExam.equalsIgnoreCase("Yes")){ %>
	<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
	<input class="radioCheckCol2" name="edemaGenExam" id="edemaYesId" checked="checked" type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="edemaGenExam" id="edemaNoId" type="radio" value="No"> No</label>
	<%}else{ %>
			<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="edemaGenExam" id="edemaYesId"  type="radio" value="Yes">Yes</label>
		<label class="autoSpace" style="padding: 0px 6px 0px 1px; margin: 0px 4px 5px 0px;">
			<input class="radioCheckCol2" name="edemaGenExam" id="edemaNoId"  checked="checked" type="radio" value="No"> No</label>
			<%} %>
			
			<div class="clear"></div>
			<label class="medium">Spine</label>
			<textarea name="spine" id="spine" maxlength="250" validate="Spine,string,no" placeholder="NAD"><%=SpineGenExam !=null?SpineGenExam:"" %></textarea> 
			<label class="medium">GAIT</label>
			<textarea  name="gait" id="gait" maxlength="250" validate="Gait,string,no" placeholder="NAD"><%=gaitGenExam !=null?gaitGenExam:"" %></textarea> 
			 
			<label class="medium">CVS</label>
			<textarea  name="cvsGenExam" maxlength="250" id="cvsGenExam"  validate="cvs,string,no"><%=cvs != null?cvs:"" %></textarea> 
			
		 			
			<%-- <label class="auto">Waist</label>
			<%if(waistValue != 0){ %>
			<input id="waistValue" name="waistValue" type="text" value="<%=waistValue != 0?waistValue:"" %>" style="width:40px"  readonly="readonly" maxlength="3" validate="Waist,string,no" />
			<%}else{ %>
			<input id="waistValue" name="waistValue" type="text" value="" style="width:40px"  maxlength="3" validate="Waist,num,no" />
			<%} %> 	<label class="smallAuto">cm</label>	--%>
			
			<%-- <label class="auto">Hip</label>
			<%if(hipValue != 0){ %>
			<input id="hipValue" name="hipValue" type="text" value="<%=hipValue != 0?hipValue:"" %>" style="width:40px"  readonly="readonly" maxlength="3" validate="Hip,string,no" />
			<%}else{ %>
			<input id="hipValue" name="hipValue" type="text" value="" style="width:40px"  maxlength="3" validate="Hip,num,no" />
			<%} %> 	<label class="smallAuto">cm</label>--%>
			
			 
			<label class="medium">Others</label>
			<textarea name="otherGeneralEamination" maxlength="250" id="otherGeneralEamination"  validate="Others,string,no"><%=otherGenExam != null?otherGenExam:"" %></textarea> 
			<div class="clear"></div>
			<div class="division"></div>
		</div>

		<!-- Added by Arbind on 15-03-2017 -->
		
				<div class="clear"></div>
		<!-- <a href="javascript:changeClass('title11','t11')"><h5 id='t11'>Immunization Details</h5></a> -->
		<h4>Immunization Details</h4>
		<div class="clear"></div>
		 <div class="Block" id="title11"> 
			<div class="clear"></div>

			<label class="auto">1st Dose of TT</label>
			 <input type="text" class="inputSmall" id="date3Id" name="<%=TETANUS_ONE_DOSE_DATE %>" readonly="readonly" value="<%=firstDose %>" MAXLENGTH="30"  onblur="ValidateLmp(this.id)"/>
			 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.getElementById('date3Id'),event)" />
				 <label class="auto">2nd Dose of TT</label>
				 <input type="text" class="inputSmall" id="date4Id" value="<%=secondDose %>" name="<%=TETANUS_TWO_DOSE_DATE %>" readonly="readonly" MAXLENGTH="30" onblur="ValidateLmp(this.id);checkSecondDoseDate(this.id,'date3Id')"/>
				  <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="checkFirstDose('<%=firstDose %>');setdate('',document.getElementById('date4Id'),event);"/>
				
				<label class="auto">Others</label>
			<input type="text" name="otherTTDetails" id="otherTTDetails" value="<%=other%>" maxlength="128" validate="Others Immunization,string,no" /> 
			</div>	
			<%-- <% if(firstDose!=null && secondDose!=null) {%>
			<div class="floatLeft" style="width: 500px;">
				<table width="40%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th scope="col">TT1 Date</th>
						<th scope="col">TT2 Date</th>
					</tr>
					<tr
						onclick="changeTTDate('<%=firstDose%>','<%=secondDose%>')">
						<td><label><%=firstDose != null ? firstDose : "" %></label></td>
						<td><label><%=secondDose != null ? secondDose : "" %></label></td>
					</tr>
				</table>
			</div>
			<% } %> --%>
			

			<div class="clear"></div>
		</div>
		<div class="clear"></div>
		
		<!-- <a href="javascript:changeClass('title12','t12')"><h5 id='t12'>If referred from Private</h5></a> -->
	 	<%-- <h4>If referred from Private</h4>
		<div class="clear"></div>
		<div class="Block" id="title12">
		<div class="clear"></div>
		<%if(referredFromPrivate != null && referredFromPrivate.equalsIgnoreCase("yes")){ %>
		<label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivateId"  checked="checked" onclick="selectReferredFrom(this.value)" type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace"
			style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
			<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivateId"  onclick="selectReferredFrom(this.value)"  type="radio" value="No"> No</label> 
			
			<%}else{ %>
			<label class="autoSpace"
				style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
				<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivate"   onclick="selectReferredFrom(this.value)" type="radio" value="Yes"> Yes	</label>
		<label class="autoSpace"
			style="padding: 0px 6px 0px 1px; margin: 0px 0px 0px 0px;">
			<input class="radioCheckCol2" name="referredFromPrivate" id="referredFromPrivate"  onclick="selectReferredFrom(this.value)" checked="checked" type="radio" value="No"> No</label> 
			<%} %>
		<%if(referredFromPrivateValue != null && !referredFromPrivateValue.equals("")){ %>
					<textarea class="opdMainTextArea" name="referredFromPrivateValue" id="referredFromPrivateValue"	  maxlength="240" ><%=referredFromPrivateValue != null?referredFromPrivateValue:"" %></textarea>
		
		<%}else{ %>	
		<div id="referredFromPrivateValueDiv" style="display: none">
			<label>Referred Detail</label> 
			<textarea class="opdMainTextArea" name="referredFromPrivateValue" id="referredFromPrivateValue"	 maxlength="240" ></textarea>
			</div>
			<%} %> 
			<div class="clear"></div>
			<div class="division"></div>
		</div> --%>
		
		<div class="clear"></div>
		
		<!-- <h6>CLINICAL EXAMINATION CHART</h6> -->
		<div class="clear"></div>
		<!-- <div class="Block" id="title10"> -->
		<div class="clear"></div>
		
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('First Trimester')" name="" id="firstTrimesterDivId" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">FIRST TRIMESTER</h4></div>			
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
			<div  id="firstTrimesterDiv"  >
			<div class="indArrow"></div>
			<div class="Block" >
				<div class="clear"></div>
				<h6>CLINICAL EXAMINATION CHART</h6>
				<div id="Trimester1Summery" style="background:#fff;height:60px; width: 1158px;text-align:left;" class="tableForTab">
				<%counter=0;for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim1){ %>
				<p>
				<%if(trim.getGeneralExamination()!=null || trim.getSystemicExamin()!=null || trim.getPaTrimes()!=null || trim.getPvTrimes()!=null || trim.getWeight()!=null || trim.getTrimesDate()!=null || trim.getBpSystolics()!=null){%>
						
				<%=++counter%>
				Date:<%=HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate())%>
				Weight: <%=trim.getWeight()%>
				BP systolic:<%=trim.getBpSystolics()%>
				BP dystolic:<%=trim.getBpDiastolics()%>
				Risk:<%=trim.getObstetricRiskMeasure()%>
				<%if(trim.getGeneralExamination()!=null && !trim.getGeneralExamination().isEmpty()){ %>
				 General Examination: <%=trim.getGeneralExamination()%> 
				  <%} %>
				  <%if(trim.getSystemicExamin()!=null && !trim.getSystemicExamin().isEmpty()){ %>
				    Systemic Examination: <%=trim.getSystemicExamin()%> 
				    <%} %>
				    <%if(trim.getPaTrimes()!=null && !trim.getPaTrimes().isEmpty()){%>
				 	PA: <%=trim.getPaTrimes()%> 
				 <%} %>
				 <%if(trim.getPvTrimes()!=null && !trim.getPvTrimes().isEmpty()){%>
				 	PV: <%=trim.getPvTrimes()%> 
				 <%} %> 
				 <%if(trim.getOthers()!=null && !trim.getOthers().isEmpty()){%>
				 Advice:<%=trim.getOthers() %>
				 <%} %> 
				</p>
				<%}} %>
				</div>
				
				<div class="floatRight" style="width:130px;">
					<input type="button" class="buttonDel" value="" onclick="removeRow1('ftTable');" />
					 <input type="button" class="buttonAdd" onclick="addRow1();" value="" />
				</div>
				<div class="clear"></div>
				
					<div class="tableForTab" style="width:1158px">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="ftTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">Weight (Kg)</th>
									<th scope="col">GA</th>									
									<!-- <th scope="col">Pallor</th> 
									<th scope="col">Edema</th> -->
									<th scope="col">BP (mm Hg)</th>
									<th scope="col">General Examination</th>
									<th scope="col">Systemic Examination</th>
									<th scope="col">P/A</th>
									<th scope="col">PV</th>
									<!-- <th scope="col">P/V</th> -->
									<th scope="col">Risk</th>
									<th scope="col">Advice</th>
									
									
								</tr>
								<%
					   								
							if(opdAntenatalCardTrim1.size()>0){
								int count=0;
								
								for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim1){
									count=count+1;
									 if(trim.getTrimesterType()==1){
									 if(trim.getCvs()!=null){
										 cvs=trim.getCvs();
									 }			 
									 if(trim.getRespSystem()!=null){
										respSystem=trim.getRespSystem();
									 }
									 if(trim.getOthersFirstTrimster()!=null){
										 othersFirstTrimster=trim.getOthersFirstTrimster();
									 }
									 if(trim.getFtAdvice()!=null){
										 ftAdvise=trim.getFtAdvice();
									 }	
									 if(trim.getAntFtdae()!=null ){
										 String ftDateAr[]=trim.getAntFtdae().toString().split("-");
										 ftDate=ftDateAr[2]+"/"+ftDateAr[1]+"/"+ftDateAr[0];
									 }		 
									 }
								%>

	<%if(trim.getTrimesDate() != null && !trim.getTrimesDate().equals("")){ %>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><div style="float: left; width:85px;"><input type="text"
										value="<%=trim.getTrimesDate() != null?HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate()):""%>" class="dateTextSmall"
										readonly="readonly"> <!-- <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date" /> --></div></td>																	
										<td scope="col"><input class="opdTextBoxTSmall"
										value="<%=trim.getWeight() != null?trim.getWeight():""%>" type="text" size="10"
										maxlength="2" readonly="readonly" /></td>
										 <td scope="col"><div style="float: left; width:115px;">
									
									<input class="opdTextBoxTSmall" value="<%=trim.getGaWeeks() != null?trim.getGaWeeks():""%>" type="text" size="10"
										placeholder="Weeks" maxlength="45" readonly="readonly" style="width:38px;"/>
										 <input class="opdTextBoxTSmall" value="<%=trim.getGaDays() != null?trim.getGaDays():""%>"
										type="text" size="10" placeholder="Days" maxlength="45"
										readonly="readonly" style="width:26px;"/></div></td> 
									 <%-- <td><select class="YesNo">
											<%
												String ftPallor = "Select";
											if(trim.getPallor()!= null){
															if (trim.getPallor().equalsIgnoreCase("y")) {
																ftPallor = "Yes";
															} else if (trim.getPallor().equalsIgnoreCase("n")) {
																ftPallor = "No";
															} else if (trim.getPallor().equalsIgnoreCase("")) {
																ftPallor = "";
															}
											}
											%>
											<option value="<%=trim.getPallor()%>"><%=ftPallor%></option>
									</select></td>  --%>
									<%--  <td><select class="YesNo">
											<%
												String ftOdemia = "Select";
															if(trim.getOdemia() != null){
															if (trim.getOdemia().equalsIgnoreCase("y")) {
																ftOdemia = "Yes";
															} else if (trim.getOdemia().equalsIgnoreCase("n")) {
																ftOdemia = "No";
															} else if (trim.getOdemia().equalsIgnoreCase("")) {
																ftOdemia = "";
															}
															}
											%>
											<option value="<%=trim.getOdemia()%>"><%=ftOdemia%></option>
									</select></td> --%> 
								
									<td scope="col"><div style="float: left; width:130px;"><input value="<%=trim.getBpSystolics() != null?trim.getBpSystolics():""%>"
										placeholder="Systolic" type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall"
										readonly="readonly" style="width:41px;"/> <label class="smallAuto autoSpace">/</label>
										<input value="<%=trim.getBpDiastolics() != null?trim.getBpDiastolics():""%>"
										placeholder="Diastolic" type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall"
										readonly="readonly" style="width:43px;" /><!-- <label class="smallAuto autoSpace">mm&nbsp;Hg</label> --></div></td>
										
										<td><input readonly="readonly" style="width: 74px;" maxlength="50" value="<%=trim.getGeneralExamination() != null?trim.getGeneralExamination():"WNL"%>" /></td>
										<td><input type="text" readonly="readonly" size="10" maxlength="300" value="<%=trim.getSystemicExamin() != null?trim.getSystemicExamin():"WNL"%>" /></td>
										
										
									<td scope="col"><input type="text"  size ="10" maxlength="50" validate="PA,metachar,no" readonly="readonly" value="<%=trim.getPaTrimes() != null?trim.getPaTrimes():"WNL"%>" /></td>
									<td scope="col">
									<input type="text" size ="10" maxlength="50" validate="PV,metachar,no" readonly="readonly" value="<%=trim.getPvTrimes() != null?trim.getPvTrimes():"Not Done"%>" />
									</td>										
									<%-- <td scope="col"><input type="text" class="opdTextBoxTSmall" readonly="readonly" maxlength="3" value="<%=trim.getFhs() != null?trim.getFhs():""%>" /></td> --%>
									
									
									<%-- <td><input type="text" readonly="readonly" maxlength="300" value="<%=trim.getObstetricRiskMeasure() != null?trim.getObstetricRiskMeasure():""%>" /></td> --%>
									<td>
									<select class="smallnew">
									<option value="Low" <%=trim.getObstetricRiskMeasure().equals("Low")?"selected='selected'":"" %> >Low</option>
									<option value="High" <%=trim.getObstetricRiskMeasure().equals("High")?"selected='selected'":"" %>>High</option>
									</select>																
									
									</td>
									<td scope="col"><input type="text" size=22 readonly="readonly" maxlength="50" value="<%=trim.getOthers() != null?trim.getOthers():""%>" /></td>
									
									
									
								</tr>
								<%	}}
								
							}
								incr = 0;len=1;
								int inxRow = 1;
								int inxCol = 0;
							for(;incr< len;incr++,inxRow++){
					%>
								<tr>
									<td scope="col"><input type="checkbox" class="radioCheck"
										id="itemRadio<%=incr%>" name="itemRadio<%=incr%>"
										onchange="checkPrescriptionCheck(<%=incr%>)" /></td>
									<td scope="col"><div style="float: left; width:115px;"><input type="text" id="ftdate<%=incr%>" 
										name="ftdate<%=incr%>"  
										class="dateTextSmall validateDate" readonly="readonly" onblur="checkTrimDate('ftdate','<%=incr%>','1');ValidateLMPandTrim1Date();openPopupForExamination(<%=incr%>,'1');" /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"  
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.getElementById('ftdate<%=incr%>'),event);" /></div></td>
																  
										
										<td scope="col"><input class="opdTextBoxTSmall" validate="Weight,float,no"
										 type="text"
										name="ftWeight<%=incr%>" id="ftWeight<%=incr%>" size="10" maxlength="5" onblur="openPopupForExamination(<%=incr%>,'1')"
onkeypress="javascript:return isNumber(event)"/></td>
										<td scope="col"><div style="float: left; width:85px;"><input class="opdTextBoxTSmall"
										 type="text" readonly="readonly" 
										name="ftGA1<%=incr%>" id="ftGA1<%=incr%>" size="10"  validate="ftGA1<%=incr%>,num,no"
										placeholder="Weeks" maxlength="2" style="width:38px;" onblur="openPopupForExamination(<%=incr%>,'1')"/> <input
										class="opdTextBoxTSmall" validate="ftGA2<%=incr%>,num,no"
										type="text" name="ftGA2<%=incr%>" id="ftGA2<%=incr%>" readonly="readonly" 
										size="10" placeholder="Days" maxlength="2" style="width:26px;"onblur="openPopupForExamination(<%=incr%>,'1')"/></div></td>
									<%-- <td scope="col"><select id="ftPallor<%=incr%>"
										name="ftPallor<%=incr%>"  class="YesNo"
										>
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td>
									<td scope="col"><select id="ftOdemia<%=incr%>"
										name="ftOdemia<%=incr%>" class="YesNo"
										>
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td> --%>				
										
									<td scope="col"><div style="float: left; width:130px;"><input name="ftsystolic<%=incr%>" validate="ftsystolic<%=incr%>,num,no"
										id="ftsystolic<%=incr%>" placeholder="Systolic"
										 type="text"
										maxlength="3" class="allownumericwithoutdecimal textSmall" style="width:41px;" onblur="checkSystolicDiastolic('ftsystolic<%=incr%>','ftdiastolic<%=incr%>')" onkeypress="javascript:return isNumber(event);openPopupForExamination(<%=incr%>,'1')"/>
										<label class="smallAuto autoSpace">/</label> <input
										name="ftdiastolic<%=incr%>" id="ftdiastolic<%=incr%>" validate="ftdiastolic<%=incr%>,num,no" placeholder="Diastolic"
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" style="width:43px;" onblur="checkSystolicDiastolic('ftsystolic<%=incr%>','ftdiastolic<%=incr%>');openPopupForExamination(<%=incr%>,'1')" onkeypress="javascript:return isNumber(event)"/><!-- <label
										class="smallAuto autoSpace">mm&nbsp;Hg</label> --></div></td>
										
										<td scope="col">
										<textarea class="autoWidthFocus" placeholder="WNL" size="10" name="ftGeneralExaminationTrim<%=incr%>" id="ftGeneralExaminationTrim<%=incr%>" maxlength="250" onblur="openPopupForExamination(<%=incr%>,'1')"></textarea>
										<%-- <select id="ftGeneralExaminationTrim<%=incr%>"
										name="ftGeneralExaminationTrim<%=incr%>" 
										>
											<option value="">select</option>
											<option value="Pallor">Pallor</option>
											<option value="Icterus">Icterus</option>
											<option value="Cyanosis">Cyanosis</option>
											<option value="Lymphadenopathy">Lymphadenopathy</option>
											<option value="Edema">Edema</option>
									</select> --%>
									</td>
										
					<td scope="col"><textarea class="autoWidthFocus" placeholder="WNL" size="10" name="ftSystemicExam<%=incr%>" onblur="openPopupForExamination(<%=incr%>,'1')" id="ftSystemicExam<%=incr%>" maxlength="250" ></textarea></td>
										
										
										
				 <td scope="col"><textarea class="autoWidthFocus" placeholder="WNL"  name="ftPA<%=incr%>" id="ftPA<%=incr%>" onblur="openPopupForExamination(<%=incr%>,'1')" maxlength="50" size ="10" ></textarea></td>
					<td scope="col">
					<textarea class="autoWidthFocus" size ="10"  name="ftPV<%=incr%>" id="ftPV<%=incr%>" onblur="openPopupForExamination(<%=incr%>,'1')" maxlength="50" placeholder="Not Done"></textarea>
					
					
					<%-- <textarea class="opdTextBoxTSmall"	tabindex="<%=inxRow%><%=inxCol + 8%>" name="ftPV<%=incr%>"
											id="ftPV<%=incr%>" maxlength="300"></textarea></td>  --%>
											
				<%-- <td scope="col"><input class="opdTextBoxTSmall" validate="ftFhs<%=incr%>,num,no" type="text"
										name="ftFhs<%=incr%>" id="ftFhs<%=incr%>" size="10" maxlength="3" style="width:28px" /></td> --%>
									
									
			<%-- <td scope="col"><input type="text"  name="ftObsRi<%=incr%>" id="ftObsRi<%=incr%>" maxlength="200" /></td> --%>
			<td scope="col">			
			<select name="ftObsRi<%=incr%>" id="ftObsRi<%=incr%>" class="smallnew" onblur="openPopupForExamination(<%=incr%>,'1')">
				<%if(risk!=null && !risk.equalsIgnoreCase("high")) {%>
											<option value="Low" selected="selected">Low</option><%}%>
				<option value="High">High</option>
				</select>
		  </td>
					
			<td scope="col"><textarea  validate="ftothersTrim<%=incr%>,string,no" name="ftothersTrim<%=incr%>" id="ftothersTrim<%=incr%>"  maxlength="50" onblur="openPopupForExamination(<%=incr%>,'1')"><%=lastPrescription!=null?lastPrescription:""%></textarea></td>
									
									
								</tr>
								<% } %>
							</table>
							<input type="hidden" name="hdb" value="<%=incr-1 %>" id="hdb" />
							<input type="hidden" name="hdbTabIndex" id="hdbTabIndex"
								value="<%=inxRow-1%>" />
						</div>
					</div>
					
					<div class="clear"></div>
						<%-- <label class="auto">CVS</label>
						<textarea class="opdMainTextArea" name="ftCVS" id="ftCVS"  maxlength="240"><%=cvs %></textarea> --%>
						
						<%-- <label  class="auto">RESP SYSTEM</label>
						<textarea class="opdMainTextArea" name="ftRespSys"  id="ftRespSys" maxlength="240"><%=respSystem %></textarea> --%>
							
						<%-- <label  class="auto">Others</label>
						<textarea class="opdMainTextArea" name="ftOthersFirstTrimster"  id="ftOthersFirstTrimster" maxlength="240"><%=othersFirstTrimster != null?othersFirstTrimster:"" %></textarea>
						<div class="clear"></div>
						<div class="paddingTop5"></div>
						<div class="clear"></div> --%>
						<%-- <label>Date	</label>
						
						<input name="ftSubDate" type="text" id="ftSubDate" value="<%=ftDate %>"  class="dateTextSmall" readonly="readonly" />
						<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"  validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('ftSubDate'),event);" /> --%>
							
						<%-- <label style="width:62px;">ADVISE</label>
						<textarea class="opdMainTextArea" name="ftAdvise" id="ftAdvise"  maxlength="240"><%=ftAdvise %></textarea>
											
						<div class="clear"></div> --%>
					</div>
					</div>
					<div class="clear"></div>
					
		<!-- ----------------------------------Start Lab Result First Trimester----------------------------------------- -->
 		
 		<%-- <h4 style="cursor:pointer;" onclick="popwindowResultEntryForAntenatal('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>');">External Lab Report Entry</h4> --%>
<div class="clear"></div>
<h4 style="cursor:pointer; float:left;" onclick="popwindowResultEntryForDermotologyAnc('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>@@@<%=templateName%>');">External Lab Report Entry</h4>
<div class="clear"></div>
	
 		 
 		  <div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Lab Result First Trimester')" id="labResultFirstTrimesterId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Lab Result First Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="labResultFirstTrimester"  >
<div class="indArrow"></div>
				<!-- changes for external lab report -->
				
				<div class="Block">
			<div class="clear"></div>			
<%if(commonLabTestReports!=null && sortedfirstTrimTestdate!=null && commonLabTestReportsMap.size()>0){ 
String testName = null;
%>
<label>Lab test report</label>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet2">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="OutSidelabResult">
							<tr>
								<th>Test Name</th>
							<%	int labFirstTrimIndex=0;
							for(; labFirstTrimIndex < firstTrimTestDateSize; labFirstTrimIndex++ ){ %>
		     				<th><%=HMSUtil.convertStringDateFormat(sortedfirstTrimTestdate.get(labFirstTrimIndex)) %> </th> 
		     				<%} %>
		     			</tr>	
							
							<%
								Iterator records = commonLabTestReportsMap.entrySet().iterator();
							    while (records.hasNext()) {
							    Map.Entry entry = (Map.Entry) records.next();
							    String key = (String)entry.getKey();	    
							%>			
							
		<tr>
		    <td style="width: 175px;"><input type="text" name="testN" value="<%=key%>"   readonly="readonly"  /></td>
		  
		   <%	
							    List <CommonLabTestReport> testDispList = new ArrayList<CommonLabTestReport>();
							    testDispList  = (ArrayList<CommonLabTestReport>)entry.getValue();
		                      for(int dateIndex=0; dateIndex < sortedfirstTrimTestdate.size(); dateIndex++ ){
		                    	  List<CommonLabTestReport> localList = new ArrayList<CommonLabTestReport>();
		                    	  for(CommonLabTestReport reportList : testDispList){		
									
									if(sortedfirstTrimTestdate !=null && sortedfirstTrimTestdate.get(dateIndex).equalsIgnoreCase(reportList.getResultDate())){
									localList.add(reportList);
								  }
		                    	  }
		                      
		                    	//single test start
									if (localList.size() == 1) {%>
									<%if(localList.get(0).getTestType().equalsIgnoreCase("Internal Test")) {%>
									<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getDgId()%>','<%=localList.get(0).getInvestigationId()%>');">Lab Results</a></td>
									<%} %>
										<%if(localList.get(0).getTestType().equalsIgnoreCase("External Test")){
										if(localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestResult().equals("")) {%>
										<td> <a href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getInvestigationId()%>','<%=localList.get(0).getResultDate()%>','<%=hinId%>','<%=localList.get(0).getResultTime() %>');">Lab Results</a> </td>
										<%}else if (localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestStatus().equalsIgnoreCase("Abnormal")){ %>
										<td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>" %> </td>
										<%} else {%>							
								 <td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "") %> </td>
									<% }	
										}}
									//single test end
									if (localList.size() ==0) {%>
										<td>-</td>	
			                    	
			                    	    
			                      <%}%> 
								<%if (localList.size() > 1) {%>
								<td>
									
								  <% String res="";String  hLink="";
								  for(CommonLabTestReport finalReport : localList){
									  String testResult="";
									  if(finalReport.getTestType().equalsIgnoreCase("External Test")){
									  if(finalReport.getTestResult()==null || finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00"))
										    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
												   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results - "+finalReport.getResultTime()+"</a>");
										      else
											    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
											   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results</a>");  
										    
										res= res.concat("\n").concat(hLink);	 
									  }	
									  if(finalReport.getTestResult()!=null && !finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00")){
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>"+"-"+finalReport.getResultTime();
											  else
												  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"-"+finalReport.getResultTime();  
										  }else{
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "");
											  else
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>";  
										  }
										  res = res.concat(testResult).concat(", ");
									  }
									  } // external test end here
									    // internal test starts here
									  if(finalReport.getTestType().equalsIgnoreCase("Internal Test")){
										  if(finalReport.getTestResult()==null || finalReport.getTestResult().equals("")){
											  
											    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getDgId()).concat("'")
													   .concat(",").concat("'").concat(""+finalReport.getInvestigationId()).concat("'").concat(");").concat("\"").concat(">Lab Results - "+finalReport.getResultTime()+"</a>");
											    
											res= res.concat("\n").concat(hLink);	 
										  }	
										  } // internal test end here
									} // end of for loop %>
								<%=res %>	
								</td>		
								<%}}} %>
									</tr>
					</table>
					</div>
				</div>
				<%}else{ %>
						<span>No Test Record found</span>
						<%} %> 
				</div>
				<!-- changes for external lab report end -->
				</div>  
				
 		 
<!-- ----------------------------------End Of Lab Result First Trimester----------------------------------------- -->					
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('usg First')" id="usgFirstDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">USG Report First Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="usgFirstDiv"  >
<div class="indArrow"></div>
					<div class="Block">
					<div class="clear"></div>
					<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							   <%int l= 1;int v=1;int n=1; %>
							  <tr><td><b>USG</b>(<10 Weeks)</td>
							  <%if(usgFlag !=null && !usgFlag.equals("")){ %>
							   <td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstSingle" name="usgFirstTrimTwo" type="radio"  <%=usgFlag.equalsIgnoreCase("single")?"checked":""%> onclick="setUsgFlag();firstTirmUsgWeeks10Revisit();" >Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTwins" name="usgFirstTrimTwo" type="radio"  <%=usgFlag.equalsIgnoreCase("Twins")?"checked":""%> onclick="setUsgFlag();firstTirmUsgWeeks10Revisit();" >Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTriplets" name="usgFirstTrimTwo" type="radio"  <%=usgFlag.equalsIgnoreCase("Triplets")?"checked":""%> onclick="setUsgFlag();firstTirmUsgWeeks10Revisit();" >Triplets</div>
                                       <input type="hidden" name="usgFlagRevisit" id="usgFlagRevisit" value="<%=revisitFlag %>" />
                                       <input type="hidden" name="usgFlagRevisitThirdV" id="usgFlagRevisitThirdV" value="<%=usgFirstTrimusgParameterValue3List.size() %>" />
                                       <input type="hidden" name="usgFlag" id="usgFlag" value="<%=usgFlag %>" />
     
     </td>
							  <%}else{ %>
							  
<td colspan="3">				    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstSingle" name="usgFirstTrimTwo" type="radio" checked="checked"   onclick="setUsgFlag();firstTirmUsgWeeks10();">Single</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTwins" name="usgFirstTrimTwo" type="radio"  onclick="setUsgFlag();firstTirmUsgWeeks10();">Twins</div>
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTriplets" name="usgFirstTrimTwo" type="radio"  onclick="setUsgFlag();firstTirmUsgWeeks10();">Triplets</div>
  <input type="hidden" name="usgFlag" id="usgFlag" value="" />
     
     </td>
     <%} %>
						</tr>
						
					 <tr>
						<td>USG Parameters</td>
						<!-- <td>Date</td> -->
					
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ 
								for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimDateListFirstVisit ){ %>
								 <td><input type="text" value="<%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%break;}} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id)"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimFirstV<%=l%>'),event);setFirstTrimFirstVisitFlag();" /></td>							
							 <input type="hidden" name="firstTrimFirstVisitFlag" id="firstTrimFirstVisitFlag" value="" />
							<% l++;} %>
							
						<%if(usgFirstTrimusgParameterValue2List.size()>0){ 
							for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimDateListSecondVisit ){ %>
									<td><input type="text" value="<%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  tabindex="2"/>
							</td>
							<%break;}} else { %>
							 <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" class="small" readonly="readonly" tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id)"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimSecondV<%=v%>'),event);setFirstTrimSecondVisitFlag();"></td>
							 <input type="hidden" name="firstTrimSecondVisitFlag" id="firstTrimSecondVisitFlag" value="" />
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){ 
							for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimDateListThirdVisit ){ %>
								<td><input type="text" value="<%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}} else {%>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n%>" value="" id="usgFirstTrimThirdV<%=n%>"  class="small" readonly="readonly"  tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id)"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimThirdV<%=n%>'),event);setFirstTrimThirdVisitFlag();">
							<input type="hidden" name="firstTrimThirdVisitFlag" id="firstTrimThirdVisitFlag" value="" />
							</td>
							<% n++; } %> 
							
							</tr> 
					
						<!-- ------- -->
						 <tr>
						<td>Mean SAC Diameter</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							  <td>
								<% for(OpdAntenatalUsg meanSacFirstVisitList:usgFirstTrimMeanSacFirstVisitList ){ %>
								<input type="text" value="<%=meanSacFirstVisitList.getUsgParameterValue1() != null?meanSacFirstVisitList.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimFirstV<%=l%>" name="usgFirstTrimFirstV<%=l%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivMeanSacDiaTwins">
						 	   <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivMeanSacDiaTwins">
						 	   <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivMeanSacDiaTriplets">
							 <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128" tabindex="1"/> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivMeanSacDiaTriplets">
							 <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
								 <td>
								<%for(OpdAntenatalUsg meanSacSecondVisitList:usgFirstTrimMeanSacSecondVisitList ){ %> 
								<input type="text" value="<%=meanSacSecondVisitList.getUsgParameterValue2() != null?meanSacSecondVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivMeanSacDiaTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
							  
							    <div class="" style="display:none" id="dataDivMeanSacDiaTripletsColTwo">
							   <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} %></td>
							
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivMeanSacDiaTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivMeanSacDiaTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>  
						 	  <%} %>
						 	    <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivMeanSacDiaTripletsColTwo">
							    <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128" tabindex="2"  /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivMeanSacDiaTripletsColTwo">
							   <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg meanSacThirdVisitList:usgFirstTrimMeanSacThirdVisitList ){ %> 
								<input type="text" value="<%=meanSacThirdVisitList.getUsgParameterValue3() != null?meanSacThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivMeanSacDiaTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							  <div class="" style="display:none" id="dataDivMeanSacDiaTripletsColThree">
							  <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							<%} %></td>
							
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>"maxlength="128" tabindex="3" />
							   <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivMeanSacDiaTwinsColThree">
							        <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivMeanSacDiaTwinsColThree">
							       <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivMeanSacDiaTripletsColThree">
							  <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivMeanSacDiaTripletsColThree">
							  <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} n++; %>
							
							</tr>
						<!-- ------ -->
						
						<tr>
						<td>Yolk SAC</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg yolkSacFirstVisit:usgFirstTrimYolkSacFirstVisit ){ %>	
								<input type="text" value="<%=yolkSacFirstVisit.getUsgParameterValue1() != null?yolkSacFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
							     <div class="clear"></div>
							<%} %>	
								</td>							
							<%} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" maxlength="128" tabindex="1"/>
								  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivusgYolkSacTwins">
							       <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivusgYolkSacTwins">
							        <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128"  tabindex="1" /></div>
								   
								 <%} 
								
								 if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivusgYolkSacTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128"  tabindex="1" /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivusgYolkSacTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128" tabindex="1"  /></div>
								<%} %> 
								 
								 
							    </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
							 <td>
							<% for(OpdAntenatalUsg yolkSacSecondVisit:usgFirstTrimYolkSacSecondVisit ){ %>		
								<input type="text" value="<%=yolkSacSecondVisit.getUsgParameterValue2() != null?yolkSacSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
							  <div class="" style="display:none" id="dataDivusgYolkSacTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
							  <div class="" style="display:none" id="dataDivusgYolkSacTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="128" tabindex="2" />
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivusgYolkSacTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivusgYolkSacTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
						   <%} %> 
						 	  
						 	  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivusgYolkSacTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivusgYolkSacTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg yolkSacThirdVisit : usgFirstTrimYolkSacThirdVisit ){ %>
								<input type="text" value="<%=yolkSacThirdVisit.getUsgParameterValue3() != null?yolkSacThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivusgYolkSacTwinsColThree">
							    <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							    <div class="" style="display:none" id="dataDivusgYolkSacTripletsColThree">
							    <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>" maxlength="128" tabindex="3" />
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivusgYolkSacTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivusgYolkSacTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	  <%} %> 
						 	      <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivusgYolkSacTripletsColThree">
							      <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivusgYolkSacTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /> </div>
						 	       <%} %> 
							
							  </td>
							<% n++; } %>
							
							</tr>
							<!-- ----- -->
							<tr>
						<td>Fetal Pole</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							 <td>
							<% for(OpdAntenatalUsg fetalPoleFirstVisit:usgFirstTrimFetalPoleFirstVisit ){ %>		
								<input type="text" value="<%=fetalPoleFirstVisit.getUsgParameterValue1() !=null?fetalPoleFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" maxlength="128" tabindex="1" />
								   <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivFetalPoleTwins">
							       <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128" tabindex="1" /></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivFetalPoleTwins">
							        <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="128" tabindex="1" /></div>
								   
								  <%} %> 
								
							 <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivFetalPoleTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128" tabindex="1"  /></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivFetalPoleTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="128"  tabindex="1" /></div>
							 <%} %> 
								 
								 
							    </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg fetalPoleSecondVisit:usgFirstTrimFetalPoleSecondVisit ){ %>	
								<input type="text" value="<%=fetalPoleSecondVisit.getUsgParameterValue2() !=null?fetalPoleSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
							  <div class="" style="display:none" id="dataDivFetalPoleTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
							  <div class="" style="display:none" id="dataDivFetalPoleTripletsColTwo">
							  <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128" tabindex="2"  /> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivFetalPoleTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2"  /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivFetalPoleTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="128" tabindex="2" /></div>
						  <%} %> 
						 	  
						 	  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivFetalPoleTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivFetalPoleTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="128" tabindex="2"  /> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg fetalPoleThirdVisit:usgFirstTrimFetalPoleThirdVisit ){ %>	 
								<input type="text" value="<%=fetalPoleThirdVisit.getUsgParameterValue3() !=null?fetalPoleThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivFetalPoleTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
							  <div class="" style="display:none" id="dataDivFetalPoleTripletsColThree">
							   <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>" maxlength="128" tabindex="3" />
						 	   <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivFetalPoleTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivFetalPoleTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	   <%} %> 
						 	  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivFetalPoleTripletsColThree">
							      <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivFetalPoleTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="128" tabindex="3" /> </div>
						 	   <%} %> 
							
							  </td>
							<% n++; } %>							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>Fetal Heart</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							 <td>
							<% for(OpdAntenatalUsg fetalHeartFirstVisit:usgFirstTrimFetalHeartFirstVisit ){ %>	
								<input type="text" value="<%=fetalHeartFirstVisit.getUsgParameterValue1() !=null?fetalHeartFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/>
								   <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivFetalHeartTwins">
							       <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivFetalHeartTwins">
							        <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								   
								  <%} %> 
								
								 <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivFetalHeartTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivFetalHeartTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
							 <%} %> 
								 
								 
							    </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
							 <td>
							<% for(OpdAntenatalUsg fetalHeartSecondVisit:usgFirstTrimFetalHeartSecondVisit ){ %>	
								<input type="text" value="<%=fetalHeartSecondVisit.getUsgParameterValue2() !=null?fetalHeartSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
							   <div class="" style="display:none" id="dataDivFetalHeartTwinsColTwo">
							   <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2"  onkeypress="javascript:return isNumber(event);"/></div>
							    <div class="" style="display:none" id="dataDivFetalHeartTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);" /> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/>
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivFetalHeartTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivFetalHeartTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);" /></div>
						    <%} %> 
						 	  
						  <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivFetalHeartTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivFetalHeartTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
						 	  <%} %> 
						 	    
							  
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<% for(OpdAntenatalUsg fetalHeartThirdVisit:usgFirstTrimFetalHeartThirdVisit ){ %>	
								<input type="text" value="<%=fetalHeartThirdVisit.getUsgParameterValue3() !=null?fetalHeartThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivFetalHeartTwinsColThree">
							     <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3"  tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
							     <div class="" style="display:none" id="dataDivFetalHeartTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/>
						 	  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivFetalHeartTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3"  tabindex="3" onkeypress="javascript:return isNumber(event);" /></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivFetalHeartTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3"  tabindex="3" onkeypress="javascript:return isNumber(event);" /></div>
						 	   <%} %>
						 	       <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivFetalHeartTripletsColThree">
							      <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);" /></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivFetalHeartTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);" /> </div>
						 	       <%} %> 
							
							  </td>
							<% n++; } %>
							
							</tr>						
						<!-- ------ -->
						<tr>
						<td>Crown Rump Length</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							 <td>
							<%for(OpdAntenatalUsg crownRumpFirstVisit:usgFirstTrimCrownRumpFirstVisit ){ %>	
								<input type="text" value="<%=crownRumpFirstVisit.getUsgParameterValue1() !=null?crownRumpFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<%} %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/>
								  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivCrownRumpLengthTwins">
							       <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivCrownRumpLengthTwins">
							        <input  type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								   
								    <%} %> 
								
								<% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivCrownRumpLengthTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="3"  tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivCrownRumpLengthTriplets">
							     <input  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="3"  tabindex="1" onkeypress="javascript:return isNumber(event);"/></div>
								 <%} %> 
								 
								 
							    </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg crownRumpSecondVisit : usgFirstTrimCrownRumpSecondVisit ){ %>	
								<input type="text" value="<%=crownRumpSecondVisit.getUsgParameterValue2() !=null?crownRumpSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivCrownRumpLengthTwinsColTwo">
							    <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2"  onkeypress="javascript:return isNumber(event);"/></div>
							    <div class="" style="display:none" id="dataDivCrownRumpLengthTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/>
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivCrownRumpLengthTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);" /></div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivCrownRumpLengthTwinsColTwo">
							  <input  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);" /></div>
						 	  <%} %> 
						 	  
						   <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivCrownRumpLengthTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);" /> </div>
						 	  <%}else{ %> 
						 	    <div class="" style="display:none" id="dataDivCrownRumpLengthTripletsColTwo">
							     <input  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/> </div>
						 	  <%} %> 
						 	     
						 	    
							  
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg crownRumpThirdVisit : usgFirstTrimCrownRumpThirdVisit ){%>	
								<input type="text" value="<%=crownRumpThirdVisit.getUsgParameterValue3() !=null?crownRumpThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<div class="" style="display:none" id="dataDivCrownRumpLengthTwinsColThree">
							   <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
							   <div class="" style="display:none" id="dataDivCrownRumpLengthTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);" />
						 	   <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivCrownRumpLengthTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
						 	   <%}else{ %>
						 	   <div class="" style="display:none" id="dataDivCrownRumpLengthTwinsColThree">
							  <input  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
						 	   <%} %>
						 	      <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivCrownRumpLengthTripletsColThree">
							      <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivCrownRumpLengthTripletsColThree">
							     <input  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/> </div>
						 	      <%} %> 
							
							  </td>
							<% n++; } %>
							</tr>
							
							<!-- ----- -->
							
							<tr>
						<td>Scan EDC</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							 <td>
							<%for(OpdAntenatalUsg scanEDCFirstVisit:usgFirstTrimScanEDCFirstVisit ){ %>	
								<input type="text" value="<%=scanEDCFirstVisit.getUsgParameterValue1() !=null?scanEDCFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								 <div class="clear"></div>
								<% break; } %> 
								</td>
							
							<%} else { %>
							<td><input type="text" name="usgFirstTrimFirstV<%=l%>" value="" id="usgFirstTrimFirstV<%=l%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstTrimFirstV1');"/>
								<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimFirstV<%=l%>'),event);" /></td>							
								<% l++;} %>
								
								<%if(usgFirstTrimusgParameterValue2List.size()>0){ %>
								 <td>
									<%for(OpdAntenatalUsg scanEDCSecondVisit : usgFirstTrimScanEDCSecondVisit ){ %>
								<input type="text" value="<%=scanEDCSecondVisit.getUsgParameterValue2() != null?scanEDCSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
								</td>
								<%break;}} else { %>
								<td><input type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" class="small" readonly="readonly" tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstTrimSecondV1');"/>
								<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimSecondV<%=v%>'),event);"></td>
								<% v++;} %>
								
								<%if(usgFirstTrimusgParameterValue3List.size()>0){ %>
								 <td>
									<%for(OpdAntenatalUsg scanEDCThirdVisit : usgFirstTrimScanEDCThirdVisit ){ %>
								<input type="text" value="<%=scanEDCThirdVisit.getUsgParameterValue3() != null?scanEDCThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
								</td>
								<%break;}} else {%>
								<td><input type="text" name="usgFirstTrimThirdV<%=n%>" value="" id="usgFirstTrimThirdV<%=n%>"  class="small" readonly="readonly" tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstTrimThirdV1');"/>
								<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimThirdV<%=n%>'),event);"></td>
								<% n++; } %> 
							</tr>
						
						<!-- ------- -->
						
						<tr>
						<td>Remarks</td>
						
							<% if(usgFirstTrimusgParameterValue1List.size()>0){ %>
							 <td>
							<%for(OpdAntenatalUsg remarksFirstVisit : usgFirstTrimRemarksFirstVisit ){ %>
								<textarea type="text" readonly="readonly" ><%=remarksFirstVisit.getUsgParameterValue1() !=null?remarksFirstVisit.getUsgParameterValue1():"" %></textarea>
								 <div class="clear"></div>
								<%} %> 
								</td>
							
							<%} else { %>
							<td><textarea type="text" name="usgFirstTrimFirstV<%=l%>" id="usgFirstTrimFirstV<%=l%>" maxlength="256" value="" tabindex="1"></textarea>
							  <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivRemarksTwins">
							       <textarea type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								   
								   <%}else{ %> 
								    <div class="" style="display:none" id="dataDivRemarksTwins">
							        <textarea type="text" id="usgFirstTrimTwinsFirstV<%=l%>" name="usgFirstTrimTwinsFirstV<%=l%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								   
								   <%} %> 
								
								 <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
								 <div class="" style="display:block" id="dataDivRemarksTriplets">
							     <textarea  type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="256" tabindex="1" ></textarea></div>
								<%}else{ %> 
								 <div class="" style="display:none" id="dataDivRemarksTriplets">
							     <textarea type="text" id="usgFirstTrimTripletsFirstV<%=l%>" name="usgFirstTrimTripletsFirstV<%=l%>" value="" maxlength="256" tabindex="1"></textarea></div>
								 <%} %> 
								 
								 
							    </td>							
							<% l++;} %>
							
							<%if(usgFirstTrimusgParameterValue2List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg remarksSecondVisit : usgFirstTrimRemarksSecondVisit ){ %>	
								<textarea type="text"  readonly="readonly" ><%=remarksSecondVisit.getUsgParameterValue2() !=null?remarksSecondVisit.getUsgParameterValue2():"" %></textarea>
								 <div class="clear"></div>
							  <div class="" style="display:none" id="dataDivRemarksTwinsColTwo">
							  <textarea  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea></div>
							  <div class="" style="display:none" id="dataDivRemarksTripletsColTwo">
							  <textarea  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgFirstTrimSecondV<%=v%>" value="" id="usgFirstTrimSecondV<%=v%>" maxlength="256" tabindex="2" ></textarea>
						 	 <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	    <div class="" style="display:block" id="dataDivRemarksTwinsColTwo">
							  <textarea  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivRemarksTwinsColTwo">
							  <textarea  type="text" id="usgFirstTrimTwinsSecondV<%=v%>" name="usgFirstTrimTwinsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea></div>
						    <%} %> 
						 	  
						 	   <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	    <div class="" style="display:block" id="dataDivRemarksTripletsColTwo">
							     <textarea  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea></div>
						 	  <%}else{ %>
						 	    <div class="" style="display:none" id="dataDivRemarksTripletsColTwo">
							     <textarea  type="text" id="usgFirstTrimTripletsSecondV<%=v%>" name="usgFirstTrimTripletsSecondV<%=v%>" value="" maxlength="256" tabindex="2" ></textarea> </div>
						 	   <%} %> 
						 	     
						 	    
							  
							  </td>
							<% v++;} %>
							
							<%if(usgFirstTrimusgParameterValue3List.size()>0){%>
							 <td>
							<%for(OpdAntenatalUsg remarksThirdVisit : usgFirstTrimRemarksThirdVisit ){ %>	
								<textarea type="text" readonly="readonly"  ><%=remarksThirdVisit.getUsgParameterValue3() !=null?remarksThirdVisit.getUsgParameterValue3():"" %></textarea>
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivRemarksTwinsColThree">
							    <textarea  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="256" tabindex="3"></textarea></div>
							    <div class="" style="display:none" id="dataDivRemarksTripletsColThree">
							    <textarea  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="256" tabindex="3" ></textarea> </div>
							<%} %>
							</td>
							<%} else { %>
							   <td><textarea type="text" name="usgFirstTrimThirdV<%=n %>" value="" id="usgFirstTrimThirdV<%=n %>" maxlength="256" tabindex="3" > </textarea>
						 	    <% if(usgFlag.equalsIgnoreCase("Twins") || usgFlag.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivRemarksTwinsColThree">
							  <textarea  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivRemarksTwinsColThree">
							  <textarea  type="text" id="usgFirstTrimTwinsThirdV<%=n%>" name="usgFirstTrimTwinsThirdV<%=n%>" value="" maxlength="256" tabindex="3"></textarea></div>
						 	   <%} %>
						 	       <% if(usgFlag.equalsIgnoreCase("Triplets")) { %>  
						 	       <div class="" style="display:block" id="dataDivRemarksTripletsColThree">
							      <textarea  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="256" tabindex="3" ></textarea></div>
						 	      <%}else{ %> 
						 	       <div class="" style="display:none" id="dataDivRemarksTripletsColThree">
							     <textarea  type="text" id="usgFirstTrimTripletsThirdV<%=n%>" name="usgFirstTrimTripletsThirdV<%=n%>" value="" maxlength="256" tabindex="3" ></textarea> </div>
						 	      <%} %>
							
							  </td>
							<% n++; } %>
							</tr>
							   
						</table> 
			<div class="clear"></div>
			<div class="paddingTop5"></div>
		
		</div> 
		
		<div class="indArrow"></div>
		            <%if((gestationalAgeWeeks!=null && !gestationalAgeWeeks.equals("")  && Integer.parseInt(gestationalAgeWeeks) >= 10 ) 
		            		|| (usgFlagSecondGrid !=null && !usgFlagSecondGrid.equals("") )){ %>
		             <div class="Block" style="display:block" id="14weeksDiv">
		            <%} else {%>
					<div class="Block" style="display:none" id="14weeksDiv">
					<%} %>					
					<div class="clear"></div>
					<table border="0" align="center" cellpadding="0" cellspacing="0"  style="border-top: 1px solid #C0C0C0; width:800px; float:left; margin-left:5px;">
							   <%int grid2FirstVisitIndex=1, grid2SecondVisitIndex=1,grid2ThirdVisitIndex=1; %>
							  <tr><td><b>USG</b>(10-14 Weeks)</td>
							  <%if(usgFlagSecondGrid !=null && !usgFlagSecondGrid.equals("")){ %>
							  
							  							   <td colspan="3">	
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimSingle1" name="usgFirstTrimTwo1" type="radio"  <%=usgFlagSecondGrid.equalsIgnoreCase("single")?"checked":""%> onclick="setUsgFlagGrid2();firstTirmUsg10to14WeeksRevisit()" >Single</div>							   			    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTwins1" name="usgFirstTrimTwo1" type="radio"  <%=usgFlagSecondGrid.equalsIgnoreCase("Twins")?"checked":""%> onclick="setUsgFlagGrid2();firstTirmUsg10to14WeeksRevisit()" >Twins</div>
 <div style="width:75px; float:left;"> <input style="margin-top:-3px;" id="usgFirstTrimTriplets1" name="usgFirstTrimTwo1" type="radio" <%=usgFlagSecondGrid.equalsIgnoreCase("Triplets")?"checked":""%> onclick="setUsgFlagGrid2();firstTirmUsg10to14WeeksRevisit()" >Triplets</div>
                                        <input type="hidden" name="usgFlagSecondGridRevisit" id="usgFlagSecondGridRevisit" value="<%=revisitFlagSecondGrid %>" />
                                       <input type="hidden" name="secondGridRevisitThirdV" id="secondGridRevisitThirdV" value="<%=usgFirstTrimGrid2DateListThirdVisit.size() %>" />
                                       <input type="hidden" name="usgFlagSecondGrid" id="usgFlagSecondGrid" value="<%=usgFlagSecondGrid %>" />
							  
							  <%}else{ %>
							  
							   <td colspan="3">	
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimSingle1" name="usgFirstTrimTwo1" type="radio" checked="checked"  onclick="setUsgFlagGrid2();firstTirmUsg10to14Weeks();">Single</div>							   			    
 <div style="width:75px; float:left;"><input style="margin-top:-3px;" id="usgFirstTrimTwins1" name="usgFirstTrimTwo1" type="radio"   onclick="setUsgFlagGrid2();firstTirmUsg10to14Weeks();">Twins</div>
 <div style="width:75px; float:left;"> <input style="margin-top:-3px;" id="usgFirstTrimTriplets1" name="usgFirstTrimTwo1" type="radio"  onclick="setUsgFlagGrid2();firstTirmUsg10to14Weeks();">Triplets</div>
                                       <input type="hidden" name="usgFlagSecondGrid" id="usgFlagSecondGrid" value="" />
      </td>
				<%} %>	</tr>
				
				         <tr>
						<td>USG Parameters</td>
					
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ 
								for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								if(dateListFirstVisit.getUsgParameter().equalsIgnoreCase("Date")){
								%>
								
								 <td><input type="text" value="<%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								<div class="clear"></div>
								</td>
							
							<%}break;}} else { %>
							<td><input type="text" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>'),event);setfirstTrimSecondGridFirstVisitFlag()" />						
							 <input type="hidden" name="firstTrimSecondGridFirstVisitFlag" id="firstTrimSecondGridFirstVisitFlag" value="" /></td>	
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){ 
							for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimGrid2DateListSecondVisit ){
								if(dateListSecondVisit.getUsgParameter().equalsIgnoreCase("Date")){%>
								<td><input type="text" value="<%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							</td>
							<%}break;}} else { %>
							 <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" class="small" readonly="readonly"  tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>'),event);setfirstTrimSecondGridSecondVisitFlag()">
							 <input type="hidden" name="firstTrimSecondGridSecondVisitFlag" id="firstTrimSecondGridSecondVisitFlag" value="" /></td>
							<% grid2SecondVisitIndex++;} %>
						
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){ 
							for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimGrid2DateListThirdVisit ){ 
							if(dateListThirdVisit.getUsgParameter().equalsIgnoreCase("Date")) {%>
									<td><input type="text" value="<%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} else {%>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"  class="small" readonly="readonly" tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id);"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>'),event);setfirstTrimSecondGridThirdVisitFlag()">
							<input type="hidden" name="firstTrimSecondGridThirdVisitFlag" id="firstTrimSecondGridThirdVisitFlag" value="" /></td>
							<% grid2ThirdVisitIndex++; } %> 
							
							</tr> 
						
						<!-- ------- -->
				
				           <tr>
						<td>CRL</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("CRL")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivCrlTwins">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivCrlTwins">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivCrlTriplets">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivCrlTriplets">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("CRL")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivCrlTwinsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div> 
							    <div class="" style="display:none" id="dataDivCrlTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivCrlTwinsColTwo">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivCrlTwinsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivCrlTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivCrlTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("CRL")) { %> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivCrlTwinsColThree">
							     <input  type="text" id="usgFirstTrimGrid2TwinsThirdVq<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							     <div class="" style="display:none" id="dataDivCrlTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivCrlTwinsColThree">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivCrlTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivCrlTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivCrlTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
				
				<tr>
						<td>NT</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("NT")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivNtTwins">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivNtTwins">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivNtTriplets">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivNtTriplets">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("NT")) {%> 
								 <input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivNtTwinsColTwo">
							     <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivNtTripletsColTwo">
							     <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128"  tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivNtTwinsColTwo">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivNtTwinsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivNtTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivNtTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("NT")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivNtTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivNtTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivNtTwinsColThree">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivNtTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivNtTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivNtTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
							
							<tr>
						<td>NB</td>
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("NB")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivNbTwins">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1"/></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivNbTwins">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivNbTriplets">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivNbTriplets">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("NB")) {%> 
								 <input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivNbTwinsColTwo">
							     <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivNbTripletsColTwo">
							     <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivNbTwinsColTwo">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivNbTwinsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivNbTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivNbTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2"  /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("NB")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								 <div class="" style="display:none" id="dataDivNbTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivNbTripletsColThree">
							    <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivNbTwinsColThree">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivNbTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivNbTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivNbTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
							
							<tr>
						<td>GA</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("GA")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivGaTwins">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivGaTwins">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivGaTriplets">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivGaTriplets">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
						
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("GA")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivGaTwinsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivGaTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivGaTwinsColTwo">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivGaTwinsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivGaTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivGaTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
						
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("GA")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								   <div class="" style="display:none" id="dataDivGaTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivGaTripletsColThree">
							   <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivGaTwinsColThree">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivGaTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivGaTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivGaTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
							
							<tr>
						<td>Scan EDC</td>
					
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dateListFirstVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								if(dateListFirstVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){
								%>
								
								<input type="text" value="<%=dateListFirstVisit.getUsgParameterValue1() != null?dateListFirstVisit.getUsgParameterValue1():"" %>"  readonly="readonly"  />
								</td>
							
							<%break;}}} else { %>
							<td><input type="text" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" class="small" readonly="readonly" tabindex="1" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstTrimGrid2FirstV1');"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16"  border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>'),event);" /></td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg dateListSecondVisit : usgFirstTrimGrid2DateListSecondVisit ){
								if(dateListSecondVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")){%>
								<input type="text" value="<%=dateListSecondVisit.getUsgParameterValue2() != null?dateListSecondVisit.getUsgParameterValue2():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} else { %>
							 <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" class="small" readonly="readonly" tabindex="2" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstTrimGrid2SecondV1');"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>'),event);"></td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){ %>
							  <td>
								 <%for(OpdAntenatalUsg dateListThirdVisit : usgFirstTrimGrid2DateListThirdVisit ){ 
							if(dateListThirdVisit.getUsgParameter().equalsIgnoreCase("Scan EDC")) {%>
								<input type="text" value="<%=dateListThirdVisit.getUsgParameterValue3() != null?dateListThirdVisit.getUsgParameterValue3():"" %>"  readonly="readonly"  />
							</td>
							<%break;}}} else {%>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"  class="small" readonly="readonly" tabindex="3" onblur="validateUSGDate(this.id);ValidateLmp(this.id);validateScanEdcDate(this.id,'usgFirstGrid2TrimThirdV1');"/>
							<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=dateC%>',document.getElementById('usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>'),event);"></td>
							<% grid2ThirdVisitIndex++; } %> 
							
							</tr> 
							<tr>
						<td>Cx Length</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Cx Length")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								<%break;}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="3" tabindex="1" onkeypress="javascript:return isNumber(event);"/></td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Cx Length")) { %> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
							<%break;} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="3" tabindex="2" onkeypress="javascript:return isNumber(event);"/></td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){%>
								 
									 <%if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Cx Length")) { %> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
							<%break;}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="3" tabindex="3" onkeypress="javascript:return isNumber(event);"/></td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
							
							<tr>
						<td>Impression</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Impression")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivImpressionTwins">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivImpressionTwins">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivImpressionTriplets">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivImpressionTriplets">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Impression")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
							 	  <div class="" style="display:none" id="dataDivImpressionTwinsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							    <div class="" style="display:none" id="dataDivImpressionTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivImpressionTwinsColTwo">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivImpressionTwinsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivImpressionTripletsColTwo">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivImpressionTripletsColTwo">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Impression")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivImpressionTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivImpressionTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivImpressionTwinsColThree">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivImpressionTwinsColThree">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivImpressionTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivImpressionTripletsColThree">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
							
							<tr>
						<td>Remarks</td>
						
							<% if(usgFirstTrimGrid2DateListFirstVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisit : usgFirstTrimGrid2DateListFirstVisit ){ 
								 if(crlVisit.getUsgParameter().equalsIgnoreCase("Remarks")){ %>
								<input type="text" value="<%= crlVisit.getUsgParameterValue1() != null?crlVisit.getUsgParameterValue1():"" %>"  readonly="readonly" />
								 <div class="clear"></div>
								<%}} %> 
								</td>
							
							<%} else { %>
							
							<td><input type="text" id="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2FirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" />
						 	 <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivRemarksTwins1">
						 	   <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%}else{ %>
						 	  <div class="" style="display:none" id="dataDivRemarksTwins1">
						 	    <input  type="text" id="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TwinsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /></div> 
						 	  <%} %> 
						 	  
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	  <div class="" style="display:block" id="dataDivRemarksTriplets1">
							 <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	  <%} else { %> 
						 	  <div class="" style="display:none" id="dataDivRemarksTriplets1">
							  <input  type="text" id="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" name="usgFirstTrimGrid2TripletsFirstV<%=grid2FirstVisitIndex%>" value="" maxlength="128" tabindex="1" /> 
							  </div>
						 	<%} %>
							 </td>							
							<% grid2FirstVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListSecondVisit.size()>0){%>
							  <td>
								 <%for(OpdAntenatalUsg crlVisitList : usgFirstTrimGrid2DateListSecondVisit ){ 
								  if(crlVisitList.getUsgParameter().equalsIgnoreCase("Remarks")) {%> 
								<input type="text" value="<%=crlVisitList.getUsgParameterValue2() != null?crlVisitList.getUsgParameterValue2():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivRemarksTwinsColTwo1">
							     <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
							     <div class="" style="display:none" id="dataDivRemarksTripletsColTwo1">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
							<%} }%>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" value="" id="usgFirstTrimGrid2SecondV<%=grid2SecondVisitIndex%>" maxlength="128" tabindex="2" />
						 	  <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	   <div class="" style="display:block" id="dataDivRemarksTwinsColTwo1">
							  <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /></div>  
						 	   <%}else{ %> 
						 	   <div class="" style="display:none" id="dataDivRemarksTwinsColTwo1">
							   <input  type="text" id="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TwinsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128" tabindex="2" /></div>
						 	  <%} %>
						 	    <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
						 	     <div class="" style="display:block" id="dataDivRemarksTripletsColTwo1">
							    <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	    <%}else{ %> 
						 	     <div class="" style="display:none" id="dataDivRemarksTripletsColTwo1">
							   <input  type="text" id="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" name="usgFirstTrimGrid2TripletsSecondV<%=grid2SecondVisitIndex%>" value="" maxlength="128"  tabindex="2" /> </div>
						 	   <%} %> 
							
							  </td>
							<% grid2SecondVisitIndex++;} %>
							
							<%if(usgFirstTrimGrid2DateListThirdVisit.size()>0){%>
							  <td>
								 <% for(OpdAntenatalUsg crlThirdVisitList : usgFirstTrimGrid2DateListThirdVisit ){
									  if(crlThirdVisitList.getUsgParameter().equalsIgnoreCase("Remarks")) {%> 
								<input type="text" value="<%=crlThirdVisitList.getUsgParameterValue3() != null?crlThirdVisitList.getUsgParameterValue3():"" %>"  readonly="readonly" disabled="disabled" />
								 <div class="clear"></div>
								  <div class="" style="display:none" id="dataDivRemarksTwinsColThree1">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							      <div class="" style="display:none" id="dataDivRemarksTripletsColThree1">
							    <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							<%}} %>
							</td>
							<%} else { %>
							   <td><input type="text" name="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>" value="" id="usgFirstGrid2TrimThirdV<%=grid2ThirdVisitIndex%>"maxlength="128" tabindex="3" />
							   <% if(usgFlagSecondGrid.equalsIgnoreCase("Twins") || usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>
								    <div class="" style="display:block" id="dataDivRemarksTwinsColThree1">
							        <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
								   <%}else{ %>
								    <div class="" style="display:none" id="dataDivRemarksTwinsColThree1">
							      <input  type="text" id="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TwinsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							   <%} %> 
								  <% if(usgFlagSecondGrid.equalsIgnoreCase("Triplets")) { %>  
							  <div class="" style="display:block" id="dataDivRemarksTripletsColThree1">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%}else{ %> 
							  <div class="" style="display:none" id="dataDivRemarksTripletsColThree1">
							  <input  type="text" id="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" name="usgFirstTrimGrid2TripletsThirdV<%=grid2ThirdVisitIndex%>" value="" maxlength="128" tabindex="3" /></div>
							  <%} %>
							  </td>
							<%} grid2ThirdVisitIndex++; %>
							
							</tr>
						
						</table> 
			<div class="clear"></div>
		
		</div>
		
		</div>	 
					
					<%-- <div class="floatLeft" style="width: 500px; margin-left: 20px;">
						<table width="40%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th scope="col">CVS</th>
								<th scope="col">RESP SYSTEM</th>
								<th scope="col">Others</th>
							</tr>
							<tr>
								<td><textarea class="opdMainTextArea" name="ftCVS"
										id="ftCVS" maxlength="300"><%=cvs %></textarea></td>
								<td><textarea class="opdMainTextArea" name="ftRespSys" id="ftRespSys" maxlength="300"><%=respSystem %></textarea></td>
								<td><textarea class="opdMainTextArea" name="ftOthersFirstTrimster" id="ftOthersFirstTrimster" maxlength="300"><%=othersFirstTrimster != null?othersFirstTrimster:"" %></textarea></td>
							</tr>
						</table>
						<div class="clear"></div> --%>
						
						<%-- <table width="40%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<th scope="col">DATE</th>
								<th scope="col">ADVISE</th>
							</tr>
							<tr>
								<td><input name="ftSubDate" type="text" id="ftSubDate"
									value="<%=ftDate %>" class="dateTextSmall" readonly="readonly" />
									<img src="/hms/jsp/images/cal.gif" width="16" height="16"
									border="0" validate="Pick a date"
									onclick="setdate('<%=dateC%>',document.opdMain.ftSubDate,event);" />
								</td>
								<td><textarea class="opdMainTextArea" name="ftAdvise"
										id="ftAdvise" maxlength="300"><%=ftAdvise %></textarea></td>
							</tr>
						</table> --%>
					<!-- </div> -->
				<!-- </div> -->
			<!-- </div> -->
			
 </div>
 <div class="clear"></div>
</div>

<div id="inAncTab3" class="inAncTabcontent">
<div class="clear"></div>
<!-- second trimester -->
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Second Trimester')" id="Trimester2SummeryId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">SECOND TRIMESTER</h4></div>			
<div class="clear"></div>

<div class="Block">
<div  id="secondTrimesterDiv">
<h6>CLINICAL EXAMINATION CHART</h6>
<div id="Trimester2Summery" style="background:#fff;height:60px; width: 1158px;text-align:left;" class="tableForTab">
        <%counter=0;for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim2){ %>
					<%if(trim.getGeneralExamination()!=null || trim.getSystemicExamin()!=null || trim.getPaTrimes()!=null) {%>
				<p><%=++counter%>
				<%if(trim.getGeneralExamination()!=null && !trim.getGeneralExamination().isEmpty()){ %>
				 General Examination: <%=trim.getGeneralExamination()%> 
				  <%} %>
				  <%if(trim.getSystemicExamin()!=null && !trim.getSystemicExamin().isEmpty()) %>
				    Systemic Examination: <%=trim.getSystemicExamin()%> 
				    <%if(trim.getPaTrimes()!=null && !trim.getPaTrimes().isEmpty()){%>
				 	PA: <%=trim.getPaTrimes()%> 
				 <%} %>
				 
				 <%if(trim.getWeight()!=null ){%>
				 	Weight: <%=trim.getWeight()%> 
				 <%} %>
				 
				 <%if(HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate())!=null ){%>
				 	Date: <%=HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate())%> 
				 <%} %>
				 
				</p>
				<%}} %>
</div>
			
			<div class="indArrow"></div>
				<div class="clear"></div>
				<div class="floatRight" style="width:130px;">
					<input type="button" class="buttonDel" value="" onclick="removeRow1('stTable');" />
					 <input type="button" class="buttonAdd" onclick="addRow2();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab" style="width:1158px">
						<div id="divTemplet1">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="stTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">Weight (Kg)</th>
									<th scope="col">General Examination</th>
									<!-- <th scope="col">Pallor</th>
									<th scope="col">Edema</th> -->									
									<th scope="col">BP (mm Hg)</th>
									<th scope="col">P/A</th>
									<th scope="col">SFH</th>
									<th scope="col">FH</th>									
									<!-- <th scope="col">Local Examination</th> -->
									<th scope="col">Systemic Examination</th>												
									<th scope="col">U.Alb</th>
									<th scope="col">Risk</th>
									<th scope="col">Advice</th>
									
									
									
								</tr>
								<%
					   int incr1 = 0,len1=1;
						int inxRow1 = 1;
						int inxCol1 = 0;
						if(opdAntenatalCardTrim2.size()>0){
							int count=0;
							for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim2){
								count=count+1;
							%>
							<%if(trim.getTrimesDate() != null && !trim.getTrimesDate().equals("")){ %>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><div style="float: left; width:115px;"><input type="text"
										value="<%=trim.getTrimesDate() != null?HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate()):""%>"
										 class="dateTextSmall"
										readonly="readonly"> <%-- <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.getElementById('stdate<%=incr1%>'),event);" /> --%></div></td>
										
										
									<td scope="col"><div style="float: left; width:85px;"><input class="opdTextBoxTSmall"
										 type="text" size="10"
										value="<%=trim.getGaWeeks() != null?trim.getGaWeeks():""%>" placeholder="Weeks" 
										maxlength="45" style="width:38px;"/> <input class="opdTextBoxTSmall"
										t type="text" size="10" 
										value="<%=trim.getGaDays() != null?trim.getGaDays():""%>" placeholder="Days" 
										maxlength="45" style="width:26px;"/></div></td>
										
									<td scope="col"><input class="opdTextBoxTSmall" 
									 type="text"
									value="<%=trim.getWeight() != null?trim.getWeight():""%>" size="10" maxlength="2" /></td>
									<td scope="col"><input type="text" style="width:119px;" readonly="readonly" maxlength="3" placeholder="NAD" value="<%=trim.getGeneralExamination() != null?trim.getGeneralExamination():""%>" /></td>
									
									<%-- <td><select class="YesNo">
											<%
												String stPallor = "Select";
											if(trim.getPallor() != null && !trim.getPallor().equals("")){
															if (trim.getPallor().equalsIgnoreCase("y")) {
																stPallor = "Yes";
															} else if (trim.getPallor().equalsIgnoreCase("n")) {
																stPallor = "No";
															} else if (trim.getPallor().equalsIgnoreCase("")) {
																stPallor = "";
															}
											}
											%>
											<option value="<%=trim.getPallor()%>"><%=stPallor != null?stPallor:""%></option>
									</select></td> --%>
									<%-- <td><select class="YesNo">
											<%
												String stOdemia = "Select";
											if(trim.getOdemia() != null && !trim.getOdemia().equals("")){	
														if (trim.getOdemia().equalsIgnoreCase("y")) {
																stOdemia = "Yes";
															} else if (trim.getOdemia().equalsIgnoreCase("n")) {
																stOdemia = "No";
															} else if (trim.getOdemia().equalsIgnoreCase("")) {
																stOdemia = "";
															}
											}else{
												stOdemia = "";
											}
											%>
											<option value="<%=trim.getOdemia()%>"><%=stOdemia%></option>
									</select></td> --%>
										
										
									<td scope="col"><div style="float: left; width: 146px;"> <input placeholder="Systolic" 
										 type="text"
										maxlength="3" value="<%=trim.getBpSystolics() != null?trim.getBpSystolics():""%>"
										class="allownumericwithoutdecimal textSmall" /> <label
										class="smallAuto autoSpace">/</label> <input
										value="<%=trim.getBpDiastolics() != null?trim.getBpDiastolics():""%>" placeholder="Diastolic" 
										type="text" maxlength="3"
										class="allownumericwithoutdecimal textSmall" /><!-- <label
										class="smallAuto autoSpace">mm&nbsp;Hg</label> --></div></td>
										<td scope="col"><input type="text" class="opdTextBoxTSmall" maxlength="300" readonly="readonly" value="<%=trim.getPaTrimes() != null?trim.getPaTrimes():""%>" /></td>
										<td scope="col"><input type="text" size=3 readonly="readonly" maxlength="3" value="<%=trim.getFhs() != null?trim.getFhs():""%>" /></td>
										<td scope="col"><input type="text" readonly="readonly" maxlength="10" placeholder="+" value="<%=trim.getFh() != null?trim.getFh():""%>" /></td>
									
								<%-- 	<td><input type="text" readonly="readonly" maxlength="300" value="<%=trim.getLocalExamination() != null?trim.getLocalExamination():"" %>" /></td> --%>
									<td><input type="text" readonly="readonly" maxlength="300" placeholder="WNL" value="<%=trim.getSystemicExamin() != null?trim.getSystemicExamin():""%>" /></td>
									
									
									
									<td scope="col">
										<%String urinAlbumin="";
							if(trim.getUrinAlbumin()!=null){
								urinAlbumin=trim.getUrinAlbumin();
							}
							%> <input class="opdTextBoxTSmall" 
										 type="text"
										value="<%=urinAlbumin%>" size="10" maxlength="45" />
									</td>
									
						<td>
									<select id="risk" name="risk" class="smallnew" >
									<option value="Low" <%=trim.getObstetricRiskMeasure().equals("Low")?"selected='selected'":"" %> >Low</option>
									<option value="High" <%=trim.getObstetricRiskMeasure().equals("High")?"selected='selected'":"" %>>High</option>
									</select>																
									
									</td>			
						<%-- <td><input type="text" readonly="readonly" maxlength="300" value="<%=trim.getObstetricRiskMeasure() != null?trim.getObstetricRiskMeasure():""%>" /> </td> --%>			
						<td scope="col"><input type="text" size=22 readonly="readonly" maxlength="50" value="<%=trim.getOthers() != null?trim.getOthers():""%>" /></td>
											
									
								</tr>
								<%
							}
							}
						}
						for(;incr1< len;incr1++,inxRow1++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										 class="radioCheck"
										id="itemRadio1<%=incr1%>" name="itemRadio1<%=incr1%>"
										onchange="checkPrescriptionCheck(<%=incr1%>)" /></td>
									<td scope="col"><div style="float: left; width:115px;"><input type="text" id="stdate<%=incr1%>"
										name="stdate<%=incr1%>" class="dateTextSmall ValidateLMPandTrim2Date" 
										readonly="readonly" onblur="checkTrimDate('stdate','<%=incr1%>','2');ValidateLMPandTrim2Date();openPopupForExamination(<%=incr1%>,'2')" /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.getElementById('stdate<%=incr1%>'),event);" /></div></td>
										
										
									<td scope="col"><div style="float: left; width:85px;"><input class="opdTextBoxTSmall"
										 type="text"  validate="stGA1<%=incr1%>,num,no" readonly="readonly"
										name="stGA1<%=incr1%>" id="stGA1<%=incr1%>"  size="10"
										placeholder="Weeks" maxlength="2" style="width:38px;"/> <input
										class="opdTextBoxTSmall" validate="stGA2<%=incr1%>,num,no" readonly="readonly"
										 type="text"
										name="stGA2<%=incr1%>" id="stGA2<%=incr1%>" size="10"
										placeholder="Days" maxlength="2" style="width:26px;"/></div></td>
										
								<td scope="col"><input class="opdTextBoxTSmall"
										 type="text"
										name="stWeight<%=incr1%>" id="stWeight<%=incr1%>" size="10"  onkeypress="javascript:return isNumber(event)" validate="stWeight<%=incr1%>,float,no" onblur="openPopupForExamination(<%=incr1%>,'2')"
										maxlength="5" /></td>	
								<td scope="col"><textarea class="autoWidthFocus" id="stGeneralExaminationTrim<%=incr1%>" name="stGeneralExaminationTrim<%=incr1%>" placeholder="WNL"   onblur="openPopupForExamination(<%=incr1%>,'2')"></textarea>
											</td>
								<%-- <td scope="col"><select id="stPallor<%=incr1%>" name="stPallor<%=incr1%>" class="YesNo" >
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td>
									<td scope="col"><select id="stOdemia<%=incr1%>" 
										name="stOdemia<%=incr1%>" class="YesNo"
										>
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td>	 --%>
										
										
									<td scope="col"><div style="float: left; width: 146px;"> <input name="stsystolic<%=incr1%>" 
										id="stsystolic<%=incr1%>" placeholder="Systolic" validate="stsystolic<%=incr1%>,num,no"
										 type="text" style="width:41px;"
										maxlength="3" class="allownumericwithoutdecimal textSmall" onblur="checkSystolicDiastolic('stsystolic<%=incr1%>','stdiastolic<%=incr1%>');openPopupForExamination(<%=incr1%>,'2')" onkeypress="javascript:return isNumber(event)"/>
										<label class="smallAuto autoSpace">/</label> <input
										name="stdiastolic<%=incr1%>" id="stdiastolic<%=incr1%>"										
										placeholder="Diastolic" type="text" maxlength="3" validate="stdiastolic<%=incr1%>,num,no"
										class="allownumericwithoutdecimal textSmall" style="width:43px;" onblur="checkSystolicDiastolic('stsystolic<%=incr1%>','stdiastolic<%=incr1%>');openPopupForExamination(<%=incr1%>,'2')" onkeypress="javascript:return isNumber(event)"/><!-- <label
										class="smallAuto autoSpace">mm&nbsp;Hg</label> --></div></td>
									
									<td scope="col"><textarea class="autoWidthFocus" size="10" placeholder="WNL"  name="stPA<%=incr1%>" id="stPA<%=incr1%>" maxlength="240"  onblur="openPopupForExamination(<%=incr1%>,'2');openPopupForExamination(<%=incr1%>,'2')"></textarea></td>		
									
									<td scope="col"><input class="opdTextBoxTSmall" validate="stFhs<%=incr1%>,num,no"
										 type="text"
										name="stFhs<%=incr1%>" id="stFhs<%=incr1%>" style="width:28px;" size="10"
										maxlength="3" onblur="openPopupForExamination(<%=incr1%>,'2')" /></td>
									<td scope="col"><input class="opdTextBoxTSmall" id ="stFh<%=incr1%>" name="stFh<%=incr1%>" validate="stFh<%=incr1%>,metachar,no"
										 type="text" style="width:28px;" size="30" placeholder="+" onblur="openPopupForExamination(<%=incr1%>,'2')"/></td>	
																		
									
							<%-- <td scope="col"><input type="text"  name="stLocalExaminationTrim<%=incr1%>" id="stLocalExaminationTrim<%=incr1%>" maxlength="240" /></td> --%>
									
									<td scope="col"><textarea class="autoWidthFocus"
											 name="stSystemicExam<%=incr1%>"
											placeholder="WNL" id="stSystemicExam<%=incr1%>" maxlength="240"  onblur="openPopupForExamination(<%=incr1%>,'2')"></textarea></td>
											
								<td scope="col"><input class="opdTextBoxTSmall"
										 type="text"
										name="stUrinAl<%=incr1%>" id="stUrinAl<%=incr1%>" size="10" validate="stUrinAl<%=incr1%>,num,no"
										maxlength="45" onblur="openPopupForExamination(<%=incr1%>,'2')"/></td>	
										
											<td scope="col">			
										<select name="stObsRi<%=incr1%>" id="stObsRi<%=incr1%>" validate="stothersTrim<%=incr1%>,string,no"  class="smallnew" onblur="openPopupForExamination(<%=incr1%>,'2')" >
											<%if(risk!=null && !risk.equalsIgnoreCase("high")) {%>
											<option value="Low" selected="selected">Low</option><%}%>
											<option value="High">High</option>
											</select>
									  </td>
										<%-- <td scope="col"><input type="text"  name="stObsRi<%=incr1%>" id="stObsRi<%=incr1%>" maxlength="240" /></td> --%>	
									
									<td scope="col"><textarea  validate="stothersTrim<%=incr1%>,string,no"  type="text" onblur="openPopupForExamination(<%=incr1%>,'2')"
										name="stothersTrim<%=incr1%>" id="stothersTrim<%=incr1%>"
										maxlength="300"><%=lastPrescription!=null?lastPrescription:"" %></textarea></td>		
											
									
								</tr>
								<% } %>
							</table>
							<input type="hidden" name="hdb1" value="<%=incr1-1 %>" id="hdb1" />
							<input type="hidden" name="hdbTabIndex1" id="hdbTabIndex1"
								value="<%=inxRow1-1%>" />
						</div>
					</div>
				</div>
			</div>
			</div>
			<!-- ----------------------------------Start Lab Result Second Trimester----------------------------------------- -->
<div class="clear"></div>	
<h4 style="cursor:pointer;float:left;" onclick="popwindowResultEntryForDermotologyAnc('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>@@@<%=templateName%>');">External Lab Report Entry</h4>
<div class="clear"></div>		
			
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Lab Result Second Trimester')" id="labResultSecondTrimesterId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Lab Result Second Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	
<div  id="labResultSecondTrimester"  >
<div class="indArrow"></div>
				<!-- changes for external lab report -->
				
				<div class="Block">
			<div class="clear"></div>			
<%if(sortedSecondTrimTestdate.size()>0 && commonLabTestReportsSecondMap.size()>0){ %>
<label>Lab test report</label>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet2">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="OutSidelabResultSecondTrim">
							<tr>
								<th>Test Name</th>
								<%	int labSecondTrimIndex=0;
							for(; labSecondTrimIndex < sortedSecondTrimTestdate.size(); labSecondTrimIndex++ ){ %>
		     				<th><%=HMSUtil.convertStringDateFormat(sortedSecondTrimTestdate.get(labSecondTrimIndex)) %> </th> 
		     				<%} %>
							</tr>
							<%
								Iterator secondRecords = commonLabTestReportsSecondMap.entrySet().iterator();
							    while (secondRecords.hasNext()) {
							    Map.Entry secondEntry = (Map.Entry) secondRecords.next();
							    String secondkey = (String)secondEntry.getKey();	    
							%>		
		                    <tr>
		    <td style="width: 175px;"><input type="text" name="testN" value="<%=secondkey%>"   readonly="readonly"  /></td>
		  
		   <%	
							    List <CommonLabTestReport> testDispListSecondTrim = new ArrayList<CommonLabTestReport>();
		                        testDispListSecondTrim  = (ArrayList<CommonLabTestReport>)secondEntry.getValue();
		                        for(int dateIndex=0; dateIndex < sortedSecondTrimTestdate.size(); dateIndex++ ){
		                    	  List<CommonLabTestReport> localListSecondTrim = new ArrayList<CommonLabTestReport>();
		                    	  for(CommonLabTestReport reportListSecondTrim : testDispListSecondTrim){		
									
									if(sortedSecondTrimTestdate !=null && sortedSecondTrimTestdate.get(dateIndex).equalsIgnoreCase(reportListSecondTrim.getResultDate())){
										localListSecondTrim.add(reportListSecondTrim);
								  }
		                    	  }
		                      
		                    	//single test start
									if (localListSecondTrim.size() == 1) {%>
									<%if(localListSecondTrim.get(0).getTestType().equalsIgnoreCase("Internal Test")) {%>
									<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=localListSecondTrim.get(0).getDgId()%>','<%=localListSecondTrim.get(0).getInvestigationId()%>');">Lab Results</a></td>
									<%} %>
										<%if(localListSecondTrim.get(0).getTestType().equalsIgnoreCase("External Test")){
										if(localListSecondTrim.get(0).getTestStatus()!=null && !localListSecondTrim.get(0).getTestStatus().equals("") && localListSecondTrim.get(0).getTestResult().equals("")) {%>
										<td> <a href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localListSecondTrim.get(0).getInvestigationId()%>','<%=localListSecondTrim.get(0).getResultDate()%>','<%=hinId%>','<%=localListSecondTrim.get(0).getResultTime() %>');">Lab Results</a> </td>
										<%}else if (localListSecondTrim.get(0).getTestStatus()!=null && !localListSecondTrim.get(0).getTestStatus().equals("") && localListSecondTrim.get(0).getTestStatus().equalsIgnoreCase("Abnormal")){ %>
										<td> <%=localListSecondTrim.get(0).getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>" %> </td>
										<%} else {%>							
								 <td> <%=localListSecondTrim.get(0).getTestResult().replaceFirst("^0+(?!$)", "") %> </td>
									<% }	
										}}
									//single test end
									if (localListSecondTrim.size() ==0) {%>
										<td>-</td>	
			                    	
			                    	    
			                      <%}%> 
								<%if (localListSecondTrim.size() > 1) {%>
								<td>
									
								  <% String resSecondTrim="";String  hLinkSecondTrim="";
								  for(CommonLabTestReport finalReportSecondTrim : localListSecondTrim){
									  String testResultSecondTrim="";
									  if(finalReportSecondTrim.getTestType().equalsIgnoreCase("External Test")){
									  if(finalReportSecondTrim.getTestResult()==null || finalReportSecondTrim.getTestResult().equals("")){
										  if(!finalReportSecondTrim.getResultTime().equals("00:00"))
											  hLinkSecondTrim = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReportSecondTrim.getInvestigationId()).concat("'")
												   .concat(",").concat("'").concat(finalReportSecondTrim.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReportSecondTrim.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results - "+finalReportSecondTrim.getResultTime()+"</a>");
										      else
										    	  hLinkSecondTrim = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReportSecondTrim.getInvestigationId()).concat("'")
											   .concat(",").concat("'").concat(finalReportSecondTrim.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReportSecondTrim.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results</a>");  
										    
										  resSecondTrim= resSecondTrim.concat("\n").concat(hLinkSecondTrim);	 
									  }	
									  if(finalReportSecondTrim.getTestResult()!=null && !finalReportSecondTrim.getTestResult().equals("")){
										  if(!finalReportSecondTrim.getResultTime().equals("00:00")){
											  if(finalReportSecondTrim.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResultSecondTrim= finalReportSecondTrim.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>"+"-"+finalReportSecondTrim.getResultTime();
											  else
												  testResultSecondTrim= finalReportSecondTrim.getTestResult().replaceFirst("^0+(?!$)", "")+"-"+finalReportSecondTrim.getResultTime();  
										  }else{
											  if(finalReportSecondTrim.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResultSecondTrim= finalReportSecondTrim.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>";
											  else
												  testResultSecondTrim= finalReportSecondTrim.getTestResult().replaceFirst("^0+(?!$)", "");  
										  }
										  resSecondTrim = resSecondTrim.concat(testResultSecondTrim).concat(", ");
									  }
									  } // external test end here
									    // internal test starts here
									  if(finalReportSecondTrim.getTestType().equalsIgnoreCase("Internal Test")){
										  if(finalReportSecondTrim.getTestResult()==null || finalReportSecondTrim.getTestResult().equals("")){
											  
											  hLinkSecondTrim = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReportSecondTrim.getDgId()).concat("'")
													   .concat(",").concat("'").concat(""+finalReportSecondTrim.getInvestigationId()).concat("'").concat(");").concat("\"").concat(">Lab Results - "+finalReportSecondTrim.getResultTime()+"</a>");
											    
											    resSecondTrim= resSecondTrim.concat("\n").concat(hLinkSecondTrim);	 
										  }	
										  } // internal test end here
									} // end of for loop %>
								<%=resSecondTrim %>	
								</td>		
								<%}}} %>
									</tr>
		
						</table>
						
					</div>
				</div>
				<%}else{ %>
						<span>No Test Record found</span>
						<%} %>
				</div>
				<!-- changes for external lab report end -->
				</div>

<!-- ----------------------------------End Of Lab Result Second Trimester----------------------------------------- -->
<!-- third trimester -->
<div class="clear"></div>

<jsp:include page="ancUsgSecondTrim.jsp" /> 

<div class="clear"></div>
</div>

<div id="inAncTab4" class="inAncTabcontent">
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Third Trimester')" id="thirdTrimesterDivId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">THIRD TRIMESTER</h4></div>
			<div class="clear"></div>
			<div class="Block">
			<div  id="thirdTrimesterDiv">
			<h6>CLINICAL EXAMINATION CHART</h6>
			<div id="Trimester3Summery" style="background:#fff;height:60px; width: 1158px;text-align:left;" class="tableForTab">
			<%counter=0;for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim3){ %>
				<%if(trim.getGeneralExamination()!=null || trim.getSystemicExamin()!=null || trim.getPaTrimes()!=null) {%>
				<p><%=++counter%>
				<%if(trim.getGeneralExamination()!=null && !trim.getGeneralExamination().isEmpty()){ %>
				 General Examination: <%=trim.getGeneralExamination()%> 
				  <%} %>
				  <%if(trim.getSystemicExamin()!=null && !trim.getSystemicExamin().isEmpty()) %>
				    Systemic Examination: <%=trim.getSystemicExamin()%> 
				    <%if(trim.getPaTrimes()!=null && !trim.getPaTrimes().isEmpty()){%>
				 	PA: <%=trim.getPaTrimes()%> 
				 <%} %>
				</p>
				<%} }%>
			</div>
			
			<div class="indArrow"></div>
				<div class="clear"></div>
				<div class="floatRight" style="width: 130px;">
					<input type="button" class="buttonDel" value="" onclick="removeRow1('ttTable');" />
					 <input type="button" class="buttonAdd" onclick="addRow3();" value="" />
				</div>
				<div class="clear"></div>
				<div class="">
					<div class="tableForTab" style="width:1158px">
						<div id="divTemplet1">

							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="ttTable">
								<tr>
									<th scope="col">&nbsp;</th>
									<th scope="col">Date</th>
									<th scope="col">GA</th>
									<th scope="col">Weight (Kg)</th>
									<th scope="col">General Examination</th>
									<!-- <th scope="col">Pallor</th>
									<th scope="col">Edema</th> -->
									<th scope="col">BP (mm Hg)</th>
									<th scope="col">P/A</th>
									<th scope="col">SFH</th>
									<th scope="col">FH</th>
									<th scope="col">Systemic Examination</th>
									<th scope="col">U.Alb</th>
									<th scope="col">Risk</th>									
									<th scope="col">Advice</th>										
								</tr>
								<%
					   int incr2 = 0,len2=1;
						int inxRow2 = 1;
						int inxCol2 = 0;
						if(opdAntenatalCardTrim3.size()>0){
							int count=0;
							for(OpdAntenatalCardTrimester trim:opdAntenatalCardTrim3){
							count=count+1;
							%>
							<%if(trim.getTrimesDate() != null && !trim.getTrimesDate().equals("")){ %>
								<tr>
									<td scope="col"><%=count %></td>
									<td scope="col"><div style="float: left; width:115px;"><input type="text"
										value="<%=trim.getTrimesDate() != null?HMSUtil.convertDateToStringWithoutTime(trim.getTrimesDate()):""%>"
										 class="dateTextSmall"
										readonly="readonly"> <%-- <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.getElementById('ttdate<%=incr2%>'),event);" /> --%></div></td>
									<td scope="col"><div style="float: left; width:85px;"><input class="opdTextBoxTSmall"
										 type="text" size="10" 
										value="<%=trim.getGaWeeks() != null?trim.getGaWeeks():""%>" placeholder="Weeks"
										maxlength="45" style="width:38px;"/> <input class="opdTextBoxTSmall"
										 type="text" size="10" 
										value="<%=trim.getGaDays() != null?trim.getGaDays():""%>" placeholder="Days"
										maxlength="45" style="width:26px;"/></div></td>
										
										<td scope="col"><input class="opdTextBoxTSmall"
										 type="text"
										value="<%=trim.getWeight() != null?trim.getWeight():""%>" size="10" maxlength="2" /></td>
										<td scope="col"><input type="text" size=20 readonly="readonly" maxlength="3" value="<%=trim.getGeneralExamination() != null?trim.getGeneralExamination():""%>" /></td>
										<%-- <td><select class="YesNo">
											<%
												String ttPallor = "Select";
											
													if(trim.getPallor() != null && !trim.getPallor().equals("")){	
															if (trim.getPallor().equalsIgnoreCase("y")) {
																ttPallor = "Yes";
															} else if (trim.getPallor().equalsIgnoreCase("n")) {
																ttPallor = "No";
															} else if (trim.getPallor().equalsIgnoreCase("")) {
																ttPallor = "";
															}
													}else{
														ttPallor="";
													}
											%>
											<option value="<%=trim.getPallor()%>"><%=ttPallor%></option>
									</select></td> --%>
									<%-- <td><select class="YesNo">
											<%
												String ttOdemia = "Select";
											if(trim.getOdemia() != null && !trim.getOdemia().equals("")){	
														if (!trim.getOdemia().equalsIgnoreCase("y")) {
																ttOdemia = "Yes";
															} else if (!trim.getOdemia().equalsIgnoreCase("n")) {
																ttOdemia = "No";
															} else if (!trim.getOdemia().equalsIgnoreCase("")) {
																ttOdemia = "";
															}
											}else{
												ttOdemia="";
											}
											%>
											<option value="<%=trim.getOdemia()%>"><%=ttOdemia%></option>
									</select></td> --%>
										
										
							<td scope="col"><div style="float: left; width: 146px;"><input placeholder="Systolic"  type="text"
										maxlength="3" value="<%=trim.getBpSystolics() != null?trim.getBpSystolics():""%>" class="allownumericwithoutdecimal textSmall" /> <label
										class="smallAuto autoSpace">/</label>
							<input  value="<%=trim.getBpDiastolics() != null?trim.getBpDiastolics():""%>" placeholder="Diastolic"
										type="text" maxlength="3" class="allownumericwithoutdecimal textSmall" /><!-- <label
										class="smallAuto autoSpace">mm&nbsp;Hg</label> --></div></td> 
										<td scope="col"><input type="text" maxlength="300"
											readonly="readonly" value="<%=trim.getPaTrimes() != null?trim.getPaTrimes():""%>"  size="10"/></td>
										
										<td scope="col"><input type="text" size=3 readonly="readonly" maxlength="3" value="<%=trim.getFhs() != null?trim.getFhs():""%>" /></td>
										
									<td><input type="text" readonly="readonly" maxlength="300" value="<%=trim.getFh() != null?trim.getFh():""%>" /></td>
									<td><input type="text" readonly="readonly" maxlength="300" placeholder="WNL" value="<%=trim.getSystemicExamin() != null?trim.getSystemicExamin():""%>" /></td>
										
									<td scope="col">
										<%String urinAlbumin="";
							if(trim.getUrinAlbumin()!=null){
								urinAlbumin=trim.getUrinAlbumin();
							}
							%> <input class="opdTextBoxTSmall"
										 type="text"
										value="<%=urinAlbumin != null?urinAlbumin:""%>" size="10" maxlength="45" />
									</td>
								<td>
									<select  class="smallnew">
									<option value="Low" <%=trim.getObstetricRiskMeasure().equals("Low")?"selected='selected'":"" %> >Low</option>
									<option value="High" <%=trim.getObstetricRiskMeasure().equals("High")?"selected='selected'":"" %>>High</option>
									</select>																
									
									</td>			
							<%-- <td><input type="text" readonly="readonly" maxlength="300" value="<%=trim.getObstetricRiskMeasure() != null?trim.getObstetricRiskMeasure():""%>" /></td> --%>
											
						<td scope="col">
										
							 <input   type="text"
										value="<%=trim.getOthers() != null?trim.getOthers():""%>" size="22" maxlength="50" />
									</td>		
									
									
									
								</tr>
								<%
							}
							}
						}
						for(;incr2< len;incr2++,inxRow2++){
					%>
								<tr>
									<td scope="col"><input type="checkbox"
										 class="radioCheck"
										id="itemRadio2<%=incr2%>" name="itemRadio2<%=incr2%>"
										onchange="checkPrescriptionCheck(<%=incr2%>)" /></td>
									<td scope="col"><div style="float: left; width:115px;"><input type="text" id="ttdate<%=incr2%>"
										name="ttdate<%=incr2%>" 
										 class="dateTextSmall ValidateLMPandTrim3Date"
										readonly="readonly" onblur="checkTrimDate('ttdate','<%=incr2%>','3');ValidateLMPandTrim3Date();openPopupForExamination(<%=incr2%>,'3')"  /> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"  
										border="0" validate="Pick a date"
										onclick="setdate('<%=dateC%>',document.getElementById('ttdate<%=incr2%>'),event);" 
									
										/></div></td>
										
									<td scope="col"><div style="float: left; width:85px;"><input class="opdTextBoxTSmall"
										 type="text" validate="ttGA1<%=incr2%>,num,no" readonly="readonly"
										name="ttGA1<%=incr2%>" id="ttGA1<%=incr2%>"  size="10"
										placeholder="Weeks" maxlength="2" style="width:38px;"/> <input
										class="opdTextBoxTSmall"
										 type="text" validate="ttGA2<%=incr2%>,num,no" readonly="readonly"
										name="ttGA2<%=incr2%>" id="ttGA2<%=incr2%>" size="10"
										placeholder="Days" maxlength="2" style="width:26px;"/></div></td>
										
										<td scope="col"><input class="opdTextBoxTSmall" 
onkeypress="javascript:return isNumber(event)"	 type="text" validate="ttWeight<%=incr2%>,float,no" onblur="openPopupForExamination(<%=incr2%>,'3')"
										name="ttWeight<%=incr2%>" id="ttWeight<%=incr2%>" size="10"
										maxlength="5" /></td>
										
										<td scope="col"> <textarea class="autoWidthFocus" id="ttGeneralExaminationTrim<%=incr2%>"
										name="ttGeneralExaminationTrim<%=incr2%>" name="stGeneralExaminationTrim<%=incr1%>" placeholder="WNL"  onblur="openPopupForExamination(<%=incr2%>,'3')"></textarea>
										
										<%-- <td scope="col"><select id="ttGeneralExaminationTrim<%=incr2%>"
										name="ttGeneralExaminationTrim<%=incr2%>" 
										>
											<option value="">select</option>
											<option value="Pallor">Pallor</option>
											<option value="Icterus">Icterus</option>
											<option value="Cyanosis">Cyanosis</option>
											<option value="Lymphadenopathy">Lymphadenopathy</option>
											<option value="Edema">Edema</option>
									</select></td> --%>
										
										<%-- <td scope="col"><select id="ttPallor<%=incr2%>"
										name="ttPallor<%=incr2%>" class="YesNo"
										>
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td>
									<td scope="col"><select id="ttOdemia<%=incr2%>"
										name="ttOdemia<%=incr2%>" class="YesNo"
										>
											<option value="">select</option>
											<option value="Y">Yes</option>
											<option value="N">No</option>
									</select></td> --%>
										
										
									<td scope="col"><div style="float: left; width: 146px;"><input name="ttsystolic<%=incr2%>"
										id="ttsystolic<%=incr2%>" placeholder="Systolic" onblur="checkSystolicDiastolic('ttsystolic<%=incr2%>','ttdiastolic<%=incr2%>');openPopupForExamination(<%=incr2%>,'3')" onkeypress="javascript:return isNumber(event)" validate="ttsystolic<%=incr2%>,num,no"
										 type="text" style="width:41px;"
										maxlength="3" class="allownumericwithoutdecimal textSmall"  />
										<label class="smallAuto autoSpace">/</label> <input
										name="ttdiastolic<%=incr2%>" id="ttdiastolic<%=incr2%>" style="width:43px;"
										
										placeholder="Diastolic" type="text" maxlength="3" onblur="checkSystolicDiastolic('ttsystolic<%=incr2%>','ttdiastolic<%=incr2%>');openPopupForExamination(<%=incr2%>,'3')" onkeypress="javascript:return isNumber(event)" validate="ttdiastolic<%=incr2%>,num,no"
										class="allownumericwithoutdecimal textSmall" /></div></td>
										
										<td scope="col"><textarea class="autoWidthFocus" size="10"
											 name="ttPA<%=incr2%>"
											id="ttPA<%=incr2%>" maxlength="45" onblur="openPopupForExamination(<%=incr2%>,'3')" placeholder="WNL" ></textarea></td>
										
										<td scope="col"><input class="opdTextBoxTSmall" validate="ttFhs<%=incr2%>,num,no"
										 type="text"
										name="ttFhs<%=incr2%>" id="ttFhs<%=incr2%>" size="10"
										maxlength="3" style="width:28px;" onblur="openPopupForExamination(<%=incr2%>,'3')"/></td>	
										
										<td scope="col"><input class="opdTextBoxTSmall" id ="ttFh<%=incr2%>" name="ttFh<%=incr1%>" validate="ttFh<%=incr2%>,metachar,no"
										 type="text" style="width:28px;" size="30" placeholder="+"  onblur="openPopupForExamination(<%=incr2%>,'3')"/></td>									
										
									
									<%-- <td scope="col"><input type="text"  name="ttLocalExaminationTrim<%=incr2%>" id="ttLocalExaminationTrim<%=incr2%>" maxlength="240" /></td> --%>
										
									<td scope="col"><textarea class="autoWidthFocus"
											 name="ttSystemicExam<%=incr2%>" placeholder="WNL"
											id="ttSystemicExam<%=incr2%>" maxlength="240" onblur="openPopupForExamination(<%=incr2%>,'3')"></textarea></td>
									<td scope="col"><input class="opdTextBoxTSmall"
										 type="text"
										name="ttUrinAl<%=incr2%>" id="ttUrinAl<%=incr2%>" size="10" validate="ttUrinAl<%=incr2%>,num,no"
										maxlength="45" onblur="openPopupForExamination(<%=incr2%>,'3')"/></td>								
											
										<%-- <td scope="col"><input type="text"
											 name="ttObsRi<%=incr2%>"
											id="ttObsRi<%=incr2%>" maxlength="240" /></td>		 --%>
											
											
											
									<td scope="col">			
									<select name="ttObsRi<%=incr2%>"
											id="ttObsRi<%=incr2%>"  class="smallnew" onblur="openPopupForExamination(<%=incr2%>,'3')">
									<%if(risk!=null && !risk.equalsIgnoreCase("high")) {%>
											<option value="Low" selected="selected">Low</option><%} %>
										<option value="High">High</option>
										</select>
								  </td>
									
									
										
									<td scope="col"><textarea 
									 type="text"
									name="ttothersTrim<%=incr2%>" id="ttothersTrim<%=incr2%>" onblur="openPopupForExamination(<%=incr2%>,'3')"
									maxlength="300"><%=lastPrescription!=null?lastPrescription:""%></textarea> </td>
									
										
								</tr>
								<%} %>
							</table>
							<input type="hidden" name="hdb2" value="<%=incr2-1 %>" id="hdb2" />
							<input type="hidden" name="hdbTabIndex2" id="hdbTabIndex2"
								value="<%=inxRow2-1%>" />
						</div>
					</div>
				</div>
			</div>
			</div>
		
<!-- ----------------------------------Start Lab Result Third Trimester----------------------------------------- -->
<div class="clear"></div>  
<h4 style="cursor:pointer;float:left;" onclick="popwindowResultEntryForDermotologyAnc('<%=visit.getHin().getId()%>@@@<%=visit.getId()%>@@@<%=templateName%>');">External Lab Report Entry</h4>
<div class="clear"></div>
 
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Lab Result Third Trimester')" id="labResultThirdTrimesterId" name="" value="-" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Lab Result Third Trimester</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div  id="labResultThirdTrimester" >
<div class="indArrow"></div>
				<!-- changes for external lab report -->
				
				<div class="Block">
			<div class="clear"></div>			
<%if(sortedThirdTrimTestdate.size() > 0 && commonLabTestReportsThirdMap.size()>0){ %>
<label>Lab test report</label>
				<div class="tableForTab" style="width:910px">
					<div id="divTemplet2">
						<table border="0" align="center" cellpadding="0" cellspacing="0" id="OutSidelabResult">
							<tr>
								<th>Test Name</th>
								<%	int labThirdTrimIndex=0;
							for(; labThirdTrimIndex < sortedThirdTrimTestdate.size(); labThirdTrimIndex++ ){ %>
		     				<th><%=HMSUtil.convertStringDateFormat(sortedThirdTrimTestdate.get(labThirdTrimIndex)) %> </th> 
		     				<%} %>
							</tr>
							
							<%
								Iterator thirdRecords = commonLabTestReportsThirdMap.entrySet().iterator();
							    while (thirdRecords.hasNext()) {
							    Map.Entry thirdEntry = (Map.Entry) thirdRecords.next();
							    String thirdkey = (String)thirdEntry.getKey();	    
							%>		
		                   <tr>
		    <td style="width: 175px;"><input type="text" name="testN" value="<%=thirdkey%>"   readonly="readonly"  /></td>
		  
		   <%	
							    List <CommonLabTestReport> testDispList = new ArrayList<CommonLabTestReport>();
							    testDispList  = (ArrayList<CommonLabTestReport>)thirdEntry.getValue();
		                       for(int dateIndex=0; dateIndex < sortedThirdTrimTestdate.size(); dateIndex++ ){
		                    	  List<CommonLabTestReport> localList = new ArrayList<CommonLabTestReport>();
		                    	  for(CommonLabTestReport reportList : testDispList){		
									
									if(sortedThirdTrimTestdate !=null && sortedThirdTrimTestdate.get(dateIndex).equalsIgnoreCase(reportList.getResultDate())){
									localList.add(reportList);
								  }
		                    	  }
		                      
		                    	//single test start
									if (localList.size() == 1) {%>
									<%if(localList.get(0).getTestType().equalsIgnoreCase("Internal Test")) {%>
									<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getDgId()%>','<%=localList.get(0).getInvestigationId()%>');">Lab Results</a></td>
									<%} %>
										<%if(localList.get(0).getTestType().equalsIgnoreCase("External Test")){
										if(localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestResult().equals("")) {%>
										<td> <a href="javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'<%=localList.get(0).getInvestigationId()%>','<%=localList.get(0).getResultDate()%>','<%=hinId%>','<%=localList.get(0).getResultTime() %>');">Lab Results</a> </td>
										<%}else if (localList.get(0).getTestStatus()!=null && !localList.get(0).getTestStatus().equals("") && localList.get(0).getTestStatus().equalsIgnoreCase("Abnormal")){ %>
										<td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>" %> </td>
										<%} else {%>							
								 <td> <%=localList.get(0).getTestResult().replaceFirst("^0+(?!$)", "") %> </td>
									<% }	
										}}
									//single test end
									if (localList.size() ==0) {%>
										<td>-</td>	
			                    	
			                    	    
			                      <%}%> 
								<%if (localList.size() > 1) {%>
								<td>
									
								  <% String res="";String  hLink="";
								  for(CommonLabTestReport finalReport : localList){
									  String testResult="";
									  if(finalReport.getTestType().equalsIgnoreCase("External Test")){
									  if(finalReport.getTestResult()==null || finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00"))
										    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
												   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results - "+finalReport.getResultTime()+"</a>");
										      else
											    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSubParameter(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getInvestigationId()).concat("'")
											   .concat(",").concat("'").concat(finalReport.getResultDate()).concat("'").concat(",").concat("'"+hinId).concat("'").concat(",'"+finalReport.getResultTime()+"'").concat(");").concat("\"").concat(">Lab Results</a>");  
										    
										res= res.concat("\n").concat(hLink);	 
									  }	
									  if(finalReport.getTestResult()!=null && !finalReport.getTestResult().equals("")){
										  if(!finalReport.getResultTime().equals("00:00")){
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>"+"-"+finalReport.getResultTime();
											  else
												  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"-"+finalReport.getResultTime();
										  }else{
											  if(finalReport.getTestStatus().equalsIgnoreCase("Abnormal"))
											  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", "")+"<b>(Abnormal)</b>";
											  else
												  testResult= finalReport.getTestResult().replaceFirst("^0+(?!$)", ""); 
										  }
										  res = res.concat(testResult).concat(", ");
									  }
									  } // external test end here
									    // internal test starts here
									  if(finalReport.getTestType().equalsIgnoreCase("Internal Test")){
										  if(finalReport.getTestResult()==null || finalReport.getTestResult().equals("")){
											  
											    hLink = "<a href=".concat("\"").concat("javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'").concat(""+finalReport.getDgId()).concat("'")
													   .concat(",").concat("'").concat(""+finalReport.getInvestigationId()).concat("'").concat(");").concat("\"").concat(">Lab Results - "+finalReport.getResultTime()+"</a>");
											    
											res= res.concat("\n").concat(hLink);	 
										  }	
										  } // internal test end here
									} // end of for loop %>
								<%=res %>	
								</td>		
								<%}}} %>
									</tr>
		
						</table>
						
					</div>
				</div>
							
							
							<%-- <%for(CommonLabTestReport externalList:commonLabTestThirdReports) {%>
		<tr>
		    <td><input type="text" name="testDate" value="<%=externalList.getResultDate()!=null?externalList.getResultDate().replaceAll("-", "/"):"" %>"   readonly="readonly" /></td>
		    <td><input type="text" name="testN" value="<%=externalList.getTestName()!=null?externalList.getTestName():"" %>"   readonly="readonly" /></td>				
			<%if(externalList.getTestType().equalsIgnoreCase("Internal Test")){ %>
			<td><a href="javascript:openPopupForLabResultsForSpeciality(csrfTokenName+'='+csrfTokenValue,'<%=externalList.getDgId()%>','<%=externalList.getInvestigationId()%>');">Lab Results</a></td>
			<%} else { %>		
			<td> <input type="text" name="testR" value="<%=externalList.getTestResult()!=null?externalList.getTestResult():"" %>" readonly="readonly" /> </td>
			<%} %>
		</tr>
		<%} %>
						</table>
						
					</div>
				</div> --%>
				<%}else{ %>
						<span>No Test Record Found</span>
						<%} %>
				</div>
				</div>
 
<!-- ----------------------------------End Of Lab Result Third Trimester----------------------------------------- -->
<div class="clear"></div>
<jsp:include page="ancUsgThirdTrim.jsp" /> 
<div class="clear"></div>
</div>

<div id="inAncTab5" class="inAncTabcontent">
<div class="clear"></div>

		<!-- ----IP Admissions------ -->
		<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('IP Admissions')" id="ipAdmissionsDivId" name="" value="-" type="button"></div>
		<div class="plusText"><h4 class="h4Tab">IP Admissions</h4></div>			
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>	
		<div  id="ipAdmissionsDiv"  >
			<div class="indArrow"></div>
			<div class="Block" >			
				<div class="clear"></div>	
				<h4 style="text-transform:none;">Internal Admission Details</h4>
				<div class="clear"></div>
				<div class="tableForTab" style="width:910px">
						<div id="divTemplet1">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="ipTable">
								<tr>
									<th scope="col">Date of Admission</th>
									<th scope="col">IP No.</th>
									<th scope="col">Diagnosis</th>			
									<th scope="col">Management</th>
									<th scope="col">Advice</th>
									<th scope="col">Date of Discharge</th>					
								</tr>
					<%
					if(ipAdmissionList.size()>0){
					for(Inpatient inpatient:ipAdmissionList){
					
							%>
					<tr>
					<td><input type="text" id="dateOfAdmn" name="dateOfAdmn" value="<%= inpatient != null && inpatient.getDateOfAddmission() != null?HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()):""%>" readonly="readonly" class="tbInDate"> </td>
					<td><input type="text" id="ipNo" name="ipNo" value="<%=inpatient.getAdNo() !=null?inpatient.getAdNo():"" %>" readonly="readonly" class="medium" > </td>
					<td><input type="text" id="diagnosis" name="diagnosis" value="<%=diagnosis!=null?diagnosis:""%>" readonly="readonly" class="tbMediuminp"> </td>
					<td><input type="text" id="management" name="management" value="<%=management != null?management:"" %>" readonly="readonly"> </td>
					<td><input type="text" id="advice" name="advice" value="<%=advice != null?advice:"" %>" readonly="readonly"> </td>
					<td><input type="text" id="dateOfdischarge" name="dateOfdischarge" value="<%=inpatient != null && inpatient.getDischargeDate() != null?HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate()):"" %>" readonly="readonly" class="tbInDate"> </td>
					</tr>
					<%}} %>
		</table>
		</div></div>
		
<div class="clear"></div>
		
<h4 style="text-transform:none;">External Admission Details</h4>		
<div class="clear"></div>
		<div class="Block" >
		<div class="summaryDivMain-" ">
		<!-- <label>Past History Summary</label> -->
		<div style="width:902px;height:65px;margin-left:0;" class="summaryDetails"><p id="pastAdmissionDetails" ><%=ipAdmissionDetailText.toString()%></p></div>
		</div>
</div>
<div class="floatRight" style="width:122px;margin-right:125px;">
<input class="buttonDel" value="" onclick="removeRowIpAdmission();" type="button" >
<input class="buttonAdd" onclick="addRowIPadm()" value="" type="button">
</div>
		<div class="tableForTab" style="width:910px">
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="IpTable">
								<tr>
								    <th>Sl No.</th>
									<th>Date of Admission</th>
									<th>IP No.</th>
									<th>Diagnosis</th>			
									<th>Management</th>
									<th>Advice</th>
									<th>Date of Discharge</th>					
								</tr>
					<%int inc = 1; %>
					<tr>
					<td><input class="radioCheck" name="NBUVBRadio<%=inc%>" id="NBUVBRadioCheck<%=inc%>" type="checkbox"></td>
					<td>
					<input id="DateofAdmission<%=inc%>"  name="DateofAdmission<%=inc%>" class="small" value=""  readonly="readonly" type="text" style="width: 85px;" onblur="ValidateLmp(this.id)">
					<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('DateofAdmission<%=inc%>'),event);" />
					</td>
					<td><input id="IPNo<%=inc %>" name="IPNo<%=inc %>" maxlength="128" type="text" style="width: 128px;"></td>
					<td><textarea id="IPDiagnosis<%=inc %>" name="IPDiagnosis<%=inc %>" maxlength="256"></textarea></td>
					<td><textarea id="IPManagement<%=inc %>" name="IPManagement<%=inc %>" maxlength="256"></textarea></td>
					<td><textarea id="IPAdvice<%=inc %>" name="IPAdvice<%=inc %>" maxlength="256"></textarea></td>
					<td>
					<input id="DateofDischarge<%=inc %>" name="DateofDischarge<%=inc %>" class="small" value=""   validate="t1ntativeDate0,string,no" onblur="ValidateLmp(this.id);checkDischargeDate('<%=inc%>')"; readonly="readonly" type="text" style="width: 85px;">
					<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=dateC%>',document.getElementById('DateofDischarge<%=inc%>'),event);" />
					</td>
					</tr>
					<%inc++; %>				
		</table>
		<input type="hidden" name="ipAdmissionCount" id="ipAdmissionCount" value="<%=inc-1 %>" />		
		</div>
			
		</div>
		</div>
		<div class="clear"></div>
		<div class="division"></div>
		
		<!-- ----IP Admissions End------ -->
		<!-- ----Family planning------ -->
		
		<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="displayCollapsibleTab('Family Planning')" id="familyPlanningDivId" name="" value="-" type="button"></div>
		<div class="plusText"><h4 class="h4Tab">Family Planning</h4></div>			
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>	
		<div  id="familyPlanningDiv"  >
			<div class="indArrow"></div>
			<div class="Block" >			
				<div class="clear"></div>	
				<div class="tableForTab" style="width:910px">
						<div id="divTemplet1">
							<table border="0" align="center" cellpadding="0" cellspacing="0"
								id="fpTable">
								<tr>
									<th scope="col" align="center">FP Options</th>													
								</tr>
								<tr>
								<td>
								<label>OCPs</label>
								<%if(ocps.equalsIgnoreCase("YES")){ %>
								<input id="ocps" name="ocps"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="ocps" name="ocps"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>															
								<label>PPIUCD</label>
								<%if(ppiucd.equalsIgnoreCase("YES")){ %>	
								<input id="ppiucd" name="ppiucd"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="ppiucd" name="ppiucd"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>Tubal Ligation</label>
								<%if(tubalLigation.equalsIgnoreCase("YES")){ %>
								<input id="tubalLigation" name="tubalLigation"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="tubalLigation" name="tubalLigation"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>Vasectomy</label>
								<%if(vasectomy.equalsIgnoreCase("YES")){ %>
								<input id="vasectomy" name="vasectomy"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="vasectomy" name="vasectomy"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>Condom</label>
								<%if(condom.equalsIgnoreCase("YES")){ %>
								<input id="condom" name="condom"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="condom" name="condom"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>Interval IUCD</label>
								<%if(intervalIUCD.equalsIgnoreCase("YES")){ %>
								<input id="intervalIucd" name="intervalIucd"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="intervalIucd" name="intervalIucd"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>LAM</label>
								<%if(fpLam.equalsIgnoreCase("YES")){ %>
								<input id="fplam" name="fplam"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="fplam" name="fplam"  value="y" type="checkbox" class="checkboxMargin" >
								<% } %>
								<div class="clear"></div>								
								<label>None</label>
								<%if(fpNone.equalsIgnoreCase("None")){ %>
								<input id="fpnone" name="fpnone"  value="y" type="checkbox" checked="checked" class="checkboxMargin" >
								<%}else{ %>
								<input id="fpnone" name="fpnone"  value="y" type="checkbox" class="checkboxMargin"  onclick="familyPlanningValidation(this.id);" />
								<% } %>
								</td>
								<div class="clear"></div>
								</tr>
								</table>
								</div></div></div></div>
		<!-- ----Family planning End------ -->

		<div class="division"></div>


<div class="clear"></div> 
</div>

<!-- =======Inner tab end here====== -->

<div class="clear"></div>
<div class="clear"></div>
<%} %>

			
<div class="clear"></div>
	

		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>
		<input id="existAnt" name="existAnte" type="hidden" value="<%=exist%>" />
		<input id="antCardId" name="antCardId" type="hidden"
			value="<%=antCardId%>" /> <input id="pmhCount" name="pmhCount"
			type="hidden" value="0" /> <input id="ftCount" name="ftCount"
			type="hidden" value="0" /> <input id="stCount" name="stCount"
			type="hidden" value="0" /> <input id="ttCount" name="ttCount"
			type="hidden" value="0" />  <input id="AntCount" name="AntCount"
			type="hidden" value="0" /> 
		<!-- <input type="button" class="button" value="Submit"
			onclick="if(antenValid()){submitForm('antenatalCard2','opd?method=addAntenatalCard2');}"
			align="right" /> <input type="text" class="button" value="View"
			onclick="submitForm('antenatalCard2','opd?method=viewAntenatalCard2&flag=prev&viewScreen=no');" />
		<input type="button" name="Back" value="Cancel" class="button"
			onclick="setValue();" /> -->

		<!-- 	<input type="button"  value="Check" class="button"
			onclick="blankSpace();antenValid();ftTrimValid();stTrimValid();ttTrimValid();f4tTrimValid();" />   -->
		
		<div class="clear"></div>
		<div class="division"></div>
		<div class="clear"></div>


		<div class="bottom">
			<label>Changed By</label> <label class="value"><%=userName %></label>

			<label>Changed Date</label> <label class="value"><%=dateC%></label> <label>Changed
				Time</label> <label class="value"><%=time%></label>
		</div>
		<div class="clear"></div>
		<div class="paddingTop40"></div>

		<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>">
		 <input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
		 <input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
			<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
		<input type="hidden" name="bloodGroupChargeId" id="bloodGroupChargeId" value="<%=properties.getProperty("chargeCodeId")%>">
		<!--Main Div Ends-->
	<!-- </form> -->
<!-- </div> -->

 <script>
<%
int corse =0;
for (MasAdministrativeSex hmc : sexList) {
%>
var patDOB='<%=patientDob%>';
icdArray[<%=corse%>] = new Array();
icdArray[<%=corse%>][0] = <%=hmc.getId()%>;
icdArray[<%=corse%>][1] = '<%=hmc.getAdministrativeSexName()%>';	
<%corse++;}%>
</script>

<style>
h6 { color:#000 !important;
    font-size:12px!important;     
    text-transform: uppercase!important;
    padding-left:9px !important;    
    } 
.tableLeftDiv {width:578px;float:left;}
.tableRightDiv {width:578px;float:right;padding-left:4px; border-left:solid 2px #0f75bf; }
.fixedWidth900 {background:#fff;min-height:70px; max-height:160px; width:1154px;overflow-x: hidden;}
.fixedWidth900 p {text-align: justify;margin: 0;line-height: 17px;padding: 5px;}
.tbInDate {width:107px!important;}
.tbMediuminp {width:265px!important;}
</style>





