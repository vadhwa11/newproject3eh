<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
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
				//List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<EtrTicketdetails> etrTicketDetailsList = new ArrayList<EtrTicketdetails>();
				List<MstrCode> mstrCodeForExpesnseTypeList = new ArrayList<MstrCode>();
				List<EtrTravelreq> etrTravelReqListForAdvanceList = new ArrayList<EtrTravelreq>();
				List<MstrStandardAllowance> standardAllowanceList = new ArrayList<MstrStandardAllowance>();
				List<EtrTravelreq> etrTravelRequestList  = new ArrayList<EtrTravelreq>();
				Users users = new Users();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("users")!= null){
					users = (Users)map.get("users");
				}
				if(map.get("etrTicketDetailsList")!= null){
					etrTicketDetailsList = (List)map.get("etrTicketDetailsList");
				}
				if(map.get("standardAllowanceList")!= null){
					standardAllowanceList = (List)map.get("standardAllowanceList");
				}
				if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("etrTravelReqListForAdvanceList")!= null){
					etrTravelReqListForAdvanceList = (List)map.get("etrTravelReqListForAdvanceList");
				}
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("mstrCodeForExpesnseTypeList")!= null){
					mstrCodeForExpesnseTypeList = (List)map.get("mstrCodeForExpesnseTypeList");
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
						  noOfDays = ((toDate.getTime() - fromDate.getTime()) / mills_per_day)+1; 
						 
							if(etrTravelreq.getAdvAmt()!= null){
								advanceTaken = advanceTaken.add(etrTravelreq.getAdvAmt());
							}
						 
					}
				}
				
			%>


