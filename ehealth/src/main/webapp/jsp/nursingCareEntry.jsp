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

<%@page import="net.sf.jasperreports.engine.util.MaxFontSizeFinder"%>
<%@page import="jkt.hms.masters.business.IpdVitalcareHeader"%>
<%@page import="jkt.hms.masters.business.IpdVitalcareDetails"%>
<%@page import="jkt.hms.masters.business.IpdVitalSetup"%>
<%@page import="jkt.hms.masters.business.IpdCareHeader"%>
<%@page import="jkt.hms.masters.business.IpdCareDetails"%>
<%@page import="jkt.hms.masters.business.Ipdcaredetail"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>


<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="jkt.hms.masters.business.NursingcareSetup"%>
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
	List nursingCareList = new ArrayList();
	try {
		if(map.get("nursingCareList") != null)
		{
		    nursingCareList=(List)map.get("nursingCareList");
		    session.setAttribute("nursingCareList",nursingCareList);
		}
		else{
			nursingCareList=(List) session.getAttribute("nursingCareList");
		}
	} catch (Exception exp) {
		exp.printStackTrace();
	}
	if(map.get("maxNursingFrequency") != null)
	{
		maxNursingFrequency=(Integer)map.get("maxNursingFrequency");
	}
	List<IpdVitalSetup> ipdVitalSetups = new ArrayList<IpdVitalSetup>();
	List<IpdVitalcareDetails> ipdVitalcareDetails = new ArrayList<IpdVitalcareDetails>();
	if(map.get("ipdVitalSetups") != null)
	{
		ipdVitalSetups=(List<IpdVitalSetup>)map.get("ipdVitalSetups");
	}
	
	if(map.get("ipdVitalcareDetails") != null)
	{
		ipdVitalcareDetails=(List<IpdVitalcareDetails>)map.get("ipdVitalcareDetails");
	}
	
	Integer maxVitalFrequency=0;
	if(map.get("maxVitalFrequency") != null)
	{
		maxVitalFrequency=(Integer)map.get("maxVitalFrequency");
	}
	
	
	
	
	List showList=new ArrayList();
	showList=(List)map.get("showList");
	List<IpdCareDetails> careDetails=new ArrayList<IpdCareDetails>();
	 if(map.get("ipdCareDetails") != null)
	{
		 careDetails=(List<IpdCareDetails>)map.get("ipdCareDetails");
	} 
	Inpatient inpatient=(Inpatient)map.get("inpatient");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	Patient patient = new Patient();
	String patientName ="-";
	String consultantName = "-";
	String currentAge = "";
	String gender="-";
	String pCategory="";
	String materialStatus="";
	String admittedBy="-";
	String refferedBy="-";
	String address="";
	
	if(inpatient!=null){
		patient = inpatient.getHin();
		
		patientName=patient.getPFirstName()+" "+(patient.getPMiddleName()!=null?patient.getPMiddleName():"")+" "+(patient.getPLastName()!=null?patient.getPLastName():"");
		consultantName=inpatient.getDoctor().getRank()!=null?inpatient.getDoctor().getRank().getRankName():""+" "+ inpatient.getDoctor().getFirstName()+" "+(inpatient.getDoctor().getMiddleName()!=null?inpatient.getDoctor().getMiddleName():"")+" "+(inpatient.getDoctor().getLastName()!=null?inpatient.getDoctor().getLastName():"");	
		
		if(inpatient.getDoctor()!=null)
		{
			consultantName=inpatient.getDoctor().getFirstName();
			if(inpatient.getDoctor().getMiddleName()!=null)
			{
				consultantName +=" "+inpatient.getDoctor().getMiddleName();
			}
			if(inpatient.getDoctor().getLastName()!=null)
			{
				consultantName +=" "+inpatient.getDoctor().getLastName();
			}
		}
		
		if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getReferredDoctor()!=null)
		{
			admittedBy=inpatient.getOpdPatientDetails().getReferredDoctor().getFirstName();
			if(inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName()!=null)
			{
				admittedBy +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getMiddleName();
			}
			if(inpatient.getOpdPatientDetails().getReferredDoctor().getLastName()!=null)
			{
				admittedBy +=" "+inpatient.getOpdPatientDetails().getReferredDoctor().getLastName();
			}
		}
		if(inpatient.getOpdPatientDetails()!=null && inpatient.getOpdPatientDetails().getEmployee()!=null)
		{
			admittedBy=inpatient.getOpdPatientDetails().getEmployee().getFirstName();
			if(inpatient.getOpdPatientDetails().getEmployee().getMiddleName()!=null)
			{
				admittedBy +=" "+inpatient.getOpdPatientDetails().getEmployee().getMiddleName();
			}
			if(inpatient.getOpdPatientDetails().getEmployee().getLastName()!=null)
			{
				admittedBy +=" "+inpatient.getOpdPatientDetails().getEmployee().getLastName();
			}
		}
		String age = "";
		
		if(inpatient.getHin().getSex()!=null)
		{
			gender=inpatient.getHin().getSex().getAdministrativeSexName();
		}		
		
		if(inpatient.getHin().getMaritalStatus()!=null)
		{
			materialStatus=inpatient.getHin().getMaritalStatus().getMaritalStatusName();
		}else
		{
			materialStatus="-";
		}
		
		
		
		if(inpatient.getHin().getPatientType()!=null){
			pCategory = inpatient.getHin().getPatientType().getPatientTypeName();
		}
		else
		{
			pCategory="-";
		}
		
		

	    if(patient.getAge()!=null)
			age = patient.getAge();
		try{
			if(!age.equals(""))
			currentAge = HMSUtil.calculateAgeForADT(age,patient.getRegDate());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		session.setAttribute("inpatient",inpatient);
	}
