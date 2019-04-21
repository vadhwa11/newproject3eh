<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : pendingSampleValidation.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author    Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
--%>
<%@page import="jkt.hms.masters.business.PharmacyLabQueue"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript"> 
$(document).ready(function() {  
    var chars = []; 
    $(window).keypress(function(e) {  
    	console.log("Barcode Scanned: " + e.which);
        if (e.which >= 48 && e.which <= 57) { 
            chars.push(String.fromCharCode(e.which)); 
        } 
        if (e.which===13) { 
            setTimeout(function(){
                if (chars.length >= 1) {
                    var barcode = chars.join("");
                    console.log("Barcode Scanned: " + barcode);
                    $("#barcode").val(barcode);
                    $("#addbutton").click();
                }
                chars = [];
            },500); 
        }
       
    });
});
$("#barcode").keypress(function(e){  
    if ( e.which === 13 ) {
        console.log("Prevent form submit.");
        e.preventDefault();
    }
});

</script>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<form name="patientSearch" action="" method="post">
	<script type="text/javascript" language="javascript">
	<%
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
	function forUnregister(val){
	if(val == "2"){
	 document.getElementById('hinId').disabled = true ;
	 document.getElementById('adId').disabled = true ;
	 document.getElementById('departmentId').disabled = true; 
              
	}else{
	document.getElementById('hinId').disabled = false;
	document.getElementById('adId').disabled = false;
	document.getElementById('departmentId').disabled = false; 
	}
	}
	</script>
	<%   
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
		String userName = "";
		String message = "";
		String deptType = "";
		
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
		
		 String pFirstName="",barcodetext="",sampleIdSearch="";
		 if(map.get("pFirstName") !=null){
			 pFirstName=(String)map.get("pFirstName");
			}
		
			if(map.get("barcodetext") !=null){
				barcodetext=(String)map.get("barcodetext");
			}
			if(map.get("sampleIdSearch") !=null){
				sampleIdSearch=(String)map.get("sampleIdSearch");
			}
			 String hinNo1="";
			 if(map.get("hinNo") !=null){
				 hinNo1=(String)map.get("hinNo");
				}
			 String fromDate="",toDate="";
			 if(map.get("fromDate") !=null){
				 fromDate=(String)map.get("fromDate");
				}
				if(map.get("toDate") !=null){
					toDate = (String)map.get("toDate");
				}
	%>
	<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			
		<%}
	%>
	</script>
	<div class="clear"></div>
	<% if(deptType.equalsIgnoreCase("DIAG")){ %>
	<div class="titleBg">
		<h2>Pending for Sample Validation</h2>
	</div>
	<%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
	<div class="titleBg">
		<h2>Acceptance for Radiological Investigations</h2>
	</div>
	<%} %>
	<div class="clear"></div>
	<h4>Patient Search</h4>
	<div class="clear"></div>
	<div class="Block">
		<div class="clear"></div>
		<label><span>*</span> From Date</label> <input type="text"
			class="date" id="fromDateId" name="<%=FROM_DATE %>"
			value="<%=!fromDate.equals("")?fromDate:currentDate %>" readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,no"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />
		<label><span>*</span> To Date</label> <input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=!toDate.equals("")?toDate:currentDate %>" class="date"
			readonly="readonly" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date,date,no"
			onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input
			id="hinId" type="text" name="<%=HIN_NO %>" value="<%=!hinNo1.equals("")?hinNo1:"" %>" MAXLENGTH="50" onkeypress="return searchKeyPress(event);"/>
		<div class="clear"></div>
		<label>Patient Type</label> <select name="<%=PATIENT_TYPE%>">
			<option value="OP">OP</option>
			<option value="IP">IP</option>
		</select> <label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input
			id="adId" type="text" name="<%=AD_NO %>" value=""
			class="textbox_size20" MAXLENGTH="50" /> <label>Ward</label> <input
			type="text" name="<%=WARD_NAME%>" value="" MAXLENGTH="15" />
		<div class="clear"></div>

		<label>Patient Name</label> <input type="text"
			name="<%=P_FIRST_NAME %>" value="<%=!pFirstName.equals("")?pFirstName:"" %>" MAXLENGTH="15" onkeypress="return searchKeyPress(event);"/> <label>Mobile
			No</label> <input type="text" name="<%=MOBILE_NO%>" value="" MAXLENGTH="15" />
		<input type="hidden" name="<%=BARCODE%>" value="" MAXLENGTH="15"
			id="barcode" />
		
		<%-- <label>Sample</label>
		<select name="sampleName" id="sampleId">
		<option value="0">Select</option>
		<%for(MasSample sample:sampleList){ %>
		<option value="<%=sample.getId()%>"><%=sample.getSampleDescription() %></option>
		<%} %>
		</select> 
 		--%>
 		<label>Priority</label> <select id="priorityId"
			name="priorityId">
			<option value="0">Select</option> 
			<option value="r">Routine</option>
			<option value="u">Urgent</option> 
		</select> 
		<div class="clear"></div>
 		<label>Investigation</label>
		<select name="invName" class="multiple" id="invId" multiple="multiple" size="8">
		<option value="0">Select</option>
		<%for(DgMasInvestigation inv:investigationList){ %>
		<option value="<%=inv.getId()%>"><%=inv.getInvestigationName() %></option>
		<%} %>
		</select>
		<label>Modality</label> <select id="subChargeCodeId" name="<%=SUB_CHARGECODE_ID %>">
			<%if(subGroupId!=0){ %>			
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>" selected="selected"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>			
			<%}%>
		<%} else {%>
		<option value="0" selected="selected">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>" ><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>			
			<%}%>
		<%} %>
		</select>
		<div class="clear"></div>
		<%-- <label>BarCode Scan</label> <input type="text" name="barcodetext" value="<%=!barcodetext.equals("")?barcodetext:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
		<label>Sample ID</label> <input type="text" name="sampleId" value="<%=!sampleIdSearch.equals("")?sampleIdSearch:"" %>" MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/> --%>
	</div>
	<div class="clear"></div>
	<input type="button" name="save" id="addbutton"
		onclick="submitForm('patientSearch','/hms/hms/lab?method=searchPatientForValidation');"
		value="Search" class="button" accesskey="a" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
	<div id="searchtable" tabindex="2"></div>
	<form name="pendingSampleValidation" method="post" action="">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
	<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
		type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	<script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"diagDate"],[2,"diagTime"], [3,"hin"],[4,"ipNo"], [5,"patName"],[6,"orderBy"],
			[7,"age"],[8,"sex"],[9,"doctorName"],[10,"ward"],[11,"priority"],[12,"sampleId"]];
	 statusTd = 5;
	</script>

