<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp  
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.OpdSurgeryDetail"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>

<%@page import="jkt.hms.masters.business.DgOrderdt"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<%
	Map map = new HashMap();
	int itemId=0;
	String qtyRequested=""; 
	int rowVal=0;
	int issuedItemId=0;
	int issueId=0;
	int detailId=0;
	String issueNo ="";
	List<MasStoreBrand> masStoreBrandList= new ArrayList<MasStoreBrand>();
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<DgResultEntryDetail> resultEntryDetailList= new ArrayList<DgResultEntryDetail>();
	if(map.get("resultEntryDetailList")!=null){
		resultEntryDetailList = (List<DgResultEntryDetail>) map.get("resultEntryDetailList");
	}
	List dgOrderHList= new ArrayList();
	if(map.get("dgOrderHList")!=null){
		dgOrderHList = (List) map.get("dgOrderHList");
	}
	String patientStatus="";
	if(map.get("patientStatus")!=null){
		patientStatus = (String) map.get("patientStatus");
	}
	
	String date="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<div class="titleBg">
<h2>Investigation Details</h2>
</div>
<title>Investigation Details</title>
<form name="investgationForm" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(dgOrderHList.size()>0){	
		  
		  try{
			   DgOrderhd dgOrderHeader=(DgOrderhd)dgOrderHList.get(0);
			  
				String patientName="";
				if(dgOrderHeader.getHin().getPFirstName()!= null){
					patientName=dgOrderHeader.getHin().getPFirstName();
				}
				if(dgOrderHeader.getHin().getPMiddleName()!= null){
					patientName=patientName+" "+dgOrderHeader.getHin().getPMiddleName();
				}
				if(dgOrderHeader.getHin().getPLastName()!= null){
					patientName=patientName+" "+dgOrderHeader.getHin().getPLastName();
				}
				
					
				
				 
		  
	%>
<div class="clear"></div>
<div class="Block">
<label>Patient Name</label>
<input value="<%=patientName%>" readonly="readonly"/>
<label>Patient Status</label><input value="<%=patientStatus%>" readonly="readonly"/><div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Height10"></div>
<table class="tableHolderPopup"	id="indentDetails" class="cmntable">
	<thead>
		<tr>
			<th>Investigation</th>
			<th>Result</th>
			<th>Result Date</th>
		</tr>
	</thead>
	<tbody>
		<%if(resultEntryDetailList !=null && resultEntryDetailList.size() >0){
			for(DgResultEntryDetail dgResultEntryDetail:resultEntryDetailList)
			{
 		 %>

		<tr>
			<td><input type="text" readonly="readonly"
				value="<%=dgResultEntryDetail.getInvestigation().getInvestigationName() %>" />
			</td>
			<td><input type="text" readonly="readonly" name="result"
				value="<%=dgResultEntryDetail.getResult()%>" /></td>
			<td><input type="text" readonly="readonly" name="resultDate"
				value="<%=HMSUtil.changeDateToddMMyyyy(dgResultEntryDetail.getResultEntry().getResultDate())%>" />
			</td>
			<tr/>
			<%}
		}else if(dgOrderHList !=null && dgOrderHList.size() >0){ 
			DgOrderhd dgOrderhd= new DgOrderhd();
				dgOrderhd = (DgOrderhd) dgOrderHList.get(0);
				Set<DgOrderdt> dgOrderdtSet = new HashSet<DgOrderdt>();
				dgOrderdtSet = dgOrderhd.getDgOrderdts();	
				for(DgOrderdt dgOrderdt :dgOrderdtSet)
				{
		%>
		<tr>
			<td><input type="text" readonly="readonly"	value="<%=dgOrderdt.getChargeCode().getChargeCodeName() %>" /></td>
			<td><input type="text" readonly="readonly" name="result" value="" /></td>
			<td><input type="text" readonly="readonly" name="resultDate" value="" />
			</td>
		</tr>
		<%}} }catch(Exception w){w.printStackTrace();}%>
	</tbody>
</table>
<div id="edited"></div>

<%}else{ %>
<h4><span>Records not Found</span></h4>
<div class="clear"></div>
<%} %> <input type="button" name="cancel" id="addbutton" value="Close"
	class="button" onclick="cancelForm();" accesskey="a" tabindex=1 /></form>

