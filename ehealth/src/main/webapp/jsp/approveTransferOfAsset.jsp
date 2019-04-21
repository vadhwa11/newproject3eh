
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dates=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(dates.length()<2){
		dates="0"+dates;
	}
%>
serverdate = '<%=dates+"/"+month1+"/"+year1%>'
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println("<h4>"+message+"</h4>");
	  }

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
} 
%>


<div class="clear"></div>

<form name="assestDetails"  method="post" action=""  >

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">




<div class="titleBg">
<h2>Approve Transfer Of Asset</h2>
</div>

<form name="searchPanel" method="post">

<div class="Block">

<label> Asset Name<span>*</span></label> 
<input type="text" name="assetName" id="assetName" value="" validate="Asset Name,metachar,no" class="textbox_size20" MAXLENGTH="32" tabindex="1"/> 

<label> Transfer Mode Category<span>*</span></label> 
 <select name="transferModeCategory" id="transferModeCategory" validate="Transfer Mode Category,string,yes" tabindex="1" >
<option value="Internally">Internally</option>
<option value="Institutional">Institutional</option>
</select>

<label>Asset Require Date</label> 
<input type="text" name="assetRequireDate" value="" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.assestDetails.assetRequireDate,true);" />

<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick=""; />
</div>
</form>


<div class="clear"></div>
<form name="itemGrid" method="post">




<div class="cmntable">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>
			<th width="13%">Sl No.</th>
			<th width="13%">Asset Name</th>
			<th width="10%">Asset Require Date</th>
			<th width="10%">Department/U</th>
			
		</tr>
	</thead>
	<tbody>
		<tr onclick="submitForm('itemGrid','procurement?method=showAssetApprovedJsp');">
			<td>
			<label>1</label>
			</td>
			<td>
			<label>ABC</label>
			</td>
			
			<td>
			<label>01/01/2015</label>
			</td>
			
			<td>
			<label>Accounts</label>
			
			</td>
			
			
		</tr>
	</tbody>
</table>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />		   			
   </div>

	<div class="Clear"></div>

</form>
<script>
function getCal()
{
	var	l=document.getElementById('landMeasurementh').value;
	var x=document.getElementById('landMeasurementw').value;
	var e=0;
	if(l!="" && x!="")
	{
		e=l*x;
		document.getElementById('landExtent').value=e;
		document.getElementById('landExtent').readOnly=true;
	}
	else{
		document.getElementById('landExtent').value="";
		document.getElementById('landExtent').readOnly=false;
	}
return true;
}

function displaySList(val){
	if(val!="")
	{
	if(val=="Lease")
	{
		document.getElementById('leaseDiv').style.display = 'inline';
				
	
	}
	if(document.getElementById('radio1').checked==true)
	{
		document.getElementById('leaseDiv').style.display = 'inline';
				
	
	}
	if(document.getElementById('radio2').checked==true )
	{
		document.getElementById('leaseDiv').style.display = 'none';
		document.getElementById('leasePeriod').value = '';
		document.getElementById('completionDate').value = '';
	}
	if(val=="FreeHold")
	{
		document.getElementById('leaseDiv').style.display = 'none';
		document.getElementById('leasePeriod').value = '';
		document.getElementById('completionDate').value = '';
	}
	}
	else
	{
		document.getElementById('leaseDiv').style.display = 'none';
		document.getElementById('leasePeriod').value = '';
		document.getElementById('completionDate').value = '';
	}
} 



</script>


<script>
function forword(val){
	if(val!=null){
		if(val==""){
		
			document.getElementById('Remark').style.display="none";
		}
		if(val=="A"){
	
			document.getElementById('Remark').style.display="";
			var aa=document.getElementById('Remark').innerHTML;
			var str=aa.replace('<span>* </span>','');
			document.getElementById('Remark').innerHTML=str;
		}
		if(val=="R"){
		
			document.getElementById('Remark').style.display="";
			var aa=document.getElementById('Remark').innerHTML;
		
			if(aa.indexOf('<span>* </span>')!=9){
				document.getElementById('Remark').innerHTML=aa.replace('<label>','<label><span>* </span>');
			}
		}
	}
	
}

</script>

