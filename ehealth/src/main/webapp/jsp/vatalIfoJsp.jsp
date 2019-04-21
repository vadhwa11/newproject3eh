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

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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

	List<IpdVitalcareDetails> ipdVitalcareDetails = new ArrayList<IpdVitalcareDetails>();
	List<IpdVitalcareDetails> ipdVitalCareDetailList=new ArrayList<IpdVitalcareDetails>();

	if(map.get("ipdVitalcareDetails") != null)
	{
		ipdVitalcareDetails=(List<IpdVitalcareDetails>)map.get("ipdVitalcareDetails");
	}
	List<IpdVitalSetup> ipdVitalSetups=new ArrayList<IpdVitalSetup>();
	{
		ipdVitalSetups=(List<IpdVitalSetup>)map.get("ipdVitalSetups");
	}
	Integer maxVitalFrequency=0;
	if(map.get("maxVitalFrequency") != null)
	{
		maxVitalFrequency=(Integer)map.get("maxVitalFrequency");
	}
	if(map.get("ipdVitalCareDetailList") != null)
	{
		ipdVitalCareDetailList=(List<IpdVitalcareDetails>)map.get("ipdVitalCareDetailList");
	}
	
%>

<%
		    int  i=1;
			int j=1;
%>

<div class="titleBg">
<h2></h2>
</div>
<div class="clear"></div>
<form name="nursingCareEntryDetail" action="" method="post">

<div class="Block">

	<h4>Patient Vital Details</h4>
	<div class="clear"></div>
	<div class="paddingTop15"></div>
<div class="clear"></div>

	<div class="clear"></div>
<div class="paddingTop25"></div>

<div class="clear"></div>



<table class="cmntable">
<tr>
<th>
Vital
</th>
<!-- <th>Time</th> -->
<%
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
</tr>

<%

		Iterator iterator=ipdVitalSetups.iterator();
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
			
		%>
	
					<td>  
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" disabled="disabled" id="vitalNameCount<%=i%>" />
					<input type="text" size="3"  class="small" name="bp1<%=i%>" class="small" value="<%=bp1 %>" id="bp1<%=i%>" maxlength="3" disabled="disabled">
							mm
							<input type="text" size="3" class="small"  class="small" name="bp2<%=i%>" value="<%=bp2 %>" id="bp2<%=i%>" maxlength="3" disabled="disabled">
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small" disabled="disabled"   value="<%=ipdCareDetail.getCareTime()!=null?ipdCareDetail.getCareTime():"-"%>" MAXLENGTH="5"  /></td>
	
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
					<input type="text" name="vitalName<%=i%>" validate="Temperature,float,no" class="small"    id="vitalName<%=i%>" /><sup>°</sup>F
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pulse"))
		{
		%>
					<td>  
					<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Pulse,float,no" class="small"    id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>"  validate="Time,string,no" id="vitaltime<%=i%>" class="small"  value="<%=time%>" MAXLENGTH="5"  /></td>
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Respiration"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Respiration,float,no" class="small"   id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	
	<%} %>
	
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Bowl"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Bowl,float,no" class="small"   id="vitalName<%=i%>" />/min
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
	
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Girth"))
		{
		%>
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Girth,float,no" class="small"   id="vitalName<%=i%>" />/cm
			         <br/>
	        		 <input type="text" validate="Time,string,no"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
		<%} %>
	

	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Blood Sugar"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Blood Sugar,float,no" class="small"    id="vitalName<%=i%>" />/mg%
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
		<%} %>
		
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Insulin"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Insulin,float,no" class="small"   id="vitalName<%=i%>" />/I.U.
			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("Pain"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"    value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<select validate="Pain,metachar,no" name="vitalName<%=i%>" class="small" id="vitalName<%=i%>"  >
			         <option value="0">Select</option>
			         <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>			         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" validate="Time,string,no" id="vitaltime<%=i%>" class="small"   value="<%=time%>" MAXLENGTH="5"  /></td>
		
	<%} %>
	
	<%if(ipdVitalSetup.getVitalName().equalsIgnoreCase("bp"))
		{
		%>
	
					<td>  
										<input type="hidden"  name="ipdvitaldetailId<%=i%>"   value="<%=careHeader.getId()%>" id="ipdvitaldetailId<%=i%>" /> 
					<input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" size="3" validate="BP,int,no" class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" >
							mm
							<input type="text" size="3" class="small" validate="BP,int,no" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" >
							 hg		         <br/>
	        		 <input type="text"  name="vitaltime<%=i%>" id="vitaltime<%=i%>" class="small"    value="<%=time%>" MAXLENGTH="5"  /></td>
	
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small" validate="Temperature,float,no"   id="vitalName<%=i%>" /><sup>°</sup>F
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>" id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" class="small" validate="Pulse,float,no"    id="vitalName<%=i%>" />/min
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Respiration,float,no"  class="small"   id="vitalName<%=i%>" />/min
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Bowl,float,no"  class="small"   id="vitalName<%=i%>" />/min
					
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Girth,float,no"  class="small"   id="vitalName<%=i%>" />/cm
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Blood Sugar,float,no" class="small"   id="vitalName<%=i%>" />/mg%
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					<input type="text" name="vitalName<%=i%>" validate="Insulin,float,no" class="small"   id="vitalName<%=i%>" />/I.U.
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
					
					<td>  <input type="hidden" name="vitalNameCount<%=i%>" class="small"   value="<%=j %>"  id="vitalNameCount<%=i%>" />
					
			         <br/>
			         <select validate="Pain,metachar,no" name="vitalName<%=i%>" id="vitalName<%=i%>" class="small" >
			         <option value="0">Select</option>
							  <%for(int k=1;k<=10;k++){ %>
		
			         <option value="P1">P<%=k %></option>
			         <%} %>
			         </select>
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
			         
			         <input type="text" size="3" validate="BP,int,no" class="small" name="bp1<%=i%>" id="bp1<%=i%>" maxlength="3" >
							mm
							<input type="text" size="3" validate="BP,int,no" class="small" name="bp2<%=i%>" id="bp2<%=i%>" maxlength="3" >
							 hg
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
		</tr>
		<%i++;}
		        	  }%>
		

</table>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>