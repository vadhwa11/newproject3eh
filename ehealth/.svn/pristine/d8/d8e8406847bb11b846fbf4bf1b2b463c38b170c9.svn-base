
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();
	List<Patient> patientList = new ArrayList<Patient>();
	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	Set<BloodMasComponent> componentList = new HashSet<BloodMasComponent>();
	
	BloodSampleScreeningHeader sampleScreeningHeader= new BloodSampleScreeningHeader();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	int hinId= 0;
	String deptName="";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("screeningList") != null){
		screeningList=(List)map.get("screeningList");
	}
	
	/* if(screeningList != null) {
		sampleScreeningHeader = (BloodSampleScreeningHeader) screeningList.get(0);
			hinId =sampleScreeningHeader.getHin().getId();
	} */
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
	if(map.get("componentList") != null){
		componentList=(Set<BloodMasComponent>)map.get("componentList");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("employeeList") != null){
	    employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
	}
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
	}
	
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		int deptId =0;
		if(session.getAttribute("deptId") != null){
			deptId = (Integer)session.getAttribute("deptId");
		}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<h4><span><%=message %></span></h4>
<%}
		
 %>

<!--main content placeholder starts here-->

<form name="bloodIssue" method="post" action="">
<div class="titleBg">
<h2>Blood Issue Entry</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Order Date</label> <label
	class="valueMedium"></label>
<label class="medium">Order Time</label> <label class="valueMedium"></label>
<label class="medium">Order No.</label> <label class="valueMedium"></label>
<label class="medium">Order By</label> <label class="value"></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <label class="value"></label>
<%-- <%
					String middleName = "";
					String lastName = "";
					if(null !=sampleScreeningHeader && sampleScreeningHeader.getHin().getPMiddleName() != null){
						middleName = sampleScreeningHeader.getHin().getPMiddleName();
					}
					if(null !=sampleScreeningHeader && sampleScreeningHeader.getHin().getPLastName() != null){
						lastName = sampleScreeningHeader.getHin().getPLastName();
					}
					
		%> --%> <label>Patient Name</label> <label class="value"></label>

<label>Sex</label> <label class="value"></label>
<%
		String age = "";
		String currentAge = "";
		age = sampleScreeningHeader.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, sampleScreeningHeader.getHin().getRegDate());
		%>

<div class="clear"></div>

<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(sampleScreeningHeader.getHin().getMaritalStatus() != null){
					maritalStatus = sampleScreeningHeader.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <label>Blood Group</label> <%
	 String bloodGroup="";
				if(sampleScreeningHeader.getHin().getBloodGroup() != null){
					bloodGroup = sampleScreeningHeader.getHin().getBloodGroup().getBloodGroupName();
				
				%> <input type="hidden" id="bloodGroupId"
	name="<%=BLOOD_GROUP_ID %>"
	value="<%=sampleScreeningHeader.getHin().getBloodGroup().getId() %>" />
<label class="value"><%=bloodGroup%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <%if( sampleScreeningHeader.getInpatient() != null){%>
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%= sampleScreeningHeader.getInpatient().getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <%} %>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=sampleScreeningHeader.getHin().getId() %>" /> <input
	type="hidden" name="<%=SAMPLE_SCREENING_HD_ID %>"
	value="<%=sampleScreeningHeader.getId()%>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block">
<%
		String monthlySeqNo="";
		if(map.get("monthlySeqNo") != null){
			monthlySeqNo = (String)map.get("monthlySeqNo");
		}
%>

<div class="clear"></div>
<label>Monthly Issue No.</label> <input id="fatherId" type=hidden
	name="<%=MONTHLY_ISSUE_NO %>" value="<%=monthlySeqNo %>"
	title="Monthly Issue No." /> <label class="value"> <%=monthlySeqNo %>
</label> <label><span>*</span>Issue Date</label> <input type="text" class="date"
	id="fromDateId" name="<%=ISSUE_DATE %>" value="<%=date %>"
	readonly="readonly" MAXLENGTH="30" validate="Issue Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.bloodIssue.<%=ISSUE_DATE%>,event)"
	tabindex="1" /> <label><span>*</span>Issue Time</label> <input
	type="text" class="date" id="fromDateId" name="<%=ISSUE_TIME %>"
	value="<%=time %>" readonly="readonly" MAXLENGTH="10"
	onblur="checkTime(bloodIssue,<%=ISSUE_TIME %>);" tabindex="1" />

<div class="clear"></div>

<label><span>*</span>Issued By</label> <select id="employeeId1"
	name=<%=ISSUED_BY %> validate="Issued By,string,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} } %>
</select> <label><span>*</span> Received By </label> <select id="employeeId2"
	name=<%=RECEIVED_BY %> validate="Received By,string,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} } %>
</select> <label><span>*</span>Cross Matched By </label> <select id="employeeId3"
	name=<%=CROSS_MATCHED_BY %> validate="Cross Matched By,string,yes"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} } %>
