
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
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
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
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
	int collectionId=0;
	if(sampleList != null) {
		sampleCollection = (BloodSampleCollection) sampleList.get(0);
			hinId =sampleCollection.getHin().getId();
			collectionId=sampleCollection.getId();
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
	if (map.get("investigationList") != null) {
		investigationList = (List<DgMasInvestigation>) map.get("investigationList");
	}
	if(map.get("patientList") != null){
		patientList = (ArrayList)map.get("patientList");
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
<form name="sampleScreening" method="post" action="">
<div class="titleBg">
<h2>Blood Sample Grouping & Cross match Result Entry</h2>
</div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Order Date</label> <label class="valueMedium"><%=HMSUtil.changeDateToddMMyyyy(sampleCollection.getRequest().getOrderDate())%></label>
<label class="medium">Order Time</label> <label class="valueMedium"><%=sampleCollection.getRequest().getOrderTime()%></label>
<label class="medium">Order No.</label> <label class="valueMedium"><%=sampleCollection.getRequest().getOrderNo()%></label>
<label class="medium">Order By</label> <label class="value"><%=sampleCollection.getRequest().getDepartment().getDepartmentName()%></label>
<div class="clear"></div>
</div>
<div class="clear"></div>

<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <label class="value"><%=sampleCollection.getHin().getHinNo() %></label>
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
<%
		String age = "";
		String currentAge = "";
		age = sampleCollection.getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, sampleCollection.getHin().getRegDate());
		%>
<div class="clear"></div>
<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(sampleCollection.getHin().getMaritalStatus() != null){
					maritalStatus = sampleCollection.getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%> <label>IP No.</label> <%if(sampleCollection.getInpatient() != null){ %>
<label class="value"><%=sampleCollection.getInpatient().getAdNo()%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="clear"></div>

<label>Blood Group</label> <%if(sampleCollection.getHin().getBloodGroup() != null){ %>
<label class="value"><%=sampleCollection.getHin().getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="value">-</label>

<div class="clear"></div>

</div>
<%if( sampleCollection.getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%= sampleCollection.getInpatient().getId()%>" /> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <%} %>
<input type="hidden" value="<%=sampleCollection.getHin().getId() %>"
	name=<%=HIN_ID %> /> <%}%> <input type="hidden"
	value="<%=collectionId %>" name=<%=SAMPLE_COLLECTION_ID %> /> <!--Block Two Ends-->
<!-- Block Three Starts -->
<h4>Sample Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%		String testSeqNo="";
		if(map.get("testSeqNo") != null){
			testSeqNo = (String)map.get("testSeqNo");
		}
%> <label>SampleTest No.</label> <input id="sampleTestId" type=hidden
	name="<%=SAMPLE_TEST_NO %>" value="<%=testSeqNo %>"
	title="Sample Test No" /> <label class="value"><%=testSeqNo %></label>

<label>SampleTest Date</label> <label class="value"> <%= date%>
</label> <label>Sample Test Time</label> <label class="value"> <%= time%>
</label> <label><span>*</span> Sample Test By</label> <select id="collectedBy"
	name="<%=EMPLOYEE_ID %>" validate="Sample Test By,string,yes"
	tabindex="1">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} }%>
</select> <label>Fit For Blood Issue</label> <select class="small"
	name="<%=BLOOD_ISSUE%>" tabindex="1">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<div class="clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="division"></div>
<div class="tableHolderAuto">

<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>SR No</th>
			<th>Test Name</th>
			<th>Result</th>
		</tr>
	</thead>
	<tbody>
		<%
 		int investigationId=0;
    	int temp=0;
    	int inc = 0;    	
    	for(inc=1;inc<=10;inc++){
    		
      	DgMasInvestigation masInvestigation = new DgMasInvestigation();
		if (investigationList.size() > 0  && inc-1 <investigationList.size()) {
		 masInvestigation = investigationList.get(inc-1);    
				investigationId=masInvestigation.getId();
 %>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex="1" /> <input
				type="hidden" id="investigationId<%=inc %>"
				name="<%=INVESTIGATION_ID %>" value="<%=masInvestigation.getId() %>" />
			</td>
			<td><input type="text" size="30" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME%>"
				value="<%=masInvestigation.getInvestigationName() %>[<%=masInvestigation.getId() %>]"
				readonly="readonly" tabindex="1" /></td>

			<td>
			<%if(sampleCollection.getHin().getBloodGroup()!= null && masInvestigation.getInvestigationName().equals("Blood Group") ){ %>
			<input type="text" id="result<%=inc%>" name="<%=RESULT%>"
				value="<%=sampleCollection.getHin().getBloodGroup().getBloodGroupName() %> "
				disabled="disabled" tabindex="1" /> <%}else if(masInvestigation.getInvestigationName().equals("ABO & RH")){ %>
			<select id="result<%=inc%>" name="<%=RESULT%>" tabindex="1">
				<option value="">Select</option>
				<option value="O Rh POSITIVE">O Rh POSITIVE</option>
				<option value="O Rh NEGATIVE">O Rh NEGATIVE</option>
				<option value="A Rh POSITIVE">A Rh POSITIVE</option>
				<option value="A Rh NEGATIVE">A Rh NEGATIVE</option>
				<option value="B Rh POSITIVE">B Rh POSITIVE</option>
				<option value="B Rh NEGATIVE">B Rh NEGATIVE</option>
				<option value="AB Rh POSITIVE">AB Rh POSITIVE</option>
				<option value="AB Rh NEGATIVE">AB Rh NEGATIVE</option>
			</select> <%}else{ %> <select id="result<%=inc%>" name="<%=RESULT%>"
				tabindex="1">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select> <%} %>
			</td>
		</tr>
		<% }else{
		 %>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex="1" /> <input
				type="hidden" id="investigationId<%=inc %>"
				name="<%=INVESTIGATION_ID %>" value="" tabindex="1" /></td>
			<td><input type="text" size="40" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME %>"
				onblur="if(fillSrNo('<%=inc %>')){checkForInvestigationName(this.value, '<%=inc %>');}"
				tabindex="1" />
			<div id="ac2update6" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('investigationName<%=inc %>','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName'});
			</script></td>

			<td><select id="result<%=inc%>" name="<%=RESULT%>" tabindex="1">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select></td>
		</tr>
		<% }
	 }
%>
	</tbody>
</table>
</div>
<div class="clear"></div>

<h4>Cross Match Method</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Cross Match Method</label> <input type="checkbox"
	class="radioCheck" name="<%=MAJOR_RS_DC %>" value="" tabindex="1" /> <label
	class="value">Major - RS + DC</label> <input type="checkbox"
	class="radioCheck" name="<%=MINOR_RS_DC  %>" value="" tabindex="1" />
<label class="value">Minor - RS + DC</label>

<div class="clear"></div>
<label><span>*</span> Cross Match By</label> <select id="collectedBy"
	name="<%=CROSS_MATCHED_BY %>" validate="Cross Match By,string,yes"
	tabindex="1">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option>
	<%		} }%>
