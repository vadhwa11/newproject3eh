<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<%@page import="java.util.*"%>
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

Map<String ,Object> map = new HashMap<String ,Object>();
String msg="";
List<Object[]> hesEquipmentMaster = new ArrayList<Object[]>();
List<MmServiceRequest> serviceRequest = new ArrayList<MmServiceRequest>();
List<String> kfcFormList = new ArrayList<String>();

if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("equipmentMaster")!= null){
	hesEquipmentMaster = (List<Object[]>)map.get("equipmentMaster");
}if (map.get("serviceRequest")!= null){
	serviceRequest = (List<MmServiceRequest>)map.get("serviceRequest");
}

if (map.get("kfcFormList")!= null){
	kfcFormList = (List)map.get("kfcFormList");
}

String kfcFormNo = "";
if(map.get("kfcFormNo") != null){
	kfcFormNo = (String)map.get("kfcFormNo");
}

String userName = "";
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
%>
<script>


function checkForValidSubmission(){
	var serviceCount = document.getElementById('serviceCount').value;
	var flag = false;
	for(var i=0;i<serviceCount;i++){
		if(document.getElementById('requestCheck'+i).checked){
			flag = true;
			break;
		}
	}
	if(!flag)
		alert("Select at least one item to approve !");
	
	return flag;
}

function checkForAllFeilds(){
	var serviceCount = document.getElementById('serviceCount').value;
	var flag = true;
	for(var i=0;i<serviceCount;i++){
		if(document.getElementById('requestCheck'+i).checked){
			if(document.getElementById("replacementValue"+i).value==''){
				flag = false;
				break;
			}
		}
	}
	if(!flag)
		alert("Please provide replacement value for the item !");
	
	return flag;
}



function isNumber(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode != 46 && charCode > 31
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

function displayEquipmentDetail(val){
	if(val != 0){
		submitForm('commiteeApproval','maintenance?method=displayEquipmentDetailForCommitee&kfcFormNo='+val);
	}	
 }

</script>
<%
if(map.get("message")!=null){
	String message=(String)map.get("message");
	out.print(message);
}	
%>

<div class="titleBg">
<h2>Condemnation List</h2>
</div>
<div class="clear"></div>
<form name="commiteeApproval" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	 <label><span>* </span>Form No</label> 
	<select name="kfcFormNo" id="kfcFormId" onchange="displayEquipmentDetail(this.value)">
	<option value="0">Select</option>
	<%if(kfcFormList.size()>0 && kfcFormList != null){
		for(int i=0; i<kfcFormList.size();i++){
		if(((String)kfcFormList.get(i)).equals(kfcFormNo)){
		%>
		<option value="<%=(String)kfcFormList.get(i)%>" selected="selected"><%=(String)kfcFormList.get(i) %></option>
		<%}else{ %>
		<option value="<%=(String)kfcFormList.get(i)%>" ><%=(String)kfcFormList.get(i) %></option>
	<%}}} %>
	</select>
</div>

<div class="Block">
<%if(serviceRequest.size()>0){ %>
	
<table>
	<tr><th> </th><th>S.No.</th><th>Request Date</th><th>Request No</th><th>Item Name</th><th>Replacement Value</th><th>Remarks</th></tr>
	
	<% 
		 int  counter=0;
		if (true) { %>
	<% 	for(MmServiceRequest serviceDetail:serviceRequest){
	%>
	<tr>
			<td><input type="checkbox" id="requestCheck<%=counter%>" name="requestCheck<%=counter%>">
			    <input type="hidden" name="serviceDetailId<%=counter%>" value="<%=serviceDetail.getId()%>" > </td>
			<td><%= counter+1%></td>
			<td><%=HMSUtil.changeDateToddMMyyyy(serviceDetail.getRequestDate())%></td>
			<td><%=serviceDetail.getServiceRequestNo()%></td>
			<td><%=serviceDetail.getEquipment().getItem().getNomenclature()%></td>
			<td><input type="text" name="replacementValue<%=counter%>" id="replacementValue<%=counter%>" onkeypress="return isNumber(event)" > </td>
			<td><textarea rows="2" cols="2" name="remarks<%=counter%>" id="remarks<%=counter%>"></textarea> </td>
	</tr>	    
<%		++counter;
				}

	    	}
	%>
 </table>
 
 <input type="hidden" name="serviceCount" value="<%=counter%>" id="serviceCount">
 </br>
 </br>
 <input type="button" value="Approve" onclick="if(checkForValidSubmission()){if(checkForAllFeilds()) {submitForm('commiteeApproval', 'maintenance?method=approveCondemnationFromCommitte')}}">
 
  <%}else{ %>
   No Records Available.
 <%} %>
 	  
	</form>  
 </div>
<div class="clear"></div> 
 <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	</div>