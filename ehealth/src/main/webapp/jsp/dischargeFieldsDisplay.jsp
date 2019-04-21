<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.DischargeItemsCategory"%>
<%@page import="jkt.hms.masters.business.DischargeItems"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script>
	<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(date1.length()<2){
	date1="0"+date1;
	}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>


<%	
	String userName = "";
	String date ="";
	String time = "";
	String reply = "";
	Map map = new HashMap();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List dischargeItemsCategoryList = new ArrayList();
	DischargeItemsCategory dischargeItemsCategory = null;
	int inpatientId=0;
	
	if(request.getAttribute("map") != null)
	{
	map = (Map) request.getAttribute("map");
	}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	date = (String)utilMap.get("currentDate");	
	time = (String)utilMap.get("currentTime");
	
	if (map.get("dischargeItemsCategoryList") != null)
	dischargeItemsCategoryList =(List)map.get("dischargeItemsCategoryList");
	
	String admitingIcd="";
	if(map.get("admitingIcd")!=null){
		admitingIcd=(String)map.get("admitingIcd");
	}
	System.out.println("admitingIcd  jsp --->>"+admitingIcd);

	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}

	String advices = "";
	if(map.get("advices")!=null){
		advices=(String)map.get("advices");
	}
	System.out.println("advices  jsp --->>"+advices);
	%>
<%
	String department = null;
	if (request.getParameter("casetype").equals("G"))
	department = "Department: General";
	else if (request.getParameter("casetype").equals("O"))
	department = "Department: Obe & Gynaecology";
	else if (request.getParameter("casetype").equals("P"))
	department = "Department: Paediatrics";
	
	%>
	

