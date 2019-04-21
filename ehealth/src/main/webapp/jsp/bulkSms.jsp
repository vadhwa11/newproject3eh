<%@page import="jkt.hms.masters.business.BulkMain"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBulkMain"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Calendar"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<form method="post" name="login">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<script type="text/javascript">

function popwindow(id)
{

 newwindow=window.open('showUpdateBulkDetails?id='+id,'name',"height=700,width=800,status=1");
 if (window.focus)
 {
 newwindow.focus()
 }
newwindow.createPopup();

}

function getDetail(){
  var val =document.getElementById('repeatCombo').value
	if(val=="0"){
	 return false
	 }else if(val=="1"){
		 document.getElementById('yearDiv').style.display = 'inline';
		 document.getElementById('monthDiv').style.display = 'none';
		 document.getElementById('weekDiv').style.display = 'none';
	}else if(val=="2"){
		 document.getElementById('yearDiv').style.display = 'none';
		 document.getElementById('monthDiv').style.display = 'inline';
		 document.getElementById('weekDiv').style.display = 'none';
	}else if(val=="3"){
		 document.getElementById('yearDiv').style.display = 'none';
		 document.getElementById('monthDiv').style.display = 'none';
		 document.getElementById('weekDiv').style.display = 'inline';
	}
}
function enableDiv(){
if(document.getElementById('repeat').checked)
document.getElementById('repeatDiv').style.display = 'inline';
else
document.getElementById('repeatDiv').style.display = 'none';
}
 <%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>

	    serverdate = '<%=curDate+"/"+month+"/"+year%>'
function checkTime(formName,timeFieldName){

	objTime = eval('document.'+formName+'.'+timeFieldName);
  	var chtime=objTime.value;
	if(chtime==""){
	alert('Time can not be blank')
		return false
	}

	try{
		 var indx = chtime.indexOf(':');

		 if (indx != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }

		 if (pairs2.length!=2) {
			 alert("Invalid Time Format.It should be HH:MM")
			 objTime.value=""
			return false;
			}

		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  objTime.value=""
				  return false;
				}

		 		 val2=eval(pairs2[0]);

						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
							  objTime.value=""
					 		 return false;}

					 		 val3=eval(pairs2[1]);

							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
							  objTime.value=""
					 		 return false;}


	}catch(e2)
	{	alert("Invalid Time")
	objTime.value=""
		return false;
	}

return true;
}

function checkForSend()
{
		if(confirm("Are You sure, You want To Send Message")){
		document.getElementById("send").disabled=true;
			return true;
			}
		else{
			return false;
			}
}

function fillValue(value){
document.getElementById("count").value=value
}
function checkValidcharOnly(charvalue,fieldname)
{
	var invalid = "~/<>`|^!'"
	//var charvalue = allTrim(charvalue) ;
	//var charvalue = allTrim(charvalue) ;
	for(i=0;i<invalid.length;i++)
	{
		for(j=0;j<invalid.length;j++)
		{
			if(charvalue.charAt(j) == invalid.charAt(i))
			{

				alert("Only valid characters are allowed in "+fieldname);
				alert("Please Remove "+ string );
				return(false);
			}
		}
	}
	for(i=0;i<charvalue.length;i++)
	{
		if(charvalue.charAt(i) == 66 || charvalue.charAt(i) == 39)
		{
			alert("Only valid characters are allowed in " +fieldname) ;
			return(false);
		}
	}
	return(true);
}

	function filterSpecialChar(str) {
	//re = /\$|,|@|#|~|`|\%|\*|\^|\&|\(|\)|\+|\=|\[|\-|\_|\]|\[|\}|\{|\;|\:|\'|\"|\<|\>|\?|\||\\|\!|\$|\./g;
	re = /\$|@|#|~|`|\%|\*|\^|\&|\(|\)|\'|\!|\$/g;
	// remove special characters like "$" and "," etc...
	return str.replace(re, "");
	}
	function submitForm(action){
	var objTemp = document.getElementById("tempId");
	for (var k=0; k<objTemp.options.length; k++) {
		objTemp.options[k].selected=true
		}
        errorMsg="";

			    if(action=="sendBulk"){
			     if(document.getElementById("tempId").value==""){
                    errorMsg="Please select Group Name \n";
                  }
                if(document.getElementById("message").value==""){
                    errorMsg=errorMsg+"Please fill message \n";
                  } else{
						/*
                     	var msg=document.getElementById("message").value;
                     	var msg=document.getElementById("message").value;
                    	if(checkValidcharOnly(msg,'Message')){
                    		document.getElementById("message").value=msg;
                    	}
                    	*/
                     	var msg=filterSpecialChar(document.getElementById("message").value);
                      	document.getElementById("message").value=msg;

                       }
                  if(document.getElementById("hours").value==""){
                    errorMsg=errorMsg+"Please select Hours \n";
                  }
                  if(document.getElementById("minutes").value==""){
                    errorMsg=errorMsg+"Please select Minutes \n";
                  }
				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}{
          	 if(confirm("Are You sure, You want To Send Message")){
				document.getElementById("send").disabled=true;
				}
				else{
					return false;
				}
		       	obj = eval('document.bulkSms');
		       	alert("action==>>"+action);
		        obj.action = "sms?method="+action;
		        obj.submit();
		       	}
		       	}else  if(action=="editBulk"){
		       	if(document.getElementById("count").value=="0"){
                    errorMsg="Please select Radio button \n";
                  }

				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}{
		       	obj = eval('document.bulkSms');
		        obj.action = action;
		        obj.submit();
		       	}}else  if(action=="stopAll"){
		       		if(confirm("Are You sure, You want To Stop  message for All Groups")){
		       				}
		       			else{return false;			}
		       		obj = eval('document.bulkSms');
			        obj.action = "sms?updateBulkDetails&type=stopAll";
			        obj.submit();
			       	}
	}
