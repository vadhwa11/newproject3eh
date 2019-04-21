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

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<MstrCode> mstrCodeForTravelClassList = new ArrayList<MstrCode>();
				List<MstrCode> mstrCodeForTicketTypeList = new ArrayList<MstrCode>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("mstrCodeForTravelClassList")!= null){
					mstrCodeForTravelClassList = (List)map.get("mstrCodeForTravelClassList");
				}
				if(map.get("mstrCodeForTicketTypeList")!= null){
					mstrCodeForTicketTypeList = (List)map.get("mstrCodeForTicketTypeList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
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
				String locationName = "";
				String organizationName = "";
				String travelType = "";
				String hotelDesc ="";
				String cabDesc="";
				int travelTypeId= 0;
				Set<EtrTrvdetails> etrTrvdetailsSet = new HashSet();
				if(etrTravelRequestList.size()>0){
					for(EtrTravelreq etrTravelreq :etrTravelRequestList){
						travelRequestId = etrTravelreq.getId();
						 refNo =etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 empName = etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getMiddleName()+" "+etrTravelreq.getEmp().getLastName();
						 employeeId = etrTravelreq.getEmp().getId();
						 rankName = etrTravelreq.getEmp().getRank().getRankName();
						 deptName = etrTravelreq.getEmp().getDepartment().getDepartmentName();
						 locationName = etrTravelreq.getEmp().getLocation().getLocationName();
						 organizationName = etrTravelreq.getEmp().getHospital().getHospitalName();
						 etrTrvdetailsSet = etrTravelreq.getEtrTrvdetails();
						 hotelDesc       = etrTravelreq.getHotelDesc();
						 cabDesc         = etrTravelreq.getLocalCabDesc();
						 if(etrTravelreq.getTrip().getId()!= null){
								 travelTypeId = etrTravelreq.getTrip().getId();
								travelType = etrTravelreq.getTrip().getCodeDesc();
							}
						
					}
				}
			%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript">
function openPopupWindow()
{
	var id = document.getElementById('travelRequestId').value;
	var url="/hms/hrms/etravel?method=displayAttachment&travelRequestId="+id+"";
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}
</script>



<form name="filledBookedDetails" method="post" action="" >
<div class="titleBg"> <h2>Ticket Details Update</h2></div>
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
<input name="<%=REFERENCE_NO %>"  value="<%=refNo %>"  validate="No. Of Days,string,yes"   maxlength="8" />

<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName %> "   validate="Start Time,string,yes"   maxlength="8" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>">

<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=rankName%>"   />
<div class="clear"></div>
<label>Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=deptName %>"    maxlength="8" />

<label>Location </label>
<input name="<%=LOCATION_ID %>"  value="<%=locationName %>"    maxlength="8" />

<label>Organization </label>
<input name="<%=HOSPITAL_ID %>"  value="<%=organizationName %>"    maxlength="8" />
<div class="clear"></div>
<label>From Date </label>
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
 
<label> To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"  readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />

<label> Fill Date </label>
<input type="text"  name="<%=FILL_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>" class="date"  readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.filledBookedDetails.<%=FILL_DATE%>,event)"/>
 <div class="clear"></div>
<label> Hotel Remark </label>
<input name="Hotel_REMARK"  value="<%=hotelDesc %>"  readonly="readonly" class="large" />
 <div class="clear"></div>
<label> Cab Remark </label>
<input name="CAB_REMARK"  value="<%= cabDesc %>"  readonly="readonly" class="large"/>
 <div class="clear"></div>
</div>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>

<table class="medium">
<tr>
<th>From </th>
<th>To</th>
<th>Date</th>
<th>Mode</th>
<th>Time Slot</th>
<th>Remark</th>
</tr>
<%
	String from = "";
	int fromId = 0;
	String to = "";
	int toId = 0;
	String travelMode = "";
	
	if(etrTrvdetailsSet.size()>0){
		for(EtrTrvdetails etrTrvdetails :etrTrvdetailsSet){
			
			if(travelTypeId==10){
					if (etrTrvdetails.getFrmPlce() != null) {
						if (etrTrvdetails.getFrmPlce().getId() != null) {
							from = etrTrvdetails.getFrmPlce().getDistrictName();
							fromId = etrTrvdetails.getFrmPlce().getId();
						} else {
							from = "";
						}
					  }
					if (etrTrvdetails.getToPlce() != null) {
						if (etrTrvdetails.getToPlce().getId() != null) {
							to = etrTrvdetails.getToPlce().getDistrictName();
							toId = etrTrvdetails.getToPlce().getId();
						} else {
							to = "";
						}
					 }
				    
					}else if(travelTypeId==11) {
							if (etrTrvdetails.getFromCountry() != null) {
								if (etrTrvdetails.getFromCountry().getId() != null) {
									from = etrTrvdetails.getFromCountry().getCountryName();
									fromId = etrTrvdetails.getFromCountry().getId();
								} else {
									from = "";
								}
							}
						if (etrTrvdetails.getToCountry() != null) {
							if (etrTrvdetails.getToCountry().getId() != null) {
								to = etrTrvdetails.getToCountry().getCountryName();
								toId = etrTrvdetails.getToCountry().getId();
							} else {
								to = "";
							}
						}
			    }
				if(etrTrvdetails.getTrip()!= null){ 
					travelMode = etrTrvdetails.getTrip().getCodeDesc();
				}else{
					travelMode = "";
				}
%>

<tr>
<td><%=from %></td>
<td><%=to %></td>
<%if(etrTrvdetails.getBDate()!= null){ %>
<td><%=HMSUtil.convertDateToStringWithoutTime(etrTrvdetails.getBDate()) %></td>
<%}else{ %>
<td>-</td>
<%} %>
<%if(etrTrvdetails.getTrip().getCodeDesc()!= null){ %>
<td><%=etrTrvdetails.getTrip().getCodeDesc() %></td>
<%}else{ %>
<td>-</td>
<%} %>

<%if((etrTrvdetails.getBeforeTime()!= null )&&(etrTrvdetails.getTimeSlot()!= null)){ %>
<td><%=etrTrvdetails.getBeforeTime() %> -- <%=etrTrvdetails.getTimeSlot() %></td>
<%}else{ %>
<td>-</td>
<%} %>
<%if(etrTrvdetails.getRemarks()!= null){ %>
<td><%=etrTrvdetails.getRemarks() %></td>
<%}else{ %>
<td>-</td>
<%} %>
</tr>
<%
	}
 }%>
</table>

<script type="text/javascript">

var cityArray =new Array();
var cityArray1 =new Array();
var travelModeArray =new Array();
var currencyArray =new Array();
var countryArray =new Array();
var countryArray1 =new Array();
var travelClassArray1 =new Array();
var ticketTypeArray =new Array();

</script>

<%  int j=0;

for(MasDistrict masDistrict :masCityList){
%>
<script>
			cityArray[<%=j%>]= new Array();
			cityArray[<%=j%>][0] = "<%=masDistrict.getId()%>";
			cityArray[<%=j%>][1] = "<%=masDistrict.getDistrictName()%>";
			
		</script>
<%j++;} %>

<%  int r=0;

for(MasDistrict masDistrict :masCityList){
%>
<script>
			cityArray1[<%=r%>]= new Array();
			cityArray1[<%=r%>][0] = "<%=masDistrict.getId()%>";
			cityArray1[<%=r%>][1] = "<%=masDistrict.getDistrictName()%>";
			
		</script>
<%r++;} %>

<%  int k= 0;
	for(MstrCode mstrCode1 :mstrCodeForTravelModeList){
		
%>
<script>
			travelModeArray[<%=k%>]= new Array();
			travelModeArray[<%=k%>][0] = "<%=mstrCode1.getId()%>";
			travelModeArray[<%=k%>][1] = "<%=mstrCode1.getCodeDesc()%>";
		
		</script>
<%k++;} %>
<%  int x= 0;
	for(MasCurrency masCurrency :currencyList){
%>
<script>
			currencyArray[<%=x%>]= new Array();
			currencyArray[<%=x%>][0] = "<%=masCurrency.getId()%>";
			currencyArray[<%=x%>][1] = "<%=masCurrency.getCurrencyCode()%>";
		</script>
<%x++;} %>

</script>
<%  int y=0;
	for(MasCountry  masCountry: countryList){
%>
<script>
			countryArray[<%=y%>]= new Array();
			countryArray[<%=y%>][0] = "<%=masCountry.getId()%>";
			countryArray[<%=y%>][1] = "<%=masCountry.getCountryName()%>";
			
		</script>
<%y++;} %>

<%  int q=0;
	for(MasCountry  masCountry1: countryList){
%>
<script>
			countryArray1[<%=q%>]= new Array();
			countryArray1[<%=q%>][0] = "<%=masCountry1.getId()%>";
			countryArray1[<%=q%>][1] = "<%=masCountry1.getCountryName()%>";
			
		</script>
<%q++;} %>

<%  int z= 0;
	for(MstrCode mstrCode2 :mstrCodeForTravelClassList){
%>
<script>
			travelClassArray1[<%=z%>]= new Array();
			travelClassArray1[<%=z%>][0] = "<%=mstrCode2.getId()%>";
			travelClassArray1[<%=z%>][1] = "<%=mstrCode2.getCodeDesc()%>";
		</script>
<%z++;} %>

<%  int l= 0;
	for(MstrCode mstrCode3 :mstrCodeForTicketTypeList){
%>
<script>
			ticketTypeArray[<%=l%>]= new Array();
			ticketTypeArray[<%=l%>][0] = "<%=mstrCode3.getId()%>";
			ticketTypeArray[<%=l%>][1] = "<%=mstrCode3.getCodeDesc()%>";
		</script>
<%l++;} %>

<div class="clear"></div>
<div class="clear"></div>
<%
String beforeTime = "";
String timeSloat = "";
if(etrTrvdetailsSet.size()>0){
	for(EtrTrvdetails etrTrvdetails :etrTrvdetailsSet){
		if(etrTrvdetails.getBeforeTime()!= null){
			beforeTime = etrTrvdetails.getBeforeTime();
		}
		if(etrTrvdetails.getTimeSlot()!= null){
			timeSloat = etrTrvdetails.getTimeSlot();
		}
	}}
		%>
<div class="paddingTop15"></div>	

<label>Remarks </label>
<input type="text" id="remarksId" name="<%=REMARKS %>" class="large"  validate="Remarks,string,no"   maxlength="300" />

<div class="clear"></div>
<div class="division"></div>
<label>Booking Details</label>
<div class="clear"></div>
<table id="ticketDetails" class="medium">
<tr>
<th>Select</th>
<th>From </th>
<th>To</th>
<th>Mode</th>
<th>Class</th>
<th>Depar.</th>
<th>Arrival</th>
<th>Tic.No</th>
<th>Tic.Type</th>
<th>Amt</th>
<th>Currency</th>
</tr>
<%
int i = 1;
	if(etrTrvdetailsSet.size()>0){
		for(EtrTrvdetails etrTrvdetails :etrTrvdetailsSet){
	
%>
<tr>
<td><input name=""  class="radioCheck"  type="checkbox"  value=""   /></td>
<%
if(travelTypeId==10){
	if (etrTrvdetails.getFrmPlce() != null) {
			from = etrTrvdetails.getFrmPlce().getDistrictName();
			//fromId = etrTicketdetails.getFrmplc().getId();
		} else {
			from = "";
		}
	  
%> 
<td><select  name="<%=CITY_ID+i%>" id="cityId<%=i %>" validate="City,string,no" >
<option value="0">Select</option>
<%
for(MasDistrict masDistrict :masCityList){ 
	if(masDistrict.getDistrictName().equals(from)){

%>
<option value="<%=masDistrict.getId() %>" selected="selected"><%=masDistrict.getDistrictName() %></option>
<%}else{ %>

<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>

<%} }%>
</select></td>
<% 
	}else if(travelTypeId==11) {
			if (etrTrvdetails.getFromCountry() != null) {
					from = etrTrvdetails.getFromCountry().getCountryName();
					//fromId = etrTicketdetails.getFromCountry().getId();
				} else {
					from = "";
				}
			
            
%>
<td><select  name="<%=COUNTRY_ID+i%>" id="countryId<%=i %>" validate="City,string,no" >
<option value="0">Select</option>
<%
for(MasCountry masCountry :countryList){ 
if(masCountry.getCountryName().equals(from)){

%>
<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName() %></option>
<%}else{ %>

<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>

<%}} %>
</select></td>
<%} %>
<%
if(travelTypeId==10){
	if (etrTrvdetails.getToPlce() != null) {
		to = etrTrvdetails.getToPlce().getDistrictName();
		//toId = etrTicketdetails.getFrmto().getId();
	} else {
		to = "";
	}
%> 
<td><select  name="<%=CITY_ID1+i%>" id="tocityId<%=i %>" validate="City,string,no" >
<option value="0">Select</option>
<%
for(MasDistrict masDistrict :masCityList){ 
		if(masDistrict.getDistrictName().equals(to)){
%>
<option value="<%=masDistrict.getId() %>" selected="selected"><%=masDistrict.getDistrictName()%></option>
<%}else{ %>

<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>

<%}} %>
</select></td>
<% 
}else if(travelTypeId==11) {
	if (etrTrvdetails.getToCountry() != null) {
		to = etrTrvdetails.getToCountry().getCountryName();
		//toId = etrTicketdetails.getToCountry().getId();
	} else {
		to = "";
	}


%>
<td><select  name="<%=COUNTRY_ID1+i%>" id="tocountryId<%=i %>" validate="City,string,no" >
<option value="0">Select</option>
<%
for(MasCountry masCountry :countryList){ 
	if(masCountry.getCountryName().equals(to)){
%>
<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
<%}else{ %>

<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>

<%}} %>
</select></td>
<%} %>
<td><select  name="<%=TRAVEL_MODE_ID+i %>" id="travelModeId<%=i %>" class="small" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MstrCode mstrCodeForTravelType : mstrCodeForTravelModeList){ 
	if(mstrCodeForTravelType.getCodeDesc().equals(travelMode)){
%>
<option value="<%=mstrCodeForTravelType.getId() %>" selected="selected"><%=mstrCodeForTravelType.getCodeDesc() %></option>
<%}else{ %>
<option value="<%=mstrCodeForTravelType.getId() %>"><%=mstrCodeForTravelType.getCodeDesc() %></option>
<%}} %>
</select></td>
<td><select  name="<%=TRAVEL_CLASS_ID+i %>" id="classId<%=i %>" class="small" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MstrCode mstrCodeForTravelClass : mstrCodeForTravelClassList){ 
%>
<option value="<%=mstrCodeForTravelClass.getId() %>"><%=mstrCodeForTravelClass.getCodeDesc() %></option>

<%} %>
</select></td>
<td><input id="departureId<%=i %>"  name="<%=DEPARTURE_TIME+i%>" value="" size="8" validate="Remark,string,no" onKeyUp="mask(this.value,this,'2',':');"  maxlength="5" /></td>
<td><input id="arrivalId<%=i %>" name="<%=ARRIVAL_TIME+i%>" value="" size="8" validate="Remark,string,no" onKeyUp="mask(this.value,this,'2',':');"  maxlength="5" /></td>
<td><input id="ticketNoId<%=i %>" name="<%=TICKET_NO+i%>" value="" size="8" validate="Remark,string,no"   maxlength="50" /></td>
<td><select  name="<%=TICKET_TYPE_ID+i %>" id="ticketTypeId<%=i %>" class="small" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MstrCode mstrCodeForTicketType: mstrCodeForTicketTypeList){ 
%>
<option value="<%=mstrCodeForTicketType.getId() %>"><%=mstrCodeForTicketType.getCodeDesc() %></option>

<%} %>
</select></td>
<td><input id="ticketAmt<%=i %>" name="<%=TICKET_AMT+i%>" value="" size="8" validate="Remark,string,no"   maxlength="50" /></td>
<td><select id="currencyId<%=i %>" name="<%=CURRENCY_ID+i %>" class="small" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MasCurrency  masCurrency: currencyList){ 
%>
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode()%></option>

<%} %>
</select></td>
</tr>
<%i++;}} %>
</table>
<div class="clear"></div>
<input name="add" type="button" class="button" value="Add" onClick="addRowForTicketBooking();"/>
<input name="ViewRequest" type="button"  class="button" value="Delete" onClick="removeRowValue();" />
<input name="Send" type="button"  class="button" value="Attach Files" onClick="javascript:openPopupWindow();" />
<input name="Send" type="button"  class="button" value="Send" onClick="submitForm('filledBookedDetails','etravel?method=sendTicketDetail','validateRow');" />
<input type="hidden"  name="hiddenValueTicket" id="hiddenValueTicket" value="<%=i%>" />