</form>
</div>
<script type="text/javascript" language="javascript"> 
	
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Token No."
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "priority"

data_header[1] = new Array;
data_header[1][0] = "Time"
data_header[1][1] = "hide";
data_header[1][2] = "7%";
data_header[1][3] = "diagTime"

data_header[2] = new Array;
data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "hin";

data_header[3] = new Array;
data_header[3][0] = "IP No"
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "ipNo";

data_header[4] = new Array;
data_header[4][0] = "Patient Name"
data_header[4][1] = "data";
data_header[4][2] = "20%";
data_header[4][3] = "patName";

data_header[5] = new Array;
data_header[5][0] = "Order By"
data_header[5][1] = "hide";
data_header[5][2] = "20%";
data_header[5][3] = "orderBy"; 

data_header[6] = new Array;
data_header[6][0] = "Age"
data_header[6][1] = "data";
data_header[6][2] = "20%";
data_header[6][3] = "age";

data_header[7] = new Array;
data_header[7][0] = "Gender"
data_header[7][1] = "data";
data_header[7][2] = "20%";
data_header[7][3] = "sex";

data_header[8] = new Array;
data_header[8][0] = "Doctor Name"
data_header[8][1] = "data";
data_header[8][2] = "20%";
data_header[8][3] = "doctorName";

data_header[9] = new Array;
data_header[9][0] = "Ward"
data_header[9][1] = "hide";
data_header[9][2] = "20%";
data_header[9][3] = "ward";

data_header[10] = new Array;
data_header[10][0] = "Date"
data_header[10][1] = "data";
data_header[10][2] = "7%";
data_header[10][3] = "diagDate";

data_header[11] = new Array;
data_header[11][0] = "Order No"
data_header[11][1] = "data";
data_header[11][2] = "20%";
data_header[11][3] = "orderNo";

