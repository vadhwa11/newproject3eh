<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.EtrTrvdetails"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hrms.masters.business.MstrCode"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@page import="jkt.hrms.masters.business.EtrTicketdetails"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<EtrTravelreq> etrTravelRequestList  = new ArrayList<EtrTravelreq>();
				List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrExpdetails> expenseDetailList = new ArrayList<EtrExpdetails>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("mstrCodeForExpesnseTypeList")!= null){
					mstrCodeForExpesnseTypeList = (List)map.get("mstrCodeForExpesnseTypeList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("expenseDetailList")!= null){
					expenseDetailList = (List)map.get("expenseDetailList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int travelRequestId = 0;
				String refNo = "";
				Date fromDate = new Date();
				Date toDate = new Date();
				String empName = "";
				int employeeId = 0;
				String rankName = "";
				String deptName = "";
				String organization = "";
				String locationName = "";
				String travelType = "";
				int travelTypeId= 0;
				String hotelDesc = "";
				String cabDesc = "";
				int etrTicketDetailId = 0;
				int fillBookDetailId = 0;
				long noOfDays = 0l;
				String tripName = "";
				 BigDecimal advanceTaken = new BigDecimal(0);
				//Set<EtrTrvdetails> etrTrvdetailsSet = new HashSet();
				if(etrTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq:etrTravelRequestList){
						travelRequestId = etrTravelreq.getId();
						 refNo =(String)etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 empName = etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName();
						 employeeId = etrTravelreq.getEmp().getId();
						 rankName = etrTravelreq.getEmp().getRank().getRankName();
						 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
						 locationName =etrTravelreq.getEmp().getLocation().getLocationName();
						 organization = etrTravelreq.getEmp().getHospital().getHospitalName();
						 if(etrTravelreq.getTrip().getId()!= null){
							 travelTypeId = etrTravelreq.getTrip().getId();
							travelType = etrTravelreq.getTrip().getCodeDesc();
						}
						
						 
						 tripName = etrTravelreq.getTrip().getCodeDesc();
						 long mills_per_day = 1000 * 60 * 60 * 24; 
						  noOfDays = (toDate.getTime() - fromDate.getTime()) / mills_per_day; 
						 
							if(etrTravelreq.getAdvAmt()!= null){
								advanceTaken = advanceTaken.add(etrTravelreq.getAdvAmt());
							}
						 
					}
				}
				
			%>


<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.MstrStandardAllowance"%>
<%@page import="jkt.hrms.masters.business.EtrExpdetails"%>
<script type="text/javascript">
	
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
	
</script>
<script type="text/javascript">
 alert("refNo -- "+refNo);
	function checkFromDate(){
		var fDate = document.getElementById('fromDateId').value;
		var tDate =document.getElementById('toDateId').value;
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		
		var count = document.getElementById('hiddenValueTicket').value;
		for(var i=1;i<count;i++){
		if(document.getElementById('tDateGrid'+i)){
			//alert(document.getElementById('tDateGrid'+i).value)
			var fGridStr = document.getElementById('fDateGrid'+i).value;
			var tGridStr = document.getElementById('tDateGrid'+i).value;
			//alert(tGridStr);
			var	fromDateGrid =new Date(fGridStr.substring(6),(fGridStr.substring(3,5) - 1) ,fGridStr.substring(0,2))
			var toDateGrid =new Date(tGridStr.substring(6),(tGridStr.substring(3,5) - 1) ,tGridStr.substring(0,2))
			
			if(fGridStr != "" && tGridStr != ""){
				if(fromDateGrid > toDateGrid){
					alert("To Date should be greater than From Date.");
					return false;
				}
			
			}
			
			if(fGridStr != ""){
				if(fromDateGrid < fromDate || fromDateGrid > toDate){
					alert("From Date should be in between Journey From Date and Journey To date.");
					return false;
				}
			}
			if(tGridStr != ""){
				if(toDateGrid < fromDate || toDateGrid > toDate){
					alert("To Date should be in between Journey From Date and Journey To date.");
					return false;
				}
			}
			}
		}
		return true;
	}
	
	
	function timeDifference()
	{
		var startTime = document.getElementById('startTimeId').value;
		var endTime = document.getElementById('endTimeId').value;
		var datet1emp = new Date(new Date().getFullYear()+"/"+new Date().getMonth()+"/"+new Date().getDay()+ " " + endTime);
		var date2temp = new Date(new Date().getFullYear()+"/"+new Date().getMonth()+"/"+new Date().getDay()+ " " + startTime);
		var timediff = datet1emp.getTime() - date2temp.getTime();
		hours = Math.floor(timediff / (1000 * 60 * 60)); 
		timediff -= hours * (1000 * 60 * 60);
		mins = Math.floor(timediff / (1000 * 60)); 
		timediff -= mins * (1000 * 60);
		var diff =  hours+"."+ mins;
		document.getElementById('totalTimeId').value = diff;
	}
	
	function checkTime(){
		var startTime = document.getElementById('startTimeId').value;
		var endTime = document.getElementById('endTimeId').value;
		if(startTime != "" && endTime != ""){
		if(startTime == endTime){
			alert(" Start Time should not  equal to End Time .");
			return false;
		}else if(endTime < startTime ){
			alert(" End Time should  greater than  Start Time .");
			return false;
		}
		}
		return true;
	} 
	
	
	</script>
<form name="updateSubmitExpenses" method="post" action="" >
<div class="titleBg"> <h2>Update Expenses</h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<label>Ref.No</label>
<input name="<%=REFERENCE_NO %>" id="<%=REFERENCE_NO %>"  value="<%=refNo %>"  validate="No. Of Days,string,yes"   maxlength="8" />
<input type="hidden"  name="refNo" id= "refNo" value="<%=refNo%>"/>

<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName %> "   validate="Start Time,string,yes"   maxlength="8" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>"/>

<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=rankName%>"   />
<div class="clear"></div>
<label>Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=deptName %>"    maxlength="8" />

<label>Location </label>
<input name="<%=LOCATION_ID %>"  value="<%=locationName %>"    maxlength="8" />

<label>Organization </label>
<input name="<%=HOSPITAL_ID %>"  value="<%=organization %>"    maxlength="8" />
<div class="clear"></div>

<label>Trip </label>
<input name="<%=TRIP_ID %>"  value="<%=tripName %>"    maxlength="8" />
<label>Journey From Date </label>
<input id="fromDateId" type="text"  name="<%=ACTUAL_J_FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />

<label>Journey To Date </label>
<input id="toDateId" type="text"  name="<%=ACTUAL_J_TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"   readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
 <div class="paddingTop15"></div>
<div class="clear"></div>
<label>Expese Head</label>
<select id="expenseHeadId" name="<%=EXPENSE_TYPE %>" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MstrCode mstrCode:mstrCodeForExpesnseTypeList){ 
%>
<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc() %></option>

<%} %>
</select>
<label>From Date </label>
<input id="fromDateId1" type="text" name="<%=FROM_DATE%>" value="" class="date" readonly="readonly" validate="From date ,date,no" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId1'),event);" />
<label> To Date </label> 
<input id="toDateId1" type="text" name="<%=TO_DATE%>" value="" class="date" readonly="readonly"  validate="To date ,date,no" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId1'),event)" />
 <div class="clear"></div>
 <label>From Country </label>
<select id="countryId" name="<%=COUNTRY_ID %>" validate="Country,string,no"  >
<option value="0">Select</option>
<%
	for(MasCountry masCountry :countryList){
%>
<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>

<%} %>
</select>


<label>To Country </label>
<select id="countryId1" name="<%=COUNTRY_ID1 %>" validate="Country ,string,no" >
<option value="0">Select</option>
<%
for(MasCountry masCountry :countryList){
%>
<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>
<%} %>
</select>



<label>From Place </label>
<select id="cityId" name="<%=CITY_ID %>" validate="City,string,no" >
<option value="0">Select</option>
<%
	for(MasDistrict masDistrict :masCityList){
%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>

<%} %>
</select>

<div class="clear"></div>
<label>To Place </label>
<select id="cityId1" name="<%=CITY_ID1 %>" validate="Country,string,no"  >
<option value="0">Select</option>
<%
for(MasDistrict masDistrict :masCityList){
%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
<%} %>
</select>
<label>Currency</label>
<select id="currencyId1" name="<%=CURRENCY_ID %>" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MasCurrency masCurrency :currencyList){ 
%>
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode() %></option>

<%} %>
</select>
<label>Amount </label>
<input id="expenseAmountId" name="<%=TICKET_AMT %>"   validate="Travel Advance Amount,float,no"   maxlength="8" />
<div class="clear"></div>
<label>Remark </label>
<input id="remarkId" name="<%=DESCRIPTION %>" value=""  validate="Remark,string,no"   maxlength="300" />
<input type="hidden" id="count" name="count" value="" />
</div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<table id="ticketDetails" class="medium">
<tr>
<th>Expense Head </th>
<th>From Date</th>
<th>To Date</th>
<th>From</th>
<th>To</th>
<th>Currency</th>
<th>Amount</th>
<th>Remark</th>