<script type="text/javascript">

 function addRowForTicketBooking(){
	var tbl = document.getElementById('ticketDetails');
	var lastRow = tbl.rows.length;
	
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdbPay = document.getElementById('hiddenValueTicket');
	hdbPay.value=iteration
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedPayMode';
	e0.value=(iteration);
	e0.size = '3'
	cell0.appendChild(e0);
	
<%
		if(travelTypeId==10){
%>
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name = '<%=CITY_ID%>'+ iteration;
	e1.id = 'cityId' + iteration;
	e1.options[0] = new Option('Select', '0');
	for(var i = 0;i<cityArray.length;i++ ){
		e1.options[i+1] = new Option(cityArray[i][1],cityArray[i][0]);
	}
	
	cell1.appendChild(e1);
	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('select');
	e2.name='<%=CITY_ID1%>'+ iteration;
	e2.id = 'tocityId'+iteration
	e2.options[0] = new Option('Select', '0');
	for(var j = 0;j<cityArray1.length;j++ ){
		e2.options[j+1] = new Option(cityArray1[j][1],cityArray1[j][0]);
	}
	cell2.appendChild(e2);


<%
}else if(travelTypeId==11){
%>
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name = '<%=COUNTRY_ID%>'+ iteration;
	e1.id = 'countryId' + iteration;
	e1.options[0] = new Option('Select', '0');
	for(var h = 0;h<countryArray.length;h++ ){
		e1.options[h+1] = new Option(countryArray[h][1],countryArray[h][0]);
	}
	cell1.appendChild(e1);
	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('select');
	e2.name='<%=COUNTRY_ID1%>'+ iteration;
	e2.id = 'tocountryId'+iteration
	e2.options[0] = new Option('Select', '0');
	for(var e = 0;e<countryArray1.length;e++ ){
		e2.options[e+1] = new Option(countryArray1[e][1],countryArray1[e][0]);
	}
	cell2.appendChild(e2);
<%}%>
	
	
	
	var cell3 = row.insertCell(3);
	var e3 = document.createElement('select');
	e3.name='<%=TRAVEL_MODE_ID%>'+ iteration;
	e3.id='travelModeId'+iteration;
	e3.options[0] = new Option('Select', '0');

	for(var k = 0;k<travelModeArray.length;k++){
		e3.options[k+1] = new Option(travelModeArray[k][1],travelModeArray[k][0]);
	}
	e3.className='small'
	cell3.appendChild(e3); 
	
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name='<%=TRAVEL_CLASS_ID%>'+ iteration;
	e4.id='classId'+iteration;
	e4.options[0] = new Option('Select', '0');

	for(var m = 0;m<travelClassArray1.length;m++ ){
		
		e4.options[m+1] = new Option(travelClassArray1[m][1],travelClassArray1[m][0]);
		
	}
	e4.className='small'
	cell4.appendChild(e4); 
	
	
	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=DEPARTURE_TIME%>'+ iteration;
	e5.id='departureId'+iteration;
	e5.size = '8'
	e5.onkeyup= function(){
					mask(this.value,this,'2',':');
					};
	e5.maxLength = '5'
	cell5.appendChild(e5); 
	
	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'text';
	e6.name='<%=ARRIVAL_TIME%>'+ iteration;
	e6.id='arrivalId'+iteration;
	e6.size = '8'
	e6.maxLength = '5'
	e6.onkeyup= function(){
					mask(this.value,this,'2',':');
					};
	cell6.appendChild(e6); 
	
	
	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=TICKET_NO%>'+ iteration;
	e7.id='ticketNoId'+iteration;
	e7.size = '8'
	cell7.appendChild(e7); 
	
	var cell8 = row.insertCell(8);
	var e8 = document.createElement('select');
	e8.name='<%=TICKET_TYPE_ID%>'+ iteration;
	e8.id='ticketTypeId'+iteration;
	e8.options[0] = new Option('Select', '0');
	for(var n = 0;n<ticketTypeArray.length;n++ ){
	
		e8.options[n+1] = new Option(ticketTypeArray[n][1],ticketTypeArray[n][0]);
		
	}
	e8.className='small'
	cell8.appendChild(e8); 
	
	var cell9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.type = 'text';
	e9.name='<%=TICKET_AMT%>'+ iteration;
	e9.id='ticketAmt'+iteration;
	e9.size = '8'
	cell9.appendChild(e9); 
	
	var cell10 = row.insertCell(10);
	var e10 = document.createElement('select');
	e10.name='<%=CURRENCY_ID%>'+ iteration;
	e10.id='currencyId'+iteration;
	e10.options[0] = new Option('Select', '0');
	
	for(var p = 0;p<currencyArray.length;p++ ){
	
		e10.options[p+1] = new Option(currencyArray[p][1],currencyArray[p][0]);
		
	}
	 e10.className='small'
	cell10.appendChild(e10); 
	
}


	function removeRowValue()
	{
		
	 var tbl = document.getElementById('ticketDetails');
	  var tblRows  = tbl.getElementsByTagName("tr");
	 
	   if(tblRows.length-2==0){
	          alert("Can not delete all rows")
	          return false;
	     }
	for(counter1=0;counter1<document.getElementsByName('selectedPayMode').length;counter1++)
	 {
	  if (document.getElementsByName('selectedPayMode')[counter1].checked == true) 
	  {
	     tbl.deleteRow(counter1+1);
	    
	  }
	 }
	}	


