<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningDetail"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>
<%@page import="jkt.hms.masters.business.BloodResultEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodResultEntryDetails"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<title>Result Entry</title>

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
	
	
	//List<DgMasInvestigation> investigationList= new ArrayList<DgMasInvestigation>();
	
List<BloodResultEntryHeader> resultList=new ArrayList<BloodResultEntryHeader>();
		
		List<BloodResultEntryDetails> investigationList=new ArrayList<BloodResultEntryDetails>();
		


if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if(map.get("resultList") != null)
{
	resultList=(List<BloodResultEntryHeader>)map.get("resultList");
}
if(map.get("investigationList") != null)
{
	investigationList=(List<BloodResultEntryDetails>)map.get("investigationList");
}

String BagNum="";
String TubNum="";
int Quantity=0; 
String cgBloodGrop="";
String cgRhfactor="";
String cgRemark="";
String sgBloodGroup="";
String sgRemark="";

int cgBloodGropId=0; int sgBloodGropId=0;
int bldSamplescreenHId=0;
int bldSampleColectionId=0;
  if(null !=resultList && resultList.size()>0){
	  for(BloodResultEntryHeader bsh:resultList){
		  if(null !=bsh.getScreeningTest()){
		  BagNum=bsh.getScreeningTest().getSampleCollection().getBagNumber();
		  TubNum=bsh.getScreeningTest().getSampleCollection().getTubeNumber();
		  bldSamplescreenHId=bsh.getId();
		  if(null !=bsh.getSampleCollection().getComponentQuantity()){
			 
		  Quantity=bsh.getSampleCollection().getComponentQuantity();
		  }
		  if(null !=bsh.getCgBloodGroup()){
			  
		  cgBloodGrop=bsh.getCgBloodGroup().getBloodGroupName();
		  cgRhfactor=bsh.getCgRhFactor();
		  cgBloodGropId=bsh.getCgBloodGroup().getId();
		  }
		  if(null !=bsh.getSgBloodGroup()){
		  sgBloodGroup=bsh.getSgBloodGroup().getBloodGroupName();
		    sgBloodGropId=bsh.getSgBloodGroup().getId();
		  }
		  if(null !=bsh.getCgRemark() && !bsh.getCgRemark().equals("null"))
		  cgRemark=bsh.getCgRemark();
		  
		   if(null !=bsh.getSgRemark() && !bsh.getSgRemark().equals("null"))
		   sgRemark=bsh.getSgRemark();
		  }
		  else{
			  BagNum=bsh.getSampleCollection().getBagNumber();
			  TubNum=bsh.getSampleCollection().getTubeNumber();
			  bldSamplescreenHId=bsh.getId();
			  if(null !=bsh.getSampleCollection().getComponentQuantity()){
				 
			  Quantity=bsh.getSampleCollection().getComponentQuantity();
			
			  }
			 
			  if(null !=bsh.getCgBloodGroup()){
			  cgBloodGrop=bsh.getCgBloodGroup().getBloodGroupName();
			  cgRhfactor=bsh.getCgRhFactor();
			  cgBloodGropId=bsh.getCgBloodGroup().getId();
			  }
			 
			  if(null !=bsh.getSgBloodGroup()){
				 
			  sgBloodGroup=bsh.getSgBloodGroup().getBloodGroupName();
			  sgBloodGropId=bsh.getSgBloodGroup().getId();
			  }
			  if(null !=bsh.getCgRemark() && !bsh.getCgRemark().equals("null"))
			  cgRemark=bsh.getCgRemark();
			  
			   if(null !=bsh.getSgRemark() && !bsh.getSgRemark().equals("null"))
			   sgRemark=bsh.getSgRemark();
		  }
	  }
  }

	
%>
<div class="titleBg">
<h2> Validate Result Entry</h2>
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
	name="<%=CURRENT_DATE %>" value="<%=date %>" title="Current date" validate="currentDate,date,no"/> 
	
	 <label>Bag Number</label> 
	 <input	type="text"  name="BagNumber" value="<%=BagNum %>" tabindex=1 maxlength="20" validate="Bag,String,no"
	 onblur="ajaxFunctionForTestPatient(testEntry);" /> 
	 
	 <input id="bldSamplescreenHId"	type="hidden" name="bldResultcreenHId" value="<%=bldSamplescreenHId%>" validate="Bag,metachar,no"/>
	 <input id="bldSampleColectionId"	type="hidden" name="bldSampleColectionId" value="<%=bldSampleColectionId%>" validate="Bag,metachar,no"/>	
	
	 <label>Tube Number</label> 
	 <input	type="text"  name="TubeNumber" value="<%=TubNum %>" tabindex=1 validate="Tube,metachar,no"
	  maxlength="20" onblur="ajaxFunctionForTestPatient(testEntry);" /> 	  
	 <input id="hinId"	type=hidden name="<%=HIN_ID%>" value="" validate="hinId,int,no"/>
	
	 <label>Quantity Collected</label> 	 
	 <input type="text"  name="Quntity"
	value="<%=Quantity %>"  class="textbox_size20"
	maxlength="20" tabindex=1 validate="Quntity,metachar,no"/><label class="smallAuto">ml</label>
	<div class="clear"></div>
	<label>Visual Inspection of Blood</label>
