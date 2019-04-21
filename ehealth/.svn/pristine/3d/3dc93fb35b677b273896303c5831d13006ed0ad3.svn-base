<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * appSetup.jsp  
 * Purpose of the JSP -  This is for Appointment Setup Screen.
 * @author  Priyanka
 * Create Date: 10th july,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<form name="OtListChange" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript" language="javascript">
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
		
	function checkForSelection()
	{
	for(var i = 0; i < document.getElementsByName('bookingId').length; i++)
		{
			  if(document.getElementsByName('bookingId')[i].checked == true && document.getElementsByName('bookingId')[i].value!=null)
			  {
					rowSelected=true;
					break;	
		      }
			  else
					rowSelected=false;
		}
		if(rowSelected==false)
		{
			if(!displayAlert("Select a Record!!"))
				alert("Select a Record!!");
			return false;
		}
		return true;
	}	
	function getOTSchedule(){
	var bookingDate=document.getElementById("bookingDate").value;
	submitForm('OtListChange','ot?method=getOTSchedule&bookingDate='+bookingDate+'');
	}
	</script>
<div class="titleBg">
<h2>OT List Change</h2>
</div>
<div class="clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	Box box=HMSUtil.getBox(request);
			 	List <OtBooking> otBookingList = new ArrayList<OtBooking>();
			 	
			 	String url=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	if(map.get("otBookingList") != null){
					otBookingList = (List)map.get("otBookingList");
				}	 	
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <span><%=message %></span> <%    
					   
					  }		 	
			 %> <!--Block One Starts-->


<div class="Block">
<div class="clear"></div>
<label>Booking Date</label>
<input type="text" id="bookingDate"	name="bookingDate" value="" maxlength="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" onclick="setdate('<%=currentDate %>',document.OtListChange.bookingDate,event);"
	validate="Pick a date" class="date" />
	<div class="clear"></div>
<input name="Print"	type="button" value="Load All OT Schedule" target="_blank"	class="inputButtonAutu" onclick="getOTSchedule();" />
<div class="clear"></div></div>
<div class="clear"></div>
<!--Block one Ends-->

<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>

<!--Block Three Starts-->
<%
	if(otBookingList !=null && otBookingList.size() >0){ %>

<div class="Block">
	
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Sl.No.</th>
		<th scope="col">OT Name</th>
		<th scope="col">Booking Date</th>
		<th scope="col">Name</th>
		<th scope="col">Age (Yrs)</th>
		<th scope="col">Diagnosis</th>
		<th scope="col">Operation</th>
		<th scope="col">Anae</th>
		<th scope="col">Ward</th>
		<th scope="col">Surgeon</th>
	</tr>


		<%	Iterator itr=otBookingList.iterator();
          	int  counter=0;
         	 while(itr.hasNext())
           	{
            
             		OtBooking  otBooking = (OtBooking)itr.next(); 
   %>

	<tr>
		<td><input name="bookingId" id="bookingId" type="radio"
			value="<%=otBooking.getId()%>" class="radioCheck" /></td>
		<td>
		<%if(otBooking.getSlNo()==0){ %> Stand By <%}else{%><%=otBooking.getSlNo() %>
		<%} %>
		</td>

		<td><%=otBooking.getOt().getOtName() %></td>

		<td><%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%></td>
		<input type="hidden" name="date"
			value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate()) %>" />
		<td><%=otBooking.getHin().getPFirstName()%></td>
		<td><%=otBooking.getHin().getAge() %></td>
		<%if(otBooking.getInpatient()!=null ){%>
		<td><%=otBooking.getInpatient().getInitDiagnosis() %></td>
		<%}else{%>
		<td>&nbsp;</td>
		<%}%>
		<td><%=otBooking.getChargeCode().getChargeCodeName() %></td>
		<td></td>
		<td><%=otBooking.getDepartment().getDepartmentName() %></td>
		<td><%=otBooking.getBookedBy().getFirstName()%></td>
	</tr>
	<%
			counter++;
		}//end of WHILE%>
		<div class="clear"></div>
			<input name="Input" type="button" class="buttonBig" value="Change Booking"
	              onclick="submitForm('OtListChange','ot?method=changeOTSchedule','checkForSelection');" />
	              
	<input name="Input" type="button" class="buttonBig"	value="Cancel Booking" 
	              onclick="submitForm('OtListChange','ot?method=cancelOTSchedule','checkForSelection');" />
		<%
	} //end of IF
%>
</table>
<div class="clear"></div>
</div>
</form>
<!--main content placeholder ends here-->