function validateRow(){
		var msg = "";
		 var tbl = document.getElementById('ticketDetails');
  		var rowlength = tbl.rows.length;
  			if(rowlength==1){
	  	alert("Please fill atleast one row to submit.");
	  	return false;
	}else{
  		 var rowlength = tbl.rows.length;
		 for(var i=1;i<rowlength;i++){
		
  		<%if(travelTypeId == 10){%>
			 	if(document.getElementById('cityId'+i).value == 0 || document.getElementById('cityId'+i).value == ""){
			 		msg += "From can not be blank in row "+i+".\n";
			 	}
			 	if(document.getElementById('tocityId'+i).value == 0 || document.getElementById('tocityId'+i).value == ""){
			 		msg += "To can not be blank in row "+i+".\n";
			 	}
  			<%}else if(travelTypeId == 11){%>
			 	if(document.getElementById('countryId'+i).value == 0 || document.getElementById('countryId'+i).value == ""){
			 		msg += "From can not be blank in row "+i+".\n";
			 	}
			 	if(document.getElementById('tocountryId'+i).value == 0 || document.getElementById('tocountryId'+i).value == ""){
			 		msg += "To can not be blank in row "+i+".\n";
			 	}
  			
		<%}%>
			 	if(document.getElementById('travelModeId'+i).value == 0 || document.getElementById('travelModeId'+i).value == ""){
			 		msg += "Travel Mode can not be blank in row "+i+".\n";
			 	}
			 	if(document.getElementById('classId'+i).value == 0 || document.getElementById('classId'+i).value == ""){
			 		msg += "Travel Mode can not be blank in row "+i+".\n";
			 	}
			 	if(document.getElementById('departureId'+i).value == "" ){
			 		msg += "Departure Time can not be blank in row "+i+".\n";
			 	}
	  			if(document.getElementById('arrivalId'+i).value == "" ){
		 		msg += "Arrival Time can not be blank in row "+i+".\n";
		 		}
		 		if(document.getElementById('ticketNoId'+i).value == "" ){
		 		msg += "Ticket No can not be blank in row "+i+".\n";
		 		}
		 		if(document.getElementById('ticketTypeId'+i).value == 0 || document.getElementById('ticketTypeId'+i).value == ""){
			 		msg += "Travel Type can not be blank in row "+i+".\n";
			 	}
			 	if(document.getElementById('ticketAmt'+i).value == "" ){
		 		msg += "Ticket Amount can not be blank in row "+i+".\n";
		 		}
			 	if(document.getElementById('currencyId'+i).value == 0 || document.getElementById('currencyId'+i).value == ""){
			 		msg += "Currency can not be blank in row "+i+".\n";
			 	}
  	
  		
  	}
  	 if(msg != ""){
			 	alert(msg);
			 	return false;
			 }
  		}
	return true;
}

</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<label>Hotel Booking</label>

<input  id="hotelBookingId" type="text" name="<%=HOTEL_BOOKING_DESC %>" value="" class="large"  validate="HotelDesc,string,no"  class="large" MAXLENGTH="500" tabindex=1>
<div class="clear"></div>
<label>Local CAB Booking</label>
<input id="cabBookingId" type="textarea" name="<%=CAB_BOOKING_DESC %>" class="large"   value="" validate="Remarks,string,no"  class="large" MAXLENGTH="500" tabindex=1/>
<div class="clear"></div>
</div>
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
			



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