data_arr = new Array();
	<%
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	    int  counter=0;
	    List<DgSampleCollectionHeader> dgHeader=new ArrayList<DgSampleCollectionHeader>();
		if (patientDeatilList != null && patientDeatilList.size() > 0) { 
			outerloop:	
				for(int ilop=0;ilop<patientDeatilList.size();ilop++) {
				DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
				dgHeader.add(dgSampleCollectionHeader);
				Patient patient = dgSampleCollectionHeader.getHin();
				
				hinNo = patient.getHinNo();
				age = patient.getAge();
				sex = patient.getSex().getAdministrativeSexName();
				patientName = patient.getPFirstName()+" "+((patient.getPMiddleName()!=null)?patient.getPMiddleName():"")+" "+((patient.getPLastName()!=null)?patient.getPLastName():""); 
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
				/* if(orderDt.getBill() != null){
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
					} */
				}
				 if(!onePamentisDone){
						continue outerloop;
					}
		
		%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] ="<%= dgSampleCollectionHeader.getId()%>,<%=((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId()%>"
			data_arr[<%= counter%>][11] = "<%= HMSUtil.convertDateToStringWithoutTime(dgSampleCollectionHeader.getDiagnosisDate())%>"
			data_arr[<%= counter%>][2] = "<%= dgSampleCollectionHeader.getDiagnosisTime()%>" 
			data_arr[<%= counter%>][3] = "<%=hinNo%>"
			
			data_arr[<%= counter%>][4] = "2154"
			data_arr[<%= counter%>][5] = "<%=patientName%>"
				<%
				if(dgSampleCollectionHeader.getDepartment().getDepartmentName() != null){
					
			%>
			data_arr[<%= counter%>][6] = "<%=dgSampleCollectionHeader.getDepartment().getDepartmentName()%> "
			<%}%>
			<%if(dgSampleCollectionHeader.getHin().getAge()==null){
				age="";
			}%>
			data_arr[<%= counter%>][7] = "<%= age%>"
			data_arr[<%= counter%>][8] = "<%= dgSampleCollectionHeader.getHin().getSex().getAdministrativeSexName()%>"
				<%String doctorName="";
			 if(dgSampleCollectionHeader.getOrder().getPrescribedBy() !=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getEmployeeName()+" "); 
			} 
			/* if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()+" ");
			}if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName());
			}   */
			%>
			data_arr[<%= counter%>][9] = "<%=doctorName%>"
			data_arr[<%= counter%>][10] = "Male Medical Ward" 
				<% 
				String status="";
				if("u".equalsIgnoreCase(dgSampleCollectionHeader.getOrder().getRoutineUrgentStatus())){
					status="Urgent";
				}else if("r".equalsIgnoreCase(dgSampleCollectionHeader.getOrder().getRoutineUrgentStatus())){
					status="Routine";
				}
				if(null !=dgSampleCollectionHeader.getPharmacyLabQueueId()){
				%>
<%-- 				data_arr[<%= counter%>][1] = "<%=dgSampleCollectionHeader.getPharmacyLabQueueId().getTokenNo()%>"
 --%>				<%}else{%>
				
		<%-- 		data_arr[<%= counter%>][1] = ""
 --%>
					<%} %>
					<%-- for(DgSampleCollectionDetails details: dgSampleCollectionHeader.getDgSampleCollectionDetails()){
						if(details.getRejected()!=null){//added by govind 20-06-2017
						}else{
						if(((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId()==details.getSubcharge().getId()){
						String diagNo="-"; 
							if(details.getDiagNo()!=null){ 
								diagNo=details.getDiagNo();
							}%>
					data_arr[<%= counter%>][12] = "<%=details.getSubcharge().getSubChargecodeCode()+"/"+diagNo%>" --%>
				<%-- <%}}}%>  --%>
				data_arr[<%= counter%>][12] = "<%=dgSampleCollectionHeader.getOrder().getOrderNo()%>";
			
                <%
					     counter++;
			    	}	
				}
		
		if(radioQueuelList.size()>0){
			
			//outerloop1:
				for(DgSampleCollectionHeader radioQueue:radioQueuelList) {
					
				//DgSampleCollectionHeader dgSampleCollectionHeader=(DgSampleCollectionHeader)patientDeatilList.get(ilop)[0];
				dgHeader.add(radioQueue);
				Patient patient = radioQueue.getHin();
				 if(RequestConstants.UHID_FOR_QUALITY_TESTING.equals(patient.getHinNo())){
					continue;
				}  
				/* Set<DgOrderhd> set = new HashSet<DgOrderhd>();
				set = radioQueue.getDgSampleCollectionHd().getOrder(); */
				
				boolean onePamentisDone=false;
				// for(DgOrderdt orderDt : set){
					if(("IP".equalsIgnoreCase(radioQueue.getOrder().getPatientType()))){
						onePamentisDone=true;
						
					}
					/* else if(!"A".equalsIgnoreCase(orderDt.getOrderStatus()) && (!"IP".equalsIgnoreCase(orderDt.getOrderhd().getPatientType()))){
						onePamentisDone=true;
					}  */
				/* if(orderDt.getBill() != null){
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
					} *///else{
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
					//}
				//}
				 /* if(!onePamentisDone){
						continue outerloop1;
					} */
		
		%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] ="<%= radioQueue.getId()%>"
			data_arr[<%= counter%>][11] = "<%= HMSUtil.convertDateToStringWithoutTime(radioQueue.getDiagnosisDate())%>"
			data_arr[<%= counter%>][2] = "<%= radioQueue.getDiagnosisTime()%>" 
			data_arr[<%= counter%>][3] = "<%=hinNo%>"
			
			data_arr[<%= counter%>][4] = "2154"
			data_arr[<%= counter%>][5] = "<%=patientName%>"
				<%
				if(radioQueue.getDepartment().getDepartmentName() != null){
					
			%>
			data_arr[<%= counter%>][6] = "<%=radioQueue.getDepartment().getDepartmentName()%> "
			<%}%>
			<%if(radioQueue.getHin().getAge()==null){
				age="";
			}%>
			data_arr[<%= counter%>][7] = "<%= age%>"
			data_arr[<%= counter%>][8] = "<%= radioQueue.getHin().getSex().getAdministrativeSexName()%>"
				<%String doctorName="";
			 if(radioQueue.getOrder().getPrescribedBy() !=null){
				doctorName=doctorName.concat(radioQueue.getOrder().getPrescribedBy().getEmployeeName()+" "); 
			} 
			/* if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getMiddleName()+" ");
			}if(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName()!=null){
				doctorName=doctorName.concat(dgSampleCollectionHeader.getOrder().getPrescribedBy().getLastName());
			}   */
			%>
			data_arr[<%= counter%>][9] = "<%=doctorName%>"
			data_arr[<%= counter%>][10] = "Male Medical Ward" 
				<% 
				String status="";
				if("u".equalsIgnoreCase(radioQueue.getOrder().getRoutineUrgentStatus())){
					status="Urgent";
				}else if("r".equalsIgnoreCase(radioQueue.getOrder().getRoutineUrgentStatus())){
					status="Routine";
				}
				%>
				data_arr[<%= counter%>][1] = "<%= radioQueue.getPharmacyLabQueueId().getTokenNo()%>" 
					data_arr[<%= counter%>][12] = "" 
					<%for(DgSampleCollectionDetails details: radioQueue.getDgSampleCollectionDetails()){%>
						//<%-- <%-- if(((MasSubChargecode)patientDeatilList.get(ilop)[1]).getId()==details.getSubcharge().getId()){
						//String diagNo="-"; 
						//	if(details.getDiagNo()!=null){ 
						//		diagNo=details.getDiagNo();
						//	}//
						<%-- //	data_arr[<%= counter%>][12] = "<%=details.getSubcharge().getSubChargecodeCode()+"/"+diagNo%>" --%> 
				<%-- //<%}  --%>
				<%}%> 
					<%
					     counter++;
			    	}	
				
		}
				%>
				<%session.setAttribute("patientDeatilList",dgHeader);%>
				<%session.setAttribute("patientDeatilList1",patientDeatilList);%>//added by govind 3-11-2016
		    formName = "pendingSampleValidation";
			
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	makeTable(start,end);
	
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('addbutton').click();
			return false;
		}
		return true;
	}
		
	</script>
