
<%@page import="java.util.Date"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreTemperatureMonitoringT"%>
<%@page import="jkt.hms.masters.business.StoreRefrigeratorAllocation"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

	<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
		
		</script>
	

<%
	Map<String,Object> map = new HashMap<String,Object>();
	Box box = HMSUtil.getBox(request);
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
		}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	List<MasHospital> hospitalList = new ArrayList<MasHospital>();
	List<Object[]> refrigeratorAllocationList = new ArrayList<Object[]>();
	List<StoreTemperatureMonitoringT> temperatureMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
	List<StoreTemperatureMonitoringT> tempMonlist = new ArrayList<StoreTemperatureMonitoringT>();
	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	if(map.get("districtList") != null){
		districtList = (List)map.get("districtList");
	}
	if(map.get("hospitalTypeList") != null){
		hospitalTypeList = (List)map.get("hospitalTypeList");
	}
	if(map.get("hospitalList") != null){
		hospitalList = (List)map.get("hospitalList");
	}
	if(map.get("refrigeratorAllocationList") != null){
		refrigeratorAllocationList = (List)map.get("refrigeratorAllocationList");
	}
	if(map.get("temperatureMonitoringTList") != null){
		temperatureMonitoringTList = (List)map.get("temperatureMonitoringTList");
	}
	if(map.get("tempMonlist") != null){
		tempMonlist = (List)map.get("tempMonlist");
	}
	System.out.println("tempMonlist=="+tempMonlist.size());
	
	/* List<Object[]> tempMonlist=new ArrayList<Object[]>();
	
	if(map.get("tempMonlist") != null){
		tempMonlist = (List<Object[]>)map.get("tempMonlist");
	} */
%>


<div class="titleBg">
<h2>Dash Board of Temperature Monitoring</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="dashBoardOfTemperatureMonitoring" method="post">
<div class="clear"></div>
<label>From Date </label>
<input type="text" name="fromDate"	value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 validate="fromDate,date,no" />
<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.dashBoardOfTemperatureMonitoring.<%= FROM_DATE%>,event);" />
<label>To Date </label>
<input type="text" name="toDate" value="<%= currentDate %>" class="date" maxlength="30" tabindex=1 validate="toDate,date,no"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.dashBoardOfTemperatureMonitoring.<%= TO_DATE%>,true);" />

<label>District</label>
<select name="district"  id="districtId" >
<option value="0">Select </option>
<%
	if(districtList.size()>0){
		for(MasDistrict masDistrict:districtList){
			
		
%>
<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName() %></option>
<%}} %>
</select>

<div class="clear"></div>
<label>Institute Type</label>
<select name="instituteType"  id="instituteType"  >
<option value="0">Select </option>
<%
	if(hospitalTypeList.size()>0){
		for(MasHospitalType hospitalType:hospitalTypeList){
			
		
%>
<option value="<%=hospitalType.getId()%>"><%=hospitalType.getHospitalTypeName()%></option>
<%}} %>
</select>
<label>Institute</label>
<select name="hospital"  id="hospitalId"  >
<option value="0">Select </option>
<%
	if(hospitalList.size()>0){
		for(MasHospital masHospital:hospitalList){
			
		
%>
<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
<%}} %>
</select>


<div class="clear"></div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('dashBoardOfTemperatureMonitoring','coldChain?method=searchForTemperatureMonitoringDashBord');" />
 
</div>
 
<div class="clear"></div>
 
<%-- <input type="button" name="print" type="submit" class="button"value="Print" onClick="showReport('departmentIndent');">--%>
 
<div class="clear"></div>

<div class="paddingTtop15"></div>
<div class="clear"></div>
 
