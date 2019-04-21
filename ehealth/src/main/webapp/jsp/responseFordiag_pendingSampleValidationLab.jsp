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

<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
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
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		
		List<Object[]> patientDeatilList = new ArrayList<Object[]>();
		List<DgSampleCollectionHeader>  radioQueuelList=new ArrayList<DgSampleCollectionHeader>();
		
		List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String message = "";
		String deptType = "";
		MasHospital masHospital = null;
		int currentLabId = 0;
		int userId = 0;
		
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		
		
		if(patientMap.get("patientDeatilList") != null){
			patientDeatilList= (List<Object[]>)patientMap.get("patientDeatilList");
		}
		
		if(patientMap.get("radioQueuelList") != null){
			radioQueuelList= (List<DgSampleCollectionHeader>)patientMap.get("radioQueuelList");
		}
		
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
		if (map.get("deptType") != null) {
			deptType = (String) map.get("deptType");
		}
		List<MasSample> sampleList = new ArrayList<MasSample>();
		if (detailsMap.get("sampleList") != null) {
			sampleList = (List<MasSample>) detailsMap.get("sampleList");
		}
		List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
		if (detailsMap.get("investigationList") != null) {
			investigationList = (List<DgMasInvestigation>) detailsMap.get("investigationList");
		} 
		if(detailsMap.get("subChargeCodeList") != null){
			subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
		}
		
		int subGroupId=0;
		if (map.get("subGroupId") != null) {
			subGroupId = (Integer) map.get("subGroupId");
		}
		 String pFirstName="",barcodetext="";
		 if(map.get("pFirstName") !=null){
			 pFirstName=(String)map.get("pFirstName");
			}
		
			if(map.get("barcodetext") !=null){
				barcodetext=(String)map.get("barcodetext");
} 
%>


