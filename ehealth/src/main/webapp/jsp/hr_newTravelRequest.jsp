<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrCode"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.MasLocation"%>
<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>

<%

				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>mstrProjectList = new ArrayList<MstrProject>();
				List<Object[]>departmentList = new ArrayList<Object[]>();
				List<MstrSiteHeader> mstrSiteList = new ArrayList<MstrSiteHeader>();
				List<Object[]> employeeList = new ArrayList<Object[]>();
				List<MasDistrict> masCityList = new ArrayList<MasDistrict>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<MstrCode> mstrCodeForTripList = new ArrayList<MstrCode>();
				List<PrjSiteResMap> prjSiteMapList = new ArrayList<PrjSiteResMap>();
				List<MstrCode> mstrCodeForTravelModeList = new ArrayList<MstrCode>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MasEmployee> employeeforLineManagerList = new ArrayList<MasEmployee>();
				List<MasEmployee> userEmployeeList = new ArrayList<MasEmployee>();
				Users users = new Users();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("mstrProjectList")!= null){
					mstrProjectList = (List)map.get("mstrProjectList");
				}
				if(map.get("userEmployeeList")!= null){
					userEmployeeList = (List)map.get("userEmployeeList");
				}
				if(map.get("employeeforLineManagerList")!= null){
					employeeforLineManagerList = (List)map.get("employeeforLineManagerList");
				}
				if(map.get("countryList")!= null){
					countryList = (List)map.get("countryList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("mstrSiteList")!= null){
					mstrSiteList = (List)map.get("mstrSiteList");
				}
				
				if(map.get("masCityList")!= null){
					masCityList = (List)map.get("masCityList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("mstrCodeForTripList")!= null){
					mstrCodeForTripList = (List)map.get("mstrCodeForTripList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("prjSiteMapList")!= null){
					prjSiteMapList = (List)map.get("prjSiteMapList");
				}
				if(map.get("mstrCodeForTravelModeList")!= null){
					mstrCodeForTravelModeList = (List)map.get("mstrCodeForTravelModeList");
				}
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
				
				String locationName = "";
				String empName = "";
				int empId = 0;
				String designation = "";
				String department = "";
				String orgnization = "";
				if(userEmployeeList.size()>0){
					for(MasEmployee masEmployee :userEmployeeList){
						if(masEmployee.getLocation() != null){
						locationName =(String) masEmployee.getLocation().getLocationName();
						}
						empId = (Integer)masEmployee.getId();
						empName = (String)(masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()+"-"+masEmployee.getEmployeeCode());
							
						if(masEmployee.getDepartment() != null){
							department = (String)masEmployee.getDepartment().getDepartmentName();
							}
						if(masEmployee.getRank() != null){
							designation = (String)masEmployee.getRank().getRankName();
							}
						if(masEmployee.getHospital() != null){
							orgnization = (String)masEmployee.getHospital().getHospitalName();
							}
					}
				}
				
				
	%>

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
	
	function checkTicketBookingDate(){
		var fDate = document.getElementById('fromDateId').value;
		var ticketDate = document.getElementById('bookingDateId').value;
		
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var ticketBookingDate =new Date(ticketDate.substring(6),(ticketDate.substring(3,5) - 1) ,ticketDate.substring(0,2))
		if(fDate != "" && ticketDate != ""){
		if (ticketBookingDate < fromDate ){
			alert(" Ticket Booking Date should be greater than equal to  From Date.");
			document.getElementById('bookingDateId').value = "";
			return false;
		}
		}
		return true;
	}



	function checkExpectedDate(){
	
		var fDate =  document.getElementById('fromDateId').value;
		var eDate = document.getElementById('expectedOnId').value;
		
		var	fromDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		var expectedDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		if(fDate != "" && eDate != ""){
		if(fromDate < expectedDate)
		{
			alert(" Advance Expected Date should be equal and less than  From Date.");
			
			document.getElementById('expectedOnId').value= "";
			return false;
		}
		}
		return true;
	}

	function selectProject(){
		obj = document.getElementById('prjectBasedId');
		   	if(obj.checked){
				document.getElementById('projectId').value = "";
		   		document.getElementById('projectId').disabled = false;
		   		document.getElementById('siteId').value = "";
		   		document.getElementById('siteId').disabled = false;
		   	}else{
		   		document.getElementById('projectId').disabled =true;
		   		document.getElementById('siteId').disabled =true;
		   		
		   	}
		  }
		  
	function selectOthers(){
		obj = document.getElementById('othersId');
	   	if(obj.checked){
			document.getElementById('departmentId').value = "";
	   		document.getElementById('departmentId').disabled = false;
	   		document.getElementById('employeeId').value = "";
	   		document.getElementById('employeeId').disabled = false;
	   	}else{
	   		document.getElementById('departmentId').disabled =true;
	   		document.getElementById('employeeId').disabled =true;
	   	}
	  }
	  
	  function calculateNoOfDays(){
	   var day1, day2;
	   var month1, month2;
	    var year1, year2;
		var fDate =  document.getElementById('fromDateId').value;
		var tDate = document.getElementById('toDateId').value;
			
			day1 = fDate.substring (0, fDate.indexOf ("/"));
			month1 = fDate.substring (fDate.indexOf ("/")+1, fDate.lastIndexOf ("/"));
			year1 = fDate.substring (fDate.lastIndexOf ("/")+1, fDate.length);
			
			day2 = tDate.substring (0, tDate.indexOf ("/"));
			month2 = tDate.substring (tDate.indexOf ("/")+1, tDate.lastIndexOf ("/"));
			year2 = tDate.substring (tDate.lastIndexOf ("/")+1, tDate.length); 
			
			var date1 = year1+"/"+month1+"/"+day1;
			var date2 = year2+"/"+month2+"/"+day2;
			
			var firstDate = Date.parse(date1)
			var secondDate= Date.parse(date2)
			
			
		//var	startDate =new Date(fDate.substring(6),(fDate.substring(3,5) - 1) ,fDate.substring(0,2))
		
		///var endDate =new Date(tDate.substring(6),(tDate.substring(3,5) - 1) ,tDate.substring(0,2))
				var oneday = 1000 * 60 * 60 * 24
			var dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ oneday) + 1;
		//var diffDays = Math.abs((startDate.getTime() - endDate.getTime()));
		
		//alert("diffDays=="+diffDays)
		
		//var totalDays = Math.round(diffDays/oneday);
		document.newTravelRequest.<%= NO_OF_DAYS %>.value = dbd;

	}
	function selectTrip(val){
		if(val == "10"){
			document.getElementById('cityId').value = "";
	   		document.getElementById('cityId').disabled = false;
	   		document.getElementById('cityId1').value = "";
	   		document.getElementById('cityId1').disabled = false;
			document.getElementById('countryId').disabled = true;
			document.getElementById('countryId1').disabled = true;
		}else if(val == "11"){
			document.getElementById('countryId').value = "";
	   		document.getElementById('countryId').disabled = false;
	   		document.getElementById('countryId1').value = "";
	   		document.getElementById('countryId1').disabled = false;
			document.getElementById('cityId').disabled = true;
			document.getElementById('cityId1').disabled = true;
		}else{
			document.getElementById('cityId').value = "";
	   		document.getElementById('cityId').disabled = false;
	   		document.getElementById('cityId1').value = "";
	   		document.getElementById('cityId1').disabled = false;
			document.getElementById('countryId').value = "";
	   		document.getElementById('countryId').disabled = false;
	   		document.getElementById('countryId1').value = "";
	   		document.getElementById('countryId1').disabled = false;
		}
		
		
	}
//-------------------------------------------------------------	  
	  function addRow(){
	    
	     document.getElementById('submitButtonDiv').style.display = "inline";
	     
		 var tbl = document.getElementById('ticketBooking');
		 var lastRow = tbl.rows.length;
		 
		 var row = tbl.insertRow(lastRow);
		 var hdb = document.getElementById('hiddenValueTicketBooking');
		 var iteration = parseInt(hdb.value)+1;
		 hdb.value = iteration;
		 
		 var cell0 = row.insertCell(0);
		 var e0 = document.createElement('input');
		 e0.type = 'checkbox';
		 e0.name='checkedValue1';
		 e0.className='radioCheck';
		 e0.value=(iteration);
		 cell0.appendChild(e0);
				 
		 var w = document.getElementById('cityId').selectedIndex;
		 var selectedText = document.getElementById('cityId').options[w].text;
				 
		 var cell1 = row.insertCell(1);
		 var e1 = document.createElement('input');
		 e1.type = 'text';
		 e1.className='readOnly';
		 e1.name = '<%=CITY_ID%>'+ (iteration);
		 e1.id = 'cityId'
		 if(document.getElementById('cityId').value != "")
		 	e1.value = selectedText;
		 e1.size = '10'
		 var e11 = document.createElement('input');
		 e11.type = 'hidden';
		 e11.name = '<%=CITY_HIDDEN_ID%>'+ (iteration);
		 	
		 
		 e11.value = document.getElementById('cityId').value;
		 
		 cell1.appendChild(e11);
		 cell1.appendChild(e1);
		 
		 var w = document.getElementById('cityId1').selectedIndex;
		 var selectedText = document.getElementById('cityId1').options[w].text;
		 	 
		 var cell2 = row.insertCell(2);
		 var e2 = document.createElement('input');
		 e2.type = 'text';
		 e2.className='readOnly';
		 e2.name='<%=CITY_ID1%>'+ (iteration);
		 if(document.getElementById('cityId1').value != "")
		 e2.value = selectedText;
		 e2.size = '10'
		 var e21 = document.createElement('input');
		 e21.type = 'hidden';
		 e21.name = '<%=CITY_HIDDEN_ID1%>'+ (iteration);
		 e21.value = document.getElementById('cityId1').value;
		 cell2.appendChild(e2);
		 cell2.appendChild(e21);
		 
		 var w = document.getElementById('travelModeId').selectedIndex;
		 var selectedText = document.getElementById('travelModeId').options[w].text;
		 
		 var cell3 = row.insertCell(3);
		 var e3 = document.createElement('input');
		 e3.type = 'text';
		 e3.className='readOnly';
		 e3.name='<%=TRAVEL_MODE_ID%>'+ (iteration);
		 e3.value =selectedText;
		 e3.size = '7'
		 var e33 = document.createElement('input');
		 e33.type = 'hidden';
		 e33.name='<%=TRAVEL_MODE_HIDDEN_ID%>'+ (iteration);
		 e33.value =document.getElementById('travelModeId').value;
		 cell3.appendChild(e3); 
		  cell3.appendChild(e33); 
		 
		 var cell4 = row.insertCell(4);
		 var e4 = document.createElement('input');
		 e4.type = 'text';
		 e4.className='readOnly';
		 e4.name='<%=TICKET_BOOKING_DATE%>'+ (iteration);
		  e4.value = document.getElementById('bookingDateId').value;
		  e4.size = '10'
		 cell4.appendChild(e4); 
		 
		 var cell5 = row.insertCell(5);
		 var e5 = document.createElement('input');
		 e5.type = 'text';
		 e5.className = 'readOnly';
		 e5.name='<%=BEFORE_TIME11%>'+ (iteration);
		 e5.value = document.getElementById('beforeTimeId').value+" - "+ document.getElementById('timeSlotId').value;
		 e5.size = '10'
		 cell5.appendChild(e5); 
		 
		 
		 var e51 = document.createElement('input');
		 e51.type = 'hidden';
		 e51.className = 'readOnly';
		 e51.name='<%=BEFORE_TIME%>'+ (iteration);
		 e51.value = document.getElementById('beforeTimeId').value;
		 e51.size = '7'
		 cell5.appendChild(e51); 
		 
		 
		
		 var e52 = document.createElement('input');
		 e52.type = 'hidden';
		 e52.className = 'readOnly';
		 e52.name='<%=TIME_SLOAT%>'+ (iteration);
		 e52.value = document.getElementById('timeSlotId').value;
		 e52.size = '7'
		 cell5.appendChild(e52); 
		 
	  
		 
		 
		 var cell6 = row.insertCell(6);
		 var e6 = document.createElement('input');
		 e6.type = 'text';
		 e6.className = 'readOnly';
		 e6.name='<%=REMARKS%>'+ (iteration);
		 e6.value = document.getElementById('remarksId').value;
		 
		 e6.size = '10'
		 cell6.appendChild(e6); 
		 
		 var w = document.getElementById('countryId').selectedIndex;
		 var selectedText = document.getElementById('countryId').options[w].text;
				 
		 var cell7 = row.insertCell(7);
		 var e7 = document.createElement('input');
		 e7.type = 'text';
		 e7.className='readOnly';
		 e7.name = '<%=COUNTRY_ID%>'+ (iteration);
		 if(document.getElementById('countryId').value != "")
		 e7.value = selectedText;
		 e7.size = '10'
		 var e71 = document.createElement('input');
		 e71.type = 'hidden';
		 e71.name = '<%=COUNTRY_HIDDEN_ID%>'+ (iteration);
		 e71.value = document.getElementById('countryId').value;
		 cell7.appendChild(e71);
		 cell7.appendChild(e7);
		 var w = document.getElementById('countryId1').selectedIndex;
		 var selectedText = document.getElementById('countryId1').options[w].text;
		  		  
		 var cell8 = row.insertCell(8);
		 var e8 = document.createElement('input');
		 e8.type = 'text';
		 e8.className = 'readOnly';
		 e8.name='<%=COUNTRY_ID1%>'+ (iteration);
		  if(document.getElementById('countryId1').value != "")
		 e8.value = selectedText;
		e8.size = '10'
		 var e81 = document.createElement('input');
		 e81.type = 'hidden';
		 e81.name='<%=COUNTRY_HIDDEN_ID1%>'+ (iteration);
		 e81.value =document.getElementById('countryId1').value;
		 cell8.appendChild(e8); 
		 cell8.appendChild(e81); 
		  document.getElementById('countryId1').value = ""
		  document.getElementById('countryId').value = ""
		  document.getElementById('remarksId').value = "";
		  document.getElementById('beforeTimeId').value = "";
		  document.getElementById('timeSlotId').value = "";
		  document.getElementById('cityId1').value = ""
		   document.getElementById('cityId').value = ""
		 document.getElementById('travelModeId').value = "";
		 document.getElementById('bookingDateId').value = "";
	}
	function addRowValue(){
		 var tbl = document.getElementById('gridId');
		 var lastRow = tbl.rows.length;
		 
		 var row = tbl.insertRow(lastRow);
		 var hdb = document.getElementById('hiddenValueForGrid');
		 var iteration = parseInt(hdb.value)+1;
		 hdb.value = iteration;
		 
		 var cell0 = row.insertCell(0);
		 var e0 = document.createElement('input');
		 e0.type = 'checkbox';
		 e0.name='checkedValue';
		 e0.className='radioCheck';
		 e0.value=(iteration);
		 cell0.appendChild(e0);
		 
		 var cell1 = row.insertCell(1);
		 var e1 = document.createElement('input');
		 e1.type = 'text';
		 e1.className='readOnly';
		 e1.name = '<%=FROM_DATE%>';
		 e1.value = document.getElementById('fromDateId').value;
		 e1.size = '10'
		 
		 cell1.appendChild(e1);
		 	 
		 var cell2 = row.insertCell(2);
		 var e2 = document.createElement('input');
		 e2.type = 'text';
		 e2.className='readOnly';
		 e2.name='<%=TO_DATE%>';
		 e2.value = document.getElementById('toDateId').value;
		 e2.size = '10'
		 cell2.appendChild(e2);
		 
		 var cell3 = row.insertCell(3);
		 var e3 = document.createElement('input');
		 e3.type = 'text';
		 e3.className='readOnly';
		 e3.name='<%=NO_OF_DAYS%>';
		 e3.value =document.getElementById('noOfDaysId').value;
		 e3.size = '3'
		 cell3.appendChild(e3); 
		  
		 var w = document.getElementById('trip').selectedIndex;
		 var selectedText = document.getElementById('trip').options[w].text;
				 
		 var cell4 = row.insertCell(4);
		 var e4 = document.createElement('input');
		 e4.type = 'text';
		 e4.className='readOnly';
		 e4.name = '<%=TRIP_ID%>';
		 if(document.getElementById('trip').value != "0")
		 e4.value = selectedText;
		 e4.size = '12'
		  var e41 = document.createElement('input');
		 e41.type = 'hidden';
		 e41.name='<%=TRIP_HIDDEN_ID%>';
		 e41.value =document.getElementById('trip').value;
		  cell4.appendChild(e41); 
		 cell4.appendChild(e4);
		
		
		 var w = document.getElementById('projectId').selectedIndex;
		 var selectedText = document.getElementById('projectId').options[w].text;
				 
		 var cell5 = row.insertCell(5);
		 var e5 = document.createElement('input');
		 e5.type = 'text';
		 e5.className='readOnly';
		 e5.name = '<%=PROJECT_ID%>';
		 if(document.getElementById('projectId').value != "0"){
		 	e5.value = selectedText;
		 }
		 e5.size = '12'
		  var e51 = document.createElement('input');
		 e51.type = 'hidden';
		 e51.name='<%=PROJECT_HIDDEN_ID%>';
		 e51.value =document.getElementById('projectId').value;
		  cell5.appendChild(e51); 
		 cell5.appendChild(e5);
		 
		 var w = document.getElementById('siteId').selectedIndex;
		 var selectedText = document.getElementById('siteId').options[w].text;
				 
		 var cell6 = row.insertCell(6);
		 var e6 = document.createElement('input');
		 e6.type = 'text';
		 e6.className='readOnly';
		 e6.name = '<%=SITE_ID%>';
		 if(document.getElementById('siteId').value != "0")
		 e6.value = selectedText;
		  e6.size = '10'
		   var e61 = document.createElement('input');
		 e61.type = 'hidden';
		 e61.name='<%=SITE_HIDDEN_ID%>';
		 e61.value =document.getElementById('siteId').value;
		 cell6.appendChild(e6);
		  cell6.appendChild(e61); 
		 		 
		 var cell7 = row.insertCell(7);
		 var e7 = document.createElement('input');
		 e7.type = 'checkbox';
		 e7.name='<%=TICKET_BOOKING%>';
		 e7.className='radioCheck';
		 e7.id = 'ticketCheckedValueId';
		  
		 e7.onclick = function(){checkTicketValue();};
		 cell7.appendChild(e7); 
		 
		 var cell8 = row.insertCell(8);
		 var e8 = document.createElement('input');
		 e8.type = 'checkbox';
		 e8.name='<%=NEED_ADVANCE%>';
		 e8.className='radioCheck';
		 e8.id = 'advanceCheckedValueId'
		 e8.onclick = function(){checkNeedAdvanceValue();};
		 cell8.appendChild(e8); 
		 
		 var cell9 = row.insertCell(9);
		 var e9 = document.createElement('input');
		 e9.type = 'checkbox';
		 e9.name='<%=HOTEL_BOOKING%>';
		 e9.className='radioCheck';
		 e9.id = 'hotelCheckedValueId'
		 e9.onclick = function(){checkHotelRemark();};
		 cell9.appendChild(e9); 
		  		  
		 var cell10 = row.insertCell(10);
		 var e10 = document.createElement('input');
		 e10.type = 'checkbox';
		 e10.name='<%=CAB_BOOKING%>';
		 e10.className='radioCheck';
		 e10.id = 'cabCheckedValueId'
		 e10.onclick = function(){checkCabRemark();};
		 cell10.appendChild(e10); 
		 
		 document.getElementById('siteId').value = "0"
		 document.getElementById('projectId').value = "0";
		 document.getElementById('trip').value = "0";
		  document.getElementById('noOfDaysId').value = "";
		 document.getElementById('toDateId').value = "";
		 document.getElementById('fromDateId').value = "";
		
	}
	
	
	function removeRowValue()
	{
		
	 var tbl = document.getElementById('gridId');
	  var tblRows  = tbl.getElementsByTagName("tr");
	for(counter1=0;counter1<document.getElementsByName('checkedValue').length;counter1++)
	 {
	  if (document.getElementsByName('checkedValue')[counter1].checked == true) 
	  {
	     tbl.deleteRow(counter1+1);
	  }
	 }
}	
	
	function removeRow()
	{
	 var tbl = document.getElementById('ticketBooking');
	  var tblRows  = tbl.getElementsByTagName("tr");
	 for(counter1=0;counter1<document.getElementsByName('checkedValue1').length;counter1++)
	 {
	  if (document.getElementsByName('checkedValue1')[counter1].checked == true) 
	  {
	     tbl.deleteRow(counter1+1);
	    
	  }
	 }
}
	function checkTicketValue(){
	if(document.getElementById('ticketCheckedValueId').checked){
	document.getElementById('ticketBookinDiv').style.display = "inline";
	}else{
	document.getElementById('ticketBookinDiv').style.display = "none";
	}
 }
	function checkNeedAdvanceValue(){
	if(document.getElementById('advanceCheckedValueId').checked){
	document.getElementById('needAdvanceDiv').style.display = "inline";
	}else{
	document.getElementById('needAdvanceDiv').style.display = "none";
	}
	}
	
	function checkHotelRemark(){
	if(document.getElementById('hotelCheckedValueId').checked){
	document.getElementById('hotelBookinDiv').style.display = "inline";
	}else{
	document.getElementById('hotelBookinDiv').style.display = "none";
	}
	}
	
	function checkCabRemark(){
	if(document.getElementById('cabCheckedValueId').checked){
	document.getElementById('cabBookinDiv').style.display = "inline";
	}else{
	document.getElementById('cabBookinDiv').style.display = "none";
	}
	}
	

</script>
<script type="text/javascript">

	function validateFieldsForDisplay(){
	var errMsg = "";
		var trip = document.getElementById('trip').value;	
		var fromDate = document.getElementById('fromDateId').value;
		var todate = document.getElementById('toDateId').value;
		var noOfDays = document.getElementById('noOfDaysId').value;
		if(trip == "0"){
			errMsg += "Travel Type can not be blank.\n";
		}
		
		if(fromDate == ""){
			errMsg += "From Date can not be blank.\n";
		}
		if(todate == ""){
			errMsg += "To Date can not be blank.\n";
		}
		if(noOfDays == "0"){
			errMsg += "No.Of days can not be blank.\n";
		}
		
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}
		document.getElementById('submitButtonDiv').style.display = "inline";
		return true;
	}
		
	function validateFields(){
		 var tbl = document.getElementById('ticketBooking');
		 var lastRow = tbl.rows.length;
		if(lastRow>1){
		  	return true;
		}else{
		
		 if(document.getElementById('ticketCheckedValueId').checked){
		 	var errMsg = "";
		var trip = document.getElementById('travelModeId').value;	
		if(trip == "")
			errMsg += "Travel Mode can not be blank.\n";
		var trip = document.getElementById('bookingDateId').value;	
		if(trip == "")
			errMsg += "Travel Date can not be blank.\n";
		var trip = document.getElementById('beforeTimeId').value;	
		if(trip == "")
			errMsg += "Time Slot can not be blank.\n";
		var trip = document.getElementById('timeSlotId').value;	
		if(trip == "")
			errMsg += "Time Slot can not be blank.\n";
		
		
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}	
	}
		 }
		 return true;
	} 
	
