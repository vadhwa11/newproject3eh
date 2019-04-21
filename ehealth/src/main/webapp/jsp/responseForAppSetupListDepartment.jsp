<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<AppSetup>appSetupList=new ArrayList<AppSetup>();

if(map.get("setupList")!=null){
	appSetupList=(List<AppSetup>)map.get("setupList");
}
String url="";
String[] day=new String[7];
	day[0]="Sunday";
	day[1]="Monday";
	day[2]="Tuesday";
	day[3]="Wednesday";
	day[4]="Thursday";
	day[5]="Friday";
	day[6]="Saturday";
%>


<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Days</th>
		<!--<th scope="col">No. of Doctors</th>
		-->
		<!-- <th scope="col">From Time:</th>
		<th scope="col">To Time</th>
		<th scope="col">Slot Duration</th>
		<th scope="col">% for Slot</th>
		<th scope="col">Break From Time</th>
		<th scope="col">Break To Time</th>
		<th scope="col">Break From Time 2</th>
		<th scope="col">Break To Time 2</th>
		<th scope="col">Break From Time 3</th>
		<th scope="col">Break To Time 3</th> -->
		<th scope="col">Token Start No.</th>
		<th scope="col">Token Interval</th>
		<th scope="col">Total Token</th>
		<th scope="col">Max No. of Days</th>
		<th scope="col">Min No. of Days</th>
	</tr>
	<%

     	int inc = 0;
     if(appSetupList!=null && appSetupList.size()<=0)
     {}
     else if (appSetupList!=null && appSetupList.size()>0)
     {
   		 url="submitForm('appSetup','appointment?method=updateAppointmentSetup');";

    	 Iterator ite=appSetupList.iterator();
    	 while ( ite.hasNext() ) {
     		AppSetup appSetup=(AppSetup)ite.next();
     		System.out.println(appSetup.getBreakFromTime()+">>>"+appSetup.getDays());
     %>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[inc]%>" />
		<input type="hidden" name="<%=DEPT_ID%>"
			value="<%=appSetup.getDept().getId()%>" />
		<input type="hidden" name="<%=APPOINTMENT_ID%>"
			value="<%=appSetup.getId()%>" />
		<td class="colHeader"><%=day[inc]%></td>
		<!--<td>
		<%if(appSetup.getNoOfDoctor()!=null && appSetup.getNoOfDoctor()!=0){ %>
		<input type="text" id="dr<%=inc%>" size=8 name="<%=DR%>" MAXLENGTH="3"
			value="<%=appSetup.getNoOfDoctor() %>"
			validate="No. Of Doctors,num,no" /> <%}else{ %> <input type="text"
			id="dr<%=inc%>" size=8 name="<%=DR%>" MAXLENGTH="3"
			validate="No. Of Doctors,num,no" /> <%}%>
		</td>

		--><td>
		<%if(appSetup.getFromTime()!=null){ %> <input type="text" size=8
			id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getFromTime() %>" /> <%}else{ %> <input type="text"
			size=8 id="fromTime<%=inc%>" name="<%=FROMTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getToTime()!=null){ %> <input type="text" size=8
			id="toTime<%=inc%>" name="<%=TOTIME %>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getToTime() %>" /> <%}else{ %> <input type="text"
			size=8 id="toTime<%=inc%>" name="<%=TOTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>

	<%-- 	<td>
		<%if(appSetup.getSlotDuration()!=null){ %> <input type="text" size=8
			id="slotDuration<%=inc%>" name="<%=SLOTTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			MAXLENGTH="8" value="<%=appSetup.getSlotDuration() %>" /> <%}else{ %>
		<input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			MAXLENGTH="8" id="slotTime" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getPercentageForSlots()!=null && appSetup.getPercentageForSlots()!=0){ %>
		<input type="text" size=8 id="percentageForSlots<%=inc%>"
			name="<%=PERCENTAGE%>" MAXLENGTH="2"
			value="<%=appSetup.getPercentageForSlots() %>"
			validate="Percentage,num,no" /> <%}else{ %> <input type="text" size=8
			id="percentageForSlots<%=inc%>" name="<%=PERCENTAGE%>" MAXLENGTH="2"
			validate="Percentage,num,no" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getBreakFromTime()!=null){ %> <input type="text" size=8
			id="breakFromTime<%=inc%>" name="<%=BREAKFROMTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakFromTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getBreakToTime()!=null){ %> <input type="text" size=8
			id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakToTime() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime<%=inc%>" name="<%=BREAKTOTIME%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>
		
		<td>
		<%if(appSetup.getBreakFromTime2()!=null){ %> <input type="text" size=8
			id="breakFromTime2<%=inc%>" name="<%=BREAKFROMTIME2%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakFromTime2() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime2<%=inc%>"
			name="<%=BREAKFROMTIME2%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>
		<td>
		<%if(appSetup.getBreakToTime2()!=null){ %> <input type="text" size=8
			id="breakToTime2<%=inc%>" name="<%=BREAKTOTIME2%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakToTime2() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime2<%=inc%>" name="<%=BREAKTOTIME2%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td> --%>
		<td>
		<%if(appSetup.getBreakFromTime3()!=null){ %> <input type="text" size=8
			id="breakFromTime3<%=inc%>" name="<%=BREAKFROMTIME3%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakFromTime3() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakFromTime3<%=inc%>"
			name="<%=BREAKFROMTIME3%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>
		<td>
		<%if(appSetup.getBreakToTime3()!=null){ %> <input type="text" size=8
			id="breakToTime3<%=inc%>" name="<%=BREAKTOTIME3%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8"
			value="<%=appSetup.getBreakToTime3() %>" /> <%}else{ %> <input
			type="text" size=8 id="breakToTime3<%=inc%>" name="<%=BREAKTOTIME3%>"
			onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /> <%}%>
		</td>
		

		<td>
		<%if(appSetup.getMaxNoOfDays()!=null && appSetup.getMaxNoOfDays()!=0){ %>
		<input type="text" size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>"
			MAXLENGTH="2" value="<%=appSetup.getMaxNoOfDays() %>"
			validate="Max. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="maxDays<%=inc%>" name="<%=MAXDAYS%>" MAXLENGTH="2"
			validate="Max. no. of Days,num,no" /> <%}%>
		</td>

		<td>
		<%if(appSetup.getMinNoOfDays()!=null && appSetup.getMinNoOfDays()!=0){ %>
		<input type="text" size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>"
			MAXLENGTH="2" value="<%=appSetup.getMinNoOfDays() %>"
			validate="Min. no. of Days,num,no" /> <%}else{ %> <input type="text"
			size=8 id="minDays<%=inc%>" name="<%=MINDAYS%>" MAXLENGTH="2"
			validate="Min. no. of Days,num,no" /> <%}%>
		</td>

	</tr>

	<%	inc++;
   		}
    	 int j;
    		inc=7-appSetupList.size();
    		for(j=0;j<inc;j++){
    	    	%>

	<tr>
		<input type="hidden" name="<%=DAYS%>" value="<%=day[j]%>" />
		<td class="colHeader"><%=day[j]%></td>
		<td><input type="text" size=8 id="dr<%=inc%>" name="<%=DR%>"
			MAXLENGTH="3" /></td>
		<td><input type="text" size=8 id="fromTime<%=inc%>"
			name="<%=FROMTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="toTime<%=inc%>"
			name="<%=TOTIME %>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="slotDuration<%=inc%>"
			name="<%=SLOTTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSlotDuration(this.value,this.id);"
			MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="percentage<%=inc%>"
			name="<%=PERCENTAGE%>" MAXLENGTH="2" /></td>
		<td><input type="text" size=8 id="breakFromTime<%=inc%>"
			name="<%=BREAKFROMTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="breakToTime<%=inc%>"
			name="<%=BREAKTOTIME%>" onKeyUp="mask(this.value,this,'2,5',':');"
			onBlur="8IsValidTimeForSetup(this.value,this.id);" MAXLENGTH="8" /></td>
		<td><input type="text" size=8 id="maxDays<%=inc%>"
			name="<%=MAXDAYS%>" MAXLENGTH="2" /></td>
		<td><input type="text" size=8 id="minDays<%=inc%>"
			name="<%=MINDAYS%>" MAXLENGTH="2" /></td>
	</tr>

	<%	}


      }
   %>
   <input  type="hidden" value="<%=inc%>" name="totalRow" id="totalRowId"/>
   
</table>
