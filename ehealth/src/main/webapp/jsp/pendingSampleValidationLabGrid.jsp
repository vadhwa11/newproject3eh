<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%
		int pageNo=1;
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<DgSampleCollectionDetails> dgSampleCollDtList = new ArrayList<DgSampleCollectionDetails>();
		Patient patient = new Patient();
		DgSampleCollectionDetails dgsampleDetails = new DgSampleCollectionDetails();
		Map<String,Object> orderDetailMap = new HashMap<String,Object>();
		
		Integer resultEntryIndex = 0;
		String requestFlag = "";
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
		if(patientMap.get("patientDeatilList") != null){
			dgSampleCollDtList= (List<DgSampleCollectionDetails>)patientMap.get("patientDeatilList");
		}
		
		if(dgSampleCollDtList.size() > 0 ){

			dgsampleDetails = dgSampleCollDtList.get(resultEntryIndex);
			patient = dgsampleDetails.getSampleCollectionHeader().getHin();
		}
		
	%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript">
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%= dgsampleDetails.getSampleCollectionHeader().getId()%>,<%=dgsampleDetails.getSubcharge().getId()%>"
			data_arr[<%= counter%>][1] = "<%= HMSUtil.convertDateToStringWithoutTime(dgsampleDetails.getSampleCollectionHeader().getDiagnosisDate())%>"
			data_arr[<%= counter%>][2] = "<%= dgsampleDetails.getSampleCollectionHeader().getDiagnosisTime()%>"

			data_arr[<%= counter%>][3] = "<%=patient.getServiceNo()%>"
			
						<%
				if(patient.getRank() != null){
				%>
				data_arr[<%= counter%>][4] = "<%=patient.getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][4] = ""
				<%}	%>
				
				
			
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
						
					data_arr[<%= counter%>][5] = "<%=detailToDisplay%> <%=sName%>"
				
				<%}else{%>
					data_arr[<%= counter%>][5] = ""
				<%} %>
				
	           	data_arr[<%= counter%>][6] = "<%=patient.getServiceType().getServiceTypeName()%> "
				data_arr[<%= counter%>][7] = "<%=patient.getHinNo()%>"
				
				<% 
				String pName = patient.getPFirstName();
				if(patient.getPMiddleName() != null){ 
					pName = pName + " " + patient.getPMiddleName(); 
				} 
				if(patient.getPLastName() != null){ 
					pName = pName + " " + patient.getPLastName();
				}
				
				%>
				data_arr[<%= counter%>][8] = "<%=pName%>"
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
				detailToDisplay = sName;
				
				if(patient.getRelation() != null){ 
					detailToDisplay = patient.getRelation().getRelationName() +" of ";
				} %>
				
				<% if(patient.getRank() != null){
					detailToDisplay = detailToDisplay + patient.getRank().getRankName();
				}
				%>
						
					data_arr[<%= counter%>][9] = "<%=detailToDisplay%> <%=sName%>"
				
				<%}else{%>
					data_arr[<%= counter%>][9] = ""
				<%} %>
				
				<%
				if(dgsampleDetails.getSampleCollectionHeader().getOrderByDepartment() != null){
				%>
					data_arr[<%= counter%>][10] = "<%=dgsampleDetails.getSampleCollectionHeader().getOrderByDepartment().getDepartmentName()%> "
				
				<%}%>
				<%
				if(dgsampleDetails.getSubcharge() != null){
				%>
					data_arr[<%= counter%>][11] = "<%=dgsampleDetails.getSubcharge().getSubChargecodeName()%> "
				
				<%}%>

</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