function IsValidTimeNext(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.
	var obj = document.getElementById(fieldId)
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
	
	var matchArray  = timeStr.match(timePat);
	if (matchArray == null) {
	    alert("Time should be in HH:MM:SS format.");
		window.setTimeout(function ()
        {
          obj.focus();
        }, 0);
     	obj.value = "";
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];
	
	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }
	
	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}	

function IsValidTimeNext2(timeStr,fieldId) {
	// Checks if time is in HH:MM:SS format.
	// The seconds are optional.
	var obj = document.getElementById(fieldId)
	var obj2 = document.getElementById('beforeTimeId')
	var timePat = /^(\d{1,2}):(\d{2})(:(\d{2}))?(\s?(AM|am|PM|pm))?$/;
	
	var matchArray  = timeStr.match(timePat);
	var matchArray2 = obj2.value.match(timePat);
	if(matchArray2 == null){
	  	window.setTimeout(function ()
        {
          obj2.focus();
        }, 0);
     	obj2.value = "";
		return false;
	}
	else if (matchArray == null) {
	    alert("Time should be in HH:MM:SS format.");
		window.setTimeout(function ()
        {
          obj.focus();
        }, 0);
     	obj.value = "";
		return false;
	}
	hour = matchArray[1];
	minute = matchArray[2];
	second = matchArray[4];
	ampm = matchArray[6];
	
	if (second=="") { second = null; }
	if (ampm=="") { ampm = null }
	
	if (hour < 0  || hour > 23) {
		alert("Hour must be between 0 and 23.");
		
		obj.value = "";
		obj.focus();
		return false;
	}
	if (minute<0 || minute > 59) {
		alert ("Minute must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	if (second != null && (second < 0 || second > 59)) {
		alert ("Second must be between 0 and 59.");
		obj.value = "";
		obj.focus();
		return false;
	}
	return false;
}
</script>

<form name="newTravelRequest" method="post" action="" >
<div class="titleBg"> <h2>Travel Request </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block">
<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName%>" readonly="readonly" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=empId%>">
<label>Designation </label>
<input name="<%=RANK_ID %>" value="<%=designation%> "  readonly="readonly" />
<label >Department </label>
<input name="<%=DEPARTMENT_ID %>"  value="<%=department %> " readonly="readonly"     />
<div class="clear"></div>
<label>Location </label>

<input name="<%=LOCATION_ID %>"  value="<%=locationName %>"    readonly="readonly" />

<label>Organization </label>
<input name="<%=HOSPITAL_ID %>"  value="<%=orgnization%>"   readonly="readonly" />
<div class="clear"></div>
<label><span>*</span>From Date </label>
<input id="fromDateId" type="text"  name="fDate" value="" class="date"  readonly="readonly"   MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>
 <label><span>*</span> To Date </label>
<input id="toDateId" type="text"  name="tDate" value=""  class="date"  readonly="readonly"    MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDateId'),event)"/>
 <label><span>*</span>No. of days </label>
<input id="noOfDaysId" name="noOfDays"   maxlength="8" />
<div class="clear"></div>
<label><span>*</span>Travel Type </label>
<select id="trip" name="trip"  onchange="selectTrip(this.value);" >
<option value="0">Select</option>
<%for(MstrCode mstrCode :mstrCodeForTripList){ %>
<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc() %></option>
<%} %>
</select>
<label>Project Based</label>
<input id="prjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>"   value="1" checked="checked" class="radioCheck" onclick="selectProject();"/>
<label class="auto">Yes</label>
<input id="nonProjectBasedId" type="radio" name="<%=PROJECT_BASED_TRIP %>" value="2" class="radioCheck"  onclick="selectProject();" />
<label class="medium">No</label>

<label>Project </label>
<select id="projectId" name="project"    onchange="submitProtoAjax('newTravelRequest','etravel?method=getProjectSiteDetailFromAjax');">
<option value="0">Select</option>
<%
	for(MstrProject mstrProject :mstrProjectList){
%>
<option value="<%=mstrProject.getId() %>"><%=mstrProject.getPrjName() %></option>
<%} %>
</select>

<div class="clear"></div>
<div id="testDiv">
<label>Site </label>
<select id="siteId" name="site"   >
<option value="0">Select</option>

</select>
</div>

<input id="lineManagerId" type="radio" name="<%=LINE_MANAGER_AND_OTHER %>"   value="1" checked="checked" class="radioCheck" onclick="selectOthers();"/>
<label class="auto">Line Manager</label>

<%if(employeeList.size()>0){ 
for(MasEmployee emp1 :employeeforLineManagerList){
%>
<label class="auto"><%=emp1.getLineManager().getFirstName()+" "+emp1.getLineManager().getLastName()%></label>
<%}} %>
<input id="othersId" type="radio" name="<%=LINE_MANAGER_AND_OTHER %>" value="2" class="radioCheck" onclick="selectOthers();" />
<label class="medium">Other</label>
<label>Department </label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>"  disabled="disabled"  onChange="populateEmployee(this.value,'newTravelRequest')">
<option value="0">Select</option>
<%
	for(Object[] masDepartment:departmentList){
%>
<option value="<%=masDepartment[0]%>"><%=masDepartment[1]%></option>
<%} %>
</select>
<div class="clear"></div>
<label>Head </label>
<select id="employeeId" name="<%=HEAD_ID %>" validate="Head,string,no"  disabled="disabled" >
<option value="0">Select</option>
<%for(Object[] masEmployee :employeeList){ %>
<option value="<%=masEmployee[0] %>"><%=masEmployee[2]+" "+masEmployee[3]+" "+masEmployee[4]%></option>
<%} %>
</select>
<%
	for(Object[] masEmployee :employeeList){ %>

<input type="hidden"  name="<%=HEAD_HIDDEN_ID %>" value="<%=masEmployee[0]%>">
<%} %>

<label>Comment </label>
<input type="text"  name="<%=COMMENTS%>" class="large"  validate="Comments,string,no"   maxlength="400" />

<div class="clear"></div>
<script type="text/javascript">
<%
int counter=0;
for (Object[] masDepartment :departmentList) 
{
for (Object[] masEmployee :employeeList) 
{
	if(masDepartment[0] != null){
		if(masDepartment[0].equals(masEmployee[9])){
%>
empArr[<%=counter%>] = new Array();
empArr[<%=counter%>][0] = <%=masDepartment[0]%>;
empArr[<%=counter%>][1] = <%=masEmployee[0]%>;									
empArr[<%=counter%>][2] = "<%=masEmployee[2] +" "+masEmployee[4]%>";
<%
counter++;
}
}
}
}
%>
</script> 
<input name="add" type="button" class="button" value="Add" onClick="if(validateFieldsForDisplay()){addRowValue();}"/>
<input name="ViewRequest" type="button"  class="button" value="Delete" onClick="removeRowValue();" />
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>


<table id="gridId" class="medium">
<tr>
<th>Select</th>
<th>From Date</th>
<th>To Date</th>
<th>Days</th>
<th>Type</th>
<th>Project</th>
<th>Site</th>
<th>Ticket</th>
<th>Advance</th>
<th>Hotel</th>
<th>Cab</th>
</tr>
</table>
<input type="hidden" value="0" name="hiddenValueForGrid" id="hiddenValueForGrid" />
<div class="clear"></div>
<div id="ticketBookinDiv" style="display: none;">
<label class="large">Assistance For Ticket Booking</label>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>From Country </label>
<select id="countryId" name="<%=COUNTRY_ID %>" validate="Country,string,no" disabled="disabled" >
<option value="">Select</option>
<%
	for(MasCountry masCountry :countryList){
%>
<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>

<%} %>
</select>


<label>To Country </label>
<select id="countryId1" name="<%=COUNTRY_ID1 %>" validate="Country ,string,no" disabled="disabled" >
<option value="">Select</option>
<%
for(MasCountry masCountry :countryList){
%>
<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>
<%} %>
</select>


<div class="clear"></div>
<label>From Place </label>
<select id="cityId" name="<%=CITY_ID %>" validate="City,string,no" disabled="disabled" >
<option value="">Select</option>
<%
	for(MasDistrict masDistrict :masCityList){
%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>

<%} %>
</select>


<label>To Place </label>
<select id="cityId1" name="<%=CITY_ID1 %>" validate="Country,string,no" disabled="disabled" >
<option value="">Select</option>
<%
for(MasDistrict masDistrict :masCityList){
%>
<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName()%></option>
<%} %>
</select>


<label><span>*</span>Travel Mode </label>
<select id="travelModeId" name="<%=TRAVEL_MODE_ID %>" validate="Travel Mode,string,no"   >
<option value="">Select</option>
<%for(MstrCode mstrCode :mstrCodeForTravelModeList){ %>
<option value="<%=mstrCode.getId() %>"><%=mstrCode.getCodeDesc() %></option>
<%} %>
</select>

<div class="clear"></div>
<label >Time Slot </label>
<input id="beforeTimeId" name="<%=BEFORE_TIME12 %>"  class="small"  validate="Before Time,string,no"   maxlength="5"  title="Time Should be in 24 hr Format"  value="" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeNext(this.value,this.id);" />
<label class="auto">to </label>
<input id="timeSlotId" name="<%=BEFORE_TIME13 %>" class="small"  validate="Before Time,string,no"   maxlength="5"  title="Time Should be in 24 hr Format"  value="" onKeyUp="mask(this.value,this,'2',':');" onBlur="IsValidTimeNext2(this.value,this.id);" />
<label>Travel Date </label>
 <input type="text" id="bookingDateId"  name="<%=TICKET_BOOKING_DATE%>" value="" class="date"  validate="Ticket Booking Date ,date,no"  readonly="readonly"   MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('bookingDateId'),event);"/>
