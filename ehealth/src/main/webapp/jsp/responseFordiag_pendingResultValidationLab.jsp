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

<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>

<% 
int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgResultEntryHeader> patientList = new ArrayList<DgResultEntryHeader>();
		List<String> stringOfSubDeptIdsList = new ArrayList<String>();
		List<String> stringOfIdsList = new ArrayList<String>();

		Patient patient = new Patient();
		DgResultEntryHeader dgResultDetail = new DgResultEntryHeader();
		//DgResultEntryDetail dgResultEntryDetail = new DgResultEntryDetail();
		Map<String,Object> orderDetailMap = new HashMap<String,Object >();
		
		Integer resultEntryIndex = 0;
		String requestFlag = "";
		String stringOfSubDeptIds = "";
		String stringOfIds = "";
		Integer counter = 0;
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(request.getParameter("resultEntryIndex") != null){
			resultEntryIndex = Integer.parseInt(request.getParameter("resultEntryIndex"));
		}
		if(request.getParameter("counter") != null){
			counter = Integer.parseInt(request.getParameter("counter"));
		}
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<DgResultEntryHeader>)patientMap.get("patientList");
		}
		if(patientMap.get("stringOfIdsList") != null){
			stringOfIdsList = (List<String>)patientMap.get("stringOfIdsList");
			
		}
		if(patientMap.get("stringOfSubDeptIdsList") != null){
			stringOfSubDeptIdsList= (List<String>)patientMap.get("stringOfSubDeptIdsList");
			
		}
		//
		//DgResultEntryDetail dgResultEntryDetail=null;
		List<DgResultEntryDetail> dgResultEntryDetailList=new ArrayList<DgResultEntryDetail>();
		List<DgSampleCollectionDetails> collDetList=new ArrayList<DgSampleCollectionDetails>();
		
		DgResultEntryDetail resulEntry=null;
		if(patientList.size() > 0 ){
			dgResultDetail = patientList.get(resultEntryIndex);
			stringOfIds = stringOfIdsList.get(resultEntryIndex);
			stringOfSubDeptIds = stringOfSubDeptIdsList.get(resultEntryIndex);
			//dgResultEntryDetail = dgResultDetail.getDgResultEntryDetails().iterator().next();
			patient = dgResultDetail.getSampleCollectionHeader().getHin();
			dgResultEntryDetailList=new ArrayList<DgResultEntryDetail>(dgResultDetail.getDgResultEntryDetails());
			for(DgResultEntryHeader he:patientList){
				collDetList.addAll(he.getSampleCollectionHeader().getDgSampleCollectionDetails());
			}
		}
		//added by govind 21-06-2017
		//System.out.println("stringOfIds "+stringOfIds+" dgResultEntryDetailList "+dgResultEntryDetailList.size()+" collDetList "+collDetList.size());
		/*DgSampleCollectionDetails colDet=null;
		String sampleId="";
		for(DgSampleCollectionDetails col:collDetList){
			//System.out.println("diagNo "+col.getDiagNo()+" hinId "+col.getSampleCollectionHeader().getHin().getId()+" phinId "+patient.getId());
			if(patient.getId()==col.getSampleCollectionHeader().getHin().getId()){
				sampleId=col.getSubcharge().getSubChargecodeCode()+"/"+col.getDiagNo();
			}
		}
		System.out.println("sampleId "+sampleId);*/
		//added by govind 21-06-2017 end
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>

<%		
String patientName = "";
String doctorName = "";
String age = "";
String sex = "";
String hinNo = "";
String diagNo = "";
List<String> pendingValidationListLabAll = new ArrayList<String>();
StringBuffer stringBuffer = new StringBuffer();

stringBuffer.append("[");


if (patientList.size() > 0){ 
	for(int i = 0; i<patientList.size(); i++){
		  DgResultEntryHeader dgResultEntryHeader =patientList.get(i);
		 System.out.println(dgResultEntryHeader.getHin().getHinNo());  
		  if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(dgResultEntryHeader.getHin().getHinNo())){
			  continue;
		  }
			stringOfIds = stringOfIdsList.get(i);
			stringOfSubDeptIds = stringOfSubDeptIdsList.get(i);
			pendingValidationListLabAll.add(stringOfIds+"@"+stringOfSubDeptIds);
			
			
			dgResultDetail = patientList.get(i);
			stringOfIds = stringOfIdsList.get(i);
			stringOfSubDeptIds = stringOfSubDeptIdsList.get(i);
			//dgResultEntryDetail = dgResultDetail.getDgResultEntryDetails().iterator().next();
			patient = dgResultDetail.getSampleCollectionHeader().getHin();
			dgResultEntryDetailList=new ArrayList<DgResultEntryDetail>(dgResultDetail.getDgResultEntryDetails());
			
stringBuffer.append("{");
stringBuffer.append("\"0\" : \""+stringOfIds+"@"+stringOfSubDeptIds+"\"");
stringBuffer.append(",");
stringBuffer.append("\"1\" : \""+dgResultDetail.getResultNo()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"2\" : \""+HMSUtil.convertDateToStringWithoutTime(dgResultDetail.getResultDate())+"\"");
stringBuffer.append(",");
for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailList){
	if(stringOfIds.contains(dgResultEntryDetail.getResultEntry().getId()+"")){
		stringBuffer.append("\"3\" : \""+dgResultEntryDetail.getSampleCollectionDetails().getSubcharge().getSubChargecodeCode()+"/"+dgResultEntryDetail.getSampleCollectionDetails().getDiagNo()+"\"");
		stringBuffer.append(",");
		break;
	}else{
		stringBuffer.append("\"3\" : \"-\"");
		stringBuffer.append(",");
		break;
	}
}
stringBuffer.append("\"4\" : \""+dgResultDetail.getResultTime()+"\"");
stringBuffer.append(",");
if(patient.getServiceNo()!=null){
		stringBuffer.append("\"5\" : \""+patient.getServiceNo()+"\"");
}else{
		stringBuffer.append("\"5\" : \"\"");
}
stringBuffer.append(",");

