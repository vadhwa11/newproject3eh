<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.StoreTemperatureMonitoringT"%>
<%@page import="jkt.hms.masters.business.StoreRefrigeratorAllocation"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script language="javascript"  type="text/javascript" src="/hms/jsp/js/hms.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();

	if(map.get("refrigeratorAllocationList") != null){
		refrigeratorAllocationList = (List<StoreRefrigeratorAllocation>)map.get("refrigeratorAllocationList");
	}
	List<StoreTemperatureMonitoringT>tempMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
	if(map.get("tempMonitoringTList") != null){
		tempMonitoringTList = (List<StoreTemperatureMonitoringT>)map.get("tempMonitoringTList");
	}
	System.out.println("tempMonitoringTList=="+tempMonitoringTList.size());
	System.out.println("refrigeratorAllocationList=="+refrigeratorAllocationList.size());
	
	%>

<div class="titleBg">
<h2>Temperature Monitoring</h2>
</div>
<div class="clear"></div>


<div class="clear"></div>
<form name="temperatureMonitoring" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="Block">
<label>Date</label>
<input type="text" name="monitoringDate" value="<%=currentDate %>" readonly="readonly" class="date"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=currentDate%>',document.temperatureMonitoring.monitoringDate,event)" />

<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('temperatureMonitoring','coldChain?method=showTemperatureMonitoringJsp');" />
	</div>
<%-- 
<div class="Block">
<label>From Date</label>
<input type="text" name="<%=FROM_DATE %>" value="<%=currentDate %>" readonly="readonly" class="date"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.annualIndentAdminSetUp.<%= FROM_DATE%>,event)" />
	

<label>To Date</label>
<input type="text" name="<%=TO_DATE %>" value="<%=currentDate %>" readonly="readonly" class="date"  />
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.annualIndentAdminSetUp.<%= TO_DATE%>,event)" />
	<div class="clear"></div>

<label>District  </label> 
<select name="district" validate="Financial Year,string,yes">
<option value="0">Select</option>

</select>

<label>Institute Type </label> 
<select name="district" validate="Financial Year,string,yes">
<option value="0">Select</option>

</select>

<label>Institute Name </label> 
<select name="district" validate="Financial Year,string,yes">
<option value="0">Select</option>

</select>



</div>
--%>
	<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="cmntable">