%>

<div class="titleBg">
<h2>Nursing Care Entry</h2>
</div>
<div class="clear"></div>
<form name="nursingCareEntryDetail" action="" method="post">
<input type="hidden" name="<%=RequestConstants.INPATIENT_ID%>" value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
 <input type="hidden"  name="adNo" value="<%=inpatient.getAdNo()%>"  validate="adNo,metachar,no"/>
 <input type="hidden"  name="hinId" value="<%=inpatient.getHin().getId()%>" validate="hinId,int,no"/>
<div class="Block">


<div class="paddingTop15"></div>
<div class="clear"></div>
	<h4>patient Details</h4>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
<div class="clear"></div>
<%@include file="PatientDetails.jsp" %>
<div class="clear"></div>

<%-- <div class="Block"><label class="auto">Select Care</label>
<select	name="cares"onchange="submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailJsp')">
	<option value="0">Select</option>
	<%

				Iterator itr=nursingCareList.iterator();
			    while(itr.hasNext()){
			    	MasNursingCare masNursingCare= (MasNursingCare) itr.next();
			    	int masNursingId=masNursingCare.getId();
			    	if(nursingId==masNursingId){

			%>
	<option value=<%=masNursingCare.getId()%> selected><%=masNursingCare.getNursingName()%></option>

	<% } else {  %>
	<option value=<%=masNursingCare.getId()%>><%=masNursingCare.getNursingName()%></option>
	<% } %>

	<%
			  }
			%>
</select> <label class="auto">Date</label>
<div id="time"><label class="valueAuto"> <%=date%></label></div>
<label class="auto">Time of Care(HH:mm)</label> <input type="text"
	id="caretime" name="caretime" value="<%=timeInHHmm %>" MAXLENGTH="5" />
<!-- <div id="time" style="
		float: left; font-size: 13px; background-image:url(/hms/jsp/images/tablehead.gif);
		height: 25px; font-weight: bold;  text-align:center; color: #000000;
		width:80px; font-size: 13px; ">
	    <input type="text" name="caretime" value="<%=timeInHHmm %>"   MAXLENGTH="5"/>
        </div>
         --> <!-- <input type="hidden" name="caretime" value="<%=timeInHHmm %>"  onblur="if(checkTimeFormat()){submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailJsp');}" MAXLENGTH="5"/> -->
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="clear"></div>
</div> --%>

<div class="clear"></div>
<div class="paddingTop25"></div>

<div class="clear"></div>
	<h4>Nursing Care Entry</h4>
	<div class="clear"></div>
<div class="paddingTop25"></div>

<div class="clear"></div>
<div id="test">

<label>Date</label>
<input class="date" name="caredate" id="caredate" value="<%=date2+"/"+month+"/"+year%>"/><img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,yes" id="imgId" onclick="javascript:setdate('28/03/2015',document.nursingCareEntryDetail.caredate,event)"  > 

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<%
		    int  i=1;
			int j=1;
%>
<table class="cmntable">
<tr>
<th>
	Nursing care/ Procedure
</th>
<!-- <th>Time</th> -->
<%
while(j<=maxNursingFrequency)
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
<th>
Status
</th>
</tr>

