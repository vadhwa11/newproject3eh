<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningDetail"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>

<%@page import="jkt.hms.masters.business.BloodResultEntryDetails"%>
<%@page import="jkt.hms.masters.business.BloodResultEntryHeader"%>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<title> Serum grouping</title>

 <script type="text/javascript">

 $(document).ready(function() {
     $("input[name$='name_radio1']").click(function() {
         var test = $(this).val();
        // $("div.desc").hide();
         //$("#divs" + test).show();
     });
 });

    </script>


<%
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
	//List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	

//List<BloodSampleScreeningHeader> screeningList = new ArrayList<BloodSampleScreeningHeader>();

List<DgMasInvestigation> investionList = new ArrayList<DgMasInvestigation>();
//List<BloodSampleScreeningDetail> screenDetailList = new ArrayList<BloodSampleScreeningDetail>();

List<BloodResultEntryHeader> screeningList = new ArrayList<BloodResultEntryHeader>();
List<BloodResultEntryDetails> screenDetailList = new ArrayList<BloodResultEntryDetails>();

List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if(map.get("screeningList") != null)
{
	screeningList=(List<BloodResultEntryHeader>)map.get("screeningList");
}
if(map.get("screenDetailList") != null)
{
	screenDetailList=(List<BloodResultEntryDetails>)map.get("screenDetailList");
}
System.out.println("");
if(map.get("bloodGroupList") != null)
{
	bloodGroupList=(List<MasBloodGroup>)map.get("bloodGroupList");
}
String BagNum="";
String TubNum="";
int Quantity=0;
int bldSamplescreenHId=0;
int bldSampleCollectionId=0;
  if(null !=screeningList && screeningList.size()>0){
	  for(BloodResultEntryHeader bsh:screeningList){
		  if(null !=bsh.getScreeningTest()){
		  BagNum=bsh.getScreeningTest().getSampleCollection().getBagNumber();
		  TubNum=bsh.getScreeningTest().getSampleCollection().getTubeNumber();
		  bldSamplescreenHId=bsh.getScreeningTest().getId();
		  }else{
		  BagNum=bsh.getSampleCollection().getBagNumber();
		  TubNum=bsh.getSampleCollection().getTubeNumber();
		 // bldSamplescreenHId=bsh.getScreeningTest().getId();
		  bldSampleCollectionId=bsh.getSampleCollection().getId();
		  }
		  if(null !=bsh.getSampleCollection().getComponentQuantity())
		 Quantity=bsh.getSampleCollection().getComponentQuantity();
	  }
  }

	if (map.get("investionList") != null) {
		investionList = (List<DgMasInvestigation>) map.get("investionList");
	}

	String hinNo="";
	if(map.get("hinNo") != null){
		hinNo = (String)map.get("hinNo");
	}
%>
<div class="titleBg">
<h2> Serum grouping</h2>
</div>
<form name="testEntry" method="post" action="">

<%
		String serialSeqNo="";
		if(map.get("serialSeqNo") != null){
			serialSeqNo = (String)map.get("serialSeqNo");
		}
%>
<div class="Block">
<input id="currentDateId" type=hidden
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" />
	 <label>Bag Number</label> 
	 <input	type="text"  name="BagNumber" value="<%=BagNum %>" tabindex=1 maxlength="20" 
	 onblur="ajaxFunctionForTestPatient(testEntry);" readonly="readonly" /> 	 
	 <input id="bldSamplescreenHId"	type="hidden" name="bldSamplescreenHId" value="<%=bldSamplescreenHId%>" />	 
	 <input id="bldSampleCollectionId"	type="hidden" name="bldSampleCollectionId" value="<%=bldSampleCollectionId%>" />
	
	 <label>Tube Number</label> 
	 <input	type="text"  name="TubeNumber" value="<%=TubNum %>" tabindex=1
	  maxlength="20" onblur="ajaxFunctionForTestPatient(testEntry);" readonly="readonly" /> 	  
	 <input id="hinId"	type=hidden name="<%=HIN_ID%>" value="" />	
	
	 <label>Quantity Collected</label> 	 
	 <input type="text"  name="Quntity"
	value="<%=Quantity %>"  class="textbox_size20"
	maxlength="20" readonly="readonly" tabindex=1 /><label class="smallAuto">ml</label>
	<div class="clear"></div>
	<label>Visual Inspection Of Blood</label>
