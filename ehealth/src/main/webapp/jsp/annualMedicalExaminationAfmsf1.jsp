<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>

<div id="contentspace"><script type="text/javascript">
	function checkAfmsfReceipt(){

	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("lastUnit").value==0){
			errMsg=errMsg+"Select Last Unit \n"
		}
		
		if(errMsg==""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
	</script> <script type="text/javascript" language="javascript">
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
		
		
	</script> <script type="text/javascript">
	function validateAME() {
	medCatId = document.getElementById("medCatId").value
	var errMsg=""
	if(medCatId ==0)
	 errMsg="Please select Medical category \n"
		boardDate = document.getElementById("boardDate").value
		nextReview = document.getElementById("nextReview").value
	   	boardDate = new Date(boardDate.substring(6),(boardDate.substring(3,5) - 1) ,boardDate.substring(0,2));
	 	nextReview = new Date(nextReview.substring(6),(nextReview.substring(3,5) - 1) ,nextReview.substring(0,2));
		if(boardDate > nextReview)
	 	{
	 	errMsg =errMsg+"Next Review date must be greater than Last AME/Board "
			
	 	}
		
		 if(errMsg !=""){
		 alert(errMsg)
		 return false;
		 }
		  return true;
}
	</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>

<div class="titleBg">
<h2>Annual Medical Examination</h2>
</div>
<div class="Block">
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box = HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	String serviceNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> employeeList = null;
			 	List<Object>empAfmsfDetList=null;
			 	List<MasRank>rankList=null;
				List<MasUnit>unitList=null;
			 		
			 	
			 	if (map.get("employeeList") != null) {
			 		employeeList = (List<Object>) map.get("employeeList");
			 		
			 	}
			 	if (map.get("empAfmsfDetList") != null) {
			 		empAfmsfDetList = (List<Object>) map.get("empAfmsfDetList");
			 		
			 	}
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 		
			 	}
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 		
			 	}
			 	if (map.get("serviceNo") != null) {
			 		serviceNo = (String) map.get("serviceNo");
			 		
			 	}
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<% } %>
<form name="annualMedicalExamination" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" title="Fill Service No. first."
	value="" class="textbox_date" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('annualMedicalExamination','/hms/hms/mis?method=getResponceForAME&serviceNo='+this.value,'deficientId');" />

<div id="deficientId">
<h4>Details</h4>
<label>Rank:</label><input type="text" name="<%=RANK %>" id="name" value="" MAXLENGTH="30" validate="Name,String,Yes" />
<label>Name:</label> <input type="text" name="<%=NAME %>" id="name" value="" MAXLENGTH="30"	validate="Name,String,Yes" />
<label>Trade:</label> <input type="text" name="<%=TRADE_ID%>" id="name" value="" MAXLENGTH="30" validate="Name,String,Yes" />
<div class="clear"></div>
<label>Parent Unit:</label> <input type="text" name="<%=UNIT_ID%>" id="name" value="" MAXLENGTH="30" validate="Name,String,Yes" />
<label><span>*</span>Medical Category:</label> <select>
	<option value="0">Select</option>
</select>
<label>Period</label> <select>
	<option value="P">Permanent</option>
	<option value="T">Temporary</option>
</select>
<div class="clear"></div>
<label><span>*</span>Last AME/Board:</label> <input type="text" name="<%=LAST_BOARD%>" id="name" value=""
	class="date" MAXLENGTH="30" validate="Name,String,Yes" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.annualMedicalExamination.<%=LAST_BOARD%>,event)" />

<label><span>*</span>Next Review:</label> <input
	type="text" name="<%=NEXT_REVIEW%>" id="name" value=""
	class="date" MAXLENGTH="30" validate="Name,String,Yes" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.annualMedicalExamination.<%=NEXT_REVIEW%>,event)" />

<div class="clear"></div>
</div>


<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="button" name="edit" value="Submit" class="button"
	onClick="if(validateAME()){submitForm('annualMedicalExamination','mis?method=editAfmsfAnnualMedicalExamination');}" />
<div id="edited"></div>

</form>
</div>
</div>





