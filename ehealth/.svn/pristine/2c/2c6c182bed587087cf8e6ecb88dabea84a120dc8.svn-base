
<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


<%
    int pageNo=1;
String testSeqNo="";
	Map<String,Object>  map = new HashMap<String,Object> ();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	//List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	//BloodReactionEntry bloodReactionEntry= new BloodReactionEntry();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	int hinId= 0;
	String deptName="";
	
	List<BloodIssueDetail> bloodIssueDetailList = new ArrayList<BloodIssueDetail>();
	BloodIssueDetail bloodIssue=new BloodIssueDetail();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("testSeqNo") != null){
		testSeqNo=(String)map.get("testSeqNo");
	}
	
	if(map.get("bloodIssueDetailList") != null){
		bloodIssueDetailList=(List<BloodIssueDetail>)map.get("bloodIssueDetailList");
	}
	
	
	/* if(map.get("reactionList") != null){
		reactionList=(List)map.get("reactionList");
	} */
	if(bloodIssueDetailList != null && bloodIssueDetailList.size()>0  ) {
		bloodIssue = (BloodIssueDetail) bloodIssueDetailList.get(0);
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
<div class="clear"></div>
<%}
%>

<form name="sampleScreening" method="post" action="">
<div class="titleBg">
<h2>Investigation of Transfusion Reacted Blood Result Entry</h2>
</div>
<!--Block One Starts-->
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Transfussion No</label> <label class="value"><%=testSeqNo %></label>
<label>Transfussion Date</label> <label class="value"></label>
<div class="clear"></div>
</div>
<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>UHID </label> 
 <label class="value"><%=bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getHinNo()%></label> 

										
					
		 <label>Patient Name</label>
		 <%if ((bloodIssue.getIssueHeader().getBloodRequestHd().getHin()!=null)){%>
<label class="value"><%=(bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getFullName())%></label>
<%}else{ %> <label class="value"><%= (bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getFullName())%></label>
<%} %> 

<label>Sex</label> <%if (bloodIssue.getIssueHeader().getBloodRequestHd().getHin()!=null){%> <label
	class="value"><%=bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
<%
		String age = "";
		String currentAge = "";
		if (bloodIssue.getIssueHeader().getBloodRequestHd().getHin()!=null){
		age = bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getAge();
	    currentAge = HMSUtil.calculateAgeForADT(age, bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getRegDate());
		}else{
			age="-";
		}
		%> <label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(bloodIssue.getIssueHeader().getBloodRequestHd().getHin()!=null){
				if(bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getMaritalStatus() != null){
					maritalStatus = bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}}else{ %> <label
	class="value">-</label> <% }%>

<div class="clear"></div>

<%if( bloodIssue.getIssueHeader().getBloodRequestHd().getInpatient() != null){%> <input type="hidden"
	name="<%=INPATIENT_ID %>"
	value="<%= bloodIssue.getIssueHeader().getBloodRequestHd().getInpatient().getId()%>" /> <%} %> <input
	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" /> <%if(bloodIssue.getIssueHeader().getBloodRequestHd().getHin()!=null){%>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=bloodIssue.getIssueHeader().getBloodRequestHd().getHin().getId() %>" /> <%} %> <input
	type="hidden" name="<%=BLOOD_ISSUE_DETAIL_ID %>"
	value="<%=bloodIssue.getIssueHeader().getId()%>" /></div>

<div class="clear"></div>
<!--Block Two Ends-->
<h4>Sample Test Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%
		
		if(map.get("testSeqNo") != null){
			testSeqNo = (String)map.get("testSeqNo");
		}
%> <label>Test No.</label> <input id="sampleTestId" type=hidden
	name="<%=TEST_NO %>" value="<%=testSeqNo %>" title="Test No" /> <label
	class="value"> <%=testSeqNo %> </label> <label><span>*</span>Test
Date</label> <input type="text" class="date" id="testDate"
	name="<%=TEST_DATE %>" value="<%=date %>" readonly="readonly"
	MAXLENGTH="30" tabindex="1" validate="Test Date,date,yes" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=date %>',document.sampleScreening.<%=TEST_DATE%>,event)"
	tabindex="1" /> <label><span>*</span>Test By</label> <select
	id="testBy" name="<%=EMPLOYEE_ID %>" validate="Test By,string,yes">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<%-- <option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option> --%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getEmployeeName() %></option>
	<%		} }%>