function checkUnsend(){
		return true
}
</script>
<form name="temp" method="get">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
String loginName="";
String message="";
if(session.getAttribute("loginName") !=null)
	loginName=""+session.getAttribute("loginName");
Map map = new HashMap();
map = HMSUtil.getCurrentDateAndTime();
String currentDate = (String) map.get("currentDate");
String currentTime = (String) map.get("currentTime");

Map<String,Object>map1=new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map1 = (Map) request.getAttribute("map");
}
List<MasBulkMain> mainList = new ArrayList<MasBulkMain>();
List<BulkMain> bulkMainList = new ArrayList<BulkMain>();

if(map1.get("mainList") != null){
	mainList = (ArrayList)map1.get("mainList");
}
if(map1.get("bulkMainList") != null){
	bulkMainList = (ArrayList)map1.get("bulkMainList");
}
if(map1.get("message")!=null){
	message=(String)map1.get("message");
}
  String bms="";
if(session.getAttribute("bms") !=null)
	bms=""+session.getAttribute("bms");
if(bms.equalsIgnoreCase(""))
{%>
	<script type="">
	obj = eval('document.temp');
    obj.action = "login";
    obj.submit();
</script>
<%} %>

</form>
<%

ResultSet bulkMainResultSet = null;
if(request.getAttribute("bulkMainResultSet") !=null){
	bulkMainResultSet=(ResultSet)request.getAttribute("bulkMainResultSet");
}
int unSendCount=0;
if(request.getAttribute("unSendCount") !=null){
	unSendCount=Integer.parseInt(""+request.getAttribute("unSendCount"));
}
ResultSet masterMainResultSet = null;
if(request.getAttribute("masterMainResultSet") !=null){
	masterMainResultSet=(ResultSet)request.getAttribute("masterMainResultSet");
}%>
<div id="formLayoutIn">
<h4>Bulk Messaging Service  </h4>
<%if(message!=null && !message.equals("")){ %>
<h3><%=message %></h3>
<%} %>
<form name="bulkSms"  method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(bulkMainList.size() >0){ %>
	<b><h2 style="color: #F38787; text-align: left; left: 15px; height:35px;">No of Unsent Messages  :<%=bulkMainList.size() %></h2></b>
<%}else{ %>
	<b><h2 style="color: #F38787; text-align: left; left: 15px; height:35px;">All bulk messages are send.</h2></b>
<%} %>
<div class="clear"></div>
<label >Group Name :</label>
<label >Added :</label>
<div class="clear"></div>
<select name="mainGroupId" id="mainGroupId"  multiple="multiple" size="3" class="list">
		<%
		if(mainList.size()>0)
		for(MasBulkMain main:mainList){
			%>
	     <option value="<%=main.getId()%>"><%=main.getGroupName()%></option>
	    <%}%>

</select>
<input type="button" name="Add" class="buttonAdd" value="" onclick="copySelectedOptions();" />

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="list">
</select>
<input type="button" name="send" class="buttonDel"  onclick="removeSelectedOptions();"/>
<input name="mainGroupName" value="Demo" id="mainGroupName" type="hidden">
<input type="hidden" value="n" name="priority">
	<%--
	<label >Priority :</label>
    <select name="priority" >
		<option value="1">First</option>
		<option value="3">Second</option>
		<option value="4">Third</option>
	</select>
	 --%>

	<div class="clear"></div>
	<label >Schedule Date :</label>
	<input type="text"  name="date" value="<%=currentDate %>" class="date" readonly="readonly"  maxlength="5" validate="date,date,no"/>
   <%if(loginName.equalsIgnoreCase("admin")){ %>
  <img id="" src="/hms/jsp/images/cal.gif" width="16" height="16"
                    border="0"
                   onclick="setdate('<%=currentDate %>',document.bulkSms.date,event)"
                     validate="Pick a date" onblur=""
                       onchange="" tabindex="1" />
	<%}else{ %>
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" />
	<%} %>

	<label >Schedule Time :</label>
		<select id="hours" name="hours"  class="smallList" validate="hours,string,no">
		    <option value="">Select Hours</option>
			<%for(int i=0;i<24;i++){ %>
			<option value="<%=i%>"><%=i%></option>
			<%} %>
		</select>
	<select  id="minutes" name="minutes" class="smallList">
	    <option value="">Select Minutes</option>
		<%for(int j=0;j<60;j++){ %>
		<option value="<%=j%>"><%=j%></option>
		<%} %>
	</select>
	<div class="clear"></div>
	<label >Message :</label>
