<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

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


<%
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}

  	Map map = new HashMap();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");

		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
%>

<title>BIN Card</title>

<script language="Javascript">
function showValue()
{
	if(document.BINCardForm.nomenclature.value != "")
	{
	var val = document.BINCardForm.nomenclature.value;
    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   		if (pvms!="")
   	 	{
			document.getElementById("pvms").value=pvms;
   	 	}
    }
}

function showReport()
{
		if (!validateDates()) return false;
		if(document.BINCardForm.nomenclature.value != "")
		{
		var val = document.BINCardForm.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);

	    //var batchNo = document.BINCardForm.batchNo.value;
	   		 if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;

	    	submitForm('BINCardForm','stores?method=generateBINCardReport');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Item Name!....");
			}
		}
	else if(document.BINCardForm.pvms.value != "")
		{
	//	BINCardForm.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		submitForm('BINCardForm','stores?method=generateBINCardReport&pvmsNo='+pvms);
		}
	else{
	   alert("Please Enter The value.")
		}
}


function validateDates()
{
	var strValue = document.BINCardForm.<%=FROM_DATE%>.value;
	var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	strValue = document.BINCardForm.<%=TO_DATE%>.value;
 	var toDate  = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	var month = 3;
	var day = 31;
	var year = 2009;
	var seperator = "/"
	var stockDate = new Date(month + seperator + day + seperator + year);

	if (fromDate > toDate)
 	{
		alert('From Date cannot be greater than To Date!....');
		return false;
 	}

 	if (fromDate < stockDate)
 	{
 		alert('From Date cannot be lesser than Stock Date (31/03/2009) !....');
		return false;
 	}

 	return true;

}


</script>
<form name="BINCardForm" method="post">
<input type="hidden" name="hospitalId"	size="5" value="<%=hospitalId%>" validate="hospitalId,int,no"/>
<input type="hidden"	name="deptId" size="5" value="<%=deptId%>" validate="deptId,int,no"/>
<input	type="hidden" name="item_id" size="5" id="item_id"/>
<div class="clear"></div>
<div class="titleBg">
<h2>BINCard Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input	type="text" name="<%=FROM_DATE%>" value="<%=date%>" class="date"	validate="fromDate,date,yes" MAXLENGTH="30"	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.BINCardForm.<%=FROM_DATE%>,event)" />
<label><span>*</span> To Date </label>
<input	type="text" name="<%=TO_DATE%>" value="<%=date%>" class="date"	validate="toDate,date,yes" MAXLENGTH="30"	readonly="readonly" /> <img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.BINCardForm.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<div class="clear"></div>
<label>Item Name </label>
<input type="text"	value="" id="nomenclature" name="nomenclature" onkeypress="return showValue()" />
<div id="ac2update" style="display: none;"	class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});</script>
<label>Item Code </label>
<input type="text"	value="" id="pvms" name="pvms" />
<!-- 
<label>Batch No </label>
<input type="text"	value="" id="batchNo" name="batchNo" />
 -->
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="showReport();" 	value="Submit" class="button" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
