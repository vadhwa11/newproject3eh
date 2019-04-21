
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>

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
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		List<ExpiryDetails> discharges=new ArrayList<ExpiryDetails>();
		if(map.get("discharge")!=null){
			 discharges=(List<ExpiryDetails>)map.get("discharge");
		}
		List<OpdPatientDetails> patientDetails=new ArrayList<OpdPatientDetails>();
		if(map.get("opdPatientDetails")!=null){
			patientDetails=(List<OpdPatientDetails>)map.get("opdPatientDetails");
		} 
		/* List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>(); 
		if(map.get("mlcList")!=null){
			mlcList=(List<OpdPatientDetails>)map.get("mlcList");
		}
		List<PatientWiseMlc> patWise = new ArrayList<PatientWiseMlc>();
		if(map.get("patWise")!=null){
			patWise=(List<PatientWiseMlc>)map.get("patWise");
		} */
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		

</script>



<div class="titleBg">
	<h2>Waiting MLC</h2>
</div>

<div class="clear"></div>
<div id="divTest">
	<form name="mortuarySearch" method="post">
		<div class="Block">
			<label><span>*</span> UHID</label> <input name="uhin" id="uhin"
				validate="UHID,string,yes" /> <input type="button" value="Search"
				onclick="submitProtoAjaxWithDivName('mortuarySearch','/hms/hms/adt?method=getMortuaryList','divTest');" />
			<input type="reset" name="Reset" id="reset" value="Reset" />
		</div>
		<div class="clear"></div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
	<form name="withoutMlc" method="post">
		<div class="Block">


			<div id="pageNavPosition"></div>
			<table id="tableId">
				<tr>
					<th>S.No</th>
					<th>Patient</th>
					<th>UHID ID</th>
					<th>OP/IP</th>  
					<th></th>
				</tr>

				<%
Set<Integer> set=new HashSet<Integer>();
   int i=1;
if(discharges.size()>0 || patientDetails.size()>0){ %>
				<tbody id="tableData">
					<%     
 		for(ExpiryDetails discharge:discharges){ 
  			 
 		%>
					<tr>

						<td><input type="hidden" name="requestId<%=i%>"
							value="<%=discharge.getId()%>" /> <%=i%></td>

						<td>
						<%=discharge.getHin()!=null &&  discharge.getHin().getFullName()!=null ? discharge.getHin().getFullName():""%>
						</td>
						<td>
						<%=discharge.getHin()!=null &&  discharge.getHin().getHinNo()!=null ? discharge.getHin().getHinNo():""%>
						</td>
						<td>IP</td>   
						<td><input type="button" value="ok"
							onclick="tdValue(<%=discharge.getId()%>,'IP',<%=discharge.getHin().getId() %>,<%=i%>)" /></td>
					</tr>

					<%		++i;
} 
 		 
 	%>
		<%	for(OpdPatientDetails patientDetail:patientDetails){ 
  			 
 		%>
					<tr>

						<td><input type="hidden" name="requestId<%=i%>"
							value="<%=patientDetail.getId()%>" /> <%=i%></td>

						<td>
						<%=patientDetail.getVisit().getHin()!=null &&  patientDetail.getVisit().getHin().getFullName()!=null ? patientDetail.getVisit().getHin().getFullName():""%>
						</td>
						<td>
						<%=patientDetail.getVisit().getHin()!=null &&  patientDetail.getVisit().getHin().getHinNo()!=null ? patientDetail.getVisit().getHin().getHinNo():""%>
						</td>
						<td>OP</td>   
						<td><input type="button" value="ok"
							onclick="tdValue(<%=patientDetail.getId()%>,'OP',<%=patientDetail.getVisit().getHin().getId() %>,<%=i%>)" /></td>
					</tr>

					<%		++i;
} 
 		 
 	%>

				</tbody>
			</table>
			<%}else{ %>
			No Records Available.
			<%} %>
		</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
	</form>
</div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>

<div class="clear"></div>
<div class="clear"></div>
<div class="bottom">
	<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
		Date:</label> <label class="value"><%=currentDate%></label> <label>Changed
		Time:</label> <label class="value"><%=currentTime%></label>
</div>
<!--Block Two Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" /> <input
		type="hidden" name="lastChgDate" value="<%=currentDate%>" /> <input
		type="hidden" name="lastChgTime" value="<%=currentTime%>" />
</div>


<script type="text/javascript">
function tdValue(id,pType,hinId,i) { 
	if(pType=="OP"){
	 submitForm('withoutMlc','mlc?method=showMortuaryRegisterJsp&opdPatientDetailId='+id+'&pType='+pType+'&hinId='+hinId+'&numberId='+hinId);
	}else{
		submitForm('withoutMlc','mlc?method=showMortuaryRegisterJsp&dischargeId='+id+'&pType='+pType+'&hinId='+hinId+'&numberId='+hinId);
	}
	}

</script>