<%

			String st="";
			Iterator iterator=showList.iterator();
		          while(iterator.hasNext())
		           {
		        	  j=1;
		        	  NursingcareSetup nursingcareSetup= (NursingcareSetup) iterator.next();
		        	  List<IpdCareDetails> localCareDetails=new ArrayList<IpdCareDetails>();
		        	  localCareDetails=HMSUtil.getIpdCareDetails(careDetails, nursingcareSetup.getNursing().getId());
		        	  int frequency=nursingcareSetup.getFrequency().getFrequencyCount();
		        	  %>
		        	  <tr>
		        	  <%
		        	  if(localCareDetails.size()>0)
		        	  {
		        		  IpdCareHeader careHeader=null;
					%>
					
					<td>
			<input type="hidden" name="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" id="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" value="<%=nursingcareSetup.getId()%>" validate="careTypeId,int,no"/>
			<%=nursingcareSetup.getNursing().getNursingName()%>
			</td>
					<%
					for(IpdCareDetails ipdCareDetail:localCareDetails)
						{
						careHeader=ipdCareDetail.getCareHeader();
						%>
						<td>
						<input type="checkbox" class="radiogrid" name="care<%=i%>" value="<%=j %>" disabled="disabled"  checked="true" DISABLED  id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=ipdCareDetail.getCareTime()%>" MAXLENGTH="5"  />
						</td>
						<%
						j++;
						} %>
						<%
						boolean isFirstLoop=true;
while(j<=maxNursingFrequency)
{
	if(isFirstLoop && j<=nursingcareSetup.getFrequency().getFrequencyCount())
	{
		isFirstLoop=false;
	%>
					<td> 
					<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdcaredetailId<%=i%>" /> 
					<input type="checkbox" class="radiogrid" name="care<%=i%>"  
					<%if(nursingcareSetup.getStopCare().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					 value="<%=j %>" id="care<%=i%>" />
					
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>" disabled="disabled"  value="<%=j%>" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
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
			<input type="hidden" name="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" id="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" value="<%=nursingcareSetup.getId()%>" />
			<%=nursingcareSetup.getNursing().getNursingName()%>
			</td>
			<%
while(j<=nursingcareSetup.getFrequency().getFrequencyCount())
{
	if(j==1)
	{
	%>
					<td>
					<%if(nursingcareSetup.getStopCare().equalsIgnoreCase("y")){ %>
					  <input type="checkbox" class="radiogrid" name="care<%=i%>"  disabled="disabled" value="<%=j %>" id="care<%=i%>" />
					<%}else{%>
					  <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="<%=j %>" id="care<%=i%>" />
					<%}%>
					
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="checkbox" class="radiogrid" name="care<%=i%>" disabled="disabled"   value="<%=j%>" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
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
	
	
				        		   <td>
				        		     <%if(nursingcareSetup.getStopCare().equalsIgnoreCase("y")){ %>
					            <input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" disabled="disabled"/>
					              <%}else{%>
					              <input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" />
					              <%}%>
				        		   </td>				        		   
				        		  
			
			<%
			}%>
			 			
	                               <td>
				        		   <%if(nursingcareSetup.getStopCare().equalsIgnoreCase("y")){ %>
					               Procedure Stopped
					              <%}else{%>
					              <%}%>
				        		   </td>		  
		</tr>
		<%i++;} %>
		

<%-- <%

			String st="";
			Iterator iterator=showList.iterator();
		    /* int  i=1; */
		          while(iterator.hasNext())
		           {
		        	  NursingcareSetup nursingcareSetup= (NursingcareSetup) iterator.next();
		        	  Set ipdcaredetail=nursingcareSetup.getIpdcaredetails();
		        	  int frequency=nursingcareSetup.getFrequency().getId();
		%>
<tr>
<td>
<input type="hidden" name="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" id="<%=RequestConstants.CARE_TYPE_ID%><%=i%>" value="<%=nursingcareSetup.getId()%>" />
<%=nursingcareSetup.getNursing().getNursingName()%>
</td>
<td>
<input type="text"  name="caretime<%=i%>" id="caretime<%=i%>"  value="<%=time%>" MAXLENGTH="5"  />
</td>
			<%
			     Iterator itr1=ipdcaredetail.iterator();
			     if(ipdcaredetail.size() > 0){
	        	  while(itr1.hasNext())
	        	  {
	        		  String bool="false";
	        		  int check=0;
	        		  String flag="off";
	        		  Ipdcaredetail ipdObj=(Ipdcaredetail)itr1.next();
	        		  //out.println('care id is == '+ipdObj.getId());
	        		  Date date1=null; 
	        		  if(ipdObj!=null)
	        		  {
	        		  int ipdcaredetailId=ipdObj.getId();
	        		  date1 =ipdObj.getDateOfCare();
	        		  }
	        		  String dateInString=HMSUtil.convertDateToStringWithoutTime(date1);
	        			utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	        			String currentDate = (String)utilMap.get("currentDate");
	        		  if(ipdObj!=null && dateInString.equals(currentDate))
	        		  {
	        			  bool="true";
	        			  String care1=ipdObj.getCare1();
	        			  String care2=ipdObj.getCare2();
	        			  String remarks=ipdObj.getRemarks();
	        			  if(ipdObj.getCare1()!= null)
	        			  {
	        				  check=1;
	        	   %>
	        	   <td>
	        	   
	        	   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="one" checked="true" DISABLED  id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        	   
	        	   </td>
	        		<%
	        		   }else{
	        			   if(check<frequency && flag.equals("off"))
	        			   {
	        				   check=1;
	        				   flag="on";
	        		%>
	        		<td>
	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		
	        		<input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare1Time()%>" MAXLENGTH="5"  />
	        		</td>
	        		<%
	        			   }else
	        			   {
	        		%>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<%
	        			   }
	        		    }
	        		    if( ipdObj.getCare2() != null)
	        		    {
	        		    	check=2;
	        	  %>
	        	  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="two" checked="true" DISABLED  value="" id="care<%=i%>" />
	        	   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        	  </td>
	        	  <%
	        		    }else
	        		    {
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=2;
	        		    		flag="on";
	        		%>
	        		<td>
	        			        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		
	        		<input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare2Time()%>" MAXLENGTH="5"  /></td>
	        		<%
	        		    	}else
	        		    	{
	        		    		
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		 </td>
	        		 <%
	        		    	}
	        		    }
	        		   
	        		    
	        		     if(ipdObj.getCare3()!= null)
	        		    {
	        		    	check=3;
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="three" checked="true" DISABLED   value="" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    }
	        		    else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=3;
	        		    		flag="on";
	        		 %>
	        		 <td>
	        		 	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		 <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare3Time()%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}else{
	        		  %>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="three" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare4() != null)
	        		    {
	        		    	check=4;
	        		  %>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" checked="true" DISABLED value="" id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    }else{
	        		    	if(check<frequency  && flag.equals("off"))
	        		    	{
	        		    		check=4;
	        		    		flag="on";
	        		 %>
	        		 <td>
	        		 	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		 
	        		 <input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare4Time()%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}else{
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare5() != null)
	        		    {
	        		    	check=5;
	        		 %>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" checked="true" DISABLED value="" id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>	        		 <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=5;
	        		    		flag="on";
	        		  %>
	        		  <td>
	        		  	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		  
	        		  <input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare5Time()%>" MAXLENGTH="5"  /></td>
	        		  <%
	        		    	}else{
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare6() != null)
	        		    {
	        		    	check=6;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=6;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		   	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		   
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare6Time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare7() != null)
	        		    {
	        		    	check=7;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=7;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		   	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare7Time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td>
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare8() != null)
	        		    {
	        		    	check=8;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off") )
	        		    	{
	        		    		check=8;
	        		    		flag="on";
	        		   %>
	        		   <td>
	        		   	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare8Time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare9() != null)
	        		    {
	        		    	check=9;
	        		   %>
	        		   <td>
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=9;
	        		    		flag="on";
	        		   %>
	        		   <td>	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		   <input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare9Time()%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare10() != null)
	        		    {
	        		    	check=10;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=10;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare10Time()%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare11() != null)
	        		    {
	        		    	check=11;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=11;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare11Time()%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }
	        		    if(ipdObj.getCare12() != null)
	        		    {
	        		    	check=12;
	        		   %>
	        		   <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" checked="true" DISABLED value="" id="care<%=i%>" />
	        		   <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		   <%
	        		    }else{
	        		    	if(check<frequency && flag.equals("off"))
	        		    	{
	        		    		check=12;
	        		    		flag="on";
	        		    %>
	        		    <td>
	        		    	        		<input type="hidden"  name="ipdcaredetailId<%=i%>"   value="<%=ipdObj.getId()%>" id="ipdcaredetailId<%=i%>" />
	        		    <input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"  value="<%=ipdObj.getCare12Time()%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}else{
	        		    %>
	        		    <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		    <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		    <%
	        		    	}
	        		    }if(remarks != null)
	        		    {
	        		   %>
	        		   <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="<%=remarks%>" size="20"  style=" border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }else{
	        		   %>
	        		   <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }
	        		    %>
	        		    data_arr[<%= i%>][18] = '<input type="hidden"  name="nursingId<%=i%>" value="<%=nursingcareSetup.getId()%>"  />'
	        		    data_arr[<%= i%>][19] = '<input type="hidden"  name="adNo<%=i%>" value="<%=nursingcareSetup.getAdNo()%>"  />'
	        		    data_arr[<%= i%>][20] = '<input type="hidden"  name="hinId<%=i%>" value="<%=patient.getId()%>"  />'
	        		    data_arr[<%= i%>][21] = '<input type="hidden"  name="ipdcaredetailId<%=i%>" value="<%=ipdObj.getId()%>"  />'

	        		    <%
	        		    break;
	        		  }
	        		  if(bool.equals("false"))
	        		  {
	        	%>
	        		<td>  <input type="checkbox" class="radiogrid" name="care<%=i%>" i   value="one" id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<td> <input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  />
	        		</td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" size="20" style=" border: 1px solid #7f9db7;" value="" MAXLENGTH="50" /></td>
	        	<%
	        		  }
	        	    }
			     }else{
			    %>
			         <td>  <input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="care<%=i%>" />
			         <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td> <input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="care<%=i%>" />
	        		<br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="care<%=i%>" />
	        		  <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="twelve" DISABLED id="care<%=i%>" />
	        		 <br/>
	        		 <input type="text"  name="caretime<%=i%>" id="caretime<%=i%>" class="small" disabled="disabled"  value="<%=time%>" MAXLENGTH="5"  /></td>
	        		 <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" style="border: 1px solid #7f9db7;" size="20" value="" MAXLENGTH="50" /></td>
				<%
			     }
				%>

		<%

			i++;
		%>
		</tr>
		<%
		  }
		%> --%>
		















<%-- <tr>

		
		           <td><input type="radio" class="radiogrid" name="parent" value="" id="parent" /></td>

			        <td>&nbsp;</td>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="once" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="twice" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="thrice" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="4 times" /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="5 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="6 times" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="7 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="8 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="9 times" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="10 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="11 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="twelve" DISABLED id="12 times" /></td>
	        		 <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" style="width: 170px; border: 1px solid #7f9db7;" value="" MAXLENGTH="50" />
	        		
</tr>
<%i++; %>
<tr>

		
		           <td><input type="radio" class="radiogrid" name="parent" value="" id="parent" /></td>

			        <td>&nbsp;</td>
					<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="one" id="once" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="two" DISABLED id="twice" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>"   value="three" DISABLED id="thrice" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="four" DISABLED id="4 times" /></td>
	        		  <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="five" DISABLED id="5 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="six" DISABLED  id="6 times" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="seven" DISABLED id="7 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eight" DISABLED id="8 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="nine" DISABLED id="9 times" /></td>
	        		<td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="ten" DISABLED id="10 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>" value="eleven" DISABLED id="11 times" /></td>
	        		 <td><input type="checkbox" class="radiogrid" name="care<%=i%>"  value="twelve" DISABLED id="12 times" /></td>
	        		 <td><input type="text"  name="careremarks<%=i%>" id="careremarks<%=i%>" style="width: 170px; border: 1px solid #7f9db7;" value="" MAXLENGTH="50" />
	        		
</tr>
<%i++; %> --%>

</table>
</div>


<input type="hidden" name="counter" id="counter" value="<%=--i %>" />
 
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop25"></div>
 
<div class="clear"></div>


<%
		      i=1;
			 j=1;
			 if(maxVitalFrequency>0){
%>
<table class="cmntable">
<tr>
<th>
Vital
</th>
<!-- <th>Time</th> -->
<%System.out.println("maxVitalFrequency "+maxVitalFrequency);
while(j<=maxVitalFrequency)
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
<th>
Status
</th>
</tr>

<%

			 iterator=ipdVitalSetups.iterator();
		          while(iterator.hasNext())
		           {
		        	  j=1;
		        	  IpdVitalSetup ipdVitalSetup= (IpdVitalSetup) iterator.next();
		        	  List<IpdVitalcareDetails> localVitalDetails=new ArrayList<IpdVitalcareDetails>();
		        	  localVitalDetails=HMSUtil.getIpdVitalDetails(ipdVitalcareDetails, ipdVitalSetup.getVitalName());
		        	  int frequency=ipdVitalSetup.getFrequency().getFrequencyCount();
		        	  %>
		        	  <%if(ipdVitalSetup.getVitalName()!=null && !ipdVitalSetup.getVitalName().equalsIgnoreCase("") && !ipdVitalSetup.getVitalName().equalsIgnoreCase("0"))
		        		  
		        		  {
		        		  %>
		        	  <tr>
		        	  
		        	  <td>
			<input type="hidden" name="vitalSetupId<%=i%>" id="vitalSetupId<%=i%>" value="<%=ipdVitalSetup.getId()%>" />
			<%=ipdVitalSetup.getVitalName()%>
			</td>
		        	   <%
		        	   String vitalRemarks="";
		        	  if(localVitalDetails.size()>0)
		        	  {
		        		  IpdVitalcareHeader careHeader=null;
					%>
					
					
					<%
					for(IpdVitalcareDetails ipdCareDetail:localVitalDetails)
						{
						careHeader=ipdCareDetail.getVitalHeader();
						%>
						<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Temperature"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small" value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"   disabled="disabled" id="vitalName<%=i%>" /><sup>°</sup>F
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pulse"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small"  value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Respiration"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small" value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Bowl"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"  value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"  disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Girth"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small"  value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"  disabled="disabled" id="vitalName<%=i%>" />/cm
			         <br/>
	        		 <input type="text" name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
		<%} %>
	

	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Blood Sugar"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small" value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"   disabled="disabled" id="vitalName<%=i%>" />/mg%
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
		<%} %>
		
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Insulin"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"  value="<%=ipdCareDetail.getVitalValue()!=null?ipdCareDetail.getVitalValue():""%>"  disabled="disabled" id="vitalName<%=i%>" />/I.U.
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pain"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"    value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<select name="vitalName<%=i%>" class="small" id="vitalName<%=i%>" disabled="disabled" >
			         <option value="0">Select</option>
			         <%for(int k=1;k<=10;k++){ %>
			         
			         <%if(("P"+k).equals(ipdCareDetail.getVitalValue()))
			         {%>
			          <option value="P1" selected="selected">P<%=k %></option>
			         <%}else{ %>
			         <%} %>
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         
			         </select>			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("bp"))
		{
		String vitalValue=ipdCareDetail.getVitalValue();
		String bp1="";
		String bp2="";
		if(vitalValue !=null && vitalValue.indexOf("/")!=-1)
		{
			bp1=vitalValue.substring(0,vitalValue.indexOf("/"));
			bp2=vitalValue.substring(vitalValue.indexOf("/")+1,vitalValue.length());
		}
		String time2="";
		time2=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-";	
		%>
	
					<td>  
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" size="3"  class="small" name="bp1<%=i%>" class="small" value="<%=bp1 %>" id="bp1<%=i%>" maxlength="3" disabled="disabled">
							mm
							<input type="text" size="3" class="small"  class="small" name="bp2<%=i%>" value="<%=bp2 %>" id="bp2<%=i%>" maxlength="3" disabled="disabled">
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time2%>" MAXLENGTH="5"  /></td>
	
	<%} %>
						<%
						j++;
						} %>
						<%
						boolean isFirstLoop=true;
while(j<=ipdVitalSetup.getFrequency().getFrequencyCount())
{
	if(isFirstLoop && j<=ipdVitalSetup.getFrequency().getFrequencyCount())
	{
		isFirstLoop=false;
	%>			
	        		 
	        		 <%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Temperature"))
		{
		%>
					<td>
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Temperature,float,no" class="small"    id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					  /><sup>°</sup>F
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pulse"))
		{
		%>
					<td>
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Pulse,float,no" class="small"    id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>/>/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  validate="Time,string,no" id="vitaltime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Respiration"))
		{
		%>
	
					<td>
				     <input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Respiration,float,no" class="small"   id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					/>/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
	
	
	<%} %>
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Bowl"))
		{
		%>
	
					<td>  
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Bowl,float,no" class="small"   id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					/>/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Girth"))
		{
		%>
					<td>
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Girth,float,no" class="small"   id="vitalName<%=i%>"
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					 />/cm
			         <br/>
	        		 <input type="text" validate="Time,string,no"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
		<%} %>
	

	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Blood Sugar"))
		{
		%>
	
					<td> 
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Blood Sugar,float,no" class="small"    id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					/>/mg%
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
		<%} %>
		
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Insulin"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Insulin,float,no" class="small"   id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					/>/I.U.
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pain"))
		{
		%>
	
					<td>
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"    value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<select validate="Pain,metachar,no" name="vitalName<%=i%>" class="small" id="vitalName<%=i%>" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					 >
			         <option value="0">Select</option>
			         <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5" disabled="disabled" /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("bp"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" size="3" validate="BP,int,no" class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" 
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
					>
							mm
							<input type="text" size="3" class="small" validate="BP,int,no" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" 
							 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
						 disabled="disabled"
						  <%}else{%>
					      <%}%>
							>
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"    value="<%=time%>" MAXLENGTH="5"  disabled="disabled"/></td>
	
	<%} %>
	
	
	        		 
<%}else
	{
	%>
					<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Temperature"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small"   disabled="disabled" id="vitalName<%=i%>" /><sup>°</sup>F
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"   id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pulse"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Respiration"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Bowl"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Girth"))
		{
		%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
				    <input type="text" name="vitalName<%=i%>" class="small"   disabled="disabled" id="vitalName<%=i%>" />/cm
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
		<%} %>
	

	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Blood Sugar"))
		{
		%>
	
					<td> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/mg%
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
		<%} %>
		
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Insulin"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/I.U.
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pain"))
		{
		%>
	
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"    value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<select  name="vitalName<%=i%>" class="small" id="vitalName<%=i%>" disabled="disabled" >
			         <option value="0">Select</option>
							  <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("bp"))
		{
		%>
	
					<td>  
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" size="3"  class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" disabled="disabled">
							mm
							<input type="text" size="3" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" disabled="disabled">
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	<%} %>
	<%}
	j++;	
	} %>
	<%
	while(j<=maxVitalFrequency)
{
	
	%>
					<td>&nbsp;</td>

	<%j++;	
	} %>
		
		
		<%
		vitalRemarks=careHeader!=null?careHeader.getRemarks():"";
		        	  }else
		        	  %> 
		        	  
		        	  <%
			{
			%>
			<%-- <td>
			<input type="hidden" name="vitalSetupId<%=i%>" id="vitalSetupId<%=i%>" value="<%=ipdVitalSetup.getId()%>" />
			<%=ipdVitalSetup.getVitalName()%>
			</td> --%>
			<%
while(j<=ipdVitalSetup.getFrequency().getFrequencyCount())
{
	
	%>
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Temperature"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					 <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" class="small" validate="Temperature,float,no"   id="vitalName<%=i%>" disabled="disabled"/>
					  <%}else{%>
					  <input type="text" name="vitalName<%=i%>" class="small" validate="Temperature,float,no"   id="vitalName<%=i%>" />
					  <%}%>
					<sup>°</sup>F
			         <br/>
	        		 <input type="text"   name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" validate="Time,string,no"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" /><sup>°</sup>F
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pulse"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					 <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					  <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" class="small" validate="Pulse,float,no"    id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					<input type="text" name="vitalName<%=i%>" class="small" validate="Pulse,float,no"    id="vitalName<%=i%>" />
					 <%}%>
					/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"   id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Respiration"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					 <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					  <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" validate="Respiration,float,no"  class="small"   id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					 <input type="text" name="vitalName<%=i%>" validate="Respiration,float,no"  class="small"   id="vitalName<%=i%>" />
					 <%}%>
					/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	
	
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Bowl"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					 <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					  <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" validate="Bowl,float,no"  class="small"   id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					 <input type="text" name="vitalName<%=i%>" validate="Bowl,float,no"  class="small"   id="vitalName<%=i%>" />
					 <%}%>
					/min
					
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small"   disabled="disabled" id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Girth"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					 <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					  <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" validate="Girth,float,no"  class="small"   id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					 <input type="text" name="vitalName<%=i%>" validate="Girth,float,no"  class="small"   id="vitalName<%=i%>" />
					 <%}%>
					/cm
			         <br/>
	        		 <input type="text" validate="Time,string,no"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/cm
			         <br/>
	        		 <input type="text"   name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	

	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Blood Sugar"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					 <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					  <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" name="vitalName<%=i%>" validate="Blood Sugar,float,no" class="small"   id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					 <input type="text" name="vitalName<%=i%>" validate="Blood Sugar,float,no" class="small"   id="vitalName<%=i%>" />
					 <%}%>
					/mg%
			         <br/>
	        		 <input type="text"   name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/mg%
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
		
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Insulin"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					   <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					<input type="text" name="vitalName<%=i%>" validate="Insulin,float,no" class="small"   id="vitalName<%=i%>" disabled="disabled"/>
					 <%}else{%>
					 <input type="text" name="vitalName<%=i%>" validate="Insulin,float,no" class="small"   id="vitalName<%=i%>" />
					 <%}%>
					/I.U.
			         <br/>
	        		 <input type="text"   name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>"  class="small"   disabled="disabled" id="vitalName<%=i%>" />/I.U.
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pain"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					
			         <br/>
			          <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					   <select validate="Pain,metachar,no" name="vitalName<%=i%>" id="vitalName<%=i%>" class="small" disabled="disabled">
			         <option value="0">Select</option>
							  <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>
					 <%}else{%>
					    <select validate="Pain,metachar,no" name="vitalName<%=i%>" id="vitalName<%=i%>" class="small" >
			         <option value="0">Select</option>
							  <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>
					 <%}%>
			      
			         <br/>
	        		 <input type="text"  validate="Time,string,no"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"    value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<select  name="vitalName<%=i%>" class="small" id="vitalName<%=i%>" disabled="disabled" >
			         <option value="0">Select</option>
							  <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("bp"))
		{
		%>
	<%
	if(j==1)
	{
	%>
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					
			         <br/>
			          <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					 <input type="text" size="3" validate="BP,int,no" class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" disabled="disabled">
					 mm
					<input type="text" size="3" validate="BP,int,no" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" disabled="disabled">
					hg
					 <%}else{%>
				    <input type="text" size="3" validate="BP,int,no" class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" >
					 mm
					<input type="text" size="3" validate="BP,int,no" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" >
					hg
					 <%}%>
					 
			        
							  <br/>
	        		 <input type="text"   name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
<%}else
	{
	%>
					<td>  
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" size="3"  class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" disabled="disabled">
							mm
							<input type="text" size="3"  class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" disabled="disabled">
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=time%>" MAXLENGTH="5"  /></td>
	<%}
	%>
	
	
	<%} %>
	
	
	
	<%
	
	j++;	
	} %>
	<%
	while(j<=maxVitalFrequency)
{
	
	%>
					<td>&nbsp;</td>

	<%j++;	
	} %>
			
			<%
			}
			%>
			<%
			if(vitalRemarks != null && !vitalRemarks.equals(""))
	        		    {
	        		   %>
	        		   <td><input type="text"  name="vitalremarks<%=i%>" id="vitalremarks<%=i%>" value="<%=vitalRemarks%>" size="20"  style=" border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }else{
	        		   %>
	        		   <td><input type="text"  name="vitalremarks<%=i%>" id="vitalremarks<%=i%>" value="" size="20" style="border: 1px solid #7f9db7;" MAXLENGTH="50" /></td>
	        		   <%
	        		    }
	        		    %>
	        		    <td>
	        		     <%if(ipdVitalSetup.getStopVital().equalsIgnoreCase("y")){ %>
					               Vital Stopped
					     <%}else{%>
					     <%}%>
	        		    </td>
		</tr>
		<%i++;}
		        	  }%>
		

