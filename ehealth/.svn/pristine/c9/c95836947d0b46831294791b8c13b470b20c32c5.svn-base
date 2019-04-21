<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title>Donor Assessment</title>
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
<script type="text/javascript" src="/hms/jsp/js/jquery-1.4.2.js"></script>

<script type="text/javascript">

function Show_Div(Div_id) {

    if (false == $(Div_id).is(':visible')) {

        $(Div_id).show(250);

    }

    else {

        $(Div_id).hide(250);

    }

}

     
</script>

<script type="text/javascript">
$(document).ready(function(){
$('#y').hide();
$("#preDonate").change(function(){
	$('#y').hide('slow');
	$("#" + this.value).show('slow');
});
});
</script>


<%
String errorMsg = "";
errorMsg = "BloodBagNo. ";
String donorUID="";
String donorName="";
String registerNum="";

int donationhdId = 0;
	int pageNo=1;
	String donorSerialNum="";
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
 	
 	List<MasOccupation> occupationList = new ArrayList<MasOccupation>();
 	List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
 	List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
 	List<MasState> stateList = new ArrayList<MasState>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	
	List<BloodDonationEntryHeader> donationList=new ArrayList<BloodDonationEntryHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("donationList")!=null){
		donationList=(ArrayList)map.get("donationList");
		
		for(BloodDonationEntryHeader bde:donationList){
			System.out.print(bde.getDonerName());
		}
	}
	
	if(map.get("donorUID") != null){
		donorUID=  map.get("donorUID").toString();
		}
	if(map.get("donorSerialNum") != null){
		donorSerialNum=  map.get("donorSerialNum").toString();
		}
	if(map.get("donorName") != null){
		donorName= map.get("donorName").toString();
		}
	
	if(map.get("bloodGroupList") != null){
		bloodGroupList = (ArrayList)map.get("bloodGroupList");
	}
	if(map.get("employeeList") != null){
	    employeeList =(ArrayList) map.get("employeeList");
	}
	if(map.get("registerNum") != null){
		registerNum =(String) map.get("registerNum");
	}
	
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
	StringTokenizer st = new StringTokenizer(time);
	String currentTime[] =time.split(":");
	String time1 =currentTime[0]+":"+currentTime[1];
	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<%} %>

<form name="donorAssessment" method="post" action="">
<div class="titleBg">
<h2>Donor Assessment</h2>
</div>
<!--  Defer Start  -->
<div id="title4">
<div class="Block" id="assessment" >
<div class="clear"></div>

<h4>Donor Details </h4>
<div class="clear"></div>

<label>Donor Reg. No </label> 
	 <input id="uidNo"
	name="registerNum" type="text" value="<%=registerNum %>" readonly="readonly"
	onblur="ajaxFunctionForDonor('bloodDonationEntry');" maxlength="15"
	tabindex=1 validate="registerNum,string,no"/> 
	
	<input id="uId" name="<%=UID%>" type="hidden" value="" tabindex=1 validate="uId,string,no" />

 <label>UHID </label> 
	 <input id="uidNo"
	name="hin_no" type="text" value="<%=donorUID%>"  readonly="readonly"
	onblur="ajaxFunctionForDonor('bloodDonationEntry');" maxlength="23"
	tabindex=1 validate="uId,string,no"/> 
	
	
	
	<label>Donor Name </label> 
	 <input id="uidNo"
	name="<%=UID%>" type="text" value="<%=donorName%>" readonly="readonly"
	onblur="ajaxFunctionForDonor('bloodDonationEntry');" maxlength="15"
	tabindex=1 validate="uId,string,no"/> 
	
	<input id="uId" name="<%=UID%>" type="hidden" value="" tabindex=1 validate="uId,string,no"/>
	<input type="hidden" name="donorSerialNum" value="<%=donorSerialNum%>" tabindex=1  validate="donorSerialNum,string,no"/> 
<div class="clear"></div>

