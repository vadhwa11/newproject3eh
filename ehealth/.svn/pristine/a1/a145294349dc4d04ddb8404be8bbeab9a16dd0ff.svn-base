
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">

	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript">
function checkk()
{
var SDate = document.survey.<%= FROM_DATE%>.value;
var EDate = document.survey.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
	if(!displayAlert("Please ensure that the To Date is greater than or equal to the From Date."))
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
	getShadowWithObj(document.calldate.next_day);
//document.calldate.next_day.focus();
return false;
}
}
		function submitProtoAjaxWithDivNameToShowStatus(formName,action,divName){
		errorMsg = "";
		ob1 = true;
		ob2 = true;
		ob3 = true;
		obj = eval('document.'+formName)

		       	obj.action = action;
	    	   	var url=action+"&"+getNameAndData(formName)

	            var oOptions = {
	                asynchronous:true, evalScripts:true,
	                onFailure: function () {
	    	   		if(!displayAlert("An error occurred:"))
		    	   		alert("An error occurred:");
	                },
	                onLoaded : function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                },
	                onInteractive :function () {
	                   document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	                },
	               // onLoading : function () {
	               //    document.getElementById(divName).innerHTML='<font id="error">Loading...</font>'
	               // }

	            }
	           } ;

</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	List<StorePoHeader> poHeaderList = new ArrayList<StorePoHeader>();

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	List<MasDistrict> district = new ArrayList<MasDistrict>();
	if(map.get("masDistrict") !=null){
		district=(List<MasDistrict>)map.get("masDistrict");
	}

	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
%>
<div class="titleBg">
<h2>Survey Report</h2>
</div>
<form name="survey" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input 	type="text" name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.survey.<%=FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> <input type="text"
	class="date" name="<%=TO_DATE%>" id="toDateId"  value="<%=currentDate%>"
	validate="To Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.survey.<%=TO_DATE%>,event);" />
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<!-- <input type="button" name="add" id="addbutton" value="Survey"
	class="buttonBig"
	onClick="submitProtoAjaxForSurvey('survey','/hms/hms/pubHealth?method=getSurveyCount','tDiv');"
	accesskey="a" tabindex=1 />
	 -->
	<input type="button" name="add" id="addbutton" value="Send Mail"
	class="buttonBig"
	onClick="submitProtoAjaxForSurvey('survey','/hms/hms/pubHealth?method=sendMailOfSurvey','tDiv');"
	accesskey="a" tabindex=1 />
	
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
 <div id="tDiv">
<label>House Survey</label>
<label>Member Survey</label>
<div class="clear"></div>
<label>Village Survey</label>

<label>Family Survey</label>
<div class="clear"></div>

</div>
<div class="clear"></div>

<div class="clear"></div>
</div>
<div class="clear"></div>
	
	<script type="text/javascript">
	
	function enableRadio(){
    
     var x=document.getElementById("district").value;
     
		if(x > 0 ){
   document.getElementById("divEnchashment").style.display ='block';
		}
		else {
			 document.getElementById("divEnchashment").style.display ='none';	
		}
	}
	
	</script>
	
	
	
	
	
	</form>