</tr>
<%
int i = 1;
int expSubmitId = 0;
String from = "";
int fromId = 0;
String to = "";
int toId = 0;
	if(expenseDetailList.size()>0){
	  for(EtrExpdetails etrExpdetails :expenseDetailList){
			expSubmitId =(Integer)etrExpdetails.getExp().getId();



%>

<tr onclick="displayEditValue(<%=i %>);" >
<%if(etrExpdetails.getExptype()!= null){ %>
<td><input type="text" name="expenseHeadGrid" id="expenseHeadGridId<%=i %>" value="<%=etrExpdetails.getExptype().getCodeDesc()%>" size="10"  align="center" class="readOnly" />
<input type="hidden" id="expenseHeadGridHiddenId<%=i %>" name="expenseHeadGridHidden<%=i %>" value="<%=etrExpdetails.getExptype().getId() %>" /></td>
<%}else{ %>
<td><input type="text" name="expenseHeadGrid" id="expenseHeadGridId<%=i %>" value="" size="10"  align="center" class="readOnly" />
<input type="hidden" id="expenseHeadGridHiddenId<%=i %>" name="expenseHeadGridHidden<%=i %>" value="" /></td>
<%} %>

<td><input type="text" size="10" name="fromDateGrid<%=i %>" id="fromDateGridId<%=i %>" value="<%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getFrmdate())%>" class="readOnly" /></td>
<td><input type="text" size="10" name="toDateGrid<%=i %>" id="toDateGridId<%=i %>" value="<%=HMSUtil.convertDateToStringWithoutTime(etrExpdetails.getTodate())%>" class="readOnly" /></td>
<%
if(travelTypeId==10 || travelTypeId==907){
	if (etrExpdetails.getFromPalce() != null) {
			from = etrExpdetails.getFromPalce().getDistrictName();
			fromId = etrExpdetails.getFromPalce().getId();
		}
	else{
		from = "";
		fromId = 0;
	}
	 
%>	
<td><input type="text" name="from" id="fromGridId<%=i %>" value="<%=from%>" size="10"  align="center" class="readOnly" />
<input type="hidden" id="fromHiddenId<%=i %>" name="fromHidden<%=i %>" value="<%=fromId %>" /></td>

<%}else if(travelTypeId==11) {
			if (etrExpdetails.getFromCountry() != null) {
					from = etrExpdetails.getFromCountry().getCountryName();
					fromId = etrExpdetails.getFromCountry().getId();
				}
			

%>
<td><input type="text" name="fromCountry" id="fromCountryGridId<%=i %>" value="<%=from%>" size="10"  align="center" class="readOnly" />
<input type="hidden" id="fromCountryHiddenId<%=i %>" name="fromCountryHidden<%=i %>" value="<%=fromId %>" /></td>
<%} %>

<%
if(travelTypeId==10 || travelTypeId==907 ){
if (etrExpdetails.getToPlace() != null) {
		to = etrExpdetails.getToPlace() .getDistrictName();
		toId = etrExpdetails.getToPlace() .getId();
	} else{
		to = "";
		toId = 0;
	}



%>
<td><input type="text" name="to" id="toGridId<%=i %>" value="<%=to%>" size="10"  align="center" class="readOnly" />
<input type="hidden" id="toHiddenId<%=i %>" name="toHidden<%=i %>" value="<%=toId%>" /></td>
<%
}else if(travelTypeId==11) {
if (etrExpdetails.getToCountry() != null) {
	if (etrExpdetails.getToCountry().getId() != null) {
		to = etrExpdetails.getToCountry().getCountryName();
		toId = etrExpdetails.getToCountry().getId();
	
		}
	}
%>
<td><input type="text" name="toCountry" id="toCountryGridId<%=i %>" value="<%=to%>" size="10"  align="center" class="readOnly" />
<input type="hidden" id="toCountryHiddenId<%=i %>" name="toCountryHidden<%=i %>" value="<%=toId%>" /></td>
<%} %>
<%if(etrExpdetails.getCurid() != null){ %>
<td><input type="text" name="currencyGrid" id="currencyGridId<%=i %>" value="<%=etrExpdetails.getCurid() .getCurrencyCode()%>" size="3"  align="center" class="readOnly" />
<input type="hidden" id="currencyHiddenId<%=i %>" name="currencyHidden<%=i %>" value="<%=etrExpdetails.getCurid() .getId() %>" /></td>
<%}else{ %>
<td><input type="text" name="currencyGrid" id="currencyGridId<%=i %>" value="" size="3"  align="center" class="readOnly" />
<input type="hidden" id="currencyHiddenId<%=i %>" name="currencyHidden<%=i %>" value="" /></td>
<%} %>

<%if(etrExpdetails.getAmount() != null){ %>
<td><input type="text" size="10" name="expenseAmountGrid<%=i %>" id="expenseAmountGridId<%=i %>" value="<%=etrExpdetails.getAmount() %>" size="5"  align="center" class="readOnly" /></td>
<%}else{ %>
<td>--</td>
<%} %>
<%if(etrExpdetails.getDescription() != null){ %>
<td><input type="text" size="10" name="remarkGrid<%=i %>" id="remarkGridId<%=i %>" value="<%=etrExpdetails.getDescription() %>" size="5"  align="center" class="readOnly" /></td>
<%}else{ %>
<td>--</td>
<%} %>
<input type="hidden" name="expDetailId<%=i %>"  value="<%=etrExpdetails.getId() %>" />
</tr>
<%i++; }} %>
</table>


