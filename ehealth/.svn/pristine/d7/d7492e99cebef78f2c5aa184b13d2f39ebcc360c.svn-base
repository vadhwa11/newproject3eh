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
List<Object[]>prescriptionList = new ArrayList<Object[]>();
List<Object[]>investigationList = new ArrayList<Object[]>();
List<Object[]>diagnosisList = new ArrayList<Object[]>();
List<Object[]>procedureList = new ArrayList<Object[]>();

if(map.get("previousDetailList")!=null){
	previousDetailList = (List<Object[]>)map.get("previousDetailList");
} 
if(map.get("prescriptionList")!=null){
	prescriptionList = (List<Object[]>)map.get("prescriptionList");
} 
if(map.get("investigationList")!=null){
	investigationList = (List<Object[]>)map.get("investigationList");
} 
if(map.get("diagnosisList")!=null){
	diagnosisList = (List<Object[]>)map.get("diagnosisList");
} 
if(map.get("procedureList")!=null){
	procedureList = (List<Object[]>)map.get("procedureList");
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
if(previousDetailList.size()>0){
	for(Object[] patientHistory :previousDetailList){
		Date opdDate = (Date)patientHistory[0];
		String preComplain = (String)patientHistory[1];
		if(!preComplain.equals("")){
		
		preComplaindateWise += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
		preComplaindateWise += " --  "+ preComplain+"<div class='clear'></div>";
		}
		history += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
		if(patientHistory[2] != null && !patientHistory[2].equals("")){
			history += "Personal History--"+(String)patientHistory[2]+"<div class='clear'></div>";
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
			systemicExamination += HMSUtil.convertDateToStringTypeDateOnly(opdDate);
			systemicExamination+=(String)patientHistory[6]+"<div class='clear'></div>";
		}
		if(patientHistory[7] != null && !patientHistory[7].equals("")){
			findings += HMSUtil.convertDateToStringTypeDateOnly(opdDate)+"<div class='clear'></div>";
			findings+="Local Examination--"+(String)patientHistory[7]+"<div class='clear'></div>";
		}
		if(patientHistory[8] != null && !patientHistory[8].equals("")){
			findings+="General Examination--"+(String)patientHistory[8]+"<div class='clear'></div>";
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
<div class="summaryDetails"><p><%=findings %></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Investigations</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Prescription</label>
<div class="summaryDetails"><p></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Diagnosis</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="summaryDivMain">
<label>Treatment</label>
<div class="summaryDetails"><p></p></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div class="summaryDivMain">
<label>Previous Ip Details</label>
<div class="summaryDetails"><p></p></div>
</div>

<div class="clear"></div>
