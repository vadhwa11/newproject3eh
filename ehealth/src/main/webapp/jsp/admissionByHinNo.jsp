
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * admissionByHinNo.jsp
 * Purpose of the JSP -
 * @author  Vivek
 * Create Date: 18th Nov,2008
 * Revision Date:
 * Revision By:
 * @version 1
--%>
<%@page import="jkt.hms.masters.business.DialysisSchudeling"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="jkt.hms.masters.business.MasPatientCategory"%>
<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="java.io.InputStream"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasAdmissionType"%>
<%@page import="jkt.hms.masters.business.MasBed"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasDocument"%>
<%@page import="jkt.hms.masters.business.MasRecordOfficeAddress"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasChargeType"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>


<%@page import="java.util.StringTokenizer"%>
<%@page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasOutsideTreatment"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@ page import="static jkt.hms.util.RequestConstants.BPL_STATUS"%>
<%@ page import="static jkt.hms.util.RequestConstants.APL_STATUS"%>

<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>

<%@page import="java.math.BigDecimal"%><script type="text/javascript"
	language="javascript" src="/hms/jsp/js/ajax.js"></script>
<!-- <body onload="changeAmount();"> -->

<body>

	<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
	<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
	<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
	<%--<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> --%>
	<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
	<script type="text/javascript" language="javascript"
		src="/hms/jsp/js/csrfToken.js"></script>
	<script>
<%
	List<MasUnit> unitList = new ArrayList<MasUnit>();
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

	<script type="text/javascript">
<!--

function openPopupWindow()
{
 var url="/hms/hms/adt?method=showICDSearchJsp";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}

function jsSetIcdData(icd_no)
{
document.getElementById("icdCode").value=icd_no;
document.getElementById("icdCode").focus();
}


// -->

</script>


	<%
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	int bedId = 0;
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String, Object> patientMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<OpdPatientDetails> patientList = new ArrayList<OpdPatientDetails>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<Object[]> employeeList = new ArrayList<Object[]>();
	/* List<MasDiet> dietList = new ArrayList<MasDiet>(); */
	List<MasAuthorizer>authorizerList=new ArrayList<MasAuthorizer>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
/* 	List<MasIcd> diagnosisList = new ArrayList<MasIcd>(); */
	List<MasAdmissionType> admissionTypeList = new ArrayList<MasAdmissionType>();
	/* List<MasBed> bedList = new ArrayList<MasBed>();
	List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>(); */
	List<MasChargeType>chargeTypeList=new ArrayList<MasChargeType>();
	List<MasRelation> relationList = new ArrayList<MasRelation>();
	/* List<MasDocument> documentList = new ArrayList<MasDocument>();
	List<MasOutsideTreatment> outsideTreatmentList=new ArrayList<MasOutsideTreatment>();
	List<MasRecordOfficeAddress> recordOfficeAddressList = new ArrayList<MasRecordOfficeAddress>(); */
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	/* List<MasPatientType> patientTypeList = new ArrayList<MasPatientType>(); */
	List<MasPatientCategory> patientCategoryList = new ArrayList<MasPatientCategory>();
List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
List<HospitalDoctorUnitM> hospitalUnitList=new ArrayList<HospitalDoctorUnitM>();
List<Patient> patientBabyList=new ArrayList<Patient>();
List<Patient> patientMotherList=new ArrayList<Patient>();

//added by govind 29-8-2016
 List<MasDistrict> districtList = new ArrayList<MasDistrict>();
 List<MasTaluk> talukList=new ArrayList<MasTaluk>();
 List<MasLsg> lsgNameList=new ArrayList<MasLsg>();
 List<MasWard> wardList = new ArrayList<MasWard>();
 List<PhMasLocality> localityList=new ArrayList<PhMasLocality>();
 List<MasPostCode> postCodeList = new ArrayList<MasPostCode>();
 List<PatientAddress> permenentAddList = new ArrayList<PatientAddress>();
 
 int districtIdByHospital=0; 
 String monthly_income="";
//added by govind 29-8-2016

	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	int bedStatusUnOccupiedId = Integer.parseInt(properties.getProperty("bedStatusUnOccupiedId"));
	String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");
	String serviceNameForNonEntitledId = properties.getProperty("serviceNameForNonEntitledId");
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	String chargeCodeForIpAdmission=properties.getProperty("chargeCodeForIpAdmission");
	String defaultAdmissionType=properties.getProperty("defaultAdmissionType");
	String depTypeCodeDialysis = properties.getProperty("depTypeCodeDialysis");
	
	List<MasDepartment> admittingDepartmentList = new ArrayList<MasDepartment>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	if(map.get("patientMap") != null){
		patientMap = (Map<String,Object>)map.get("patientMap");
	}
	if (patientMap.get("departmentList") != null) 
	{
		admittingDepartmentList = (List<MasDepartment>) patientMap.get("departmentList");
	}
	
	
	if(patientMap.get("patientList") != null){
		patientList = (List<OpdPatientDetails>)patientMap.get("patientList");

		session.setAttribute("patientList", patientList);
	}else if(session.getAttribute("patientList") != null){
		patientList = (List<OpdPatientDetails>)session.getAttribute("patientList");
	}
	
	if(map.get("patientBabyList") != null){
		patientBabyList = (List<Patient>)map.get("patientBabyList");
		
	}
	List<DialysisSchudeling>dialysisSchedulingList = new ArrayList<DialysisSchudeling>();
	if(map.get("dialysisSchedulingList") != null){
		dialysisSchedulingList = (List<DialysisSchudeling>)map.get("dialysisSchedulingList");
		
	}
	
	if(patientMap.get("patientTypeForSocialCategory") != null){
		patientTypeForSocialCategory = (List<MasPatientType>)patientMap.get("patientTypeForSocialCategory");
	}
	if(patientMap.get("patientTypeForOtherCategory") != null){
		patientTypeForOtherCategory = (List<MasPatientType>)patientMap.get("patientTypeForOtherCategory");
	}
	
	//This is the part test bed availability
	
	if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
	
    
	if(detailsMap.get("chargeCodeList")!=null){
		chargeCodeList=(List<MasChargeCode>)(detailsMap.get("chargeCodeList"));
	}
	
	String lastIpNo ="";
	if(detailsMap.get("lastIpNo") != null){
		lastIpNo = (String )detailsMap.get("lastIpNo");
	}
	/* if(detailsMap.get("bedList") != null){
		bedList = (List<MasBed>)detailsMap.get("bedList");
	} */
	if(detailsMap.get("authorizerList")!=null){
		authorizerList=(List<MasAuthorizer>)detailsMap.get("authorizerList");
	}
	
	//added by govind 29-8-2016
		 if(detailsMap.get("districtList") != null)
	       {
	    	   districtList = (List<MasDistrict>)detailsMap.get("districtList");
	       }
		   
		     if(detailsMap.get("localityList") != null)
	       {
	    	   localityList = (List<PhMasLocality>)detailsMap.get("localityList");
	       }
		      if(detailsMap.get("talukList") != null)
	      {
	    	  talukList =(List<MasTaluk>)detailsMap.get("talukList");
	              
	      } 
		    if(detailsMap.get("lsgNameList") != null)
	      {
	    	  lsgNameList =(List<MasLsg>)detailsMap.get("lsgNameList");
	              
	      }
		  
		    if(detailsMap.get("wardList") != null)
	      {
	    	  wardList =(List<MasWard>)detailsMap.get("wardList");
	              
	      }
		  
		    if(detailsMap.get("localityList") != null)
	       {
	    	   localityList = (List<PhMasLocality>)detailsMap.get("localityList");
	       }
		    if(detailsMap.get("postCodeList") != null)
		       {
		    	postCodeList = (List<MasPostCode>)detailsMap.get("postCodeList");
		       }
			    
		    if(detailsMap.get("permenentAddList") != null)
		       {
		    	permenentAddList = (List<PatientAddress>)detailsMap.get("permenentAddList");
		    	System.out.println(" goivnd jsp permenentAddList "+permenentAddList.size());
		       }
		    
		    int  disticId=0,talukId=0,lsgId=0,wardId=0,localId=0,postOffice=0;
		    String lsgHousNo="",healthHouseId="",pinCode="",colonyHouseNo="";
		    int perAddId=0;
		    if(permenentAddList.size()>0){
		    	for(PatientAddress p:permenentAddList){
		    		
		    		if(p.getDistrict()!=null){
		    		disticId=p.getDistrict().getId();
		    		}
		    		if(p.getTaluk()!=null){
		    		talukId=p.getTaluk().getId();
		    		}
		    		if(p.getLsgName()!=null){
		    		lsgId=p.getLsgName().getId();
		    		}
		    		if(p.getWardNo()!=null){
		    		wardId=p.getWardNo().getId();
		    		}
		    		if(p.getLocality()!=null){
		    		localId=p.getLocality().getId();
		    		}
		    		if(p.getPinCode()!=null ){
		    		pinCode=p.getPinCode().toString();
		    		}
		    		if(p.getPostOffice()!=null){
		    		postOffice=p.getPostOffice().getId();
		    		}
		    		if(p.getLsgHouseNo()!=null){
		    		lsgHousNo=p.getLsgHouseNo().toString();
		    		}
		    		if(p.getHealthHouseId()!=null ){
		    		healthHouseId=p.getHealthHouseId().toString();  
		    		}
		    		if(p.getId()!=null){
		    			perAddId=p.getId();  
			    	}
		    	}
		    }
		    
			//added by govind 29-8-2016 end
	/* List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
	if(detailsMap.get("complaintList") != null){
		complaintList = (List<MasComplaint>)detailsMap.get("complaintList");
	} */
	/* for (Iterator iterator = bedList.iterator(); iterator.hasNext();) {
		MasBed masBed = (MasBed) iterator.next();
		if(masBed.getBedStatus().getId() == bedStatusUnOccupiedId){
			bedId = masBed.getId();
	  }
	} */
	
	//added by dhananjay
	 List<Patient> ipPatientList=new ArrayList<Patient>();
	if(detailsMap.get("ipPatientList") != null){
		ipPatientList= (List<Patient>)detailsMap.get("ipPatientList");
	}
	
	//end
	
	if(patientList.size() > 0){
		OpdPatientDetails patient = patientList.get(0);
		String age = "";
		//int ageForDiet = 0;
		int currentAge = 0;
		int patientCategoryId=0;
		if(patient.getVisit().getHin().getPatientType()!=null){
			patientCategoryId =patient.getVisit().getHin().getPatientType().getId();
		}
		if(patient.getVisit().getHin().getDateOfBirth()!=null){
			currentAge = HMSUtil.getCurrentAgeByDoB(patient.getVisit().getHin().getDateOfBirth());
		}
		age=""+currentAge;
		if(null !=patient.getVisit().getHin().getMonthlyIncome())
		monthly_income=String.valueOf(patient.getVisit().getHin().getMonthlyIncome()) ;
		
		//ageForDiet = Integer.parseInt(""+HMSUtil.calculateAgeForADT2(age, patient.getRegDate())) ;

		//List<MasRank> rankList = new ArrayList<MasRank>();
		//if(detailsMap.get("rankList") != null){
		//rankList= (List<MasRank>)detailsMap.get("rankList");
		//}
		if(detailsMap.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)detailsMap.get("maritalStatusList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("hospitalUnitList") != null){
			hospitalUnitList = (List<HospitalDoctorUnitM>)detailsMap.get("hospitalUnitList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<Object[]>)detailsMap.get("employeeList");
		}
		/* if(detailsMap.get("dietList") != null){
			dietList = (List<MasDiet>)detailsMap.get("dietList");
		} */
		if(detailsMap.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)detailsMap.get("bloodGroupList");
		}

		/* if(detailsMap.get("diagnosisList") != null){
			diagnosisList = (List<MasIcd>)detailsMap.get("diagnosisList");
		} */
		if(detailsMap.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)detailsMap.get("admissionTypeList");
		}

		/* if(detailsMap.get("caseTypeList") != null){
			caseTypeList = (List<MasCaseType>)detailsMap.get("caseTypeList");
		} */
		if(detailsMap.get("relationList") != null){
			relationList = (List<MasRelation>)detailsMap.get("relationList");
		}
		/* if(detailsMap.get("documentList") != null){
			documentList = (List<MasDocument>)detailsMap.get("documentList");
		} */
		/* if(detailsMap.get("recordOfficeAddressList") != null){
			recordOfficeAddressList = (List<MasRecordOfficeAddress>)detailsMap.get("recordOfficeAddressList");
		} */
		/* if(detailsMap.get("unitList") != null){
			unitList = (List<MasUnit>)detailsMap.get("unitList");
		} */
		
		if(detailsMap.get("patientCategoryList") != null){
			patientCategoryList = (List<MasPatientCategory>)detailsMap.get("patientCategoryList");
		}


%>
	<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<script type="text/javascript">


function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)
	/*
	if(document.getElementById('nokNameId').value == "")
		errorMessage=errorMessage+"Please Fill Relative name \n";
	if(document.getElementById('relId').value == 0)
		errorMessage=errorMessage+"Please Select Relation \n";
	if(document.getElementById('nokAddr').value == "")
		errorMessage=errorMessage+"Please Fill Address \n";
		if(document.getElementById('serviceTypeId').value !=7){
			if(document.getElementById('unitId').value == "0")
			errorMessage=errorMessage+"Please Select Unit \n";
		}

	if(document.getElementById('admType').value == "0")
		errorMessage=errorMessage+"Please Select  Admited Type \n";

	*/
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}


}
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId');
		obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
  
  
function chechFoAttachAdmission(){
	submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation');
}


function checkDiet(age,currentTime){

age=parseInt(age)
if(age<1){
}

}