<select id="pType" name=<%=PATIENT_TYPE %>
	validate="Type,string,no">
	<option value="0">Select</option>	
</select>
	<div class="clear"></div>
	
	<%--  <label>Patient
Type</label> <select id="pType" name=<%=PATIENT_TYPE %>
	validate="Type,string,no">
	<option value="0">Select</option>
	<option value="ip">IP</option>
	<option value="op">OP</option>
</select> 
 --%>
<%-- <label><span>*</span> Sex</label> 
<select id="sexId" name=<%=SEX_ID %>
	validate="Sex,string,yes">
	<option value="0">Select</option>

	<%
				         		if(sexList != null){ 	
				         			for (Iterator iter = sexList.iterator(); iter.hasNext();) {
				         				MasAdministrativeSex administrativeSex = (MasAdministrativeSex) iter.next();
				         %>
	<option value="<%=administrativeSex.getId() %>"><%=administrativeSex.getAdministrativeSexName()%></option>
	<%		} } %>
</select> --%>
<div class="clear"></div>
<%-- <label><span>*</span> Age</label> <input type="text" id="age"
	name="<%= AGE%>" value="" validate="Age,string,yes"
	class="textbox_size20" maxlength="20" tabindex=1 />
	 <label><span>*</span>
Contact No.</label> <input type="text" id="teleNo" name="<%= CONTACT_NUMBER%>"
	value="" validate="Contact No.,phone,yes" class="textbox_size20"
	maxlength="20" tabindex=1 />
	 --%>
	 <%-- <label><span>*</span> Received By
</label> <select id="employeeId" name=<%=EMPLOYEE_ID %>
	validate="Received By,string,yes">
	<option value="0">Select</option>

	<%
				         		if(employeeList != null){ 	
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         				String empName= "" ;
				         				empName = masEmployee.getFirstName();
				         				if(masEmployee.getMiddleName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getMiddleName());
				         				if(masEmployee.getLastName() != null)
				         					empName = empName.concat(" ").concat(masEmployee.getLastName());
				         %>
	<option value="<%=masEmployee.getId() %>"><%=empName%></option>
	<%		} } %>
</select> --%>
<div class="clear"></div>

<div class="clear"></div>
<input type="hidden" value="0" name="pagecounter2" /> <!-- Block Three Ends -->
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="" />

<div class="clear"></div>
<h4>List Of Tests</h4>
<div class="clear"></div>

<div class="tableHolderAuto">

<%-- <table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th>SR No</th> -->
			<th>Name Of Test</th>
			<th>Reactive</th>
			<th>Non-Reactive</th>
			<!-- <th><span>*</span>Result</th> -->
		</tr>
	</thead>
	<tbody>
		
		<%
		
		for(BloodResultEntryDetails bsd:screenDetailList){
			System.out.print(bsd.getResult());
		%>
		<tr>
			
			<td><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %><%=inc %>"
				value="" /></td>
				
				
			<td><input type="text" size="20" id="investigationName"
				name="investigationNameaa" value="<%=bsd.getInvestigation().getInvestigationName()%>"
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
				
				<input type="hidden" size="20" id="investigationName"
				name="investigationName" value="<%=bsd.getInvestigation().getId()%>"
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
			<div id="ac2update6" style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('investigationName','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName'});
			</script></td>
			
			<!-- <input type="text" size="40" id="investigationName"
				name=""
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
			<div id="ac2update6" style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('investigationName','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName'});
			</script> -->
			<%if(bsd.getResult().equalsIgnoreCase("y")){ %>
			<td>
			<input type="radio" checked="checked" name="reactive<%=bsd.getInvestigation().getId() %>" value="y">
			</td>
			<%}else{ %>
			<td>
			<!-- <input type="text" id="result" value=""
				name="" maxlength="100" size="100" tabindex="1" /> -->
				<input type="radio"  name="reactive<%=bsd.getInvestigation().getId() %>" value="y">
				
			</td>
			<%} 
			if(bsd.getResult().equalsIgnoreCase("n")){%>
			<td><input type="radio" checked="checked" name="reactive<%=bsd.getInvestigation().getId()  %>" value="n"></td>
			<%}else{%>
			<td><input type="radio"  name="reactive<%=bsd.getInvestigation().getId()  %>" value="n"></td>
			<%} %>
		</tr>
		<%} %>
		
	</tbody>
