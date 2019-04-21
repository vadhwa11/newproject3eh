
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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

<form name="assestDetails"  method="post" action=""  enctype="multipart/form-data">



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h2>Asset Details For Movable Fixed Asset </h2>

<div class="Block">

<label> Asset Category<span>*</span></label> 
 
<select name="assestCategoryId" id="assestCategoryId" validate="Asset Category,string,yes" tabindex="1" >

<option value="0">Select</option>
</select>



<label> Movable Type<span>*</span></label> 
<select name="movableType" validate="Manufacturer,string,no" tabindex="1" >
<option value="0">Select</option>

</select>


<label> Manufacturer</label>
<select name="manufacturerId" validate="Manufacturer,string,no" tabindex="1" >
<option value="0">Select</option>

</select>

<label>Email Id</label> 
<input type="text" name="<%=EMAIL_ID %>"    value="" validate="Email Id,email,no" MAXLENGTH="40" tabindex="30" />

<label>Land Line</label> 
<input type="text" name="<%=PHONE %>" value=""  validate="Phone,phone,no" MAXLENGTH="20" tabindex="28" id="phoneNo" />

<label>Mobile</label> 
<input type="text" name="<%=MOBILE %>"     id="mobileNo" value="" validate="Mobile Number,phone,no"
                       MAXLENGTH="20" tabindex="29"  />

<div class="Clear"></div>

<label> Service</label>
<select name="manufacturerId" validate="Manufacturer,string,no" tabindex="1" >
<option value="0">Select</option>
<option value="o">Outlets</option>
<option value="p">Personal</option>
</select>


<label>Vehicles<span>*</span></label> 
<input type="text" name="vehicles" id="vehicles" value="" validate="Vehicles,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 


<label>Value<span>*</span></label> 
<input type="text" name="values" id="values" value="" validate="Values,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 
	
	
<div class="clear"></div>	




<label> Warranty</label> 
<select name="warranty" validate="Warranty,string,no" tabindex="1" >
<option value="0">Select</option>
<option value="AMC">AMC</option>
<option value="KMSCL">KMSCL</option>
</select>

<label>Purchase Date </label>
<input type="text" name="purchaseDate"	value="" class="date" maxlength="30" tabindex=1 />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('',document.assestDetails.purchaseDate,event);" />


<label>Drawings <span>*</span></label> 
<input type="text" name="drawings" id="drawings" value="" validate="Drawings,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 




	
<div class="clear"></div>	


<label>Technical Literature <span>*</span></label> 
<input type="text" name="technicalLiterature" id="technicalLiterature" value="" validate="Technical Literature,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 





<label>Upload Document</label>
<input type="file" name="upload_filename" id="fileNameId" class="browse" tabindex="1"/>

<div class="clear"></div>

<label>Details </label> 
<textarea rows="" cols="" name="details" maxlength="100"  onkeyup="return ismaxlength(this)" tabindex="1"></textarea>

<label>Service Provider<span>*</span></label> 
<input type="text" name="" id="" value="" validate="Service Provider,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 

<label>Maintenance Protocols<span>*</span></label> 
<input type="text" name="maintenanceProtocols" id="maintenanceProtocols" value="" validate="Maintenance Protocols,string,no" class="textbox_size20" MAXLENGTH="10"  tabindex="1"> 

<div class="clear"></div>
<label> Purchased</label> 
<select name="warranty" validate="Warranty,string,no" tabindex="1" >
<option value="0">Select</option>
<option value="KMSCL">KMSCL</option>
<option value="Other">Other</option>
</select>

<div class="clear"></div>


</div>
	
<div class="clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="add" id="addbutton"	value="Submit" class="button" onClick=""	accesskey="a" tabindex="1" />
<input type="button" name="add" id="addbutton"	value="Back" class="button" onClick=""	accesskey="a" tabindex="1" />
<input type="button" name="add" id="addbutton"	value="Reset" class="button" onClick="" accesskey="g" tabindex="1" />		
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

