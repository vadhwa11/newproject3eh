
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
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
	List<BloodDonationEntryDetail> doantionDetailList = new ArrayList<BloodDonationEntryDetail>();
	List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	
	BloodDonationEntryDetail donationEntryDetail= new BloodDonationEntryDetail();
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
	if(map.get("doantionDetailList") != null){
		doantionDetailList=(List)map.get("doantionDetailList");
	}
	Patient patient = new Patient();
	if(doantionDetailList != null && doantionDetailList.size()>0)
	{
		donationEntryDetail=(BloodDonationEntryDetail) doantionDetailList.get(0);
		if(donationEntryDetail.getDonation().getHin() != null){
			patient = (Patient) donationEntryDetail.getDonation().getHin();
			hinId=patient.getId();
		}
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
<%}
%>
<form name="sampleScreening" method="post" action="">
<div class="titleBg">
<h2>Donor Sample Screening Test Result Entry</h2>
</div>
<div class="clear"></div>

<div class="Block"><label>Blood Bag No.</label> <label
	class="value"><%=donationEntryDetail.getBloodBagNo()%></label> <label>Donation
No.</label> <label class="value"><%=donationEntryDetail.getDonation().getDonationNo()%></label>

<div class="clear"></div>

<input type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=deptId %>" />
<%if(donationEntryDetail.getDonation().getHin() != null){ %> <input
	type="hidden" name="<%=HIN_ID %>"
	value="<%=donationEntryDetail.getDonation().getHin().getId() %>" /> <%} %>
<input type="hidden" name="<%=BLOOD_DONATION_ENTRY_DETAIL_ID %>"
	value="<%=donationEntryDetail.getId() %>" />
<div class="clear"></div>
<%
				String testSeqNo="";
				if(map.get("testSeqNo") != null){
					testSeqNo = (String)map.get("testSeqNo");
				}
		%> <label>Sample Tested No.</label> <input id="sampleTestId"
	type=hidden name="<%=SAMPLE_TEST_NO %>" value="<%=testSeqNo %>"
	title="Sample Test No" /> <label class="value"><%=testSeqNo %></label>

<label>Sample Tested Date</label> <label class="value"> <%= date%>
</label> <label> <span>*</span> Sample Tested By</label> <select
	id="collectedBy" name="<%=EMPLOYEE_ID %>"
	validate="Sample Test By,string,no">
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

<label> Donor Name</label> <label class="value"><%=donationEntryDetail.getDonation().getDonerName() %></label>

<label> HIN</label> <%if(donationEntryDetail.getDonation().getHin()!=null){ %>
<label class="value"><%=donationEntryDetail.getDonation().getHin().getHinNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label> Sex</label> <%if(donationEntryDetail.getDonation().getSex()!=null){ %>
<label class="value"><%=donationEntryDetail.getDonation().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<div class="division"></div>
<input type="hidden" value="0" name="pagecounter2" /> <input
	type="hidden" name="pageNo" id="pageNo" value="<%=pageNo%>" /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<h4>Sample Tested Details</h4>
<div class="clear"></div>


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
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %>"
				value="<%=masInvestigation.getId() %>" /></td>
			<td><input type="text" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME%>"
				value="<%=masInvestigation.getInvestigationName() %>[<%=masInvestigation.getId() %>]"
				readonly="readonly" /></td>

			<td>
			<%if(masInvestigation.getInvestigationName().equals("ABO & RH")){ %> <select
				id="result<%=inc%>" name="<%=RESULT%>">
				<option value="">Select</option>
				<option value="O Rh POSITIVE">O Rh POSITIVE</option>
				<option value="O Rh NEGATIVE">O Rh NEGATIVE</option>
				<option value="A Rh POSITIVE">A Rh POSITIVE</option>
				<option value="A Rh NEGATIVE">A Rh NEGATIVE</option>
				<option value="B Rh POSITIVE">B Rh POSITIVE</option>
				<option value="B Rh NEGATIVE">B Rh NEGATIVE</option>
				<option value="AB Rh POSITIVE">AB Rh POSITIVE</option>
				<option value="AB Rh NEGATIVE">AB Rh NEGATIVE</option>
			</select> <%}else{ %> <select id="result<%=inc%>" name="<%=RESULT%>">
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
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %>" value="" />

			</td>
			<td><input type="text" id="investigationName<%=inc%>"
				name="<%=INVESTIGATION_NAME %>"
				onblur="if(fillSrNo('<%=inc %>')){checkForInvestigationName(this.value, '<%=inc %>');}" />
			<div id="ac2update6" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
		
			  new Ajax.Autocompleter('investigationName<%=inc %>','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName<%=inc %>'});
			</script></td>

			<td><select id="result<%=inc%>" name="<%=RESULT%>">
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
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="division"></div>
<input type="button" class="button" value="Add"
	onclick="if(checkFilledRow())submitForm('sampleScreening','bloodBank?method=submitDonorBloodSampleScreeningTest');"
	align="right" /> <input type="reset" class="button" name="Reset"
	id="reset" value="Reset"
	onclick="resetClicked('sampleScreening',<%=inc %>);" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
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
			var indexForInvestigationName = indexForInvestigationName;
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

</script>