<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
map = (Map) request.getAttribute("map");
}
List<Object[]>previousDetailList = new ArrayList<Object[]>();
List<Object[]>previousPrescriptionList = new ArrayList<Object[]>();
List<Object[]>previousInvestigationList = new ArrayList<Object[]>();
List<Object[]>previousDiagnosisList = new ArrayList<Object[]>();
List<Object[]>previousProcedureList = new ArrayList<Object[]>();

Map<Date, String> previousInvestigationHashMap =null;
if(map.get("previousInvestigationHashMap")!=null){
	previousInvestigationHashMap = (Map<Date, String>)map.get("previousInvestigationHashMap");
} 
if(map.get("previousDetailList")!=null){
	previousDetailList = (List<Object[]>)map.get("previousDetailList");
} 
if(map.get("previousPrescriptionList")!=null){
	previousPrescriptionList = (List<Object[]>)map.get("previousPrescriptionList");
} 
if(map.get("previousInvestigationList")!=null){
	previousInvestigationList = (List<Object[]>)map.get("previousInvestigationList");
} 
if(map.get("previousDiagnosisList")!=null){
	previousDiagnosisList = (List<Object[]>)map.get("previousDiagnosisList");
} 
if(map.get("previousProcedureList")!=null){
	previousProcedureList = (List<Object[]>)map.get("previousProcedureList");
} 







%>




<div class="summaryDivMain">
<label>Previous Complaints</label>
<%
String preComplaindateWise = "";
String history = "";
String systemicExamination = "";
String findings = "";
int preHeight = 0;
String preWeight = "";
String prePulse = "";
String preBP = "";
String preInvestigation = "";
String prePrecription = "";
String preDiagnosis = "";
String preProcedure = "";
String preComplain = "";
String procedureDone = "";
String opdRemarks = "";
String opdReview = "";
if(previousDetailList.size()>0){
for(Object[] patientHistory :previousDetailList){

Date opdDate = (Date)patientHistory[0];
if(patientHistory[1] != null && !patientHistory[1].equals("")){
	preComplain = (String)patientHistory[1];
}
if(!preComplain.equals("")){

preComplaindateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
preComplaindateWise += " --  "+ preComplain+"<div class='clear'></div>";
}
history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
if(patientHistory[2] != null && !patientHistory[2].equals("")){
	history += "Past History--"+(String)patientHistory[2]+"<div class='clear'></div>";
}
if(patientHistory[3] != null && !patientHistory[3].equals("")){
	history += "Family History--"+(String)patientHistory[3]+"<div class='clear'></div>";
}
if(patientHistory[4] != null && !patientHistory[4].equals("")){
	history += "Medication History--"+(String)patientHistory[4]+"<div class='clear'></div>";
}
if(patientHistory[5] != null && !patientHistory[5].equals("")){
	history += "History of Past Illness--"+(String)patientHistory[5]+"<div class='clear'></div>";
}
if(patientHistory[6] != null && !patientHistory[6].equals("")){
	history += "History of Menstrual and Obstetric--"+(String)patientHistory[6]+"<div class='clear'></div>";
}
if(patientHistory[7] != null && !patientHistory[7].equals("")){
	systemicExamination += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
	systemicExamination+=(String)patientHistory[7]+"<div class='clear'></div>";
}
if(patientHistory[8] != null && !patientHistory[8].equals("")){
	findings += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
	findings+="Local Examination--"+(String)patientHistory[8]+"<div class='clear'></div>";
}
if(patientHistory[9] != null && !patientHistory[9].equals("")){
	findings+="General Examination--"+(String)patientHistory[9]+"<div class='clear'></div>";
}

/* if(patientHistory[10] != null && ((Integer)patientHistory[10])!=0){
	findings+="Vitals: Height-"+(Double)patientHistory[10];
} 
if(patientHistory[11] != null && ((Double)patientHistory[11])!=0){
	findings+="weight-"+(Double)patientHistory[11];
}*/
if(patientHistory[12] != null && ((Integer)patientHistory[12])!=0){
	findings+="Pulse-"+(Integer)patientHistory[12];
}
if(patientHistory[13] != null && !patientHistory[13].equals("")){
	findings+="BP-"+(String)patientHistory[13];
}
if(patientHistory[14] != null && !patientHistory[14].equals("")){
	findings+="P/S-"+(String)patientHistory[14]+"<div class='clear'></div>";
}
if(patientHistory[15] != null && !patientHistory[15].equals("")){
	findings+="P/V-"+(String)patientHistory[15]+"<div class='clear'></div>";
}
if(patientHistory[16] != null && !patientHistory[16].equals("")){
	findings+="P/R-"+(String)patientHistory[16]+"<div class='clear'></div>";
}
if(patientHistory[17] != null && !patientHistory[17].equals("")){
	findings+="Smear Collection-"+(((String)patientHistory[17]).equalsIgnoreCase("y")?"Yes":"No")+"<div class='clear'></div>";
}
 
/* 	if(patientHistory[18] != null && !patientHistory[18].equals("")){
	preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
	preDiagnosis+="Other Diagnosis--"+(String)patientHistory[18]+"<div class='clear'></div>";
} */

if(patientHistory[19] != null && !patientHistory[19].equals("")){
	opdRemarks += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
	opdRemarks +=(String)patientHistory[19]+"<div class='clear'></div>";
}
if(patientHistory[25] != null && !patientHistory[25].equals("")){
	opdReview += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
	opdReview +=(String)patientHistory[25]+"<div class='clear'></div>";
}

if(patientHistory[21] != null && !patientHistory[21].equals("")){
	procedureDone += (String)patientHistory[21]+"<div class='clear'></div>";
}
if(patientHistory[22] != null && !patientHistory[22].equals("")){
	preProcedure += "Treatment --"+(String)patientHistory[22]+"<div class='clear'></div>";
}

if(patientHistory[23] != null && !patientHistory[23].equals("")){
	history += "History of Development--"+(String)patientHistory[23]+"<div class='clear'></div>";
}

if(patientHistory[24] != null && !patientHistory[24].equals("")){
	history += "History of Diet--"+(String)patientHistory[24]+"<div class='clear'></div>";
}
/* if(patientHistory[25] != null && !patientHistory[25].equals("")){
	//opdRemarks += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
	opdRemarks +=(String)patientHistory[25]+"<div class='clear'></div>";
} */
}}

