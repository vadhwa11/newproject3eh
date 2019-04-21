<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasPhysiotherapyHeader"%>
<%@page import="jkt.hms.masters.business.MasPhysiotherapyDetail"%>


<script
	type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	 month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>

<!--  <script type="text/javascript" src="/hms/jsp/js/ddaccordion.js">

	/***********************************************
	* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
	* This notice must stay intact for legal use
	***********************************************/

	</script>-->
<script type="text/javascript">


	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: true, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})


	</script>

<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> mapForDS= new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String consultationDate = (String)utilMap.get("currentDate");
		String consultationTime = (String)utilMap.get("currentTime");
		int hospitalId=0;int deptId=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		
		if (session.getAttribute("deptId") != null) {
			deptId = (Integer) session.getAttribute("deptId");
		}
		
		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}
		String deptName="";
		if(map.get("deptName") != null){
			deptName=(String)map.get("deptName");
			}
		List<MasPhysiotherapyHeader> headerList = new ArrayList<MasPhysiotherapyHeader>();
		List<MasPhysiotherapyDetail> detailList = new ArrayList<MasPhysiotherapyDetail>();
		List<Visit> visitList = new ArrayList<Visit>();
		if(map.get("visitList") != null){
			visitList=(List<Visit>)map.get("visitList");
			}
		if(map.get("headerList") != null){
			headerList=(List<MasPhysiotherapyHeader>)map.get("headerList");
			}
		if(map.get("detailList") != null){
			detailList=(List<MasPhysiotherapyDetail>)map.get("detailList");
			}
		MasPhysiotherapyHeader header = new MasPhysiotherapyHeader();
		Visit visit=(Visit)visitList.get(0);
		if(headerList.size()>0){
		 header = (MasPhysiotherapyHeader)headerList.get(0);
		}
		String patientName="";
		if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
		}
		if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
		}
		if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
		}
		String modality_name="";
		String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
%>
<form name="opdMain" action="" method="post"><input type="hidden"
	name="userName" value="<%=userName %>" />
