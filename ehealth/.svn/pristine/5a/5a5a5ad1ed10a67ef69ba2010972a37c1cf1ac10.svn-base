<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * nursingCareEntry.jsp
 * Purpose of the JSP -  This is for Nursing Care Entry.
 * @author  Vikas
 * @author  Deepali
 * Create Date: 20th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="jkt.hms.masters.business.MasHouseKeepingFrequency"%>
<%@page import="jkt.hms.masters.business.HouseKeepingService"%>
<%@page import="jkt.hms.masters.business.IpdCareDetails"%>
<%@page import="jkt.hms.masters.business.HouseKeepingSetup"%>
<%@page import="net.sf.jasperreports.engine.util.MaxFontSizeFinder"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date2=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date2.length()<2){
			date2="0"+date2;
		}
			
	%>
		serverdate = '<%=date2+"/"+month+"/"+year%>'
</script>

<%
int maxNursingFrequency=0;
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String timeInHHmm="";
	String [] temp = null;
	temp = time.split(":");
	for (int i = 0 ; i < temp.length-1 ; i++) {

		timeInHHmm=timeInHHmm+(String)temp[i];
    	 if(i==0)
    	 {
    		 timeInHHmm=timeInHHmm+":";
    	 }
	}
	List<HouseKeepingSetup> houseKeepingSetupList = new ArrayList<HouseKeepingSetup>();
	List<HouseKeepingService> ipdCareDetails = new ArrayList<HouseKeepingService>();

	int maxHousekeepingFrequency = 0;
		if(map.get("houseKeepingSetupList") != null)
		{
			houseKeepingSetupList=(List)map.get("houseKeepingSetupList");
		}
		if(map.get("ipdCareDetails") != null)
		{
			ipdCareDetails=(List)map.get("ipdCareDetails");
		}
	if(map.get("maxHousekeepingFrequency") != null)
	{
		maxHousekeepingFrequency=(Integer)map.get("maxHousekeepingFrequency");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	if(message!=null && !message.equals("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg">
<h2>House Keeping Entry</h2>
</div>
<div class="clear"></div>
<form name="houseKeepingEntryDetail" action="" method="post">
<div class="Block">


<div class="paddingTop25"></div>
<div class="clear"></div>
<div id="test">

<label>Date</label>
<input class="date" name="caredate" id="caredate" value="<%=date2+"/"+month+"/"+year%>" readonly="readonly"/>
<!-- <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes" id="imgId" onclick="javascript:setdate('28/03/2015',document.houseKeepingEntryDetail.caredate,event)"  > --> 

<div class="clear"></div>
<div class="paddingTop25"></div>
<%
		    int  i=1;
			int j=1;
%>

<%!


public  List<HouseKeepingService> houseKeepingSevice(List<HouseKeepingService> careDetails,int setupId)
{
	List<HouseKeepingService> careDetails2=new ArrayList<HouseKeepingService>();
	if(careDetails!=null)
	{
		for (HouseKeepingService careDetail : careDetails) {
			MasHouseKeepingFrequency frequency=careDetail.getHouseKeepingSetup().getHouseKeepingFrequency();
			Map<String,Object> utilMap = new HashMap<String,Object>();
			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
			String date = (String)utilMap.get("currentDate");
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(HMSUtil.convertStringTypeDateToDateType(date));
			calendar.add(Calendar.DAY_OF_MONTH, (-1)*frequency.getFrequencyCount());
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
		     calendar.set(Calendar.SECOND, 0);			
			if(careDetail.getServiceDate().after(calendar.getTime()) && careDetail.getHouseKeepingSetup().getId()==setupId)
			{
				careDetails2.add(careDetail);
			}
		}
	}
	return careDetails2;
	
} 
%>
<table class="cmntable">
<tr>
<th>
Activity
</th>
<!-- <th>Time</th> -->
<%
while(j<=maxHousekeepingFrequency)
{
	%>
	<th>
<%=j %>
</th>	
	<%
j++;	
} %>
<th>
Remarks
</th>
</tr>

<%

			String st="";
			Iterator iterator=houseKeepingSetupList.iterator();
		          while(iterator.hasNext())
		           {
		        	  j=1;
		        	  HouseKeepingSetup houseKeepingSetup= (HouseKeepingSetup) iterator.next();
		        	  List<HouseKeepingService> localCareDetails=new ArrayList<HouseKeepingService>();
		        	  localCareDetails=houseKeepingSevice(ipdCareDetails, houseKeepingSetup.getId());
		        	  int frequency=houseKeepingSetup.getFrequency().getFrequencyCount().intValue();
		        	  %>
		        	  <tr>
		        	<%
		        	  if(localCareDetails.size()>0)
		        	  {
		        		  HouseKeepingService careHeader=null;
					%>
					
					<td>
			<input type="hidden" name="activity<%=i%>" id="activity<%=i%>" value="<%=houseKeepingSetup.getId()%>" />
			<%=houseKeepingSetup.getHouseKeeping().getHouseKeepingName()%>
			</td>
					<%
					for(HouseKeepingService ipdCareDetail:localCareDetails)
						{
						careHeader=ipdCareDetail;
						%>
						<td>
						<input type="checkbox" class="radiogrid" name="care<%=i%>" value="<%=j %>" disabled="disabled"  checked="true" DISABLED  id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=careHeader.getServiceTime()%>" MAXLENGTH="5"  />
						</td>
						<%
						j++;
						} %>
						<%
						boolean isFirstLoop=true;
while(j<=maxHousekeepingFrequency)
{
	if(isFirstLoop && j<=houseKeepingSetup.getFrequency().getFrequencyCount().intValue())
	{
		isFirstLoop=false;
	%>
					<td> 
					<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdcaredetailId<%=i%>" /> 
					<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="<%=j %>" id="care<%=i%>" />					
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="00.00" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>  <input type="checkbox" class="radiogrid" name="care<%=i%>" disabled="disabled"  value="<%=j%>" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="" MAXLENGTH="5"  /></td>
	<%}
	j++;	
	} %>
	
	<%
while(j<=maxNursingFrequency)
{
	
	%>
					<td>&nbsp;</td>

	<%j++;	
	} %>
		
		<%
	        		   if(careHeader.getRemarks() != null)
	        		    {
	        		   %>
	        		   <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="<%=careHeader.getRemarks()%>" size="20"  style=" border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }else{
	        		   %>
	        		   <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }
	        		    %>
		<%}else
			{%>
			<td>
			<input type="hidden" name="activity<%=i%>" id="activity<%=i%>" value="<%=houseKeepingSetup.getId()%>" />
			<%=houseKeepingSetup.getHouseKeeping().getHouseKeepingName()%>
			</td>
			<%
while(j<=houseKeepingSetup.getFrequency().getFrequencyCount().intValue())
{
	if(j==1)
	{
	%>
					<td>  <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="<%=j %>" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="00:00" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>  <input type="checkbox" class="radiogrid" name="care<%=i%>" disabled="disabled"   value="<%=j%>" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="" MAXLENGTH="5"  /></td>
	<%}
	j++;	
	} %>
	
	<%
while(j<=maxNursingFrequency)
{
	
	%>
					<td>&nbsp;</td>

	<%j++;	
	} %>
	
	
				        		   <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
			
			 <%
			}%> 
			 			
	        		  
		</tr>
		<%i++;} %>

</table>
</div>


<input type="hidden" name="counter" id="counter" value="<%=--i %>" />

<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>



</div>
<input type="button" class="button" value="Submit " align="left" onClick="submitNursingCareEntryForm();" />
<input type="reset" class="button" value="Reset " align="left"
	onClick="" />

<div class="paddingTop25"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


</div>
<div class="clear"></div>
<div id="testDiv"></div>
<div class="clear"></div>

<script type="text/javascript">

function submitNursingCareEntryForm()
{
	validateForNursingCareEntry(); 
	submitForm('houseKeepingEntryDetail','ipd?method=submitHouseKeepingDetails');
}

function checkTimeFormat(){

	var chtime=document.getElementById("caretime").value
 	if(chtime==""){
		alert('Changed Time  can not be blank')
		return false
	}
	 if(chtime!= ""){
	 			var index=chtime.indexOf(':');
				if(!validateInteger(trimAll(chtime)))
				{
					alert(" Time should be a number(without spaces) without special Characters in HH:MM Format.");
					return false
				}
				if(index == -1)
				  alert("Please Enter The Time in Correct Format.")
		 //var indx = chtime.indexOf(':');

		 if (index != -1) {
		 var pairs2 = chtime.substring(0,chtime.length).split(':');
		 }

		 if (pairs2.length!=2) {
			 alert("Invalid Time Format.It should be HH:MM")
			return false;
			}
		 if (pairs2[0].length != 2 || pairs2[1].length != 2 ) {
				  alert("Invalid Time Format.It should be HH:MM")
				  return false;
				}
		 		 val2=eval(pairs2[0]);

						  if (val2<0 || val2>23) {
							  alert("Hours should 00-23")
					 		 return false;}

					 		 val3=eval(pairs2[1]);

							  if (val3<0 || val3>59) {
							  alert("Min should 00-59")
					 		 return false;}
		return true;
	}
	}
	function validate(ref)
	{
	 if (this.focus)
	 {
	  this.focus();
	 }
	 alert('test');
	 return false;
	}
function validateInteger( strValue ) {
  var objRegExp  =/^((\+|-)\d)?\d*(\:\d{2})?$/;
 	return objRegExp.test(strValue);
}

/*
 method for validating remarks field in nursingEntry Detail screen.
 not developed yet
*/
/* function validateRemarksForNursing(){

		//alert("haloooo")
		var counter=document.getElementById("counter").value;
		for(var i = 0; i < counter; i++)
		{

		var careRemarks=document.getElementById('careremarks'+i).value
		var careRemarksFromDB=document.getElementById('careRemarksFromDB'+i).value
		if(!(careRemarksFromDB == "empty"))
		{
		  alert("In if block when remarks are not empty")
			if(!(careRemarks == careRemarksFromDB))
			{
				alert("in loop comparing remarks field.")
					var bool="false"
					for(var j=0;j<document.getElementsByName('care'+i).length;j++)
					{
						var care=document.getElementsByName('care'+i)[j].checked
						if(care == true)
						{
						 bool="true"
						}
						else
						{
						  bool="false"
						}
						if(bool== "false")
						{
							alert("Please select the Frequency For remarks to be submitted. ")
							return false;
						}

					}
		    }
  		 }
	   }
	   return false;
		} */
		
function validateForNursingCareEntry(){
	var counter=document.getElementById("counter").value;
	for(var i = 1; i <=counter; i++)
	{
	     if(document.getElementById("care1").checked)
	    	 {
	    	 document.getElementById("caretime"+i).setAttribute("validate", "Care Time,time,yes");
	    	 }
	     else
	    	 {
	    	 document.getElementById("caretime"+i).setAttribute("validate", "Care Time,time,no");
	    	 }
	}
}
</script>
