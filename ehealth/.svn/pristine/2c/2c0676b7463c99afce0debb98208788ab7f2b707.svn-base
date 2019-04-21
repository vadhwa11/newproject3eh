<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<form name="bloodTransfusion" method="post" action=""><script
	type="text/javascript">
		history.forward();
</script> <script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Set<Inpatient> inpatientSet = new HashSet<Inpatient>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		if(map.get("pageNo") != null){
			pageNo=(Integer)map.get("pageNo");
		}
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<BloodMasComponent> componentList = new ArrayList<BloodMasComponent>();
		
		if(map.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)map.get("inpatientList");
		}
	
		if(map.get("componentList") != null){
			componentList=(List)map.get("componentList");
		}

	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	 }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<%} %>

<div class="titleBg">
<h2>Consent for Blood Transfusion Entry</h2>
</div>
<div class="clear"></div>
<div class="Block"><input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <%
		int entrySeqNo=0;
		if(map.get("entrySeqNo") != null){
			entrySeqNo = (Integer)map.get("entrySeqNo");
		}
%> <label>Entry No.</label> <input id="orderNoId" type=hidden
	name="<%=ENTRY_NO %>" value="<%=entrySeqNo %>" title="Order Number" />

<label class="value"><%=entrySeqNo %></label> <label>Entry Date</label>
<label class="value"> <%= currentDate%> </label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="Block">
<% for (Inpatient inpatient:inpatientList) {%> <label>HIN </label> <label
	class="value"><%=inpatient.getHin().getHinNo()%></label> <label>Patient
Name</label> <label class="value"><%=inpatient.getHin().getPFirstName()+" "+inpatient.getHin().getPMiddleName()+" "+inpatient.getHin().getPLastName() %></label>

<label>Sex </label> <%if(inpatient.getHin().getSex() !=null){ %> <label
	class="value"><%=inpatient.getHin().getSex().getAdministrativeSexName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>
<div class="clear"></div>
<label>Age </label> <%if(inpatient.getHin().getAge() !=null){ %> <label
	class="value"><%=inpatient.getHin().getAge()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %> <label>Marital Status </label> <%if(inpatient.getHin().getMaritalStatus() !=null){ %>
<label class="value"><%=inpatient.getHin().getMaritalStatus().getMaritalStatusName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <label>Religion
</label> <%if(inpatient.getHin().getReligion() !=null){ %> <label class="value"><%=inpatient.getHin().getReligion().getReligionName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="clear"></div>

<label>District </label> <%if(inpatient.getHin().getDistrict() !=null){ %>
<label class="value"><%=inpatient.getHin().getDistrict().getDistrictName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>
<div class="clear"></div>
</div>

<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=inpatient.getId()%>" /> <input type="hidden"
	name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=inpatient.getHin().getId() %>" /> <%} %>
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><label class="noWidth"> <span>*</span>
Blood Component Name</label> <select id="compId" name=<%=BLOOD_COMPONENT_ID%>
	validate="Blood Component Name,string,yes">
	<option value="0">Select</option>

	<%
				         		if(componentList != null){ 	
				         			for (Iterator iter = componentList.iterator(); iter.hasNext();) {
				         				BloodMasComponent  masComponent = (BloodMasComponent) iter.next();
				         %>
	<option value="<%=masComponent.getId() %>"><%=masComponent.getComponentName()%></option>
	<%		} }%>
</select> <label>Witness Name</label> <input type="text"
	name="<%=WITNESS_NAME %>" value="" MAXLENGTH="30"
	validate="Witness Name,string,no" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts--> <input type="button" class="button"
	value="Add"
	onclick="submitForm('bloodTransfusion','bloodBank?method=submitBloodTransfusion')"
	align="right" /> <input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodTransfusion');" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label>

<div class="clear"></div>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>