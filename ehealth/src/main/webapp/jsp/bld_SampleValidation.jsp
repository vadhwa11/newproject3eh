
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
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
	List<BloodSampleCollection> sampleList = new ArrayList<BloodSampleCollection>();
	List<Patient> patientList = new ArrayList<Patient>();
	
	BloodSampleCollection sampleCollection= new BloodSampleCollection();
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
	if(map.get("sampleList") != null){
		sampleList=(List)map.get("sampleList");
	}
	if(sampleList != null) {
		sampleCollection = (BloodSampleCollection) sampleList.get(0);
			hinId =sampleCollection.getHin().getId();
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
	
    MasDepartment masDepartment=new MasDepartment();
   // masDepartment = (MasDepartment) sampleCollection.getDepartment();
	
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
<form name="sampleValidation" method="post" action=""><!--main content placeholder starts here-->
<div class="titleBg">
<h2>Sample Validation</h2>
</div>
<div class="clear"></div>
<div class="Block"><label class="NoWidth">Order Date</label> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(sampleCollection.getRequest().getOrderDate())%></label>
<label class="NoWidth">Order Time</label> <label class="value"><%=sampleCollection.getRequest().getOrderTime()%></label>
<label class="NoWidth">Order No.</label> <label class="value"><%=sampleCollection.getRequest().getOrderNo()%></label>
<label class="NoWidth">Order By</label> <label class="value"><%=sampleCollection.getRequest().getDepartment().getDepartmentName()%></label>
<div class="clear"></div>
</div>
<div class="clear"></div>

<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> HIN </label> <label class="value"><%=sampleCollection.getHin().getHinNo() %></label>
<%
					String middleName = "";
					String lastName = "";
					if(sampleCollection.getHin().getPMiddleName() != null){
						middleName = sampleCollection.getHin().getPMiddleName();
					}
					if(sampleCollection.getHin().getPLastName() != null){
						lastName = sampleCollection.getHin().getPLastName();
					}
	%> <label>Patient Name</label> <label class="value"><%= sampleCollection.getHin().getPFirstName()+" "+middleName+" "+lastName%></label>

<label>Sex</label> <label class="value"><%=sampleCollection.getHin().getSex().getAdministrativeSexName() %></label>
<div class="clear"></div>
<%
		String age = "";
		String currentAge = "";
		age = sampleCollection.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, sampleCollection.getHin().getRegDate());
		%> <label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(sampleCollection.getHin().getMaritalStatus() != null){
					maritalStatus = sampleCollection.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <%
			int inpatientId =0;
		
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = sampleCollection.getHin().getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
				}
%> <label>IP No.</label> <%if(inpatient != null){ %> <label class="value"><%=inpatient.getAdNo()%></label>
<%}else{ %> <label class="value">-</label> <% }%> <%if( sampleCollection.getInpatient() != null){%>
<input type="hidden" name="<%=INPATIENT_ID %>"
	value="<%= sampleCollection.getInpatient().getId()%>" /> <%} } %> <label>Blood
Group</label> <%if(sampleCollection.getHin().getBloodGroup() != null){ %> <label
	class="value"><%=sampleCollection.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="clear"></div>



<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" />
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=sampleCollection.getHin().getId() %>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	value="<%=sampleCollection.getId()%>" /></div>
<!--Block Two Ends--> <!-- Block Three Starts -->
<h4>Sample Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label class="noWidth">SampleValidation Date</label> <label
	class="value"> <%= date%> </label> <label class="noWidth">SampleValidation
Time</label> <label class="value"> <%= time%> </label> <label class="noWidth"><span>*</span>Validated
By</label> <select id="collectedBy" name="<%=EMPLOYEE_ID %>"
	validate="Validated By,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} }%>
</select>

<div class="clear"></div>
<label class="noWidth">Accepted</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked"
	class="radioCheck" tabindex=1 /> <label class="noWidth">Rejected</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioCheck"
	tabindex=1 />
<div class="clear"></div>


<label class="common">Remarks</label> <input id="clinicalNote"
	type="text" name="<%= REMARKS%>" value=""
	validate="Clinical Notes,string,no" MAXLENGTH="100"
	style="width: 600px;" tabindex=1 />

<div class="clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<!-- Block Three Ends --> <!-- Table Ends --> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('sampleValidation','bloodBank?method=submitBloodSampleValidation');"
	align="right" tabindex=1 /> <input type="reset"
	class="buttonHighlight" name="Reset" id="reset" value="Reset"
	onclick="resetClicked('sampleValidation');" accesskey="r" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<!--main content placeholder ends here-->

<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">

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
</script>