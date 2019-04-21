<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasSample"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/opd.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>';
	</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	MasHospital masHospital = null;
	String currentDate = (String) utilMap.get("currentDate");
	String message = "";
	String patientType="";
	int currentLabId = 0;
	int userId=0;
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message= (String)map.get("message");
	}
	if(map.get("patientType") != null){
		patientType= (String)map.get("patientType");
	}
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<InvestigationTrackerUtil> trackerList=new ArrayList<InvestigationTrackerUtil>();
	if(map.get("subChargeCodeList") != null){
		subChargeCodeList = (List<MasSubChargecode>)map.get("subChargeCodeList");
    }
	if(map.get("trackerList") != null){
		trackerList = (List<InvestigationTrackerUtil>)map.get("trackerList");
    }
	System.out.println("subChargeCodeList jsp "+subChargeCodeList.size());
	 String fromDate="",toDate="";
	 if(map.get("fromDate") !=null){
		 fromDate=(String)map.get("fromDate");
		}
		if(map.get("toDate") !=null){
			toDate = (String)map.get("toDate");
		}
		
		 String hinNo="";
		 if(map.get("hinNo") !=null){
			 hinNo=(String)map.get("hinNo");
			} 
			
			 String pFirstName="",barcodetext="";
			 if(map.get("pFirstName") !=null){
				 pFirstName=(String)map.get("pFirstName");
				}
			
				if(map.get("barcodetext") !=null){
					barcodetext=(String)map.get("barcodetext");
				}
				if(detailsMap.get("masHospital") != null){
					masHospital =(MasHospital)detailsMap.get("masHospital");
				}
				if(detailsMap.get("currentLabId") != null){
				currentLabId = (Integer)detailsMap.get("currentLabId");
				}
				if (detailsMap.get("userId") != null) {
					userId = (Integer) detailsMap.get("userId");
				}
				int subGroupId=0;
				if (map.get("subGroupId") != null) {
				subGroupId = (Integer) map.get("subGroupId");
				}
				System.out.println("subGroupId jsp "+subGroupId);
%>
<div class="clear"></div>
<div class="titleBg">
<h2>Lab Investigation Tracker</h2>
</div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<form name="trackerSearch" action="" method="post">
<label>Barcode Scan</label>
<input type="text" name="barcodetext" value="<%=!barcodetext.equals("")?barcodetext:"" %>" 
MAXLENGTH="25" onkeypress="return searchKeyPress(event);"/>
<label>UHID</label><input
			id="hinId" type="text" name="<%=HIN_NO %>" value="<%=!hinNo.equals("")?hinNo:"" %>" maxlength="50" validate="hinNo,metachar,no" onkeypress="return searchKeyPress(event);"/>

<label>Patient Name</label>
<input type="text"	name="<%=P_FIRST_NAME %>" value="<%=!pFirstName.equals("")?pFirstName:"" %>" 
maxlength="30" validate="pFirstName,metachar,no" onkeypress="return searchKeyPress(event);"/>

<div class="clear"></div>
<label>Mobile No</label>
<input type="text" name="<%=MOBILE_NO%>" value="" maxlength="30" onkeypress="return searchKeyPress(event);"/>
<label>Patient Type</label>
<select  name="patientType" id="patientType"
			validate="patientType,metachar,no"
			onChange=" submitProtoAjax('resultPrinting', '/hms/hms/investigation?method=showPaitentTestDetailInResultPrinting&orderNo=5')">
			<%if(patientType.equals("")){ %>
			<option value="">Select One</option>
			<option value="IP">IP</option>
			<option value="OP">OP</option>
			<%}else if(patientType.equals("IP")){ %>
			<option value="">Select One</option>
			<option selected="selected" value="IP">IP</option>
			<option value="OP">OP</option>
			<%}else{%>
			<option value="">Select One</option>
			<option value="IP">IP</option>
			<option selected="selected" value="OP">OP</option>
			<%} %>
		</select> 
<label>IP No</label>
<input id="ipNo" name="ipNo" value="" tabindex="1" type="text" onkeypress="return searchKeyPress(event);">