function getOldAdNo(){
if(document.getElementById('old').checked == true){
		document.getElementById('oldAdNoId').disabled = false;
		document.getElementById('imgId').style.display = 'inline';
		document.getElementById('admTime').disabled=false


	}else{
		document.getElementById('oldAdNoId').disabled = true;
		document.getElementById('imgId').style.display = 'none';
		document.getElementById('admTime').disabled=true
	}
}
</script>

	<script type="text/javascript">
			function displayUnit(deptId){
				  var hospitalId='<%=session.getAttribute("hospitalId")%>';

				  var xmlHttp=null;
				  try {
				    // Firefox, Opera 8.0+, Safari
				    xmlHttp=new XMLHttpRequest();
				  }catch (e){
				    // Internet Explorer
				    try{
				      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
				    }catch (e){
				    	alert(e)
				      try{
				        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				      }catch (e){
				        alert("Your browser does not support AJAX!");
				        return false;
				      }
				     }
				   }
				  obj = document.getElementById("unit");
				  obj.length=1;
				  
				  
					/*obj.options[0].value=0;
					obj.options[0].text="select";*/
				    xmlHttp.onreadystatechange=function()
				    {
				      if(xmlHttp.readyState==4){

				      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
				      	//alert("items"+items)
				      
						
				      	for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					        var unitId  = item.getElementsByTagName("unitId")[0];
					        var unitCode  = item.getElementsByTagName("unitCode")[0];
					        
					       
					        
					        if(unitId.childNodes[0] !=undefined){
					        obj.length++;
							obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
							obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;
					        }
					        
							//document.getElementById("unit").selectedIndex = unitId.childNodes[0].nodeValue


				      	}
				      }
				    }
				     var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+deptId;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
				    xmlHttp.open("GET",url,false);
				    xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(null);
				 				
				<%-- var lUnit = document.getElementById('localUnit');
				var unit1 = document.registration.<%=UNIT_ID %>;

				if(lUnit.checked == false){
					unit1.length = 1;
					<%
					 for(MasUnit unit : unitList){
					%>
					unit1.length++;
					unit1.options[unit1.length-1].value=<%=unit.getId()%>;
					unit1.options[unit1.length-1].text='<%=unit.getUnitName()%>';

				<%}%>
				}else{
					unit1.length = 1;
					<%
					 for(MasUnit unit : unitList){
						 if(unit.getLocalUnit() != null){
						 if(unit.getLocalUnit().equals("y")){
					%>
					unit1.length++;
					unit1.options[unit1.length-1].value=<%=unit.getId()%>;
					unit1.options[unit1.length-1].text='<%=unit.getUnitName()%>';
					<%}
						 }
					}%>
				}
				unit1.length++;
				unit1.options[unit1.length-1].value='Other';
				unit1.options[unit1.length-1].text='Other'; --%>
			}

		</script>


	<form name="admissionByHin" method="post" id="onFocusForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="hidden"
			name="<%=HIN_ID%>" value="<%=patient.getVisit().getHin().getId() %>" />
		<input type="hidden" name="opdpatientdetail"
			value="<%=patient.getId()%>" />

		<!-- Added by Amit Das on 23-02-2016 -->
		<input type="hidden" name="<%=VISIT_ID%>"
			value="<%=patient.getVisit().getId() %>" />

		<div class="titleBg">
			<h2>Patient Admission</h2>
		</div>

		<div class="Block">
			<%-- <input type="hidden" name="patTypeId" id="patTypeId" value="<%=patTyprId %>"/> --%>

			<div class="clear"></div>
			<h4>Patient Details</h4>
			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<div class="clear"></div>

			<label><%=prop.getProperty("com.jkt.hms.uhid") %></label> <label
				class="value"><%=patient.getVisit().getHin().getHinNo() %></label>
			<%
	if(patient.getVisit().getHin().getSex() != null){
	%>

			<%
		String patientName = patient.getVisit().getHin().getPFirstName();
		if(patient.getVisit().getHin().getPMiddleName() != null){
			patientName = patient.getVisit().getHin().getPMiddleName();
		}
		if(patient.getVisit().getHin().getPLastName() != null){
			patientName = patient.getVisit().getHin().getPLastName();
		}
		if(null !=patient.getVisit().getHin().getMonthlyIncome())
			monthly_income=String.valueOf(patient.getVisit().getHin().getMonthlyIncome()) ;
		
		
		String address = "";
		if(patient.getVisit().getHin().getPatientAddress()!=null){
			address = patient.getVisit().getHin().getPatientAddress();
			address = address.replace("\n", "").replace("\r", "");
			address = address.replaceAll("\'","");
			address = address.replaceAll("^\"|\"$", "");
			
		}
		%>

			<label>Patient Name</label> <label class="value"><%=patientName%></label>
			<input type="hidden" name="<%=PATIENT_NAME %>"
				value="<%= patientName%>" /> <label>Address</label> <label
				class="value"></label>
			<div class="clear"></div>
			<label>Gender</label> <label class="value"><%= patient.getVisit().getHin().getSex()!=null?patient.getVisit().getHin().getSex().getAdministrativeSexName():"" %></label>
			<%} %>

			<input type="hidden" id="patientTypeId" name="patientTypeId"
				value="<%=patient.getVisit().getHin().getPatientType()!=null?patient.getVisit().getHin().getPatientType().getId():"" %>" />

			<input type="hidden" name="patienthinId"
				value="<%=patient.getVisit().getHin().getId() %>" /> <input
				type="hidden" name="<%=GENDER %>" id="<%=GENDER %>"
				value="<%=patient.getVisit().getHin().getSex()!=null?patient.getVisit().getHin().getSex().getId():"" %>" />

			<label>Marital Status</label>
			<%if(patient.getVisit().getHin().getMaritalStatus() !=null){%>
			<label class="value"><%=patient.getVisit().getHin().getMaritalStatus().getMaritalStatusName() %></label>
			<%}
else
{
%>
			<label class="value">-</label>

			<%
}%>


			<%-- <select name="<%=MARITAL_STATUS_ID %>" validate="Marital Status,string,no" tabindex="1"  >
        <option value="0">Select</option>
	<%
			 for(MasMaritalStatus masMaritalStatus : maritalStatusList){
				 if(patient.getVisit().getHin().getMaritalStatus() !=null){
			if(patient.getVisit().getHin().getMaritalStatus().getId() == masMaritalStatus.getId()){
			%>
        <option value="<%=masMaritalStatus.getId()%>" selected="selected"><%=masMaritalStatus.getMaritalStatusName()%></option>
        <%}else{ %>
        <option value="<%=masMaritalStatus.getId()%>" ><%=masMaritalStatus.getMaritalStatusName()%></option>
        <%}}else{%>
			<option value="<%=masMaritalStatus.getId()%>" ><%=masMaritalStatus.getMaritalStatusName()%></option>

				 <% }}%>
</select> --%>

			<input type="hidden" id="sexId" name="<%=SEX_ID %>"
				value="<%= patient.getVisit().getHin().getSex()!=null?patient.getVisit().getHin().getSex().getId():""%>" />



			<label>Age</label> <label class="value"><%=currentAge%></label>


			<div class="clear"></div>

			<label>Patient Category</label> <label class="value"> <%if(patient.getVisit().getHin().getPatientCategory()!=null){ %>
				<input type="hidden"
				value="<%=patient.getVisit().getHin().getPatientCategory().getId() %>" />
				<%=patient.getVisit().getHin().getPatientCategory().getPatientCategoryName() %>
				<%}else
                    	 {%> - <%} %>

			</label> <label>Department</label> <label class="value"> <%=patient.getVisit().getDepartment()!=null ? patient.getVisit().getDepartment().getDepartmentName():"" %>
				<!-- Added by Amit Das on 23-02-2016 --> <input type="hidden"
				name="ward"
				value="<%=patient.getVisit().getDepartment()!=null ? patient.getVisit().getDepartment().getId():"" %>" />

			</label> <label>Unit</label>
			<%
String unit = "";
if(patient.getVisit().getUnit()!=null){
	unit = patient.getVisit().getUnit().getUnitCode();
}
%>
			<label class="value"><%=unit %></label>
			<div class="clear"></div>
			<label> Referring Doctor</label>
			<%
String refferedDoctor="-";
if(patient.getEmployee()!=null)
{
refferedDoctor=patient.getEmployee().getFirstName();
if(patient.getEmployee().getMiddleName()!=null)
{
	refferedDoctor +=" "+patient.getEmployee().getMiddleName();
}
if(patient.getEmployee().getLastName()!=null)
{
	refferedDoctor +=" "+ patient.getEmployee().getLastName();
}
}
String str="";
%>
			<label class="value"><%=refferedDoctor%></label> <input type="hidden"
				name="<%=REFERED_BY %>"
				value="<%=patient.getEmployee()!=null?patient.getEmployee().getId():str%>" />

			<label Family Income Status>Family Income Status<span>*</span></label>
			<%if(patient.getBillStatus()!=null && patient.getBillStatus().equalsIgnoreCase("y")){ %>
			<label class="mediumAuto">BPL <input type="radio"
				class="radioCheckCol2" tabindex="2" checked="checked"
				name="<%=BPL_STATUS %>" value="bpl" /></label> <label class="mediumAuto">APL<input
				type="radio" class="radioCheckCol2" tabindex="2"
				name="<%=BPL_STATUS %>" value="apl" /></label>

			<%}else if(patient.getBillStatus()!=null && patient.getBillStatus().equalsIgnoreCase("n")){ %>
			<label class="mediumAuto">BPL <input type="radio"
				class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
				value="bpl" /></label> <label class="mediumAuto">APL<input
				type="radio" class="radioCheckCol2" tabindex="2" checked="checked"
				name="<%=BPL_STATUS %>" value="apl" /></label>
			<%} else { %>
			<label class="mediumAuto">BPL <input type="radio"
				class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
				value="bpl" /></label> <label class="mediumAuto">APL<input
				type="radio" class="radioCheckCol2" tabindex="2"
				name="<%=BPL_STATUS %>" value="apl" /></label>
			<%} %>
			<!-- Added Scheme By Amit Das on 23-02-2016 -->

			<label style="margin-right: 5px;">Scheme</label>
			<div id="schemeDiv">
				<select name="schemeList" id="schemeList" validate="Scheme,int,no"
					style="width: 151px !important;">
					<option value="0">Select</option>
				</select>
			</div>

			<!-- Ended Scheme By Amit Das on 23-02-2016 -->

			<div class="clear"></div>
			<label>Social<span>*</span>
			</label> <select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>" tabindex="1"
				validate="Social,int,yes" style="width: 170px; margin-right: 1px;">
				<option value="0">Select</option>
				<%for(MasPatientType masPatientType : patientTypeForSocialCategory)
			       {%>
				<%if(patientCategoryId==masPatientType.getId()){ %>
				<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
				<%}else{ %>
				<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
				<%} %>
				<%}%>
			</select> <label>Other Category</label> <select id="otherCategoryId"
				tabindex="2" multiple="multiple" class="multiple" size="5"
				style="width: 167px" name="<%=OTHER_CATEGORY%>">
				<option value="0">select</option>
				<%
				if(null != patientTypeForOtherCategory){
				for(MasPatientType otherCategory : patientTypeForOtherCategory)
			       {%>
				<%if(patientCategoryId==otherCategory.getId()){ %>
				<option value="<%=otherCategory.getId()%>" selected="selected"><%=otherCategory.getPatientTypeName()%></option>
				<%}else{ %>
				<option value="<%=otherCategory.getId()%>"><%=otherCategory.getPatientTypeName()%></option>
				<%} %>
				<%}
				}
				%>
			</select> <label>Monthly Income</label> <input type=""
				value="<%=monthly_income %>" name="monthlyIncome" tabindex="1"
				validate="Monthly Income,float,no" />




			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<h4>Admission Details</h4>
			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<div class="clear"></div>

			<label> Admission Type</label> <select
				name="<%=ADMISSION_TYPE_ID %>" tabindex="1"
				validate="Admission Type,int,no">
				<%
for(MasAdmissionType admissionType:admissionTypeList)
{
%>
				<option value="<%=admissionType.getId()%>"><%=admissionType.getAdmissionTypeName()%></option>
				<%
}
%>
			</select> <label>Admission Date & Time</label> <img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" id="imgId"
				onclick="javascript:setdate('<%=currentDate %>',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />
			<input class="dateTextSmall" type="text"
				name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>"
				readonly="readonly" validate="Date Of Admission,date,yes" MAXLENGTH="30"
				id="admDate" onchange="populateListDateTime();"
				onclick="populateListDateTime();" /> <input class="textSmall"
				style="width: 79px;" type="text" name="<%=TIME_OF_ADMISSION %>"
				value="<%=currentTime %>" validate="Adm. Time,timeFormat,yes"
				id="admTime"
				onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

			<!-- Added by Arbind on 04-03-2017 -->
			<label>Admitting Department</label> <select id="deptId"
				name="admittingDoctorDept" tabindex="1"
				onchange="populateUnitForDepartment(this.value)"
				validate="Service Center,int,no">
				<option value="0">Select</option>
				<%for(MasDepartment masDepartment : admittingDepartmentList){
	if(patient.getVisit().getDepartment().getId() == masDepartment.getId()) {%>
				<option selected="selected" value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<%} else {%>
				<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
				<% }
}%>
			</select>

			<div class="clear"></div>
			<label> Unit</label> <select name="hospitalUnitId"
				validate="Unit,int,no" id="unit" tabindex="2"
				onchange="displayUnitHeadeName(this.value);">
				<option value="">Select</option>
				<%
	    if(hospitalUnitList.size()>0){
			for (HospitalDoctorUnitM  hospitalUnit : hospitalUnitList){
				
					
		%>
				<option value="<%=hospitalUnit.getId ()%>"><%=hospitalUnit.getUnitCode()%></option>
				<%}} %>
			</select> <label>Unit Head </label> <input name="headName" id="headName" validate="Unit Head,metacharDot,no"
				value="" /> <label>Admitting doctor <span>*</span></label> <select
				name="<%=CONSULTING_DOCTOR %>" id=""
				validate="Admitting doctor,int,yes" tabindex="1">
				<option value="0">Select</option>
				<% String doctorMiddleName = "";
	String doctorLastName = "";
		for (Object[]  obj : employeeList){
				
			
				if(obj[2]!= null){
					doctorMiddleName = (String)obj[2];
				}
				if(obj[3]!= null){
					doctorLastName = (String)obj[3];
				}
	
		if(obj[0]==patient.getEmployee().getId()){
	%>
				<option selected="selected" value="<%=obj[0]%>"><%=obj[1]+" "+doctorMiddleName+" "+doctorLastName%></option>
				<%  }else{
	%>
				<option value="<%=obj[0]%>"><%=obj[1]+" "+doctorMiddleName+" "+doctorLastName%></option>


				<%}
		 %>


				<%} %>
			</select>

			<div class="clear"></div>

			<label> Ward <span>*</span></label> <select
				name="<%=DEPARTMENT_ID %>" validate="Ward,int,yes" id="wardId"
				tabindex="1">
				<!-- onchange="displayUnit(this.value);" -->

				<option value="0">Select</option>
				<%
			for (MasDepartment  masDepartment : departmentList){
				if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
					if(patient.getAdmissionWard()!=null && masDepartment.getId()==patient.getAdmissionWard().getId())
					{
		%>
				<option selected="selected" value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
				<%} else { %>
				<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
				<%}}
		}%>
			</select> <label>Remarks</label>
			<textarea rows="4" name="<%=REMARKS%>" tabindex="2"
				validate="Remarks,metachar,no" maxlength="250" value=""
				class="textareaMediua"></textarea>
			<% if(patient.getPayWardCheckedStatus()!=null && patient.getPayWardCheckedStatus().equalsIgnoreCase("Y")) { %>
			<label>Payward Status</label> <label class="value">Yes</label>
			<% } %>
			<label>Critical Condition <input type="checkbox"
				style="margin-top: 3px" name="<%=CONDITION %>" id="<%=CONDITION %>"
				class="radioCheckCol2" /></label>

			<%if(patient.getMlcType() != null){
		if(patient.getMlcType().equalsIgnoreCase("y")){
		%>
			<label style="width: 183px; margin-left: 2px;">MLC <input
				type="checkbox" style="margin-top: 3px" name="<%=MLC%>"
				id="<%=MLC%>" checked="checked" class="radioCheckCol2" /></label>
			<%}else{ %>
			<label style="width: 183px; margin-left: 2px;">MLC <input
				type="checkbox" style="margin-top: 3px" name="<%=MLC%>"
				id="<%=MLC%>" class="radioCheckCol2" /></label>
			<%}}else{ %>
			<label style="width: 183px; margin-left: 2px;">MLC <input
				type="checkbox" style="margin-top: 3px" name="<%=MLC%>"
				id="<%=MLC%>" class="radioCheckCol2" /></label>
			<%} %>
			<%if(currentAge<=1){ %>
			<label>New Born Baby <input type="checkbox"
				style="margin-top: 3px" name="newBornBaby" id="newBornBabyId"
				onclick="getMotherUHID()" maxlength="25" class="radioCheckCol2" /></label>
			<%} %>
			<div id="motherUHID" style="display: none;">
				<label>Mother UHID</label> <input type="text" id="motherUHIDId"
					name="motherUHID" tabindex="2" validate="Mother UHID,metachar,no"
					onblur="checkMotherExistence(this.value)" class="textbox_size20"
					maxlength="50" />

			</div>
			<div class="clear"></div>
			<label>Cash Received</label> <input type="checkbox" tabindex="1"
				checked="checked" name="cashreceived" id="cashreceived" value="y"
				onclick="cashNotReceived()" style="margin: 0px 5px;" />
			<div id="cashNotReceived" style="display: none;">
				<label>Reason</label> <select id="cashReason" name="cashReason"
					style="margin-left: 3px; width: 162px;" tabindex="1">
					<option value="">Select</option>
					<option value="Accident">Accident</option>
					<option value="Medico Legal">Medico Legal</option>
					<option value="Staff">Staff</option>
					<option value="Foreigner">Foreigner</option>
					<option value="UnKnown Patient">UnKnown Patient</option>
					<option value="Below 18 Years">Below 18 Years</option>
				</select>
			</div>

			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<h4>Bystander/ Attendant</h4>
			<div class="clear"></div>
			<div class="paddingTop15"></div>
			<div class="clear"></div>
			<div id="next_of_kin_detail">

				<label>UHID</label> <input type="text" name="<%=NEXT_OF_KIN_UHID %>"
					id="<%=NEXT_OF_KIN_UHID %>" onkeypress="searchDependent1(event)"
					onblur="searchDependent();" validate="UHID,metachar,no" /> <label>Name</label>
				<input id="nokNameId" type="text" name="<%=RELATIVE_NAME %>"
					value="" validate="Dependent Name,metacharDot,no" maxlength="30"
					tabindex="1" /> <label>Relation</label> <select
					name="<%=RELATION_ID%>" id="relId" validate=" Relation,int,no"
					tabindex="1">
					<option value="">Select</option>
					<%
      for(MasRelation relation:relationList)
      {
   	   %>
					<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
					<%
      }
      %>
				</select>
				<div class="clear"></div>
				<label>Contact No. </label> <input type="text" name="<%=MOBILE %>"
					id="mobileNo" value="" validate="Cobtact Number,phone,no"
					MAXLENGTH="10" tabindex="1" />

				</textarea>
				<label>Address</label>
				<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
					class="textareaMediua" tabindex="1" 
					onpaste="return checkOnPaste(this)"
					oninput="return checkMaxLengthMoz(this)"
					onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)">
