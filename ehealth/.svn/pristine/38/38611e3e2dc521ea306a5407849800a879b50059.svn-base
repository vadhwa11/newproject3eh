
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="/hms/jsp/js/jquery-ui.css" />
<script type="text/javascript" src="/hms/jsp/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-ui.js"></script>

<title>Screening Process</title>

<%
    int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<BloodStockDetail> stockList = new ArrayList<BloodStockDetail>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Box box = HMSUtil.getBox(request);
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("stockList") != null){
		stockList=(List)map.get("stockList");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
<%}
%>

<form name="bloodSampleScreening" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Sample Testing</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
 <label>Bag Number</label> 
	 <input	type="text"  name="BagNumber" value="${requestScope.map.bagNum}" readonly="readonly" tabindex=1 maxlength="20" 
	 onblur="ajaxFunctionForTestPatient(testEntry);" /> 
	
	 <input id="samplId" type=hidden name="sampleSequenceId" value="${requestScope.map.samplId}" />
	 
	
	 <label>Tube Number</label> 
	 <input	type="text"  name="TubeNumber" readonly="readonly" value="${requestScope.map.tubNum}" tabindex=1
	  maxlength="20" onblur="ajaxFunctionForTestPatient(testEntry);" /> 
	  
	
	 <label>Quantity Collected</label> 
	 
	 <input type="text" id="teleNo" name="Quntity" readonly="readonly"
	value="${requestScope.map.quantityNum}" 
	maxlength="10" tabindex=1 /><label class="small">ml</label>
	
<div class="clear"></div>
<label>Visual Inspection Of Blood</label>
	<select name="mydropdown">
				<option value="">Select</option>
				</select>
 			
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<h4>List Of Tests</h4>		
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="tableForTab" style="width:890px; height:352px; overflow: scroll;">
<c:if test="${not empty requestScope.map.testlist}">

<table class="" id="testListID" cellpadding="5" width="50%" border="0" cellspacing="0" cellpadding="0">
 		<thead>
		<tr>
			<th >Name Of Test</th>
			<th >Select</th>
		</tr>
		</thead>
	<c:forEach var="testlist" items="${requestScope.map.testlist }">
			<tr>	
			<td ><input type="hidden" class="large" name="${testlist.id}" value="${testlist.investigationName}" />${testlist.investigationName}
			<input type="hidden" name="chargeId" value="${testlist.chargeCode.id}" />
			<input type="hidden" name="mainchargeId" value="${testlist.mainChargecode.id}" /> </td>
			<td style="width:80px"><input type="checkbox" checked="checked" name="selectedTest"  value="${testlist.id}"   /></td>
			</tr>
	</c:forEach>
	</table>
	</c:if>
</div>
	
<div class="clear"></div>
<div class="clear"></div>
<input type="button" class="button" value="Other Test"
	onclick="SelectName()"
	align="right" /> 
	<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

	
</div>

<!--Block One Starts-->

<div class="clear"></div>
<div class="clear"></div>

<!-- <div class="clear"></div>
<div class="paddingTop15"></div>
 -->
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" /> <input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" />

<div class="clear"></div>
<div class="clear"></div>

<div>
<div id="popupdiv" title="Basic modal dialog" style="display: none">
<b> <label>Visual Inspection Of Blood</label>
	<select name="mydropdown">
				<option value="Milk">Select</option>
				<option value="Cheese">B+</option>
				<option value="Bread">O+</option>
				</select></b>
</div>

<div class="clear"></div>



<input type="button" class="button" value="Submit"
	onclick="submitForm('bloodSampleScreening','/hms/hms/bloodBank?method=submitBloodSampleScreeningTest&discardsample=submitsampleScreen')"
	align="right"/>
	<!-- <input type="button" class="buttonBig2" value="Discard Blood"
	onclick="if(checkFilledRow() && checkFilledRow())submitFormDetails();"
	align="right"/>
	 -->
	 
	 <input type="button" class="buttonBig2" name="discardsample" value="Discard Blood"
	onclick="submitForm('bloodSampleScreening','/hms/hms/bloodBank?method=submitBloodSampleScreeningTest&discardsample=Discard Blood')"
	align="right"/>
	
	 
	<input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodSeperation');" accesskey="r" />
<div class="clear"></div>
<%-- <div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div> --%>
<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
<script type="text/javascript">
var popup;
function SelectName() {
    popup = window.open("/hms/hms/bloodBank?method=showBloodTestList", "Popup", "width=500,height=350");
    popup.focus();
}
</script>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
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
function submitFormDetails(){
var stockDtId=document.getElementById("stockDetailId").value
submitForm('bloodSeperation','bloodBank?method=submitBloodComponentSeperation&stockDtId='+stockDtId+'');
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
		
		if(componentId =="")
		{
		
	     document.getElementById('componentCode'+inc).value="";
	  	 document.getElementById('quantity'+inc).value="";
	  	 document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo1').value;
	  	document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			document.getElementById('bloodBagId'+inc).value=""
			document.getElementById('stockMainId1'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentNameForSeparition('bloodSeperation','bloodBank?method=fillItemsForComponentnameSeperation&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('componentCode'+inc).value = "";
			document.getElementById('quantity'+inc).value = "";
			document.getElementById('bloodBagId'+inc).value= document.getElementById('bloodBagNo').value;
			document.getElementById('stockMainId1'+inc).value= document.getElementById('stockMainId').value;
		}
}

function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one row to submit in Blood Component Separation Details.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('bloodBagId'+i).value == ""){
	  				msg += "BloodBag No. can not be blank.\n";
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
function checkFilledRow1(){
	var msg ="";
	  			if(document.getElementById('bloodBagNo1').value == ""){
	  				msg += "Blood Current Stock Details can not be blank.\n";
	  			}
	  			
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }

</script>