<div id="testDiv">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<% if (department!=null) { %>
<h4><%=department%></h4>

<div class="clear"></div>
<div class="Block">
<div id="dtDiv">
<% if (dischargeItemsCategoryList.size() > 0 ) { %> <%  
	for (int i=0;i<dischargeItemsCategoryList.size();i++)
	{
	reply="";
	dischargeItemsCategory = (DischargeItemsCategory)dischargeItemsCategoryList.get(i);
	%>
 <%
	if (map.get(dischargeItemsCategory.getId().toString())!=null)
	reply = map.get(dischargeItemsCategory.getId().toString()).toString();	
	else
	    reply="";	
	
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("DIAG"))
	{
	if (map.get("DIAG")!=null) reply = map.get("DIAG").toString();
	}
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("INVS"))
	{
	if (map.get("INVS")!=null) reply = map.get("INVS").toString();
	}
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("ANES"))
	{
	if (map.get("ANES")!=null) reply = map.get("ANES").toString();
	}
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("OPER"))
	{
	if (map.get("OPER")!=null) reply = map.get("OPER").toString();
	}
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("HIST"))
	{
	if (map.get("HIST")!=null) reply = map.get("HIST").toString();
	}
	if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("MEDI"))
	{
	if (map.get("MEDI")!=null) reply = map.get("MEDI").toString();
	}
	%> <%
	if (dischargeItemsCategory.getLabelDataType().equals("TEXTAREA"))
	{
	%> <% if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("HPTH")) { %>
	 <label><a href="#" onclick="getIPPrescriptionDetails();">Treatments</a></label>
	 <textarea class="textareaMediua" name="<%=dischargeItemsCategory.getId().intValue()%>" id="treatmentId"
	cols="100" rows="10"
	maxlength="5000" ><%=reply%></textarea> <%
	}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("FIND")) { %>
	 <label style="width: 165px;">Condition at Discharge</label>
	 <textarea class="textareaMediua" name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
	cols="100" rows="10" onkeyup="return checkLength(this)"
	maxlength="5000" ><%=reply%></textarea> <%
	}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("DIAG"))
	{ 
	%>
	
	
	 <label><%=dischargeItemsCategory.getLabel()%></label>
	 <textarea class="textareaMediua" name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
	cols="40" rows="2" onkeyup="return checkLength(this)"
	maxlength="1022" ><%=reply%></textarea> <%
	}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("INVS"))
	{ 
		%> 
		<label style="width: 165px;"><a href="javascript:openPopupForInvestigation('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
		<textarea class="textareaMediua" name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
		cols="100" rows="10" onkeyup="return checkLength(this)"
		maxlength="1022"><%=reply%></textarea> <%
		}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("ANES"))
		{ 
			
			%>  <label><%=dischargeItemsCategory.getLabel()%></label>
			<textarea name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
			cols="100" rows="10"onkeyup="return checkLength(this)"
			maxlength="1022" ><%=reply%></textarea> <%
			} else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("OPER"))
			{ 
				%> <label><%=dischargeItemsCategory.getLabel()%></label>
				 <textarea name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
				cols="100" rows="10" onkeyup="return checkLength(this)"
				maxlength="1022" ><%=reply%></textarea> <%
				} 
			else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("HIST"))
			{ 
				%>  <label><%=dischargeItemsCategory.getLabel()%></label>
				<textarea name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
				cols="100" rows="10" onkeyup="return checkLength(this)"
				maxlength="1022" ><%=reply%></textarea> <%
				}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("PRES")){ %>
				<label><a href="javascript:openPopupForTreatment('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
				<textarea name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
				cols="100" rows="10" onkeyup="return checkLength(this)"
				maxlength="1022" ><%=reply%></textarea> 
	
	<%}else if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("OPTR"))
	{ 
		%> <label><a href="javascript:openPopupForProcedure('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
		 <textarea name="<%=dischargeItemsCategory.getId().intValue()%>" id="<%=dischargeItemsCategory.getId().intValue()%>"
		cols="100" rows="10" onkeyup="return checkLength(this)"
		maxlength="1022" ><%=reply%></textarea> <%
		} 
				
				else { System.out.println("dischargeItemsCategory.getLabel()------>>>"+dischargeItemsCategory.getLabel());%> 
				
	<% if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("FIDIA")){%>		
	 <label><a href="javascript:openPopupForFinalDischarge('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
	 <%}else  if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("TreGi")){ %>
	 <label><a href="javascript:openPopupForTreatment('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
	 <%}else if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("CSLTREM")){ %>
	 <label><a href="javascript:openPopupForWardRemarks('<%=dischargeItemsCategory.getId().intValue()%>');"><%=dischargeItemsCategory.getLabel()%></a></label>
	 <%}else{ %>
	 <label><%=dischargeItemsCategory.getLabel()%></label>
	 <%} %>
	 
	 <%if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("ADDIA")){ %>
	 <textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="40" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="2" onkeyup="return checkLength(this)"
	maxlength="1022"><%=admitingIcd.concat(" ").concat(reply)%></textarea> 
	<%}
	 
	 
	 
	 else{ %>
	<textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="40" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="2" onkeyup="return checkLength(this)"
	maxlength="1022"><%=reply%></textarea> 
	
	<%} %>
	
	<% } %>
	
	 <%
	} else if (dischargeItemsCategory.getLabelDataType().equals("TEXT")) { 
		if (dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("BLGR")) { %>
			<label style="width: 165px;">To be reviewed on/after</label>
			<input type="text" class="date" readonly="readonly" <%-- onblur="isPastDate(<%=date %>,date<%=dischargeItemsCategory.getId().intValue()%>);" --%>
			name="date<%=dischargeItemsCategory.getId().intValue()%>" maxlength="1022" id="date<%=dischargeItemsCategory.getId().intValue()%>"
			value="<%=reply%>" validate="<%=dischargeItemsCategory.getLabel()%>,validateDeliveryDate,no"
	class="date"  />
			 <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="javascript:setdate('<%=date %>',document.dischargePatient.date<%=dischargeItemsCategory.getId().intValue()%>,'event')" /><%
		} else { %>
		<label><%=dischargeItemsCategory.getLabel()%></label>
		<input type="text"
		name="<%=dischargeItemsCategory.getId().intValue()%>" maxlength="1022" id="<%=dischargeItemsCategory.getId().intValue()%>"
		value="<%=reply%>" validate="<%=dischargeItemsCategory.getLabel()%>,validateDeliveryDate,no"
	class="date"  /> <% }
	} else if (dischargeItemsCategory.getLabelDataType().equals("DATE")) { 
	%> 
	 <label><%=dischargeItemsCategory.getLabel()%></label><input type="text" id="date<%=dischargeItemsCategory.getId().intValue()%>"
	name="date<%=dischargeItemsCategory.getId().intValue()%>"
	value="<%=reply%>"
	validate="<%=dischargeItemsCategory.getLabel()%>,validateDeliveryDate,no"
	class="date"  /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="javascript:setdate('<%=date %>',document.dischargePatient.date<%=dischargeItemsCategory.getId().intValue()%>,'event')" />
<%
	} else if(dischargeItemsCategory.getLabelDataType().equals("COMBO_NAME")){
	%> <label><%=dischargeItemsCategory.getLabel()%></label>
	 <select name="<%=dischargeItemsCategory.getId().intValue()%>"></select> <% 
	} else if(dischargeItemsCategory.getLabelDataType().equals("TEXTAREABIG")) {
		
	if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("BCS")){ %> 
	<div class="clear"></div>
	<label style="width: 165px;">Brief History & Clinical Notes</label><textarea 
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="60" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="3" onkeyup="return checkLength(this)"
	maxlength="5000" style="width: 950px; height: 24px;" ><%=reply%></textarea> 
	<div class="clear"></div> <% 
	} else if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("HIST")){ %> 
	<div class="clear"></div>
	<label style="width: 165px;">Operation/Delivery Notes</label><textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="60" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="3" onkeyup="return checkLength(this)"
	maxlength="5000" style="width: 950px; height: 24px;" ><%=reply%></textarea> 
	<div class="clear"></div> <% 
	} else if(dischargeItemsCategory.getItemCode().getItemCode().equalsIgnoreCase("ADVC")){ %> 
	
	<div class="clear"></div>
	<label style="width: 165px;">Advice on Discharge</label><textarea 
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="60" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="3" onkeyup="return checkLength(this)"
	maxlength="5000" style="width: 950px; height: 24px;" ><%=advices%> <%=reply%></textarea> 
	<div class="clear"></div> <% 
	} else { %> 
	<label><%=dischargeItemsCategory.getLabel()%></label><textarea
	name="<%=dischargeItemsCategory.getId().intValue()%>" cols="60" id="<%=dischargeItemsCategory.getId().intValue()%>"
	rows="3" onkeyup="return checkLength(this)"
	maxlength="5000"><%=reply%></textarea> <% } %> <%
	} }
	%>
	<%
	
	if(map.get("parent")!=null){
		inpatientId=(Integer)map.get("parent");
		System.out.println("parent-----------JSP--->>"+inpatientId);
	}
	%>
	
	