<%
String patientName = "";
String doctorName = "";
String age = "";
String sex = "";
String hinNo = "";
String diagNo = "";

    int  counter=0;
   
    List<DgSampleCollectionHeader> dgHeader=new ArrayList<DgSampleCollectionHeader>();
	StringBuffer stringBuffer = new StringBuffer();
	if (patientDeatilList != null && patientDeatilList.size() > 0) {
		stringBuffer.append("[");
		outerloop:	
			for(int ilop=0;ilop<patientDeatilList.size();ilop++) {
				
			DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
			dgHeader.add(dgSampleCollectionHeader);
			
			
			Patient patient = dgSampleCollectionHeader.getHin();
			 if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
				continue;
			}  
			
			Set<DgOrderdt> set = new HashSet<DgOrderdt>();
			set = dgSampleCollectionHeader.getOrder().getDgOrderdts();
			boolean onePamentisDone=false;
			 for(DgOrderdt orderDt : set){
				 
				if(("IP".equalsIgnoreCase(orderDt.getOrderhd().getPatientType()))){
					onePamentisDone=true;
					
				}else if(!"A".equalsIgnoreCase(orderDt.getOrderStatus()) && (!"IP".equalsIgnoreCase(orderDt.getOrderhd().getPatientType()))){
					onePamentisDone=true;
				} 
				
			if(orderDt.getBill() != null){
				BlOpBillHeader  billHeader = orderDt.getBill();
				if(billHeader.getHin() != null ){
				patientName=billHeader.getHin().getPFirstName();
				age=billHeader.getHin().getAge();
				if(age==null){
					age="";
				}
				sex=billHeader.getHin().getSex().getAdministrativeSexName();
				hinNo=billHeader.getHin().getHinNo();
				}else {
					patientName=billHeader.getPatientName();
					age=billHeader.getAge();
					if(age==null){
						age="";
					}
					sex=billHeader.getSex().getAdministrativeSexName();
					hinNo="-";
				}
				}else{
					DgOrderhd  orderhd = orderDt.getOrderhd();
					if(orderhd.getHin() != null){
						patientName=orderhd.getHin().getPFirstName();
						age=orderhd.getHin().getAge();
						if(age==null){
							age="";
						}
						sex=orderhd.getHin().getSex().getAdministrativeSexName();
						hinNo=orderhd.getHin().getHinNo();
					}
				}
			}
			 
			 if(!onePamentisDone){
					continue outerloop;
				}
	%>
	
	<%
		stringBuffer.append("{");
		stringBuffer.append("\"0\" : \""+dgSampleCollectionHeader.getId()+","+((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId()+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"1\" : \""+HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionHeader.getDiagnosisDate())+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"2\" : \""+dgSampleCollectionHeader.getDiagnosisTime()+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"3\" : \""+hinNo+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"4\" : \"2154\"");
		stringBuffer.append(",");
		stringBuffer.append("\"5\" : \""+patientName+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"6\" : \""+dgSampleCollectionHeader.getDepartment().getDepartmentName()+"\"");
		stringBuffer.append(",");
		
		if(dgSampleCollectionHeader.getHin().getAge()==null){
			age="";
		}
		stringBuffer.append("\"7\" : \""+age+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"8\" : \""+dgSampleCollectionHeader.getHin().getSex().getAdministrativeSexName()+"\"");
		stringBuffer.append(",");
		
		if(dgSampleCollectionHeader.getOrder().getPrescribedBy() !=null){
			doctorName=dgSampleCollectionHeader.getOrder().getPrescribedBy().getEmployeeName(); 
		} 
		stringBuffer.append("\"9\" : \""+doctorName+"\"");
		stringBuffer.append(",");
		stringBuffer.append("\"10\" : \"Male Medical Ward\"");
		stringBuffer.append(",");
		stringBuffer.append("\"11\" : \"\"");
		
		for(DgSampleCollectionDetails details: dgSampleCollectionHeader.getDgSampleCollectionDetails()){
			if(details.getRejected()!=null){//added by govind 20-06-2017
			}else{
			if(((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId()==details.getSubcharge().getId()){
			diagNo="-"; 
				if(details.getDiagNo()!=null){ 
					diagNo=details.getDiagNo();
				}
				stringBuffer.append(",");
				stringBuffer.append("\"12\" : \""+details.getSubcharge().getSubChargecodeCode()+"/"+diagNo+"\"");	
	   }}}
		
		stringBuffer.append("}");
			
		if(ilop!=patientDeatilList.size()-1)
				stringBuffer.append(",");
			
		}	
	}	
	%>

	<%
	
	int ilop =0;
	if(radioQueuelList.size()>0){
		
		for(DgSampleCollectionHeader radioQueue:radioQueuelList) {
			ilop++;
			dgHeader.add(radioQueue);
			Patient patient = radioQueue.getHin();
			 if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
				continue;
			}  
			boolean onePamentisDone=false;
			
				if(("IP".equalsIgnoreCase(radioQueue.getOrder().getPatientType()))){
					onePamentisDone=true;
					
				}
			
					DgOrderhd  orderhd = radioQueue.getOrder();
			if(orderhd.getHin() != null){
						patientName=orderhd.getHin().getPFirstName();
						age=orderhd.getHin().getAge();
						if(age==null){
							age="";
						}
						sex=orderhd.getHin().getSex().getAdministrativeSexName();
						hinNo=orderhd.getHin().getHinNo();
			}
	stringBuffer.append("{");
	stringBuffer.append("\"0\" : \""+radioQueue.getId()+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"1\" : \""+HMSUtil.convertDateToStringWithoutTime(radioQueue.getDiagnosisDate())+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"2\" : \""+radioQueue.getDiagnosisTime()+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"3\" : \""+hinNo+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"4\" : \"2154\"");
	stringBuffer.append(",");
	stringBuffer.append("\"5\" : \""+patientName+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"6\" : \""+radioQueue.getDepartment().getDepartmentName()+"\"");
	stringBuffer.append(",");
	
	if(radioQueue.getHin().getAge()==null){
		age="";
	}
	stringBuffer.append("\"7\" : \""+age+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"8\" : \""+radioQueue.getHin().getSex().getAdministrativeSexName()+"\"");
	stringBuffer.append(",");
	
	if(radioQueue.getOrder().getPrescribedBy() !=null){
		doctorName=doctorName.concat(radioQueue.getOrder().getPrescribedBy().getEmployeeName()+" "); 
	} 
	stringBuffer.append("\"9\" : \""+doctorName+"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"10\" : \"Male Medical Ward\"");
	stringBuffer.append(",");
	stringBuffer.append("\"11\" : \"\"");
	stringBuffer.append(",");
	stringBuffer.append("\"12\" : \"\"");
	stringBuffer.append("}");
	
	if(ilop!=patientDeatilList.size())
		stringBuffer.append(",");
	
	
	}	
		
		stringBuffer.append("]");
		
   } else if(patientDeatilList != null && patientDeatilList.size() > 0) {

		stringBuffer.append("]");
   }
	

	session.setAttribute("patientDeatilList",dgHeader);
	session.setAttribute("patientDeatilList1",patientDeatilList);
	
	%>
<%=stringBuffer.toString() %>

