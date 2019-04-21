<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.MortuaryRegisterDetails"%>
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
		
		String CurrentDate=date+"/"+month+"/"+year;
		%>
		serverdate = '<%=date+"/"+month+"/"+year%>'		
</script>
<%
String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");

Map<String, Object> map=new HashMap<String, Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String ,Object>)request.getAttribute("map");
}

List<MortuaryRegisterDetails> mortuaryDetails=new ArrayList<MortuaryRegisterDetails>();
if(map.get("mortuaryDetails") !=null){
	mortuaryDetails =(List) map.get("mortuaryDetails");
}

%>


<div class="titleBg">
<h4>Waiting Mortuary</h4>
</div>

<div class="clear"></div>
<div class="Block">
<div id="pageNavPosition"></div>
<%
		if(mortuaryDetails.size()>0){
		%>

<table id="tableId">
<tr>
	<th>S.No</th>
	<th>Patient</th>
	<th>UHID ID</th>
	<th>Mortuary Regd. Date</th>
	<th>Status</th>
	
</tr>

<%int count=1; 
	for(MortuaryRegisterDetails mortuaryList : mortuaryDetails){ %>
	
		<form method="post" name="mortuaryDetails<%=count %>">
		<input type="hidden" name="patiientWiseMlcId" value="<%=(mortuaryList.getPatientWiseMlc()!=null && mortuaryList.getPatientWiseMlc().getId()!=null)?mortuaryList.getPatientWiseMlc().getId():"" %>" />
		<input type="hidden" name="hinId" value="<%=(mortuaryList.getPatientWiseMlc()!=null && mortuaryList.getPatientWiseMlc().getHin()!=null && mortuaryList.getPatientWiseMlc().getHin().getId()!=null)?mortuaryList.getPatientWiseMlc().getHin().getId():"" %>" />
		<input type="hidden" name="mortuaryRegdDetailId" value="<%=(mortuaryList.getId()!=null)?mortuaryList.getId():"" %>" />
		<tr onclick="submitForm('mortuaryDetails<%=count %>', 'mlc?method=showPostmortemExaminationJsp')">
		    <td><%=count %></td>
			<td><%=(mortuaryList.getPatientWiseMlc()!=null && mortuaryList.getPatientWiseMlc().getHin()!=null &&  mortuaryList.getPatientWiseMlc().getHin().getFullName()!=null)?mortuaryList.getPatientWiseMlc().getHin().getFullName():"" %></td>
			<td><%=(mortuaryList.getPatientWiseMlc()!=null && mortuaryList.getPatientWiseMlc().getHin()!=null && mortuaryList.getPatientWiseMlc().getHin().getHinNo()!=null)?mortuaryList.getPatientWiseMlc().getHin().getHinNo():"" %></td>
			<td><%=(mortuaryList.getMortuaryRegDate()!=null)?mortuaryList.getMortuaryRegDate():""%></td>
			<td><%=(mortuaryList.getPostmortemStatus()!=null)?mortuaryList.getPostmortemStatus():"" %></td>
		</tr> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
		<%++count;
		%>
		
		<%}%>
	</table>
	
	 <%}else{%>
	 <h2>No Records Available</h2>
	    <%} %>
	</table>
	</div>
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	
   <div class="clear"></div>
 <div class="clear"></div>