<h4>Assessment </h4>
<div class="clear"></div>
<label>Previously Donated</label> <select
	name="<%=PREVIOUSLY_DONATED%>" class="smallest-" tabindex="1" validate="previoulsyDonated,string,no"
	id="preDonate" onchange="preDonated(bloodDonationEntry);">
	<option value="n">No</option>
	<option id="other" value="y">Yes</option></select>
	
 <div id="y">
 <label class="smallAuto">If yes, No. of times</label> <input
	id="noOfTimes" type="text" class="smallest" name="<%=NUMBER_OF_TIME %>"
	 maxlength="2" value=""
	 tabindex="1" validate="numberOfTime,int,no"/> 
	
	<label class="auto">When Last Donated</label> 
	<input type="text" class="date" id="lastDateId"
	name="<%=LAST_DONATED_DATE %>"  value=""
	 MAXLENGTH="10" tabindex="1" validate="lastDonatedDate,date,no"/> 
	<img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	
	onClick="setdate('<%=currentDate %>',document.bloodDonationEntry.<%=LAST_DONATED_DATE%>,event)" />
	<div class="clear"></div>
</div>


<label>Time of Last Meal</label> <input id="lastMealTime"
	name="<%=LAST_MEAL_TIME %>" type="text"
	onKeyUp="mask(this.value,this,'2',':');"
	onblur="IsValidTime(this.value,'lastMealTime')" maxlength="5"
	tabindex="1" validate="lastMealtime,string,no"/> 
	
	<label class="heightAuto">Any discomfort during/after donation</label> 
<select name="<%=DISCOMFORT%>" class="smallest-"
	tabindex="1" validate="discomfort,string,no">
	<option value="n">No</option>
	<option value="y">Yes</option>
</select>

<input type="hidden" value="${fn:length(requestScope.map.assesstmentDetailList)}" name="assestmentSize" id="assestmentSizeId" validate="assestmentSize,int,no"/>
<div class="clear"></div>
<c:if test="${not empty requestScope.map.assesstmentDetailList}">
<c:forEach var='assesstment' items="${requestScope.map.assesstmentDetailList}" >

<label class="largeAutoHeight">${assesstment.assessmentName}</label> 
<label class="autoSize"><input type="radio"  class="radioCheckCol2" name="${assesstment.assessmentName}" value="y" tabindex=1 validate="assessmentName,string,no" />Yes</label>
<label class="autoSize"><input type="radio" class="radioCheckCol2" checked="checked" name="${assesstment.assessmentName}" value="n" tabindex=1 validate="assessmentName,string,no" /> No</label>

<input type="hidden" name="${assesstment.assessmentName}${assesstment.id}" value="${assesstment.assessmentName}" tabindex=1  validate="assessmentName,string,no"/> 
<input type="hidden" name="${assesstment.id}" value="${assesstment.id}" tabindex=1 validate="assessmentId,int,no" /> 
<input type="hidden" name="${assesstment.assessmentType}${assesstment.id}" value="${assesstment.assessmentType}" tabindex=1 validate="assessmentType,string,no" /> 

<div class="clear"></div>

</c:forEach>
</c:if>
<c:if test="${empty requestScope.map.assesstmentDetailList}">
<h4> No Data Available</h4>
</c:if>

<div class="clear"></div>

<h4>Declaration Of Donor </h4>
<div class="clear"></div>

<div id="displayText" style="padding:0px 0px 10px 10px;">
I have completed 18 years of age. I am not a professional donor. I am wiling to donate one unit of blood and give consent for my blood being tested for transfusion transmitted disease. The medical history that I have furnished is true to the best of my knowledge and I understnad that the question asked are for my own safety and safety of the patient receving my blood.
</div>

<label>Do you accept this ? </label>
<label class="autoSize"><input type="radio" class="radioCheckCol2"  name="consent" value="yes">yes</label>
<label class="autoSize"><input type="radio" class="radioCheckCol2"  name="consent" value="No">No</label>
<label>Cell Grouping Request</label>
<input type="checkbox" value="y" name="cellGroupingRequest">
<div class="clear"></div>
<div class="clear"></div>
<!-- <div id="displayText" align="right">
Signature of Donor
</div> -->
<div class="clear"> </div>
<div class="clear"> </div>
<div class="clear"> </div>


<input type="button" class="button" value="Submit"
	onclick="if(checkAssesstment()){submitForm('donorAssessment','/hms/hms/bloodBank?method=submitDonarAssessment')}"
	align="right" tabindex=1 /> 
	
	<input type="reset"
	class="button" name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodDonationEntry');" accesskey="r"
	tabindex=1 />
	
	<input type="button"
	class="button" name="Print Declaration Form" id="reset" value="Print Declaration Form"
	onclick="submitForm('donorAssessment','/hms/hms/bloodBank?method=printDeclarationForm');" accesskey="r"
	tabindex=1 />
	
	<input type="button"
	class="button" name="Upload Declaration Form" id="reset" value="Upload Declaration Form"
	onclick="" accesskey="r"
	tabindex=1 />
	
	<!-- <input type="button"
	class="button" name="Print EHR" id="reset" value="Upload Declaration Form"
	onclick="" accesskey="r"
	tabindex=1 /> -->
	<input class="button" type="button" 
	onclick="opnpopupForEHR('<%=donorUID %>');" 
	value="Generate EHR Report" name="Generate EHR Report">
	
