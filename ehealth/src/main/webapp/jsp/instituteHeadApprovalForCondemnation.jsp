<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MmMasRequestStatus"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
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
List<String> kfcFormList = new ArrayList<String>();
List<MmServiceRequest> mmServiceRequestList = new ArrayList<MmServiceRequest>();
List<MmMasRequestStatus> mmMasRequestList = new ArrayList<MmMasRequestStatus>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<MasHospitalType> instituteTypeList = null;

if(request.getAttribute("map")!=null)
{
	map = (Map<String ,Object>) request.getAttribute("map");
}
if (map.get("kfcFormList")!= null){
	kfcFormList = (List)map.get("kfcFormList");
}
if (map.get("mmServiceRequestList")!= null){
	mmServiceRequestList = (List)map.get("mmServiceRequestList");
}
if (map.get("mmMasRequestList")!= null){
	mmMasRequestList = (List)map.get("mmMasRequestList");
}
if (map.get("instituteTypeList")!= null){
	instituteTypeList = (List)map.get("instituteTypeList");
}

if (map.get("employeeList")!= null){
	employeeList = (List)map.get("employeeList");
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
serverdate = '<%=date+"/"+month+"/"+year%>'
	
	function checkData(){
	var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
	 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
	 if(start<=end){
		 return true;
	 }else{alert("Date is Incorrect.");return false;}
}

</script>
<%
if(map.get("message")!=null){
	String message=(String)map.get("message");
	out.print(message);
}	
%>

<div class="titleBg">
<h2>Institute Head Approval</h2>
</div>
<div class="clear"></div>
<form name="instituteHeadApproval" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
	 <label><span>* </span>Form No</label> 
	<select name="kfcFormNo" id="kfcFormId" onchange="displayEquipmentDetail(this.value)" validate ="Form No,string,yes">
	<option value="">Select</option>
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
<%if(mmServiceRequestList.size()>0){ %>
<table>
	<tr><th>S.No.</th>
	<th>Request Date</th>
	<th>Request No</th>
	<th>Item Name</th>
	<th>Status</th>
	</tr>
	<%
	int k=1;
	
	for(MmServiceRequest mmServiceRequest :mmServiceRequestList){ %>
	
	<tr>
	<td><%=k %></td>
	<td><%=mmServiceRequest.getRequestDate()!= null?HMSUtil.convertDateToStringWithoutTime(mmServiceRequest.getRequestDate()):"" %>
	<input type="hidden" name="mmServiceRequestId<%=k %>" id="mmServiceRequestId" value="<%=mmServiceRequest.getId()!= null?mmServiceRequest.getId():""%>"></td>
	<td><%=mmServiceRequest.getServiceRequestNo()!= null?mmServiceRequest.getServiceRequestNo():"" %></td>
	<td><%=mmServiceRequest.getEquipment()!= null?mmServiceRequest.getEquipment().getItem().getNomenclature():"" %></td>
	<td><select name="headApprovalStatus<%=k %>" id="headApprovalStatus<%=k %>"  validate="Status,int,yes">
		<option value="">Select</option>
		<%if(mmMasRequestList.size()>0){
			for(MmMasRequestStatus mmMasRequestStatus : mmMasRequestList){
			%>
			<option value="<%=mmMasRequestStatus.getId()%>"><%=mmMasRequestStatus.getStatusName() %></option>
		<%}} %>
	</select></td>
	</tr>	  
	    
<%k++;} %>
 </table>
 <div class="clear"></div> 
 <input	type="hidden" name="count" id="count"	value="<%=k %>"  />
 </br>
 <div class="clear"></div> 
 
 <label style="width: 219px;"><span>*</span>Condemnation Comitee Name</label>
 <input	type="text" name="commiteeName" id="commiteeName" validate="Condemnation Comitee Name,string,yes"  />

 <div class="clear"></div> 

<label style="width: 219px;"><span>*</span>Institute Type Name</label>
 <select  name="hospitalTypeId"  id="hospitalTypeId" onchange="displayInstitutes(this.value)"  validate="Institute Type Name,string,yes" >
 <%if(instituteTypeList.size()>0){
	 for(MasHospitalType masHospitalType : instituteTypeList){
	 %>
	 <option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
<%} }%>
 </select>
 
 
 <label style="width: 219px;"><span>*</span>Institute Name</label>
 <select  name="hospitalId"  id="hospitalId" onchange="displayinstituteEmployees(this.value)"  validate="Institute Name,string,yes" >
 </select>

<div class="clear"></div> 
<label style="width: 219px;"><span>*</span>Institute Employees</label>
 <select  name="hospitalEmployees"  id="hospitalEmployees" multiple="multiple"  validate="Hospital Employees,string,no" class="multiple1" size="5">
 </select>
 

<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" style="margin-top: 6px !important;" value="" onclick="copySelectedOptions();" />
</div>
 
 <label style="width: 219px;"><span>*</span>Condemnation Comitee Members</label>
 <select  name="condemnationComiteeId"  id="condemnationComiteeId" multiple="multiple"  validate="Condemnation Comitee,string,no" class="multiple1" size="5">
 
 </select>
 
 <div class="clear"></div> 
 </br>
 
 <input	type="button" name="Submit" type="submit" value="Submit" class="button" onclick="submitForm('instituteHeadApproval','maintenance?method=submitInstituteHeadApproval');" />
 
 
<%}else{ %>
No Records Available.
<%} %>
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
	
<div class="clear"></div>
	<script>
		function displayEquipmentDetail(val){
		if(val != 0){
			submitForm('instituteHeadApproval','maintenance?method=displayEquipmentDetail&kfcFormNo='+val);
			
		}	
			
		}
		
		
		
		function displayInstitutes(val){
			if(val != 0){
				submitProtoAjaxWithDivName('instituteHeadApproval','maintenance?method=displayInstitutes&hospitalTypeId='+val,'hospitalId');
				
			}	
				
		}
		
		
		function displayinstituteEmployees(val){
			if(val != 0){
				submitProtoAjaxWithDivName('instituteHeadApproval','maintenance?method=displayInstitueEmployee&hospitalId='+val,'hospitalEmployees');
				
			}	
				
		}
		
		
		function copySelectedOptions() {
			   from =document.getElementById("hospitalEmployees");
			   to =document.getElementById("condemnationComiteeId");
				var options = new Object();
				if (hasOptions(to)) {
					for (var i=0; i<to.options.length; i++) {
						options[to.options[i].value] = to.options[i].text;
						}
					}
				if (!hasOptions(from)) { return; }
				for (var i=0; i<from.options.length; i++) {
					var o = from.options[i];
					if (o.selected) {
						if (options[o.value] == null || options[o.value] == "undefined" || options[o.value]!=o.text) {
							if (!hasOptions(to)) { var index = 0; } else { var index=to.options.length; }
							to.options[index] = new Option( o.text, o.value, true, false);
							}
						}
					}
				/* if ((arguments.length<3) || (arguments[2]==true)) {
					sortSelect(to);
					} */
				from.selectedIndex = -1;
				to.selectedIndex = -1;
				var objTemp = document.getElementById("tempId");
				for (var k=0; k<objTemp.options.length; k++) {
					objTemp.options[k].selected=true;
				}
		}
		
	

		function hasOptions(obj) {
			if (obj!=null && obj.options!=null) { return true; }
			return false;
		}
	
	
	</script>
	</form>