
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
	
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>

<form name="bloodBagCrossCheckingForm" method="post" action="">
<div class="titleBg">
<h2>Sample Testing</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
 <label>Bag Number</label> 
	 <input	type="text"  name="BagNumber" value="${requestScope.map.bagNum}" readonly="readonly" tabindex=1 maxlength="20" 
	 onblur="ajaxFunctionForTestPatient(testEntry);" /> 
	
	 <input id="samplId" type="hidden" name="sampleSequenceId" value="${requestScope.map.samplId}" />
	 
	
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

<input type="text" id="bagBarcode" name="bagBarcode" value=""/>

<input type="button" class="buttonBig2" value="Scan Bag Bar Code"  /> 
	
<input type="text"  id="tubeBarcode" name="tubeBarcode" value="" onblur="crossCheckBagTube(this.value)"/>

<input type="button" class="buttonBig2" value="Scan Tube Bar Code" /> 
	
	<input type="button" id="untestedstockId" class="buttonBig2"
	 value="Transfer to untested stock" style="display: none" 
	 onclick="submitForm('bloodBagCrossCheckingForm','/hms/hms/bloodBank?method=saveUntestedBloodBags')"/> 
	
	<!-- <input type="button" class="buttonBig2" value="Scan Tube Bar Code"
	onclick="SelectName()" />  -->

	<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
	
</div>


<div class="clear"></div>

<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
var popup;
function SelectName() {
    popup = window.open("/hms/hms/bloodBank?method=showBloodTestList", "Popup", "width=500,height=350");
    popup.focus();
}

function crossCheckBagTube(){
	var tubeBarCode=document.getElementById('tubeBarcode').value;
	var bagBarcode=document.getElementById('bagBarcode').value;
	if(bagBarcode==""){
		alert("First scan bag bar code")
	}
	else{
		if(tubeBarCode!="" ){
			if(tubeBarCode==bagBarcode){
				alert("Bar code matched")
				document.getElementById('untestedstockId').style.display="block";
				
			}
			else{
				alert("Bar code not matched")
				document.getElementById('untestedstockId').style.display="none";
			}
		}
	}
	
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
