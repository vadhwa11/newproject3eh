<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Object[]> dgSampleCollDtList = new ArrayList<Object[]>();
		Patient patient = new Patient();

		DgSampleCollectionHeader dgSampleCollHeader = new DgSampleCollectionHeader();
		
		MasSubChargecode subChargeCode = new MasSubChargecode();
		//DgMasInvestigation dgMasInvestigation = new DgMasInvestigation();
		Integer resultEntryIndex = 0;
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
			dgSampleCollDtList= (List<Object[]>)patientMap.get("patientList");
		}
		List<DgSampleCollectionDetails> collectionDetails=null;
		if(dgSampleCollDtList.size() > 0 ){
			dgSampleCollHeader = (DgSampleCollectionHeader)dgSampleCollDtList.get(resultEntryIndex)[0];
			patient = ((DgSampleCollectionHeader)dgSampleCollDtList.get(resultEntryIndex)[0]).getHin();
			subChargeCode = (MasSubChargecode)dgSampleCollDtList.get(resultEntryIndex)[1];
			 
			collectionDetails=new ArrayList<DgSampleCollectionDetails>(dgSampleCollHeader.getDgSampleCollectionDetails());
		}
		
		
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>

<%@page import="jkt.hms.masters.business.DgMasInvestigation"%><script type="text/javascript" language="javascript">

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=dgSampleCollHeader.getId()%>,<%=subChargeCode.getId()%>"
/*
 * Code is changed By Mukesh
 * Previous Code is on the behalf of subchargeCodeId But Now this is replaced by investigation is
 * Date 18 Apr 2011
 */
data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(dgSampleCollHeader.getOrder().getOrderDate())%>"
<%for(DgSampleCollectionDetails details: collectionDetails){
		if(subChargeCode.getId()==details.getSubcharge().getId()){%>
			data_arr[<%= counter%>][2] = "<%=details.getSubcharge().getSubChargecodeCode()+"/"+details.getDiagNo()%>"
<%}}%>
data_arr[<%= counter%>][3] = "<%=dgSampleCollHeader.getOrder().getOrderTime()%>"
<%if(patient.getServiceNo()!=null){%>
data_arr[<%= counter%>][4] = "<%=patient.getServiceNo()%>"
<%}else{%>
data_arr[<%= counter%>][4] = "";
<%}%>
<%
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
%>
data_arr[<%= counter%>][5] = "<%=pName%>"
<%}else{%>
data_arr[<%= counter%>][5] = "-"
<%}%>
<%
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

	} %>
	
	<% if(patient.getRank() != null){
		detailToDisplay = detailToDisplay + patient.getRank().getRankName();
	}
	%>
			
		data_arr[<%= counter%>][6] = "<%=detailToDisplay%> <%=sName%>"
	
	<%}else{%>
		data_arr[<%= counter%>][6] = "-"
<%}%>
data_arr[<%= counter%>][7] = "<%=patient.getHinNo()%> "
data_arr[<%= counter%>][8] = "" 

<%if(patient != null && patient.getAge()!=null){%>
data_arr[<%= counter%>][9] = "<%=patient.getAge()%> "
<%}else{%>
data_arr[<%= counter%>][9] ="-"
<%}%>

<%if(patient != null){%>
data_arr[<%= counter%>][10] = "<%=patient.getSex().getAdministrativeSexName()%> "
<%}else{%>
data_arr[<%= counter%>][10] = "-"
<%}%>

<%if(dgSampleCollHeader.getOrder() != null){%>
data_arr[<%= counter%>][11] = "<%=dgSampleCollHeader.getOrder().getPatientType()%> "
<%}else{%>
data_arr[<%= counter%>][11] ="-"
<%}%>

<%if(dgSampleCollHeader.getOrder().getDepartment() != null){%>
data_arr[<%= counter%>][12] = "<%=dgSampleCollHeader.getOrder().getDepartment().getDepartmentName()%> "
<%}else{%>
data_arr[<%= counter%>][12] = "-"
<%}%>

	<%if(dgSampleCollHeader.getOrder().getPrescribedBy()!= null){
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
			%>

			data_arr[<%= counter%>][13] = "<%=name%>"
		<%}else{%>
			data_arr[<%= counter%>][13] = "-"
		<%}%>

data_arr[<%= counter%>][14] = "<%=patient.getId()%> "

<%if (dgSampleCollHeader != null){%>
data_arr[<%= counter%>][15] = "<%=dgSampleCollHeader.getId()%> "
<%}else{%>
data_arr[<%= counter%>][15] = "-"
<%}%>

<%if (subChargeCode != null){ %>
data_arr[<%= counter%>][16] = "<%=subChargeCode.getSubChargecodeName()%> "
<%}else{%>
data_arr[<%= counter%>][16] = "-"
<%}%>

<%if (subChargeCode != null){ %>
data_arr[<%= counter%>][17] = "<%=subChargeCode.getId()%> "
<%}else{%>
data_arr[<%= counter%>][17] = "-"
<%}%>
data_arr[<%= counter%>][18] = "Male Medical Ward"
data_arr[<%= counter%>][19] = "Pending For Result Entry"
	<% 
	String status="";
	if("u".equalsIgnoreCase(dgSampleCollHeader.getOrder().getRoutineUrgentStatus())){
		status="Urgent";
	}else{
		status="Routine";
	}
	%>
data_arr[<%= counter%>][20] = "<%=status%>"  
</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