<input type="hidden" id="expSubmitId" name="expSubmit" value="<%=expSubmitId %>" /> 
<div class="division"></div>
<div class="clear"></div>
<input name="update" type="button" class="button" value="Update" onClick="updateRow();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Update" type="button" class="button" value="Submit" onClick="submitForm('updateSubmitExpenses','etravel?method=updateExpenseDetails');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"><%=userName%></label>

<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>

 
</div>
		
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
			
<script type="text/javascript">
	//---------------display value grid to textboxes-------------------------
	function displayEditValue(i){
	
		document.getElementById('expenseHeadId').value = document.getElementById('expenseHeadGridHiddenId'+i).value;
		document.getElementById('fromDateId1').value = document.getElementById('fromDateGridId'+i).value;
		document.getElementById('toDateId1').value = document.getElementById('toDateGridId'+i).value;
		
		if(document.getElementById('fromHiddenId'+i))
	 		document.getElementById('cityId').value = document.getElementById('fromHiddenId'+i).value;
	 	
	 	if(document.getElementById('toHiddenId'+i))
	    	document.getElementById('cityId1').value = document.getElementById('toHiddenId'+i).value;
	    
	      if(document.getElementById('fromCountryHiddenId'+i))
	    	document.getElementById('countryId').value = document.getElementById('fromCountryHiddenId'+i).value;
	    
	    if(document.getElementById('toCountryHiddenId'+i))
	    	document.getElementById('countryId1').value = document.getElementById('toCountryHiddenId'+i).value;
	    
		document.getElementById('currencyId1').value = document.getElementById('currencyHiddenId'+i).value;
		document.getElementById('expenseAmountId').value = document.getElementById('expenseAmountGridId'+i).value;
		document.getElementById('remarkId').value = document.getElementById('remarkGridId'+i).value;
		 document.getElementById('count').value = i;
		
	}
	
	
		 //---------------display value textboxes to grid-------------------------
  function updateRow(){
  	
  		var i = document.getElementById('count').value;
  		
  		 var w = document.getElementById('expenseHeadId').selectedIndex;
		 var selectedText = document.getElementById('expenseHeadId').options[w].text;
		   if(document.getElementById('expenseHeadId').value != "0")
		     document.getElementById('expenseHeadGridId'+i).value = selectedText;
		     document.getElementById('expenseHeadGridHiddenId'+i).value = document.getElementById('expenseHeadId').value;
		     
   	    document.getElementById('fromDateGridId'+i).value = document.getElementById('fromDateId1').value;
		     
   	    document.getElementById('toDateGridId'+i).value = document.getElementById('toDateId1').value;
		     	
  		if(document.getElementById('fromGridId'+i)){
	     var w = document.getElementById('cityId').selectedIndex;
		 var selectedText = document.getElementById('cityId').options[w].text;
		   if(document.getElementById('cityId').value != "0")
		    document.getElementById('fromGridId'+i).value = selectedText;
		    document.getElementById('fromHiddenId'+i).value = document.getElementById('cityId').value;	
	    
	     var w1 = document.getElementById('cityId1').selectedIndex;
		 var selectedText = document.getElementById('cityId1').options[w1].text;
		  if(document.getElementById('cityId1').value != "0")
	    	document.getElementById('toGridId'+i).value =selectedText;
	     	document.getElementById('toHiddenId'+i).value = document.getElementById('cityId1').value;
	   }
	   
	   if(document.getElementById('fromCountryHiddenId'+i)){  	
	     	var w11 = document.getElementById('countryId').selectedIndex;
			 var selectedText = document.getElementById('countryId').options[w11].text;
			  if(document.getElementById('countryId').value != "0")
		    document.getElementById('fromCountryGridId'+i).value = selectedText;
		    document.getElementById('fromCountryHiddenId'+i).value = document.getElementById('countryId').value;
		    
	    
	    var w12 = document.getElementById('countryId1').selectedIndex;
		 var selectedText = document.getElementById('countryId1').options[w12].text;
		  if(document.getElementById('countryId1').value != "0")
	    	document.getElementById('toCountryGridId'+i).value =selectedText;
	     	document.getElementById('toCountryHiddenId'+i).value = document.getElementById('countryId1').value;	
	     
	     }
	     	
	     var w5 = document.getElementById('currencyId1').selectedIndex;
		 var selectedText = document.getElementById('currencyId1').options[w5].text;
		 if(document.getElementById('currencyId1').value != "0")
	     document.getElementById('currencyGridId'+i).value = selectedText;
	     document.getElementById('currencyHiddenId'+i).value = document.getElementById('currencyId1').value;	
	   
		 document.getElementById('expenseAmountGridId'+i).value = document.getElementById('expenseAmountId').value;
 		 document.getElementById('remarkGridId'+i).value = document.getElementById('remarkId').value;
		 document.getElementById('expenseHeadId').value = "0";
	     document.getElementById('fromDateId1').value = "";
		 document.getElementById('toDateId1').value = "";
		 document.getElementById('cityId').value = "0";
		 document.getElementById('cityId1').value = "0";
         document.getElementById('currencyId1').value = "0";
         document.getElementById('expenseAmountId').value = "";
         document.getElementById('remarkId').value = "";
  }
  	
  
	
	</script>
	
	


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

