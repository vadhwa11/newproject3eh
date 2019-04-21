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
		List<Object[]> dgSampleCollDtList = new ArrayList<Object[]>();
		Patient patient = new Patient();

		DgSampleCollectionHeader dgSampleCollHeader = new DgSampleCollectionHeader();
		
		MasSubChargecode subChargeCode = new MasSubChargecode();
		MasChargeCode chargeCode = new MasChargeCode();
		Integer resultEntryIndex = 0;
		Integer counter = 0;
		List<Object[]> patientList = new ArrayList<Object[]>();

		
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
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Object[]>)patientMap.get("patientList");
		}
		
		if(patientMap.get("patientList") != null){
			dgSampleCollDtList= (List<Object[]>)patientMap.get("patientList");
		}
		
		
String patientName = "";
String doctorName = "";
String age = "";
String sex = "";
String hinNo = "";
String diagNo = "";
    
List<DgSampleCollectionHeader> dgHeader=new ArrayList<DgSampleCollectionHeader>();
StringBuffer stringBuffer = new StringBuffer();

List<String> combinedListAll = new ArrayList<String>();
stringBuffer.append("[");
for(int ilop=0;ilop<patientList.size();ilop++) {
	counter++;
	List<DgSampleCollectionDetails> collectionDetails=null;
	if(dgSampleCollDtList.size() > 0 ){
		dgSampleCollHeader = (DgSampleCollectionHeader)dgSampleCollDtList.get(ilop)[0];
		patient = ((DgSampleCollectionHeader)dgSampleCollDtList.get(ilop)[0]).getHin();
		subChargeCode = (MasSubChargecode)dgSampleCollDtList.get(ilop)[1];
		//chargeCode = (MasChargeCode)dgSampleCollDtList.get(ilop)[2];
		 
		collectionDetails=new ArrayList<DgSampleCollectionDetails>(dgSampleCollHeader.getDgSampleCollectionDetails());
	}

	if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(((DgSampleCollectionHeader)patientList.get(ilop)[0]).getHin().getHinNo())){
		 continue;
	}
	combinedListAll.add(((DgSampleCollectionHeader)patientList.get(ilop)[0]).getId()+","+((MasSubChargecode)patientList.get(ilop)[1]).getId());
	
stringBuffer.append("{");
stringBuffer.append("\"0\" : \""+dgSampleCollHeader.getId()+","+subChargeCode.getId()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"1\" : \""+HMSUtil.convertDateToStringWithoutTime(dgSampleCollHeader.getOrder().getOrderDate())+"\"");
stringBuffer.append(",");
for(DgSampleCollectionDetails details: collectionDetails){
	if(subChargeCode.getId()==details.getSubcharge().getId()){
		stringBuffer.append("\"2\" : \""+details.getSubcharge().getSubChargecodeCode()+"/"+details.getDiagNo()+"\"");
		break;
	}
}
stringBuffer.append(",");
stringBuffer.append("\"3\" : \""+dgSampleCollHeader.getOrder().getOrderTime()+"\"");
stringBuffer.append(",");
if(patient.getServiceNo()!=null){
		stringBuffer.append("\"4\" : \""+patient.getServiceNo()+"\"");
}else{
		stringBuffer.append("\"4\" : \"\"");
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
stringBuffer.append("\"5\" : \""+pName+"\"");
}else{
	stringBuffer.append("\"5\" : \"-\"");
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
stringBuffer.append("\"6\" : \""+detailToDisplay+" "+sName+"\"");
}else{
	stringBuffer.append("\"6\" : \"-\"");
}
stringBuffer.append(",");
stringBuffer.append("\"7\" : \""+patient.getHinNo()+"\"");
stringBuffer.append(",");
stringBuffer.append("\"8\" : \"\"");
stringBuffer.append(",");
if(patient != null && patient.getAge()!=null){
	stringBuffer.append("\"9\" : \""+patient.getAge()+"\"");
}else{
	stringBuffer.append("\"9\" : \"\"");
}
stringBuffer.append(",");
	
	if(patient.getSex() != null){
	stringBuffer.append("\"10\" : \""+patient.getSex().getAdministrativeSexName()+"\"");
	}else{
		stringBuffer.append("\"10\" : \"\"");
	}
	stringBuffer.append(",");
	if(dgSampleCollHeader.getOrder() != null){
	stringBuffer.append("\"11\" : \""+dgSampleCollHeader.getOrder().getPatientType()+"\"");
	}else{
		stringBuffer.append("\"11\" : \"-\"");
	}
	stringBuffer.append(",");
	if(dgSampleCollHeader.getOrder().getDepartment() != null){
		stringBuffer.append("\"12\" : \""+dgSampleCollHeader.getOrder().getDepartment().getDepartmentName()+"\"");
		}else{
			stringBuffer.append("\"12\" : \"-\"");
		}
	stringBuffer.append(",");

	if(dgSampleCollHeader.getOrder().getPrescribedBy()!= null){
					String FirName="";String midName=""; String lastName="";
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getFirstName()!=null){
						FirName = dgSampleCollHeader.getOrder().getPrescribedBy().getFirstName();
					}
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getMiddleName()!=null){
						midName = dgSampleCollHeader.getOrder().getPrescribedBy().getMiddleName();
					}
					if(dgSampleCollHeader.getOrder().getPrescribedBy().getLastName()!=null){
						lastName = dgSampleCollHeader.getOrder().getPrescribedBy().getLastName();
					}
					String name =FirName+" "+midName+" "+lastName;
			
					stringBuffer.append("\"13\" : \""+name+"\"");
	}else{
		stringBuffer.append("\"13\" : \"-\"");
	}
	
	stringBuffer.append(",");
	stringBuffer.append("\"14\" : \""+patient.getId()+"\"");
	stringBuffer.append(",");
	
	if(dgSampleCollHeader.getId() != null){
		stringBuffer.append("\"15\" : \""+dgSampleCollHeader.getId()+"\"");
	}else{
		stringBuffer.append("\"15\" : \"-\"");
	}
	stringBuffer.append(",");
	
	if(subChargeCode.getId() != null){
		stringBuffer.append("\"16\" : \""+subChargeCode.getSubChargecodeName()+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"17\" : \""+subChargeCode.getId()+"\"");
	}else{
		stringBuffer.append("\"16\" : \"-\"");
		stringBuffer.append(",");
		stringBuffer.append("\"17\" : \"-\"");
	}
	
	stringBuffer.append(",");
	stringBuffer.append("\"18\" : \"Male Medical Ward\"");
	stringBuffer.append(",");
	stringBuffer.append("\"19\" : \"Pending For Result Entry\"");
	stringBuffer.append(",");
	
	String status="";
	if("u".equalsIgnoreCase(dgSampleCollHeader.getOrder().getRoutineUrgentStatus())){
		status="Urgent";
	}else{
		status="Routine";
	}
	
	stringBuffer.append("\"20\" : \""+status+"\"");
	stringBuffer.append("}");
	
	
	if(counter!=patientList.size())
		stringBuffer.append(",");
	
}
stringBuffer.append("]");

if(session.getAttribute("combinedListAll") != null){
	session.removeAttribute("combinedListAll");
	session.setAttribute("combinedListAll",combinedListAll);
}else{
	session.setAttribute("combinedListAll",combinedListAll);
}
%>

<%=stringBuffer.toString() %>