</textarea>
				<!-- add by govind 29-8-2016 -->
				<div class="clear"></div>
				<h4>Address</h4>
				<div id="permanentAddDiv" class="">
					<input type="hidden" name="perAddId" value="<%=perAddId%>"
						id="permAddr" tabindex="21" /> <label>District</label><select
						name="permanentDistrict" id="pcityId" tabindex=""
						validate="District,int,no"
						onChange="permanentsubDistrictByDistrictId(this.value),populatePPincodeByDistrict(this.value),lsgByDistrict('plsgNameId',this.value)">
						<option value="">Select</option>
						<%			
		for(MasDistrict masDistrict : districtList)
		{
			%>
						<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
						<%}
				
%>
					</select>
					<script>
	<%
	if(disticId!=0){
	%>
	document.getElementById('pcityId').value = '<%=disticId%>';
	<%}else if(districtIdByHospital!=0){%>
	document.getElementById('pcityId').value = '<%=districtIdByHospital%>';
	<%}%>
	</script>

					<label>Taluk</label><select name="<%=P_TALUK%>" id="talukId"
						tabindex="22" onchange="" validate="Taluk,int,no">

						<option value="">Select</option>
						<% 	for(MasTaluk masTaluk:talukList){ %>

						<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
						<%}
				%>
					</select>


					<script>
	<%
	if(talukId!=0){
	%>
	document.getElementById('talukId').value = '<%=talukId%>';
	<%}%>
	</script>


					<label>LSG Name</label><select name="<%=P_LSG_NAME %>"
						id="plsgNameId"
						onchange="populatePPWardByLsg('pWardId',this.value);"
						tabindex="23">

						<option value=" ">Select</option>
						<% for(MasLsg masLsg:lsgNameList){ %>
						<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

						<%	}
				
			
				%>

					</select>
					<script>
	<%
	if(lsgId!=0){
	%>
	document.getElementById('plsgNameId').value = '<%=lsgId%>';
	<%}%>
	</script>
					<div class="clear"></div>
					<label>Ward</label> <select name="<%=P_WARD %>" id="pWardId"
						tabindex="24" id="wardId"
						onchange="populatePPLocalityByWardLsg('pWardId','plsgNameId','locality');">
						<option value="">Select</option>
						<%
				for(MasWard masWard:wardList){ 
						%>
						<option value="<%=masWard.getId() %>"><%=masWard.getWardName() %></option>
						<%}
				%>
					</select>

					<script>
	<%
	if(wardId!=0){
	%>
	document.getElementById('pWardId').value = '<%=wardId%>';
	<%}%>
	</script>
					<label>Locality</label><select name="<%=P_LOCALITY %>"
						id="locality" tabindex="25" validate="Locality,int,no">

						<option value="">Select</option>
						<% for(PhMasLocality locality:localityList ){ %>
						<option value="<%=locality.getId()%>"><%=locality.getLocalityName() %></option>

						<%
				}
		
				%>
					</select>

					<script>
	<%
	if(localId!=0){
	%>
	document.getElementById('locality').value = '<%=localId%>';
	<%}%>
	</script>

					<label>LSG House No.</label><input type="text"
						name="<%=P_LSG_HOUSE_NO %>" id="<%=P_LSG_HOUSE_NO %>" value=""
						validate="LSG House No,metacharSlash,no" maxlength="32" tabindex="26"
						value="<%=lsgHousNo %>" />
					<div class="clear"></div>
					<label>Colony House No.</label><input type="text"
						name="<%=P_HOUSE_NO %>" value=""
						validate="Colony House No,metacharSlash,no" maxlength="32" tabindex="27"
						id="PhouseId" onblur="" value="<%=colonyHouseNo %>" /> <label>Post
						Office</label> <select name="<%=P_POST_OFFICE %>" id="pppostOff"
						onchange="populatePinCodeForPost(this.value);" validate="Post Office,int,no"
						tabindex="28">

						<option value="">Select</option>

						<% for (MasPostCode masPostOff:postCodeList ){ %>
						<option value="<%=masPostOff.getId()%>"><%=masPostOff.getPostCodeName() %></option>
						<% 
				}
				
			%>

					</select>

					<script>
	<%
	if(postOffice!=0){
	%>
	document.getElementById('pppostOff').value = '<%=postOffice%>';
	<%}%>
	</script>
					<label>Pin Code</label><input type="text" id="ppincode"
						name="<%=P_PINCODE%>" tabindex="29" validate="Pin Code,int,no"
						MAXLENGTH="6" readonly="readonly" value="<%=pinCode %>" />
					<div class="clear"></div>
					<label>Health House Id</label><input type="text" id="healthHouseId"
						name="<%=P_HEALTH_HOUSE_ID%>" value="" tabindex="30" validate="Health House Id,int,no"
						MAXLENGTH="32" value="<%=healthHouseId %>" />
				</div>
				<!-- add by govind 29-8-2016 -->

			</div>
			<div class="clear"></div>


			<input type="hidden" id="hinNo" name="<%=HIN_NO %>"
				value="<%=patient.getVisit().getHin().getHinNo() %>"> <input
				type="hidden" id="hinId" name="<%=HIN_ID %>"
				value="<%=patient.getVisit().getHin().getId() %>"> <input
				type="hidden" name="<%=AGE %>" value="<%=age %>"> <input
				type="hidden" name="<%=SERVICE_TYPE_CODE %>" value=""> <input
				type="hidden" name="<%=SERVICE_TYPE_ID %>" value=""
				id="serviceTypeId"> <input type="hidden" name="<%=BED_ID %>"
				value="" id="bedId">

			<div class="clear"></div>

			<!-- start of billing  -->

			<h4><%=prop.getProperty("com.jkt.hms.bill_heading") %></h4>



			<label>Charge</label> <select name="registrationType"
				id="registrationType" tabindex="46" onfocus="" >
				<option>select</option>
			</select> <label>Waive Charge <input type="checkbox"
				class="radioCheckCol2" style="margin-top: 3px" />
			</label> <label style="width: 177px;">Authorized By</label> <select
				name="registrationType" id="registrationType" tabindex="46"
				onfocus="" >
				<option>select</option>
			</select>
			<div class="clear"></div>
			<label>Bill No.</label> <input type="text" validate="Bill No,metachar,no"/> <label>Amount
				Chargeable</label> <input type="text" validate="Amount Chargeable,float,no" />

			<div class="clear"></div>

			<label>Available Credit Balance</label> <input type="text" validate="Available Credit Balance,float,no"/> <input
				type="checkbox" class="radioCheckCol2" style="margin-top: 3px" /> <label
				class="auto" style="padding: 0px 12px 0px 5px;">Adjust
				Against Credit</label> <input type="text" /> <label>Balance To Be
				Paid</label> <input type="text" validate="Balance To Be Paid,float,no"/> <label>Amount Actually paid</label> <input
				type="text" validate="Amount Actually paid,float,no"/> <label>Amount Tendered</label> <input type="text" validate="Amount Tendered,float,no"/>


			<label>Revised Credit Balance</label> <input type="text" validate="Revised Credit Balance,float,no"/>
			<div class="clear"></div>


			<%-- end of billing  --%>

			<div id="edited"></div>
			<div class="clear"></div>

			<div class="clear"></div>
			<div class="paddingTop40"></div>

			<input type="button" name="Submit11" value="Save" class="button"
				onClick="if(checkDepartment()){chechFoAttachAdmission()};"
				id="saveId" tabindex="1" /> <input type="hidden" name="attached"
				value="Attached" class="button" />
			<%-- 	    <input type="button" name="<%=MLC %>" value="MLC" class="button" onClick="if(checkForNok()){submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation&mlcFlag=1&flag=ipMlc','validateFRW');}" />
 --%>
			<input type="reset" name="Reset" value="Reset" class="button"
				accesskey="r" tabindex="1" />
			<%--	<div class="clear"></div> --%>
			<% } 
	
		else if(null !=ipPatientList && ipPatientList.size()>0){
		Patient ppatient = ipPatientList.get(0);
		String age = "";
		//int ageForDiet = 0;
		int currentAge = 0;
		int patientCategoryId=0;
		if(ppatient.getPatientType()!=null){
			patientCategoryId =ppatient.getPatientType().getId();
		}
		if(ppatient.getDateOfBirth()!=null){
			currentAge = HMSUtil.getCurrentAgeByDoB(ppatient.getDateOfBirth());
		}
		age=""+currentAge;
		
	
		if(detailsMap.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)detailsMap.get("maritalStatusList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("hospitalUnitList") != null){
			hospitalUnitList = (List<HospitalDoctorUnitM>)detailsMap.get("hospitalUnitList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<Object[]>)detailsMap.get("employeeList");
		}
	
		if(detailsMap.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)detailsMap.get("bloodGroupList");
		}

		
		if(detailsMap.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)detailsMap.get("admissionTypeList");
		}

		
		if(detailsMap.get("relationList") != null){
			relationList = (List<MasRelation>)detailsMap.get("relationList");
		}
		
		
		if(detailsMap.get("patientCategoryList") != null){
			patientCategoryList = (List<MasPatientCategory>)detailsMap.get("patientCategoryList");
		}

		String address = "";
		if(ppatient.getPatientAddress()!=null){
			address = ppatient.getPatientAddress();
			address = address.replace("\n", "").replace("\r", "");
			address = address.replaceAll("\'","");
			address = address.replaceAll("^\"|\"$", "");
			
		}
	
%>
			<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
			<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
			<script type="text/javascript">


function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)

	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}


}
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId');
		obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
  
  
function chechFoAttachAdmission(){
	submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation');
}


function checkDiet(age,currentTime){

age=parseInt(age)
if(age<1){
}

}

function getOldAdNo(){
if(document.getElementById('old').checked == true){
		document.getElementById('oldAdNoId').disabled = false;
		document.getElementById('imgId').style.display = 'inline';
		document.getElementById('admTime').disabled=false


	}else{
		document.getElementById('oldAdNoId').disabled = true;
		document.getElementById('imgId').style.display = 'none';
		document.getElementById('admTime').disabled=true
	}
}
</script>

			<script type="text/javascript">
			function displayUnit(deptId){
				  var hospitalId='<%=session.getAttribute("hospitalId")%>';

				  var xmlHttp=null;
				  try {
				    // Firefox, Opera 8.0+, Safari
				    xmlHttp=new XMLHttpRequest();
				  }catch (e){
				    // Internet Explorer
				    try{
				      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
				    }catch (e){
				    	alert(e)
				      try{
				        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				      }catch (e){
				        alert("Your browser does not support AJAX!");
				        return false;
				      }
				     }
				   }
				  obj = document.getElementById("unit");
				  obj.length=1;
				  
				  
					/*obj.options[0].value=0;
					obj.options[0].text="select";*/
				    xmlHttp.onreadystatechange=function()
				    {
				      if(xmlHttp.readyState==4){

				      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
				      	//alert("items"+items)
				      
						
				      	for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					        var unitId  = item.getElementsByTagName("unitId")[0];
					        var unitCode  = item.getElementsByTagName("unitCode")[0];
					        
					       
					        
					        if(unitId.childNodes[0] !=undefined){
					        obj.length++;
							obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
							obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;
					        }
					        
							//document.getElementById("unit").selectedIndex = unitId.childNodes[0].nodeValue


				      	}
				      }
				    }
				     var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+deptId;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
				    xmlHttp.open("GET",url,false);
				    xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(null);
				 				
				
			}

		</script>


			<form name="admissionByHin" method="post" id="onFocusForm">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}"> <input type="hidden"
					name="<%=HIN_ID%>" value="<%=ppatient.getId() %>" /> <input
					type="hidden" name="opdpatientdetail" value="" />

				<!-- Added by Amit Das on 23-02-2016 -->
				<input type="hidden" name="<%=VISIT_ID%>"
					value="<%=ppatient.getId() %>" />

				<div class="titleBg">
					<h2>Patient Admission</h2>
				</div>

				<div class="Block">
					<%-- <input type="hidden" name="patTypeId" id="patTypeId" value="<%=patTyprId %>"/> --%>

					<div class="clear"></div>
					<h4>Patient Details</h4>
					<div class="clear"></div>
					<div class="paddingTop15"></div>
					<div class="clear"></div>

					<label><%=prop.getProperty("com.jkt.hms.uhid") %></label> <label
						class="value"><%=ppatient.getHinNo() %></label>
					<%
	if(ppatient.getSex() != null){
	%>

					<%
		String patientName = ppatient.getPFirstName();
		if(ppatient.getPMiddleName() != null){
			patientName = ppatient.getPMiddleName();
		}
		if(ppatient.getPLastName() != null){
			patientName = ppatient.getPLastName();
		}
		if(null !=ppatient.getMonthlyIncome())
			monthly_income=String.valueOf(ppatient.getMonthlyIncome()) ;
		%>

					<label>Patient Name</label> <label class="value"><%=patientName%></label>
					<input type="hidden" name="<%=PATIENT_NAME %>"
						value="<%= patientName%>" /> <label>Address</label> <label
						class="value"> </label>
					<div class="clear"></div>
					<label>Gender</label> <label class="value"><%= ppatient.getSex()!=null?ppatient.getSex().getAdministrativeSexName():"" %></label>
					<%} %>

					<input type="hidden" id="patientTypeId" name="patientTypeId"
						value="<%=ppatient.getPatientType()!=null?ppatient.getPatientType().getId():"" %>" />



					<input type="hidden" name="<%=GENDER %>" id="<%=GENDER %>"
						value="<%=ppatient.getSex()!=null?ppatient.getSex().getId():"" %>" />

					<label>Marital Status</label>
					<%if(ppatient.getMaritalStatus() !=null){%>
					<label class="value"><%=ppatient.getMaritalStatus().getMaritalStatusName() %></label>
					<%}
