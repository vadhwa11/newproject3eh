<%@page import="jkt.hms.masters.business.MasWasteDisposal"%>
<%@page import="java.util.Iterator"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BioWasteHandOver"%>
<%@page import="org.bouncycastle.asn1.x509.qualified.BiometricData"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasWasteContainer"%>
<%@page import="jkt.hms.masters.business.MasWasteCategory"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<BioWasteHandOver>BioWasteHandOverList=new ArrayList<BioWasteHandOver>();
	List<MasWasteContainer>wasteContainerList=new ArrayList<MasWasteContainer>();
	List<MasWasteDisposal>disposalList=new ArrayList<MasWasteDisposal>();
	if(map.get("BioWasteHandOverList")!=null){
		BioWasteHandOverList=(List<BioWasteHandOver>)map.get("BioWasteHandOverList");
	}
	if(map.get("wasteContainerList")!=null){
		wasteContainerList=(List<MasWasteContainer>)map.get("wasteContainerList");
	}
	if(map.get("disposalList")!=null){
		disposalList=(List<MasWasteDisposal>)map.get("disposalList");
	}
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	if(message!=null && !message.equals("")){
%>
<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>


<h4><%=message %></h4>
<%} %>
<div class="titleBg">
<h2>Bio Medical Waste Disposal</h2>
</div>
<div class="clear"></div>
<form name="dispDetails" method="post">
<div class="Block">

<%for(BioWasteHandOver BioWasteHandOver:BioWasteHandOverList ){%>
<input type="text" name="headerId" readonly="readonly" value="<%=BioWasteHandOver.getId() %>" />
<label>Waste Category</label>
<label class="value"><%=BioWasteHandOver.getCategory().getWasteCategoryName() %></label>
<label>Container</label>
<label class="value"><%=BioWasteHandOver.getContainer().getWasteContainerName() %></label>
<label>Colour</label>
<label class="value"><%=BioWasteHandOver.getColour() %></label>
<div class="clear"></div>
<label>Quantity</label>
<label class="value"><%=BioWasteHandOver.getQty() %></label>
<label>Department</label>
<label class="value"><%=BioWasteHandOver.getDepartmentId().getDepartmentName() %></label>
<label>Disposal</label>
<select name="dispName" id="dispId">
<option value="0">Select </option>
<%for(MasWasteDisposal disp:disposalList){ %>
<option value="<%=disp.getId()%>"><%=disp.getWasteDisposalName() %></option>
<%} %>
</select>
<%}%>
</div>
<div class="clear"></div>
<div class="clear"></div>
<input  type="button" value="save" onclick="submitForm('dispDetails','/hms/hms/ipd?method=saveDispDetails')" />
<div class="clear"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>