<%-- <input type="button"
	class="button" name="Reset" id="reset" value="Physical Examination"
	onclick="submitForm('donorAssessment','bloodBank?method=showPhysicalExaminationJsp&donorAssesstMid=${requestScope.map.donorAssesstMid}')"
	 accesskey="r"
	tabindex=1 /> --%>
<div class="clear"></div>
 
</div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<div class="clear"></div>

<!--Bottom labels starts-->
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>


<!--Bottom labels starts--> <!--main content placeholder ends here--></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
function checkAssesstment(){
	
	var assestmentSize=document.getElementById('assestmentSizeId').value;
	if(!assestmentSize || assestmentSize>0){
		return true;
	}
	else{
		alert("Assesstment Test not available ! ");
		return false;
	}

}

</script>
<!-- <script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}
function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
	/*	if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		*/
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentName('bloodDonationEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
		}
}



		
	function checkBloodBagNoForExisting(bagNoObj, rowCount) 
	{
  	 	var xmlHttp;
     		try {
    			// Firefox, Opera 8.0+, Safari
   	 			xmlHttp=new XMLHttpRequest();
	  		}catch (e){
    		// Internet Explorer
    			try{
     	 			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    			}catch (e){
    				alert(e)
     	 			try{
        				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
     	 			}catch (e){
        				alert("Your browser does not support AJAX!");
        				return false;
      				}
     			}
   			}
    	xmlHttp.onreadystatechange=function()
    	{
     	 	if(xmlHttp.readyState==4){
      		var items =xmlHttp.responseXML.getElementsByTagName('radioIdFlags')[0];
       			for (loop = 0; loop < items.childNodes.length; loop++) 
      			{
	   		    	var item = items.childNodes[loop];
	    	    	var flagValue  = item.getElementsByTagName("flagValue")[0];
	    	    	var checkResult = flagValue.childNodes[0].nodeValue;
	    	    	if(checkResult == 'Duplicate'){
	    	    		
	    	    			alert('Blood Bag No'+ bagNoObj.value + ' already exist.');
	    	    		
	    	    		
	    	    		document.getElementById('bloodBagId'+rowCount).focus();
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='duplicateBloodBagNo';
	    	    		return false;
	    	    	}else{
	    	    		document.getElementById('bloodBagNoValueCheckOnSubmit'+rowCount).value='correctBloodBagNo';
						return true;	    	    	
	    	    	}
      			}
    		}
  		}
  		bagNo = bagNoObj.value;
  		// alert(bagNoObj.value);
  		// alert(rowCount);
  		 //return false;
  		var url="/hms/hms/bloodBank?method=checkForExistingBloodBagNo&bagIdToCheck="+bagNo+"&sampleCollectionIdToCheck="+sampleCollectionIdToCheck;
    	xmlHttp.open("GET",url,true);
    	xmlHttp.setRequestHeader("Content-Type", "text/xml");
    	xmlHttp.send(null);
  		
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
	  	 	if(document.getElementById('bloodBagId'+i)){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
	  			}
	  			if(document.getElementById('componentName'+i).value == ""){
	  				msg += "Component Name can not be blank.\n";
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
function checkForBloodBagNo1(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('bloodBagId'+i).value==val)
		{
			alert("Blood bag already selected...!")
			document.getElementById('bloodBagId'+inc).value=""
			var e=eval(document.getElementById('bloodBagId'+inc)); 
			e.focus();
			return false;
		} }  }
		
		}
}
function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('Maximum Limit is '+maxLimit+' characters.');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	}
}
</script> --> <script type="text/javascript">
		history.forward();
</script>
<script>
function opnpopupForEHR(val){
	
	var hin_no=document.getElementById('uidNo').value;
	//alert("in method!!"+val);
	var url="/hms/hms/bloodBank?method=getForDateJsp&hin_no="+val;
	newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
}
</script>