<select id="pType" name=<%=PATIENT_TYPE %>
	validate="patientType,metachar,no">
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
<input type="hidden" value="0" name="pagecounter2" validate="pagecounter2,int,no"/> <!-- Block Three Ends -->
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="" validate="pageNo,int,no"/>

<div class="clear"></div>
<h4>List Of Tests</h4>
<div class="clear"></div>

<!-- <div class="tableHolderAuto"> -->
<div class="tableForTab" style="width:1100px; height:352px; overflow: scroll;">
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
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
		
		for(BloodResultEntryDetails  bsd:investigationList){
		%>
		<tr>
			
			<%-- <td><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" /> <input type="hidden"
				id="investigationId<%=inc %>" name="<%=INVESTIGATION_ID %><%=inc %>"
				value="" /></td>
				 --%>
				
			<td><input type="text" size="50" id="investigationName"
				name="investigationNameaa" value="<%=bsd.getInvestigation().getInvestigationName()%>"
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
				
				<input type="hidden" size="20" id="investigationName"
				name="investigationName" validate="investigationName,metachar,no" value="<%=bsd.getInvestigation().getId()%>"
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
			<div id="ac2update6" style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('investigationName','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName'});
			</script></td>
			
			<td><!-- <input type="text" size="40" id="investigationName"
				name=""
				onblur="if(fillSrNo('')){checkForInvestigationName(this.value, '');}" />
			<div id="ac2update6" style="display: none;" class="autocomplete">
			</div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('investigationName','ac2update6','bloodBank?method=getTestName',{parameters:'requiredField=investigationName'});
			</script> -->
			<input type="radio" name="reactive<%=bsd.getInvestigation().getId() %>" value="y" validate="reactive,metachar,no">
			</td>
			
			<td>
			<!-- <input type="text" id="result" value=""
				name="" maxlength="100" size="100" tabindex="1" /> -->
				<input type="radio" checked="checked" name="reactive<%=bsd.getInvestigation().getId()  %>" value="n" validate="reactive,metachar,no">
			</td>
			
		</tr>
		<%} %>
		
	</tbody>
</table>
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
  
 <div id="divs1" class="desc">
  <h4>Cell Grouping</h4>
	 <label>Blood Group</label> 
  
    
    <input Type="hidden" id="cgBloodGropId" name="cgBloodGropId" value="<%= cgBloodGropId%>" readonly="readonly"
	validate="ccbloodGroup,metachar,no"/>
	
	<input Type="hidden" id="sgBloodGropId" name="sgBloodGropId" value="<%= sgBloodGropId%>" readonly="readonly"
	validate="ccbloodGroup,metachar,no"/>
	
	<input Type="text" id="pType" name="ccbloodGroup" value="<%= cgBloodGrop%>" readonly="readonly"
	validate="ccbloodGroup,metachar,no"/>
	
<label>Rh Type</label> 
   
	<input Type="text" name="cgRh" value="<%= cgRhfactor%>" readonly="readonly"
	validate="cgRh,string,no"/>
	

 
<label>Remarks</label> 
 <input type="text" name="cgRemark" value="<%=cgRemark%>" readonly="readonly" validate="cgRemark,metachar,no"/>
  </div>

 <%-- <label>Discrepancy</label> 
 <input type="text" name="cgRemark" value="<%=%>"/>
 </div> --%>
  
  </div>
  
<div class="clear"></div>

<h4>Serum Grouping</h4>
	 <label>Blood Group</label> 
   
	<input Type="text" id="pType" name="sgbloodGroup" value="<%= sgBloodGroup%>" readonly="readonly"
	validate="sgbloodGroup,metachar,no"/>
	
<label>Remarks</label> 
 <input type="text" name="sgRemark" value="<%=sgRemark%>" readonly="readonly" validate="sgRemark,metachar,no"/>
  <div class="clear"></div>
 <label>Discrepancy</label> 
 <input type="text" name="discrepancy" value="" validate="sgRemark,metachar,no"/>
 


<div class="clear"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('testEntry','bloodBank?method=validateResulTestEntry');"
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

</div>
</form>
<div class="clear"></div>


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