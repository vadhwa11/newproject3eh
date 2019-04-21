<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.util.Set"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>

<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<%
System.out.println("..............................................");
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
Box box = HMSUtil.getBox(request);
Map<String, Object> patientMap = new HashMap<String, Object>();
Map<String, Object> map = new HashMap<String, Object>();
List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
MasHospital masHospital = null;
int currentLabId = 0;
int userId =0;
//List<DgOrderhd> patientList = new ArrayList<DgOrderhd>();

List<DgResultEntryHeader> patientListResult = new ArrayList<DgResultEntryHeader>();

List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
 date = (String) utilMap.get("currentDate");
	//Date toDate  = null;
//Date fromDate=null;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("detailsMap") !=null){
	detailsMap=(Map<String, Object>)map.get("detailsMap");
}
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
}
if(patientMap.get("patientListResult") != null){
	patientListResult= (List<DgResultEntryHeader>)patientMap.get("patientListResult");
	
}


System.out.println("patientListResult in array Div jsp == "+patientListResult.size());

String patientName = "";
String doctorName = "";
String age = "";
String sex = "";
String hinNo = "";
String diagNo = "";
StringBuffer stringBuffer = new StringBuffer();


int counter=0;
	String validate = "";
	int peviousDgId=0;
	
if (patientListResult != null && patientListResult.size() > 0) { 

stringBuffer.append("[");
	for(DgResultEntryHeader dgResultDetail : patientListResult){
		if(peviousDgId !=dgResultDetail.getSampleCollectionHeader().getId()){
			peviousDgId=dgResultDetail.getSampleCollectionHeader().getId();
		
		
	Patient patient = dgResultDetail.getHin();
	if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
		continue;
	}
			
stringBuffer.append("{");
stringBuffer.append("\"0\" : \""+dgResultDetail.getSampleCollectionHeader().getOrder().getId()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"1\" : \""+"<input type='radio' name='parent' value='"+dgResultDetail.getSampleCollectionHeader().getOrder().getId()+"' id='parent="+counter+"' >\"");
stringBuffer.append(",");
stringBuffer.append("\"2\" : \""+HMSUtil.changeDateToddMMyyyy(dgResultDetail.getResultDate())+"\"");
stringBuffer.append(",");
stringBuffer.append("\"3\" : \""+dgResultDetail.getResultTime()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"4\" : \""+dgResultDetail.getHin().getHinNo()+"\"");
stringBuffer.append(",");
if(dgResultDetail.getHin().getPFirstName() != null  && !(dgResultDetail.getHin().getPFirstName().equals(""))){
	
	String pMiddleName = "";
	String pLastName = "";
	if(patient.getPMiddleName() != null){
		pMiddleName = dgResultDetail.getHin().getPMiddleName();
	}
	if(patient.getPLastName() != null){
		pLastName = dgResultDetail.getHin().getPLastName();
	}
	String pName = dgResultDetail.getHin().getPFirstName()+" "+pMiddleName+" "+pLastName;
		stringBuffer.append("\"5\" : \""+pName+"\"");
}else{
		stringBuffer.append("\"5\" : \"\"");
}
stringBuffer.append(",");
stringBuffer.append("\"6\" : \"-\"");
stringBuffer.append(",");
if(dgResultDetail.getHin() != null && dgResultDetail.getHin().getAge()!=null){
	stringBuffer.append("\"7\" : \""+dgResultDetail.getHin().getAge()+"\"");
}else{
	stringBuffer.append("\"7\" : \"-\"");
}
stringBuffer.append(",");
if(dgResultDetail.getHin() != null){
	  if(dgResultDetail.getHin().getSex() != null){
	    if(dgResultDetail.getHin().getSex().getAdministrativeSexName() != null){ 
	    	stringBuffer.append("\"8\" : \""+dgResultDetail.getHin().getSex().getAdministrativeSexName()+"\"");
	    	stringBuffer.append(",");
	    }
	  } 
}
if(dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType() != null){ 	  
	stringBuffer.append("\"9\" : \""+dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()+"\"");
}else{
		stringBuffer.append("\"9\" : \"-\"");
}

stringBuffer.append(",");
if(dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName() != null){	
		stringBuffer.append("\"10\" : \""+dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()+"\"");
}else{
			stringBuffer.append("\"10\" : \"-\"");
}
stringBuffer.append(",");
String DFName="";
String DMName="";
String DLName="";
if(null != dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy() && dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName() != null){	
   DFName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
	 }

	if(null != dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy() && dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName() != null){	
		DMName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
	 }
 if(null != dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy() && dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName() != null){	
	 DLName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
 } 		 
 
 stringBuffer.append("\"11\" : \""+DFName+" "+DMName+" "+DLName+"\"");
 stringBuffer.append(",");
 stringBuffer.append("\"12\" : \"-\"");
 stringBuffer.append(",");
 
 if(dgResultDetail.getSampleCollectionHeader().getOrder().getOrderNo() != null){ 
	 stringBuffer.append("\"13\" : \"OP Clinic\"");
 }else{
	 stringBuffer.append("\"13\" : \"-\"");
 }
 	stringBuffer.append("}");
	
	
if(counter!=patientListResult.size()-1)
		stringBuffer.append(",");

 counter++;
	}
  }

stringBuffer.append("]");
}
%>

<%=stringBuffer.toString() %>

