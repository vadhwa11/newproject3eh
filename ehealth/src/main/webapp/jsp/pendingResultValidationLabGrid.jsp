<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
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
<script type="text/javascript" language="javascript">

		  		data_arr[<%= counter%>] = new Array();
		  		data_arr[<%= counter%>][0] = "<%=stringOfIds%>@<%=stringOfSubDeptIds%>"
				data_arr[<%= counter%>][1] = "<%=dgResultDetail.getResultNo()%>"
				data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(dgResultDetail.getResultDate())%>"
				<%for(DgResultEntryDetail dgResultEntryDetail:dgResultEntryDetailList){
					if(stringOfIds.contains(dgResultEntryDetail.getResultEntry().getId()+"")){%>
					  data_arr[<%= counter%>][3] ="<%=dgResultEntryDetail.getSampleCollectionDetails().getSubcharge().getSubChargecodeCode()+"/"+dgResultEntryDetail.getSampleCollectionDetails().getDiagNo()%>"
							<%--data_arr[<%= counter%>][3] ="<%=sampleId%>"--%>
				<%}}%>
						<%--data_arr[<%= counter%>][3] ="<%=sampleId%>";--%>
				data_arr[<%= counter%>][4] = "<%=dgResultDetail.getResultTime()%>"
				<%if(patient.getServiceNo()!=null){%>
				
				data_arr[<%= counter%>][5] = "<%=patient.getServiceNo()%>"
				<%}else{%>
				data_arr[<%= counter%>][5]=""
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
				data_arr[<%= counter%>][6] = "<%=pName%>"
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
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
							
						data_arr[<%= counter%>][7] = "<%=detailToDisplay%> <%=sName%>"
					
					<%}else{%>
						data_arr[<%= counter%>][7] = "-"
				<%}%>
								data_arr[<%= counter%>][8] = "<%=patient.getHinNo()%> "
								data_arr[<%= counter%>][9] = "121"
				
				<%if(dgResultDetail.getHin() != null && dgResultDetail.getHin().getAge()!=null){%>
				data_arr[<%= counter%>][10] = "<%=dgResultDetail.getHin().getAge()%> "
				<%}else{%>
				data_arr[<%= counter%>][10] = "-"
				<%}%>
				
				data_arr[<%= counter%>][11] = "<%=dgResultDetail.getHin().getSex().getAdministrativeSexName()%> "
				
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][12] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getPatientType()%> "
				<%}else{%>
				data_arr[<%= counter%>][12] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder()!= null){%>
				data_arr[<%= counter%>][13] = "<%=dgResultDetail.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%> "
				<%}else{%>
				data_arr[<%= counter%>][13] = "-"
				<%}%>
				<%if(dgResultDetail.getSampleCollectionHeader().getOrder().getPrescribedBy()!= null){
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
					
				%>
				data_arr[<%= counter%>][14] = "<%=name%>"
				<%}else{%>
				data_arr[<%= counter%>][14] = "-"
				<%}%>
				
				data_arr[<%= counter%>][15] = "<%=dgResultDetail.getId()%>"
				
				<%
				if(dgResultDetail.getSampleCollectionHeader().getDiagnosisDate() != null){%>
				data_arr[<%= counter%>][16] = "<%=dgResultDetail.getSampleCollectionHeader().getDiagnosisDate()%>"
				<%}else{%>
				data_arr[<%= counter%>][16] ="-"
				<% } %>

				<%
				if(dgResultDetail.getSubChargecode() != null){%>
				data_arr[<%= counter%>][17] = "<%=dgResultDetail.getSubChargecode().getSubChargecodeName()%>"
				<%}else{%>
				data_arr[<%= counter%>][17] ="-"
				<% } %>
				data_arr[<%= counter%>][18] ="Male Medical Ward"
					<% 
					String status="";
					if("u".equalsIgnoreCase(dgResultDetail.getSampleCollectionHeader().getOrder().getRoutineUrgentStatus())){
						status="Urgent";
					}else{
						status="Routine";
					}
					%>
				//details.getSubcharge().getSubChargecodeCode()+"/"+details.getDiagNo()
				data_arr[<%= counter%>][19] ="<%=status%>"
				
				

</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