<%--	<label class="auto">Repeat :</label>
<input type="checkbox" name="repeat" id="repeat" class="radioCheck" value="y" onclick="enableDiv();"/>
--%>
	<div class="clear"></div>
		<textarea name="message" id="message" cols="20" rows="2" tabindex="1" validate="message,string,no" onKeyDown="limitText(this,159);" class="large" onKeyUp="limitText(this,159);" onpaste="limitText(this,159);" ></textarea>
<label class="comment" >Left :</label>
<input type="text" name="left" id="left" readonly="readonly" value="159" class="smallLeftText"/>


	<div class="clear"></div>
	<div id="repeatDiv" style="display: block;">
	<label >Frequency :</label>

<label >Repeat Time :</label>
	<div class="clear"></div>
	<select name="repeatFrequency" id="repeatCombo" onchange="getDetail();">
	    <option value="0">Select</option>
		<option value="1">Yearly</option>
		<option value="2">Monthly</option>
		<option value="3">Weekly</option>
	</select>

		<input type="text" name="repeatTime" onblur="checkTime('bulkSms','repeatTime');" maxlength="5"/>

	<div id="yearDiv" style="display: block;">
	<div class="clear"></div>
		<label >Repeat Date :</label>
		<div class="clear"></div>
		<input type="text"  name="repeatDate" value="" class="date" readonly="readonly"   />
	    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"   onclick="setdate('',document.bulkSms.repeatDate,event)"/>
	<div class="clear"></div>
	</div>
		<div class="clear"></div>
	<div id="monthDiv" style="display: none;">
		<label >Day :</label>
		<div class="clear"></div>
			<select name="monthDay">
	    <option value="0">Select</option>
		<%for(int i=1;i<=31;i++){ %>
			<option value="<%=i%>"><%=i%></option>
			<%} %>
	</select>
	<div class="clear"></div>
	</div>
		<div id="weekDiv" style="display: none;">
		<label >Day :</label>
		<div class="clear"></div>
		<select name="weekDay">
		    <option value="0">Select</option>
			<option value="1">Monday</option>
			<option value="2">Tuesday</option>
			<option value="3">Wednesday</option>
			<option value="4">Thursday</option>
			<option value="5">Friday</option>
			<option value="6">Saturday</option>
			<option value="7">Sunday</option>
		</select>
		<div class="clear"></div>
	</div>


	<div class="clear"></div>
	</div>
<input type="button" name="send" class="button" value="Send" id="send" onclick="if(checkUnsend()){submitForm('sendBulk');}" />
	<div class="clear"></div>
	
	<input type="button" name="send" class="button" value="Stop All" id="send" onclick="submitForm('bulkSms','sms?method=updateBulkDetails');" />
<div class="clear"></div>
	<h4>Unsend messages </h4>

	<div class="clear"></div>

	<div class="lockHead">
<table border="0" cellpadding="0" cellspacing="0"><tbody><tr><td>
<div id="TableContainer" class="TableContainer">

 <table class="scrollTable">
  <thead class="fixedHeader headerFormat">

	<tr>
	<th>Group Name</th>
	<th>Date</th>
	<th>Time</th>
	<th>Message</th>
	</tr>

  </thead>
  <tbody class="scrollContent bodyFormat">

            <tr class="alternateRow">

	<%
		int count =1;
	System.out.println("bulkMainList.size()  ===== >>"+bulkMainList.size());
		if (bulkMainList != null && bulkMainList.size() > 0) {
			for (BulkMain bMain : bulkMainList) {
				String date4MySQL1 = "";
				try {
					//		date4MySQL1=HMSUtil.converDateToString(new Date(bulkMainResultSet.getString("activate_date"));
				} catch (Exception e) {
					//		date4MySQL1 =bulkMainResultSet.getString("activate_date") ;
				}
	%>

	<td><%=bMain.getName() %></td>
	<td>
	<input type="text"  name="date<%=count %>" value="<%=bMain.getActiveDate()%>" class="date" readonly="readonly"   />
	</td>
	<td><input type="hidden" name="time<%=count %>" value="<%=bMain.getActivateTime() %>"  readonly="readonly"/><%=bMain.getActivateTime() %></td>
	<td><input type="hidden" name="time<%=count %>" value="<%=bMain.getMessage() %>"  readonly="readonly" class="date"/><%=bMain.getMessage() %></td>
	</tr>
	<%count++;}} %>
	</tbody>
</table>
</div></td></tr></tbody></table>
        </div>
	<div class="clear"></div>
	<input type="hidden" value="0" id="count" name="count" />
	<div class="clear"></div>

</form>
</div>
<div class="clear"></div>
<script>
function limitText(limitField, limitNum) {
	if(limitNum-limitField.value.length !='-1')
	document.getElementById("left").value=limitNum-limitField.value.length
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
        
    } 
}
</script>