if(previousInvestigationHashMap!=null && previousInvestigationHashMap.size()>0){
	for (Map.Entry<Date, String> prevInves : previousInvestigationHashMap.entrySet())
	{
		preInvestigation+=  HMSUtil.convertDateToStringTypeDateOnly(prevInves.getKey())+" "+prevInves.getValue()+"<div class='clear'></div>";
	}
	/* Date visitDate =null;
	for(Object[] inves :previousInvestigationList){
		 visitDate = (Date)inves[0];
		preInvestigation += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
		if(inves[1] != null && !inves[1].equals("")){
			preInvestigation += (String)inves[1]+"<div class='clear'></div>";
		}
		
	} */
	
}



if(previousPrescriptionList.size()>0){
for(Object[] pres :previousPrescriptionList){
Date visitDate = (Date)pres[0];
prePrecription += HMSUtil.convertDateToStringTypeDateOnly(visitDate)+"<div class='clear'></div>";
if(pres[1] != null && !pres[1].equals("")){
	prePrecription += (String)pres[1];
}
/* if(pres[2] != null && !pres[2].equals("")){
	prePrecription += (String)pres[2];
} */
if(pres[3] != null && !pres[3].equals("")){
	prePrecription += " | "+(Float)pres[3];
}
/* if(pres[4] != null && !pres[4].equals("")){
	prePrecription += (String)pres[4];
}
if(pres[5] != null && ((Integer)pres[5])!=0){
	prePrecription += (Integer)pres[5];
}
if(pres[6] != null && !pres[6].equals("")){
	prePrecription += (String)pres[6];
} */
prePrecription +="<div class='clear'></div>";
}}
System.out.println("previousDiagnosisList"+previousDiagnosisList);
if(previousDiagnosisList.size()>0){
for(Object[] diag :previousDiagnosisList){
Date visitDate = (Date)diag[0];
preDiagnosis += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
if(diag[1] != null && !diag[1].equals("")){
	preDiagnosis += (String)diag[1]+"<div class='clear'></div>";
}

}}

if(previousProcedureList.size()>0){
for(Object[] proc :previousProcedureList){
Date visitDate = (Date)proc[0];
preProcedure += HMSUtil.convertDateToStringTypeDateOnly(visitDate);
if(proc[1] != null && !proc[1].equals("")){
	preProcedure +="Procedure--"+ (String)proc[1]+"<div class='clear'></div>";
}

}}
		
  %>
	<div class="summaryDetails"><p><%=preComplaindateWise %></p></div>
			
			</div>
			
			<div class="summaryDivMain">
			<label>History</label>
			<div class="summaryDetails"><p><%=history %></p></div>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			<div class="summaryDivMain">
			<label>Systemic Examination</label>
			<div class="summaryDetails"><p><%=systemicExamination %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Findings</label>
			<div class="summaryDetails"><p><%=findings%></p></div>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			<div class="summaryDivMain">
			<label>Investigations</label>
			<div class="summaryDetails"><p><%=preInvestigation %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Prescription</label>
			<div class="summaryDetails"><p><%=prePrecription %></p></div>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			<div class="summaryDivMain">
			<label>Diagnosis</label>
			<div class="summaryDetails"><p><%=preDiagnosis %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Treatment</label>
			<div class="summaryDetails"><p><%=preProcedure %></p></div>
			</div>
			<div class="clear"></div>
			<div class="paddingTop5"></div>
			
			<div class="summaryDivMain">
			<label>Previous Ip Details</label>
			<div class="summaryDetails"><p></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Procedure done</label>
			<div class="summaryDetails"><p><%=procedureDone %></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>Remarks</label>
			<div class="summaryDetails"><p><%=opdRemarks%></p></div>
			</div>
			
			<div class="summaryDivMain">
			<label>OPD Review</label>
			<div class="summaryDetails"><p><%=opdReview%></p></div>
			</div>
			<div class="clear"></div>

<div class="clear"></div>