</select>

<div class="clear"></div>

<label class="auto">Method of cross matching</label> <input
	type="checkbox" class="radioCheck" name="<%=SAL_RT %>" value=""
	tabindex="1" /> <label class="value">Sal-RT</label> <input
	type="checkbox" class="radioCheck" name="<%=SAL %>" value=""
	tabindex="1" /> <label class="value">Sal 37&deg;C</label> <input
	type="checkbox" class="radioCheck" name="<%=ALB %>" value=""
	tabindex="1" /> <label class="value">ALB 37&deg;C</label> <input
	type="checkbox" class="radioCheck" name="<%=AHG %>" value=""
	tabindex="1" /> <label class="value">AHG 37&deg;C</label>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">

	<thead>
		<tr>
			<th scope="col">Sr. No.</th>
			<th scope="col">Component Name</th>
			<th scope="col">Blood Bag No.</th>
			<th scope="col">Quantity (ml)</th>
			<th scope="col"></th>
		</tr>
	</thead>
	<tbody>
		<%

	int detailCounter=8; 
	int temp=0;
	int inc = 0;    	
	if(pageNo!=1){
		temp=detailCounter*(pageNo-1);
	} 
	
 %>

		<tr>
			<%if(componentList.size()>=inc){
	  for(BloodMasComponent bloodMasComponent :componentList){
	 inc++;
	 
  %>
			<td width="5%"><input type="text" id="srNo" size="2"
				value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" tabindex="1" /></td>

			<td><input type="text" id="componentName<%=inc%>"
				name="<%=BLOOD_COMPONENT_NAME%>"
				value="<%=bloodMasComponent.getComponentName() %>" /> <input
				type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%>"
				id="bloodComponentId<%=inc %>"
				value="<%=bloodMasComponent.getId() %>" /></td>


			<td><input id="bloodBagNo<%=inc%>" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				readonly="readonly" tabindex="1" /> <input type="hidden" value=""
				name="<%=STOCK_DETAIL_ID%>" id="stockDetailId<%=inc %>" /></td>

			<td><input type="text" id="qty<%=inc%>" name="<%=QUANTITY %>"
				value="" validate="Qty,int,no" MAXLENGTH="3" readonly="readonly"
				tabindex="1" /></td>
			<td><input type="button" class="button" value="Issue"
				onclick="get_bag_no(<%=inc %>,<%=bloodMasComponent.getId()%>);"
				align="right" /></td>
		</tr>
		<%}}%>
		<input type="hidden" name="counter" id="counter" value="<%=inc %>" />
	</tbody>
</table>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="if(checkIssue()){submitForm('bloodIssue','bloodBank?method=submitBloodIssue');}"
	align="right" tabindex="1" /> <input type="reset"
	class="buttonHighlight" name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodIssue',<%=inc %>);" accesskey="r"
	tabindex="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
</div>
<!--Bottom labels ends-->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script language="javascript">	          
function get_bag_no(rowNo,bloodId)
{
var url='/hms/hms/bloodBank?method=showPopUpBloodIssueJsp&bloodComponentId='+bloodId+'&rowNo='+rowNo ;
 popwindow(url);
 }  

var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name','height=500,width=800,status=1');
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

function checkIssue(){
	var counter = document.getElementById('counter').value;
	for(var i=1;i<=counter;i++){
		if(document.getElementById('bloodBagNo'+i)){
			if(document.getElementById('bloodBagNo'+i).value == ""){
				alert("Please Issue Component.");
				return false;
			}
		}
	}
	return true;
	
}
</script>