<div class="clear"></div>
<label>Modality</label>
<select id="subChargeCodeId"
			name="<%=SUB_CHARGECODE_ID %>">
			<option value="0">Select</option>
			<% for(MasSubChargecode subChargecode : subChargeCodeList){ %>
			<% if(subGroupId==subChargecode.getId()){%>
			<option value="<%=subChargecode.getId() %>" selected="selected"><%=subChargecode.getSubChargecodeName() %></option>
			<% }else{%>
			<option value="<%=subChargecode.getId() %>"><%=subChargecode.getSubChargecodeName() %></option>
			<%}%>
			<%}%>
</select>
<label>From Date</label>
<input type="text" class="date"
			id="fromDateId" name="<%=FROM_DATE %>" value="<%=!fromDate.equals("")?fromDate:currentDate %>"
			readonly="readonly" MAXLENGTH="30" validate="fromDate,date,yes"/> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.trackerSearch.<%=FROM_DATE%>,event)" />
<label>To Date</label>
<input type="text" id="ToDateId"
			name="<%=TO_DATE %>" value="<%=!toDate.equals("")?toDate:currentDate %>" class="date"
			readonly="readonly" validate="toDate,date,yes" MAXLENGTH="30" /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onclick="setdate('<%=currentDate %>',document.trackerSearch.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<input id="investigationTracker" name="search" value="Search" class="button" tabindex="1" type="button"
onclick="submitForm('trackerSearch','/hms/hms/lab?method=showLabInvestigationTracker');"
>
<input tabindex="1" name="Reset" value="Cancel" class="button" accesskey="r" type="reset">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="trackerForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tbody>
    <tr>
      <th>UHID</th>     
      <th>Patient Name</th>
      <th>Investgation Name</th>
      <th>Sample Collection Status</th>
      <th>Sample Validation Status</th>
      <th>Result Entry Status</th>
      <th>Result Validation Status</th>
    </tr>
    <tr>
    <%for(InvestigationTrackerUtil track:trackerList){ %>
    <tr>
      <td><%=track.getHinNo()!=null?track.getHinNo():"" %></td>
      <td><%=track.getPatientName()!=null?track.getPatientName():"" %></td>
      <td><%=track.getInvestigationName()!=null?track.getInvestigationName():"" %></td>
      <td style="text-align: center;font-weight: bold;"><%=track.getCollectionStatus()!=null?track.getCollectionStatus():"" %></td>
      <td style="text-align: center;font-weight: bold;"><%=track.getValidationStatus()!=null?track.getValidationStatus():"" %></td>
      <td style="text-align: center;font-weight: bold;"><%=track.getResultEntryStatus()!=null?track.getResultEntryStatus():"" %></td>
      <td style="text-align: center;font-weight: bold;">
      <%if(track.getResultValidationStatus()!=null && track.getResultValidationStatus().equalsIgnoreCase("Done")){ %>
      <input type="button" name="print" id="print" onclick="printResultView('<%=track.getOrderId()%>');" target="_blank" value="VIEW" class="button" accesskey="a" />
      <input type="button" name="PrintReport" id="printOut" onclick="printResult('<%=track.getOrderId()%>');" target="_blank" value="PRINT" class="button" accesskey="a" />
      <%}else{%>
      <%=track.getResultValidationStatus()!=null?track.getResultValidationStatus():"" %>
      <%}%>
      </td>
    </tr>
    <tr>
    <%}%>
  </tbody>
</table>
</form>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<%-- 
<input name="" value="Save" tabindex="1" class="button" type="button">
<input name="Reset" value="Reset" class="buttonHighlight" tabindex="" onclick="setFocus()" type="reset">
--%>
</div>

<script type="text/javascript" language="javascript">
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('investigationTracker').click();
			return false;
		}
		return true;
	}
	function printResult(orderNo){
	submitForm('trackerForm','/hms/hms/investigation?method=printResultValidationReport&parent='+orderNo);	
	}
	
	function printResultView(orderNo){
	//submitForm('trackerForm','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);
	openPopupForLabResultsNew(csrfTokenName+'='+csrfTokenValue,orderNo);
	}
</script>