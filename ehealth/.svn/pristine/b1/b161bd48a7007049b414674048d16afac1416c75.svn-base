<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *   
 * Purpose of the JSP 
 * @author  Mukesh
* Create Date: 09.06.2011
 * Revision Date:      
 * Revision By:  
 * 
--%>


<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestM"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveRequestT"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>


<%@page import="jkt.hms.masters.business.CssdTemplateInstrument"%><link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/h_style.css" />
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	

	
	
	List<CssdAutoclaveRequestM> cssdAutoclaveRequestMList = (ArrayList<CssdAutoclaveRequestM>)map.get("cssdAutoclaveRequestMList");
	List<CssdAutoclaveRequestT> cssdAutoclaveRequestTList = (ArrayList<CssdAutoclaveRequestT>)map.get("cssdAutoclaveRequestTList");
	List<CssdInstrumentMaster> cssdInstrumentMasterList = (ArrayList<CssdInstrumentMaster>)map.get("cssdInstrumentMasterList");
	
	List<CssdTemplateInstrument> cssdTemplateInstrumentList = new ArrayList<CssdTemplateInstrument>();
	if(map.get("cssdTemplateInstrumentList")!=null){
		cssdTemplateInstrumentList = (ArrayList<CssdTemplateInstrument>)map.get("cssdTemplateInstrumentList");
	}
	
%>


<!--Block Two Starts-->
<div id="testDiv">
<div class="titleBg">
<h2>Autoclave Request Details</h2>
</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>

<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th>Sr.No.</th>
		<th>Instrument Code</th>
		<th>Instrument Name</th>
		<th>Quantity</th>
		<th>Remarks</th>
	</tr>

	<%
	int i=0;
  for(CssdAutoclaveRequestT cssdAutoclaveRequestT : cssdAutoclaveRequestTList)
  { 
	  Set<CssdTemplateInstrument> cssdTemplateInstrumentSet=new HashSet<CssdTemplateInstrument>();
	  cssdTemplateInstrumentSet=cssdAutoclaveRequestT.getInstrument().getCssdTemplateInstruments();
	  String templateName="";
	  if(cssdTemplateInstrumentSet.size()>0){
		  for(CssdTemplateInstrument cssdTemplateInstrument:cssdTemplateInstrumentSet){
			  templateName=" [ "+cssdTemplateInstrument.getTemplate().getTemplateName()+" ]";
		  }
	  }
  %>
	<tr>
		<td><%=++i%></td>
		<td><%=cssdAutoclaveRequestT.getInstrument().getInstrumentCode()%></td>
		<td><%=cssdAutoclaveRequestT.getInstrument().getInstrumentName()+templateName %></td>
		<td><%=cssdAutoclaveRequestT.getQty()%></td>
		<td><%=cssdAutoclaveRequestT.getRemarks()%></td>
	</tr>
	<% } %>
</table>
</div>


</div>
<div class="Clear"></div>