else
{
%>
					<label class="value">-</label>

					<%
}%>



					<input type="hidden" id="sexId" name="<%=SEX_ID %>"
						value="<%= ppatient.getSex()!=null?ppatient.getSex().getId():""%>" />



					<label>Age</label> <label class="value"><%=currentAge%></label>



					<div class="clear"></div>

					<label>Patient Category</label> <label class="value"> <%if(ppatient.getPatientCategory()!=null){ %>
						<input type="hidden"
						value="<%=ppatient.getPatientCategory().getId() %>" /> <%=ppatient.getPatientCategory().getPatientCategoryName() %>
						<%}else
                    	 {%> - <%} %>

					</label> <label>Department</label> <label class="value"> <%-- <%=patient.getReferedDepartment()!=null ? patient.getReferedDepartment().getDepartmentName():"" %> --%>

						<!-- Added by Amit Das on 23-02-2016 --> <input type="hidden"
						name="ward" value="" />

					</label> <label>Unit</label> <label class="value">-</label>
					<div class="clear"></div>
					<label> Referring Doctor</label>
					<%
String refferedDoctor="-";


String str="";
%>
					<label class="value"><%=refferedDoctor%></label> <input
						type="hidden" name="<%=REFERED_BY %>" value="" /> <label Family
						Income Status>Family Income Status<span>*</span></label>
					<%if(ppatient.getBplStatus()!=null && ppatient.getBplStatus().equalsIgnoreCase("y")){ %>
					<label class="mediumAuto">BPL <input type="radio"
						disabled="disabled" class="radioCheckCol2" tabindex="2"
						checked="checked" name="<%=BPL_STATUS %>" value="bpl" /></label> <label
						class="mediumAuto">APL<input type="radio"
						disabled="disabled" class="radioCheckCol2" tabindex="2"
						name="<%=BPL_STATUS %>" value="apl" /></label>

					<%}else if(ppatient.getBplStatus()!=null && ppatient.getBplStatus().equalsIgnoreCase("n")){ %>
					<label class="mediumAuto">BPL <input type="radio"
						disabled="disabled" class="radioCheckCol2" tabindex="2"
						name="<%=BPL_STATUS %>" value="bpl" /></label> <label class="mediumAuto">APL<input
						type="radio" disabled="disabled" class="radioCheckCol2"
						tabindex="2" checked="checked" name="<%=BPL_STATUS %>" value="apl" /></label>
					<%} else { %>
					<label class="mediumAuto">BPL <input type="radio"
						class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
						value="bpl" /></label> <label class="mediumAuto">APL<input
						type="radio" class="radioCheckCol2" tabindex="2"
						name="<%=BPL_STATUS %>" value="apl" /></label>
					<%} %>
					<!-- Added Scheme By Amit Das on 23-02-2016 -->

					<label style="margin-right: 5px;">Scheme</label>
					<div id="schemeDiv">
						<select name="schemeList" id="schemeList" validate="Scheme,int,no"
							style="width: 151px !important;">
							<option value="0">Select</option>
						</select>
					</div>

					<!-- Ended Scheme By Amit Das on 23-02-2016 -->

					<div class="clear"></div>
					<label>Social<span>*</span>
					</label>
					<%if(patientCategoryId!=0){ %>
					<select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
						tabindex="1" disabled="disabled" validate="Social,int,yes"
						style="width: 170px; margin-right: 1px;">
						<option value="0">Select</option>
						<%for(MasPatientType masPatientType : patientTypeForSocialCategory)
			       {%>
						<%if(patientCategoryId==masPatientType.getId()){ %>
						<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
						<%}else{ %>
						<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
						<%} %>
						<%}%>
					</select>
					<%}else{ %>
					<select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
						tabindex="1" validate="Social,int,yes"
						style="width: 170px; margin-right: 1px;">
						<option value="0">Select</option>
						<%for(MasPatientType masPatientType : patientTypeForSocialCategory)
			       {%>
						<%if(patientCategoryId==masPatientType.getId()){ %>
						<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
						<%}else{ %>
						<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
						<%} %>
						<%}%>
					</select>
					<%} %>
					<label>Other Category</label>
					<%if(patientCategoryId!=0){ %>
					<select id="otherCategoryId" disabled="disabled" tabindex="2"
						multiple="multiple" class="multiple" size="5" style="width: 167px"
						name="<%=OTHER_CATEGORY%>">
						<option value="0">select</option>
						<%
				if(null != patientTypeForOtherCategory){
				for(MasPatientType otherCategory : patientTypeForOtherCategory)
			       {%>
						<%if(patientCategoryId==otherCategory.getId()){ %>
						<option value="<%=otherCategory.getId()%>" selected="selected"><%=otherCategory.getPatientTypeName()%></option>
						<%}else{ %>
						<option value="<%=otherCategory.getId()%>"><%=otherCategory.getPatientTypeName()%></option>
						<%} %>
						<%}
				}
				%>
					</select>
					<%}else{ %>
					<select id="otherCategoryId" tabindex="2" multiple="multiple"
						class="multiple" size="5" style="width: 167px"
						name="<%=OTHER_CATEGORY%>">
						<option value="0">select</option>
						<%
				if(null != patientTypeForOtherCategory){
				for(MasPatientType otherCategory : patientTypeForOtherCategory)
			       {%>
						<%if(patientCategoryId==otherCategory.getId()){ %>
						<option value="<%=otherCategory.getId()%>" selected="selected"><%=otherCategory.getPatientTypeName()%></option>
						<%}else{ %>
						<option value="<%=otherCategory.getId()%>"><%=otherCategory.getPatientTypeName()%></option>
						<%} %>
						<%}
				}
				%>
					</select>
					<%} %>
					<label>Monthly Income</label> <input type=""
						value="<%=monthly_income %>" name="monthlyIncome"
						readonly="readonly" tabindex="1"
						validate="Monthly Income,float,no" />



					<div class="clear"></div>
					<div class="paddingTop15"></div>
					<h4>Admission Details</h4>
					<div class="clear"></div>
					<div class="paddingTop15"></div>
					<div class="clear"></div>

					<label> Admission Type</label> <select
						name="<%=ADMISSION_TYPE_ID %>" tabindex="1"
						validate="Admission Type,int,no">
						<%
for(MasAdmissionType admissionType:admissionTypeList)
{
%>
						<option value="<%=admissionType.getId()%>"><%=admissionType.getAdmissionTypeName()%></option>
						<%
}
%>
					</select> <label>Admission Date & Time</label> <img
						src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
						validate="Pick a date" id="imgId"
						onclick="javascript:setdate('<%=currentDate %>',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />
					<input class="dateTextSmall" type="text"
						name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>"
						readonly="readonly" validate="Adm. Date,date,yes" MAXLENGTH="30"
						id="admDate" onchange="populateListDateTime();"
						onclick="populateListDateTime();" /> <input class="textSmall"
						style="width: 79px;" type="text" name="<%=TIME_OF_ADMISSION %>"
						value="<%=currentTime %>" validate="Adm. Time,timeFormat,yes"
						id="admTime"
						onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

					<label>Admitting Department</label> <select id="deptId"
						name="admittingDoctorDept" tabindex="1"
						onchange="populateUnitForDepartment(this.value)"
						validate="Service Center,int,no">
						<option value="0">Select</option>
						<%for(MasDepartment masDepartment : admittingDepartmentList){%>
						<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
						<%}%>
					</select>
					<div class="clear"></div>
					<label> Unit</label> <select name="hospitalUnitId"
						validate="Unit,int,no" id="unit" tabindex="2"
						onchange="displayUnitHeadeName(this.value);">
						<option value="">Select</option>
						<%
	    if(hospitalUnitList.size()>0){
			for (HospitalDoctorUnitM  hospitalUnit : hospitalUnitList){
				
					
		%>
						<option value="<%=hospitalUnit.getId ()%>"><%=hospitalUnit.getUnitCode()%></option>
						<%}} %>
					</select> <label>Unit Head </label> <input name="headName" id="headName"
						value="" validate="Unit Head,metacharDot,no"/> <label>Admitting doctor</label> <select
						name="<%=CONSULTING_DOCTOR %>" id="loddrs"
						validate="Admitting doctor,int,yes" tabindex="1">
						<option value="0">Select</option>
						<% 
	String doctorMiddleName = "";
	String doctorLastName = "";
	if(employeeList.size()>0){
		for (Object[]  obj : employeeList){
			
				if(obj[2]!= null){
					doctorMiddleName = (String)obj[2];
				}
				if(obj[3]!= null){
					doctorLastName = (String)obj[3];
				}
		%>
						<option value="<%=obj[0]%>"><%=obj[1]+" "+doctorMiddleName+" "+doctorLastName%></option>
						<%}} %>
					</select>

					<div class="clear"></div>
					<label> Ward <span>*</span></label> <select
						name="<%=DEPARTMENT_ID %>" validate="Ward,int,yes" id="wardId"
						tabindex="1">
						<!-- onchange="displayUnit(this.value);" -->


						<option value="0">Select</option>
						<%
			for (MasDepartment  masDepartment : departmentList){
				if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
					
		%>

						<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
						<%}
		}%>
					</select> <label>Remarks</label>
					<textarea rows="4" name="<%=REMARKS%>" tabindex="2"
						validate="Remarks,metachar,no" maxlength="250" value=""
						class="textareaMediua"></textarea>

					<label>Critical Condition <input type="checkbox"
						style="margin-top: 3px" name="<%=CONDITION %>"
						id="<%=CONDITION %>" class="radioCheckCol2" /></label>


					<%if(currentAge<=1){ %>
					<label>New Born Baby <input type="checkbox"
						style="margin-top: 3px" name="newBornBaby" id="newBornBabyId"
						onclick="getMotherUHID()" maxlength="25" class="radioCheckCol2" /></label>
					<%} %>
					<div id="motherUHID" style="display: none;">
						<label>Mother UHID</label> <input type="text" id="motherUHIDId"
							name="motherUHID" tabindex="2" validate="Mother UHID,metachar,no"
							onblur="checkMotherExistence(this.value)" class="textbox_size20"
							maxlength="50" />

					</div>
					<div class="clear"></div>
					<label>Cash Received</label> <input type="checkbox" tabindex="1"
						checked="checked" validate="Cash Received,String,no"
						name="cashreceived" id="cashreceived" value="y"
						onclick="cashNotReceived()" style="margin: 0px 5px;" />
					<div id="cashNotReceived" style="display: none;">
						<label>Reason</label> <select id="cashReason" name="cashReason"
							style="margin-left: 3px; width: 162px;" tabindex="1">
							<option value="">Select</option>
							<option value="Accident">Accident</option>
							<option value="Medico Legal">Medico Legal</option>
							<option value="Staff">Staff</option>
							<option value="Foreigner">Foreigner</option>
							<option value="UnKnown Patient">UnKnown Patient</option>
							<option value="Below 18 Years">Below 18 Years</option>
						</select>
					</div>

					<div class="clear"></div>
					<div class="paddingTop15"></div>
					<h4>Bystander/ Attendant</h4>
					<div class="clear"></div>
					<div class="paddingTop15"></div>
					<div class="clear"></div>
					<div id="next_of_kin_detail">

						<label>UHID</label> <input type="text"
							name="<%=NEXT_OF_KIN_UHID %>" id="<%=NEXT_OF_KIN_UHID %>"
							onkeypress="searchDependent1(event)" onblur="searchDependent();"
							validate="UHID,metachar,no" /> <label>Name</label> <input
							id="nokNameId" type="text" name="<%=RELATIVE_NAME %>" value=""
							validate="Dependent Name,metacharDot,no" maxlength="30"
							tabindex="1" /> <label>Relation</label> <select
							name="<%=RELATION_ID%>" id="relId" validate=" Relation,int,no"
							tabindex="1">
							<option value="">Select</option>
							<%
      for(MasRelation relation:relationList)
      {
   	   %>
							<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
							<%
      }
      %>
						</select>
						<div class="clear"></div>
						<label>Contact No. </label> <input type="text" name="<%=MOBILE %>"
							id="mobileNo" value="" validate="Cobtact Number,phone,no"
							MAXLENGTH="10" tabindex="1" />

						</textarea>
						<label>Address</label>
						<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
							class="textareaMediua" tabindex="1"
							maxlength="128" onpaste="return checkOnPaste(this)"
							oninput="return checkMaxLengthMoz(this)"
							onKeyDown="return checkMaxLength(this)"
							onKeyUp="finalCheck(this)">
</textarea>
						<!-- add by govind 29-8-2016 -->
						<div class="clear"></div>
						<h4>Address</h4>
						<div id="permanentAddDiv" class="">
							<input type="hidden" name="perAddId" value="<%=perAddId%>"
								id="permAddr" tabindex="1" /> <label>District</label><select
								name="permanentDistrict" id="pcityId" tabindex=""
								validate="District,int,no"
								onChange="permanentsubDistrictByDistrictId(this.value),populatePPincodeByDistrict(this.value),
				lsgByDistrict('plsgNameId',this.value)">
								<option value="">Select</option>
								<%	
		for(MasDistrict masDistrict : districtList)
		{
			%>
								<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
								<%}
				