<label>Remarks </label>
<input type="text" id="remarksId" name="<%=REMARKS %>"   validate="Remarks,string,no"   maxlength="100" />

<div class="clear"></div>

<div class="clear"></div>
<input name="add" type="button" class="button" value="Add" onClick="if(validateFields()){addRow();}"/>
<input name="ViewRequest" type="button"  class="button" value="Delete" onClick="removeRow();" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<table id="ticketBooking" class="medium" >
<tr>

<th>Select</th>
<th>From Place</th>
<th>To Place</th>
<th>Travel Type</th>
<th>Date</th>
<th>Time Slot</th>
<th>Remarks</th>
<th>From Country</th>
<th>To Country</th>
</tr>

</table>
<input type="hidden" value="0" name="hiddenValueTicketBooking" id="hiddenValueTicketBooking" />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div id="needAdvanceDiv" style="display: none;">
<label>Need Advance</label>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Currency</label>
<select id="currencyId" name="<%=CURRENCY_ID %>" validate="Currency,string,no" >
<option value="0">Select</option>
<%
for(MasCurrency masCurrency :currencyList){ 
%>
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode() %></option>

<%} %>
</select>
<label>Amount </label>
<input id="amountId" name="<%=TRAVEL_ADVANCE_AMOUNT %>"   validate="Travel Advance Amount,float,no"   maxlength="8" />
<label>Expected On </label>
<input id="expectedOnId" type="text"  name="<%=EXPECTED_ON_DATE %>"   value="" class="date" readonly="readonly" validate="Expected on Date date ,date,no"  MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.newTravelRequest.<%=EXPECTED_ON_DATE%>,event)"/>
 


<div class="clear"></div>
<label>Remark </label>
<input id="descriptionId" name="<%=DESCRIPTION %>"   validate="Remark,string,no"   maxlength="100" />
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div id="hotelBookinDiv" style="display: none;">
<label class="Auto">Hotel Remark</label>
<textarea  id="hotelBookingId" type="textarea" name="<%=HOTEL_BOOKING_DESC %>" value="" class="medium"  validate="HotelDesc,string,no"  class="large" MAXLENGTH="500" tabindex=1></textarea>
</div>
<div id="cabBookinDiv" style="display: none;">
<label class="Auto">CAB Remark</label>
<textarea id="cabBookingId" type="textarea" name="<%=CAB_BOOKING_DESC %>" class="medium"   value="" validate="Remarks,string,no"  class="large" MAXLENGTH="500" tabindex=1/></textarea>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div id="submitButtonDiv" style="display: none;">
<input name="Submit11" type="button" class="button" value="Submit" onClick="submitForm('newTravelRequest','etravel?method=submitNewTravelRequest');"/>
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
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