</select>
<div class="clear"></div>
</div>
<!-- Block Three Starts --> <input type="hidden" value="0"
	name="pagecounter2" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <!-- Block Three Ends --> <input type="hidden"
	size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="paddingTop15"></div>
<div class="tableForTab" style="width:1100px; height:252px; overflow: scroll;">
<table width="100%" id="componentDetails" border="0" cellpadding="0"
	cellspacing="0">
	<tr>
		<th scope="col">SR No</th>
		<th scope="col">Test Name</th>
		<th scope="col">Result</th>
	</tr>
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
			<td width="5%"><input type="hidden" size="2" value="<%=inc%>"
				name="counter" id="counter" /> <input type="text" size="2"
				value="<%=inc%>" name="<%=SR_NO%>" readonly="readonly" /> <input
				type="hidden" id="investigationId<%=inc %>"
				name="<%=INVESTIGATION_ID %>" value="<%=masInvestigation.getId() %>" />

			</td>
			<td><input type="text" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME%>" size="50"
				value="<%=masInvestigation.getInvestigationName() %>[<%=masInvestigation.getId() %>]"
				readonly="readonly" /></td>

			<td>
			<%if(masInvestigation.getInvestigationName().equals("ABO & RH")){ %> <select
				id="result<%=inc%>" name="<%=RESULT%>" style="width: 120px">
				<option value="">Select</option>
				<option value="O Rh POSITIVE">O Rh POSITIVE</option>
				<option value="O Rh NEGATIVE">O Rh NEGATIVE</option>
				<option value="A Rh POSITIVE">A Rh POSITIVE</option>
				<option value="A Rh NEGATIVE">A Rh NEGATIVE</option>
				<option value="B Rh POSITIVE">B Rh POSITIVE</option>
				<option value="B Rh NEGATIVE">B Rh NEGATIVE</option>
				<option value="AB Rh POSITIVE">AB Rh POSITIVE</option>
				<option value="AB Rh NEGATIVE">AB Rh NEGATIVE</option>
			</select> <%}else{ %> <select id="result<%=inc%>" name="<%=RESULT%>" style="width: 120px">
				<option value="">Select</option>
				<option value="negative">Negative</option>
				<option value="positive">Positive</option>
			</select> <%} %>
			</td>
		</tr>
		<% }
	 }
%>
	</tbody>
</table>
</div>
<div class="clear"></div>
<h4>Cross Match Method</h4>
<div class="Block"><label>Cross Match Method</label> <input
	type="checkbox" class="radioCheck" name="<%=MAJOR_RS_DC %>" value="" />
<label class="value">Major - RS + DC</label> <input type="checkbox"
	class="radioCheck" name="<%=MAJOR_DS_RC  %>" value="" /> <label
	class="value">Major - DS + RC</label>

<div class="clear"></div>
<label><span>*</span>Cross Match By</label> <select id="collectedBy"
	name="<%=CROSS_MATCHED_BY %>" validate="Cross Match By,string,yes">
	<option value="0">Select</option>
	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<%-- <option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ " "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%></option> --%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getEmployeeName() %></option>
	<%		} }%>
</select> <label class="noWidth">Compatibility</label> <select class="small"
	id="result<%=inc%>" name="<%=COMPATIBILITY%>">
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<div class="clear"></div>
<label><span>*</span>Feedback</label>

 <textarea rows="100" cols="100" id="feedbackdetail" name="feedbackdetail" >

</textarea> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow() && checkFilledTest())submitForm('sampleScreening','bloodBank?method=submitTransfussionReaction');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('sampleScreening');"
	accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels starts-->
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
			document.getElementById('investigationName1'+inc).value=""
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
	//alert(document.getElementById("investigationName"+a).value )
	if(document.getElementById("investigationName"+a).value!=""){
	if(document.getElementById("result"+a).value==""){
	alert("Please select result in row "+a);
	return false;
	}
	else
	return true;
	}
	}
	
	}
	
function checkFilledTest(){
	for(var a=1;a<=10;a++){
	if(document.getElementById("result"+a).value!=""){
	if(document.getElementById("investigationName"+a).value==""){
	alert("Please select Test in row "+a);
	return false;
	}
	else
	return true;
	}
	}
	
	}
</script>