%>
							</select>

							<script>
	<%
	if(disticId!=0){
	%>
	document.getElementById('pcityId').value = '<%=disticId%>';
	<%}else if(districtIdByHospital!=0){%>
	document.getElementById('pcityId').value = '<%=districtIdByHospital%>';
	<%}%>
	</script>

							<label>Taluk</label><select name="<%=P_TALUK%>" id="talukId"
								tabindex="22" validate="Taluk,int,no">

								<option value="">Select</option>
								<% 	for(MasTaluk masTaluk:talukList){ %>

								<option value="<%=masTaluk.getId()%>"><%=masTaluk.getTalukName() %></option>
								<%}
				%>
							</select>


							<script>
	<%
	if(talukId!=0){
	%>
	document.getElementById('talukId').value = '<%=talukId%>';
	<%}%>
	</script>


							<label>LSG Name</label><select name="<%=P_LSG_NAME %>"
								id="plsgNameId"
								onchange="populatePPWardByLsg('pWardId',this.value);"
								tabindex="23" validate="LSG Name,int,no">

								<option value=" ">Select</option>
								<% for(MasLsg masLsg:lsgNameList){ %>
								<option value="<%=masLsg.getId()%>"><%=masLsg.getLsgTypeName() %></option>

								<%	}
							
				%>

							</select>


							<script>
	<%
	if(lsgId!=0){
	%>
	document.getElementById('plsgNameId').value = '<%=lsgId%>';
	<%}%>
	</script>


							<div class="clear"></div>
							<label>Ward</label> <select name="<%=P_WARD %>" id="pWardId"
								tabindex="24" id="wardId" validate="ward,int,no"
								onchange="populatePPLocalityByWardLsg('pWardId','plsgNameId','locality');">
								<option value="">Select</option>
								<%
				for(MasWard masWard:wardList){ 
							%>
								<option value="<%=masWard.getId() %>"><%=masWard.getWardName() %></option>
								<%
				}
				%>
							</select>
							<script>
	<%
	if(wardId!=0){
	%>
	document.getElementById('pWardId').value = '<%=wardId%>';
	<%}%>
	</script>


							<label>Locality</label><select name="<%=P_LOCALITY %>"
								id="locality" tabindex="25" validate="Locality,int,no">

								<option value="">Select</option>
								<% for(PhMasLocality locality:localityList ){ %>
								<option value="<%=locality.getId()%>"><%=locality.getLocalityName() %></option>

								<%
				}
		
				%>
							</select>

							<script>
	<%
	if(localId!=0){
	%>
	document.getElementById('locality').value = '<%=localId%>';
	<%}%>
	</script>

							<label>LSG House No.</label><input type="text"
								name="<%=P_LSG_HOUSE_NO %>" id="<%=P_LSG_HOUSE_NO %>" value=""
								validate="LSG House No,metacharSlash,no" maxlength="32" tabindex="26"
								value="<%=lsgHousNo %>" />
							<div class="clear"></div>
							<label>Colony House No.</label><input type="text"
								name="<%=P_HOUSE_NO %>" value=""
								validate="Colony House No,metacharSlash,no" maxlength="32"
								tabindex="27" id="PhouseId" onblur=""
								value="<%=colonyHouseNo %>" /> <label>Post Office</label> <select
								name="<%=P_POST_OFFICE %>" id="pppostOff"
								onchange="populatePinCodeForPost(this.value);"
								validate="Post Office,int,no">

								<option value="">Select</option>

								<% for (MasPostCode masPostOff:postCodeList ){ %>
								<option value="<%=masPostOff.getId()%>"><%=masPostOff.getPostCodeName() %></option>
								<% 
				}
				
			%>

							</select>
							<script>
	<%
	if(postOffice!=0){
	%>
	document.getElementById('pppostOff').value = '<%=postOffice%>';
	<%}%>
	</script>

							<label>Pin Code</label><input type="text" id="ppincode"
								name="<%=P_PINCODE%>" tabindex="29" validate="Pin Code,int,no"
								MAXLENGTH="6" readonly="readonly" value="<%=pinCode %>" />
							<div class="clear"></div>
							<label>Health House Id</label><input type="text"
								id="healthHouseId" name="<%=P_HEALTH_HOUSE_ID%>" value=""
								tabindex="30" validate="Health House Id,int,no" MAXLENGTH="32"
								value="<%=healthHouseId %>" />
						</div>
						<!-- add by govind 29-8-2016 -->

					</div>
					<div class="clear"></div>


					<input type="hidden" id="hinNo" name="<%=HIN_NO %>"
						value="<%=ppatient.getHinNo() %>"> <input type="hidden"
						id="hinId" name="<%=HIN_ID %>" value="<%=ppatient.getId() %>">
					<input type="hidden" name="<%=AGE %>" value="<%=age %>"> <input
						type="hidden" name="<%=SERVICE_TYPE_CODE %>" value=""> <input
						type="hidden" name="<%=SERVICE_TYPE_ID %>" value=""
						id="serviceTypeId"> <input type="hidden"
						name="<%=BED_ID %>" value="" id="bedId">

					<div class="clear"></div>

					<!-- start of billing  -->

					<h4><%=prop.getProperty("com.jkt.hms.bill_heading") %></h4>



					<label>Charge</label> <select name="registrationType"
						id="registrationType" tabindex="46" onfocus=""  >
						<option>select</option>
					</select> <label>Waive Charge <input type="checkbox"
						class="radioCheckCol2" style="margin-top: 3px" />
					</label> <label style="width: 177px;">Authorized By</label> <select
						name="registrationType" id="registrationType" tabindex="46"
						onfocus="" >
						<option>select</option>
					</select>
					<div class="clear"></div>
					<label>Bill No.</label> <input type="text" validate="Bill No,metachar,no" /> <label>Amount
						Chargeable</label> <input type="text" validate="Amount Chargeable,float,no" />

					<div class="clear"></div>

					<label>Available Credit Balance</label> <input type="text" validate="Available Credit Balance,float,no"/> <input
						type="checkbox" class="radioCheckCol2" style="margin-top: 3px" />

					<label class="auto" style="padding: 0px 12px 0px 5px;">Adjust
						Against Credit</label> <input type="text" /> <label>Balance To Be
						Paid</label> <input type="text" validate="Balance To Be Paid,float,no"/> <label>Amount Actually paid</label> <input
						type="text" validate="Amount Actually paid,float,no"/> <label>Amount Tendered</label> <input type="text" validate="Amount Tendered,float,no"/>


					<label>Revised Credit Balance</label> <input type="text" validate="Revised Credit Balance,float,no"/>
					<div class="clear"></div>


					<%-- end of billing  --%>

					<div id="edited"></div>
					<div class="clear"></div>

					<div class="clear"></div>
					<div class="paddingTop40"></div>

					<input type="button" name="Submit11" value="Save" class="button"
						onClick="if(checkDepartment()){chechFoAttachAdmission()};"
						id="saveId" tabindex="1" /> <input type="hidden" name="attached"
						value="Attached" class="button" /> <input type="reset"
						name="Reset" value="Reset" class="button" accesskey="r"
						tabindex="1" />

					<% }

	else if(patientBabyList.size() > 0){
		Patient patient = patientBabyList.get(0);
		
		
		if(detailsMap.get("patientMotherList") != null){
			patientMotherList = (List<Patient>)detailsMap.get("patientMotherList");
		}
		
		Patient patientMother = patientMotherList.get(0);
		
		String age = "";
		
		int currentAge = 0;
		int patientCategoryId=0;
		if(patient.getPatientType()!=null){
			patientCategoryId =patient.getPatientType().getId();
		}
		if(patient.getDateOfBirth()!=null){
			currentAge = HMSUtil.getCurrentAgeByDoB(patient.getDateOfBirth());
		}
		age=""+currentAge;
	
		if(detailsMap.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)detailsMap.get("maritalStatusList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("hospitalUnitList") != null){
			hospitalUnitList = (List<HospitalDoctorUnitM>)detailsMap.get("hospitalUnitList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<Object[]>)detailsMap.get("employeeList");
		}
	
		if(detailsMap.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)detailsMap.get("bloodGroupList");
		}

		if(detailsMap.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)detailsMap.get("admissionTypeList");
		}

		if(detailsMap.get("relationList") != null){
			relationList = (List<MasRelation>)detailsMap.get("relationList");
		}
	
		
		if(detailsMap.get("patientCategoryList") != null){
			patientCategoryList = (List<MasPatientCategory>)detailsMap.get("patientCategoryList");
		}


%>
					<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
					<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
					<script type="text/javascript">


function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}


}
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId');
		obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
function chechFoAttachAdmission(){
	submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation');
}
function checkDiet(age,currentTime){

age=parseInt(age)
if(age<1){
}

}

function getOldAdNo(){
if(document.getElementById('old').checked == true){
		document.getElementById('oldAdNoId').disabled = false;
		document.getElementById('imgId').style.display = 'inline';
		document.getElementById('admTime').disabled=false


	}else{
		document.getElementById('oldAdNoId').disabled = true;
		document.getElementById('imgId').style.display = 'none';
		document.getElementById('admTime').disabled=true
	}
}
</script>

					<script type="text/javascript">
			function displayUnit(deptId){
				  var hospitalId='<%=session.getAttribute("hospitalId")%>';

				  var xmlHttp=null;
				  try {
				    // Firefox, Opera 8.0+, Safari
				    xmlHttp=new XMLHttpRequest();
				  }catch (e){
				    // Internet Explorer
				    try{
				      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
				    }catch (e){
				    	alert(e)
				      try{
				        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				      }catch (e){
				        alert("Your browser does not support AJAX!");
				        return false;
				      }
				     }
				   }
				  obj = document.getElementById("unit");
				  obj.length=1;
				  
				  
					/*obj.options[0].value=0;
					obj.options[0].text="select";*/
				    xmlHttp.onreadystatechange=function()
				    {
				      if(xmlHttp.readyState==4){

				      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
				      	//alert("items"+items)
				      
						
				      	for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					        var unitId  = item.getElementsByTagName("unitId")[0];
					        var unitCode  = item.getElementsByTagName("unitCode")[0];
					        
					       
					        
					        if(unitId.childNodes[0] !=undefined){
					        obj.length++;
							obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
							obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;
					        }
					        
							//document.getElementById("unit").selectedIndex = unitId.childNodes[0].nodeValue


				      	}
				      }
				    }
				     var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+deptId;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
				    xmlHttp.open("GET",url,false);
				    xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(null);
				 				
			
			}

		</script>


					<form name="admissionByHin" method="post" id="onFocusForm">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}"> <input type="hidden"
							name="<%=HIN_ID%>" value="<%=patient.getId() %>" /> <input
							type="hidden" name="opdpatientdetail" value="0" />
						<div class="titleBg">
							<h2>Patient Admission</h2>
						</div>

						<div class="Block">
							<%-- <input type="hidden" name="patTypeId" id="patTypeId" value="<%=patTyprId %>"/> --%>

							<div class="clear"></div>
							<h4>Patient Details</h4>
							<div class="clear"></div>
							<div class="paddingTop15"></div>
							<div class="clear"></div>

							<label><%=prop.getProperty("com.jkt.hms.uhid") %></label> <label
								class="value"><%=patient.getHinNo() %></label>
							<%
	if(patient.getSex() != null){
	%>

							<%
		String patientName = patient.getPFirstName();
		if(patient.getPMiddleName() != null){
			patientName = patient.getPMiddleName();
		}
		if(patient.getPLastName() != null){
			patientName = patient.getPLastName();
		}

		%>

							<label>Patient Name</label> <label class="value"><%=patientName%></label>
							<input type="hidden" name="<%=PATIENT_NAME %>"
								value="<%= patient.getPFirstName()%>" /> <label>Address</label>
							<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
								class="textareaMediua" tabindex="19"
								onpaste="return checkOnPaste(this)"
								oninput="return checkMaxLengthMoz(this)"
								onKeyDown="return checkMaxLength(this)"
								onKeyUp="finalCheck(this)">
</textarea>

							<div class="clear"></div>
							<label>Gender</label> <label class="value"><%= patient.getSex()!=null?patient.getSex().getAdministrativeSexName():"" %></label>
							<%} %>

							<input type="hidden" id="patientTypeId" name="patientTypeId"
								value="<%=patientMother.getPatientType()!=null?patient.getPatientType().getId():"" %>" />



							<input type="hidden" name="<%=GENDER %>" id="<%=GENDER %>"
								value="<%=patient.getSex()!=null?patient.getSex().getId():"" %>" />

							<label>Marital Status</label>
							<%if(patientMother.getMaritalStatus() !=null){%>
							<label class="value"><%=patientMother.getMaritalStatus().getMaritalStatusName() %></label>
							<%}
else
{
%>
							<label class="value">-</label>

							<%
}%>


							<input type="hidden" id="sexId" name="<%=SEX_ID %>"
								value="<%= patient.getSex()!=null?patient.getSex().getId():""%>" />



							<label>Age</label> <label class="value"><%=currentAge%></label>


							<div class="clear"></div>

							<label>Patient Category</label> <label class="value"> <%if(patientMother.getPatientCategory()!=null){ %>
								<input type="hidden"
								value="<%=patientMother.getPatientCategory().getId() %>" /> <%=patientMother.getPatientCategory().getPatientCategoryName() %>
								<%}else
                    	 {%> - <%} %>

							</label> <label>Department</label> <label class="value">-</label> <label>Unit</label>
							<label class="value">-</label>
							<div class="clear"></div>
							<label> Referring Doctor</label> <label class="value">-</label> <label
								style="margin-right: 1px;">Family Income Status<span>*</span></label>
							<%if(patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("y")){ %>
							<label class="mediumAuto">BPL <input type="radio"
								class="radioCheckCol2" tabindex="2" checked="checked"
								name="<%=BPL_STATUS %>" value="bpl" /></label> <label
								class="mediumAuto">APL<input type="radio"
								class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
								value="apl" /></label>

							<%}else if(patient.getBplStatus()!=null && patient.getBplStatus().equalsIgnoreCase("n")){ %>
							<label class="mediumAuto">BPL <input type="radio"
								class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
								value="bpl" /></label> <label class="mediumAuto">APL<input
								type="radio" class="radioCheckCol2" tabindex="2"
								checked="checked" name="<%=BPL_STATUS %>" value="apl" /></label>
							<%} else { %>
							<label class="mediumAuto">BPL <input type="radio"
								class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
								value="bpl" /></label> <label class="mediumAuto">APL<input
								type="radio" class="radioCheckCol2" tabindex="2"
								name="<%=BPL_STATUS %>" value="apl" /></label>
							<%} %>


							<div class="clear"></div>
							<label>Social<span>*</span>
							</label> <select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
								tabindex="1" validate="Social,int,yes"
								style="width: 170px; margin-right: 1px;">
								<option value="0">Select</option>
								<%for(MasPatientType masPatientType : patientTypeForSocialCategory)
			       {%>
								<%if(patientCategoryId==masPatientType.getId()){ %>
								<option value="<%=masPatientType.getId()%>" selected="selected"><%=masPatientType.getPatientTypeName()%></option>
								<%}else{ %>
								<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
								<%} %>
								<%}%>
							</select> <label>Other Category</label> <select id="otherCategoryId"
								tabindex="2" multiple="multiple" class="multiple" size="5"
								style="width: 167px" name="<%=OTHER_CATEGORY%>">
								<option value="0">select</option>
								<%
				if(null != patientTypeForOtherCategory){
				for(MasPatientType otherCategory : patientTypeForOtherCategory)
			       {%>
								<%if(patientCategoryId==otherCategory.getId()){ %>
								<option value="<%=otherCategory.getId()%>" selected="selected"><%=otherCategory.getPatientTypeName()%></option>
								<%}else{ %>
								<option value="<%=otherCategory.getId()%>"><%=otherCategory.getPatientTypeName()%></option>
								<%} %>
								<%}
				}
				%>
							</select>

							<div class="clear"></div>
							<div class="paddingTop15"></div>
							<h4>Admission Details</h4>
							<div class="clear"></div>
							<div class="paddingTop15"></div>
							<div class="clear"></div>

							<label> Admission Type</label> <select
								name="<%=ADMISSION_TYPE_ID %>" tabindex="1"
								validate="Admission Type,int,no">
								<%
