<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hospital.jsp  
 * Purpose of the JSP -  This is for All Hospital Master.
 * @author  Mansi
 * Create Date: 04 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.LocationParameterMapping"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.PhMasElectricalSection"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript">

/***********************************************
* Textarea Maxlength script- © Dynamic Drive (www.dynamicdrive.com)
* This notice must stay intact for legal use.
* Visit http://www.dynamicdrive.com/ for full source code
***********************************************/

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

</script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime"); 
List<LocationParameterMapping> locationParameterMapping=new ArrayList<LocationParameterMapping>(); 
locationParameterMapping=(List<LocationParameterMapping>)map.get("locationParameterList");
MasHospital masHospital=(MasHospital)map.get("masHospital");
String hospitalName="";
if(masHospital!=null){
	hospitalName=masHospital.getHospitalName();
}
Set<PhMasLocality> localities=new HashSet<PhMasLocality>();
if(locationParameterMapping!=null && locationParameterMapping.size()>0){
	for(LocationParameterMapping locationParameterMapping2:locationParameterMapping){ 
		if(locationParameterMapping2.getLocality()!=null){
			localities.add(locationParameterMapping2.getLocality());
		}
	}
	
}
int locId=0;
if(map.get("locationId")!=null){
	 locId=(Integer)map.get("locationId");
}   
if(map.get("message") != null){
	   String message = (String)map.get("message");
	 %>
<h4><span><%=message %></span></h4>
<%}

%>
<script>
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

<!--main content placeholder starts here-->

<h2>Vector Survey</h2>
<div class="clear"></div>
<!--Block One Starts-->
<div class="Block"> 
<form name="search" method="post" action="">

<label>Institution</label> 
<input type="text" name="hospitalName" value="<%=hospitalName%>" onClick="showInsDis(this)"  readonly="readonly"  validate="Institution,string,yes"/>
  
<label>Locality</label>
<select name="location" multiple="multiple" size="10" validate="Locality,string,no" >
<option value="-1">Select</option>
<%if(localities!=null && localities.size()>0){
	for(PhMasLocality phMasLocality:localities){
	if(locId==phMasLocality.getId()){ 
	%>
		<option value="<%=phMasLocality.getId()%>" selected="selected"><%=phMasLocality.getLocalityName() %></option>
<%}else{%>
	<option value="<%=phMasLocality.getId()%>"><%=phMasLocality.getLocalityName() %></option>
	
<%}}	
} %> 
</select>

<div class="clear"></div>
<label>From Date</label>
<input type="text"	tabindex="1" name="fromDate"  value="<%=date %>" class="date"	readonly="readonly"	validate=""	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="From date,date,yes"	onclick="setdate('<%=date %>',document.search.fromDate,event)" />

<label>To Date</label>
<input type="text"	tabindex="1" name="toDate" value="<%=date %>" class="date"	readonly="readonly"		validate=""	MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="To date,date,yes"	onclick="setdate('<%=date %>',document.search.toDate,event)" />

<div class="clear"></div>
		
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','pubHealth?method=showVectorDetail')"	tabindex=1 />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<%if(map.get("houseIndex")!=null){%> 	
<label>House Index</label> 
<input type="text" name="houseIndex" value="<%=map.get("houseIndex") %> " onClick="showInsDis(this)"  readonly="readonly"/>   	
<%} %>
<%if(map.get("containerIndex")!=null){%> 	
<label>Container Index</label> 
<input type="text" name="containerIndex" value="<%=map.get("containerIndex") %>  " onClick="showInsDis(this)"  readonly="readonly"/>  	
<%} %>
<%if(map.get("breteauIndex")!=null){%> 	
<label>Breteau Index</label> 
<input type="text" name="breteauIndex" value="<%=map.get("breteauIndex") %>  " onClick="showInsDis(this)"  readonly="readonly"/>   
<%} %>
<%if(map.get("pupaeIndex")!=null){%> 	
<label>Pupae Index</label> 
<input type="text" name="pupaeIndex" value="<%=map.get("pupaeIndex") %>  " onClick="showInsDis(this)"  readonly="readonly"/>  	
<%} %> 

</div>  
   
<div class="clear"></div>  
 <div class="clear"></div> 
<div class="bottom"><label>Changed By</label> <label class="value"></label>

<label>Changed Date</label> <label class="value"><%=date%></label> 

<label>Changed Time</label> <label class="value"><%=time%></label>
 <input type="hidden"	name="<%=CHANGED_BY%>" value="admin" /> 
 <input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
 </div> 