</select> <label class="noWidth">Compatibility</label> <select class="small"
	id="result<%=inc%>" name="<%=COMPATIBILITY%>" tabindex="1">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<div class="clear"></div>
</div>
<!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow()&& checkFilledTest()){submitForm('sampleScreening','bloodBank?method=submitBloodSampleScreeningTest');}"
	align="right" tabindex="1" /> <input type="reset"
	class="buttonHighlight" name="Reset" id="reset" value="Reset"
	onclick="resetClicked('sampleScreening');" accesskey="r" tabindex="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>
</div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
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
<script type="text/javascript">
function checkForInvestigationName(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForInvestigationName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var investigationId = val.substring(index1,index2);
			var indexForInvestigationName = indexForInvestigationName--;
			var investigationName = val.substring(0,indexForInvestigationName);
		
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('investigationName'+i).value==val)
		{
			alert("investigation Name already selected...!")
			document.getElementById('investigationName'+inc).value=""
			var e=eval(document.getElementById('investigationName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteInvestigationName('sampleScreening','bloodBank?method=fillItemsForInvestigationName&investigationName=' +  investigationName , inc);
		
}
}
function fillSrNo(rowVal){

	if(document.getElementById('investigationName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('investigationName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function checkFilledRow(){
	for(var a=1;a<=10;a++){
	if(document.getElementById("investigationName"+a).value!=""){
	if(document.getElementById("result"+a).value==""){
	alert("Please select result in row "+a);
	return false;
	}
	}
	}
	return true;
	}
	
function checkFilledTest(){
	for(var a=1;a<=10;a++){
	if(document.getElementById("result"+a).value!=""){
	if(document.getElementById("investigationName"+a).value==""){
	alert("Please select Test in row "+a);
	return false;
	}
	}
	}
	return true;
	}
</script>