<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.MstrStandardAllowance"%>
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
	function checkFromDate(){
		var fDate = document.getElementById('fromDateId').value;
		var tDate =document.getElementById('toDateId').value;
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var toDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
		
		var count = document.getElementById('hiddenValueTicket').value;
		
		for(var i=1;i<=count;i++){
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
<form name="submitExpenses" method="post" action="">
<div class="titleBg">
<h2>Submit Expenses</h2>
</div>
<div class="clear"></div>
<%
	if (message != null) {
%>
<h4><%=message%></h4>
<%
	}
%>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block"><label>Ref.No</label> <input
	name="<%=REFERENCE_NO %>" value="<%=refNo %>"
	validate="No. Of Days,string,yes" maxlength="8" /> <label>Employee</label>
<input name="<%=EMPLOYEE_ID %>" value="<%=empName %> "
	validate="Start Time,string,yes" maxlength="8" /> <input type="hidden"
	name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>"> <label>Designation
</label> <input name="<%=RANK_ID %>" value="<%=rankName%>" />
<div class="clear"></div>
<label>Department </label> <input name="<%=DEPARTMENT_ID %>"
	value="<%=deptName %>" maxlength="8" /> <label>Location </label> <input
	name="<%=LOCATION_ID %>" value="<%=locationName %>" maxlength="8" /> <label>Organization
</label> <input name="<%=HOSPITAL_ID %>" value="<%=organization %>"
	maxlength="8" />
<div class="clear"></div>

<label>Trip </label> <input name="<%=TRIP_ID %>" value="<%=tripName %>"
	maxlength="8" /> <label>Journey From Date </label> <input
	id="fromDateId" type="text" name="<%=ACTUAL_J_FROM_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"
	readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" /> <label>Journey
To Date </label> <input id="toDateId" type="text" name="<%=ACTUAL_J_TO_DATE %>"
	value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"
	readonly="readonly" onblur="calculateNoOfDays();"
	validate="To date ,date,yes" MAXLENGTH="30" />
<div class="clear"></div>
<label>No.Of Days </label> <input id="noOFDaysId"
	name="<%=NO_OF_DAYS %>" class="small" disabled="disabled"
	validate="No. Of Days,string,yes" maxlength="8" /> <script
	type="text/javascript">
          		  document.getElementById('noOFDaysId').value='<%=noOfDays%>';
            </script></div>
<script type="text/javascript">
var expenseArray =new Array();
var cityArray =new Array();
var cityArray1 =new Array();
var currencyArray =new Array();
var countryArray =new Array();
var countryArray1 =new Array();
</script> <%
 	int x = 0;
 	for (MstrCode codeType : mstrCodeForExpesnseTypeList) {
 %> <script>
			expenseArray[<%=x%>]= new Array();
			expenseArray[<%=x%>][0] = "<%=codeType.getId()%>";
			expenseArray[<%=x%>][1] = "<%=codeType.getCodeDesc()%>";
		</script> <%
 	x++;
 	}
 %> <%
 	int j = 0;

 	for (MasDistrict masDistrict : masCityList) {
 %> <script>
			cityArray[<%=j%>]= new Array();
			cityArray[<%=j%>][0] = "<%=masDistrict.getId()%>";
			cityArray[<%=j%>][1] = "<%=masDistrict.getDistrictName()%>";
			
		</script> <%
 	j++;
 	}
 %> <%
 	int r = 0;

 	for (MasDistrict masDistrict : masCityList) {
 %> <script>
			cityArray1[<%=r%>]= new Array();
			cityArray1[<%=r%>][0] = "<%=masDistrict.getId()%>";
			cityArray1[<%=r%>][1] = "<%=masDistrict.getDistrictName()%>";
			
		</script> <%
 	r++;
 	}
 %> <%
 	int n = 0;
 	for (MasCurrency masCurrency : currencyList) {
 %> <script>
			currencyArray[<%=n%>]= new Array();
			currencyArray[<%=n%>][0] = "<%=masCurrency.getId()%>";
			currencyArray[<%=n%>][1] = "<%=masCurrency.getCurrencyCode()%>";
		</script> <%
 	n++;
 	}
 %> </script> <%
 	int y = 0;
 	for (MasCountry masCountry : countryList) {
 %> <script>
			countryArray[<%=y%>]= new Array();
			countryArray[<%=y%>][0] = "<%=masCountry.getId()%>";
			countryArray[<%=y%>][1] = "<%=masCountry.getCountryName()%>";
			
		</script> <%
 	y++;
 	}
 %> <%
 	int q = 0;
 	for (MasCountry masCountry1 : countryList) {
 %> <script>
			countryArray1[<%=q%>]= new Array();
			countryArray1[<%=q%>][0] = "<%=masCountry1.getId()%>";
			countryArray1[<%=q%>][1] = "<%=masCountry1.getCountryName()%>";
			
		</script> <%
 	q++;
 	}
 %> </script> <input type="hidden" id="travelRequestId"
	name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" />
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<label>Travel Start Time</label> <input id="startTimeId"
	name="<%=START_TIME %>" validate="Start Time,string,no" maxlength="5"
	title="Time Should be in 24 hr Format" value=""
	onKeyUp="mask(this.value,this,'2',':');" /> <label>Travel End
Time</label> <input id="endTimeId" name="<%=END_TIME %>"
	validate="End Time,string,no" maxlength="5"
	title="Time Should be in 24 hr Format" value=""
	onKeyUp="mask(this.value,this,'2',':');" onBlur="timeDifference();" />
<label>Total Time</label> <input id="totalTimeId" name="totalTime"
	validate="Total Time,string,no" maxlength="5" value=""
	onBlur="timeDifference();" />
<div class="clear"></div>
<div class="division"></div>
<%
	BigDecimal totalAdvanceTaken = new BigDecimal(0);
	BigDecimal totalsettledAmount = new BigDecimal(0);
	BigDecimal balance = new BigDecimal(0);
	if (etrTravelReqListForAdvanceList.size() > 0) {
		for (EtrTravelreq etrTravelreqForAdvance : etrTravelReqListForAdvanceList) {

			if (etrTravelreqForAdvance.getAdvAmt() != null) {
				totalAdvanceTaken = totalAdvanceTaken
						.add(etrTravelreqForAdvance.getAdvAmt());
			}
			if (etrTravelreqForAdvance.getAdvancePaidAmt() != null) {
				totalsettledAmount = totalsettledAmount
						.add(etrTravelreqForAdvance.getAdvancePaidAmt());
			}

			balance = totalsettledAmount.subtract(totalAdvanceTaken);
%> <%
 	}
 	}
 %> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Tour
Advance:<%=advanceTaken%></label> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Tot.
Advance:<%=totalAdvanceTaken%></label> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Total
Settled:<%=totalsettledAmount%></label> <label
	style="text-align: left; font: normal 10px verdana; background-color: white; color: black;">Balance:<%=balance%></label>


<table id="ticketDetails" class="medium">
	<tr>
		<th>Select</th>
		<th>Expense Head</th>
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
		String from = "";
		int fromId = 0;
		String to = "";
		int toId = 0;

		if (etrTicketDetailsList.size() > 0) {
			for (EtrTicketdetails etrTicketdetails : etrTicketDetailsList) {
				fillBookDetailId = etrTicketdetails.getFbdt().getId();
	%>

	<tr>
		<td><input name="" class="radioCheck" type="checkbox"
			checked="checked" value="" /></td>
		<td><select id="expenseTypId<%=i%>"
			name="<%=EXPENSE_TYPE_ID+i %>" validate="Currency,string,no">
			<option value="0">Select</option>
			<%
				for (MstrCode mstrCode : mstrCodeForExpesnseTypeList) {
			%>
			<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc()%></option>

			<%
				}
			%>
		</select></td>
		<td><input type="text" id="fDateGrid<%=i%>" size="9"
			name="<%=FROM_DATE+i%>"	value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>" class="date" readonly="readonly" validate="From date ,date,yes" MAXLENGTH="30" onChange="message1()" /> 
			<img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="setdate('',document.submitExpenses.<%=FROM_DATE+i%>,event)" /></td>

		<td><input type="text" size="9" id="tDateGrid<%=i%>"
			name="<%=TO_DATE+i%>"
			value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"
			class="date" readonly="readonly" validate="To date ,date,yes"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onclick="setdate('',document.submitExpenses.<%=TO_DATE+i%>,event)" /></td>


		<%
		   
			if (travelTypeId == 907 || travelTypeId == 10) {
						if (etrTicketdetails.getFrmplc() != null) {
							if (etrTicketdetails.getFrmplc().getId() != null) {
								from = etrTicketdetails.getFrmplc()
										.getDistrictName();
								//fromId = etrTicketdetails.getFrmplc().getId();
							} else {
								from = "";
							}
						}
		%>
		<td><select name="<%=CITY_ID+i%>" id="cityId<%=i %>"
			class="small" validate="City,string,no">
			<option value="0">Select</option>
			<%
				for (MasDistrict masDistrict : masCityList) {
								if (masDistrict.getDistrictName().equals(from)) {
			%>
			<option value="<%=masDistrict.getId() %>" selected="selected"><%=masDistrict.getDistrictName()%></option>
			<%
				} else {
			%>

			<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>

			<%
				}
							}
			%>
		</select></td>
		<%
			} else if (travelTypeId == 11) {
						if (etrTicketdetails.getFromCountry() != null) {
							if (etrTicketdetails.getFromCountry().getId() != null) {
								from = etrTicketdetails.getFromCountry()
										.getCountryName();
								//fromId = etrTicketdetails.getFromCountry().getId();
							} else {
								from = "";
							}
						}
		%>
		<td><select name="<%=COUNTRY_ID+i%>" class="small"
			id="countryId<%=i %>" validate="City,string,no">
			<option value="0">Select</option>
			<%
				for (MasCountry masCountry : countryList) {
								if (masCountry.getCountryName().equals(from)) {
			%>
			<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
			<%
				} else {
			%>

			<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName()%></option>

			<%
				}
							}
			%>
		</select></td>

		<%
			}
		%>

		<%
		if (travelTypeId == 907 || travelTypeId == 10){
						if (etrTicketdetails.getFrmto() != null) {
							to = etrTicketdetails.getFrmto().getDistrictName();
							//toId = etrTicketdetails.getFrmto().getId();
						} else {
							to = "";
						}
		%>
		<td><select name="<%=CITY_ID1+i%>" class="small"
			id="tocityId<%=i %>" validate="City,string,no">
			<option value="0">Select</option>
			<%
				for (MasDistrict masDistrict : masCityList) {
								if (masDistrict.getDistrictName().equals(to)) {
			%>
			<option value="<%=masDistrict.getId() %>" selected="selected"><%=masDistrict.getDistrictName()%></option>
			<%
				} else {
			%>

			<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>

			<%
				}
							}
			%>
		</select></td>
		<%
			} else if (travelTypeId == 11) {
						if (etrTicketdetails.getToCountry() != null) {
							to = etrTicketdetails.getToCountry()
									.getCountryName();
							//toId = etrTicketdetails.getToCountry().getId();
						} else {
							to = "";
						}
		%>
		<td><select name="<%=COUNTRY_ID1+i%>" id="tocountryId<%=i %>"
			class="small" validate="City,string,no">
			<option value="0">Select</option>
			<%
				for (MasCountry masCountry : countryList) {
								if (masCountry.getCountryName().equals(to)) {
			%>
			<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
			<%
				} else {
			%>

			<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName()%></option>

			<%
				}
							}
			%>
		</select></td>
		<%
			}
		%>


		<td><select id="currencyId<%=i %>" name="<%=CURRENCY_ID+i%>"
			class="small" validate="Currency,string,no">
			<option value="0">Select</option>
			<%
				for (MasCurrency masCurrency : currencyList) {
			%>
			<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode()%></option>

			<%
				}
			%>
		</select></td>
		<td><input id="amountId<%=i %>" name="<%=TICKET_AMT+i%>" size="7"
			value="<%=etrTicketdetails.getAmt()%>" validate="Remark,string,no"
			maxlength="50" /></td>

		<td><input id="descriptionId" name="<%=DESCRIPTION+i%>" value=""
			size="10" validate="Remark,string,no" maxlength="50" /></td>

	</tr>


	<%
		i++;
			}
		}
	%>
</table>
<input name="add" type="button" class="button" value="Add"
	onClick="addRowForExpenses();" /> <input name="ViewRequest"
	type="button" class="button" value="Delete" onClick="removeRow();" />
<input type="hidden" name="hiddenValueTicket" id="hiddenValueTicket"
	value="<%=i%>" /> <input type="hidden"
	name="<%=ETR_FILL_BOOK_DETAIL_ID %>" value="<%=fillBookDetailId %>">
<script type="text/javascript">
function addRowForExpenses(){
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
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name='<%=EXPENSE_TYPE_ID%>'+ iteration;
	e1.id='expenseTypId'+iteration;
	e1.options[0] = new Option('Select', '0');

	for(var k = 0;k<expenseArray.length;k++){
		e1.options[k+1] = new Option(expenseArray[k][1],expenseArray[k][0]);
	}
	
	cell1.appendChild(e1); 
	
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=FROM_DATE%>'+ iteration;
	e2.id='fDateGrid'+iteration;
	e2.size = '9'
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.class = 'calender';
	eImg.style.display ='inline';
	eImg.onclick = function(event){
					setdate('',document.getElementById('fDateGrid'+iteration),event) };
	cell2.appendChild(e2); 
	cell2.appendChild(eImg);
	
	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=TO_DATE%>'+ iteration;
	e3.id='tDateGrid'+iteration;
	e3.size = '9'
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.class = 'calender';
	eImg.style.display ='inline';
	eImg.onclick = function(event){
					setdate('',document.getElementById('tDateGrid'+iteration),event) };
	cell3.appendChild(e3); 
	cell3.appendChild(eImg);
	
	
	
<%
		if(travelTypeId==907 || travelTypeId == 10 ){
%>

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name='<%=CITY_ID%>'+ iteration;
	e4.id='cityId'+iteration;
	e4.options[0] = new Option('Select', '0');

	for(var k = 0;k<cityArray.length;k++){
		e4.options[k+1] = new Option(cityArray[k][1],cityArray[k][0]);
	}
	e4.className='small'
	cell4.appendChild(e4); 
	
	
	var cell5 = row.insertCell(5);
	var e5 = document.createElement('select');
	e5.name='<%=CITY_ID1%>'+ iteration;
	e5.id = 'tocityId'+iteration
	e5.options[0] = new Option('Select', '0');
	for(var j = 0;j<cityArray1.length;j++ ){
		e5.options[j+1] = new Option(cityArray1[j][1],cityArray1[j][0]);
	}
	e5.className='small'
	cell5.appendChild(e5);


<%
}else if(travelTypeId==11){
%>
	var cell4 = row.insertCell(4);
	var e4 = document.createElement('select');
	e4.name = '<%=COUNTRY_ID%>'+ iteration;
	e4.id = 'countryId' + iteration;
	e4.options[0] = new Option('Select', '0');
	for(var h = 0;h<countryArray.length;h++ ){
		e4.options[h+1] = new Option(countryArray[h][1],countryArray[h][0]);
	}
	e4.className='small'
	cell4.appendChild(e4);
	
	var cell5 = row.insertCell(5);
	var e5 = document.createElement('select');
	e5.name='<%=COUNTRY_ID1%>'+ iteration;
	e5.id = 'tocountryId'+iteration
	e5.options[0] = new Option('Select', '0');
	for(var e = 0;e<countryArray1.length;e++ ){
		e5.options[e+1] = new Option(countryArray1[e][1],countryArray1[e][0]);
	}
	 e5.className='small'
	cell5.appendChild(e5);
<%}%>
	
	var cell6 = row.insertCell(6);
	var e6 = document.createElement('select');
	e6.name='<%=CURRENCY_ID%>'+ iteration;
	e6.id = 'currencyId'+iteration
	e6.options[0] = new Option('Select', '0');
	for(var e = 0;e<currencyArray.length;e++ ){
		e6.options[e+1] = new Option(currencyArray[e][1],currencyArray[e][0]);
	}
	 e6.className='small'
	cell6.appendChild(e6);
	
	
	var cell7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.type = 'text';
	e7.name='<%=TICKET_AMT%>'+ iteration;
	e7.id='amountId'+iteration;
	e7.size = '7'
	cell7.appendChild(e7); 
	
	var cell8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.type = 'text';
	e8.name='<%=DESCRIPTION%>'+ iteration;
	e8.id='descId'+iteration;
	e8.size = '10'
	cell8.appendChild(e8); 
	
}
</script> <script type="text/javascript">
function openPopupWindow()
{
	var id = document.getElementById('travelRequestId').value;
	var url="/hms/hrms/etravel?method=displaySubmitExpensesAttachment&travelRequestId="+id+"";
 	newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
}


function removeRow()
	{
	 var tbl = document.getElementById('ticketDetails');
	  var tblRows  = tbl.getElementsByTagName("tr");
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
		 for(var j=2;j<=rowlength;j++){
		    var i = j - 1;
		// if(document.getElementById('expenseTypId'+i).value != null){
	
		 	if(document.getElementById('expenseTypId'+i).value == "0" || document.getElementById('expenseTypId'+i).value == ""){
		 		msg += "Expense Head can not be blank in row "+i+".\n";
		  	}
		 	if(document.getElementById('fDateGrid'+i).value == "" ){
		 		msg += "From Date can not be blank in row "+i+".\n";
		  	}
		 	if(document.getElementById('tDateGrid'+i).value == "" ){
		 		msg += "To Date can not be blank in row "+i+".\n";
		 	}
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
			 	if(document.getElementById('currencyId'+i).value == 0 || document.getElementById('currencyId'+i).value == ""){
			 		msg += "Currency can not be blank in row "+i+".\n";
			 	}
	  			if(document.getElementById('amountId'+i).value == "" ){
		 		msg += "Amount can not be blank in row "+i+".\n";
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
<!-- <input name="button" type="button" class="buttonBig" value="Cancel Booked Details" onClick="submitForm('submitExpenses','etravel?method=cancelBookedDetails');"/>
--> 


<input name="button" type="button" class="buttonBig" value="Submit Expenses"
	onClick="submitForm('submitExpenses','etravel?method=saveSubmitExpensesDetails','checkFromDate','checkTime','validateRow');" />
<input name="Send" type="button" class="buttonBig" value="Attach Files"
	onClick="javascript:openPopupWindow();" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label> <label class="value"><%=userName%></label>

<label>Last Changed DATE</label> <label class="value"><%=date%></label>

<label>Last Changed Time</label> <label class="value"><%=time%></label>


</div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