</table>
<%}%>
</div>


<input type="hidden" name="vitalcounter" id="vitalcounter" value="<%=--i %>" />
<input type="button" class="button" value="Submit " align="left" onClick="submitNursingCareEntryForm();" />
<input type="reset" class="button" name="reset" value="Reset" onclick="submitFormForButton('nursingCareEntryDetail','ipd?method=showNursingCareEntryJsp');"/>
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('nursingCareEntryDetail','ipd?method=showPatientListNurseJsp');"/>

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


</div>
<div class="clear"></div>
<div id="testDiv"></div>
<%-- <script>
		<% if (nursingId !=0 ) { %>
				submitProtoAjax('nursingCareEntry','/hms/hms/ipd?method=showNursingCareEntryDetailForPatientJsp&nursingId=<%=nursingCareSetupId%>');
		<% } %>
		</script> --%>

<div class="clear"></div>

<script type="text/javascript">

function submitNursingCareEntryForm()
{
	validateForNursingCareEntry(); 
	submitForm('nursingCareEntryDetail','ipd?method=submitNursingCareEntryDetails');
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
	    	 document.getElementById("caretime"+i).setAttribute("validate", "Care Time,string,yes");
	    	 }
	     else
	    	 {
	    	 document.getElementById("caretime"+i).setAttribute("validate", "Care Time,string,no");
	    	 }
	}
}
</script>