<div class="titleBg">
<h2><%=deptName%></h2>
</div>
<%
				if(map.get("message") != null){
				   String message = (String)map.get("message");
			  }
		    %>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%if(visit.getHin().getHinNo()!= null){ %> <label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %> <label>Patient
Name </label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %> <label class="valueMedium"><%=visit.getHin().getAge() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %> <label
	class="medium">Visit Date </label> <%if(visitDateInString != null){ %> <label
	class="valueMedium"><%=visitDateInString %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class=""><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Phone No.</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valueMedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %> <label
	class="medium">Mobile No.</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valueMedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label>Consulting Doctor</label> <%
String doctorName="";
 if(visit.getDoctor()!=null)
 {
	doctorName = visit.getDoctor().getFirstName();
	if(visit.getDoctor().getMiddleName()!=null)
	{
		doctorName = doctorName+" "+visit.getDoctor().getMiddleName();
	}
	if(visit.getDoctor().getLastName()!=null)
	{

		doctorName = doctorName+" "+visit.getDoctor().getLastName();
	}
 }
 String physioName="";
 if(header.getPhysiotherapistId()!=null){
	 physioName=header.getPhysiotherapistId().getFirstName();
	 if(header.getPhysiotherapistId().getMiddleName()!=null){
		 physioName=physioName+" "+header.getPhysiotherapistId().getMiddleName();
	 }
	 if(header.getPhysiotherapistId().getLastName()!=null){
		 physioName=physioName+" "+header.getPhysiotherapistId().getLastName();
	 }
 }
 int inc=1;
%> <label class="value"><%=doctorName%></label> <label class="medium">Prev.
Diag </label> <%if(visit.getDiagnosis()!= null){ %> <label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <input type="hidden"
	name="visitId" value="<%=visit.getId()%>" /> <input type="hidden"
	name="<%=HIN_NO%>" value="<%=visit.getHin().getId()%>" />
<div class="clear"></div>
</div>
<%if(headerList.size()>0){ %>
<div class="Block">
<div class="clear"></div>
<label> Physiotherapist Name</label><%if(header.getPhysiotherapistId()!=null){ %> 
<label class="valueMedium"><%=physioName%></label>
<input type="hidden" value="<%=header.getPhysiotherapistId().getId()%>" id="physio" name="physio"/>
<%}else{%>
<label class="valueMedium">-</label>
<%} %>
<label>H/O & Examination</label><label class="valueMedium"><%=header.getHoexamination()%></label>
<label>Plan of care & Goals</label><label class="valueMedium"><%=header.getPlanGoals()%></label>
</div>
<div class="clear"></div>
<table border="0" width="50%" align="center" cellpadding="0"
	cellspacing="0" id="tblSample">
	<tr>
	<!--<th style="width: 40px" > Repeat</th>
		--><th> Modality Name</th>
		<th>Remarks</th>
	</tr>
	<%
	
   for(MasPhysiotherapyDetail detail : detailList)
   {
%>
	<tr>
	<!--<td><input style="width: 40px" type="checkbox" id="check" onclick="changeType()"></input></td>
	  --><%
	   if(detail.getModalityCode()!=null){ 
		   modality_name = "MODALITY"+detail.getModalityCode();
	   }
	   %>	   
		<td><%=modality_name%>
		<input type="hidden"  id="moda<%=inc%>" value="<%=detail.getModalityCode()%>"></input></td>
		<td><%=detail.getModalityRemarks()%>
		<input type="hidden" value="<%=detail.getModalityRemarks()%>" name="remarks" id="remarks<%=inc%>"></input></td>
	</tr>
	<%inc++;}
	%>
	<input type="hidden" value="<%=inc%>" name="hiddenValue" id="hiddenValue"></input>
</table>
<div class="clear"></div>
<label>Prognosis Reports</label> <%=header.getPrognosisReports()%>
<div class="clear"></div>
<input type="button" class="button" value="Repeat" name="submit" id="submit" onclick="getData(opdMain)"/>
<%}else{ %>
<h4>----No Data Found----</h4>
<%} %>
<input type="button" class="button" value="Back" onclick="history.back()"/>
<input type="button" class="button" value="Close" onclick="window.close()"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>
<script>

function getData(formName){
	//window.opener.document.getElementById('physiotherapistNameId').value=document.getElementById('physio').value;;
	 window.opener.document.getElementById('hoExaminationId').value="<%=header.getHoexamination()%>";
	 window.opener.document.getElementById('plancaregoalsId').value="<%=header.getPlanGoals()%>";
	 window.opener.document.getElementById('prognosisReportsId').value="<%=header.getPrognosisReports()%>";
	 var loopc= window.opener.document.getElementById('hidvalId').value;
	 var loopd= parseInt(document.getElementById('hiddenValue').value)-1;
	 if(loopc==loopd){
	 for(var i=1;i<=loopd;i++){
	 window.opener.document.getElementById('modalityNameId'+i).value=document.getElementById('moda'+i).value;
	 window.opener.document.getElementById("remarksId"+i).value=document.getElementById('remarks'+i).value;
	 }
	 }else{
		 if(loopd>loopc){
	var loope=parseInt(loopd)-parseInt(loopc);
	for (var j=0;j<loope;j++){
	window.opener.addRow();
		}
		 for(var i=1;i<=loopd;i++){
			 window.opener.document.getElementById('modalityNameId'+i).value=document.getElementById('moda'+i).value;
			 window.opener.document.getElementById("remarksId"+i).value=document.getElementById('remarks'+i).value;
			 }
		 }else if(loopc>loopd){
			 var loopf=parseInt(loopc)-parseInt(loopd);
				for (var j=0;j<loopf;j++){
				window.opener.removeRow();
					}
					 for(var i=1;i<=loopd;i++){
						 window.opener.document.getElementById('modalityNameId'+i).value=document.getElementById('moda'+i).value;
						 window.opener.document.getElementById("remarksId"+i).value=document.getElementById('remarks'+i).value;
						 }
			 }
		 }
	 window.close();
}
</script>

