<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasMainChargecode"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<script type="text/javascript">
function getSubchargeCodeList() 
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
   var mainCharge=document.getElementById("mainCharge").value;
   
    var url="lab?method=getSubChargeCodeList&mainCharge="+mainCharge+"";
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
      	var subCharge=document.getElementById("subCharge");
      	subCharge.length = 1;
      	subCharge.options[subCharge.length-1].value="0";
      		subCharge.options[subCharge.length-1].text="Select";
      	
      	for (loop = 0; loop < items.childNodes.length; loop++) 
      	{	
      	
      	subCharge.length++;
 				var item = items.childNodes[loop];
	
	 			var id  = item.getElementsByTagName("id")[0];
	      		var pvms  = item.getElementsByTagName("pvms")[0];
	      
	       		var name  = item.getElementsByTagName("name")[0];
				subCharge.options[subCharge.length-1].value=id.childNodes[0].nodeValue;
				subCharge.options[subCharge.length-1].text=name.childNodes[0].nodeValue+"["+pvms.childNodes[0].nodeValue+"]";			
				
      	
	   	  
	      
        	
      }
    }
  }
}

function getChargeCodeList() 
{
 var subCharge=document.getElementById("subCharge").value
 //if(subCharge!="0"){
 submitProtoAjaxWithDivName('chargeList','/hms/hms/lab?method=getChargeCodeList&subCharge='+subCharge+'','chargeDiv');
 //}
}
</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasMainChargecode>masMainChargecodeList=new ArrayList<MasMainChargecode>();
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map")!=null){
		map=(	Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("masMainChargecodeList") !=null){
		masMainChargecodeList=(List<MasMainChargecode>)	map.get("masMainChargecodeList");
	}
		
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="chargeList" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Charge List Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Main Charge </label> 
<select
	name="mainCharge" id="mainCharge" validate="main charge,int,no"
	onblur="getSubchargeCodeList()">
	<option value="0">select</option>
	<%for(MasMainChargecode masMainChargecode :masMainChargecodeList){ %>
	<option value="<%=masMainChargecode.getId()%>"><%=masMainChargecode.getMainChargecodeName() %>[<%=masMainChargecode.getMainChargecodeCode() %>]</option>
	<%} %>
</select> 
<label> Sub Charge </label> 
<select name="subCharge" id="subCharge"  validate="sub charge,int,no"
	onblur="getChargeCodeList()">
	<option value="0">select</option>
</select>
<div id="chargeDiv">
<label> Charge </label> <select name="charge" id="charge"  validate="charge,int,no">
	<option value="0">select</option>
</select></div>
<div class="clear"></div>
<label> Date Required </label> 
<input type="text" name="<%= TO_DATE %>" value="" class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="setdate('<%=currentDate%>',document.chargeList.<%= TO_DATE%>,true);" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('chargeList','/hms/hms/lab?method=printChargeListReport');"></input>
<div class="clear"></div>
<div class="division"></div>
</form>