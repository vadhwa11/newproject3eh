<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Pain Magt.
 * @author  Awadhesh
 * Create Date: 7th Nov.,2017
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OtPostAnaesthisiaPainManagement"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<link href="/hms/jsp/css/style.css?n=1" rel="stylesheet" type="text/css" />
<form name="painManagementResource" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%

	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Patient> patientList = new ArrayList<Patient>();
	if(map.get("patientList") != null){
		patientList= (List<Patient>)map.get("patientList");
	}
	List<OtPostAnaesthisiaPainManagement> painGridList=new ArrayList<OtPostAnaesthisiaPainManagement>(); 
	int painGridSize=0;
	if(map.get("painGridList") != null){
		painGridList = (List<OtPostAnaesthisiaPainManagement>)map.get("painGridList");
		painGridSize=painGridList.size();
	}
	Patient patient=patientList.get(0);
	String patientName="";
	if(patient.getPFirstName()!= null){
		patientName=patient.getPFirstName();
		}
		if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!= null){
		patientName=patientName+" "+patient.getPLastName();
		}
	String  age=patient.getAge();	
	String gender=patient.getSex().getAdministrativeSexName();
	 %>
	
<div class="titleBg">
<h2>Periscope Reading</h2>
</div> 
<div class="clear"></div>
<div class="Block">	 
	<label>Patient Name</label><input type="text" value="<%=patientName %>"  readonly="readonly" style="height:26px;"/>
    <label>Age</label><input type="text" class="dateTextSmall" value="<%=age!=null && !age.equals("")?age:"" %>"  readonly="readonly" style="height:26px;"/>
	 <label>Gender</label><input type="text"  class="dateTextSmall" value="<%=gender %>"  readonly="readonly" style="height:26px;"/>
    <div class="clear"></div>
	
	
	<%
	if(painGridList.size()!=0){%>
	<div class="clear"></div>
	
	<input type="hidden" value="<%=painGridSize%>" name="painGridSize" id="painGridSize" tabindex=1 /> 
	<div id="nameDiv">
<table width="100%" colspan="7" id="componentDetailsForBlood" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th width="3%">&nbsp;</th> -->
			<th width="10%">Body Part</th>
			<th width="7%">Periscope Value</th>
			<th width="10%">Pain Condition</th>
			<th width="7%">Reading Interval</th>
			<th width="7%">Time</th>
		</tr>
	</thead>
	<tbody>
	
		<%int i=0;
		for(OtPostAnaesthisiaPainManagement painGrid:painGridList){
		int otBookingId=painGrid.getOtPostAnaesthisiaProcedure().getId();
		int hospitalId=painGrid.getHospital().getId();
		String bodyPart=painGrid.getPartName();
		int periscopeValue=painGrid.getPeriscopeValue();
		String periscopeName=painGrid.getPeriscopeName();
		int painId=painGrid.getId();
		int interval=painGrid.getPeriod();
		String time=painGrid.getTimeOfUpdate();
		%>
		<tr>
		<%-- <td width="3"> <input type="radio" value="<%=painGrid %>" 
				id="radioId<%=i%>" name="painId" 
				onclick="populatebloodBankQuantity(this.value);" />
		</td> --%>
		<td width="10%"><%-- <input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> --%>
				<input type="hidden" value="<%=painId %>" 
				id="painId<%=i%>" name="painId">
				<input
				type="hidden" value="<%=otBookingId%>" name="otBookingId<%=i%>"
				id="otBookingId<%=i%>" tabindex=1 /> 
				<input
				type="hidden" value="<%=hospitalId%>" name="hospitalId<%=i%>"
				id="hospitalId<%=i%>" tabindex=1 /> 
				<input
				type="text" value="<%=bodyPart%>" name="bodyPart<%=i%>"
				id="bodyPart<%=i%>" tabindex=1 readonly="readonly" /> 
				
				
				  </td>
				<td><input type="text" value="<%=periscopeValue%>" id="periscopeValue<%=i%>" name="periscopeValue<%=i%>" readonly="readonly"/></td>
				
				<td><input type="text" value="<%=periscopeName%>" id="periscopeName<%=i%>" name="periscopeName<%=i%>" readonly="readonly"/></td> 
				
				<td><input type="text" value="<%=interval%>" id="interval<%=i%>" name="interval<%=i%>" readonly="readonly"/></td>
				
				<td><input type="text" value="<%=time%>" id="time<%=i%>" name="time<%=i%>" readonly="readonly"/></td>   
		</tr>
			
			<%
			++i;
		}%>
		</tbody>
</table>
<div class="clear"></div>
<div class="paddingTop5"></div>

<input type="button" name="b" value="Go Back" class="button"	onClick="window.close();" />
		<% 
	}else{
			%>
		
		No Record Found
<% }%>	

</div>
</div>
</form>