for(MasAdmissionType admissionType:admissionTypeList)
{
%>
								<option value="<%=admissionType.getId()%>"><%=admissionType.getAdmissionTypeName()%></option>
								<%
}
%>
							</select> <label>Admission Date & Time</label> <img
								src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
								validate="Pick a date" id="imgId"
								onclick="javascript:setdate('<%=currentDate %>',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />
							<input class="dateTextSmall" type="text"
								name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>"
								readonly="readonly" validate="Adm. Date,date,yes"
								MAXLENGTH="30" id="admDate" onchange="populateListDateTime();"
								onclick="populateListDateTime();" /> <input class="textSmall"
								style="width: 79px;" type="text" name="<%=TIME_OF_ADMISSION %>"
								value="<%=currentTime %>" validate="Adm. Time,timeFormat,yes"
								id="admTime"
								onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

							<label>Admitting doctor</label> <select
								name="<%=CONSULTING_DOCTOR %>"
								validate="Admitting doctor,int,yes" tabindex="1">
								<option value="0">Select</option>
								<% 
	String doctorMiddleName="";
	String doctorLastName= "";
		for (Object[]  obj : employeeList){
			if(obj[2]!= null){
				doctorMiddleName = (String)obj[2];
			}
			if(obj[3]!= null){
				doctorLastName = (String)obj[3];
			}
	%>
								<option value="<%=obj[0]%>"><%=obj[1]%>+" "+<%=doctorMiddleName %>+"
									"+<%=doctorLastName %></option>





								<%} %>
							</select>

							<div class="clear"></div>
							<label> Ward <span>*</span></label> <select
								name="<%=DEPARTMENT_ID %>" validate="Ward,int,yes" id="wardId"
								tabindex="1">
								<!-- onchange="displayUnit(this.value);" -->
								<option value="0">Select</option>
								<%
			for (MasDepartment  masDepartment : departmentList){%>

								<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
								<%}
		%>
							</select> <label> Unit</label> <select name="hospitalUnitId"
								validate="Unit,int,no" id="unit" tabindex="2"
								onchange="displayUnitHeadeName(this.value);">
								<option value="">Select</option>
								<%
	    if(hospitalUnitList.size()>0){
			for (HospitalDoctorUnitM  hospitalUnit : hospitalUnitList){
				
					
		%>
								<option value="<%=hospitalUnit.getId ()%>"><%=hospitalUnit.getUnitCode()%></option>
								<%}} %>
							</select> <label>Unit Head </label> <input name="headName" id="headName"
								value="" validate="Unit Head,metacharDot,no"/> <label>Remarks</label>
							<textarea rows="4" name="<%=REMARKS%>" tabindex="2"
								validate="Remarks,metachar,no" maxlength="250" value=""
								class="textareaMediua"></textarea>

							<label>Critical Condition <input type="checkbox"
								style="margin-top: 3px" name="<%=CONDITION %>"
								id="<%=CONDITION %>" class="radioCheckCol2" /></label> <label
								style="width: 183px; margin-left: 2px;">MLC <input
								type="checkbox" style="margin-top: 3px" name="<%=MLC%>"
								id="<%=MLC%>" class="radioCheckCol2" /></label>
							<%if(currentAge<=1){ %>
							<label>New Born Baby <input type="checkbox"
								name="newBornBaby" id="newBornBabyId" onclick="getMotherUHID()"
								maxlength="25" class="radioCheckCol2" /></label>
							<%} %>
							<div id="motherUHID" style="display: none;">
								<label>Mother UHID</label> <input type="text" id="motherUHIDId"
									name="motherUHID" tabindex="2"
									validate="Mother UHID,metachar,no"
									onblur="checkMotherExistence(this.value)"
									value="<%=patientMother.getHinNo()%>" class="textbox_size20"
									maxlength="50" />

							</div>
							<div class="clear"></div>
							<label>Cash Received</label> <input type="checkbox" tabindex="1"
								checked="checked" name="cashreceived" id="cashreceived"
								value="y" onclick="cashNotReceived()" style="margin: 0px 5px;" />
							<div id="cashNotReceived" style="display: none;">
								<label>Reason</label> <select id="cashReason" name="cashReason"
									style="margin-left: 3px; width: 162px;" tabindex="1">
									<option value="">Select</option>
									<option value="Accident">Accident</option>
									<option value="Medico Legal">Medico Legal</option>
									<option value="Staff">Staff</option>
									<option value="Foreigner">Foreigner</option>
									<option value="UnKnown Patient">UnKnown Patient</option>
									<option value="Below 18 Years">Below 18 Years</option>
								</select>
							</div>

							<div class="clear"></div>
							<div class="paddingTop15"></div>
							<h4>Bystander/ Attendant</h4>
							<div class="clear"></div>
							<div class="paddingTop15"></div>
							<div class="clear"></div>
							<div id="next_of_kin_detail">

								<label>UHID</label> <input type="text"
									name="<%=NEXT_OF_KIN_UHID %>" id="<%=NEXT_OF_KIN_UHID %>"
									onkeypress="searchDependent1(event)"
									onblur="searchDependent();" validate="UHID,metachar,no" /> <label>Name</label>
								<input id="nokNameId" type="text" name="<%=RELATIVE_NAME %>"
									value="" validate="Dependent Name,metacharDot,no" maxlength="30"
									tabindex="1" /> <label>Relation</label> <select
									name="<%=RELATION_ID%>" id="relId"
									validate=" Relation,int,no" tabindex="1">
									<option value="">Select</option>
									<%
      for(MasRelation relation:relationList)
      {
   	   %>
									<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
									<%
      }
      %>
								</select>
								<div class="clear"></div>
								<label>Contact No. </label> <input type="text"
									name="<%=MOBILE %>" id="mobileNo" value=""
									validate="Cobtact Number,phone,no" MAXLENGTH="10" tabindex="1" />

								</textarea>
								<label>Address</label>
								<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
									class="textareaMediua" tabindex="1"
									
									onpaste="return checkOnPaste(this)"
									oninput="return checkMaxLengthMoz(this)"
									onKeyDown="return checkMaxLength(this)"
									onKeyUp="finalCheck(this)">
</textarea>

							</div>
							<div class="clear"></div>


							<input type="hidden" id="hinNo" name="<%=HIN_NO %>"
								value="<%=patient.getHinNo() %>"> <input type="hidden"
								id="hinId" name="<%=HIN_ID %>" value="<%=patient.getId() %>">
							<input type="hidden" name="<%=AGE %>" value="<%=age %>">
							<input type="hidden" name="<%=SERVICE_TYPE_CODE %>" value="">
							<input type="hidden" name="<%=SERVICE_TYPE_ID %>" value=""
								id="serviceTypeId"> <input type="hidden"
								name="<%=BED_ID %>" value="" id="bedId">

							<div class="clear"></div>

							<!-- start of billing  -->

							<h4><%=prop.getProperty("com.jkt.hms.bill_heading") %></h4>



							<label>Charge</label> <select name="registrationType"
								id="registrationType" tabindex="46" onfocus="" >
								<option>select</option>
							</select> <label>Waive Charge <input type="checkbox"
								class="radioCheckCol2" style="margin-top: 3px" />
							</label> <label style="width: 177px;">Authorized By</label> <select
								name="registrationType" id="registrationType" tabindex="46" 
								onfocus="" >
								<option>select</option>
							</select>
							<div class="clear"></div>
							<label>Bill No.</label> <input type="text" validate="Bill No,metachar,no"  /> <label>Amount
								Chargeable</label> <input type="text" validate="Amount Chargeable,float,no" />

							<div class="clear"></div>

							<label>Available Credit Balance</label> <input type="text" validate="Available Credit Balance,float,no" /> <input
								type="checkbox" class="radioCheckCol2" style="margin-top: 3px" />

							<label class="auto" style="padding: 0px 12px 0px 5px;">Adjust
								Against Credit</label> <input type="text" /> <label>Balance To
								Be Paid</label> <input type="text" validate="Balance To Be Paid,float,no" /> <label>Amount Actually
								paid</label> <input type="text" validate="Amount Actually paid Paid,float,no" /> <label>Amount Tendered</label> <input
								type="text" validate="Amount Tendered,float,no"/> <label>Revised Credit Balance</label> <input
								type="text" validate="Revised Credit Balance,float,no"  />
							<div class="clear"></div>


							<%-- end of billing  --%>

							<div id="edited"></div>
							<div class="clear"></div>

							<div class="clear"></div>
							<div class="paddingTop40"></div>

							<input type="button" name="Submit11" value="Save" class="button"
								onClick="if(checkDepartment()){chechFoAttachAdmission()};"
								id="saveId" tabindex="1" /> <input type="hidden"
								name="attached" value="Attached" class="button" />
							<%-- 	    <input type="button" name="<%=MLC %>" value="MLC" class="button" onClick="if(checkForNok()){submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation&mlcFlag=1&flag=ipMlc','validateFRW');}" />
 --%>
							<input type="reset" name="Reset" value="Reset" class="button"
								accesskey="r" tabindex="1" />
							<%--	<div class="clear"></div> --%>

							<%}else if(dialysisSchedulingList.size()>0){
		//OpdPatientDetails patient = patientList.get(0);
		DialysisSchudeling dialysisSchudeling = dialysisSchedulingList.get(0);
		String age = "";
		//int ageForDiet = 0;
		int currentAge = 0;
		int patientCategoryId=0;
		if(dialysisSchudeling.getHin().getPatientType()!=null){
			patientCategoryId =dialysisSchudeling.getHin().getPatientType().getId();
		}
		if(dialysisSchudeling.getHin().getDateOfBirth()!=null){
			currentAge = HMSUtil.getCurrentAgeByDoB(dialysisSchudeling.getHin().getDateOfBirth());
		}
		age=""+currentAge;
		
		List<MasDepartment> departmentListForDialysis = new ArrayList<MasDepartment>();
		if(detailsMap.get("maritalStatusList") != null){
			maritalStatusList = (List<MasMaritalStatus>)detailsMap.get("maritalStatusList");
		}
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(detailsMap.get("departmentListForDialysis") != null){
			departmentListForDialysis = (List<MasDepartment>)detailsMap.get("departmentListForDialysis");
		}
		if(detailsMap.get("hospitalUnitList") != null){
			hospitalUnitList = (List<HospitalDoctorUnitM>)detailsMap.get("hospitalUnitList");
		}
		if(detailsMap.get("employeeList") != null){
			employeeList = (List<Object[]>)detailsMap.get("employeeList");
		}
	
		if(detailsMap.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)detailsMap.get("bloodGroupList");
		}

		
		if(detailsMap.get("admissionTypeList") != null){
			admissionTypeList = (List<MasAdmissionType>)detailsMap.get("admissionTypeList");
		}

		
		if(detailsMap.get("relationList") != null){
			relationList = (List<MasRelation>)detailsMap.get("relationList");
		}
	
		if(detailsMap.get("patientCategoryList") != null){
			patientCategoryList = (List<MasPatientCategory>)detailsMap.get("patientCategoryList");
		}


%>
							<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
							<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
							<script type="text/javascript">


function checkForNok(){
var errorMessage="";
	formName="registration"
	obj = eval('document.'+formName)
	
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}


}
function fillDiagnosisCombo() {
var val =document.getElementById("icd").value
  	  var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	    var initDiagnosis=val.substring(0,parseInt(index1)-1);
	    if(id !=""){
		obj =document.getElementById('diagnosisId');
		obj.length = document.getElementById('diagnosisId').length;

	        	obj.length++;
				obj.options[obj.length-1].value=id
				obj.options[obj.length-1].text=val
				obj.options[obj.length-1].selected=true
				document.getElementById('icd').value =""
				}
    document.getElementById('initDiagnosis').value= initDiagnosis
  }
  
  
function chechFoAttachAdmission(){
	submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation');
}


function checkDiet(age,currentTime){

age=parseInt(age)
if(age<1){
}

}