<table border="0" cellpadding="0" cellspacing="0">

					<tr>
						<th>Date</th>
						<th>Ref/CR</th>
						<%-- <%
			int k = 1;
						if(refrigeratorAllocationList.size()>0){
							for(StoreRefrigeratorAllocation refrigeratorAllocation :refrigeratorAllocationList){
								 %>
			<th colspan="2">Records<%=k %></th>
			
			<%k++;}} %> --%>
			<th colspan="2">Records1</th>
			<th colspan="2">Records2</th>
			<th colspan="2">Records3</th>
			<th colspan="2">Records4</th>
				
		</tr>
		<tr>		
		<th></th>
			
			
			<th></th>
			<th>Time1</th>
			<th>Temp1</th>
			<th>Time2</th>
			<th>Temp2</th>
			<th>Time3</th>
			<th>Temp3</th>
			<th>Time4</th>
			<th>Temp4</th>
			<%-- <%
			int j = 1;
			if(tempMonlist.size()>0){
				for(Object[] arr : tempMonlist){ %>
			<th>Time<%=j %></th>
			<th>Temp<%=j %></th>
			<%j++;}} %> --%>
			 
		</tr>
		<%
		int i = 1;	
		
if(refrigeratorAllocationList.size()>0){
	System.out.println("refrigeratorAllocationList=="+refrigeratorAllocationList.size());
				for(Object[] refrigeratorAllocation :refrigeratorAllocationList){
		
		%>
		<tr>
		<td> <%=HMSUtil.convertDateToStringWithoutTime((Date)refrigeratorAllocation[3]) %> </td>
		<td>
			<input type="text" name="refrigeratorNo" size="20" value="<%=refrigeratorAllocation[1]!= null?refrigeratorAllocation[1]:"" %>" size="5"	tabindex=1   id="refrigeratorNo"  />
			<input type="hidden" name="refrigeratorId<%=i %>" value="<%=refrigeratorAllocation[0] != null?refrigeratorAllocation[0]:"" %>" size="5"	tabindex=1   id="refrigeratorId"  />
			
			</td>
		<%			
		int count=0;
		//for(int k=1;k<=4;k++){
				if(tempMonlist.size()>0){
					int k=0;
					for(StoreTemperatureMonitoringT temperatureMonitoringT : tempMonlist){
						BigDecimal temp1 = new BigDecimal(0);
						String time1 = "";
						//System.out.println("111=="+(temperatureMonitoringT.getMonitoringM().getRefrigerator().getId()==Integer.parseInt(refrigeratorAllocation[0].toString())));
						 if((temperatureMonitoringT.getMonitoringM().getRefrigerator().getId()==Integer.parseInt(refrigeratorAllocation[0].toString()))){
							 //if((temperatureMonitoringT.getMonitoringM().getRefBatchNo().equals(refrigeratorAllocation[2].toString()))){

							k++;
						
							 if(temperatureMonitoringT.getMonitoringTime()   != null){
								time1 = (String)temperatureMonitoringT.getMonitoringTime();
							}
							if(temperatureMonitoringT.getTemperature()   !=null){
								temp1 = (BigDecimal)temperatureMonitoringT.getTemperature() ;
							}
							 }
						//}
				
					if(!time1.equals(""))		{					
			%>
			
			<td>
			<input type="text" name="time1" value="<%=time1!= null?time1:"" %>" size="3"	tabindex=1  readonly="readonly" id="time1"  />
			</td>
			<%}
					
			if(temp1.compareTo(new BigDecimal(0))>0) {%>
			<td>
			<input type="text" name="temp1" value="<%=temp1!= null?temp1.intValue():"" %>" size="3"	tabindex=1  readonly="readonly" id="temp1" />
			</td>
			<%}
						
					}
					
					if(k<4){
					for(int j=k;j<4;j++){
						%>
						<td>
			<input type="text" name="time1" value="" size="3"	tabindex=1  readonly="readonly" id="time1"  />
			</td>
			<td>
			<input type="text" name="temp1" value="" size="3"	tabindex=1  readonly="readonly" id="temp1"  />
			</td>
				<%}
					}
				}
				
					//} %>
		 
				<% }} %>		
		</tr>
				
			</table>

 
<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 