</table> --%>
</div>
<div class="clear"></div>

<div id="div3">
<!-- <label><input id="id_radio1" type="radio" class="radioCheckCol2" name="name_radio1" checked="checked" value="1" />Cell Grouping</label>
 <label><input id="id_radio2" type="radio"class="radioCheckCol2" name="name_radio1" value="2" />Serum Grouping</label> -->
<!-- <label>Blood Group</label> 
<input id="id_radio2" type="radio"class="radioCheck" name="name_radio1" value="2" /> -->
<div class="clear"></div>
<%-- <div id="divs1" class="desc">
  
	 <label>Blood Group</label> 
   
	<select id="pType" name="ccbloodGroup"
	validate="Type,string,no">
	<option value="">Select</option>
	<%
	for(MasBloodGroup masbldG:bloodGroupList){
	%>
	<option value="<%=masbldG.getId()%>"><%=masbldG.getBloodGroupName()%></option>
	<%} %>
</select>  
<label>Rh Type</label> 
   
	<select id="pType" name="cgRh"
	validate="Type,string,no">
	<option value="0">Select</option>
	<option value="+">+ve</option>
	<option value="-">-ve</option>
</select> 
 
 <!-- <div class="clear"></div>
 <label>Discrepancy</label> 
  <textarea rows="4" cols="50">

</textarea> 
 -->
<label>Remarks</label> 
 <textarea rows="4" cols="50">
 
</textarea> 
  </div> --%>
  
  <div id="divs2" class="desc">
   
 <label>Blood Group<span>*</span></label> 
   
	<select id="pType" name="ccbloodGroup"
	validate="Blood Group,int,yes">
	<option value="">Select</option>
	<%
	for(MasBloodGroup masbldG:bloodGroupList){
	%>
	<option value="<%=masbldG.getId()%>"><%=masbldG.getBloodGroupName()%></option>
	<%} %>
</select>  
 
 <!-- <label>Discrepancy</label> 
  <textarea rows="4" cols="50">
 
</textarea>  -->

 <label>Remarks</label> 
 <textarea name="sgRemark" rows="4" cols="50" class="textareaMediua">
 
</textarea> 
 </div>
  
  </div>
  
<div class="clear"></div>

<input type="hidden" name="rowCount" value="">
<div class="clear"></div>
<div class="clear"></div>




<!-- <label>Remarks</label> 
 <textarea rows="4" cols="50">

</textarea> -->
<div class="clear"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('testEntry','bloodBank?method=submitBloodTestEntrySg');"
	align="right" /> 
	
	<!-- <input type="button" class="buttonBig2" name="button"
	id="reset" value="Sample Discard" onclick="resetClicked('testEntry');"
	accesskey="r" /> -->
<div class="clear"></div>

<div class="clear"></div>
<%-- <div class="bottom">

<label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>

<div class="clear"></div>
</div> --%>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>

<script>
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
		
		ajaxFunctionForAutoCompleteInvestigationName('testEntry','bloodBank?method=fillItemsForInvestigationName&investigationName=' +  investigationName , inc);
		
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
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('investigationName'+i).value != ""){
	  			if(document.getElementById('result'+i).value == ""){
	  				msg += "Result can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
function validateRequiredDate(){
	var nowDate=new Date();
		
		obj1 = eval(document.testEntry.testDate)
			
		if(obj1.value != "" )
		{
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
			
			if(nowDate<validFromDate)
				{
				alert("Future Test Date should not be allowed.!!");
				document.getElementById("testDate").value=""
				return false;
				}
		}
		return true;
	}
</script>