<form name="submitForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
		<tr>
			<th>Referigerator/CR</th>
			<th>Stored Qty</th>
			<!-- <th>Ref. Min Temp(°C)</th>
			<th>Ref. Max Temp(°C)</th> -->
			<th colspan="2">Records1</th>
			<th colspan="2">Records2</th>
			<th colspan="2">Records3</th>
			<th colspan="2">Records4</th>
			<th>Potency</th>
			<th>Transfer</th>
			 <th>Stock</th> 
			
		</tr>
		
		<tr>

			<!-- <th></th>
			 <th></th> -->
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
			 <th></th>
			<th></th>
			 <th></th> 
			
			
			
		</tr>
		
		
		<%
		int i = 0;
		
		if(tempMonitoringTList.size()>0){
		if(refrigeratorAllocationList.size()>0){
			for(StoreRefrigeratorAllocation refrigeratorAllocation : refrigeratorAllocationList){
		
		
		%>
		<tr>
			
			
			<td>
			<input type="text"  readonly="readonly" name="refrigeratorNo" value="<%=refrigeratorAllocation.getRefrigeratorNo() != null ? refrigeratorAllocation.getRefrigeratorNo().getNomenclature():""+"-"+refrigeratorAllocation.getRefBatchNo() != null?refrigeratorAllocation.getRefBatchNo():"" %>" size="20"	tabindex=1   id="refrigeratorNo<%=i %>" />
			<input type="hidden" name="refrigeratorId" value="<%=refrigeratorAllocation.getRefrigeratorNo() != null ? refrigeratorAllocation.getRefrigeratorNo().getId():"" %>" size="8"	tabindex=1   id="refrigeratorId<%=i %>" />
			<input type="hidden" name="maxTime" value="<%=refrigeratorAllocation.getItem().getTempratureMax() != null ? refrigeratorAllocation.getItem().getTempratureMax().intValue():"" %>" size="8"	tabindex=1   id="maxTime<%=i %>" />
			<input type="hidden" name="refBatchNo" value="<%=refrigeratorAllocation.getRefBatchNo() != null ? refrigeratorAllocation.getRefBatchNo():"" %>" size="8"	tabindex=1   id="maxTime<%=i %>" />
			
			</td>
		
			<td>
			<input type="hidden" name="refrigeratorAllocationId" value="<%=refrigeratorAllocation.getId()!= null?refrigeratorAllocation.getId():"" %>" />
			<input type="text" name="storedQty" value="<%=refrigeratorAllocation.getStoredQty()!= null?refrigeratorAllocation.getStoredQty().intValue():"" %>" size="5"	 readonly="readonly" tabindex=1   id="storedQty<%=i %>" />
			</td>
			
			<%-- 	<td>
			<input type="text" name="minTemperature" value="<%=refrigeratorAllocation.getMaxTemp()!= null?refrigeratorAllocation.getMinTemp().intValue():""%>" size="5"	  tabindex=1   id="maxTemperature<%=i %>" />
			</td>
			
				<td>
			<input type="text" name="maxTemperature" value="<%=refrigeratorAllocation.getMinTemp()!= null?refrigeratorAllocation.getMaxTemp().intValue():""%>" size="5"	  tabindex=1   id="maxTemperature<%=i %>" />
			</td> --%>
		<%-- 	<td>
			<input type="text" name="timeA" value="" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"  size="5"	tabindex=1  onkeydown="validateTime(this.value); " id="timeA<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempA" value="" size="5"	tabindex=1   id="tempA<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeB" value="" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"  size="5" 	tabindex=1   id="timeB<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempB" value="" size="5"	tabindex=1   id="tempB<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeC" value="" size="5" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"	tabindex=1   id="timeC<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempC" value="" size="5"	tabindex=1   id="tempC<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeD" value="" size="5" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"	tabindex=1  id="timeD<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempD" value="" size="5"	tabindex=1   id="tempD<%=i %>" />
			</td> --%>
			
			<%			
		int count=0;
			int storeTempMontoringMId = 0;
		//for(int k=1;k<=4;k++){
				if(tempMonitoringTList.size()>0){
					int k=0;
					for(StoreTemperatureMonitoringT temperatureMonitoringT : tempMonitoringTList){
						BigDecimal temp1 = new BigDecimal(0);
						String time1 = "";
						 if((temperatureMonitoringT.getMonitoringM().getRefrigerator().getId()==refrigeratorAllocation.getRefrigeratorNo().getId())){
							 if((temperatureMonitoringT.getMonitoringM().getRefBatchNo().equals(refrigeratorAllocation.getRefBatchNo()))){

							k++;
						
							 if(temperatureMonitoringT.getMonitoringTime()   != null){
								time1 = (String)temperatureMonitoringT.getMonitoringTime();
							}
							if(temperatureMonitoringT.getTemperature()   !=null){
								temp1 = (BigDecimal)temperatureMonitoringT.getTemperature() ;
							}
							 }
							 storeTempMontoringMId = temperatureMonitoringT.getMonitoringM().getId();
						}
				
									
			%>
			<% if(!time1.equals("")){	%>
			<td>
			<input type="text" name="time1" value="<%=time1!= null?time1:"" %>" size="3"	tabindex=1  readonly="readonly" id="time1"  />
			<input type="text" name="storeTempMontoringMId<%=i %>" value="<%=storeTempMontoringMId!= 0?storeTempMontoringMId:"" %>" size="3"	tabindex=1  readonly="readonly" id="storeTempMontoringMId<%=i %>"  />
			
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
		 
			
			<td>
			
			<input type="checkbox" class="radioCheck" name="potency<%=i %>" value="y" 	tabindex=1   id="potency<%=i %>" />
			</td>
			<td>
			<input type="checkbox" name="transfer<%=i %>" class="radioCheck"  value="t" 	tabindex=1   id="transfer<%=i %>" />
			</td> 
			
			 <td><a href="javascript:openPopupWindow('<%=refrigeratorAllocation.getItem().getId()%>','<%=refrigeratorAllocation.getDepartment().getId()%>','<%=refrigeratorAllocation.getHospital().getId()%>','<%=refrigeratorAllocation.getRefrigeratorNo().getId()%>','<%=refrigeratorAllocation.getRefBatchNo()%>');">Stock</a>
			</td> 
			<%i++;}} %>
		</tr>
		<%}else{ 
			System.out.println("refrigeratorAllocationList=="+refrigeratorAllocationList.size());
		if(refrigeratorAllocationList.size()>0){
			for(StoreRefrigeratorAllocation refrigeratorAllocation : refrigeratorAllocationList){
		
		
		%>
		<tr>
			
			
			<td>
			<input type="text"  readonly="readonly" name="refrigeratorNo" value="<%=refrigeratorAllocation.getRefrigeratorNo() != null ? refrigeratorAllocation.getRefrigeratorNo().getNomenclature():""+"-"+refrigeratorAllocation.getRefBatchNo() != null?refrigeratorAllocation.getRefBatchNo():"" %>" size="20"	tabindex=1   id="refrigeratorNo<%=i %>" />
			<input type="hidden" name="refrigeratorId" value="<%=refrigeratorAllocation.getRefrigeratorNo() != null ? refrigeratorAllocation.getRefrigeratorNo().getId():"" %>" size="8"	tabindex=1   id="refrigeratorId<%=i %>" />
			<input type="hidden" name="maxTime" value="<%=refrigeratorAllocation.getItem().getTempratureMax() != null ? refrigeratorAllocation.getItem().getTempratureMax().intValue():"" %>" size="8"	tabindex=1   id="maxTime<%=i %>" />
			<input type="hidden" name="refBatchNo" value="<%=refrigeratorAllocation.getRefBatchNo() != null ? refrigeratorAllocation.getRefBatchNo():"" %>" size="8"	tabindex=1   id="maxTime<%=i %>" />
			
			</td>
		
			<td>
			<input type="hidden" name="refrigeratorAllocationId" value="<%=refrigeratorAllocation.getId()!= null?refrigeratorAllocation.getId():"" %>" />
			<input type="text" name="storedQty" value="<%=refrigeratorAllocation.getStoredQty()!= null?refrigeratorAllocation.getStoredQty().intValue():"" %>" size="5"	 readonly="readonly" tabindex=1   id="storedQty<%=i %>" />
			</td>
			
			<%-- 	<td>
			<input type="text" name="minTemperature" value="<%=refrigeratorAllocation.getMaxTemp()!= null?refrigeratorAllocation.getMinTemp().intValue():""%>" size="5"	  tabindex=1   id="maxTemperature<%=i %>" />
			</td>
			
				<td>
			<input type="text" name="maxTemperature" value="<%=refrigeratorAllocation.getMinTemp()!= null?refrigeratorAllocation.getMaxTemp().intValue():""%>" size="5"	  tabindex=1   id="maxTemperature<%=i %>" />
			</td> --%>
			<td>
			<input type="text" name="timeA" value="" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"  size="5"	tabindex=1  onkeydown="validateTime(this.value); " id="timeA<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempA" value="" size="5"	tabindex=1   id="tempA<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeB" value="" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"  size="5" 	tabindex=1   id="timeB<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempB" value="" size="5"	tabindex=1   id="tempB<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeC" value="" size="5" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"	tabindex=1   id="timeC<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempC" value="" size="5"	tabindex=1   id="tempC<%=i %>" />
			</td>
			<td>
			<input type="text" name="timeD" value="" size="5" onKeyUp="mask(this.value,this,'2',':');" maxlength="5"	tabindex=1  id="timeD<%=i %>" />
			</td>
			<td>
			<input type="text" name="tempD" value="" size="5"	tabindex=1   id="tempD<%=i %>" />
			</td>
			
			<td>
			<input type="checkbox" class="radioCheck" name="potency<%=i %>" value="y" 	tabindex=1   id="potency<%=i %>" />
			</td>
			<td>
			<input type="checkbox" name="transfer<%=i %>" class="radioCheck"  value="t" 	tabindex=1   id="transfer<%=i %>" />
			</td> 
			
			 <td><a href="javascript:openPopupWindow('<%=refrigeratorAllocation.getItem().getId()%>','<%=refrigeratorAllocation.getDepartment().getId()%>','<%=refrigeratorAllocation.getHospital().getId()%>','<%=refrigeratorAllocation.getRefrigeratorNo().getId()%>','<%=refrigeratorAllocation.getRefBatchNo()%>');">Stock</a>
			</td> 
			<%i++;}} %>
		</tr>
		<%} %>
</table>
</div>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="paddingTop15"></div>
<%if(tempMonitoringTList.size()>0){ %>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('temperatureMonitoring','coldChain?method=submitTemperatureMonitoring');" />
<%}else{ %>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('temperatureMonitoring','coldChain?method=submitTemperatureMonitoring','validateTemp');" />

<%} %>
<input name="button"  type="reset"	value="Reset" class="button"	onclick=""; />
</form>
<div class="clear"></div>
<script type="text/javascript">
function validateTemp(){
	//alert("sdfdsf=="+document.getElementById('hdb').value);
	var count = document.getElementById('hdb').value;	
	for (i = 0; i < count; i++){
	//alert("max time=="+document.getElementById('maxTime'+i).value);	
	//alert("tempA=="+document.getElementById('tempA'+i).value);	
	//alert("tempB=="+document.getElementById('tempB'+i).value);	
	//alert("tempC=="+document.getElementById('tempC'+i).value);	
	//alert("tempD=="+document.getElementById('tempD'+i).value);	
		var maxTime = document.getElementById('maxTime'+i).value;
		var tempA = document.getElementById('tempA'+i).value;
		var tempB = document.getElementById('tempB'+i).value;
		var tempC = document.getElementById('tempC'+i).value;
		var tempD = document.getElementById('tempD'+i).value;
		//if(tempA != "" && tempB != "" && tempC != "" && tempD != "" && maxTime != ""){
			//alert("condition==="+tempA>maxTime)
			if(parseInt(tempA)>parseInt(maxTime) || parseInt(tempB)>parseInt(maxTime) || parseInt(tempC)>parseInt(maxTime) || parseInt(tempD)>parseInt(maxTime)){
				
				if(confirm("Temperature Exceeded"))
					return true;
				else
					return false;
				
			}
		//}
	
	}	
			return true;
}



function openPopupWindow(itemId,deptId,hospitalId,refrigeratorId,refBatchNo)
{
 var url="/hms/hms/coldChain?method=showRefrigeratorAllocationPopup&itemId="+itemId+"&deptId="+deptId+"&hospitalId="+hospitalId+"&refrigeratorId="+refrigeratorId+"&refBatchNo="+refBatchNo;
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	
}
function validateTime(s) {
	  
	  var t = s.split(':');
	  return /^\d\d:\d\d$/.submitForm(s) &&
	         t[0] >= 0 && t[0] < 25 &&
	         t[1] >= 0 && t[1] < 60;
	           
	}

</script>

</form>