function getOldAdNo(){
if(document.getElementById('old').checked == true){
		document.getElementById('oldAdNoId').disabled = false;
		document.getElementById('imgId').style.display = 'inline';
		document.getElementById('admTime').disabled=false


	}else{
		document.getElementById('oldAdNoId').disabled = true;
		document.getElementById('imgId').style.display = 'none';
		document.getElementById('admTime').disabled=true
	}
}
</script>

							<script type="text/javascript">
			function displayUnit(deptId){
				  var hospitalId='<%=session.getAttribute("hospitalId")%>';

				  var xmlHttp=null;
				  try {
				    // Firefox, Opera 8.0+, Safari
				    xmlHttp=new XMLHttpRequest();
				  }catch (e){
				    // Internet Explorer
				    try{
				      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
				    }catch (e){
				    	alert(e)
				      try{
				        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				      }catch (e){
				        alert("Your browser does not support AJAX!");
				        return false;
				      }
				     }
				   }
				  obj = document.getElementById("unit");
				  obj.length=1;
				  
				  
					/*obj.options[0].value=0;
					obj.options[0].text="select";*/
				    xmlHttp.onreadystatechange=function()
				    {
				      if(xmlHttp.readyState==4){

				      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
				      	//alert("items"+items)
				      
						
				      	for (loop = 0; loop < items.childNodes.length; loop++) {
					   	    var item = items.childNodes[loop];
					        var unitId  = item.getElementsByTagName("unitId")[0];
					        var unitCode  = item.getElementsByTagName("unitCode")[0];
					        
					       
					        
					        if(unitId.childNodes[0] !=undefined){
					        obj.length++;
							obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
							obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;
					        }
					        
							//document.getElementById("unit").selectedIndex = unitId.childNodes[0].nodeValue


				      	}
				      }
				    }
				     var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+deptId;
			    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
				    xmlHttp.open("GET",url,false);
				    xmlHttp.setRequestHeader("Content-Type", "text/xml");
				    xmlHttp.send(null);
				 	
			}

		</script>


							<form name="admissionByHin" method="post" id="onFocusForm">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}"> <input type="hidden"
									name="<%=HIN_ID%>"
									value="<%=dialysisSchudeling.getHin().getId() %>" />



								<!-- Added by Amit Das on 23-02-2016 -->
								<%--
		commented by anamika
 <input type="hidden" name="<%=VISIT_ID%>" value="<%=patient.getVisit().getId() %>" /> --%>

								<div class="titleBg">
									<h2>Patient Admission</h2>
								</div>

								<div class="Block">
									<%-- <input type="hidden" name="patTypeId" id="patTypeId" value="<%=patTyprId %>"/> --%>

									<div class="clear"></div>
									<h4>Patient Details</h4>
									<div class="clear"></div>
									<div class="paddingTop15"></div>
									<div class="clear"></div>

									<label><%=prop.getProperty("com.jkt.hms.uhid") %></label> <label
										class="value"><%=dialysisSchudeling.getHin().getHinNo() %></label>
									<%
	if(dialysisSchudeling.getHin().getSex() != null){
	%>

									<%
		String patientName = dialysisSchudeling.getHin().getPFirstName();
		if(dialysisSchudeling.getHin().getPMiddleName() != null){
			patientName = dialysisSchudeling.getHin().getPMiddleName();
		}
		if(dialysisSchudeling.getHin().getPLastName() != null){
			patientName = dialysisSchudeling.getHin().getPLastName();
		}

		%>

									<label>Patient Name</label> <label class="value"><%=patientName%></label>
									<input type="hidden" name="<%=PATIENT_NAME %>"
										value="<%= patientName%>" /> <label>Address</label> <label
										class="value">- </label>
									<div class="clear"></div>
									<label>Gender</label> <label class="value"><%= dialysisSchudeling.getHin().getSex()!=null?dialysisSchudeling.getHin().getSex().getAdministrativeSexName():"" %></label>
									<%} %>

									<input type="hidden" id="patientTypeId" name="patientTypeId"
										value="<%=dialysisSchudeling.getHin().getPatientType()!=null?dialysisSchudeling.getHin().getPatientType().getId():"" %>" />
									<input type="hidden" id="dialysisSchudelingId"
										name="dialysisSchudelingId"
										value="<%=dialysisSchudeling.getId()!=null?dialysisSchudeling.getId():"" %>" />



									<input type="hidden" name="<%=GENDER %>" id="<%=GENDER %>"
										value="<%=dialysisSchudeling.getHin().getSex()!=null?dialysisSchudeling.getHin().getSex().getId():"" %>" />

									<label>Marital Status</label>
									<%if(dialysisSchudeling.getHin().getMaritalStatus() !=null){%>
									<label class="value"><%=dialysisSchudeling.getHin().getMaritalStatus().getMaritalStatusName() %></label>
									<%}
else
{
%>
									<label class="value">-</label>

									<%
}%>


									<input type="hidden" id="sexId" name="<%=SEX_ID %>"
										value="<%=dialysisSchudeling.getHin().getSex()!=null?dialysisSchudeling.getHin().getSex().getId():""%>" />



									<label>Age</label> <label class="value"><%=currentAge%></label>


									<div class="clear"></div>

									<label>Patient Category</label> <label class="value"> <%if(dialysisSchudeling.getHin().getPatientCategory()!=null){ %>
										<input type="hidden"
										value="<%=dialysisSchudeling.getHin().getPatientCategory().getId() %>" />
										<%=dialysisSchudeling.getHin().getPatientCategory().getPatientCategoryName() %>
										<%}else
                    	 {%> - <%} %>

									</label> <label>Department</label> <label class="value"> <%=dialysisSchudeling.getDepartment()!=null ? dialysisSchudeling.getDepartment().getDepartmentName():"" %>
										<!-- Added by Amit Das on 23-02-2016 --> <input type="hidden"
										name="ward"
										value="<%=dialysisSchudeling.getDepartment()!=null ? dialysisSchudeling.getDepartment().getId():"" %>" />

									</label> <label>Unit</label> <label class="value">-</label>
									<div class="clear"></div>
									<label> Referring Doctor</label> <label class="value">-</label>


									<label>Family Income Status<span>*</span></label>
									<%if(dialysisSchudeling.getHin().getBplStatus()!=null && dialysisSchudeling.getHin().getBplStatus().equalsIgnoreCase("y")){ %>
									<label class="mediumAuto">BPL <input type="radio"
										class="radioCheckCol2" tabindex="2" checked="checked"
										name="<%=BPL_STATUS %>" value="bpl" /></label> <label class="auto">APL<input
										type="radio" class="radioCheckCol2" tabindex="2"
										name="<%=BPL_STATUS %>" value="apl" /></label>

									<%}else if(dialysisSchudeling.getHin().getBplStatus()!=null && dialysisSchudeling.getHin().getBplStatus().equalsIgnoreCase("n")){ %>
									<label class="mediumAuto">BPL <input type="radio"
										class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
										value="bpl" /></label> <label class="mediumAuto">APL<input
										type="radio" class="radioCheckCol2" tabindex="2"
										checked="checked" name="<%=BPL_STATUS %>" value="apl" /></label>
									<%} else { %>
									<label class="mediumAuto">BPL <input type="radio"
										class="radioCheckCol2" tabindex="2" name="<%=BPL_STATUS %>"
										value="bpl" /></label> <label class="mediumAuto">APL<input
										type="radio" class="radioCheckCol2" tabindex="2"
										name="<%=BPL_STATUS %>" value="apl" /></label>
									<%} %>
									<!-- Added Scheme By Amit Das on 23-02-2016 -->

									<label style="margin-right: 5px;">Scheme</label>
									<div id="schemeDiv">
										<select name="schemeList" id="schemeList"
											validate="Scheme,int,no" style="width: 151px !important;">
											<option value="0">Select</option>
										</select>
									</div>

									<!-- Ended Scheme By Amit Das on 23-02-2016 -->

									<div class="clear"></div>
									<label>Social<span>*</span>
									</label> <select id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
										tabindex="1" validate="Social,int,yes"
										style="width: 170px; margin-right: 1px;">
										<option value="0">Select</option>
										<%for(MasPatientType masPatientType : patientTypeForSocialCategory)
			       {%>
										<%if(patientCategoryId==masPatientType.getId()){ %>
										<option value="<%=masPatientType.getId()%>"
											selected="selected"><%=masPatientType.getPatientTypeName()%></option>
										<%}else{ %>
										<option value="<%=masPatientType.getId()%>"><%=masPatientType.getPatientTypeName()%></option>
										<%} %>
										<%}%>
									</select> <label>Other Category</label> <select id="otherCategoryId"
										tabindex="2" multiple="multiple" class="multiple" size="5"
										style="width: 167px" name="<%=OTHER_CATEGORY%>">
										<option value="0">select</option>
										<%
				if(null != patientTypeForOtherCategory){
				for(MasPatientType otherCategory : patientTypeForOtherCategory)
			       {%>
										<%if(patientCategoryId==otherCategory.getId()){ %>
										<option value="<%=otherCategory.getId()%>" selected="selected"><%=otherCategory.getPatientTypeName()%></option>
										<%}else{ %>
										<option value="<%=otherCategory.getId()%>"><%=otherCategory.getPatientTypeName()%></option>
										<%} %>
										<%}
				}
				%>
									</select>


									<div class="clear"></div>
									<div class="paddingTop15"></div>
									<h4>Admission Details</h4>
									<div class="clear"></div>
									<div class="paddingTop15"></div>
									<div class="clear"></div>

									<label> Admission Type</label> <select
										name="<%=ADMISSION_TYPE_ID %>"
										validate="Admission Type,int,no">
										<%
for(MasAdmissionType admissionType:admissionTypeList)
{
%>
										<option value="<%=admissionType.getId()%>"><%=admissionType.getAdmissionTypeName()%></option>
										<%
}
%>
									</select> <label>Admission Date & Time</label> <img
										src="/hms/jsp/images/cal.gif" width="16" height="16"
										border="0" validate="Pick a date" id="imgId"
										onclick="javascript:setdate('<%=currentDate %>',document.admissionByHin.<%=DATE_OF_ADMISSION%>,event)" />
									<input class="dateTextSmall" type="text"
										name="<%=DATE_OF_ADMISSION%>" value="<%=currentDate %>"
										readonly="readonly" validate="Adm. Date,date,yes"
										MAXLENGTH="30" id="admDate" onchange="populateListDateTime();"
										onclick="populateListDateTime();" /> <input class="textSmall"
										style="width: 79px;" type="text"
										name="<%=TIME_OF_ADMISSION %>" value="<%=currentTime %>"
										validate="Adm. Time,timeFormat,yes" id="admTime"
										onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');populateListDateTime();" />

									<label>Admitting doctor</label> <select
										name="<%=CONSULTING_DOCTOR %>"
										validate="Admitting doctor,int,yes" tabindex="1">
										<option value="0">Select</option>
										<% 
for (Object[]  obj : employeeList){

%>
										<option value="<%=obj[0]%>"><%=obj[1]%></option>

										<%} %>
									</select>

									<div class="clear"></div>
									<label> Ward <span>*</span></label> <select
										name="<%=DEPARTMENT_ID %>" validate="Ward,int,yes" id="wardId"
										tabindex="1">
										<!-- onchange="displayUnit(this.value);" -->
										<!--  onchange="" onblur="getBillAmount();changeAmount();"-->

										<option value="0">Select</option>
										<%
			for (MasDepartment  masDepartment : departmentListForDialysis){
				if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(depTypeCodeDialysis)){
			%>
										<option value="<%=masDepartment.getId ()%>"><%=masDepartment.getDepartmentName()%></option>
										<%}}
		%>
									</select> <label> Unit</label> <select name="hospitalUnitId"
										validate="Unit,int,no" id="unit" tabindex="2"
										onchange="displayUnitHeadeName(this.value);">
										<option value="">Select</option>
										<%
	    if(hospitalUnitList.size()>0){
			for (HospitalDoctorUnitM  hospitalUnit : hospitalUnitList){
				
					
		%>
										<option value="<%=hospitalUnit.getId ()%>"><%=hospitalUnit.getUnitCode()%></option>
										<%}} %>
									</select> <label>Unit Head </label> <input name="headName" id="headName"
										value="" validate="Unit Head,metacharDot,no"/> <label>Remarks</label>
									<textarea rows="4" name="<%=REMARKS%>" tabindex="2"
										validate="Remarks,metachar,no" maxlength="250" value=""
										class="textareaMediua"></textarea>
									<label>Critical Condition <input type="checkbox"
										style="margin-top: 3px" name="<%=CONDITION %>"
										id="<%=CONDITION %>" class="radioCheckCol2" /></label> <label
										style="width: 183px; margin-left: 2px;">MLC <input
										type="checkbox" style="margin-top: 3px" name="<%=MLC%>"
										id="<%=MLC%>" class="radioCheckCol2" /></label>
									<%if(currentAge<=1){ %>
									<label>New Born Baby <input type="checkbox"
										name="newBornBaby" id="newBornBabyId"
										onclick="getMotherUHID()" maxlength="25"
										class="radioCheckCol2" /></label>
									<%} %>
									<div id="motherUHID" style="display: none;">
										<label>Mother UHID</label> <input type="text"
											id="motherUHIDId" name="motherUHID" tabindex="2"
											validate="Mother UHID,metachar,no"
											onblur="checkMotherExistence(this.value)"
											class="textbox_size20" maxlength="50" />

									</div>
									<div class="clear"></div>
									<label>Cash Received</label> <input type="checkbox"
										tabindex="1" checked="checked" name="cashreceived"
										id="cashreceived" value="y" onclick="cashNotReceived()"
										style="margin: 0px 5px;" />
									<div id="cashNotReceived" style="display: none;">
										<label>Reason</label> <select id="cashReason"
											name="cashReason" style="margin-left: 3px; width: 162px;"
											tabindex="1">
											<option value="">Select</option>
											<option value="Accident">Accident</option>
											<option value="Medico Legal">Medico Legal</option>
											<option value="Staff">Staff</option>
											<option value="Foreigner">Foreigner</option>
											<option value="UnKnown Patient">UnKnown Patient</option>
											<option value="Below 18 Years">Below 18 Years</option>
										</select>
									</div>

									<div class="clear"></div>
									<div class="paddingTop15"></div>
									<h4>Bystander/ Attendant</h4>
									<div class="clear"></div>
									<div class="paddingTop15"></div>
									<div class="clear"></div>
									<div id="next_of_kin_detail">

										<label>UHID</label> <input type="text"
											name="<%=NEXT_OF_KIN_UHID %>" id="<%=NEXT_OF_KIN_UHID %>"
											onkeypress="searchDependent1(event)"
											onblur="searchDependent();" validate="UHID,metachar,no" /> <label>Name</label>
										<input id="nokNameId" type="text" name="<%=RELATIVE_NAME %>"
											value="" validate="Dependent Name,metacharDot,no" maxlength="30"
											tabindex="1" /> <label>Relation</label> <select
											name="<%=RELATION_ID%>" id="relId"
											validate=" Relation,int,no" tabindex="1">
											<option value="">Select</option>
											<%
      for(MasRelation relation:relationList)
      {
   	   %>
											<option value="<%=relation.getId()%>"><%=relation.getRelationName()%></option>
											<%
      }
      %>
										</select>
										<div class="clear"></div>
										<label>Contact No. </label> <input type="text"
											name="<%=MOBILE %>" id="mobileNo" value=""
											validate="Cobtact Number,phone,no" MAXLENGTH="10"
											tabindex="1" />

										</textarea>
										<label>Address</label>
										<textarea name="<%=ADDRESS %>" id="addr" cols="20" rows="2"
											class="textareaMediua" tabindex="1"
											
											onpaste="return checkOnPaste(this)"
											oninput="return checkMaxLengthMoz(this)"
											onKeyDown="return checkMaxLength(this)"
											onKeyUp="finalCheck(this)">
