
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
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
		String userName = "";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<PatientWiseMlc> mlcList = new ArrayList<PatientWiseMlc>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("mlcList")!=null){
			mlcList=(List<PatientWiseMlc>)map.get("mlcList");
		}
		
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		

</script>


<div class="titleBg">
<h2>Waiting List Of POSTMORTEM CERTIFICATE	</h2>
</div>
<div class="clear"></div>
<div class="Block">


<div id="pageNavPosition"></div>
<%if(mlcList.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Patient</th><th>HIN NO</th><th>Status</th></tr>
<tbody id="tableData">
	<% 
		 int  counter=0; 
 		for(PatientWiseMlc mlcDetail:mlcList){ 
	%> 
			<form name="mlc<%= counter+1%>" method="post">
			<input type="hidden" name="requestId" value="<%=mlcDetail.getOpdPatientDetail().getId()%>" />
			<%if(mlcDetail.getHin()!=null) {%>
			<input type="hidden" name="visitId" value="<%=mlcDetail.getHin()%>" />
				<input type="hidden" name="hinId" value="<%=mlcDetail.getHin().getId()%>" />
			<%}else{%>
			<input type="hidden" name="visitId" value="<%=mlcDetail.getInpatient().getHin()%>" />
				<input type="hidden" name="hinId" value="<%=mlcDetail.getInpatient().getHin().getId()%>" />
			<%} %>
				<tr onclick="submitForm('mlc<%=counter+1%>', 'mlc?method=showPostMartemCertificate')">
			<td><%= counter+1%></td>
			<%if(mlcDetail.getHin()!=null) {%>   
		    <td><%= mlcDetail.getHin().getFullName()!=null ? mlcDetail.getHin().getFullName():""%></td>
		     <%}else{%>
		      <td><%= mlcDetail.getInpatient().getHin()!=null ?mlcDetail.getInpatient().getHin().getFullName():""%></td>
		      <%} %>
		    
		 	<%if(mlcDetail.getHin()!=null) {%>   
		<td><%= mlcDetail.getHin().getHinNo()!=null ? mlcDetail.getHin().getHinNo():""%></td>
		   <%}else{%>
		   <td><%= mlcDetail.getInpatient().getHin()!=null ? mlcDetail.getInpatient().getHin().getId():""%></td>
		   <%} %>
		    <%if( mlcDetail.getStatus().equalsIgnoreCase("A")){ %>
		    	  <td> Not Authorized </td>
		   <%     }
		      else{%>
		       <td><%= mlcDetail.getStatus()!=null ? mlcDetail.getStatus():""%></td>		
		     <% } %>
		    
		    </tr>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%		++counter;
				} 
 	%> 
 	</tbody>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	
	
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	</div>
   <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>