
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Ujjwal Kashyap
* Create Date: 31st Dec 2015
* Revision Date:
* Revision By:
* @version 1
--%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.UHID_FOR_QUALITY_TESTING"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

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

<div class="clear"></div>
<%

String time = "";
String userName = "";
int hospitalId = 0;
int deptId = 0;
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	date = (String)utilMap.get("currentDate");
	time = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null)
	{
	userName = (String)session.getAttribute("userName");
}

Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}





List<StorePoHeader> poHeaderList=new ArrayList<StorePoHeader>();
if(map.get("poHeaderList") != null)
{
	poHeaderList=(List<StorePoHeader>)map.get("poHeaderList");
}
%>


<script language="Javascript">
function showValue()
{
	if(document.localPurchaseItemTracking.nomenclature.value != "")
	{
	var val = document.localPurchaseItemTracking.nomenclature.value;
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
		
		if(document.localPurchaseItemTracking.nomenclature.value != "")
		{
		var val = document.localPurchaseItemTracking.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);

	   		 if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;

	    	
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Item Name!....");
			}
		}
	else if(document.localPurchaseItemTracking.pvms.value != "")
		{
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		}
		submitForm('localPurchaseItemTracking','procurement?method=printForLocalPurchaseItemTrackingScreen');
	
}

function showReport1()
{
		
		if(document.localPurchaseItemTracking.nomenclature.value != "")
		{
		var val = document.localPurchaseItemTracking.nomenclature.value;
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
   		 if (pvms!="")
	   	 	{
	    	document.getElementById("pvms").value=pvms;
			}
			
		}
		submitForm('localPurchaseItemTracking','procurement?method=printForLocalPurchaseItemTracking');
}









function validateDates()
{
	var strValue = document.localPurchaseItemTracking.<%=FROM_DATE%>.value;
	var fromDate = new Date(strValue.substring(6),(strValue.substring(3,5) - 1) ,strValue.substring(0,2));
	strValue = document.localPurchaseItemTracking.<%=TO_DATE%>.value;
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
<form name="localPurchaseItemTracking" method="post">
<h2>Local Purchase Item Tracking</h2>
<div class="clear"></div>
<div class="Block">


<label>From Date </label>
<input	type="text" name="<%=FROM_DATE%>" value="" class="date"	validate="fromDate,date,no" MAXLENGTH="30"	readonly="readonly"   /> 
<img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.localPurchaseItemTracking.<%=FROM_DATE%>,event)" />
<label>To Date </label>
<input	type="text" name="<%=TO_DATE%>" value="" class="date"	validate="toDate,date,no" MAXLENGTH="30"	readonly="readonly"  onblur="submitProtoAjaxWithDivName('localPurchaseItemTracking','/hms/hms/procurement?method=getFromDateAndToDate','testDiv');"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	class="calender" tabindex="1"	onClick="submitProtoAjaxWithDivName('localPurchaseItemTracking','/hms/hms/procurement?method=getFromDateAndToDate','testDiv');setdate('<%=date%>',document.localPurchaseItemTracking.<%=TO_DATE%>,event)"/>

  <div id="testDiv">
<label>PO Number <span>*</span></label>
<select name="poNubner" id="poId">
<option value="0">Select</option>
<%for(StorePoHeader hd:poHeaderList){ %>
<option value="<%=hd.getId()%>"><%=hd.getPoNumber() %></option>
<%} %>
</select>

</div>

<input	type="hidden" name="item_id" size="5" id="item_id"/>
<label>Item Name </label>

<input type="text"	value="" id="nomenclature" name="nomenclature" onkeypress="return showValue()" />
<div id="ac2update" style="display: none;"	class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});</script>
<label>Item Code </label>
<input type="text"	value="" id="pvms" name="pvms" />
<div class="clear"></div>



<input type="button" name="report" onClick="showReport1();" 	value="pdf" class="button" />
<input type="button" name="report" onClick="showReport();" 	value="HTML" class="button" />


</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>