</textarea>

									</div>
									<div class="clear"></div>


									<input type="hidden" id="hinNo" name="<%=HIN_NO %>"
										value="<%=dialysisSchudeling.getHin().getHinNo() %>">
									<input type="hidden" id="hinId" name="<%=HIN_ID %>"
										value="<%=dialysisSchudeling.getHin().getId() %>"> <input
										type="hidden" name="<%=AGE %>" value="<%=age %>"> <input
										type="hidden" name="<%=SERVICE_TYPE_CODE %>" value="">
									<input type="hidden" name="<%=SERVICE_TYPE_ID %>" value=""
										id="serviceTypeId"> <input type="hidden"
										name="<%=BED_ID %>" value="" id="bedId">

									<div class="clear"></div>

									<!-- start of billing  -->

									<h4><%=prop.getProperty("com.jkt.hms.bill_heading") %></h4>


									<label>Charge</label> <select name="registrationType"
										id="registrationType" tabindex="46" onfocus="" >
										<option>select</option>
									</select> <label>Waive Charge <input type="checkbox"
										class="radioCheckCol2" style="margin-top: 3px" />
									</label> <label style="width: 177px;">Authorized By</label> <select
										name="registrationType" id="registrationType" tabindex="46"
										onfocus="" >
										<option>select</option>
									</select>
									<div class="clear"></div>
									<label>Bill No.</label> <input type="text" validate="Bill No,metachar,no" /> <label>Amount
										Chargeable</label> <input type="text" validate="Amount Chargeable,float,no" />

									<div class="clear"></div>

									<label>Available Credit Balance</label> <input type="text" validate="Available Credit Balance,float,no"/>
									<input type="checkbox" class="radioCheckCol2"
										style="margin-top: 3px" /> <label class="auto"
										style="padding: 0px 12px 0px 5px;">Adjust Against
										Credit</label> <input type="text" /> <label>Balance To Be
										Paid</label> <input type="text" validate="Balance To Be Paid,float,no"/> <label>Amount Actually
										paid</label> <input type="text" /> <label>Amount Tendered</label> <input
										type="text" validate="Amount Tendered,float,no"/> <label>Revised Credit Balance</label> <input
										type="text" validate="Revised Credit Balance,float,no"/>
									<div class="clear"></div>


									<%-- end of billing  --%>

									<div id="edited"></div>
									<div class="clear"></div>

									<div class="clear"></div>
									<div class="paddingTop40"></div>

									<input type="button" name="Submit11" value="Save"
										class="button"
										onClick="if(checkDepartment()){chechFoAttachAdmission()};"
										id="saveId" tabindex="1" /> <input type="hidden"
										name="attached" value="Attached" class="button" />
									<%-- 	    <input type="button" name="<%=MLC %>" value="MLC" class="button" onClick="if(checkForNok()){submitForm('admissionByHin','/hms/hms/adt?method=submitAdmissionInformation&mlcFlag=1&flag=ipMlc','validateFRW');}" />
 --%>
									<input type="reset" name="Reset" value="Reset" class="button"
										accesskey="r" tabindex="1" />


									<%}else{%>
									<h4>
										<span>No Records Found !</span>
									</h4>
									<%} %>



									<div class="clear"></div>
									<div class="paddingTop40"></div>
									<div class="clear"></div>
									<div class="paddingTop40"></div>
								</div>
								<div id="statusMessage"></div>

								<div class="clear"></div>

								<div class="paddingTop40"></div>

							</form>


							<script type="text/javascript">

//Added by Amit Das on 23-02-2016
submitProtoAjaxWithDivName('admissionByHin','/hms/hms/billingMaster?method=listScheme&type=ip&isPaywardBooking=true','schemeDiv');



function getMotherUHID(){
	if(document.getElementById('newBornBabyId').checked = true){
		document.getElementById('motherUHID').style.display = 'block';
	}else{
		document.getElementById('motherUHID').style.display = 'none';
	}
}


function  checkMotherExistence(val){
	//alert("dsfdsf"+val);
	submitProtoAjaxForMotherDetails('admissionByHin','/hms/hms/adt?method=checkMotherDetail&hinNo='+val);
	
}

function submitProtoAjaxForMotherDetails(formName,action){
	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      	if(items.childNodes.length!=0){


	      		for (loop = 0; loop < items.childNodes.length; loop++) {
			   	    var item = items.childNodes[loop];
			   	    var msg  = item.getElementsByTagName("msg")[0];
			   	 
			       if(msg !=undefined && msg.childNodes[0] !=undefined){
			      	 document.getElementById('motherUHIDId').value="";
			       }
				}
		   	  }

	      }
	    }
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

	  }


	
	

function checkForDiscount()
{
	var authorizer=eval(document.admissionByHin.refDoctor.value);
	var amount=parseFloat(document.admissionByHin.amt.value);
	var discountVar=document.admissionByHin.discount.value;
	if(validateFloat(discountVar)){
		if(discountVar>amount)
		{
			alert("Discount should be less than or equal to amount!!");
			document.admissionByHin.discount.value="";
			return false;
		}
		if(discountVar!="" && authorizer==0)
		{
			alert("Select Authorizer!!");
			return false;
		}
	}else{
		alert("Charity should be integer or decimal value.");
		document.admissionByHin.discount.value = "";
		return false;

	}
	return true;
}

			function displayAddress2(){
				var unit = document.getElementById('unitId').value;
				document.getElementById('unitAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				document.getElementById('addUnitDiv').style.display = 'none';
				<%
					 for(MasUnit masUnit : unitList){
				%>
						var unit1 = '<%=masUnit.getId()%>';
						if(unit == unit1){

							document.admissionByHin.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('addUnitDiv').style.display = 'inline';
						document.getElementById('unitAddId').style.display = 'none';
					}
				}else if(unit == 0){
					document.admissionByHin.<%=UNIT_ADDRESS%>.value = '';
				}
			}
		</script>
							<script language="Javascript">
function  fillChargeCode(val){
if(val=="0"||val==""){
alert("Pls select Charge Type")
return false;
}else{

submitProtoAjaxForChargeCode('admissionByHin','/hms/hms/adt?method=getChargeCodeDetails&chargeTypeId='+val);
}
}
 function submitProtoAjaxForChargeCode(formName,action){
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	if(items.childNodes.length!=0){
      	var obj=document.getElementById("chargeCodeId");
      	obj.length=1
      		obj.options[obj.length-1].value="0";
      		obj.options[obj.length-1].text="select";
      	for (loop = 0; loop < items.childNodes.length; loop++) {
      	 obj.length++;
	   	 var item = items.childNodes[loop];
	   	   var id=item.getElementsByTagName("id")[0];
	   	     var chargeName=item.getElementsByTagName("chargeName")[0];
				obj.options[obj.length-1].value=id.childNodes[0].nodeValue;
				obj.options[obj.length-1].text=chargeName.childNodes[0].nodeValue;


	   	  }
	   	  }
	   	  else{
      	alert("There are No items for This charge Type ");

      	}
      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }
			function displayAddress(selectedUnit)
			{
				var unit = selectedUnit;
				document.getElementById('unitAddId').style.display = 'inline';
				if(unit != 0){
				if(unit != 'Other'){
				<%
					 for(MasUnit masUnit : unitList) {
				%>
						var unit1 = '<%=masUnit.getId()%>';
						if(unit == unit1){
							document.admissionByHin.unitAdd.value = '<%=masUnit.getUnitAddress()%>'
						 }
			<%}%>}else if(unit == 'Other'){
						document.getElementById('unitAddId').style.display = 'none';
					}
				}else if(unit == 0){
					document.admissionByHin.unitAdd.value = '';
				}
			}

			function jsSetBedId(bedId)
			{
			document.getElementById("bedId").value=bedId;
			}

function  fillBillingItems(){

	var val = document.getElementById('chargeCodeId').value;

	if(val=="0"||val==""){
		alert("Pls select Charge Code")
		return false;
	}else{
		var hinNo=document.admissionByHin.hinNo.value;
		submitProtoAjaxForBillingDetails('admissionByHin','/hms/hms/registration?method=getIpAdmissionDetailsForBilling&hinNo='+hinNo+'&chargeCodeId='+val);
	}
}

function submitProtoAjaxForBillingDetails(formName,action){
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
    	alert(e)
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){

      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	if(items.childNodes.length!=0){


      	for (loop = 0; loop < items.childNodes.length; loop++) {

	   	 var item = items.childNodes[loop];
	   	   var chargeCodeId=item.getElementsByTagName("chargeCodeId")[0];
	   	   var billNo=item.getElementsByTagName("billNo")[0];
	   	   var amt=item.getElementsByTagName("amount")[0];
	   	   billNo=billNo.childNodes[0].nodeValue;
	   	    amt=amt.childNodes[0].nodeValue;
	   	     var chargeCodeName=item.getElementsByTagName("chargeCodeName")[0];

	   	  document.getElementById("billNo").value=billNo;
	   	  document.getElementById("amt").value=amt;

	   	  }
	   	  }

      }
    }
    var url=action+"&"+getNameAndData(formName);
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

  }


 
</script>
							<script>
function checkDepartment(){
var gender;
var department;
gender = document.admissionByHin.<%=GENDER%>.value;
department = document.admissionByHin.<%=DEPARTMENT_ID%>.value;
if (gender == "3" && department == "49")
{
alert('This is a male patient OBG Department cannot register him');

}else
return true;
}

/* document.getElementById('complaintId').focus(); */
</script>
							<script>
function changeAmount(){
	//alert("in method");
var patType=document.getElementById('patTypeId').value;
//	alert("patType--->"+patType)
if(patType==14 || patType==15 || patType==16 || patType==17){
	document.getElementById('amt').value='0.0'
}else {
	document.getElementById('amt').value='25.0'
}
}

function enableDisableOnDependent()
{
	if(document.getElementById("attachAdmission").checked )
		{
		document.getElementById("nokNameId").disabled=false;
		document.getElementById("relId").disabled=false;
		document.getElementById("mobileNo").disabled=false;
		document.getElementById("addr").disabled=false;
		
		}
	else
		{

		document.getElementById("nokNameId").disabled=true;
		document.getElementById("relId").disabled=true;
		document.getElementById("mobileNo").disabled=true;
		document.getElementById("addr").disabled=true;
		}
}

function checkDependentFieldData()
{
	if(document.getElementById("attachAdmission").checked)
		{
		if(document.getElementById("nokNameId")==null || document.getElementById("nokNameId").value.trim()=='')
			{
			alert("Please fill dependent name");
			return false;
			
			}
		if(document.getElementById("relId")==null || document.getElementById("relId").value=='')
		{
			alert("Please select relation");
			return false;
		}
		if(document.getElementById("mobileNo")==null || document.getElementById("mobileNo").value.trim()=='')
		{
			alert("please fill mobile no.");
			return false;
		}
		if(document.getElementById("addr")==null || document.getElementById("addr").value.trim()=='')
		{
			alert("please fill address");
			return false;
		}
		return true;
		}
	
	else
		{
		return true;
		}
}

function searchDependent()
{
	if(document.getElementById("<%=NEXT_OF_KIN_UHID%>")!=null && document.getElementById("<%=NEXT_OF_KIN_UHID%>").value!='')
		{
		submitProtoAjaxDynamic('admissionByHin',"ipd?method=searchNextOfKinPatient","next_of_kin_detail");
		} 
}

function searchDependent1(event)
  {
	event=event|| window.event;
	var keycode = (event.keyCode ? event.keyCode : event.which);
	if(keycode==13)
		{
		searchDependent();
		}
}
	
	/* enableDisableOnDependent(); */
	 
  function populateDoctorForUnit(UnitId) {

	  var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }

	  docobj = document.getElementById("loddrs");
	  docobj.length=1;
	  if(document.getElementById("consultingDocId"))
	 	 document.getElementById("consultingDocId").value="";
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	      
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		   	    
		        var DoctId  = item.getElementsByTagName("DoctId")[0];
		        var DoctName  = item.getElementsByTagName("DoctName")[0];
		        
		     
		        var hedDoctName  = item.getElementsByTagName("hedDoctName")[0];
		       
		        docobj.length++;
		        docobj.options[docobj.length-1].value=DoctId.childNodes[0].nodeValue;
		        docobj.options[docobj.length-1].text=DoctName.childNodes[0].nodeValue;
				
				if(hedDoctName!=undefined && document.getElementById("consultingDocId"))
					document.getElementById("consultingDocId").value=hedDoctName.childNodes[0].nodeValue;
	      	}
	      }
	    }
	      
	       var url="/hms/hms/registration?method=populateDoctorForUnit&UnitId="+UnitId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	  }
 
 
  function populateUnitForDepartment(departmentId) {
	var depatmentId=0;
	var hospitalId=0;
	var selectedUnit=0;
	
	  var xmlHttp=null;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
	  obj = document.getElementById("unit");
	  obj.length=1;
	  
	  obj1 = document.getElementById("loddrs");
	  obj1.length=1;
	  
	  
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){

	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	    	
	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		        var unitId  = item.getElementsByTagName("unitId")[0];
		        var unitCode  = item.getElementsByTagName("unitCode")[0];
		        
		        var doctorId  = item.getElementsByTagName("doctorId")[0];
		        var doctorName  = item.getElementsByTagName("doctorName")[0];
		       
		        var deptUnitId = item.getElementsByTagName("deptUnitId")[0];
		        
		        if(unitId !=undefined && unitId.childNodes[0] !=undefined){
		        	obj.length++;
		        	obj.options[obj.length-1].value=unitId.childNodes[0].nodeValue;
		        	obj.options[obj.length-1].text=unitCode.childNodes[0].nodeValue;
		        	document.getElementById("unit").selectedIndex= "1";
		        	//Added by Arbind on 21-05-2017
		        	if(deptUnitId != undefined && deptUnitId.childNodes[0] != undefined) {
		        		if(deptUnitId.childNodes[0].nodeValue == unitId.childNodes[0].nodeValue) {
		        			document.getElementById("unit").value = deptUnitId.childNodes[0].nodeValue;
		        			selectedUnit = deptUnitId.childNodes[0].nodeValue;
		        		}
		        	}
		        }
		      
		        
		        if(doctorId !=undefined   && doctorId.childNodes[0] !=undefined){
			        obj1.length++;
					obj1.options[obj1.length-1].value=doctorId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=doctorName.childNodes[0].nodeValue;
					document.getElementById("loddrs").selectedIndex= "1";
		        	//Added by Arbind on 21-05-2017
		        	
		        	   document.getElementById("loddrs").value = doctorId.childNodes[0].nodeValue;
		        			selectedUnit = doctorId.childNodes[0].nodeValue;
		        	   //selectItemByValueId(document.getElementById("loddrs"),doctorId.childNodes[0].nodeValue);
			        }
			        
		        
			

	      	}
	      }
	    }
	  
	 
	      var url="/hms/hms/registration?method=populateUnitForDepartment&hospitalId="+hospitalId+"&depatmentId="+departmentId;
   	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,false);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	    //Added by Arbind on 21-05-2017
	   /*  if(selectedUnit != 0)
	    	populateDoctorForUnit(selectedUnit);
	    else
	    	populateDoctorForDepartment(departmentId); */
	    	if(selectedUnit==0)
	    		populateDoctorForDepartment(departmentId);
	  }
  
  function selectItemByValueId(elmnt, value){
	  alert(elmnt.value+"....."+value);
	  for(var i=0; i < elmnt.options.length; i++)
	  {
		  if(elmnt.options[i].value === value) {
		      elmnt.selectedIndex = i;
		      break;
		    }
		  }
		}
	
</script>
							<%
								admissionTypeList = null;
								authorizerList = null;
								/* bedList=null; */
								bloodGroupList = null;
								chargeCodeList = null;
								chargeTypeList = null;
								/* complaintList=null; */
								departmentList = null;
								/* diagnosisList=null;
								 dietList=null;
								 documentList=null; */
								employeeList = null;
								maritalStatusList = null;
							%>