if(patient.getPFirstName() != null  && !(patient.getPFirstName().equals(""))){
	String pMiddleName = "";
	String pLastName = "";
	if(patient.getPMiddleName() != null){
		pMiddleName = patient.getPMiddleName();
	}
	if(patient.getPLastName() != null){
		pLastName = patient.getPLastName();
	}
String pName = patient.getPFirstName()+" "+pMiddleName+" "+pLastName;
stringBuffer.append("\"6\" : \""+pName+"\"");
}else{
	stringBuffer.append("\"6\" : \"\"");
}
stringBuffer.append(",");
if(patient.getSFirstName() != null  && !(patient.getSFirstName().equals(""))){
	
	String sMiddleName = "";
	String sLastName = "";
	if(patient.getSMiddleName() != null){
		sMiddleName = patient.getSMiddleName();
	}
	if(patient.getSLastName() != null){
		sLastName = patient.getSLastName();
	}
	String sName = patient.getSFirstName()+" "+sMiddleName+" "+sLastName;
	String detailToDisplay = "";
	
	
	if(patient.getRelation() != null){ 
		if(!patient.getRelation().getRelationCode().equalsIgnoreCase("06") ){
			detailToDisplay = patient.getRelation().getRelationName() +" of ";
		}

	}
	
	if(patient.getRank() != null){
		detailToDisplay = detailToDisplay + patient.getRank().getRankName();
	}
stringBuffer.append("\"7\" : \""+detailToDisplay+" "+sName+"\"");
}else{
	stringBuffer.append("\"7\" : \"-\"");
}
stringBuffer.append(",");
stringBuffer.append("\"8\" : \""+patient.getHinNo()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"9\" : \"121\"");
stringBuffer.append(",");
if(dgResultDetail.getHin() != null && dgResultDetail.getHin().getAge()!=null){
	stringBuffer.append("\"10\" : \""+dgResultDetail.getHin().getAge()+"\"");
}else{
	stringBuffer.append("\"10\" : \"\"");
}
stringBuffer.append(",");
	
	if(patient.getSex() != null){
	stringBuffer.append("\"11\" : \""+patient.getSex().getAdministrativeSexName()+"\"");
	}else{
		stringBuffer.append("\"11\" : \"\"");
	}
	stringBuffer.append(",");
	if(dgResultDetail.getSampleCollectionHeader().getOrder() != null){
	stringBuffer.append("\"12\" : \""+dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()+"\"");
	}else{
		stringBuffer.append("\"12\" : \"-\"");
	}
	stringBuffer.append(",");
	if(dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment() != null){
		stringBuffer.append("\"13\" : \""+dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()+"\"");
		}else{
			stringBuffer.append("\"13\" : \"-\"");
		}
	stringBuffer.append(",");

	if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
		String FirName="";String midName=""; String lastName="";
		if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName()!=null){
		FirName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getFirstName();
		}
		if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName()!=null){
			midName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getMiddleName();
		}
		if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName()!=null){
			lastName=dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy().getLastName();
		}
		String name =FirName+" "+midName+" "+lastName;
			
					stringBuffer.append("\"14\" : \""+name+"\"");
	}else{
		stringBuffer.append("\"14\" : \"-\"");
	}
	
	stringBuffer.append(",");
	stringBuffer.append("\"15\" : \""+dgResultDetail.getId()+"\"");
	stringBuffer.append(",");
	
	if(dgResultDetail.getSampleCollectionHeader().getDiagnosisDate() != null){
		stringBuffer.append("\"16\" : \""+dgResultDetail.getSampleCollectionHeader().getDiagnosisDate()+"\"");
	}else{
		stringBuffer.append("\"16\" : \"-\"");
	}
	stringBuffer.append(",");
	
	if(dgResultDetail.getSubChargecode() != null){
		stringBuffer.append("\"17\" : \""+dgResultDetail.getSubChargecode().getSubChargecodeName()+"\"");
	}else{
		stringBuffer.append("\"17\" : \"-\"");
	}
	
	stringBuffer.append(",");
	stringBuffer.append("\"18\" : \"Male Medical Ward\"");
	stringBuffer.append(",");
	
	String status="";
	if("u".equalsIgnoreCase(dgResultDetail.getSampleCollectionHeader().getOrder().getRoutineUrgentStatus())){
		status="Urgent";
	}else{
		status="Routine";
	}
	
	stringBuffer.append("\"19\" : \""+status+"\"");
	stringBuffer.append("}");
	
	
	if(i!=patientList.size()-1)
		stringBuffer.append(",");
	
}
}
stringBuffer.append("]");

if(session.getAttribute("pendingValidationListLabAll") != null){
	session.removeAttribute("pendingValidationListLabAll");
	session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
}else{
	session.setAttribute("pendingValidationListLabAll",pendingValidationListLabAll);
}
%>

<%=stringBuffer.toString() %>