<div class="clear"></div>
</div>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Add" id="addbutton" value="Submit"
	class="button"
	onClick="submitForm('dischargePatient','discharge?method=addDischargeSummary&parent=<%=inpatientId %>');"
	accesskey="a" />
	<input type="button" name="Reset" value="reset" class="button"
	onClick="submitFormForButton('dischargePatient','discharge?method=showDischargeInputJsp&parent=<%=inpatientId %>');"
	accesskey="p" />
	
<!-- <input type="button" name="Print" value="Print" class="button"
	onClick="submitForm('dischargePatient','/hms/hms/discharge?method=showDischargeSummaryReport');"
	accesskey="p" />
<input type="button" name="DischargeSlip" value="Discharge Slip"
	class="buttonBig"
	onClick="submitForm('dischargePatient','/hms/hms/ipd?method=showDischargeSlipReport');"
	accesskey="d" />
<input type="reset" name="Back" value="Back" class="button"
	onClick="submitForm('dischargePatient','/hms/hms/ipd?method=showPatientListJspNew');"  accesskey="r" /> -->
<input type="hidden" name="isRecordAlreadyExists"
	value="<%=map.get("isRecordAlreadyExists")%>" />

<% } %>
<% } %>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script>
function isPastDate(value,dateValue) {
    var now = new Date;
    var target = new Date(value);

    if (target.getFullYear() < now.getFullYear()) {
        return true;
    } else if (target.getMonth() < now.getMonth()) {
        return true;
    } else if (target.getDate() <= now.getDate()) {
        return true;
    }
    alert("Please Enter Future Date");
    document.getElementById.dateValue.value=value;
    return false;
}
</script>
